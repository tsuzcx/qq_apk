package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.by.c;
import com.tencent.mm.model.ab;
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
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
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
  private String EqO;
  private String EqP;
  private Orders Ivh;
  private TextView KWo;
  private IListener OBB;
  private WalletFormView OBS;
  private TextView OBT;
  private TextView OBU;
  private int OBX;
  private ElementQuery OJG;
  private Profession OJH;
  private List<dtk> OKI;
  private String[] OKK;
  private WalletFormView OVH;
  private Bankcard OVI;
  private WalletFormView OWA;
  private WalletFormView OWB;
  private WalletFormView OWC;
  private WalletFormView OWD;
  private WalletFormView OWE;
  private WalletFormView OWF;
  private WalletFormView OWG;
  private WalletFormView OWH;
  private WalletFormView OWI;
  private WalletFormView OWJ;
  private WalletFormView OWK;
  private WalletFormView OWL;
  private WalletFormView OWM;
  private WalletFormView OWN;
  private WalletFormView OWO;
  private WalletFormView OWP;
  private WalletFormView OWQ;
  private WalletFormView OWR;
  private WalletFormView OWS;
  private WalletFormView OWT;
  private WalletPhoneInputView OWU;
  private WalletFormView OWV;
  private WalletFormView OWW;
  private Map<String, e.a> OWX;
  private boolean OWY;
  private CheckBox OWZ;
  private TextView OWp;
  private TextView OWq;
  private TextView OWr;
  private TextView OWs;
  private TextView OWt;
  private TextView OWu;
  private TextView OWv;
  private TextView OWw;
  private TextView OWx;
  private WalletFormView OWy;
  private WalletFormView OWz;
  private String OXA;
  private boolean OXB;
  private int OXC;
  private int OXD;
  private int OXE;
  private View.OnClickListener OXF;
  private CheckBox OXa;
  private String OXb;
  private boolean OXc;
  private boolean OXd;
  private boolean OXe;
  private boolean OXf;
  private boolean OXg;
  private boolean OXh;
  private boolean OXi;
  private boolean OXj;
  private boolean OXk;
  private String[] OXl;
  private String OXm;
  private WalletFormView OXn;
  private List<ElementQuery> OXo;
  private int OXp;
  private int OXq;
  private int OXr;
  private int OXs;
  private int OXt;
  private int OXu;
  private int OXv;
  private int OXw;
  private int OXx;
  private int OXy;
  private String OXz;
  private Authen OxB;
  e OyM;
  private String cityCode;
  private String countryCode;
  private Button jbJ;
  private ScrollView jbL;
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
    this.OWV = null;
    this.OJG = new ElementQuery();
    this.OxB = new Authen();
    this.Ivh = null;
    this.mPayInfo = null;
    this.OVI = null;
    this.OWX = null;
    this.OyM = null;
    this.OWY = false;
    this.OBX = 1;
    this.OXe = false;
    this.OXf = false;
    this.OXg = false;
    this.OXh = false;
    this.OXi = false;
    this.OXj = false;
    this.OXk = false;
    this.OXl = null;
    this.OXo = new ArrayList();
    this.OKI = new ArrayList();
    this.OXF = new WalletCardElementUI.11(this);
    this.OBB = new WalletCardElementUI.13(this);
    AppMethodBeat.o(70798);
  }
  
  private void Cg(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(70805);
    if (paramBoolean)
    {
      Object localObject = this.KWo;
      if (this.OJG.OPs)
      {
        i = 0;
        ((TextView)localObject).setVisibility(i);
        localObject = this.OWN;
        if (!this.OJG.OPs) {
          break label225;
        }
        i = 0;
        label54:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.OWO;
        if (!this.OJG.OPt) {
          break label231;
        }
        i = 0;
        label78:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.OWP;
        if (!this.OJG.OPu) {
          break label237;
        }
        i = 0;
        label102:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.OWQ;
        if (!this.OJG.OPx) {
          break label243;
        }
        i = 0;
        label126:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.OWR;
        if (!this.OJG.OPz) {
          break label249;
        }
        i = 0;
        label150:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.OWS;
        if (!this.OJG.OPy) {
          break label255;
        }
        i = 0;
        label174:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.OWT;
        if (!this.OJG.OPA) {
          break label261;
        }
      }
      label261:
      for (int i = j;; i = 8)
      {
        ((WalletFormView)localObject).setVisibility(i);
        this.OWv.setVisibility(4);
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
    this.KWo.setVisibility(8);
    this.OWN.setVisibility(8);
    this.OWO.setVisibility(8);
    this.OWP.setVisibility(8);
    this.OWQ.setVisibility(8);
    this.OWR.setVisibility(8);
    this.OWS.setVisibility(8);
    this.OWT.setVisibility(8);
    this.OWv.setVisibility(8);
    AppMethodBeat.o(70805);
  }
  
  private void a(WalletFormView paramWalletFormView, int paramInt)
  {
    AppMethodBeat.i(70816);
    paramWalletFormView = paramWalletFormView.getLogicDelegate();
    if ((paramWalletFormView instanceof com.tencent.mm.wallet_core.ui.formview.a.a))
    {
      ((com.tencent.mm.wallet_core.ui.formview.a.a)paramWalletFormView).azL(paramInt);
      amD(paramInt);
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
        paramArrayOfWalletFormView[i].fuo();
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
  
  private void amD(int paramInt)
  {
    AppMethodBeat.i(70817);
    if (paramInt == 1)
    {
      setEditFocusListener(this.OBS, 1, false, false, false);
      AppMethodBeat.o(70817);
      return;
    }
    setEditFocusListener(this.OBS, 1, true, false, false);
    AppMethodBeat.o(70817);
  }
  
  private boolean bAu()
  {
    AppMethodBeat.i(70812);
    WalletFormView localWalletFormView = this.OWV;
    this.OWV = null;
    if (!this.OWy.jf(null))
    {
      if ((this.OWV == null) && (localWalletFormView != this.OWy)) {
        this.OWV = this.OWy;
      }
      this.OWs.setText(a.i.wallet_card_bankcard_type_err_tips);
      this.OWs.setTextColor(getResources().getColor(a.c.red));
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (!this.OVH.jf(null))
      {
        if ((this.OWV == null) && (localWalletFormView != this.OVH)) {
          this.OWV = this.OVH;
        }
        bool1 = false;
      }
      if (!this.OWW.jf(this.OWq))
      {
        if ((this.OWV == null) && (localWalletFormView != this.OWW)) {
          this.OWV = this.OWW;
        }
        bool1 = false;
      }
      int i;
      if ((!this.OBS.jf(this.OBU)) && (!this.OWY))
      {
        if ((this.OWV == null) && (localWalletFormView != this.OBS)) {
          this.OWV = this.OBS;
        }
        this.OBU.setText(a.i.wallet_card_identify_err_hint);
        this.OBU.setTextColor(getResources().getColor(a.c.red));
        i = 1;
      }
      for (boolean bool2 = false;; bool2 = bool1)
      {
        bool1 = bool2;
        if (this.OXe)
        {
          bool1 = bool2;
          if (!this.OWI.jf(null))
          {
            if ((this.OWV == null) && (localWalletFormView != this.OWI)) {
              this.OWV = this.OWI;
            }
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (this.OXf)
        {
          bool2 = bool1;
          if (!this.OWK.jf(null))
          {
            if ((this.OWV == null) && (localWalletFormView != this.OWK)) {
              this.OWV = this.OWK;
            }
            bool2 = false;
          }
        }
        if (!this.OWD.jf(this.OBU)) {
          if (i != 0)
          {
            this.OBU.setText(a.i.wallet_card_err_id_phone);
            this.OBU.setTextColor(getResources().getColor(a.c.red));
            if ((this.OWV == null) && (localWalletFormView != this.OWD)) {
              this.OWV = this.OWD;
            }
            bool1 = false;
            label401:
            if (this.OBU.getVisibility() == 4)
            {
              if (!this.OJG.OPd) {
                break label1165;
              }
              this.OBU.setText(getString(a.i.wallet_card_identify_first_tips));
              label436:
              this.OBU.setTextColor(getResources().getColor(a.c.hint_text_color));
              this.OBU.setVisibility(0);
            }
            if (this.OWA.jf(this.OWu)) {
              break label1220;
            }
            if ((this.OWV == null) && (localWalletFormView != this.OWA)) {
              this.OWV = this.OWA;
            }
            i = 1;
            bool1 = false;
          }
        }
        for (;;)
        {
          if (!this.OWz.jf(this.OWu))
          {
            if ((this.OWV == null) && (localWalletFormView != this.OWz)) {
              this.OWV = this.OWz;
            }
            bool2 = false;
            label543:
            if (!this.OWZ.isChecked()) {
              bool2 = false;
            }
            if (!this.OWN.jf(this.OWv))
            {
              if ((this.OWV == null) && (localWalletFormView != this.OWN)) {
                this.OWV = this.OWN;
              }
              bool2 = false;
            }
            if (!this.OWO.jf(this.OWv))
            {
              if ((this.OWV == null) && (localWalletFormView != this.OWO)) {
                this.OWV = this.OWO;
              }
              bool2 = false;
            }
            if (!this.OWP.jf(this.OWv))
            {
              if ((this.OWV == null) && (localWalletFormView != this.OWP)) {
                this.OWV = this.OWP;
              }
              bool2 = false;
            }
            if (!this.OWQ.jf(this.OWv))
            {
              if ((this.OWV == null) && (localWalletFormView != this.OWQ)) {
                this.OWV = this.OWQ;
              }
              bool2 = false;
            }
            if (!this.OWR.jf(this.OWv))
            {
              if ((this.OWV == null) && (localWalletFormView != this.OWR)) {
                this.OWV = this.OWR;
              }
              bool2 = false;
            }
            if (!this.OWS.jf(this.OWv))
            {
              if ((this.OWV == null) && (localWalletFormView != this.OWS)) {
                this.OWV = this.OWS;
              }
              bool2 = false;
            }
            if (!this.OWT.jf(this.OWv))
            {
              if ((this.OWV == null) && (localWalletFormView != this.OWT)) {
                this.OWV = this.OWT;
              }
              bool2 = false;
            }
            bool1 = bool2;
            if (this.OXd)
            {
              bool1 = bool2;
              if (!this.OWE.jf(null))
              {
                if ((this.OWV == null) && (localWalletFormView != this.OWE)) {
                  this.OWV = this.OWE;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.OXc)
            {
              bool2 = bool1;
              if (!this.OWF.jf(null))
              {
                if ((this.OWV == null) && (localWalletFormView != this.OWF)) {
                  this.OWV = this.OWF;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.OXc)
            {
              bool1 = bool2;
              if (!this.OWG.jf(null))
              {
                if ((this.OWV == null) && (localWalletFormView != this.OWG)) {
                  this.OWV = this.OWG;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.OXB)
            {
              bool2 = bool1;
              if (!this.OWH.jf(null))
              {
                if ((this.OWV == null) && (localWalletFormView != this.OWH)) {
                  this.OWV = this.OWH;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.OXh)
            {
              bool1 = bool2;
              if (!this.OWL.jf(null))
              {
                if ((this.OWV == null) && (localWalletFormView != this.OWL)) {
                  this.OWV = this.OWL;
                }
                bool1 = false;
              }
            }
            if (!bool1) {
              break label1201;
            }
            this.jbJ.setEnabled(true);
            this.jbJ.setClickable(true);
            if (localWalletFormView != null) {
              localWalletFormView.setImeOptions(1073741824);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(70812);
            return bool1;
            this.OBU.setText(a.i.wallet_card_err_phone);
            this.OBU.setTextColor(getResources().getColor(a.c.red));
            break;
            bool1 = bool2;
            if (i == 0) {
              break label401;
            }
            this.OBU.setVisibility(0);
            bool1 = bool2;
            break label401;
            label1165:
            this.OBU.setText(getString(a.i.wallet_card_identify_security));
            break label436;
            bool2 = bool1;
            if (i == 0) {
              break label543;
            }
            this.OWu.setVisibility(4);
            bool2 = bool1;
            break label543;
            label1201:
            this.jbJ.setEnabled(false);
            this.jbJ.setClickable(false);
          }
          label1220:
          i = 0;
        }
        i = 0;
      }
    }
  }
  
  private void bhx(String paramString)
  {
    AppMethodBeat.i(70811);
    Object localObject = u.gJw().OIn;
    this.OXo.clear();
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
        } while (!localElementQuery.DNV.equals(paramString));
        Log.i("MicroMsg.WalletCardElmentUI", "add element: %s, %s", new Object[] { localElementQuery.DNV, localElementQuery.fvP });
        this.OXo.add(localElementQuery);
        if ((getInput().getInt("key_bind_scene", -1) == 5) && (!localElementQuery.OPH)) {
          localElementQuery.OPr = getString(a.i.wallet_wx_offline_no_support);
        }
      } while (this.OXo.size() < 2);
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
  
  private void gLl()
  {
    AppMethodBeat.i(70801);
    Object localObject;
    if (gLq()) {
      localObject = getInput().getString("realname_verify_process_get_wording_cache");
    }
    try
    {
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = (cbj)new cbj().parseFrom(((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.OKI.addAll(((cbj)localObject).TjT);
      }
      localObject = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      if (localObject != null)
      {
        this.mTrueName = ((RealNameBundle)localObject).OMa;
        this.OXA = ((RealNameBundle)localObject).OMw;
        this.sex = ((RealNameBundle)localObject).sex;
        if ((this.OJG != null) && (this.OJG.gIY() != null) && (this.OJG.gIY().contains(Integer.valueOf(((RealNameBundle)localObject).OMd))))
        {
          Log.i("MicroMsg.WalletCardElmentUI", "set cretype: %s", new Object[] { Integer.valueOf(((RealNameBundle)localObject).OMd), this.OJG.gIY() });
          this.OBX = ((RealNameBundle)localObject).OMd;
          this.OWC.setText(((RealNameBundle)localObject).OMe);
          this.OBS.setText(((RealNameBundle)localObject).OMb);
          a(this.OBS, this.OBX);
          if (((RealNameBundle)localObject).OMm != 9999) {
            break label606;
          }
          this.OWK.setText(getString(a.i.wc_pay_realname_input_long_term_hint_text));
          this.OXq = 9999;
          this.OXr = 12;
          this.OXs = 31;
          this.OWJ.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(((RealNameBundle)localObject).OMy), Integer.valueOf(((RealNameBundle)localObject).OMz), Integer.valueOf(((RealNameBundle)localObject).OMA) }));
          this.mSelectCreCountIndex = ((RealNameBundle)localObject).OMk;
          this.OWI.setText(this.OKK[this.mSelectCreCountIndex]);
        }
        this.OVH.setText(((RealNameBundle)localObject).OMa);
        this.countryCode = ((RealNameBundle)localObject).OMg;
        this.provinceCode = ((RealNameBundle)localObject).OMh;
        this.cityCode = ((RealNameBundle)localObject).OMi;
        this.OWF.setText(((RealNameBundle)localObject).OMj);
        this.OWG.setText(((RealNameBundle)localObject).OMw);
        this.OXm = ((RealNameBundle)localObject).OMt;
        this.OWM.setText(((RealNameBundle)localObject).OMu);
        this.OJH = ((RealNameBundle)localObject).OMf;
        if (this.OJH != null) {
          this.OWE.setText(this.OJH.OLY);
        }
        this.OXC = (((RealNameBundle)localObject).sex - 1);
        if (this.OXC < 0) {
          this.OXC = 0;
        }
        WalletFormView localWalletFormView = this.OWH;
        if (((RealNameBundle)localObject).sex != 1) {
          break label656;
        }
        i = a.i.sex_male;
        localWalletFormView.setText(getString(i));
        this.OXw = ((RealNameBundle)localObject).OMq;
        this.OXx = ((RealNameBundle)localObject).OMr;
        this.OXy = ((RealNameBundle)localObject).OMs;
        if ((this.OXw > 0) && (this.OXx > 0) && (this.OXy > 0)) {
          this.OWL.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.OXw), Integer.valueOf(this.OXx), Integer.valueOf(this.OXy) }));
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
        this.OWK.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(localIOException.OMm), Integer.valueOf(localIOException.OMn), Integer.valueOf(localIOException.OMo) }));
        continue;
        label656:
        int i = a.i.sex_female;
      }
    }
  }
  
  private void gLm()
  {
    AppMethodBeat.i(70802);
    Object localObject1;
    Object localObject2;
    if (this.OJG.OPF == 0)
    {
      this.OWU.gMA();
      localObject1 = u.gJw().OTr;
      if (localObject1 == null) {
        break label172;
      }
      localObject2 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.wallet_core.id_verify.model.a)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).fvP.equals(this.OJG.fvP))
          {
            label77:
            localObject2 = this.OWU;
            if (localObject1 != null)
            {
              if (Util.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).OLI)) {
                break label177;
              }
              ((WalletPhoneInputView)localObject2).PfG.setHint(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).OLI);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).OLJ)) {
        ((WalletPhoneInputView)localObject2).PfN = ((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).OLJ;
      }
      AppMethodBeat.o(70802);
      return;
      this.OWU.gMB();
      localObject1 = (EditText)this.OWU.findViewById(a.f.prefix_input_et);
      setEditFocusListener(this.OWU.getPhoneNumberEt(), (EditText)localObject1, 0, false, false, true);
      break;
      label172:
      localObject1 = null;
      break label77;
      label177:
      ((WalletPhoneInputView)localObject2).PfG.setHint(((WalletPhoneInputView)localObject2).getContext().getString(a.i.wallet_card_mobile_hint));
    }
  }
  
  private void gLn()
  {
    AppMethodBeat.i(70808);
    Object localObject1;
    boolean bool;
    if (bAu())
    {
      com.tencent.mm.plugin.wallet_core.utils.j.gMO();
      if (!Util.isNullOrNil(this.OJG.OPp))
      {
        localObject1 = getInput();
        if ((this.OXa.getVisibility() == 0) && (this.OXa.isChecked()))
        {
          bool = true;
          ((Bundle)localObject1).putBoolean("key_is_follow_bank_username", bool);
          getInput().putString("key_bank_username", this.OJG.OPp);
        }
      }
      else
      {
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if ((this.OJG != null) && (localObject1 != null) && (this.OyM != null) && (this.OWX != null))
        {
          if (!this.OWX.containsKey(this.OJG.fvP)) {
            break label1487;
          }
          ((FavorPayInfo)localObject1).OPI = ((e.a)this.OWX.get(this.OJG.fvP)).OVi.OwC;
          label168:
          getInput().putParcelable("key_favor_pay_info", (Parcelable)localObject1);
        }
        this.OxB = new Authen();
        if (this.OVI != null)
        {
          this.OxB.GGC = this.OVI.ONB;
          this.OxB.CBX = this.OVI.field_bankcardTail;
        }
        localObject1 = getInput().getString("key_card_id");
        if (this.OWW.getVisibility() != 0) {
          break label1555;
        }
        localObject1 = this.OWW.getText();
      }
    }
    label524:
    label1555:
    for (;;)
    {
      this.OxB.HzF = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.OxB.OMS = ((String)localObject1);
      this.OxB.fvP = this.OJG.fvP;
      this.OxB.OMR = this.OBX;
      this.OxB.OMP = getInput().getString("key_pwd1");
      if (!Util.isNullOrNil(this.OWA.getText())) {
        this.OxB.OMT = this.OWA.getText();
      }
      this.OxB.OIl = this.OWD.getText();
      this.OxB.OMW = this.OWN.getText();
      this.OxB.OMX = this.OWO.getText();
      this.OxB.country = this.OXb;
      this.OxB.province = this.EqO;
      this.OxB.city = this.EqP;
      this.OxB.lLg = this.OWQ.getText();
      this.OxB.DNX = this.OWR.getText();
      this.OxB.nkC = this.OWS.getText();
      this.OxB.hDf = this.OWT.getText();
      String str = com.tencent.mm.wallet_core.ui.g.bCq(this.OxB.OIl);
      getInput().putString("key_mobile", str);
      localObject1 = getInput();
      label736:
      Object localObject2;
      if (this.OJG.OIp == 2)
      {
        bool = true;
        ((Bundle)localObject1).putBoolean("key_is_oversea", bool);
        this.OxB.OMQ = this.OBS.getText();
        this.OxB.OMa = this.OVH.getText();
        this.OxB.OMU = this.OWz.getText();
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if (localObject1 != null)
        {
          this.OxB.OMY = ((FavorPayInfo)localObject1).OPL;
          this.OxB.OMZ = ((FavorPayInfo)localObject1).OPI;
        }
        this.OxB.ONe = ("+" + this.OWU.getCountryCode());
        this.OxB.OMk = this.mSelectCreCountIndex;
        if (this.OXq != 9999) {
          break label1511;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "is long term");
        localObject1 = new TenpaySecureEncrypt();
        this.OxB.OMl = ((TenpaySecureEncrypt)localObject1).desedeEncode(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.OXq), Integer.valueOf(this.OXr), Integer.valueOf(this.OXs) }), com.tencent.mm.wallet_core.ui.g.ijw());
        Log.d("MicroMsg.WalletCardElmentUI", "expire date: %s", new Object[] { this.OWK.getText() });
        this.OxB.OMp = this.OWL.getText();
        Log.d("MicroMsg.WalletCardElmentUI", "birth date: %s", new Object[] { this.OWL.getText() });
        localObject2 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new RealNameBundle();
        }
        ((RealNameBundle)localObject1).OMa = this.OVH.getText();
        ((RealNameBundle)localObject1).sex = (this.OXC + 1);
        ((RealNameBundle)localObject1).OMg = this.countryCode;
        ((RealNameBundle)localObject1).OMh = this.provinceCode;
        ((RealNameBundle)localObject1).OMi = this.cityCode;
        ((RealNameBundle)localObject1).OMw = this.OWG.getText();
        ((RealNameBundle)localObject1).OMf = this.OJH;
        ((RealNameBundle)localObject1).OMt = this.OXm;
        ((RealNameBundle)localObject1).OMp = this.OWL.getText();
        ((RealNameBundle)localObject1).OMd = this.OBX;
        ((RealNameBundle)localObject1).OMe = this.OWC.getText();
        ((RealNameBundle)localObject1).OMb = "";
        ((RealNameBundle)localObject1).OMc = this.OBS.getText();
        ((RealNameBundle)localObject1).OMx = this.OWJ.getText();
        ((RealNameBundle)localObject1).OMl = this.OWK.getText();
        ((RealNameBundle)localObject1).OMk = this.mSelectCreCountIndex;
        getInput().putParcelable("realname_verify_process_bundle", (Parcelable)localObject1);
        Log.d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", new Object[] { Integer.valueOf(this.OxB.OMk), this.OxB.OMl, this.OxB.OMp });
        if ((gLp()) && (!Util.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!Util.isNullOrNil(getInput().getString("key_true_name"))))
        {
          Log.i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
          this.OxB.OMQ = getInput().getString("key_identity");
          this.OxB.OMR = getInput().getInt("key_id_type", -1);
          this.OxB.OMa = this.mTrueName;
          Log.i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.OxB.OMa);
        }
        Log.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.OxB.HzF + " elemt.bankcardTag : " + this.OJG.OIp);
        Log.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.OJG.OIp);
        localObject2 = getInput();
        ((Bundle)localObject2).putString("key_mobile", str);
        ((Bundle)localObject2).putParcelable("key_authen", this.OxB);
        ((Bundle)localObject2).putString("key_bank_phone", this.OJG.OPo);
        ((Bundle)localObject2).putString("key_country_code", this.countryCode);
        ((Bundle)localObject2).putString("key_province_code", this.provinceCode);
        ((Bundle)localObject2).putString("key_city_code", this.cityCode);
        ((Bundle)localObject2).putParcelable("key_profession", this.OJH);
        ((Bundle)localObject2).putString("key_country_iso", this.OXm);
        ((Bundle)localObject2).putString("key_bind_card_type", this.OxB.fvP);
        ((Bundle)localObject2).putString("key_bind_card_show1", this.OJG.DNV);
        if (2 != this.OJG.OPl) {
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
          this.OxB.ONf = 1;
          this.OxB.OIv = ((String)localObject1);
        }
        this.OxB.ONg = ((Bundle)localObject2).getString("kreq_token");
        if (!getNetController().r(new Object[] { this.OxB, this.Ivh })) {
          break label1539;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
        AppMethodBeat.o(70808);
        return;
        bool = false;
        break;
        ((FavorPayInfo)localObject1).OPI = this.OyM.cU(((FavorPayInfo)localObject1).OPI, false);
        break label168;
        bool = false;
        break label524;
        this.OxB.OMl = this.OWK.getText();
        break label736;
      }
      Log.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70808);
      return;
    }
  }
  
  private void gLo()
  {
    AppMethodBeat.i(70818);
    Object localObject;
    if ((this.OJG != null) && (this.OWX != null) && (this.OWX.containsKey(this.OJG.fvP)))
    {
      localObject = (e.a)this.OWX.get(this.OJG.fvP);
      if ((localObject == null) || (((e.a)localObject).OVi == null)) {
        break label133;
      }
    }
    label133:
    for (double d = ((e.a)localObject).OVj;; d = 0.0D)
    {
      localObject = getString(a.i.wallet_card_bank_favor_tips, new Object[] { com.tencent.mm.wallet_core.ui.g.F(d) });
      this.OWw.setText((CharSequence)localObject);
      this.OWw.setVisibility(0);
      AppMethodBeat.o(70818);
      return;
      this.OWw.setVisibility(8);
      AppMethodBeat.o(70818);
      return;
    }
  }
  
  private boolean gLp()
  {
    AppMethodBeat.i(70819);
    boolean bool = getInput().getBoolean("key_is_forgot_process", false);
    AppMethodBeat.o(70819);
    return bool;
  }
  
  private boolean gLq()
  {
    AppMethodBeat.i(174523);
    d locald = getProcess();
    if ((locald != null) && ("realname_verify_process".equals(locald.epb())))
    {
      if (locald.fKb.getInt("real_name_verify_mode", 0) == 4)
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
  
  private void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(70803);
    if (this.OJG == null) {
      this.OJG = new ElementQuery();
    }
    Log.i("MicroMsg.WalletCardElmentUI", "element: %s, %s", new Object[] { this.OJG.DNV, this.OJG.fvP });
    gLm();
    gLo();
    com.tencent.mm.wallet_core.a.bF(this);
    Object localObject1 = (Bankcard)getInput().getParcelable("key_bankcard");
    Object localObject2;
    Object localObject3;
    if ((gLp()) && (localObject1 != null))
    {
      this.OWW.setHint(getString(a.i.wallet_card_forgot_id_hint, new Object[] { ((Bankcard)localObject1).field_bankcardTail }));
      localObject1 = this.OWW;
      localObject2 = this.OWp;
      localObject3 = this.OWq;
      a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
      localObject1 = this.OWy;
      localObject2 = this.OWr;
      localObject3 = this.OWs;
      a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
    }
    for (;;)
    {
      if (paramBoolean) {
        gLl();
      }
      this.OXe = false;
      this.OXf = false;
      this.OXh = false;
      this.OXi = false;
      if (!gLq()) {
        break;
      }
      localObject1 = this.OKI.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dtk)((Iterator)localObject1).next();
        if (((dtk)localObject2).TZF.key == this.OBX)
        {
          this.OXe = ((dtk)localObject2).TZJ;
          this.OXf = ((dtk)localObject2).TZI;
          this.OXg = ((dtk)localObject2).TZM;
          this.OXh = ((dtk)localObject2).TZK;
          this.OXB = ((dtk)localObject2).TZO;
          this.OXd = ((dtk)localObject2).TZG;
          this.OXc = ((dtk)localObject2).TZH;
          this.OXj = ((dtk)localObject2).TZL;
          this.OXi = true;
        }
      }
      if (!Util.isNullOrNil(this.OJG.DNV))
      {
        this.OWy.setText(this.OJG.DNV);
        if (!this.OJG.gIJ()) {
          break label561;
        }
        this.OXn.setVisibility(0);
        this.OXn.setText(getString(a.i.wallet_credit_card));
      }
      for (;;)
      {
        localObject1 = this.OWW;
        localObject2 = this.OWp;
        localObject3 = this.OWq;
        a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        localObject1 = this.OWy;
        localObject2 = this.OWr;
        localObject3 = this.OWs;
        a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        this.OWW.setOnInfoIvClickListener(this.OXF);
        if (!u.gJo().gJY().gJF()) {
          break label596;
        }
        this.OWW.getInfoIv().setImageResource(a.h.wallet_scan_camera);
        this.OWW.getInfoIv().setVisibility(0);
        break;
        label561:
        if (this.OJG.gIX())
        {
          this.OXn.setVisibility(0);
          this.OXn.setText(getString(a.i.wallet_deposit_card));
        }
      }
      label596:
      this.OWW.getInfoIv().setVisibility(4);
    }
    Object localObject4;
    WalletFormView localWalletFormView1;
    WalletFormView localWalletFormView2;
    TextView localTextView1;
    TextView localTextView2;
    boolean bool1;
    boolean bool2;
    if ((this.OJG.OPG != null) && (!this.OJG.OPG.isEmpty()))
    {
      Log.i("MicroMsg.WalletCardElmentUI", "identity type： %s", new Object[] { Integer.valueOf(this.OBX) });
      localObject1 = this.OJG.OPG.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CreTypeRuleInfo)((Iterator)localObject1).next();
        if (((CreTypeRuleInfo)localObject2).OOK == this.OBX)
        {
          if (((CreTypeRuleInfo)localObject2).OOL.OOG == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show cre count");
            this.OXe = true;
          }
          if (((CreTypeRuleInfo)localObject2).OOL.OOI == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show cre expire");
            this.OXf = true;
          }
          if (((CreTypeRuleInfo)localObject2).OOL.OOH == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show birthday");
            this.OXh = true;
          }
          if (((CreTypeRuleInfo)localObject2).OOL.OOJ == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show cre type");
            if (u.gJo().gKa() > 0)
            {
              Log.i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
              this.OXi = true;
            }
          }
        }
      }
      if ((this.OBX == 2) && (this.OXk))
      {
        this.OXj = true;
        if (!this.OXf)
        {
          this.OXq = 0;
          this.OXr = 0;
          this.OXs = 0;
        }
        if (!this.OXh)
        {
          this.OXw = 0;
          this.OXx = 0;
          this.OXy = 0;
        }
        if (!this.OXe) {
          this.mSelectCreCountIndex = 0;
        }
        this.OWB.setVisibility(8);
        if (!Bankcard.amv(this.OJG.OIp)) {
          break label1497;
        }
        localObject1 = this.OVH;
        localObject2 = this.OWC;
        localObject3 = this.OBS;
        localObject4 = this.OWI;
        localWalletFormView1 = this.OWJ;
        localWalletFormView2 = this.OWK;
        localTextView1 = this.OBT;
        localTextView2 = this.OBU;
        a(new boolean[] { 0, 0, 0, 0, 0, 0 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.OWD.setVisibility(8);
        Cg(true);
        paramBoolean = this.OXh;
        bool1 = this.OXj;
        bool2 = this.OXB;
        localObject1 = this.OWF;
        localObject2 = this.OWG;
        localObject3 = this.OWE;
        localObject4 = this.OWL;
        localWalletFormView1 = this.OWM;
        localWalletFormView2 = this.OWH;
        localTextView1 = this.OWx;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        paramBoolean = this.OJG.OPf;
        bool1 = this.OJG.OPg;
        localObject1 = this.OWA;
        localObject2 = this.OWz;
        localObject3 = this.OWt;
        localObject4 = this.OWu;
        a(new boolean[] { paramBoolean, bool1 }, new WalletFormView[] { localObject1, localObject2 }, (TextView)localObject3, (TextView)localObject4);
        if (this.OWy.getVisibility() != 0) {
          break label2960;
        }
        switch (this.OJG.OPk)
        {
        default: 
          this.OWs.setVisibility(8);
          label1325:
          this.OWs.setTextColor(getResources().getColor(a.c.normal_color));
        }
      }
    }
    for (;;)
    {
      if ((!Util.isNullOrNil(this.OJG.OPE)) && (this.OWs.getVisibility() != 0))
      {
        Log.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
        this.OWs.setText(this.OJG.OPE);
        this.OWs.setVisibility(0);
      }
      if ((Util.isNullOrNil(this.OJG.OPp)) || (!ab.Ql(this.OJG.OPp)) || (gLp())) {
        break label2972;
      }
      this.OXa.setText(this.OJG.OPq);
      this.OXa.setVisibility(0);
      AppMethodBeat.o(70803);
      return;
      this.OXj = false;
      break;
      if ((this.OBX == 2) && (this.OXk))
      {
        this.OXj = true;
        break;
      }
      this.OXj = false;
      break;
      label1497:
      int i;
      if ((this.OJG.gIY() != null) && (this.OJG.gIY().size() > 0))
      {
        i = 1;
        label1524:
        if ((!gLp()) && (!u.gJo().gJS())) {
          break label2440;
        }
        localObject2 = u.gJo().getTrueName();
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          if (getProcess() != null) {
            localObject1 = getProcess().fKb.getString("key_true_name");
          }
        }
        if (Util.isNullOrNil((String)localObject1)) {
          break label2252;
        }
        localObject1 = getString(a.i.wallet_card_username_hint_forget, new Object[] { com.tencent.mm.wallet_core.ui.g.bCp((String)localObject1) });
        this.OVH.setHint((CharSequence)localObject1);
        this.OWB.setHint((CharSequence)localObject1);
        label1633:
        if ((!gLp()) || (Util.isNullOrNil(getInput().getString("key_identity"))) || (getInput().getInt("key_id_type", -1) == -1) || (Util.isNullOrNil(getInput().getString("key_true_name")))) {
          break label2282;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
        paramBoolean = this.OXe;
        bool1 = this.OXg;
        bool2 = this.OXf;
        localObject1 = this.OVH;
        localObject2 = this.OWC;
        localObject3 = this.OBS;
        localObject4 = this.OWI;
        localWalletFormView1 = this.OWJ;
        localWalletFormView2 = this.OWK;
        localTextView1 = this.OBT;
        localTextView2 = this.OBU;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.mTrueName = getInput().getString("key_true_name");
        Log.i("MicroMsg.WalletCardElmentUI", "name is " + this.mTrueName);
        this.OWD.setVisibility(0);
        if (this.OVI != null)
        {
          if (!Util.isNullOrNil(this.OVI.field_mobile)) {
            d(this.OWD, this.OVI.field_mobile);
          }
          if (!Util.isNullOrNil(this.OVI.OMT)) {
            d(this.OWA, this.OVI.OMT);
          }
          if (!Util.isNullOrNil(this.OVI.ONA)) {
            d(this.OWz, this.OVI.ONA);
          }
        }
        if (!this.OJG.OPd) {
          break label2681;
        }
        this.OBU.setText("");
      }
      for (;;)
      {
        if (!Util.isNullOrNil(this.OJG.OPh)) {
          this.OBS.setText(this.OJG.OPh);
        }
        if (u.gJo().gKa() <= 0) {
          break label2698;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", new Object[] { Integer.valueOf(u.gJo().gKa()) });
        this.OWC.setClickable(false);
        this.OWC.setText(u.gJw().iR(this));
        this.OWC.setInputEnable(false);
        a(this.OBS, this.OBX);
        Cg(false);
        paramBoolean = this.OXB;
        bool1 = this.OXc;
        bool2 = this.OXc;
        boolean bool3 = this.OXd;
        boolean bool4 = this.OXh;
        boolean bool5 = this.OXj;
        localObject1 = this.OWH;
        localObject2 = this.OWF;
        localObject3 = this.OWG;
        localObject4 = this.OWE;
        localWalletFormView1 = this.OWL;
        localWalletFormView2 = this.OWM;
        localTextView1 = this.OWx;
        a(new boolean[] { paramBoolean, bool1, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        break;
        i = 0;
        break label1524;
        label2252:
        localObject1 = getString(a.i.wallet_card_username_hint);
        this.OVH.setHint((CharSequence)localObject1);
        this.OWB.setHint((CharSequence)localObject1);
        break label1633;
        label2282:
        if ((this.OXi) || (i != 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool1 = this.OXe;
          bool2 = this.OXg;
          bool3 = this.OXf;
          localObject1 = this.OVH;
          localObject2 = this.OWC;
          localObject3 = this.OBS;
          localObject4 = this.OWI;
          localWalletFormView1 = this.OWJ;
          localWalletFormView2 = this.OWK;
          localTextView1 = this.OBT;
          localTextView2 = this.OBU;
          a(new boolean[] { true, paramBoolean, true, bool1, bool2, bool3 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          break;
        }
        label2440:
        bool1 = this.OJG.OPd;
        if ((this.OXi) || ((i != 0) && (this.OJG.OPe))) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool2 = this.OJG.OPe;
          bool3 = this.OXe;
          bool4 = this.OXg;
          bool5 = this.OXf;
          localObject1 = this.OVH;
          localObject2 = this.OWC;
          localObject3 = this.OBS;
          localObject4 = this.OWI;
          localWalletFormView1 = this.OWJ;
          localWalletFormView2 = this.OWK;
          localTextView1 = this.OBT;
          localTextView2 = this.OBU;
          a(new boolean[] { bool1, paramBoolean, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          this.OWD.setVisibility(0);
          Log.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.OJG.OPd + " canModifyIdentity:" + this.OJG.OPe);
          break;
        }
        label2681:
        this.OBU.setText(getString(a.i.wallet_card_identify_security));
      }
      label2698:
      if (this.OJG.gIY() != null)
      {
        i = this.OJG.gIY().size();
        label2721:
        Log.i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", new Object[] { Integer.valueOf(i) });
        if (i > 1) {
          break label2876;
        }
        this.OWC.setClickable(false);
        this.OWC.setInputEnable(false);
        this.OBS.setInputEnable(true);
      }
      for (;;)
      {
        localObject1 = this.OJG.gIY();
        if ((localObject1 == null) || (!((List)localObject1).contains(Integer.valueOf(this.OBX)))) {
          this.OBX = 1;
        }
        if (!u.gJw().aN(this, this.OBX).equals(this.OXz)) {
          com.tencent.mm.plugin.report.service.h.IzE.a(16816, new Object[] { Integer.valueOf(this.OBX) });
        }
        this.OWC.setText(u.gJw().aN(this, this.OBX));
        break;
        i = 0;
        break label2721;
        label2876:
        this.OWC.setClickable(true);
        this.OWC.setInputEnable(true);
        this.OBS.setInputEnable(true);
      }
      this.OWs.setText(a.i.wallet_card_cardtype_tipmsg_cn);
      this.OWs.setVisibility(0);
      break label1325;
      this.OWs.setVisibility(8);
      break label1325;
      this.OWs.setVisibility(8);
      break label1325;
      this.OWs.setVisibility(8);
      break label1325;
      label2960:
      this.OWs.setVisibility(8);
    }
    label2972:
    this.OXa.setVisibility(8);
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
    this.OWp = ((TextView)findViewById(a.f.wallet_card_forgot_id_tipmsg));
    this.OWW = ((WalletFormView)findViewById(a.f.wallet_card_forgot_id));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.OWW);
    this.OWq = ((TextView)findViewById(a.f.wallet_card_forgot_id_err_tipmsg));
    this.OBT = ((TextView)findViewById(a.f.wallet_card_identify_tipmsg));
    this.OVH = ((WalletFormView)findViewById(a.f.name_et));
    this.OWB = ((WalletFormView)findViewById(a.f.forgot_name_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.OVH);
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.OWB);
    this.OWC = ((WalletFormView)findViewById(a.f.wallet_cre_type));
    this.OBS = ((WalletFormView)findViewById(a.f.identity_et));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.OBS);
    this.OBU = ((TextView)findViewById(a.f.wallet_card_identify_err_hint));
    this.OWr = ((TextView)findViewById(a.f.wallet_card_bankcard_type_tipmsg));
    this.OWy = ((WalletFormView)findViewById(a.f.wallet_card_name));
    this.OXn = ((WalletFormView)findViewById(a.f.wallet_card_type));
    this.OWs = ((TextView)findViewById(a.f.wallet_card_cardtype_tipmsg));
    this.OWw = ((TextView)findViewById(a.f.wallet_card_favor));
    this.OWt = ((TextView)findViewById(a.f.wallet_card_cvv_tipmsg));
    this.OWA = ((WalletFormView)findViewById(a.f.cvv_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.OWA);
    this.OWz = ((WalletFormView)findViewById(a.f.date_et));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.OWz);
    this.OWu = ((TextView)findViewById(a.f.wallet_card_cvv_err_tipmsg));
    this.KWo = ((TextView)findViewById(a.f.wallet_card_address_tipmsg));
    this.OWN = ((WalletFormView)findViewById(a.f.first_name_et));
    this.OWO = ((WalletFormView)findViewById(a.f.last_name_et));
    this.OWP = ((WalletFormView)findViewById(a.f.area_et));
    this.OWQ = ((WalletFormView)findViewById(a.f.address_et));
    this.OWR = ((WalletFormView)findViewById(a.f.phone_et));
    this.OWS = ((WalletFormView)findViewById(a.f.post_et));
    this.OWT = ((WalletFormView)findViewById(a.f.email_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.OWT);
    this.OWv = ((TextView)findViewById(a.f.wallet_card_address_err_tipmsg));
    this.OWZ = ((CheckBox)findViewById(a.f.agree_wx_cb));
    this.OXa = ((CheckBox)findViewById(a.f.agree_follow_bank_cb));
    this.jbJ = ((Button)findViewById(a.f.next_btn));
    this.jbL = ((ScrollView)findViewById(a.f.wallet_sv));
    this.OWE = ((WalletFormView)findViewById(a.f.private_profession_et));
    this.OWF = ((WalletFormView)findViewById(a.f.private_area_et));
    this.OWG = ((WalletFormView)findViewById(a.f.private_address_et));
    this.OWH = ((WalletFormView)findViewById(a.f.private_sex_et));
    this.OWI = ((WalletFormView)findViewById(a.f.wallet_cre_change_times));
    this.OWJ = ((WalletFormView)findViewById(a.f.wallet_cre_effect_date));
    this.OWK = ((WalletFormView)findViewById(a.f.wallet_cre_expire_date));
    this.OWL = ((WalletFormView)findViewById(a.f.private_birthday_et));
    this.OWM = ((WalletFormView)findViewById(a.f.private_country_et));
    this.OWx = ((TextView)findViewById(a.f.wallet_card_private_info_tipmsg));
    this.OWU = ((WalletPhoneInputView)findViewById(a.f.mobile_new_et));
    this.OWD = this.OWU.getPhoneNumberEt();
    this.OVH.setOnInputValidChangeListener(this);
    this.OWB.setOnInputValidChangeListener(this);
    this.OWW.setOnInputValidChangeListener(this);
    this.OWC.setOnInputValidChangeListener(this);
    this.OBS.setOnInputValidChangeListener(this);
    this.OWD.setOnInputValidChangeListener(new WalletFormView.a()
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
    this.OWA.setOnInputValidChangeListener(this);
    this.OWz.setOnInputValidChangeListener(this);
    this.OWN.setOnInputValidChangeListener(this);
    this.OWO.setOnInputValidChangeListener(this);
    this.OWP.setOnInputValidChangeListener(this);
    this.OWQ.setOnInputValidChangeListener(this);
    this.OWR.setOnInputValidChangeListener(this);
    this.OWS.setOnInputValidChangeListener(this);
    this.OWT.setOnInputValidChangeListener(this);
    this.OWE.setOnInputValidChangeListener(this);
    this.OWF.setOnInputValidChangeListener(this);
    this.OVH.setOnEditorActionListener(this);
    this.OWB.setOnEditorActionListener(this);
    this.OWW.setOnEditorActionListener(this);
    this.OWC.setOnEditorActionListener(this);
    this.OBS.setOnEditorActionListener(this);
    this.OWD.setOnEditorActionListener(this);
    this.OWA.setOnEditorActionListener(this);
    this.OWz.setOnEditorActionListener(this);
    this.OWN.setOnEditorActionListener(this);
    this.OWO.setOnEditorActionListener(this);
    this.OWP.setOnEditorActionListener(this);
    this.OWQ.setOnEditorActionListener(this);
    this.OWR.setOnEditorActionListener(this);
    this.OWS.setOnEditorActionListener(this);
    this.OWT.setOnEditorActionListener(this);
    this.OWF.setOnEditorActionListener(this);
    this.OWE.setOnEditorActionListener(this);
    this.OWy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70786);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardElementUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putInt("key_bind_scene", WalletCardElementUI.this.getInput().getInt("key_bind_scene", -1));
        Util.isNullOrNil(WalletCardElementUI.c(WalletCardElementUI.this).getText());
        WalletCardElementUI.this.hideTenpayKB();
        localObject = com.tencent.mm.wallet_core.a.bF(WalletCardElementUI.this);
        if (localObject != null) {
          ((d)localObject).a(WalletCardElementUI.this, WalletBankCardSelectUI.class, paramAnonymousView, 1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70786);
      }
    });
    this.OXn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70788);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(WalletCardElementUI.this.getString(a.i.wallet_deposit_card));
        paramAnonymousView.add(WalletCardElementUI.this.getString(a.i.wallet_credit_card));
        if (WalletCardElementUI.d(WalletCardElementUI.this).size() == 1)
        {
          localObject = (ElementQuery)WalletCardElementUI.d(WalletCardElementUI.this).get(0);
          if (!((ElementQuery)localObject).gIX()) {
            break label180;
          }
          paramAnonymousView.remove(1);
        }
        for (;;)
        {
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.ayK(WalletCardElementUI.e(WalletCardElementUI.this));
          paramAnonymousView.YrN = new b.b()
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
                  if (((i != 0) && (paramAnonymous2Object2.gIX())) || ((i == 0) && (paramAnonymous2Object2.gIJ())))
                  {
                    WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymous2Object2);
                    WalletCardElementUI.g(WalletCardElementUI.this);
                  }
                }
                WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymousView.idp());
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
          if (((ElementQuery)localObject).gIJ()) {
            paramAnonymousView.remove(0);
          }
        }
      }
    });
    this.OWC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70789);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletCardElementUI.h(WalletCardElementUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70789);
      }
    });
    this.OWI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext(), WalletCardElementUI.i(WalletCardElementUI.this));
        paramAnonymousView.YrN = new b.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(70790);
            if (paramAnonymous2Boolean)
            {
              WalletCardElementUI.j(WalletCardElementUI.this).setText((String)paramAnonymous2Object1);
              WalletCardElementUI.b(WalletCardElementUI.this, paramAnonymousView.idp());
              WalletCardElementUI.b(WalletCardElementUI.this);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(70790);
          }
        };
        paramAnonymousView.ayK(WalletCardElementUI.k(WalletCardElementUI.this));
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70791);
      }
    });
    this.OWJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70793);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.a(WalletCardElementUI.this.getContext());
        paramAnonymousView.YrF = new com.tencent.mm.ui.widget.picker.a.a()
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
        paramAnonymousView.bd(i, j, k);
        localObject = WalletCardElementUI.l(WalletCardElementUI.this).getContentEt().getText().toString();
        if ((WalletCardElementUI.m(WalletCardElementUI.this) > 0) && (WalletCardElementUI.n(WalletCardElementUI.this) > 0) && (WalletCardElementUI.o(WalletCardElementUI.this) > 0)) {
          paramAnonymousView.bb(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
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
            paramAnonymousView.bb(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
          }
        }
      }
    });
    this.OWK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70794);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.a(WalletCardElementUI.this.getContext());
        paramAnonymousView.YrF = new com.tencent.mm.ui.widget.picker.a.a()
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
        paramAnonymousView.bc(i, j, k);
        paramAnonymousView.bd(i + 200, 12, 31);
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
          paramAnonymousView.bb(1, 1, 1);
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
          paramAnonymousView.bb(WalletCardElementUI.q(WalletCardElementUI.this), WalletCardElementUI.r(WalletCardElementUI.this), WalletCardElementUI.s(WalletCardElementUI.this));
        }
      }
    });
    this.OWH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70795);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = WalletCardElementUI.this.getResources().getStringArray(a.b.wc_pay_realname_sex_selection);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext(), paramAnonymousView);
        paramAnonymousView.YrN = new b.b()
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
              paramAnonymousView.ayK(WalletCardElementUI.u(WalletCardElementUI.this));
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
    this.OWF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70797);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("GetAddress", true);
        paramAnonymousView.putExtra("ShowSelectedLocation", false);
        if (!Bankcard.amv(WalletCardElementUI.v(WalletCardElementUI.this).OIp))
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
    this.OWE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70774);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent(WalletCardElementUI.this.getContext(), WalletSelectProfessionUI.class);
        paramAnonymousView.putExtra("key_profession_list", WalletCardElementUI.x(WalletCardElementUI.this));
        WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 5);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70774);
      }
    });
    this.OWL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(174512);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.a(WalletCardElementUI.this.getContext());
        paramAnonymousView.YrF = new com.tencent.mm.ui.widget.picker.a.a()
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
          paramAnonymousView.bb(WalletCardElementUI.z(WalletCardElementUI.this), WalletCardElementUI.A(WalletCardElementUI.this), WalletCardElementUI.B(WalletCardElementUI.this));
        }
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174512);
      }
    });
    this.OWM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70776);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    this.OWZ.setChecked(true);
    this.OWZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.wallet_core.ui.g.b(WalletCardElementUI.this, WalletCardElementUI.v(WalletCardElementUI.this).fvP, WalletCardElementUI.v(WalletCardElementUI.this).DNV, false, WalletCardElementUI.v(WalletCardElementUI.this).OPD);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70778);
      }
    });
    this.OWP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174514);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
        if (Bankcard.amv(WalletCardElementUI.v(WalletCardElementUI.this).OIp)) {
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
    this.OWG.setOnInputValidChangeListener(this);
    this.jbJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174515);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletCardElementUI.C(WalletCardElementUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174515);
      }
    });
    setEditFocusListener(this.OWW, 0, false, false, true);
    setEditFocusListener(this.OBS, 1, false, false, true);
    setEditFocusListener(this.OWD, 0, false, false, true);
    if ((this.OJG != null) && (!Util.isNullOrNil(this.OJG.OPr)))
    {
      com.tencent.mm.ui.base.h.a(this, this.OJG.OPr, null, true, null);
      this.OJG = null;
    }
    for (;;)
    {
      jq(true);
      bAu();
      Object localObject = com.tencent.mm.wallet_core.a.bF(this);
      if ((localObject == null) || (!((d)localObject).iim())) {
        break label1478;
      }
      localObject = (Orders)getInput().getParcelable("key_orders");
      if ((localObject == null) || (((Orders)localObject).OQN != 1)) {
        break;
      }
      this.OWY = true;
      this.OVH.setText(com.tencent.mm.wallet_core.ui.g.bCp(((Orders)localObject).OMa));
      this.OVH.setEnabled(false);
      this.OVH.setFocusable(false);
      this.OBX = ((Orders)localObject).OQO;
      this.OWC.setText(u.gJw().aN(this, this.OBX));
      this.OWC.setEnabled(false);
      this.OBS.setText(((Orders)localObject).OPh);
      this.OBS.setInputEnable(false);
      this.OBS.setFocusable(false);
      this.OBT.setText(a.i.wallet_card_assigned_userinfo_tips);
      AppMethodBeat.o(70800);
      return;
      if ((getInput().getInt("key_bind_scene", -1) == 5) && (!this.OJG.OPH))
      {
        com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_wx_offline_no_support_micropay_dialog_content), null, true, null);
        this.OJG.DNV = null;
      }
    }
    this.OWY = false;
    label1478:
    AppMethodBeat.o(70800);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70810);
    Log.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (this.OWU.g(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(70810);
      return;
    }
    if ((paramInt1 == 6) && (paramInt2 == 100))
    {
      if (!Util.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        this.OXm = paramIntent.getStringExtra("iso_code");
        this.OWM.setText(paramIntent.getStringExtra("country_name"));
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
      bAu();
      AppMethodBeat.o(70810);
      return;
      this.OJG = null;
      this.OXp = 0;
      this.mSelectBankName = paramIntent.getStringExtra("bank_name");
      this.OWy.setText(this.mSelectBankName);
      this.OXn.setVisibility(0);
      this.OXn.setText("");
      bhx(this.mSelectBankName);
      if (this.OXo.size() == 1) {
        this.OJG = ((ElementQuery)this.OXo.get(0));
      }
      Log.i("MicroMsg.WalletCardElmentUI", "select bank: %s, %s", new Object[] { this.mSelectBankName, Integer.valueOf(this.OXo.size()) });
      this.OVI = null;
      jq(false);
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.OXb = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.EqO = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.EqP = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        if (Util.isNullOrNil(str1))
        {
          this.OWP.setText(str3 + " " + str4);
          label486:
          if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.OJG.OPy)) {
            break label709;
          }
          this.OWS.setVisibility(0);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", new Object[] { str1, str2, str3, str4, this.EqP });
        break;
        this.OWP.setText(str1 + " " + str4);
        break label486;
        if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.EqP = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.OWP.setText(str1 + " " + str3);
          break label486;
        }
        this.EqP = this.OXb;
        this.OWP.setText(str1);
        break label486;
        label709:
        this.OWS.setVisibility(8);
      }
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.OWW.set3DesValStr(paramIntent);
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
      this.OWF.setText(paramIntent.toString());
      continue;
      this.OJH = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
      this.OWE.setText(this.OJH.OLY);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70799);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.OJG = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.Ivh = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.OBX = u.gJo().gKa();
    this.OVI = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
    this.OXc = getInput().getBoolean("key_need_area", false);
    this.OXd = getInput().getBoolean("key_need_profession", false);
    this.OXk = getInput().getBoolean("key_need_country", false);
    this.OXl = getInput().getStringArray("key_country_excludes");
    if (this.OJG != null) {
      bhx(this.OJG.DNV);
    }
    Log.d("MicroMsg.WalletCardElmentUI", "neeCountry: %s", new Object[] { Boolean.valueOf(this.OXk) });
    if ((this.OXc) || (this.OXd)) {
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
    this.OKK = new String[100];
    int i = 0;
    while (i < this.OKK.length)
    {
      this.OKK[i] = getString(a.i.wallet_cre_count, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    paramBundle = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
    if ((this.Ivh != null) && (paramBundle != null))
    {
      this.OyM = f.OVk.a(this.Ivh);
      if (this.OyM == null) {
        break label482;
      }
      paramBundle = this.OyM.bhu(paramBundle.OPI);
      this.OWX = this.OyM.bhp(paramBundle);
    }
    for (;;)
    {
      initView();
      this.jbL.pageScroll(33);
      com.tencent.mm.plugin.wallet_core.utils.j.a(this, getInput(), 3);
      EventCenter.instance.addListener(this.OBB);
      AppMethodBeat.o(70799);
      return;
      label482:
      Log.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70815);
    EventCenter.instance.removeListener(this.OBB);
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
      if (this.OWV == null) {
        gLn();
      }
      AppMethodBeat.o(70814);
      return false;
    }
    boolean bool1;
    if (this.OWV != null)
    {
      paramTextView = this.OWV;
      if (paramTextView.YXE != null)
      {
        bool1 = paramTextView.YXE.isFocusable();
        if (!bool1) {
          break label157;
        }
        paramTextView = this.OWV;
        bool1 = bool2;
        if (paramTextView.YXE != null) {
          bool1 = paramTextView.YXE.isClickable();
        }
        if ((!bool1) || (!this.OWV.ijB())) {
          break label157;
        }
        this.OWV.ijE();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70814);
      return true;
      bool1 = false;
      break;
      label157:
      this.OWV.performClick();
      continue;
      gLn();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70813);
    bAu();
    AppMethodBeat.o(70813);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70809);
    Log.i("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      Log.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramq instanceof ae))
      {
        Log.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
        com.tencent.mm.wallet_core.a.l(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI
 * JD-Core Version:    0.7.0.1
 */