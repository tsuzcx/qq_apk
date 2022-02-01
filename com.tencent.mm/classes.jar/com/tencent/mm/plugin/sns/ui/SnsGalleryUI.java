package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.ni;
import com.tencent.mm.autogen.mmdata.rpt.od;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.d.c.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@k
public class SnsGalleryUI
  extends SnsBaseGalleryUI
  implements z.a
{
  private String QFZ = "";
  private int RnZ = 0;
  private boolean hHq = false;
  private int scene = 0;
  private String userName = "";
  
  private int aa(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(308422);
    int i = this.RnH.getPosition();
    int j = paramSnsInfo.getTimeLine().ContentObj.Zpr.size();
    if ((j > 1) && (i > 1) && (i <= j)) {
      i -= 1;
    }
    for (;;)
    {
      AppMethodBeat.o(308422);
      return i;
      i = 0;
    }
  }
  
  protected final void aW(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(308433);
    Object localObject1;
    if (((paramBoolean1) || (paramBoolean2)) && (this.RnE != null))
    {
      localObject1 = this.RnE;
      if ((((z)localObject1).Rde == null) || (!((z)localObject1).Rde.cDi().isShowing())) {
        break label161;
      }
    }
    label161:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject2 = this.RnH.getSelectId();
        String str = this.RnH.getSelectedMediaId();
        localObject1 = this.RnH.getSelectItem();
        Log.i("MicroMsg.SnsGalleryUI", "onTranslateEnd showTranslateMenu: %s, showOcrMenu: %s, selectLocalId: %s, mediaId: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), localObject2, str });
        localObject2 = al.hgB().aZL((String)localObject2);
        i = aa((SnsInfo)localObject2);
        this.RnE.a(this.hHq, (SnsInfo)localObject2, ((bzi)localObject1).ibT, paramBoolean1, paramBoolean2, true, i);
      }
      AppMethodBeat.o(308433);
      return;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98706);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
      if (hob())
      {
        AppMethodBeat.o(98706);
        return true;
      }
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.RnE.RdQ);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(98706);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98706);
    return bool;
  }
  
  public int getLayoutId()
  {
    return b.g.sns_gallery_img;
  }
  
  public final void hf(String paramString, int paramInt)
  {
    AppMethodBeat.i(98708);
    if (this.RnH != null)
    {
      if ((!Util.isNullOrNil(paramString)) && (paramInt != 3)) {
        this.RnH.baF(paramString);
      }
      this.RnH.Ei(true);
    }
    AppMethodBeat.o(98708);
  }
  
  public final void hg(String paramString, int paramInt)
  {
    AppMethodBeat.i(98710);
    super.hg(paramString, paramInt);
    paramString = al.hgB().aZL(paramString);
    TimeLineObject localTimeLineObject;
    ni localni;
    if (paramString != null)
    {
      j.QFS.S(paramString);
      j.QFS.e(paramString, paramInt);
      localTimeLineObject = paramString.getTimeLine();
      if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj != null) && (!Util.isNullOrNil(localTimeLineObject.ContentObj.Zpr)))
      {
        localni = j.QFS.hiq();
        if (localni != null) {
          break label188;
        }
        localni = j.QFS.hir();
        localni.jeN = 1L;
        localni = localni.vG(t.uB(paramString.field_snsId)).vF(j.QFS.QGh.jfs);
        localni.iOd = j.QFS.QGh.iOd;
        localni.iwe = localTimeLineObject.ContentObj.Zpq;
        localni.jeM = localTimeLineObject.ContentObj.Zpr.size();
        j.QFS.QGy = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      j.QFS.h(paramString, paramInt);
      AppMethodBeat.o(98710);
      return;
      label188:
      if (!Util.isEqual(t.uB(paramString.field_snsId), localni.ivZ))
      {
        j.QFS.hiu();
        localni = j.QFS.hir();
        localni.jeN = 0L;
        localni = localni.vG(t.uB(paramString.field_snsId)).vF(j.QFS.QGh.jfs);
        localni.iOd = j.QFS.QGh.iOd;
        localni.iwe = localTimeLineObject.ContentObj.Zpq;
        localni.jeM = localTimeLineObject.ContentObj.Zpr.size();
        j.QFS.QGy = System.currentTimeMillis();
      }
    }
  }
  
  protected final boolean hod()
  {
    return true;
  }
  
  protected final int hoe()
  {
    return 4;
  }
  
  protected final int hof()
  {
    return 4;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98707);
    this.scene = getIntent().getIntExtra("sns_video_scene", 0);
    this.userName = getIntent().getStringExtra("sns_gallery_userName");
    int i = getIntent().getIntExtra("sns_gallery_localId", 0);
    this.hHq = getIntent().getBooleanExtra("sns_gallery_is_self", false);
    this.RnZ = getIntent().getIntExtra("sns_gallery_position", 0);
    Object localObject = ai.bF("sns_table_", i);
    Log.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", new Object[] { localObject, Integer.valueOf(this.RnZ) });
    hg((String)localObject, this.RnZ);
    am(this.hHq, 1);
    this.RnH = new SnsInfoFlip(this);
    this.RnH.setVideoScene(this.scene);
    this.RnH.setNeedScanImage(true);
    ArrayList localArrayList = al.hgr().aYA(this.userName);
    localObject = localArrayList;
    if (localArrayList == null) {
      localObject = new ArrayList();
    }
    this.RnH.setShowTitle(true);
    this.RnH.setEnableHorLongBmpMode(false);
    this.RnH.a((List)localObject, this.userName, this.RnZ, this.RnC, this);
    this.RnH.setOnDeleteAllAction(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98697);
        SnsGalleryUI.this.RnE.hlZ();
        AppMethodBeat.o(98697);
      }
    });
    this.RnH.setOnPageSelectListener(this);
    this.RnH.getGallery().setLongClickOverListener(new MMViewPager.d()
    {
      public final void longClickOver()
      {
        AppMethodBeat.i(307588);
        SnsGalleryUI.a(SnsGalleryUI.this);
        AppMethodBeat.o(307588);
      }
    });
    h.baF();
    localObject = ((n)h.ax(n.class)).bzA().JE(this.userName);
    if ((localObject != null) && ((int)((d)localObject).maN > 0) && (d.rs(((az)localObject).field_type))) {
      localObject = br.jbi();
    }
    for (;;)
    {
      this.RnH.setFromScene((br)localObject);
      this.RnH.setUIFromScene(getFromScene());
      this.RnH.username = this.userName;
      addView(this.RnH);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98699);
          SnsGalleryUI.this.RnE.hlZ();
          AppMethodBeat.o(98699);
          return true;
        }
      });
      addIconOptionMenu(0, b.i.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(307597);
          SnsGalleryUI.a(SnsGalleryUI.this);
          AppMethodBeat.o(307597);
          return true;
        }
      });
      AppMethodBeat.o(98707);
      return;
      localObject = com.tencent.mm.model.z.bAM();
      if (this.userName.equals(localObject)) {
        localObject = br.jbj();
      } else {
        localObject = br.jbk();
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
    String str1;
    if (2 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        str1 = paramIntent.getStringExtra("Select_Conv_User");
        String str2 = paramIntent.getStringExtra("custom_send_text");
        paramIntent = null;
        if (this.RnH != null)
        {
          paramIntent = this.RnH.getSelectItem();
          if (paramIntent.ibT.vhJ != 6)
          {
            AppMethodBeat.o(98709);
            return;
          }
          paramIntent = paramIntent.ibT;
        }
        if (paramIntent == null)
        {
          AppMethodBeat.o(98709);
          return;
        }
        c.a locala = c.RUl;
        c.a.b(this, str1, str2, paramIntent);
        AppMethodBeat.o(98709);
      }
    }
    else if (1 == paramInt1)
    {
      paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
      str1 = ai.bF("sns_table_", paramIntent.getIntExtra("sns_gallery_op_id", 0));
      this.RnE.alE(paramInt1);
      hf(str1, 1);
      if (paramIntent.getBooleanExtra("sns_gallery_force_finish", false))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("sns_cmd_list", this.RnE.RdQ);
        setResult(-1, paramIntent);
        finish();
      }
    }
    AppMethodBeat.o(98709);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98700);
    aw.bW(this);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    setActionbarColor(getContext().getResources().getColor(b.c.dark_actionbar_color));
    setNavigationbarColor(getContext().getResources().getColor(b.c.dark_actionbar_color));
    initView();
    j.QFS.QGr = System.currentTimeMillis();
    AppMethodBeat.o(98700);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98701);
    getWindow().clearFlags(128);
    al.hgy().bq(this);
    super.onDestroy();
    j localj = j.QFS;
    if (localj.QGr != 0L)
    {
      localj.QGs += System.currentTimeMillis() - localj.QGr;
      localj.QGr = 0L;
    }
    j.QFS.his();
    j.QFS.hiu();
    AppMethodBeat.o(98701);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98704);
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(98704);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98705);
    super.onResume();
    SnsInfoFlip localSnsInfoFlip;
    if (this.RnH != null)
    {
      dmz localdmz = this.RnH.getCntMedia();
      localSnsInfoFlip = this.RnH;
      if ((localdmz == null) || (localdmz.vhJ != 6)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localSnsInfoFlip.Ei(bool);
      com.tencent.mm.plugin.ball.f.f.d(true, true, true);
      AppMethodBeat.o(98705);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98702);
    super.onStart();
    j.QFS.QGy = System.currentTimeMillis();
    AppMethodBeat.o(98702);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98703);
    super.onStop();
    j.QFS.his();
    AppMethodBeat.o(98703);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsGalleryUI
 * JD-Core Version:    0.7.0.1
 */