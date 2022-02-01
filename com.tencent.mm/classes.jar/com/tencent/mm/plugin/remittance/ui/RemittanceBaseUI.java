package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.f.a.gs;
import com.tencent.mm.f.a.gs.a;
import com.tencent.mm.f.a.gu;
import com.tencent.mm.f.b.a.nt;
import com.tencent.mm.f.b.a.oa;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.remittance.model.ae;
import com.tencent.mm.plugin.remittance.model.ae.a;
import com.tencent.mm.plugin.remittance.model.al;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public abstract class RemittanceBaseUI
  extends WalletBaseUI
  implements f.a
{
  protected String GIN;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 270);
  private double Ims;
  protected TextView IoA;
  private LinearLayout IoB;
  private LinearLayout IoC;
  private LinearLayout IoD;
  private TextView IoE;
  private TextView IoF;
  private LinearLayout IoG;
  protected String IoH;
  protected boolean IoI = true;
  protected String IoJ;
  private String IoK;
  protected String IoL;
  protected String IoM = null;
  protected String IoN = null;
  protected int IoO;
  private int IoP;
  protected String IoQ;
  protected String IoR;
  protected String IoS;
  private Map<String, a> IoT = new HashMap();
  private String IoU;
  protected boolean IoV = false;
  private ae IoW;
  private nt IoX;
  private boolean IoY = false;
  private IListener IoZ = new RemittanceBaseUI.4(this);
  protected com.tencent.mm.plugin.wallet.a Iol = null;
  protected String Iom;
  protected String Ion;
  protected String Ioo;
  private int Iop = -1;
  protected boolean Ioq = false;
  protected String Ior;
  protected ImageView Ios;
  protected TextView Iot;
  protected TextView Iou;
  protected TextView Iov;
  protected TextView Iow;
  protected TextView Iox;
  private TextView Ioy;
  private TextView Ioz;
  private boolean Ipa = false;
  private boolean Ipb = false;
  private boolean Ipc = false;
  private boolean Ipd = false;
  private zh Ipe = null;
  private IListener Ipf = new IListener() {};
  protected double Ipg = 0.0D;
  protected String Iph = "";
  protected String Ipi = "";
  protected String Ipj = "";
  private IListener<gu> Ipk = new RemittanceBaseUI.25(this);
  private String fLj;
  protected int fRV = 0;
  protected String iSn;
  private int mChannel;
  protected String mDesc;
  protected double mMC;
  protected ScrollView mMs;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected Button njb;
  protected String tMB;
  protected WalletFormView tZh;
  
  private void a(ae paramae, zh paramzh)
  {
    this.IoY = true;
    new c(this).a(paramae, paramzh, new c.a()
    {
      public final void aWF(String paramAnonymousString)
      {
        AppMethodBeat.i(67967);
        Log.i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceBaseUI.this.IoS = paramAnonymousString;
        RemittanceBaseUI.this.fAG();
        AppMethodBeat.o(67967);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(232290);
        RemittanceBaseUI.this.IoS = "";
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(232290);
      }
    });
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean)
    {
      if (this.IoV) {
        com.tencent.mm.plugin.report.service.h.IzE.a(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
      String str = paramIntent.getStringExtra("key_trans_id");
      if (Util.isNullOrNil(this.IoU)) {
        this.IoU = str;
      }
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        al.aWL(this.iSn);
      }
      if (this.Ims == 0.0D)
      {
        if (this.mScene == 1) {
          com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(17), Integer.valueOf(1) });
        }
      }
      else {
        finish();
      }
    }
    for (;;)
    {
      if (Util.isEqual(this.Iop, 0)) {
        b(paramBoolean, paramIntent);
      }
      do
      {
        return;
        com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
        break;
        if (ag.bL(paramIntent))
        {
          finish();
          return;
        }
      } while (ag.bM(paramIntent));
      if (this.mScene == 1) {
        com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(16), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
    }
  }
  
  private boolean a(ae paramae)
  {
    if (!this.Ipa) {}
    for (boolean bool2 = d(paramae);; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.Ipb) {
          bool1 = e(paramae);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!this.Ipc) {
          bool2 = f(paramae);
        }
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.Ipd) {
          bool1 = c(paramae);
        }
      }
      bool2 = bool1;
      String str;
      if (!bool1)
      {
        bool2 = bool1;
        if (!Util.isNullOrNil(paramae.Imz))
        {
          bool2 = bool1;
          if (!Util.isNullOrNil(paramae.ImA))
          {
            str = g.ic(g.PJ(this.iSn), 10);
            if (!Util.isNullOrNil(this.tMB)) {
              str = this.tMB;
            }
            if (Util.isNullOrNil(this.IoL)) {
              break label193;
            }
            str = getString(a.i.remittance_collect_block, new Object[] { str, this.IoL });
          }
        }
      }
      label193:
      for (;;)
      {
        bool2 = a(paramae.fHb, paramae.ImA, str, paramae.Imz, paramae);
        return bool2;
      }
    }
  }
  
  private boolean a(final String paramString1, String paramString2, String paramString3, String paramString4, final ae paramae)
  {
    View localView = LayoutInflater.from(this).inflate(a.g.remittance_second_alert_ui, null);
    TextView localTextView1 = (TextView)localView.findViewById(a.f.rsau_title);
    TextView localTextView2 = (TextView)localView.findViewById(a.f.rsau_payee);
    TextView localTextView3 = (TextView)localView.findViewById(a.f.rsau_money);
    localTextView1.setText(paramString2);
    localTextView2.setText(l.b(this, paramString3, localTextView2.getTextSize()));
    double d = Util.getDouble(paramString4, 0.0D);
    localTextView3.setText(String.format("%s%.2f", new Object[] { ah.ijb(), Double.valueOf(Double.valueOf(d).doubleValue() / 100.0D) }));
    paramString2 = new d.a(this);
    paramString2.HG(false);
    paramString2.ayc(a.i.remittance_second_alert_title);
    paramString2.iI(localView);
    paramString2.ayj(a.i.remittance_continue);
    paramString2.ayk(a.i.button_cancel);
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
        AppMethodBeat.i(216005);
        RemittanceBaseUI.this.showLoading();
        RemittanceBaseUI.this.a(paramString1, RemittanceBaseUI.this.iSn, RemittanceBaseUI.this.IoL, paramae);
        AppMethodBeat.o(216005);
      }
    });
    paramString2.icu().show();
    return true;
  }
  
  private static void aWO(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
      return;
    }
    paramString = URLDecoder.decode(paramString);
    Log.i("MicroMsg.RemittanceBaseUI", "helios:".concat(String.valueOf(paramString)));
    String str = (String)XmlParser.parseXml(paramString, "msg", null).get(".msg.appmsg.wcpayinfo.transferid");
    if (TextUtils.isEmpty(str))
    {
      Log.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
      return;
    }
    com.tencent.mm.plugin.remittance.a.c.fzJ().fzM().kb(str, paramString);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    d.a locala = new d.a(paramContext);
    locala.bBc(paramString2);
    locala.bBd(paramString1);
    locala.bBj(paramString3).c(paramOnClickListener1);
    locala.bBk(paramString4).d(paramOnClickListener2);
    locala.HG(false);
    locala.HH(true);
    paramString1 = locala.icu();
    paramString1.show();
    com.tencent.mm.ui.base.h.a(paramContext, paramString1);
  }
  
  private void b(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      this.fRV = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.RemittanceBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.fRV), Double.valueOf(this.Ipg), this.Iph, this.Ipi, this.Ipj });
      do
      {
        return;
      } while (paramIntent == null);
      this.fRV = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.Ipg = this.mMC;
      this.Iph = this.mDesc;
      this.Ipi = this.IoH;
      this.Ipj = this.IoU;
    }
  }
  
  private static boolean b(ae paramae)
  {
    return ((paramae.ImK == 1) && (paramae.ImL != null)) || ((paramae.ImL != null) && (paramae.ImL.Slx > 0));
  }
  
  private void bV(int paramInt, String paramString)
  {
    this.IoX = new nt();
    this.IoX.gnP = 2L;
    this.IoX.gef = paramInt;
    this.IoX.EH(paramString);
    this.IoX.bpa();
  }
  
  private boolean c(final ae paramae)
  {
    if ((paramae.fUY != null) && (paramae.fUY.gIF()))
    {
      this.Ipd = true;
      com.tencent.mm.ui.base.h.c(this, paramae.fUY.wording, "", paramae.fUY.oDK, paramae.fUY.oDJ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67955);
          Log.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[] { paramae.fUY.tVu });
          g.p(RemittanceBaseUI.this.getContext(), paramae.fUY.tVu, false);
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
  
  private boolean d(final ae paramae)
  {
    if (!Util.isNullOrNil(paramae.Imm))
    {
      this.Ipa = true;
      bV(1, paramae.fJG);
      com.tencent.mm.ui.base.h.c(this, paramae.Imm, getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67956);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 3, paramae.fJG);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramae))
          {
            RemittanceBaseUI.this.showLoading();
            RemittanceBaseUI.this.a(paramae.fHb, RemittanceBaseUI.this.iSn, RemittanceBaseUI.this.IoL, paramae);
          }
          AppMethodBeat.o(67956);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67957);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 2, paramae.fJG);
          AppMethodBeat.o(67957);
        }
      });
      return true;
    }
    return false;
  }
  
  private boolean e(final ae paramae)
  {
    boolean bool = false;
    String str1;
    String str2;
    if (paramae.Imk > 0)
    {
      this.Ipb = true;
      if (paramae.Iml == null) {
        break label143;
      }
      if (!Util.isNullOrNil(paramae.Iml.wording)) {
        break label120;
      }
      str1 = getString(a.i.remittance_remind_desc, new Object[] { Integer.valueOf(paramae.Imk) });
      String str3 = getString(a.i.remittance_continue);
      if (!Util.isNullOrNil(paramae.Iml.ImM)) {
        break label131;
      }
      str2 = getString(a.i.remittance_open_order_history_action);
      label87:
      b(this, str1, "", str3, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67958);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramae))
          {
            RemittanceBaseUI.this.showLoading();
            RemittanceBaseUI.this.a(paramae.fHb, RemittanceBaseUI.this.iSn, RemittanceBaseUI.this.IoL, paramae);
          }
          AppMethodBeat.o(67958);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67959);
          if (Util.isNullOrNil(paramae.Iml.ImN))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(67959);
            return;
          }
          com.tencent.mm.plugin.account.sdk.b.a.b(RemittanceBaseUI.this, paramae.Iml.ImN, 5, true);
          AppMethodBeat.o(67959);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label120:
      str1 = paramae.Iml.wording;
      break;
      label131:
      str2 = paramae.Iml.ImM;
      break label87;
      label143:
      Log.i("MicroMsg.RemittanceBaseUI", "scene.zaituMessage == null");
      b(this, getString(a.i.remittance_remind_desc, new Object[] { Integer.valueOf(paramae.Imk) }), getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.remittance_open_order_history_action), new DialogInterface.OnClickListener()new RemittanceBaseUI.13
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67961);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramae)) {
            RemittanceBaseUI.this.a(paramae.fHb, RemittanceBaseUI.this.iSn, RemittanceBaseUI.this.IoL, paramae);
          }
          AppMethodBeat.o(67961);
        }
      }, new RemittanceBaseUI.13(this));
    }
  }
  
  private boolean f(final ae paramae)
  {
    if (paramae.Imr)
    {
      this.Ipc = true;
      f.a(this, this.mScene, paramae.Imu / 100.0D, paramae.Imt / 100.0D, paramae.Imo / 100.0D, paramae.Imq, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67963);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          RemittanceBaseUI.this.showLoading();
          RemittanceBaseUI.this.a(paramae.fHb, RemittanceBaseUI.this.iSn, RemittanceBaseUI.this.IoL, paramae);
          if (RemittanceBaseUI.this.mScene == 1) {
            com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67963);
            return;
            com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          }
        }
      });
      return true;
    }
    return false;
  }
  
  private void fAB()
  {
    if ((fAF()) && (!Util.isNullOrNil(this.IoN)) && (this.IoP != 0) && (this.IoO == 1))
    {
      addIconOptionMenu(0, a.e.wallet_qanda_icon, new RemittanceBaseUI.27(this));
      return;
    }
    removeAllOptionMenu();
  }
  
  private void fAC()
  {
    if ((!Util.isNullOrNil(this.IoM)) && (this.IoP != 0))
    {
      int i;
      if (this.IoP == 1) {
        i = 2;
      }
      try
      {
        for (;;)
        {
          this.Iov.setText(String.format(this.IoM, new Object[] { Integer.valueOf(i) }));
          this.Iov.setVisibility(0);
          return;
          i = 24;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.RemittanceBaseUI", localException, "", new Object[0]);
          this.Iov.setText(getString(a.i.remittance_hardcode_tips, new Object[] { Integer.valueOf(i) }));
        }
      }
    }
    this.Iov.setText("");
    this.Iov.setVisibility(8);
  }
  
  private void fAE()
  {
    Object localObject2 = g.ic(g.PJ(this.iSn), 10);
    Object localObject1 = localObject2;
    if (!Util.isNullOrNil(this.IoL)) {
      localObject1 = getString(a.i.remittance_collect_block, new Object[] { localObject2, this.IoL });
    }
    if (this.mScene == 1)
    {
      localObject2 = getIntent().getStringExtra("receiver_tips");
      this.Iot.setTextColor(getResources().getColor(a.c.normal_text_color));
      this.Iou.setVisibility(0);
      if (Util.isNullOrNil(this.iSn))
      {
        localObject1 = getString(a.i.remittance_collect_pay_wrords_nick_tip_withdout_username, new Object[] { this.IoL });
        this.Iou.setText(l.b(this, (CharSequence)localObject1, this.Iou.getTextSize()));
        label148:
        this.Iot.setText(l.b(this, (CharSequence)localObject2, this.Iot.getTextSize()));
        if (!com.tencent.mm.kernel.h.aHB()) {
          break label488;
        }
        localObject1 = com.tencent.mm.am.q.bhP();
        if ((localObject1 == null) || (Util.isNullOrNil(this.iSn))) {
          break label488;
        }
        localObject1 = ((k)localObject1).TS(this.iSn);
        if ((localObject1 != null) && (!Util.isNullOrNil(((j)localObject1).bhI()))) {
          break label488;
        }
        final long l = Util.nowMilliSecond();
        az.a.ltq.a(this.iSn, "", new az.b.a()
        {
          public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(67981);
            if (paramAnonymousBoolean)
            {
              Log.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (Util.nowMilliSecond() - l) + " ms");
              com.tencent.mm.am.d.aH(paramAnonymousString, 3);
            }
            for (;;)
            {
              RemittanceBaseUI.e(RemittanceBaseUI.this);
              AppMethodBeat.o(67981);
              return;
              Log.w("MicroMsg.RemittanceBaseUI", "getContact failed");
            }
          }
        });
      }
    }
    label488:
    for (int i = 1;; i = 0)
    {
      if ((Util.isNullOrNil(this.iSn)) && (!Util.isNullOrNil(this.Ion)))
      {
        Log.i("MicroMsg.RemittanceBaseUI", "use mRecvHeadimgurl(%s) to avatar, mReceiverAvatarIv:%s", new Object[] { this.Ion, this.Ios.getClass().getSimpleName() });
        if ((this.Ios instanceof CdnImageView))
        {
          i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 44.0F);
          ((CdnImageView)this.Ios).setRoundCorner(true);
          ((CdnImageView)this.Ios).w(this.Ion, i, i, a.e.default_avatar);
        }
      }
      while (i != 0)
      {
        return;
        localObject1 = getString(a.i.remittance_collect_pay_wrords_nick_tip, new Object[] { g.ic(g.PJ(this.iSn), 10), this.IoL });
        break;
        localObject2 = localObject1;
        if (this.mScene != 6) {
          break label148;
        }
        localObject2 = getIntent().getStringExtra("receiver_tips");
        if (!Util.isNullOrNil(this.tMB)) {
          localObject1 = this.tMB;
        }
        if (Util.isNullOrNil((String)localObject2))
        {
          localObject2 = getString(a.i.remittance_collect_pay_wrords, new Object[] { localObject1 });
          break label148;
        }
        localObject2 = Util.safeFormatString((String)localObject2, new Object[] { localObject1 });
        break label148;
      }
      foI();
      return;
    }
  }
  
  private boolean fAF()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  private void foI()
  {
    RemittanceBaseUI.29 local29 = new RemittanceBaseUI.29(this);
    if (MMHandlerThread.isMainThread())
    {
      local29.run();
      return;
    }
    MMHandlerThread.postToMainThread(new RemittanceBaseUI.30(this, local29));
  }
  
  public void TM(String paramString)
  {
    Log.i("MicroMsg.RemittanceBaseUI", "onGet");
    if (Util.nullAsNil(paramString).length() <= 0) {
      Log.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.iSn)) {
      return;
    }
    foI();
  }
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final ae paramae)
  {
    Log.i("MicroMsg.RemittanceBaseUI", "startPay mKindaEnable %s reqKey %s", new Object[] { Boolean.valueOf(this.mKindaEnable), paramString1 });
    if (b(paramae))
    {
      if (paramae.ImL.Slx == 0)
      {
        this.Ipe = paramae.ImL;
        a(paramae, paramae.ImL);
      }
      do
      {
        return;
        if (paramae.ImL.Slx == 1)
        {
          localObject1 = new oa();
          ((oa)localObject1).has = ((int)paramae.Imy);
          localObject1 = ((oa)localObject1).EJ(paramae.username);
          ((oa)localObject1).hal = 4L;
          ((oa)localObject1).bpa();
          com.tencent.mm.ui.base.h.a(this, paramae.ImL.wording, paramae.ImL.title, getResources().getString(a.i.remittance_warn_re_name_continue), getResources().getString(a.i.remittance_warn_re_name_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(67968);
              Log.i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceBaseUI.g(RemittanceBaseUI.this) });
              paramAnonymousDialogInterface = new oa();
              paramAnonymousDialogInterface.has = ((int)paramae.Imy);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.EJ(paramae.username);
              paramAnonymousDialogInterface.hal = 9L;
              paramAnonymousDialogInterface.bpa();
              paramae.ImL = null;
              RemittanceBaseUI.this.a(paramString1, paramString2, paramString3, paramae);
              AppMethodBeat.o(67968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(67969);
              Log.i("MicroMsg.RemittanceBaseUI", "onClick1");
              paramAnonymousDialogInterface = new oa();
              paramAnonymousDialogInterface.has = ((int)paramae.Imy);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.EJ(paramae.username);
              paramAnonymousDialogInterface.hal = 8L;
              paramAnonymousDialogInterface.bpa();
              AppMethodBeat.o(67969);
            }
          }, a.c.real_name_goon_remittance);
          return;
        }
      } while (paramae.ImL.Slx != 2);
      com.tencent.mm.ui.base.h.a(this, paramae.ImL.wording, paramae.ImL.title, getResources().getString(a.i.welcome_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      return;
    }
    if (this.IoY)
    {
      localObject1 = new oa();
      ((oa)localObject1).has = paramae.amount;
      localObject1 = ((oa)localObject1).EJ(paramae.username);
      ((oa)localObject1).hal = 5L;
      ((oa)localObject1).bpa();
    }
    this.IoY = false;
    if (this.mPayScene == 31) {
      aWO(this.IoK);
    }
    Object localObject1 = new PayInfo();
    ((PayInfo)localObject1).fwv = paramString1;
    ((PayInfo)localObject1).fOY = this.mPayScene;
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
    paramString1.putString("extinfo_key_3", this.IoJ);
    paramString1.putBoolean("extinfo_key_4", bool);
    paramString1.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
    paramString1.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
    paramString1.putString("extinfo_key_7", this.mDesc);
    paramString1.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
    paramString1.putString("extinfo_key_16", this.IoU);
    if (paramae != null) {
      paramString1.putString("extinfo_key_19", paramae.ImI);
    }
    int j = 0;
    int i = j;
    if (this.mScene == 1)
    {
      i = j;
      if (paramae != null)
      {
        paramString1.putString("extinfo_key_11", paramae.Imw);
        paramString1.putInt("extinfo_key_12", paramae.ImC);
        paramString1.putString("extinfo_key_13", paramae.ImD);
        paramString1.putString("extinfo_key_14", paramae.ImE);
        paramString1.putString("extinfo_key_17", paramae.ImG);
        paramString1.putString("extinfo_key_18", paramae.ImH);
        i = paramae.ImF;
      }
    }
    if (paramae != null) {
      paramString1.putInt("extinfo_key_15", paramae.amount);
    }
    if (this.Ioq)
    {
      paramString1.putBoolean("extinfo_key_23", this.Ioq);
      paramString1.putString("extinfo_key_24", this.mName);
      paramString1.putString("extinfo_key_25", this.GIN);
      paramString1.putString("extinfo_key_26", this.IoH);
    }
    ((PayInfo)localObject1).lfu = paramString1;
    paramString1 = new Intent();
    Log.i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      paramString1.setClass(this, RemittanceF2fDynamicCodeUI.class);
      paramString1.putExtra("key_pay_info", (Parcelable)localObject1);
      paramString1.putExtra("key_rcvr_open_id", this.IoQ);
      paramString1.putExtra("key_mch_info", this.Ioo);
      paramString1.putExtra("from_patch_ui", true);
      paramString1.putExtra("get_dynamic_code_sign", paramae.ImG);
      paramString1.putExtra("get_dynamic_code_extend", paramae.ImH);
      paramString1.putExtra("dynamic_code_spam_wording", paramae.ImJ);
      paramString1.putExtra("show_paying_wording", paramae.ImI);
      paramString1.putExtra("key_transfer_qrcode_id", this.Ior);
      com.tencent.mm.plugin.report.service.h.IzE.a(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      this.Ipf.alive();
      startActivityForResult(paramString1, 5);
      return;
    }
    if (this.mKindaEnable)
    {
      paramae = "";
      paramString3 = "";
      Object localObject2 = getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
      if (!Util.isNullOrNil(paramString2))
      {
        com.tencent.mm.kernel.h.aHH();
        paramString1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwg(paramString2);
        if (paramString1 != null)
        {
          paramString3 = paramString1.ays();
          paramae = new StringBuilder().append(g.bCw(paramString3));
          if (Util.isNullOrNil(this.IoL))
          {
            paramString1 = "";
            paramString1 = paramString1;
            paramae = Util.safeFormatString((String)localObject2, new Object[] { paramString1 });
            paramString3 = getString(a.i.remittance_result_receiver_desc, new Object[] { g.bCw(paramString3) });
          }
        }
      }
      for (;;)
      {
        if (((PayInfo)localObject1).lfu == null) {
          ((PayInfo)localObject1).lfu = new Bundle();
        }
        localObject2 = ((PayInfo)localObject1).lfu;
        ((Bundle)localObject2).putString("extinfo_key_1", paramString2);
        ((Bundle)localObject2).putString("extinfo_key_2", this.IoL);
        ((Bundle)localObject2).putString("cashier_desc", paramae);
        ((Bundle)localObject2).putString("prepay_page_payee", paramString1);
        ((Bundle)localObject2).putString("succ_tip", paramString3);
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, (PayInfo)localObject1);
        return;
        paramString1 = "(" + this.IoL + ")";
        break;
        Log.e("MicroMsg.RemittanceBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        Log.e("MicroMsg.RemittanceBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.Iol, paramString1);
    if ((paramae.IlF != null) && (paramae.IlF.fDc.fDf != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramae.IlF.fDc.fDf, false, "", (PayInfo)localObject1, paramString3, paramString1, paramae.IlF.fDc.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public abstract void aWN(String paramString);
  
  public abstract void fAA();
  
  public abstract void fAD();
  
  protected final void fAG()
  {
    aWN(this.mDesc);
  }
  
  protected void fAH()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("recent_remittance_contact_list", al.fAq());
    localIntent.setClass(getContext(), SelectRemittanceContactUI.class);
    startActivityForResult(localIntent, 2);
  }
  
  public void fAy()
  {
    ac localac = new ac(this.iSn, this.Ior);
    localac.setProcessName("RemittanceProcess");
    doSceneProgress(localac);
  }
  
  public void fAz() {}
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    if ((this.mPayScene == 33) || (this.mPayScene == 32)) {
      return a.g.remittance_new_ui_f2f;
    }
    if (Util.isEqual(this.Iop, 0))
    {
      hideActionbarLine();
      return a.g.remittance_new_ui_mainland;
    }
    return a.g.remittance_new_ui;
  }
  
  public void initView()
  {
    if ((this.mPayScene == 33) || (this.mPayScene == 32))
    {
      setMMTitle(a.i.remittance_busi_pay);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67950);
          if ((RemittanceBaseUI.this.mScene == 1) || (RemittanceBaseUI.this.mScene == 6))
          {
            RemittanceBaseUI.this.fAy();
            RemittanceBaseUI.this.finish();
          }
          for (;;)
          {
            RemittanceBaseUI.this.fAz();
            AppMethodBeat.o(67950);
            return true;
            if ((RemittanceBaseUI.this.mScene == 2) || (RemittanceBaseUI.this.mScene == 5)) {
              RemittanceBaseUI.this.finish();
            } else {
              RemittanceBaseUI.this.fAH();
            }
          }
        }
      });
      this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
      this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
      this.mMs = ((ScrollView)findViewById(a.f.root_view));
      this.Ios = ((ImageView)findViewById(a.f.remittance_receiver_avatar));
      this.Iot = ((TextView)findViewById(a.f.remittance_receiver_display_name));
      this.Iou = ((TextView)findViewById(a.f.remittance_receiver_display_name_tip));
      this.Iou.setVisibility(8);
      this.IoC = ((LinearLayout)findViewById(a.f.remittance_edit_layout));
      this.IoB = ((LinearLayout)findViewById(a.f.remittance_ftf_desc_layout));
      this.Ioz = ((TextView)findViewById(a.f.remittance_fixed_amount_fee));
      this.IoA = ((TextView)findViewById(a.f.remittance_fixed_amount_fee_currency));
      this.Ioy = ((TextView)findViewById(a.f.remittance_fixed_amount_desc));
      if (Util.isEqual(this.Iop, 0))
      {
        this.IoD = ((LinearLayout)findViewById(a.f.remittance_address_container));
        this.IoE = ((TextView)findViewById(a.f.name_telephone_tv));
        this.IoF = ((TextView)findViewById(a.f.address_detail_tv));
      }
      fAE();
      this.tZh = ((WalletFormView)findViewById(a.f.money_ev));
      if (this.mPayScene != 33) {
        break label657;
      }
      this.Ioz.setText(g.formatMoney2f(this.mMC));
      this.IoA.setText(ah.ijb());
      this.IoJ = getIntent().getStringExtra("desc");
      if (Util.isNullOrNil(this.IoJ)) {
        break label645;
      }
      this.Ioy.setText(l.b(getContext(), this.IoJ, this.Ioy.getTextSize()));
      this.Ioy.setVisibility(0);
      label358:
      this.IoB.setVisibility(0);
      this.IoC.setVisibility(8);
      label375:
      this.njb = ((Button)findViewById(a.f.next_btn));
      this.njb.setOnClickListener(new aa()
      {
        public final void cOw()
        {
          AppMethodBeat.i(67960);
          RemittanceBaseUI localRemittanceBaseUI;
          String str;
          if (RemittanceBaseUI.this.mPayScene == 33)
          {
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.aWN(str);
            if (RemittanceBaseUI.b(RemittanceBaseUI.this) == 0.0D)
            {
              if (RemittanceBaseUI.this.mScene != 1) {
                break label261;
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceBaseUI.this.mScene == 1) && (!Util.isNullOrNil(RemittanceBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.h.IzE.a(14074, new Object[] { Integer.valueOf(2) });
            }
            AppMethodBeat.o(67960);
            return;
            RemittanceBaseUI.this.mMC = Util.getDouble(RemittanceBaseUI.this.tZh.getText(), 0.0D);
            if (!RemittanceBaseUI.this.tZh.bAz())
            {
              w.makeText(RemittanceBaseUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
              break;
            }
            if (RemittanceBaseUI.this.mMC < 0.01D)
            {
              RemittanceBaseUI.this.fAA();
              break;
            }
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.fAI();
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.aWN(str);
            break;
            label261:
            com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      });
      this.Iow = ((TextView)findViewById(a.f.remittance_desc));
      this.Iox = ((TextView)findViewById(a.f.add_remittance_desc));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label778;
      }
      this.Iox.setText(a.i.remittance_add_f2f_desc_link);
    }
    for (;;)
    {
      if (!z.bdq()) {
        findViewById(a.f.remittance_desc_container).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67977);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.fAI();
            com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            if ((RemittanceBaseUI.this.mScene == 1) || (RemittanceBaseUI.this.mScene == 6))
            {
              localObject = RemittanceBaseUI.this.getString(a.i.remittance_add_f2f_desc_link);
              paramAnonymousView = RemittanceBaseUI.this.getString(a.i.remittance_desc_max_words_count_tip);
              com.tencent.mm.plugin.report.service.h.IzE.a(14074, new Object[] { Integer.valueOf(1) });
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
                    if (!Util.isNullOrNil(paramAnonymous2CharSequence.toString()))
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
                    MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
                str1 = RemittanceBaseUI.this.getString(a.i.remittance_add_desc_link);
                str2 = RemittanceBaseUI.this.getString(a.i.remittance_busi_desc_max_words_count_tip);
                localObject = str1;
                paramAnonymousView = str2;
              } while (!Util.isEqual(RemittanceBaseUI.a(RemittanceBaseUI.this), 0));
              localObject = str1;
              paramAnonymousView = str2;
            } while (!RemittanceBaseUI.this.Ioq);
            com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, str1, RemittanceBaseUI.this.mDesc, str2, RemittanceBaseUI.this.IoI, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.GIN, RemittanceBaseUI.this.IoH, new a.a()new f.c
            {
              public final boolean a(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4)
              {
                AppMethodBeat.i(67971);
                RemittanceBaseUI.this.IoI = paramAnonymous2Boolean;
                if (!Util.isNullOrNil(paramAnonymous2String1))
                {
                  RemittanceBaseUI.this.mDesc = paramAnonymous2String1;
                  if (RemittanceBaseUI.this.IoI) {
                    break label188;
                  }
                  if (Util.isNullOrNil(paramAnonymous2String2)) {
                    break label146;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymous2String2;
                  label65:
                  if (Util.isNullOrNil(paramAnonymous2String3)) {
                    break label160;
                  }
                  RemittanceBaseUI.this.GIN = paramAnonymous2String3;
                  label85:
                  if (Util.isNullOrNil(paramAnonymous2String4)) {
                    break label174;
                  }
                  RemittanceBaseUI.this.IoH = paramAnonymous2String4;
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
                  RemittanceBaseUI.this.GIN = null;
                  break label85;
                  label174:
                  RemittanceBaseUI.this.IoH = null;
                  continue;
                  label188:
                  RemittanceBaseUI.this.mName = null;
                  RemittanceBaseUI.this.GIN = null;
                  RemittanceBaseUI.this.IoH = null;
                }
              }
            }, new f.c()
            {
              public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(67973);
                MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
        com.tencent.mm.kernel.h.aHH();
        if (((String)com.tencent.mm.kernel.h.aHG().aHp().b(327732, "0")).equals("0"))
        {
          com.tencent.mm.ui.base.h.a(getContext(), a.i.remittance_first_ftf_pay_tips, a.i.remittance_first_ftf_pay_tips_title, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(327732, "1");
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().hxT();
        }
      }
      this.Iov = ((TextView)findViewById(a.f.placeholder));
      this.IoG = ((LinearLayout)findViewById(a.f.remittance_main_ui));
      fAC();
      fAD();
      fAB();
      if ((this.mPayScene != 33) && (this.mPayScene == 32)) {}
      return;
      setMMTitle(a.i.remittance_title);
      break;
      label645:
      this.Ioy.setVisibility(8);
      break label358;
      label657:
      this.tZh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67984);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          RemittanceBaseUI.this.hideTenpayKB();
          RemittanceBaseUI.fAI();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67984);
        }
      });
      this.tZh.getTitleTv().setText(String.format(getString(a.i.remittance_fee_tips), new Object[] { "¥" }));
      this.tZh.a(new RemittanceBaseUI.2(this));
      setEditFocusListener(this.tZh, 2, false);
      findViewById(a.f.placeholder);
      findViewById(a.f.remittance_main_ui).setVisibility(0);
      this.IoB.setVisibility(8);
      this.IoC.setVisibility(0);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(67952);
          if (paramAnonymousBoolean)
          {
            RemittanceBaseUI.a(RemittanceBaseUI.this, RemittanceBaseUI.this.mMs, RemittanceBaseUI.this.njb);
            AppMethodBeat.o(67952);
            return;
          }
          RemittanceBaseUI.this.mMs.scrollTo(0, 0);
          AppMethodBeat.o(67952);
        }
      });
      break label375;
      label778:
      this.Iox.setText(a.i.remittance_add_desc_link);
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
    Log.i("MicroMsg.RemittanceBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + Util.nullAs(this.iSn, "null") + ", =" + Util.nullAs(this.tMB, "null"));
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
        if (!Util.isNullOrNil(str1))
        {
          this.iSn = str1;
          fAE();
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
          str1 = getString(a.i.bank_remit_remittance_desc_text);
          String str2 = getString(a.i.remittance_desc_max_words_count_tip);
          String str3 = paramIntent.getStringExtra("userName");
          String str4 = paramIntent.getStringExtra("telNumber");
          String str5 = paramIntent.getStringExtra("proviceFirstStageName") + paramIntent.getStringExtra("addressCitySecondStageName") + paramIntent.getStringExtra("addressCountiesThirdStageName") + paramIntent.getStringExtra("addressDetailInfo");
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, str1, this.mDesc, str2, false, str3, str4, str5, new a.a()new f.c
          {
            public final boolean a(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
            {
              AppMethodBeat.i(67964);
              RemittanceBaseUI.this.IoI = paramAnonymousBoolean;
              if (!Util.isNullOrNil(paramAnonymousString1))
              {
                RemittanceBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceBaseUI.this.IoI)
                {
                  if (Util.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (Util.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceBaseUI.this.GIN = paramAnonymousString3;
                  label70:
                  if (Util.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceBaseUI.this.IoH = paramAnonymousString4;; RemittanceBaseUI.this.IoH = null)
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
                RemittanceBaseUI.this.GIN = null;
                break label70;
              }
            }
          }, new f.c()
          {
            public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(67966);
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
    if (!fAF())
    {
      this.fLj = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.bgD(this.fLj);
    }
    long l;
    if ((this instanceof RemittanceHKUI))
    {
      this.Iop = 1;
      super.onCreate(paramBundle);
      this.Iol = com.tencent.mm.plugin.wallet.a.be(getIntent());
      this.Ior = getIntent().getStringExtra("scan_remittance_id");
      this.mMC = getIntent().getDoubleExtra("fee", 0.0D);
      this.iSn = getIntent().getStringExtra("receiver_name");
      this.Ion = getIntent().getStringExtra("recv_headimgurl");
      this.tMB = getIntent().getStringExtra("receiver_nick_name");
      this.IoL = getIntent().getStringExtra("receiver_true_name");
      this.Iom = getIntent().getStringExtra("mch_name");
      this.Ioo = getIntent().getStringExtra("mch_info");
      this.mChannel = getIntent().getIntExtra("pay_channel", 0);
      this.IoQ = Util.nullAs(getIntent().getStringExtra("rcvr_open_id"), "");
      Log.i("MicroMsg.RemittanceBaseUI", "mUserName %s", new Object[] { this.iSn });
      com.tencent.mm.kernel.h.aHH();
      l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().b(147457, Long.valueOf(0L))).longValue();
      if ((0x10 & l) == 0L) {
        break label342;
      }
      this.IoP = 1;
    }
    for (;;)
    {
      com.tencent.mm.am.q.bhz().a(this);
      initView();
      this.Ipk.alive();
      com.tencent.mm.wallet_core.b.iie();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.vCG, true);
      return;
      if (!(this instanceof RemittanceOSUI)) {
        break;
      }
      this.Iop = 2;
      break;
      label342:
      if ((l & 0x20) != 0L) {
        this.IoP = 2;
      } else {
        this.IoP = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    EventCenter.instance.removeListener(this.IoZ);
    com.tencent.mm.am.q.bhz().b(this);
    this.Ipk.dead();
    this.Ipf.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.bgE(this.fLj);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    this.IoS = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof ae))
      {
        paramq = (ae)paramq;
        af.B(this.mPayScene, paramq.fHb, paramInt2);
        this.IoK = paramq.Imn;
        if (!Util.isNullOrNil(paramq.Imv)) {
          this.IoL = paramq.Imv;
        }
        if ((this.mPayScene == 32) || (this.mPayScene == 33))
        {
          this.IoU = paramq.tUC;
          if (this.Iol != null) {
            this.Iol.j(10000, new Object[] { Integer.valueOf(this.mPayScene), this.iSn, Double.valueOf(paramq.Imy) });
          }
          if (paramq.ImL != null) {
            break label278;
          }
          paramString = "";
          label158:
          this.IoR = paramString;
          if (a(paramq)) {
            break label312;
          }
          a(paramq.fHb, this.iSn, this.IoL, paramq);
          label191:
          paramString = new a(paramq.Imw, paramq.tUC, paramq.tXa, paramq.Imx, paramq.amount, paramq.fJG, paramq.fww, paramq.ImB, Util.getLong(paramq.Imz, 0L));
          this.IoT.put(paramq.fHb, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.IoU = paramq.fJG;
        break;
        label278:
        if (Util.isNullOrNil(paramq.ImL.IoR))
        {
          paramString = this.IoR;
          break label158;
        }
        paramString = paramq.ImL.IoR;
        break label158;
        label312:
        if (!this.mKindaEnable) {
          break label191;
        }
        hideLoading();
        break label191;
        if ((paramq instanceof aj)) {
          throw null;
        }
        if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.ak))
        {
          this.IoM = ((com.tencent.mm.plugin.wallet_core.c.ak)paramq).oFx;
          this.IoN = ((com.tencent.mm.plugin.wallet_core.c.ak)paramq).OIG;
          this.IoO = ((com.tencent.mm.plugin.wallet_core.c.ak)paramq).OIH;
          fAC();
          fAB();
        }
      }
    }
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.ak))
    {
      Log.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
      this.Iov.setText("");
      this.Iov.setVisibility(8);
    }
    do
    {
      do
      {
        return false;
      } while (!(paramq instanceof ae));
      if (this.mKindaEnable) {
        hideLoading();
      }
      this.IoW = ((ae)paramq);
      EventCenter.instance.add(this.IoZ);
      af.B(this.mPayScene, "", paramInt2);
    } while (!c((ae)paramq));
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    String ImB;
    String Imw;
    String Imx;
    long Ipu;
    int amount;
    String fJG;
    String fww;
    String tUC;
    String tXa;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong)
    {
      this.Imw = paramString1;
      this.tUC = paramString2;
      this.tXa = paramString3;
      this.Imx = paramString4;
      this.amount = paramInt;
      this.fJG = paramString5;
      this.fww = paramString6;
      this.ImB = paramString7;
      this.Ipu = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
 * JD-Core Version:    0.7.0.1
 */