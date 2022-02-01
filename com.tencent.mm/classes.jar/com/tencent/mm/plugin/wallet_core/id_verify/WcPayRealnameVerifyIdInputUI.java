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
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.crb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
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
  private static final int CRk;
  private WalletFormView CQx;
  private WalletFormView CQy;
  private VM CRA;
  private String CRB;
  private String CRC;
  private String[] CRD;
  private List<crb> CRE;
  private String[] CRF;
  private int CRG;
  private int CRH;
  private int CRI;
  private int CRJ;
  private int CRK;
  private int CRL;
  private int CRM;
  private int CRN;
  private int CRO;
  private String CRP;
  private TenpaySecureEncrypt CRQ;
  private WalletFormView CRl;
  private WalletFormView CRm;
  private WalletFormView CRn;
  private WalletFormView CRo;
  private WalletFormView CRp;
  private WalletFormView CRq;
  private WalletFormView CRr;
  private WalletFormView CRs;
  private WalletFormView CRt;
  private c CRu;
  private TextView CRv;
  private com.tencent.mm.ui.widget.picker.b CRw;
  private String CRx;
  private String CRy;
  private boolean CRz;
  private Button jqk;
  private TextView lCL;
  private Profession[] mProfessions;
  private WalletFormView xSD;
  
  static
  {
    AppMethodBeat.i(70117);
    CRk = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 88);
    AppMethodBeat.o(70117);
  }
  
  public WcPayRealnameVerifyIdInputUI()
  {
    AppMethodBeat.i(70104);
    this.CRE = new ArrayList();
    this.CRF = new String[100];
    int i = 0;
    while (i < this.CRF.length)
    {
      this.CRF[i] = aj.getContext().getString(2131765220, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    this.CRG = 0;
    this.CRH = 0;
    this.CRI = 0;
    this.CRJ = 0;
    this.CRK = 0;
    this.CRL = 0;
    this.CRM = 0;
    this.CRN = 0;
    this.CRO = 0;
    this.CRP = "";
    this.CRQ = new TenpaySecureEncrypt();
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
      localBundle.putString("key_country_code", (String)this.CRA.CSf.getValue());
      localBundle.putString("key_province_code", (String)this.CRA.CSg.getValue());
      localBundle.putString("key_city_code", (String)this.CRA.CSh.getValue());
      localBundle.putParcelable("key_profession", (Parcelable)this.CRA.CSk.getValue());
      localBundle.putBoolean("realname_verify_process_need_bind_card", paramg.CSG);
      localBundle.putBoolean("realname_verify_process_need_face", paramg.CSH);
      localBundle.putLong("realname_verify_process_face_scene", paramg.hki);
      localBundle.putString("realname_verify_process_face_package", paramg.packageExt);
      localBundle.putString("realname_verify_process_face_package_sign", paramg.dFT);
      localBundle.putString("realname_verify_process_add_bank_word", paramg.CSK);
      localBundle.putString("realname_verify_process_req_key", paramg.dve);
      paramg = new RealNameBundle();
      paramg.CTa = ((String)this.CRA.CSa.getValue());
      paramg.CTb = this.CRB;
      paramg.CTc = this.CRC;
      paramg.CTd = ((crb)this.CRA.CSc.getValue()).Hjv.key;
      paramg.CTe = this.CRl.getText();
      paramg.CTf = ((Profession)this.CRA.CSk.getValue());
      paramg.CTg = ((String)this.CRA.CSf.getValue());
      paramg.CTh = ((String)this.CRA.CSg.getValue());
      paramg.CTi = ((String)this.CRA.CSh.getValue());
      paramg.CTj = ((String)this.CRA.CSi.getValue());
      paramg.CTk = ((Integer)this.CRA.CSo.getValue()).intValue();
      paramg.CTx = ((String)this.CRA.CSm.getValue());
      paramg.CTy = this.CRG;
      paramg.CTz = this.CRH;
      paramg.CTA = this.CRI;
      paramg.CTl = ((String)this.CRA.CSn.getValue());
      paramg.CTm = this.CRJ;
      paramg.CTn = this.CRK;
      paramg.CTo = this.CRL;
      paramg.CTp = this.CRr.getText();
      paramg.CTq = this.CRM;
      paramg.CTr = this.CRN;
      paramg.CTs = this.CRO;
      paramg.CTt = ((String)this.CRA.CSq.getValue());
      paramg.CTu = ((String)this.CRA.CSr.getValue());
      paramg.CTv = this.CRP;
      paramg.CTw = ((String)this.CRA.CSj.getValue());
      paramg.CTB = ((String)this.CRA.CSs.getValue());
      if (!getString(2131763533).equals(this.CRA.CSb.getValue())) {
        break label640;
      }
    }
    label640:
    for (int i = 1;; i = 2)
    {
      paramg.ePk = i;
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
    this.xSD = ((WalletFormView)findViewById(2131307081));
    this.CRt = ((WalletFormView)findViewById(2131307085));
    this.CRl = ((WalletFormView)findViewById(2131307079));
    this.CRm = ((WalletFormView)findViewById(2131307078));
    this.CRn = ((WalletFormView)findViewById(2131307077));
    this.CRo = ((WalletFormView)findViewById(2131307076));
    this.CRp = ((WalletFormView)findViewById(2131307075));
    this.CRq = ((WalletFormView)findViewById(2131307082));
    this.CRr = ((WalletFormView)findViewById(2131307074));
    this.CQx = ((WalletFormView)findViewById(2131307084));
    this.CQy = ((WalletFormView)findViewById(2131307073));
    this.CRs = ((WalletFormView)findViewById(2131307080));
    this.jqk = ((Button)findViewById(2131307083));
    this.lCL = ((TextView)findViewById(2131307087));
    this.CRv = ((TextView)findViewById(2131307086));
    if (!bt.isNullOrNil(this.CRx)) {
      this.lCL.setText(this.CRx);
    }
    if (!bt.isNullOrNil(this.CRy))
    {
      this.CRv.setText(this.CRy);
      this.CRv.setVisibility(0);
    }
    this.xSD.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    int i = getResources().getDimensionPixelSize(2131165480);
    int j = getResources().getDimensionPixelSize(2131165274);
    Object localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).rightMargin = j;
    this.xSD.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.xSD.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.xSD.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.xSD.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(70075);
        paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
        String str = WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).getText();
        paramAnonymousEditable.CSa.setValue(str);
        AppMethodBeat.o(70075);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.CRl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70087);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "click cre type");
        WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).CSe.setValue(Boolean.TRUE);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70087);
      }
    });
    this.CRl.getInfoIv().setClickable(false);
    this.CRl.getContentEt().setInputType(131073);
    this.CRm.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.CRm.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.CRm.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.CRm);
    this.CRm.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(70090);
        WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramAnonymousEditable.toString());
        WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this, WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).getText());
        paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
        String str = WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
        paramAnonymousEditable.CSd.setValue(str);
        AppMethodBeat.o(70090);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.CRt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70092);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = WcPayRealnameVerifyIdInputUI.this.getResources().getStringArray(2130903102);
        paramAnonymousView = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), paramAnonymousView);
        paramAnonymousView.LaQ = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(174489);
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2Object2 = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
              paramAnonymous2Object1 = (String)paramAnonymous2Object1;
              paramAnonymous2Object2.CSb.setValue(paramAnonymous2Object1);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174489);
          }
        };
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70092);
      }
    });
    this.CRn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70094);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext());
        localObject = Calendar.getInstance();
        int i = ((Calendar)localObject).get(1);
        int j = ((Calendar)localObject).get(2) + 1;
        int k = ((Calendar)localObject).get(5);
        paramAnonymousView.aR(i, j, k);
        paramAnonymousView.aQ(1900, 1, 1);
        paramAnonymousView.LaK = new b.a()
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
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).CSm.setValue(str);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174490);
          }
        };
        localObject = (String)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).CSm.getValue();
        if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
        {
          i = bt.getInt(((String)localObject).substring(0, 4), 0);
          j = bt.getInt(((String)localObject).substring(5, 7), 0);
          k = bt.getInt(((String)localObject).substring(9, 10), 0);
          if ((i > 0) && (j > 0) && (k > 0)) {
            paramAnonymousView.aP(i, j, k);
          }
        }
        for (;;)
        {
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70094);
          return;
          paramAnonymousView.aP(i, j, k);
        }
      }
    });
    this.CRn.getInfoIv().setClickable(false);
    this.CRo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70096);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext()));
        paramAnonymousView = Calendar.getInstance();
        int i = paramAnonymousView.get(1);
        int j = paramAnonymousView.get(2) + 1;
        int k = paramAnonymousView.get(5);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aP(i, j, k);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aQ(i, j, k);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aR(i + 200, 12, 31);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).setLongTermYear(true);
        WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).LaK = new b.a()
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
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).aEl(str);
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
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).aEl(str);
            }
          }
        };
        paramAnonymousView = (String)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).CSn.getValue();
        if ((!bt.isNullOrNil(paramAnonymousView)) && (paramAnonymousView.length() >= 8))
        {
          i = bt.getInt(paramAnonymousView.substring(0, 4), 0);
          j = bt.getInt(paramAnonymousView.substring(5, 7), 0);
          k = bt.getInt(paramAnonymousView.substring(8, 10), 0);
          if ((i > 0) && (j > 0) && (k > 0))
          {
            if (i != 9999) {
              break label291;
            }
            WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aP(1, 1, 1);
          }
        }
        for (;;)
        {
          WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70096);
          return;
          label291:
          WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).aP(i, j, k);
        }
      }
    });
    this.CRo.getInfoIv().setClickable(false);
    this.CRs.setInputType(3);
    this.CRs.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(174491);
        paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
        String str = WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).getText();
        paramAnonymousEditable.CSs.setValue(str);
        AppMethodBeat.o(174491);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.CRp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70098);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this));
        paramAnonymousView.LaQ = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(174492);
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2Object1 = WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this);
              int i = paramAnonymousView.fMM();
              paramAnonymous2Object1.CSo.setValue(Integer.valueOf(i));
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174492);
          }
        };
        if (WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).CSo.getValue() != null) {
          paramAnonymousView.afD(((Integer)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).CSo.getValue()).intValue());
        }
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70098);
      }
    });
    this.CRp.getInfoIv().setClickable(false);
    this.CRr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70099);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext());
        localObject = Calendar.getInstance();
        int k = ((Calendar)localObject).get(1);
        int m = ((Calendar)localObject).get(2) + 1;
        int n = ((Calendar)localObject).get(5);
        paramAnonymousView.aP(k, m, n);
        int j = k - 200;
        int i = j;
        if (j <= 0) {
          i = 1;
        }
        paramAnonymousView.aQ(i, 1, 1);
        paramAnonymousView.aR(k, m, n);
        paramAnonymousView.LaK = new b.a()
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
              WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).CSp.setValue(str);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174493);
          }
        };
        localObject = (String)WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).CSp.getValue();
        if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
        {
          i = bt.getInt(((String)localObject).substring(0, 4), 0);
          j = bt.getInt(((String)localObject).substring(5, 7), 0);
          k = bt.getInt(((String)localObject).substring(9, 10), 0);
          if ((i > 0) && (j > 0) && (k > 0)) {
            paramAnonymousView.aP(i, j, k);
          }
        }
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70099);
      }
    });
    this.CRr.getInfoIv().setClickable(false);
    this.CRq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70076);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WcPayRealnameVerifyIdInputUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        if (WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this) != null) {
          paramAnonymousView.putExtra("exclude_countries_iso", WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this));
        }
        paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
        paramAnonymousView.putExtra("ui_title", WcPayRealnameVerifyIdInputUI.this.getString(2131765859));
        WcPayRealnameVerifyIdInputUI.this.startActivityForResult(paramAnonymousView, 3);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70076);
      }
    });
    this.CRq.getInfoIv().setClickable(false);
    this.CQx.getContentEt().setInputType(131073);
    this.CQx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174477);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
        WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174477);
      }
    });
    this.CQx.getInfoIv().setClickable(false);
    this.CQy.getContentEt().setInputType(131073);
    this.CQy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174478);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
        if (WcPayRealnameVerifyIdInputUI.j(WcPayRealnameVerifyIdInputUI.this)) {
          WcPayRealnameVerifyIdInputUI.k(WcPayRealnameVerifyIdInputUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174478);
          return;
          WcPayRealnameVerifyIdInputUI.l(WcPayRealnameVerifyIdInputUI.this);
        }
      }
    });
    this.CQy.getInfoIv().setClickable(false);
    this.jqk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174479);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
        WcPayRealnameVerifyIdInputUI.m(WcPayRealnameVerifyIdInputUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174479);
      }
    });
    this.xSD.fSi();
    this.CRA.CSe.observe(this, new Observer()
    {
      int iKS = 0;
    });
    this.CRA.CSc.observe(this, new Observer() {});
    this.CRA.CSm.observe(this, new Observer() {});
    this.CRA.CSn.observe(this, new Observer() {});
    this.CRA.CSb.observe(this, new Observer() {});
    this.CRA.CSo.observe(this, new Observer() {});
    this.CRA.CSp.observe(this, new Observer() {});
    this.CRA.CSi.observe(this, new Observer() {});
    this.CRA.CSj.observe(this, new Observer() {});
    this.CRA.CSr.observe(this, new Observer() {});
    this.CRA.CSk.observe(this, new Observer() {});
    this.CRA.CSl.observe(this, new Observer() {});
    if (this.CRE.size() > 0) {
      this.CRA.a((crb)this.CRE.get(0));
    }
    for (;;)
    {
      e.a(new WalletFormView[] { this.xSD, this.CRl, this.CRm, this.CQx, this.CQy, this.CRn, this.CRo, this.CRp, this.CRq, this.CRr, this.CRs, this.CRt });
      AppMethodBeat.o(70106);
      return;
      localObject = this.CRm.getLogicDelegate();
      if ((localObject instanceof a.a)) {
        ((a.a)localObject).ags(-1);
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
        this.CRA.A(str4, str5, paramIntent, localStringBuilder.toString());
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
        this.CRA.CSk.setValue(paramIntent);
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
        this.CRP = paramIntent.getStringExtra("couttry_code");
        paramIntent = this.CRA;
        paramIntent.CSq.setValue(str1);
        paramIntent.CSr.setValue(str2);
        AppMethodBeat.o(70111);
      }
    }
    else
    {
      if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.CQL);
        str2 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.CQM);
        str3 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.CQN);
        str4 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.CQO);
        paramIntent = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.CQP);
        this.CRA.A(str1, str2, str3, str4);
        this.CRA.CSj.setValue(paramIntent);
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
    this.CRA = ((VM)ViewModelProviders.of(this).get(VM.class));
    paramBundle = getInput().getString("realname_verify_process_get_wording_cache");
    try
    {
      if (!bt.isNullOrNil(paramBundle))
      {
        paramBundle = (bhd)new bhd().parseFrom(paramBundle.getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.CRE.addAll(paramBundle.GCF);
        this.CRx = paramBundle.CRx;
        this.CRy = paramBundle.CRy;
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
      this.mProfessions = paramString.CSW;
      this.CRD = paramString.CRD;
    }
    while ((!(paramn instanceof g)) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(70108);
      return false;
    }
    paramString = (g)paramn;
    if (paramString.COB == null) {
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70108);
      return true;
      ad.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify show juveniles dialog");
      h.e(this, paramString.COB.dxD, "", paramString.COB.Dae, paramString.COB.Dad, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(174487);
          ad.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lOk");
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramString);
          u.tQ(1);
          AppMethodBeat.o(174487);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(174488);
          ad.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lCancel");
          u.tQ(0);
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
    public MutableLiveData<String> CSa;
    public MutableLiveData<String> CSb;
    public MutableLiveData<crb> CSc;
    public MutableLiveData<String> CSd;
    public MutableLiveData<Boolean> CSe;
    public MutableLiveData<String> CSf;
    public MutableLiveData<String> CSg;
    public MutableLiveData<String> CSh;
    public MutableLiveData<String> CSi;
    public MutableLiveData<String> CSj;
    public MutableLiveData<Profession> CSk;
    public MutableLiveData<Boolean> CSl;
    public MutableLiveData<String> CSm;
    public MutableLiveData<String> CSn;
    public MutableLiveData<Integer> CSo;
    public MutableLiveData<String> CSp;
    public MutableLiveData<String> CSq;
    public MutableLiveData<String> CSr;
    public MutableLiveData<String> CSs;
    
    public VM()
    {
      AppMethodBeat.i(70101);
      this.CSa = new MutableLiveData();
      this.CSb = new MutableLiveData();
      this.CSc = new MutableLiveData();
      this.CSd = new MutableLiveData();
      this.CSe = new MutableLiveData();
      this.CSf = new MutableLiveData();
      this.CSg = new MutableLiveData();
      this.CSh = new MutableLiveData();
      this.CSi = new MutableLiveData();
      this.CSj = new MutableLiveData();
      this.CSk = new MutableLiveData();
      this.CSl = new MutableLiveData();
      this.CSm = new MutableLiveData();
      this.CSn = new MutableLiveData();
      this.CSo = new MutableLiveData();
      this.CSp = new MutableLiveData();
      this.CSq = new MutableLiveData();
      this.CSr = new MutableLiveData();
      this.CSs = new MutableLiveData();
      this.CSo.setValue(Integer.valueOf(0));
      Observer local1 = new Observer()
      {
        public final void onChanged(Object paramAnonymousObject)
        {
          AppMethodBeat.i(70100);
          if (WcPayRealnameVerifyIdInputUI.VM.a(WcPayRealnameVerifyIdInputUI.VM.this))
          {
            WcPayRealnameVerifyIdInputUI.VM.this.CSl.setValue(Boolean.TRUE);
            AppMethodBeat.o(70100);
            return;
          }
          WcPayRealnameVerifyIdInputUI.VM.this.CSl.setValue(Boolean.FALSE);
          AppMethodBeat.o(70100);
        }
      };
      this.CSa.observeForever(local1);
      this.CSd.observeForever(local1);
      this.CSk.observeForever(local1);
      this.CSf.observeForever(local1);
      this.CSg.observeForever(local1);
      this.CSh.observeForever(local1);
      this.CSm.observeForever(local1);
      this.CSn.observeForever(local1);
      this.CSo.observeForever(local1);
      this.CSq.observeForever(local1);
      this.CSr.observeForever(local1);
      this.CSp.observeForever(local1);
      this.CSs.observeForever(local1);
      this.CSb.observeForever(local1);
      AppMethodBeat.o(70101);
    }
    
    public final void A(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(174494);
      this.CSf.setValue(paramString1);
      this.CSg.setValue(paramString2);
      this.CSh.setValue(paramString3);
      this.CSi.setValue(paramString4);
      AppMethodBeat.o(174494);
    }
    
    public final void a(crb paramcrb)
    {
      AppMethodBeat.i(70102);
      this.CSc.setValue(paramcrb);
      AppMethodBeat.o(70102);
    }
    
    public final void aEl(String paramString)
    {
      AppMethodBeat.i(199307);
      this.CSn.setValue(paramString);
      AppMethodBeat.o(199307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI
 * JD-Core Version:    0.7.0.1
 */