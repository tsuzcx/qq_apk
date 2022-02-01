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
import com.tencent.mm.ah.w.a;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.d.m.a;
import com.tencent.mm.plugin.sns.ad.d.m.c;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
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
  private String dvs;
  private String dyy;
  private String hjY;
  private String hjZ;
  private String mediaId;
  private TextView qPW;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private p xIq;
  private FrameLayout yIb;
  private SnsAdStreamVideoView yIc;
  private String yId;
  private boolean yIe;
  private boolean yIf;
  private String yIg;
  private com.tencent.mm.plugin.sns.ad.d.j yIh;
  private String yIi;
  private String yIj;
  private int yIk;
  private int yIl;
  private String yIm;
  private String yIn;
  private String yIo;
  private long yIp;
  private int yIq;
  private int yIr;
  private boolean yIs;
  private String yjs;
  private int ypz;
  
  public SnsAdStreamVideoPlayUI()
  {
    AppMethodBeat.i(98458);
    this.yIh = new com.tencent.mm.plugin.sns.ad.d.j("SnsAdStreamVideoPlayUI");
    this.yjs = "";
    AppMethodBeat.o(98458);
  }
  
  private void OK(int paramInt)
  {
    AppMethodBeat.i(98465);
    if (this.yIc != null) {
      this.yIc.c(paramInt, true);
    }
    AppMethodBeat.o(98465);
  }
  
  public final void aI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98470);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s download finish", new Object[] { paramString });
    this.yIh.xJP = 1;
    AppMethodBeat.o(98470);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(98466);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s prepared, video total time %d", new Object[] { paramString2, Integer.valueOf(this.yIc.getVideoDurationSec()) });
    this.yIc.dSE();
    if (this.ypz == 0) {
      this.ypz = this.yIc.getVideoDurationSec();
    }
    paramString1 = this.yIh.xJX;
    if (getResources().getConfiguration().orientation == 2) {
      i = 2;
    }
    paramString1.xLc = i;
    this.yIh.xJX.xLd = bs.Gn();
    this.yIh.xJX.xLb = 2;
    this.yIh.xJX.xKZ = 0;
    paramString1 = this.yIh.xJX;
    paramString1.xKX += 1;
    this.yIh.xJX.xLd = bs.Gn();
    AppMethodBeat.o(98466);
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98467);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s video ended", new Object[] { paramString2 });
    paramString1 = this.yIh.xJX;
    paramString1.xKY += 1;
    this.yIc.stop();
    this.yIc.dSB();
    this.yIc.zkw.stopTimer();
    this.yIc.setIsShowBasicControls(true);
    AppMethodBeat.o(98467);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98468);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SnsAdStreamVideoPlayUI", "%s video paused", new Object[] { paramString2 });
    paramString1 = this.yIh.xJX;
    paramString1.xKZ += (int)bs.aO(this.yIh.xJX.xLd);
    AppMethodBeat.o(98468);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98469);
    this.yIc.dSC();
    AppMethodBeat.o(98469);
  }
  
  public final void ds(String paramString1, String paramString2) {}
  
  public final void dt(String paramString1, String paramString2) {}
  
  public final void eJ(String paramString1, String paramString2) {}
  
  public void finish()
  {
    AppMethodBeat.i(98462);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoPlayUI", "stop play");
    this.yIc.onUIDestroy();
    this.yIc.dSE();
    af.dHM().atu(this.mediaId);
    if ((this.yIh != null) && (this.yjs != null) && (this.yjs.length() > 0))
    {
      this.yIh.dFI();
      localObject = new Intent();
      ((Intent)localObject).putExtra("KComponentCid", this.yjs);
      ((Intent)localObject).putExtra("KStreamVideoPlayCount", this.yIh.xJT);
      ((Intent)localObject).putExtra("KStreamVideoPlayCompleteCount", this.yIh.xJU);
      ((Intent)localObject).putExtra("KStreamVideoTotalPlayTimeInMs", this.yIh.xJV);
      setResult(-1, (Intent)localObject);
    }
    if (this.yIl != 0) {
      com.tencent.mm.plugin.sns.ad.d.m.a(m.a.xKy, this.yIj, this.yIi, this.yIk, this.yIl, this.yIm, this.yIn, this.yIo, this.yIp, this.yIq, this.yIr);
    }
    int i;
    String str;
    int j;
    if (this.yIs)
    {
      if (this.xIq != null) {
        break label402;
      }
      i = 0;
      if (this.xIq != null)
      {
        str = this.yIh.dFH();
        long l2 = this.yIh.xJQ - this.yIh.hTE;
        long l1 = l2;
        if (l2 < 0L)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SnsAdStreamVideoPlayUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.yIh.xJQ), Long.valueOf(this.yIh.hTE) });
          l1 = this.yIh.xJQ;
        }
        j = (int)l1;
        localObject = this.xIq.dFQ();
        if (localObject != null) {
          break label413;
        }
      }
    }
    label402:
    label413:
    for (Object localObject = "";; localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).yfa)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.sns.ad.d.f(this.dyy, 6, this.yIh.xJQ, str, i, j, j, this.xIq.dME().dLX(), this.xIq.dME().dLY(), (String)localObject), 0);
      super.finish();
      AppMethodBeat.o(98462);
      return;
      i = this.xIq.dMF();
      break;
    }
  }
  
  public int getForceOrientation()
  {
    if (this.yIe) {
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
    this.yIb = ((FrameLayout)findViewById(2131304241));
    this.yIc = ((SnsAdStreamVideoView)findViewById(2131306410));
    this.yIb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98455);
        SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setIsShowBasicControls(true);
        if (SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).isPlaying())
        {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).zkw.stopTimer();
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).dSE();
        }
        AppMethodBeat.o(98455);
      }
    });
    this.yIb.setPadding(0, 0, 0, aj.ej(this));
    this.qPW = ((TextView)findViewById(2131304777));
    Object localObject;
    if (!bs.T(new String[] { this.hjY, this.hjZ }))
    {
      this.qPW.setVisibility(0);
      this.qPW.setText(this.hjY);
      this.qPW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98456);
          if (SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this) != 0) {
            com.tencent.mm.plugin.sns.ad.d.m.a(m.a.xKw, SnsAdStreamVideoPlayUI.h(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.j(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.k(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.l(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.m(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.n(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.o(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.p(SnsAdStreamVideoPlayUI.this));
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
              paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iV(str, SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this));
            }
          }
          localIntent.putExtra("jsapiargs", localBundle);
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("useJs", true);
          if (SnsAdStreamVideoPlayUI.s(SnsAdStreamVideoPlayUI.this)) {
            com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, SnsAdStreamVideoPlayUI.t(SnsAdStreamVideoPlayUI.this).field_snsId, 18, 0));
          }
          com.tencent.mm.plugin.sns.c.a.iyx.i(localIntent, SnsAdStreamVideoPlayUI.this);
          SnsAdStreamVideoPlayUI.this.finish();
          AppMethodBeat.o(98456);
        }
      });
      this.yIc.setReporter(this);
      this.yIc.setIMMVideoViewCallback(this);
      this.yIc.setIMMDownloadFinish(this);
      this.yIc.setRootPath(af.getSnsAdPath());
      this.yIc.c(false, this.yId, 0);
      this.yIc.setScaleType(h.e.DnJ);
      this.yIc.setIOnlineVideoProxy(new com.tencent.mm.plugin.sns.model.ac());
      if ((bs.isNullOrNil(this.thumbPath)) || (!i.eA(this.thumbPath))) {
        break label314;
      }
      localObject = com.tencent.mm.sdk.platformtools.f.decodeFile(this.thumbPath, null);
      if (localObject == null) {
        break label314;
      }
      this.yIc.setCover((Bitmap)localObject);
      label247:
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoPlayUI", "start play");
      if (!this.yIc.isPlaying())
      {
        if (this.yIc.getCurrPosSec() != this.yIc.getVideoDurationSec()) {
          break label502;
        }
        OK(0);
      }
    }
    for (;;)
    {
      this.yIc.start();
      AppMethodBeat.o(98460);
      return;
      this.qPW.setVisibility(8);
      break;
      label314:
      String str = "attach" + this.mediaId;
      localObject = an.jc(af.getSnsAdPath(), str);
      str = com.tencent.mm.plugin.sns.data.q.asM(str);
      this.thumbPath = ((String)localObject + str);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoPlayUI", "try download thumb img %s, save to %s", new Object[] { this.mediaId, this.thumbPath });
      btz localbtz = com.tencent.mm.modelsns.g.a(this.thumbPath, 2, this.thumbUrl, this.thumbUrl, 1, 1, "");
      com.tencent.mm.plugin.sns.data.m localm = new com.tencent.mm.plugin.sns.data.m(localbtz);
      localm.xNy = 3;
      localm.dlj = localbtz.Id;
      af.dHM().a(new a(localbtz.Id));
      com.tencent.mm.plugin.sns.model.b localb = af.dHM();
      bf localbf = bf.fbk();
      localbf.gIh = ((int)(System.currentTimeMillis() / 1000L));
      localb.a(localbtz, 8, localm, localbf, (String)localObject, str);
      break label247;
      label502:
      OK(this.yIc.getCurrPosSec());
    }
  }
  
  public final void oQ(long paramLong) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98471);
    if (999 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = bs.S(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoPlayUI", "send sight to %s", new Object[] { str2 });
          localObject1 = new k.b();
          ((k.b)localObject1).title = this.yIg;
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
          if (!bs.isNullOrNil(this.url))
          {
            ((k.b)localObject1).url = this.url;
            ((k.b)localObject1).thumburl = this.thumbUrl;
            ((k.b)localObject1).hjV = this.yId;
            ((k.b)localObject1).hjW = this.ypz;
            ((k.b)localObject1).hjX = this.yIg;
            ((k.b)localObject1).hjZ = this.hjZ;
            ((k.b)localObject1).hjY = this.hjY;
            ((k.b)localObject1).hka = this.thumbUrl;
            ((k.b)localObject1).hkb = this.yIi;
            ((k.b)localObject1).hkc = this.yIj;
            ((k.b)localObject1).dvs = this.dvs;
            localObject2 = i.aU(this.thumbPath, 0, -1);
            if (localObject2 != null) {
              break label474;
            }
            i = 0;
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoPlayUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.awq() != null) {
              w.a.awq().a((k.b)localObject1, "", "", str2, "", (byte[])localObject2);
            }
            com.tencent.mm.plugin.messenger.a.j.dck().hF(str1, str2);
            if (this.yIs) {
              com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.xIq.field_snsId, 12, 0));
            }
            if (this.yIl == 0) {
              continue;
            }
            boolean bool = com.tencent.mm.model.w.sQ(str2);
            if (!bool) {
              break label482;
            }
            localObject1 = m.c.xKK;
            localObject2 = this.yIj;
            str3 = this.yIi;
            j = this.yIk;
            k = this.yIl;
            str4 = this.yIm;
            str5 = this.yIn;
            str6 = this.yIo;
            l = this.yIp;
            m = this.yIq;
            n = this.yIr;
            if (!bool) {
              break label490;
            }
          }
          label474:
          label482:
          label490:
          for (int i = com.tencent.mm.model.q.wb(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.ad.d.m.a((m.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject1).url = this.yId;
            break label137;
            i = localObject2.length;
            break label246;
            localObject1 = m.c.xKJ;
            break label360;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
      }
    }
    else if (998 == paramInt1)
    {
      if (this.yIl != 0) {
        com.tencent.mm.plugin.sns.ad.d.m.a(m.c.xKL, this.yIj, this.yIi, this.yIk, this.yIl, this.yIm, this.yIn, this.yIo, this.yIp, this.yIq, this.yIr, 0);
      }
      if (-1 != paramInt2) {
        break label650;
      }
      if (this.yIs) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.xIq.field_snsId, 15, 0));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(98471);
      return;
      if (!this.yIs) {
        break;
      }
      com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.xIq.field_snsId, 13, 0));
      break;
      label650:
      if (this.yIs) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.xIq.field_snsId, 16, 0));
      }
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(98459);
    super.onCreate(paramBundle);
    this.url = getIntent().getStringExtra("KUrl");
    this.yId = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.thumbPath = getIntent().getStringExtra("KThumbPath");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.yIe = getIntent().getBooleanExtra("ForceLandscape", false);
    this.yIf = getIntent().getBooleanExtra("KBlockFav", false);
    this.yIg = bs.bG(getIntent().getStringExtra("KMediaTitle"), "");
    this.ypz = getIntent().getIntExtra("KMediaVideoTime", 0);
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.xIq = af.dHR().auS(com.tencent.mm.plugin.sns.data.q.atd(paramBundle));
    this.yIs = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.yIh.xJR = bs.Gn();
    this.yjs = getIntent().getStringExtra("KComponentCid");
    this.yIi = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.yIj = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.yIk = getIntent().getIntExtra("KSta_SourceType", 0);
    this.yIl = getIntent().getIntExtra("KSta_Scene", 0);
    this.yIm = getIntent().getStringExtra("KSta_FromUserName");
    this.yIn = getIntent().getStringExtra("KSta_ChatName");
    this.yIo = getIntent().getStringExtra("KSta_SnSId");
    this.yIp = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.yIq = getIntent().getIntExtra("KSta_FavID", 0);
    this.yIr = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.dvs = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.dyy = bs.bG(getIntent().getStringExtra("KViewId"), "");
    this.hjY = getIntent().getStringExtra("StreamWording");
    this.hjZ = getIntent().getStringExtra("StremWebUrl");
    setMMTitle("");
    paramBundle = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    paramBundle.ISu = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(98451);
        if (paramAnonymousl.fiA())
        {
          paramAnonymousl.jw(1002, 2131763770);
          paramAnonymousl.jw(1003, 2131763771);
          if (!SnsAdStreamVideoPlayUI.c(SnsAdStreamVideoPlayUI.this)) {
            paramAnonymousl.jw(1004, 2131763769);
          }
        }
        AppMethodBeat.o(98451);
      }
    };
    paramBundle.ISv = new n.d()
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
    paramBundle.Ihj = new e.b()
    {
      public final void onDismiss() {}
    };
    addIconOptionMenu(1001, 2131230853, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98453);
        paramBundle.cED();
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
    if (this.yIh != null) {
      this.yIh.onResume();
    }
    AppMethodBeat.o(98463);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98464);
    super.onStop();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoPlayUI", "pause play");
    this.yIc.pause();
    com.tencent.mm.plugin.sns.ad.d.a.a locala;
    if (this.yIs)
    {
      i = getResources().getConfiguration().orientation;
      this.yIh.NV(this.yIc.getCurrPosSec());
      this.yIh.xJX.xLd = bs.Gn();
      locala = this.yIh.xJX;
      if (i != 2) {
        break label127;
      }
    }
    label127:
    for (int i = 2;; i = 1)
    {
      locala.xLc = i;
      this.yIh.xJX.xLb = 2;
      if (this.yIh != null) {
        this.yIh.hTD = bs.Gn();
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
  
  public final void sv(String paramString) {}
  
  final class a
    implements b.b
  {
    private String mediaId;
    
    public a(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void atn(String paramString) {}
    
    public final void bF(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(98457);
      if ((!bs.T(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoPlayUI", "download image finish %s", new Object[] { paramString });
        paramString = com.tencent.mm.sdk.platformtools.f.decodeFile(SnsAdStreamVideoPlayUI.a(SnsAdStreamVideoPlayUI.this), null);
        if (paramString != null) {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setCover(paramString);
        }
      }
      AppMethodBeat.o(98457);
    }
    
    public final void bG(String paramString, boolean paramBoolean) {}
    
    public final void dGO() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */