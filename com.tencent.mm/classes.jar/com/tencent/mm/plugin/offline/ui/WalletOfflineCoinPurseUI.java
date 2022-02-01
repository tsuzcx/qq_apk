package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.uj.b;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.a.xd.b;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.offline.a.j;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.b;
import com.tencent.mm.plugin.offline.a.s.c;
import com.tencent.mm.plugin.offline.a.s.d;
import com.tencent.mm.plugin.offline.a.s.e;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ah.a;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.kernel.i
public class WalletOfflineCoinPurseUI
  extends WalletBaseUI
  implements u.a, s.a, com.tencent.mm.plugin.offline.b, a, bh.a
{
  private static int mmW = 0;
  private boolean cwr;
  private int fsv;
  private View.OnClickListener iAw;
  private int jqR;
  private com.tencent.mm.ui.widget.a.e lBF;
  private int mEntryScene;
  private long mLastTime;
  private int mState;
  private Dialog mTipDialog;
  private boolean nzc;
  private int pOf;
  private HashMap<String, Integer> sWX;
  private String uiA;
  private String ujd;
  private com.tencent.mm.plugin.offline.a.m ujf;
  private int ujh;
  private av uji;
  private com.tencent.mm.sdk.b.c<kb> ujv;
  private String ulA;
  private View ulB;
  private TextView ulC;
  private ImageView ulD;
  private RelativeLayout ulE;
  private LinearLayout ulF;
  private CdnImageView ulG;
  private TextView ulH;
  private TextView ulI;
  private e ulJ;
  private g ulK;
  private b ulL;
  private f ulM;
  private d ulN;
  private LinearLayout ulO;
  private LinearLayout ulP;
  private LinearLayout ulQ;
  private LinearLayout ulR;
  private LinearLayout ulS;
  private String ulT;
  private boolean ulU;
  private com.tencent.mm.plugin.offline.g ulV;
  private boolean ulW;
  private boolean ulX;
  private boolean ulY;
  private boolean ulZ;
  private HashMap<String, View> ull;
  private HashMap<String, Integer> ulm;
  Bitmap uln;
  Bitmap ulo;
  private c ulp;
  private boolean ulq;
  private boolean ulr;
  private ArrayList<String> uls;
  private ArrayList<String> ult;
  private ArrayList<Boolean> ulu;
  private String ulv;
  private View ulw;
  private ImageView ulx;
  private ImageView uly;
  private TextView ulz;
  private av umA;
  private boolean uma;
  private int umb;
  private ArrayList<Bitmap> umc;
  private ArrayList<Bitmap> umd;
  private com.tencent.mm.wallet_core.ui.c ume;
  private c umf;
  private OfflineAlertView umg;
  private boolean umh;
  private boolean umi;
  private String umj;
  private boolean umk;
  private String uml;
  private boolean umm;
  private int umn;
  private boolean umo;
  com.tencent.mm.sdk.b.c<xk> ump;
  com.tencent.mm.sdk.b.c<xk> umq;
  private com.tencent.mm.sdk.b.c<ct> umr;
  private com.tencent.mm.sdk.b.c<nl> ums;
  private com.tencent.mm.sdk.b.c<mu> umt;
  private com.tencent.mm.sdk.b.c<mv> umu;
  private com.tencent.mm.sdk.b.c umv;
  private com.tencent.mm.sdk.b.c umw;
  private com.tencent.mm.sdk.b.c umx;
  public boolean umy;
  private av umz;
  
  public WalletOfflineCoinPurseUI()
  {
    AppMethodBeat.i(66468);
    this.mLastTime = 0L;
    this.mState = 3;
    this.ull = new HashMap();
    this.ulm = new HashMap();
    this.mEntryScene = -1;
    this.uln = null;
    this.ulo = null;
    this.ulq = false;
    this.ulr = false;
    this.uls = new ArrayList();
    this.ult = new ArrayList();
    this.ulu = new ArrayList();
    this.uiA = "";
    this.ulv = "";
    this.ulT = "";
    this.ujd = "";
    this.nzc = true;
    this.ulU = false;
    this.ulW = false;
    this.ulX = false;
    this.ulY = false;
    this.ulZ = true;
    this.uma = false;
    this.umb = -1;
    this.umc = new ArrayList();
    this.umd = new ArrayList();
    this.umh = false;
    this.umi = false;
    this.umj = null;
    this.umk = false;
    this.jqR = 0;
    this.umm = false;
    this.umo = true;
    this.ump = new com.tencent.mm.sdk.b.c() {};
    this.umq = new com.tencent.mm.sdk.b.c() {};
    this.umr = new com.tencent.mm.sdk.b.c() {};
    this.ums = new com.tencent.mm.sdk.b.c() {};
    this.umt = new com.tencent.mm.sdk.b.c() {};
    this.umu = new com.tencent.mm.sdk.b.c() {};
    this.umv = new WalletOfflineCoinPurseUI.38(this);
    this.umw = new com.tencent.mm.sdk.b.c() {};
    this.umx = new com.tencent.mm.sdk.b.c() {};
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66411);
        long l;
        if ((paramAnonymousView.getId() == 2131306827) || (paramAnonymousView.getId() == 2131306693) || (paramAnonymousView.getId() == 2131306694))
        {
          if ((paramAnonymousView.getId() == 2131306827) && (WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).isShowing()))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
            AppMethodBeat.o(66411);
            return;
          }
          l = System.currentTimeMillis();
          if (((WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this) == null) || (!WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).isShowing())) && (l - WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this) >= 400L) && (com.tencent.mm.plugin.offline.c.a.cZi()) && (!WalletOfflineCoinPurseUI.q(WalletOfflineCoinPurseUI.this)))
          {
            if (paramAnonymousView.getId() != 2131306827) {
              break label204;
            }
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, false);
          }
        }
        for (;;)
        {
          if (WalletOfflineCoinPurseUI.r(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.s(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.r(WalletOfflineCoinPurseUI.this).M(paramAnonymousView, WalletOfflineCoinPurseUI.t(WalletOfflineCoinPurseUI.this));
          }
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, l);
          AppMethodBeat.o(66411);
          return;
          label204:
          if ((paramAnonymousView.getId() == 2131306693) || (paramAnonymousView.getId() == 2131306694))
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(13958, new Object[] { Integer.valueOf(4) });
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, true);
          }
        }
      }
    };
    this.umy = false;
    this.sWX = new HashMap();
    this.ujh = 60000;
    this.uji = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66434);
        if (!WalletOfflineCoinPurseUI.L(WalletOfflineCoinPurseUI.this))
        {
          WalletOfflineCoinPurseUI.y(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.z(WalletOfflineCoinPurseUI.this);
        }
        av localav = WalletOfflineCoinPurseUI.N(WalletOfflineCoinPurseUI.this);
        long l = WalletOfflineCoinPurseUI.M(WalletOfflineCoinPurseUI.this);
        localav.av(l, l);
        AppMethodBeat.o(66434);
        return false;
      }
    }, false);
    this.umz = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(174401);
        WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this);
        if ((WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).isShowing())) {
          WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).dismiss();
        }
        com.tencent.mm.plugin.offline.g.cYm();
        WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this);
        if (com.tencent.mm.plugin.offline.c.a.cZJ()) {
          WalletOfflineCoinPurseUI.this.cYD();
        }
        AppMethodBeat.o(174401);
        return false;
      }
    }, false);
    this.umA = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(184862);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this)) });
        if (WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this))
        {
          cg localcg = new cg();
          localcg.dex.bRZ = 0;
          com.tencent.mm.sdk.b.a.ESL.l(localcg);
        }
        WalletOfflineCoinPurseUI.this.finish();
        AppMethodBeat.o(184862);
        return false;
      }
    }, false);
    this.ujv = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(66468);
  }
  
  private void IJ(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(66490);
    if (!com.tencent.mm.plugin.offline.c.a.cZi())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
      AppMethodBeat.o(66490);
      return;
    }
    com.tencent.mm.plugin.offline.k.cYr();
    Object localObject = com.tencent.mm.plugin.offline.k.cYt().B(this.mEntryScene, paramInt, this.ulA);
    this.ujd = ((String)localObject);
    this.ulT = ((String)localObject);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[] { Integer.valueOf(paramInt), this.ujd, this.ulT, bt.eGN().toString() });
    bPs();
    if (bt.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.mm.plugin.report.service.h.vKh;
      if (com.tencent.mm.plugin.offline.c.a.cB(aj.getContext())) {}
      for (paramInt = 0;; paramInt = 1)
      {
        if (ay.isNetworkConnected(getBaseContext())) {
          i = 1;
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).f(14163, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 26L, 1L, true);
        if (!ay.isNetworkConnected(getBaseContext())) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 28L, 1L, true);
        AppMethodBeat.o(66490);
        return;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 27L, 1L, true);
    }
    AppMethodBeat.o(66490);
  }
  
  private static void IK(int paramInt)
  {
    AppMethodBeat.i(66509);
    com.tencent.mm.g.b.a.o localo = new com.tencent.mm.g.b.a.o();
    localo.dHQ = paramInt;
    localo.aBj();
    AppMethodBeat.o(66509);
  }
  
  private void R(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66480);
    if (com.tencent.mm.plugin.offline.c.a.nT(true).size() > 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
      cYT();
      cYS();
      this.ulB.setVisibility(0);
    }
    for (;;)
    {
      if (paramBoolean1) {
        IJ(0);
      }
      nR(paramBoolean2);
      bKO();
      cYK();
      AppMethodBeat.o(66480);
      return;
      this.ulB.setVisibility(0);
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
    }
  }
  
  private void a(Bankcard paramBankcard)
  {
    AppMethodBeat.i(66511);
    if (TextUtils.isEmpty(this.uiA))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
      AppMethodBeat.o(66511);
      return;
    }
    if (paramBankcard.ebz())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
      this.ulD.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      AppMethodBeat.o(66511);
      return;
    }
    String str2 = com.tencent.mm.plugin.offline.c.a.ajS(this.uiA);
    String str1 = str2;
    if (paramBankcard.ebw())
    {
      str1 = str2;
      if (paramBankcard.Acf != null) {
        str1 = paramBankcard.Acf.dct;
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
      AppMethodBeat.o(66511);
      return;
    }
    e(this.ulD, str1, getResources().getDimensionPixelOffset(2131167003));
    AppMethodBeat.o(66511);
  }
  
  private void bKO()
  {
    AppMethodBeat.i(66479);
    if (com.tencent.mm.plugin.offline.c.a.cZi())
    {
      this.ulE.setVisibility(0);
      AppMethodBeat.o(66479);
      return;
    }
    this.ulE.setVisibility(4);
    AppMethodBeat.o(66479);
  }
  
  private void bPs()
  {
    AppMethodBeat.i(66516);
    az localaz = com.tencent.mm.plugin.wallet_core.model.k.ebS();
    Object localObject = new StringBuilder().append(this.ulT);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz();
    localObject = com.tencent.mm.sdk.platformtools.ai.du(p.getString(com.tencent.mm.kernel.a.getUin()));
    if (localaz != null) {
      com.tencent.mm.plugin.report.service.h.vKh.f(13444, new Object[] { localaz.Cvf, localaz.Cvg, Long.valueOf(localaz.Cve), localObject, localaz.Cvh, localaz.Cvi, localaz.Cvj });
    }
    AppMethodBeat.o(66516);
  }
  
  private void cLg()
  {
    AppMethodBeat.i(66484);
    Bitmap localBitmap = this.uln;
    this.uln = cYQ();
    this.ulx.setImageBitmap(this.uln);
    this.umc.add(0, localBitmap);
    AppMethodBeat.o(66484);
  }
  
  private void cYH()
  {
    AppMethodBeat.i(66470);
    cYW();
    cZb();
    cYX();
    cYU();
    AppMethodBeat.o(66470);
  }
  
  private void cYI()
  {
    AppMethodBeat.i(66472);
    com.tencent.mm.wallet_core.ui.e.aby(32);
    com.tencent.mm.pluginsdk.wallet.f.al(this, this.pOf);
    AppMethodBeat.o(66472);
  }
  
  private void cYJ()
  {
    AppMethodBeat.i(66478);
    buc localbuc = com.tencent.mm.plugin.wallet_core.model.s.ecc().Aio;
    if (localbuc == null)
    {
      this.ulF.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if (localbuc.DRx == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "offlineGuideBar.guide_data == null");
      this.ulF.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    Object localObject = localbuc.DRx.uns;
    if (com.tencent.mm.plugin.wallet_core.model.s.ecc().atT((String)localObject) == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar bindSerial(%s) is null bankcard!", new Object[] { bt.by((String)localObject, "") });
      this.ulF.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    localObject = com.tencent.mm.plugin.offline.c.a.cZk();
    if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (bt.kU(localbuc.DRx.uns, ((Bankcard)localObject).field_bindSerial)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar defaultBankcard(%s) == bindSerial(%s)", new Object[] { ((Bankcard)localObject).field_bindSerial, localbuc.DRx.uns });
      this.ulF.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if ((this.ulF.isShown()) && (this.ulF.getTag() != null) && ((this.ulF.getTag() instanceof buc)) && (bt.I((buc)this.ulF.getTag(), localbuc)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "");
      AppMethodBeat.o(66478);
      return;
    }
    if (localbuc.zOa == 0)
    {
      this.ulF.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if (!this.ulZ)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "isShowGuideBar == false");
      AppMethodBeat.o(66478);
      return;
    }
    int i = this.ulF.getVisibility();
    this.ulF.setTag(localbuc);
    this.ulF.setVisibility(0);
    if ((!bt.isNullOrNil(localbuc.DRy)) && (this.ulF.getBackground() != null)) {
      this.ulF.getBackground().setColorFilter(Color.parseColor(localbuc.DRy), PorterDuff.Mode.SRC);
    }
    int j = BackwardSupportUtil.b.g(this, 20.0F);
    this.ulG.r(localbuc.zOh, j, j, -1);
    this.ulH.setText(localbuc.zOc);
    this.ulH.setTextColor(Color.parseColor(localbuc.zOd));
    this.ulI.setText(localbuc.zOe);
    this.ulI.setTextColor(Color.parseColor(localbuc.zOf));
    this.ulI.setTag(localbuc.DRx.uns);
    com.tencent.mm.ui.ai.a(this.ulI.getPaint(), 0.8F);
    if (localbuc.zPQ == ah.a.AhR.value) {
      this.ulI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184848);
          WalletOfflineCoinPurseUI.IL(2);
          String str2 = "";
          String str1 = str2;
          if (paramAnonymousView.getTag() != null)
          {
            str1 = str2;
            if ((paramAnonymousView.getTag() instanceof String)) {
              str1 = (String)paramAnonymousView.getTag();
            }
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "mOfflineGuideButtonTv click! bindSerial:%s", new Object[] { str1 });
          if (bt.isNullOrNil(str1))
          {
            AppMethodBeat.o(184848);
            return;
          }
          WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.s.ecc().atT(str1);
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, paramAnonymousView);
          AppMethodBeat.o(184848);
        }
      });
    }
    IK(1);
    if ((i == 8) && (this.umg.isShowing()))
    {
      cYU();
      if ((!this.ulW) && (this.umg.II(4)))
      {
        com.tencent.mm.kernel.g.afC();
        if (!((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fme, Boolean.FALSE)).booleanValue()) {
          cYV();
        }
      }
    }
    AppMethodBeat.o(66478);
  }
  
  private void cYK()
  {
    AppMethodBeat.i(66481);
    if ((!this.umy) && (!ay.isNetworkConnected(getBaseContext())))
    {
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.cYt();
      if (com.tencent.mm.plugin.offline.e.cYj() == 0)
      {
        this.umy = true;
        b.ar(this);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
      }
    }
    AppMethodBeat.o(66481);
  }
  
  private void cYL()
  {
    AppMethodBeat.i(66482);
    int i = com.tencent.mm.plugin.offline.c.a.cZn();
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.cZl();
    if (c.cYF())
    {
      this.mState = 7;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
      AppMethodBeat.o(66482);
      return;
    }
    if (!ay.isNetworkConnected(getBaseContext()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
      this.mState = 6;
      AppMethodBeat.o(66482);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.cZi())
    {
      if (i == 0)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
        this.mState = 1;
        AppMethodBeat.o(66482);
        return;
      }
      if ((i != 0) && (localBankcard == null))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
        this.mState = 2;
        AppMethodBeat.o(66482);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
      this.mState = 5;
      AppMethodBeat.o(66482);
      return;
    }
    if (i == 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
      this.mState = 1;
      AppMethodBeat.o(66482);
      return;
    }
    if ((i != 0) && (localBankcard == null))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
      this.mState = 2;
      AppMethodBeat.o(66482);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
    this.mState = 5;
    AppMethodBeat.o(66482);
  }
  
  private boolean cYM()
  {
    return (this.mState == 2) || (this.mState == 1) || (this.mState == 7);
  }
  
  private void cYN()
  {
    AppMethodBeat.i(66485);
    Bitmap localBitmap = this.ulo;
    this.ulo = cYP();
    this.uly.setImageBitmap(this.ulo);
    if (cYM()) {
      this.uly.setAlpha(10);
    }
    for (;;)
    {
      this.umd.add(0, localBitmap);
      AppMethodBeat.o(66485);
      return;
      this.uly.setAlpha(255);
    }
  }
  
  private void cYO()
  {
    AppMethodBeat.i(66486);
    if (this.ume != null)
    {
      this.ume.lK(this.ulT, this.ujd);
      this.ume.uln = this.uln;
      this.ume.ulo = this.ulo;
      this.ume.fkw();
    }
    AppMethodBeat.o(66486);
  }
  
  private Bitmap cYP()
  {
    AppMethodBeat.i(66488);
    if (TextUtils.isEmpty(this.ujd))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
      AppMethodBeat.o(66488);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.bz.a.a.b(this, this.ujd, 5, 0);
    AppMethodBeat.o(66488);
    return localBitmap;
  }
  
  private Bitmap cYQ()
  {
    AppMethodBeat.i(66489);
    if (TextUtils.isEmpty(this.ulT))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
      AppMethodBeat.o(66489);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.bz.a.a.b(this, this.ulT, 12, 3);
    AppMethodBeat.o(66489);
    return localBitmap;
  }
  
  private void cYR()
  {
    AppMethodBeat.i(66493);
    if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
      this.mTipDialog.dismiss();
    }
    AppMethodBeat.o(66493);
  }
  
  private void cYT()
  {
    AppMethodBeat.i(66499);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.cZk();
    if (localBankcard != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
      com.tencent.mm.plugin.offline.c.a.ajL(localBankcard.field_bindSerial);
      this.uiA = localBankcard.field_bindSerial;
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.cYt().uiA = this.uiA;
      AppMethodBeat.o(66499);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
    AppMethodBeat.o(66499);
  }
  
  private void cYU()
  {
    AppMethodBeat.i(66500);
    if (this.ulW)
    {
      AppMethodBeat.o(66500);
      return;
    }
    if (!this.umg.II(4))
    {
      AppMethodBeat.o(66500);
      return;
    }
    com.tencent.mm.kernel.g.afC();
    if ((!((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fme, Boolean.FALSE)).booleanValue()) && (!this.umg.isShowing())) {
      cYV();
    }
    AppMethodBeat.o(66500);
  }
  
  private void cYV()
  {
    AppMethodBeat.i(66501);
    if (!this.umg.II(4))
    {
      AppMethodBeat.o(66501);
      return;
    }
    this.umg.ee(this.ulw);
    AppMethodBeat.o(66501);
  }
  
  private void cYW()
  {
    AppMethodBeat.i(66502);
    if (!this.umg.II(1))
    {
      AppMethodBeat.o(66502);
      return;
    }
    if (this.umg.ukO == 1) {
      this.umg.dismiss();
    }
    boolean bool1 = com.tencent.mm.plugin.wallet_core.model.s.ecc().ecH();
    boolean bool2 = com.tencent.mm.plugin.wallet_core.model.s.ecc().ecG();
    if ((bool1) || (bool2))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.umg.a(this.ulw, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66421);
          com.tencent.mm.plugin.offline.c.a.cZu();
          com.tencent.mm.plugin.offline.k.cYr();
          com.tencent.mm.plugin.offline.k.bp(196648, "0");
          WalletOfflineCoinPurseUI.F(WalletOfflineCoinPurseUI.this);
          AppMethodBeat.o(66421);
        }
      }, 1);
    }
    AppMethodBeat.o(66502);
  }
  
  private void cYX()
  {
    AppMethodBeat.i(66503);
    if (!this.umg.II(3))
    {
      AppMethodBeat.o(66503);
      return;
    }
    if (this.umg.ukO == 3) {
      this.umg.dismiss();
    }
    com.tencent.mm.plugin.offline.k.cYr();
    String str1 = com.tencent.mm.plugin.offline.k.IH(196617);
    com.tencent.mm.wallet_core.c.b.fjR();
    boolean bool1 = com.tencent.mm.wallet_core.c.b.isCertExist(str1);
    boolean bool2 = com.tencent.mm.plugin.offline.c.a.cZi();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) || (!bool2)) {
      if (!bool1)
      {
        com.tencent.mm.kernel.g.afC();
        String str2 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FfO, "");
        if ((str2 == null) || (!str2.equals(com.tencent.mm.compatible.deviceinfo.q.cG(true)))) {
          break label222;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + str1 + " ,recreate offline");
      com.tencent.mm.plugin.offline.c.a.cZu();
      this.ulE.setVisibility(4);
      this.umg.a(this.ulw, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66422);
          com.tencent.mm.plugin.offline.c.a.j(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this));
          WalletOfflineCoinPurseUI.this.finish();
          AppMethodBeat.o(66422);
        }
      }, 3);
      AppMethodBeat.o(66503);
      return;
      label222:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
    }
  }
  
  private void cYY()
  {
    AppMethodBeat.i(66504);
    if (!this.umg.II(5))
    {
      AppMethodBeat.o(66504);
      return;
    }
    if (this.umg.ukO == 5) {
      this.umg.dismiss();
    }
    this.umg.b(this.ulw, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66423);
        com.tencent.mm.plugin.offline.k.cYr();
        com.tencent.mm.plugin.offline.k.cYu();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.i.cYq()) });
        com.tencent.mm.plugin.offline.k.cYr();
        com.tencent.mm.plugin.offline.k.cYu();
        if (com.tencent.mm.plugin.offline.i.cYq() <= 0)
        {
          paramAnonymousView = new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 10);
          WalletOfflineCoinPurseUI.this.doSceneForceProgress(paramAnonymousView);
          AppMethodBeat.o(66423);
          return;
        }
        WalletOfflineCoinPurseUI.G(WalletOfflineCoinPurseUI.this);
        AppMethodBeat.o(66423);
      }
    });
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 73L, 1L, true);
    AppMethodBeat.o(66504);
  }
  
  private void cZa()
  {
    AppMethodBeat.i(66506);
    if ((this.umg.isShowing()) && (this.umg.ukO == 5)) {
      this.umg.dismiss();
    }
    AppMethodBeat.o(66506);
  }
  
  private boolean cZb()
  {
    AppMethodBeat.i(66507);
    if (!this.umg.II(2))
    {
      AppMethodBeat.o(66507);
      return false;
    }
    if (this.umg.ukO == 2) {
      this.umg.dismiss();
    }
    List localList = com.tencent.mm.plugin.offline.c.a.cZo();
    if (localList.size() <= 0)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      AppMethodBeat.o(66507);
      return false;
    }
    int i = 0;
    while (i < localList.size())
    {
      Bankcard localBankcard = (Bankcard)localList.get(i);
      if ((localBankcard != null) && (localBankcard.field_support_micropay) && (bt.isNullOrNil(localBankcard.field_forbidWord)))
      {
        AppMethodBeat.o(66507);
        return true;
      }
      i += 1;
    }
    this.umg.dismiss();
    this.umg.a(this.ulw, new Runnable()new WalletOfflineCoinPurseUI.27
    {
      public final void run()
      {
        AppMethodBeat.i(174395);
        if (WalletOfflineCoinPurseUI.D(WalletOfflineCoinPurseUI.this)) {
          com.tencent.mm.plugin.offline.c.a.a(WalletOfflineCoinPurseUI.this, 20000, -1, WalletOfflineCoinPurseUI.this.getInput());
        }
        for (;;)
        {
          WalletOfflineCoinPurseUI.E(WalletOfflineCoinPurseUI.this);
          AppMethodBeat.o(174395);
          return;
          c localc = WalletOfflineCoinPurseUI.v(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.offline.c.a.i(localc.mActivity, localc.ule);
        }
      }
    }, new WalletOfflineCoinPurseUI.27(this));
    AppMethodBeat.o(66507);
    return false;
  }
  
  private static void cZc()
  {
    AppMethodBeat.i(66510);
    if (!com.tencent.mm.plugin.offline.c.a.cZB())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.cYu().gt(3, 3);
    }
    AppMethodBeat.o(66510);
  }
  
  private void e(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(66495);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66495);
      return;
    }
    Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramString));
    if (localBitmap != null) {
      paramImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.f.a(localBitmap, paramInt, paramInt, true, false));
    }
    this.ull.put(paramString, paramImageView);
    this.ulm.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(66495);
  }
  
  private void nR(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(66483);
    long l = System.currentTimeMillis();
    int i;
    if ((paramBoolean) && ((bt.isNullOrNil(this.ulT)) || (bt.isNullOrNil(this.ujd))))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
      cYY();
      cLg();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - l));
      cYN();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - l));
      recycleBmpList();
      cYO();
      cYJ();
      com.tencent.mm.wallet_core.c.ab.jZ(10, 0);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
      if (!com.tencent.mm.plugin.offline.c.a.cB(aj.getContext())) {
        break label281;
      }
      i = 0;
      label148:
      if (ay.isNetworkConnected(aj.getContext())) {
        j = 1;
      }
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.cYt();
      localh.f(14163, new Object[] { Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(com.tencent.mm.plugin.offline.e.cYj()) });
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 67L, 1L, true);
      if (!ay.isNetworkConnected(aj.getContext())) {
        break label286;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 32L, 1L, true);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.offline.c.a.cB(this)) {
        break label303;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 34L, 1L, true);
      AppMethodBeat.o(66483);
      return;
      cZa();
      break;
      label281:
      i = 1;
      break label148;
      label286:
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 33L, 1L, true);
    }
    label303:
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 35L, 1L, true);
    AppMethodBeat.o(66483);
  }
  
  private void nS(boolean paramBoolean)
  {
    AppMethodBeat.i(66508);
    if (!com.tencent.mm.plugin.offline.c.a.cZi())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.cZi()) });
      AppMethodBeat.o(66508);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.nT(false).size() <= 0)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      this.ulC.setVisibility(8);
      AppMethodBeat.o(66508);
      return;
    }
    final ArrayList localArrayList = ae.sB(true);
    int i;
    Object localObject;
    int j;
    if ((paramBoolean) && (this.lBF == null))
    {
      this.lBF = new com.tencent.mm.ui.widget.a.e(this, 2, true);
      this.umb = -1;
      this.lBF.bfo();
      i = 0;
      localObject = null;
      j = 0;
      label128:
      if (i >= localArrayList.size()) {
        break label213;
      }
      Bankcard localBankcard = (Bankcard)localArrayList.get(i);
      if ((bt.isNullOrNil(localBankcard.field_bindSerial)) || (!this.uiA.equals(localBankcard.field_bindSerial))) {
        break label352;
      }
      j = i;
      localObject = localBankcard;
    }
    label213:
    label352:
    for (;;)
    {
      i += 1;
      break label128;
      this.lBF = null;
      this.lBF = new com.tencent.mm.ui.widget.a.e(this, 2, true);
      break;
      if (localObject != null)
      {
        localArrayList.remove(localObject);
        localArrayList.add(0, localObject);
        j = 0;
      }
      this.lBF.HrX = new n.c()
      {
        public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(184860);
          paramAnonymousl.clear();
          int i = 0;
          final Bankcard localBankcard;
          Object localObject1;
          Object localObject3;
          Bitmap localBitmap;
          if (i < localArrayList.size())
          {
            localBankcard = (Bankcard)localArrayList.get(i);
            localObject1 = com.tencent.mm.plugin.offline.c.a.ajR(localBankcard.field_bankcardType);
            localObject3 = localObject1;
            if (localBankcard.ebw())
            {
              localObject3 = localObject1;
              if (localBankcard.Acf != null) {
                localObject3 = localBankcard.Acf.dct;
              }
            }
            localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject3));
            com.tencent.mm.platformtools.u.a(new u.a()
            {
              public final void l(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(184858);
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(184857);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletOfflineCoinPurseUI.28.1.this.umK });
                    if (WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).containsKey(paramAnonymous2String))
                    {
                      int i = ((Integer)WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).get(paramAnonymous2String)).intValue();
                      if (WalletOfflineCoinPurseUI.28.1.this.sXf.getItem(i) != null)
                      {
                        WalletOfflineCoinPurseUI.28.1.this.sXf.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.a(paramAnonymous2Bitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), true, false)));
                        WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).ffw();
                      }
                    }
                    AppMethodBeat.o(184857);
                  }
                });
                AppMethodBeat.o(184858);
              }
            });
            localObject1 = "";
            if (!bt.isNullOrNil(localBankcard.field_forbidWord)) {
              localObject1 = localBankcard.field_forbidWord;
            }
            if ((!bt.isNullOrNil((String)localObject1)) || (localBankcard.field_support_micropay)) {
              break label712;
            }
            if (bt.isNullOrNil(localBankcard.field_no_micro_word)) {
              localObject1 = "";
            }
          }
          label165:
          label191:
          label580:
          label712:
          for (;;)
          {
            Object localObject2;
            Object localObject4;
            String str;
            if (bt.isNullOrNil(localBankcard.field_forbid_title))
            {
              localObject2 = new SpannableString((CharSequence)localObject1);
              localObject4 = localObject1;
              if (((!localBankcard.ebv()) && (!localBankcard.ebw())) || (localBankcard.AbU < 0.0D)) {
                break label570;
              }
              str = localBankcard.field_desc + WalletOfflineCoinPurseUI.this.getString(2131764999, new Object[] { com.tencent.mm.wallet_core.ui.e.E(localBankcard.AbU) });
              localObject1 = null;
              if (!localBankcard.ebz()) {
                break label580;
              }
              localObject1 = com.tencent.mm.svg.a.a.g(WalletOfflineCoinPurseUI.this.getResources(), 2131690298);
              if (localObject1 == null) {
                WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).put(localObject3, Integer.valueOf(i));
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str, localObject2 });
              if (!localBankcard.ebA()) {
                break label647;
              }
              localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(WalletOfflineCoinPurseUI.this.getContext(), str);
              if (bt.isNullOrNil((String)localObject4))
              {
                if (!bt.isNullOrNil(localBankcard.Act)) {
                  break label628;
                }
                localObject2 = "";
              }
              if (localObject1 != null) {
                break label638;
              }
              localObject1 = null;
              if (!bt.isNullOrNil((String)localObject4)) {
                break label641;
              }
            }
            for (boolean bool = false;; bool = true)
            {
              paramAnonymousl.b(i, (CharSequence)localObject3, (CharSequence)localObject2, (Drawable)localObject1, bool);
              i += 1;
              break;
              localObject1 = localBankcard.field_no_micro_word;
              break label165;
              localObject4 = (String)localObject1 + " ";
              localObject2 = new SpannableString((String)localObject4 + localBankcard.field_forbid_title);
              localObject1 = new com.tencent.mm.plugin.wallet_core.ui.l(WalletOfflineCoinPurseUI.this)
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(184859);
                  paramAnonymous2View = localBankcard.field_forbid_url;
                  if ((localBankcard.ebA()) && (bt.isNullOrNil(paramAnonymous2View)))
                  {
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand");
                    paramAnonymous2View = new uj();
                    paramAnonymous2View.dzH.userName = localBankcard.zHs;
                    paramAnonymous2View.dzH.dzJ = localBankcard.zHt;
                    paramAnonymous2View.dzH.scene = 1137;
                    paramAnonymous2View.dzH.dzK = 0;
                    com.tencent.mm.sdk.b.a.ESL.l(paramAnonymous2View);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand result:%s", new Object[] { Boolean.valueOf(paramAnonymous2View.dzI.dzZ) });
                    if (paramAnonymous2View.dzI.dzZ)
                    {
                      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 1);
                      WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).bfo();
                      AppMethodBeat.o(184859);
                      return;
                    }
                    WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 0);
                    AppMethodBeat.o(184859);
                    return;
                  }
                  Intent localIntent = new Intent();
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", new Object[] { paramAnonymous2View });
                  localIntent.putExtra("rawUrl", paramAnonymous2View);
                  localIntent.putExtra("geta8key_username", com.tencent.mm.model.u.aqG());
                  localIntent.putExtra("pay_channel", 1);
                  com.tencent.mm.wallet_core.ui.e.X(WalletOfflineCoinPurseUI.this.getContext(), localIntent);
                  AppMethodBeat.o(184859);
                }
              };
              int j = ((String)localObject4).length();
              int k = ((String)localObject4).length() + localBankcard.field_forbid_title.length();
              ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(WalletOfflineCoinPurseUI.this.getResources().getColor(2131101130)), j, k, 33);
              ((SpannableString)localObject2).setSpan(localObject1, j, k, 33);
              break label191;
              str = localBankcard.field_desc;
              break label264;
              if (localBitmap == null) {
                break label289;
              }
              localObject1 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.a(localBitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), true, false));
              break label289;
              label628:
              localObject2 = localBankcard.Act;
              break label384;
              label638:
              break label392;
            }
            localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(WalletOfflineCoinPurseUI.this.getContext(), str);
            if (localObject1 == null)
            {
              localObject1 = null;
              if (!bt.isNullOrNil((String)localObject4)) {
                break label700;
              }
            }
            for (bool = false;; bool = true)
            {
              paramAnonymousl.b(i, (CharSequence)localObject3, (CharSequence)localObject2, (Drawable)localObject1, bool);
              break;
              break label669;
            }
            AppMethodBeat.o(184860);
            return;
          }
        }
      };
      this.lBF.HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(184861);
          if (WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).bfo();
            paramAnonymousMenuItem = (Bankcard)localArrayList.get(paramAnonymousInt);
            com.tencent.mm.plugin.report.service.h.vKh.f(14515, new Object[] { Integer.valueOf(3) });
            if ((!bt.isNullOrNil(paramAnonymousMenuItem.field_forbid_title)) || (!bt.isNullOrNil(paramAnonymousMenuItem.field_forbidWord)) || (!paramAnonymousMenuItem.field_support_micropay)) {
              com.tencent.mm.plugin.report.service.h.vKh.f(14515, new Object[] { Integer.valueOf(4) });
            }
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, paramAnonymousMenuItem);
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.ebA()))
            {
              WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this);
              WalletOfflineCoinPurseUI.IL(3);
            }
          }
          AppMethodBeat.o(184861);
        }
      };
      localObject = View.inflate(this, 2131495985, null);
      this.lBF.uYV = true;
      this.lBF.hRK = j;
      this.lBF.HFm = true;
      this.lBF.J((View)localObject, false);
      this.lBF.csG();
      com.tencent.mm.plugin.report.service.h.vKh.f(13955, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(66508);
      return;
    }
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(66487);
    int i;
    if (this.umc.size() >= 2)
    {
      i = this.umc.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.e.T((Bitmap)this.umc.remove(i));
        i -= 1;
      }
    }
    if (this.umd.size() >= 2)
    {
      i = this.umd.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.e.T((Bitmap)this.umd.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(66487);
  }
  
  public final void P(String paramString, long paramLong)
  {
    AppMethodBeat.i(187052);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
    IJ(1);
    nR(true);
    com.tencent.mm.wallet_core.ui.e.aby(40);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 21L, 1L, true);
    if (this.ume.iAs.isShowing())
    {
      if (this.ume.nzc)
      {
        this.ume.fkx();
        AppMethodBeat.o(187052);
        return;
      }
      this.ume.dismiss();
    }
    cYV();
    AppMethodBeat.o(187052);
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(66491);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
      AppMethodBeat.o(66491);
      return false;
    }
    cYR();
    this.ume.dismiss();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "msgtype=" + paramc.ukC);
    int i;
    if (4 == paramc.ukC)
    {
      this.ulU = false;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = this.umf;
      if (paramc == null) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
      }
      for (;;)
      {
        if ((this.ulX) && (!this.ulY))
        {
          this.ulX = false;
          this.ulU = false;
        }
        if (i != 0)
        {
          IJ(0);
          nR(true);
        }
        AppMethodBeat.o(66491);
        return true;
        if (5 == paramc.ukC)
        {
          this.ulU = true;
          this.ulX = true;
          this.ulY = false;
          if (this.umz.eFX()) {
            break label420;
          }
          this.umz.stopTimer();
          i = 0;
          break;
        }
        if (6 == paramc.ukC)
        {
          if (!this.umz.eFX()) {
            this.umz.stopTimer();
          }
          if (!this.uji.eFX()) {
            this.uji.stopTimer();
          }
          this.ulU = false;
          if (!com.tencent.mm.plugin.offline.c.a.cZj()) {
            break label1585;
          }
          i = 0;
          break;
        }
        if (8 == paramc.ukC)
        {
          if (this.umz.eFX()) {
            break label1585;
          }
          this.umz.stopTimer();
          i = 1;
          break;
        }
        if (23 == paramc.ukC)
        {
          if (this.umz.eFX()) {
            break label420;
          }
          this.umz.stopTimer();
          i = 0;
          break;
        }
        if (20 == paramc.ukC)
        {
          this.ulU = false;
          if (this.umz.eFX()) {
            break label420;
          }
          this.umz.stopTimer();
          i = 0;
          break;
        }
        if (24 != paramc.ukC) {
          break label1585;
        }
        if (com.tencent.mm.plugin.offline.c.a.cZJ())
        {
          this.ulU = true;
          if (com.tencent.mm.plugin.offline.c.a.cZJ())
          {
            if (this.mTipDialog != null) {
              break label425;
            }
            this.mTipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), false, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(184851);
                WalletOfflineCoinPurseUI.A(WalletOfflineCoinPurseUI.this);
                AppMethodBeat.o(184851);
              }
            });
          }
        }
        for (;;)
        {
          localObject1 = this.umz;
          long l = com.tencent.mm.plugin.offline.g.cYl();
          ((av)localObject1).av(l, l);
          label420:
          i = 0;
          break;
          label425:
          if (!this.mTipDialog.isShowing()) {
            this.mTipDialog.show();
          }
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + paramc.ukC);
        if (paramc.ukC == 24) {
          ((c)localObject1).mHT.vibrate(50L);
        }
        if (4 == paramc.ukC)
        {
          ((c)localObject1).a((s.b)paramc);
          com.tencent.mm.plugin.offline.g.cYm();
        }
        else
        {
          if (5 == paramc.ukC)
          {
            paramc = (s.e)paramc;
            if (paramc != null)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + paramc.ukF + " msg.wxRetMsg:" + paramc.ukG + " msg.cftRetCode:" + paramc.ukF + " msg.cftRetMsg:" + paramc.ukE);
              if ((!TextUtils.isEmpty(paramc.ukF)) || (!TextUtils.isEmpty(paramc.ukG)) || (!TextUtils.isEmpty(paramc.ukD)) || (!TextUtils.isEmpty(paramc.ukE)))
              {
                if ((!TextUtils.isEmpty(paramc.ukF)) || (!TextUtils.isEmpty(paramc.ukG)) || (TextUtils.isEmpty(paramc.ukD)) || (TextUtils.isEmpty(paramc.ukE))) {
                  break label706;
                }
                b.d(((c)localObject1).mActivity, paramc.ukE);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.offline.g.cYm();
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 0L, 1L, true);
              break;
              label706:
              if ((!TextUtils.isEmpty(paramc.ukF)) && (com.tencent.mm.plugin.offline.c.a.isNumeric(paramc.ukF))) {
                ((c)localObject1).a(null, bt.getInt(paramc.ukF, 0), paramc.ukG, paramc.ukH);
              } else {
                b.d(((c)localObject1).mActivity, paramc.ukG);
              }
            }
          }
          Object localObject2;
          if (6 == paramc.ukC)
          {
            paramc = (s.f)paramc;
            int j;
            if (paramc != null)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + paramc.ukJ);
              com.tencent.mm.plugin.offline.k.cYr();
              localObject2 = com.tencent.mm.plugin.offline.k.cYv().ajF(paramc.ukK.dcE);
              if (localObject2 == null) {
                break label944;
              }
              if (((r)localObject2).field_status != com.tencent.mm.plugin.offline.g.uiO) {
                break label939;
              }
              j = 1;
            }
            for (;;)
            {
              if (j == 0)
              {
                com.tencent.mm.plugin.offline.g.eb(paramc.ukK.dcE, com.tencent.mm.plugin.offline.g.uiO);
                com.tencent.mm.plugin.offline.c.a.a(((c)localObject1).mActivity, paramc);
                ((c)localObject1).mActivity.setResult(-1);
                ((c)localObject1).mActivity.finish();
              }
              com.tencent.mm.plugin.offline.g.cYm();
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 7L, 1L, true);
              if (com.tencent.mm.plugin.offline.c.a.unj != 4) {
                break;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
              com.tencent.mm.plugin.report.service.h.vKh.f(13412, new Object[0]);
              break;
              label939:
              j = 0;
              continue;
              label944:
              j = 0;
            }
          }
          Object localObject3;
          Object localObject4;
          if (8 == paramc.ukC)
          {
            paramc = (s.g)paramc;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + paramc.id);
            if (paramc.ocN == 0)
            {
              localObject2 = ((c)localObject1).mActivity.getLayoutInflater().inflate(2131495993, null);
              localObject3 = (TextView)((View)localObject2).findViewById(2131303150);
              localObject4 = (TextView)((View)localObject2).findViewById(2131303153);
              ((TextView)localObject3).setText(paramc.ukM);
              ((TextView)localObject4).setText(paramc.ukL);
              com.tencent.mm.plugin.offline.g.eb(paramc.dlJ, com.tencent.mm.plugin.offline.g.uiQ);
              com.tencent.mm.ui.base.h.a(((c)localObject1).mActivity, "", (View)localObject2, ((c)localObject1).getString(2131765972), ((c)localObject1).getString(2131755691), new c.11((c)localObject1, paramc), new c.12((c)localObject1, paramc));
            }
            else if (paramc.ocN == 1)
            {
              if (((c)localObject1).ulc != null) {
                ((c)localObject1).ulc.show();
              }
              com.tencent.mm.plugin.report.service.h.vKh.f(13955, new Object[] { Integer.valueOf(1) });
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + paramc.id);
              com.tencent.mm.plugin.offline.g.eb(paramc.dlJ, com.tencent.mm.plugin.offline.g.uiQ);
              ((c)localObject1).ulc = com.tencent.mm.plugin.wallet_core.ui.s.a(((c)localObject1).mActivity, paramc.ukL, paramc.ukM, new c.13((c)localObject1, paramc), new c.14((c)localObject1), new c.15((c)localObject1, paramc));
              ((c)localObject1).ulc.vRJ.setVisibility(0);
              ((c)localObject1).ulc.vGn.setVisibility(8);
            }
          }
          else
          {
            if (23 == paramc.ukC)
            {
              paramc = (s.d)paramc;
              localObject2 = new PayInfo();
              ((PayInfo)localObject2).dcE = paramc.dlJ;
              ((PayInfo)localObject2).dtb = 8;
              ((PayInfo)localObject2).Coy = 1;
              ((PayInfo)localObject2).Cos = new Bundle();
              ((PayInfo)localObject2).Cos.putLong("extinfo_key_9", System.currentTimeMillis());
              paramc = new c.1((c)localObject1, (PayInfo)localObject2);
              com.tencent.mm.sdk.b.a.ESL.b(paramc);
              com.tencent.mm.wallet_core.b.fjk();
              boolean bool1;
              label1406:
              String str;
              if ((com.tencent.mm.wallet_core.b.b(b.a.pom, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_OFFLINE_PAY_SWTICH_KEY")))
              {
                bool1 = true;
                boolean bool2 = bool1;
                if (bool1)
                {
                  com.tencent.mm.wallet_core.b.fjk();
                  bool2 = com.tencent.mm.wallet_core.b.b(b.a.pri, false);
                }
                if (!bool2) {
                  break label1510;
                }
                localObject3 = (com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class);
                localObject4 = ((c)localObject1).mActivity;
                str = ((PayInfo)localObject2).dcE;
                if (((c)localObject1).ulb != null) {
                  break label1496;
                }
              }
              label1496:
              for (paramc = "";; paramc = ((c)localObject1).ulb.cYC())
              {
                ((com.tencent.mm.pluginsdk.wallet.a)localObject3).startOfflinePay((Context)localObject4, str, paramc, ((PayInfo)localObject2).channel);
                break;
                bool1 = false;
                break label1406;
              }
              label1510:
              localObject3 = ((c)localObject1).mActivity;
              if (((c)localObject1).ulb == null) {}
              for (paramc = "";; paramc = ((c)localObject1).ulb.cYC())
              {
                com.tencent.mm.pluginsdk.wallet.f.a((Context)localObject3, false, "", paramc, (PayInfo)localObject2, "", new Intent(), 1);
                break;
              }
            }
            if (20 == paramc.ukC) {
              com.tencent.mm.plugin.offline.g.cYm();
            }
          }
        }
      }
      label1585:
      i = 1;
    }
  }
  
  public void addDialog(Dialog paramDialog)
  {
    AppMethodBeat.i(66492);
    if (((paramDialog instanceof com.tencent.mm.ui.widget.a.d)) && (this.ulX))
    {
      this.ulY = true;
      paramDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(184850);
          if (this.umH != null) {
            this.umH.onDismiss(paramAnonymousDialogInterface);
          }
          if (WalletOfflineCoinPurseUI.w(WalletOfflineCoinPurseUI.this))
          {
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.x(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.y(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.z(WalletOfflineCoinPurseUI.this);
          }
          AppMethodBeat.o(184850);
        }
      });
    }
    super.addDialog(paramDialog);
    AppMethodBeat.o(66492);
  }
  
  public final void bIp()
  {
    AppMethodBeat.i(66512);
    IJ(0);
    nR(true);
    AppMethodBeat.o(66512);
  }
  
  public final void cYA()
  {
    AppMethodBeat.i(66514);
    nS(false);
    AppMethodBeat.o(66514);
  }
  
  public final void cYB()
  {
    AppMethodBeat.i(66515);
    doSceneProgress(new j(""), false);
    AppMethodBeat.o(66515);
  }
  
  public final String cYC()
  {
    return this.uiA;
  }
  
  public final void cYD()
  {
    AppMethodBeat.i(66518);
    if (!this.uji.eFX()) {
      this.uji.stopTimer();
    }
    IJ(0);
    nR(true);
    this.ulU = false;
    av localav = this.uji;
    long l = this.ujh;
    localav.av(l, l);
    AppMethodBeat.o(66518);
  }
  
  public final void cYS()
  {
    int j = 0;
    AppMethodBeat.i(66498);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.cZk();
    findViewById(2131306839).setVisibility(0);
    this.ulC.setTextSize(0, getResources().getDimensionPixelSize(2131165517));
    String str;
    Object localObject;
    if ((this.ulC != null) && (localBankcard != null)) {
      if (localBankcard.ebA())
      {
        str = localBankcard.Acr;
        localObject = com.tencent.mm.plugin.wallet_core.model.s.ecc().eda();
        if ((localObject == null) || (bt.isNullOrNil(localBankcard.field_forbidWord))) {
          break label347;
        }
        Iterator localIterator = ((List)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (com.tencent.mm.plugin.wallet_core.model.c)localIterator.next();
        } while (!((com.tencent.mm.plugin.wallet_core.model.c)localObject).uns.equals(localBankcard.field_bindSerial));
      }
    }
    for (;;)
    {
      if ((localObject != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.wallet_core.model.c)localObject).AbF)))
      {
        if (!localBankcard.ebA()) {
          str = localBankcard.field_desc + ((com.tencent.mm.plugin.wallet_core.model.c)localObject).AbF;
        }
        findViewById(2131306839).setVisibility(8);
        com.tencent.mm.plugin.report.service.h.vKh.f(14515, new Object[] { Integer.valueOf(2) });
        this.ulC.setTextSize(0, getResources().getDimensionPixelSize(2131165466));
      }
      for (int i = 1;; i = 0)
      {
        this.ulC.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), str, this.ulC.getTextSize()));
        for (;;)
        {
          if (localBankcard != null) {
            a(localBankcard);
          }
          if (i != 0) {
            this.ulD.setImageResource(2131690126);
          }
          AppMethodBeat.o(66498);
          return;
          str = getString(2131765945, new Object[] { localBankcard.field_desc });
          break;
          i = j;
          if (localBankcard == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
            i = j;
          }
        }
      }
      label347:
      localObject = null;
    }
  }
  
  public final void cYZ()
  {
    AppMethodBeat.i(66505);
    this.ulE.setVisibility(4);
    this.umg.a(this.ulw, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174394);
        com.tencent.mm.plugin.offline.c.a.cZu();
        com.tencent.mm.plugin.offline.c.a.k(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this));
        WalletOfflineCoinPurseUI.this.finish();
        AppMethodBeat.o(174394);
      }
    });
    AppMethodBeat.o(66505);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66513);
    doSceneProgress(new com.tencent.mm.plugin.offline.a.e(paramInt, paramString1, paramString2, paramString3), com.tencent.mm.plugin.offline.c.a.cZj());
    AppMethodBeat.o(66513);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495987;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(174404);
    Resources localResources = super.getResources();
    AppMethodBeat.o(174404);
    return localResources;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66477);
    this.umg = ((OfflineAlertView)findViewById(2131302989));
    this.umg.dismiss();
    this.umg.setDialogState(new OfflineAlertView.a()
    {
      public final void onClose()
      {
        AppMethodBeat.i(184845);
        WalletOfflineCoinPurseUI.g(WalletOfflineCoinPurseUI.this);
        AppMethodBeat.o(184845);
      }
      
      public final void onShow()
      {
        AppMethodBeat.i(184846);
        WalletOfflineCoinPurseUI.g(WalletOfflineCoinPurseUI.this);
        AppMethodBeat.o(184846);
      }
    });
    com.tencent.mm.wallet_core.c.b.fjR().init(getApplicationContext());
    Object localObject;
    if ((this.mEntryScene == 3) || (this.mEntryScene == 10) || (this.mEntryScene == 11) || (this.mEntryScene == 12))
    {
      setMMTitle(2131765959);
      this.umf = new c(this, this);
      localObject = this.umf;
      ((c)localObject).mHT = ((Vibrator)((c)localObject).mActivity.getSystemService("vibrator"));
      this.ume = new com.tencent.mm.wallet_core.ui.c(this, true);
      this.ume.fkv();
      this.ulw = findViewById(2131306828);
      this.ulx = ((ImageView)findViewById(2131306827));
      this.uly = ((ImageView)findViewById(2131306693));
      this.ulz = ((TextView)findViewById(2131306694));
      this.ulB = findViewById(2131306838);
      this.ulC = ((TextView)findViewById(2131306840));
      this.ulD = ((ImageView)findViewById(2131306837));
      this.ulE = ((RelativeLayout)findViewById(2131306763));
      this.ulF = ((LinearLayout)findViewById(2131306843));
      this.ulG = ((CdnImageView)findViewById(2131306844));
      this.ulH = ((TextView)findViewById(2131306842));
      this.ulI = ((TextView)findViewById(2131306841));
      this.ulE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66409);
          WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this);
          AppMethodBeat.o(66409);
        }
      });
      this.ulx.setOnClickListener(this.iAw);
      this.uly.setOnClickListener(this.iAw);
      this.ulz.setOnClickListener(this.iAw);
      this.ulB.setClickable(true);
      this.ulB.setOnClickListener(new WalletOfflineCoinPurseUI.9(this));
      this.mLastTime = System.currentTimeMillis();
      this.ulJ = new e();
      this.ulJ.cNE();
      com.tencent.mm.plugin.newtips.a.cWs().h(this.ulJ);
      this.ulK = new g();
      this.ulK.cNE();
      com.tencent.mm.plugin.newtips.a.cWs().h(this.ulK);
      this.ulL = new b();
      this.ulL.cNE();
      com.tencent.mm.plugin.newtips.a.cWs().h(this.ulL);
      this.ulM = new f();
      this.ulM.cNE();
      com.tencent.mm.plugin.newtips.a.cWs().h(this.ulM);
      this.ulN = new d();
      this.ulN.cNE();
      com.tencent.mm.plugin.newtips.a.cWs().h(this.ulN);
      if ((this.mEntryScene != 3) && (this.mEntryScene != 10) && (this.mEntryScene != 11) && (this.mEntryScene != 12)) {
        break label901;
      }
      this.ulO.setVisibility(8);
      this.ulP.setVisibility(8);
      this.ulQ.setVisibility(8);
      this.ulR.setVisibility(8);
      label613:
      if ((com.tencent.mm.plugin.offline.c.a.cZi()) && (c.cYF()))
      {
        localObject = this.umf;
        com.tencent.mm.plugin.offline.k.cYr();
        ((c)localObject).a(com.tencent.mm.plugin.offline.k.cYs().ukv);
      }
      cYL();
      R(true, false);
      localObject = this.uji;
      long l1 = this.ujh;
      ((av)localObject).av(l1, l1);
      if ((com.tencent.mm.plugin.offline.c.a.unj != 3) || (!com.tencent.mm.plugin.offline.c.a.unm)) {
        break label1134;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
      int i = com.tencent.mm.plugin.offline.c.a.unk;
      l1 = com.tencent.mm.plugin.offline.c.a.unl;
      long l2 = System.currentTimeMillis();
      long l3 = i * 1000 + l1 - l2;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + l1 + " now:" + l2 + " interval:" + l3);
      if ((com.tencent.mm.plugin.offline.c.a.unk <= 0) || (com.tencent.mm.plugin.offline.c.a.unl <= 0L) || (l3 <= 0L)) {
        break label1122;
      }
      if (!this.umA.eFX()) {
        this.umA.stopTimer();
      }
      this.umA.av(l3, l3);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
    }
    for (;;)
    {
      cYK();
      localObject = new xd();
      ((xd)localObject).dCC.scene = "5";
      ((xd)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66407);
          if (!bt.isNullOrNil(this.nYZ.dCD.dCE))
          {
            com.tencent.mm.wallet_core.ui.e.a((TextView)WalletOfflineCoinPurseUI.this.findViewById(2131297186), this.nYZ.dCD.dCE, this.nYZ.dCD.content, this.nYZ.dCD.url);
            AppMethodBeat.o(66407);
            return;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
          AppMethodBeat.o(66407);
        }
      };
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(66477);
      return;
      setMMTitle(2131765960);
      break;
      label901:
      this.ulR.setVisibility(0);
      this.ulS.setVisibility(0);
      final boolean bool1 = com.tencent.mm.plugin.newtips.a.g.b(this.ulJ);
      final boolean bool2 = com.tencent.mm.plugin.newtips.a.g.b(this.ulL);
      final boolean bool3 = com.tencent.mm.plugin.newtips.a.g.b(this.ulM);
      final boolean bool4 = com.tencent.mm.plugin.newtips.a.g.b(this.ulK);
      final boolean bool5 = com.tencent.mm.plugin.newtips.a.g.b(this.ulN);
      if (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FrC, Boolean.FALSE)).booleanValue()) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
      }
      ImageView localImageView;
      for (;;)
      {
        localObject = (TextView)findViewById(2131297128);
        localImageView = (ImageView)findViewById(2131297127);
        if (!this.umk) {
          break label1098;
        }
        ((TextView)localObject).setText(2131756357);
        localImageView.setImageResource(2131690666);
        localImageView.getDrawable().setColorFilter(getResources().getColor(2131099828), PorterDuff.Mode.SRC_ATOP);
        break;
        getWindow().getDecorView().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(184847);
            ScrollView localScrollView = (ScrollView)WalletOfflineCoinPurseUI.this.findViewById(2131302992);
            if (localScrollView == null)
            {
              AppMethodBeat.o(184847);
              return;
            }
            int[] arrayOfInt = new int[2];
            localScrollView.getLocationInWindow(arrayOfInt);
            int i = com.tencent.mm.ui.ai.cf(WalletOfflineCoinPurseUI.this.getContext()).y;
            int j = i;
            if (com.tencent.mm.ui.ai.ju(WalletOfflineCoinPurseUI.this.getContext()))
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
              j = i - com.tencent.mm.ui.ai.eb(WalletOfflineCoinPurseUI.this.getContext());
            }
            if (bool1) {}
            for (i = arrayOfInt[1] + WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).getBottom();; i = 0)
            {
              if (bool4) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).getBottom();
              }
              if (bool2) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).getBottom();
              }
              if (bool3) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).getBottom();
              }
              if (bool5) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).getBottom();
              }
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
              i -= j;
              if (i > 0) {
                localScrollView.scrollBy(0, i);
              }
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrC, Boolean.TRUE);
              AppMethodBeat.o(184847);
              return;
            }
          }
        });
      }
      label1098:
      ((TextView)localObject).setText(2131756407);
      localImageView.setImageResource(2131689757);
      localImageView.clearColorFilter();
      break label613;
      label1122:
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
      continue;
      label1134:
      if (com.tencent.mm.plugin.offline.c.a.unj == 3) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
      } else {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.c.a.unj) });
      }
    }
  }
  
  public final void l(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(66496);
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(66496);
      return;
    }
    final ImageView localImageView = (ImageView)this.ull.get(paramString);
    paramString = (Integer)this.ulm.get(paramString);
    if ((localImageView == null) || (paramString == null))
    {
      AppMethodBeat.o(66496);
      return;
    }
    new ap(getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184852);
        int i = paramString.intValue();
        Bitmap localBitmap = com.tencent.mm.sdk.platformtools.f.a(paramBitmap, i, i, true, false);
        localImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(184852);
      }
    });
    AppMethodBeat.o(66496);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66469);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.wallet_core.model.s.ebW();
    this.umk = com.tencent.mm.plugin.wallet_core.model.s.ecl();
    com.tencent.mm.plugin.offline.k.ujs = true;
    com.tencent.mm.wallet_core.ui.e.aby(41);
    paramBundle = getIntent();
    this.ulW = paramBundle.getBooleanExtra("is_offline_create", false);
    if ((paramBundle != null) && (paramBundle.hasExtra("key_entry_scene"))) {
      this.mEntryScene = paramBundle.getIntExtra("key_entry_scene", this.mEntryScene);
    }
    this.fsv = paramBundle.getIntExtra("key_from_scene", 0);
    this.ulA = bt.by(paramBundle.getStringExtra("key_business_attach"), "");
    this.pOf = 1;
    if (this.mEntryScene == 2) {
      this.pOf = 1;
    }
    for (;;)
    {
      getWindow().addFlags(8192);
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
      setContentViewVisibility(0);
      setActionbarColor(getResources().getColor(2131099824));
      hideActionbarLine();
      paramBundle = getWindow().getAttributes();
      if (paramBundle.screenBrightness < 0.85F)
      {
        paramBundle.screenBrightness = 0.85F;
        getWindow().setAttributes(paramBundle);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(184867);
          paramAnonymousMenuItem = new hl();
          paramAnonymousMenuItem.dlc.dld = "ok";
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
          if (WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this) == 8) {
            com.tencent.mm.plugin.offline.c.a.ajW(WalletOfflineCoinPurseUI.this.getIntent().getStringExtra("key_appid"));
          }
          WalletOfflineCoinPurseUI.this.finish();
          AppMethodBeat.o(184867);
          return false;
        }
      });
      try
      {
        bh.a(this, this);
        i = 1;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", paramBundle, "", new Object[0]);
          getWindow().setFlags(8192, 8192);
          int i = 0;
          continue;
          if (com.tencent.mm.plugin.wallet_core.model.s.ecc().ecH())
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
            com.tencent.mm.plugin.offline.c.a.cZu();
            com.tencent.mm.plugin.offline.k.cYr();
            com.tencent.mm.plugin.offline.k.bp(196648, "0");
          }
          else if ((com.tencent.mm.plugin.wallet_core.model.s.ecc().ecF()) && (com.tencent.mm.plugin.offline.c.a.cZi()))
          {
            cZc();
          }
        }
      }
      if (i == 0) {
        bh.a(this, null);
      }
      com.tencent.mm.wallet_core.ui.e.fkA();
      if (!com.tencent.mm.plugin.wallet_core.model.s.ecc().ecK()) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
      initView();
      com.tencent.mm.platformtools.u.a(this);
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.cYs().a(this);
      addSceneEndListener(606);
      addSceneEndListener(609);
      addSceneEndListener(1501);
      com.tencent.mm.plugin.offline.k.cYr();
      com.tencent.mm.plugin.offline.k.cYt().dy(this);
      com.tencent.mm.sdk.b.a.ESL.c(this.umx);
      com.tencent.mm.plugin.offline.c.a.cZv();
      com.tencent.mm.sdk.b.a.ESL.b(this.umv);
      com.tencent.mm.sdk.b.a.ESL.b(this.umt);
      com.tencent.mm.sdk.b.a.ESL.b(this.ump);
      this.umq.alive();
      this.umr.alive();
      this.ums.alive();
      this.ulV = new com.tencent.mm.plugin.offline.g();
      paramBundle = new mv();
      paramBundle.dsb.aFj = hashCode();
      com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
      this.umu.alive();
      AppMethodBeat.o(66469);
      return;
      if (this.mEntryScene == 1) {
        this.pOf = 2;
      } else if (this.mEntryScene == 8) {
        this.pOf = 4;
      } else if (this.mEntryScene == 4) {
        this.pOf = 6;
      } else {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[] { Integer.valueOf(this.pOf) });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66475);
    Object localObject = com.tencent.mm.plugin.offline.c.a.cZk();
    if (localObject != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerial:%s serial:%s mLastBindSerial:%s", new Object[] { this.uiA, ((Bankcard)localObject).field_bindSerial, this.ulv });
      if (((Bankcard)localObject).ebA())
      {
        localObject = this.ulv;
        bt.isNullOrNil(this.ulv);
        com.tencent.mm.plugin.offline.c.a.ajL((String)localObject);
        com.tencent.mm.plugin.offline.k.cYr();
        com.tencent.mm.plugin.offline.k.cYt().uiA = ((String)localObject);
      }
    }
    this.umg.dismiss();
    com.tencent.mm.plugin.offline.k.ujs = false;
    com.tencent.mm.wallet_core.ui.e.T(this.uln);
    com.tencent.mm.wallet_core.ui.e.T(this.ulo);
    com.tencent.mm.wallet_core.ui.e.aQ(this.umc);
    com.tencent.mm.wallet_core.ui.e.aQ(this.umd);
    this.umc.clear();
    this.umd.clear();
    this.uls.clear();
    this.ult.clear();
    this.ulu.clear();
    com.tencent.mm.platformtools.u.c(this);
    com.tencent.mm.plugin.offline.k.cYr();
    com.tencent.mm.plugin.offline.k.cYs().b(this);
    removeSceneEndListener(606);
    removeSceneEndListener(609);
    removeSceneEndListener(1501);
    com.tencent.mm.plugin.offline.k.cYr();
    com.tencent.mm.plugin.offline.k.cYt().dz(this);
    com.tencent.mm.sdk.b.a.ESL.d(this.umx);
    com.tencent.mm.sdk.b.a.ESL.d(this.umv);
    com.tencent.mm.sdk.b.a.ESL.d(this.ump);
    if (!this.uji.eFX()) {
      this.uji.stopTimer();
    }
    if (!this.umA.eFX()) {
      this.umA.stopTimer();
    }
    if (this.ume != null) {
      this.ume.release();
    }
    if (this.umf != null)
    {
      localObject = this.umf;
      ((c)localObject).mHT.cancel();
      ((c)localObject).mActivity = null;
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.umt);
    this.umr.dead();
    this.ums.dead();
    localObject = this.ulV;
    ((com.tencent.mm.plugin.offline.g)localObject).stop();
    com.tencent.mm.plugin.offline.g.cYm();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(385, ((com.tencent.mm.plugin.offline.g)localObject).uiS);
    ((com.tencent.mm.plugin.offline.g)localObject).uiU = null;
    this.umu.dead();
    this.umq.dead();
    com.tencent.mm.plugin.remittance.mobile.a.b.Kx(0);
    super.onDestroy();
    AppMethodBeat.o(66475);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66517);
    if ((paramInt == 4) && (this.umg != null) && (this.umg.getVisibility() == 0) && (this.umg.ukP))
    {
      this.umg.dismiss();
      AppMethodBeat.o(66517);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(66517);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(66473);
    super.onNewIntent(paramIntent);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
    this.ulq = true;
    AppMethodBeat.o(66473);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66474);
    com.tencent.mm.plugin.offline.k.cYr();
    com.tencent.mm.plugin.offline.i locali = com.tencent.mm.plugin.offline.k.cYu();
    locali.mHandler.removeCallbacks(locali.ujg);
    bh.a(this, null);
    this.cwr = false;
    com.tencent.mm.sdk.b.a.ESL.d(this.umw);
    this.ulV.stop();
    super.onPause();
    AppMethodBeat.o(66474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66471);
    super.onResume();
    com.tencent.mm.sdk.b.a.ESL.c(this.umw);
    try
    {
      bh.a(this, this);
      if (!this.umh)
      {
        cYH();
        this.umh = true;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
      this.cwr = true;
      Object localObject = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).a(this, ((com.tencent.mm.plugin.walletlock.a.b)localObject).efN(), null);
      if (ay.isNetworkConnected(getBaseContext()))
      {
        if (com.tencent.mm.plugin.wallet_core.model.s.ecc().ecK()) {
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 8));
        }
        if ((com.tencent.mm.plugin.offline.c.a.cZi()) && (this.umo))
        {
          com.tencent.mm.plugin.offline.k.cYr();
          com.tencent.mm.plugin.offline.k.cYu().nQ(false);
          if (!c.cYF()) {
            doSceneProgress(new com.tencent.mm.plugin.offline.a.q(this.mEntryScene, this.jqR, this.uml), false);
          }
        }
      }
      if (!this.umo) {
        this.umo = true;
      }
      cYL();
      localObject = com.tencent.mm.plugin.offline.c.a.cZk();
      if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (!((Bankcard)localObject).field_bindSerial.equals(this.uiA)))
      {
        this.uiA = ((Bankcard)localObject).field_bindSerial;
        com.tencent.mm.plugin.offline.k.cYr();
        com.tencent.mm.plugin.offline.k.cYt().uiA = this.uiA;
        i = 1;
        if ((i != 0) || ((this.ulr) && (this.ulq)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
          this.ulr = false;
          this.ulq = false;
          cYS();
          IJ(0);
          nR(true);
        }
        localObject = this.ulV;
        if (!com.tencent.mm.plugin.offline.c.a.cZJ()) {
          break label511;
        }
        com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.offline.g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + ((com.tencent.mm.plugin.offline.g)localObject).uiU.eFX());
        if ((((com.tencent.mm.plugin.offline.g)localObject).uiU == null) || (((com.tencent.mm.plugin.offline.g)localObject).uiU.eFX()))
        {
          ((com.tencent.mm.plugin.offline.g)localObject).status = 1;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 61L, 1L, true);
          if (!((com.tencent.mm.plugin.offline.g)localObject).uiT) {
            break label485;
          }
          com.tencent.mm.plugin.offline.g.cYm();
          localObject = ((com.tencent.mm.plugin.offline.g)localObject).uiU;
          l = com.tencent.mm.plugin.offline.g.uiD;
          ((av)localObject).av(l, l);
          i = com.tencent.mm.plugin.offline.g.uiD;
        }
        if (this.umm)
        {
          this.umm = false;
          com.tencent.mm.plugin.report.service.h.vKh.f(18930, new Object[] { Integer.valueOf(this.umn), Integer.valueOf(4) });
        }
        AppMethodBeat.o(66471);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", localException, "", new Object[0]);
        continue;
        int i = 0;
        continue;
        label485:
        av localav = localException.uiU;
        long l = com.tencent.mm.plugin.offline.g.uiR;
        localav.av(l, l);
        i = com.tencent.mm.plugin.offline.g.uiR;
        continue;
        label511:
        com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.offline.g.TAG, "OfflineGetMsg is not in abtest");
      }
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(66476);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " scene: " + paramn);
    if (((paramn instanceof com.tencent.mm.plugin.offline.a.f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.ujf.cYw();
      this.ujf = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
      {
        if (this.umi)
        {
          this.umi = false;
          paramString = com.tencent.mm.plugin.offline.c.a.cZl();
          if (paramString != null) {
            doSceneForceProgress(new com.tencent.mm.plugin.offline.a.k(paramString, this.umj, 0));
          }
          AppMethodBeat.o(66476);
          return true;
        }
        if (com.tencent.mm.plugin.offline.c.a.cZi())
        {
          if (com.tencent.mm.plugin.offline.c.a.cZl() != null) {
            doSceneProgress(new com.tencent.mm.plugin.offline.a.n(System.currentTimeMillis(), this.mEntryScene), false);
          }
          cZc();
        }
        paramString = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).zWJ;
        if ((paramString == null) || (paramString.AeO == 0))
        {
          if (this.umg.ukO == 7) {
            this.umg.dismiss();
          }
          cZb();
          label272:
          if ((!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.n)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.a)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.e))) {
            break label1441;
          }
          cYL();
          R(false, true);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66476);
      return true;
      if (!this.umg.II(7)) {
        break;
      }
      if (this.umg.ukO == 7) {
        this.umg.dismiss();
      }
      this.umn = paramString.AeN;
      Object localObject1 = this.umg;
      View localView = this.ulw;
      Object localObject2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184855);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "do click fqf text link");
          WalletOfflineCoinPurseUI.H(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.I(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this, "weixin://wcpay/fqf/opentinyapp");
          AppMethodBeat.o(184855);
        }
      };
      com.tencent.mm.plugin.report.service.h.vKh.f(18930, new Object[] { Integer.valueOf(paramString.AeN), Integer.valueOf(1) });
      ((OfflineAlertView)localObject1).ukO = 7;
      ((OfflineAlertView)localObject1).setVisibility(0);
      ((OfflineAlertView)localObject1).ukP = false;
      ((OfflineAlertView)localObject1).hSI.removeAllViews();
      Object localObject3 = LayoutInflater.from(((OfflineAlertView)localObject1).getContext()).inflate(2131495990, ((OfflineAlertView)localObject1).hSI, false);
      ((OfflineAlertView)localObject1).hSI.addView((View)localObject3);
      Object localObject4 = (TextView)((View)localObject3).findViewById(2131302001);
      TextView localTextView = (TextView)((View)localObject3).findViewById(2131305510);
      localObject3 = (Button)((View)localObject3).findViewById(2131300871);
      if (!bt.isNullOrNil(paramString.AeQ)) {
        ((TextView)localObject4).setText(paramString.AeQ);
      }
      if (!bt.isNullOrNil(paramString.AeR))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("repayment_tiny_app_username", paramString.AeS);
        ((Bundle)localObject4).putString("repayment_tiny_app_path", paramString.AeT);
        localTextView.setText(paramString.AeR);
        com.tencent.mm.pluginsdk.ui.span.k.a(localTextView, false, localObject4);
        if (((OfflineAlertView)localObject1).mYs != null) {
          com.tencent.mm.pluginsdk.ui.span.k.b(((OfflineAlertView)localObject1).mYs);
        }
        ((OfflineAlertView)localObject1).mYs = new OfflineAlertView.2((OfflineAlertView)localObject1, (View.OnClickListener)localObject2, paramString);
        com.tencent.mm.pluginsdk.ui.span.k.a(((OfflineAlertView)localObject1).mYs);
      }
      if (paramString.AeP > 0)
      {
        ((Button)localObject3).setEnabled(false);
        if (((OfflineAlertView)localObject1).ukR == null) {
          break label705;
        }
        ((OfflineAlertView)localObject1).ukR.cancel();
      }
      for (;;)
      {
        ((OfflineAlertView)localObject1).ukR.start();
        ((Button)localObject3).setOnClickListener(new OfflineAlertView.4((OfflineAlertView)localObject1, paramString));
        localView.post(new OfflineAlertView.5((OfflineAlertView)localObject1, localView));
        break;
        label705:
        localObject2 = new com.tencent.mm.wallet_core.c.c();
        ((com.tencent.mm.wallet_core.c.c)localObject2).duration = (paramString.AeP * 1000);
        ((com.tencent.mm.wallet_core.c.c)localObject2).interval = 1000L;
        ((com.tencent.mm.wallet_core.c.c)localObject2).Ide = new OfflineAlertView.3((OfflineAlertView)localObject1, (Button)localObject3);
        ((OfflineAlertView)localObject1).ukR = new com.tencent.mm.wallet_core.c.c.1((com.tencent.mm.wallet_core.c.c)localObject2, ((com.tencent.mm.wallet_core.c.c)localObject2).duration, ((com.tencent.mm.wallet_core.c.c)localObject2).interval);
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.m))
      {
        this.ujf = ((com.tencent.mm.plugin.offline.a.m)paramn);
        paramString = this.ujf.ukj;
        com.tencent.mm.plugin.offline.k.cYr();
        paramString = new com.tencent.mm.plugin.offline.a.f(paramString, com.tencent.mm.plugin.offline.k.IH(196617));
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
        break label272;
      }
      if ((paramn instanceof j))
      {
        cYL();
        cYH();
        break label272;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.n))
      {
        paramString = (com.tencent.mm.plugin.offline.a.n)paramn;
        if ("1".equals(paramString.uko))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
          if (bt.isNullOrNil(paramString.ukp)) {}
          for (paramString = getString(2131765224);; paramString = paramString.ukp)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(184844);
                WalletOfflineCoinPurseUI.this.finish();
                AppMethodBeat.o(184844);
              }
            });
            AppMethodBeat.o(66476);
            return true;
          }
        }
        if (paramString.ujJ == 0)
        {
          localObject1 = this.umf;
          ((c)localObject1).uld = com.tencent.mm.plugin.offline.c.a.cZp();
          ((c)localObject1).uld = ((c)localObject1).uld;
          if (!"1".equals(paramString.ukn)) {
            break label272;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
          doSceneProgress(new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 8), false);
          break label272;
        }
        if (paramString.ujJ == 0) {
          break label272;
        }
        this.umf.a(paramString, paramString.ujJ, paramString.ujK);
        break label272;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.a)) {
        break label272;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
      {
        this.umf.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        break label272;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
      {
        if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
          this.mTipDialog.dismiss();
        }
        paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.i)paramn;
        if (("1".equals(paramString.Aai)) || (("2".equals(paramString.Aai)) && (!bt.isNullOrNil(paramString.Aaj))))
        {
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_activity", ".ui.WalletOfflineCoinPurseUI");
          paramString.putString("realname_verify_process_jump_plugin", "offline");
          com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString, null, 1006);
        }
        for (;;)
        {
          AppMethodBeat.o(66476);
          return true;
          if ("collect".equals(paramString.Aam)) {
            cYI();
          } else if ("reward".equals(paramString.Aam)) {
            com.tencent.mm.bs.d.O(getContext(), "collect", ".reward.ui.QrRewardMainUI");
          } else {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { paramString.Aam });
          }
        }
      }
      if (!(paramn instanceof com.tencent.mm.plugin.offline.a.q)) {
        break label272;
      }
      paramString = (com.tencent.mm.plugin.offline.a.q)paramn;
      this.ulZ = true;
      if ((paramString.isJumpRemind()) && (!this.uma && (paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
      {
        public final void cMH() {}
      }))) {
        this.uma = true;
      }
      onSceneEnd(paramString.uku.errType, paramString.uku.errCode, paramString.uku.errMsg, paramString.uks);
      onSceneEnd(paramString.ukt.errType, paramString.ukt.errCode, paramString.ukt.errMsg, paramString.ukr);
      if ((this.lBF == null) || (!this.lBF.isShowing()) || (this.umb != 1)) {
        break label272;
      }
      nS(true);
      break label272;
      label1441:
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.f))
      {
        cYL();
        R(true, true);
      }
      else if ((paramn instanceof com.tencent.mm.plugin.offline.a.k))
      {
        com.tencent.mm.plugin.offline.c.a.au(this);
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 8), false);
        cYW();
        cYX();
        cYU();
        continue;
        if ((paramn instanceof com.tencent.mm.plugin.offline.a.n))
        {
          cYL();
          R(false, true);
          if (411 == paramInt2) {
            this.umf.a(paramn, paramInt2, paramString);
          }
        }
        else if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
        {
          this.umf.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        }
        else if (!(paramn instanceof j))
        {
          if ((paramn instanceof com.tencent.mm.plugin.offline.a.f))
          {
            this.ujf = null;
          }
          else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
          {
            if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
              this.mTipDialog.dismiss();
            }
          }
          else if ((paramn instanceof com.tencent.mm.plugin.offline.a.q))
          {
            cYL();
            R(false, true);
            if (411 == paramInt2) {
              this.umf.a(paramn, paramInt2, paramString);
            }
          }
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b
    extends WalletOfflineCoinPurseUI.a
  {
    public b()
    {
      super();
    }
    
    public final boolean cNE()
    {
      AppMethodBeat.i(66444);
      super.cNE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.z.c.adr().b(ae.a.Frx, ae.a.Fqt))
      {
        this.umO.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.uew, true);
      }
      AppMethodBeat.o(66444);
      return true;
    }
    
    public final void cZe()
    {
      AppMethodBeat.i(66443);
      WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306758));
      this.umO = ((ImageView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296290));
      this.umP = ((TextView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296301));
      this.umQ = ((ImageView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296300));
      WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66442);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
          com.tencent.mm.plugin.newtips.a.cWs().Ip(16);
          com.tencent.mm.plugin.report.service.h.vKh.f(14021, new Object[] { Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          paramAnonymousView = new Intent();
          if (WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this) == 1) {
            paramAnonymousView.putExtra("enter_scene", 2);
          }
          for (;;)
          {
            com.tencent.mm.bs.d.b(WalletOfflineCoinPurseUI.this.getContext(), "aa", ".ui.AAEntranceUI", paramAnonymousView);
            WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
            if (com.tencent.mm.z.c.adr().b(ae.a.Frx, ae.a.Fqt))
            {
              com.tencent.mm.z.c.adr().c(ae.a.Frx, ae.a.Fqt);
              WalletOfflineCoinPurseUI.b.this.umO.setVisibility(8);
              com.tencent.mm.plugin.report.service.h.vKh.f(14396, new Object[] { Integer.valueOf(4) });
            }
            AppMethodBeat.o(66442);
            return;
            if (WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this) == 2) {
              paramAnonymousView.putExtra("enter_scene", 4);
            } else {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { Integer.valueOf(WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this)) });
            }
          }
        }
      });
      AppMethodBeat.o(66443);
    }
    
    public final String getPath()
    {
      return "grouppayreddot";
    }
    
    public final View getRoot()
    {
      AppMethodBeat.i(66445);
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66445);
      return localLinearLayout;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    ArrayList<String> hIH;
    ArrayList<Boolean> umS;
    
    public c()
    {
      AppMethodBeat.i(66446);
      this.hIH = new ArrayList();
      this.umS = new ArrayList();
      AppMethodBeat.o(66446);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66447);
      int i = this.hIH.size();
      AppMethodBeat.o(66447);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(66448);
      Object localObject = this.hIH.get(paramInt);
      AppMethodBeat.o(66448);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(66450);
      paramView = (CheckedTextView)View.inflate(WalletOfflineCoinPurseUI.this, 2131495971, null);
      paramView.setText((String)this.hIH.get(paramInt));
      if (WalletOfflineCoinPurseUI.cZd() == paramInt)
      {
        paramView.setChecked(true);
        if (!isEnabled(paramInt)) {
          break label90;
        }
        paramView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(2131100711));
        paramView.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(66450);
        return paramView;
        paramView.setChecked(false);
        break;
        label90:
        paramView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(2131100490));
        paramView.setEnabled(false);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(66449);
      boolean bool = ((Boolean)this.umS.get(paramInt)).booleanValue();
      AppMethodBeat.o(66449);
      return bool;
    }
  }
  
  final class d
    extends WalletOfflineCoinPurseUI.a
  {
    public d()
    {
      super();
    }
    
    public final void cZe()
    {
      AppMethodBeat.i(66452);
      WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306759));
      this.umO = ((ImageView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297132));
      this.umP = ((TextView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297134));
      this.umQ = ((ImageView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297133));
      WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66451);
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = new eq();
          paramAnonymousView.dFd = 3L;
          paramAnonymousView.aBj();
          com.tencent.mm.plugin.newtips.a.cWs().Ip(20);
          com.tencent.mm.plugin.remittance.mobile.a.b.Kx(WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this));
          if (WalletOfflineCoinPurseUI.Y(WalletOfflineCoinPurseUI.this))
          {
            com.tencent.mm.bs.d.O(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".mobile.ui.BankMobileRemittanceChooseUI");
            AppMethodBeat.o(66451);
            return;
          }
          com.tencent.mm.bs.d.O(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
          AppMethodBeat.o(66451);
        }
      });
      AppMethodBeat.o(66452);
    }
    
    public final String getPath()
    {
      return "transfertoreddot";
    }
    
    public final View getRoot()
    {
      AppMethodBeat.i(66453);
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66453);
      return localLinearLayout;
    }
  }
  
  final class e
    extends WalletOfflineCoinPurseUI.a
  {
    public e()
    {
      super();
    }
    
    public final boolean cNE()
    {
      AppMethodBeat.i(66457);
      super.cNE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.z.c.adr().b(ae.a.Fry, ae.a.Fqt))
      {
        com.tencent.mm.kernel.g.afC();
        String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqN, "");
        if (bt.isNullOrNil(str)) {
          break label98;
        }
        this.umP.setText(str);
        this.umP.setVisibility(0);
        this.umQ.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.uex, true);
      }
      for (;;)
      {
        AppMethodBeat.o(66457);
        return true;
        label98:
        this.umO.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.uew, true);
      }
    }
    
    public final void cZe()
    {
      AppMethodBeat.i(66456);
      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306761));
      this.umO = ((ImageView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299650));
      this.umP = ((TextView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299652));
      this.umQ = ((ImageView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299651));
      WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66455);
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.cWs().Ip(17);
          if (com.tencent.mm.z.c.adr().b(ae.a.Fry, ae.a.Fqt))
          {
            com.tencent.mm.z.c.adr().c(ae.a.Fry, ae.a.Fqt);
            WalletOfflineCoinPurseUI.e.this.umO.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.umP.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.umQ.setVisibility(8);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqN, "");
            com.tencent.mm.plugin.report.service.h.vKh.f(14396, new Object[] { Integer.valueOf(3) });
          }
          if (com.tencent.mm.plugin.wallet_core.model.s.ecc().ecF())
          {
            WalletOfflineCoinPurseUI.U(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.o(66455);
            return;
          }
          com.tencent.mm.plugin.wallet_core.model.s.ebW();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          com.tencent.mm.wallet_core.d.i locali = WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this);
          new a.a()
          {
            public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(66454);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + paramAnonymous2Int1 + ";errCode=" + paramAnonymous2Int2 + ";errMsg=" + paramAnonymous2String + ";hadAgree = " + paramAnonymous2Boolean);
              if (paramAnonymous2Int1 == 2)
              {
                paramAnonymous2String = new com.tencent.mm.plugin.wallet_core.id_verify.model.i("collect");
                WalletOfflineCoinPurseUI.this.doSceneProgress(paramAnonymous2String, false);
              }
              for (;;)
              {
                AppMethodBeat.o(66454);
                return true;
                if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Boolean))
                {
                  paramAnonymous2String = new com.tencent.mm.plugin.wallet_core.id_verify.model.i("collect");
                  WalletOfflineCoinPurseUI.this.doSceneProgress(paramAnonymous2String, false);
                }
                else if (WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this) != null)
                {
                  WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).dismiss();
                }
              }
            }
          };
          if (!com.tencent.mm.plugin.wallet_core.model.s.b(paramAnonymousView, locali, 1006))
          {
            paramAnonymousView = new com.tencent.mm.plugin.wallet_core.id_verify.model.i("collect");
            WalletOfflineCoinPurseUI.this.doSceneForceProgress(paramAnonymousView);
          }
          AppMethodBeat.o(66455);
        }
      });
      AppMethodBeat.o(66456);
    }
    
    public final String getPath()
    {
      return "facingreceivereddot";
    }
    
    public final View getRoot()
    {
      AppMethodBeat.i(66458);
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66458);
      return localLinearLayout;
    }
  }
  
  final class f
    extends WalletOfflineCoinPurseUI.a
  {
    public f()
    {
      super();
    }
    
    public final boolean cNE()
    {
      AppMethodBeat.i(66461);
      super.cNE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.z.c.adr().b(ae.a.Frz, ae.a.Fqt))
      {
        this.umO.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.uew, true);
      }
      AppMethodBeat.o(66461);
      return true;
    }
    
    public final void cZe()
    {
      AppMethodBeat.i(66460);
      WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306762));
      this.umO = ((ImageView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299640));
      this.umP = ((TextView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299642));
      this.umQ = ((ImageView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299641));
      WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66459);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.cWs().Ip(18);
          com.tencent.mm.plugin.report.service.h.vKh.f(14021, new Object[] { Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          com.tencent.mm.bs.d.O(WalletOfflineCoinPurseUI.this.getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
          if (com.tencent.mm.z.c.adr().b(ae.a.Frz, ae.a.Fqt))
          {
            com.tencent.mm.z.c.adr().c(ae.a.Frz, ae.a.Fqt);
            WalletOfflineCoinPurseUI.f.this.umO.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.vKh.f(14396, new Object[] { Integer.valueOf(5) });
          }
          AppMethodBeat.o(66459);
        }
      });
      AppMethodBeat.o(66460);
    }
    
    public final String getPath()
    {
      return "f2fhongbaoreddot";
    }
    
    public final View getRoot()
    {
      AppMethodBeat.i(66462);
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66462);
      return localLinearLayout;
    }
  }
  
  final class g
    extends WalletOfflineCoinPurseUI.a
  {
    public g()
    {
      super();
    }
    
    public final boolean cNE()
    {
      AppMethodBeat.i(66467);
      super.cNE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.z.c.adr().b(ae.a.FrA, ae.a.Fqt))
      {
        this.umO.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.uew, true);
      }
      AppMethodBeat.o(66467);
      return true;
    }
    
    public final void cZe()
    {
      AppMethodBeat.i(66465);
      WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306764));
      this.umO = ((ImageView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303608));
      this.umP = ((TextView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303610));
      this.umQ = ((ImageView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303609));
      WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66464);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.cWs().Ip(19);
          com.tencent.mm.plugin.report.service.h.vKh.f(14021, new Object[] { Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          if (com.tencent.mm.z.c.adr().b(ae.a.FrA, ae.a.Fqt))
          {
            com.tencent.mm.z.c.adr().c(ae.a.FrA, ae.a.Fqt);
            WalletOfflineCoinPurseUI.g.this.umO.setVisibility(8);
          }
          if (com.tencent.mm.plugin.wallet_core.model.s.ecc().ecF())
          {
            com.tencent.mm.bs.d.O(WalletOfflineCoinPurseUI.this.getContext(), "collect", ".reward.ui.QrRewardMainUI");
            AppMethodBeat.o(66464);
            return;
          }
          com.tencent.mm.plugin.wallet_core.model.s.ebW();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          com.tencent.mm.wallet_core.d.i locali = WalletOfflineCoinPurseUI.X(WalletOfflineCoinPurseUI.this);
          new a.a()
          {
            public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(66463);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + paramAnonymous2Int1 + ";errCode=" + paramAnonymous2Int2 + ";errMsg=" + paramAnonymous2String + ";hadAgree = " + paramAnonymous2Boolean);
              if (paramAnonymous2Int1 == 2)
              {
                paramAnonymous2String = new com.tencent.mm.plugin.wallet_core.id_verify.model.i("reward");
                WalletOfflineCoinPurseUI.this.doSceneProgress(paramAnonymous2String, false);
              }
              for (;;)
              {
                AppMethodBeat.o(66463);
                return true;
                if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Boolean))
                {
                  paramAnonymous2String = new com.tencent.mm.plugin.wallet_core.id_verify.model.i("reward");
                  WalletOfflineCoinPurseUI.this.doSceneProgress(paramAnonymous2String, false);
                }
                else if (WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this) != null)
                {
                  WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).dismiss();
                }
              }
            }
          };
          if (!com.tencent.mm.plugin.wallet_core.model.s.b(paramAnonymousView, locali, 1006))
          {
            paramAnonymousView = new com.tencent.mm.plugin.wallet_core.id_verify.model.i("reward");
            WalletOfflineCoinPurseUI.this.doSceneForceProgress(paramAnonymousView);
          }
          AppMethodBeat.o(66464);
        }
      });
      AppMethodBeat.o(66465);
    }
    
    public final String getPath()
    {
      return "rewardcodereddot";
    }
    
    public final View getRoot()
    {
      AppMethodBeat.i(66466);
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66466);
      return localLinearLayout;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI
 * JD-Core Version:    0.7.0.1
 */