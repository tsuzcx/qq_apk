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
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acw;
import com.tencent.mm.autogen.a.hd;
import com.tencent.mm.autogen.a.hd.a;
import com.tencent.mm.autogen.a.hf;
import com.tencent.mm.autogen.a.hf.a;
import com.tencent.mm.autogen.mmdata.rpt.rl;
import com.tencent.mm.autogen.mmdata.rpt.rs;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.model.ad;
import com.tencent.mm.plugin.remittance.model.af;
import com.tencent.mm.plugin.remittance.model.af.a;
import com.tencent.mm.plugin.remittance.model.al;
import com.tencent.mm.plugin.remittance.model.am;
import com.tencent.mm.plugin.remittance.model.an;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.gen;
import com.tencent.mm.protocal.protobuf.gep;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.model.ag;
import com.tencent.mm.wallet_core.model.ah;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public abstract class RemittanceNewBaseUI
  extends WalletBaseUI
  implements AvatarStorage.a, WcPayKeyboard.a
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 270);
  private RemittanceRemarkInputHalfPage OeL;
  TextView Oew;
  CdnImageView Oex;
  CdnImageView Oey;
  protected int Ohb = 4;
  private long Oif;
  private double OjJ;
  private String Ojy;
  protected com.tencent.mm.plugin.wallet.a OlE = null;
  protected String OlF;
  protected String OlH;
  private int OlI = -1;
  protected boolean OlJ = false;
  protected String OlK;
  protected ImageView OlL;
  protected TextView OlM;
  protected TextView OlN;
  protected TextView OlP;
  protected TextView OlQ;
  private TextView OlR;
  private TextView OlS;
  protected TextView OlT;
  private LinearLayout OlU;
  private LinearLayout OlV;
  private LinearLayout OlW;
  private TextView OlX;
  private TextView OlY;
  LinearLayout OlZ;
  protected String OmA = "";
  protected String OmB = "";
  protected String OmC = "";
  private IListener<hf> OmD = new IListener(com.tencent.mm.app.f.hfK)
  {
    private boolean a(hf paramAnonymoushf)
    {
      int j = 1;
      AppMethodBeat.i(289113);
      String str = paramAnonymoushf.hHZ.hAT;
      if (paramAnonymoushf.hHZ.isKinda)
      {
        Log.f("MicroMsg.RemittanceNewBaseUI", "F2fPayCheckEvent is from kinda");
        RemittanceNewBaseUI.this.Opb = false;
        MMHandlerThread.postToMainThreadDelayed(RemittanceNewBaseUI.q(RemittanceNewBaseUI.this), 300L);
        if (paramAnonymoushf.hHZ.hAV == 1)
        {
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, str, paramAnonymoushf.hHZ.hAU);
          if (paramAnonymoushf.hHZ.hIa == RemittanceNewBaseUI.this.getContext().hashCode()) {
            if (!Util.isNullOrNil(RemittanceNewBaseUI.this.ciX))
            {
              com.tencent.mm.plugin.remittance.app.c.gLv().gLy().aO(RemittanceNewBaseUI.r(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.ciX, RemittanceNewBaseUI.this.luk);
              if (RemittanceNewBaseUI.s(RemittanceNewBaseUI.this) > 0L)
              {
                if (Util.isNullOrNil(RemittanceNewBaseUI.this.ciX)) {
                  break label288;
                }
                com.tencent.mm.plugin.remittance.model.g.Oie.a(RemittanceNewBaseUI.this.ciX, RemittanceNewBaseUI.s(RemittanceNewBaseUI.this), RemittanceNewBaseUI.t(RemittanceNewBaseUI.this), RemittanceNewBaseUI.r(RemittanceNewBaseUI.this), RemittanceNewBaseUI.u(RemittanceNewBaseUI.this));
              }
            }
          }
        }
        label288:
        while (paramAnonymoushf.hHZ.hAV != 2) {
          for (;;)
          {
            AppMethodBeat.o(289113);
            return false;
            com.tencent.mm.plugin.remittance.app.c.gLv().gLy().lz(RemittanceNewBaseUI.r(RemittanceNewBaseUI.this), RemittanceNewBaseUI.this.luk);
            continue;
            Log.w("MicroMsg.RemittanceNewBaseUI", "callback to wrong page: %s, %s", new Object[] { Integer.valueOf(paramAnonymoushf.hHZ.hIa), Integer.valueOf(RemittanceNewBaseUI.this.getContext().hashCode()) });
            continue;
            com.tencent.mm.plugin.remittance.model.g.Oie.a(RemittanceNewBaseUI.this.luk, RemittanceNewBaseUI.s(RemittanceNewBaseUI.this), RemittanceNewBaseUI.t(RemittanceNewBaseUI.this), RemittanceNewBaseUI.r(RemittanceNewBaseUI.this), RemittanceNewBaseUI.u(RemittanceNewBaseUI.this));
          }
        }
        i = j;
        if (RemittanceNewBaseUI.this.mScene != 2) {
          if (RemittanceNewBaseUI.this.mScene != 5) {
            break label462;
          }
        }
      }
      label462:
      for (int i = j;; i = 0)
      {
        if ((!Util.isNullOrNil(RemittanceNewBaseUI.this.luk)) && (i == 0))
        {
          paramAnonymoushf = new Intent();
          paramAnonymoushf.putExtra("Chat_User", RemittanceNewBaseUI.this.luk);
          paramAnonymoushf.putExtra("finish_direct", false);
          com.tencent.mm.br.c.g(RemittanceNewBaseUI.this, ".ui.chatting.ChattingUI", paramAnonymoushf);
          break;
        }
        RemittanceNewBaseUI.this.finish();
        break;
        RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, str, paramAnonymoushf.hHZ.hAU);
        AppMethodBeat.o(289113);
        return false;
      }
    }
  };
  protected String Oma = "";
  protected boolean Omb = true;
  protected String Omc;
  private String Omd;
  protected String Ome;
  protected String Omf = null;
  protected String Omg = null;
  protected int Omh;
  private int Omi;
  protected String Omj;
  protected String Omk;
  protected String Oml;
  private Map<String, a> Omm = new HashMap();
  private String Omn;
  protected boolean Omo = false;
  private af Omp;
  private rl Omq;
  private boolean Omr = false;
  private IListener Oms = new IListener(com.tencent.mm.app.f.hfK) {};
  private boolean Omt = false;
  private boolean Omu = false;
  private boolean Omv = false;
  private boolean Omw = false;
  private abe Omx = null;
  private IListener Omy = new IListener(com.tencent.mm.app.f.hfK) {};
  protected double Omz = 0.0D;
  protected boolean Opb = false;
  protected String Osd = "";
  private long Ose;
  LinearLayout Osf;
  LinearLayout Osg;
  TextView Osh;
  protected String ciX;
  private String hQR;
  protected int hXQ = 0;
  protected String luk;
  private int mChannel;
  protected String mDesc = "";
  protected int mPayScene;
  protected int mScene;
  private int pIZ;
  protected ScrollView pJa;
  private WcPayKeyboard pJb;
  private RelativeLayout pJf;
  private TextView pJg;
  private RelativeLayout pJh;
  protected double pJk;
  private Runnable pJs = new Runnable()
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
  private int state = 0;
  protected String wPR;
  private com.tencent.mm.ui.widget.a.j xcO;
  protected WalletFormView xcz;
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, j.a parama1, j.a parama2)
  {
    if (this.xcO != null)
    {
      this.xcO.cyW();
      this.xcO = null;
    }
    this.xcO = new com.tencent.mm.ui.widget.a.j(paramContext, 1, 3);
    this.xcO.d(paramString4, paramString3);
    this.xcO.a(parama2, parama1);
    paramString3 = View.inflate(paramContext, a.g.remittance_new_ui_half_dialog_title_view, null);
    paramString4 = (TextView)paramString3.findViewById(a.f.half_dialog_title);
    aw.a(paramString4.getPaint(), 0.8F);
    paramString4.setText(paramString2);
    ((WeImageView)paramString3.findViewById(a.f.half_dialog_close_iv)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68230);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (RemittanceNewBaseUI.m(RemittanceNewBaseUI.this) != null) {
          RemittanceNewBaseUI.m(RemittanceNewBaseUI.this).cyW();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68230);
      }
    });
    this.xcO.setHeaderView(paramString3);
    paramContext = View.inflate(paramContext, a.g.remittance_new_ui_half_dialog_content_view, null);
    paramString2 = (TextView)paramContext.findViewById(a.f.half_dialog_content);
    aw.a(paramString2.getPaint(), 0.8F);
    paramString2.setText(paramString1);
    this.xcO.setCustomView(paramContext);
    this.xcO.dDn();
  }
  
  private void a(af paramaf, abe paramabe)
  {
    this.Omr = true;
    new d(this).a(paramaf, paramabe, new d.a()
    {
      public final void aTT(String paramAnonymousString)
      {
        AppMethodBeat.i(288950);
        Log.i("MicroMsg.RemittanceNewBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceNewBaseUI.this.Oml = paramAnonymousString;
        RemittanceNewBaseUI.this.gMA();
        AppMethodBeat.o(288950);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(288953);
        RemittanceNewBaseUI.this.Oml = "";
        RemittanceNewBaseUI.this.hideLoading();
        RemittanceNewBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(288953);
      }
    });
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean)
    {
      if (this.Omo) {
        com.tencent.mm.plugin.report.service.h.OAn.b(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
      String str = paramIntent.getStringExtra("key_trans_id");
      if (Util.isNullOrNil(this.Omn)) {
        this.Omn = str;
      }
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        an.aTZ(this.luk);
      }
      if (this.OjJ == 0.0D)
      {
        if (this.mScene == 1) {
          com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(17), Integer.valueOf(1) });
        }
      }
      else {
        finish();
      }
    }
    for (;;)
    {
      if (Util.isEqual(this.OlI, 0)) {
        b(paramBoolean, paramIntent);
      }
      do
      {
        return;
        com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
        break;
        if (ah.cq(paramIntent))
        {
          finish();
          return;
        }
      } while (ah.cr(paramIntent));
      if (this.mScene == 1) {
        com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(16), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
    }
  }
  
  private boolean a(af paramaf)
  {
    if (!this.Omt) {}
    for (boolean bool2 = d(paramaf);; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.Omu) {
          bool1 = e(paramaf);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!this.Omv) {
          bool2 = f(paramaf);
        }
      }
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.Omw) {
          bool1 = c(paramaf);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!Util.isNullOrNil(paramaf.OjP))
        {
          bool2 = bool1;
          if (!Util.isNullOrNil(paramaf.OjQ))
          {
            String str2 = i.jo(i.getDisplayName(this.luk), 10);
            String str1 = str2;
            if (!Util.isNullOrNil(this.Ome)) {
              str1 = getString(a.i.remittance_collect_block, new Object[] { str2, this.Ome });
            }
            bool2 = a(paramaf.hMy, paramaf.OjQ, str1, paramaf.OjP, paramaf);
          }
        }
      }
      return bool2;
    }
  }
  
  private boolean a(final String paramString1, String paramString2, String paramString3, String paramString4, final af paramaf)
  {
    View localView = LayoutInflater.from(this).inflate(a.g.remittance_second_alert_ui, null);
    TextView localTextView1 = (TextView)localView.findViewById(a.f.rsau_title);
    TextView localTextView2 = (TextView)localView.findViewById(a.f.rsau_payee);
    TextView localTextView3 = (TextView)localView.findViewById(a.f.rsau_money);
    localTextView1.setText(paramString2);
    localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramString3, localTextView2.getTextSize()));
    double d = Util.getDouble(paramString4, 0.0D);
    localTextView3.setText(String.format("%s%.2f", new Object[] { ai.jOX(), Double.valueOf(Double.valueOf(d).doubleValue() / 100.0D) }));
    paramString2 = new e.a(this);
    paramString2.NC(false);
    paramString2.aEK(a.i.remittance_second_alert_title);
    paramString2.md(localView);
    paramString2.aER(a.i.remittance_continue);
    paramString2.aES(a.i.button_cancel);
    paramString2.d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(288939);
        com.tencent.mm.plugin.report.service.h.OAn.b(23749, new Object[] { Integer.valueOf(2) });
        RemittanceNewBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(288939);
      }
    });
    paramString2.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68239);
        com.tencent.mm.plugin.report.service.h.OAn.b(23749, new Object[] { Integer.valueOf(3) });
        RemittanceNewBaseUI.this.showLoading();
        RemittanceNewBaseUI.this.a(paramString1, RemittanceNewBaseUI.this.luk, RemittanceNewBaseUI.this.Ome, paramaf);
        AppMethodBeat.o(68239);
      }
    });
    paramString2.jHH().show();
    com.tencent.mm.plugin.report.service.h.OAn.b(23749, new Object[] { Integer.valueOf(1) });
    return true;
  }
  
  private static void aUc(String paramString)
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
    com.tencent.mm.plugin.remittance.app.c.gLv().gLy().lx(str, paramString);
  }
  
  private void aUh(String paramString)
  {
    i.a(this.OlQ, paramString, 0, paramString.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(288946);
        RemittanceNewBaseUI.i(RemittanceNewBaseUI.this);
        AppMethodBeat.o(288946);
      }
    }), getContext());
  }
  
  private void b(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      this.hXQ = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.RemittanceNewBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.hXQ), Double.valueOf(this.Omz), this.OmA, this.OmB, this.OmC });
      do
      {
        return;
      } while (paramIntent == null);
      this.hXQ = paramIntent.getIntExtra("key_pay_reslut_type", 3);
      this.Omz = this.pJk;
      this.OmA = this.mDesc;
      this.OmB = this.Oma;
      this.OmC = this.Omn;
    }
  }
  
  private static boolean b(af paramaf)
  {
    return ((paramaf.Oka == 1) && (paramaf.Okb != null)) || ((paramaf.Okb != null) && (paramaf.Okb.ZjH > 0));
  }
  
  private boolean c(final af paramaf)
  {
    if ((paramaf.iaV != null) && (paramaf.iaV.ihT()))
    {
      this.Omw = true;
      com.tencent.mm.ui.base.k.b(this, paramaf.iaV.wording, "", paramaf.iaV.right_button_wording, paramaf.iaV.rGU, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68222);
          Log.i("MicroMsg.RemittanceNewBaseUI", "goto h5: %s", new Object[] { paramaf.iaV.wYO });
          i.p(RemittanceNewBaseUI.this.getContext(), paramaf.iaV.wYO, false);
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
  
  private void cG(int paramInt, String paramString)
  {
    this.Omq = new rl();
    this.Omq.iqr = 2L;
    this.Omq.ikE = paramInt;
    this.Omq.yp(paramString);
    this.Omq.bMH();
  }
  
  private boolean d(final af paramaf)
  {
    if (!Util.isNullOrNil(paramaf.OjD))
    {
      this.Omt = true;
      cG(1, paramaf.hPj);
      com.tencent.mm.ui.base.k.b(this, paramaf.OjD, "", getString(a.i.remittance_continue), getString(a.i.remittance_dialog_cancel_remittance), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68224);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 3, paramaf.hPj);
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramaf))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramaf.hMy, RemittanceNewBaseUI.this.luk, RemittanceNewBaseUI.this.Ome, paramaf);
          }
          AppMethodBeat.o(68224);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68225);
          RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, 2, paramaf.hPj);
          if ((RemittanceNewBaseUI.this.mScene == 1) || (RemittanceNewBaseUI.this.mScene == 6))
          {
            RemittanceNewBaseUI.this.gMs();
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
          RemittanceNewBaseUI.this.gMB();
          AppMethodBeat.o(68225);
        }
      });
      return true;
    }
    return false;
  }
  
  private boolean e(final af paramaf)
  {
    boolean bool = false;
    String str1;
    String str2;
    if (paramaf.OjB > 0)
    {
      this.Omu = true;
      if (paramaf.OjC == null) {
        break label153;
      }
      if (!Util.isNullOrNil(paramaf.OjC.wording)) {
        break label130;
      }
      str1 = getString(a.i.remittance_remind_desc, new Object[] { Integer.valueOf(paramaf.OjB) });
      String str3 = getString(a.i.remittance_second_alert_title);
      String str4 = getString(a.i.remittance_continue);
      if (!Util.isNullOrNil(paramaf.OjC.Okc)) {
        break label141;
      }
      str2 = getString(a.i.remittance_open_order_history_action);
      label96:
      a(this, str1, str3, str4, str2, new j.a()new j.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(288921);
          if (RemittanceNewBaseUI.m(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.m(RemittanceNewBaseUI.this).cyW();
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this);
          }
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramaf))
          {
            if (RemittanceNewBaseUI.o(RemittanceNewBaseUI.this)) {
              RemittanceNewBaseUI.this.showLoading();
            }
            RemittanceNewBaseUI.this.a(paramaf.hMy, RemittanceNewBaseUI.this.luk, RemittanceNewBaseUI.this.Ome, paramaf);
          }
          AppMethodBeat.o(288921);
        }
      }, new j.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(288965);
          if (RemittanceNewBaseUI.m(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.m(RemittanceNewBaseUI.this).cyW();
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this);
          }
          if (Util.isNullOrNil(paramaf.OjC.Okd))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(288965);
            return;
          }
          com.tencent.mm.plugin.account.sdk.c.a.b(RemittanceNewBaseUI.this, paramaf.OjC.Okd, 5, true);
          AppMethodBeat.o(288965);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label130:
      str1 = paramaf.OjC.wording;
      break;
      label141:
      str2 = paramaf.OjC.Okc;
      break label96;
      label153:
      Log.i("MicroMsg.RemittanceNewBaseUI", "scene.zaituMessage == null");
      a(this, getString(a.i.remittance_remind_desc, new Object[] { Integer.valueOf(paramaf.OjB) }), getString(a.i.remittance_second_alert_title), getString(a.i.remittance_continue), getString(a.i.remittance_open_order_history_action), new j.a()new j.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(288967);
          if (RemittanceNewBaseUI.m(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.m(RemittanceNewBaseUI.this).cyW();
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this);
          }
          if (!RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, paramaf))
          {
            RemittanceNewBaseUI.this.showLoading();
            RemittanceNewBaseUI.this.a(paramaf.hMy, RemittanceNewBaseUI.this.luk, RemittanceNewBaseUI.this.Ome, paramaf);
          }
          AppMethodBeat.o(288967);
        }
      }, new j.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(288970);
          if (RemittanceNewBaseUI.m(RemittanceNewBaseUI.this) != null)
          {
            RemittanceNewBaseUI.m(RemittanceNewBaseUI.this).cyW();
            RemittanceNewBaseUI.n(RemittanceNewBaseUI.this);
          }
          com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
          AppMethodBeat.o(288970);
        }
      });
    }
  }
  
  private boolean f(final af paramaf)
  {
    if (paramaf.OjI)
    {
      this.Omv = true;
      g.a(this, this.mScene, paramaf.OjL / 100.0D, paramaf.OjK / 100.0D, paramaf.OjF / 100.0D, paramaf.OjH, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(288951);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          RemittanceNewBaseUI.this.showLoading();
          RemittanceNewBaseUI.this.a(paramaf.hMy, RemittanceNewBaseUI.this.luk, RemittanceNewBaseUI.this.Ome, paramaf);
          if (RemittanceNewBaseUI.this.mScene == 1) {
            com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(288951);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          }
        }
      });
      return true;
    }
    return false;
  }
  
  private void gMX()
  {
    this.pJb.Oi(true);
  }
  
  private void gMv()
  {
    if ((gMz()) && (!Util.isNullOrNil(this.Omg)) && (this.Omi != 0) && (this.Omh == 1))
    {
      addIconOptionMenu(0, a.e.wallet_qanda_icon, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(289179);
          i.p(RemittanceNewBaseUI.this.getContext(), RemittanceNewBaseUI.this.Omg, false);
          AppMethodBeat.o(289179);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void gMw()
  {
    int i;
    if ((!Util.isNullOrNil(this.Omf)) && (this.Omi != 0))
    {
      if (this.Omi == 1) {}
      for (i = 2;; i = 24) {
        try
        {
          this.pJb.setTipText(String.format(this.Omf, new Object[] { Integer.valueOf(i) }));
          return;
        }
        catch (Exception localException)
        {
          Log.i("MicroMsg.RemittanceNewBaseUI", "updatePlaceHolderTv() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          this.pJb.setTipText(getString(a.i.remittance_hardcode_tips, new Object[] { Integer.valueOf(i) }));
          return;
        }
      }
    }
    this.pJb.hVf();
  }
  
  private void gzL()
  {
    final Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(68217);
        a.b.a(RemittanceNewBaseUI.this.OlL, RemittanceNewBaseUI.this.luk, 0.1F, false);
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
  
  public final void LM(String paramString)
  {
    Log.i("MicroMsg.RemittanceNewBaseUI", "onGet");
    if (Util.nullAsNil(paramString).length() <= 0) {
      Log.e("MicroMsg.RemittanceNewBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.luk)) {
      return;
    }
    gzL();
  }
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final af paramaf)
  {
    if (b(paramaf))
    {
      if (paramaf.Okb.ZjH == 0)
      {
        this.Omx = paramaf.Okb;
        a(paramaf, paramaf.Okb);
      }
      do
      {
        return;
        if (paramaf.Okb.ZjH == 1)
        {
          localObject1 = new rs();
          ((rs)localObject1).jwc = ((int)paramaf.OjO);
          localObject1 = ((rs)localObject1).yr(paramaf.username);
          ((rs)localObject1).jvV = 4L;
          ((rs)localObject1).bMH();
          com.tencent.mm.ui.base.k.a(this, paramaf.Okb.wording, paramaf.Okb.title, getResources().getString(a.i.remittance_warn_re_name_continue), getResources().getString(a.i.remittance_warn_re_name_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(288948);
              Log.i("MicroMsg.RemittanceNewBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceNewBaseUI.p(RemittanceNewBaseUI.this) });
              paramAnonymousDialogInterface = new rs();
              paramAnonymousDialogInterface.jwc = ((int)paramaf.OjO);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.yr(paramaf.username);
              paramAnonymousDialogInterface.jvV = 9L;
              paramAnonymousDialogInterface.bMH();
              paramaf.Okb = null;
              RemittanceNewBaseUI.this.a(paramString1, paramString2, paramString3, paramaf);
              AppMethodBeat.o(288948);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(68236);
              Log.i("MicroMsg.RemittanceNewBaseUI", "onClick1");
              paramAnonymousDialogInterface = new rs();
              paramAnonymousDialogInterface.jwc = ((int)paramaf.OjO);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.yr(paramaf.username);
              paramAnonymousDialogInterface.jvV = 8L;
              paramAnonymousDialogInterface.bMH();
              RemittanceNewBaseUI.this.hideLoading();
              AppMethodBeat.o(68236);
            }
          }, a.c.real_name_goon_remittance);
          return;
        }
      } while (paramaf.Okb.ZjH != 2);
      com.tencent.mm.ui.base.k.a(this, paramaf.Okb.wording, paramaf.Okb.title, getResources().getString(a.i.welcome_i_know), new DialogInterface.OnClickListener()
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
    if (this.Omr)
    {
      localObject1 = new rs();
      ((rs)localObject1).jwc = paramaf.amount;
      localObject1 = ((rs)localObject1).yr(paramaf.username);
      ((rs)localObject1).jvV = 5L;
      ((rs)localObject1).bMH();
    }
    this.Omr = false;
    if (this.mPayScene == 31) {
      aUc(this.Omd);
    }
    Object localObject1 = new PayInfo();
    ((PayInfo)localObject1).hAT = paramString1;
    ((PayInfo)localObject1).hUR = this.mPayScene;
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
    paramString1.putString("extinfo_key_3", this.Omc);
    paramString1.putBoolean("extinfo_key_4", bool);
    paramString1.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
    paramString1.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
    paramString1.putString("extinfo_key_7", this.mDesc);
    paramString1.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
    paramString1.putString("extinfo_key_16", this.Omn);
    if (paramaf != null) {
      paramString1.putString("extinfo_key_19", paramaf.OjY);
    }
    int j = 0;
    int i = j;
    if (this.mScene == 1)
    {
      i = j;
      if (paramaf != null)
      {
        paramString1.putString("extinfo_key_11", paramaf.OjM);
        paramString1.putInt("extinfo_key_12", paramaf.OjS);
        paramString1.putString("extinfo_key_13", paramaf.OjT);
        paramString1.putString("extinfo_key_14", paramaf.OjU);
        paramString1.putString("extinfo_key_17", paramaf.OjW);
        paramString1.putString("extinfo_key_18", paramaf.OjX);
        i = paramaf.OjV;
      }
    }
    if (paramaf != null) {
      paramString1.putInt("extinfo_key_15", paramaf.amount);
    }
    ((PayInfo)localObject1).nKf = paramString1;
    paramString1 = new Intent();
    Log.i("MicroMsg.RemittanceNewBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      paramString1.setClass(this, RemittanceF2fDynamicCodeUI.class);
      paramString1.putExtra("key_pay_info", (Parcelable)localObject1);
      paramString1.putExtra("key_rcvr_open_id", this.Omj);
      paramString1.putExtra("key_mch_info", this.OlH);
      paramString1.putExtra("from_patch_ui", true);
      paramString1.putExtra("get_dynamic_code_sign", paramaf.OjW);
      paramString1.putExtra("get_dynamic_code_extend", paramaf.OjX);
      paramString1.putExtra("dynamic_code_spam_wording", paramaf.OjZ);
      paramString1.putExtra("show_paying_wording", paramaf.OjY);
      paramString1.putExtra("key_transfer_qrcode_id", this.OlK);
      com.tencent.mm.plugin.report.service.h.OAn.b(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      this.Omy.alive();
      startActivityForResult(paramString1, 5);
      return;
    }
    if (this.mKindaEnable)
    {
      paramaf = "";
      paramString3 = "";
      Object localObject2 = getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
      if (!Util.isNullOrNil(paramString2))
      {
        com.tencent.mm.kernel.h.baF();
        paramString1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxu(paramString2);
        if (paramString1 != null)
        {
          paramString3 = paramString1.aSV();
          paramaf = new StringBuilder().append(i.bEU(paramString3));
          if (Util.isNullOrNil(this.Ome))
          {
            paramString1 = "";
            paramString1 = paramString1;
            paramaf = Util.safeFormatString((String)localObject2, new Object[] { paramString1 });
            paramString3 = getString(a.i.remittance_result_receiver_desc, new Object[] { i.bEU(paramString3) });
          }
        }
      }
      for (;;)
      {
        if (((PayInfo)localObject1).nKf == null) {
          ((PayInfo)localObject1).nKf = new Bundle();
        }
        localObject2 = ((PayInfo)localObject1).nKf;
        ((Bundle)localObject2).putString("extinfo_key_1", paramString2);
        ((Bundle)localObject2).putString("extinfo_key_2", this.Ome);
        ((Bundle)localObject2).putString("cashier_desc", paramaf);
        ((Bundle)localObject2).putString("prepay_page_payee", paramString1);
        ((Bundle)localObject2).putString("succ_tip", paramString3);
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, (PayInfo)localObject1);
        this.Opb = true;
        return;
        paramString1 = "(" + this.Ome + ")";
        break;
        Log.e("MicroMsg.RemittanceNewBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        Log.e("MicroMsg.RemittanceNewBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.OlE, paramString1);
    ((PayInfo)localObject1).YvN = this.hQR;
    ((PayInfo)localObject1).cHU = this.Omo;
    if ((paramaf.OiC != null) && (paramaf.OiC.hHR.hHU != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramaf.OiC.hHR.hHU, false, "", (PayInfo)localObject1, paramString3, paramString1, paramaf.OiC.hHR.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, hd paramhd);
  
  public final void cY(float paramFloat) {}
  
  public abstract void eIA();
  
  protected final void gMA()
  {
    if (this.mPayScene == 33)
    {
      a(this.mDesc, this.Oma, this.Omc, "", null);
      return;
    }
    a(this.mDesc, this.Oma, null, "", null);
  }
  
  protected final void gMB()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("recent_remittance_contact_list", an.gMc());
    localIntent.setClass(getContext(), SelectRemittanceContactUI.class);
    startActivityForResult(localIntent, 2);
  }
  
  public final void gMs()
  {
    ad localad = new ad(this.luk, this.OlK);
    localad.setProcessName("RemittanceProcess");
    doSceneProgress(localad);
  }
  
  public abstract void gMu();
  
  public abstract void gMx();
  
  protected final void gMy()
  {
    Object localObject1 = i.jn(i.getDisplayName(this.luk), 10);
    Object localObject2 = localObject1;
    if (!Util.isNullOrNil(this.Ome)) {
      localObject2 = getString(a.i.remittance_collect_block, new Object[] { localObject1, this.Ome });
    }
    if (this.mScene == 1)
    {
      localObject2 = getIntent().getStringExtra("receiver_tips");
      this.OlM.setTextColor(getResources().getColor(a.c.normal_text_color));
      this.OlN.setVisibility(0);
      if (Util.isNullOrNil(this.luk))
      {
        localObject1 = getString(a.i.remittance_collect_pay_wrords_nick_tip_withdout_username, new Object[] { this.Ome });
        this.OlN.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject1, this.OlN.getTextSize()));
        localObject1 = localObject2;
        label152:
        i.Q(this.OlM);
        this.OlM.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject1, this.OlM.getTextSize()));
        if (!com.tencent.mm.kernel.h.baz()) {
          break label381;
        }
        localObject1 = com.tencent.mm.modelavatar.q.bFE();
        if ((localObject1 == null) || (Util.isNullOrNil(this.luk))) {
          break label381;
        }
        localObject1 = ((com.tencent.mm.modelavatar.k)localObject1).LS(this.luk);
        if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.modelavatar.j)localObject1).bFx()))) {
          break label381;
        }
        long l = Util.nowMilliSecond();
        az.a.okP.a(this.luk, "", new RemittanceNewBaseUI.3(this, l));
      }
    }
    label381:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        gzL();
      }
      return;
      localObject1 = getString(a.i.remittance_collect_pay_wrords_nick_tip, new Object[] { i.jo(i.getDisplayName(this.luk), 10), this.Ome });
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
  
  protected final boolean gMz()
  {
    return (this.mScene == 0) || (this.mScene == 2);
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
            RemittanceNewBaseUI.this.gMs();
            RemittanceNewBaseUI.this.finish();
          }
          for (;;)
          {
            AppMethodBeat.o(68223);
            return true;
            if ((RemittanceNewBaseUI.this.mScene == 2) || (RemittanceNewBaseUI.this.mScene == 5)) {
              RemittanceNewBaseUI.this.finish();
            } else {
              RemittanceNewBaseUI.this.gMB();
            }
          }
        }
      });
      this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
      this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
      this.pJa = ((ScrollView)findViewById(a.f.root_view));
      this.OlL = ((ImageView)findViewById(a.f.remittance_receiver_avatar));
      this.OlM = ((TextView)findViewById(a.f.remittance_receiver_display_name));
      this.OlN = ((TextView)findViewById(a.f.remittance_receiver_display_name_tip));
      this.OlN.setVisibility(8);
      this.OlV = ((LinearLayout)findViewById(a.f.remittance_edit_layout));
      this.OlU = ((LinearLayout)findViewById(a.f.remittance_ftf_desc_layout));
      this.OlS = ((TextView)findViewById(a.f.remittance_fixed_amount_fee));
      this.OlT = ((TextView)findViewById(a.f.remittance_fixed_amount_fee_currency));
      this.OlR = ((TextView)findViewById(a.f.remittance_fixed_amount_desc));
      this.OlW = ((LinearLayout)findViewById(a.f.remittance_address_container));
      this.OlX = ((TextView)findViewById(a.f.name_telephone_tv));
      this.OlY = ((TextView)findViewById(a.f.address_detail_tv));
      this.Osh = ((TextView)findViewById(a.f.remittance_title_tips));
      this.Osf = ((LinearLayout)findViewById(a.f.remittance_new_warning_layout));
      this.Osg = ((LinearLayout)this.Osf.findViewById(a.f.remittance_warning_click_ll));
      this.Oew = ((TextView)this.Osf.findViewById(a.f.remittance_warning_tips));
      this.Oex = ((CdnImageView)this.Osf.findViewById(a.f.remittance_warning_left_logo));
      this.Oey = ((CdnImageView)this.Osf.findViewById(a.f.remittance_warning_right_logo));
      this.Osh = ((TextView)findViewById(a.f.remittance_title_tips));
      gMy();
      this.xcz = ((WalletFormView)findViewById(a.f.money_ev));
      if (this.mPayScene != 33) {
        break label964;
      }
      this.OlS.setText(i.formatMoney2f(this.pJk));
      this.OlT.setText(ai.jOX());
      this.Omc = getIntent().getStringExtra("desc");
      if (Util.isNullOrNil(this.Omc)) {
        break label952;
      }
      this.OlR.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), this.Omc, this.OlR.getTextSize()));
      this.OlR.setVisibility(0);
      this.OlU.setVisibility(0);
      this.OlV.setVisibility(8);
      localObject = (ImageView)findViewById(a.f.wallet_max_uni_heave_line_iv);
      if (!aw.isDarkMode()) {
        break label1181;
      }
      findViewById(a.f.wallet_max_unit_line_iv).setVisibility(8);
      findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line_dark);
      label525:
      localObject = new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(288949);
          String str;
          if (RemittanceNewBaseUI.this.mPayScene == 33)
          {
            paramAnonymousView = RemittanceNewBaseUI.this;
            str = RemittanceNewBaseUI.this.mDesc;
            RemittanceNewBaseUI.b(RemittanceNewBaseUI.this);
            paramAnonymousView.a(str, RemittanceNewBaseUI.this.Oma, RemittanceNewBaseUI.this.Omc, "", null);
            if (RemittanceNewBaseUI.d(RemittanceNewBaseUI.this) == 0.0D)
            {
              if (RemittanceNewBaseUI.this.mScene != 1) {
                break label286;
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceNewBaseUI.this.mScene == 1) && (!Util.isNullOrNil(RemittanceNewBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.h.OAn.b(14074, new Object[] { Integer.valueOf(2) });
            }
            AppMethodBeat.o(288949);
            return;
            RemittanceNewBaseUI.this.pJk = Util.getDouble(RemittanceNewBaseUI.this.xcz.getText(), 0.0D);
            if (!RemittanceNewBaseUI.this.xcz.bZp())
            {
              RemittanceNewBaseUI.c(RemittanceNewBaseUI.this);
              break;
            }
            if (RemittanceNewBaseUI.this.pJk < 0.01D)
            {
              RemittanceNewBaseUI.this.gMu();
              break;
            }
            RemittanceNewBaseUI.this.hideWcKb();
            RemittanceNewBaseUI.this.xcz.clearFocus();
            paramAnonymousView = RemittanceNewBaseUI.this;
            str = RemittanceNewBaseUI.this.mDesc;
            RemittanceNewBaseUI.b(RemittanceNewBaseUI.this);
            paramAnonymousView.a(str, RemittanceNewBaseUI.this.Oma, null, "", null);
            break;
            label286:
            com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      };
      this.xcz.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(68241);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66))
          {
            Log.i("MicroMsg.RemittanceNewBaseUI", "click enter");
            this.pJE.onClick(null);
            AppMethodBeat.o(68241);
            return true;
          }
          AppMethodBeat.o(68241);
          return true;
        }
      });
      this.xcz.setmContentAbnormalMoneyCheck(true);
      this.xcz.getContentEt().setTextSize(1, 56.0F);
      this.xcz.getTitleTv().setTextSize(1, 56.0F);
      this.OlP = ((TextView)findViewById(a.f.remittance_desc));
      this.OlQ = ((TextView)findViewById(a.f.add_remittance_desc));
      this.OlP.setClickable(true);
      this.OlQ.setClickable(true);
      i.bG(this.OlP, 50);
      i.bG(this.OlQ, 50);
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label1214;
      }
      aUh(getString(a.i.remittance_add_f2f_desc_link));
      label679:
      if ((!z.bBi()) && (Util.isEqual(this.OlI, 0)))
      {
        this.pJh = ((RelativeLayout)findViewById(a.f.wallet_max_unit_container));
        if ((!LocaleUtil.getApplicationLanguage().equals("zh_CN")) && (!LocaleUtil.getApplicationLanguage().equals("zh_TW")) && (!LocaleUtil.getApplicationLanguage().equals("zh_HK"))) {
          break label1228;
        }
        this.pJf = ((RelativeLayout)findViewById(a.f.wallet_max_unit_layout));
        this.pJg = ((TextView)findViewById(a.f.wallet_max_unit_tv));
        this.pJf.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(289107);
            RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).getWidth());
            RemittanceNewBaseUI.f(RemittanceNewBaseUI.this).setVisibility(8);
            Log.d("MicroMsg.RemittanceNewBaseUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(RemittanceNewBaseUI.g(RemittanceNewBaseUI.this)) });
            AppMethodBeat.o(289107);
          }
        });
        this.xcz.setmWalletFormViewListener(new WalletFormView.c()
        {
          public final void f(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(289108);
            if (Util.isEqual(RemittanceNewBaseUI.this.Ohb, 0))
            {
              Log.i("MicroMsg.RemittanceNewBaseUI", "mAmountRemindBit == 0");
              RemittanceNewBaseUI.f(RemittanceNewBaseUI.this).setVisibility(8);
              AppMethodBeat.o(289108);
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
            if (i >= RemittanceNewBaseUI.this.Ohb)
            {
              j = RemittanceNewBaseUI.this.xcz.i(paramAnonymousCharSequence, RemittanceNewBaseUI.g(RemittanceNewBaseUI.this), j);
              if (j != 0)
              {
                RemittanceNewBaseUI.f(RemittanceNewBaseUI.this).setVisibility(0);
                paramAnonymousCharSequence = ah.bD(MMApplicationContext.getContext(), i);
                RemittanceNewBaseUI.h(RemittanceNewBaseUI.this).setText(paramAnonymousCharSequence);
                paramAnonymousCharSequence = (RelativeLayout.LayoutParams)RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).getLayoutParams();
                paramAnonymousCharSequence.leftMargin = j;
                RemittanceNewBaseUI.e(RemittanceNewBaseUI.this).setLayoutParams(paramAnonymousCharSequence);
                AppMethodBeat.o(289108);
                return;
              }
              RemittanceNewBaseUI.f(RemittanceNewBaseUI.this).setVisibility(8);
              AppMethodBeat.o(289108);
              return;
            }
            RemittanceNewBaseUI.f(RemittanceNewBaseUI.this).setVisibility(8);
            AppMethodBeat.o(289108);
          }
        });
      }
    }
    for (;;)
    {
      if (this.mScene == 1)
      {
        com.tencent.mm.kernel.h.baF();
        if (((String)com.tencent.mm.kernel.h.baE().ban().d(327732, "0")).equals("0"))
        {
          com.tencent.mm.ui.base.k.a(getContext(), a.i.remittance_first_ftf_pay_tips, a.i.remittance_first_ftf_pay_tips_title, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(327732, "1");
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().iZy();
        }
      }
      this.OlZ = ((LinearLayout)findViewById(a.f.remittance_main_ui));
      gMw();
      gMx();
      gMv();
      if ((this.mPayScene != 33) && (this.mPayScene != 32)) {
        break label1240;
      }
      return;
      setMMTitle("");
      break;
      label952:
      this.OlR.setVisibility(8);
      break label461;
      label964:
      this.xcz.getTitleTv().setText(String.format(getString(a.i.remittance_fee_tips), new Object[] { "¥" }));
      this.xcz.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(68219);
          RemittanceNewBaseUI.k(RemittanceNewBaseUI.this);
          AppMethodBeat.o(68219);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.xcz.jPD();
      this.pJb = ((WcPayKeyboard)findViewById(a.f.wp_kb));
      gMX();
      setWPKeyboard(this.xcz.getContentEt(), true, false);
      this.xcz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68220);
          RemittanceNewBaseUI.this.xcz.getContentEt().requestFocus();
          AppMethodBeat.o(68220);
        }
      });
      setWcKbHeightListener(this);
      this.pJb.setActionText(getString(a.i.remittance_next_btn));
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((al)com.tencent.mm.ui.component.k.d(getContext()).q(al.class)).setValue("keyboard_title_key", getString(a.i.remittance_next_btn));
      ((RelativeLayout.LayoutParams)this.pJb.getLayoutParams()).addRule(12);
      findViewById(a.f.placeholder);
      findViewById(a.f.remittance_main_ui).setVisibility(0);
      this.OlU.setVisibility(8);
      this.OlV.setVisibility(0);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean) {}
      });
      break label478;
      label1181:
      findViewById(a.f.wallet_max_unit_line_iv).setVisibility(0);
      findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(8);
      ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line);
      break label525;
      label1214:
      aUh(getString(a.i.remittance_add_desc_link));
      break label679;
      label1228:
      this.pJh.setVisibility(8);
    }
    label1240:
    this.pJa.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(289173);
        RemittanceNewBaseUI.this.handleKeyboardTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(289173);
        return false;
      }
    });
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    if (this.mKindaEnable) {
      return (!this.Opb) && (this.pJb.jOo());
    }
    return this.pJb.jOo();
  }
  
  public boolean needLockPage()
  {
    return (this.mPayScene == 33) || (this.mPayScene == 32);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Log.i("MicroMsg.RemittanceNewBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.luk);
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
          this.luk = str;
          gMy();
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
    if (!gMz())
    {
      this.hQR = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.bgj(this.hQR);
    }
    if ((this instanceof RemittanceUI)) {
      this.OlI = 0;
    }
    super.onCreate(paramBundle);
    this.OlE = com.tencent.mm.plugin.wallet.a.bE(getIntent());
    this.OlK = getIntent().getStringExtra("scan_remittance_id");
    this.pJk = getIntent().getDoubleExtra("fee", 0.0D);
    this.luk = getIntent().getStringExtra("receiver_name");
    this.wPR = getIntent().getStringExtra("receiver_nick_name");
    this.Ome = getIntent().getStringExtra("receiver_true_name");
    this.OlF = getIntent().getStringExtra("mch_name");
    this.OlH = getIntent().getStringExtra("mch_info");
    this.mChannel = getIntent().getIntExtra("pay_channel", 0);
    this.Omj = Util.nullAs(getIntent().getStringExtra("rcvr_open_id"), "");
    this.ciX = getIntent().getStringExtra("key_group_name");
    if ((!Util.isNullOrNil(this.ciX)) && (this.mChannel == 11)) {
      this.mChannel = 14;
    }
    Log.i("MicroMsg.RemittanceNewBaseUI", "mUserName %s", new Object[] { this.luk });
    com.tencent.mm.kernel.h.baF();
    long l = ((Long)com.tencent.mm.kernel.h.baE().ban().d(147457, Long.valueOf(0L))).longValue();
    if ((0x10 & l) != 0L) {
      this.Omi = 1;
    }
    for (;;)
    {
      eIA();
      com.tencent.mm.modelavatar.q.bFp().a(this);
      initView();
      this.OmD.alive();
      com.tencent.mm.wallet_core.b.jNX();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(c.a.yRc, true);
      this.state = 1;
      return;
      if ((l & 0x20) != 0L) {
        this.Omi = 2;
      } else {
        this.Omi = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("MicroMsg.RemittanceNewBaseUI", "onDestroy()");
    MMHandlerThread.removeRunnable(this.pJs);
    this.Oms.dead();
    com.tencent.mm.modelavatar.q.bFp().b(this);
    this.OmD.dead();
    this.Omy.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.bgk(this.hQR);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    Log.i("MicroMsg.RemittanceNewBaseUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.pJb != null) && (this.pJb.onKeyUp(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    Log.i("MicroMsg.RemittanceNewBaseUI", "onPause()");
    if (!this.pJb.jOn()) {
      this.state = 3;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Log.i("MicroMsg.RemittanceNewBaseUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb()))
    {
      showNormalStWcKb();
      this.xcz.requestFocus();
    }
    this.state = 2;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    this.Oml = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof af))
      {
        paramp = (af)paramp;
        ag.G(this.mPayScene, paramp.hMy, paramInt2);
        this.Omd = paramp.OjE;
        if (!Util.isNullOrNil(paramp.OiN)) {
          this.Ome = paramp.OiN;
        }
        if ((this.mPayScene == 32) || (this.mPayScene == 33))
        {
          this.Omn = paramp.wXY;
          if (this.OlE != null) {
            this.OlE.k(10000, new Object[] { Integer.valueOf(this.mPayScene), this.luk, Double.valueOf(paramp.OjO) });
          }
          if (paramp.Okb != null) {
            break label331;
          }
          paramString = "";
          label158:
          this.Omk = paramString;
          if (a(paramp)) {
            break label365;
          }
          a(paramp.hMy, this.luk, this.Ome, paramp);
          label191:
          paramString = new a(paramp.OjM, paramp.wXY, paramp.xas, paramp.OjN, paramp.amount, paramp.hPj, paramp.hAU, paramp.OjR, Util.getLong(paramp.OjP, 0L));
          this.Omm.put(paramp.hMy, paramString);
          if ((paramp.Oif <= 0L) || (paramp.Oif > 1800L)) {
            break label379;
          }
          this.Oif = paramp.Oif;
          this.Ojy = paramp.Ojy;
          this.Ose = Util.getLong(paramp.OjP, 0L);
        }
      }
      for (;;)
      {
        return true;
        this.Omn = paramp.hPj;
        break;
        label331:
        if (Util.isNullOrNil(paramp.Okb.Omk))
        {
          paramString = this.Omk;
          break label158;
        }
        paramString = paramp.Okb.Omk;
        break label158;
        label365:
        if (!this.mKindaEnable) {
          break label191;
        }
        hideLoading();
        break label191;
        label379:
        this.Oif = 0L;
        this.Ojy = "";
        this.Ose = 0L;
        continue;
        if ((paramp instanceof ak))
        {
          this.Omf = ((ak)paramp).rIB;
          this.Omg = ((ak)paramp).Vys;
          this.Omh = ((ak)paramp).Vyt;
          gMw();
          gMv();
        }
      }
    }
    if ((paramp instanceof ak))
    {
      Log.i("MicroMsg.RemittanceNewBaseUI", "net error, use hardcode wording");
      this.mWcKeyboard.hVf();
    }
    do
    {
      do
      {
        return false;
      } while (!(paramp instanceof af));
      if (this.mKindaEnable) {
        hideLoading();
      }
      this.Omp = ((af)paramp);
      this.Oms.alive();
      ag.G(this.mPayScene, "", paramInt2);
    } while (!c((af)paramp));
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    Log.i("MicroMsg.RemittanceNewBaseUI", "onWindowFocusChanged");
    if ((this.xcO != null) && (!this.xcO.isShowing()))
    {
      this.xcO.cyW();
      this.xcO = null;
      if (this.pJs != null) {
        MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
      }
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(al.class);
  }
  
  static final class a
  {
    String OjM;
    String OjN;
    String OjR;
    long OmN;
    int amount;
    String hAU;
    String hPj;
    String wXY;
    String xas;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong)
    {
      this.OjM = paramString1;
      this.wXY = paramString2;
      this.xas = paramString3;
      this.OjN = paramString4;
      this.amount = paramInt;
      this.hPj = paramString5;
      this.hAU = paramString6;
      this.OjR = paramString7;
      this.OmN = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
 * JD-Core Version:    0.7.0.1
 */