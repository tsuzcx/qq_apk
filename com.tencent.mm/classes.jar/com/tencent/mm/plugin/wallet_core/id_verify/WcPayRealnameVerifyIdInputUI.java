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
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.l;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final int zYB;
  private Button iwY;
  private TextView kEu;
  private Profession[] mProfessions;
  private WalletFormView vuR;
  private WalletFormView zXO;
  private WalletFormView zXP;
  private WalletFormView zYC;
  private WalletFormView zYD;
  private WalletFormView zYE;
  private WalletFormView zYF;
  private WalletFormView zYG;
  private WalletFormView zYH;
  private WalletFormView zYI;
  private WalletFormView zYJ;
  private WalletFormView zYK;
  private c zYL;
  private TextView zYM;
  private b zYN;
  private String zYO;
  private String zYP;
  private boolean zYQ;
  private VM zYR;
  private String zYS;
  private String zYT;
  private String[] zYU;
  private List<cgy> zYV;
  private String[] zYW;
  private int zYX;
  private int zYY;
  private int zYZ;
  private int zZa;
  private int zZb;
  private int zZc;
  private int zZd;
  private int zZe;
  private int zZf;
  private String zZg;
  private TenpaySecureEncrypt zZh;
  
  static
  {
    AppMethodBeat.i(70117);
    zYB = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 88);
    AppMethodBeat.o(70117);
  }
  
  public WcPayRealnameVerifyIdInputUI()
  {
    AppMethodBeat.i(70104);
    this.zYV = new ArrayList();
    this.zYW = new String[100];
    int i = 0;
    while (i < this.zYW.length)
    {
      this.zYW[i] = aj.getContext().getString(2131765220, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    this.zYX = 0;
    this.zYY = 0;
    this.zYZ = 0;
    this.zZa = 0;
    this.zZb = 0;
    this.zZc = 0;
    this.zZd = 0;
    this.zZe = 0;
    this.zZf = 0;
    this.zZg = "";
    this.zZh = new TenpaySecureEncrypt();
    AppMethodBeat.o(70104);
  }
  
  private void a(g paramg)
  {
    AppMethodBeat.i(70109);
    d locald = getProcess();
    Bundle localBundle = getInput();
    String str = paramg.token;
    ad.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify response succ");
    if (locald != null)
    {
      localBundle.putString("key_real_name_token", str);
      localBundle.putString("key_country_code", (String)this.zYR.zZw.getValue());
      localBundle.putString("key_province_code", (String)this.zYR.zZx.getValue());
      localBundle.putString("key_city_code", (String)this.zYR.zZy.getValue());
      localBundle.putParcelable("key_profession", (Parcelable)this.zYR.zZB.getValue());
      localBundle.putBoolean("realname_verify_process_need_bind_card", paramg.zZX);
      localBundle.putBoolean("realname_verify_process_need_face", paramg.zZY);
      localBundle.putLong("realname_verify_process_face_scene", paramg.gri);
      localBundle.putString("realname_verify_process_face_package", paramg.packageExt);
      localBundle.putString("realname_verify_process_face_package_sign", paramg.dwg);
      localBundle.putString("realname_verify_process_add_bank_word", paramg.Aab);
      localBundle.putString("realname_verify_process_req_key", paramg.dlJ);
      paramg = new RealNameBundle();
      paramg.Aar = ((String)this.zYR.zZr.getValue());
      paramg.Aas = this.zYS;
      paramg.Aat = this.zYT;
      paramg.Aau = ((cgy)this.zYR.zZt.getValue()).Ecv.key;
      paramg.Aav = this.zYC.getText();
      paramg.Aaw = ((Profession)this.zYR.zZB.getValue());
      paramg.Aax = ((String)this.zYR.zZw.getValue());
      paramg.Aay = ((String)this.zYR.zZx.getValue());
      paramg.Aaz = ((String)this.zYR.zZy.getValue());
      paramg.AaA = ((String)this.zYR.zZz.getValue());
      paramg.AaB = ((Integer)this.zYR.zZF.getValue()).intValue();
      paramg.AaO = ((String)this.zYR.zZD.getValue());
      paramg.AaP = this.zYX;
      paramg.AaQ = this.zYY;
      paramg.AaR = this.zYZ;
      paramg.AaC = ((String)this.zYR.zZE.getValue());
      paramg.AaD = this.zZa;
      paramg.AaE = this.zZb;
      paramg.AaF = this.zZc;
      paramg.AaG = this.zYI.getText();
      paramg.AaH = this.zZd;
      paramg.AaI = this.zZe;
      paramg.AaJ = this.zZf;
      paramg.AaK = ((String)this.zYR.zZH.getValue());
      paramg.AaL = ((String)this.zYR.zZI.getValue());
      paramg.AaM = this.zZg;
      paramg.AaN = ((String)this.zYR.zZA.getValue());
      paramg.AaS = ((String)this.zYR.zZJ.getValue());
      if (!getString(2131763533).equals(this.zYR.zZs.getValue())) {
        break label640;
      }
    }
    label640:
    for (int i = 1;; i = 2)
    {
      paramg.evp = i;
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
    this.vuR = ((WalletFormView)findViewById(2131307081));
    this.zYK = ((WalletFormView)findViewById(2131307085));
    this.zYC = ((WalletFormView)findViewById(2131307079));
    this.zYD = ((WalletFormView)findViewById(2131307078));
    this.zYE = ((WalletFormView)findViewById(2131307077));
    this.zYF = ((WalletFormView)findViewById(2131307076));
    this.zYG = ((WalletFormView)findViewById(2131307075));
    this.zYH = ((WalletFormView)findViewById(2131307082));
    this.zYI = ((WalletFormView)findViewById(2131307074));
    this.zXO = ((WalletFormView)findViewById(2131307084));
    this.zXP = ((WalletFormView)findViewById(2131307073));
    this.zYJ = ((WalletFormView)findViewById(2131307080));
    this.iwY = ((Button)findViewById(2131307083));
    this.kEu = ((TextView)findViewById(2131307087));
    this.zYM = ((TextView)findViewById(2131307086));
    if (!bt.isNullOrNil(this.zYO)) {
      this.kEu.setText(this.zYO);
    }
    if (!bt.isNullOrNil(this.zYP))
    {
      this.zYM.setText(this.zYP);
      this.zYM.setVisibility(0);
    }
    this.vuR.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    int i = getResources().getDimensionPixelSize(2131165480);
    int j = getResources().getDimensionPixelSize(2131165274);
    Object localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).rightMargin = j;
    this.vuR.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.vuR.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.vuR.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.vuR.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(70075);
        paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
        String str = WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).getText();
        paramAnonymousEditable.zZr.setValue(str);
        AppMethodBeat.o(70075);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.zYC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70087);
        ad.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "click cre type");
        WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).zZv.setValue(Boolean.TRUE);
        AppMethodBeat.o(70087);
      }
    });
    this.zYC.getInfoIv().setClickable(false);
    this.zYC.getContentEt().setInputType(131073);
    this.zYD.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.zYD.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.zYD.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.zYD);
    this.zYD.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(70090);
        WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramAnonymousEditable.toString());
        WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this, WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).getText());
        paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
        String str = WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
        paramAnonymousEditable.zZu.setValue(str);
        AppMethodBeat.o(70090);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.zYK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70092);
        paramAnonymousView = WcPayRealnameVerifyIdInputUI.this.getResources().getStringArray(2130903102);
        paramAnonymousView = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), paramAnonymousView);
        paramAnonymousView.HIW = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(174489);
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2Object2 = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
              paramAnonymous2Object1 = (String)paramAnonymous2Object1;
              paramAnonymous2Object2.zZs.setValue(paramAnonymous2Object1);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174489);
          }
        };
        paramAnonymousView.show();
        AppMethodBeat.o(70092);
      }
    });
    this.zYE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70094);
        paramAnonymousView = new b(WcPayRealnameVerifyIdInputUI.this.getContext());
        Object localObject = Calendar.getInstance();
        int i = ((Calendar)localObject).get(1);
        int j = ((Calendar)localObject).get(2) + 1;
        int k = ((Calendar)localObject).get(5);
        paramAnonymousView.aO(i, j, k);
        paramAnonymousView.aN(1900, 1, 1);
        paramAnonymousView.HIQ = new b.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(174490);
            if (paramAnonymous2Boolean)
            {
              ad.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "year: %s, month: %s, day: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
              String str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
              WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
              WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).zZD.setValue(str);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174490);
          }
        };
        localObject = (String)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).zZD.getValue();
        if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
        {
          i = bt.getInt(((String)localObject).substring(0, 4), 0);
          j = bt.getInt(((String)localObject).substring(5, 7), 0);
          k = bt.getInt(((String)localObject).substring(9, 10), 0);
          if ((i > 0) && (j > 0) && (k > 0)) {
            paramAnonymousView.aM(i, j, k);
          }
        }
        for (;;)
        {
          paramAnonymousView.show();
          AppMethodBeat.o(70094);
          return;
          paramAnonymousView.aM(i, j, k);
        }
      }
    });
    this.zYE.getInfoIv().setClickable(false);
    this.zYF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70096);
        WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, new b(WcPayRealnameVerifyIdInputUI.this.getContext()));
        paramAnonymousView = Calendar.getInstance();
        int i = paramAnonymousView.get(1);
        int j = paramAnonymousView.get(2) + 1;
        int k = paramAnonymousView.get(5);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aM(i, j, k);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aN(i, j, k);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aO(i + 200, 12, 31);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).setLongTermYear(true);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).HIQ = new b.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(70095);
            String str;
            if (paramAnonymous2Boolean)
            {
              ad.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "year: %s, month: %s, day: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
              if (paramAnonymous2Int1 != 1) {
                break label157;
              }
              str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(9999), Integer.valueOf(12), Integer.valueOf(31) });
              WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this, 9999);
              WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this, 12);
              WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this, 31);
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).atL(str);
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
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).atL(str);
            }
          }
        };
        paramAnonymousView = (String)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).zZE.getValue();
        if ((!bt.isNullOrNil(paramAnonymousView)) && (paramAnonymousView.length() >= 8))
        {
          i = bt.getInt(paramAnonymousView.substring(0, 4), 0);
          j = bt.getInt(paramAnonymousView.substring(5, 7), 0);
          k = bt.getInt(paramAnonymousView.substring(8, 10), 0);
          if ((i > 0) && (j > 0) && (k > 0))
          {
            if (i != 9999) {
              break label247;
            }
            WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aM(1, 1, 1);
          }
        }
        for (;;)
        {
          WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).show();
          AppMethodBeat.o(70096);
          return;
          label247:
          WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aM(i, j, k);
        }
      }
    });
    this.zYF.getInfoIv().setClickable(false);
    this.zYJ.setInputType(3);
    this.zYJ.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(174491);
        paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
        String str = WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).getText();
        paramAnonymousEditable.zZJ.setValue(str);
        AppMethodBeat.o(174491);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.zYG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70098);
        paramAnonymousView = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this));
        paramAnonymousView.HIW = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(174492);
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2Object1 = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
              int i = paramAnonymousView.ffZ();
              paramAnonymous2Object1.zZF.setValue(Integer.valueOf(i));
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174492);
          }
        };
        if (WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).zZF.getValue() != null) {
          paramAnonymousView.aaR(((Integer)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).zZF.getValue()).intValue());
        }
        paramAnonymousView.show();
        AppMethodBeat.o(70098);
      }
    });
    this.zYG.getInfoIv().setClickable(false);
    this.zYI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70099);
        paramAnonymousView = new b(WcPayRealnameVerifyIdInputUI.this.getContext());
        Object localObject = Calendar.getInstance();
        int k = ((Calendar)localObject).get(1);
        int m = ((Calendar)localObject).get(2) + 1;
        int n = ((Calendar)localObject).get(5);
        paramAnonymousView.aM(k, m, n);
        int j = k - 200;
        int i = j;
        if (j <= 0) {
          i = 1;
        }
        paramAnonymousView.aN(i, 1, 1);
        paramAnonymousView.aO(k, m, n);
        paramAnonymousView.HIQ = new b.a()
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
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).zZG.setValue(str);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174493);
          }
        };
        localObject = (String)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).zZG.getValue();
        if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
        {
          i = bt.getInt(((String)localObject).substring(0, 4), 0);
          j = bt.getInt(((String)localObject).substring(5, 7), 0);
          k = bt.getInt(((String)localObject).substring(9, 10), 0);
          if ((i > 0) && (j > 0) && (k > 0)) {
            paramAnonymousView.aM(i, j, k);
          }
        }
        paramAnonymousView.show();
        AppMethodBeat.o(70099);
      }
    });
    this.zYI.getInfoIv().setClickable(false);
    this.zYH.setOnClickListener(new View.OnClickListener()
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
    this.zYH.getInfoIv().setClickable(false);
    this.zXO.getContentEt().setInputType(131073);
    this.zXO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174477);
        WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
        WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this);
        AppMethodBeat.o(174477);
      }
    });
    this.zXO.getInfoIv().setClickable(false);
    this.zXP.getContentEt().setInputType(131073);
    this.zXP.setOnClickListener(new View.OnClickListener()
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
    this.zXP.getInfoIv().setClickable(false);
    this.iwY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174479);
        WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
        WcPayRealnameVerifyIdInputUI.m(WcPayRealnameVerifyIdInputUI.this);
        AppMethodBeat.o(174479);
      }
    });
    this.vuR.fkI();
    this.zYR.zZv.observe(this, new Observer()
    {
      int hRK = 0;
    });
    this.zYR.zZt.observe(this, new Observer() {});
    this.zYR.zZD.observe(this, new Observer() {});
    this.zYR.zZE.observe(this, new Observer() {});
    this.zYR.zZs.observe(this, new Observer() {});
    this.zYR.zZF.observe(this, new Observer() {});
    this.zYR.zZG.observe(this, new Observer() {});
    this.zYR.zZz.observe(this, new Observer() {});
    this.zYR.zZA.observe(this, new Observer() {});
    this.zYR.zZI.observe(this, new Observer() {});
    this.zYR.zZB.observe(this, new Observer() {});
    this.zYR.zZC.observe(this, new Observer() {});
    if (this.zYV.size() > 0) {
      this.zYR.a((cgy)this.zYV.get(0));
    }
    for (;;)
    {
      e.a(new WalletFormView[] { this.vuR, this.zYC, this.zYD, this.zXO, this.zXP, this.zYE, this.zYF, this.zYG, this.zYH, this.zYI, this.zYJ, this.zYK });
      AppMethodBeat.o(70106);
      return;
      localObject = this.zYD.getLogicDelegate();
      if ((localObject instanceof a.a)) {
        ((a.a)localObject).abz(-1);
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
        if (!bt.isNullOrNil(str1))
        {
          localStringBuilder.append(str1);
          localStringBuilder.append(" ");
        }
        if (!bt.isNullOrNil(str2))
        {
          localStringBuilder.append(str2);
          localStringBuilder.append(" ");
        }
        if (!bt.isNullOrNil(str3)) {
          localStringBuilder.append(str3);
        }
        this.zYR.x(str4, str5, paramIntent, localStringBuilder.toString());
        AppMethodBeat.o(70111);
        return;
      }
      ad.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no area choose!");
      AppMethodBeat.o(70111);
      return;
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        paramIntent = (Profession)paramIntent.getParcelableExtra("key_select_profession");
        this.zYR.zZB.setValue(paramIntent);
        AppMethodBeat.o(70111);
        return;
      }
      ad.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no choose!");
      AppMethodBeat.o(70111);
      return;
    }
    if ((paramInt1 == 3) && (paramInt2 == 100))
    {
      if (!bt.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        str1 = paramIntent.getStringExtra("iso_code");
        str2 = paramIntent.getStringExtra("country_name");
        this.zZg = paramIntent.getStringExtra("couttry_code");
        paramIntent = this.zYR;
        paramIntent.zZH.setValue(str1);
        paramIntent.zZI.setValue(str2);
        AppMethodBeat.o(70111);
      }
    }
    else
    {
      if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.zYc);
        str2 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.zYd);
        str3 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.zYe);
        str4 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.zYf);
        paramIntent = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.zYg);
        this.zYR.x(str1, str2, str3, str4);
        this.zYR.zZA.setValue(paramIntent);
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
    this.zYR = ((VM)ViewModelProviders.of(this).get(VM.class));
    paramBundle = getInput().getString("realname_verify_process_get_wording_cache");
    try
    {
      if (!bt.isNullOrNil(paramBundle))
      {
        paramBundle = (azf)new azf().parseFrom(paramBundle.getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.zYV.addAll(paramBundle.DxQ);
        this.zYO = paramBundle.zYO;
        this.zYP = paramBundle.zYP;
      }
      initView();
      ad.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "do get user ext info");
      doSceneForceProgress(new l());
      AppMethodBeat.o(70105);
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WcPayRealnameVerifyIdInputUI", paramBundle, "", new Object[0]);
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
      this.mProfessions = paramString.Aan;
      this.zYU = paramString.zYU;
    }
    while ((!(paramn instanceof g)) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(70108);
      return false;
    }
    paramString = (g)paramn;
    if (paramString.zVS == null) {
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70108);
      return true;
      ad.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify show juveniles dialog");
      h.d(this, paramString.zVS.doh, "", paramString.zVS.Ahr, paramString.zVS.Ahq, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(174487);
          ad.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lOk");
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramString);
          t.sw(1);
          AppMethodBeat.o(174487);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(174488);
          ad.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lCancel");
          t.sw(0);
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
    public MutableLiveData<String> zZA;
    public MutableLiveData<Profession> zZB;
    public MutableLiveData<Boolean> zZC;
    public MutableLiveData<String> zZD;
    public MutableLiveData<String> zZE;
    public MutableLiveData<Integer> zZF;
    public MutableLiveData<String> zZG;
    public MutableLiveData<String> zZH;
    public MutableLiveData<String> zZI;
    public MutableLiveData<String> zZJ;
    public MutableLiveData<String> zZr;
    public MutableLiveData<String> zZs;
    public MutableLiveData<cgy> zZt;
    public MutableLiveData<String> zZu;
    public MutableLiveData<Boolean> zZv;
    public MutableLiveData<String> zZw;
    public MutableLiveData<String> zZx;
    public MutableLiveData<String> zZy;
    public MutableLiveData<String> zZz;
    
    public VM()
    {
      AppMethodBeat.i(70101);
      this.zZr = new MutableLiveData();
      this.zZs = new MutableLiveData();
      this.zZt = new MutableLiveData();
      this.zZu = new MutableLiveData();
      this.zZv = new MutableLiveData();
      this.zZw = new MutableLiveData();
      this.zZx = new MutableLiveData();
      this.zZy = new MutableLiveData();
      this.zZz = new MutableLiveData();
      this.zZA = new MutableLiveData();
      this.zZB = new MutableLiveData();
      this.zZC = new MutableLiveData();
      this.zZD = new MutableLiveData();
      this.zZE = new MutableLiveData();
      this.zZF = new MutableLiveData();
      this.zZG = new MutableLiveData();
      this.zZH = new MutableLiveData();
      this.zZI = new MutableLiveData();
      this.zZJ = new MutableLiveData();
      this.zZF.setValue(Integer.valueOf(0));
      Observer local1 = new Observer()
      {
        public final void onChanged(Object paramAnonymousObject)
        {
          AppMethodBeat.i(70100);
          if (WcPayRealnameVerifyIdInputUI.VM.a(WcPayRealnameVerifyIdInputUI.VM.this))
          {
            WcPayRealnameVerifyIdInputUI.VM.this.zZC.setValue(Boolean.TRUE);
            AppMethodBeat.o(70100);
            return;
          }
          WcPayRealnameVerifyIdInputUI.VM.this.zZC.setValue(Boolean.FALSE);
          AppMethodBeat.o(70100);
        }
      };
      this.zZr.observeForever(local1);
      this.zZu.observeForever(local1);
      this.zZB.observeForever(local1);
      this.zZw.observeForever(local1);
      this.zZx.observeForever(local1);
      this.zZy.observeForever(local1);
      this.zZD.observeForever(local1);
      this.zZE.observeForever(local1);
      this.zZF.observeForever(local1);
      this.zZH.observeForever(local1);
      this.zZI.observeForever(local1);
      this.zZG.observeForever(local1);
      this.zZJ.observeForever(local1);
      this.zZs.observeForever(local1);
      AppMethodBeat.o(70101);
    }
    
    public final void a(cgy paramcgy)
    {
      AppMethodBeat.i(70102);
      this.zZt.setValue(paramcgy);
      AppMethodBeat.o(70102);
    }
    
    public final void atL(String paramString)
    {
      AppMethodBeat.i(187158);
      this.zZE.setValue(paramString);
      AppMethodBeat.o(187158);
    }
    
    public final void x(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(174494);
      this.zZw.setValue(paramString1);
      this.zZx.setValue(paramString2);
      this.zZy.setValue(paramString3);
      this.zZz.setValue(paramString4);
      AppMethodBeat.o(174494);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI
 * JD-Core Version:    0.7.0.1
 */