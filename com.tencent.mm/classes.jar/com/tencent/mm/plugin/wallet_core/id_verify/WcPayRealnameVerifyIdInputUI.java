package com.tencent.mm.plugin.wallet_core.id_verify;

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
import androidx.lifecycle.af;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
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
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.protocal.protobuf.emf;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEncrypt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WcPayRealnameVerifyIdInputUI
  extends WalletBaseUI
{
  private static final int VAa;
  private WalletFormView OcP;
  private int VAA;
  private int VAB;
  private int VAC;
  private int VAD;
  private int VAE;
  private int VAF;
  private String VAG;
  private TenpaySecureEncrypt VAH;
  private WalletFormView VAb;
  private WalletFormView VAc;
  private WalletFormView VAd;
  private WalletFormView VAe;
  private WalletFormView VAf;
  private WalletFormView VAg;
  private WalletFormView VAh;
  private WalletFormView VAi;
  private WalletFormView VAj;
  private com.tencent.mm.ui.widget.picker.b VAk;
  private TextView VAl;
  private com.tencent.mm.ui.widget.picker.a VAm;
  private String VAn;
  private String VAo;
  private boolean VAp;
  private a VAq;
  private String VAr;
  private String VAs;
  private String[] VAt;
  private List<emf> VAu;
  private fgr VAv;
  private String[] VAw;
  private int VAx;
  private int VAy;
  private int VAz;
  private WalletFormView Vzo;
  private WalletFormView Vzp;
  private Profession[] mProfessions;
  private Button qgp;
  private TextView sUt;
  
  static
  {
    AppMethodBeat.i(70117);
    VAa = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 88);
    AppMethodBeat.o(70117);
  }
  
  public WcPayRealnameVerifyIdInputUI()
  {
    AppMethodBeat.i(70104);
    this.VAu = new ArrayList();
    this.VAw = new String[100];
    int i = 0;
    while (i < this.VAw.length)
    {
      this.VAw[i] = MMApplicationContext.getContext().getString(a.i.wallet_cre_count, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    this.VAx = 0;
    this.VAy = 0;
    this.VAz = 0;
    this.VAA = 0;
    this.VAB = 0;
    this.VAC = 0;
    this.VAD = 0;
    this.VAE = 0;
    this.VAF = 0;
    this.VAG = "";
    this.VAH = new TenpaySecureEncrypt();
    AppMethodBeat.o(70104);
  }
  
  private void a(com.tencent.mm.plugin.wallet_core.id_verify.model.g paramg)
  {
    AppMethodBeat.i(70109);
    e locale = getProcess();
    Bundle localBundle = getInput();
    String str = paramg.token;
    Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify response succ");
    if (locale != null)
    {
      localBundle.putString("key_real_name_token", str);
      localBundle.putString("key_country_code", (String)this.VAq.VAX.getValue());
      localBundle.putString("key_province_code", (String)this.VAq.VAY.getValue());
      localBundle.putString("key_city_code", (String)this.VAq.VAZ.getValue());
      localBundle.putParcelable("key_profession", (Parcelable)this.VAq.VBc.getValue());
      localBundle.putBoolean("realname_verify_process_need_bind_card", paramg.VBx);
      localBundle.putBoolean("realname_verify_process_need_face", paramg.VBy);
      localBundle.putLong("realname_verify_process_face_scene", paramg.nAz);
      localBundle.putString("realname_verify_process_face_package", paramg.packageExt);
      localBundle.putString("realname_verify_process_face_package_sign", paramg.hYz);
      localBundle.putString("realname_verify_process_add_bank_word", paramg.VBB);
      localBundle.putString("realname_verify_process_req_key", paramg.hMy);
      paramg = new RealNameBundle();
      paramg.VBL = ((String)this.VAq.VAS.getValue());
      paramg.VBM = this.VAr;
      paramg.VBN = this.VAs;
      paramg.VBO = ((emf)this.VAq.VAU.getValue()).abqC.key;
      paramg.VBP = this.VAb.getText();
      paramg.VBQ = ((Profession)this.VAq.VBc.getValue());
      paramg.VBR = ((String)this.VAq.VAX.getValue());
      paramg.VBS = ((String)this.VAq.VAY.getValue());
      paramg.VBT = ((String)this.VAq.VAZ.getValue());
      paramg.VBU = ((String)this.VAq.VBa.getValue());
      paramg.VBV = ((Integer)this.VAq.VBg.getValue()).intValue();
      paramg.VCi = ((String)this.VAq.VBe.getValue());
      paramg.VCj = this.VAx;
      paramg.VCk = this.VAy;
      paramg.VCl = this.VAz;
      paramg.VBW = ((String)this.VAq.VBf.getValue());
      paramg.VBX = this.VAA;
      paramg.VBY = this.VAB;
      paramg.VBZ = this.VAC;
      paramg.VCa = this.VAh.getText();
      paramg.VCb = this.VAD;
      paramg.VCc = this.VAE;
      paramg.VCd = this.VAF;
      paramg.VCe = ((String)this.VAq.VBi.getValue());
      paramg.VCf = ((String)this.VAq.VBj.getValue());
      paramg.VCg = this.VAG;
      paramg.VCh = ((String)this.VAq.VBb.getValue());
      paramg.VCm = ((String)this.VAq.VBk.getValue());
      if (!getString(a.i.sex_male).equals(this.VAq.VAT.getValue())) {
        break label641;
      }
    }
    label641:
    for (int i = 1;; i = 2)
    {
      paramg.sex = i;
      localBundle.putParcelable("realname_verify_process_bundle", paramg);
      locale.a(this, 0, localBundle);
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
    this.OcP = ((WalletFormView)findViewById(a.f.wpri_name_et));
    this.VAj = ((WalletFormView)findViewById(a.f.wpri_sex_et));
    this.VAb = ((WalletFormView)findViewById(a.f.wpri_cretype_et));
    this.VAc = ((WalletFormView)findViewById(a.f.wpri_crenum_et));
    this.VAd = ((WalletFormView)findViewById(a.f.wpri_cre_valid_date_et));
    this.VAe = ((WalletFormView)findViewById(a.f.wpri_cre_invalid_date_et));
    this.VAf = ((WalletFormView)findViewById(a.f.wpri_cre_change_times_et));
    this.VAg = ((WalletFormView)findViewById(a.f.wpri_nationality_et));
    this.VAh = ((WalletFormView)findViewById(a.f.wpri_birthday_et));
    this.Vzo = ((WalletFormView)findViewById(a.f.wpri_profession_et));
    this.Vzp = ((WalletFormView)findViewById(a.f.wpri_address_et));
    this.VAi = ((WalletFormView)findViewById(a.f.wpri_mobile_et));
    this.qgp = ((Button)findViewById(a.f.wpri_next_btn));
    this.sUt = ((TextView)findViewById(a.f.wpri_title_tv));
    this.VAl = ((TextView)findViewById(a.f.wpri_title_desc_tv));
    if (!Util.isNullOrNil(this.VAn)) {
      this.sUt.setText(this.VAn);
    }
    if (!Util.isNullOrNil(this.VAo))
    {
      this.VAl.setText(this.VAo);
      this.VAl.setVisibility(0);
    }
    this.OcP.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    int i = getResources().getDimensionPixelSize(a.d.LargePadding);
    int j = getResources().getDimensionPixelSize(a.d.Edge_0_5_A);
    Object localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).rightMargin = j;
    if ((this.VAv != null) && (!Util.isNullOrNil(this.VAv.abGv)))
    {
      this.OcP.setText(this.VAv.abGv);
      this.VAq.bgt(this.VAv.abGv);
      this.OcP.setContentTextColor(getResources().getColor(a.c.FG_2));
      this.OcP.setInputEnable(false);
      this.OcP.getInfoIv().setImageResource(a.h.icons_outlined_info);
      this.OcP.getInfoIv().setmUserSetImageIconColor(getResources().getColor(a.c.FG_2));
      this.OcP.getInfoIv().setVisibility(0);
      this.OcP.getInfoIv().setClickable(true);
      this.OcP.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(301371);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "on click listener");
          paramAnonymousView = new j(WcPayRealnameVerifyIdInputUI.this.getContext(), 1, 2);
          paramAnonymousView.bh(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).abGw);
          paramAnonymousView.d(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).abGy, WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).abGA);
          paramAnonymousView.a(new j.a()new j.a
          {
            public final void onClick()
            {
              AppMethodBeat.i(301387);
              com.tencent.mm.wallet_core.ui.i.bC(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).abGz);
              paramAnonymousView.cyW();
              AppMethodBeat.o(301387);
            }
          }, new j.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(301381);
              paramAnonymousView.cyW();
              AppMethodBeat.o(301381);
            }
          });
          localObject = LayoutInflater.from(WcPayRealnameVerifyIdInputUI.this.getContext()).inflate(a.g.wcpay_special_findpwd_dialog, null);
          ((TextView)((View)localObject).findViewById(a.f.wsfd_content_tv)).setText(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).abGx);
          paramAnonymousView.setCustomView((View)localObject);
          paramAnonymousView.dDn();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(301371);
        }
      });
      this.VAb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(301364);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "click cre type");
          WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).VAW.setValue(Boolean.TRUE);
          WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(301364);
        }
      });
      this.VAb.getInfoIv().setClickable(false);
      this.VAb.getContentEt().setInputType(131073);
      this.VAc.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.VAc.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.VAc.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
      com.tencent.mm.wallet_core.ui.formview.a.d(this.VAc);
      this.VAc.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(301367);
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramAnonymousEditable.toString());
          WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this, WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this).getText());
          paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
          String str = WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this);
          paramAnonymousEditable.VAV.setValue(str);
          AppMethodBeat.o(301367);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.VAj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70094);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
          paramAnonymousView = WcPayRealnameVerifyIdInputUI.this.getResources().getStringArray(a.b.wc_pay_realname_sex_selection);
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.agkc = new b.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(70093);
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2Object2 = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
                paramAnonymous2Object1 = (String)paramAnonymous2Object1;
                paramAnonymous2Object2.VAT.setValue(paramAnonymous2Object1);
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
      this.VAd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70096);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.a(WcPayRealnameVerifyIdInputUI.this.getContext());
          localObject = Calendar.getInstance();
          int i = ((Calendar)localObject).get(1);
          int j = ((Calendar)localObject).get(2) + 1;
          int k = ((Calendar)localObject).get(5);
          paramAnonymousView.bE(i, j, k);
          paramAnonymousView.bD(1900, 1, 1);
          paramAnonymousView.agjU = new com.tencent.mm.ui.widget.picker.a.a()
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
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).VBe.setValue(str);
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(70095);
            }
          };
          localObject = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).VBe.getValue();
          if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
          {
            i = Util.getInt(((String)localObject).substring(0, 4), 0);
            j = Util.getInt(((String)localObject).substring(5, 7), 0);
            k = Util.getInt(((String)localObject).substring(9, 10), 0);
            if ((i > 0) && (j > 0) && (k > 0)) {
              paramAnonymousView.bC(i, j, k);
            }
          }
          for (;;)
          {
            paramAnonymousView.show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70096);
            return;
            paramAnonymousView.bC(i, j, k);
          }
        }
      });
      this.VAd.getInfoIv().setClickable(false);
      this.VAd.getContentEt().setClickable(false);
      this.VAd.getContentEt().setFocusable(false);
      this.VAe.getContentEt().setClickable(false);
      this.VAe.getContentEt().setFocusable(false);
      this.VAd.getContentEt().setInputType(131073);
      this.VAe.getContentEt().setInputType(131073);
      this.VAe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70097);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, new com.tencent.mm.ui.widget.picker.a(WcPayRealnameVerifyIdInputUI.this.getContext()));
          paramAnonymousView = Calendar.getInstance();
          int i = paramAnonymousView.get(1);
          int j = paramAnonymousView.get(2) + 1;
          int k = paramAnonymousView.get(5);
          WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).bC(i, j, k);
          WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).bD(i, j, k);
          WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).bE(i + 200, 12, 31);
          WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).setLongTermYear(true);
          WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).agjU = new com.tencent.mm.ui.widget.picker.a.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(301384);
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
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).bgu(str);
              }
              for (;;)
              {
                WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).hide();
                AppMethodBeat.o(301384);
                return;
                label157:
                str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
                WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
                WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).bgu(str);
              }
            }
          };
          paramAnonymousView = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).VBf.getValue();
          if ((!Util.isNullOrNil(paramAnonymousView)) && (paramAnonymousView.length() >= 8))
          {
            i = Util.getInt(paramAnonymousView.substring(0, 4), 0);
            j = Util.getInt(paramAnonymousView.substring(5, 7), 0);
            k = Util.getInt(paramAnonymousView.substring(8, 10), 0);
            if ((i > 0) && (j > 0) && (k > 0))
            {
              if (i != 9999) {
                break label298;
              }
              WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).bC(1, 1, 1);
            }
          }
          for (;;)
          {
            WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70097);
            return;
            label298:
            WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).bC(i, j, k);
          }
        }
      });
      this.VAe.getInfoIv().setClickable(false);
      this.VAi.setInputType(3);
      this.VAi.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(301370);
          paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
          String str = WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this).getText();
          paramAnonymousEditable.VBk.setValue(str);
          AppMethodBeat.o(301370);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.VAf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70099);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this));
          paramAnonymousView.agkc = new b.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(301405);
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2Object1 = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
                int i = paramAnonymousView.jIz();
                paramAnonymous2Object1.VBg.setValue(Integer.valueOf(i));
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(301405);
            }
          };
          if (WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).VBg.getValue() != null) {
            paramAnonymousView.aFq(((Integer)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).VBg.getValue()).intValue());
          }
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70099);
        }
      });
      this.VAf.getInfoIv().setClickable(false);
      this.VAh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70076);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.a(WcPayRealnameVerifyIdInputUI.this.getContext());
          localObject = Calendar.getInstance();
          int k = ((Calendar)localObject).get(1);
          int m = ((Calendar)localObject).get(2) + 1;
          int n = ((Calendar)localObject).get(5);
          paramAnonymousView.bC(k, m, n);
          int j = k - 200;
          int i = j;
          if (j <= 0) {
            i = 1;
          }
          paramAnonymousView.bD(i, 1, 1);
          paramAnonymousView.bE(k, m, n);
          paramAnonymousView.agjU = new com.tencent.mm.ui.widget.picker.a.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(301373);
              if (paramAnonymous2Boolean)
              {
                String str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
                WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
                WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).VBh.setValue(str);
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(301373);
            }
          };
          localObject = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).VBh.getValue();
          if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
          {
            i = Util.getInt(((String)localObject).substring(0, 4), 0);
            j = Util.getInt(((String)localObject).substring(5, 7), 0);
            k = Util.getInt(((String)localObject).substring(9, 10), 0);
            if ((i > 0) && (j > 0) && (k > 0)) {
              paramAnonymousView.bC(i, j, k);
            }
          }
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70076);
        }
      });
      this.VAh.getInfoIv().setClickable(false);
      this.VAg.getContentEt().setFocusable(true);
      this.VAg.getContentEt().setClickable(true);
      this.VAg.getContentEt().setEnabled(true);
      this.VAg.getContentEt().setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174477);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
          paramAnonymousView = new Intent();
          paramAnonymousView.setClassName(WcPayRealnameVerifyIdInputUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
          if (WcPayRealnameVerifyIdInputUI.j(WcPayRealnameVerifyIdInputUI.this) != null) {
            paramAnonymousView.putExtra("exclude_countries_iso", WcPayRealnameVerifyIdInputUI.j(WcPayRealnameVerifyIdInputUI.this));
          }
          paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
          paramAnonymousView.putExtra("ui_title", WcPayRealnameVerifyIdInputUI.this.getString(a.i.wallet_select_country_title));
          WcPayRealnameVerifyIdInputUI.this.startActivityForResult(paramAnonymousView, 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174477);
        }
      });
      this.VAg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174478);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
          paramAnonymousView = new Intent();
          paramAnonymousView.setClassName(WcPayRealnameVerifyIdInputUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
          if (WcPayRealnameVerifyIdInputUI.j(WcPayRealnameVerifyIdInputUI.this) != null) {
            paramAnonymousView.putExtra("exclude_countries_iso", WcPayRealnameVerifyIdInputUI.j(WcPayRealnameVerifyIdInputUI.this));
          }
          paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
          paramAnonymousView.putExtra("ui_title", WcPayRealnameVerifyIdInputUI.this.getString(a.i.wallet_select_country_title));
          WcPayRealnameVerifyIdInputUI.this.startActivityForResult(paramAnonymousView, 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174478);
        }
      });
      this.VAg.getInfoIv().setClickable(false);
      this.Vzo.getContentEt().setInputType(131073);
      this.Vzo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174479);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
          WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
          WcPayRealnameVerifyIdInputUI.k(WcPayRealnameVerifyIdInputUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174479);
        }
      });
      this.Vzo.getInfoIv().setClickable(false);
      this.Vzp.getContentEt().setInputType(131073);
      this.Vzp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(301372);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
          WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
          if (WcPayRealnameVerifyIdInputUI.l(WcPayRealnameVerifyIdInputUI.this)) {
            WcPayRealnameVerifyIdInputUI.m(WcPayRealnameVerifyIdInputUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(301372);
            return;
            WcPayRealnameVerifyIdInputUI.n(WcPayRealnameVerifyIdInputUI.this);
          }
        }
      });
      this.Vzp.getInfoIv().setClickable(false);
      this.qgp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(301374);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this);
          WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
          WcPayRealnameVerifyIdInputUI.o(WcPayRealnameVerifyIdInputUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(301374);
        }
      });
      this.OcP.jPE();
      this.VAq.VAW.a(this, new y()
      {
        int pym = 0;
      });
      this.VAq.VAU.a(this, new y() {});
      this.VAq.VBe.a(this, new y() {});
      this.VAq.VBf.a(this, new y() {});
      this.VAq.VAT.a(this, new y() {});
      this.VAq.VBg.a(this, new y() {});
      this.VAq.VBh.a(this, new y() {});
      this.VAq.VBa.a(this, new y() {});
      this.VAq.VBb.a(this, new y() {});
      this.VAq.VBj.a(this, new y() {});
      this.VAq.VBc.a(this, new y() {});
      this.VAq.VBd.a(this, new y() {});
      if (this.VAu.size() <= 0) {
        break label1392;
      }
      this.VAq.a((emf)this.VAu.get(0));
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.ui.i.a(new WalletFormView[] { this.OcP, this.VAb, this.VAc, this.Vzo, this.Vzp, this.VAd, this.VAe, this.VAf, this.VAg, this.VAh, this.VAi, this.VAj });
      AppMethodBeat.o(70106);
      return;
      this.OcP.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.OcP.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.OcP.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
      this.OcP.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(301360);
          WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).bgt(WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).getText());
          AppMethodBeat.o(301360);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      break;
      label1392:
      localObject = this.VAc.getLogicDelegate();
      if ((localObject instanceof com.tencent.mm.wallet_core.ui.formview.a.a)) {
        ((com.tencent.mm.wallet_core.ui.formview.a.a)localObject).aGB(-1);
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
        this.VAq.M(str4, str5, paramIntent, localStringBuilder.toString());
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
        this.VAq.VBc.setValue(paramIntent);
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
        this.VAG = paramIntent.getStringExtra("couttry_code");
        paramIntent = this.VAq;
        paramIntent.VBi.setValue(str1);
        paramIntent.VBj.setValue(str2);
        AppMethodBeat.o(70111);
      }
    }
    else
    {
      if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.VzB);
        str2 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.VzC);
        str3 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.VzD);
        str4 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.VzE);
        paramIntent = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.VzF);
        this.VAq.M(str1, str2, str3, str4);
        this.VAq.VBb.setValue(paramIntent);
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
    this.VAq = ((a)ai.a(this, null).q(a.class));
    paramBundle = getInput().getString("realname_verify_process_get_wording_cache");
    try
    {
      if (!Util.isNullOrNil(paramBundle))
      {
        paramBundle = (cqs)new cqs().parseFrom(paramBundle.getBytes(org.apache.commons.b.a.ISO_8859_1));
        this.VAu.addAll(paramBundle.aaxw);
        this.VAn = paramBundle.VAn;
        this.VAo = paramBundle.VAo;
        this.VAv = paramBundle.aaxy;
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(70108);
    if ((paramp instanceof l))
    {
      paramString = (l)paramp;
      this.mProfessions = paramString.VBH;
      this.VAt = paramString.VAt;
    }
    while ((!(paramp instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.g)) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(70108);
      return false;
    }
    paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.g)paramp;
    if (paramString.Vxt == null) {
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70108);
      return true;
      Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify show juveniles dialog");
      k.b(this, paramString.Vxt.wording, "", paramString.Vxt.VJn, paramString.Vxt.VJm, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(301363);
          Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lOk");
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramString);
          v.BI(1);
          AppMethodBeat.o(301363);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(301362);
          Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lCancel");
          v.BI(0);
          AppMethodBeat.o(301362);
        }
      });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(301428);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet_core.utils.g.class);
    AppMethodBeat.o(301428);
  }
  
  public static class a
    extends af
  {
    public x<String> VAS;
    public x<String> VAT;
    public x<emf> VAU;
    public x<String> VAV;
    public x<Boolean> VAW;
    public x<String> VAX;
    public x<String> VAY;
    public x<String> VAZ;
    public x<String> VBa;
    public x<String> VBb;
    public x<Profession> VBc;
    public x<Boolean> VBd;
    public x<String> VBe;
    public x<String> VBf;
    public x<Integer> VBg;
    public x<String> VBh;
    public x<String> VBi;
    public x<String> VBj;
    public x<String> VBk;
    
    public a()
    {
      AppMethodBeat.i(70101);
      this.VAS = new x();
      this.VAT = new x();
      this.VAU = new x();
      this.VAV = new x();
      this.VAW = new x();
      this.VAX = new x();
      this.VAY = new x();
      this.VAZ = new x();
      this.VBa = new x();
      this.VBb = new x();
      this.VBc = new x();
      this.VBd = new x();
      this.VBe = new x();
      this.VBf = new x();
      this.VBg = new x();
      this.VBh = new x();
      this.VBi = new x();
      this.VBj = new x();
      this.VBk = new x();
      this.VBg.setValue(Integer.valueOf(0));
      y local1 = new y()
      {
        public final void onChanged(Object paramAnonymousObject)
        {
          AppMethodBeat.i(70100);
          if (WcPayRealnameVerifyIdInputUI.a.a(WcPayRealnameVerifyIdInputUI.a.this))
          {
            WcPayRealnameVerifyIdInputUI.a.this.VBd.setValue(Boolean.TRUE);
            AppMethodBeat.o(70100);
            return;
          }
          WcPayRealnameVerifyIdInputUI.a.this.VBd.setValue(Boolean.FALSE);
          AppMethodBeat.o(70100);
        }
      };
      this.VAS.a(local1);
      this.VAV.a(local1);
      this.VBc.a(local1);
      this.VAX.a(local1);
      this.VAY.a(local1);
      this.VAZ.a(local1);
      this.VBe.a(local1);
      this.VBf.a(local1);
      this.VBg.a(local1);
      this.VBi.a(local1);
      this.VBj.a(local1);
      this.VBh.a(local1);
      this.VBk.a(local1);
      this.VAT.a(local1);
      AppMethodBeat.o(70101);
    }
    
    public final void M(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(174494);
      this.VAX.setValue(paramString1);
      this.VAY.setValue(paramString2);
      this.VAZ.setValue(paramString3);
      this.VBa.setValue(paramString4);
      AppMethodBeat.o(174494);
    }
    
    public final void a(emf paramemf)
    {
      AppMethodBeat.i(70102);
      this.VAU.setValue(paramemf);
      AppMethodBeat.o(70102);
    }
    
    public final void bgt(String paramString)
    {
      AppMethodBeat.i(301365);
      this.VAS.setValue(paramString);
      AppMethodBeat.o(301365);
    }
    
    public final void bgu(String paramString)
    {
      AppMethodBeat.i(301366);
      this.VBf.setValue(paramString);
      AppMethodBeat.o(301366);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI
 * JD-Core Version:    0.7.0.1
 */