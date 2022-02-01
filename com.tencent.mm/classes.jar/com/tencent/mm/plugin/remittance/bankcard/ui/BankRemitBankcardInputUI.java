package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filter.FilterListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.bankcard.a.d;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.plugin.remittance.bankcard.a.m;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.axo;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankRemitBankcardInputUI
  extends BankRemitBaseUI
{
  private String content;
  private String dCl = "";
  private Button jtd;
  private com.tencent.mm.ui.widget.a.e rIV;
  private Dialog vMm = null;
  private ListPopupWindow yiA;
  private c yiB;
  private Filter.FilterListener yiC;
  private ArrayList<TransferRecordParcel> yiD;
  private ArrayList<TransferRecordParcel> yiE;
  private int yiF;
  private int yiG;
  private String yiH;
  private String yiI;
  private String yiJ;
  private String yiK;
  private String yiL;
  private String yiM;
  private EnterTimeParcel yiN;
  private BankcardElemParcel yiO;
  private TransferRecordParcel yiP;
  private boolean yiQ = true;
  private boolean yiR = false;
  private boolean yiS = false;
  private boolean yiT = false;
  private com.tencent.mm.plugin.remittance.bankcard.a.g yiU = null;
  private boolean yiV = false;
  private boolean yiW = false;
  private boolean yiX = true;
  private boolean yiY = false;
  private boolean yiZ = false;
  private CdnImageView yip;
  private WalletFormView yiw;
  private WalletFormView yix;
  private WalletFormView yiy;
  private WalletFormView yiz;
  private boolean yja = false;
  private String yjb;
  private String yjc;
  
  private static void a(TransferRecordParcel paramTransferRecordParcel, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67463);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.yis.equals(paramTransferRecordParcel.yis))
        {
          localTransferRecordParcel.yiv = paramTransferRecordParcel.yiv;
          AppMethodBeat.o(67463);
          return;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(67463);
  }
  
  private void at(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67465);
    ae.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", new Object[] { paramString1 });
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.a(paramString1, paramString2, paramString3), false);
    AppMethodBeat.o(67465);
  }
  
  private void dLZ()
  {
    AppMethodBeat.i(67468);
    ae.i("MicroMsg.BankRemitBankcardInputUI", "do operation");
    this.yiZ = true;
    doSceneProgress(new k(), false);
    AppMethodBeat.o(67468);
  }
  
  private void dMa()
  {
    AppMethodBeat.i(67469);
    this.yix.dHu();
    this.yix.setContentEnabled(false);
    this.yiS = true;
    AppMethodBeat.o(67469);
  }
  
  private void dMb()
  {
    AppMethodBeat.i(67470);
    this.yiy.setClickable(false);
    this.yiT = true;
    AppMethodBeat.o(67470);
  }
  
  private void dMc()
  {
    AppMethodBeat.i(67471);
    if (this.yiP != null)
    {
      this.yiw.setText(this.yiP.yiu);
      this.yiR = true;
      this.yix.setText(getString(2131756358, new Object[] { this.yiP.yit }));
      this.yiy.setText(this.yiP.uVs);
      this.yip.setUrl(this.yiP.yhW);
      dMa();
      dMb();
    }
    AppMethodBeat.o(67471);
  }
  
  private void dMd()
  {
    AppMethodBeat.i(67472);
    if (this.yiO != null)
    {
      this.yiy.setText(this.yiO.uVs);
      this.yip.setUrl(this.yiO.yhW);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.yip.getLayoutParams();
      localLayoutParams.setMargins(com.tencent.mm.cb.a.fromDPToPix(getContext(), 15), 0, 0, 0);
      this.yip.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(67472);
  }
  
  private void dMe()
  {
    AppMethodBeat.i(67473);
    if (this.yiN != null)
    {
      if (!bu.isNullOrNil(this.yiN.hDr)) {
        this.yiz.setContentTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.yiN.hDr, true));
      }
      for (;;)
      {
        this.yiz.setText(this.yiN.yig);
        this.yiz.setVisibility(0);
        AppMethodBeat.o(67473);
        return;
        this.yiz.setContentTextColorRes(2131100711);
      }
    }
    if ((this.yiO != null) && (!bu.isNullOrNil(this.yiO.yhZ)))
    {
      this.yiz.setText(this.yiO.yhZ);
      if (!bu.isNullOrNil(this.yiO.yia)) {
        this.yiz.setContentTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.yiO.yia, true));
      }
      for (;;)
      {
        this.yiz.setVisibility(0);
        AppMethodBeat.o(67473);
        return;
        this.yiz.setContentTextColorRes(2131100711);
      }
    }
    this.yiz.setVisibility(8);
    AppMethodBeat.o(67473);
  }
  
  private void dMf()
  {
    AppMethodBeat.i(67474);
    if (this.yiz.getVisibility() == 0)
    {
      this.yiy.setBackground(getResources().getDrawable(2131234650));
      AppMethodBeat.o(67474);
      return;
    }
    this.yiy.setBackground(getResources().getDrawable(2131231123));
    AppMethodBeat.o(67474);
  }
  
  private void dMg()
  {
    AppMethodBeat.i(67475);
    if ((!bu.isNullOrNil(this.yiw.getText())) && (!this.yiw.getText().trim().isEmpty()) && (!bu.isNullOrNil(this.yix.getText())) && (this.yiw.aVz()) && (!this.yix.getText().trim().isEmpty()) && (this.yix.aVz()) && (!bu.isNullOrNil(this.yiy.getText())) && (this.yiz.getVisibility() == 0) && (!bu.isNullOrNil(this.yiz.getText())) && (this.yiO != null) && (bu.isNullOrNil(this.yiO.yib)))
    {
      this.jtd.setEnabled(true);
      AppMethodBeat.o(67475);
      return;
    }
    this.jtd.setEnabled(false);
    AppMethodBeat.o(67475);
  }
  
  private void dMh()
  {
    AppMethodBeat.i(67476);
    if ((this.yiO != null) && (!bu.isNullOrNil(this.yiO.yhZ)))
    {
      this.yiN = null;
      AppMethodBeat.o(67476);
      return;
    }
    if ((this.yiO != null) && (this.yiO.yic != null))
    {
      Iterator localIterator = this.yiO.yic.iterator();
      while (localIterator.hasNext())
      {
        EnterTimeParcel localEnterTimeParcel = (EnterTimeParcel)localIterator.next();
        if (localEnterTimeParcel.yii > 0)
        {
          this.yiN = localEnterTimeParcel;
          AppMethodBeat.o(67476);
          return;
        }
      }
    }
    AppMethodBeat.o(67476);
  }
  
  private void qr(boolean paramBoolean)
  {
    AppMethodBeat.i(67466);
    ae.i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      doSceneProgress(new m(), true);
      AppMethodBeat.o(67466);
      return;
    }
    doSceneProgress(new m(), false);
    AppMethodBeat.o(67466);
  }
  
  private void v(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67467);
    ae.i("MicroMsg.BankRemitBankcardInputUI", "do check bank bind: %s %s", new Object[] { paramString3, paramString4 });
    ae.d("MicroMsg.BankRemitBankcardInputUI", "payeeName: %s, bankCardNo: %s", new Object[] { paramString1, paramString2 });
    doSceneProgress(new d(paramString1, paramString2, paramString3, paramString4));
    AppMethodBeat.o(67467);
  }
  
  private static void w(String paramString, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67464);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.yis.equals(paramString))
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
      ae.e("MicroMsg.BankRemitBankcardInputUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(67461);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493150;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67457);
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.yiw = ((WalletFormView)findViewById(2131297515));
    this.yiw.getInfoIv().setLayoutParams(localLayoutParams);
    this.yiw.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.yiw.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.yix = ((WalletFormView)findViewById(2131297514));
    this.yix.getInfoIv().setLayoutParams(localLayoutParams);
    this.yix.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.yix.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.yiy = ((WalletFormView)findViewById(2131297513));
    this.yip = ((CdnImageView)this.yiy.findViewById(2131306748));
    this.yiz = ((WalletFormView)findViewById(2131297512));
    this.jtd = ((Button)findViewById(2131297516));
    this.yiw.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    this.yiw.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(67446);
        BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this);
        BankRemitBankcardInputUI.d(BankRemitBankcardInputUI.this);
        if ((BankRemitBankcardInputUI.e(BankRemitBankcardInputUI.this)) && (BankRemitBankcardInputUI.f(BankRemitBankcardInputUI.this) != null)) {
          BankRemitBankcardInputUI.h(BankRemitBankcardInputUI.this).getFilter().filter(paramAnonymousEditable.toString(), BankRemitBankcardInputUI.g(BankRemitBankcardInputUI.this));
        }
        for (;;)
        {
          if (BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this)) {
            BankRemitBankcardInputUI.j(BankRemitBankcardInputUI.this);
          }
          BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
          BankRemitBankcardInputUI.l(BankRemitBankcardInputUI.this);
          if ((BankRemitBankcardInputUI.m(BankRemitBankcardInputUI.this)) && (BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this).getInputLength() <= BankRemitBankcardInputUI.o(BankRemitBankcardInputUI.this)))
          {
            BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this).setMaxInputLength(BankRemitBankcardInputUI.o(BankRemitBankcardInputUI.this));
            BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this).setFilters(new InputFilter[] { new InputFilter.LengthFilter(BankRemitBankcardInputUI.o(BankRemitBankcardInputUI.this)) });
          }
          AppMethodBeat.o(67446);
          return;
          BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, true);
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.yiw.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(67448);
        if (paramAnonymousInt == 5)
        {
          BankRemitBankcardInputUI.this.hideVKB();
          if (!BankRemitBankcardInputUI.p(BankRemitBankcardInputUI.this)) {
            ar.o(new Runnable()
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
    this.yiw.fWE();
    com.tencent.mm.wallet_core.ui.formview.a.b(this.yix);
    setEditFocusListener(this.yix, 2, false, false, true);
    this.yix.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(67450);
        BankRemitBankcardInputUI.q(BankRemitBankcardInputUI.this);
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67449);
            BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67449);
          }
        }, 200L);
        AppMethodBeat.o(67450);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (!bu.isNullOrNil(this.content)) {
      this.yix.setText(this.content);
    }
    this.yiy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67451);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        BankRemitBankcardInputUI.this.hideVKB();
        paramAnonymousView = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getText();
        if ((BankRemitBankcardInputUI.s(BankRemitBankcardInputUI.this)) && (!bu.isNullOrNil(paramAnonymousView)))
        {
          localObject = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getMD5Value();
          BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, paramAnonymousView, (String)localObject);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67451);
          return;
          BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
        }
      }
    });
    this.yiz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67452);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
        BankRemitBankcardInputUI.this.hideVKB();
        BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).dHu();
        if (!BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this))
        {
          paramAnonymousView = new Intent(BankRemitBankcardInputUI.this.getContext(), BankRemitSelectArriveTimeUI.class);
          if ((BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).yic != null)) {
            paramAnonymousView.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).yic);
          }
          if (BankRemitBankcardInputUI.w(BankRemitBankcardInputUI.this) != null) {
            paramAnonymousView.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.w(BankRemitBankcardInputUI.this).yif);
          }
          BankRemitBankcardInputUI.this.startActivityForResult(paramAnonymousView, 3);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67452);
      }
    });
    this.jtd.setOnClickListener(new w()
    {
      public final void ccc()
      {
        AppMethodBeat.i(67454);
        ae.i("MicroMsg.BankRemitBankcardInputUI", "click next btn");
        BankRemitBankcardInputUI.this.hideVKB();
        BankRemitBankcardInputUI.this.hideTenpayKB();
        if (BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this))
        {
          AppMethodBeat.o(67454);
          return;
        }
        Object localObject1 = BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this).getText();
        Object localObject2 = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getText();
        if ((bu.isNullOrNil((String)localObject1)) || (((String)localObject1).trim().isEmpty()) || (bu.isNullOrNil((String)localObject2)) || (((String)localObject2).trim().isEmpty()) || (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) == null))
        {
          ae.w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", new Object[] { localObject1, localObject2, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) });
          AppMethodBeat.o(67454);
          return;
        }
        ae.i("MicroMsg.BankRemitBankcardInputUI", "onRealClick() ifGetOperation:%s waitingGetOperation:%s ifAutoNext:%s", new Object[] { Boolean.valueOf(BankRemitBankcardInputUI.m(BankRemitBankcardInputUI.this)), Boolean.valueOf(BankRemitBankcardInputUI.x(BankRemitBankcardInputUI.this)), Boolean.valueOf(BankRemitBankcardInputUI.y(BankRemitBankcardInputUI.this)) });
        if (BankRemitBankcardInputUI.m(BankRemitBankcardInputUI.this))
        {
          if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this))
          {
            if (BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this))
            {
              ae.i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
              BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67454);
              return;
            }
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, (String)localObject1, (String)localObject2, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).uVs, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).dlT);
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
          BankRemitBankcardInputUI.this.getString(2131755726);
          BankRemitBankcardInputUI.a((BankRemitBankcardInputUI)localObject1, h.b((Context)localObject2, BankRemitBankcardInputUI.this.getString(2131765693), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(67453);
              ae.i("MicroMsg.BankRemitBankcardInputUI", "coperationTipDialogNoTransparent onCancel()");
              BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, false);
              BankRemitBankcardInputUI.C(BankRemitBankcardInputUI.this);
              if ((BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).isShowing())) {
                BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).dismiss();
              }
              if ((BankRemitBankcardInputUI.D(BankRemitBankcardInputUI.this).getVisibility() == 8) || (BankRemitBankcardInputUI.E(BankRemitBankcardInputUI.this).getVisibility() == 4))
              {
                ae.i("MicroMsg.BankRemitBankcardInputUI", "usr cancel, & visibility not visiable, so finish");
                BankRemitBankcardInputUI.this.finish();
              }
              BankRemitBankcardInputUI.F(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67453);
            }
          }));
        }
      }
    });
    this.yiw.getInfoIv().setVisibility(0);
    this.yiw.getInfoIv().setClickable(true);
    this.yiw.getInfoIv().setEnabled(true);
    this.yiw.getInfoIv().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67445);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
        if ((BankRemitBankcardInputUI.T(BankRemitBankcardInputUI.this)) || (!BankRemitBankcardInputUI.U(BankRemitBankcardInputUI.this))) {
          BankRemitBankcardInputUI.V(BankRemitBankcardInputUI.this);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(14673, new Object[] { Integer.valueOf(3) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67445);
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
    dMg();
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
        this.yiQ = false;
        this.yiJ = paramIntent.getStringExtra("key_bank_card_seqno");
        str = this.yiJ;
        if (this.yiD == null) {
          break label241;
        }
        localIterator = this.yiD.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (TransferRecordParcel)localIterator.next();
        } while (!((TransferRecordParcel)localObject).yis.equals(str));
      }
      for (;;)
      {
        this.yiP = ((TransferRecordParcel)localObject);
        dMc();
        dMg();
        if (this.yiP != null) {
          at(this.yiP.yis, this.yiI, this.yiP.dlT);
        }
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67441);
            BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this).dHu();
            AppMethodBeat.o(67441);
          }
        }, 50L);
        ae.i("MicroMsg.BankRemitBankcardInputUI", "resultCode: %s", new Object[] { Integer.valueOf(paramInt2) });
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
          w(str, this.yiD);
          w(str, this.yiE);
        }
        label241:
        if (this.yiE != null)
        {
          localIterator = this.yiE.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject = (TransferRecordParcel)localIterator.next();
              if (((TransferRecordParcel)localObject).yis.equals(str)) {
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
          a((TransferRecordParcel)localObject, this.yiD);
          a((TransferRecordParcel)localObject, this.yiE);
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
        if ((this.yiO != null) && (this.yiO.yic != null))
        {
          paramIntent = this.yiO.yic.iterator();
          while (paramIntent.hasNext())
          {
            localObject = (EnterTimeParcel)paramIntent.next();
            if (((EnterTimeParcel)localObject).yif == paramInt1) {
              this.yiN = ((EnterTimeParcel)localObject);
            }
          }
        }
        for (;;)
        {
          dMe();
          dMg();
          AppMethodBeat.o(67462);
          return;
          ae.w("MicroMsg.BankRemitBankcardInputUI", "can't find the right enter scene: %d", new Object[] { Integer.valueOf(paramInt1) });
        }
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        this.yiO = ((BankcardElemParcel)paramIntent.getParcelableExtra("key_bank_card_elem_parcel"));
        dMd();
        dMh();
        dMe();
        dMf();
        dMg();
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
    paramBundle = new yo();
    paramBundle.dNR.scene = "12";
    paramBundle.callback = new BankRemitBankcardInputUI.1(this, paramBundle);
    com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
    addSceneEndListener(1348);
    addSceneEndListener(1542);
    addSceneEndListener(1378);
    addSceneEndListener(1349);
    addSceneEndListener(1280);
    this.yiM = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWp, ""));
    qr(false);
    dLZ();
    setMMTitle(2131756407);
    addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67435);
        ae.d("MicroMsg.BankRemitBankcardInputUI", "help click");
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new com.tencent.mm.ui.widget.a.e(BankRemitBankcardInputUI.this.getContext(), 1, false));
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(67433);
            paramAnonymous2l.add(0, 0, 0, BankRemitBankcardInputUI.this.getString(2131756381));
            paramAnonymous2l.add(0, 1, 0, BankRemitBankcardInputUI.this.getString(2131756379));
            AppMethodBeat.o(67433);
          }
        };
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(67434);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(67434);
              return;
              if (!bu.isNullOrNil(BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this))) {
                f.p(BankRemitBankcardInputUI.this.getContext(), BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this), false);
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.g.yxI.f(14673, new Object[] { Integer.valueOf(6) });
                AppMethodBeat.o(67434);
                return;
                ae.w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
              }
              f.p(BankRemitBankcardInputUI.this.getContext(), "https://kf.qq.com/touch/scene_product.html?scene_id=kf4568", true);
            }
          }
        };
        BankRemitBankcardInputUI.this.hideTenpayKB();
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).cPF();
        com.tencent.mm.plugin.report.service.g.yxI.f(14673, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(67435);
        return false;
      }
    });
    com.tencent.mm.plugin.report.service.g.yxI.f(14673, new Object[] { Integer.valueOf(1) });
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
    this.yiw.postDelayed(new Runnable()
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(67458);
    ae.i("MicroMsg.BankRemitBankcardInputUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof com.tencent.mm.plugin.remittance.bankcard.a.a))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.a.a)paramn;
      if (!paramString.yhI.equals(this.yiP.yis))
      {
        ae.i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", new Object[] { paramString.yhI, this.yiJ });
        AppMethodBeat.o(67458);
        return true;
      }
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67424);
          BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, paramString.yhH.FRb);
          BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new BankcardElemParcel(paramString.yhH.FRa));
          if (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) != null) {}
          for (paramAnonymousString = BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).uVs;; paramAnonymousString = "")
          {
            ae.i("MicroMsg.BankRemitBankcardInputUI", "response bank: %s", new Object[] { paramAnonymousString });
            BankRemitBankcardInputUI.H(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.I(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.J(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.K(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67424);
            return;
          }
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67423);
          ae.e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.yhH.dmy), paramString.yhH.phe });
          if (!bu.isNullOrNil(paramString.yhH.phe)) {
            h.a(BankRemitBankcardInputUI.this.getContext(), paramString.yhH.phe, null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
          }
          AppMethodBeat.o(67423);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67455);
          ae.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
          AppMethodBeat.o(67455);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(67458);
      return false;
      if ((paramn instanceof com.tencent.mm.plugin.remittance.bankcard.a.g))
      {
        paramString = (com.tencent.mm.plugin.remittance.bankcard.a.g)paramn;
        if (paramString == this.yiU)
        {
          ae.i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
          this.yiU = null;
        }
        if (!paramString.md5.equals(this.yix.getMD5Value()))
        {
          ae.i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", new Object[] { paramString.md5, this.yix.getMD5Value() });
          AppMethodBeat.o(67458);
          return true;
        }
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67427);
            if (paramString.yhN.FRa == null)
            {
              ae.w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
              BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67427);
              return;
            }
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new BankcardElemParcel(paramString.yhN.FRa));
            BankRemitBankcardInputUI.H(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.I(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.J(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.K(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67427);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67426);
            ae.e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.yhN.dmy), paramString.yhN.phe });
            BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67426);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67425);
            ae.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
            AppMethodBeat.o(67425);
          }
        });
      }
      else if ((paramn instanceof m))
      {
        paramString = (m)paramn;
        this.yiW = true;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67430);
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, false);
            BankRemitBankcardInputUI.d(BankRemitBankcardInputUI.this, paramString.yhT.FQZ);
            ae.d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", new Object[] { BankRemitBankcardInputUI.L(BankRemitBankcardInputUI.this) });
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, TransferRecordParcel.ft(paramString.yhT.HBZ));
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, TransferRecordParcel.ft(paramString.yhT.HBY));
            ae.i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.M(BankRemitBankcardInputUI.this).size()), Integer.valueOf(BankRemitBankcardInputUI.N(BankRemitBankcardInputUI.this).size()) });
            BankRemitBankcardInputUI.O(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67430);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67429);
            ae.e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", new Object[] { Integer.valueOf(paramString.yhT.dmy), paramString.yhT.phe });
            if (!bu.isNullOrNil(paramString.yhT.phe)) {
              h.a(BankRemitBankcardInputUI.this.getContext(), paramString.yhT.phe, null, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, true);
            AppMethodBeat.o(67429);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67428);
            ae.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, true);
            AppMethodBeat.o(67428);
          }
        });
      }
      else if ((paramn instanceof d))
      {
        paramString = (d)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67436);
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, paramString.yhK.FRb);
            BankRemitBankcardInputUI.e(BankRemitBankcardInputUI.this, paramString.yhK.yiu);
            BankRemitBankcardInputUI.f(BankRemitBankcardInputUI.this, paramString.yhK.yis);
            BankRemitBankcardInputUI.g(BankRemitBankcardInputUI.this, paramString.yhK.yit);
            BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67436);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67432);
            ae.e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", new Object[] { Integer.valueOf(paramString.yhK.dmy), paramString.yhK.phe });
            if (!bu.isNullOrNil(paramString.yhK.phe)) {
              h.a(BankRemitBankcardInputUI.this.getContext(), paramString.yhK.phe, null, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
            AppMethodBeat.o(67432);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67431);
            ae.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
            AppMethodBeat.o(67431);
          }
        });
      }
      else if ((paramn instanceof k))
      {
        paramString = (k)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67439);
            if ((BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).isShowing())) {
              BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).dismiss();
            }
            BankRemitBankcardInputUI.P(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.C(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.h(BankRemitBankcardInputUI.this, paramString.yhR.HsY);
            BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this, paramString.yhR.HsZ);
            ae.i("MicroMsg.BankRemitBankcardInputUI", "set uniqueId:%s", new Object[] { BankRemitBankcardInputUI.Q(BankRemitBankcardInputUI.this) });
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, paramString.yhR.Hta);
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, paramString.yhR.Htb);
            ae.d("MicroMsg.BankRemitBankcardInputUI", "set nameLenLimit:%s", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.o(BankRemitBankcardInputUI.this)) });
            if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this))
            {
              if (BankRemitBankcardInputUI.y(BankRemitBankcardInputUI.this))
              {
                if (BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this))
                {
                  ae.i("MicroMsg.BankRemitBankcardInputUI", "NetSceneBankRemitOperation: from record goto next direct");
                  BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
                }
                for (;;)
                {
                  BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, false);
                  AppMethodBeat.o(67439);
                  return;
                  BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).uVs, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).dlT);
                }
              }
            }
            else {
              BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
            }
            AppMethodBeat.o(67439);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67438);
            ae.e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", new Object[] { Integer.valueOf(paramString.yhR.dmy), paramString.yhR.phe });
            if (!bu.isNullOrNil(paramString.yhR.phe)) {
              h.a(BankRemitBankcardInputUI.this.getContext(), paramString.yhR.phe, null, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
            BankRemitBankcardInputUI.this.finish();
            AppMethodBeat.o(67438);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67437);
            ae.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI
 * JD-Core Version:    0.7.0.1
 */