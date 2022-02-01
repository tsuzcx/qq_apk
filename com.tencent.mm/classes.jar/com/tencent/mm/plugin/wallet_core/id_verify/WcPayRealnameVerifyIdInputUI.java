package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
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
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.l;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.protocal.protobuf.ely;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEncrypt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WcPayRealnameVerifyIdInputUI
  extends WalletBaseUI
{
  private static final int OKo;
  private WalletFormView Igq;
  private WalletFormView OJC;
  private WalletFormView OJD;
  private com.tencent.mm.ui.widget.picker.a OKA;
  private String OKB;
  private String OKC;
  private boolean OKD;
  private a OKE;
  private String OKF;
  private String OKG;
  private String[] OKH;
  private List<dtk> OKI;
  private ely OKJ;
  private String[] OKK;
  private int OKL;
  private int OKM;
  private int OKN;
  private int OKO;
  private int OKP;
  private int OKQ;
  private int OKR;
  private int OKS;
  private int OKT;
  private String OKU;
  private TenpaySecureEncrypt OKV;
  private WalletFormView OKp;
  private WalletFormView OKq;
  private WalletFormView OKr;
  private WalletFormView OKs;
  private WalletFormView OKt;
  private WalletFormView OKu;
  private WalletFormView OKv;
  private WalletFormView OKw;
  private WalletFormView OKx;
  private com.tencent.mm.ui.widget.picker.b OKy;
  private TextView OKz;
  private Profession[] mProfessions;
  private Button njb;
  private TextView pPT;
  
  static
  {
    AppMethodBeat.i(70117);
    OKo = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 88);
    AppMethodBeat.o(70117);
  }
  
  public WcPayRealnameVerifyIdInputUI()
  {
    AppMethodBeat.i(70104);
    this.OKI = new ArrayList();
    this.OKK = new String[100];
    int i = 0;
    while (i < this.OKK.length)
    {
      this.OKK[i] = MMApplicationContext.getContext().getString(a.i.wallet_cre_count, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    this.OKL = 0;
    this.OKM = 0;
    this.OKN = 0;
    this.OKO = 0;
    this.OKP = 0;
    this.OKQ = 0;
    this.OKR = 0;
    this.OKS = 0;
    this.OKT = 0;
    this.OKU = "";
    this.OKV = new TenpaySecureEncrypt();
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
      localBundle.putString("key_country_code", (String)this.OKE.OLl.getValue());
      localBundle.putString("key_province_code", (String)this.OKE.OLm.getValue());
      localBundle.putString("key_city_code", (String)this.OKE.OLn.getValue());
      localBundle.putParcelable("key_profession", (Parcelable)this.OKE.OLq.getValue());
      localBundle.putBoolean("realname_verify_process_need_bind_card", paramg.OLM);
      localBundle.putBoolean("realname_verify_process_need_face", paramg.OLN);
      localBundle.putLong("realname_verify_process_face_scene", paramg.kVd);
      localBundle.putString("realname_verify_process_face_package", paramg.packageExt);
      localBundle.putString("realname_verify_process_face_package_sign", paramg.fSC);
      localBundle.putString("realname_verify_process_add_bank_word", paramg.OLQ);
      localBundle.putString("realname_verify_process_req_key", paramg.fHb);
      paramg = new RealNameBundle();
      paramg.OMa = ((String)this.OKE.OLg.getValue());
      paramg.OMb = this.OKF;
      paramg.OMc = this.OKG;
      paramg.OMd = ((dtk)this.OKE.OLi.getValue()).TZF.key;
      paramg.OMe = this.OKp.getText();
      paramg.OMf = ((Profession)this.OKE.OLq.getValue());
      paramg.OMg = ((String)this.OKE.OLl.getValue());
      paramg.OMh = ((String)this.OKE.OLm.getValue());
      paramg.OMi = ((String)this.OKE.OLn.getValue());
      paramg.OMj = ((String)this.OKE.OLo.getValue());
      paramg.OMk = ((Integer)this.OKE.OLu.getValue()).intValue();
      paramg.OMx = ((String)this.OKE.OLs.getValue());
      paramg.OMy = this.OKL;
      paramg.OMz = this.OKM;
      paramg.OMA = this.OKN;
      paramg.OMl = ((String)this.OKE.OLt.getValue());
      paramg.OMm = this.OKO;
      paramg.OMn = this.OKP;
      paramg.OMo = this.OKQ;
      paramg.OMp = this.OKv.getText();
      paramg.OMq = this.OKR;
      paramg.OMr = this.OKS;
      paramg.OMs = this.OKT;
      paramg.OMt = ((String)this.OKE.OLw.getValue());
      paramg.OMu = ((String)this.OKE.OLx.getValue());
      paramg.OMv = this.OKU;
      paramg.OMw = ((String)this.OKE.OLp.getValue());
      paramg.OMB = ((String)this.OKE.OLy.getValue());
      if (!getString(a.i.sex_male).equals(this.OKE.OLh.getValue())) {
        break label641;
      }
    }
    label641:
    for (int i = 1;; i = 2)
    {
      paramg.sex = i;
      localBundle.putParcelable("realname_verify_process_bundle", paramg);
      locald.a(this, 0, localBundle);
      AppMethodBeat.o(70109);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return a.g.wc_pay_realname_verify_id_input_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70106);
    this.Igq = ((WalletFormView)findViewById(a.f.wpri_name_et));
    this.OKx = ((WalletFormView)findViewById(a.f.wpri_sex_et));
    this.OKp = ((WalletFormView)findViewById(a.f.wpri_cretype_et));
    this.OKq = ((WalletFormView)findViewById(a.f.wpri_crenum_et));
    this.OKr = ((WalletFormView)findViewById(a.f.wpri_cre_valid_date_et));
    this.OKs = ((WalletFormView)findViewById(a.f.wpri_cre_invalid_date_et));
    this.OKt = ((WalletFormView)findViewById(a.f.wpri_cre_change_times_et));
    this.OKu = ((WalletFormView)findViewById(a.f.wpri_nationality_et));
    this.OKv = ((WalletFormView)findViewById(a.f.wpri_birthday_et));
    this.OJC = ((WalletFormView)findViewById(a.f.wpri_profession_et));
    this.OJD = ((WalletFormView)findViewById(a.f.wpri_address_et));
    this.OKw = ((WalletFormView)findViewById(a.f.wpri_mobile_et));
    this.njb = ((Button)findViewById(a.f.wpri_next_btn));
    this.pPT = ((TextView)findViewById(a.f.wpri_title_tv));
    this.OKz = ((TextView)findViewById(a.f.wpri_title_desc_tv));
    if (!Util.isNullOrNil(this.OKB)) {
      this.pPT.setText(this.OKB);
    }
    if (!Util.isNullOrNil(this.OKC))
    {
      this.OKz.setText(this.OKC);
      this.OKz.setVisibility(0);
    }
    this.Igq.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    int i = getResources().getDimensionPixelSize(a.d.LargePadding);
    int j = getResources().getDimensionPixelSize(a.d.Edge_0_5_A);
    Object localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).rightMargin = j;
    if ((this.OKJ != null) && (!Util.isNullOrNil(this.OKJ.UnT)))
    {
      this.Igq.setText(this.OKJ.UnT);
      this.OKE.bgM(this.OKJ.UnT);
      this.Igq.setContentTextColor(getResources().getColor(a.c.FG_2));
      this.Igq.setInputEnable(false);
      this.Igq.getInfoIv().setImageResource(a.h.icons_outlined_info);
      this.Igq.getInfoIv().setmUserSetImageIconColor(getResources().getColor(a.c.FG_2));
      this.Igq.getInfoIv().setVisibility(0);
      this.Igq.getInfoIv().setClickable(true);
      this.Igq.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(253214);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "on click listener");
          paramAnonymousView = new com.tencent.mm.ui.widget.a.g(WcPayRealnameVerifyIdInputUI.this.getContext(), 1, 2);
          paramAnonymousView.aT(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).UnU);
          paramAnonymousView.d(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).UnW, WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).UnY);
          paramAnonymousView.a(new g.a()new g.a
          {
            public final void onClick()
            {
              AppMethodBeat.i(242017);
              com.tencent.mm.wallet_core.ui.g.bA(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).UnX);
              paramAnonymousView.bYF();
              AppMethodBeat.o(242017);
            }
          }, new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(270403);
              paramAnonymousView.bYF();
              AppMethodBeat.o(270403);
            }
          });
          localObject = LayoutInflater.from(WcPayRealnameVerifyIdInputUI.this.getContext()).inflate(a.g.wcpay_special_findpwd_dialog, null);
          ((TextView)((View)localObject).findViewById(a.f.wsfd_content_tv)).setText(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).UnV);
          paramAnonymousView.setCustomView((View)localObject);
          paramAnonymousView.eik();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(253214);
        }
      });
      this.OKp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(223817);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "click cre type");
          WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).OLk.setValue(Boolean.TRUE);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(223817);
        }
      });
      this.OKp.getInfoIv().setClickable(false);
      this.OKp.getContentEt().setInputType(131073);
      this.OKq.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.OKq.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.OKq.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
      com.tencent.mm.wallet_core.ui.formview.a.d(this.OKq);
      this.OKq.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(195523);
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramAnonymousEditable.toString());
          WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this, WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this).getText());
          paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
          String str = WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this);
          paramAnonymousEditable.OLj.setValue(str);
          AppMethodBeat.o(195523);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.OKx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70094);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = WcPayRealnameVerifyIdInputUI.this.getResources().getStringArray(a.b.wc_pay_realname_sex_selection);
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.YrN = new b.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(70093);
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2Object2 = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
                paramAnonymous2Object1 = (String)paramAnonymous2Object1;
                paramAnonymous2Object2.OLh.setValue(paramAnonymous2Object1);
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
      this.OKr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70096);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.a(WcPayRealnameVerifyIdInputUI.this.getContext());
          localObject = Calendar.getInstance();
          int i = ((Calendar)localObject).get(1);
          int j = ((Calendar)localObject).get(2) + 1;
          int k = ((Calendar)localObject).get(5);
          paramAnonymousView.bd(i, j, k);
          paramAnonymousView.bc(1900, 1, 1);
          paramAnonymousView.YrF = new com.tencent.mm.ui.widget.picker.a.a()
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
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).OLs.setValue(str);
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(70095);
            }
          };
          localObject = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).OLs.getValue();
          if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
          {
            i = Util.getInt(((String)localObject).substring(0, 4), 0);
            j = Util.getInt(((String)localObject).substring(5, 7), 0);
            k = Util.getInt(((String)localObject).substring(9, 10), 0);
            if ((i > 0) && (j > 0) && (k > 0)) {
              paramAnonymousView.bb(i, j, k);
            }
          }
          for (;;)
          {
            paramAnonymousView.show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70096);
            return;
            paramAnonymousView.bb(i, j, k);
          }
        }
      });
      this.OKr.getInfoIv().setClickable(false);
      this.OKs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70097);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, new com.tencent.mm.ui.widget.picker.a(WcPayRealnameVerifyIdInputUI.this.getContext()));
          paramAnonymousView = Calendar.getInstance();
          int i = paramAnonymousView.get(1);
          int j = paramAnonymousView.get(2) + 1;
          int k = paramAnonymousView.get(5);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).bb(i, j, k);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).bc(i, j, k);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).bd(i + 200, 12, 31);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).setLongTermYear(true);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).YrF = new com.tencent.mm.ui.widget.picker.a.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(273212);
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
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).bgN(str);
              }
              for (;;)
              {
                WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).hide();
                AppMethodBeat.o(273212);
                return;
                label157:
                str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
                WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
                WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).bgN(str);
              }
            }
          };
          paramAnonymousView = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).OLt.getValue();
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
              WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).bb(1, 1, 1);
            }
          }
          for (;;)
          {
            WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70097);
            return;
            label291:
            WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).bb(i, j, k);
          }
        }
      });
      this.OKs.getInfoIv().setClickable(false);
      this.OKw.setInputType(3);
      this.OKw.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(275404);
          paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
          String str = WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).getText();
          paramAnonymousEditable.OLy.setValue(str);
          AppMethodBeat.o(275404);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.OKt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70099);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this));
          paramAnonymousView.YrN = new b.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(255515);
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2Object1 = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
                int i = paramAnonymousView.idp();
                paramAnonymous2Object1.OLu.setValue(Integer.valueOf(i));
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(255515);
            }
          };
          if (WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).OLu.getValue() != null) {
            paramAnonymousView.ayK(((Integer)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).OLu.getValue()).intValue());
          }
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70099);
        }
      });
      this.OKt.getInfoIv().setClickable(false);
      this.OKv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70076);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.a(WcPayRealnameVerifyIdInputUI.this.getContext());
          localObject = Calendar.getInstance();
          int k = ((Calendar)localObject).get(1);
          int m = ((Calendar)localObject).get(2) + 1;
          int n = ((Calendar)localObject).get(5);
          paramAnonymousView.bb(k, m, n);
          int j = k - 200;
          int i = j;
          if (j <= 0) {
            i = 1;
          }
          paramAnonymousView.bc(i, 1, 1);
          paramAnonymousView.bd(k, m, n);
          paramAnonymousView.YrF = new com.tencent.mm.ui.widget.picker.a.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(275093);
              if (paramAnonymous2Boolean)
              {
                String str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
                WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
                WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).OLv.setValue(str);
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(275093);
            }
          };
          localObject = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).OLv.getValue();
          if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
          {
            i = Util.getInt(((String)localObject).substring(0, 4), 0);
            j = Util.getInt(((String)localObject).substring(5, 7), 0);
            k = Util.getInt(((String)localObject).substring(9, 10), 0);
            if ((i > 0) && (j > 0) && (k > 0)) {
              paramAnonymousView.bb(i, j, k);
            }
          }
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70076);
        }
      });
      this.OKv.getInfoIv().setClickable(false);
      this.OKu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174477);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.setClassName(WcPayRealnameVerifyIdInputUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
          if (WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this) != null) {
            paramAnonymousView.putExtra("exclude_countries_iso", WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this));
          }
          paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
          paramAnonymousView.putExtra("ui_title", WcPayRealnameVerifyIdInputUI.this.getString(a.i.wallet_select_country_title));
          WcPayRealnameVerifyIdInputUI.this.startActivityForResult(paramAnonymousView, 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174477);
        }
      });
      this.OKu.getInfoIv().setClickable(false);
      this.OJC.getContentEt().setInputType(131073);
      this.OJC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174478);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
          WcPayRealnameVerifyIdInputUI.j(WcPayRealnameVerifyIdInputUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174478);
        }
      });
      this.OJC.getInfoIv().setClickable(false);
      this.OJD.getContentEt().setInputType(131073);
      this.OJD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174479);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
      this.OJD.getInfoIv().setClickable(false);
      this.njb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187158);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
          WcPayRealnameVerifyIdInputUI.n(WcPayRealnameVerifyIdInputUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(187158);
        }
      });
      this.Igq.ijE();
      this.OKE.OLk.a(this, new s()
      {
        int mBE = 0;
      });
      this.OKE.OLi.a(this, new s() {});
      this.OKE.OLs.a(this, new s() {});
      this.OKE.OLt.a(this, new s() {});
      this.OKE.OLh.a(this, new s() {});
      this.OKE.OLu.a(this, new s() {});
      this.OKE.OLv.a(this, new s() {});
      this.OKE.OLo.a(this, new s() {});
      this.OKE.OLp.a(this, new s() {});
      this.OKE.OLx.a(this, new s() {});
      this.OKE.OLq.a(this, new s() {});
      this.OKE.OLr.a(this, new s() {});
      if (this.OKI.size() <= 0) {
        break label1271;
      }
      this.OKE.a((dtk)this.OKI.get(0));
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.ui.g.a(new WalletFormView[] { this.Igq, this.OKp, this.OKq, this.OJC, this.OJD, this.OKr, this.OKs, this.OKt, this.OKu, this.OKv, this.OKw, this.OKx });
      AppMethodBeat.o(70106);
      return;
      this.Igq.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.Igq.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.Igq.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
      this.Igq.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(269464);
          WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).bgM(WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).getText());
          AppMethodBeat.o(269464);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      break;
      label1271:
      localObject = this.OKq.getLogicDelegate();
      if ((localObject instanceof com.tencent.mm.wallet_core.ui.formview.a.a)) {
        ((com.tencent.mm.wallet_core.ui.formview.a.a)localObject).azL(-1);
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
        this.OKE.K(str4, str5, paramIntent, localStringBuilder.toString());
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
        this.OKE.OLq.setValue(paramIntent);
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
        this.OKU = paramIntent.getStringExtra("couttry_code");
        paramIntent = this.OKE;
        paramIntent.OLw.setValue(str1);
        paramIntent.OLx.setValue(str2);
        AppMethodBeat.o(70111);
      }
    }
    else
    {
      if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.OJP);
        str2 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.OJQ);
        str3 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.OJR);
        str4 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.OJS);
        paramIntent = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.OJT);
        this.OKE.K(str1, str2, str3, str4);
        this.OKE.OLp.setValue(paramIntent);
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
    setActionbarColor(getResources().getColor(a.c.BG_5));
    hideActionbarLine();
    setMMTitle("");
    this.mNetSceneMgr.addSceneEndListener(1616);
    this.OKE = ((a)z.a(this, null).i(a.class));
    paramBundle = getInput().getString("realname_verify_process_get_wording_cache");
    try
    {
      if (!Util.isNullOrNil(paramBundle))
      {
        paramBundle = (cbj)new cbj().parseFrom(paramBundle.getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.OKI.addAll(paramBundle.TjT);
        this.OKB = paramBundle.OKB;
        this.OKC = paramBundle.OKC;
        this.OKJ = paramBundle.TjV;
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
      this.mProfessions = paramString.OLW;
      this.OKH = paramString.OKH;
    }
    while ((!(paramq instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.g)) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(70108);
      return false;
    }
    paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.g)paramq;
    if (paramString.OHH == null) {
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70108);
      return true;
      Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify show juveniles dialog");
      h.c(this, paramString.OHH.wording, "", paramString.OHH.OTg, paramString.OHH.OTf, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(174488);
          Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lOk");
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramString);
          v.Bv(1);
          AppMethodBeat.o(174488);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(210553);
          Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lCancel");
          v.Bv(0);
          AppMethodBeat.o(210553);
        }
      });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class a
    extends x
  {
    public r<String> OLg;
    public r<String> OLh;
    public r<dtk> OLi;
    public r<String> OLj;
    public r<Boolean> OLk;
    public r<String> OLl;
    public r<String> OLm;
    public r<String> OLn;
    public r<String> OLo;
    public r<String> OLp;
    public r<Profession> OLq;
    public r<Boolean> OLr;
    public r<String> OLs;
    public r<String> OLt;
    public r<Integer> OLu;
    public r<String> OLv;
    public r<String> OLw;
    public r<String> OLx;
    public r<String> OLy;
    
    public a()
    {
      AppMethodBeat.i(70101);
      this.OLg = new r();
      this.OLh = new r();
      this.OLi = new r();
      this.OLj = new r();
      this.OLk = new r();
      this.OLl = new r();
      this.OLm = new r();
      this.OLn = new r();
      this.OLo = new r();
      this.OLp = new r();
      this.OLq = new r();
      this.OLr = new r();
      this.OLs = new r();
      this.OLt = new r();
      this.OLu = new r();
      this.OLv = new r();
      this.OLw = new r();
      this.OLx = new r();
      this.OLy = new r();
      this.OLu.setValue(Integer.valueOf(0));
      s local1 = new s()
      {
        public final void onChanged(Object paramAnonymousObject)
        {
          AppMethodBeat.i(70100);
          if (WcPayRealnameVerifyIdInputUI.a.a(WcPayRealnameVerifyIdInputUI.a.this))
          {
            WcPayRealnameVerifyIdInputUI.a.this.OLr.setValue(Boolean.TRUE);
            AppMethodBeat.o(70100);
            return;
          }
          WcPayRealnameVerifyIdInputUI.a.this.OLr.setValue(Boolean.FALSE);
          AppMethodBeat.o(70100);
        }
      };
      this.OLg.a(local1);
      this.OLj.a(local1);
      this.OLq.a(local1);
      this.OLl.a(local1);
      this.OLm.a(local1);
      this.OLn.a(local1);
      this.OLs.a(local1);
      this.OLt.a(local1);
      this.OLu.a(local1);
      this.OLw.a(local1);
      this.OLx.a(local1);
      this.OLv.a(local1);
      this.OLy.a(local1);
      this.OLh.a(local1);
      AppMethodBeat.o(70101);
    }
    
    public final void K(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(174494);
      this.OLl.setValue(paramString1);
      this.OLm.setValue(paramString2);
      this.OLn.setValue(paramString3);
      this.OLo.setValue(paramString4);
      AppMethodBeat.o(174494);
    }
    
    public final void a(dtk paramdtk)
    {
      AppMethodBeat.i(70102);
      this.OLi.setValue(paramdtk);
      AppMethodBeat.o(70102);
    }
    
    public final void bgM(String paramString)
    {
      AppMethodBeat.i(242839);
      this.OLg.setValue(paramString);
      AppMethodBeat.o(242839);
    }
    
    public final void bgN(String paramString)
    {
      AppMethodBeat.i(242840);
      this.OLt.setValue(paramString);
      AppMethodBeat.o(242840);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI
 * JD-Core Version:    0.7.0.1
 */