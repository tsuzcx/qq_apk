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
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.g.a.xo.b;
import com.tencent.mm.plugin.remittance.bankcard.a.d;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.plugin.remittance.bankcard.a.m;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankRemitBankcardInputUI
  extends BankRemitBaseUI
{
  private String content;
  private String dpt = "";
  private Button iXb;
  private com.tencent.mm.ui.widget.a.e qQK;
  private Dialog uxF = null;
  private CdnImageView wEP;
  private WalletFormView wEW;
  private WalletFormView wEX;
  private WalletFormView wEY;
  private WalletFormView wEZ;
  private boolean wFA = false;
  private String wFB;
  private String wFC;
  private ListPopupWindow wFa;
  private c wFb;
  private Filter.FilterListener wFc;
  private ArrayList<TransferRecordParcel> wFd;
  private ArrayList<TransferRecordParcel> wFe;
  private int wFf;
  private int wFg;
  private String wFh;
  private String wFi;
  private String wFj;
  private String wFk;
  private String wFl;
  private String wFm;
  private EnterTimeParcel wFn;
  private BankcardElemParcel wFo;
  private TransferRecordParcel wFp;
  private boolean wFq = true;
  private boolean wFr = false;
  private boolean wFs = false;
  private boolean wFt = false;
  private com.tencent.mm.plugin.remittance.bankcard.a.g wFu = null;
  private boolean wFv = false;
  private boolean wFw = false;
  private boolean wFx = true;
  private boolean wFy = false;
  private boolean wFz = false;
  
  private static void a(TransferRecordParcel paramTransferRecordParcel, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67463);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.wES.equals(paramTransferRecordParcel.wES))
        {
          localTransferRecordParcel.wEV = paramTransferRecordParcel.wEV;
          AppMethodBeat.o(67463);
          return;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(67463);
  }
  
  private void al(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67465);
    ac.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", new Object[] { paramString1 });
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.a(paramString1, paramString2, paramString3), false);
    AppMethodBeat.o(67465);
  }
  
  private void dxq()
  {
    AppMethodBeat.i(67468);
    ac.i("MicroMsg.BankRemitBankcardInputUI", "do operation");
    this.wFz = true;
    doSceneProgress(new k(), false);
    AppMethodBeat.o(67468);
  }
  
  private void dxr()
  {
    AppMethodBeat.i(67469);
    this.wEX.dtG();
    this.wEX.setContentEnabled(false);
    this.wFs = true;
    AppMethodBeat.o(67469);
  }
  
  private void dxs()
  {
    AppMethodBeat.i(67470);
    this.wEY.setClickable(false);
    this.wFt = true;
    AppMethodBeat.o(67470);
  }
  
  private void dxt()
  {
    AppMethodBeat.i(67471);
    if (this.wFp != null)
    {
      this.wEW.setText(this.wFp.wEU);
      this.wFr = true;
      this.wEX.setText(getString(2131756358, new Object[] { this.wFp.wET }));
      this.wEY.setText(this.wFp.tGS);
      this.wEP.setUrl(this.wFp.wEw);
      dxr();
      dxs();
    }
    AppMethodBeat.o(67471);
  }
  
  private void dxu()
  {
    AppMethodBeat.i(67472);
    if (this.wFo != null)
    {
      this.wEY.setText(this.wFo.tGS);
      this.wEP.setUrl(this.wFo.wEw);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.wEP.getLayoutParams();
      localLayoutParams.setMargins(com.tencent.mm.cc.a.fromDPToPix(getContext(), 15), 0, 0, 0);
      this.wEP.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(67472);
  }
  
  private void dxv()
  {
    AppMethodBeat.i(67473);
    if (this.wFn != null)
    {
      if (!bs.isNullOrNil(this.wFn.hiu)) {
        this.wEZ.setContentTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(this.wFn.hiu, true));
      }
      for (;;)
      {
        this.wEZ.setText(this.wFn.wEG);
        this.wEZ.setVisibility(0);
        AppMethodBeat.o(67473);
        return;
        this.wEZ.setContentTextColorRes(2131100711);
      }
    }
    if ((this.wFo != null) && (!bs.isNullOrNil(this.wFo.wEz)))
    {
      this.wEZ.setText(this.wFo.wEz);
      if (!bs.isNullOrNil(this.wFo.wEA)) {
        this.wEZ.setContentTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(this.wFo.wEA, true));
      }
      for (;;)
      {
        this.wEZ.setVisibility(0);
        AppMethodBeat.o(67473);
        return;
        this.wEZ.setContentTextColorRes(2131100711);
      }
    }
    this.wEZ.setVisibility(8);
    AppMethodBeat.o(67473);
  }
  
  private void dxw()
  {
    AppMethodBeat.i(67474);
    if (this.wEZ.getVisibility() == 0)
    {
      this.wEY.setBackground(getResources().getDrawable(2131234650));
      AppMethodBeat.o(67474);
      return;
    }
    this.wEY.setBackground(getResources().getDrawable(2131231123));
    AppMethodBeat.o(67474);
  }
  
  private void dxx()
  {
    AppMethodBeat.i(67475);
    if ((!bs.isNullOrNil(this.wEW.getText())) && (!this.wEW.getText().trim().isEmpty()) && (!bs.isNullOrNil(this.wEX.getText())) && (this.wEW.aRO()) && (!this.wEX.getText().trim().isEmpty()) && (this.wEX.aRO()) && (!bs.isNullOrNil(this.wEY.getText())) && (this.wEZ.getVisibility() == 0) && (!bs.isNullOrNil(this.wEZ.getText())) && (this.wFo != null) && (bs.isNullOrNil(this.wFo.wEB)))
    {
      this.iXb.setEnabled(true);
      AppMethodBeat.o(67475);
      return;
    }
    this.iXb.setEnabled(false);
    AppMethodBeat.o(67475);
  }
  
  private void dxy()
  {
    AppMethodBeat.i(67476);
    if ((this.wFo != null) && (!bs.isNullOrNil(this.wFo.wEz)))
    {
      this.wFn = null;
      AppMethodBeat.o(67476);
      return;
    }
    if ((this.wFo != null) && (this.wFo.wEC != null))
    {
      Iterator localIterator = this.wFo.wEC.iterator();
      while (localIterator.hasNext())
      {
        EnterTimeParcel localEnterTimeParcel = (EnterTimeParcel)localIterator.next();
        if (localEnterTimeParcel.wEI > 0)
        {
          this.wFn = localEnterTimeParcel;
          AppMethodBeat.o(67476);
          return;
        }
      }
    }
    AppMethodBeat.o(67476);
  }
  
  private void pL(boolean paramBoolean)
  {
    AppMethodBeat.i(67466);
    ac.i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      doSceneProgress(new m(), true);
      AppMethodBeat.o(67466);
      return;
    }
    doSceneProgress(new m(), false);
    AppMethodBeat.o(67466);
  }
  
  private static void t(String paramString, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67464);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.wES.equals(paramString))
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
  
  private void u(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67467);
    ac.i("MicroMsg.BankRemitBankcardInputUI", "do check bank bind: %s %s", new Object[] { paramString3, paramString4 });
    ac.d("MicroMsg.BankRemitBankcardInputUI", "payeeName: %s, bankCardNo: %s", new Object[] { paramString1, paramString2 });
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
      ac.e("MicroMsg.BankRemitBankcardInputUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
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
    int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 16);
    int j = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.wEW = ((WalletFormView)findViewById(2131297515));
    this.wEW.getInfoIv().setLayoutParams(localLayoutParams);
    this.wEW.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.wEW.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.wEX = ((WalletFormView)findViewById(2131297514));
    this.wEX.getInfoIv().setLayoutParams(localLayoutParams);
    this.wEX.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.wEX.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.wEY = ((WalletFormView)findViewById(2131297513));
    this.wEP = ((CdnImageView)this.wEY.findViewById(2131306748));
    this.wEZ = ((WalletFormView)findViewById(2131297512));
    this.iXb = ((Button)findViewById(2131297516));
    this.wEW.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    this.wEW.a(new TextWatcher()
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
    this.wEW.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(67448);
        if (paramAnonymousInt == 5)
        {
          BankRemitBankcardInputUI.this.hideVKB();
          if (!BankRemitBankcardInputUI.p(BankRemitBankcardInputUI.this)) {
            ap.n(new Runnable()
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
    this.wEW.fAY();
    com.tencent.mm.wallet_core.ui.formview.a.b(this.wEX);
    setEditFocusListener(this.wEX, 2, false, false, true);
    this.wEX.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(67450);
        BankRemitBankcardInputUI.q(BankRemitBankcardInputUI.this);
        ap.n(new Runnable()
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
    if (!bs.isNullOrNil(this.content)) {
      this.wEX.setText(this.content);
    }
    this.wEY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67451);
        BankRemitBankcardInputUI.this.hideVKB();
        paramAnonymousView = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getText();
        if ((BankRemitBankcardInputUI.s(BankRemitBankcardInputUI.this)) && (!bs.isNullOrNil(paramAnonymousView)))
        {
          String str = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getMD5Value();
          BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, paramAnonymousView, str);
          AppMethodBeat.o(67451);
          return;
        }
        BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
        AppMethodBeat.o(67451);
      }
    });
    this.wEZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67452);
        ac.i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
        BankRemitBankcardInputUI.this.hideVKB();
        BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).dtG();
        if (!BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this))
        {
          paramAnonymousView = new Intent(BankRemitBankcardInputUI.this.getContext(), BankRemitSelectArriveTimeUI.class);
          if ((BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).wEC != null)) {
            paramAnonymousView.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).wEC);
          }
          if (BankRemitBankcardInputUI.w(BankRemitBankcardInputUI.this) != null) {
            paramAnonymousView.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.w(BankRemitBankcardInputUI.this).wEF);
          }
          BankRemitBankcardInputUI.this.startActivityForResult(paramAnonymousView, 3);
        }
        AppMethodBeat.o(67452);
      }
    });
    this.iXb.setOnClickListener(new w()
    {
      public final void bWk()
      {
        AppMethodBeat.i(67454);
        ac.i("MicroMsg.BankRemitBankcardInputUI", "click next btn");
        BankRemitBankcardInputUI.this.hideVKB();
        BankRemitBankcardInputUI.this.hideTenpayKB();
        if (BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this))
        {
          AppMethodBeat.o(67454);
          return;
        }
        Object localObject1 = BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this).getText();
        Object localObject2 = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getText();
        if ((bs.isNullOrNil((String)localObject1)) || (((String)localObject1).trim().isEmpty()) || (bs.isNullOrNil((String)localObject2)) || (((String)localObject2).trim().isEmpty()) || (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) == null))
        {
          ac.w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", new Object[] { localObject1, localObject2, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) });
          AppMethodBeat.o(67454);
          return;
        }
        ac.i("MicroMsg.BankRemitBankcardInputUI", "onRealClick() ifGetOperation:%s waitingGetOperation:%s ifAutoNext:%s", new Object[] { Boolean.valueOf(BankRemitBankcardInputUI.m(BankRemitBankcardInputUI.this)), Boolean.valueOf(BankRemitBankcardInputUI.x(BankRemitBankcardInputUI.this)), Boolean.valueOf(BankRemitBankcardInputUI.y(BankRemitBankcardInputUI.this)) });
        if (BankRemitBankcardInputUI.m(BankRemitBankcardInputUI.this))
        {
          if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this))
          {
            if (BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this))
            {
              ac.i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
              BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67454);
              return;
            }
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, (String)localObject1, (String)localObject2, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).tGS, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).cZz);
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
          BankRemitBankcardInputUI.a((BankRemitBankcardInputUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, BankRemitBankcardInputUI.this.getString(2131765693), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(67453);
              ac.i("MicroMsg.BankRemitBankcardInputUI", "coperationTipDialogNoTransparent onCancel()");
              BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, false);
              BankRemitBankcardInputUI.C(BankRemitBankcardInputUI.this);
              if ((BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).isShowing())) {
                BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).dismiss();
              }
              if ((BankRemitBankcardInputUI.D(BankRemitBankcardInputUI.this).getVisibility() == 8) || (BankRemitBankcardInputUI.E(BankRemitBankcardInputUI.this).getVisibility() == 4))
              {
                ac.i("MicroMsg.BankRemitBankcardInputUI", "usr cancel, & visibility not visiable, so finish");
                BankRemitBankcardInputUI.this.finish();
              }
              BankRemitBankcardInputUI.F(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67453);
            }
          }));
        }
      }
    });
    this.wEW.getInfoIv().setVisibility(0);
    this.wEW.getInfoIv().setClickable(true);
    this.wEW.getInfoIv().setEnabled(true);
    this.wEW.getInfoIv().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67445);
        ac.d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
        if ((BankRemitBankcardInputUI.T(BankRemitBankcardInputUI.this)) || (!BankRemitBankcardInputUI.U(BankRemitBankcardInputUI.this))) {
          BankRemitBankcardInputUI.V(BankRemitBankcardInputUI.this);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(14673, new Object[] { Integer.valueOf(3) });
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
    dxx();
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
        this.wFq = false;
        this.wFj = paramIntent.getStringExtra("key_bank_card_seqno");
        str = this.wFj;
        if (this.wFd == null) {
          break label241;
        }
        localIterator = this.wFd.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (TransferRecordParcel)localIterator.next();
        } while (!((TransferRecordParcel)localObject).wES.equals(str));
      }
      for (;;)
      {
        this.wFp = ((TransferRecordParcel)localObject);
        dxt();
        dxx();
        if (this.wFp != null) {
          al(this.wFp.wES, this.wFi, this.wFp.cZz);
        }
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67441);
            BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this).dtG();
            AppMethodBeat.o(67441);
          }
        }, 50L);
        ac.i("MicroMsg.BankRemitBankcardInputUI", "resultCode: %s", new Object[] { Integer.valueOf(paramInt2) });
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
          t(str, this.wFd);
          t(str, this.wFe);
        }
        label241:
        if (this.wFe != null)
        {
          localIterator = this.wFe.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject = (TransferRecordParcel)localIterator.next();
              if (((TransferRecordParcel)localObject).wES.equals(str)) {
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
          a((TransferRecordParcel)localObject, this.wFd);
          a((TransferRecordParcel)localObject, this.wFe);
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
        if ((this.wFo != null) && (this.wFo.wEC != null))
        {
          paramIntent = this.wFo.wEC.iterator();
          while (paramIntent.hasNext())
          {
            localObject = (EnterTimeParcel)paramIntent.next();
            if (((EnterTimeParcel)localObject).wEF == paramInt1) {
              this.wFn = ((EnterTimeParcel)localObject);
            }
          }
        }
        for (;;)
        {
          dxv();
          dxx();
          AppMethodBeat.o(67462);
          return;
          ac.w("MicroMsg.BankRemitBankcardInputUI", "can't find the right enter scene: %d", new Object[] { Integer.valueOf(paramInt1) });
        }
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        this.wFo = ((BankcardElemParcel)paramIntent.getParcelableExtra("key_bank_card_elem_parcel"));
        dxu();
        dxy();
        dxv();
        dxw();
        dxx();
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
    paramBundle = new xo();
    paramBundle.dAo.scene = "12";
    paramBundle.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67422);
        if (!bs.isNullOrNil(paramBundle.dAp.dAq)) {
          com.tencent.mm.wallet_core.ui.e.a((TextView)BankRemitBankcardInputUI.this.findViewById(2131297186), paramBundle.dAp.dAq, paramBundle.dAp.content, paramBundle.dAp.url);
        }
        AppMethodBeat.o(67422);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
    addSceneEndListener(1348);
    addSceneEndListener(1542);
    addSceneEndListener(1378);
    addSceneEndListener(1349);
    addSceneEndListener(1280);
    this.wFm = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPv, ""));
    pL(false);
    dxq();
    setMMTitle(2131756407);
    addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67435);
        ac.d("MicroMsg.BankRemitBankcardInputUI", "help click");
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new com.tencent.mm.ui.widget.a.e(BankRemitBankcardInputUI.this.getContext(), 1, false));
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).ISu = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(67433);
            paramAnonymous2l.add(0, 0, 0, BankRemitBankcardInputUI.this.getString(2131756381));
            paramAnonymous2l.add(0, 1, 0, BankRemitBankcardInputUI.this.getString(2131756379));
            AppMethodBeat.o(67433);
          }
        };
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).ISv = new n.d()
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
              if (!bs.isNullOrNil(BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this))) {
                com.tencent.mm.wallet_core.ui.e.o(BankRemitBankcardInputUI.this.getContext(), BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this), false);
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.wUl.f(14673, new Object[] { Integer.valueOf(6) });
                AppMethodBeat.o(67434);
                return;
                ac.w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
              }
              com.tencent.mm.wallet_core.ui.e.o(BankRemitBankcardInputUI.this.getContext(), "https://kf.qq.com/touch/scene_product.html?scene_id=kf4568", true);
            }
          }
        };
        BankRemitBankcardInputUI.this.hideTenpayKB();
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).cED();
        com.tencent.mm.plugin.report.service.h.wUl.f(14673, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(67435);
        return false;
      }
    });
    com.tencent.mm.plugin.report.service.h.wUl.f(14673, new Object[] { Integer.valueOf(1) });
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
    this.wEW.postDelayed(new Runnable()
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
    ac.i("MicroMsg.BankRemitBankcardInputUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof com.tencent.mm.plugin.remittance.bankcard.a.a))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.a.a)paramn;
      if (!paramString.wEi.equals(this.wFp.wES))
      {
        ac.i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", new Object[] { paramString.wEi, this.wFj });
        AppMethodBeat.o(67458);
        return true;
      }
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67424);
          BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, paramString.wEh.DTk);
          BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new BankcardElemParcel(paramString.wEh.DTj));
          if (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) != null) {}
          for (paramAnonymousString = BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).tGS;; paramAnonymousString = "")
          {
            ac.i("MicroMsg.BankRemitBankcardInputUI", "response bank: %s", new Object[] { paramAnonymousString });
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
          ac.e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.wEh.dae), paramString.wEh.oxf });
          if (!bs.isNullOrNil(paramString.wEh.oxf)) {
            com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.wEh.oxf, null, false, new DialogInterface.OnClickListener()
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
          ac.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
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
        if (paramString == this.wFu)
        {
          ac.i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
          this.wFu = null;
        }
        if (!paramString.md5.equals(this.wEX.getMD5Value()))
        {
          ac.i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", new Object[] { paramString.md5, this.wEX.getMD5Value() });
          AppMethodBeat.o(67458);
          return true;
        }
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67427);
            if (paramString.wEn.DTj == null)
            {
              ac.w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
              BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67427);
              return;
            }
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new BankcardElemParcel(paramString.wEn.DTj));
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
            ac.e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.wEn.dae), paramString.wEn.oxf });
            BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67426);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67425);
            ac.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
            AppMethodBeat.o(67425);
          }
        });
      }
      else if ((paramn instanceof m))
      {
        paramString = (m)paramn;
        this.wFw = true;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67430);
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, false);
            BankRemitBankcardInputUI.d(BankRemitBankcardInputUI.this, paramString.wEt.DTi);
            ac.d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", new Object[] { BankRemitBankcardInputUI.L(BankRemitBankcardInputUI.this) });
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, TransferRecordParcel.eY(paramString.wEt.Fyu));
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, TransferRecordParcel.eY(paramString.wEt.Fyt));
            ac.i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.M(BankRemitBankcardInputUI.this).size()), Integer.valueOf(BankRemitBankcardInputUI.N(BankRemitBankcardInputUI.this).size()) });
            BankRemitBankcardInputUI.O(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67430);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67429);
            ac.e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", new Object[] { Integer.valueOf(paramString.wEt.dae), paramString.wEt.oxf });
            if (!bs.isNullOrNil(paramString.wEt.oxf)) {
              com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.wEt.oxf, null, false, new DialogInterface.OnClickListener()
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
            ac.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
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
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, paramString.wEk.DTk);
            BankRemitBankcardInputUI.e(BankRemitBankcardInputUI.this, paramString.wEk.wEU);
            BankRemitBankcardInputUI.f(BankRemitBankcardInputUI.this, paramString.wEk.wES);
            BankRemitBankcardInputUI.g(BankRemitBankcardInputUI.this, paramString.wEk.wET);
            BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67436);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67432);
            ac.e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", new Object[] { Integer.valueOf(paramString.wEk.dae), paramString.wEk.oxf });
            if (!bs.isNullOrNil(paramString.wEk.oxf)) {
              com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.wEk.oxf, null, false, new DialogInterface.OnClickListener()
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
            ac.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
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
            BankRemitBankcardInputUI.h(BankRemitBankcardInputUI.this, paramString.wEr.FpN);
            BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this, paramString.wEr.FpO);
            ac.i("MicroMsg.BankRemitBankcardInputUI", "set uniqueId:%s", new Object[] { BankRemitBankcardInputUI.Q(BankRemitBankcardInputUI.this) });
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, paramString.wEr.FpP);
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, paramString.wEr.FpQ);
            ac.d("MicroMsg.BankRemitBankcardInputUI", "set nameLenLimit:%s", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.o(BankRemitBankcardInputUI.this)) });
            if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this))
            {
              if (BankRemitBankcardInputUI.y(BankRemitBankcardInputUI.this))
              {
                if (BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this))
                {
                  ac.i("MicroMsg.BankRemitBankcardInputUI", "NetSceneBankRemitOperation: from record goto next direct");
                  BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
                }
                for (;;)
                {
                  BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, false);
                  AppMethodBeat.o(67439);
                  return;
                  BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).tGS, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).cZz);
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
            ac.e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", new Object[] { Integer.valueOf(paramString.wEr.dae), paramString.wEr.oxf });
            if (!bs.isNullOrNil(paramString.wEr.oxf)) {
              com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.wEr.oxf, null, false, new DialogInterface.OnClickListener()
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
            ac.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
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