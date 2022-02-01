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
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.autogen.a.acx;
import com.tencent.mm.autogen.a.acx.b;
import com.tencent.mm.autogen.a.adb;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.autogen.a.bh;
import com.tencent.mm.autogen.a.cz;
import com.tencent.mm.autogen.a.do;
import com.tencent.mm.autogen.a.kg;
import com.tencent.mm.autogen.a.my;
import com.tencent.mm.autogen.a.my.a;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.autogen.a.qn;
import com.tencent.mm.autogen.a.qo;
import com.tencent.mm.autogen.a.rf;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.a.zp.b;
import com.tencent.mm.autogen.mmdata.rpt.av;
import com.tencent.mm.autogen.mmdata.rpt.rq;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.offline.a.b.a;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.a.u.a;
import com.tencent.mm.plugin.offline.a.u.b;
import com.tencent.mm.plugin.offline.a.u.d;
import com.tencent.mm.plugin.offline.a.u.e;
import com.tencent.mm.plugin.offline.a.u.f;
import com.tencent.mm.plugin.offline.a.u.h;
import com.tencent.mm.plugin.offline.c.c.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ah.a;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.protocal.protobuf.dvr;
import com.tencent.mm.protocal.protobuf.dvs;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.model.ab;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.model.c.1;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.kernel.k
public class WalletOfflineCoinPurseUI
  extends WalletBaseUI
  implements r.a, u.a, com.tencent.mm.plugin.offline.b, c.b, a, ScreenShotUtil.ScreenShotCallback
{
  private HashMap<String, Integer> Kkr;
  private boolean MAA;
  private ArrayList<String> MAB;
  private ArrayList<String> MAC;
  private ArrayList<Boolean> MAD;
  private String MAE;
  private Bankcard MAF;
  private ScrollView MAG;
  private View MAH;
  private ImageView MAI;
  private ImageView MAJ;
  private TextView MAK;
  private String MAL;
  private View MAM;
  private TextView MAN;
  private WeImageView MAO;
  private RelativeLayout MAQ;
  private LinearLayout MAR;
  private CdnImageView MAS;
  private TextView MAT;
  private TextView MAU;
  private e MAV;
  private h MAW;
  private b MAX;
  private f MAY;
  private d MAZ;
  private HashMap<String, View> MAv;
  private HashMap<String, Integer> MAw;
  Bitmap MAx;
  Bitmap MAy;
  private boolean MAz;
  private boolean MBA;
  private ArrayList<Bitmap> MBB;
  private ArrayList<Bitmap> MBC;
  private com.tencent.mm.wallet_core.ui.c MBD;
  private c MBE;
  public OfflineAlertView MBF;
  private boolean MBG;
  private boolean MBH;
  private String MBI;
  private boolean MBJ;
  private String MBK;
  private boolean MBL;
  private int MBM;
  private boolean MBN;
  private boolean MBO;
  private boolean MBP;
  private com.tencent.mm.plugin.wallet_core.model.r MBQ;
  private boolean MBR;
  private boolean MBS;
  private String MBT;
  private my MBU;
  IListener<ade> MBV;
  IListener<my> MBW;
  IListener<ade> MBX;
  private IListener<do> MBY;
  private IListener<rf> MBZ;
  private LinearLayout MBa;
  private CdnImageView MBb;
  private TextView MBc;
  private g MBd;
  private boolean MBe;
  private LinearLayout MBf;
  private LinearLayout MBg;
  private LinearLayout MBh;
  private LinearLayout MBi;
  private LinearLayout MBj;
  private LinearLayout MBk;
  private TextView MBl;
  private Toast MBm;
  private String MBn;
  private boolean MBo;
  private com.tencent.mm.plugin.offline.g MBp;
  private boolean MBq;
  private boolean MBr;
  private boolean MBs;
  private boolean MBt;
  private boolean MBu;
  private int MBv;
  private com.tencent.mm.plugin.wallet.ui.a MBw;
  private int MBx;
  private boolean MBy;
  private boolean MBz;
  private IListener<qn> MCa;
  private IListener<qo> MCb;
  private IListener MCc;
  private IListener MCd;
  private IListener MCe;
  public boolean MCf;
  private MTimerHandler MCg;
  private MTimerHandler MCh;
  private String MxZ;
  private String Mxy;
  private o Myb;
  private int Myd;
  private MTimerHandler Mye;
  private IListener<ng> Myr;
  private int eventId;
  private int lCR;
  private int mEntryScene;
  private boolean mIsForeground;
  private long mLastTime;
  private int mState;
  private Dialog mTipDialog;
  private View.OnClickListener qjL;
  private boolean wAg;
  private int ybL;
  
  public WalletOfflineCoinPurseUI()
  {
    AppMethodBeat.i(66468);
    this.mLastTime = 0L;
    this.mState = 3;
    this.MAv = new HashMap();
    this.MAw = new HashMap();
    this.mEntryScene = -1;
    this.MAx = null;
    this.MAy = null;
    this.MAz = false;
    this.MAA = false;
    this.MAB = new ArrayList();
    this.MAC = new ArrayList();
    this.MAD = new ArrayList();
    this.Mxy = "";
    this.MAE = "";
    this.MBe = false;
    this.MBn = "";
    this.MxZ = "";
    this.wAg = true;
    this.MBo = false;
    this.MBq = false;
    this.MBr = false;
    this.MBs = false;
    this.MBt = true;
    this.MBu = false;
    this.MBv = -1;
    this.MBx = 1;
    this.MBy = false;
    this.MBz = false;
    this.MBA = false;
    this.MBB = new ArrayList();
    this.MBC = new ArrayList();
    this.MBG = false;
    this.MBH = false;
    this.MBI = null;
    this.MBJ = false;
    this.eventId = 0;
    this.MBL = false;
    this.MBN = true;
    this.MBO = false;
    this.MBP = false;
    this.MBR = false;
    this.MBS = false;
    this.MBV = new IListener(com.tencent.mm.app.f.hfK) {};
    this.MBW = new IListener(com.tencent.mm.app.f.hfK) {};
    this.MBX = new IListener(com.tencent.mm.app.f.hfK) {};
    this.MBY = new IListener(com.tencent.mm.app.f.hfK) {};
    this.MBZ = new WalletOfflineCoinPurseUI.5(this, com.tencent.mm.app.f.hfK);
    this.MCa = new WalletOfflineCoinPurseUI.7(this, com.tencent.mm.app.f.hfK);
    this.MCb = new WalletOfflineCoinPurseUI.8(this, com.tencent.mm.app.f.hfK);
    this.MCc = new WalletOfflineCoinPurseUI.9(this, com.tencent.mm.app.f.hfK);
    this.MCd = new IListener(com.tencent.mm.app.f.hfK) {};
    this.MCe = new IListener(com.tencent.mm.app.f.hfK) {};
    this.qjL = new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(269145);
        long l;
        if ((paramAnonymousView.getId() == a.f.wallet_qrcode_iv) || (paramAnonymousView.getId() == a.f.wallet_barcode_iv) || (paramAnonymousView.getId() == a.f.wallet_barcode_tv))
        {
          if ((paramAnonymousView.getId() == a.f.wallet_qrcode_iv) && (WalletOfflineCoinPurseUI.this.MBF != null) && (WalletOfflineCoinPurseUI.this.MBF.isShowing()))
          {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
            AppMethodBeat.o(269145);
            return;
          }
          l = System.currentTimeMillis();
          if (((WalletOfflineCoinPurseUI.this.MBF == null) || (!WalletOfflineCoinPurseUI.this.MBF.isShowing())) && (l - WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this) >= 400L) && (com.tencent.mm.plugin.offline.c.d.gwA()) && (!WalletOfflineCoinPurseUI.v(WalletOfflineCoinPurseUI.this)))
          {
            if (paramAnonymousView.getId() != a.f.wallet_qrcode_iv) {
              break label209;
            }
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, false);
          }
        }
        for (;;)
        {
          if (WalletOfflineCoinPurseUI.w(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.x(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.w(WalletOfflineCoinPurseUI.this).ak(paramAnonymousView, WalletOfflineCoinPurseUI.y(WalletOfflineCoinPurseUI.this));
          }
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, l);
          AppMethodBeat.o(269145);
          return;
          label209:
          if ((paramAnonymousView.getId() == a.f.wallet_barcode_iv) || (paramAnonymousView.getId() == a.f.wallet_barcode_tv))
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(13958, new Object[] { Integer.valueOf(4) });
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, true);
          }
        }
      }
    };
    this.MCf = false;
    this.Kkr = new HashMap();
    this.Myd = 60000;
    this.Mye = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(269230);
        if (!WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this))
        {
          WalletOfflineCoinPurseUI.G(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.H(WalletOfflineCoinPurseUI.this);
        }
        WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this).startTimer(WalletOfflineCoinPurseUI.U(WalletOfflineCoinPurseUI.this));
        AppMethodBeat.o(269230);
        return false;
      }
    }, false);
    this.MCg = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(269223);
        WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this);
        if ((WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this).isShowing())) {
          WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this).dismiss();
        }
        com.tencent.mm.plugin.offline.g.gve();
        WalletOfflineCoinPurseUI.X(WalletOfflineCoinPurseUI.this);
        if (com.tencent.mm.plugin.offline.c.d.gxc()) {
          WalletOfflineCoinPurseUI.this.gvw();
        }
        AppMethodBeat.o(269223);
        return false;
      }
    }, false);
    this.MCh = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(269236);
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.Y(WalletOfflineCoinPurseUI.this)) });
        if (WalletOfflineCoinPurseUI.Y(WalletOfflineCoinPurseUI.this))
        {
          cz localcz = new cz();
          localcz.hCT.resultCode = 0;
          localcz.publish();
        }
        WalletOfflineCoinPurseUI.this.finish();
        AppMethodBeat.o(269236);
        return false;
      }
    }, false);
    this.Myr = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(66468);
  }
  
  private void Ai(boolean paramBoolean)
  {
    AppMethodBeat.i(269277);
    List localList = com.tencent.mm.plugin.offline.c.d.Am(true);
    if ((localList != null) && (localList.size() > 0))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
      gvR();
      gvQ();
      this.MAM.setVisibility(0);
    }
    for (;;)
    {
      if (paramBoolean) {
        bs(0, false);
      }
      Aj(true);
      dmE();
      gvG();
      AppMethodBeat.o(269277);
      return;
      this.MAM.setVisibility(0);
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
    }
  }
  
  private void Aj(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(66483);
    long l = System.currentTimeMillis();
    int i;
    if ((Util.isNullOrNil(this.MBn)) || (Util.isNullOrNil(this.MxZ)))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
      gvX();
      fWF();
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - l));
      gvJ();
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - l));
      recycleBmpList();
      gvK();
      gvD();
      gvE();
      ac.pu(10, 0);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      MMApplicationContext.getContext();
      if (!com.tencent.mm.plugin.offline.c.d.gwX()) {
        break label281;
      }
      i = 0;
      label149:
      if (NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
        j = 1;
      }
      com.tencent.mm.plugin.offline.k.gvj();
      com.tencent.mm.plugin.offline.k.gvl();
      localh.b(14163, new Object[] { Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(com.tencent.mm.plugin.offline.e.gvb()) });
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 67L, 1L, true);
      if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
        break label286;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 32L, 1L, true);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.offline.c.d.gwX()) {
        break label303;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 34L, 1L, true);
      AppMethodBeat.o(66483);
      return;
      gwa();
      break;
      label281:
      i = 1;
      break label149;
      label286:
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 33L, 1L, true);
    }
    label303:
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 35L, 1L, true);
    AppMethodBeat.o(66483);
  }
  
  private void Ak(boolean paramBoolean)
  {
    AppMethodBeat.i(66508);
    if (!com.tencent.mm.plugin.offline.c.d.gwA())
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.c.d.gwA()) });
      AppMethodBeat.o(66508);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.offline.c.d.getTokenType() == 2)
    {
      i = com.tencent.mm.kernel.h.aZW().bFQ();
      if ((i != 6) && (i != 4)) {
        gwc();
      }
      for (i = 0; i == 0; i = 1)
      {
        Log.w("MicroMsg.WalletOfflineCoinPurseUI", "network disabled");
        AppMethodBeat.o(66508);
        return;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.offline.c.d.Am(false);
    if ((localObject1 == null) || (((List)localObject1).size() <= 0))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      this.MAN.setVisibility(8);
      AppMethodBeat.o(66508);
      return;
    }
    final ArrayList localArrayList = com.tencent.mm.plugin.wallet_core.model.ae.HH(true);
    int j;
    label194:
    Object localObject2;
    if ((paramBoolean) && (this.MBw == null))
    {
      this.MBw = new com.tencent.mm.plugin.wallet.ui.a(this);
      this.MBv = -1;
      this.MBw.xcO.cyW();
      i = 0;
      localObject1 = null;
      j = 0;
      if (i >= localArrayList.size()) {
        break label277;
      }
      localObject2 = (Bankcard)localArrayList.get(i);
      if ((Util.isNullOrNil(((Bankcard)localObject2).field_bindSerial)) || (!this.Mxy.equals(((Bankcard)localObject2).field_bindSerial))) {
        break label557;
      }
      j = i;
      localObject1 = localObject2;
    }
    label277:
    label557:
    for (;;)
    {
      i += 1;
      break label194;
      this.MBw = null;
      this.MBw = new com.tencent.mm.plugin.wallet.ui.a(this);
      break;
      if (localObject1 != null)
      {
        localArrayList.remove(localObject1);
        localArrayList.add(0, localObject1);
        j = 0;
      }
      this.MBw.Vtg = new com.tencent.mm.ui.base.u.g()
      {
        public final void onCreateMMMenu(final com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(269275);
          paramAnonymouss.clear();
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mmBottomSheet list show");
          int i = 0;
          final Bankcard localBankcard;
          Object localObject1;
          Object localObject3;
          Bitmap localBitmap;
          Object localObject2;
          label180:
          Object localObject4;
          if (i < localArrayList.size())
          {
            localBankcard = (Bankcard)localArrayList.get(i);
            localObject1 = com.tencent.mm.plugin.offline.c.d.aQR(localBankcard.field_bankcardType);
            localObject3 = localObject1;
            if (localBankcard.ihW())
            {
              localObject3 = localObject1;
              if (localBankcard.VDy != null) {
                localObject3 = localBankcard.VDy.MpW;
              }
            }
            localBitmap = com.tencent.mm.platformtools.r.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject3));
            com.tencent.mm.platformtools.r.a(new r.a()
            {
              public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(269241);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(269162);
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletOfflineCoinPurseUI.38.1.this.MCv });
                    if (WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this).containsKey(paramAnonymous2String))
                    {
                      int i = ((Integer)WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this).get(paramAnonymous2String)).intValue();
                      if (WalletOfflineCoinPurseUI.38.1.this.Kkz.getItem(i) != null)
                      {
                        WalletOfflineCoinPurseUI.38.1.this.Kkz.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(paramAnonymous2Bitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false)));
                        if ((WalletOfflineCoinPurseUI.this.isFinishing()) || (WalletOfflineCoinPurseUI.this.isDestroyed()))
                        {
                          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineCoinPurseUI.this.isFinishing() || WalletOfflineCoinPurseUI.this.isDestroyed()：%s，%s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.this.isFinishing()), Boolean.valueOf(WalletOfflineCoinPurseUI.this.isDestroyed()) });
                          AppMethodBeat.o(269162);
                          return;
                        }
                        WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this).ihf();
                      }
                    }
                    AppMethodBeat.o(269162);
                  }
                });
                AppMethodBeat.o(269241);
              }
            });
            localObject2 = "";
            if (!Util.isNullOrNil(localBankcard.field_forbidWord)) {
              localObject2 = localBankcard.field_forbidWord;
            }
            localObject1 = localObject2;
            if (Util.isNullOrNil((String)localObject2))
            {
              localObject1 = localObject2;
              if (!localBankcard.field_support_micropay)
              {
                if (!Util.isNullOrNil(localBankcard.field_no_micro_word)) {
                  break label552;
                }
                localObject1 = "";
              }
            }
            if (Util.isNullOrNil(localBankcard.field_forbid_title))
            {
              localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
              localObject4 = localObject1;
              localObject1 = localObject2;
              label210:
              if ((!Util.isNullOrNil((CharSequence)localObject1)) || (Util.isNullOrNil(localBankcard.field_prompt_info_prompt_text))) {
                break label831;
              }
              localObject1 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
              if ((!Util.isNullOrNil(localBankcard.field_prompt_info_jump_text)) && (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_url)))
              {
                ((SpannableStringBuilder)localObject1).append(localBankcard.field_prompt_info_jump_text);
                ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.plugin.wallet_core.ui.s(new s.a()
                {
                  public final void eS(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(269253);
                    com.tencent.mm.wallet_core.ui.i.bC(WalletOfflineCoinPurseUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
                    com.tencent.mm.plugin.report.service.h.OAn.b(20216, new Object[] { Integer.valueOf(3), localBankcard.field_prompt_info_jump_url });
                    AppMethodBeat.o(269253);
                  }
                }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject1).length(), 33);
              }
            }
          }
          label387:
          label413:
          label552:
          label831:
          for (;;)
          {
            String str;
            if (((localBankcard.ihV()) || (localBankcard.ihW())) && (localBankcard.VDo >= 0.0D))
            {
              str = localBankcard.field_desc + WalletOfflineCoinPurseUI.this.getString(a.i.wallet_balance_left, new Object[] { com.tencent.mm.wallet_core.ui.i.X(localBankcard.VDo) });
              localObject2 = null;
              if (!localBankcard.ihZ()) {
                break label710;
              }
              localObject2 = com.tencent.mm.svg.a.a.i(WalletOfflineCoinPurseUI.this.getResources(), a.h.honey_pay_bank_logo);
              if (localObject2 == null) {
                WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this).put(localObject3, Integer.valueOf(i));
              }
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "can choose list：i %d fee %s %s，status:%s", new Object[] { Integer.valueOf(i), str, localObject1, Integer.valueOf(localBankcard.field_defaultCardState) });
              if (!localBankcard.iia()) {
                break label776;
              }
              localObject3 = com.tencent.mm.pluginsdk.ui.span.p.b(WalletOfflineCoinPurseUI.this.getContext(), str);
              if (Util.isNullOrNil((String)localObject4))
              {
                if (!Util.isNullOrNil(localBankcard.VDM)) {
                  break label760;
                }
                localObject1 = "";
              }
              if (Util.isNullOrNil((String)localObject4)) {
                break label770;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              paramAnonymouss.a(i, (CharSequence)localObject3, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
              i += 1;
              break;
              localObject1 = localBankcard.field_no_micro_word;
              break label180;
              localObject4 = (String)localObject1 + " ";
              localObject1 = new SpannableStringBuilder((String)localObject4 + localBankcard.field_forbid_title);
              localObject2 = new n(WalletOfflineCoinPurseUI.this)
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(269254);
                  paramAnonymous2View = localBankcard.field_forbid_url;
                  if ((localBankcard.iia()) && (Util.isNullOrNil(paramAnonymous2View)))
                  {
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand");
                    paramAnonymous2View = new zp();
                    paramAnonymous2View.icM.userName = localBankcard.VcU;
                    paramAnonymous2View.icM.icO = localBankcard.VcV;
                    paramAnonymous2View.icM.scene = 1137;
                    paramAnonymous2View.icM.icP = 0;
                    paramAnonymous2View.publish();
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand result:%s", new Object[] { Boolean.valueOf(paramAnonymous2View.icN.idi) });
                    if (paramAnonymous2View.icN.idi)
                    {
                      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 1);
                      WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this).xcO.cyW();
                      AppMethodBeat.o(269254);
                      return;
                    }
                    WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 0);
                    AppMethodBeat.o(269254);
                    return;
                  }
                  Intent localIntent = new Intent();
                  Log.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", new Object[] { paramAnonymous2View });
                  localIntent.putExtra("rawUrl", paramAnonymous2View);
                  localIntent.putExtra("geta8key_username", z.bAM());
                  localIntent.putExtra("pay_channel", 1);
                  com.tencent.mm.wallet_core.ui.i.aS(WalletOfflineCoinPurseUI.this.getContext(), localIntent);
                  AppMethodBeat.o(269254);
                }
              };
              int j = ((String)localObject4).length();
              int k = ((String)localObject4).length() + localBankcard.field_forbid_title.length();
              ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(WalletOfflineCoinPurseUI.this.getResources().getColor(a.c.wallet_offline_link_color)), j, k, 33);
              ((SpannableStringBuilder)localObject1).setSpan(localObject2, j, k, 33);
              break label210;
              str = localBankcard.field_desc;
              break label387;
              label710:
              if (localBitmap == null) {
                break label413;
              }
              localObject2 = new BitmapDrawable(BitmapUtil.extractThumbNail(localBitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false));
              break label413;
              label760:
              localObject1 = localBankcard.VDM;
              break label519;
            }
            localObject3 = com.tencent.mm.pluginsdk.ui.span.p.b(WalletOfflineCoinPurseUI.this.getContext(), str);
            if (!Util.isNullOrNil((String)localObject4)) {}
            for (bool = true;; bool = false)
            {
              paramAnonymouss.a(i, (CharSequence)localObject3, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
              break;
            }
            AppMethodBeat.o(269275);
            return;
          }
        }
      };
      this.MBw.a(new j.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(269274);
          if (WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.R(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.S(WalletOfflineCoinPurseUI.this);
            Bankcard localBankcard = (Bankcard)localArrayList.get(WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this).pym);
            if (localBankcard.field_bindSerial.equals(WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this)))
            {
              WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this).xcO.cyW();
              AppMethodBeat.o(269274);
              return;
            }
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, localBankcard, true, new WalletOfflineCoinPurseUI.39..ExternalSyntheticLambda0(this, localBankcard));
          }
          AppMethodBeat.o(269274);
        }
      });
      localObject1 = View.inflate(this, a.g.wallet_offline_coin_bankcard_header, null);
      localObject2 = (LinearLayout)((View)localObject1).findViewById(a.f.offline_select_bankcard_title_layout);
      ((LinearLayout)localObject2).setFocusable(true);
      ((LinearLayout)localObject2).setContentDescription(MMApplicationContext.getContext().getString(a.i.offline_bankcard_title) + MMApplicationContext.getContext().getString(a.i.offline_bankcard_desc));
      com.tencent.mm.wallet_core.ui.i.Q((TextView)((View)localObject1).findViewById(a.f.offline_select_bankcard_title));
      ((View)localObject1).findViewById(a.f.offline_header_close_icon_iv).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269224);
          if (WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this) != null) {
            WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this).xcO.cyW();
          }
          AppMethodBeat.o(269224);
        }
      });
      ((View)localObject1).findViewById(a.f.offline_header_close_icon_iv).setContentDescription(getString(a.i.wallet_accessibility_close_btn));
      this.MBw.Vtn = true;
      this.MBw.au(getResources().getString(a.i.wallet_dialog_confirm));
      this.MBw.pym = j;
      this.MBw.Vto = true;
      this.MBw.setTitleView((View)localObject1);
      this.MBw.dDn();
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(269226);
          if (this.MCz != null) {
            this.MCz.sendAccessibilityEvent(8);
          }
          AppMethodBeat.o(269226);
        }
      }, 500L);
      com.tencent.mm.plugin.report.service.h.OAn.b(13955, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(66508);
      return;
    }
  }
  
  private void Al(boolean paramBoolean)
  {
    AppMethodBeat.i(269373);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "resetDefaultBankcard");
    Object localObject = com.tencent.mm.plugin.offline.c.c.MDa;
    com.tencent.mm.plugin.offline.c.c.gww();
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.offline.c.c.MDa;
      localObject = com.tencent.mm.plugin.offline.c.c.gwy();
      if (localObject != null)
      {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "newCard : %s，oldCard：：%s", new Object[] { ((Bankcard)localObject).field_bindSerial, this.Mxy });
        if (com.tencent.mm.plugin.offline.c.d.getTokenType() != 2) {
          a((Bankcard)localObject, false, null);
        }
        if (gwg())
        {
          afg(8);
          this.MBz = true;
          AppMethodBeat.o(269373);
          return;
        }
        this.MBz = false;
      }
    }
    AppMethodBeat.o(269373);
  }
  
  private void a(Bankcard paramBankcard)
  {
    AppMethodBeat.i(269363);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(269363);
      return;
    }
    this.Mxy = paramBankcard.field_bindSerial;
    this.MAF = paramBankcard;
    com.tencent.mm.plugin.offline.c.c localc = com.tencent.mm.plugin.offline.c.c.MDa;
    com.tencent.mm.plugin.offline.c.c.aQJ(this.Mxy);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "set current bindSerial: %s, %s", new Object[] { this.Mxy, paramBankcard.field_bankcardType });
    AppMethodBeat.o(269363);
  }
  
  private void a(Bankcard paramBankcard, boolean paramBoolean)
  {
    AppMethodBeat.i(269359);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(269359);
      return;
    }
    String str = paramBankcard.field_bindSerial;
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doSelectBackcard tempSerial:%s，mBindSerial：%s", new Object[] { str, this.Mxy });
    if ((!TextUtils.isEmpty(str)) && (!str.equals(this.Mxy)))
    {
      a(paramBankcard);
      gvQ();
      bs(0, paramBoolean);
      Aj(true);
    }
    AppMethodBeat.o(269359);
  }
  
  private void a(Bankcard paramBankcard, boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(269351);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doSelectPaymentCompat: %s", new Object[] { paramBankcard.field_bindSerial });
    if (paramBankcard == null)
    {
      AppMethodBeat.o(269351);
      return;
    }
    if (paramBankcard.field_bindSerial.equals(this.Mxy))
    {
      AppMethodBeat.o(269351);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.d.getTokenType() == 2)
    {
      b.a locala = com.tencent.mm.plugin.offline.a.b.MyA;
      if (com.tencent.mm.plugin.offline.a.b.gvo())
      {
        Log.w("MicroMsg.WalletOfflineCoinPurseUI", "is doing setpayment, skip");
        gwc();
        AppMethodBeat.o(269351);
        return;
      }
      showLoading(false);
      new com.tencent.mm.plugin.offline.a.b(paramBankcard.field_bindSerial, paramBankcard.field_bankcardType, paramBankcard.field_defaultCardState).bFJ().b(new WalletOfflineCoinPurseUI..ExternalSyntheticLambda3(this, paramBankcard, paramBoolean, paramRunnable)).a(this);
      AppMethodBeat.o(269351);
      return;
    }
    this.MBT = null;
    gvD();
    a(paramBankcard, paramBoolean);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(269351);
  }
  
  private void aff(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(269298);
    com.tencent.mm.plugin.offline.k.gvj();
    Object localObject = com.tencent.mm.plugin.offline.k.gvl().G(this.mEntryScene, paramInt, this.MAL);
    this.MxZ = ((String)localObject);
    this.MBn = ((String)localObject);
    Log.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[] { Integer.valueOf(paramInt), this.MxZ, this.MBn, Util.getStack().toString() });
    dsz();
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.mm.plugin.report.service.h.OAn;
      MMApplicationContext.getContext();
      if (com.tencent.mm.plugin.offline.c.d.gwX()) {}
      for (paramInt = 0;; paramInt = 1)
      {
        if (NetStatusUtil.isNetworkConnected(getBaseContext())) {
          i = 1;
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).b(14163, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 26L, 1L, true);
        if (!NetStatusUtil.isNetworkConnected(getBaseContext())) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 28L, 1L, true);
        AppMethodBeat.o(269298);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 27L, 1L, true);
    }
    AppMethodBeat.o(269298);
  }
  
  private static void afg(int paramInt)
  {
    AppMethodBeat.i(66509);
    av localav = new av();
    localav.ipH = paramInt;
    localav.bMH();
    AppMethodBeat.o(66509);
  }
  
  private static int argbColor(long paramLong)
  {
    AppMethodBeat.i(269370);
    int i = Color.argb((int)(paramLong >> 24 & 0xFF), (int)(paramLong >> 16 & 0xFF), (int)(paramLong >> 8 & 0xFF), (int)(0xFF & paramLong));
    AppMethodBeat.o(269370);
    return i;
  }
  
  private void b(Bankcard paramBankcard)
  {
    AppMethodBeat.i(66511);
    if (TextUtils.isEmpty(this.Mxy))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
      AppMethodBeat.o(66511);
      return;
    }
    if (paramBankcard.ihZ())
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
      this.MAO.setImageDrawable(com.tencent.mm.svg.a.a.i(getContext().getResources(), a.h.honey_pay_bank_logo));
      AppMethodBeat.o(66511);
      return;
    }
    String str2 = com.tencent.mm.plugin.offline.c.d.aQS(this.Mxy);
    String str1 = str2;
    if (paramBankcard.ihW())
    {
      str1 = str2;
      if (paramBankcard.VDy != null) {
        str1 = paramBankcard.VDy.MpW;
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
      this.MAO.setImageBitmap(null);
      AppMethodBeat.o(66511);
      return;
    }
    g(this.MAO, str1, getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width));
    AppMethodBeat.o(66511);
  }
  
  private void bs(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(269296);
    if (!com.tencent.mm.plugin.offline.c.d.gwA())
    {
      Log.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
      AppMethodBeat.o(269296);
      return;
    }
    if (!((d)component(d.class)).gwp())
    {
      Log.w("MicroMsg.WalletOfflineCoinPurseUI", "token is disabled");
      AppMethodBeat.o(269296);
      return;
    }
    b.a locala = com.tencent.mm.plugin.offline.a.b.MyA;
    if (com.tencent.mm.plugin.offline.a.b.gvo())
    {
      Log.w("MicroMsg.WalletOfflineCoinPurseUI", "is doing setofflinepayment, skip update code");
      AppMethodBeat.o(269296);
      return;
    }
    if ((this.MAF != null) && (com.tencent.mm.plugin.offline.c.d.getTokenType() == 2) && (!paramBoolean) && (!com.tencent.mm.plugin.wallet_core.model.ae.h(this.MAF)))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "update undefault card, need do setpayment");
      new com.tencent.mm.plugin.offline.a.b(this.MAF.field_bindSerial, this.MAF.field_bankcardType, this.MAF.field_defaultCardState).bFJ().b(new WalletOfflineCoinPurseUI..ExternalSyntheticLambda2(this, paramInt)).a(this);
      AppMethodBeat.o(269296);
      return;
    }
    aff(paramInt);
    AppMethodBeat.o(269296);
  }
  
  private void dmE()
  {
    AppMethodBeat.i(66479);
    if ((com.tencent.mm.plugin.offline.c.d.gwA()) || (!((d)component(d.class)).gwp()))
    {
      this.MAQ.setVisibility(0);
      AppMethodBeat.o(66479);
      return;
    }
    this.MAQ.setVisibility(4);
    AppMethodBeat.o(66479);
  }
  
  private void dsz()
  {
    AppMethodBeat.i(66516);
    bi localbi = com.tencent.mm.plugin.wallet_core.model.k.iis();
    Object localObject = new StringBuilder().append(this.MBn);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC();
    localObject = MD5Util.getMD5String(com.tencent.mm.b.p.getString(com.tencent.mm.kernel.b.getUin()));
    if (localbi != null) {
      com.tencent.mm.plugin.report.service.h.OAn.b(13444, new Object[] { localbi.YCJ, localbi.YCK, Long.valueOf(localbi.YCI), localObject, localbi.YCL, localbi.YCM, localbi.YCN });
    }
    AppMethodBeat.o(66516);
  }
  
  private void fWF()
  {
    AppMethodBeat.i(66484);
    Bitmap localBitmap = this.MAx;
    this.MAx = gvM();
    this.MAI.setImageBitmap(this.MAx);
    this.MBB.add(0, localBitmap);
    AppMethodBeat.o(66484);
  }
  
  private void g(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(66495);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66495);
      return;
    }
    Bitmap localBitmap = com.tencent.mm.platformtools.r.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramString));
    if (localBitmap != null)
    {
      if ((paramImageView instanceof WeImageView)) {
        ((WeImageView)paramImageView).setEnableColorFilter(false);
      }
      paramImageView.setImageBitmap(BitmapUtil.extractThumbNail(localBitmap, paramInt, paramInt, true, false));
    }
    this.MAv.put(paramString, paramImageView);
    this.MAw.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(66495);
  }
  
  private void gvA()
  {
    AppMethodBeat.i(66470);
    gvV();
    gwb();
    gvW();
    gvZ();
    gvS();
    AppMethodBeat.o(66470);
  }
  
  private void gvB()
  {
    AppMethodBeat.i(66472);
    com.tencent.mm.wallet_core.ui.i.aGA(32);
    com.tencent.mm.pluginsdk.wallet.f.bo(this, this.ybL);
    AppMethodBeat.o(66472);
  }
  
  private boolean gvC()
  {
    AppMethodBeat.i(269249);
    if (!Util.isNullOrNil(this.MBT))
    {
      this.MBk.setVisibility(0);
      this.MBl.setText(this.MBT);
      AppMethodBeat.o(269249);
      return true;
    }
    this.MBk.setVisibility(8);
    AppMethodBeat.o(269249);
    return false;
  }
  
  private void gvD()
  {
    AppMethodBeat.i(269256);
    if (!gvC()) {
      gvF();
    }
    AppMethodBeat.o(269256);
  }
  
  private void gvE()
  {
    AppMethodBeat.i(269264);
    com.tencent.mm.kernel.h.baF();
    Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adhQ, "");
    if (Util.isNullOrNil((String)localObject))
    {
      this.MBa.setVisibility(8);
      AppMethodBeat.o(269264);
      return;
    }
    this.MBd = new g((byte)0);
    try
    {
      localObject = new JSONObject((String)localObject);
      g localg = this.MBd;
      localg.iconUrl = ((JSONObject)localObject).optString("icon_url");
      localg.MCJ = ((JSONObject)localObject).optString("title");
      localg.MCK = ((JSONObject)localObject).optString("tiny_app_username");
      localg.MCL = ((JSONObject)localObject).optString("tiny_app_path");
      localg.h5Url = ((JSONObject)localObject).optString("h5_url");
      localg.jumpType = ((JSONObject)localObject).optInt("jump_type");
      if (Util.isNullOrNil(this.MBd.MCJ))
      {
        Log.e("MicroMsg.WalletOfflineCoinPurseUI", "title is null, can not show info page");
        this.MBa.setVisibility(8);
        AppMethodBeat.o(269264);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "parse jumpinfo json fail : %s", new Object[] { localJSONException.getMessage() });
      this.MBa.setVisibility(8);
      AppMethodBeat.o(269264);
      return;
    }
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "show jump info layout");
    if (!this.MBe)
    {
      this.MBe = true;
      com.tencent.mm.plugin.report.service.h.OAn.b(14515, new Object[] { Integer.valueOf(5) });
    }
    this.MBa.setVisibility(0);
    if (!Util.isNullOrNil(this.MBd.iconUrl))
    {
      this.MBb.setUrl(this.MBd.iconUrl);
      this.MBb.setVisibility(0);
    }
    for (;;)
    {
      this.MBc.setText(this.MBd.MCJ);
      this.MBa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66410);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click jump info layout");
          com.tencent.mm.plugin.report.service.h.OAn.b(14515, new Object[] { Integer.valueOf(6) });
          paramAnonymousView = WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this);
          int i;
          if ((paramAnonymousView.jumpType == 1) && (!Util.isNullOrNil(paramAnonymousView.MCK)))
          {
            i = 1;
            if (i == 0) {
              break label211;
            }
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "jump to tinyapp, username : %s", new Object[] { WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this).MCK });
            paramAnonymousView = new zp();
            paramAnonymousView.icM.userName = WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this).MCK;
            paramAnonymousView.icM.icO = Util.nullAs(WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this).MCL, "");
            paramAnonymousView.icM.scene = 1137;
            paramAnonymousView.icM.icP = 0;
            paramAnonymousView.publish();
          }
          label294:
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66410);
            return;
            i = 0;
            break;
            label211:
            paramAnonymousView = WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this);
            if ((paramAnonymousView.jumpType == 2) && (!Util.isNullOrNil(paramAnonymousView.h5Url))) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label294;
              }
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "jump to h5 : %s", new Object[] { WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this).h5Url });
              com.tencent.mm.wallet_core.ui.i.o(WalletOfflineCoinPurseUI.this.getContext(), WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this).h5Url, false);
              break;
            }
          }
        }
      });
      AppMethodBeat.o(269264);
      return;
      this.MBb.setVisibility(8);
    }
  }
  
  private void gvF()
  {
    AppMethodBeat.i(66478);
    final dvr localdvr = com.tencent.mm.plugin.wallet_core.model.u.iiC().VKj;
    if (localdvr == null)
    {
      this.MAR.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    Object localObject;
    if (localdvr.VmW == ah.a.VJK.value)
    {
      if (localdvr.abbk == null)
      {
        Log.e("MicroMsg.WalletOfflineCoinPurseUI", "offlineGuideBar.guide_data == null");
        this.MAR.setVisibility(8);
        AppMethodBeat.o(66478);
        return;
      }
      localObject = localdvr.abbk.MDt;
      if (com.tencent.mm.plugin.wallet_core.model.u.iiC().p((String)localObject, false, false) == null)
      {
        Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar bindSerial(%s) is null bankcard!", new Object[] { Util.nullAs((String)localObject, "") });
        this.MAR.setVisibility(8);
        AppMethodBeat.o(66478);
        return;
      }
      localObject = this.MAF;
      if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (Util.isEqual(localdvr.abbk.MDt, ((Bankcard)localObject).field_bindSerial)))
      {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar defaultBankcard(%s) == bindSerial(%s)", new Object[] { ((Bankcard)localObject).field_bindSerial, localdvr.abbk.MDt });
        this.MAR.setVisibility(8);
        AppMethodBeat.o(66478);
        return;
      }
    }
    if ((this.MAR.isShown()) && (this.MAR.getTag() != null) && ((this.MAR.getTag() instanceof dvr)) && (Util.isEqual((dvr)this.MAR.getTag(), localdvr)))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "");
      AppMethodBeat.o(66478);
      return;
    }
    if (localdvr.Vlg == 0)
    {
      this.MAR.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if (!this.MBt)
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "isShowGuideBar == false");
      AppMethodBeat.o(66478);
      return;
    }
    int i = this.MAR.getVisibility();
    this.MAR.setTag(localdvr);
    this.MAR.setVisibility(0);
    final int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 20.0F);
    this.MAS.w(localdvr.Vln, j, j, -1);
    this.MAT.setText(localdvr.Vli);
    this.MAU.setText(localdvr.Vlk);
    aw.a(this.MAU.getPaint(), 0.8F);
    if (localdvr.VmW == ah.a.VJK.value)
    {
      if ((!Util.isNullOrNil(localdvr.background_color)) && (this.MAR.getBackground() != null)) {
        this.MAR.getBackground().setColorFilter(Color.parseColor(localdvr.background_color), PorterDuff.Mode.SRC);
      }
      this.MAT.setTextColor(Color.parseColor(localdvr.Vlj));
      this.MAU.setTextColor(Color.parseColor(localdvr.Vll));
      this.MAU.setTag(localdvr.abbk.MDt);
      this.MAU.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269146);
          WalletOfflineCoinPurseUI.afh(2);
          String str2 = "";
          String str1 = str2;
          if (paramAnonymousView.getTag() != null)
          {
            str1 = str2;
            if ((paramAnonymousView.getTag() instanceof String)) {
              str1 = (String)paramAnonymousView.getTag();
            }
          }
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mOfflineGuideButtonTv click! bindSerial:%s", new Object[] { str1 });
          if (Util.isNullOrNil(str1))
          {
            AppMethodBeat.o(269146);
            return;
          }
          WalletOfflineCoinPurseUI.z(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.A(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.u.iiC().bgD(str1);
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, paramAnonymousView, false, null);
          AppMethodBeat.o(269146);
        }
      });
      afg(1);
      this.MBA = true;
    }
    for (;;)
    {
      if ((i == 8) && (this.MBF.isShowing()))
      {
        gvS();
        gvT();
      }
      AppMethodBeat.o(66478);
      return;
      if (localdvr.VmW == ah.a.VJL.value)
      {
        if ((!Util.isNullOrNil(localdvr.background_color)) && (this.MAR.getBackground() != null)) {
          this.MAR.getBackground().setColorFilter(argbColor(Long.parseLong(localdvr.background_color.substring(2), 16)), PorterDuff.Mode.SRC);
        }
        this.MAT.setTextColor(argbColor(Long.parseLong(localdvr.Vlj.substring(2), 16)));
        this.MAU.setTextColor(argbColor(Long.parseLong(localdvr.Vll.substring(2), 16)));
        if (!Util.isNullOrNil(localdvr.Vlm))
        {
          localObject = (LinearLayout.LayoutParams)this.MAU.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
          this.MAU.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.MAU.setPadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 12), com.tencent.mm.cd.a.fromDPToPix(getContext(), 4), com.tencent.mm.cd.a.fromDPToPix(getContext(), 12), com.tencent.mm.cd.a.fromDPToPix(getContext(), 4));
          j = argbColor(Long.parseLong(localdvr.Vlm.substring(2), 16));
          this.MAU.setBackgroundDrawable(getContext().getResources().getDrawable(a.e.wallet_wx_offline_guide_button_tv_normal_bg));
          ((GradientDrawable)this.MAU.getBackground()).setColor(j);
          this.MAU.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(269151);
              if (paramAnonymousMotionEvent.getAction() == 0) {
                WalletOfflineCoinPurseUI.B(WalletOfflineCoinPurseUI.this).setBackgroundDrawable(WalletOfflineCoinPurseUI.this.getContext().getResources().getDrawable(a.e.wallet_wx_offline_guide_button_tv_click_bg));
              }
              for (;;)
              {
                AppMethodBeat.o(269151);
                return false;
                if (paramAnonymousMotionEvent.getAction() == 1)
                {
                  WalletOfflineCoinPurseUI.B(WalletOfflineCoinPurseUI.this).setBackgroundDrawable(WalletOfflineCoinPurseUI.this.getContext().getResources().getDrawable(a.e.wallet_wx_offline_guide_button_tv_normal_bg));
                  ((GradientDrawable)WalletOfflineCoinPurseUI.B(WalletOfflineCoinPurseUI.this).getBackground()).setColor(j);
                }
              }
            }
          });
        }
        this.MAU.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(269157);
            WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.afh(5);
            switch (localdvr.abbn)
            {
            default: 
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown entrance type");
              AppMethodBeat.o(269157);
              return;
            case 1: 
              AppMethodBeat.o(269157);
              return;
            case 2: 
              com.tencent.mm.wallet_core.ui.i.p(WalletOfflineCoinPurseUI.this.getContext(), localdvr.abbo, false);
              AppMethodBeat.o(269157);
              return;
            }
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.api.i()
            {
              public final void UP(String paramAnonymous2String)
              {
                AppMethodBeat.i(269265);
                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onTriggerHalfScreenShare");
                AppMethodBeat.o(269265);
              }
              
              public final void ceq()
              {
                AppMethodBeat.i(269273);
                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onAppBrandPreconditionError");
                ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(this);
                AppMethodBeat.o(269273);
              }
              
              public final void cer()
              {
                AppMethodBeat.i(269232);
                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onAppBrandUIEnter");
                AppMethodBeat.o(269232);
              }
              
              public final void ces()
              {
                AppMethodBeat.i(269259);
                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onAppBrandProcessDied");
                WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this);
                ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(this);
                AppMethodBeat.o(269259);
              }
              
              public final void ie(boolean paramAnonymous2Boolean)
              {
                AppMethodBeat.i(269246);
                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onAppBrandUIExit：%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
                WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this);
                ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(this);
                AppMethodBeat.o(269246);
              }
            };
            com.tencent.mm.wallet_core.ui.i.a(localdvr.abbp, localdvr.abbq, 0, 1137, paramAnonymousView);
            AppMethodBeat.o(269157);
          }
        });
        afg(4);
        this.MBA = false;
      }
    }
  }
  
  private void gvG()
  {
    AppMethodBeat.i(66481);
    if ((!this.MCf) && (!NetStatusUtil.isNetworkConnected(getBaseContext())))
    {
      com.tencent.mm.plugin.offline.k.gvj();
      com.tencent.mm.plugin.offline.k.gvl();
      if (com.tencent.mm.plugin.offline.e.gvb() == 0)
      {
        this.MCf = true;
        b.bf(this);
        Log.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
      }
    }
    AppMethodBeat.o(66481);
  }
  
  private void gvH()
  {
    AppMethodBeat.i(66482);
    int i = com.tencent.mm.plugin.offline.c.d.gwF();
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.d.gwD();
    if (c.gvy())
    {
      this.mState = 7;
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
      AppMethodBeat.o(66482);
      return;
    }
    if (!NetStatusUtil.isNetworkConnected(getBaseContext()))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
      this.mState = 6;
      AppMethodBeat.o(66482);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.d.gwA())
    {
      if (i == 0)
      {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
        this.mState = 1;
        AppMethodBeat.o(66482);
        return;
      }
      if ((i != 0) && (localBankcard == null))
      {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
        this.mState = 2;
        AppMethodBeat.o(66482);
        return;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
      this.mState = 5;
      AppMethodBeat.o(66482);
      return;
    }
    if (i == 0)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
      this.mState = 1;
      AppMethodBeat.o(66482);
      return;
    }
    if ((i != 0) && (localBankcard == null))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
      this.mState = 2;
      AppMethodBeat.o(66482);
      return;
    }
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
    this.mState = 5;
    AppMethodBeat.o(66482);
  }
  
  private boolean gvI()
  {
    return (this.mState == 2) || (this.mState == 1) || (this.mState == 7);
  }
  
  private void gvJ()
  {
    AppMethodBeat.i(66485);
    Bitmap localBitmap = this.MAy;
    this.MAy = gvL();
    this.MAJ.setImageBitmap(this.MAy);
    if (gvI()) {
      this.MAJ.setAlpha(10);
    }
    for (;;)
    {
      this.MBC.add(0, localBitmap);
      AppMethodBeat.o(66485);
      return;
      this.MAJ.setAlpha(255);
    }
  }
  
  private void gvK()
  {
    AppMethodBeat.i(66486);
    if (this.MBD != null)
    {
      this.MBD.qv(this.MBn, this.MxZ);
      this.MBD.MAx = this.MAx;
      this.MBD.MAy = this.MAy;
      this.MBD.jPm();
    }
    AppMethodBeat.o(66486);
  }
  
  private Bitmap gvL()
  {
    AppMethodBeat.i(66488);
    if (TextUtils.isEmpty(this.MxZ))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
      AppMethodBeat.o(66488);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.bz.a.a.a(this, this.MxZ, 5, 0, 0.0D);
    AppMethodBeat.o(66488);
    return localBitmap;
  }
  
  private Bitmap gvM()
  {
    AppMethodBeat.i(66489);
    if (TextUtils.isEmpty(this.MBn))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
      AppMethodBeat.o(66489);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.bz.a.a.a(this, this.MBn, 12, 3, 0.0D);
    AppMethodBeat.o(66489);
    return localBitmap;
  }
  
  private void gvN()
  {
    AppMethodBeat.i(66493);
    if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
      this.mTipDialog.dismiss();
    }
    AppMethodBeat.o(66493);
  }
  
  private void gvO()
  {
    AppMethodBeat.i(66494);
    doSceneProgress(new com.tencent.mm.plugin.offline.a.p(System.currentTimeMillis(), this.mEntryScene), false);
    AppMethodBeat.o(66494);
  }
  
  private void gvP()
  {
    AppMethodBeat.i(269302);
    com.tencent.mm.plugin.offline.a.s locals = new com.tencent.mm.plugin.offline.a.s(this.mEntryScene, this.eventId, this.MBK, this.MBx);
    this.MBx = 0;
    doSceneProgress(locals, false);
    AppMethodBeat.o(269302);
  }
  
  private void gvQ()
  {
    int j = 0;
    AppMethodBeat.i(66498);
    Bankcard localBankcard = this.MAF;
    findViewById(a.f.wallet_wx_offline_change_bankcard_tip).setVisibility(0);
    this.MAN.setTextSize(0, getResources().getDimensionPixelSize(a.d.NormalTextSize));
    String str;
    Object localObject;
    if ((this.MAN != null) && (localBankcard != null)) {
      if (localBankcard.iia())
      {
        str = localBankcard.VDK;
        localObject = com.tencent.mm.plugin.wallet_core.model.u.iiC().ijC();
        if ((localObject == null) || (Util.isNullOrNil(localBankcard.field_forbidWord))) {
          break label369;
        }
        Iterator localIterator = ((List)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (com.tencent.mm.plugin.wallet_core.model.c)localIterator.next();
        } while (!((com.tencent.mm.plugin.wallet_core.model.c)localObject).MDt.equals(localBankcard.field_bindSerial));
      }
    }
    for (;;)
    {
      if ((localObject != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.wallet_core.model.c)localObject).VCZ)))
      {
        if (!localBankcard.iia()) {
          str = localBankcard.field_desc + ((com.tencent.mm.plugin.wallet_core.model.c)localObject).VCZ;
        }
        findViewById(a.f.wallet_wx_offline_change_bankcard_tip).setVisibility(8);
        com.tencent.mm.plugin.report.service.h.OAn.b(14515, new Object[] { Integer.valueOf(2) });
        this.MAN.setTextSize(0, getResources().getDimensionPixelSize(a.d.HintTextSize));
      }
      for (int i = 1;; i = 0)
      {
        this.MAN.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), str, this.MAN.getTextSize()));
        for (;;)
        {
          if (localBankcard != null) {
            b(localBankcard);
          }
          if (i != 0)
          {
            this.MAO.setEnableColorFilter(true);
            this.MAO.setIconColor(Color.parseColor("#FA9D3B"));
            this.MAO.setImageResource(a.h.icons_filled_error);
          }
          AppMethodBeat.o(66498);
          return;
          str = getString(a.i.wallet_wx_offline_change_bankcard_tips, new Object[] { localBankcard.field_desc });
          break;
          i = j;
          if (localBankcard == null)
          {
            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
            i = j;
          }
        }
      }
      label369:
      localObject = null;
    }
  }
  
  private void gvR()
  {
    AppMethodBeat.i(66499);
    com.tencent.mm.plugin.offline.c.c localc = com.tencent.mm.plugin.offline.c.c.MDa;
    this.MAF = com.tencent.mm.plugin.offline.c.c.gwy();
    if (this.MAF != null) {
      this.Mxy = this.MAF.field_bindSerial;
    }
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial(): %s", new Object[] { this.Mxy });
    AppMethodBeat.o(66499);
  }
  
  private void gvS()
  {
    AppMethodBeat.i(66500);
    if (this.MBq)
    {
      AppMethodBeat.o(66500);
      return;
    }
    if (!this.MBF.afe(4))
    {
      AppMethodBeat.o(66500);
      return;
    }
    com.tencent.mm.kernel.h.baF();
    if ((!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acOf, Boolean.FALSE)).booleanValue()) && (!this.MBF.isShowing())) {
      gvU();
    }
    AppMethodBeat.o(66500);
  }
  
  private void gvT()
  {
    AppMethodBeat.i(269321);
    if (this.MBq)
    {
      AppMethodBeat.o(269321);
      return;
    }
    if (!this.MBF.afe(4))
    {
      AppMethodBeat.o(269321);
      return;
    }
    com.tencent.mm.kernel.h.baF();
    if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acOf, Boolean.FALSE)).booleanValue()) {
      gvU();
    }
    AppMethodBeat.o(269321);
  }
  
  private void gvU()
  {
    AppMethodBeat.i(66501);
    if (!this.MBF.afe(4))
    {
      AppMethodBeat.o(66501);
      return;
    }
    this.MBF.iy(this.MAH);
    AppMethodBeat.o(66501);
  }
  
  private void gvV()
  {
    AppMethodBeat.i(66502);
    if (!this.MBF.afe(1))
    {
      AppMethodBeat.o(66502);
      return;
    }
    if (this.MBF.MzP == 1) {
      this.MBF.dismiss();
    }
    boolean bool1 = com.tencent.mm.plugin.wallet_core.model.u.iiC().ijh();
    boolean bool2 = com.tencent.mm.plugin.wallet_core.model.u.iiC().ijg();
    boolean bool3 = com.tencent.mm.plugin.wallet_core.model.u.iiC().ijn();
    if ((bool1) || (bool2) || (bool3))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B, isRegButUnRealname: %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      this.MBF.a(this.MAH, new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269255);
          com.tencent.mm.plugin.offline.c.d.gwM();
          com.tencent.mm.plugin.offline.k.gvj();
          com.tencent.mm.plugin.offline.k.ct(196648, "0");
          WalletOfflineCoinPurseUI.L(WalletOfflineCoinPurseUI.this);
          AppMethodBeat.o(269255);
        }
      }, 1);
    }
    AppMethodBeat.o(66502);
  }
  
  private void gvW()
  {
    AppMethodBeat.i(66503);
    if (!this.MBF.afe(3))
    {
      AppMethodBeat.o(66503);
      return;
    }
    if (this.MBF.MzP == 3) {
      this.MBF.dismiss();
    }
    com.tencent.mm.plugin.offline.k.gvj();
    String str1 = com.tencent.mm.plugin.offline.k.afd(196617);
    com.tencent.mm.wallet_core.model.b.jOG();
    boolean bool1 = com.tencent.mm.wallet_core.model.b.isCertExist(str1);
    boolean bool2 = com.tencent.mm.plugin.offline.c.d.gwA();
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) || (!bool2)) {
      if (!bool1)
      {
        com.tencent.mm.kernel.h.baF();
        String str2 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acHA, "");
        if ((str2 == null) || (!str2.equals(com.tencent.mm.compatible.deviceinfo.q.eD(true)))) {
          break label222;
        }
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + str1 + " ,recreate offline");
      com.tencent.mm.plugin.offline.c.d.gwM();
      this.MAQ.setVisibility(4);
      this.MBF.a(this.MAH, new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269261);
          com.tencent.mm.plugin.offline.c.d.l(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this));
          AppMethodBeat.o(269261);
        }
      }, 3);
      AppMethodBeat.o(66503);
      return;
      label222:
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
    }
  }
  
  private void gvX()
  {
    AppMethodBeat.i(66504);
    if (!this.MBF.afe(5))
    {
      AppMethodBeat.o(66504);
      return;
    }
    if (this.MBF.MzP == 5) {
      this.MBF.dismiss();
    }
    this.MBF.c(this.MAH, new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(269260);
        com.tencent.mm.plugin.offline.k.gvj();
        com.tencent.mm.plugin.offline.k.gvm();
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.i.gvi()) });
        com.tencent.mm.plugin.offline.k.gvj();
        com.tencent.mm.plugin.offline.k.gvm();
        if (com.tencent.mm.plugin.offline.i.gvi() <= 0)
        {
          paramAnonymousView = new o((int)(System.currentTimeMillis() / 1000L), 10);
          WalletOfflineCoinPurseUI.this.doSceneForceProgress(paramAnonymousView);
          AppMethodBeat.o(269260);
          return;
        }
        WalletOfflineCoinPurseUI.M(WalletOfflineCoinPurseUI.this);
        AppMethodBeat.o(269260);
      }
    });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 73L, 1L, true);
    AppMethodBeat.o(66504);
  }
  
  private void gvZ()
  {
    AppMethodBeat.i(269332);
    if ((this.MBQ == null) || (!this.MBQ.wtT))
    {
      if (this.MBF.MzP == 8) {
        this.MBF.dismiss();
      }
      AppMethodBeat.o(269332);
      return;
    }
    if (!this.MBF.afe(8))
    {
      AppMethodBeat.o(269332);
      return;
    }
    if (this.MBF.MzP == 8) {
      this.MBF.dismiss();
    }
    this.MBF.a(this.MAH, this.MBQ);
    com.tencent.mm.plugin.report.service.h.OAn.b(20258, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(269332);
  }
  
  private void gwa()
  {
    AppMethodBeat.i(66506);
    if ((this.MBF.isShowing()) && (this.MBF.MzP == 5)) {
      this.MBF.dismiss();
    }
    AppMethodBeat.o(66506);
  }
  
  private boolean gwb()
  {
    AppMethodBeat.i(66507);
    if (!this.MBF.afe(2))
    {
      AppMethodBeat.o(66507);
      return false;
    }
    if (this.MBF.MzP == 2) {
      this.MBF.dismiss();
    }
    List localList = com.tencent.mm.plugin.offline.c.d.gwG();
    if ((localList == null) || (localList.size() <= 0))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      AppMethodBeat.o(66507);
      return false;
    }
    int i = 0;
    while (i < localList.size())
    {
      Bankcard localBankcard = (Bankcard)localList.get(i);
      if ((localBankcard != null) && (localBankcard.field_support_micropay) && (Util.isNullOrNil(localBankcard.field_forbidWord)))
      {
        AppMethodBeat.o(66507);
        return true;
      }
      i += 1;
    }
    this.MBF.a(this.MAH, new Runnable()new WalletOfflineCoinPurseUI.37
    {
      public final void run()
      {
        AppMethodBeat.i(269269);
        if (WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this)) {
          com.tencent.mm.plugin.offline.c.d.a(WalletOfflineCoinPurseUI.this, 20000, -1, WalletOfflineCoinPurseUI.this.getInput());
        }
        for (;;)
        {
          WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this);
          AppMethodBeat.o(269269);
          return;
          c localc = WalletOfflineCoinPurseUI.D(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.offline.c.d.k(localc.mActivity, localc.MAo);
        }
      }
    }, new WalletOfflineCoinPurseUI.37(this));
    AppMethodBeat.o(66507);
    return false;
  }
  
  private void gwc()
  {
    AppMethodBeat.i(269346);
    if (this.MBm != null) {
      this.MBm.cancel();
    }
    this.MBm = aa.c(getContext(), getString(a.i.wallet_offline_network_disconnect_tips));
    AppMethodBeat.o(269346);
  }
  
  private static void gwd()
  {
    AppMethodBeat.i(66510);
    if (!com.tencent.mm.plugin.offline.c.d.gwT())
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
      com.tencent.mm.plugin.offline.k.gvj();
      com.tencent.mm.plugin.offline.k.gvm().kp(3, 3);
    }
    AppMethodBeat.o(66510);
  }
  
  private void gwf()
  {
    AppMethodBeat.i(269371);
    List localList = com.tencent.mm.plugin.offline.c.d.Am(false);
    if ((localList == null) || (localList.size() <= 0))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      AppMethodBeat.o(269371);
      return;
    }
    int i = 0;
    while (i < localList.size())
    {
      Bankcard localBankcard = (Bankcard)localList.get(i);
      if ((!Util.isNullOrNil(localBankcard.field_bindSerial)) && (this.MAE.equals(localBankcard.field_bindSerial)))
      {
        a(localBankcard, false, null);
        this.MAE = "";
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "find the mBindSerialOperation");
      }
      i += 1;
    }
    if (this.MBU == null)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mJsApiOfflineUserBindQueryResultCallBackEventEvent == null");
      AppMethodBeat.o(269371);
      return;
    }
    if (!Util.isNullOrNil(this.MAE)) {}
    for (this.MBU.hPb.errMsg = "fail:no find operation bindSerial";; this.MBU.hPb.errMsg = "ok:open success")
    {
      this.MBU.hPa.callback.run();
      this.MBU = null;
      this.MAE = "";
      AppMethodBeat.o(269371);
      return;
    }
  }
  
  private boolean gwg()
  {
    AppMethodBeat.i(269375);
    Bankcard localBankcard = this.MAF;
    if ((localBankcard != null) && (localBankcard.iia()))
    {
      AppMethodBeat.o(269375);
      return true;
    }
    AppMethodBeat.o(269375);
    return false;
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(66487);
    int i;
    if (this.MBB.size() >= 2)
    {
      i = this.MBB.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.i.ah((Bitmap)this.MBB.remove(i));
        i -= 1;
      }
    }
    if (this.MBC.size() >= 2)
    {
      i = this.MBC.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.i.ah((Bitmap)this.MBC.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(66487);
  }
  
  public void addDialog(Dialog paramDialog)
  {
    AppMethodBeat.i(66492);
    if (((paramDialog instanceof com.tencent.mm.ui.widget.a.e)) && (this.MBr))
    {
      this.MBs = true;
      paramDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(269156);
          if (this.MCs != null) {
            this.MCs.onDismiss(paramAnonymousDialogInterface);
          }
          if (WalletOfflineCoinPurseUI.E(WalletOfflineCoinPurseUI.this))
          {
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.F(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.G(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.H(WalletOfflineCoinPurseUI.this);
          }
          AppMethodBeat.o(269156);
        }
      });
    }
    super.addDialog(paramDialog);
    AppMethodBeat.o(66492);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public final void dkd()
  {
    AppMethodBeat.i(66512);
    bs(0, false);
    Aj(true);
    AppMethodBeat.o(66512);
  }
  
  public final void f(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66513);
    doSceneProgress(new com.tencent.mm.plugin.offline.a.g(paramInt, paramString1, paramString2, paramString3), com.tencent.mm.plugin.offline.c.d.gwB());
    AppMethodBeat.o(66513);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_offline_coin_purse_ui;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(174404);
    Resources localResources = super.getResources();
    AppMethodBeat.o(174404);
    return localResources;
  }
  
  public final void gvY()
  {
    AppMethodBeat.i(66505);
    this.MAQ.setVisibility(4);
    this.MBF.b(this.MAH, new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(269257);
        com.tencent.mm.plugin.offline.c.d.gwM();
        com.tencent.mm.plugin.offline.c.d.m(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this));
        WalletOfflineCoinPurseUI.this.getWindow().getDecorView().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(269135);
            WalletOfflineCoinPurseUI.this.finish();
            AppMethodBeat.o(269135);
          }
        }, 300L);
        AppMethodBeat.o(269257);
      }
    });
    AppMethodBeat.o(66505);
  }
  
  public final void gvt()
  {
    AppMethodBeat.i(66514);
    Ak(false);
    AppMethodBeat.o(66514);
  }
  
  public final void gvu()
  {
    AppMethodBeat.i(66515);
    doSceneProgress(new com.tencent.mm.plugin.offline.a.l(""), false);
    AppMethodBeat.o(66515);
  }
  
  public final String gvv()
  {
    return this.Mxy;
  }
  
  public final void gvw()
  {
    AppMethodBeat.i(66518);
    if (!this.Mye.stopped()) {
      this.Mye.stopTimer();
    }
    bs(0, false);
    Aj(true);
    this.MBo = false;
    this.Mye.startTimer(this.Myd);
    AppMethodBeat.o(66518);
  }
  
  public final void gwe()
  {
    AppMethodBeat.i(269687);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "on token type change");
    gvR();
    gvQ();
    AppMethodBeat.o(269687);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66477);
    this.MAG = ((ScrollView)findViewById(a.f.offline_root_layout));
    this.MAG.setBackgroundColor(getResources().getColor(a.c.UN_Brand_BG_100));
    this.MBF = ((OfflineAlertView)findViewById(a.f.offline_alert_view));
    this.MBF.dismiss();
    this.MBF.setDialogState(new OfflineAlertView.a()
    {
      public final void bfj()
      {
        AppMethodBeat.i(269167);
        WalletOfflineCoinPurseUI.gwh();
        ((WalletOfflineCoinPurseUI.c)WalletOfflineCoinPurseUI.this.component(WalletOfflineCoinPurseUI.c.class)).gwj();
        AppMethodBeat.o(269167);
      }
      
      public final void onShow()
      {
        AppMethodBeat.i(269168);
        WalletOfflineCoinPurseUI.gwh();
        ((WalletOfflineCoinPurseUI.c)WalletOfflineCoinPurseUI.this.component(WalletOfflineCoinPurseUI.c.class)).gwj();
        AppMethodBeat.o(269168);
      }
    });
    com.tencent.mm.wallet_core.model.b.jOG().init(getApplicationContext());
    Object localObject;
    if ((this.mEntryScene == 3) || (this.mEntryScene == 10) || (this.mEntryScene == 11) || (this.mEntryScene == 12))
    {
      setMMTitle(a.i.wallet_wx_offline_coin_purse_card_title);
      this.MBE = new c(this, this);
      localObject = this.MBE;
      ((c)localObject).uAL = ((Vibrator)((c)localObject).mActivity.getSystemService("vibrator"));
      this.MBD = new com.tencent.mm.wallet_core.ui.c(this, true);
      this.MBD.jPl();
      this.MAH = findViewById(a.f.wallet_qrcode_layout);
      this.MAI = ((ImageView)findViewById(a.f.wallet_qrcode_iv));
      this.MAJ = ((ImageView)findViewById(a.f.wallet_barcode_iv));
      this.MAK = ((TextView)findViewById(a.f.wallet_barcode_tv));
      this.MAM = findViewById(a.f.wallet_wx_offline_change_bankcard_layout);
      this.MAN = ((TextView)findViewById(a.f.wallet_wx_offline_change_bankcard_tv));
      this.MAO = ((WeImageView)findViewById(a.f.wallet_wx_offline_bank_logo));
      this.MAO.setEnableColorFilter(false);
      this.MAQ = ((RelativeLayout)findViewById(a.f.wallet_offline_menu_layout));
      this.MAR = ((LinearLayout)findViewById(a.f.wallet_wx_offline_guide_layout));
      this.MAS = ((CdnImageView)findViewById(a.f.wallet_wx_offline_guide_logo_iv));
      this.MAT = ((TextView)findViewById(a.f.wallet_wx_offline_guide_content_tv));
      this.MAU = ((TextView)findViewById(a.f.wallet_wx_offline_guide_button_tv));
      this.MAM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(269131);
          ViewGroup.LayoutParams localLayoutParams = WalletOfflineCoinPurseUI.q(WalletOfflineCoinPurseUI.this).getLayoutParams();
          if (localLayoutParams != null) {
            WalletOfflineCoinPurseUI.q(WalletOfflineCoinPurseUI.this).setMinimumHeight(localLayoutParams.height);
          }
          AppMethodBeat.o(269131);
        }
      });
      this.MAQ.setOnClickListener(new WalletOfflineCoinPurseUI.18(this));
      this.MAI.setOnClickListener(this.qjL);
      this.MAJ.setOnClickListener(this.qjL);
      this.MAK.setOnClickListener(this.qjL);
      this.MAM.setClickable(true);
      this.MAM.setOnClickListener(new WalletOfflineCoinPurseUI.19(this));
      this.mLastTime = System.currentTimeMillis();
      this.MAV = new e();
      this.MAV.fZE();
      com.tencent.mm.plugin.newtips.a.gtf().h(this.MAV);
      this.MAW = new h();
      this.MAW.fZE();
      com.tencent.mm.plugin.newtips.a.gtf().h(this.MAW);
      this.MAX = new b();
      this.MAX.fZE();
      com.tencent.mm.plugin.newtips.a.gtf().h(this.MAX);
      this.MAY = new f();
      this.MAY.fZE();
      com.tencent.mm.plugin.newtips.a.gtf().h(this.MAY);
      this.MAZ = new d();
      this.MAZ.fZE();
      com.tencent.mm.plugin.newtips.a.gtf().h(this.MAZ);
      if ((this.mEntryScene != 3) && (this.mEntryScene != 10) && (this.mEntryScene != 11) && (this.mEntryScene != 12)) {
        break label1013;
      }
      this.MBf.setVisibility(8);
      this.MBg.setVisibility(8);
      this.MBh.setVisibility(8);
      this.MBi.setVisibility(8);
      label668:
      this.MBa = ((LinearLayout)findViewById(a.f.wallet_offline_jump_info_layout));
      this.MBb = ((CdnImageView)findViewById(a.f.wallet_offline_jump_info_icon_iv));
      this.MBc = ((TextView)findViewById(a.f.wallet_offline_jump_info_title_tv));
      this.MBk = ((LinearLayout)findViewById(a.f.wallet_offline_prior_card_changed_tips_layout));
      this.MBl = ((TextView)findViewById(a.f.wallet_offline_prior_card_changed_tips_tv));
      if ((com.tencent.mm.plugin.offline.c.d.gwA()) && (c.gvy()))
      {
        localObject = this.MBE;
        com.tencent.mm.plugin.offline.k.gvj();
        ((c)localObject).a(com.tencent.mm.plugin.offline.k.gvk().Mzt);
      }
      gvH();
      Ai(true);
      this.Mye.startTimer(this.Myd);
      if ((com.tencent.mm.plugin.offline.c.d.MDk != 3) || (!com.tencent.mm.plugin.offline.c.d.MDn)) {
        break label1246;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
      int i = com.tencent.mm.plugin.offline.c.d.MDl;
      long l1 = com.tencent.mm.plugin.offline.c.d.MDm;
      long l2 = System.currentTimeMillis();
      long l3 = i * 1000 + l1 - l2;
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + l1 + " now:" + l2 + " interval:" + l3);
      if ((com.tencent.mm.plugin.offline.c.d.MDl <= 0) || (com.tencent.mm.plugin.offline.c.d.MDm <= 0L) || (l3 <= 0L)) {
        break label1234;
      }
      if (!this.MCh.stopped()) {
        this.MCh.stopTimer();
      }
      this.MCh.startTimer(l3);
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
    }
    for (;;)
    {
      gvG();
      localObject = new acx();
      ((acx)localObject).igk.scene = "5";
      ((acx)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184847);
          if (!Util.isNullOrNil(this.xer.igl.igm))
          {
            com.tencent.mm.wallet_core.ui.i.a(null, (TextView)WalletOfflineCoinPurseUI.this.findViewById(a.f.banner_tips), this.xer.igl.igm, this.xer.igl.content, this.xer.igl.url);
            AppMethodBeat.o(184847);
            return;
          }
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
          AppMethodBeat.o(184847);
        }
      };
      ((acx)localObject).publish();
      AppMethodBeat.o(66477);
      return;
      setMMTitle(a.i.wallet_wx_offline_coin_purse_title);
      break;
      label1013:
      this.MBi.setVisibility(0);
      this.MBj.setVisibility(0);
      final boolean bool1 = com.tencent.mm.plugin.newtips.a.g.b(this.MAV);
      final boolean bool2 = com.tencent.mm.plugin.newtips.a.g.b(this.MAX);
      final boolean bool3 = com.tencent.mm.plugin.newtips.a.g.b(this.MAY);
      final boolean bool4 = com.tencent.mm.plugin.newtips.a.g.b(this.MAW);
      final boolean bool5 = com.tencent.mm.plugin.newtips.a.g.b(this.MAZ);
      if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUu, Boolean.FALSE)).booleanValue()) {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
      }
      ImageView localImageView;
      for (;;)
      {
        localObject = (TextView)findViewById(a.f.bank_mobile_remit_title);
        localImageView = (ImageView)findViewById(a.f.bank_mobile_remit_icon);
        if (!this.MBJ) {
          break label1210;
        }
        ((TextView)localObject).setText(a.i.bank_mobile_remit_title);
        localImageView.setImageResource(a.h.icons_outlined_transfer);
        localImageView.getDrawable().setColorFilter(getResources().getColor(a.c.BW_100_Alpha_0_9), PorterDuff.Mode.SRC_ATOP);
        break;
        getWindow().getDecorView().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(269166);
            if (WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this) == null)
            {
              AppMethodBeat.o(269166);
              return;
            }
            int[] arrayOfInt = new int[2];
            WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).getLocationInWindow(arrayOfInt);
            int i = aw.bf(WalletOfflineCoinPurseUI.this.getContext()).y;
            int j = i;
            if (aw.bg(WalletOfflineCoinPurseUI.this.getContext()))
            {
              Log.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
              j = i - aw.bk(WalletOfflineCoinPurseUI.this.getContext());
            }
            if (bool1) {}
            for (i = arrayOfInt[1] + WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).getBottom();; i = 0)
            {
              if (bool4) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).getBottom();
              }
              if (bool2) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).getBottom();
              }
              if (bool3) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.n(WalletOfflineCoinPurseUI.this).getBottom();
              }
              if (bool5) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).getBottom();
              }
              Log.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
              i -= j;
              if (i > 0) {
                WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).scrollBy(0, i);
              }
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acUu, Boolean.TRUE);
              AppMethodBeat.o(269166);
              return;
            }
          }
        });
      }
      label1210:
      ((TextView)localObject).setText(a.i.bank_remit_title);
      localImageView.setImageResource(a.h.bank_remit_transfer);
      localImageView.clearColorFilter();
      break label668;
      label1234:
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
      continue;
      label1246:
      if (com.tencent.mm.plugin.offline.c.d.MDk == 3) {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
      } else {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.c.d.MDk) });
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
    final ImageView localImageView = (ImageView)this.MAv.get(paramString);
    paramString = (Integer)this.MAw.get(paramString);
    if ((localImageView == null) || (paramString == null))
    {
      AppMethodBeat.o(66496);
      return;
    }
    new MMHandler(getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269154);
        int i = paramString.intValue();
        if ((localImageView instanceof WeImageView)) {
          ((WeImageView)localImageView).setEnableColorFilter(false);
        }
        Bitmap localBitmap = BitmapUtil.extractThumbNail(paramBitmap, i, i, true, false);
        localImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(269154);
      }
    });
    AppMethodBeat.o(66496);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66469);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.offline.c.c.MDa;
    com.tencent.mm.plugin.offline.c.c.reload();
    com.tencent.mm.plugin.wallet_core.model.u.iiw();
    this.MBJ = com.tencent.mm.plugin.wallet_core.model.u.iiL();
    com.tencent.mm.plugin.offline.k.Myo = true;
    com.tencent.mm.wallet_core.ui.i.aGA(41);
    paramBundle = getIntent();
    this.MBq = paramBundle.getBooleanExtra("is_offline_create", false);
    if ((paramBundle != null) && (paramBundle.hasExtra("key_entry_scene"))) {
      this.mEntryScene = paramBundle.getIntExtra("key_entry_scene", this.mEntryScene);
    }
    this.lCR = paramBundle.getIntExtra("key_from_scene", 0);
    this.MAL = Util.nullAs(paramBundle.getStringExtra("key_business_attach"), "");
    this.ybL = 1;
    if (this.mEntryScene == 2) {
      this.ybL = 1;
    }
    for (;;)
    {
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!WeChatEnvironment.hasDebugger())) {
        getWindow().addFlags(8192);
      }
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
      setContentViewVisibility(0);
      setActionbarColor(getResources().getColor(a.c.UN_Brand_BG_100));
      setActionbarElementColor(getResources().getColor(a.c.White));
      setNavigationbarColor(getResources().getColor(a.c.UN_Brand_BG_100));
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
          AppMethodBeat.i(269239);
          paramAnonymousMenuItem = new kg();
          paramAnonymousMenuItem.hLR.hLS = "ok";
          paramAnonymousMenuItem.publish();
          if (WalletOfflineCoinPurseUI.f(WalletOfflineCoinPurseUI.this) == 8) {
            com.tencent.mm.plugin.offline.c.d.aQW(WalletOfflineCoinPurseUI.this.getIntent().getStringExtra("key_appid"));
          }
          WalletOfflineCoinPurseUI.this.finish();
          AppMethodBeat.o(269239);
          return false;
        }
      });
      try
      {
        ScreenShotUtil.setScreenShotCallback(this, this);
        i = 1;
        if (i == 0) {
          ScreenShotUtil.setScreenShotCallback(this, null);
        }
        com.tencent.mm.wallet_core.ui.i.jPt();
        if (!com.tencent.mm.plugin.offline.a.s.isEnabled()) {
          doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ae(null, 8), false);
        }
        if (!com.tencent.mm.plugin.offline.c.d.gwA())
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doNetSceneUserBindQuery on create when not open offlinepay");
          gvP();
        }
        if (com.tencent.mm.plugin.wallet_core.model.u.iiC().ijl())
        {
          Log.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
          initView();
          paramBundle = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acVB, "");
          if (Util.isNullOrNil(paramBundle)) {}
        }
      }
      catch (Exception paramBundle)
      {
        try
        {
          label720:
          do
          {
            for (;;)
            {
              this.MBQ = com.tencent.mm.plugin.wallet_core.model.r.cp(new JSONObject(paramBundle));
              com.tencent.mm.platformtools.r.a(this);
              com.tencent.mm.plugin.offline.k.gvj();
              com.tencent.mm.plugin.offline.k.gvk().a(this);
              addSceneEndListener(606);
              addSceneEndListener(609);
              addSceneEndListener(1501);
              addSceneEndListener(580);
              com.tencent.mm.plugin.offline.k.gvj();
              com.tencent.mm.plugin.offline.k.gvl().gj(this);
              this.MCe.alive();
              com.tencent.mm.plugin.offline.c.d.gwN();
              this.MCc.alive();
              this.MCa.alive();
              this.MBV.alive();
              this.MBW.alive();
              paramBundle = com.tencent.mm.plugin.offline.c.c.MDa;
              com.tencent.mm.plugin.offline.c.c.a(this);
              this.MBX.alive();
              this.MBY.alive();
              this.MBZ.alive();
              this.MBp = new com.tencent.mm.plugin.offline.g();
              paramBundle = new qo();
              paramBundle.hTO.cHb = hashCode();
              paramBundle.publish();
              this.MCb.alive();
              AppMethodBeat.o(66469);
              return;
              if (this.mEntryScene == 1)
              {
                this.ybL = 2;
                break;
              }
              if (this.mEntryScene == 8)
              {
                this.ybL = 4;
                break;
              }
              if (this.mEntryScene == 4)
              {
                this.ybL = 6;
                break;
              }
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[] { Integer.valueOf(this.ybL) });
              break;
              paramBundle = paramBundle;
              Log.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", paramBundle, "", new Object[0]);
              getWindow().setFlags(8192, 8192);
              int i = 0;
              continue;
              if (!com.tencent.mm.plugin.wallet_core.model.u.iiC().ijh()) {
                break label720;
              }
              Log.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
              com.tencent.mm.plugin.offline.c.d.gwM();
              com.tencent.mm.plugin.offline.k.gvj();
              com.tencent.mm.plugin.offline.k.ct(196648, "0");
            }
          } while ((!com.tencent.mm.plugin.wallet_core.model.u.iiC().ijf()) || (!com.tencent.mm.plugin.offline.c.d.gwA()));
          gwd();
        }
        catch (JSONException paramBundle)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", paramBundle, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66475);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onDestory()");
    if (this.MAF != null)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerial:%s serial:%s", new Object[] { this.Mxy, this.MAF.field_bindSerial });
      if (!com.tencent.mm.plugin.wallet_core.model.ae.h(this.MAF)) {
        break label419;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onDestory：do set as default card");
    }
    for (;;)
    {
      this.MBF.dismiss();
      com.tencent.mm.plugin.offline.k.Myo = false;
      com.tencent.mm.wallet_core.ui.i.ah(this.MAx);
      com.tencent.mm.wallet_core.ui.i.ah(this.MAy);
      com.tencent.mm.wallet_core.ui.i.cj(this.MBB);
      com.tencent.mm.wallet_core.ui.i.cj(this.MBC);
      this.MBB.clear();
      this.MBC.clear();
      this.MAB.clear();
      this.MAC.clear();
      this.MAD.clear();
      com.tencent.mm.platformtools.r.c(this);
      com.tencent.mm.plugin.offline.k.gvj();
      com.tencent.mm.plugin.offline.k.gvk().b(this);
      removeSceneEndListener(606);
      removeSceneEndListener(609);
      removeSceneEndListener(1501);
      removeSceneEndListener(580);
      com.tencent.mm.plugin.offline.k.gvj();
      com.tencent.mm.plugin.offline.k.gvl().gk(this);
      this.MCe.dead();
      this.MCc.dead();
      this.MBV.dead();
      this.MBW.dead();
      if (!this.Mye.stopped()) {
        this.Mye.stopTimer();
      }
      if (!this.MCh.stopped()) {
        this.MCh.stopTimer();
      }
      if (!this.MCg.stopped()) {
        this.MCg.stopTimer();
      }
      if (this.MBD != null) {
        this.MBD.release();
      }
      if (this.MBE != null)
      {
        localObject = this.MBE;
        ((c)localObject).uAL.cancel();
        ((c)localObject).mActivity = null;
      }
      this.MCa.dead();
      this.MBY.dead();
      this.MBZ.dead();
      Object localObject = this.MBp;
      ((com.tencent.mm.plugin.offline.g)localObject).stop();
      com.tencent.mm.plugin.offline.g.gve();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(385, ((com.tencent.mm.plugin.offline.g)localObject).MxP);
      ((com.tencent.mm.plugin.offline.g)localObject).MxR = null;
      this.MCb.dead();
      this.MBX.dead();
      com.tencent.mm.plugin.remittance.mobile.a.b.ahg(0);
      localObject = com.tencent.mm.plugin.offline.c.c.MDa;
      com.tencent.mm.plugin.offline.c.c.b(this);
      localObject = com.tencent.mm.plugin.offline.c.c.MDa;
      com.tencent.mm.plugin.offline.c.c.reload();
      super.onDestroy();
      AppMethodBeat.o(66475);
      return;
      label419:
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onDestory：do not set as default card");
      Al(false);
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66517);
    if ((paramInt == 4) && (this.MBF != null) && (this.MBF.getVisibility() == 0) && (this.MBF.MzQ))
    {
      this.MBF.dismiss();
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
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
    this.MAz = true;
    AppMethodBeat.o(66473);
  }
  
  public boolean onNotify(u.d paramd)
  {
    AppMethodBeat.i(66491);
    if (paramd == null)
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
      AppMethodBeat.o(66491);
      return false;
    }
    gvN();
    this.MBD.dismiss();
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msgtype：%s，mBindSerial：%s", new Object[] { Integer.valueOf(paramd.MzB), this.Mxy });
    int i;
    if (4 == paramd.MzB)
    {
      this.MBo = false;
      i = 0;
    }
    for (;;)
    {
      c localc = this.MBE;
      if (paramd == null) {
        Log.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
      }
      for (;;)
      {
        if ((this.MBr) && (!this.MBs))
        {
          this.MBr = false;
          this.MBo = false;
        }
        if (i != 0)
        {
          bs(0, false);
          Aj(true);
        }
        AppMethodBeat.o(66491);
        return true;
        if (5 == paramd.MzB)
        {
          this.MBo = true;
          this.MBr = true;
          this.MBs = false;
          if (this.MCg.stopped()) {
            break label444;
          }
          this.MCg.stopTimer();
          i = 0;
          break;
        }
        if (6 == paramd.MzB)
        {
          if (!this.MCg.stopped()) {
            this.MCg.stopTimer();
          }
          if (!this.Mye.stopped()) {
            this.Mye.stopTimer();
          }
          this.MBo = false;
          if (!com.tencent.mm.plugin.offline.c.d.gwB()) {
            break label1593;
          }
          i = 0;
          break;
        }
        if (8 == paramd.MzB)
        {
          if (this.MCg.stopped()) {
            break label1593;
          }
          this.MCg.stopTimer();
          i = 1;
          break;
        }
        if (23 == paramd.MzB)
        {
          this.MBP = false;
          this.MBO = true;
          if (this.MCg.stopped()) {
            break label444;
          }
          this.MCg.stopTimer();
          i = 0;
          break;
        }
        if (20 == paramd.MzB)
        {
          this.MBo = false;
          if (this.MCg.stopped()) {
            break label444;
          }
          this.MCg.stopTimer();
          i = 0;
          break;
        }
        if (24 != paramd.MzB) {
          break label1593;
        }
        if (com.tencent.mm.plugin.offline.c.d.gxc())
        {
          if (gwg())
          {
            if (!this.MBz) {
              break label449;
            }
            afg(10);
          }
          label395:
          this.MBo = true;
          if (com.tencent.mm.plugin.offline.c.d.gxc())
          {
            if (this.mTipDialog != null) {
              break label472;
            }
            this.mTipDialog = com.tencent.mm.wallet_core.ui.l.a(getContext(), false, new WalletOfflineCoinPurseUI.27(this));
          }
        }
        for (;;)
        {
          this.MCg.startTimer(com.tencent.mm.plugin.offline.g.gvd());
          label444:
          i = 0;
          break;
          label449:
          if (this.MBA)
          {
            afg(11);
            break label395;
          }
          afg(12);
          break label395;
          label472:
          if (!this.mTipDialog.isShowing()) {
            this.mTipDialog.show();
          }
        }
        Log.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + paramd.MzB);
        if (paramd.MzB == 24) {
          localc.uAL.vibrate(50L);
        }
        if (4 == paramd.MzB)
        {
          localc.a((u.b)paramd);
          com.tencent.mm.plugin.offline.g.gve();
        }
        else
        {
          if (5 == paramd.MzB)
          {
            paramd = (u.f)paramd;
            if (paramd != null)
            {
              Log.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + paramd.MzF + " msg.wxRetMsg:" + paramd.MzG + " msg.cftRetCode:" + paramd.MzF + " msg.cftRetMsg:" + paramd.MzE);
              if ((!TextUtils.isEmpty(paramd.MzF)) || (!TextUtils.isEmpty(paramd.MzG)) || (!TextUtils.isEmpty(paramd.MzD)) || (!TextUtils.isEmpty(paramd.MzE)))
              {
                if ((!TextUtils.isEmpty(paramd.MzF)) || (!TextUtils.isEmpty(paramd.MzG)) || (TextUtils.isEmpty(paramd.MzD)) || (TextUtils.isEmpty(paramd.MzE))) {
                  break label753;
                }
                b.l(localc.mActivity, paramd.MzE);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.offline.g.gve();
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 0L, 1L, true);
              break;
              label753:
              if ((!TextUtils.isEmpty(paramd.MzF)) && (com.tencent.mm.plugin.offline.c.d.isNumeric(paramd.MzF))) {
                localc.a(null, Util.getInt(paramd.MzF, 0), paramd.MzG, paramd.MzH);
              } else {
                b.l(localc.mActivity, paramd.MzG);
              }
            }
          }
          Object localObject1;
          if (6 == paramd.MzB)
          {
            paramd = (com.tencent.mm.plugin.offline.a.u.g)paramd;
            int j;
            if (paramd != null)
            {
              Log.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + paramd.MzK);
              com.tencent.mm.plugin.offline.k.gvj();
              localObject1 = com.tencent.mm.plugin.offline.k.gvn().aQD(paramd.MzL.hAT);
              if (localObject1 == null) {
                break label991;
              }
              if (((com.tencent.mm.plugin.offline.a.t)localObject1).field_status != com.tencent.mm.plugin.offline.g.MxL) {
                break label986;
              }
              j = 1;
            }
            for (;;)
            {
              if (j == 0)
              {
                com.tencent.mm.plugin.offline.g.gs(paramd.MzL.hAT, com.tencent.mm.plugin.offline.g.MxL);
                com.tencent.mm.plugin.offline.c.d.a(localc.mActivity, paramd);
                localc.mActivity.setResult(-1);
                localc.mActivity.finish();
              }
              com.tencent.mm.plugin.offline.g.gve();
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 7L, 1L, true);
              if (com.tencent.mm.plugin.offline.c.d.MDk != 4) {
                break;
              }
              Log.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
              com.tencent.mm.plugin.report.service.h.OAn.b(13412, new Object[0]);
              break;
              label986:
              j = 0;
              continue;
              label991:
              j = 0;
            }
          }
          Object localObject2;
          Object localObject3;
          if (8 == paramd.MzB)
          {
            paramd = (u.h)paramd;
            Log.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + paramd.id);
            if (paramd.xld == 0)
            {
              localObject1 = localc.mActivity.getLayoutInflater().inflate(a.g.wallet_offline_payconfirm_layout, null);
              localObject2 = (TextView)((View)localObject1).findViewById(a.f.pay_fee);
              localObject3 = (TextView)((View)localObject1).findViewById(a.f.pay_good_name);
              ((TextView)localObject2).setText(paramd.MzN);
              ((TextView)localObject3).setText(paramd.MzM);
              com.tencent.mm.plugin.offline.g.gs(paramd.hMy, com.tencent.mm.plugin.offline.g.MxN);
              com.tencent.mm.ui.base.k.a(localc.mActivity, "", (View)localObject1, localc.getString(a.i.wallet_wx_offline_pay_confirm_enter), localc.getString(a.i.app_cancel), new c.11(localc, paramd), new c.12(localc, paramd));
            }
            else if (paramd.xld == 1)
            {
              if (localc.MAm != null) {
                localc.MAm.show();
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(13955, new Object[] { Integer.valueOf(1) });
              Log.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + paramd.id);
              com.tencent.mm.plugin.offline.g.gs(paramd.hMy, com.tencent.mm.plugin.offline.g.MxN);
              localc.MAm = com.tencent.mm.plugin.wallet_core.ui.u.a(localc.mActivity, paramd.MzM, paramd.MzN, new c.13(localc, paramd), new c.14(localc), new c.15(localc, paramd));
              localc.MAm.OYJ.setVisibility(0);
              localc.MAm.Oqd.setVisibility(8);
            }
          }
          else
          {
            if (23 == paramd.MzB)
            {
              paramd = (u.e)paramd;
              localObject1 = new PayInfo();
              ((PayInfo)localObject1).hAT = paramd.hMy;
              ((PayInfo)localObject1).hUR = 8;
              ((PayInfo)localObject1).YvL = 1;
              ((PayInfo)localObject1).nKf = new Bundle();
              ((PayInfo)localObject1).nKf.putLong("extinfo_key_9", System.currentTimeMillis());
              com.tencent.mm.wallet_core.b.jNX();
              boolean bool2 = com.tencent.mm.wallet_core.b.b(c.a.yRc, true);
              boolean bool1 = bool2;
              if (bool2)
              {
                com.tencent.mm.wallet_core.b.jNX();
                bool1 = true;
              }
              if (bool1)
              {
                localObject2 = (com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class);
                localObject3 = localc.mActivity;
                String str = ((PayInfo)localObject1).hAT;
                if (localc.MAl == null) {}
                for (paramd = "";; paramd = localc.MAl.gvv())
                {
                  ((com.tencent.mm.pluginsdk.wallet.a)localObject2).startOfflinePay((Context)localObject3, str, paramd, ((PayInfo)localObject1).channel);
                  break;
                }
              }
              new OfflineLogicMgr.1(localc, com.tencent.mm.app.f.hfK, (PayInfo)localObject1).alive();
              localObject2 = localc.mActivity;
              if (localc.MAl == null) {}
              for (paramd = "";; paramd = localc.MAl.gvv())
              {
                com.tencent.mm.pluginsdk.wallet.f.a((Context)localObject2, false, "", paramd, (PayInfo)localObject1, "", new Intent(), 1);
                break;
              }
            }
            if (20 == paramd.MzB) {
              com.tencent.mm.plugin.offline.g.gve();
            }
          }
        }
      }
      label1593:
      i = 1;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66474);
    com.tencent.mm.plugin.offline.k.gvj();
    com.tencent.mm.plugin.offline.i locali = com.tencent.mm.plugin.offline.k.gvm();
    locali.mHandler.removeCallbacks(locali.Myc);
    ScreenShotUtil.setScreenShotCallback(this, null);
    this.mIsForeground = false;
    this.MCd.dead();
    this.MBp.stop();
    if (this.MBm != null) {
      this.MBm.cancel();
    }
    super.onPause();
    AppMethodBeat.o(66474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66471);
    super.onResume();
    com.tencent.mm.plugin.offline.k.Myo = true;
    this.MCd.alive();
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, this);
      if (!this.MBG)
      {
        gvA();
        this.MBG = true;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
      this.mIsForeground = true;
      Object localObject = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class);
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).a(this, ((com.tencent.mm.plugin.walletlock.a.b)localObject).imz(), null);
      if (NetStatusUtil.isNetworkConnected(getBaseContext()))
      {
        if (com.tencent.mm.plugin.wallet_core.model.u.iiC().ijl()) {
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ae(null, 8));
        }
        if ((com.tencent.mm.plugin.offline.c.d.gwA()) && (this.MBN))
        {
          com.tencent.mm.plugin.offline.k.gvj();
          com.tencent.mm.plugin.offline.k.gvm().Ah(false);
          if (!c.gvy())
          {
            if (!com.tencent.mm.plugin.offline.a.s.isEnabled()) {
              break label521;
            }
            if (!this.MBy) {
              break label457;
            }
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do not doNetSceneUserBindQuery()");
            this.MBy = false;
          }
        }
      }
      if (!this.MBN) {
        this.MBN = true;
      }
      gvH();
      localObject = com.tencent.mm.plugin.offline.c.c.MDa;
      localObject = com.tencent.mm.plugin.offline.c.c.gwy();
      if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (!((Bankcard)localObject).field_bindSerial.equals(this.Mxy)))
      {
        a((Bankcard)localObject);
        i = 1;
        if ((i != 0) || ((this.MAA) && (this.MAz)))
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
          this.MAA = false;
          this.MAz = false;
          gvQ();
          bs(0, false);
          Aj(true);
        }
        localObject = this.MBp;
        if (!com.tencent.mm.plugin.offline.c.d.gxc()) {
          break label551;
        }
        Log.i(com.tencent.mm.plugin.offline.g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + ((com.tencent.mm.plugin.offline.g)localObject).MxR.stopped());
        if ((((com.tencent.mm.plugin.offline.g)localObject).MxR == null) || (((com.tencent.mm.plugin.offline.g)localObject).MxR.stopped()))
        {
          ((com.tencent.mm.plugin.offline.g)localObject).status = 1;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 61L, 1L, true);
          if (!((com.tencent.mm.plugin.offline.g)localObject).MxQ) {
            break label533;
          }
          com.tencent.mm.plugin.offline.g.gve();
          ((com.tencent.mm.plugin.offline.g)localObject).MxR.startTimer(com.tencent.mm.plugin.offline.g.MxB);
          i = com.tencent.mm.plugin.offline.g.MxB;
        }
        if (this.MBL)
        {
          this.MBL = false;
          com.tencent.mm.plugin.report.service.h.OAn.b(18930, new Object[] { Integer.valueOf(this.MBM), Integer.valueOf(4) });
        }
        this.MBR = false;
        this.MBS = false;
        AppMethodBeat.o(66471);
      }
    }
    catch (Exception localException)
    {
      label521:
      label533:
      label551:
      for (;;)
      {
        int i;
        Log.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", localException, "", new Object[0]);
        continue;
        label457:
        if (this.MBP)
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "callbackFromKinda，do not doSceneUserBindQuery");
          this.MBP = false;
          this.MBO = false;
        }
        else if (this.MBO)
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "is paying in kinda，do not doSceneUserBindQuery");
        }
        else
        {
          gvP();
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do doNetSceneUserBindQuery()");
          continue;
          gvO();
          continue;
          i = 0;
          continue;
          localException.MxR.startTimer(com.tencent.mm.plugin.offline.g.MxO);
          i = com.tencent.mm.plugin.offline.g.MxO;
          continue;
          Log.i(com.tencent.mm.plugin.offline.g.TAG, "OfflineGetMsg is not in abtest");
        }
      }
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(66476);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " scene: " + paramp);
    if (((paramp instanceof com.tencent.mm.plugin.offline.a.h)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.Myb.gvp();
      this.Myb = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.ae))
      {
        if (this.MBH)
        {
          this.MBH = false;
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "bind card success - fromKinda");
          if (!com.tencent.mm.plugin.offline.c.d.gwA())
          {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "bind card success need doCreateOffline");
            paramString = com.tencent.mm.plugin.offline.c.d.gwC();
            if (paramString != null) {
              doSceneForceProgress(new com.tencent.mm.plugin.offline.a.m(paramString, this.MBI, 0));
            }
          }
          AppMethodBeat.o(66476);
          return true;
        }
        if (com.tencent.mm.plugin.offline.c.d.gwA())
        {
          if (com.tencent.mm.plugin.offline.c.d.gwD() != null) {
            gvO();
          }
          gwd();
        }
        paramString = ((com.tencent.mm.plugin.wallet_core.c.ae)paramp).Vyk;
        if ((paramString == null) || (paramString.VGl == 0))
        {
          if (this.MBF.MzP == 7) {
            this.MBF.dismiss();
          }
          this.MBQ = ((com.tencent.mm.plugin.wallet_core.c.ae)paramp).Vyl;
          gvZ();
          gwb();
          label284:
          if ((!(paramp instanceof com.tencent.mm.plugin.wallet_core.c.ae)) && (!(paramp instanceof com.tencent.mm.plugin.offline.a.p)) && (!(paramp instanceof com.tencent.mm.plugin.offline.a.c)) && (!(paramp instanceof com.tencent.mm.plugin.offline.a.g))) {
            break label1564;
          }
          if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.ae))
          {
            if ((!this.MBS) && (!this.MBR)) {
              break label1556;
            }
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hasClickFQFGuideBar || hasClickChangeBankcardLayout，dont resetDefaultBankcard");
          }
          label347:
          gvH();
          Ai(false);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66476);
      return true;
      if (!this.MBF.afe(7)) {
        break;
      }
      if (this.MBF.MzP == 7) {
        this.MBF.dismiss();
      }
      this.MBM = paramString.VGk;
      Object localObject1 = this.MBF;
      View localView = this.MAH;
      Object localObject2 = new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269268);
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do click fqf text link");
          WalletOfflineCoinPurseUI.N(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, "weixin://wcpay/fqf/opentinyapp");
          AppMethodBeat.o(269268);
        }
      };
      com.tencent.mm.plugin.report.service.h.OAn.b(18930, new Object[] { Integer.valueOf(paramString.VGk), Integer.valueOf(1) });
      ((OfflineAlertView)localObject1).MzP = 7;
      ((OfflineAlertView)localObject1).setVisibility(0);
      ((OfflineAlertView)localObject1).MzQ = false;
      ((OfflineAlertView)localObject1).pzj.removeAllViews();
      Object localObject3 = LayoutInflater.from(((OfflineAlertView)localObject1).getContext()).inflate(a.g.wallet_offline_installment_overdue_layout, ((OfflineAlertView)localObject1).pzj, false);
      ((OfflineAlertView)localObject1).pzj.addView((View)localObject3);
      Object localObject4 = (TextView)((View)localObject3).findViewById(a.f.main_title_tv);
      TextView localTextView = (TextView)((View)localObject3).findViewById(a.f.sub_title_tv);
      localObject3 = (Button)((View)localObject3).findViewById(a.f.i_know_btn);
      if (!Util.isNullOrNil(paramString.VGn)) {
        ((TextView)localObject4).setText(paramString.VGn);
      }
      if (!Util.isNullOrNil(paramString.VGo))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("repayment_tiny_app_username", paramString.VGp);
        ((Bundle)localObject4).putString("repayment_tiny_app_path", paramString.VGq);
        localTextView.setText(paramString.VGo);
        com.tencent.mm.pluginsdk.ui.span.p.a(localTextView, false, localObject4);
        if (((OfflineAlertView)localObject1).vIA != null) {
          com.tencent.mm.pluginsdk.ui.span.p.b(((OfflineAlertView)localObject1).vIA);
        }
        ((OfflineAlertView)localObject1).vIA = new OfflineAlertView.7((OfflineAlertView)localObject1, (View.OnClickListener)localObject2, paramString);
        com.tencent.mm.pluginsdk.ui.span.p.a(((OfflineAlertView)localObject1).vIA);
      }
      if (paramString.VGm > 0)
      {
        ((Button)localObject3).setEnabled(false);
        if (((OfflineAlertView)localObject1).MzS == null) {
          break label747;
        }
        ((OfflineAlertView)localObject1).MzS.cancel();
      }
      for (;;)
      {
        ((OfflineAlertView)localObject1).MzS.start();
        ((Button)localObject3).setOnClickListener(new OfflineAlertView.9((OfflineAlertView)localObject1, paramString));
        localView.post(new OfflineAlertView.10((OfflineAlertView)localObject1, localView));
        break;
        label747:
        localObject2 = new com.tencent.mm.wallet_core.model.c();
        ((com.tencent.mm.wallet_core.model.c)localObject2).duration = (paramString.VGm * 1000);
        ((com.tencent.mm.wallet_core.model.c)localObject2).interval = 1000L;
        ((com.tencent.mm.wallet_core.model.c)localObject2).agSI = new OfflineAlertView.8((OfflineAlertView)localObject1, (Button)localObject3);
        ((OfflineAlertView)localObject1).MzS = new c.1((com.tencent.mm.wallet_core.model.c)localObject2, ((com.tencent.mm.wallet_core.model.c)localObject2).duration, ((com.tencent.mm.wallet_core.model.c)localObject2).interval);
      }
      if ((paramp instanceof o))
      {
        this.Myb = ((o)paramp);
        this.Myb.gvp();
        break label284;
      }
      if ((paramp instanceof com.tencent.mm.plugin.offline.a.l))
      {
        gvH();
        gvA();
        break label284;
      }
      if ((paramp instanceof com.tencent.mm.plugin.offline.a.p))
      {
        paramString = (com.tencent.mm.plugin.offline.a.p)paramp;
        if ("1".equals(paramString.Mzm))
        {
          Log.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
          if (Util.isNullOrNil(paramString.Mzn)) {}
          for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.Mzn)
          {
            com.tencent.mm.ui.base.k.a(this, paramString, "", false, new WalletOfflineCoinPurseUI.6(this));
            AppMethodBeat.o(66476);
            return true;
          }
        }
        if (paramString.MyG == 0)
        {
          localObject1 = this.MBE;
          ((c)localObject1).MAn = com.tencent.mm.plugin.offline.c.d.gwH();
          ((c)localObject1).MAn = ((c)localObject1).MAn;
          if (!"1".equals(paramString.Mzl)) {
            break label284;
          }
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
          paramString = com.tencent.mm.plugin.offline.a.b.MyA;
          if (!com.tencent.mm.plugin.offline.a.b.gvo())
          {
            doSceneProgress(new o((int)(System.currentTimeMillis() / 1000L), 8), false);
            break label284;
          }
          Log.w("MicroMsg.WalletOfflineCoinPurseUI", "is doing setofflinepayment");
          break label284;
        }
        if (paramString.MyG == 0) {
          break label284;
        }
        this.MBE.a(paramString, paramString.MyG, paramString.MyH);
        break label284;
      }
      if ((paramp instanceof com.tencent.mm.plugin.offline.a.c)) {
        break label284;
      }
      if ((paramp instanceof com.tencent.mm.plugin.offline.a.g))
      {
        this.MBE.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
        break label284;
      }
      if ((paramp instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
      {
        if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
          this.mTipDialog.dismiss();
        }
        paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.i)paramp;
        if (("1".equals(paramString.VBC)) || (("2".equals(paramString.VBC)) && (!Util.isNullOrNil(paramString.VBD))))
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
          if ("collect".equals(paramString.VBG)) {
            gvB();
          } else if ("reward".equals(paramString.VBG)) {
            com.tencent.mm.br.c.ai(getContext(), "collect", ".reward.ui.QrRewardMainUI");
          } else {
            Log.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { paramString.VBG });
          }
        }
      }
      if (!(paramp instanceof com.tencent.mm.plugin.offline.a.s)) {
        break label284;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneTenpayWxOfflineUserBindQuery ok");
      paramString = (com.tencent.mm.plugin.offline.a.s)paramp;
      this.MBt = true;
      if ((paramString.isJumpRemind()) && (!this.MBu))
      {
        localObject1 = paramString.getJumpRemind();
        ((com.tencent.mm.wallet_core.model.m)localObject1).jOK();
        if (((com.tencent.mm.wallet_core.model.m)localObject1).a(this, new com.tencent.mm.wallet_core.model.g()
        {
          public final void fWQ() {}
        })) {
          this.MBu = true;
        }
      }
      onSceneEnd(paramString.Mzr.errType, paramString.Mzr.errCode, paramString.Mzr.errMsg, paramString.Mzp);
      onSceneEnd(paramString.Mzq.errType, paramString.Mzq.errCode, paramString.Mzq.errMsg, paramString.Mzo);
      localObject1 = com.tencent.mm.plugin.offline.c.c.MDa;
      if (com.tencent.mm.plugin.offline.c.c.gwz())
      {
        gvR();
        gvQ();
      }
      if ((this.MBw != null) && (this.MBw.xcO.isShowing()) && (this.MBv == 1)) {
        Ak(true);
      }
      if (!Util.isNullOrNil(this.MAE))
      {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerialOperation：%s", new Object[] { this.MAE });
        gwf();
      }
      this.MBT = paramString.Mzs;
      gvD();
      break label284;
      label1556:
      Al(true);
      break label347;
      label1564:
      if (!(paramp instanceof com.tencent.mm.plugin.offline.a.h)) {
        if ((paramp instanceof com.tencent.mm.plugin.offline.a.m))
        {
          Ai(true);
          com.tencent.mm.plugin.offline.c.d.bi(this);
          doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ae(null, 8), false);
          gvV();
          gvW();
          gvS();
        }
        else if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.d))
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneCheckPayJsapi ok");
          this.MAR.setVisibility(8);
          com.tencent.mm.plugin.wallet_core.model.u.iiC().c(null);
          if (this.MBU != null)
          {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end mJsApiOfflineUserBindQueryResultCallBackEventEvent != null");
            paramString = this.MBU;
            if (paramString.hPa.hPh.equals("1"))
            {
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "FQF openSuccess");
              afg(6);
              if (!Util.isNullOrNil(paramString.hPa.hPg))
              {
                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "event.data.bindSerial is : %s", new Object[] { paramString.hPa.hPg });
                this.MAE = paramString.hPa.hPg;
              }
              doSceneProgress(new com.tencent.mm.plugin.offline.a.s(this.mEntryScene, this.eventId, "", paramString.hPa.appId, paramString.hPa.hPd), false);
            }
            else
            {
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "FQF openfail");
              afg(7);
              if (this.MBU != null)
              {
                this.MBU.hPb.errMsg = "ok:open fail";
                this.MBU.hPa.callback.run();
                this.MBU = null;
                this.MAE = "";
              }
            }
          }
          else
          {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneCheckPayJsapi fail");
            continue;
            if ((paramp instanceof com.tencent.mm.plugin.offline.a.p))
            {
              gvH();
              Ai(false);
              if (411 == paramInt2) {
                this.MBE.a(paramp, paramInt2, paramString);
              }
            }
            else if ((paramp instanceof com.tencent.mm.plugin.offline.a.g))
            {
              this.MBE.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
            }
            else if ((!(paramp instanceof com.tencent.mm.plugin.offline.a.l)) && (!(paramp instanceof com.tencent.mm.plugin.offline.a.h)))
            {
              if ((paramp instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
              {
                if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
                  this.mTipDialog.dismiss();
                }
              }
              else if ((paramp instanceof com.tencent.mm.plugin.offline.a.s))
              {
                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneTenpayWxOfflineUserBindQuery fail");
                gvH();
                Ai(false);
                if (411 == paramInt2) {
                  this.MBE.a(paramp, paramInt2, paramString);
                }
                if (this.MBU != null)
                {
                  this.MBU.hPb.errMsg = "fail:NetSceneTenpayWxOfflineUserBindQuery";
                  this.MBU.hPa.callback.run();
                  this.MBU = null;
                  this.MAE = "";
                }
              }
              else if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.d))
              {
                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneCheckPayJsapi fail");
                if (this.MBU != null)
                {
                  this.MBU.hPb.errMsg = "fail:NetSceneCheckPayJsapi";
                  this.MBU.hPa.callback.run();
                  this.MBU = null;
                  this.MAE = "";
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(269672);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
    bs(1, false);
    Aj(true);
    com.tencent.mm.wallet_core.ui.i.aGA(40);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 21L, 1L, true);
    if (this.MBD.qjH.isShowing())
    {
      if (this.MBD.wAg)
      {
        this.MBD.jPn();
        AppMethodBeat.o(269672);
        return;
      }
      this.MBD.dismiss();
    }
    gvU();
    AppMethodBeat.o(269672);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(269688);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(c.class);
    paramHashSet.add(d.class);
    AppMethodBeat.o(269688);
  }
  
  abstract class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    protected TextView MCA;
    protected TextView MCB;
    protected ImageView MCC;
    
    public a()
    {
      gwi();
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
    }
    
    public final boolean a(boolean paramBoolean, fng paramfng)
    {
      if (paramBoolean)
      {
        this.MCC.setVisibility(0);
        this.MCB.setVisibility(0);
        this.MCB.setText(paramfng.title);
      }
      for (;;)
      {
        return true;
        this.MCC.setVisibility(8);
        this.MCB.setVisibility(8);
      }
    }
    
    public final boolean b(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean fZD()
    {
      return false;
    }
    
    public boolean fZE()
    {
      return false;
    }
    
    public abstract void gwi();
    
    public final boolean ym(boolean paramBoolean)
    {
      return com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
    }
    
    public final boolean yn(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.MCC.setVisibility(0);
      }
      for (;;)
      {
        return true;
        this.MCC.setVisibility(8);
      }
    }
    
    public final boolean yo(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.MCA.setVisibility(0);
      }
      for (;;)
      {
        return true;
        this.MCA.setVisibility(8);
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
    
    public final boolean fZE()
    {
      AppMethodBeat.i(66444);
      super.fZE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.aa.c.aYo().b(at.a.acUp, at.a.acTk))
      {
        this.MCA.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.MsL, true);
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
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66445);
      return localLinearLayout;
    }
    
    public final void gwi()
    {
      AppMethodBeat.i(66443);
      WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(a.f.wallet_offline_aa_btn_layout));
      this.MCA = ((TextView)WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).findViewById(a.f.aa_new_dot));
      this.MCB = ((TextView)WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).findViewById(a.f.aa_red_wording));
      this.MCC = ((ImageView)WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).findViewById(a.f.aa_red_dot));
      WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269196);
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
          com.tencent.mm.plugin.newtips.a.gtf().aeI(16);
          com.tencent.mm.plugin.report.service.h.OAn.b(14021, new Object[] { Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.ae(WalletOfflineCoinPurseUI.this)) });
          paramAnonymousView = new Intent();
          if (WalletOfflineCoinPurseUI.f(WalletOfflineCoinPurseUI.this) == 1) {
            paramAnonymousView.putExtra("enter_scene", 2);
          }
          for (;;)
          {
            com.tencent.mm.br.c.b(WalletOfflineCoinPurseUI.this.getContext(), "aa", ".ui.AAEntranceUI", paramAnonymousView);
            WalletOfflineCoinPurseUI.ab(WalletOfflineCoinPurseUI.this);
            if (com.tencent.mm.aa.c.aYo().b(at.a.acUp, at.a.acTk))
            {
              com.tencent.mm.aa.c.aYo().c(at.a.acUp, at.a.acTk);
              WalletOfflineCoinPurseUI.b.this.MCA.setVisibility(8);
              com.tencent.mm.plugin.report.service.h.OAn.b(14396, new Object[] { Integer.valueOf(4) });
            }
            AppMethodBeat.o(269196);
            return;
            if (WalletOfflineCoinPurseUI.f(WalletOfflineCoinPurseUI.this) == 2) {
              paramAnonymousView.putExtra("enter_scene", 4);
            } else {
              Log.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { Integer.valueOf(WalletOfflineCoinPurseUI.f(WalletOfflineCoinPurseUI.this)) });
            }
          }
        }
      });
      AppMethodBeat.o(66443);
    }
  }
  
  public static class c
    extends MMBaseAccessibilityConfig
  {
    public c(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
    
    public final void gwj()
    {
      AppMethodBeat.i(269148);
      ViewGroup localViewGroup1 = (ViewGroup)findViewById(a.f.offline_alert_view);
      ViewGroup localViewGroup2 = (ViewGroup)findViewById(a.f.wallet_qrcode_layout);
      if ((localViewGroup1 == null) || (localViewGroup2 == null))
      {
        AppMethodBeat.o(269148);
        return;
      }
      if (localViewGroup1.isShown())
      {
        localViewGroup1.setImportantForAccessibility(1);
        localViewGroup2.setImportantForAccessibility(4);
        AppMethodBeat.o(269148);
        return;
      }
      localViewGroup1.setImportantForAccessibility(2);
      localViewGroup2.setImportantForAccessibility(1);
      AppMethodBeat.o(269148);
    }
    
    public void initConfig()
    {
      AppMethodBeat.i(269142);
      MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.f.offline_root_layout);
      localConfigHelper.disable(a.f.offline_content_layout);
      focusFirst(a.f.wallet_offline_centent_title_tv);
      focusOrder().next(a.f.wallet_offline_centent_title_tv);
      localConfigHelper.view(a.f.wallet_barcode_layout).desc(a.i.wallet_wx_offline_barcode_content_description_1).clickAs(a.f.wallet_barcode_tv);
      localConfigHelper.view(a.f.wallet_qrcode_iv).type(ViewType.TextView);
      localConfigHelper.view(a.f.offline_unopen_top_layout).desc(a.i.offline_unopened_pay_desc_tips);
      localConfigHelper.view(a.f.tip_first).desc(a.i.wallet_offline_know_new_tips_default);
      localConfigHelper.view(a.f.no_support_tips).desc(a.i.wallet_offline_support_error_default);
      localConfigHelper.view(a.f.take_for_more).type(ViewType.Button);
      localConfigHelper.view(a.f.top_layout).desc(new kotlin.g.a.b() {});
      localConfigHelper.view(a.f.wallet_offline_collect_btn_layout).desc(a.i.offline_collect_btn_text).type(ViewType.Button);
      localConfigHelper.view(a.f.wallet_offline_qr_reward_layout).desc(a.i.qr_reward_main_title).type(ViewType.Button);
      localConfigHelper.view(a.f.wallet_offline_aa_btn_layout).desc(a.i.launch_aa_title).type(ViewType.Button);
      localConfigHelper.view(a.f.wallet_offline_f2f_lucky_btn_layout).desc(a.i.lucky_money_f2f_title).type(ViewType.Button);
      localConfigHelper.view(a.f.wallet_offline_bank_remit_layout).desc(a.i.bank_mobile_remit_title).type(ViewType.Button);
      localConfigHelper.view(a.f.wallet_wx_offline_change_bankcard_layout).desc(new kotlin.g.a.b() {}).type(ViewType.Button);
      AppMethodBeat.o(269142);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(269144);
      super.onResume();
      gwj();
      AppMethodBeat.o(269144);
    }
  }
  
  final class d
    extends WalletOfflineCoinPurseUI.a
  {
    public d()
    {
      super();
    }
    
    public final String getPath()
    {
      return "transfertoreddot";
    }
    
    public final View getRoot()
    {
      AppMethodBeat.i(66453);
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66453);
      return localLinearLayout;
    }
    
    public final void gwi()
    {
      AppMethodBeat.i(66452);
      WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(a.f.wallet_offline_bank_remit_layout));
      this.MCA = ((TextView)WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).findViewById(a.f.bank_remit_new_dot));
      this.MCB = ((TextView)WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).findViewById(a.f.bank_remit_red_wording));
      this.MCC = ((ImageView)WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).findViewById(a.f.bank_remit_red_dot));
      WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269202);
          WalletOfflineCoinPurseUI.ab(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = new rq();
          paramAnonymousView.ikE = 3L;
          paramAnonymousView.bMH();
          com.tencent.mm.plugin.newtips.a.gtf().aeI(20);
          com.tencent.mm.plugin.remittance.mobile.a.b.ahg(WalletOfflineCoinPurseUI.f(WalletOfflineCoinPurseUI.this));
          if (WalletOfflineCoinPurseUI.ag(WalletOfflineCoinPurseUI.this))
          {
            com.tencent.mm.br.c.ai(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".mobile.ui.BankMobileRemittanceChooseUI");
            AppMethodBeat.o(269202);
            return;
          }
          com.tencent.mm.br.c.ai(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
          AppMethodBeat.o(269202);
        }
      });
      AppMethodBeat.o(66452);
    }
  }
  
  final class e
    extends WalletOfflineCoinPurseUI.a
  {
    public e()
    {
      super();
    }
    
    public final boolean fZE()
    {
      AppMethodBeat.i(66457);
      super.fZE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.aa.c.aYo().b(at.a.acUq, at.a.acTk))
      {
        com.tencent.mm.kernel.h.baF();
        String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTE, "");
        if (Util.isNullOrNil(str)) {
          break label98;
        }
        this.MCB.setText(str);
        this.MCB.setVisibility(0);
        this.MCC.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.MsM, true);
      }
      for (;;)
      {
        AppMethodBeat.o(66457);
        return true;
        label98:
        this.MCA.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.MsL, true);
      }
    }
    
    public final String getPath()
    {
      return "facingreceivereddot";
    }
    
    public final View getRoot()
    {
      AppMethodBeat.i(66458);
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66458);
      return localLinearLayout;
    }
    
    public final void gwi()
    {
      AppMethodBeat.i(66456);
      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(a.f.wallet_offline_collect_btn_layout));
      this.MCA = ((TextView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_recv_new_dot));
      this.MCB = ((TextView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_recv_red_wording));
      this.MCC = ((ImageView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_recv_red_dot));
      WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269267);
          WalletOfflineCoinPurseUI.ab(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.gtf().aeI(17);
          if (com.tencent.mm.aa.c.aYo().b(at.a.acUq, at.a.acTk))
          {
            com.tencent.mm.aa.c.aYo().c(at.a.acUq, at.a.acTk);
            WalletOfflineCoinPurseUI.e.this.MCA.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.MCB.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.MCC.setVisibility(8);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acTE, "");
            com.tencent.mm.plugin.report.service.h.OAn.b(14396, new Object[] { Integer.valueOf(3) });
          }
          if (com.tencent.mm.plugin.wallet_core.model.u.iiC().ijf())
          {
            WalletOfflineCoinPurseUI.ac(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.o(269267);
            return;
          }
          com.tencent.mm.plugin.wallet_core.model.u.iiw();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          com.tencent.mm.wallet_core.c.i locali = WalletOfflineCoinPurseUI.ad(WalletOfflineCoinPurseUI.this);
          new a.a()
          {
            public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(66454);
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + paramAnonymous2Int1 + ";errCode=" + paramAnonymous2Int2 + ";errMsg=" + paramAnonymous2String + ";hadAgree = " + paramAnonymous2Boolean);
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
                else if (WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this) != null)
                {
                  WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this).dismiss();
                }
              }
            }
          };
          if (!com.tencent.mm.plugin.wallet_core.model.u.b(paramAnonymousView, locali, 1006))
          {
            paramAnonymousView = new com.tencent.mm.plugin.wallet_core.id_verify.model.i("collect");
            WalletOfflineCoinPurseUI.this.doSceneForceProgress(paramAnonymousView);
          }
          AppMethodBeat.o(269267);
        }
      });
      AppMethodBeat.o(66456);
    }
  }
  
  final class f
    extends WalletOfflineCoinPurseUI.a
  {
    public f()
    {
      super();
    }
    
    public final boolean fZE()
    {
      AppMethodBeat.i(66461);
      super.fZE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.aa.c.aYo().b(at.a.acUr, at.a.acTk))
      {
        this.MCA.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.MsL, true);
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
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.n(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66462);
      return localLinearLayout;
    }
    
    public final void gwi()
    {
      AppMethodBeat.i(66460);
      WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(a.f.wallet_offline_f2f_lucky_btn_layout));
      this.MCA = ((TextView)WalletOfflineCoinPurseUI.n(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_hb_new_dot));
      this.MCB = ((TextView)WalletOfflineCoinPurseUI.n(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_hb_red_wording));
      this.MCC = ((ImageView)WalletOfflineCoinPurseUI.n(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_hb_red_dot));
      WalletOfflineCoinPurseUI.n(WalletOfflineCoinPurseUI.this).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269198);
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
          WalletOfflineCoinPurseUI.ab(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.gtf().aeI(18);
          com.tencent.mm.plugin.report.service.h.OAn.b(14021, new Object[] { Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.ae(WalletOfflineCoinPurseUI.this)) });
          com.tencent.mm.br.c.ai(WalletOfflineCoinPurseUI.this.getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
          if (com.tencent.mm.aa.c.aYo().b(at.a.acUr, at.a.acTk))
          {
            com.tencent.mm.aa.c.aYo().c(at.a.acUr, at.a.acTk);
            WalletOfflineCoinPurseUI.f.this.MCA.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.OAn.b(14396, new Object[] { Integer.valueOf(5) });
          }
          AppMethodBeat.o(269198);
        }
      });
      AppMethodBeat.o(66460);
    }
  }
  
  static final class g
  {
    public String MCJ;
    public String MCK;
    public String MCL;
    public String h5Url;
    public String iconUrl;
    public int jumpType;
  }
  
  final class h
    extends WalletOfflineCoinPurseUI.a
  {
    public h()
    {
      super();
    }
    
    public final boolean fZE()
    {
      AppMethodBeat.i(66467);
      super.fZE();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.aa.c.aYo().b(at.a.acUs, at.a.acTk))
      {
        this.MCA.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.MsL, true);
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
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66466);
      return localLinearLayout;
    }
    
    public final void gwi()
    {
      AppMethodBeat.i(66465);
      WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(a.f.wallet_offline_qr_reward_layout));
      this.MCA = ((TextView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(a.f.qr_reward_new_dot));
      this.MCB = ((TextView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(a.f.qr_reward_red_wording));
      this.MCC = ((ImageView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(a.f.qr_reward_red_dot));
      WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(269172);
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
          WalletOfflineCoinPurseUI.ab(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.gtf().aeI(19);
          com.tencent.mm.plugin.report.service.h.OAn.b(14021, new Object[] { Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.ae(WalletOfflineCoinPurseUI.this)) });
          if (com.tencent.mm.aa.c.aYo().b(at.a.acUs, at.a.acTk))
          {
            com.tencent.mm.aa.c.aYo().c(at.a.acUs, at.a.acTk);
            WalletOfflineCoinPurseUI.h.this.MCA.setVisibility(8);
          }
          if (com.tencent.mm.plugin.wallet_core.model.u.iiC().ijf())
          {
            com.tencent.mm.br.c.ai(WalletOfflineCoinPurseUI.this.getContext(), "collect", ".reward.ui.QrRewardMainUI");
            AppMethodBeat.o(269172);
            return;
          }
          com.tencent.mm.plugin.wallet_core.model.u.iiw();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          com.tencent.mm.wallet_core.c.i locali = WalletOfflineCoinPurseUI.af(WalletOfflineCoinPurseUI.this);
          new a.a()
          {
            public final boolean run(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(66463);
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + paramAnonymous2Int1 + ";errCode=" + paramAnonymous2Int2 + ";errMsg=" + paramAnonymous2String + ";hadAgree = " + paramAnonymous2Boolean);
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
                else if (WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this) != null)
                {
                  WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this).dismiss();
                }
              }
            }
          };
          if (!com.tencent.mm.plugin.wallet_core.model.u.b(paramAnonymousView, locali, 1006))
          {
            paramAnonymousView = new com.tencent.mm.plugin.wallet_core.id_verify.model.i("reward");
            WalletOfflineCoinPurseUI.this.doSceneForceProgress(paramAnonymousView);
          }
          AppMethodBeat.o(269172);
        }
      });
      AppMethodBeat.o(66465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI
 * JD-Core Version:    0.7.0.1
 */