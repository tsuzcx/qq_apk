package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.l;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.aac;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tenpay.android.wechat.TenpaySecureEncrypt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WcPayRealnameVerifyIdInputUI
  extends WalletBaseUI
{
  private static final int BqV;
  private WalletFormView BqW;
  private WalletFormView BqX;
  private WalletFormView BqY;
  private WalletFormView BqZ;
  private WalletFormView Bqi;
  private WalletFormView Bqj;
  private String BrA;
  private TenpaySecureEncrypt BrB;
  private WalletFormView Bra;
  private WalletFormView Brb;
  private WalletFormView Brc;
  private WalletFormView Brd;
  private WalletFormView Bre;
  private c Brf;
  private TextView Brg;
  private b Brh;
  private String Bri;
  private String Brj;
  private boolean Brk;
  private VM Brl;
  private String Brm;
  private String Brn;
  private String[] Bro;
  private List<cmb> Brp;
  private String[] Brq;
  private int Brr;
  private int Brs;
  private int Brt;
  private int Bru;
  private int Brv;
  private int Brw;
  private int Brx;
  private int Bry;
  private int Brz;
  private Button iXb;
  private TextView lfN;
  private Profession[] mProfessions;
  private WalletFormView wEW;
  
  static
  {
    AppMethodBeat.i(70117);
    BqV = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 88);
    AppMethodBeat.o(70117);
  }
  
  public WcPayRealnameVerifyIdInputUI()
  {
    AppMethodBeat.i(70104);
    this.Brp = new ArrayList();
    this.Brq = new String[100];
    int i = 0;
    while (i < this.Brq.length)
    {
      this.Brq[i] = ai.getContext().getString(2131765220, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    this.Brr = 0;
    this.Brs = 0;
    this.Brt = 0;
    this.Bru = 0;
    this.Brv = 0;
    this.Brw = 0;
    this.Brx = 0;
    this.Bry = 0;
    this.Brz = 0;
    this.BrA = "";
    this.BrB = new TenpaySecureEncrypt();
    AppMethodBeat.o(70104);
  }
  
  private void a(g paramg)
  {
    AppMethodBeat.i(70109);
    d locald = getProcess();
    Bundle localBundle = getInput();
    String str = paramg.token;
    ac.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify response succ");
    if (locald != null)
    {
      localBundle.putString("key_real_name_token", str);
      localBundle.putString("key_country_code", (String)this.Brl.BrQ.getValue());
      localBundle.putString("key_province_code", (String)this.Brl.BrR.getValue());
      localBundle.putString("key_city_code", (String)this.Brl.BrS.getValue());
      localBundle.putParcelable("key_profession", (Parcelable)this.Brl.BrV.getValue());
      localBundle.putBoolean("realname_verify_process_need_bind_card", paramg.Bsr);
      localBundle.putBoolean("realname_verify_process_need_face", paramg.Bss);
      localBundle.putLong("realname_verify_process_face_scene", paramg.gRQ);
      localBundle.putString("realname_verify_process_face_package", paramg.packageExt);
      localBundle.putString("realname_verify_process_face_package_sign", paramg.dtT);
      localBundle.putString("realname_verify_process_add_bank_word", paramg.Bsv);
      localBundle.putString("realname_verify_process_req_key", paramg.djr);
      paramg = new RealNameBundle();
      paramg.BsL = ((String)this.Brl.BrL.getValue());
      paramg.BsM = this.Brm;
      paramg.BsN = this.Brn;
      paramg.BsO = ((cmb)this.Brl.BrN.getValue()).Fzq.key;
      paramg.BsP = this.BqW.getText();
      paramg.BsQ = ((Profession)this.Brl.BrV.getValue());
      paramg.BsR = ((String)this.Brl.BrQ.getValue());
      paramg.BsS = ((String)this.Brl.BrR.getValue());
      paramg.BsT = ((String)this.Brl.BrS.getValue());
      paramg.BsU = ((String)this.Brl.BrT.getValue());
      paramg.BsV = ((Integer)this.Brl.BrZ.getValue()).intValue();
      paramg.Bti = ((String)this.Brl.BrX.getValue());
      paramg.Btj = this.Brr;
      paramg.Btk = this.Brs;
      paramg.Btl = this.Brt;
      paramg.BsW = ((String)this.Brl.BrY.getValue());
      paramg.BsX = this.Bru;
      paramg.BsY = this.Brv;
      paramg.BsZ = this.Brw;
      paramg.Bta = this.Brc.getText();
      paramg.Btb = this.Brx;
      paramg.Btc = this.Bry;
      paramg.Btd = this.Brz;
      paramg.Bte = ((String)this.Brl.Bsb.getValue());
      paramg.Btf = ((String)this.Brl.Bsc.getValue());
      paramg.Btg = this.BrA;
      paramg.Bth = ((String)this.Brl.BrU.getValue());
      paramg.Btm = ((String)this.Brl.Bsd.getValue());
      if (!getString(2131763533).equals(this.Brl.BrM.getValue())) {
        break label640;
      }
    }
    label640:
    for (int i = 1;; i = 2)
    {
      paramg.exL = i;
      localBundle.putParcelable("realname_verify_process_bundle", paramg);
      locald.a(this, 0, localBundle);
      AppMethodBeat.o(70109);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131496066;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70106);
    this.wEW = ((WalletFormView)findViewById(2131307081));
    this.Bre = ((WalletFormView)findViewById(2131307085));
    this.BqW = ((WalletFormView)findViewById(2131307079));
    this.BqX = ((WalletFormView)findViewById(2131307078));
    this.BqY = ((WalletFormView)findViewById(2131307077));
    this.BqZ = ((WalletFormView)findViewById(2131307076));
    this.Bra = ((WalletFormView)findViewById(2131307075));
    this.Brb = ((WalletFormView)findViewById(2131307082));
    this.Brc = ((WalletFormView)findViewById(2131307074));
    this.Bqi = ((WalletFormView)findViewById(2131307084));
    this.Bqj = ((WalletFormView)findViewById(2131307073));
    this.Brd = ((WalletFormView)findViewById(2131307080));
    this.iXb = ((Button)findViewById(2131307083));
    this.lfN = ((TextView)findViewById(2131307087));
    this.Brg = ((TextView)findViewById(2131307086));
    if (!bs.isNullOrNil(this.Bri)) {
      this.lfN.setText(this.Bri);
    }
    if (!bs.isNullOrNil(this.Brj))
    {
      this.Brg.setText(this.Brj);
      this.Brg.setVisibility(0);
    }
    this.wEW.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    int i = getResources().getDimensionPixelSize(2131165480);
    int j = getResources().getDimensionPixelSize(2131165274);
    Object localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).rightMargin = j;
    this.wEW.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.wEW.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.wEW.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.wEW.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(70075);
        paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
        String str = WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).getText();
        paramAnonymousEditable.BrL.setValue(str);
        AppMethodBeat.o(70075);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.BqW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70087);
        ac.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "click cre type");
        WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).BrP.setValue(Boolean.TRUE);
        AppMethodBeat.o(70087);
      }
    });
    this.BqW.getInfoIv().setClickable(false);
    this.BqW.getContentEt().setInputType(131073);
    this.BqX.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.BqX.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.BqX.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.BqX);
    this.BqX.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(70090);
        WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramAnonymousEditable.toString());
        WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this, WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).getText());
        paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
        String str = WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
        paramAnonymousEditable.BrO.setValue(str);
        AppMethodBeat.o(70090);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Bre.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70092);
        paramAnonymousView = WcPayRealnameVerifyIdInputUI.this.getResources().getStringArray(2130903102);
        paramAnonymousView = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), paramAnonymousView);
        paramAnonymousView.Jjt = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(174489);
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2Object2 = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
              paramAnonymous2Object1 = (String)paramAnonymous2Object1;
              paramAnonymous2Object2.BrM.setValue(paramAnonymous2Object1);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174489);
          }
        };
        paramAnonymousView.show();
        AppMethodBeat.o(70092);
      }
    });
    this.BqY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70094);
        paramAnonymousView = new b(WcPayRealnameVerifyIdInputUI.this.getContext());
        Object localObject = Calendar.getInstance();
        int i = ((Calendar)localObject).get(1);
        int j = ((Calendar)localObject).get(2) + 1;
        int k = ((Calendar)localObject).get(5);
        paramAnonymousView.aQ(i, j, k);
        paramAnonymousView.aP(1900, 1, 1);
        paramAnonymousView.Jjn = new b.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(174490);
            if (paramAnonymous2Boolean)
            {
              ac.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "year: %s, month: %s, day: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
              String str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
              WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
              WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).BrX.setValue(str);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174490);
          }
        };
        localObject = (String)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).BrX.getValue();
        if ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
        {
          i = bs.getInt(((String)localObject).substring(0, 4), 0);
          j = bs.getInt(((String)localObject).substring(5, 7), 0);
          k = bs.getInt(((String)localObject).substring(9, 10), 0);
          if ((i > 0) && (j > 0) && (k > 0)) {
            paramAnonymousView.aO(i, j, k);
          }
        }
        for (;;)
        {
          paramAnonymousView.show();
          AppMethodBeat.o(70094);
          return;
          paramAnonymousView.aO(i, j, k);
        }
      }
    });
    this.BqY.getInfoIv().setClickable(false);
    this.BqZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70096);
        WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, new b(WcPayRealnameVerifyIdInputUI.this.getContext()));
        paramAnonymousView = Calendar.getInstance();
        int i = paramAnonymousView.get(1);
        int j = paramAnonymousView.get(2) + 1;
        int k = paramAnonymousView.get(5);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aO(i, j, k);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aP(i, j, k);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aQ(i + 200, 12, 31);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).setLongTermYear(true);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).Jjn = new b.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(70095);
            String str;
            if (paramAnonymous2Boolean)
            {
              ac.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "year: %s, month: %s, day: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
              if (paramAnonymous2Int1 != 1) {
                break label157;
              }
              str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(9999), Integer.valueOf(12), Integer.valueOf(31) });
              WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this, 9999);
              WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this, 12);
              WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this, 31);
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).azd(str);
            }
            for (;;)
            {
              WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).hide();
              AppMethodBeat.o(70095);
              return;
              label157:
              str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
              WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
              WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
              WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).azd(str);
            }
          }
        };
        paramAnonymousView = (String)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).BrY.getValue();
        if ((!bs.isNullOrNil(paramAnonymousView)) && (paramAnonymousView.length() >= 8))
        {
          i = bs.getInt(paramAnonymousView.substring(0, 4), 0);
          j = bs.getInt(paramAnonymousView.substring(5, 7), 0);
          k = bs.getInt(paramAnonymousView.substring(8, 10), 0);
          if ((i > 0) && (j > 0) && (k > 0))
          {
            if (i != 9999) {
              break label247;
            }
            WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aO(1, 1, 1);
          }
        }
        for (;;)
        {
          WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).show();
          AppMethodBeat.o(70096);
          return;
          label247:
          WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aO(i, j, k);
        }
      }
    });
    this.BqZ.getInfoIv().setClickable(false);
    this.Brd.setInputType(3);
    this.Brd.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(174491);
        paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
        String str = WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).getText();
        paramAnonymousEditable.Bsd.setValue(str);
        AppMethodBeat.o(174491);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Bra.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70098);
        paramAnonymousView = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this));
        paramAnonymousView.Jjt = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(174492);
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2Object1 = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
              int i = paramAnonymousView.fvY();
              paramAnonymous2Object1.BrZ.setValue(Integer.valueOf(i));
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174492);
          }
        };
        if (WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).BrZ.getValue() != null) {
          paramAnonymousView.adc(((Integer)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).BrZ.getValue()).intValue());
        }
        paramAnonymousView.show();
        AppMethodBeat.o(70098);
      }
    });
    this.Bra.getInfoIv().setClickable(false);
    this.Brc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70099);
        paramAnonymousView = new b(WcPayRealnameVerifyIdInputUI.this.getContext());
        Object localObject = Calendar.getInstance();
        int k = ((Calendar)localObject).get(1);
        int m = ((Calendar)localObject).get(2) + 1;
        int n = ((Calendar)localObject).get(5);
        paramAnonymousView.aO(k, m, n);
        int j = k - 200;
        int i = j;
        if (j <= 0) {
          i = 1;
        }
        paramAnonymousView.aP(i, 1, 1);
        paramAnonymousView.aQ(k, m, n);
        paramAnonymousView.Jjn = new b.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(174493);
            if (paramAnonymous2Boolean)
            {
              String str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
              WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
              WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
              WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).Bsa.setValue(str);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174493);
          }
        };
        localObject = (String)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).Bsa.getValue();
        if ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
        {
          i = bs.getInt(((String)localObject).substring(0, 4), 0);
          j = bs.getInt(((String)localObject).substring(5, 7), 0);
          k = bs.getInt(((String)localObject).substring(9, 10), 0);
          if ((i > 0) && (j > 0) && (k > 0)) {
            paramAnonymousView.aO(i, j, k);
          }
        }
        paramAnonymousView.show();
        AppMethodBeat.o(70099);
      }
    });
    this.Brc.getInfoIv().setClickable(false);
    this.Brb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70076);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WcPayRealnameVerifyIdInputUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        if (WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this) != null) {
          paramAnonymousView.putExtra("exclude_countries_iso", WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this));
        }
        paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
        paramAnonymousView.putExtra("ui_title", WcPayRealnameVerifyIdInputUI.this.getString(2131765859));
        WcPayRealnameVerifyIdInputUI.this.startActivityForResult(paramAnonymousView, 3);
        AppMethodBeat.o(70076);
      }
    });
    this.Brb.getInfoIv().setClickable(false);
    this.Bqi.getContentEt().setInputType(131073);
    this.Bqi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174477);
        WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
        WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this);
        AppMethodBeat.o(174477);
      }
    });
    this.Bqi.getInfoIv().setClickable(false);
    this.Bqj.getContentEt().setInputType(131073);
    this.Bqj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174478);
        WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
        if (WcPayRealnameVerifyIdInputUI.j(WcPayRealnameVerifyIdInputUI.this))
        {
          WcPayRealnameVerifyIdInputUI.k(WcPayRealnameVerifyIdInputUI.this);
          AppMethodBeat.o(174478);
          return;
        }
        WcPayRealnameVerifyIdInputUI.l(WcPayRealnameVerifyIdInputUI.this);
        AppMethodBeat.o(174478);
      }
    });
    this.Bqj.getInfoIv().setClickable(false);
    this.iXb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174479);
        WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
        WcPayRealnameVerifyIdInputUI.m(WcPayRealnameVerifyIdInputUI.this);
        AppMethodBeat.o(174479);
      }
    });
    this.wEW.fAY();
    this.Brl.BrP.observe(this, new Observer()
    {
      int irP = 0;
    });
    this.Brl.BrN.observe(this, new Observer() {});
    this.Brl.BrX.observe(this, new Observer() {});
    this.Brl.BrY.observe(this, new Observer() {});
    this.Brl.BrM.observe(this, new Observer() {});
    this.Brl.BrZ.observe(this, new Observer() {});
    this.Brl.Bsa.observe(this, new Observer() {});
    this.Brl.BrT.observe(this, new Observer() {});
    this.Brl.BrU.observe(this, new Observer() {});
    this.Brl.Bsc.observe(this, new Observer() {});
    this.Brl.BrV.observe(this, new Observer() {});
    this.Brl.BrW.observe(this, new Observer() {});
    if (this.Brp.size() > 0) {
      this.Brl.a((cmb)this.Brp.get(0));
    }
    for (;;)
    {
      e.a(new WalletFormView[] { this.wEW, this.BqW, this.BqX, this.Bqi, this.Bqj, this.BqY, this.BqZ, this.Bra, this.Brb, this.Brc, this.Brd, this.Bre });
      AppMethodBeat.o(70106);
      return;
      localObject = this.BqX.getLogicDelegate();
      if ((localObject instanceof a.a)) {
        ((a.a)localObject).adS(-1);
      }
    }
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70111);
    String str1;
    String str2;
    String str3;
    String str4;
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        str1 = paramIntent.getStringExtra("CountryName");
        str2 = paramIntent.getStringExtra("ProviceName");
        str3 = paramIntent.getStringExtra("CityName");
        str4 = paramIntent.getStringExtra("Country");
        String str5 = paramIntent.getStringExtra("Contact_Province");
        paramIntent = paramIntent.getStringExtra("Contact_City");
        StringBuilder localStringBuilder = new StringBuilder();
        if (!bs.isNullOrNil(str1))
        {
          localStringBuilder.append(str1);
          localStringBuilder.append(" ");
        }
        if (!bs.isNullOrNil(str2))
        {
          localStringBuilder.append(str2);
          localStringBuilder.append(" ");
        }
        if (!bs.isNullOrNil(str3)) {
          localStringBuilder.append(str3);
        }
        this.Brl.z(str4, str5, paramIntent, localStringBuilder.toString());
        AppMethodBeat.o(70111);
        return;
      }
      ac.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no area choose!");
      AppMethodBeat.o(70111);
      return;
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        paramIntent = (Profession)paramIntent.getParcelableExtra("key_select_profession");
        this.Brl.BrV.setValue(paramIntent);
        AppMethodBeat.o(70111);
        return;
      }
      ac.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no choose!");
      AppMethodBeat.o(70111);
      return;
    }
    if ((paramInt1 == 3) && (paramInt2 == 100))
    {
      if (!bs.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        str1 = paramIntent.getStringExtra("iso_code");
        str2 = paramIntent.getStringExtra("country_name");
        this.BrA = paramIntent.getStringExtra("couttry_code");
        paramIntent = this.Brl;
        paramIntent.Bsb.setValue(str1);
        paramIntent.Bsc.setValue(str2);
        AppMethodBeat.o(70111);
      }
    }
    else
    {
      if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.Bqw);
        str2 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.Bqx);
        str3 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.Bqy);
        str4 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.Bqz);
        paramIntent = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.BqA);
        this.Brl.z(str1, str2, str3, str4);
        this.Brl.BrU.setValue(paramIntent);
        AppMethodBeat.o(70111);
        return;
      }
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(70111);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70105);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131099653));
    hideActionbarLine();
    setMMTitle("");
    this.mNetSceneMgr.addSceneEndListener(1616);
    this.Brl = ((VM)ViewModelProviders.of(this).get(VM.class));
    paramBundle = getInput().getString("realname_verify_process_get_wording_cache");
    try
    {
      if (!bs.isNullOrNil(paramBundle))
      {
        paramBundle = (bcx)new bcx().parseFrom(paramBundle.getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.Brp.addAll(paramBundle.ETm);
        this.Bri = paramBundle.Bri;
        this.Brj = paramBundle.Brj;
      }
      initView();
      ac.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "do get user ext info");
      doSceneForceProgress(new l());
      AppMethodBeat.o(70105);
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WcPayRealnameVerifyIdInputUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70107);
    super.onDestroy();
    this.mNetSceneMgr.removeSceneEndListener(1616);
    AppMethodBeat.o(70107);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(70110);
    getInput().getInt("key_err_code");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(70110);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(70108);
    if ((paramn instanceof l))
    {
      paramString = (l)paramn;
      this.mProfessions = paramString.BsH;
      this.Bro = paramString.Bro;
    }
    while ((!(paramn instanceof g)) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(70108);
      return false;
    }
    paramString = (g)paramn;
    if (paramString.Bom == null) {
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70108);
      return true;
      ac.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify show juveniles dialog");
      h.d(this, paramString.Bom.dlQ, "", paramString.Bom.BzL, paramString.Bom.BzK, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(174487);
          ac.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lOk");
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramString);
          t.tn(1);
          AppMethodBeat.o(174487);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(174488);
          ac.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lCancel");
          t.tn(0);
          AppMethodBeat.o(174488);
        }
      });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class VM
    extends ViewModel
  {
    public MutableLiveData<String> BrL;
    public MutableLiveData<String> BrM;
    public MutableLiveData<cmb> BrN;
    public MutableLiveData<String> BrO;
    public MutableLiveData<Boolean> BrP;
    public MutableLiveData<String> BrQ;
    public MutableLiveData<String> BrR;
    public MutableLiveData<String> BrS;
    public MutableLiveData<String> BrT;
    public MutableLiveData<String> BrU;
    public MutableLiveData<Profession> BrV;
    public MutableLiveData<Boolean> BrW;
    public MutableLiveData<String> BrX;
    public MutableLiveData<String> BrY;
    public MutableLiveData<Integer> BrZ;
    public MutableLiveData<String> Bsa;
    public MutableLiveData<String> Bsb;
    public MutableLiveData<String> Bsc;
    public MutableLiveData<String> Bsd;
    
    public VM()
    {
      AppMethodBeat.i(70101);
      this.BrL = new MutableLiveData();
      this.BrM = new MutableLiveData();
      this.BrN = new MutableLiveData();
      this.BrO = new MutableLiveData();
      this.BrP = new MutableLiveData();
      this.BrQ = new MutableLiveData();
      this.BrR = new MutableLiveData();
      this.BrS = new MutableLiveData();
      this.BrT = new MutableLiveData();
      this.BrU = new MutableLiveData();
      this.BrV = new MutableLiveData();
      this.BrW = new MutableLiveData();
      this.BrX = new MutableLiveData();
      this.BrY = new MutableLiveData();
      this.BrZ = new MutableLiveData();
      this.Bsa = new MutableLiveData();
      this.Bsb = new MutableLiveData();
      this.Bsc = new MutableLiveData();
      this.Bsd = new MutableLiveData();
      this.BrZ.setValue(Integer.valueOf(0));
      Observer local1 = new Observer()
      {
        public final void onChanged(Object paramAnonymousObject)
        {
          AppMethodBeat.i(70100);
          if (WcPayRealnameVerifyIdInputUI.VM.a(WcPayRealnameVerifyIdInputUI.VM.this))
          {
            WcPayRealnameVerifyIdInputUI.VM.this.BrW.setValue(Boolean.TRUE);
            AppMethodBeat.o(70100);
            return;
          }
          WcPayRealnameVerifyIdInputUI.VM.this.BrW.setValue(Boolean.FALSE);
          AppMethodBeat.o(70100);
        }
      };
      this.BrL.observeForever(local1);
      this.BrO.observeForever(local1);
      this.BrV.observeForever(local1);
      this.BrQ.observeForever(local1);
      this.BrR.observeForever(local1);
      this.BrS.observeForever(local1);
      this.BrX.observeForever(local1);
      this.BrY.observeForever(local1);
      this.BrZ.observeForever(local1);
      this.Bsb.observeForever(local1);
      this.Bsc.observeForever(local1);
      this.Bsa.observeForever(local1);
      this.Bsd.observeForever(local1);
      this.BrM.observeForever(local1);
      AppMethodBeat.o(70101);
    }
    
    public final void a(cmb paramcmb)
    {
      AppMethodBeat.i(70102);
      this.BrN.setValue(paramcmb);
      AppMethodBeat.o(70102);
    }
    
    public final void azd(String paramString)
    {
      AppMethodBeat.i(207279);
      this.BrY.setValue(paramString);
      AppMethodBeat.o(207279);
    }
    
    public final void z(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(174494);
      this.BrQ.setValue(paramString1);
      this.BrR.setValue(paramString2);
      this.BrS.setValue(paramString3);
      this.BrT.setValue(paramString4);
      AppMethodBeat.o(174494);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI
 * JD-Core Version:    0.7.0.1
 */