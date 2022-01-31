package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.CreExtInfo;
import com.tencent.mm.plugin.wallet_core.model.CreTypeRuleInfo;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WalletCardElementUI
  extends WalletBaseUI
  implements TextView.OnEditorActionListener, WalletFormView.a
{
  private String countryCode;
  private String fHR;
  private String fnB;
  private String fnC;
  private Button gHb;
  private PayInfo mPayInfo;
  private Profession[] mProfessions;
  private int mSelectCreCountIndex;
  private String mTrueName;
  private String ogW;
  private String ogX;
  private Orders qrf;
  private TextView rUN;
  private Authen tVs;
  b tWD;
  private int tZB;
  private com.tencent.mm.sdk.b.c tZf;
  private WalletFormView tZx;
  private TextView tZy;
  private TextView tZz;
  private ElementQuery udb;
  private Profession udc;
  private String[] udv;
  private boolean uhG;
  private TextView unR;
  private TextView unS;
  private TextView unT;
  private TextView unU;
  private TextView unV;
  private TextView unW;
  private TextView unX;
  private TextView unY;
  private TextView unZ;
  private WalletFormView unh;
  private Bankcard unj;
  private CheckBox uoA;
  private String uoB;
  private boolean uoC;
  private boolean uoD;
  private boolean uoE;
  private boolean uoF;
  private boolean uoG;
  private boolean uoH;
  private String[] uoI;
  private String uoJ;
  private WalletFormView uoK;
  private List<ElementQuery> uoL;
  private int uoM;
  private int uoN;
  private int uoO;
  private int uoP;
  private int uoQ;
  private int uoR;
  private int uoS;
  private String uoT;
  private BaseAdapter uoU;
  private View.OnClickListener uoV;
  private WalletFormView uoa;
  private WalletFormView uob;
  private WalletFormView uoc;
  private WalletFormView uod;
  private WalletFormView uoe;
  private WalletFormView uof;
  private WalletFormView uog;
  private WalletFormView uoh;
  private WalletFormView uoi;
  private WalletFormView uoj;
  private WalletFormView uok;
  private WalletFormView uol;
  private WalletFormView uom;
  private WalletFormView uon;
  private WalletFormView uoo;
  private WalletFormView uop;
  private WalletFormView uoq;
  private WalletFormView uor;
  private WalletFormView uos;
  private WalletPhoneInputView uot;
  private ScrollView uou;
  private WalletFormView uov;
  private WalletFormView uow;
  private Map<String, b.a> uox;
  private boolean uoy;
  private CheckBox uoz;
  
  public WalletCardElementUI()
  {
    AppMethodBeat.i(47237);
    this.uov = null;
    this.udb = new ElementQuery();
    this.tVs = new Authen();
    this.qrf = null;
    this.mPayInfo = null;
    this.unj = null;
    this.uox = null;
    this.tWD = null;
    this.uoy = false;
    this.tZB = 1;
    this.uoE = false;
    this.uoF = false;
    this.uoG = false;
    this.uoH = false;
    this.uhG = false;
    this.uoI = null;
    this.uoL = new ArrayList();
    this.uoU = new WalletCardElementUI.8(this);
    this.uoV = new WalletCardElementUI.9(this);
    this.tZf = new WalletCardElementUI.10(this);
    AppMethodBeat.o(47237);
  }
  
  private void ID(int paramInt)
  {
    AppMethodBeat.i(47254);
    if (paramInt == 1)
    {
      setEditFocusListener(this.tZx, 1, false, false);
      AppMethodBeat.o(47254);
      return;
    }
    setEditFocusListener(this.tZx, 1, true, false);
    AppMethodBeat.o(47254);
  }
  
  private static void a(WalletFormView paramWalletFormView, int paramInt)
  {
    AppMethodBeat.i(47253);
    paramWalletFormView = paramWalletFormView.getLogicDelegate();
    if ((paramWalletFormView instanceof a.a)) {
      ((a.a)paramWalletFormView).RY(paramInt);
    }
    AppMethodBeat.o(47253);
  }
  
  private static void a(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(47242);
    if (!bo.isNullOrNil(paramString))
    {
      KeyListener localKeyListener = paramWalletFormView.getKeyListener();
      paramWalletFormView.setKeyListener(null);
      paramWalletFormView.setEnabled(false);
      paramWalletFormView.setClickable(false);
      paramWalletFormView.setText(paramString);
      paramWalletFormView.setKeyListener(localKeyListener);
      paramWalletFormView.setVisibility(0);
      AppMethodBeat.o(47242);
      return;
    }
    paramWalletFormView.setVisibility(8);
    AppMethodBeat.o(47242);
  }
  
  private static void a(boolean[] paramArrayOfBoolean, WalletFormView[] paramArrayOfWalletFormView, TextView paramTextView1, TextView paramTextView2)
  {
    AppMethodBeat.i(47245);
    a(paramArrayOfBoolean, paramArrayOfWalletFormView, paramTextView1, paramTextView2, false);
    AppMethodBeat.o(47245);
  }
  
  private static void a(boolean[] paramArrayOfBoolean, WalletFormView[] paramArrayOfWalletFormView, TextView paramTextView1, TextView paramTextView2, boolean paramBoolean)
  {
    AppMethodBeat.i(47244);
    int k = paramArrayOfBoolean.length;
    int i = 0;
    int j = 0;
    if (i < k)
    {
      if (paramArrayOfBoolean[i] != 0)
      {
        j = 1;
        paramArrayOfWalletFormView[i].setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        paramArrayOfWalletFormView[i].setVisibility(8);
        paramArrayOfWalletFormView[i].cfK();
      }
    }
    if (j != 0)
    {
      paramTextView1.setVisibility(0);
      if (paramTextView2 != null)
      {
        if (paramBoolean)
        {
          paramTextView2.setVisibility(8);
          AppMethodBeat.o(47244);
          return;
        }
        paramTextView2.setVisibility(4);
        AppMethodBeat.o(47244);
      }
    }
    else
    {
      paramTextView1.setVisibility(8);
      if (paramTextView2 != null) {
        paramTextView2.setVisibility(8);
      }
    }
    AppMethodBeat.o(47244);
  }
  
  private boolean asr()
  {
    AppMethodBeat.i(47249);
    WalletFormView localWalletFormView = this.uov;
    this.uov = null;
    if (!this.uoa.fE(null))
    {
      if ((this.uov == null) && (localWalletFormView != this.uoa)) {
        this.uov = this.uoa;
      }
      this.unU.setText(2131304904);
      this.unU.setTextColor(getResources().getColor(2131690391));
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (!this.unh.fE(null))
      {
        if ((this.uov == null) && (localWalletFormView != this.unh)) {
          this.uov = this.unh;
        }
        bool1 = false;
      }
      if (!this.uow.fE(this.unS))
      {
        if ((this.uov == null) && (localWalletFormView != this.uow)) {
          this.uov = this.uow;
        }
        bool1 = false;
      }
      int i;
      if ((!this.tZx.fE(this.tZz)) && (!this.uoy))
      {
        if ((this.uov == null) && (localWalletFormView != this.tZx)) {
          this.uov = this.tZx;
        }
        this.tZz.setText(2131304940);
        this.tZz.setTextColor(getResources().getColor(2131690391));
        i = 1;
      }
      for (boolean bool2 = false;; bool2 = bool1)
      {
        bool1 = bool2;
        if (this.uoE)
        {
          bool1 = bool2;
          if (!this.uoi.fE(null))
          {
            if ((this.uov == null) && (localWalletFormView != this.uoi)) {
              this.uov = this.uoi;
            }
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (this.uoF)
        {
          bool2 = bool1;
          if (!this.uoj.fE(null))
          {
            if ((this.uov == null) && (localWalletFormView != this.uoj)) {
              this.uov = this.uoj;
            }
            bool2 = false;
          }
        }
        if (!this.uof.fE(this.tZz)) {
          if (i != 0)
          {
            this.tZz.setText(2131304933);
            this.tZz.setTextColor(getResources().getColor(2131690391));
            if ((this.uov == null) && (localWalletFormView != this.uof)) {
              this.uov = this.uof;
            }
            bool1 = false;
            label401:
            if (this.tZz.getVisibility() == 4)
            {
              if (!this.udb.uhp) {
                break label1069;
              }
              this.tZz.setText(getString(2131304941));
              label436:
              this.tZz.setTextColor(getResources().getColor(2131690168));
              this.tZz.setVisibility(0);
            }
            if (this.uoc.fE(this.unW)) {
              break label1124;
            }
            if ((this.uov == null) && (localWalletFormView != this.uoc)) {
              this.uov = this.uoc;
            }
            i = 1;
            bool1 = false;
          }
        }
        for (;;)
        {
          if (!this.uob.fE(this.unW))
          {
            if ((this.uov == null) && (localWalletFormView != this.uob)) {
              this.uov = this.uob;
            }
            bool2 = false;
            label543:
            if (!this.uoz.isChecked()) {
              bool2 = false;
            }
            if (!this.uom.fE(this.unX))
            {
              if ((this.uov == null) && (localWalletFormView != this.uom)) {
                this.uov = this.uom;
              }
              bool2 = false;
            }
            if (!this.uon.fE(this.unX))
            {
              if ((this.uov == null) && (localWalletFormView != this.uon)) {
                this.uov = this.uon;
              }
              bool2 = false;
            }
            if (!this.uoo.fE(this.unX))
            {
              if ((this.uov == null) && (localWalletFormView != this.uoo)) {
                this.uov = this.uoo;
              }
              bool2 = false;
            }
            if (!this.uop.fE(this.unX))
            {
              if ((this.uov == null) && (localWalletFormView != this.uop)) {
                this.uov = this.uop;
              }
              bool2 = false;
            }
            if (!this.uoq.fE(this.unX))
            {
              if ((this.uov == null) && (localWalletFormView != this.uoq)) {
                this.uov = this.uoq;
              }
              bool2 = false;
            }
            if (!this.uor.fE(this.unX))
            {
              if ((this.uov == null) && (localWalletFormView != this.uor)) {
                this.uov = this.uor;
              }
              bool2 = false;
            }
            if (!this.uos.fE(this.unX))
            {
              if ((this.uov == null) && (localWalletFormView != this.uos)) {
                this.uov = this.uos;
              }
              bool2 = false;
            }
            bool1 = bool2;
            if (this.uoD)
            {
              bool1 = bool2;
              if (!this.uog.fE(null))
              {
                if ((this.uov == null) && (localWalletFormView != this.uog)) {
                  this.uov = this.uog;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.uoC)
            {
              bool2 = bool1;
              if (!this.uoh.fE(null))
              {
                if ((this.uov == null) && (localWalletFormView != this.uoh)) {
                  this.uov = this.uoh;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.uoG)
            {
              bool1 = bool2;
              if (!this.uok.fE(null))
              {
                if ((this.uov == null) && (localWalletFormView != this.uok)) {
                  this.uov = this.uok;
                }
                bool1 = false;
              }
            }
            if (!bool1) {
              break label1105;
            }
            this.gHb.setEnabled(true);
            this.gHb.setClickable(true);
            if (localWalletFormView != null) {
              localWalletFormView.setImeOptions(1073741824);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(47249);
            return bool1;
            this.tZz.setText(2131304934);
            this.tZz.setTextColor(getResources().getColor(2131690391));
            break;
            bool1 = bool2;
            if (i == 0) {
              break label401;
            }
            this.tZz.setVisibility(0);
            bool1 = bool2;
            break label401;
            label1069:
            this.tZz.setText(getString(2131304944));
            break label436;
            bool2 = bool1;
            if (i == 0) {
              break label543;
            }
            this.unW.setVisibility(4);
            bool2 = bool1;
            break label543;
            label1105:
            this.gHb.setEnabled(false);
            this.gHb.setClickable(false);
          }
          label1124:
          i = 0;
        }
        i = 0;
      }
    }
  }
  
  private void cVv()
  {
    int j = 0;
    AppMethodBeat.i(142501);
    Object localObject = getProcess();
    int i = j;
    if (localObject != null)
    {
      i = j;
      if ("realname_verify_process".equals(((com.tencent.mm.wallet_core.c)localObject).bzC()))
      {
        i = j;
        if (((com.tencent.mm.wallet_core.c)localObject).mEJ.getInt("real_name_verify_mode", 0) == 4) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      localObject = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      if (localObject != null)
      {
        this.udc = ((RealNameBundle)localObject).uex;
        this.mTrueName = ((RealNameBundle)localObject).ueu;
        this.countryCode = ((RealNameBundle)localObject).uey;
        this.fnC = ((RealNameBundle)localObject).uez;
        this.fnB = ((RealNameBundle)localObject).ueA;
        this.fHR = ((RealNameBundle)localObject).ueF;
        this.mSelectCreCountIndex = ((RealNameBundle)localObject).ueC;
        if ((this.udb != null) && (this.udb.cTw() != null) && (this.udb.cTw().contains(Integer.valueOf(((RealNameBundle)localObject).uew))))
        {
          this.tZB = ((RealNameBundle)localObject).uew;
          this.uoe.setText(com.tencent.mm.plugin.wallet_core.model.t.cTV().ab(this, this.tZB));
          this.tZx.setText(((RealNameBundle)localObject).uev);
          a(this.tZx, this.tZB);
          ID(this.tZB);
        }
        this.unh.setText(this.mTrueName);
        this.uoj.setText(((RealNameBundle)localObject).ueD);
        this.uoi.setText(this.udv[this.uoM]);
        this.uol.setText(((RealNameBundle)localObject).ueG);
        this.uoh.setText(((RealNameBundle)localObject).ueB);
        this.uok.setText(((RealNameBundle)localObject).ueE);
        if (this.udc != null) {
          this.uog.setText(this.udc.ues);
        }
      }
    }
    AppMethodBeat.o(142501);
  }
  
  private void cVw()
  {
    AppMethodBeat.i(47240);
    if (this.udb.uhR == 0)
    {
      this.uot.cWK();
      AppMethodBeat.o(47240);
      return;
    }
    this.uot.cWL();
    EditText localEditText = (EditText)this.uot.findViewById(2131829352);
    setEditFocusListener(this.uot.getPhoneNumberEt(), localEditText, 0, false, false, true);
    AppMethodBeat.o(47240);
  }
  
  private void cVx()
  {
    AppMethodBeat.i(47246);
    Object localObject1;
    boolean bool;
    if (asr())
    {
      d.cWY();
      if (!bo.isNullOrNil(this.udb.uhB))
      {
        localObject1 = getInput();
        if ((this.uoA.getVisibility() == 0) && (this.uoA.isChecked()))
        {
          bool = true;
          ((Bundle)localObject1).putBoolean("key_is_follow_bank_username", bool);
          getInput().putString("key_bank_username", this.udb.uhB);
        }
      }
      else
      {
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if ((this.udb != null) && (localObject1 != null) && (this.tWD != null) && (this.uox != null))
        {
          if (!this.uox.containsKey(this.udb.poq)) {
            break label1136;
          }
          ((FavorPayInfo)localObject1).uhU = ((b.a)this.uox.get(this.udb.poq)).umL.tUv;
          label168:
          getInput().putParcelable("key_favor_pay_info", (Parcelable)localObject1);
        }
        this.tVs = new Authen();
        if (this.unj != null)
        {
          this.tVs.por = this.unj.ufK;
          this.tVs.ufc = this.unj.field_bankcardTail;
        }
        localObject1 = getInput().getString("key_card_id");
        if (this.uow.getVisibility() != 0) {
          break label1187;
        }
        localObject1 = this.uow.getText();
      }
    }
    label522:
    label1171:
    label1187:
    for (;;)
    {
      this.tVs.pVo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.tVs.ueZ = ((String)localObject1);
      this.tVs.poq = this.udb.poq;
      this.tVs.ueY = this.tZB;
      this.tVs.ueW = getInput().getString("key_pwd1");
      if (!bo.isNullOrNil(this.uoc.getText())) {
        this.tVs.ufa = this.uoc.getText();
      }
      this.tVs.ubQ = this.uof.getText();
      this.tVs.ufe = this.uom.getText();
      this.tVs.uff = this.uon.getText();
      this.tVs.country = this.uoB;
      this.tVs.province = this.ogW;
      this.tVs.city = this.ogX;
      this.tVs.fBq = this.uop.getText();
      this.tVs.nLs = this.uoq.getText();
      this.tVs.gKS = this.uor.getText();
      this.tVs.dqF = this.uos.getText();
      localObject1 = e.awd(this.tVs.ubQ);
      getInput().putString("key_mobile", (String)localObject1);
      Object localObject2 = getInput();
      if (this.udb.ubU == 2)
      {
        bool = true;
        ((Bundle)localObject2).putBoolean("key_is_oversea", bool);
        this.tVs.ueX = this.tZx.getText();
        this.tVs.ueu = this.unh.getText();
        this.tVs.ufb = this.uob.getText();
        localObject2 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if (localObject2 != null)
        {
          this.tVs.ufg = ((FavorPayInfo)localObject2).uhX;
          this.tVs.ufh = ((FavorPayInfo)localObject2).uhU;
        }
        this.tVs.ufm = ("+" + this.uot.getCountryCode());
        this.tVs.ueC = this.mSelectCreCountIndex;
        this.tVs.ufn = this.uoj.getText();
        this.tVs.ueE = this.uok.getText();
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", new Object[] { Integer.valueOf(this.tVs.ueC), this.tVs.ufn, this.tVs.ueE });
        if ((cVz()) && (!bo.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!bo.isNullOrNil(getInput().getString("key_true_name"))))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
          this.tVs.ueX = getInput().getString("key_identity");
          this.tVs.ueY = getInput().getInt("key_id_type", -1);
          this.tVs.ueu = this.mTrueName;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.tVs.ueu);
        }
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.tVs.pVo + " elemt.bankcardTag : " + this.udb.ubU);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.udb.ubU);
        localObject2 = getInput();
        ((Bundle)localObject2).putString("key_mobile", (String)localObject1);
        ((Bundle)localObject2).putParcelable("key_authen", this.tVs);
        ((Bundle)localObject2).putString("key_bank_phone", this.udb.uhA);
        ((Bundle)localObject2).putString("key_country_code", this.countryCode);
        ((Bundle)localObject2).putString("key_province_code", this.fnC);
        ((Bundle)localObject2).putString("key_city_code", this.fnB);
        ((Bundle)localObject2).putParcelable("key_profession", this.udc);
        ((Bundle)localObject2).putString("key_country_iso", this.fHR);
        ((Bundle)localObject2).putString("key_bind_card_type", this.tVs.poq);
        ((Bundle)localObject2).putString("key_bind_card_show1", this.udb.nLq);
        if (2 != this.udb.uhx) {
          break label1160;
        }
      }
      for (localObject1 = getString(2131305029);; localObject1 = getString(2131305049))
      {
        ((Bundle)localObject2).putString("key_bind_card_show2", (String)localObject1);
        if (!getNetController().p(new Object[] { this.tVs, this.qrf })) {
          break label1171;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
        AppMethodBeat.o(47246);
        return;
        bool = false;
        break;
        label1136:
        ((FavorPayInfo)localObject1).uhU = this.tWD.bJ(((FavorPayInfo)localObject1).uhU, false);
        break label168;
        bool = false;
        break label522;
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(47246);
      return;
    }
  }
  
  private void cVy()
  {
    AppMethodBeat.i(47255);
    Object localObject;
    if ((this.udb != null) && (this.uox != null) && (this.uox.containsKey(this.udb.poq)))
    {
      localObject = (b.a)this.uox.get(this.udb.poq);
      if ((localObject == null) || (((b.a)localObject).umL == null)) {
        break label133;
      }
    }
    label133:
    for (double d = ((b.a)localObject).umM;; d = 0.0D)
    {
      localObject = getString(2131304903, new Object[] { e.F(d) });
      this.unY.setText((CharSequence)localObject);
      this.unY.setVisibility(0);
      AppMethodBeat.o(47255);
      return;
      this.unY.setVisibility(8);
      AppMethodBeat.o(47255);
      return;
    }
  }
  
  private boolean cVz()
  {
    AppMethodBeat.i(47256);
    boolean bool = getInput().getBoolean("key_is_forgot_process", false);
    AppMethodBeat.o(47256);
    return bool;
  }
  
  private void gJ(boolean paramBoolean)
  {
    AppMethodBeat.i(142502);
    if (this.udb == null) {
      this.udb = new ElementQuery();
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "element: %s, %s", new Object[] { this.udb.nLq, this.udb.poq });
    cVw();
    cVy();
    com.tencent.mm.wallet_core.a.aM(this);
    Object localObject1 = (Bankcard)getInput().getParcelable("key_bankcard");
    Object localObject2;
    Object localObject3;
    if ((cVz()) && (localObject1 != null))
    {
      this.uow.setHint(getString(2131304938, new Object[] { ((Bankcard)localObject1).field_bankcardTail }));
      localObject1 = this.uow;
      localObject2 = this.unR;
      localObject3 = this.unS;
      a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
      localObject1 = this.uoa;
      localObject2 = this.unT;
      localObject3 = this.unU;
      a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
    }
    for (;;)
    {
      this.uoE = false;
      this.uoF = false;
      this.uoG = false;
      this.uoH = false;
      if ((this.udb.uhS == null) || (this.udb.uhS.isEmpty())) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "identity type： %s", new Object[] { Integer.valueOf(this.tZB) });
      localObject1 = this.udb.uhS.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CreTypeRuleInfo)((Iterator)localObject1).next();
        if (((CreTypeRuleInfo)localObject2).ugV == this.tZB)
        {
          if (((CreTypeRuleInfo)localObject2).ugW.ugR == 1)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "need show cre count");
            this.uoE = true;
          }
          if (((CreTypeRuleInfo)localObject2).ugW.ugT == 1)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "need show cre expire");
            this.uoF = true;
          }
          if (((CreTypeRuleInfo)localObject2).ugW.ugS == 1)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "need show birthday");
            this.uoG = true;
          }
          if (((CreTypeRuleInfo)localObject2).ugW.ugU == 1)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "need show cre type");
            if (com.tencent.mm.plugin.wallet_core.model.t.cTN().cUv() > 0)
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
              this.uoH = true;
            }
          }
        }
      }
      if (!bo.isNullOrNil(this.udb.nLq))
      {
        this.uoa.setText(this.udb.nLq);
        if (!this.udb.cTh()) {
          break label635;
        }
        this.uoK.setVisibility(0);
        this.uoK.setText(getString(2131305029));
      }
      for (;;)
      {
        localObject1 = this.uow;
        localObject2 = this.unR;
        localObject3 = this.unS;
        a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        localObject1 = this.uoa;
        localObject2 = this.unT;
        localObject3 = this.unU;
        a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        this.uow.setOnInfoIvClickListener(this.uoV);
        if (!com.tencent.mm.plugin.wallet_core.model.t.cTN().cUt().cUc()) {
          break label670;
        }
        this.uow.getInfoIv().setImageResource(2131232197);
        this.uow.getInfoIv().setVisibility(0);
        break;
        label635:
        if (this.udb.cTv())
        {
          this.uoK.setVisibility(0);
          this.uoK.setText(getString(2131305049));
        }
      }
      label670:
      this.uow.getInfoIv().setVisibility(4);
    }
    if (!this.uoF)
    {
      this.uoN = 0;
      this.uoO = 0;
      this.uoP = 0;
    }
    if (!this.uoG)
    {
      this.uoQ = 0;
      this.uoR = 0;
      this.uoS = 0;
    }
    if (!this.uoE) {
      this.mSelectCreCountIndex = 0;
    }
    this.uod.setVisibility(8);
    Object localObject4;
    Object localObject5;
    TextView localTextView1;
    TextView localTextView2;
    boolean bool2;
    boolean bool1;
    if (Bankcard.Ix(this.udb.ubU))
    {
      localObject1 = this.unh;
      localObject2 = this.uoe;
      localObject3 = this.tZx;
      localObject4 = this.uoi;
      localObject5 = this.uoj;
      localTextView1 = this.tZy;
      localTextView2 = this.tZz;
      a(new boolean[] { 0, 0, 0, 0, 0 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localObject5 }, localTextView1, localTextView2);
      this.uof.setVisibility(8);
      nJ(true);
      bool2 = this.uoG;
      if ((this.tZB == 2) && (this.uhG))
      {
        bool1 = true;
        localObject1 = this.uoh;
        localObject2 = this.uog;
        localObject3 = this.uok;
        localObject4 = this.uol;
        localObject5 = this.unZ;
        a(new boolean[] { false, false, bool2, bool1 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4 }, (TextView)localObject5, null);
        if (paramBoolean) {
          cVv();
        }
        paramBoolean = this.udb.uhr;
        bool1 = this.udb.uhs;
        localObject1 = this.uoc;
        localObject2 = this.uob;
        localObject3 = this.unV;
        localObject4 = this.unW;
        a(new boolean[] { paramBoolean, bool1 }, new WalletFormView[] { localObject1, localObject2 }, (TextView)localObject3, (TextView)localObject4);
        if (this.uoa.getVisibility() != 0) {
          break label2611;
        }
        switch (this.udb.uhw)
        {
        default: 
          this.unU.setVisibility(8);
          label1125:
          this.unU.setTextColor(getResources().getColor(2131690318));
        }
      }
    }
    for (;;)
    {
      if ((!bo.isNullOrNil(this.udb.uhQ)) && (this.unU.getVisibility() != 0))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
        this.unU.setText(this.udb.uhQ);
        this.unU.setVisibility(0);
      }
      if ((bo.isNullOrNil(this.udb.uhB)) || (!com.tencent.mm.model.t.nT(this.udb.uhB)) || (cVz())) {
        break label2623;
      }
      this.uoA.setText(this.udb.uhC);
      this.uoA.setVisibility(0);
      AppMethodBeat.o(142502);
      return;
      bool1 = false;
      break;
      int i;
      label1290:
      label1399:
      boolean bool3;
      label1731:
      boolean bool4;
      if ((this.udb.cTw() != null) && (this.udb.cTw().size() > 0))
      {
        i = 1;
        if ((!cVz()) && (!com.tencent.mm.plugin.wallet_core.model.t.cTN().cUn())) {
          break label2124;
        }
        localObject2 = com.tencent.mm.plugin.wallet_core.model.t.cTN().getTrueName();
        localObject1 = localObject2;
        if (bo.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          if (getProcess() != null) {
            localObject1 = getProcess().mEJ.getString("key_true_name");
          }
        }
        if (bo.isNullOrNil((String)localObject1)) {
          break label1958;
        }
        localObject1 = getString(2131304988, new Object[] { e.awc((String)localObject1) });
        this.unh.setHint((CharSequence)localObject1);
        this.uod.setHint((CharSequence)localObject1);
        if ((!cVz()) || (bo.isNullOrNil(getInput().getString("key_identity"))) || (getInput().getInt("key_id_type", -1) == -1) || (bo.isNullOrNil(getInput().getString("key_true_name")))) {
          break label1988;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
        bool1 = this.uoE;
        bool2 = this.uoF;
        localObject1 = this.unh;
        localObject2 = this.uoe;
        localObject3 = this.tZx;
        localObject4 = this.uoi;
        localObject5 = this.uoj;
        localTextView1 = this.tZy;
        localTextView2 = this.tZz;
        a(new boolean[] { false, false, false, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localObject5 }, localTextView1, localTextView2);
        this.mTrueName = getInput().getString("key_true_name");
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "name is " + this.mTrueName);
        this.uof.setVisibility(0);
        if (this.unj != null)
        {
          if (!bo.isNullOrNil(this.unj.field_mobile)) {
            a(this.uof, this.unj.field_mobile);
          }
          if (!bo.isNullOrNil(this.unj.ufa)) {
            a(this.uoc, this.unj.ufa);
          }
          if (!bo.isNullOrNil(this.unj.ufJ)) {
            a(this.uob, this.unj.ufJ);
          }
        }
        if (!this.udb.uhp) {
          break label2343;
        }
        this.tZz.setText("");
        this.tZx.setText(this.udb.uht);
        if (com.tencent.mm.plugin.wallet_core.model.t.cTN().cUv() <= 0) {
          break label2360;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.wallet_core.model.t.cTN().cUv()) });
        this.uoe.setClickable(false);
        this.uoe.setText(com.tencent.mm.plugin.wallet_core.model.t.cTV().fq(this));
        this.uoe.setInputEnable(false);
        a(this.tZx, this.tZB);
        ID(this.tZB);
        nJ(false);
        bool2 = this.uoC;
        bool3 = this.uoD;
        bool4 = this.uoG;
        if ((this.tZB != 2) || (!this.uhG)) {
          break label2549;
        }
      }
      label1958:
      label1988:
      label2124:
      label2549:
      for (bool1 = true;; bool1 = false)
      {
        localObject1 = this.uoh;
        localObject2 = this.uog;
        localObject3 = this.uok;
        localObject4 = this.uol;
        localObject5 = this.unZ;
        a(new boolean[] { bool2, bool3, bool4, bool1 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4 }, (TextView)localObject5, null);
        break;
        i = 0;
        break label1290;
        localObject1 = getString(2131304987);
        this.unh.setHint((CharSequence)localObject1);
        this.uod.setHint((CharSequence)localObject1);
        break label1399;
        if ((this.uoH) || (i != 0)) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = this.uoE;
          bool3 = this.uoF;
          localObject1 = this.unh;
          localObject2 = this.uoe;
          localObject3 = this.tZx;
          localObject4 = this.uoi;
          localObject5 = this.uoj;
          localTextView1 = this.tZy;
          localTextView2 = this.tZz;
          a(new boolean[] { true, bool1, true, bool2, bool3 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localObject5 }, localTextView1, localTextView2);
          break;
        }
        bool2 = this.udb.uhp;
        if ((this.uoH) || ((i != 0) && (this.udb.uhq))) {}
        for (bool1 = true;; bool1 = false)
        {
          bool3 = this.udb.uhq;
          bool4 = this.uoE;
          boolean bool5 = this.uoF;
          localObject1 = this.unh;
          localObject2 = this.uoe;
          localObject3 = this.tZx;
          localObject4 = this.uoi;
          localObject5 = this.uoj;
          localTextView1 = this.tZy;
          localTextView2 = this.tZz;
          a(new boolean[] { bool2, bool1, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localObject5 }, localTextView1, localTextView2);
          this.uof.setVisibility(0);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.udb.uhp + " canModifyIdentity:" + this.udb.uhq);
          break;
        }
        this.tZz.setText(getString(2131304944));
        break label1731;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", new Object[] { Integer.valueOf(this.uoU.getCount()) });
        if (this.uoU.getCount() <= 1)
        {
          this.uoe.setClickable(false);
          this.uoe.setInputEnable(false);
          this.tZx.setInputEnable(true);
        }
        for (;;)
        {
          localObject1 = this.udb.cTw();
          if ((localObject1 == null) || (!((List)localObject1).contains(Integer.valueOf(this.tZB)))) {
            this.tZB = 1;
          }
          if (!com.tencent.mm.plugin.wallet_core.model.t.cTV().ab(this, this.tZB).equals(this.uoT)) {
            com.tencent.mm.plugin.report.service.h.qsU.e(16816, new Object[] { Integer.valueOf(this.tZB) });
          }
          this.uoe.setText(com.tencent.mm.plugin.wallet_core.model.t.cTV().ab(this, this.tZB));
          break;
          this.uoe.setClickable(true);
          this.uoe.setInputEnable(true);
          this.tZx.setInputEnable(true);
        }
      }
      label2343:
      label2360:
      this.unU.setText(2131304909);
      this.unU.setVisibility(0);
      break label1125;
      this.unU.setVisibility(8);
      break label1125;
      this.unU.setVisibility(8);
      break label1125;
      this.unU.setVisibility(8);
      break label1125;
      label2611:
      this.unU.setVisibility(8);
    }
    label2623:
    this.uoA.setVisibility(8);
    AppMethodBeat.o(142502);
  }
  
  private void nJ(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(47243);
    if (paramBoolean)
    {
      Object localObject = this.rUN;
      if (this.udb.uhE)
      {
        i = 0;
        ((TextView)localObject).setVisibility(i);
        localObject = this.uom;
        if (!this.udb.uhE) {
          break label225;
        }
        i = 0;
        label54:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.uon;
        if (!this.udb.uhF) {
          break label231;
        }
        i = 0;
        label78:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.uoo;
        if (!this.udb.uhG) {
          break label237;
        }
        i = 0;
        label102:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.uop;
        if (!this.udb.uhJ) {
          break label243;
        }
        i = 0;
        label126:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.uoq;
        if (!this.udb.uhL) {
          break label249;
        }
        i = 0;
        label150:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.uor;
        if (!this.udb.uhK) {
          break label255;
        }
        i = 0;
        label174:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.uos;
        if (!this.udb.uhM) {
          break label261;
        }
      }
      label261:
      for (int i = j;; i = 8)
      {
        ((WalletFormView)localObject).setVisibility(i);
        this.unX.setVisibility(4);
        AppMethodBeat.o(47243);
        return;
        i = 8;
        break;
        label225:
        i = 8;
        break label54;
        label231:
        i = 8;
        break label78;
        label237:
        i = 8;
        break label102;
        label243:
        i = 8;
        break label126;
        label249:
        i = 8;
        break label150;
        label255:
        i = 8;
        break label174;
      }
    }
    this.rUN.setVisibility(8);
    this.uom.setVisibility(8);
    this.uon.setVisibility(8);
    this.uoo.setVisibility(8);
    this.uop.setVisibility(8);
    this.uoq.setVisibility(8);
    this.uor.setVisibility(8);
    this.uos.setVisibility(8);
    this.unX.setVisibility(8);
    AppMethodBeat.o(47243);
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971155;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47239);
    this.unR = ((TextView)findViewById(2131829042));
    this.uow = ((WalletFormView)findViewById(2131829044));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.uow);
    this.unS = ((TextView)findViewById(2131829045));
    this.tZy = ((TextView)findViewById(2131829050));
    this.unh = ((WalletFormView)findViewById(2131829013));
    this.uod = ((WalletFormView)findViewById(2131829043));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.unh);
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.uod);
    this.uoe = ((WalletFormView)findViewById(2131829051));
    this.tZx = ((WalletFormView)findViewById(2131829052));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.tZx);
    this.tZz = ((TextView)findViewById(2131829061));
    this.unT = ((TextView)findViewById(2131823479));
    this.uoa = ((WalletFormView)findViewById(2131829046));
    this.uoK = ((WalletFormView)findViewById(2131823480));
    this.unU = ((TextView)findViewById(2131829048));
    this.unY = ((TextView)findViewById(2131829047));
    this.unV = ((TextView)findViewById(2131829049));
    this.uoc = ((WalletFormView)findViewById(2131826695));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.uoc);
    this.uob = ((WalletFormView)findViewById(2131826697));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.uob);
    this.unW = ((TextView)findViewById(2131826696));
    this.rUN = ((TextView)findViewById(2131829062));
    this.uom = ((WalletFormView)findViewById(2131829063));
    this.uon = ((WalletFormView)findViewById(2131829064));
    this.uoo = ((WalletFormView)findViewById(2131829065));
    this.uop = ((WalletFormView)findViewById(2131829066));
    this.uoq = ((WalletFormView)findViewById(2131829067));
    this.uor = ((WalletFormView)findViewById(2131829068));
    this.uos = ((WalletFormView)findViewById(2131829069));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.uos);
    this.unX = ((TextView)findViewById(2131829070));
    this.uoz = ((CheckBox)findViewById(2131829071));
    this.uoA = ((CheckBox)findViewById(2131829072));
    this.gHb = ((Button)findViewById(2131822914));
    this.uou = ((ScrollView)findViewById(2131823477));
    this.uog = ((WalletFormView)findViewById(2131829056));
    this.uoh = ((WalletFormView)findViewById(2131829057));
    this.uoi = ((WalletFormView)findViewById(2131829054));
    this.uoj = ((WalletFormView)findViewById(2131829053));
    this.uok = ((WalletFormView)findViewById(2131829058));
    this.uol = ((WalletFormView)findViewById(2131829059));
    this.unZ = ((TextView)findViewById(2131829055));
    this.uot = ((WalletPhoneInputView)findViewById(2131829060));
    this.uof = this.uot.getPhoneNumberEt();
    this.unh.setOnInputValidChangeListener(this);
    this.uod.setOnInputValidChangeListener(this);
    this.uow.setOnInputValidChangeListener(this);
    this.uoe.setOnInputValidChangeListener(this);
    this.tZx.setOnInputValidChangeListener(this);
    this.uof.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(47211);
        if (!paramAnonymousBoolean)
        {
          WalletCardElementUI.a(WalletCardElementUI.this);
          WalletCardElementUI.this.getInput().putParcelable("key_history_bankcard", null);
        }
        WalletCardElementUI.b(WalletCardElementUI.this);
        AppMethodBeat.o(47211);
      }
    });
    this.uoc.setOnInputValidChangeListener(this);
    this.uob.setOnInputValidChangeListener(this);
    this.uom.setOnInputValidChangeListener(this);
    this.uon.setOnInputValidChangeListener(this);
    this.uoo.setOnInputValidChangeListener(this);
    this.uop.setOnInputValidChangeListener(this);
    this.uoq.setOnInputValidChangeListener(this);
    this.uor.setOnInputValidChangeListener(this);
    this.uos.setOnInputValidChangeListener(this);
    this.uog.setOnInputValidChangeListener(this);
    this.uoh.setOnInputValidChangeListener(this);
    this.unh.setOnEditorActionListener(this);
    this.uod.setOnEditorActionListener(this);
    this.uow.setOnEditorActionListener(this);
    this.uoe.setOnEditorActionListener(this);
    this.tZx.setOnEditorActionListener(this);
    this.uof.setOnEditorActionListener(this);
    this.uoc.setOnEditorActionListener(this);
    this.uob.setOnEditorActionListener(this);
    this.uom.setOnEditorActionListener(this);
    this.uon.setOnEditorActionListener(this);
    this.uoo.setOnEditorActionListener(this);
    this.uop.setOnEditorActionListener(this);
    this.uoq.setOnEditorActionListener(this);
    this.uor.setOnEditorActionListener(this);
    this.uos.setOnEditorActionListener(this);
    this.uoh.setOnEditorActionListener(this);
    this.uog.setOnEditorActionListener(this);
    this.uoa.setOnClickListener(new WalletCardElementUI.11(this));
    this.uoK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47227);
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(WalletCardElementUI.this.getString(2131305049));
        paramAnonymousView.add(WalletCardElementUI.this.getString(2131305029));
        ElementQuery localElementQuery;
        if (WalletCardElementUI.d(WalletCardElementUI.this).size() == 1)
        {
          localElementQuery = (ElementQuery)WalletCardElementUI.d(WalletCardElementUI.this).get(0);
          if (!localElementQuery.cTv()) {
            break label154;
          }
          paramAnonymousView.remove(1);
        }
        for (;;)
        {
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.Rw(WalletCardElementUI.e(WalletCardElementUI.this));
          paramAnonymousView.AIW = new WalletCardElementUI.12.1(this, paramAnonymousView);
          paramAnonymousView.Rv(com.tencent.mm.cb.a.fromDPToPix(WalletCardElementUI.this.getContext(), 288));
          paramAnonymousView.show();
          AppMethodBeat.o(47227);
          return;
          label154:
          if (localElementQuery.cTh()) {
            paramAnonymousView.remove(0);
          }
        }
      }
    });
    this.uoe.setOnClickListener(new WalletCardElementUI.13(this));
    this.uoi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47230);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext(), WalletCardElementUI.h(WalletCardElementUI.this));
        paramAnonymousView.AIW = new WalletCardElementUI.14.1(this, paramAnonymousView);
        paramAnonymousView.Rw(WalletCardElementUI.j(WalletCardElementUI.this));
        paramAnonymousView.show();
        AppMethodBeat.o(47230);
      }
    });
    this.uoj.setOnClickListener(new WalletCardElementUI.15(this));
    this.uoh.setOnClickListener(new WalletCardElementUI.16(this));
    this.uog.setOnClickListener(new WalletCardElementUI.17(this));
    this.uok.setOnClickListener(new WalletCardElementUI.18(this));
    this.uol.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47212);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WalletCardElementUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        paramAnonymousView.putExtra("exclude_countries_iso", WalletCardElementUI.u(WalletCardElementUI.this));
        paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
        paramAnonymousView.putExtra("ui_title", WalletCardElementUI.this.getString(2131305640));
        WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 6);
        AppMethodBeat.o(47212);
      }
    });
    this.uoz.setChecked(true);
    this.uoz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(47213);
        WalletCardElementUI.b(WalletCardElementUI.this);
        AppMethodBeat.o(47213);
      }
    });
    findViewById(2131826245).setOnClickListener(new WalletCardElementUI.4(this));
    this.uoo.setOnClickListener(new WalletCardElementUI.5(this));
    this.gHb.setOnClickListener(new WalletCardElementUI.6(this));
    setEditFocusListener(this.uow, 0, false);
    setEditFocusListener(this.tZx, 1, false);
    setEditFocusListener(this.uof, 0, false, true, true);
    if ((this.udb != null) && (!bo.isNullOrNil(this.udb.uhD)))
    {
      com.tencent.mm.ui.base.h.a(this, this.udb.uhD, null, true, null);
      this.udb = null;
    }
    for (;;)
    {
      gJ(true);
      asr();
      this.uof.dTc();
      Object localObject = com.tencent.mm.wallet_core.a.aM(this);
      if ((localObject == null) || (!((com.tencent.mm.wallet_core.c)localObject).dRQ())) {
        break label1401;
      }
      localObject = (Orders)getInput().getParcelable("key_orders");
      if ((localObject == null) || (((Orders)localObject).uiW != 1)) {
        break;
      }
      this.uoy = true;
      this.unh.setText(e.awc(((Orders)localObject).ueu));
      this.unh.setEnabled(false);
      this.unh.setFocusable(false);
      this.tZB = ((Orders)localObject).uiX;
      this.uoe.setText(com.tencent.mm.plugin.wallet_core.model.t.cTV().ab(this, this.tZB));
      this.uoe.setEnabled(false);
      this.tZx.setText(((Orders)localObject).uht);
      this.tZx.setInputEnable(false);
      this.tZx.setFocusable(false);
      this.tZy.setText(2131304902);
      AppMethodBeat.o(47239);
      return;
      if ((getInput().getInt("key_bind_scene", -1) == 5) && (!this.udb.uhT))
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131305751), null, true, null);
        this.udb.nLq = null;
      }
    }
    this.uoy = false;
    label1401:
    AppMethodBeat.o(47239);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47248);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (this.uot.e(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(47248);
      return;
    }
    if ((paramInt1 == 6) && (paramInt2 == 100))
    {
      if (!bo.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        this.fHR = paramIntent.getStringExtra("iso_code");
        this.uol.setText(paramIntent.getStringExtra("country_name"));
      }
      AppMethodBeat.o(47248);
      return;
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(47248);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      asr();
      AppMethodBeat.o(47248);
      return;
      this.udb = null;
      this.uoM = 0;
      this.uoJ = paramIntent.getStringExtra("bank_name");
      this.uoa.setText(this.uoJ);
      this.uoK.setVisibility(0);
      this.uoK.setText("");
      paramIntent = com.tencent.mm.plugin.wallet_core.model.t.cTV().ubS;
      this.uoL.clear();
      if (paramIntent != null)
      {
        paramIntent = paramIntent.iterator();
        do
        {
          do
          {
            if (!paramIntent.hasNext()) {
              break;
            }
            localObject = (ElementQuery)paramIntent.next();
          } while (!((ElementQuery)localObject).nLq.equals(this.uoJ));
          this.uoL.add(localObject);
          if ((getInput().getInt("key_bind_scene", -1) == 5) && (!((ElementQuery)localObject).uhT)) {
            ((ElementQuery)localObject).uhD = getString(2131305749);
          }
        } while (this.uoL.size() < 2);
      }
      if (this.uoL.size() == 1) {
        this.udb = ((ElementQuery)this.uoL.get(0));
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "select bank: %s, %s", new Object[] { this.uoJ, Integer.valueOf(this.uoL.size()) });
      this.unj = null;
      gJ(false);
      continue;
      Object localObject = paramIntent.getStringExtra("CountryName");
      String str1 = paramIntent.getStringExtra("Country");
      this.uoB = ((String)localObject + "|" + str1);
      String str2 = paramIntent.getStringExtra("ProviceName");
      String str3 = paramIntent.getStringExtra("CityName");
      if (!bo.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.ogW = (str2 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.ogX = (str3 + "|" + paramIntent.getStringExtra("Contact_City"));
        if (bo.isNullOrNil((String)localObject))
        {
          this.uoo.setText(str2 + " " + str3);
          label600:
          if ((!"US".equals(str1)) && (!"CA".equals(str1)) && (!this.udb.uhK)) {
            break label823;
          }
          this.uor.setVisibility(0);
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", new Object[] { localObject, str1, str2, str3, this.ogX });
        break;
        this.uoo.setText((String)localObject + " " + str3);
        break label600;
        if (!bo.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.ogX = (str2 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.uoo.setText((String)localObject + " " + str2);
          break label600;
        }
        this.ogX = this.uoB;
        this.uoo.setText((String)localObject);
        break label600;
        label823:
        this.uor.setVisibility(8);
      }
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.uow.set3DesValStr(paramIntent);
      continue;
      localObject = paramIntent.getStringExtra("CountryName");
      str1 = paramIntent.getStringExtra("ProviceName");
      str2 = paramIntent.getStringExtra("CityName");
      this.countryCode = paramIntent.getStringExtra("Country");
      this.fnC = paramIntent.getStringExtra("Contact_Province");
      this.fnB = paramIntent.getStringExtra("Contact_City");
      paramIntent = new StringBuilder();
      if (!bo.isNullOrNil((String)localObject)) {
        paramIntent.append((String)localObject);
      }
      if (!bo.isNullOrNil(str1)) {
        paramIntent.append(" ").append(str1);
      }
      if (!bo.isNullOrNil(str2)) {
        paramIntent.append(" ").append(str2);
      }
      this.uoh.setText(paramIntent.toString());
      continue;
      this.udc = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
      this.uog.setText(this.udc.ues);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47238);
    super.onCreate(paramBundle);
    this.udb = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.qrf = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.tZB = com.tencent.mm.plugin.wallet_core.model.t.cTN().cUv();
    this.unj = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
    this.uoC = getInput().getBoolean("key_need_area", false);
    this.uoD = getInput().getBoolean("key_need_profession", false);
    this.uhG = getInput().getBoolean("key_need_country", false);
    this.uoI = getInput().getStringArray("key_country_excludes");
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletCardElmentUI", "neeCountry: %s", new Object[] { Boolean.valueOf(this.uhG) });
    if ((this.uoC) || (this.uoD)) {
      setMMTitle(2131305056);
    }
    for (;;)
    {
      paramBundle = getInput().getParcelableArray("key_profession_list");
      if (paramBundle == null) {
        break;
      }
      this.mProfessions = new Profession[paramBundle.length];
      i = 0;
      while (i < paramBundle.length)
      {
        this.mProfessions[i] = ((Profession)paramBundle[i]);
        i += 1;
      }
      setMMTitle(2131305055);
    }
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    this.udv = new String[100];
    int i = 0;
    while (i < this.udv.length)
    {
      this.udv[i] = getString(2131305028, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    paramBundle = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
    if ((this.qrf != null) && (paramBundle != null))
    {
      this.tWD = c.umO.a(this.qrf);
      if (this.tWD == null) {
        break label459;
      }
      paramBundle = this.tWD.afF(paramBundle.uhU);
      this.uox = this.tWD.afA(paramBundle);
    }
    for (;;)
    {
      initView();
      this.uou.pageScroll(33);
      d.a(this, getInput(), 3);
      com.tencent.mm.sdk.b.a.ymk.c(this.tZf);
      AppMethodBeat.o(47238);
      return;
      label459:
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47252);
    com.tencent.mm.sdk.b.a.ymk.d(this.tZf);
    super.onDestroy();
    AppMethodBeat.o(47252);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(47251);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      if (this.uov == null) {
        cVx();
      }
      AppMethodBeat.o(47251);
      return false;
    }
    boolean bool1;
    if (this.uov != null)
    {
      paramTextView = this.uov;
      if (paramTextView.AZe != null)
      {
        bool1 = paramTextView.AZe.isFocusable();
        if (!bool1) {
          break label157;
        }
        paramTextView = this.uov;
        bool1 = bool2;
        if (paramTextView.AZe != null) {
          bool1 = paramTextView.AZe.isClickable();
        }
        if ((!bool1) || (!this.uov.dSZ())) {
          break label157;
        }
        this.uov.dTc();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(47251);
      return true;
      bool1 = false;
      break;
      label157:
      this.uov.performClick();
      continue;
      cVx();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47250);
    asr();
    AppMethodBeat.o(47250);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47247);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
        com.tencent.mm.wallet_core.a.j(this, paramString);
        AppMethodBeat.o(47247);
        return true;
      }
      AppMethodBeat.o(47247);
      return false;
    }
    AppMethodBeat.o(47247);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI
 * JD-Core Version:    0.7.0.1
 */