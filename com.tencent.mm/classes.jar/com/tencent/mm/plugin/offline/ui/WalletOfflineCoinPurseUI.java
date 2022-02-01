package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.b;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.g.a.yo.b;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.b.a.hl;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.offline.a.j;
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
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.ai.a;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.kernel.i
public class WalletOfflineCoinPurseUI
  extends WalletBaseUI
  implements u.a, s.a, com.tencent.mm.plugin.offline.b, a, bi.a
{
  private static int nuE = 0;
  private boolean cFc;
  private int duP;
  private int fRv;
  private View.OnClickListener jwB;
  private int mEntryScene;
  private com.tencent.mm.ui.widget.a.e mIQ;
  private long mLastTime;
  private int mState;
  private Dialog mTipDialog;
  private boolean oLY;
  private int roH;
  private HashMap<String, Integer> vtZ;
  private String wMz;
  private String wNc;
  private com.tencent.mm.plugin.offline.a.m wNe;
  private int wNg;
  private aw wNh;
  private com.tencent.mm.sdk.b.c<kt> wNu;
  private String wPA;
  private View wPB;
  private TextView wPC;
  private ImageView wPD;
  private RelativeLayout wPE;
  private LinearLayout wPF;
  private CdnImageView wPG;
  private TextView wPH;
  private TextView wPI;
  private e wPJ;
  private g wPK;
  private b wPL;
  private f wPM;
  private d wPN;
  private LinearLayout wPO;
  private LinearLayout wPP;
  private LinearLayout wPQ;
  private LinearLayout wPR;
  private LinearLayout wPS;
  private String wPT;
  private boolean wPU;
  private com.tencent.mm.plugin.offline.g wPV;
  private boolean wPW;
  private boolean wPX;
  private boolean wPY;
  private boolean wPZ;
  private HashMap<String, View> wPl;
  private HashMap<String, Integer> wPm;
  Bitmap wPn;
  Bitmap wPo;
  private c wPp;
  private boolean wPq;
  private boolean wPr;
  private ArrayList<String> wPs;
  private ArrayList<String> wPt;
  private ArrayList<Boolean> wPu;
  private String wPv;
  private View wPw;
  private ImageView wPx;
  private ImageView wPy;
  private TextView wPz;
  private aw wQA;
  private aw wQB;
  private boolean wQa;
  private int wQb;
  private ArrayList<Bitmap> wQc;
  private ArrayList<Bitmap> wQd;
  private com.tencent.mm.wallet_core.ui.c wQe;
  private c wQf;
  private OfflineAlertView wQg;
  private boolean wQh;
  private boolean wQi;
  private String wQj;
  private boolean wQk;
  private String wQl;
  private boolean wQm;
  private int wQn;
  private boolean wQo;
  private com.tencent.mm.plugin.wallet_core.model.r wQp;
  com.tencent.mm.sdk.b.c<yv> wQq;
  com.tencent.mm.sdk.b.c<yv> wQr;
  private com.tencent.mm.sdk.b.c<cx> wQs;
  private com.tencent.mm.sdk.b.c<od> wQt;
  private com.tencent.mm.sdk.b.c<nm> wQu;
  private com.tencent.mm.sdk.b.c<nn> wQv;
  private com.tencent.mm.sdk.b.c wQw;
  private com.tencent.mm.sdk.b.c wQx;
  private com.tencent.mm.sdk.b.c wQy;
  public boolean wQz;
  
  public WalletOfflineCoinPurseUI()
  {
    AppMethodBeat.i(66468);
    this.mLastTime = 0L;
    this.mState = 3;
    this.wPl = new HashMap();
    this.wPm = new HashMap();
    this.mEntryScene = -1;
    this.wPn = null;
    this.wPo = null;
    this.wPq = false;
    this.wPr = false;
    this.wPs = new ArrayList();
    this.wPt = new ArrayList();
    this.wPu = new ArrayList();
    this.wMz = "";
    this.wPv = "";
    this.wPT = "";
    this.wNc = "";
    this.oLY = true;
    this.wPU = false;
    this.wPW = false;
    this.wPX = false;
    this.wPY = false;
    this.wPZ = true;
    this.wQa = false;
    this.wQb = -1;
    this.wQc = new ArrayList();
    this.wQd = new ArrayList();
    this.wQh = false;
    this.wQi = false;
    this.wQj = null;
    this.wQk = false;
    this.duP = 0;
    this.wQm = false;
    this.wQo = true;
    this.wQq = new com.tencent.mm.sdk.b.c() {};
    this.wQr = new com.tencent.mm.sdk.b.c() {};
    this.wQs = new WalletOfflineCoinPurseUI.23(this);
    this.wQt = new com.tencent.mm.sdk.b.c() {};
    this.wQu = new com.tencent.mm.sdk.b.c() {};
    this.wQv = new WalletOfflineCoinPurseUI.37(this);
    this.wQw = new WalletOfflineCoinPurseUI.38(this);
    this.wQx = new com.tencent.mm.sdk.b.c() {};
    this.wQy = new com.tencent.mm.sdk.b.c() {};
    this.jwB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66411);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        long l;
        if ((paramAnonymousView.getId() == 2131306827) || (paramAnonymousView.getId() == 2131306693) || (paramAnonymousView.getId() == 2131306694))
        {
          if ((paramAnonymousView.getId() == 2131306827) && (WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).isShowing()))
          {
            ae.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66411);
            return;
          }
          l = System.currentTimeMillis();
          if (((WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this) == null) || (!WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).isShowing())) && (l - WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this) >= 400L) && (com.tencent.mm.plugin.offline.c.a.dAy()) && (!WalletOfflineCoinPurseUI.q(WalletOfflineCoinPurseUI.this)))
          {
            if (paramAnonymousView.getId() != 2131306827) {
              break label260;
            }
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, false);
          }
        }
        for (;;)
        {
          if (WalletOfflineCoinPurseUI.r(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.s(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.r(WalletOfflineCoinPurseUI.this).S(paramAnonymousView, WalletOfflineCoinPurseUI.t(WalletOfflineCoinPurseUI.this));
          }
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, l);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66411);
          return;
          label260:
          if ((paramAnonymousView.getId() == 2131306693) || (paramAnonymousView.getId() == 2131306694))
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(13958, new Object[] { Integer.valueOf(4) });
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, true);
          }
        }
      }
    };
    this.wQz = false;
    this.vtZ = new HashMap();
    this.wNg = 60000;
    this.wNh = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66434);
        if (!WalletOfflineCoinPurseUI.L(WalletOfflineCoinPurseUI.this))
        {
          WalletOfflineCoinPurseUI.y(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.z(WalletOfflineCoinPurseUI.this);
        }
        aw localaw = WalletOfflineCoinPurseUI.N(WalletOfflineCoinPurseUI.this);
        long l = WalletOfflineCoinPurseUI.M(WalletOfflineCoinPurseUI.this);
        localaw.ay(l, l);
        AppMethodBeat.o(66434);
        return false;
      }
    }, false);
    this.wQA = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(174401);
        WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this);
        if ((WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).isShowing())) {
          WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).dismiss();
        }
        com.tencent.mm.plugin.offline.g.dzB();
        WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this);
        if (com.tencent.mm.plugin.offline.c.a.dAZ()) {
          WalletOfflineCoinPurseUI.this.dzS();
        }
        AppMethodBeat.o(174401);
        return false;
      }
    }, false);
    this.wQB = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(184862);
        ae.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this)) });
        if (WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this))
        {
          cj localcj = new cj();
          localcj.dor.bZU = 0;
          com.tencent.mm.sdk.b.a.IvT.l(localcj);
        }
        WalletOfflineCoinPurseUI.this.finish();
        AppMethodBeat.o(184862);
        return false;
      }
    }, false);
    this.wNu = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(66468);
  }
  
  private void MP(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(66490);
    if (!com.tencent.mm.plugin.offline.c.a.dAy())
    {
      ae.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
      AppMethodBeat.o(66490);
      return;
    }
    com.tencent.mm.plugin.offline.k.dzG();
    Object localObject = com.tencent.mm.plugin.offline.k.dzI().B(this.mEntryScene, paramInt, this.wPA);
    this.wNc = ((String)localObject);
    this.wPT = ((String)localObject);
    ae.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[] { Integer.valueOf(paramInt), this.wNc, this.wPT, bu.fpN().toString() });
    ccA();
    if (bu.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.mm.plugin.report.service.g.yxI;
      if (com.tencent.mm.plugin.offline.c.a.cJ(ak.getContext())) {}
      for (paramInt = 0;; paramInt = 1)
      {
        if (az.isNetworkConnected(getBaseContext())) {
          i = 1;
        }
        ((com.tencent.mm.plugin.report.service.g)localObject).f(14163, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 26L, 1L, true);
        if (!az.isNetworkConnected(getBaseContext())) {
          break;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 28L, 1L, true);
        AppMethodBeat.o(66490);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 27L, 1L, true);
    }
    AppMethodBeat.o(66490);
  }
  
  private static void MQ(int paramInt)
  {
    AppMethodBeat.i(66509);
    com.tencent.mm.g.b.a.r localr = new com.tencent.mm.g.b.a.r();
    localr.dTY = paramInt;
    localr.aLH();
    AppMethodBeat.o(66509);
  }
  
  private void X(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66480);
    if (com.tencent.mm.plugin.offline.c.a.pu(true).size() > 0)
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
      dAi();
      dAh();
      this.wPB.setVisibility(0);
    }
    for (;;)
    {
      if (paramBoolean1) {
        MP(0);
      }
      ps(paramBoolean2);
      bXV();
      dzZ();
      AppMethodBeat.o(66480);
      return;
      this.wPB.setVisibility(0);
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
    }
  }
  
  private void a(Bankcard paramBankcard)
  {
    AppMethodBeat.i(66511);
    if (TextUtils.isEmpty(this.wMz))
    {
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
      AppMethodBeat.o(66511);
      return;
    }
    if (paramBankcard.eIC())
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
      this.wPD.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      AppMethodBeat.o(66511);
      return;
    }
    String str2 = com.tencent.mm.plugin.offline.c.a.avf(this.wMz);
    String str1 = str2;
    if (paramBankcard.eIz())
    {
      str1 = str2;
      if (paramBankcard.Dmu != null) {
        str1 = paramBankcard.Dmu.wFJ;
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
      AppMethodBeat.o(66511);
      return;
    }
    e(this.wPD, str1, getResources().getDimensionPixelOffset(2131167003));
    AppMethodBeat.o(66511);
  }
  
  private void bXV()
  {
    AppMethodBeat.i(66479);
    if (com.tencent.mm.plugin.offline.c.a.dAy())
    {
      this.wPE.setVisibility(0);
      AppMethodBeat.o(66479);
      return;
    }
    this.wPE.setVisibility(4);
    AppMethodBeat.o(66479);
  }
  
  private void ccA()
  {
    AppMethodBeat.i(66516);
    bb localbb = com.tencent.mm.plugin.wallet_core.model.k.eIV();
    Object localObject = new StringBuilder().append(this.wPT);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP();
    localObject = com.tencent.mm.sdk.platformtools.aj.ej(p.getString(com.tencent.mm.kernel.a.getUin()));
    if (localbb != null) {
      com.tencent.mm.plugin.report.service.g.yxI.f(13444, new Object[] { localbb.FLd, localbb.FLe, Long.valueOf(localbb.FLc), localObject, localbb.FLf, localbb.FLg, localbb.FLh });
    }
    AppMethodBeat.o(66516);
  }
  
  private void dAa()
  {
    AppMethodBeat.i(66482);
    int i = com.tencent.mm.plugin.offline.c.a.dAD();
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.dAB();
    if (c.dzU())
    {
      this.mState = 7;
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
      AppMethodBeat.o(66482);
      return;
    }
    if (!az.isNetworkConnected(getBaseContext()))
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
      this.mState = 6;
      AppMethodBeat.o(66482);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.dAy())
    {
      if (i == 0)
      {
        ae.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
        this.mState = 1;
        AppMethodBeat.o(66482);
        return;
      }
      if ((i != 0) && (localBankcard == null))
      {
        ae.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
        this.mState = 2;
        AppMethodBeat.o(66482);
        return;
      }
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
      this.mState = 5;
      AppMethodBeat.o(66482);
      return;
    }
    if (i == 0)
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
      this.mState = 1;
      AppMethodBeat.o(66482);
      return;
    }
    if ((i != 0) && (localBankcard == null))
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
      this.mState = 2;
      AppMethodBeat.o(66482);
      return;
    }
    ae.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
    this.mState = 5;
    AppMethodBeat.o(66482);
  }
  
  private boolean dAb()
  {
    return (this.mState == 2) || (this.mState == 1) || (this.mState == 7);
  }
  
  private void dAc()
  {
    AppMethodBeat.i(66485);
    Bitmap localBitmap = this.wPo;
    this.wPo = dAe();
    this.wPy.setImageBitmap(this.wPo);
    if (dAb()) {
      this.wPy.setAlpha(10);
    }
    for (;;)
    {
      this.wQd.add(0, localBitmap);
      AppMethodBeat.o(66485);
      return;
      this.wPy.setAlpha(255);
    }
  }
  
  private void dAd()
  {
    AppMethodBeat.i(66486);
    if (this.wQe != null)
    {
      this.wQe.mL(this.wPT, this.wNc);
      this.wQe.wPn = this.wPn;
      this.wQe.wPo = this.wPo;
      this.wQe.fWs();
    }
    AppMethodBeat.o(66486);
  }
  
  private Bitmap dAe()
  {
    AppMethodBeat.i(66488);
    if (TextUtils.isEmpty(this.wNc))
    {
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
      AppMethodBeat.o(66488);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.by.a.a.b(this, this.wNc, 5, 0);
    AppMethodBeat.o(66488);
    return localBitmap;
  }
  
  private Bitmap dAf()
  {
    AppMethodBeat.i(66489);
    if (TextUtils.isEmpty(this.wPT))
    {
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
      AppMethodBeat.o(66489);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.by.a.a.b(this, this.wPT, 12, 3);
    AppMethodBeat.o(66489);
    return localBitmap;
  }
  
  private void dAg()
  {
    AppMethodBeat.i(66493);
    if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
      this.mTipDialog.dismiss();
    }
    AppMethodBeat.o(66493);
  }
  
  private void dAi()
  {
    AppMethodBeat.i(66499);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.dAA();
    if (localBankcard != null)
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
      com.tencent.mm.plugin.offline.c.a.auY(localBankcard.field_bindSerial);
      this.wMz = localBankcard.field_bindSerial;
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.dzI().wMz = this.wMz;
      AppMethodBeat.o(66499);
      return;
    }
    ae.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
    AppMethodBeat.o(66499);
  }
  
  private void dAj()
  {
    AppMethodBeat.i(66500);
    if (this.wPW)
    {
      AppMethodBeat.o(66500);
      return;
    }
    if (!this.wQg.MO(4))
    {
      AppMethodBeat.o(66500);
      return;
    }
    com.tencent.mm.kernel.g.ajS();
    if ((!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQJ, Boolean.FALSE)).booleanValue()) && (!this.wQg.isShowing())) {
      dAk();
    }
    AppMethodBeat.o(66500);
  }
  
  private void dAk()
  {
    AppMethodBeat.i(66501);
    if (!this.wQg.MO(4))
    {
      AppMethodBeat.o(66501);
      return;
    }
    this.wQg.ew(this.wPw);
    AppMethodBeat.o(66501);
  }
  
  private void dAl()
  {
    AppMethodBeat.i(66502);
    if (!this.wQg.MO(1))
    {
      AppMethodBeat.o(66502);
      return;
    }
    if (this.wQg.wON == 1) {
      this.wQg.dismiss();
    }
    boolean bool1 = t.eJf().eJJ();
    boolean bool2 = t.eJf().eJI();
    if ((bool1) || (bool2))
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.wQg.a(this.wPw, new WalletOfflineCoinPurseUI.20(this), 1);
    }
    AppMethodBeat.o(66502);
  }
  
  private void dAm()
  {
    AppMethodBeat.i(66503);
    if (!this.wQg.MO(3))
    {
      AppMethodBeat.o(66503);
      return;
    }
    if (this.wQg.wON == 3) {
      this.wQg.dismiss();
    }
    com.tencent.mm.plugin.offline.k.dzG();
    String str1 = com.tencent.mm.plugin.offline.k.MN(196617);
    com.tencent.mm.wallet_core.c.b.fVM();
    boolean bool1 = com.tencent.mm.wallet_core.c.b.isCertExist(str1);
    boolean bool2 = com.tencent.mm.plugin.offline.c.a.dAy();
    ae.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) || (!bool2)) {
      if (!bool1)
      {
        com.tencent.mm.kernel.g.ajS();
        String str2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IKp, "");
        if ((str2 == null) || (!str2.equals(com.tencent.mm.compatible.deviceinfo.q.cH(true)))) {
          break label222;
        }
        ae.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + str1 + " ,recreate offline");
      com.tencent.mm.plugin.offline.c.a.dAK();
      this.wPE.setVisibility(4);
      this.wQg.a(this.wPw, new WalletOfflineCoinPurseUI.21(this), 3);
      AppMethodBeat.o(66503);
      return;
      label222:
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
    }
  }
  
  private void dAn()
  {
    AppMethodBeat.i(66504);
    if (!this.wQg.MO(5))
    {
      AppMethodBeat.o(66504);
      return;
    }
    if (this.wQg.wON == 5) {
      this.wQg.dismiss();
    }
    this.wQg.b(this.wPw, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66423);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.offline.k.dzG();
        com.tencent.mm.plugin.offline.k.dzJ();
        ae.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.i.dzF()) });
        com.tencent.mm.plugin.offline.k.dzG();
        com.tencent.mm.plugin.offline.k.dzJ();
        if (com.tencent.mm.plugin.offline.i.dzF() <= 0)
        {
          paramAnonymousView = new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 10);
          WalletOfflineCoinPurseUI.this.doSceneForceProgress(paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66423);
          return;
          WalletOfflineCoinPurseUI.G(WalletOfflineCoinPurseUI.this);
        }
      }
    });
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 73L, 1L, true);
    AppMethodBeat.o(66504);
  }
  
  private void dAp()
  {
    AppMethodBeat.i(189951);
    if ((this.wQp == null) || (!this.wQp.oFM))
    {
      if (this.wQg.wON == 8) {
        this.wQg.dismiss();
      }
      AppMethodBeat.o(189951);
      return;
    }
    if (!this.wQg.MO(8))
    {
      AppMethodBeat.o(189951);
      return;
    }
    if (this.wQg.wON == 8) {
      this.wQg.dismiss();
    }
    this.wQg.a(this.wPw, this.wQp);
    com.tencent.mm.plugin.report.service.g.yxI.f(20258, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(189951);
  }
  
  private void dAq()
  {
    AppMethodBeat.i(66506);
    if ((this.wQg.isShowing()) && (this.wQg.wON == 5)) {
      this.wQg.dismiss();
    }
    AppMethodBeat.o(66506);
  }
  
  private boolean dAr()
  {
    AppMethodBeat.i(66507);
    if (!this.wQg.MO(2))
    {
      AppMethodBeat.o(66507);
      return false;
    }
    if (this.wQg.wON == 2) {
      this.wQg.dismiss();
    }
    List localList = com.tencent.mm.plugin.offline.c.a.dAE();
    if (localList.size() <= 0)
    {
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      AppMethodBeat.o(66507);
      return false;
    }
    int i = 0;
    while (i < localList.size())
    {
      Bankcard localBankcard = (Bankcard)localList.get(i);
      if ((localBankcard != null) && (localBankcard.field_support_micropay) && (bu.isNullOrNil(localBankcard.field_forbidWord)))
      {
        AppMethodBeat.o(66507);
        return true;
      }
      i += 1;
    }
    this.wQg.dismiss();
    this.wQg.a(this.wPw, new Runnable()new WalletOfflineCoinPurseUI.27
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
          com.tencent.mm.plugin.offline.c.a.i(localc.mActivity, localc.wPe);
        }
      }
    }, new WalletOfflineCoinPurseUI.27(this));
    AppMethodBeat.o(66507);
    return false;
  }
  
  private static void dAs()
  {
    AppMethodBeat.i(66510);
    if (!com.tencent.mm.plugin.offline.c.a.dAR())
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.dzJ().gT(3, 3);
    }
    AppMethodBeat.o(66510);
  }
  
  private void dkX()
  {
    AppMethodBeat.i(66484);
    Bitmap localBitmap = this.wPn;
    this.wPn = dAf();
    this.wPx.setImageBitmap(this.wPn);
    this.wQc.add(0, localBitmap);
    AppMethodBeat.o(66484);
  }
  
  private void dzW()
  {
    AppMethodBeat.i(66470);
    dAl();
    dAr();
    dAm();
    dAj();
    dAp();
    AppMethodBeat.o(66470);
  }
  
  private void dzX()
  {
    AppMethodBeat.i(66472);
    com.tencent.mm.wallet_core.ui.f.aha(32);
    com.tencent.mm.pluginsdk.wallet.f.au(this, this.roH);
    AppMethodBeat.o(66472);
  }
  
  private void dzY()
  {
    AppMethodBeat.i(66478);
    cee localcee = t.eJf().DsF;
    if (localcee == null)
    {
      this.wPF.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if (localcee.HqY == null)
    {
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "offlineGuideBar.guide_data == null");
      this.wPF.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    Object localObject = localcee.HqY.wRt;
    if (t.eJf().aFN((String)localObject) == null)
    {
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar bindSerial(%s) is null bankcard!", new Object[] { bu.bI((String)localObject, "") });
      this.wPF.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    localObject = com.tencent.mm.plugin.offline.c.a.dAA();
    if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (bu.lX(localcee.HqY.wRt, ((Bankcard)localObject).field_bindSerial)))
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar defaultBankcard(%s) == bindSerial(%s)", new Object[] { ((Bankcard)localObject).field_bindSerial, localcee.HqY.wRt });
      this.wPF.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if ((this.wPF.isShown()) && (this.wPF.getTag() != null) && ((this.wPF.getTag() instanceof cee)) && (bu.K((cee)this.wPF.getTag(), localcee)))
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "");
      AppMethodBeat.o(66478);
      return;
    }
    if (localcee.CYo == 0)
    {
      this.wPF.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if (!this.wPZ)
    {
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "isShowGuideBar == false");
      AppMethodBeat.o(66478);
      return;
    }
    int i = this.wPF.getVisibility();
    this.wPF.setTag(localcee);
    this.wPF.setVisibility(0);
    if ((!bu.isNullOrNil(localcee.HqZ)) && (this.wPF.getBackground() != null)) {
      this.wPF.getBackground().setColorFilter(Color.parseColor(localcee.HqZ), PorterDuff.Mode.SRC);
    }
    int j = BackwardSupportUtil.b.h(this, 20.0F);
    this.wPG.r(localcee.CYv, j, j, -1);
    this.wPH.setText(localcee.CYq);
    this.wPH.setTextColor(Color.parseColor(localcee.CYr));
    this.wPI.setText(localcee.CYs);
    this.wPI.setTextColor(Color.parseColor(localcee.CYt));
    this.wPI.setTag(localcee.HqY.wRt);
    al.a(this.wPI.getPaint(), 0.8F);
    if (localcee.Dae == ai.a.Dsh.value) {
      this.wPI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184848);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          WalletOfflineCoinPurseUI.MR(2);
          String str = "";
          localObject = str;
          if (paramAnonymousView.getTag() != null)
          {
            localObject = str;
            if ((paramAnonymousView.getTag() instanceof String)) {
              localObject = (String)paramAnonymousView.getTag();
            }
          }
          ae.i("MicroMsg.WalletOfflineCoinPurseUI", "mOfflineGuideButtonTv click! bindSerial:%s", new Object[] { localObject });
          if (bu.isNullOrNil((String)localObject))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(184848);
            return;
          }
          WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = t.eJf().aFN((String)localObject);
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(184848);
        }
      });
    }
    MQ(1);
    if ((i == 8) && (this.wQg.isShowing()))
    {
      dAj();
      if ((!this.wPW) && (this.wQg.MO(4)))
      {
        com.tencent.mm.kernel.g.ajS();
        if (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQJ, Boolean.FALSE)).booleanValue()) {
          dAk();
        }
      }
    }
    AppMethodBeat.o(66478);
  }
  
  private void dzZ()
  {
    AppMethodBeat.i(66481);
    if ((!this.wQz) && (!az.isNetworkConnected(getBaseContext())))
    {
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.dzI();
      if (com.tencent.mm.plugin.offline.e.dzy() == 0)
      {
        this.wQz = true;
        b.aw(this);
        ae.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
      }
    }
    AppMethodBeat.o(66481);
  }
  
  private void e(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(66495);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66495);
      return;
    }
    Bitmap localBitmap = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramString));
    if (localBitmap != null) {
      paramImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.h.a(localBitmap, paramInt, paramInt, true, false));
    }
    this.wPl.put(paramString, paramImageView);
    this.wPm.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(66495);
  }
  
  private void ps(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(66483);
    long l = System.currentTimeMillis();
    int i;
    if ((paramBoolean) && ((bu.isNullOrNil(this.wPT)) || (bu.isNullOrNil(this.wNc))))
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
      dAn();
      dkX();
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - l));
      dAc();
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - l));
      recycleBmpList();
      dAd();
      dzY();
      ab.kI(10, 0);
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
      if (!com.tencent.mm.plugin.offline.c.a.cJ(ak.getContext())) {
        break label281;
      }
      i = 0;
      label148:
      if (az.isNetworkConnected(ak.getContext())) {
        j = 1;
      }
      com.tencent.mm.plugin.offline.k.dzG();
      com.tencent.mm.plugin.offline.k.dzI();
      localg.f(14163, new Object[] { Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(com.tencent.mm.plugin.offline.e.dzy()) });
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 67L, 1L, true);
      if (!az.isNetworkConnected(ak.getContext())) {
        break label286;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 32L, 1L, true);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.offline.c.a.cJ(this)) {
        break label303;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 34L, 1L, true);
      AppMethodBeat.o(66483);
      return;
      dAq();
      break;
      label281:
      i = 1;
      break label148;
      label286:
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 33L, 1L, true);
    }
    label303:
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 35L, 1L, true);
    AppMethodBeat.o(66483);
  }
  
  private void pt(boolean paramBoolean)
  {
    AppMethodBeat.i(66508);
    if (!com.tencent.mm.plugin.offline.c.a.dAy())
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.dAy()) });
      AppMethodBeat.o(66508);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.pu(false).size() <= 0)
    {
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      this.wPC.setVisibility(8);
      AppMethodBeat.o(66508);
      return;
    }
    final ArrayList localArrayList = af.uu(true);
    int i;
    Object localObject;
    int j;
    if ((paramBoolean) && (this.mIQ == null))
    {
      this.mIQ = new com.tencent.mm.ui.widget.a.e(this, 2, true);
      this.wQb = -1;
      this.mIQ.bqD();
      i = 0;
      localObject = null;
      j = 0;
      label128:
      if (i >= localArrayList.size()) {
        break label213;
      }
      Bankcard localBankcard = (Bankcard)localArrayList.get(i);
      if ((bu.isNullOrNil(localBankcard.field_bindSerial)) || (!this.wMz.equals(localBankcard.field_bindSerial))) {
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
      this.mIQ = null;
      this.mIQ = new com.tencent.mm.ui.widget.a.e(this, 2, true);
      break;
      if (localObject != null)
      {
        localArrayList.remove(localObject);
        localArrayList.add(0, localObject);
        j = 0;
      }
      this.mIQ.LfS = new n.d()
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
            localObject1 = com.tencent.mm.plugin.offline.c.a.ave(localBankcard.field_bankcardType);
            localObject3 = localObject1;
            if (localBankcard.eIz())
            {
              localObject3 = localObject1;
              if (localBankcard.Dmu != null) {
                localObject3 = localBankcard.Dmu.wFJ;
              }
            }
            localBitmap = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject3));
            u.a(new u.a()
            {
              public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(184858);
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(184857);
                    ae.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletOfflineCoinPurseUI.28.1.this.wQL });
                    if (WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).containsKey(paramAnonymous2String))
                    {
                      int i = ((Integer)WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).get(paramAnonymous2String)).intValue();
                      if (WalletOfflineCoinPurseUI.28.1.this.vuh.getItem(i) != null)
                      {
                        WalletOfflineCoinPurseUI.28.1.this.vuh.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.h.a(paramAnonymous2Bitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), true, false)));
                        WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).fQA();
                      }
                    }
                    AppMethodBeat.o(184857);
                  }
                });
                AppMethodBeat.o(184858);
              }
            });
            localObject2 = "";
            if (!bu.isNullOrNil(localBankcard.field_forbidWord)) {
              localObject2 = localBankcard.field_forbidWord;
            }
            localObject1 = localObject2;
            if (bu.isNullOrNil((String)localObject2))
            {
              localObject1 = localObject2;
              if (!localBankcard.field_support_micropay)
              {
                if (!bu.isNullOrNil(localBankcard.field_no_micro_word)) {
                  break label531;
                }
                localObject1 = "";
              }
            }
            if (bu.isNullOrNil(localBankcard.field_forbid_title))
            {
              localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
              localObject4 = localObject1;
              localObject1 = localObject2;
              label203:
              if ((!bu.ah((CharSequence)localObject1)) || (bu.isNullOrNil(localBankcard.field_prompt_info_prompt_text))) {
                break label808;
              }
              localObject1 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
              if ((!bu.isNullOrNil(localBankcard.field_prompt_info_jump_text)) && (!bu.isNullOrNil(localBankcard.field_prompt_info_jump_url)))
              {
                ((SpannableStringBuilder)localObject1).append(localBankcard.field_prompt_info_jump_text);
                ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
                {
                  public final void dN(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(189949);
                    com.tencent.mm.wallet_core.ui.f.aY(WalletOfflineCoinPurseUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
                    com.tencent.mm.plugin.report.service.g.yxI.f(20216, new Object[] { Integer.valueOf(3), localBankcard.field_prompt_info_jump_url });
                    AppMethodBeat.o(189949);
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
            if (((localBankcard.eIy()) || (localBankcard.eIz())) && (localBankcard.Dmj >= 0.0D))
            {
              str = localBankcard.field_desc + WalletOfflineCoinPurseUI.this.getString(2131764999, new Object[] { com.tencent.mm.wallet_core.ui.f.D(localBankcard.Dmj) });
              label379:
              localObject2 = null;
              if (!localBankcard.eIC()) {
                break label688;
              }
              localObject2 = com.tencent.mm.svg.a.a.g(WalletOfflineCoinPurseUI.this.getResources(), 2131690298);
              if (localObject2 == null) {
                WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).put(localObject3, Integer.valueOf(i));
              }
              ae.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str, localObject1 });
              if (!localBankcard.eID()) {
                break label754;
              }
              localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(WalletOfflineCoinPurseUI.this.getContext(), str);
              if (bu.isNullOrNil((String)localObject4))
              {
                if (!bu.isNullOrNil(localBankcard.DmI)) {
                  break label738;
                }
                localObject1 = "";
              }
              label499:
              if (bu.isNullOrNil((String)localObject4)) {
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
                  if ((localBankcard.eID()) && (bu.isNullOrNil(paramAnonymous2View)))
                  {
                    ae.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand");
                    paramAnonymous2View = new vq();
                    paramAnonymous2View.dKT.userName = localBankcard.CRv;
                    paramAnonymous2View.dKT.dKV = localBankcard.CRw;
                    paramAnonymous2View.dKT.scene = 1137;
                    paramAnonymous2View.dKT.dKW = 0;
                    com.tencent.mm.sdk.b.a.IvT.l(paramAnonymous2View);
                    ae.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand result:%s", new Object[] { Boolean.valueOf(paramAnonymous2View.dKU.dLn) });
                    if (paramAnonymous2View.dKU.dLn)
                    {
                      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 1);
                      WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).bqD();
                      AppMethodBeat.o(184859);
                      return;
                    }
                    WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 0);
                    AppMethodBeat.o(184859);
                    return;
                  }
                  Intent localIntent = new Intent();
                  ae.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", new Object[] { paramAnonymous2View });
                  localIntent.putExtra("rawUrl", paramAnonymous2View);
                  localIntent.putExtra("geta8key_username", v.aAC());
                  localIntent.putExtra("pay_channel", 1);
                  com.tencent.mm.wallet_core.ui.f.an(WalletOfflineCoinPurseUI.this.getContext(), localIntent);
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
              localObject2 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.h.a(localBitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), true, false));
              break label404;
              localObject1 = localBankcard.DmI;
              break label499;
            }
            label754:
            localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(WalletOfflineCoinPurseUI.this.getContext(), str);
            if (!bu.isNullOrNil((String)localObject4)) {}
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
      this.mIQ.LfT = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(184861);
          if (WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).bqD();
            paramAnonymousMenuItem = (Bankcard)localArrayList.get(paramAnonymousInt);
            com.tencent.mm.plugin.report.service.g.yxI.f(14515, new Object[] { Integer.valueOf(3) });
            if ((!bu.isNullOrNil(paramAnonymousMenuItem.field_forbid_title)) || (!bu.isNullOrNil(paramAnonymousMenuItem.field_forbidWord)) || (!paramAnonymousMenuItem.field_support_micropay)) {
              com.tencent.mm.plugin.report.service.g.yxI.f(14515, new Object[] { Integer.valueOf(4) });
            }
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, paramAnonymousMenuItem);
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.eID()))
            {
              WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this);
              WalletOfflineCoinPurseUI.MR(3);
            }
          }
          AppMethodBeat.o(184861);
        }
      };
      localObject = View.inflate(this, 2131495985, null);
      this.mIQ.xFq = true;
      this.mIQ.iNL = j;
      this.mIQ.Ltv = true;
      this.mIQ.P((View)localObject, false);
      this.mIQ.cPF();
      com.tencent.mm.plugin.report.service.g.yxI.f(13955, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(66508);
      return;
    }
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(66487);
    int i;
    if (this.wQc.size() >= 2)
    {
      i = this.wQc.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.f.U((Bitmap)this.wQc.remove(i));
        i -= 1;
      }
    }
    if (this.wQd.size() >= 2)
    {
      i = this.wQd.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.f.U((Bitmap)this.wQd.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(66487);
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(189950);
    ae.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
    MP(1);
    ps(true);
    com.tencent.mm.wallet_core.ui.f.aha(40);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 21L, 1L, true);
    if (this.wQe.jwx.isShowing())
    {
      if (this.wQe.oLY)
      {
        this.wQe.fWt();
        AppMethodBeat.o(189950);
        return;
      }
      this.wQe.dismiss();
    }
    dAk();
    AppMethodBeat.o(189950);
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(66491);
    if (paramc == null)
    {
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
      AppMethodBeat.o(66491);
      return false;
    }
    dAg();
    this.wQe.dismiss();
    ae.i("MicroMsg.WalletOfflineCoinPurseUI", "msgtype=" + paramc.wOB);
    int i;
    if (4 == paramc.wOB)
    {
      this.wPU = false;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = this.wQf;
      if (paramc == null) {
        ae.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
      }
      for (;;)
      {
        if ((this.wPX) && (!this.wPY))
        {
          this.wPX = false;
          this.wPU = false;
        }
        if (i != 0)
        {
          MP(0);
          ps(true);
        }
        AppMethodBeat.o(66491);
        return true;
        if (5 == paramc.wOB)
        {
          this.wPU = true;
          this.wPX = true;
          this.wPY = false;
          if (this.wQA.foU()) {
            break label420;
          }
          this.wQA.stopTimer();
          i = 0;
          break;
        }
        if (6 == paramc.wOB)
        {
          if (!this.wQA.foU()) {
            this.wQA.stopTimer();
          }
          if (!this.wNh.foU()) {
            this.wNh.stopTimer();
          }
          this.wPU = false;
          if (!com.tencent.mm.plugin.offline.c.a.dAz()) {
            break label1585;
          }
          i = 0;
          break;
        }
        if (8 == paramc.wOB)
        {
          if (this.wQA.foU()) {
            break label1585;
          }
          this.wQA.stopTimer();
          i = 1;
          break;
        }
        if (23 == paramc.wOB)
        {
          if (this.wQA.foU()) {
            break label420;
          }
          this.wQA.stopTimer();
          i = 0;
          break;
        }
        if (20 == paramc.wOB)
        {
          this.wPU = false;
          if (this.wQA.foU()) {
            break label420;
          }
          this.wQA.stopTimer();
          i = 0;
          break;
        }
        if (24 != paramc.wOB) {
          break label1585;
        }
        if (com.tencent.mm.plugin.offline.c.a.dAZ())
        {
          this.wPU = true;
          if (com.tencent.mm.plugin.offline.c.a.dAZ())
          {
            if (this.mTipDialog != null) {
              break label425;
            }
            this.mTipDialog = com.tencent.mm.wallet_core.ui.h.a(getContext(), false, new WalletOfflineCoinPurseUI.15(this));
          }
        }
        for (;;)
        {
          localObject1 = this.wQA;
          long l = com.tencent.mm.plugin.offline.g.dzA();
          ((aw)localObject1).ay(l, l);
          label420:
          i = 0;
          break;
          label425:
          if (!this.mTipDialog.isShowing()) {
            this.mTipDialog.show();
          }
        }
        ae.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + paramc.wOB);
        if (paramc.wOB == 24) {
          ((c)localObject1).nQa.vibrate(50L);
        }
        if (4 == paramc.wOB)
        {
          ((c)localObject1).a((s.b)paramc);
          com.tencent.mm.plugin.offline.g.dzB();
        }
        else
        {
          if (5 == paramc.wOB)
          {
            paramc = (s.e)paramc;
            if (paramc != null)
            {
              ae.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + paramc.wOE + " msg.wxRetMsg:" + paramc.wOF + " msg.cftRetCode:" + paramc.wOE + " msg.cftRetMsg:" + paramc.wOD);
              if ((!TextUtils.isEmpty(paramc.wOE)) || (!TextUtils.isEmpty(paramc.wOF)) || (!TextUtils.isEmpty(paramc.wOC)) || (!TextUtils.isEmpty(paramc.wOD)))
              {
                if ((!TextUtils.isEmpty(paramc.wOE)) || (!TextUtils.isEmpty(paramc.wOF)) || (TextUtils.isEmpty(paramc.wOC)) || (TextUtils.isEmpty(paramc.wOD))) {
                  break label706;
                }
                b.e(((c)localObject1).mActivity, paramc.wOD);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.offline.g.dzB();
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 0L, 1L, true);
              break;
              label706:
              if ((!TextUtils.isEmpty(paramc.wOE)) && (com.tencent.mm.plugin.offline.c.a.isNumeric(paramc.wOE))) {
                ((c)localObject1).a(null, bu.getInt(paramc.wOE, 0), paramc.wOF, paramc.wOG);
              } else {
                b.e(((c)localObject1).mActivity, paramc.wOF);
              }
            }
          }
          Object localObject2;
          if (6 == paramc.wOB)
          {
            paramc = (s.f)paramc;
            int j;
            if (paramc != null)
            {
              ae.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + paramc.wOI);
              com.tencent.mm.plugin.offline.k.dzG();
              localObject2 = com.tencent.mm.plugin.offline.k.dzK().auS(paramc.wOJ.dmw);
              if (localObject2 == null) {
                break label944;
              }
              if (((com.tencent.mm.plugin.offline.a.r)localObject2).field_status != com.tencent.mm.plugin.offline.g.wMN) {
                break label939;
              }
              j = 1;
            }
            for (;;)
            {
              if (j == 0)
              {
                com.tencent.mm.plugin.offline.g.eI(paramc.wOJ.dmw, com.tencent.mm.plugin.offline.g.wMN);
                com.tencent.mm.plugin.offline.c.a.a(((c)localObject1).mActivity, paramc);
                ((c)localObject1).mActivity.setResult(-1);
                ((c)localObject1).mActivity.finish();
              }
              com.tencent.mm.plugin.offline.g.dzB();
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 7L, 1L, true);
              if (com.tencent.mm.plugin.offline.c.a.wRk != 4) {
                break;
              }
              ae.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
              com.tencent.mm.plugin.report.service.g.yxI.f(13412, new Object[0]);
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
          if (8 == paramc.wOB)
          {
            paramc = (s.g)paramc;
            ae.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + paramc.id);
            if (paramc.pqv == 0)
            {
              localObject2 = ((c)localObject1).mActivity.getLayoutInflater().inflate(2131495993, null);
              localObject3 = (TextView)((View)localObject2).findViewById(2131303150);
              localObject4 = (TextView)((View)localObject2).findViewById(2131303153);
              ((TextView)localObject3).setText(paramc.wOL);
              ((TextView)localObject4).setText(paramc.wOK);
              com.tencent.mm.plugin.offline.g.eI(paramc.dwj, com.tencent.mm.plugin.offline.g.wMP);
              com.tencent.mm.ui.base.h.a(((c)localObject1).mActivity, "", (View)localObject2, ((c)localObject1).getString(2131765972), ((c)localObject1).getString(2131755691), new c.11((c)localObject1, paramc), new c.12((c)localObject1, paramc));
            }
            else if (paramc.pqv == 1)
            {
              if (((c)localObject1).wPc != null) {
                ((c)localObject1).wPc.show();
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(13955, new Object[] { Integer.valueOf(1) });
              ae.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + paramc.id);
              com.tencent.mm.plugin.offline.g.eI(paramc.dwj, com.tencent.mm.plugin.offline.g.wMP);
              ((c)localObject1).wPc = com.tencent.mm.plugin.wallet_core.ui.s.a(((c)localObject1).mActivity, paramc.wOK, paramc.wOL, new c.13((c)localObject1, paramc), new c.14((c)localObject1), new c.15((c)localObject1, paramc));
              ((c)localObject1).wPc.yGw.setVisibility(0);
              ((c)localObject1).wPc.ytR.setVisibility(8);
            }
          }
          else
          {
            if (23 == paramc.wOB)
            {
              paramc = (s.d)paramc;
              localObject2 = new PayInfo();
              ((PayInfo)localObject2).dmw = paramc.dwj;
              ((PayInfo)localObject2).dDH = 8;
              ((PayInfo)localObject2).FEv = 1;
              ((PayInfo)localObject2).hwN = new Bundle();
              ((PayInfo)localObject2).hwN.putLong("extinfo_key_9", System.currentTimeMillis());
              com.tencent.mm.wallet_core.b.fVf();
              boolean bool1;
              label1386:
              String str;
              if ((com.tencent.mm.wallet_core.b.b(b.a.qDk, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_OFFLINE_PAY_SWTICH_KEY")))
              {
                bool1 = true;
                boolean bool2 = bool1;
                if (bool1)
                {
                  com.tencent.mm.wallet_core.b.fVf();
                  bool2 = com.tencent.mm.wallet_core.b.b(b.a.qGK, false);
                }
                if (!bool2) {
                  break label1490;
                }
                localObject3 = (com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class);
                localObject4 = ((c)localObject1).mActivity;
                str = ((PayInfo)localObject2).dmw;
                if (((c)localObject1).wPb != null) {
                  break label1476;
                }
              }
              label1476:
              for (paramc = "";; paramc = ((c)localObject1).wPb.dzR())
              {
                ((com.tencent.mm.pluginsdk.wallet.a)localObject3).startOfflinePay((Context)localObject4, str, paramc, ((PayInfo)localObject2).channel);
                break;
                bool1 = false;
                break label1386;
              }
              label1490:
              paramc = new c.1((c)localObject1, (PayInfo)localObject2);
              com.tencent.mm.sdk.b.a.IvT.b(paramc);
              localObject3 = ((c)localObject1).mActivity;
              if (((c)localObject1).wPb == null) {}
              for (paramc = "";; paramc = ((c)localObject1).wPb.dzR())
              {
                com.tencent.mm.pluginsdk.wallet.f.a((Context)localObject3, false, "", paramc, (PayInfo)localObject2, "", new Intent(), 1);
                break;
              }
            }
            if (20 == paramc.wOB) {
              com.tencent.mm.plugin.offline.g.dzB();
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
    if (((paramDialog instanceof com.tencent.mm.ui.widget.a.d)) && (this.wPX))
    {
      this.wPY = true;
      paramDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(184850);
          if (this.wQI != null) {
            this.wQI.onDismiss(paramAnonymousDialogInterface);
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
  
  public final void bVw()
  {
    AppMethodBeat.i(66512);
    MP(0);
    ps(true);
    AppMethodBeat.o(66512);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public final void dAh()
  {
    int j = 0;
    AppMethodBeat.i(66498);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.dAA();
    findViewById(2131306839).setVisibility(0);
    this.wPC.setTextSize(0, getResources().getDimensionPixelSize(2131165517));
    String str;
    Object localObject;
    if ((this.wPC != null) && (localBankcard != null)) {
      if (localBankcard.eID())
      {
        str = localBankcard.DmG;
        localObject = t.eJf().eKc();
        if ((localObject == null) || (bu.isNullOrNil(localBankcard.field_forbidWord))) {
          break label347;
        }
        Iterator localIterator = ((List)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (com.tencent.mm.plugin.wallet_core.model.c)localIterator.next();
        } while (!((com.tencent.mm.plugin.wallet_core.model.c)localObject).wRt.equals(localBankcard.field_bindSerial));
      }
    }
    for (;;)
    {
      if ((localObject != null) && (!bu.isNullOrNil(((com.tencent.mm.plugin.wallet_core.model.c)localObject).DlU)))
      {
        if (!localBankcard.eID()) {
          str = localBankcard.field_desc + ((com.tencent.mm.plugin.wallet_core.model.c)localObject).DlU;
        }
        findViewById(2131306839).setVisibility(8);
        com.tencent.mm.plugin.report.service.g.yxI.f(14515, new Object[] { Integer.valueOf(2) });
        this.wPC.setTextSize(0, getResources().getDimensionPixelSize(2131165466));
      }
      for (int i = 1;; i = 0)
      {
        this.wPC.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), str, this.wPC.getTextSize()));
        for (;;)
        {
          if (localBankcard != null) {
            a(localBankcard);
          }
          if (i != 0) {
            this.wPD.setImageResource(2131690126);
          }
          AppMethodBeat.o(66498);
          return;
          str = getString(2131765945, new Object[] { localBankcard.field_desc });
          break;
          i = j;
          if (localBankcard == null)
          {
            ae.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
            i = j;
          }
        }
      }
      label347:
      localObject = null;
    }
  }
  
  public final void dAo()
  {
    AppMethodBeat.i(66505);
    this.wPE.setVisibility(4);
    this.wQg.a(this.wPw, new WalletOfflineCoinPurseUI.24(this));
    AppMethodBeat.o(66505);
  }
  
  public final void dzP()
  {
    AppMethodBeat.i(66514);
    pt(false);
    AppMethodBeat.o(66514);
  }
  
  public final void dzQ()
  {
    AppMethodBeat.i(66515);
    doSceneProgress(new j(""), false);
    AppMethodBeat.o(66515);
  }
  
  public final String dzR()
  {
    return this.wMz;
  }
  
  public final void dzS()
  {
    AppMethodBeat.i(66518);
    if (!this.wNh.foU()) {
      this.wNh.stopTimer();
    }
    MP(0);
    ps(true);
    this.wPU = false;
    aw localaw = this.wNh;
    long l = this.wNg;
    localaw.ay(l, l);
    AppMethodBeat.o(66518);
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66513);
    doSceneProgress(new com.tencent.mm.plugin.offline.a.e(paramInt, paramString1, paramString2, paramString3), com.tencent.mm.plugin.offline.c.a.dAz());
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
    this.wQg = ((OfflineAlertView)findViewById(2131302989));
    this.wQg.dismiss();
    this.wQg.setDialogState(new OfflineAlertView.a()
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
    com.tencent.mm.wallet_core.c.b.fVM().init(getApplicationContext());
    Object localObject;
    if ((this.mEntryScene == 3) || (this.mEntryScene == 10) || (this.mEntryScene == 11) || (this.mEntryScene == 12))
    {
      setMMTitle(2131765959);
      this.wQf = new c(this, this);
      localObject = this.wQf;
      ((c)localObject).nQa = ((Vibrator)((c)localObject).mActivity.getSystemService("vibrator"));
      this.wQe = new com.tencent.mm.wallet_core.ui.c(this, true);
      this.wQe.fWr();
      this.wPw = findViewById(2131306828);
      this.wPx = ((ImageView)findViewById(2131306827));
      this.wPy = ((ImageView)findViewById(2131306693));
      this.wPz = ((TextView)findViewById(2131306694));
      this.wPB = findViewById(2131306838);
      this.wPC = ((TextView)findViewById(2131306840));
      this.wPD = ((ImageView)findViewById(2131306837));
      this.wPE = ((RelativeLayout)findViewById(2131306763));
      this.wPF = ((LinearLayout)findViewById(2131306843));
      this.wPG = ((CdnImageView)findViewById(2131306844));
      this.wPH = ((TextView)findViewById(2131306842));
      this.wPI = ((TextView)findViewById(2131306841));
      this.wPE.setOnClickListener(new WalletOfflineCoinPurseUI.8(this));
      this.wPx.setOnClickListener(this.jwB);
      this.wPy.setOnClickListener(this.jwB);
      this.wPz.setOnClickListener(this.jwB);
      this.wPB.setClickable(true);
      this.wPB.setOnClickListener(new WalletOfflineCoinPurseUI.9(this));
      this.mLastTime = System.currentTimeMillis();
      this.wPJ = new e();
      this.wPJ.dnE();
      com.tencent.mm.plugin.newtips.a.dxD().h(this.wPJ);
      this.wPK = new g();
      this.wPK.dnE();
      com.tencent.mm.plugin.newtips.a.dxD().h(this.wPK);
      this.wPL = new b();
      this.wPL.dnE();
      com.tencent.mm.plugin.newtips.a.dxD().h(this.wPL);
      this.wPM = new f();
      this.wPM.dnE();
      com.tencent.mm.plugin.newtips.a.dxD().h(this.wPM);
      this.wPN = new d();
      this.wPN.dnE();
      com.tencent.mm.plugin.newtips.a.dxD().h(this.wPN);
      if ((this.mEntryScene != 3) && (this.mEntryScene != 10) && (this.mEntryScene != 11) && (this.mEntryScene != 12)) {
        break label901;
      }
      this.wPO.setVisibility(8);
      this.wPP.setVisibility(8);
      this.wPQ.setVisibility(8);
      this.wPR.setVisibility(8);
      label613:
      if ((com.tencent.mm.plugin.offline.c.a.dAy()) && (c.dzU()))
      {
        localObject = this.wQf;
        com.tencent.mm.plugin.offline.k.dzG();
        ((c)localObject).a(com.tencent.mm.plugin.offline.k.dzH().wOu);
      }
      dAa();
      X(true, false);
      localObject = this.wNh;
      long l1 = this.wNg;
      ((aw)localObject).ay(l1, l1);
      if ((com.tencent.mm.plugin.offline.c.a.wRk != 3) || (!com.tencent.mm.plugin.offline.c.a.wRn)) {
        break label1134;
      }
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
      int i = com.tencent.mm.plugin.offline.c.a.wRl;
      l1 = com.tencent.mm.plugin.offline.c.a.wRm;
      long l2 = System.currentTimeMillis();
      long l3 = i * 1000 + l1 - l2;
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + l1 + " now:" + l2 + " interval:" + l3);
      if ((com.tencent.mm.plugin.offline.c.a.wRl <= 0) || (com.tencent.mm.plugin.offline.c.a.wRm <= 0L) || (l3 <= 0L)) {
        break label1122;
      }
      if (!this.wQB.foU()) {
        this.wQB.stopTimer();
      }
      this.wQB.ay(l3, l3);
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
    }
    for (;;)
    {
      dzZ();
      localObject = new yo();
      ((yo)localObject).dNR.scene = "5";
      ((yo)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66407);
          if (!bu.isNullOrNil(this.pmv.dNS.dNT))
          {
            com.tencent.mm.wallet_core.ui.f.a((TextView)WalletOfflineCoinPurseUI.this.findViewById(2131297186), this.pmv.dNS.dNT, this.pmv.dNS.content, this.pmv.dNS.url);
            AppMethodBeat.o(66407);
            return;
          }
          ae.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
          AppMethodBeat.o(66407);
        }
      };
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(66477);
      return;
      setMMTitle(2131765960);
      break;
      label901:
      this.wPR.setVisibility(0);
      this.wPS.setVisibility(0);
      final boolean bool1 = com.tencent.mm.plugin.newtips.a.g.b(this.wPJ);
      final boolean bool2 = com.tencent.mm.plugin.newtips.a.g.b(this.wPL);
      final boolean bool3 = com.tencent.mm.plugin.newtips.a.g.b(this.wPM);
      final boolean bool4 = com.tencent.mm.plugin.newtips.a.g.b(this.wPK);
      final boolean bool5 = com.tencent.mm.plugin.newtips.a.g.b(this.wPN);
      if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWm, Boolean.FALSE)).booleanValue()) {
        ae.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
      }
      ImageView localImageView;
      for (;;)
      {
        localObject = (TextView)findViewById(2131297128);
        localImageView = (ImageView)findViewById(2131297127);
        if (!this.wQk) {
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
            int i = al.ck(WalletOfflineCoinPurseUI.this.getContext()).y;
            int j = i;
            if (al.jY(WalletOfflineCoinPurseUI.this.getContext()))
            {
              ae.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
              j = i - al.en(WalletOfflineCoinPurseUI.this.getContext());
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
              ae.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
              i -= j;
              if (i > 0) {
                localScrollView.scrollBy(0, i);
              }
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWm, Boolean.TRUE);
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
      ae.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
      continue;
      label1134:
      if (com.tencent.mm.plugin.offline.c.a.wRk == 3) {
        ae.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
      } else {
        ae.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.c.a.wRk) });
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
    final ImageView localImageView = (ImageView)this.wPl.get(paramString);
    paramString = (Integer)this.wPm.get(paramString);
    if ((localImageView == null) || (paramString == null))
    {
      AppMethodBeat.o(66496);
      return;
    }
    new aq(getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184852);
        int i = paramString.intValue();
        Bitmap localBitmap = com.tencent.mm.sdk.platformtools.h.a(paramBitmap, i, i, true, false);
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
    t.eIZ();
    this.wQk = t.eJo();
    com.tencent.mm.plugin.offline.k.wNr = true;
    com.tencent.mm.wallet_core.ui.f.aha(41);
    paramBundle = getIntent();
    this.wPW = paramBundle.getBooleanExtra("is_offline_create", false);
    if ((paramBundle != null) && (paramBundle.hasExtra("key_entry_scene"))) {
      this.mEntryScene = paramBundle.getIntExtra("key_entry_scene", this.mEntryScene);
    }
    this.fRv = paramBundle.getIntExtra("key_from_scene", 0);
    this.wPA = bu.bI(paramBundle.getStringExtra("key_business_attach"), "");
    this.roH = 1;
    if (this.mEntryScene == 2) {
      this.roH = 1;
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
          paramAnonymousMenuItem = new ia();
          paramAnonymousMenuItem.dvC.dvD = "ok";
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
          if (WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this) == 8) {
            com.tencent.mm.plugin.offline.c.a.avj(WalletOfflineCoinPurseUI.this.getIntent().getStringExtra("key_appid"));
          }
          WalletOfflineCoinPurseUI.this.finish();
          AppMethodBeat.o(184867);
          return false;
        }
      });
      try
      {
        bi.a(this, this);
        i = 1;
        if (i == 0) {
          bi.a(this, null);
        }
        com.tencent.mm.wallet_core.ui.f.fWw();
        if (t.eJf().eJM())
        {
          ae.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
          initView();
          paramBundle = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.IXp, "");
          if (bu.isNullOrNil(paramBundle)) {}
        }
      }
      catch (Exception paramBundle)
      {
        try
        {
          label628:
          do
          {
            for (;;)
            {
              this.wQp = com.tencent.mm.plugin.wallet_core.model.r.bj(new JSONObject(paramBundle));
              u.a(this);
              com.tencent.mm.plugin.offline.k.dzG();
              com.tencent.mm.plugin.offline.k.dzH().a(this);
              addSceneEndListener(606);
              addSceneEndListener(609);
              addSceneEndListener(1501);
              com.tencent.mm.plugin.offline.k.dzG();
              com.tencent.mm.plugin.offline.k.dzI().dD(this);
              com.tencent.mm.sdk.b.a.IvT.c(this.wQy);
              com.tencent.mm.plugin.offline.c.a.dAL();
              com.tencent.mm.sdk.b.a.IvT.b(this.wQw);
              com.tencent.mm.sdk.b.a.IvT.b(this.wQu);
              com.tencent.mm.sdk.b.a.IvT.b(this.wQq);
              this.wQr.alive();
              this.wQs.alive();
              this.wQt.alive();
              this.wPV = new com.tencent.mm.plugin.offline.g();
              paramBundle = new nn();
              paramBundle.dCE.aHQ = hashCode();
              com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
              this.wQv.alive();
              AppMethodBeat.o(66469);
              return;
              if (this.mEntryScene == 1)
              {
                this.roH = 2;
                break;
              }
              if (this.mEntryScene == 8)
              {
                this.roH = 4;
                break;
              }
              if (this.mEntryScene == 4)
              {
                this.roH = 6;
                break;
              }
              ae.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[] { Integer.valueOf(this.roH) });
              break;
              paramBundle = paramBundle;
              ae.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", paramBundle, "", new Object[0]);
              getWindow().setFlags(8192, 8192);
              int i = 0;
              continue;
              if (!t.eJf().eJJ()) {
                break label628;
              }
              ae.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
              com.tencent.mm.plugin.offline.c.a.dAK();
              com.tencent.mm.plugin.offline.k.dzG();
              com.tencent.mm.plugin.offline.k.bz(196648, "0");
            }
          } while ((!t.eJf().eJH()) || (!com.tencent.mm.plugin.offline.c.a.dAy()));
          dAs();
        }
        catch (JSONException paramBundle)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", paramBundle, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66475);
    Object localObject = com.tencent.mm.plugin.offline.c.a.dAA();
    if (localObject != null)
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerial:%s serial:%s mLastBindSerial:%s", new Object[] { this.wMz, ((Bankcard)localObject).field_bindSerial, this.wPv });
      if (((Bankcard)localObject).eID())
      {
        localObject = this.wPv;
        bu.isNullOrNil(this.wPv);
        com.tencent.mm.plugin.offline.c.a.auY((String)localObject);
        com.tencent.mm.plugin.offline.k.dzG();
        com.tencent.mm.plugin.offline.k.dzI().wMz = ((String)localObject);
      }
    }
    this.wQg.dismiss();
    com.tencent.mm.plugin.offline.k.wNr = false;
    com.tencent.mm.wallet_core.ui.f.U(this.wPn);
    com.tencent.mm.wallet_core.ui.f.U(this.wPo);
    com.tencent.mm.wallet_core.ui.f.ba(this.wQc);
    com.tencent.mm.wallet_core.ui.f.ba(this.wQd);
    this.wQc.clear();
    this.wQd.clear();
    this.wPs.clear();
    this.wPt.clear();
    this.wPu.clear();
    u.c(this);
    com.tencent.mm.plugin.offline.k.dzG();
    com.tencent.mm.plugin.offline.k.dzH().b(this);
    removeSceneEndListener(606);
    removeSceneEndListener(609);
    removeSceneEndListener(1501);
    com.tencent.mm.plugin.offline.k.dzG();
    com.tencent.mm.plugin.offline.k.dzI().dE(this);
    com.tencent.mm.sdk.b.a.IvT.d(this.wQy);
    com.tencent.mm.sdk.b.a.IvT.d(this.wQw);
    com.tencent.mm.sdk.b.a.IvT.d(this.wQq);
    if (!this.wNh.foU()) {
      this.wNh.stopTimer();
    }
    if (!this.wQB.foU()) {
      this.wQB.stopTimer();
    }
    if (this.wQe != null) {
      this.wQe.release();
    }
    if (this.wQf != null)
    {
      localObject = this.wQf;
      ((c)localObject).nQa.cancel();
      ((c)localObject).mActivity = null;
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.wQu);
    this.wQs.dead();
    this.wQt.dead();
    localObject = this.wPV;
    ((com.tencent.mm.plugin.offline.g)localObject).stop();
    com.tencent.mm.plugin.offline.g.dzB();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(385, ((com.tencent.mm.plugin.offline.g)localObject).wMR);
    ((com.tencent.mm.plugin.offline.g)localObject).wMT = null;
    this.wQv.dead();
    this.wQr.dead();
    com.tencent.mm.plugin.remittance.mobile.a.b.OE(0);
    super.onDestroy();
    AppMethodBeat.o(66475);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66517);
    if ((paramInt == 4) && (this.wQg != null) && (this.wQg.getVisibility() == 0) && (this.wQg.wOO))
    {
      this.wQg.dismiss();
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
    ae.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
    this.wPq = true;
    AppMethodBeat.o(66473);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66474);
    com.tencent.mm.plugin.offline.k.dzG();
    com.tencent.mm.plugin.offline.i locali = com.tencent.mm.plugin.offline.k.dzJ();
    locali.mHandler.removeCallbacks(locali.wNf);
    bi.a(this, null);
    this.cFc = false;
    com.tencent.mm.sdk.b.a.IvT.d(this.wQx);
    this.wPV.stop();
    super.onPause();
    AppMethodBeat.o(66474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66471);
    super.onResume();
    com.tencent.mm.sdk.b.a.IvT.c(this.wQx);
    try
    {
      bi.a(this, this);
      if (!this.wQh)
      {
        dzW();
        this.wQh = true;
      }
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
      this.cFc = true;
      Object localObject = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).a(this, ((com.tencent.mm.plugin.walletlock.a.b)localObject).eMV(), null);
      if (az.isNetworkConnected(getBaseContext()))
      {
        if (t.eJf().eJM()) {
          doSceneForceProgress(new ad(null, 8));
        }
        if ((com.tencent.mm.plugin.offline.c.a.dAy()) && (this.wQo))
        {
          com.tencent.mm.plugin.offline.k.dzG();
          com.tencent.mm.plugin.offline.k.dzJ().pr(false);
          if (!c.dzU()) {
            doSceneProgress(new com.tencent.mm.plugin.offline.a.q(this.mEntryScene, this.duP, this.wQl), false);
          }
        }
      }
      if (!this.wQo) {
        this.wQo = true;
      }
      dAa();
      localObject = com.tencent.mm.plugin.offline.c.a.dAA();
      if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (!((Bankcard)localObject).field_bindSerial.equals(this.wMz)))
      {
        this.wMz = ((Bankcard)localObject).field_bindSerial;
        com.tencent.mm.plugin.offline.k.dzG();
        com.tencent.mm.plugin.offline.k.dzI().wMz = this.wMz;
        i = 1;
        if ((i != 0) || ((this.wPr) && (this.wPq)))
        {
          ae.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
          this.wPr = false;
          this.wPq = false;
          dAh();
          MP(0);
          ps(true);
        }
        localObject = this.wPV;
        if (!com.tencent.mm.plugin.offline.c.a.dAZ()) {
          break label511;
        }
        ae.i(com.tencent.mm.plugin.offline.g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + ((com.tencent.mm.plugin.offline.g)localObject).wMT.foU());
        if ((((com.tencent.mm.plugin.offline.g)localObject).wMT == null) || (((com.tencent.mm.plugin.offline.g)localObject).wMT.foU()))
        {
          ((com.tencent.mm.plugin.offline.g)localObject).status = 1;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 61L, 1L, true);
          if (!((com.tencent.mm.plugin.offline.g)localObject).wMS) {
            break label485;
          }
          com.tencent.mm.plugin.offline.g.dzB();
          localObject = ((com.tencent.mm.plugin.offline.g)localObject).wMT;
          l = com.tencent.mm.plugin.offline.g.wMC;
          ((aw)localObject).ay(l, l);
          i = com.tencent.mm.plugin.offline.g.wMC;
        }
        if (this.wQm)
        {
          this.wQm = false;
          com.tencent.mm.plugin.report.service.g.yxI.f(18930, new Object[] { Integer.valueOf(this.wQn), Integer.valueOf(4) });
        }
        AppMethodBeat.o(66471);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", localException, "", new Object[0]);
        continue;
        int i = 0;
        continue;
        label485:
        aw localaw = localException.wMT;
        long l = com.tencent.mm.plugin.offline.g.wMQ;
        localaw.ay(l, l);
        i = com.tencent.mm.plugin.offline.g.wMQ;
        continue;
        label511:
        ae.i(com.tencent.mm.plugin.offline.g.TAG, "OfflineGetMsg is not in abtest");
      }
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(66476);
    ae.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " scene: " + paramn);
    if (((paramn instanceof com.tencent.mm.plugin.offline.a.f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      ae.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.wNe.dzL();
      this.wNe = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof ad))
      {
        if (this.wQi)
        {
          this.wQi = false;
          paramString = com.tencent.mm.plugin.offline.c.a.dAB();
          if (paramString != null) {
            doSceneForceProgress(new com.tencent.mm.plugin.offline.a.k(paramString, this.wQj, 0));
          }
          AppMethodBeat.o(66476);
          return true;
        }
        if (com.tencent.mm.plugin.offline.c.a.dAy())
        {
          if (com.tencent.mm.plugin.offline.c.a.dAB() != null) {
            doSceneProgress(new com.tencent.mm.plugin.offline.a.n(System.currentTimeMillis(), this.mEntryScene), false);
          }
          dAs();
        }
        paramString = ((ad)paramn).DgW;
        if ((paramString == null) || (paramString.Dpd == 0))
        {
          if (this.wQg.wON == 7) {
            this.wQg.dismiss();
          }
          this.wQp = ((ad)paramn).DgX;
          dAp();
          dAr();
          label288:
          if ((!(paramn instanceof ad)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.n)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.a)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.e))) {
            break label1457;
          }
          dAa();
          X(false, true);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66476);
      return true;
      if (!this.wQg.MO(7)) {
        break;
      }
      if (this.wQg.wON == 7) {
        this.wQg.dismiss();
      }
      this.wQn = paramString.Dpc;
      Object localObject1 = this.wQg;
      View localView = this.wPw;
      Object localObject2 = new WalletOfflineCoinPurseUI.25(this);
      com.tencent.mm.plugin.report.service.g.yxI.f(18930, new Object[] { Integer.valueOf(paramString.Dpc), Integer.valueOf(1) });
      ((OfflineAlertView)localObject1).wON = 7;
      ((OfflineAlertView)localObject1).setVisibility(0);
      ((OfflineAlertView)localObject1).wOO = false;
      ((OfflineAlertView)localObject1).iOJ.removeAllViews();
      Object localObject3 = LayoutInflater.from(((OfflineAlertView)localObject1).getContext()).inflate(2131495990, ((OfflineAlertView)localObject1).iOJ, false);
      ((OfflineAlertView)localObject1).iOJ.addView((View)localObject3);
      Object localObject4 = (TextView)((View)localObject3).findViewById(2131302001);
      TextView localTextView = (TextView)((View)localObject3).findViewById(2131305510);
      localObject3 = (Button)((View)localObject3).findViewById(2131300871);
      if (!bu.isNullOrNil(paramString.Dpf)) {
        ((TextView)localObject4).setText(paramString.Dpf);
      }
      if (!bu.isNullOrNil(paramString.Dpg))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("repayment_tiny_app_username", paramString.Dph);
        ((Bundle)localObject4).putString("repayment_tiny_app_path", paramString.Dpi);
        localTextView.setText(paramString.Dpg);
        com.tencent.mm.pluginsdk.ui.span.k.a(localTextView, false, localObject4);
        if (((OfflineAlertView)localObject1).ohO != null) {
          com.tencent.mm.pluginsdk.ui.span.k.b(((OfflineAlertView)localObject1).ohO);
        }
        ((OfflineAlertView)localObject1).ohO = new OfflineAlertView.3((OfflineAlertView)localObject1, (View.OnClickListener)localObject2, paramString);
        com.tencent.mm.pluginsdk.ui.span.k.a(((OfflineAlertView)localObject1).ohO);
      }
      if (paramString.Dpe > 0)
      {
        ((Button)localObject3).setEnabled(false);
        if (((OfflineAlertView)localObject1).wOQ == null) {
          break label721;
        }
        ((OfflineAlertView)localObject1).wOQ.cancel();
      }
      for (;;)
      {
        ((OfflineAlertView)localObject1).wOQ.start();
        ((Button)localObject3).setOnClickListener(new OfflineAlertView.5((OfflineAlertView)localObject1, paramString));
        localView.post(new OfflineAlertView.6((OfflineAlertView)localObject1, localView));
        break;
        label721:
        localObject2 = new com.tencent.mm.wallet_core.c.c();
        ((com.tencent.mm.wallet_core.c.c)localObject2).duration = (paramString.Dpe * 1000);
        ((com.tencent.mm.wallet_core.c.c)localObject2).interval = 1000L;
        ((com.tencent.mm.wallet_core.c.c)localObject2).LUz = new OfflineAlertView.4((OfflineAlertView)localObject1, (Button)localObject3);
        ((OfflineAlertView)localObject1).wOQ = new com.tencent.mm.wallet_core.c.c.1((com.tencent.mm.wallet_core.c.c)localObject2, ((com.tencent.mm.wallet_core.c.c)localObject2).duration, ((com.tencent.mm.wallet_core.c.c)localObject2).interval);
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.m))
      {
        this.wNe = ((com.tencent.mm.plugin.offline.a.m)paramn);
        paramString = this.wNe.wOi;
        com.tencent.mm.plugin.offline.k.dzG();
        paramString = new com.tencent.mm.plugin.offline.a.f(paramString, com.tencent.mm.plugin.offline.k.MN(196617));
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
        break label288;
      }
      if ((paramn instanceof j))
      {
        dAa();
        dzW();
        break label288;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.n))
      {
        paramString = (com.tencent.mm.plugin.offline.a.n)paramn;
        if ("1".equals(paramString.wOn))
        {
          ae.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
          if (bu.isNullOrNil(paramString.wOo)) {}
          for (paramString = getString(2131765224);; paramString = paramString.wOo)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", false, new WalletOfflineCoinPurseUI.3(this));
            AppMethodBeat.o(66476);
            return true;
          }
        }
        if (paramString.wNI == 0)
        {
          localObject1 = this.wQf;
          ((c)localObject1).wPd = com.tencent.mm.plugin.offline.c.a.dAF();
          ((c)localObject1).wPd = ((c)localObject1).wPd;
          if (!"1".equals(paramString.wOm)) {
            break label288;
          }
          ae.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
          doSceneProgress(new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 8), false);
          break label288;
        }
        if (paramString.wNI == 0) {
          break label288;
        }
        this.wQf.a(paramString, paramString.wNI, paramString.wNJ);
        break label288;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.a)) {
        break label288;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
      {
        this.wQf.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        break label288;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
      {
        if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
          this.mTipDialog.dismiss();
        }
        paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.i)paramn;
        if (("1".equals(paramString.Dkx)) || (("2".equals(paramString.Dkx)) && (!bu.isNullOrNil(paramString.Dky))))
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
          if ("collect".equals(paramString.DkB)) {
            dzX();
          } else if ("reward".equals(paramString.DkB)) {
            com.tencent.mm.br.d.Q(getContext(), "collect", ".reward.ui.QrRewardMainUI");
          } else {
            ae.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { paramString.DkB });
          }
        }
      }
      if (!(paramn instanceof com.tencent.mm.plugin.offline.a.q)) {
        break label288;
      }
      paramString = (com.tencent.mm.plugin.offline.a.q)paramn;
      this.wPZ = true;
      if ((paramString.isJumpRemind()) && (!this.wQa && (paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
      {
        public final void dmz() {}
      }))) {
        this.wQa = true;
      }
      onSceneEnd(paramString.wOt.errType, paramString.wOt.errCode, paramString.wOt.errMsg, paramString.wOr);
      onSceneEnd(paramString.wOs.errType, paramString.wOs.errCode, paramString.wOs.errMsg, paramString.wOq);
      if ((this.mIQ == null) || (!this.mIQ.isShowing()) || (this.wQb != 1)) {
        break label288;
      }
      pt(true);
      break label288;
      label1457:
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.f))
      {
        dAa();
        X(true, true);
      }
      else if ((paramn instanceof com.tencent.mm.plugin.offline.a.k))
      {
        com.tencent.mm.plugin.offline.c.a.az(this);
        doSceneProgress(new ad(null, 8), false);
        dAl();
        dAm();
        dAj();
        continue;
        if ((paramn instanceof com.tencent.mm.plugin.offline.a.n))
        {
          dAa();
          X(false, true);
          if (411 == paramInt2) {
            this.wQf.a(paramn, paramInt2, paramString);
          }
        }
        else if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
        {
          this.wQf.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        }
        else if (!(paramn instanceof j))
        {
          if ((paramn instanceof com.tencent.mm.plugin.offline.a.f))
          {
            this.wNe = null;
          }
          else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
          {
            if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
              this.mTipDialog.dismiss();
            }
          }
          else if ((paramn instanceof com.tencent.mm.plugin.offline.a.q))
          {
            dAa();
            X(false, true);
            if (411 == paramInt2) {
              this.wQf.a(paramn, paramInt2, paramString);
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
    
    public final void dAu()
    {
      AppMethodBeat.i(66443);
      WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306758));
      this.wQP = ((ImageView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296290));
      this.wQQ = ((TextView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296301));
      this.wQR = ((ImageView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296300));
      WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineAALayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
          com.tencent.mm.plugin.newtips.a.dxD().Mv(16);
          com.tencent.mm.plugin.report.service.g.yxI.f(14021, new Object[] { Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          paramAnonymousView = new Intent();
          if (WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this) == 1) {
            paramAnonymousView.putExtra("enter_scene", 2);
          }
          for (;;)
          {
            com.tencent.mm.br.d.b(WalletOfflineCoinPurseUI.this.getContext(), "aa", ".ui.AAEntranceUI", paramAnonymousView);
            WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
            if (com.tencent.mm.y.c.ahI().b(am.a.IWh, am.a.IVd))
            {
              com.tencent.mm.y.c.ahI().c(am.a.IWh, am.a.IVd);
              WalletOfflineCoinPurseUI.b.this.wQP.setVisibility(8);
              com.tencent.mm.plugin.report.service.g.yxI.f(14396, new Object[] { Integer.valueOf(4) });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineAALayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66442);
            return;
            if (WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this) == 2) {
              paramAnonymousView.putExtra("enter_scene", 4);
            } else {
              ae.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { Integer.valueOf(WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this)) });
            }
          }
        }
      });
      AppMethodBeat.o(66443);
    }
    
    public final boolean dnE()
    {
      AppMethodBeat.i(66444);
      super.dnE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.ahI().b(am.a.IWh, am.a.IVd))
      {
        this.wQP.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wIw, true);
      }
      AppMethodBeat.o(66444);
      return true;
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
    ArrayList<String> mDataList;
    ArrayList<Boolean> wQT;
    
    public c()
    {
      AppMethodBeat.i(66446);
      this.mDataList = new ArrayList();
      this.wQT = new ArrayList();
      AppMethodBeat.o(66446);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66447);
      int i = this.mDataList.size();
      AppMethodBeat.o(66447);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(66448);
      Object localObject = this.mDataList.get(paramInt);
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
      paramView.setText((String)this.mDataList.get(paramInt));
      if (WalletOfflineCoinPurseUI.dAt() == paramInt)
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
      boolean bool = ((Boolean)this.wQT.get(paramInt)).booleanValue();
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
    
    public final void dAu()
    {
      AppMethodBeat.i(66452);
      WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306759));
      this.wQP = ((ImageView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297132));
      this.wQQ = ((TextView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297134));
      this.wQR = ((ImageView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297133));
      WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66451);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineBankRemitLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = new hl();
          paramAnonymousView.dQB = 3L;
          paramAnonymousView.aLH();
          com.tencent.mm.plugin.newtips.a.dxD().Mv(20);
          com.tencent.mm.plugin.remittance.mobile.a.b.OE(WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this));
          if (WalletOfflineCoinPurseUI.Y(WalletOfflineCoinPurseUI.this)) {
            com.tencent.mm.br.d.Q(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".mobile.ui.BankMobileRemittanceChooseUI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineBankRemitLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66451);
            return;
            com.tencent.mm.br.d.Q(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
          }
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
    
    public final void dAu()
    {
      AppMethodBeat.i(66456);
      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306761));
      this.wQP = ((ImageView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299650));
      this.wQQ = ((TextView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299652));
      this.wQR = ((ImageView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299651));
      WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66455);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.dxD().Mv(17);
          if (com.tencent.mm.y.c.ahI().b(am.a.IWi, am.a.IVd))
          {
            com.tencent.mm.y.c.ahI().c(am.a.IWi, am.a.IVd);
            WalletOfflineCoinPurseUI.e.this.wQP.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.wQQ.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.wQR.setVisibility(8);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVx, "");
            com.tencent.mm.plugin.report.service.g.yxI.f(14396, new Object[] { Integer.valueOf(3) });
          }
          if (t.eJf().eJH())
          {
            WalletOfflineCoinPurseUI.U(WalletOfflineCoinPurseUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66455);
            return;
          }
          t.eIZ();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          localObject = WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this);
          new a.a()
          {
            public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(66454);
              ae.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + paramAnonymous2Int1 + ";errCode=" + paramAnonymous2Int2 + ";errMsg=" + paramAnonymous2String + ";hadAgree = " + paramAnonymous2Boolean);
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
          if (!t.b(paramAnonymousView, (com.tencent.mm.wallet_core.d.e)localObject, 1006))
          {
            paramAnonymousView = new com.tencent.mm.plugin.wallet_core.id_verify.model.i("collect");
            WalletOfflineCoinPurseUI.this.doSceneForceProgress(paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66455);
        }
      });
      AppMethodBeat.o(66456);
    }
    
    public final boolean dnE()
    {
      AppMethodBeat.i(66457);
      super.dnE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.ahI().b(am.a.IWi, am.a.IVd))
      {
        com.tencent.mm.kernel.g.ajS();
        String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVx, "");
        if (bu.isNullOrNil(str)) {
          break label98;
        }
        this.wQQ.setText(str);
        this.wQQ.setVisibility(0);
        this.wQR.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wIx, true);
      }
      for (;;)
      {
        AppMethodBeat.o(66457);
        return true;
        label98:
        this.wQP.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wIw, true);
      }
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
    
    public final void dAu()
    {
      AppMethodBeat.i(66460);
      WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306762));
      this.wQP = ((ImageView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299640));
      this.wQQ = ((TextView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299642));
      this.wQR = ((ImageView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299641));
      WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66459);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineF2fLuckyLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.dxD().Mv(18);
          com.tencent.mm.plugin.report.service.g.yxI.f(14021, new Object[] { Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          com.tencent.mm.br.d.Q(WalletOfflineCoinPurseUI.this.getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
          if (com.tencent.mm.y.c.ahI().b(am.a.IWj, am.a.IVd))
          {
            com.tencent.mm.y.c.ahI().c(am.a.IWj, am.a.IVd);
            WalletOfflineCoinPurseUI.f.this.wQP.setVisibility(8);
            com.tencent.mm.plugin.report.service.g.yxI.f(14396, new Object[] { Integer.valueOf(5) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineF2fLuckyLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66459);
        }
      });
      AppMethodBeat.o(66460);
    }
    
    public final boolean dnE()
    {
      AppMethodBeat.i(66461);
      super.dnE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.ahI().b(am.a.IWj, am.a.IVd))
      {
        this.wQP.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wIw, true);
      }
      AppMethodBeat.o(66461);
      return true;
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
    
    public final void dAu()
    {
      AppMethodBeat.i(66465);
      WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306764));
      this.wQP = ((ImageView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303608));
      this.wQQ = ((TextView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303610));
      this.wQR = ((ImageView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303609));
      WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66464);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          ae.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.dxD().Mv(19);
          com.tencent.mm.plugin.report.service.g.yxI.f(14021, new Object[] { Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          if (com.tencent.mm.y.c.ahI().b(am.a.IWk, am.a.IVd))
          {
            com.tencent.mm.y.c.ahI().c(am.a.IWk, am.a.IVd);
            WalletOfflineCoinPurseUI.g.this.wQP.setVisibility(8);
          }
          if (t.eJf().eJH())
          {
            com.tencent.mm.br.d.Q(WalletOfflineCoinPurseUI.this.getContext(), "collect", ".reward.ui.QrRewardMainUI");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66464);
            return;
          }
          t.eIZ();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          localObject = WalletOfflineCoinPurseUI.X(WalletOfflineCoinPurseUI.this);
          new a.a()
          {
            public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(66463);
              ae.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + paramAnonymous2Int1 + ";errCode=" + paramAnonymous2Int2 + ";errMsg=" + paramAnonymous2String + ";hadAgree = " + paramAnonymous2Boolean);
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
          if (!t.b(paramAnonymousView, (com.tencent.mm.wallet_core.d.e)localObject, 1006))
          {
            paramAnonymousView = new com.tencent.mm.plugin.wallet_core.id_verify.model.i("reward");
            WalletOfflineCoinPurseUI.this.doSceneForceProgress(paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66464);
        }
      });
      AppMethodBeat.o(66465);
    }
    
    public final boolean dnE()
    {
      AppMethodBeat.i(66467);
      super.dnE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.ahI().b(am.a.IWk, am.a.IVd))
      {
        this.wQP.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wIw, true);
      }
      AppMethodBeat.o(66467);
      return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI
 * JD-Core Version:    0.7.0.1
 */