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
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.a;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.yn;
import com.tencent.mm.g.b.a.hg;
import com.tencent.mm.g.b.a.hn;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.remittance.model.w.a;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 270);
  private String dAa;
  protected int dGt = 0;
  protected String fIQ;
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected String oYU;
  protected WalletFormView pkW;
  private int state = 0;
  protected ScrollView uSG;
  protected String wTG;
  private int ymC;
  private WcPayKeyboard ymE;
  private RelativeLayout ymM;
  private TextView ymN;
  private RelativeLayout ymO;
  protected double ymU;
  protected int ymv = 4;
  private Runnable ync = new Runnable()
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
  private double yon;
  protected com.tencent.mm.plugin.wallet.a ypV = null;
  protected String ypW;
  protected String ypY;
  private int ypZ = -1;
  private int yqA;
  protected String yqB;
  protected String yqC;
  protected String yqD;
  private Map<String, a> yqE = new HashMap();
  private String yqF;
  protected boolean yqG = false;
  private w yqH;
  private hg yqI;
  private boolean yqJ = false;
  private com.tencent.mm.sdk.b.c yqK = new com.tencent.mm.sdk.b.c() {};
  private boolean yqL = false;
  private boolean yqM = false;
  private boolean yqN = false;
  private boolean yqO = false;
  private xr yqP = null;
  private com.tencent.mm.sdk.b.c yqQ = new com.tencent.mm.sdk.b.c() {};
  protected double yqR = 0.0D;
  protected String yqS = "";
  protected String yqT = "";
  protected String yqU = "";
  private com.tencent.mm.sdk.b.c<gk> yqV = new com.tencent.mm.sdk.b.c() {};
  protected boolean yqa = false;
  protected String yqb;
  protected ImageView yqc;
  protected TextView yqd;
  protected TextView yqe;
  protected TextView yqg;
  protected TextView yqh;
  private TextView yqi;
  private TextView yqj;
  protected TextView yqk;
  private LinearLayout yql;
  private LinearLayout yqm;
  private LinearLayout yqn;
  private TextView yqo;
  private TextView yqp;
  private LinearLayout yqq;
  protected String yqr;
  protected boolean yqs = true;
  protected String yqt;
  private String yqv;
  protected String yqw;
  protected String yqx = null;
  protected String yqy = null;
  protected int yqz;
  protected boolean ysY = false;
  
  private void a(w paramw, xr paramxr)
  {
    this.yqJ = true;
    new c(this).a(paramw, paramxr, new c.a()
    {
      public final void axB(String paramAnonymousString)
      {
        AppMethodBeat.i(68234);
        ae.i("MicroMsg.RemittanceNewBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceNewBaseUI.this.yqD = paramAnonymousString;
        RemittanceNewBaseUI.this.dMR();
        AppMethodBeat.o(68234);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(174431);
        RemittanceNewBaseUI.this.yqD = "";
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
      if (this.yqG) {
        com.tencent.mm.plugin.report.service.g.yxI.f(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
      String str = paramIntent.getStringExtra("key_trans_id");
      if (bu.isNullOrNil(this.yqF)) {
        this.yqF = str;
      }
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        com.tencent.mm.plugin.remittance.model.ad.axH(this.fIQ);
      }
      if (this.yon == 0.0D)
      {
        if (this.mScene == 1) {
          com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(17), Integer.valueOf(1) });
        }
      }
      else {
        finish();
      }
    }
    for (;;)
    {
      if (bu.jB(this.ypZ, 0)) {
        b(paramBoolean, paramIntent);
      }
      do
      {
        return;
        com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
        break;
        if (ag.bx(paramIntent))
        {
          finish();
          return;
        }
      } while (ag.by(paramIntent));
      if (this.mScene == 1) {
        com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(16), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
    }
  }
  
  private boolean a(w paramw)
  {
    if (!this.yqL) {}
    for (boolean bool2 = d(paramw);; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.yqM) {
          bool1 = e(paramw);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!this.yqN) {
          bool2 = f(paramw);
        }
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.yqO) {
          bool1 = c(paramw);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bu.isNullOrNil(paramw.you))
        {
          bool2 = bool1;
          if (!bu.isNullOrNil(paramw.yov))
          {
            String str2 = com.tencent.mm.wallet_core.ui.f.gX(com.tencent.mm.wallet_core.ui.f.zP(this.fIQ), 10);
            String str1 = str2;
            if (!bu.isNullOrNil(this.yqw)) {
              str1 = getString(2131762438, new Object[] { str2, this.yqw });
            }
            bool2 = a(paramw.dwj, paramw.yov, str1, paramw.you, paramw);
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
    double d = bu.getDouble(paramString4, 0.0D);
    localTextView3.setText(String.format("%s%.2f", new Object[] { ah.fWc(), Double.valueOf(Double.valueOf(d).doubleValue() / 100.0D) }));
    paramString2 = new d.a(this);
    paramString2.zf(false);
    paramString2.afN(2131762530);
    paramString2.hd(localView);
    paramString2.afU(2131762444);
    paramString2.afV(2131756755);
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
        AppMethodBeat.i(190042);
        RemittanceNewBaseUI.this.showLoading();
        RemittanceNewBaseUI.this.a(paramString1, RemittanceNewBaseUI.this.fIQ, RemittanceNewBaseUI.this.yqw, paramw);
        AppMethodBeat.o(190042);
      }
    });
    paramString2.fQv().show();
    return true;
  }
  
  private static void axK(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.RemittanceNewBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    ae.i("MicroMsg.RemittanceNewBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)bx.M(paramString, "msg").get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      ae.e("MicroMsg.RemittanceNewBaseUI", "paymsgid count't be null in appmsg");
      return;
    }
    com.tencent.mm.plugin.remittance.a.c.dLS().dLV().ja(str, paramString);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    d.a locala = new d.a(paramContext);
    locala.aZh(paramString2);
    locala.aZi(paramString1);
    locala.aZo(paramString3).c(paramOnClickListener1);
    locala.aZp(paramString4).d(paramOnClickListener2);
    locala.zf(false);
    locala.zg(true);
    paramString1 = locala.fQv();
    paramString1.show();
    h.a(paramContext, paramString1);
  }
  
  private void b(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      this.dGt = 1;
    }
    for (;;)
    {
      ae.i("MicroMsg.RemittanceNewBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.dGt), Double.valueOf(this.yqR), this.yqS, this.yqT, this.yqU });
      do
      {
        return;
      } while (paramIntent == null);
      this.dGt = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.yqR = this.ymU;
      this.yqS = this.mDesc;
      this.yqT = this.yqr;
      this.yqU = this.yqF;
    }
  }
  
  private static boolean b(w paramw)
  {
    return ((paramw.yoF == 1) && (paramw.yoG != null)) || ((paramw.yoG != null) && (paramw.yoG.GpC > 0));
  }
  
  private void bJ(int paramInt, String paramString)
  {
    this.yqI = new hg();
    this.yqI.dWt = 2L;
    this.yqI.dQB = paramInt;
    this.yqI.qv(paramString);
    this.yqI.aLH();
  }
  
  private boolean c(final w paramw)
  {
    if ((paramw.dJo != null) && (paramw.dJo.eIw()))
    {
      this.yqO = true;
      h.e(this, paramw.dJo.dyI, "", paramw.dJo.kDa, paramw.dJo.kCZ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68222);
          ae.i("MicroMsg.RemittanceNewBaseUI", "goto h5: %s", new Object[] { paramw.dJo.phk });
          com.tencent.mm.wallet_core.ui.f.p(RemittanceNewBaseUI.this.getContext(), paramw.dJo.phk, false);
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
    if (!bu.isNullOrNil(paramw.yoh))
    {
      this.yqL = true;
      bJ(1, paramw.dyA);
      h.e(this, paramw.yoh, getString(2131755873), getString(2131762444), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68224);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 3, paramw.dyA);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramw.dwj, RemittanceNewBaseUI.this.fIQ, RemittanceNewBaseUI.this.yqw, paramw);
          }
          AppMethodBeat.o(68224);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68225);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 2, paramw.dyA);
          AppMethodBeat.o(68225);
        }
      });
      return true;
    }
    return false;
  }
  
  private void dML()
  {
    if ((dMQ()) && (!bu.isNullOrNil(this.yqy)) && (this.yqA != 0) && (this.yqz == 1))
    {
      addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68215);
          com.tencent.mm.wallet_core.ui.f.p(RemittanceNewBaseUI.this.getContext(), RemittanceNewBaseUI.this.yqy, false);
          AppMethodBeat.o(68215);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void dMM()
  {
    int i;
    if ((!bu.isNullOrNil(this.yqx)) && (this.yqA != 0))
    {
      if (this.yqA == 1) {}
      for (i = 2;; i = 24) {
        try
        {
          this.ymE.setTipText(String.format(this.yqx, new Object[] { Integer.valueOf(i) }));
          return;
        }
        catch (Exception localException)
        {
          ae.i("MicroMsg.RemittanceNewBaseUI", "updatePlaceHolderTv() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          this.ymE.setTipText(getString(2131762496, new Object[] { Integer.valueOf(i) }));
          return;
        }
      }
    }
    this.ymE.eyi();
  }
  
  private void dMP()
  {
    final Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68217);
        Bitmap localBitmap = com.tencent.mm.aj.c.a(RemittanceNewBaseUI.this.fIQ, false, -1, null);
        if (localBitmap == null)
        {
          RemittanceNewBaseUI.this.yqc.setImageResource(2131231875);
          AppMethodBeat.o(68217);
          return;
        }
        RemittanceNewBaseUI.this.yqc.setImageBitmap(localBitmap);
        AppMethodBeat.o(68217);
      }
    };
    if (ar.isMainThread())
    {
      local4.run();
      return;
    }
    ar.f(new Runnable()
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
    if (paramw.yof > 0)
    {
      this.yqM = true;
      if (paramw.yog == null) {
        break label144;
      }
      if (!bu.isNullOrNil(paramw.yog.dyI)) {
        break label121;
      }
      str1 = getString(2131762517, new Object[] { Integer.valueOf(paramw.yof) });
      String str3 = getString(2131762444);
      if (!bu.isNullOrNil(paramw.yog.yoH)) {
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
            RemittanceNewBaseUI.this.a(paramw.dwj, RemittanceNewBaseUI.this.fIQ, RemittanceNewBaseUI.this.yqw, paramw);
          }
          AppMethodBeat.o(68226);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68227);
          if (bu.isNullOrNil(paramw.yog.yoI))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(68227);
            return;
          }
          com.tencent.mm.plugin.account.a.b.a.b(RemittanceNewBaseUI.this, paramw.yog.yoI, 5, true);
          AppMethodBeat.o(68227);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label121:
      str1 = paramw.yog.dyI;
      break;
      label132:
      str2 = paramw.yog.yoH;
      break label87;
      label144:
      ae.i("MicroMsg.RemittanceNewBaseUI", "scene.zaituMessage == null");
      b(this, getString(2131762517, new Object[] { Integer.valueOf(paramw.yof) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68228);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramw))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramw.dwj, RemittanceNewBaseUI.this.fIQ, RemittanceNewBaseUI.this.yqw, paramw);
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
    if (paramw.yom)
    {
      this.yqN = true;
      f.a(this, this.mScene, paramw.yop / 100.0D, paramw.yoo / 100.0D, paramw.yoj / 100.0D, paramw.yol, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68230);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          RemittanceNewBaseUI.this.showLoading();
          RemittanceNewBaseUI.this.a(paramw.dwj, RemittanceNewBaseUI.this.fIQ, RemittanceNewBaseUI.this.yqw, paramw);
          if (RemittanceNewBaseUI.this.mScene == 1) {
            com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68230);
            return;
            com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          }
        }
      });
      return true;
    }
    return false;
  }
  
  private void lG(boolean paramBoolean)
  {
    this.ymE.zx(paramBoolean);
  }
  
  public final void DG(String paramString)
  {
    ae.i("MicroMsg.RemittanceNewBaseUI", "onGet");
    if (bu.nullAsNil(paramString).length() <= 0) {
      ae.e("MicroMsg.RemittanceNewBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.fIQ)) {
      return;
    }
    dMP();
  }
  
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, gi paramgi);
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final w paramw)
  {
    if (b(paramw))
    {
      if (paramw.yoG.GpC == 0)
      {
        this.yqP = paramw.yoG;
        a(paramw, paramw.yoG);
      }
      do
      {
        return;
        if (paramw.yoG.GpC == 1)
        {
          localObject1 = new hn();
          ((hn)localObject1).etH = ((int)paramw.yot);
          localObject1 = ((hn)localObject1).qx(paramw.username);
          ((hn)localObject1).etA = 4L;
          ((hn)localObject1).aLH();
          h.a(this, paramw.yoG.dyI, paramw.yoG.title, getResources().getString(2131762540), getResources().getString(2131762539), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68236);
              ae.i("MicroMsg.RemittanceNewBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceNewBaseUI.p(RemittanceNewBaseUI.this) });
              paramAnonymousDialogInterface = new hn();
              paramAnonymousDialogInterface.etH = ((int)paramw.yot);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.qx(paramw.username);
              paramAnonymousDialogInterface.etA = 9L;
              paramAnonymousDialogInterface.aLH();
              paramw.yoG = null;
              RemittanceNewBaseUI.this.a(paramString1, paramString2, paramString3, paramw);
              AppMethodBeat.o(68236);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68237);
              ae.i("MicroMsg.RemittanceNewBaseUI", "onClick1");
              paramAnonymousDialogInterface = new hn();
              paramAnonymousDialogInterface.etH = ((int)paramw.yot);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.qx(paramw.username);
              paramAnonymousDialogInterface.etA = 8L;
              paramAnonymousDialogInterface.aLH();
              RemittanceNewBaseUI.this.hideLoading();
              AppMethodBeat.o(68237);
            }
          }, 2131100777);
          return;
        }
      } while (paramw.yoG.GpC != 2);
      h.a(this, paramw.yoG.dyI, paramw.yoG.title, getResources().getString(2131766205), new DialogInterface.OnClickListener()
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
    if (this.yqJ)
    {
      localObject1 = new hn();
      ((hn)localObject1).etH = paramw.vxx;
      localObject1 = ((hn)localObject1).qx(paramw.username);
      ((hn)localObject1).etA = 5L;
      ((hn)localObject1).aLH();
    }
    this.yqJ = false;
    if (this.mPayScene == 31) {
      axK(this.yqv);
    }
    Object localObject1 = new PayInfo();
    ((PayInfo)localObject1).dmw = paramString1;
    ((PayInfo)localObject1).dDH = this.mPayScene;
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
    paramString1.putString("extinfo_key_3", this.yqt);
    paramString1.putBoolean("extinfo_key_4", bool);
    paramString1.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
    paramString1.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
    paramString1.putString("extinfo_key_7", this.mDesc);
    paramString1.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
    paramString1.putString("extinfo_key_16", this.yqF);
    if (paramw != null) {
      paramString1.putString("extinfo_key_19", paramw.yoD);
    }
    int j = 0;
    int i = j;
    if (this.mScene == 1)
    {
      i = j;
      if (paramw != null)
      {
        paramString1.putString("extinfo_key_11", paramw.yor);
        paramString1.putInt("extinfo_key_12", paramw.yox);
        paramString1.putString("extinfo_key_13", paramw.yoy);
        paramString1.putString("extinfo_key_14", paramw.yoz);
        paramString1.putString("extinfo_key_17", paramw.yoB);
        paramString1.putString("extinfo_key_18", paramw.yoC);
        i = paramw.yoA;
      }
    }
    if (paramw != null) {
      paramString1.putInt("extinfo_key_15", paramw.vxx);
    }
    if (this.yqa)
    {
      paramString1.putBoolean("extinfo_key_23", this.yqa);
      paramString1.putString("extinfo_key_24", this.mName);
      paramString1.putString("extinfo_key_25", this.wTG);
      paramString1.putString("extinfo_key_26", this.yqr);
    }
    ((PayInfo)localObject1).hwN = paramString1;
    paramString1 = new Intent();
    ae.i("MicroMsg.RemittanceNewBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      paramString1.setClass(this, RemittanceF2fDynamicCodeUI.class);
      paramString1.putExtra("key_pay_info", (Parcelable)localObject1);
      paramString1.putExtra("key_rcvr_open_id", this.yqB);
      paramString1.putExtra("key_mch_info", this.ypY);
      paramString1.putExtra("from_patch_ui", true);
      paramString1.putExtra("get_dynamic_code_sign", paramw.yoB);
      paramString1.putExtra("get_dynamic_code_extend", paramw.yoC);
      paramString1.putExtra("dynamic_code_spam_wording", paramw.yoE);
      paramString1.putExtra("show_paying_wording", paramw.yoD);
      paramString1.putExtra("key_transfer_qrcode_id", this.yqb);
      com.tencent.mm.plugin.report.service.g.yxI.f(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      this.yqQ.alive();
      startActivityForResult(paramString1, 5);
      return;
    }
    if (this.mKindaEnable)
    {
      paramw = "";
      paramString3 = "";
      Object localObject2 = getString(2131765746);
      if (!bu.isNullOrNil(paramString2))
      {
        com.tencent.mm.kernel.g.ajS();
        paramString1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUK(paramString2);
        if (paramString1 != null)
        {
          paramString3 = paramString1.adG();
          paramw = new StringBuilder().append(com.tencent.mm.wallet_core.ui.f.bar(paramString3));
          if (bu.isNullOrNil(this.yqw))
          {
            paramString1 = "";
            paramString1 = paramString1;
            paramw = bu.x((String)localObject2, new Object[] { paramString1 });
            paramString3 = getString(2131762525, new Object[] { com.tencent.mm.wallet_core.ui.f.bar(paramString3) });
          }
        }
      }
      for (;;)
      {
        if (((PayInfo)localObject1).hwN == null) {
          ((PayInfo)localObject1).hwN = new Bundle();
        }
        localObject2 = ((PayInfo)localObject1).hwN;
        ((Bundle)localObject2).putString("extinfo_key_1", paramString2);
        ((Bundle)localObject2).putString("extinfo_key_2", this.yqw);
        ((Bundle)localObject2).putString("cashier_desc", paramw);
        ((Bundle)localObject2).putString("prepay_page_payee", paramString1);
        ((Bundle)localObject2).putString("succ_tip", paramString3);
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, (PayInfo)localObject1);
        this.ysY = true;
        return;
        paramString1 = "(" + this.yqw + ")";
        break;
        ae.e("MicroMsg.RemittanceNewBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        ae.e("MicroMsg.RemittanceNewBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.ypV, paramString1);
    ((PayInfo)localObject1).FEx = this.dAa;
    ((PayInfo)localObject1).beA = this.yqG;
    if ((paramw.ynN != null) && (paramw.ynN.dtd.dtg != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramw.ynN.dtd.dtg, false, "", (PayInfo)localObject1, paramString3, paramString1, paramw.ynN.dtd.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public final void bv(float paramFloat) {}
  
  public final void dMI()
  {
    u localu = new u(this.fIQ, this.yqb);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
  }
  
  public abstract void dMK();
  
  public abstract void dMN();
  
  protected final void dMO()
  {
    Object localObject1 = com.tencent.mm.wallet_core.ui.f.gX(com.tencent.mm.wallet_core.ui.f.zP(this.fIQ), 10);
    Object localObject2 = localObject1;
    if (!bu.isNullOrNil(this.yqw)) {
      localObject2 = getString(2131762438, new Object[] { localObject1, this.yqw });
    }
    if (this.mScene == 1)
    {
      localObject2 = getIntent().getStringExtra("receiver_tips");
      this.yqd.setTextColor(getResources().getColor(2131100711));
      this.yqe.setVisibility(0);
      if (bu.isNullOrNil(this.fIQ))
      {
        localObject1 = getString(2131762441, new Object[] { this.yqw });
        this.yqe.setText(k.b(this, (CharSequence)localObject1, this.yqe.getTextSize()));
        localObject1 = localObject2;
        label152:
        this.yqd.setText(k.b(this, (CharSequence)localObject1, this.yqd.getTextSize()));
        if (!com.tencent.mm.kernel.g.ajM()) {
          break label375;
        }
        localObject1 = p.aEN();
        if ((localObject1 == null) || (bu.isNullOrNil(this.fIQ))) {
          break label375;
        }
        localObject1 = ((j)localObject1).DL(this.fIQ);
        if ((localObject1 != null) && (!bu.isNullOrNil(((i)localObject1).aEH()))) {
          break label375;
        }
        final long l = bu.fpO();
        au.a.hIG.a(this.fIQ, "", new au.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(68216);
            if (paramAnonymousBoolean)
            {
              ae.v("MicroMsg.RemittanceNewBaseUI", "getContact suc; cost=" + (bu.fpO() - l) + " ms");
              com.tencent.mm.aj.c.al(paramAnonymousString, 3);
            }
            for (;;)
            {
              RemittanceNewBaseUI.m(RemittanceNewBaseUI.this);
              AppMethodBeat.o(68216);
              return;
              ae.w("MicroMsg.RemittanceNewBaseUI", "getContact failed");
            }
          }
        });
      }
    }
    label375:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        dMP();
      }
      return;
      localObject1 = getString(2131762440, new Object[] { com.tencent.mm.wallet_core.ui.f.gX(com.tencent.mm.wallet_core.ui.f.zP(this.fIQ), 10), this.yqw });
      break;
      localObject1 = localObject2;
      if (this.mScene != 6) {
        break label152;
      }
      localObject1 = getIntent().getStringExtra("receiver_tips");
      if (bu.isNullOrNil((String)localObject1))
      {
        localObject1 = getString(2131762439, new Object[] { localObject2 });
        break label152;
      }
      localObject1 = bu.x((String)localObject1, new Object[] { localObject2 });
      break label152;
    }
  }
  
  protected final boolean dMQ()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  protected final void dMR()
  {
    if (this.mPayScene == 33)
    {
      a(this.mDesc, this.ypZ, this.mName, this.wTG, this.yqr, this.yqt, "", null);
      return;
    }
    a(this.mDesc, this.ypZ, this.mName, this.wTG, this.yqr, null, "", null);
  }
  
  public abstract void dNj();
  
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
            RemittanceNewBaseUI.this.dMI();
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
              localIntent.putExtra("recent_remittance_contact_list", com.tencent.mm.plugin.remittance.model.ad.dMA());
              localIntent.setClass(paramAnonymousMenuItem.getContext(), SelectRemittanceContactUI.class);
              paramAnonymousMenuItem.startActivityForResult(localIntent, 2);
            }
          }
        }
      });
      this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
      this.mKBLayout = findViewById(2131305693);
      this.uSG = ((ScrollView)findViewById(2131304251));
      this.yqc = ((ImageView)findViewById(2131304060));
      this.yqd = ((TextView)findViewById(2131304061));
      this.yqe = ((TextView)findViewById(2131304062));
      this.yqe.setVisibility(8);
      this.yqm = ((LinearLayout)findViewById(2131304033));
      this.yql = ((LinearLayout)findViewById(2131304042));
      this.yqj = ((TextView)findViewById(2131304040));
      this.yqk = ((TextView)findViewById(2131304041));
      this.yqi = ((TextView)findViewById(2131304036));
      this.yqn = ((LinearLayout)findViewById(2131303987));
      this.yqo = ((TextView)findViewById(2131302665));
      this.yqp = ((TextView)findViewById(2131296478));
      dMO();
      this.pkW = ((WalletFormView)findViewById(2131302446));
      if (this.mPayScene != 33) {
        break label810;
      }
      this.yqj.setText(com.tencent.mm.wallet_core.ui.f.C(this.ymU));
      this.yqk.setText(ah.fWc());
      this.yqt = getIntent().getStringExtra("desc");
      if (bu.isNullOrNil(this.yqt)) {
        break label798;
      }
      this.yqi.setText(k.b(getContext(), this.yqt, this.yqi.getTextSize()));
      this.yqi.setVisibility(0);
      this.yql.setVisibility(0);
      this.yqm.setVisibility(8);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (RemittanceNewBaseUI.this.mPayScene == 33)
          {
            RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.wTG, RemittanceNewBaseUI.this.yqr, RemittanceNewBaseUI.this.yqt, "", null);
            if (RemittanceNewBaseUI.c(RemittanceNewBaseUI.this) == 0.0D)
            {
              if (RemittanceNewBaseUI.this.mScene != 1) {
                break label344;
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceNewBaseUI.this.mScene == 1) && (!bu.isNullOrNil(RemittanceNewBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.g.yxI.f(14074, new Object[] { Integer.valueOf(2) });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68235);
            return;
            RemittanceNewBaseUI.this.ymU = bu.getDouble(RemittanceNewBaseUI.this.pkW.getText(), 0.0D);
            if (!RemittanceNewBaseUI.this.pkW.aVz())
            {
              t.makeText(RemittanceNewBaseUI.this.getContext(), 2131765031, 0).show();
              break;
            }
            if (RemittanceNewBaseUI.this.ymU < 0.01D)
            {
              RemittanceNewBaseUI.this.dMK();
              break;
            }
            RemittanceNewBaseUI.this.hideWcKb();
            RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.wTG, RemittanceNewBaseUI.this.yqr, null, "", null);
            break;
            label344:
            com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      };
      this.pkW.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(68241);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            ae.i("MicroMsg.RemittanceNewBaseUI", "click enter");
            this.ynf.onClick(null);
            AppMethodBeat.o(68241);
            return true;
          }
          AppMethodBeat.o(68241);
          return true;
        }
      });
      this.pkW.setmContentAbnormalMoneyCheck(true);
      this.yqg = ((TextView)findViewById(2131304013));
      this.yqh = ((TextView)findViewById(2131296464));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label1028;
      }
      this.yqh.setText(2131762418);
      label506:
      if (!v.aAR())
      {
        findViewById(2131304014).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68248);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            RemittanceNewBaseUI.this.showCircleStWcKb();
            com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            if ((RemittanceNewBaseUI.this.mScene == 1) || (RemittanceNewBaseUI.this.mScene == 6))
            {
              localObject = RemittanceNewBaseUI.this.getString(2131762418);
              paramAnonymousView = RemittanceNewBaseUI.this.getString(2131762445);
              com.tencent.mm.plugin.report.service.g.yxI.f(14074, new Object[] { Integer.valueOf(1) });
            }
            for (;;)
            {
              com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceNewBaseUI.this, (String)localObject, RemittanceNewBaseUI.this.mDesc, paramAnonymousView, true, 20, new h.b()new DialogInterface.OnClickListener
              {
                public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
                {
                  AppMethodBeat.i(68245);
                  if (!bu.isNullOrNil(paramAnonymous2CharSequence.toString()))
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
                  ar.o(new Runnable()
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
              if ((bu.jB(RemittanceNewBaseUI.b(RemittanceNewBaseUI.this), 0)) && (RemittanceNewBaseUI.this.yqa))
              {
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceNewBaseUI.this, (String)localObject, RemittanceNewBaseUI.this.mDesc, paramAnonymousView, RemittanceNewBaseUI.this.yqs, RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.wTG, RemittanceNewBaseUI.this.yqr, true, new a.a()new f.c
                {
                  public final boolean a(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4)
                  {
                    AppMethodBeat.i(68242);
                    RemittanceNewBaseUI.this.yqs = paramAnonymous2Boolean;
                    if (!bu.isNullOrNil(paramAnonymous2String1))
                    {
                      RemittanceNewBaseUI.this.mDesc = paramAnonymous2String1;
                      if (RemittanceNewBaseUI.this.yqs) {
                        break label188;
                      }
                      if (bu.isNullOrNil(paramAnonymous2String2)) {
                        break label146;
                      }
                      RemittanceNewBaseUI.this.mName = paramAnonymous2String2;
                      label65:
                      if (bu.isNullOrNil(paramAnonymous2String3)) {
                        break label160;
                      }
                      RemittanceNewBaseUI.this.wTG = paramAnonymous2String3;
                      label85:
                      if (bu.isNullOrNil(paramAnonymous2String4)) {
                        break label174;
                      }
                      RemittanceNewBaseUI.this.yqr = paramAnonymous2String4;
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
                      RemittanceNewBaseUI.this.wTG = null;
                      break label85;
                      label174:
                      RemittanceNewBaseUI.this.yqr = null;
                      continue;
                      label188:
                      RemittanceNewBaseUI.this.mName = null;
                      RemittanceNewBaseUI.this.wTG = null;
                      RemittanceNewBaseUI.this.yqr = null;
                    }
                  }
                }, new f.c()
                {
                  public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(68244);
                    ar.o(new Runnable()
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
        if (bu.jB(this.ypZ, 0))
        {
          this.ymO = ((RelativeLayout)findViewById(2131306751));
          if ((!com.tencent.mm.sdk.platformtools.ad.fom().equals("zh_CN")) && (!com.tencent.mm.sdk.platformtools.ad.fom().equals("zh_TW")) && (!com.tencent.mm.sdk.platformtools.ad.fom().equals("zh_HK"))) {
            break label1041;
          }
          this.ymM = ((RelativeLayout)findViewById(2131306753));
          this.ymN = ((TextView)findViewById(2131306756));
          this.ymM.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(68249);
              RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, RemittanceNewBaseUI.f(RemittanceNewBaseUI.this).getWidth());
              RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(8);
              ae.d("MicroMsg.RemittanceNewBaseUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceNewBaseUI.h(RemittanceNewBaseUI.this)) });
              AppMethodBeat.o(68249);
            }
          });
          this.pkW.setmWalletFormViewListener(new WalletFormView.c()
          {
            public final void p(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(68250);
              if (bu.jB(RemittanceNewBaseUI.this.ymv, 0))
              {
                ae.i("MicroMsg.RemittanceNewBaseUI", "mAmountRemindBit == 0");
                RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(8);
                AppMethodBeat.o(68250);
                return;
              }
              long l = Double.valueOf(bu.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
              int j = 0;
              int i = 0;
              while (l != 0L)
              {
                j = (int)(l % 10L);
                l /= 10L;
                i += 1;
              }
              if (i >= RemittanceNewBaseUI.this.ymv)
              {
                j = RemittanceNewBaseUI.this.pkW.j(paramAnonymousCharSequence, RemittanceNewBaseUI.h(RemittanceNewBaseUI.this), j);
                if (j != 0)
                {
                  RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setVisibility(0);
                  paramAnonymousCharSequence = ag.aQ(ak.getContext(), i);
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
        com.tencent.mm.kernel.g.ajS();
        if (((String)com.tencent.mm.kernel.g.ajR().ajA().get(327732, "0")).equals("0"))
        {
          h.a(getContext(), 2131762490, 2131762491, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(327732, "1");
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().fuc();
        }
      }
      this.yqq = ((LinearLayout)findViewById(2131304051));
      dMM();
      dMN();
      dML();
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        break label1053;
      }
      return;
      setMMTitle(2131762535);
      break;
      label798:
      this.yqi.setVisibility(8);
      break label351;
      label810:
      this.pkW.getTitleTv().setText(String.format(getString(2131762486), new Object[] { "¥" }));
      this.pkW.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(68219);
          double d = bu.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!RemittanceNewBaseUI.this.pkW.aVz()) || (d < 0.01D))
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
      this.pkW.fWD();
      this.ymE = ((WcPayKeyboard)findViewById(2131307020));
      lG(false);
      setWPKeyboard(this.pkW.getContentEt(), true, false);
      this.pkW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68220);
          RemittanceNewBaseUI.this.pkW.getContentEt().requestFocus();
          AppMethodBeat.o(68220);
        }
      });
      setWcKbHeightListener(this);
      this.ymE.setActionText(getString(2131762504));
      ((RelativeLayout.LayoutParams)this.ymE.getLayoutParams()).addRule(12);
      findViewById(2131303272);
      findViewById(2131304051).setVisibility(0);
      this.yql.setVisibility(8);
      this.yqm.setVisibility(0);
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
      this.yqh.setText(2131762417);
      break label506;
      label1041:
      this.ymO.setVisibility(8);
    }
    label1053:
    this.uSG.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(68251);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if ((RemittanceNewBaseUI.j(RemittanceNewBaseUI.this).isShown()) && (RemittanceNewBaseUI.k(RemittanceNewBaseUI.this).fVs()))
        {
          RemittanceNewBaseUI.l(RemittanceNewBaseUI.this).fVq();
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
      return (!this.ysY) && (this.ymE.fVu());
    }
    return this.ymE.fVu();
  }
  
  public boolean needLockPage()
  {
    return (this.mPayScene == 33) || (this.mPayScene == 32);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    ae.i("MicroMsg.RemittanceNewBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.fIQ);
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
        if (!bu.isNullOrNil(str1))
        {
          this.fIQ = str1;
          dMO();
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
              RemittanceNewBaseUI.this.yqs = paramAnonymousBoolean;
              if (!bu.isNullOrNil(paramAnonymousString1))
              {
                RemittanceNewBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceNewBaseUI.this.yqs)
                {
                  if (bu.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceNewBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (bu.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceNewBaseUI.this.wTG = paramAnonymousString3;
                  label70:
                  if (bu.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceNewBaseUI.this.yqr = paramAnonymousString4;; RemittanceNewBaseUI.this.yqr = null)
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
                RemittanceNewBaseUI.this.wTG = null;
                break label70;
              }
            }
          }, new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(68233);
              ar.o(new Runnable()
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
    if (!dMQ())
    {
      this.dAa = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.aFw(this.dAa);
    }
    if ((this instanceof RemittanceUI)) {
      this.ypZ = 0;
    }
    super.onCreate(paramBundle);
    this.ypV = com.tencent.mm.plugin.wallet.a.aT(getIntent());
    this.yqb = getIntent().getStringExtra("scan_remittance_id");
    this.ymU = getIntent().getDoubleExtra("fee", 0.0D);
    this.fIQ = getIntent().getStringExtra("receiver_name");
    this.oYU = getIntent().getStringExtra("receiver_nick_name");
    this.yqw = getIntent().getStringExtra("receiver_true_name");
    this.ypW = getIntent().getStringExtra("mch_name");
    this.ypY = getIntent().getStringExtra("mch_info");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.yqB = bu.bI(getIntent().getStringExtra("rcvr_open_id"), "");
    ae.i("MicroMsg.RemittanceNewBaseUI", "mUserName %s", new Object[] { this.fIQ });
    com.tencent.mm.kernel.g.ajS();
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(147457, Long.valueOf(0L))).longValue();
    if ((0x10 & l) != 0L)
    {
      this.yqA = 1;
      dNj();
      p.aEA().a(this);
      initView();
      this.yqV.alive();
      com.tencent.mm.wallet_core.b.fVf();
      if ((!com.tencent.mm.wallet_core.b.b(b.a.qDk, true)) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY"))) {
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
        this.yqA = 2;
        break;
      }
      this.yqA = 0;
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ae.i("MicroMsg.RemittanceNewBaseUI", "onDestroy()");
    ar.ay(this.ync);
    com.tencent.mm.sdk.b.a.IvT.d(this.yqK);
    p.aEA().b(this);
    this.yqV.dead();
    this.yqQ.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.aFx(this.dAa);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    ae.i("MicroMsg.RemittanceNewBaseUI", "onDialogDismiss()");
    ar.o(this.ync, 300L);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.ymE != null) && (this.ymE.onKeyUp(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    ae.i("MicroMsg.RemittanceNewBaseUI", "onPause()");
    if (!this.ymE.fVt()) {
      this.state = 3;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ae.i("MicroMsg.RemittanceNewBaseUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    this.yqD = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof w))
      {
        paramn = (w)paramn;
        af.w(this.mPayScene, paramn.dwj, paramInt2);
        this.yqv = paramn.yoi;
        if (!bu.isNullOrNil(paramn.yoq)) {
          this.yqw = paramn.yoq;
        }
        if ((this.mPayScene == 32) || (this.mPayScene == 33))
        {
          this.yqF = paramn.pgs;
          if (this.ypV != null) {
            this.ypV.j(10000, new Object[] { Integer.valueOf(this.mPayScene), this.fIQ, Double.valueOf(paramn.yot) });
          }
          if (paramn.yoG != null) {
            break label280;
          }
          paramString = "";
          label160:
          this.yqC = paramString;
          if (a(paramn)) {
            break label314;
          }
          a(paramn.dwj, this.fIQ, this.yqw, paramn);
          label193:
          paramString = new a(paramn.yor, paramn.pgs, paramn.piP, paramn.yos, paramn.vxx, paramn.dyA, paramn.dmx, paramn.yow, bu.getLong(paramn.you, 0L));
          this.yqE.put(paramn.dwj, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.yqF = paramn.dyA;
        break;
        label280:
        if (bu.isNullOrNil(paramn.yoG.yqC))
        {
          paramString = this.yqC;
          break label160;
        }
        paramString = paramn.yoG.yqC;
        break label160;
        label314:
        if (!this.mKindaEnable) {
          break label193;
        }
        hideLoading();
        break label193;
        if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
        {
          this.yqx = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).kEK;
          this.yqy = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Dhf;
          this.yqz = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Dhg;
          dMM();
          dML();
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
    {
      ae.i("MicroMsg.RemittanceNewBaseUI", "net error, use hardcode wording");
      this.mWcKeyboard.eyi();
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
      this.yqH = ((w)paramn);
      com.tencent.mm.sdk.b.a.IvT.c(this.yqK);
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
    String dmx;
    String dyA;
    String pgs;
    String piP;
    int vxx;
    String yor;
    String yos;
    String yow;
    long yrf;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong)
    {
      this.yor = paramString1;
      this.pgs = paramString2;
      this.piP = paramString3;
      this.yos = paramString4;
      this.vxx = paramInt;
      this.dyA = paramString5;
      this.dmx = paramString6;
      this.yow = paramString7;
      this.yrf = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
 * JD-Core Version:    0.7.0.1
 */