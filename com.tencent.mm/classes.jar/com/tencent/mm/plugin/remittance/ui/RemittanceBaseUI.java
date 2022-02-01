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
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.remittance.model.w.a;
import com.tencent.mm.plugin.wallet_core.c.ai;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.vf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
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
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cd.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aj.getContext(), 270);
  private String dpw;
  protected int dvA = 0;
  protected String flk;
  protected Button iwY;
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected String nLX;
  protected WalletFormView nXA;
  protected ScrollView swv;
  protected String upF;
  private double vAJ;
  protected TextView vCA;
  protected TextView vCB;
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
  private String vCQ;
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
  protected String vCt;
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
  protected double vzp;
  
  private void a(w paramw, vf paramvf)
  {
    this.vDf = true;
    new c(this).a(paramw, paramvf, new c.a()
    {
      public final void amf(String paramAnonymousString)
      {
        AppMethodBeat.i(67967);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceBaseUI.this.vCZ = paramAnonymousString;
        RemittanceBaseUI.this.dkf();
        AppMethodBeat.o(67967);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(187080);
        RemittanceBaseUI.this.vCZ = "";
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(187080);
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
      String str;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bt.isNullOrNil(paramw.vAQ))
        {
          bool2 = bool1;
          if (!bt.isNullOrNil(paramw.vAR))
          {
            str = com.tencent.mm.wallet_core.ui.e.gn(com.tencent.mm.wallet_core.ui.e.sh(this.flk), 10);
            if (!bt.isNullOrNil(this.nLX)) {
              str = this.nLX;
            }
            if (bt.isNullOrNil(this.vCS)) {
              break label193;
            }
            str = getString(2131762438, new Object[] { str, this.vCS });
          }
        }
      }
      label193:
      for (;;)
      {
        bool2 = a(paramw.dlJ, paramw.vAR, str, paramw.vAQ, paramw);
        return bool2;
      }
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
        AppMethodBeat.i(67978);
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(67978);
      }
    });
    paramString2.b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(187081);
        RemittanceBaseUI.this.showLoading();
        RemittanceBaseUI.this.a(paramString1, RemittanceBaseUI.this.flk, RemittanceBaseUI.this.vCS, paramw);
        AppMethodBeat.o(187081);
      }
    });
    paramString2.fft().show();
    return true;
  }
  
  private static void amo(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)bw.K(paramString, "msg").get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.dvA), Double.valueOf(this.vDn), this.vDo, this.vDp, this.vDq });
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
          AppMethodBeat.i(67955);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[] { paramw.dyo.nTQ });
          com.tencent.mm.wallet_core.ui.e.p(RemittanceBaseUI.this.getContext(), paramw.dyo.nTQ, false);
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
          AppMethodBeat.i(67956);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 3, paramw.dnZ);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw))
          {
            RemittanceBaseUI.this.showLoading();
            RemittanceBaseUI.this.a(paramw.dlJ, RemittanceBaseUI.this.flk, RemittanceBaseUI.this.vCS, paramw);
          }
          AppMethodBeat.o(67956);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67957);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 2, paramw.dnZ);
          AppMethodBeat.o(67957);
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
          AppMethodBeat.i(67980);
          com.tencent.mm.wallet_core.ui.e.p(RemittanceBaseUI.this.getContext(), RemittanceBaseUI.this.vCU, false);
          AppMethodBeat.o(67980);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void dka()
  {
    if ((!bt.isNullOrNil(this.vCT)) && (this.vCW != 0))
    {
      int i;
      if (this.vCW == 1) {
        i = 2;
      }
      try
      {
        for (;;)
        {
          this.vCB.setText(String.format(this.vCT, new Object[] { Integer.valueOf(i) }));
          this.vCB.setVisibility(0);
          return;
          i = 24;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.RemittanceBaseUI", localException, "", new Object[0]);
          this.vCB.setText(getString(2131762496, new Object[] { Integer.valueOf(i) }));
        }
      }
    }
    this.vCB.setText("");
    this.vCB.setVisibility(8);
  }
  
  private void dkc()
  {
    Object localObject2 = com.tencent.mm.wallet_core.ui.e.gn(com.tencent.mm.wallet_core.ui.e.sh(this.flk), 10);
    Object localObject1 = localObject2;
    if (!bt.isNullOrNil(this.vCS)) {
      localObject1 = getString(2131762438, new Object[] { localObject2, this.vCS });
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
        label148:
        this.vCz.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject2, this.vCz.getTextSize()));
        if (!g.afw()) {
          break label488;
        }
        localObject1 = p.auF();
        if ((localObject1 == null) || (bt.isNullOrNil(this.flk))) {
          break label488;
        }
        localObject1 = ((j)localObject1).we(this.flk);
        if ((localObject1 != null) && (!bt.isNullOrNil(((i)localObject1).auy()))) {
          break label488;
        }
        final long l = bt.eGO();
        ar.a.gMW.a(this.flk, "", new ar.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(67981);
            if (paramAnonymousBoolean)
            {
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (bt.eGO() - l) + " ms");
              com.tencent.mm.ak.c.ac(paramAnonymousString, 3);
            }
            for (;;)
            {
              RemittanceBaseUI.e(RemittanceBaseUI.this);
              AppMethodBeat.o(67981);
              return;
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.RemittanceBaseUI", "getContact failed");
            }
          }
        });
      }
    }
    label488:
    for (int i = 1;; i = 0)
    {
      if ((bt.isNullOrNil(this.flk)) && (!bt.isNullOrNil(this.vCt)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "use mRecvHeadimgurl(%s) to avatar, mReceiverAvatarIv:%s", new Object[] { this.vCt, this.vCy.getClass().getSimpleName() });
        if ((this.vCy instanceof CdnImageView))
        {
          i = BackwardSupportUtil.b.g(this, 44.0F);
          ((CdnImageView)this.vCy).setRoundCorner(true);
          ((CdnImageView)this.vCy).r(this.vCt, i, i, 2131231875);
        }
      }
      while (i != 0)
      {
        return;
        localObject1 = getString(2131762440, new Object[] { com.tencent.mm.wallet_core.ui.e.gn(com.tencent.mm.wallet_core.ui.e.sh(this.flk), 10), this.vCS });
        break;
        localObject2 = localObject1;
        if (this.mScene != 6) {
          break label148;
        }
        localObject2 = getIntent().getStringExtra("receiver_tips");
        if (!bt.isNullOrNil(this.nLX)) {
          localObject1 = this.nLX;
        }
        if (bt.isNullOrNil((String)localObject2))
        {
          localObject2 = getString(2131762439, new Object[] { localObject1 });
          break label148;
        }
        localObject2 = bt.u((String)localObject2, new Object[] { localObject1 });
        break label148;
      }
      dkd();
      return;
    }
  }
  
  private void dkd()
  {
    final Runnable local30 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67982);
        Bitmap localBitmap = com.tencent.mm.ak.c.a(RemittanceBaseUI.this.flk, false, -1, null);
        if (localBitmap == null)
        {
          RemittanceBaseUI.this.vCy.setImageResource(2131231875);
          AppMethodBeat.o(67982);
          return;
        }
        RemittanceBaseUI.this.vCy.setImageBitmap(localBitmap);
        AppMethodBeat.o(67982);
      }
    };
    if (aq.isMainThread())
    {
      local30.run();
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67983);
        local30.run();
        AppMethodBeat.o(67983);
      }
    });
  }
  
  private boolean dke()
  {
    return (this.mScene == 0) || (this.mScene == 2);
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
        break label143;
      }
      if (!bt.isNullOrNil(paramw.vAC.doh)) {
        break label120;
      }
      str1 = getString(2131762517, new Object[] { Integer.valueOf(paramw.vAB) });
      String str3 = getString(2131762444);
      if (!bt.isNullOrNil(paramw.vAC.vBd)) {
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
            RemittanceBaseUI.this.a(paramw.dlJ, RemittanceBaseUI.this.flk, RemittanceBaseUI.this.vCS, paramw);
          }
          AppMethodBeat.o(67958);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67959);
          if (bt.isNullOrNil(paramw.vAC.vBe))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(67959);
            return;
          }
          com.tencent.mm.plugin.account.a.b.a.b(RemittanceBaseUI.this, paramw.vAC.vBe, 5, true);
          AppMethodBeat.o(67959);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label120:
      str1 = paramw.vAC.doh;
      break;
      label131:
      str2 = paramw.vAC.vBd;
      break label87;
      label143:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "scene.zaituMessage == null");
      b(this, getString(2131762517, new Object[] { Integer.valueOf(paramw.vAB) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67961);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw)) {
            RemittanceBaseUI.this.a(paramw.dlJ, RemittanceBaseUI.this.flk, RemittanceBaseUI.this.vCS, paramw);
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
  
  private boolean f(final w paramw)
  {
    if (paramw.vAI)
    {
      this.vDj = true;
      f.a(this, this.mScene, paramw.vAL / 100.0D, paramw.vAK / 100.0D, paramw.vAF / 100.0D, paramw.vAH, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67963);
          RemittanceBaseUI.this.showLoading();
          RemittanceBaseUI.this.a(paramw.dlJ, RemittanceBaseUI.this.flk, RemittanceBaseUI.this.vCS, paramw);
          if (RemittanceBaseUI.this.mScene == 1)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
            AppMethodBeat.o(67963);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          AppMethodBeat.o(67963);
        }
      });
      return true;
    }
    return false;
  }
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final w paramw)
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "startPay mKindaEnable %s reqKey %s", new Object[] { Boolean.valueOf(this.mKindaEnable), paramString1 });
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
              AppMethodBeat.i(67968);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceBaseUI.h(RemittanceBaseUI.this) });
              paramAnonymousDialogInterface = new es();
              paramAnonymousDialogInterface.dZD = ((int)paramw.vAP);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.kL(paramw.username);
              paramAnonymousDialogInterface.dZv = 9L;
              paramAnonymousDialogInterface.aBj();
              paramw.vBc = null;
              RemittanceBaseUI.this.a(paramString1, paramString2, paramString3, paramw);
              AppMethodBeat.o(67968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(67969);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "onClick1");
              paramAnonymousDialogInterface = new es();
              paramAnonymousDialogInterface.dZD = ((int)paramw.vAP);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.kL(paramw.username);
              paramAnonymousDialogInterface.dZv = 8L;
              paramAnonymousDialogInterface.aBj();
              AppMethodBeat.o(67969);
            }
          }, 2131100777);
          return;
        }
      } while (paramw.vBc.CXj != 2);
      com.tencent.mm.ui.base.h.a(this, paramw.vBc.doh, paramw.vBc.title, getResources().getString(2131766205), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
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
        return;
        paramString1 = "(" + this.vCS + ")";
        break;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.vCr, paramString1);
    if ((paramw.vAj != null) && (paramw.vAj.djg.djj != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramw.vAj.djg.djj, false, "", (PayInfo)localObject1, paramString3, paramString1, paramw.vAj.djg.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public abstract void amn(String paramString);
  
  public void djW()
  {
    com.tencent.mm.plugin.remittance.model.u localu = new com.tencent.mm.plugin.remittance.model.u(this.flk, this.vCx);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
  }
  
  public void djX() {}
  
  public abstract void djY();
  
  public abstract void dkb();
  
  protected final void dkf()
  {
    amn(this.mDesc);
  }
  
  protected void dkg()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("recent_remittance_contact_list", com.tencent.mm.plugin.remittance.model.ad.djO());
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
    if (bt.iY(this.vCv, 0))
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
            RemittanceBaseUI.this.djW();
            RemittanceBaseUI.this.finish();
          }
          for (;;)
          {
            RemittanceBaseUI.this.djX();
            AppMethodBeat.o(67950);
            return true;
            if ((RemittanceBaseUI.this.mScene == 2) || (RemittanceBaseUI.this.mScene == 5)) {
              RemittanceBaseUI.this.finish();
            } else {
              RemittanceBaseUI.this.dkg();
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
      if (bt.iY(this.vCv, 0))
      {
        this.vCJ = ((LinearLayout)findViewById(2131303987));
        this.vCK = ((TextView)findViewById(2131302665));
        this.vCL = ((TextView)findViewById(2131296478));
      }
      dkc();
      this.nXA = ((WalletFormView)findViewById(2131302446));
      if (this.mPayScene != 33) {
        break label657;
      }
      this.vCF.setText(com.tencent.mm.wallet_core.ui.e.D(this.vzp));
      this.vCG.setText(ah.fkg());
      this.vCP = getIntent().getStringExtra("desc");
      if (bt.isNullOrNil(this.vCP)) {
        break label645;
      }
      this.vCE.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.vCP, this.vCE.getTextSize()));
      this.vCE.setVisibility(0);
      label358:
      this.vCH.setVisibility(0);
      this.vCI.setVisibility(8);
      label375:
      this.iwY = ((Button)findViewById(2131302852));
      this.iwY.setOnClickListener(new v()
      {
        public final void bOU()
        {
          AppMethodBeat.i(67960);
          RemittanceBaseUI localRemittanceBaseUI;
          String str;
          if (RemittanceBaseUI.this.mPayScene == 33)
          {
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.amn(str);
            if (RemittanceBaseUI.b(RemittanceBaseUI.this) == 0.0D)
            {
              if (RemittanceBaseUI.this.mScene != 1) {
                break label260;
              }
              com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceBaseUI.this.mScene == 1) && (!bt.isNullOrNil(RemittanceBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.h.vKh.f(14074, new Object[] { Integer.valueOf(2) });
            }
            AppMethodBeat.o(67960);
            return;
            RemittanceBaseUI.this.vzp = bt.getDouble(RemittanceBaseUI.this.nXA.getText(), 0.0D);
            if (!RemittanceBaseUI.this.nXA.aKX())
            {
              t.makeText(RemittanceBaseUI.this.getContext(), 2131765031, 0).show();
              break;
            }
            if (RemittanceBaseUI.this.vzp < 0.01D)
            {
              RemittanceBaseUI.this.djY();
              break;
            }
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.dkh();
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.amn(str);
            break;
            label260:
            com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      });
      this.vCC = ((TextView)findViewById(2131304013));
      this.vCD = ((TextView)findViewById(2131296464));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label778;
      }
      this.vCD.setText(2131762418);
    }
    for (;;)
    {
      if (!com.tencent.mm.model.u.aqV()) {
        findViewById(2131304014).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67977);
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.dkh();
            com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            Object localObject;
            if ((RemittanceBaseUI.this.mScene == 1) || (RemittanceBaseUI.this.mScene == 6))
            {
              localObject = RemittanceBaseUI.this.getString(2131762418);
              paramAnonymousView = RemittanceBaseUI.this.getString(2131762445);
              com.tencent.mm.plugin.report.service.h.vKh.f(14074, new Object[] { Integer.valueOf(1) });
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
                    if (!bt.isNullOrNil(paramAnonymous2CharSequence.toString()))
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
                    aq.n(new Runnable()
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
                AppMethodBeat.o(67977);
                return;
                str1 = RemittanceBaseUI.this.getString(2131762417);
                str2 = RemittanceBaseUI.this.getString(2131762424);
                localObject = str1;
                paramAnonymousView = str2;
              } while (!bt.iY(RemittanceBaseUI.a(RemittanceBaseUI.this), 0));
              localObject = str1;
              paramAnonymousView = str2;
            } while (!RemittanceBaseUI.this.vCw);
            com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, str1, RemittanceBaseUI.this.mDesc, str2, RemittanceBaseUI.this.vCO, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.upF, RemittanceBaseUI.this.vCN, new a.a()new f.c
            {
              public final boolean a(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4)
              {
                AppMethodBeat.i(67971);
                RemittanceBaseUI.this.vCO = paramAnonymous2Boolean;
                if (!bt.isNullOrNil(paramAnonymous2String1))
                {
                  RemittanceBaseUI.this.mDesc = paramAnonymous2String1;
                  if (RemittanceBaseUI.this.vCO) {
                    break label188;
                  }
                  if (bt.isNullOrNil(paramAnonymous2String2)) {
                    break label146;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymous2String2;
                  label65:
                  if (bt.isNullOrNil(paramAnonymous2String3)) {
                    break label160;
                  }
                  RemittanceBaseUI.this.upF = paramAnonymous2String3;
                  label85:
                  if (bt.isNullOrNil(paramAnonymous2String4)) {
                    break label174;
                  }
                  RemittanceBaseUI.this.vCN = paramAnonymous2String4;
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
                  RemittanceBaseUI.this.upF = null;
                  break label85;
                  label174:
                  RemittanceBaseUI.this.vCN = null;
                  continue;
                  label188:
                  RemittanceBaseUI.this.mName = null;
                  RemittanceBaseUI.this.upF = null;
                  RemittanceBaseUI.this.vCN = null;
                }
              }
            }, new f.c()
            {
              public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(67973);
                aq.n(new Runnable()
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
            AppMethodBeat.o(67977);
          }
        });
      }
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
      this.vCB = ((TextView)findViewById(2131303272));
      this.vCM = ((LinearLayout)findViewById(2131304051));
      dka();
      dkb();
      djZ();
      if ((this.mPayScene != 33) && (this.mPayScene == 32)) {}
      return;
      setMMTitle(2131762535);
      break;
      label645:
      this.vCE.setVisibility(8);
      break label358;
      label657:
      this.nXA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67984);
          RemittanceBaseUI.this.hideTenpayKB();
          RemittanceBaseUI.dkh();
          AppMethodBeat.o(67984);
        }
      });
      this.nXA.getTitleTv().setText(String.format(getString(2131762486), new Object[] { "¥" }));
      this.nXA.a(new RemittanceBaseUI.2(this));
      setEditFocusListener(this.nXA, 2, false);
      findViewById(2131303272);
      findViewById(2131304051).setVisibility(0);
      this.vCH.setVisibility(8);
      this.vCI.setVisibility(0);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(67952);
          if (paramAnonymousBoolean)
          {
            RemittanceBaseUI.a(RemittanceBaseUI.this, RemittanceBaseUI.this.swv, RemittanceBaseUI.this.iwY);
            AppMethodBeat.o(67952);
            return;
          }
          RemittanceBaseUI.this.swv.scrollTo(0, 0);
          AppMethodBeat.o(67952);
        }
      });
      break label375;
      label778:
      this.vCD.setText(2131762417);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + bt.by(this.flk, "null") + ", =" + bt.by(this.nLX, "null"));
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
              RemittanceBaseUI.this.vCO = paramAnonymousBoolean;
              if (!bt.isNullOrNil(paramAnonymousString1))
              {
                RemittanceBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceBaseUI.this.vCO)
                {
                  if (bt.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (bt.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceBaseUI.this.upF = paramAnonymousString3;
                  label70:
                  if (bt.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceBaseUI.this.vCN = paramAnonymousString4;; RemittanceBaseUI.this.vCN = null)
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
                RemittanceBaseUI.this.upF = null;
                break label70;
              }
            }
          }, new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(67966);
              aq.n(new Runnable()
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
    if (!dke())
    {
      this.dpw = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.atD(this.dpw);
    }
    long l;
    if ((this instanceof RemittanceHKUI))
    {
      this.vCv = 1;
      super.onCreate(paramBundle);
      this.vCr = com.tencent.mm.plugin.wallet.a.aL(getIntent());
      this.vCx = getIntent().getStringExtra("scan_remittance_id");
      this.vzp = getIntent().getDoubleExtra("fee", 0.0D);
      this.flk = getIntent().getStringExtra("receiver_name");
      this.vCt = getIntent().getStringExtra("recv_headimgurl");
      this.nLX = getIntent().getStringExtra("receiver_nick_name");
      this.vCS = getIntent().getStringExtra("receiver_true_name");
      this.vCs = getIntent().getStringExtra("mch_name");
      this.vCu = getIntent().getStringExtra("mch_info");
      this.mChannel = getIntent().getIntExtra("pay_channel", 0);
      this.vCX = bt.by(getIntent().getStringExtra("rcvr_open_id"), "");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "mUserName %s", new Object[] { this.flk });
      g.afC();
      l = ((Long)g.afB().afk().get(147457, Long.valueOf(0L))).longValue();
      if ((0x10 & l) == 0L) {
        break label370;
      }
      this.vCW = 1;
      label292:
      p.auq().a(this);
      initView();
      this.vDr.alive();
      com.tencent.mm.wallet_core.b.fjk();
      if ((!com.tencent.mm.wallet_core.b.b(b.a.pom, true)) || (!((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY"))) {
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
      this.vCv = 2;
      break;
      label370:
      if ((l & 0x20) != 0L)
      {
        this.vCW = 2;
        break label292;
      }
      this.vCW = 0;
      break label292;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ESL.d(this.vDg);
    p.auq().b(this);
    this.vDr.dead();
    this.vDm.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.atE(this.dpw);
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
            break label278;
          }
          paramString = "";
          label158:
          this.vCY = paramString;
          if (a(paramn)) {
            break label312;
          }
          a(paramn.dlJ, this.flk, this.vCS, paramn);
          label191:
          paramString = new a(paramn.vAN, paramn.nSY, paramn.nVt, paramn.vAO, paramn.tav, paramn.dnZ, paramn.dcF, paramn.vAS, bt.getLong(paramn.vAQ, 0L));
          this.vDa.put(paramn.dlJ, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.vDb = paramn.dnZ;
        break;
        label278:
        if (bt.isNullOrNil(paramn.vBc.vCY))
        {
          paramString = this.vCY;
          break label158;
        }
        paramString = paramn.vBc.vCY;
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
          if (!bt.isNullOrNil(paramString.zWM))
          {
            ((TextView)findViewById(2131304075)).setText(paramString.zWM);
            paramn = findViewById(2131305865);
            paramn.setVisibility(0);
            paramn.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(67953);
                f.a(RemittanceBaseUI.this, RemittanceBaseUI.this.mScene, RemittanceBaseUI.f(RemittanceBaseUI.this), RemittanceBaseUI.b(RemittanceBaseUI.this));
                if (RemittanceBaseUI.this.mScene == 1)
                {
                  com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(13), Integer.valueOf(1) });
                  AppMethodBeat.o(67953);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
                AppMethodBeat.o(67953);
              }
            });
          }
          this.vCQ = paramString.vCQ;
          this.vAJ = paramString.vAJ;
          if (this.vAJ == 0.0D) {
            if (this.mScene == 1) {
              com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(14), Integer.valueOf(1) });
            } else {
              com.tencent.mm.plugin.report.service.h.vKh.f(12689, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            }
          }
        }
        else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
      this.vCB.setText("");
      this.vCB.setVisibility(8);
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
      com.tencent.mm.sdk.b.a.ESL.b(this.vDg);
      com.tencent.mm.wallet_core.c.af.v(this.mPayScene, "", paramInt2);
    } while (!c((w)paramn));
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void vZ(String paramString)
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "onGet");
    if (bt.nullAsNil(paramString).length() <= 0) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
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
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
 * JD-Core Version:    0.7.0.1
 */