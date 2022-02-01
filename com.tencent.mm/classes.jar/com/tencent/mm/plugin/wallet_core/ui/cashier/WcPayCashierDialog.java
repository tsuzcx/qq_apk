package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.lifecycle.h.a;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.e.a;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.o.b;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.eqh;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class WcPayCashierDialog
  extends i
  implements androidx.lifecycle.k
{
  public static final int PdD;
  public static final int PdE;
  public static final int PdF;
  public static final int PdG;
  private View EQr;
  public Orders Ivh;
  private com.tencent.mm.plugin.wallet_core.utils.a OuA;
  public FavorPayInfo OxY;
  private TextView Pbw;
  private TextView PdH;
  private TextView PdI;
  private TextView PdJ;
  private WalletTextView PdK;
  private ViewGroup PdL;
  private EditHintPasswdView PdM;
  private ViewGroup PdN;
  private Button PdO;
  private TextView PdP;
  private ViewGroup PdQ;
  private CdnImageView PdR;
  private TextView PdS;
  private Button PdT;
  private ViewGroup PdU;
  private WcPayCashierDetailItemLayout PdV;
  private WcPayCashierDetailItemLayout PdW;
  private WcPayCashierDetailItemLayout PdX;
  private WcPayCashierDetailItemLayout PdY;
  private WcPayCashierFingerprintDialog PdZ;
  private ImageView Pdk;
  private a Pea;
  private o Peb;
  private int Pec;
  private int Ped;
  private int Pee;
  public Bankcard Pef;
  private boolean Peg;
  private boolean Peh;
  private boolean Pei;
  private boolean Pej;
  private String Pek;
  private String Pel;
  private String Pem;
  private boolean Pen;
  private boolean Peo;
  public a Pep;
  List<b> Peq;
  private Context mContext;
  private MyKeyboardWindow mKeyboard;
  public PayInfo mPayInfo;
  private ViewGroup qoE;
  
  static
  {
    AppMethodBeat.i(71415);
    PdD = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 30);
    PdE = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    PdF = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    PdG = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 24);
    AppMethodBeat.o(71415);
  }
  
  public WcPayCashierDialog(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(71361);
    this.Pec = 0;
    this.Ped = 0;
    this.Pee = 0;
    this.mPayInfo = new PayInfo();
    this.Ivh = new Orders();
    this.Peg = false;
    this.Pei = true;
    this.Peq = new ArrayList();
    this.mContext = paramContext;
    this.qoE = ((ViewGroup)View.inflate(getContext(), a.g.wc_pay_cashier_dialog, null));
    this.Pdk = ((ImageView)this.qoE.findViewById(a.f.wpcd_close_iv));
    this.PdH = ((TextView)this.qoE.findViewById(a.f.wpcd_dialog_title_tv));
    this.PdI = ((TextView)this.qoE.findViewById(a.f.wpcd_switch_verify_way_tv));
    this.PdJ = ((TextView)this.qoE.findViewById(a.f.wpcd_order_desc_tv));
    this.Pbw = ((TextView)this.qoE.findViewById(a.f.wpcd_charge_fee_tv));
    this.PdK = ((WalletTextView)this.qoE.findViewById(a.f.wpcd_order_money_tv));
    this.PdL = ((ViewGroup)this.qoE.findViewById(a.f.wpcd_detail_layout));
    this.PdM = ((EditHintPasswdView)this.qoE.findViewById(a.f.wpcd_pwd_input_et));
    this.PdN = ((ViewGroup)this.qoE.findViewById(a.f.wpcd_pwd_input_layout));
    this.PdW = ((WcPayCashierDetailItemLayout)this.qoE.findViewById(a.f.wpcd_payway_layout));
    this.PdO = ((Button)this.qoE.findViewById(a.f.wpcd_confirm_pay_btn));
    this.PdP = ((TextView)this.qoE.findViewById(a.f.wpcd_error_tips_tv));
    this.PdQ = ((ViewGroup)this.qoE.findViewById(a.f.wpcd_bank_favor_layout));
    this.PdR = ((CdnImageView)this.qoE.findViewById(a.f.wpcd_favor_icon_iv));
    this.PdS = ((TextView)this.qoE.findViewById(a.f.wpcd_favor_content_tv));
    this.PdT = ((Button)this.qoE.findViewById(a.f.wpcd_favor_btn));
    this.mKeyboard = ((MyKeyboardWindow)this.qoE.findViewById(a.f.tenpay_num_keyboard));
    this.PdU = ((ViewGroup)this.qoE.findViewById(a.f.tenpay_keyboard_layout));
    this.EQr = this.qoE.findViewById(a.f.wpcd_detail_divider);
    ar.a(this.PdH.getPaint(), 0.8F);
    ar.a(this.PdI.getPaint(), 0.8F);
    paramContext = this.Pdk;
    int i = PdD;
    int j = PdD;
    Util.expandViewTouchArea(paramContext, i, i, j, j);
    paramContext = au.o(getContext(), a.h.actionbar_icon_dark_close, getContext().getResources().getColor(a.c.black_per30));
    this.Pdk.setImageDrawable(paramContext);
    this.Pdk.setOnClickListener(new WcPayCashierDialog.10(this));
    com.tencent.mm.wallet_core.ui.formview.a.a(this.PdM);
    this.PdM.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71355);
        if (paramAnonymousBoolean)
        {
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.e(WcPayCashierDialog.this).getText(), WcPayCashierDialog.this.OxY);
          com.tencent.mm.plugin.report.service.h.IzE.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        }
        AppMethodBeat.o(71355);
      }
    });
    paramContext = (EditText)this.qoE.findViewById(a.f.wallet_content);
    g.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      View.AccessibilityDelegate localAccessibilityDelegate = com.tencent.mm.ui.a.d.hJh();
      this.mKeyboard.setSecureAccessibility(localAccessibilityDelegate);
      paramContext.setAccessibilityDelegate(localAccessibilityDelegate);
    }
    paramContext.setOnClickListener(new WcPayCashierDialog.12(this));
    this.qoE.findViewById(a.f.tenpay_push_down).setOnClickListener(new WcPayCashierDialog.13(this));
    this.PdO.setOnClickListener(new aa()
    {
      public final void cOw()
      {
        int i = 0;
        AppMethodBeat.i(71358);
        Log.i("MicroMsg.WcPayCashierDialog", "click pay btn: %s", new Object[] { Integer.valueOf(WcPayCashierDialog.h(WcPayCashierDialog.this)) });
        if (WcPayCashierDialog.this.mPayInfo == null) {
          if (WcPayCashierDialog.this.mPayInfo != null) {
            break label113;
          }
        }
        label113:
        for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.fwv)
        {
          af.f(i, str, 20, "");
          WcPayCashierDialog.i(WcPayCashierDialog.this);
          if (WcPayCashierDialog.h(WcPayCashierDialog.this) != 1) {
            break label127;
          }
          WcPayCashierDialog.j(WcPayCashierDialog.this);
          g.azK(9);
          AppMethodBeat.o(71358);
          return;
          i = WcPayCashierDialog.this.mPayInfo.fOY;
          break;
        }
        label127:
        if (WcPayCashierDialog.h(WcPayCashierDialog.this) == 2)
        {
          WcPayCashierDialog.k(WcPayCashierDialog.this);
          AppMethodBeat.o(71358);
          return;
        }
        Log.i("MicroMsg.WcPayCashierDialog", "wrong mode, switch pwd");
        WcPayCashierDialog.l(WcPayCashierDialog.this);
        AppMethodBeat.o(71358);
      }
    });
    this.PdI.setOnClickListener(new WcPayCashierDialog.15(this));
    setCancelable(true);
    setCanceledOnTouchOutside(false);
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71335);
        Log.i("MicroMsg.WcPayCashierDialog", "on canceled");
        WcPayCashierDialog.b(WcPayCashierDialog.this);
        if (WcPayCashierDialog.c(WcPayCashierDialog.this) != null) {
          WcPayCashierDialog.c(WcPayCashierDialog.this).onCancel();
        }
        AppMethodBeat.o(71335);
      }
    });
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71353);
        Log.i("MicroMsg.WcPayCashierDialog", "on dismissed");
        WcPayCashierDialog.b(WcPayCashierDialog.this);
        WcPayCashierDialog.d(WcPayCashierDialog.this);
        AppMethodBeat.o(71353);
      }
    });
    ((MMActivity)this.mContext).getLifecycle().a(this);
    this.OuA = new com.tencent.mm.plugin.wallet_core.utils.a();
    AppMethodBeat.o(71361);
  }
  
  private void Cq(boolean paramBoolean)
  {
    AppMethodBeat.i(71391);
    Log.i("MicroMsg.WcPayCashierDialog", "switch to pwd: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Pec = 0;
    this.mPayInfo.PbP = 0;
    this.PdN.setVisibility(0);
    this.PdO.setVisibility(8);
    this.PdM.fuo();
    gLZ();
    this.PdH.setVisibility(0);
    if (paramBoolean)
    {
      this.PdI.setVisibility(8);
      AppMethodBeat.o(71391);
      return;
    }
    this.PdI.setVisibility(0);
    AppMethodBeat.o(71391);
  }
  
  private void H(TextView paramTextView)
  {
    AppMethodBeat.i(71377);
    com.tencent.mm.plugin.wallet_core.ui.e locale = com.tencent.mm.plugin.wallet_core.ui.f.OVk.a(this.Ivh);
    j localj = locale.bhs(this.OxY.OPI);
    List localList = locale.gLg();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = "";
    int i;
    if ((localj != null) && (localj.Owt > 0.0D))
    {
      localStringBuilder.append(localj.Owv);
      i = 1;
    }
    for (;;)
    {
      if ((localj != null) && (localj.Owu != 0) && (!Util.isNullOrNil(localStringBuilder)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append(localj.Oww);
      }
      if ((!Util.isNullOrNil(localStringBuilder)) && (!Util.isNullOrNil((String)localObject)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append((String)localObject);
        label152:
        localObject = localStringBuilder.toString();
        Log.i("MicroMsg.WcPayCashierDialog", "favor text: %s", new Object[] { localObject });
        if (i == 0) {
          break label335;
        }
        paramTextView.setTextColor(getContext().getResources().getColor(a.c.Orange));
      }
      for (;;)
      {
        paramTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(71377);
        return;
        if (localList.size() <= 0) {
          break label355;
        }
        localObject = locale.gLf();
        if ((localj == null) && (locale.gLe() == 1) && (localObject != null) && (((j)localObject).Owu == 0) && (this.Pei) && (this.Ivh.ORe.Owz != null) && (this.Ivh.ORe.Owz.OvV == 1))
        {
          localObject = getContext().getString(a.i.wallet_pwd_dialog_unuse_favors);
          i = 0;
          break;
        }
        localObject = getContext().getString(a.i.wallet_pwd_dialog_more_favors);
        i = 1;
        break;
        if (Util.isNullOrNil((String)localObject)) {
          break label152;
        }
        localStringBuilder.append((String)localObject);
        break label152;
        label335:
        paramTextView.setTextColor(getContext().getResources().getColor(a.c.half_alpha_black));
      }
      label355:
      i = 1;
    }
  }
  
  private void a(Bankcard paramBankcard, CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(71381);
    if (paramBankcard == null)
    {
      Log.e("MicroMsg.WcPayCashierDialog", "setBankcardText bankcard == null");
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.gIH())
    {
      paramCdnImageView.setImageResource(a.e.wallet_balance_manager_logo_small);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.gII())
    {
      this.OuA.a(paramBankcard, paramCdnImageView);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.gIL())
    {
      paramCdnImageView.setImageDrawable(com.tencent.mm.svg.a.a.h(getContext().getResources(), a.h.honey_pay_bank_logo));
      if (!Util.isNullOrNil(paramBankcard.ONV))
      {
        paramCdnImageView.setUseSdcardCache(true);
        paramCdnImageView.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.gKS());
        paramCdnImageView.hr(paramBankcard.ONV, a.h.honey_pay_bank_logo);
        AppMethodBeat.o(71381);
      }
    }
    else
    {
      this.OuA.a(getContext(), paramBankcard, paramCdnImageView);
    }
    AppMethodBeat.o(71381);
  }
  
  private void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, String paramString, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71371);
    Log.i("MicroMsg.WcPayCashierDialog", "set view data: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBankcard });
    this.mPayInfo = paramPayInfo;
    this.Ivh = paramOrders;
    this.OxY = paramFavorPayInfo;
    if (!paramBoolean2) {
      this.Pef = paramBankcard;
    }
    this.Peh = paramBoolean1;
    this.Pek = paramString;
    gMb();
    gMm();
    gMh();
    gMk();
    gMj();
    gMf();
    gMc();
    iT(this.Ivh.field_infos);
    gMd();
    gMg();
    gMe();
    if (paramBoolean2) {
      setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(71360);
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.this.OxY);
          WcPayCashierDialog.this.setOnShowListener(null);
          AppMethodBeat.o(71360);
        }
      });
    }
    AppMethodBeat.o(71371);
  }
  
  private void a(boolean paramBoolean1, int paramInt, final boolean paramBoolean2, final FavorPayInfo paramFavorPayInfo)
  {
    AppMethodBeat.i(71394);
    Log.i("MicroMsg.WcPayCashierDialog", "go to bankcard dialog");
    if (this.Pea != null) {
      this.Pea.dismiss();
    }
    hide();
    this.PdM.fuo();
    int i;
    label62:
    a locala;
    Object localObject3;
    Object localObject4;
    label123:
    Object localObject5;
    if (this.mPayInfo == null)
    {
      i = 0;
      if (this.mPayInfo != null) {
        break label817;
      }
      localObject1 = "";
      af.f(i, (String)localObject1, 11, "");
      this.Pea = new a(this.mContext);
      locala = this.Pea;
      localObject2 = this.mPayInfo;
      localObject3 = this.Ivh;
      localObject4 = this.Pef;
      if (localObject4 != null) {
        break label829;
      }
      localObject1 = "";
      Log.i("MicroMsg.WcPayCashierBankcardDialog", "set view data: %s, %s, %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt) });
      locala.mPayInfo = ((PayInfo)localObject2);
      locala.Ivh = ((Orders)localObject3);
      locala.OxY = paramFavorPayInfo;
      locala.OBu = ((Bankcard)localObject4);
      locala.Pdo = ((Orders)localObject3).OIp;
      locala.Pdp = paramBoolean1;
      locala.Pdq = paramInt;
      if (locala.Pdp) {
        locala.Pdr = false;
      }
      if (locala.mPayInfo.fOY != 8) {
        break label839;
      }
      localObject1 = (ArrayList)ag.Cc(true);
      label241:
      localObject2 = localObject1;
      if (locala.OxY != null)
      {
        if (locala.OxY.OPJ == 0) {
          break label851;
        }
        paramInt = 1;
        label266:
        localObject2 = localObject1;
        if (paramInt != 0)
        {
          if (locala.Pdp) {
            break label856;
          }
          localObject2 = localObject1;
        }
      }
      label286:
      localObject2 = ((List)localObject2).iterator();
      label295:
      if (!((Iterator)localObject2).hasNext()) {
        break label1478;
      }
      localObject3 = (Bankcard)((Iterator)localObject2).next();
      localObject4 = new WcPayCashierBankcardItemLayout(locala.getContext());
      locala.Pdn.add(localObject4);
      locala.Pdl.addView((View)localObject4);
      if (!((Bankcard)localObject3).gIH()) {
        break label961;
      }
      com.tencent.mm.plugin.wallet_core.utils.a.n(((WcPayCashierBankcardItemLayout)localObject4).tCM);
      label370:
      if (!((Bankcard)localObject3).gIH()) {
        break label1165;
      }
      localObject1 = u.gJo().OnP;
      if (Util.isNullOrNil(((Bankcard)localObject1).ONE)) {
        break label1090;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).Pdv.setText(((Bankcard)localObject1).ONE);
      label410:
      localObject1 = "";
      switch (((Bankcard)localObject3).a(locala.Pdo, locala.Ivh))
      {
      default: 
        if (!Util.isNullOrNil(((Bankcard)localObject3).field_tips)) {
          localObject1 = ((Bankcard)localObject3).field_tips;
        }
        label494:
        localObject5 = new SpannableStringBuilder((CharSequence)localObject1);
        if ((!Util.isNullOrNil(((Bankcard)localObject3).field_forbid_title)) && (!Util.isNullOrNil(((Bankcard)localObject3).field_forbid_url)))
        {
          ((SpannableStringBuilder)localObject5).append("  ");
          ((SpannableStringBuilder)localObject5).append(((Bankcard)localObject3).field_forbid_title);
          ((SpannableStringBuilder)localObject5).setSpan(new ForegroundColorSpan(locala.getContext().getResources().getColor(a.c.wallet_forbid_card_link_color)), ((String)localObject1).length() + 2, ((SpannableStringBuilder)localObject5).length(), 34);
          ((WcPayCashierBankcardItemLayout)localObject4).Pdw.setOnClickListener(new a.5(locala, (Bankcard)localObject3));
        }
        if (!Util.isNullOrNil((CharSequence)localObject5))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Pdw.setVisibility(0);
          ((WcPayCashierBankcardItemLayout)localObject4).Pdw.setText((CharSequence)localObject5);
        }
        if ((locala.Pdr) && (Util.isNullOrNil((CharSequence)localObject5)))
        {
          localObject1 = locala.i((Bankcard)localObject3);
          if (((LinkedList)localObject1).size() > 0)
          {
            ((WcPayCashierBankcardItemLayout)localObject4).OYp.setVisibility(0);
            ((WcPayCashierBankcardItemLayout)localObject4).Pdw.setVisibility(8);
            ((WcPayCashierBankcardItemLayout)localObject4).OYp.setWording((LinkedList)localObject1);
          }
        }
        if ((locala.OBu != null) && (((Bankcard)localObject3).field_bindSerial.equals(locala.OBu.field_bindSerial))) {
          ((WcPayCashierBankcardItemLayout)localObject4).Pdx.setChecked(true);
        }
        if (((Bankcard)localObject3).a(locala.Pdo, locala.Ivh) != 0)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Pdx.setChecked(false);
          ((WcPayCashierBankcardItemLayout)localObject4).Pdv.setTextColor(locala.getContext().getResources().getColor(a.c.half_alpha_black));
          ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(false);
        }
        break;
      }
    }
    for (;;)
    {
      ((WcPayCashierBankcardItemLayout)localObject4).setOnClickListener(new a.6(locala, (Bankcard)localObject3));
      break label295;
      i = this.mPayInfo.fOY;
      break;
      label817:
      localObject1 = this.mPayInfo.fwv;
      break label62;
      label829:
      localObject1 = ((Bankcard)localObject4).field_desc;
      break label123;
      label839:
      localObject1 = (ArrayList)ag.Cc(false);
      break label241;
      label851:
      paramInt = 0;
      break label266;
      label856:
      localObject3 = locala.OxY.OPK;
      localObject2 = new ArrayList();
      paramInt = 0;
      if (paramInt < ((ArrayList)localObject1).size())
      {
        localObject4 = (Bankcard)((ArrayList)localObject1).get(paramInt);
        if (Util.isNullOrNil((String)localObject3)) {
          if (!((Bankcard)localObject4).field_bankcardType.equalsIgnoreCase("CFT")) {
            ((ArrayList)localObject2).add(localObject4);
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if (((Bankcard)localObject4).field_bankcardType.equals(localObject3)) {
            ((ArrayList)localObject2).add(localObject4);
          }
        }
      }
      break label286;
      label961:
      if (((Bankcard)localObject3).gII())
      {
        locala.OuA.a((Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).tCM);
        break label370;
      }
      if (((Bankcard)localObject3).gIL())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).tCM.setImageDrawable(com.tencent.mm.svg.a.a.h(locala.getContext().getResources(), a.h.honey_pay_bank_logo));
        if (Util.isNullOrNil(((Bankcard)localObject3).ONV)) {
          break label370;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).tCM.setUseSdcardCache(true);
        ((WcPayCashierBankcardItemLayout)localObject4).tCM.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.gKS());
        ((WcPayCashierBankcardItemLayout)localObject4).tCM.hr(((Bankcard)localObject3).ONV, a.h.honey_pay_bank_logo);
        break label370;
      }
      locala.OuA.a(locala.getContext(), (Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).tCM);
      break label370;
      label1090:
      if (((Bankcard)localObject1).OND >= 0.0D)
      {
        localObject5 = ((WcPayCashierBankcardItemLayout)localObject4).Pdv;
        Context localContext = locala.getContext();
        locala.getContext();
        ((TextView)localObject5).setText(localContext.getString(ah.ijg(), new Object[] { g.F(((Bankcard)localObject1).OND) }));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).Pdv.setText("");
      break label410;
      label1165:
      if (((Bankcard)localObject3).gII())
      {
        localObject1 = u.gJo().OUc;
        if (!Util.isNullOrNil(((Bankcard)localObject1).ONE))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Pdv.setText(((Bankcard)localObject1).ONE);
          break label410;
        }
        if (((Bankcard)localObject1).OND >= 0.0D)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).Pdv.setText(locala.getContext().getString(a.i.wallet_lqt_change_bankcard_balance_left, new Object[] { g.F(((Bankcard)localObject1).OND) }));
          break label410;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).Pdv.setText("");
        break label410;
      }
      if (((Bankcard)localObject3).gIL())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).Pdv.setText(l.b(locala.getContext(), ((Bankcard)localObject3).field_desc, ((WcPayCashierBankcardItemLayout)localObject4).Pdv.getTextSize()));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).Pdv.setText(((Bankcard)localObject3).field_desc);
      break label410;
      localObject1 = ((Bankcard)localObject3).field_forbidWord;
      break label494;
      localObject1 = locala.getContext().getString(a.i.wallet_pay_bankcard_expired);
      break label494;
      localObject1 = locala.getContext().getString(a.i.wallet_pay_bankcard_quota);
      break label494;
      localObject1 = locala.getContext().getString(a.i.wallet_pay_bankcard_maintenance);
      break label494;
      localObject1 = locala.getContext().getString(a.i.wallet_pay_bankcard_insufficient_balance);
      break label494;
      localObject1 = locala.getContext().getString(a.i.wallet_pay_bankcard_domestic);
      break label494;
      localObject1 = locala.getContext().getString(a.i.wallet_pay_bankcard_international);
      break label494;
      localObject1 = locala.getContext().getString(a.i.wallet_pay_bankcard_not_support_bankcard);
      break label494;
      ((WcPayCashierBankcardItemLayout)localObject4).Pdv.setTextColor(locala.getContext().getResources().getColor(a.c.normal_text_color));
      ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(true);
    }
    label1478:
    Object localObject1 = new WcPayCashierBankcardItemLayout(locala.getContext());
    ((WcPayCashierBankcardItemLayout)localObject1).tCM.setVisibility(4);
    ((WcPayCashierBankcardItemLayout)localObject1).Pdv.setText(a.i.wallet_pay_bankcard_add);
    ((WcPayCashierBankcardItemLayout)localObject1).Pdv.setTextColor(locala.getContext().getResources().getColor(a.c.link_color));
    ((WcPayCashierBankcardItemLayout)localObject1).Pdx.setVisibility(8);
    Object localObject2 = locala.gLW();
    if ((locala.Pdr) && (((LinkedList)localObject2).size() > 0))
    {
      ((WcPayCashierBankcardItemLayout)localObject1).OYp.setVisibility(0);
      ((WcPayCashierBankcardItemLayout)localObject1).Pdw.setVisibility(8);
      ((WcPayCashierBankcardItemLayout)localObject1).OYp.setWording((LinkedList)localObject2);
    }
    ((WcPayCashierBankcardItemLayout)localObject1).setOnClickListener(new a.7(locala));
    locala.Pdl.addView((View)localObject1);
    localObject2 = "";
    localObject1 = localObject2;
    if (locala.Ivh != null)
    {
      localObject1 = localObject2;
      if (locala.Ivh.ORd != null)
      {
        localObject1 = localObject2;
        if (locala.Ivh.ORd.size() > 0) {
          localObject1 = locala.getContext().getString(a.i.wallet_change_bankcard_tips, new Object[] { g.d(locala.Ivh.fwy, locala.Ivh.GHz), ((Orders.Commodity)locala.Ivh.ORd.get(0)).desc });
        }
      }
    }
    if ((locala.OxY != null) && (!Util.isNullOrNil(locala.OxY.OPM)))
    {
      locala.Pdm.setVisibility(0);
      locala.Pdm.setText(locala.OxY.OPM);
      locala.OxY.OPM = "";
    }
    for (;;)
    {
      localObject1 = this.Pea.Pdt;
      this.Peq.add(localObject1);
      this.Pea.Pds = new a.a()
      {
        public final void gFG()
        {
          AppMethodBeat.i(71351);
          Log.i("MicroMsg.WcPayCashierDialog", "on click add new bankcard");
          WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.G(WcPayCashierDialog.this);
          if (WcPayCashierDialog.c(WcPayCashierDialog.this) != null) {
            WcPayCashierDialog.c(WcPayCashierDialog.this).gFG();
          }
          WcPayCashierDialog.this.dismiss();
          AppMethodBeat.o(71351);
        }
        
        public final void k(Bankcard paramAnonymousBankcard)
        {
          int i = 0;
          AppMethodBeat.i(71350);
          if (paramAnonymousBankcard == null)
          {
            AppMethodBeat.o(71350);
            return;
          }
          Log.i("MicroMsg.WcPayCashierDialog", "on select bankcard: %s, %s", new Object[] { paramAnonymousBankcard.field_bankName, paramAnonymousBankcard.field_bindSerial });
          if ((WcPayCashierDialog.this.Pef == null) || (!paramAnonymousBankcard.field_bindSerial.equals(WcPayCashierDialog.this.Pef.field_bindSerial)))
          {
            if (WcPayCashierDialog.this.mPayInfo != null) {
              break label202;
            }
            if (WcPayCashierDialog.this.mPayInfo != null) {
              break label216;
            }
          }
          label202:
          label216:
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.fwv)
          {
            af.f(i, str, 13, paramAnonymousBankcard.field_bindSerial);
            WcPayCashierDialog.this.Pef = paramAnonymousBankcard;
            WcPayCashierDialog.this.OxY = paramFavorPayInfo;
            WcPayCashierDialog.u(WcPayCashierDialog.this);
            WcPayCashierDialog.p(WcPayCashierDialog.this);
            WcPayCashierDialog.q(WcPayCashierDialog.this);
            WcPayCashierDialog.v(WcPayCashierDialog.this);
            WcPayCashierDialog.w(WcPayCashierDialog.this);
            WcPayCashierDialog.E(WcPayCashierDialog.this);
            WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
            WcPayCashierDialog.G(WcPayCashierDialog.this);
            WcPayCashierDialog.this.show();
            AppMethodBeat.o(71350);
            return;
            i = WcPayCashierDialog.this.mPayInfo.fOY;
            break;
          }
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(71352);
          Log.i("MicroMsg.WcPayCashierDialog", "on bankcard dialog cancel");
          WcPayCashierDialog.F(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.G(WcPayCashierDialog.this);
          WcPayCashierDialog.this.show();
          AppMethodBeat.o(71352);
        }
      };
      this.Pea.show();
      AppMethodBeat.o(71394);
      return;
      if (locala.Pdq != 0)
      {
        locala.Pdm.setVisibility(0);
        locala.Pdm.setText((CharSequence)localObject1);
      }
      else
      {
        locala.Pdm.setVisibility(8);
      }
    }
  }
  
  private static boolean a(PayInfo paramPayInfo)
  {
    return (paramPayInfo != null) && ((paramPayInfo.fOY == 31) || (paramPayInfo.fOY == 32) || (paramPayInfo.fOY == 33));
  }
  
  private void amK(int paramInt)
  {
    AppMethodBeat.i(71386);
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.PdN.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.PdO.getLayoutParams();
    if (paramInt == 0) {
      localLayoutParams1.topMargin = PdG;
    }
    for (localLayoutParams2.topMargin = PdG;; localLayoutParams2.topMargin = PdF)
    {
      this.PdN.setLayoutParams(localLayoutParams1);
      this.PdO.setLayoutParams(localLayoutParams2);
      this.PdQ.setVisibility(paramInt);
      AppMethodBeat.o(71386);
      return;
      localLayoutParams1.topMargin = PdE;
    }
  }
  
  private static void bf(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71390);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
    if ((locala.type() == 1) && ((locala.eon()) || (locala.eoq())) && (com.tencent.mm.plugin.soter.e.b.gat()) && (com.tencent.mm.plugin.soter.e.b.gas()) && (com.tencent.soter.core.a.ioE() == 0))
    {
      Log.i("MicroMsg.WcPayCashierDialog", "may treble init error");
      com.tencent.mm.plugin.report.service.h.IzE.el(1104, 23);
      if (locala.type() == 2)
      {
        if (com.tencent.soter.core.a.ioE() != 0) {
          break label246;
        }
        com.tencent.mm.plugin.report.service.h.IzE.el(1104, 28);
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        com.tencent.mm.plugin.report.service.h.IzE.el(1104, 27);
      }
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.h.IzE.el(1104, 33);
      }
      AppMethodBeat.o(71390);
      return;
      if (locala.type() != 2) {
        break;
      }
      if (com.tencent.soter.core.a.ioE() == 1)
      {
        if (!com.tencent.soter.core.a.ioG())
        {
          Log.i("MicroMsg.WcPayCashierDialog", "soter service disconnected");
          com.tencent.mm.plugin.report.service.h.IzE.el(1104, 24);
          break;
        }
        if (paramBoolean1) {
          break;
        }
        Log.i("MicroMsg.WcPayCashierDialog", "soter treble key error");
        com.tencent.mm.plugin.report.service.h.IzE.el(1104, 25);
        break;
      }
      if (paramBoolean1) {
        break;
      }
      Log.i("MicroMsg.WcPayCashierDialog", "soter1.0 key error");
      com.tencent.mm.plugin.report.service.h.IzE.el(1104, 26);
      break;
      label246:
      com.tencent.mm.plugin.report.service.h.IzE.el(1104, 31);
    }
  }
  
  private void gLZ()
  {
    AppMethodBeat.i(71366);
    if (!this.PdU.isShown())
    {
      this.PdU.setVisibility(0);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.wxpay.a.a.sight_slide_bottom_in);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.PdU.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71366);
  }
  
  private void gMa()
  {
    AppMethodBeat.i(71367);
    if (this.PdU.isShown())
    {
      this.PdU.setVisibility(8);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.wxpay.a.a.sight_slide_bottom_out);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.PdU.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71367);
  }
  
  private void gMb()
  {
    AppMethodBeat.i(71373);
    Object localObject1 = com.tencent.mm.plugin.wallet_core.ui.f.OVk.a(this.Ivh);
    if (localObject1 != null) {
      if ((this.OxY != null) && (this.Pef != null)) {
        if (!this.Pef.field_bankcardType.equalsIgnoreCase("CFT")) {
          break label452;
        }
      }
    }
    label195:
    label452:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WcPayCashierDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { this.OxY.OPI, Boolean.valueOf(bool) });
      String str = ((com.tencent.mm.plugin.wallet_core.ui.e)localObject1).cU(this.OxY.OPI, bool);
      Log.i("MicroMsg.WcPayCashierDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str });
      Object localObject3 = ((com.tencent.mm.plugin.wallet_core.ui.e)localObject1).bhq(str);
      Object localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.e)localObject1).cT(str, true);
      e.a locala1 = (e.a)((Map)localObject3).get(this.Pef.field_bindSerial);
      e.a locala2 = (e.a)((Map)localObject2).get(this.Pef.field_bankcardType);
      j localj = ((com.tencent.mm.plugin.wallet_core.ui.e)localObject1).cS(str, bool);
      if (localj == null)
      {
        localObject1 = "";
        if (locala1 != null) {
          break label289;
        }
        localObject2 = "";
        if (locala2 != null) {
          break label298;
        }
      }
      for (localObject3 = "";; localObject3 = locala2.toString())
      {
        Log.i("MicroMsg.WcPayCashierDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", new Object[] { localObject1, localObject2, localObject3 });
        if ((locala1 == null) || (locala1.OVi == null) || (Util.isNullOrNil(locala1.OVi.OwC))) {
          break label308;
        }
        this.OxY.OPI = locala1.OVi.OwC;
        AppMethodBeat.o(71373);
        return;
        localObject1 = localj.OwC;
        break;
        localObject2 = locala1.toString();
        break label195;
      }
      if ((locala2 != null) && (locala2.OVi != null) && (!Util.isNullOrNil(locala2.OVi.OwC)))
      {
        this.OxY.OPI = locala2.OVi.OwC;
        AppMethodBeat.o(71373);
        return;
      }
      if (localj != null)
      {
        this.OxY.OPI = localj.OwC;
        AppMethodBeat.o(71373);
        return;
      }
      this.OxY.OPI = str;
      AppMethodBeat.o(71373);
      return;
      if (this.Ivh.ORe != null)
      {
        this.OxY = ((com.tencent.mm.plugin.wallet_core.ui.e)localObject1).bhv(((com.tencent.mm.plugin.wallet_core.ui.e)localObject1).bhw(this.Ivh.ORe.Owm));
        AppMethodBeat.o(71373);
        return;
        Log.d("MicroMsg.WcPayCashierDialog", "getFavorLogicHelper null");
      }
      AppMethodBeat.o(71373);
      return;
    }
  }
  
  private void gMc()
  {
    AppMethodBeat.i(71374);
    if (this.Pej)
    {
      Log.i("MicroMsg.WcPayCashierDialog", "don't show foreign currency");
      if (this.PdY != null)
      {
        this.PdL.removeView(this.PdY);
        this.PdY = null;
      }
      AppMethodBeat.o(71374);
      return;
    }
    if ((!Util.isNullOrNil(this.Ivh.ORv)) && (!Util.isNullOrNil(this.Ivh.ORw)))
    {
      this.PdY = new WcPayCashierDetailItemLayout(getContext());
      this.PdL.addView(this.PdY, 0);
      this.PdY.PdA.setVisibility(8);
      this.PdY.PdB.setVisibility(8);
      this.PdY.InN.setText(a.i.wc_pay_foreign_currency_text);
      this.PdY.gLY();
      if ((this.Ivh.ORv.equals("CNY")) && (!Util.isNullOrNil(this.Ivh.ORu)))
      {
        localStringBuilder = new StringBuilder(this.Ivh.ORw);
        localStringBuilder.append(this.Ivh.ORu);
        if ((!Util.isNullOrNil(this.Ivh.ORy)) && (!Util.isNullOrNil(this.Ivh.ORz))) {
          localStringBuilder.append(String.format("(%s%s)", new Object[] { this.Ivh.ORz, this.Ivh.ORx }));
        }
        this.PdY.uzI.setText(localStringBuilder);
        AppMethodBeat.o(71374);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(this.Ivh.ORw);
      localStringBuilder.append(this.Ivh.ORu);
      this.PdY.uzI.setText(localStringBuilder);
    }
    AppMethodBeat.o(71374);
  }
  
  private void gMd()
  {
    AppMethodBeat.i(71375);
    com.tencent.mm.plugin.wallet_core.ui.e locale = com.tencent.mm.plugin.wallet_core.ui.f.OVk.a(this.Ivh);
    if ((this.OxY == null) || ((locale != null) && (!locale.gLd())))
    {
      this.PdL.removeView(this.PdX);
      this.PdX = null;
      AppMethodBeat.o(71375);
      return;
    }
    if (this.PdX == null)
    {
      this.PdX = new WcPayCashierDetailItemLayout(getContext());
      this.PdL.addView(this.PdX);
      this.PdX.InN.setText(a.i.wc_pay_favor_text);
      this.PdX.PdA.setVisibility(8);
      this.PdX.PdB.setVisibility(0);
      this.PdX.uzI.setTextColor(getContext().getResources().getColor(a.c.Orange));
      this.PdX.gLY();
      this.PdX.setOnClickListener(new aa()
      {
        public final void cOw()
        {
          AppMethodBeat.i(71340);
          int i;
          if (WcPayCashierDialog.this.mPayInfo == null)
          {
            i = 0;
            if (WcPayCashierDialog.this.mPayInfo != null) {
              break label95;
            }
          }
          label95:
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.fwv)
          {
            af.f(i, str, 12, "");
            WcPayCashierDialog.this.hide();
            if (WcPayCashierDialog.o(WcPayCashierDialog.this) == null) {
              break label109;
            }
            WcPayCashierDialog.o(WcPayCashierDialog.this).dismiss();
            WcPayCashierDialog.a(WcPayCashierDialog.this, null);
            AppMethodBeat.o(71340);
            return;
            i = WcPayCashierDialog.this.mPayInfo.fOY;
            break;
          }
          label109:
          WcPayCashierDialog.a(WcPayCashierDialog.this, o.a(WcPayCashierDialog.this.getContext(), WcPayCashierDialog.this.Ivh, WcPayCashierDialog.this.OxY.OPI, new o.b()new DialogInterface.OnCancelListener
          {
            public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
            {
              int i = 0;
              AppMethodBeat.i(71338);
              Log.i("MicroMsg.WcPayCashierDialog", "on select favor: %s", new Object[] { paramAnonymous2FavorPayInfo.OPI });
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              Object localObject;
              if (WcPayCashierDialog.this.mPayInfo == null)
              {
                if (WcPayCashierDialog.this.mPayInfo != null) {
                  break label227;
                }
                localObject = "";
                label66:
                af.f(i, (String)localObject, 15, paramAnonymous2FavorPayInfo.OPI);
                localObject = com.tencent.mm.plugin.wallet_core.ui.e.cJ(paramAnonymous2FavorPayInfo.OPJ, paramAnonymous2FavorPayInfo.OPK);
                WcPayCashierDialog.this.OxY.OPM = "";
                if (!com.tencent.mm.plugin.wallet_core.ui.e.a(paramAnonymous2FavorPayInfo, WcPayCashierDialog.this.Pef)) {
                  break label267;
                }
                if (((List)localObject).size() != 0) {
                  break label244;
                }
                paramAnonymous2FavorPayInfo.OPM = WcPayCashierDialog.this.getContext().getString(a.i.wallet_favor_need_bind_bankcard);
                label150:
                WcPayCashierDialog.b(WcPayCashierDialog.this, paramAnonymous2FavorPayInfo);
              }
              for (;;)
              {
                WcPayCashierDialog.p(WcPayCashierDialog.this);
                WcPayCashierDialog.q(WcPayCashierDialog.this);
                WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.r(WcPayCashierDialog.this).uzI);
                AppMethodBeat.o(71338);
                return;
                i = WcPayCashierDialog.this.mPayInfo.fOY;
                break;
                label227:
                localObject = WcPayCashierDialog.this.mPayInfo.fwv;
                break label66;
                label244:
                paramAnonymous2FavorPayInfo.OPM = WcPayCashierDialog.this.getContext().getString(a.i.wallet_favor_need_change_bankcard);
                break label150;
                label267:
                WcPayCashierDialog.this.OxY = paramAnonymous2FavorPayInfo;
                WcPayCashierDialog.this.show();
              }
            }
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(71339);
              Log.i("MicroMsg.WcPayCashierDialog", "on cancel");
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              WcPayCashierDialog.this.show();
              AppMethodBeat.o(71339);
            }
          }));
          AppMethodBeat.o(71340);
        }
      });
    }
    H(this.PdX.uzI);
    AppMethodBeat.o(71375);
  }
  
  private void gMe()
  {
    AppMethodBeat.i(71378);
    if ((this.PdL.getChildCount() == 0) && (this.PdW.getVisibility() == 8))
    {
      Log.d("MicroMsg.WcPayCashierDialog", "invisible divider");
      this.EQr.setVisibility(8);
      AppMethodBeat.o(71378);
      return;
    }
    this.EQr.setVisibility(0);
    AppMethodBeat.o(71378);
  }
  
  private void gMf()
  {
    AppMethodBeat.i(71379);
    if (!this.Pej)
    {
      if (this.PdV != null)
      {
        this.PdL.removeView(this.PdV);
        this.PdV = null;
      }
      AppMethodBeat.o(71379);
      return;
    }
    Object localObject1;
    if (this.PdV == null)
    {
      this.PdV = new WcPayCashierDetailItemLayout(getContext());
      this.PdL.addView(this.PdV, 0);
      this.PdV.InN.setText(a.i.wc_pay_origin_fee_text);
      this.PdV.PdA.setVisibility(8);
      this.PdV.PdB.setVisibility(8);
      this.PdV.gLY();
      localObject1 = g.azI(7);
    }
    try
    {
      this.PdV.uzI.setTypeface(Typeface.createFromAsset(getContext().getAssets(), (String)localObject1));
      this.PdV.uzI.getPaint().setFlags(16);
      str = "";
      localObject1 = str;
      if (!Util.isNullOrNil(this.Ivh.ORu))
      {
        localObject1 = str;
        if (!Util.isNullOrNil(this.Ivh.ORw)) {
          localObject1 = String.format("%s%s", new Object[] { this.Ivh.ORw, this.Ivh.ORu });
        }
      }
      str = g.d(this.Ivh.fwy, this.Ivh.GHz);
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = String.format("%s(%s)", new Object[] { str, localObject1 });
        this.PdV.uzI.setText((CharSequence)localObject1);
        AppMethodBeat.o(71379);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        Log.e("MicroMsg.WcPayCashierDialog", "setTypeface() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        continue;
        Object localObject2 = str;
      }
    }
  }
  
  private void gMg()
  {
    AppMethodBeat.i(71380);
    if (!this.Peh)
    {
      Log.i("MicroMsg.WcPayCashierDialog", "can not change pay way");
      this.PdW.setVisibility(8);
      AppMethodBeat.o(71380);
      return;
    }
    this.PdW.setVisibility(0);
    this.PdW.InN.setText(a.i.wc_pay_payway_text);
    this.PdW.PdA.setVisibility(0);
    this.PdW.PdB.setVisibility(0);
    this.PdW.gLY();
    this.PdW.setOnClickListener(new WcPayCashierDialog.4(this));
    this.PdW.PdA.setImageBitmap(null);
    a(this.Pef, this.PdW.PdA);
    if (this.Pef == null) {}
    for (String str = "";; str = this.Pef.field_desc)
    {
      Object localObject = str;
      if (this.Pef != null)
      {
        localObject = str;
        if (this.Pef.gIL()) {
          localObject = l.c(this.mContext, str);
        }
      }
      this.PdW.ai((CharSequence)localObject);
      AppMethodBeat.o(71380);
      return;
    }
  }
  
  private void gMh()
  {
    AppMethodBeat.i(71382);
    gMi();
    gMl();
    AppMethodBeat.o(71382);
  }
  
  private void gMi()
  {
    AppMethodBeat.i(71383);
    Object localObject2 = "";
    Object localObject1;
    if (this.Pen)
    {
      localObject1 = this.Pel;
      this.PdJ.setText((CharSequence)localObject1);
      AppMethodBeat.o(71383);
      return;
    }
    if (this.mPayInfo.lfu == null)
    {
      localObject1 = "";
      label52:
      if (Util.isNullOrNil((String)localObject1)) {
        break label222;
      }
    }
    for (;;)
    {
      if ((!Util.isNullOrNil((String)localObject1)) || (this.Ivh == null) || (this.Ivh.ORd == null)) {
        break label1145;
      }
      Object localObject3 = (Orders.Commodity)this.Ivh.ORd.get(0);
      if (localObject3 == null) {
        break label1181;
      }
      localObject1 = ((Orders.Commodity)localObject3).GHo;
      localObject2 = localObject1;
      if (a(this.mPayInfo))
      {
        localObject2 = localObject1;
        if (!Util.isNullOrNil((String)localObject1)) {
          localObject2 = (String)localObject1 + "\n";
        }
        localObject2 = (String)localObject2 + ((Orders.Commodity)localObject3).desc;
      }
      localObject1 = localObject2;
      if (!Util.isNullOrNil((String)localObject2)) {
        break;
      }
      localObject1 = ((Orders.Commodity)localObject3).desc;
      break;
      localObject1 = this.mPayInfo.lfu.getString("extinfo_key_19", "");
      break label52;
      label222:
      if ((this.mPayInfo.fOY == 32) || (this.mPayInfo.fOY == 33))
      {
        String str1 = this.mPayInfo.lfu.getString("extinfo_key_5", "");
        String str2 = this.mPayInfo.lfu.getString("extinfo_key_1", "");
        localObject3 = getContext().getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
        localObject1 = localObject2;
        if (!Util.isNullOrNil(str1))
        {
          localObject3 = str1;
          localObject1 = str1;
        }
        if (!Util.isNullOrNil(str2))
        {
          localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwg(str2);
          if (localObject2 != null)
          {
            localObject1 = ((as)localObject2).ays();
            localObject2 = new StringBuilder().append(g.bCw((String)localObject1));
            if (Util.isNullOrNil(this.mPayInfo.Imv)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.Imv + ")")
            {
              localObject1 = Util.safeFormatString((String)localObject3, new Object[] { (String)localObject1 });
              break;
            }
          }
          Log.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(str2)));
        }
        else
        {
          Log.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
        }
      }
      else
      {
        int i;
        if (this.mPayInfo.fOY == 31)
        {
          localObject1 = this.mPayInfo.lfu.getString("extinfo_key_1", "");
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwg((String)localObject1);
            if (localObject3 != null)
            {
              localObject1 = ((as)localObject3).ayr();
              localObject2 = getContext();
              i = a.i.wallet_pwd_dialog_remittance_desc_txt;
              localObject3 = new StringBuilder().append((String)localObject1);
              if (Util.isNullOrNil(this.mPayInfo.Imv)) {}
              for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.Imv + ")")
              {
                localObject1 = ((Context)localObject2).getString(i, new Object[] { (String)localObject1 });
                break;
              }
            }
            Log.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
            localObject1 = localObject2;
          }
          else
          {
            Log.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            localObject1 = localObject2;
          }
        }
        else if (this.mPayInfo.fOY == 42)
        {
          localObject1 = this.mPayInfo.lfu.getString("extinfo_key_1", "");
          if (!Util.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.kernel.h.aHH();
            localObject3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwg((String)localObject1);
            if (localObject3 != null)
            {
              localObject1 = ((as)localObject3).ayr();
              localObject2 = getContext();
              i = a.i.wallet_pwd_dialog_aa_desc_txt;
              localObject3 = new StringBuilder().append((String)localObject1);
              if (Util.isNullOrNil(this.mPayInfo.Imv)) {}
              for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.Imv + ")")
              {
                localObject1 = ((Context)localObject2).getString(i, new Object[] { (String)localObject1 });
                break;
              }
            }
            Log.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(localObject1)));
            localObject1 = localObject2;
          }
          else
          {
            Log.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            localObject1 = localObject2;
          }
        }
        else if (this.mPayInfo.fOY == 48)
        {
          localObject1 = getContext().getString(a.i.qr_reward_grant_btn);
        }
        else if (this.mPayInfo.fOY == 49)
        {
          localObject1 = this.mPayInfo.lfu.getString("extinfo_key_1", "");
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject1 = getContext().getString(a.i.wallet_pwd_dialog_remittance_desc_txt, new Object[] { localObject1 });
          }
          else
          {
            Log.e("MicroMsg.WcPayCashierDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.fOY) });
            localObject1 = localObject2;
          }
        }
        else if (this.mPayInfo.fOY == 56)
        {
          localObject1 = this.mPayInfo.lfu.getString("extinfo_key_12", "");
          if (Util.isNullOrNil((String)localObject1))
          {
            Log.e("MicroMsg.WcPayCashierDialog", "title is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.fOY) });
            localObject1 = localObject2;
          }
        }
        else if ((this.mPayInfo.fOY == 45) || (this.mPayInfo.fOY == 52))
        {
          localObject1 = getContext().getString(a.i.wallet_lqt_save_title);
        }
        else
        {
          localObject1 = localObject2;
          if (this.mPayInfo.fOY == 11) {
            localObject1 = getContext().getString(a.i.wallet_balance_save_title2);
          }
        }
      }
    }
    label1145:
    localObject2 = new StringBuilder("orders null?:");
    if (this.Ivh == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.w("MicroMsg.WcPayCashierDialog", bool);
      label1181:
      break;
    }
  }
  
  private void gMj()
  {
    AppMethodBeat.i(71384);
    if (!Util.isNullOrNil(this.Pek))
    {
      this.Pbw.setText(this.Pek);
      this.Pbw.setVisibility(0);
      AppMethodBeat.o(71384);
      return;
    }
    this.Pbw.setVisibility(8);
    AppMethodBeat.o(71384);
  }
  
  private void gMk()
  {
    AppMethodBeat.i(71385);
    if ((this.Pei) && (this.Ivh.ORe.Owz != null) && (this.Ivh.ORe.Owz.OvV == 1))
    {
      final com.tencent.mm.plugin.wallet.a.b localb = this.Ivh.ORe.Owz;
      this.PdR.setUrl(localb.Owc);
      this.PdS.setText(localb.OvX);
      if (!Util.isNullOrNil(localb.OvY)) {
        this.PdS.setTextColor(com.tencent.mm.plugin.wallet_core.utils.k.cW(localb.OvY, true));
      }
      this.PdT.setText(localb.OvZ);
      if (!Util.isNullOrNil(localb.Owa)) {
        this.PdT.setTextColor(com.tencent.mm.plugin.wallet_core.utils.k.cW(localb.Owa, true));
      }
      this.PdT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71342);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.WcPayCashierDialog", "click bank favor btn");
          WcPayCashierDialog.t(WcPayCashierDialog.this);
          WcPayCashierDialog.this.Pef = u.gJo().bgV(localb.OvU.GGC);
          paramAnonymousView = com.tencent.mm.plugin.wallet_core.ui.f.OVk.a(WcPayCashierDialog.this.Ivh).bhv(localb.OvW);
          Log.i("MicroMsg.WcPayCashierDialog", "set favor info: %s", new Object[] { paramAnonymousView.OPI });
          if (paramAnonymousView.OPI.equals("0")) {
            WcPayCashierDialog.u(WcPayCashierDialog.this);
          }
          for (;;)
          {
            WcPayCashierDialog.p(WcPayCashierDialog.this);
            WcPayCashierDialog.q(WcPayCashierDialog.this);
            WcPayCashierDialog.v(WcPayCashierDialog.this);
            WcPayCashierDialog.w(WcPayCashierDialog.this);
            WcPayCashierDialog.x(WcPayCashierDialog.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71342);
            return;
            WcPayCashierDialog.this.OxY = paramAnonymousView;
          }
        }
      });
      amK(0);
      AppMethodBeat.o(71385);
      return;
    }
    amK(8);
    AppMethodBeat.o(71385);
  }
  
  private void gMl()
  {
    AppMethodBeat.i(71387);
    Object localObject1;
    if (this.Pen) {
      localObject1 = this.Pem;
    }
    for (;;)
    {
      this.PdK.setText((CharSequence)localObject1);
      AppMethodBeat.o(71387);
      return;
      Object localObject2 = com.tencent.mm.plugin.wallet_core.ui.f.OVk.a(this.Ivh);
      localObject1 = g.d(this.Ivh.fwy, this.Ivh.GHz);
      this.Pej = false;
      if (localObject2 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.wallet_core.ui.e)localObject2).bhs(this.OxY.OPI);
        localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.e)localObject2).gLg();
        if ((localObject1 != null) && (((j)localObject1).Owt > 0.0D))
        {
          this.Pej = true;
          localObject1 = g.d(((j)localObject1).Ows, this.Ivh.GHz);
        }
        else if ((localObject1 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = g.d(((j)localObject1).Ows, this.Ivh.GHz);
        }
        else
        {
          localObject1 = g.d(this.Ivh.fwy, this.Ivh.GHz);
        }
      }
    }
  }
  
  private void gMm()
  {
    AppMethodBeat.i(71388);
    gMn();
    Log.i("MicroMsg.WcPayCashierDialog", "use touch pay: %s", new Object[] { Integer.valueOf(this.Ivh.ORa) });
    if (this.Pec == 0)
    {
      boolean bool;
      if (this.Ped > 0) {
        bool = false;
      }
      for (;;)
      {
        Cq(bool);
        AppMethodBeat.o(71388);
        return;
        if (this.Pee == 1)
        {
          this.PdP.setVisibility(8);
          bool = true;
        }
        else
        {
          if (this.Pee != 3) {
            break;
          }
          this.PdP.setText(a.i.wallet_finger_print_not_recorded);
          this.PdP.setVisibility(0);
          bool = true;
        }
      }
      if (this.mPayInfo.Rzi == 100102)
      {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViC, Boolean.TRUE);
        com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
        locala.rD(false);
        locala.rE(false);
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViA, Boolean.FALSE);
        this.PdP.setText(a.i.wallet_fingerprint_severe_error_hint);
      }
      for (;;)
      {
        this.PdP.setTextColor(getContext().getResources().getColor(a.c.wallet_pwd_bank_card_text_color));
        this.PdP.setVisibility(0);
        bool = true;
        break;
        this.PdP.setText(a.i.wallet_finger_print_not_recorded);
      }
    }
    if (this.Pec == 1)
    {
      gMo();
      AppMethodBeat.o(71388);
      return;
    }
    if (this.Pec == 2) {
      gMp();
    }
    AppMethodBeat.o(71388);
  }
  
  private void gMn()
  {
    AppMethodBeat.i(71389);
    Log.i("MicroMsg.WcPayCashierDialog", "update verify way: %s", new Object[] { Integer.valueOf(this.Ivh.ORa) });
    com.tencent.mm.plugin.fingerprint.d.a locala;
    boolean bool3;
    if (this.Ivh.ORa == 1)
    {
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.eos()) && (locala.eot()) && (!locala.eoo()) && (locala.eon()) && (locala.eow()))
      {
        this.Ped = 1;
        bool3 = p.ByH.ByJ;
        if ((u.gJo() == null) || (this.Ped <= 0)) {
          break label484;
        }
      }
    }
    label148:
    label332:
    label484:
    for (boolean bool2 = locala.eoz();; bool2 = true)
    {
      bf(bool2, bool3);
      boolean bool1;
      if (!bool3)
      {
        bool1 = true;
        bool2 &= bool1;
        if (bool2) {
          break label332;
        }
        p.ByH.ByJ = true;
        this.Ped = 0;
        this.Pee = 3;
        this.mPayInfo.ORb = true;
        p.ByH.ByJ = true;
      }
      for (;;)
      {
        this.Pec = this.Ped;
        Log.i("MicroMsg.WcPayCashierDialog", "keystatus: %s, errcode: %s, payway: %s, supportMode: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(this.mPayInfo.Rzi), Integer.valueOf(this.Pec), Integer.valueOf(this.Ped) });
        AppMethodBeat.o(71389);
        return;
        if ((locala.eoA()) && (locala.eoB()) && (!locala.eop()) && (locala.eoq()) && (locala.eow()))
        {
          this.Ped = 2;
          break;
        }
        this.Ped = 0;
        this.Pee = 2;
        break;
        bool1 = false;
        break label148;
        if ((this.mPayInfo.Rzi == 100000) || (this.mPayInfo.Rzi == 100102))
        {
          if (this.mPayInfo.Rzi == 100000) {
            this.mPayInfo.PbP = 0;
          }
          this.Ped = 0;
          this.Pee = 4;
        }
      }
      this.Pec = 0;
      this.Ped = 0;
      this.Pee = 1;
      locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
      if ((locala.eos()) && (locala.eot()) && (!locala.eoo()) && (locala.eon()))
      {
        Log.w("MicroMsg.WcPayCashierDialog", "wired case");
        com.tencent.mm.plugin.report.service.h.IzE.el(1104, 2);
      }
      AppMethodBeat.o(71389);
      return;
    }
  }
  
  private void gMo()
  {
    AppMethodBeat.i(71392);
    this.Pec = 1;
    this.mPayInfo.PbP = 1;
    this.PdN.setVisibility(8);
    this.PdO.setVisibility(0);
    this.PdM.fuo();
    gMa();
    this.PdH.setVisibility(8);
    this.PdI.setText(a.i.wallet_pwd_pay_mode);
    AppMethodBeat.o(71392);
  }
  
  private void gMp()
  {
    AppMethodBeat.i(71393);
    this.Pec = 2;
    this.mPayInfo.PbP = 1;
    this.PdN.setVisibility(8);
    this.PdO.setVisibility(0);
    this.PdM.fuo();
    gMa();
    this.PdH.setVisibility(8);
    this.PdI.setText(a.i.wallet_pwd_pay_mode);
    AppMethodBeat.o(71393);
  }
  
  private void iT(List<eqh> paramList)
  {
    AppMethodBeat.i(71372);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        eqh localeqh = (eqh)paramList.next();
        WcPayCashierDetailItemLayout localWcPayCashierDetailItemLayout = new WcPayCashierDetailItemLayout(getContext());
        localWcPayCashierDetailItemLayout.PdA.setVisibility(8);
        if ((localeqh.UsK != null) && (localeqh.UsK.size() > 0)) {
          com.tencent.mm.plugin.wallet_core.utils.k.a(localWcPayCashierDetailItemLayout.InN, (erh)localeqh.UsK.get(0), null);
        }
        if ((localeqh.UsL != null) && (localeqh.UsL.size() > 0))
        {
          com.tencent.mm.plugin.wallet_core.utils.k.a(localWcPayCashierDetailItemLayout.uzI, (erh)localeqh.UsL.get(0), null);
          label149:
          if (localeqh.UsM == null) {
            break label267;
          }
          int i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
          int j = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 16);
          com.tencent.mm.plugin.wallet_core.utils.k.a(localWcPayCashierDetailItemLayout.PdB, localeqh.UsM, a.h.arrow_right, i, j, true);
          localWcPayCashierDetailItemLayout.PdB.setVisibility(0);
        }
        for (;;)
        {
          localWcPayCashierDetailItemLayout.gLY();
          if (localeqh.RGh != null) {
            localWcPayCashierDetailItemLayout.setOnClickListener(new WcPayCashierDialog.2(this, localeqh));
          }
          this.PdL.addView(localWcPayCashierDetailItemLayout);
          break;
          localWcPayCashierDetailItemLayout.uzI.setVisibility(8);
          localWcPayCashierDetailItemLayout.InN.setMaxWidth(2147483647);
          break label149;
          label267:
          localWcPayCashierDetailItemLayout.PdB.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(71372);
  }
  
  public final void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71370);
    a(paramPayInfo, paramOrders, paramFavorPayInfo, "", paramBankcard, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(71370);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, List<eqh> paramList)
  {
    AppMethodBeat.i(71369);
    this.Pel = paramString1;
    this.Pem = paramString2;
    this.Pek = paramString3;
    this.Pen = true;
    this.Peh = false;
    gMm();
    gMh();
    gMj();
    iT(paramList);
    gMg();
    gMe();
    AppMethodBeat.o(71369);
  }
  
  @t(jl=h.a.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(71368);
    Log.i("MicroMsg.WcPayCashierDialog", "activity paused, release and dismiss");
    this.PdM.fuo();
    AppMethodBeat.o(71368);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71363);
    super.onCreate(paramBundle);
    setContentView(this.qoE);
    paramBundle = getWindow();
    paramBundle.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    paramBundle.setAttributes(localLayoutParams);
    paramBundle.addFlags(67108864);
    if (g.ijx()) {
      paramBundle.addFlags(8192);
    }
    com.tencent.mm.compatible.util.d.qV(21);
    AppMethodBeat.o(71363);
  }
  
  public void show()
  {
    AppMethodBeat.i(71376);
    super.show();
    AppMethodBeat.o(71376);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard);
    
    public abstract void gFG();
    
    public abstract void onCancel();
  }
  
  public static abstract interface b
  {
    public abstract void gLX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog
 * JD-Core Version:    0.7.0.1
 */