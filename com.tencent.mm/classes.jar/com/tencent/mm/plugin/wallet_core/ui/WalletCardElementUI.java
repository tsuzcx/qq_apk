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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.si;
import com.tencent.mm.model.w;
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
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.crb;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.a;
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
  private TextView AhI;
  private Authen CIo;
  d CJy;
  private int CMB;
  private com.tencent.mm.sdk.b.c CMf;
  private WalletFormView CMx;
  private TextView CMy;
  private TextView CMz;
  private ElementQuery CQB;
  private Profession CQC;
  private List<crb> CRE;
  private String[] CRF;
  private WalletFormView DcA;
  private Bankcard DcC;
  private WalletFormView DdA;
  private WalletFormView DdB;
  private WalletFormView DdC;
  private WalletFormView DdD;
  private WalletFormView DdE;
  private WalletFormView DdF;
  private WalletFormView DdG;
  private WalletFormView DdH;
  private WalletFormView DdI;
  private WalletFormView DdJ;
  private WalletFormView DdK;
  private WalletFormView DdL;
  private WalletFormView DdM;
  private WalletFormView DdN;
  private WalletFormView DdO;
  private WalletFormView DdP;
  private WalletPhoneInputView DdQ;
  private WalletFormView DdR;
  private WalletFormView DdS;
  private Map<String, d.a> DdT;
  private boolean DdU;
  private CheckBox DdV;
  private CheckBox DdW;
  private String DdX;
  private boolean DdY;
  private boolean DdZ;
  private TextView Ddl;
  private TextView Ddm;
  private TextView Ddn;
  private TextView Ddo;
  private TextView Ddp;
  private TextView Ddq;
  private TextView Ddr;
  private TextView Dds;
  private TextView Ddt;
  private WalletFormView Ddu;
  private WalletFormView Ddv;
  private WalletFormView Ddw;
  private WalletFormView Ddx;
  private WalletFormView Ddy;
  private WalletFormView Ddz;
  private int DeA;
  private View.OnClickListener DeB;
  private boolean Dea;
  private boolean Deb;
  private boolean Dec;
  private boolean Ded;
  private boolean Dee;
  private boolean Def;
  private boolean Deg;
  private String[] Deh;
  private String Dei;
  private WalletFormView Dej;
  private List<ElementQuery> Dek;
  private int Del;
  private int Dem;
  private int Den;
  private int Deo;
  private int Dep;
  private int Deq;
  private int Der;
  private int Des;
  private int Det;
  private int Deu;
  private String Dev;
  private String Dew;
  private boolean Dex;
  private int Dey;
  private int Dez;
  private String cityCode;
  private String countryCode;
  private int ePk;
  private Button fQh;
  private ScrollView fQj;
  private PayInfo mPayInfo;
  private Profession[] mProfessions;
  private String mSelectBankName;
  private int mSelectCreCountIndex;
  private String mTrueName;
  private String provinceCode;
  private String vgX;
  private String vgY;
  private Orders ygb;
  
  public WalletCardElementUI()
  {
    AppMethodBeat.i(70798);
    this.DdR = null;
    this.CQB = new ElementQuery();
    this.CIo = new Authen();
    this.ygb = null;
    this.mPayInfo = null;
    this.DcC = null;
    this.DdT = null;
    this.CJy = null;
    this.DdU = false;
    this.CMB = 1;
    this.Dea = false;
    this.Deb = false;
    this.Dec = false;
    this.Ded = false;
    this.Dee = false;
    this.Def = false;
    this.Deg = false;
    this.Deh = null;
    this.Dek = new ArrayList();
    this.CRE = new ArrayList();
    this.DeB = new WalletCardElementUI.11(this);
    this.CMf = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(70798);
  }
  
  private void VE(int paramInt)
  {
    AppMethodBeat.i(70817);
    if (paramInt == 1)
    {
      setEditFocusListener(this.CMx, 1, false, false, false);
      AppMethodBeat.o(70817);
      return;
    }
    setEditFocusListener(this.CMx, 1, true, false, false);
    AppMethodBeat.o(70817);
  }
  
  private void a(WalletFormView paramWalletFormView, int paramInt)
  {
    AppMethodBeat.i(70816);
    paramWalletFormView = paramWalletFormView.getLogicDelegate();
    if ((paramWalletFormView instanceof a.a))
    {
      ((a.a)paramWalletFormView).ags(paramInt);
      VE(paramInt);
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
        paramArrayOfWalletFormView[i].dEe();
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
  
  private void aET(String paramString)
  {
    AppMethodBeat.i(70811);
    Object localObject = t.eFG().CPh;
    this.Dek.clear();
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
        } while (!localElementQuery.uJF.equals(paramString));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "add element: %s, %s", new Object[] { localElementQuery.uJF, localElementQuery.dkR });
        this.Dek.add(localElementQuery);
        if ((getInput().getInt("key_bind_scene", -1) == 5) && (!localElementQuery.CWK)) {
          localElementQuery.CWu = getString(2131765969);
        }
      } while (this.Dek.size() < 2);
    }
    AppMethodBeat.o(70811);
  }
  
  private boolean aUW()
  {
    AppMethodBeat.i(70812);
    WalletFormView localWalletFormView = this.DdR;
    this.DdR = null;
    if (!this.Ddu.ho(null))
    {
      if ((this.DdR == null) && (localWalletFormView != this.Ddu)) {
        this.DdR = this.Ddu;
      }
      this.Ddo.setText(2131765091);
      this.Ddo.setTextColor(getResources().getColor(2131100798));
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (!this.DcA.ho(null))
      {
        if ((this.DdR == null) && (localWalletFormView != this.DcA)) {
          this.DdR = this.DcA;
        }
        bool1 = false;
      }
      if (!this.DdS.ho(this.Ddm))
      {
        if ((this.DdR == null) && (localWalletFormView != this.DdS)) {
          this.DdR = this.DdS;
        }
        bool1 = false;
      }
      int i;
      if ((!this.CMx.ho(this.CMz)) && (!this.DdU))
      {
        if ((this.DdR == null) && (localWalletFormView != this.CMx)) {
          this.DdR = this.CMx;
        }
        this.CMz.setText(2131765132);
        this.CMz.setTextColor(getResources().getColor(2131100798));
        i = 1;
      }
      for (boolean bool2 = false;; bool2 = bool1)
      {
        bool1 = bool2;
        if (this.Dea)
        {
          bool1 = bool2;
          if (!this.DdE.ho(null))
          {
            if ((this.DdR == null) && (localWalletFormView != this.DdE)) {
              this.DdR = this.DdE;
            }
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (this.Deb)
        {
          bool2 = bool1;
          if (!this.DdG.ho(null))
          {
            if ((this.DdR == null) && (localWalletFormView != this.DdG)) {
              this.DdR = this.DdG;
            }
            bool2 = false;
          }
        }
        if (!this.Ddz.ho(this.CMz)) {
          if (i != 0)
          {
            this.CMz.setText(2131765125);
            this.CMz.setTextColor(getResources().getColor(2131100798));
            if ((this.DdR == null) && (localWalletFormView != this.Ddz)) {
              this.DdR = this.Ddz;
            }
            bool1 = false;
            label401:
            if (this.CMz.getVisibility() == 4)
            {
              if (!this.CQB.CWg) {
                break label1165;
              }
              this.CMz.setText(getString(2131765133));
              label436:
              this.CMz.setTextColor(getResources().getColor(2131100490));
              this.CMz.setVisibility(0);
            }
            if (this.Ddw.ho(this.Ddq)) {
              break label1220;
            }
            if ((this.DdR == null) && (localWalletFormView != this.Ddw)) {
              this.DdR = this.Ddw;
            }
            i = 1;
            bool1 = false;
          }
        }
        for (;;)
        {
          if (!this.Ddv.ho(this.Ddq))
          {
            if ((this.DdR == null) && (localWalletFormView != this.Ddv)) {
              this.DdR = this.Ddv;
            }
            bool2 = false;
            label543:
            if (!this.DdV.isChecked()) {
              bool2 = false;
            }
            if (!this.DdJ.ho(this.Ddr))
            {
              if ((this.DdR == null) && (localWalletFormView != this.DdJ)) {
                this.DdR = this.DdJ;
              }
              bool2 = false;
            }
            if (!this.DdK.ho(this.Ddr))
            {
              if ((this.DdR == null) && (localWalletFormView != this.DdK)) {
                this.DdR = this.DdK;
              }
              bool2 = false;
            }
            if (!this.DdL.ho(this.Ddr))
            {
              if ((this.DdR == null) && (localWalletFormView != this.DdL)) {
                this.DdR = this.DdL;
              }
              bool2 = false;
            }
            if (!this.DdM.ho(this.Ddr))
            {
              if ((this.DdR == null) && (localWalletFormView != this.DdM)) {
                this.DdR = this.DdM;
              }
              bool2 = false;
            }
            if (!this.DdN.ho(this.Ddr))
            {
              if ((this.DdR == null) && (localWalletFormView != this.DdN)) {
                this.DdR = this.DdN;
              }
              bool2 = false;
            }
            if (!this.DdO.ho(this.Ddr))
            {
              if ((this.DdR == null) && (localWalletFormView != this.DdO)) {
                this.DdR = this.DdO;
              }
              bool2 = false;
            }
            if (!this.DdP.ho(this.Ddr))
            {
              if ((this.DdR == null) && (localWalletFormView != this.DdP)) {
                this.DdR = this.DdP;
              }
              bool2 = false;
            }
            bool1 = bool2;
            if (this.DdZ)
            {
              bool1 = bool2;
              if (!this.DdA.ho(null))
              {
                if ((this.DdR == null) && (localWalletFormView != this.DdA)) {
                  this.DdR = this.DdA;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.DdY)
            {
              bool2 = bool1;
              if (!this.DdB.ho(null))
              {
                if ((this.DdR == null) && (localWalletFormView != this.DdB)) {
                  this.DdR = this.DdB;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.DdY)
            {
              bool1 = bool2;
              if (!this.DdC.ho(null))
              {
                if ((this.DdR == null) && (localWalletFormView != this.DdC)) {
                  this.DdR = this.DdC;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.Dex)
            {
              bool2 = bool1;
              if (!this.DdD.ho(null))
              {
                if ((this.DdR == null) && (localWalletFormView != this.DdD)) {
                  this.DdR = this.DdD;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.Ded)
            {
              bool1 = bool2;
              if (!this.DdH.ho(null))
              {
                if ((this.DdR == null) && (localWalletFormView != this.DdH)) {
                  this.DdR = this.DdH;
                }
                bool1 = false;
              }
            }
            if (!bool1) {
              break label1201;
            }
            this.fQh.setEnabled(true);
            this.fQh.setClickable(true);
            if (localWalletFormView != null) {
              localWalletFormView.setImeOptions(1073741824);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(70812);
            return bool1;
            this.CMz.setText(2131765126);
            this.CMz.setTextColor(getResources().getColor(2131100798));
            break;
            bool1 = bool2;
            if (i == 0) {
              break label401;
            }
            this.CMz.setVisibility(0);
            bool1 = bool2;
            break label401;
            label1165:
            this.CMz.setText(getString(2131765136));
            break label436;
            bool2 = bool1;
            if (i == 0) {
              break label543;
            }
            this.Ddq.setVisibility(4);
            bool2 = bool1;
            break label543;
            label1201:
            this.fQh.setEnabled(false);
            this.fQh.setClickable(false);
          }
          label1220:
          i = 0;
        }
        i = 0;
      }
    }
  }
  
  private static void d(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(70804);
    if (!bt.isNullOrNil(paramString))
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
  
  private void eHs()
  {
    AppMethodBeat.i(70801);
    Object localObject;
    if (eHx()) {
      localObject = getInput().getString("realname_verify_process_get_wording_cache");
    }
    try
    {
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = (bhd)new bhd().parseFrom(((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.CRE.addAll(((bhd)localObject).GCF);
      }
      localObject = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      if (localObject != null)
      {
        this.mTrueName = ((RealNameBundle)localObject).CTa;
        this.Dew = ((RealNameBundle)localObject).CTw;
        this.ePk = ((RealNameBundle)localObject).ePk;
        if ((this.CQB != null) && (this.CQB.eFi() != null) && (this.CQB.eFi().contains(Integer.valueOf(((RealNameBundle)localObject).CTd))))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "set cretype: %s", new Object[] { Integer.valueOf(((RealNameBundle)localObject).CTd), this.CQB.eFi() });
          this.CMB = ((RealNameBundle)localObject).CTd;
          this.Ddy.setText(((RealNameBundle)localObject).CTe);
          this.CMx.setText(((RealNameBundle)localObject).CTb);
          a(this.CMx, this.CMB);
          if (((RealNameBundle)localObject).CTm != 9999) {
            break label606;
          }
          this.DdG.setText(getString(2131766450));
          this.Dem = 9999;
          this.Den = 12;
          this.Deo = 31;
          this.DdF.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(((RealNameBundle)localObject).CTy), Integer.valueOf(((RealNameBundle)localObject).CTz), Integer.valueOf(((RealNameBundle)localObject).CTA) }));
          this.mSelectCreCountIndex = ((RealNameBundle)localObject).CTk;
          this.DdE.setText(this.CRF[this.mSelectCreCountIndex]);
        }
        this.DcA.setText(((RealNameBundle)localObject).CTa);
        this.countryCode = ((RealNameBundle)localObject).CTg;
        this.provinceCode = ((RealNameBundle)localObject).CTh;
        this.cityCode = ((RealNameBundle)localObject).CTi;
        this.DdB.setText(((RealNameBundle)localObject).CTj);
        this.DdC.setText(((RealNameBundle)localObject).CTw);
        this.Dei = ((RealNameBundle)localObject).CTt;
        this.DdI.setText(((RealNameBundle)localObject).CTu);
        this.CQC = ((RealNameBundle)localObject).CTf;
        if (this.CQC != null) {
          this.DdA.setText(this.CQC.CSY);
        }
        this.Dey = (((RealNameBundle)localObject).ePk - 1);
        if (this.Dey < 0) {
          this.Dey = 0;
        }
        WalletFormView localWalletFormView = this.DdD;
        if (((RealNameBundle)localObject).ePk != 1) {
          break label656;
        }
        i = 2131763533;
        localWalletFormView.setText(getString(i));
        this.Des = ((RealNameBundle)localObject).CTq;
        this.Det = ((RealNameBundle)localObject).CTr;
        this.Deu = ((RealNameBundle)localObject).CTs;
        if ((this.Des > 0) && (this.Det > 0) && (this.Deu > 0)) {
          this.DdH.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.Des), Integer.valueOf(this.Det), Integer.valueOf(this.Deu) }));
        }
      }
      AppMethodBeat.o(70801);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WalletCardElmentUI", localIOException, "", new Object[0]);
        continue;
        label606:
        this.DdG.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(localIOException.CTm), Integer.valueOf(localIOException.CTn), Integer.valueOf(localIOException.CTo) }));
        continue;
        label656:
        int i = 2131763532;
      }
    }
  }
  
  private void eHt()
  {
    AppMethodBeat.i(70802);
    Object localObject1;
    Object localObject2;
    if (this.CQB.CWI == 0)
    {
      this.DdQ.eIF();
      localObject1 = t.eFG().Dap;
      if (localObject1 == null) {
        break label172;
      }
      localObject2 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.wallet_core.id_verify.model.a)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).dkR.equals(this.CQB.dkR))
          {
            label77:
            localObject2 = this.DdQ;
            if (localObject1 != null)
            {
              if (bt.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).CSC)) {
                break label177;
              }
              ((WalletPhoneInputView)localObject2).Dmy.setHint(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).CSC);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).CSD)) {
        ((WalletPhoneInputView)localObject2).DmF = ((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).CSD;
      }
      AppMethodBeat.o(70802);
      return;
      this.DdQ.eIG();
      localObject1 = (EditText)this.DdQ.findViewById(2131303383);
      setEditFocusListener(this.DdQ.getPhoneNumberEt(), (EditText)localObject1, 0, false, false, true);
      break;
      label172:
      localObject1 = null;
      break label77;
      label177:
      ((WalletPhoneInputView)localObject2).Dmy.setHint(((WalletPhoneInputView)localObject2).getContext().getString(2131765144));
    }
  }
  
  private void eHu()
  {
    AppMethodBeat.i(70808);
    Object localObject1;
    boolean bool;
    if (aUW())
    {
      f.eIT();
      if (!bt.isNullOrNil(this.CQB.CWs))
      {
        localObject1 = getInput();
        if ((this.DdW.getVisibility() == 0) && (this.DdW.isChecked()))
        {
          bool = true;
          ((Bundle)localObject1).putBoolean("key_is_follow_bank_username", bool);
          getInput().putString("key_bank_username", this.CQB.CWs);
        }
      }
      else
      {
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if ((this.CQB != null) && (localObject1 != null) && (this.CJy != null) && (this.DdT != null))
        {
          if (!this.DdT.containsKey(this.CQB.dkR)) {
            break label1487;
          }
          ((FavorPayInfo)localObject1).CWL = ((d.a)this.DdT.get(this.CQB.dkR)).Dcb.CHp;
          label168:
          getInput().putParcelable("key_favor_pay_info", (Parcelable)localObject1);
        }
        this.CIo = new Authen();
        if (this.DcC != null)
        {
          this.CIo.wBI = this.DcC.CUB;
          this.CIo.tUK = this.DcC.field_bankcardTail;
        }
        localObject1 = getInput().getString("key_card_id");
        if (this.DdS.getVisibility() != 0) {
          break label1555;
        }
        localObject1 = this.DdS.getText();
      }
    }
    label524:
    label1555:
    for (;;)
    {
      this.CIo.xnF = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.CIo.CTS = ((String)localObject1);
      this.CIo.dkR = this.CQB.dkR;
      this.CIo.CTR = this.CMB;
      this.CIo.CTP = getInput().getString("key_pwd1");
      if (!bt.isNullOrNil(this.Ddw.getText())) {
        this.CIo.CTT = this.Ddw.getText();
      }
      this.CIo.CPf = this.Ddz.getText();
      this.CIo.CTW = this.DdJ.getText();
      this.CIo.CTX = this.DdK.getText();
      this.CIo.country = this.DdX;
      this.CIo.ePu = this.vgX;
      this.CIo.ePv = this.vgY;
      this.CIo.hWY = this.DdM.getText();
      this.CIo.uJH = this.DdN.getText();
      this.CIo.jrN = this.DdO.getText();
      this.CIo.ePn = this.DdP.getText();
      String str = com.tencent.mm.wallet_core.ui.e.aYI(this.CIo.CPf);
      getInput().putString("key_mobile", str);
      localObject1 = getInput();
      label736:
      Object localObject2;
      if (this.CQB.CPj == 2)
      {
        bool = true;
        ((Bundle)localObject1).putBoolean("key_is_oversea", bool);
        this.CIo.CTQ = this.CMx.getText();
        this.CIo.CTa = this.DcA.getText();
        this.CIo.CTU = this.Ddv.getText();
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if (localObject1 != null)
        {
          this.CIo.CTY = ((FavorPayInfo)localObject1).CWO;
          this.CIo.CTZ = ((FavorPayInfo)localObject1).CWL;
        }
        this.CIo.CUe = ("+" + this.DdQ.getCountryCode());
        this.CIo.CTk = this.mSelectCreCountIndex;
        if (this.Dem != 9999) {
          break label1511;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "is long term");
        localObject1 = new TenpaySecureEncrypt();
        this.CIo.CTl = ((TenpaySecureEncrypt)localObject1).desedeEncode(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.Dem), Integer.valueOf(this.Den), Integer.valueOf(this.Deo) }), com.tencent.mm.wallet_core.ui.e.fSb());
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "expire date: %s", new Object[] { this.DdG.getText() });
        this.CIo.CTp = this.DdH.getText();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "birth date: %s", new Object[] { this.DdH.getText() });
        localObject2 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new RealNameBundle();
        }
        ((RealNameBundle)localObject1).CTa = this.DcA.getText();
        ((RealNameBundle)localObject1).ePk = (this.Dey + 1);
        ((RealNameBundle)localObject1).CTg = this.countryCode;
        ((RealNameBundle)localObject1).CTh = this.provinceCode;
        ((RealNameBundle)localObject1).CTi = this.cityCode;
        ((RealNameBundle)localObject1).CTw = this.DdC.getText();
        ((RealNameBundle)localObject1).CTf = this.CQC;
        ((RealNameBundle)localObject1).CTt = this.Dei;
        ((RealNameBundle)localObject1).CTp = this.DdH.getText();
        ((RealNameBundle)localObject1).CTd = this.CMB;
        ((RealNameBundle)localObject1).CTe = this.Ddy.getText();
        ((RealNameBundle)localObject1).CTb = "";
        ((RealNameBundle)localObject1).CTc = this.CMx.getText();
        ((RealNameBundle)localObject1).CTx = this.DdF.getText();
        ((RealNameBundle)localObject1).CTl = this.DdG.getText();
        ((RealNameBundle)localObject1).CTk = this.mSelectCreCountIndex;
        getInput().putParcelable("realname_verify_process_bundle", (Parcelable)localObject1);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", new Object[] { Integer.valueOf(this.CIo.CTk), this.CIo.CTl, this.CIo.CTp });
        if ((eHw()) && (!bt.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!bt.isNullOrNil(getInput().getString("key_true_name"))))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
          this.CIo.CTQ = getInput().getString("key_identity");
          this.CIo.CTR = getInput().getInt("key_id_type", -1);
          this.CIo.CTa = this.mTrueName;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.CIo.CTa);
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.CIo.xnF + " elemt.bankcardTag : " + this.CQB.CPj);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.CQB.CPj);
        localObject2 = getInput();
        ((Bundle)localObject2).putString("key_mobile", str);
        ((Bundle)localObject2).putParcelable("key_authen", this.CIo);
        ((Bundle)localObject2).putString("key_bank_phone", this.CQB.CWr);
        ((Bundle)localObject2).putString("key_country_code", this.countryCode);
        ((Bundle)localObject2).putString("key_province_code", this.provinceCode);
        ((Bundle)localObject2).putString("key_city_code", this.cityCode);
        ((Bundle)localObject2).putParcelable("key_profession", this.CQC);
        ((Bundle)localObject2).putString("key_country_iso", this.Dei);
        ((Bundle)localObject2).putString("key_bind_card_type", this.CIo.dkR);
        ((Bundle)localObject2).putString("key_bind_card_show1", this.CQB.uJF);
        if (2 != this.CQB.CWo) {
          break label1528;
        }
      }
      label1487:
      label1511:
      label1528:
      for (localObject1 = getString(2131765221);; localObject1 = getString(2131765241))
      {
        ((Bundle)localObject2).putString("key_bind_card_show2", (String)localObject1);
        localObject1 = ((Bundle)localObject2).getString("key_bind_card_user_token", null);
        if (!bt.isNullOrNil((String)localObject1))
        {
          this.CIo.CUf = 1;
          this.CIo.CPp = ((String)localObject1);
        }
        this.CIo.CUg = ((Bundle)localObject2).getString("kreq_token");
        if (!getNetController().s(new Object[] { this.CIo, this.ygb })) {
          break label1539;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
        AppMethodBeat.o(70808);
        return;
        bool = false;
        break;
        ((FavorPayInfo)localObject1).CWL = this.CJy.cj(((FavorPayInfo)localObject1).CWL, false);
        break label168;
        bool = false;
        break label524;
        this.CIo.CTl = this.DdG.getText();
        break label736;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70808);
      return;
    }
  }
  
  private void eHv()
  {
    AppMethodBeat.i(70818);
    Object localObject;
    if ((this.CQB != null) && (this.DdT != null) && (this.DdT.containsKey(this.CQB.dkR)))
    {
      localObject = (d.a)this.DdT.get(this.CQB.dkR);
      if ((localObject == null) || (((d.a)localObject).Dcb == null)) {
        break label133;
      }
    }
    label133:
    for (double d = ((d.a)localObject).Dcc;; d = 0.0D)
    {
      localObject = getString(2131765090, new Object[] { com.tencent.mm.wallet_core.ui.e.D(d) });
      this.Dds.setText((CharSequence)localObject);
      this.Dds.setVisibility(0);
      AppMethodBeat.o(70818);
      return;
      this.Dds.setVisibility(8);
      AppMethodBeat.o(70818);
      return;
    }
  }
  
  private boolean eHw()
  {
    AppMethodBeat.i(70819);
    boolean bool = getInput().getBoolean("key_is_forgot_process", false);
    AppMethodBeat.o(70819);
    return bool;
  }
  
  private boolean eHx()
  {
    AppMethodBeat.i(174523);
    com.tencent.mm.wallet_core.d locald = getProcess();
    if ((locald != null) && ("realname_verify_process".equals(locald.cQc())))
    {
      if (locald.dxT.getInt("real_name_verify_mode", 0) == 4)
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
  
  private void hq(boolean paramBoolean)
  {
    AppMethodBeat.i(70803);
    if (this.CQB == null) {
      this.CQB = new ElementQuery();
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "element: %s, %s", new Object[] { this.CQB.uJF, this.CQB.dkR });
    eHt();
    eHv();
    com.tencent.mm.wallet_core.a.br(this);
    Object localObject1 = (Bankcard)getInput().getParcelable("key_bankcard");
    Object localObject2;
    Object localObject3;
    if ((eHw()) && (localObject1 != null))
    {
      this.DdS.setHint(getString(2131765130, new Object[] { ((Bankcard)localObject1).field_bankcardTail }));
      localObject1 = this.DdS;
      localObject2 = this.Ddl;
      localObject3 = this.Ddm;
      a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
      localObject1 = this.Ddu;
      localObject2 = this.Ddn;
      localObject3 = this.Ddo;
      a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
    }
    for (;;)
    {
      if (paramBoolean) {
        eHs();
      }
      this.Dea = false;
      this.Deb = false;
      this.Ded = false;
      this.Dee = false;
      if (!eHx()) {
        break;
      }
      localObject1 = this.CRE.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (crb)((Iterator)localObject1).next();
        if (((crb)localObject2).Hjv.key == this.CMB)
        {
          this.Dea = ((crb)localObject2).Hjz;
          this.Deb = ((crb)localObject2).Hjy;
          this.Dec = ((crb)localObject2).HjC;
          this.Ded = ((crb)localObject2).HjA;
          this.Dex = ((crb)localObject2).HjE;
          this.DdZ = ((crb)localObject2).Hjw;
          this.DdY = ((crb)localObject2).Hjx;
          this.Def = ((crb)localObject2).HjB;
          this.Dee = true;
        }
      }
      if (!bt.isNullOrNil(this.CQB.uJF))
      {
        this.Ddu.setText(this.CQB.uJF);
        if (!this.CQB.eET()) {
          break label561;
        }
        this.Dej.setVisibility(0);
        this.Dej.setText(getString(2131765221));
      }
      for (;;)
      {
        localObject1 = this.DdS;
        localObject2 = this.Ddl;
        localObject3 = this.Ddm;
        a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        localObject1 = this.Ddu;
        localObject2 = this.Ddn;
        localObject3 = this.Ddo;
        a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        this.DdS.setOnInfoIvClickListener(this.DeB);
        if (!t.eFy().eGi().eFP()) {
          break label596;
        }
        this.DdS.getInfoIv().setImageResource(2131691405);
        this.DdS.getInfoIv().setVisibility(0);
        break;
        label561:
        if (this.CQB.eFh())
        {
          this.Dej.setVisibility(0);
          this.Dej.setText(getString(2131765241));
        }
      }
      label596:
      this.DdS.getInfoIv().setVisibility(4);
    }
    Object localObject4;
    WalletFormView localWalletFormView1;
    WalletFormView localWalletFormView2;
    TextView localTextView1;
    TextView localTextView2;
    boolean bool1;
    boolean bool2;
    if ((this.CQB.CWJ != null) && (!this.CQB.CWJ.isEmpty()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "identity type： %s", new Object[] { Integer.valueOf(this.CMB) });
      localObject1 = this.CQB.CWJ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CreTypeRuleInfo)((Iterator)localObject1).next();
        if (((CreTypeRuleInfo)localObject2).CVM == this.CMB)
        {
          if (((CreTypeRuleInfo)localObject2).CVN.CVI == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "need show cre count");
            this.Dea = true;
          }
          if (((CreTypeRuleInfo)localObject2).CVN.CVK == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "need show cre expire");
            this.Deb = true;
          }
          if (((CreTypeRuleInfo)localObject2).CVN.CVJ == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "need show birthday");
            this.Ded = true;
          }
          if (((CreTypeRuleInfo)localObject2).CVN.CVL == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "need show cre type");
            if (t.eFy().eGk() > 0)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
              this.Dee = true;
            }
          }
        }
      }
      if ((this.CMB == 2) && (this.Deg))
      {
        this.Def = true;
        if (!this.Deb)
        {
          this.Dem = 0;
          this.Den = 0;
          this.Deo = 0;
        }
        if (!this.Ded)
        {
          this.Des = 0;
          this.Det = 0;
          this.Deu = 0;
        }
        if (!this.Dea) {
          this.mSelectCreCountIndex = 0;
        }
        this.Ddx.setVisibility(8);
        if (!Bankcard.Vx(this.CQB.CPj)) {
          break label1497;
        }
        localObject1 = this.DcA;
        localObject2 = this.Ddy;
        localObject3 = this.CMx;
        localObject4 = this.DdE;
        localWalletFormView1 = this.DdF;
        localWalletFormView2 = this.DdG;
        localTextView1 = this.CMy;
        localTextView2 = this.CMz;
        a(new boolean[] { 0, 0, 0, 0, 0, 0 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.Ddz.setVisibility(8);
        up(true);
        paramBoolean = this.Ded;
        bool1 = this.Def;
        bool2 = this.Dex;
        localObject1 = this.DdB;
        localObject2 = this.DdC;
        localObject3 = this.DdA;
        localObject4 = this.DdH;
        localWalletFormView1 = this.DdI;
        localWalletFormView2 = this.DdD;
        localTextView1 = this.Ddt;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        paramBoolean = this.CQB.CWi;
        bool1 = this.CQB.CWj;
        localObject1 = this.Ddw;
        localObject2 = this.Ddv;
        localObject3 = this.Ddp;
        localObject4 = this.Ddq;
        a(new boolean[] { paramBoolean, bool1 }, new WalletFormView[] { localObject1, localObject2 }, (TextView)localObject3, (TextView)localObject4);
        if (this.Ddu.getVisibility() != 0) {
          break label2960;
        }
        switch (this.CQB.CWn)
        {
        default: 
          this.Ddo.setVisibility(8);
          label1325:
          this.Ddo.setTextColor(getResources().getColor(2131100707));
        }
      }
    }
    for (;;)
    {
      if ((!bt.isNullOrNil(this.CQB.CWH)) && (this.Ddo.getVisibility() != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
        this.Ddo.setText(this.CQB.CWH);
        this.Ddo.setVisibility(0);
      }
      if ((bt.isNullOrNil(this.CQB.CWs)) || (!w.zD(this.CQB.CWs)) || (eHw())) {
        break label2972;
      }
      this.DdW.setText(this.CQB.CWt);
      this.DdW.setVisibility(0);
      AppMethodBeat.o(70803);
      return;
      this.Def = false;
      break;
      if ((this.CMB == 2) && (this.Deg))
      {
        this.Def = true;
        break;
      }
      this.Def = false;
      break;
      label1497:
      int i;
      if ((this.CQB.eFi() != null) && (this.CQB.eFi().size() > 0))
      {
        i = 1;
        label1524:
        if ((!eHw()) && (!t.eFy().eGc())) {
          break label2440;
        }
        localObject2 = t.eFy().getTrueName();
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          if (getProcess() != null) {
            localObject1 = getProcess().dxT.getString("key_true_name");
          }
        }
        if (bt.isNullOrNil((String)localObject1)) {
          break label2252;
        }
        localObject1 = getString(2131765180, new Object[] { com.tencent.mm.wallet_core.ui.e.aYH((String)localObject1) });
        this.DcA.setHint((CharSequence)localObject1);
        this.Ddx.setHint((CharSequence)localObject1);
        label1633:
        if ((!eHw()) || (bt.isNullOrNil(getInput().getString("key_identity"))) || (getInput().getInt("key_id_type", -1) == -1) || (bt.isNullOrNil(getInput().getString("key_true_name")))) {
          break label2282;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
        paramBoolean = this.Dea;
        bool1 = this.Dec;
        bool2 = this.Deb;
        localObject1 = this.DcA;
        localObject2 = this.Ddy;
        localObject3 = this.CMx;
        localObject4 = this.DdE;
        localWalletFormView1 = this.DdF;
        localWalletFormView2 = this.DdG;
        localTextView1 = this.CMy;
        localTextView2 = this.CMz;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.mTrueName = getInput().getString("key_true_name");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "name is " + this.mTrueName);
        this.Ddz.setVisibility(0);
        if (this.DcC != null)
        {
          if (!bt.isNullOrNil(this.DcC.field_mobile)) {
            d(this.Ddz, this.DcC.field_mobile);
          }
          if (!bt.isNullOrNil(this.DcC.CTT)) {
            d(this.Ddw, this.DcC.CTT);
          }
          if (!bt.isNullOrNil(this.DcC.CUA)) {
            d(this.Ddv, this.DcC.CUA);
          }
        }
        if (!this.CQB.CWg) {
          break label2681;
        }
        this.CMz.setText("");
      }
      for (;;)
      {
        if (!bt.isNullOrNil(this.CQB.CWk)) {
          this.CMx.setText(this.CQB.CWk);
        }
        if (t.eFy().eGk() <= 0) {
          break label2698;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", new Object[] { Integer.valueOf(t.eFy().eGk()) });
        this.Ddy.setClickable(false);
        this.Ddy.setText(t.eFG().gL(this));
        this.Ddy.setInputEnable(false);
        a(this.CMx, this.CMB);
        up(false);
        paramBoolean = this.Dex;
        bool1 = this.DdY;
        bool2 = this.DdY;
        boolean bool3 = this.DdZ;
        boolean bool4 = this.Ded;
        boolean bool5 = this.Def;
        localObject1 = this.DdD;
        localObject2 = this.DdB;
        localObject3 = this.DdC;
        localObject4 = this.DdA;
        localWalletFormView1 = this.DdH;
        localWalletFormView2 = this.DdI;
        localTextView1 = this.Ddt;
        a(new boolean[] { paramBoolean, bool1, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        break;
        i = 0;
        break label1524;
        label2252:
        localObject1 = getString(2131765179);
        this.DcA.setHint((CharSequence)localObject1);
        this.Ddx.setHint((CharSequence)localObject1);
        break label1633;
        label2282:
        if ((this.Dee) || (i != 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool1 = this.Dea;
          bool2 = this.Dec;
          bool3 = this.Deb;
          localObject1 = this.DcA;
          localObject2 = this.Ddy;
          localObject3 = this.CMx;
          localObject4 = this.DdE;
          localWalletFormView1 = this.DdF;
          localWalletFormView2 = this.DdG;
          localTextView1 = this.CMy;
          localTextView2 = this.CMz;
          a(new boolean[] { true, paramBoolean, true, bool1, bool2, bool3 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          break;
        }
        label2440:
        bool1 = this.CQB.CWg;
        if ((this.Dee) || ((i != 0) && (this.CQB.CWh))) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool2 = this.CQB.CWh;
          bool3 = this.Dea;
          bool4 = this.Dec;
          bool5 = this.Deb;
          localObject1 = this.DcA;
          localObject2 = this.Ddy;
          localObject3 = this.CMx;
          localObject4 = this.DdE;
          localWalletFormView1 = this.DdF;
          localWalletFormView2 = this.DdG;
          localTextView1 = this.CMy;
          localTextView2 = this.CMz;
          a(new boolean[] { bool1, paramBoolean, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          this.Ddz.setVisibility(0);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.CQB.CWg + " canModifyIdentity:" + this.CQB.CWh);
          break;
        }
        label2681:
        this.CMz.setText(getString(2131765136));
      }
      label2698:
      if (this.CQB.eFi() != null)
      {
        i = this.CQB.eFi().size();
        label2721:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", new Object[] { Integer.valueOf(i) });
        if (i > 1) {
          break label2876;
        }
        this.Ddy.setClickable(false);
        this.Ddy.setInputEnable(false);
        this.CMx.setInputEnable(true);
      }
      for (;;)
      {
        localObject1 = this.CQB.eFi();
        if ((localObject1 == null) || (!((List)localObject1).contains(Integer.valueOf(this.CMB)))) {
          this.CMB = 1;
        }
        if (!t.eFG().am(this, this.CMB).equals(this.Dev)) {
          com.tencent.mm.plugin.report.service.g.yhR.f(16816, new Object[] { Integer.valueOf(this.CMB) });
        }
        this.Ddy.setText(t.eFG().am(this, this.CMB));
        break;
        i = 0;
        break label2721;
        label2876:
        this.Ddy.setClickable(true);
        this.Ddy.setInputEnable(true);
        this.CMx.setInputEnable(true);
      }
      this.Ddo.setText(2131765096);
      this.Ddo.setVisibility(0);
      break label1325;
      this.Ddo.setVisibility(8);
      break label1325;
      this.Ddo.setVisibility(8);
      break label1325;
      this.Ddo.setVisibility(8);
      break label1325;
      label2960:
      this.Ddo.setVisibility(8);
    }
    label2972:
    this.DdW.setVisibility(8);
    AppMethodBeat.o(70803);
  }
  
  private void up(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(70805);
    if (paramBoolean)
    {
      Object localObject = this.AhI;
      if (this.CQB.CWv)
      {
        i = 0;
        ((TextView)localObject).setVisibility(i);
        localObject = this.DdJ;
        if (!this.CQB.CWv) {
          break label225;
        }
        i = 0;
        label54:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.DdK;
        if (!this.CQB.CWw) {
          break label231;
        }
        i = 0;
        label78:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.DdL;
        if (!this.CQB.CWx) {
          break label237;
        }
        i = 0;
        label102:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.DdM;
        if (!this.CQB.CWA) {
          break label243;
        }
        i = 0;
        label126:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.DdN;
        if (!this.CQB.CWC) {
          break label249;
        }
        i = 0;
        label150:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.DdO;
        if (!this.CQB.CWB) {
          break label255;
        }
        i = 0;
        label174:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.DdP;
        if (!this.CQB.CWD) {
          break label261;
        }
      }
      label261:
      for (int i = j;; i = 8)
      {
        ((WalletFormView)localObject).setVisibility(i);
        this.Ddr.setVisibility(4);
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
    this.AhI.setVisibility(8);
    this.DdJ.setVisibility(8);
    this.DdK.setVisibility(8);
    this.DdL.setVisibility(8);
    this.DdM.setVisibility(8);
    this.DdN.setVisibility(8);
    this.DdO.setVisibility(8);
    this.DdP.setVisibility(8);
    this.Ddr.setVisibility(8);
    AppMethodBeat.o(70805);
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
    return 2131495929;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70800);
    this.Ddl = ((TextView)findViewById(2131306710));
    this.DdS = ((WalletFormView)findViewById(2131306708));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.DdS);
    this.Ddm = ((TextView)findViewById(2131306709));
    this.CMy = ((TextView)findViewById(2131306712));
    this.DcA = ((WalletFormView)findViewById(2131302662));
    this.Ddx = ((WalletFormView)findViewById(2131300224));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.DcA);
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Ddx);
    this.Ddy = ((WalletFormView)findViewById(2131306730));
    this.CMx = ((WalletFormView)findViewById(2131300910));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.CMx);
    this.CMz = ((TextView)findViewById(2131306711));
    this.Ddn = ((TextView)findViewById(2131306701));
    this.Ddu = ((WalletFormView)findViewById(2131306713));
    this.Dej = ((WalletFormView)findViewById(2131306717));
    this.Ddo = ((TextView)findViewById(2131306702));
    this.Dds = ((TextView)findViewById(2131306706));
    this.Ddp = ((TextView)findViewById(2131306704));
    this.Ddw = ((WalletFormView)findViewById(2131298914));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.Ddw);
    this.Ddv = ((WalletFormView)findViewById(2131298929));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.Ddv);
    this.Ddq = ((TextView)findViewById(2131306703));
    this.AhI = ((TextView)findViewById(2131306699));
    this.DdJ = ((WalletFormView)findViewById(2131300112));
    this.DdK = ((WalletFormView)findViewById(2131301314));
    this.DdL = ((WalletFormView)findViewById(2131296936));
    this.DdM = ((WalletFormView)findViewById(2131296479));
    this.DdN = ((WalletFormView)findViewById(2131303210));
    this.DdO = ((WalletFormView)findViewById(2131303363));
    this.DdP = ((WalletFormView)findViewById(2131299329));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.DdP);
    this.Ddr = ((TextView)findViewById(2131306698));
    this.DdV = ((CheckBox)findViewById(2131296518));
    this.DdW = ((CheckBox)findViewById(2131296515));
    this.fQh = ((Button)findViewById(2131302852));
    this.fQj = ((ScrollView)findViewById(2131306834));
    this.DdA = ((WalletFormView)findViewById(2131303415));
    this.DdB = ((WalletFormView)findViewById(2131303412));
    this.DdC = ((WalletFormView)findViewById(2131303411));
    this.DdD = ((WalletFormView)findViewById(2131303416));
    this.DdE = ((WalletFormView)findViewById(2131306727));
    this.DdF = ((WalletFormView)findViewById(2131306728));
    this.DdG = ((WalletFormView)findViewById(2131306729));
    this.DdH = ((WalletFormView)findViewById(2131303413));
    this.DdI = ((WalletFormView)findViewById(2131303414));
    this.Ddt = ((TextView)findViewById(2131306715));
    this.DdQ = ((WalletPhoneInputView)findViewById(2131302361));
    this.Ddz = this.DdQ.getPhoneNumberEt();
    this.DcA.setOnInputValidChangeListener(this);
    this.Ddx.setOnInputValidChangeListener(this);
    this.DdS.setOnInputValidChangeListener(this);
    this.Ddy.setOnInputValidChangeListener(this);
    this.CMx.setOnInputValidChangeListener(this);
    this.Ddz.setOnInputValidChangeListener(new WalletFormView.a()
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
    this.Ddw.setOnInputValidChangeListener(this);
    this.Ddv.setOnInputValidChangeListener(this);
    this.DdJ.setOnInputValidChangeListener(this);
    this.DdK.setOnInputValidChangeListener(this);
    this.DdL.setOnInputValidChangeListener(this);
    this.DdM.setOnInputValidChangeListener(this);
    this.DdN.setOnInputValidChangeListener(this);
    this.DdO.setOnInputValidChangeListener(this);
    this.DdP.setOnInputValidChangeListener(this);
    this.DdA.setOnInputValidChangeListener(this);
    this.DdB.setOnInputValidChangeListener(this);
    this.DcA.setOnEditorActionListener(this);
    this.Ddx.setOnEditorActionListener(this);
    this.DdS.setOnEditorActionListener(this);
    this.Ddy.setOnEditorActionListener(this);
    this.CMx.setOnEditorActionListener(this);
    this.Ddz.setOnEditorActionListener(this);
    this.Ddw.setOnEditorActionListener(this);
    this.Ddv.setOnEditorActionListener(this);
    this.DdJ.setOnEditorActionListener(this);
    this.DdK.setOnEditorActionListener(this);
    this.DdL.setOnEditorActionListener(this);
    this.DdM.setOnEditorActionListener(this);
    this.DdN.setOnEditorActionListener(this);
    this.DdO.setOnEditorActionListener(this);
    this.DdP.setOnEditorActionListener(this);
    this.DdB.setOnEditorActionListener(this);
    this.DdA.setOnEditorActionListener(this);
    this.Ddu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70786);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardElementUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putInt("key_bind_scene", WalletCardElementUI.this.getInput().getInt("key_bind_scene", -1));
        bt.isNullOrNil(WalletCardElementUI.c(WalletCardElementUI.this).getText());
        WalletCardElementUI.this.hideTenpayKB();
        localObject = com.tencent.mm.wallet_core.a.br(WalletCardElementUI.this);
        if (localObject != null) {
          ((com.tencent.mm.wallet_core.d)localObject).a(WalletCardElementUI.this, WalletBankCardSelectUI.class, paramAnonymousView, 1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70786);
      }
    });
    this.Dej.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70788);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(WalletCardElementUI.this.getString(2131765241));
        paramAnonymousView.add(WalletCardElementUI.this.getString(2131765221));
        if (WalletCardElementUI.d(WalletCardElementUI.this).size() == 1)
        {
          localObject = (ElementQuery)WalletCardElementUI.d(WalletCardElementUI.this).get(0);
          if (!((ElementQuery)localObject).eFh()) {
            break label178;
          }
          paramAnonymousView.remove(1);
        }
        for (;;)
        {
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.afD(WalletCardElementUI.e(WalletCardElementUI.this));
          paramAnonymousView.LaQ = new c.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(70787);
              paramAnonymousView.hide();
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2Object1 = (String)paramAnonymous2Object1;
                WalletCardElementUI.f(WalletCardElementUI.this).setText(paramAnonymous2Object1);
                if (!paramAnonymous2Object1.equals(WalletCardElementUI.this.getString(2131765221))) {
                  break label162;
                }
              }
              label162:
              for (int i = 0;; i = 1)
              {
                paramAnonymous2Object1 = WalletCardElementUI.d(WalletCardElementUI.this).iterator();
                while (paramAnonymous2Object1.hasNext())
                {
                  paramAnonymous2Object2 = (ElementQuery)paramAnonymous2Object1.next();
                  if (((i != 0) && (paramAnonymous2Object2.eFh())) || ((i == 0) && (paramAnonymous2Object2.eET())))
                  {
                    WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymous2Object2);
                    WalletCardElementUI.g(WalletCardElementUI.this);
                  }
                }
                WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymousView.fMM());
                AppMethodBeat.o(70787);
                return;
              }
            }
          };
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70788);
          return;
          label178:
          if (((ElementQuery)localObject).eET()) {
            paramAnonymousView.remove(0);
          }
        }
      }
    });
    this.Ddy.setOnClickListener(new WalletCardElementUI.15(this));
    this.DdE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), WalletCardElementUI.i(WalletCardElementUI.this));
        paramAnonymousView.LaQ = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(70790);
            if (paramAnonymous2Boolean)
            {
              WalletCardElementUI.j(WalletCardElementUI.this).setText((String)paramAnonymous2Object1);
              WalletCardElementUI.b(WalletCardElementUI.this, paramAnonymousView.fMM());
              WalletCardElementUI.b(WalletCardElementUI.this);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(70790);
          }
        };
        paramAnonymousView.afD(WalletCardElementUI.k(WalletCardElementUI.this));
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70791);
      }
    });
    this.DdF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70793);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
        paramAnonymousView.LaK = new b.a()
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
        paramAnonymousView.aR(i, j, k);
        localObject = WalletCardElementUI.l(WalletCardElementUI.this).getContentEt().getText().toString();
        if ((WalletCardElementUI.m(WalletCardElementUI.this) > 0) && (WalletCardElementUI.n(WalletCardElementUI.this) > 0) && (WalletCardElementUI.o(WalletCardElementUI.this) > 0)) {
          paramAnonymousView.aP(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
        }
        for (;;)
        {
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70793);
          return;
          if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).length() == 8))
          {
            WalletCardElementUI.c(WalletCardElementUI.this, bt.getInt(((String)localObject).substring(0, 4), i));
            WalletCardElementUI.d(WalletCardElementUI.this, bt.getInt(((String)localObject).substring(4, 6), j));
            WalletCardElementUI.e(WalletCardElementUI.this, bt.getInt(((String)localObject).substring(6, 8), k));
            paramAnonymousView.aP(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
          }
        }
      }
    });
    this.DdG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70794);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
        paramAnonymousView.LaK = new b.a()
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
                break label122;
              }
              WalletCardElementUI.p(WalletCardElementUI.this).setText(WalletCardElementUI.this.getString(2131766450));
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
              label122:
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
        paramAnonymousView.aQ(i, j, k);
        paramAnonymousView.aR(i + 200, 12, 31);
        paramAnonymousView.setLongTermYear(true);
        localObject = WalletCardElementUI.p(WalletCardElementUI.this).getContentEt().getText().toString();
        if ((WalletCardElementUI.q(WalletCardElementUI.this) <= 0) || (WalletCardElementUI.r(WalletCardElementUI.this) <= 0) || (WalletCardElementUI.s(WalletCardElementUI.this) <= 0))
        {
          if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).length() == 8))
          {
            WalletCardElementUI.f(WalletCardElementUI.this, bt.getInt(((String)localObject).substring(0, 4), i));
            WalletCardElementUI.g(WalletCardElementUI.this, bt.getInt(((String)localObject).substring(4, 6), j));
            WalletCardElementUI.h(WalletCardElementUI.this, bt.getInt(((String)localObject).substring(6, 8), k));
          }
        }
        else
        {
          if (WalletCardElementUI.q(WalletCardElementUI.this) != 9999) {
            break label340;
          }
          paramAnonymousView.aP(1, 1, 1);
        }
        for (;;)
        {
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70794);
          return;
          if (!((String)localObject).equals(WalletCardElementUI.this.getString(2131766450))) {
            break;
          }
          WalletCardElementUI.f(WalletCardElementUI.this, 9999);
          WalletCardElementUI.g(WalletCardElementUI.this, 12);
          WalletCardElementUI.h(WalletCardElementUI.this, 31);
          break;
          label340:
          paramAnonymousView.aP(WalletCardElementUI.q(WalletCardElementUI.this), WalletCardElementUI.r(WalletCardElementUI.this), WalletCardElementUI.s(WalletCardElementUI.this));
        }
      }
    });
    this.DdD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70795);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = WalletCardElementUI.this.getResources().getStringArray(2130903102);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), paramAnonymousView);
        paramAnonymousView.LaQ = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(174522);
            if (paramAnonymous2Boolean)
            {
              WalletCardElementUI.t(WalletCardElementUI.this).setText((String)paramAnonymous2Object1);
              if (!((String)paramAnonymous2Object1).equalsIgnoreCase(WalletCardElementUI.this.getString(2131763533))) {
                break label90;
              }
              WalletCardElementUI.i(WalletCardElementUI.this, 0);
            }
            for (;;)
            {
              paramAnonymousView.afD(WalletCardElementUI.u(WalletCardElementUI.this));
              paramAnonymousView.hide();
              AppMethodBeat.o(174522);
              return;
              label90:
              WalletCardElementUI.i(WalletCardElementUI.this, 1);
            }
          }
        };
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70795);
      }
    });
    this.DdB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70797);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("GetAddress", true);
        paramAnonymousView.putExtra("ShowSelectedLocation", false);
        if (!Bankcard.Vx(WalletCardElementUI.v(WalletCardElementUI.this).CPj))
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
        com.tencent.mm.bs.d.c(WalletCardElementUI.this.getContext(), ".ui.tools.MultiStageCitySelectUI", paramAnonymousView, 4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70797);
      }
    });
    this.DdA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70774);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Intent(WalletCardElementUI.this.getContext(), WalletSelectProfessionUI.class);
        paramAnonymousView.putExtra("key_profession_list", WalletCardElementUI.x(WalletCardElementUI.this));
        WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 5);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70774);
      }
    });
    this.DdH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(174512);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
        paramAnonymousView.LaK = new b.a()
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
          paramAnonymousView.aP(WalletCardElementUI.z(WalletCardElementUI.this), WalletCardElementUI.A(WalletCardElementUI.this), WalletCardElementUI.B(WalletCardElementUI.this));
        }
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174512);
      }
    });
    this.DdI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70776);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WalletCardElementUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        paramAnonymousView.putExtra("exclude_countries_iso", WalletCardElementUI.w(WalletCardElementUI.this));
        paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
        paramAnonymousView.putExtra("ui_title", WalletCardElementUI.this.getString(2131765859));
        WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 6);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70776);
      }
    });
    this.DdV.setChecked(true);
    this.DdV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(174513);
        WalletCardElementUI.b(WalletCardElementUI.this);
        AppMethodBeat.o(174513);
      }
    });
    findViewById(2131296513).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70778);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.wallet_core.ui.e.b(WalletCardElementUI.this, WalletCardElementUI.v(WalletCardElementUI.this).dkR, WalletCardElementUI.v(WalletCardElementUI.this).uJF, false, WalletCardElementUI.v(WalletCardElementUI.this).CWG);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70778);
      }
    });
    this.DdL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174514);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
        if (Bankcard.Vx(WalletCardElementUI.v(WalletCardElementUI.this).CPj)) {
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
    this.DdC.setOnInputValidChangeListener(this);
    this.fQh.setOnClickListener(new WalletCardElementUI.8(this));
    setEditFocusListener(this.DdS, 0, false, false, true);
    setEditFocusListener(this.CMx, 1, false, false, true);
    setEditFocusListener(this.Ddz, 0, false, false, true);
    if ((this.CQB != null) && (!bt.isNullOrNil(this.CQB.CWu)))
    {
      h.a(this, this.CQB.CWu, null, true, null);
      this.CQB = null;
    }
    for (;;)
    {
      hq(true);
      aUW();
      Object localObject = com.tencent.mm.wallet_core.a.br(this);
      if ((localObject == null) || (!((com.tencent.mm.wallet_core.d)localObject).fQR())) {
        break label1478;
      }
      localObject = (Orders)getInput().getParcelable("key_orders");
      if ((localObject == null) || (((Orders)localObject).CXU != 1)) {
        break;
      }
      this.DdU = true;
      this.DcA.setText(com.tencent.mm.wallet_core.ui.e.aYH(((Orders)localObject).CTa));
      this.DcA.setEnabled(false);
      this.DcA.setFocusable(false);
      this.CMB = ((Orders)localObject).CXV;
      this.Ddy.setText(t.eFG().am(this, this.CMB));
      this.Ddy.setEnabled(false);
      this.CMx.setText(((Orders)localObject).CWk);
      this.CMx.setInputEnable(false);
      this.CMx.setFocusable(false);
      this.CMy.setText(2131765089);
      AppMethodBeat.o(70800);
      return;
      if ((getInput().getInt("key_bind_scene", -1) == 5) && (!this.CQB.CWK))
      {
        h.a(this, getString(2131765971), null, true, null);
        this.CQB.uJF = null;
      }
    }
    this.DdU = false;
    label1478:
    AppMethodBeat.o(70800);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70810);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (this.DdQ.f(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(70810);
      return;
    }
    if ((paramInt1 == 6) && (paramInt2 == 100))
    {
      if (!bt.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        this.Dei = paramIntent.getStringExtra("iso_code");
        this.DdI.setText(paramIntent.getStringExtra("country_name"));
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
      aUW();
      AppMethodBeat.o(70810);
      return;
      this.CQB = null;
      this.Del = 0;
      this.mSelectBankName = paramIntent.getStringExtra("bank_name");
      this.Ddu.setText(this.mSelectBankName);
      this.Dej.setVisibility(0);
      this.Dej.setText("");
      aET(this.mSelectBankName);
      if (this.Dek.size() == 1) {
        this.CQB = ((ElementQuery)this.Dek.get(0));
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "select bank: %s, %s", new Object[] { this.mSelectBankName, Integer.valueOf(this.Dek.size()) });
      this.DcC = null;
      hq(false);
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.DdX = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!bt.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.vgX = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.vgY = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        if (bt.isNullOrNil(str1))
        {
          this.DdL.setText(str3 + " " + str4);
          label486:
          if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.CQB.CWB)) {
            break label709;
          }
          this.DdO.setVisibility(0);
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", new Object[] { str1, str2, str3, str4, this.vgY });
        break;
        this.DdL.setText(str1 + " " + str4);
        break label486;
        if (!bt.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.vgY = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.DdL.setText(str1 + " " + str3);
          break label486;
        }
        this.vgY = this.DdX;
        this.DdL.setText(str1);
        break label486;
        label709:
        this.DdO.setVisibility(8);
      }
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.DdS.set3DesValStr(paramIntent);
      continue;
      str1 = paramIntent.getStringExtra("CountryName");
      str2 = paramIntent.getStringExtra("ProviceName");
      str3 = paramIntent.getStringExtra("CityName");
      this.countryCode = paramIntent.getStringExtra("Country");
      this.provinceCode = paramIntent.getStringExtra("Contact_Province");
      this.cityCode = paramIntent.getStringExtra("Contact_City");
      paramIntent = new StringBuilder();
      if (!bt.isNullOrNil(str1)) {
        paramIntent.append(str1);
      }
      if (!bt.isNullOrNil(str2)) {
        paramIntent.append(" ").append(str2);
      }
      if (!bt.isNullOrNil(str3)) {
        paramIntent.append(" ").append(str3);
      }
      this.DdB.setText(paramIntent.toString());
      continue;
      this.CQC = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
      this.DdA.setText(this.CQC.CSY);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70799);
    super.onCreate(paramBundle);
    this.CQB = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.ygb = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.CMB = t.eFy().eGk();
    this.DcC = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
    this.DdY = getInput().getBoolean("key_need_area", false);
    this.DdZ = getInput().getBoolean("key_need_profession", false);
    this.Deg = getInput().getBoolean("key_need_country", false);
    this.Deh = getInput().getStringArray("key_country_excludes");
    if (this.CQB != null) {
      aET(this.CQB.uJF);
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "neeCountry: %s", new Object[] { Boolean.valueOf(this.Deg) });
    if ((this.DdY) || (this.DdZ)) {
      setMMTitle(2131765248);
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
      setMMTitle(2131765247);
    }
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    this.CRF = new String[100];
    int i = 0;
    while (i < this.CRF.length)
    {
      this.CRF[i] = getString(2131765220, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    paramBundle = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
    if ((this.ygb != null) && (paramBundle != null))
    {
      this.CJy = e.Dcd.a(this.ygb);
      if (this.CJy == null) {
        break label477;
      }
      paramBundle = this.CJy.aEQ(paramBundle.CWL);
      this.DdT = this.CJy.aEL(paramBundle);
    }
    for (;;)
    {
      initView();
      this.fQj.pageScroll(33);
      f.a(this, getInput(), 3);
      com.tencent.mm.sdk.b.a.IbL.c(this.CMf);
      AppMethodBeat.o(70799);
      return;
      label477:
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70815);
    com.tencent.mm.sdk.b.a.IbL.d(this.CMf);
    super.onDestroy();
    AppMethodBeat.o(70815);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(70814);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      if (this.DdR == null) {
        eHu();
      }
      AppMethodBeat.o(70814);
      return false;
    }
    boolean bool1;
    if (this.DdR != null)
    {
      paramTextView = this.DdR;
      if (paramTextView.LAy != null)
      {
        bool1 = paramTextView.LAy.isFocusable();
        if (!bool1) {
          break label157;
        }
        paramTextView = this.DdR;
        bool1 = bool2;
        if (paramTextView.LAy != null) {
          bool1 = paramTextView.LAy.isClickable();
        }
        if ((!bool1) || (!this.DdR.fSf())) {
          break label157;
        }
        this.DdR.fSi();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70814);
      return true;
      bool1 = false;
      break;
      label157:
      this.DdR.performClick();
      continue;
      eHu();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70813);
    aUW();
    AppMethodBeat.o(70813);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70809);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI
 * JD-Core Version:    0.7.0.1
 */