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
import android.text.SpannableStringBuilder;
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
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.ut.b;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.g.a.xo.b;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.b.a.gg;
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
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.protocal.protobuf.byu;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bg.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.kernel.i
public class WalletOfflineCoinPurseUI
  extends WalletBaseUI
  implements u.a, s.a, com.tencent.mm.plugin.offline.b, a, bg.a
{
  private static int mOX = 0;
  private boolean ctA;
  private int fwc;
  private int jRj;
  private View.OnClickListener jax;
  private int mEntryScene;
  private long mLastTime;
  private int mState;
  private Dialog mTipDialog;
  private com.tencent.mm.ui.widget.a.e mdB;
  private boolean ocd;
  private int qwN;
  private HashMap<String, Integer> ufk;
  private String vrZ;
  private String vrw;
  private com.tencent.mm.plugin.offline.a.m vsb;
  private int vsd;
  private au vse;
  private com.tencent.mm.sdk.b.c<kj> vsr;
  private RelativeLayout vuA;
  private LinearLayout vuB;
  private CdnImageView vuC;
  private TextView vuD;
  private TextView vuE;
  private e vuF;
  private g vuG;
  private b vuH;
  private f vuI;
  private d vuJ;
  private LinearLayout vuK;
  private LinearLayout vuL;
  private LinearLayout vuM;
  private LinearLayout vuN;
  private LinearLayout vuO;
  private String vuP;
  private boolean vuQ;
  private com.tencent.mm.plugin.offline.g vuR;
  private boolean vuS;
  private boolean vuT;
  private boolean vuU;
  private boolean vuV;
  private boolean vuW;
  private int vuX;
  private ArrayList<Bitmap> vuY;
  private ArrayList<Bitmap> vuZ;
  private HashMap<String, View> vuh;
  private HashMap<String, Integer> vui;
  Bitmap vuj;
  Bitmap vuk;
  private c vul;
  private boolean vum;
  private boolean vun;
  private ArrayList<String> vuo;
  private ArrayList<String> vup;
  private ArrayList<Boolean> vuq;
  private String vur;
  private View vus;
  private ImageView vut;
  private ImageView vuu;
  private TextView vuv;
  private String vuw;
  private View vux;
  private TextView vuy;
  private ImageView vuz;
  private com.tencent.mm.wallet_core.ui.c vva;
  private c vvb;
  private OfflineAlertView vvc;
  private boolean vvd;
  private boolean vve;
  private String vvf;
  private boolean vvg;
  private String vvh;
  private boolean vvi;
  private int vvj;
  private boolean vvk;
  com.tencent.mm.sdk.b.c<xv> vvl;
  com.tencent.mm.sdk.b.c<xv> vvm;
  private com.tencent.mm.sdk.b.c<ct> vvn;
  private com.tencent.mm.sdk.b.c<nu> vvo;
  private com.tencent.mm.sdk.b.c<nd> vvp;
  private com.tencent.mm.sdk.b.c<ne> vvq;
  private com.tencent.mm.sdk.b.c vvr;
  private com.tencent.mm.sdk.b.c vvs;
  private com.tencent.mm.sdk.b.c vvt;
  public boolean vvu;
  private au vvv;
  private au vvw;
  
  public WalletOfflineCoinPurseUI()
  {
    AppMethodBeat.i(66468);
    this.mLastTime = 0L;
    this.mState = 3;
    this.vuh = new HashMap();
    this.vui = new HashMap();
    this.mEntryScene = -1;
    this.vuj = null;
    this.vuk = null;
    this.vum = false;
    this.vun = false;
    this.vuo = new ArrayList();
    this.vup = new ArrayList();
    this.vuq = new ArrayList();
    this.vrw = "";
    this.vur = "";
    this.vuP = "";
    this.vrZ = "";
    this.ocd = true;
    this.vuQ = false;
    this.vuS = false;
    this.vuT = false;
    this.vuU = false;
    this.vuV = true;
    this.vuW = false;
    this.vuX = -1;
    this.vuY = new ArrayList();
    this.vuZ = new ArrayList();
    this.vvd = false;
    this.vve = false;
    this.vvf = null;
    this.vvg = false;
    this.jRj = 0;
    this.vvi = false;
    this.vvk = true;
    this.vvl = new com.tencent.mm.sdk.b.c() {};
    this.vvm = new com.tencent.mm.sdk.b.c() {};
    this.vvn = new com.tencent.mm.sdk.b.c() {};
    this.vvo = new com.tencent.mm.sdk.b.c() {};
    this.vvp = new com.tencent.mm.sdk.b.c() {};
    this.vvq = new com.tencent.mm.sdk.b.c() {};
    this.vvr = new WalletOfflineCoinPurseUI.38(this);
    this.vvs = new com.tencent.mm.sdk.b.c() {};
    this.vvt = new com.tencent.mm.sdk.b.c() {};
    this.jax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66411);
        long l;
        if ((paramAnonymousView.getId() == 2131306827) || (paramAnonymousView.getId() == 2131306693) || (paramAnonymousView.getId() == 2131306694))
        {
          if ((paramAnonymousView.getId() == 2131306827) && (WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).isShowing()))
          {
            ac.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
            AppMethodBeat.o(66411);
            return;
          }
          l = System.currentTimeMillis();
          if (((WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this) == null) || (!WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).isShowing())) && (l - WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this) >= 400L) && (com.tencent.mm.plugin.offline.c.a.dmQ()) && (!WalletOfflineCoinPurseUI.q(WalletOfflineCoinPurseUI.this)))
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
            com.tencent.mm.plugin.report.service.h.wUl.f(13958, new Object[] { Integer.valueOf(4) });
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, true);
          }
        }
      }
    };
    this.vvu = false;
    this.ufk = new HashMap();
    this.vsd = 60000;
    this.vse = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66434);
        if (!WalletOfflineCoinPurseUI.L(WalletOfflineCoinPurseUI.this))
        {
          WalletOfflineCoinPurseUI.y(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.z(WalletOfflineCoinPurseUI.this);
        }
        au localau = WalletOfflineCoinPurseUI.N(WalletOfflineCoinPurseUI.this);
        long l = WalletOfflineCoinPurseUI.M(WalletOfflineCoinPurseUI.this);
        localau.au(l, l);
        AppMethodBeat.o(66434);
        return false;
      }
    }, false);
    this.vvv = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(174401);
        WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this);
        if ((WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).isShowing())) {
          WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).dismiss();
        }
        com.tencent.mm.plugin.offline.g.dlU();
        WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this);
        if (com.tencent.mm.plugin.offline.c.a.dnr()) {
          WalletOfflineCoinPurseUI.this.dml();
        }
        AppMethodBeat.o(174401);
        return false;
      }
    }, false);
    this.vvw = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(184862);
        ac.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this)) });
        if (WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this))
        {
          cg localcg = new cg();
          localcg.dbT.bPH = 0;
          com.tencent.mm.sdk.b.a.GpY.l(localcg);
        }
        WalletOfflineCoinPurseUI.this.finish();
        AppMethodBeat.o(184862);
        return false;
      }
    }, false);
    this.vsr = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(66468);
  }
  
  private void KI(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(66490);
    if (!com.tencent.mm.plugin.offline.c.a.dmQ())
    {
      ac.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
      AppMethodBeat.o(66490);
      return;
    }
    com.tencent.mm.plugin.offline.k.dlZ();
    Object localObject = com.tencent.mm.plugin.offline.k.dmb().A(this.mEntryScene, paramInt, this.vuw);
    this.vrZ = ((String)localObject);
    this.vuP = ((String)localObject);
    ac.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[] { Integer.valueOf(paramInt), this.vrZ, this.vuP, bs.eWi().toString() });
    bWI();
    if (bs.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.mm.plugin.report.service.h.wUl;
      if (com.tencent.mm.plugin.offline.c.a.cK(ai.getContext())) {}
      for (paramInt = 0;; paramInt = 1)
      {
        if (ax.isNetworkConnected(getBaseContext())) {
          i = 1;
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).f(14163, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 26L, 1L, true);
        if (!ax.isNetworkConnected(getBaseContext())) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 28L, 1L, true);
        AppMethodBeat.o(66490);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 27L, 1L, true);
    }
    AppMethodBeat.o(66490);
  }
  
  private static void KJ(int paramInt)
  {
    AppMethodBeat.i(66509);
    com.tencent.mm.g.b.a.o localo = new com.tencent.mm.g.b.a.o();
    localo.dFD = paramInt;
    localo.aHZ();
    AppMethodBeat.o(66509);
  }
  
  private void U(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66480);
    if (com.tencent.mm.plugin.offline.c.a.oN(true).size() > 0)
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
      dmB();
      dmA();
      this.vux.setVisibility(0);
    }
    for (;;)
    {
      if (paramBoolean1) {
        KI(0);
      }
      oL(paramBoolean2);
      bSb();
      dms();
      AppMethodBeat.o(66480);
      return;
      this.vux.setVisibility(0);
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
    }
  }
  
  private void a(Bankcard paramBankcard)
  {
    AppMethodBeat.i(66511);
    if (TextUtils.isEmpty(this.vrw))
    {
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
      AppMethodBeat.o(66511);
      return;
    }
    if (paramBankcard.eqV())
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
      this.vuz.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      AppMethodBeat.o(66511);
      return;
    }
    String str2 = com.tencent.mm.plugin.offline.c.a.aoQ(this.vrw);
    String str1 = str2;
    if (paramBankcard.eqS())
    {
      str1 = str2;
      if (paramBankcard.Buz != null) {
        str1 = paramBankcard.Buz.vkI;
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
      AppMethodBeat.o(66511);
      return;
    }
    e(this.vuz, str1, getResources().getDimensionPixelOffset(2131167003));
    AppMethodBeat.o(66511);
  }
  
  private void bSb()
  {
    AppMethodBeat.i(66479);
    if (com.tencent.mm.plugin.offline.c.a.dmQ())
    {
      this.vuA.setVisibility(0);
      AppMethodBeat.o(66479);
      return;
    }
    this.vuA.setVisibility(4);
    AppMethodBeat.o(66479);
  }
  
  private void bWI()
  {
    AppMethodBeat.i(66516);
    bb localbb = com.tencent.mm.plugin.wallet_core.model.k.ero();
    Object localObject = new StringBuilder().append(this.vuP);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP();
    localObject = ah.dg(p.getString(com.tencent.mm.kernel.a.getUin()));
    if (localbb != null) {
      com.tencent.mm.plugin.report.service.h.wUl.f(13444, new Object[] { localbb.DNA, localbb.DNB, Long.valueOf(localbb.DNz), localObject, localbb.DNC, localbb.DND, localbb.DNE });
    }
    AppMethodBeat.o(66516);
  }
  
  private void cYM()
  {
    AppMethodBeat.i(66484);
    Bitmap localBitmap = this.vuj;
    this.vuj = dmy();
    this.vut.setImageBitmap(this.vuj);
    this.vuY.add(0, localBitmap);
    AppMethodBeat.o(66484);
  }
  
  private void dmB()
  {
    AppMethodBeat.i(66499);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.dmS();
    if (localBankcard != null)
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
      com.tencent.mm.plugin.offline.c.a.aoJ(localBankcard.field_bindSerial);
      this.vrw = localBankcard.field_bindSerial;
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.dmb().vrw = this.vrw;
      AppMethodBeat.o(66499);
      return;
    }
    ac.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
    AppMethodBeat.o(66499);
  }
  
  private void dmC()
  {
    AppMethodBeat.i(66500);
    if (this.vuS)
    {
      AppMethodBeat.o(66500);
      return;
    }
    if (!this.vvc.KH(4))
    {
      AppMethodBeat.o(66500);
      return;
    }
    com.tencent.mm.kernel.g.agS();
    if ((!((Boolean)com.tencent.mm.kernel.g.agR().agA().get(com.tencent.mm.storage.ah.a.GJT, Boolean.FALSE)).booleanValue()) && (!this.vvc.isShowing())) {
      dmD();
    }
    AppMethodBeat.o(66500);
  }
  
  private void dmD()
  {
    AppMethodBeat.i(66501);
    if (!this.vvc.KH(4))
    {
      AppMethodBeat.o(66501);
      return;
    }
    this.vvc.en(this.vus);
    AppMethodBeat.o(66501);
  }
  
  private void dmE()
  {
    AppMethodBeat.i(66502);
    if (!this.vvc.KH(1))
    {
      AppMethodBeat.o(66502);
      return;
    }
    if (this.vvc.vtK == 1) {
      this.vvc.dismiss();
    }
    boolean bool1 = com.tencent.mm.plugin.wallet_core.model.s.ery().esc();
    boolean bool2 = com.tencent.mm.plugin.wallet_core.model.s.ery().esb();
    if ((bool1) || (bool2))
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.vvc.a(this.vus, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66421);
          com.tencent.mm.plugin.offline.c.a.dnc();
          com.tencent.mm.plugin.offline.k.dlZ();
          com.tencent.mm.plugin.offline.k.bu(196648, "0");
          WalletOfflineCoinPurseUI.F(WalletOfflineCoinPurseUI.this);
          AppMethodBeat.o(66421);
        }
      }, 1);
    }
    AppMethodBeat.o(66502);
  }
  
  private void dmF()
  {
    AppMethodBeat.i(66503);
    if (!this.vvc.KH(3))
    {
      AppMethodBeat.o(66503);
      return;
    }
    if (this.vvc.vtK == 3) {
      this.vvc.dismiss();
    }
    com.tencent.mm.plugin.offline.k.dlZ();
    String str1 = com.tencent.mm.plugin.offline.k.KG(196617);
    com.tencent.mm.wallet_core.c.b.fAg();
    boolean bool1 = com.tencent.mm.wallet_core.c.b.isCertExist(str1);
    boolean bool2 = com.tencent.mm.plugin.offline.c.a.dmQ();
    ac.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) || (!bool2)) {
      if (!bool1)
      {
        com.tencent.mm.kernel.g.agS();
        String str2 = (String)com.tencent.mm.kernel.g.agR().agA().get(com.tencent.mm.storage.ah.a.GDC, "");
        if ((str2 == null) || (!str2.equals(com.tencent.mm.compatible.deviceinfo.q.cF(true)))) {
          break label222;
        }
        ac.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + str1 + " ,recreate offline");
      com.tencent.mm.plugin.offline.c.a.dnc();
      this.vuA.setVisibility(4);
      this.vvc.a(this.vus, new View.OnClickListener()
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
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
    }
  }
  
  private void dmG()
  {
    AppMethodBeat.i(66504);
    if (!this.vvc.KH(5))
    {
      AppMethodBeat.o(66504);
      return;
    }
    if (this.vvc.vtK == 5) {
      this.vvc.dismiss();
    }
    this.vvc.b(this.vus, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66423);
        com.tencent.mm.plugin.offline.k.dlZ();
        com.tencent.mm.plugin.offline.k.dmc();
        ac.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.i.dlY()) });
        com.tencent.mm.plugin.offline.k.dlZ();
        com.tencent.mm.plugin.offline.k.dmc();
        if (com.tencent.mm.plugin.offline.i.dlY() <= 0)
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
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 73L, 1L, true);
    AppMethodBeat.o(66504);
  }
  
  private void dmI()
  {
    AppMethodBeat.i(66506);
    if ((this.vvc.isShowing()) && (this.vvc.vtK == 5)) {
      this.vvc.dismiss();
    }
    AppMethodBeat.o(66506);
  }
  
  private boolean dmJ()
  {
    AppMethodBeat.i(66507);
    if (!this.vvc.KH(2))
    {
      AppMethodBeat.o(66507);
      return false;
    }
    if (this.vvc.vtK == 2) {
      this.vvc.dismiss();
    }
    List localList = com.tencent.mm.plugin.offline.c.a.dmW();
    if (localList.size() <= 0)
    {
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      AppMethodBeat.o(66507);
      return false;
    }
    int i = 0;
    while (i < localList.size())
    {
      Bankcard localBankcard = (Bankcard)localList.get(i);
      if ((localBankcard != null) && (localBankcard.field_support_micropay) && (bs.isNullOrNil(localBankcard.field_forbidWord)))
      {
        AppMethodBeat.o(66507);
        return true;
      }
      i += 1;
    }
    this.vvc.dismiss();
    this.vvc.a(this.vus, new Runnable()new WalletOfflineCoinPurseUI.27
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
          com.tencent.mm.plugin.offline.c.a.i(localc.mActivity, localc.vua);
        }
      }
    }, new WalletOfflineCoinPurseUI.27(this));
    AppMethodBeat.o(66507);
    return false;
  }
  
  private static void dmK()
  {
    AppMethodBeat.i(66510);
    if (!com.tencent.mm.plugin.offline.c.a.dnj())
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.dmc().gA(3, 3);
    }
    AppMethodBeat.o(66510);
  }
  
  private void dmp()
  {
    AppMethodBeat.i(66470);
    dmE();
    dmJ();
    dmF();
    dmC();
    AppMethodBeat.o(66470);
  }
  
  private void dmq()
  {
    AppMethodBeat.i(66472);
    com.tencent.mm.wallet_core.ui.e.adR(32);
    com.tencent.mm.pluginsdk.wallet.f.ar(this, this.qwN);
    AppMethodBeat.o(66472);
  }
  
  private void dmr()
  {
    AppMethodBeat.i(66478);
    byt localbyt = com.tencent.mm.plugin.wallet_core.model.s.ery().BAJ;
    if (localbyt == null)
    {
      this.vuB.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if (localbyt.FnP == null)
    {
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "offlineGuideBar.guide_data == null");
      this.vuB.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    Object localObject = localbyt.FnP.vwo;
    if (com.tencent.mm.plugin.wallet_core.model.s.ery().azl((String)localObject) == null)
    {
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar bindSerial(%s) is null bankcard!", new Object[] { bs.bG((String)localObject, "") });
      this.vuB.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    localObject = com.tencent.mm.plugin.offline.c.a.dmS();
    if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (bs.lr(localbyt.FnP.vwo, ((Bankcard)localObject).field_bindSerial)))
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar defaultBankcard(%s) == bindSerial(%s)", new Object[] { ((Bankcard)localObject).field_bindSerial, localbyt.FnP.vwo });
      this.vuB.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if ((this.vuB.isShown()) && (this.vuB.getTag() != null) && ((this.vuB.getTag() instanceof byt)) && (bs.I((byt)this.vuB.getTag(), localbyt)))
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "");
      AppMethodBeat.o(66478);
      return;
    }
    if (localbyt.Bgu == 0)
    {
      this.vuB.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if (!this.vuV)
    {
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "isShowGuideBar == false");
      AppMethodBeat.o(66478);
      return;
    }
    int i = this.vuB.getVisibility();
    this.vuB.setTag(localbyt);
    this.vuB.setVisibility(0);
    if ((!bs.isNullOrNil(localbyt.FnQ)) && (this.vuB.getBackground() != null)) {
      this.vuB.getBackground().setColorFilter(Color.parseColor(localbyt.FnQ), PorterDuff.Mode.SRC);
    }
    int j = BackwardSupportUtil.b.g(this, 20.0F);
    this.vuC.r(localbyt.BgB, j, j, -1);
    this.vuD.setText(localbyt.Bgw);
    this.vuD.setTextColor(Color.parseColor(localbyt.Bgx));
    this.vuE.setText(localbyt.Bgy);
    this.vuE.setTextColor(Color.parseColor(localbyt.Bgz));
    this.vuE.setTag(localbyt.FnP.vwo);
    aj.a(this.vuE.getPaint(), 0.8F);
    if (localbyt.Bik == com.tencent.mm.plugin.wallet_core.model.ah.a.BAl.value) {
      this.vuE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184848);
          WalletOfflineCoinPurseUI.KK(2);
          String str2 = "";
          String str1 = str2;
          if (paramAnonymousView.getTag() != null)
          {
            str1 = str2;
            if ((paramAnonymousView.getTag() instanceof String)) {
              str1 = (String)paramAnonymousView.getTag();
            }
          }
          ac.i("MicroMsg.WalletOfflineCoinPurseUI", "mOfflineGuideButtonTv click! bindSerial:%s", new Object[] { str1 });
          if (bs.isNullOrNil(str1))
          {
            AppMethodBeat.o(184848);
            return;
          }
          WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.s.ery().azl(str1);
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, paramAnonymousView);
          AppMethodBeat.o(184848);
        }
      });
    }
    KJ(1);
    if ((i == 8) && (this.vvc.isShowing()))
    {
      dmC();
      if ((!this.vuS) && (this.vvc.KH(4)))
      {
        com.tencent.mm.kernel.g.agS();
        if (!((Boolean)com.tencent.mm.kernel.g.agR().agA().get(com.tencent.mm.storage.ah.a.GJT, Boolean.FALSE)).booleanValue()) {
          dmD();
        }
      }
    }
    AppMethodBeat.o(66478);
  }
  
  private void dms()
  {
    AppMethodBeat.i(66481);
    if ((!this.vvu) && (!ax.isNetworkConnected(getBaseContext())))
    {
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.dmb();
      if (com.tencent.mm.plugin.offline.e.dlR() == 0)
      {
        this.vvu = true;
        b.av(this);
        ac.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
      }
    }
    AppMethodBeat.o(66481);
  }
  
  private void dmt()
  {
    AppMethodBeat.i(66482);
    int i = com.tencent.mm.plugin.offline.c.a.dmV();
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.dmT();
    if (c.dmn())
    {
      this.mState = 7;
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
      AppMethodBeat.o(66482);
      return;
    }
    if (!ax.isNetworkConnected(getBaseContext()))
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
      this.mState = 6;
      AppMethodBeat.o(66482);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.dmQ())
    {
      if (i == 0)
      {
        ac.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
        this.mState = 1;
        AppMethodBeat.o(66482);
        return;
      }
      if ((i != 0) && (localBankcard == null))
      {
        ac.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
        this.mState = 2;
        AppMethodBeat.o(66482);
        return;
      }
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
      this.mState = 5;
      AppMethodBeat.o(66482);
      return;
    }
    if (i == 0)
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
      this.mState = 1;
      AppMethodBeat.o(66482);
      return;
    }
    if ((i != 0) && (localBankcard == null))
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
      this.mState = 2;
      AppMethodBeat.o(66482);
      return;
    }
    ac.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
    this.mState = 5;
    AppMethodBeat.o(66482);
  }
  
  private boolean dmu()
  {
    return (this.mState == 2) || (this.mState == 1) || (this.mState == 7);
  }
  
  private void dmv()
  {
    AppMethodBeat.i(66485);
    Bitmap localBitmap = this.vuk;
    this.vuk = dmx();
    this.vuu.setImageBitmap(this.vuk);
    if (dmu()) {
      this.vuu.setAlpha(10);
    }
    for (;;)
    {
      this.vuZ.add(0, localBitmap);
      AppMethodBeat.o(66485);
      return;
      this.vuu.setAlpha(255);
    }
  }
  
  private void dmw()
  {
    AppMethodBeat.i(66486);
    if (this.vva != null)
    {
      this.vva.mh(this.vuP, this.vrZ);
      this.vva.vuj = this.vuj;
      this.vva.vuk = this.vuk;
      this.vva.fAM();
    }
    AppMethodBeat.o(66486);
  }
  
  private Bitmap dmx()
  {
    AppMethodBeat.i(66488);
    if (TextUtils.isEmpty(this.vrZ))
    {
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
      AppMethodBeat.o(66488);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.by.a.a.b(this, this.vrZ, 5, 0);
    AppMethodBeat.o(66488);
    return localBitmap;
  }
  
  private Bitmap dmy()
  {
    AppMethodBeat.i(66489);
    if (TextUtils.isEmpty(this.vuP))
    {
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
      AppMethodBeat.o(66489);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.by.a.a.b(this, this.vuP, 12, 3);
    AppMethodBeat.o(66489);
    return localBitmap;
  }
  
  private void dmz()
  {
    AppMethodBeat.i(66493);
    if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
      this.mTipDialog.dismiss();
    }
    AppMethodBeat.o(66493);
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
    this.vuh.put(paramString, paramImageView);
    this.vui.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(66495);
  }
  
  private void oL(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(66483);
    long l = System.currentTimeMillis();
    int i;
    if ((paramBoolean) && ((bs.isNullOrNil(this.vuP)) || (bs.isNullOrNil(this.vrZ))))
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
      dmG();
      cYM();
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - l));
      dmv();
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - l));
      recycleBmpList();
      dmw();
      dmr();
      ab.km(10, 0);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
      if (!com.tencent.mm.plugin.offline.c.a.cK(ai.getContext())) {
        break label281;
      }
      i = 0;
      label148:
      if (ax.isNetworkConnected(ai.getContext())) {
        j = 1;
      }
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.dmb();
      localh.f(14163, new Object[] { Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(com.tencent.mm.plugin.offline.e.dlR()) });
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 67L, 1L, true);
      if (!ax.isNetworkConnected(ai.getContext())) {
        break label286;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 32L, 1L, true);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.offline.c.a.cK(this)) {
        break label303;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 34L, 1L, true);
      AppMethodBeat.o(66483);
      return;
      dmI();
      break;
      label281:
      i = 1;
      break label148;
      label286:
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 33L, 1L, true);
    }
    label303:
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 35L, 1L, true);
    AppMethodBeat.o(66483);
  }
  
  private void oM(boolean paramBoolean)
  {
    AppMethodBeat.i(66508);
    if (!com.tencent.mm.plugin.offline.c.a.dmQ())
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.dmQ()) });
      AppMethodBeat.o(66508);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.oN(false).size() <= 0)
    {
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      this.vuy.setVisibility(8);
      AppMethodBeat.o(66508);
      return;
    }
    final ArrayList localArrayList = com.tencent.mm.plugin.wallet_core.model.ae.tC(true);
    int i;
    Object localObject;
    int j;
    if ((paramBoolean) && (this.mdB == null))
    {
      this.mdB = new com.tencent.mm.ui.widget.a.e(this, 2, true);
      this.vuX = -1;
      this.mdB.bmi();
      i = 0;
      localObject = null;
      j = 0;
      label128:
      if (i >= localArrayList.size()) {
        break label213;
      }
      Bankcard localBankcard = (Bankcard)localArrayList.get(i);
      if ((bs.isNullOrNil(localBankcard.field_bindSerial)) || (!this.vrw.equals(localBankcard.field_bindSerial))) {
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
      this.mdB = null;
      this.mdB = new com.tencent.mm.ui.widget.a.e(this, 2, true);
      break;
      if (localObject != null)
      {
        localArrayList.remove(localObject);
        localArrayList.add(0, localObject);
        j = 0;
      }
      this.mdB.ISu = new n.c()
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
          Object localObject2;
          label173:
          Object localObject4;
          if (i < localArrayList.size())
          {
            localBankcard = (Bankcard)localArrayList.get(i);
            localObject1 = com.tencent.mm.plugin.offline.c.a.aoP(localBankcard.field_bankcardType);
            localObject3 = localObject1;
            if (localBankcard.eqS())
            {
              localObject3 = localObject1;
              if (localBankcard.Buz != null) {
                localObject3 = localBankcard.Buz.vkI;
              }
            }
            localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject3));
            com.tencent.mm.platformtools.u.a(new u.a()
            {
              public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(184858);
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(184857);
                    ac.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletOfflineCoinPurseUI.28.1.this.vvG });
                    if (WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).containsKey(paramAnonymous2String))
                    {
                      int i = ((Integer)WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).get(paramAnonymous2String)).intValue();
                      if (WalletOfflineCoinPurseUI.28.1.this.ufs.getItem(i) != null)
                      {
                        WalletOfflineCoinPurseUI.28.1.this.ufs.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.a(paramAnonymous2Bitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), true, false)));
                        WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).fvu();
                      }
                    }
                    AppMethodBeat.o(184857);
                  }
                });
                AppMethodBeat.o(184858);
              }
            });
            localObject2 = "";
            if (!bs.isNullOrNil(localBankcard.field_forbidWord)) {
              localObject2 = localBankcard.field_forbidWord;
            }
            localObject1 = localObject2;
            if (bs.isNullOrNil((String)localObject2))
            {
              localObject1 = localObject2;
              if (!localBankcard.field_support_micropay)
              {
                if (!bs.isNullOrNil(localBankcard.field_no_micro_word)) {
                  break label531;
                }
                localObject1 = "";
              }
            }
            if (bs.isNullOrNil(localBankcard.field_forbid_title))
            {
              localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
              localObject4 = localObject1;
              localObject1 = localObject2;
              label203:
              if ((!bs.aj((CharSequence)localObject1)) || (bs.isNullOrNil(localBankcard.field_prompt_info_prompt_text))) {
                break label808;
              }
              localObject1 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
              if ((!bs.isNullOrNil(localBankcard.field_prompt_info_jump_text)) && (!bs.isNullOrNil(localBankcard.field_prompt_info_jump_url)))
              {
                ((SpannableStringBuilder)localObject1).append(localBankcard.field_prompt_info_jump_text);
                ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
                {
                  public final void dK(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(207121);
                    com.tencent.mm.wallet_core.ui.e.aT(WalletOfflineCoinPurseUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
                    com.tencent.mm.plugin.report.service.h.wUl.f(20216, new Object[] { Integer.valueOf(3), localBankcard.field_prompt_info_jump_url });
                    AppMethodBeat.o(207121);
                  }
                }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject1).length(), 33);
              }
            }
          }
          label404:
          label808:
          for (;;)
          {
            String str;
            if (((localBankcard.eqR()) || (localBankcard.eqS())) && (localBankcard.Buo >= 0.0D))
            {
              str = localBankcard.field_desc + WalletOfflineCoinPurseUI.this.getString(2131764999, new Object[] { com.tencent.mm.wallet_core.ui.e.D(localBankcard.Buo) });
              label379:
              localObject2 = null;
              if (!localBankcard.eqV()) {
                break label688;
              }
              localObject2 = com.tencent.mm.svg.a.a.g(WalletOfflineCoinPurseUI.this.getResources(), 2131690298);
              if (localObject2 == null) {
                WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).put(localObject3, Integer.valueOf(i));
              }
              ac.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str, localObject1 });
              if (!localBankcard.eqW()) {
                break label754;
              }
              localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(WalletOfflineCoinPurseUI.this.getContext(), str);
              if (bs.isNullOrNil((String)localObject4))
              {
                if (!bs.isNullOrNil(localBankcard.BuN)) {
                  break label738;
                }
                localObject1 = "";
              }
              label499:
              if (bs.isNullOrNil((String)localObject4)) {
                break label748;
              }
            }
            label688:
            label738:
            label748:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousl.b(i, (CharSequence)localObject3, (CharSequence)localObject1, (Drawable)localObject2, bool);
              i += 1;
              break;
              localObject1 = localBankcard.field_no_micro_word;
              break label173;
              localObject4 = (String)localObject1 + " ";
              localObject1 = new SpannableStringBuilder((String)localObject4 + localBankcard.field_forbid_title);
              localObject2 = new com.tencent.mm.plugin.wallet_core.ui.l(WalletOfflineCoinPurseUI.this)
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(184859);
                  paramAnonymous2View = localBankcard.field_forbid_url;
                  if ((localBankcard.eqW()) && (bs.isNullOrNil(paramAnonymous2View)))
                  {
                    ac.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand");
                    paramAnonymous2View = new ut();
                    paramAnonymous2View.dxt.userName = localBankcard.AZE;
                    paramAnonymous2View.dxt.dxv = localBankcard.AZF;
                    paramAnonymous2View.dxt.scene = 1137;
                    paramAnonymous2View.dxt.dxw = 0;
                    com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2View);
                    ac.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand result:%s", new Object[] { Boolean.valueOf(paramAnonymous2View.dxu.dxL) });
                    if (paramAnonymous2View.dxu.dxL)
                    {
                      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 1);
                      WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).bmi();
                      AppMethodBeat.o(184859);
                      return;
                    }
                    WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 0);
                    AppMethodBeat.o(184859);
                    return;
                  }
                  Intent localIntent = new Intent();
                  ac.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", new Object[] { paramAnonymous2View });
                  localIntent.putExtra("rawUrl", paramAnonymous2View);
                  localIntent.putExtra("geta8key_username", com.tencent.mm.model.u.axw());
                  localIntent.putExtra("pay_channel", 1);
                  com.tencent.mm.wallet_core.ui.e.al(WalletOfflineCoinPurseUI.this.getContext(), localIntent);
                  AppMethodBeat.o(184859);
                }
              };
              int j = ((String)localObject4).length();
              int k = ((String)localObject4).length() + localBankcard.field_forbid_title.length();
              ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(WalletOfflineCoinPurseUI.this.getResources().getColor(2131101130)), j, k, 33);
              ((SpannableStringBuilder)localObject1).setSpan(localObject2, j, k, 33);
              break label203;
              str = localBankcard.field_desc;
              break label379;
              if (localBitmap == null) {
                break label404;
              }
              localObject2 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.a(localBitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), true, false));
              break label404;
              localObject1 = localBankcard.BuN;
              break label499;
            }
            label754:
            localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(WalletOfflineCoinPurseUI.this.getContext(), str);
            if (!bs.isNullOrNil((String)localObject4)) {}
            for (bool = true;; bool = false)
            {
              paramAnonymousl.b(i, (CharSequence)localObject3, (CharSequence)localObject1, (Drawable)localObject2, bool);
              break;
            }
            AppMethodBeat.o(184860);
            return;
          }
        }
      };
      this.mdB.ISv = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(184861);
          if (WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).bmi();
            paramAnonymousMenuItem = (Bankcard)localArrayList.get(paramAnonymousInt);
            com.tencent.mm.plugin.report.service.h.wUl.f(14515, new Object[] { Integer.valueOf(3) });
            if ((!bs.isNullOrNil(paramAnonymousMenuItem.field_forbid_title)) || (!bs.isNullOrNil(paramAnonymousMenuItem.field_forbidWord)) || (!paramAnonymousMenuItem.field_support_micropay)) {
              com.tencent.mm.plugin.report.service.h.wUl.f(14515, new Object[] { Integer.valueOf(4) });
            }
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, paramAnonymousMenuItem);
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.eqW()))
            {
              WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this);
              WalletOfflineCoinPurseUI.KK(3);
            }
          }
          AppMethodBeat.o(184861);
        }
      };
      localObject = View.inflate(this, 2131495985, null);
      this.mdB.whK = true;
      this.mdB.irP = j;
      this.mdB.JfJ = true;
      this.mdB.J((View)localObject, false);
      this.mdB.cED();
      com.tencent.mm.plugin.report.service.h.wUl.f(13955, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(66508);
      return;
    }
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(66487);
    int i;
    if (this.vuY.size() >= 2)
    {
      i = this.vuY.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.e.T((Bitmap)this.vuY.remove(i));
        i -= 1;
      }
    }
    if (this.vuZ.size() >= 2)
    {
      i = this.vuZ.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.e.T((Bitmap)this.vuZ.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(66487);
  }
  
  public final void Q(String paramString, long paramLong)
  {
    AppMethodBeat.i(207122);
    ac.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
    KI(1);
    oL(true);
    com.tencent.mm.wallet_core.ui.e.adR(40);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 21L, 1L, true);
    if (this.vva.jat.isShowing())
    {
      if (this.vva.ocd)
      {
        this.vva.fAN();
        AppMethodBeat.o(207122);
        return;
      }
      this.vva.dismiss();
    }
    dmD();
    AppMethodBeat.o(207122);
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(66491);
    if (paramc == null)
    {
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
      AppMethodBeat.o(66491);
      return false;
    }
    dmz();
    this.vva.dismiss();
    ac.i("MicroMsg.WalletOfflineCoinPurseUI", "msgtype=" + paramc.vty);
    int i;
    if (4 == paramc.vty)
    {
      this.vuQ = false;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = this.vvb;
      if (paramc == null) {
        ac.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
      }
      for (;;)
      {
        if ((this.vuT) && (!this.vuU))
        {
          this.vuT = false;
          this.vuQ = false;
        }
        if (i != 0)
        {
          KI(0);
          oL(true);
        }
        AppMethodBeat.o(66491);
        return true;
        if (5 == paramc.vty)
        {
          this.vuQ = true;
          this.vuT = true;
          this.vuU = false;
          if (this.vvv.eVs()) {
            break label420;
          }
          this.vvv.stopTimer();
          i = 0;
          break;
        }
        if (6 == paramc.vty)
        {
          if (!this.vvv.eVs()) {
            this.vvv.stopTimer();
          }
          if (!this.vse.eVs()) {
            this.vse.stopTimer();
          }
          this.vuQ = false;
          if (!com.tencent.mm.plugin.offline.c.a.dmR()) {
            break label1585;
          }
          i = 0;
          break;
        }
        if (8 == paramc.vty)
        {
          if (this.vvv.eVs()) {
            break label1585;
          }
          this.vvv.stopTimer();
          i = 1;
          break;
        }
        if (23 == paramc.vty)
        {
          if (this.vvv.eVs()) {
            break label420;
          }
          this.vvv.stopTimer();
          i = 0;
          break;
        }
        if (20 == paramc.vty)
        {
          this.vuQ = false;
          if (this.vvv.eVs()) {
            break label420;
          }
          this.vvv.stopTimer();
          i = 0;
          break;
        }
        if (24 != paramc.vty) {
          break label1585;
        }
        if (com.tencent.mm.plugin.offline.c.a.dnr())
        {
          this.vuQ = true;
          if (com.tencent.mm.plugin.offline.c.a.dnr())
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
          localObject1 = this.vvv;
          long l = com.tencent.mm.plugin.offline.g.dlT();
          ((au)localObject1).au(l, l);
          label420:
          i = 0;
          break;
          label425:
          if (!this.mTipDialog.isShowing()) {
            this.mTipDialog.show();
          }
        }
        ac.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + paramc.vty);
        if (paramc.vty == 24) {
          ((c)localObject1).njY.vibrate(50L);
        }
        if (4 == paramc.vty)
        {
          ((c)localObject1).a((s.b)paramc);
          com.tencent.mm.plugin.offline.g.dlU();
        }
        else
        {
          if (5 == paramc.vty)
          {
            paramc = (s.e)paramc;
            if (paramc != null)
            {
              ac.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + paramc.vtB + " msg.wxRetMsg:" + paramc.vtC + " msg.cftRetCode:" + paramc.vtB + " msg.cftRetMsg:" + paramc.vtA);
              if ((!TextUtils.isEmpty(paramc.vtB)) || (!TextUtils.isEmpty(paramc.vtC)) || (!TextUtils.isEmpty(paramc.vtz)) || (!TextUtils.isEmpty(paramc.vtA)))
              {
                if ((!TextUtils.isEmpty(paramc.vtB)) || (!TextUtils.isEmpty(paramc.vtC)) || (TextUtils.isEmpty(paramc.vtz)) || (TextUtils.isEmpty(paramc.vtA))) {
                  break label706;
                }
                b.d(((c)localObject1).mActivity, paramc.vtA);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.offline.g.dlU();
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 0L, 1L, true);
              break;
              label706:
              if ((!TextUtils.isEmpty(paramc.vtB)) && (com.tencent.mm.plugin.offline.c.a.isNumeric(paramc.vtB))) {
                ((c)localObject1).a(null, bs.getInt(paramc.vtB, 0), paramc.vtC, paramc.vtD);
              } else {
                b.d(((c)localObject1).mActivity, paramc.vtC);
              }
            }
          }
          Object localObject2;
          if (6 == paramc.vty)
          {
            paramc = (s.f)paramc;
            int j;
            if (paramc != null)
            {
              ac.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + paramc.vtF);
              com.tencent.mm.plugin.offline.k.dlZ();
              localObject2 = com.tencent.mm.plugin.offline.k.dmd().aoD(paramc.vtG.dac);
              if (localObject2 == null) {
                break label944;
              }
              if (((r)localObject2).field_status != com.tencent.mm.plugin.offline.g.vrK) {
                break label939;
              }
              j = 1;
            }
            for (;;)
            {
              if (j == 0)
              {
                com.tencent.mm.plugin.offline.g.ei(paramc.vtG.dac, com.tencent.mm.plugin.offline.g.vrK);
                com.tencent.mm.plugin.offline.c.a.a(((c)localObject1).mActivity, paramc);
                ((c)localObject1).mActivity.setResult(-1);
                ((c)localObject1).mActivity.finish();
              }
              com.tencent.mm.plugin.offline.g.dlU();
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 7L, 1L, true);
              if (com.tencent.mm.plugin.offline.c.a.vwf != 4) {
                break;
              }
              ac.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
              com.tencent.mm.plugin.report.service.h.wUl.f(13412, new Object[0]);
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
          if (8 == paramc.vty)
          {
            paramc = (s.g)paramc;
            ac.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + paramc.id);
            if (paramc.oGm == 0)
            {
              localObject2 = ((c)localObject1).mActivity.getLayoutInflater().inflate(2131495993, null);
              localObject3 = (TextView)((View)localObject2).findViewById(2131303150);
              localObject4 = (TextView)((View)localObject2).findViewById(2131303153);
              ((TextView)localObject3).setText(paramc.vtI);
              ((TextView)localObject4).setText(paramc.vtH);
              com.tencent.mm.plugin.offline.g.ei(paramc.djr, com.tencent.mm.plugin.offline.g.vrM);
              com.tencent.mm.ui.base.h.a(((c)localObject1).mActivity, "", (View)localObject2, ((c)localObject1).getString(2131765972), ((c)localObject1).getString(2131755691), new c.11((c)localObject1, paramc), new c.12((c)localObject1, paramc));
            }
            else if (paramc.oGm == 1)
            {
              if (((c)localObject1).vtY != null) {
                ((c)localObject1).vtY.show();
              }
              com.tencent.mm.plugin.report.service.h.wUl.f(13955, new Object[] { Integer.valueOf(1) });
              ac.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + paramc.id);
              com.tencent.mm.plugin.offline.g.ei(paramc.djr, com.tencent.mm.plugin.offline.g.vrM);
              ((c)localObject1).vtY = com.tencent.mm.plugin.wallet_core.ui.s.a(((c)localObject1).mActivity, paramc.vtH, paramc.vtI, new c.13((c)localObject1, paramc), new c.14((c)localObject1), new c.15((c)localObject1, paramc));
              ((c)localObject1).vtY.xcu.setVisibility(0);
              ((c)localObject1).vtY.wQs.setVisibility(8);
            }
          }
          else
          {
            if (23 == paramc.vty)
            {
              paramc = (s.d)paramc;
              localObject2 = new PayInfo();
              ((PayInfo)localObject2).dac = paramc.djr;
              ((PayInfo)localObject2).dqL = 8;
              ((PayInfo)localObject2).DGQ = 1;
              ((PayInfo)localObject2).hbR = new Bundle();
              ((PayInfo)localObject2).hbR.putLong("extinfo_key_9", System.currentTimeMillis());
              paramc = new c.1((c)localObject1, (PayInfo)localObject2);
              com.tencent.mm.sdk.b.a.GpY.b(paramc);
              com.tencent.mm.wallet_core.b.fzz();
              boolean bool1;
              label1406:
              String str;
              if ((com.tencent.mm.wallet_core.b.b(b.a.pRO, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_OFFLINE_PAY_SWTICH_KEY")))
              {
                bool1 = true;
                boolean bool2 = bool1;
                if (bool1)
                {
                  com.tencent.mm.wallet_core.b.fzz();
                  bool2 = com.tencent.mm.wallet_core.b.b(b.a.pUV, false);
                }
                if (!bool2) {
                  break label1510;
                }
                localObject3 = (com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class);
                localObject4 = ((c)localObject1).mActivity;
                str = ((PayInfo)localObject2).dac;
                if (((c)localObject1).vtX != null) {
                  break label1496;
                }
              }
              label1496:
              for (paramc = "";; paramc = ((c)localObject1).vtX.dmk())
              {
                ((com.tencent.mm.pluginsdk.wallet.a)localObject3).startOfflinePay((Context)localObject4, str, paramc, ((PayInfo)localObject2).channel);
                break;
                bool1 = false;
                break label1406;
              }
              label1510:
              localObject3 = ((c)localObject1).mActivity;
              if (((c)localObject1).vtX == null) {}
              for (paramc = "";; paramc = ((c)localObject1).vtX.dmk())
              {
                com.tencent.mm.pluginsdk.wallet.f.a((Context)localObject3, false, "", paramc, (PayInfo)localObject2, "", new Intent(), 1);
                break;
              }
            }
            if (20 == paramc.vty) {
              com.tencent.mm.plugin.offline.g.dlU();
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
    if (((paramDialog instanceof com.tencent.mm.ui.widget.a.d)) && (this.vuT))
    {
      this.vuU = true;
      paramDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(184850);
          if (this.vvD != null) {
            this.vvD.onDismiss(paramAnonymousDialogInterface);
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
  
  public final void bPC()
  {
    AppMethodBeat.i(66512);
    KI(0);
    oL(true);
    AppMethodBeat.o(66512);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public final void dmA()
  {
    int j = 0;
    AppMethodBeat.i(66498);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.dmS();
    findViewById(2131306839).setVisibility(0);
    this.vuy.setTextSize(0, getResources().getDimensionPixelSize(2131165517));
    String str;
    Object localObject;
    if ((this.vuy != null) && (localBankcard != null)) {
      if (localBankcard.eqW())
      {
        str = localBankcard.BuL;
        localObject = com.tencent.mm.plugin.wallet_core.model.s.ery().esv();
        if ((localObject == null) || (bs.isNullOrNil(localBankcard.field_forbidWord))) {
          break label347;
        }
        Iterator localIterator = ((List)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (com.tencent.mm.plugin.wallet_core.model.c)localIterator.next();
        } while (!((com.tencent.mm.plugin.wallet_core.model.c)localObject).vwo.equals(localBankcard.field_bindSerial));
      }
    }
    for (;;)
    {
      if ((localObject != null) && (!bs.isNullOrNil(((com.tencent.mm.plugin.wallet_core.model.c)localObject).BtZ)))
      {
        if (!localBankcard.eqW()) {
          str = localBankcard.field_desc + ((com.tencent.mm.plugin.wallet_core.model.c)localObject).BtZ;
        }
        findViewById(2131306839).setVisibility(8);
        com.tencent.mm.plugin.report.service.h.wUl.f(14515, new Object[] { Integer.valueOf(2) });
        this.vuy.setTextSize(0, getResources().getDimensionPixelSize(2131165466));
      }
      for (int i = 1;; i = 0)
      {
        this.vuy.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), str, this.vuy.getTextSize()));
        for (;;)
        {
          if (localBankcard != null) {
            a(localBankcard);
          }
          if (i != 0) {
            this.vuz.setImageResource(2131690126);
          }
          AppMethodBeat.o(66498);
          return;
          str = getString(2131765945, new Object[] { localBankcard.field_desc });
          break;
          i = j;
          if (localBankcard == null)
          {
            ac.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
            i = j;
          }
        }
      }
      label347:
      localObject = null;
    }
  }
  
  public final void dmH()
  {
    AppMethodBeat.i(66505);
    this.vuA.setVisibility(4);
    this.vvc.a(this.vus, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174394);
        com.tencent.mm.plugin.offline.c.a.dnc();
        com.tencent.mm.plugin.offline.c.a.k(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this));
        WalletOfflineCoinPurseUI.this.finish();
        AppMethodBeat.o(174394);
      }
    });
    AppMethodBeat.o(66505);
  }
  
  public final void dmi()
  {
    AppMethodBeat.i(66514);
    oM(false);
    AppMethodBeat.o(66514);
  }
  
  public final void dmj()
  {
    AppMethodBeat.i(66515);
    doSceneProgress(new j(""), false);
    AppMethodBeat.o(66515);
  }
  
  public final String dmk()
  {
    return this.vrw;
  }
  
  public final void dml()
  {
    AppMethodBeat.i(66518);
    if (!this.vse.eVs()) {
      this.vse.stopTimer();
    }
    KI(0);
    oL(true);
    this.vuQ = false;
    au localau = this.vse;
    long l = this.vsd;
    localau.au(l, l);
    AppMethodBeat.o(66518);
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66513);
    doSceneProgress(new com.tencent.mm.plugin.offline.a.e(paramInt, paramString1, paramString2, paramString3), com.tencent.mm.plugin.offline.c.a.dmR());
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
    this.vvc = ((OfflineAlertView)findViewById(2131302989));
    this.vvc.dismiss();
    this.vvc.setDialogState(new OfflineAlertView.a()
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
    com.tencent.mm.wallet_core.c.b.fAg().init(getApplicationContext());
    Object localObject;
    if ((this.mEntryScene == 3) || (this.mEntryScene == 10) || (this.mEntryScene == 11) || (this.mEntryScene == 12))
    {
      setMMTitle(2131765959);
      this.vvb = new c(this, this);
      localObject = this.vvb;
      ((c)localObject).njY = ((Vibrator)((c)localObject).mActivity.getSystemService("vibrator"));
      this.vva = new com.tencent.mm.wallet_core.ui.c(this, true);
      this.vva.fAL();
      this.vus = findViewById(2131306828);
      this.vut = ((ImageView)findViewById(2131306827));
      this.vuu = ((ImageView)findViewById(2131306693));
      this.vuv = ((TextView)findViewById(2131306694));
      this.vux = findViewById(2131306838);
      this.vuy = ((TextView)findViewById(2131306840));
      this.vuz = ((ImageView)findViewById(2131306837));
      this.vuA = ((RelativeLayout)findViewById(2131306763));
      this.vuB = ((LinearLayout)findViewById(2131306843));
      this.vuC = ((CdnImageView)findViewById(2131306844));
      this.vuD = ((TextView)findViewById(2131306842));
      this.vuE = ((TextView)findViewById(2131306841));
      this.vuA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66409);
          WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this);
          AppMethodBeat.o(66409);
        }
      });
      this.vut.setOnClickListener(this.jax);
      this.vuu.setOnClickListener(this.jax);
      this.vuv.setOnClickListener(this.jax);
      this.vux.setClickable(true);
      this.vux.setOnClickListener(new WalletOfflineCoinPurseUI.9(this));
      this.mLastTime = System.currentTimeMillis();
      this.vuF = new e();
      this.vuF.dbl();
      com.tencent.mm.plugin.newtips.a.dkb().h(this.vuF);
      this.vuG = new g();
      this.vuG.dbl();
      com.tencent.mm.plugin.newtips.a.dkb().h(this.vuG);
      this.vuH = new b();
      this.vuH.dbl();
      com.tencent.mm.plugin.newtips.a.dkb().h(this.vuH);
      this.vuI = new f();
      this.vuI.dbl();
      com.tencent.mm.plugin.newtips.a.dkb().h(this.vuI);
      this.vuJ = new d();
      this.vuJ.dbl();
      com.tencent.mm.plugin.newtips.a.dkb().h(this.vuJ);
      if ((this.mEntryScene != 3) && (this.mEntryScene != 10) && (this.mEntryScene != 11) && (this.mEntryScene != 12)) {
        break label901;
      }
      this.vuK.setVisibility(8);
      this.vuL.setVisibility(8);
      this.vuM.setVisibility(8);
      this.vuN.setVisibility(8);
      label613:
      if ((com.tencent.mm.plugin.offline.c.a.dmQ()) && (c.dmn()))
      {
        localObject = this.vvb;
        com.tencent.mm.plugin.offline.k.dlZ();
        ((c)localObject).a(com.tencent.mm.plugin.offline.k.dma().vtr);
      }
      dmt();
      U(true, false);
      localObject = this.vse;
      long l1 = this.vsd;
      ((au)localObject).au(l1, l1);
      if ((com.tencent.mm.plugin.offline.c.a.vwf != 3) || (!com.tencent.mm.plugin.offline.c.a.vwi)) {
        break label1134;
      }
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
      int i = com.tencent.mm.plugin.offline.c.a.vwg;
      l1 = com.tencent.mm.plugin.offline.c.a.vwh;
      long l2 = System.currentTimeMillis();
      long l3 = i * 1000 + l1 - l2;
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + l1 + " now:" + l2 + " interval:" + l3);
      if ((com.tencent.mm.plugin.offline.c.a.vwg <= 0) || (com.tencent.mm.plugin.offline.c.a.vwh <= 0L) || (l3 <= 0L)) {
        break label1122;
      }
      if (!this.vvw.eVs()) {
        this.vvw.stopTimer();
      }
      this.vvw.au(l3, l3);
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
    }
    for (;;)
    {
      dms();
      localObject = new xo();
      ((xo)localObject).dAo.scene = "5";
      ((xo)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66407);
          if (!bs.isNullOrNil(this.oCu.dAp.dAq))
          {
            com.tencent.mm.wallet_core.ui.e.a((TextView)WalletOfflineCoinPurseUI.this.findViewById(2131297186), this.oCu.dAp.dAq, this.oCu.dAp.content, this.oCu.dAp.url);
            AppMethodBeat.o(66407);
            return;
          }
          ac.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
          AppMethodBeat.o(66407);
        }
      };
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(66477);
      return;
      setMMTitle(2131765960);
      break;
      label901:
      this.vuN.setVisibility(0);
      this.vuO.setVisibility(0);
      final boolean bool1 = com.tencent.mm.plugin.newtips.a.g.b(this.vuF);
      final boolean bool2 = com.tencent.mm.plugin.newtips.a.g.b(this.vuH);
      final boolean bool3 = com.tencent.mm.plugin.newtips.a.g.b(this.vuI);
      final boolean bool4 = com.tencent.mm.plugin.newtips.a.g.b(this.vuG);
      final boolean bool5 = com.tencent.mm.plugin.newtips.a.g.b(this.vuJ);
      if (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(com.tencent.mm.storage.ah.a.GPs, Boolean.FALSE)).booleanValue()) {
        ac.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
      }
      ImageView localImageView;
      for (;;)
      {
        localObject = (TextView)findViewById(2131297128);
        localImageView = (ImageView)findViewById(2131297127);
        if (!this.vvg) {
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
            int i = aj.cl(WalletOfflineCoinPurseUI.this.getContext()).y;
            int j = i;
            if (aj.jF(WalletOfflineCoinPurseUI.this.getContext()))
            {
              ac.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
              j = i - aj.ej(WalletOfflineCoinPurseUI.this.getContext());
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
              ac.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
              i -= j;
              if (i > 0) {
                localScrollView.scrollBy(0, i);
              }
              com.tencent.mm.kernel.g.agR().agA().set(com.tencent.mm.storage.ah.a.GPs, Boolean.TRUE);
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
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
      continue;
      label1134:
      if (com.tencent.mm.plugin.offline.c.a.vwf == 3) {
        ac.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
      } else {
        ac.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.c.a.vwf) });
      }
    }
  }
  
  public final void k(final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(66496);
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(66496);
      return;
    }
    final ImageView localImageView = (ImageView)this.vuh.get(paramString);
    paramString = (Integer)this.vui.get(paramString);
    if ((localImageView == null) || (paramString == null))
    {
      AppMethodBeat.o(66496);
      return;
    }
    new ao(getMainLooper()).post(new Runnable()
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
    com.tencent.mm.plugin.wallet_core.model.s.ers();
    this.vvg = com.tencent.mm.plugin.wallet_core.model.s.erH();
    com.tencent.mm.plugin.offline.k.vso = true;
    com.tencent.mm.wallet_core.ui.e.adR(41);
    paramBundle = getIntent();
    this.vuS = paramBundle.getBooleanExtra("is_offline_create", false);
    if ((paramBundle != null) && (paramBundle.hasExtra("key_entry_scene"))) {
      this.mEntryScene = paramBundle.getIntExtra("key_entry_scene", this.mEntryScene);
    }
    this.fwc = paramBundle.getIntExtra("key_from_scene", 0);
    this.vuw = bs.bG(paramBundle.getStringExtra("key_business_attach"), "");
    this.qwN = 1;
    if (this.mEntryScene == 2) {
      this.qwN = 1;
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
          paramAnonymousMenuItem = new hs();
          paramAnonymousMenuItem.diL.diM = "ok";
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMenuItem);
          if (WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this) == 8) {
            com.tencent.mm.plugin.offline.c.a.aoU(WalletOfflineCoinPurseUI.this.getIntent().getStringExtra("key_appid"));
          }
          WalletOfflineCoinPurseUI.this.finish();
          AppMethodBeat.o(184867);
          return false;
        }
      });
      try
      {
        bg.a(this, this);
        i = 1;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", paramBundle, "", new Object[0]);
          getWindow().setFlags(8192, 8192);
          int i = 0;
          continue;
          if (com.tencent.mm.plugin.wallet_core.model.s.ery().esc())
          {
            ac.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
            com.tencent.mm.plugin.offline.c.a.dnc();
            com.tencent.mm.plugin.offline.k.dlZ();
            com.tencent.mm.plugin.offline.k.bu(196648, "0");
          }
          else if ((com.tencent.mm.plugin.wallet_core.model.s.ery().esa()) && (com.tencent.mm.plugin.offline.c.a.dmQ()))
          {
            dmK();
          }
        }
      }
      if (i == 0) {
        bg.a(this, null);
      }
      com.tencent.mm.wallet_core.ui.e.fAQ();
      if (!com.tencent.mm.plugin.wallet_core.model.s.ery().esf()) {
        break;
      }
      ac.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
      initView();
      com.tencent.mm.platformtools.u.a(this);
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.dma().a(this);
      addSceneEndListener(606);
      addSceneEndListener(609);
      addSceneEndListener(1501);
      com.tencent.mm.plugin.offline.k.dlZ();
      com.tencent.mm.plugin.offline.k.dmb().dz(this);
      com.tencent.mm.sdk.b.a.GpY.c(this.vvt);
      com.tencent.mm.plugin.offline.c.a.dnd();
      com.tencent.mm.sdk.b.a.GpY.b(this.vvr);
      com.tencent.mm.sdk.b.a.GpY.b(this.vvp);
      com.tencent.mm.sdk.b.a.GpY.b(this.vvl);
      this.vvm.alive();
      this.vvn.alive();
      this.vvo.alive();
      this.vuR = new com.tencent.mm.plugin.offline.g();
      paramBundle = new ne();
      paramBundle.dpM.aFZ = hashCode();
      com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
      this.vvq.alive();
      AppMethodBeat.o(66469);
      return;
      if (this.mEntryScene == 1) {
        this.qwN = 2;
      } else if (this.mEntryScene == 8) {
        this.qwN = 4;
      } else if (this.mEntryScene == 4) {
        this.qwN = 6;
      } else {
        ac.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[] { Integer.valueOf(this.qwN) });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66475);
    Object localObject = com.tencent.mm.plugin.offline.c.a.dmS();
    if (localObject != null)
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerial:%s serial:%s mLastBindSerial:%s", new Object[] { this.vrw, ((Bankcard)localObject).field_bindSerial, this.vur });
      if (((Bankcard)localObject).eqW())
      {
        localObject = this.vur;
        bs.isNullOrNil(this.vur);
        com.tencent.mm.plugin.offline.c.a.aoJ((String)localObject);
        com.tencent.mm.plugin.offline.k.dlZ();
        com.tencent.mm.plugin.offline.k.dmb().vrw = ((String)localObject);
      }
    }
    this.vvc.dismiss();
    com.tencent.mm.plugin.offline.k.vso = false;
    com.tencent.mm.wallet_core.ui.e.T(this.vuj);
    com.tencent.mm.wallet_core.ui.e.T(this.vuk);
    com.tencent.mm.wallet_core.ui.e.bc(this.vuY);
    com.tencent.mm.wallet_core.ui.e.bc(this.vuZ);
    this.vuY.clear();
    this.vuZ.clear();
    this.vuo.clear();
    this.vup.clear();
    this.vuq.clear();
    com.tencent.mm.platformtools.u.c(this);
    com.tencent.mm.plugin.offline.k.dlZ();
    com.tencent.mm.plugin.offline.k.dma().b(this);
    removeSceneEndListener(606);
    removeSceneEndListener(609);
    removeSceneEndListener(1501);
    com.tencent.mm.plugin.offline.k.dlZ();
    com.tencent.mm.plugin.offline.k.dmb().dA(this);
    com.tencent.mm.sdk.b.a.GpY.d(this.vvt);
    com.tencent.mm.sdk.b.a.GpY.d(this.vvr);
    com.tencent.mm.sdk.b.a.GpY.d(this.vvl);
    if (!this.vse.eVs()) {
      this.vse.stopTimer();
    }
    if (!this.vvw.eVs()) {
      this.vvw.stopTimer();
    }
    if (this.vva != null) {
      this.vva.release();
    }
    if (this.vvb != null)
    {
      localObject = this.vvb;
      ((c)localObject).njY.cancel();
      ((c)localObject).mActivity = null;
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.vvp);
    this.vvn.dead();
    this.vvo.dead();
    localObject = this.vuR;
    ((com.tencent.mm.plugin.offline.g)localObject).stop();
    com.tencent.mm.plugin.offline.g.dlU();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(385, ((com.tencent.mm.plugin.offline.g)localObject).vrO);
    ((com.tencent.mm.plugin.offline.g)localObject).vrQ = null;
    this.vvq.dead();
    this.vvm.dead();
    com.tencent.mm.plugin.remittance.mobile.a.b.Mw(0);
    super.onDestroy();
    AppMethodBeat.o(66475);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66517);
    if ((paramInt == 4) && (this.vvc != null) && (this.vvc.getVisibility() == 0) && (this.vvc.vtL))
    {
      this.vvc.dismiss();
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
    ac.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
    this.vum = true;
    AppMethodBeat.o(66473);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66474);
    com.tencent.mm.plugin.offline.k.dlZ();
    com.tencent.mm.plugin.offline.i locali = com.tencent.mm.plugin.offline.k.dmc();
    locali.mHandler.removeCallbacks(locali.vsc);
    bg.a(this, null);
    this.ctA = false;
    com.tencent.mm.sdk.b.a.GpY.d(this.vvs);
    this.vuR.stop();
    super.onPause();
    AppMethodBeat.o(66474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66471);
    super.onResume();
    com.tencent.mm.sdk.b.a.GpY.c(this.vvs);
    try
    {
      bg.a(this, this);
      if (!this.vvd)
      {
        dmp();
        this.vvd = true;
      }
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
      this.ctA = true;
      Object localObject = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).a(this, ((com.tencent.mm.plugin.walletlock.a.b)localObject).evh(), null);
      if (ax.isNetworkConnected(getBaseContext()))
      {
        if (com.tencent.mm.plugin.wallet_core.model.s.ery().esf()) {
          doSceneForceProgress(new ad(null, 8));
        }
        if ((com.tencent.mm.plugin.offline.c.a.dmQ()) && (this.vvk))
        {
          com.tencent.mm.plugin.offline.k.dlZ();
          com.tencent.mm.plugin.offline.k.dmc().oK(false);
          if (!c.dmn()) {
            doSceneProgress(new com.tencent.mm.plugin.offline.a.q(this.mEntryScene, this.jRj, this.vvh), false);
          }
        }
      }
      if (!this.vvk) {
        this.vvk = true;
      }
      dmt();
      localObject = com.tencent.mm.plugin.offline.c.a.dmS();
      if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (!((Bankcard)localObject).field_bindSerial.equals(this.vrw)))
      {
        this.vrw = ((Bankcard)localObject).field_bindSerial;
        com.tencent.mm.plugin.offline.k.dlZ();
        com.tencent.mm.plugin.offline.k.dmb().vrw = this.vrw;
        i = 1;
        if ((i != 0) || ((this.vun) && (this.vum)))
        {
          ac.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
          this.vun = false;
          this.vum = false;
          dmA();
          KI(0);
          oL(true);
        }
        localObject = this.vuR;
        if (!com.tencent.mm.plugin.offline.c.a.dnr()) {
          break label511;
        }
        ac.i(com.tencent.mm.plugin.offline.g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + ((com.tencent.mm.plugin.offline.g)localObject).vrQ.eVs());
        if ((((com.tencent.mm.plugin.offline.g)localObject).vrQ == null) || (((com.tencent.mm.plugin.offline.g)localObject).vrQ.eVs()))
        {
          ((com.tencent.mm.plugin.offline.g)localObject).status = 1;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 61L, 1L, true);
          if (!((com.tencent.mm.plugin.offline.g)localObject).vrP) {
            break label485;
          }
          com.tencent.mm.plugin.offline.g.dlU();
          localObject = ((com.tencent.mm.plugin.offline.g)localObject).vrQ;
          l = com.tencent.mm.plugin.offline.g.vrz;
          ((au)localObject).au(l, l);
          i = com.tencent.mm.plugin.offline.g.vrz;
        }
        if (this.vvi)
        {
          this.vvi = false;
          com.tencent.mm.plugin.report.service.h.wUl.f(18930, new Object[] { Integer.valueOf(this.vvj), Integer.valueOf(4) });
        }
        AppMethodBeat.o(66471);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", localException, "", new Object[0]);
        continue;
        int i = 0;
        continue;
        label485:
        au localau = localException.vrQ;
        long l = com.tencent.mm.plugin.offline.g.vrN;
        localau.au(l, l);
        i = com.tencent.mm.plugin.offline.g.vrN;
        continue;
        label511:
        ac.i(com.tencent.mm.plugin.offline.g.TAG, "OfflineGetMsg is not in abtest");
      }
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(66476);
    ac.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " scene: " + paramn);
    if (((paramn instanceof com.tencent.mm.plugin.offline.a.f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      ac.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.vsb.dme();
      this.vsb = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof ad))
      {
        if (this.vve)
        {
          this.vve = false;
          paramString = com.tencent.mm.plugin.offline.c.a.dmT();
          if (paramString != null) {
            doSceneForceProgress(new com.tencent.mm.plugin.offline.a.k(paramString, this.vvf, 0));
          }
          AppMethodBeat.o(66476);
          return true;
        }
        if (com.tencent.mm.plugin.offline.c.a.dmQ())
        {
          if (com.tencent.mm.plugin.offline.c.a.dmT() != null) {
            doSceneProgress(new com.tencent.mm.plugin.offline.a.n(System.currentTimeMillis(), this.mEntryScene), false);
          }
          dmK();
        }
        paramString = ((ad)paramn).Bpd;
        if ((paramString == null) || (paramString.Bxi == 0))
        {
          if (this.vvc.vtK == 7) {
            this.vvc.dismiss();
          }
          dmJ();
          label272:
          if ((!(paramn instanceof ad)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.n)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.a)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.e))) {
            break label1441;
          }
          dmt();
          U(false, true);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66476);
      return true;
      if (!this.vvc.KH(7)) {
        break;
      }
      if (this.vvc.vtK == 7) {
        this.vvc.dismiss();
      }
      this.vvj = paramString.Bxh;
      Object localObject1 = this.vvc;
      View localView = this.vus;
      Object localObject2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184855);
          ac.i("MicroMsg.WalletOfflineCoinPurseUI", "do click fqf text link");
          WalletOfflineCoinPurseUI.H(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.I(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this, "weixin://wcpay/fqf/opentinyapp");
          AppMethodBeat.o(184855);
        }
      };
      com.tencent.mm.plugin.report.service.h.wUl.f(18930, new Object[] { Integer.valueOf(paramString.Bxh), Integer.valueOf(1) });
      ((OfflineAlertView)localObject1).vtK = 7;
      ((OfflineAlertView)localObject1).setVisibility(0);
      ((OfflineAlertView)localObject1).vtL = false;
      ((OfflineAlertView)localObject1).isN.removeAllViews();
      Object localObject3 = LayoutInflater.from(((OfflineAlertView)localObject1).getContext()).inflate(2131495990, ((OfflineAlertView)localObject1).isN, false);
      ((OfflineAlertView)localObject1).isN.addView((View)localObject3);
      Object localObject4 = (TextView)((View)localObject3).findViewById(2131302001);
      TextView localTextView = (TextView)((View)localObject3).findViewById(2131305510);
      localObject3 = (Button)((View)localObject3).findViewById(2131300871);
      if (!bs.isNullOrNil(paramString.Bxk)) {
        ((TextView)localObject4).setText(paramString.Bxk);
      }
      if (!bs.isNullOrNil(paramString.Bxl))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("repayment_tiny_app_username", paramString.Bxm);
        ((Bundle)localObject4).putString("repayment_tiny_app_path", paramString.Bxn);
        localTextView.setText(paramString.Bxl);
        com.tencent.mm.pluginsdk.ui.span.k.a(localTextView, false, localObject4);
        if (((OfflineAlertView)localObject1).nAR != null) {
          com.tencent.mm.pluginsdk.ui.span.k.b(((OfflineAlertView)localObject1).nAR);
        }
        ((OfflineAlertView)localObject1).nAR = new OfflineAlertView.2((OfflineAlertView)localObject1, (View.OnClickListener)localObject2, paramString);
        com.tencent.mm.pluginsdk.ui.span.k.a(((OfflineAlertView)localObject1).nAR);
      }
      if (paramString.Bxj > 0)
      {
        ((Button)localObject3).setEnabled(false);
        if (((OfflineAlertView)localObject1).vtN == null) {
          break label705;
        }
        ((OfflineAlertView)localObject1).vtN.cancel();
      }
      for (;;)
      {
        ((OfflineAlertView)localObject1).vtN.start();
        ((Button)localObject3).setOnClickListener(new OfflineAlertView.4((OfflineAlertView)localObject1, paramString));
        localView.post(new OfflineAlertView.5((OfflineAlertView)localObject1, localView));
        break;
        label705:
        localObject2 = new com.tencent.mm.wallet_core.c.c();
        ((com.tencent.mm.wallet_core.c.c)localObject2).duration = (paramString.Bxj * 1000);
        ((com.tencent.mm.wallet_core.c.c)localObject2).interval = 1000L;
        ((com.tencent.mm.wallet_core.c.c)localObject2).JEG = new OfflineAlertView.3((OfflineAlertView)localObject1, (Button)localObject3);
        ((OfflineAlertView)localObject1).vtN = new com.tencent.mm.wallet_core.c.c.1((com.tencent.mm.wallet_core.c.c)localObject2, ((com.tencent.mm.wallet_core.c.c)localObject2).duration, ((com.tencent.mm.wallet_core.c.c)localObject2).interval);
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.m))
      {
        this.vsb = ((com.tencent.mm.plugin.offline.a.m)paramn);
        paramString = this.vsb.vtf;
        com.tencent.mm.plugin.offline.k.dlZ();
        paramString = new com.tencent.mm.plugin.offline.a.f(paramString, com.tencent.mm.plugin.offline.k.KG(196617));
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
        break label272;
      }
      if ((paramn instanceof j))
      {
        dmt();
        dmp();
        break label272;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.n))
      {
        paramString = (com.tencent.mm.plugin.offline.a.n)paramn;
        if ("1".equals(paramString.vtk))
        {
          ac.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
          if (bs.isNullOrNil(paramString.vtl)) {}
          for (paramString = getString(2131765224);; paramString = paramString.vtl)
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
        if (paramString.vsF == 0)
        {
          localObject1 = this.vvb;
          ((c)localObject1).vtZ = com.tencent.mm.plugin.offline.c.a.dmX();
          ((c)localObject1).vtZ = ((c)localObject1).vtZ;
          if (!"1".equals(paramString.vtj)) {
            break label272;
          }
          ac.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
          doSceneProgress(new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 8), false);
          break label272;
        }
        if (paramString.vsF == 0) {
          break label272;
        }
        this.vvb.a(paramString, paramString.vsF, paramString.vsG);
        break label272;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.a)) {
        break label272;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
      {
        this.vvb.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        break label272;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
      {
        if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
          this.mTipDialog.dismiss();
        }
        paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.i)paramn;
        if (("1".equals(paramString.BsC)) || (("2".equals(paramString.BsC)) && (!bs.isNullOrNil(paramString.BsD))))
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
          if ("collect".equals(paramString.BsG)) {
            dmq();
          } else if ("reward".equals(paramString.BsG)) {
            com.tencent.mm.br.d.N(getContext(), "collect", ".reward.ui.QrRewardMainUI");
          } else {
            ac.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { paramString.BsG });
          }
        }
      }
      if (!(paramn instanceof com.tencent.mm.plugin.offline.a.q)) {
        break label272;
      }
      paramString = (com.tencent.mm.plugin.offline.a.q)paramn;
      this.vuV = true;
      if ((paramString.isJumpRemind()) && (!this.vuW && (paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
      {
        public final void dan() {}
      }))) {
        this.vuW = true;
      }
      onSceneEnd(paramString.vtq.errType, paramString.vtq.errCode, paramString.vtq.errMsg, paramString.vto);
      onSceneEnd(paramString.vtp.errType, paramString.vtp.errCode, paramString.vtp.errMsg, paramString.vtn);
      if ((this.mdB == null) || (!this.mdB.isShowing()) || (this.vuX != 1)) {
        break label272;
      }
      oM(true);
      break label272;
      label1441:
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.f))
      {
        dmt();
        U(true, true);
      }
      else if ((paramn instanceof com.tencent.mm.plugin.offline.a.k))
      {
        com.tencent.mm.plugin.offline.c.a.ay(this);
        doSceneProgress(new ad(null, 8), false);
        dmE();
        dmF();
        dmC();
        continue;
        if ((paramn instanceof com.tencent.mm.plugin.offline.a.n))
        {
          dmt();
          U(false, true);
          if (411 == paramInt2) {
            this.vvb.a(paramn, paramInt2, paramString);
          }
        }
        else if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
        {
          this.vvb.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        }
        else if (!(paramn instanceof j))
        {
          if ((paramn instanceof com.tencent.mm.plugin.offline.a.f))
          {
            this.vsb = null;
          }
          else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
          {
            if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
              this.mTipDialog.dismiss();
            }
          }
          else if ((paramn instanceof com.tencent.mm.plugin.offline.a.q))
          {
            dmt();
            U(false, true);
            if (411 == paramInt2) {
              this.vvb.a(paramn, paramInt2, paramString);
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
  
  abstract class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    protected ImageView vvK;
    protected TextView vvL;
    protected ImageView vvM;
    
    public a()
    {
      dmM();
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
    }
    
    public final boolean a(boolean paramBoolean, dhn paramdhn)
    {
      if (paramBoolean)
      {
        this.vvM.setVisibility(0);
        this.vvL.setVisibility(0);
        this.vvL.setText(paramdhn.title);
      }
      for (;;)
      {
        return true;
        this.vvM.setVisibility(8);
        this.vvL.setVisibility(8);
      }
    }
    
    public final boolean b(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean dbk()
    {
      return false;
    }
    
    public boolean dbl()
    {
      return false;
    }
    
    public abstract void dmM();
    
    public final boolean nR(boolean paramBoolean)
    {
      return com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
    }
    
    public final boolean nS(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.vvM.setVisibility(0);
      }
      for (;;)
      {
        return true;
        this.vvM.setVisibility(8);
      }
    }
    
    public final boolean nT(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.vvK.setVisibility(0);
      }
      for (;;)
      {
        return true;
        this.vvK.setVisibility(8);
      }
    }
  }
  
  final class b
    extends WalletOfflineCoinPurseUI.a
  {
    public b()
    {
      super();
    }
    
    public final boolean dbl()
    {
      AppMethodBeat.i(66444);
      super.dbl();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.aeH().b(com.tencent.mm.storage.ah.a.GPn, com.tencent.mm.storage.ah.a.GOj))
      {
        this.vvK.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.vnu, true);
      }
      AppMethodBeat.o(66444);
      return true;
    }
    
    public final void dmM()
    {
      AppMethodBeat.i(66443);
      WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306758));
      this.vvK = ((ImageView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296290));
      this.vvL = ((TextView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296301));
      this.vvM = ((ImageView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296300));
      WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66442);
          ac.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
          com.tencent.mm.plugin.newtips.a.dkb().Ko(16);
          com.tencent.mm.plugin.report.service.h.wUl.f(14021, new Object[] { Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          paramAnonymousView = new Intent();
          if (WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this) == 1) {
            paramAnonymousView.putExtra("enter_scene", 2);
          }
          for (;;)
          {
            com.tencent.mm.br.d.b(WalletOfflineCoinPurseUI.this.getContext(), "aa", ".ui.AAEntranceUI", paramAnonymousView);
            WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
            if (com.tencent.mm.y.c.aeH().b(com.tencent.mm.storage.ah.a.GPn, com.tencent.mm.storage.ah.a.GOj))
            {
              com.tencent.mm.y.c.aeH().c(com.tencent.mm.storage.ah.a.GPn, com.tencent.mm.storage.ah.a.GOj);
              WalletOfflineCoinPurseUI.b.this.vvK.setVisibility(8);
              com.tencent.mm.plugin.report.service.h.wUl.f(14396, new Object[] { Integer.valueOf(4) });
            }
            AppMethodBeat.o(66442);
            return;
            if (WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this) == 2) {
              paramAnonymousView.putExtra("enter_scene", 4);
            } else {
              ac.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { Integer.valueOf(WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this)) });
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
    ArrayList<String> ijj;
    ArrayList<Boolean> vvO;
    
    public c()
    {
      AppMethodBeat.i(66446);
      this.ijj = new ArrayList();
      this.vvO = new ArrayList();
      AppMethodBeat.o(66446);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66447);
      int i = this.ijj.size();
      AppMethodBeat.o(66447);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(66448);
      Object localObject = this.ijj.get(paramInt);
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
      paramView.setText((String)this.ijj.get(paramInt));
      if (WalletOfflineCoinPurseUI.dmL() == paramInt)
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
      boolean bool = ((Boolean)this.vvO.get(paramInt)).booleanValue();
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
    
    public final void dmM()
    {
      AppMethodBeat.i(66452);
      WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306759));
      this.vvK = ((ImageView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297132));
      this.vvL = ((TextView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297134));
      this.vvM = ((ImageView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297133));
      WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66451);
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = new gg();
          paramAnonymousView.dCQ = 3L;
          paramAnonymousView.aHZ();
          com.tencent.mm.plugin.newtips.a.dkb().Ko(20);
          com.tencent.mm.plugin.remittance.mobile.a.b.Mw(WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this));
          if (WalletOfflineCoinPurseUI.Y(WalletOfflineCoinPurseUI.this))
          {
            com.tencent.mm.br.d.N(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".mobile.ui.BankMobileRemittanceChooseUI");
            AppMethodBeat.o(66451);
            return;
          }
          com.tencent.mm.br.d.N(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
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
    
    public final boolean dbl()
    {
      AppMethodBeat.i(66457);
      super.dbl();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.aeH().b(com.tencent.mm.storage.ah.a.GPo, com.tencent.mm.storage.ah.a.GOj))
      {
        com.tencent.mm.kernel.g.agS();
        String str = (String)com.tencent.mm.kernel.g.agR().agA().get(com.tencent.mm.storage.ah.a.GOD, "");
        if (bs.isNullOrNil(str)) {
          break label98;
        }
        this.vvL.setText(str);
        this.vvL.setVisibility(0);
        this.vvM.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.vnv, true);
      }
      for (;;)
      {
        AppMethodBeat.o(66457);
        return true;
        label98:
        this.vvK.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.vnu, true);
      }
    }
    
    public final void dmM()
    {
      AppMethodBeat.i(66456);
      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306761));
      this.vvK = ((ImageView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299650));
      this.vvL = ((TextView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299652));
      this.vvM = ((ImageView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299651));
      WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66455);
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.dkb().Ko(17);
          if (com.tencent.mm.y.c.aeH().b(com.tencent.mm.storage.ah.a.GPo, com.tencent.mm.storage.ah.a.GOj))
          {
            com.tencent.mm.y.c.aeH().c(com.tencent.mm.storage.ah.a.GPo, com.tencent.mm.storage.ah.a.GOj);
            WalletOfflineCoinPurseUI.e.this.vvK.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.vvL.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.vvM.setVisibility(8);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agR().agA().set(com.tencent.mm.storage.ah.a.GOD, "");
            com.tencent.mm.plugin.report.service.h.wUl.f(14396, new Object[] { Integer.valueOf(3) });
          }
          if (com.tencent.mm.plugin.wallet_core.model.s.ery().esa())
          {
            WalletOfflineCoinPurseUI.U(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.o(66455);
            return;
          }
          com.tencent.mm.plugin.wallet_core.model.s.ers();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          com.tencent.mm.wallet_core.d.i locali = WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this);
          new a.a()
          {
            public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(66454);
              ac.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + paramAnonymous2Int1 + ";errCode=" + paramAnonymous2Int2 + ";errMsg=" + paramAnonymous2String + ";hadAgree = " + paramAnonymous2Boolean);
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
    
    public final boolean dbl()
    {
      AppMethodBeat.i(66461);
      super.dbl();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.aeH().b(com.tencent.mm.storage.ah.a.GPp, com.tencent.mm.storage.ah.a.GOj))
      {
        this.vvK.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.vnu, true);
      }
      AppMethodBeat.o(66461);
      return true;
    }
    
    public final void dmM()
    {
      AppMethodBeat.i(66460);
      WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306762));
      this.vvK = ((ImageView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299640));
      this.vvL = ((TextView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299642));
      this.vvM = ((ImageView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299641));
      WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66459);
          ac.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.dkb().Ko(18);
          com.tencent.mm.plugin.report.service.h.wUl.f(14021, new Object[] { Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          com.tencent.mm.br.d.N(WalletOfflineCoinPurseUI.this.getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
          if (com.tencent.mm.y.c.aeH().b(com.tencent.mm.storage.ah.a.GPp, com.tencent.mm.storage.ah.a.GOj))
          {
            com.tencent.mm.y.c.aeH().c(com.tencent.mm.storage.ah.a.GPp, com.tencent.mm.storage.ah.a.GOj);
            WalletOfflineCoinPurseUI.f.this.vvK.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.wUl.f(14396, new Object[] { Integer.valueOf(5) });
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
    
    public final boolean dbl()
    {
      AppMethodBeat.i(66467);
      super.dbl();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.aeH().b(com.tencent.mm.storage.ah.a.GPq, com.tencent.mm.storage.ah.a.GOj))
      {
        this.vvK.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.vnu, true);
      }
      AppMethodBeat.o(66467);
      return true;
    }
    
    public final void dmM()
    {
      AppMethodBeat.i(66465);
      WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306764));
      this.vvK = ((ImageView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303608));
      this.vvL = ((TextView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303610));
      this.vvM = ((ImageView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303609));
      WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66464);
          ac.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.dkb().Ko(19);
          com.tencent.mm.plugin.report.service.h.wUl.f(14021, new Object[] { Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          if (com.tencent.mm.y.c.aeH().b(com.tencent.mm.storage.ah.a.GPq, com.tencent.mm.storage.ah.a.GOj))
          {
            com.tencent.mm.y.c.aeH().c(com.tencent.mm.storage.ah.a.GPq, com.tencent.mm.storage.ah.a.GOj);
            WalletOfflineCoinPurseUI.g.this.vvK.setVisibility(8);
          }
          if (com.tencent.mm.plugin.wallet_core.model.s.ery().esa())
          {
            com.tencent.mm.br.d.N(WalletOfflineCoinPurseUI.this.getContext(), "collect", ".reward.ui.QrRewardMainUI");
            AppMethodBeat.o(66464);
            return;
          }
          com.tencent.mm.plugin.wallet_core.model.s.ers();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          com.tencent.mm.wallet_core.d.i locali = WalletOfflineCoinPurseUI.X(WalletOfflineCoinPurseUI.this);
          new a.a()
          {
            public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(66463);
              ac.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + paramAnonymous2Int1 + ";errCode=" + paramAnonymous2Int2 + ";errMsg=" + paramAnonymous2String + ";hadAgree = " + paramAnonymous2Boolean);
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