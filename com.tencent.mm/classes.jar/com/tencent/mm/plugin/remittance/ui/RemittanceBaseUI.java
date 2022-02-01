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
import com.tencent.mm.plugin.remittance.model.w.a;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
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
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 270);
  private String dnh;
  protected int dtm = 0;
  protected String foE;
  protected Button iXb;
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected WalletFormView oAV;
  protected String ooX;
  protected ScrollView tEk;
  protected String vyB;
  protected double wJu;
  private double wKO;
  private int wMA = -1;
  protected boolean wMB = false;
  protected String wMC;
  protected ImageView wMD;
  protected TextView wME;
  protected TextView wMF;
  protected TextView wMG;
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
  private String wMV;
  private String wMW;
  protected String wMX;
  protected String wMY = null;
  protected String wMZ = null;
  protected com.tencent.mm.plugin.wallet.a wMw = null;
  protected String wMx;
  protected String wMy;
  protected String wMz;
  protected int wNa;
  private int wNb;
  protected String wNc;
  protected String wNd;
  protected String wNe;
  private Map<String, a> wNf = new HashMap();
  private String wNg;
  protected boolean wNh = false;
  private com.tencent.mm.plugin.remittance.model.w wNi;
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
  
  private void a(com.tencent.mm.plugin.remittance.model.w paramw, vp paramvp)
  {
    this.wNk = true;
    new c(this).a(paramw, paramvp, new c.a()
    {
      public final void arm(String paramAnonymousString)
      {
        AppMethodBeat.i(67967);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceBaseUI.this.wNe = paramAnonymousString;
        RemittanceBaseUI.this.dyh();
        AppMethodBeat.o(67967);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(207161);
        RemittanceBaseUI.this.wNe = "";
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(207161);
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
  
  private boolean a(com.tencent.mm.plugin.remittance.model.w paramw)
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
      String str;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bs.isNullOrNil(paramw.wKV))
        {
          bool2 = bool1;
          if (!bs.isNullOrNil(paramw.wKW))
          {
            str = com.tencent.mm.wallet_core.ui.e.gr(com.tencent.mm.wallet_core.ui.e.wk(this.foE), 10);
            if (!bs.isNullOrNil(this.ooX)) {
              str = this.ooX;
            }
            if (bs.isNullOrNil(this.wMX)) {
              break label193;
            }
            str = getString(2131762438, new Object[] { str, this.wMX });
          }
        }
      }
      label193:
      for (;;)
      {
        bool2 = a(paramw.djr, paramw.wKW, str, paramw.wKV, paramw);
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
        AppMethodBeat.i(67978);
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(67978);
      }
    });
    paramString2.b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(207162);
        RemittanceBaseUI.this.showLoading();
        RemittanceBaseUI.this.a(paramString1, RemittanceBaseUI.this.foE, RemittanceBaseUI.this.wMX, paramw);
        AppMethodBeat.o(207162);
      }
    });
    paramString2.fvp().show();
    return true;
  }
  
  private static void arv(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)bv.L(paramString, "msg").get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
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
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.dtm), Double.valueOf(this.wNs), this.wNt, this.wNu, this.wNv });
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
  
  private static boolean b(com.tencent.mm.plugin.remittance.model.w paramw)
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
  
  private boolean c(final com.tencent.mm.plugin.remittance.model.w paramw)
  {
    if ((paramw.dwa != null) && (paramw.dwa.eqP()))
    {
      this.wNp = true;
      com.tencent.mm.ui.base.h.d(this, paramw.dwa.dlQ, "", paramw.dwa.unX, paramw.dwa.unW, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67955);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[] { paramw.dwa.oxl });
          com.tencent.mm.wallet_core.ui.e.o(RemittanceBaseUI.this.getContext(), paramw.dwa.oxl, false);
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
    if (!bs.isNullOrNil(paramw.wKI))
    {
      this.wNm = true;
      bD(1, paramw.dlI);
      com.tencent.mm.ui.base.h.d(this, paramw.wKI, getString(2131755873), getString(2131762444), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67956);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 3, paramw.dlI);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw))
          {
            RemittanceBaseUI.this.showLoading();
            RemittanceBaseUI.this.a(paramw.djr, RemittanceBaseUI.this.foE, RemittanceBaseUI.this.wMX, paramw);
          }
          AppMethodBeat.o(67956);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67957);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 2, paramw.dlI);
          AppMethodBeat.o(67957);
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
          AppMethodBeat.i(67980);
          com.tencent.mm.wallet_core.ui.e.o(RemittanceBaseUI.this.getContext(), RemittanceBaseUI.this.wMZ, false);
          AppMethodBeat.o(67980);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void dyc()
  {
    if ((!bs.isNullOrNil(this.wMY)) && (this.wNb != 0))
    {
      int i;
      if (this.wNb == 1) {
        i = 2;
      }
      try
      {
        for (;;)
        {
          this.wMG.setText(String.format(this.wMY, new Object[] { Integer.valueOf(i) }));
          this.wMG.setVisibility(0);
          return;
          i = 24;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.RemittanceBaseUI", localException, "", new Object[0]);
          this.wMG.setText(getString(2131762496, new Object[] { Integer.valueOf(i) }));
        }
      }
    }
    this.wMG.setText("");
    this.wMG.setVisibility(8);
  }
  
  private void dye()
  {
    Object localObject2 = com.tencent.mm.wallet_core.ui.e.gr(com.tencent.mm.wallet_core.ui.e.wk(this.foE), 10);
    Object localObject1 = localObject2;
    if (!bs.isNullOrNil(this.wMX)) {
      localObject1 = getString(2131762438, new Object[] { localObject2, this.wMX });
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
        label148:
        this.wME.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject2, this.wME.getTextSize()));
        if (!g.agM()) {
          break label488;
        }
        localObject1 = p.aBw();
        if ((localObject1 == null) || (bs.isNullOrNil(this.foE))) {
          break label488;
        }
        localObject1 = ((j)localObject1).Ak(this.foE);
        if ((localObject1 != null) && (!bs.isNullOrNil(((i)localObject1).aBp()))) {
          break label488;
        }
        long l = bs.eWj();
        ar.a.hnw.a(this.foE, "", new RemittanceBaseUI.29(this, l));
      }
    }
    label488:
    for (int i = 1;; i = 0)
    {
      if ((bs.isNullOrNil(this.foE)) && (!bs.isNullOrNil(this.wMy)))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "use mRecvHeadimgurl(%s) to avatar, mReceiverAvatarIv:%s", new Object[] { this.wMy, this.wMD.getClass().getSimpleName() });
        if ((this.wMD instanceof CdnImageView))
        {
          i = BackwardSupportUtil.b.g(this, 44.0F);
          ((CdnImageView)this.wMD).setRoundCorner(true);
          ((CdnImageView)this.wMD).r(this.wMy, i, i, 2131231875);
        }
      }
      while (i != 0)
      {
        return;
        localObject1 = getString(2131762440, new Object[] { com.tencent.mm.wallet_core.ui.e.gr(com.tencent.mm.wallet_core.ui.e.wk(this.foE), 10), this.wMX });
        break;
        localObject2 = localObject1;
        if (this.mScene != 6) {
          break label148;
        }
        localObject2 = getIntent().getStringExtra("receiver_tips");
        if (!bs.isNullOrNil(this.ooX)) {
          localObject1 = this.ooX;
        }
        if (bs.isNullOrNil((String)localObject2))
        {
          localObject2 = getString(2131762439, new Object[] { localObject1 });
          break label148;
        }
        localObject2 = bs.u((String)localObject2, new Object[] { localObject1 });
        break label148;
      }
      dyf();
      return;
    }
  }
  
  private void dyf()
  {
    final Runnable local30 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67982);
        Bitmap localBitmap = com.tencent.mm.aj.c.a(RemittanceBaseUI.this.foE, false, -1, null);
        if (localBitmap == null)
        {
          RemittanceBaseUI.this.wMD.setImageResource(2131231875);
          AppMethodBeat.o(67982);
          return;
        }
        RemittanceBaseUI.this.wMD.setImageBitmap(localBitmap);
        AppMethodBeat.o(67982);
      }
    };
    if (ap.isMainThread())
    {
      local30.run();
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67983);
        local30.run();
        AppMethodBeat.o(67983);
      }
    });
  }
  
  private boolean dyg()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  private boolean e(final com.tencent.mm.plugin.remittance.model.w paramw)
  {
    boolean bool = false;
    String str1;
    String str2;
    if (paramw.wKG > 0)
    {
      this.wNn = true;
      if (paramw.wKH == null) {
        break label143;
      }
      if (!bs.isNullOrNil(paramw.wKH.dlQ)) {
        break label120;
      }
      str1 = getString(2131762517, new Object[] { Integer.valueOf(paramw.wKG) });
      String str3 = getString(2131762444);
      if (!bs.isNullOrNil(paramw.wKH.wLi)) {
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
            RemittanceBaseUI.this.a(paramw.djr, RemittanceBaseUI.this.foE, RemittanceBaseUI.this.wMX, paramw);
          }
          AppMethodBeat.o(67958);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67959);
          if (bs.isNullOrNil(paramw.wKH.wLj))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(67959);
            return;
          }
          com.tencent.mm.plugin.account.a.b.a.b(RemittanceBaseUI.this, paramw.wKH.wLj, 5, true);
          AppMethodBeat.o(67959);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label120:
      str1 = paramw.wKH.dlQ;
      break;
      label131:
      str2 = paramw.wKH.wLi;
      break label87;
      label143:
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "scene.zaituMessage == null");
      b(this, getString(2131762517, new Object[] { Integer.valueOf(paramw.wKG) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67961);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw)) {
            RemittanceBaseUI.this.a(paramw.djr, RemittanceBaseUI.this.foE, RemittanceBaseUI.this.wMX, paramw);
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
    if (paramw.wKN)
    {
      this.wNo = true;
      f.a(this, this.mScene, paramw.wKQ / 100.0D, paramw.wKP / 100.0D, paramw.wKK / 100.0D, paramw.wKM, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67963);
          RemittanceBaseUI.this.showLoading();
          RemittanceBaseUI.this.a(paramw.djr, RemittanceBaseUI.this.foE, RemittanceBaseUI.this.wMX, paramw);
          if (RemittanceBaseUI.this.mScene == 1)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
            AppMethodBeat.o(67963);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          AppMethodBeat.o(67963);
        }
      });
      return true;
    }
    return false;
  }
  
  public void Af(String paramString)
  {
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "onGet");
    if (bs.nullAsNil(paramString).length() <= 0) {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.foE)) {
      return;
    }
    dyf();
  }
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final com.tencent.mm.plugin.remittance.model.w paramw)
  {
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "startPay mKindaEnable %s reqKey %s", new Object[] { Boolean.valueOf(this.mKindaEnable), paramString1 });
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
              AppMethodBeat.i(67968);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceBaseUI.h(RemittanceBaseUI.this) });
              paramAnonymousDialogInterface = new gi();
              paramAnonymousDialogInterface.ebv = ((int)paramw.wKU);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.nD(paramw.username);
              paramAnonymousDialogInterface.ebn = 9L;
              paramAnonymousDialogInterface.aHZ();
              paramw.wLh = null;
              RemittanceBaseUI.this.a(paramString1, paramString2, paramString3, paramw);
              AppMethodBeat.o(67968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(67969);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "onClick1");
              paramAnonymousDialogInterface = new gi();
              paramAnonymousDialogInterface.ebv = ((int)paramw.wKU);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.nD(paramw.username);
              paramAnonymousDialogInterface.ebn = 8L;
              paramAnonymousDialogInterface.aHZ();
              AppMethodBeat.o(67969);
            }
          }, 2131100777);
          return;
        }
      } while (paramw.wLh.EpS != 2);
      com.tencent.mm.ui.base.h.a(this, paramw.wLh.dlQ, paramw.wLh.title, getResources().getString(2131766205), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
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
        return;
        paramString1 = "(" + this.wMX + ")";
        break;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RemittanceBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RemittanceBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.wMw, paramString1);
    if ((paramw.wKo != null) && (paramw.wKo.dgB.dgE != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramw.wKo.dgB.dgE, false, "", (PayInfo)localObject1, paramString3, paramString1, paramw.wKo.dgB.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public abstract void aru(String paramString);
  
  public void dxY()
  {
    com.tencent.mm.plugin.remittance.model.u localu = new com.tencent.mm.plugin.remittance.model.u(this.foE, this.wMC);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
  }
  
  public void dxZ() {}
  
  public abstract void dya();
  
  public abstract void dyd();
  
  protected final void dyh()
  {
    aru(this.mDesc);
  }
  
  protected void dyi()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("recent_remittance_contact_list", ad.dxQ());
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
    if (bs.jl(this.wMA, 0))
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
            RemittanceBaseUI.this.dxY();
            RemittanceBaseUI.this.finish();
          }
          for (;;)
          {
            RemittanceBaseUI.this.dxZ();
            AppMethodBeat.o(67950);
            return true;
            if ((RemittanceBaseUI.this.mScene == 2) || (RemittanceBaseUI.this.mScene == 5)) {
              RemittanceBaseUI.this.finish();
            } else {
              RemittanceBaseUI.this.dyi();
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
      if (bs.jl(this.wMA, 0))
      {
        this.wMO = ((LinearLayout)findViewById(2131303987));
        this.wMP = ((TextView)findViewById(2131302665));
        this.wMQ = ((TextView)findViewById(2131296478));
      }
      dye();
      this.oAV = ((WalletFormView)findViewById(2131302446));
      if (this.mPayScene != 33) {
        break label657;
      }
      this.wMK.setText(com.tencent.mm.wallet_core.ui.e.C(this.wJu));
      this.wML.setText(ah.fAw());
      this.wMU = getIntent().getStringExtra("desc");
      if (bs.isNullOrNil(this.wMU)) {
        break label645;
      }
      this.wMJ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.wMU, this.wMJ.getTextSize()));
      this.wMJ.setVisibility(0);
      label358:
      this.wMM.setVisibility(0);
      this.wMN.setVisibility(8);
      label375:
      this.iXb = ((Button)findViewById(2131302852));
      this.iXb.setOnClickListener(new com.tencent.mm.ui.w()
      {
        public final void bWk()
        {
          AppMethodBeat.i(67960);
          RemittanceBaseUI localRemittanceBaseUI;
          String str;
          if (RemittanceBaseUI.this.mPayScene == 33)
          {
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.aru(str);
            if (RemittanceBaseUI.b(RemittanceBaseUI.this) == 0.0D)
            {
              if (RemittanceBaseUI.this.mScene != 1) {
                break label260;
              }
              com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceBaseUI.this.mScene == 1) && (!bs.isNullOrNil(RemittanceBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.h.wUl.f(14074, new Object[] { Integer.valueOf(2) });
            }
            AppMethodBeat.o(67960);
            return;
            RemittanceBaseUI.this.wJu = bs.getDouble(RemittanceBaseUI.this.oAV.getText(), 0.0D);
            if (!RemittanceBaseUI.this.oAV.aRO())
            {
              t.makeText(RemittanceBaseUI.this.getContext(), 2131765031, 0).show();
              break;
            }
            if (RemittanceBaseUI.this.wJu < 0.01D)
            {
              RemittanceBaseUI.this.dya();
              break;
            }
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.dyj();
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.aru(str);
            break;
            label260:
            com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      });
      this.wMH = ((TextView)findViewById(2131304013));
      this.wMI = ((TextView)findViewById(2131296464));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label778;
      }
      this.wMI.setText(2131762418);
    }
    for (;;)
    {
      if (!com.tencent.mm.model.u.axL()) {
        findViewById(2131304014).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67977);
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.dyj();
            com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            Object localObject;
            if ((RemittanceBaseUI.this.mScene == 1) || (RemittanceBaseUI.this.mScene == 6))
            {
              localObject = RemittanceBaseUI.this.getString(2131762418);
              paramAnonymousView = RemittanceBaseUI.this.getString(2131762445);
              com.tencent.mm.plugin.report.service.h.wUl.f(14074, new Object[] { Integer.valueOf(1) });
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
                    if (!bs.isNullOrNil(paramAnonymous2CharSequence.toString()))
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
                    ap.n(new Runnable()
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
              } while (!bs.jl(RemittanceBaseUI.a(RemittanceBaseUI.this), 0));
              localObject = str1;
              paramAnonymousView = str2;
            } while (!RemittanceBaseUI.this.wMB);
            com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, str1, RemittanceBaseUI.this.mDesc, str2, RemittanceBaseUI.this.wMT, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.vyB, RemittanceBaseUI.this.wMS, new a.a()new f.c
            {
              public final boolean a(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4)
              {
                AppMethodBeat.i(67971);
                RemittanceBaseUI.this.wMT = paramAnonymous2Boolean;
                if (!bs.isNullOrNil(paramAnonymous2String1))
                {
                  RemittanceBaseUI.this.mDesc = paramAnonymous2String1;
                  if (RemittanceBaseUI.this.wMT) {
                    break label188;
                  }
                  if (bs.isNullOrNil(paramAnonymous2String2)) {
                    break label146;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymous2String2;
                  label65:
                  if (bs.isNullOrNil(paramAnonymous2String3)) {
                    break label160;
                  }
                  RemittanceBaseUI.this.vyB = paramAnonymous2String3;
                  label85:
                  if (bs.isNullOrNil(paramAnonymous2String4)) {
                    break label174;
                  }
                  RemittanceBaseUI.this.wMS = paramAnonymous2String4;
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
                  RemittanceBaseUI.this.vyB = null;
                  break label85;
                  label174:
                  RemittanceBaseUI.this.wMS = null;
                  continue;
                  label188:
                  RemittanceBaseUI.this.mName = null;
                  RemittanceBaseUI.this.vyB = null;
                  RemittanceBaseUI.this.wMS = null;
                }
              }
            }, new f.c()
            {
              public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(67973);
                ap.n(new Runnable()
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
        g.agS();
        if (((String)g.agR().agA().get(327732, "0")).equals("0"))
        {
          com.tencent.mm.ui.base.h.a(getContext(), 2131762490, 2131762491, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          g.agS();
          g.agR().agA().set(327732, "1");
          g.agS();
          g.agR().agA().faa();
        }
      }
      this.wMG = ((TextView)findViewById(2131303272));
      this.wMR = ((LinearLayout)findViewById(2131304051));
      dyc();
      dyd();
      dyb();
      if ((this.mPayScene != 33) && (this.mPayScene == 32)) {}
      return;
      setMMTitle(2131762535);
      break;
      label645:
      this.wMJ.setVisibility(8);
      break label358;
      label657:
      this.oAV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67984);
          RemittanceBaseUI.this.hideTenpayKB();
          RemittanceBaseUI.dyj();
          AppMethodBeat.o(67984);
        }
      });
      this.oAV.getTitleTv().setText(String.format(getString(2131762486), new Object[] { "¥" }));
      this.oAV.a(new RemittanceBaseUI.2(this));
      setEditFocusListener(this.oAV, 2, false);
      findViewById(2131303272);
      findViewById(2131304051).setVisibility(0);
      this.wMM.setVisibility(8);
      this.wMN.setVisibility(0);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(67952);
          if (paramAnonymousBoolean)
          {
            RemittanceBaseUI.a(RemittanceBaseUI.this, RemittanceBaseUI.this.tEk, RemittanceBaseUI.this.iXb);
            AppMethodBeat.o(67952);
            return;
          }
          RemittanceBaseUI.this.tEk.scrollTo(0, 0);
          AppMethodBeat.o(67952);
        }
      });
      break label375;
      label778:
      this.wMI.setText(2131762417);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + bs.bG(this.foE, "null") + ", =" + bs.bG(this.ooX, "null"));
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
              RemittanceBaseUI.this.wMT = paramAnonymousBoolean;
              if (!bs.isNullOrNil(paramAnonymousString1))
              {
                RemittanceBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceBaseUI.this.wMT)
                {
                  if (bs.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (bs.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceBaseUI.this.vyB = paramAnonymousString3;
                  label70:
                  if (bs.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceBaseUI.this.wMS = paramAnonymousString4;; RemittanceBaseUI.this.wMS = null)
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
                RemittanceBaseUI.this.vyB = null;
                break label70;
              }
            }
          }, new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(67966);
              ap.n(new Runnable()
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
    if (!dyg())
    {
      this.dnh = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.ayV(this.dnh);
    }
    long l;
    if ((this instanceof RemittanceHKUI))
    {
      this.wMA = 1;
      super.onCreate(paramBundle);
      this.wMw = com.tencent.mm.plugin.wallet.a.aN(getIntent());
      this.wMC = getIntent().getStringExtra("scan_remittance_id");
      this.wJu = getIntent().getDoubleExtra("fee", 0.0D);
      this.foE = getIntent().getStringExtra("receiver_name");
      this.wMy = getIntent().getStringExtra("recv_headimgurl");
      this.ooX = getIntent().getStringExtra("receiver_nick_name");
      this.wMX = getIntent().getStringExtra("receiver_true_name");
      this.wMx = getIntent().getStringExtra("mch_name");
      this.wMz = getIntent().getStringExtra("mch_info");
      this.mChannel = getIntent().getIntExtra("pay_channel", 0);
      this.wNc = bs.bG(getIntent().getStringExtra("rcvr_open_id"), "");
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "mUserName %s", new Object[] { this.foE });
      g.agS();
      l = ((Long)g.agR().agA().get(147457, Long.valueOf(0L))).longValue();
      if ((0x10 & l) == 0L) {
        break label370;
      }
      this.wNb = 1;
      label292:
      p.aBh().a(this);
      initView();
      this.wNw.alive();
      com.tencent.mm.wallet_core.b.fzz();
      if ((!com.tencent.mm.wallet_core.b.b(b.a.pRO, true)) || (!((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY"))) {
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
      this.wMA = 2;
      break;
      label370:
      if ((l & 0x20) != 0L)
      {
        this.wNb = 2;
        break label292;
      }
      this.wNb = 0;
      break label292;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.GpY.d(this.wNl);
    p.aBh().b(this);
    this.wNw.dead();
    this.wNr.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.ayW(this.dnh);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    this.wNe = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.w))
      {
        paramn = (com.tencent.mm.plugin.remittance.model.w)paramn;
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
            break label278;
          }
          paramString = "";
          label158:
          this.wNd = paramString;
          if (a(paramn)) {
            break label312;
          }
          a(paramn.djr, this.foE, this.wMX, paramn);
          label191:
          paramString = new a(paramn.wKS, paramn.owt, paramn.oyO, paramn.wKT, paramn.uiK, paramn.dlI, paramn.dad, paramn.wKX, bs.getLong(paramn.wKV, 0L));
          this.wNf.put(paramn.djr, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.wNg = paramn.dlI;
        break;
        label278:
        if (bs.isNullOrNil(paramn.wLh.wNd))
        {
          paramString = this.wNd;
          break label158;
        }
        paramString = paramn.wLh.wNd;
        break label158;
        label312:
        if (!this.mKindaEnable) {
          break label191;
        }
        hideLoading();
        break label191;
        if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ai))
        {
          paramString = (com.tencent.mm.plugin.wallet_core.c.ai)paramn;
          if (!bs.isNullOrNil(paramString.Bpg))
          {
            ((TextView)findViewById(2131304075)).setText(paramString.Bpg);
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
                  com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(13), Integer.valueOf(1) });
                  AppMethodBeat.o(67953);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
                AppMethodBeat.o(67953);
              }
            });
          }
          this.wMV = paramString.wMV;
          this.wKO = paramString.wKO;
          if (this.wKO == 0.0D) {
            if (this.mScene == 1) {
              com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(14), Integer.valueOf(1) });
            } else {
              com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            }
          }
        }
        else if ((paramn instanceof aj))
        {
          this.wMY = ((aj)paramn).kgH;
          this.wMZ = ((aj)paramn).Bpl;
          this.wNa = ((aj)paramn).Bpm;
          dyc();
          dyb();
        }
      }
    }
    if ((paramn instanceof aj))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
      this.wMG.setText("");
      this.wMG.setVisibility(8);
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
      this.wNi = ((com.tencent.mm.plugin.remittance.model.w)paramn);
      com.tencent.mm.sdk.b.a.GpY.b(this.wNl);
      af.x(this.mPayScene, "", paramInt2);
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
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
 * JD-Core Version:    0.7.0.1
 */