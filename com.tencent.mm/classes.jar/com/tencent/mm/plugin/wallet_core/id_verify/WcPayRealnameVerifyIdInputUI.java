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
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.l;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.ebx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.b;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tenpay.android.wechat.TenpaySecureEncrypt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WcPayRealnameVerifyIdInputUI
  extends WalletBaseUI
{
  private static final int HSh;
  private WalletFormView Cjx;
  private WalletFormView HRu;
  private WalletFormView HRv;
  private String[] HSA;
  private List<djv> HSB;
  private ebx HSC;
  private String[] HSD;
  private int HSE;
  private int HSF;
  private int HSG;
  private int HSH;
  private int HSI;
  private int HSJ;
  private int HSK;
  private int HSL;
  private int HSM;
  private String HSN;
  private TenpaySecureEncrypt HSO;
  private WalletFormView HSi;
  private WalletFormView HSj;
  private WalletFormView HSk;
  private WalletFormView HSl;
  private WalletFormView HSm;
  private WalletFormView HSn;
  private WalletFormView HSo;
  private WalletFormView HSp;
  private WalletFormView HSq;
  private c HSr;
  private TextView HSs;
  private com.tencent.mm.ui.widget.picker.b HSt;
  private String HSu;
  private String HSv;
  private boolean HSw;
  private VM HSx;
  private String HSy;
  private String HSz;
  private Button krs;
  private TextView mPa;
  private Profession[] mProfessions;
  
  static
  {
    AppMethodBeat.i(70117);
    HSh = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 88);
    AppMethodBeat.o(70117);
  }
  
  public WcPayRealnameVerifyIdInputUI()
  {
    AppMethodBeat.i(70104);
    this.HSB = new ArrayList();
    this.HSD = new String[100];
    int i = 0;
    while (i < this.HSD.length)
    {
      this.HSD[i] = MMApplicationContext.getContext().getString(2131767663, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    this.HSE = 0;
    this.HSF = 0;
    this.HSG = 0;
    this.HSH = 0;
    this.HSI = 0;
    this.HSJ = 0;
    this.HSK = 0;
    this.HSL = 0;
    this.HSM = 0;
    this.HSN = "";
    this.HSO = new TenpaySecureEncrypt();
    AppMethodBeat.o(70104);
  }
  
  private void a(com.tencent.mm.plugin.wallet_core.id_verify.model.g paramg)
  {
    AppMethodBeat.i(70109);
    d locald = getProcess();
    Bundle localBundle = getInput();
    String str = paramg.token;
    Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify response succ");
    if (locald != null)
    {
      localBundle.putString("key_real_name_token", str);
      localBundle.putString("key_country_code", (String)this.HSx.HTe.getValue());
      localBundle.putString("key_province_code", (String)this.HSx.HTf.getValue());
      localBundle.putString("key_city_code", (String)this.HSx.HTg.getValue());
      localBundle.putParcelable("key_profession", (Parcelable)this.HSx.HTj.getValue());
      localBundle.putBoolean("realname_verify_process_need_bind_card", paramg.HTF);
      localBundle.putBoolean("realname_verify_process_need_face", paramg.HTG);
      localBundle.putLong("realname_verify_process_face_scene", paramg.igp);
      localBundle.putString("realname_verify_process_face_package", paramg.packageExt);
      localBundle.putString("realname_verify_process_face_package_sign", paramg.dYK);
      localBundle.putString("realname_verify_process_add_bank_word", paramg.HTJ);
      localBundle.putString("realname_verify_process_req_key", paramg.dNQ);
      paramg = new RealNameBundle();
      paramg.HTZ = ((String)this.HSx.HSZ.getValue());
      paramg.HUa = this.HSy;
      paramg.HUb = this.HSz;
      paramg.HUc = ((djv)this.HSx.HTb.getValue()).MNM.key;
      paramg.HUd = this.HSi.getText();
      paramg.HUe = ((Profession)this.HSx.HTj.getValue());
      paramg.HUf = ((String)this.HSx.HTe.getValue());
      paramg.HUg = ((String)this.HSx.HTf.getValue());
      paramg.HUh = ((String)this.HSx.HTg.getValue());
      paramg.HUi = ((String)this.HSx.HTh.getValue());
      paramg.HUj = ((Integer)this.HSx.HTn.getValue()).intValue();
      paramg.HUw = ((String)this.HSx.HTl.getValue());
      paramg.HUx = this.HSE;
      paramg.HUy = this.HSF;
      paramg.HUz = this.HSG;
      paramg.HUk = ((String)this.HSx.HTm.getValue());
      paramg.HUl = this.HSH;
      paramg.HUm = this.HSI;
      paramg.HUn = this.HSJ;
      paramg.HUo = this.HSo.getText();
      paramg.HUp = this.HSK;
      paramg.HUq = this.HSL;
      paramg.HUr = this.HSM;
      paramg.HUs = ((String)this.HSx.HTp.getValue());
      paramg.HUt = ((String)this.HSx.HTq.getValue());
      paramg.HUu = this.HSN;
      paramg.HUv = ((String)this.HSx.HTi.getValue());
      paramg.HUA = ((String)this.HSx.HTr.getValue());
      if (!getString(2131765721).equals(this.HSx.HTa.getValue())) {
        break label640;
      }
    }
    label640:
    for (int i = 1;; i = 2)
    {
      paramg.fuA = i;
      localBundle.putParcelable("realname_verify_process_bundle", paramg);
      locald.a(this, 0, localBundle);
      AppMethodBeat.o(70109);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131497046;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70106);
    this.Cjx = ((WalletFormView)findViewById(2131310605));
    this.HSq = ((WalletFormView)findViewById(2131310609));
    this.HSi = ((WalletFormView)findViewById(2131310603));
    this.HSj = ((WalletFormView)findViewById(2131310602));
    this.HSk = ((WalletFormView)findViewById(2131310601));
    this.HSl = ((WalletFormView)findViewById(2131310600));
    this.HSm = ((WalletFormView)findViewById(2131310599));
    this.HSn = ((WalletFormView)findViewById(2131310606));
    this.HSo = ((WalletFormView)findViewById(2131310598));
    this.HRu = ((WalletFormView)findViewById(2131310608));
    this.HRv = ((WalletFormView)findViewById(2131310597));
    this.HSp = ((WalletFormView)findViewById(2131310604));
    this.krs = ((Button)findViewById(2131310607));
    this.mPa = ((TextView)findViewById(2131310611));
    this.HSs = ((TextView)findViewById(2131310610));
    if (!Util.isNullOrNil(this.HSu)) {
      this.mPa.setText(this.HSu);
    }
    if (!Util.isNullOrNil(this.HSv))
    {
      this.HSs.setText(this.HSv);
      this.HSs.setVisibility(0);
    }
    this.Cjx.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    int i = getResources().getDimensionPixelSize(2131165498);
    int j = getResources().getDimensionPixelSize(2131165277);
    Object localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).rightMargin = j;
    if ((this.HSC != null) && (!Util.isNullOrNil(this.HSC.Nbx)))
    {
      this.Cjx.setText(this.HSC.Nbx);
      this.HSx.aVd(this.HSC.Nbx);
      this.Cjx.setContentTextColor(getResources().getColor(2131099749));
      this.Cjx.setInputEnable(false);
      this.Cjx.getInfoIv().setImageResource(2131690820);
      this.Cjx.getInfoIv().setmUserSetImageIconColor(getResources().getColor(2131099749));
      this.Cjx.getInfoIv().setVisibility(0);
      this.Cjx.getInfoIv().setClickable(true);
      this.Cjx.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(214175);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "on click listener");
          paramAnonymousView = new com.tencent.mm.ui.widget.a.g(WcPayRealnameVerifyIdInputUI.this.getContext(), 1, 2);
          paramAnonymousView.aE(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).Nby);
          paramAnonymousView.b(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).NbA, WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).NbC);
          paramAnonymousView.a(new g.a()new g.a
          {
            public final void onClick()
            {
              AppMethodBeat.i(214173);
              f.bn(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).NbB);
              paramAnonymousView.bMo();
              AppMethodBeat.o(214173);
            }
          }, new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(214174);
              paramAnonymousView.bMo();
              AppMethodBeat.o(214174);
            }
          });
          localObject = LayoutInflater.from(WcPayRealnameVerifyIdInputUI.this.getContext()).inflate(2131497049, null);
          ((TextView)((View)localObject).findViewById(2131310625)).setText(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).Nbz);
          paramAnonymousView.setCustomView((View)localObject);
          paramAnonymousView.dGm();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(214175);
        }
      });
      this.HSi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(214182);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "click cre type");
          WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).HTd.setValue(Boolean.TRUE);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(214182);
        }
      });
      this.HSi.getInfoIv().setClickable(false);
      this.HSi.getContentEt().setInputType(131073);
      this.HSj.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.HSj.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.HSj.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099749));
      com.tencent.mm.wallet_core.ui.formview.a.d(this.HSj);
      this.HSj.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(214183);
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramAnonymousEditable.toString());
          WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this, WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this).getText());
          paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
          String str = WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this);
          paramAnonymousEditable.HTc.setValue(str);
          AppMethodBeat.o(214183);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.HSq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70094);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = WcPayRealnameVerifyIdInputUI.this.getResources().getStringArray(2130903104);
          paramAnonymousView = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.QTc = new c.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(70093);
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2Object2 = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
                paramAnonymous2Object1 = (String)paramAnonymous2Object1;
                paramAnonymous2Object2.HTa.setValue(paramAnonymous2Object1);
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(70093);
            }
          };
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70094);
        }
      });
      this.HSk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70096);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext());
          localObject = Calendar.getInstance();
          int i = ((Calendar)localObject).get(1);
          int j = ((Calendar)localObject).get(2) + 1;
          int k = ((Calendar)localObject).get(5);
          paramAnonymousView.aZ(i, j, k);
          paramAnonymousView.aY(1900, 1, 1);
          paramAnonymousView.QSU = new b.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(70095);
              if (paramAnonymous2Boolean)
              {
                Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "year: %s, month: %s, day: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                String str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
                WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).HTl.setValue(str);
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(70095);
            }
          };
          localObject = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).HTl.getValue();
          if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
          {
            i = Util.getInt(((String)localObject).substring(0, 4), 0);
            j = Util.getInt(((String)localObject).substring(5, 7), 0);
            k = Util.getInt(((String)localObject).substring(9, 10), 0);
            if ((i > 0) && (j > 0) && (k > 0)) {
              paramAnonymousView.aX(i, j, k);
            }
          }
          for (;;)
          {
            paramAnonymousView.show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70096);
            return;
            paramAnonymousView.aX(i, j, k);
          }
        }
      });
      this.HSk.getInfoIv().setClickable(false);
      this.HSl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70097);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext()));
          paramAnonymousView = Calendar.getInstance();
          int i = paramAnonymousView.get(1);
          int j = paramAnonymousView.get(2) + 1;
          int k = paramAnonymousView.get(5);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).aX(i, j, k);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).aY(i, j, k);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).aZ(i + 200, 12, 31);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).setLongTermYear(true);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).QSU = new b.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(214184);
              String str;
              if (paramAnonymous2Boolean)
              {
                Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "year: %s, month: %s, day: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if (paramAnonymous2Int1 != 1) {
                  break label157;
                }
                str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(9999), Integer.valueOf(12), Integer.valueOf(31) });
                WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this, 9999);
                WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this, 12);
                WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this, 31);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).aVe(str);
              }
              for (;;)
              {
                WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).hide();
                AppMethodBeat.o(214184);
                return;
                label157:
                str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
                WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
                WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).aVe(str);
              }
            }
          };
          paramAnonymousView = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).HTm.getValue();
          if ((!Util.isNullOrNil(paramAnonymousView)) && (paramAnonymousView.length() >= 8))
          {
            i = Util.getInt(paramAnonymousView.substring(0, 4), 0);
            j = Util.getInt(paramAnonymousView.substring(5, 7), 0);
            k = Util.getInt(paramAnonymousView.substring(8, 10), 0);
            if ((i > 0) && (j > 0) && (k > 0))
            {
              if (i != 9999) {
                break label291;
              }
              WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).aX(1, 1, 1);
            }
          }
          for (;;)
          {
            WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70097);
            return;
            label291:
            WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).aX(i, j, k);
          }
        }
      });
      this.HSl.getInfoIv().setClickable(false);
      this.HSp.setInputType(3);
      this.HSp.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(214185);
          paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
          String str = WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).getText();
          paramAnonymousEditable.HTr.setValue(str);
          AppMethodBeat.o(214185);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.HSm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70099);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this));
          paramAnonymousView.QTc = new c.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(214186);
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2Object1 = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
                int i = paramAnonymousView.hci();
                paramAnonymous2Object1.HTn.setValue(Integer.valueOf(i));
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(214186);
            }
          };
          if (WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).HTn.getValue() != null) {
            paramAnonymousView.app(((Integer)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).HTn.getValue()).intValue());
          }
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70099);
        }
      });
      this.HSm.getInfoIv().setClickable(false);
      this.HSo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70076);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext());
          localObject = Calendar.getInstance();
          int k = ((Calendar)localObject).get(1);
          int m = ((Calendar)localObject).get(2) + 1;
          int n = ((Calendar)localObject).get(5);
          paramAnonymousView.aX(k, m, n);
          int j = k - 200;
          int i = j;
          if (j <= 0) {
            i = 1;
          }
          paramAnonymousView.aY(i, 1, 1);
          paramAnonymousView.aZ(k, m, n);
          paramAnonymousView.QSU = new b.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(214176);
              if (paramAnonymous2Boolean)
              {
                String str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
                WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
                WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).HTo.setValue(str);
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(214176);
            }
          };
          localObject = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).HTo.getValue();
          if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
          {
            i = Util.getInt(((String)localObject).substring(0, 4), 0);
            j = Util.getInt(((String)localObject).substring(5, 7), 0);
            k = Util.getInt(((String)localObject).substring(9, 10), 0);
            if ((i > 0) && (j > 0) && (k > 0)) {
              paramAnonymousView.aX(i, j, k);
            }
          }
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70076);
        }
      });
      this.HSo.getInfoIv().setClickable(false);
      this.HSn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174477);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.setClassName(WcPayRealnameVerifyIdInputUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
          if (WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this) != null) {
            paramAnonymousView.putExtra("exclude_countries_iso", WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this));
          }
          paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
          paramAnonymousView.putExtra("ui_title", WcPayRealnameVerifyIdInputUI.this.getString(2131768312));
          WcPayRealnameVerifyIdInputUI.this.startActivityForResult(paramAnonymousView, 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174477);
        }
      });
      this.HSn.getInfoIv().setClickable(false);
      this.HRu.getContentEt().setInputType(131073);
      this.HRu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174478);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
          WcPayRealnameVerifyIdInputUI.j(WcPayRealnameVerifyIdInputUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174478);
        }
      });
      this.HRu.getInfoIv().setClickable(false);
      this.HRv.getContentEt().setInputType(131073);
      this.HRv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174479);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
          if (WcPayRealnameVerifyIdInputUI.k(WcPayRealnameVerifyIdInputUI.this)) {
            WcPayRealnameVerifyIdInputUI.l(WcPayRealnameVerifyIdInputUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(174479);
            return;
            WcPayRealnameVerifyIdInputUI.m(WcPayRealnameVerifyIdInputUI.this);
          }
        }
      });
      this.HRv.getInfoIv().setClickable(false);
      this.krs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(214177);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
          WcPayRealnameVerifyIdInputUI.n(WcPayRealnameVerifyIdInputUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(214177);
        }
      });
      this.Cjx.hic();
      this.HSx.HTd.observe(this, new Observer()
      {
        int jKz = 0;
      });
      this.HSx.HTb.observe(this, new Observer() {});
      this.HSx.HTl.observe(this, new Observer() {});
      this.HSx.HTm.observe(this, new Observer() {});
      this.HSx.HTa.observe(this, new Observer() {});
      this.HSx.HTn.observe(this, new Observer() {});
      this.HSx.HTo.observe(this, new Observer() {});
      this.HSx.HTh.observe(this, new Observer() {});
      this.HSx.HTi.observe(this, new Observer() {});
      this.HSx.HTq.observe(this, new Observer() {});
      this.HSx.HTj.observe(this, new Observer() {});
      this.HSx.HTk.observe(this, new Observer() {});
      if (this.HSB.size() <= 0) {
        break label1265;
      }
      this.HSx.a((djv)this.HSB.get(0));
    }
    for (;;)
    {
      f.a(new WalletFormView[] { this.Cjx, this.HSi, this.HSj, this.HRu, this.HRv, this.HSk, this.HSl, this.HSm, this.HSn, this.HSo, this.HSp, this.HSq });
      AppMethodBeat.o(70106);
      return;
      this.Cjx.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.Cjx.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.Cjx.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099749));
      this.Cjx.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(214179);
          WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).aVd(WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).getText());
          AppMethodBeat.o(214179);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      break;
      label1265:
      localObject = this.HSj.getLogicDelegate();
      if ((localObject instanceof a.a)) {
        ((a.a)localObject).aqn(-1);
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
        if (!Util.isNullOrNil(str1))
        {
          localStringBuilder.append(str1);
          localStringBuilder.append(" ");
        }
        if (!Util.isNullOrNil(str2))
        {
          localStringBuilder.append(str2);
          localStringBuilder.append(" ");
        }
        if (!Util.isNullOrNil(str3)) {
          localStringBuilder.append(str3);
        }
        this.HSx.E(str4, str5, paramIntent, localStringBuilder.toString());
        AppMethodBeat.o(70111);
        return;
      }
      Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no area choose!");
      AppMethodBeat.o(70111);
      return;
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        paramIntent = (Profession)paramIntent.getParcelableExtra("key_select_profession");
        this.HSx.HTj.setValue(paramIntent);
        AppMethodBeat.o(70111);
        return;
      }
      Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no choose!");
      AppMethodBeat.o(70111);
      return;
    }
    if ((paramInt1 == 3) && (paramInt2 == 100))
    {
      if (!Util.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        str1 = paramIntent.getStringExtra("iso_code");
        str2 = paramIntent.getStringExtra("country_name");
        this.HSN = paramIntent.getStringExtra("couttry_code");
        paramIntent = this.HSx;
        paramIntent.HTp.setValue(str1);
        paramIntent.HTq.setValue(str2);
        AppMethodBeat.o(70111);
      }
    }
    else
    {
      if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.HRI);
        str2 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.HRJ);
        str3 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.HRK);
        str4 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.HRL);
        paramIntent = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.HRM);
        this.HSx.E(str1, str2, str3, str4);
        this.HSx.HTi.setValue(paramIntent);
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
    this.HSx = ((VM)ViewModelProviders.of(this).get(VM.class));
    paramBundle = getInput().getString("realname_verify_process_get_wording_cache");
    try
    {
      if (!Util.isNullOrNil(paramBundle))
      {
        paramBundle = (btr)new btr().parseFrom(paramBundle.getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.HSB.addAll(paramBundle.MaA);
        this.HSu = paramBundle.HSu;
        this.HSv = paramBundle.HSv;
        this.HSC = paramBundle.MaC;
      }
      initView();
      Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "do get user ext info");
      doSceneForceProgress(new l());
      AppMethodBeat.o(70105);
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WcPayRealnameVerifyIdInputUI", paramBundle, "", new Object[0]);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(70108);
    if ((paramq instanceof l))
    {
      paramString = (l)paramq;
      this.mProfessions = paramString.HTV;
      this.HSA = paramString.HSA;
    }
    while ((!(paramq instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.g)) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(70108);
      return false;
    }
    paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.g)paramq;
    if (paramString.HPz == null) {
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70108);
      return true;
      Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify show juveniles dialog");
      h.c(this, paramString.HPz.dQx, "", paramString.HPz.IaV, paramString.HPz.IaU, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(174488);
          Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lOk");
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramString);
          u.xV(1);
          AppMethodBeat.o(174488);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(214181);
          Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lCancel");
          u.xV(0);
          AppMethodBeat.o(214181);
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
    public MutableLiveData<String> HSZ;
    public MutableLiveData<String> HTa;
    public MutableLiveData<djv> HTb;
    public MutableLiveData<String> HTc;
    public MutableLiveData<Boolean> HTd;
    public MutableLiveData<String> HTe;
    public MutableLiveData<String> HTf;
    public MutableLiveData<String> HTg;
    public MutableLiveData<String> HTh;
    public MutableLiveData<String> HTi;
    public MutableLiveData<Profession> HTj;
    public MutableLiveData<Boolean> HTk;
    public MutableLiveData<String> HTl;
    public MutableLiveData<String> HTm;
    public MutableLiveData<Integer> HTn;
    public MutableLiveData<String> HTo;
    public MutableLiveData<String> HTp;
    public MutableLiveData<String> HTq;
    public MutableLiveData<String> HTr;
    
    public VM()
    {
      AppMethodBeat.i(70101);
      this.HSZ = new MutableLiveData();
      this.HTa = new MutableLiveData();
      this.HTb = new MutableLiveData();
      this.HTc = new MutableLiveData();
      this.HTd = new MutableLiveData();
      this.HTe = new MutableLiveData();
      this.HTf = new MutableLiveData();
      this.HTg = new MutableLiveData();
      this.HTh = new MutableLiveData();
      this.HTi = new MutableLiveData();
      this.HTj = new MutableLiveData();
      this.HTk = new MutableLiveData();
      this.HTl = new MutableLiveData();
      this.HTm = new MutableLiveData();
      this.HTn = new MutableLiveData();
      this.HTo = new MutableLiveData();
      this.HTp = new MutableLiveData();
      this.HTq = new MutableLiveData();
      this.HTr = new MutableLiveData();
      this.HTn.setValue(Integer.valueOf(0));
      Observer local1 = new Observer()
      {
        public final void onChanged(Object paramAnonymousObject)
        {
          AppMethodBeat.i(70100);
          if (WcPayRealnameVerifyIdInputUI.VM.a(WcPayRealnameVerifyIdInputUI.VM.this))
          {
            WcPayRealnameVerifyIdInputUI.VM.this.HTk.setValue(Boolean.TRUE);
            AppMethodBeat.o(70100);
            return;
          }
          WcPayRealnameVerifyIdInputUI.VM.this.HTk.setValue(Boolean.FALSE);
          AppMethodBeat.o(70100);
        }
      };
      this.HSZ.observeForever(local1);
      this.HTc.observeForever(local1);
      this.HTj.observeForever(local1);
      this.HTe.observeForever(local1);
      this.HTf.observeForever(local1);
      this.HTg.observeForever(local1);
      this.HTl.observeForever(local1);
      this.HTm.observeForever(local1);
      this.HTn.observeForever(local1);
      this.HTp.observeForever(local1);
      this.HTq.observeForever(local1);
      this.HTo.observeForever(local1);
      this.HTr.observeForever(local1);
      this.HTa.observeForever(local1);
      AppMethodBeat.o(70101);
    }
    
    public final void E(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(174494);
      this.HTe.setValue(paramString1);
      this.HTf.setValue(paramString2);
      this.HTg.setValue(paramString3);
      this.HTh.setValue(paramString4);
      AppMethodBeat.o(174494);
    }
    
    public final void a(djv paramdjv)
    {
      AppMethodBeat.i(70102);
      this.HTb.setValue(paramdjv);
      AppMethodBeat.o(70102);
    }
    
    public final void aVd(String paramString)
    {
      AppMethodBeat.i(214187);
      this.HSZ.setValue(paramString);
      AppMethodBeat.o(214187);
    }
    
    public final void aVe(String paramString)
    {
      AppMethodBeat.i(214188);
      this.HTm.setValue(paramString);
      AppMethodBeat.o(214188);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI
 * JD-Core Version:    0.7.0.1
 */