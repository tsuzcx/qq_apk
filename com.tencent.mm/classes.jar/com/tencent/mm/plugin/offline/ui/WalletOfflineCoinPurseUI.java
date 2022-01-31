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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.b;
import com.tencent.mm.plugin.offline.a.s.c;
import com.tencent.mm.plugin.offline.a.s.d;
import com.tencent.mm.plugin.offline.a.s.e;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.kernel.i
public class WalletOfflineCoinPurseUI
  extends WalletBaseUI
  implements x.a, s.a, com.tencent.mm.plugin.offline.b, a, bc.a
{
  private static int jwK = 0;
  private boolean bNX;
  private int ejF;
  private View.OnClickListener gMO;
  private int gyl;
  private boolean ktM;
  private long mLastTime;
  private int mState;
  private Dialog mTipDialog;
  private int mhr;
  private String pjW;
  private com.tencent.mm.plugin.offline.a.m pkB;
  private int pkD;
  private ap pkE;
  private String pkz;
  private HashMap<String, View> pmB;
  private HashMap<String, Integer> pmC;
  Bitmap pmD;
  Bitmap pmE;
  private WalletOfflineCoinPurseUI.a pmF;
  private boolean pmG;
  private boolean pmH;
  private ArrayList<String> pmI;
  private ArrayList<String> pmJ;
  private ArrayList<Boolean> pmK;
  private View pmL;
  private ImageView pmM;
  private ImageView pmN;
  private TextView pmO;
  private String pmP;
  private View pmQ;
  private TextView pmR;
  private ImageView pmS;
  private RelativeLayout pmT;
  private LinearLayout pmU;
  private LinearLayout pmV;
  private LinearLayout pmW;
  private LinearLayout pmX;
  private LinearLayout pmY;
  private String pmZ;
  private boolean pna;
  private com.tencent.mm.plugin.offline.g pnb;
  private boolean pnc;
  private boolean pnd;
  private boolean pne;
  private boolean pnf;
  private ArrayList<Bitmap> png;
  private ArrayList<Bitmap> pnh;
  private com.tencent.mm.wallet_core.ui.c pni;
  private c pnj;
  private OfflineAlertView pnk;
  private boolean pnl;
  com.tencent.mm.sdk.b.c<vk> pnm;
  private com.tencent.mm.sdk.b.c<cn> pnn;
  private com.tencent.mm.sdk.b.c<lz> pno;
  private com.tencent.mm.sdk.b.c<lk> pnp;
  private com.tencent.mm.sdk.b.c<ll> pnq;
  private com.tencent.mm.sdk.b.c pnr;
  private com.tencent.mm.sdk.b.c pns;
  private com.tencent.mm.sdk.b.c pnt;
  public boolean pnu;
  private HashMap<String, Integer> pnv;
  private ap pnw;
  private ap pnx;
  
  public WalletOfflineCoinPurseUI()
  {
    AppMethodBeat.i(43561);
    this.mLastTime = 0L;
    this.mState = 3;
    this.pmB = new HashMap();
    this.pmC = new HashMap();
    this.gyl = -1;
    this.pmD = null;
    this.pmE = null;
    this.pmG = false;
    this.pmH = false;
    this.pmI = new ArrayList();
    this.pmJ = new ArrayList();
    this.pmK = new ArrayList();
    this.pjW = "";
    this.pmZ = "";
    this.pkz = "";
    this.ktM = true;
    this.pna = false;
    this.pnc = false;
    this.pnd = false;
    this.pne = false;
    this.pnf = false;
    this.png = new ArrayList();
    this.pnh = new ArrayList();
    this.pnl = false;
    this.pnm = new com.tencent.mm.sdk.b.c() {};
    this.pnn = new WalletOfflineCoinPurseUI.12(this);
    this.pno = new WalletOfflineCoinPurseUI.23(this);
    this.pnp = new WalletOfflineCoinPurseUI.36(this);
    this.pnq = new WalletOfflineCoinPurseUI.37(this);
    this.pnr = new WalletOfflineCoinPurseUI.38(this);
    this.pns = new com.tencent.mm.sdk.b.c() {};
    this.pnt = new WalletOfflineCoinPurseUI.40(this);
    this.gMO = new WalletOfflineCoinPurseUI.15(this);
    this.pnu = false;
    this.pnv = new HashMap();
    this.pkD = 60000;
    this.pkE = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(43542);
        if (!WalletOfflineCoinPurseUI.L(WalletOfflineCoinPurseUI.this))
        {
          WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.D(WalletOfflineCoinPurseUI.this);
        }
        ap localap = WalletOfflineCoinPurseUI.N(WalletOfflineCoinPurseUI.this);
        long l = WalletOfflineCoinPurseUI.M(WalletOfflineCoinPurseUI.this);
        localap.ag(l, l);
        AppMethodBeat.o(43542);
        return false;
      }
    }, false);
    this.pnw = new ap(new WalletOfflineCoinPurseUI.33(this), false);
    this.pnx = new ap(new WalletOfflineCoinPurseUI.35(this), false);
    AppMethodBeat.o(43561);
  }
  
  private void Ba(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(43586);
    if (!com.tencent.mm.plugin.offline.c.a.bZw())
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
      AppMethodBeat.o(43586);
      return;
    }
    com.tencent.mm.plugin.offline.k.bYF();
    Object localObject = com.tencent.mm.plugin.offline.k.bYH().t(this.gyl, paramInt, this.pmP);
    this.pkz = ((String)localObject);
    this.pmZ = ((String)localObject);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[] { Integer.valueOf(paramInt), this.pkz, this.pmZ, bo.dtY().toString() });
    biu();
    if (bo.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.mm.plugin.report.service.h.qsU;
      if (com.tencent.mm.plugin.offline.c.a.eD(ah.getContext())) {}
      for (paramInt = 0;; paramInt = 1)
      {
        if (at.isNetworkConnected(getBaseContext())) {
          i = 1;
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).e(14163, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 26L, 1L, true);
        if (!at.isNetworkConnected(getBaseContext())) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 28L, 1L, true);
        AppMethodBeat.o(43586);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 27L, 1L, true);
    }
    AppMethodBeat.o(43586);
  }
  
  private void E(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(43576);
    if (com.tencent.mm.plugin.offline.c.a.jX(true).size() > 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
      bZh();
      bZg();
      this.pmQ.setVisibility(0);
    }
    for (;;)
    {
      if (paramBoolean1) {
        Ba(0);
      }
      jW(paramBoolean2);
      bdQ();
      bYX();
      AppMethodBeat.o(43576);
      return;
      this.pmQ.setVisibility(0);
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
    }
  }
  
  private void a(Bankcard paramBankcard)
  {
    AppMethodBeat.i(43606);
    if (TextUtils.isEmpty(this.pjW))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
      AppMethodBeat.o(43606);
      return;
    }
    if (paramBankcard.cTj())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
      this.pmS.setImageDrawable(com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131231407));
      AppMethodBeat.o(43606);
      return;
    }
    String str2 = com.tencent.mm.plugin.offline.c.a.Wy(this.pjW);
    String str1 = str2;
    if (paramBankcard.cTg())
    {
      str1 = str2;
      if (paramBankcard.ufW != null) {
        str1 = paramBankcard.ufW.pek;
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
      AppMethodBeat.o(43606);
      return;
    }
    e(this.pmS, str1, getResources().getDimensionPixelOffset(2131428824));
    AppMethodBeat.o(43606);
  }
  
  private void bMX()
  {
    AppMethodBeat.i(43580);
    Bitmap localBitmap = this.pmD;
    this.pmD = bZd();
    this.pmM.setImageBitmap(this.pmD);
    if (bYZ()) {
      this.pmM.setAlpha(10);
    }
    for (;;)
    {
      this.png.add(0, localBitmap);
      AppMethodBeat.o(43580);
      return;
      this.pmM.setAlpha(255);
    }
  }
  
  private void bYV()
  {
    AppMethodBeat.i(43563);
    bZk();
    bZp();
    bZl();
    bZi();
    AppMethodBeat.o(43563);
  }
  
  private void bYW()
  {
    AppMethodBeat.i(43565);
    com.tencent.mm.wallet_core.ui.e.RX(32);
    com.tencent.mm.pluginsdk.wallet.h.al(this, this.mhr);
    AppMethodBeat.o(43565);
  }
  
  private void bYX()
  {
    AppMethodBeat.i(43577);
    if ((!this.pnu) && (!at.isNetworkConnected(getBaseContext())))
    {
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.bYH();
      if (com.tencent.mm.plugin.offline.e.bYx() == 0)
      {
        this.pnu = true;
        b.Z(this);
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
      }
    }
    AppMethodBeat.o(43577);
  }
  
  private void bYY()
  {
    AppMethodBeat.i(43578);
    int i = com.tencent.mm.plugin.offline.c.a.bZB();
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.bZz();
    if (c.bYT())
    {
      this.mState = 7;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
      AppMethodBeat.o(43578);
      return;
    }
    if (!at.isNetworkConnected(getBaseContext()))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
      this.mState = 6;
      AppMethodBeat.o(43578);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.bZw())
    {
      if (i == 0)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
        this.mState = 1;
        AppMethodBeat.o(43578);
        return;
      }
      if ((i != 0) && (localBankcard == null))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
        this.mState = 2;
        AppMethodBeat.o(43578);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
      this.mState = 5;
      AppMethodBeat.o(43578);
      return;
    }
    if (i == 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
      this.mState = 1;
      AppMethodBeat.o(43578);
      return;
    }
    if ((i != 0) && (localBankcard == null))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
      this.mState = 2;
      AppMethodBeat.o(43578);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
    this.mState = 5;
    AppMethodBeat.o(43578);
  }
  
  private boolean bYZ()
  {
    return (this.mState == 2) || (this.mState == 1) || (this.mState == 7);
  }
  
  private void bZa()
  {
    AppMethodBeat.i(43581);
    Bitmap localBitmap = this.pmE;
    this.pmE = bZc();
    this.pmN.setImageBitmap(this.pmE);
    if (bYZ()) {
      this.pmN.setAlpha(10);
    }
    for (;;)
    {
      this.pnh.add(0, localBitmap);
      AppMethodBeat.o(43581);
      return;
      this.pmN.setAlpha(255);
    }
  }
  
  private void bZb()
  {
    AppMethodBeat.i(43582);
    if (this.pni != null)
    {
      this.pni.iJ(this.pmZ, this.pkz);
      this.pni.pmD = this.pmD;
      this.pni.pmE = this.pmE;
      this.pni.dSP();
    }
    AppMethodBeat.o(43582);
  }
  
  private Bitmap bZc()
  {
    AppMethodBeat.i(43584);
    if (TextUtils.isEmpty(this.pkz))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
      AppMethodBeat.o(43584);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.by.a.a.b(this, this.pkz, 5, 0);
    AppMethodBeat.o(43584);
    return localBitmap;
  }
  
  private Bitmap bZd()
  {
    AppMethodBeat.i(43585);
    if (TextUtils.isEmpty(this.pmZ))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
      AppMethodBeat.o(43585);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.by.a.a.b(this, this.pmZ, 12, 3);
    AppMethodBeat.o(43585);
    return localBitmap;
  }
  
  private void bZe()
  {
    AppMethodBeat.i(43589);
    if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
      this.mTipDialog.dismiss();
    }
    AppMethodBeat.o(43589);
  }
  
  private void bZf()
  {
    AppMethodBeat.i(43590);
    doSceneProgress(new n(System.currentTimeMillis(), com.tencent.mm.plugin.offline.c.a.poh), false);
    AppMethodBeat.o(43590);
  }
  
  private void bZh()
  {
    AppMethodBeat.i(43595);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.bZy();
    if (localBankcard != null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard");
      com.tencent.mm.plugin.offline.c.a.Wr(localBankcard.field_bindSerial);
      this.pjW = localBankcard.field_bindSerial;
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.bYH().pjW = this.pjW;
      AppMethodBeat.o(43595);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
    AppMethodBeat.o(43595);
  }
  
  private void bZi()
  {
    AppMethodBeat.i(43596);
    if (this.pnc)
    {
      AppMethodBeat.o(43596);
      return;
    }
    if (!this.pnk.AZ(4))
    {
      AppMethodBeat.o(43596);
      return;
    }
    com.tencent.mm.kernel.g.RM();
    if ((!((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yDG, Boolean.FALSE)).booleanValue()) && (!this.pnk.isShowing())) {
      bZj();
    }
    AppMethodBeat.o(43596);
  }
  
  private void bZj()
  {
    AppMethodBeat.i(43597);
    if (!this.pnk.AZ(4))
    {
      AppMethodBeat.o(43597);
      return;
    }
    this.pnk.du(this.pmL);
    AppMethodBeat.o(43597);
  }
  
  private void bZk()
  {
    AppMethodBeat.i(43598);
    if (!this.pnk.AZ(1))
    {
      AppMethodBeat.o(43598);
      return;
    }
    if (this.pnk.pmi == 1) {
      this.pnk.dismiss();
    }
    boolean bool1 = t.cTN().cUn();
    boolean bool2 = t.cTN().cUm();
    if ((bool1) || (bool2))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.pnk.a(this.pmL, new WalletOfflineCoinPurseUI.24(this), 1);
    }
    AppMethodBeat.o(43598);
  }
  
  private void bZl()
  {
    AppMethodBeat.i(43599);
    if (!this.pnk.AZ(3))
    {
      AppMethodBeat.o(43599);
      return;
    }
    if (this.pnk.pmi == 3) {
      this.pnk.dismiss();
    }
    com.tencent.mm.plugin.offline.k.bYF();
    String str1 = com.tencent.mm.plugin.offline.k.AY(196617);
    com.tencent.mm.wallet_core.c.b.dSi();
    boolean bool1 = com.tencent.mm.wallet_core.c.b.isCertExist(str1);
    boolean bool2 = com.tencent.mm.plugin.offline.c.a.bZw();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) || (!bool2)) {
      if (!bool1)
      {
        com.tencent.mm.kernel.g.RM();
        String str2 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yxu, "");
        if ((str2 == null) || (!str2.equals(com.tencent.mm.compatible.e.q.bP(true)))) {
          break label213;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + str1 + " ,recreate offline");
      com.tencent.mm.plugin.offline.c.a.bZH();
      this.pnk.a(this.pmL, new WalletOfflineCoinPurseUI.25(this), 3);
      AppMethodBeat.o(43599);
      return;
      label213:
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
    }
  }
  
  private void bZm()
  {
    AppMethodBeat.i(43600);
    if (!this.pnk.AZ(5))
    {
      AppMethodBeat.o(43600);
      return;
    }
    if (this.pnk.pmi == 5) {
      this.pnk.dismiss();
    }
    this.pnk.b(this.pmL, new WalletOfflineCoinPurseUI.26(this));
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 73L, 1L, true);
    AppMethodBeat.o(43600);
  }
  
  private void bZo()
  {
    AppMethodBeat.i(43602);
    if ((this.pnk.isShowing()) && (this.pnk.pmi == 5)) {
      this.pnk.dismiss();
    }
    AppMethodBeat.o(43602);
  }
  
  private boolean bZp()
  {
    AppMethodBeat.i(43603);
    if (!this.pnk.AZ(2))
    {
      AppMethodBeat.o(43603);
      return false;
    }
    if (this.pnk.pmi == 2) {
      this.pnk.dismiss();
    }
    List localList = com.tencent.mm.plugin.offline.c.a.bZC();
    if (localList.size() <= 0)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      AppMethodBeat.o(43603);
      return false;
    }
    int i = 0;
    while (i < localList.size())
    {
      Bankcard localBankcard = (Bankcard)localList.get(i);
      if ((localBankcard != null) && (localBankcard.field_support_micropay) && (bo.isNullOrNil(localBankcard.field_forbidWord)))
      {
        AppMethodBeat.o(43603);
        return true;
      }
      i += 1;
    }
    this.pnk.dismiss();
    this.pnk.a(this.pmL, new WalletOfflineCoinPurseUI.28(this), new WalletOfflineCoinPurseUI.29(this));
    AppMethodBeat.o(43603);
    return false;
  }
  
  private void bZq()
  {
    AppMethodBeat.i(43604);
    if (!com.tencent.mm.plugin.offline.c.a.bZw())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.bZw()) });
      AppMethodBeat.o(43604);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.jX(false).size() <= 0)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      this.pmR.setVisibility(8);
      AppMethodBeat.o(43604);
      return;
    }
    Object localObject = ae.nG(true);
    com.tencent.mm.ui.widget.b.d locald = new com.tencent.mm.ui.widget.b.d(this, 2, true);
    int i = 0;
    int k;
    for (int j = 0; i < ((List)localObject).size(); j = k)
    {
      Bankcard localBankcard = (Bankcard)((List)localObject).get(i);
      k = j;
      if (!bo.isNullOrNil(localBankcard.field_bindSerial))
      {
        k = j;
        if (this.pjW.equals(localBankcard.field_bindSerial)) {
          k = i;
        }
      }
      i += 1;
    }
    locald.sao = new WalletOfflineCoinPurseUI.30(this, (List)localObject, locald);
    locald.sap = new WalletOfflineCoinPurseUI.31(this, locald, (List)localObject);
    localObject = View.inflate(this, 2130971209, null);
    locald.pXc = true;
    locald.udx = j;
    locald.AHi = true;
    locald.G((View)localObject, false);
    locald.crd();
    com.tencent.mm.plugin.report.service.h.qsU.e(13955, new Object[] { Integer.valueOf(3) });
    AppMethodBeat.o(43604);
  }
  
  private static void bZr()
  {
    AppMethodBeat.i(43605);
    if (!com.tencent.mm.plugin.offline.c.a.bZP())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.bYI().eX(3, 3);
    }
    AppMethodBeat.o(43605);
  }
  
  private void bdQ()
  {
    AppMethodBeat.i(43575);
    if (com.tencent.mm.plugin.offline.c.a.bZw())
    {
      this.pmT.setVisibility(0);
      AppMethodBeat.o(43575);
      return;
    }
    this.pmT.setVisibility(4);
    AppMethodBeat.o(43575);
  }
  
  private void ber()
  {
    AppMethodBeat.i(43583);
    int i;
    if (this.png.size() >= 2)
    {
      i = this.png.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.e.I((Bitmap)this.png.remove(i));
        i -= 1;
      }
    }
    if (this.pnh.size() >= 2)
    {
      i = this.pnh.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.e.I((Bitmap)this.pnh.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(43583);
  }
  
  private void biu()
  {
    AppMethodBeat.i(43612);
    aw localaw = com.tencent.mm.plugin.wallet_core.model.m.cTC();
    Object localObject = new StringBuilder().append(this.pmZ);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ();
    localObject = ag.cE(com.tencent.mm.a.p.getString(com.tencent.mm.kernel.a.getUin()));
    if (localaw != null) {
      com.tencent.mm.plugin.report.service.h.qsU.e(13444, new Object[] { localaw.wmQ, localaw.wmR, Long.valueOf(localaw.wmP), localObject, localaw.wmS, localaw.wmT });
    }
    AppMethodBeat.o(43612);
  }
  
  private void e(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(43591);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(43591);
      return;
    }
    Bitmap localBitmap = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramString));
    if (localBitmap != null) {
      paramImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(localBitmap, paramInt, paramInt, true, false));
    }
    this.pmB.put(paramString, paramImageView);
    this.pmC.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(43591);
  }
  
  private void jW(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(43579);
    long l = System.currentTimeMillis();
    int i;
    if ((paramBoolean) && ((bo.isNullOrNil(this.pmZ)) || (bo.isNullOrNil(this.pkz))))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
      bZm();
      bMX();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - l));
      bZa();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - l));
      ber();
      bZb();
      com.tencent.mm.wallet_core.c.z.id(10, 0);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
      if (!com.tencent.mm.plugin.offline.c.a.eD(ah.getContext())) {
        break label277;
      }
      i = 0;
      label144:
      if (at.isNetworkConnected(ah.getContext())) {
        j = 1;
      }
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.bYH();
      localh.e(14163, new Object[] { Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(com.tencent.mm.plugin.offline.e.bYx()) });
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 67L, 1L, true);
      if (!at.isNetworkConnected(ah.getContext())) {
        break label282;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 32L, 1L, true);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.offline.c.a.eD(this)) {
        break label299;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 34L, 1L, true);
      AppMethodBeat.o(43579);
      return;
      bZo();
      break;
      label277:
      i = 1;
      break label144;
      label282:
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 33L, 1L, true);
    }
    label299:
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 35L, 1L, true);
    AppMethodBeat.o(43579);
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(43587);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
      AppMethodBeat.o(43587);
      return false;
    }
    bZe();
    this.pni.dismiss();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "msgtype=" + paramc.plW);
    int i;
    if (4 == paramc.plW)
    {
      this.pna = false;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = this.pnj;
      if (paramc == null) {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
      }
      for (;;)
      {
        if ((this.pnd) && (!this.pne))
        {
          this.pnd = false;
          this.pna = false;
        }
        if (i != 0)
        {
          Ba(0);
          jW(true);
        }
        AppMethodBeat.o(43587);
        return true;
        if (5 == paramc.plW)
        {
          this.pna = true;
          this.pnd = true;
          this.pne = false;
          if (this.pnw.dtj()) {
            break label420;
          }
          this.pnw.stopTimer();
          i = 0;
          break;
        }
        if (6 == paramc.plW)
        {
          if (!this.pnw.dtj()) {
            this.pnw.stopTimer();
          }
          if (!this.pkE.dtj()) {
            this.pkE.stopTimer();
          }
          this.pna = false;
          if (!com.tencent.mm.plugin.offline.c.a.bZx()) {
            break label1557;
          }
          i = 0;
          break;
        }
        if (8 == paramc.plW)
        {
          if (this.pnw.dtj()) {
            break label1557;
          }
          this.pnw.stopTimer();
          i = 1;
          break;
        }
        if (23 == paramc.plW)
        {
          if (this.pnw.dtj()) {
            break label420;
          }
          this.pnw.stopTimer();
          i = 0;
          break;
        }
        if (20 == paramc.plW)
        {
          this.pna = false;
          if (this.pnw.dtj()) {
            break label420;
          }
          this.pnw.stopTimer();
          i = 0;
          break;
        }
        if (24 != paramc.plW) {
          break label1557;
        }
        if (com.tencent.mm.plugin.offline.c.a.bZX())
        {
          this.pna = true;
          if (com.tencent.mm.plugin.offline.c.a.bZX())
          {
            if (this.mTipDialog != null) {
              break label425;
            }
            this.mTipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), false, new WalletOfflineCoinPurseUI.18(this));
          }
        }
        for (;;)
        {
          localObject1 = this.pnw;
          long l = com.tencent.mm.plugin.offline.g.bYz();
          ((ap)localObject1).ag(l, l);
          label420:
          i = 0;
          break;
          label425:
          if (!this.mTipDialog.isShowing()) {
            this.mTipDialog.show();
          }
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + paramc.plW);
        if (paramc.plW == 24) {
          ((c)localObject1).kqP.vibrate(50L);
        }
        if (4 == paramc.plW)
        {
          ((c)localObject1).a((s.b)paramc);
          com.tencent.mm.plugin.offline.g.bYA();
        }
        else
        {
          if (5 == paramc.plW)
          {
            paramc = (s.e)paramc;
            if (paramc != null)
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + paramc.plZ + " msg.wxRetMsg:" + paramc.pma + " msg.cftRetCode:" + paramc.plZ + " msg.cftRetMsg:" + paramc.plY);
              if ((!TextUtils.isEmpty(paramc.plZ)) || (!TextUtils.isEmpty(paramc.pma)) || (!TextUtils.isEmpty(paramc.plX)) || (!TextUtils.isEmpty(paramc.plY)))
              {
                if ((!TextUtils.isEmpty(paramc.plZ)) || (!TextUtils.isEmpty(paramc.pma)) || (TextUtils.isEmpty(paramc.plX)) || (TextUtils.isEmpty(paramc.plY))) {
                  break label706;
                }
                b.d(((c)localObject1).mActivity, paramc.plY);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.offline.g.bYA();
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 0L, 1L, true);
              break;
              label706:
              if ((!TextUtils.isEmpty(paramc.plZ)) && (com.tencent.mm.plugin.offline.c.a.isNumeric(paramc.plZ))) {
                ((c)localObject1).a(null, Integer.valueOf(paramc.plZ).intValue(), paramc.pma, paramc.pmb);
              } else {
                b.d(((c)localObject1).mActivity, paramc.pma);
              }
            }
          }
          Object localObject2;
          int j;
          if (6 == paramc.plW)
          {
            paramc = (s.f)paramc;
            if (paramc != null)
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + paramc.pmd);
              com.tencent.mm.plugin.offline.k.bYF();
              localObject2 = com.tencent.mm.plugin.offline.k.bYJ().Wl(paramc.pme.cnI);
              if (localObject2 == null) {
                break label946;
              }
              if (((r)localObject2).field_status != com.tencent.mm.plugin.offline.g.pkk) {
                break label941;
              }
              j = 1;
            }
            for (;;)
            {
              if (j == 0)
              {
                com.tencent.mm.plugin.offline.g.cW(paramc.pme.cnI, com.tencent.mm.plugin.offline.g.pkk);
                com.tencent.mm.plugin.offline.c.a.a(((c)localObject1).mActivity, paramc);
                ((c)localObject1).mActivity.setResult(-1);
                ((c)localObject1).mActivity.finish();
              }
              com.tencent.mm.plugin.offline.g.bYA();
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 7L, 1L, true);
              if (com.tencent.mm.plugin.offline.c.a.poh != 4) {
                break;
              }
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
              com.tencent.mm.plugin.report.service.h.qsU.e(13412, new Object[0]);
              break;
              label941:
              j = 0;
              continue;
              label946:
              j = 0;
            }
          }
          Object localObject3;
          Object localObject4;
          if (8 == paramc.plW)
          {
            paramc = (s.g)paramc;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + paramc.id);
            if (paramc.kWb == 0)
            {
              localObject2 = ((c)localObject1).mActivity.getLayoutInflater().inflate(2130971216, null);
              localObject3 = (TextView)((View)localObject2).findViewById(2131829251);
              localObject4 = (TextView)((View)localObject2).findViewById(2131829252);
              ((TextView)localObject3).setText(paramc.pmg);
              ((TextView)localObject4).setText(paramc.pmf);
              com.tencent.mm.plugin.offline.g.cW(paramc.cwk, com.tencent.mm.plugin.offline.g.pkm);
              com.tencent.mm.ui.base.h.a(((c)localObject1).mActivity, "", (View)localObject2, ((c)localObject1).getString(2131305752), ((c)localObject1).getString(2131296888), new c.11((c)localObject1, paramc), new c.12((c)localObject1, paramc));
            }
            else if (paramc.kWb == 1)
            {
              if (((c)localObject1).pms != null) {
                ((c)localObject1).pms.show();
              }
              com.tencent.mm.plugin.report.service.h.qsU.e(13955, new Object[] { Integer.valueOf(1) });
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + paramc.id);
              com.tencent.mm.plugin.offline.g.cW(paramc.cwk, com.tencent.mm.plugin.offline.g.pkm);
              ((c)localObject1).pms = com.tencent.mm.plugin.wallet_core.ui.q.a(((c)localObject1).mActivity, paramc.pmf, paramc.pmg, new c.13((c)localObject1, paramc), new c.14((c)localObject1), new c.15((c)localObject1, paramc));
              ((c)localObject1).pms.qwP.setVisibility(0);
              ((c)localObject1).pms.qpc.setVisibility(8);
            }
          }
          else
          {
            if (23 == paramc.plW)
            {
              paramc = (s.d)paramc;
              localObject2 = new PayInfo();
              ((PayInfo)localObject2).cnI = paramc.cwk;
              ((PayInfo)localObject2).cCD = 8;
              ((PayInfo)localObject2).wgB = 1;
              ((PayInfo)localObject2).wgv = new Bundle();
              ((PayInfo)localObject2).wgv.putLong("extinfo_key_9", System.currentTimeMillis());
              paramc = new c.1((c)localObject1, (PayInfo)localObject2);
              com.tencent.mm.sdk.b.a.ymk.b(paramc);
              com.tencent.mm.wallet_core.b.dRI();
              label1402:
              String str;
              if ((com.tencent.mm.wallet_core.b.dpQ()) && (((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_OFFLINE_PAY_SWTICH_KEY")))
              {
                j = 1;
                if (j == 0) {
                  break label1485;
                }
                localObject3 = (com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class);
                localObject4 = ((c)localObject1).mActivity;
                str = ((PayInfo)localObject2).cnI;
                localObject2 = ((PayInfo)localObject2).cqx;
                if (((c)localObject1).pmr != null) {
                  break label1471;
                }
              }
              label1471:
              for (paramc = "";; paramc = ((c)localObject1).pmr.bYQ())
              {
                ((com.tencent.mm.pluginsdk.wallet.b)localObject3).startOfflinePay((Context)localObject4, str, (String)localObject2, paramc);
                break;
                j = 0;
                break label1402;
              }
              label1485:
              localObject3 = ((c)localObject1).mActivity;
              if (((c)localObject1).pmr == null) {}
              for (paramc = "";; paramc = ((c)localObject1).pmr.bYQ())
              {
                com.tencent.mm.pluginsdk.wallet.h.a((Context)localObject3, false, "", paramc, (PayInfo)localObject2, "", new Intent(), 1);
                break;
              }
            }
            if (20 == paramc.plW) {
              com.tencent.mm.plugin.offline.g.bYA();
            }
          }
        }
      }
      label1557:
      i = 1;
    }
  }
  
  public final void aNW()
  {
    AppMethodBeat.i(43593);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
    Ba(1);
    jW(true);
    com.tencent.mm.wallet_core.ui.e.RX(40);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 21L, 1L, true);
    if (this.pni.gMK.isShowing())
    {
      if (this.pni.ktM)
      {
        this.pni.dSQ();
        AppMethodBeat.o(43593);
        return;
      }
      this.pni.dismiss();
    }
    bZj();
    AppMethodBeat.o(43593);
  }
  
  public void addDialog(Dialog paramDialog)
  {
    AppMethodBeat.i(43588);
    if (((paramDialog instanceof com.tencent.mm.ui.widget.b.c)) && (this.pnd))
    {
      this.pne = true;
      paramDialog.setOnDismissListener(new WalletOfflineCoinPurseUI.17(this, ((com.tencent.mm.ui.widget.b.c)paramDialog).AGG));
    }
    super.addDialog(paramDialog);
    AppMethodBeat.o(43588);
  }
  
  public final void bYO()
  {
    AppMethodBeat.i(43609);
    bZq();
    AppMethodBeat.o(43609);
  }
  
  public final void bYP()
  {
    AppMethodBeat.i(43610);
    doSceneProgress(new com.tencent.mm.plugin.offline.a.j(""), false);
    AppMethodBeat.o(43610);
  }
  
  public final String bYQ()
  {
    return this.pjW;
  }
  
  public final void bYR()
  {
    AppMethodBeat.i(43614);
    if (!this.pkE.dtj()) {
      this.pkE.stopTimer();
    }
    Ba(0);
    jW(true);
    this.pna = false;
    ap localap = this.pkE;
    long l = this.pkD;
    localap.ag(l, l);
    AppMethodBeat.o(43614);
  }
  
  public final void bZg()
  {
    int j = 0;
    AppMethodBeat.i(43594);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.bZy();
    findViewById(2131829225).setVisibility(0);
    this.pmR.setTextSize(0, getResources().getDimensionPixelSize(2131427809));
    String str;
    Object localObject;
    if ((this.pmR != null) && (localBankcard != null)) {
      if (localBankcard.cTk())
      {
        str = localBankcard.ugi;
        localObject = t.cTN().cUG();
        if ((localObject == null) || (bo.isNullOrNil(localBankcard.field_forbidWord))) {
          break label347;
        }
        Iterator localIterator = ((List)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (com.tencent.mm.plugin.wallet_core.model.e)localIterator.next();
        } while (!((com.tencent.mm.plugin.wallet_core.model.e)localObject).por.equals(localBankcard.field_bindSerial));
      }
    }
    for (;;)
    {
      if ((localObject != null) && (!bo.isNullOrNil(((com.tencent.mm.plugin.wallet_core.model.e)localObject).ufx)))
      {
        if (!localBankcard.cTk()) {
          str = localBankcard.field_desc + ((com.tencent.mm.plugin.wallet_core.model.e)localObject).ufx;
        }
        findViewById(2131829225).setVisibility(8);
        com.tencent.mm.plugin.report.service.h.qsU.e(14515, new Object[] { Integer.valueOf(2) });
        this.pmR.setTextSize(0, getResources().getDimensionPixelSize(2131427758));
      }
      for (int i = 1;; i = 0)
      {
        this.pmR.setText(com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), str, this.pmR.getTextSize()));
        for (;;)
        {
          if (localBankcard != null) {
            a(localBankcard);
          }
          if (i != 0) {
            this.pmS.setImageResource(2131231282);
          }
          AppMethodBeat.o(43594);
          return;
          str = getString(2131305725, new Object[] { localBankcard.field_desc });
          break;
          i = j;
          if (localBankcard == null)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
            i = j;
          }
        }
      }
      label347:
      localObject = null;
    }
  }
  
  public final void bZn()
  {
    AppMethodBeat.i(43601);
    this.pmT.setVisibility(4);
    this.pnk.a(this.pmL, new WalletOfflineCoinPurseUI.27(this));
    AppMethodBeat.o(43601);
  }
  
  public final void bbx()
  {
    AppMethodBeat.i(43607);
    Ba(0);
    jW(true);
    AppMethodBeat.o(43607);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(43608);
    doSceneProgress(new com.tencent.mm.plugin.offline.a.e(paramInt, paramString1, paramString2, paramString3), com.tencent.mm.plugin.offline.c.a.bZx());
    AppMethodBeat.o(43608);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971211;
  }
  
  public void initView()
  {
    AppMethodBeat.i(43571);
    this.pnk = ((OfflineAlertView)findViewById(2131829226));
    this.pnk.dismiss();
    this.pnk.setDialogState(new WalletOfflineCoinPurseUI.4(this));
    com.tencent.mm.wallet_core.c.b.dSi().init(getApplicationContext());
    Object localObject;
    if ((this.gyl == 3) || (this.gyl == 10) || (this.gyl == 11) || (this.gyl == 12))
    {
      setMMTitle(2131305739);
      this.pnj = new c(this, this);
      localObject = this.pnj;
      ((c)localObject).kqP = ((Vibrator)((c)localObject).mActivity.getSystemService("vibrator"));
      this.pni = new com.tencent.mm.wallet_core.ui.c(this, true);
      this.pni.dSO();
      this.pmL = findViewById(2131829218);
      this.pmM = ((ImageView)findViewById(2131829221));
      this.pmN = ((ImageView)findViewById(2131829220));
      this.pmO = ((TextView)findViewById(2131829219));
      this.pmQ = findViewById(2131829222);
      this.pmR = ((TextView)findViewById(2131829224));
      this.pmS = ((ImageView)findViewById(2131829223));
      this.pmT = ((RelativeLayout)findViewById(2131829217));
      this.pmT.setOnClickListener(new WalletOfflineCoinPurseUI.13(this));
      this.pmM.setOnClickListener(this.gMO);
      this.pmN.setOnClickListener(this.gMO);
      this.pmO.setOnClickListener(this.gMO);
      this.pmQ.setClickable(true);
      this.pmQ.setOnClickListener(new WalletOfflineCoinPurseUI.14(this));
      this.mLastTime = System.currentTimeMillis();
      this.pmU = ((LinearLayout)findViewById(2131829227));
      this.pmV = ((LinearLayout)findViewById(2131829233));
      this.pmW = ((LinearLayout)findViewById(2131829235));
      this.pmX = ((LinearLayout)findViewById(2131829231));
      this.pmY = ((LinearLayout)findViewById(2131829237));
      if ((this.gyl != 3) && (this.gyl != 10) && (this.gyl != 11) && (this.gyl != 12)) {
        break label765;
      }
      this.pmU.setVisibility(8);
      this.pmV.setVisibility(8);
      this.pmW.setVisibility(8);
      this.pmX.setVisibility(8);
      if ((com.tencent.mm.plugin.offline.c.a.bZw()) && (c.bYT()))
      {
        localObject = this.pnj;
        com.tencent.mm.plugin.offline.k.bYF();
        ((c)localObject).a(com.tencent.mm.plugin.offline.k.bYG().plP);
      }
      bYY();
      E(true, false);
      localObject = this.pkE;
      long l1 = this.pkD;
      ((ap)localObject).ag(l1, l1);
      if ((com.tencent.mm.plugin.offline.c.a.poh != 3) || (!com.tencent.mm.plugin.offline.c.a.pok)) {
        break label1233;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
      int i = com.tencent.mm.plugin.offline.c.a.poi;
      l1 = com.tencent.mm.plugin.offline.c.a.poj;
      long l2 = System.currentTimeMillis();
      long l3 = i * 1000 + l1 - l2;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + l1 + " now:" + l2 + " interval:" + l3);
      if ((com.tencent.mm.plugin.offline.c.a.poi <= 0) || (com.tencent.mm.plugin.offline.c.a.poj <= 0L) || (l3 <= 0L)) {
        break label1221;
      }
      if (!this.pnx.dtj()) {
        this.pnx.stopTimer();
      }
      this.pnx.ag(l3, l3);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
    }
    for (;;)
    {
      bYX();
      localObject = new vd();
      ((vd)localObject).cLE.bSd = "5";
      ((vd)localObject).callback = new WalletOfflineCoinPurseUI.5(this, (vd)localObject);
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(43571);
      return;
      setMMTitle(2131305740);
      break;
      label765:
      this.pmX.setVisibility(0);
      this.pmY.setVisibility(0);
      boolean bool1 = com.tencent.mm.x.c.PJ().b(ac.a.yIA, ac.a.yHA);
      boolean bool2 = com.tencent.mm.x.c.PJ().b(ac.a.yIB, ac.a.yHA);
      boolean bool3 = com.tencent.mm.x.c.PJ().b(ac.a.yIC, ac.a.yHA);
      boolean bool4 = com.tencent.mm.x.c.PJ().b(ac.a.yID, ac.a.yHA);
      boolean bool5 = com.tencent.mm.x.c.PJ().b(ac.a.yIE, ac.a.yHA);
      localObject = (ImageView)this.pmV.findViewById(2131829234);
      ImageView localImageView1 = (ImageView)this.pmU.findViewById(2131829228);
      ImageView localImageView2 = (ImageView)this.pmW.findViewById(2131829236);
      ImageView localImageView3 = (ImageView)this.pmX.findViewById(2131829232);
      TextView localTextView = (TextView)this.pmU.findViewById(2131829229);
      ImageView localImageView4 = (ImageView)this.pmU.findViewById(2131829230);
      ImageView localImageView5 = (ImageView)this.pmY.findViewById(2131829238);
      if (bool1) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (bool2)
      {
        com.tencent.mm.kernel.g.RM();
        String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHR, "");
        if (!bo.isNullOrNil(str))
        {
          localTextView.setText(str);
          localTextView.setVisibility(0);
          localImageView4.setVisibility(0);
        }
      }
      else
      {
        label1022:
        if (bool3) {
          localImageView2.setVisibility(0);
        }
        if (bool4) {
          localImageView3.setVisibility(0);
        }
        if (bool5) {
          localImageView5.setVisibility(0);
        }
        if (!((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIF, Boolean.FALSE)).booleanValue()) {
          break label1189;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
      }
      for (;;)
      {
        this.pmU.setOnClickListener(new WalletOfflineCoinPurseUI.7(this, localImageView1, localTextView, localImageView4));
        this.pmV.setOnClickListener(new WalletOfflineCoinPurseUI.8(this, (ImageView)localObject));
        this.pmW.setOnClickListener(new WalletOfflineCoinPurseUI.9(this, localImageView2));
        this.pmX.setOnClickListener(new WalletOfflineCoinPurseUI.10(this, localImageView3));
        this.pmY.setOnClickListener(new WalletOfflineCoinPurseUI.11(this, localImageView5));
        break;
        localImageView1.setVisibility(0);
        break label1022;
        label1189:
        getWindow().getDecorView().post(new WalletOfflineCoinPurseUI.6(this, bool2, bool4, bool1, bool3, bool5));
      }
      label1221:
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
      continue;
      label1233:
      if (com.tencent.mm.plugin.offline.c.a.poh == 3) {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
      } else {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.c.a.poh) });
      }
    }
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(43592);
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(43592);
      return;
    }
    ImageView localImageView = (ImageView)this.pmB.get(paramString);
    paramString = (Integer)this.pmC.get(paramString);
    if ((localImageView == null) || (paramString == null))
    {
      AppMethodBeat.o(43592);
      return;
    }
    new ak(getMainLooper()).post(new WalletOfflineCoinPurseUI.19(this, paramString, paramBitmap, localImageView));
    AppMethodBeat.o(43592);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(43562);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.offline.k.pkO = true;
    com.tencent.mm.wallet_core.ui.e.RX(41);
    paramBundle = getIntent();
    this.pnc = paramBundle.getBooleanExtra("is_offline_create", false);
    if ((paramBundle != null) && (paramBundle.hasExtra("key_entry_scene"))) {
      this.gyl = paramBundle.getIntExtra("key_entry_scene", this.gyl);
    }
    this.ejF = paramBundle.getIntExtra("key_from_scene", 0);
    this.pmP = bo.bf(paramBundle.getStringExtra("key_business_attach"), "");
    this.mhr = 1;
    if (this.gyl == 2) {
      this.mhr = 1;
    }
    for (;;)
    {
      getWindow().addFlags(8192);
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
      setContentViewVisibility(0);
      setActionbarColor(getResources().getColor(2131690655));
      hideActionbarLine();
      paramBundle = getWindow().getAttributes();
      if (paramBundle.screenBrightness < 0.85F)
      {
        paramBundle.screenBrightness = 0.85F;
        getWindow().setAttributes(paramBundle);
      }
      setBackBtn(new WalletOfflineCoinPurseUI.34(this));
      try
      {
        bc.a(this, this);
        i = 1;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", paramBundle, "", new Object[0]);
          getWindow().setFlags(8192, 8192);
          int i = 0;
          continue;
          if (t.cTN().cUn())
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
            com.tencent.mm.plugin.offline.c.a.bZH();
            com.tencent.mm.plugin.offline.k.bYF();
            com.tencent.mm.plugin.offline.k.aT(196648, "0");
          }
          else if ((t.cTN().cUl()) && (com.tencent.mm.plugin.offline.c.a.bZw()))
          {
            bZr();
          }
        }
      }
      if (i != 0) {
        bc.a(this, null);
      }
      com.tencent.mm.wallet_core.ui.e.dST();
      if (!com.tencent.mm.plugin.offline.a.q.isEnabled()) {
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 8), false);
      }
      if (!t.cTN().cUq()) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
      initView();
      x.a(this);
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.bYG().a(this);
      addSceneEndListener(606);
      addSceneEndListener(609);
      addSceneEndListener(1501);
      com.tencent.mm.plugin.offline.k.bYF();
      com.tencent.mm.plugin.offline.k.bYH().ce(this);
      com.tencent.mm.sdk.b.a.ymk.c(this.pnt);
      com.tencent.mm.plugin.offline.c.a.bZI();
      com.tencent.mm.sdk.b.a.ymk.b(this.pnr);
      com.tencent.mm.sdk.b.a.ymk.b(this.pnp);
      com.tencent.mm.sdk.b.a.ymk.b(this.pnm);
      this.pnn.alive();
      this.pno.alive();
      this.pnb = new com.tencent.mm.plugin.offline.g();
      paramBundle = new ll();
      paramBundle.cBF.axc = hashCode();
      com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
      this.pnq.alive();
      AppMethodBeat.o(43562);
      return;
      if (this.gyl == 1) {
        this.mhr = 2;
      } else if (this.gyl == 8) {
        this.mhr = 4;
      } else if (this.gyl == 4) {
        this.mhr = 6;
      } else {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[] { Integer.valueOf(this.mhr) });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43568);
    com.tencent.mm.plugin.offline.k.pkO = false;
    com.tencent.mm.wallet_core.ui.e.I(this.pmD);
    com.tencent.mm.wallet_core.ui.e.I(this.pmE);
    com.tencent.mm.wallet_core.ui.e.at(this.png);
    com.tencent.mm.wallet_core.ui.e.at(this.pnh);
    this.png.clear();
    this.pnh.clear();
    this.pmI.clear();
    this.pmJ.clear();
    this.pmK.clear();
    x.c(this);
    com.tencent.mm.plugin.offline.k.bYF();
    com.tencent.mm.plugin.offline.k.bYG().b(this);
    removeSceneEndListener(606);
    removeSceneEndListener(609);
    removeSceneEndListener(1501);
    com.tencent.mm.plugin.offline.k.bYF();
    com.tencent.mm.plugin.offline.k.bYH().cf(this);
    com.tencent.mm.sdk.b.a.ymk.d(this.pnt);
    com.tencent.mm.sdk.b.a.ymk.d(this.pnr);
    com.tencent.mm.sdk.b.a.ymk.d(this.pnm);
    if (!this.pkE.dtj()) {
      this.pkE.stopTimer();
    }
    if (!this.pnx.dtj()) {
      this.pnx.stopTimer();
    }
    if (this.pni != null) {
      this.pni.release();
    }
    if (this.pnj != null)
    {
      localObject = this.pnj;
      ((c)localObject).kqP.cancel();
      ((c)localObject).mActivity = null;
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.pnp);
    this.pnn.dead();
    this.pno.dead();
    Object localObject = this.pnb;
    ((com.tencent.mm.plugin.offline.g)localObject).stop();
    com.tencent.mm.plugin.offline.g.bYA();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(385, ((com.tencent.mm.plugin.offline.g)localObject).pko);
    ((com.tencent.mm.plugin.offline.g)localObject).pkq = null;
    this.pnq.dead();
    super.onDestroy();
    AppMethodBeat.o(43568);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(43613);
    if ((paramInt == 4) && (this.pnk != null) && (this.pnk.getVisibility() == 0) && (this.pnk.pmk))
    {
      this.pnk.dismiss();
      AppMethodBeat.o(43613);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(43613);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(43566);
    super.onNewIntent(paramIntent);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
    this.pmG = true;
    AppMethodBeat.o(43566);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(43567);
    com.tencent.mm.plugin.offline.k.bYF();
    com.tencent.mm.plugin.offline.i locali = com.tencent.mm.plugin.offline.k.bYI();
    locali.mHandler.removeCallbacks(locali.pkC);
    bc.a(this, null);
    this.bNX = false;
    com.tencent.mm.sdk.b.a.ymk.d(this.pns);
    this.pnb.stop();
    super.onPause();
    AppMethodBeat.o(43567);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(43564);
    super.onResume();
    com.tencent.mm.sdk.b.a.ymk.c(this.pns);
    try
    {
      bc.a(this, this);
      if (!this.pnl)
      {
        bYV();
        this.pnl = true;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
      this.bNX = true;
      Object localObject = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.walletlock.a.b.class);
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).a(this, ((com.tencent.mm.plugin.walletlock.a.b)localObject).cXt(), null);
      if (at.isNetworkConnected(getBaseContext()))
      {
        if (t.cTN().cUq()) {
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 8));
        }
        if (com.tencent.mm.plugin.offline.c.a.bZw())
        {
          com.tencent.mm.plugin.offline.k.bYF();
          com.tencent.mm.plugin.offline.k.bYI().jV(false);
          if (!c.bYT())
          {
            if (!com.tencent.mm.plugin.offline.a.q.isEnabled()) {
              break label415;
            }
            doSceneProgress(new com.tencent.mm.plugin.offline.a.q(com.tencent.mm.plugin.offline.c.a.poh), false);
          }
        }
      }
      bYY();
      localObject = com.tencent.mm.plugin.offline.c.a.bZy();
      if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (!((Bankcard)localObject).field_bindSerial.equals(this.pjW)))
      {
        this.pjW = ((Bankcard)localObject).field_bindSerial;
        com.tencent.mm.plugin.offline.k.bYF();
        com.tencent.mm.plugin.offline.k.bYH().pjW = this.pjW;
        i = 1;
        if ((i != 0) || ((this.pmH) && (this.pmG)))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
          this.pmH = false;
          this.pmG = false;
          bZg();
          Ba(0);
          jW(true);
        }
        localObject = this.pnb;
        if (!com.tencent.mm.plugin.offline.c.a.bZX()) {
          break label457;
        }
        com.tencent.mm.sdk.platformtools.ab.i(com.tencent.mm.plugin.offline.g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + ((com.tencent.mm.plugin.offline.g)localObject).pkq.dtj());
        if ((((com.tencent.mm.plugin.offline.g)localObject).pkq != null) && (!((com.tencent.mm.plugin.offline.g)localObject).pkq.dtj())) {
          break label466;
        }
        ((com.tencent.mm.plugin.offline.g)localObject).status = 1;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 61L, 1L, true);
        if (!((com.tencent.mm.plugin.offline.g)localObject).pkp) {
          break label427;
        }
        com.tencent.mm.plugin.offline.g.bYA();
        localObject = ((com.tencent.mm.plugin.offline.g)localObject).pkq;
        l = com.tencent.mm.plugin.offline.g.pjZ;
        ((ap)localObject).ag(l, l);
        i = com.tencent.mm.plugin.offline.g.pjZ;
        AppMethodBeat.o(43564);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", localException, "", new Object[0]);
        continue;
        label415:
        bZf();
        continue;
        i = 0;
      }
      label427:
      ap localap = localException.pkq;
      long l = com.tencent.mm.plugin.offline.g.pkn;
      localap.ag(l, l);
      int i = com.tencent.mm.plugin.offline.g.pkn;
      AppMethodBeat.o(43564);
      return;
    }
    label457:
    com.tencent.mm.sdk.platformtools.ab.i(com.tencent.mm.plugin.offline.g.TAG, "OfflineGetMsg is not in abtest");
    label466:
    AppMethodBeat.o(43564);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(43569);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " scene: " + paramm);
    if (((paramm instanceof com.tencent.mm.plugin.offline.a.f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.pkB.bYK();
      this.pkB = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
      {
        if (com.tencent.mm.plugin.offline.c.a.bZw())
        {
          if (com.tencent.mm.plugin.offline.c.a.bZz() != null) {
            bZf();
          }
          bZr();
        }
        bZp();
        if ((!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab)) && (!(paramm instanceof n)) && (!(paramm instanceof com.tencent.mm.plugin.offline.a.a)) && (!(paramm instanceof com.tencent.mm.plugin.offline.a.e))) {
          break label836;
        }
        bYY();
        E(false, true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(43569);
      return true;
      if ((paramm instanceof com.tencent.mm.plugin.offline.a.m))
      {
        this.pkB = ((com.tencent.mm.plugin.offline.a.m)paramm);
        paramString = this.pkB.plD;
        com.tencent.mm.plugin.offline.k.bYF();
        paramString = new com.tencent.mm.plugin.offline.a.f(paramString, com.tencent.mm.plugin.offline.k.AY(196617));
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
        break;
      }
      if ((paramm instanceof com.tencent.mm.plugin.offline.a.j))
      {
        bYY();
        bYV();
        break;
      }
      if ((paramm instanceof n))
      {
        paramString = (n)paramm;
        if ("1".equals(paramString.plI))
        {
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
          if (bo.isNullOrNil(paramString.plJ)) {}
          for (paramString = getString(2131305032);; paramString = paramString.plJ)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", false, new WalletOfflineCoinPurseUI.2(this));
            AppMethodBeat.o(43569);
            return true;
          }
        }
        if (paramString.pld == 0)
        {
          c localc = this.pnj;
          localc.pmt = com.tencent.mm.plugin.offline.c.a.bZD();
          localc.pmt = localc.pmt;
          if (!"1".equals(paramString.plH)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
          doSceneProgress(new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 8), false);
          break;
        }
        if (paramString.pld == 0) {
          break;
        }
        this.pnj.a(paramString, paramString.pld, paramString.ple);
        break;
      }
      if ((paramm instanceof com.tencent.mm.plugin.offline.a.a)) {
        break;
      }
      if ((paramm instanceof com.tencent.mm.plugin.offline.a.e))
      {
        this.pnj.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
        break;
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f))
      {
        if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
          this.mTipDialog.dismiss();
        }
        paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.f)paramm;
        if (("1".equals(paramString.uel)) || (("2".equals(paramString.uel)) && (!bo.isNullOrNil(paramString.uem))))
        {
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_activity", ".ui.WalletOfflineCoinPurseUI");
          paramString.putString("realname_verify_process_jump_plugin", "offline");
          com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramString, null, 1006);
        }
        for (;;)
        {
          AppMethodBeat.o(43569);
          return true;
          if ("collect".equals(paramString.uep)) {
            bYW();
          } else if ("reward".equals(paramString.uep)) {
            com.tencent.mm.bq.d.H(getContext(), "collect", ".reward.ui.QrRewardMainUI");
          } else {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { paramString.uep });
          }
        }
      }
      if (!(paramm instanceof com.tencent.mm.plugin.offline.a.q)) {
        break;
      }
      paramString = (com.tencent.mm.plugin.offline.a.q)paramm;
      if ((paramString.isJumpRemind()) && (!this.pnf) && (paramString.getJumpRemind().a(this, new WalletOfflineCoinPurseUI.3(this)))) {
        this.pnf = true;
      }
      onSceneEnd(paramString.plO.errType, paramString.plO.errCode, paramString.plO.errMsg, paramString.plM);
      onSceneEnd(paramString.plN.errType, paramString.plN.errCode, paramString.plN.errMsg, paramString.plL);
      break;
      label836:
      if ((paramm instanceof com.tencent.mm.plugin.offline.a.f))
      {
        bYY();
        E(true, true);
        continue;
        if ((paramm instanceof n))
        {
          bYY();
          E(false, true);
          if (411 == paramInt2) {
            this.pnj.a(paramm, paramInt2, paramString);
          }
        }
        else if ((paramm instanceof com.tencent.mm.plugin.offline.a.e))
        {
          this.pnj.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
        }
        else if (!(paramm instanceof com.tencent.mm.plugin.offline.a.j))
        {
          if ((paramm instanceof com.tencent.mm.plugin.offline.a.f))
          {
            this.pkB = null;
          }
          else if ((paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f))
          {
            if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
              this.mTipDialog.dismiss();
            }
          }
          else if ((paramm instanceof com.tencent.mm.plugin.offline.a.q))
          {
            bYY();
            E(false, true);
            if (411 == paramInt2) {
              this.pnj.a(paramm, paramInt2, paramString);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI
 * JD-Core Version:    0.7.0.1
 */