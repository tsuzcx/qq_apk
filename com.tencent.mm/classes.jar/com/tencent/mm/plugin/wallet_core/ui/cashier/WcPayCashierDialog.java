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
import androidx.lifecycle.j.a;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.fingerprint.mgr.a.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.f.a;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.plugin.wallet_core.ui.p.b;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.dtm;
import com.tencent.mm.protocal.protobuf.etg;
import com.tencent.mm.protocal.protobuf.fll;
import com.tencent.mm.protocal.protobuf.fmp;
import com.tencent.mm.protocal.protobuf.fxx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.wallet_core.model.ag;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class WcPayCashierDialog
  extends com.tencent.mm.ui.widget.a.i
  implements androidx.lifecycle.p
{
  public static final int VUk;
  public static final int VUl;
  public static final int VUm;
  public static final int VUn;
  private View KKP;
  public Orders OsJ;
  private TextView VSc;
  private ImageView VTR;
  private TextView VUA;
  private Button VUB;
  private ViewGroup VUC;
  private WcPayCashierDetailItemLayout VUD;
  private WcPayCashierDetailItemLayout VUE;
  private WcPayCashierDetailItemLayout VUF;
  private WcPayCashierDetailItemLayout VUG;
  private WcPayCashierFingerprintDialog VUH;
  private a VUI;
  private com.tencent.mm.plugin.wallet_core.ui.p VUJ;
  private int VUK;
  private int VUL;
  private int VUM;
  public Bankcard VUN;
  private boolean VUO;
  private boolean VUP;
  private boolean VUQ;
  private boolean VUR;
  private String VUS;
  private String VUT;
  private String VUU;
  private boolean VUV;
  private boolean VUW;
  public a VUX;
  List<b> VUY;
  private TextView VUo;
  private TextView VUp;
  private TextView VUq;
  private ViewGroup VUr;
  private WalletTextView VUs;
  private ViewGroup VUt;
  private EditHintPasswdView VUu;
  private ViewGroup VUv;
  private Button VUw;
  private TextView VUx;
  private ViewGroup VUy;
  private CdnImageView VUz;
  private com.tencent.mm.plugin.wallet_core.utils.b VjO;
  public FavorPayInfo Vnj;
  private Context mContext;
  private MyKeyboardWindow mKeyboard;
  public PayInfo mPayInfo;
  private ViewGroup tth;
  
  static
  {
    AppMethodBeat.i(71415);
    VUk = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 30);
    VUl = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    VUm = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    VUn = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 24);
    AppMethodBeat.o(71415);
  }
  
  public WcPayCashierDialog(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(71361);
    this.VUK = 0;
    this.VUL = 0;
    this.VUM = 0;
    this.mPayInfo = new PayInfo();
    this.OsJ = new Orders();
    this.VUO = false;
    this.VUQ = true;
    this.VUY = new ArrayList();
    this.mContext = paramContext;
    this.tth = ((ViewGroup)View.inflate(getContext(), a.g.wc_pay_cashier_dialog, null));
    this.VTR = ((ImageView)this.tth.findViewById(a.f.wpcd_close_iv));
    this.VUo = ((TextView)this.tth.findViewById(a.f.wpcd_dialog_title_tv));
    this.VUp = ((TextView)this.tth.findViewById(a.f.wpcd_switch_verify_way_tv));
    this.VUq = ((TextView)this.tth.findViewById(a.f.wpcd_order_desc_tv));
    this.VUr = ((ViewGroup)this.tth.findViewById(a.f.wpcd_order_total));
    this.VSc = ((TextView)this.tth.findViewById(a.f.wpcd_charge_fee_tv));
    this.VUs = ((WalletTextView)this.tth.findViewById(a.f.wpcd_order_money_tv));
    this.VUt = ((ViewGroup)this.tth.findViewById(a.f.wpcd_detail_layout));
    this.VUu = ((EditHintPasswdView)this.tth.findViewById(a.f.wpcd_pwd_input_et));
    this.VUv = ((ViewGroup)this.tth.findViewById(a.f.wpcd_pwd_input_layout));
    this.VUE = ((WcPayCashierDetailItemLayout)this.tth.findViewById(a.f.wpcd_payway_layout));
    this.VUw = ((Button)this.tth.findViewById(a.f.wpcd_confirm_pay_btn));
    this.VUx = ((TextView)this.tth.findViewById(a.f.wpcd_error_tips_tv));
    this.VUy = ((ViewGroup)this.tth.findViewById(a.f.wpcd_bank_favor_layout));
    this.VUz = ((CdnImageView)this.tth.findViewById(a.f.wpcd_favor_icon_iv));
    this.VUA = ((TextView)this.tth.findViewById(a.f.wpcd_favor_content_tv));
    this.VUB = ((Button)this.tth.findViewById(a.f.wpcd_favor_btn));
    this.mKeyboard = ((MyKeyboardWindow)this.tth.findViewById(a.f.tenpay_num_keyboard));
    this.VUC = ((ViewGroup)this.tth.findViewById(a.f.tenpay_keyboard_layout));
    this.KKP = this.tth.findViewById(a.f.wpcd_detail_divider);
    aw.a(this.VUo.getPaint(), 0.8F);
    aw.a(this.VUp.getPaint(), 0.8F);
    paramContext = this.VTR;
    int i = VUk;
    int j = VUk;
    Util.expandViewTouchArea(paramContext, i, i, j, j);
    paramContext = bb.m(getContext(), a.h.actionbar_icon_dark_close, getContext().getResources().getColor(a.c.black_per30));
    this.VTR.setImageDrawable(paramContext);
    this.VTR.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(301354);
        Log.i("MicroMsg.WcPayCashierDialog", "click close icon");
        WcPayCashierDialog.this.cancel();
        AppMethodBeat.o(301354);
      }
    });
    com.tencent.mm.wallet_core.ui.formview.a.a(this.VUu);
    this.VUu.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71355);
        if (paramAnonymousBoolean)
        {
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.e(WcPayCashierDialog.this).getText(), WcPayCashierDialog.this.Vnj);
          com.tencent.mm.plugin.report.service.h.OAn.b(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(71355);
          return;
        }
        String str = WcPayCashierDialog.e(WcPayCashierDialog.this).getEditText().getText().toString();
        WcPayCashierDialog.e(WcPayCashierDialog.this).setContentDescription(WcPayCashierDialog.f(WcPayCashierDialog.this).getString(a.i.wc_pay_accessbility_pwd_view, new Object[] { str.length() }));
        AppMethodBeat.o(71355);
      }
    });
    paramContext = (EditText)this.tth.findViewById(a.f.wallet_content);
    com.tencent.mm.wallet_core.ui.i.setNoSystemInputOnEditText(paramContext);
    this.mKeyboard.setInputEditText(paramContext);
    if (Build.VERSION.SDK_INT >= 14)
    {
      com.tencent.mm.wallet_core.c localc = new com.tencent.mm.wallet_core.c();
      this.mKeyboard.setSecureAccessibility(localc);
      paramContext.setAccessibilityDelegate(localc);
    }
    paramContext.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(301352);
        WcPayCashierDialog.g(WcPayCashierDialog.this);
        AppMethodBeat.o(301352);
      }
    });
    this.tth.findViewById(a.f.tenpay_push_down).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(301351);
        WcPayCashierDialog.h(WcPayCashierDialog.this);
        AppMethodBeat.o(301351);
      }
    });
    this.VUw.setOnClickListener(new ac()
    {
      public final void dsb()
      {
        int i = 0;
        AppMethodBeat.i(71358);
        Log.i("MicroMsg.WcPayCashierDialog", "click pay btn: %s", new Object[] { Integer.valueOf(WcPayCashierDialog.i(WcPayCashierDialog.this)) });
        if (WcPayCashierDialog.this.mPayInfo == null) {
          if (WcPayCashierDialog.this.mPayInfo != null) {
            break label113;
          }
        }
        label113:
        for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.hAT)
        {
          ag.g(i, str, 20, "");
          WcPayCashierDialog.j(WcPayCashierDialog.this);
          if (WcPayCashierDialog.i(WcPayCashierDialog.this) != 1) {
            break label127;
          }
          WcPayCashierDialog.k(WcPayCashierDialog.this);
          com.tencent.mm.wallet_core.ui.i.aGA(9);
          AppMethodBeat.o(71358);
          return;
          i = WcPayCashierDialog.this.mPayInfo.hUR;
          break;
        }
        label127:
        if (WcPayCashierDialog.i(WcPayCashierDialog.this) == 2)
        {
          WcPayCashierDialog.l(WcPayCashierDialog.this);
          AppMethodBeat.o(71358);
          return;
        }
        Log.i("MicroMsg.WcPayCashierDialog", "wrong mode, switch pwd");
        WcPayCashierDialog.m(WcPayCashierDialog.this);
        AppMethodBeat.o(71358);
      }
    });
    this.VUp.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(301353);
        Log.d("MicroMsg.WcPayCashierDialog", "click pay way btn");
        WcPayCashierDialog.n(WcPayCashierDialog.this);
        AppMethodBeat.o(301353);
      }
    });
    paramContext = new com.tencent.mm.wallet_core.c();
    paramContext.setViewType(ViewType.Button);
    this.VUp.setAccessibilityDelegate(paramContext);
    this.VTR.setAccessibilityDelegate(paramContext);
    this.VUu.setImportantForAccessibility(1);
    this.VUu.setContentDescription(this.mContext.getString(a.i.wc_pay_accessbility_pwd_view, new Object[] { "0" }));
    this.VUu.getEditText().setImportantForAccessibility(2);
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
    ((MMActivity)this.mContext).getLifecycle().addObserver(this);
    this.VjO = new com.tencent.mm.plugin.wallet_core.utils.b();
    AppMethodBeat.o(71361);
  }
  
  private void HV(boolean paramBoolean)
  {
    AppMethodBeat.i(71391);
    Log.i("MicroMsg.WcPayCashierDialog", "switch to pwd: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.VUK = 0;
    this.mPayInfo.VSv = 0;
    this.VUv.setVisibility(0);
    this.VUw.setVisibility(8);
    this.VUu.gGd();
    ilp();
    this.VUo.setVisibility(0);
    if (paramBoolean)
    {
      this.VUp.setVisibility(8);
      AppMethodBeat.o(71391);
      return;
    }
    this.VUp.setVisibility(0);
    AppMethodBeat.o(71391);
  }
  
  private void K(TextView paramTextView)
  {
    AppMethodBeat.i(71377);
    com.tencent.mm.plugin.wallet_core.ui.f localf = g.VLx.a(this.OsJ);
    com.tencent.mm.plugin.wallet.model.j localj = localf.bhb(this.Vnj.VFC);
    List localList = localf.ikx();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = "";
    int i;
    if ((localj != null) && (localj.VlE > 0.0D))
    {
      localStringBuilder.append(localj.VlG);
      i = 1;
    }
    for (;;)
    {
      if ((localj != null) && (localj.VlF != 0) && (!Util.isNullOrNil(localStringBuilder)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append(localj.VlH);
      }
      if ((!Util.isNullOrNil(localStringBuilder)) && (!Util.isNullOrNil((String)localObject)))
      {
        localStringBuilder.append(",");
        localStringBuilder.append((String)localObject);
        label152:
        localObject = localStringBuilder.toString();
        Log.i("MicroMsg.WcPayCashierDialog", "favor text: %s", new Object[] { localObject });
        if (i == 0) {
          break label340;
        }
        paramTextView.setTextColor(getContext().getResources().getColor(a.c.Orange));
      }
      for (;;)
      {
        paramTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(71377);
        return;
        if ((localList == null) || (localList.size() <= 0)) {
          break label360;
        }
        localObject = localf.ikw();
        if ((localj == null) && (localf.ikv() == 1) && (localObject != null) && (((com.tencent.mm.plugin.wallet.model.j)localObject).VlF == 0) && (this.VUQ) && (this.OsJ.VGY.VlK != null) && (this.OsJ.VGY.VlK.Vlg == 1))
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
        label340:
        paramTextView.setTextColor(getContext().getResources().getColor(a.c.half_alpha_black));
      }
      label360:
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
    if (paramBankcard.ihV())
    {
      paramCdnImageView.setImageResource(a.e.wallet_balance_manager_logo_small);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.ihW())
    {
      this.VjO.a(paramBankcard, paramCdnImageView);
      AppMethodBeat.o(71381);
      return;
    }
    if (paramBankcard.ihZ())
    {
      paramCdnImageView.setImageDrawable(com.tencent.mm.svg.a.a.i(getContext().getResources(), a.h.honey_pay_bank_logo));
      if (!Util.isNullOrNil(paramBankcard.VDG))
      {
        paramCdnImageView.setUseSdcardCache(true);
        paramCdnImageView.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.ikk());
        paramCdnImageView.iz(paramBankcard.VDG, a.h.honey_pay_bank_logo);
        AppMethodBeat.o(71381);
      }
    }
    else
    {
      this.VjO.a(getContext(), paramBankcard, paramCdnImageView);
    }
    AppMethodBeat.o(71381);
  }
  
  private void a(PayInfo paramPayInfo, Orders paramOrders, FavorPayInfo paramFavorPayInfo, String paramString, Bankcard paramBankcard, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71371);
    Log.i("MicroMsg.WcPayCashierDialog", "set view data: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBankcard });
    this.mPayInfo = paramPayInfo;
    this.OsJ = paramOrders;
    this.Vnj = paramFavorPayInfo;
    if (!paramBoolean2) {
      this.VUN = paramBankcard;
    }
    this.VUP = paramBoolean1;
    this.VUS = paramString;
    ilq();
    ilB();
    ilw();
    ilz();
    ily();
    ilu();
    ilr();
    mb(this.OsJ.field_infos);
    ils();
    ilv();
    ilt();
    if (paramBoolean2) {
      setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(301331);
          WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.this.Vnj);
          WcPayCashierDialog.this.setOnShowListener(null);
          AppMethodBeat.o(301331);
        }
      });
    }
    AppMethodBeat.o(71371);
  }
  
  private void a(boolean paramBoolean1, int paramInt, final boolean paramBoolean2, final FavorPayInfo paramFavorPayInfo)
  {
    AppMethodBeat.i(71394);
    Log.i("MicroMsg.WcPayCashierDialog", "go to bankcard dialog");
    if (this.VUI != null) {
      this.VUI.dismiss();
    }
    hide();
    this.VUu.gGd();
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
        break label822;
      }
      localObject1 = "";
      ag.g(i, (String)localObject1, 11, "");
      this.VUI = new a(this.mContext);
      locala = this.VUI;
      localObject2 = this.mPayInfo;
      localObject3 = this.OsJ;
      localObject4 = this.VUN;
      if (localObject4 != null) {
        break label834;
      }
      localObject1 = "";
      Log.i("MicroMsg.WcPayCashierBankcardDialog", "set view data: %s, %s, %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt) });
      locala.mPayInfo = ((PayInfo)localObject2);
      locala.OsJ = ((Orders)localObject3);
      locala.Vnj = paramFavorPayInfo;
      locala.MAF = ((Bankcard)localObject4);
      locala.VTV = ((Orders)localObject3).Vyb;
      locala.VTW = paramBoolean1;
      locala.VTX = paramInt;
      if (locala.VTW) {
        locala.VTY = false;
      }
      if (locala.mPayInfo.hUR != 8) {
        break label844;
      }
      localObject1 = (ArrayList)ae.HH(true);
      label241:
      localObject2 = localObject1;
      if (locala.Vnj != null)
      {
        if (locala.Vnj.VFD == 0) {
          break label856;
        }
        paramInt = 1;
        label266:
        localObject2 = localObject1;
        if (paramInt != 0)
        {
          if (locala.VTW) {
            break label861;
          }
          localObject2 = localObject1;
        }
      }
      label286:
      localObject2 = ((List)localObject2).iterator();
      label295:
      if (!((Iterator)localObject2).hasNext()) {
        break label1483;
      }
      localObject3 = (Bankcard)((Iterator)localObject2).next();
      localObject4 = new WcPayCashierBankcardItemLayout(locala.getContext());
      locala.VTU.add(localObject4);
      locala.VTS.addView((View)localObject4);
      if (!((Bankcard)localObject3).ihV()) {
        break label966;
      }
      com.tencent.mm.plugin.wallet_core.utils.b.w(((WcPayCashierBankcardItemLayout)localObject4).wGP);
      label370:
      if (!((Bankcard)localObject3).ihV()) {
        break label1170;
      }
      localObject1 = u.iiC().VcF;
      if (Util.isNullOrNil(((Bankcard)localObject1).VDp)) {
        break label1095;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).VUc.setText(((Bankcard)localObject1).VDp);
      label410:
      localObject1 = "";
      switch (((Bankcard)localObject3).a(locala.VTV, locala.OsJ))
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
          ((WcPayCashierBankcardItemLayout)localObject4).VUd.setOnClickListener(new a.5(locala, (Bankcard)localObject3));
        }
        if (!Util.isNullOrNil((CharSequence)localObject5))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).VUd.setVisibility(0);
          ((WcPayCashierBankcardItemLayout)localObject4).VUd.setText((CharSequence)localObject5);
        }
        if ((locala.VTY) && (Util.isNullOrNil((CharSequence)localObject5)))
        {
          localObject1 = locala.j((Bankcard)localObject3);
          if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
          {
            ((WcPayCashierBankcardItemLayout)localObject4).VOD.setVisibility(0);
            ((WcPayCashierBankcardItemLayout)localObject4).VUd.setVisibility(8);
            ((WcPayCashierBankcardItemLayout)localObject4).VOD.setWording((LinkedList)localObject1);
          }
        }
        if ((locala.MAF != null) && (((Bankcard)localObject3).field_bindSerial.equals(locala.MAF.field_bindSerial))) {
          ((WcPayCashierBankcardItemLayout)localObject4).VUe.setChecked(true);
        }
        if (((Bankcard)localObject3).a(locala.VTV, locala.OsJ) != 0)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).VUe.setChecked(false);
          ((WcPayCashierBankcardItemLayout)localObject4).VUc.setTextColor(locala.getContext().getResources().getColor(a.c.half_alpha_black));
          ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(false);
        }
        break;
      }
    }
    for (;;)
    {
      ((WcPayCashierBankcardItemLayout)localObject4).setOnClickListener(new a.6(locala, (Bankcard)localObject3));
      break label295;
      i = this.mPayInfo.hUR;
      break;
      label822:
      localObject1 = this.mPayInfo.hAT;
      break label62;
      label834:
      localObject1 = ((Bankcard)localObject4).field_desc;
      break label123;
      label844:
      localObject1 = (ArrayList)ae.HH(false);
      break label241;
      label856:
      paramInt = 0;
      break label266;
      label861:
      localObject3 = locala.Vnj.VFE;
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
      label966:
      if (((Bankcard)localObject3).ihW())
      {
        locala.VjO.a((Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).wGP);
        break label370;
      }
      if (((Bankcard)localObject3).ihZ())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).wGP.setImageDrawable(com.tencent.mm.svg.a.a.i(locala.getContext().getResources(), a.h.honey_pay_bank_logo));
        if (Util.isNullOrNil(((Bankcard)localObject3).VDG)) {
          break label370;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).wGP.setUseSdcardCache(true);
        ((WcPayCashierBankcardItemLayout)localObject4).wGP.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.ikk());
        ((WcPayCashierBankcardItemLayout)localObject4).wGP.iz(((Bankcard)localObject3).VDG, a.h.honey_pay_bank_logo);
        break label370;
      }
      locala.VjO.a(locala.getContext(), (Bankcard)localObject3, ((WcPayCashierBankcardItemLayout)localObject4).wGP);
      break label370;
      label1095:
      if (((Bankcard)localObject1).VDo >= 0.0D)
      {
        localObject5 = ((WcPayCashierBankcardItemLayout)localObject4).VUc;
        Context localContext = locala.getContext();
        locala.getContext();
        ((TextView)localObject5).setText(localContext.getString(ai.jPb(), new Object[] { com.tencent.mm.wallet_core.ui.i.X(((Bankcard)localObject1).VDo) }));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).VUc.setText("");
      break label410;
      label1170:
      if (((Bankcard)localObject3).ihW())
      {
        localObject1 = u.iiC().VKi;
        if (!Util.isNullOrNil(((Bankcard)localObject1).VDp))
        {
          ((WcPayCashierBankcardItemLayout)localObject4).VUc.setText(((Bankcard)localObject1).VDp);
          break label410;
        }
        if (((Bankcard)localObject1).VDo >= 0.0D)
        {
          ((WcPayCashierBankcardItemLayout)localObject4).VUc.setText(locala.getContext().getString(a.i.wallet_lqt_change_bankcard_balance_left, new Object[] { com.tencent.mm.wallet_core.ui.i.X(((Bankcard)localObject1).VDo) }));
          break label410;
        }
        ((WcPayCashierBankcardItemLayout)localObject4).VUc.setText("");
        break label410;
      }
      if (((Bankcard)localObject3).ihZ())
      {
        ((WcPayCashierBankcardItemLayout)localObject4).VUc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(locala.getContext(), ((Bankcard)localObject3).field_desc, ((WcPayCashierBankcardItemLayout)localObject4).VUc.getTextSize()));
        break label410;
      }
      ((WcPayCashierBankcardItemLayout)localObject4).VUc.setText(((Bankcard)localObject3).field_desc);
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
      ((WcPayCashierBankcardItemLayout)localObject4).VUc.setTextColor(locala.getContext().getResources().getColor(a.c.normal_text_color));
      ((WcPayCashierBankcardItemLayout)localObject4).setEnabled(true);
    }
    label1483:
    Object localObject1 = new WcPayCashierBankcardItemLayout(locala.getContext());
    ((WcPayCashierBankcardItemLayout)localObject1).wGP.setVisibility(4);
    ((WcPayCashierBankcardItemLayout)localObject1).VUc.setText(a.i.wallet_pay_bankcard_add);
    ((WcPayCashierBankcardItemLayout)localObject1).VUc.setTextColor(locala.getContext().getResources().getColor(a.c.link_color));
    ((WcPayCashierBankcardItemLayout)localObject1).VUe.setVisibility(8);
    Object localObject2 = locala.ilm();
    if ((locala.VTY) && (localObject2 != null) && (((LinkedList)localObject2).size() > 0))
    {
      ((WcPayCashierBankcardItemLayout)localObject1).VOD.setVisibility(0);
      ((WcPayCashierBankcardItemLayout)localObject1).VUd.setVisibility(8);
      ((WcPayCashierBankcardItemLayout)localObject1).VOD.setWording((LinkedList)localObject2);
    }
    ((WcPayCashierBankcardItemLayout)localObject1).setOnClickListener(new a.7(locala));
    locala.VTS.addView((View)localObject1);
    localObject2 = "";
    localObject1 = localObject2;
    if (locala.OsJ != null)
    {
      localObject1 = localObject2;
      if (locala.OsJ.VGX != null)
      {
        localObject1 = localObject2;
        if (locala.OsJ.VGX.size() > 0) {
          localObject1 = locala.getContext().getString(a.i.wallet_change_bankcard_tips, new Object[] { com.tencent.mm.wallet_core.ui.i.e(locala.OsJ.hAW, locala.OsJ.MEq), ((Orders.Commodity)locala.OsJ.VGX.get(0)).desc });
        }
      }
    }
    if ((locala.Vnj != null) && (!Util.isNullOrNil(locala.Vnj.VFG)))
    {
      locala.VTT.setVisibility(0);
      locala.VTT.setText(locala.Vnj.VFG);
      locala.Vnj.VFG = "";
    }
    for (;;)
    {
      localObject1 = this.VUI.VUa;
      this.VUY.add(localObject1);
      this.VUI.VTZ = new a.a()
      {
        public final void ieE()
        {
          AppMethodBeat.i(301358);
          Log.i("MicroMsg.WcPayCashierDialog", "on click add new bankcard");
          WcPayCashierDialog.I(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.J(WcPayCashierDialog.this);
          if (WcPayCashierDialog.c(WcPayCashierDialog.this) != null) {
            WcPayCashierDialog.c(WcPayCashierDialog.this).ieE();
          }
          WcPayCashierDialog.this.dismiss();
          AppMethodBeat.o(301358);
        }
        
        public final void l(Bankcard paramAnonymousBankcard)
        {
          int i = 0;
          AppMethodBeat.i(301356);
          if (paramAnonymousBankcard == null)
          {
            AppMethodBeat.o(301356);
            return;
          }
          Log.i("MicroMsg.WcPayCashierDialog", "on select bankcard: %s, %s", new Object[] { paramAnonymousBankcard.field_bankName, paramAnonymousBankcard.field_bindSerial });
          if ((WcPayCashierDialog.this.VUN == null) || (!paramAnonymousBankcard.field_bindSerial.equals(WcPayCashierDialog.this.VUN.field_bindSerial)))
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
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.hAT)
          {
            ag.g(i, str, 13, paramAnonymousBankcard.field_bindSerial);
            WcPayCashierDialog.this.VUN = paramAnonymousBankcard;
            WcPayCashierDialog.this.Vnj = paramFavorPayInfo;
            WcPayCashierDialog.x(WcPayCashierDialog.this);
            WcPayCashierDialog.s(WcPayCashierDialog.this);
            WcPayCashierDialog.t(WcPayCashierDialog.this);
            WcPayCashierDialog.y(WcPayCashierDialog.this);
            WcPayCashierDialog.z(WcPayCashierDialog.this);
            WcPayCashierDialog.H(WcPayCashierDialog.this);
            WcPayCashierDialog.I(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
            WcPayCashierDialog.J(WcPayCashierDialog.this);
            WcPayCashierDialog.this.show();
            AppMethodBeat.o(301356);
            return;
            i = WcPayCashierDialog.this.mPayInfo.hUR;
            break;
          }
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(301359);
          Log.i("MicroMsg.WcPayCashierDialog", "on bankcard dialog cancel");
          WcPayCashierDialog.I(WcPayCashierDialog.this).a(WcPayCashierDialog.this);
          WcPayCashierDialog.J(WcPayCashierDialog.this);
          WcPayCashierDialog.this.show();
          AppMethodBeat.o(301359);
        }
      };
      this.VUI.show();
      AppMethodBeat.o(71394);
      return;
      if (locala.VTX != 0)
      {
        locala.VTT.setVisibility(0);
        locala.VTT.setText((CharSequence)localObject1);
      }
      else
      {
        locala.VTT.setVisibility(8);
      }
    }
  }
  
  private static boolean a(PayInfo paramPayInfo)
  {
    return (paramPayInfo != null) && ((paramPayInfo.hUR == 31) || (paramPayInfo.hUR == 32) || (paramPayInfo.hUR == 33));
  }
  
  private void asz(int paramInt)
  {
    AppMethodBeat.i(71386);
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.VUv.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.VUw.getLayoutParams();
    if (paramInt == 0) {
      localLayoutParams1.topMargin = VUn;
    }
    for (localLayoutParams2.topMargin = VUn;; localLayoutParams2.topMargin = VUm)
    {
      this.VUv.setLayoutParams(localLayoutParams1);
      this.VUw.setLayoutParams(localLayoutParams2);
      this.VUy.setVisibility(paramInt);
      AppMethodBeat.o(71386);
      return;
      localLayoutParams1.topMargin = VUl;
    }
  }
  
  private static void bA(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(71390);
    com.tencent.mm.plugin.fingerprint.c.a locala = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
    if ((locala.type() == 1) && ((locala.ftq()) || (locala.ftt())) && (com.tencent.mm.plugin.soter.d.b.htK()) && (com.tencent.mm.plugin.soter.d.b.htJ()) && (com.tencent.soter.core.a.jXR() == 0))
    {
      Log.i("MicroMsg.WcPayCashierDialog", "may treble init error");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 23);
      if (locala.type() == 2)
      {
        if (com.tencent.soter.core.a.jXR() != 0) {
          break label246;
        }
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 28);
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 27);
      }
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 33);
      }
      AppMethodBeat.o(71390);
      return;
      if (locala.type() != 2) {
        break;
      }
      if (com.tencent.soter.core.a.jXR() == 1)
      {
        if (!com.tencent.soter.core.a.jXT())
        {
          Log.i("MicroMsg.WcPayCashierDialog", "soter service disconnected");
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 24);
          break;
        }
        if (paramBoolean1) {
          break;
        }
        Log.i("MicroMsg.WcPayCashierDialog", "soter treble key error");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 25);
        break;
      }
      if (paramBoolean1) {
        break;
      }
      Log.i("MicroMsg.WcPayCashierDialog", "soter1.0 key error");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 26);
      break;
      label246:
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 31);
    }
  }
  
  private void eAw()
  {
    AppMethodBeat.i(71367);
    if (this.VUC.isShown())
    {
      this.VUC.setVisibility(8);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.wxpay.a.a.sight_slide_bottom_out);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.VUC.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71367);
  }
  
  private void ilA()
  {
    AppMethodBeat.i(71387);
    Object localObject1;
    if (this.VUV) {
      localObject1 = this.VUU;
    }
    for (;;)
    {
      this.VUs.setText((CharSequence)localObject1);
      AppMethodBeat.o(71387);
      return;
      Object localObject2 = g.VLx.a(this.OsJ);
      localObject1 = com.tencent.mm.wallet_core.ui.i.e(this.OsJ.hAW, this.OsJ.MEq);
      this.VUR = false;
      if (localObject2 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.wallet_core.ui.f)localObject2).bhb(this.Vnj.VFC);
        localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.f)localObject2).ikx();
        if ((localObject1 != null) && (((com.tencent.mm.plugin.wallet.model.j)localObject1).VlE > 0.0D))
        {
          this.VUR = true;
          localObject1 = com.tencent.mm.wallet_core.ui.i.e(((com.tencent.mm.plugin.wallet.model.j)localObject1).VlD, this.OsJ.MEq);
        }
        else if ((localObject1 != null) && (localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = com.tencent.mm.wallet_core.ui.i.e(((com.tencent.mm.plugin.wallet.model.j)localObject1).VlD, this.OsJ.MEq);
        }
        else
        {
          localObject1 = com.tencent.mm.wallet_core.ui.i.e(this.OsJ.hAW, this.OsJ.MEq);
        }
      }
    }
  }
  
  private void ilB()
  {
    AppMethodBeat.i(71388);
    ilC();
    Log.i("MicroMsg.WcPayCashierDialog", "use touch pay: %s", new Object[] { Integer.valueOf(this.OsJ.VGU) });
    if (this.VUK == 0)
    {
      boolean bool;
      if (this.VUL > 0) {
        bool = false;
      }
      for (;;)
      {
        HV(bool);
        AppMethodBeat.o(71388);
        return;
        if (this.VUM == 1)
        {
          this.VUx.setVisibility(8);
          bool = true;
        }
        else
        {
          if (this.VUM != 3) {
            break;
          }
          this.VUx.setText(a.i.wallet_finger_print_not_recorded);
          this.VUx.setVisibility(0);
          bool = true;
        }
      }
      if (this.mPayInfo.YvG == 100102)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acJW, Boolean.TRUE);
        com.tencent.mm.plugin.fingerprint.c.a locala = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
        locala.vu(false);
        locala.vv(false);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acJU, Boolean.FALSE);
        this.VUx.setText(a.i.wallet_fingerprint_severe_error_hint);
      }
      for (;;)
      {
        this.VUx.setTextColor(getContext().getResources().getColor(a.c.wallet_pwd_bank_card_text_color));
        this.VUx.setVisibility(0);
        bool = true;
        break;
        this.VUx.setText(a.i.wallet_finger_print_not_recorded);
      }
    }
    if (this.VUK == 1)
    {
      ilD();
      AppMethodBeat.o(71388);
      return;
    }
    if (this.VUK == 2) {
      ilE();
    }
    AppMethodBeat.o(71388);
  }
  
  private void ilC()
  {
    AppMethodBeat.i(71389);
    Log.i("MicroMsg.WcPayCashierDialog", "update verify way: %s", new Object[] { Integer.valueOf(this.OsJ.VGU) });
    com.tencent.mm.plugin.fingerprint.c.a locala;
    boolean bool3;
    if (this.OsJ.VGU == 1)
    {
      locala = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
      if ((locala.ftv()) && (locala.ftw()) && (!locala.ftr()) && (locala.ftq()) && (locala.ftz()))
      {
        this.VUL = 1;
        bool3 = com.tencent.mm.plugin.fingerprint.mgr.j.Hgj.Hgl;
        if ((u.iiC() == null) || (this.VUL <= 0)) {
          break label484;
        }
      }
    }
    label148:
    label332:
    label484:
    for (boolean bool2 = locala.ftC();; bool2 = true)
    {
      bA(bool2, bool3);
      boolean bool1;
      if (!bool3)
      {
        bool1 = true;
        bool2 &= bool1;
        if (bool2) {
          break label332;
        }
        com.tencent.mm.plugin.fingerprint.mgr.j.Hgj.Hgl = true;
        this.VUL = 0;
        this.VUM = 3;
        this.mPayInfo.VGV = true;
        com.tencent.mm.plugin.fingerprint.mgr.j.Hgj.Hgl = true;
      }
      for (;;)
      {
        this.VUK = this.VUL;
        Log.i("MicroMsg.WcPayCashierDialog", "keystatus: %s, errcode: %s, payway: %s, supportMode: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(this.mPayInfo.YvG), Integer.valueOf(this.VUK), Integer.valueOf(this.VUL) });
        AppMethodBeat.o(71389);
        return;
        if ((locala.ftD()) && (locala.ftE()) && (!locala.fts()) && (locala.ftt()) && (locala.ftz()))
        {
          this.VUL = 2;
          break;
        }
        this.VUL = 0;
        this.VUM = 2;
        break;
        bool1 = false;
        break label148;
        if ((this.mPayInfo.YvG == 100000) || (this.mPayInfo.YvG == 100102))
        {
          if (this.mPayInfo.YvG == 100000) {
            this.mPayInfo.VSv = 0;
          }
          this.VUL = 0;
          this.VUM = 4;
        }
      }
      this.VUK = 0;
      this.VUL = 0;
      this.VUM = 1;
      locala = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
      if ((locala.ftv()) && (locala.ftw()) && (!locala.ftr()) && (locala.ftq()))
      {
        Log.w("MicroMsg.WcPayCashierDialog", "wired case");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 2);
      }
      AppMethodBeat.o(71389);
      return;
    }
  }
  
  private void ilD()
  {
    AppMethodBeat.i(71392);
    this.VUK = 1;
    this.mPayInfo.VSv = 1;
    this.VUv.setVisibility(8);
    this.VUw.setVisibility(0);
    this.VUu.gGd();
    eAw();
    this.VUo.setVisibility(8);
    this.VUp.setText(a.i.wallet_pwd_pay_mode);
    AppMethodBeat.o(71392);
  }
  
  private void ilE()
  {
    AppMethodBeat.i(71393);
    this.VUK = 2;
    this.mPayInfo.VSv = 1;
    this.VUv.setVisibility(8);
    this.VUw.setVisibility(0);
    this.VUu.gGd();
    eAw();
    this.VUo.setVisibility(8);
    this.VUp.setText(a.i.wallet_pwd_pay_mode);
    AppMethodBeat.o(71393);
  }
  
  private void ilp()
  {
    AppMethodBeat.i(71366);
    if (!this.VUC.isShown())
    {
      this.VUC.setVisibility(0);
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.wxpay.a.a.sight_slide_bottom_in);
      localAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimation.setDuration(180L);
      this.VUC.startAnimation(localAnimation);
    }
    AppMethodBeat.o(71366);
  }
  
  private void ilq()
  {
    AppMethodBeat.i(71373);
    Object localObject1 = g.VLx.a(this.OsJ);
    if (localObject1 != null) {
      if ((this.Vnj != null) && (this.VUN != null)) {
        if (!this.VUN.field_bankcardType.equalsIgnoreCase("CFT")) {
          break label452;
        }
      }
    }
    label195:
    label452:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WcPayCashierDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", new Object[] { this.Vnj.VFC, Boolean.valueOf(bool) });
      String str = ((com.tencent.mm.plugin.wallet_core.ui.f)localObject1).dC(this.Vnj.VFC, bool);
      Log.i("MicroMsg.WcPayCashierDialog", "nonBankSelectedFaovrCompId %s", new Object[] { str });
      Object localObject3 = ((com.tencent.mm.plugin.wallet_core.ui.f)localObject1).bgZ(str);
      Object localObject2 = ((com.tencent.mm.plugin.wallet_core.ui.f)localObject1).dB(str, true);
      f.a locala1 = (f.a)((Map)localObject3).get(this.VUN.field_bindSerial);
      f.a locala2 = (f.a)((Map)localObject2).get(this.VUN.field_bankcardType);
      com.tencent.mm.plugin.wallet.model.j localj = ((com.tencent.mm.plugin.wallet_core.ui.f)localObject1).dA(str, bool);
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
        if ((locala1 == null) || (locala1.VLv == null) || (Util.isNullOrNil(locala1.VLv.VlN))) {
          break label308;
        }
        this.Vnj.VFC = locala1.VLv.VlN;
        AppMethodBeat.o(71373);
        return;
        localObject1 = localj.VlN;
        break;
        localObject2 = locala1.toString();
        break label195;
      }
      if ((locala2 != null) && (locala2.VLv != null) && (!Util.isNullOrNil(locala2.VLv.VlN)))
      {
        this.Vnj.VFC = locala2.VLv.VlN;
        AppMethodBeat.o(71373);
        return;
      }
      if (localj != null)
      {
        this.Vnj.VFC = localj.VlN;
        AppMethodBeat.o(71373);
        return;
      }
      this.Vnj.VFC = str;
      AppMethodBeat.o(71373);
      return;
      if (this.OsJ.VGY != null)
      {
        this.Vnj = ((com.tencent.mm.plugin.wallet_core.ui.f)localObject1).bhe(((com.tencent.mm.plugin.wallet_core.ui.f)localObject1).bhf(this.OsJ.VGY.Vlx));
        AppMethodBeat.o(71373);
        return;
        Log.d("MicroMsg.WcPayCashierDialog", "getFavorLogicHelper null");
      }
      AppMethodBeat.o(71373);
      return;
    }
  }
  
  private void ilr()
  {
    AppMethodBeat.i(71374);
    if (this.VUR)
    {
      Log.i("MicroMsg.WcPayCashierDialog", "don't show foreign currency");
      if (this.VUG != null)
      {
        this.VUt.removeView(this.VUG);
        this.VUG = null;
      }
      AppMethodBeat.o(71374);
      return;
    }
    if ((!Util.isNullOrNil(this.OsJ.VHp)) && (!Util.isNullOrNil(this.OsJ.VHq)))
    {
      this.VUG = new WcPayCashierDetailItemLayout(getContext());
      this.VUt.addView(this.VUG, 0);
      this.VUG.VUh.setVisibility(8);
      this.VUG.VUi.setVisibility(8);
      this.VUG.Olf.setText(a.i.wc_pay_foreign_currency_text);
      this.VUG.ilo();
      if ((this.OsJ.VHp.equals("CNY")) && (!Util.isNullOrNil(this.OsJ.VHo)))
      {
        localStringBuilder = new StringBuilder(this.OsJ.VHq);
        localStringBuilder.append(this.OsJ.VHo);
        if ((!Util.isNullOrNil(this.OsJ.VHs)) && (!Util.isNullOrNil(this.OsJ.VHt))) {
          localStringBuilder.append(String.format("(%s%s)", new Object[] { this.OsJ.VHt, this.OsJ.VHr }));
        }
        this.VUG.xGl.setText(localStringBuilder);
        AppMethodBeat.o(71374);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(this.OsJ.VHq);
      localStringBuilder.append(this.OsJ.VHo);
      this.VUG.xGl.setText(localStringBuilder);
    }
    AppMethodBeat.o(71374);
  }
  
  private void ils()
  {
    AppMethodBeat.i(71375);
    com.tencent.mm.plugin.wallet_core.ui.f localf = g.VLx.a(this.OsJ);
    if ((this.Vnj == null) || ((localf != null) && (!localf.iku())))
    {
      this.VUt.removeView(this.VUF);
      this.VUF = null;
      AppMethodBeat.o(71375);
      return;
    }
    if (this.VUF == null)
    {
      this.VUF = new WcPayCashierDetailItemLayout(getContext());
      this.VUt.addView(this.VUF);
      this.VUF.Olf.setText(a.i.wc_pay_favor_text);
      this.VUF.VUh.setVisibility(8);
      this.VUF.VUi.setVisibility(0);
      this.VUF.xGl.setTextColor(getContext().getResources().getColor(a.c.Orange));
      this.VUF.ilo();
      this.VUF.setOnClickListener(new ac()
      {
        public final void dsb()
        {
          AppMethodBeat.i(301334);
          int i;
          if (WcPayCashierDialog.this.mPayInfo == null)
          {
            i = 0;
            if (WcPayCashierDialog.this.mPayInfo != null) {
              break label95;
            }
          }
          label95:
          for (String str = "";; str = WcPayCashierDialog.this.mPayInfo.hAT)
          {
            ag.g(i, str, 12, "");
            WcPayCashierDialog.this.hide();
            if (WcPayCashierDialog.r(WcPayCashierDialog.this) == null) {
              break label109;
            }
            WcPayCashierDialog.r(WcPayCashierDialog.this).dismiss();
            WcPayCashierDialog.a(WcPayCashierDialog.this, null);
            AppMethodBeat.o(301334);
            return;
            i = WcPayCashierDialog.this.mPayInfo.hUR;
            break;
          }
          label109:
          WcPayCashierDialog.a(WcPayCashierDialog.this, com.tencent.mm.plugin.wallet_core.ui.p.a(WcPayCashierDialog.this.getContext(), WcPayCashierDialog.this.OsJ, WcPayCashierDialog.this.Vnj.VFC, new p.b()new DialogInterface.OnCancelListener
          {
            public final void a(FavorPayInfo paramAnonymous2FavorPayInfo)
            {
              int i = 0;
              AppMethodBeat.i(301333);
              Log.i("MicroMsg.WcPayCashierDialog", "on select favor: %s", new Object[] { paramAnonymous2FavorPayInfo.VFC });
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              Object localObject;
              if (WcPayCashierDialog.this.mPayInfo == null)
              {
                if (WcPayCashierDialog.this.mPayInfo != null) {
                  break label227;
                }
                localObject = "";
                label66:
                ag.g(i, (String)localObject, 15, paramAnonymous2FavorPayInfo.VFC);
                localObject = com.tencent.mm.plugin.wallet_core.ui.f.dz(paramAnonymous2FavorPayInfo.VFD, paramAnonymous2FavorPayInfo.VFE);
                WcPayCashierDialog.this.Vnj.VFG = "";
                if (!com.tencent.mm.plugin.wallet_core.ui.f.a(paramAnonymous2FavorPayInfo, WcPayCashierDialog.this.VUN)) {
                  break label267;
                }
                if (((List)localObject).size() != 0) {
                  break label244;
                }
                paramAnonymous2FavorPayInfo.VFG = WcPayCashierDialog.this.getContext().getString(a.i.wallet_favor_need_bind_bankcard);
                label150:
                WcPayCashierDialog.b(WcPayCashierDialog.this, paramAnonymous2FavorPayInfo);
              }
              for (;;)
              {
                WcPayCashierDialog.s(WcPayCashierDialog.this);
                WcPayCashierDialog.t(WcPayCashierDialog.this);
                WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.u(WcPayCashierDialog.this).xGl);
                AppMethodBeat.o(301333);
                return;
                i = WcPayCashierDialog.this.mPayInfo.hUR;
                break;
                label227:
                localObject = WcPayCashierDialog.this.mPayInfo.hAT;
                break label66;
                label244:
                paramAnonymous2FavorPayInfo.VFG = WcPayCashierDialog.this.getContext().getString(a.i.wallet_favor_need_change_bankcard);
                break label150;
                label267:
                WcPayCashierDialog.this.Vnj = paramAnonymous2FavorPayInfo;
                WcPayCashierDialog.this.show();
              }
            }
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(301330);
              Log.i("MicroMsg.WcPayCashierDialog", "on cancel");
              WcPayCashierDialog.a(WcPayCashierDialog.this, null);
              WcPayCashierDialog.this.show();
              AppMethodBeat.o(301330);
            }
          }));
          AppMethodBeat.o(301334);
        }
      });
    }
    K(this.VUF.xGl);
    AppMethodBeat.o(71375);
  }
  
  private void ilt()
  {
    AppMethodBeat.i(71378);
    if ((this.VUt.getChildCount() == 0) && (this.VUE.getVisibility() == 8))
    {
      Log.d("MicroMsg.WcPayCashierDialog", "invisible divider");
      this.KKP.setVisibility(8);
      AppMethodBeat.o(71378);
      return;
    }
    this.KKP.setVisibility(0);
    AppMethodBeat.o(71378);
  }
  
  private void ilu()
  {
    AppMethodBeat.i(71379);
    if (!this.VUR)
    {
      if (this.VUD != null)
      {
        this.VUt.removeView(this.VUD);
        this.VUD = null;
      }
      AppMethodBeat.o(71379);
      return;
    }
    Object localObject1;
    if (this.VUD == null)
    {
      this.VUD = new WcPayCashierDetailItemLayout(getContext());
      this.VUt.addView(this.VUD, 0);
      this.VUD.Olf.setText(a.i.wc_pay_origin_fee_text);
      this.VUD.VUh.setVisibility(8);
      this.VUD.VUi.setVisibility(8);
      this.VUD.ilo();
      localObject1 = com.tencent.mm.wallet_core.ui.i.aGy(7);
    }
    try
    {
      this.VUD.xGl.setTypeface(Typeface.createFromAsset(getContext().getAssets(), (String)localObject1));
      this.VUD.xGl.getPaint().setFlags(16);
      str = "";
      localObject1 = str;
      if (!Util.isNullOrNil(this.OsJ.VHo))
      {
        localObject1 = str;
        if (!Util.isNullOrNil(this.OsJ.VHq)) {
          localObject1 = String.format("%s%s", new Object[] { this.OsJ.VHq, this.OsJ.VHo });
        }
      }
      str = com.tencent.mm.wallet_core.ui.i.e(this.OsJ.hAW, this.OsJ.MEq);
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = String.format("%s(%s)", new Object[] { str, localObject1 });
        this.VUD.xGl.setText((CharSequence)localObject1);
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
  
  private void ilv()
  {
    AppMethodBeat.i(71380);
    if (!this.VUP)
    {
      Log.i("MicroMsg.WcPayCashierDialog", "can not change pay way");
      this.VUE.setVisibility(8);
      AppMethodBeat.o(71380);
      return;
    }
    this.VUE.setVisibility(0);
    this.VUE.Olf.setText(a.i.wc_pay_payway_text);
    this.VUE.VUh.setVisibility(0);
    this.VUE.VUi.setVisibility(0);
    this.VUE.ilo();
    this.VUE.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(301332);
        Log.d("MicroMsg.WcPayCashierDialog", "click bankcard item");
        WcPayCashierDialog.v(WcPayCashierDialog.this);
        AppMethodBeat.o(301332);
      }
    });
    this.VUE.VUh.setImageBitmap(null);
    a(this.VUN, this.VUE.VUh);
    if (this.VUN == null) {}
    for (String str = "";; str = this.VUN.field_desc)
    {
      Object localObject = str;
      if (this.VUN != null)
      {
        localObject = str;
        if (this.VUN.ihZ()) {
          localObject = com.tencent.mm.pluginsdk.ui.span.p.b(this.mContext, str);
        }
      }
      this.VUE.av((CharSequence)localObject);
      AppMethodBeat.o(71380);
      return;
    }
  }
  
  private void ilw()
  {
    AppMethodBeat.i(71382);
    ilx();
    ilA();
    this.VUr.setContentDescription(this.VUq.getText().toString() + "," + this.VUs.jPy().toString());
    AppMethodBeat.o(71382);
  }
  
  private void ilx()
  {
    AppMethodBeat.i(71383);
    Object localObject2 = "";
    Object localObject1;
    if (this.VUV)
    {
      localObject1 = this.VUT;
      this.VUq.setText((CharSequence)localObject1);
      AppMethodBeat.o(71383);
      return;
    }
    if (this.mPayInfo.nKf == null)
    {
      localObject1 = "";
      label52:
      if (Util.isNullOrNil((String)localObject1)) {
        break label222;
      }
    }
    for (;;)
    {
      if ((!Util.isNullOrNil((String)localObject1)) || (this.OsJ == null) || (this.OsJ.VGX == null)) {
        break label1145;
      }
      Object localObject3 = (Orders.Commodity)this.OsJ.VGX.get(0);
      if (localObject3 == null) {
        break label1181;
      }
      localObject1 = ((Orders.Commodity)localObject3).MEf;
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
      localObject1 = this.mPayInfo.nKf.getString("extinfo_key_19", "");
      break label52;
      label222:
      if ((this.mPayInfo.hUR == 32) || (this.mPayInfo.hUR == 33))
      {
        String str1 = this.mPayInfo.nKf.getString("extinfo_key_5", "");
        String str2 = this.mPayInfo.nKf.getString("extinfo_key_1", "");
        localObject3 = getContext().getString(a.i.wallet_pwd_dialog_remittance_desc_txt);
        localObject1 = localObject2;
        if (!Util.isNullOrNil(str1))
        {
          localObject3 = str1;
          localObject1 = str1;
        }
        if (!Util.isNullOrNil(str2))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(str2);
          if (localObject2 != null)
          {
            localObject1 = ((au)localObject2).aSV();
            localObject2 = new StringBuilder().append(com.tencent.mm.wallet_core.ui.i.bEU((String)localObject1));
            if (Util.isNullOrNil(this.mPayInfo.OiN)) {}
            for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.OiN + ")")
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
        if (this.mPayInfo.hUR == 31)
        {
          localObject1 = this.mPayInfo.nKf.getString("extinfo_key_1", "");
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu((String)localObject1);
            if (localObject3 != null)
            {
              localObject1 = ((au)localObject3).aSU();
              localObject2 = getContext();
              i = a.i.wallet_pwd_dialog_remittance_desc_txt;
              localObject3 = new StringBuilder().append((String)localObject1);
              if (Util.isNullOrNil(this.mPayInfo.OiN)) {}
              for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.OiN + ")")
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
        else if (this.mPayInfo.hUR == 42)
        {
          localObject1 = this.mPayInfo.nKf.getString("extinfo_key_1", "");
          if (!Util.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.kernel.h.baF();
            localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu((String)localObject1);
            if (localObject3 != null)
            {
              localObject1 = ((au)localObject3).aSU();
              localObject2 = getContext();
              i = a.i.wallet_pwd_dialog_aa_desc_txt;
              localObject3 = new StringBuilder().append((String)localObject1);
              if (Util.isNullOrNil(this.mPayInfo.OiN)) {}
              for (localObject1 = "";; localObject1 = "(" + this.mPayInfo.OiN + ")")
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
        else if (this.mPayInfo.hUR == 48)
        {
          localObject1 = getContext().getString(a.i.qr_reward_grant_btn);
        }
        else if (this.mPayInfo.hUR == 49)
        {
          localObject1 = this.mPayInfo.nKf.getString("extinfo_key_1", "");
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject1 = getContext().getString(a.i.wallet_pwd_dialog_remittance_desc_txt, new Object[] { localObject1 });
          }
          else
          {
            Log.e("MicroMsg.WcPayCashierDialog", "userName is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.hUR) });
            localObject1 = localObject2;
          }
        }
        else if (this.mPayInfo.hUR == 56)
        {
          localObject1 = this.mPayInfo.nKf.getString("extinfo_key_12", "");
          if (Util.isNullOrNil((String)localObject1))
          {
            Log.e("MicroMsg.WcPayCashierDialog", "title is null, scene is %s", new Object[] { Integer.valueOf(this.mPayInfo.hUR) });
            localObject1 = localObject2;
          }
        }
        else if ((this.mPayInfo.hUR == 45) || (this.mPayInfo.hUR == 52))
        {
          localObject1 = getContext().getString(a.i.wallet_lqt_save_title);
        }
        else
        {
          localObject1 = localObject2;
          if (this.mPayInfo.hUR == 11) {
            localObject1 = getContext().getString(a.i.wallet_balance_save_title2);
          }
        }
      }
    }
    label1145:
    localObject2 = new StringBuilder("orders null?:");
    if (this.OsJ == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.w("MicroMsg.WcPayCashierDialog", bool);
      label1181:
      break;
    }
  }
  
  private void ily()
  {
    AppMethodBeat.i(71384);
    if (!Util.isNullOrNil(this.VUS))
    {
      this.VSc.setText(this.VUS);
      this.VSc.setVisibility(0);
      AppMethodBeat.o(71384);
      return;
    }
    this.VSc.setVisibility(8);
    AppMethodBeat.o(71384);
  }
  
  private void ilz()
  {
    AppMethodBeat.i(71385);
    if ((this.VUQ) && (this.OsJ.VGY.VlK != null) && (this.OsJ.VGY.VlK.Vlg == 1))
    {
      final com.tencent.mm.plugin.wallet.model.b localb = this.OsJ.VGY.VlK;
      this.VUz.setUrl(localb.Vln);
      this.VUA.setText(localb.Vli);
      if (!Util.isNullOrNil(localb.Vlj)) {
        this.VUA.setTextColor(com.tencent.mm.plugin.wallet_core.utils.n.dE(localb.Vlj, true));
      }
      this.VUB.setText(localb.Vlk);
      if (!Util.isNullOrNil(localb.Vll)) {
        this.VUB.setTextColor(com.tencent.mm.plugin.wallet_core.utils.n.dE(localb.Vll, true));
      }
      this.VUB.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(301337);
          Log.i("MicroMsg.WcPayCashierDialog", "click bank favor btn");
          WcPayCashierDialog.w(WcPayCashierDialog.this);
          WcPayCashierDialog.this.VUN = u.iiC().bgD(localb.Vlf.MDt);
          paramAnonymousView = g.VLx.a(WcPayCashierDialog.this.OsJ).bhe(localb.Vlh);
          Log.i("MicroMsg.WcPayCashierDialog", "set favor info: %s", new Object[] { paramAnonymousView.VFC });
          if (paramAnonymousView.VFC.equals("0")) {
            WcPayCashierDialog.x(WcPayCashierDialog.this);
          }
          for (;;)
          {
            WcPayCashierDialog.s(WcPayCashierDialog.this);
            WcPayCashierDialog.t(WcPayCashierDialog.this);
            WcPayCashierDialog.y(WcPayCashierDialog.this);
            WcPayCashierDialog.z(WcPayCashierDialog.this);
            WcPayCashierDialog.A(WcPayCashierDialog.this);
            AppMethodBeat.o(301337);
            return;
            WcPayCashierDialog.this.Vnj = paramAnonymousView;
          }
        }
      });
      asz(0);
      AppMethodBeat.o(71385);
      return;
    }
    asz(8);
    AppMethodBeat.o(71385);
  }
  
  private void mb(List<fll> paramList)
  {
    AppMethodBeat.i(71372);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        final fll localfll = (fll)paramList.next();
        WcPayCashierDetailItemLayout localWcPayCashierDetailItemLayout = new WcPayCashierDetailItemLayout(getContext());
        localWcPayCashierDetailItemLayout.VUh.setVisibility(8);
        if ((localfll.abLS != null) && (localfll.abLS.size() > 0)) {
          com.tencent.mm.plugin.wallet_core.utils.n.a(localWcPayCashierDetailItemLayout.Olf, (fmp)localfll.abLS.get(0), null);
        }
        if ((localfll.abLT != null) && (localfll.abLT.size() > 0))
        {
          com.tencent.mm.plugin.wallet_core.utils.n.a(localWcPayCashierDetailItemLayout.xGl, (fmp)localfll.abLT.get(0), null);
          label149:
          if (localfll.abLU == null) {
            break label267;
          }
          int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
          int j = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 16);
          com.tencent.mm.plugin.wallet_core.utils.n.a(localWcPayCashierDetailItemLayout.VUi, localfll.abLU, a.h.arrow_right, i, j, true);
          localWcPayCashierDetailItemLayout.VUi.setVisibility(0);
        }
        for (;;)
        {
          localWcPayCashierDetailItemLayout.ilo();
          if (localfll.YCV != null) {
            localWcPayCashierDetailItemLayout.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
            {
              public final void dr(View paramAnonymousView)
              {
                AppMethodBeat.i(301335);
                Log.i("MicroMsg.WcPayCashierDialog", "click item: %s", new Object[] { localfll.YCV.url });
                if ((localfll.YCV.type == 13) && (localfll.YCV.abwG != null) && ("fetchfavordialog".equals(localfll.YCV.url)))
                {
                  paramAnonymousView = new b(WcPayCashierDialog.f(WcPayCashierDialog.this));
                  if ((localfll.YCV.abwG.Zqw.size() > 0) && (((fxx)localfll.YCV.abwG.Zqw.get(0)).abVM != null))
                  {
                    Object localObject1 = ((fxx)localfll.YCV.abwG.Zqw.get(0)).abVM.aaIH;
                    Object localObject2 = localfll.YCV.abwG.Zqu.YCT;
                    if (localObject2 != null) {
                      com.tencent.mm.plugin.wallet_core.utils.n.a(paramAnonymousView.sUt, (fmp)localObject2, null);
                    }
                    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                    {
                      localObject1 = ((List)localObject1).iterator();
                      while (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = (fll)((Iterator)localObject1).next();
                        View localView = View.inflate(paramAnonymousView.getContext(), a.g.wc_pay_cashier_fetch_favor_cell_item, null);
                        TextView localTextView1 = (TextView)localView.findViewById(a.f.wpfc_title_tv);
                        TextView localTextView2 = (TextView)localView.findViewById(a.f.wpfc_desc_tv);
                        if ((((fll)localObject2).abLS != null) && (((fll)localObject2).abLS.size() > 0))
                        {
                          com.tencent.mm.plugin.wallet_core.utils.n.a(localTextView1, (fmp)((fll)localObject2).abLS.get(0), null);
                          if (((fll)localObject2).abLS.size() >= 2) {
                            com.tencent.mm.plugin.wallet_core.utils.n.a(localTextView2, (fmp)((fll)localObject2).abLS.get(1), null);
                          }
                        }
                        paramAnonymousView.VVh.addView(localView);
                      }
                    }
                  }
                  paramAnonymousView.setOnDismissListener(new DialogInterface.OnDismissListener()
                  {
                    public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(301346);
                      WcPayCashierDialog.this.show();
                      AppMethodBeat.o(301346);
                    }
                  });
                  paramAnonymousView.show();
                  WcPayCashierDialog.this.hide();
                }
                AppMethodBeat.o(301335);
              }
            });
          }
          this.VUt.addView(localWcPayCashierDetailItemLayout);
          break;
          localWcPayCashierDetailItemLayout.xGl.setVisibility(8);
          localWcPayCashierDetailItemLayout.Olf.setMaxWidth(2147483647);
          break label149;
          label267:
          localWcPayCashierDetailItemLayout.VUi.setVisibility(8);
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
  
  public final void a(String paramString1, String paramString2, String paramString3, List<fll> paramList)
  {
    AppMethodBeat.i(71369);
    this.VUT = paramString1;
    this.VUU = paramString2;
    this.VUS = paramString3;
    this.VUV = true;
    this.VUP = false;
    ilB();
    ilw();
    ily();
    mb(paramList);
    ilv();
    ilt();
    AppMethodBeat.o(71369);
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(71368);
    Log.i("MicroMsg.WcPayCashierDialog", "activity paused, release and dismiss");
    this.VUu.gGd();
    AppMethodBeat.o(71368);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71363);
    super.onCreate(paramBundle);
    setContentView(this.tth);
    paramBundle = getWindow();
    paramBundle.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    paramBundle.setAttributes(localLayoutParams);
    paramBundle.addFlags(67108864);
    if (com.tencent.mm.wallet_core.ui.i.jPv()) {
      paramBundle.addFlags(8192);
    }
    d.rb(21);
    AppMethodBeat.o(71363);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(301436);
    super.onStart();
    if (this.VUK == 0)
    {
      if (this.VUo != null)
      {
        this.VUo.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(301349);
            WcPayCashierDialog.o(WcPayCashierDialog.this).sendAccessibilityEvent(128);
            if (WcPayCashierDialog.p(WcPayCashierDialog.this) != null) {
              WcPayCashierDialog.p(WcPayCashierDialog.this).setContentDescription(WcPayCashierDialog.this.getContext().getString(a.i.close_btn));
            }
            AppMethodBeat.o(301349);
          }
        });
        AppMethodBeat.o(301436);
      }
    }
    else if (this.VUw != null) {
      this.VUw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(301339);
          WcPayCashierDialog.q(WcPayCashierDialog.this).sendAccessibilityEvent(128);
          if (WcPayCashierDialog.p(WcPayCashierDialog.this) != null) {
            WcPayCashierDialog.p(WcPayCashierDialog.this).setContentDescription(WcPayCashierDialog.this.getContext().getString(a.i.close_btn));
          }
          AppMethodBeat.o(301339);
        }
      });
    }
    AppMethodBeat.o(301436);
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
    
    public abstract void ieE();
    
    public abstract void onCancel();
  }
  
  public static abstract interface b
  {
    public abstract void iln();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog
 * JD-Core Version:    0.7.0.1
 */