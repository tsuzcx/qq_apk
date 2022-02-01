package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ko;
import com.tencent.mm.f.b.a.ld;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@k
public class SnsGalleryUI
  extends SnsBaseGalleryUI
  implements y.a
{
  private int KOm = 0;
  private String Kig = "";
  private boolean fCB = false;
  private int scene = 0;
  private String userName = "";
  
  private int X(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(261586);
    int i = this.KNW.getPosition();
    int j = paramSnsInfo.getTimeLine().ContentObj.Sqr.size();
    if ((j > 1) && (i > 1) && (i <= j)) {
      i -= 1;
    }
    for (;;)
    {
      AppMethodBeat.o(261586);
      return i;
      i = 0;
    }
  }
  
  protected final void aB(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(261590);
    Object localObject1;
    if (((paramBoolean1) || (paramBoolean2)) && (this.KNT != null))
    {
      localObject1 = this.KNT;
      if ((((y)localObject1).KCH == null) || (!((y)localObject1).KCH.isShowing())) {
        break label158;
      }
    }
    label158:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject2 = this.KNW.getSelectId();
        String str = this.KNW.getSelectedMediaId();
        localObject1 = this.KNW.getSelectItem();
        Log.i("MicroMsg.SnsGalleryUI", "onTranslateEnd showTranslateMenu: %s, showOcrMenu: %s, selectLocalId: %s, mediaId: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), localObject2, str });
        localObject2 = aj.fOI().bbl((String)localObject2);
        i = X((SnsInfo)localObject2);
        this.KNT.a(this.fCB, (SnsInfo)localObject2, ((com.tencent.mm.plugin.sns.j.b)localObject1).fVT, paramBoolean1, paramBoolean2, true, i);
      }
      AppMethodBeat.o(261590);
      return;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98706);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
      if (fVN())
      {
        AppMethodBeat.o(98706);
        return true;
      }
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.KNT.KEo);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(98706);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98706);
    return bool;
  }
  
  protected final boolean fVP()
  {
    return true;
  }
  
  protected final int fVQ()
  {
    return 4;
  }
  
  protected final int fVR()
  {
    return 4;
  }
  
  public int getLayoutId()
  {
    return i.g.sns_gallery_img;
  }
  
  public final void gl(String paramString, int paramInt)
  {
    AppMethodBeat.i(98708);
    SnsInfoFlip localSnsInfoFlip;
    if (this.KNW != null) {
      if ((!Util.isNullOrNil(paramString)) && (paramInt != 3))
      {
        localSnsInfoFlip = this.KNW;
        if ((localSnsInfoFlip.KRM != null) && (localSnsInfoFlip.lxh != null)) {
          break label57;
        }
      }
    }
    for (;;)
    {
      this.KNW.yY(true);
      AppMethodBeat.o(98708);
      return;
      label57:
      paramInt = 0;
      while (paramInt >= 0)
      {
        if (localSnsInfoFlip.KRM != null) {
          for (;;)
          {
            if (paramInt >= localSnsInfoFlip.lxh.size()) {
              break label137;
            }
            com.tencent.mm.plugin.sns.j.b localb = localSnsInfoFlip.KRM.ahk(paramInt);
            if ((!Util.isNullOrNil(localb.parentId)) && (localb.parentId.equals(paramString)))
            {
              localSnsInfoFlip.lxh.remove(paramInt);
              break;
            }
            paramInt += 1;
          }
        }
        label137:
        paramInt = -1;
      }
      localSnsInfoFlip.KRM.notifyDataSetChanged();
    }
  }
  
  public final void gm(String paramString, int paramInt)
  {
    AppMethodBeat.i(98710);
    super.gm(paramString, paramInt);
    paramString = aj.fOI().bbl(paramString);
    TimeLineObject localTimeLineObject;
    ko localko;
    if (paramString != null)
    {
      com.tencent.mm.plugin.sns.k.g.Kia.Q(paramString);
      com.tencent.mm.plugin.sns.k.g.Kia.d(paramString, paramInt);
      localTimeLineObject = paramString.getTimeLine();
      if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj != null) && (!Util.isNullOrNil(localTimeLineObject.ContentObj.Sqr)))
      {
        localko = com.tencent.mm.plugin.sns.k.g.Kia.fQs();
        if (localko != null) {
          break label186;
        }
        localko = com.tencent.mm.plugin.sns.k.g.Kia.fQt();
        localko.gOy = 1L;
        localko = localko.BE(t.Qv(paramString.field_snsId)).BD(com.tencent.mm.plugin.sns.k.g.Kia.Kio.gQg);
        localko.gBe = com.tencent.mm.plugin.sns.k.g.Kia.Kio.gBe;
        localko.gmU = localTimeLineObject.ContentObj.Sqq;
        localko.gOx = localTimeLineObject.ContentObj.Sqr.size();
        com.tencent.mm.plugin.sns.k.g.Kia.KiE = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.k.g.Kia.g(paramString, paramInt);
      AppMethodBeat.o(98710);
      return;
      label186:
      if (!Util.isEqual(t.Qv(paramString.field_snsId), localko.gmO))
      {
        com.tencent.mm.plugin.sns.k.g.Kia.fQw();
        localko = com.tencent.mm.plugin.sns.k.g.Kia.fQt();
        localko.gOy = 0L;
        localko = localko.BE(t.Qv(paramString.field_snsId)).BD(com.tencent.mm.plugin.sns.k.g.Kia.Kio.gQg);
        localko.gBe = com.tencent.mm.plugin.sns.k.g.Kia.Kio.gBe;
        localko.gmU = localTimeLineObject.ContentObj.Sqq;
        localko.gOx = localTimeLineObject.ContentObj.Sqr.size();
        com.tencent.mm.plugin.sns.k.g.Kia.KiE = System.currentTimeMillis();
      }
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(98707);
    this.scene = getIntent().getIntExtra("sns_video_scene", 0);
    this.userName = getIntent().getStringExtra("sns_gallery_userName");
    int i = getIntent().getIntExtra("sns_gallery_localId", 0);
    this.fCB = getIntent().getBooleanExtra("sns_gallery_is_self", false);
    this.KOm = getIntent().getIntExtra("sns_gallery_position", 0);
    Object localObject = com.tencent.mm.plugin.sns.storage.y.bt("sns_table_", i);
    Log.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", new Object[] { localObject, Integer.valueOf(this.KOm) });
    gm((String)localObject, this.KOm);
    ak(this.fCB, 1);
    this.KNW = new SnsInfoFlip(this);
    this.KNW.setVideoScene(this.scene);
    this.KNW.setNeedScanImage(true);
    localObject = aj.fOy();
    String str = this.userName;
    localObject = (ArrayList)((ap.a)localObject).JZB.get(str);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      this.KNW.setShowTitle(true);
      this.KNW.setEnableHorLongBmpMode(false);
      this.KNW.a((List)localObject, this.userName, this.KOm, this.KNR, this);
      this.KNW.setOnDeleteAllAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98697);
          SnsGalleryUI.this.KNT.fTG();
          AppMethodBeat.o(98697);
        }
      });
      this.KNW.setOnPageSelectListener(this);
      h.aHH();
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.userName);
      if ((localObject != null) && ((int)((com.tencent.mm.contact.d)localObject).jxt > 0) && (com.tencent.mm.contact.d.rk(((ax)localObject).field_type))) {
        localObject = bp.hzi();
      }
      for (;;)
      {
        this.KNW.setFromScene((bp)localObject);
        this.KNW.setUIFromScene(getFromScene());
        this.KNW.username = this.userName;
        addView(this.KNW);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98698);
            SnsGalleryUI.this.KNT.fTG();
            AppMethodBeat.o(98698);
            return true;
          }
        });
        addIconOptionMenu(0, i.i.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98699);
            Object localObject = SnsGalleryUI.this.KNW.getSelectId();
            String str = SnsGalleryUI.this.KNW.getSelectedMediaId();
            paramAnonymousMenuItem = SnsGalleryUI.this.KNW.getSelectItem();
            Log.d("MicroMsg.SnsGalleryUI", "click selectLocalId: %s, mediaId: %s, showTranslate: %s, showOcr: %s", new Object[] { localObject, str, Boolean.valueOf(SnsGalleryUI.this.KNW.KDy), Boolean.valueOf(SnsGalleryUI.this.KNW.KDz) });
            localObject = aj.fOI().bbl((String)localObject);
            if ((localObject != null) && (!((SnsInfo)localObject).isWaitPost()))
            {
              str = com.tencent.mm.plugin.sns.model.g.D(paramAnonymousMenuItem.fVT);
              SnsGalleryUI.this.cE(str, true);
            }
            try
            {
              int i = SnsGalleryUI.a(SnsGalleryUI.this, (SnsInfo)localObject);
              SnsGalleryUI.this.KNT.a(SnsGalleryUI.a(SnsGalleryUI.this), (SnsInfo)localObject, paramAnonymousMenuItem.fVT, SnsGalleryUI.this.KNW.KDy, SnsGalleryUI.this.KNW.KDz, true, i);
              AppMethodBeat.o(98699);
              return true;
            }
            catch (Exception paramAnonymousMenuItem)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.SnsGalleryUI", paramAnonymousMenuItem, "", new Object[0]);
              }
            }
          }
        });
        AppMethodBeat.o(98707);
        return;
        localObject = z.bcZ();
        if (this.userName.equals(localObject)) {
          localObject = bp.hzj();
        } else {
          localObject = bp.hzk();
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98709);
    Log.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(98709);
      return;
    }
    String str2;
    String str1;
    if (2 == paramInt1)
    {
      if (-1 != paramInt2) {
        break label514;
      }
      str2 = paramIntent.getStringExtra("Select_Conv_User");
      str1 = paramIntent.getStringExtra("custom_send_text");
      if (this.KNW == null) {
        break label534;
      }
      paramIntent = this.KNW.getSelectItem();
      if (paramIntent.fVT.rWu != 6)
      {
        AppMethodBeat.o(98709);
        return;
      }
    }
    label514:
    label534:
    for (Object localObject2 = paramIntent.fVT;; localObject2 = null)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(98709);
        return;
      }
      String str3 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject2).Id);
      paramIntent = "";
      Object localObject1 = "";
      String str4 = t.i((cvt)localObject2);
      if (u.agG(str3 + str4))
      {
        localObject1 = str3 + str4;
        paramIntent = str3 + t.d((cvt)localObject2);
      }
      if (u.agG(str3 + t.o((cvt)localObject2))) {
        paramIntent = str3 + t.o((cvt)localObject2);
      }
      for (localObject1 = str3 + t.m((cvt)localObject2);; localObject1 = localObject2)
      {
        localObject2 = Util.stringsToList(str2.split(","));
        paramInt1 = t.aZt(paramIntent);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str2 = (String)((Iterator)localObject2).next();
          Log.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[] { str2, paramIntent, localObject1, Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.g.eRW().a(this, str2, paramIntent, (String)localObject1, 62, paramInt1, "", null);
          com.tencent.mm.plugin.messenger.a.g.eRW().iQ(str1, str2);
        }
        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(i.j.has_send));
        AppMethodBeat.o(98709);
        return;
        if (1 == paramInt1)
        {
          paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
          localObject1 = com.tencent.mm.plugin.sns.storage.y.bt("sns_table_", paramIntent.getIntExtra("sns_gallery_op_id", 0));
          this.KNT.agL(paramInt1);
          gl((String)localObject1, 1);
          if (paramIntent.getBooleanExtra("sns_gallery_force_finish", false))
          {
            paramIntent = new Intent();
            paramIntent.putExtra("sns_cmd_list", this.KNT.KEo);
            setResult(-1, paramIntent);
            finish();
          }
        }
        AppMethodBeat.o(98709);
        return;
        localObject2 = paramIntent;
        paramIntent = (Intent)localObject1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98700);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    setActionbarColor(getContext().getResources().getColor(i.c.dark_actionbar_color));
    setNavigationbarColor(getContext().getResources().getColor(i.c.dark_actionbar_color));
    initView();
    com.tencent.mm.plugin.sns.k.g.Kia.Kix = System.currentTimeMillis();
    AppMethodBeat.o(98700);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98701);
    getWindow().clearFlags(128);
    aj.fOF().aO(this);
    super.onDestroy();
    com.tencent.mm.plugin.sns.k.g localg = com.tencent.mm.plugin.sns.k.g.Kia;
    if (localg.Kix != 0L)
    {
      localg.Kiy += System.currentTimeMillis() - localg.Kix;
      localg.Kix = 0L;
    }
    com.tencent.mm.plugin.sns.k.g.Kia.fQu();
    com.tencent.mm.plugin.sns.k.g.Kia.fQw();
    AppMethodBeat.o(98701);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98704);
    super.onPause();
    f.d(false, true, true);
    AppMethodBeat.o(98704);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98705);
    super.onResume();
    SnsInfoFlip localSnsInfoFlip;
    if (this.KNW != null)
    {
      cvt localcvt = this.KNW.getCntMedia();
      localSnsInfoFlip = this.KNW;
      if ((localcvt == null) || (localcvt.rWu != 6)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localSnsInfoFlip.yY(bool);
      f.d(true, true, true);
      AppMethodBeat.o(98705);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98702);
    super.onStart();
    com.tencent.mm.plugin.sns.k.g.Kia.KiE = System.currentTimeMillis();
    AppMethodBeat.o(98702);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98703);
    super.onStop();
    com.tencent.mm.plugin.sns.k.g.Kia.fQu();
    AppMethodBeat.o(98703);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsGalleryUI
 * JD-Core Version:    0.7.0.1
 */