package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.w;
import com.tencent.mm.aj.w.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.sns.ad.f.p.a;
import com.tencent.mm.plugin.sns.ad.f.p.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(35)
public class SnsAdStreamVideoPlayUI
  extends MMActivity
  implements i.a, i.b, com.tencent.mm.pluginsdk.ui.i.c
{
  private int JJO;
  private SnsInfo Jzk;
  private String KNA;
  private com.tencent.mm.plugin.sns.ad.f.m KNB;
  private String KNC;
  private String KND;
  private int KNE;
  private int KNF;
  private String KNG;
  private String KNH;
  private String KNI;
  private long KNJ;
  private int KNK;
  private int KNL;
  private boolean KNM;
  private FrameLayout KNw;
  private SnsAdStreamVideoView KNx;
  private boolean KNy;
  private boolean KNz;
  private String KmB;
  private String fUk;
  private String kih;
  private String lou;
  private String lov;
  private String mediaId;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private String viewId;
  private TextView wOf;
  
  public SnsAdStreamVideoPlayUI()
  {
    AppMethodBeat.i(98458);
    this.KNB = new com.tencent.mm.plugin.sns.ad.f.m("SnsAdStreamVideoPlayUI");
    this.KmB = "";
    AppMethodBeat.o(98458);
  }
  
  private void aeL(int paramInt)
  {
    AppMethodBeat.i(98465);
    if (this.KNx != null) {
      this.KNx.a(paramInt, true);
    }
    AppMethodBeat.o(98465);
  }
  
  public final void EW(long paramLong) {}
  
  public final void KP(String paramString) {}
  
  public final void aR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98470);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s download finish", new Object[] { paramString });
    this.KNB.JFm = 1;
    AppMethodBeat.o(98470);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dS(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(98466);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s prepared, video total time %d", new Object[] { paramString2, Integer.valueOf(this.KNx.getVideoDurationSec()) });
    this.KNx.fZz();
    if (this.JJO == 0) {
      this.JJO = this.KNx.getVideoDurationSec();
    }
    paramString1 = this.KNB.JFu;
    if (getResources().getConfiguration().orientation == 2) {
      i = 2;
    }
    paramString1.JGI = i;
    this.KNB.JFu.JGJ = Util.currentTicks();
    this.KNB.JFu.JGH = 2;
    this.KNB.JFu.JGF = 0;
    paramString1 = this.KNB.JFu;
    paramString1.JGD += 1;
    this.KNB.JFu.JGJ = Util.currentTicks();
    AppMethodBeat.o(98466);
  }
  
  public final void dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98467);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s video ended", new Object[] { paramString2 });
    paramString1 = this.KNB.JFu;
    paramString1.JGE += 1;
    this.KNx.stop();
    this.KNx.fZw();
    this.KNx.Ltg.stopTimer();
    this.KNx.setIsShowBasicControls(true);
    AppMethodBeat.o(98467);
  }
  
  public final void dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98468);
    Log.d("MicroMsg.SnsAdStreamVideoPlayUI", "%s video paused", new Object[] { paramString2 });
    paramString1 = this.KNB.JFu;
    paramString1.JGF += (int)Util.ticksToNow(this.KNB.JFu.JGJ);
    AppMethodBeat.o(98468);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98469);
    this.KNx.fZx();
    AppMethodBeat.o(98469);
  }
  
  public final void dW(String paramString1, String paramString2) {}
  
  public final void dX(String paramString1, String paramString2) {}
  
  public final void fC(String paramString1, String paramString2) {}
  
  public void finish()
  {
    AppMethodBeat.i(98462);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "stop play");
    this.KNx.onUIDestroy();
    this.KNx.fZz();
    aj.fOD().aZH(this.mediaId);
    if ((this.KNB != null) && (this.KmB != null) && (this.KmB.length() > 0))
    {
      this.KNB.fKT();
      localObject = new Intent();
      ((Intent)localObject).putExtra("KComponentCid", this.KmB);
      ((Intent)localObject).putExtra("KStreamVideoPlayCount", this.KNB.JFq);
      ((Intent)localObject).putExtra("KStreamVideoPlayCompleteCount", this.KNB.JFr);
      ((Intent)localObject).putExtra("KStreamVideoTotalPlayTimeInMs", this.KNB.JFs);
      setResult(-1, (Intent)localObject);
    }
    if (this.KNF != 0) {
      com.tencent.mm.plugin.sns.ad.f.p.a(p.a.JFZ, this.KND, this.KNC, this.KNE, this.KNF, this.KNG, this.KNH, this.KNI, this.KNJ, this.KNK, this.KNL);
    }
    int i;
    String str;
    int j;
    if (this.KNM)
    {
      if (this.Jzk != null) {
        break label402;
      }
      i = 0;
      if (this.Jzk != null)
      {
        str = this.KNB.fKS();
        long l2 = this.KNB.JFn - this.KNB.mba;
        long l1 = l2;
        if (l2 < 0L)
        {
          Log.e("MicroMsg.SnsAdStreamVideoPlayUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.KNB.JFn), Long.valueOf(this.KNB.mba) });
          l1 = this.KNB.JFn;
        }
        j = (int)l1;
        localObject = this.Jzk.getAdInfo();
        if (localObject != null) {
          break label413;
        }
      }
    }
    label402:
    label413:
    for (Object localObject = "";; localObject = ((ADInfo)localObject).waidPkg)
    {
      h.aHH();
      h.aHF().kcd.a(new com.tencent.mm.plugin.sns.ad.f.g(this.viewId, 6, this.KNB.JFn, str, i, j, j, this.Jzk.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), this.Jzk.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), (String)localObject), 0);
      super.finish();
      AppMethodBeat.o(98462);
      return;
      i = this.Jzk.getAdRecSrc();
      break;
    }
  }
  
  public int getForceOrientation()
  {
    if (this.KNy) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return i.g.sns_ad_stream_play_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98460);
    this.KNw = ((FrameLayout)findViewById(i.f.root_container));
    this.KNx = ((SnsAdStreamVideoView)findViewById(i.f.video_view));
    this.KNw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98455);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setIsShowBasicControls(true);
        if (SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).isPlaying())
        {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).Ltg.stopTimer();
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).fZz();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98455);
      }
    });
    this.KNw.setPadding(0, 0, 0, ar.aB(this));
    this.wOf = ((TextView)findViewById(i.f.show_ad_sight));
    Object localObject;
    if (!Util.isNullOrNil(new String[] { this.lou, this.lov }))
    {
      this.wOf.setVisibility(0);
      this.wOf.setText(this.lou);
      this.wOf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98456);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this) != 0) {
            com.tencent.mm.plugin.sns.ad.f.p.a(p.a.JFX, SnsAdStreamVideoPlayUI.h(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.j(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.k(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.l(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.m(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.n(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.o(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.p(SnsAdStreamVideoPlayUI.this));
          }
          Intent localIntent = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("key_snsad_statextstr", SnsAdStreamVideoPlayUI.q(SnsAdStreamVideoPlayUI.this));
          localObject = SnsAdStreamVideoPlayUI.r(SnsAdStreamVideoPlayUI.this);
          paramAnonymousView = (View)localObject;
          if (SnsAdStreamVideoPlayUI.s(SnsAdStreamVideoPlayUI.this))
          {
            paramAnonymousView = (View)localObject;
            if (!TextUtils.isEmpty(SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this))) {
              paramAnonymousView = com.tencent.mm.plugin.sns.data.t.kw((String)localObject, SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this));
            }
          }
          localIntent.putExtra("jsapiargs", localBundle);
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("useJs", true);
          if (SnsAdStreamVideoPlayUI.s(SnsAdStreamVideoPlayUI.this)) {
            com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(0, 6, SnsAdStreamVideoPlayUI.t(SnsAdStreamVideoPlayUI.this).field_snsId, 18, 0));
          }
          com.tencent.mm.plugin.sns.c.a.mIG.h(localIntent, SnsAdStreamVideoPlayUI.this);
          SnsAdStreamVideoPlayUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98456);
        }
      });
      this.KNx.setReporter(this);
      this.KNx.setIMMVideoViewCallback(this);
      this.KNx.setIMMDownloadFinish(this);
      this.KNx.setRootPath(aj.getSnsAdPath());
      this.KNx.c(false, this.kih, 0);
      this.KNx.setScaleType(com.tencent.mm.pluginsdk.ui.i.e.RcG);
      this.KNx.setIOnlineVideoProxy(new af());
      if ((Util.isNullOrNil(this.thumbPath)) || (!u.agG(this.thumbPath))) {
        break label314;
      }
      localObject = BitmapUtil.decodeFile(this.thumbPath, null);
      if (localObject == null) {
        break label314;
      }
      this.KNx.setCover((Bitmap)localObject);
      label247:
      Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "start play");
      if (!this.KNx.isPlaying())
      {
        if (this.KNx.getCurrPosSec() != this.KNx.getVideoDurationSec()) {
          break label502;
        }
        aeL(0);
      }
    }
    for (;;)
    {
      this.KNx.start();
      AppMethodBeat.o(98460);
      return;
      this.wOf.setVisibility(8);
      break;
      label314:
      String str = "attach" + this.mediaId;
      localObject = aq.kD(aj.getSnsAdPath(), str);
      str = com.tencent.mm.plugin.sns.data.t.aZb(str);
      this.thumbPath = ((String)localObject + str);
      Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "try download thumb img %s, save to %s", new Object[] { this.mediaId, this.thumbPath });
      cvt localcvt = com.tencent.mm.modelsns.o.a(this.thumbPath, 2, this.thumbUrl, this.thumbUrl, 1, 1, "");
      com.tencent.mm.plugin.sns.data.p localp = new com.tencent.mm.plugin.sns.data.p(localcvt);
      localp.JRn = 3;
      localp.fIY = localcvt.Id;
      aj.fOD().a(new a(localcvt.Id));
      com.tencent.mm.plugin.sns.model.c localc = aj.fOD();
      bp localbp = bp.hzh();
      localbp.time = ((int)(System.currentTimeMillis() / 1000L));
      localc.a(localcvt, 8, localp, localbp, (String)localObject, str);
      break label247;
      label502:
      aeL(this.KNx.getCurrPosSec());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98471);
    if (999 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = Util.stringsToList(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "send sight to %s", new Object[] { str2 });
          localObject1 = new k.b();
          ((k.b)localObject1).title = this.KNA;
          ((k.b)localObject1).type = 4;
          label137:
          Object localObject2;
          label246:
          String str3;
          label360:
          int j;
          int k;
          String str4;
          String str5;
          String str6;
          long l;
          int m;
          int n;
          if (!Util.isNullOrNil(this.url))
          {
            ((k.b)localObject1).url = this.url;
            ((k.b)localObject1).thumburl = this.thumbUrl;
            ((k.b)localObject1).lor = this.kih;
            ((k.b)localObject1).los = this.JJO;
            ((k.b)localObject1).lot = this.KNA;
            ((k.b)localObject1).lov = this.lov;
            ((k.b)localObject1).lou = this.lou;
            ((k.b)localObject1).low = this.thumbUrl;
            ((k.b)localObject1).lox = this.KNC;
            ((k.b)localObject1).loy = this.KND;
            ((k.b)localObject1).fUk = this.fUk;
            localObject2 = u.aY(this.thumbPath, 0, -1);
            if (localObject2 != null) {
              break label474;
            }
            i = 0;
            Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.bbx() != null) {
              w.a.bbx().a((k.b)localObject1, "", "", str2, "", (byte[])localObject2);
            }
            com.tencent.mm.plugin.messenger.a.g.eRW().iQ(str1, str2);
            if (this.KNM) {
              com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(0, 6, this.Jzk.field_snsId, 12, 0));
            }
            if (this.KNF == 0) {
              continue;
            }
            boolean bool = ab.Lj(str2);
            if (!bool) {
              break label482;
            }
            localObject1 = p.c.JGl;
            localObject2 = this.KND;
            str3 = this.KNC;
            j = this.KNE;
            k = this.KNF;
            str4 = this.KNG;
            str5 = this.KNH;
            str6 = this.KNI;
            l = this.KNJ;
            m = this.KNK;
            n = this.KNL;
            if (!bool) {
              break label490;
            }
          }
          label474:
          label482:
          label490:
          for (int i = v.Pu(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.ad.f.p.a((p.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject1).url = this.kih;
            break label137;
            i = localObject2.length;
            break label246;
            localObject1 = p.c.JGk;
            break label360;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(i.j.has_send));
      }
    }
    else if (998 == paramInt1)
    {
      if (this.KNF != 0) {
        com.tencent.mm.plugin.sns.ad.f.p.a(p.c.JGm, this.KND, this.KNC, this.KNE, this.KNF, this.KNG, this.KNH, this.KNI, this.KNJ, this.KNK, this.KNL, 0);
      }
      if (-1 != paramInt2) {
        break label650;
      }
      if (this.KNM) {
        com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(0, 6, this.Jzk.field_snsId, 15, 0));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(98471);
      return;
      if (!this.KNM) {
        break;
      }
      com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(0, 6, this.Jzk.field_snsId, 13, 0));
      break;
      label650:
      if (this.KNM) {
        com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(0, 6, this.Jzk.field_snsId, 16, 0));
      }
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(98459);
    super.onCreate(paramBundle);
    this.url = getIntent().getStringExtra("KUrl");
    this.kih = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.thumbPath = getIntent().getStringExtra("KThumbPath");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.KNy = getIntent().getBooleanExtra("ForceLandscape", false);
    this.KNz = getIntent().getBooleanExtra("KBlockFav", false);
    this.KNA = Util.nullAs(getIntent().getStringExtra("KMediaTitle"), "");
    this.JJO = getIntent().getIntExtra("KMediaVideoTime", 0);
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.Jzk = aj.fOI().bbk(com.tencent.mm.plugin.sns.data.t.aZs(paramBundle));
    this.KNM = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.KNB.JFo = Util.currentTicks();
    this.KmB = getIntent().getStringExtra("KComponentCid");
    this.KNC = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.KND = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.KNE = getIntent().getIntExtra("KSta_SourceType", 0);
    this.KNF = getIntent().getIntExtra("KSta_Scene", 0);
    this.KNG = getIntent().getStringExtra("KSta_FromUserName");
    this.KNH = getIntent().getStringExtra("KSta_ChatName");
    this.KNI = getIntent().getStringExtra("KSta_SnSId");
    this.KNJ = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.KNK = getIntent().getIntExtra("KSta_FavID", 0);
    this.KNL = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.fUk = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.viewId = Util.nullAs(getIntent().getStringExtra("KViewId"), "");
    this.lou = getIntent().getStringExtra("StreamWording");
    this.lov = getIntent().getStringExtra("StremWebUrl");
    setMMTitle("");
    paramBundle = new e(this, 1, false);
    paramBundle.ODT = new q.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
      {
        AppMethodBeat.i(98451);
        if (paramAnonymouso.hJO())
        {
          paramAnonymouso.mn(1002, i.j.sns_ad_video_right_menu_send_friend);
          paramAnonymouso.mn(1003, i.j.sns_ad_video_right_menu_share_sns);
          if (!SnsAdStreamVideoPlayUI.c(SnsAdStreamVideoPlayUI.this)) {
            paramAnonymouso.mn(1004, i.j.sns_ad_video_right_menu_fav);
          }
        }
        AppMethodBeat.o(98451);
      }
    };
    paramBundle.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(98452);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(98452);
          return;
          SnsAdStreamVideoPlayUI.d(SnsAdStreamVideoPlayUI.this);
          AppMethodBeat.o(98452);
          return;
          SnsAdStreamVideoPlayUI.e(SnsAdStreamVideoPlayUI.this);
          AppMethodBeat.o(98452);
          return;
          SnsAdStreamVideoPlayUI.f(SnsAdStreamVideoPlayUI.this);
        }
      }
    };
    paramBundle.XbB = new e.b()
    {
      public final void onDismiss() {}
    };
    addIconOptionMenu(1001, com.tencent.mm.plugin.sns.i.e.actionbar_icon_light_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98453);
        paramBundle.eik();
        AppMethodBeat.o(98453);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98454);
        SnsAdStreamVideoPlayUI.this.finish();
        AppMethodBeat.o(98454);
        return true;
      }
    }, com.tencent.mm.plugin.sns.i.e.actionbar_icon_light_close);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    setActionbarColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.transparent));
    setNavigationbarColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.transparent));
    initView();
    AppMethodBeat.o(98459);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98461);
    if (paramInt == 4)
    {
      finish();
      AppMethodBeat.o(98461);
      return true;
    }
    AppMethodBeat.o(98461);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98463);
    super.onResume();
    if (this.KNB != null) {
      this.KNB.onResume();
    }
    AppMethodBeat.o(98463);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98464);
    super.onStop();
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "pause play");
    this.KNx.pause();
    com.tencent.mm.plugin.sns.ad.f.a.b localb;
    if (this.KNM)
    {
      i = getResources().getConfiguration().orientation;
      this.KNB.aeO(this.KNx.getCurrPosSec());
      this.KNB.JFu.JGJ = Util.currentTicks();
      localb = this.KNB.JFu;
      if (i != 2) {
        break label127;
      }
    }
    label127:
    for (int i = 2;; i = 1)
    {
      localb.JGI = i;
      this.KNB.JFu.JGH = 2;
      if (this.KNB != null) {
        this.KNB.maZ = Util.currentTicks();
      }
      AppMethodBeat.o(98464);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements c.b
  {
    private String mediaId;
    
    public a(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void aYK(String paramString) {}
    
    public final void cq(String paramString, boolean paramBoolean) {}
    
    public final void cr(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(98457);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "download image finish %s", new Object[] { paramString });
        paramString = BitmapUtil.decodeFile(SnsAdStreamVideoPlayUI.a(SnsAdStreamVideoPlayUI.this), null);
        if (paramString != null) {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setCover(paramString);
        }
      }
      AppMethodBeat.o(98457);
    }
    
    public final void fLL() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */