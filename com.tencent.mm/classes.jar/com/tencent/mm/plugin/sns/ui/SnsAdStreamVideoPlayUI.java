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
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.r;
import com.tencent.mm.af.r.a;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.a;
import com.tencent.mm.plugin.sns.a.b.k.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(35)
public class SnsAdStreamVideoPlayUI
  extends MMActivity
  implements h.a, h.b, h.c
{
  private String cBO;
  private String cGU;
  private String fiR;
  private String fiS;
  private String hpq;
  private TextView mzS;
  private com.tencent.mm.plugin.sns.storage.n rMD;
  private String rNA;
  private int rNB;
  private int rNC;
  private String rND;
  private String rNE;
  private String rNF;
  private long rNG;
  private int rNH;
  private int rNI;
  private boolean rNJ;
  private FrameLayout rNs;
  private SnsAdStreamVideoView rNt;
  private String rNu;
  private boolean rNv;
  private boolean rNw;
  private String rNx;
  private h rNy;
  private String rNz;
  private String rsI;
  private int rxA;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  
  public SnsAdStreamVideoPlayUI()
  {
    AppMethodBeat.i(145510);
    this.rNy = new h("SnsAdStreamVideoPlayUI");
    this.rsI = "";
    AppMethodBeat.o(145510);
  }
  
  private void Ee(int paramInt)
  {
    AppMethodBeat.i(145517);
    if (this.rNt != null) {
      this.rNt.d(paramInt, true);
    }
    AppMethodBeat.o(145517);
  }
  
  public final void an(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(145522);
    ab.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s download finish", new Object[] { paramString });
    this.rNy.qZB = 1;
    AppMethodBeat.o(145522);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public final void cq(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(145518);
    ab.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s prepared, video total time %d", new Object[] { paramString2, Integer.valueOf(this.rNt.getVideoDurationSec()) });
    this.rNt.cxI();
    if (this.rxA == 0) {
      this.rxA = this.rNt.getVideoDurationSec();
    }
    paramString1 = this.rNy.qZJ;
    if (getResources().getConfiguration().orientation == 2) {
      i = 2;
    }
    paramString1.raM = i;
    this.rNy.qZJ.raN = bo.yB();
    this.rNy.qZJ.raL = 2;
    this.rNy.qZJ.raJ = 0;
    paramString1 = this.rNy.qZJ;
    paramString1.raH += 1;
    this.rNy.qZJ.raN = bo.yB();
    AppMethodBeat.o(145518);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145519);
    ab.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s video ended", new Object[] { paramString2 });
    paramString1 = this.rNy.qZJ;
    paramString1.raI += 1;
    this.rNt.stop();
    this.rNt.cxF();
    this.rNt.smN.stopTimer();
    this.rNt.setIsShowBasicControls(true);
    AppMethodBeat.o(145519);
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145520);
    ab.d("MicroMsg.SnsAdStreamVideoPlayUI", "%s video paused", new Object[] { paramString2 });
    paramString1 = this.rNy.qZJ;
    paramString1.raJ += (int)bo.av(this.rNy.qZJ.raN);
    AppMethodBeat.o(145520);
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145521);
    this.rNt.cxG();
    AppMethodBeat.o(145521);
  }
  
  public final void cu(String paramString1, String paramString2) {}
  
  public final void cv(String paramString1, String paramString2) {}
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public void finish()
  {
    AppMethodBeat.i(145514);
    ab.i("MicroMsg.SnsAdStreamVideoPlayUI", "stop play");
    this.rNt.aEM();
    this.rNt.cxI();
    ag.cpa().aaa(this.cBO);
    Object localObject;
    if ((this.rNy != null) && (this.rsI != null) && (this.rsI.length() > 0))
    {
      this.rNy.cnG();
      localObject = new Intent();
      ((Intent)localObject).putExtra("KComponentCid", this.rsI);
      ((Intent)localObject).putExtra("KStreamVideoPlayCount", this.rNy.qZF);
      ((Intent)localObject).putExtra("KStreamVideoPlayCompleteCount", this.rNy.qZG);
      ((Intent)localObject).putExtra("KStreamVideoTotalPlayTimeInMs", this.rNy.qZH);
      setResult(-1, (Intent)localObject);
    }
    if (this.rNC != 0) {
      k.a(k.a.rai, this.rNA, this.rNz, this.rNB, this.rNC, this.rND, this.rNE, this.rNF, this.rNG, this.rNH, this.rNI);
    }
    if (this.rNJ) {
      if (this.rMD != null) {
        break label388;
      }
    }
    label388:
    for (int i = 0;; i = this.rMD.csR())
    {
      if (this.rMD != null)
      {
        localObject = this.rNy.cnF();
        long l2 = this.rNy.qZC - this.rNy.fQy;
        long l1 = l2;
        if (l2 < 0L)
        {
          ab.e("MicroMsg.SnsAdStreamVideoPlayUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.rNy.qZC), Long.valueOf(this.rNy.fQy) });
          l1 = this.rNy.qZC;
        }
        int j = (int)l1;
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.plugin.sns.a.b.d(this.hpq, 6, 2, this.rNy.qZC, null, null, 2, (String)localObject, -1, i, j, j, 0, this.rMD.csQ().csj(), this.rMD.csQ().csk()), 0);
      }
      super.finish();
      AppMethodBeat.o(145514);
      return;
    }
  }
  
  public int getForceOrientation()
  {
    if (this.rNv) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return 2130970798;
  }
  
  public final void hB(long paramLong) {}
  
  public void initView()
  {
    AppMethodBeat.i(145512);
    this.rNs = ((FrameLayout)findViewById(2131823717));
    this.rNt = ((SnsAdStreamVideoView)findViewById(2131821436));
    this.rNs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(145507);
        SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setIsShowBasicControls(true);
        if (SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).isPlaying())
        {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).smN.stopTimer();
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).cxI();
        }
        AppMethodBeat.o(145507);
      }
    });
    this.rNs.setPadding(0, 0, 0, af.fx(this));
    this.mzS = ((TextView)findViewById(2131827797));
    Object localObject;
    if (!bo.Q(new String[] { this.fiR, this.fiS }))
    {
      this.mzS.setVisibility(0);
      this.mzS.setText(this.fiR);
      this.mzS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(145508);
          if (SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this) != 0) {
            k.a(k.a.rag, SnsAdStreamVideoPlayUI.h(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.j(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.k(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.l(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.m(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.n(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.o(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.p(SnsAdStreamVideoPlayUI.this));
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
              paramAnonymousView = i.gg(str, SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this));
            }
          }
          localIntent.putExtra("jsapiargs", localBundle);
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("useJs", true);
          if (SnsAdStreamVideoPlayUI.s(SnsAdStreamVideoPlayUI.this)) {
            i.a(new SnsAdClick(0, 6, SnsAdStreamVideoPlayUI.t(SnsAdStreamVideoPlayUI.this).field_snsId, 18, 0));
          }
          com.tencent.mm.plugin.sns.c.a.gmO.i(localIntent, SnsAdStreamVideoPlayUI.this);
          SnsAdStreamVideoPlayUI.this.finish();
          AppMethodBeat.o(145508);
        }
      });
      this.rNt.setReporter(this);
      this.rNt.setIMMVideoViewCallback(this);
      this.rNt.setIMMDownloadFinish(this);
      this.rNt.setRootPath(ag.getSnsAdPath());
      this.rNt.c(false, this.rNu, 0);
      this.rNt.setScaleType(h.d.vQK);
      this.rNt.setIOnlineVideoProxy(new ad());
      if ((bo.isNullOrNil(this.thumbPath)) || (!com.tencent.mm.vfs.e.cN(this.thumbPath))) {
        break label314;
      }
      localObject = com.tencent.mm.sdk.platformtools.d.decodeFile(this.thumbPath, null);
      if (localObject == null) {
        break label314;
      }
      this.rNt.setCover((Bitmap)localObject);
      label247:
      ab.i("MicroMsg.SnsAdStreamVideoPlayUI", "start play");
      if (!this.rNt.isPlaying())
      {
        if (this.rNt.getCurrPosSec() != this.rNt.getVideoDurationSec()) {
          break label500;
        }
        Ee(0);
      }
    }
    for (;;)
    {
      this.rNt.start();
      AppMethodBeat.o(145512);
      return;
      this.mzS.setVisibility(8);
      break;
      label314:
      String str = "attach" + this.cBO;
      localObject = ao.gl(ag.getSnsAdPath(), str);
      str = i.Zx(str);
      this.thumbPath = ((String)localObject + str);
      ab.i("MicroMsg.SnsAdStreamVideoPlayUI", "try download thumb img %s, save to %s", new Object[] { this.cBO, this.thumbPath });
      bcs localbcs = com.tencent.mm.modelsns.e.a(this.thumbPath, 2, this.thumbUrl, this.thumbUrl, 1, 1, "");
      com.tencent.mm.plugin.sns.data.e locale = new com.tencent.mm.plugin.sns.data.e(localbcs);
      locale.rbj = 3;
      locale.ohe = localbcs.Id;
      ag.cpa().a(new SnsAdStreamVideoPlayUI.a(this, localbcs.Id));
      com.tencent.mm.plugin.sns.model.b localb = ag.cpa();
      az localaz = az.dxB();
      localaz.oLs = ((int)(System.currentTimeMillis() / 1000L));
      localb.a(localbcs, locale, localaz, (String)localObject, str);
      break label247;
      label500:
      Ee(this.rNt.getCurrPosSec());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(145523);
    if (999 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = bo.P(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          ab.i("MicroMsg.SnsAdStreamVideoPlayUI", "send sight to %s", new Object[] { str2 });
          localObject1 = new j.b();
          ((j.b)localObject1).title = this.rNx;
          ((j.b)localObject1).type = 4;
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
          if (!bo.isNullOrNil(this.url))
          {
            ((j.b)localObject1).url = this.url;
            ((j.b)localObject1).thumburl = this.thumbUrl;
            ((j.b)localObject1).fiO = this.rNu;
            ((j.b)localObject1).fiP = this.rxA;
            ((j.b)localObject1).fiQ = this.rNx;
            ((j.b)localObject1).fiS = this.fiS;
            ((j.b)localObject1).fiR = this.fiR;
            ((j.b)localObject1).fiT = this.thumbUrl;
            ((j.b)localObject1).fiU = this.rNz;
            ((j.b)localObject1).fiV = this.rNA;
            ((j.b)localObject1).cGU = this.cGU;
            localObject2 = com.tencent.mm.vfs.e.i(this.thumbPath, 0, -1);
            if (localObject2 != null) {
              break label474;
            }
            i = 0;
            ab.i("MicroMsg.SnsAdStreamVideoPlayUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (r.a.Yp() != null) {
              r.a.Yp().a((j.b)localObject1, "", "", str2, "", (byte[])localObject2);
            }
            com.tencent.mm.plugin.messenger.a.g.bPJ().fh(str1, str2);
            if (this.rNJ) {
              i.a(new SnsAdClick(0, 6, this.rMD.field_snsId, 12, 0));
            }
            if (this.rNC == 0) {
              continue;
            }
            boolean bool = t.lA(str2);
            if (!bool) {
              break label482;
            }
            localObject1 = k.c.rau;
            localObject2 = this.rNA;
            str3 = this.rNz;
            j = this.rNB;
            k = this.rNC;
            str4 = this.rND;
            str5 = this.rNE;
            str6 = this.rNF;
            l = this.rNG;
            m = this.rNH;
            n = this.rNI;
            if (!bool) {
              break label490;
            }
          }
          label474:
          label482:
          label490:
          for (int i = com.tencent.mm.model.n.nv(str2);; i = 0)
          {
            k.a((k.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((j.b)localObject1).url = this.rNu;
            break label137;
            i = localObject2.length;
            break label246;
            localObject1 = k.c.rat;
            break label360;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131300637));
      }
    }
    else if (998 == paramInt1)
    {
      if (this.rNC != 0) {
        k.a(k.c.rav, this.rNA, this.rNz, this.rNB, this.rNC, this.rND, this.rNE, this.rNF, this.rNG, this.rNH, this.rNI, 0);
      }
      if (-1 != paramInt2) {
        break label650;
      }
      if (this.rNJ) {
        i.a(new SnsAdClick(0, 6, this.rMD.field_snsId, 15, 0));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(145523);
      return;
      if (!this.rNJ) {
        break;
      }
      i.a(new SnsAdClick(0, 6, this.rMD.field_snsId, 13, 0));
      break;
      label650:
      if (this.rNJ) {
        i.a(new SnsAdClick(0, 6, this.rMD.field_snsId, 16, 0));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(145511);
    super.onCreate(paramBundle);
    this.url = getIntent().getStringExtra("KUrl");
    this.rNu = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.thumbPath = getIntent().getStringExtra("KThumbPath");
    this.cBO = getIntent().getStringExtra("KMediaId");
    this.rNv = getIntent().getBooleanExtra("ForceLandscape", false);
    this.rNw = getIntent().getBooleanExtra("KBlockFav", false);
    this.rNx = bo.bf(getIntent().getStringExtra("KMediaTitle"), "");
    this.rxA = getIntent().getIntExtra("KMediaVideoTime", 0);
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.rMD = ag.cpf().abu(i.ZN(paramBundle));
    this.rNJ = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.rNy.qZD = bo.yB();
    this.rsI = getIntent().getStringExtra("KComponentCid");
    this.rNz = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.rNA = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.rNB = getIntent().getIntExtra("KSta_SourceType", 0);
    this.rNC = getIntent().getIntExtra("KSta_Scene", 0);
    this.rND = getIntent().getStringExtra("KSta_FromUserName");
    this.rNE = getIntent().getStringExtra("KSta_ChatName");
    this.rNF = getIntent().getStringExtra("KSta_SnSId");
    this.rNG = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.rNH = getIntent().getIntExtra("KSta_FavID", 0);
    this.rNI = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.cGU = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.hpq = bo.bf(getIntent().getStringExtra("KViewId"), "");
    this.fiR = getIntent().getStringExtra("StreamWording");
    this.fiS = getIntent().getStringExtra("StremWebUrl");
    setMMTitle("");
    paramBundle = new com.tencent.mm.ui.widget.b.d(this, 1, false);
    paramBundle.sao = new SnsAdStreamVideoPlayUI.1(this);
    paramBundle.sap = new SnsAdStreamVideoPlayUI.2(this);
    paramBundle.AGQ = new SnsAdStreamVideoPlayUI.3(this);
    addIconOptionMenu(1001, 2130837627, new SnsAdStreamVideoPlayUI.4(this, paramBundle));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(145506);
        SnsAdStreamVideoPlayUI.this.finish();
        AppMethodBeat.o(145506);
        return true;
      }
    }, 2130837626);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    setActionbarColor(getResources().getColor(2131690605));
    setNavigationbarColor(getResources().getColor(2131690605));
    initView();
    AppMethodBeat.o(145511);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(145513);
    if (paramInt == 4)
    {
      finish();
      AppMethodBeat.o(145513);
      return true;
    }
    AppMethodBeat.o(145513);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(145515);
    super.onResume();
    if (this.rNy != null) {
      this.rNy.onResume();
    }
    AppMethodBeat.o(145515);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(145516);
    super.onStop();
    ab.i("MicroMsg.SnsAdStreamVideoPlayUI", "pause play");
    this.rNt.pause();
    com.tencent.mm.plugin.sns.a.b.a.a locala;
    if (this.rNJ)
    {
      i = getResources().getConfiguration().orientation;
      this.rNy.Dx(this.rNt.getCurrPosSec());
      this.rNy.qZJ.raN = bo.yB();
      locala = this.rNy.qZJ;
      if (i != 2) {
        break label127;
      }
    }
    label127:
    for (int i = 2;; i = 1)
    {
      locala.raM = i;
      this.rNy.qZJ.raL = 2;
      if (this.rNy != null) {
        this.rNy.fQx = bo.yB();
      }
      AppMethodBeat.o(145516);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void xE(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */