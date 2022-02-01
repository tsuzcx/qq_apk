package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.f.a.gs;
import com.tencent.mm.f.a.gs.a;
import com.tencent.mm.f.a.gu;
import com.tencent.mm.f.b.a.nt;
import com.tencent.mm.f.b.a.oa;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.remittance.model.ae;
import com.tencent.mm.plugin.remittance.model.ae.a;
import com.tencent.mm.plugin.remittance.model.al;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
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
  implements com.tencent.mm.am.f.a, WcPayKeyboard.a
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 270);
  protected int Iko = 4;
  private long Ilo;
  private String Imh;
  private double Ims;
  protected TextView IoA;
  private LinearLayout IoB;
  private LinearLayout IoC;
  private LinearLayout IoD;
  private TextView IoE;
  private TextView IoF;
  LinearLayout IoG;
  protected String IoH = "";
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
  private IListener IoZ = new RemittanceNewBaseUI.9(this);
  protected com.tencent.mm.plugin.wallet.a Iol = null;
  protected String Iom;
  protected String Ioo;
  private int Iop = -1;
  protected boolean Ioq = false;
  protected String Ior;
  protected ImageView Ios;
  protected TextView Iot;
  protected TextView Iou;
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
  private IListener<gu> Ipk = new RemittanceNewBaseUI.29(this);
  protected boolean Iru = false;
  TextView IuA;
  CdnImageView IuB;
  CdnImageView IuC;
  TextView IuD;
  protected String Iuv = "";
  private RemittanceRemarkInputHalfPage Iuw;
  private long Iux;
  LinearLayout Iuy;
  LinearLayout Iuz;
  protected String auA;
  private String fLj;
  protected int fRV = 0;
  protected String iSn;
  private int mChannel;
  protected String mDesc = "";
  protected double mMC;
  private Runnable mMK = new Runnable()
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
  private int mMr;
  protected ScrollView mMs;
  private WcPayKeyboard mMt;
  private RelativeLayout mMx;
  private TextView mMy;
  private RelativeLayout mMz;
  protected int mPayScene;
  protected int mScene;
  private int state = 0;
  protected String tMB;
  protected WalletFormView tZh;
  private com.tencent.mm.ui.widget.a.g tZx;
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, g.a parama1, g.a parama2)
  {
    if (this.tZx != null)
    {
      this.tZx.bYF();
      this.tZx = null;
    }
    this.tZx = new com.tencent.mm.ui.widget.a.g(paramContext, 1, 3);
    this.tZx.d(paramString4, paramString3);
    this.tZx.a(parama2, parama1);
    paramString3 = View.inflate(paramContext, a.g.remittance_new_ui_half_dialog_title_view, null);
    paramString4 = (TextView)paramString3.findViewById(a.f.half_dialog_title);
    ar.a(paramString4.getPaint(), 0.8F);
    paramString4.setText(paramString2);
    ((WeImageView)paramString3.findViewById(a.f.half_dialog_close_iv)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68230);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (RemittanceNewBaseUI.n(RemittanceNewBaseUI.this) != null) {
          RemittanceNewBaseUI.n(RemittanceNewBaseUI.this).bYF();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68230);
      }
    });
    this.tZx.setHeaderView(paramString3);
    paramContext = View.inflate(paramContext, a.g.remittance_new_ui_half_dialog_content_view, null);
    paramString2 = (TextView)paramContext.findViewById(a.f.half_dialog_content);
    ar.a(paramString2.getPaint(), 0.8F);
    paramString2.setText(paramString1);
    this.tZx.setCustomView(paramContext);
    this.tZx.eik();
  }
  
  private void a(ae paramae, zh paramzh)
  {
    this.IoY = true;
    new c(this).a(paramae, paramzh, new c.a()
    {
      public final void aWF(String paramAnonymousString)
      {
        AppMethodBeat.i(276436);
        Log.i("MicroMsg.RemittanceNewBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceNewBaseUI.this.IoS = paramAnonymousString;
        RemittanceNewBaseUI.this.fAG();
        AppMethodBeat.o(276436);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(276438);
        RemittanceNewBaseUI.this.IoS = "";
        RemittanceNewBaseUI.this.hideLoading();
        RemittanceNewBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(276438);
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
      if (!bool1)
      {
        bool2 = bool1;
        if (!Util.isNullOrNil(paramae.Imz))
        {
          bool2 = bool1;
          if (!Util.isNullOrNil(paramae.ImA))
          {
            String str2 = com.tencent.mm.wallet_core.ui.g.ic(com.tencent.mm.wallet_core.ui.g.PJ(this.iSn), 10);
            String str1 = str2;
            if (!Util.isNullOrNil(this.IoL)) {
              str1 = getString(a.i.remittance_collect_block, new Object[] { str2, this.IoL });
            }
            bool2 = a(paramae.fHb, paramae.ImA, str1, paramae.Imz, paramae);
          }
        }
      }
      return bool2;
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
        AppMethodBeat.i(191072);
        RemittanceNewBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(191072);
      }
    });
    paramString2.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68239);
        RemittanceNewBaseUI.this.showLoading();
        RemittanceNewBaseUI.this.a(paramString1, RemittanceNewBaseUI.this.iSn, RemittanceNewBaseUI.this.IoL, paramae);
        AppMethodBeat.o(68239);
      }
    });
    paramString2.icu().show();
    return true;
  }
  
  private static void aWO(String paramString)
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
    com.tencent.mm.plugin.remittance.a.c.fzJ().fzM().kb(str, paramString);
  }
  
  private void aWR(String paramString)
  {
    com.tencent.mm.wallet_core.ui.g.a(this.Iox, paramString, 0, paramString.length(), new com.tencent.mm.wallet_core.ui.f(new com.tencent.mm.wallet_core.ui.f.a()
    {
      public final void bwz()
      {
        AppMethodBeat.i(271283);
        RemittanceNewBaseUI.k(RemittanceNewBaseUI.this);
        AppMethodBeat.o(271283);
      }
    }), getContext());
  }
  
  private void b(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      this.fRV = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.RemittanceNewBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.fRV), Double.valueOf(this.Ipg), this.Iph, this.Ipi, this.Ipj });
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
          AppMethodBeat.i(68222);
          Log.i("MicroMsg.RemittanceNewBaseUI", "goto h5: %s", new Object[] { paramae.fUY.tVu });
          com.tencent.mm.wallet_core.ui.g.p(RemittanceNewBaseUI.this.getContext(), paramae.fUY.tVu, false);
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
  
  private boolean d(final ae paramae)
  {
    if (!Util.isNullOrNil(paramae.Imm))
    {
      this.Ipa = true;
      bV(1, paramae.fJG);
      com.tencent.mm.ui.base.h.c(this, paramae.Imm, "", getString(a.i.remittance_continue), getString(a.i.remittance_dialog_cancel_remittance), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68224);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 3, paramae.fJG);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramae))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramae.fHb, RemittanceNewBaseUI.this.iSn, RemittanceNewBaseUI.this.IoL, paramae);
          }
          AppMethodBeat.o(68224);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68225);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 2, paramae.fJG);
          if ((RemittanceNewBaseUI.this.mScene == 1) || (RemittanceNewBaseUI.this.mScene == 6))
          {
            RemittanceNewBaseUI.this.fAy();
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
          RemittanceNewBaseUI.this.fAH();
          AppMethodBeat.o(68225);
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
        break label153;
      }
      if (!Util.isNullOrNil(paramae.Iml.wording)) {
        break label130;
      }
      str1 = getString(a.i.remittance_remind_desc, new Object[] { Integer.valueOf(paramae.Imk) });
      String str3 = getString(a.i.remittance_second_alert_title);
      String str4 = getString(a.i.remittance_continue);
      if (!Util.isNullOrNil(paramae.Iml.ImM)) {
        break label141;
      }
      str2 = getString(a.i.remittance_open_order_history_action);
      label96:
      a(this, str1, str3, str4, str2, new g.a()new g.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(275992);
          if (RemittanceNewBaseUI.n(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this).bYF();
            RemittanceNewBaseUI.o(RemittanceNewBaseUI.this);
          }
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramae))
          {
            if (RemittanceNewBaseUI.p(RemittanceNewBaseUI.this)) {
              RemittanceNewBaseUI.this.showLoading();
            }
            RemittanceNewBaseUI.this.a(paramae.fHb, RemittanceNewBaseUI.this.iSn, RemittanceNewBaseUI.this.IoL, paramae);
          }
          AppMethodBeat.o(275992);
        }
      }, new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(265124);
          if (RemittanceNewBaseUI.n(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this).bYF();
            RemittanceNewBaseUI.o(RemittanceNewBaseUI.this);
          }
          if (Util.isNullOrNil(paramae.Iml.ImN))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(265124);
            return;
          }
          com.tencent.mm.plugin.account.sdk.b.a.b(RemittanceNewBaseUI.this, paramae.Iml.ImN, 5, true);
          AppMethodBeat.o(265124);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label130:
      str1 = paramae.Iml.wording;
      break;
      label141:
      str2 = paramae.Iml.ImM;
      break label96;
      label153:
      Log.i("MicroMsg.RemittanceNewBaseUI", "scene.zaituMessage == null");
      a(this, getString(a.i.remittance_remind_desc, new Object[] { Integer.valueOf(paramae.Imk) }), getString(a.i.remittance_second_alert_title), getString(a.i.remittance_continue), getString(a.i.remittance_open_order_history_action), new g.a()new g.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(187660);
          if (RemittanceNewBaseUI.n(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this).bYF();
            RemittanceNewBaseUI.o(RemittanceNewBaseUI.this);
          }
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramae))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramae.fHb, RemittanceNewBaseUI.this.iSn, RemittanceNewBaseUI.this.IoL, paramae);
          }
          AppMethodBeat.o(187660);
        }
      }, new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(227933);
          if (RemittanceNewBaseUI.n(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this).bYF();
            RemittanceNewBaseUI.o(RemittanceNewBaseUI.this);
          }
          com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
          AppMethodBeat.o(227933);
        }
      });
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
          AppMethodBeat.i(248606);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          RemittanceNewBaseUI.this.showLoading();
          RemittanceNewBaseUI.this.a(paramae.fHb, RemittanceNewBaseUI.this.iSn, RemittanceNewBaseUI.this.IoL, paramae);
          if (RemittanceNewBaseUI.this.mScene == 1) {
            com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248606);
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
      addIconOptionMenu(0, a.e.wallet_qanda_icon, new RemittanceNewBaseUI.41(this));
      return;
    }
    removeAllOptionMenu();
  }
  
  private void fAC()
  {
    int i;
    if ((!Util.isNullOrNil(this.IoM)) && (this.IoP != 0))
    {
      if (this.IoP == 1) {}
      for (i = 2;; i = 24) {
        try
        {
          this.mMt.setTipText(String.format(this.IoM, new Object[] { Integer.valueOf(i) }));
          return;
        }
        catch (Exception localException)
        {
          Log.i("MicroMsg.RemittanceNewBaseUI", "updatePlaceHolderTv() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          this.mMt.setTipText(getString(a.i.remittance_hardcode_tips, new Object[] { Integer.valueOf(i) }));
          return;
        }
      }
    }
    this.mMt.gxi();
  }
  
  private void foI()
  {
    final Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68217);
        a.b.a(RemittanceNewBaseUI.this.Ios, RemittanceNewBaseUI.this.iSn, 0.1F, false);
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
  
  private void gR(boolean paramBoolean)
  {
    this.mMt.Ih(paramBoolean);
  }
  
  public final void TM(String paramString)
  {
    Log.i("MicroMsg.RemittanceNewBaseUI", "onGet");
    if (Util.nullAsNil(paramString).length() <= 0) {
      Log.e("MicroMsg.RemittanceNewBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.iSn)) {
      return;
    }
    foI();
  }
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final ae paramae)
  {
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
              AppMethodBeat.i(191327);
              Log.i("MicroMsg.RemittanceNewBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceNewBaseUI.q(RemittanceNewBaseUI.this) });
              paramAnonymousDialogInterface = new oa();
              paramAnonymousDialogInterface.has = ((int)paramae.Imy);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.EJ(paramae.username);
              paramAnonymousDialogInterface.hal = 9L;
              paramAnonymousDialogInterface.bpa();
              paramae.ImL = null;
              RemittanceNewBaseUI.this.a(paramString1, paramString2, paramString3, paramae);
              AppMethodBeat.o(191327);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68236);
              Log.i("MicroMsg.RemittanceNewBaseUI", "onClick1");
              paramAnonymousDialogInterface = new oa();
              paramAnonymousDialogInterface.has = ((int)paramae.Imy);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.EJ(paramae.username);
              paramAnonymousDialogInterface.hal = 8L;
              paramAnonymousDialogInterface.bpa();
              RemittanceNewBaseUI.this.hideLoading();
              AppMethodBeat.o(68236);
            }
          }, a.c.real_name_goon_remittance);
          return;
        }
      } while (paramae.ImL.Slx != 2);
      com.tencent.mm.ui.base.h.a(this, paramae.ImL.wording, paramae.ImL.title, getResources().getString(a.i.welcome_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68237);
          RemittanceNewBaseUI.this.hideLoading();
          AppMethodBeat.o(68237);
        }
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
    ((PayInfo)localObject1).lfu = paramString1;
    paramString1 = new Intent();
    Log.i("MicroMsg.RemittanceNewBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
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
          paramae = new StringBuilder().append(com.tencent.mm.wallet_core.ui.g.bCw(paramString3));
          if (Util.isNullOrNil(this.IoL))
          {
            paramString1 = "";
            paramString1 = paramString1;
            paramae = Util.safeFormatString((String)localObject2, new Object[] { paramString1 });
            paramString3 = getString(a.i.remittance_result_receiver_desc, new Object[] { com.tencent.mm.wallet_core.ui.g.bCw(paramString3) });
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
        this.Iru = true;
        return;
        paramString1 = "(" + this.IoL + ")";
        break;
        Log.e("MicroMsg.RemittanceNewBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        Log.e("MicroMsg.RemittanceNewBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.Iol, paramString1);
    ((PayInfo)localObject1).Rzp = this.fLj;
    ((PayInfo)localObject1).aNY = this.IoV;
    if ((paramae.IlF != null) && (paramae.IlF.fDc.fDf != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramae.IlF.fDc.fDf, false, "", (PayInfo)localObject1, paramString3, paramString1, paramae.IlF.fDc.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, gs paramgs);
  
  public final void bU(float paramFloat) {}
  
  public abstract void fAA();
  
  public abstract void fAD();
  
  protected final void fAE()
  {
    Object localObject1 = com.tencent.mm.wallet_core.ui.g.ib(com.tencent.mm.wallet_core.ui.g.PJ(this.iSn), 10);
    Object localObject2 = localObject1;
    if (!Util.isNullOrNil(this.IoL)) {
      localObject2 = getString(a.i.remittance_collect_block, new Object[] { localObject1, this.IoL });
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
        localObject1 = localObject2;
        label152:
        com.tencent.mm.wallet_core.ui.g.N(this.Iot);
        this.Iot.setText(l.b(this, (CharSequence)localObject1, this.Iot.getTextSize()));
        if (!com.tencent.mm.kernel.h.aHB()) {
          break label381;
        }
        localObject1 = com.tencent.mm.am.q.bhP();
        if ((localObject1 == null) || (Util.isNullOrNil(this.iSn))) {
          break label381;
        }
        localObject1 = ((k)localObject1).TS(this.iSn);
        if ((localObject1 != null) && (!Util.isNullOrNil(((j)localObject1).bhI()))) {
          break label381;
        }
        long l = Util.nowMilliSecond();
        az.a.ltq.a(this.iSn, "", new RemittanceNewBaseUI.3(this, l));
      }
    }
    label381:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        foI();
      }
      return;
      localObject1 = getString(a.i.remittance_collect_pay_wrords_nick_tip, new Object[] { com.tencent.mm.wallet_core.ui.g.ic(com.tencent.mm.wallet_core.ui.g.PJ(this.iSn), 10), this.IoL });
      break;
      localObject1 = localObject2;
      if (this.mScene != 6) {
        break label152;
      }
      localObject1 = getIntent().getStringExtra("receiver_tips");
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject1 = getString(a.i.remittance_collect_pay_wrords, new Object[] { localObject2 });
        break label152;
      }
      localObject1 = Util.safeFormatString((String)localObject1, new Object[] { localObject2 });
      break label152;
    }
  }
  
  protected final boolean fAF()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  protected final void fAG()
  {
    if (this.mPayScene == 33)
    {
      a(this.mDesc, this.IoH, this.IoJ, "", null);
      return;
    }
    a(this.mDesc, this.IoH, null, "", null);
  }
  
  protected final void fAH()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("recent_remittance_contact_list", al.fAq());
    localIntent.setClass(getContext(), SelectRemittanceContactUI.class);
    startActivityForResult(localIntent, 2);
  }
  
  public abstract void fAY();
  
  public final void fAy()
  {
    ac localac = new ac(this.iSn, this.Ior);
    localac.setProcessName("RemittanceProcess");
    doSceneProgress(localac);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.remittance_new_ui_mainland;
  }
  
  public void initView()
  {
    hideActionbarLine();
    label461:
    label478:
    Object localObject;
    if ((this.mPayScene == 33) || (this.mPayScene == 32))
    {
      setMMTitle(a.i.remittance_busi_pay);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(68223);
          if ((RemittanceNewBaseUI.this.mScene == 1) || (RemittanceNewBaseUI.this.mScene == 6))
          {
            RemittanceNewBaseUI.this.fAy();
            RemittanceNewBaseUI.this.finish();
          }
          for (;;)
          {
            AppMethodBeat.o(68223);
            return true;
            if ((RemittanceNewBaseUI.this.mScene == 2) || (RemittanceNewBaseUI.this.mScene == 5)) {
              RemittanceNewBaseUI.this.finish();
            } else {
              RemittanceNewBaseUI.this.fAH();
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
      this.IoD = ((LinearLayout)findViewById(a.f.remittance_address_container));
      this.IoE = ((TextView)findViewById(a.f.name_telephone_tv));
      this.IoF = ((TextView)findViewById(a.f.address_detail_tv));
      this.IuD = ((TextView)findViewById(a.f.remittance_title_tips));
      this.Iuy = ((LinearLayout)findViewById(a.f.remittance_new_warning_layout));
      this.Iuz = ((LinearLayout)this.Iuy.findViewById(a.f.remittance_warning_click_ll));
      this.IuA = ((TextView)this.Iuy.findViewById(a.f.remittance_warning_tips));
      this.IuB = ((CdnImageView)this.Iuy.findViewById(a.f.remittance_warning_left_logo));
      this.IuC = ((CdnImageView)this.Iuy.findViewById(a.f.remittance_warning_right_logo));
      this.IuD = ((TextView)findViewById(a.f.remittance_title_tips));
      fAE();
      this.tZh = ((WalletFormView)findViewById(a.f.money_ev));
      if (this.mPayScene != 33) {
        break label920;
      }
      this.Ioz.setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(this.mMC));
      this.IoA.setText(ah.ijb());
      this.IoJ = getIntent().getStringExtra("desc");
      if (Util.isNullOrNil(this.IoJ)) {
        break label908;
      }
      this.Ioy.setText(l.b(getContext(), this.IoJ, this.Ioy.getTextSize()));
      this.Ioy.setVisibility(0);
      this.IoB.setVisibility(0);
      this.IoC.setVisibility(8);
      localObject = (ImageView)findViewById(a.f.wallet_max_uni_heave_line_iv);
      if (!ar.isDarkMode()) {
        break label1105;
      }
      findViewById(a.f.wallet_max_unit_line_iv).setVisibility(8);
      findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line_dark);
      label525:
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68235);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (RemittanceNewBaseUI.this.mPayScene == 33)
          {
            paramAnonymousView = RemittanceNewBaseUI.this;
            localObject = RemittanceNewBaseUI.this.mDesc;
            RemittanceNewBaseUI.b(RemittanceNewBaseUI.this);
            paramAnonymousView.a((String)localObject, RemittanceNewBaseUI.this.IoH, RemittanceNewBaseUI.this.IoJ, "", null);
            if (RemittanceNewBaseUI.c(RemittanceNewBaseUI.this) == 0.0D)
            {
              if (RemittanceNewBaseUI.this.mScene != 1) {
                break label327;
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceNewBaseUI.this.mScene == 1) && (!Util.isNullOrNil(RemittanceNewBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.h.IzE.a(14074, new Object[] { Integer.valueOf(2) });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68235);
            return;
            RemittanceNewBaseUI.this.mMC = Util.getDouble(RemittanceNewBaseUI.this.tZh.getText(), 0.0D);
            if (!RemittanceNewBaseUI.this.tZh.bAz())
            {
              w.makeText(RemittanceNewBaseUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
              break;
            }
            if (RemittanceNewBaseUI.this.mMC < 0.01D)
            {
              RemittanceNewBaseUI.this.fAA();
              break;
            }
            RemittanceNewBaseUI.this.hideWcKb();
            paramAnonymousView = RemittanceNewBaseUI.this;
            localObject = RemittanceNewBaseUI.this.mDesc;
            RemittanceNewBaseUI.b(RemittanceNewBaseUI.this);
            paramAnonymousView.a((String)localObject, RemittanceNewBaseUI.this.IoH, null, "", null);
            break;
            label327:
            com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      };
      this.tZh.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(68241);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            Log.i("MicroMsg.RemittanceNewBaseUI", "click enter");
            this.mMW.onClick(null);
            AppMethodBeat.o(68241);
            return true;
          }
          AppMethodBeat.o(68241);
          return true;
        }
      });
      this.tZh.setmContentAbnormalMoneyCheck(true);
      this.Iow = ((TextView)findViewById(a.f.remittance_desc));
      this.Iox = ((TextView)findViewById(a.f.add_remittance_desc));
      com.tencent.mm.wallet_core.ui.g.bi(this.Iow, 50);
      com.tencent.mm.wallet_core.ui.g.bi(this.Iox, 50);
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label1138;
      }
      aWR(getString(a.i.remittance_add_f2f_desc_link));
      label635:
      if ((!z.bdq()) && (Util.isEqual(this.Iop, 0)))
      {
        this.mMz = ((RelativeLayout)findViewById(a.f.wallet_max_unit_container));
        if ((!LocaleUtil.getApplicationLanguage().equals("zh_CN")) && (!LocaleUtil.getApplicationLanguage().equals("zh_TW")) && (!LocaleUtil.getApplicationLanguage().equals("zh_HK"))) {
          break label1152;
        }
        this.mMx = ((RelativeLayout)findViewById(a.f.wallet_max_unit_layout));
        this.mMy = ((TextView)findViewById(a.f.wallet_max_unit_tv));
        this.mMx.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(275024);
            RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, RemittanceNewBaseUI.d(RemittanceNewBaseUI.this).getWidth());
            RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).setVisibility(8);
            Log.d("MicroMsg.RemittanceNewBaseUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceNewBaseUI.f(RemittanceNewBaseUI.this)) });
            AppMethodBeat.o(275024);
          }
        });
        this.tZh.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void f(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(196464);
            if (Util.isEqual(RemittanceNewBaseUI.this.Iko, 0))
            {
              Log.i("MicroMsg.RemittanceNewBaseUI", "mAmountRemindBit == 0");
              RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).setVisibility(8);
              AppMethodBeat.o(196464);
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
            if (i >= RemittanceNewBaseUI.this.Iko)
            {
              j = RemittanceNewBaseUI.this.tZh.k(paramAnonymousCharSequence, RemittanceNewBaseUI.f(RemittanceNewBaseUI.this), j);
              if (j != 0)
              {
                RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).setVisibility(0);
                paramAnonymousCharSequence = ag.bk(MMApplicationContext.getContext(), i);
                RemittanceNewBaseUI.g(RemittanceNewBaseUI.this).setText(paramAnonymousCharSequence);
                paramAnonymousCharSequence = (RelativeLayout.LayoutParams)RemittanceNewBaseUI.d(RemittanceNewBaseUI.this).getLayoutParams();
                paramAnonymousCharSequence.leftMargin = j;
                RemittanceNewBaseUI.d(RemittanceNewBaseUI.this).setLayoutParams(paramAnonymousCharSequence);
                AppMethodBeat.o(196464);
                return;
              }
              RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).setVisibility(8);
              AppMethodBeat.o(196464);
              return;
            }
            RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).setVisibility(8);
            AppMethodBeat.o(196464);
          }
        });
      }
    }
    for (;;)
    {
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
      this.IoG = ((LinearLayout)findViewById(a.f.remittance_main_ui));
      fAC();
      fAD();
      fAB();
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        break label1164;
      }
      return;
      setMMTitle("");
      break;
      label908:
      this.Ioy.setVisibility(8);
      break label461;
      label920:
      this.tZh.getTitleTv().setText(String.format(getString(a.i.remittance_fee_tips), new Object[] { "¥" }));
      this.tZh.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(68219);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!RemittanceNewBaseUI.this.tZh.bAz()) || (d < 0.01D))
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
      this.tZh.ijD();
      this.mMt = ((WcPayKeyboard)findViewById(a.f.wp_kb));
      gR(false);
      setWPKeyboard(this.tZh.getContentEt(), true, false);
      this.tZh.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68220);
          RemittanceNewBaseUI.this.tZh.getContentEt().requestFocus();
          AppMethodBeat.o(68220);
        }
      });
      setWcKbHeightListener(this);
      this.mMt.setActionText(getString(a.i.remittance_next_btn));
      ((RelativeLayout.LayoutParams)this.mMt.getLayoutParams()).addRule(12);
      findViewById(a.f.placeholder);
      findViewById(a.f.remittance_main_ui).setVisibility(0);
      this.IoB.setVisibility(8);
      this.IoC.setVisibility(0);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean) {}
      });
      break label478;
      label1105:
      findViewById(a.f.wallet_max_unit_line_iv).setVisibility(0);
      findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(8);
      ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line);
      break label525;
      label1138:
      aWR(getString(a.i.remittance_add_desc_link));
      break label635;
      label1152:
      this.mMz.setVisibility(8);
    }
    label1164:
    this.mMs.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(270977);
        if ((RemittanceNewBaseUI.h(RemittanceNewBaseUI.this).isShown()) && (RemittanceNewBaseUI.i(RemittanceNewBaseUI.this).iir()))
        {
          RemittanceNewBaseUI.j(RemittanceNewBaseUI.this).iip();
          AppMethodBeat.o(270977);
          return true;
        }
        AppMethodBeat.o(270977);
        return false;
      }
    });
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    if (this.mKindaEnable) {
      return (!this.Iru) && (this.mMt.iit());
    }
    return this.mMt.iit();
  }
  
  public boolean needLockPage()
  {
    return (this.mPayScene == 33) || (this.mPayScene == 32);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Log.i("MicroMsg.RemittanceNewBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.iSn);
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
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("Select_Conv_User");
        if (!Util.isNullOrNil(str))
        {
          this.iSn = str;
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
    if ((this instanceof RemittanceUI)) {
      this.Iop = 0;
    }
    super.onCreate(paramBundle);
    this.Iol = com.tencent.mm.plugin.wallet.a.be(getIntent());
    this.Ior = getIntent().getStringExtra("scan_remittance_id");
    this.mMC = getIntent().getDoubleExtra("fee", 0.0D);
    this.iSn = getIntent().getStringExtra("receiver_name");
    this.tMB = getIntent().getStringExtra("receiver_nick_name");
    this.IoL = getIntent().getStringExtra("receiver_true_name");
    this.Iom = getIntent().getStringExtra("mch_name");
    this.Ioo = getIntent().getStringExtra("mch_info");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.IoQ = Util.nullAs(getIntent().getStringExtra("rcvr_open_id"), "");
    this.auA = getIntent().getStringExtra("key_group_name");
    Log.i("MicroMsg.RemittanceNewBaseUI", "mUserName %s", new Object[] { this.iSn });
    com.tencent.mm.kernel.h.aHH();
    long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().b(147457, Long.valueOf(0L))).longValue();
    if ((0x10 & l) != 0L) {
      this.IoP = 1;
    }
    for (;;)
    {
      fAY();
      com.tencent.mm.am.q.bhz().a(this);
      initView();
      this.Ipk.alive();
      com.tencent.mm.wallet_core.b.iie();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.vCG, true);
      this.state = 1;
      return;
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
    Log.i("MicroMsg.RemittanceNewBaseUI", "onDestroy()");
    MMHandlerThread.removeRunnable(this.mMK);
    EventCenter.instance.removeListener(this.IoZ);
    com.tencent.mm.am.q.bhz().b(this);
    this.Ipk.dead();
    this.Ipf.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.bgE(this.fLj);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    Log.i("MicroMsg.RemittanceNewBaseUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.mMt != null) && (this.mMt.onKeyUp(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    Log.i("MicroMsg.RemittanceNewBaseUI", "onPause()");
    if (!this.mMt.iis()) {
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
            break label331;
          }
          paramString = "";
          label158:
          this.IoR = paramString;
          if (a(paramq)) {
            break label365;
          }
          a(paramq.fHb, this.iSn, this.IoL, paramq);
          label191:
          paramString = new a(paramq.Imw, paramq.tUC, paramq.tXa, paramq.Imx, paramq.amount, paramq.fJG, paramq.fww, paramq.ImB, Util.getLong(paramq.Imz, 0L));
          this.IoT.put(paramq.fHb, paramString);
          if ((paramq.Ilo <= 0L) || (paramq.Ilo > 1800L)) {
            break label379;
          }
          this.Ilo = paramq.Ilo;
          this.Imh = paramq.Imh;
          this.Iux = Util.getLong(paramq.Imz, 0L);
        }
      }
      for (;;)
      {
        return true;
        this.IoU = paramq.fJG;
        break;
        label331:
        if (Util.isNullOrNil(paramq.ImL.IoR))
        {
          paramString = this.IoR;
          break label158;
        }
        paramString = paramq.ImL.IoR;
        break label158;
        label365:
        if (!this.mKindaEnable) {
          break label191;
        }
        hideLoading();
        break label191;
        label379:
        this.Ilo = 0L;
        this.Imh = "";
        this.Iux = 0L;
        continue;
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
      Log.i("MicroMsg.RemittanceNewBaseUI", "net error, use hardcode wording");
      this.mWcKeyboard.gxi();
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
      EventCenter.instance.addListener(this.IoZ);
      af.B(this.mPayScene, "", paramInt2);
    } while (!c((ae)paramq));
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    Log.i("MicroMsg.RemittanceNewBaseUI", "onWindowFocusChanged");
    if ((this.tZx != null) && (!this.tZx.isShowing()))
    {
      this.tZx.bYF();
      this.tZx = null;
      if (this.mMK != null) {
        MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
      }
    }
    super.onWindowFocusChanged(paramBoolean);
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
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
 * JD-Core Version:    0.7.0.1
 */