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
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.gh.a;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.b.a.he;
import com.tencent.mm.g.b.a.hl;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.remittance.model.w.a;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
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
  implements e.a, WcPayKeyboard.a
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aj.getContext(), 270);
  protected int dFo = 0;
  private String dyV;
  protected String fGM;
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected String oSs;
  protected WalletFormView peq;
  private int state = 0;
  protected ScrollView uGT;
  protected String wDV;
  protected int xWC = 4;
  private int xWJ;
  private WcPayKeyboard xWL;
  private RelativeLayout xWT;
  private TextView xWU;
  private RelativeLayout xWV;
  protected double xXb;
  private Runnable xXi = new Runnable()
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
  private double xYv;
  protected String yaA;
  protected boolean yaB = true;
  protected String yaC;
  private String yaE;
  protected String yaF;
  protected String yaG = null;
  protected String yaH = null;
  protected int yaI;
  private int yaJ;
  protected String yaK;
  protected String yaL;
  protected String yaM;
  private Map<String, a> yaN = new HashMap();
  private String yaO;
  protected boolean yaP = false;
  private w yaQ;
  private he yaR;
  private boolean yaS = false;
  private com.tencent.mm.sdk.b.c yaT = new com.tencent.mm.sdk.b.c() {};
  private boolean yaU = false;
  private boolean yaV = false;
  private boolean yaW = false;
  private boolean yaX = false;
  private xo yaY = null;
  private com.tencent.mm.sdk.b.c yaZ = new com.tencent.mm.sdk.b.c() {};
  protected com.tencent.mm.plugin.wallet.a yad = null;
  protected String yae;
  protected String yag;
  private int yah = -1;
  protected boolean yai = false;
  protected String yaj;
  protected ImageView yak;
  protected TextView yal;
  protected TextView yam;
  protected TextView yao;
  protected TextView yap;
  private TextView yaq;
  private TextView yar;
  protected TextView yas;
  private LinearLayout yat;
  private LinearLayout yau;
  private LinearLayout yav;
  private TextView yax;
  private TextView yay;
  private LinearLayout yaz;
  protected double yba = 0.0D;
  protected String ybb = "";
  protected String ybc = "";
  protected String ybd = "";
  private com.tencent.mm.sdk.b.c<gj> ybe = new com.tencent.mm.sdk.b.c() {};
  protected boolean ydh = false;
  
  private void a(w paramw, xo paramxo)
  {
    this.yaS = true;
    new c(this).a(paramw, paramxo, new c.a()
    {
      public final void awm(String paramAnonymousString)
      {
        AppMethodBeat.i(68234);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceNewBaseUI.this.yaM = paramAnonymousString;
        RemittanceNewBaseUI.this.dJz();
        AppMethodBeat.o(68234);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(174431);
        RemittanceNewBaseUI.this.yaM = "";
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
      if (this.yaP) {
        com.tencent.mm.plugin.report.service.g.yhR.f(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
      String str = paramIntent.getStringExtra("key_trans_id");
      if (bt.isNullOrNil(this.yaO)) {
        this.yaO = str;
      }
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        com.tencent.mm.plugin.remittance.model.ad.aws(this.fGM);
      }
      if (this.xYv == 0.0D)
      {
        if (this.mScene == 1) {
          com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(17), Integer.valueOf(1) });
        }
      }
      else {
        finish();
      }
    }
    for (;;)
    {
      if (bt.jx(this.yah, 0)) {
        b(paramBoolean, paramIntent);
      }
      do
      {
        return;
        com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
        break;
        if (ag.bw(paramIntent))
        {
          finish();
          return;
        }
      } while (ag.bx(paramIntent));
      if (this.mScene == 1) {
        com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(16), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
    }
  }
  
  private boolean a(w paramw)
  {
    if (!this.yaU) {}
    for (boolean bool2 = d(paramw);; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.yaV) {
          bool1 = e(paramw);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!this.yaW) {
          bool2 = f(paramw);
        }
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.yaX) {
          bool1 = c(paramw);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bt.isNullOrNil(paramw.xYC))
        {
          bool2 = bool1;
          if (!bt.isNullOrNil(paramw.xYD))
          {
            String str2 = com.tencent.mm.wallet_core.ui.e.gO(com.tencent.mm.wallet_core.ui.e.zf(this.fGM), 10);
            String str1 = str2;
            if (!bt.isNullOrNil(this.yaF)) {
              str1 = getString(2131762438, new Object[] { str2, this.yaF });
            }
            bool2 = a(paramw.dve, paramw.xYD, str1, paramw.xYC, paramw);
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
    localTextView2.setText(k.b(this, paramString3, localTextView2.getTextSize()));
    double d = bt.getDouble(paramString4, 0.0D);
    localTextView3.setText(String.format("%s%.2f", new Object[] { ah.fRG(), Double.valueOf(Double.valueOf(d).doubleValue() / 100.0D) }));
    paramString2 = new d.a(this);
    paramString2.yR(false);
    paramString2.afe(2131762530);
    paramString2.gY(localView);
    paramString2.afl(2131762444);
    paramString2.afm(2131756755);
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
        AppMethodBeat.i(199185);
        RemittanceNewBaseUI.this.showLoading();
        RemittanceNewBaseUI.this.a(paramString1, RemittanceNewBaseUI.this.fGM, RemittanceNewBaseUI.this.yaF, paramw);
        AppMethodBeat.o(199185);
      }
    });
    paramString2.fMb().show();
    return true;
  }
  
  private static void awv(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceNewBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)bw.M(paramString, "msg").get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceNewBaseUI", "paymsgid count't be null in appmsg");
      return;
    }
    com.tencent.mm.plugin.remittance.a.c.dIB().dIE().iU(str, paramString);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    d.a locala = new d.a(paramContext);
    locala.aXF(paramString2);
    locala.aXG(paramString1);
    locala.aXM(paramString3).c(paramOnClickListener1);
    locala.aXN(paramString4).d(paramOnClickListener2);
    locala.yR(false);
    locala.yS(true);
    paramString1 = locala.fMb();
    paramString1.show();
    h.a(paramContext, paramString1);
  }
  
  private void b(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      this.dFo = 1;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.dFo), Double.valueOf(this.yba), this.ybb, this.ybc, this.ybd });
      do
      {
        return;
      } while (paramIntent == null);
      this.dFo = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.yba = this.xXb;
      this.ybb = this.mDesc;
      this.ybc = this.yaA;
      this.ybd = this.yaO;
    }
  }
  
  private static boolean b(w paramw)
  {
    return ((paramw.xYN == 1) && (paramw.xYO != null)) || ((paramw.xYO != null) && (paramw.xYO.FXd > 0));
  }
  
  private void bJ(int paramInt, String paramString)
  {
    this.yaR = new he();
    this.yaR.dVd = 2L;
    this.yaR.dPl = paramInt;
    this.yaR.qa(paramString);
    this.yaR.aLk();
  }
  
  private boolean c(final w paramw)
  {
    if ((paramw.dIk != null) && (paramw.dIk.eEP()))
    {
      this.yaX = true;
      h.e(this, paramw.dIk.dxD, "", paramw.dIk.kzL, paramw.dIk.kzK, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68222);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "goto h5: %s", new Object[] { paramw.dIk.paG });
          com.tencent.mm.wallet_core.ui.e.o(RemittanceNewBaseUI.this.getContext(), paramw.dIk.paG, false);
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
    if (!bt.isNullOrNil(paramw.xYp))
    {
      this.yaU = true;
      bJ(1, paramw.dxv);
      h.e(this, paramw.xYp, getString(2131755873), getString(2131762444), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68224);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 3, paramw.dxv);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramw.dve, RemittanceNewBaseUI.this.fGM, RemittanceNewBaseUI.this.yaF, paramw);
          }
          AppMethodBeat.o(68224);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68225);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 2, paramw.dxv);
          AppMethodBeat.o(68225);
        }
      });
      return true;
    }
    return false;
  }
  
  private void dJt()
  {
    if ((dJy()) && (!bt.isNullOrNil(this.yaH)) && (this.yaJ != 0) && (this.yaI == 1))
    {
      addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68215);
          com.tencent.mm.wallet_core.ui.e.o(RemittanceNewBaseUI.this.getContext(), RemittanceNewBaseUI.this.yaH, false);
          AppMethodBeat.o(68215);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void dJu()
  {
    int i;
    if ((!bt.isNullOrNil(this.yaG)) && (this.yaJ != 0))
    {
      if (this.yaJ == 1) {}
      for (i = 2;; i = 24) {
        try
        {
          this.xWL.setTipText(String.format(this.yaG, new Object[] { Integer.valueOf(i) }));
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "updatePlaceHolderTv() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          this.xWL.setTipText(getString(2131762496, new Object[] { Integer.valueOf(i) }));
          return;
        }
      }
    }
    this.xWL.euC();
  }
  
  private void dJx()
  {
    final Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68217);
        Bitmap localBitmap = com.tencent.mm.ak.c.a(RemittanceNewBaseUI.this.fGM, false, -1, null);
        if (localBitmap == null)
        {
          RemittanceNewBaseUI.this.yak.setImageResource(2131231875);
          AppMethodBeat.o(68217);
          return;
        }
        RemittanceNewBaseUI.this.yak.setImageBitmap(localBitmap);
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
    if (paramw.xYn > 0)
    {
      this.yaV = true;
      if (paramw.xYo == null) {
        break label144;
      }
      if (!bt.isNullOrNil(paramw.xYo.dxD)) {
        break label121;
      }
      str1 = getString(2131762517, new Object[] { Integer.valueOf(paramw.xYn) });
      String str3 = getString(2131762444);
      if (!bt.isNullOrNil(paramw.xYo.xYP)) {
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
            RemittanceNewBaseUI.this.a(paramw.dve, RemittanceNewBaseUI.this.fGM, RemittanceNewBaseUI.this.yaF, paramw);
          }
          AppMethodBeat.o(68226);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68227);
          if (bt.isNullOrNil(paramw.xYo.xYQ))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(68227);
            return;
          }
          com.tencent.mm.plugin.account.a.b.a.b(RemittanceNewBaseUI.this, paramw.xYo.xYQ, 5, true);
          AppMethodBeat.o(68227);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label121:
      str1 = paramw.xYo.dxD;
      break;
      label132:
      str2 = paramw.xYo.xYP;
      break label87;
      label144:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "scene.zaituMessage == null");
      b(this, getString(2131762517, new Object[] { Integer.valueOf(paramw.xYn) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68228);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramw.dve, RemittanceNewBaseUI.this.fGM, RemittanceNewBaseUI.this.yaF, paramw);
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
    if (paramw.xYu)
    {
      this.yaW = true;
      f.a(this, this.mScene, paramw.xYx / 100.0D, paramw.xYw / 100.0D, paramw.xYr / 100.0D, paramw.xYt, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68230);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          RemittanceNewBaseUI.this.showLoading();
          RemittanceNewBaseUI.this.a(paramw.dve, RemittanceNewBaseUI.this.fGM, RemittanceNewBaseUI.this.yaF, paramw);
          if (RemittanceNewBaseUI.this.mScene == 1) {
            com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68230);
            return;
            com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          }
        }
      });
      return true;
    }
    return false;
  }
  
  private void lG(boolean paramBoolean)
  {
    this.xWL.zj(paramBoolean);
  }
  
  public final void De(String paramString)
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onGet");
    if (bt.nullAsNil(paramString).length() <= 0) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceNewBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.fGM)) {
      return;
    }
    dJx();
  }
  
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, gh paramgh);
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final w paramw)
  {
    if (b(paramw))
    {
      if (paramw.xYO.FXd == 0)
      {
        this.yaY = paramw.xYO;
        a(paramw, paramw.xYO);
      }
      do
      {
        return;
        if (paramw.xYO.FXd == 1)
        {
          localObject1 = new hl();
          ((hl)localObject1).esa = ((int)paramw.xYB);
          localObject1 = ((hl)localObject1).qc(paramw.username);
          ((hl)localObject1).erT = 4L;
          ((hl)localObject1).aLk();
          h.a(this, paramw.xYO.dxD, paramw.xYO.title, getResources().getString(2131762540), getResources().getString(2131762539), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68236);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceNewBaseUI.p(RemittanceNewBaseUI.this) });
              paramAnonymousDialogInterface = new hl();
              paramAnonymousDialogInterface.esa = ((int)paramw.xYB);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.qc(paramw.username);
              paramAnonymousDialogInterface.erT = 9L;
              paramAnonymousDialogInterface.aLk();
              paramw.xYO = null;
              RemittanceNewBaseUI.this.a(paramString1, paramString2, paramString3, paramw);
              AppMethodBeat.o(68236);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68237);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onClick1");
              paramAnonymousDialogInterface = new hl();
              paramAnonymousDialogInterface.esa = ((int)paramw.xYB);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.qc(paramw.username);
              paramAnonymousDialogInterface.erT = 8L;
              paramAnonymousDialogInterface.aLk();
              RemittanceNewBaseUI.this.hideLoading();
              AppMethodBeat.o(68237);
            }
          }, 2131100777);
          return;
        }
      } while (paramw.xYO.FXd != 2);
      h.a(this, paramw.xYO.dxD, paramw.xYO.title, getResources().getString(2131766205), new DialogInterface.OnClickListener()
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
    if (this.yaS)
    {
      localObject1 = new hl();
      ((hl)localObject1).esa = paramw.vls;
      localObject1 = ((hl)localObject1).qc(paramw.username);
      ((hl)localObject1).erT = 5L;
      ((hl)localObject1).aLk();
    }
    this.yaS = false;
    if (this.mPayScene == 31) {
      awv(this.yaE);
    }
    Object localObject1 = new PayInfo();
    ((PayInfo)localObject1).dlu = paramString1;
    ((PayInfo)localObject1).dCC = this.mPayScene;
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
    paramString1.putString("extinfo_key_3", this.yaC);
    paramString1.putBoolean("extinfo_key_4", bool);
    paramString1.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
    paramString1.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
    paramString1.putString("extinfo_key_7", this.mDesc);
    paramString1.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
    paramString1.putString("extinfo_key_16", this.yaO);
    if (paramw != null) {
      paramString1.putString("extinfo_key_19", paramw.xYL);
    }
    int j = 0;
    int i = j;
    if (this.mScene == 1)
    {
      i = j;
      if (paramw != null)
      {
        paramString1.putString("extinfo_key_11", paramw.xYz);
        paramString1.putInt("extinfo_key_12", paramw.xYF);
        paramString1.putString("extinfo_key_13", paramw.xYG);
        paramString1.putString("extinfo_key_14", paramw.xYH);
        paramString1.putString("extinfo_key_17", paramw.xYJ);
        paramString1.putString("extinfo_key_18", paramw.xYK);
        i = paramw.xYI;
      }
    }
    if (paramw != null) {
      paramString1.putInt("extinfo_key_15", paramw.vls);
    }
    if (this.yai)
    {
      paramString1.putBoolean("extinfo_key_23", this.yai);
      paramString1.putString("extinfo_key_24", this.mName);
      paramString1.putString("extinfo_key_25", this.wDV);
      paramString1.putString("extinfo_key_26", this.yaA);
    }
    ((PayInfo)localObject1).htZ = paramString1;
    paramString1 = new Intent();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      paramString1.setClass(this, RemittanceF2fDynamicCodeUI.class);
      paramString1.putExtra("key_pay_info", (Parcelable)localObject1);
      paramString1.putExtra("key_rcvr_open_id", this.yaK);
      paramString1.putExtra("key_mch_info", this.yag);
      paramString1.putExtra("from_patch_ui", true);
      paramString1.putExtra("get_dynamic_code_sign", paramw.xYJ);
      paramString1.putExtra("get_dynamic_code_extend", paramw.xYK);
      paramString1.putExtra("dynamic_code_spam_wording", paramw.xYM);
      paramString1.putExtra("show_paying_wording", paramw.xYL);
      paramString1.putExtra("key_transfer_qrcode_id", this.yaj);
      com.tencent.mm.plugin.report.service.g.yhR.f(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      this.yaZ.alive();
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
        com.tencent.mm.kernel.g.ajD();
        paramString1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTj(paramString2);
        if (paramString1 != null)
        {
          paramString3 = paramString1.adv();
          paramw = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aYO(paramString3));
          if (bt.isNullOrNil(this.yaF))
          {
            paramString1 = "";
            paramString1 = paramString1;
            paramw = bt.x((String)localObject2, new Object[] { paramString1 });
            paramString3 = getString(2131762525, new Object[] { com.tencent.mm.wallet_core.ui.e.aYO(paramString3) });
          }
        }
      }
      for (;;)
      {
        if (((PayInfo)localObject1).htZ == null) {
          ((PayInfo)localObject1).htZ = new Bundle();
        }
        localObject2 = ((PayInfo)localObject1).htZ;
        ((Bundle)localObject2).putString("extinfo_key_1", paramString2);
        ((Bundle)localObject2).putString("extinfo_key_2", this.yaF);
        ((Bundle)localObject2).putString("cashier_desc", paramw);
        ((Bundle)localObject2).putString("prepay_page_payee", paramString1);
        ((Bundle)localObject2).putString("succ_tip", paramString3);
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, (PayInfo)localObject1);
        this.ydh = true;
        return;
        paramString1 = "(" + this.yaF + ")";
        break;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceNewBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceNewBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.yad, paramString1);
    ((PayInfo)localObject1).FlZ = this.dyV;
    ((PayInfo)localObject1).beA = this.yaP;
    if ((paramw.xXV != null) && (paramw.xXV.drX.dsa != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramw.xXV.drX.dsa, false, "", (PayInfo)localObject1, paramString3, paramString1, paramw.xXV.drX.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public final void bv(float paramFloat) {}
  
  public abstract void dJR();
  
  public final void dJq()
  {
    com.tencent.mm.plugin.remittance.model.u localu = new com.tencent.mm.plugin.remittance.model.u(this.fGM, this.yaj);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
  }
  
  public abstract void dJs();
  
  public abstract void dJv();
  
  protected final void dJw()
  {
    Object localObject1 = com.tencent.mm.wallet_core.ui.e.gO(com.tencent.mm.wallet_core.ui.e.zf(this.fGM), 10);
    Object localObject2 = localObject1;
    if (!bt.isNullOrNil(this.yaF)) {
      localObject2 = getString(2131762438, new Object[] { localObject1, this.yaF });
    }
    if (this.mScene == 1)
    {
      localObject2 = getIntent().getStringExtra("receiver_tips");
      this.yal.setTextColor(getResources().getColor(2131100711));
      this.yam.setVisibility(0);
      if (bt.isNullOrNil(this.fGM))
      {
        localObject1 = getString(2131762441, new Object[] { this.yaF });
        this.yam.setText(k.b(this, (CharSequence)localObject1, this.yam.getTextSize()));
        localObject1 = localObject2;
        label152:
        this.yal.setText(k.b(this, (CharSequence)localObject1, this.yal.getTextSize()));
        if (!com.tencent.mm.kernel.g.ajx()) {
          break label375;
        }
        localObject1 = p.aEx();
        if ((localObject1 == null) || (bt.isNullOrNil(this.fGM))) {
          break label375;
        }
        localObject1 = ((j)localObject1).Dj(this.fGM);
        if ((localObject1 != null) && (!bt.isNullOrNil(((i)localObject1).aEr()))) {
          break label375;
        }
        final long l = bt.flT();
        as.a.hFO.a(this.fGM, "", new as.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(68216);
            if (paramAnonymousBoolean)
            {
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.RemittanceNewBaseUI", "getContact suc; cost=" + (bt.flT() - l) + " ms");
              com.tencent.mm.ak.c.ak(paramAnonymousString, 3);
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
        dJx();
      }
      return;
      localObject1 = getString(2131762440, new Object[] { com.tencent.mm.wallet_core.ui.e.gO(com.tencent.mm.wallet_core.ui.e.zf(this.fGM), 10), this.yaF });
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
      localObject1 = bt.x((String)localObject1, new Object[] { localObject2 });
      break label152;
    }
  }
  
  protected final boolean dJy()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  protected final void dJz()
  {
    if (this.mPayScene == 33)
    {
      a(this.mDesc, this.yah, this.mName, this.wDV, this.yaA, this.yaC, "", null);
      return;
    }
    a(this.mDesc, this.yah, this.mName, this.wDV, this.yaA, null, "", null);
  }
  
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
            RemittanceNewBaseUI.this.dJq();
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
              localIntent.putExtra("recent_remittance_contact_list", com.tencent.mm.plugin.remittance.model.ad.dJi());
              localIntent.setClass(paramAnonymousMenuItem.getContext(), SelectRemittanceContactUI.class);
              paramAnonymousMenuItem.startActivityForResult(localIntent, 2);
            }
          }
        }
      });
      this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
      this.mKBLayout = findViewById(2131305693);
      this.uGT = ((ScrollView)findViewById(2131304251));
      this.yak = ((ImageView)findViewById(2131304060));
      this.yal = ((TextView)findViewById(2131304061));
      this.yam = ((TextView)findViewById(2131304062));
      this.yam.setVisibility(8);
      this.yau = ((LinearLayout)findViewById(2131304033));
      this.yat = ((LinearLayout)findViewById(2131304042));
      this.yar = ((TextView)findViewById(2131304040));
      this.yas = ((TextView)findViewById(2131304041));
      this.yaq = ((TextView)findViewById(2131304036));
      this.yav = ((LinearLayout)findViewById(2131303987));
      this.yax = ((TextView)findViewById(2131302665));
      this.yay = ((TextView)findViewById(2131296478));
      dJw();
      this.peq = ((WalletFormView)findViewById(2131302446));
      if (this.mPayScene != 33) {
        break label810;
      }
      this.yar.setText(com.tencent.mm.wallet_core.ui.e.C(this.xXb));
      this.yas.setText(ah.fRG());
      this.yaC = getIntent().getStringExtra("desc");
      if (bt.isNullOrNil(this.yaC)) {
        break label798;
      }
      this.yaq.setText(k.b(getContext(), this.yaC, this.yaq.getTextSize()));
      this.yaq.setVisibility(0);
      this.yat.setVisibility(0);
      this.yau.setVisibility(8);
      localObject = (ImageView)findViewById(2131306750);
      if (!al.isDarkMode()) {
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (RemittanceNewBaseUI.this.mPayScene == 33)
          {
            RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.wDV, RemittanceNewBaseUI.this.yaA, RemittanceNewBaseUI.this.yaC, "", null);
            if (RemittanceNewBaseUI.c(RemittanceNewBaseUI.this) == 0.0D)
            {
              if (RemittanceNewBaseUI.this.mScene != 1) {
                break label344;
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceNewBaseUI.this.mScene == 1) && (!bt.isNullOrNil(RemittanceNewBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.g.yhR.f(14074, new Object[] { Integer.valueOf(2) });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68235);
            return;
            RemittanceNewBaseUI.this.xXb = bt.getDouble(RemittanceNewBaseUI.this.peq.getText(), 0.0D);
            if (!RemittanceNewBaseUI.this.peq.aVa())
            {
              t.makeText(RemittanceNewBaseUI.this.getContext(), 2131765031, 0).show();
              break;
            }
            if (RemittanceNewBaseUI.this.xXb < 0.01D)
            {
              RemittanceNewBaseUI.this.dJs();
              break;
            }
            RemittanceNewBaseUI.this.hideWcKb();
            RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.wDV, RemittanceNewBaseUI.this.yaA, null, "", null);
            break;
            label344:
            com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      };
      this.peq.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(68241);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "click enter");
            this.xXl.onClick(null);
            AppMethodBeat.o(68241);
            return true;
          }
          AppMethodBeat.o(68241);
          return true;
        }
      });
      this.peq.setmContentAbnormalMoneyCheck(true);
      this.yao = ((TextView)findViewById(2131304013));
      this.yap = ((TextView)findViewById(2131296464));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label1028;
      }
      this.yap.setText(2131762418);
      label506:
      if (!com.tencent.mm.model.u.aAB())
      {
        findViewById(2131304014).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68248);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            RemittanceNewBaseUI.this.showCircleStWcKb();
            com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            if ((RemittanceNewBaseUI.this.mScene == 1) || (RemittanceNewBaseUI.this.mScene == 6))
            {
              localObject = RemittanceNewBaseUI.this.getString(2131762418);
              paramAnonymousView = RemittanceNewBaseUI.this.getString(2131762445);
              com.tencent.mm.plugin.report.service.g.yhR.f(14074, new Object[] { Integer.valueOf(1) });
            }
            for (;;)
            {
              com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceNewBaseUI.this, (String)localObject, RemittanceNewBaseUI.this.mDesc, paramAnonymousView, true, 20, new h.b()new DialogInterface.OnClickListener
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
                  aq.o(new Runnable()
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
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(68248);
              return;
              localObject = RemittanceNewBaseUI.this.getString(2131762417);
              paramAnonymousView = RemittanceNewBaseUI.this.getString(2131762424);
              if ((bt.jx(RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), 0)) && (RemittanceNewBaseUI.this.yai))
              {
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceNewBaseUI.this, (String)localObject, RemittanceNewBaseUI.this.mDesc, paramAnonymousView, RemittanceNewBaseUI.this.yaB, RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.wDV, RemittanceNewBaseUI.this.yaA, true, new a.a()new f.c
                {
                  public final boolean a(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4)
                  {
                    AppMethodBeat.i(68242);
                    RemittanceNewBaseUI.this.yaB = paramAnonymous2Boolean;
                    if (!bt.isNullOrNil(paramAnonymous2String1))
                    {
                      RemittanceNewBaseUI.this.mDesc = paramAnonymous2String1;
                      if (RemittanceNewBaseUI.this.yaB) {
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
                      RemittanceNewBaseUI.this.wDV = paramAnonymous2String3;
                      label85:
                      if (bt.isNullOrNil(paramAnonymous2String4)) {
                        break label174;
                      }
                      RemittanceNewBaseUI.this.yaA = paramAnonymous2String4;
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
                      RemittanceNewBaseUI.this.wDV = null;
                      break label85;
                      label174:
                      RemittanceNewBaseUI.this.yaA = null;
                      continue;
                      label188:
                      RemittanceNewBaseUI.this.mName = null;
                      RemittanceNewBaseUI.this.wDV = null;
                      RemittanceNewBaseUI.this.yaA = null;
                    }
                  }
                }, new f.c()
                {
                  public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(68244);
                    aq.o(new Runnable()
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
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68248);
                return;
              }
            }
          }
        });
        if (bt.jx(this.yah, 0))
        {
          this.xWV = ((RelativeLayout)findViewById(2131306751));
          if ((!com.tencent.mm.sdk.platformtools.ac.fks().equals("zh_CN")) && (!com.tencent.mm.sdk.platformtools.ac.fks().equals("zh_TW")) && (!com.tencent.mm.sdk.platformtools.ac.fks().equals("zh_HK"))) {
            break label1041;
          }
          this.xWT = ((RelativeLayout)findViewById(2131306753));
          this.xWU = ((TextView)findViewById(2131306756));
          this.xWT.post(new Runnable()
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
          this.peq.setmWalletFormViewListener(new WalletFormView.c()
          {
            public final void p(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(68250);
              if (bt.jx(RemittanceNewBaseUI.this.xWC, 0))
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
              if (i >= RemittanceNewBaseUI.this.xWC)
              {
                j = RemittanceNewBaseUI.this.peq.j(paramAnonymousCharSequence, RemittanceNewBaseUI.h(RemittanceNewBaseUI.this), j);
                if (j != 0)
                {
                  RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(0);
                  paramAnonymousCharSequence = ag.aQ(com.tencent.mm.sdk.platformtools.aj.getContext(), i);
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
        com.tencent.mm.kernel.g.ajD();
        if (((String)com.tencent.mm.kernel.g.ajC().ajl().get(327732, "0")).equals("0"))
        {
          h.a(getContext(), 2131762490, 2131762491, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(327732, "1");
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().fqc();
        }
      }
      this.yaz = ((LinearLayout)findViewById(2131304051));
      dJu();
      dJv();
      dJt();
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        break label1053;
      }
      return;
      setMMTitle(2131762535);
      break;
      label798:
      this.yaq.setVisibility(8);
      break label351;
      label810:
      this.peq.getTitleTv().setText(String.format(getString(2131762486), new Object[] { "¥" }));
      this.peq.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(68219);
          double d = bt.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!RemittanceNewBaseUI.this.peq.aVa()) || (d < 0.01D))
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
      this.peq.fSh();
      this.xWL = ((WcPayKeyboard)findViewById(2131307020));
      lG(false);
      setWPKeyboard(this.peq.getContentEt(), true, false);
      this.peq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68220);
          RemittanceNewBaseUI.this.peq.getContentEt().requestFocus();
          AppMethodBeat.o(68220);
        }
      });
      setWcKbHeightListener(this);
      this.xWL.setActionText(getString(2131762504));
      ((RelativeLayout.LayoutParams)this.xWL.getLayoutParams()).addRule(12);
      findViewById(2131303272);
      findViewById(2131304051).setVisibility(0);
      this.yat.setVisibility(8);
      this.yau.setVisibility(0);
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
      this.yap.setText(2131762417);
      break label506;
      label1041:
      this.xWV.setVisibility(8);
    }
    label1053:
    this.uGT.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68251);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if ((RemittanceNewBaseUI.j(RemittanceNewBaseUI.this).isShown()) && (RemittanceNewBaseUI.k(RemittanceNewBaseUI.this).fQW()))
        {
          RemittanceNewBaseUI.l(RemittanceNewBaseUI.this).fQU();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(68251);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(68251);
        return false;
      }
    });
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    if (this.mKindaEnable) {
      return (!this.ydh) && (this.xWL.fQY());
    }
    return this.xWL.fQY();
  }
  
  public boolean needLockPage()
  {
    return (this.mPayScene == 33) || (this.mPayScene == 32);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.fGM);
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
          this.fGM = str1;
          dJw();
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
              RemittanceNewBaseUI.this.yaB = paramAnonymousBoolean;
              if (!bt.isNullOrNil(paramAnonymousString1))
              {
                RemittanceNewBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceNewBaseUI.this.yaB)
                {
                  if (bt.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceNewBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (bt.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceNewBaseUI.this.wDV = paramAnonymousString3;
                  label70:
                  if (bt.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceNewBaseUI.this.yaA = paramAnonymousString4;; RemittanceNewBaseUI.this.yaA = null)
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
                RemittanceNewBaseUI.this.wDV = null;
                break label70;
              }
            }
          }, new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(68233);
              aq.o(new Runnable()
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
    if (!dJy())
    {
      this.dyV = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.aEd(this.dyV);
    }
    if ((this instanceof RemittanceUI)) {
      this.yah = 0;
    }
    super.onCreate(paramBundle);
    this.yad = com.tencent.mm.plugin.wallet.a.aS(getIntent());
    this.yaj = getIntent().getStringExtra("scan_remittance_id");
    this.xXb = getIntent().getDoubleExtra("fee", 0.0D);
    this.fGM = getIntent().getStringExtra("receiver_name");
    this.oSs = getIntent().getStringExtra("receiver_nick_name");
    this.yaF = getIntent().getStringExtra("receiver_true_name");
    this.yae = getIntent().getStringExtra("mch_name");
    this.yag = getIntent().getStringExtra("mch_info");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.yaK = bt.bI(getIntent().getStringExtra("rcvr_open_id"), "");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "mUserName %s", new Object[] { this.fGM });
    com.tencent.mm.kernel.g.ajD();
    long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(147457, Long.valueOf(0L))).longValue();
    if ((0x10 & l) != 0L)
    {
      this.yaJ = 1;
      dJR();
      p.aEk().a(this);
      initView();
      this.ybe.alive();
      com.tencent.mm.wallet_core.b.fQJ();
      if ((!com.tencent.mm.wallet_core.b.b(b.a.qwl, true)) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY"))) {
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
        this.yaJ = 2;
        break;
      }
      this.yaJ = 0;
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onDestroy()");
    aq.aA(this.xXi);
    com.tencent.mm.sdk.b.a.IbL.d(this.yaT);
    p.aEk().b(this);
    this.ybe.dead();
    this.yaZ.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.aEe(this.dyV);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onDialogDismiss()");
    aq.o(this.xXi, 300L);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.xWL != null) && (this.xWL.onKeyUp(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "onPause()");
    if (!this.xWL.fQX()) {
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
    this.yaM = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof w))
      {
        paramn = (w)paramn;
        af.w(this.mPayScene, paramn.dve, paramInt2);
        this.yaE = paramn.xYq;
        if (!bt.isNullOrNil(paramn.xYy)) {
          this.yaF = paramn.xYy;
        }
        if ((this.mPayScene == 32) || (this.mPayScene == 33))
        {
          this.yaO = paramn.oZO;
          if (this.yad != null) {
            this.yad.j(10000, new Object[] { Integer.valueOf(this.mPayScene), this.fGM, Double.valueOf(paramn.xYB) });
          }
          if (paramn.xYO != null) {
            break label280;
          }
          paramString = "";
          label160:
          this.yaL = paramString;
          if (a(paramn)) {
            break label314;
          }
          a(paramn.dve, this.fGM, this.yaF, paramn);
          label193:
          paramString = new a(paramn.xYz, paramn.oZO, paramn.pcj, paramn.xYA, paramn.vls, paramn.dxv, paramn.dlv, paramn.xYE, bt.getLong(paramn.xYC, 0L));
          this.yaN.put(paramn.dve, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.yaO = paramn.dxv;
        break;
        label280:
        if (bt.isNullOrNil(paramn.xYO.yaL))
        {
          paramString = this.yaL;
          break label160;
        }
        paramString = paramn.xYO.yaL;
        break label160;
        label314:
        if (!this.mKindaEnable) {
          break label193;
        }
        hideLoading();
        break label193;
        if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
        {
          this.yaG = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).kBv;
          this.yaH = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).CPB;
          this.yaI = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).CPC;
          dJu();
          dJt();
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceNewBaseUI", "net error, use hardcode wording");
      this.mWcKeyboard.euC();
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
      this.yaQ = ((w)paramn);
      com.tencent.mm.sdk.b.a.IbL.c(this.yaT);
      af.w(this.mPayScene, "", paramInt2);
    } while (!c((w)paramn));
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    String dlv;
    String dxv;
    String oZO;
    String pcj;
    int vls;
    String xYA;
    String xYE;
    String xYz;
    long ybo;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong)
    {
      this.xYz = paramString1;
      this.oZO = paramString2;
      this.pcj = paramString3;
      this.xYA = paramString4;
      this.vls = paramInt;
      this.dxv = paramString5;
      this.dlv = paramString6;
      this.xYE = paramString7;
      this.ybo = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
 * JD-Core Version:    0.7.0.1
 */