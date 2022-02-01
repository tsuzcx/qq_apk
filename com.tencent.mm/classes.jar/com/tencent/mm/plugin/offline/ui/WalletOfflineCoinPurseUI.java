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
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vm.b;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.b;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.g.b.a.hj;
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
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.protocal.protobuf.cdl;
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
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
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
  implements u.a, s.a, com.tencent.mm.plugin.offline.b, a, bh.a
{
  private static int npu = 0;
  private boolean cEv;
  private int dtK;
  private int fPp;
  private View.OnClickListener jtG;
  private com.tencent.mm.ui.widget.a.e mDL;
  private int mEntryScene;
  private long mLastTime;
  private int mState;
  private Dialog mTipDialog;
  private boolean oFw;
  private int rgD;
  private HashMap<String, Integer> vhT;
  private String wAA;
  private boolean wAB;
  private int wAC;
  private boolean wAD;
  private com.tencent.mm.plugin.wallet_core.model.r wAE;
  com.tencent.mm.sdk.b.c<yp> wAF;
  com.tencent.mm.sdk.b.c<yp> wAG;
  private com.tencent.mm.sdk.b.c<cw> wAH;
  private com.tencent.mm.sdk.b.c<oc> wAI;
  private com.tencent.mm.sdk.b.c<nl> wAJ;
  private com.tencent.mm.sdk.b.c<nm> wAK;
  private com.tencent.mm.sdk.b.c wAL;
  private com.tencent.mm.sdk.b.c wAM;
  private com.tencent.mm.sdk.b.c wAN;
  public boolean wAO;
  private av wAP;
  private av wAQ;
  private b wAa;
  private f wAb;
  private d wAc;
  private LinearLayout wAd;
  private LinearLayout wAe;
  private LinearLayout wAf;
  private LinearLayout wAg;
  private LinearLayout wAh;
  private String wAi;
  private boolean wAj;
  private com.tencent.mm.plugin.offline.g wAk;
  private boolean wAl;
  private boolean wAm;
  private boolean wAn;
  private boolean wAo;
  private boolean wAp;
  private int wAq;
  private ArrayList<Bitmap> wAr;
  private ArrayList<Bitmap> wAs;
  private com.tencent.mm.wallet_core.ui.c wAt;
  private c wAu;
  private OfflineAlertView wAv;
  private boolean wAw;
  private boolean wAx;
  private String wAy;
  private boolean wAz;
  private String wwO;
  private com.tencent.mm.sdk.b.c<ks> wxJ;
  private String wxr;
  private com.tencent.mm.plugin.offline.a.m wxt;
  private int wxv;
  private av wxw;
  private HashMap<String, View> wzA;
  private HashMap<String, Integer> wzB;
  Bitmap wzC;
  Bitmap wzD;
  private c wzE;
  private boolean wzF;
  private boolean wzG;
  private ArrayList<String> wzH;
  private ArrayList<String> wzI;
  private ArrayList<Boolean> wzJ;
  private String wzK;
  private View wzL;
  private ImageView wzM;
  private ImageView wzN;
  private TextView wzO;
  private String wzP;
  private View wzQ;
  private TextView wzR;
  private ImageView wzS;
  private RelativeLayout wzT;
  private LinearLayout wzU;
  private CdnImageView wzV;
  private TextView wzW;
  private TextView wzX;
  private e wzY;
  private g wzZ;
  
  public WalletOfflineCoinPurseUI()
  {
    AppMethodBeat.i(66468);
    this.mLastTime = 0L;
    this.mState = 3;
    this.wzA = new HashMap();
    this.wzB = new HashMap();
    this.mEntryScene = -1;
    this.wzC = null;
    this.wzD = null;
    this.wzF = false;
    this.wzG = false;
    this.wzH = new ArrayList();
    this.wzI = new ArrayList();
    this.wzJ = new ArrayList();
    this.wwO = "";
    this.wzK = "";
    this.wAi = "";
    this.wxr = "";
    this.oFw = true;
    this.wAj = false;
    this.wAl = false;
    this.wAm = false;
    this.wAn = false;
    this.wAo = true;
    this.wAp = false;
    this.wAq = -1;
    this.wAr = new ArrayList();
    this.wAs = new ArrayList();
    this.wAw = false;
    this.wAx = false;
    this.wAy = null;
    this.wAz = false;
    this.dtK = 0;
    this.wAB = false;
    this.wAD = true;
    this.wAF = new com.tencent.mm.sdk.b.c() {};
    this.wAG = new com.tencent.mm.sdk.b.c() {};
    this.wAH = new WalletOfflineCoinPurseUI.23(this);
    this.wAI = new WalletOfflineCoinPurseUI.34(this);
    this.wAJ = new com.tencent.mm.sdk.b.c() {};
    this.wAK = new com.tencent.mm.sdk.b.c() {};
    this.wAL = new WalletOfflineCoinPurseUI.38(this);
    this.wAM = new com.tencent.mm.sdk.b.c() {};
    this.wAN = new com.tencent.mm.sdk.b.c() {};
    this.jtG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66411);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        long l;
        if ((paramAnonymousView.getId() == 2131306827) || (paramAnonymousView.getId() == 2131306693) || (paramAnonymousView.getId() == 2131306694))
        {
          if ((paramAnonymousView.getId() == 2131306827) && (WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).isShowing()))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66411);
            return;
          }
          l = System.currentTimeMillis();
          if (((WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this) == null) || (!WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).isShowing())) && (l - WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this) >= 400L) && (com.tencent.mm.plugin.offline.c.a.dxi()) && (!WalletOfflineCoinPurseUI.q(WalletOfflineCoinPurseUI.this)))
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
            WalletOfflineCoinPurseUI.r(WalletOfflineCoinPurseUI.this).N(paramAnonymousView, WalletOfflineCoinPurseUI.t(WalletOfflineCoinPurseUI.this));
          }
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, l);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66411);
          return;
          label260:
          if ((paramAnonymousView.getId() == 2131306693) || (paramAnonymousView.getId() == 2131306694))
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(13958, new Object[] { Integer.valueOf(4) });
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, true);
          }
        }
      }
    };
    this.wAO = false;
    this.vhT = new HashMap();
    this.wxv = 60000;
    this.wxw = new av(new av.a()
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
        localav.az(l, l);
        AppMethodBeat.o(66434);
        return false;
      }
    }, false);
    this.wAP = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(174401);
        WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this);
        if ((WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).isShowing())) {
          WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).dismiss();
        }
        com.tencent.mm.plugin.offline.g.dwl();
        WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this);
        if (com.tencent.mm.plugin.offline.c.a.dxJ()) {
          WalletOfflineCoinPurseUI.this.dwC();
        }
        AppMethodBeat.o(174401);
        return false;
      }
    }, false);
    this.wAQ = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(184862);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this)) });
        if (WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this))
        {
          cj localcj = new cj();
          localcj.dnp.bZU = 0;
          com.tencent.mm.sdk.b.a.IbL.l(localcj);
        }
        WalletOfflineCoinPurseUI.this.finish();
        AppMethodBeat.o(184862);
        return false;
      }
    }, false);
    this.wxJ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(66468);
  }
  
  private void Mk(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(66490);
    if (!com.tencent.mm.plugin.offline.c.a.dxi())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
      AppMethodBeat.o(66490);
      return;
    }
    com.tencent.mm.plugin.offline.k.dwq();
    Object localObject = com.tencent.mm.plugin.offline.k.dws().B(this.mEntryScene, paramInt, this.wzP);
    this.wxr = ((String)localObject);
    this.wAi = ((String)localObject);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[] { Integer.valueOf(paramInt), this.wxr, this.wAi, bt.flS().toString() });
    cbl();
    if (bt.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.mm.plugin.report.service.g.yhR;
      if (com.tencent.mm.plugin.offline.c.a.cH(aj.getContext())) {}
      for (paramInt = 0;; paramInt = 1)
      {
        if (ay.isNetworkConnected(getBaseContext())) {
          i = 1;
        }
        ((com.tencent.mm.plugin.report.service.g)localObject).f(14163, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 26L, 1L, true);
        if (!ay.isNetworkConnected(getBaseContext())) {
          break;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 28L, 1L, true);
        AppMethodBeat.o(66490);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 27L, 1L, true);
    }
    AppMethodBeat.o(66490);
  }
  
  private static void Ml(int paramInt)
  {
    AppMethodBeat.i(66509);
    com.tencent.mm.g.b.a.r localr = new com.tencent.mm.g.b.a.r();
    localr.dSI = paramInt;
    localr.aLk();
    AppMethodBeat.o(66509);
  }
  
  private void Y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66480);
    if (com.tencent.mm.plugin.offline.c.a.pm(true).size() > 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
      dwS();
      dwR();
      this.wzQ.setVisibility(0);
    }
    for (;;)
    {
      if (paramBoolean1) {
        Mk(0);
      }
      pk(paramBoolean2);
      bWG();
      dwJ();
      AppMethodBeat.o(66480);
      return;
      this.wzQ.setVisibility(0);
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
    }
  }
  
  private void a(Bankcard paramBankcard)
  {
    AppMethodBeat.i(66511);
    if (TextUtils.isEmpty(this.wwO))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
      AppMethodBeat.o(66511);
      return;
    }
    if (paramBankcard.eEV())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
      this.wzS.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131690298));
      AppMethodBeat.o(66511);
      return;
    }
    String str2 = com.tencent.mm.plugin.offline.c.a.atQ(this.wwO);
    String str1 = str2;
    if (paramBankcard.eES())
    {
      str1 = str2;
      if (paramBankcard.CUO != null) {
        str1 = paramBankcard.CUO.wqa;
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
      AppMethodBeat.o(66511);
      return;
    }
    e(this.wzS, str1, getResources().getDimensionPixelOffset(2131167003));
    AppMethodBeat.o(66511);
  }
  
  private void bWG()
  {
    AppMethodBeat.i(66479);
    if (com.tencent.mm.plugin.offline.c.a.dxi())
    {
      this.wzT.setVisibility(0);
      AppMethodBeat.o(66479);
      return;
    }
    this.wzT.setVisibility(4);
    AppMethodBeat.o(66479);
  }
  
  private void cbl()
  {
    AppMethodBeat.i(66516);
    bb localbb = com.tencent.mm.plugin.wallet_core.model.k.eFo();
    Object localObject = new StringBuilder().append(this.wAi);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA();
    localObject = com.tencent.mm.sdk.platformtools.ai.ee(p.getString(com.tencent.mm.kernel.a.getUin()));
    if (localbb != null) {
      com.tencent.mm.plugin.report.service.g.yhR.f(13444, new Object[] { localbb.FsF, localbb.FsG, Long.valueOf(localbb.FsE), localObject, localbb.FsH, localbb.FsI, localbb.FsJ });
    }
    AppMethodBeat.o(66516);
  }
  
  private void dhY()
  {
    AppMethodBeat.i(66484);
    Bitmap localBitmap = this.wzC;
    this.wzC = dwP();
    this.wzM.setImageBitmap(this.wzC);
    this.wAr.add(0, localBitmap);
    AppMethodBeat.o(66484);
  }
  
  private void dwG()
  {
    AppMethodBeat.i(66470);
    dwV();
    dxb();
    dwW();
    dwT();
    dwZ();
    AppMethodBeat.o(66470);
  }
  
  private void dwH()
  {
    AppMethodBeat.i(66472);
    com.tencent.mm.wallet_core.ui.e.agr(32);
    com.tencent.mm.pluginsdk.wallet.f.au(this, this.rgD);
    AppMethodBeat.o(66472);
  }
  
  private void dwI()
  {
    AppMethodBeat.i(66478);
    cdk localcdk = t.eFy().Dbb;
    if (localcdk == null)
    {
      this.wzU.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if (localcdk.GXy == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "offlineGuideBar.guide_data == null");
      this.wzU.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    Object localObject = localcdk.GXy.wBI;
    if (t.eFy().aEt((String)localObject) == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar bindSerial(%s) is null bankcard!", new Object[] { bt.bI((String)localObject, "") });
      this.wzU.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    localObject = com.tencent.mm.plugin.offline.c.a.dxk();
    if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (bt.lQ(localcdk.GXy.wBI, ((Bankcard)localObject).field_bindSerial)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar defaultBankcard(%s) == bindSerial(%s)", new Object[] { ((Bankcard)localObject).field_bindSerial, localcdk.GXy.wBI });
      this.wzU.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if ((this.wzU.isShown()) && (this.wzU.getTag() != null) && ((this.wzU.getTag() instanceof cdk)) && (bt.K((cdk)this.wzU.getTag(), localcdk)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "");
      AppMethodBeat.o(66478);
      return;
    }
    if (localcdk.CGI == 0)
    {
      this.wzU.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if (!this.wAo)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "isShowGuideBar == false");
      AppMethodBeat.o(66478);
      return;
    }
    int i = this.wzU.getVisibility();
    this.wzU.setTag(localcdk);
    this.wzU.setVisibility(0);
    if ((!bt.isNullOrNil(localcdk.GXz)) && (this.wzU.getBackground() != null)) {
      this.wzU.getBackground().setColorFilter(Color.parseColor(localcdk.GXz), PorterDuff.Mode.SRC);
    }
    int j = BackwardSupportUtil.b.g(this, 20.0F);
    this.wzV.r(localcdk.CGP, j, j, -1);
    this.wzW.setText(localcdk.CGK);
    this.wzW.setTextColor(Color.parseColor(localcdk.CGL));
    this.wzX.setText(localcdk.CGM);
    this.wzX.setTextColor(Color.parseColor(localcdk.CGN));
    this.wzX.setTag(localcdk.GXy.wBI);
    al.a(this.wzX.getPaint(), 0.8F);
    if (localcdk.CIy == ai.a.DaD.value) {
      this.wzX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184848);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          WalletOfflineCoinPurseUI.Mm(2);
          String str = "";
          localObject = str;
          if (paramAnonymousView.getTag() != null)
          {
            localObject = str;
            if ((paramAnonymousView.getTag() instanceof String)) {
              localObject = (String)paramAnonymousView.getTag();
            }
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "mOfflineGuideButtonTv click! bindSerial:%s", new Object[] { localObject });
          if (bt.isNullOrNil((String)localObject))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(184848);
            return;
          }
          WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = t.eFy().aEt((String)localObject);
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(184848);
        }
      });
    }
    Ml(1);
    if ((i == 8) && (this.wAv.isShowing()))
    {
      dwT();
      if ((!this.wAl) && (this.wAv.Mj(4)))
      {
        com.tencent.mm.kernel.g.ajD();
        if (!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iwl, Boolean.FALSE)).booleanValue()) {
          dwU();
        }
      }
    }
    AppMethodBeat.o(66478);
  }
  
  private void dwJ()
  {
    AppMethodBeat.i(66481);
    if ((!this.wAO) && (!ay.isNetworkConnected(getBaseContext())))
    {
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.dws();
      if (com.tencent.mm.plugin.offline.e.dwi() == 0)
      {
        this.wAO = true;
        b.av(this);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
      }
    }
    AppMethodBeat.o(66481);
  }
  
  private void dwK()
  {
    AppMethodBeat.i(66482);
    int i = com.tencent.mm.plugin.offline.c.a.dxn();
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.dxl();
    if (c.dwE())
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
    if (com.tencent.mm.plugin.offline.c.a.dxi())
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
  
  private boolean dwL()
  {
    return (this.mState == 2) || (this.mState == 1) || (this.mState == 7);
  }
  
  private void dwM()
  {
    AppMethodBeat.i(66485);
    Bitmap localBitmap = this.wzD;
    this.wzD = dwO();
    this.wzN.setImageBitmap(this.wzD);
    if (dwL()) {
      this.wzN.setAlpha(10);
    }
    for (;;)
    {
      this.wAs.add(0, localBitmap);
      AppMethodBeat.o(66485);
      return;
      this.wzN.setAlpha(255);
    }
  }
  
  private void dwN()
  {
    AppMethodBeat.i(66486);
    if (this.wAt != null)
    {
      this.wAt.mF(this.wAi, this.wxr);
      this.wAt.wzC = this.wzC;
      this.wAt.wzD = this.wzD;
      this.wAt.fRW();
    }
    AppMethodBeat.o(66486);
  }
  
  private Bitmap dwO()
  {
    AppMethodBeat.i(66488);
    if (TextUtils.isEmpty(this.wxr))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
      AppMethodBeat.o(66488);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.bz.a.a.b(this, this.wxr, 5, 0);
    AppMethodBeat.o(66488);
    return localBitmap;
  }
  
  private Bitmap dwP()
  {
    AppMethodBeat.i(66489);
    if (TextUtils.isEmpty(this.wAi))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
      AppMethodBeat.o(66489);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.bz.a.a.b(this, this.wAi, 12, 3);
    AppMethodBeat.o(66489);
    return localBitmap;
  }
  
  private void dwQ()
  {
    AppMethodBeat.i(66493);
    if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
      this.mTipDialog.dismiss();
    }
    AppMethodBeat.o(66493);
  }
  
  private void dwS()
  {
    AppMethodBeat.i(66499);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.dxk();
    if (localBankcard != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
      com.tencent.mm.plugin.offline.c.a.atJ(localBankcard.field_bindSerial);
      this.wwO = localBankcard.field_bindSerial;
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.dws().wwO = this.wwO;
      AppMethodBeat.o(66499);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
    AppMethodBeat.o(66499);
  }
  
  private void dwT()
  {
    AppMethodBeat.i(66500);
    if (this.wAl)
    {
      AppMethodBeat.o(66500);
      return;
    }
    if (!this.wAv.Mj(4))
    {
      AppMethodBeat.o(66500);
      return;
    }
    com.tencent.mm.kernel.g.ajD();
    if ((!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iwl, Boolean.FALSE)).booleanValue()) && (!this.wAv.isShowing())) {
      dwU();
    }
    AppMethodBeat.o(66500);
  }
  
  private void dwU()
  {
    AppMethodBeat.i(66501);
    if (!this.wAv.Mj(4))
    {
      AppMethodBeat.o(66501);
      return;
    }
    this.wAv.ew(this.wzL);
    AppMethodBeat.o(66501);
  }
  
  private void dwV()
  {
    AppMethodBeat.i(66502);
    if (!this.wAv.Mj(1))
    {
      AppMethodBeat.o(66502);
      return;
    }
    if (this.wAv.wzc == 1) {
      this.wAv.dismiss();
    }
    boolean bool1 = t.eFy().eGc();
    boolean bool2 = t.eFy().eGb();
    if ((bool1) || (bool2))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.wAv.a(this.wzL, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66421);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.plugin.offline.c.a.dxu();
          com.tencent.mm.plugin.offline.k.dwq();
          com.tencent.mm.plugin.offline.k.bz(196648, "0");
          WalletOfflineCoinPurseUI.F(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66421);
        }
      }, 1);
    }
    AppMethodBeat.o(66502);
  }
  
  private void dwW()
  {
    AppMethodBeat.i(66503);
    if (!this.wAv.Mj(3))
    {
      AppMethodBeat.o(66503);
      return;
    }
    if (this.wAv.wzc == 3) {
      this.wAv.dismiss();
    }
    com.tencent.mm.plugin.offline.k.dwq();
    String str1 = com.tencent.mm.plugin.offline.k.Mi(196617);
    com.tencent.mm.wallet_core.c.b.fRq();
    boolean bool1 = com.tencent.mm.wallet_core.c.b.isCertExist(str1);
    boolean bool2 = com.tencent.mm.plugin.offline.c.a.dxi();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) || (!bool2)) {
      if (!bool1)
      {
        com.tencent.mm.kernel.g.ajD();
        String str2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IpV, "");
        if ((str2 == null) || (!str2.equals(com.tencent.mm.compatible.deviceinfo.q.cH(true)))) {
          break label222;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + str1 + " ,recreate offline");
      com.tencent.mm.plugin.offline.c.a.dxu();
      this.wzT.setVisibility(4);
      this.wAv.a(this.wzL, new WalletOfflineCoinPurseUI.21(this), 3);
      AppMethodBeat.o(66503);
      return;
      label222:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
    }
  }
  
  private void dwX()
  {
    AppMethodBeat.i(66504);
    if (!this.wAv.Mj(5))
    {
      AppMethodBeat.o(66504);
      return;
    }
    if (this.wAv.wzc == 5) {
      this.wAv.dismiss();
    }
    this.wAv.b(this.wzL, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66423);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.offline.k.dwq();
        com.tencent.mm.plugin.offline.k.dwt();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.i.dwp()) });
        com.tencent.mm.plugin.offline.k.dwq();
        com.tencent.mm.plugin.offline.k.dwt();
        if (com.tencent.mm.plugin.offline.i.dwp() <= 0)
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
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 73L, 1L, true);
    AppMethodBeat.o(66504);
  }
  
  private void dwZ()
  {
    AppMethodBeat.i(199116);
    if ((this.wAE == null) || (!this.wAE.ozk))
    {
      if (this.wAv.wzc == 8) {
        this.wAv.dismiss();
      }
      AppMethodBeat.o(199116);
      return;
    }
    if (!this.wAv.Mj(8))
    {
      AppMethodBeat.o(199116);
      return;
    }
    if (this.wAv.wzc == 8) {
      this.wAv.dismiss();
    }
    this.wAv.a(this.wzL, this.wAE);
    com.tencent.mm.plugin.report.service.g.yhR.f(20258, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(199116);
  }
  
  private void dxa()
  {
    AppMethodBeat.i(66506);
    if ((this.wAv.isShowing()) && (this.wAv.wzc == 5)) {
      this.wAv.dismiss();
    }
    AppMethodBeat.o(66506);
  }
  
  private boolean dxb()
  {
    AppMethodBeat.i(66507);
    if (!this.wAv.Mj(2))
    {
      AppMethodBeat.o(66507);
      return false;
    }
    if (this.wAv.wzc == 2) {
      this.wAv.dismiss();
    }
    List localList = com.tencent.mm.plugin.offline.c.a.dxo();
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
    this.wAv.dismiss();
    this.wAv.a(this.wzL, new Runnable()new WalletOfflineCoinPurseUI.27
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
          com.tencent.mm.plugin.offline.c.a.i(localc.mActivity, localc.wzt);
        }
      }
    }, new WalletOfflineCoinPurseUI.27(this));
    AppMethodBeat.o(66507);
    return false;
  }
  
  private static void dxc()
  {
    AppMethodBeat.i(66510);
    if (!com.tencent.mm.plugin.offline.c.a.dxB())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.dwt().gS(3, 3);
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
      paramImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.g.a(localBitmap, paramInt, paramInt, true, false));
    }
    this.wzA.put(paramString, paramImageView);
    this.wzB.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(66495);
  }
  
  private void pk(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(66483);
    long l = System.currentTimeMillis();
    int i;
    if ((paramBoolean) && ((bt.isNullOrNil(this.wAi)) || (bt.isNullOrNil(this.wxr))))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
      dwX();
      dhY();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - l));
      dwM();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - l));
      recycleBmpList();
      dwN();
      dwI();
      ab.kB(10, 0);
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
      if (!com.tencent.mm.plugin.offline.c.a.cH(aj.getContext())) {
        break label281;
      }
      i = 0;
      label148:
      if (ay.isNetworkConnected(aj.getContext())) {
        j = 1;
      }
      com.tencent.mm.plugin.offline.k.dwq();
      com.tencent.mm.plugin.offline.k.dws();
      localg.f(14163, new Object[] { Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(com.tencent.mm.plugin.offline.e.dwi()) });
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 67L, 1L, true);
      if (!ay.isNetworkConnected(aj.getContext())) {
        break label286;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 32L, 1L, true);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.offline.c.a.cH(this)) {
        break label303;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 34L, 1L, true);
      AppMethodBeat.o(66483);
      return;
      dxa();
      break;
      label281:
      i = 1;
      break label148;
      label286:
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 33L, 1L, true);
    }
    label303:
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 35L, 1L, true);
    AppMethodBeat.o(66483);
  }
  
  private void pl(boolean paramBoolean)
  {
    AppMethodBeat.i(66508);
    if (!com.tencent.mm.plugin.offline.c.a.dxi())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.dxi()) });
      AppMethodBeat.o(66508);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.pm(false).size() <= 0)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      this.wzR.setVisibility(8);
      AppMethodBeat.o(66508);
      return;
    }
    final ArrayList localArrayList = af.um(true);
    int i;
    Object localObject;
    int j;
    if ((paramBoolean) && (this.mDL == null))
    {
      this.mDL = new com.tencent.mm.ui.widget.a.e(this, 2, true);
      this.wAq = -1;
      this.mDL.bpT();
      i = 0;
      localObject = null;
      j = 0;
      label128:
      if (i >= localArrayList.size()) {
        break label213;
      }
      Bankcard localBankcard = (Bankcard)localArrayList.get(i);
      if ((bt.isNullOrNil(localBankcard.field_bindSerial)) || (!this.wwO.equals(localBankcard.field_bindSerial))) {
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
      this.mDL = null;
      this.mDL = new com.tencent.mm.ui.widget.a.e(this, 2, true);
      break;
      if (localObject != null)
      {
        localArrayList.remove(localObject);
        localArrayList.add(0, localObject);
        j = 0;
      }
      this.mDL.KJy = new n.d()
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
            localObject1 = com.tencent.mm.plugin.offline.c.a.atP(localBankcard.field_bankcardType);
            localObject3 = localObject1;
            if (localBankcard.eES())
            {
              localObject3 = localObject1;
              if (localBankcard.CUO != null) {
                localObject3 = localBankcard.CUO.wqa;
              }
            }
            localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject3));
            com.tencent.mm.platformtools.u.a(new u.a()
            {
              public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(184858);
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(184857);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletOfflineCoinPurseUI.28.1.this.wBa });
                    if (WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).containsKey(paramAnonymous2String))
                    {
                      int i = ((Integer)WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).get(paramAnonymous2String)).intValue();
                      if (WalletOfflineCoinPurseUI.28.1.this.vic.getItem(i) != null)
                      {
                        WalletOfflineCoinPurseUI.28.1.this.vic.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.a(paramAnonymous2Bitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), true, false)));
                        WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).fMg();
                      }
                    }
                    AppMethodBeat.o(184857);
                  }
                });
                AppMethodBeat.o(184858);
              }
            });
            localObject2 = "";
            if (!bt.isNullOrNil(localBankcard.field_forbidWord)) {
              localObject2 = localBankcard.field_forbidWord;
            }
            localObject1 = localObject2;
            if (bt.isNullOrNil((String)localObject2))
            {
              localObject1 = localObject2;
              if (!localBankcard.field_support_micropay)
              {
                if (!bt.isNullOrNil(localBankcard.field_no_micro_word)) {
                  break label531;
                }
                localObject1 = "";
              }
            }
            if (bt.isNullOrNil(localBankcard.field_forbid_title))
            {
              localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
              localObject4 = localObject1;
              localObject1 = localObject2;
              label203:
              if ((!bt.ai((CharSequence)localObject1)) || (bt.isNullOrNil(localBankcard.field_prompt_info_prompt_text))) {
                break label808;
              }
              localObject1 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
              if ((!bt.isNullOrNil(localBankcard.field_prompt_info_jump_text)) && (!bt.isNullOrNil(localBankcard.field_prompt_info_jump_url)))
              {
                ((SpannableStringBuilder)localObject1).append(localBankcard.field_prompt_info_jump_text);
                ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
                {
                  public final void dN(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(199114);
                    com.tencent.mm.wallet_core.ui.e.aW(WalletOfflineCoinPurseUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
                    com.tencent.mm.plugin.report.service.g.yhR.f(20216, new Object[] { Integer.valueOf(3), localBankcard.field_prompt_info_jump_url });
                    AppMethodBeat.o(199114);
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
            if (((localBankcard.eER()) || (localBankcard.eES())) && (localBankcard.CUD >= 0.0D))
            {
              str = localBankcard.field_desc + WalletOfflineCoinPurseUI.this.getString(2131764999, new Object[] { com.tencent.mm.wallet_core.ui.e.D(localBankcard.CUD) });
              label379:
              localObject2 = null;
              if (!localBankcard.eEV()) {
                break label688;
              }
              localObject2 = com.tencent.mm.svg.a.a.g(WalletOfflineCoinPurseUI.this.getResources(), 2131690298);
              if (localObject2 == null) {
                WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this).put(localObject3, Integer.valueOf(i));
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str, localObject1 });
              if (!localBankcard.eEW()) {
                break label754;
              }
              localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(WalletOfflineCoinPurseUI.this.getContext(), str);
              if (bt.isNullOrNil((String)localObject4))
              {
                if (!bt.isNullOrNil(localBankcard.CVc)) {
                  break label738;
                }
                localObject1 = "";
              }
              label499:
              if (bt.isNullOrNil((String)localObject4)) {
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
                  if ((localBankcard.eEW()) && (bt.isNullOrNil(paramAnonymous2View)))
                  {
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand");
                    paramAnonymous2View = new vm();
                    paramAnonymous2View.dJF.userName = localBankcard.CzQ;
                    paramAnonymous2View.dJF.dJH = localBankcard.CzR;
                    paramAnonymous2View.dJF.scene = 1137;
                    paramAnonymous2View.dJF.dJI = 0;
                    com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2View);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand result:%s", new Object[] { Boolean.valueOf(paramAnonymous2View.dJG.dJY) });
                    if (paramAnonymous2View.dJG.dJY)
                    {
                      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 1);
                      WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).bpT();
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
                  localIntent.putExtra("geta8key_username", com.tencent.mm.model.u.aAm());
                  localIntent.putExtra("pay_channel", 1);
                  com.tencent.mm.wallet_core.ui.e.an(WalletOfflineCoinPurseUI.this.getContext(), localIntent);
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
              localObject2 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.a(localBitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167003), true, false));
              break label404;
              localObject1 = localBankcard.CVc;
              break label499;
            }
            label754:
            localObject3 = com.tencent.mm.pluginsdk.ui.span.k.c(WalletOfflineCoinPurseUI.this.getContext(), str);
            if (!bt.isNullOrNil((String)localObject4)) {}
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
      this.mDL.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(184861);
          if (WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this).bpT();
            paramAnonymousMenuItem = (Bankcard)localArrayList.get(paramAnonymousInt);
            com.tencent.mm.plugin.report.service.g.yhR.f(14515, new Object[] { Integer.valueOf(3) });
            if ((!bt.isNullOrNil(paramAnonymousMenuItem.field_forbid_title)) || (!bt.isNullOrNil(paramAnonymousMenuItem.field_forbidWord)) || (!paramAnonymousMenuItem.field_support_micropay)) {
              com.tencent.mm.plugin.report.service.g.yhR.f(14515, new Object[] { Integer.valueOf(4) });
            }
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, paramAnonymousMenuItem);
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.eEW()))
            {
              WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this);
              WalletOfflineCoinPurseUI.Mm(3);
            }
          }
          AppMethodBeat.o(184861);
        }
      };
      localObject = View.inflate(this, 2131495985, null);
      this.mDL.xpt = true;
      this.mDL.iKS = j;
      this.mDL.KWX = true;
      this.mDL.K((View)localObject, false);
      this.mDL.cMW();
      com.tencent.mm.plugin.report.service.g.yhR.f(13955, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(66508);
      return;
    }
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(66487);
    int i;
    if (this.wAr.size() >= 2)
    {
      i = this.wAr.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.e.T((Bitmap)this.wAr.remove(i));
        i -= 1;
      }
    }
    if (this.wAs.size() >= 2)
    {
      i = this.wAs.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.e.T((Bitmap)this.wAs.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(66487);
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(199115);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
    Mk(1);
    pk(true);
    com.tencent.mm.wallet_core.ui.e.agr(40);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 21L, 1L, true);
    if (this.wAt.jtC.isShowing())
    {
      if (this.wAt.oFw)
      {
        this.wAt.fRX();
        AppMethodBeat.o(199115);
        return;
      }
      this.wAt.dismiss();
    }
    dwU();
    AppMethodBeat.o(199115);
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
    dwQ();
    this.wAt.dismiss();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "msgtype=" + paramc.wyQ);
    int i;
    if (4 == paramc.wyQ)
    {
      this.wAj = false;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = this.wAu;
      if (paramc == null) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
      }
      for (;;)
      {
        if ((this.wAm) && (!this.wAn))
        {
          this.wAm = false;
          this.wAj = false;
        }
        if (i != 0)
        {
          Mk(0);
          pk(true);
        }
        AppMethodBeat.o(66491);
        return true;
        if (5 == paramc.wyQ)
        {
          this.wAj = true;
          this.wAm = true;
          this.wAn = false;
          if (this.wAP.fkZ()) {
            break label420;
          }
          this.wAP.stopTimer();
          i = 0;
          break;
        }
        if (6 == paramc.wyQ)
        {
          if (!this.wAP.fkZ()) {
            this.wAP.stopTimer();
          }
          if (!this.wxw.fkZ()) {
            this.wxw.stopTimer();
          }
          this.wAj = false;
          if (!com.tencent.mm.plugin.offline.c.a.dxj()) {
            break label1585;
          }
          i = 0;
          break;
        }
        if (8 == paramc.wyQ)
        {
          if (this.wAP.fkZ()) {
            break label1585;
          }
          this.wAP.stopTimer();
          i = 1;
          break;
        }
        if (23 == paramc.wyQ)
        {
          if (this.wAP.fkZ()) {
            break label420;
          }
          this.wAP.stopTimer();
          i = 0;
          break;
        }
        if (20 == paramc.wyQ)
        {
          this.wAj = false;
          if (this.wAP.fkZ()) {
            break label420;
          }
          this.wAP.stopTimer();
          i = 0;
          break;
        }
        if (24 != paramc.wyQ) {
          break label1585;
        }
        if (com.tencent.mm.plugin.offline.c.a.dxJ())
        {
          this.wAj = true;
          if (com.tencent.mm.plugin.offline.c.a.dxJ())
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
          localObject1 = this.wAP;
          long l = com.tencent.mm.plugin.offline.g.dwk();
          ((av)localObject1).az(l, l);
          label420:
          i = 0;
          break;
          label425:
          if (!this.mTipDialog.isShowing()) {
            this.mTipDialog.show();
          }
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + paramc.wyQ);
        if (paramc.wyQ == 24) {
          ((c)localObject1).nKv.vibrate(50L);
        }
        if (4 == paramc.wyQ)
        {
          ((c)localObject1).a((s.b)paramc);
          com.tencent.mm.plugin.offline.g.dwl();
        }
        else
        {
          if (5 == paramc.wyQ)
          {
            paramc = (s.e)paramc;
            if (paramc != null)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + paramc.wyT + " msg.wxRetMsg:" + paramc.wyU + " msg.cftRetCode:" + paramc.wyT + " msg.cftRetMsg:" + paramc.wyS);
              if ((!TextUtils.isEmpty(paramc.wyT)) || (!TextUtils.isEmpty(paramc.wyU)) || (!TextUtils.isEmpty(paramc.wyR)) || (!TextUtils.isEmpty(paramc.wyS)))
              {
                if ((!TextUtils.isEmpty(paramc.wyT)) || (!TextUtils.isEmpty(paramc.wyU)) || (TextUtils.isEmpty(paramc.wyR)) || (TextUtils.isEmpty(paramc.wyS))) {
                  break label706;
                }
                b.d(((c)localObject1).mActivity, paramc.wyS);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.offline.g.dwl();
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 0L, 1L, true);
              break;
              label706:
              if ((!TextUtils.isEmpty(paramc.wyT)) && (com.tencent.mm.plugin.offline.c.a.isNumeric(paramc.wyT))) {
                ((c)localObject1).a(null, bt.getInt(paramc.wyT, 0), paramc.wyU, paramc.wyV);
              } else {
                b.d(((c)localObject1).mActivity, paramc.wyU);
              }
            }
          }
          Object localObject2;
          if (6 == paramc.wyQ)
          {
            paramc = (s.f)paramc;
            int j;
            if (paramc != null)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + paramc.wyX);
              com.tencent.mm.plugin.offline.k.dwq();
              localObject2 = com.tencent.mm.plugin.offline.k.dwu().atD(paramc.wyY.dlu);
              if (localObject2 == null) {
                break label944;
              }
              if (((com.tencent.mm.plugin.offline.a.r)localObject2).field_status != com.tencent.mm.plugin.offline.g.wxc) {
                break label939;
              }
              j = 1;
            }
            for (;;)
            {
              if (j == 0)
              {
                com.tencent.mm.plugin.offline.g.eA(paramc.wyY.dlu, com.tencent.mm.plugin.offline.g.wxc);
                com.tencent.mm.plugin.offline.c.a.a(((c)localObject1).mActivity, paramc);
                ((c)localObject1).mActivity.setResult(-1);
                ((c)localObject1).mActivity.finish();
              }
              com.tencent.mm.plugin.offline.g.dwl();
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 7L, 1L, true);
              if (com.tencent.mm.plugin.offline.c.a.wBz != 4) {
                break;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
              com.tencent.mm.plugin.report.service.g.yhR.f(13412, new Object[0]);
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
          if (8 == paramc.wyQ)
          {
            paramc = (s.g)paramc;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + paramc.id);
            if (paramc.pjQ == 0)
            {
              localObject2 = ((c)localObject1).mActivity.getLayoutInflater().inflate(2131495993, null);
              localObject3 = (TextView)((View)localObject2).findViewById(2131303150);
              localObject4 = (TextView)((View)localObject2).findViewById(2131303153);
              ((TextView)localObject3).setText(paramc.wza);
              ((TextView)localObject4).setText(paramc.wyZ);
              com.tencent.mm.plugin.offline.g.eA(paramc.dve, com.tencent.mm.plugin.offline.g.wxe);
              h.a(((c)localObject1).mActivity, "", (View)localObject2, ((c)localObject1).getString(2131765972), ((c)localObject1).getString(2131755691), new c.11((c)localObject1, paramc), new c.12((c)localObject1, paramc));
            }
            else if (paramc.pjQ == 1)
            {
              if (((c)localObject1).wzr != null) {
                ((c)localObject1).wzr.show();
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(13955, new Object[] { Integer.valueOf(1) });
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + paramc.id);
              com.tencent.mm.plugin.offline.g.eA(paramc.dve, com.tencent.mm.plugin.offline.g.wxe);
              ((c)localObject1).wzr = com.tencent.mm.plugin.wallet_core.ui.s.a(((c)localObject1).mActivity, paramc.wyZ, paramc.wza, new c.13((c)localObject1, paramc), new c.14((c)localObject1), new c.15((c)localObject1, paramc));
              ((c)localObject1).wzr.yqw.setVisibility(0);
              ((c)localObject1).wzr.yea.setVisibility(8);
            }
          }
          else
          {
            if (23 == paramc.wyQ)
            {
              paramc = (s.d)paramc;
              localObject2 = new PayInfo();
              ((PayInfo)localObject2).dlu = paramc.dve;
              ((PayInfo)localObject2).dCC = 8;
              ((PayInfo)localObject2).FlX = 1;
              ((PayInfo)localObject2).htZ = new Bundle();
              ((PayInfo)localObject2).htZ.putLong("extinfo_key_9", System.currentTimeMillis());
              com.tencent.mm.wallet_core.b.fQJ();
              boolean bool1;
              label1386:
              String str;
              if ((com.tencent.mm.wallet_core.b.b(b.a.qwl, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_OFFLINE_PAY_SWTICH_KEY")))
              {
                bool1 = true;
                boolean bool2 = bool1;
                if (bool1)
                {
                  com.tencent.mm.wallet_core.b.fQJ();
                  bool2 = com.tencent.mm.wallet_core.b.b(b.a.qzD, false);
                }
                if (!bool2) {
                  break label1490;
                }
                localObject3 = (com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class);
                localObject4 = ((c)localObject1).mActivity;
                str = ((PayInfo)localObject2).dlu;
                if (((c)localObject1).wzq != null) {
                  break label1476;
                }
              }
              label1476:
              for (paramc = "";; paramc = ((c)localObject1).wzq.dwB())
              {
                ((com.tencent.mm.pluginsdk.wallet.a)localObject3).startOfflinePay((Context)localObject4, str, paramc, ((PayInfo)localObject2).channel);
                break;
                bool1 = false;
                break label1386;
              }
              label1490:
              paramc = new c.1((c)localObject1, (PayInfo)localObject2);
              com.tencent.mm.sdk.b.a.IbL.b(paramc);
              localObject3 = ((c)localObject1).mActivity;
              if (((c)localObject1).wzq == null) {}
              for (paramc = "";; paramc = ((c)localObject1).wzq.dwB())
              {
                com.tencent.mm.pluginsdk.wallet.f.a((Context)localObject3, false, "", paramc, (PayInfo)localObject2, "", new Intent(), 1);
                break;
              }
            }
            if (20 == paramc.wyQ) {
              com.tencent.mm.plugin.offline.g.dwl();
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
    if (((paramDialog instanceof com.tencent.mm.ui.widget.a.d)) && (this.wAm))
    {
      this.wAn = true;
      paramDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(184850);
          if (this.wAX != null) {
            this.wAX.onDismiss(paramAnonymousDialogInterface);
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
  
  public final void bUh()
  {
    AppMethodBeat.i(66512);
    Mk(0);
    pk(true);
    AppMethodBeat.o(66512);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public final void dwA()
  {
    AppMethodBeat.i(66515);
    doSceneProgress(new j(""), false);
    AppMethodBeat.o(66515);
  }
  
  public final String dwB()
  {
    return this.wwO;
  }
  
  public final void dwC()
  {
    AppMethodBeat.i(66518);
    if (!this.wxw.fkZ()) {
      this.wxw.stopTimer();
    }
    Mk(0);
    pk(true);
    this.wAj = false;
    av localav = this.wxw;
    long l = this.wxv;
    localav.az(l, l);
    AppMethodBeat.o(66518);
  }
  
  public final void dwR()
  {
    int j = 0;
    AppMethodBeat.i(66498);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.dxk();
    findViewById(2131306839).setVisibility(0);
    this.wzR.setTextSize(0, getResources().getDimensionPixelSize(2131165517));
    String str;
    Object localObject;
    if ((this.wzR != null) && (localBankcard != null)) {
      if (localBankcard.eEW())
      {
        str = localBankcard.CVa;
        localObject = t.eFy().eGv();
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
        } while (!((com.tencent.mm.plugin.wallet_core.model.c)localObject).wBI.equals(localBankcard.field_bindSerial));
      }
    }
    for (;;)
    {
      if ((localObject != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.wallet_core.model.c)localObject).CUo)))
      {
        if (!localBankcard.eEW()) {
          str = localBankcard.field_desc + ((com.tencent.mm.plugin.wallet_core.model.c)localObject).CUo;
        }
        findViewById(2131306839).setVisibility(8);
        com.tencent.mm.plugin.report.service.g.yhR.f(14515, new Object[] { Integer.valueOf(2) });
        this.wzR.setTextSize(0, getResources().getDimensionPixelSize(2131165466));
      }
      for (int i = 1;; i = 0)
      {
        this.wzR.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), str, this.wzR.getTextSize()));
        for (;;)
        {
          if (localBankcard != null) {
            a(localBankcard);
          }
          if (i != 0) {
            this.wzS.setImageResource(2131690126);
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
  
  public final void dwY()
  {
    AppMethodBeat.i(66505);
    this.wzT.setVisibility(4);
    this.wAv.a(this.wzL, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174394);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.offline.c.a.dxu();
        com.tencent.mm.plugin.offline.c.a.k(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this));
        WalletOfflineCoinPurseUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174394);
      }
    });
    AppMethodBeat.o(66505);
  }
  
  public final void dwz()
  {
    AppMethodBeat.i(66514);
    pl(false);
    AppMethodBeat.o(66514);
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66513);
    doSceneProgress(new com.tencent.mm.plugin.offline.a.e(paramInt, paramString1, paramString2, paramString3), com.tencent.mm.plugin.offline.c.a.dxj());
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
    this.wAv = ((OfflineAlertView)findViewById(2131302989));
    this.wAv.dismiss();
    this.wAv.setDialogState(new OfflineAlertView.a()
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
    com.tencent.mm.wallet_core.c.b.fRq().init(getApplicationContext());
    Object localObject;
    if ((this.mEntryScene == 3) || (this.mEntryScene == 10) || (this.mEntryScene == 11) || (this.mEntryScene == 12))
    {
      setMMTitle(2131765959);
      this.wAu = new c(this, this);
      localObject = this.wAu;
      ((c)localObject).nKv = ((Vibrator)((c)localObject).mActivity.getSystemService("vibrator"));
      this.wAt = new com.tencent.mm.wallet_core.ui.c(this, true);
      this.wAt.fRV();
      this.wzL = findViewById(2131306828);
      this.wzM = ((ImageView)findViewById(2131306827));
      this.wzN = ((ImageView)findViewById(2131306693));
      this.wzO = ((TextView)findViewById(2131306694));
      this.wzQ = findViewById(2131306838);
      this.wzR = ((TextView)findViewById(2131306840));
      this.wzS = ((ImageView)findViewById(2131306837));
      this.wzT = ((RelativeLayout)findViewById(2131306763));
      this.wzU = ((LinearLayout)findViewById(2131306843));
      this.wzV = ((CdnImageView)findViewById(2131306844));
      this.wzW = ((TextView)findViewById(2131306842));
      this.wzX = ((TextView)findViewById(2131306841));
      this.wzT.setOnClickListener(new WalletOfflineCoinPurseUI.8(this));
      this.wzM.setOnClickListener(this.jtG);
      this.wzN.setOnClickListener(this.jtG);
      this.wzO.setOnClickListener(this.jtG);
      this.wzQ.setClickable(true);
      this.wzQ.setOnClickListener(new WalletOfflineCoinPurseUI.9(this));
      this.mLastTime = System.currentTimeMillis();
      this.wzY = new e();
      this.wzY.dkE();
      com.tencent.mm.plugin.newtips.a.dun().h(this.wzY);
      this.wzZ = new g();
      this.wzZ.dkE();
      com.tencent.mm.plugin.newtips.a.dun().h(this.wzZ);
      this.wAa = new b();
      this.wAa.dkE();
      com.tencent.mm.plugin.newtips.a.dun().h(this.wAa);
      this.wAb = new f();
      this.wAb.dkE();
      com.tencent.mm.plugin.newtips.a.dun().h(this.wAb);
      this.wAc = new d();
      this.wAc.dkE();
      com.tencent.mm.plugin.newtips.a.dun().h(this.wAc);
      if ((this.mEntryScene != 3) && (this.mEntryScene != 10) && (this.mEntryScene != 11) && (this.mEntryScene != 12)) {
        break label901;
      }
      this.wAd.setVisibility(8);
      this.wAe.setVisibility(8);
      this.wAf.setVisibility(8);
      this.wAg.setVisibility(8);
      label613:
      if ((com.tencent.mm.plugin.offline.c.a.dxi()) && (c.dwE()))
      {
        localObject = this.wAu;
        com.tencent.mm.plugin.offline.k.dwq();
        ((c)localObject).a(com.tencent.mm.plugin.offline.k.dwr().wyJ);
      }
      dwK();
      Y(true, false);
      localObject = this.wxw;
      long l1 = this.wxv;
      ((av)localObject).az(l1, l1);
      if ((com.tencent.mm.plugin.offline.c.a.wBz != 3) || (!com.tencent.mm.plugin.offline.c.a.wBC)) {
        break label1134;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
      int i = com.tencent.mm.plugin.offline.c.a.wBA;
      l1 = com.tencent.mm.plugin.offline.c.a.wBB;
      long l2 = System.currentTimeMillis();
      long l3 = i * 1000 + l1 - l2;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + l1 + " now:" + l2 + " interval:" + l3);
      if ((com.tencent.mm.plugin.offline.c.a.wBA <= 0) || (com.tencent.mm.plugin.offline.c.a.wBB <= 0L) || (l3 <= 0L)) {
        break label1122;
      }
      if (!this.wAQ.fkZ()) {
        this.wAQ.stopTimer();
      }
      this.wAQ.az(l3, l3);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
    }
    for (;;)
    {
      dwJ();
      localObject = new yi();
      ((yi)localObject).dMB.scene = "5";
      ((yi)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66407);
          if (!bt.isNullOrNil(this.pfP.dMC.dMD))
          {
            com.tencent.mm.wallet_core.ui.e.a((TextView)WalletOfflineCoinPurseUI.this.findViewById(2131297186), this.pfP.dMC.dMD, this.pfP.dMC.content, this.pfP.dMC.url);
            AppMethodBeat.o(66407);
            return;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
          AppMethodBeat.o(66407);
        }
      };
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(66477);
      return;
      setMMTitle(2131765960);
      break;
      label901:
      this.wAg.setVisibility(0);
      this.wAh.setVisibility(0);
      final boolean bool1 = com.tencent.mm.plugin.newtips.a.g.b(this.wzY);
      final boolean bool2 = com.tencent.mm.plugin.newtips.a.g.b(this.wAa);
      final boolean bool3 = com.tencent.mm.plugin.newtips.a.g.b(this.wAb);
      final boolean bool4 = com.tencent.mm.plugin.newtips.a.g.b(this.wzZ);
      final boolean bool5 = com.tencent.mm.plugin.newtips.a.g.b(this.wAc);
      if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBN, Boolean.FALSE)).booleanValue()) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
      }
      ImageView localImageView;
      for (;;)
      {
        localObject = (TextView)findViewById(2131297128);
        localImageView = (ImageView)findViewById(2131297127);
        if (!this.wAz) {
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
            int i = al.ci(WalletOfflineCoinPurseUI.this.getContext()).y;
            int j = i;
            if (al.jR(WalletOfflineCoinPurseUI.this.getContext()))
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
              j = i - al.ej(WalletOfflineCoinPurseUI.this.getContext());
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
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBN, Boolean.TRUE);
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
      if (com.tencent.mm.plugin.offline.c.a.wBz == 3) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
      } else {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.c.a.wBz) });
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
    final ImageView localImageView = (ImageView)this.wzA.get(paramString);
    paramString = (Integer)this.wzB.get(paramString);
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
        Bitmap localBitmap = com.tencent.mm.sdk.platformtools.g.a(paramBitmap, i, i, true, false);
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
    t.eFs();
    this.wAz = t.eFH();
    com.tencent.mm.plugin.offline.k.wxG = true;
    com.tencent.mm.wallet_core.ui.e.agr(41);
    paramBundle = getIntent();
    this.wAl = paramBundle.getBooleanExtra("is_offline_create", false);
    if ((paramBundle != null) && (paramBundle.hasExtra("key_entry_scene"))) {
      this.mEntryScene = paramBundle.getIntExtra("key_entry_scene", this.mEntryScene);
    }
    this.fPp = paramBundle.getIntExtra("key_from_scene", 0);
    this.wzP = bt.bI(paramBundle.getStringExtra("key_business_attach"), "");
    this.rgD = 1;
    if (this.mEntryScene == 2) {
      this.rgD = 1;
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
          paramAnonymousMenuItem = new hz();
          paramAnonymousMenuItem.dux.duy = "ok";
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
          if (WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this) == 8) {
            com.tencent.mm.plugin.offline.c.a.atU(WalletOfflineCoinPurseUI.this.getIntent().getStringExtra("key_appid"));
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
        if (i == 0) {
          bh.a(this, null);
        }
        com.tencent.mm.wallet_core.ui.e.fSa();
        if (t.eFy().eGf())
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
          initView();
          paramBundle = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.ICP, "");
          if (bt.isNullOrNil(paramBundle)) {}
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
              this.wAE = com.tencent.mm.plugin.wallet_core.model.r.bj(new JSONObject(paramBundle));
              com.tencent.mm.platformtools.u.a(this);
              com.tencent.mm.plugin.offline.k.dwq();
              com.tencent.mm.plugin.offline.k.dwr().a(this);
              addSceneEndListener(606);
              addSceneEndListener(609);
              addSceneEndListener(1501);
              com.tencent.mm.plugin.offline.k.dwq();
              com.tencent.mm.plugin.offline.k.dws().dC(this);
              com.tencent.mm.sdk.b.a.IbL.c(this.wAN);
              com.tencent.mm.plugin.offline.c.a.dxv();
              com.tencent.mm.sdk.b.a.IbL.b(this.wAL);
              com.tencent.mm.sdk.b.a.IbL.b(this.wAJ);
              com.tencent.mm.sdk.b.a.IbL.b(this.wAF);
              this.wAG.alive();
              this.wAH.alive();
              this.wAI.alive();
              this.wAk = new com.tencent.mm.plugin.offline.g();
              paramBundle = new nm();
              paramBundle.dBz.aHQ = hashCode();
              com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
              this.wAK.alive();
              AppMethodBeat.o(66469);
              return;
              if (this.mEntryScene == 1)
              {
                this.rgD = 2;
                break;
              }
              if (this.mEntryScene == 8)
              {
                this.rgD = 4;
                break;
              }
              if (this.mEntryScene == 4)
              {
                this.rgD = 6;
                break;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[] { Integer.valueOf(this.rgD) });
              break;
              paramBundle = paramBundle;
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", paramBundle, "", new Object[0]);
              getWindow().setFlags(8192, 8192);
              int i = 0;
              continue;
              if (!t.eFy().eGc()) {
                break label628;
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
              com.tencent.mm.plugin.offline.c.a.dxu();
              com.tencent.mm.plugin.offline.k.dwq();
              com.tencent.mm.plugin.offline.k.bz(196648, "0");
            }
          } while ((!t.eFy().eGa()) || (!com.tencent.mm.plugin.offline.c.a.dxi()));
          dxc();
        }
        catch (JSONException paramBundle)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", paramBundle, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66475);
    Object localObject = com.tencent.mm.plugin.offline.c.a.dxk();
    if (localObject != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerial:%s serial:%s mLastBindSerial:%s", new Object[] { this.wwO, ((Bankcard)localObject).field_bindSerial, this.wzK });
      if (((Bankcard)localObject).eEW())
      {
        localObject = this.wzK;
        bt.isNullOrNil(this.wzK);
        com.tencent.mm.plugin.offline.c.a.atJ((String)localObject);
        com.tencent.mm.plugin.offline.k.dwq();
        com.tencent.mm.plugin.offline.k.dws().wwO = ((String)localObject);
      }
    }
    this.wAv.dismiss();
    com.tencent.mm.plugin.offline.k.wxG = false;
    com.tencent.mm.wallet_core.ui.e.T(this.wzC);
    com.tencent.mm.wallet_core.ui.e.T(this.wzD);
    com.tencent.mm.wallet_core.ui.e.aZ(this.wAr);
    com.tencent.mm.wallet_core.ui.e.aZ(this.wAs);
    this.wAr.clear();
    this.wAs.clear();
    this.wzH.clear();
    this.wzI.clear();
    this.wzJ.clear();
    com.tencent.mm.platformtools.u.c(this);
    com.tencent.mm.plugin.offline.k.dwq();
    com.tencent.mm.plugin.offline.k.dwr().b(this);
    removeSceneEndListener(606);
    removeSceneEndListener(609);
    removeSceneEndListener(1501);
    com.tencent.mm.plugin.offline.k.dwq();
    com.tencent.mm.plugin.offline.k.dws().dD(this);
    com.tencent.mm.sdk.b.a.IbL.d(this.wAN);
    com.tencent.mm.sdk.b.a.IbL.d(this.wAL);
    com.tencent.mm.sdk.b.a.IbL.d(this.wAF);
    if (!this.wxw.fkZ()) {
      this.wxw.stopTimer();
    }
    if (!this.wAQ.fkZ()) {
      this.wAQ.stopTimer();
    }
    if (this.wAt != null) {
      this.wAt.release();
    }
    if (this.wAu != null)
    {
      localObject = this.wAu;
      ((c)localObject).nKv.cancel();
      ((c)localObject).mActivity = null;
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.wAJ);
    this.wAH.dead();
    this.wAI.dead();
    localObject = this.wAk;
    ((com.tencent.mm.plugin.offline.g)localObject).stop();
    com.tencent.mm.plugin.offline.g.dwl();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(385, ((com.tencent.mm.plugin.offline.g)localObject).wxg);
    ((com.tencent.mm.plugin.offline.g)localObject).wxi = null;
    this.wAK.dead();
    this.wAG.dead();
    com.tencent.mm.plugin.remittance.mobile.a.b.NY(0);
    super.onDestroy();
    AppMethodBeat.o(66475);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66517);
    if ((paramInt == 4) && (this.wAv != null) && (this.wAv.getVisibility() == 0) && (this.wAv.wzd))
    {
      this.wAv.dismiss();
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
    this.wzF = true;
    AppMethodBeat.o(66473);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66474);
    com.tencent.mm.plugin.offline.k.dwq();
    com.tencent.mm.plugin.offline.i locali = com.tencent.mm.plugin.offline.k.dwt();
    locali.mHandler.removeCallbacks(locali.wxu);
    bh.a(this, null);
    this.cEv = false;
    com.tencent.mm.sdk.b.a.IbL.d(this.wAM);
    this.wAk.stop();
    super.onPause();
    AppMethodBeat.o(66474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66471);
    super.onResume();
    com.tencent.mm.sdk.b.a.IbL.c(this.wAM);
    try
    {
      bh.a(this, this);
      if (!this.wAw)
      {
        dwG();
        this.wAw = true;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
      this.cEv = true;
      Object localObject = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).a(this, ((com.tencent.mm.plugin.walletlock.a.b)localObject).eJn(), null);
      if (ay.isNetworkConnected(getBaseContext()))
      {
        if (t.eFy().eGf()) {
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 8));
        }
        if ((com.tencent.mm.plugin.offline.c.a.dxi()) && (this.wAD))
        {
          com.tencent.mm.plugin.offline.k.dwq();
          com.tencent.mm.plugin.offline.k.dwt().pj(false);
          if (!c.dwE()) {
            doSceneProgress(new com.tencent.mm.plugin.offline.a.q(this.mEntryScene, this.dtK, this.wAA), false);
          }
        }
      }
      if (!this.wAD) {
        this.wAD = true;
      }
      dwK();
      localObject = com.tencent.mm.plugin.offline.c.a.dxk();
      if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (!((Bankcard)localObject).field_bindSerial.equals(this.wwO)))
      {
        this.wwO = ((Bankcard)localObject).field_bindSerial;
        com.tencent.mm.plugin.offline.k.dwq();
        com.tencent.mm.plugin.offline.k.dws().wwO = this.wwO;
        i = 1;
        if ((i != 0) || ((this.wzG) && (this.wzF)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
          this.wzG = false;
          this.wzF = false;
          dwR();
          Mk(0);
          pk(true);
        }
        localObject = this.wAk;
        if (!com.tencent.mm.plugin.offline.c.a.dxJ()) {
          break label511;
        }
        com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.offline.g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + ((com.tencent.mm.plugin.offline.g)localObject).wxi.fkZ());
        if ((((com.tencent.mm.plugin.offline.g)localObject).wxi == null) || (((com.tencent.mm.plugin.offline.g)localObject).wxi.fkZ()))
        {
          ((com.tencent.mm.plugin.offline.g)localObject).status = 1;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 61L, 1L, true);
          if (!((com.tencent.mm.plugin.offline.g)localObject).wxh) {
            break label485;
          }
          com.tencent.mm.plugin.offline.g.dwl();
          localObject = ((com.tencent.mm.plugin.offline.g)localObject).wxi;
          l = com.tencent.mm.plugin.offline.g.wwR;
          ((av)localObject).az(l, l);
          i = com.tencent.mm.plugin.offline.g.wwR;
        }
        if (this.wAB)
        {
          this.wAB = false;
          com.tencent.mm.plugin.report.service.g.yhR.f(18930, new Object[] { Integer.valueOf(this.wAC), Integer.valueOf(4) });
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
        av localav = localException.wxi;
        long l = com.tencent.mm.plugin.offline.g.wxf;
        localav.az(l, l);
        i = com.tencent.mm.plugin.offline.g.wxf;
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
      this.wxt.dwv();
      this.wxt = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
      {
        if (this.wAx)
        {
          this.wAx = false;
          paramString = com.tencent.mm.plugin.offline.c.a.dxl();
          if (paramString != null) {
            doSceneForceProgress(new com.tencent.mm.plugin.offline.a.k(paramString, this.wAy, 0));
          }
          AppMethodBeat.o(66476);
          return true;
        }
        if (com.tencent.mm.plugin.offline.c.a.dxi())
        {
          if (com.tencent.mm.plugin.offline.c.a.dxl() != null) {
            doSceneProgress(new com.tencent.mm.plugin.offline.a.n(System.currentTimeMillis(), this.mEntryScene), false);
          }
          dxc();
        }
        paramString = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).CPs;
        if ((paramString == null) || (paramString.CXy == 0))
        {
          if (this.wAv.wzc == 7) {
            this.wAv.dismiss();
          }
          this.wAE = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).CPt;
          dwZ();
          dxb();
          label288:
          if ((!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.n)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.a)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.e))) {
            break label1457;
          }
          dwK();
          Y(false, true);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66476);
      return true;
      if (!this.wAv.Mj(7)) {
        break;
      }
      if (this.wAv.wzc == 7) {
        this.wAv.dismiss();
      }
      this.wAC = paramString.CXx;
      Object localObject1 = this.wAv;
      View localView = this.wzL;
      Object localObject2 = new WalletOfflineCoinPurseUI.25(this);
      com.tencent.mm.plugin.report.service.g.yhR.f(18930, new Object[] { Integer.valueOf(paramString.CXx), Integer.valueOf(1) });
      ((OfflineAlertView)localObject1).wzc = 7;
      ((OfflineAlertView)localObject1).setVisibility(0);
      ((OfflineAlertView)localObject1).wzd = false;
      ((OfflineAlertView)localObject1).iLQ.removeAllViews();
      Object localObject3 = LayoutInflater.from(((OfflineAlertView)localObject1).getContext()).inflate(2131495990, ((OfflineAlertView)localObject1).iLQ, false);
      ((OfflineAlertView)localObject1).iLQ.addView((View)localObject3);
      Object localObject4 = (TextView)((View)localObject3).findViewById(2131302001);
      TextView localTextView = (TextView)((View)localObject3).findViewById(2131305510);
      localObject3 = (Button)((View)localObject3).findViewById(2131300871);
      if (!bt.isNullOrNil(paramString.CXA)) {
        ((TextView)localObject4).setText(paramString.CXA);
      }
      if (!bt.isNullOrNil(paramString.CXB))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("repayment_tiny_app_username", paramString.CXC);
        ((Bundle)localObject4).putString("repayment_tiny_app_path", paramString.CXD);
        localTextView.setText(paramString.CXB);
        com.tencent.mm.pluginsdk.ui.span.k.a(localTextView, false, localObject4);
        if (((OfflineAlertView)localObject1).oca != null) {
          com.tencent.mm.pluginsdk.ui.span.k.b(((OfflineAlertView)localObject1).oca);
        }
        ((OfflineAlertView)localObject1).oca = new OfflineAlertView.3((OfflineAlertView)localObject1, (View.OnClickListener)localObject2, paramString);
        com.tencent.mm.pluginsdk.ui.span.k.a(((OfflineAlertView)localObject1).oca);
      }
      if (paramString.CXz > 0)
      {
        ((Button)localObject3).setEnabled(false);
        if (((OfflineAlertView)localObject1).wzf == null) {
          break label721;
        }
        ((OfflineAlertView)localObject1).wzf.cancel();
      }
      for (;;)
      {
        ((OfflineAlertView)localObject1).wzf.start();
        ((Button)localObject3).setOnClickListener(new OfflineAlertView.5((OfflineAlertView)localObject1, paramString));
        localView.post(new OfflineAlertView.6((OfflineAlertView)localObject1, localView));
        break;
        label721:
        localObject2 = new com.tencent.mm.wallet_core.c.c();
        ((com.tencent.mm.wallet_core.c.c)localObject2).duration = (paramString.CXz * 1000);
        ((com.tencent.mm.wallet_core.c.c)localObject2).interval = 1000L;
        ((com.tencent.mm.wallet_core.c.c)localObject2).LxK = new OfflineAlertView.4((OfflineAlertView)localObject1, (Button)localObject3);
        ((OfflineAlertView)localObject1).wzf = new com.tencent.mm.wallet_core.c.c.1((com.tencent.mm.wallet_core.c.c)localObject2, ((com.tencent.mm.wallet_core.c.c)localObject2).duration, ((com.tencent.mm.wallet_core.c.c)localObject2).interval);
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.m))
      {
        this.wxt = ((com.tencent.mm.plugin.offline.a.m)paramn);
        paramString = this.wxt.wyx;
        com.tencent.mm.plugin.offline.k.dwq();
        paramString = new com.tencent.mm.plugin.offline.a.f(paramString, com.tencent.mm.plugin.offline.k.Mi(196617));
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
        break label288;
      }
      if ((paramn instanceof j))
      {
        dwK();
        dwG();
        break label288;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.n))
      {
        paramString = (com.tencent.mm.plugin.offline.a.n)paramn;
        if ("1".equals(paramString.wyC))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
          if (bt.isNullOrNil(paramString.wyD)) {}
          for (paramString = getString(2131765224);; paramString = paramString.wyD)
          {
            h.a(this, paramString, "", false, new DialogInterface.OnClickListener()
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
        if (paramString.wxX == 0)
        {
          localObject1 = this.wAu;
          ((c)localObject1).wzs = com.tencent.mm.plugin.offline.c.a.dxp();
          ((c)localObject1).wzs = ((c)localObject1).wzs;
          if (!"1".equals(paramString.wyB)) {
            break label288;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
          doSceneProgress(new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 8), false);
          break label288;
        }
        if (paramString.wxX == 0) {
          break label288;
        }
        this.wAu.a(paramString, paramString.wxX, paramString.wxY);
        break label288;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.a)) {
        break label288;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
      {
        this.wAu.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        break label288;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
      {
        if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
          this.mTipDialog.dismiss();
        }
        paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.i)paramn;
        if (("1".equals(paramString.CSR)) || (("2".equals(paramString.CSR)) && (!bt.isNullOrNil(paramString.CSS))))
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
          if ("collect".equals(paramString.CSV)) {
            dwH();
          } else if ("reward".equals(paramString.CSV)) {
            com.tencent.mm.bs.d.Q(getContext(), "collect", ".reward.ui.QrRewardMainUI");
          } else {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { paramString.CSV });
          }
        }
      }
      if (!(paramn instanceof com.tencent.mm.plugin.offline.a.q)) {
        break label288;
      }
      paramString = (com.tencent.mm.plugin.offline.a.q)paramn;
      this.wAo = true;
      if ((paramString.isJumpRemind()) && (!this.wAp && (paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
      {
        public final void djA() {}
      }))) {
        this.wAp = true;
      }
      onSceneEnd(paramString.wyI.errType, paramString.wyI.errCode, paramString.wyI.errMsg, paramString.wyG);
      onSceneEnd(paramString.wyH.errType, paramString.wyH.errCode, paramString.wyH.errMsg, paramString.wyF);
      if ((this.mDL == null) || (!this.mDL.isShowing()) || (this.wAq != 1)) {
        break label288;
      }
      pl(true);
      break label288;
      label1457:
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.f))
      {
        dwK();
        Y(true, true);
      }
      else if ((paramn instanceof com.tencent.mm.plugin.offline.a.k))
      {
        com.tencent.mm.plugin.offline.c.a.ay(this);
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 8), false);
        dwV();
        dwW();
        dwT();
        continue;
        if ((paramn instanceof com.tencent.mm.plugin.offline.a.n))
        {
          dwK();
          Y(false, true);
          if (411 == paramInt2) {
            this.wAu.a(paramn, paramInt2, paramString);
          }
        }
        else if ((paramn instanceof com.tencent.mm.plugin.offline.a.e))
        {
          this.wAu.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        }
        else if (!(paramn instanceof j))
        {
          if ((paramn instanceof com.tencent.mm.plugin.offline.a.f))
          {
            this.wxt = null;
          }
          else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
          {
            if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
              this.mTipDialog.dismiss();
            }
          }
          else if ((paramn instanceof com.tencent.mm.plugin.offline.a.q))
          {
            dwK();
            Y(false, true);
            if (411 == paramInt2) {
              this.wAu.a(paramn, paramInt2, paramString);
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
    
    public final boolean dkE()
    {
      AppMethodBeat.i(66444);
      super.dkE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.z.c.aht().b(al.a.IBI, al.a.IAE))
      {
        this.wBe.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wsM, true);
      }
      AppMethodBeat.o(66444);
      return true;
    }
    
    public final void dxe()
    {
      AppMethodBeat.i(66443);
      WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306758));
      this.wBe = ((ImageView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296290));
      this.wBf = ((TextView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296301));
      this.wBg = ((ImageView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131296300));
      WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineAALayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
          com.tencent.mm.plugin.newtips.a.dun().LQ(16);
          com.tencent.mm.plugin.report.service.g.yhR.f(14021, new Object[] { Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          paramAnonymousView = new Intent();
          if (WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this) == 1) {
            paramAnonymousView.putExtra("enter_scene", 2);
          }
          for (;;)
          {
            com.tencent.mm.bs.d.b(WalletOfflineCoinPurseUI.this.getContext(), "aa", ".ui.AAEntranceUI", paramAnonymousView);
            WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
            if (com.tencent.mm.z.c.aht().b(al.a.IBI, al.a.IAE))
            {
              com.tencent.mm.z.c.aht().c(al.a.IBI, al.a.IAE);
              WalletOfflineCoinPurseUI.b.this.wBe.setVisibility(8);
              com.tencent.mm.plugin.report.service.g.yhR.f(14396, new Object[] { Integer.valueOf(4) });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineAALayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    ArrayList<String> mDataList;
    ArrayList<Boolean> wBi;
    
    public c()
    {
      AppMethodBeat.i(66446);
      this.mDataList = new ArrayList();
      this.wBi = new ArrayList();
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
      if (WalletOfflineCoinPurseUI.dxd() == paramInt)
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
      boolean bool = ((Boolean)this.wBi.get(paramInt)).booleanValue();
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
    
    public final void dxe()
    {
      AppMethodBeat.i(66452);
      WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306759));
      this.wBe = ((ImageView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297132));
      this.wBf = ((TextView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297134));
      this.wBg = ((ImageView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131297133));
      WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66451);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineBankRemitLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = new hj();
          paramAnonymousView.dPl = 3L;
          paramAnonymousView.aLk();
          com.tencent.mm.plugin.newtips.a.dun().LQ(20);
          com.tencent.mm.plugin.remittance.mobile.a.b.NY(WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this));
          if (WalletOfflineCoinPurseUI.Y(WalletOfflineCoinPurseUI.this)) {
            com.tencent.mm.bs.d.Q(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".mobile.ui.BankMobileRemittanceChooseUI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineBankRemitLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66451);
            return;
            com.tencent.mm.bs.d.Q(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
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
    
    public final boolean dkE()
    {
      AppMethodBeat.i(66457);
      super.dkE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.z.c.aht().b(al.a.IBJ, al.a.IAE))
      {
        com.tencent.mm.kernel.g.ajD();
        String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAY, "");
        if (bt.isNullOrNil(str)) {
          break label98;
        }
        this.wBf.setText(str);
        this.wBf.setVisibility(0);
        this.wBg.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wsN, true);
      }
      for (;;)
      {
        AppMethodBeat.o(66457);
        return true;
        label98:
        this.wBe.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wsM, true);
      }
    }
    
    public final void dxe()
    {
      AppMethodBeat.i(66456);
      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306761));
      this.wBe = ((ImageView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299650));
      this.wBf = ((TextView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299652));
      this.wBg = ((ImageView)WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).findViewById(2131299651));
      WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66455);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.dun().LQ(17);
          if (com.tencent.mm.z.c.aht().b(al.a.IBJ, al.a.IAE))
          {
            com.tencent.mm.z.c.aht().c(al.a.IBJ, al.a.IAE);
            WalletOfflineCoinPurseUI.e.this.wBe.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.wBf.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.wBg.setVisibility(8);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAY, "");
            com.tencent.mm.plugin.report.service.g.yhR.f(14396, new Object[] { Integer.valueOf(3) });
          }
          if (t.eFy().eGa())
          {
            WalletOfflineCoinPurseUI.U(WalletOfflineCoinPurseUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66455);
            return;
          }
          t.eFs();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          localObject = WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this);
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
    
    public final boolean dkE()
    {
      AppMethodBeat.i(66461);
      super.dkE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.z.c.aht().b(al.a.IBK, al.a.IAE))
      {
        this.wBe.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wsM, true);
      }
      AppMethodBeat.o(66461);
      return true;
    }
    
    public final void dxe()
    {
      AppMethodBeat.i(66460);
      WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306762));
      this.wBe = ((ImageView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299640));
      this.wBf = ((TextView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299642));
      this.wBg = ((ImageView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131299641));
      WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66459);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineF2fLuckyLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.dun().LQ(18);
          com.tencent.mm.plugin.report.service.g.yhR.f(14021, new Object[] { Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          com.tencent.mm.bs.d.Q(WalletOfflineCoinPurseUI.this.getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
          if (com.tencent.mm.z.c.aht().b(al.a.IBK, al.a.IAE))
          {
            com.tencent.mm.z.c.aht().c(al.a.IBK, al.a.IAE);
            WalletOfflineCoinPurseUI.f.this.wBe.setVisibility(8);
            com.tencent.mm.plugin.report.service.g.yhR.f(14396, new Object[] { Integer.valueOf(5) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineF2fLuckyLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    
    public final boolean dkE()
    {
      AppMethodBeat.i(66467);
      super.dkE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.z.c.aht().b(al.a.IBL, al.a.IAE))
      {
        this.wBe.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wsM, true);
      }
      AppMethodBeat.o(66467);
      return true;
    }
    
    public final void dxe()
    {
      AppMethodBeat.i(66465);
      WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131306764));
      this.wBe = ((ImageView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303608));
      this.wBf = ((TextView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303610));
      this.wBg = ((ImageView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131303609));
      WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66464);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.dun().LQ(19);
          com.tencent.mm.plugin.report.service.g.yhR.f(14021, new Object[] { Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this)) });
          if (com.tencent.mm.z.c.aht().b(al.a.IBL, al.a.IAE))
          {
            com.tencent.mm.z.c.aht().c(al.a.IBL, al.a.IAE);
            WalletOfflineCoinPurseUI.g.this.wBe.setVisibility(8);
          }
          if (t.eFy().eGa())
          {
            com.tencent.mm.bs.d.Q(WalletOfflineCoinPurseUI.this.getContext(), "collect", ".reward.ui.QrRewardMainUI");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66464);
            return;
          }
          t.eFs();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          localObject = WalletOfflineCoinPurseUI.X(WalletOfflineCoinPurseUI.this);
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