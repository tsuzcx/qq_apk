package com.tencent.mm.plugin.remittance.ui;

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
import com.tencent.mm.autogen.a.acw;
import com.tencent.mm.autogen.a.hd;
import com.tencent.mm.autogen.a.hd.a;
import com.tencent.mm.autogen.a.hf;
import com.tencent.mm.autogen.mmdata.rpt.rl;
import com.tencent.mm.autogen.mmdata.rpt.rs;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.app.c;
import com.tencent.mm.plugin.remittance.model.ad;
import com.tencent.mm.plugin.remittance.model.af;
import com.tencent.mm.plugin.remittance.model.af.a;
import com.tencent.mm.plugin.remittance.model.am;
import com.tencent.mm.plugin.remittance.model.an;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k.b;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.wallet_core.model.ag;
import com.tencent.mm.wallet_core.model.ah;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public abstract class RemittanceBaseUI
  extends WalletBaseUI
  implements AvatarStorage.a
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 270);
  protected String MFC;
  private double OjJ;
  protected com.tencent.mm.plugin.wallet.a OlE = null;
  protected String OlF;
  protected String OlG;
  protected String OlH;
  private int OlI = -1;
  protected boolean OlJ = false;
  protected String OlK;
  protected ImageView OlL;
  protected TextView OlM;
  protected TextView OlN;
  protected TextView OlO;
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
  private LinearLayout OlZ;
  protected String OmA = "";
  protected String OmB = "";
  protected String OmC = "";
  private IListener<hf> OmD = new IListener(com.tencent.mm.app.f.hfK) {};
  protected String Oma;
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
  private String hQR;
  protected int hXQ = 0;
  protected String luk;
  private int mChannel;
  protected String mDesc;
  protected String mName;
  protected int mPayScene;
  protected int mScene;
  protected ScrollView pJa;
  protected double pJk;
  protected Button qgp;
  protected String wPR;
  protected WalletFormView xcz;
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    e.a locala = new e.a(paramContext);
    locala.bDv(paramString2);
    locala.bDw(paramString1);
    locala.bDC(paramString3).c(paramOnClickListener1);
    locala.bDD(paramString4).d(paramOnClickListener2);
    locala.NC(false);
    locala.ND(true);
    paramString1 = locala.jHH();
    paramString1.show();
    com.tencent.mm.ui.base.k.a(paramContext, paramString1);
  }
  
  private void a(af paramaf, abe paramabe)
  {
    this.Omr = true;
    new d(this).a(paramaf, paramabe, new d.a()
    {
      public final void aTT(String paramAnonymousString)
      {
        AppMethodBeat.i(67967);
        Log.i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", new Object[] { paramAnonymousString });
        RemittanceBaseUI.this.Oml = paramAnonymousString;
        RemittanceBaseUI.this.gMA();
        AppMethodBeat.o(67967);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(289004);
        RemittanceBaseUI.this.Oml = "";
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(289004);
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
      String str;
      if (!bool1)
      {
        bool2 = bool1;
        if (!Util.isNullOrNil(paramaf.OjP))
        {
          bool2 = bool1;
          if (!Util.isNullOrNil(paramaf.OjQ))
          {
            str = i.jo(i.getDisplayName(this.luk), 10);
            if (!Util.isNullOrNil(this.wPR)) {
              str = this.wPR;
            }
            if (Util.isNullOrNil(this.Ome)) {
              break label193;
            }
            str = getString(a.i.remittance_collect_block, new Object[] { str, this.Ome });
          }
        }
      }
      label193:
      for (;;)
      {
        bool2 = a(paramaf.hMy, paramaf.OjQ, str, paramaf.OjP, paramaf);
        return bool2;
      }
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
        AppMethodBeat.i(67978);
        RemittanceBaseUI.this.showNormalStWcKb();
        AppMethodBeat.o(67978);
      }
    });
    paramString2.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(288935);
        RemittanceBaseUI.this.showLoading();
        RemittanceBaseUI.this.a(paramString1, RemittanceBaseUI.this.luk, RemittanceBaseUI.this.Ome, paramaf);
        AppMethodBeat.o(288935);
      }
    });
    paramString2.jHH().show();
    return true;
  }
  
  private static void aUc(String paramString)
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
    c.gLv().gLy().lx(str, paramString);
  }
  
  private void b(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      this.hXQ = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.RemittanceBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", new Object[] { Integer.valueOf(this.hXQ), Double.valueOf(this.Omz), this.OmA, this.OmB, this.OmC });
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
          AppMethodBeat.i(67955);
          Log.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[] { paramaf.iaV.wYO });
          i.p(RemittanceBaseUI.this.getContext(), paramaf.iaV.wYO, false);
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
      com.tencent.mm.ui.base.k.b(this, paramaf.OjD, getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67956);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 3, paramaf.hPj);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramaf))
          {
            RemittanceBaseUI.this.showLoading();
            RemittanceBaseUI.this.a(paramaf.hMy, RemittanceBaseUI.this.luk, RemittanceBaseUI.this.Ome, paramaf);
          }
          AppMethodBeat.o(67956);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67957);
          RemittanceBaseUI.a(RemittanceBaseUI.this, 2, paramaf.hPj);
          AppMethodBeat.o(67957);
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
        break label143;
      }
      if (!Util.isNullOrNil(paramaf.OjC.wording)) {
        break label120;
      }
      str1 = getString(a.i.remittance_remind_desc, new Object[] { Integer.valueOf(paramaf.OjB) });
      String str3 = getString(a.i.remittance_continue);
      if (!Util.isNullOrNil(paramaf.OjC.Okc)) {
        break label131;
      }
      str2 = getString(a.i.remittance_open_order_history_action);
      label87:
      a(this, str1, "", str3, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67958);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramaf))
          {
            RemittanceBaseUI.this.showLoading();
            RemittanceBaseUI.this.a(paramaf.hMy, RemittanceBaseUI.this.luk, RemittanceBaseUI.this.Ome, paramaf);
          }
          AppMethodBeat.o(67958);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67959);
          if (Util.isNullOrNil(paramaf.OjC.Okd))
          {
            com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.o(67959);
            return;
          }
          com.tencent.mm.plugin.account.sdk.c.a.b(RemittanceBaseUI.this, paramaf.OjC.Okd, 5, true);
          AppMethodBeat.o(67959);
        }
      });
    }
    for (;;)
    {
      bool = true;
      return bool;
      label120:
      str1 = paramaf.OjC.wording;
      break;
      label131:
      str2 = paramaf.OjC.Okc;
      break label87;
      label143:
      Log.i("MicroMsg.RemittanceBaseUI", "scene.zaituMessage == null");
      a(this, getString(a.i.remittance_remind_desc, new Object[] { Integer.valueOf(paramaf.OjB) }), getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.remittance_open_order_history_action), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67961);
          if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramaf)) {
            RemittanceBaseUI.this.a(paramaf.hMy, RemittanceBaseUI.this.luk, RemittanceBaseUI.this.Ome, paramaf);
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
  
  private boolean f(final af paramaf)
  {
    if (paramaf.OjI)
    {
      this.Omv = true;
      g.a(this, this.mScene, paramaf.OjL / 100.0D, paramaf.OjK / 100.0D, paramaf.OjF / 100.0D, paramaf.OjH, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67963);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          RemittanceBaseUI.this.showLoading();
          RemittanceBaseUI.this.a(paramaf.hMy, RemittanceBaseUI.this.luk, RemittanceBaseUI.this.Ome, paramaf);
          if (RemittanceBaseUI.this.mScene == 1) {
            com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67963);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          }
        }
      });
      return true;
    }
    return false;
  }
  
  private void gMv()
  {
    if ((gMz()) && (!Util.isNullOrNil(this.Omg)) && (this.Omi != 0) && (this.Omh == 1))
    {
      addIconOptionMenu(0, a.e.wallet_qanda_icon, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(67980);
          i.p(RemittanceBaseUI.this.getContext(), RemittanceBaseUI.this.Omg, false);
          AppMethodBeat.o(67980);
          return false;
        }
      });
      return;
    }
    removeAllOptionMenu();
  }
  
  private void gMw()
  {
    if ((!Util.isNullOrNil(this.Omf)) && (this.Omi != 0))
    {
      int i;
      if (this.Omi == 1) {
        i = 2;
      }
      try
      {
        for (;;)
        {
          this.OlO.setText(String.format(this.Omf, new Object[] { Integer.valueOf(i) }));
          this.OlO.setVisibility(0);
          return;
          i = 24;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.RemittanceBaseUI", localException, "", new Object[0]);
          this.OlO.setText(getString(a.i.remittance_hardcode_tips, new Object[] { Integer.valueOf(i) }));
        }
      }
    }
    this.OlO.setText("");
    this.OlO.setVisibility(8);
  }
  
  private void gMy()
  {
    Object localObject2 = i.jo(i.getDisplayName(this.luk), 10);
    Object localObject1 = localObject2;
    if (!Util.isNullOrNil(this.Ome)) {
      localObject1 = getString(a.i.remittance_collect_block, new Object[] { localObject2, this.Ome });
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
        label148:
        this.OlM.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject2, this.OlM.getTextSize()));
        if (!com.tencent.mm.kernel.h.baz()) {
          break label488;
        }
        localObject1 = com.tencent.mm.modelavatar.q.bFE();
        if ((localObject1 == null) || (Util.isNullOrNil(this.luk))) {
          break label488;
        }
        localObject1 = ((com.tencent.mm.modelavatar.k)localObject1).LS(this.luk);
        if ((localObject1 != null) && (!Util.isNullOrNil(((j)localObject1).bFx()))) {
          break label488;
        }
        long l = Util.nowMilliSecond();
        az.a.okP.a(this.luk, "", new RemittanceBaseUI.26(this, l));
      }
    }
    label488:
    for (int i = 1;; i = 0)
    {
      if ((Util.isNullOrNil(this.luk)) && (!Util.isNullOrNil(this.OlG)))
      {
        Log.i("MicroMsg.RemittanceBaseUI", "use mRecvHeadimgurl(%s) to avatar, mReceiverAvatarIv:%s", new Object[] { this.OlG, this.OlL.getClass().getSimpleName() });
        if ((this.OlL instanceof CdnImageView))
        {
          i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 44.0F);
          ((CdnImageView)this.OlL).setRoundCorner(true);
          ((CdnImageView)this.OlL).w(this.OlG, i, i, a.e.default_avatar);
        }
      }
      while (i != 0)
      {
        return;
        localObject1 = getString(a.i.remittance_collect_pay_wrords_nick_tip, new Object[] { i.jo(i.getDisplayName(this.luk), 10), this.Ome });
        break;
        localObject2 = localObject1;
        if (this.mScene != 6) {
          break label148;
        }
        localObject2 = getIntent().getStringExtra("receiver_tips");
        if (!Util.isNullOrNil(this.wPR)) {
          localObject1 = this.wPR;
        }
        if (Util.isNullOrNil((String)localObject2))
        {
          localObject2 = getString(a.i.remittance_collect_pay_wrords, new Object[] { localObject1 });
          break label148;
        }
        localObject2 = Util.safeFormatString((String)localObject2, new Object[] { localObject1 });
        break label148;
      }
      gzL();
      return;
    }
  }
  
  private boolean gMz()
  {
    return (this.mScene == 0) || (this.mScene == 2);
  }
  
  private void gzL()
  {
    final Runnable local27 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67982);
        Bitmap localBitmap = com.tencent.mm.modelavatar.d.a(RemittanceBaseUI.this.luk, false, -1, null);
        if (localBitmap == null)
        {
          RemittanceBaseUI.this.OlL.setImageResource(a.e.default_avatar);
          AppMethodBeat.o(67982);
          return;
        }
        RemittanceBaseUI.this.OlL.setImageBitmap(localBitmap);
        AppMethodBeat.o(67982);
      }
    };
    if (MMHandlerThread.isMainThread())
    {
      local27.run();
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67983);
        local27.run();
        AppMethodBeat.o(67983);
      }
    });
  }
  
  public void LM(String paramString)
  {
    Log.i("MicroMsg.RemittanceBaseUI", "onGet");
    if (Util.nullAsNil(paramString).length() <= 0) {
      Log.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = ".concat(String.valueOf(paramString)));
    }
    while (!paramString.equals(this.luk)) {
      return;
    }
    gzL();
  }
  
  protected final void a(final String paramString1, final String paramString2, final String paramString3, final af paramaf)
  {
    Log.i("MicroMsg.RemittanceBaseUI", "startPay mKindaEnable %s reqKey %s", new Object[] { Boolean.valueOf(this.mKindaEnable), paramString1 });
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
              AppMethodBeat.i(67968);
              Log.i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceBaseUI.g(RemittanceBaseUI.this) });
              paramAnonymousDialogInterface = new rs();
              paramAnonymousDialogInterface.jwc = ((int)paramaf.OjO);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.yr(paramaf.username);
              paramAnonymousDialogInterface.jvV = 9L;
              paramAnonymousDialogInterface.bMH();
              paramaf.Okb = null;
              RemittanceBaseUI.this.a(paramString1, paramString2, paramString3, paramaf);
              AppMethodBeat.o(67968);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(67969);
              Log.i("MicroMsg.RemittanceBaseUI", "onClick1");
              paramAnonymousDialogInterface = new rs();
              paramAnonymousDialogInterface.jwc = ((int)paramaf.OjO);
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.yr(paramaf.username);
              paramAnonymousDialogInterface.jvV = 8L;
              paramAnonymousDialogInterface.bMH();
              AppMethodBeat.o(67969);
            }
          }, a.c.real_name_goon_remittance);
          return;
        }
      } while (paramaf.Okb.ZjH != 2);
      com.tencent.mm.ui.base.k.a(this, paramaf.Okb.wording, paramaf.Okb.title, getResources().getString(a.i.welcome_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
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
    if (this.OlJ)
    {
      paramString1.putBoolean("extinfo_key_23", this.OlJ);
      paramString1.putString("extinfo_key_24", this.mName);
      paramString1.putString("extinfo_key_25", this.MFC);
      paramString1.putString("extinfo_key_26", this.Oma);
    }
    ((PayInfo)localObject1).nKf = paramString1;
    paramString1 = new Intent();
    Log.i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
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
        return;
        paramString1 = "(" + this.Ome + ")";
        break;
        Log.e("MicroMsg.RemittanceBaseUI", "can not found contact for user::".concat(String.valueOf(paramString2)));
        paramString1 = "";
        continue;
        Log.e("MicroMsg.RemittanceBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        paramString1 = "";
      }
    }
    hideLoading();
    com.tencent.mm.plugin.wallet.a.a(this.OlE, paramString1);
    if ((paramaf.OiC != null) && (paramaf.OiC.hHR.hHU != null))
    {
      com.tencent.mm.pluginsdk.wallet.f.a(paramaf.OiC.hHR.hHU, false, "", (PayInfo)localObject1, paramString3, paramString1, paramaf.OiC.hHR.mRequestCode);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", (PayInfo)localObject1, paramString3, paramString1, 1);
  }
  
  public abstract void aUb(String paramString);
  
  protected final void gMA()
  {
    aUb(this.mDesc);
  }
  
  protected void gMB()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("recent_remittance_contact_list", an.gMc());
    localIntent.setClass(getContext(), SelectRemittanceContactUI.class);
    startActivityForResult(localIntent, 2);
  }
  
  public void gMs()
  {
    ad localad = new ad(this.luk, this.OlK);
    localad.setProcessName("RemittanceProcess");
    doSceneProgress(localad);
  }
  
  public void gMt() {}
  
  public abstract void gMu();
  
  public abstract void gMx();
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    if ((this.mPayScene == 33) || (this.mPayScene == 32)) {
      return a.g.remittance_new_ui_f2f;
    }
    if (Util.isEqual(this.OlI, 0))
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
            RemittanceBaseUI.this.gMs();
            RemittanceBaseUI.this.finish();
          }
          for (;;)
          {
            RemittanceBaseUI.this.gMt();
            AppMethodBeat.o(67950);
            return true;
            if ((RemittanceBaseUI.this.mScene == 2) || (RemittanceBaseUI.this.mScene == 5)) {
              RemittanceBaseUI.this.finish();
            } else {
              RemittanceBaseUI.this.gMB();
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
      if (Util.isEqual(this.OlI, 0))
      {
        this.OlW = ((LinearLayout)findViewById(a.f.remittance_address_container));
        this.OlX = ((TextView)findViewById(a.f.name_telephone_tv));
        this.OlY = ((TextView)findViewById(a.f.address_detail_tv));
      }
      gMy();
      this.xcz = ((WalletFormView)findViewById(a.f.money_ev));
      if (this.mPayScene != 33) {
        break label657;
      }
      this.OlS.setText(i.formatMoney2f(this.pJk));
      this.OlT.setText(ai.jOX());
      this.Omc = getIntent().getStringExtra("desc");
      if (Util.isNullOrNil(this.Omc)) {
        break label645;
      }
      this.OlR.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), this.Omc, this.OlR.getTextSize()));
      this.OlR.setVisibility(0);
      label358:
      this.OlU.setVisibility(0);
      this.OlV.setVisibility(8);
      label375:
      this.qgp = ((Button)findViewById(a.f.next_btn));
      this.qgp.setOnClickListener(new ac()
      {
        public final void dsb()
        {
          AppMethodBeat.i(67960);
          RemittanceBaseUI localRemittanceBaseUI;
          String str;
          if (RemittanceBaseUI.this.mPayScene == 33)
          {
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.aUb(str);
            if (RemittanceBaseUI.b(RemittanceBaseUI.this) == 0.0D)
            {
              if (RemittanceBaseUI.this.mScene != 1) {
                break label261;
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
            }
          }
          for (;;)
          {
            if ((RemittanceBaseUI.this.mScene == 1) && (!Util.isNullOrNil(RemittanceBaseUI.this.mDesc))) {
              com.tencent.mm.plugin.report.service.h.OAn.b(14074, new Object[] { Integer.valueOf(2) });
            }
            AppMethodBeat.o(67960);
            return;
            RemittanceBaseUI.this.pJk = Util.getDouble(RemittanceBaseUI.this.xcz.getText(), 0.0D);
            if (!RemittanceBaseUI.this.xcz.bZp())
            {
              aa.makeText(RemittanceBaseUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
              break;
            }
            if (RemittanceBaseUI.this.pJk < 0.01D)
            {
              RemittanceBaseUI.this.gMu();
              break;
            }
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.gMC();
            localRemittanceBaseUI = RemittanceBaseUI.this;
            str = RemittanceBaseUI.this.mDesc;
            RemittanceBaseUI.a(RemittanceBaseUI.this);
            localRemittanceBaseUI.aUb(str);
            break;
            label261:
            com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          }
        }
      });
      this.OlP = ((TextView)findViewById(a.f.remittance_desc));
      this.OlQ = ((TextView)findViewById(a.f.add_remittance_desc));
      if ((this.mScene != 1) && (this.mScene != 6)) {
        break label778;
      }
      this.OlQ.setText(a.i.remittance_add_f2f_desc_link);
    }
    for (;;)
    {
      if (!z.bBi()) {
        findViewById(a.f.remittance_desc_container).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(67977);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            RemittanceBaseUI.this.hideTenpayKB();
            RemittanceBaseUI.gMC();
            com.tencent.mm.plugin.report.service.h.OAn.b(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
            if ((RemittanceBaseUI.this.mScene == 1) || (RemittanceBaseUI.this.mScene == 6))
            {
              localObject = RemittanceBaseUI.this.getString(a.i.remittance_add_f2f_desc_link);
              paramAnonymousView = RemittanceBaseUI.this.getString(a.i.remittance_desc_max_words_count_tip);
              com.tencent.mm.plugin.report.service.h.OAn.b(14074, new Object[] { Integer.valueOf(1) });
            }
            String str1;
            String str2;
            do
            {
              do
              {
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, (String)localObject, RemittanceBaseUI.this.mDesc, paramAnonymousView, 20, new k.b()new DialogInterface.OnClickListener
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
            } while (!RemittanceBaseUI.this.OlJ);
            com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, str1, RemittanceBaseUI.this.mDesc, str2, RemittanceBaseUI.this.Omb, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.MFC, RemittanceBaseUI.this.Oma, new a.a()new g.c
            {
              public final boolean a(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4)
              {
                AppMethodBeat.i(67971);
                RemittanceBaseUI.this.Omb = paramAnonymous2Boolean;
                if (!Util.isNullOrNil(paramAnonymous2String1))
                {
                  RemittanceBaseUI.this.mDesc = paramAnonymous2String1;
                  if (RemittanceBaseUI.this.Omb) {
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
                  RemittanceBaseUI.this.MFC = paramAnonymous2String3;
                  label85:
                  if (Util.isNullOrNil(paramAnonymous2String4)) {
                    break label174;
                  }
                  RemittanceBaseUI.this.Oma = paramAnonymous2String4;
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
                  RemittanceBaseUI.this.MFC = null;
                  break label85;
                  label174:
                  RemittanceBaseUI.this.Oma = null;
                  continue;
                  label188:
                  RemittanceBaseUI.this.mName = null;
                  RemittanceBaseUI.this.MFC = null;
                  RemittanceBaseUI.this.Oma = null;
                }
              }
            }, new g.c()
            {
              public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
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
      this.OlO = ((TextView)findViewById(a.f.placeholder));
      this.OlZ = ((LinearLayout)findViewById(a.f.remittance_main_ui));
      gMw();
      gMx();
      gMv();
      if ((this.mPayScene != 33) && (this.mPayScene == 32)) {}
      return;
      setMMTitle(a.i.remittance_title);
      break;
      label645:
      this.OlR.setVisibility(8);
      break label358;
      label657:
      this.xcz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67984);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          RemittanceBaseUI.this.hideTenpayKB();
          RemittanceBaseUI.gMC();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67984);
        }
      });
      this.xcz.getTitleTv().setText(String.format(getString(a.i.remittance_fee_tips), new Object[] { "¥" }));
      this.xcz.a(new RemittanceBaseUI.2(this));
      setEditFocusListener(this.xcz, 2, false);
      findViewById(a.f.placeholder);
      findViewById(a.f.remittance_main_ui).setVisibility(0);
      this.OlU.setVisibility(8);
      this.OlV.setVisibility(0);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(67952);
          if (paramAnonymousBoolean)
          {
            RemittanceBaseUI.a(RemittanceBaseUI.this, RemittanceBaseUI.this.pJa, RemittanceBaseUI.this.qgp);
            AppMethodBeat.o(67952);
            return;
          }
          RemittanceBaseUI.this.pJa.scrollTo(0, 0);
          AppMethodBeat.o(67952);
        }
      });
      break label375;
      label778:
      this.OlQ.setText(a.i.remittance_add_desc_link);
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
    Log.i("MicroMsg.RemittanceBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + Util.nullAs(this.luk, "null") + ", =" + Util.nullAs(this.wPR, "null"));
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
          this.luk = str1;
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
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          hideTenpayKB();
          str1 = getString(a.i.bank_remit_remittance_desc_text);
          String str2 = getString(a.i.remittance_desc_max_words_count_tip);
          String str3 = paramIntent.getStringExtra("userName");
          String str4 = paramIntent.getStringExtra("telNumber");
          String str5 = paramIntent.getStringExtra("proviceFirstStageName") + paramIntent.getStringExtra("addressCitySecondStageName") + paramIntent.getStringExtra("addressCountiesThirdStageName") + paramIntent.getStringExtra("addressDetailInfo");
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, str1, this.mDesc, str2, false, str3, str4, str5, new a.a()new g.c
          {
            public final boolean a(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
            {
              AppMethodBeat.i(67964);
              RemittanceBaseUI.this.Omb = paramAnonymousBoolean;
              if (!Util.isNullOrNil(paramAnonymousString1))
              {
                RemittanceBaseUI.this.mDesc = paramAnonymousString1;
                if (!RemittanceBaseUI.this.Omb)
                {
                  if (Util.isNullOrNil(paramAnonymousString2)) {
                    break label119;
                  }
                  RemittanceBaseUI.this.mName = paramAnonymousString2;
                  label53:
                  if (Util.isNullOrNil(paramAnonymousString3)) {
                    break label130;
                  }
                  RemittanceBaseUI.this.MFC = paramAnonymousString3;
                  label70:
                  if (Util.isNullOrNil(paramAnonymousString4)) {
                    break label141;
                  }
                }
              }
              label130:
              label141:
              for (RemittanceBaseUI.this.Oma = paramAnonymousString4;; RemittanceBaseUI.this.Oma = null)
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
                RemittanceBaseUI.this.MFC = null;
                break label70;
              }
            }
          }, new g.c()
          {
            public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
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
    if (!gMz())
    {
      this.hQR = UUID.randomUUID().toString();
      com.tencent.mm.plugin.wallet.pay.a.b.bgj(this.hQR);
    }
    long l;
    if ((this instanceof RemittanceHKUI))
    {
      this.OlI = 1;
      super.onCreate(paramBundle);
      this.OlE = com.tencent.mm.plugin.wallet.a.bE(getIntent());
      this.OlK = getIntent().getStringExtra("scan_remittance_id");
      this.pJk = getIntent().getDoubleExtra("fee", 0.0D);
      this.luk = getIntent().getStringExtra("receiver_name");
      this.OlG = getIntent().getStringExtra("recv_headimgurl");
      this.wPR = getIntent().getStringExtra("receiver_nick_name");
      this.Ome = getIntent().getStringExtra("receiver_true_name");
      this.OlF = getIntent().getStringExtra("mch_name");
      this.OlH = getIntent().getStringExtra("mch_info");
      this.mChannel = getIntent().getIntExtra("pay_channel", 0);
      this.Omj = Util.nullAs(getIntent().getStringExtra("rcvr_open_id"), "");
      Log.i("MicroMsg.RemittanceBaseUI", "mUserName %s", new Object[] { this.luk });
      com.tencent.mm.kernel.h.baF();
      l = ((Long)com.tencent.mm.kernel.h.baE().ban().d(147457, Long.valueOf(0L))).longValue();
      if ((0x10 & l) == 0L) {
        break label341;
      }
      this.Omi = 1;
    }
    for (;;)
    {
      com.tencent.mm.modelavatar.q.bFp().a(this);
      initView();
      this.OmD.alive();
      com.tencent.mm.wallet_core.b.jNX();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(c.a.yRc, true);
      return;
      if (!(this instanceof RemittanceOSUI)) {
        break;
      }
      this.OlI = 2;
      break;
      label341:
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
    this.Oms.dead();
    com.tencent.mm.modelavatar.q.bFp().b(this);
    this.OmD.dead();
    this.Omy.dead();
    com.tencent.mm.plugin.wallet.pay.a.b.bgk(this.hQR);
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
            break label278;
          }
          paramString = "";
          label158:
          this.Omk = paramString;
          if (a(paramp)) {
            break label312;
          }
          a(paramp.hMy, this.luk, this.Ome, paramp);
          label191:
          paramString = new a(paramp.OjM, paramp.wXY, paramp.xas, paramp.OjN, paramp.amount, paramp.hPj, paramp.hAU, paramp.OjR, Util.getLong(paramp.OjP, 0L));
          this.Omm.put(paramp.hMy, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.Omn = paramp.hPj;
        break;
        label278:
        if (Util.isNullOrNil(paramp.Okb.Omk))
        {
          paramString = this.Omk;
          break label158;
        }
        paramString = paramp.Okb.Omk;
        break label158;
        label312:
        if (!this.mKindaEnable) {
          break label191;
        }
        hideLoading();
        break label191;
        if ((paramp instanceof aj)) {
          throw null;
        }
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
      Log.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
      this.OlO.setText("");
      this.OlO.setVisibility(8);
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
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
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
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
 * JD-Core Version:    0.7.0.1
 */