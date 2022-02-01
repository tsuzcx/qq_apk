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
import com.tencent.mm.plugin.sns.a.b.m.a;
import com.tencent.mm.plugin.sns.a.b.m.c;
import com.tencent.mm.plugin.sns.model.ac;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(35)
public class SnsAdStreamVideoPlayUI
  extends MMActivity
  implements h.a, h.b, h.c
{
  private String dAM;
  private String dxG;
  private String gJy;
  private String gJz;
  private String mediaId;
  private TextView qhu;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private String wWE;
  private p wwP;
  private int xcL;
  private int xvA;
  private int xvB;
  private boolean xvC;
  private FrameLayout xvl;
  private SnsAdStreamVideoView xvm;
  private String xvn;
  private boolean xvo;
  private boolean xvp;
  private String xvq;
  private com.tencent.mm.plugin.sns.a.b.j xvr;
  private String xvs;
  private String xvt;
  private int xvu;
  private int xvv;
  private String xvw;
  private String xvx;
  private String xvy;
  private long xvz;
  
  public SnsAdStreamVideoPlayUI()
  {
    AppMethodBeat.i(98458);
    this.xvr = new com.tencent.mm.plugin.sns.a.b.j("SnsAdStreamVideoPlayUI");
    this.wWE = "";
    AppMethodBeat.o(98458);
  }
  
  private void MI(int paramInt)
  {
    AppMethodBeat.i(98465);
    if (this.xvm != null) {
      this.xvm.c(paramInt, true);
    }
    AppMethodBeat.o(98465);
  }
  
  public final void aH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98470);
    ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s download finish", new Object[] { paramString });
    this.xvr.wyo = 1;
    AppMethodBeat.o(98470);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void db(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(98466);
    ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s prepared, video total time %d", new Object[] { paramString2, Integer.valueOf(this.xvm.getVideoDurationSec()) });
    this.xvm.dEg();
    if (this.xcL == 0) {
      this.xcL = this.xvm.getVideoDurationSec();
    }
    paramString1 = this.xvr.wyw;
    if (getResources().getConfiguration().orientation == 2) {
      i = 2;
    }
    paramString1.wzB = i;
    this.xvr.wyw.wzC = bt.GC();
    this.xvr.wyw.wzA = 2;
    this.xvr.wyw.wzy = 0;
    paramString1 = this.xvr.wyw;
    paramString1.wzw += 1;
    this.xvr.wyw.wzC = bt.GC();
    AppMethodBeat.o(98466);
  }
  
  public final void dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98467);
    ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s video ended", new Object[] { paramString2 });
    paramString1 = this.xvr.wyw;
    paramString1.wzx += 1;
    this.xvm.stop();
    this.xvm.dEd();
    this.xvm.xXA.stopTimer();
    this.xvm.setIsShowBasicControls(true);
    AppMethodBeat.o(98467);
  }
  
  public final void dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98468);
    ad.d("MicroMsg.SnsAdStreamVideoPlayUI", "%s video paused", new Object[] { paramString2 });
    paramString1 = this.xvr.wyw;
    paramString1.wzy += (int)bt.aS(this.xvr.wyw.wzC);
    AppMethodBeat.o(98468);
  }
  
  public final void de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98469);
    this.xvm.dEe();
    AppMethodBeat.o(98469);
  }
  
  public final void dg(String paramString1, String paramString2) {}
  
  public final void dh(String paramString1, String paramString2) {}
  
  public void finish()
  {
    AppMethodBeat.i(98462);
    ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "stop play");
    this.xvm.onUIDestroy();
    this.xvm.dEg();
    af.dtp().aoi(this.mediaId);
    if ((this.xvr != null) && (this.wWE != null) && (this.wWE.length() > 0))
    {
      this.xvr.drw();
      localObject = new Intent();
      ((Intent)localObject).putExtra("KComponentCid", this.wWE);
      ((Intent)localObject).putExtra("KStreamVideoPlayCount", this.xvr.wys);
      ((Intent)localObject).putExtra("KStreamVideoPlayCompleteCount", this.xvr.wyt);
      ((Intent)localObject).putExtra("KStreamVideoTotalPlayTimeInMs", this.xvr.wyu);
      setResult(-1, (Intent)localObject);
    }
    if (this.xvv != 0) {
      com.tencent.mm.plugin.sns.a.b.m.a(m.a.wyX, this.xvt, this.xvs, this.xvu, this.xvv, this.xvw, this.xvx, this.xvy, this.xvz, this.xvA, this.xvB);
    }
    int i;
    String str;
    int j;
    if (this.xvC)
    {
      if (this.wwP != null) {
        break label402;
      }
      i = 0;
      if (this.wwP != null)
      {
        str = this.xvr.drv();
        long l2 = this.xvr.wyp - this.xvr.htc;
        long l1 = l2;
        if (l2 < 0L)
        {
          ad.e("MicroMsg.SnsAdStreamVideoPlayUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.xvr.wyp), Long.valueOf(this.xvr.htc) });
          l1 = this.xvr.wyp;
        }
        j = (int)l1;
        localObject = this.wwP.dxu();
        if (localObject != null) {
          break label413;
        }
      }
    }
    label402:
    label413:
    for (Object localObject = "";; localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).wSu)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.sns.a.b.f(this.dAM, 6, this.xvr.wyp, str, i, j, j, this.wwP.dyh().dxA(), this.wwP.dyh().dxB(), (String)localObject), 0);
      super.finish();
      AppMethodBeat.o(98462);
      return;
      i = this.wwP.dyi();
      break;
    }
  }
  
  public int getForceOrientation()
  {
    if (this.xvo) {
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
    this.xvl = ((FrameLayout)findViewById(2131304241));
    this.xvm = ((SnsAdStreamVideoView)findViewById(2131306410));
    this.xvl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98455);
        SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setIsShowBasicControls(true);
        if (SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).isPlaying())
        {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).xXA.stopTimer();
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).dEg();
        }
        AppMethodBeat.o(98455);
      }
    });
    this.xvl.setPadding(0, 0, 0, ai.eb(this));
    this.qhu = ((TextView)findViewById(2131304777));
    Object localObject;
    if (!bt.T(new String[] { this.gJy, this.gJz }))
    {
      this.qhu.setVisibility(0);
      this.qhu.setText(this.gJy);
      this.qhu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98456);
          if (SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this) != 0) {
            com.tencent.mm.plugin.sns.a.b.m.a(m.a.wyV, SnsAdStreamVideoPlayUI.h(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.j(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.k(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.l(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.m(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.n(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.o(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.p(SnsAdStreamVideoPlayUI.this));
          }
          Intent localIntent = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("key_snsad_statextstr", SnsAdStreamVideoPlayUI.q(SnsAdStreamVideoPlayUI.this));
          String str = SnsAdStreamVideoPlayUI.r(SnsAdStreamVideoPlayUI.this);
          paramAnonymousView = str;
          if (SnsAdStreamVideoPlayUI.s(SnsAdStreamVideoPlayUI.this))
          {
            paramAnonymousView = str;
            if (!TextUtils.isEmpty(SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this))) {
              paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iy(str, SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this));
            }
          }
          localIntent.putExtra("jsapiargs", localBundle);
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("useJs", true);
          if (SnsAdStreamVideoPlayUI.s(SnsAdStreamVideoPlayUI.this)) {
            com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, SnsAdStreamVideoPlayUI.t(SnsAdStreamVideoPlayUI.this).field_snsId, 18, 0));
          }
          com.tencent.mm.plugin.sns.d.a.hYt.i(localIntent, SnsAdStreamVideoPlayUI.this);
          SnsAdStreamVideoPlayUI.this.finish();
          AppMethodBeat.o(98456);
        }
      });
      this.xvm.setReporter(this);
      this.xvm.setIMMVideoViewCallback(this);
      this.xvm.setIMMDownloadFinish(this);
      this.xvm.setRootPath(af.getSnsAdPath());
      this.xvm.c(false, this.xvn, 0);
      this.xvm.setScaleType(h.e.BVs);
      this.xvm.setIOnlineVideoProxy(new ac());
      if ((bt.isNullOrNil(this.thumbPath)) || (!i.eK(this.thumbPath))) {
        break label314;
      }
      localObject = com.tencent.mm.sdk.platformtools.f.decodeFile(this.thumbPath, null);
      if (localObject == null) {
        break label314;
      }
      this.xvm.setCover((Bitmap)localObject);
      label247:
      ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "start play");
      if (!this.xvm.isPlaying())
      {
        if (this.xvm.getCurrPosSec() != this.xvm.getVideoDurationSec()) {
          break label502;
        }
        MI(0);
      }
    }
    for (;;)
    {
      this.xvm.start();
      AppMethodBeat.o(98460);
      return;
      this.qhu.setVisibility(8);
      break;
      label314:
      String str = "attach" + this.mediaId;
      localObject = an.iF(af.getSnsAdPath(), str);
      str = com.tencent.mm.plugin.sns.data.q.anA(str);
      this.thumbPath = ((String)localObject + str);
      ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "try download thumb img %s, save to %s", new Object[] { this.mediaId, this.thumbPath });
      bpi localbpi = com.tencent.mm.modelsns.g.a(this.thumbPath, 2, this.thumbUrl, this.thumbUrl, 1, 1, "");
      com.tencent.mm.plugin.sns.data.m localm = new com.tencent.mm.plugin.sns.data.m(localbpi);
      localm.wBd = 3;
      localm.dnB = localbpi.Id;
      af.dtp().a(new a(localbpi.Id));
      com.tencent.mm.plugin.sns.model.b localb = af.dtp();
      bc localbc = bc.eLG();
      localbc.tGD = ((int)(System.currentTimeMillis() / 1000L));
      localb.a(localbpi, 8, localm, localbc, (String)localObject, str);
      break label247;
      label502:
      MI(this.xvm.getCurrPosSec());
    }
  }
  
  public final void jw(String paramString1, String paramString2) {}
  
  public final void ln(long paramLong) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98471);
    if (999 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = bt.S(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "send sight to %s", new Object[] { str2 });
          localObject1 = new k.b();
          ((k.b)localObject1).title = this.xvq;
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
            ((k.b)localObject1).gJv = this.xvn;
            ((k.b)localObject1).gJw = this.xcL;
            ((k.b)localObject1).gJx = this.xvq;
            ((k.b)localObject1).gJz = this.gJz;
            ((k.b)localObject1).gJy = this.gJy;
            ((k.b)localObject1).gJA = this.thumbUrl;
            ((k.b)localObject1).gJB = this.xvs;
            ((k.b)localObject1).gJC = this.xvt;
            ((k.b)localObject1).dxG = this.dxG;
            localObject2 = i.aR(this.thumbPath, 0, -1);
            if (localObject2 != null) {
              break label474;
            }
            i = 0;
            ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.apB() != null) {
              w.a.apB().a((k.b)localObject1, "", "", str2, "", (byte[])localObject2);
            }
            com.tencent.mm.plugin.messenger.a.j.cOB().hm(str1, str2);
            if (this.xvC) {
              com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.wwP.field_snsId, 12, 0));
            }
            if (this.xvv == 0) {
              continue;
            }
            boolean bool = com.tencent.mm.model.w.pF(str2);
            if (!bool) {
              break label482;
            }
            localObject1 = m.c.wzj;
            localObject2 = this.xvt;
            str3 = this.xvs;
            j = this.xvu;
            k = this.xvv;
            str4 = this.xvw;
            str5 = this.xvx;
            str6 = this.xvy;
            l = this.xvz;
            m = this.xvA;
            n = this.xvB;
            if (!bool) {
              break label490;
            }
          }
          label474:
          label482:
          label490:
          for (int i = com.tencent.mm.model.q.rY(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.a.b.m.a((m.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject1).url = this.xvn;
            break label137;
            i = localObject2.length;
            break label246;
            localObject1 = m.c.wzi;
            break label360;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
      }
    }
    else if (998 == paramInt1)
    {
      if (this.xvv != 0) {
        com.tencent.mm.plugin.sns.a.b.m.a(m.c.wzk, this.xvt, this.xvs, this.xvu, this.xvv, this.xvw, this.xvx, this.xvy, this.xvz, this.xvA, this.xvB, 0);
      }
      if (-1 != paramInt2) {
        break label650;
      }
      if (this.xvC) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.wwP.field_snsId, 15, 0));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(98471);
      return;
      if (!this.xvC) {
        break;
      }
      com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.wwP.field_snsId, 13, 0));
      break;
      label650:
      if (this.xvC) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.wwP.field_snsId, 16, 0));
      }
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(98459);
    super.onCreate(paramBundle);
    this.url = getIntent().getStringExtra("KUrl");
    this.xvn = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.thumbPath = getIntent().getStringExtra("KThumbPath");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.xvo = getIntent().getBooleanExtra("ForceLandscape", false);
    this.xvp = getIntent().getBooleanExtra("KBlockFav", false);
    this.xvq = bt.by(getIntent().getStringExtra("KMediaTitle"), "");
    this.xcL = getIntent().getIntExtra("KMediaVideoTime", 0);
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.wwP = af.dtu().apJ(com.tencent.mm.plugin.sns.data.q.anR(paramBundle));
    this.xvC = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.xvr.wyq = bt.GC();
    this.wWE = getIntent().getStringExtra("KComponentCid");
    this.xvs = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.xvt = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.xvu = getIntent().getIntExtra("KSta_SourceType", 0);
    this.xvv = getIntent().getIntExtra("KSta_Scene", 0);
    this.xvw = getIntent().getStringExtra("KSta_FromUserName");
    this.xvx = getIntent().getStringExtra("KSta_ChatName");
    this.xvy = getIntent().getStringExtra("KSta_SnSId");
    this.xvz = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.xvA = getIntent().getIntExtra("KSta_FavID", 0);
    this.xvB = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.dxG = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.dAM = bt.by(getIntent().getStringExtra("KViewId"), "");
    this.gJy = getIntent().getStringExtra("StreamWording");
    this.gJz = getIntent().getStringExtra("StremWebUrl");
    setMMTitle("");
    paramBundle = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    paramBundle.HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(98451);
        if (paramAnonymousl.eSQ())
        {
          paramAnonymousl.jj(1002, 2131763770);
          paramAnonymousl.jj(1003, 2131763771);
          if (!SnsAdStreamVideoPlayUI.c(SnsAdStreamVideoPlayUI.this)) {
            paramAnonymousl.jj(1004, 2131763769);
          }
        }
        AppMethodBeat.o(98451);
      }
    };
    paramBundle.HrY = new n.d()
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
    paramBundle.GHn = new e.b()
    {
      public final void onDismiss() {}
    };
    addIconOptionMenu(1001, 2131230853, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98453);
        paramBundle.csG();
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
    if (this.xvr != null) {
      this.xvr.onResume();
    }
    AppMethodBeat.o(98463);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98464);
    super.onStop();
    ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "pause play");
    this.xvm.pause();
    com.tencent.mm.plugin.sns.a.b.a.a locala;
    if (this.xvC)
    {
      i = getResources().getConfiguration().orientation;
      this.xvr.LV(this.xvm.getCurrPosSec());
      this.xvr.wyw.wzC = bt.GC();
      locala = this.xvr.wyw;
      if (i != 2) {
        break label127;
      }
    }
    label127:
    for (int i = 2;; i = 1)
    {
      locala.wzB = i;
      this.xvr.wyw.wzA = 2;
      if (this.xvr != null) {
        this.xvr.htb = bt.GC();
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
  
  public final void pj(String paramString) {}
  
  final class a
    implements b.b
  {
    private String mediaId;
    
    public a(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void aob(String paramString) {}
    
    public final void by(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(98457);
      if ((!bt.T(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        ad.i("MicroMsg.SnsAdStreamVideoPlayUI", "download image finish %s", new Object[] { paramString });
        paramString = com.tencent.mm.sdk.platformtools.f.decodeFile(SnsAdStreamVideoPlayUI.a(SnsAdStreamVideoPlayUI.this), null);
        if (paramString != null) {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setCover(paramString);
        }
      }
      AppMethodBeat.o(98457);
    }
    
    public final void bz(String paramString, boolean paramBoolean) {}
    
    public final void dsp() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */