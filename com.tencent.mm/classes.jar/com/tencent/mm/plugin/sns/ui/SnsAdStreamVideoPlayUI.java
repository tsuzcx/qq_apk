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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.sns.ad.d.f;
import com.tencent.mm.plugin.sns.ad.d.j;
import com.tencent.mm.plugin.sns.ad.d.m.a;
import com.tencent.mm.plugin.sns.ad.d.m.c;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(35)
public class SnsAdStreamVideoPlayUI
  extends MMActivity
  implements i.a, i.b, i.c
{
  private String aQj;
  private String dHv;
  private String hCh;
  private String hCi;
  private String mediaId;
  private TextView rzW;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private p yXF;
  private String zAg;
  private int zGB;
  private String zZA;
  private j zZB;
  private String zZC;
  private String zZD;
  private int zZE;
  private int zZF;
  private String zZG;
  private String zZH;
  private String zZI;
  private long zZJ;
  private int zZK;
  private int zZL;
  private boolean zZM;
  private FrameLayout zZv;
  private SnsAdStreamVideoView zZw;
  private String zZx;
  private boolean zZy;
  private boolean zZz;
  
  public SnsAdStreamVideoPlayUI()
  {
    AppMethodBeat.i(98458);
    this.zZB = new j("SnsAdStreamVideoPlayUI");
    this.zAg = "";
    AppMethodBeat.o(98458);
  }
  
  private void Qs(int paramInt)
  {
    AppMethodBeat.i(98465);
    if (this.zZw != null) {
      this.zZw.c(paramInt, true);
    }
    AppMethodBeat.o(98465);
  }
  
  public final void aK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98470);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s download finish", new Object[] { paramString });
    this.zZB.yZe = 1;
    AppMethodBeat.o(98470);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dq(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(98466);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s prepared, video total time %d", new Object[] { paramString2, Integer.valueOf(this.zZw.getVideoDurationSec()) });
    this.zZw.eeZ();
    if (this.zGB == 0) {
      this.zGB = this.zZw.getVideoDurationSec();
    }
    paramString1 = this.zZB.yZm;
    if (getResources().getConfiguration().orientation == 2) {
      i = 2;
    }
    paramString1.zar = i;
    this.zZB.yZm.zas = bt.HI();
    this.zZB.yZm.zaq = 2;
    this.zZB.yZm.zao = 0;
    paramString1 = this.zZB.yZm;
    paramString1.zam += 1;
    this.zZB.yZm.zas = bt.HI();
    AppMethodBeat.o(98466);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98467);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s video ended", new Object[] { paramString2 });
    paramString1 = this.zZB.yZm;
    paramString1.zan += 1;
    this.zZw.stop();
    this.zZw.eeW();
    this.zZw.ACu.stopTimer();
    this.zZw.setIsShowBasicControls(true);
    AppMethodBeat.o(98467);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98468);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsAdStreamVideoPlayUI", "%s video paused", new Object[] { paramString2 });
    paramString1 = this.zZB.yZm;
    paramString1.zao += (int)bt.aO(this.zZB.yZm.zas);
    AppMethodBeat.o(98468);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98469);
    this.zZw.eeX();
    AppMethodBeat.o(98469);
  }
  
  public final void du(String paramString1, String paramString2) {}
  
  public final void dv(String paramString1, String paramString2) {}
  
  public final void eT(String paramString1, String paramString2) {}
  
  public void finish()
  {
    AppMethodBeat.i(98462);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "stop play");
    this.zZw.onUIDestroy();
    this.zZw.eeZ();
    ag.dTZ().ayz(this.mediaId);
    if ((this.zZB != null) && (this.zAg != null) && (this.zAg.length() > 0))
    {
      this.zZB.dRA();
      localObject = new Intent();
      ((Intent)localObject).putExtra("KComponentCid", this.zAg);
      ((Intent)localObject).putExtra("KStreamVideoPlayCount", this.zZB.yZi);
      ((Intent)localObject).putExtra("KStreamVideoPlayCompleteCount", this.zZB.yZj);
      ((Intent)localObject).putExtra("KStreamVideoTotalPlayTimeInMs", this.zZB.yZk);
      setResult(-1, (Intent)localObject);
    }
    if (this.zZF != 0) {
      com.tencent.mm.plugin.sns.ad.d.m.a(m.a.yZN, this.zZD, this.zZC, this.zZE, this.zZF, this.zZG, this.zZH, this.zZI, this.zZJ, this.zZK, this.zZL);
    }
    int i;
    String str;
    int j;
    if (this.zZM)
    {
      if (this.yXF != null) {
        break label402;
      }
      i = 0;
      if (this.yXF != null)
      {
        str = this.zZB.dRz();
        long l2 = this.zZB.yZf - this.zZB.imY;
        long l1 = l2;
        if (l2 < 0L)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsAdStreamVideoPlayUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.zZB.yZf), Long.valueOf(this.zZB.imY) });
          l1 = this.zZB.yZf;
        }
        j = (int)l1;
        localObject = this.yXF.dRK();
        if (localObject != null) {
          break label413;
        }
      }
    }
    label402:
    label413:
    for (Object localObject = "";; localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).zvb)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(new f(this.aQj, 6, this.zZB.yZf, str, i, j, j, this.yXF.dYU().dYn(), this.yXF.dYU().dYo(), (String)localObject), 0);
      super.finish();
      AppMethodBeat.o(98462);
      return;
      i = this.yXF.dYV();
      break;
    }
  }
  
  public int getForceOrientation()
  {
    if (this.zZy) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return 2131495518;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98460);
    this.zZv = ((FrameLayout)findViewById(2131304241));
    this.zZw = ((SnsAdStreamVideoView)findViewById(2131306410));
    this.zZv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98455);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setIsShowBasicControls(true);
        if (SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).isPlaying())
        {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).ACu.stopTimer();
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).eeZ();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98455);
      }
    });
    this.zZv.setPadding(0, 0, 0, al.ej(this));
    this.rzW = ((TextView)findViewById(2131304777));
    Object localObject;
    if (!bt.V(new String[] { this.hCh, this.hCi }))
    {
      this.rzW.setVisibility(0);
      this.rzW.setText(this.hCh);
      this.rzW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98456);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if (SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this) != 0) {
            com.tencent.mm.plugin.sns.ad.d.m.a(m.a.yZL, SnsAdStreamVideoPlayUI.h(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.j(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.k(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.l(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.m(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.n(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.o(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.p(SnsAdStreamVideoPlayUI.this));
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
              paramAnonymousView = com.tencent.mm.plugin.sns.data.q.jh((String)localObject, SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this));
            }
          }
          localIntent.putExtra("jsapiargs", localBundle);
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("useJs", true);
          if (SnsAdStreamVideoPlayUI.s(SnsAdStreamVideoPlayUI.this)) {
            com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, SnsAdStreamVideoPlayUI.t(SnsAdStreamVideoPlayUI.this).field_snsId, 18, 0));
          }
          com.tencent.mm.plugin.sns.c.a.iRG.i(localIntent, SnsAdStreamVideoPlayUI.this);
          SnsAdStreamVideoPlayUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98456);
        }
      });
      this.zZw.setReporter(this);
      this.zZw.setIMMVideoViewCallback(this);
      this.zZw.setIMMDownloadFinish(this);
      this.zZw.setRootPath(ag.getSnsAdPath());
      this.zZw.c(false, this.zZx, 0);
      this.zZw.setScaleType(i.e.ESO);
      this.zZw.setIOnlineVideoProxy(new com.tencent.mm.plugin.sns.model.ad());
      if ((bt.isNullOrNil(this.thumbPath)) || (!i.fv(this.thumbPath))) {
        break label314;
      }
      localObject = com.tencent.mm.sdk.platformtools.g.decodeFile(this.thumbPath, null);
      if (localObject == null) {
        break label314;
      }
      this.zZw.setCover((Bitmap)localObject);
      label247:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "start play");
      if (!this.zZw.isPlaying())
      {
        if (this.zZw.getCurrPosSec() != this.zZw.getVideoDurationSec()) {
          break label502;
        }
        Qs(0);
      }
    }
    for (;;)
    {
      this.zZw.start();
      AppMethodBeat.o(98460);
      return;
      this.rzW.setVisibility(8);
      break;
      label314:
      String str = "attach" + this.mediaId;
      localObject = ao.jo(ag.getSnsAdPath(), str);
      str = com.tencent.mm.plugin.sns.data.q.axR(str);
      this.thumbPath = ((String)localObject + str);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "try download thumb img %s, save to %s", new Object[] { this.mediaId, this.thumbPath });
      byn localbyn = h.a(this.thumbPath, 2, this.thumbUrl, this.thumbUrl, 1, 1, "");
      com.tencent.mm.plugin.sns.data.m localm = new com.tencent.mm.plugin.sns.data.m(localbyn);
      localm.zds = 3;
      localm.dwW = localbyn.Id;
      ag.dTZ().a(new a(localbyn.Id));
      com.tencent.mm.plugin.sns.model.b localb = ag.dTZ();
      bj localbj = bj.frn();
      localbj.hbR = ((int)(System.currentTimeMillis() / 1000L));
      localb.a(localbyn, 8, localm, localbj, (String)localObject, str);
      break label247;
      label502:
      Qs(this.zZw.getCurrPosSec());
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
        Iterator localIterator = bt.U(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "send sight to %s", new Object[] { str2 });
          localObject1 = new k.b();
          ((k.b)localObject1).title = this.zZA;
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
          if (!bt.isNullOrNil(this.url))
          {
            ((k.b)localObject1).url = this.url;
            ((k.b)localObject1).thumburl = this.thumbUrl;
            ((k.b)localObject1).hCe = this.zZx;
            ((k.b)localObject1).hCf = this.zGB;
            ((k.b)localObject1).hCg = this.zZA;
            ((k.b)localObject1).hCi = this.hCi;
            ((k.b)localObject1).hCh = this.hCh;
            ((k.b)localObject1).hCj = this.thumbUrl;
            ((k.b)localObject1).hCk = this.zZC;
            ((k.b)localObject1).hCl = this.zZD;
            ((k.b)localObject1).dHv = this.dHv;
            localObject2 = i.aY(this.thumbPath, 0, -1);
            if (localObject2 != null) {
              break label474;
            }
            i = 0;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.azd() != null) {
              w.a.azd().a((k.b)localObject1, "", "", str2, "", (byte[])localObject2);
            }
            com.tencent.mm.plugin.messenger.a.g.dlD().hP(str1, str2);
            if (this.zZM) {
              com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.yXF.field_snsId, 12, 0));
            }
            if (this.zZF == 0) {
              continue;
            }
            boolean bool = com.tencent.mm.model.w.vF(str2);
            if (!bool) {
              break label482;
            }
            localObject1 = m.c.yZZ;
            localObject2 = this.zZD;
            str3 = this.zZC;
            j = this.zZE;
            k = this.zZF;
            str4 = this.zZG;
            str5 = this.zZH;
            str6 = this.zZI;
            l = this.zZJ;
            m = this.zZK;
            n = this.zZL;
            if (!bool) {
              break label490;
            }
          }
          label474:
          label482:
          label490:
          for (int i = com.tencent.mm.model.q.yS(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.ad.d.m.a((m.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject1).url = this.zZx;
            break label137;
            i = localObject2.length;
            break label246;
            localObject1 = m.c.yZY;
            break label360;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
      }
    }
    else if (998 == paramInt1)
    {
      if (this.zZF != 0) {
        com.tencent.mm.plugin.sns.ad.d.m.a(m.c.zaa, this.zZD, this.zZC, this.zZE, this.zZF, this.zZG, this.zZH, this.zZI, this.zZJ, this.zZK, this.zZL, 0);
      }
      if (-1 != paramInt2) {
        break label650;
      }
      if (this.zZM) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.yXF.field_snsId, 15, 0));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(98471);
      return;
      if (!this.zZM) {
        break;
      }
      com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.yXF.field_snsId, 13, 0));
      break;
      label650:
      if (this.zZM) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.yXF.field_snsId, 16, 0));
      }
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(98459);
    super.onCreate(paramBundle);
    this.url = getIntent().getStringExtra("KUrl");
    this.zZx = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.thumbPath = getIntent().getStringExtra("KThumbPath");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.zZy = getIntent().getBooleanExtra("ForceLandscape", false);
    this.zZz = getIntent().getBooleanExtra("KBlockFav", false);
    this.zZA = bt.bI(getIntent().getStringExtra("KMediaTitle"), "");
    this.zGB = getIntent().getIntExtra("KMediaVideoTime", 0);
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.yXF = ag.dUe().azZ(com.tencent.mm.plugin.sns.data.q.ayi(paramBundle));
    this.zZM = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.zZB.yZg = bt.HI();
    this.zAg = getIntent().getStringExtra("KComponentCid");
    this.zZC = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.zZD = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.zZE = getIntent().getIntExtra("KSta_SourceType", 0);
    this.zZF = getIntent().getIntExtra("KSta_Scene", 0);
    this.zZG = getIntent().getStringExtra("KSta_FromUserName");
    this.zZH = getIntent().getStringExtra("KSta_ChatName");
    this.zZI = getIntent().getStringExtra("KSta_SnSId");
    this.zZJ = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.zZK = getIntent().getIntExtra("KSta_FavID", 0);
    this.zZL = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.dHv = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.aQj = bt.bI(getIntent().getStringExtra("KViewId"), "");
    this.hCh = getIntent().getStringExtra("StreamWording");
    this.hCi = getIntent().getStringExtra("StremWebUrl");
    setMMTitle("");
    paramBundle = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    paramBundle.KJy = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(98451);
        if (paramAnonymousl.fyP())
        {
          paramAnonymousl.jI(1002, 2131763770);
          paramAnonymousl.jI(1003, 2131763771);
          if (!SnsAdStreamVideoPlayUI.c(SnsAdStreamVideoPlayUI.this)) {
            paramAnonymousl.jI(1004, 2131763769);
          }
        }
        AppMethodBeat.o(98451);
      }
    };
    paramBundle.KJz = new n.e()
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
    paramBundle.JXC = new e.b()
    {
      public final void onDismiss() {}
    };
    addIconOptionMenu(1001, 2131230853, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98453);
        paramBundle.cMW();
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
    }, 2131230851);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    setActionbarColor(getResources().getColor(2131101053));
    setNavigationbarColor(getResources().getColor(2131101053));
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
    if (this.zZB != null) {
      this.zZB.onResume();
    }
    AppMethodBeat.o(98463);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98464);
    super.onStop();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "pause play");
    this.zZw.pause();
    com.tencent.mm.plugin.sns.ad.d.a.a locala;
    if (this.zZM)
    {
      i = getResources().getConfiguration().orientation;
      this.zZB.Py(this.zZw.getCurrPosSec());
      this.zZB.yZm.zas = bt.HI();
      locala = this.zZB.yZm;
      if (i != 2) {
        break label127;
      }
    }
    label127:
    for (int i = 2;; i = 1)
    {
      locala.zar = i;
      this.zZB.yZm.zaq = 2;
      if (this.zZB != null) {
        this.zZB.imX = bt.HI();
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
  
  public final void qQ(long paramLong) {}
  
  public final void vk(String paramString) {}
  
  final class a
    implements b.b
  {
    private String mediaId;
    
    public a(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void ays(String paramString) {}
    
    public final void bM(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(98457);
      if ((!bt.V(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "download image finish %s", new Object[] { paramString });
        paramString = com.tencent.mm.sdk.platformtools.g.decodeFile(SnsAdStreamVideoPlayUI.a(SnsAdStreamVideoPlayUI.this), null);
        if (paramString != null) {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setCover(paramString);
        }
      }
      AppMethodBeat.o(98457);
    }
    
    public final void bN(String paramString, boolean paramBoolean) {}
    
    public final void dTb() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */