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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.bankcard.a.d;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.biy;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.gz;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.x;
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
  private WalletFormView CjA;
  private ListPopupWindow CjB;
  private c CjC;
  private Filter.FilterListener CjD;
  private ArrayList<TransferRecordParcel> CjE;
  private ArrayList<TransferRecordParcel> CjF;
  private int CjG;
  private int CjH;
  private String CjI;
  private String CjJ;
  private String CjK;
  private String CjL;
  private String CjM;
  private String CjN;
  private EnterTimeParcel CjO;
  private BankcardElemParcel CjP;
  private TransferRecordParcel CjQ;
  private boolean CjR = true;
  private boolean CjS = false;
  private boolean CjT = false;
  private boolean CjU = false;
  private com.tencent.mm.plugin.remittance.bankcard.a.g CjV = null;
  private boolean CjW = false;
  private boolean CjX = false;
  private boolean CjY = true;
  private boolean CjZ = false;
  private CdnImageView Cjq;
  private WalletFormView Cjx;
  private WalletFormView Cjy;
  private WalletFormView Cjz;
  private boolean Cka = false;
  private boolean Ckb = false;
  private String Ckc;
  private String Ckd;
  private String content;
  private String dUb = "";
  private Button krs;
  private com.tencent.mm.ui.widget.a.e tiF;
  private Dialog zhz = null;
  
  private static void A(String paramString, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67464);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.Cjt.equals(paramString))
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
  
  private static void a(TransferRecordParcel paramTransferRecordParcel, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67463);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.Cjt.equals(paramTransferRecordParcel.Cjt))
        {
          localTransferRecordParcel.Cjw = paramTransferRecordParcel.Cjw;
          AppMethodBeat.o(67463);
          return;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(67463);
  }
  
  private void aE(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67465);
    Log.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", new Object[] { paramString1 });
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.a(paramString1, paramString2, paramString3), false);
    AppMethodBeat.o(67465);
  }
  
  private void eNa()
  {
    AppMethodBeat.i(67468);
    Log.i("MicroMsg.BankRemitBankcardInputUI", "do operation");
    this.Cka = true;
    doSceneProgress(new k(), false);
    AppMethodBeat.o(67468);
  }
  
  private void eNb()
  {
    AppMethodBeat.i(67469);
    this.Cjy.eIi();
    this.Cjy.setContentEnabled(false);
    this.CjT = true;
    AppMethodBeat.o(67469);
  }
  
  private void eNc()
  {
    AppMethodBeat.i(67470);
    this.Cjz.setClickable(false);
    this.CjU = true;
    AppMethodBeat.o(67470);
  }
  
  private void eNd()
  {
    AppMethodBeat.i(67471);
    if (this.CjQ != null)
    {
      this.Cjx.setText(this.CjQ.Cjv);
      this.CjS = true;
      this.Cjy.setText(getString(2131756493, new Object[] { this.CjQ.Cju }));
      this.Cjz.setText(this.CjQ.ynT);
      this.Cjq.setUrl(this.CjQ.CiX);
      eNb();
      eNc();
    }
    AppMethodBeat.o(67471);
  }
  
  private void eNe()
  {
    AppMethodBeat.i(67472);
    if (this.CjP != null)
    {
      this.Cjz.setText(this.CjP.ynT);
      this.Cjq.setUrl(this.CjP.CiX);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Cjq.getLayoutParams();
      localLayoutParams.setMargins(com.tencent.mm.cb.a.fromDPToPix(getContext(), 15), 0, 0, 0);
      this.Cjq.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(67472);
  }
  
  private void eNf()
  {
    AppMethodBeat.i(67473);
    if (this.CjO != null)
    {
      if (!Util.isNullOrNil(this.CjO.ixw)) {
        this.CjA.setContentTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CjO.ixw, true));
      }
      for (;;)
      {
        this.CjA.setText(this.CjO.Cjh);
        this.CjA.setVisibility(0);
        AppMethodBeat.o(67473);
        return;
        this.CjA.setContentTextColorRes(2131100904);
      }
    }
    if ((this.CjP != null) && (!Util.isNullOrNil(this.CjP.Cja)))
    {
      this.CjA.setText(this.CjP.Cja);
      if (!Util.isNullOrNil(this.CjP.Cjb)) {
        this.CjA.setContentTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CjP.Cjb, true));
      }
      for (;;)
      {
        this.CjA.setVisibility(0);
        AppMethodBeat.o(67473);
        return;
        this.CjA.setContentTextColorRes(2131100904);
      }
    }
    this.CjA.setVisibility(8);
    AppMethodBeat.o(67473);
  }
  
  private void eNg()
  {
    AppMethodBeat.i(67474);
    if (this.CjA.getVisibility() == 0)
    {
      this.Cjz.setBackground(getResources().getDrawable(2131235612));
      AppMethodBeat.o(67474);
      return;
    }
    this.Cjz.setBackground(getResources().getDrawable(2131231159));
    AppMethodBeat.o(67474);
  }
  
  private void eNh()
  {
    AppMethodBeat.i(67475);
    if ((!Util.isNullOrNil(this.Cjx.getText())) && (!this.Cjx.getText().trim().isEmpty()) && (!Util.isNullOrNil(this.Cjy.getText())) && (this.Cjx.bql()) && (!this.Cjy.getText().trim().isEmpty()) && (this.Cjy.bql()) && (!Util.isNullOrNil(this.Cjz.getText())) && (this.CjA.getVisibility() == 0) && (!Util.isNullOrNil(this.CjA.getText())) && (this.CjP != null) && (Util.isNullOrNil(this.CjP.Cjc)))
    {
      this.krs.setEnabled(true);
      AppMethodBeat.o(67475);
      return;
    }
    this.krs.setEnabled(false);
    AppMethodBeat.o(67475);
  }
  
  private void eNi()
  {
    AppMethodBeat.i(67476);
    if ((this.CjP != null) && (!Util.isNullOrNil(this.CjP.Cja)))
    {
      this.CjO = null;
      AppMethodBeat.o(67476);
      return;
    }
    if ((this.CjP != null) && (this.CjP.Cjd != null))
    {
      Iterator localIterator = this.CjP.Cjd.iterator();
      while (localIterator.hasNext())
      {
        EnterTimeParcel localEnterTimeParcel = (EnterTimeParcel)localIterator.next();
        if (localEnterTimeParcel.Cjj > 0)
        {
          this.CjO = localEnterTimeParcel;
          AppMethodBeat.o(67476);
          return;
        }
      }
    }
    AppMethodBeat.o(67476);
  }
  
  private void tI(boolean paramBoolean)
  {
    AppMethodBeat.i(67466);
    Log.i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.m(), true);
      AppMethodBeat.o(67466);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.m(), false);
    AppMethodBeat.o(67466);
  }
  
  private void z(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67467);
    Log.i("MicroMsg.BankRemitBankcardInputUI", "do check bank bind: %s %s", new Object[] { paramString3, paramString4 });
    Log.d("MicroMsg.BankRemitBankcardInputUI", "payeeName: %s, bankCardNo: %s", new Object[] { paramString1, paramString2 });
    doSceneProgress(new d(paramString1, paramString2, paramString3, paramString4));
    AppMethodBeat.o(67467);
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
    return 2131493196;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67457);
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.Cjx = ((WalletFormView)findViewById(2131297741));
    this.Cjx.getInfoIv().setLayoutParams(localLayoutParams);
    this.Cjx.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.Cjx.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099749));
    this.Cjy = ((WalletFormView)findViewById(2131297740));
    this.Cjy.getInfoIv().setLayoutParams(localLayoutParams);
    this.Cjy.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.Cjy.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099749));
    this.Cjz = ((WalletFormView)findViewById(2131297739));
    this.Cjq = ((CdnImageView)this.Cjz.findViewById(2131310209));
    this.CjA = ((WalletFormView)findViewById(2131297738));
    this.krs = ((Button)findViewById(2131297742));
    this.Cjx.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    this.Cjx.a(new TextWatcher()
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
    this.Cjx.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.Cjx.hic();
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Cjy);
    setEditFocusListener(this.Cjy, 2, false, false, true);
    this.Cjy.a(new TextWatcher()
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
            BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67449);
          }
        }, 200L);
        AppMethodBeat.o(67450);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (!Util.isNullOrNil(this.content)) {
      this.Cjy.setText(this.content);
    }
    this.Cjz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67451);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        BankRemitBankcardInputUI.this.hideVKB();
        paramAnonymousView = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getText();
        if ((BankRemitBankcardInputUI.s(BankRemitBankcardInputUI.this)) && (!Util.isNullOrNil(paramAnonymousView)))
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
    this.CjA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67452);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
        BankRemitBankcardInputUI.this.hideVKB();
        BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).eIi();
        if (!BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this))
        {
          paramAnonymousView = new Intent(BankRemitBankcardInputUI.this.getContext(), BankRemitSelectArriveTimeUI.class);
          if ((BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).Cjd != null)) {
            paramAnonymousView.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).Cjd);
          }
          if (BankRemitBankcardInputUI.w(BankRemitBankcardInputUI.this) != null) {
            paramAnonymousView.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.w(BankRemitBankcardInputUI.this).Cjg);
          }
          BankRemitBankcardInputUI.this.startActivityForResult(paramAnonymousView, 3);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67452);
      }
    });
    this.krs.setOnClickListener(new x()
    {
      public final void czW()
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
        Object localObject1 = BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this).getText();
        Object localObject2 = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getText();
        if ((Util.isNullOrNil((String)localObject1)) || (((String)localObject1).trim().isEmpty()) || (Util.isNullOrNil((String)localObject2)) || (((String)localObject2).trim().isEmpty()) || (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) == null))
        {
          Log.w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", new Object[] { localObject1, localObject2, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) });
          AppMethodBeat.o(67454);
          return;
        }
        Log.i("MicroMsg.BankRemitBankcardInputUI", "onRealClick() ifGetOperation:%s waitingGetOperation:%s ifAutoNext:%s", new Object[] { Boolean.valueOf(BankRemitBankcardInputUI.m(BankRemitBankcardInputUI.this)), Boolean.valueOf(BankRemitBankcardInputUI.x(BankRemitBankcardInputUI.this)), Boolean.valueOf(BankRemitBankcardInputUI.y(BankRemitBankcardInputUI.this)) });
        if (BankRemitBankcardInputUI.m(BankRemitBankcardInputUI.this))
        {
          if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this))
          {
            if (BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this))
            {
              Log.i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
              BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67454);
              return;
            }
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, (String)localObject1, (String)localObject2, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).ynT, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).dDj);
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
          BankRemitBankcardInputUI.this.getString(2131755797);
          BankRemitBankcardInputUI.a((BankRemitBankcardInputUI)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, BankRemitBankcardInputUI.this.getString(2131768146), true, new DialogInterface.OnCancelListener()
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
    this.Cjx.getInfoIv().setVisibility(0);
    this.Cjx.getInfoIv().setClickable(true);
    this.Cjx.getInfoIv().setEnabled(true);
    this.Cjx.getInfoIv().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67445);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
        if ((BankRemitBankcardInputUI.T(BankRemitBankcardInputUI.this)) || (!BankRemitBankcardInputUI.U(BankRemitBankcardInputUI.this))) {
          BankRemitBankcardInputUI.V(BankRemitBankcardInputUI.this);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(14673, new Object[] { Integer.valueOf(3) });
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
    eNh();
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
        this.CjR = false;
        this.CjK = paramIntent.getStringExtra("key_bank_card_seqno");
        str = this.CjK;
        if (this.CjE == null) {
          break label241;
        }
        localIterator = this.CjE.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (TransferRecordParcel)localIterator.next();
        } while (!((TransferRecordParcel)localObject).Cjt.equals(str));
      }
      for (;;)
      {
        this.CjQ = ((TransferRecordParcel)localObject);
        eNd();
        eNh();
        if (this.CjQ != null) {
          aE(this.CjQ.Cjt, this.CjJ, this.CjQ.dDj);
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67441);
            BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this).eIi();
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
          A(str, this.CjE);
          A(str, this.CjF);
        }
        label241:
        if (this.CjF != null)
        {
          localIterator = this.CjF.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject = (TransferRecordParcel)localIterator.next();
              if (((TransferRecordParcel)localObject).Cjt.equals(str)) {
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
          a((TransferRecordParcel)localObject, this.CjE);
          a((TransferRecordParcel)localObject, this.CjF);
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
        if ((this.CjP != null) && (this.CjP.Cjd != null))
        {
          paramIntent = this.CjP.Cjd.iterator();
          while (paramIntent.hasNext())
          {
            localObject = (EnterTimeParcel)paramIntent.next();
            if (((EnterTimeParcel)localObject).Cjg == paramInt1) {
              this.CjO = ((EnterTimeParcel)localObject);
            }
          }
        }
        for (;;)
        {
          eNf();
          eNh();
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
        this.CjP = ((BankcardElemParcel)paramIntent.getParcelableExtra("key_bank_card_elem_parcel"));
        eNe();
        eNi();
        eNf();
        eNg();
        eNh();
        AppMethodBeat.o(67462);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    label534:
    AppMethodBeat.o(67462);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(67456);
    super.onCreate(paramBundle);
    hideActionbarLine();
    this.content = getIntent().getStringExtra("key_content");
    initView();
    paramBundle = new zt();
    paramBundle.efM.scene = "12";
    paramBundle.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67422);
        if (!Util.isNullOrNil(paramBundle.efN.efO)) {
          f.a((TextView)BankRemitBankcardInputUI.this.findViewById(2131297330), paramBundle.efN.efO, paramBundle.efN.content, paramBundle.efN.url);
        }
        AppMethodBeat.o(67422);
      }
    };
    EventCenter.instance.publish(paramBundle);
    addSceneEndListener(1348);
    addSceneEndListener(1542);
    addSceneEndListener(1378);
    addSceneEndListener(1349);
    addSceneEndListener(1280);
    this.CjN = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OeH, ""));
    tI(false);
    eNa();
    setMMTitle(2131756542);
    addIconOptionMenu(0, 2131689495, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67435);
        Log.d("MicroMsg.BankRemitBankcardInputUI", "help click");
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new com.tencent.mm.ui.widget.a.e(BankRemitBankcardInputUI.this.getContext(), 1, false));
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).HLX = new o.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
          {
            AppMethodBeat.i(67433);
            paramAnonymous2m.add(0, 0, 0, BankRemitBankcardInputUI.this.getString(2131756516));
            paramAnonymous2m.add(0, 1, 0, BankRemitBankcardInputUI.this.getString(2131756514));
            AppMethodBeat.o(67433);
          }
        };
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).HLY = new o.g()
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
              if (!Util.isNullOrNil(BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this))) {
                f.p(BankRemitBankcardInputUI.this.getContext(), BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this), false);
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(14673, new Object[] { Integer.valueOf(6) });
                AppMethodBeat.o(67434);
                return;
                Log.w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
              }
              f.p(BankRemitBankcardInputUI.this.getContext(), "https://" + WeChatHosts.domainString(2131761715) + "/touch/scene_product.html?scene_id=kf4568", true);
            }
          }
        };
        BankRemitBankcardInputUI.this.hideTenpayKB();
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).dGm();
        com.tencent.mm.plugin.report.service.h.CyF.a(14673, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(67435);
        return false;
      }
    });
    com.tencent.mm.plugin.report.service.h.CyF.a(14673, new Object[] { Integer.valueOf(1) });
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
    this.Cjx.postDelayed(new Runnable()
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(67458);
    Log.i("MicroMsg.BankRemitBankcardInputUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramq instanceof com.tencent.mm.plugin.remittance.bankcard.a.a))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.a.a)paramq;
      if (!paramString.CiJ.equals(this.CjQ.Cjt))
      {
        Log.i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", new Object[] { paramString.CiJ, this.CjK });
        AppMethodBeat.o(67458);
        return true;
      }
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67424);
          BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, paramString.CiI.KKI);
          BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new BankcardElemParcel(paramString.CiI.KKH));
          if (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) != null) {}
          for (paramAnonymousString = BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).ynT;; paramAnonymousString = "")
          {
            Log.i("MicroMsg.BankRemitBankcardInputUI", "response bank: %s", new Object[] { paramAnonymousString });
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
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67423);
          Log.e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.CiI.dDN), paramString.CiI.qwn });
          if (!Util.isNullOrNil(paramString.CiI.qwn)) {
            com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.CiI.qwn, null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
          }
          AppMethodBeat.o(67423);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67455);
          Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousq });
          AppMethodBeat.o(67455);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(67458);
      return false;
      if ((paramq instanceof com.tencent.mm.plugin.remittance.bankcard.a.g))
      {
        paramString = (com.tencent.mm.plugin.remittance.bankcard.a.g)paramq;
        if (paramString == this.CjV)
        {
          Log.i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
          this.CjV = null;
        }
        if (!paramString.md5.equals(this.Cjy.getMD5Value()))
        {
          Log.i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", new Object[] { paramString.md5, this.Cjy.getMD5Value() });
          AppMethodBeat.o(67458);
          return true;
        }
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67427);
            if (paramString.CiO.KKH == null)
            {
              Log.w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
              BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67427);
              return;
            }
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new BankcardElemParcel(paramString.CiO.KKH));
            BankRemitBankcardInputUI.H(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.I(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.J(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.K(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67427);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67426);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.CiO.dDN), paramString.CiO.qwn });
            BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67426);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67425);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousq });
            AppMethodBeat.o(67425);
          }
        });
      }
      else if ((paramq instanceof com.tencent.mm.plugin.remittance.bankcard.a.m))
      {
        paramString = (com.tencent.mm.plugin.remittance.bankcard.a.m)paramq;
        this.CjX = true;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67430);
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, false);
            BankRemitBankcardInputUI.d(BankRemitBankcardInputUI.this, paramString.CiU.KKG);
            Log.d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", new Object[] { BankRemitBankcardInputUI.L(BankRemitBankcardInputUI.this) });
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, TransferRecordParcel.go(paramString.CiU.MMN));
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, TransferRecordParcel.go(paramString.CiU.MMM));
            Log.i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.M(BankRemitBankcardInputUI.this).size()), Integer.valueOf(BankRemitBankcardInputUI.N(BankRemitBankcardInputUI.this).size()) });
            BankRemitBankcardInputUI.O(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67430);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67429);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", new Object[] { Integer.valueOf(paramString.CiU.dDN), paramString.CiU.qwn });
            if (!Util.isNullOrNil(paramString.CiU.qwn)) {
              com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.CiU.qwn, null, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, true);
            AppMethodBeat.o(67429);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67428);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousq });
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, true);
            AppMethodBeat.o(67428);
          }
        });
      }
      else if ((paramq instanceof d))
      {
        paramString = (d)paramq;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67436);
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, paramString.CiL.KKI);
            BankRemitBankcardInputUI.e(BankRemitBankcardInputUI.this, paramString.CiL.Cjv);
            BankRemitBankcardInputUI.f(BankRemitBankcardInputUI.this, paramString.CiL.Cjt);
            BankRemitBankcardInputUI.g(BankRemitBankcardInputUI.this, paramString.CiL.Cju);
            BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67436);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67432);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", new Object[] { Integer.valueOf(paramString.CiL.dDN), paramString.CiL.qwn });
            if (!Util.isNullOrNil(paramString.CiL.qwn)) {
              com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.CiL.qwn, null, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
            AppMethodBeat.o(67432);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67431);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousq });
            AppMethodBeat.o(67431);
          }
        });
      }
      else if ((paramq instanceof k))
      {
        paramString = (k)paramq;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67439);
            if ((BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).isShowing())) {
              BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).dismiss();
            }
            BankRemitBankcardInputUI.P(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.C(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.h(BankRemitBankcardInputUI.this, paramString.CiS.MBU);
            BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this, paramString.CiS.MBV);
            Log.i("MicroMsg.BankRemitBankcardInputUI", "set uniqueId:%s", new Object[] { BankRemitBankcardInputUI.Q(BankRemitBankcardInputUI.this) });
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, paramString.CiS.MBW);
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, paramString.CiS.MBX);
            Log.d("MicroMsg.BankRemitBankcardInputUI", "set nameLenLimit:%s", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.o(BankRemitBankcardInputUI.this)) });
            if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this))
            {
              if (BankRemitBankcardInputUI.y(BankRemitBankcardInputUI.this))
              {
                if (BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this))
                {
                  Log.i("MicroMsg.BankRemitBankcardInputUI", "NetSceneBankRemitOperation: from record goto next direct");
                  BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
                }
                for (;;)
                {
                  BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, false);
                  AppMethodBeat.o(67439);
                  return;
                  BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).ynT, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).dDj);
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
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67438);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", new Object[] { Integer.valueOf(paramString.CiS.dDN), paramString.CiS.qwn });
            if (!Util.isNullOrNil(paramString.CiS.qwn)) {
              com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.CiS.qwn, null, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
            }
            BankRemitBankcardInputUI.this.finish();
            AppMethodBeat.o(67438);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67437);
            Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousq });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI
 * JD-Core Version:    0.7.0.1
 */