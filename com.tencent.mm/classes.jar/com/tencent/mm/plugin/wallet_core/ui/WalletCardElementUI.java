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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.c.ad;
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
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aac;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.wallet_core.d.g;
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
  private TextView BCT;
  private TextView BCU;
  private TextView BCV;
  private TextView BCW;
  private TextView BCX;
  private TextView BCY;
  private TextView BCZ;
  private WalletFormView BCi;
  private Bankcard BCk;
  private WalletFormView BDA;
  private Map<String, d.a> BDB;
  private boolean BDC;
  private CheckBox BDD;
  private CheckBox BDE;
  private String BDF;
  private boolean BDG;
  private boolean BDH;
  private boolean BDI;
  private boolean BDJ;
  private boolean BDK;
  private boolean BDL;
  private boolean BDM;
  private boolean BDN;
  private boolean BDO;
  private String[] BDP;
  private String BDQ;
  private WalletFormView BDR;
  private List<ElementQuery> BDS;
  private int BDT;
  private int BDU;
  private int BDV;
  private int BDW;
  private int BDX;
  private int BDY;
  private int BDZ;
  private TextView BDa;
  private TextView BDb;
  private WalletFormView BDc;
  private WalletFormView BDd;
  private WalletFormView BDe;
  private WalletFormView BDf;
  private WalletFormView BDg;
  private WalletFormView BDh;
  private WalletFormView BDi;
  private WalletFormView BDj;
  private WalletFormView BDk;
  private WalletFormView BDl;
  private WalletFormView BDm;
  private WalletFormView BDn;
  private WalletFormView BDo;
  private WalletFormView BDp;
  private WalletFormView BDq;
  private WalletFormView BDr;
  private WalletFormView BDs;
  private WalletFormView BDt;
  private WalletFormView BDu;
  private WalletFormView BDv;
  private WalletFormView BDw;
  private WalletFormView BDx;
  private WalletPhoneInputView BDy;
  private WalletFormView BDz;
  private int BEa;
  private int BEb;
  private int BEc;
  private String BEd;
  private String BEe;
  private boolean BEf;
  private int BEg;
  private int BEh;
  private int BEi;
  private View.OnClickListener BEj;
  private Authen Bia;
  d Bjk;
  private com.tencent.mm.sdk.b.c BlQ;
  private WalletFormView Bmi;
  private TextView Bmj;
  private TextView Bmk;
  private int Bmm;
  private ElementQuery Bqm;
  private Profession Bqn;
  private List<cmb> Brp;
  private String[] Brq;
  private String cityCode;
  private String countryCode;
  private int exL;
  private Button fwU;
  private ScrollView fwW;
  private PayInfo mPayInfo;
  private Profession[] mProfessions;
  private String mSelectBankName;
  private int mSelectCreCountIndex;
  private String mTrueName;
  private String provinceCode;
  private String ueo;
  private String uep;
  private Orders wSu;
  private TextView yQm;
  
  public WalletCardElementUI()
  {
    AppMethodBeat.i(70798);
    this.BDz = null;
    this.Bqm = new ElementQuery();
    this.Bia = new Authen();
    this.wSu = null;
    this.mPayInfo = null;
    this.BCk = null;
    this.BDB = null;
    this.Bjk = null;
    this.BDC = false;
    this.Bmm = 1;
    this.BDI = false;
    this.BDJ = false;
    this.BDK = false;
    this.BDL = false;
    this.BDM = false;
    this.BDN = false;
    this.BDO = false;
    this.BDP = null;
    this.BDS = new ArrayList();
    this.Brp = new ArrayList();
    this.BEj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174518);
        com.tencent.mm.plugin.report.service.h.wUl.f(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
        com.tencent.mm.wallet_core.ui.e.d(WalletCardElementUI.this, s.ery().getTrueName());
        AppMethodBeat.o(174518);
      }
    };
    this.BlQ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(70798);
  }
  
  private void TM(int paramInt)
  {
    AppMethodBeat.i(70817);
    if (paramInt == 1)
    {
      setEditFocusListener(this.Bmi, 1, false, false, false);
      AppMethodBeat.o(70817);
      return;
    }
    setEditFocusListener(this.Bmi, 1, true, false, false);
    AppMethodBeat.o(70817);
  }
  
  private void a(WalletFormView paramWalletFormView, int paramInt)
  {
    AppMethodBeat.i(70816);
    paramWalletFormView = paramWalletFormView.getLogicDelegate();
    if ((paramWalletFormView instanceof a.a))
    {
      ((a.a)paramWalletFormView).adS(paramInt);
      TM(paramInt);
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
        paramArrayOfWalletFormView[i].dtH();
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
  
  private boolean aRK()
  {
    AppMethodBeat.i(70812);
    WalletFormView localWalletFormView = this.BDz;
    this.BDz = null;
    if (!this.BDc.gX(null))
    {
      if ((this.BDz == null) && (localWalletFormView != this.BDc)) {
        this.BDz = this.BDc;
      }
      this.BCW.setText(2131765091);
      this.BCW.setTextColor(getResources().getColor(2131100798));
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (!this.BCi.gX(null))
      {
        if ((this.BDz == null) && (localWalletFormView != this.BCi)) {
          this.BDz = this.BCi;
        }
        bool1 = false;
      }
      if (!this.BDA.gX(this.BCU))
      {
        if ((this.BDz == null) && (localWalletFormView != this.BDA)) {
          this.BDz = this.BDA;
        }
        bool1 = false;
      }
      int i;
      if ((!this.Bmi.gX(this.Bmk)) && (!this.BDC))
      {
        if ((this.BDz == null) && (localWalletFormView != this.Bmi)) {
          this.BDz = this.Bmi;
        }
        this.Bmk.setText(2131765132);
        this.Bmk.setTextColor(getResources().getColor(2131100798));
        i = 1;
      }
      for (boolean bool2 = false;; bool2 = bool1)
      {
        bool1 = bool2;
        if (this.BDI)
        {
          bool1 = bool2;
          if (!this.BDm.gX(null))
          {
            if ((this.BDz == null) && (localWalletFormView != this.BDm)) {
              this.BDz = this.BDm;
            }
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (this.BDJ)
        {
          bool2 = bool1;
          if (!this.BDo.gX(null))
          {
            if ((this.BDz == null) && (localWalletFormView != this.BDo)) {
              this.BDz = this.BDo;
            }
            bool2 = false;
          }
        }
        if (!this.BDh.gX(this.Bmk)) {
          if (i != 0)
          {
            this.Bmk.setText(2131765125);
            this.Bmk.setTextColor(getResources().getColor(2131100798));
            if ((this.BDz == null) && (localWalletFormView != this.BDh)) {
              this.BDz = this.BDh;
            }
            bool1 = false;
            label401:
            if (this.Bmk.getVisibility() == 4)
            {
              if (!this.Bqm.BvQ) {
                break label1165;
              }
              this.Bmk.setText(getString(2131765133));
              label436:
              this.Bmk.setTextColor(getResources().getColor(2131100490));
              this.Bmk.setVisibility(0);
            }
            if (this.BDe.gX(this.BCY)) {
              break label1220;
            }
            if ((this.BDz == null) && (localWalletFormView != this.BDe)) {
              this.BDz = this.BDe;
            }
            i = 1;
            bool1 = false;
          }
        }
        for (;;)
        {
          if (!this.BDd.gX(this.BCY))
          {
            if ((this.BDz == null) && (localWalletFormView != this.BDd)) {
              this.BDz = this.BDd;
            }
            bool2 = false;
            label543:
            if (!this.BDD.isChecked()) {
              bool2 = false;
            }
            if (!this.BDr.gX(this.BCZ))
            {
              if ((this.BDz == null) && (localWalletFormView != this.BDr)) {
                this.BDz = this.BDr;
              }
              bool2 = false;
            }
            if (!this.BDs.gX(this.BCZ))
            {
              if ((this.BDz == null) && (localWalletFormView != this.BDs)) {
                this.BDz = this.BDs;
              }
              bool2 = false;
            }
            if (!this.BDt.gX(this.BCZ))
            {
              if ((this.BDz == null) && (localWalletFormView != this.BDt)) {
                this.BDz = this.BDt;
              }
              bool2 = false;
            }
            if (!this.BDu.gX(this.BCZ))
            {
              if ((this.BDz == null) && (localWalletFormView != this.BDu)) {
                this.BDz = this.BDu;
              }
              bool2 = false;
            }
            if (!this.BDv.gX(this.BCZ))
            {
              if ((this.BDz == null) && (localWalletFormView != this.BDv)) {
                this.BDz = this.BDv;
              }
              bool2 = false;
            }
            if (!this.BDw.gX(this.BCZ))
            {
              if ((this.BDz == null) && (localWalletFormView != this.BDw)) {
                this.BDz = this.BDw;
              }
              bool2 = false;
            }
            if (!this.BDx.gX(this.BCZ))
            {
              if ((this.BDz == null) && (localWalletFormView != this.BDx)) {
                this.BDz = this.BDx;
              }
              bool2 = false;
            }
            bool1 = bool2;
            if (this.BDH)
            {
              bool1 = bool2;
              if (!this.BDi.gX(null))
              {
                if ((this.BDz == null) && (localWalletFormView != this.BDi)) {
                  this.BDz = this.BDi;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.BDG)
            {
              bool2 = bool1;
              if (!this.BDj.gX(null))
              {
                if ((this.BDz == null) && (localWalletFormView != this.BDj)) {
                  this.BDz = this.BDj;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.BDG)
            {
              bool1 = bool2;
              if (!this.BDk.gX(null))
              {
                if ((this.BDz == null) && (localWalletFormView != this.BDk)) {
                  this.BDz = this.BDk;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.BEf)
            {
              bool2 = bool1;
              if (!this.BDl.gX(null))
              {
                if ((this.BDz == null) && (localWalletFormView != this.BDl)) {
                  this.BDz = this.BDl;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.BDL)
            {
              bool1 = bool2;
              if (!this.BDp.gX(null))
              {
                if ((this.BDz == null) && (localWalletFormView != this.BDp)) {
                  this.BDz = this.BDp;
                }
                bool1 = false;
              }
            }
            if (!bool1) {
              break label1201;
            }
            this.fwU.setEnabled(true);
            this.fwU.setClickable(true);
            if (localWalletFormView != null) {
              localWalletFormView.setImeOptions(1073741824);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(70812);
            return bool1;
            this.Bmk.setText(2131765126);
            this.Bmk.setTextColor(getResources().getColor(2131100798));
            break;
            bool1 = bool2;
            if (i == 0) {
              break label401;
            }
            this.Bmk.setVisibility(0);
            bool1 = bool2;
            break label401;
            label1165:
            this.Bmk.setText(getString(2131765136));
            break label436;
            bool2 = bool1;
            if (i == 0) {
              break label543;
            }
            this.BCY.setVisibility(4);
            bool2 = bool1;
            break label543;
            label1201:
            this.fwU.setEnabled(false);
            this.fwU.setClickable(false);
          }
          label1220:
          i = 0;
        }
        i = 0;
      }
    }
  }
  
  private void azJ(String paramString)
  {
    AppMethodBeat.i(70811);
    Object localObject = s.erG().BoS;
    this.BDS.clear();
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
        } while (!localElementQuery.tGS.equals(paramString));
        ac.i("MicroMsg.WalletCardElmentUI", "add element: %s, %s", new Object[] { localElementQuery.tGS, localElementQuery.cZz });
        this.BDS.add(localElementQuery);
        if ((getInput().getInt("key_bind_scene", -1) == 5) && (!localElementQuery.Bwu)) {
          localElementQuery.Bwe = getString(2131765969);
        }
      } while (this.BDS.size() < 2);
    }
    AppMethodBeat.o(70811);
  }
  
  private static void d(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(70804);
    if (!bs.isNullOrNil(paramString))
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
  
  private void etm()
  {
    AppMethodBeat.i(70801);
    Object localObject;
    if (etr()) {
      localObject = getInput().getString("realname_verify_process_get_wording_cache");
    }
    try
    {
      if (!bs.isNullOrNil((String)localObject))
      {
        localObject = (bcx)new bcx().parseFrom(((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.Brp.addAll(((bcx)localObject).ETm);
      }
      localObject = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      if (localObject != null)
      {
        this.mTrueName = ((RealNameBundle)localObject).BsL;
        this.BEe = ((RealNameBundle)localObject).Bth;
        this.exL = ((RealNameBundle)localObject).exL;
        if ((this.Bqm != null) && (this.Bqm.eri() != null) && (this.Bqm.eri().contains(Integer.valueOf(((RealNameBundle)localObject).BsO))))
        {
          ac.i("MicroMsg.WalletCardElmentUI", "set cretype: %s", new Object[] { Integer.valueOf(((RealNameBundle)localObject).BsO), this.Bqm.eri() });
          this.Bmm = ((RealNameBundle)localObject).BsO;
          this.BDg.setText(((RealNameBundle)localObject).BsP);
          this.Bmi.setText(((RealNameBundle)localObject).BsM);
          a(this.Bmi, this.Bmm);
          if (((RealNameBundle)localObject).BsX != 9999) {
            break label606;
          }
          this.BDo.setText(getString(2131766450));
          this.BDU = 9999;
          this.BDV = 12;
          this.BDW = 31;
          this.BDn.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(((RealNameBundle)localObject).Btj), Integer.valueOf(((RealNameBundle)localObject).Btk), Integer.valueOf(((RealNameBundle)localObject).Btl) }));
          this.mSelectCreCountIndex = ((RealNameBundle)localObject).BsV;
          this.BDm.setText(this.Brq[this.mSelectCreCountIndex]);
        }
        this.BCi.setText(((RealNameBundle)localObject).BsL);
        this.countryCode = ((RealNameBundle)localObject).BsR;
        this.provinceCode = ((RealNameBundle)localObject).BsS;
        this.cityCode = ((RealNameBundle)localObject).BsT;
        this.BDj.setText(((RealNameBundle)localObject).BsU);
        this.BDk.setText(((RealNameBundle)localObject).Bth);
        this.BDQ = ((RealNameBundle)localObject).Bte;
        this.BDq.setText(((RealNameBundle)localObject).Btf);
        this.Bqn = ((RealNameBundle)localObject).BsQ;
        if (this.Bqn != null) {
          this.BDi.setText(this.Bqn.BsJ);
        }
        this.BEg = (((RealNameBundle)localObject).exL - 1);
        if (this.BEg < 0) {
          this.BEg = 0;
        }
        WalletFormView localWalletFormView = this.BDl;
        if (((RealNameBundle)localObject).exL != 1) {
          break label656;
        }
        i = 2131763533;
        localWalletFormView.setText(getString(i));
        this.BEa = ((RealNameBundle)localObject).Btb;
        this.BEb = ((RealNameBundle)localObject).Btc;
        this.BEc = ((RealNameBundle)localObject).Btd;
        if ((this.BEa > 0) && (this.BEb > 0) && (this.BEc > 0)) {
          this.BDp.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.BEa), Integer.valueOf(this.BEb), Integer.valueOf(this.BEc) }));
        }
      }
      AppMethodBeat.o(70801);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WalletCardElmentUI", localIOException, "", new Object[0]);
        continue;
        label606:
        this.BDo.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(localIOException.BsX), Integer.valueOf(localIOException.BsY), Integer.valueOf(localIOException.BsZ) }));
        continue;
        label656:
        int i = 2131763532;
      }
    }
  }
  
  private void etn()
  {
    AppMethodBeat.i(70802);
    Object localObject1;
    Object localObject2;
    if (this.Bqm.Bws == 0)
    {
      this.BDy.euz();
      localObject1 = s.erG().BzW;
      if (localObject1 == null) {
        break label172;
      }
      localObject2 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.wallet_core.id_verify.model.a)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).cZz.equals(this.Bqm.cZz))
          {
            label77:
            localObject2 = this.BDy;
            if (localObject1 != null)
            {
              if (bs.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).Bsn)) {
                break label177;
              }
              ((WalletPhoneInputView)localObject2).BMg.setHint(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).Bsn);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!bs.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).Bso)) {
        ((WalletPhoneInputView)localObject2).BMn = ((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).Bso;
      }
      AppMethodBeat.o(70802);
      return;
      this.BDy.euA();
      localObject1 = (EditText)this.BDy.findViewById(2131303383);
      setEditFocusListener(this.BDy.getPhoneNumberEt(), (EditText)localObject1, 0, false, false, true);
      break;
      label172:
      localObject1 = null;
      break label77;
      label177:
      ((WalletPhoneInputView)localObject2).BMg.setHint(((WalletPhoneInputView)localObject2).getContext().getString(2131765144));
    }
  }
  
  private void eto()
  {
    AppMethodBeat.i(70808);
    Object localObject1;
    boolean bool;
    if (aRK())
    {
      f.euN();
      if (!bs.isNullOrNil(this.Bqm.Bwc))
      {
        localObject1 = getInput();
        if ((this.BDE.getVisibility() == 0) && (this.BDE.isChecked()))
        {
          bool = true;
          ((Bundle)localObject1).putBoolean("key_is_follow_bank_username", bool);
          getInput().putString("key_bank_username", this.Bqm.Bwc);
        }
      }
      else
      {
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if ((this.Bqm != null) && (localObject1 != null) && (this.Bjk != null) && (this.BDB != null))
        {
          if (!this.BDB.containsKey(this.Bqm.cZz)) {
            break label1487;
          }
          ((FavorPayInfo)localObject1).Bwv = ((d.a)this.BDB.get(this.Bqm.cZz)).BBJ.Bhb;
          label168:
          getInput().putParcelable("key_favor_pay_info", (Parcelable)localObject1);
        }
        this.Bia = new Authen();
        if (this.BCk != null)
        {
          this.Bia.vwo = this.BCk.Bum;
          this.Bia.tyP = this.BCk.field_bankcardTail;
        }
        localObject1 = getInput().getString("key_card_id");
        if (this.BDA.getVisibility() != 0) {
          break label1555;
        }
        localObject1 = this.BDA.getText();
      }
    }
    label524:
    label1555:
    for (;;)
    {
      this.Bia.wfX = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.Bia.BtD = ((String)localObject1);
      this.Bia.cZz = this.Bqm.cZz;
      this.Bia.BtC = this.Bmm;
      this.Bia.BtA = getInput().getString("key_pwd1");
      if (!bs.isNullOrNil(this.BDe.getText())) {
        this.Bia.BtE = this.BDe.getText();
      }
      this.Bia.BoQ = this.BDh.getText();
      this.Bia.BtH = this.BDr.getText();
      this.Bia.BtI = this.BDs.getText();
      this.Bia.country = this.BDF;
      this.Bia.exV = this.ueo;
      this.Bia.exW = this.uep;
      this.Bia.hEt = this.BDu.getText();
      this.Bia.tGU = this.BDv.getText();
      this.Bia.iYE = this.BDw.getText();
      this.Bia.exO = this.BDx.getText();
      String str = com.tencent.mm.wallet_core.ui.e.aSJ(this.Bia.BoQ);
      getInput().putString("key_mobile", str);
      localObject1 = getInput();
      label736:
      Object localObject2;
      if (this.Bqm.BoU == 2)
      {
        bool = true;
        ((Bundle)localObject1).putBoolean("key_is_oversea", bool);
        this.Bia.BtB = this.Bmi.getText();
        this.Bia.BsL = this.BCi.getText();
        this.Bia.BtF = this.BDd.getText();
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if (localObject1 != null)
        {
          this.Bia.BtJ = ((FavorPayInfo)localObject1).Bwy;
          this.Bia.BtK = ((FavorPayInfo)localObject1).Bwv;
        }
        this.Bia.BtP = ("+" + this.BDy.getCountryCode());
        this.Bia.BsV = this.mSelectCreCountIndex;
        if (this.BDU != 9999) {
          break label1511;
        }
        ac.i("MicroMsg.WalletCardElmentUI", "is long term");
        localObject1 = new TenpaySecureEncrypt();
        this.Bia.BsW = ((TenpaySecureEncrypt)localObject1).desedeEncode(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.BDU), Integer.valueOf(this.BDV), Integer.valueOf(this.BDW) }), com.tencent.mm.wallet_core.ui.e.fAR());
        ac.d("MicroMsg.WalletCardElmentUI", "expire date: %s", new Object[] { this.BDo.getText() });
        this.Bia.Bta = this.BDp.getText();
        ac.d("MicroMsg.WalletCardElmentUI", "birth date: %s", new Object[] { this.BDp.getText() });
        localObject2 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new RealNameBundle();
        }
        ((RealNameBundle)localObject1).BsL = this.BCi.getText();
        ((RealNameBundle)localObject1).exL = (this.BEg + 1);
        ((RealNameBundle)localObject1).BsR = this.countryCode;
        ((RealNameBundle)localObject1).BsS = this.provinceCode;
        ((RealNameBundle)localObject1).BsT = this.cityCode;
        ((RealNameBundle)localObject1).Bth = this.BDk.getText();
        ((RealNameBundle)localObject1).BsQ = this.Bqn;
        ((RealNameBundle)localObject1).Bte = this.BDQ;
        ((RealNameBundle)localObject1).Bta = this.BDp.getText();
        ((RealNameBundle)localObject1).BsO = this.Bmm;
        ((RealNameBundle)localObject1).BsP = this.BDg.getText();
        ((RealNameBundle)localObject1).BsM = "";
        ((RealNameBundle)localObject1).BsN = this.Bmi.getText();
        ((RealNameBundle)localObject1).Bti = this.BDn.getText();
        ((RealNameBundle)localObject1).BsW = this.BDo.getText();
        ((RealNameBundle)localObject1).BsV = this.mSelectCreCountIndex;
        getInput().putParcelable("realname_verify_process_bundle", (Parcelable)localObject1);
        ac.d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", new Object[] { Integer.valueOf(this.Bia.BsV), this.Bia.BsW, this.Bia.Bta });
        if ((etq()) && (!bs.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!bs.isNullOrNil(getInput().getString("key_true_name"))))
        {
          ac.i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
          this.Bia.BtB = getInput().getString("key_identity");
          this.Bia.BtC = getInput().getInt("key_id_type", -1);
          this.Bia.BsL = this.mTrueName;
          ac.i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.Bia.BsL);
        }
        ac.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.Bia.wfX + " elemt.bankcardTag : " + this.Bqm.BoU);
        ac.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.Bqm.BoU);
        localObject2 = getInput();
        ((Bundle)localObject2).putString("key_mobile", str);
        ((Bundle)localObject2).putParcelable("key_authen", this.Bia);
        ((Bundle)localObject2).putString("key_bank_phone", this.Bqm.Bwb);
        ((Bundle)localObject2).putString("key_country_code", this.countryCode);
        ((Bundle)localObject2).putString("key_province_code", this.provinceCode);
        ((Bundle)localObject2).putString("key_city_code", this.cityCode);
        ((Bundle)localObject2).putParcelable("key_profession", this.Bqn);
        ((Bundle)localObject2).putString("key_country_iso", this.BDQ);
        ((Bundle)localObject2).putString("key_bind_card_type", this.Bia.cZz);
        ((Bundle)localObject2).putString("key_bind_card_show1", this.Bqm.tGS);
        if (2 != this.Bqm.BvY) {
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
        if (!bs.isNullOrNil((String)localObject1))
        {
          this.Bia.BtQ = 1;
          this.Bia.Bpa = ((String)localObject1);
        }
        this.Bia.BtR = ((Bundle)localObject2).getString("kreq_token");
        if (!getNetController().s(new Object[] { this.Bia, this.wSu })) {
          break label1539;
        }
        ac.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
        AppMethodBeat.o(70808);
        return;
        bool = false;
        break;
        ((FavorPayInfo)localObject1).Bwv = this.Bjk.cb(((FavorPayInfo)localObject1).Bwv, false);
        break label168;
        bool = false;
        break label524;
        this.Bia.BsW = this.BDo.getText();
        break label736;
      }
      ac.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70808);
      return;
    }
  }
  
  private void etp()
  {
    AppMethodBeat.i(70818);
    Object localObject;
    if ((this.Bqm != null) && (this.BDB != null) && (this.BDB.containsKey(this.Bqm.cZz)))
    {
      localObject = (d.a)this.BDB.get(this.Bqm.cZz);
      if ((localObject == null) || (((d.a)localObject).BBJ == null)) {
        break label133;
      }
    }
    label133:
    for (double d = ((d.a)localObject).BBK;; d = 0.0D)
    {
      localObject = getString(2131765090, new Object[] { com.tencent.mm.wallet_core.ui.e.D(d) });
      this.BDa.setText((CharSequence)localObject);
      this.BDa.setVisibility(0);
      AppMethodBeat.o(70818);
      return;
      this.BDa.setVisibility(8);
      AppMethodBeat.o(70818);
      return;
    }
  }
  
  private boolean etq()
  {
    AppMethodBeat.i(70819);
    boolean bool = getInput().getBoolean("key_is_forgot_process", false);
    AppMethodBeat.o(70819);
    return bool;
  }
  
  private boolean etr()
  {
    AppMethodBeat.i(174523);
    com.tencent.mm.wallet_core.d locald = getProcess();
    if ((locald != null) && ("realname_verify_process".equals(locald.cHN())))
    {
      if (locald.dmf.getInt("real_name_verify_mode", 0) == 4)
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
  
  private void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(70803);
    if (this.Bqm == null) {
      this.Bqm = new ElementQuery();
    }
    ac.i("MicroMsg.WalletCardElmentUI", "element: %s, %s", new Object[] { this.Bqm.tGS, this.Bqm.cZz });
    etn();
    etp();
    com.tencent.mm.wallet_core.a.br(this);
    Object localObject1 = (Bankcard)getInput().getParcelable("key_bankcard");
    Object localObject2;
    Object localObject3;
    if ((etq()) && (localObject1 != null))
    {
      this.BDA.setHint(getString(2131765130, new Object[] { ((Bankcard)localObject1).field_bankcardTail }));
      localObject1 = this.BDA;
      localObject2 = this.BCT;
      localObject3 = this.BCU;
      a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
      localObject1 = this.BDc;
      localObject2 = this.BCV;
      localObject3 = this.BCW;
      a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
    }
    for (;;)
    {
      if (paramBoolean) {
        etm();
      }
      this.BDI = false;
      this.BDJ = false;
      this.BDL = false;
      this.BDM = false;
      if (!etr()) {
        break;
      }
      localObject1 = this.Brp.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cmb)((Iterator)localObject1).next();
        if (((cmb)localObject2).Fzq.key == this.Bmm)
        {
          this.BDI = ((cmb)localObject2).Fzu;
          this.BDJ = ((cmb)localObject2).Fzt;
          this.BDK = ((cmb)localObject2).Fzx;
          this.BDL = ((cmb)localObject2).Fzv;
          this.BEf = ((cmb)localObject2).Fzz;
          this.BDH = ((cmb)localObject2).Fzr;
          this.BDG = ((cmb)localObject2).Fzs;
          this.BDN = ((cmb)localObject2).Fzw;
          this.BDM = true;
        }
      }
      if (!bs.isNullOrNil(this.Bqm.tGS))
      {
        this.BDc.setText(this.Bqm.tGS);
        if (!this.Bqm.eqT()) {
          break label561;
        }
        this.BDR.setVisibility(0);
        this.BDR.setText(getString(2131765221));
      }
      for (;;)
      {
        localObject1 = this.BDA;
        localObject2 = this.BCT;
        localObject3 = this.BCU;
        a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        localObject1 = this.BDc;
        localObject2 = this.BCV;
        localObject3 = this.BCW;
        a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        this.BDA.setOnInfoIvClickListener(this.BEj);
        if (!s.ery().esi().erP()) {
          break label596;
        }
        this.BDA.getInfoIv().setImageResource(2131691405);
        this.BDA.getInfoIv().setVisibility(0);
        break;
        label561:
        if (this.Bqm.erh())
        {
          this.BDR.setVisibility(0);
          this.BDR.setText(getString(2131765241));
        }
      }
      label596:
      this.BDA.getInfoIv().setVisibility(4);
    }
    Object localObject4;
    WalletFormView localWalletFormView1;
    WalletFormView localWalletFormView2;
    TextView localTextView1;
    TextView localTextView2;
    boolean bool1;
    boolean bool2;
    if ((this.Bqm.Bwt != null) && (!this.Bqm.Bwt.isEmpty()))
    {
      ac.i("MicroMsg.WalletCardElmentUI", "identity type： %s", new Object[] { Integer.valueOf(this.Bmm) });
      localObject1 = this.Bqm.Bwt.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CreTypeRuleInfo)((Iterator)localObject1).next();
        if (((CreTypeRuleInfo)localObject2).Bvx == this.Bmm)
        {
          if (((CreTypeRuleInfo)localObject2).Bvy.Bvt == 1)
          {
            ac.i("MicroMsg.WalletCardElmentUI", "need show cre count");
            this.BDI = true;
          }
          if (((CreTypeRuleInfo)localObject2).Bvy.Bvv == 1)
          {
            ac.i("MicroMsg.WalletCardElmentUI", "need show cre expire");
            this.BDJ = true;
          }
          if (((CreTypeRuleInfo)localObject2).Bvy.Bvu == 1)
          {
            ac.i("MicroMsg.WalletCardElmentUI", "need show birthday");
            this.BDL = true;
          }
          if (((CreTypeRuleInfo)localObject2).Bvy.Bvw == 1)
          {
            ac.i("MicroMsg.WalletCardElmentUI", "need show cre type");
            if (s.ery().esk() > 0)
            {
              ac.i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
              this.BDM = true;
            }
          }
        }
      }
      if ((this.Bmm == 2) && (this.BDO))
      {
        this.BDN = true;
        if (!this.BDJ)
        {
          this.BDU = 0;
          this.BDV = 0;
          this.BDW = 0;
        }
        if (!this.BDL)
        {
          this.BEa = 0;
          this.BEb = 0;
          this.BEc = 0;
        }
        if (!this.BDI) {
          this.mSelectCreCountIndex = 0;
        }
        this.BDf.setVisibility(8);
        if (!Bankcard.TF(this.Bqm.BoU)) {
          break label1497;
        }
        localObject1 = this.BCi;
        localObject2 = this.BDg;
        localObject3 = this.Bmi;
        localObject4 = this.BDm;
        localWalletFormView1 = this.BDn;
        localWalletFormView2 = this.BDo;
        localTextView1 = this.Bmj;
        localTextView2 = this.Bmk;
        a(new boolean[] { 0, 0, 0, 0, 0, 0 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.BDh.setVisibility(8);
        tF(true);
        paramBoolean = this.BDL;
        bool1 = this.BDN;
        bool2 = this.BEf;
        localObject1 = this.BDj;
        localObject2 = this.BDk;
        localObject3 = this.BDi;
        localObject4 = this.BDp;
        localWalletFormView1 = this.BDq;
        localWalletFormView2 = this.BDl;
        localTextView1 = this.BDb;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        paramBoolean = this.Bqm.BvS;
        bool1 = this.Bqm.BvT;
        localObject1 = this.BDe;
        localObject2 = this.BDd;
        localObject3 = this.BCX;
        localObject4 = this.BCY;
        a(new boolean[] { paramBoolean, bool1 }, new WalletFormView[] { localObject1, localObject2 }, (TextView)localObject3, (TextView)localObject4);
        if (this.BDc.getVisibility() != 0) {
          break label2960;
        }
        switch (this.Bqm.BvX)
        {
        default: 
          this.BCW.setVisibility(8);
          label1325:
          this.BCW.setTextColor(getResources().getColor(2131100707));
        }
      }
    }
    for (;;)
    {
      if ((!bs.isNullOrNil(this.Bqm.Bwr)) && (this.BCW.getVisibility() != 0))
      {
        ac.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
        this.BCW.setText(this.Bqm.Bwr);
        this.BCW.setVisibility(0);
      }
      if ((bs.isNullOrNil(this.Bqm.Bwc)) || (!com.tencent.mm.model.w.wG(this.Bqm.Bwc)) || (etq())) {
        break label2972;
      }
      this.BDE.setText(this.Bqm.Bwd);
      this.BDE.setVisibility(0);
      AppMethodBeat.o(70803);
      return;
      this.BDN = false;
      break;
      if ((this.Bmm == 2) && (this.BDO))
      {
        this.BDN = true;
        break;
      }
      this.BDN = false;
      break;
      label1497:
      int i;
      if ((this.Bqm.eri() != null) && (this.Bqm.eri().size() > 0))
      {
        i = 1;
        label1524:
        if ((!etq()) && (!s.ery().esc())) {
          break label2440;
        }
        localObject2 = s.ery().getTrueName();
        localObject1 = localObject2;
        if (bs.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          if (getProcess() != null) {
            localObject1 = getProcess().dmf.getString("key_true_name");
          }
        }
        if (bs.isNullOrNil((String)localObject1)) {
          break label2252;
        }
        localObject1 = getString(2131765180, new Object[] { com.tencent.mm.wallet_core.ui.e.aSI((String)localObject1) });
        this.BCi.setHint((CharSequence)localObject1);
        this.BDf.setHint((CharSequence)localObject1);
        label1633:
        if ((!etq()) || (bs.isNullOrNil(getInput().getString("key_identity"))) || (getInput().getInt("key_id_type", -1) == -1) || (bs.isNullOrNil(getInput().getString("key_true_name")))) {
          break label2282;
        }
        ac.i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
        paramBoolean = this.BDI;
        bool1 = this.BDK;
        bool2 = this.BDJ;
        localObject1 = this.BCi;
        localObject2 = this.BDg;
        localObject3 = this.Bmi;
        localObject4 = this.BDm;
        localWalletFormView1 = this.BDn;
        localWalletFormView2 = this.BDo;
        localTextView1 = this.Bmj;
        localTextView2 = this.Bmk;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.mTrueName = getInput().getString("key_true_name");
        ac.i("MicroMsg.WalletCardElmentUI", "name is " + this.mTrueName);
        this.BDh.setVisibility(0);
        if (this.BCk != null)
        {
          if (!bs.isNullOrNil(this.BCk.field_mobile)) {
            d(this.BDh, this.BCk.field_mobile);
          }
          if (!bs.isNullOrNil(this.BCk.BtE)) {
            d(this.BDe, this.BCk.BtE);
          }
          if (!bs.isNullOrNil(this.BCk.Bul)) {
            d(this.BDd, this.BCk.Bul);
          }
        }
        if (!this.Bqm.BvQ) {
          break label2681;
        }
        this.Bmk.setText("");
      }
      for (;;)
      {
        if (!bs.isNullOrNil(this.Bqm.BvU)) {
          this.Bmi.setText(this.Bqm.BvU);
        }
        if (s.ery().esk() <= 0) {
          break label2698;
        }
        ac.i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", new Object[] { Integer.valueOf(s.ery().esk()) });
        this.BDg.setClickable(false);
        this.BDg.setText(s.erG().gH(this));
        this.BDg.setInputEnable(false);
        a(this.Bmi, this.Bmm);
        tF(false);
        paramBoolean = this.BEf;
        bool1 = this.BDG;
        bool2 = this.BDG;
        boolean bool3 = this.BDH;
        boolean bool4 = this.BDL;
        boolean bool5 = this.BDN;
        localObject1 = this.BDl;
        localObject2 = this.BDj;
        localObject3 = this.BDk;
        localObject4 = this.BDi;
        localWalletFormView1 = this.BDp;
        localWalletFormView2 = this.BDq;
        localTextView1 = this.BDb;
        a(new boolean[] { paramBoolean, bool1, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        break;
        i = 0;
        break label1524;
        label2252:
        localObject1 = getString(2131765179);
        this.BCi.setHint((CharSequence)localObject1);
        this.BDf.setHint((CharSequence)localObject1);
        break label1633;
        label2282:
        if ((this.BDM) || (i != 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool1 = this.BDI;
          bool2 = this.BDK;
          bool3 = this.BDJ;
          localObject1 = this.BCi;
          localObject2 = this.BDg;
          localObject3 = this.Bmi;
          localObject4 = this.BDm;
          localWalletFormView1 = this.BDn;
          localWalletFormView2 = this.BDo;
          localTextView1 = this.Bmj;
          localTextView2 = this.Bmk;
          a(new boolean[] { true, paramBoolean, true, bool1, bool2, bool3 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          break;
        }
        label2440:
        bool1 = this.Bqm.BvQ;
        if ((this.BDM) || ((i != 0) && (this.Bqm.BvR))) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool2 = this.Bqm.BvR;
          bool3 = this.BDI;
          bool4 = this.BDK;
          bool5 = this.BDJ;
          localObject1 = this.BCi;
          localObject2 = this.BDg;
          localObject3 = this.Bmi;
          localObject4 = this.BDm;
          localWalletFormView1 = this.BDn;
          localWalletFormView2 = this.BDo;
          localTextView1 = this.Bmj;
          localTextView2 = this.Bmk;
          a(new boolean[] { bool1, paramBoolean, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          this.BDh.setVisibility(0);
          ac.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.Bqm.BvQ + " canModifyIdentity:" + this.Bqm.BvR);
          break;
        }
        label2681:
        this.Bmk.setText(getString(2131765136));
      }
      label2698:
      if (this.Bqm.eri() != null)
      {
        i = this.Bqm.eri().size();
        label2721:
        ac.i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", new Object[] { Integer.valueOf(i) });
        if (i > 1) {
          break label2876;
        }
        this.BDg.setClickable(false);
        this.BDg.setInputEnable(false);
        this.Bmi.setInputEnable(true);
      }
      for (;;)
      {
        localObject1 = this.Bqm.eri();
        if ((localObject1 == null) || (!((List)localObject1).contains(Integer.valueOf(this.Bmm)))) {
          this.Bmm = 1;
        }
        if (!s.erG().aj(this, this.Bmm).equals(this.BEd)) {
          com.tencent.mm.plugin.report.service.h.wUl.f(16816, new Object[] { Integer.valueOf(this.Bmm) });
        }
        this.BDg.setText(s.erG().aj(this, this.Bmm));
        break;
        i = 0;
        break label2721;
        label2876:
        this.BDg.setClickable(true);
        this.BDg.setInputEnable(true);
        this.Bmi.setInputEnable(true);
      }
      this.BCW.setText(2131765096);
      this.BCW.setVisibility(0);
      break label1325;
      this.BCW.setVisibility(8);
      break label1325;
      this.BCW.setVisibility(8);
      break label1325;
      this.BCW.setVisibility(8);
      break label1325;
      label2960:
      this.BCW.setVisibility(8);
    }
    label2972:
    this.BDE.setVisibility(8);
    AppMethodBeat.o(70803);
  }
  
  private void tF(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(70805);
    if (paramBoolean)
    {
      Object localObject = this.yQm;
      if (this.Bqm.Bwf)
      {
        i = 0;
        ((TextView)localObject).setVisibility(i);
        localObject = this.BDr;
        if (!this.Bqm.Bwf) {
          break label225;
        }
        i = 0;
        label54:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.BDs;
        if (!this.Bqm.Bwg) {
          break label231;
        }
        i = 0;
        label78:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.BDt;
        if (!this.Bqm.Bwh) {
          break label237;
        }
        i = 0;
        label102:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.BDu;
        if (!this.Bqm.Bwk) {
          break label243;
        }
        i = 0;
        label126:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.BDv;
        if (!this.Bqm.Bwm) {
          break label249;
        }
        i = 0;
        label150:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.BDw;
        if (!this.Bqm.Bwl) {
          break label255;
        }
        i = 0;
        label174:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.BDx;
        if (!this.Bqm.Bwn) {
          break label261;
        }
      }
      label261:
      for (int i = j;; i = 8)
      {
        ((WalletFormView)localObject).setVisibility(i);
        this.BCZ.setVisibility(4);
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
    this.yQm.setVisibility(8);
    this.BDr.setVisibility(8);
    this.BDs.setVisibility(8);
    this.BDt.setVisibility(8);
    this.BDu.setVisibility(8);
    this.BDv.setVisibility(8);
    this.BDw.setVisibility(8);
    this.BDx.setVisibility(8);
    this.BCZ.setVisibility(8);
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
    this.BCT = ((TextView)findViewById(2131306710));
    this.BDA = ((WalletFormView)findViewById(2131306708));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.BDA);
    this.BCU = ((TextView)findViewById(2131306709));
    this.Bmj = ((TextView)findViewById(2131306712));
    this.BCi = ((WalletFormView)findViewById(2131302662));
    this.BDf = ((WalletFormView)findViewById(2131300224));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.BCi);
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.BDf);
    this.BDg = ((WalletFormView)findViewById(2131306730));
    this.Bmi = ((WalletFormView)findViewById(2131300910));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.Bmi);
    this.Bmk = ((TextView)findViewById(2131306711));
    this.BCV = ((TextView)findViewById(2131306701));
    this.BDc = ((WalletFormView)findViewById(2131306713));
    this.BDR = ((WalletFormView)findViewById(2131306717));
    this.BCW = ((TextView)findViewById(2131306702));
    this.BDa = ((TextView)findViewById(2131306706));
    this.BCX = ((TextView)findViewById(2131306704));
    this.BDe = ((WalletFormView)findViewById(2131298914));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.BDe);
    this.BDd = ((WalletFormView)findViewById(2131298929));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.BDd);
    this.BCY = ((TextView)findViewById(2131306703));
    this.yQm = ((TextView)findViewById(2131306699));
    this.BDr = ((WalletFormView)findViewById(2131300112));
    this.BDs = ((WalletFormView)findViewById(2131301314));
    this.BDt = ((WalletFormView)findViewById(2131296936));
    this.BDu = ((WalletFormView)findViewById(2131296479));
    this.BDv = ((WalletFormView)findViewById(2131303210));
    this.BDw = ((WalletFormView)findViewById(2131303363));
    this.BDx = ((WalletFormView)findViewById(2131299329));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.BDx);
    this.BCZ = ((TextView)findViewById(2131306698));
    this.BDD = ((CheckBox)findViewById(2131296518));
    this.BDE = ((CheckBox)findViewById(2131296515));
    this.fwU = ((Button)findViewById(2131302852));
    this.fwW = ((ScrollView)findViewById(2131306834));
    this.BDi = ((WalletFormView)findViewById(2131303415));
    this.BDj = ((WalletFormView)findViewById(2131303412));
    this.BDk = ((WalletFormView)findViewById(2131303411));
    this.BDl = ((WalletFormView)findViewById(2131303416));
    this.BDm = ((WalletFormView)findViewById(2131306727));
    this.BDn = ((WalletFormView)findViewById(2131306728));
    this.BDo = ((WalletFormView)findViewById(2131306729));
    this.BDp = ((WalletFormView)findViewById(2131303413));
    this.BDq = ((WalletFormView)findViewById(2131303414));
    this.BDb = ((TextView)findViewById(2131306715));
    this.BDy = ((WalletPhoneInputView)findViewById(2131302361));
    this.BDh = this.BDy.getPhoneNumberEt();
    this.BCi.setOnInputValidChangeListener(this);
    this.BDf.setOnInputValidChangeListener(this);
    this.BDA.setOnInputValidChangeListener(this);
    this.BDg.setOnInputValidChangeListener(this);
    this.Bmi.setOnInputValidChangeListener(this);
    this.BDh.setOnInputValidChangeListener(new WalletFormView.a()
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
    this.BDe.setOnInputValidChangeListener(this);
    this.BDd.setOnInputValidChangeListener(this);
    this.BDr.setOnInputValidChangeListener(this);
    this.BDs.setOnInputValidChangeListener(this);
    this.BDt.setOnInputValidChangeListener(this);
    this.BDu.setOnInputValidChangeListener(this);
    this.BDv.setOnInputValidChangeListener(this);
    this.BDw.setOnInputValidChangeListener(this);
    this.BDx.setOnInputValidChangeListener(this);
    this.BDi.setOnInputValidChangeListener(this);
    this.BDj.setOnInputValidChangeListener(this);
    this.BCi.setOnEditorActionListener(this);
    this.BDf.setOnEditorActionListener(this);
    this.BDA.setOnEditorActionListener(this);
    this.BDg.setOnEditorActionListener(this);
    this.Bmi.setOnEditorActionListener(this);
    this.BDh.setOnEditorActionListener(this);
    this.BDe.setOnEditorActionListener(this);
    this.BDd.setOnEditorActionListener(this);
    this.BDr.setOnEditorActionListener(this);
    this.BDs.setOnEditorActionListener(this);
    this.BDt.setOnEditorActionListener(this);
    this.BDu.setOnEditorActionListener(this);
    this.BDv.setOnEditorActionListener(this);
    this.BDw.setOnEditorActionListener(this);
    this.BDx.setOnEditorActionListener(this);
    this.BDj.setOnEditorActionListener(this);
    this.BDi.setOnEditorActionListener(this);
    this.BDc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70786);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardElementUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putInt("key_bind_scene", WalletCardElementUI.this.getInput().getInt("key_bind_scene", -1));
        bs.isNullOrNil(WalletCardElementUI.c(WalletCardElementUI.this).getText());
        WalletCardElementUI.this.hideTenpayKB();
        com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.br(WalletCardElementUI.this);
        if (locald != null) {
          locald.a(WalletCardElementUI.this, WalletBankCardSelectUI.class, paramAnonymousView, 1);
        }
        AppMethodBeat.o(70786);
      }
    });
    this.BDR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70788);
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(WalletCardElementUI.this.getString(2131765241));
        paramAnonymousView.add(WalletCardElementUI.this.getString(2131765221));
        ElementQuery localElementQuery;
        if (WalletCardElementUI.d(WalletCardElementUI.this).size() == 1)
        {
          localElementQuery = (ElementQuery)WalletCardElementUI.d(WalletCardElementUI.this).get(0);
          if (!localElementQuery.erh()) {
            break label137;
          }
          paramAnonymousView.remove(1);
        }
        for (;;)
        {
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.adc(WalletCardElementUI.e(WalletCardElementUI.this));
          paramAnonymousView.Jjt = new c.a()
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
                  if (((i != 0) && (paramAnonymous2Object2.erh())) || ((i == 0) && (paramAnonymous2Object2.eqT())))
                  {
                    WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymous2Object2);
                    WalletCardElementUI.g(WalletCardElementUI.this);
                  }
                }
                WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymousView.fvY());
                AppMethodBeat.o(70787);
                return;
              }
            }
          };
          paramAnonymousView.show();
          AppMethodBeat.o(70788);
          return;
          label137:
          if (localElementQuery.eqT()) {
            paramAnonymousView.remove(0);
          }
        }
      }
    });
    this.BDg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70789);
        WalletCardElementUI.h(WalletCardElementUI.this);
        AppMethodBeat.o(70789);
      }
    });
    this.BDm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70791);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), WalletCardElementUI.i(WalletCardElementUI.this));
        paramAnonymousView.Jjt = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(70790);
            if (paramAnonymous2Boolean)
            {
              WalletCardElementUI.j(WalletCardElementUI.this).setText((String)paramAnonymous2Object1);
              WalletCardElementUI.b(WalletCardElementUI.this, paramAnonymousView.fvY());
              WalletCardElementUI.b(WalletCardElementUI.this);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(70790);
          }
        };
        paramAnonymousView.adc(WalletCardElementUI.k(WalletCardElementUI.this));
        paramAnonymousView.show();
        AppMethodBeat.o(70791);
      }
    });
    this.BDn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70793);
        paramAnonymousView = new b(WalletCardElementUI.this.getContext());
        paramAnonymousView.Jjn = new b.a()
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
        Object localObject = Calendar.getInstance();
        int i = ((Calendar)localObject).get(1);
        int j = ((Calendar)localObject).get(2) + 1;
        int k = ((Calendar)localObject).get(5);
        paramAnonymousView.aQ(i, j, k);
        localObject = WalletCardElementUI.l(WalletCardElementUI.this).getContentEt().getText().toString();
        if ((WalletCardElementUI.m(WalletCardElementUI.this) > 0) && (WalletCardElementUI.n(WalletCardElementUI.this) > 0) && (WalletCardElementUI.o(WalletCardElementUI.this) > 0)) {
          paramAnonymousView.aO(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
        }
        for (;;)
        {
          paramAnonymousView.show();
          AppMethodBeat.o(70793);
          return;
          if ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).length() == 8))
          {
            WalletCardElementUI.c(WalletCardElementUI.this, bs.getInt(((String)localObject).substring(0, 4), i));
            WalletCardElementUI.d(WalletCardElementUI.this, bs.getInt(((String)localObject).substring(4, 6), j));
            WalletCardElementUI.e(WalletCardElementUI.this, bs.getInt(((String)localObject).substring(6, 8), k));
            paramAnonymousView.aO(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
          }
        }
      }
    });
    this.BDo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70794);
        paramAnonymousView = new b(WalletCardElementUI.this.getContext());
        paramAnonymousView.Jjn = new b.a()
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
        Object localObject = Calendar.getInstance();
        int i = ((Calendar)localObject).get(1);
        int j = ((Calendar)localObject).get(2) + 1;
        int k = ((Calendar)localObject).get(5);
        paramAnonymousView.aP(i, j, k);
        paramAnonymousView.aQ(i + 200, 12, 31);
        paramAnonymousView.setLongTermYear(true);
        localObject = WalletCardElementUI.p(WalletCardElementUI.this).getContentEt().getText().toString();
        if ((WalletCardElementUI.q(WalletCardElementUI.this) <= 0) || (WalletCardElementUI.r(WalletCardElementUI.this) <= 0) || (WalletCardElementUI.s(WalletCardElementUI.this) <= 0))
        {
          if ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).length() == 8))
          {
            WalletCardElementUI.f(WalletCardElementUI.this, bs.getInt(((String)localObject).substring(0, 4), i));
            WalletCardElementUI.g(WalletCardElementUI.this, bs.getInt(((String)localObject).substring(4, 6), j));
            WalletCardElementUI.h(WalletCardElementUI.this, bs.getInt(((String)localObject).substring(6, 8), k));
          }
        }
        else
        {
          if (WalletCardElementUI.q(WalletCardElementUI.this) != 9999) {
            break label296;
          }
          paramAnonymousView.aO(1, 1, 1);
        }
        for (;;)
        {
          paramAnonymousView.show();
          AppMethodBeat.o(70794);
          return;
          if (!((String)localObject).equals(WalletCardElementUI.this.getString(2131766450))) {
            break;
          }
          WalletCardElementUI.f(WalletCardElementUI.this, 9999);
          WalletCardElementUI.g(WalletCardElementUI.this, 12);
          WalletCardElementUI.h(WalletCardElementUI.this, 31);
          break;
          label296:
          paramAnonymousView.aO(WalletCardElementUI.q(WalletCardElementUI.this), WalletCardElementUI.r(WalletCardElementUI.this), WalletCardElementUI.s(WalletCardElementUI.this));
        }
      }
    });
    this.BDl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70795);
        paramAnonymousView = WalletCardElementUI.this.getResources().getStringArray(2130903102);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), paramAnonymousView);
        paramAnonymousView.Jjt = new c.a()
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
              paramAnonymousView.adc(WalletCardElementUI.u(WalletCardElementUI.this));
              paramAnonymousView.hide();
              AppMethodBeat.o(174522);
              return;
              label90:
              WalletCardElementUI.i(WalletCardElementUI.this, 1);
            }
          }
        };
        paramAnonymousView.show();
        AppMethodBeat.o(70795);
      }
    });
    this.BDj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70797);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("GetAddress", true);
        paramAnonymousView.putExtra("ShowSelectedLocation", false);
        if (!Bankcard.TF(WalletCardElementUI.v(WalletCardElementUI.this).BoU))
        {
          paramAnonymousView.putExtra("IsRealNameVerifyScene", true);
          paramAnonymousView.putExtra("IsNeedShowSearchBar", true);
        }
        if ((WalletCardElementUI.w(WalletCardElementUI.this) != null) && (WalletCardElementUI.w(WalletCardElementUI.this).length > 0))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(Arrays.asList(WalletCardElementUI.w(WalletCardElementUI.this)));
          localArrayList.remove("CN");
          localArrayList.remove("TW");
          localArrayList.remove("HK");
          localArrayList.remove("MO");
          paramAnonymousView.putStringArrayListExtra("BlockedCountries", localArrayList);
        }
        com.tencent.mm.br.d.c(WalletCardElementUI.this.getContext(), ".ui.tools.MultiStageCitySelectUI", paramAnonymousView, 4);
        AppMethodBeat.o(70797);
      }
    });
    this.BDi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70774);
        paramAnonymousView = new Intent(WalletCardElementUI.this.getContext(), WalletSelectProfessionUI.class);
        paramAnonymousView.putExtra("key_profession_list", WalletCardElementUI.x(WalletCardElementUI.this));
        WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 5);
        AppMethodBeat.o(70774);
      }
    });
    this.BDp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(174512);
        paramAnonymousView = new b(WalletCardElementUI.this.getContext());
        paramAnonymousView.Jjn = new b.a()
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
          paramAnonymousView.aO(WalletCardElementUI.z(WalletCardElementUI.this), WalletCardElementUI.A(WalletCardElementUI.this), WalletCardElementUI.B(WalletCardElementUI.this));
        }
        paramAnonymousView.show();
        AppMethodBeat.o(174512);
      }
    });
    this.BDq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70776);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WalletCardElementUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        paramAnonymousView.putExtra("exclude_countries_iso", WalletCardElementUI.w(WalletCardElementUI.this));
        paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
        paramAnonymousView.putExtra("ui_title", WalletCardElementUI.this.getString(2131765859));
        WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 6);
        AppMethodBeat.o(70776);
      }
    });
    this.BDD.setChecked(true);
    this.BDD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
        com.tencent.mm.wallet_core.ui.e.b(WalletCardElementUI.this, WalletCardElementUI.v(WalletCardElementUI.this).cZz, WalletCardElementUI.v(WalletCardElementUI.this).tGS, false, WalletCardElementUI.v(WalletCardElementUI.this).Bwq);
        AppMethodBeat.o(70778);
      }
    });
    this.BDt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174514);
        paramAnonymousView = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
        if (Bankcard.TF(WalletCardElementUI.v(WalletCardElementUI.this).BoU)) {
          paramAnonymousView.putExtra("IsAutoPosition", false);
        }
        for (;;)
        {
          WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 2);
          AppMethodBeat.o(174514);
          return;
          paramAnonymousView.putExtra("IsRealNameVerifyScene", true);
          paramAnonymousView.putExtra("IsNeedShowSearchBar", true);
        }
      }
    });
    this.BDk.setOnInputValidChangeListener(this);
    this.fwU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174515);
        WalletCardElementUI.C(WalletCardElementUI.this);
        AppMethodBeat.o(174515);
      }
    });
    setEditFocusListener(this.BDA, 0, false, false, true);
    setEditFocusListener(this.Bmi, 1, false, false, true);
    setEditFocusListener(this.BDh, 0, false, false, true);
    if ((this.Bqm != null) && (!bs.isNullOrNil(this.Bqm.Bwe)))
    {
      com.tencent.mm.ui.base.h.a(this, this.Bqm.Bwe, null, true, null);
      this.Bqm = null;
    }
    for (;;)
    {
      hj(true);
      aRK();
      Object localObject = com.tencent.mm.wallet_core.a.br(this);
      if ((localObject == null) || (!((com.tencent.mm.wallet_core.d)localObject).fzH())) {
        break label1478;
      }
      localObject = (Orders)getInput().getParcelable("key_orders");
      if ((localObject == null) || (((Orders)localObject).BxB != 1)) {
        break;
      }
      this.BDC = true;
      this.BCi.setText(com.tencent.mm.wallet_core.ui.e.aSI(((Orders)localObject).BsL));
      this.BCi.setEnabled(false);
      this.BCi.setFocusable(false);
      this.Bmm = ((Orders)localObject).BxC;
      this.BDg.setText(s.erG().aj(this, this.Bmm));
      this.BDg.setEnabled(false);
      this.Bmi.setText(((Orders)localObject).BvU);
      this.Bmi.setInputEnable(false);
      this.Bmi.setFocusable(false);
      this.Bmj.setText(2131765089);
      AppMethodBeat.o(70800);
      return;
      if ((getInput().getInt("key_bind_scene", -1) == 5) && (!this.Bqm.Bwu))
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131765971), null, true, null);
        this.Bqm.tGS = null;
      }
    }
    this.BDC = false;
    label1478:
    AppMethodBeat.o(70800);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70810);
    ac.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (this.BDy.f(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(70810);
      return;
    }
    if ((paramInt1 == 6) && (paramInt2 == 100))
    {
      if (!bs.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        this.BDQ = paramIntent.getStringExtra("iso_code");
        this.BDq.setText(paramIntent.getStringExtra("country_name"));
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
      aRK();
      AppMethodBeat.o(70810);
      return;
      this.Bqm = null;
      this.BDT = 0;
      this.mSelectBankName = paramIntent.getStringExtra("bank_name");
      this.BDc.setText(this.mSelectBankName);
      this.BDR.setVisibility(0);
      this.BDR.setText("");
      azJ(this.mSelectBankName);
      if (this.BDS.size() == 1) {
        this.Bqm = ((ElementQuery)this.BDS.get(0));
      }
      ac.i("MicroMsg.WalletCardElmentUI", "select bank: %s, %s", new Object[] { this.mSelectBankName, Integer.valueOf(this.BDS.size()) });
      this.BCk = null;
      hj(false);
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.BDF = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!bs.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.ueo = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.uep = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        if (bs.isNullOrNil(str1))
        {
          this.BDt.setText(str3 + " " + str4);
          label486:
          if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.Bqm.Bwl)) {
            break label709;
          }
          this.BDw.setVisibility(0);
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", new Object[] { str1, str2, str3, str4, this.uep });
        break;
        this.BDt.setText(str1 + " " + str4);
        break label486;
        if (!bs.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.uep = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.BDt.setText(str1 + " " + str3);
          break label486;
        }
        this.uep = this.BDF;
        this.BDt.setText(str1);
        break label486;
        label709:
        this.BDw.setVisibility(8);
      }
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.BDA.set3DesValStr(paramIntent);
      continue;
      str1 = paramIntent.getStringExtra("CountryName");
      str2 = paramIntent.getStringExtra("ProviceName");
      str3 = paramIntent.getStringExtra("CityName");
      this.countryCode = paramIntent.getStringExtra("Country");
      this.provinceCode = paramIntent.getStringExtra("Contact_Province");
      this.cityCode = paramIntent.getStringExtra("Contact_City");
      paramIntent = new StringBuilder();
      if (!bs.isNullOrNil(str1)) {
        paramIntent.append(str1);
      }
      if (!bs.isNullOrNil(str2)) {
        paramIntent.append(" ").append(str2);
      }
      if (!bs.isNullOrNil(str3)) {
        paramIntent.append(" ").append(str3);
      }
      this.BDj.setText(paramIntent.toString());
      continue;
      this.Bqn = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
      this.BDi.setText(this.Bqn.BsJ);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70799);
    super.onCreate(paramBundle);
    this.Bqm = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.wSu = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.Bmm = s.ery().esk();
    this.BCk = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
    this.BDG = getInput().getBoolean("key_need_area", false);
    this.BDH = getInput().getBoolean("key_need_profession", false);
    this.BDO = getInput().getBoolean("key_need_country", false);
    this.BDP = getInput().getStringArray("key_country_excludes");
    if (this.Bqm != null) {
      azJ(this.Bqm.tGS);
    }
    ac.d("MicroMsg.WalletCardElmentUI", "neeCountry: %s", new Object[] { Boolean.valueOf(this.BDO) });
    if ((this.BDG) || (this.BDH)) {
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
    ac.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    this.Brq = new String[100];
    int i = 0;
    while (i < this.Brq.length)
    {
      this.Brq[i] = getString(2131765220, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    paramBundle = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
    if ((this.wSu != null) && (paramBundle != null))
    {
      this.Bjk = e.BBL.a(this.wSu);
      if (this.Bjk == null) {
        break label477;
      }
      paramBundle = this.Bjk.azG(paramBundle.Bwv);
      this.BDB = this.Bjk.azB(paramBundle);
    }
    for (;;)
    {
      initView();
      this.fwW.pageScroll(33);
      f.a(this, getInput(), 3);
      com.tencent.mm.sdk.b.a.GpY.c(this.BlQ);
      AppMethodBeat.o(70799);
      return;
      label477:
      ac.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70815);
    com.tencent.mm.sdk.b.a.GpY.d(this.BlQ);
    super.onDestroy();
    AppMethodBeat.o(70815);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(70814);
    ac.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      if (this.BDz == null) {
        eto();
      }
      AppMethodBeat.o(70814);
      return false;
    }
    boolean bool1;
    if (this.BDz != null)
    {
      paramTextView = this.BDz;
      if (paramTextView.JHv != null)
      {
        bool1 = paramTextView.JHv.isFocusable();
        if (!bool1) {
          break label157;
        }
        paramTextView = this.BDz;
        bool1 = bool2;
        if (paramTextView.JHv != null) {
          bool1 = paramTextView.JHv.isClickable();
        }
        if ((!bool1) || (!this.BDz.fAV())) {
          break label157;
        }
        this.BDz.fAY();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70814);
      return true;
      bool1 = false;
      break;
      label157:
      this.BDz.performClick();
      continue;
      eto();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70813);
    aRK();
    AppMethodBeat.o(70813);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70809);
    ac.i("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      ac.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramn instanceof ad))
      {
        ac.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
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