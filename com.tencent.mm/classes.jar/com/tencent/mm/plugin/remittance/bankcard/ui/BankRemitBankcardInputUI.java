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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.a.xd.b;
import com.tencent.mm.plugin.remittance.bankcard.a.d;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.plugin.remittance.bankcard.a.m;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.v;
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
  private String drI = "";
  private Button iwY;
  private com.tencent.mm.ui.widget.a.e qii;
  private Dialog tpn = null;
  private CdnImageView vuK;
  private WalletFormView vuR;
  private WalletFormView vuS;
  private WalletFormView vuT;
  private WalletFormView vuU;
  private ListPopupWindow vuV;
  private c vuW;
  private Filter.FilterListener vuX;
  private ArrayList<TransferRecordParcel> vuY;
  private ArrayList<TransferRecordParcel> vuZ;
  private int vva;
  private int vvb;
  private String vvc;
  private String vvd;
  private String vve;
  private String vvf;
  private String vvg;
  private String vvh;
  private EnterTimeParcel vvi;
  private BankcardElemParcel vvj;
  private TransferRecordParcel vvk;
  private boolean vvl = true;
  private boolean vvm = false;
  private boolean vvn = false;
  private boolean vvo = false;
  private com.tencent.mm.plugin.remittance.bankcard.a.g vvp = null;
  private boolean vvq = false;
  private boolean vvr = false;
  private boolean vvs = true;
  private boolean vvt = false;
  private boolean vvu = false;
  private boolean vvv = false;
  private String vvw;
  private String vvx;
  
  private static void a(TransferRecordParcel paramTransferRecordParcel, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67463);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.vuN.equals(paramTransferRecordParcel.vuN))
        {
          localTransferRecordParcel.vuQ = paramTransferRecordParcel.vuQ;
          AppMethodBeat.o(67463);
          return;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(67463);
  }
  
  private void ak(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67465);
    ad.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", new Object[] { paramString1 });
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.a(paramString1, paramString2, paramString3), false);
    AppMethodBeat.o(67465);
  }
  
  private void djp()
  {
    AppMethodBeat.i(67468);
    ad.i("MicroMsg.BankRemitBankcardInputUI", "do operation");
    this.vvu = true;
    doSceneProgress(new k(), false);
    AppMethodBeat.o(67468);
  }
  
  private void djq()
  {
    AppMethodBeat.i(67469);
    this.vuS.dfZ();
    this.vuS.setContentEnabled(false);
    this.vvn = true;
    AppMethodBeat.o(67469);
  }
  
  private void djr()
  {
    AppMethodBeat.i(67470);
    this.vuT.setClickable(false);
    this.vvo = true;
    AppMethodBeat.o(67470);
  }
  
  private void djs()
  {
    AppMethodBeat.i(67471);
    if (this.vvk != null)
    {
      this.vuR.setText(this.vvk.vuP);
      this.vvm = true;
      this.vuS.setText(getString(2131756358, new Object[] { this.vvk.vuO }));
      this.vuT.setText(this.vvk.szi);
      this.vuK.setUrl(this.vvk.vur);
      djq();
      djr();
    }
    AppMethodBeat.o(67471);
  }
  
  private void djt()
  {
    AppMethodBeat.i(67472);
    if (this.vvj != null)
    {
      this.vuT.setText(this.vvj.szi);
      this.vuK.setUrl(this.vvj.vur);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.vuK.getLayoutParams();
      localLayoutParams.setMargins(com.tencent.mm.cd.a.fromDPToPix(getContext(), 15), 0, 0, 0);
      this.vuK.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(67472);
  }
  
  private void dju()
  {
    AppMethodBeat.i(67473);
    if (this.vvi != null)
    {
      if (!bt.isNullOrNil(this.vvi.gHT)) {
        this.vuU.setContentTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(this.vvi.gHT, true));
      }
      for (;;)
      {
        this.vuU.setText(this.vvi.vuB);
        this.vuU.setVisibility(0);
        AppMethodBeat.o(67473);
        return;
        this.vuU.setContentTextColorRes(2131100711);
      }
    }
    if ((this.vvj != null) && (!bt.isNullOrNil(this.vvj.vuu)))
    {
      this.vuU.setText(this.vvj.vuu);
      if (!bt.isNullOrNil(this.vvj.vuv)) {
        this.vuU.setContentTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(this.vvj.vuv, true));
      }
      for (;;)
      {
        this.vuU.setVisibility(0);
        AppMethodBeat.o(67473);
        return;
        this.vuU.setContentTextColorRes(2131100711);
      }
    }
    this.vuU.setVisibility(8);
    AppMethodBeat.o(67473);
  }
  
  private void djv()
  {
    AppMethodBeat.i(67474);
    if (this.vuU.getVisibility() == 0)
    {
      this.vuT.setBackground(getResources().getDrawable(2131234650));
      AppMethodBeat.o(67474);
      return;
    }
    this.vuT.setBackground(getResources().getDrawable(2131231123));
    AppMethodBeat.o(67474);
  }
  
  private void djw()
  {
    AppMethodBeat.i(67475);
    if ((!bt.isNullOrNil(this.vuR.getText())) && (!this.vuR.getText().trim().isEmpty()) && (!bt.isNullOrNil(this.vuS.getText())) && (this.vuR.aKX()) && (!this.vuS.getText().trim().isEmpty()) && (this.vuS.aKX()) && (!bt.isNullOrNil(this.vuT.getText())) && (this.vuU.getVisibility() == 0) && (!bt.isNullOrNil(this.vuU.getText())) && (this.vvj != null) && (bt.isNullOrNil(this.vvj.vuw)))
    {
      this.iwY.setEnabled(true);
      AppMethodBeat.o(67475);
      return;
    }
    this.iwY.setEnabled(false);
    AppMethodBeat.o(67475);
  }
  
  private void djx()
  {
    AppMethodBeat.i(67476);
    if ((this.vvj != null) && (!bt.isNullOrNil(this.vvj.vuu)))
    {
      this.vvi = null;
      AppMethodBeat.o(67476);
      return;
    }
    if ((this.vvj != null) && (this.vvj.vux != null))
    {
      Iterator localIterator = this.vvj.vux.iterator();
      while (localIterator.hasNext())
      {
        EnterTimeParcel localEnterTimeParcel = (EnterTimeParcel)localIterator.next();
        if (localEnterTimeParcel.vuD > 0)
        {
          this.vvi = localEnterTimeParcel;
          AppMethodBeat.o(67476);
          return;
        }
      }
    }
    AppMethodBeat.o(67476);
  }
  
  private void oN(boolean paramBoolean)
  {
    AppMethodBeat.i(67466);
    ad.i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      doSceneProgress(new m(), true);
      AppMethodBeat.o(67466);
      return;
    }
    doSceneProgress(new m(), false);
    AppMethodBeat.o(67466);
  }
  
  private void s(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(67467);
    ad.i("MicroMsg.BankRemitBankcardInputUI", "do check bank bind: %s %s", new Object[] { paramString3, paramString4 });
    ad.d("MicroMsg.BankRemitBankcardInputUI", "payeeName: %s, bankCardNo: %s", new Object[] { paramString1, paramString2 });
    doSceneProgress(new d(paramString1, paramString2, paramString3, paramString4));
    AppMethodBeat.o(67467);
  }
  
  private static void v(String paramString, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(67464);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.vuN.equals(paramString))
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
      ad.e("MicroMsg.BankRemitBankcardInputUI", "%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
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
    int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.vuR = ((WalletFormView)findViewById(2131297515));
    this.vuR.getInfoIv().setLayoutParams(localLayoutParams);
    this.vuR.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.vuR.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.vuS = ((WalletFormView)findViewById(2131297514));
    this.vuS.getInfoIv().setLayoutParams(localLayoutParams);
    this.vuS.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.vuS.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.vuT = ((WalletFormView)findViewById(2131297513));
    this.vuK = ((CdnImageView)this.vuT.findViewById(2131306748));
    this.vuU = ((WalletFormView)findViewById(2131297512));
    this.iwY = ((Button)findViewById(2131297516));
    this.vuR.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    this.vuR.a(new TextWatcher()
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
    this.vuR.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(67448);
        if (paramAnonymousInt == 5)
        {
          BankRemitBankcardInputUI.this.hideVKB();
          if (!BankRemitBankcardInputUI.p(BankRemitBankcardInputUI.this)) {
            aq.n(new Runnable()
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
    this.vuR.fkI();
    com.tencent.mm.wallet_core.ui.formview.a.b(this.vuS);
    setEditFocusListener(this.vuS, 2, false, false, true);
    this.vuS.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(67450);
        BankRemitBankcardInputUI.q(BankRemitBankcardInputUI.this);
        aq.n(new Runnable()
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
    if (!bt.isNullOrNil(this.content)) {
      this.vuS.setText(this.content);
    }
    this.vuT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67451);
        BankRemitBankcardInputUI.this.hideVKB();
        paramAnonymousView = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getText();
        if ((BankRemitBankcardInputUI.s(BankRemitBankcardInputUI.this)) && (!bt.isNullOrNil(paramAnonymousView)))
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
    this.vuU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67452);
        ad.i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
        BankRemitBankcardInputUI.this.hideVKB();
        BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).dfZ();
        if (!BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this))
        {
          paramAnonymousView = new Intent(BankRemitBankcardInputUI.this.getContext(), BankRemitSelectArriveTimeUI.class);
          if ((BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).vux != null)) {
            paramAnonymousView.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).vux);
          }
          if (BankRemitBankcardInputUI.w(BankRemitBankcardInputUI.this) != null) {
            paramAnonymousView.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.w(BankRemitBankcardInputUI.this).vuA);
          }
          BankRemitBankcardInputUI.this.startActivityForResult(paramAnonymousView, 3);
        }
        AppMethodBeat.o(67452);
      }
    });
    this.iwY.setOnClickListener(new v()
    {
      public final void bOU()
      {
        AppMethodBeat.i(67454);
        ad.i("MicroMsg.BankRemitBankcardInputUI", "click next btn");
        BankRemitBankcardInputUI.this.hideVKB();
        BankRemitBankcardInputUI.this.hideTenpayKB();
        if (BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this))
        {
          AppMethodBeat.o(67454);
          return;
        }
        Object localObject1 = BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this).getText();
        Object localObject2 = BankRemitBankcardInputUI.r(BankRemitBankcardInputUI.this).getText();
        if ((bt.isNullOrNil((String)localObject1)) || (((String)localObject1).trim().isEmpty()) || (bt.isNullOrNil((String)localObject2)) || (((String)localObject2).trim().isEmpty()) || (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) == null))
        {
          ad.w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", new Object[] { localObject1, localObject2, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) });
          AppMethodBeat.o(67454);
          return;
        }
        ad.i("MicroMsg.BankRemitBankcardInputUI", "onRealClick() ifGetOperation:%s waitingGetOperation:%s ifAutoNext:%s", new Object[] { Boolean.valueOf(BankRemitBankcardInputUI.m(BankRemitBankcardInputUI.this)), Boolean.valueOf(BankRemitBankcardInputUI.x(BankRemitBankcardInputUI.this)), Boolean.valueOf(BankRemitBankcardInputUI.y(BankRemitBankcardInputUI.this)) });
        if (BankRemitBankcardInputUI.m(BankRemitBankcardInputUI.this))
        {
          if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this))
          {
            if (BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this))
            {
              ad.i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
              BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67454);
              return;
            }
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, (String)localObject1, (String)localObject2, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).szi, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).dca);
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
              ad.i("MicroMsg.BankRemitBankcardInputUI", "coperationTipDialogNoTransparent onCancel()");
              BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, false);
              BankRemitBankcardInputUI.C(BankRemitBankcardInputUI.this);
              if ((BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this) != null) && (BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).isShowing())) {
                BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.this).dismiss();
              }
              if ((BankRemitBankcardInputUI.D(BankRemitBankcardInputUI.this).getVisibility() == 8) || (BankRemitBankcardInputUI.E(BankRemitBankcardInputUI.this).getVisibility() == 4))
              {
                ad.i("MicroMsg.BankRemitBankcardInputUI", "usr cancel, & visibility not visiable, so finish");
                BankRemitBankcardInputUI.this.finish();
              }
              BankRemitBankcardInputUI.F(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67453);
            }
          }));
        }
      }
    });
    this.vuR.getInfoIv().setVisibility(0);
    this.vuR.getInfoIv().setClickable(true);
    this.vuR.getInfoIv().setEnabled(true);
    this.vuR.getInfoIv().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67445);
        ad.d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
        if ((BankRemitBankcardInputUI.T(BankRemitBankcardInputUI.this)) || (!BankRemitBankcardInputUI.U(BankRemitBankcardInputUI.this))) {
          BankRemitBankcardInputUI.V(BankRemitBankcardInputUI.this);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(14673, new Object[] { Integer.valueOf(3) });
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
    djw();
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
        this.vvl = false;
        this.vve = paramIntent.getStringExtra("key_bank_card_seqno");
        str = this.vve;
        if (this.vuY == null) {
          break label241;
        }
        localIterator = this.vuY.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (TransferRecordParcel)localIterator.next();
        } while (!((TransferRecordParcel)localObject).vuN.equals(str));
      }
      for (;;)
      {
        this.vvk = ((TransferRecordParcel)localObject);
        djs();
        djw();
        if (this.vvk != null) {
          ak(this.vvk.vuN, this.vvd, this.vvk.dca);
        }
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67441);
            BankRemitBankcardInputUI.n(BankRemitBankcardInputUI.this).dfZ();
            AppMethodBeat.o(67441);
          }
        }, 50L);
        ad.i("MicroMsg.BankRemitBankcardInputUI", "resultCode: %s", new Object[] { Integer.valueOf(paramInt2) });
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
          v(str, this.vuY);
          v(str, this.vuZ);
        }
        label241:
        if (this.vuZ != null)
        {
          localIterator = this.vuZ.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject = (TransferRecordParcel)localIterator.next();
              if (((TransferRecordParcel)localObject).vuN.equals(str)) {
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
          a((TransferRecordParcel)localObject, this.vuY);
          a((TransferRecordParcel)localObject, this.vuZ);
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
        if ((this.vvj != null) && (this.vvj.vux != null))
        {
          paramIntent = this.vvj.vux.iterator();
          while (paramIntent.hasNext())
          {
            localObject = (EnterTimeParcel)paramIntent.next();
            if (((EnterTimeParcel)localObject).vuA == paramInt1) {
              this.vvi = ((EnterTimeParcel)localObject);
            }
          }
        }
        for (;;)
        {
          dju();
          djw();
          AppMethodBeat.o(67462);
          return;
          ad.w("MicroMsg.BankRemitBankcardInputUI", "can't find the right enter scene: %d", new Object[] { Integer.valueOf(paramInt1) });
        }
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        this.vvj = ((BankcardElemParcel)paramIntent.getParcelableExtra("key_bank_card_elem_parcel"));
        djt();
        djx();
        dju();
        djv();
        djw();
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
    paramBundle = new xd();
    paramBundle.dCC.scene = "12";
    paramBundle.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67422);
        if (!bt.isNullOrNil(paramBundle.dCD.dCE)) {
          com.tencent.mm.wallet_core.ui.e.a((TextView)BankRemitBankcardInputUI.this.findViewById(2131297186), paramBundle.dCD.dCE, paramBundle.dCD.content, paramBundle.dCD.url);
        }
        AppMethodBeat.o(67422);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
    addSceneEndListener(1348);
    addSceneEndListener(1542);
    addSceneEndListener(1378);
    addSceneEndListener(1349);
    addSceneEndListener(1280);
    this.vvh = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FrF, ""));
    oN(false);
    djp();
    setMMTitle(2131756407);
    addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67435);
        ad.d("MicroMsg.BankRemitBankcardInputUI", "help click");
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new com.tencent.mm.ui.widget.a.e(BankRemitBankcardInputUI.this.getContext(), 1, false));
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).HrX = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(67433);
            paramAnonymous2l.add(0, 0, 0, BankRemitBankcardInputUI.this.getString(2131756381));
            paramAnonymous2l.add(0, 1, 0, BankRemitBankcardInputUI.this.getString(2131756379));
            AppMethodBeat.o(67433);
          }
        };
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).HrY = new n.d()
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
              if (!bt.isNullOrNil(BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this))) {
                com.tencent.mm.wallet_core.ui.e.p(BankRemitBankcardInputUI.this.getContext(), BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this), false);
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.vKh.f(14673, new Object[] { Integer.valueOf(6) });
                AppMethodBeat.o(67434);
                return;
                ad.w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
              }
              com.tencent.mm.wallet_core.ui.e.p(BankRemitBankcardInputUI.this.getContext(), "https://kf.qq.com/touch/scene_product.html?scene_id=kf4568", true);
            }
          }
        };
        BankRemitBankcardInputUI.this.hideTenpayKB();
        BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this).csG();
        com.tencent.mm.plugin.report.service.h.vKh.f(14673, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(67435);
        return false;
      }
    });
    com.tencent.mm.plugin.report.service.h.vKh.f(14673, new Object[] { Integer.valueOf(1) });
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
    this.vuR.postDelayed(new Runnable()
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
    ad.i("MicroMsg.BankRemitBankcardInputUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof com.tencent.mm.plugin.remittance.bankcard.a.a))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.a.a)paramn;
      if (!paramString.vud.equals(this.vvk.vuN))
      {
        ad.i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", new Object[] { paramString.vud, this.vve });
        AppMethodBeat.o(67458);
        return true;
      }
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67424);
          BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, paramString.vuc.CAM);
          BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new BankcardElemParcel(paramString.vuc.CAL));
          if (BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this) != null) {}
          for (paramAnonymousString = BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).szi;; paramAnonymousString = "")
          {
            ad.i("MicroMsg.BankRemitBankcardInputUI", "response bank: %s", new Object[] { paramAnonymousString });
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
          ad.e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.vuc.dcG), paramString.vuc.nTK });
          if (!bt.isNullOrNil(paramString.vuc.nTK)) {
            com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.vuc.nTK, null, false, new DialogInterface.OnClickListener()
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
          ad.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
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
        if (paramString == this.vvp)
        {
          ad.i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
          this.vvp = null;
        }
        if (!paramString.md5.equals(this.vuS.getMD5Value()))
        {
          ad.i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", new Object[] { paramString.md5, this.vuS.getMD5Value() });
          AppMethodBeat.o(67458);
          return true;
        }
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67427);
            if (paramString.vui.CAL == null)
            {
              ad.w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
              BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
              AppMethodBeat.o(67427);
              return;
            }
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, new BankcardElemParcel(paramString.vui.CAL));
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
            ad.e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.vui.dcG), paramString.vui.nTK });
            BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67426);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67425);
            ad.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
            AppMethodBeat.o(67425);
          }
        });
      }
      else if ((paramn instanceof m))
      {
        paramString = (m)paramn;
        this.vvr = true;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67430);
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, false);
            BankRemitBankcardInputUI.d(BankRemitBankcardInputUI.this, paramString.vuo.CAK);
            ad.d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", new Object[] { BankRemitBankcardInputUI.L(BankRemitBankcardInputUI.this) });
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, TransferRecordParcel.eS(paramString.vuo.Ebz));
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, TransferRecordParcel.eS(paramString.vuo.Eby));
            ad.i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.M(BankRemitBankcardInputUI.this).size()), Integer.valueOf(BankRemitBankcardInputUI.N(BankRemitBankcardInputUI.this).size()) });
            BankRemitBankcardInputUI.O(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67430);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67429);
            ad.e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", new Object[] { Integer.valueOf(paramString.vuo.dcG), paramString.vuo.nTK });
            if (!bt.isNullOrNil(paramString.vuo.nTK)) {
              com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.vuo.nTK, null, false, new DialogInterface.OnClickListener()
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
            ad.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
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
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, paramString.vuf.CAM);
            BankRemitBankcardInputUI.e(BankRemitBankcardInputUI.this, paramString.vuf.vuP);
            BankRemitBankcardInputUI.f(BankRemitBankcardInputUI.this, paramString.vuf.vuN);
            BankRemitBankcardInputUI.g(BankRemitBankcardInputUI.this, paramString.vuf.vuO);
            BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
            AppMethodBeat.o(67436);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67432);
            ad.e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", new Object[] { Integer.valueOf(paramString.vuf.dcG), paramString.vuf.nTK });
            if (!bt.isNullOrNil(paramString.vuf.nTK)) {
              com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.vuf.nTK, null, false, new DialogInterface.OnClickListener()
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
            ad.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
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
            BankRemitBankcardInputUI.h(BankRemitBankcardInputUI.this, paramString.vum.DTr);
            BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this, paramString.vum.DTs);
            ad.i("MicroMsg.BankRemitBankcardInputUI", "set uniqueId:%s", new Object[] { BankRemitBankcardInputUI.Q(BankRemitBankcardInputUI.this) });
            BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, paramString.vum.DTt);
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, paramString.vum.DTu);
            ad.d("MicroMsg.BankRemitBankcardInputUI", "set nameLenLimit:%s", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.o(BankRemitBankcardInputUI.this)) });
            if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this))
            {
              if (BankRemitBankcardInputUI.y(BankRemitBankcardInputUI.this))
              {
                if (BankRemitBankcardInputUI.i(BankRemitBankcardInputUI.this))
                {
                  ad.i("MicroMsg.BankRemitBankcardInputUI", "NetSceneBankRemitOperation: from record goto next direct");
                  BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
                }
                for (;;)
                {
                  BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, false);
                  AppMethodBeat.o(67439);
                  return;
                  BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).szi, BankRemitBankcardInputUI.v(BankRemitBankcardInputUI.this).dca);
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
            ad.e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", new Object[] { Integer.valueOf(paramString.vum.dcG), paramString.vum.nTK });
            if (!bt.isNullOrNil(paramString.vum.nTK)) {
              com.tencent.mm.ui.base.h.a(BankRemitBankcardInputUI.this.getContext(), paramString.vum.nTK, null, false, new DialogInterface.OnClickListener()
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
            ad.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousn });
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