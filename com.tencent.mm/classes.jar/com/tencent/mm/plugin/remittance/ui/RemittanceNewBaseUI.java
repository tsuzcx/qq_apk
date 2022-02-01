package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
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
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.a.gd.a;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.remittance.model.w.a;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.vf;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
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
  implements e.a, WcPayKeyboard.a
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cd.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aj.getContext(), 270);
  private String dpw;
  protected int dvA = 0;
  protected String flk;
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected String nLX;
  protected WalletFormView nXA;
  private int state = 0;
  protected ScrollView swv;
  protected String upF;
  private double vAJ;
  protected TextView vCA;
  protected TextView vCC;
  protected TextView vCD;
  private TextView vCE;
  private TextView vCF;
  protected TextView vCG;
  private LinearLayout vCH;
  private LinearLayout vCI;
  private LinearLayout vCJ;
  private TextView vCK;
  private TextView vCL;
  private LinearLayout vCM;
  protected String vCN;
  protected boolean vCO = true;
  protected String vCP;
  private String vCR;
  protected String vCS;
  protected String vCT = null;
  protected String vCU = null;
  protected int vCV;
  private int vCW;
  protected String vCX;
  protected String vCY;
  protected String vCZ;
  protected com.tencent.mm.plugin.wallet.a vCr = null;
  protected String vCs;
  protected String vCu;
  private int vCv = -1;
  protected boolean vCw = false;
  protected String vCx;
  protected ImageView vCy;
  protected TextView vCz;
  private Map<String, a> vDa = new HashMap();
  private String vDb;
  protected boolean vDc = false;
  private w vDd;
  private el vDe;
  private boolean vDf = false;
  private com.tencent.mm.sdk.b.c vDg = new com.tencent.mm.sdk.b.c() {};
  private boolean vDh = false;
  private boolean vDi = false;
  private boolean vDj = false;
  private boolean vDk = false;
  private vf vDl = null;
  private com.tencent.mm.sdk.b.c vDm = new com.tencent.mm.sdk.b.c() {};
  protected double vDn = 0.0D;
  protected String vDo = "";
  protected String vDp = "";
  protected String vDq = "";
  private com.tencent.mm.sdk.b.c<gf> vDr = new com.tencent.mm.sdk.b.c() {};
  protected boolean vFu = false;
  protected int vyQ = 4;
  private int vyX;
  private WcPayKeyboard vyZ;
  private RelativeLayout vzh;
  private TextView vzi;
  private RelativeLayout vzj;
  protected double vzp;
  private Runnable vzw = new Runnable()
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
  
  private void a(w paramw, vf paramvf)
  {
    this.vDf = true;
    new c(this).a(paramw, paramvf, new c.a()
    {
      public final void amf(String paramAnonymousString)
      {
        AppMethodBeat.i(68234);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceNewBaseUI.this.vCZ = paramAnonymousString;
        RemittanceNewBaseUI.this.dkf();
        AppMethodBeat.o(68234);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(174431);
        RemittanceNewBaseUI.this.vCZ = "";
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
      if (this.vDc) {
        com.tencent.mm.plugin.report.service.h.vKh.f(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
      String str = paramIntent.getStringExtra("key_trans_id");
      if (bt.isNullOrNil(this.vDb)) {
        this.vDb = str;
      }
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        com.tencent.mm.plugin.remittance.model.ad.aml(this.flk);
      }
      if (this.vAJ == 0.0D)
      {
        if (this.mScene == 1) {
          com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(17), Integer.valueOf(1) });
        }
      }
      else {
        finish();
      }
    }
    for (;;)
    {
      if (bt.iY(this.vCv, 0)) {
        b(paramBoolean, paramIntent);
      }
      do
      {
        return;
        com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
        break;
        if (ag.bq(paramIntent))
        {
          finish();
          return;
        }
      } while (ag.br(paramIntent));
      if (this.mScene == 1) {
        com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(16), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
    }
  }
  
  private boolean a(w paramw)
  {
    if (!this.vDh) {}
    for (boolean bool2 = d(paramw);; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.vDi) {
          bool1 = e(paramw);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!this.vDj) {
          bool2 = f(paramw);
        }
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.vDk) {
          bool1 = c(paramw);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bt.isNullOrNil(paramw.vAQ))
        {
          bool2 = bool1;
          if (!bt.isNullOrNil(paramw.vAR))
          {
            String str2 = com.tencent.mm.wallet_core.ui.e.gn(com.tencent.mm.wallet_core.ui.e.sh(this.flk), 10);
            String str1 = str2;
            if (!bt.isNullOrNil(this.vCS)) {
              str1 = getString(2131762438, new Object[] { str2, this.vCS });
            }
            bool2 = a(paramw.dlJ, paramw.vAR, str1, paramw.vAQ, paramw);
          }
        }
      }
      return bool2;
    }
  }
  
  private boolean a(final String paramString1, String paramString2, String paramString3, String paramString4, final w paramw)
  {
    View localView = LayoutInflater.from(this).inflate(2131495263, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131304264);
    TextView localTextView2 = (TextView)localView.findViewById(2131304263);
    TextView localTextView3 = (TextView)localView.findViewById(2131304262);
    localTextView1.setText(paramString2);
    localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, paramString3, localTextView2.getTextSize()));
    double d = bt.getDouble(paramString4, 0.0D);
    localTextView3.setText(String.format("%s%.2f", new Object[] { ah.fkg(), Double.valueOf(Double.valueOf(d).doubleValue() / 100.0D) }));
    paramString2 = new d.a(this);
    paramString2.wX(false);
    paramString2.aau(2131762530);
    paramString2.gs(localView);
    paramString2.aaB(2131762444);
    paramString2.aaC(2131756755);
    paramString2.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68239);
        RemittanceNewBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(68239);
      }
    });
    paramString2.b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(187110);
        RemittanceNewBaseUI.this.showLoading();
        RemittanceNewBaseUI.this.a(paramString1, RemittanceNewBaseUI.this.flk, RemittanceNewBaseUI.this.vCS, paramw);
        AppMethodBeat.o(187110);
      }
    });
    paramString2.fft().show();
    return true;
  }
  
  private static void amo(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceNewBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)bw.K(paramString, "msg").get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceNewBaseUI", "paymsgid count't be null in appmsg");
      return;
    }
    com.tencent.mm.plugin.remittance.a.c.djj().djm().in(str, paramString);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    d.a locala = new d.a(paramContext);
    locala.aMf(paramString2);
    locala.aMg(paramString1);
    locala.aMm(paramString3).b(paramOnClickListener1);
    locala.aMn(paramString4).c(paramOnClickListener2);
    locala.wX(false);
    locala.wY(true);
    paramString1 = locala.fft();
    paramString1.show();
    com.tencent.mm.ui.base.h.a(paramContext, paramString1);
  }
  
  private void b(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      this.dvA = 1;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.dvA), Double.valueOf(this.vDn), this.vDo, this.vDp, this.vDq });
      do
      {
        return;
      } while (paramIntent == null);
      this.dvA = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.vDn = this.vzp;
      this.vDo = this.mDesc;
      this.vDp = this.vCN;
      this.vDq = this.vDb;
    }
  }
  
  private static boolean b(w paramw)
  {
    return ((paramw.vBb == 1) && (paramw.vBc != null)) || ((paramw.vBc != null) && (paramw.vBc.CXj > 0));
  }
  
  private void bA(int paramInt, String paramString)
  {
    this.vDe = new el();
    this.vDe.dKe = 2L;
    this.vDe.dFd = paramInt;
    this.vDe.kJ(paramString);
    this.vDe.aBj();
  }
  
  private boolean c(final w paramw)
  {
    if ((paramw.dyo != null) && (paramw.dyo.ebt()))
    {
      this.vDk = true;
      com.tencent.mm.ui.base.h.d(this, paramw.dyo.doh, "", paramw.dyo.tfI, paramw.dyo.tfH, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68222);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "goto h5: %s", new Object[] { paramw.dyo.nTQ });
          com.tencent.mm.wallet_core.ui.e.p(RemittanceNewBaseUI.this.getContext(), paramw.dyo.nTQ, false);
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
    if (!bt.isNullOrNil(paramw.vAD))
    {
      this.vDh = true;
      bA(1, paramw.dnZ);
      com.tencent.mm.ui.base.h.d(this, paramw.vAD, getString(2131755873), getString(2131762444), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68224);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 3, paramw.dnZ);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramw.dlJ, RemittanceNewBaseUI.this.flk, RemittanceNewBaseUI.this.vCS, paramw);
          }
          AppMethodBeat.o(68224);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68225);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 2, paramw.dnZ);
          AppMethodBeat.o(68225);
        }
      });
      return true;
    }
    return false;
  }
  
  private void djZ()
  {
    if ((dke()) && (!bt.isNullOrNil(this.vCU)) && (this.vCW != 0) && (this.vCV == 1))
    {
      addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68215);
          com.tencent.mm.wallet_core.ui.e.p(RemittanceNewBaseUI.this.getContext(), RemittanceNewBaseUI.this.vCU, false);
          AppMethodBeat.o(68215);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void dka()
  {
    int i;
    if ((!bt.isNullOrNil(this.vCT)) && (this.vCW != 0))
    {
      if (this.vCW == 1) {}
      for (i = 2;; i = 24) {
        try
        {
          this.vyZ.setTipText(String.format(this.vCT, new Object[] { Integer.valueOf(i) }));
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "updatePlaceHolderTv() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          this.vyZ.setTipText(getString(2131762496, new Object[] { Integer.valueOf(i) }));
          return;
        }
      }
    }
    this.vyZ.dRG();
  }
  
  private void dkd()
  {
    final Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68217);
        Bitmap localBitmap = com.tencent.mm.ak.c.a(RemittanceNewBaseUI.this.flk, false, -1, null);
        if (localBitmap == null)
        {
          RemittanceNewBaseUI.this.vCy.setImageResource(2131231875);
          AppMethodBeat.o(68217);
          return;
        }
        RemittanceNewBaseUI.this.vCy.setImageBitmap(localBitmap);
        AppMethodBeat.o(68217);
      }
    };
    if (aq.isMainThread())
    {
      local4.run();
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68218);
        local4.run();
        AppMethodBeat.o(68218);
      }
    });
  }
  
  private boolean e(final w paramw)
  {
    boolean bool = false;
    String str1;
    String str2;
    if (paramw.vAB > 0)
    {
      this.vDi = true;
      if (paramw.vAC == null) {
        break label144;
      }
      if (!bt.isNullOrNil(paramw.vAC.doh)) {
        break label121;
      }
      str1 = getString(2131762517, new Object[] { Integer.valueOf(paramw.vAB) });
      String str3 = getString(2131762444);
      if (!bt.isNullOrNil(paramw.vAC.vBd)) {
        break label132;
      }
      str2 = getString(2131762505);
      label87:
      b(this, str1, "", str3, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68226);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            if (RemittanceNewBaseUI.o(RemittanceNewBaseUI.this)) {
              RemittanceNewBaseUI.this.showLoading();
            }
            RemittanceNewBaseUI.this.a(paramw.dlJ, RemittanceNewBaseUI.this.flk, RemittanceNewBaseUI.this.vCS, paramw);
          }
          AppMethodBeat.o(68226);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68227);
          if (bt.isNullOrNil(paramw.vAC.vBe))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(68227);
            return;
          }
          com.tencent.mm.plugin.account.a.b.a.b(RemittanceNewBaseUI.this, paramw.vAC.vBe, 5, true);
          AppMethodBeat.o(68227);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label121:
      str1 = paramw.vAC.doh;
      break;
      label132:
      str2 = paramw.vAC.vBd;
      break label87;
      label144:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "scene.zaituMessage == null");
      b(this, getString(2131762517, new Object[] { Integer.valueOf(paramw.vAB) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68228);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramw.dlJ, RemittanceNewBaseUI.this.flk, RemittanceNewBaseUI.this.vCS, paramw);
          }
          AppMethodBeat.o(68228);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68229);
          com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
          AppMethodBeat.o(68229);
        }
      });
    }
  }
  
  private boolean f(final w paramw)
  {
    if (paramw.vAI)
    {
      this.vDj = true;
      f.a(this, this.mScene, paramw.vAL / 100.0D, paramw.vAK / 100.0D, paramw.vAF / 100.0D, paramw.vAH, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68230);
          RemittanceNewBaseUI.this.showLoading();
          RemittanceNewBaseUI.this.a(paramw.dlJ, RemittanceNewBaseUI.this.flk, RemittanceNewBaseUI.this.vCS, paramw);
          if (RemittanceNewBaseUI.this.mScene == 1)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
            AppMethodBeat.o(68230);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          AppMethodBeat.o(68230);
        }
      });
      return true;
    }
    return false;
  }
  
  private void kJ(boolean paramBoolean)
  {
    this.vyZ.xm(paramBoolean);
  }
  
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, gd paramgd);
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final w paramw)
  {
    if (b(paramw))
    {
      if (paramw.vBc.CXj == 0)
      {
        this.vDl = paramw.vBc;
        a(paramw, paramw.vBc);
      }
      do
      {
        return;
        if (paramw.vBc.CXj == 1)
        {
          localObject1 = new es();
          ((es)localObject1).dZD = ((int)paramw.vAP);
          localObject1 = ((es)localObject1).kL(paramw.username);
          ((es)localObject1).dZv = 4L;
          ((es)localObject1).aBj();
          com.tencent.mm.ui.base.h.a(this, paramw.vBc.doh, paramw.vBc.title, getResources().getString(2131762540), getResources().getString(2131762539), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68236);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceNewBaseUI.p(RemittanceNewBaseUI.this) });
              paramAnonymousDialogInterface = new es();
              paramAnonymousDialogInterface.dZD = ((int)paramw.vAP);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.kL(paramw.username);
              paramAnonymousDialogInterface.dZv = 9L;
              paramAnonymousDialogInterface.aBj();
              paramw.vBc = null;
              RemittanceNewBaseUI.this.a(paramString1, paramString2, paramString3, paramw);
              AppMethodBeat.o(68236);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68237);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onClick1");
              paramAnonymousDialogInterface = new es();
              paramAnonymousDialogInterface.dZD = ((int)paramw.vAP);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.kL(paramw.username);
              paramAnonymousDialogInterface.dZv = 8L;
              paramAnonymousDialogInterface.aBj();
              RemittanceNewBaseUI.this.hideLoading();
              AppMethodBeat.o(68237);
            }
          }, 2131100777);
          return;
        }
      } while (paramw.vBc.CXj != 2);
      com.tencent.mm.ui.base.h.a(this, paramw.vBc.doh, paramw.vBc.title, getResources().getString(2131766205), new DialogInterface.OnClickListener()
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
    if (this.vDf)
    {
      localObject1 = new es();
      ((es)localObject1).dZD = paramw.tav;
      localObject1 = ((es)localObject1).kL(paramw.username);
      ((es)localObject1).dZv = 5L;
      ((es)localObject1).aBj();
    }
    this.vDf = false;
    if (this.mPayScene == 31) {
      amo(this.vCR);
    }
    Object localObject1 = new PayInfo();
    ((PayInfo)localObject1).dcE = paramString1;
    ((PayInfo)localObject1).dtb = this.mPayScene;
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
    paramString1.putString("extinfo_key_3", this.vCP);
    paramString1.putBoolean("extinfo_key_4", bool);
    paramString1.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
    paramString1.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
    paramString1.putString("extinfo_key_7", this.mDesc);
    paramString1.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
    paramString1.putString("extinfo_key_16", this.vDb);
    if (paramw != null) {
      paramString1.putString("extinfo_key_19", paramw.vAZ);
    }
    int j = 0;
    int i = j;
    if (this.mScene == 1)
    {
      i = j;
      if (paramw != null)
      {
        paramString1.putString("extinfo_key_11", paramw.vAN);
        paramString1.putInt("extinfo_key_12", paramw.vAT);
        paramString1.putString("extinfo_key_13", paramw.vAU);
        paramString1.putString("extinfo_key_14", paramw.vAV);
        paramString1.putString("extinfo_key_17", paramw.vAX);
        paramString1.putString("extinfo_key_18", paramw.vAY);
        i = paramw.vAW;
      }
    }
    if (paramw != null) {
      paramString1.putInt("extinfo_key_15", paramw.tav);
    }
    if (this.vCw)
    {
      paramString1.putBoolean("extinfo_key_23", this.vCw);
      paramString1.putString("extinfo_key_24", this.mName);
      paramString1.putString("extinfo_key_25", this.upF);
      paramString1.putString("extinfo_key_26", this.vCN);
    }
    ((PayInfo)localObject1).Cos = paramString1;
    paramString1 = new Intent();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      paramString1.setClass(this, RemittanceF2fDynamicCodeUI.class);
      paramString1.putExtra("key_pay_info", (Parcelable)localObject1);
      paramString1.putExtra("key_rcvr_open_id", this.vCX);
      paramString1.putExtra("key_mch_info", this.vCu);
      paramString1.putExtra("from_patch_ui", true);
      paramString1.putExtra("get_dynamic_code_sign", paramw.vAX);
      paramString1.putExtra("get_dynamic_code_extend", paramw.vAY);
      paramString1.putExtra("dynamic_code_spam_wording", paramw.vBa);
      paramString1.putExtra("show_paying_wording", paramw.vAZ);
      paramString1.putExtra("key_transfer_qrcode_id", this.vCx);
      com.tencent.mm.plugin.report.service.h.vKh.f(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      this.vDm.alive();
      startActivityForResult(paramString1, 5);
      return;
    }
    if (this.mKindaEnable)
    {
      paramw = "";
      paramString3 = "";
      Object localObject2 = getString(2131765746);
      if (!bt.isNullOrNil(paramString2))
      {
        g.afC();
        paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(paramString2);
        if (paramString1 != null)
        {
          paramString3 = paramString1.ZX();
          paramw = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aNm(paramString3));
          if (bt.isNullOrNil(this.vCS))
          {
            paramString1 = "";
            paramString1 = paramString1;
            paramw = bt.u((String)localObject2, new Object[] { paramString1 });
            paramString3 = getString(2131762525, new Object[] { com.tencent.mm.wallet_core.ui.e.aNm(paramString3) });
          }
        }
      }
      for (;;)
      {
        if (((PayInfo)localObject1).Cos == null) {
          ((PayInfo)localObject1).Cos = new Bundle();
        }
        localObject2 = ((PayInfo)localObject1).Cos;
        ((Bundle)localObject2).putString("extinfo_key_1", paramString2);
        ((Bundle)localObject2).putString("extinfo_key_2", this.vCS);
        ((Bundle)localObject2).putString("cashier_desc", paramw);
        ((Bundle)localObject2).putString("prepay_page_payee", paramString1);
        ((Bundle)localObject2).putString("succ_tip", paramString3);
        ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, (PayInfo)localObject1);
        this.vFu = true;
        return;
        paramString1 = "(" + this.vCS + ")";
        break;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceNewBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceNewBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.vCr, paramString1);
    ((PayInfo)localObject1).CoA = this.dpw;
    ((PayInfo)localObject1).aTo = this.vDc;
    if ((paramw.vAj != null) && (paramw.vAj.djg.djj != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramw.vAj.djg.djj, false, "", (PayInfo)localObject1, paramString3, paramString1, paramw.vAj.djg.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public final void bk(float paramFloat) {}
  
  public final void djW()
  {
    com.tencent.mm.plugin.remittance.model.u localu = new com.tencent.mm.plugin.remittance.model.u(this.flk, this.vCx);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
  }
  
  public abstract void djY();
  
  public abstract void dkb();
  
  protected final void dkc()
  {
    Object localObject1 = com.tencent.mm.wallet_core.ui.e.gn(com.tencent.mm.wallet_core.ui.e.sh(this.flk), 10);
    Object localObject2 = localObject1;
    if (!bt.isNullOrNil(this.vCS)) {
      localObject2 = getString(2131762438, new Object[] { localObject1, this.vCS });
    }
    if (this.mScene == 1)
    {
      localObject2 = getIntent().getStringExtra("receiver_tips");
      this.vCz.setTextColor(getResources().getColor(2131100711));
      this.vCA.setVisibility(0);
      if (bt.isNullOrNil(this.flk))
      {
        localObject1 = getString(2131762441, new Object[] { this.vCS });
        this.vCA.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, this.vCA.getTextSize()));
        localObject1 = localObject2;
        label152:
        this.vCz.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, this.vCz.getTextSize()));
        if (!g.afw()) {
          break label375;
        }
        localObject1 = p.auF();
        if ((localObject1 == null) || (bt.isNullOrNil(this.flk))) {
          break label375;
        }
        localObject1 = ((j)localObject1).we(this.flk);
        if ((localObject1 != null) && (!bt.isNullOrNil(((i)localObject1).auy()))) {
          break label375;
        }
        final long l = bt.eGO();
        ar.a.gMW.a(this.flk, "", new ar.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(68216);
            if (paramAnonymousBoolean)
            {
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.RemittanceNewBaseUI", "getContact suc; cost=" + (bt.eGO() - l) + " ms");
              com.tencent.mm.ak.c.ac(paramAnonymousString, 3);
            }
            for (;;)
            {
              RemittanceNewBaseUI.m(RemittanceNewBaseUI.this);
              AppMethodBeat.o(68216);
              return;
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.RemittanceNewBaseUI", "getContact failed");
            }
          }
        });
      }
    }
    label375:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        dkd();
      }
      return;
      localObject1 = getString(2131762440, new Object[] { com.tencent.mm.wallet_core.ui.e.gn(com.tencent.mm.wallet_core.ui.e.sh(this.flk), 10), this.vCS });
      break;
      localObject1 = localObject2;
      if (this.mScene != 6) {
        break label152;
      }
      localObject1 = getIntent().getStringExtra("receiver_tips");
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject1 = getString(2131762439, new Object[] { localObject2 });
        break label152;
      }
      localObject1 = bt.u((String)localObject1, new Object[] { localObject2 });
      break label152;
    }
  }
  
  protected final boolean dke()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  protected final void dkf()
  {
    if (this.mPayScene == 33)
    {
      a(this.mDesc, this.vCv, this.mName, this.upF, this.vCN, this.vCP, "", null);
      return;
    }
    a(this.mDesc, this.vCv, this.mName, this.upF, this.vCN, null, "", null);
  }
  
  public abstract void dkx();
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495260;
  }
  
  public void initView()
  {
    hideActionbarLine();
    label351:
    label368:
    Object localObject;
    if ((this.mPayScene == 33) || (this.mPayScene == 32))
    {
      setMMTitle(2131762434);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68223);
          if ((RemittanceNewBaseUI.this.mScene == 1) || (RemittanceNewBaseUI.this.mScene == 6))
          {
            RemittanceNewBaseUI.this.djW();
            RemittanceNewBaseUI.this.finish();
          }
          for (;;)
          {
            AppMethodBeat.o(68223);
            return true;
            if ((RemittanceNewBaseUI.this.mScene == 2) || (RemittanceNewBaseUI.this.mScene == 5))
            {
              RemittanceNewBaseUI.this.finish();
            }
            else
            {
              paramAnonymousMenuItem = RemittanceNewBaseUI.this;
              Intent localIntent = new Intent();
              localIntent.putExtra("recent_remittance_contact_list", com.tencent.mm.plugin.remittance.model.ad.djO());
              localIntent.setClass(paramAnonymousMenuItem.getContext(), SelectRemittanceContactUI.class);
              paramAnonymousMenuItem.startActivityForResult(localIntent, 2);
            }
          }
        }
      });
      this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
      this.mKBLayout = findViewById(2131305693);
      this.swv = ((ScrollView)findViewById(2131304251));
      this.vCy = ((ImageView)findViewById(2131304060));
      this.vCz = ((TextView)findViewById(2131304061));
      this.vCA = ((TextView)findViewById(2131304062));
      this.vCA.setVisibility(8);
      this.vCI = ((LinearLayout)findViewById(2131304033));
      this.vCH = ((LinearLayout)findViewById(2131304042));
      this.vCF = ((TextView)findViewById(2131304040));
      this.vCG = ((TextView)findViewById(2131304041));
      this.vCE = ((TextView)findViewById(2131304036));
      this.vCJ = ((LinearLayout)findViewById(2131303987));
      this.vCK = ((TextView)findViewById(2131302665));
      this.vCL = ((TextView)findViewById(2131296478));
      dkc();
      this.nXA = ((WalletFormView)findViewById(2131302446));
      if (this.mPayScene != 33) {
        break label810;
      }
      this.vCF.setText(com.tencent.mm.wallet_core.ui.e.D(this.vzp));
      this.vCG.setText(ah.fkg());
      this.vCP = getIntent().getStringExtra("desc");
      if (bt.isNullOrNil(this.vCP)) {
        break label798;
      }
      this.vCE.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.vCP, this.vCE.getTextSize()));
      this.vCE.setVisibility(0);
      this.vCH.setVisibility(0);
      this.vCI.setVisibility(8);
      localObject = (ImageView)findViewById(2131306750);
      if (!ai.Eq()) {
        break label995;
      }
      findViewById(2131306755).setVisibility(8);
      findViewById(2131306752).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(2131234672);
      label415:
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68235);
          if (RemittanceNewBaseUI.this.mPayScene == 33)
          {
            RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.upF, RemittanceNewBaseUI.this.vCN, RemittanceNewBaseUI.this.vCP, "", null);
            if (RemittanceNewBaseUI.c(RemittanceNewBaseUI.this) == 0.0D)
            {
              if (RemittanceNewBaseUI.this.mScene != 1) {
                break label303;
              }
              com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceNewBaseUI.this.mScene == 1) && (!bt.isNullOrNil(RemittanceNewBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.h.vKh.f(14074, new Object[] { Integer.valueOf(2) });
            }
            AppMethodBeat.o(68235);
            return;
            RemittanceNewBaseUI.this.vzp = bt.getDouble(RemittanceNewBaseUI.this.nXA.getText(), 0.0D);
            if (!RemittanceNewBaseUI.this.nXA.aKX())
            {
              t.makeText(RemittanceNewBaseUI.this.getContext(), 2131765031, 0).show();
              break;
            }
            if (RemittanceNewBaseUI.this.vzp < 0.01D)
            {
              RemittanceNewBaseUI.this.djY();
              break;
            }
            RemittanceNewBaseUI.this.hideWcKb();
            RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.upF, RemittanceNewBaseUI.this.vCN, null, "", null);
            break;
            label303:
            com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      };
      this.nXA.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(68241);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "click enter");
            this.vzz.onClick(null);
            AppMethodBeat.o(68241);
            return true;
          }
          AppMethodBeat.o(68241);
          return true;
        }
      });
      this.nXA.setmContentAbnormalMoneyCheck(true);
      this.vCC = ((TextView)findViewById(2131304013));
      this.vCD = ((TextView)findViewById(2131296464));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label1028;
      }
      this.vCD.setText(2131762418);
      label506:
      if (!com.tencent.mm.model.u.aqV())
      {
        findViewById(2131304014).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68248);
            RemittanceNewBaseUI.this.showCircleStWcKb();
            com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            String str;
            if ((RemittanceNewBaseUI.this.mScene == 1) || (RemittanceNewBaseUI.this.mScene == 6))
            {
              str = RemittanceNewBaseUI.this.getString(2131762418);
              paramAnonymousView = RemittanceNewBaseUI.this.getString(2131762445);
              com.tencent.mm.plugin.report.service.h.vKh.f(14074, new Object[] { Integer.valueOf(1) });
            }
            for (;;)
            {
              com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceNewBaseUI.this, str, RemittanceNewBaseUI.this.mDesc, paramAnonymousView, true, 20, new h.b()new DialogInterface.OnClickListener
              {
                public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
                {
                  AppMethodBeat.i(68245);
                  if (!bt.isNullOrNil(paramAnonymous2CharSequence.toString()))
                  {
                    RemittanceNewBaseUI.this.mDesc = paramAnonymous2CharSequence.toString();
                    RemittanceNewBaseUI.e(RemittanceNewBaseUI.this);
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(68245);
                    return true;
                    RemittanceNewBaseUI.this.mDesc = null;
                    RemittanceNewBaseUI.e(RemittanceNewBaseUI.this);
                  }
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(68247);
                  aq.n(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(68246);
                      RemittanceNewBaseUI.this.hideVKB();
                      AppMethodBeat.o(68246);
                    }
                  }, 500L);
                  AppMethodBeat.o(68247);
                }
              });
              AppMethodBeat.o(68248);
              return;
              str = RemittanceNewBaseUI.this.getString(2131762417);
              paramAnonymousView = RemittanceNewBaseUI.this.getString(2131762424);
              if ((bt.iY(RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), 0)) && (RemittanceNewBaseUI.this.vCw))
              {
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceNewBaseUI.this, str, RemittanceNewBaseUI.this.mDesc, paramAnonymousView, RemittanceNewBaseUI.this.vCO, RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.upF, RemittanceNewBaseUI.this.vCN, true, new a.a()new f.c
                {
                  public final boolean a(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4)
                  {
                    AppMethodBeat.i(68242);
                    RemittanceNewBaseUI.this.vCO = paramAnonymous2Boolean;
                    if (!bt.isNullOrNil(paramAnonymous2String1))
                    {
                      RemittanceNewBaseUI.this.mDesc = paramAnonymous2String1;
                      if (RemittanceNewBaseUI.this.vCO) {
                        break label188;
                      }
                      if (bt.isNullOrNil(paramAnonymous2String2)) {
                        break label146;
                      }
                      RemittanceNewBaseUI.this.mName = paramAnonymous2String2;
                      label65:
                      if (bt.isNullOrNil(paramAnonymous2String3)) {
                        break label160;
                      }
                      RemittanceNewBaseUI.this.upF = paramAnonymous2String3;
                      label85:
                      if (bt.isNullOrNil(paramAnonymous2String4)) {
                        break label174;
                      }
                      RemittanceNewBaseUI.this.vCN = paramAnonymous2String4;
                    }
                    for (;;)
                    {
                      RemittanceNewBaseUI.d(RemittanceNewBaseUI.this);
                      RemittanceNewBaseUI.e(RemittanceNewBaseUI.this);
                      AppMethodBeat.o(68242);
                      return true;
                      RemittanceNewBaseUI.this.mDesc = null;
                      break;
                      label146:
                      RemittanceNewBaseUI.this.mName = null;
                      break label65;
                      label160:
                      RemittanceNewBaseUI.this.upF = null;
                      break label85;
                      label174:
                      RemittanceNewBaseUI.this.vCN = null;
                      continue;
                      label188:
                      RemittanceNewBaseUI.this.mName = null;
                      RemittanceNewBaseUI.this.upF = null;
                      RemittanceNewBaseUI.this.vCN = null;
                    }
                  }
                }, new f.c()
                {
                  public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(68244);
                    aq.n(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(68243);
                        RemittanceNewBaseUI.this.hideVKB();
                        AppMethodBeat.o(68243);
                      }
                    }, 500L);
                    AppMethodBeat.o(68244);
                  }
                });
                AppMethodBeat.o(68248);
                return;
              }
            }
          }
        });
        if (bt.iY(this.vCv, 0))
        {
          this.vzj = ((RelativeLayout)findViewById(2131306751));
          if ((!com.tencent.mm.sdk.platformtools.ac.eFu().equals("zh_CN")) && (!com.tencent.mm.sdk.platformtools.ac.eFu().equals("zh_TW")) && (!com.tencent.mm.sdk.platformtools.ac.eFu().equals("zh_HK"))) {
            break label1041;
          }
          this.vzh = ((RelativeLayout)findViewById(2131306753));
          this.vzi = ((TextView)findViewById(2131306756));
          this.vzh.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68249);
              RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, RemittanceNewBaseUI.f(RemittanceNewBaseUI.this).getWidth());
              RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(8);
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.RemittanceNewBaseUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceNewBaseUI.h(RemittanceNewBaseUI.this)) });
              AppMethodBeat.o(68249);
            }
          });
          this.nXA.setmWalletFormViewListener(new WalletFormView.c()
          {
            public final void p(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(68250);
              if (bt.iY(RemittanceNewBaseUI.this.vyQ, 0))
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "mAmountRemindBit == 0");
                RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(8);
                AppMethodBeat.o(68250);
                return;
              }
              long l = Double.valueOf(bt.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
              int j = 0;
              int i = 0;
              while (l != 0L)
              {
                j = (int)(l % 10L);
                l /= 10L;
                i += 1;
              }
              if (i >= RemittanceNewBaseUI.this.vyQ)
              {
                j = RemittanceNewBaseUI.this.nXA.m(paramAnonymousCharSequence, RemittanceNewBaseUI.h(RemittanceNewBaseUI.this), j);
                if (j != 0)
                {
                  RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(0);
                  paramAnonymousCharSequence = ag.aH(com.tencent.mm.sdk.platformtools.aj.getContext(), i);
                  RemittanceNewBaseUI.i(RemittanceNewBaseUI.this).setText(paramAnonymousCharSequence);
                  paramAnonymousCharSequence = (RelativeLayout.LayoutParams)RemittanceNewBaseUI.f(RemittanceNewBaseUI.this).getLayoutParams();
                  paramAnonymousCharSequence.leftMargin = j;
                  RemittanceNewBaseUI.f(RemittanceNewBaseUI.this).setLayoutParams(paramAnonymousCharSequence);
                  AppMethodBeat.o(68250);
                  return;
                }
                RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(8);
                AppMethodBeat.o(68250);
                return;
              }
              RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(8);
              AppMethodBeat.o(68250);
            }
          });
        }
      }
    }
    for (;;)
    {
      if (this.mScene == 1)
      {
        g.afC();
        if (((String)g.afB().afk().get(327732, "0")).equals("0"))
        {
          com.tencent.mm.ui.base.h.a(getContext(), 2131762490, 2131762491, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          g.afC();
          g.afB().afk().set(327732, "1");
          g.afC();
          g.afB().afk().eKy();
        }
      }
      this.vCM = ((LinearLayout)findViewById(2131304051));
      dka();
      dkb();
      djZ();
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        break label1053;
      }
      return;
      setMMTitle(2131762535);
      break;
      label798:
      this.vCE.setVisibility(8);
      break label351;
      label810:
      this.nXA.getTitleTv().setText(String.format(getString(2131762486), new Object[] { "¥" }));
      this.nXA.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(68219);
          double d = bt.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!RemittanceNewBaseUI.this.nXA.aKX()) || (d < 0.01D))
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
      this.nXA.fkH();
      this.vyZ = ((WcPayKeyboard)findViewById(2131307020));
      kJ(false);
      setWPKeyboard(this.nXA.getContentEt(), true, false);
      this.nXA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68220);
          RemittanceNewBaseUI.this.nXA.getContentEt().requestFocus();
          AppMethodBeat.o(68220);
        }
      });
      setWcKbHeightListener(this);
      this.vyZ.setActionText(getString(2131762504));
      ((RelativeLayout.LayoutParams)this.vyZ.getLayoutParams()).addRule(12);
      findViewById(2131303272);
      findViewById(2131304051).setVisibility(0);
      this.vCH.setVisibility(8);
      this.vCI.setVisibility(0);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean) {}
      });
      break label368;
      label995:
      findViewById(2131306755).setVisibility(0);
      findViewById(2131306752).setVisibility(8);
      ((ImageView)localObject).setBackgroundResource(2131234671);
      break label415;
      label1028:
      this.vCD.setText(2131762417);
      break label506;
      label1041:
      this.vzj.setVisibility(8);
    }
    label1053:
    this.swv.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68251);
        if ((RemittanceNewBaseUI.j(RemittanceNewBaseUI.this).isShown()) && (RemittanceNewBaseUI.k(RemittanceNewBaseUI.this).fjx()))
        {
          RemittanceNewBaseUI.l(RemittanceNewBaseUI.this).fjv();
          AppMethodBeat.o(68251);
          return true;
        }
        AppMethodBeat.o(68251);
        return false;
      }
    });
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    if (this.mKindaEnable) {
      return (!this.vFu) && (this.vyZ.fjz());
    }
    return this.vyZ.fjz();
  }
  
  public boolean needLockPage()
  {
    return (this.mPayScene == 33) || (this.mPayScene == 32);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.flk);
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
        if (!bt.isNullOrNil(str1))
        {
          this.flk = str1;
          dkc();
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
          str1 = getString(2131756394);
          String str2 = getString(2131762445);
          String str3 = paramIntent.getStringExtra("userName");
          String str4 = paramIntent.getStringExtra("telNumber");
          String str5 = paramIntent.getStringExtra("proviceFirstStageName") + paramIntent.getStringExtra("addressCitySecondStageName") + paramIntent.getStringExtra("addressCountiesThirdStageName") + paramIntent.getStringExtra("addressDetailInfo");
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, str1, this.mDesc, str2, false, str3, str4, str5, true, new a.a()new f.c
          {
            public final boolean a(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
            {
              AppMethodBeat.i(68231);
              RemittanceNewBaseUI.this.vCO = paramAnonymousBoolean;
              if (!bt.isNullOrNil(paramAnonymousString1))
              {
                RemittanceNewBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceNewBaseUI.this.vCO)
                {
                  if (bt.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceNewBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (bt.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceNewBaseUI.this.upF = paramAnonymousString3;
                  label70:
                  if (bt.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceNewBaseUI.this.vCN = paramAnonymousString4;; RemittanceNewBaseUI.this.vCN = null)
              {
                RemittanceNewBaseUI.d(RemittanceNewBaseUI.this);
                RemittanceNewBaseUI.e(RemittanceNewBaseUI.this);
                AppMethodBeat.o(68231);
                return true;
                RemittanceNewBaseUI.this.mDesc = null;
                break;
                label119:
                RemittanceNewBaseUI.this.mName = null;
                break label53;
                RemittanceNewBaseUI.this.upF = null;
                break label70;
              }
            }
          }, new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(68233);
              aq.n(new Runnable()
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
    if (!dke())
    {
      this.dpw = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.atD(this.dpw);
    }
    if ((this instanceof RemittanceUI)) {
      this.vCv = 0;
    }
    super.onCreate(paramBundle);
    this.vCr = com.tencent.mm.plugin.wallet.a.aL(getIntent());
    this.vCx = getIntent().getStringExtra("scan_remittance_id");
    this.vzp = getIntent().getDoubleExtra("fee", 0.0D);
    this.flk = getIntent().getStringExtra("receiver_name");
    this.nLX = getIntent().getStringExtra("receiver_nick_name");
    this.vCS = getIntent().getStringExtra("receiver_true_name");
    this.vCs = getIntent().getStringExtra("mch_name");
    this.vCu = getIntent().getStringExtra("mch_info");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.vCX = bt.by(getIntent().getStringExtra("rcvr_open_id"), "");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "mUserName %s", new Object[] { this.flk });
    g.afC();
    long l = ((Long)g.afB().afk().get(147457, Long.valueOf(0L))).longValue();
    if ((0x10 & l) != 0L)
    {
      this.vCW = 1;
      dkx();
      p.auq().a(this);
      initView();
      this.vDr.alive();
      com.tencent.mm.wallet_core.b.fjk();
      if ((!com.tencent.mm.wallet_core.b.b(b.a.pom, true)) || (!((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY"))) {
        break label377;
      }
    }
    label377:
    for (boolean bool = true;; bool = false)
    {
      this.mKindaEnable = bool;
      this.state = 1;
      return;
      if ((l & 0x20) != 0L)
      {
        this.vCW = 2;
        break;
      }
      this.vCW = 0;
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onDestroy()");
    aq.az(this.vzw);
    com.tencent.mm.sdk.b.a.ESL.d(this.vDg);
    p.auq().b(this);
    this.vDr.dead();
    this.vDm.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.atE(this.dpw);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onDialogDismiss()");
    aq.n(this.vzw, 300L);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.vyZ != null) && (this.vyZ.onKeyUp(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onPause()");
    if (!this.vyZ.fjy()) {
      this.state = 3;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    this.vCZ = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof w))
      {
        paramn = (w)paramn;
        com.tencent.mm.wallet_core.c.af.v(this.mPayScene, paramn.dlJ, paramInt2);
        this.vCR = paramn.vAE;
        if (!bt.isNullOrNil(paramn.vAM)) {
          this.vCS = paramn.vAM;
        }
        if ((this.mPayScene == 32) || (this.mPayScene == 33))
        {
          this.vDb = paramn.nSY;
          if (this.vCr != null) {
            this.vCr.j(10000, new Object[] { Integer.valueOf(this.mPayScene), this.flk, Double.valueOf(paramn.vAP) });
          }
          if (paramn.vBc != null) {
            break label280;
          }
          paramString = "";
          label160:
          this.vCY = paramString;
          if (a(paramn)) {
            break label314;
          }
          a(paramn.dlJ, this.flk, this.vCS, paramn);
          label193:
          paramString = new a(paramn.vAN, paramn.nSY, paramn.nVt, paramn.vAO, paramn.tav, paramn.dnZ, paramn.dcF, paramn.vAS, bt.getLong(paramn.vAQ, 0L));
          this.vDa.put(paramn.dlJ, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.vDb = paramn.dnZ;
        break;
        label280:
        if (bt.isNullOrNil(paramn.vBc.vCY))
        {
          paramString = this.vCY;
          break label160;
        }
        paramString = paramn.vBc.vCY;
        break label160;
        label314:
        if (!this.mKindaEnable) {
          break label193;
        }
        hideLoading();
        break label193;
        if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
        {
          this.vCT = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).jGj;
          this.vCU = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).zWR;
          this.vCV = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).zWS;
          dka();
          djZ();
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "net error, use hardcode wording");
      this.mWcKeyboard.dRG();
    }
    do
    {
      do
      {
        return false;
      } while (!(paramn instanceof w));
      if (this.mKindaEnable) {
        hideLoading();
      }
      this.vDd = ((w)paramn);
      com.tencent.mm.sdk.b.a.ESL.c(this.vDg);
      com.tencent.mm.wallet_core.c.af.v(this.mPayScene, "", paramInt2);
    } while (!c((w)paramn));
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vZ(String paramString)
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onGet");
    if (bt.nullAsNil(paramString).length() <= 0) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceNewBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.flk)) {
      return;
    }
    dkd();
  }
  
  static final class a
  {
    String dcF;
    String dnZ;
    String nSY;
    String nVt;
    int tav;
    String vAN;
    String vAO;
    String vAS;
    long vDB;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong)
    {
      this.vAN = paramString1;
      this.nSY = paramString2;
      this.nVt = paramString3;
      this.vAO = paramString4;
      this.tav = paramInt;
      this.dnZ = paramString5;
      this.dcF = paramString6;
      this.vAS = paramString7;
      this.vDB = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
 * JD-Core Version:    0.7.0.1
 */