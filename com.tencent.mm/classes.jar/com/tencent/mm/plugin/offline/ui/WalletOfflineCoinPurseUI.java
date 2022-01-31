package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ck;
import com.tencent.mm.h.a.kw;
import com.tencent.mm.h.a.kx;
import com.tencent.mm.h.a.lk;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.h.a.tm;
import com.tencent.mm.h.a.tp;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.b;
import com.tencent.mm.plugin.offline.a.s.c;
import com.tencent.mm.plugin.offline.a.s.d;
import com.tencent.mm.plugin.offline.a.s.e;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.ay.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.j
public class WalletOfflineCoinPurseUI
  extends WalletBaseUI
  implements x.a, s.a, com.tencent.mm.plugin.offline.b, a, ay.a
{
  private static int hnL = 0;
  private boolean bqV;
  private int drX;
  private int fgD = -1;
  private View.OnClickListener fvj = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView.getId() == a.f.wallet_qrcode_iv) || (paramAnonymousView.getId() == a.f.wallet_barcode_iv) || (paramAnonymousView.getId() == a.f.wallet_barcode_tv))
      {
        if ((paramAnonymousView.getId() != a.f.wallet_qrcode_iv) || (WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this) == null) || (!WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this).isShowing())) {
          break label71;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
      }
      label71:
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (((WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this).isShowing())) || (l - WalletOfflineCoinPurseUI.v(WalletOfflineCoinPurseUI.this) < 400L) || (!com.tencent.mm.plugin.offline.c.a.bqH()) || (WalletOfflineCoinPurseUI.w(WalletOfflineCoinPurseUI.this)));
      if (paramAnonymousView.getId() == a.f.wallet_qrcode_iv) {
        WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, false);
      }
      for (;;)
      {
        if (WalletOfflineCoinPurseUI.x(WalletOfflineCoinPurseUI.this) != null)
        {
          WalletOfflineCoinPurseUI.y(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.x(WalletOfflineCoinPurseUI.this).y(paramAnonymousView, WalletOfflineCoinPurseUI.z(WalletOfflineCoinPurseUI.this));
        }
        WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, l);
        return;
        if ((paramAnonymousView.getId() == a.f.wallet_barcode_iv) || (paramAnonymousView.getId() == a.f.wallet_barcode_tv))
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(13958, new Object[] { Integer.valueOf(4) });
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, true);
        }
      }
    }
  };
  private boolean isF = true;
  private int jNi;
  private String mJH = "";
  private String mKk = "";
  private com.tencent.mm.plugin.offline.a.m mKm;
  private int mKo = 60000;
  private am mKp = new am(new am.a()
  {
    public final boolean tC()
    {
      if (!WalletOfflineCoinPurseUI.M(WalletOfflineCoinPurseUI.this))
      {
        WalletOfflineCoinPurseUI.D(WalletOfflineCoinPurseUI.this);
        WalletOfflineCoinPurseUI.E(WalletOfflineCoinPurseUI.this);
      }
      am localam = WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this);
      long l = WalletOfflineCoinPurseUI.N(WalletOfflineCoinPurseUI.this);
      localam.S(l, l);
      return false;
    }
  }, false);
  private long mLastTime = 0L;
  private View mMA;
  private TextView mMB;
  private ImageView mMC;
  RelativeLayout mMD;
  private LinearLayout mME;
  private LinearLayout mMF;
  private LinearLayout mMG;
  private LinearLayout mMH;
  private LinearLayout mMI;
  private Dialog mMJ;
  private String mMK = "";
  private boolean mML = false;
  private com.tencent.mm.plugin.offline.g mMM;
  private boolean mMN = false;
  private boolean mMO = false;
  private boolean mMP = false;
  private boolean mMQ = false;
  private ArrayList<Bitmap> mMR = new ArrayList();
  private ArrayList<Bitmap> mMS = new ArrayList();
  private com.tencent.mm.wallet_core.ui.c mMT;
  private c mMU;
  OfflineAlertView mMV;
  private boolean mMW = false;
  com.tencent.mm.sdk.b.c<tp> mMX = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.sdk.b.c<ck> mMY = new WalletOfflineCoinPurseUI.12(this);
  private com.tencent.mm.sdk.b.c<lk> mMZ = new WalletOfflineCoinPurseUI.23(this);
  private HashMap<String, View> mMl = new HashMap();
  private HashMap<String, Integer> mMm = new HashMap();
  Bitmap mMn = null;
  Bitmap mMo = null;
  private WalletOfflineCoinPurseUI.a mMp;
  private boolean mMq = false;
  private boolean mMr = false;
  private ArrayList<String> mMs = new ArrayList();
  private ArrayList<String> mMt = new ArrayList();
  private ArrayList<Boolean> mMu = new ArrayList();
  View mMv;
  private ImageView mMw;
  private ImageView mMx;
  private TextView mMy;
  private String mMz;
  private com.tencent.mm.sdk.b.c<kw> mNa = new WalletOfflineCoinPurseUI.36(this);
  private com.tencent.mm.sdk.b.c<kx> mNb = new WalletOfflineCoinPurseUI.37(this);
  private com.tencent.mm.sdk.b.c mNc = new WalletOfflineCoinPurseUI.38(this);
  private com.tencent.mm.sdk.b.c mNd = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.sdk.b.c mNe = new WalletOfflineCoinPurseUI.40(this);
  public boolean mNf = false;
  private HashMap<String, Integer> mNg = new HashMap();
  private am mNh = new am(new WalletOfflineCoinPurseUI.33(this), false);
  private am mNi = new am(new WalletOfflineCoinPurseUI.35(this), false);
  private int mState = 3;
  
  private void A(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (com.tencent.mm.plugin.offline.c.a.ib(true).size() > 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
      bqx();
      Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.bqJ();
      if (localBankcard != null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
        com.tencent.mm.plugin.offline.c.a.Kp(localBankcard.field_bindSerial);
        this.mJH = localBankcard.field_bindSerial;
        k.bpX();
        k.bpZ().mJH = this.mJH;
        this.mMA.setVisibility(0);
        label79:
        if (paramBoolean1) {
          vC(0);
        }
        ia(paramBoolean2);
        if (!com.tencent.mm.plugin.offline.c.a.bqH()) {
          break label145;
        }
        this.mMD.setVisibility(0);
      }
    }
    for (;;)
    {
      bqr();
      return;
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
      break;
      this.mMA.setVisibility(8);
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
      break label79;
      label145:
      this.mMD.setVisibility(4);
    }
  }
  
  private void aCg()
  {
    int i;
    if (this.mMR.size() >= 2)
    {
      i = this.mMR.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.e.w((Bitmap)this.mMR.remove(i));
        i -= 1;
      }
    }
    if (this.mMS.size() >= 2)
    {
      i = this.mMS.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.e.w((Bitmap)this.mMS.remove(i));
        i -= 1;
      }
    }
  }
  
  private void bqA()
  {
    if (!this.mMV.vB(1)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      if (this.mMV.mLS == 1) {
        this.mMV.dismiss();
      }
      bool1 = com.tencent.mm.plugin.wallet_core.model.o.bVs().bVK();
      bool2 = com.tencent.mm.plugin.wallet_core.model.o.bVs().bVO();
    } while ((!bool1) && (!bool2));
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    this.mMV.a(this.mMv, new WalletOfflineCoinPurseUI.24(this), 1);
  }
  
  private void bqB()
  {
    if (!this.mMV.vB(3)) {}
    String str1;
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      if (this.mMV.mLS == 3) {
        this.mMV.dismiss();
      }
      k.bpX();
      str1 = k.vA(196617);
      com.tencent.mm.wallet_core.c.a.cMr();
      bool1 = com.tencent.mm.wallet_core.c.a.isCertExist(str1);
      bool2 = com.tencent.mm.plugin.offline.c.a.bqH();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    } while ((bool1) && (bool2));
    if (!bool1)
    {
      com.tencent.mm.kernel.g.DQ();
      String str2 = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.unD, "");
      if ((str2 == null) || (!str2.equals(com.tencent.mm.compatible.e.q.zf()))) {
        break label194;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + str1 + " ,recreate offline");
      com.tencent.mm.plugin.offline.c.a.bqS();
      this.mMV.a(this.mMv, new WalletOfflineCoinPurseUI.25(this), 3);
      return;
      label194:
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
    }
  }
  
  private boolean bqC()
  {
    if (!this.mMV.vB(2)) {
      return false;
    }
    if (this.mMV.mLS == 2) {
      this.mMV.dismiss();
    }
    Object localObject1 = com.tencent.mm.plugin.offline.c.a.bqN();
    if (((List)localObject1).size() <= 0)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      return false;
    }
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (Bankcard)((List)localObject1).get(i);
      if ((localObject2 != null) && (((Bankcard)localObject2).field_support_micropay) && (bk.bl(((Bankcard)localObject2).field_forbidWord))) {
        return true;
      }
      i += 1;
    }
    this.mMV.dismiss();
    localObject1 = this.mMV;
    Object localObject2 = this.mMv;
    WalletOfflineCoinPurseUI.28 local28 = new WalletOfflineCoinPurseUI.28(this);
    WalletOfflineCoinPurseUI.29 local29 = new WalletOfflineCoinPurseUI.29(this);
    ((OfflineAlertView)localObject1).setVisibility(0);
    ((OfflineAlertView)localObject1).mLT.removeAllViews();
    View localView = LayoutInflater.from(((OfflineAlertView)localObject1).getContext()).inflate(a.g.wallet_offline_nosupport_tip, null);
    ((OfflineAlertView)localObject1).mLT.addView(localView);
    ((View)localObject2).post(new OfflineAlertView.1((OfflineAlertView)localObject1, (View)localObject2, local28, local29));
    return false;
  }
  
  private void bqD()
  {
    if (!com.tencent.mm.plugin.offline.c.a.bqH())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.bqH()) });
      return;
    }
    Object localObject3 = com.tencent.mm.plugin.offline.c.a.ib(false);
    if (((List)localObject3).size() <= 0)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      this.mMB.setVisibility(8);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = -1;
    int k = -1;
    Object localObject1 = null;
    Object localObject2 = null;
    if (i < ((List)localObject3).size())
    {
      if (((Bankcard)((List)localObject3).get(i)).bUQ())
      {
        localObject2 = (Bankcard)((List)localObject3).get(i);
        k = i;
      }
      if (!((Bankcard)((List)localObject3).get(i)).bUR()) {
        break label625;
      }
      localObject1 = (Bankcard)((List)localObject3).get(i);
      j = i;
    }
    label625:
    for (;;)
    {
      i += 1;
      break;
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      if (localObject1 != null) {
        localArrayList.add(localObject1);
      }
      i = 0;
      while (i < ((List)localObject3).size())
      {
        if ((i != j) && (i != k)) {
          localArrayList.add(((List)localObject3).get(i));
        }
        i += 1;
      }
      com.tencent.mm.plugin.offline.c.a.Kr(com.tencent.mm.plugin.offline.c.a.bqW());
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "showChangeBankcardDialog() bankcard size is " + localArrayList.size());
      localObject2 = com.tencent.mm.plugin.wallet_core.model.o.bVs().bWa();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new LinkedList();
        localObject3 = localArrayList.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add((Bankcard)((Iterator)localObject3).next());
        }
        localArrayList.clear();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = f((List)localObject1, ((com.tencent.mm.plugin.wallet_core.model.c)((Iterator)localObject2).next()).mOc);
          if (localObject3 != null) {
            localArrayList.add(localObject3);
          }
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add((Bankcard)((Iterator)localObject1).next());
        }
      }
      localObject1 = new com.tencent.mm.ui.widget.a.d(this, 2, true);
      i = 0;
      for (j = 0; i < localArrayList.size(); j = k)
      {
        localObject2 = (Bankcard)localArrayList.get(i);
        k = j;
        if (!bk.bl(((Bankcard)localObject2).field_bindSerial))
        {
          k = j;
          if (this.mJH.equals(((Bankcard)localObject2).field_bindSerial)) {
            k = i;
          }
        }
        i += 1;
      }
      ((com.tencent.mm.ui.widget.a.d)localObject1).phH = new WalletOfflineCoinPurseUI.30(this, localArrayList, (com.tencent.mm.ui.widget.a.d)localObject1);
      ((com.tencent.mm.ui.widget.a.d)localObject1).phI = new WalletOfflineCoinPurseUI.31(this, (com.tencent.mm.ui.widget.a.d)localObject1, localArrayList);
      localObject2 = View.inflate(this, a.g.wallet_offline_coin_bankcard_header, null);
      ((com.tencent.mm.ui.widget.a.d)localObject1).nrO = true;
      ((com.tencent.mm.ui.widget.a.d)localObject1).wno = j;
      ((com.tencent.mm.ui.widget.a.d)localObject1).wnm = true;
      ((com.tencent.mm.ui.widget.a.d)localObject1).ej((View)localObject2);
      ((com.tencent.mm.ui.widget.a.d)localObject1).cfU();
      com.tencent.mm.plugin.report.service.h.nFQ.f(13955, new Object[] { Integer.valueOf(3) });
      return;
    }
  }
  
  private static void bqE()
  {
    if (!com.tencent.mm.plugin.offline.c.a.bra())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
      k.bpX();
      k.bqa().dx(3, 3);
    }
  }
  
  private void bqp()
  {
    bqA();
    bqC();
    bqB();
    bqy();
  }
  
  private void bqq()
  {
    com.tencent.mm.wallet_core.ui.e.Jc(32);
    com.tencent.mm.pluginsdk.wallet.h.X(this, this.jNi);
  }
  
  private void bqr()
  {
    if ((!this.mNf) && (!aq.isNetworkConnected(getBaseContext())))
    {
      k.bpX();
      k.bpZ();
      if (com.tencent.mm.plugin.offline.e.bpQ() == 0)
      {
        this.mNf = true;
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.OfflineErrorHelper", "offline code size is 0, show check network error dialog");
        com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_wx_offline_check_network_connect_tips), null, false, new b.4(this));
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
      }
    }
  }
  
  private void bqs()
  {
    int i = com.tencent.mm.plugin.offline.c.a.bqM();
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.bqK();
    if (c.bqn())
    {
      this.mState = 7;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
      return;
    }
    if (!aq.isNetworkConnected(getBaseContext()))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
      this.mState = 6;
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.bqH())
    {
      if (i == 0)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
        this.mState = 1;
        return;
      }
      if ((i != 0) && (localBankcard == null))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
        this.mState = 2;
        return;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
      this.mState = 5;
      return;
    }
    if (i == 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
      this.mState = 1;
      return;
    }
    if ((i != 0) && (localBankcard == null))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
      this.mState = 2;
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
    this.mState = 5;
  }
  
  private boolean bqt()
  {
    return (this.mState == 2) || (this.mState == 1) || (this.mState == 7);
  }
  
  private void bqu()
  {
    if (this.mMT != null)
    {
      this.mMT.gG(this.mMK, this.mKk);
      this.mMT.mMn = this.mMn;
      this.mMT.mMo = this.mMo;
      this.mMT.cNd();
    }
  }
  
  private void bqv()
  {
    if ((this.mMJ != null) && (this.mMJ.isShowing())) {
      this.mMJ.dismiss();
    }
  }
  
  private void bqw()
  {
    a(new n(System.currentTimeMillis(), com.tencent.mm.plugin.offline.c.a.mNS), false, false);
  }
  
  private void bqy()
  {
    if (this.mMN) {}
    do
    {
      do
      {
        return;
      } while (!this.mMV.vB(4));
      com.tencent.mm.kernel.g.DQ();
    } while ((((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.utD, Boolean.valueOf(false))).booleanValue()) || (this.mMV.isShowing()));
    bqz();
  }
  
  private void bqz()
  {
    if (!this.mMV.vB(4)) {
      return;
    }
    OfflineAlertView localOfflineAlertView = this.mMV;
    View localView1 = this.mMv;
    localOfflineAlertView.setVisibility(0);
    localOfflineAlertView.mLT.removeAllViews();
    View localView2 = LayoutInflater.from(localOfflineAlertView.getContext()).inflate(a.g.wallet_offline_first_guide, null);
    localOfflineAlertView.mLT.addView(localView2);
    com.tencent.mm.plugin.report.service.h.nFQ.f(13750, new Object[] { Integer.valueOf(1) });
    localView1.post(new OfflineAlertView.2(localOfflineAlertView, localView1));
  }
  
  private static Bankcard f(List<Bankcard> paramList, String paramString)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Bankcard localBankcard = (Bankcard)localIterator.next();
      if (paramString.equals(localBankcard.field_bindSerial))
      {
        paramList.remove(localBankcard);
        return localBankcard;
      }
    }
    return null;
  }
  
  private void ia(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    Object localObject1;
    label246:
    label378:
    int i;
    label279:
    label345:
    int j;
    if ((paramBoolean) && ((bk.bl(this.mMK)) || (bk.bl(this.mKk))))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
      if (this.mMV.vB(5))
      {
        if (this.mMV.mLS == 5) {
          this.mMV.dismiss();
        }
        localObject1 = this.mMV;
        localObject2 = this.mMv;
        WalletOfflineCoinPurseUI.26 local26 = new WalletOfflineCoinPurseUI.26(this);
        ((OfflineAlertView)localObject1).mLS = 5;
        ((OfflineAlertView)localObject1).setVisibility(0);
        ((OfflineAlertView)localObject1).mLU = false;
        ((OfflineAlertView)localObject1).mLT.removeAllViews();
        Object localObject3 = LayoutInflater.from(((OfflineAlertView)localObject1).getContext()).inflate(a.g.wallet_offline_unopened_layout, null);
        ((OfflineAlertView)localObject1).mLT.addView((View)localObject3);
        ((TextView)((View)localObject3).findViewById(a.f.alert_title)).setText(a.i.offline_empty_code_text);
        localObject3 = (Button)((View)localObject3).findViewById(a.f.i_know_btn);
        ((Button)localObject3).setText(a.i.offline_empty_code_btn_text);
        ((Button)localObject3).setOnClickListener(local26);
        ((View)localObject2).post(new OfflineAlertView.8((OfflineAlertView)localObject1, (View)localObject2));
        com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 73L, 1L, true);
      }
      Object localObject2 = this.mMn;
      if (!TextUtils.isEmpty(this.mMK)) {
        break label597;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
      localObject1 = null;
      this.mMn = ((Bitmap)localObject1);
      this.mMw.setImageBitmap(this.mMn);
      if (!bqt()) {
        break label613;
      }
      this.mMw.setAlpha(10);
      this.mMR.add(0, localObject2);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - l));
      localObject2 = this.mMo;
      if (!TextUtils.isEmpty(this.mKk)) {
        break label626;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
      localObject1 = null;
      this.mMo = ((Bitmap)localObject1);
      this.mMx.setImageBitmap(this.mMo);
      if (!bqt()) {
        break label641;
      }
      this.mMx.setAlpha(10);
      this.mMS.add(0, localObject2);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - l));
      aCg();
      bqu();
      w.fT(10, 0);
      localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
      if (!com.tencent.mm.plugin.offline.c.a.dR(ae.getContext())) {
        break label654;
      }
      i = 0;
      label446:
      if (!aq.isNetworkConnected(ae.getContext())) {
        break label659;
      }
      j = 1;
      label457:
      k.bpX();
      k.bpZ();
      ((com.tencent.mm.plugin.report.service.h)localObject1).f(14163, new Object[] { Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(com.tencent.mm.plugin.offline.e.bpQ()) });
      com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 67L, 1L, true);
      if (!aq.isNetworkConnected(ae.getContext())) {
        break label664;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 32L, 1L, true);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.offline.c.a.dR(this)) {
        break label681;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 34L, 1L, true);
      return;
      if ((!this.mMV.isShowing()) || (this.mMV.mLS != 5)) {
        break;
      }
      this.mMV.dismiss();
      break;
      label597:
      localObject1 = com.tencent.mm.by.a.a.b(this, this.mMK, 12, 3);
      break label246;
      label613:
      this.mMw.setAlpha(255);
      break label279;
      label626:
      localObject1 = com.tencent.mm.by.a.a.b(this, this.mKk, 5, 0);
      break label345;
      label641:
      this.mMx.setAlpha(255);
      break label378;
      label654:
      i = 1;
      break label446;
      label659:
      j = 0;
      break label457;
      label664:
      com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 33L, 1L, true);
    }
    label681:
    com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 35L, 1L, true);
  }
  
  private void vC(int paramInt)
  {
    int i = 0;
    if (!com.tencent.mm.plugin.offline.c.a.bqH()) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
    }
    do
    {
      return;
      k.bpX();
      localObject1 = k.bpZ();
      int j = this.fgD;
      Object localObject2 = this.mMz;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), bk.csb().toString() });
      localObject1 = ((com.tencent.mm.plugin.offline.e)localObject1).o(j, paramInt, (String)localObject2);
      this.mKk = ((String)localObject1);
      this.mMK = ((String)localObject1);
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[] { Integer.valueOf(paramInt), this.mKk, this.mMK, bk.csb().toString() });
      localObject2 = com.tencent.mm.plugin.wallet_core.model.i.bVj();
      Object localObject3 = new StringBuilder().append(this.mMK);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DN();
      localObject3 = ad.bB(com.tencent.mm.a.o.getString(com.tencent.mm.kernel.a.CK()));
      if (localObject2 != null) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13444, new Object[] { ((aw)localObject2).sun, ((aw)localObject2).suo, Long.valueOf(((aw)localObject2).sum), localObject3, ((aw)localObject2).sup, ((aw)localObject2).suq });
      }
    } while (!bk.bl((String)localObject1));
    Object localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
    if (com.tencent.mm.plugin.offline.c.a.dR(ae.getContext())) {}
    for (paramInt = 0;; paramInt = 1)
    {
      if (aq.isNetworkConnected(getBaseContext())) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject1).f(14163, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 26L, 1L, true);
      if (!aq.isNetworkConnected(getBaseContext())) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 28L, 1L, true);
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 27L, 1L, true);
  }
  
  public final boolean a(s.c paramc)
  {
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
      return false;
    }
    bqv();
    this.mMT.dismiss();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "msgtype=" + paramc.mLF);
    int i;
    if (4 == paramc.mLF)
    {
      this.mML = false;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = this.mMU;
      if (paramc == null) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
      }
      for (;;)
      {
        if ((this.mMO) && (!this.mMP))
        {
          this.mMO = false;
          this.mML = false;
        }
        if (i != 0)
        {
          vC(0);
          ia(true);
        }
        return true;
        if (5 == paramc.mLF)
        {
          this.mML = true;
          this.mMO = true;
          this.mMP = false;
          if (this.mNh.crl()) {
            break label405;
          }
          this.mNh.stopTimer();
          i = 0;
          break;
        }
        if (6 == paramc.mLF)
        {
          if (!this.mNh.crl()) {
            this.mNh.stopTimer();
          }
          if (!this.mKp.crl()) {
            this.mKp.stopTimer();
          }
          this.mML = false;
          if (!com.tencent.mm.plugin.offline.c.a.bqI()) {
            break label1427;
          }
          i = 0;
          break;
        }
        if (8 == paramc.mLF)
        {
          if (this.mNh.crl()) {
            break label1427;
          }
          this.mNh.stopTimer();
          i = 1;
          break;
        }
        if (23 == paramc.mLF)
        {
          if (this.mNh.crl()) {
            break label405;
          }
          this.mNh.stopTimer();
          i = 0;
          break;
        }
        if (20 == paramc.mLF)
        {
          this.mML = false;
          if (this.mNh.crl()) {
            break label405;
          }
          this.mNh.stopTimer();
          i = 0;
          break;
        }
        if (24 != paramc.mLF) {
          break label1427;
        }
        if (com.tencent.mm.plugin.offline.c.a.bri())
        {
          this.mML = true;
          if (com.tencent.mm.plugin.offline.c.a.bri())
          {
            if (this.mMJ != null) {
              break label410;
            }
            this.mMJ = com.tencent.mm.wallet_core.ui.g.a(this.mController.uMN, false, new WalletOfflineCoinPurseUI.18(this));
          }
        }
        for (;;)
        {
          localObject1 = this.mNh;
          long l = com.tencent.mm.plugin.offline.g.bpS();
          ((am)localObject1).S(l, l);
          label405:
          i = 0;
          break;
          label410:
          if (!this.mMJ.isShowing()) {
            this.mMJ.show();
          }
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + paramc.mLF);
        if (paramc.mLF == 24) {
          ((c)localObject1).ibr.vibrate(50L);
        }
        if (4 == paramc.mLF)
        {
          ((c)localObject1).a((s.b)paramc);
          com.tencent.mm.plugin.offline.g.bpT();
        }
        else
        {
          if (5 == paramc.mLF)
          {
            paramc = (s.e)paramc;
            if (paramc != null)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + paramc.mLI + " msg.wxRetMsg:" + paramc.mLJ + " msg.cftRetCode:" + paramc.mLI + " msg.cftRetMsg:" + paramc.mLH);
              if ((!TextUtils.isEmpty(paramc.mLI)) || (!TextUtils.isEmpty(paramc.mLJ)) || (!TextUtils.isEmpty(paramc.mLG)) || (!TextUtils.isEmpty(paramc.mLH)))
              {
                if ((!TextUtils.isEmpty(paramc.mLI)) || (!TextUtils.isEmpty(paramc.mLJ)) || (TextUtils.isEmpty(paramc.mLG)) || (TextUtils.isEmpty(paramc.mLH))) {
                  break label691;
                }
                b.b(((c)localObject1).mActivity, paramc.mLH);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.offline.g.bpT();
              com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 0L, 1L, true);
              break;
              label691:
              if ((!TextUtils.isEmpty(paramc.mLI)) && (com.tencent.mm.plugin.offline.c.a.yS(paramc.mLI))) {
                ((c)localObject1).a(null, Integer.valueOf(paramc.mLI).intValue(), paramc.mLJ, paramc.mLK);
              } else {
                b.b(((c)localObject1).mActivity, paramc.mLJ);
              }
            }
          }
          Object localObject2;
          if (6 == paramc.mLF)
          {
            paramc = (s.f)paramc;
            int j;
            if (paramc != null)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + paramc.mLM);
              k.bpX();
              localObject2 = k.bqb().Km(paramc.mLN.bMX);
              if (localObject2 == null) {
                break label931;
              }
              if (((r)localObject2).field_status != com.tencent.mm.plugin.offline.g.mJV) {
                break label926;
              }
              j = 1;
            }
            for (;;)
            {
              if (j == 0)
              {
                com.tencent.mm.plugin.offline.g.ce(paramc.mLN.bMX, com.tencent.mm.plugin.offline.g.mJV);
                com.tencent.mm.plugin.offline.c.a.a(((c)localObject1).mActivity, paramc);
                ((c)localObject1).mActivity.setResult(-1);
                ((c)localObject1).mActivity.finish();
              }
              com.tencent.mm.plugin.offline.g.bpT();
              com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 7L, 1L, true);
              if (com.tencent.mm.plugin.offline.c.a.mNS != 4) {
                break;
              }
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
              com.tencent.mm.plugin.report.service.h.nFQ.f(13412, new Object[0]);
              break;
              label926:
              j = 0;
              continue;
              label931:
              j = 0;
            }
          }
          Object localObject3;
          if (8 == paramc.mLF)
          {
            paramc = (s.g)paramc;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + paramc.id);
            if (paramc.mLQ == 0)
            {
              localObject2 = ((c)localObject1).mActivity.getLayoutInflater().inflate(a.g.wallet_offline_payconfirm_layout, null);
              localObject3 = (TextView)((View)localObject2).findViewById(a.f.pay_fee);
              TextView localTextView = (TextView)((View)localObject2).findViewById(a.f.pay_good_name);
              ((TextView)localObject3).setText(paramc.mLP);
              localTextView.setText(paramc.mLO);
              com.tencent.mm.plugin.offline.g.ce(paramc.bOT, com.tencent.mm.plugin.offline.g.mJX);
              com.tencent.mm.ui.base.h.a(((c)localObject1).mActivity, "", (View)localObject2, ((c)localObject1).getString(a.i.wallet_wx_offline_pay_confirm_enter), ((c)localObject1).getString(a.i.app_cancel), new c.11((c)localObject1, paramc), new c.12((c)localObject1, paramc));
            }
            else if (paramc.mLQ == 1)
            {
              if (((c)localObject1).mMc != null) {
                ((c)localObject1).mMc.show();
              }
              com.tencent.mm.plugin.report.service.h.nFQ.f(13955, new Object[] { Integer.valueOf(1) });
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + paramc.id);
              com.tencent.mm.plugin.offline.g.ce(paramc.bOT, com.tencent.mm.plugin.offline.g.mJX);
              ((c)localObject1).mMc = com.tencent.mm.plugin.wallet_core.ui.o.a(((c)localObject1).mActivity, paramc.mLO, paramc.mLP, new c.13((c)localObject1, paramc), new c.14((c)localObject1), new c.15((c)localObject1, paramc));
              ((c)localObject1).mMc.nJn.setVisibility(0);
              ((c)localObject1).mMc.nCX.setVisibility(8);
            }
          }
          else
          {
            if (23 == paramc.mLF)
            {
              paramc = (s.d)paramc;
              localObject2 = new PayInfo();
              ((PayInfo)localObject2).bMX = paramc.bOT;
              ((PayInfo)localObject2).bUV = 8;
              ((PayInfo)localObject2).sod = 1;
              ((PayInfo)localObject2).snX = new Bundle();
              ((PayInfo)localObject2).snX.putLong("extinfo_key_9", System.currentTimeMillis());
              paramc = new c.1((c)localObject1, (PayInfo)localObject2);
              com.tencent.mm.sdk.b.a.udP.b(paramc);
              localObject3 = ((c)localObject1).mActivity;
              if (((c)localObject1).mMb == null) {}
              for (paramc = "";; paramc = ((c)localObject1).mMb.bqk())
              {
                com.tencent.mm.pluginsdk.wallet.h.a((Context)localObject3, false, "", paramc, (PayInfo)localObject2, "", new Intent(), 1);
                break;
              }
            }
            if (20 == paramc.mLF) {
              com.tencent.mm.plugin.offline.g.bpT();
            }
          }
        }
      }
      label1427:
      i = 1;
    }
  }
  
  public final void addDialog(Dialog paramDialog)
  {
    if (((paramDialog instanceof com.tencent.mm.ui.widget.a.c)) && (this.mMO))
    {
      this.mMP = true;
      paramDialog.setOnDismissListener(new WalletOfflineCoinPurseUI.17(this, ((com.tencent.mm.ui.widget.a.c)paramDialog).wmK));
    }
    super.addDialog(paramDialog);
  }
  
  public final void aqt()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
    vC(1);
    ia(true);
    com.tencent.mm.wallet_core.ui.e.Jc(40);
    com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 21L, 1L, true);
    if (this.mMT.fvf.isShowing())
    {
      if (this.mMT.isF)
      {
        this.mMT.cNe();
        return;
      }
      this.mMT.dismiss();
    }
    bqz();
  }
  
  public final void azP()
  {
    vC(0);
    ia(true);
  }
  
  public final boolean bgK()
  {
    return false;
  }
  
  public final void bqi()
  {
    bqD();
  }
  
  public final void bqj()
  {
    a(new com.tencent.mm.plugin.offline.a.j(""), false, false);
  }
  
  public final String bqk()
  {
    return this.mJH;
  }
  
  public final void bql()
  {
    if (!this.mKp.crl()) {
      this.mKp.stopTimer();
    }
    vC(0);
    ia(true);
    this.mML = false;
    am localam = this.mKp;
    long l = this.mKo;
    localam.S(l, l);
  }
  
  public final void bqx()
  {
    Object localObject3 = com.tencent.mm.plugin.offline.c.a.bqJ();
    findViewById(a.f.wallet_wx_offline_change_bankcard_tip).setVisibility(0);
    this.mMB.setTextSize(0, getResources().getDimensionPixelSize(a.d.NormalTextSize));
    Object localObject2;
    Object localObject1;
    if ((this.mMB != null) && (localObject3 != null))
    {
      localObject2 = getString(a.i.wallet_wx_offline_change_bankcard_tips, new Object[] { ((Bankcard)localObject3).field_desc });
      localObject1 = com.tencent.mm.plugin.wallet_core.model.o.bVs().bWa();
      if ((localObject1 == null) || (bk.bl(((Bankcard)localObject3).field_forbidWord))) {
        break label508;
      }
      Iterator localIterator = ((List)localObject1).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (com.tencent.mm.plugin.wallet_core.model.c)localIterator.next();
      } while (!((com.tencent.mm.plugin.wallet_core.model.c)localObject1).mOc.equals(((Bankcard)localObject3).field_bindSerial));
    }
    for (;;)
    {
      if ((localObject1 != null) && (!bk.bl(((com.tencent.mm.plugin.wallet_core.model.c)localObject1).qtk)))
      {
        localObject1 = ((Bankcard)localObject3).field_desc + ((com.tencent.mm.plugin.wallet_core.model.c)localObject1).qtk;
        findViewById(a.f.wallet_wx_offline_change_bankcard_tip).setVisibility(8);
        com.tencent.mm.plugin.report.service.h.nFQ.f(14515, new Object[] { Integer.valueOf(2) });
        this.mMB.setTextSize(0, getResources().getDimensionPixelSize(a.d.HintTextSize));
      }
      for (int i = 1;; i = 0)
      {
        this.mMB.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mController.uMN, (CharSequence)localObject1, this.mMB.getTextSize()));
        if (localObject3 != null)
        {
          if (!TextUtils.isEmpty(this.mJH)) {
            break label310;
          }
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
        }
        for (;;)
        {
          if (i != 0) {
            this.mMC.setImageResource(a.h.error_offline_info);
          }
          return;
          if (localObject3 == null) {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
          }
          i = 0;
          break;
          label310:
          if (((Bankcard)localObject3).bUU())
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
            this.mMC.setImageDrawable(com.tencent.mm.svg.a.a.e(this.mController.uMN.getResources(), a.h.honey_pay_bank_logo));
          }
          else
          {
            localObject2 = com.tencent.mm.plugin.offline.c.a.Kw(this.mJH);
            localObject1 = localObject2;
            if (((Bankcard)localObject3).bUR())
            {
              localObject1 = localObject2;
              if (((Bankcard)localObject3).qtH != null) {
                localObject1 = ((Bankcard)localObject3).qtH.mEi;
              }
            }
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
            }
            else
            {
              localObject2 = this.mMC;
              int j = getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width);
              if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
              {
                localObject3 = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject1));
                if (localObject3 != null) {
                  ((ImageView)localObject2).setImageBitmap(com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject3, j, j, true, false));
                }
                this.mMl.put(localObject1, localObject2);
                this.mMm.put(localObject1, Integer.valueOf(j));
              }
            }
          }
        }
        localObject1 = localObject2;
      }
      label508:
      localObject1 = null;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " scene: " + paramm);
    if (((paramm instanceof com.tencent.mm.plugin.offline.a.f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.mKm.bqe();
      this.mKm = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))
      {
        if (com.tencent.mm.plugin.offline.c.a.bqH())
        {
          if (com.tencent.mm.plugin.offline.c.a.bqK() != null) {
            bqw();
          }
          bqE();
        }
        bqC();
        if ((!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.y)) && (!(paramm instanceof n)) && (!(paramm instanceof com.tencent.mm.plugin.offline.a.a)) && (!(paramm instanceof com.tencent.mm.plugin.offline.a.e))) {
          break label841;
        }
        bqs();
        A(false, true);
      }
    }
    label841:
    label979:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                if ((paramm instanceof com.tencent.mm.plugin.offline.a.m))
                {
                  this.mKm = ((com.tencent.mm.plugin.offline.a.m)paramm);
                  paramString = this.mKm.mLm;
                  k.bpX();
                  paramString = new com.tencent.mm.plugin.offline.a.f(paramString, k.vA(196617));
                  com.tencent.mm.kernel.g.DQ();
                  com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
                  break;
                }
                if ((paramm instanceof com.tencent.mm.plugin.offline.a.j))
                {
                  bqs();
                  bqp();
                  break;
                }
                Object localObject;
                if ((paramm instanceof n))
                {
                  paramString = (n)paramm;
                  if ("1".equals(paramString.mLr))
                  {
                    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
                    if (bk.bl(paramString.mLs)) {}
                    for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.mLs)
                    {
                      com.tencent.mm.ui.base.h.a(this, paramString, "", false, new WalletOfflineCoinPurseUI.2(this));
                      return true;
                    }
                  }
                  if (paramString.mKM == 0)
                  {
                    localObject = this.mMU;
                    ((c)localObject).mMd = com.tencent.mm.plugin.offline.c.a.bqO();
                    ((c)localObject).mMd = ((c)localObject).mMd;
                    if (!"1".equals(paramString.mLq)) {
                      break;
                    }
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
                    a(new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 8), false, false);
                    break;
                  }
                  if (paramString.mKM == 0) {
                    break;
                  }
                  this.mMU.a(paramString, paramString.mKM, paramString.mKN);
                  break;
                }
                if ((paramm instanceof com.tencent.mm.plugin.offline.a.a)) {
                  break;
                }
                if ((paramm instanceof com.tencent.mm.plugin.offline.a.e))
                {
                  this.mMU.c(paramInt1, paramInt2, paramString, paramm);
                  break;
                }
                if ((paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f))
                {
                  if ((this.mMJ != null) && (this.mMJ.isShowing())) {
                    this.mMJ.dismiss();
                  }
                  paramm = (com.tencent.mm.plugin.wallet_core.id_verify.model.f)paramm;
                  if (("1".equals(paramm.qsn)) || (("2".equals(paramm.qsn)) && (!bk.bl(paramm.qso))))
                  {
                    paramString = new Bundle();
                    paramString.putString("realname_verify_process_jump_activity", ".ui.WalletOfflineCoinPurseUI");
                    paramString.putString("realname_verify_process_jump_plugin", "offline");
                    localObject = paramm.qso;
                    localObject = paramm.qsp;
                    paramm = paramm.qsq;
                    com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString, null, 1006);
                    return true;
                  }
                  if ("collect".equals(paramm.qsr))
                  {
                    bqq();
                    return true;
                  }
                  if ("reward".equals(paramm.qsr))
                  {
                    com.tencent.mm.br.d.x(this.mController.uMN, "collect", ".reward.ui.QrRewardMainUI");
                    return true;
                  }
                  com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { paramm.qsr });
                  return true;
                }
                if (!(paramm instanceof com.tencent.mm.plugin.offline.a.q)) {
                  break;
                }
                paramString = (com.tencent.mm.plugin.offline.a.q)paramm;
                if ((paramString.cMv()) && (!this.mMQ) && (paramString.lQQ.a(this, new WalletOfflineCoinPurseUI.3(this)))) {
                  this.mMQ = true;
                }
                c(paramString.mLx.errType, paramString.mLx.errCode, paramString.mLx.aox, paramString.mLv);
                c(paramString.mLw.errType, paramString.mLw.errCode, paramString.mLw.aox, paramString.mLu);
                break;
              } while (!(paramm instanceof com.tencent.mm.plugin.offline.a.f));
              bqs();
              A(true, true);
              return true;
              if (!(paramm instanceof n)) {
                break label899;
              }
              bqs();
              A(false, true);
            } while (411 != paramInt2);
            this.mMU.a(paramm, paramInt2, paramString);
            return true;
            if ((paramm instanceof com.tencent.mm.plugin.offline.a.e))
            {
              this.mMU.c(paramInt1, paramInt2, paramString, paramm);
              return true;
            }
          } while ((paramm instanceof com.tencent.mm.plugin.offline.a.j));
          if ((paramm instanceof com.tencent.mm.plugin.offline.a.f))
          {
            this.mKm = null;
            return true;
          }
          if (!(paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f)) {
            break label979;
          }
        } while ((this.mMJ == null) || (!this.mMJ.isShowing()));
        this.mMJ.dismiss();
        return true;
      } while (!(paramm instanceof com.tencent.mm.plugin.offline.a.q));
      bqs();
      A(false, true);
    } while (411 != paramInt2);
    label899:
    this.mMU.a(paramm, paramInt2, paramString);
    return true;
  }
  
  public final void d(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a(new com.tencent.mm.plugin.offline.a.e(paramInt, paramString1, paramString2, paramString3), com.tencent.mm.plugin.offline.c.a.bqI(), false);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_offline_coin_purse_ui;
  }
  
  protected final void initView()
  {
    this.mMV = ((OfflineAlertView)findViewById(a.f.offline_alert_view));
    this.mMV.dismiss();
    this.mMV.setDialogState(new WalletOfflineCoinPurseUI.4(this));
    com.tencent.mm.wallet_core.c.a.cMr();
    com.tencent.mm.wallet_core.c.a.init(getApplicationContext());
    Object localObject;
    if ((this.fgD == 3) || (this.fgD == 10) || (this.fgD == 11) || (this.fgD == 12))
    {
      setMMTitle(a.i.wallet_wx_offline_coin_purse_card_title);
      this.mMU = new c(this, this);
      localObject = this.mMU;
      ((c)localObject).ibr = ((Vibrator)((c)localObject).mActivity.getSystemService("vibrator"));
      this.mMT = new com.tencent.mm.wallet_core.ui.c(this, true);
      this.mMT.init();
      this.mMv = findViewById(a.f.wallet_qrcode_layout);
      this.mMw = ((ImageView)findViewById(a.f.wallet_qrcode_iv));
      this.mMx = ((ImageView)findViewById(a.f.wallet_barcode_iv));
      this.mMy = ((TextView)findViewById(a.f.wallet_barcode_tv));
      this.mMA = findViewById(a.f.wallet_wx_offline_change_bankcard_layout);
      this.mMB = ((TextView)findViewById(a.f.wallet_wx_offline_change_bankcard_tv));
      this.mMC = ((ImageView)findViewById(a.f.wallet_wx_offline_bank_logo));
      this.mMD = ((RelativeLayout)findViewById(a.f.wallet_offline_menu_layout));
      this.mMD.setOnClickListener(new WalletOfflineCoinPurseUI.13(this));
      this.mMw.setOnClickListener(this.fvj);
      this.mMx.setOnClickListener(this.fvj);
      this.mMy.setOnClickListener(this.fvj);
      this.mMA.setClickable(true);
      this.mMA.setOnClickListener(new WalletOfflineCoinPurseUI.14(this));
      this.mLastTime = System.currentTimeMillis();
      this.mME = ((LinearLayout)findViewById(a.f.wallet_offline_collect_btn_layout));
      this.mMF = ((LinearLayout)findViewById(a.f.wallet_offline_aa_btn_layout));
      this.mMG = ((LinearLayout)findViewById(a.f.wallet_offline_f2f_lucky_btn_layout));
      this.mMH = ((LinearLayout)findViewById(a.f.wallet_offline_qr_reward_layout));
      this.mMI = ((LinearLayout)findViewById(a.f.wallet_offline_bank_remit_layout));
      if ((this.fgD != 3) && (this.fgD != 10) && (this.fgD != 11) && (this.fgD != 12)) {
        break label754;
      }
      this.mME.setVisibility(8);
      this.mMF.setVisibility(8);
      this.mMG.setVisibility(8);
      this.mMH.setVisibility(8);
      if ((com.tencent.mm.plugin.offline.c.a.bqH()) && (c.bqn()))
      {
        localObject = this.mMU;
        k.bpX();
        ((c)localObject).a(k.bpY().mLy);
      }
      bqs();
      A(true, false);
      localObject = this.mKp;
      long l1 = this.mKo;
      ((am)localObject).S(l1, l1);
      if ((com.tencent.mm.plugin.offline.c.a.mNS != 3) || (!com.tencent.mm.plugin.offline.c.a.mNV)) {
        break label1223;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
      int i = com.tencent.mm.plugin.offline.c.a.mNT;
      l1 = com.tencent.mm.plugin.offline.c.a.mNU;
      long l2 = System.currentTimeMillis();
      long l3 = i * 1000 + l1 - l2;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + l1 + " now:" + l2 + " interval:" + l3);
      if ((com.tencent.mm.plugin.offline.c.a.mNT <= 0) || (com.tencent.mm.plugin.offline.c.a.mNU <= 0L) || (l3 <= 0L)) {
        break label1211;
      }
      if (!this.mNi.crl()) {
        this.mNi.stopTimer();
      }
      this.mNi.S(l3, l3);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
    }
    for (;;)
    {
      bqr();
      localObject = new ti();
      ((ti)localObject).ccU.bso = "5";
      ((ti)localObject).bFJ = new WalletOfflineCoinPurseUI.5(this, (ti)localObject);
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      return;
      setMMTitle(a.i.wallet_wx_offline_coin_purse_title);
      break;
      label754:
      this.mMH.setVisibility(0);
      this.mMI.setVisibility(0);
      boolean bool1 = com.tencent.mm.y.c.BS().b(ac.a.uyq, ac.a.uxr);
      boolean bool2 = com.tencent.mm.y.c.BS().b(ac.a.uyr, ac.a.uxr);
      boolean bool3 = com.tencent.mm.y.c.BS().b(ac.a.uys, ac.a.uxr);
      boolean bool4 = com.tencent.mm.y.c.BS().b(ac.a.uyt, ac.a.uxr);
      boolean bool5 = com.tencent.mm.y.c.BS().b(ac.a.uyu, ac.a.uxr);
      localObject = (ImageView)this.mMF.findViewById(a.f.aa_new_dot);
      ImageView localImageView1 = (ImageView)this.mME.findViewById(a.f.f2f_recv_new_dot);
      ImageView localImageView2 = (ImageView)this.mMG.findViewById(a.f.f2f_hb_new_dot);
      ImageView localImageView3 = (ImageView)this.mMH.findViewById(a.f.qr_reward_new_dot);
      TextView localTextView = (TextView)this.mME.findViewById(a.f.f2f_recv_red_wording);
      ImageView localImageView4 = (ImageView)this.mME.findViewById(a.f.f2f_recv_red_dot);
      ImageView localImageView5 = (ImageView)this.mMI.findViewById(a.f.bank_remit_new_dot);
      if (bool1) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (bool2)
      {
        com.tencent.mm.kernel.g.DQ();
        String str = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxH, "");
        if (!bk.bl(str))
        {
          localTextView.setText(str);
          localTextView.setVisibility(0);
          localImageView4.setVisibility(0);
        }
      }
      else
      {
        label1011:
        if (bool3) {
          localImageView2.setVisibility(0);
        }
        if (bool4) {
          localImageView3.setVisibility(0);
        }
        if (bool5) {
          localImageView5.setVisibility(0);
        }
        if (!((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyv, Boolean.valueOf(false))).booleanValue()) {
          break label1179;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
      }
      for (;;)
      {
        this.mME.setOnClickListener(new WalletOfflineCoinPurseUI.7(this, localImageView1, localTextView, localImageView4));
        this.mMF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
            com.tencent.mm.plugin.report.service.h.nFQ.f(14021, new Object[] { Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this)) });
            com.tencent.mm.br.d.x(WalletOfflineCoinPurseUI.this.mController.uMN, "aa", ".ui.AAEntranceUI");
            if (com.tencent.mm.y.c.BS().b(ac.a.uyq, ac.a.uxr))
            {
              com.tencent.mm.y.c.BS().c(ac.a.uyq, ac.a.uxr);
              this.mNt.setVisibility(8);
              com.tencent.mm.plugin.report.service.h.nFQ.f(14396, new Object[] { Integer.valueOf(4) });
            }
          }
        });
        this.mMG.setOnClickListener(new WalletOfflineCoinPurseUI.9(this, localImageView2));
        this.mMH.setOnClickListener(new WalletOfflineCoinPurseUI.10(this, localImageView3));
        this.mMI.setOnClickListener(new WalletOfflineCoinPurseUI.11(this, localImageView5));
        break;
        localImageView1.setVisibility(0);
        break label1011;
        label1179:
        getWindow().getDecorView().post(new WalletOfflineCoinPurseUI.6(this, bool2, bool4, bool1, bool3, bool5));
      }
      label1211:
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
      continue;
      label1223:
      if (com.tencent.mm.plugin.offline.c.a.mNS == 3) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
      } else {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.c.a.mNS) });
      }
    }
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null) || (paramBitmap.isRecycled())) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.mMl.get(paramString);
      paramString = (Integer)this.mMm.get(paramString);
    } while ((localImageView == null) || (paramString == null));
    new ah(getMainLooper()).post(new WalletOfflineCoinPurseUI.19(this, paramString, paramBitmap, localImageView));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    k.mKz = true;
    com.tencent.mm.wallet_core.ui.e.Jc(41);
    paramBundle = getIntent();
    this.mMN = paramBundle.getBooleanExtra("is_offline_create", false);
    if ((paramBundle != null) && (paramBundle.hasExtra("key_entry_scene"))) {
      this.fgD = paramBundle.getIntExtra("key_entry_scene", this.fgD);
    }
    this.drX = paramBundle.getIntExtra("key_from_scene", 0);
    this.mMz = bk.aM(paramBundle.getStringExtra("key_business_attach"), "");
    this.jNi = 1;
    if (this.fgD == 2)
    {
      this.jNi = 1;
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
      vN(0);
      ta(getResources().getColor(a.c.wallet_offline_bg_color));
      czo();
      paramBundle = getWindow().getAttributes();
      if (paramBundle.screenBrightness < 0.85F)
      {
        paramBundle.screenBrightness = 0.85F;
        getWindow().setAttributes(paramBundle);
      }
      setBackBtn(new WalletOfflineCoinPurseUI.34(this));
      com.tencent.mm.wallet_core.ui.e.cNp();
      if (!com.tencent.mm.plugin.offline.a.q.isEnabled()) {
        a(new com.tencent.mm.plugin.wallet_core.c.y(null, 8), false, false);
      }
      if (!com.tencent.mm.plugin.wallet_core.model.o.bVs().bVM()) {
        break label477;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
    }
    for (;;)
    {
      initView();
      x.a(this);
      k.bpX();
      k.bpY().a(this);
      kh(606);
      kh(609);
      kh(1501);
      k.bpX();
      k.bpZ().bz(this);
      com.tencent.mm.sdk.b.a.udP.c(this.mNe);
      com.tencent.mm.plugin.offline.c.a.bqT();
      com.tencent.mm.sdk.b.a.udP.b(this.mNc);
      com.tencent.mm.sdk.b.a.udP.b(this.mNa);
      com.tencent.mm.sdk.b.a.udP.b(this.mMX);
      this.mMY.cqo();
      this.mMZ.cqo();
      this.mMM = new com.tencent.mm.plugin.offline.g();
      paramBundle = new kx();
      paramBundle.bUa.auK = hashCode();
      com.tencent.mm.sdk.b.a.udP.m(paramBundle);
      this.mNb.cqo();
      return;
      if (this.fgD == 1)
      {
        this.jNi = 2;
        break;
      }
      if (this.fgD == 8)
      {
        this.jNi = 4;
        break;
      }
      if (this.fgD == 4)
      {
        this.jNi = 6;
        break;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[] { Integer.valueOf(this.jNi) });
      break;
      label477:
      if (com.tencent.mm.plugin.wallet_core.model.o.bVs().bVK())
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
        com.tencent.mm.plugin.offline.c.a.bqS();
        k.bpX();
        k.ax(196648, "0");
      }
      else if ((com.tencent.mm.plugin.wallet_core.model.o.bVs().bVN()) && (com.tencent.mm.plugin.offline.c.a.bqH()))
      {
        bqE();
      }
    }
  }
  
  public void onDestroy()
  {
    k.mKz = false;
    com.tencent.mm.wallet_core.ui.e.w(this.mMn);
    com.tencent.mm.wallet_core.ui.e.w(this.mMo);
    com.tencent.mm.wallet_core.ui.e.ak(this.mMR);
    com.tencent.mm.wallet_core.ui.e.ak(this.mMS);
    this.mMR.clear();
    this.mMS.clear();
    this.mMs.clear();
    this.mMt.clear();
    this.mMu.clear();
    x.c(this);
    k.bpX();
    k.bpY().b(this);
    ki(606);
    ki(609);
    ki(1501);
    k.bpX();
    k.bpZ().bA(this);
    com.tencent.mm.sdk.b.a.udP.d(this.mNe);
    com.tencent.mm.sdk.b.a.udP.d(this.mNc);
    com.tencent.mm.sdk.b.a.udP.d(this.mMX);
    if (!this.mKp.crl()) {
      this.mKp.stopTimer();
    }
    if (!this.mNi.crl()) {
      this.mNi.stopTimer();
    }
    if (this.mMT != null) {
      this.mMT.release();
    }
    if (this.mMU != null)
    {
      localObject = this.mMU;
      ((c)localObject).ibr.cancel();
      ((c)localObject).mActivity = null;
    }
    com.tencent.mm.sdk.b.a.udP.d(this.mNa);
    this.mMY.dead();
    this.mMZ.dead();
    Object localObject = this.mMM;
    ((com.tencent.mm.plugin.offline.g)localObject).stop();
    com.tencent.mm.plugin.offline.g.bpT();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(385, ((com.tencent.mm.plugin.offline.g)localObject).mJZ);
    ((com.tencent.mm.plugin.offline.g)localObject).mKb = null;
    this.mNb.dead();
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.mMV != null) && (this.mMV.getVisibility() == 0) && (this.mMV.mLU))
    {
      this.mMV.dismiss();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
    this.mMq = true;
  }
  
  public void onPause()
  {
    k.bpX();
    com.tencent.mm.plugin.offline.i locali = k.bqa();
    locali.mHandler.removeCallbacks(locali.mKn);
    ay.a(this, null);
    this.bqV = false;
    com.tencent.mm.sdk.b.a.udP.d(this.mNd);
    this.mMM.stop();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.b.a.udP.c(this.mNd);
    ay.a(this, this);
    if (!this.mMW)
    {
      bqp();
      this.mMW = true;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
    this.bqV = true;
    Object localObject = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.walletlock.a.b.class);
    ((com.tencent.mm.plugin.walletlock.a.b)localObject).a(this, ((com.tencent.mm.plugin.walletlock.a.b)localObject).bXL(), null);
    if (aq.isNetworkConnected(getBaseContext()))
    {
      if (com.tencent.mm.plugin.wallet_core.model.o.bVs().bVM()) {
        a(new com.tencent.mm.plugin.wallet_core.c.y(null, 8), true, false);
      }
      if (com.tencent.mm.plugin.offline.c.a.bqH())
      {
        k.bpX();
        k.bqa().hZ(false);
        if (!c.bqn())
        {
          if (!com.tencent.mm.plugin.offline.a.q.isEnabled()) {
            break label387;
          }
          a(new com.tencent.mm.plugin.offline.a.q(com.tencent.mm.plugin.offline.c.a.mNS), false, false);
        }
      }
    }
    bqs();
    localObject = com.tencent.mm.plugin.offline.c.a.bqJ();
    if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (!((Bankcard)localObject).field_bindSerial.equals(this.mJH)))
    {
      this.mJH = ((Bankcard)localObject).field_bindSerial;
      k.bpX();
      k.bpZ().mJH = this.mJH;
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((this.mMr) && (this.mMq)))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
        this.mMr = false;
        this.mMq = false;
        bqx();
        vC(0);
        ia(true);
      }
      localObject = this.mMM;
      if (!com.tencent.mm.plugin.offline.c.a.bri()) {
        break label423;
      }
      com.tencent.mm.sdk.platformtools.y.i(com.tencent.mm.plugin.offline.g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + ((com.tencent.mm.plugin.offline.g)localObject).mKb.crl());
      if ((((com.tencent.mm.plugin.offline.g)localObject).mKb == null) || (((com.tencent.mm.plugin.offline.g)localObject).mKb.crl()))
      {
        ((com.tencent.mm.plugin.offline.g)localObject).status = 1;
        com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 61L, 1L, true);
        if (!((com.tencent.mm.plugin.offline.g)localObject).mKa) {
          break label399;
        }
        com.tencent.mm.plugin.offline.g.bpT();
        localObject = ((com.tencent.mm.plugin.offline.g)localObject).mKb;
        l = com.tencent.mm.plugin.offline.g.mJK;
        ((am)localObject).S(l, l);
        i = com.tencent.mm.plugin.offline.g.mJK;
      }
      return;
      label387:
      bqw();
      break;
    }
    label399:
    localObject = ((com.tencent.mm.plugin.offline.g)localObject).mKb;
    long l = com.tencent.mm.plugin.offline.g.mJY;
    ((am)localObject).S(l, l);
    i = com.tencent.mm.plugin.offline.g.mJY;
    return;
    label423:
    com.tencent.mm.sdk.platformtools.y.i(com.tencent.mm.plugin.offline.g.TAG, "OfflineGetMsg is not in abtest");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI
 * JD-Core Version:    0.7.0.1
 */