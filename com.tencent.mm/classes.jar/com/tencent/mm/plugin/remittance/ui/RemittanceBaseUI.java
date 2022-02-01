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
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.remittance.model.w.a;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aj.getContext(), 270);
  protected int dFo = 0;
  private String dyV;
  protected String fGM;
  protected Button jqk;
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected String oSs;
  protected WalletFormView peq;
  protected ScrollView uGT;
  protected String wDV;
  protected double xXb;
  private double xYv;
  protected String yaA;
  protected boolean yaB = true;
  protected String yaC;
  private String yaD;
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
  private com.tencent.mm.plugin.remittance.model.w yaQ;
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
  protected String yaf;
  protected String yag;
  private int yah = -1;
  protected boolean yai = false;
  protected String yaj;
  protected ImageView yak;
  protected TextView yal;
  protected TextView yam;
  protected TextView yan;
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
  
  private void a(com.tencent.mm.plugin.remittance.model.w paramw, xo paramxo)
  {
    this.yaS = true;
    new c(this).a(paramw, paramxo, new c.a()
    {
      public final void awm(String paramAnonymousString)
      {
        AppMethodBeat.i(67967);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceBaseUI.this.yaM = paramAnonymousString;
        RemittanceBaseUI.this.dJz();
        AppMethodBeat.o(67967);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(199156);
        RemittanceBaseUI.this.yaM = "";
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(199156);
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
  
  private boolean a(com.tencent.mm.plugin.remittance.model.w paramw)
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
      String str;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bt.isNullOrNil(paramw.xYC))
        {
          bool2 = bool1;
          if (!bt.isNullOrNil(paramw.xYD))
          {
            str = com.tencent.mm.wallet_core.ui.e.gO(com.tencent.mm.wallet_core.ui.e.zf(this.fGM), 10);
            if (!bt.isNullOrNil(this.oSs)) {
              str = this.oSs;
            }
            if (bt.isNullOrNil(this.yaF)) {
              break label193;
            }
            str = getString(2131762438, new Object[] { str, this.yaF });
          }
        }
      }
      label193:
      for (;;)
      {
        bool2 = a(paramw.dve, paramw.xYD, str, paramw.xYC, paramw);
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
        AppMethodBeat.i(67978);
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(67978);
      }
    });
    paramString2.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(199157);
        RemittanceBaseUI.this.showLoading();
        RemittanceBaseUI.this.a(paramString1, RemittanceBaseUI.this.fGM, RemittanceBaseUI.this.yaF, paramw);
        AppMethodBeat.o(199157);
      }
    });
    paramString2.fMb().show();
    return true;
  }
  
  private static void awv(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)bw.M(paramString, "msg").get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.dFo), Double.valueOf(this.yba), this.ybb, this.ybc, this.ybd });
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
  
  private static boolean b(com.tencent.mm.plugin.remittance.model.w paramw)
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
  
  private boolean c(final com.tencent.mm.plugin.remittance.model.w paramw)
  {
    if ((paramw.dIk != null) && (paramw.dIk.eEP()))
    {
      this.yaX = true;
      h.e(this, paramw.dIk.dxD, "", paramw.dIk.kzL, paramw.dIk.kzK, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67955);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[] { paramw.dIk.paG });
          com.tencent.mm.wallet_core.ui.e.o(RemittanceBaseUI.this.getContext(), paramw.dIk.paG, false);
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
    if (!bt.isNullOrNil(paramw.xYp))
    {
      this.yaU = true;
      bJ(1, paramw.dxv);
      h.e(this, paramw.xYp, getString(2131755873), getString(2131762444), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67956);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 3, paramw.dxv);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw))
          {
            RemittanceBaseUI.this.showLoading();
            RemittanceBaseUI.this.a(paramw.dve, RemittanceBaseUI.this.fGM, RemittanceBaseUI.this.yaF, paramw);
          }
          AppMethodBeat.o(67956);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67957);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 2, paramw.dxv);
          AppMethodBeat.o(67957);
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
          AppMethodBeat.i(67980);
          com.tencent.mm.wallet_core.ui.e.o(RemittanceBaseUI.this.getContext(), RemittanceBaseUI.this.yaH, false);
          AppMethodBeat.o(67980);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void dJu()
  {
    if ((!bt.isNullOrNil(this.yaG)) && (this.yaJ != 0))
    {
      int i;
      if (this.yaJ == 1) {
        i = 2;
      }
      try
      {
        for (;;)
        {
          this.yan.setText(String.format(this.yaG, new Object[] { Integer.valueOf(i) }));
          this.yan.setVisibility(0);
          return;
          i = 24;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.RemittanceBaseUI", localException, "", new Object[0]);
          this.yan.setText(getString(2131762496, new Object[] { Integer.valueOf(i) }));
        }
      }
    }
    this.yan.setText("");
    this.yan.setVisibility(8);
  }
  
  private void dJw()
  {
    Object localObject2 = com.tencent.mm.wallet_core.ui.e.gO(com.tencent.mm.wallet_core.ui.e.zf(this.fGM), 10);
    Object localObject1 = localObject2;
    if (!bt.isNullOrNil(this.yaF)) {
      localObject1 = getString(2131762438, new Object[] { localObject2, this.yaF });
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
        label148:
        this.yal.setText(k.b(this, (CharSequence)localObject2, this.yal.getTextSize()));
        if (!com.tencent.mm.kernel.g.ajx()) {
          break label488;
        }
        localObject1 = p.aEx();
        if ((localObject1 == null) || (bt.isNullOrNil(this.fGM))) {
          break label488;
        }
        localObject1 = ((j)localObject1).Dj(this.fGM);
        if ((localObject1 != null) && (!bt.isNullOrNil(((i)localObject1).aEr()))) {
          break label488;
        }
        final long l = bt.flT();
        as.a.hFO.a(this.fGM, "", new as.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(67981);
            if (paramAnonymousBoolean)
            {
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (bt.flT() - l) + " ms");
              com.tencent.mm.ak.c.ak(paramAnonymousString, 3);
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
      if ((bt.isNullOrNil(this.fGM)) && (!bt.isNullOrNil(this.yaf)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "use mRecvHeadimgurl(%s) to avatar, mReceiverAvatarIv:%s", new Object[] { this.yaf, this.yak.getClass().getSimpleName() });
        if ((this.yak instanceof CdnImageView))
        {
          i = BackwardSupportUtil.b.g(this, 44.0F);
          ((CdnImageView)this.yak).setRoundCorner(true);
          ((CdnImageView)this.yak).r(this.yaf, i, i, 2131231875);
        }
      }
      while (i != 0)
      {
        return;
        localObject1 = getString(2131762440, new Object[] { com.tencent.mm.wallet_core.ui.e.gO(com.tencent.mm.wallet_core.ui.e.zf(this.fGM), 10), this.yaF });
        break;
        localObject2 = localObject1;
        if (this.mScene != 6) {
          break label148;
        }
        localObject2 = getIntent().getStringExtra("receiver_tips");
        if (!bt.isNullOrNil(this.oSs)) {
          localObject1 = this.oSs;
        }
        if (bt.isNullOrNil((String)localObject2))
        {
          localObject2 = getString(2131762439, new Object[] { localObject1 });
          break label148;
        }
        localObject2 = bt.x((String)localObject2, new Object[] { localObject1 });
        break label148;
      }
      dJx();
      return;
    }
  }
  
  private void dJx()
  {
    final Runnable local30 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67982);
        Bitmap localBitmap = com.tencent.mm.ak.c.a(RemittanceBaseUI.this.fGM, false, -1, null);
        if (localBitmap == null)
        {
          RemittanceBaseUI.this.yak.setImageResource(2131231875);
          AppMethodBeat.o(67982);
          return;
        }
        RemittanceBaseUI.this.yak.setImageBitmap(localBitmap);
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
  
  private boolean dJy()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  private boolean e(final com.tencent.mm.plugin.remittance.model.w paramw)
  {
    boolean bool = false;
    String str1;
    String str2;
    if (paramw.xYn > 0)
    {
      this.yaV = true;
      if (paramw.xYo == null) {
        break label143;
      }
      if (!bt.isNullOrNil(paramw.xYo.dxD)) {
        break label120;
      }
      str1 = getString(2131762517, new Object[] { Integer.valueOf(paramw.xYn) });
      String str3 = getString(2131762444);
      if (!bt.isNullOrNil(paramw.xYo.xYP)) {
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
            RemittanceBaseUI.this.a(paramw.dve, RemittanceBaseUI.this.fGM, RemittanceBaseUI.this.yaF, paramw);
          }
          AppMethodBeat.o(67958);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67959);
          if (bt.isNullOrNil(paramw.xYo.xYQ))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(67959);
            return;
          }
          com.tencent.mm.plugin.account.a.b.a.b(RemittanceBaseUI.this, paramw.xYo.xYQ, 5, true);
          AppMethodBeat.o(67959);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label120:
      str1 = paramw.xYo.dxD;
      break;
      label131:
      str2 = paramw.xYo.xYP;
      break label87;
      label143:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "scene.zaituMessage == null");
      b(this, getString(2131762517, new Object[] { Integer.valueOf(paramw.xYn) }), getString(2131755873), getString(2131762444), getString(2131762505), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67961);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramw)) {
            RemittanceBaseUI.this.a(paramw.dve, RemittanceBaseUI.this.fGM, RemittanceBaseUI.this.yaF, paramw);
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
    if (paramw.xYu)
    {
      this.yaW = true;
      f.a(this, this.mScene, paramw.xYx / 100.0D, paramw.xYw / 100.0D, paramw.xYr / 100.0D, paramw.xYt, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67963);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          RemittanceBaseUI.this.showLoading();
          RemittanceBaseUI.this.a(paramw.dve, RemittanceBaseUI.this.fGM, RemittanceBaseUI.this.yaF, paramw);
          if (RemittanceBaseUI.this.mScene == 1) {
            com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67963);
            return;
            com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          }
        }
      });
      return true;
    }
    return false;
  }
  
  public void De(String paramString)
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "onGet");
    if (bt.nullAsNil(paramString).length() <= 0) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.fGM)) {
      return;
    }
    dJx();
  }
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final com.tencent.mm.plugin.remittance.model.w paramw)
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "startPay mKindaEnable %s reqKey %s", new Object[] { Boolean.valueOf(this.mKindaEnable), paramString1 });
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
              AppMethodBeat.i(67968);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceBaseUI.h(RemittanceBaseUI.this) });
              paramAnonymousDialogInterface = new hl();
              paramAnonymousDialogInterface.esa = ((int)paramw.xYB);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.qc(paramw.username);
              paramAnonymousDialogInterface.erT = 9L;
              paramAnonymousDialogInterface.aLk();
              paramw.xYO = null;
              RemittanceBaseUI.this.a(paramString1, paramString2, paramString3, paramw);
              AppMethodBeat.o(67968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(67969);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "onClick1");
              paramAnonymousDialogInterface = new hl();
              paramAnonymousDialogInterface.esa = ((int)paramw.xYB);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.qc(paramw.username);
              paramAnonymousDialogInterface.erT = 8L;
              paramAnonymousDialogInterface.aLk();
              AppMethodBeat.o(67969);
            }
          }, 2131100777);
          return;
        }
      } while (paramw.xYO.FXd != 2);
      h.a(this, paramw.xYO.dxD, paramw.xYO.title, getResources().getString(2131766205), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
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
        return;
        paramString1 = "(" + this.yaF + ")";
        break;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RemittanceBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.yad, paramString1);
    if ((paramw.xXV != null) && (paramw.xXV.drX.dsa != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramw.xXV.drX.dsa, false, "", (PayInfo)localObject1, paramString3, paramString1, paramw.xXV.drX.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public abstract void awu(String paramString);
  
  protected void dJA()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("recent_remittance_contact_list", com.tencent.mm.plugin.remittance.model.ad.dJi());
    localIntent.setClass(getContext(), SelectRemittanceContactUI.class);
    startActivityForResult(localIntent, 2);
  }
  
  public void dJq()
  {
    com.tencent.mm.plugin.remittance.model.u localu = new com.tencent.mm.plugin.remittance.model.u(this.fGM, this.yaj);
    localu.setProcessName("RemittanceProcess");
    doSceneProgress(localu);
  }
  
  public void dJr() {}
  
  public abstract void dJs();
  
  public abstract void dJv();
  
  protected final void dJz()
  {
    awu(this.mDesc);
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
    if (bt.jx(this.yah, 0))
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
            RemittanceBaseUI.this.dJq();
            RemittanceBaseUI.this.finish();
          }
          for (;;)
          {
            RemittanceBaseUI.this.dJr();
            AppMethodBeat.o(67950);
            return true;
            if ((RemittanceBaseUI.this.mScene == 2) || (RemittanceBaseUI.this.mScene == 5)) {
              RemittanceBaseUI.this.finish();
            } else {
              RemittanceBaseUI.this.dJA();
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
      if (bt.jx(this.yah, 0))
      {
        this.yav = ((LinearLayout)findViewById(2131303987));
        this.yax = ((TextView)findViewById(2131302665));
        this.yay = ((TextView)findViewById(2131296478));
      }
      dJw();
      this.peq = ((WalletFormView)findViewById(2131302446));
      if (this.mPayScene != 33) {
        break label657;
      }
      this.yar.setText(com.tencent.mm.wallet_core.ui.e.C(this.xXb));
      this.yas.setText(ah.fRG());
      this.yaC = getIntent().getStringExtra("desc");
      if (bt.isNullOrNil(this.yaC)) {
        break label645;
      }
      this.yaq.setText(k.b(getContext(), this.yaC, this.yaq.getTextSize()));
      this.yaq.setVisibility(0);
      label358:
      this.yat.setVisibility(0);
      this.yau.setVisibility(8);
      label375:
      this.jqk = ((Button)findViewById(2131302852));
      this.jqk.setOnClickListener(new com.tencent.mm.ui.w()
      {
        public final void caN()
        {
          AppMethodBeat.i(67960);
          RemittanceBaseUI localRemittanceBaseUI;
          String str;
          if (RemittanceBaseUI.this.mPayScene == 33)
          {
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.awu(str);
            if (RemittanceBaseUI.b(RemittanceBaseUI.this) == 0.0D)
            {
              if (RemittanceBaseUI.this.mScene != 1) {
                break label260;
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceBaseUI.this.mScene == 1) && (!bt.isNullOrNil(RemittanceBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.g.yhR.f(14074, new Object[] { Integer.valueOf(2) });
            }
            AppMethodBeat.o(67960);
            return;
            RemittanceBaseUI.this.xXb = bt.getDouble(RemittanceBaseUI.this.peq.getText(), 0.0D);
            if (!RemittanceBaseUI.this.peq.aVa())
            {
              t.makeText(RemittanceBaseUI.this.getContext(), 2131765031, 0).show();
              break;
            }
            if (RemittanceBaseUI.this.xXb < 0.01D)
            {
              RemittanceBaseUI.this.dJs();
              break;
            }
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.dJB();
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.awu(str);
            break;
            label260:
            com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      });
      this.yao = ((TextView)findViewById(2131304013));
      this.yap = ((TextView)findViewById(2131296464));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label778;
      }
      this.yap.setText(2131762418);
    }
    for (;;)
    {
      if (!com.tencent.mm.model.u.aAB()) {
        findViewById(2131304014).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67977);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.dJB();
            com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            if ((RemittanceBaseUI.this.mScene == 1) || (RemittanceBaseUI.this.mScene == 6))
            {
              localObject = RemittanceBaseUI.this.getString(2131762418);
              paramAnonymousView = RemittanceBaseUI.this.getString(2131762445);
              com.tencent.mm.plugin.report.service.g.yhR.f(14074, new Object[] { Integer.valueOf(1) });
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
                    aq.o(new Runnable()
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
              } while (!bt.jx(RemittanceBaseUI.a(RemittanceBaseUI.this), 0));
              localObject = str1;
              paramAnonymousView = str2;
            } while (!RemittanceBaseUI.this.yai);
            com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, str1, RemittanceBaseUI.this.mDesc, str2, RemittanceBaseUI.this.yaB, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.wDV, RemittanceBaseUI.this.yaA, new a.a()new f.c
            {
              public final boolean a(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4)
              {
                AppMethodBeat.i(67971);
                RemittanceBaseUI.this.yaB = paramAnonymous2Boolean;
                if (!bt.isNullOrNil(paramAnonymous2String1))
                {
                  RemittanceBaseUI.this.mDesc = paramAnonymous2String1;
                  if (RemittanceBaseUI.this.yaB) {
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
                  RemittanceBaseUI.this.wDV = paramAnonymous2String3;
                  label85:
                  if (bt.isNullOrNil(paramAnonymous2String4)) {
                    break label174;
                  }
                  RemittanceBaseUI.this.yaA = paramAnonymous2String4;
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
                  RemittanceBaseUI.this.wDV = null;
                  break label85;
                  label174:
                  RemittanceBaseUI.this.yaA = null;
                  continue;
                  label188:
                  RemittanceBaseUI.this.mName = null;
                  RemittanceBaseUI.this.wDV = null;
                  RemittanceBaseUI.this.yaA = null;
                }
              }
            }, new f.c()
            {
              public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(67973);
                aq.o(new Runnable()
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
      this.yan = ((TextView)findViewById(2131303272));
      this.yaz = ((LinearLayout)findViewById(2131304051));
      dJu();
      dJv();
      dJt();
      if ((this.mPayScene != 33) && (this.mPayScene == 32)) {}
      return;
      setMMTitle(2131762535);
      break;
      label645:
      this.yaq.setVisibility(8);
      break label358;
      label657:
      this.peq.setOnClickListener(new RemittanceBaseUI.32(this));
      this.peq.getTitleTv().setText(String.format(getString(2131762486), new Object[] { "¥" }));
      this.peq.a(new RemittanceBaseUI.2(this));
      setEditFocusListener(this.peq, 2, false);
      findViewById(2131303272);
      findViewById(2131304051).setVisibility(0);
      this.yat.setVisibility(8);
      this.yau.setVisibility(0);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(67952);
          if (paramAnonymousBoolean)
          {
            RemittanceBaseUI.a(RemittanceBaseUI.this, RemittanceBaseUI.this.uGT, RemittanceBaseUI.this.jqk);
            AppMethodBeat.o(67952);
            return;
          }
          RemittanceBaseUI.this.uGT.scrollTo(0, 0);
          AppMethodBeat.o(67952);
        }
      });
      break label375;
      label778:
      this.yap.setText(2131762417);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + bt.bI(this.fGM, "null") + ", =" + bt.bI(this.oSs, "null"));
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
              RemittanceBaseUI.this.yaB = paramAnonymousBoolean;
              if (!bt.isNullOrNil(paramAnonymousString1))
              {
                RemittanceBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceBaseUI.this.yaB)
                {
                  if (bt.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (bt.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceBaseUI.this.wDV = paramAnonymousString3;
                  label70:
                  if (bt.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceBaseUI.this.yaA = paramAnonymousString4;; RemittanceBaseUI.this.yaA = null)
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
                RemittanceBaseUI.this.wDV = null;
                break label70;
              }
            }
          }, new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(67966);
              aq.o(new Runnable()
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
    if (!dJy())
    {
      this.dyV = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.aEd(this.dyV);
    }
    long l;
    if ((this instanceof RemittanceHKUI))
    {
      this.yah = 1;
      super.onCreate(paramBundle);
      this.yad = com.tencent.mm.plugin.wallet.a.aS(getIntent());
      this.yaj = getIntent().getStringExtra("scan_remittance_id");
      this.xXb = getIntent().getDoubleExtra("fee", 0.0D);
      this.fGM = getIntent().getStringExtra("receiver_name");
      this.yaf = getIntent().getStringExtra("recv_headimgurl");
      this.oSs = getIntent().getStringExtra("receiver_nick_name");
      this.yaF = getIntent().getStringExtra("receiver_true_name");
      this.yae = getIntent().getStringExtra("mch_name");
      this.yag = getIntent().getStringExtra("mch_info");
      this.mChannel = getIntent().getIntExtra("pay_channel", 0);
      this.yaK = bt.bI(getIntent().getStringExtra("rcvr_open_id"), "");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "mUserName %s", new Object[] { this.fGM });
      com.tencent.mm.kernel.g.ajD();
      l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(147457, Long.valueOf(0L))).longValue();
      if ((0x10 & l) == 0L) {
        break label370;
      }
      this.yaJ = 1;
      label292:
      p.aEk().a(this);
      initView();
      this.ybe.alive();
      com.tencent.mm.wallet_core.b.fQJ();
      if ((!com.tencent.mm.wallet_core.b.b(b.a.qwl, true)) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY"))) {
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
      this.yah = 2;
      break;
      label370:
      if ((l & 0x20) != 0L)
      {
        this.yaJ = 2;
        break label292;
      }
      this.yaJ = 0;
      break label292;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IbL.d(this.yaT);
    p.aEk().b(this);
    this.ybe.dead();
    this.yaZ.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.aEe(this.dyV);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    this.yaM = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.remittance.model.w))
      {
        paramn = (com.tencent.mm.plugin.remittance.model.w)paramn;
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
            break label278;
          }
          paramString = "";
          label158:
          this.yaL = paramString;
          if (a(paramn)) {
            break label312;
          }
          a(paramn.dve, this.fGM, this.yaF, paramn);
          label191:
          paramString = new a(paramn.xYz, paramn.oZO, paramn.pcj, paramn.xYA, paramn.vls, paramn.dxv, paramn.dlv, paramn.xYE, bt.getLong(paramn.xYC, 0L));
          this.yaN.put(paramn.dve, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.yaO = paramn.dxv;
        break;
        label278:
        if (bt.isNullOrNil(paramn.xYO.yaL))
        {
          paramString = this.yaL;
          break label158;
        }
        paramString = paramn.xYO.yaL;
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
          if (!bt.isNullOrNil(paramString.CPw))
          {
            ((TextView)findViewById(2131304075)).setText(paramString.CPw);
            paramn = findViewById(2131305865);
            paramn.setVisibility(0);
            paramn.setOnClickListener(new RemittanceBaseUI.4(this));
          }
          this.yaD = paramString.yaD;
          this.xYv = paramString.xYv;
          if (this.xYv == 0.0D) {
            if (this.mScene == 1) {
              com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(14), Integer.valueOf(1) });
            } else {
              com.tencent.mm.plugin.report.service.g.yhR.f(12689, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            }
          }
        }
        else if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
      this.yan.setText("");
      this.yan.setVisibility(8);
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
      this.yaQ = ((com.tencent.mm.plugin.remittance.model.w)paramn);
      com.tencent.mm.sdk.b.a.IbL.b(this.yaT);
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
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
 * JD-Core Version:    0.7.0.1
 */