package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnFocusChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filter.FilterListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.FocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.bankcard.b.g;
import com.tencent.mm.plugin.remittance.bankcard.b.m;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.cey;
import com.tencent.mm.protocal.protobuf.dzb;
import com.tencent.mm.protocal.protobuf.eks;
import com.tencent.mm.protocal.protobuf.geo;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class BankRemitBankcardInputUI
  extends BankRemitBaseUI
{
  private com.tencent.mm.ui.widget.a.f Alz;
  private Dialog KHi = null;
  private CdnImageView OcI;
  private WalletFormView OcP;
  private WalletFormView OcQ;
  private WalletFormView OcR;
  private WalletFormView OcS;
  private ListView OcT;
  private c OcU;
  private Filter.FilterListener OcV;
  private ArrayList<TransferRecordParcel> OcW;
  private ArrayList<TransferRecordParcel> OcX;
  private int OcY;
  private int OcZ;
  private String Oda;
  private String Odb;
  private String Odc;
  private String Odd;
  private String Ode;
  private String Odf;
  private EnterTimeParcel Odg;
  private BankcardElemParcel Odh;
  private TransferRecordParcel Odi;
  private boolean Odj = true;
  private boolean Odk = false;
  private boolean Odl = false;
  private boolean Odm = false;
  private g Odn = null;
  private boolean Odo = false;
  private boolean Odp = false;
  private boolean Odq = true;
  private geo Odr;
  private boolean Ods = false;
  private boolean Odt = false;
  private boolean Odu = false;
  private String Odv;
  private String Odw;
  private String content;
  private String hTs = "";
  private WcPayBannerView pLM;
  private Button qgp;
  
  private void BF(boolean paramBoolean)
  {
    AppMethodBeat.i(67466);
    Log.i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      doSceneProgress(new m(), true);
      AppMethodBeat.o(67466);
      return;
    }
    doSceneProgress(new m(), false);
    AppMethodBeat.o(67466);
  }
  
  private static void E(String paramString, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67464);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.OcL.equals(paramString))
        {
          paramList.remove(localTransferRecordParcel);
          AppMethodBeat.o(67464);
          return;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(67464);
  }
  
  private void G(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67467);
    Log.i("MicroMsg.BankRemitBankcardInputUI", "do check bank bind: %s %s", new Object[] { paramString3, paramString4 });
    Log.d("MicroMsg.BankRemitBankcardInputUI", "payeeName: %s, bankCardNo: %s", new Object[] { paramString1, paramString2 });
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.b.d(paramString1, paramString2, paramString3, paramString4));
    AppMethodBeat.o(67467);
  }
  
  private static void a(TransferRecordParcel paramTransferRecordParcel, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67463);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.OcL.equals(paramTransferRecordParcel.OcL))
        {
          localTransferRecordParcel.OcO = paramTransferRecordParcel.OcO;
          AppMethodBeat.o(67463);
          return;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(67463);
  }
  
  private void aN(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67465);
    Log.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", new Object[] { paramString1 });
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.b.a(paramString1, paramString2, paramString3), false);
    AppMethodBeat.o(67465);
  }
  
  private void fTm()
  {
    AppMethodBeat.i(67475);
    if ((!Util.isNullOrNil(this.OcP.getText())) && (!this.OcP.getText().trim().isEmpty()) && (!Util.isNullOrNil(this.OcQ.getText())) && (this.OcP.bZp()) && (!this.OcQ.getText().trim().isEmpty()) && (this.OcQ.bZp()) && (!Util.isNullOrNil(this.OcR.getText())) && (this.OcS.getVisibility() == 0) && (!Util.isNullOrNil(this.OcS.getText())) && (this.Odh != null) && (Util.isNullOrNil(this.Odh.Ocu)))
    {
      this.qgp.setEnabled(true);
      AppMethodBeat.o(67475);
      return;
    }
    this.qgp.setEnabled(false);
    AppMethodBeat.o(67475);
  }
  
  private void gLB()
  {
    AppMethodBeat.i(67468);
    Log.i("MicroMsg.BankRemitBankcardInputUI", "do operation");
    this.Odt = true;
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.b.k(), false);
    AppMethodBeat.o(67468);
  }
  
  private void gLC()
  {
    AppMethodBeat.i(67469);
    this.OcQ.gGc();
    this.OcQ.setContentEnabled(false);
    this.Odl = true;
    AppMethodBeat.o(67469);
  }
  
  private void gLD()
  {
    AppMethodBeat.i(67470);
    this.OcR.setClickable(false);
    this.Odm = true;
    AppMethodBeat.o(67470);
  }
  
  private void gLE()
  {
    AppMethodBeat.i(67471);
    if (this.Odi != null)
    {
      this.OcP.setText(this.Odi.OcN);
      this.Odk = true;
      this.OcQ.setText(getString(a.i.bank_remit_bank_card_mask_text, new Object[] { this.Odi.OcM }));
      this.OcR.setText(this.Odi.JFk);
      this.OcI.setUrl(this.Odi.Ocp);
      gLC();
      gLD();
    }
    AppMethodBeat.o(67471);
  }
  
  private void gLF()
  {
    AppMethodBeat.i(67472);
    if (this.Odh != null)
    {
      this.OcR.setText(this.Odh.JFk);
      this.OcI.setUrl(this.Odh.Ocp);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.OcI.getLayoutParams();
      localLayoutParams.setMargins(com.tencent.mm.cd.a.fromDPToPix(getContext(), 15), 0, 0, 0);
      this.OcI.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(67472);
  }
  
  private void gLG()
  {
    AppMethodBeat.i(67473);
    if (this.Odg != null)
    {
      if (!Util.isNullOrNil(this.Odg.nRQ)) {
        this.OcS.setContentTextColor(n.dE(this.Odg.nRQ, true));
      }
      for (;;)
      {
        this.OcS.setText(this.Odg.Ocz);
        this.OcS.setVisibility(0);
        AppMethodBeat.o(67473);
        return;
        this.OcS.setContentTextColorRes(a.c.normal_text_color);
      }
    }
    if ((this.Odh != null) && (!Util.isNullOrNil(this.Odh.Ocs)))
    {
      this.OcS.setText(this.Odh.Ocs);
      if (!Util.isNullOrNil(this.Odh.Oct)) {
        this.OcS.setContentTextColor(n.dE(this.Odh.Oct, true));
      }
      for (;;)
      {
        this.OcS.setVisibility(0);
        AppMethodBeat.o(67473);
        return;
        this.OcS.setContentTextColorRes(a.c.normal_text_color);
      }
    }
    this.OcS.setVisibility(8);
    AppMethodBeat.o(67473);
  }
  
  private void gLH()
  {
    AppMethodBeat.i(67474);
    if (this.OcS.getVisibility() == 0)
    {
      this.OcR.setBackground(getResources().getDrawable(a.e.wallet_clickable_bg));
      AppMethodBeat.o(67474);
      return;
    }
    this.OcR.setBackground(getResources().getDrawable(a.e.bank_remit_form_item_corner_bg));
    AppMethodBeat.o(67474);
  }
  
  private void gLI()
  {
    AppMethodBeat.i(67476);
    if ((this.Odh != null) && (!Util.isNullOrNil(this.Odh.Ocs)))
    {
      this.Odg = null;
      AppMethodBeat.o(67476);
      return;
    }
    if ((this.Odh != null) && (this.Odh.Ocv != null))
    {
      Iterator localIterator = this.Odh.Ocv.iterator();
      while (localIterator.hasNext())
      {
        EnterTimeParcel localEnterTimeParcel = (EnterTimeParcel)localIterator.next();
        if (localEnterTimeParcel.OcB > 0)
        {
          this.Odg = localEnterTimeParcel;
          AppMethodBeat.o(67476);
          return;
        }
      }
    }
    AppMethodBeat.o(67476);
  }
  
  public void finish()
  {
    AppMethodBeat.i(67461);
    super.finish();
    try
    {
      hideVKB();
      AppMethodBeat.o(67461);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.BankRemitBankcardInputUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(67461);
    }
  }
  
  public int getLayoutId()
  {
    return a.g.bank_remit_bankcard_input_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67457);
    int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.OcP = ((WalletFormView)findViewById(a.f.brbi_name_et));
    this.OcP.getInfoIv().setLayoutParams(localLayoutParams);
    this.OcP.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.OcP.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
    this.OcP.setIsSecretAnswer(true);
    this.OcP.findViewById(a.f.wallet_info).setAccessibilityDelegate(new c((byte)0));
    this.OcP.getContentEt().setInputType(131073);
    this.OcQ = ((WalletFormView)findViewById(a.f.brbi_card_et));
    this.OcQ.getInfoIv().setLayoutParams(localLayoutParams);
    this.OcQ.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.OcQ.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
    ((TextView)this.OcQ.findViewById(a.f.wallet_title)).setAccessibilityDelegate(new b((byte)0));
    this.OcQ.getContentEt().setInputType(131073);
    this.OcR = ((WalletFormView)findViewById(a.f.brbi_bank_name_et));
    this.OcR.getContentEt().setInputType(131073);
    this.OcI = ((CdnImageView)this.OcR.findViewById(a.f.wallet_left_icon));
    this.OcS = ((WalletFormView)findViewById(a.f.brbi_arrive_time_et));
    this.OcS.getContentEt().setInputType(131073);
    this.qgp = ((Button)findViewById(a.f.brbi_next_btn));
    this.OcP.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    this.OcP.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(288765);
        if (paramAnonymousBoolean)
        {
          if ((BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this).getContentEt().getText() != null) && (BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this).getContentEt().getText().length() > 0))
          {
            AppMethodBeat.o(288765);
            return;
          }
          BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this).getInfoIv().setContentDescription(BankRemitBankcardInputUI.this.getString(a.i.bank_remit_select_payee_other_title));
          AppMethodBeat.o(288765);
          return;
        }
        BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this).getInfoIv().setContentDescription(BankRemitBankcardInputUI.this.getString(a.i.bank_remit_select_payee_other_title));
        AppMethodBeat.o(288765);
      }
    });
    this.OcP.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(67446);
        if (paramAnonymousEditable.length() == 0) {
          BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this).getInfoIv().setContentDescription(BankRemitBankcardInputUI.this.getString(a.i.bank_remit_select_payee_other_title));
        }
        BankRemitBankcardInputUI.d(BankRemitBankcardInputUI.this);
        BankRemitBankcardInputUI.e(BankRemitBankcardInputUI.this);
        if ((BankRemitBankcardInputUI.f(BankRemitBankcardInputUI.this)) && (BankRemitBankcardInputUI.g(BankRemitBankcardInputUI.this) != null)) {
          BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this).getFilter().filter(paramAnonymousEditable.toString(), BankRemitBankcardInputUI.h(BankRemitBankcardInputUI.this));
        }
        for (;;)
        {
          if (BankRemitBankcardInputUI.j(BankRemitBankcardInputUI.this)) {
            BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
          }
          BankRemitBankcardInputUI.l(BankRemitBankcardInputUI.this);
          BankRemitBankcardInputUI.m(BankRemitBankcardInputUI.this);
          if ((BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this)) && (BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this).getInputLength() <= BankRemitBankcardInputUI.o(BankRemitBankcardInputUI.this)))
          {
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this).setMaxInputLength(BankRemitBankcardInputUI.o(BankRemitBankcardInputUI.this));
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this).setFilters(new InputFilter[] { new InputFilter.LengthFilter(BankRemitBankcardInputUI.o(BankRemitBankcardInputUI.this)) });
          }
          AppMethodBeat.o(67446);
          return;
          BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, true);
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.OcP.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(67448);
        if (paramAnonymousInt == 5)
        {
          BankRemitBankcardInputUI.this.hideVKB();
          if (!BankRemitBankcardInputUI.p(BankRemitBankcardInputUI.this)) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(67447);
                BankRemitBankcardInputUI.this.showTenpayKB();
                AppMethodBeat.o(67447);
              }
            }, 200L);
          }
        }
        AppMethodBeat.o(67448);
        return false;
      }
    });
    com.tencent.mm.wallet_core.ui.formview.a.b(this.OcQ);
    setEditFocusListener(this.OcQ, 2, false, false, true);
    this.OcQ.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(67450);
        BankRemitBankcardInputUI.q(BankRemitBankcardInputUI.this);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67449);
            BankRemitBankcardInputUI.l(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67449);
          }
        }, 200L);
        AppMethodBeat.o(67450);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (!Util.isNullOrNil(this.content)) {
      this.OcQ.setText(this.content);
    }
    this.OcR.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(288768);
        BankRemitBankcardInputUI.this.hideVKB();
        BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).gGc();
        paramAnonymousView = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getText();
        if ((BankRemitBankcardInputUI.s(BankRemitBankcardInputUI.this)) && (!Util.isNullOrNil(paramAnonymousView)))
        {
          String str = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getMD5Value();
          BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, paramAnonymousView, str);
          AppMethodBeat.o(288768);
          return;
        }
        BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
        AppMethodBeat.o(288768);
      }
    });
    this.OcS.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(288769);
        Log.i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
        BankRemitBankcardInputUI.this.hideVKB();
        BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).gGc();
        if (!BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this))
        {
          paramAnonymousView = new Intent(BankRemitBankcardInputUI.this.getContext(), BankRemitSelectArriveTimeUI.class);
          if ((BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).Ocv != null)) {
            paramAnonymousView.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).Ocv);
          }
          if (BankRemitBankcardInputUI.w(BankRemitBankcardInputUI.this) != null) {
            paramAnonymousView.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.w(BankRemitBankcardInputUI.this).Ocy);
          }
          BankRemitBankcardInputUI.this.startActivityForResult(paramAnonymousView, 3);
        }
        AppMethodBeat.o(288769);
      }
    });
    this.qgp.setOnClickListener(new ac()
    {
      public final void dsb()
      {
        AppMethodBeat.i(67454);
        Log.i("MicroMsg.BankRemitBankcardInputUI", "click next btn");
        BankRemitBankcardInputUI.this.hideVKB();
        BankRemitBankcardInputUI.this.hideTenpayKB();
        if (BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this))
        {
          AppMethodBeat.o(67454);
          return;
        }
        Object localObject1 = BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this).getText();
        Object localObject2 = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getText();
        if ((Util.isNullOrNil((String)localObject1)) || (((String)localObject1).trim().isEmpty()) || (Util.isNullOrNil((String)localObject2)) || (((String)localObject2).trim().isEmpty()) || (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) == null))
        {
          Log.w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", new Object[] { localObject1, localObject2, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) });
          AppMethodBeat.o(67454);
          return;
        }
        Log.i("MicroMsg.BankRemitBankcardInputUI", "onRealClick() ifGetOperation:%s waitingGetOperation:%s ifAutoNext:%s", new Object[] { Boolean.valueOf(BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this)), Boolean.valueOf(BankRemitBankcardInputUI.x(BankRemitBankcardInputUI.this)), Boolean.valueOf(BankRemitBankcardInputUI.y(BankRemitBankcardInputUI.this)) });
        if (BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this))
        {
          if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this))
          {
            if (BankRemitBankcardInputUI.j(BankRemitBankcardInputUI.this))
            {
              Log.i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
              BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67454);
              return;
            }
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, (String)localObject1, (String)localObject2, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).JFk, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).hAk);
            AppMethodBeat.o(67454);
          }
        }
        else
        {
          BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, true);
          BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, (String)localObject1);
          BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, (String)localObject2);
          if (BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this) == null) {
            break label348;
          }
          BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).show();
        }
        for (;;)
        {
          if (!BankRemitBankcardInputUI.x(BankRemitBankcardInputUI.this)) {
            BankRemitBankcardInputUI.G(BankRemitBankcardInputUI.this);
          }
          AppMethodBeat.o(67454);
          return;
          label348:
          localObject1 = BankRemitBankcardInputUI.this;
          localObject2 = BankRemitBankcardInputUI.this;
          BankRemitBankcardInputUI.this.getString(a.i.app_empty_string);
          BankRemitBankcardInputUI.a((BankRemitBankcardInputUI)localObject1, com.tencent.mm.ui.base.k.a((Context)localObject2, BankRemitBankcardInputUI.this.getString(a.i.wallet_pay_loading), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(67453);
              Log.i("MicroMsg.BankRemitBankcardInputUI", "coperationTipDialogNoTransparent onCancel()");
              BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, false);
              BankRemitBankcardInputUI.C(BankRemitBankcardInputUI.this);
              if ((BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).isShowing())) {
                BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).dismiss();
              }
              if ((BankRemitBankcardInputUI.D(BankRemitBankcardInputUI.this).getVisibility() == 8) || (BankRemitBankcardInputUI.E(BankRemitBankcardInputUI.this).getVisibility() == 4))
              {
                Log.i("MicroMsg.BankRemitBankcardInputUI", "usr cancel, & visibility not visiable, so finish");
                BankRemitBankcardInputUI.this.finish();
              }
              BankRemitBankcardInputUI.F(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67453);
            }
          }));
        }
      }
    });
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    this.OcP.getInfoIv().setVisibility(0);
    this.OcP.getInfoIv().setClickable(true);
    this.OcP.getInfoIv().setEnabled(true);
    this.OcP.getInfoIv().setContentDescription(getString(a.i.bank_remit_select_payee_other_title));
    this.OcP.getInfoIv().setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(288772);
        Log.d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
        if ((BankRemitBankcardInputUI.U(BankRemitBankcardInputUI.this)) || (!BankRemitBankcardInputUI.V(BankRemitBankcardInputUI.this))) {
          BankRemitBankcardInputUI.W(BankRemitBankcardInputUI.this);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(14673, new Object[] { Integer.valueOf(3) });
          AppMethodBeat.o(288772);
          return;
          paramAnonymousView = new Intent(BankRemitBankcardInputUI.this.getContext(), BankRemitSelectPayeeUI.class);
          if (BankRemitBankcardInputUI.M(BankRemitBankcardInputUI.this) != null) {
            paramAnonymousView.putParcelableArrayListExtra("key_self_transfer_record_list", BankRemitBankcardInputUI.M(BankRemitBankcardInputUI.this));
          }
          if (BankRemitBankcardInputUI.N(BankRemitBankcardInputUI.this) != null) {
            paramAnonymousView.putParcelableArrayListExtra("key_freq_transfer_record_list", BankRemitBankcardInputUI.N(BankRemitBankcardInputUI.this));
          }
          BankRemitBankcardInputUI.this.startActivityForResult(paramAnonymousView, 1);
        }
      }
    });
    fTm();
    AppMethodBeat.o(67457);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(67462);
    Object localObject;
    if (paramInt1 == 1)
    {
      String str;
      Iterator localIterator;
      if (paramInt2 == -1)
      {
        this.Odj = false;
        this.Odc = paramIntent.getStringExtra("key_bank_card_seqno");
        str = this.Odc;
        if (this.OcW == null) {
          break label241;
        }
        localIterator = this.OcW.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (TransferRecordParcel)localIterator.next();
        } while (!((TransferRecordParcel)localObject).OcL.equals(str));
      }
      for (;;)
      {
        this.Odi = ((TransferRecordParcel)localObject);
        gLE();
        fTm();
        if (this.Odi != null) {
          aN(this.Odi.OcL, this.Odb, this.Odi.hAk);
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67441);
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this).gGc();
            AppMethodBeat.o(67441);
          }
        }, 50L);
        Log.i("MicroMsg.BankRemitBankcardInputUI", "resultCode: %s", new Object[] { Integer.valueOf(paramInt2) });
        if (paramIntent == null) {
          break label534;
        }
        localObject = paramIntent.getStringArrayListExtra("key_delete_seq_no_list");
        paramIntent = paramIntent.getParcelableArrayListExtra("key_modified_record_list");
        if (localObject == null) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          E(str, this.OcW);
          E(str, this.OcX);
        }
        label241:
        if (this.OcX != null)
        {
          localIterator = this.OcX.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject = (TransferRecordParcel)localIterator.next();
              if (((TransferRecordParcel)localObject).OcL.equals(str)) {
                break;
              }
            }
          }
        }
        localObject = null;
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          localObject = (TransferRecordParcel)paramIntent.next();
          a((TransferRecordParcel)localObject, this.OcW);
          a((TransferRecordParcel)localObject, this.OcX);
        }
      }
      AppMethodBeat.o(67462);
      return;
    }
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        paramInt1 = paramIntent.getIntExtra("key_enter_time_scene", -1);
        if ((this.Odh != null) && (this.Odh.Ocv != null))
        {
          paramIntent = this.Odh.Ocv.iterator();
          while (paramIntent.hasNext())
          {
            localObject = (EnterTimeParcel)paramIntent.next();
            if (((EnterTimeParcel)localObject).Ocy == paramInt1) {
              this.Odg = ((EnterTimeParcel)localObject);
            }
          }
        }
        for (;;)
        {
          gLG();
          fTm();
          AppMethodBeat.o(67462);
          return;
          Log.w("MicroMsg.BankRemitBankcardInputUI", "can't find the right enter scene: %d", new Object[] { Integer.valueOf(paramInt1) });
        }
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        this.Odh = ((BankcardElemParcel)paramIntent.getParcelableExtra("key_bank_card_elem_parcel"));
        gLF();
        gLI();
        gLG();
        gLH();
        fTm();
        AppMethodBeat.o(67462);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    label534:
    AppMethodBeat.o(67462);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67456);
    super.onCreate(paramBundle);
    hideActionbarLine();
    this.content = getIntent().getStringExtra("key_content");
    initView();
    addSceneEndListener(1348);
    addSceneEndListener(1542);
    addSceneEndListener(1378);
    addSceneEndListener(1349);
    addSceneEndListener(1280);
    this.Odf = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUx, ""));
    BF(false);
    gLB();
    setMMTitle(a.i.bank_remit_title);
    addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new BankRemitBankcardInputUI.1(this));
    com.tencent.mm.plugin.report.service.h.OAn.b(14673, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(67456);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67460);
    super.onDestroy();
    removeSceneEndListener(1348);
    removeSceneEndListener(1542);
    removeSceneEndListener(1378);
    removeSceneEndListener(1349);
    removeSceneEndListener(1280);
    AppMethodBeat.o(67460);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(67459);
    super.onResume();
    this.OcP.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67440);
        BankRemitBankcardInputUI.this.showVKB();
        AppMethodBeat.o(67440);
      }
    }, 500L);
    AppMethodBeat.o(67459);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(67458);
    Log.i("MicroMsg.BankRemitBankcardInputUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    if ((paramp instanceof com.tencent.mm.plugin.remittance.bankcard.b.a))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.b.a)paramp;
      if (!paramString.Ocb.equals(this.Odi.OcL))
      {
        Log.i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", new Object[] { paramString.Ocb, this.Odc });
        AppMethodBeat.o(67458);
        return true;
      }
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(67424);
          BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, paramString.Oca.YIM);
          BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new BankcardElemParcel(paramString.Oca.YIL));
          if (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) != null) {}
          for (paramAnonymousString = BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).JFk;; paramAnonymousString = "")
          {
            Log.i("MicroMsg.BankRemitBankcardInputUI", "response bank: %s", new Object[] { paramAnonymousString });
            BankRemitBankcardInputUI.H(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.I(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.J(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.K(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.l(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67424);
            return;
          }
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(67423);
          Log.e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.Oca.hAV), paramString.Oca.wYI });
          if (!Util.isNullOrNil(paramString.Oca.wYI)) {
            com.tencent.mm.ui.base.k.a(BankRemitBankcardInputUI.this.getContext(), paramString.Oca.wYI, null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
          }
          AppMethodBeat.o(67423);
        }
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(67455);
          Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousp });
          AppMethodBeat.o(67455);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(67458);
      return false;
      if ((paramp instanceof g))
      {
        paramString = (g)paramp;
        if (paramString == this.Odn)
        {
          Log.i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
          this.Odn = null;
        }
        if (!paramString.md5.equals(this.OcQ.getMD5Value()))
        {
          Log.i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", new Object[] { paramString.md5, this.OcQ.getMD5Value() });
          AppMethodBeat.o(67458);
          return true;
        }
        paramString.a(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67427);
            if (paramString.Ocg.YIL == null)
            {
              Log.w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
              BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67427);
              return;
            }
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new BankcardElemParcel(paramString.Ocg.YIL));
            BankRemitBankcardInputUI.H(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.I(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.J(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.K(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.l(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67427);
          }
        }).b(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67426);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.Ocg.hAV), paramString.Ocg.wYI });
            BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67426);
          }
        }).c(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67425);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousp });
            AppMethodBeat.o(67425);
          }
        });
      }
      else if ((paramp instanceof m))
      {
        paramString = (m)paramp;
        this.Odp = true;
        paramString.a(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67430);
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, false);
            BankRemitBankcardInputUI.d(BankRemitBankcardInputUI.this, paramString.Ocm.YIK);
            Log.d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", new Object[] { BankRemitBankcardInputUI.L(BankRemitBankcardInputUI.this) });
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, TransferRecordParcel.jU(paramString.Ocm.abpE));
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, TransferRecordParcel.jU(paramString.Ocm.abpD));
            Log.i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.M(BankRemitBankcardInputUI.this).size()), Integer.valueOf(BankRemitBankcardInputUI.N(BankRemitBankcardInputUI.this).size()) });
            BankRemitBankcardInputUI.O(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67430);
          }
        }).b(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67429);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", new Object[] { Integer.valueOf(paramString.Ocm.hAV), paramString.Ocm.wYI });
            if (!Util.isNullOrNil(paramString.Ocm.wYI)) {
              com.tencent.mm.ui.base.k.a(BankRemitBankcardInputUI.this.getContext(), paramString.Ocm.wYI, null, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, true);
            AppMethodBeat.o(67429);
          }
        }).c(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67428);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousp });
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, true);
            AppMethodBeat.o(67428);
          }
        });
      }
      else if ((paramp instanceof com.tencent.mm.plugin.remittance.bankcard.b.d))
      {
        paramString = (com.tencent.mm.plugin.remittance.bankcard.b.d)paramp;
        paramString.a(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67436);
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, paramString.Ocd.YIM);
            BankRemitBankcardInputUI.e(BankRemitBankcardInputUI.this, paramString.Ocd.OcN);
            BankRemitBankcardInputUI.f(BankRemitBankcardInputUI.this, paramString.Ocd.OcL);
            BankRemitBankcardInputUI.g(BankRemitBankcardInputUI.this, paramString.Ocd.OcM);
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, paramString.Ocd.Zir);
            BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67436);
          }
        }).b(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67432);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", new Object[] { Integer.valueOf(paramString.Ocd.hAV), paramString.Ocd.wYI });
            if (!Util.isNullOrNil(paramString.Ocd.wYI)) {
              com.tencent.mm.ui.base.k.a(BankRemitBankcardInputUI.this.getContext(), paramString.Ocd.wYI, null, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
            AppMethodBeat.o(67432);
          }
        }).c(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67431);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousp });
            AppMethodBeat.o(67431);
          }
        });
      }
      else if ((paramp instanceof com.tencent.mm.plugin.remittance.bankcard.b.k))
      {
        paramString = (com.tencent.mm.plugin.remittance.bankcard.b.k)paramp;
        paramString.a(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67439);
            if ((BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).isShowing())) {
              BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).dismiss();
            }
            BankRemitBankcardInputUI.P(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.C(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.h(BankRemitBankcardInputUI.this, paramString.Ock.abdT);
            BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this, paramString.Ock.abdU);
            Log.i("MicroMsg.BankRemitBankcardInputUI", "set uniqueId:%s", new Object[] { BankRemitBankcardInputUI.Q(BankRemitBankcardInputUI.this) });
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, paramString.Ock.abdV);
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, paramString.Ock.abdW);
            Log.d("MicroMsg.BankRemitBankcardInputUI", "set nameLenLimit:%s", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.o(BankRemitBankcardInputUI.this)) });
            BankRemitBankcardInputUI.R(BankRemitBankcardInputUI.this).setBannerData(paramString.Ock.ign);
            if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this))
            {
              if (BankRemitBankcardInputUI.y(BankRemitBankcardInputUI.this))
              {
                if (BankRemitBankcardInputUI.j(BankRemitBankcardInputUI.this))
                {
                  Log.i("MicroMsg.BankRemitBankcardInputUI", "NetSceneBankRemitOperation: from record goto next direct");
                  BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
                }
                for (;;)
                {
                  BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, false);
                  AppMethodBeat.o(67439);
                  return;
                  BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).JFk, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).hAk);
                }
              }
            }
            else {
              BankRemitBankcardInputUI.l(BankRemitBankcardInputUI.this);
            }
            AppMethodBeat.o(67439);
          }
        }).b(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67438);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", new Object[] { Integer.valueOf(paramString.Ock.hAV), paramString.Ock.wYI });
            if (!Util.isNullOrNil(paramString.Ock.wYI)) {
              com.tencent.mm.ui.base.k.a(BankRemitBankcardInputUI.this.getContext(), paramString.Ock.wYI, null, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
            BankRemitBankcardInputUI.this.finish();
            AppMethodBeat.o(67438);
          }
        }).c(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(67437);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousp });
            BankRemitBankcardInputUI.C(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, false);
            AppMethodBeat.o(67437);
          }
        });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(288913);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(a.class);
    AppMethodBeat.o(288913);
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
      AppMethodBeat.i(288749);
      MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.bank_remit_bankcard_input_ui);
      localConfigHelper.disable(a.f.bank_remit_bankcard_input_ui_root);
      localConfigHelper.disable(a.f.bank_remit_bankcard_input_ui_scrollview);
      localConfigHelper.disable(a.f.bank_remit_bankcard_input_ui_scrollview_content);
      localConfigHelper.disable(a.f.bank_remit_bankcard_input_ui_scrollview_content_input_area);
      Object localObject1 = root(a.f.brbi_name_et);
      ((MMBaseAccessibilityConfig.ConfigHelper)localObject1).disable(a.f.brbi_name_et);
      ((MMBaseAccessibilityConfig.ConfigHelper)localObject1).disable(a.f.wallet_prefilled);
      ((MMBaseAccessibilityConfig.ConfigHelper)localObject1).disable(a.f.wallet_form_common_root);
      localConfigHelper.focusOrder().next(a.f.wallet_title);
      localConfigHelper.focusOrder().next(a.f.wallet_content);
      localConfigHelper.focusOrder().next(a.f.wallet_info).next(a.f.name_remind_list);
      int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
      findViewById(a.f.brbi_name_et).findViewById(a.f.wallet_content);
      ((MMBaseAccessibilityConfig.ConfigHelper)localObject1).view(a.f.wallet_info).expand(i, i, i, i);
      localConfigHelper = root(a.f.brbi_card_et);
      localConfigHelper.disable(a.f.brbi_card_et);
      localConfigHelper.disable(a.f.wallet_prefilled);
      localConfigHelper.disable(a.f.wallet_form_common_root);
      localConfigHelper.focusOrder().next(a.f.wallet_title);
      localConfigHelper.focusOrder().next(a.f.wallet_content);
      localConfigHelper.focusOrder().next(a.f.wallet_info);
      localConfigHelper = root(a.f.brbi_bank_name_et);
      localConfigHelper.disable(a.f.bank_remit_bank_name_form_view_root);
      localConfigHelper.disable(a.f.wallet_title);
      localConfigHelper.disable(a.f.wallet_prefilled);
      localConfigHelper.disable(a.f.wallet_left_icon);
      localConfigHelper.disable(a.f.wallet_content);
      localConfigHelper.disable(a.f.wallet_info);
      Object localObject2 = findViewById(a.f.brbi_bank_name_et);
      localObject1 = (TextView)((View)localObject2).findViewById(a.f.wallet_title);
      localObject2 = (TenpaySecureEditText)((View)localObject2).findViewById(a.f.wallet_content);
      ((TenpaySecureEditText)localObject2).setAccessibilityDelegate(new a());
      localConfigHelper.view(a.f.brbi_bank_name_et).type(ViewType.Button).desc(new kotlin.g.a.b() {});
      localConfigHelper = root(a.f.brbi_arrive_time_et);
      localConfigHelper.disable(a.f.wallet_form_common_root);
      localConfigHelper.disable(a.f.wallet_title);
      localConfigHelper.disable(a.f.wallet_prefilled);
      localConfigHelper.disable(a.f.wallet_left_icon);
      localConfigHelper.disable(a.f.wallet_content);
      localConfigHelper.disable(a.f.wallet_info);
      localObject2 = findViewById(a.f.brbi_arrive_time_et);
      localObject1 = (TextView)((View)localObject2).findViewById(a.f.wallet_title);
      localObject2 = (TenpaySecureEditText)((View)localObject2).findViewById(a.f.wallet_content);
      ((TenpaySecureEditText)localObject2).setAccessibilityDelegate(new a());
      localConfigHelper.view(a.f.brbi_arrive_time_et).type(ViewType.Button).desc(new kotlin.g.a.b() {});
      root(a.f.custom_menu_container_outside).view(a.f.action_option_icon).desc(a.i.actionbar_more).type(ViewType.Button);
      AppMethodBeat.o(288749);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(288754);
      super.onResume();
      AppMethodBeat.o(288754);
    }
    
    public final class a
      extends View.AccessibilityDelegate
    {
      public a() {}
      
      public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
      {
        AppMethodBeat.i(288761);
        super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
        if ((paramView instanceof EditText)) {
          androidx.core.g.a.d.aK(paramView).y("");
        }
        AppMethodBeat.o(288761);
      }
    }
  }
  
  final class b
    extends View.AccessibilityDelegate
  {
    private b() {}
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(288748);
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      if (paramAccessibilityEvent.getEventType() == 32768)
      {
        paramView = (BankRemitBankcardInputUI)paramView.getContext();
        if ((paramView != null) && ((paramView instanceof BankRemitBankcardInputUI)))
        {
          paramAccessibilityEvent = paramView.findViewById(a.f.name_remind_list);
          if (paramAccessibilityEvent != null) {
            paramAccessibilityEvent.setVisibility(8);
          }
          if (BankRemitBankcardInputUI.c(paramView) != null)
          {
            BankRemitBankcardInputUI.c(paramView).gGc();
            paramView.hideVKB();
          }
        }
      }
      AppMethodBeat.o(288748);
    }
  }
  
  final class c
    extends View.AccessibilityDelegate
  {
    private c() {}
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(288747);
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      if (paramAccessibilityEvent.getEventType() == 32768)
      {
        paramView = (BankRemitBankcardInputUI)paramView.getContext();
        if ((paramView != null) && ((paramView instanceof BankRemitBankcardInputUI)) && (BankRemitBankcardInputUI.c(paramView) != null) && (BankRemitBankcardInputUI.c(paramView).getText() == null))
        {
          BankRemitBankcardInputUI.c(paramView).gGc();
          paramView.hideVKB();
        }
      }
      AppMethodBeat.o(288747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI
 * JD-Core Version:    0.7.0.1
 */