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
import android.support.v7.app.AppCompatActivity;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.lc.a;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.b;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.g.b.a.ag;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.offline.a.j;
import com.tencent.mm.plugin.offline.a.n;
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
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
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
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
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
  implements u.a, s.a, com.tencent.mm.plugin.offline.b, a, ScreenShotUtil.ScreenShotCallback
{
  private static int oEI = 0;
  private String AII;
  private com.tencent.mm.plugin.offline.a.m AIK;
  private int AIM;
  private MTimerHandler AIN;
  private String AIf;
  private IListener<lj> AJa;
  private HashMap<String, View> AKR;
  private HashMap<String, Integer> AKS;
  Bitmap AKT;
  Bitmap AKU;
  private c AKV;
  private boolean AKW;
  private boolean AKX;
  private ArrayList<String> AKY;
  private ArrayList<String> AKZ;
  private String ALA;
  private boolean ALB;
  private com.tencent.mm.plugin.offline.g ALC;
  private boolean ALD;
  private boolean ALE;
  private boolean ALF;
  private boolean ALG;
  private boolean ALH;
  private int ALI;
  private com.tencent.mm.plugin.wallet.ui.a ALJ;
  private int ALK;
  private boolean ALM;
  private boolean ALN;
  private boolean ALO;
  private ArrayList<Bitmap> ALP;
  private ArrayList<Bitmap> ALQ;
  private com.tencent.mm.wallet_core.ui.c ALR;
  private c ALS;
  private OfflineAlertView ALT;
  private boolean ALU;
  private boolean ALV;
  private String ALW;
  private boolean ALX;
  private String ALY;
  private boolean ALZ;
  private ArrayList<Boolean> ALa;
  private String ALb;
  private String ALc;
  private View ALd;
  private ImageView ALe;
  private ImageView ALf;
  private TextView ALg;
  private String ALh;
  private View ALi;
  private TextView ALj;
  private WeImageView ALk;
  private RelativeLayout ALl;
  private LinearLayout ALm;
  private CdnImageView ALn;
  private TextView ALo;
  private TextView ALp;
  private e ALq;
  private g ALr;
  private b ALs;
  private f ALt;
  private d ALu;
  private LinearLayout ALv;
  private LinearLayout ALw;
  private LinearLayout ALx;
  private LinearLayout ALy;
  private LinearLayout ALz;
  private int AMa;
  private boolean AMb;
  private com.tencent.mm.plugin.wallet_core.model.r AMc;
  private boolean AMd;
  private boolean AMe;
  private com.tencent.mm.g.a.lc AMf;
  IListener<aaa> AMg;
  IListener<com.tencent.mm.g.a.lc> AMh;
  IListener<aaa> AMi;
  private IListener<da> AMj;
  private IListener<ov> AMk;
  private IListener<oe> AMl;
  private IListener<of> AMm;
  private IListener AMn;
  private IListener AMo;
  private IListener AMp;
  public boolean AMq;
  private MTimerHandler AMr;
  private MTimerHandler AMs;
  private int eventId;
  private int gwE;
  private View.OnClickListener kuO;
  private int mEntryScene;
  private boolean mIsForeground;
  private long mLastTime;
  private int mState;
  private Dialog mTipDialog;
  private boolean pZM;
  private int sQn;
  private HashMap<String, Integer> yNN;
  
  public WalletOfflineCoinPurseUI()
  {
    AppMethodBeat.i(66468);
    this.mLastTime = 0L;
    this.mState = 3;
    this.AKR = new HashMap();
    this.AKS = new HashMap();
    this.mEntryScene = -1;
    this.AKT = null;
    this.AKU = null;
    this.AKW = false;
    this.AKX = false;
    this.AKY = new ArrayList();
    this.AKZ = new ArrayList();
    this.ALa = new ArrayList();
    this.AIf = "";
    this.ALb = "";
    this.ALc = "";
    this.ALA = "";
    this.AII = "";
    this.pZM = true;
    this.ALB = false;
    this.ALD = false;
    this.ALE = false;
    this.ALF = false;
    this.ALG = true;
    this.ALH = false;
    this.ALI = -1;
    this.ALK = 1;
    this.ALM = false;
    this.ALN = false;
    this.ALO = false;
    this.ALP = new ArrayList();
    this.ALQ = new ArrayList();
    this.ALU = false;
    this.ALV = false;
    this.ALW = null;
    this.ALX = false;
    this.eventId = 0;
    this.ALZ = false;
    this.AMb = true;
    this.AMd = false;
    this.AMe = false;
    this.AMg = new IListener() {};
    this.AMh = new IListener() {};
    this.AMi = new IListener() {};
    this.AMj = new IListener() {};
    this.AMk = new IListener() {};
    this.AMl = new IListener() {};
    this.AMm = new IListener() {};
    this.AMn = new IListener() {};
    this.AMo = new IListener() {};
    this.AMp = new IListener() {};
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213639);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        long l;
        if ((paramAnonymousView.getId() == 2131310288) || (paramAnonymousView.getId() == 2131310153) || (paramAnonymousView.getId() == 2131310154))
        {
          if ((paramAnonymousView.getId() == 2131310288) && (WalletOfflineCoinPurseUI.r(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.r(WalletOfflineCoinPurseUI.this).isShowing()))
          {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213639);
            return;
          }
          l = System.currentTimeMillis();
          if (((WalletOfflineCoinPurseUI.r(WalletOfflineCoinPurseUI.this) == null) || (!WalletOfflineCoinPurseUI.r(WalletOfflineCoinPurseUI.this).isShowing())) && (l - WalletOfflineCoinPurseUI.s(WalletOfflineCoinPurseUI.this) >= 400L) && (com.tencent.mm.plugin.offline.c.a.eAj()) && (!WalletOfflineCoinPurseUI.t(WalletOfflineCoinPurseUI.this)))
          {
            if (paramAnonymousView.getId() != 2131310288) {
              break label260;
            }
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, false);
          }
        }
        for (;;)
        {
          if (WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.v(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this).aa(paramAnonymousView, WalletOfflineCoinPurseUI.w(WalletOfflineCoinPurseUI.this));
          }
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, l);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213639);
          return;
          label260:
          if ((paramAnonymousView.getId() == 2131310153) || (paramAnonymousView.getId() == 2131310154))
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(13958, new Object[] { Integer.valueOf(4) });
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, true);
          }
        }
      }
    };
    this.AMq = false;
    this.yNN = new HashMap();
    this.AIM = 60000;
    this.AIN = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(213661);
        if (!WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this))
        {
          WalletOfflineCoinPurseUI.E(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.F(WalletOfflineCoinPurseUI.this);
        }
        WalletOfflineCoinPurseUI.S(WalletOfflineCoinPurseUI.this).startTimer(WalletOfflineCoinPurseUI.R(WalletOfflineCoinPurseUI.this));
        AppMethodBeat.o(213661);
        return false;
      }
    }, false);
    this.AMr = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(213662);
        WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this);
        if ((WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this).isShowing())) {
          WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this).dismiss();
        }
        com.tencent.mm.plugin.offline.g.ezi();
        WalletOfflineCoinPurseUI.U(WalletOfflineCoinPurseUI.this);
        if (com.tencent.mm.plugin.offline.c.a.eAL()) {
          WalletOfflineCoinPurseUI.this.ezz();
        }
        AppMethodBeat.o(213662);
        return false;
      }
    }, false);
    this.AMs = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(213663);
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this)) });
        if (WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this))
        {
          cm localcm = new cm();
          localcm.dFH.resultCode = 0;
          EventCenter.instance.publish(localcm);
        }
        WalletOfflineCoinPurseUI.this.finish();
        AppMethodBeat.o(213663);
        return false;
      }
    }, false);
    this.AJa = new IListener() {};
    AppMethodBeat.o(66468);
  }
  
  private void TZ(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(66490);
    if (!com.tencent.mm.plugin.offline.c.a.eAj())
    {
      Log.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
      AppMethodBeat.o(66490);
      return;
    }
    com.tencent.mm.plugin.offline.k.ezn();
    Object localObject = com.tencent.mm.plugin.offline.k.ezp().A(this.mEntryScene, paramInt, this.ALh);
    this.AII = ((String)localObject);
    this.ALA = ((String)localObject);
    Log.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[] { Integer.valueOf(paramInt), this.AII, this.ALA, Util.getStack().toString() });
    cAu();
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.mm.plugin.report.service.h.CyF;
      if (com.tencent.mm.plugin.offline.c.a.isAppOnForeground(MMApplicationContext.getContext())) {}
      for (paramInt = 0;; paramInt = 1)
      {
        if (NetStatusUtil.isNetworkConnected(getBaseContext())) {
          i = 1;
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).a(14163, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 26L, 1L, true);
        if (!NetStatusUtil.isNetworkConnected(getBaseContext())) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 28L, 1L, true);
        AppMethodBeat.o(66490);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 27L, 1L, true);
    }
    AppMethodBeat.o(66490);
  }
  
  private static void Ua(int paramInt)
  {
    AppMethodBeat.i(66509);
    ag localag = new ag();
    localag.enW = paramInt;
    localag.bfK();
    AppMethodBeat.o(66509);
  }
  
  private void a(Bankcard paramBankcard)
  {
    AppMethodBeat.i(213669);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(213669);
      return;
    }
    paramBankcard = paramBankcard.field_bindSerial;
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doSelectBackcard tempSerial:%s，mBindSerial：%s", new Object[] { paramBankcard, this.AIf });
    if ((!TextUtils.isEmpty(paramBankcard)) && (!paramBankcard.equals(this.AIf)))
    {
      this.ALc = this.AIf;
      this.AIf = paramBankcard;
      com.tencent.mm.plugin.offline.c.a.aJk(this.AIf);
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.ezp().AIf = this.AIf;
      ezO();
      TZ(0);
      sy(true);
    }
    AppMethodBeat.o(213669);
  }
  
  private void ab(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66480);
    if (com.tencent.mm.plugin.offline.c.a.sB(true).size() > 0)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
      ezP();
      ezO();
      this.ALi.setVisibility(0);
    }
    for (;;)
    {
      if (paramBoolean1) {
        TZ(0);
      }
      sy(paramBoolean2);
      cvL();
      ezG();
      AppMethodBeat.o(66480);
      return;
      this.ALi.setVisibility(0);
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
    }
  }
  
  private static int argbColor(long paramLong)
  {
    AppMethodBeat.i(213670);
    int i = Color.argb((int)(paramLong >> 24 & 0xFF), (int)(paramLong >> 16 & 0xFF), (int)(paramLong >> 8 & 0xFF), (int)(0xFF & paramLong));
    AppMethodBeat.o(213670);
    return i;
  }
  
  private void b(Bankcard paramBankcard)
  {
    AppMethodBeat.i(66511);
    if (TextUtils.isEmpty(this.AIf))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
      AppMethodBeat.o(66511);
      return;
    }
    this.ALk.setEnableColorFilter(false);
    if (paramBankcard.fQf())
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
      this.ALk.setImageDrawable(com.tencent.mm.svg.a.a.h(getContext().getResources(), 2131690395));
      AppMethodBeat.o(66511);
      return;
    }
    String str2 = com.tencent.mm.plugin.offline.c.a.aJr(this.AIf);
    String str1 = str2;
    if (paramBankcard.fQc())
    {
      str1 = str2;
      if (paramBankcard.HVM != null) {
        str1 = paramBankcard.HVM.AAU;
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
      AppMethodBeat.o(66511);
      return;
    }
    e(this.ALk, str1, getResources().getDimensionPixelOffset(2131167138));
    AppMethodBeat.o(66511);
  }
  
  private void cAu()
  {
    AppMethodBeat.i(66516);
    bf localbf = com.tencent.mm.plugin.wallet_core.model.k.fQy();
    Object localObject = new StringBuilder().append(this.ALA);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf();
    localObject = MD5Util.getMD5String(com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin()));
    if (localbf != null) {
      com.tencent.mm.plugin.report.service.h.CyF.a(13444, new Object[] { localbf.KED, localbf.KEE, Long.valueOf(localbf.KEC), localObject, localbf.KEF, localbf.KEG, localbf.KEH });
    }
    AppMethodBeat.o(66516);
  }
  
  private void cvL()
  {
    AppMethodBeat.i(66479);
    if (com.tencent.mm.plugin.offline.c.a.eAj())
    {
      this.ALl.setVisibility(0);
      AppMethodBeat.o(66479);
      return;
    }
    this.ALl.setVisibility(4);
    AppMethodBeat.o(66479);
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
      paramImageView.setImageBitmap(BitmapUtil.extractThumbNail(localBitmap, paramInt, paramInt, true, false));
    }
    this.AKR.put(paramString, paramImageView);
    this.AKS.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(66495);
  }
  
  private void eAa()
  {
    AppMethodBeat.i(213671);
    List localList = com.tencent.mm.plugin.offline.c.a.sB(false);
    if (localList.size() <= 0)
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      AppMethodBeat.o(213671);
      return;
    }
    int i = 0;
    while (i < localList.size())
    {
      Bankcard localBankcard = (Bankcard)localList.get(i);
      if ((!Util.isNullOrNil(localBankcard.field_bindSerial)) && (this.ALb.equals(localBankcard.field_bindSerial)))
      {
        a(localBankcard);
        this.ALb = "";
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "find the mBindSerialOperation");
      }
      i += 1;
    }
    if (this.AMf == null)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mJsApiOfflineUserBindQueryResultCallBackEventEvent == null");
      AppMethodBeat.o(213671);
      return;
    }
    if (!Util.isNullOrNil(this.ALb)) {}
    for (this.AMf.dQh.errMsg = "fail:no find operation bindSerial";; this.AMf.dQh.errMsg = "ok:open success")
    {
      this.AMf.dQg.callback.run();
      this.AMf = null;
      this.ALb = "";
      AppMethodBeat.o(213671);
      return;
    }
  }
  
  private static boolean eAb()
  {
    AppMethodBeat.i(213672);
    com.tencent.mm.kernel.g.aAi();
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTC, Integer.valueOf(1))).intValue();
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "fqfCardSettingState is :%s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      AppMethodBeat.o(213672);
      return false;
    case 0: 
    case 1: 
      AppMethodBeat.o(213672);
      return false;
    }
    AppMethodBeat.o(213672);
    return true;
  }
  
  private static boolean eAc()
  {
    AppMethodBeat.i(213673);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.eAm();
    if ((localBankcard != null) && (localBankcard.fQg()))
    {
      AppMethodBeat.o(213673);
      return true;
    }
    AppMethodBeat.o(213673);
    return false;
  }
  
  private void eeP()
  {
    AppMethodBeat.i(66484);
    Bitmap localBitmap = this.AKT;
    this.AKT = ezM();
    this.ALe.setImageBitmap(this.AKT);
    this.ALP.add(0, localBitmap);
    AppMethodBeat.o(66484);
  }
  
  private void ezD()
  {
    AppMethodBeat.i(66470);
    ezS();
    ezY();
    ezT();
    ezQ();
    ezW();
    AppMethodBeat.o(66470);
  }
  
  private void ezE()
  {
    AppMethodBeat.i(66472);
    com.tencent.mm.wallet_core.ui.f.aqm(32);
    com.tencent.mm.pluginsdk.wallet.f.aD(this, this.sQn);
    AppMethodBeat.o(66472);
  }
  
  private void ezF()
  {
    AppMethodBeat.i(66478);
    final cul localcul = com.tencent.mm.plugin.wallet_core.model.t.fQI().IbR;
    if (localcul == null)
    {
      this.ALm.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    Object localObject;
    if (localcul.HFS == ai.a.Ibs.value)
    {
      if (localcul.MzF == null)
      {
        Log.e("MicroMsg.WalletOfflineCoinPurseUI", "offlineGuideBar.guide_data == null");
        this.ALm.setVisibility(8);
        AppMethodBeat.o(66478);
        return;
      }
      localObject = localcul.MzF.ANo;
      if (com.tencent.mm.plugin.wallet_core.model.t.fQI().l((String)localObject, false, false) == null)
      {
        Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar bindSerial(%s) is null bankcard!", new Object[] { Util.nullAs((String)localObject, "") });
        this.ALm.setVisibility(8);
        AppMethodBeat.o(66478);
        return;
      }
      localObject = com.tencent.mm.plugin.offline.c.a.eAm();
      if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (Util.isEqual(localcul.MzF.ANo, ((Bankcard)localObject).field_bindSerial)))
      {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar defaultBankcard(%s) == bindSerial(%s)", new Object[] { ((Bankcard)localObject).field_bindSerial, localcul.MzF.ANo });
        this.ALm.setVisibility(8);
        AppMethodBeat.o(66478);
        return;
      }
    }
    if ((this.ALm.isShown()) && (this.ALm.getTag() != null) && ((this.ALm.getTag() instanceof cul)) && (Util.isEqual((cul)this.ALm.getTag(), localcul)))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "");
      AppMethodBeat.o(66478);
      return;
    }
    if (localcul.HEc == 0)
    {
      this.ALm.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if (!this.ALG)
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "isShowGuideBar == false");
      AppMethodBeat.o(66478);
      return;
    }
    int i = this.ALm.getVisibility();
    this.ALm.setTag(localcul);
    this.ALm.setVisibility(0);
    final int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 20.0F);
    this.ALn.s(localcul.HEj, j, j, -1);
    this.ALo.setText(localcul.HEe);
    this.ALp.setText(localcul.HEg);
    com.tencent.mm.ui.ao.a(this.ALp.getPaint(), 0.8F);
    if (localcul.HFS == ai.a.Ibs.value)
    {
      if ((!Util.isNullOrNil(localcul.LFY)) && (this.ALm.getBackground() != null)) {
        this.ALm.getBackground().setColorFilter(Color.parseColor(localcul.LFY), PorterDuff.Mode.SRC);
      }
      this.ALo.setTextColor(Color.parseColor(localcul.HEf));
      this.ALp.setTextColor(Color.parseColor(localcul.HEh));
      this.ALp.setTag(localcul.MzF.ANo);
      this.ALp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213640);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          WalletOfflineCoinPurseUI.Ub(2);
          String str = "";
          localObject = str;
          if (paramAnonymousView.getTag() != null)
          {
            localObject = str;
            if ((paramAnonymousView.getTag() instanceof String)) {
              localObject = (String)paramAnonymousView.getTag();
            }
          }
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mOfflineGuideButtonTv click! bindSerial:%s", new Object[] { localObject });
          if (Util.isNullOrNil((String)localObject))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213640);
            return;
          }
          WalletOfflineCoinPurseUI.x(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.y(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.t.fQI().aVm((String)localObject);
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213640);
        }
      });
      Ua(1);
      this.ALO = true;
    }
    for (;;)
    {
      if ((i == 8) && (this.ALT.isShowing()))
      {
        ezQ();
        if ((!this.ALD) && (this.ALT.TY(4)))
        {
          com.tencent.mm.kernel.g.aAi();
          if (!((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NYK, Boolean.FALSE)).booleanValue()) {
            ezR();
          }
        }
      }
      AppMethodBeat.o(66478);
      return;
      if (localcul.HFS == ai.a.Ibt.value)
      {
        if ((!Util.isNullOrNil(localcul.LFY)) && (this.ALm.getBackground() != null)) {
          this.ALm.getBackground().setColorFilter(argbColor(Long.parseLong(localcul.LFY.substring(2), 16)), PorterDuff.Mode.SRC);
        }
        this.ALo.setTextColor(argbColor(Long.parseLong(localcul.HEf.substring(2), 16)));
        this.ALp.setTextColor(argbColor(Long.parseLong(localcul.HEh.substring(2), 16)));
        if (!Util.isNullOrNil(localcul.HEi))
        {
          localObject = (LinearLayout.LayoutParams)this.ALp.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
          this.ALp.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.ALp.setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 12), com.tencent.mm.cb.a.fromDPToPix(getContext(), 4), com.tencent.mm.cb.a.fromDPToPix(getContext(), 12), com.tencent.mm.cb.a.fromDPToPix(getContext(), 4));
          j = argbColor(Long.parseLong(localcul.HEi.substring(2), 16));
          this.ALp.setBackgroundDrawable(getContext().getResources().getDrawable(2131235682));
          ((GradientDrawable)this.ALp.getBackground()).setColor(j);
          this.ALp.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(213641);
              if (paramAnonymousMotionEvent.getAction() == 0) {
                WalletOfflineCoinPurseUI.z(WalletOfflineCoinPurseUI.this).setBackgroundDrawable(WalletOfflineCoinPurseUI.this.getContext().getResources().getDrawable(2131235681));
              }
              for (;;)
              {
                AppMethodBeat.o(213641);
                return false;
                if (paramAnonymousMotionEvent.getAction() == 1)
                {
                  WalletOfflineCoinPurseUI.z(WalletOfflineCoinPurseUI.this).setBackgroundDrawable(WalletOfflineCoinPurseUI.this.getContext().getResources().getDrawable(2131235682));
                  ((GradientDrawable)WalletOfflineCoinPurseUI.z(WalletOfflineCoinPurseUI.this).getBackground()).setColor(j);
                }
              }
            }
          });
        }
        this.ALp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213642);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            WalletOfflineCoinPurseUI.A(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.Ub(5);
            switch (localcul.MzI)
            {
            default: 
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown entrance type");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213642);
              return;
              com.tencent.mm.wallet_core.ui.f.p(WalletOfflineCoinPurseUI.this.getContext(), localcul.MzJ, false);
              continue;
              com.tencent.mm.wallet_core.ui.f.u(localcul.MzK, localcul.MzL, 0, 1137);
            }
          }
        });
        Ua(4);
        this.ALO = false;
      }
    }
  }
  
  private void ezG()
  {
    AppMethodBeat.i(66481);
    if ((!this.AMq) && (!NetStatusUtil.isNetworkConnected(getBaseContext())))
    {
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.ezp();
      if (com.tencent.mm.plugin.offline.e.ezf() == 0)
      {
        this.AMq = true;
        b.ax(this);
        Log.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
      }
    }
    AppMethodBeat.o(66481);
  }
  
  private void ezH()
  {
    AppMethodBeat.i(66482);
    int i = com.tencent.mm.plugin.offline.c.a.eAp();
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.sA(false);
    if (c.ezB())
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
    if (com.tencent.mm.plugin.offline.c.a.eAj())
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
  
  private boolean ezI()
  {
    return (this.mState == 2) || (this.mState == 1) || (this.mState == 7);
  }
  
  private void ezJ()
  {
    AppMethodBeat.i(66485);
    Bitmap localBitmap = this.AKU;
    this.AKU = ezL();
    this.ALf.setImageBitmap(this.AKU);
    if (ezI()) {
      this.ALf.setAlpha(10);
    }
    for (;;)
    {
      this.ALQ.add(0, localBitmap);
      AppMethodBeat.o(66485);
      return;
      this.ALf.setAlpha(255);
    }
  }
  
  private void ezK()
  {
    AppMethodBeat.i(66486);
    if (this.ALR != null)
    {
      this.ALR.nC(this.ALA, this.AII);
      this.ALR.AKT = this.AKT;
      this.ALR.AKU = this.AKU;
      this.ALR.hhQ();
    }
    AppMethodBeat.o(66486);
  }
  
  private Bitmap ezL()
  {
    AppMethodBeat.i(66488);
    if (TextUtils.isEmpty(this.AII))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
      AppMethodBeat.o(66488);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.by.a.a.a(this, this.AII, 5, 0, 0.0D);
    AppMethodBeat.o(66488);
    return localBitmap;
  }
  
  private Bitmap ezM()
  {
    AppMethodBeat.i(66489);
    if (TextUtils.isEmpty(this.ALA))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
      AppMethodBeat.o(66489);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.by.a.a.a(this, this.ALA, 12, 3, 0.0D);
    AppMethodBeat.o(66489);
    return localBitmap;
  }
  
  private void ezN()
  {
    AppMethodBeat.i(66493);
    if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
      this.mTipDialog.dismiss();
    }
    AppMethodBeat.o(66493);
  }
  
  private void ezP()
  {
    AppMethodBeat.i(66499);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.eAm();
    if (localBankcard != null)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard：%s", new Object[] { localBankcard.field_bindSerial });
      com.tencent.mm.plugin.offline.c.a.aJk(localBankcard.field_bindSerial);
      this.AIf = localBankcard.field_bindSerial;
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.ezp().AIf = this.AIf;
      AppMethodBeat.o(66499);
      return;
    }
    Log.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
    AppMethodBeat.o(66499);
  }
  
  private void ezQ()
  {
    AppMethodBeat.i(66500);
    if (this.ALD)
    {
      AppMethodBeat.o(66500);
      return;
    }
    if (!this.ALT.TY(4))
    {
      AppMethodBeat.o(66500);
      return;
    }
    com.tencent.mm.kernel.g.aAi();
    if ((!((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NYK, Boolean.FALSE)).booleanValue()) && (!this.ALT.isShowing())) {
      ezR();
    }
    AppMethodBeat.o(66500);
  }
  
  private void ezR()
  {
    AppMethodBeat.i(66501);
    if (!this.ALT.TY(4))
    {
      AppMethodBeat.o(66501);
      return;
    }
    this.ALT.eE(this.ALd);
    AppMethodBeat.o(66501);
  }
  
  private void ezS()
  {
    AppMethodBeat.i(66502);
    if (!this.ALT.TY(1))
    {
      AppMethodBeat.o(66502);
      return;
    }
    if (this.ALT.AKt == 1) {
      this.ALT.dismiss();
    }
    boolean bool1 = com.tencent.mm.plugin.wallet_core.model.t.fQI().fRm();
    boolean bool2 = com.tencent.mm.plugin.wallet_core.model.t.fQI().fRl();
    if ((bool1) || (bool2))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.ALT.a(this.ALd, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184855);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.offline.c.a.eAw();
          com.tencent.mm.plugin.offline.k.ezn();
          com.tencent.mm.plugin.offline.k.bN(196648, "0");
          WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(184855);
        }
      }, 1);
    }
    AppMethodBeat.o(66502);
  }
  
  private void ezT()
  {
    AppMethodBeat.i(66503);
    if (!this.ALT.TY(3))
    {
      AppMethodBeat.o(66503);
      return;
    }
    if (this.ALT.AKt == 3) {
      this.ALT.dismiss();
    }
    com.tencent.mm.plugin.offline.k.ezn();
    String str1 = com.tencent.mm.plugin.offline.k.TX(196617);
    com.tencent.mm.wallet_core.c.b.hhj();
    boolean bool1 = com.tencent.mm.wallet_core.c.b.isCertExist(str1);
    boolean bool2 = com.tencent.mm.plugin.offline.c.a.eAj();
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) || (!bool2)) {
      if (!bool1)
      {
        com.tencent.mm.kernel.g.aAi();
        String str2 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NSn, "");
        if ((str2 == null) || (!str2.equals(com.tencent.mm.compatible.deviceinfo.q.dr(true)))) {
          break label222;
        }
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + str1 + " ,recreate offline");
      com.tencent.mm.plugin.offline.c.a.eAw();
      this.ALl.setVisibility(4);
      this.ALT.a(this.ALd, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213650);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.offline.c.a.j(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this));
          WalletOfflineCoinPurseUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213650);
        }
      }, 3);
      AppMethodBeat.o(66503);
      return;
      label222:
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
    }
  }
  
  private void ezU()
  {
    AppMethodBeat.i(66504);
    if (!this.ALT.TY(5))
    {
      AppMethodBeat.o(66504);
      return;
    }
    if (this.ALT.AKt == 5) {
      this.ALT.dismiss();
    }
    this.ALT.b(this.ALd, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213651);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.offline.k.ezn();
        com.tencent.mm.plugin.offline.k.ezq();
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.i.ezm()) });
        com.tencent.mm.plugin.offline.k.ezn();
        com.tencent.mm.plugin.offline.k.ezq();
        if (com.tencent.mm.plugin.offline.i.ezm() <= 0)
        {
          paramAnonymousView = new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 10);
          WalletOfflineCoinPurseUI.this.doSceneForceProgress(paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213651);
          return;
          WalletOfflineCoinPurseUI.L(WalletOfflineCoinPurseUI.this);
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 73L, 1L, true);
    AppMethodBeat.o(66504);
  }
  
  private void ezW()
  {
    AppMethodBeat.i(213668);
    if ((this.AMc == null) || (!this.AMc.pTt))
    {
      if (this.ALT.AKt == 8) {
        this.ALT.dismiss();
      }
      AppMethodBeat.o(213668);
      return;
    }
    if (!this.ALT.TY(8))
    {
      AppMethodBeat.o(213668);
      return;
    }
    if (this.ALT.AKt == 8) {
      this.ALT.dismiss();
    }
    this.ALT.a(this.ALd, this.AMc);
    com.tencent.mm.plugin.report.service.h.CyF.a(20258, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(213668);
  }
  
  private void ezX()
  {
    AppMethodBeat.i(66506);
    if ((this.ALT.isShowing()) && (this.ALT.AKt == 5)) {
      this.ALT.dismiss();
    }
    AppMethodBeat.o(66506);
  }
  
  private boolean ezY()
  {
    AppMethodBeat.i(66507);
    if (!this.ALT.TY(2))
    {
      AppMethodBeat.o(66507);
      return false;
    }
    if (this.ALT.AKt == 2) {
      this.ALT.dismiss();
    }
    List localList = com.tencent.mm.plugin.offline.c.a.eAq();
    if (localList.size() <= 0)
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
    this.ALT.dismiss();
    this.ALT.a(this.ALd, new Runnable()new WalletOfflineCoinPurseUI.31
    {
      public final void run()
      {
        AppMethodBeat.i(213654);
        if (WalletOfflineCoinPurseUI.I(WalletOfflineCoinPurseUI.this)) {
          com.tencent.mm.plugin.offline.c.a.a(WalletOfflineCoinPurseUI.this, 20000, -1, WalletOfflineCoinPurseUI.this.getInput());
        }
        for (;;)
        {
          WalletOfflineCoinPurseUI.J(WalletOfflineCoinPurseUI.this);
          AppMethodBeat.o(213654);
          return;
          c localc = WalletOfflineCoinPurseUI.B(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.offline.c.a.i(localc.mActivity, localc.AKK);
        }
      }
    }, new WalletOfflineCoinPurseUI.31(this));
    AppMethodBeat.o(66507);
    return false;
  }
  
  private static void ezZ()
  {
    AppMethodBeat.i(66510);
    if (!com.tencent.mm.plugin.offline.c.a.eAD())
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.ezq().hE(3, 3);
    }
    AppMethodBeat.o(66510);
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(66487);
    int i;
    if (this.ALP.size() >= 2)
    {
      i = this.ALP.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.f.Z((Bitmap)this.ALP.remove(i));
        i -= 1;
      }
    }
    if (this.ALQ.size() >= 2)
    {
      i = this.ALQ.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.f.Z((Bitmap)this.ALQ.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(66487);
  }
  
  private void sy(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(66483);
    long l = System.currentTimeMillis();
    int i;
    if ((paramBoolean) && ((Util.isNullOrNil(this.ALA)) || (Util.isNullOrNil(this.AII))))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
      ezU();
      eeP();
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - l));
      ezJ();
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - l));
      recycleBmpList();
      ezK();
      ezF();
      ab.mg(10, 0);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
      if (!com.tencent.mm.plugin.offline.c.a.isAppOnForeground(MMApplicationContext.getContext())) {
        break label281;
      }
      i = 0;
      label148:
      if (NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
        j = 1;
      }
      com.tencent.mm.plugin.offline.k.ezn();
      com.tencent.mm.plugin.offline.k.ezp();
      localh.a(14163, new Object[] { Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(com.tencent.mm.plugin.offline.e.ezf()) });
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 67L, 1L, true);
      if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
        break label286;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 32L, 1L, true);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.offline.c.a.isAppOnForeground(this)) {
        break label303;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 34L, 1L, true);
      AppMethodBeat.o(66483);
      return;
      ezX();
      break;
      label281:
      i = 1;
      break label148;
      label286:
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 33L, 1L, true);
    }
    label303:
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 35L, 1L, true);
    AppMethodBeat.o(66483);
  }
  
  private void sz(boolean paramBoolean)
  {
    AppMethodBeat.i(66508);
    if (!com.tencent.mm.plugin.offline.c.a.eAj())
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.eAj()) });
      AppMethodBeat.o(66508);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.sB(false).size() <= 0)
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      this.ALj.setVisibility(8);
      AppMethodBeat.o(66508);
      return;
    }
    final ArrayList localArrayList = af.yh(true);
    int i;
    Object localObject;
    int j;
    if ((paramBoolean) && (this.ALJ == null))
    {
      this.ALJ = new com.tencent.mm.plugin.wallet.ui.a(this);
      this.ALI = -1;
      this.ALJ.qAx.bMo();
      i = 0;
      localObject = null;
      j = 0;
      label129:
      if (i >= localArrayList.size()) {
        break label212;
      }
      Bankcard localBankcard = (Bankcard)localArrayList.get(i);
      if ((Util.isNullOrNil(localBankcard.field_bindSerial)) || (!this.AIf.equals(localBankcard.field_bindSerial))) {
        break label400;
      }
      j = i;
      localObject = localBankcard;
    }
    label400:
    for (;;)
    {
      i += 1;
      break label129;
      this.ALJ = null;
      this.ALJ = new com.tencent.mm.plugin.wallet.ui.a(this);
      break;
      label212:
      if (localObject != null)
      {
        localArrayList.remove(localObject);
        localArrayList.add(0, localObject);
        j = 0;
      }
      this.ALJ.HLX = new o.f()
      {
        public final void onCreateMMMenu(final com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(213658);
          paramAnonymousm.clear();
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
            localObject1 = com.tencent.mm.plugin.offline.c.a.aJq(localBankcard.field_bankcardType);
            localObject3 = localObject1;
            if (localBankcard.fQc())
            {
              localObject3 = localObject1;
              if (localBankcard.HVM != null) {
                localObject3 = localBankcard.HVM.AAU;
              }
            }
            localBitmap = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject3));
            u.a(new u.a()
            {
              public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(213656);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(66427);
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletOfflineCoinPurseUI.32.1.this.AMF });
                    if (WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).containsKey(paramAnonymous2String))
                    {
                      int i = ((Integer)WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).get(paramAnonymous2String)).intValue();
                      if (WalletOfflineCoinPurseUI.32.1.this.yNV.getItem(i) != null)
                      {
                        WalletOfflineCoinPurseUI.32.1.this.yNV.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(paramAnonymous2Bitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167138), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167138), true, false)));
                        if ((WalletOfflineCoinPurseUI.this.isFinishing()) || (WalletOfflineCoinPurseUI.this.isDestroyed()))
                        {
                          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineCoinPurseUI.this.isFinishing() || WalletOfflineCoinPurseUI.this.isDestroyed()：%s，%s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.this.isFinishing()), Boolean.valueOf(WalletOfflineCoinPurseUI.this.isDestroyed()) });
                          AppMethodBeat.o(66427);
                          return;
                        }
                        WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this).fPw();
                      }
                    }
                    AppMethodBeat.o(66427);
                  }
                });
                AppMethodBeat.o(213656);
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
                  break label539;
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
                break label817;
              }
              localObject1 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
              if ((!Util.isNullOrNil(localBankcard.field_prompt_info_jump_text)) && (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_url)))
              {
                ((SpannableStringBuilder)localObject1).append(localBankcard.field_prompt_info_jump_text);
                ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
                {
                  public final void dF(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(213657);
                    com.tencent.mm.wallet_core.ui.f.bn(WalletOfflineCoinPurseUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
                    com.tencent.mm.plugin.report.service.h.CyF.a(20216, new Object[] { Integer.valueOf(3), localBankcard.field_prompt_info_jump_url });
                    AppMethodBeat.o(213657);
                  }
                }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject1).length(), 33);
              }
            }
          }
          label386:
          label411:
          label817:
          for (;;)
          {
            String str;
            if (((localBankcard.fQb()) || (localBankcard.fQc())) && (localBankcard.HVC >= 0.0D))
            {
              str = localBankcard.field_desc + WalletOfflineCoinPurseUI.this.getString(2131767442, new Object[] { com.tencent.mm.wallet_core.ui.f.D(localBankcard.HVC) });
              localObject2 = null;
              if (!localBankcard.fQf()) {
                break label696;
              }
              localObject2 = com.tencent.mm.svg.a.a.h(WalletOfflineCoinPurseUI.this.getResources(), 2131690395);
              if (localObject2 == null) {
                WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this).put(localObject3, Integer.valueOf(i));
              }
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str, localObject1 });
              if (!localBankcard.fQg()) {
                break label762;
              }
              localObject3 = com.tencent.mm.pluginsdk.ui.span.l.c(WalletOfflineCoinPurseUI.this.getContext(), str);
              if (Util.isNullOrNil((String)localObject4))
              {
                if (!Util.isNullOrNil(localBankcard.HWa)) {
                  break label746;
                }
                localObject1 = "";
              }
              label506:
              if (Util.isNullOrNil((String)localObject4)) {
                break label756;
              }
            }
            label696:
            label746:
            label756:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousm.a(i, (CharSequence)localObject3, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
              i += 1;
              break;
              localObject1 = localBankcard.field_no_micro_word;
              break label180;
              localObject4 = (String)localObject1 + " ";
              localObject1 = new SpannableStringBuilder((String)localObject4 + localBankcard.field_forbid_title);
              localObject2 = new com.tencent.mm.plugin.wallet_core.ui.l(WalletOfflineCoinPurseUI.this)
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(66429);
                  paramAnonymous2View = localBankcard.field_forbid_url;
                  if ((localBankcard.fQg()) && (Util.isNullOrNil(paramAnonymous2View)))
                  {
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand");
                    paramAnonymous2View = new wq();
                    paramAnonymous2View.ecI.userName = localBankcard.Hwr;
                    paramAnonymous2View.ecI.ecK = localBankcard.Hws;
                    paramAnonymous2View.ecI.scene = 1137;
                    paramAnonymous2View.ecI.ecL = 0;
                    EventCenter.instance.publish(paramAnonymous2View);
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand result:%s", new Object[] { Boolean.valueOf(paramAnonymous2View.ecJ.edc) });
                    if (paramAnonymous2View.ecJ.edc)
                    {
                      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 1);
                      WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this).qAx.bMo();
                      AppMethodBeat.o(66429);
                      return;
                    }
                    WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 0);
                    AppMethodBeat.o(66429);
                    return;
                  }
                  Intent localIntent = new Intent();
                  Log.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", new Object[] { paramAnonymous2View });
                  localIntent.putExtra("rawUrl", paramAnonymous2View);
                  localIntent.putExtra("geta8key_username", z.aTY());
                  localIntent.putExtra("pay_channel", 1);
                  com.tencent.mm.wallet_core.ui.f.aA(WalletOfflineCoinPurseUI.this.getContext(), localIntent);
                  AppMethodBeat.o(66429);
                }
              };
              int j = ((String)localObject4).length();
              int k = ((String)localObject4).length() + localBankcard.field_forbid_title.length();
              ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(WalletOfflineCoinPurseUI.this.getResources().getColor(2131101373)), j, k, 33);
              ((SpannableStringBuilder)localObject1).setSpan(localObject2, j, k, 33);
              break label210;
              str = localBankcard.field_desc;
              break label386;
              if (localBitmap == null) {
                break label411;
              }
              localObject2 = new BitmapDrawable(BitmapUtil.extractThumbNail(localBitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167138), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(2131167138), true, false));
              break label411;
              localObject1 = localBankcard.HWa;
              break label506;
            }
            label762:
            localObject3 = com.tencent.mm.pluginsdk.ui.span.l.c(WalletOfflineCoinPurseUI.this.getContext(), str);
            if (!Util.isNullOrNil((String)localObject4)) {}
            for (bool = true;; bool = false)
            {
              paramAnonymousm.a(i, (CharSequence)localObject3, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
              break;
            }
            AppMethodBeat.o(213658);
            return;
          }
        }
      };
      this.ALJ.a(new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(213659);
          if (WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this).qAx.bMo();
            Bankcard localBankcard = (Bankcard)localArrayList.get(WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this).jKz);
            com.tencent.mm.plugin.report.service.h.CyF.a(14515, new Object[] { Integer.valueOf(3) });
            if ((!Util.isNullOrNil(localBankcard.field_forbid_title)) || (!Util.isNullOrNil(localBankcard.field_forbidWord)) || (!localBankcard.field_support_micropay)) {
              com.tencent.mm.plugin.report.service.h.CyF.a(14515, new Object[] { Integer.valueOf(4) });
            }
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click mmBottomSheet card：%s", new Object[] { localBankcard.field_bindSerial });
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, localBankcard);
            if ((localBankcard != null) && (localBankcard.fQg()))
            {
              WalletOfflineCoinPurseUI.x(WalletOfflineCoinPurseUI.this);
              WalletOfflineCoinPurseUI.Ub(3);
            }
          }
          AppMethodBeat.o(213659);
        }
      });
      localObject = View.inflate(this, 2131496965, null);
      com.tencent.mm.wallet_core.ui.f.G((TextView)((View)localObject).findViewById(2131305587));
      ((View)localObject).findViewById(2131305582).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213660);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this) != null) {
            WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this).qAx.bMo();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213660);
        }
      });
      this.ALJ.HMf = true;
      this.ALJ.T(getResources().getString(2131767686));
      this.ALJ.jKz = j;
      this.ALJ.HMg = true;
      this.ALJ.setTitleView((View)localObject);
      this.ALJ.dGm();
      com.tencent.mm.plugin.report.service.h.CyF.a(13955, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(66508);
      return;
    }
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(66491);
    if (paramc == null)
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
      AppMethodBeat.o(66491);
      return false;
    }
    ezN();
    this.ALR.dismiss();
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msgtype：%s，mBindSerial：%s", new Object[] { Integer.valueOf(paramc.AKh), this.AIf });
    int i;
    if (4 == paramc.AKh)
    {
      this.ALB = false;
      i = 0;
    }
    for (;;)
    {
      c localc = this.ALS;
      if (paramc == null) {
        Log.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
      }
      for (;;)
      {
        if ((this.ALE) && (!this.ALF))
        {
          this.ALE = false;
          this.ALB = false;
        }
        if (i != 0)
        {
          TZ(0);
          sy(true);
        }
        AppMethodBeat.o(66491);
        return true;
        if (5 == paramc.AKh)
        {
          this.ALB = true;
          this.ALE = true;
          this.ALF = false;
          if (this.AMr.stopped()) {
            break label432;
          }
          this.AMr.stopTimer();
          i = 0;
          break;
        }
        if (6 == paramc.AKh)
        {
          if (!this.AMr.stopped()) {
            this.AMr.stopTimer();
          }
          if (!this.AIN.stopped()) {
            this.AIN.stopTimer();
          }
          this.ALB = false;
          if (!com.tencent.mm.plugin.offline.c.a.eAk()) {
            break label1590;
          }
          i = 0;
          break;
        }
        if (8 == paramc.AKh)
        {
          if (this.AMr.stopped()) {
            break label1590;
          }
          this.AMr.stopTimer();
          i = 1;
          break;
        }
        if (23 == paramc.AKh)
        {
          if (this.AMr.stopped()) {
            break label432;
          }
          this.AMr.stopTimer();
          i = 0;
          break;
        }
        if (20 == paramc.AKh)
        {
          this.ALB = false;
          if (this.AMr.stopped()) {
            break label432;
          }
          this.AMr.stopTimer();
          i = 0;
          break;
        }
        if (24 != paramc.AKh) {
          break label1590;
        }
        if (com.tencent.mm.plugin.offline.c.a.eAL())
        {
          if (eAc())
          {
            if (!this.ALN) {
              break label437;
            }
            Ua(10);
          }
          label383:
          this.ALB = true;
          if (com.tencent.mm.plugin.offline.c.a.eAL())
          {
            if (this.mTipDialog != null) {
              break label460;
            }
            this.mTipDialog = com.tencent.mm.wallet_core.ui.h.a(getContext(), false, new WalletOfflineCoinPurseUI.19(this));
          }
        }
        for (;;)
        {
          this.AMr.startTimer(com.tencent.mm.plugin.offline.g.ezh());
          label432:
          i = 0;
          break;
          label437:
          if (this.ALO)
          {
            Ua(11);
            break label383;
          }
          Ua(12);
          break label383;
          label460:
          if (!this.mTipDialog.isShowing()) {
            this.mTipDialog.show();
          }
        }
        Log.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + paramc.AKh);
        if (paramc.AKh == 24) {
          localc.paT.vibrate(50L);
        }
        if (4 == paramc.AKh)
        {
          localc.a((s.b)paramc);
          com.tencent.mm.plugin.offline.g.ezi();
        }
        else
        {
          if (5 == paramc.AKh)
          {
            paramc = (s.e)paramc;
            if (paramc != null)
            {
              Log.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + paramc.AKk + " msg.wxRetMsg:" + paramc.AKl + " msg.cftRetCode:" + paramc.AKk + " msg.cftRetMsg:" + paramc.AKj);
              if ((!TextUtils.isEmpty(paramc.AKk)) || (!TextUtils.isEmpty(paramc.AKl)) || (!TextUtils.isEmpty(paramc.AKi)) || (!TextUtils.isEmpty(paramc.AKj)))
              {
                if ((!TextUtils.isEmpty(paramc.AKk)) || (!TextUtils.isEmpty(paramc.AKl)) || (TextUtils.isEmpty(paramc.AKi)) || (TextUtils.isEmpty(paramc.AKj))) {
                  break label741;
                }
                b.i(localc.mActivity, paramc.AKj);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.offline.g.ezi();
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 0L, 1L, true);
              break;
              label741:
              if ((!TextUtils.isEmpty(paramc.AKk)) && (com.tencent.mm.plugin.offline.c.a.isNumeric(paramc.AKk))) {
                localc.a(null, Util.getInt(paramc.AKk, 0), paramc.AKl, paramc.AKm);
              } else {
                b.i(localc.mActivity, paramc.AKl);
              }
            }
          }
          Object localObject1;
          if (6 == paramc.AKh)
          {
            paramc = (s.f)paramc;
            int j;
            if (paramc != null)
            {
              Log.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + paramc.AKo);
              com.tencent.mm.plugin.offline.k.ezn();
              localObject1 = com.tencent.mm.plugin.offline.k.ezr().aJe(paramc.AKp.dDL);
              if (localObject1 == null) {
                break label979;
              }
              if (((com.tencent.mm.plugin.offline.a.r)localObject1).field_status != com.tencent.mm.plugin.offline.g.AIt) {
                break label974;
              }
              j = 1;
            }
            for (;;)
            {
              if (j == 0)
              {
                com.tencent.mm.plugin.offline.g.eY(paramc.AKp.dDL, com.tencent.mm.plugin.offline.g.AIt);
                com.tencent.mm.plugin.offline.c.a.a(localc.mActivity, paramc);
                localc.mActivity.setResult(-1);
                localc.mActivity.finish();
              }
              com.tencent.mm.plugin.offline.g.ezi();
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 7L, 1L, true);
              if (com.tencent.mm.plugin.offline.c.a.ANf != 4) {
                break;
              }
              Log.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
              com.tencent.mm.plugin.report.service.h.CyF.a(13412, new Object[0]);
              break;
              label974:
              j = 0;
              continue;
              label979:
              j = 0;
            }
          }
          Object localObject2;
          Object localObject3;
          if (8 == paramc.AKh)
          {
            paramc = (s.g)paramc;
            Log.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + paramc.id);
            if (paramc.qGa == 0)
            {
              localObject1 = localc.mActivity.getLayoutInflater().inflate(2131496973, null);
              localObject2 = (TextView)((View)localObject1).findViewById(2131305807);
              localObject3 = (TextView)((View)localObject1).findViewById(2131305810);
              ((TextView)localObject2).setText(paramc.AKr);
              ((TextView)localObject3).setText(paramc.AKq);
              com.tencent.mm.plugin.offline.g.eY(paramc.dNQ, com.tencent.mm.plugin.offline.g.AIv);
              com.tencent.mm.ui.base.h.a(localc.mActivity, "", (View)localObject1, localc.getString(2131768425), localc.getString(2131755761), new c.11(localc, paramc), new c.12(localc, paramc));
            }
            else if (paramc.qGa == 1)
            {
              if (localc.AKI != null) {
                localc.AKI.show();
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(13955, new Object[] { Integer.valueOf(1) });
              Log.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + paramc.id);
              com.tencent.mm.plugin.offline.g.eY(paramc.dNQ, com.tencent.mm.plugin.offline.g.AIv);
              localc.AKI = com.tencent.mm.plugin.wallet_core.ui.s.a(localc.mActivity, paramc.AKq, paramc.AKr, new c.13(localc, paramc), new c.14(localc), new c.15(localc, paramc));
              localc.AKI.CKk.setVisibility(0);
              localc.AKI.CuI.setVisibility(8);
            }
          }
          else
          {
            if (23 == paramc.AKh)
            {
              paramc = (s.d)paramc;
              localObject1 = new PayInfo();
              ((PayInfo)localObject1).dDL = paramc.dNQ;
              ((PayInfo)localObject1).dVv = 8;
              ((PayInfo)localObject1).Kxz = 1;
              ((PayInfo)localObject1).iqp = new Bundle();
              ((PayInfo)localObject1).iqp.putLong("extinfo_key_9", System.currentTimeMillis());
              com.tencent.mm.wallet_core.b.hgC();
              boolean bool2 = com.tencent.mm.wallet_core.b.b(b.a.rWd, true);
              boolean bool1 = bool2;
              if (bool2)
              {
                com.tencent.mm.wallet_core.b.hgC();
                bool1 = com.tencent.mm.wallet_core.b.b(b.a.sab, false);
              }
              if (bool1)
              {
                localObject2 = (com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class);
                localObject3 = localc.mActivity;
                String str = ((PayInfo)localObject1).dDL;
                if (localc.AKH == null) {}
                for (paramc = "";; paramc = localc.AKH.ezy())
                {
                  ((com.tencent.mm.pluginsdk.wallet.a)localObject2).startOfflinePay((Context)localObject3, str, paramc, ((PayInfo)localObject1).channel);
                  break;
                }
              }
              paramc = new c.1(localc, (PayInfo)localObject1);
              EventCenter.instance.add(paramc);
              localObject2 = localc.mActivity;
              if (localc.AKH == null) {}
              for (paramc = "";; paramc = localc.AKH.ezy())
              {
                com.tencent.mm.pluginsdk.wallet.f.a((Context)localObject2, false, "", paramc, (PayInfo)localObject1, "", new Intent(), 1);
                break;
              }
            }
            if (20 == paramc.AKh) {
              com.tencent.mm.plugin.offline.g.ezi();
            }
          }
        }
      }
      label1590:
      i = 1;
    }
  }
  
  public void addDialog(Dialog paramDialog)
  {
    AppMethodBeat.i(66492);
    if (((paramDialog instanceof com.tencent.mm.ui.widget.a.d)) && (this.ALE))
    {
      this.ALF = true;
      paramDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(213644);
          if (this.AMC != null) {
            this.AMC.onDismiss(paramAnonymousDialogInterface);
          }
          if (WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this))
          {
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.D(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.E(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.F(WalletOfflineCoinPurseUI.this);
          }
          AppMethodBeat.o(213644);
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
  
  public final void ctk()
  {
    AppMethodBeat.i(66512);
    TZ(0);
    sy(true);
    AppMethodBeat.o(66512);
  }
  
  public final void ezO()
  {
    int j = 0;
    AppMethodBeat.i(66498);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.eAm();
    findViewById(2131310301).setVisibility(0);
    this.ALj.setTextSize(0, getResources().getDimensionPixelSize(2131165535));
    String str;
    Object localObject;
    if ((this.ALj != null) && (localBankcard != null)) {
      if (localBankcard.fQg())
      {
        str = localBankcard.HVY;
        localObject = com.tencent.mm.plugin.wallet_core.model.t.fQI().fRF();
        if ((localObject == null) || (Util.isNullOrNil(localBankcard.field_forbidWord))) {
          break label368;
        }
        Iterator localIterator = ((List)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (com.tencent.mm.plugin.wallet_core.model.c)localIterator.next();
        } while (!((com.tencent.mm.plugin.wallet_core.model.c)localObject).ANo.equals(localBankcard.field_bindSerial));
      }
    }
    for (;;)
    {
      if ((localObject != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.wallet_core.model.c)localObject).HVn)))
      {
        if (!localBankcard.fQg()) {
          str = localBankcard.field_desc + ((com.tencent.mm.plugin.wallet_core.model.c)localObject).HVn;
        }
        findViewById(2131310301).setVisibility(8);
        com.tencent.mm.plugin.report.service.h.CyF.a(14515, new Object[] { Integer.valueOf(2) });
        this.ALj.setTextSize(0, getResources().getDimensionPixelSize(2131165482));
      }
      for (int i = 1;; i = 0)
      {
        this.ALj.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), str, this.ALj.getTextSize()));
        for (;;)
        {
          if (localBankcard != null) {
            b(localBankcard);
          }
          if (i != 0)
          {
            this.ALk.setEnableColorFilter(true);
            this.ALk.setIconColor(Color.parseColor("#FA9D3B"));
            this.ALk.setImageResource(2131690547);
          }
          AppMethodBeat.o(66498);
          return;
          str = getString(2131768398, new Object[] { localBankcard.field_desc });
          break;
          i = j;
          if (localBankcard == null)
          {
            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
            i = j;
          }
        }
      }
      label368:
      localObject = null;
    }
  }
  
  public final void ezV()
  {
    AppMethodBeat.i(66505);
    this.ALl.setVisibility(4);
    this.ALT.a(this.ALd, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213652);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.offline.c.a.eAw();
        com.tencent.mm.plugin.offline.c.a.k(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this));
        WalletOfflineCoinPurseUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213652);
      }
    });
    AppMethodBeat.o(66505);
  }
  
  public final void ezw()
  {
    AppMethodBeat.i(66514);
    sz(false);
    AppMethodBeat.o(66514);
  }
  
  public final void ezx()
  {
    AppMethodBeat.i(66515);
    doSceneProgress(new j(""), false);
    AppMethodBeat.o(66515);
  }
  
  public final String ezy()
  {
    return this.AIf;
  }
  
  public final void ezz()
  {
    AppMethodBeat.i(66518);
    if (!this.AIN.stopped()) {
      this.AIN.stopTimer();
    }
    TZ(0);
    sy(true);
    this.ALB = false;
    this.AIN.startTimer(this.AIM);
    AppMethodBeat.o(66518);
  }
  
  public final void f(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66513);
    doSceneProgress(new com.tencent.mm.plugin.offline.a.e(paramInt, paramString1, paramString2, paramString3), com.tencent.mm.plugin.offline.c.a.eAk());
    AppMethodBeat.o(66513);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496967;
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
    this.ALT = ((OfflineAlertView)findViewById(2131305580));
    this.ALT.dismiss();
    this.ALT.setDialogState(new OfflineAlertView.a()
    {
      public final void onClose()
      {
        AppMethodBeat.i(213634);
        WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this);
        AppMethodBeat.o(213634);
      }
      
      public final void onShow()
      {
        AppMethodBeat.i(213635);
        WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this);
        AppMethodBeat.o(213635);
      }
    });
    com.tencent.mm.wallet_core.c.b.hhj().init(getApplicationContext());
    Object localObject;
    if ((this.mEntryScene == 3) || (this.mEntryScene == 10) || (this.mEntryScene == 11) || (this.mEntryScene == 12))
    {
      setMMTitle(2131768412);
      this.ALS = new c(this, this);
      localObject = this.ALS;
      ((c)localObject).paT = ((Vibrator)((c)localObject).mActivity.getSystemService("vibrator"));
      this.ALR = new com.tencent.mm.wallet_core.ui.c(this, true);
      this.ALR.hhP();
      this.ALd = findViewById(2131310289);
      this.ALe = ((ImageView)findViewById(2131310288));
      this.ALf = ((ImageView)findViewById(2131310153));
      this.ALg = ((TextView)findViewById(2131310154));
      this.ALi = findViewById(2131310300);
      this.ALj = ((TextView)findViewById(2131310302));
      this.ALk = ((WeImageView)findViewById(2131310299));
      this.ALl = ((RelativeLayout)findViewById(2131310224));
      this.ALm = ((LinearLayout)findViewById(2131310305));
      this.ALn = ((CdnImageView)findViewById(2131310306));
      this.ALo = ((TextView)findViewById(2131310304));
      this.ALp = ((TextView)findViewById(2131310303));
      this.ALi.post(new WalletOfflineCoinPurseUI.9(this));
      this.ALl.setOnClickListener(new WalletOfflineCoinPurseUI.10(this));
      this.ALe.setOnClickListener(this.kuO);
      this.ALf.setOnClickListener(this.kuO);
      this.ALg.setOnClickListener(this.kuO);
      this.ALi.setClickable(true);
      this.ALi.setOnClickListener(new WalletOfflineCoinPurseUI.11(this));
      this.mLastTime = System.currentTimeMillis();
      this.ALq = new e();
      this.ALq.ehq();
      com.tencent.mm.plugin.newtips.a.exl().h(this.ALq);
      this.ALr = new g();
      this.ALr.ehq();
      com.tencent.mm.plugin.newtips.a.exl().h(this.ALr);
      this.ALs = new b();
      this.ALs.ehq();
      com.tencent.mm.plugin.newtips.a.exl().h(this.ALs);
      this.ALt = new f();
      this.ALt.ehq();
      com.tencent.mm.plugin.newtips.a.exl().h(this.ALt);
      this.ALu = new d();
      this.ALu.ehq();
      com.tencent.mm.plugin.newtips.a.exl().h(this.ALu);
      if ((this.mEntryScene != 3) && (this.mEntryScene != 10) && (this.mEntryScene != 11) && (this.mEntryScene != 12)) {
        break label908;
      }
      this.ALv.setVisibility(8);
      this.ALw.setVisibility(8);
      this.ALx.setVisibility(8);
      this.ALy.setVisibility(8);
      label629:
      if ((com.tencent.mm.plugin.offline.c.a.eAj()) && (c.ezB()))
      {
        localObject = this.ALS;
        com.tencent.mm.plugin.offline.k.ezn();
        ((c)localObject).a(com.tencent.mm.plugin.offline.k.ezo().AKa);
      }
      ezH();
      ab(true, false);
      this.AIN.startTimer(this.AIM);
      if ((com.tencent.mm.plugin.offline.c.a.ANf != 3) || (!com.tencent.mm.plugin.offline.c.a.ANi)) {
        break label1141;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
      int i = com.tencent.mm.plugin.offline.c.a.ANg;
      long l1 = com.tencent.mm.plugin.offline.c.a.ANh;
      long l2 = System.currentTimeMillis();
      long l3 = i * 1000 + l1 - l2;
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + l1 + " now:" + l2 + " interval:" + l3);
      if ((com.tencent.mm.plugin.offline.c.a.ANg <= 0) || (com.tencent.mm.plugin.offline.c.a.ANh <= 0L) || (l3 <= 0L)) {
        break label1129;
      }
      if (!this.AMs.stopped()) {
        this.AMs.stopTimer();
      }
      this.AMs.startTimer(l3);
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
    }
    for (;;)
    {
      ezG();
      localObject = new zt();
      ((zt)localObject).efM.scene = "5";
      ((zt)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184847);
          if (!Util.isNullOrNil(this.qBN.efN.efO))
          {
            com.tencent.mm.wallet_core.ui.f.a((TextView)WalletOfflineCoinPurseUI.this.findViewById(2131297330), this.qBN.efN.efO, this.qBN.efN.content, this.qBN.efN.url);
            AppMethodBeat.o(184847);
            return;
          }
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
          AppMethodBeat.o(184847);
        }
      };
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(66477);
      return;
      setMMTitle(2131768413);
      break;
      label908:
      this.ALy.setVisibility(0);
      this.ALz.setVisibility(0);
      final boolean bool1 = com.tencent.mm.plugin.newtips.a.g.b(this.ALq);
      final boolean bool2 = com.tencent.mm.plugin.newtips.a.g.b(this.ALs);
      final boolean bool3 = com.tencent.mm.plugin.newtips.a.g.b(this.ALt);
      final boolean bool4 = com.tencent.mm.plugin.newtips.a.g.b(this.ALr);
      final boolean bool5 = com.tencent.mm.plugin.newtips.a.g.b(this.ALu);
      if (((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OeE, Boolean.FALSE)).booleanValue()) {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
      }
      ImageView localImageView;
      for (;;)
      {
        localObject = (TextView)findViewById(2131297272);
        localImageView = (ImageView)findViewById(2131297271);
        if (!this.ALX) {
          break label1105;
        }
        ((TextView)localObject).setText(2131756492);
        localImageView.setImageResource(2131690922);
        localImageView.getDrawable().setColorFilter(getResources().getColor(2131099681), PorterDuff.Mode.SRC_ATOP);
        break;
        getWindow().getDecorView().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(213636);
            ScrollView localScrollView = (ScrollView)WalletOfflineCoinPurseUI.this.findViewById(2131305584);
            if (localScrollView == null)
            {
              AppMethodBeat.o(213636);
              return;
            }
            int[] arrayOfInt = new int[2];
            localScrollView.getLocationInWindow(arrayOfInt);
            int i = com.tencent.mm.ui.ao.az(WalletOfflineCoinPurseUI.this.getContext()).y;
            int j = i;
            if (com.tencent.mm.ui.ao.aA(WalletOfflineCoinPurseUI.this.getContext()))
            {
              Log.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
              j = i - com.tencent.mm.ui.ao.aD(WalletOfflineCoinPurseUI.this.getContext());
            }
            if (bool1) {}
            for (i = arrayOfInt[1] + WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).getBottom();; i = 0)
            {
              if (bool4) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).getBottom();
              }
              if (bool2) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).getBottom();
              }
              if (bool3) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).getBottom();
              }
              if (bool5) {
                i = arrayOfInt[1] + WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).getBottom();
              }
              Log.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
              i -= j;
              if (i > 0) {
                localScrollView.scrollBy(0, i);
              }
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OeE, Boolean.TRUE);
              AppMethodBeat.o(213636);
              return;
            }
          }
        });
      }
      label1105:
      ((TextView)localObject).setText(2131756542);
      localImageView.setImageResource(2131689766);
      localImageView.clearColorFilter();
      break label629;
      label1129:
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
      continue;
      label1141:
      if (com.tencent.mm.plugin.offline.c.a.ANf == 3) {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
      } else {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.c.a.ANf) });
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
    final ImageView localImageView = (ImageView)this.AKR.get(paramString);
    paramString = (Integer)this.AKS.get(paramString);
    if ((localImageView == null) || (paramString == null))
    {
      AppMethodBeat.o(66496);
      return;
    }
    new MMHandler(getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213646);
        int i = paramString.intValue();
        Bitmap localBitmap = BitmapUtil.extractThumbNail(paramBitmap, i, i, true, false);
        localImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(213646);
      }
    });
    AppMethodBeat.o(66496);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66469);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.wallet_core.model.t.fQC();
    this.ALX = com.tencent.mm.plugin.wallet_core.model.t.fQR();
    com.tencent.mm.plugin.offline.k.AIX = true;
    com.tencent.mm.wallet_core.ui.f.aqm(41);
    paramBundle = getIntent();
    this.ALD = paramBundle.getBooleanExtra("is_offline_create", false);
    if ((paramBundle != null) && (paramBundle.hasExtra("key_entry_scene"))) {
      this.mEntryScene = paramBundle.getIntExtra("key_entry_scene", this.mEntryScene);
    }
    this.gwE = paramBundle.getIntExtra("key_from_scene", 0);
    this.ALh = Util.nullAs(paramBundle.getStringExtra("key_business_attach"), "");
    this.sQn = 1;
    if (this.mEntryScene == 2) {
      this.sQn = 1;
    }
    for (;;)
    {
      getWindow().addFlags(8192);
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
      setContentViewVisibility(0);
      setActionbarColor(getResources().getColor(2131099840));
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
          AppMethodBeat.i(213666);
          paramAnonymousMenuItem = new ip();
          paramAnonymousMenuItem.dNj.dNk = "ok";
          EventCenter.instance.publish(paramAnonymousMenuItem);
          if (WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this) == 8) {
            com.tencent.mm.plugin.offline.c.a.aJv(WalletOfflineCoinPurseUI.this.getIntent().getStringExtra("key_appid"));
          }
          WalletOfflineCoinPurseUI.this.finish();
          AppMethodBeat.o(213666);
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
        com.tencent.mm.wallet_core.ui.f.hhU();
        if (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRp())
        {
          Log.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
          initView();
          paramBundle = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.OfI, "");
          if (Util.isNullOrNil(paramBundle)) {}
        }
      }
      catch (Exception paramBundle)
      {
        try
        {
          label646:
          do
          {
            for (;;)
            {
              this.AMc = com.tencent.mm.plugin.wallet_core.model.r.bJ(new JSONObject(paramBundle));
              u.a(this);
              com.tencent.mm.plugin.offline.k.ezn();
              com.tencent.mm.plugin.offline.k.ezo().a(this);
              addSceneEndListener(606);
              addSceneEndListener(609);
              addSceneEndListener(1501);
              addSceneEndListener(580);
              com.tencent.mm.plugin.offline.k.ezn();
              com.tencent.mm.plugin.offline.k.ezp().dM(this);
              EventCenter.instance.addListener(this.AMp);
              com.tencent.mm.plugin.offline.c.a.eAx();
              EventCenter.instance.add(this.AMn);
              EventCenter.instance.add(this.AMl);
              EventCenter.instance.add(this.AMg);
              EventCenter.instance.add(this.AMh);
              this.AMi.alive();
              this.AMj.alive();
              this.AMk.alive();
              this.ALC = new com.tencent.mm.plugin.offline.g();
              paramBundle = new of();
              paramBundle.dUu.aHK = hashCode();
              EventCenter.instance.publish(paramBundle);
              this.AMm.alive();
              AppMethodBeat.o(66469);
              return;
              if (this.mEntryScene == 1)
              {
                this.sQn = 2;
                break;
              }
              if (this.mEntryScene == 8)
              {
                this.sQn = 4;
                break;
              }
              if (this.mEntryScene == 4)
              {
                this.sQn = 6;
                break;
              }
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[] { Integer.valueOf(this.sQn) });
              break;
              paramBundle = paramBundle;
              Log.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", paramBundle, "", new Object[0]);
              getWindow().setFlags(8192, 8192);
              int i = 0;
              continue;
              if (!com.tencent.mm.plugin.wallet_core.model.t.fQI().fRm()) {
                break label646;
              }
              Log.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
              com.tencent.mm.plugin.offline.c.a.eAw();
              com.tencent.mm.plugin.offline.k.ezn();
              com.tencent.mm.plugin.offline.k.bN(196648, "0");
            }
          } while ((!com.tencent.mm.plugin.wallet_core.model.t.fQI().fRk()) || (!com.tencent.mm.plugin.offline.c.a.eAj()));
          ezZ();
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
    Object localObject = com.tencent.mm.plugin.offline.c.a.eAm();
    if (localObject != null)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerial:%s serial:%s mLastBindSerial:%s", new Object[] { this.AIf, ((Bankcard)localObject).field_bindSerial, this.ALc });
      if ((((Bankcard)localObject).fQg()) && (!eAb()))
      {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "need checkout FQF");
        localObject = this.ALc;
        Util.isNullOrNil(this.ALc);
        com.tencent.mm.plugin.offline.c.a.aJk((String)localObject);
        com.tencent.mm.plugin.offline.k.ezn();
        com.tencent.mm.plugin.offline.k.ezp().AIf = ((String)localObject);
      }
    }
    this.ALT.dismiss();
    com.tencent.mm.plugin.offline.k.AIX = false;
    com.tencent.mm.wallet_core.ui.f.Z(this.AKT);
    com.tencent.mm.wallet_core.ui.f.Z(this.AKU);
    com.tencent.mm.wallet_core.ui.f.bu(this.ALP);
    com.tencent.mm.wallet_core.ui.f.bu(this.ALQ);
    this.ALP.clear();
    this.ALQ.clear();
    this.AKY.clear();
    this.AKZ.clear();
    this.ALa.clear();
    u.c(this);
    com.tencent.mm.plugin.offline.k.ezn();
    com.tencent.mm.plugin.offline.k.ezo().b(this);
    removeSceneEndListener(606);
    removeSceneEndListener(609);
    removeSceneEndListener(1501);
    removeSceneEndListener(580);
    com.tencent.mm.plugin.offline.k.ezn();
    com.tencent.mm.plugin.offline.k.ezp().dN(this);
    EventCenter.instance.removeListener(this.AMp);
    EventCenter.instance.removeListener(this.AMn);
    EventCenter.instance.removeListener(this.AMg);
    EventCenter.instance.removeListener(this.AMh);
    if (!this.AIN.stopped()) {
      this.AIN.stopTimer();
    }
    if (!this.AMs.stopped()) {
      this.AMs.stopTimer();
    }
    if (this.ALR != null) {
      this.ALR.release();
    }
    if (this.ALS != null)
    {
      localObject = this.ALS;
      ((c)localObject).paT.cancel();
      ((c)localObject).mActivity = null;
    }
    EventCenter.instance.removeListener(this.AMl);
    this.AMj.dead();
    this.AMk.dead();
    localObject = this.ALC;
    ((com.tencent.mm.plugin.offline.g)localObject).stop();
    com.tencent.mm.plugin.offline.g.ezi();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(385, ((com.tencent.mm.plugin.offline.g)localObject).AIx);
    ((com.tencent.mm.plugin.offline.g)localObject).AIz = null;
    this.AMm.dead();
    this.AMi.dead();
    com.tencent.mm.plugin.remittance.mobile.a.b.VZ(0);
    super.onDestroy();
    AppMethodBeat.o(66475);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66517);
    if ((paramInt == 4) && (this.ALT != null) && (this.ALT.getVisibility() == 0) && (this.ALT.AKu))
    {
      this.ALT.dismiss();
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
    this.AKW = true;
    AppMethodBeat.o(66473);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66474);
    com.tencent.mm.plugin.offline.k.ezn();
    com.tencent.mm.plugin.offline.i locali = com.tencent.mm.plugin.offline.k.ezq();
    locali.mHandler.removeCallbacks(locali.AIL);
    ScreenShotUtil.setScreenShotCallback(this, null);
    this.mIsForeground = false;
    EventCenter.instance.removeListener(this.AMo);
    this.ALC.stop();
    super.onPause();
    AppMethodBeat.o(66474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66471);
    super.onResume();
    EventCenter.instance.addListener(this.AMo);
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, this);
      if (!this.ALU)
      {
        ezD();
        this.ALU = true;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
      this.mIsForeground = true;
      Object localObject = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class);
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).a(this, ((com.tencent.mm.plugin.walletlock.a.b)localObject).fUE(), null);
      if (NetStatusUtil.isNetworkConnected(getBaseContext()))
      {
        if (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRp()) {
          doSceneForceProgress(new ad(null, 8));
        }
        if ((com.tencent.mm.plugin.offline.c.a.eAj()) && (this.AMb))
        {
          com.tencent.mm.plugin.offline.k.ezn();
          com.tencent.mm.plugin.offline.k.ezq().sx(false);
          if (!c.ezB())
          {
            if (!this.ALM) {
              break label463;
            }
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do not doNetSceneUserBindQuery()");
            this.ALM = false;
          }
        }
      }
      if (!this.AMb) {
        this.AMb = true;
      }
      ezH();
      localObject = com.tencent.mm.plugin.offline.c.a.eAm();
      if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (!((Bankcard)localObject).field_bindSerial.equals(this.AIf)))
      {
        this.AIf = ((Bankcard)localObject).field_bindSerial;
        com.tencent.mm.plugin.offline.k.ezn();
        com.tencent.mm.plugin.offline.k.ezp().AIf = this.AIf;
        i = 1;
        if ((i != 0) || ((this.AKX) && (this.AKW)))
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
          this.AKX = false;
          this.AKW = false;
          ezO();
          TZ(0);
          sy(true);
        }
        localObject = this.ALC;
        if (!com.tencent.mm.plugin.offline.c.a.eAL()) {
          break label533;
        }
        Log.i(com.tencent.mm.plugin.offline.g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + ((com.tencent.mm.plugin.offline.g)localObject).AIz.stopped());
        if ((((com.tencent.mm.plugin.offline.g)localObject).AIz == null) || (((com.tencent.mm.plugin.offline.g)localObject).AIz.stopped()))
        {
          ((com.tencent.mm.plugin.offline.g)localObject).status = 1;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 61L, 1L, true);
          if (!((com.tencent.mm.plugin.offline.g)localObject).AIy) {
            break label515;
          }
          com.tencent.mm.plugin.offline.g.ezi();
          ((com.tencent.mm.plugin.offline.g)localObject).AIz.startTimer(com.tencent.mm.plugin.offline.g.AIi);
          i = com.tencent.mm.plugin.offline.g.AIi;
        }
        if (this.ALZ)
        {
          this.ALZ = false;
          com.tencent.mm.plugin.report.service.h.CyF.a(18930, new Object[] { Integer.valueOf(this.AMa), Integer.valueOf(4) });
        }
        this.AMd = false;
        this.AMe = false;
        AppMethodBeat.o(66471);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", localException, "", new Object[0]);
        continue;
        label463:
        com.tencent.mm.plugin.offline.a.q localq = new com.tencent.mm.plugin.offline.a.q(this.mEntryScene, this.eventId, this.ALY, this.ALK);
        this.ALK = 0;
        doSceneProgress(localq, false);
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do doNetSceneUserBindQuery()");
        continue;
        int i = 0;
        continue;
        label515:
        localq.AIz.startTimer(com.tencent.mm.plugin.offline.g.AIw);
        i = com.tencent.mm.plugin.offline.g.AIw;
        continue;
        label533:
        Log.i(com.tencent.mm.plugin.offline.g.TAG, "OfflineGetMsg is not in abtest");
      }
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(66476);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " scene: " + paramq);
    if (((paramq instanceof com.tencent.mm.plugin.offline.a.f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.AIK.ezs();
      this.AIK = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof ad))
      {
        if (this.ALV)
        {
          this.ALV = false;
          paramString = com.tencent.mm.plugin.offline.c.a.eAn();
          if (paramString != null) {
            doSceneForceProgress(new com.tencent.mm.plugin.offline.a.k(paramString, this.ALW, 0));
          }
          AppMethodBeat.o(66476);
          return true;
        }
        if (com.tencent.mm.plugin.offline.c.a.eAj())
        {
          if (com.tencent.mm.plugin.offline.c.a.sA(false) != null) {
            doSceneProgress(new n(System.currentTimeMillis(), this.mEntryScene), false);
          }
          ezZ();
        }
        paramString = ((ad)paramq).HQp;
        if ((paramString == null) || (paramString.HYr == 0))
        {
          if (this.ALT.AKt == 7) {
            this.ALT.dismiss();
          }
          this.AMc = ((ad)paramq).HQq;
          ezW();
          ezY();
          label289:
          if ((!(paramq instanceof ad)) && (!(paramq instanceof n)) && (!(paramq instanceof com.tencent.mm.plugin.offline.a.a)) && (!(paramq instanceof com.tencent.mm.plugin.offline.a.e))) {
            break label1641;
          }
          if ((paramq instanceof ad))
          {
            if ((!this.AMe) && (!this.AMd)) {
              break label1535;
            }
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hasClickFQFGuideBar || hasClickChangeBankcardLayout，dont resetDefaultBankcard");
          }
          label352:
          ezH();
          ab(false, true);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66476);
      return true;
      if (!this.ALT.TY(7)) {
        break;
      }
      if (this.ALT.AKt == 7) {
        this.ALT.dismiss();
      }
      this.AMa = paramString.HYq;
      Object localObject1 = this.ALT;
      View localView = this.ALd;
      Object localObject2 = new WalletOfflineCoinPurseUI.29(this);
      com.tencent.mm.plugin.report.service.h.CyF.a(18930, new Object[] { Integer.valueOf(paramString.HYq), Integer.valueOf(1) });
      ((OfflineAlertView)localObject1).AKt = 7;
      ((OfflineAlertView)localObject1).setVisibility(0);
      ((OfflineAlertView)localObject1).AKu = false;
      ((OfflineAlertView)localObject1).jLy.removeAllViews();
      Object localObject3 = LayoutInflater.from(((OfflineAlertView)localObject1).getContext()).inflate(2131496970, ((OfflineAlertView)localObject1).jLy, false);
      ((OfflineAlertView)localObject1).jLy.addView((View)localObject3);
      Object localObject4 = (TextView)((View)localObject3).findViewById(2131304339);
      TextView localTextView = (TextView)((View)localObject3).findViewById(2131308721);
      localObject3 = (Button)((View)localObject3).findViewById(2131302465);
      if (!Util.isNullOrNil(paramString.HYt)) {
        ((TextView)localObject4).setText(paramString.HYt);
      }
      if (!Util.isNullOrNil(paramString.HYu))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("repayment_tiny_app_username", paramString.HYv);
        ((Bundle)localObject4).putString("repayment_tiny_app_path", paramString.HYw);
        localTextView.setText(paramString.HYu);
        com.tencent.mm.pluginsdk.ui.span.l.a(localTextView, false, localObject4);
        if (((OfflineAlertView)localObject1).ptq != null) {
          com.tencent.mm.pluginsdk.ui.span.l.b(((OfflineAlertView)localObject1).ptq);
        }
        ((OfflineAlertView)localObject1).ptq = new OfflineAlertView.3((OfflineAlertView)localObject1, (View.OnClickListener)localObject2, paramString);
        com.tencent.mm.pluginsdk.ui.span.l.a(((OfflineAlertView)localObject1).ptq);
      }
      if (paramString.HYs > 0)
      {
        ((Button)localObject3).setEnabled(false);
        if (((OfflineAlertView)localObject1).AKw == null) {
          break label753;
        }
        ((OfflineAlertView)localObject1).AKw.cancel();
      }
      for (;;)
      {
        ((OfflineAlertView)localObject1).AKw.start();
        ((Button)localObject3).setOnClickListener(new OfflineAlertView.5((OfflineAlertView)localObject1, paramString));
        localView.post(new OfflineAlertView.6((OfflineAlertView)localObject1, localView));
        break;
        label753:
        localObject2 = new com.tencent.mm.wallet_core.c.c();
        ((com.tencent.mm.wallet_core.c.c)localObject2).duration = (paramString.HYs * 1000);
        ((com.tencent.mm.wallet_core.c.c)localObject2).interval = 1000L;
        ((com.tencent.mm.wallet_core.c.c)localObject2).Rtp = new OfflineAlertView.4((OfflineAlertView)localObject1, (Button)localObject3);
        ((OfflineAlertView)localObject1).AKw = new com.tencent.mm.wallet_core.c.c.1((com.tencent.mm.wallet_core.c.c)localObject2, ((com.tencent.mm.wallet_core.c.c)localObject2).duration, ((com.tencent.mm.wallet_core.c.c)localObject2).interval);
      }
      if ((paramq instanceof com.tencent.mm.plugin.offline.a.m))
      {
        this.AIK = ((com.tencent.mm.plugin.offline.a.m)paramq);
        paramString = this.AIK.AJO;
        com.tencent.mm.plugin.offline.k.ezn();
        paramString = new com.tencent.mm.plugin.offline.a.f(paramString, com.tencent.mm.plugin.offline.k.TX(196617));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
        break label289;
      }
      if ((paramq instanceof j))
      {
        ezH();
        ezD();
        break label289;
      }
      if ((paramq instanceof n))
      {
        paramString = (n)paramq;
        if ("1".equals(paramString.AJT))
        {
          Log.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
          if (Util.isNullOrNil(paramString.AJU)) {}
          for (paramString = getString(2131767667);; paramString = paramString.AJU)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(213633);
                WalletOfflineCoinPurseUI.this.finish();
                AppMethodBeat.o(213633);
              }
            });
            AppMethodBeat.o(66476);
            return true;
          }
        }
        if (paramString.AJo == 0)
        {
          localObject1 = this.ALS;
          ((c)localObject1).AKJ = com.tencent.mm.plugin.offline.c.a.eAr();
          ((c)localObject1).AKJ = ((c)localObject1).AKJ;
          if (!"1".equals(paramString.AJS)) {
            break label289;
          }
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
          doSceneProgress(new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 8), false);
          break label289;
        }
        if (paramString.AJo == 0) {
          break label289;
        }
        this.ALS.a(paramString, paramString.AJo, paramString.AJp);
        break label289;
      }
      if ((paramq instanceof com.tencent.mm.plugin.offline.a.a)) {
        break label289;
      }
      if ((paramq instanceof com.tencent.mm.plugin.offline.a.e))
      {
        this.ALS.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
        break label289;
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
      {
        if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
          this.mTipDialog.dismiss();
        }
        paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.i)paramq;
        if (("1".equals(paramString.HTQ)) || (("2".equals(paramString.HTQ)) && (!Util.isNullOrNil(paramString.HTR))))
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
          if ("collect".equals(paramString.HTU)) {
            ezE();
          } else if ("reward".equals(paramString.HTU)) {
            com.tencent.mm.br.c.V(getContext(), "collect", ".reward.ui.QrRewardMainUI");
          } else {
            Log.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { paramString.HTU });
          }
        }
      }
      if (!(paramq instanceof com.tencent.mm.plugin.offline.a.q)) {
        break label289;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneTenpayWxOfflineUserBindQuery ok");
      paramString = (com.tencent.mm.plugin.offline.a.q)paramq;
      this.ALG = true;
      if ((paramString.isJumpRemind()) && (!this.ALH && (paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
      {
        public final void eeY() {}
      }))) {
        this.ALH = true;
      }
      onSceneEnd(paramString.AJZ.errType, paramString.AJZ.errCode, paramString.AJZ.errMsg, paramString.AJX);
      onSceneEnd(paramString.AJY.errType, paramString.AJY.errCode, paramString.AJY.errMsg, paramString.AJW);
      if ((this.ALJ != null) && (this.ALJ.qAx.isShowing()) && (this.ALI == 1)) {
        sz(true);
      }
      if (Util.isNullOrNil(this.ALb)) {
        break label289;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerialOperation：%s", new Object[] { this.ALb });
      eAa();
      break label289;
      label1535:
      if (eAc())
      {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "resetDefaultBankcard()");
        paramString = com.tencent.mm.plugin.offline.c.a.eAl();
        if (paramString != null)
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "newDefaultBankcard.field_bindSerial : %s，mBindSerial：%s", new Object[] { paramString.field_bindSerial, this.AIf });
          a(paramString);
          if (eAc())
          {
            Ua(8);
            this.ALN = true;
            break label352;
          }
          this.ALN = false;
          break label352;
        }
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "get bankcard fail");
        break label352;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "currentBankcard is not FQF,dont resetDefaultBankcard");
      break label352;
      label1641:
      if ((paramq instanceof com.tencent.mm.plugin.offline.a.f))
      {
        ezH();
        ab(true, true);
      }
      else if ((paramq instanceof com.tencent.mm.plugin.offline.a.k))
      {
        com.tencent.mm.plugin.offline.c.a.aA(this);
        doSceneProgress(new ad(null, 8), false);
        ezS();
        ezT();
        ezQ();
      }
      else if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneCheckPayJsapi ok");
        this.ALm.setVisibility(8);
        com.tencent.mm.plugin.wallet_core.model.t.fQI().c(null);
        if (this.AMf != null)
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end mJsApiOfflineUserBindQueryResultCallBackEventEvent != null");
          paramString = this.AMf;
          if (paramString.dQg.dQn.equals("1"))
          {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "FQF openSuccess");
            Ua(6);
            if (!Util.isNullOrNil(paramString.dQg.dQm))
            {
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "event.data.bindSerial is : %s", new Object[] { paramString.dQg.dQm });
              this.ALb = paramString.dQg.dQm;
            }
            doSceneProgress(new com.tencent.mm.plugin.offline.a.q(this.mEntryScene, this.eventId, "", paramString.dQg.appId, paramString.dQg.dQj), false);
          }
          else
          {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "FQF openfail");
            Ua(7);
            if (this.AMf != null)
            {
              this.AMf.dQh.errMsg = "ok:open fail";
              this.AMf.dQg.callback.run();
              this.AMf = null;
              this.ALb = "";
            }
          }
        }
        else
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneCheckPayJsapi fail");
          continue;
          if ((paramq instanceof n))
          {
            ezH();
            ab(false, true);
            if (411 == paramInt2) {
              this.ALS.a(paramq, paramInt2, paramString);
            }
          }
          else if ((paramq instanceof com.tencent.mm.plugin.offline.a.e))
          {
            this.ALS.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
          }
          else if (!(paramq instanceof j))
          {
            if ((paramq instanceof com.tencent.mm.plugin.offline.a.f))
            {
              this.AIK = null;
            }
            else if ((paramq instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
            {
              if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
                this.mTipDialog.dismiss();
              }
            }
            else if ((paramq instanceof com.tencent.mm.plugin.offline.a.q))
            {
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneTenpayWxOfflineUserBindQuery fail");
              ezH();
              ab(false, true);
              if (411 == paramInt2) {
                this.ALS.a(paramq, paramInt2, paramString);
              }
              if (this.AMf != null)
              {
                this.AMf.dQh.errMsg = "fail:NetSceneTenpayWxOfflineUserBindQuery";
                this.AMf.dQg.callback.run();
                this.AMf = null;
                this.ALb = "";
              }
            }
            else if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d))
            {
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneCheckPayJsapi fail");
              if (this.AMf != null)
              {
                this.AMf.dQh.errMsg = "fail:NetSceneCheckPayJsapi";
                this.AMf.dQg.callback.run();
                this.AMf = null;
                this.ALb = "";
              }
            }
          }
        }
      }
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(213667);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
    TZ(1);
    sy(true);
    com.tencent.mm.wallet_core.ui.f.aqm(40);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 21L, 1L, true);
    if (this.ALR.kuK.isShowing())
    {
      if (this.ALR.pZM)
      {
        this.ALR.hhR();
        AppMethodBeat.o(213667);
        return;
      }
      this.ALR.dismiss();
    }
    ezR();
    AppMethodBeat.o(213667);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  abstract class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    protected TextView AMJ;
    protected TextView AMK;
    protected ImageView AML;
    
    public a()
    {
      eAf();
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
    }
    
    public final boolean a(boolean paramBoolean, ehv paramehv)
    {
      if (paramBoolean)
      {
        this.AML.setVisibility(0);
        this.AMK.setVisibility(0);
        this.AMK.setText(paramehv.title);
      }
      for (;;)
      {
        return true;
        this.AML.setVisibility(8);
        this.AMK.setVisibility(8);
      }
    }
    
    public final boolean b(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public abstract void eAf();
    
    public final boolean ehp()
    {
      return false;
    }
    
    public boolean ehq()
    {
      return false;
    }
    
    public final boolean qV(boolean paramBoolean)
    {
      return com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
    }
    
    public final boolean qW(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.AML.setVisibility(0);
      }
      for (;;)
      {
        return true;
        this.AML.setVisibility(8);
      }
    }
    
    public final boolean qX(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.AMJ.setVisibility(0);
      }
      for (;;)
      {
        return true;
        this.AMJ.setVisibility(8);
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
    
    public final void eAf()
    {
      AppMethodBeat.i(66443);
      WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131310219));
      this.AMJ = ((TextView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131296294));
      this.AMK = ((TextView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131296305));
      this.AML = ((ImageView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(2131296304));
      WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineAALayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
          com.tencent.mm.plugin.newtips.a.exl().TC(16);
          com.tencent.mm.plugin.report.service.h.CyF.a(14021, new Object[] { Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.ab(WalletOfflineCoinPurseUI.this)) });
          paramAnonymousView = new Intent();
          if (WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this) == 1) {
            paramAnonymousView.putExtra("enter_scene", 2);
          }
          for (;;)
          {
            com.tencent.mm.br.c.b(WalletOfflineCoinPurseUI.this.getContext(), "aa", ".ui.AAEntranceUI", paramAnonymousView);
            WalletOfflineCoinPurseUI.Y(WalletOfflineCoinPurseUI.this);
            if (com.tencent.mm.y.c.axV().b(ar.a.Oez, ar.a.Odv))
            {
              com.tencent.mm.y.c.axV().c(ar.a.Oez, ar.a.Odv);
              WalletOfflineCoinPurseUI.b.this.AMJ.setVisibility(8);
              com.tencent.mm.plugin.report.service.h.CyF.a(14396, new Object[] { Integer.valueOf(4) });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineAALayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66442);
            return;
            if (WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this) == 2) {
              paramAnonymousView.putExtra("enter_scene", 4);
            } else {
              Log.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { Integer.valueOf(WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this)) });
            }
          }
        }
      });
      AppMethodBeat.o(66443);
    }
    
    public final boolean ehq()
    {
      AppMethodBeat.i(66444);
      super.ehq();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.axV().b(ar.a.Oez, ar.a.Odv))
      {
        this.AMJ.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.ADH, true);
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
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66445);
      return localLinearLayout;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    ArrayList<Boolean> AMN;
    ArrayList<String> mDataList;
    
    public c()
    {
      AppMethodBeat.i(66446);
      this.mDataList = new ArrayList();
      this.AMN = new ArrayList();
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
      paramView = (CheckedTextView)View.inflate(WalletOfflineCoinPurseUI.this, 2131496951, null);
      paramView.setText((String)this.mDataList.get(paramInt));
      if (WalletOfflineCoinPurseUI.eAe() == paramInt)
      {
        paramView.setChecked(true);
        if (!isEnabled(paramInt)) {
          break label90;
        }
        paramView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(2131100904));
        paramView.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(66450);
        return paramView;
        paramView.setChecked(false);
        break;
        label90:
        paramView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(2131100594));
        paramView.setEnabled(false);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(66449);
      boolean bool = ((Boolean)this.AMN.get(paramInt)).booleanValue();
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
    
    public final void eAf()
    {
      AppMethodBeat.i(66452);
      WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131310220));
      this.AMJ = ((TextView)WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).findViewById(2131297276));
      this.AMK = ((TextView)WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).findViewById(2131297278));
      this.AML = ((ImageView)WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).findViewById(2131297277));
      WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66451);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineBankRemitLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          WalletOfflineCoinPurseUI.Y(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = new com.tencent.mm.g.b.a.lc();
          paramAnonymousView.ejA = 3L;
          paramAnonymousView.bfK();
          com.tencent.mm.plugin.newtips.a.exl().TC(20);
          com.tencent.mm.plugin.remittance.mobile.a.b.VZ(WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this));
          if (WalletOfflineCoinPurseUI.ad(WalletOfflineCoinPurseUI.this)) {
            com.tencent.mm.br.c.V(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".mobile.ui.BankMobileRemittanceChooseUI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineBankRemitLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66451);
            return;
            com.tencent.mm.br.c.V(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
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
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this);
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
    
    public final void eAf()
    {
      AppMethodBeat.i(66456);
      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131310222));
      this.AMJ = ((TextView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131300291));
      this.AMK = ((TextView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131300293));
      this.AML = ((ImageView)WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).findViewById(2131300292));
      WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66455);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          WalletOfflineCoinPurseUI.Y(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.exl().TC(17);
          if (com.tencent.mm.y.c.axV().b(ar.a.OeA, ar.a.Odv))
          {
            com.tencent.mm.y.c.axV().c(ar.a.OeA, ar.a.Odv);
            WalletOfflineCoinPurseUI.e.this.AMJ.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.AMK.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.AML.setVisibility(8);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdP, "");
            com.tencent.mm.plugin.report.service.h.CyF.a(14396, new Object[] { Integer.valueOf(3) });
          }
          if (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRk())
          {
            WalletOfflineCoinPurseUI.Z(WalletOfflineCoinPurseUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66455);
            return;
          }
          com.tencent.mm.plugin.wallet_core.model.t.fQC();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          localObject = WalletOfflineCoinPurseUI.aa(WalletOfflineCoinPurseUI.this);
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
                else if (WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this) != null)
                {
                  WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this).dismiss();
                }
              }
            }
          };
          if (!com.tencent.mm.plugin.wallet_core.model.t.b(paramAnonymousView, (com.tencent.mm.wallet_core.d.e)localObject, 1006))
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
    
    public final boolean ehq()
    {
      AppMethodBeat.i(66457);
      super.ehq();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.axV().b(ar.a.OeA, ar.a.Odv))
      {
        com.tencent.mm.kernel.g.aAi();
        String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OdP, "");
        if (Util.isNullOrNil(str)) {
          break label98;
        }
        this.AMK.setText(str);
        this.AMK.setVisibility(0);
        this.AML.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.ADI, true);
      }
      for (;;)
      {
        AppMethodBeat.o(66457);
        return true;
        label98:
        this.AMJ.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.ADH, true);
      }
    }
    
    public final String getPath()
    {
      return "facingreceivereddot";
    }
    
    public final View getRoot()
    {
      AppMethodBeat.i(66458);
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.i(WalletOfflineCoinPurseUI.this);
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
    
    public final void eAf()
    {
      AppMethodBeat.i(66460);
      WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131310223));
      this.AMJ = ((TextView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131300281));
      this.AMK = ((TextView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131300283));
      this.AML = ((ImageView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(2131300282));
      WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66459);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineF2fLuckyLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
          WalletOfflineCoinPurseUI.Y(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.exl().TC(18);
          com.tencent.mm.plugin.report.service.h.CyF.a(14021, new Object[] { Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.ab(WalletOfflineCoinPurseUI.this)) });
          com.tencent.mm.br.c.V(WalletOfflineCoinPurseUI.this.getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
          if (com.tencent.mm.y.c.axV().b(ar.a.OeB, ar.a.Odv))
          {
            com.tencent.mm.y.c.axV().c(ar.a.OeB, ar.a.Odv);
            WalletOfflineCoinPurseUI.f.this.AMJ.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.CyF.a(14396, new Object[] { Integer.valueOf(5) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineF2fLuckyLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66459);
        }
      });
      AppMethodBeat.o(66460);
    }
    
    public final boolean ehq()
    {
      AppMethodBeat.i(66461);
      super.ehq();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.axV().b(ar.a.OeB, ar.a.Odv))
      {
        this.AMJ.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.ADH, true);
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
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this);
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
    
    public final void eAf()
    {
      AppMethodBeat.i(66465);
      WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(2131310225));
      this.AMJ = ((TextView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131306386));
      this.AMK = ((TextView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131306388));
      this.AML = ((ImageView)WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).findViewById(2131306387));
      WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66464);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
          WalletOfflineCoinPurseUI.Y(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.exl().TC(19);
          com.tencent.mm.plugin.report.service.h.CyF.a(14021, new Object[] { Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.ab(WalletOfflineCoinPurseUI.this)) });
          if (com.tencent.mm.y.c.axV().b(ar.a.OeC, ar.a.Odv))
          {
            com.tencent.mm.y.c.axV().c(ar.a.OeC, ar.a.Odv);
            WalletOfflineCoinPurseUI.g.this.AMJ.setVisibility(8);
          }
          if (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRk())
          {
            com.tencent.mm.br.c.V(WalletOfflineCoinPurseUI.this.getContext(), "collect", ".reward.ui.QrRewardMainUI");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66464);
            return;
          }
          com.tencent.mm.plugin.wallet_core.model.t.fQC();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          localObject = WalletOfflineCoinPurseUI.ac(WalletOfflineCoinPurseUI.this);
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
                else if (WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this) != null)
                {
                  WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this).dismiss();
                }
              }
            }
          };
          if (!com.tencent.mm.plugin.wallet_core.model.t.b(paramAnonymousView, (com.tencent.mm.wallet_core.d.e)localObject, 1006))
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
    
    public final boolean ehq()
    {
      AppMethodBeat.i(66467);
      super.ehq();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.y.c.axV().b(ar.a.OeC, ar.a.Odv))
      {
        this.AMJ.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.ADH, true);
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
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66466);
      return localLinearLayout;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI
 * JD-Core Version:    0.7.0.1
 */