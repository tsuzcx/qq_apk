package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.b.a.ih;
import com.tencent.mm.g.b.a.iu;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@i
public class SnsGalleryUI
  extends SnsBaseGalleryUI
  implements w.a
{
  private String DUW = "";
  private int EAu = 0;
  private boolean dJM = false;
  private int scene = 0;
  private String userName = "";
  
  private int W(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(203575);
    int i = this.EAi.getPosition();
    int j = paramSnsInfo.getTimeLine().ContentObj.LoV.size();
    if ((j > 1) && (i > 1) && (i <= j)) {
      i -= 1;
    }
    for (;;)
    {
      AppMethodBeat.o(203575);
      return i;
      i = 0;
    }
  }
  
  protected final void ap(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(203576);
    Object localObject1;
    if (((paramBoolean1) || (paramBoolean2)) && (this.EAf != null))
    {
      localObject1 = this.EAf;
      if ((((w)localObject1).Epy == null) || (!((w)localObject1).Epy.isShowing())) {
        break label158;
      }
    }
    label158:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject2 = this.EAi.getSelectId();
        String str = this.EAi.getSelectedMediaId();
        localObject1 = this.EAi.getSelectItem();
        Log.i("MicroMsg.SnsGalleryUI", "onTranslateEnd showTranslateMenu: %s, showOcrMenu: %s, selectLocalId: %s, mediaId: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), localObject2, str });
        localObject2 = aj.faO().aQm((String)localObject2);
        i = W((SnsInfo)localObject2);
        this.EAf.a(this.dJM, (SnsInfo)localObject2, ((com.tencent.mm.plugin.sns.j.b)localObject1).ebR, paramBoolean1, paramBoolean2, true, i);
      }
      AppMethodBeat.o(203576);
      return;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98706);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.EAf.EqW);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(98706);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98706);
    return bool;
  }
  
  public final void fH(String paramString, int paramInt)
  {
    AppMethodBeat.i(98708);
    SnsInfoFlip localSnsInfoFlip;
    if (this.EAi != null) {
      if ((!Util.isNullOrNil(paramString)) && (paramInt != 3))
      {
        localSnsInfoFlip = this.EAi;
        if ((localSnsInfoFlip.EDX != null) && (localSnsInfoFlip.iHf != null)) {
          break label57;
        }
      }
    }
    for (;;)
    {
      this.EAi.vu(true);
      AppMethodBeat.o(98708);
      return;
      label57:
      paramInt = 0;
      while (paramInt >= 0)
      {
        if (localSnsInfoFlip.EDX != null) {
          for (;;)
          {
            if (paramInt >= localSnsInfoFlip.iHf.size()) {
              break label137;
            }
            com.tencent.mm.plugin.sns.j.b localb = localSnsInfoFlip.EDX.ZN(paramInt);
            if ((!Util.isNullOrNil(localb.parentId)) && (localb.parentId.equals(paramString)))
            {
              localSnsInfoFlip.iHf.remove(paramInt);
              break;
            }
            paramInt += 1;
          }
        }
        label137:
        paramInt = -1;
      }
      localSnsInfoFlip.EDX.notifyDataSetChanged();
    }
  }
  
  public final void fI(String paramString, int paramInt)
  {
    AppMethodBeat.i(98710);
    super.fI(paramString, paramInt);
    paramString = aj.faO().aQm(paramString);
    TimeLineObject localTimeLineObject;
    ih localih;
    if (paramString != null)
    {
      com.tencent.mm.plugin.sns.k.e.DUQ.P(paramString);
      com.tencent.mm.plugin.sns.k.e.DUQ.c(paramString, paramInt);
      localTimeLineObject = paramString.getTimeLine();
      if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj != null) && (!Util.isNullOrNil(localTimeLineObject.ContentObj.LoV)))
      {
        localih = com.tencent.mm.plugin.sns.k.e.DUQ.fcz();
        if (localih != null) {
          break label186;
        }
        localih = com.tencent.mm.plugin.sns.k.e.DUQ.fcA();
        localih.eOs = 1L;
        localih = localih.wf(r.Jc(paramString.field_snsId)).we(com.tencent.mm.plugin.sns.k.e.DUQ.DVe.ePK);
        localih.eDV = com.tencent.mm.plugin.sns.k.e.DUQ.DVe.eDV;
        localih.erx = localTimeLineObject.ContentObj.LoU;
        localih.eOr = localTimeLineObject.ContentObj.LoV.size();
        com.tencent.mm.plugin.sns.k.e.DUQ.DVu = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.k.e.DUQ.f(paramString, paramInt);
      AppMethodBeat.o(98710);
      return;
      label186:
      if (!Util.isEqual(r.Jc(paramString.field_snsId), localih.err))
      {
        com.tencent.mm.plugin.sns.k.e.DUQ.fcD();
        localih = com.tencent.mm.plugin.sns.k.e.DUQ.fcA();
        localih.eOs = 0L;
        localih = localih.wf(r.Jc(paramString.field_snsId)).we(com.tencent.mm.plugin.sns.k.e.DUQ.DVe.ePK);
        localih.eDV = com.tencent.mm.plugin.sns.k.e.DUQ.DVe.eDV;
        localih.erx = localTimeLineObject.ContentObj.LoU;
        localih.eOr = localTimeLineObject.ContentObj.LoV.size();
        com.tencent.mm.plugin.sns.k.e.DUQ.DVu = System.currentTimeMillis();
      }
    }
  }
  
  protected final boolean fhC()
  {
    return true;
  }
  
  protected final int fhD()
  {
    return 4;
  }
  
  protected final int fhE()
  {
    return 4;
  }
  
  public int getLayoutId()
  {
    return 2131496440;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98707);
    this.scene = getIntent().getIntExtra("sns_video_scene", 0);
    this.userName = getIntent().getStringExtra("sns_gallery_userName");
    int i = getIntent().getIntExtra("sns_gallery_localId", 0);
    this.dJM = getIntent().getBooleanExtra("sns_gallery_is_self", false);
    this.EAu = getIntent().getIntExtra("sns_gallery_position", 0);
    Object localObject = y.bq("sns_table_", i);
    Log.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", new Object[] { localObject, Integer.valueOf(this.EAu) });
    fI((String)localObject, this.EAu);
    X(this.dJM, 1);
    this.EAi = new SnsInfoFlip(this);
    this.EAi.setVideoScene(this.scene);
    this.EAi.setNeedScanImage(true);
    localObject = aj.faE();
    String str = this.userName;
    if (((aq.a)localObject).DMA.containsKey(str))
    {
      i = ((Integer)((aq.a)localObject).DMA.get(str)).intValue();
      ((aq.a)localObject).DMA.put(str, Integer.valueOf(i + 1));
      localObject = (ArrayList)((aq.a)localObject).DMz.get(str);
      if (localObject != null) {
        break label477;
      }
      localObject = new ArrayList();
    }
    label477:
    for (;;)
    {
      this.EAi.setShowTitle(true);
      this.EAi.setEnableHorLongBmpMode(false);
      this.EAi.a((List)localObject, this.userName, this.EAu, this.EAd, this);
      this.EAi.setOnDeleteAllAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98697);
          SnsGalleryUI.this.EAf.ffJ();
          AppMethodBeat.o(98697);
        }
      });
      this.EAi.setOnPageSelectListener(this);
      com.tencent.mm.kernel.g.aAi();
      localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.userName);
      if ((localObject != null) && ((int)((c)localObject).gMZ > 0) && (c.oR(((ax)localObject).field_type))) {
        localObject = bp.gCV();
      }
      for (;;)
      {
        this.EAi.setFromScene((bp)localObject);
        this.EAi.setUIFromScene(getFromScene());
        this.EAi.username = this.userName;
        addView(this.EAi);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98698);
            SnsGalleryUI.this.EAf.ffJ();
            AppMethodBeat.o(98698);
            return true;
          }
        });
        addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(98699);
            Object localObject = SnsGalleryUI.this.EAi.getSelectId();
            String str = SnsGalleryUI.this.EAi.getSelectedMediaId();
            paramAnonymousMenuItem = SnsGalleryUI.this.EAi.getSelectItem();
            Log.d("MicroMsg.SnsGalleryUI", "click selectLocalId: %s, mediaId: %s, showTranslate: %s, showOcr: %s", new Object[] { localObject, str, Boolean.valueOf(SnsGalleryUI.this.EAi.Eqi), Boolean.valueOf(SnsGalleryUI.this.EAi.Eqj) });
            localObject = aj.faO().aQm((String)localObject);
            try
            {
              int i = SnsGalleryUI.a(SnsGalleryUI.this, (SnsInfo)localObject);
              SnsGalleryUI.this.EAf.a(SnsGalleryUI.a(SnsGalleryUI.this), (SnsInfo)localObject, paramAnonymousMenuItem.ebR, SnsGalleryUI.this.EAi.Eqi, SnsGalleryUI.this.EAi.Eqj, true, i);
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
        ((aq.a)localObject).DMA.put(str, Integer.valueOf(0));
        break;
        localObject = z.aTY();
        if (this.userName.equals(localObject)) {
          localObject = bp.gCW();
        } else {
          localObject = bp.gCX();
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
      if (this.EAi == null) {
        break label534;
      }
      paramIntent = this.EAi.getSelectItem();
      if (paramIntent.ebR.oUv != 6)
      {
        AppMethodBeat.o(98709);
        return;
      }
    }
    label514:
    label534:
    for (Object localObject2 = paramIntent.ebR;; localObject2 = null)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(98709);
        return;
      }
      String str3 = ar.ki(aj.getAccSnsPath(), ((cnb)localObject2).Id);
      paramIntent = "";
      Object localObject1 = "";
      String str4 = r.j((cnb)localObject2);
      if (s.YS(str3 + str4))
      {
        localObject1 = str3 + str4;
        paramIntent = str3 + r.e((cnb)localObject2);
      }
      if (s.YS(str3 + r.p((cnb)localObject2))) {
        paramIntent = str3 + r.p((cnb)localObject2);
      }
      for (localObject1 = str3 + r.n((cnb)localObject2);; localObject1 = localObject2)
      {
        localObject2 = Util.stringsToList(str2.split(","));
        paramInt1 = r.aOx(paramIntent);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str2 = (String)((Iterator)localObject2).next();
          Log.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[] { str2, paramIntent, localObject1, Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.g.eir().a(this, str2, paramIntent, (String)localObject1, 62, paramInt1, "", null);
          com.tencent.mm.plugin.messenger.a.g.eir().iF(str1, str2);
        }
        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131761619));
        AppMethodBeat.o(98709);
        return;
        if (1 == paramInt1)
        {
          paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
          localObject1 = y.bq("sns_table_", paramIntent.getIntExtra("sns_gallery_op_id", 0));
          this.EAf.Zu(paramInt1);
          fH((String)localObject1, 1);
          if (paramIntent.getBooleanExtra("sns_gallery_force_finish", false))
          {
            paramIntent = new Intent();
            paramIntent.putExtra("sns_cmd_list", this.EAf.EqW);
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
    setActionbarColor(getContext().getResources().getColor(2131100229));
    setNavigationbarColor(getContext().getResources().getColor(2131100229));
    initView();
    com.tencent.mm.plugin.sns.k.e.DUQ.DVn = System.currentTimeMillis();
    AppMethodBeat.o(98700);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98701);
    getWindow().clearFlags(128);
    Object localObject = aj.faE();
    String str = this.userName;
    int i;
    if (((aq.a)localObject).DMA.containsKey(str))
    {
      i = Math.max(((Integer)((aq.a)localObject).DMA.get(str)).intValue() - 1, 0);
      ((aq.a)localObject).DMA.put(str, Integer.valueOf(i));
    }
    for (;;)
    {
      if (i <= 0) {
        ((aq.a)localObject).DMz.remove(str);
      }
      aj.faL().aI(this);
      super.onDestroy();
      localObject = com.tencent.mm.plugin.sns.k.e.DUQ;
      if (((com.tencent.mm.plugin.sns.k.e)localObject).DVn != 0L)
      {
        ((com.tencent.mm.plugin.sns.k.e)localObject).DVo += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.k.e)localObject).DVn;
        ((com.tencent.mm.plugin.sns.k.e)localObject).DVn = 0L;
      }
      com.tencent.mm.plugin.sns.k.e.DUQ.fcB();
      com.tencent.mm.plugin.sns.k.e.DUQ.fcD();
      AppMethodBeat.o(98701);
      return;
      i = 0;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98704);
    super.onPause();
    f.e(false, true, true);
    AppMethodBeat.o(98704);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98705);
    super.onResume();
    SnsInfoFlip localSnsInfoFlip;
    if (this.EAi != null)
    {
      cnb localcnb = this.EAi.getCntMedia();
      localSnsInfoFlip = this.EAi;
      if ((localcnb == null) || (localcnb.oUv != 6)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localSnsInfoFlip.vu(bool);
      f.e(true, true, true);
      AppMethodBeat.o(98705);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98702);
    super.onStart();
    com.tencent.mm.plugin.sns.k.e.DUQ.DVu = System.currentTimeMillis();
    AppMethodBeat.o(98702);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98703);
    super.onStop();
    com.tencent.mm.plugin.sns.k.e.DUQ.fcB();
    AppMethodBeat.o(98703);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsGalleryUI
 * JD-Core Version:    0.7.0.1
 */