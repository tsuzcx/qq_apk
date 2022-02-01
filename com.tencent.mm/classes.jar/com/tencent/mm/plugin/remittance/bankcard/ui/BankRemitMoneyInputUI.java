package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.remittance.bankcard.b.n;
import com.tencent.mm.plugin.remittance.bankcard.b.o;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.ui.RemittanceRemarkInputHalfPage;
import com.tencent.mm.plugin.remittance.ui.RemittanceRemarkInputHalfPage.b;
import com.tencent.mm.plugin.remittance.ui.RemittanceRemarkInputHalfPage.c;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.err;
import com.tencent.mm.protocal.protobuf.gen;
import com.tencent.mm.protocal.protobuf.geo;
import com.tencent.mm.protocal.protobuf.gep;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.model.ah;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.io.IOException;
import java.util.HashSet;

public class BankRemitMoneyInputUI
  extends BankRemitBaseUI
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  public String KFd;
  private CdnImageView OcI;
  private TextView OcK;
  private String OeA;
  private String OeB;
  private String OeC;
  private String OeD;
  private int OeE;
  private int OeF;
  private com.tencent.mm.plugin.wallet_core.ui.s OeG;
  private long OeH;
  public int OeI;
  private int OeJ;
  private int OeK;
  private RemittanceRemarkInputHalfPage OeL;
  private geo OeM;
  public String Oed;
  private TextView Oen;
  private WalletFormView Oeo;
  private LinearLayout Oep;
  private TextView Oeq;
  private TextView Oer;
  private TextView Oes;
  private TextView Oet;
  private ViewGroup Oeu;
  private ViewGroup Oev;
  private TextView Oew;
  private CdnImageView Oex;
  private CdnImageView Oey;
  private BankcardElemParcel Oez;
  private String mBankType;
  private String mDesc;
  private ScrollView pJa;
  private Button qgp;
  
  public BankRemitMoneyInputUI()
  {
    AppMethodBeat.i(67556);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    this.mDesc = "";
    this.OeI = 0;
    AppMethodBeat.o(67556);
  }
  
  private void bVu()
  {
    AppMethodBeat.i(67562);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!Util.isNullOrNil(this.mDesc))
    {
      localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), this.mDesc));
      localSpannableStringBuilder.append(" " + getString(a.i.bank_remit_remittance_desc_modify_text));
      localSpannableStringBuilder.setSpan(this.OeG, this.mDesc.length(), localSpannableStringBuilder.length(), 34);
    }
    for (;;)
    {
      this.Oet.setText(localSpannableStringBuilder);
      AppMethodBeat.o(67562);
      return;
      localSpannableStringBuilder.append(getString(a.i.bank_remit_remittance_desc_text));
      localSpannableStringBuilder.setSpan(this.OeG, 0, localSpannableStringBuilder.length(), 18);
    }
  }
  
  private void fTm()
  {
    AppMethodBeat.i(67563);
    if ((Util.getDouble(this.Oeo.getText(), 0.0D) > 0.0D) && (!Util.isNullOrNil(this.OeB)) && (!Util.isNullOrNil(this.OeC)) && (!Util.isNullOrNil(this.mBankType)) && (!Util.isNullOrNil(this.OeD)))
    {
      this.qgp.setEnabled(true);
      AppMethodBeat.o(67563);
      return;
    }
    Log.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", new Object[] { this.Oeo.getText(), Boolean.valueOf(Util.isNullOrNil(this.OeB)), Boolean.valueOf(Util.isNullOrNil(this.OeC)), Boolean.valueOf(Util.isNullOrNil(this.mBankType)), Boolean.valueOf(Util.isNullOrNil(this.OeD)) });
    this.qgp.setEnabled(false);
    AppMethodBeat.o(67563);
  }
  
  public final void aKP(String paramString)
  {
    AppMethodBeat.i(288915);
    Log.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", new Object[] { this.Oed, paramString });
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.b.c(this.Oed, paramString), false);
    AppMethodBeat.o(288915);
  }
  
  public int getLayoutId()
  {
    return a.g.bank_remit_money_input_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67558);
    this.pJa = ((ScrollView)findViewById(a.f.root_view));
    this.OcI = ((CdnImageView)findViewById(a.f.brmi_bank_logo_iv));
    this.OcK = ((TextView)findViewById(a.f.brmi_bank_name_tv));
    this.Oen = ((TextView)findViewById(a.f.brmi_payee_tv));
    this.Oeo = ((WalletFormView)findViewById(a.f.brmi_bank_money_input_tv));
    this.Oep = ((LinearLayout)findViewById(a.f.brmi_fee_rate_layout));
    this.Oeq = ((TextView)this.Oep.findViewById(a.f.brmi_fee_rate_title_tv));
    this.Oer = ((TextView)this.Oep.findViewById(a.f.brmi_fee_tv));
    this.Oes = ((TextView)this.Oep.findViewById(a.f.brmi_total_money_tv));
    this.Oet = ((TextView)this.Oep.findViewById(a.f.brmi_remit_desc_tv));
    this.qgp = ((Button)findViewById(a.f.brmi_next_btn));
    this.Oeu = ((ViewGroup)findViewById(a.f.remittance_new_warning_layout));
    this.Oev = ((ViewGroup)this.Oeu.findViewById(a.f.remittance_warning_click_ll));
    this.Oew = ((TextView)this.Oeu.findViewById(a.f.remittance_warning_tips));
    this.Oex = ((CdnImageView)this.Oeu.findViewById(a.f.remittance_warning_left_logo));
    this.Oey = ((CdnImageView)this.Oeu.findViewById(a.f.remittance_warning_right_logo));
    this.Oeq.setText(getString(a.i.bank_remit_fee_rate_text, new Object[] { this.Oez.Ocw }));
    this.OcI.setUrl(this.Oez.Ocp);
    this.OcK.setText(getString(a.i.bank_remit_select_payee_name_with_remark, new Object[] { this.Oez.JFk, this.OeC }));
    this.Oen.setText(this.OeA);
    this.Oeo.setTitleText(ai.jOX());
    setEditFocusListener(this.Oeo, 2, false);
    this.Oeo.setmContentAbnormalMoneyCheck(true);
    this.Oeo.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(67544);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 2)) {
          WalletFormView.a(BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this).getContentEt(), str, i + 3, j);
        }
        paramAnonymousEditable = paramAnonymousEditable.toString();
        if ((!Util.isNullOrNil(paramAnonymousEditable)) && (Util.getDouble(paramAnonymousEditable, 0.0D) > 0.0D)) {
          BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this).setVisibility(0);
        }
        for (;;)
        {
          BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramAnonymousEditable);
          BankRemitMoneyInputUI.c(BankRemitMoneyInputUI.this);
          AppMethodBeat.o(67544);
          return;
          BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this).setVisibility(8);
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Oet.setClickable(true);
    this.Oet.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(this));
    this.OeG = new com.tencent.mm.plugin.wallet_core.ui.s(new s.a()
    {
      public final void eS(View paramAnonymousView)
      {
        AppMethodBeat.i(67554);
        if (BankRemitMoneyInputUI.j(BankRemitMoneyInputUI.this) == null) {
          BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, new RemittanceRemarkInputHalfPage(BankRemitMoneyInputUI.this, 10, "", RemittanceRemarkInputHalfPage.b.OsA));
        }
        paramAnonymousView = BankRemitMoneyInputUI.this.getString(a.i.bank_remit_transfer_wording, new Object[] { this.OeQ });
        BankRemitMoneyInputUI.j(BankRemitMoneyInputUI.this).a(BankRemitMoneyInputUI.k(BankRemitMoneyInputUI.this), paramAnonymousView, new RemittanceRemarkInputHalfPage.c()
        {
          public final void f(boolean paramAnonymous2Boolean, String paramAnonymous2String1, String paramAnonymous2String2)
          {
            AppMethodBeat.i(288751);
            if (!paramAnonymous2Boolean)
            {
              if (Util.isNullOrNil(paramAnonymous2String1)) {
                break label44;
              }
              BankRemitMoneyInputUI.c(BankRemitMoneyInputUI.this, paramAnonymous2String1);
            }
            for (;;)
            {
              BankRemitMoneyInputUI.l(BankRemitMoneyInputUI.this);
              AppMethodBeat.o(288751);
              return;
              label44:
              BankRemitMoneyInputUI.c(BankRemitMoneyInputUI.this, "");
            }
          }
        });
        com.tencent.mm.plugin.report.service.h.OAn.b(14673, new Object[] { Integer.valueOf(4) });
        AppMethodBeat.o(67554);
      }
    });
    bVu();
    this.qgp.setOnClickListener(new ac()
    {
      public final void dsb()
      {
        AppMethodBeat.i(67546);
        Log.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
        double d = com.tencent.mm.plugin.remittance.bankcard.model.a.lv(BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this).getText(), "100");
        if (d <= 0.0D)
        {
          Log.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", new Object[] { Double.valueOf(d) });
          Toast.makeText(BankRemitMoneyInputUI.this, a.i.bank_remit_illegal_arg_text, 1).show();
          AppMethodBeat.o(67546);
          return;
        }
        BankRemitMoneyInputUI.d(BankRemitMoneyInputUI.this);
        AppMethodBeat.o(67546);
      }
    });
    fTm();
    geo localgeo;
    int i;
    int j;
    int k;
    if ((this.OeM != null) && (this.OeM.abaE == 1) && (this.OeM.acca != null) && (!Util.isNullOrNil(this.OeM.acca.wording)))
    {
      localgeo = this.OeM;
      final gep localgep = localgeo.acca;
      this.Oeu.setVisibility(0);
      Log.i("MicroMsg.BankRemitMoneyInputUI", "warning textInfo.wording:%s", new Object[] { localgep.wording });
      this.Oew.setText(localgep.wording);
      if ((aw.isDarkMode()) && (!Util.isNullOrNil(localgeo.accb)))
      {
        this.Oew.setTextColor(i.aHm(localgeo.accb));
        i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 20.0F);
        j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 8.0F);
        k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 16.0F);
        if ((!aw.isDarkMode()) || (Util.isNullOrNil(localgeo.accd))) {
          break label760;
        }
        this.Oex.w(localgeo.accd, i, i, -1);
        label647:
        if ((!aw.isDarkMode()) || (Util.isNullOrNil(localgeo.accf))) {
          break label778;
        }
        this.Oey.w(localgeo.accf, j, k, -1);
        label679:
        this.Oeu.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(288743);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)BankRemitMoneyInputUI.n(BankRemitMoneyInputUI.this).getLayoutParams();
            if (BankRemitMoneyInputUI.o(BankRemitMoneyInputUI.this).isShown()) {}
            for (localLayoutParams.width = (BankRemitMoneyInputUI.o(BankRemitMoneyInputUI.this).getRight() + com.tencent.mm.cd.a.fromDPToPix(BankRemitMoneyInputUI.this.getContext(), 8));; localLayoutParams.width = (BankRemitMoneyInputUI.p(BankRemitMoneyInputUI.this).getRight() + com.tencent.mm.cd.a.fromDPToPix(BankRemitMoneyInputUI.this.getContext(), 8)))
            {
              localLayoutParams.height = com.tencent.mm.cd.a.fromDPToPix(BankRemitMoneyInputUI.this.getContext(), 36);
              BankRemitMoneyInputUI.n(BankRemitMoneyInputUI.this).setLayoutParams(localLayoutParams);
              if (!BankRemitMoneyInputUI.o(BankRemitMoneyInputUI.this).isShown()) {
                break;
              }
              BankRemitMoneyInputUI.p(BankRemitMoneyInputUI.this).setMaxWidth(BankRemitMoneyInputUI.q(BankRemitMoneyInputUI.this).getWidth() - com.tencent.mm.cd.a.fromDPToPix(BankRemitMoneyInputUI.this.getContext(), 20) - com.tencent.mm.cd.a.fromDPToPix(BankRemitMoneyInputUI.this.getContext(), 8) - com.tencent.mm.cd.a.fromDPToPix(BankRemitMoneyInputUI.this.getContext(), 12) - com.tencent.mm.cd.a.fromDPToPix(BankRemitMoneyInputUI.this.getContext(), 16));
              AppMethodBeat.o(288743);
              return;
            }
            BankRemitMoneyInputUI.p(BankRemitMoneyInputUI.this).setMaxWidth(BankRemitMoneyInputUI.q(BankRemitMoneyInputUI.this).getWidth() - com.tencent.mm.cd.a.fromDPToPix(BankRemitMoneyInputUI.this.getContext(), 20) - com.tencent.mm.cd.a.fromDPToPix(BankRemitMoneyInputUI.this.getContext(), 8) - com.tencent.mm.cd.a.fromDPToPix(BankRemitMoneyInputUI.this.getContext(), 12));
            AppMethodBeat.o(288743);
          }
        }, 10L);
        this.Oev.setClickable(true);
        this.Oev.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(288744);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitMoneyInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            Log.i("MicroMsg.BankRemitMoneyInputUI", " click option item : %s ,type:%s", new Object[] { localgep.wording, Integer.valueOf(localgep.accg.type) });
            switch (localgep.accg.type)
            {
            default: 
              Log.e("MicroMsg.BankRemitMoneyInputUI", "unknow text info type");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitMoneyInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(288744);
              return;
              Log.i("MicroMsg.BankRemitMoneyInputUI", " textInfo.jumpInfo.url ：%s", new Object[] { localgep.accg.url });
              i.p(BankRemitMoneyInputUI.this.getContext(), localgep.accg.url, false);
              continue;
              Log.i("MicroMsg.BankRemitMoneyInputUI", " textInfo.jumpInfo.username ：%s", new Object[] { localgep.accg.username });
              i.y(localgep.accg.username, localgep.accg.OkP, 0, 1000);
              continue;
              Log.e("MicroMsg.BankRemitMoneyInputUI", " text info type is OPTIONS_MENU_ITEM_JUMP_TYPE_NATIVE");
            }
          }
        });
      }
    }
    for (;;)
    {
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(67547);
          if (paramAnonymousBoolean)
          {
            BankRemitMoneyInputUI.e(BankRemitMoneyInputUI.this);
            AppMethodBeat.o(67547);
            return;
          }
          BankRemitMoneyInputUI.f(BankRemitMoneyInputUI.this).scrollTo(0, 0);
          AppMethodBeat.o(67547);
        }
      });
      AppMethodBeat.o(67558);
      return;
      this.Oew.setTextColor(i.aHm(localgeo.absh));
      break;
      label760:
      this.Oex.w(localgeo.accc, i, i, -1);
      break label647;
      label778:
      if ((!aw.isDarkMode()) && (!Util.isNullOrNil(localgeo.acce)))
      {
        this.Oey.w(localgeo.acce, j, k, -1);
        break label679;
      }
      this.Oey.setVisibility(8);
      break label679;
      Log.i("MicroMsg.BankRemitMoneyInputUI", "  do not show WarningView");
      this.Oeu.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(67561);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
        Object localObject = new Intent(getContext(), BankRemitDetailUI.class);
        ((Intent)localObject).putExtra("key_transfer_bill_id", this.Oed);
        ((Intent)localObject).putExtra("key_enter_scene", 0);
        startActivityForResult((Intent)localObject, 2);
        localObject = "";
        if (paramIntent != null) {
          localObject = paramIntent.getStringExtra("key_trans_id");
        }
        aKP((String)localObject);
        this.OeI = 1;
        paramIntent = new n(this.Oed, this.KFd, 1);
      }
      for (;;)
      {
        doSceneProgress(paramIntent, false);
        AppMethodBeat.o(67561);
        return;
        if (ah.cq(paramIntent))
        {
          finish();
          AppMethodBeat.o(67561);
          return;
        }
        if (ah.cr(paramIntent))
        {
          AppMethodBeat.o(67561);
          return;
        }
        Log.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", new Object[] { Integer.valueOf(paramInt2) });
        this.OeI = paramIntent.getIntExtra("key_pay_reslut_type", 0);
        paramIntent = new n(this.Oed, this.KFd, this.OeI);
        Log.i("MicroMsg.BankRemitMoneyInputUI", "onActivityResult() requestCode == REQ_PAY resultCode != RESULT_OK  mUnpayType:%s", new Object[] { Integer.valueOf(this.OeI) });
      }
    }
    if (paramInt1 == 2)
    {
      Log.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
      paramIntent = new Intent();
      paramIntent.addFlags(67108864);
      com.tencent.mm.br.c.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", paramIntent);
      AppMethodBeat.o(67561);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67561);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67557);
    super.onCreate(paramBundle);
    hideActionbarLine();
    addSceneEndListener(1380);
    addSceneEndListener(2739);
    int j = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUv, Integer.valueOf(10))).intValue();
    int i = j;
    if (j < 0) {
      i = 10;
    }
    this.OeJ = i;
    j = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUw, Integer.valueOf(5000000))).intValue();
    i = j;
    if (j <= 0) {
      i = 5000000;
    }
    this.OeK = i;
    Log.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", new Object[] { Integer.valueOf(this.OeJ), Integer.valueOf(this.OeK) });
    this.KFd = getIntent().getStringExtra("key_unique_id");
    this.Oez = ((BankcardElemParcel)getIntent().getParcelableExtra("key_bank_card_elem_parcel"));
    this.OeA = getIntent().getStringExtra("key_payee_name");
    this.OeB = getIntent().getStringExtra("key_bank_card_seqno");
    this.OeC = getIntent().getStringExtra("key_bank_card_tailno");
    this.OeD = getIntent().getStringExtra("key_encrypt_data");
    this.OeE = getIntent().getIntExtra("key_enter_time_scene", 0);
    this.OeF = getIntent().getIntExtra("key_input_type", 0);
    paramBundle = getIntent().getByteArrayExtra("key_notice_item");
    geo localgeo;
    if (paramBundle != null) {
      localgeo = new geo();
    }
    try
    {
      localgeo.parseFrom(paramBundle);
      this.OeM = localgeo;
      Log.d("MicroMsg.BankRemitMoneyInputUI", "set uniqueId:%s", new Object[] { this.KFd });
      if (this.Oez == null)
      {
        Log.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
        this.Oez = new BankcardElemParcel();
      }
      this.mBankType = this.Oez.hAk;
      initView();
      setMMTitle(a.i.bank_remit_title);
      com.tencent.mm.wallet_core.b.jNX();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(c.a.yRc, true);
      AppMethodBeat.o(67557);
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BankRemitMoneyInputUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67560);
    super.onDestroy();
    removeSceneEndListener(1380);
    removeSceneEndListener(2739);
    AppMethodBeat.o(67560);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(67559);
    if ((paramp instanceof o))
    {
      paramString = (o)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(67550);
          Log.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", new Object[] { paramString.Oco.Hgk, paramString.Oco.YYi });
          Log.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", new Object[] { paramString.Oco.OcN, paramString.Oco.JFk });
          BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this, paramString.Oco.YYi);
          if (!BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString))
          {
            BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString.Oco.Hgk, paramString.Oco.OcN, paramString.Oco.JFk, paramString.Oco.OcM);
            AppMethodBeat.o(67550);
            return;
          }
          if (BankRemitMoneyInputUI.i(BankRemitMoneyInputUI.this)) {
            BankRemitMoneyInputUI.this.hideLoading();
          }
          AppMethodBeat.o(67550);
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(67549);
          Log.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", new Object[] { Integer.valueOf(paramString.Oco.hAV), paramString.Oco.wYI });
          BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString);
          if (BankRemitMoneyInputUI.h(BankRemitMoneyInputUI.this)) {
            BankRemitMoneyInputUI.this.hideLoading();
          }
          AppMethodBeat.o(67549);
        }
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(67548);
          Log.e("MicroMsg.BankRemitMoneyInputUI", "net error: %s", new Object[] { paramAnonymousp });
          if (BankRemitMoneyInputUI.g(BankRemitMoneyInputUI.this)) {
            BankRemitMoneyInputUI.this.hideLoading();
          }
          AppMethodBeat.o(67548);
        }
      });
    }
    AppMethodBeat.o(67559);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean shouldEnsureSoterConnection()
  {
    return true;
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(288919);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(a.class);
    AppMethodBeat.o(288919);
  }
  
  public static class a
    extends MMBaseAccessibilityConfig
  {
    public a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
    
    public void initConfig()
    {
      AppMethodBeat.i(288737);
      MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.bank_remit_money_input_ui);
      localConfigHelper.disable(a.f.root_view);
      localConfigHelper.disable(a.f.root_view_content);
      localConfigHelper.disable(a.f.bank_remit_money_input_input_content_root);
      localConfigHelper.disable(a.f.brmi_bank_money_input_tv);
      localConfigHelper.disable(a.f.brmi_fee_rate_layout);
      localConfigHelper.disable(a.f.brmi_fee_rate_title_tv);
      localConfigHelper.disable(a.f.brmi_fee_tv);
      localConfigHelper.disable(a.f.total_fee_title_tv);
      localConfigHelper.disable(a.f.brmi_total_money_tv);
      localConfigHelper.view(a.f.service_fee_rate_layout).descFormat(a.i.bank_remit_money_input_fee_rate_accessibility).valueByView(a.f.brmi_fee_rate_title_tv).valueByView(a.f.brmi_fee_tv);
      localConfigHelper.view(a.f.total_fee_layout).descFormat(a.i.bank_remit_money_input_total_fee_accessibility).valueByView(a.f.total_fee_title_tv).valueByView(a.f.brmi_total_money_tv);
      localConfigHelper = root(a.g.wallet_remittance_form_money);
      localConfigHelper.disable(a.f.wallet_title);
      localConfigHelper.disable(a.f.wallet_prefilled);
      localConfigHelper.disable(a.f.wallet_content);
      localConfigHelper.focusFirst(a.f.money_et_layout);
      final TenpaySecureEditText localTenpaySecureEditText = (TenpaySecureEditText)findViewById(a.f.brmi_bank_money_input_tv).findViewById(a.f.wallet_content);
      localConfigHelper.view(a.f.money_et_layout).clickAs(a.f.wallet_content).type(ViewType.EditText).desc(new kotlin.g.a.b() {});
      AppMethodBeat.o(288737);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(288738);
      super.onResume();
      AppMethodBeat.o(288738);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI
 * JD-Core Version:    0.7.0.1
 */