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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.model.x;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.sns.ad.e.f;
import com.tencent.mm.plugin.sns.ad.e.k;
import com.tencent.mm.plugin.sns.ad.e.n.a;
import com.tencent.mm.plugin.sns.ad.e.n.c;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(35)
public class SnsAdStreamVideoPlayUI
  extends MMActivity
  implements i.a, i.b, i.c
{
  private FrameLayout AqI;
  private SnsAdStreamVideoView AqJ;
  private String AqK;
  private boolean AqL;
  private boolean AqM;
  private String AqN;
  private k AqO;
  private String AqP;
  private String AqQ;
  private int AqR;
  private int AqS;
  private String AqT;
  private String AqU;
  private String AqV;
  private long AqW;
  private int AqX;
  private int AqY;
  private boolean AqZ;
  private String aQj;
  private String dIA;
  private String hEW;
  private String hEX;
  private String mediaId;
  private TextView rIh;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private String zRg;
  private int zXJ;
  private p znm;
  
  public SnsAdStreamVideoPlayUI()
  {
    AppMethodBeat.i(98458);
    this.AqO = new k("SnsAdStreamVideoPlayUI");
    this.zRg = "";
    AppMethodBeat.o(98458);
  }
  
  private void QZ(int paramInt)
  {
    AppMethodBeat.i(98465);
    if (this.AqJ != null) {
      this.AqJ.c(paramInt, true);
    }
    AppMethodBeat.o(98465);
  }
  
  public final void aM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98470);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s download finish", new Object[] { paramString });
    this.AqO.zpF = 1;
    AppMethodBeat.o(98470);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void ds(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(98466);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s prepared, video total time %d", new Object[] { paramString2, Integer.valueOf(this.AqJ.getVideoDurationSec()) });
    this.AqJ.eiG();
    if (this.zXJ == 0) {
      this.zXJ = this.AqJ.getVideoDurationSec();
    }
    paramString1 = this.AqO.zpN;
    if (getResources().getConfiguration().orientation == 2) {
      i = 2;
    }
    paramString1.zqS = i;
    this.AqO.zpN.zqT = bu.HQ();
    this.AqO.zpN.zqR = 2;
    this.AqO.zpN.zqP = 0;
    paramString1 = this.AqO.zpN;
    paramString1.zqN += 1;
    this.AqO.zpN.zqT = bu.HQ();
    AppMethodBeat.o(98466);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98467);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s video ended", new Object[] { paramString2 });
    paramString1 = this.AqO.zpN;
    paramString1.zqO += 1;
    this.AqJ.stop();
    this.AqJ.eiD();
    this.AqJ.ATV.stopTimer();
    this.AqJ.setIsShowBasicControls(true);
    AppMethodBeat.o(98467);
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98468);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsAdStreamVideoPlayUI", "%s video paused", new Object[] { paramString2 });
    paramString1 = this.AqO.zpN;
    paramString1.zqP += (int)bu.aO(this.AqO.zpN.zqT);
    AppMethodBeat.o(98468);
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98469);
    this.AqJ.eiE();
    AppMethodBeat.o(98469);
  }
  
  public final void dw(String paramString1, String paramString2) {}
  
  public final void dx(String paramString1, String paramString2) {}
  
  public final void eX(String paramString1, String paramString2) {}
  
  public void finish()
  {
    AppMethodBeat.i(98462);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoPlayUI", "stop play");
    this.AqJ.onUIDestroy();
    this.AqJ.eiG();
    ah.dXz().azQ(this.mediaId);
    if ((this.AqO != null) && (this.zRg != null) && (this.zRg.length() > 0))
    {
      this.AqO.dUY();
      localObject = new Intent();
      ((Intent)localObject).putExtra("KComponentCid", this.zRg);
      ((Intent)localObject).putExtra("KStreamVideoPlayCount", this.AqO.zpJ);
      ((Intent)localObject).putExtra("KStreamVideoPlayCompleteCount", this.AqO.zpK);
      ((Intent)localObject).putExtra("KStreamVideoTotalPlayTimeInMs", this.AqO.zpL);
      setResult(-1, (Intent)localObject);
    }
    if (this.AqS != 0) {
      com.tencent.mm.plugin.sns.ad.e.n.a(n.a.zqo, this.AqQ, this.AqP, this.AqR, this.AqS, this.AqT, this.AqU, this.AqV, this.AqW, this.AqX, this.AqY);
    }
    int i;
    String str;
    int j;
    if (this.AqZ)
    {
      if (this.znm != null) {
        break label402;
      }
      i = 0;
      if (this.znm != null)
      {
        str = this.AqO.dUX();
        long l2 = this.AqO.zpG - this.AqO.ipS;
        long l1 = l2;
        if (l2 < 0L)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsAdStreamVideoPlayUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.AqO.zpG), Long.valueOf(this.AqO.ipS) });
          l1 = this.AqO.zpG;
        }
        j = (int)l1;
        localObject = this.znm.dVi();
        if (localObject != null) {
          break label413;
        }
      }
    }
    label402:
    label413:
    for (Object localObject = "";; localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).zMw)
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(new f(this.aQj, 6, this.AqO.zpG, str, i, j, j, this.znm.ecy().ebR(), this.znm.ecy().ebS(), (String)localObject), 0);
      super.finish();
      AppMethodBeat.o(98462);
      return;
      i = this.znm.ecz();
      break;
    }
  }
  
  public int getForceOrientation()
  {
    if (this.AqL) {
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
    this.AqI = ((FrameLayout)findViewById(2131304241));
    this.AqJ = ((SnsAdStreamVideoView)findViewById(2131306410));
    this.AqI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98455);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setIsShowBasicControls(true);
        if (SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).isPlaying())
        {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).ATV.stopTimer();
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).eiG();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98455);
      }
    });
    this.AqI.setPadding(0, 0, 0, al.en(this));
    this.rIh = ((TextView)findViewById(2131304777));
    Object localObject;
    if (!bu.V(new String[] { this.hEW, this.hEX }))
    {
      this.rIh.setVisibility(0);
      this.rIh.setText(this.hEW);
      this.rIh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98456);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if (SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this) != 0) {
            com.tencent.mm.plugin.sns.ad.e.n.a(n.a.zqm, SnsAdStreamVideoPlayUI.h(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.j(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.k(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.l(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.m(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.n(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.o(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.p(SnsAdStreamVideoPlayUI.this));
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
              paramAnonymousView = com.tencent.mm.plugin.sns.data.r.jo((String)localObject, SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this));
            }
          }
          localIntent.putExtra("jsapiargs", localBundle);
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("useJs", true);
          if (SnsAdStreamVideoPlayUI.s(SnsAdStreamVideoPlayUI.this)) {
            com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(0, 6, SnsAdStreamVideoPlayUI.t(SnsAdStreamVideoPlayUI.this).field_snsId, 18, 0));
          }
          com.tencent.mm.plugin.sns.c.a.iUz.i(localIntent, SnsAdStreamVideoPlayUI.this);
          SnsAdStreamVideoPlayUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98456);
        }
      });
      this.AqJ.setReporter(this);
      this.AqJ.setIMMVideoViewCallback(this);
      this.AqJ.setIMMDownloadFinish(this);
      this.AqJ.setRootPath(ah.getSnsAdPath());
      this.AqJ.c(false, this.AqK, 0);
      this.AqJ.setScaleType(i.e.Flj);
      this.AqJ.setIOnlineVideoProxy(new com.tencent.mm.plugin.sns.model.ae());
      if ((bu.isNullOrNil(this.thumbPath)) || (!o.fB(this.thumbPath))) {
        break label314;
      }
      localObject = com.tencent.mm.sdk.platformtools.h.decodeFile(this.thumbPath, null);
      if (localObject == null) {
        break label314;
      }
      this.AqJ.setCover((Bitmap)localObject);
      label247:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoPlayUI", "start play");
      if (!this.AqJ.isPlaying())
      {
        if (this.AqJ.getCurrPosSec() != this.AqJ.getVideoDurationSec()) {
          break label502;
        }
        QZ(0);
      }
    }
    for (;;)
    {
      this.AqJ.start();
      AppMethodBeat.o(98460);
      return;
      this.rIh.setVisibility(8);
      break;
      label314:
      String str = "attach" + this.mediaId;
      localObject = ap.jv(ah.getSnsAdPath(), str);
      str = com.tencent.mm.plugin.sns.data.r.azi(str);
      this.thumbPath = ((String)localObject + str);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoPlayUI", "try download thumb img %s, save to %s", new Object[] { this.mediaId, this.thumbPath });
      bzh localbzh = com.tencent.mm.modelsns.h.a(this.thumbPath, 2, this.thumbUrl, this.thumbUrl, 1, 1, "");
      com.tencent.mm.plugin.sns.data.n localn = new com.tencent.mm.plugin.sns.data.n(localbzh);
      localn.zui = 3;
      localn.dyb = localbzh.Id;
      ah.dXz().a(new a(localbzh.Id));
      c localc = ah.dXz();
      bk localbk = bk.fvn();
      localbk.heF = ((int)(System.currentTimeMillis() / 1000L));
      localc.a(localbzh, 8, localn, localbk, (String)localObject, str);
      break label247;
      label502:
      QZ(this.AqJ.getCurrPosSec());
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
        Iterator localIterator = bu.U(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoPlayUI", "send sight to %s", new Object[] { str2 });
          localObject1 = new k.b();
          ((k.b)localObject1).title = this.AqN;
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
          if (!bu.isNullOrNil(this.url))
          {
            ((k.b)localObject1).url = this.url;
            ((k.b)localObject1).thumburl = this.thumbUrl;
            ((k.b)localObject1).hET = this.AqK;
            ((k.b)localObject1).hEU = this.zXJ;
            ((k.b)localObject1).hEV = this.AqN;
            ((k.b)localObject1).hEX = this.hEX;
            ((k.b)localObject1).hEW = this.hEW;
            ((k.b)localObject1).hEY = this.thumbUrl;
            ((k.b)localObject1).hEZ = this.AqP;
            ((k.b)localObject1).hFa = this.AqQ;
            ((k.b)localObject1).dIA = this.dIA;
            localObject2 = o.bb(this.thumbPath, 0, -1);
            if (localObject2 != null) {
              break label474;
            }
            i = 0;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoPlayUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.azs() != null) {
              w.a.azs().a((k.b)localObject1, "", "", str2, "", (byte[])localObject2);
            }
            com.tencent.mm.plugin.messenger.a.g.doC().hW(str1, str2);
            if (this.AqZ) {
              com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(0, 6, this.znm.field_snsId, 12, 0));
            }
            if (this.AqS == 0) {
              continue;
            }
            boolean bool = x.wb(str2);
            if (!bool) {
              break label482;
            }
            localObject1 = n.c.zqA;
            localObject2 = this.AqQ;
            str3 = this.AqP;
            j = this.AqR;
            k = this.AqS;
            str4 = this.AqT;
            str5 = this.AqU;
            str6 = this.AqV;
            l = this.AqW;
            m = this.AqX;
            n = this.AqY;
            if (!bool) {
              break label490;
            }
          }
          label474:
          label482:
          label490:
          for (int i = com.tencent.mm.model.r.zC(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.ad.e.n.a((n.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject1).url = this.AqK;
            break label137;
            i = localObject2.length;
            break label246;
            localObject1 = n.c.zqz;
            break label360;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
      }
    }
    else if (998 == paramInt1)
    {
      if (this.AqS != 0) {
        com.tencent.mm.plugin.sns.ad.e.n.a(n.c.zqB, this.AqQ, this.AqP, this.AqR, this.AqS, this.AqT, this.AqU, this.AqV, this.AqW, this.AqX, this.AqY, 0);
      }
      if (-1 != paramInt2) {
        break label650;
      }
      if (this.AqZ) {
        com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(0, 6, this.znm.field_snsId, 15, 0));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(98471);
      return;
      if (!this.AqZ) {
        break;
      }
      com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(0, 6, this.znm.field_snsId, 13, 0));
      break;
      label650:
      if (this.AqZ) {
        com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(0, 6, this.znm.field_snsId, 16, 0));
      }
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(98459);
    super.onCreate(paramBundle);
    this.url = getIntent().getStringExtra("KUrl");
    this.AqK = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.thumbPath = getIntent().getStringExtra("KThumbPath");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.AqL = getIntent().getBooleanExtra("ForceLandscape", false);
    this.AqM = getIntent().getBooleanExtra("KBlockFav", false);
    this.AqN = bu.bI(getIntent().getStringExtra("KMediaTitle"), "");
    this.zXJ = getIntent().getIntExtra("KMediaVideoTime", 0);
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.znm = ah.dXE().aBq(com.tencent.mm.plugin.sns.data.r.azz(paramBundle));
    this.AqZ = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.AqO.zpH = bu.HQ();
    this.zRg = getIntent().getStringExtra("KComponentCid");
    this.AqP = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.AqQ = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.AqR = getIntent().getIntExtra("KSta_SourceType", 0);
    this.AqS = getIntent().getIntExtra("KSta_Scene", 0);
    this.AqT = getIntent().getStringExtra("KSta_FromUserName");
    this.AqU = getIntent().getStringExtra("KSta_ChatName");
    this.AqV = getIntent().getStringExtra("KSta_SnSId");
    this.AqW = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.AqX = getIntent().getIntExtra("KSta_FavID", 0);
    this.AqY = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.dIA = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.aQj = bu.bI(getIntent().getStringExtra("KViewId"), "");
    this.hEW = getIntent().getStringExtra("StreamWording");
    this.hEX = getIntent().getStringExtra("StremWebUrl");
    setMMTitle("");
    paramBundle = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    paramBundle.LfS = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(98451);
        if (paramAnonymousl.fCR())
        {
          paramAnonymousl.jM(1002, 2131763770);
          paramAnonymousl.jM(1003, 2131763771);
          if (!SnsAdStreamVideoPlayUI.c(SnsAdStreamVideoPlayUI.this)) {
            paramAnonymousl.jM(1004, 2131763769);
          }
        }
        AppMethodBeat.o(98451);
      }
    };
    paramBundle.LfT = new n.e()
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
    paramBundle.KtV = new e.b()
    {
      public final void onDismiss() {}
    };
    addIconOptionMenu(1001, 2131230853, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98453);
        paramBundle.cPF();
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
    if (this.AqO != null) {
      this.AqO.onResume();
    }
    AppMethodBeat.o(98463);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98464);
    super.onStop();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoPlayUI", "pause play");
    this.AqJ.pause();
    com.tencent.mm.plugin.sns.ad.e.a.a locala;
    if (this.AqZ)
    {
      i = getResources().getConfiguration().orientation;
      this.AqO.Qf(this.AqJ.getCurrPosSec());
      this.AqO.zpN.zqT = bu.HQ();
      locala = this.AqO.zpN;
      if (i != 2) {
        break label127;
      }
    }
    label127:
    for (int i = 2;; i = 1)
    {
      locala.zqS = i;
      this.AqO.zpN.zqR = 2;
      if (this.AqO != null) {
        this.AqO.ipR = bu.HQ();
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
  
  public final void rd(long paramLong) {}
  
  public final void vG(String paramString) {}
  
  final class a
    implements c.b
  {
    private String mediaId;
    
    public a(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void azJ(String paramString) {}
    
    public final void bQ(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(98457);
      if ((!bu.V(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoPlayUI", "download image finish %s", new Object[] { paramString });
        paramString = com.tencent.mm.sdk.platformtools.h.decodeFile(SnsAdStreamVideoPlayUI.a(SnsAdStreamVideoPlayUI.this), null);
        if (paramString != null) {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setCover(paramString);
        }
      }
      AppMethodBeat.o(98457);
    }
    
    public final void bR(String paramString, boolean paramBoolean) {}
    
    public final void dWB() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */