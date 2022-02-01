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
import com.tencent.mm.g.a.sj;
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
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private TextView AyU;
  private Authen CZU;
  d Dbe;
  private com.tencent.mm.sdk.b.c DdN;
  private WalletFormView Def;
  private TextView Deg;
  private TextView Deh;
  private int Dej;
  private ElementQuery Dif;
  private Profession Dig;
  private List<crv> Dji;
  private String[] Djk;
  private TextView DuP;
  private TextView DuQ;
  private TextView DuR;
  private TextView DuS;
  private TextView DuT;
  private TextView DuU;
  private TextView DuV;
  private TextView DuW;
  private TextView DuX;
  private WalletFormView DuY;
  private WalletFormView DuZ;
  private WalletFormView Due;
  private Bankcard Dug;
  private CheckBox DvA;
  private String DvB;
  private boolean DvC;
  private boolean DvD;
  private boolean DvE;
  private boolean DvF;
  private boolean DvG;
  private boolean DvH;
  private boolean DvI;
  private boolean DvJ;
  private boolean DvK;
  private String[] DvL;
  private String DvM;
  private WalletFormView DvN;
  private List<ElementQuery> DvO;
  private int DvP;
  private int DvQ;
  private int DvR;
  private int DvS;
  private int DvT;
  private int DvU;
  private int DvV;
  private int DvW;
  private int DvX;
  private int DvY;
  private String DvZ;
  private WalletFormView Dva;
  private WalletFormView Dvb;
  private WalletFormView Dvc;
  private WalletFormView Dvd;
  private WalletFormView Dve;
  private WalletFormView Dvf;
  private WalletFormView Dvg;
  private WalletFormView Dvh;
  private WalletFormView Dvi;
  private WalletFormView Dvj;
  private WalletFormView Dvk;
  private WalletFormView Dvl;
  private WalletFormView Dvm;
  private WalletFormView Dvn;
  private WalletFormView Dvo;
  private WalletFormView Dvp;
  private WalletFormView Dvq;
  private WalletFormView Dvr;
  private WalletFormView Dvs;
  private WalletFormView Dvt;
  private WalletPhoneInputView Dvu;
  private WalletFormView Dvv;
  private WalletFormView Dvw;
  private Map<String, d.a> Dvx;
  private boolean Dvy;
  private CheckBox Dvz;
  private String Dwa;
  private boolean Dwb;
  private int Dwc;
  private int Dwd;
  private int Dwe;
  private View.OnClickListener Dwf;
  private String cityCode;
  private String countryCode;
  private int eQV;
  private Button fSn;
  private ScrollView fSp;
  private PayInfo mPayInfo;
  private Profession[] mProfessions;
  private String mSelectBankName;
  private int mSelectCreCountIndex;
  private String mTrueName;
  private String provinceCode;
  private String vte;
  private String vtf;
  private Orders yvS;
  
  public WalletCardElementUI()
  {
    AppMethodBeat.i(70798);
    this.Dvv = null;
    this.Dif = new ElementQuery();
    this.CZU = new Authen();
    this.yvS = null;
    this.mPayInfo = null;
    this.Dug = null;
    this.Dvx = null;
    this.Dbe = null;
    this.Dvy = false;
    this.Dej = 1;
    this.DvE = false;
    this.DvF = false;
    this.DvG = false;
    this.DvH = false;
    this.DvI = false;
    this.DvJ = false;
    this.DvK = false;
    this.DvL = null;
    this.DvO = new ArrayList();
    this.Dji = new ArrayList();
    this.Dwf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174518);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.report.service.g.yxI.f(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
        com.tencent.mm.wallet_core.ui.f.d(WalletCardElementUI.this, t.eJf().getTrueName());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174518);
      }
    };
    this.DdN = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(70798);
  }
  
  private void Wl(int paramInt)
  {
    AppMethodBeat.i(70817);
    if (paramInt == 1)
    {
      setEditFocusListener(this.Def, 1, false, false, false);
      AppMethodBeat.o(70817);
      return;
    }
    setEditFocusListener(this.Def, 1, true, false, false);
    AppMethodBeat.o(70817);
  }
  
  private void a(WalletFormView paramWalletFormView, int paramInt)
  {
    AppMethodBeat.i(70816);
    paramWalletFormView = paramWalletFormView.getLogicDelegate();
    if ((paramWalletFormView instanceof a.a))
    {
      ((a.a)paramWalletFormView).ahb(paramInt);
      Wl(paramInt);
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
        paramArrayOfWalletFormView[i].dHv();
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
  
  private void aGn(String paramString)
  {
    AppMethodBeat.i(70811);
    Object localObject = t.eJn().DgL;
    this.DvO.clear();
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
        } while (!localElementQuery.uVs.equals(paramString));
        ae.i("MicroMsg.WalletCardElmentUI", "add element: %s, %s", new Object[] { localElementQuery.uVs, localElementQuery.dlT });
        this.DvO.add(localElementQuery);
        if ((getInput().getInt("key_bind_scene", -1) == 5) && (!localElementQuery.Dop)) {
          localElementQuery.DnZ = getString(2131765969);
        }
      } while (this.DvO.size() < 2);
    }
    AppMethodBeat.o(70811);
  }
  
  private boolean aVv()
  {
    AppMethodBeat.i(70812);
    WalletFormView localWalletFormView = this.Dvv;
    this.Dvv = null;
    if (!this.DuY.ht(null))
    {
      if ((this.Dvv == null) && (localWalletFormView != this.DuY)) {
        this.Dvv = this.DuY;
      }
      this.DuS.setText(2131765091);
      this.DuS.setTextColor(getResources().getColor(2131100798));
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (!this.Due.ht(null))
      {
        if ((this.Dvv == null) && (localWalletFormView != this.Due)) {
          this.Dvv = this.Due;
        }
        bool1 = false;
      }
      if (!this.Dvw.ht(this.DuQ))
      {
        if ((this.Dvv == null) && (localWalletFormView != this.Dvw)) {
          this.Dvv = this.Dvw;
        }
        bool1 = false;
      }
      int i;
      if ((!this.Def.ht(this.Deh)) && (!this.Dvy))
      {
        if ((this.Dvv == null) && (localWalletFormView != this.Def)) {
          this.Dvv = this.Def;
        }
        this.Deh.setText(2131765132);
        this.Deh.setTextColor(getResources().getColor(2131100798));
        i = 1;
      }
      for (boolean bool2 = false;; bool2 = bool1)
      {
        bool1 = bool2;
        if (this.DvE)
        {
          bool1 = bool2;
          if (!this.Dvi.ht(null))
          {
            if ((this.Dvv == null) && (localWalletFormView != this.Dvi)) {
              this.Dvv = this.Dvi;
            }
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (this.DvF)
        {
          bool2 = bool1;
          if (!this.Dvk.ht(null))
          {
            if ((this.Dvv == null) && (localWalletFormView != this.Dvk)) {
              this.Dvv = this.Dvk;
            }
            bool2 = false;
          }
        }
        if (!this.Dvd.ht(this.Deh)) {
          if (i != 0)
          {
            this.Deh.setText(2131765125);
            this.Deh.setTextColor(getResources().getColor(2131100798));
            if ((this.Dvv == null) && (localWalletFormView != this.Dvd)) {
              this.Dvv = this.Dvd;
            }
            bool1 = false;
            label401:
            if (this.Deh.getVisibility() == 4)
            {
              if (!this.Dif.DnL) {
                break label1165;
              }
              this.Deh.setText(getString(2131765133));
              label436:
              this.Deh.setTextColor(getResources().getColor(2131100490));
              this.Deh.setVisibility(0);
            }
            if (this.Dva.ht(this.DuU)) {
              break label1220;
            }
            if ((this.Dvv == null) && (localWalletFormView != this.Dva)) {
              this.Dvv = this.Dva;
            }
            i = 1;
            bool1 = false;
          }
        }
        for (;;)
        {
          if (!this.DuZ.ht(this.DuU))
          {
            if ((this.Dvv == null) && (localWalletFormView != this.DuZ)) {
              this.Dvv = this.DuZ;
            }
            bool2 = false;
            label543:
            if (!this.Dvz.isChecked()) {
              bool2 = false;
            }
            if (!this.Dvn.ht(this.DuV))
            {
              if ((this.Dvv == null) && (localWalletFormView != this.Dvn)) {
                this.Dvv = this.Dvn;
              }
              bool2 = false;
            }
            if (!this.Dvo.ht(this.DuV))
            {
              if ((this.Dvv == null) && (localWalletFormView != this.Dvo)) {
                this.Dvv = this.Dvo;
              }
              bool2 = false;
            }
            if (!this.Dvp.ht(this.DuV))
            {
              if ((this.Dvv == null) && (localWalletFormView != this.Dvp)) {
                this.Dvv = this.Dvp;
              }
              bool2 = false;
            }
            if (!this.Dvq.ht(this.DuV))
            {
              if ((this.Dvv == null) && (localWalletFormView != this.Dvq)) {
                this.Dvv = this.Dvq;
              }
              bool2 = false;
            }
            if (!this.Dvr.ht(this.DuV))
            {
              if ((this.Dvv == null) && (localWalletFormView != this.Dvr)) {
                this.Dvv = this.Dvr;
              }
              bool2 = false;
            }
            if (!this.Dvs.ht(this.DuV))
            {
              if ((this.Dvv == null) && (localWalletFormView != this.Dvs)) {
                this.Dvv = this.Dvs;
              }
              bool2 = false;
            }
            if (!this.Dvt.ht(this.DuV))
            {
              if ((this.Dvv == null) && (localWalletFormView != this.Dvt)) {
                this.Dvv = this.Dvt;
              }
              bool2 = false;
            }
            bool1 = bool2;
            if (this.DvD)
            {
              bool1 = bool2;
              if (!this.Dve.ht(null))
              {
                if ((this.Dvv == null) && (localWalletFormView != this.Dve)) {
                  this.Dvv = this.Dve;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.DvC)
            {
              bool2 = bool1;
              if (!this.Dvf.ht(null))
              {
                if ((this.Dvv == null) && (localWalletFormView != this.Dvf)) {
                  this.Dvv = this.Dvf;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.DvC)
            {
              bool1 = bool2;
              if (!this.Dvg.ht(null))
              {
                if ((this.Dvv == null) && (localWalletFormView != this.Dvg)) {
                  this.Dvv = this.Dvg;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.Dwb)
            {
              bool2 = bool1;
              if (!this.Dvh.ht(null))
              {
                if ((this.Dvv == null) && (localWalletFormView != this.Dvh)) {
                  this.Dvv = this.Dvh;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.DvH)
            {
              bool1 = bool2;
              if (!this.Dvl.ht(null))
              {
                if ((this.Dvv == null) && (localWalletFormView != this.Dvl)) {
                  this.Dvv = this.Dvl;
                }
                bool1 = false;
              }
            }
            if (!bool1) {
              break label1201;
            }
            this.fSn.setEnabled(true);
            this.fSn.setClickable(true);
            if (localWalletFormView != null) {
              localWalletFormView.setImeOptions(1073741824);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(70812);
            return bool1;
            this.Deh.setText(2131765126);
            this.Deh.setTextColor(getResources().getColor(2131100798));
            break;
            bool1 = bool2;
            if (i == 0) {
              break label401;
            }
            this.Deh.setVisibility(0);
            bool1 = bool2;
            break label401;
            label1165:
            this.Deh.setText(getString(2131765136));
            break label436;
            bool2 = bool1;
            if (i == 0) {
              break label543;
            }
            this.DuU.setVisibility(4);
            bool2 = bool1;
            break label543;
            label1201:
            this.fSn.setEnabled(false);
            this.fSn.setClickable(false);
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
    if (!bu.isNullOrNil(paramString))
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
  
  private void eLa()
  {
    AppMethodBeat.i(70801);
    Object localObject;
    if (eLf()) {
      localObject = getInput().getString("realname_verify_process_get_wording_cache");
    }
    try
    {
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = (bht)new bht().parseFrom(((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.Dji.addAll(((bht)localObject).GWf);
      }
      localObject = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      if (localObject != null)
      {
        this.mTrueName = ((RealNameBundle)localObject).DkG;
        this.Dwa = ((RealNameBundle)localObject).Dlc;
        this.eQV = ((RealNameBundle)localObject).eQV;
        if ((this.Dif != null) && (this.Dif.eIP() != null) && (this.Dif.eIP().contains(Integer.valueOf(((RealNameBundle)localObject).DkJ))))
        {
          ae.i("MicroMsg.WalletCardElmentUI", "set cretype: %s", new Object[] { Integer.valueOf(((RealNameBundle)localObject).DkJ), this.Dif.eIP() });
          this.Dej = ((RealNameBundle)localObject).DkJ;
          this.Dvc.setText(((RealNameBundle)localObject).DkK);
          this.Def.setText(((RealNameBundle)localObject).DkH);
          a(this.Def, this.Dej);
          if (((RealNameBundle)localObject).DkS != 9999) {
            break label606;
          }
          this.Dvk.setText(getString(2131766450));
          this.DvQ = 9999;
          this.DvR = 12;
          this.DvS = 31;
          this.Dvj.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(((RealNameBundle)localObject).Dle), Integer.valueOf(((RealNameBundle)localObject).Dlf), Integer.valueOf(((RealNameBundle)localObject).Dlg) }));
          this.mSelectCreCountIndex = ((RealNameBundle)localObject).DkQ;
          this.Dvi.setText(this.Djk[this.mSelectCreCountIndex]);
        }
        this.Due.setText(((RealNameBundle)localObject).DkG);
        this.countryCode = ((RealNameBundle)localObject).DkM;
        this.provinceCode = ((RealNameBundle)localObject).DkN;
        this.cityCode = ((RealNameBundle)localObject).DkO;
        this.Dvf.setText(((RealNameBundle)localObject).DkP);
        this.Dvg.setText(((RealNameBundle)localObject).Dlc);
        this.DvM = ((RealNameBundle)localObject).DkZ;
        this.Dvm.setText(((RealNameBundle)localObject).Dla);
        this.Dig = ((RealNameBundle)localObject).DkL;
        if (this.Dig != null) {
          this.Dve.setText(this.Dig.DkE);
        }
        this.Dwc = (((RealNameBundle)localObject).eQV - 1);
        if (this.Dwc < 0) {
          this.Dwc = 0;
        }
        WalletFormView localWalletFormView = this.Dvh;
        if (((RealNameBundle)localObject).eQV != 1) {
          break label656;
        }
        i = 2131763533;
        localWalletFormView.setText(getString(i));
        this.DvW = ((RealNameBundle)localObject).DkW;
        this.DvX = ((RealNameBundle)localObject).DkX;
        this.DvY = ((RealNameBundle)localObject).DkY;
        if ((this.DvW > 0) && (this.DvX > 0) && (this.DvY > 0)) {
          this.Dvl.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.DvW), Integer.valueOf(this.DvX), Integer.valueOf(this.DvY) }));
        }
      }
      AppMethodBeat.o(70801);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WalletCardElmentUI", localIOException, "", new Object[0]);
        continue;
        label606:
        this.Dvk.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(localIOException.DkS), Integer.valueOf(localIOException.DkT), Integer.valueOf(localIOException.DkU) }));
        continue;
        label656:
        int i = 2131763532;
      }
    }
  }
  
  private void eLb()
  {
    AppMethodBeat.i(70802);
    Object localObject1;
    Object localObject2;
    if (this.Dif.Don == 0)
    {
      this.Dvu.eMn();
      localObject1 = t.eJn().DrU;
      if (localObject1 == null) {
        break label172;
      }
      localObject2 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.wallet_core.id_verify.model.a)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).dlT.equals(this.Dif.dlT))
          {
            label77:
            localObject2 = this.Dvu;
            if (localObject1 != null)
            {
              if (bu.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).Dki)) {
                break label177;
              }
              ((WalletPhoneInputView)localObject2).DEc.setHint(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).Dki);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!bu.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).Dkj)) {
        ((WalletPhoneInputView)localObject2).DEj = ((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).Dkj;
      }
      AppMethodBeat.o(70802);
      return;
      this.Dvu.eMo();
      localObject1 = (EditText)this.Dvu.findViewById(2131303383);
      setEditFocusListener(this.Dvu.getPhoneNumberEt(), (EditText)localObject1, 0, false, false, true);
      break;
      label172:
      localObject1 = null;
      break label77;
      label177:
      ((WalletPhoneInputView)localObject2).DEc.setHint(((WalletPhoneInputView)localObject2).getContext().getString(2131765144));
    }
  }
  
  private void eLc()
  {
    AppMethodBeat.i(70808);
    Object localObject1;
    boolean bool;
    if (aVv())
    {
      com.tencent.mm.plugin.wallet_core.utils.f.eMB();
      if (!bu.isNullOrNil(this.Dif.DnX))
      {
        localObject1 = getInput();
        if ((this.DvA.getVisibility() == 0) && (this.DvA.isChecked()))
        {
          bool = true;
          ((Bundle)localObject1).putBoolean("key_is_follow_bank_username", bool);
          getInput().putString("key_bank_username", this.Dif.DnX);
        }
      }
      else
      {
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if ((this.Dif != null) && (localObject1 != null) && (this.Dbe != null) && (this.Dvx != null))
        {
          if (!this.Dvx.containsKey(this.Dif.dlT)) {
            break label1487;
          }
          ((FavorPayInfo)localObject1).Doq = ((d.a)this.Dvx.get(this.Dif.dlT)).DtF.CYV;
          label168:
          getInput().putParcelable("key_favor_pay_info", (Parcelable)localObject1);
        }
        this.CZU = new Authen();
        if (this.Dug != null)
        {
          this.CZU.wRt = this.Dug.Dmh;
          this.CZU.ufC = this.Dug.field_bankcardTail;
        }
        localObject1 = getInput().getString("key_card_id");
        if (this.Dvw.getVisibility() != 0) {
          break label1555;
        }
        localObject1 = this.Dvw.getText();
      }
    }
    label524:
    label1555:
    for (;;)
    {
      this.CZU.xDC = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.CZU.Dly = ((String)localObject1);
      this.CZU.dlT = this.Dif.dlT;
      this.CZU.Dlx = this.Dej;
      this.CZU.Dlv = getInput().getString("key_pwd1");
      if (!bu.isNullOrNil(this.Dva.getText())) {
        this.CZU.Dlz = this.Dva.getText();
      }
      this.CZU.DgJ = this.Dvd.getText();
      this.CZU.DlC = this.Dvn.getText();
      this.CZU.DlD = this.Dvo.getText();
      this.CZU.country = this.DvB;
      this.CZU.eRf = this.vte;
      this.CZU.eRg = this.vtf;
      this.CZU.hZQ = this.Dvq.getText();
      this.CZU.uVu = this.Dvr.getText();
      this.CZU.juG = this.Dvs.getText();
      this.CZU.eQY = this.Dvt.getText();
      String str = com.tencent.mm.wallet_core.ui.f.bal(this.CZU.DgJ);
      getInput().putString("key_mobile", str);
      localObject1 = getInput();
      label736:
      Object localObject2;
      if (this.Dif.DgN == 2)
      {
        bool = true;
        ((Bundle)localObject1).putBoolean("key_is_oversea", bool);
        this.CZU.Dlw = this.Def.getText();
        this.CZU.DkG = this.Due.getText();
        this.CZU.DlA = this.DuZ.getText();
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if (localObject1 != null)
        {
          this.CZU.DlE = ((FavorPayInfo)localObject1).Dot;
          this.CZU.DlF = ((FavorPayInfo)localObject1).Doq;
        }
        this.CZU.DlK = ("+" + this.Dvu.getCountryCode());
        this.CZU.DkQ = this.mSelectCreCountIndex;
        if (this.DvQ != 9999) {
          break label1511;
        }
        ae.i("MicroMsg.WalletCardElmentUI", "is long term");
        localObject1 = new TenpaySecureEncrypt();
        this.CZU.DkR = ((TenpaySecureEncrypt)localObject1).desedeEncode(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.DvQ), Integer.valueOf(this.DvR), Integer.valueOf(this.DvS) }), com.tencent.mm.wallet_core.ui.f.fWx());
        ae.d("MicroMsg.WalletCardElmentUI", "expire date: %s", new Object[] { this.Dvk.getText() });
        this.CZU.DkV = this.Dvl.getText();
        ae.d("MicroMsg.WalletCardElmentUI", "birth date: %s", new Object[] { this.Dvl.getText() });
        localObject2 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new RealNameBundle();
        }
        ((RealNameBundle)localObject1).DkG = this.Due.getText();
        ((RealNameBundle)localObject1).eQV = (this.Dwc + 1);
        ((RealNameBundle)localObject1).DkM = this.countryCode;
        ((RealNameBundle)localObject1).DkN = this.provinceCode;
        ((RealNameBundle)localObject1).DkO = this.cityCode;
        ((RealNameBundle)localObject1).Dlc = this.Dvg.getText();
        ((RealNameBundle)localObject1).DkL = this.Dig;
        ((RealNameBundle)localObject1).DkZ = this.DvM;
        ((RealNameBundle)localObject1).DkV = this.Dvl.getText();
        ((RealNameBundle)localObject1).DkJ = this.Dej;
        ((RealNameBundle)localObject1).DkK = this.Dvc.getText();
        ((RealNameBundle)localObject1).DkH = "";
        ((RealNameBundle)localObject1).DkI = this.Def.getText();
        ((RealNameBundle)localObject1).Dld = this.Dvj.getText();
        ((RealNameBundle)localObject1).DkR = this.Dvk.getText();
        ((RealNameBundle)localObject1).DkQ = this.mSelectCreCountIndex;
        getInput().putParcelable("realname_verify_process_bundle", (Parcelable)localObject1);
        ae.d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", new Object[] { Integer.valueOf(this.CZU.DkQ), this.CZU.DkR, this.CZU.DkV });
        if ((eLe()) && (!bu.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!bu.isNullOrNil(getInput().getString("key_true_name"))))
        {
          ae.i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
          this.CZU.Dlw = getInput().getString("key_identity");
          this.CZU.Dlx = getInput().getInt("key_id_type", -1);
          this.CZU.DkG = this.mTrueName;
          ae.i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.CZU.DkG);
        }
        ae.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.CZU.xDC + " elemt.bankcardTag : " + this.Dif.DgN);
        ae.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.Dif.DgN);
        localObject2 = getInput();
        ((Bundle)localObject2).putString("key_mobile", str);
        ((Bundle)localObject2).putParcelable("key_authen", this.CZU);
        ((Bundle)localObject2).putString("key_bank_phone", this.Dif.DnW);
        ((Bundle)localObject2).putString("key_country_code", this.countryCode);
        ((Bundle)localObject2).putString("key_province_code", this.provinceCode);
        ((Bundle)localObject2).putString("key_city_code", this.cityCode);
        ((Bundle)localObject2).putParcelable("key_profession", this.Dig);
        ((Bundle)localObject2).putString("key_country_iso", this.DvM);
        ((Bundle)localObject2).putString("key_bind_card_type", this.CZU.dlT);
        ((Bundle)localObject2).putString("key_bind_card_show1", this.Dif.uVs);
        if (2 != this.Dif.DnT) {
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
        if (!bu.isNullOrNil((String)localObject1))
        {
          this.CZU.DlL = 1;
          this.CZU.DgT = ((String)localObject1);
        }
        this.CZU.DlM = ((Bundle)localObject2).getString("kreq_token");
        if (!getNetController().r(new Object[] { this.CZU, this.yvS })) {
          break label1539;
        }
        ae.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
        AppMethodBeat.o(70808);
        return;
        bool = false;
        break;
        ((FavorPayInfo)localObject1).Doq = this.Dbe.cn(((FavorPayInfo)localObject1).Doq, false);
        break label168;
        bool = false;
        break label524;
        this.CZU.DkR = this.Dvk.getText();
        break label736;
      }
      ae.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70808);
      return;
    }
  }
  
  private void eLd()
  {
    AppMethodBeat.i(70818);
    Object localObject;
    if ((this.Dif != null) && (this.Dvx != null) && (this.Dvx.containsKey(this.Dif.dlT)))
    {
      localObject = (d.a)this.Dvx.get(this.Dif.dlT);
      if ((localObject == null) || (((d.a)localObject).DtF == null)) {
        break label133;
      }
    }
    label133:
    for (double d = ((d.a)localObject).DtG;; d = 0.0D)
    {
      localObject = getString(2131765090, new Object[] { com.tencent.mm.wallet_core.ui.f.D(d) });
      this.DuW.setText((CharSequence)localObject);
      this.DuW.setVisibility(0);
      AppMethodBeat.o(70818);
      return;
      this.DuW.setVisibility(8);
      AppMethodBeat.o(70818);
      return;
    }
  }
  
  private boolean eLe()
  {
    AppMethodBeat.i(70819);
    boolean bool = getInput().getBoolean("key_is_forgot_process", false);
    AppMethodBeat.o(70819);
    return bool;
  }
  
  private boolean eLf()
  {
    AppMethodBeat.i(174523);
    com.tencent.mm.wallet_core.d locald = getProcess();
    if ((locald != null) && ("realname_verify_process".equals(locald.cSH())))
    {
      if (locald.dyY.getInt("real_name_verify_mode", 0) == 4)
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
  
  private void hr(boolean paramBoolean)
  {
    AppMethodBeat.i(70803);
    if (this.Dif == null) {
      this.Dif = new ElementQuery();
    }
    ae.i("MicroMsg.WalletCardElmentUI", "element: %s, %s", new Object[] { this.Dif.uVs, this.Dif.dlT });
    eLb();
    eLd();
    com.tencent.mm.wallet_core.a.bs(this);
    Object localObject1 = (Bankcard)getInput().getParcelable("key_bankcard");
    Object localObject2;
    Object localObject3;
    if ((eLe()) && (localObject1 != null))
    {
      this.Dvw.setHint(getString(2131765130, new Object[] { ((Bankcard)localObject1).field_bankcardTail }));
      localObject1 = this.Dvw;
      localObject2 = this.DuP;
      localObject3 = this.DuQ;
      a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
      localObject1 = this.DuY;
      localObject2 = this.DuR;
      localObject3 = this.DuS;
      a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
    }
    for (;;)
    {
      if (paramBoolean) {
        eLa();
      }
      this.DvE = false;
      this.DvF = false;
      this.DvH = false;
      this.DvI = false;
      if (!eLf()) {
        break;
      }
      localObject1 = this.Dji.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (crv)((Iterator)localObject1).next();
        if (((crv)localObject2).HCV.key == this.Dej)
        {
          this.DvE = ((crv)localObject2).HCZ;
          this.DvF = ((crv)localObject2).HCY;
          this.DvG = ((crv)localObject2).HDc;
          this.DvH = ((crv)localObject2).HDa;
          this.Dwb = ((crv)localObject2).HDe;
          this.DvD = ((crv)localObject2).HCW;
          this.DvC = ((crv)localObject2).HCX;
          this.DvJ = ((crv)localObject2).HDb;
          this.DvI = true;
        }
      }
      if (!bu.isNullOrNil(this.Dif.uVs))
      {
        this.DuY.setText(this.Dif.uVs);
        if (!this.Dif.eIA()) {
          break label561;
        }
        this.DvN.setVisibility(0);
        this.DvN.setText(getString(2131765221));
      }
      for (;;)
      {
        localObject1 = this.Dvw;
        localObject2 = this.DuP;
        localObject3 = this.DuQ;
        a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        localObject1 = this.DuY;
        localObject2 = this.DuR;
        localObject3 = this.DuS;
        a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        this.Dvw.setOnInfoIvClickListener(this.Dwf);
        if (!t.eJf().eJP().eJw()) {
          break label596;
        }
        this.Dvw.getInfoIv().setImageResource(2131691405);
        this.Dvw.getInfoIv().setVisibility(0);
        break;
        label561:
        if (this.Dif.eIO())
        {
          this.DvN.setVisibility(0);
          this.DvN.setText(getString(2131765241));
        }
      }
      label596:
      this.Dvw.getInfoIv().setVisibility(4);
    }
    Object localObject4;
    WalletFormView localWalletFormView1;
    WalletFormView localWalletFormView2;
    TextView localTextView1;
    TextView localTextView2;
    boolean bool1;
    boolean bool2;
    if ((this.Dif.Doo != null) && (!this.Dif.Doo.isEmpty()))
    {
      ae.i("MicroMsg.WalletCardElmentUI", "identity type： %s", new Object[] { Integer.valueOf(this.Dej) });
      localObject1 = this.Dif.Doo.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CreTypeRuleInfo)((Iterator)localObject1).next();
        if (((CreTypeRuleInfo)localObject2).Dns == this.Dej)
        {
          if (((CreTypeRuleInfo)localObject2).Dnt.Dno == 1)
          {
            ae.i("MicroMsg.WalletCardElmentUI", "need show cre count");
            this.DvE = true;
          }
          if (((CreTypeRuleInfo)localObject2).Dnt.Dnq == 1)
          {
            ae.i("MicroMsg.WalletCardElmentUI", "need show cre expire");
            this.DvF = true;
          }
          if (((CreTypeRuleInfo)localObject2).Dnt.Dnp == 1)
          {
            ae.i("MicroMsg.WalletCardElmentUI", "need show birthday");
            this.DvH = true;
          }
          if (((CreTypeRuleInfo)localObject2).Dnt.Dnr == 1)
          {
            ae.i("MicroMsg.WalletCardElmentUI", "need show cre type");
            if (t.eJf().eJR() > 0)
            {
              ae.i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
              this.DvI = true;
            }
          }
        }
      }
      if ((this.Dej == 2) && (this.DvK))
      {
        this.DvJ = true;
        if (!this.DvF)
        {
          this.DvQ = 0;
          this.DvR = 0;
          this.DvS = 0;
        }
        if (!this.DvH)
        {
          this.DvW = 0;
          this.DvX = 0;
          this.DvY = 0;
        }
        if (!this.DvE) {
          this.mSelectCreCountIndex = 0;
        }
        this.Dvb.setVisibility(8);
        if (!Bankcard.We(this.Dif.DgN)) {
          break label1497;
        }
        localObject1 = this.Due;
        localObject2 = this.Dvc;
        localObject3 = this.Def;
        localObject4 = this.Dvi;
        localWalletFormView1 = this.Dvj;
        localWalletFormView2 = this.Dvk;
        localTextView1 = this.Deg;
        localTextView2 = this.Deh;
        a(new boolean[] { 0, 0, 0, 0, 0, 0 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.Dvd.setVisibility(8);
        ux(true);
        paramBoolean = this.DvH;
        bool1 = this.DvJ;
        bool2 = this.Dwb;
        localObject1 = this.Dvf;
        localObject2 = this.Dvg;
        localObject3 = this.Dve;
        localObject4 = this.Dvl;
        localWalletFormView1 = this.Dvm;
        localWalletFormView2 = this.Dvh;
        localTextView1 = this.DuX;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        paramBoolean = this.Dif.DnN;
        bool1 = this.Dif.DnO;
        localObject1 = this.Dva;
        localObject2 = this.DuZ;
        localObject3 = this.DuT;
        localObject4 = this.DuU;
        a(new boolean[] { paramBoolean, bool1 }, new WalletFormView[] { localObject1, localObject2 }, (TextView)localObject3, (TextView)localObject4);
        if (this.DuY.getVisibility() != 0) {
          break label2960;
        }
        switch (this.Dif.DnS)
        {
        default: 
          this.DuS.setVisibility(8);
          label1325:
          this.DuS.setTextColor(getResources().getColor(2131100707));
        }
      }
    }
    for (;;)
    {
      if ((!bu.isNullOrNil(this.Dif.Dom)) && (this.DuS.getVisibility() != 0))
      {
        ae.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
        this.DuS.setText(this.Dif.Dom);
        this.DuS.setVisibility(0);
      }
      if ((bu.isNullOrNil(this.Dif.DnX)) || (!com.tencent.mm.model.x.An(this.Dif.DnX)) || (eLe())) {
        break label2972;
      }
      this.DvA.setText(this.Dif.DnY);
      this.DvA.setVisibility(0);
      AppMethodBeat.o(70803);
      return;
      this.DvJ = false;
      break;
      if ((this.Dej == 2) && (this.DvK))
      {
        this.DvJ = true;
        break;
      }
      this.DvJ = false;
      break;
      label1497:
      int i;
      if ((this.Dif.eIP() != null) && (this.Dif.eIP().size() > 0))
      {
        i = 1;
        label1524:
        if ((!eLe()) && (!t.eJf().eJJ())) {
          break label2440;
        }
        localObject2 = t.eJf().getTrueName();
        localObject1 = localObject2;
        if (bu.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          if (getProcess() != null) {
            localObject1 = getProcess().dyY.getString("key_true_name");
          }
        }
        if (bu.isNullOrNil((String)localObject1)) {
          break label2252;
        }
        localObject1 = getString(2131765180, new Object[] { com.tencent.mm.wallet_core.ui.f.bak((String)localObject1) });
        this.Due.setHint((CharSequence)localObject1);
        this.Dvb.setHint((CharSequence)localObject1);
        label1633:
        if ((!eLe()) || (bu.isNullOrNil(getInput().getString("key_identity"))) || (getInput().getInt("key_id_type", -1) == -1) || (bu.isNullOrNil(getInput().getString("key_true_name")))) {
          break label2282;
        }
        ae.i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
        paramBoolean = this.DvE;
        bool1 = this.DvG;
        bool2 = this.DvF;
        localObject1 = this.Due;
        localObject2 = this.Dvc;
        localObject3 = this.Def;
        localObject4 = this.Dvi;
        localWalletFormView1 = this.Dvj;
        localWalletFormView2 = this.Dvk;
        localTextView1 = this.Deg;
        localTextView2 = this.Deh;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.mTrueName = getInput().getString("key_true_name");
        ae.i("MicroMsg.WalletCardElmentUI", "name is " + this.mTrueName);
        this.Dvd.setVisibility(0);
        if (this.Dug != null)
        {
          if (!bu.isNullOrNil(this.Dug.field_mobile)) {
            d(this.Dvd, this.Dug.field_mobile);
          }
          if (!bu.isNullOrNil(this.Dug.Dlz)) {
            d(this.Dva, this.Dug.Dlz);
          }
          if (!bu.isNullOrNil(this.Dug.Dmg)) {
            d(this.DuZ, this.Dug.Dmg);
          }
        }
        if (!this.Dif.DnL) {
          break label2681;
        }
        this.Deh.setText("");
      }
      for (;;)
      {
        if (!bu.isNullOrNil(this.Dif.DnP)) {
          this.Def.setText(this.Dif.DnP);
        }
        if (t.eJf().eJR() <= 0) {
          break label2698;
        }
        ae.i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", new Object[] { Integer.valueOf(t.eJf().eJR()) });
        this.Dvc.setClickable(false);
        this.Dvc.setText(t.eJn().gQ(this));
        this.Dvc.setInputEnable(false);
        a(this.Def, this.Dej);
        ux(false);
        paramBoolean = this.Dwb;
        bool1 = this.DvC;
        bool2 = this.DvC;
        boolean bool3 = this.DvD;
        boolean bool4 = this.DvH;
        boolean bool5 = this.DvJ;
        localObject1 = this.Dvh;
        localObject2 = this.Dvf;
        localObject3 = this.Dvg;
        localObject4 = this.Dve;
        localWalletFormView1 = this.Dvl;
        localWalletFormView2 = this.Dvm;
        localTextView1 = this.DuX;
        a(new boolean[] { paramBoolean, bool1, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        break;
        i = 0;
        break label1524;
        label2252:
        localObject1 = getString(2131765179);
        this.Due.setHint((CharSequence)localObject1);
        this.Dvb.setHint((CharSequence)localObject1);
        break label1633;
        label2282:
        if ((this.DvI) || (i != 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool1 = this.DvE;
          bool2 = this.DvG;
          bool3 = this.DvF;
          localObject1 = this.Due;
          localObject2 = this.Dvc;
          localObject3 = this.Def;
          localObject4 = this.Dvi;
          localWalletFormView1 = this.Dvj;
          localWalletFormView2 = this.Dvk;
          localTextView1 = this.Deg;
          localTextView2 = this.Deh;
          a(new boolean[] { true, paramBoolean, true, bool1, bool2, bool3 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          break;
        }
        label2440:
        bool1 = this.Dif.DnL;
        if ((this.DvI) || ((i != 0) && (this.Dif.DnM))) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool2 = this.Dif.DnM;
          bool3 = this.DvE;
          bool4 = this.DvG;
          bool5 = this.DvF;
          localObject1 = this.Due;
          localObject2 = this.Dvc;
          localObject3 = this.Def;
          localObject4 = this.Dvi;
          localWalletFormView1 = this.Dvj;
          localWalletFormView2 = this.Dvk;
          localTextView1 = this.Deg;
          localTextView2 = this.Deh;
          a(new boolean[] { bool1, paramBoolean, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          this.Dvd.setVisibility(0);
          ae.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.Dif.DnL + " canModifyIdentity:" + this.Dif.DnM);
          break;
        }
        label2681:
        this.Deh.setText(getString(2131765136));
      }
      label2698:
      if (this.Dif.eIP() != null)
      {
        i = this.Dif.eIP().size();
        label2721:
        ae.i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", new Object[] { Integer.valueOf(i) });
        if (i > 1) {
          break label2876;
        }
        this.Dvc.setClickable(false);
        this.Dvc.setInputEnable(false);
        this.Def.setInputEnable(true);
      }
      for (;;)
      {
        localObject1 = this.Dif.eIP();
        if ((localObject1 == null) || (!((List)localObject1).contains(Integer.valueOf(this.Dej)))) {
          this.Dej = 1;
        }
        if (!t.eJn().am(this, this.Dej).equals(this.DvZ)) {
          com.tencent.mm.plugin.report.service.g.yxI.f(16816, new Object[] { Integer.valueOf(this.Dej) });
        }
        this.Dvc.setText(t.eJn().am(this, this.Dej));
        break;
        i = 0;
        break label2721;
        label2876:
        this.Dvc.setClickable(true);
        this.Dvc.setInputEnable(true);
        this.Def.setInputEnable(true);
      }
      this.DuS.setText(2131765096);
      this.DuS.setVisibility(0);
      break label1325;
      this.DuS.setVisibility(8);
      break label1325;
      this.DuS.setVisibility(8);
      break label1325;
      this.DuS.setVisibility(8);
      break label1325;
      label2960:
      this.DuS.setVisibility(8);
    }
    label2972:
    this.DvA.setVisibility(8);
    AppMethodBeat.o(70803);
  }
  
  private void ux(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(70805);
    if (paramBoolean)
    {
      Object localObject = this.AyU;
      if (this.Dif.Doa)
      {
        i = 0;
        ((TextView)localObject).setVisibility(i);
        localObject = this.Dvn;
        if (!this.Dif.Doa) {
          break label225;
        }
        i = 0;
        label54:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.Dvo;
        if (!this.Dif.Dob) {
          break label231;
        }
        i = 0;
        label78:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.Dvp;
        if (!this.Dif.Doc) {
          break label237;
        }
        i = 0;
        label102:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.Dvq;
        if (!this.Dif.Dof) {
          break label243;
        }
        i = 0;
        label126:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.Dvr;
        if (!this.Dif.Doh) {
          break label249;
        }
        i = 0;
        label150:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.Dvs;
        if (!this.Dif.Dog) {
          break label255;
        }
        i = 0;
        label174:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.Dvt;
        if (!this.Dif.Doi) {
          break label261;
        }
      }
      label261:
      for (int i = j;; i = 8)
      {
        ((WalletFormView)localObject).setVisibility(i);
        this.DuV.setVisibility(4);
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
    this.AyU.setVisibility(8);
    this.Dvn.setVisibility(8);
    this.Dvo.setVisibility(8);
    this.Dvp.setVisibility(8);
    this.Dvq.setVisibility(8);
    this.Dvr.setVisibility(8);
    this.Dvs.setVisibility(8);
    this.Dvt.setVisibility(8);
    this.DuV.setVisibility(8);
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
    this.DuP = ((TextView)findViewById(2131306710));
    this.Dvw = ((WalletFormView)findViewById(2131306708));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Dvw);
    this.DuQ = ((TextView)findViewById(2131306709));
    this.Deg = ((TextView)findViewById(2131306712));
    this.Due = ((WalletFormView)findViewById(2131302662));
    this.Dvb = ((WalletFormView)findViewById(2131300224));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Due);
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Dvb);
    this.Dvc = ((WalletFormView)findViewById(2131306730));
    this.Def = ((WalletFormView)findViewById(2131300910));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.Def);
    this.Deh = ((TextView)findViewById(2131306711));
    this.DuR = ((TextView)findViewById(2131306701));
    this.DuY = ((WalletFormView)findViewById(2131306713));
    this.DvN = ((WalletFormView)findViewById(2131306717));
    this.DuS = ((TextView)findViewById(2131306702));
    this.DuW = ((TextView)findViewById(2131306706));
    this.DuT = ((TextView)findViewById(2131306704));
    this.Dva = ((WalletFormView)findViewById(2131298914));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.Dva);
    this.DuZ = ((WalletFormView)findViewById(2131298929));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.DuZ);
    this.DuU = ((TextView)findViewById(2131306703));
    this.AyU = ((TextView)findViewById(2131306699));
    this.Dvn = ((WalletFormView)findViewById(2131300112));
    this.Dvo = ((WalletFormView)findViewById(2131301314));
    this.Dvp = ((WalletFormView)findViewById(2131296936));
    this.Dvq = ((WalletFormView)findViewById(2131296479));
    this.Dvr = ((WalletFormView)findViewById(2131303210));
    this.Dvs = ((WalletFormView)findViewById(2131303363));
    this.Dvt = ((WalletFormView)findViewById(2131299329));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.Dvt);
    this.DuV = ((TextView)findViewById(2131306698));
    this.Dvz = ((CheckBox)findViewById(2131296518));
    this.DvA = ((CheckBox)findViewById(2131296515));
    this.fSn = ((Button)findViewById(2131302852));
    this.fSp = ((ScrollView)findViewById(2131306834));
    this.Dve = ((WalletFormView)findViewById(2131303415));
    this.Dvf = ((WalletFormView)findViewById(2131303412));
    this.Dvg = ((WalletFormView)findViewById(2131303411));
    this.Dvh = ((WalletFormView)findViewById(2131303416));
    this.Dvi = ((WalletFormView)findViewById(2131306727));
    this.Dvj = ((WalletFormView)findViewById(2131306728));
    this.Dvk = ((WalletFormView)findViewById(2131306729));
    this.Dvl = ((WalletFormView)findViewById(2131303413));
    this.Dvm = ((WalletFormView)findViewById(2131303414));
    this.DuX = ((TextView)findViewById(2131306715));
    this.Dvu = ((WalletPhoneInputView)findViewById(2131302361));
    this.Dvd = this.Dvu.getPhoneNumberEt();
    this.Due.setOnInputValidChangeListener(this);
    this.Dvb.setOnInputValidChangeListener(this);
    this.Dvw.setOnInputValidChangeListener(this);
    this.Dvc.setOnInputValidChangeListener(this);
    this.Def.setOnInputValidChangeListener(this);
    this.Dvd.setOnInputValidChangeListener(new WalletFormView.a()
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
    this.Dva.setOnInputValidChangeListener(this);
    this.DuZ.setOnInputValidChangeListener(this);
    this.Dvn.setOnInputValidChangeListener(this);
    this.Dvo.setOnInputValidChangeListener(this);
    this.Dvp.setOnInputValidChangeListener(this);
    this.Dvq.setOnInputValidChangeListener(this);
    this.Dvr.setOnInputValidChangeListener(this);
    this.Dvs.setOnInputValidChangeListener(this);
    this.Dvt.setOnInputValidChangeListener(this);
    this.Dve.setOnInputValidChangeListener(this);
    this.Dvf.setOnInputValidChangeListener(this);
    this.Due.setOnEditorActionListener(this);
    this.Dvb.setOnEditorActionListener(this);
    this.Dvw.setOnEditorActionListener(this);
    this.Dvc.setOnEditorActionListener(this);
    this.Def.setOnEditorActionListener(this);
    this.Dvd.setOnEditorActionListener(this);
    this.Dva.setOnEditorActionListener(this);
    this.DuZ.setOnEditorActionListener(this);
    this.Dvn.setOnEditorActionListener(this);
    this.Dvo.setOnEditorActionListener(this);
    this.Dvp.setOnEditorActionListener(this);
    this.Dvq.setOnEditorActionListener(this);
    this.Dvr.setOnEditorActionListener(this);
    this.Dvs.setOnEditorActionListener(this);
    this.Dvt.setOnEditorActionListener(this);
    this.Dvf.setOnEditorActionListener(this);
    this.Dve.setOnEditorActionListener(this);
    this.DuY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70786);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardElementUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putInt("key_bind_scene", WalletCardElementUI.this.getInput().getInt("key_bind_scene", -1));
        bu.isNullOrNil(WalletCardElementUI.c(WalletCardElementUI.this).getText());
        WalletCardElementUI.this.hideTenpayKB();
        localObject = com.tencent.mm.wallet_core.a.bs(WalletCardElementUI.this);
        if (localObject != null) {
          ((com.tencent.mm.wallet_core.d)localObject).a(WalletCardElementUI.this, WalletBankCardSelectUI.class, paramAnonymousView, 1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70786);
      }
    });
    this.DvN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70788);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(WalletCardElementUI.this.getString(2131765241));
        paramAnonymousView.add(WalletCardElementUI.this.getString(2131765221));
        if (WalletCardElementUI.d(WalletCardElementUI.this).size() == 1)
        {
          localObject = (ElementQuery)WalletCardElementUI.d(WalletCardElementUI.this).get(0);
          if (!((ElementQuery)localObject).eIO()) {
            break label178;
          }
          paramAnonymousView.remove(1);
        }
        for (;;)
        {
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.agm(WalletCardElementUI.e(WalletCardElementUI.this));
          paramAnonymousView.Lxq = new c.a()
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
                  if (((i != 0) && (paramAnonymous2Object2.eIO())) || ((i == 0) && (paramAnonymous2Object2.eIA())))
                  {
                    WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymous2Object2);
                    WalletCardElementUI.g(WalletCardElementUI.this);
                  }
                }
                WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymousView.fRg());
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
          if (((ElementQuery)localObject).eIA()) {
            paramAnonymousView.remove(0);
          }
        }
      }
    });
    this.Dvc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70789);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletCardElementUI.h(WalletCardElementUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70789);
      }
    });
    this.Dvi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), WalletCardElementUI.i(WalletCardElementUI.this));
        paramAnonymousView.Lxq = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(70790);
            if (paramAnonymous2Boolean)
            {
              WalletCardElementUI.j(WalletCardElementUI.this).setText((String)paramAnonymous2Object1);
              WalletCardElementUI.b(WalletCardElementUI.this, paramAnonymousView.fRg());
              WalletCardElementUI.b(WalletCardElementUI.this);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(70790);
          }
        };
        paramAnonymousView.agm(WalletCardElementUI.k(WalletCardElementUI.this));
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70791);
      }
    });
    this.Dvj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70793);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
        paramAnonymousView.Lxi = new b.a()
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
        paramAnonymousView.aS(i, j, k);
        localObject = WalletCardElementUI.l(WalletCardElementUI.this).getContentEt().getText().toString();
        if ((WalletCardElementUI.m(WalletCardElementUI.this) > 0) && (WalletCardElementUI.n(WalletCardElementUI.this) > 0) && (WalletCardElementUI.o(WalletCardElementUI.this) > 0)) {
          paramAnonymousView.aQ(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
        }
        for (;;)
        {
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70793);
          return;
          if ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).length() == 8))
          {
            WalletCardElementUI.c(WalletCardElementUI.this, bu.getInt(((String)localObject).substring(0, 4), i));
            WalletCardElementUI.d(WalletCardElementUI.this, bu.getInt(((String)localObject).substring(4, 6), j));
            WalletCardElementUI.e(WalletCardElementUI.this, bu.getInt(((String)localObject).substring(6, 8), k));
            paramAnonymousView.aQ(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
          }
        }
      }
    });
    this.Dvk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70794);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
        paramAnonymousView.Lxi = new b.a()
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
        paramAnonymousView.aR(i, j, k);
        paramAnonymousView.aS(i + 200, 12, 31);
        paramAnonymousView.setLongTermYear(true);
        localObject = WalletCardElementUI.p(WalletCardElementUI.this).getContentEt().getText().toString();
        if ((WalletCardElementUI.q(WalletCardElementUI.this) <= 0) || (WalletCardElementUI.r(WalletCardElementUI.this) <= 0) || (WalletCardElementUI.s(WalletCardElementUI.this) <= 0))
        {
          if ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).length() == 8))
          {
            WalletCardElementUI.f(WalletCardElementUI.this, bu.getInt(((String)localObject).substring(0, 4), i));
            WalletCardElementUI.g(WalletCardElementUI.this, bu.getInt(((String)localObject).substring(4, 6), j));
            WalletCardElementUI.h(WalletCardElementUI.this, bu.getInt(((String)localObject).substring(6, 8), k));
          }
        }
        else
        {
          if (WalletCardElementUI.q(WalletCardElementUI.this) != 9999) {
            break label340;
          }
          paramAnonymousView.aQ(1, 1, 1);
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
          paramAnonymousView.aQ(WalletCardElementUI.q(WalletCardElementUI.this), WalletCardElementUI.r(WalletCardElementUI.this), WalletCardElementUI.s(WalletCardElementUI.this));
        }
      }
    });
    this.Dvh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70795);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = WalletCardElementUI.this.getResources().getStringArray(2130903102);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), paramAnonymousView);
        paramAnonymousView.Lxq = new c.a()
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
              paramAnonymousView.agm(WalletCardElementUI.u(WalletCardElementUI.this));
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
    this.Dvf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70797);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("GetAddress", true);
        paramAnonymousView.putExtra("ShowSelectedLocation", false);
        if (!Bankcard.We(WalletCardElementUI.v(WalletCardElementUI.this).DgN))
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
        com.tencent.mm.br.d.c(WalletCardElementUI.this.getContext(), ".ui.tools.MultiStageCitySelectUI", paramAnonymousView, 4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70797);
      }
    });
    this.Dve.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70774);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent(WalletCardElementUI.this.getContext(), WalletSelectProfessionUI.class);
        paramAnonymousView.putExtra("key_profession_list", WalletCardElementUI.x(WalletCardElementUI.this));
        WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 5);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70774);
      }
    });
    this.Dvl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(174512);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
        paramAnonymousView.Lxi = new b.a()
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
          paramAnonymousView.aQ(WalletCardElementUI.z(WalletCardElementUI.this), WalletCardElementUI.A(WalletCardElementUI.this), WalletCardElementUI.B(WalletCardElementUI.this));
        }
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174512);
      }
    });
    this.Dvm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70776);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.Dvz.setChecked(true);
    this.Dvz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.wallet_core.ui.f.b(WalletCardElementUI.this, WalletCardElementUI.v(WalletCardElementUI.this).dlT, WalletCardElementUI.v(WalletCardElementUI.this).uVs, false, WalletCardElementUI.v(WalletCardElementUI.this).Dol);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70778);
      }
    });
    this.Dvp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174514);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
        if (Bankcard.We(WalletCardElementUI.v(WalletCardElementUI.this).DgN)) {
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
    this.Dvg.setOnInputValidChangeListener(this);
    this.fSn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174515);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletCardElementUI.C(WalletCardElementUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174515);
      }
    });
    setEditFocusListener(this.Dvw, 0, false, false, true);
    setEditFocusListener(this.Def, 1, false, false, true);
    setEditFocusListener(this.Dvd, 0, false, false, true);
    if ((this.Dif != null) && (!bu.isNullOrNil(this.Dif.DnZ)))
    {
      h.a(this, this.Dif.DnZ, null, true, null);
      this.Dif = null;
    }
    for (;;)
    {
      hr(true);
      aVv();
      Object localObject = com.tencent.mm.wallet_core.a.bs(this);
      if ((localObject == null) || (!((com.tencent.mm.wallet_core.d)localObject).fVn())) {
        break label1478;
      }
      localObject = (Orders)getInput().getParcelable("key_orders");
      if ((localObject == null) || (((Orders)localObject).Dpz != 1)) {
        break;
      }
      this.Dvy = true;
      this.Due.setText(com.tencent.mm.wallet_core.ui.f.bak(((Orders)localObject).DkG));
      this.Due.setEnabled(false);
      this.Due.setFocusable(false);
      this.Dej = ((Orders)localObject).DpA;
      this.Dvc.setText(t.eJn().am(this, this.Dej));
      this.Dvc.setEnabled(false);
      this.Def.setText(((Orders)localObject).DnP);
      this.Def.setInputEnable(false);
      this.Def.setFocusable(false);
      this.Deg.setText(2131765089);
      AppMethodBeat.o(70800);
      return;
      if ((getInput().getInt("key_bind_scene", -1) == 5) && (!this.Dif.Dop))
      {
        h.a(this, getString(2131765971), null, true, null);
        this.Dif.uVs = null;
      }
    }
    this.Dvy = false;
    label1478:
    AppMethodBeat.o(70800);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70810);
    ae.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (this.Dvu.g(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(70810);
      return;
    }
    if ((paramInt1 == 6) && (paramInt2 == 100))
    {
      if (!bu.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        this.DvM = paramIntent.getStringExtra("iso_code");
        this.Dvm.setText(paramIntent.getStringExtra("country_name"));
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
      aVv();
      AppMethodBeat.o(70810);
      return;
      this.Dif = null;
      this.DvP = 0;
      this.mSelectBankName = paramIntent.getStringExtra("bank_name");
      this.DuY.setText(this.mSelectBankName);
      this.DvN.setVisibility(0);
      this.DvN.setText("");
      aGn(this.mSelectBankName);
      if (this.DvO.size() == 1) {
        this.Dif = ((ElementQuery)this.DvO.get(0));
      }
      ae.i("MicroMsg.WalletCardElmentUI", "select bank: %s, %s", new Object[] { this.mSelectBankName, Integer.valueOf(this.DvO.size()) });
      this.Dug = null;
      hr(false);
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.DvB = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!bu.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.vte = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.vtf = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        if (bu.isNullOrNil(str1))
        {
          this.Dvp.setText(str3 + " " + str4);
          label486:
          if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.Dif.Dog)) {
            break label709;
          }
          this.Dvs.setVisibility(0);
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", new Object[] { str1, str2, str3, str4, this.vtf });
        break;
        this.Dvp.setText(str1 + " " + str4);
        break label486;
        if (!bu.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.vtf = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.Dvp.setText(str1 + " " + str3);
          break label486;
        }
        this.vtf = this.DvB;
        this.Dvp.setText(str1);
        break label486;
        label709:
        this.Dvs.setVisibility(8);
      }
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.Dvw.set3DesValStr(paramIntent);
      continue;
      str1 = paramIntent.getStringExtra("CountryName");
      str2 = paramIntent.getStringExtra("ProviceName");
      str3 = paramIntent.getStringExtra("CityName");
      this.countryCode = paramIntent.getStringExtra("Country");
      this.provinceCode = paramIntent.getStringExtra("Contact_Province");
      this.cityCode = paramIntent.getStringExtra("Contact_City");
      paramIntent = new StringBuilder();
      if (!bu.isNullOrNil(str1)) {
        paramIntent.append(str1);
      }
      if (!bu.isNullOrNil(str2)) {
        paramIntent.append(" ").append(str2);
      }
      if (!bu.isNullOrNil(str3)) {
        paramIntent.append(" ").append(str3);
      }
      this.Dvf.setText(paramIntent.toString());
      continue;
      this.Dig = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
      this.Dve.setText(this.Dig.DkE);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70799);
    super.onCreate(paramBundle);
    this.Dif = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.yvS = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.Dej = t.eJf().eJR();
    this.Dug = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
    this.DvC = getInput().getBoolean("key_need_area", false);
    this.DvD = getInput().getBoolean("key_need_profession", false);
    this.DvK = getInput().getBoolean("key_need_country", false);
    this.DvL = getInput().getStringArray("key_country_excludes");
    if (this.Dif != null) {
      aGn(this.Dif.uVs);
    }
    ae.d("MicroMsg.WalletCardElmentUI", "neeCountry: %s", new Object[] { Boolean.valueOf(this.DvK) });
    if ((this.DvC) || (this.DvD)) {
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
    ae.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    this.Djk = new String[100];
    int i = 0;
    while (i < this.Djk.length)
    {
      this.Djk[i] = getString(2131765220, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    paramBundle = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
    if ((this.yvS != null) && (paramBundle != null))
    {
      this.Dbe = e.DtH.a(this.yvS);
      if (this.Dbe == null) {
        break label477;
      }
      paramBundle = this.Dbe.aGk(paramBundle.Doq);
      this.Dvx = this.Dbe.aGf(paramBundle);
    }
    for (;;)
    {
      initView();
      this.fSp.pageScroll(33);
      com.tencent.mm.plugin.wallet_core.utils.f.a(this, getInput(), 3);
      com.tencent.mm.sdk.b.a.IvT.c(this.DdN);
      AppMethodBeat.o(70799);
      return;
      label477:
      ae.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70815);
    com.tencent.mm.sdk.b.a.IvT.d(this.DdN);
    super.onDestroy();
    AppMethodBeat.o(70815);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(70814);
    ae.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      if (this.Dvv == null) {
        eLc();
      }
      AppMethodBeat.o(70814);
      return false;
    }
    boolean bool1;
    if (this.Dvv != null)
    {
      paramTextView = this.Dvv;
      if (paramTextView.LXo != null)
      {
        bool1 = paramTextView.LXo.isFocusable();
        if (!bool1) {
          break label157;
        }
        paramTextView = this.Dvv;
        bool1 = bool2;
        if (paramTextView.LXo != null) {
          bool1 = paramTextView.LXo.isClickable();
        }
        if ((!bool1) || (!this.Dvv.fWB())) {
          break label157;
        }
        this.Dvv.fWE();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70814);
      return true;
      bool1 = false;
      break;
      label157:
      this.Dvv.performClick();
      continue;
      eLc();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70813);
    aVv();
    AppMethodBeat.o(70813);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70809);
    ae.i("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      ae.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramn instanceof ad))
      {
        ae.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI
 * JD-Core Version:    0.7.0.1
 */