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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.a.ge.a;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.g.a.xn;
import com.tencent.mm.g.b.a.gb;
import com.tencent.mm.g.b.a.gi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.remittance.model.ad;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.remittance.model.w.a;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
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
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 270);
  private String dnh;
  protected int dtm = 0;
  protected String foE;
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected WalletFormView oAV;
  protected String ooX;
  private int state = 0;
  protected ScrollView tEk;
  protected String vyB;
  protected int wIV = 4;
  private Runnable wJB = new Runnable()
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
  private int wJc;
  private WcPayKeyboard wJe;
  private RelativeLayout wJm;
  private TextView wJn;
  private RelativeLayout wJo;
  protected double wJu;
  private double wKO;
  private int wMA = -1;
  protected boolean wMB = false;
  protected String wMC;
  protected ImageView wMD;
  protected TextView wME;
  protected TextView wMF;
  protected TextView wMH;
  protected TextView wMI;
  private TextView wMJ;
  private TextView wMK;
  protected TextView wML;
  private LinearLayout wMM;
  private LinearLayout wMN;
  private LinearLayout wMO;
  private TextView wMP;
  private TextView wMQ;
  private LinearLayout wMR;
  protected String wMS;
  protected boolean wMT = true;
  protected String wMU;
  private String wMW;
  protected String wMX;
  protected String wMY = null;
  protected String wMZ = null;
  protected com.tencent.mm.plugin.wallet.a wMw = null;
  protected String wMx;
  protected String wMz;
  protected int wNa;
  private int wNb;
  protected String wNc;
  protected String wNd;
  protected String wNe;
  private Map<String, a> wNf = new HashMap();
  private String wNg;
  protected boolean wNh = false;
  private w wNi;
  private gb wNj;
  private boolean wNk = false;
  private com.tencent.mm.sdk.b.c wNl = new com.tencent.mm.sdk.b.c() {};
  private boolean wNm = false;
  private boolean wNn = false;
  private boolean wNo = false;
  private boolean wNp = false;
  private vp wNq = null;
  private com.tencent.mm.sdk.b.c wNr = new com.tencent.mm.sdk.b.c() {};
  protected double wNs = 0.0D;
  protected String wNt = "";
  protected String wNu = "";
  protected String wNv = "";
  private com.tencent.mm.sdk.b.c<gg> wNw = new com.tencent.mm.sdk.b.c() {};
  protected boolean wPz = false;
  
  private void a(w paramw, vp paramvp)
  {
    this.wNk = true;
    new c(this).a(paramw, paramvp, new c.a()
    {
      public final void arm(String paramAnonymousString)
      {
        AppMethodBeat.i(68234);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceNewBaseUI.this.wNe = paramAnonymousString;
        RemittanceNewBaseUI.this.dyh();
        AppMethodBeat.o(68234);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(174431);
        RemittanceNewBaseUI.this.wNe = "";
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
      if (this.wNh) {
        com.tencent.mm.plugin.report.service.h.wUl.f(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
      String str = paramIntent.getStringExtra("key_trans_id");
      if (bs.isNullOrNil(this.wNg)) {
        this.wNg = str;
      }
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        ad.ars(this.foE);
      }
      if (this.wKO == 0.0D)
      {
        if (this.mScene == 1) {
          com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(17), Integer.valueOf(1) });
        }
      }
      else {
        finish();
      }
    }
    for (;;)
    {
      if (bs.jl(this.wMA, 0)) {
        b(paramBoolean, paramIntent);
      }
      do
      {
        return;
        com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
        break;
        if (ag.br(paramIntent))
        {
          finish();
          return;
        }
      } while (ag.bs(paramIntent));
      if (this.mScene == 1) {
        com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(16), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
    }
  }
  
  private boolean a(w paramw)
  {
    if (!this.wNm) {}
    for (boolean bool2 = d(paramw);; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.wNn) {
          bool1 = e(paramw);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!this.wNo) {
          bool2 = f(paramw);
        }
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.wNp) {
          bool1 = c(paramw);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bs.isNullOrNil(paramw.wKV))
        {
          bool2 = bool1;
          if (!bs.isNullOrNil(paramw.wKW))
          {
            String str2 = com.tencent.mm.wallet_core.ui.e.gr(com.tencent.mm.wallet_core.ui.e.wk(this.foE), 10);
            String str1 = str2;
            if (!bs.isNullOrNil(this.wMX)) {
              str1 = getString(2131762438, new Object[] { str2, this.wMX });
            }
            bool2 = a(paramw.djr, paramw.wKW, str1, paramw.wKV, paramw);
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
    double d = bs.getDouble(paramString4, 0.0D);
    localTextView3.setText(String.format("%s%.2f", new Object[] { ah.fAw(), Double.valueOf(Double.valueOf(d).doubleValue() / 100.0D) }));
    paramString2 = new d.a(this);
    paramString2.yf(false);
    paramString2.acF(2131762530);
    paramString2.gH(localView);
    paramString2.acM(2131762444);
    paramString2.acN(2131756755);
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
        AppMethodBeat.i(207190);
        RemittanceNewBaseUI.this.showLoading();
        RemittanceNewBaseUI.this.a(paramString1, RemittanceNewBaseUI.this.foE, RemittanceNewBaseUI.this.wMX, paramw);
        AppMethodBeat.o(207190);
      }
    });
    paramString2.fvp().show();
    return true;
  }
  
  private static void arv(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RemittanceNewBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)bv.L(paramString, "msg").get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RemittanceNewBaseUI", "paymsgid count't be null in appmsg");
      return;
    }
    com.tencent.mm.plugin.remittance.a.c.dxj().dxm().iH(str, paramString);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    d.a locala = new d.a(paramContext);
    locala.aRH(paramString2);
    locala.aRI(paramString1);
    locala.aRO(paramString3).b(paramOnClickListener1);
    locala.aRP(paramString4).c(paramOnClickListener2);
    locala.yf(false);
    locala.yg(true);
    paramString1 = locala.fvp();
    paramString1.show();
    com.tencent.mm.ui.base.h.a(paramContext, paramString1);
  }
  
  private void b(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      this.dtm = 1;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.dtm), Double.valueOf(this.wNs), this.wNt, this.wNu, this.wNv });
      do
      {
        return;
      } while (paramIntent == null);
      this.dtm = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.wNs = this.wJu;
      this.wNt = this.mDesc;
      this.wNu = this.wMS;
      this.wNv = this.wNg;
    }
  }
  
  private static boolean b(w paramw)
  {
    return ((paramw.wLg == 1) && (paramw.wLh != null)) || ((paramw.wLh != null) && (paramw.wLh.EpS > 0));
  }
  
  private void bD(int paramInt, String paramString)
  {
    this.wNj = new gb();
    this.wNj.dHY = 2L;
    this.wNj.dCQ = paramInt;
    this.wNj.nB(paramString);
    this.wNj.aHZ();
  }
  
  private boolean c(final w paramw)
  {
    if ((paramw.dwa != null) && (paramw.dwa.eqP()))
    {
      this.wNp = true;
      com.tencent.mm.ui.base.h.d(this, paramw.dwa.dlQ, "", paramw.dwa.unX, paramw.dwa.unW, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68222);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "goto h5: %s", new Object[] { paramw.dwa.oxl });
          com.tencent.mm.wallet_core.ui.e.o(RemittanceNewBaseUI.this.getContext(), paramw.dwa.oxl, false);
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
    if (!bs.isNullOrNil(paramw.wKI))
    {
      this.wNm = true;
      bD(1, paramw.dlI);
      com.tencent.mm.ui.base.h.d(this, paramw.wKI, getString(2131755873), getString(2131762444), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68224);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 3, paramw.dlI);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramw.djr, RemittanceNewBaseUI.this.foE, RemittanceNewBaseUI.this.wMX, paramw);
          }
          AppMethodBeat.o(68224);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68225);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 2, paramw.dlI);
          AppMethodBeat.o(68225);
        }
      });
      return true;
    }
    return false;
  }
  
  private void dyb()
  {
    if ((dyg()) && (!bs.isNullOrNil(this.wMZ)) && (this.wNb != 0) && (this.wNa == 1))
    {
      addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68215);
          com.tencent.mm.wallet_core.ui.e.o(RemittanceNewBaseUI.this.getContext(), RemittanceNewBaseUI.this.wMZ, false);
          AppMethodBeat.o(68215);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void dyc()
  {
    int i;
    if ((!bs.isNullOrNil(this.wMY)) && (this.wNb != 0))
    {
      if (this.wNb == 1) {}
      for (i = 2;; i = 24) {
        try
        {
          this.wJe.setTipText(String.format(this.wMY, new Object[] { Integer.valueOf(i) }));
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "updatePlaceHolderTv() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          this.wJe.setTipText(getString(2131762496, new Object[] { Integer.valueOf(i) }));
          return;
        }
      }
    }
    this.wJe.egR();
  }
  
  private void dyf()
  {
    final Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68217);
        Bitmap localBitmap = com.tencent.mm.aj.c.a(RemittanceNewBaseUI.this.foE, false, -1, null);
        if (localBitmap == null)
        {
          RemittanceNewBaseUI.this.wMD.setImageResource(2131231875);
          AppMethodBeat.o(68217);
          return;
        }
        RemittanceNewBaseUI.this.wMD.setImageBitmap(localBitmap);
        AppMethodBeat.o(68217);
      }
    };
    if (ap.isMainThread())
    {
      local4.run();
      return;
    }
    ap.f(new Runnable()
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
    if (paramw.wKG > 0)
    {
      this.wNn = true;
      if (paramw.wKH == null) {
        break label144;
      }
      if (!bs.isNullOrNil(paramw.wKH.dlQ)) {
        break label121;
      }
      str1 = getString(2131762517, new Object[] { Integer.valueOf(paramw.wKG) });
      String str3 = getString(2131762444);
      if (!bs.isNullOrNil(paramw.wKH.wLi)) {
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
            RemittanceNewBaseUI.this.a(paramw.djr, RemittanceNewBaseUI.this.foE, RemittanceNewBaseUI.this.wMX, paramw);
          }
          AppMethodBeat.o(68226);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68227);
          if (bs.isNullOrNil(paramw.wKH.wLj))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(68227);
            return;
          }
          com.tencent.mm.plugin.account.a.b.a.b(RemittanceNewBaseUI.this, paramw.wKH.wLj, 5, true);
          AppMethodBeat.o(68227);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label121:
      str1 = paramw.wKH.dlQ;
      break;
      label132:
      str2 = paramw.wKH.wLi;
      break label87;
      label144:
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "scene.zaituMessage == null");
      b(this, getString(2131762517, new Object[] { Integer.valueOf(paramw.wKG) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68228);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramw.djr, RemittanceNewBaseUI.this.foE, RemittanceNewBaseUI.this.wMX, paramw);
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
    if (paramw.wKN)
    {
      this.wNo = true;
      f.a(this, this.mScene, paramw.wKQ / 100.0D, paramw.wKP / 100.0D, paramw.wKK / 100.0D, paramw.wKM, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68230);
          RemittanceNewBaseUI.this.showLoading();
          RemittanceNewBaseUI.this.a(paramw.djr, RemittanceNewBaseUI.this.foE, RemittanceNewBaseUI.this.wMX, paramw);
          if (RemittanceNewBaseUI.this.mScene == 1)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
            AppMethodBeat.o(68230);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          AppMethodBeat.o(68230);
        }
      });
      return true;
    }
    return false;
  }
  
  private void ln(boolean paramBoolean)
  {
    this.wJe.yw(paramBoolean);
  }
  
  public final void Af(String paramString)
  {
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "onGet");
    if (bs.nullAsNil(paramString).length() <= 0) {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RemittanceNewBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.foE)) {
      return;
    }
    dyf();
  }
  
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ge paramge);
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final w paramw)
  {
    if (b(paramw))
    {
      if (paramw.wLh.EpS == 0)
      {
        this.wNq = paramw.wLh;
        a(paramw, paramw.wLh);
      }
      do
      {
        return;
        if (paramw.wLh.EpS == 1)
        {
          localObject1 = new gi();
          ((gi)localObject1).ebv = ((int)paramw.wKU);
          localObject1 = ((gi)localObject1).nD(paramw.username);
          ((gi)localObject1).ebn = 4L;
          ((gi)localObject1).aHZ();
          com.tencent.mm.ui.base.h.a(this, paramw.wLh.dlQ, paramw.wLh.title, getResources().getString(2131762540), getResources().getString(2131762539), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68236);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceNewBaseUI.p(RemittanceNewBaseUI.this) });
              paramAnonymousDialogInterface = new gi();
              paramAnonymousDialogInterface.ebv = ((int)paramw.wKU);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.nD(paramw.username);
              paramAnonymousDialogInterface.ebn = 9L;
              paramAnonymousDialogInterface.aHZ();
              paramw.wLh = null;
              RemittanceNewBaseUI.this.a(paramString1, paramString2, paramString3, paramw);
              AppMethodBeat.o(68236);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68237);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "onClick1");
              paramAnonymousDialogInterface = new gi();
              paramAnonymousDialogInterface.ebv = ((int)paramw.wKU);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.nD(paramw.username);
              paramAnonymousDialogInterface.ebn = 8L;
              paramAnonymousDialogInterface.aHZ();
              RemittanceNewBaseUI.this.hideLoading();
              AppMethodBeat.o(68237);
            }
          }, 2131100777);
          return;
        }
      } while (paramw.wLh.EpS != 2);
      com.tencent.mm.ui.base.h.a(this, paramw.wLh.dlQ, paramw.wLh.title, getResources().getString(2131766205), new DialogInterface.OnClickListener()
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
    if (this.wNk)
    {
      localObject1 = new gi();
      ((gi)localObject1).ebv = paramw.uiK;
      localObject1 = ((gi)localObject1).nD(paramw.username);
      ((gi)localObject1).ebn = 5L;
      ((gi)localObject1).aHZ();
    }
    this.wNk = false;
    if (this.mPayScene == 31) {
      arv(this.wMW);
    }
    Object localObject1 = new PayInfo();
    ((PayInfo)localObject1).dac = paramString1;
    ((PayInfo)localObject1).dqL = this.mPayScene;
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
    paramString1.putString("extinfo_key_3", this.wMU);
    paramString1.putBoolean("extinfo_key_4", bool);
    paramString1.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
    paramString1.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
    paramString1.putString("extinfo_key_7", this.mDesc);
    paramString1.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
    paramString1.putString("extinfo_key_16", this.wNg);
    if (paramw != null) {
      paramString1.putString("extinfo_key_19", paramw.wLe);
    }
    int j = 0;
    int i = j;
    if (this.mScene == 1)
    {
      i = j;
      if (paramw != null)
      {
        paramString1.putString("extinfo_key_11", paramw.wKS);
        paramString1.putInt("extinfo_key_12", paramw.wKY);
        paramString1.putString("extinfo_key_13", paramw.wKZ);
        paramString1.putString("extinfo_key_14", paramw.wLa);
        paramString1.putString("extinfo_key_17", paramw.wLc);
        paramString1.putString("extinfo_key_18", paramw.wLd);
        i = paramw.wLb;
      }
    }
    if (paramw != null) {
      paramString1.putInt("extinfo_key_15", paramw.uiK);
    }
    if (this.wMB)
    {
      paramString1.putBoolean("extinfo_key_23", this.wMB);
      paramString1.putString("extinfo_key_24", this.mName);
      paramString1.putString("extinfo_key_25", this.vyB);
      paramString1.putString("extinfo_key_26", this.wMS);
    }
    ((PayInfo)localObject1).hbR = paramString1;
    paramString1 = new Intent();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      paramString1.setClass(this, RemittanceF2fDynamicCodeUI.class);
      paramString1.putExtra("key_pay_info", (Parcelable)localObject1);
      paramString1.putExtra("key_rcvr_open_id", this.wNc);
      paramString1.putExtra("key_mch_info", this.wMz);
      paramString1.putExtra("from_patch_ui", true);
      paramString1.putExtra("get_dynamic_code_sign", paramw.wLc);
      paramString1.putExtra("get_dynamic_code_extend", paramw.wLd);
      paramString1.putExtra("dynamic_code_spam_wording", paramw.wLf);
      paramString1.putExtra("show_paying_wording", paramw.wLe);
      paramString1.putExtra("key_transfer_qrcode_id", this.wMC);
      com.tencent.mm.plugin.report.service.h.wUl.f(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      this.wNr.alive();
      startActivityForResult(paramString1, 5);
      return;
    }
    if (this.mKindaEnable)
    {
      paramw = "";
      paramString3 = "";
      Object localObject2 = getString(2131765746);
      if (!bs.isNullOrNil(paramString2))
      {
        g.agS();
        paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(paramString2);
        if (paramString1 != null)
        {
          paramString3 = paramString1.aaS();
          paramw = new StringBuilder().append(com.tencent.mm.wallet_core.ui.e.aSP(paramString3));
          if (bs.isNullOrNil(this.wMX))
          {
            paramString1 = "";
            paramString1 = paramString1;
            paramw = bs.u((String)localObject2, new Object[] { paramString1 });
            paramString3 = getString(2131762525, new Object[] { com.tencent.mm.wallet_core.ui.e.aSP(paramString3) });
          }
        }
      }
      for (;;)
      {
        if (((PayInfo)localObject1).hbR == null) {
          ((PayInfo)localObject1).hbR = new Bundle();
        }
        localObject2 = ((PayInfo)localObject1).hbR;
        ((Bundle)localObject2).putString("extinfo_key_1", paramString2);
        ((Bundle)localObject2).putString("extinfo_key_2", this.wMX);
        ((Bundle)localObject2).putString("cashier_desc", paramw);
        ((Bundle)localObject2).putString("prepay_page_payee", paramString1);
        ((Bundle)localObject2).putString("succ_tip", paramString3);
        ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, (PayInfo)localObject1);
        this.wPz = true;
        return;
        paramString1 = "(" + this.wMX + ")";
        break;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RemittanceNewBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RemittanceNewBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.wMw, paramString1);
    ((PayInfo)localObject1).DGS = this.dnh;
    ((PayInfo)localObject1).aUg = this.wNh;
    if ((paramw.wKo != null) && (paramw.wKo.dgB.dgE != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramw.wKo.dgB.dgE, false, "", (PayInfo)localObject1, paramString3, paramString1, paramw.wKo.dgB.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public final void bs(float paramFloat) {}
  
  public final void dxY()
  {
    com.tencent.mm.plugin.remittance.model.u localu = new com.tencent.mm.plugin.remittance.model.u(this.foE, this.wMC);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
  }
  
  public abstract void dya();
  
  public abstract void dyd();
  
  protected final void dye()
  {
    Object localObject1 = com.tencent.mm.wallet_core.ui.e.gr(com.tencent.mm.wallet_core.ui.e.wk(this.foE), 10);
    Object localObject2 = localObject1;
    if (!bs.isNullOrNil(this.wMX)) {
      localObject2 = getString(2131762438, new Object[] { localObject1, this.wMX });
    }
    if (this.mScene == 1)
    {
      localObject2 = getIntent().getStringExtra("receiver_tips");
      this.wME.setTextColor(getResources().getColor(2131100711));
      this.wMF.setVisibility(0);
      if (bs.isNullOrNil(this.foE))
      {
        localObject1 = getString(2131762441, new Object[] { this.wMX });
        this.wMF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, this.wMF.getTextSize()));
        localObject1 = localObject2;
        label152:
        this.wME.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, this.wME.getTextSize()));
        if (!g.agM()) {
          break label375;
        }
        localObject1 = p.aBw();
        if ((localObject1 == null) || (bs.isNullOrNil(this.foE))) {
          break label375;
        }
        localObject1 = ((j)localObject1).Ak(this.foE);
        if ((localObject1 != null) && (!bs.isNullOrNil(((i)localObject1).aBp()))) {
          break label375;
        }
        long l = bs.eWj();
        ar.a.hnw.a(this.foE, "", new RemittanceNewBaseUI.3(this, l));
      }
    }
    label375:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        dyf();
      }
      return;
      localObject1 = getString(2131762440, new Object[] { com.tencent.mm.wallet_core.ui.e.gr(com.tencent.mm.wallet_core.ui.e.wk(this.foE), 10), this.wMX });
      break;
      localObject1 = localObject2;
      if (this.mScene != 6) {
        break label152;
      }
      localObject1 = getIntent().getStringExtra("receiver_tips");
      if (bs.isNullOrNil((String)localObject1))
      {
        localObject1 = getString(2131762439, new Object[] { localObject2 });
        break label152;
      }
      localObject1 = bs.u((String)localObject1, new Object[] { localObject2 });
      break label152;
    }
  }
  
  protected final boolean dyg()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  protected final void dyh()
  {
    if (this.mPayScene == 33)
    {
      a(this.mDesc, this.wMA, this.mName, this.vyB, this.wMS, this.wMU, "", null);
      return;
    }
    a(this.mDesc, this.wMA, this.mName, this.vyB, this.wMS, null, "", null);
  }
  
  public abstract void dyz();
  
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
            RemittanceNewBaseUI.this.dxY();
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
              localIntent.putExtra("recent_remittance_contact_list", ad.dxQ());
              localIntent.setClass(paramAnonymousMenuItem.getContext(), SelectRemittanceContactUI.class);
              paramAnonymousMenuItem.startActivityForResult(localIntent, 2);
            }
          }
        }
      });
      this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
      this.mKBLayout = findViewById(2131305693);
      this.tEk = ((ScrollView)findViewById(2131304251));
      this.wMD = ((ImageView)findViewById(2131304060));
      this.wME = ((TextView)findViewById(2131304061));
      this.wMF = ((TextView)findViewById(2131304062));
      this.wMF.setVisibility(8);
      this.wMN = ((LinearLayout)findViewById(2131304033));
      this.wMM = ((LinearLayout)findViewById(2131304042));
      this.wMK = ((TextView)findViewById(2131304040));
      this.wML = ((TextView)findViewById(2131304041));
      this.wMJ = ((TextView)findViewById(2131304036));
      this.wMO = ((LinearLayout)findViewById(2131303987));
      this.wMP = ((TextView)findViewById(2131302665));
      this.wMQ = ((TextView)findViewById(2131296478));
      dye();
      this.oAV = ((WalletFormView)findViewById(2131302446));
      if (this.mPayScene != 33) {
        break label810;
      }
      this.wMK.setText(com.tencent.mm.wallet_core.ui.e.C(this.wJu));
      this.wML.setText(ah.fAw());
      this.wMU = getIntent().getStringExtra("desc");
      if (bs.isNullOrNil(this.wMU)) {
        break label798;
      }
      this.wMJ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.wMU, this.wMJ.getTextSize()));
      this.wMJ.setVisibility(0);
      this.wMM.setVisibility(0);
      this.wMN.setVisibility(8);
      localObject = (ImageView)findViewById(2131306750);
      if (!com.tencent.mm.ui.aj.DT()) {
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
            RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.vyB, RemittanceNewBaseUI.this.wMS, RemittanceNewBaseUI.this.wMU, "", null);
            if (RemittanceNewBaseUI.c(RemittanceNewBaseUI.this) == 0.0D)
            {
              if (RemittanceNewBaseUI.this.mScene != 1) {
                break label303;
              }
              com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceNewBaseUI.this.mScene == 1) && (!bs.isNullOrNil(RemittanceNewBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.h.wUl.f(14074, new Object[] { Integer.valueOf(2) });
            }
            AppMethodBeat.o(68235);
            return;
            RemittanceNewBaseUI.this.wJu = bs.getDouble(RemittanceNewBaseUI.this.oAV.getText(), 0.0D);
            if (!RemittanceNewBaseUI.this.oAV.aRO())
            {
              t.makeText(RemittanceNewBaseUI.this.getContext(), 2131765031, 0).show();
              break;
            }
            if (RemittanceNewBaseUI.this.wJu < 0.01D)
            {
              RemittanceNewBaseUI.this.dya();
              break;
            }
            RemittanceNewBaseUI.this.hideWcKb();
            RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.vyB, RemittanceNewBaseUI.this.wMS, null, "", null);
            break;
            label303:
            com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      };
      this.oAV.getContentEt().setOnEditorActionListener(new RemittanceNewBaseUI.31(this, (View.OnClickListener)localObject));
      this.oAV.setmContentAbnormalMoneyCheck(true);
      this.wMH = ((TextView)findViewById(2131304013));
      this.wMI = ((TextView)findViewById(2131296464));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label1028;
      }
      this.wMI.setText(2131762418);
      label506:
      if (!com.tencent.mm.model.u.axL())
      {
        findViewById(2131304014).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68248);
            RemittanceNewBaseUI.this.showCircleStWcKb();
            com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            String str;
            if ((RemittanceNewBaseUI.this.mScene == 1) || (RemittanceNewBaseUI.this.mScene == 6))
            {
              str = RemittanceNewBaseUI.this.getString(2131762418);
              paramAnonymousView = RemittanceNewBaseUI.this.getString(2131762445);
              com.tencent.mm.plugin.report.service.h.wUl.f(14074, new Object[] { Integer.valueOf(1) });
            }
            for (;;)
            {
              com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceNewBaseUI.this, str, RemittanceNewBaseUI.this.mDesc, paramAnonymousView, true, 20, new h.b()new DialogInterface.OnClickListener
              {
                public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
                {
                  AppMethodBeat.i(68245);
                  if (!bs.isNullOrNil(paramAnonymous2CharSequence.toString()))
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
                  ap.n(new Runnable()
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
              if ((bs.jl(RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), 0)) && (RemittanceNewBaseUI.this.wMB))
              {
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceNewBaseUI.this, str, RemittanceNewBaseUI.this.mDesc, paramAnonymousView, RemittanceNewBaseUI.this.wMT, RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.vyB, RemittanceNewBaseUI.this.wMS, true, new a.a()new f.c
                {
                  public final boolean a(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4)
                  {
                    AppMethodBeat.i(68242);
                    RemittanceNewBaseUI.this.wMT = paramAnonymous2Boolean;
                    if (!bs.isNullOrNil(paramAnonymous2String1))
                    {
                      RemittanceNewBaseUI.this.mDesc = paramAnonymous2String1;
                      if (RemittanceNewBaseUI.this.wMT) {
                        break label188;
                      }
                      if (bs.isNullOrNil(paramAnonymous2String2)) {
                        break label146;
                      }
                      RemittanceNewBaseUI.this.mName = paramAnonymous2String2;
                      label65:
                      if (bs.isNullOrNil(paramAnonymous2String3)) {
                        break label160;
                      }
                      RemittanceNewBaseUI.this.vyB = paramAnonymous2String3;
                      label85:
                      if (bs.isNullOrNil(paramAnonymous2String4)) {
                        break label174;
                      }
                      RemittanceNewBaseUI.this.wMS = paramAnonymous2String4;
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
                      RemittanceNewBaseUI.this.vyB = null;
                      break label85;
                      label174:
                      RemittanceNewBaseUI.this.wMS = null;
                      continue;
                      label188:
                      RemittanceNewBaseUI.this.mName = null;
                      RemittanceNewBaseUI.this.vyB = null;
                      RemittanceNewBaseUI.this.wMS = null;
                    }
                  }
                }, new f.c()
                {
                  public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(68244);
                    ap.n(new Runnable()
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
        if (bs.jl(this.wMA, 0))
        {
          this.wJo = ((RelativeLayout)findViewById(2131306751));
          if ((!ab.eUO().equals("zh_CN")) && (!ab.eUO().equals("zh_TW")) && (!ab.eUO().equals("zh_HK"))) {
            break label1041;
          }
          this.wJm = ((RelativeLayout)findViewById(2131306753));
          this.wJn = ((TextView)findViewById(2131306756));
          this.wJm.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68249);
              RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, RemittanceNewBaseUI.f(RemittanceNewBaseUI.this).getWidth());
              RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(8);
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.RemittanceNewBaseUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceNewBaseUI.h(RemittanceNewBaseUI.this)) });
              AppMethodBeat.o(68249);
            }
          });
          this.oAV.setmWalletFormViewListener(new WalletFormView.c()
          {
            public final void p(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(68250);
              if (bs.jl(RemittanceNewBaseUI.this.wIV, 0))
              {
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "mAmountRemindBit == 0");
                RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(8);
                AppMethodBeat.o(68250);
                return;
              }
              long l = Double.valueOf(bs.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
              int j = 0;
              int i = 0;
              while (l != 0L)
              {
                j = (int)(l % 10L);
                l /= 10L;
                i += 1;
              }
              if (i >= RemittanceNewBaseUI.this.wIV)
              {
                j = RemittanceNewBaseUI.this.oAV.n(paramAnonymousCharSequence, RemittanceNewBaseUI.h(RemittanceNewBaseUI.this), j);
                if (j != 0)
                {
                  RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(0);
                  paramAnonymousCharSequence = ag.aN(com.tencent.mm.sdk.platformtools.ai.getContext(), i);
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
        g.agS();
        if (((String)g.agR().agA().get(327732, "0")).equals("0"))
        {
          com.tencent.mm.ui.base.h.a(getContext(), 2131762490, 2131762491, new RemittanceNewBaseUI.35(this));
          g.agS();
          g.agR().agA().set(327732, "1");
          g.agS();
          g.agR().agA().faa();
        }
      }
      this.wMR = ((LinearLayout)findViewById(2131304051));
      dyc();
      dyd();
      dyb();
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        break label1053;
      }
      return;
      setMMTitle(2131762535);
      break;
      label798:
      this.wMJ.setVisibility(8);
      break label351;
      label810:
      this.oAV.getTitleTv().setText(String.format(getString(2131762486), new Object[] { "¥" }));
      this.oAV.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(68219);
          double d = bs.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!RemittanceNewBaseUI.this.oAV.aRO()) || (d < 0.01D))
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
      this.oAV.fAX();
      this.wJe = ((WcPayKeyboard)findViewById(2131307020));
      ln(false);
      setWPKeyboard(this.oAV.getContentEt(), true, false);
      this.oAV.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68220);
          RemittanceNewBaseUI.this.oAV.getContentEt().requestFocus();
          AppMethodBeat.o(68220);
        }
      });
      setWcKbHeightListener(this);
      this.wJe.setActionText(getString(2131762504));
      ((RelativeLayout.LayoutParams)this.wJe.getLayoutParams()).addRule(12);
      findViewById(2131303272);
      findViewById(2131304051).setVisibility(0);
      this.wMM.setVisibility(8);
      this.wMN.setVisibility(0);
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
      this.wMI.setText(2131762417);
      break label506;
      label1041:
      this.wJo.setVisibility(8);
    }
    label1053:
    this.tEk.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68251);
        if ((RemittanceNewBaseUI.j(RemittanceNewBaseUI.this).isShown()) && (RemittanceNewBaseUI.k(RemittanceNewBaseUI.this).fzM()))
        {
          RemittanceNewBaseUI.l(RemittanceNewBaseUI.this).fzK();
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
      return (!this.wPz) && (this.wJe.fzO());
    }
    return this.wJe.fzO();
  }
  
  public boolean needLockPage()
  {
    return (this.mPayScene == 33) || (this.mPayScene == 32);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.foE);
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
        if (!bs.isNullOrNil(str1))
        {
          this.foE = str1;
          dye();
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
              RemittanceNewBaseUI.this.wMT = paramAnonymousBoolean;
              if (!bs.isNullOrNil(paramAnonymousString1))
              {
                RemittanceNewBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceNewBaseUI.this.wMT)
                {
                  if (bs.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceNewBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (bs.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceNewBaseUI.this.vyB = paramAnonymousString3;
                  label70:
                  if (bs.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceNewBaseUI.this.wMS = paramAnonymousString4;; RemittanceNewBaseUI.this.wMS = null)
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
                RemittanceNewBaseUI.this.vyB = null;
                break label70;
              }
            }
          }, new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(68233);
              ap.n(new Runnable()
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
    if (!dyg())
    {
      this.dnh = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.ayV(this.dnh);
    }
    if ((this instanceof RemittanceUI)) {
      this.wMA = 0;
    }
    super.onCreate(paramBundle);
    this.wMw = com.tencent.mm.plugin.wallet.a.aN(getIntent());
    this.wMC = getIntent().getStringExtra("scan_remittance_id");
    this.wJu = getIntent().getDoubleExtra("fee", 0.0D);
    this.foE = getIntent().getStringExtra("receiver_name");
    this.ooX = getIntent().getStringExtra("receiver_nick_name");
    this.wMX = getIntent().getStringExtra("receiver_true_name");
    this.wMx = getIntent().getStringExtra("mch_name");
    this.wMz = getIntent().getStringExtra("mch_info");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.wNc = bs.bG(getIntent().getStringExtra("rcvr_open_id"), "");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "mUserName %s", new Object[] { this.foE });
    g.agS();
    long l = ((Long)g.agR().agA().get(147457, Long.valueOf(0L))).longValue();
    if ((0x10 & l) != 0L)
    {
      this.wNb = 1;
      dyz();
      p.aBh().a(this);
      initView();
      this.wNw.alive();
      com.tencent.mm.wallet_core.b.fzz();
      if ((!com.tencent.mm.wallet_core.b.b(b.a.pRO, true)) || (!((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY"))) {
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
        this.wNb = 2;
        break;
      }
      this.wNb = 0;
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "onDestroy()");
    ap.aB(this.wJB);
    com.tencent.mm.sdk.b.a.GpY.d(this.wNl);
    p.aBh().b(this);
    this.wNw.dead();
    this.wNr.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.ayW(this.dnh);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "onDialogDismiss()");
    ap.n(this.wJB, 300L);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.wJe != null) && (this.wJe.onKeyUp(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "onPause()");
    if (!this.wJe.fzN()) {
      this.state = 3;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    this.wNe = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof w))
      {
        paramn = (w)paramn;
        af.x(this.mPayScene, paramn.djr, paramInt2);
        this.wMW = paramn.wKJ;
        if (!bs.isNullOrNil(paramn.wKR)) {
          this.wMX = paramn.wKR;
        }
        if ((this.mPayScene == 32) || (this.mPayScene == 33))
        {
          this.wNg = paramn.owt;
          if (this.wMw != null) {
            this.wMw.j(10000, new Object[] { Integer.valueOf(this.mPayScene), this.foE, Double.valueOf(paramn.wKU) });
          }
          if (paramn.wLh != null) {
            break label280;
          }
          paramString = "";
          label160:
          this.wNd = paramString;
          if (a(paramn)) {
            break label314;
          }
          a(paramn.djr, this.foE, this.wMX, paramn);
          label193:
          paramString = new a(paramn.wKS, paramn.owt, paramn.oyO, paramn.wKT, paramn.uiK, paramn.dlI, paramn.dad, paramn.wKX, bs.getLong(paramn.wKV, 0L));
          this.wNf.put(paramn.djr, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.wNg = paramn.dlI;
        break;
        label280:
        if (bs.isNullOrNil(paramn.wLh.wNd))
        {
          paramString = this.wNd;
          break label160;
        }
        paramString = paramn.wLh.wNd;
        break label160;
        label314:
        if (!this.mKindaEnable) {
          break label193;
        }
        hideLoading();
        break label193;
        if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
        {
          this.wMY = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).kgH;
          this.wMZ = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Bpl;
          this.wNa = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Bpm;
          dyc();
          dyb();
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceNewBaseUI", "net error, use hardcode wording");
      this.mWcKeyboard.egR();
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
      this.wNi = ((w)paramn);
      com.tencent.mm.sdk.b.a.GpY.c(this.wNl);
      af.x(this.mPayScene, "", paramInt2);
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
    String dad;
    String dlI;
    String owt;
    String oyO;
    int uiK;
    String wKS;
    String wKT;
    String wKX;
    long wNG;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong)
    {
      this.wKS = paramString1;
      this.owt = paramString2;
      this.oyO = paramString3;
      this.wKT = paramString4;
      this.uiK = paramInt;
      this.dlI = paramString5;
      this.dad = paramString6;
      this.wKX = paramString7;
      this.wNG = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
 * JD-Core Version:    0.7.0.1
 */