package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.vx;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.model.j;
import com.tencent.mm.plugin.wallet_core.c.ae;
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
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wallet_core.utils.m;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.protocal.protobuf.emf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEncrypt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WalletCardElementUI
  extends WalletBaseUI
  implements TextView.OnEditorActionListener, WalletFormView.a
{
  private String Kju;
  private String Kjv;
  private Orders OsJ;
  private TextView Rwl;
  private List<emf> VAu;
  private String[] VAw;
  private WalletFormView VLW;
  private Bankcard VLY;
  private TextView VMD;
  private TextView VME;
  private TextView VMF;
  private TextView VMG;
  private TextView VMH;
  private TextView VMI;
  private TextView VMJ;
  private TextView VMK;
  private TextView VML;
  private WalletFormView VMM;
  private WalletFormView VMN;
  private WalletFormView VMO;
  private WalletFormView VMP;
  private WalletFormView VMQ;
  private WalletFormView VMR;
  private WalletFormView VMS;
  private WalletFormView VMT;
  private WalletFormView VMU;
  private WalletFormView VMV;
  private WalletFormView VMW;
  private WalletFormView VMX;
  private WalletFormView VMY;
  private WalletFormView VMZ;
  private String VNA;
  private WalletFormView VNB;
  private List<ElementQuery> VNC;
  private int VND;
  private int VNE;
  private int VNF;
  private int VNG;
  private int VNH;
  private int VNI;
  private int VNJ;
  private int VNK;
  private int VNL;
  private int VNM;
  private String VNN;
  private String VNO;
  private boolean VNP;
  private int VNQ;
  private int VNR;
  private int VNS;
  private View.OnClickListener VNT;
  private WalletFormView VNa;
  private WalletFormView VNb;
  private WalletFormView VNc;
  private WalletFormView VNd;
  private WalletFormView VNe;
  private WalletFormView VNf;
  private WalletFormView VNg;
  private WalletFormView VNh;
  private WalletPhoneInputView VNi;
  private WalletFormView VNj;
  private WalletFormView VNk;
  private Map<String, f.a> VNl;
  private boolean VNm;
  private CheckBox VNn;
  private CheckBox VNo;
  private String VNp;
  private boolean VNq;
  private boolean VNr;
  private boolean VNs;
  private boolean VNt;
  private boolean VNu;
  private boolean VNv;
  private boolean VNw;
  private boolean VNx;
  private boolean VNy;
  private String[] VNz;
  private Authen VmM;
  f VnX;
  private IListener VqO;
  private WalletFormView Vre;
  private TextView Vrf;
  private TextView Vrg;
  private int Vrj;
  private ElementQuery Vzs;
  private Profession Vzt;
  private String cityCode;
  private String countryCode;
  private Button lDJ;
  private ScrollView lDL;
  private PayInfo mPayInfo;
  private Profession[] mProfessions;
  private String mSelectBankName;
  private int mSelectCreCountIndex;
  private String mTrueName;
  private String provinceCode;
  private int sex;
  
  public WalletCardElementUI()
  {
    AppMethodBeat.i(70798);
    this.VNj = null;
    this.Vzs = new ElementQuery();
    this.VmM = new Authen();
    this.OsJ = null;
    this.mPayInfo = null;
    this.VLY = null;
    this.VNl = null;
    this.VnX = null;
    this.VNm = false;
    this.Vrj = 1;
    this.VNs = false;
    this.VNt = false;
    this.VNu = false;
    this.VNv = false;
    this.VNw = false;
    this.VNx = false;
    this.VNy = false;
    this.VNz = null;
    this.VNC = new ArrayList();
    this.VAu = new ArrayList();
    this.VNT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174518);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        h.OAn.b(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
        i.c(WalletCardElementUI.this, u.iiC().getTrueName());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174518);
      }
    };
    this.VqO = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(70798);
  }
  
  private void HL(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(70805);
    if (paramBoolean)
    {
      Object localObject = this.Rwl;
      if (this.Vzs.VFm)
      {
        i = 0;
        ((TextView)localObject).setVisibility(i);
        localObject = this.VNb;
        if (!this.Vzs.VFm) {
          break label225;
        }
        i = 0;
        label54:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.VNc;
        if (!this.Vzs.VFn) {
          break label231;
        }
        i = 0;
        label78:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.VNd;
        if (!this.Vzs.VFo) {
          break label237;
        }
        i = 0;
        label102:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.VNe;
        if (!this.Vzs.VFr) {
          break label243;
        }
        i = 0;
        label126:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.VNf;
        if (!this.Vzs.VFt) {
          break label249;
        }
        i = 0;
        label150:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.VNg;
        if (!this.Vzs.VFs) {
          break label255;
        }
        i = 0;
        label174:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.VNh;
        if (!this.Vzs.VFu) {
          break label261;
        }
      }
      label261:
      for (int i = j;; i = 8)
      {
        ((WalletFormView)localObject).setVisibility(i);
        this.VMJ.setVisibility(4);
        AppMethodBeat.o(70805);
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
    this.Rwl.setVisibility(8);
    this.VNb.setVisibility(8);
    this.VNc.setVisibility(8);
    this.VNd.setVisibility(8);
    this.VNe.setVisibility(8);
    this.VNf.setVisibility(8);
    this.VNg.setVisibility(8);
    this.VNh.setVisibility(8);
    this.VMJ.setVisibility(8);
    AppMethodBeat.o(70805);
  }
  
  private void a(WalletFormView paramWalletFormView, int paramInt)
  {
    AppMethodBeat.i(70816);
    paramWalletFormView = paramWalletFormView.getLogicDelegate();
    if ((paramWalletFormView instanceof com.tencent.mm.wallet_core.ui.formview.a.a))
    {
      ((com.tencent.mm.wallet_core.ui.formview.a.a)paramWalletFormView).aGB(paramInt);
      ass(paramInt);
    }
    AppMethodBeat.o(70816);
  }
  
  private static void a(boolean[] paramArrayOfBoolean, WalletFormView[] paramArrayOfWalletFormView, TextView paramTextView1, TextView paramTextView2)
  {
    AppMethodBeat.i(70807);
    a(paramArrayOfBoolean, paramArrayOfWalletFormView, paramTextView1, paramTextView2, false);
    AppMethodBeat.o(70807);
  }
  
  private static void a(boolean[] paramArrayOfBoolean, WalletFormView[] paramArrayOfWalletFormView, TextView paramTextView1, TextView paramTextView2, boolean paramBoolean)
  {
    AppMethodBeat.i(70806);
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
        paramArrayOfWalletFormView[i].gGd();
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
          AppMethodBeat.o(70806);
          return;
        }
        paramTextView2.setVisibility(4);
        AppMethodBeat.o(70806);
      }
    }
    else
    {
      paramTextView1.setVisibility(8);
      if (paramTextView2 != null) {
        paramTextView2.setVisibility(8);
      }
    }
    AppMethodBeat.o(70806);
  }
  
  private void ass(int paramInt)
  {
    AppMethodBeat.i(70817);
    if (paramInt == 1)
    {
      setEditFocusListener(this.Vre, 1, false, false, false);
      AppMethodBeat.o(70817);
      return;
    }
    setEditFocusListener(this.Vre, 1, true, false, false);
    AppMethodBeat.o(70817);
  }
  
  private boolean bZk()
  {
    AppMethodBeat.i(70812);
    WalletFormView localWalletFormView = this.VNj;
    this.VNj = null;
    if (!this.VMM.mJ(null))
    {
      if ((this.VNj == null) && (localWalletFormView != this.VMM)) {
        this.VNj = this.VMM;
      }
      this.VMG.setText(a.i.wallet_card_bankcard_type_err_tips);
      this.VMG.setTextColor(getResources().getColor(a.c.red));
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (!this.VLW.mJ(null))
      {
        if ((this.VNj == null) && (localWalletFormView != this.VLW)) {
          this.VNj = this.VLW;
        }
        bool1 = false;
      }
      if (!this.VNk.mJ(this.VME))
      {
        if ((this.VNj == null) && (localWalletFormView != this.VNk)) {
          this.VNj = this.VNk;
        }
        bool1 = false;
      }
      int i;
      if ((!this.Vre.mJ(this.Vrg)) && (!this.VNm))
      {
        if ((this.VNj == null) && (localWalletFormView != this.Vre)) {
          this.VNj = this.Vre;
        }
        this.Vrg.setText(a.i.wallet_card_identify_err_hint);
        this.Vrg.setTextColor(getResources().getColor(a.c.red));
        i = 1;
      }
      for (boolean bool2 = false;; bool2 = bool1)
      {
        bool1 = bool2;
        if (this.VNs)
        {
          bool1 = bool2;
          if (!this.VMW.mJ(null))
          {
            if ((this.VNj == null) && (localWalletFormView != this.VMW)) {
              this.VNj = this.VMW;
            }
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (this.VNt)
        {
          bool2 = bool1;
          if (!this.VMY.mJ(null))
          {
            if ((this.VNj == null) && (localWalletFormView != this.VMY)) {
              this.VNj = this.VMY;
            }
            bool2 = false;
          }
        }
        if (!this.VMR.mJ(this.Vrg)) {
          if (i != 0)
          {
            this.Vrg.setText(a.i.wallet_card_err_id_phone);
            this.Vrg.setTextColor(getResources().getColor(a.c.red));
            if ((this.VNj == null) && (localWalletFormView != this.VMR)) {
              this.VNj = this.VMR;
            }
            bool1 = false;
            label401:
            if (this.Vrg.getVisibility() == 4)
            {
              if (!this.Vzs.VEX) {
                break label1165;
              }
              this.Vrg.setText(getString(a.i.wallet_card_identify_first_tips));
              label436:
              this.Vrg.setTextColor(getResources().getColor(a.c.hint_text_color));
              this.Vrg.setVisibility(0);
            }
            if (this.VMO.mJ(this.VMI)) {
              break label1220;
            }
            if ((this.VNj == null) && (localWalletFormView != this.VMO)) {
              this.VNj = this.VMO;
            }
            i = 1;
            bool1 = false;
          }
        }
        for (;;)
        {
          if (!this.VMN.mJ(this.VMI))
          {
            if ((this.VNj == null) && (localWalletFormView != this.VMN)) {
              this.VNj = this.VMN;
            }
            bool2 = false;
            label543:
            if (!this.VNn.isChecked()) {
              bool2 = false;
            }
            if (!this.VNb.mJ(this.VMJ))
            {
              if ((this.VNj == null) && (localWalletFormView != this.VNb)) {
                this.VNj = this.VNb;
              }
              bool2 = false;
            }
            if (!this.VNc.mJ(this.VMJ))
            {
              if ((this.VNj == null) && (localWalletFormView != this.VNc)) {
                this.VNj = this.VNc;
              }
              bool2 = false;
            }
            if (!this.VNd.mJ(this.VMJ))
            {
              if ((this.VNj == null) && (localWalletFormView != this.VNd)) {
                this.VNj = this.VNd;
              }
              bool2 = false;
            }
            if (!this.VNe.mJ(this.VMJ))
            {
              if ((this.VNj == null) && (localWalletFormView != this.VNe)) {
                this.VNj = this.VNe;
              }
              bool2 = false;
            }
            if (!this.VNf.mJ(this.VMJ))
            {
              if ((this.VNj == null) && (localWalletFormView != this.VNf)) {
                this.VNj = this.VNf;
              }
              bool2 = false;
            }
            if (!this.VNg.mJ(this.VMJ))
            {
              if ((this.VNj == null) && (localWalletFormView != this.VNg)) {
                this.VNj = this.VNg;
              }
              bool2 = false;
            }
            if (!this.VNh.mJ(this.VMJ))
            {
              if ((this.VNj == null) && (localWalletFormView != this.VNh)) {
                this.VNj = this.VNh;
              }
              bool2 = false;
            }
            bool1 = bool2;
            if (this.VNr)
            {
              bool1 = bool2;
              if (!this.VMS.mJ(null))
              {
                if ((this.VNj == null) && (localWalletFormView != this.VMS)) {
                  this.VNj = this.VMS;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.VNq)
            {
              bool2 = bool1;
              if (!this.VMT.mJ(null))
              {
                if ((this.VNj == null) && (localWalletFormView != this.VMT)) {
                  this.VNj = this.VMT;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.VNq)
            {
              bool1 = bool2;
              if (!this.VMU.mJ(null))
              {
                if ((this.VNj == null) && (localWalletFormView != this.VMU)) {
                  this.VNj = this.VMU;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.VNP)
            {
              bool2 = bool1;
              if (!this.VMV.mJ(null))
              {
                if ((this.VNj == null) && (localWalletFormView != this.VMV)) {
                  this.VNj = this.VMV;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.VNv)
            {
              bool1 = bool2;
              if (!this.VMZ.mJ(null))
              {
                if ((this.VNj == null) && (localWalletFormView != this.VMZ)) {
                  this.VNj = this.VMZ;
                }
                bool1 = false;
              }
            }
            if (!bool1) {
              break label1201;
            }
            this.lDJ.setEnabled(true);
            this.lDJ.setClickable(true);
            if (localWalletFormView != null) {
              localWalletFormView.setImeOptions(1073741824);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(70812);
            return bool1;
            this.Vrg.setText(a.i.wallet_card_err_phone);
            this.Vrg.setTextColor(getResources().getColor(a.c.red));
            break;
            bool1 = bool2;
            if (i == 0) {
              break label401;
            }
            this.Vrg.setVisibility(0);
            bool1 = bool2;
            break label401;
            label1165:
            this.Vrg.setText(getString(a.i.wallet_card_identify_security));
            break label436;
            bool2 = bool1;
            if (i == 0) {
              break label543;
            }
            this.VMI.setVisibility(4);
            bool2 = bool1;
            break label543;
            label1201:
            this.lDJ.setEnabled(false);
            this.lDJ.setClickable(false);
          }
          label1220:
          i = 0;
        }
        i = 0;
      }
    }
  }
  
  private void bhg(String paramString)
  {
    AppMethodBeat.i(70811);
    Object localObject = u.iiK().VxZ;
    this.VNC.clear();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        ElementQuery localElementQuery;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localElementQuery = (ElementQuery)((Iterator)localObject).next();
        } while (!localElementQuery.JFk.equals(paramString));
        Log.i("MicroMsg.WalletCardElmentUI", "add element: %s, %s", new Object[] { localElementQuery.JFk, localElementQuery.hAk });
        this.VNC.add(localElementQuery);
        if ((getInput().getInt("key_bind_scene", -1) == 5) && (!localElementQuery.VFB)) {
          localElementQuery.VFl = getString(a.i.wallet_wx_offline_no_support);
        }
      } while (this.VNC.size() < 2);
    }
    AppMethodBeat.o(70811);
  }
  
  private static void d(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(70804);
    if (!Util.isNullOrNil(paramString))
    {
      KeyListener localKeyListener = paramWalletFormView.getKeyListener();
      paramWalletFormView.setKeyListener(null);
      paramWalletFormView.setEnabled(false);
      paramWalletFormView.setClickable(false);
      paramWalletFormView.setText(paramString);
      paramWalletFormView.setKeyListener(localKeyListener);
      paramWalletFormView.setVisibility(0);
      AppMethodBeat.o(70804);
      return;
    }
    paramWalletFormView.setVisibility(8);
    AppMethodBeat.o(70804);
  }
  
  private void ikC()
  {
    AppMethodBeat.i(70801);
    Object localObject;
    if (ikH()) {
      localObject = getInput().getString("realname_verify_process_get_wording_cache");
    }
    try
    {
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = (cqs)new cqs().parseFrom(((String)localObject).getBytes(org.apache.commons.b.a.ISO_8859_1));
        this.VAu.addAll(((cqs)localObject).aaxw);
      }
      localObject = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      if (localObject != null)
      {
        this.mTrueName = ((RealNameBundle)localObject).VBL;
        this.VNO = ((RealNameBundle)localObject).VCh;
        this.sex = ((RealNameBundle)localObject).sex;
        if ((this.Vzs != null) && (this.Vzs.iim() != null) && (this.Vzs.iim().contains(Integer.valueOf(((RealNameBundle)localObject).VBO))))
        {
          Log.i("MicroMsg.WalletCardElmentUI", "set cretype: %s", new Object[] { Integer.valueOf(((RealNameBundle)localObject).VBO), this.Vzs.iim() });
          this.Vrj = ((RealNameBundle)localObject).VBO;
          this.VMQ.setText(((RealNameBundle)localObject).VBP);
          this.Vre.setText(((RealNameBundle)localObject).VBM);
          a(this.Vre, this.Vrj);
          if (((RealNameBundle)localObject).VBX != 9999) {
            break label606;
          }
          this.VMY.setText(getString(a.i.wc_pay_realname_input_long_term_hint_text));
          this.VNE = 9999;
          this.VNF = 12;
          this.VNG = 31;
          this.VMX.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(((RealNameBundle)localObject).VCj), Integer.valueOf(((RealNameBundle)localObject).VCk), Integer.valueOf(((RealNameBundle)localObject).VCl) }));
          this.mSelectCreCountIndex = ((RealNameBundle)localObject).VBV;
          this.VMW.setText(this.VAw[this.mSelectCreCountIndex]);
        }
        this.VLW.setText(((RealNameBundle)localObject).VBL);
        this.countryCode = ((RealNameBundle)localObject).VBR;
        this.provinceCode = ((RealNameBundle)localObject).VBS;
        this.cityCode = ((RealNameBundle)localObject).VBT;
        this.VMT.setText(((RealNameBundle)localObject).VBU);
        this.VMU.setText(((RealNameBundle)localObject).VCh);
        this.VNA = ((RealNameBundle)localObject).VCe;
        this.VNa.setText(((RealNameBundle)localObject).VCf);
        this.Vzt = ((RealNameBundle)localObject).VBQ;
        if (this.Vzt != null) {
          this.VMS.setText(this.Vzt.VBJ);
        }
        this.VNQ = (((RealNameBundle)localObject).sex - 1);
        if (this.VNQ < 0) {
          this.VNQ = 0;
        }
        WalletFormView localWalletFormView = this.VMV;
        if (((RealNameBundle)localObject).sex != 1) {
          break label656;
        }
        i = a.i.sex_male;
        localWalletFormView.setText(getString(i));
        this.VNK = ((RealNameBundle)localObject).VCb;
        this.VNL = ((RealNameBundle)localObject).VCc;
        this.VNM = ((RealNameBundle)localObject).VCd;
        if ((this.VNK > 0) && (this.VNL > 0) && (this.VNM > 0)) {
          this.VMZ.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.VNK), Integer.valueOf(this.VNL), Integer.valueOf(this.VNM) }));
        }
      }
      AppMethodBeat.o(70801);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletCardElmentUI", localIOException, "", new Object[0]);
        continue;
        label606:
        this.VMY.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(localIOException.VBX), Integer.valueOf(localIOException.VBY), Integer.valueOf(localIOException.VBZ) }));
        continue;
        label656:
        int i = a.i.sex_female;
      }
    }
  }
  
  private void ikD()
  {
    AppMethodBeat.i(70802);
    Object localObject1;
    Object localObject2;
    if (this.Vzs.VFz == 0)
    {
      this.VNi.ilO();
      localObject1 = u.iiK().VJy;
      if (localObject1 == null) {
        break label172;
      }
      localObject2 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.wallet_core.id_verify.model.a)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).hAk.equals(this.Vzs.hAk))
          {
            label77:
            localObject2 = this.VNi;
            if (localObject1 != null)
            {
              if (Util.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).VBu)) {
                break label177;
              }
              ((WalletPhoneInputView)localObject2).VWu.setHint(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).VBu);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).VBv)) {
        ((WalletPhoneInputView)localObject2).VWB = ((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).VBv;
      }
      AppMethodBeat.o(70802);
      return;
      this.VNi.ilP();
      localObject1 = (EditText)this.VNi.findViewById(a.f.prefix_input_et);
      setEditFocusListener(this.VNi.getPhoneNumberEt(), (EditText)localObject1, 0, false, false, true);
      break;
      label172:
      localObject1 = null;
      break label77;
      label177:
      ((WalletPhoneInputView)localObject2).VWu.setHint(((WalletPhoneInputView)localObject2).getContext().getString(a.i.wallet_card_mobile_hint));
    }
  }
  
  private void ikE()
  {
    AppMethodBeat.i(70808);
    Object localObject1;
    boolean bool;
    if (bZk())
    {
      m.imd();
      if (!Util.isNullOrNil(this.Vzs.VFj))
      {
        localObject1 = getInput();
        if ((this.VNo.getVisibility() == 0) && (this.VNo.isChecked()))
        {
          bool = true;
          ((Bundle)localObject1).putBoolean("key_is_follow_bank_username", bool);
          getInput().putString("key_bank_username", this.Vzs.VFj);
        }
      }
      else
      {
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if ((this.Vzs != null) && (localObject1 != null) && (this.VnX != null) && (this.VNl != null))
        {
          if (!this.VNl.containsKey(this.Vzs.hAk)) {
            break label1487;
          }
          ((FavorPayInfo)localObject1).VFC = ((f.a)this.VNl.get(this.Vzs.hAk)).VLv.VlN;
          label168:
          getInput().putParcelable("key_favor_pay_info", (Parcelable)localObject1);
        }
        this.VmM = new Authen();
        if (this.VLY != null)
        {
          this.VmM.MDt = this.VLY.VDm;
          this.VmM.IvM = this.VLY.field_bankcardTail;
        }
        localObject1 = getInput().getString("key_card_id");
        if (this.VNk.getVisibility() != 0) {
          break label1555;
        }
        localObject1 = this.VNk.getText();
      }
    }
    label524:
    label1555:
    for (;;)
    {
      this.VmM.Nxi = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.VmM.VCD = ((String)localObject1);
      this.VmM.hAk = this.Vzs.hAk;
      this.VmM.VCC = this.Vrj;
      this.VmM.VCA = getInput().getString("key_pwd1");
      if (!Util.isNullOrNil(this.VMO.getText())) {
        this.VmM.VCE = this.VMO.getText();
      }
      this.VmM.VxX = this.VMR.getText();
      this.VmM.VCH = this.VNb.getText();
      this.VmM.VCI = this.VNc.getText();
      this.VmM.country = this.VNp;
      this.VmM.province = this.Kju;
      this.VmM.city = this.Kjv;
      this.VmM.oDI = this.VNe.getText();
      this.VmM.JFm = this.VNf.getText();
      this.VmM.qhL = this.VNg.getText();
      this.VmM.kab = this.VNh.getText();
      String str = i.bEO(this.VmM.VxX);
      getInput().putString("key_mobile", str);
      localObject1 = getInput();
      label736:
      Object localObject2;
      if (this.Vzs.Vyb == 2)
      {
        bool = true;
        ((Bundle)localObject1).putBoolean("key_is_oversea", bool);
        this.VmM.VCB = this.Vre.getText();
        this.VmM.VBL = this.VLW.getText();
        this.VmM.VCF = this.VMN.getText();
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if (localObject1 != null)
        {
          this.VmM.VCJ = ((FavorPayInfo)localObject1).VFF;
          this.VmM.VCK = ((FavorPayInfo)localObject1).VFC;
        }
        this.VmM.VCP = ("+" + this.VNi.getCountryCode());
        this.VmM.VBV = this.mSelectCreCountIndex;
        if (this.VNE != 9999) {
          break label1511;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "is long term");
        localObject1 = new TenpaySecureEncrypt();
        this.VmM.VBW = ((TenpaySecureEncrypt)localObject1).desedeEncode(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.VNE), Integer.valueOf(this.VNF), Integer.valueOf(this.VNG) }), i.jPu());
        Log.d("MicroMsg.WalletCardElmentUI", "expire date: %s", new Object[] { this.VMY.getText() });
        this.VmM.VCa = this.VMZ.getText();
        Log.d("MicroMsg.WalletCardElmentUI", "birth date: %s", new Object[] { this.VMZ.getText() });
        localObject2 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new RealNameBundle();
        }
        ((RealNameBundle)localObject1).VBL = this.VLW.getText();
        ((RealNameBundle)localObject1).sex = (this.VNQ + 1);
        ((RealNameBundle)localObject1).VBR = this.countryCode;
        ((RealNameBundle)localObject1).VBS = this.provinceCode;
        ((RealNameBundle)localObject1).VBT = this.cityCode;
        ((RealNameBundle)localObject1).VCh = this.VMU.getText();
        ((RealNameBundle)localObject1).VBQ = this.Vzt;
        ((RealNameBundle)localObject1).VCe = this.VNA;
        ((RealNameBundle)localObject1).VCa = this.VMZ.getText();
        ((RealNameBundle)localObject1).VBO = this.Vrj;
        ((RealNameBundle)localObject1).VBP = this.VMQ.getText();
        ((RealNameBundle)localObject1).VBM = "";
        ((RealNameBundle)localObject1).VBN = this.Vre.getText();
        ((RealNameBundle)localObject1).VCi = this.VMX.getText();
        ((RealNameBundle)localObject1).VBW = this.VMY.getText();
        ((RealNameBundle)localObject1).VBV = this.mSelectCreCountIndex;
        getInput().putParcelable("realname_verify_process_bundle", (Parcelable)localObject1);
        Log.d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", new Object[] { Integer.valueOf(this.VmM.VBV), this.VmM.VBW, this.VmM.VCa });
        if ((ikG()) && (!Util.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!Util.isNullOrNil(getInput().getString("key_true_name"))))
        {
          Log.i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
          this.VmM.VCB = getInput().getString("key_identity");
          this.VmM.VCC = getInput().getInt("key_id_type", -1);
          this.VmM.VBL = this.mTrueName;
          Log.i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.VmM.VBL);
        }
        Log.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.VmM.Nxi + " elemt.bankcardTag : " + this.Vzs.Vyb);
        Log.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.Vzs.Vyb);
        localObject2 = getInput();
        ((Bundle)localObject2).putString("key_mobile", str);
        ((Bundle)localObject2).putParcelable("key_authen", this.VmM);
        ((Bundle)localObject2).putString("key_bank_phone", this.Vzs.VFi);
        ((Bundle)localObject2).putString("key_country_code", this.countryCode);
        ((Bundle)localObject2).putString("key_province_code", this.provinceCode);
        ((Bundle)localObject2).putString("key_city_code", this.cityCode);
        ((Bundle)localObject2).putParcelable("key_profession", this.Vzt);
        ((Bundle)localObject2).putString("key_country_iso", this.VNA);
        ((Bundle)localObject2).putString("key_bind_card_type", this.VmM.hAk);
        ((Bundle)localObject2).putString("key_bind_card_show1", this.Vzs.JFk);
        if (2 != this.Vzs.VFf) {
          break label1528;
        }
      }
      label1487:
      label1511:
      label1528:
      for (localObject1 = getString(a.i.wallet_credit_card);; localObject1 = getString(a.i.wallet_deposit_card))
      {
        ((Bundle)localObject2).putString("key_bind_card_show2", (String)localObject1);
        localObject1 = ((Bundle)localObject2).getString("key_bind_card_user_token", null);
        if (!Util.isNullOrNil((String)localObject1))
        {
          this.VmM.VCQ = 1;
          this.VmM.Vyh = ((String)localObject1);
        }
        this.VmM.VCR = ((Bundle)localObject2).getString("kreq_token");
        if (!getNetController().t(new Object[] { this.VmM, this.OsJ })) {
          break label1539;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
        AppMethodBeat.o(70808);
        return;
        bool = false;
        break;
        ((FavorPayInfo)localObject1).VFC = this.VnX.dC(((FavorPayInfo)localObject1).VFC, false);
        break label168;
        bool = false;
        break label524;
        this.VmM.VBW = this.VMY.getText();
        break label736;
      }
      Log.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70808);
      return;
    }
  }
  
  private void ikF()
  {
    AppMethodBeat.i(70818);
    Object localObject;
    if ((this.Vzs != null) && (this.VNl != null) && (this.VNl.containsKey(this.Vzs.hAk)))
    {
      localObject = (f.a)this.VNl.get(this.Vzs.hAk);
      if ((localObject == null) || (((f.a)localObject).VLv == null)) {
        break label133;
      }
    }
    label133:
    for (double d = ((f.a)localObject).VLw;; d = 0.0D)
    {
      localObject = getString(a.i.wallet_card_bank_favor_tips, new Object[] { i.X(d) });
      this.VMK.setText((CharSequence)localObject);
      this.VMK.setVisibility(0);
      AppMethodBeat.o(70818);
      return;
      this.VMK.setVisibility(8);
      AppMethodBeat.o(70818);
      return;
    }
  }
  
  private boolean ikG()
  {
    AppMethodBeat.i(70819);
    boolean bool = getInput().getBoolean("key_is_forgot_process", false);
    AppMethodBeat.o(70819);
    return bool;
  }
  
  private boolean ikH()
  {
    AppMethodBeat.i(174523);
    e locale = getProcess();
    if ((locale != null) && ("realname_verify_process".equals(locale.fud())))
    {
      if (locale.hPH.getInt("real_name_verify_mode", 0) == 4)
      {
        AppMethodBeat.o(174523);
        return true;
      }
      AppMethodBeat.o(174523);
      return false;
    }
    AppMethodBeat.o(174523);
    return false;
  }
  
  private void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(70803);
    if (this.Vzs == null) {
      this.Vzs = new ElementQuery();
    }
    Log.i("MicroMsg.WalletCardElmentUI", "element: %s, %s", new Object[] { this.Vzs.JFk, this.Vzs.hAk });
    ikD();
    ikF();
    com.tencent.mm.wallet_core.a.cm(this);
    Object localObject1 = (Bankcard)getInput().getParcelable("key_bankcard");
    Object localObject2;
    Object localObject3;
    if ((ikG()) && (localObject1 != null))
    {
      this.VNk.setHint(getString(a.i.wallet_card_forgot_id_hint, new Object[] { ((Bankcard)localObject1).field_bankcardTail }));
      localObject1 = this.VNk;
      localObject2 = this.VMD;
      localObject3 = this.VME;
      a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
      localObject1 = this.VMM;
      localObject2 = this.VMF;
      localObject3 = this.VMG;
      a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
    }
    for (;;)
    {
      if (paramBoolean) {
        ikC();
      }
      this.VNs = false;
      this.VNt = false;
      this.VNv = false;
      this.VNw = false;
      if (!ikH()) {
        break;
      }
      localObject1 = this.VAu.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (emf)((Iterator)localObject1).next();
        if (((emf)localObject2).abqC.key == this.Vrj)
        {
          this.VNs = ((emf)localObject2).abqG;
          this.VNt = ((emf)localObject2).abqF;
          this.VNu = ((emf)localObject2).abqJ;
          this.VNv = ((emf)localObject2).abqH;
          this.VNP = ((emf)localObject2).abqL;
          this.VNr = ((emf)localObject2).abqD;
          this.VNq = ((emf)localObject2).abqE;
          this.VNx = ((emf)localObject2).abqI;
          this.VNw = true;
        }
      }
      if (!Util.isNullOrNil(this.Vzs.JFk))
      {
        this.VMM.setText(this.Vzs.JFk);
        if (!this.Vzs.ihX()) {
          break label561;
        }
        this.VNB.setVisibility(0);
        this.VNB.setText(getString(a.i.wallet_credit_card));
      }
      for (;;)
      {
        localObject1 = this.VNk;
        localObject2 = this.VMD;
        localObject3 = this.VME;
        a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        localObject1 = this.VMM;
        localObject2 = this.VMF;
        localObject3 = this.VMG;
        a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        this.VNk.setOnInfoIvClickListener(this.VNT);
        if (!u.iiC().ijp().iiT()) {
          break label596;
        }
        this.VNk.getInfoIv().setImageResource(a.h.wallet_scan_camera);
        this.VNk.getInfoIv().setVisibility(0);
        break;
        label561:
        if (this.Vzs.iil())
        {
          this.VNB.setVisibility(0);
          this.VNB.setText(getString(a.i.wallet_deposit_card));
        }
      }
      label596:
      this.VNk.getInfoIv().setVisibility(4);
    }
    Object localObject4;
    WalletFormView localWalletFormView1;
    WalletFormView localWalletFormView2;
    TextView localTextView1;
    TextView localTextView2;
    boolean bool1;
    boolean bool2;
    if ((this.Vzs.VFA != null) && (!this.Vzs.VFA.isEmpty()))
    {
      Log.i("MicroMsg.WalletCardElmentUI", "identity type： %s", new Object[] { Integer.valueOf(this.Vrj) });
      localObject1 = this.Vzs.VFA.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CreTypeRuleInfo)((Iterator)localObject1).next();
        if (((CreTypeRuleInfo)localObject2).VEE == this.Vrj)
        {
          if (((CreTypeRuleInfo)localObject2).VEF.VEA == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show cre count");
            this.VNs = true;
          }
          if (((CreTypeRuleInfo)localObject2).VEF.VEC == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show cre expire");
            this.VNt = true;
          }
          if (((CreTypeRuleInfo)localObject2).VEF.VEB == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show birthday");
            this.VNv = true;
          }
          if (((CreTypeRuleInfo)localObject2).VEF.VED == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show cre type");
            if (u.iiC().ijr() > 0)
            {
              Log.i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
              this.VNw = true;
            }
          }
        }
      }
      if ((this.Vrj == 2) && (this.VNy))
      {
        this.VNx = true;
        if (!this.VNt)
        {
          this.VNE = 0;
          this.VNF = 0;
          this.VNG = 0;
        }
        if (!this.VNv)
        {
          this.VNK = 0;
          this.VNL = 0;
          this.VNM = 0;
        }
        if (!this.VNs) {
          this.mSelectCreCountIndex = 0;
        }
        this.VMP.setVisibility(8);
        if (!Bankcard.asi(this.Vzs.Vyb)) {
          break label1497;
        }
        localObject1 = this.VLW;
        localObject2 = this.VMQ;
        localObject3 = this.Vre;
        localObject4 = this.VMW;
        localWalletFormView1 = this.VMX;
        localWalletFormView2 = this.VMY;
        localTextView1 = this.Vrf;
        localTextView2 = this.Vrg;
        a(new boolean[] { 0, 0, 0, 0, 0, 0 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.VMR.setVisibility(8);
        HL(true);
        paramBoolean = this.VNv;
        bool1 = this.VNx;
        bool2 = this.VNP;
        localObject1 = this.VMT;
        localObject2 = this.VMU;
        localObject3 = this.VMS;
        localObject4 = this.VMZ;
        localWalletFormView1 = this.VNa;
        localWalletFormView2 = this.VMV;
        localTextView1 = this.VML;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        paramBoolean = this.Vzs.VEZ;
        bool1 = this.Vzs.VFa;
        localObject1 = this.VMO;
        localObject2 = this.VMN;
        localObject3 = this.VMH;
        localObject4 = this.VMI;
        a(new boolean[] { paramBoolean, bool1 }, new WalletFormView[] { localObject1, localObject2 }, (TextView)localObject3, (TextView)localObject4);
        if (this.VMM.getVisibility() != 0) {
          break label2960;
        }
        switch (this.Vzs.VFe)
        {
        default: 
          this.VMG.setVisibility(8);
          label1325:
          this.VMG.setTextColor(getResources().getColor(a.c.normal_color));
        }
      }
    }
    for (;;)
    {
      if ((!Util.isNullOrNil(this.Vzs.VFy)) && (this.VMG.getVisibility() != 0))
      {
        Log.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
        this.VMG.setText(this.Vzs.VFy);
        this.VMG.setVisibility(0);
      }
      if ((Util.isNullOrNil(this.Vzs.VFj)) || (!ab.IR(this.Vzs.VFj)) || (ikG())) {
        break label2972;
      }
      this.VNo.setText(this.Vzs.VFk);
      this.VNo.setVisibility(0);
      AppMethodBeat.o(70803);
      return;
      this.VNx = false;
      break;
      if ((this.Vrj == 2) && (this.VNy))
      {
        this.VNx = true;
        break;
      }
      this.VNx = false;
      break;
      label1497:
      int i;
      if ((this.Vzs.iim() != null) && (this.Vzs.iim().size() > 0))
      {
        i = 1;
        label1524:
        if ((!ikG()) && (!u.iiC().ijh())) {
          break label2440;
        }
        localObject2 = u.iiC().getTrueName();
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          if (getProcess() != null) {
            localObject1 = getProcess().hPH.getString("key_true_name");
          }
        }
        if (Util.isNullOrNil((String)localObject1)) {
          break label2252;
        }
        localObject1 = getString(a.i.wallet_card_username_hint_forget, new Object[] { i.bEN((String)localObject1) });
        this.VLW.setHint((CharSequence)localObject1);
        this.VMP.setHint((CharSequence)localObject1);
        label1633:
        if ((!ikG()) || (Util.isNullOrNil(getInput().getString("key_identity"))) || (getInput().getInt("key_id_type", -1) == -1) || (Util.isNullOrNil(getInput().getString("key_true_name")))) {
          break label2282;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
        paramBoolean = this.VNs;
        bool1 = this.VNu;
        bool2 = this.VNt;
        localObject1 = this.VLW;
        localObject2 = this.VMQ;
        localObject3 = this.Vre;
        localObject4 = this.VMW;
        localWalletFormView1 = this.VMX;
        localWalletFormView2 = this.VMY;
        localTextView1 = this.Vrf;
        localTextView2 = this.Vrg;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.mTrueName = getInput().getString("key_true_name");
        Log.i("MicroMsg.WalletCardElmentUI", "name is " + this.mTrueName);
        this.VMR.setVisibility(0);
        if (this.VLY != null)
        {
          if (!Util.isNullOrNil(this.VLY.field_mobile)) {
            d(this.VMR, this.VLY.field_mobile);
          }
          if (!Util.isNullOrNil(this.VLY.VCE)) {
            d(this.VMO, this.VLY.VCE);
          }
          if (!Util.isNullOrNil(this.VLY.VDl)) {
            d(this.VMN, this.VLY.VDl);
          }
        }
        if (!this.Vzs.VEX) {
          break label2681;
        }
        this.Vrg.setText("");
      }
      for (;;)
      {
        if (!Util.isNullOrNil(this.Vzs.VFb)) {
          this.Vre.setText(this.Vzs.VFb);
        }
        if (u.iiC().ijr() <= 0) {
          break label2698;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", new Object[] { Integer.valueOf(u.iiC().ijr()) });
        this.VMQ.setClickable(false);
        this.VMQ.setText(u.iiK().kJ(this));
        this.VMQ.setInputEnable(false);
        a(this.Vre, this.Vrj);
        HL(false);
        paramBoolean = this.VNP;
        bool1 = this.VNq;
        bool2 = this.VNq;
        boolean bool3 = this.VNr;
        boolean bool4 = this.VNv;
        boolean bool5 = this.VNx;
        localObject1 = this.VMV;
        localObject2 = this.VMT;
        localObject3 = this.VMU;
        localObject4 = this.VMS;
        localWalletFormView1 = this.VMZ;
        localWalletFormView2 = this.VNa;
        localTextView1 = this.VML;
        a(new boolean[] { paramBoolean, bool1, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        break;
        i = 0;
        break label1524;
        label2252:
        localObject1 = getString(a.i.wallet_card_username_hint);
        this.VLW.setHint((CharSequence)localObject1);
        this.VMP.setHint((CharSequence)localObject1);
        break label1633;
        label2282:
        if ((this.VNw) || (i != 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool1 = this.VNs;
          bool2 = this.VNu;
          bool3 = this.VNt;
          localObject1 = this.VLW;
          localObject2 = this.VMQ;
          localObject3 = this.Vre;
          localObject4 = this.VMW;
          localWalletFormView1 = this.VMX;
          localWalletFormView2 = this.VMY;
          localTextView1 = this.Vrf;
          localTextView2 = this.Vrg;
          a(new boolean[] { true, paramBoolean, true, bool1, bool2, bool3 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          break;
        }
        label2440:
        bool1 = this.Vzs.VEX;
        if ((this.VNw) || ((i != 0) && (this.Vzs.VEY))) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool2 = this.Vzs.VEY;
          bool3 = this.VNs;
          bool4 = this.VNu;
          bool5 = this.VNt;
          localObject1 = this.VLW;
          localObject2 = this.VMQ;
          localObject3 = this.Vre;
          localObject4 = this.VMW;
          localWalletFormView1 = this.VMX;
          localWalletFormView2 = this.VMY;
          localTextView1 = this.Vrf;
          localTextView2 = this.Vrg;
          a(new boolean[] { bool1, paramBoolean, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          this.VMR.setVisibility(0);
          Log.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.Vzs.VEX + " canModifyIdentity:" + this.Vzs.VEY);
          break;
        }
        label2681:
        this.Vrg.setText(getString(a.i.wallet_card_identify_security));
      }
      label2698:
      if (this.Vzs.iim() != null)
      {
        i = this.Vzs.iim().size();
        label2721:
        Log.i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", new Object[] { Integer.valueOf(i) });
        if (i > 1) {
          break label2876;
        }
        this.VMQ.setClickable(false);
        this.VMQ.setInputEnable(false);
        this.Vre.setInputEnable(true);
      }
      for (;;)
      {
        localObject1 = this.Vzs.iim();
        if ((localObject1 == null) || (!((List)localObject1).contains(Integer.valueOf(this.Vrj)))) {
          this.Vrj = 1;
        }
        if (!u.iiK().bf(this, this.Vrj).equals(this.VNN)) {
          h.OAn.b(16816, new Object[] { Integer.valueOf(this.Vrj) });
        }
        this.VMQ.setText(u.iiK().bf(this, this.Vrj));
        break;
        i = 0;
        break label2721;
        label2876:
        this.VMQ.setClickable(true);
        this.VMQ.setInputEnable(true);
        this.Vre.setInputEnable(true);
      }
      this.VMG.setText(a.i.wallet_card_cardtype_tipmsg_cn);
      this.VMG.setVisibility(0);
      break label1325;
      this.VMG.setVisibility(8);
      break label1325;
      this.VMG.setVisibility(8);
      break label1325;
      this.VMG.setVisibility(8);
      break label1325;
      label2960:
      this.VMG.setVisibility(8);
    }
    label2972:
    this.VNo.setVisibility(8);
    AppMethodBeat.o(70803);
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
    return a.g.wallet_card_element_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70800);
    this.VMD = ((TextView)findViewById(a.f.wallet_card_forgot_id_tipmsg));
    this.VNk = ((WalletFormView)findViewById(a.f.wallet_card_forgot_id));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.VNk);
    this.VME = ((TextView)findViewById(a.f.wallet_card_forgot_id_err_tipmsg));
    this.Vrf = ((TextView)findViewById(a.f.wallet_card_identify_tipmsg));
    this.VLW = ((WalletFormView)findViewById(a.f.name_et));
    this.VMP = ((WalletFormView)findViewById(a.f.forgot_name_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.VLW);
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.VMP);
    this.VMQ = ((WalletFormView)findViewById(a.f.wallet_cre_type));
    this.Vre = ((WalletFormView)findViewById(a.f.identity_et));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.Vre);
    this.Vrg = ((TextView)findViewById(a.f.wallet_card_identify_err_hint));
    this.VMF = ((TextView)findViewById(a.f.wallet_card_bankcard_type_tipmsg));
    this.VMM = ((WalletFormView)findViewById(a.f.wallet_card_name));
    this.VNB = ((WalletFormView)findViewById(a.f.wallet_card_type));
    this.VMG = ((TextView)findViewById(a.f.wallet_card_cardtype_tipmsg));
    this.VMK = ((TextView)findViewById(a.f.wallet_card_favor));
    this.VMH = ((TextView)findViewById(a.f.wallet_card_cvv_tipmsg));
    this.VMO = ((WalletFormView)findViewById(a.f.cvv_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.VMO);
    this.VMN = ((WalletFormView)findViewById(a.f.date_et));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.VMN);
    this.VMI = ((TextView)findViewById(a.f.wallet_card_cvv_err_tipmsg));
    this.Rwl = ((TextView)findViewById(a.f.wallet_card_address_tipmsg));
    this.VNb = ((WalletFormView)findViewById(a.f.first_name_et));
    this.VNc = ((WalletFormView)findViewById(a.f.last_name_et));
    this.VNd = ((WalletFormView)findViewById(a.f.area_et));
    this.VNe = ((WalletFormView)findViewById(a.f.address_et));
    this.VNf = ((WalletFormView)findViewById(a.f.phone_et));
    this.VNg = ((WalletFormView)findViewById(a.f.post_et));
    this.VNh = ((WalletFormView)findViewById(a.f.email_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.VNh);
    this.VMJ = ((TextView)findViewById(a.f.wallet_card_address_err_tipmsg));
    this.VNn = ((CheckBox)findViewById(a.f.agree_wx_cb));
    this.VNo = ((CheckBox)findViewById(a.f.agree_follow_bank_cb));
    this.lDJ = ((Button)findViewById(a.f.next_btn));
    this.lDL = ((ScrollView)findViewById(a.f.wallet_sv));
    this.VMS = ((WalletFormView)findViewById(a.f.private_profession_et));
    this.VMT = ((WalletFormView)findViewById(a.f.private_area_et));
    this.VMU = ((WalletFormView)findViewById(a.f.private_address_et));
    this.VMV = ((WalletFormView)findViewById(a.f.private_sex_et));
    this.VMW = ((WalletFormView)findViewById(a.f.wallet_cre_change_times));
    this.VMX = ((WalletFormView)findViewById(a.f.wallet_cre_effect_date));
    this.VMY = ((WalletFormView)findViewById(a.f.wallet_cre_expire_date));
    this.VMZ = ((WalletFormView)findViewById(a.f.private_birthday_et));
    this.VNa = ((WalletFormView)findViewById(a.f.private_country_et));
    this.VML = ((TextView)findViewById(a.f.wallet_card_private_info_tipmsg));
    this.VNi = ((WalletPhoneInputView)findViewById(a.f.mobile_new_et));
    this.VMR = this.VNi.getPhoneNumberEt();
    this.VLW.setOnInputValidChangeListener(this);
    this.VMP.setOnInputValidChangeListener(this);
    this.VNk.setOnInputValidChangeListener(this);
    this.VMQ.setOnInputValidChangeListener(this);
    this.Vre.setOnInputValidChangeListener(this);
    this.VMR.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70773);
        if (!paramAnonymousBoolean)
        {
          WalletCardElementUI.a(WalletCardElementUI.this);
          WalletCardElementUI.this.getInput().putParcelable("key_history_bankcard", null);
        }
        WalletCardElementUI.b(WalletCardElementUI.this);
        AppMethodBeat.o(70773);
      }
    });
    this.VMO.setOnInputValidChangeListener(this);
    this.VMN.setOnInputValidChangeListener(this);
    this.VNb.setOnInputValidChangeListener(this);
    this.VNc.setOnInputValidChangeListener(this);
    this.VNd.setOnInputValidChangeListener(this);
    this.VNe.setOnInputValidChangeListener(this);
    this.VNf.setOnInputValidChangeListener(this);
    this.VNg.setOnInputValidChangeListener(this);
    this.VNh.setOnInputValidChangeListener(this);
    this.VMS.setOnInputValidChangeListener(this);
    this.VMT.setOnInputValidChangeListener(this);
    this.VLW.setOnEditorActionListener(this);
    this.VMP.setOnEditorActionListener(this);
    this.VNk.setOnEditorActionListener(this);
    this.VMQ.setOnEditorActionListener(this);
    this.Vre.setOnEditorActionListener(this);
    this.VMR.setOnEditorActionListener(this);
    this.VMO.setOnEditorActionListener(this);
    this.VMN.setOnEditorActionListener(this);
    this.VNb.setOnEditorActionListener(this);
    this.VNc.setOnEditorActionListener(this);
    this.VNd.setOnEditorActionListener(this);
    this.VNe.setOnEditorActionListener(this);
    this.VNf.setOnEditorActionListener(this);
    this.VNg.setOnEditorActionListener(this);
    this.VNh.setOnEditorActionListener(this);
    this.VMT.setOnEditorActionListener(this);
    this.VMS.setOnEditorActionListener(this);
    this.VMM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70786);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardElementUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putInt("key_bind_scene", WalletCardElementUI.this.getInput().getInt("key_bind_scene", -1));
        Util.isNullOrNil(WalletCardElementUI.c(WalletCardElementUI.this).getText());
        WalletCardElementUI.this.hideTenpayKB();
        localObject = com.tencent.mm.wallet_core.a.cm(WalletCardElementUI.this);
        if (localObject != null) {
          ((e)localObject).a(WalletCardElementUI.this, WalletBankCardSelectUI.class, paramAnonymousView, 1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70786);
      }
    });
    this.VNB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70788);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(WalletCardElementUI.this.getString(a.i.wallet_deposit_card));
        paramAnonymousView.add(WalletCardElementUI.this.getString(a.i.wallet_credit_card));
        if (WalletCardElementUI.d(WalletCardElementUI.this).size() == 1)
        {
          localObject = (ElementQuery)WalletCardElementUI.d(WalletCardElementUI.this).get(0);
          if (!((ElementQuery)localObject).iil()) {
            break label180;
          }
          paramAnonymousView.remove(1);
        }
        for (;;)
        {
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.aFq(WalletCardElementUI.e(WalletCardElementUI.this));
          paramAnonymousView.agkc = new b.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(70787);
              paramAnonymousView.hide();
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2Object1 = (String)paramAnonymous2Object1;
                WalletCardElementUI.f(WalletCardElementUI.this).setText(paramAnonymous2Object1);
                if (!paramAnonymous2Object1.equals(WalletCardElementUI.this.getString(a.i.wallet_credit_card))) {
                  break label163;
                }
              }
              label163:
              for (int i = 0;; i = 1)
              {
                paramAnonymous2Object1 = WalletCardElementUI.d(WalletCardElementUI.this).iterator();
                while (paramAnonymous2Object1.hasNext())
                {
                  paramAnonymous2Object2 = (ElementQuery)paramAnonymous2Object1.next();
                  if (((i != 0) && (paramAnonymous2Object2.iil())) || ((i == 0) && (paramAnonymous2Object2.ihX())))
                  {
                    WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymous2Object2);
                    WalletCardElementUI.g(WalletCardElementUI.this);
                  }
                }
                WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymousView.jIz());
                AppMethodBeat.o(70787);
                return;
              }
            }
          };
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70788);
          return;
          label180:
          if (((ElementQuery)localObject).ihX()) {
            paramAnonymousView.remove(0);
          }
        }
      }
    });
    this.VMQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70789);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletCardElementUI.h(WalletCardElementUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70789);
      }
    });
    this.VMW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext(), WalletCardElementUI.i(WalletCardElementUI.this));
        paramAnonymousView.agkc = new b.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(70790);
            if (paramAnonymous2Boolean)
            {
              WalletCardElementUI.j(WalletCardElementUI.this).setText((String)paramAnonymous2Object1);
              WalletCardElementUI.b(WalletCardElementUI.this, paramAnonymousView.jIz());
              WalletCardElementUI.b(WalletCardElementUI.this);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(70790);
          }
        };
        paramAnonymousView.aFq(WalletCardElementUI.k(WalletCardElementUI.this));
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70791);
      }
    });
    this.VMX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70793);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.a(WalletCardElementUI.this.getContext());
        paramAnonymousView.agjU = new com.tencent.mm.ui.widget.picker.a.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(70792);
            if (paramAnonymous2Boolean)
            {
              if ((paramAnonymous2Int1 <= 0) || (paramAnonymous2Int2 <= 0) || (paramAnonymous2Int3 <= 0))
              {
                AppMethodBeat.o(70792);
                return;
              }
              WalletCardElementUI.l(WalletCardElementUI.this).setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }));
              WalletCardElementUI.c(WalletCardElementUI.this, paramAnonymous2Int1);
              WalletCardElementUI.d(WalletCardElementUI.this, paramAnonymous2Int2);
              WalletCardElementUI.e(WalletCardElementUI.this, paramAnonymous2Int3);
              WalletCardElementUI.b(WalletCardElementUI.this);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(70792);
          }
        };
        localObject = Calendar.getInstance();
        int i = ((Calendar)localObject).get(1);
        int j = ((Calendar)localObject).get(2) + 1;
        int k = ((Calendar)localObject).get(5);
        paramAnonymousView.bE(i, j, k);
        localObject = WalletCardElementUI.l(WalletCardElementUI.this).getContentEt().getText().toString();
        if ((WalletCardElementUI.m(WalletCardElementUI.this) > 0) && (WalletCardElementUI.n(WalletCardElementUI.this) > 0) && (WalletCardElementUI.o(WalletCardElementUI.this) > 0)) {
          paramAnonymousView.bC(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
        }
        for (;;)
        {
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70793);
          return;
          if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() == 8))
          {
            WalletCardElementUI.c(WalletCardElementUI.this, Util.getInt(((String)localObject).substring(0, 4), i));
            WalletCardElementUI.d(WalletCardElementUI.this, Util.getInt(((String)localObject).substring(4, 6), j));
            WalletCardElementUI.e(WalletCardElementUI.this, Util.getInt(((String)localObject).substring(6, 8), k));
            paramAnonymousView.bC(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
          }
        }
      }
    });
    this.VMY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70794);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.a(WalletCardElementUI.this.getContext());
        paramAnonymousView.agjU = new com.tencent.mm.ui.widget.picker.a.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(174521);
            if (paramAnonymous2Boolean)
            {
              if ((paramAnonymous2Int1 <= 0) || (paramAnonymous2Int2 <= 0) || (paramAnonymous2Int3 <= 0))
              {
                AppMethodBeat.o(174521);
                return;
              }
              if (paramAnonymous2Int1 != 1) {
                break label123;
              }
              WalletCardElementUI.p(WalletCardElementUI.this).setText(WalletCardElementUI.this.getString(a.i.wc_pay_realname_input_long_term_hint_text));
              WalletCardElementUI.f(WalletCardElementUI.this, 9999);
              WalletCardElementUI.g(WalletCardElementUI.this, 12);
              WalletCardElementUI.h(WalletCardElementUI.this, 31);
            }
            for (;;)
            {
              WalletCardElementUI.b(WalletCardElementUI.this);
              paramAnonymousView.hide();
              AppMethodBeat.o(174521);
              return;
              label123:
              WalletCardElementUI.p(WalletCardElementUI.this).setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }));
              WalletCardElementUI.f(WalletCardElementUI.this, paramAnonymous2Int1);
              WalletCardElementUI.g(WalletCardElementUI.this, paramAnonymous2Int2);
              WalletCardElementUI.h(WalletCardElementUI.this, paramAnonymous2Int3);
            }
          }
        };
        localObject = Calendar.getInstance();
        int i = ((Calendar)localObject).get(1);
        int j = ((Calendar)localObject).get(2) + 1;
        int k = ((Calendar)localObject).get(5);
        paramAnonymousView.bD(i, j, k);
        paramAnonymousView.bE(i + 200, 12, 31);
        paramAnonymousView.setLongTermYear(true);
        localObject = WalletCardElementUI.p(WalletCardElementUI.this).getContentEt().getText().toString();
        if ((WalletCardElementUI.q(WalletCardElementUI.this) <= 0) || (WalletCardElementUI.r(WalletCardElementUI.this) <= 0) || (WalletCardElementUI.s(WalletCardElementUI.this) <= 0))
        {
          if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() == 8))
          {
            WalletCardElementUI.f(WalletCardElementUI.this, Util.getInt(((String)localObject).substring(0, 4), i));
            WalletCardElementUI.g(WalletCardElementUI.this, Util.getInt(((String)localObject).substring(4, 6), j));
            WalletCardElementUI.h(WalletCardElementUI.this, Util.getInt(((String)localObject).substring(6, 8), k));
          }
        }
        else
        {
          if (WalletCardElementUI.q(WalletCardElementUI.this) != 9999) {
            break label341;
          }
          paramAnonymousView.bC(1, 1, 1);
        }
        for (;;)
        {
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70794);
          return;
          if (!((String)localObject).equals(WalletCardElementUI.this.getString(a.i.wc_pay_realname_input_long_term_hint_text))) {
            break;
          }
          WalletCardElementUI.f(WalletCardElementUI.this, 9999);
          WalletCardElementUI.g(WalletCardElementUI.this, 12);
          WalletCardElementUI.h(WalletCardElementUI.this, 31);
          break;
          label341:
          paramAnonymousView.bC(WalletCardElementUI.q(WalletCardElementUI.this), WalletCardElementUI.r(WalletCardElementUI.this), WalletCardElementUI.s(WalletCardElementUI.this));
        }
      }
    });
    this.VMV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70795);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = WalletCardElementUI.this.getResources().getStringArray(a.b.wc_pay_realname_sex_selection);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext(), paramAnonymousView);
        paramAnonymousView.agkc = new b.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(174522);
            if (paramAnonymous2Boolean)
            {
              WalletCardElementUI.t(WalletCardElementUI.this).setText((String)paramAnonymous2Object1);
              if (!((String)paramAnonymous2Object1).equalsIgnoreCase(WalletCardElementUI.this.getString(a.i.sex_male))) {
                break label91;
              }
              WalletCardElementUI.i(WalletCardElementUI.this, 0);
            }
            for (;;)
            {
              paramAnonymousView.aFq(WalletCardElementUI.u(WalletCardElementUI.this));
              paramAnonymousView.hide();
              AppMethodBeat.o(174522);
              return;
              label91:
              WalletCardElementUI.i(WalletCardElementUI.this, 1);
            }
          }
        };
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70795);
      }
    });
    this.VMT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70797);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("GetAddress", true);
        paramAnonymousView.putExtra("ShowSelectedLocation", false);
        if (!Bankcard.asi(WalletCardElementUI.v(WalletCardElementUI.this).Vyb))
        {
          paramAnonymousView.putExtra("IsRealNameVerifyScene", true);
          paramAnonymousView.putExtra("IsNeedShowSearchBar", true);
        }
        if ((WalletCardElementUI.w(WalletCardElementUI.this) != null) && (WalletCardElementUI.w(WalletCardElementUI.this).length > 0))
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).addAll(Arrays.asList(WalletCardElementUI.w(WalletCardElementUI.this)));
          ((ArrayList)localObject).remove("CN");
          ((ArrayList)localObject).remove("TW");
          ((ArrayList)localObject).remove("HK");
          ((ArrayList)localObject).remove("MO");
          paramAnonymousView.putStringArrayListExtra("BlockedCountries", (ArrayList)localObject);
        }
        c.d(WalletCardElementUI.this.getContext(), ".ui.tools.MultiStageCitySelectUI", paramAnonymousView, 4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70797);
      }
    });
    this.VMS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70774);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Intent(WalletCardElementUI.this.getContext(), WalletSelectProfessionUI.class);
        paramAnonymousView.putExtra("key_profession_list", WalletCardElementUI.x(WalletCardElementUI.this));
        WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 5);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70774);
      }
    });
    this.VMZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(174512);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.a(WalletCardElementUI.this.getContext());
        paramAnonymousView.agjU = new com.tencent.mm.ui.widget.picker.a.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(174511);
            if (paramAnonymous2Boolean)
            {
              WalletCardElementUI.y(WalletCardElementUI.this).setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }));
              WalletCardElementUI.j(WalletCardElementUI.this, paramAnonymous2Int1);
              WalletCardElementUI.k(WalletCardElementUI.this, paramAnonymous2Int2);
              WalletCardElementUI.l(WalletCardElementUI.this, paramAnonymous2Int3);
              WalletCardElementUI.b(WalletCardElementUI.this);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(174511);
          }
        };
        if ((WalletCardElementUI.z(WalletCardElementUI.this) > 0) && (WalletCardElementUI.A(WalletCardElementUI.this) > 0) && (WalletCardElementUI.B(WalletCardElementUI.this) > 0)) {
          paramAnonymousView.bC(WalletCardElementUI.z(WalletCardElementUI.this), WalletCardElementUI.A(WalletCardElementUI.this), WalletCardElementUI.B(WalletCardElementUI.this));
        }
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174512);
      }
    });
    this.VNa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70776);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WalletCardElementUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        paramAnonymousView.putExtra("exclude_countries_iso", WalletCardElementUI.w(WalletCardElementUI.this));
        paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
        paramAnonymousView.putExtra("ui_title", WalletCardElementUI.this.getString(a.i.wallet_select_country_title));
        WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 6);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70776);
      }
    });
    this.VNn.setChecked(true);
    this.VNn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(174513);
        WalletCardElementUI.b(WalletCardElementUI.this);
        AppMethodBeat.o(174513);
      }
    });
    findViewById(a.f.agree_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70778);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        i.a(WalletCardElementUI.this, WalletCardElementUI.v(WalletCardElementUI.this).hAk, WalletCardElementUI.v(WalletCardElementUI.this).JFk, false, WalletCardElementUI.v(WalletCardElementUI.this).VFx);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70778);
      }
    });
    this.VNd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174514);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
        if (Bankcard.asi(WalletCardElementUI.v(WalletCardElementUI.this).Vyb)) {
          paramAnonymousView.putExtra("IsAutoPosition", false);
        }
        for (;;)
        {
          WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174514);
          return;
          paramAnonymousView.putExtra("IsRealNameVerifyScene", true);
          paramAnonymousView.putExtra("IsNeedShowSearchBar", true);
        }
      }
    });
    this.VMU.setOnInputValidChangeListener(this);
    this.lDJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174515);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletCardElementUI.C(WalletCardElementUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174515);
      }
    });
    setEditFocusListener(this.VNk, 0, false, false, true);
    setEditFocusListener(this.Vre, 1, false, false, true);
    setEditFocusListener(this.VMR, 0, false, false, true);
    if ((this.Vzs != null) && (!Util.isNullOrNil(this.Vzs.VFl)))
    {
      k.a(this, this.Vzs.VFl, null, true, null);
      this.Vzs = null;
    }
    for (;;)
    {
      kD(true);
      bZk();
      Object localObject = com.tencent.mm.wallet_core.a.cm(this);
      if ((localObject == null) || (!((e)localObject).jOh())) {
        break label1478;
      }
      localObject = (Orders)getInput().getParcelable("key_orders");
      if ((localObject == null) || (((Orders)localObject).VGH != 1)) {
        break;
      }
      this.VNm = true;
      this.VLW.setText(i.bEN(((Orders)localObject).VBL));
      this.VLW.setEnabled(false);
      this.VLW.setFocusable(false);
      this.Vrj = ((Orders)localObject).VGI;
      this.VMQ.setText(u.iiK().bf(this, this.Vrj));
      this.VMQ.setEnabled(false);
      this.Vre.setText(((Orders)localObject).VFb);
      this.Vre.setInputEnable(false);
      this.Vre.setFocusable(false);
      this.Vrf.setText(a.i.wallet_card_assigned_userinfo_tips);
      AppMethodBeat.o(70800);
      return;
      if ((getInput().getInt("key_bind_scene", -1) == 5) && (!this.Vzs.VFB))
      {
        k.a(this, getString(a.i.wallet_wx_offline_no_support_micropay_dialog_content), null, true, null);
        this.Vzs.JFk = null;
      }
    }
    this.VNm = false;
    label1478:
    AppMethodBeat.o(70800);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70810);
    Log.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (this.VNi.j(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(70810);
      return;
    }
    if ((paramInt1 == 6) && (paramInt2 == 100))
    {
      if (!Util.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        this.VNA = paramIntent.getStringExtra("iso_code");
        this.VNa.setText(paramIntent.getStringExtra("country_name"));
      }
      AppMethodBeat.o(70810);
      return;
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(70810);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      bZk();
      AppMethodBeat.o(70810);
      return;
      this.Vzs = null;
      this.VND = 0;
      this.mSelectBankName = paramIntent.getStringExtra("bank_name");
      this.VMM.setText(this.mSelectBankName);
      this.VNB.setVisibility(0);
      this.VNB.setText("");
      bhg(this.mSelectBankName);
      if (this.VNC.size() == 1) {
        this.Vzs = ((ElementQuery)this.VNC.get(0));
      }
      Log.i("MicroMsg.WalletCardElmentUI", "select bank: %s, %s", new Object[] { this.mSelectBankName, Integer.valueOf(this.VNC.size()) });
      this.VLY = null;
      kD(false);
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.VNp = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.Kju = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.Kjv = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        if (Util.isNullOrNil(str1))
        {
          this.VNd.setText(str3 + " " + str4);
          label486:
          if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.Vzs.VFs)) {
            break label709;
          }
          this.VNg.setVisibility(0);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", new Object[] { str1, str2, str3, str4, this.Kjv });
        break;
        this.VNd.setText(str1 + " " + str4);
        break label486;
        if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.Kjv = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.VNd.setText(str1 + " " + str3);
          break label486;
        }
        this.Kjv = this.VNp;
        this.VNd.setText(str1);
        break label486;
        label709:
        this.VNg.setVisibility(8);
      }
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.VNk.set3DesValStr(paramIntent);
      continue;
      str1 = paramIntent.getStringExtra("CountryName");
      str2 = paramIntent.getStringExtra("ProviceName");
      str3 = paramIntent.getStringExtra("CityName");
      this.countryCode = paramIntent.getStringExtra("Country");
      this.provinceCode = paramIntent.getStringExtra("Contact_Province");
      this.cityCode = paramIntent.getStringExtra("Contact_City");
      paramIntent = new StringBuilder();
      if (!Util.isNullOrNil(str1)) {
        paramIntent.append(str1);
      }
      if (!Util.isNullOrNil(str2)) {
        paramIntent.append(" ").append(str2);
      }
      if (!Util.isNullOrNil(str3)) {
        paramIntent.append(" ").append(str3);
      }
      this.VMT.setText(paramIntent.toString());
      continue;
      this.Vzt = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
      this.VMS.setText(this.Vzt.VBJ);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70799);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.Vzs = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.OsJ = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.Vrj = u.iiC().ijr();
    this.VLY = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
    this.VNq = getInput().getBoolean("key_need_area", false);
    this.VNr = getInput().getBoolean("key_need_profession", false);
    this.VNy = getInput().getBoolean("key_need_country", false);
    this.VNz = getInput().getStringArray("key_country_excludes");
    if (this.Vzs != null) {
      bhg(this.Vzs.JFk);
    }
    Log.d("MicroMsg.WalletCardElmentUI", "neeCountry: %s", new Object[] { Boolean.valueOf(this.VNy) });
    if ((this.VNq) || (this.VNr)) {
      setMMTitle(a.i.wallet_elment_title2);
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
      setMMTitle(a.i.wallet_elment_title);
    }
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    Log.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    this.VAw = new String[100];
    int i = 0;
    while (i < this.VAw.length)
    {
      this.VAw[i] = getString(a.i.wallet_cre_count, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    paramBundle = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
    if ((this.OsJ != null) && (paramBundle != null))
    {
      this.VnX = g.VLx.a(this.OsJ);
      if (this.VnX == null) {
        break label478;
      }
      paramBundle = this.VnX.bhd(paramBundle.VFC);
      this.VNl = this.VnX.bgY(paramBundle);
    }
    for (;;)
    {
      initView();
      this.lDL.pageScroll(33);
      m.a(this, getInput(), 3);
      this.VqO.alive();
      AppMethodBeat.o(70799);
      return;
      label478:
      Log.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70815);
    this.VqO.dead();
    super.onDestroy();
    AppMethodBeat.o(70815);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(70814);
    Log.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      if (this.VNj == null) {
        ikE();
      }
      AppMethodBeat.o(70814);
      return false;
    }
    boolean bool1;
    if (this.VNj != null)
    {
      paramTextView = this.VNj;
      if (paramTextView.agVJ != null)
      {
        bool1 = paramTextView.agVJ.isFocusable();
        if (!bool1) {
          break label157;
        }
        paramTextView = this.VNj;
        bool1 = bool2;
        if (paramTextView.agVJ != null) {
          bool1 = paramTextView.agVJ.isClickable();
        }
        if ((!bool1) || (!this.VNj.jPB())) {
          break label157;
        }
        this.VNj.jPE();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70814);
      return true;
      bool1 = false;
      break;
      label157:
      this.VNj.performClick();
      continue;
      ikE();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70813);
    bZk();
    AppMethodBeat.o(70813);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(70809);
    Log.i("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      Log.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramp instanceof ae))
      {
        Log.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
        com.tencent.mm.wallet_core.a.k(this, paramString);
        AppMethodBeat.o(70809);
        return true;
      }
      AppMethodBeat.o(70809);
      return false;
    }
    AppMethodBeat.o(70809);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI
 * JD-Core Version:    0.7.0.1
 */