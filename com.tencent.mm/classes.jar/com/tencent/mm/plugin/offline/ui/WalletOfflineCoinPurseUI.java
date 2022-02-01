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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.f.a.aba;
import com.tencent.mm.f.a.aba.b;
import com.tencent.mm.f.a.abe;
import com.tencent.mm.f.a.abh;
import com.tencent.mm.f.a.bb;
import com.tencent.mm.f.a.cq;
import com.tencent.mm.f.a.de;
import com.tencent.mm.f.a.jf;
import com.tencent.mm.f.a.lt;
import com.tencent.mm.f.a.lt.a;
import com.tencent.mm.f.a.ma;
import com.tencent.mm.f.a.pb;
import com.tencent.mm.f.a.pc;
import com.tencent.mm.f.a.ps;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.a.xw.b;
import com.tencent.mm.f.b.a.am;
import com.tencent.mm.f.b.a.ny;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.offline.a.j;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.b;
import com.tencent.mm.plugin.offline.a.s.c;
import com.tencent.mm.plugin.offline.a.s.d;
import com.tencent.mm.plugin.offline.a.s.e;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.aj.a;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.ddu;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
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
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
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

@com.tencent.mm.kernel.k
public class WalletOfflineCoinPurseUI
  extends WalletBaseUI
  implements u.a, s.a, com.tencent.mm.plugin.offline.b, a, ScreenShotUtil.ScreenShotCallback
{
  private static int rGs = 0;
  private HashMap<String, Integer> ErL;
  private String GBR;
  private com.tencent.mm.plugin.offline.a.m GBT;
  private int GBV;
  private MTimerHandler GBW;
  private String GBp;
  private IListener<ma> GCj;
  private TextView GEA;
  private e GEB;
  private g GEC;
  private b GED;
  private f GEE;
  private d GEF;
  private LinearLayout GEG;
  private LinearLayout GEH;
  private LinearLayout GEI;
  private LinearLayout GEJ;
  private LinearLayout GEK;
  private String GEL;
  private boolean GEM;
  private com.tencent.mm.plugin.offline.g GEN;
  private boolean GEO;
  private boolean GEP;
  private boolean GEQ;
  private boolean GER;
  private boolean GES;
  private int GEU;
  private com.tencent.mm.plugin.wallet.ui.a GEV;
  private int GEW;
  private boolean GEX;
  private boolean GEY;
  private boolean GEZ;
  private HashMap<String, View> GEc;
  private HashMap<String, Integer> GEd;
  Bitmap GEe;
  Bitmap GEf;
  private c GEg;
  private boolean GEh;
  private boolean GEi;
  private ArrayList<String> GEj;
  private ArrayList<String> GEk;
  private ArrayList<Boolean> GEl;
  private String GEm;
  private String GEn;
  private View GEo;
  private ImageView GEp;
  private ImageView GEq;
  private TextView GEr;
  private String GEs;
  private View GEt;
  private TextView GEu;
  private WeImageView GEv;
  private RelativeLayout GEw;
  private LinearLayout GEx;
  private CdnImageView GEy;
  private TextView GEz;
  private IListener GFA;
  private IListener GFB;
  private IListener GFC;
  public boolean GFD;
  private MTimerHandler GFE;
  private MTimerHandler GFF;
  private ArrayList<Bitmap> GFa;
  private ArrayList<Bitmap> GFb;
  private com.tencent.mm.wallet_core.ui.c GFc;
  private c GFd;
  private OfflineAlertView GFe;
  private boolean GFf;
  private boolean GFg;
  private String GFh;
  private boolean GFi;
  private String GFj;
  private boolean GFk;
  private int GFl;
  private boolean GFm;
  private boolean GFn;
  private boolean GFo;
  private com.tencent.mm.plugin.wallet_core.model.r GFp;
  private boolean GFq;
  private boolean GFr;
  private lt GFs;
  IListener<abh> GFt;
  IListener<lt> GFu;
  IListener<abh> GFv;
  private IListener<de> GFw;
  private IListener<ps> GFx;
  private IListener<pb> GFy;
  private IListener<pc> GFz;
  private int eventId;
  private int jaR;
  private int mEntryScene;
  private boolean mIsForeground;
  private long mLastTime;
  private int mState;
  private Dialog mTipDialog;
  private View.OnClickListener nmC;
  private boolean tvI;
  private int wwk;
  
  public WalletOfflineCoinPurseUI()
  {
    AppMethodBeat.i(66468);
    this.mLastTime = 0L;
    this.mState = 3;
    this.GEc = new HashMap();
    this.GEd = new HashMap();
    this.mEntryScene = -1;
    this.GEe = null;
    this.GEf = null;
    this.GEh = false;
    this.GEi = false;
    this.GEj = new ArrayList();
    this.GEk = new ArrayList();
    this.GEl = new ArrayList();
    this.GBp = "";
    this.GEm = "";
    this.GEn = "";
    this.GEL = "";
    this.GBR = "";
    this.tvI = true;
    this.GEM = false;
    this.GEO = false;
    this.GEP = false;
    this.GEQ = false;
    this.GER = true;
    this.GES = false;
    this.GEU = -1;
    this.GEW = 1;
    this.GEX = false;
    this.GEY = false;
    this.GEZ = false;
    this.GFa = new ArrayList();
    this.GFb = new ArrayList();
    this.GFf = false;
    this.GFg = false;
    this.GFh = null;
    this.GFi = false;
    this.eventId = 0;
    this.GFk = false;
    this.GFm = true;
    this.GFn = false;
    this.GFo = false;
    this.GFq = false;
    this.GFr = false;
    this.GFt = new IListener() {};
    this.GFu = new IListener() {};
    this.GFv = new IListener() {};
    this.GFw = new IListener() {};
    this.GFx = new WalletOfflineCoinPurseUI.40(this);
    this.GFy = new IListener() {};
    this.GFz = new IListener() {};
    this.GFA = new WalletOfflineCoinPurseUI.44(this);
    this.GFB = new IListener() {};
    this.GFC = new IListener() {};
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(240992);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        long l;
        if ((paramAnonymousView.getId() == a.f.wallet_qrcode_iv) || (paramAnonymousView.getId() == a.f.wallet_barcode_iv) || (paramAnonymousView.getId() == a.f.wallet_barcode_tv))
        {
          if ((paramAnonymousView.getId() == a.f.wallet_qrcode_iv) && (WalletOfflineCoinPurseUI.t(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.t(WalletOfflineCoinPurseUI.this).isShowing()))
          {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240992);
            return;
          }
          l = System.currentTimeMillis();
          if (((WalletOfflineCoinPurseUI.t(WalletOfflineCoinPurseUI.this) == null) || (!WalletOfflineCoinPurseUI.t(WalletOfflineCoinPurseUI.this).isShowing())) && (l - WalletOfflineCoinPurseUI.u(WalletOfflineCoinPurseUI.this) >= 400L) && (com.tencent.mm.plugin.offline.c.a.flN()) && (!WalletOfflineCoinPurseUI.v(WalletOfflineCoinPurseUI.this)))
          {
            if (paramAnonymousView.getId() != a.f.wallet_qrcode_iv) {
              break label265;
            }
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, false);
          }
        }
        for (;;)
        {
          if (WalletOfflineCoinPurseUI.w(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.x(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.w(WalletOfflineCoinPurseUI.this).ae(paramAnonymousView, WalletOfflineCoinPurseUI.y(WalletOfflineCoinPurseUI.this));
          }
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, l);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(240992);
          return;
          label265:
          if ((paramAnonymousView.getId() == a.f.wallet_barcode_iv) || (paramAnonymousView.getId() == a.f.wallet_barcode_tv))
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(13958, new Object[] { Integer.valueOf(4) });
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, true);
          }
        }
      }
    };
    this.GFD = false;
    this.ErL = new HashMap();
    this.GBV = 60000;
    this.GBW = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(206100);
        if (!WalletOfflineCoinPurseUI.S(WalletOfflineCoinPurseUI.this))
        {
          WalletOfflineCoinPurseUI.G(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.H(WalletOfflineCoinPurseUI.this);
        }
        WalletOfflineCoinPurseUI.U(WalletOfflineCoinPurseUI.this).startTimer(WalletOfflineCoinPurseUI.T(WalletOfflineCoinPurseUI.this));
        AppMethodBeat.o(206100);
        return false;
      }
    }, false);
    this.GFE = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(270644);
        WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this);
        if ((WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this) != null) && (WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this).isShowing())) {
          WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this).dismiss();
        }
        com.tencent.mm.plugin.offline.g.fkN();
        WalletOfflineCoinPurseUI.W(WalletOfflineCoinPurseUI.this);
        if (com.tencent.mm.plugin.offline.c.a.fmp()) {
          WalletOfflineCoinPurseUI.this.flf();
        }
        AppMethodBeat.o(270644);
        return false;
      }
    }, false);
    this.GFF = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(268984);
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.X(WalletOfflineCoinPurseUI.this)) });
        if (WalletOfflineCoinPurseUI.X(WalletOfflineCoinPurseUI.this))
        {
          cq localcq = new cq();
          localcq.fyo.resultCode = 0;
          EventCenter.instance.publish(localcq);
        }
        WalletOfflineCoinPurseUI.this.finish();
        AppMethodBeat.o(268984);
        return false;
      }
    }, false);
    this.GCj = new IListener() {};
    AppMethodBeat.o(66468);
  }
  
  private void a(Bankcard paramBankcard)
  {
    AppMethodBeat.i(276242);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(276242);
      return;
    }
    paramBankcard = paramBankcard.field_bindSerial;
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doSelectBackcard tempSerial:%s，mBindSerial：%s", new Object[] { paramBankcard, this.GBp });
    if ((!TextUtils.isEmpty(paramBankcard)) && (!paramBankcard.equals(this.GBp)))
    {
      this.GEn = this.GBp;
      this.GBp = paramBankcard;
      com.tencent.mm.plugin.offline.c.a.aTG(this.GBp);
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.fkV().GBp = this.GBp;
      flu();
      aaM(0);
      vM(true);
    }
    AppMethodBeat.o(276242);
  }
  
  private void aaM(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(66490);
    if (!com.tencent.mm.plugin.offline.c.a.flN())
    {
      Log.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
      AppMethodBeat.o(66490);
      return;
    }
    com.tencent.mm.plugin.offline.k.fkT();
    Object localObject = com.tencent.mm.plugin.offline.k.fkV().C(this.mEntryScene, paramInt, this.GEs);
    this.GBR = ((String)localObject);
    this.GEL = ((String)localObject);
    Log.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", new Object[] { Integer.valueOf(paramInt), this.GBR, this.GEL, Util.getStack().toString() });
    cOU();
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      if (com.tencent.mm.plugin.offline.c.a.isAppOnForeground(MMApplicationContext.getContext())) {}
      for (paramInt = 0;; paramInt = 1)
      {
        if (NetStatusUtil.isNetworkConnected(getBaseContext())) {
          i = 1;
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).a(14163, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 26L, 1L, true);
        if (!NetStatusUtil.isNetworkConnected(getBaseContext())) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 28L, 1L, true);
        AppMethodBeat.o(66490);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 27L, 1L, true);
    }
    AppMethodBeat.o(66490);
  }
  
  private static void aaN(int paramInt)
  {
    AppMethodBeat.i(66509);
    am localam = new am();
    localam.giX = paramInt;
    localam.bpa();
    AppMethodBeat.o(66509);
  }
  
  private void am(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66480);
    if (com.tencent.mm.plugin.offline.c.a.vQ(true).size() > 0)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
      flv();
      flu();
      this.GEt.setVisibility(0);
    }
    for (;;)
    {
      if (paramBoolean1) {
        aaM(0);
      }
      vM(paramBoolean2);
      cJn();
      flm();
      AppMethodBeat.o(66480);
      return;
      this.GEt.setVisibility(0);
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
    }
  }
  
  private static int argbColor(long paramLong)
  {
    AppMethodBeat.i(276246);
    int i = Color.argb((int)(paramLong >> 24 & 0xFF), (int)(paramLong >> 16 & 0xFF), (int)(paramLong >> 8 & 0xFF), (int)(0xFF & paramLong));
    AppMethodBeat.o(276246);
    return i;
  }
  
  private void b(Bankcard paramBankcard)
  {
    AppMethodBeat.i(66511);
    if (TextUtils.isEmpty(this.GBp))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
      AppMethodBeat.o(66511);
      return;
    }
    this.GEv.setEnableColorFilter(false);
    if (paramBankcard.gIL())
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
      this.GEv.setImageDrawable(com.tencent.mm.svg.a.a.h(getContext().getResources(), a.h.honey_pay_bank_logo));
      AppMethodBeat.o(66511);
      return;
    }
    String str2 = com.tencent.mm.plugin.offline.c.a.aTN(this.GBp);
    String str1 = str2;
    if (paramBankcard.gII())
    {
      str1 = str2;
      if (paramBankcard.ONN != null) {
        str1 = paramBankcard.ONN.GtW;
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
      AppMethodBeat.o(66511);
      return;
    }
    g(this.GEv, str1, getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width));
    AppMethodBeat.o(66511);
  }
  
  private void cJn()
  {
    AppMethodBeat.i(66479);
    if (com.tencent.mm.plugin.offline.c.a.flN())
    {
      this.GEw.setVisibility(0);
      AppMethodBeat.o(66479);
      return;
    }
    this.GEw.setVisibility(4);
    AppMethodBeat.o(66479);
  }
  
  private void cOU()
  {
    AppMethodBeat.i(66516);
    bd localbd = com.tencent.mm.plugin.wallet_core.model.k.gJe();
    Object localObject = new StringBuilder().append(this.GEL);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE();
    localObject = MD5Util.getMD5String(p.getString(com.tencent.mm.kernel.b.getUin()));
    if (localbd != null) {
      com.tencent.mm.plugin.report.service.h.IzE.a(13444, new Object[] { localbd.RFV, localbd.RFW, Long.valueOf(localbd.RFU), localObject, localbd.RFX, localbd.RFY, localbd.RFZ });
    }
    AppMethodBeat.o(66516);
  }
  
  private void eOk()
  {
    AppMethodBeat.i(66484);
    Bitmap localBitmap = this.GEe;
    this.GEe = fls();
    this.GEp.setImageBitmap(this.GEe);
    this.GFa.add(0, localBitmap);
    AppMethodBeat.o(66484);
  }
  
  private void flA()
  {
    AppMethodBeat.i(66504);
    if (!this.GFe.aaL(5))
    {
      AppMethodBeat.o(66504);
      return;
    }
    if (this.GFe.GDA == 5) {
      this.GFe.dismiss();
    }
    this.GFe.c(this.GEo, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(265328);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.offline.k.fkT();
        com.tencent.mm.plugin.offline.k.fkW();
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.i.fkS()) });
        com.tencent.mm.plugin.offline.k.fkT();
        com.tencent.mm.plugin.offline.k.fkW();
        if (com.tencent.mm.plugin.offline.i.fkS() <= 0)
        {
          paramAnonymousView = new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 10);
          WalletOfflineCoinPurseUI.this.doSceneForceProgress(paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(265328);
          return;
          WalletOfflineCoinPurseUI.N(WalletOfflineCoinPurseUI.this);
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 73L, 1L, true);
    AppMethodBeat.o(66504);
  }
  
  private void flC()
  {
    AppMethodBeat.i(276241);
    if ((this.GFp == null) || (!this.GFp.tpu))
    {
      if (this.GFe.GDA == 8) {
        this.GFe.dismiss();
      }
      AppMethodBeat.o(276241);
      return;
    }
    if (!this.GFe.aaL(8))
    {
      AppMethodBeat.o(276241);
      return;
    }
    if (this.GFe.GDA == 8) {
      this.GFe.dismiss();
    }
    this.GFe.a(this.GEo, this.GFp);
    com.tencent.mm.plugin.report.service.h.IzE.a(20258, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(276241);
  }
  
  private void flD()
  {
    AppMethodBeat.i(66506);
    if ((this.GFe.isShowing()) && (this.GFe.GDA == 5)) {
      this.GFe.dismiss();
    }
    AppMethodBeat.o(66506);
  }
  
  private boolean flE()
  {
    AppMethodBeat.i(66507);
    if (!this.GFe.aaL(2))
    {
      AppMethodBeat.o(66507);
      return false;
    }
    if (this.GFe.GDA == 2) {
      this.GFe.dismiss();
    }
    List localList = com.tencent.mm.plugin.offline.c.a.flU();
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
    this.GFe.dismiss();
    this.GFe.a(this.GEo, new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(186647);
        if (WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this)) {
          com.tencent.mm.plugin.offline.c.a.a(WalletOfflineCoinPurseUI.this, 20000, -1, WalletOfflineCoinPurseUI.this.getInput());
        }
        for (;;)
        {
          WalletOfflineCoinPurseUI.L(WalletOfflineCoinPurseUI.this);
          AppMethodBeat.o(186647);
          return;
          c localc = WalletOfflineCoinPurseUI.D(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.offline.c.a.j(localc.mActivity, localc.GDV);
        }
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(228007);
        WalletOfflineCoinPurseUI.s(WalletOfflineCoinPurseUI.this);
        AppMethodBeat.o(228007);
      }
    });
    AppMethodBeat.o(66507);
    return false;
  }
  
  private static void flF()
  {
    AppMethodBeat.i(66510);
    if (!com.tencent.mm.plugin.offline.c.a.fmh())
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.fkW().iJ(3, 3);
    }
    AppMethodBeat.o(66510);
  }
  
  private void flG()
  {
    AppMethodBeat.i(276249);
    List localList = com.tencent.mm.plugin.offline.c.a.vQ(false);
    if (localList.size() <= 0)
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      AppMethodBeat.o(276249);
      return;
    }
    int i = 0;
    while (i < localList.size())
    {
      Bankcard localBankcard = (Bankcard)localList.get(i);
      if ((!Util.isNullOrNil(localBankcard.field_bindSerial)) && (this.GEm.equals(localBankcard.field_bindSerial)))
      {
        a(localBankcard);
        this.GEm = "";
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "find the mBindSerialOperation");
      }
      i += 1;
    }
    if (this.GFs == null)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mJsApiOfflineUserBindQueryResultCallBackEventEvent == null");
      AppMethodBeat.o(276249);
      return;
    }
    if (!Util.isNullOrNil(this.GEm)) {}
    for (this.GFs.fJy.errMsg = "fail:no find operation bindSerial";; this.GFs.fJy.errMsg = "ok:open success")
    {
      this.GFs.fJx.callback.run();
      this.GFs = null;
      this.GEm = "";
      AppMethodBeat.o(276249);
      return;
    }
  }
  
  private static boolean flH()
  {
    AppMethodBeat.i(276251);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.flQ();
    if ((localBankcard != null) && (localBankcard.gIM()))
    {
      AppMethodBeat.o(276251);
      return true;
    }
    AppMethodBeat.o(276251);
    return false;
  }
  
  private void flj()
  {
    AppMethodBeat.i(66470);
    fly();
    flE();
    flz();
    flw();
    flC();
    AppMethodBeat.o(66470);
  }
  
  private void flk()
  {
    AppMethodBeat.i(66472);
    com.tencent.mm.wallet_core.ui.g.azK(32);
    com.tencent.mm.pluginsdk.wallet.f.aV(this, this.wwk);
    AppMethodBeat.o(66472);
  }
  
  private void fll()
  {
    AppMethodBeat.i(66478);
    final ddt localddt = com.tencent.mm.plugin.wallet_core.model.u.gJo().OUd;
    if (localddt == null)
    {
      this.GEx.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    Object localObject;
    if (localddt.OxL == aj.a.OTE.value)
    {
      if (localddt.TLl == null)
      {
        Log.e("MicroMsg.WalletOfflineCoinPurseUI", "offlineGuideBar.guide_data == null");
        this.GEx.setVisibility(8);
        AppMethodBeat.o(66478);
        return;
      }
      localObject = localddt.TLl.GGC;
      if (com.tencent.mm.plugin.wallet_core.model.u.gJo().l((String)localObject, false, false) == null)
      {
        Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar bindSerial(%s) is null bankcard!", new Object[] { Util.nullAs((String)localObject, "") });
        this.GEx.setVisibility(8);
        AppMethodBeat.o(66478);
        return;
      }
      localObject = com.tencent.mm.plugin.offline.c.a.flQ();
      if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (Util.isEqual(localddt.TLl.GGC, ((Bankcard)localObject).field_bindSerial)))
      {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar defaultBankcard(%s) == bindSerial(%s)", new Object[] { ((Bankcard)localObject).field_bindSerial, localddt.TLl.GGC });
        this.GEx.setVisibility(8);
        AppMethodBeat.o(66478);
        return;
      }
    }
    if ((this.GEx.isShown()) && (this.GEx.getTag() != null) && ((this.GEx.getTag() instanceof ddt)) && (Util.isEqual((ddt)this.GEx.getTag(), localddt)))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "");
      AppMethodBeat.o(66478);
      return;
    }
    if (localddt.OvV == 0)
    {
      this.GEx.setVisibility(8);
      AppMethodBeat.o(66478);
      return;
    }
    if (!this.GER)
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "isShowGuideBar == false");
      AppMethodBeat.o(66478);
      return;
    }
    int i = this.GEx.getVisibility();
    this.GEx.setTag(localddt);
    this.GEx.setVisibility(0);
    final int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 20.0F);
    this.GEy.w(localddt.Owc, j, j, -1);
    this.GEz.setText(localddt.OvX);
    this.GEA.setText(localddt.OvZ);
    ar.a(this.GEA.getPaint(), 0.8F);
    if (localddt.OxL == aj.a.OTE.value)
    {
      if ((!Util.isNullOrNil(localddt.background_color)) && (this.GEx.getBackground() != null)) {
        this.GEx.getBackground().setColorFilter(Color.parseColor(localddt.background_color), PorterDuff.Mode.SRC);
      }
      this.GEz.setTextColor(Color.parseColor(localddt.OvY));
      this.GEA.setTextColor(Color.parseColor(localddt.Owa));
      this.GEA.setTag(localddt.TLl.GGC);
      this.GEA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(275346);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          WalletOfflineCoinPurseUI.aaO(2);
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
            AppMethodBeat.o(275346);
            return;
          }
          WalletOfflineCoinPurseUI.z(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.A(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.u.gJo().bgV((String)localObject);
          WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(275346);
        }
      });
      aaN(1);
      this.GEZ = true;
    }
    for (;;)
    {
      if ((i == 8) && (this.GFe.isShowing()))
      {
        flw();
        if ((!this.GEO) && (this.GFe.aaL(4)))
        {
          com.tencent.mm.kernel.h.aHH();
          if (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmK, Boolean.FALSE)).booleanValue()) {
            flx();
          }
        }
      }
      AppMethodBeat.o(66478);
      return;
      if (localddt.OxL == aj.a.OTF.value)
      {
        if ((!Util.isNullOrNil(localddt.background_color)) && (this.GEx.getBackground() != null)) {
          this.GEx.getBackground().setColorFilter(argbColor(Long.parseLong(localddt.background_color.substring(2), 16)), PorterDuff.Mode.SRC);
        }
        this.GEz.setTextColor(argbColor(Long.parseLong(localddt.OvY.substring(2), 16)));
        this.GEA.setTextColor(argbColor(Long.parseLong(localddt.Owa.substring(2), 16)));
        if (!Util.isNullOrNil(localddt.Owb))
        {
          localObject = (LinearLayout.LayoutParams)this.GEA.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 8);
          this.GEA.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.GEA.setPadding(com.tencent.mm.ci.a.fromDPToPix(getContext(), 12), com.tencent.mm.ci.a.fromDPToPix(getContext(), 4), com.tencent.mm.ci.a.fromDPToPix(getContext(), 12), com.tencent.mm.ci.a.fromDPToPix(getContext(), 4));
          j = argbColor(Long.parseLong(localddt.Owb.substring(2), 16));
          this.GEA.setBackgroundDrawable(getContext().getResources().getDrawable(a.e.wallet_wx_offline_guide_button_tv_normal_bg));
          ((GradientDrawable)this.GEA.getBackground()).setColor(j);
          this.GEA.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(198514);
              if (paramAnonymousMotionEvent.getAction() == 0) {
                WalletOfflineCoinPurseUI.B(WalletOfflineCoinPurseUI.this).setBackgroundDrawable(WalletOfflineCoinPurseUI.this.getContext().getResources().getDrawable(a.e.wallet_wx_offline_guide_button_tv_click_bg));
              }
              for (;;)
              {
                AppMethodBeat.o(198514);
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
        this.GEA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(273027);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.aaO(5);
            switch (localddt.TLo)
            {
            default: 
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown entrance type");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(273027);
              return;
              com.tencent.mm.wallet_core.ui.g.p(WalletOfflineCoinPurseUI.this.getContext(), localddt.TLp, false);
              continue;
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.api.i()
              {
                public final void bFd()
                {
                  AppMethodBeat.i(275906);
                  Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onAppBrandPreconditionError");
                  ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.r.class)).a(this);
                  AppMethodBeat.o(275906);
                }
                
                public final void bFe()
                {
                  AppMethodBeat.i(275903);
                  Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onAppBrandUIEnter");
                  AppMethodBeat.o(275903);
                }
                
                public final void bFf()
                {
                  AppMethodBeat.i(275905);
                  Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onAppBrandProcessDied");
                  WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this);
                  ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.r.class)).a(this);
                  AppMethodBeat.o(275905);
                }
                
                public final void hn(boolean paramAnonymous2Boolean)
                {
                  AppMethodBeat.i(275904);
                  Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onAppBrandUIExit：%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
                  WalletOfflineCoinPurseUI.C(WalletOfflineCoinPurseUI.this);
                  ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.r.class)).a(this);
                  AppMethodBeat.o(275904);
                }
              };
              com.tencent.mm.wallet_core.ui.g.a(localddt.TLq, localddt.TLr, 0, 1137, paramAnonymousView);
            }
          }
        });
        aaN(4);
        this.GEZ = false;
      }
    }
  }
  
  private void flm()
  {
    AppMethodBeat.i(66481);
    if ((!this.GFD) && (!NetStatusUtil.isNetworkConnected(getBaseContext())))
    {
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.fkV();
      if (com.tencent.mm.plugin.offline.e.fkK() == 0)
      {
        this.GFD = true;
        b.aD(this);
        Log.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
      }
    }
    AppMethodBeat.o(66481);
  }
  
  private void fln()
  {
    AppMethodBeat.i(66482);
    int i = com.tencent.mm.plugin.offline.c.a.flT();
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.vP(false);
    if (c.flh())
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
    if (com.tencent.mm.plugin.offline.c.a.flN())
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
  
  private boolean flo()
  {
    return (this.mState == 2) || (this.mState == 1) || (this.mState == 7);
  }
  
  private void flp()
  {
    AppMethodBeat.i(66485);
    Bitmap localBitmap = this.GEf;
    this.GEf = flr();
    this.GEq.setImageBitmap(this.GEf);
    if (flo()) {
      this.GEq.setAlpha(10);
    }
    for (;;)
    {
      this.GFb.add(0, localBitmap);
      AppMethodBeat.o(66485);
      return;
      this.GEq.setAlpha(255);
    }
  }
  
  private void flq()
  {
    AppMethodBeat.i(66486);
    if (this.GFc != null)
    {
      this.GFc.ox(this.GEL, this.GBR);
      this.GFc.GEe = this.GEe;
      this.GFc.GEf = this.GEf;
      this.GFc.ijr();
    }
    AppMethodBeat.o(66486);
  }
  
  private Bitmap flr()
  {
    AppMethodBeat.i(66488);
    if (TextUtils.isEmpty(this.GBR))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
      AppMethodBeat.o(66488);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.cf.a.a.a(this, this.GBR, 5, 0, 0.0D);
    AppMethodBeat.o(66488);
    return localBitmap;
  }
  
  private Bitmap fls()
  {
    AppMethodBeat.i(66489);
    if (TextUtils.isEmpty(this.GEL))
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
      AppMethodBeat.o(66489);
      return null;
    }
    Bitmap localBitmap = com.tencent.mm.cf.a.a.a(this, this.GEL, 12, 3, 0.0D);
    AppMethodBeat.o(66489);
    return localBitmap;
  }
  
  private void flt()
  {
    AppMethodBeat.i(66493);
    if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
      this.mTipDialog.dismiss();
    }
    AppMethodBeat.o(66493);
  }
  
  private void flv()
  {
    AppMethodBeat.i(66499);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.flQ();
    if (localBankcard != null)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard：%s", new Object[] { localBankcard.field_bindSerial });
      com.tencent.mm.plugin.offline.c.a.aTG(localBankcard.field_bindSerial);
      this.GBp = localBankcard.field_bindSerial;
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.fkV().GBp = this.GBp;
      AppMethodBeat.o(66499);
      return;
    }
    Log.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
    AppMethodBeat.o(66499);
  }
  
  private void flw()
  {
    AppMethodBeat.i(66500);
    if (this.GEO)
    {
      AppMethodBeat.o(66500);
      return;
    }
    if (!this.GFe.aaL(4))
    {
      AppMethodBeat.o(66500);
      return;
    }
    com.tencent.mm.kernel.h.aHH();
    if ((!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmK, Boolean.FALSE)).booleanValue()) && (!this.GFe.isShowing())) {
      flx();
    }
    AppMethodBeat.o(66500);
  }
  
  private void flx()
  {
    AppMethodBeat.i(66501);
    if (!this.GFe.aaL(4))
    {
      AppMethodBeat.o(66501);
      return;
    }
    this.GFe.fG(this.GEo);
    AppMethodBeat.o(66501);
  }
  
  private void fly()
  {
    AppMethodBeat.i(66502);
    if (!this.GFe.aaL(1))
    {
      AppMethodBeat.o(66502);
      return;
    }
    if (this.GFe.GDA == 1) {
      this.GFe.dismiss();
    }
    boolean bool1 = com.tencent.mm.plugin.wallet_core.model.u.gJo().gJS();
    boolean bool2 = com.tencent.mm.plugin.wallet_core.model.u.gJo().gJR();
    if ((bool1) || (bool2))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.GFe.a(this.GEo, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184855);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.offline.c.a.fma();
          com.tencent.mm.plugin.offline.k.fkT();
          com.tencent.mm.plugin.offline.k.bL(196648, "0");
          WalletOfflineCoinPurseUI.M(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(184855);
        }
      }, 1);
    }
    AppMethodBeat.o(66502);
  }
  
  private void flz()
  {
    AppMethodBeat.i(66503);
    if (!this.GFe.aaL(3))
    {
      AppMethodBeat.o(66503);
      return;
    }
    if (this.GFe.GDA == 3) {
      this.GFe.dismiss();
    }
    com.tencent.mm.plugin.offline.k.fkT();
    String str1 = com.tencent.mm.plugin.offline.k.aaK(196617);
    com.tencent.mm.wallet_core.c.b.iiL();
    boolean bool1 = com.tencent.mm.wallet_core.c.b.isCertExist(str1);
    boolean bool2 = com.tencent.mm.plugin.offline.c.a.flN();
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) || (!bool2)) {
      if (!bool1)
      {
        com.tencent.mm.kernel.h.aHH();
        String str2 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vgl, "");
        if ((str2 == null) || (!str2.equals(com.tencent.mm.compatible.deviceinfo.q.dR(true)))) {
          break label222;
        }
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + str1 + " ,recreate offline");
      com.tencent.mm.plugin.offline.c.a.fma();
      this.GEw.setVisibility(4);
      this.GFe.a(this.GEo, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(277442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.offline.c.a.k(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this));
          WalletOfflineCoinPurseUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(277442);
        }
      }, 3);
      AppMethodBeat.o(66503);
      return;
      label222:
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
    }
  }
  
  private void g(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(66495);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66495);
      return;
    }
    Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramString));
    if (localBitmap != null) {
      paramImageView.setImageBitmap(BitmapUtil.extractThumbNail(localBitmap, paramInt, paramInt, true, false));
    }
    this.GEc.put(paramString, paramImageView);
    this.GEd.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(66495);
  }
  
  private void recycleBmpList()
  {
    AppMethodBeat.i(66487);
    int i;
    if (this.GFa.size() >= 2)
    {
      i = this.GFa.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.g.X((Bitmap)this.GFa.remove(i));
        i -= 1;
      }
    }
    if (this.GFb.size() >= 2)
    {
      i = this.GFb.size() - 1;
      while (i > 1)
      {
        com.tencent.mm.wallet_core.ui.g.X((Bitmap)this.GFb.remove(i));
        i -= 1;
      }
    }
    AppMethodBeat.o(66487);
  }
  
  private void vM(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(66483);
    long l = System.currentTimeMillis();
    int i;
    if ((paramBoolean) && ((Util.isNullOrNil(this.GEL)) || (Util.isNullOrNil(this.GBR))))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
      flA();
      eOk();
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - l));
      flp();
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - l));
      recycleBmpList();
      flq();
      fll();
      ab.ny(10, 0);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      if (!com.tencent.mm.plugin.offline.c.a.isAppOnForeground(MMApplicationContext.getContext())) {
        break label281;
      }
      i = 0;
      label148:
      if (NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
        j = 1;
      }
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.fkV();
      localh.a(14163, new Object[] { Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(com.tencent.mm.plugin.offline.e.fkK()) });
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 67L, 1L, true);
      if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
        break label286;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 32L, 1L, true);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.offline.c.a.isAppOnForeground(this)) {
        break label303;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 34L, 1L, true);
      AppMethodBeat.o(66483);
      return;
      flD();
      break;
      label281:
      i = 1;
      break label148;
      label286:
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 33L, 1L, true);
    }
    label303:
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 35L, 1L, true);
    AppMethodBeat.o(66483);
  }
  
  private void vN(boolean paramBoolean)
  {
    AppMethodBeat.i(66508);
    if (!com.tencent.mm.plugin.offline.c.a.flN())
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.flN()) });
      AppMethodBeat.o(66508);
      return;
    }
    if (com.tencent.mm.plugin.offline.c.a.vQ(false).size() <= 0)
    {
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
      this.GEu.setVisibility(8);
      AppMethodBeat.o(66508);
      return;
    }
    final ArrayList localArrayList = ag.Cc(true);
    int i;
    Object localObject;
    int j;
    if ((paramBoolean) && (this.GEV == null))
    {
      this.GEV = new com.tencent.mm.plugin.wallet.ui.a(this);
      this.GEU = -1;
      this.GEV.tZx.bYF();
      i = 0;
      localObject = null;
      j = 0;
      label129:
      if (i >= localArrayList.size()) {
        break label212;
      }
      Bankcard localBankcard = (Bankcard)localArrayList.get(i);
      if ((Util.isNullOrNil(localBankcard.field_bindSerial)) || (!this.GBp.equals(localBankcard.field_bindSerial))) {
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
      this.GEV = null;
      this.GEV = new com.tencent.mm.plugin.wallet.ui.a(this);
      break;
      label212:
      if (localObject != null)
      {
        localArrayList.remove(localObject);
        localArrayList.add(0, localObject);
        j = 0;
      }
      this.GEV.ODT = new q.f()
      {
        public final void onCreateMMMenu(final o paramAnonymouso)
        {
          AppMethodBeat.i(276102);
          paramAnonymouso.clear();
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
            localObject1 = com.tencent.mm.plugin.offline.c.a.aTM(localBankcard.field_bankcardType);
            localObject3 = localObject1;
            if (localBankcard.gII())
            {
              localObject3 = localObject1;
              if (localBankcard.ONN != null) {
                localObject3 = localBankcard.ONN.GtW;
              }
            }
            localBitmap = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject3));
            com.tencent.mm.platformtools.u.a(new u.a()
            {
              public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
              {
                AppMethodBeat.i(194087);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(66427);
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, WalletOfflineCoinPurseUI.32.1.this.GFU });
                    if (WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this).containsKey(paramAnonymous2String))
                    {
                      int i = ((Integer)WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this).get(paramAnonymous2String)).intValue();
                      if (WalletOfflineCoinPurseUI.32.1.this.ErT.getItem(i) != null)
                      {
                        WalletOfflineCoinPurseUI.32.1.this.ErT.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(paramAnonymous2Bitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false)));
                        if ((WalletOfflineCoinPurseUI.this.isFinishing()) || (WalletOfflineCoinPurseUI.this.isDestroyed()))
                        {
                          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineCoinPurseUI.this.isFinishing() || WalletOfflineCoinPurseUI.this.isDestroyed()：%s，%s", new Object[] { Boolean.valueOf(WalletOfflineCoinPurseUI.this.isFinishing()), Boolean.valueOf(WalletOfflineCoinPurseUI.this.isDestroyed()) });
                          AppMethodBeat.o(66427);
                          return;
                        }
                        WalletOfflineCoinPurseUI.R(WalletOfflineCoinPurseUI.this).gIa();
                      }
                    }
                    AppMethodBeat.o(66427);
                  }
                });
                AppMethodBeat.o(194087);
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
                ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.plugin.wallet_core.ui.r(new r.a()
                {
                  public final void ed(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(255829);
                    com.tencent.mm.wallet_core.ui.g.bA(WalletOfflineCoinPurseUI.this.getContext(), localBankcard.field_prompt_info_jump_url);
                    com.tencent.mm.plugin.report.service.h.IzE.a(20216, new Object[] { Integer.valueOf(3), localBankcard.field_prompt_info_jump_url });
                    AppMethodBeat.o(255829);
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
            if (((localBankcard.gIH()) || (localBankcard.gII())) && (localBankcard.OND >= 0.0D))
            {
              str = localBankcard.field_desc + WalletOfflineCoinPurseUI.this.getString(a.i.wallet_balance_left, new Object[] { com.tencent.mm.wallet_core.ui.g.F(localBankcard.OND) });
              localObject2 = null;
              if (!localBankcard.gIL()) {
                break label710;
              }
              localObject2 = com.tencent.mm.svg.a.a.h(WalletOfflineCoinPurseUI.this.getResources(), a.h.honey_pay_bank_logo);
              if (localObject2 == null) {
                WalletOfflineCoinPurseUI.Q(WalletOfflineCoinPurseUI.this).put(localObject3, Integer.valueOf(i));
              }
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "can choose list：i %d fee %s %s，status:%s", new Object[] { Integer.valueOf(i), str, localObject1, Integer.valueOf(localBankcard.field_defaultCardState) });
              if (!localBankcard.gIM()) {
                break label776;
              }
              localObject3 = l.c(WalletOfflineCoinPurseUI.this.getContext(), str);
              if (Util.isNullOrNil((String)localObject4))
              {
                if (!Util.isNullOrNil(localBankcard.OOb)) {
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
              paramAnonymouso.a(i, (CharSequence)localObject3, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
              i += 1;
              break;
              localObject1 = localBankcard.field_no_micro_word;
              break label180;
              localObject4 = (String)localObject1 + " ";
              localObject1 = new SpannableStringBuilder((String)localObject4 + localBankcard.field_forbid_title);
              localObject2 = new com.tencent.mm.plugin.wallet_core.ui.m(WalletOfflineCoinPurseUI.this)
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(66429);
                  paramAnonymous2View = localBankcard.field_forbid_url;
                  if ((localBankcard.gIM()) && (Util.isNullOrNil(paramAnonymous2View)))
                  {
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand");
                    paramAnonymous2View = new xw();
                    paramAnonymous2View.fWN.userName = localBankcard.Ooe;
                    paramAnonymous2View.fWN.fWP = localBankcard.Oof;
                    paramAnonymous2View.fWN.scene = 1137;
                    paramAnonymous2View.fWN.fWQ = 0;
                    EventCenter.instance.publish(paramAnonymous2View);
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand result:%s", new Object[] { Boolean.valueOf(paramAnonymous2View.fWO.fXi) });
                    if (paramAnonymous2View.fWO.fXi)
                    {
                      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, 1);
                      WalletOfflineCoinPurseUI.R(WalletOfflineCoinPurseUI.this).tZx.bYF();
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
                  localIntent.putExtra("geta8key_username", z.bcZ());
                  localIntent.putExtra("pay_channel", 1);
                  com.tencent.mm.wallet_core.ui.g.aJ(WalletOfflineCoinPurseUI.this.getContext(), localIntent);
                  AppMethodBeat.o(66429);
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
              localObject1 = localBankcard.OOb;
              break label519;
            }
            localObject3 = l.c(WalletOfflineCoinPurseUI.this.getContext(), str);
            if (!Util.isNullOrNil((String)localObject4)) {}
            for (bool = true;; bool = false)
            {
              paramAnonymouso.a(i, (CharSequence)localObject3, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
              break;
            }
            AppMethodBeat.o(276102);
            return;
          }
        }
      };
      this.GEV.a(new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(262272);
          if (WalletOfflineCoinPurseUI.R(WalletOfflineCoinPurseUI.this) != null)
          {
            WalletOfflineCoinPurseUI.R(WalletOfflineCoinPurseUI.this).tZx.bYF();
            Bankcard localBankcard = (Bankcard)localArrayList.get(WalletOfflineCoinPurseUI.R(WalletOfflineCoinPurseUI.this).mBE);
            com.tencent.mm.plugin.report.service.h.IzE.a(14515, new Object[] { Integer.valueOf(3) });
            if ((!Util.isNullOrNil(localBankcard.field_forbid_title)) || (!Util.isNullOrNil(localBankcard.field_forbidWord)) || (!localBankcard.field_support_micropay)) {
              com.tencent.mm.plugin.report.service.h.IzE.a(14515, new Object[] { Integer.valueOf(4) });
            }
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click mmBottomSheet card：%s,status：%s", new Object[] { localBankcard.field_bindSerial, Integer.valueOf(localBankcard.field_defaultCardState) });
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, localBankcard);
            if ((localBankcard != null) && (localBankcard.gIM()))
            {
              WalletOfflineCoinPurseUI.z(WalletOfflineCoinPurseUI.this);
              WalletOfflineCoinPurseUI.aaO(3);
            }
          }
          AppMethodBeat.o(262272);
        }
      });
      localObject = View.inflate(this, a.g.wallet_offline_coin_bankcard_header, null);
      com.tencent.mm.wallet_core.ui.g.N((TextView)((View)localObject).findViewById(a.f.offline_select_bankcard_title));
      ((View)localObject).findViewById(a.f.offline_header_close_icon_iv).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187541);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (WalletOfflineCoinPurseUI.R(WalletOfflineCoinPurseUI.this) != null) {
            WalletOfflineCoinPurseUI.R(WalletOfflineCoinPurseUI.this).tZx.bYF();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(187541);
        }
      });
      this.GEV.OEb = true;
      this.GEV.ah(getResources().getString(a.i.wallet_dialog_confirm));
      this.GEV.mBE = j;
      this.GEV.OEc = true;
      this.GEV.setTitleView((View)localObject);
      this.GEV.eik();
      com.tencent.mm.plugin.report.service.h.IzE.a(13955, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(66508);
      return;
    }
  }
  
  private void vO(boolean paramBoolean)
  {
    AppMethodBeat.i(276250);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "resetDefaultBankcard");
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.flP();
    if (localBankcard != null)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "newCard : %s，oldCard：：%s", new Object[] { localBankcard.field_bindSerial, this.GBp });
      com.tencent.mm.plugin.offline.c.a.aTG(localBankcard.field_bindSerial);
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.fkV().GBp = localBankcard.field_bindSerial;
      if (paramBoolean)
      {
        a(localBankcard);
        if (flH())
        {
          aaN(8);
          this.GEY = true;
          AppMethodBeat.o(276250);
          return;
        }
        this.GEY = false;
        AppMethodBeat.o(276250);
      }
    }
    else
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "get bankcard fail");
    }
    AppMethodBeat.o(276250);
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
    flt();
    this.GFc.dismiss();
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msgtype：%s，mBindSerial：%s", new Object[] { Integer.valueOf(paramc.GDo), this.GBp });
    int i;
    if (4 == paramc.GDo)
    {
      this.GEM = false;
      i = 0;
    }
    for (;;)
    {
      c localc = this.GFd;
      if (paramc == null) {
        Log.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
      }
      for (;;)
      {
        if ((this.GEP) && (!this.GEQ))
        {
          this.GEP = false;
          this.GEM = false;
        }
        if (i != 0)
        {
          aaM(0);
          vM(true);
        }
        AppMethodBeat.o(66491);
        return true;
        if (5 == paramc.GDo)
        {
          this.GEM = true;
          this.GEP = true;
          this.GEQ = false;
          if (this.GFE.stopped()) {
            break label442;
          }
          this.GFE.stopTimer();
          i = 0;
          break;
        }
        if (6 == paramc.GDo)
        {
          if (!this.GFE.stopped()) {
            this.GFE.stopTimer();
          }
          if (!this.GBW.stopped()) {
            this.GBW.stopTimer();
          }
          this.GEM = false;
          if (!com.tencent.mm.plugin.offline.c.a.flO()) {
            break label1600;
          }
          i = 0;
          break;
        }
        if (8 == paramc.GDo)
        {
          if (this.GFE.stopped()) {
            break label1600;
          }
          this.GFE.stopTimer();
          i = 1;
          break;
        }
        if (23 == paramc.GDo)
        {
          this.GFo = false;
          this.GFn = true;
          if (this.GFE.stopped()) {
            break label442;
          }
          this.GFE.stopTimer();
          i = 0;
          break;
        }
        if (20 == paramc.GDo)
        {
          this.GEM = false;
          if (this.GFE.stopped()) {
            break label442;
          }
          this.GFE.stopTimer();
          i = 0;
          break;
        }
        if (24 != paramc.GDo) {
          break label1600;
        }
        if (com.tencent.mm.plugin.offline.c.a.fmp())
        {
          if (flH())
          {
            if (!this.GEY) {
              break label447;
            }
            aaN(10);
          }
          label393:
          this.GEM = true;
          if (com.tencent.mm.plugin.offline.c.a.fmp())
          {
            if (this.mTipDialog != null) {
              break label470;
            }
            this.mTipDialog = com.tencent.mm.wallet_core.ui.i.a(getContext(), false, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(242443);
                WalletOfflineCoinPurseUI.I(WalletOfflineCoinPurseUI.this);
                AppMethodBeat.o(242443);
              }
            });
          }
        }
        for (;;)
        {
          this.GFE.startTimer(com.tencent.mm.plugin.offline.g.fkM());
          label442:
          i = 0;
          break;
          label447:
          if (this.GEZ)
          {
            aaN(11);
            break label393;
          }
          aaN(12);
          break label393;
          label470:
          if (!this.mTipDialog.isShowing()) {
            this.mTipDialog.show();
          }
        }
        Log.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + paramc.GDo);
        if (paramc.GDo == 24) {
          localc.rqC.vibrate(50L);
        }
        if (4 == paramc.GDo)
        {
          localc.a((s.b)paramc);
          com.tencent.mm.plugin.offline.g.fkN();
        }
        else
        {
          if (5 == paramc.GDo)
          {
            paramc = (s.e)paramc;
            if (paramc != null)
            {
              Log.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + paramc.GDr + " msg.wxRetMsg:" + paramc.GDs + " msg.cftRetCode:" + paramc.GDr + " msg.cftRetMsg:" + paramc.GDq);
              if ((!TextUtils.isEmpty(paramc.GDr)) || (!TextUtils.isEmpty(paramc.GDs)) || (!TextUtils.isEmpty(paramc.GDp)) || (!TextUtils.isEmpty(paramc.GDq)))
              {
                if ((!TextUtils.isEmpty(paramc.GDr)) || (!TextUtils.isEmpty(paramc.GDs)) || (TextUtils.isEmpty(paramc.GDp)) || (TextUtils.isEmpty(paramc.GDq))) {
                  break label751;
                }
                b.i(localc.mActivity, paramc.GDq);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.offline.g.fkN();
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 0L, 1L, true);
              break;
              label751:
              if ((!TextUtils.isEmpty(paramc.GDr)) && (com.tencent.mm.plugin.offline.c.a.isNumeric(paramc.GDr))) {
                localc.a(null, Util.getInt(paramc.GDr, 0), paramc.GDs, paramc.GDt);
              } else {
                b.i(localc.mActivity, paramc.GDs);
              }
            }
          }
          Object localObject1;
          if (6 == paramc.GDo)
          {
            paramc = (s.f)paramc;
            int j;
            if (paramc != null)
            {
              Log.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + paramc.GDv);
              com.tencent.mm.plugin.offline.k.fkT();
              localObject1 = com.tencent.mm.plugin.offline.k.fkX().aTA(paramc.GDw.fwv);
              if (localObject1 == null) {
                break label989;
              }
              if (((com.tencent.mm.plugin.offline.a.r)localObject1).field_status != com.tencent.mm.plugin.offline.g.GBC) {
                break label984;
              }
              j = 1;
            }
            for (;;)
            {
              if (j == 0)
              {
                com.tencent.mm.plugin.offline.g.fz(paramc.GDw.fwv, com.tencent.mm.plugin.offline.g.GBC);
                com.tencent.mm.plugin.offline.c.a.a(localc.mActivity, paramc);
                localc.mActivity.setResult(-1);
                localc.mActivity.finish();
              }
              com.tencent.mm.plugin.offline.g.fkN();
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 7L, 1L, true);
              if (com.tencent.mm.plugin.offline.c.a.GGt != 4) {
                break;
              }
              Log.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
              com.tencent.mm.plugin.report.service.h.IzE.a(13412, new Object[0]);
              break;
              label984:
              j = 0;
              continue;
              label989:
              j = 0;
            }
          }
          Object localObject2;
          Object localObject3;
          if (8 == paramc.GDo)
          {
            paramc = (s.g)paramc;
            Log.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + paramc.id);
            if (paramc.ufc == 0)
            {
              localObject1 = localc.mActivity.getLayoutInflater().inflate(a.g.wallet_offline_payconfirm_layout, null);
              localObject2 = (TextView)((View)localObject1).findViewById(a.f.pay_fee);
              localObject3 = (TextView)((View)localObject1).findViewById(a.f.pay_good_name);
              ((TextView)localObject2).setText(paramc.GDy);
              ((TextView)localObject3).setText(paramc.GDx);
              com.tencent.mm.plugin.offline.g.fz(paramc.fHb, com.tencent.mm.plugin.offline.g.GBE);
              com.tencent.mm.ui.base.h.a(localc.mActivity, "", (View)localObject1, localc.getString(a.i.wallet_wx_offline_pay_confirm_enter), localc.getString(a.i.app_cancel), new c.11(localc, paramc), new c.12(localc, paramc));
            }
            else if (paramc.ufc == 1)
            {
              if (localc.GDT != null) {
                localc.GDT.show();
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(13955, new Object[] { Integer.valueOf(1) });
              Log.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + paramc.id);
              com.tencent.mm.plugin.offline.g.fz(paramc.fHb, com.tencent.mm.plugin.offline.g.GBE);
              localc.GDT = com.tencent.mm.plugin.wallet_core.ui.t.a(localc.mActivity, paramc.GDx, paramc.GDy, new c.13(localc, paramc), new c.14(localc), new c.15(localc, paramc));
              localc.GDT.IPM.setVisibility(0);
              localc.GDT.Isv.setVisibility(8);
            }
          }
          else
          {
            if (23 == paramc.GDo)
            {
              paramc = (s.d)paramc;
              localObject1 = new PayInfo();
              ((PayInfo)localObject1).fwv = paramc.fHb;
              ((PayInfo)localObject1).fOY = 8;
              ((PayInfo)localObject1).Rzn = 1;
              ((PayInfo)localObject1).lfu = new Bundle();
              ((PayInfo)localObject1).lfu.putLong("extinfo_key_9", System.currentTimeMillis());
              com.tencent.mm.wallet_core.b.iie();
              boolean bool2 = com.tencent.mm.wallet_core.b.b(b.a.vCG, true);
              boolean bool1 = bool2;
              if (bool2)
              {
                com.tencent.mm.wallet_core.b.iie();
                bool1 = com.tencent.mm.wallet_core.b.b(b.a.vHf, false);
              }
              if (bool1)
              {
                localObject2 = (com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class);
                localObject3 = localc.mActivity;
                String str = ((PayInfo)localObject1).fwv;
                if (localc.GDS == null) {}
                for (paramc = "";; paramc = localc.GDS.fle())
                {
                  ((com.tencent.mm.pluginsdk.wallet.a)localObject2).startOfflinePay((Context)localObject3, str, paramc, ((PayInfo)localObject1).channel);
                  break;
                }
              }
              paramc = new c.1(localc, (PayInfo)localObject1);
              EventCenter.instance.add(paramc);
              localObject2 = localc.mActivity;
              if (localc.GDS == null) {}
              for (paramc = "";; paramc = localc.GDS.fle())
              {
                com.tencent.mm.pluginsdk.wallet.f.a((Context)localObject2, false, "", paramc, (PayInfo)localObject1, "", new Intent(), 1);
                break;
              }
            }
            if (20 == paramc.GDo) {
              com.tencent.mm.plugin.offline.g.fkN();
            }
          }
        }
      }
      label1600:
      i = 1;
    }
  }
  
  public void addDialog(Dialog paramDialog)
  {
    AppMethodBeat.i(66492);
    if (((paramDialog instanceof com.tencent.mm.ui.widget.a.d)) && (this.GEP))
    {
      this.GEQ = true;
      paramDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(275005);
          if (this.GFQ != null) {
            this.GFQ.onDismiss(paramAnonymousDialogInterface);
          }
          if (WalletOfflineCoinPurseUI.E(WalletOfflineCoinPurseUI.this))
          {
            WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.F(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.G(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.H(WalletOfflineCoinPurseUI.this);
          }
          AppMethodBeat.o(275005);
        }
      });
    }
    super.addDialog(paramDialog);
    AppMethodBeat.o(66492);
  }
  
  public final void cGM()
  {
    AppMethodBeat.i(66512);
    aaM(0);
    vM(true);
    AppMethodBeat.o(66512);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public final void f(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66513);
    doSceneProgress(new com.tencent.mm.plugin.offline.a.e(paramInt, paramString1, paramString2, paramString3), com.tencent.mm.plugin.offline.c.a.flO());
    AppMethodBeat.o(66513);
  }
  
  public final void flB()
  {
    AppMethodBeat.i(66505);
    this.GEw.setVisibility(4);
    this.GFe.b(this.GEo, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(275897);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.offline.c.a.fma();
        com.tencent.mm.plugin.offline.c.a.l(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this));
        WalletOfflineCoinPurseUI.this.getWindow().getDecorView().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(271244);
            WalletOfflineCoinPurseUI.this.finish();
            AppMethodBeat.o(271244);
          }
        }, 300L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(275897);
      }
    });
    AppMethodBeat.o(66505);
  }
  
  public final void flc()
  {
    AppMethodBeat.i(66514);
    vN(false);
    AppMethodBeat.o(66514);
  }
  
  public final void fld()
  {
    AppMethodBeat.i(66515);
    doSceneProgress(new j(""), false);
    AppMethodBeat.o(66515);
  }
  
  public final String fle()
  {
    return this.GBp;
  }
  
  public final void flf()
  {
    AppMethodBeat.i(66518);
    if (!this.GBW.stopped()) {
      this.GBW.stopTimer();
    }
    aaM(0);
    vM(true);
    this.GEM = false;
    this.GBW.startTimer(this.GBV);
    AppMethodBeat.o(66518);
  }
  
  public final void flu()
  {
    int j = 0;
    AppMethodBeat.i(66498);
    Bankcard localBankcard = com.tencent.mm.plugin.offline.c.a.flQ();
    findViewById(a.f.wallet_wx_offline_change_bankcard_tip).setVisibility(0);
    this.GEu.setTextSize(0, getResources().getDimensionPixelSize(a.d.NormalTextSize));
    String str;
    Object localObject;
    if ((this.GEu != null) && (localBankcard != null)) {
      if (localBankcard.gIM())
      {
        str = localBankcard.ONZ;
        localObject = com.tencent.mm.plugin.wallet_core.model.u.gJo().gKl();
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
        } while (!((com.tencent.mm.plugin.wallet_core.model.c)localObject).GGC.equals(localBankcard.field_bindSerial));
      }
    }
    for (;;)
    {
      if ((localObject != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.wallet_core.model.c)localObject).ONo)))
      {
        if (!localBankcard.gIM()) {
          str = localBankcard.field_desc + ((com.tencent.mm.plugin.wallet_core.model.c)localObject).ONo;
        }
        findViewById(a.f.wallet_wx_offline_change_bankcard_tip).setVisibility(8);
        com.tencent.mm.plugin.report.service.h.IzE.a(14515, new Object[] { Integer.valueOf(2) });
        this.GEu.setTextSize(0, getResources().getDimensionPixelSize(a.d.HintTextSize));
      }
      for (int i = 1;; i = 0)
      {
        this.GEu.setText(l.b(getContext(), str, this.GEu.getTextSize()));
        for (;;)
        {
          if (localBankcard != null) {
            b(localBankcard);
          }
          if (i != 0)
          {
            this.GEv.setEnableColorFilter(true);
            this.GEv.setIconColor(Color.parseColor("#FA9D3B"));
            this.GEv.setImageResource(a.h.icons_filled_error);
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
      label368:
      localObject = null;
    }
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
  
  public void initView()
  {
    AppMethodBeat.i(66477);
    this.GFe = ((OfflineAlertView)findViewById(a.f.offline_alert_view));
    this.GFe.dismiss();
    this.GFe.setDialogState(new OfflineAlertView.a()
    {
      public final void onClose()
      {
        AppMethodBeat.i(272601);
        WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this);
        AppMethodBeat.o(272601);
      }
      
      public final void onShow()
      {
        AppMethodBeat.i(272602);
        WalletOfflineCoinPurseUI.j(WalletOfflineCoinPurseUI.this);
        AppMethodBeat.o(272602);
      }
    });
    com.tencent.mm.wallet_core.c.b.iiL().init(getApplicationContext());
    Object localObject;
    if ((this.mEntryScene == 3) || (this.mEntryScene == 10) || (this.mEntryScene == 11) || (this.mEntryScene == 12))
    {
      setMMTitle(a.i.wallet_wx_offline_coin_purse_card_title);
      this.GFd = new c(this, this);
      localObject = this.GFd;
      ((c)localObject).rqC = ((Vibrator)((c)localObject).mActivity.getSystemService("vibrator"));
      this.GFc = new com.tencent.mm.wallet_core.ui.c(this, true);
      this.GFc.ijq();
      this.GEo = findViewById(a.f.wallet_qrcode_layout);
      this.GEp = ((ImageView)findViewById(a.f.wallet_qrcode_iv));
      this.GEq = ((ImageView)findViewById(a.f.wallet_barcode_iv));
      this.GEr = ((TextView)findViewById(a.f.wallet_barcode_tv));
      this.GEt = findViewById(a.f.wallet_wx_offline_change_bankcard_layout);
      this.GEu = ((TextView)findViewById(a.f.wallet_wx_offline_change_bankcard_tv));
      this.GEv = ((WeImageView)findViewById(a.f.wallet_wx_offline_bank_logo));
      this.GEw = ((RelativeLayout)findViewById(a.f.wallet_offline_menu_layout));
      this.GEx = ((LinearLayout)findViewById(a.f.wallet_wx_offline_guide_layout));
      this.GEy = ((CdnImageView)findViewById(a.f.wallet_wx_offline_guide_logo_iv));
      this.GEz = ((TextView)findViewById(a.f.wallet_wx_offline_guide_content_tv));
      this.GEA = ((TextView)findViewById(a.f.wallet_wx_offline_guide_button_tv));
      this.GEt.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219393);
          ViewGroup.LayoutParams localLayoutParams = WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this).getLayoutParams();
          if (localLayoutParams != null) {
            WalletOfflineCoinPurseUI.p(WalletOfflineCoinPurseUI.this).setMinimumHeight(localLayoutParams.height);
          }
          AppMethodBeat.o(219393);
        }
      });
      this.GEw.setOnClickListener(new WalletOfflineCoinPurseUI.10(this));
      this.GEp.setOnClickListener(this.nmC);
      this.GEq.setOnClickListener(this.nmC);
      this.GEr.setOnClickListener(this.nmC);
      this.GEt.setClickable(true);
      this.GEt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184848);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click change_bankcard_layout() card：%s", new Object[] { WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this) });
          com.tencent.mm.plugin.report.service.h.IzE.a(14515, new Object[] { Integer.valueOf(1) });
          WalletOfflineCoinPurseUI.r(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.s(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(184848);
        }
      });
      this.mLastTime = System.currentTimeMillis();
      this.GEB = new e();
      this.GEB.eQX();
      com.tencent.mm.plugin.newtips.a.fiO().h(this.GEB);
      this.GEC = new g();
      this.GEC.eQX();
      com.tencent.mm.plugin.newtips.a.fiO().h(this.GEC);
      this.GED = new b();
      this.GED.eQX();
      com.tencent.mm.plugin.newtips.a.fiO().h(this.GED);
      this.GEE = new f();
      this.GEE.eQX();
      com.tencent.mm.plugin.newtips.a.fiO().h(this.GEE);
      this.GEF = new d();
      this.GEF.eQX();
      com.tencent.mm.plugin.newtips.a.fiO().h(this.GEF);
      if ((this.mEntryScene != 3) && (this.mEntryScene != 10) && (this.mEntryScene != 11) && (this.mEntryScene != 12)) {
        break label908;
      }
      this.GEG.setVisibility(8);
      this.GEH.setVisibility(8);
      this.GEI.setVisibility(8);
      this.GEJ.setVisibility(8);
      label629:
      if ((com.tencent.mm.plugin.offline.c.a.flN()) && (c.flh()))
      {
        localObject = this.GFd;
        com.tencent.mm.plugin.offline.k.fkT();
        ((c)localObject).a(com.tencent.mm.plugin.offline.k.fkU().GDh);
      }
      fln();
      am(true, false);
      this.GBW.startTimer(this.GBV);
      if ((com.tencent.mm.plugin.offline.c.a.GGt != 3) || (!com.tencent.mm.plugin.offline.c.a.GGw)) {
        break label1141;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
      int i = com.tencent.mm.plugin.offline.c.a.GGu;
      long l1 = com.tencent.mm.plugin.offline.c.a.GGv;
      long l2 = System.currentTimeMillis();
      long l3 = i * 1000 + l1 - l2;
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i + " beginTime:" + l1 + " now:" + l2 + " interval:" + l3);
      if ((com.tencent.mm.plugin.offline.c.a.GGu <= 0) || (com.tencent.mm.plugin.offline.c.a.GGv <= 0L) || (l3 <= 0L)) {
        break label1129;
      }
      if (!this.GFF.stopped()) {
        this.GFF.stopTimer();
      }
      this.GFF.startTimer(l3);
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
    }
    for (;;)
    {
      flm();
      localObject = new aba();
      ((aba)localObject).gac.scene = "5";
      ((aba)localObject).callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184847);
          if (!Util.isNullOrNil(this.uaN.gad.gae))
          {
            com.tencent.mm.wallet_core.ui.g.a((TextView)WalletOfflineCoinPurseUI.this.findViewById(a.f.banner_tips), this.uaN.gad.gae, this.uaN.gad.content, this.uaN.gad.url);
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
      setMMTitle(a.i.wallet_wx_offline_coin_purse_title);
      break;
      label908:
      this.GEJ.setVisibility(0);
      this.GEK.setVisibility(0);
      final boolean bool1 = com.tencent.mm.plugin.newtips.a.g.b(this.GEB);
      final boolean bool2 = com.tencent.mm.plugin.newtips.a.g.b(this.GED);
      final boolean bool3 = com.tencent.mm.plugin.newtips.a.g.b(this.GEE);
      final boolean bool4 = com.tencent.mm.plugin.newtips.a.g.b(this.GEC);
      final boolean bool5 = com.tencent.mm.plugin.newtips.a.g.b(this.GEF);
      if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VsP, Boolean.FALSE)).booleanValue()) {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
      }
      ImageView localImageView;
      for (;;)
      {
        localObject = (TextView)findViewById(a.f.bank_mobile_remit_title);
        localImageView = (ImageView)findViewById(a.f.bank_mobile_remit_icon);
        if (!this.GFi) {
          break label1105;
        }
        ((TextView)localObject).setText(a.i.bank_mobile_remit_title);
        localImageView.setImageResource(a.h.icons_outlined_transfer);
        localImageView.getDrawable().setColorFilter(getResources().getColor(a.c.BW_100_Alpha_0_9), PorterDuff.Mode.SRC_ATOP);
        break;
        getWindow().getDecorView().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(272811);
            ScrollView localScrollView = (ScrollView)WalletOfflineCoinPurseUI.this.findViewById(a.f.offline_root_layout);
            if (localScrollView == null)
            {
              AppMethodBeat.o(272811);
              return;
            }
            int[] arrayOfInt = new int[2];
            localScrollView.getLocationInWindow(arrayOfInt);
            int i = ar.au(WalletOfflineCoinPurseUI.this.getContext()).y;
            int j = i;
            if (ar.av(WalletOfflineCoinPurseUI.this.getContext()))
            {
              Log.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
              j = i - ar.aB(WalletOfflineCoinPurseUI.this.getContext());
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
                localScrollView.scrollBy(0, i);
              }
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsP, Boolean.TRUE);
              AppMethodBeat.o(272811);
              return;
            }
          }
        });
      }
      label1105:
      ((TextView)localObject).setText(a.i.bank_remit_title);
      localImageView.setImageResource(a.h.bank_remit_transfer);
      localImageView.clearColorFilter();
      break label629;
      label1129:
      Log.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
      continue;
      label1141:
      if (com.tencent.mm.plugin.offline.c.a.GGt == 3) {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
      } else {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", new Object[] { Integer.valueOf(com.tencent.mm.plugin.offline.c.a.GGt) });
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
    final ImageView localImageView = (ImageView)this.GEc.get(paramString);
    paramString = (Integer)this.GEd.get(paramString);
    if ((localImageView == null) || (paramString == null))
    {
      AppMethodBeat.o(66496);
      return;
    }
    new MMHandler(getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194119);
        int i = paramString.intValue();
        Bitmap localBitmap = BitmapUtil.extractThumbNail(paramBitmap, i, i, true, false);
        localImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(194119);
      }
    });
    AppMethodBeat.o(66496);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66469);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.wallet_core.model.u.gJi();
    this.GFi = com.tencent.mm.plugin.wallet_core.model.u.gJx();
    com.tencent.mm.plugin.offline.k.GCg = true;
    com.tencent.mm.wallet_core.ui.g.azK(41);
    paramBundle = getIntent();
    this.GEO = paramBundle.getBooleanExtra("is_offline_create", false);
    if ((paramBundle != null) && (paramBundle.hasExtra("key_entry_scene"))) {
      this.mEntryScene = paramBundle.getIntExtra("key_entry_scene", this.mEntryScene);
    }
    this.jaR = paramBundle.getIntExtra("key_from_scene", 0);
    this.GEs = Util.nullAs(paramBundle.getStringExtra("key_business_attach"), "");
    this.wwk = 1;
    if (this.mEntryScene == 2) {
      this.wwk = 1;
    }
    for (;;)
    {
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!WeChatEnvironment.hasDebugger())) {
        getWindow().addFlags(8192);
      }
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
      setContentViewVisibility(0);
      setActionbarColor(getResources().getColor(a.c.UN_Brand_BG_100));
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
          AppMethodBeat.i(275043);
          paramAnonymousMenuItem = new jf();
          paramAnonymousMenuItem.fGv.fGw = "ok";
          EventCenter.instance.publish(paramAnonymousMenuItem);
          if (WalletOfflineCoinPurseUI.f(WalletOfflineCoinPurseUI.this) == 8) {
            com.tencent.mm.plugin.offline.c.a.aTR(WalletOfflineCoinPurseUI.this.getIntent().getStringExtra("key_appid"));
          }
          WalletOfflineCoinPurseUI.this.finish();
          AppMethodBeat.o(275043);
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
        com.tencent.mm.wallet_core.ui.g.ijv();
        com.tencent.mm.plugin.offline.a.q.isEnabled();
        if (com.tencent.mm.plugin.wallet_core.model.u.gJo().gJV())
        {
          Log.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
          initView();
          paramBundle = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VtW, "");
          if (Util.isNullOrNil(paramBundle)) {}
        }
      }
      catch (Exception paramBundle)
      {
        try
        {
          label682:
          do
          {
            for (;;)
            {
              this.GFp = com.tencent.mm.plugin.wallet_core.model.r.bU(new JSONObject(paramBundle));
              com.tencent.mm.platformtools.u.a(this);
              com.tencent.mm.plugin.offline.k.fkT();
              com.tencent.mm.plugin.offline.k.fkU().a(this);
              addSceneEndListener(606);
              addSceneEndListener(609);
              addSceneEndListener(1501);
              addSceneEndListener(580);
              com.tencent.mm.plugin.offline.k.fkT();
              com.tencent.mm.plugin.offline.k.fkV().dP(this);
              EventCenter.instance.addListener(this.GFC);
              com.tencent.mm.plugin.offline.c.a.fmb();
              EventCenter.instance.add(this.GFA);
              EventCenter.instance.add(this.GFy);
              EventCenter.instance.add(this.GFt);
              EventCenter.instance.add(this.GFu);
              this.GFv.alive();
              this.GFw.alive();
              this.GFx.alive();
              this.GEN = new com.tencent.mm.plugin.offline.g();
              paramBundle = new pc();
              paramBundle.fNW.aNf = hashCode();
              EventCenter.instance.publish(paramBundle);
              this.GFz.alive();
              AppMethodBeat.o(66469);
              return;
              if (this.mEntryScene == 1)
              {
                this.wwk = 2;
                break;
              }
              if (this.mEntryScene == 8)
              {
                this.wwk = 4;
                break;
              }
              if (this.mEntryScene == 4)
              {
                this.wwk = 6;
                break;
              }
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", new Object[] { Integer.valueOf(this.wwk) });
              break;
              paramBundle = paramBundle;
              Log.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", paramBundle, "", new Object[0]);
              getWindow().setFlags(8192, 8192);
              int i = 0;
              continue;
              if (!com.tencent.mm.plugin.wallet_core.model.u.gJo().gJS()) {
                break label682;
              }
              Log.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
              com.tencent.mm.plugin.offline.c.a.fma();
              com.tencent.mm.plugin.offline.k.fkT();
              com.tencent.mm.plugin.offline.k.bL(196648, "0");
            }
          } while ((!com.tencent.mm.plugin.wallet_core.model.u.gJo().gJQ()) || (!com.tencent.mm.plugin.offline.c.a.flN()));
          flF();
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
    Object localObject = com.tencent.mm.plugin.offline.c.a.flQ();
    if (localObject != null)
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerial:%s serial:%s mLastBindSerial:%s", new Object[] { this.GBp, ((Bankcard)localObject).field_bindSerial, this.GEn });
      if (!ag.g((Bankcard)localObject)) {
        break label426;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onDestory：do set as default card");
    }
    for (;;)
    {
      this.GFe.dismiss();
      com.tencent.mm.plugin.offline.k.GCg = false;
      com.tencent.mm.wallet_core.ui.g.X(this.GEe);
      com.tencent.mm.wallet_core.ui.g.X(this.GEf);
      com.tencent.mm.wallet_core.ui.g.bJ(this.GFa);
      com.tencent.mm.wallet_core.ui.g.bJ(this.GFb);
      this.GFa.clear();
      this.GFb.clear();
      this.GEj.clear();
      this.GEk.clear();
      this.GEl.clear();
      com.tencent.mm.platformtools.u.c(this);
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.fkU().b(this);
      removeSceneEndListener(606);
      removeSceneEndListener(609);
      removeSceneEndListener(1501);
      removeSceneEndListener(580);
      com.tencent.mm.plugin.offline.k.fkT();
      com.tencent.mm.plugin.offline.k.fkV().dQ(this);
      EventCenter.instance.removeListener(this.GFC);
      EventCenter.instance.removeListener(this.GFA);
      EventCenter.instance.removeListener(this.GFt);
      EventCenter.instance.removeListener(this.GFu);
      if (!this.GBW.stopped()) {
        this.GBW.stopTimer();
      }
      if (!this.GFF.stopped()) {
        this.GFF.stopTimer();
      }
      if (!this.GFE.stopped()) {
        this.GFE.stopTimer();
      }
      if (this.GFc != null) {
        this.GFc.release();
      }
      if (this.GFd != null)
      {
        localObject = this.GFd;
        ((c)localObject).rqC.cancel();
        ((c)localObject).mActivity = null;
      }
      EventCenter.instance.removeListener(this.GFy);
      this.GFw.dead();
      this.GFx.dead();
      localObject = this.GEN;
      ((com.tencent.mm.plugin.offline.g)localObject).stop();
      com.tencent.mm.plugin.offline.g.fkN();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(385, ((com.tencent.mm.plugin.offline.g)localObject).GBG);
      ((com.tencent.mm.plugin.offline.g)localObject).GBI = null;
      this.GFz.dead();
      this.GFv.dead();
      com.tencent.mm.plugin.remittance.mobile.a.b.acN(0);
      super.onDestroy();
      AppMethodBeat.o(66475);
      return;
      label426:
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onDestory：do not set as default card");
      vO(false);
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66517);
    if ((paramInt == 4) && (this.GFe != null) && (this.GFe.getVisibility() == 0) && (this.GFe.GDB))
    {
      this.GFe.dismiss();
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
    this.GEh = true;
    AppMethodBeat.o(66473);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66474);
    com.tencent.mm.plugin.offline.k.fkT();
    com.tencent.mm.plugin.offline.i locali = com.tencent.mm.plugin.offline.k.fkW();
    locali.mHandler.removeCallbacks(locali.GBU);
    ScreenShotUtil.setScreenShotCallback(this, null);
    this.mIsForeground = false;
    EventCenter.instance.removeListener(this.GFB);
    this.GEN.stop();
    super.onPause();
    AppMethodBeat.o(66474);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66471);
    super.onResume();
    EventCenter.instance.addListener(this.GFB);
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, this);
      if (!this.GFf)
      {
        flj();
        this.GFf = true;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
      this.mIsForeground = true;
      Object localObject = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class);
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).a(this, ((com.tencent.mm.plugin.walletlock.a.b)localObject).gNk(), null);
      if (NetStatusUtil.isNetworkConnected(getBaseContext()))
      {
        if (com.tencent.mm.plugin.wallet_core.model.u.gJo().gJV()) {
          doSceneForceProgress(new ae(null, 8));
        }
        if ((com.tencent.mm.plugin.offline.c.a.flN()) && (this.GFm))
        {
          com.tencent.mm.plugin.offline.k.fkT();
          com.tencent.mm.plugin.offline.k.fkW().vL(false);
          if (!c.flh())
          {
            com.tencent.mm.plugin.offline.a.q.isEnabled();
            if (!this.GEX) {
              break label467;
            }
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do not doNetSceneUserBindQuery()");
            this.GEX = false;
          }
        }
      }
      if (!this.GFm) {
        this.GFm = true;
      }
      fln();
      localObject = com.tencent.mm.plugin.offline.c.a.flQ();
      if ((localObject != null) && (((Bankcard)localObject).field_bindSerial != null) && (!((Bankcard)localObject).field_bindSerial.equals(this.GBp)))
      {
        this.GBp = ((Bankcard)localObject).field_bindSerial;
        com.tencent.mm.plugin.offline.k.fkT();
        com.tencent.mm.plugin.offline.k.fkV().GBp = this.GBp;
        i = 1;
        if ((i != 0) || ((this.GEi) && (this.GEh)))
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
          this.GEi = false;
          this.GEh = false;
          flu();
          aaM(0);
          vM(true);
        }
        localObject = this.GEN;
        if (!com.tencent.mm.plugin.offline.c.a.fmp()) {
          break label585;
        }
        Log.i(com.tencent.mm.plugin.offline.g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + ((com.tencent.mm.plugin.offline.g)localObject).GBI.stopped());
        if ((((com.tencent.mm.plugin.offline.g)localObject).GBI == null) || (((com.tencent.mm.plugin.offline.g)localObject).GBI.stopped()))
        {
          ((com.tencent.mm.plugin.offline.g)localObject).status = 1;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 61L, 1L, true);
          if (!((com.tencent.mm.plugin.offline.g)localObject).GBH) {
            break label567;
          }
          com.tencent.mm.plugin.offline.g.fkN();
          ((com.tencent.mm.plugin.offline.g)localObject).GBI.startTimer(com.tencent.mm.plugin.offline.g.GBs);
          i = com.tencent.mm.plugin.offline.g.GBs;
        }
        if (this.GFk)
        {
          this.GFk = false;
          com.tencent.mm.plugin.report.service.h.IzE.a(18930, new Object[] { Integer.valueOf(this.GFl), Integer.valueOf(4) });
        }
        this.GFq = false;
        this.GFr = false;
        AppMethodBeat.o(66471);
      }
    }
    catch (Exception localException)
    {
      label567:
      label585:
      for (;;)
      {
        int i;
        Log.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", localException, "", new Object[0]);
        continue;
        label467:
        if (this.GFo)
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "callbackFromKinda，do not doSceneUserBindQuery");
          this.GFo = false;
          this.GFn = false;
        }
        else if (this.GFn)
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "is paying in kinda，do not doSceneUserBindQuery");
        }
        else
        {
          com.tencent.mm.plugin.offline.a.q localq = new com.tencent.mm.plugin.offline.a.q(this.mEntryScene, this.eventId, this.GFj, this.GEW);
          this.GEW = 0;
          doSceneProgress(localq, false);
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do doNetSceneUserBindQuery()");
          continue;
          i = 0;
          continue;
          localq.GBI.startTimer(com.tencent.mm.plugin.offline.g.GBF);
          i = com.tencent.mm.plugin.offline.g.GBF;
          continue;
          Log.i(com.tencent.mm.plugin.offline.g.TAG, "OfflineGetMsg is not in abtest");
        }
      }
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(66476);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " scene: " + paramq);
    if (((paramq instanceof com.tencent.mm.plugin.offline.a.f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.GBT.fkY();
      this.GBT = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof ae))
      {
        if (this.GFg)
        {
          this.GFg = false;
          paramString = com.tencent.mm.plugin.offline.c.a.flR();
          if (paramString != null) {
            doSceneForceProgress(new com.tencent.mm.plugin.offline.a.k(paramString, this.GFh, 0));
          }
          AppMethodBeat.o(66476);
          return true;
        }
        if (com.tencent.mm.plugin.offline.c.a.flN())
        {
          if (com.tencent.mm.plugin.offline.c.a.vP(false) != null) {
            doSceneProgress(new n(System.currentTimeMillis(), this.mEntryScene), false);
          }
          flF();
        }
        paramString = ((ae)paramq).OIy;
        if ((paramString == null) || (paramString.OQr == 0))
        {
          if (this.GFe.GDA == 7) {
            this.GFe.dismiss();
          }
          this.GFp = ((ae)paramq).OIz;
          flC();
          flE();
          label289:
          if ((!(paramq instanceof ae)) && (!(paramq instanceof n)) && (!(paramq instanceof com.tencent.mm.plugin.offline.a.a)) && (!(paramq instanceof com.tencent.mm.plugin.offline.a.e))) {
            break label1543;
          }
          if ((paramq instanceof ae))
          {
            if ((!this.GFr) && (!this.GFq)) {
              break label1535;
            }
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hasClickFQFGuideBar || hasClickChangeBankcardLayout，dont resetDefaultBankcard");
          }
          label352:
          fln();
          am(false, true);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66476);
      return true;
      if (!this.GFe.aaL(7)) {
        break;
      }
      if (this.GFe.GDA == 7) {
        this.GFe.dismiss();
      }
      this.GFl = paramString.OQq;
      Object localObject1 = this.GFe;
      View localView = this.GEo;
      Object localObject2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(264269);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do click fqf text link");
          WalletOfflineCoinPurseUI.O(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.P(WalletOfflineCoinPurseUI.this);
          WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this, "weixin://wcpay/fqf/opentinyapp");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(264269);
        }
      };
      com.tencent.mm.plugin.report.service.h.IzE.a(18930, new Object[] { Integer.valueOf(paramString.OQq), Integer.valueOf(1) });
      ((OfflineAlertView)localObject1).GDA = 7;
      ((OfflineAlertView)localObject1).setVisibility(0);
      ((OfflineAlertView)localObject1).GDB = false;
      ((OfflineAlertView)localObject1).mCC.removeAllViews();
      Object localObject3 = LayoutInflater.from(((OfflineAlertView)localObject1).getContext()).inflate(a.g.wallet_offline_installment_overdue_layout, ((OfflineAlertView)localObject1).mCC, false);
      ((OfflineAlertView)localObject1).mCC.addView((View)localObject3);
      Object localObject4 = (TextView)((View)localObject3).findViewById(a.f.main_title_tv);
      TextView localTextView = (TextView)((View)localObject3).findViewById(a.f.sub_title_tv);
      localObject3 = (Button)((View)localObject3).findViewById(a.f.i_know_btn);
      if (!Util.isNullOrNil(paramString.OQt)) {
        ((TextView)localObject4).setText(paramString.OQt);
      }
      if (!Util.isNullOrNil(paramString.OQu))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("repayment_tiny_app_username", paramString.OQv);
        ((Bundle)localObject4).putString("repayment_tiny_app_path", paramString.OQw);
        localTextView.setText(paramString.OQu);
        l.a(localTextView, false, localObject4);
        if (((OfflineAlertView)localObject1).sCG != null) {
          l.b(((OfflineAlertView)localObject1).sCG);
        }
        ((OfflineAlertView)localObject1).sCG = new OfflineAlertView.6((OfflineAlertView)localObject1, (View.OnClickListener)localObject2, paramString);
        l.a(((OfflineAlertView)localObject1).sCG);
      }
      if (paramString.OQs > 0)
      {
        ((Button)localObject3).setEnabled(false);
        if (((OfflineAlertView)localObject1).GDD == null) {
          break label753;
        }
        ((OfflineAlertView)localObject1).GDD.cancel();
      }
      for (;;)
      {
        ((OfflineAlertView)localObject1).GDD.start();
        ((Button)localObject3).setOnClickListener(new OfflineAlertView.8((OfflineAlertView)localObject1, paramString));
        localView.post(new OfflineAlertView.9((OfflineAlertView)localObject1, localView));
        break;
        label753:
        localObject2 = new com.tencent.mm.wallet_core.c.c();
        ((com.tencent.mm.wallet_core.c.c)localObject2).duration = (paramString.OQs * 1000);
        ((com.tencent.mm.wallet_core.c.c)localObject2).interval = 1000L;
        ((com.tencent.mm.wallet_core.c.c)localObject2).YUN = new OfflineAlertView.7((OfflineAlertView)localObject1, (Button)localObject3);
        ((OfflineAlertView)localObject1).GDD = new com.tencent.mm.wallet_core.c.c.1((com.tencent.mm.wallet_core.c.c)localObject2, ((com.tencent.mm.wallet_core.c.c)localObject2).duration, ((com.tencent.mm.wallet_core.c.c)localObject2).interval);
      }
      if ((paramq instanceof com.tencent.mm.plugin.offline.a.m))
      {
        this.GBT = ((com.tencent.mm.plugin.offline.a.m)paramq);
        paramString = this.GBT.GCW;
        com.tencent.mm.plugin.offline.k.fkT();
        paramString = new com.tencent.mm.plugin.offline.a.f(paramString, com.tencent.mm.plugin.offline.k.aaK(196617));
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
        break label289;
      }
      if ((paramq instanceof j))
      {
        fln();
        flj();
        break label289;
      }
      if ((paramq instanceof n))
      {
        paramString = (n)paramq;
        if ("1".equals(paramString.GDb))
        {
          Log.w("MicroMsg.WalletOfflineCoinPurseUI", "hy: should pause. showFirstPostTip alert to finish");
          if (Util.isNullOrNil(paramString.GDc)) {}
          for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.GDc)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(219115);
                WalletOfflineCoinPurseUI.this.finish();
                AppMethodBeat.o(219115);
              }
            });
            AppMethodBeat.o(66476);
            return true;
          }
        }
        if (paramString.GCv == 0)
        {
          localObject1 = this.GFd;
          ((c)localObject1).GDU = com.tencent.mm.plugin.offline.c.a.flV();
          ((c)localObject1).GDU = ((c)localObject1).GDU;
          if (!"1".equals(paramString.GDa)) {
            break label289;
          }
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: should refresh codes. doscene");
          doSceneProgress(new com.tencent.mm.plugin.offline.a.m((int)(System.currentTimeMillis() / 1000L), 8), false);
          break label289;
        }
        if (paramString.GCv == 0) {
          break label289;
        }
        this.GFd.a(paramString, paramString.GCv, paramString.GCw);
        break label289;
      }
      if ((paramq instanceof com.tencent.mm.plugin.offline.a.a)) {
        break label289;
      }
      if ((paramq instanceof com.tencent.mm.plugin.offline.a.e))
      {
        this.GFd.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
        break label289;
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.i))
      {
        if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
          this.mTipDialog.dismiss();
        }
        paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.i)paramq;
        if (("1".equals(paramString.OLR)) || (("2".equals(paramString.OLR)) && (!Util.isNullOrNil(paramString.OLS))))
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
          if ("collect".equals(paramString.OLV)) {
            flk();
          } else if ("reward".equals(paramString.OLV)) {
            com.tencent.mm.by.c.ad(getContext(), "collect", ".reward.ui.QrRewardMainUI");
          } else {
            Log.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { paramString.OLV });
          }
        }
      }
      if (!(paramq instanceof com.tencent.mm.plugin.offline.a.q)) {
        break label289;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneTenpayWxOfflineUserBindQuery ok");
      paramString = (com.tencent.mm.plugin.offline.a.q)paramq;
      this.GER = true;
      if ((paramString.isJumpRemind()) && (!this.GES && (paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
      {
        public final void eOt() {}
      }))) {
        this.GES = true;
      }
      onSceneEnd(paramString.GDg.errType, paramString.GDg.errCode, paramString.GDg.errMsg, paramString.GDe);
      onSceneEnd(paramString.GDf.errType, paramString.GDf.errCode, paramString.GDf.errMsg, paramString.GDd);
      if ((this.GEV != null) && (this.GEV.tZx.isShowing()) && (this.GEU == 1)) {
        vN(true);
      }
      if (Util.isNullOrNil(this.GEm)) {
        break label289;
      }
      Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerialOperation：%s", new Object[] { this.GEm });
      flG();
      break label289;
      label1535:
      vO(true);
      break label352;
      label1543:
      if ((paramq instanceof com.tencent.mm.plugin.offline.a.f))
      {
        fln();
        am(true, true);
      }
      else if ((paramq instanceof com.tencent.mm.plugin.offline.a.k))
      {
        com.tencent.mm.plugin.offline.c.a.aG(this);
        doSceneProgress(new ae(null, 8), false);
        fly();
        flz();
        flw();
      }
      else if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneCheckPayJsapi ok");
        this.GEx.setVisibility(8);
        com.tencent.mm.plugin.wallet_core.model.u.gJo().c(null);
        if (this.GFs != null)
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end mJsApiOfflineUserBindQueryResultCallBackEventEvent != null");
          paramString = this.GFs;
          if (paramString.fJx.fJE.equals("1"))
          {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "FQF openSuccess");
            aaN(6);
            if (!Util.isNullOrNil(paramString.fJx.fJD))
            {
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "event.data.bindSerial is : %s", new Object[] { paramString.fJx.fJD });
              this.GEm = paramString.fJx.fJD;
            }
            doSceneProgress(new com.tencent.mm.plugin.offline.a.q(this.mEntryScene, this.eventId, "", paramString.fJx.appId, paramString.fJx.fJA), false);
          }
          else
          {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "FQF openfail");
            aaN(7);
            if (this.GFs != null)
            {
              this.GFs.fJy.errMsg = "ok:open fail";
              this.GFs.fJx.callback.run();
              this.GFs = null;
              this.GEm = "";
            }
          }
        }
        else
        {
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneCheckPayJsapi fail");
          continue;
          if ((paramq instanceof n))
          {
            fln();
            am(false, true);
            if (411 == paramInt2) {
              this.GFd.a(paramq, paramInt2, paramString);
            }
          }
          else if ((paramq instanceof com.tencent.mm.plugin.offline.a.e))
          {
            this.GFd.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
          }
          else if (!(paramq instanceof j))
          {
            if ((paramq instanceof com.tencent.mm.plugin.offline.a.f))
            {
              this.GBT = null;
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
              fln();
              am(false, true);
              if (411 == paramInt2) {
                this.GFd.a(paramq, paramInt2, paramString);
              }
              if (this.GFs != null)
              {
                this.GFs.fJy.errMsg = "fail:NetSceneTenpayWxOfflineUserBindQuery";
                this.GFs.fJx.callback.run();
                this.GFs = null;
                this.GEm = "";
              }
            }
            else if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d))
            {
              Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onScene end NetSceneCheckPayJsapi fail");
              if (this.GFs != null)
              {
                this.GFs.fJy.errMsg = "fail:NetSceneCheckPayJsapi";
                this.GFs.fJx.callback.run();
                this.GFs = null;
                this.GEm = "";
              }
            }
          }
        }
      }
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(276236);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
    aaM(1);
    vM(true);
    com.tencent.mm.wallet_core.ui.g.azK(40);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 21L, 1L, true);
    if (this.GFc.nmy.isShowing())
    {
      if (this.GFc.tvI)
      {
        this.GFc.ijs();
        AppMethodBeat.o(276236);
        return;
      }
      this.GFc.dismiss();
    }
    flx();
    AppMethodBeat.o(276236);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  abstract class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    protected TextView GFY;
    protected TextView GFZ;
    protected ImageView GGa;
    
    public a()
    {
      flJ();
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
    }
    
    public final boolean a(boolean paramBoolean, erx paramerx)
    {
      if (paramBoolean)
      {
        this.GGa.setVisibility(0);
        this.GFZ.setVisibility(0);
        this.GFZ.setText(paramerx.title);
      }
      for (;;)
      {
        return true;
        this.GGa.setVisibility(8);
        this.GFZ.setVisibility(8);
      }
    }
    
    public final boolean b(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean eQW()
    {
      return false;
    }
    
    public boolean eQX()
    {
      return false;
    }
    
    public abstract void flJ();
    
    public final boolean tX(boolean paramBoolean)
    {
      return com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
    }
    
    public final boolean tY(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.GGa.setVisibility(0);
      }
      for (;;)
      {
        return true;
        this.GGa.setVisibility(8);
      }
    }
    
    public final boolean tZ(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.GFY.setVisibility(0);
      }
      for (;;)
      {
        return true;
        this.GFY.setVisibility(8);
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
    
    public final boolean eQX()
    {
      AppMethodBeat.i(66444);
      super.eQX();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.aa.c.aFn().b(ar.a.VsK, ar.a.VrG))
      {
        this.GFY.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.GwL, true);
      }
      AppMethodBeat.o(66444);
      return true;
    }
    
    public final void flJ()
    {
      AppMethodBeat.i(66443);
      WalletOfflineCoinPurseUI.c(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(a.f.wallet_offline_aa_btn_layout));
      this.GFY = ((TextView)WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).findViewById(a.f.aa_new_dot));
      this.GFZ = ((TextView)WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).findViewById(a.f.aa_red_wording));
      this.GGa = ((ImageView)WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).findViewById(a.f.aa_red_dot));
      WalletOfflineCoinPurseUI.m(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineAALayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
          com.tencent.mm.plugin.newtips.a.fiO().aap(16);
          com.tencent.mm.plugin.report.service.h.IzE.a(14021, new Object[] { Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.ad(WalletOfflineCoinPurseUI.this)) });
          paramAnonymousView = new Intent();
          if (WalletOfflineCoinPurseUI.f(WalletOfflineCoinPurseUI.this) == 1) {
            paramAnonymousView.putExtra("enter_scene", 2);
          }
          for (;;)
          {
            com.tencent.mm.by.c.b(WalletOfflineCoinPurseUI.this.getContext(), "aa", ".ui.AAEntranceUI", paramAnonymousView);
            WalletOfflineCoinPurseUI.aa(WalletOfflineCoinPurseUI.this);
            if (com.tencent.mm.aa.c.aFn().b(ar.a.VsK, ar.a.VrG))
            {
              com.tencent.mm.aa.c.aFn().c(ar.a.VsK, ar.a.VrG);
              WalletOfflineCoinPurseUI.b.this.GFY.setVisibility(8);
              com.tencent.mm.plugin.report.service.h.IzE.a(14396, new Object[] { Integer.valueOf(4) });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineAALayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66442);
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
  }
  
  final class c
    extends BaseAdapter
  {
    ArrayList<Boolean> GGc;
    ArrayList<String> mDataList;
    
    public c()
    {
      AppMethodBeat.i(66446);
      this.mDataList = new ArrayList();
      this.GGc = new ArrayList();
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
      paramView = (CheckedTextView)View.inflate(WalletOfflineCoinPurseUI.this, a.g.wallet_list_dialog_item_singlechoice, null);
      paramView.setText((String)this.mDataList.get(paramInt));
      if (WalletOfflineCoinPurseUI.flI() == paramInt)
      {
        paramView.setChecked(true);
        if (!isEnabled(paramInt)) {
          break label92;
        }
        paramView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(a.c.normal_text_color));
        paramView.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(66450);
        return paramView;
        paramView.setChecked(false);
        break;
        label92:
        paramView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(a.c.hint_text_color));
        paramView.setEnabled(false);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(66449);
      boolean bool = ((Boolean)this.GGc.get(paramInt)).booleanValue();
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
    
    public final void flJ()
    {
      AppMethodBeat.i(66452);
      WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(a.f.wallet_offline_bank_remit_layout));
      this.GFY = ((TextView)WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).findViewById(a.f.bank_remit_new_dot));
      this.GFZ = ((TextView)WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).findViewById(a.f.bank_remit_red_wording));
      this.GGa = ((ImageView)WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).findViewById(a.f.bank_remit_red_dot));
      WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66451);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineBankRemitLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          WalletOfflineCoinPurseUI.aa(WalletOfflineCoinPurseUI.this);
          paramAnonymousView = new ny();
          paramAnonymousView.gef = 3L;
          paramAnonymousView.bpa();
          com.tencent.mm.plugin.newtips.a.fiO().aap(20);
          com.tencent.mm.plugin.remittance.mobile.a.b.acN(WalletOfflineCoinPurseUI.f(WalletOfflineCoinPurseUI.this));
          if (WalletOfflineCoinPurseUI.af(WalletOfflineCoinPurseUI.this)) {
            com.tencent.mm.by.c.ad(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".mobile.ui.BankMobileRemittanceChooseUI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineBankRemitLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66451);
            return;
            com.tencent.mm.by.c.ad(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
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
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this);
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
    
    public final boolean eQX()
    {
      AppMethodBeat.i(66457);
      super.eQX();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.aa.c.aFn().b(ar.a.VsL, ar.a.VrG))
      {
        com.tencent.mm.kernel.h.aHH();
        String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsa, "");
        if (Util.isNullOrNil(str)) {
          break label98;
        }
        this.GFZ.setText(str);
        this.GFZ.setVisibility(0);
        this.GGa.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.GwM, true);
      }
      for (;;)
      {
        AppMethodBeat.o(66457);
        return true;
        label98:
        this.GFY.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.GwL, true);
      }
    }
    
    public final void flJ()
    {
      AppMethodBeat.i(66456);
      WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(a.f.wallet_offline_collect_btn_layout));
      this.GFY = ((TextView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_recv_new_dot));
      this.GFZ = ((TextView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_recv_red_wording));
      this.GGa = ((ImageView)WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_recv_red_dot));
      WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66455);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          WalletOfflineCoinPurseUI.aa(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.fiO().aap(17);
          if (com.tencent.mm.aa.c.aFn().b(ar.a.VsL, ar.a.VrG))
          {
            com.tencent.mm.aa.c.aFn().c(ar.a.VsL, ar.a.VrG);
            WalletOfflineCoinPurseUI.e.this.GFY.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.GFZ.setVisibility(8);
            WalletOfflineCoinPurseUI.e.this.GGa.setVisibility(8);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsa, "");
            com.tencent.mm.plugin.report.service.h.IzE.a(14396, new Object[] { Integer.valueOf(3) });
          }
          if (com.tencent.mm.plugin.wallet_core.model.u.gJo().gJQ())
          {
            WalletOfflineCoinPurseUI.ab(WalletOfflineCoinPurseUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66455);
            return;
          }
          com.tencent.mm.plugin.wallet_core.model.u.gJi();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          localObject = WalletOfflineCoinPurseUI.ac(WalletOfflineCoinPurseUI.this);
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
                else if (WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this) != null)
                {
                  WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this).dismiss();
                }
              }
            }
          };
          if (!com.tencent.mm.plugin.wallet_core.model.u.b(paramAnonymousView, (com.tencent.mm.wallet_core.d.e)localObject, 1006))
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
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.k(WalletOfflineCoinPurseUI.this);
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
    
    public final boolean eQX()
    {
      AppMethodBeat.i(66461);
      super.eQX();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.aa.c.aFn().b(ar.a.VsM, ar.a.VrG))
      {
        this.GFY.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.GwL, true);
      }
      AppMethodBeat.o(66461);
      return true;
    }
    
    public final void flJ()
    {
      AppMethodBeat.i(66460);
      WalletOfflineCoinPurseUI.d(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(a.f.wallet_offline_f2f_lucky_btn_layout));
      this.GFY = ((TextView)WalletOfflineCoinPurseUI.n(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_hb_new_dot));
      this.GFZ = ((TextView)WalletOfflineCoinPurseUI.n(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_hb_red_wording));
      this.GGa = ((ImageView)WalletOfflineCoinPurseUI.n(WalletOfflineCoinPurseUI.this).findViewById(a.f.f2f_hb_red_dot));
      WalletOfflineCoinPurseUI.n(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66459);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineF2fLuckyLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
          WalletOfflineCoinPurseUI.aa(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.fiO().aap(18);
          com.tencent.mm.plugin.report.service.h.IzE.a(14021, new Object[] { Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.ad(WalletOfflineCoinPurseUI.this)) });
          com.tencent.mm.by.c.ad(WalletOfflineCoinPurseUI.this.getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
          if (com.tencent.mm.aa.c.aFn().b(ar.a.VsM, ar.a.VrG))
          {
            com.tencent.mm.aa.c.aFn().c(ar.a.VsM, ar.a.VrG);
            WalletOfflineCoinPurseUI.f.this.GFY.setVisibility(8);
            com.tencent.mm.plugin.report.service.h.IzE.a(14396, new Object[] { Integer.valueOf(5) });
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
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.n(WalletOfflineCoinPurseUI.this);
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
    
    public final boolean eQX()
    {
      AppMethodBeat.i(66467);
      super.eQX();
      com.tencent.mm.plugin.newtips.a.g.a(this);
      if (com.tencent.mm.aa.c.aFn().b(ar.a.VsN, ar.a.VrG))
      {
        this.GFY.setVisibility(0);
        com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.GwL, true);
      }
      AppMethodBeat.o(66467);
      return true;
    }
    
    public final void flJ()
    {
      AppMethodBeat.i(66465);
      WalletOfflineCoinPurseUI.b(WalletOfflineCoinPurseUI.this, (LinearLayout)WalletOfflineCoinPurseUI.this.findViewById(a.f.wallet_offline_qr_reward_layout));
      this.GFY = ((TextView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(a.f.qr_reward_new_dot));
      this.GFZ = ((TextView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(a.f.qr_reward_red_wording));
      this.GGa = ((ImageView)WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).findViewById(a.f.qr_reward_red_dot));
      WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66464);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
          WalletOfflineCoinPurseUI.aa(WalletOfflineCoinPurseUI.this);
          com.tencent.mm.plugin.newtips.a.fiO().aap(19);
          com.tencent.mm.plugin.report.service.h.IzE.a(14021, new Object[] { Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.ad(WalletOfflineCoinPurseUI.this)) });
          if (com.tencent.mm.aa.c.aFn().b(ar.a.VsN, ar.a.VrG))
          {
            com.tencent.mm.aa.c.aFn().c(ar.a.VsN, ar.a.VrG);
            WalletOfflineCoinPurseUI.g.this.GFY.setVisibility(8);
          }
          if (com.tencent.mm.plugin.wallet_core.model.u.gJo().gJQ())
          {
            com.tencent.mm.by.c.ad(WalletOfflineCoinPurseUI.this.getContext(), "collect", ".reward.ui.QrRewardMainUI");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66464);
            return;
          }
          com.tencent.mm.plugin.wallet_core.model.u.gJi();
          paramAnonymousView = WalletOfflineCoinPurseUI.this;
          localObject = WalletOfflineCoinPurseUI.ae(WalletOfflineCoinPurseUI.this);
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
                else if (WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this) != null)
                {
                  WalletOfflineCoinPurseUI.V(WalletOfflineCoinPurseUI.this).dismiss();
                }
              }
            }
          };
          if (!com.tencent.mm.plugin.wallet_core.model.u.b(paramAnonymousView, (com.tencent.mm.wallet_core.d.e)localObject, 1006))
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
      LinearLayout localLinearLayout = WalletOfflineCoinPurseUI.l(WalletOfflineCoinPurseUI.this);
      AppMethodBeat.o(66466);
      return localLinearLayout;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI
 * JD-Core Version:    0.7.0.1
 */