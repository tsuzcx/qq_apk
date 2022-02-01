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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.l;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
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
  private static final int DiO;
  private WalletFormView DiP;
  private WalletFormView DiQ;
  private WalletFormView DiR;
  private WalletFormView DiS;
  private WalletFormView DiT;
  private WalletFormView DiU;
  private WalletFormView DiV;
  private WalletFormView DiW;
  private WalletFormView DiX;
  private c DiY;
  private TextView DiZ;
  private WalletFormView Dib;
  private WalletFormView Dic;
  private com.tencent.mm.ui.widget.picker.b Dja;
  private String Djb;
  private String Djc;
  private boolean Djd;
  private VM Dje;
  private String Djf;
  private String Djg;
  private String[] Djh;
  private List<crv> Dji;
  private din Djj;
  private String[] Djk;
  private int Djl;
  private int Djm;
  private int Djn;
  private int Djo;
  private int Djp;
  private int Djq;
  private int Djr;
  private int Djs;
  private int Djt;
  private String Dju;
  private TenpaySecureEncrypt Djv;
  private Button jtd;
  private TextView lHk;
  private Profession[] mProfessions;
  private WalletFormView yiw;
  
  static
  {
    AppMethodBeat.i(70117);
    DiO = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 88);
    AppMethodBeat.o(70117);
  }
  
  public WcPayRealnameVerifyIdInputUI()
  {
    AppMethodBeat.i(70104);
    this.Dji = new ArrayList();
    this.Djk = new String[100];
    int i = 0;
    while (i < this.Djk.length)
    {
      this.Djk[i] = ak.getContext().getString(2131765220, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    this.Djl = 0;
    this.Djm = 0;
    this.Djn = 0;
    this.Djo = 0;
    this.Djp = 0;
    this.Djq = 0;
    this.Djr = 0;
    this.Djs = 0;
    this.Djt = 0;
    this.Dju = "";
    this.Djv = new TenpaySecureEncrypt();
    AppMethodBeat.o(70104);
  }
  
  private void a(com.tencent.mm.plugin.wallet_core.id_verify.model.g paramg)
  {
    AppMethodBeat.i(70109);
    d locald = getProcess();
    Bundle localBundle = getInput();
    String str = paramg.token;
    ae.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify response succ");
    if (locald != null)
    {
      localBundle.putString("key_real_name_token", str);
      localBundle.putString("key_country_code", (String)this.Dje.DjL.getValue());
      localBundle.putString("key_province_code", (String)this.Dje.DjM.getValue());
      localBundle.putString("key_city_code", (String)this.Dje.DjN.getValue());
      localBundle.putParcelable("key_profession", (Parcelable)this.Dje.DjQ.getValue());
      localBundle.putBoolean("realname_verify_process_need_bind_card", paramg.Dkm);
      localBundle.putBoolean("realname_verify_process_need_face", paramg.Dkn);
      localBundle.putLong("realname_verify_process_face_scene", paramg.hmW);
      localBundle.putString("realname_verify_process_face_package", paramg.packageExt);
      localBundle.putString("realname_verify_process_face_package_sign", paramg.dGY);
      localBundle.putString("realname_verify_process_add_bank_word", paramg.Dkq);
      localBundle.putString("realname_verify_process_req_key", paramg.dwj);
      paramg = new RealNameBundle();
      paramg.DkG = ((String)this.Dje.DjG.getValue());
      paramg.DkH = this.Djf;
      paramg.DkI = this.Djg;
      paramg.DkJ = ((crv)this.Dje.DjI.getValue()).HCV.key;
      paramg.DkK = this.DiP.getText();
      paramg.DkL = ((Profession)this.Dje.DjQ.getValue());
      paramg.DkM = ((String)this.Dje.DjL.getValue());
      paramg.DkN = ((String)this.Dje.DjM.getValue());
      paramg.DkO = ((String)this.Dje.DjN.getValue());
      paramg.DkP = ((String)this.Dje.DjO.getValue());
      paramg.DkQ = ((Integer)this.Dje.DjU.getValue()).intValue();
      paramg.Dld = ((String)this.Dje.DjS.getValue());
      paramg.Dle = this.Djl;
      paramg.Dlf = this.Djm;
      paramg.Dlg = this.Djn;
      paramg.DkR = ((String)this.Dje.DjT.getValue());
      paramg.DkS = this.Djo;
      paramg.DkT = this.Djp;
      paramg.DkU = this.Djq;
      paramg.DkV = this.DiV.getText();
      paramg.DkW = this.Djr;
      paramg.DkX = this.Djs;
      paramg.DkY = this.Djt;
      paramg.DkZ = ((String)this.Dje.DjW.getValue());
      paramg.Dla = ((String)this.Dje.DjX.getValue());
      paramg.Dlb = this.Dju;
      paramg.Dlc = ((String)this.Dje.DjP.getValue());
      paramg.Dlh = ((String)this.Dje.DjY.getValue());
      if (!getString(2131763533).equals(this.Dje.DjH.getValue())) {
        break label640;
      }
    }
    label640:
    for (int i = 1;; i = 2)
    {
      paramg.eQV = i;
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
    this.yiw = ((WalletFormView)findViewById(2131307081));
    this.DiX = ((WalletFormView)findViewById(2131307085));
    this.DiP = ((WalletFormView)findViewById(2131307079));
    this.DiQ = ((WalletFormView)findViewById(2131307078));
    this.DiR = ((WalletFormView)findViewById(2131307077));
    this.DiS = ((WalletFormView)findViewById(2131307076));
    this.DiT = ((WalletFormView)findViewById(2131307075));
    this.DiU = ((WalletFormView)findViewById(2131307082));
    this.DiV = ((WalletFormView)findViewById(2131307074));
    this.Dib = ((WalletFormView)findViewById(2131307084));
    this.Dic = ((WalletFormView)findViewById(2131307073));
    this.DiW = ((WalletFormView)findViewById(2131307080));
    this.jtd = ((Button)findViewById(2131307083));
    this.lHk = ((TextView)findViewById(2131307087));
    this.DiZ = ((TextView)findViewById(2131307086));
    if (!bu.isNullOrNil(this.Djb)) {
      this.lHk.setText(this.Djb);
    }
    if (!bu.isNullOrNil(this.Djc))
    {
      this.DiZ.setText(this.Djc);
      this.DiZ.setVisibility(0);
    }
    this.yiw.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    int i = getResources().getDimensionPixelSize(2131165480);
    int j = getResources().getDimensionPixelSize(2131165274);
    Object localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).rightMargin = j;
    if ((this.Djj != null) && (!bu.isNullOrNil(this.Djj.HPF)))
    {
      this.yiw.setText(this.Djj.HPF);
      this.Dje.aFE(this.Djj.HPF);
      this.yiw.setContentTextColor(getResources().getColor(2131099735));
      this.yiw.setInputEnable(false);
      this.yiw.getInfoIv().setImageResource(2131690585);
      this.yiw.getInfoIv().setmUserSetImageIconColor(getResources().getColor(2131099735));
      this.yiw.getInfoIv().setVisibility(0);
      this.yiw.getInfoIv().setClickable(true);
      this.yiw.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(190173);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          ae.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "on click listener");
          paramAnonymousView = new com.tencent.mm.ui.widget.a.g(WcPayRealnameVerifyIdInputUI.this.getContext(), 1, 2);
          paramAnonymousView.ax(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).HPG);
          paramAnonymousView.c(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).HPI, WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).HPK);
          paramAnonymousView.a(new g.a()new g.a
          {
            public final void onClick()
            {
              AppMethodBeat.i(190171);
              f.aY(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).HPJ);
              paramAnonymousView.bqD();
              AppMethodBeat.o(190171);
            }
          }, new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(190172);
              paramAnonymousView.bqD();
              AppMethodBeat.o(190172);
            }
          });
          localObject = LayoutInflater.from(WcPayRealnameVerifyIdInputUI.this.getContext()).inflate(2131496532, null);
          ((TextView)((View)localObject).findViewById(2131308529)).setText(WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this).HPH);
          paramAnonymousView.setCustomView((View)localObject);
          paramAnonymousView.cPF();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(190173);
        }
      });
      this.DiP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190180);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "click cre type");
          WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).DjK.setValue(Boolean.TRUE);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(190180);
        }
      });
      this.DiP.getInfoIv().setClickable(false);
      this.DiP.getContentEt().setInputType(131073);
      this.DiQ.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.DiQ.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.DiQ.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
      com.tencent.mm.wallet_core.ui.formview.a.d(this.DiQ);
      this.DiQ.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(190181);
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramAnonymousEditable.toString());
          WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this, WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this).getText());
          paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
          String str = WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this);
          paramAnonymousEditable.DjJ.setValue(str);
          AppMethodBeat.o(190181);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.DiX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70094);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = WcPayRealnameVerifyIdInputUI.this.getResources().getStringArray(2130903102);
          paramAnonymousView = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.Lxq = new c.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(70093);
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2Object2 = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
                paramAnonymous2Object1 = (String)paramAnonymous2Object1;
                paramAnonymous2Object2.DjH.setValue(paramAnonymous2Object1);
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
      this.DiR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70096);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext());
          localObject = Calendar.getInstance();
          int i = ((Calendar)localObject).get(1);
          int j = ((Calendar)localObject).get(2) + 1;
          int k = ((Calendar)localObject).get(5);
          paramAnonymousView.aS(i, j, k);
          paramAnonymousView.aR(1900, 1, 1);
          paramAnonymousView.Lxi = new b.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(70095);
              if (paramAnonymous2Boolean)
              {
                ae.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "year: %s, month: %s, day: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                String str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
                WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).DjS.setValue(str);
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(70095);
            }
          };
          localObject = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).DjS.getValue();
          if ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
          {
            i = bu.getInt(((String)localObject).substring(0, 4), 0);
            j = bu.getInt(((String)localObject).substring(5, 7), 0);
            k = bu.getInt(((String)localObject).substring(9, 10), 0);
            if ((i > 0) && (j > 0) && (k > 0)) {
              paramAnonymousView.aQ(i, j, k);
            }
          }
          for (;;)
          {
            paramAnonymousView.show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70096);
            return;
            paramAnonymousView.aQ(i, j, k);
          }
        }
      });
      this.DiR.getInfoIv().setClickable(false);
      this.DiS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70097);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext()));
          paramAnonymousView = Calendar.getInstance();
          int i = paramAnonymousView.get(1);
          int j = paramAnonymousView.get(2) + 1;
          int k = paramAnonymousView.get(5);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).aQ(i, j, k);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).aR(i, j, k);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).aS(i + 200, 12, 31);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).setLongTermYear(true);
          WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).Lxi = new b.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(190182);
              String str;
              if (paramAnonymous2Boolean)
              {
                ae.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "year: %s, month: %s, day: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if (paramAnonymous2Int1 != 1) {
                  break label157;
                }
                str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(9999), Integer.valueOf(12), Integer.valueOf(31) });
                WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this, 9999);
                WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this, 12);
                WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this, 31);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).aFF(str);
              }
              for (;;)
              {
                WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).hide();
                AppMethodBeat.o(190182);
                return;
                label157:
                str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                WcPayRealnameVerifyIdInputUI.d(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
                WcPayRealnameVerifyIdInputUI.e(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
                WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).aFF(str);
              }
            }
          };
          paramAnonymousView = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).DjT.getValue();
          if ((!bu.isNullOrNil(paramAnonymousView)) && (paramAnonymousView.length() >= 8))
          {
            i = bu.getInt(paramAnonymousView.substring(0, 4), 0);
            j = bu.getInt(paramAnonymousView.substring(5, 7), 0);
            k = bu.getInt(paramAnonymousView.substring(8, 10), 0);
            if ((i > 0) && (j > 0) && (k > 0))
            {
              if (i != 9999) {
                break label291;
              }
              WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).aQ(1, 1, 1);
            }
          }
          for (;;)
          {
            WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70097);
            return;
            label291:
            WcPayRealnameVerifyIdInputUI.f(WcPayRealnameVerifyIdInputUI.this).aQ(i, j, k);
          }
        }
      });
      this.DiS.getInfoIv().setClickable(false);
      this.DiW.setInputType(3);
      this.DiW.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(190183);
          paramAnonymousEditable = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
          String str = WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this).getText();
          paramAnonymousEditable.DjY.setValue(str);
          AppMethodBeat.o(190183);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.DiT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70099);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this));
          paramAnonymousView.Lxq = new c.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(190184);
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2Object1 = WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this);
                int i = paramAnonymousView.fRg();
                paramAnonymous2Object1.DjU.setValue(Integer.valueOf(i));
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(190184);
            }
          };
          if (WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).DjU.getValue() != null) {
            paramAnonymousView.agm(((Integer)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).DjU.getValue()).intValue());
          }
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70099);
        }
      });
      this.DiT.getInfoIv().setClickable(false);
      this.DiV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(70076);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WcPayRealnameVerifyIdInputUI.this.getContext());
          localObject = Calendar.getInstance();
          int k = ((Calendar)localObject).get(1);
          int m = ((Calendar)localObject).get(2) + 1;
          int n = ((Calendar)localObject).get(5);
          paramAnonymousView.aQ(k, m, n);
          int j = k - 200;
          int i = j;
          if (j <= 0) {
            i = 1;
          }
          paramAnonymousView.aR(i, 1, 1);
          paramAnonymousView.aS(k, m, n);
          paramAnonymousView.Lxi = new b.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(190174);
              if (paramAnonymous2Boolean)
              {
                String str = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                WcPayRealnameVerifyIdInputUI.g(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int1);
                WcPayRealnameVerifyIdInputUI.h(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int2);
                WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this, paramAnonymous2Int3);
                WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).DjV.setValue(str);
              }
              paramAnonymousView.hide();
              AppMethodBeat.o(190174);
            }
          };
          localObject = (String)WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).DjV.getValue();
          if ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).length() >= 10))
          {
            i = bu.getInt(((String)localObject).substring(0, 4), 0);
            j = bu.getInt(((String)localObject).substring(5, 7), 0);
            k = bu.getInt(((String)localObject).substring(9, 10), 0);
            if ((i > 0) && (j > 0) && (k > 0)) {
              paramAnonymousView.aQ(i, j, k);
            }
          }
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70076);
        }
      });
      this.DiV.getInfoIv().setClickable(false);
      this.DiU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174477);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.setClassName(WcPayRealnameVerifyIdInputUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
          if (WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this) != null) {
            paramAnonymousView.putExtra("exclude_countries_iso", WcPayRealnameVerifyIdInputUI.i(WcPayRealnameVerifyIdInputUI.this));
          }
          paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
          paramAnonymousView.putExtra("ui_title", WcPayRealnameVerifyIdInputUI.this.getString(2131765859));
          WcPayRealnameVerifyIdInputUI.this.startActivityForResult(paramAnonymousView, 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174477);
        }
      });
      this.DiU.getInfoIv().setClickable(false);
      this.Dib.getContentEt().setInputType(131073);
      this.Dib.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174478);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
          WcPayRealnameVerifyIdInputUI.j(WcPayRealnameVerifyIdInputUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174478);
        }
      });
      this.Dib.getInfoIv().setClickable(false);
      this.Dic.getContentEt().setInputType(131073);
      this.Dic.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174479);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
      this.Dic.getInfoIv().setClickable(false);
      this.jtd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190175);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
          WcPayRealnameVerifyIdInputUI.n(WcPayRealnameVerifyIdInputUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(190175);
        }
      });
      this.yiw.fWE();
      this.Dje.DjK.observe(this, new Observer()
      {
        int iNL = 0;
      });
      this.Dje.DjI.observe(this, new Observer() {});
      this.Dje.DjS.observe(this, new Observer() {});
      this.Dje.DjT.observe(this, new Observer() {});
      this.Dje.DjH.observe(this, new Observer() {});
      this.Dje.DjU.observe(this, new Observer() {});
      this.Dje.DjV.observe(this, new Observer() {});
      this.Dje.DjO.observe(this, new Observer() {});
      this.Dje.DjP.observe(this, new Observer() {});
      this.Dje.DjX.observe(this, new Observer() {});
      this.Dje.DjQ.observe(this, new Observer() {});
      this.Dje.DjR.observe(this, new Observer() {});
      if (this.Dji.size() <= 0) {
        break label1265;
      }
      this.Dje.a((crv)this.Dji.get(0));
    }
    for (;;)
    {
      f.a(new WalletFormView[] { this.yiw, this.DiP, this.DiQ, this.Dib, this.Dic, this.DiR, this.DiS, this.DiT, this.DiU, this.DiV, this.DiW, this.DiX });
      AppMethodBeat.o(70106);
      return;
      this.yiw.getInfoIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.yiw.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.yiw.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
      this.yiw.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(190177);
          WcPayRealnameVerifyIdInputUI.c(WcPayRealnameVerifyIdInputUI.this).aFE(WcPayRealnameVerifyIdInputUI.b(WcPayRealnameVerifyIdInputUI.this).getText());
          AppMethodBeat.o(190177);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      break;
      label1265:
      localObject = this.DiQ.getLogicDelegate();
      if ((localObject instanceof a.a)) {
        ((a.a)localObject).ahb(-1);
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
        if (!bu.isNullOrNil(str1))
        {
          localStringBuilder.append(str1);
          localStringBuilder.append(" ");
        }
        if (!bu.isNullOrNil(str2))
        {
          localStringBuilder.append(str2);
          localStringBuilder.append(" ");
        }
        if (!bu.isNullOrNil(str3)) {
          localStringBuilder.append(str3);
        }
        this.Dje.A(str4, str5, paramIntent, localStringBuilder.toString());
        AppMethodBeat.o(70111);
        return;
      }
      ae.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no area choose!");
      AppMethodBeat.o(70111);
      return;
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        paramIntent = (Profession)paramIntent.getParcelableExtra("key_select_profession");
        this.Dje.DjQ.setValue(paramIntent);
        AppMethodBeat.o(70111);
        return;
      }
      ae.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no choose!");
      AppMethodBeat.o(70111);
      return;
    }
    if ((paramInt1 == 3) && (paramInt2 == 100))
    {
      if (!bu.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        str1 = paramIntent.getStringExtra("iso_code");
        str2 = paramIntent.getStringExtra("country_name");
        this.Dju = paramIntent.getStringExtra("couttry_code");
        paramIntent = this.Dje;
        paramIntent.DjW.setValue(str1);
        paramIntent.DjX.setValue(str2);
        AppMethodBeat.o(70111);
      }
    }
    else
    {
      if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.Dip);
        str2 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.Diq);
        str3 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.Dir);
        str4 = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.Dis);
        paramIntent = paramIntent.getStringExtra(WcPayRealnameInputAddressUI.Dit);
        this.Dje.A(str1, str2, str3, str4);
        this.Dje.DjP.setValue(paramIntent);
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
    this.Dje = ((VM)ViewModelProviders.of(this).get(VM.class));
    paramBundle = getInput().getString("realname_verify_process_get_wording_cache");
    try
    {
      if (!bu.isNullOrNil(paramBundle))
      {
        paramBundle = (bht)new bht().parseFrom(paramBundle.getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.Dji.addAll(paramBundle.GWf);
        this.Djb = paramBundle.Djb;
        this.Djc = paramBundle.Djc;
        this.Djj = paramBundle.GWh;
      }
      initView();
      ae.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "do get user ext info");
      doSceneForceProgress(new l());
      AppMethodBeat.o(70105);
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WcPayRealnameVerifyIdInputUI", paramBundle, "", new Object[0]);
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
      this.mProfessions = paramString.DkC;
      this.Djh = paramString.Djh;
    }
    while ((!(paramn instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.g)) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(70108);
      return false;
    }
    paramString = (com.tencent.mm.plugin.wallet_core.id_verify.model.g)paramn;
    if (paramString.Dgg == null) {
      a(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(70108);
      return true;
      ae.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify show juveniles dialog");
      h.e(this, paramString.Dgg.dyI, "", paramString.Dgg.DrJ, paramString.Dgg.DrI, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(174488);
          ae.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lOk");
          WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, paramString);
          u.tW(1);
          AppMethodBeat.o(174488);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(190179);
          ae.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lCancel");
          u.tW(0);
          AppMethodBeat.o(190179);
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
    public MutableLiveData<String> DjG;
    public MutableLiveData<String> DjH;
    public MutableLiveData<crv> DjI;
    public MutableLiveData<String> DjJ;
    public MutableLiveData<Boolean> DjK;
    public MutableLiveData<String> DjL;
    public MutableLiveData<String> DjM;
    public MutableLiveData<String> DjN;
    public MutableLiveData<String> DjO;
    public MutableLiveData<String> DjP;
    public MutableLiveData<Profession> DjQ;
    public MutableLiveData<Boolean> DjR;
    public MutableLiveData<String> DjS;
    public MutableLiveData<String> DjT;
    public MutableLiveData<Integer> DjU;
    public MutableLiveData<String> DjV;
    public MutableLiveData<String> DjW;
    public MutableLiveData<String> DjX;
    public MutableLiveData<String> DjY;
    
    public VM()
    {
      AppMethodBeat.i(70101);
      this.DjG = new MutableLiveData();
      this.DjH = new MutableLiveData();
      this.DjI = new MutableLiveData();
      this.DjJ = new MutableLiveData();
      this.DjK = new MutableLiveData();
      this.DjL = new MutableLiveData();
      this.DjM = new MutableLiveData();
      this.DjN = new MutableLiveData();
      this.DjO = new MutableLiveData();
      this.DjP = new MutableLiveData();
      this.DjQ = new MutableLiveData();
      this.DjR = new MutableLiveData();
      this.DjS = new MutableLiveData();
      this.DjT = new MutableLiveData();
      this.DjU = new MutableLiveData();
      this.DjV = new MutableLiveData();
      this.DjW = new MutableLiveData();
      this.DjX = new MutableLiveData();
      this.DjY = new MutableLiveData();
      this.DjU.setValue(Integer.valueOf(0));
      Observer local1 = new Observer()
      {
        public final void onChanged(Object paramAnonymousObject)
        {
          AppMethodBeat.i(70100);
          if (WcPayRealnameVerifyIdInputUI.VM.a(WcPayRealnameVerifyIdInputUI.VM.this))
          {
            WcPayRealnameVerifyIdInputUI.VM.this.DjR.setValue(Boolean.TRUE);
            AppMethodBeat.o(70100);
            return;
          }
          WcPayRealnameVerifyIdInputUI.VM.this.DjR.setValue(Boolean.FALSE);
          AppMethodBeat.o(70100);
        }
      };
      this.DjG.observeForever(local1);
      this.DjJ.observeForever(local1);
      this.DjQ.observeForever(local1);
      this.DjL.observeForever(local1);
      this.DjM.observeForever(local1);
      this.DjN.observeForever(local1);
      this.DjS.observeForever(local1);
      this.DjT.observeForever(local1);
      this.DjU.observeForever(local1);
      this.DjW.observeForever(local1);
      this.DjX.observeForever(local1);
      this.DjV.observeForever(local1);
      this.DjY.observeForever(local1);
      this.DjH.observeForever(local1);
      AppMethodBeat.o(70101);
    }
    
    public final void A(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(174494);
      this.DjL.setValue(paramString1);
      this.DjM.setValue(paramString2);
      this.DjN.setValue(paramString3);
      this.DjO.setValue(paramString4);
      AppMethodBeat.o(174494);
    }
    
    public final void a(crv paramcrv)
    {
      AppMethodBeat.i(70102);
      this.DjI.setValue(paramcrv);
      AppMethodBeat.o(70102);
    }
    
    public final void aFE(String paramString)
    {
      AppMethodBeat.i(190185);
      this.DjG.setValue(paramString);
      AppMethodBeat.o(190185);
    }
    
    public final void aFF(String paramString)
    {
      AppMethodBeat.i(190186);
      this.DjT.setValue(paramString);
      AppMethodBeat.o(190186);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI
 * JD-Core Version:    0.7.0.1
 */