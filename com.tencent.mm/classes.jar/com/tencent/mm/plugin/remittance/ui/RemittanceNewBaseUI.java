package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gl.a;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.g.b.a.kx;
import com.tencent.mm.g.b.a.le;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.remittance.model.ad;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.remittance.model.w.a;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public abstract class RemittanceNewBaseUI
  extends WalletBaseUI
  implements com.tencent.mm.aj.e.a, WcPayKeyboard.a
{
  protected String APz;
  protected int Cnv = 4;
  private double Cpd;
  protected com.tencent.mm.plugin.wallet.a CqM = null;
  protected String CqN;
  protected String CqP;
  private int CqQ = -1;
  protected boolean CqR = false;
  protected String CqS;
  protected ImageView CqT;
  protected TextView CqU;
  protected TextView CqV;
  protected TextView CqX;
  protected TextView CqY;
  private TextView CqZ;
  private boolean CrA = false;
  private IListener CrB = new IListener() {};
  private boolean CrC = false;
  private boolean CrD = false;
  private boolean CrE = false;
  private boolean CrF = false;
  private zd CrG = null;
  private IListener CrH = new IListener() {};
  protected double CrI = 0.0D;
  protected String CrJ = "";
  protected String CrK = "";
  protected String CrL = "";
  private IListener<gn> CrM = new IListener() {};
  private TextView Cra;
  protected TextView Crb;
  private LinearLayout Crc;
  private LinearLayout Crd;
  private LinearLayout Cre;
  private TextView Crf;
  private TextView Crg;
  private LinearLayout Crh;
  protected String Cri;
  protected boolean Crj = true;
  protected String Crk;
  private String Crm;
  protected String Crn;
  protected String Cro = null;
  protected String Crp = null;
  protected int Crq;
  private int Crr;
  protected String Crs;
  protected String Crt;
  protected String Cru;
  private Map<String, a> Crv = new HashMap();
  private String Crw;
  protected boolean Crx = false;
  private w Cry;
  private kx Crz;
  protected boolean CtP = false;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 270);
  private String dRM;
  protected int dYe = 0;
  protected String goe;
  private int jVe;
  protected ScrollView jVf;
  private WcPayKeyboard jVg;
  private RelativeLayout jVk;
  private TextView jVl;
  private RelativeLayout jVm;
  protected double jVp;
  private Runnable jVx = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(68214);
      if ((RemittanceNewBaseUI.a(RemittanceNewBaseUI.this) == 2) && (RemittanceNewBaseUI.this.isHandleAutoShowNormalStWcKb())) {
        RemittanceNewBaseUI.this.showNormalStWcKb();
      }
      AppMethodBeat.o(68214);
    }
  };
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected WalletFormView qAh;
  private com.tencent.mm.ui.widget.a.g qAx;
  protected String qnT;
  private int state = 0;
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, g.a parama1, g.a parama2)
  {
    if (this.qAx != null)
    {
      this.qAx.bMo();
      this.qAx = null;
    }
    this.qAx = new com.tencent.mm.ui.widget.a.g(paramContext, 1, 3);
    this.qAx.b(paramString4, paramString3);
    this.qAx.a(parama2, parama1);
    paramString3 = View.inflate(paramContext, 2131496108, null);
    paramString4 = (TextView)paramString3.findViewById(2131302237);
    com.tencent.mm.ui.ao.a(paramString4.getPaint(), 0.8F);
    paramString4.setText(paramString2);
    this.qAx.setHeaderView(paramString3);
    paramContext = View.inflate(paramContext, 2131496107, null);
    paramString2 = (TextView)paramContext.findViewById(2131302235);
    com.tencent.mm.ui.ao.a(paramString2.getPaint(), 0.8F);
    paramString2.setText(paramString1);
    this.qAx.setCustomView(paramContext);
    this.qAx.dGm();
  }
  
  private void a(w paramw, zd paramzd)
  {
    this.CrA = true;
    new c(this).a(paramw, paramzd, new c.a()
    {
      public final void aMb(String paramAnonymousString)
      {
        AppMethodBeat.i(68234);
        Log.i("MicroMsg.RemittanceNewBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceNewBaseUI.this.Cru = paramAnonymousString;
        RemittanceNewBaseUI.this.eNR();
        AppMethodBeat.o(68234);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(174431);
        RemittanceNewBaseUI.this.Cru = "";
        RemittanceNewBaseUI.this.hideLoading();
        RemittanceNewBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(174431);
      }
    });
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean)
    {
      if (this.Crx) {
        com.tencent.mm.plugin.report.service.h.CyF.a(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
      String str = paramIntent.getStringExtra("key_trans_id");
      if (Util.isNullOrNil(this.Crw)) {
        this.Crw = str;
      }
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        ad.aMh(this.goe);
      }
      if (this.Cpd == 0.0D)
      {
        if (this.mScene == 1) {
          com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(17), Integer.valueOf(1) });
        }
      }
      else {
        finish();
      }
    }
    for (;;)
    {
      if (Util.isEqual(this.CqQ, 0)) {
        b(paramBoolean, paramIntent);
      }
      do
      {
        return;
        com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
        break;
        if (ag.bH(paramIntent))
        {
          finish();
          return;
        }
      } while (ag.bI(paramIntent));
      if (this.mScene == 1) {
        com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(16), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
    }
  }
  
  private boolean a(w paramw)
  {
    if (!this.CrC) {}
    for (boolean bool2 = d(paramw);; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.CrD) {
          bool1 = e(paramw);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!this.CrE) {
          bool2 = f(paramw);
        }
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.CrF) {
          bool1 = c(paramw);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!Util.isNullOrNil(paramw.Cpk))
        {
          bool2 = bool1;
          if (!Util.isNullOrNil(paramw.Cpl))
          {
            String str2 = com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(this.goe), 10);
            String str1 = str2;
            if (!Util.isNullOrNil(this.Crn)) {
              str1 = getString(2131764504, new Object[] { str2, this.Crn });
            }
            bool2 = a(paramw.dNQ, paramw.Cpl, str1, paramw.Cpk, paramw);
          }
        }
      }
      return bool2;
    }
  }
  
  private boolean a(final String paramString1, String paramString2, String paramString3, String paramString4, final w paramw)
  {
    View localView = LayoutInflater.from(this).inflate(2131496112, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131307187);
    TextView localTextView2 = (TextView)localView.findViewById(2131307186);
    TextView localTextView3 = (TextView)localView.findViewById(2131307185);
    localTextView1.setText(paramString2);
    localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, paramString3, localTextView2.getTextSize()));
    double d = Util.getDouble(paramString4, 0.0D);
    localTextView3.setText(String.format("%s%.2f", new Object[] { ah.hhz(), Double.valueOf(Double.valueOf(d).doubleValue() / 100.0D) }));
    paramString2 = new d.a(this);
    paramString2.Dk(false);
    paramString2.aoO(2131764597);
    paramString2.hs(localView);
    paramString2.aoV(2131764510);
    paramString2.aoW(2131756918);
    paramString2.d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68239);
        RemittanceNewBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(68239);
      }
    });
    paramString2.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(213828);
        RemittanceNewBaseUI.this.showLoading();
        RemittanceNewBaseUI.this.a(paramString1, RemittanceNewBaseUI.this.goe, RemittanceNewBaseUI.this.Crn, paramw);
        AppMethodBeat.o(213828);
      }
    });
    paramString2.hbn().show();
    return true;
  }
  
  private static void aMk(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.RemittanceNewBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    Log.i("MicroMsg.RemittanceNewBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)XmlParser.parseXml(paramString, "msg", null).get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      Log.e("MicroMsg.RemittanceNewBaseUI", "paymsgid count't be null in appmsg");
      return;
    }
    com.tencent.mm.plugin.remittance.a.c.eMU().eMX().jL(str, paramString);
  }
  
  private void aMn(String paramString)
  {
    com.tencent.mm.wallet_core.ui.f.a(this.CqY, paramString, 0, paramString.length(), new com.tencent.mm.wallet_core.ui.e(new com.tencent.mm.wallet_core.ui.e.a()
    {
      public final void bmr()
      {
        AppMethodBeat.i(213831);
        RemittanceNewBaseUI.k(RemittanceNewBaseUI.this);
        AppMethodBeat.o(213831);
      }
    }), getContext());
  }
  
  private void b(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      this.dYe = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.RemittanceNewBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.dYe), Double.valueOf(this.CrI), this.CrJ, this.CrK, this.CrL });
      do
      {
        return;
      } while (paramIntent == null);
      this.dYe = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.CrI = this.jVp;
      this.CrJ = this.mDesc;
      this.CrK = this.Cri;
      this.CrL = this.Crw;
    }
  }
  
  private static boolean b(w paramw)
  {
    return ((paramw.Cpv == 1) && (paramw.Cpw != null)) || ((paramw.Cpw != null) && (paramw.Cpw.Lko > 0));
  }
  
  private void bX(int paramInt, String paramString)
  {
    this.Crz = new kx();
    this.Crz.erW = 2L;
    this.Crz.ejA = paramInt;
    this.Crz.yp(paramString);
    this.Crz.bfK();
  }
  
  private boolean c(final w paramw)
  {
    if ((paramw.ebb != null) && (paramw.ebb.fPZ()))
    {
      this.CrF = true;
      com.tencent.mm.ui.base.h.c(this, paramw.ebb.dQx, "", paramw.ebb.lHB, paramw.ebb.lHA, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68222);
          Log.i("MicroMsg.RemittanceNewBaseUI", "goto h5: %s", new Object[] { paramw.ebb.qwt });
          com.tencent.mm.wallet_core.ui.f.p(RemittanceNewBaseUI.this.getContext(), paramw.ebb.qwt, false);
          AppMethodBeat.o(68222);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      return true;
    }
    return false;
  }
  
  private boolean d(final w paramw)
  {
    if (!Util.isNullOrNil(paramw.CoX))
    {
      this.CrC = true;
      bX(1, paramw.dQp);
      com.tencent.mm.ui.base.h.c(this, paramw.CoX, "", getString(2131764510), getString(2131764549), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68224);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 3, paramw.dQp);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramw.dNQ, RemittanceNewBaseUI.this.goe, RemittanceNewBaseUI.this.Crn, paramw);
          }
          AppMethodBeat.o(68224);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68225);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 2, paramw.dQp);
          if ((RemittanceNewBaseUI.this.mScene == 1) || (RemittanceNewBaseUI.this.mScene == 6))
          {
            RemittanceNewBaseUI.this.eNI();
            RemittanceNewBaseUI.this.finish();
            AppMethodBeat.o(68225);
            return;
          }
          if ((RemittanceNewBaseUI.this.mScene == 2) || (RemittanceNewBaseUI.this.mScene == 5))
          {
            RemittanceNewBaseUI.this.finish();
            AppMethodBeat.o(68225);
            return;
          }
          RemittanceNewBaseUI.this.eNS();
          AppMethodBeat.o(68225);
        }
      });
      return true;
    }
    return false;
  }
  
  private boolean e(final w paramw)
  {
    boolean bool = false;
    String str1;
    String str2;
    if (paramw.CoV > 0)
    {
      this.CrD = true;
      if (paramw.CoW == null) {
        break label153;
      }
      if (!Util.isNullOrNil(paramw.CoW.dQx)) {
        break label130;
      }
      str1 = getString(2131764584, new Object[] { Integer.valueOf(paramw.CoV) });
      String str3 = getString(2131764597);
      String str4 = getString(2131764510);
      if (!Util.isNullOrNil(paramw.CoW.Cpx)) {
        break label141;
      }
      str2 = getString(2131764572);
      label96:
      a(this, str1, str3, str4, str2, new g.a()new g.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(213824);
          if (RemittanceNewBaseUI.n(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this).bMo();
            RemittanceNewBaseUI.o(RemittanceNewBaseUI.this);
          }
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            if (RemittanceNewBaseUI.p(RemittanceNewBaseUI.this)) {
              RemittanceNewBaseUI.this.showLoading();
            }
            RemittanceNewBaseUI.this.a(paramw.dNQ, RemittanceNewBaseUI.this.goe, RemittanceNewBaseUI.this.Crn, paramw);
          }
          AppMethodBeat.o(213824);
        }
      }, new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(213825);
          if (RemittanceNewBaseUI.n(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this).bMo();
            RemittanceNewBaseUI.o(RemittanceNewBaseUI.this);
          }
          if (Util.isNullOrNil(paramw.CoW.Cpy))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(213825);
            return;
          }
          com.tencent.mm.plugin.account.a.b.a.b(RemittanceNewBaseUI.this, paramw.CoW.Cpy, 5, true);
          AppMethodBeat.o(213825);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label130:
      str1 = paramw.CoW.dQx;
      break;
      label141:
      str2 = paramw.CoW.Cpx;
      break label96;
      label153:
      Log.i("MicroMsg.RemittanceNewBaseUI", "scene.zaituMessage == null");
      a(this, getString(2131764584, new Object[] { Integer.valueOf(paramw.CoV) }), getString(2131764597), getString(2131764510), getString(2131764572), new g.a()new g.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(213826);
          if (RemittanceNewBaseUI.n(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this).bMo();
            RemittanceNewBaseUI.o(RemittanceNewBaseUI.this);
          }
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramw.dNQ, RemittanceNewBaseUI.this.goe, RemittanceNewBaseUI.this.Crn, paramw);
          }
          AppMethodBeat.o(213826);
        }
      }, new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(213827);
          if (RemittanceNewBaseUI.n(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this).bMo();
            RemittanceNewBaseUI.o(RemittanceNewBaseUI.this);
          }
          com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
          AppMethodBeat.o(213827);
        }
      });
    }
  }
  
  private void eNL()
  {
    if ((eNQ()) && (!Util.isNullOrNil(this.Crp)) && (this.Crr != 0) && (this.Crq == 1))
    {
      addIconOptionMenu(0, 2131235663, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(213841);
          com.tencent.mm.wallet_core.ui.f.p(RemittanceNewBaseUI.this.getContext(), RemittanceNewBaseUI.this.Crp, false);
          AppMethodBeat.o(213841);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void eNM()
  {
    int i;
    if ((!Util.isNullOrNil(this.Cro)) && (this.Crr != 0))
    {
      if (this.Crr == 1) {}
      for (i = 2;; i = 24) {
        try
        {
          this.jVg.setTipText(String.format(this.Cro, new Object[] { Integer.valueOf(i) }));
          return;
        }
        catch (Exception localException)
        {
          Log.i("MicroMsg.RemittanceNewBaseUI", "updatePlaceHolderTv() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          this.jVg.setTipText(getString(2131764563, new Object[] { Integer.valueOf(i) }));
          return;
        }
      }
    }
    this.jVg.fEW();
  }
  
  private void eNP()
  {
    final Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68217);
        Bitmap localBitmap = com.tencent.mm.aj.c.a(RemittanceNewBaseUI.this.goe, false, -1, null);
        if (localBitmap == null)
        {
          RemittanceNewBaseUI.this.CqT.setImageResource(2131231957);
          AppMethodBeat.o(68217);
          return;
        }
        RemittanceNewBaseUI.this.CqT.setImageBitmap(localBitmap);
        AppMethodBeat.o(68217);
      }
    };
    if (MMHandlerThread.isMainThread())
    {
      local4.run();
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68218);
        local4.run();
        AppMethodBeat.o(68218);
      }
    });
  }
  
  private boolean f(final w paramw)
  {
    if (paramw.Cpc)
    {
      this.CrE = true;
      f.a(this, this.mScene, paramw.Cpf / 100.0D, paramw.Cpe / 100.0D, paramw.CoZ / 100.0D, paramw.Cpb, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68230);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RemittanceNewBaseUI.this.showLoading();
          RemittanceNewBaseUI.this.a(paramw.dNQ, RemittanceNewBaseUI.this.goe, RemittanceNewBaseUI.this.Crn, paramw);
          if (RemittanceNewBaseUI.this.mScene == 1) {
            com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68230);
            return;
            com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          }
        }
      });
      return true;
    }
    return false;
  }
  
  private void gf(boolean paramBoolean)
  {
    this.jVg.DH(paramBoolean);
  }
  
  public final void Mr(String paramString)
  {
    Log.i("MicroMsg.RemittanceNewBaseUI", "onGet");
    if (Util.nullAsNil(paramString).length() <= 0) {
      Log.e("MicroMsg.RemittanceNewBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.goe)) {
      return;
    }
    eNP();
  }
  
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, gl paramgl);
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final w paramw)
  {
    if (b(paramw))
    {
      if (paramw.Cpw.Lko == 0)
      {
        this.CrG = paramw.Cpw;
        a(paramw, paramw.Cpw);
      }
      do
      {
        return;
        if (paramw.Cpw.Lko == 1)
        {
          localObject1 = new le();
          ((le)localObject1).eXN = ((int)paramw.Cpj);
          localObject1 = ((le)localObject1).yr(paramw.username);
          ((le)localObject1).eXG = 4L;
          ((le)localObject1).bfK();
          com.tencent.mm.ui.base.h.a(this, paramw.Cpw.dQx, paramw.Cpw.title, getResources().getString(2131764607), getResources().getString(2131764606), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68236);
              Log.i("MicroMsg.RemittanceNewBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceNewBaseUI.s(RemittanceNewBaseUI.this) });
              paramAnonymousDialogInterface = new le();
              paramAnonymousDialogInterface.eXN = ((int)paramw.Cpj);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.yr(paramw.username);
              paramAnonymousDialogInterface.eXG = 9L;
              paramAnonymousDialogInterface.bfK();
              paramw.Cpw = null;
              RemittanceNewBaseUI.this.a(paramString1, paramString2, paramString3, paramw);
              AppMethodBeat.o(68236);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68237);
              Log.i("MicroMsg.RemittanceNewBaseUI", "onClick1");
              paramAnonymousDialogInterface = new le();
              paramAnonymousDialogInterface.eXN = ((int)paramw.Cpj);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.yr(paramw.username);
              paramAnonymousDialogInterface.eXG = 8L;
              paramAnonymousDialogInterface.bfK();
              RemittanceNewBaseUI.this.hideLoading();
              AppMethodBeat.o(68237);
            }
          }, 2131100973);
          return;
        }
      } while (paramw.Cpw.Lko != 2);
      com.tencent.mm.ui.base.h.a(this, paramw.Cpw.dQx, paramw.Cpw.title, getResources().getString(2131768713), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(174432);
          RemittanceNewBaseUI.this.hideLoading();
          AppMethodBeat.o(174432);
        }
      });
      return;
    }
    if (this.CrA)
    {
      localObject1 = new le();
      ((le)localObject1).eXN = paramw.yRL;
      localObject1 = ((le)localObject1).yr(paramw.username);
      ((le)localObject1).eXG = 5L;
      ((le)localObject1).bfK();
    }
    this.CrA = false;
    if (this.mPayScene == 31) {
      aMk(this.Crm);
    }
    Object localObject1 = new PayInfo();
    ((PayInfo)localObject1).dDL = paramString1;
    ((PayInfo)localObject1).dVv = this.mPayScene;
    if (this.mChannel > 0) {
      ((PayInfo)localObject1).channel = this.mChannel;
    }
    boolean bool = false;
    if ((this.mScene == 2) || (this.mScene == 5)) {
      bool = true;
    }
    paramString1 = new Bundle();
    paramString1.putString("extinfo_key_1", paramString2);
    paramString1.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
    paramString1.putString("extinfo_key_3", this.Crk);
    paramString1.putBoolean("extinfo_key_4", bool);
    paramString1.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
    paramString1.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
    paramString1.putString("extinfo_key_7", this.mDesc);
    paramString1.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
    paramString1.putString("extinfo_key_16", this.Crw);
    if (paramw != null) {
      paramString1.putString("extinfo_key_19", paramw.Cpt);
    }
    int j = 0;
    int i = j;
    if (this.mScene == 1)
    {
      i = j;
      if (paramw != null)
      {
        paramString1.putString("extinfo_key_11", paramw.Cph);
        paramString1.putInt("extinfo_key_12", paramw.Cpn);
        paramString1.putString("extinfo_key_13", paramw.Cpo);
        paramString1.putString("extinfo_key_14", paramw.Cpp);
        paramString1.putString("extinfo_key_17", paramw.Cpr);
        paramString1.putString("extinfo_key_18", paramw.Cps);
        i = paramw.Cpq;
      }
    }
    if (paramw != null) {
      paramString1.putInt("extinfo_key_15", paramw.yRL);
    }
    if (this.CqR)
    {
      paramString1.putBoolean("extinfo_key_23", this.CqR);
      paramString1.putString("extinfo_key_24", this.mName);
      paramString1.putString("extinfo_key_25", this.APz);
      paramString1.putString("extinfo_key_26", this.Cri);
    }
    ((PayInfo)localObject1).iqp = paramString1;
    paramString1 = new Intent();
    Log.i("MicroMsg.RemittanceNewBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      paramString1.setClass(this, RemittanceF2fDynamicCodeUI.class);
      paramString1.putExtra("key_pay_info", (Parcelable)localObject1);
      paramString1.putExtra("key_rcvr_open_id", this.Crs);
      paramString1.putExtra("key_mch_info", this.CqP);
      paramString1.putExtra("from_patch_ui", true);
      paramString1.putExtra("get_dynamic_code_sign", paramw.Cpr);
      paramString1.putExtra("get_dynamic_code_extend", paramw.Cps);
      paramString1.putExtra("dynamic_code_spam_wording", paramw.Cpu);
      paramString1.putExtra("show_paying_wording", paramw.Cpt);
      paramString1.putExtra("key_transfer_qrcode_id", this.CqS);
      com.tencent.mm.plugin.report.service.h.CyF.a(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      this.CrH.alive();
      startActivityForResult(paramString1, 5);
      return;
    }
    if (this.mKindaEnable)
    {
      paramw = "";
      paramString3 = "";
      Object localObject2 = getString(2131768199);
      if (!Util.isNullOrNil(paramString2))
      {
        com.tencent.mm.kernel.g.aAi();
        paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(paramString2);
        if (paramString1 != null)
        {
          paramString3 = paramString1.arJ();
          paramw = new StringBuilder().append(com.tencent.mm.wallet_core.ui.f.bpz(paramString3));
          if (Util.isNullOrNil(this.Crn))
          {
            paramString1 = "";
            paramString1 = paramString1;
            paramw = Util.safeFormatString((String)localObject2, new Object[] { paramString1 });
            paramString3 = getString(2131764592, new Object[] { com.tencent.mm.wallet_core.ui.f.bpz(paramString3) });
          }
        }
      }
      for (;;)
      {
        if (((PayInfo)localObject1).iqp == null) {
          ((PayInfo)localObject1).iqp = new Bundle();
        }
        localObject2 = ((PayInfo)localObject1).iqp;
        ((Bundle)localObject2).putString("extinfo_key_1", paramString2);
        ((Bundle)localObject2).putString("extinfo_key_2", this.Crn);
        ((Bundle)localObject2).putString("cashier_desc", paramw);
        ((Bundle)localObject2).putString("prepay_page_payee", paramString1);
        ((Bundle)localObject2).putString("succ_tip", paramString3);
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, (PayInfo)localObject1);
        this.CtP = true;
        return;
        paramString1 = "(" + this.Crn + ")";
        break;
        Log.e("MicroMsg.RemittanceNewBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        Log.e("MicroMsg.RemittanceNewBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.CqM, paramString1);
    ((PayInfo)localObject1).KxB = this.dRM;
    ((PayInfo)localObject1).bex = this.Crx;
    if ((paramw.CoD != null) && (paramw.CoD.dKn.dKq != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramw.CoD.dKn.dKq, false, "", (PayInfo)localObject1, paramString3, paramString1, paramw.CoD.dKn.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public final void bO(float paramFloat) {}
  
  public final void eNI()
  {
    com.tencent.mm.plugin.remittance.model.u localu = new com.tencent.mm.plugin.remittance.model.u(this.goe, this.CqS);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
  }
  
  public abstract void eNK();
  
  public abstract void eNN();
  
  protected final void eNO()
  {
    Object localObject1 = com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(this.goe), 10);
    Object localObject2 = localObject1;
    if (!Util.isNullOrNil(this.Crn)) {
      localObject2 = getString(2131764504, new Object[] { localObject1, this.Crn });
    }
    if (this.mScene == 1)
    {
      localObject2 = getIntent().getStringExtra("receiver_tips");
      this.CqU.setTextColor(getResources().getColor(2131100904));
      this.CqV.setVisibility(0);
      if (Util.isNullOrNil(this.goe))
      {
        localObject1 = getString(2131764507, new Object[] { this.Crn });
        this.CqV.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject1, this.CqV.getTextSize()));
        localObject1 = localObject2;
        label152:
        this.CqU.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject1, this.CqU.getTextSize()));
        if (!com.tencent.mm.kernel.g.aAc()) {
          break label375;
        }
        localObject1 = p.aYB();
        if ((localObject1 == null) || (Util.isNullOrNil(this.goe))) {
          break label375;
        }
        localObject1 = ((j)localObject1).Mx(this.goe);
        if ((localObject1 != null) && (!Util.isNullOrNil(((i)localObject1).aYu()))) {
          break label375;
        }
        final long l = Util.nowMilliSecond();
        ay.a.iDq.a(this.goe, "", new ay.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(68216);
            if (paramAnonymousBoolean)
            {
              Log.v("MicroMsg.RemittanceNewBaseUI", "getContact suc; cost=" + (Util.nowMilliSecond() - l) + " ms");
              com.tencent.mm.aj.c.ap(paramAnonymousString, 3);
            }
            for (;;)
            {
              RemittanceNewBaseUI.l(RemittanceNewBaseUI.this);
              AppMethodBeat.o(68216);
              return;
              Log.w("MicroMsg.RemittanceNewBaseUI", "getContact failed");
            }
          }
        });
      }
    }
    label375:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        eNP();
      }
      return;
      localObject1 = getString(2131764506, new Object[] { com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(this.goe), 10), this.Crn });
      break;
      localObject1 = localObject2;
      if (this.mScene != 6) {
        break label152;
      }
      localObject1 = getIntent().getStringExtra("receiver_tips");
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject1 = getString(2131764505, new Object[] { localObject2 });
        break label152;
      }
      localObject1 = Util.safeFormatString((String)localObject1, new Object[] { localObject2 });
      break label152;
    }
  }
  
  protected final boolean eNQ()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  protected final void eNR()
  {
    if (this.mPayScene == 33)
    {
      a(this.mDesc, this.CqQ, this.mName, this.APz, this.Cri, this.Crk, "", null);
      return;
    }
    a(this.mDesc, this.CqQ, this.mName, this.APz, this.Cri, null, "", null);
  }
  
  protected final void eNS()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("recent_remittance_contact_list", ad.eNA());
    localIntent.setClass(getContext(), SelectRemittanceContactUI.class);
    startActivityForResult(localIntent, 2);
  }
  
  public abstract void eOj();
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496109;
  }
  
  public void initView()
  {
    hideActionbarLine();
    label351:
    label368:
    Object localObject;
    if ((this.mPayScene == 33) || (this.mPayScene == 32))
    {
      setMMTitle(2131764500);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68223);
          if ((RemittanceNewBaseUI.this.mScene == 1) || (RemittanceNewBaseUI.this.mScene == 6))
          {
            RemittanceNewBaseUI.this.eNI();
            RemittanceNewBaseUI.this.finish();
          }
          for (;;)
          {
            AppMethodBeat.o(68223);
            return true;
            if ((RemittanceNewBaseUI.this.mScene == 2) || (RemittanceNewBaseUI.this.mScene == 5)) {
              RemittanceNewBaseUI.this.finish();
            } else {
              RemittanceNewBaseUI.this.eNS();
            }
          }
        }
      });
      this.mKeyboard = ((MyKeyboardWindow)findViewById(2131308962));
      this.mKBLayout = findViewById(2131308960);
      this.jVf = ((ScrollView)findViewById(2131307173));
      this.CqT = ((ImageView)findViewById(2131306923));
      this.CqU = ((TextView)findViewById(2131306924));
      this.CqV = ((TextView)findViewById(2131306925));
      this.CqV.setVisibility(8);
      this.Crd = ((LinearLayout)findViewById(2131306896));
      this.Crc = ((LinearLayout)findViewById(2131306905));
      this.Cra = ((TextView)findViewById(2131306903));
      this.Crb = ((TextView)findViewById(2131306904));
      this.CqZ = ((TextView)findViewById(2131306899));
      this.Cre = ((LinearLayout)findViewById(2131306843));
      this.Crf = ((TextView)findViewById(2131305219));
      this.Crg = ((TextView)findViewById(2131296552));
      eNO();
      this.qAh = ((WalletFormView)findViewById(2131304847));
      if (this.mPayScene != 33) {
        break label793;
      }
      this.Cra.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.jVp));
      this.Crb.setText(ah.hhz());
      this.Crk = getIntent().getStringExtra("desc");
      if (Util.isNullOrNil(this.Crk)) {
        break label781;
      }
      this.CqZ.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.Crk, this.CqZ.getTextSize()));
      this.CqZ.setVisibility(0);
      this.Crc.setVisibility(0);
      this.Crd.setVisibility(8);
      localObject = (ImageView)findViewById(2131310211);
      if (!com.tencent.mm.ui.ao.isDarkMode()) {
        break label978;
      }
      findViewById(2131310216).setVisibility(8);
      findViewById(2131310213).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(2131235634);
      label415:
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68235);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (RemittanceNewBaseUI.this.mPayScene == 33)
          {
            RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.APz, RemittanceNewBaseUI.this.Cri, RemittanceNewBaseUI.this.Crk, "", null);
            if (RemittanceNewBaseUI.c(RemittanceNewBaseUI.this) == 0.0D)
            {
              if (RemittanceNewBaseUI.this.mScene != 1) {
                break label344;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceNewBaseUI.this.mScene == 1) && (!Util.isNullOrNil(RemittanceNewBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.h.CyF.a(14074, new Object[] { Integer.valueOf(2) });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68235);
            return;
            RemittanceNewBaseUI.this.jVp = Util.getDouble(RemittanceNewBaseUI.this.qAh.getText(), 0.0D);
            if (!RemittanceNewBaseUI.this.qAh.bql())
            {
              com.tencent.mm.ui.base.u.makeText(RemittanceNewBaseUI.this.getContext(), 2131767474, 0).show();
              break;
            }
            if (RemittanceNewBaseUI.this.jVp < 0.01D)
            {
              RemittanceNewBaseUI.this.eNK();
              break;
            }
            RemittanceNewBaseUI.this.hideWcKb();
            RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.APz, RemittanceNewBaseUI.this.Cri, null, "", null);
            break;
            label344:
            com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      };
      this.qAh.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(68241);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            Log.i("MicroMsg.RemittanceNewBaseUI", "click enter");
            this.jVJ.onClick(null);
            AppMethodBeat.o(68241);
            return true;
          }
          AppMethodBeat.o(68241);
          return true;
        }
      });
      this.qAh.setmContentAbnormalMoneyCheck(true);
      this.CqX = ((TextView)findViewById(2131306869));
      this.CqY = ((TextView)findViewById(2131296537));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label1011;
      }
      aMn(getString(2131764484));
      label507:
      if ((!z.aUo()) && (Util.isEqual(this.CqQ, 0)))
      {
        this.jVm = ((RelativeLayout)findViewById(2131310212));
        if ((!LocaleUtil.getApplicationLanguage().equals("zh_CN")) && (!LocaleUtil.getApplicationLanguage().equals("zh_TW")) && (!LocaleUtil.getApplicationLanguage().equals("zh_HK"))) {
          break label1025;
        }
        this.jVk = ((RelativeLayout)findViewById(2131310214));
        this.jVl = ((TextView)findViewById(2131310217));
        this.jVk.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(213838);
            RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, RemittanceNewBaseUI.d(RemittanceNewBaseUI.this).getWidth());
            RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).setVisibility(8);
            Log.d("MicroMsg.RemittanceNewBaseUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceNewBaseUI.f(RemittanceNewBaseUI.this)) });
            AppMethodBeat.o(213838);
          }
        });
        this.qAh.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void p(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(213839);
            if (Util.isEqual(RemittanceNewBaseUI.this.Cnv, 0))
            {
              Log.i("MicroMsg.RemittanceNewBaseUI", "mAmountRemindBit == 0");
              RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).setVisibility(8);
              AppMethodBeat.o(213839);
              return;
            }
            long l = Double.valueOf(Util.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
            int j = 0;
            int i = 0;
            while (l != 0L)
            {
              j = (int)(l % 10L);
              l /= 10L;
              i += 1;
            }
            if (i >= RemittanceNewBaseUI.this.Cnv)
            {
              j = RemittanceNewBaseUI.this.qAh.k(paramAnonymousCharSequence, RemittanceNewBaseUI.f(RemittanceNewBaseUI.this), j);
              if (j != 0)
              {
                RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).setVisibility(0);
                paramAnonymousCharSequence = ag.aR(MMApplicationContext.getContext(), i);
                RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setText(paramAnonymousCharSequence);
                paramAnonymousCharSequence = (RelativeLayout.LayoutParams)RemittanceNewBaseUI.d(RemittanceNewBaseUI.this).getLayoutParams();
                paramAnonymousCharSequence.leftMargin = j;
                RemittanceNewBaseUI.d(RemittanceNewBaseUI.this).setLayoutParams(paramAnonymousCharSequence);
                AppMethodBeat.o(213839);
                return;
              }
              RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).setVisibility(8);
              AppMethodBeat.o(213839);
              return;
            }
            RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).setVisibility(8);
            AppMethodBeat.o(213839);
          }
        });
      }
    }
    for (;;)
    {
      if (this.mScene == 1)
      {
        com.tencent.mm.kernel.g.aAi();
        if (((String)com.tencent.mm.kernel.g.aAh().azQ().get(327732, "0")).equals("0"))
        {
          com.tencent.mm.ui.base.h.a(getContext(), 2131764557, 2131764558, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(327732, "1");
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().gBI();
        }
      }
      this.Crh = ((LinearLayout)findViewById(2131306914));
      eNM();
      eNN();
      eNL();
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        break label1037;
      }
      return;
      setMMTitle(2131764602);
      break;
      label781:
      this.CqZ.setVisibility(8);
      break label351;
      label793:
      this.qAh.getTitleTv().setText(String.format(getString(2131764553), new Object[] { "¥" }));
      this.qAh.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(68219);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!RemittanceNewBaseUI.this.qAh.bql()) || (d < 0.01D))
          {
            RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, false);
            AppMethodBeat.o(68219);
            return;
          }
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, true);
          AppMethodBeat.o(68219);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.qAh.hib();
      this.jVg = ((WcPayKeyboard)findViewById(2131310544));
      gf(false);
      setWPKeyboard(this.qAh.getContentEt(), true, false);
      this.qAh.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68220);
          RemittanceNewBaseUI.this.qAh.getContentEt().requestFocus();
          AppMethodBeat.o(68220);
        }
      });
      setWcKbHeightListener(this);
      this.jVg.setActionText(getString(2131764571));
      ((RelativeLayout.LayoutParams)this.jVg.getLayoutParams()).addRule(12);
      findViewById(2131305945);
      findViewById(2131306914).setVisibility(0);
      this.Crc.setVisibility(8);
      this.Crd.setVisibility(0);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean) {}
      });
      break label368;
      label978:
      findViewById(2131310216).setVisibility(0);
      findViewById(2131310213).setVisibility(8);
      ((ImageView)localObject).setBackgroundResource(2131235633);
      break label415;
      label1011:
      aMn(getString(2131764483));
      break label507;
      label1025:
      this.jVm.setVisibility(8);
    }
    label1037:
    this.jVf.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(213840);
        if ((RemittanceNewBaseUI.h(RemittanceNewBaseUI.this).isShown()) && (RemittanceNewBaseUI.i(RemittanceNewBaseUI.this).hgP()))
        {
          RemittanceNewBaseUI.j(RemittanceNewBaseUI.this).hgN();
          AppMethodBeat.o(213840);
          return true;
        }
        AppMethodBeat.o(213840);
        return false;
      }
    });
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    if (this.mKindaEnable) {
      return (!this.CtP) && (this.jVg.hgR());
    }
    return this.jVg.hgR();
  }
  
  public boolean needLockPage()
  {
    return (this.mPayScene == 33) || (this.mPayScene == 32);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Log.i("MicroMsg.RemittanceNewBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.goe);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1) {}
      for (;;)
      {
        a(bool1, paramIntent);
        break;
        bool1 = false;
      }
      if (paramInt2 == -1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        a(bool1, paramIntent);
        break;
      }
      String str1;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra("Select_Conv_User");
        if (!Util.isNullOrNil(str1))
        {
          this.goe = str1;
          eNO();
        }
        else
        {
          finish();
        }
      }
      else
      {
        finish();
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          hideWcKb();
          str1 = getString(2131756529);
          String str2 = getString(2131764511);
          String str3 = paramIntent.getStringExtra("userName");
          String str4 = paramIntent.getStringExtra("telNumber");
          String str5 = paramIntent.getStringExtra("proviceFirstStageName") + paramIntent.getStringExtra("addressCitySecondStageName") + paramIntent.getStringExtra("addressCountiesThirdStageName") + paramIntent.getStringExtra("addressDetailInfo");
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, str1, this.mDesc, str2, false, str3, str4, str5, true, new a.a()new f.c
          {
            public final boolean a(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
            {
              AppMethodBeat.i(68231);
              RemittanceNewBaseUI.this.Crj = paramAnonymousBoolean;
              if (!Util.isNullOrNil(paramAnonymousString1))
              {
                RemittanceNewBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceNewBaseUI.this.Crj)
                {
                  if (Util.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceNewBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (Util.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceNewBaseUI.this.APz = paramAnonymousString3;
                  label70:
                  if (Util.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceNewBaseUI.this.Cri = paramAnonymousString4;; RemittanceNewBaseUI.this.Cri = null)
              {
                RemittanceNewBaseUI.q(RemittanceNewBaseUI.this);
                RemittanceNewBaseUI.r(RemittanceNewBaseUI.this);
                AppMethodBeat.o(68231);
                return true;
                RemittanceNewBaseUI.this.mDesc = null;
                break;
                label119:
                RemittanceNewBaseUI.this.mName = null;
                break label53;
                RemittanceNewBaseUI.this.APz = null;
                break label70;
              }
            }
          }, new f.c()
          {
            public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(68233);
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(68232);
                  RemittanceNewBaseUI.this.hideVKB();
                  AppMethodBeat.o(68232);
                }
              }, 500L);
              AppMethodBeat.o(68233);
            }
          });
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
    if (!eNQ())
    {
      this.dRM = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.aUU(this.dRM);
    }
    if ((this instanceof RemittanceUI)) {
      this.CqQ = 0;
    }
    super.onCreate(paramBundle);
    this.CqM = com.tencent.mm.plugin.wallet.a.be(getIntent());
    this.CqS = getIntent().getStringExtra("scan_remittance_id");
    this.jVp = getIntent().getDoubleExtra("fee", 0.0D);
    this.goe = getIntent().getStringExtra("receiver_name");
    this.qnT = getIntent().getStringExtra("receiver_nick_name");
    this.Crn = getIntent().getStringExtra("receiver_true_name");
    this.CqN = getIntent().getStringExtra("mch_name");
    this.CqP = getIntent().getStringExtra("mch_info");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.Crs = Util.nullAs(getIntent().getStringExtra("rcvr_open_id"), "");
    Log.i("MicroMsg.RemittanceNewBaseUI", "mUserName %s", new Object[] { this.goe });
    com.tencent.mm.kernel.g.aAi();
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(147457, Long.valueOf(0L))).longValue();
    if ((0x10 & l) != 0L) {
      this.Crr = 1;
    }
    for (;;)
    {
      eOj();
      p.aYn().a(this);
      initView();
      this.CrM.alive();
      com.tencent.mm.wallet_core.b.hgC();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.rWd, true);
      this.state = 1;
      return;
      if ((l & 0x20) != 0L) {
        this.Crr = 2;
      } else {
        this.Crr = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("MicroMsg.RemittanceNewBaseUI", "onDestroy()");
    MMHandlerThread.removeRunnable(this.jVx);
    EventCenter.instance.removeListener(this.CrB);
    p.aYn().b(this);
    this.CrM.dead();
    this.CrH.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.aUV(this.dRM);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    Log.i("MicroMsg.RemittanceNewBaseUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jVg != null) && (this.jVg.onKeyUp(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    Log.i("MicroMsg.RemittanceNewBaseUI", "onPause()");
    if (!this.jVg.hgQ()) {
      this.state = 3;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Log.i("MicroMsg.RemittanceNewBaseUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    this.Cru = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof w))
      {
        paramq = (w)paramq;
        af.z(this.mPayScene, paramq.dNQ, paramInt2);
        this.Crm = paramq.CoY;
        if (!Util.isNullOrNil(paramq.Cpg)) {
          this.Crn = paramq.Cpg;
        }
        if ((this.mPayScene == 32) || (this.mPayScene == 33))
        {
          this.Crw = paramq.qvD;
          if (this.CqM != null) {
            this.CqM.k(10000, new Object[] { Integer.valueOf(this.mPayScene), this.goe, Double.valueOf(paramq.Cpj) });
          }
          if (paramq.Cpw != null) {
            break label280;
          }
          paramString = "";
          label160:
          this.Crt = paramString;
          if (a(paramq)) {
            break label314;
          }
          a(paramq.dNQ, this.goe, this.Crn, paramq);
          label193:
          paramString = new a(paramq.Cph, paramq.qvD, paramq.qya, paramq.Cpi, paramq.yRL, paramq.dQp, paramq.dDM, paramq.Cpm, Util.getLong(paramq.Cpk, 0L));
          this.Crv.put(paramq.dNQ, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.Crw = paramq.dQp;
        break;
        label280:
        if (Util.isNullOrNil(paramq.Cpw.Crt))
        {
          paramString = this.Crt;
          break label160;
        }
        paramString = paramq.Cpw.Crt;
        break label160;
        label314:
        if (!this.mKindaEnable) {
          break label193;
        }
        hideLoading();
        break label193;
        if ((paramq instanceof aj))
        {
          this.Cro = ((aj)paramq).lJj;
          this.Crp = ((aj)paramq).HQy;
          this.Crq = ((aj)paramq).HQz;
          eNM();
          eNL();
        }
      }
    }
    if ((paramq instanceof aj))
    {
      Log.i("MicroMsg.RemittanceNewBaseUI", "net error, use hardcode wording");
      this.mWcKeyboard.fEW();
    }
    do
    {
      do
      {
        return false;
      } while (!(paramq instanceof w));
      if (this.mKindaEnable) {
        hideLoading();
      }
      this.Cry = ((w)paramq);
      EventCenter.instance.addListener(this.CrB);
      af.z(this.mPayScene, "", paramInt2);
    } while (!c((w)paramq));
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    Log.i("MicroMsg.RemittanceNewBaseUI", "onWindowFocusChanged");
    if ((this.qAx != null) && (!this.qAx.isShowing()))
    {
      this.qAx.bMo();
      this.qAx = null;
      if (this.jVx != null) {
        MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
      }
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  static final class a
  {
    String Cph;
    String Cpi;
    String Cpm;
    long CrW;
    String dDM;
    String dQp;
    String qvD;
    String qya;
    int yRL;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong)
    {
      this.Cph = paramString1;
      this.qvD = paramString2;
      this.qya = paramString3;
      this.Cpi = paramString4;
      this.yRL = paramInt;
      this.dQp = paramString5;
      this.dDM = paramString6;
      this.Cpm = paramString7;
      this.CrW = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
 * JD-Core Version:    0.7.0.1
 */