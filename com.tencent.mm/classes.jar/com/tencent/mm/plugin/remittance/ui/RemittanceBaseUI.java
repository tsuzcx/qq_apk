package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
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
import com.tencent.mm.plugin.remittance.model.ad;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.plugin.remittance.model.w.a;
import com.tencent.mm.plugin.wallet_core.c.ai;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public abstract class RemittanceBaseUI
  extends WalletBaseUI
  implements e.a
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 270);
  private String dAa;
  protected int dGt = 0;
  protected String fIQ;
  protected Button jtd;
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected String oYU;
  protected WalletFormView pkW;
  protected ScrollView uSG;
  protected String wTG;
  protected double ymU;
  private double yon;
  protected com.tencent.mm.plugin.wallet.a ypV = null;
  protected String ypW;
  protected String ypX;
  protected String ypY;
  private int ypZ = -1;
  private int yqA;
  protected String yqB;
  protected String yqC;
  protected String yqD;
  private Map<String, a> yqE = new HashMap();
  private String yqF;
  protected boolean yqG = false;
  private com.tencent.mm.plugin.remittance.model.w yqH;
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
  protected TextView yqf;
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
  private String yqu;
  private String yqv;
  protected String yqw;
  protected String yqx = null;
  protected String yqy = null;
  protected int yqz;
  
  private void a(com.tencent.mm.plugin.remittance.model.w paramw, xr paramxr)
  {
    this.yqJ = true;
    new c(this).a(paramw, paramxr, new c.a()
    {
      public final void axB(String paramAnonymousString)
      {
        AppMethodBeat.i(67967);
        ae.i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceBaseUI.this.yqD = paramAnonymousString;
        RemittanceBaseUI.this.dMR();
        AppMethodBeat.o(67967);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(190013);
        RemittanceBaseUI.this.yqD = "";
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(190013);
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
        ad.axH(this.fIQ);
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
  
  private boolean a(com.tencent.mm.plugin.remittance.model.w paramw)
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
      String str;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bu.isNullOrNil(paramw.you))
        {
          bool2 = bool1;
          if (!bu.isNullOrNil(paramw.yov))
          {
            str = com.tencent.mm.wallet_core.ui.f.gX(com.tencent.mm.wallet_core.ui.f.zP(this.fIQ), 10);
            if (!bu.isNullOrNil(this.oYU)) {
              str = this.oYU;
            }
            if (bu.isNullOrNil(this.yqw)) {
              break label193;
            }
            str = getString(2131762438, new Object[] { str, this.yqw });
          }
        }
      }
      label193:
      for (;;)
      {
        bool2 = a(paramw.dwj, paramw.yov, str, paramw.you, paramw);
        return bool2;
      }
    }
  }
  
  private boolean a(final String paramString1, String paramString2, String paramString3, String paramString4, final com.tencent.mm.plugin.remittance.model.w paramw)
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
        AppMethodBeat.i(67978);
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(67978);
      }
    });
    paramString2.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(190014);
        RemittanceBaseUI.this.showLoading();
        RemittanceBaseUI.this.a(paramString1, RemittanceBaseUI.this.fIQ, RemittanceBaseUI.this.yqw, paramw);
        AppMethodBeat.o(190014);
      }
    });
    paramString2.fQv().show();
    return true;
  }
  
  private static void axK(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    ae.i("MicroMsg.RemittanceBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)bx.M(paramString, "msg").get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      ae.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
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
      ae.i("MicroMsg.RemittanceBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.dGt), Double.valueOf(this.yqR), this.yqS, this.yqT, this.yqU });
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
  
  private static boolean b(com.tencent.mm.plugin.remittance.model.w paramw)
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
  
  private boolean c(final com.tencent.mm.plugin.remittance.model.w paramw)
  {
    if ((paramw.dJo != null) && (paramw.dJo.eIw()))
    {
      this.yqO = true;
      h.e(this, paramw.dJo.dyI, "", paramw.dJo.kDa, paramw.dJo.kCZ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67955);
          ae.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[] { paramw.dJo.phk });
          com.tencent.mm.wallet_core.ui.f.p(RemittanceBaseUI.this.getContext(), paramw.dJo.phk, false);
          AppMethodBeat.o(67955);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      return true;
    }
    return false;
  }
  
  private boolean d(final com.tencent.mm.plugin.remittance.model.w paramw)
  {
    if (!bu.isNullOrNil(paramw.yoh))
    {
      this.yqL = true;
      bJ(1, paramw.dyA);
      h.e(this, paramw.yoh, getString(2131755873), getString(2131762444), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67956);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 3, paramw.dyA);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw))
          {
            RemittanceBaseUI.this.showLoading();
            RemittanceBaseUI.this.a(paramw.dwj, RemittanceBaseUI.this.fIQ, RemittanceBaseUI.this.yqw, paramw);
          }
          AppMethodBeat.o(67956);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67957);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 2, paramw.dyA);
          AppMethodBeat.o(67957);
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
          AppMethodBeat.i(67980);
          com.tencent.mm.wallet_core.ui.f.p(RemittanceBaseUI.this.getContext(), RemittanceBaseUI.this.yqy, false);
          AppMethodBeat.o(67980);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void dMM()
  {
    if ((!bu.isNullOrNil(this.yqx)) && (this.yqA != 0))
    {
      int i;
      if (this.yqA == 1) {
        i = 2;
      }
      try
      {
        for (;;)
        {
          this.yqf.setText(String.format(this.yqx, new Object[] { Integer.valueOf(i) }));
          this.yqf.setVisibility(0);
          return;
          i = 24;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.RemittanceBaseUI", localException, "", new Object[0]);
          this.yqf.setText(getString(2131762496, new Object[] { Integer.valueOf(i) }));
        }
      }
    }
    this.yqf.setText("");
    this.yqf.setVisibility(8);
  }
  
  private void dMO()
  {
    Object localObject2 = com.tencent.mm.wallet_core.ui.f.gX(com.tencent.mm.wallet_core.ui.f.zP(this.fIQ), 10);
    Object localObject1 = localObject2;
    if (!bu.isNullOrNil(this.yqw)) {
      localObject1 = getString(2131762438, new Object[] { localObject2, this.yqw });
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
        label148:
        this.yqd.setText(k.b(this, (CharSequence)localObject2, this.yqd.getTextSize()));
        if (!com.tencent.mm.kernel.g.ajM()) {
          break label488;
        }
        localObject1 = p.aEN();
        if ((localObject1 == null) || (bu.isNullOrNil(this.fIQ))) {
          break label488;
        }
        localObject1 = ((j)localObject1).DL(this.fIQ);
        if ((localObject1 != null) && (!bu.isNullOrNil(((i)localObject1).aEH()))) {
          break label488;
        }
        final long l = bu.fpO();
        au.a.hIG.a(this.fIQ, "", new au.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(67981);
            if (paramAnonymousBoolean)
            {
              ae.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (bu.fpO() - l) + " ms");
              com.tencent.mm.aj.c.al(paramAnonymousString, 3);
            }
            for (;;)
            {
              RemittanceBaseUI.e(RemittanceBaseUI.this);
              AppMethodBeat.o(67981);
              return;
              ae.w("MicroMsg.RemittanceBaseUI", "getContact failed");
            }
          }
        });
      }
    }
    label488:
    for (int i = 1;; i = 0)
    {
      if ((bu.isNullOrNil(this.fIQ)) && (!bu.isNullOrNil(this.ypX)))
      {
        ae.i("MicroMsg.RemittanceBaseUI", "use mRecvHeadimgurl(%s) to avatar, mReceiverAvatarIv:%s", new Object[] { this.ypX, this.yqc.getClass().getSimpleName() });
        if ((this.yqc instanceof CdnImageView))
        {
          i = BackwardSupportUtil.b.h(this, 44.0F);
          ((CdnImageView)this.yqc).setRoundCorner(true);
          ((CdnImageView)this.yqc).r(this.ypX, i, i, 2131231875);
        }
      }
      while (i != 0)
      {
        return;
        localObject1 = getString(2131762440, new Object[] { com.tencent.mm.wallet_core.ui.f.gX(com.tencent.mm.wallet_core.ui.f.zP(this.fIQ), 10), this.yqw });
        break;
        localObject2 = localObject1;
        if (this.mScene != 6) {
          break label148;
        }
        localObject2 = getIntent().getStringExtra("receiver_tips");
        if (!bu.isNullOrNil(this.oYU)) {
          localObject1 = this.oYU;
        }
        if (bu.isNullOrNil((String)localObject2))
        {
          localObject2 = getString(2131762439, new Object[] { localObject1 });
          break label148;
        }
        localObject2 = bu.x((String)localObject2, new Object[] { localObject1 });
        break label148;
      }
      dMP();
      return;
    }
  }
  
  private void dMP()
  {
    final Runnable local30 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67982);
        Bitmap localBitmap = com.tencent.mm.aj.c.a(RemittanceBaseUI.this.fIQ, false, -1, null);
        if (localBitmap == null)
        {
          RemittanceBaseUI.this.yqc.setImageResource(2131231875);
          AppMethodBeat.o(67982);
          return;
        }
        RemittanceBaseUI.this.yqc.setImageBitmap(localBitmap);
        AppMethodBeat.o(67982);
      }
    };
    if (ar.isMainThread())
    {
      local30.run();
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67983);
        local30.run();
        AppMethodBeat.o(67983);
      }
    });
  }
  
  private boolean dMQ()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  private boolean e(final com.tencent.mm.plugin.remittance.model.w paramw)
  {
    boolean bool = false;
    String str1;
    String str2;
    if (paramw.yof > 0)
    {
      this.yqM = true;
      if (paramw.yog == null) {
        break label143;
      }
      if (!bu.isNullOrNil(paramw.yog.dyI)) {
        break label120;
      }
      str1 = getString(2131762517, new Object[] { Integer.valueOf(paramw.yof) });
      String str3 = getString(2131762444);
      if (!bu.isNullOrNil(paramw.yog.yoH)) {
        break label131;
      }
      str2 = getString(2131762505);
      label87:
      b(this, str1, "", str3, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67958);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw))
          {
            RemittanceBaseUI.this.showLoading();
            RemittanceBaseUI.this.a(paramw.dwj, RemittanceBaseUI.this.fIQ, RemittanceBaseUI.this.yqw, paramw);
          }
          AppMethodBeat.o(67958);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67959);
          if (bu.isNullOrNil(paramw.yog.yoI))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(67959);
            return;
          }
          com.tencent.mm.plugin.account.a.b.a.b(RemittanceBaseUI.this, paramw.yog.yoI, 5, true);
          AppMethodBeat.o(67959);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label120:
      str1 = paramw.yog.dyI;
      break;
      label131:
      str2 = paramw.yog.yoH;
      break label87;
      label143:
      ae.i("MicroMsg.RemittanceBaseUI", "scene.zaituMessage == null");
      b(this, getString(2131762517, new Object[] { Integer.valueOf(paramw.yof) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67961);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw)) {
            RemittanceBaseUI.this.a(paramw.dwj, RemittanceBaseUI.this.fIQ, RemittanceBaseUI.this.yqw, paramw);
          }
          AppMethodBeat.o(67961);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67962);
          com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
          AppMethodBeat.o(67962);
        }
      });
    }
  }
  
  private boolean f(final com.tencent.mm.plugin.remittance.model.w paramw)
  {
    if (paramw.yom)
    {
      this.yqN = true;
      f.a(this, this.mScene, paramw.yop / 100.0D, paramw.yoo / 100.0D, paramw.yoj / 100.0D, paramw.yol, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67963);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          RemittanceBaseUI.this.showLoading();
          RemittanceBaseUI.this.a(paramw.dwj, RemittanceBaseUI.this.fIQ, RemittanceBaseUI.this.yqw, paramw);
          if (RemittanceBaseUI.this.mScene == 1) {
            com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67963);
            return;
            com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          }
        }
      });
      return true;
    }
    return false;
  }
  
  public void DG(String paramString)
  {
    ae.i("MicroMsg.RemittanceBaseUI", "onGet");
    if (bu.nullAsNil(paramString).length() <= 0) {
      ae.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.fIQ)) {
      return;
    }
    dMP();
  }
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final com.tencent.mm.plugin.remittance.model.w paramw)
  {
    ae.i("MicroMsg.RemittanceBaseUI", "startPay mKindaEnable %s reqKey %s", new Object[] { Boolean.valueOf(this.mKindaEnable), paramString1 });
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
              AppMethodBeat.i(67968);
              ae.i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceBaseUI.h(RemittanceBaseUI.this) });
              paramAnonymousDialogInterface = new hn();
              paramAnonymousDialogInterface.etH = ((int)paramw.yot);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.qx(paramw.username);
              paramAnonymousDialogInterface.etA = 9L;
              paramAnonymousDialogInterface.aLH();
              paramw.yoG = null;
              RemittanceBaseUI.this.a(paramString1, paramString2, paramString3, paramw);
              AppMethodBeat.o(67968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(67969);
              ae.i("MicroMsg.RemittanceBaseUI", "onClick1");
              paramAnonymousDialogInterface = new hn();
              paramAnonymousDialogInterface.etH = ((int)paramw.yot);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.qx(paramw.username);
              paramAnonymousDialogInterface.etA = 8L;
              paramAnonymousDialogInterface.aLH();
              AppMethodBeat.o(67969);
            }
          }, 2131100777);
          return;
        }
      } while (paramw.yoG.GpC != 2);
      h.a(this, paramw.yoG.dyI, paramw.yoG.title, getResources().getString(2131766205), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
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
    ae.i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
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
        return;
        paramString1 = "(" + this.yqw + ")";
        break;
        ae.e("MicroMsg.RemittanceBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        ae.e("MicroMsg.RemittanceBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.ypV, paramString1);
    if ((paramw.ynN != null) && (paramw.ynN.dtd.dtg != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramw.ynN.dtd.dtg, false, "", (PayInfo)localObject1, paramString3, paramString1, paramw.ynN.dtd.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public abstract void axJ(String paramString);
  
  public void dMI()
  {
    u localu = new u(this.fIQ, this.yqb);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
  }
  
  public void dMJ() {}
  
  public abstract void dMK();
  
  public abstract void dMN();
  
  protected final void dMR()
  {
    axJ(this.mDesc);
  }
  
  protected void dMS()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("recent_remittance_contact_list", ad.dMA());
    localIntent.setClass(getContext(), SelectRemittanceContactUI.class);
    startActivityForResult(localIntent, 2);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    if ((this.mPayScene == 33) || (this.mPayScene == 32)) {
      return 2131495259;
    }
    if (bu.jB(this.ypZ, 0))
    {
      hideActionbarLine();
      return 2131495260;
    }
    return 2131495258;
  }
  
  public void initView()
  {
    if ((this.mPayScene == 33) || (this.mPayScene == 32))
    {
      setMMTitle(2131762434);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67950);
          if ((RemittanceBaseUI.this.mScene == 1) || (RemittanceBaseUI.this.mScene == 6))
          {
            RemittanceBaseUI.this.dMI();
            RemittanceBaseUI.this.finish();
          }
          for (;;)
          {
            RemittanceBaseUI.this.dMJ();
            AppMethodBeat.o(67950);
            return true;
            if ((RemittanceBaseUI.this.mScene == 2) || (RemittanceBaseUI.this.mScene == 5)) {
              RemittanceBaseUI.this.finish();
            } else {
              RemittanceBaseUI.this.dMS();
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
      if (bu.jB(this.ypZ, 0))
      {
        this.yqn = ((LinearLayout)findViewById(2131303987));
        this.yqo = ((TextView)findViewById(2131302665));
        this.yqp = ((TextView)findViewById(2131296478));
      }
      dMO();
      this.pkW = ((WalletFormView)findViewById(2131302446));
      if (this.mPayScene != 33) {
        break label657;
      }
      this.yqj.setText(com.tencent.mm.wallet_core.ui.f.C(this.ymU));
      this.yqk.setText(ah.fWc());
      this.yqt = getIntent().getStringExtra("desc");
      if (bu.isNullOrNil(this.yqt)) {
        break label645;
      }
      this.yqi.setText(k.b(getContext(), this.yqt, this.yqi.getTextSize()));
      this.yqi.setVisibility(0);
      label358:
      this.yql.setVisibility(0);
      this.yqm.setVisibility(8);
      label375:
      this.jtd = ((Button)findViewById(2131302852));
      this.jtd.setOnClickListener(new com.tencent.mm.ui.w()
      {
        public final void ccc()
        {
          AppMethodBeat.i(67960);
          RemittanceBaseUI localRemittanceBaseUI;
          String str;
          if (RemittanceBaseUI.this.mPayScene == 33)
          {
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.axJ(str);
            if (RemittanceBaseUI.b(RemittanceBaseUI.this) == 0.0D)
            {
              if (RemittanceBaseUI.this.mScene != 1) {
                break label260;
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceBaseUI.this.mScene == 1) && (!bu.isNullOrNil(RemittanceBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.g.yxI.f(14074, new Object[] { Integer.valueOf(2) });
            }
            AppMethodBeat.o(67960);
            return;
            RemittanceBaseUI.this.ymU = bu.getDouble(RemittanceBaseUI.this.pkW.getText(), 0.0D);
            if (!RemittanceBaseUI.this.pkW.aVz())
            {
              t.makeText(RemittanceBaseUI.this.getContext(), 2131765031, 0).show();
              break;
            }
            if (RemittanceBaseUI.this.ymU < 0.01D)
            {
              RemittanceBaseUI.this.dMK();
              break;
            }
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.dMT();
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.axJ(str);
            break;
            label260:
            com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      });
      this.yqg = ((TextView)findViewById(2131304013));
      this.yqh = ((TextView)findViewById(2131296464));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label778;
      }
      this.yqh.setText(2131762418);
    }
    for (;;)
    {
      if (!v.aAR()) {
        findViewById(2131304014).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67977);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.dMT();
            com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            if ((RemittanceBaseUI.this.mScene == 1) || (RemittanceBaseUI.this.mScene == 6))
            {
              localObject = RemittanceBaseUI.this.getString(2131762418);
              paramAnonymousView = RemittanceBaseUI.this.getString(2131762445);
              com.tencent.mm.plugin.report.service.g.yxI.f(14074, new Object[] { Integer.valueOf(1) });
            }
            String str1;
            String str2;
            do
            {
              do
              {
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, (String)localObject, RemittanceBaseUI.this.mDesc, paramAnonymousView, 20, new h.b()new DialogInterface.OnClickListener
                {
                  public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
                  {
                    AppMethodBeat.i(67974);
                    if (!bu.isNullOrNil(paramAnonymous2CharSequence.toString()))
                    {
                      RemittanceBaseUI.this.mDesc = paramAnonymous2CharSequence.toString();
                      RemittanceBaseUI.d(RemittanceBaseUI.this);
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(67974);
                      return true;
                      RemittanceBaseUI.this.mDesc = null;
                      RemittanceBaseUI.d(RemittanceBaseUI.this);
                    }
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(67976);
                    ar.o(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(67975);
                        RemittanceBaseUI.this.hideVKB();
                        AppMethodBeat.o(67975);
                      }
                    }, 500L);
                    AppMethodBeat.o(67976);
                  }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67977);
                return;
                str1 = RemittanceBaseUI.this.getString(2131762417);
                str2 = RemittanceBaseUI.this.getString(2131762424);
                localObject = str1;
                paramAnonymousView = str2;
              } while (!bu.jB(RemittanceBaseUI.a(RemittanceBaseUI.this), 0));
              localObject = str1;
              paramAnonymousView = str2;
            } while (!RemittanceBaseUI.this.yqa);
            com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, str1, RemittanceBaseUI.this.mDesc, str2, RemittanceBaseUI.this.yqs, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.wTG, RemittanceBaseUI.this.yqr, new a.a()new f.c
            {
              public final boolean a(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4)
              {
                AppMethodBeat.i(67971);
                RemittanceBaseUI.this.yqs = paramAnonymous2Boolean;
                if (!bu.isNullOrNil(paramAnonymous2String1))
                {
                  RemittanceBaseUI.this.mDesc = paramAnonymous2String1;
                  if (RemittanceBaseUI.this.yqs) {
                    break label188;
                  }
                  if (bu.isNullOrNil(paramAnonymous2String2)) {
                    break label146;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymous2String2;
                  label65:
                  if (bu.isNullOrNil(paramAnonymous2String3)) {
                    break label160;
                  }
                  RemittanceBaseUI.this.wTG = paramAnonymous2String3;
                  label85:
                  if (bu.isNullOrNil(paramAnonymous2String4)) {
                    break label174;
                  }
                  RemittanceBaseUI.this.yqr = paramAnonymous2String4;
                }
                for (;;)
                {
                  RemittanceBaseUI.c(RemittanceBaseUI.this);
                  RemittanceBaseUI.d(RemittanceBaseUI.this);
                  AppMethodBeat.o(67971);
                  return true;
                  RemittanceBaseUI.this.mDesc = null;
                  break;
                  label146:
                  RemittanceBaseUI.this.mName = null;
                  break label65;
                  label160:
                  RemittanceBaseUI.this.wTG = null;
                  break label85;
                  label174:
                  RemittanceBaseUI.this.yqr = null;
                  continue;
                  label188:
                  RemittanceBaseUI.this.mName = null;
                  RemittanceBaseUI.this.wTG = null;
                  RemittanceBaseUI.this.yqr = null;
                }
              }
            }, new f.c()
            {
              public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(67973);
                ar.o(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(67972);
                    RemittanceBaseUI.this.hideVKB();
                    AppMethodBeat.o(67972);
                  }
                }, 500L);
                AppMethodBeat.o(67973);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67977);
          }
        });
      }
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
      this.yqf = ((TextView)findViewById(2131303272));
      this.yqq = ((LinearLayout)findViewById(2131304051));
      dMM();
      dMN();
      dML();
      if ((this.mPayScene != 33) && (this.mPayScene == 32)) {}
      return;
      setMMTitle(2131762535);
      break;
      label645:
      this.yqi.setVisibility(8);
      break label358;
      label657:
      this.pkW.setOnClickListener(new RemittanceBaseUI.32(this));
      this.pkW.getTitleTv().setText(String.format(getString(2131762486), new Object[] { "¥" }));
      this.pkW.a(new RemittanceBaseUI.2(this));
      setEditFocusListener(this.pkW, 2, false);
      findViewById(2131303272);
      findViewById(2131304051).setVisibility(0);
      this.yql.setVisibility(8);
      this.yqm.setVisibility(0);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(67952);
          if (paramAnonymousBoolean)
          {
            RemittanceBaseUI.a(RemittanceBaseUI.this, RemittanceBaseUI.this.uSG, RemittanceBaseUI.this.jtd);
            AppMethodBeat.o(67952);
            return;
          }
          RemittanceBaseUI.this.uSG.scrollTo(0, 0);
          AppMethodBeat.o(67952);
        }
      });
      break label375;
      label778:
      this.yqh.setText(2131762417);
    }
  }
  
  public boolean needLockPage()
  {
    return (this.mPayScene == 33) || (this.mPayScene == 32);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    ae.i("MicroMsg.RemittanceBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + bu.bI(this.fIQ, "null") + ", =" + bu.bI(this.oYU, "null"));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      bool1 = bool2;
      if (paramInt2 == -1) {
        bool1 = true;
      }
      a(bool1, paramIntent);
      continue;
      if (paramInt2 == -1) {}
      for (;;)
      {
        a(bool1, paramIntent);
        break;
        bool1 = false;
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
          hideTenpayKB();
          str1 = getString(2131756394);
          String str2 = getString(2131762445);
          String str3 = paramIntent.getStringExtra("userName");
          String str4 = paramIntent.getStringExtra("telNumber");
          String str5 = paramIntent.getStringExtra("proviceFirstStageName") + paramIntent.getStringExtra("addressCitySecondStageName") + paramIntent.getStringExtra("addressCountiesThirdStageName") + paramIntent.getStringExtra("addressDetailInfo");
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, str1, this.mDesc, str2, false, str3, str4, str5, new a.a()new f.c
          {
            public final boolean a(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
            {
              AppMethodBeat.i(67964);
              RemittanceBaseUI.this.yqs = paramAnonymousBoolean;
              if (!bu.isNullOrNil(paramAnonymousString1))
              {
                RemittanceBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceBaseUI.this.yqs)
                {
                  if (bu.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (bu.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceBaseUI.this.wTG = paramAnonymousString3;
                  label70:
                  if (bu.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceBaseUI.this.yqr = paramAnonymousString4;; RemittanceBaseUI.this.yqr = null)
              {
                RemittanceBaseUI.c(RemittanceBaseUI.this);
                RemittanceBaseUI.d(RemittanceBaseUI.this);
                AppMethodBeat.o(67964);
                return true;
                RemittanceBaseUI.this.mDesc = null;
                break;
                label119:
                RemittanceBaseUI.this.mName = null;
                break label53;
                RemittanceBaseUI.this.wTG = null;
                break label70;
              }
            }
          }, new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(67966);
              ar.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(67965);
                  RemittanceBaseUI.this.hideVKB();
                  AppMethodBeat.o(67965);
                }
              }, 500L);
              AppMethodBeat.o(67966);
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
    long l;
    if ((this instanceof RemittanceHKUI))
    {
      this.ypZ = 1;
      super.onCreate(paramBundle);
      this.ypV = com.tencent.mm.plugin.wallet.a.aT(getIntent());
      this.yqb = getIntent().getStringExtra("scan_remittance_id");
      this.ymU = getIntent().getDoubleExtra("fee", 0.0D);
      this.fIQ = getIntent().getStringExtra("receiver_name");
      this.ypX = getIntent().getStringExtra("recv_headimgurl");
      this.oYU = getIntent().getStringExtra("receiver_nick_name");
      this.yqw = getIntent().getStringExtra("receiver_true_name");
      this.ypW = getIntent().getStringExtra("mch_name");
      this.ypY = getIntent().getStringExtra("mch_info");
      this.mChannel = getIntent().getIntExtra("pay_channel", 0);
      this.yqB = bu.bI(getIntent().getStringExtra("rcvr_open_id"), "");
      ae.i("MicroMsg.RemittanceBaseUI", "mUserName %s", new Object[] { this.fIQ });
      com.tencent.mm.kernel.g.ajS();
      l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(147457, Long.valueOf(0L))).longValue();
      if ((0x10 & l) == 0L) {
        break label370;
      }
      this.yqA = 1;
      label292:
      p.aEA().a(this);
      initView();
      this.yqV.alive();
      com.tencent.mm.wallet_core.b.fVf();
      if ((!com.tencent.mm.wallet_core.b.b(b.a.qDk, true)) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY"))) {
        break label396;
      }
    }
    label396:
    for (boolean bool = true;; bool = false)
    {
      this.mKindaEnable = bool;
      return;
      if (!(this instanceof RemittanceOSUI)) {
        break;
      }
      this.ypZ = 2;
      break;
      label370:
      if ((l & 0x20) != 0L)
      {
        this.yqA = 2;
        break label292;
      }
      this.yqA = 0;
      break label292;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IvT.d(this.yqK);
    p.aEA().b(this);
    this.yqV.dead();
    this.yqQ.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.aFx(this.dAa);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    this.yqD = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.w))
      {
        paramn = (com.tencent.mm.plugin.remittance.model.w)paramn;
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
            break label278;
          }
          paramString = "";
          label158:
          this.yqC = paramString;
          if (a(paramn)) {
            break label312;
          }
          a(paramn.dwj, this.fIQ, this.yqw, paramn);
          label191:
          paramString = new a(paramn.yor, paramn.pgs, paramn.piP, paramn.yos, paramn.vxx, paramn.dyA, paramn.dmx, paramn.yow, bu.getLong(paramn.you, 0L));
          this.yqE.put(paramn.dwj, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.yqF = paramn.dyA;
        break;
        label278:
        if (bu.isNullOrNil(paramn.yoG.yqC))
        {
          paramString = this.yqC;
          break label158;
        }
        paramString = paramn.yoG.yqC;
        break label158;
        label312:
        if (!this.mKindaEnable) {
          break label191;
        }
        hideLoading();
        break label191;
        if ((paramn instanceof ai))
        {
          paramString = (ai)paramn;
          if (!bu.isNullOrNil(paramString.Dha))
          {
            ((TextView)findViewById(2131304075)).setText(paramString.Dha);
            paramn = findViewById(2131305865);
            paramn.setVisibility(0);
            paramn.setOnClickListener(new RemittanceBaseUI.4(this));
          }
          this.yqu = paramString.yqu;
          this.yon = paramString.yon;
          if (this.yon == 0.0D) {
            if (this.mScene == 1) {
              com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(14), Integer.valueOf(1) });
            } else {
              com.tencent.mm.plugin.report.service.g.yxI.f(12689, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            }
          }
        }
        else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
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
      ae.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
      this.yqf.setText("");
      this.yqf.setVisibility(8);
    }
    do
    {
      do
      {
        return false;
      } while (!(paramn instanceof com.tencent.mm.plugin.remittance.model.w));
      if (this.mKindaEnable) {
        hideLoading();
      }
      this.yqH = ((com.tencent.mm.plugin.remittance.model.w)paramn);
      com.tencent.mm.sdk.b.a.IvT.b(this.yqK);
      af.w(this.mPayScene, "", paramInt2);
    } while (!c((com.tencent.mm.plugin.remittance.model.w)paramn));
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
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
 * JD-Core Version:    0.7.0.1
 */