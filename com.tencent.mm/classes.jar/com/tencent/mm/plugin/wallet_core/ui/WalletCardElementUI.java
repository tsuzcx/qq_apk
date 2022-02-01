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
import com.tencent.mm.g.a.rn;
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
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.bt;
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
  private WalletFormView AjM;
  private Bankcard AjO;
  private TextView AkA;
  private TextView AkB;
  private TextView AkC;
  private TextView AkD;
  private TextView AkE;
  private TextView AkF;
  private WalletFormView AkG;
  private WalletFormView AkH;
  private WalletFormView AkI;
  private WalletFormView AkJ;
  private WalletFormView AkK;
  private WalletFormView AkL;
  private WalletFormView AkM;
  private WalletFormView AkN;
  private WalletFormView AkO;
  private WalletFormView AkP;
  private WalletFormView AkQ;
  private WalletFormView AkR;
  private WalletFormView AkS;
  private WalletFormView AkT;
  private WalletFormView AkU;
  private WalletFormView AkV;
  private WalletFormView AkW;
  private WalletFormView AkX;
  private WalletFormView AkY;
  private WalletFormView AkZ;
  private TextView Akx;
  private TextView Aky;
  private TextView Akz;
  private int AlA;
  private int AlB;
  private int AlC;
  private int AlD;
  private int AlE;
  private int AlF;
  private int AlG;
  private int AlH;
  private String AlI;
  private String AlJ;
  private boolean AlK;
  private int AlL;
  private int AlM;
  private int AlN;
  private View.OnClickListener AlO;
  private WalletFormView Ala;
  private WalletFormView Alb;
  private WalletPhoneInputView Alc;
  private WalletFormView Ald;
  private WalletFormView Ale;
  private Map<String, d.a> Alf;
  private boolean Alg;
  private CheckBox Alh;
  private CheckBox Ali;
  private String Alj;
  private boolean Alk;
  private boolean Alm;
  private boolean Aln;
  private boolean Alo;
  private boolean Alp;
  private boolean Alq;
  private boolean Alr;
  private boolean Als;
  private boolean Alt;
  private String[] Alu;
  private String Alv;
  private WalletFormView Alw;
  private List<ElementQuery> Alx;
  private int Aly;
  private int Alz;
  private String cityCode;
  private String countryCode;
  private int evp;
  private Button ftn;
  private ScrollView ftp;
  private PayInfo mPayInfo;
  private Profession[] mProfessions;
  private String mSelectBankName;
  private int mSelectCreCountIndex;
  private String mTrueName;
  private String provinceCode;
  private String sWb;
  private String sWc;
  private Orders vIq;
  private TextView xDy;
  private Authen zPG;
  d zQQ;
  private WalletFormView zTO;
  private TextView zTP;
  private TextView zTQ;
  private int zTS;
  private com.tencent.mm.sdk.b.c zTw;
  private ElementQuery zXS;
  private Profession zXT;
  private List<cgy> zYV;
  private String[] zYW;
  
  public WalletCardElementUI()
  {
    AppMethodBeat.i(70798);
    this.Ald = null;
    this.zXS = new ElementQuery();
    this.zPG = new Authen();
    this.vIq = null;
    this.mPayInfo = null;
    this.AjO = null;
    this.Alf = null;
    this.zQQ = null;
    this.Alg = false;
    this.zTS = 1;
    this.Aln = false;
    this.Alo = false;
    this.Alp = false;
    this.Alq = false;
    this.Alr = false;
    this.Als = false;
    this.Alt = false;
    this.Alu = null;
    this.Alx = new ArrayList();
    this.zYV = new ArrayList();
    this.AlO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174518);
        com.tencent.mm.plugin.report.service.h.vKh.f(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
        com.tencent.mm.wallet_core.ui.e.d(WalletCardElementUI.this, s.ecc().getTrueName());
        AppMethodBeat.o(174518);
      }
    };
    this.zTw = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(70798);
  }
  
  private void RD(int paramInt)
  {
    AppMethodBeat.i(70817);
    if (paramInt == 1)
    {
      setEditFocusListener(this.zTO, 1, false, false, false);
      AppMethodBeat.o(70817);
      return;
    }
    setEditFocusListener(this.zTO, 1, true, false, false);
    AppMethodBeat.o(70817);
  }
  
  private void a(WalletFormView paramWalletFormView, int paramInt)
  {
    AppMethodBeat.i(70816);
    paramWalletFormView = paramWalletFormView.getLogicDelegate();
    if ((paramWalletFormView instanceof a.a))
    {
      ((a.a)paramWalletFormView).abz(paramInt);
      RD(paramInt);
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
        paramArrayOfWalletFormView[i].dga();
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
  
  private boolean aKT()
  {
    AppMethodBeat.i(70812);
    WalletFormView localWalletFormView = this.Ald;
    this.Ald = null;
    if (!this.AkG.gF(null))
    {
      if ((this.Ald == null) && (localWalletFormView != this.AkG)) {
        this.Ald = this.AkG;
      }
      this.AkA.setText(2131765091);
      this.AkA.setTextColor(getResources().getColor(2131100798));
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (!this.AjM.gF(null))
      {
        if ((this.Ald == null) && (localWalletFormView != this.AjM)) {
          this.Ald = this.AjM;
        }
        bool1 = false;
      }
      if (!this.Ale.gF(this.Aky))
      {
        if ((this.Ald == null) && (localWalletFormView != this.Ale)) {
          this.Ald = this.Ale;
        }
        bool1 = false;
      }
      int i;
      if ((!this.zTO.gF(this.zTQ)) && (!this.Alg))
      {
        if ((this.Ald == null) && (localWalletFormView != this.zTO)) {
          this.Ald = this.zTO;
        }
        this.zTQ.setText(2131765132);
        this.zTQ.setTextColor(getResources().getColor(2131100798));
        i = 1;
      }
      for (boolean bool2 = false;; bool2 = bool1)
      {
        bool1 = bool2;
        if (this.Aln)
        {
          bool1 = bool2;
          if (!this.AkQ.gF(null))
          {
            if ((this.Ald == null) && (localWalletFormView != this.AkQ)) {
              this.Ald = this.AkQ;
            }
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (this.Alo)
        {
          bool2 = bool1;
          if (!this.AkS.gF(null))
          {
            if ((this.Ald == null) && (localWalletFormView != this.AkS)) {
              this.Ald = this.AkS;
            }
            bool2 = false;
          }
        }
        if (!this.AkL.gF(this.zTQ)) {
          if (i != 0)
          {
            this.zTQ.setText(2131765125);
            this.zTQ.setTextColor(getResources().getColor(2131100798));
            if ((this.Ald == null) && (localWalletFormView != this.AkL)) {
              this.Ald = this.AkL;
            }
            bool1 = false;
            label401:
            if (this.zTQ.getVisibility() == 4)
            {
              if (!this.zXS.Adw) {
                break label1165;
              }
              this.zTQ.setText(getString(2131765133));
              label436:
              this.zTQ.setTextColor(getResources().getColor(2131100490));
              this.zTQ.setVisibility(0);
            }
            if (this.AkI.gF(this.AkC)) {
              break label1220;
            }
            if ((this.Ald == null) && (localWalletFormView != this.AkI)) {
              this.Ald = this.AkI;
            }
            i = 1;
            bool1 = false;
          }
        }
        for (;;)
        {
          if (!this.AkH.gF(this.AkC))
          {
            if ((this.Ald == null) && (localWalletFormView != this.AkH)) {
              this.Ald = this.AkH;
            }
            bool2 = false;
            label543:
            if (!this.Alh.isChecked()) {
              bool2 = false;
            }
            if (!this.AkV.gF(this.AkD))
            {
              if ((this.Ald == null) && (localWalletFormView != this.AkV)) {
                this.Ald = this.AkV;
              }
              bool2 = false;
            }
            if (!this.AkW.gF(this.AkD))
            {
              if ((this.Ald == null) && (localWalletFormView != this.AkW)) {
                this.Ald = this.AkW;
              }
              bool2 = false;
            }
            if (!this.AkX.gF(this.AkD))
            {
              if ((this.Ald == null) && (localWalletFormView != this.AkX)) {
                this.Ald = this.AkX;
              }
              bool2 = false;
            }
            if (!this.AkY.gF(this.AkD))
            {
              if ((this.Ald == null) && (localWalletFormView != this.AkY)) {
                this.Ald = this.AkY;
              }
              bool2 = false;
            }
            if (!this.AkZ.gF(this.AkD))
            {
              if ((this.Ald == null) && (localWalletFormView != this.AkZ)) {
                this.Ald = this.AkZ;
              }
              bool2 = false;
            }
            if (!this.Ala.gF(this.AkD))
            {
              if ((this.Ald == null) && (localWalletFormView != this.Ala)) {
                this.Ald = this.Ala;
              }
              bool2 = false;
            }
            if (!this.Alb.gF(this.AkD))
            {
              if ((this.Ald == null) && (localWalletFormView != this.Alb)) {
                this.Ald = this.Alb;
              }
              bool2 = false;
            }
            bool1 = bool2;
            if (this.Alm)
            {
              bool1 = bool2;
              if (!this.AkM.gF(null))
              {
                if ((this.Ald == null) && (localWalletFormView != this.AkM)) {
                  this.Ald = this.AkM;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.Alk)
            {
              bool2 = bool1;
              if (!this.AkN.gF(null))
              {
                if ((this.Ald == null) && (localWalletFormView != this.AkN)) {
                  this.Ald = this.AkN;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.Alk)
            {
              bool1 = bool2;
              if (!this.AkO.gF(null))
              {
                if ((this.Ald == null) && (localWalletFormView != this.AkO)) {
                  this.Ald = this.AkO;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.AlK)
            {
              bool2 = bool1;
              if (!this.AkP.gF(null))
              {
                if ((this.Ald == null) && (localWalletFormView != this.AkP)) {
                  this.Ald = this.AkP;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.Alq)
            {
              bool1 = bool2;
              if (!this.AkT.gF(null))
              {
                if ((this.Ald == null) && (localWalletFormView != this.AkT)) {
                  this.Ald = this.AkT;
                }
                bool1 = false;
              }
            }
            if (!bool1) {
              break label1201;
            }
            this.ftn.setEnabled(true);
            this.ftn.setClickable(true);
            if (localWalletFormView != null) {
              localWalletFormView.setImeOptions(1073741824);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(70812);
            return bool1;
            this.zTQ.setText(2131765126);
            this.zTQ.setTextColor(getResources().getColor(2131100798));
            break;
            bool1 = bool2;
            if (i == 0) {
              break label401;
            }
            this.zTQ.setVisibility(0);
            bool1 = bool2;
            break label401;
            label1165:
            this.zTQ.setText(getString(2131765136));
            break label436;
            bool2 = bool1;
            if (i == 0) {
              break label543;
            }
            this.AkC.setVisibility(4);
            bool2 = bool1;
            break label543;
            label1201:
            this.ftn.setEnabled(false);
            this.ftn.setClickable(false);
          }
          label1220:
          i = 0;
        }
        i = 0;
      }
    }
  }
  
  private void aus(String paramString)
  {
    AppMethodBeat.i(70811);
    Object localObject = s.eck().zWy;
    this.Alx.clear();
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
        } while (!localElementQuery.szi.equals(paramString));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "add element: %s, %s", new Object[] { localElementQuery.szi, localElementQuery.dca });
        this.Alx.add(localElementQuery);
        if ((getInput().getInt("key_bind_scene", -1) == 5) && (!localElementQuery.Aea)) {
          localElementQuery.AdK = getString(2131765969);
        }
      } while (this.Alx.size() < 2);
    }
    AppMethodBeat.o(70811);
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
  
  private void edR()
  {
    AppMethodBeat.i(70801);
    Object localObject;
    if (edW()) {
      localObject = getInput().getString("realname_verify_process_get_wording_cache");
    }
    try
    {
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = (azf)new azf().parseFrom(((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.zYV.addAll(((azf)localObject).DxQ);
      }
      localObject = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      if (localObject != null)
      {
        this.mTrueName = ((RealNameBundle)localObject).Aar;
        this.AlJ = ((RealNameBundle)localObject).AaN;
        this.evp = ((RealNameBundle)localObject).evp;
        if ((this.zXS != null) && (this.zXS.ebM() != null) && (this.zXS.ebM().contains(Integer.valueOf(((RealNameBundle)localObject).Aau))))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "set cretype: %s", new Object[] { Integer.valueOf(((RealNameBundle)localObject).Aau), this.zXS.ebM() });
          this.zTS = ((RealNameBundle)localObject).Aau;
          this.AkK.setText(((RealNameBundle)localObject).Aav);
          this.zTO.setText(((RealNameBundle)localObject).Aas);
          a(this.zTO, this.zTS);
          if (((RealNameBundle)localObject).AaD != 9999) {
            break label606;
          }
          this.AkS.setText(getString(2131766450));
          this.Alz = 9999;
          this.AlA = 12;
          this.AlB = 31;
          this.AkR.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(((RealNameBundle)localObject).AaP), Integer.valueOf(((RealNameBundle)localObject).AaQ), Integer.valueOf(((RealNameBundle)localObject).AaR) }));
          this.mSelectCreCountIndex = ((RealNameBundle)localObject).AaB;
          this.AkQ.setText(this.zYW[this.mSelectCreCountIndex]);
        }
        this.AjM.setText(((RealNameBundle)localObject).Aar);
        this.countryCode = ((RealNameBundle)localObject).Aax;
        this.provinceCode = ((RealNameBundle)localObject).Aay;
        this.cityCode = ((RealNameBundle)localObject).Aaz;
        this.AkN.setText(((RealNameBundle)localObject).AaA);
        this.AkO.setText(((RealNameBundle)localObject).AaN);
        this.Alv = ((RealNameBundle)localObject).AaK;
        this.AkU.setText(((RealNameBundle)localObject).AaL);
        this.zXT = ((RealNameBundle)localObject).Aaw;
        if (this.zXT != null) {
          this.AkM.setText(this.zXT.Aap);
        }
        this.AlL = (((RealNameBundle)localObject).evp - 1);
        if (this.AlL < 0) {
          this.AlL = 0;
        }
        WalletFormView localWalletFormView = this.AkP;
        if (((RealNameBundle)localObject).evp != 1) {
          break label656;
        }
        i = 2131763533;
        localWalletFormView.setText(getString(i));
        this.AlF = ((RealNameBundle)localObject).AaH;
        this.AlG = ((RealNameBundle)localObject).AaI;
        this.AlH = ((RealNameBundle)localObject).AaJ;
        if ((this.AlF > 0) && (this.AlG > 0) && (this.AlH > 0)) {
          this.AkT.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.AlF), Integer.valueOf(this.AlG), Integer.valueOf(this.AlH) }));
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
        this.AkS.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(localIOException.AaD), Integer.valueOf(localIOException.AaE), Integer.valueOf(localIOException.AaF) }));
        continue;
        label656:
        int i = 2131763532;
      }
    }
  }
  
  private void edS()
  {
    AppMethodBeat.i(70802);
    Object localObject1;
    Object localObject2;
    if (this.zXS.AdY == 0)
    {
      this.Alc.efe();
      localObject1 = s.eck().AhC;
      if (localObject1 == null) {
        break label172;
      }
      localObject2 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.wallet_core.id_verify.model.a)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).dca.equals(this.zXS.dca))
          {
            label77:
            localObject2 = this.Alc;
            if (localObject1 != null)
            {
              if (bt.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).zZT)) {
                break label177;
              }
              ((WalletPhoneInputView)localObject2).AtM.setHint(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).zZT);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).zZU)) {
        ((WalletPhoneInputView)localObject2).AtT = ((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).zZU;
      }
      AppMethodBeat.o(70802);
      return;
      this.Alc.eff();
      localObject1 = (EditText)this.Alc.findViewById(2131303383);
      setEditFocusListener(this.Alc.getPhoneNumberEt(), (EditText)localObject1, 0, false, false, true);
      break;
      label172:
      localObject1 = null;
      break label77;
      label177:
      ((WalletPhoneInputView)localObject2).AtM.setHint(((WalletPhoneInputView)localObject2).getContext().getString(2131765144));
    }
  }
  
  private void edT()
  {
    AppMethodBeat.i(70808);
    Object localObject1;
    boolean bool;
    if (aKT())
    {
      f.eft();
      if (!bt.isNullOrNil(this.zXS.AdI))
      {
        localObject1 = getInput();
        if ((this.Ali.getVisibility() == 0) && (this.Ali.isChecked()))
        {
          bool = true;
          ((Bundle)localObject1).putBoolean("key_is_follow_bank_username", bool);
          getInput().putString("key_bank_username", this.zXS.AdI);
        }
      }
      else
      {
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if ((this.zXS != null) && (localObject1 != null) && (this.zQQ != null) && (this.Alf != null))
        {
          if (!this.Alf.containsKey(this.zXS.dca)) {
            break label1487;
          }
          ((FavorPayInfo)localObject1).Aeb = ((d.a)this.Alf.get(this.zXS.dca)).Ajn.zOH;
          label168:
          getInput().putParcelable("key_favor_pay_info", (Parcelable)localObject1);
        }
        this.zPG = new Authen();
        if (this.AjO != null)
        {
          this.zPG.uns = this.AjO.AbS;
          this.zPG.sqX = this.AjO.field_bankcardTail;
        }
        localObject1 = getInput().getString("key_card_id");
        if (this.Ale.getVisibility() != 0) {
          break label1555;
        }
        localObject1 = this.Ale.getText();
      }
    }
    label524:
    label1555:
    for (;;)
    {
      this.zPG.uXi = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.zPG.Abj = ((String)localObject1);
      this.zPG.dca = this.zXS.dca;
      this.zPG.Abi = this.zTS;
      this.zPG.Abg = getInput().getString("key_pwd1");
      if (!bt.isNullOrNil(this.AkI.getText())) {
        this.zPG.Abk = this.AkI.getText();
      }
      this.zPG.zWw = this.AkL.getText();
      this.zPG.Abn = this.AkV.getText();
      this.zPG.Abo = this.AkW.getText();
      this.zPG.country = this.Alj;
      this.zPG.evz = this.sWb;
      this.zPG.evA = this.sWc;
      this.zPG.hdQ = this.AkY.getText();
      this.zPG.szk = this.AkZ.getText();
      this.zPG.iyB = this.Ala.getText();
      this.zPG.evs = this.Alb.getText();
      String str = com.tencent.mm.wallet_core.ui.e.aNg(this.zPG.zWw);
      getInput().putString("key_mobile", str);
      localObject1 = getInput();
      label736:
      Object localObject2;
      if (this.zXS.zWA == 2)
      {
        bool = true;
        ((Bundle)localObject1).putBoolean("key_is_oversea", bool);
        this.zPG.Abh = this.zTO.getText();
        this.zPG.Aar = this.AjM.getText();
        this.zPG.Abl = this.AkH.getText();
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if (localObject1 != null)
        {
          this.zPG.Abp = ((FavorPayInfo)localObject1).Aee;
          this.zPG.Abq = ((FavorPayInfo)localObject1).Aeb;
        }
        this.zPG.Abv = ("+" + this.Alc.getCountryCode());
        this.zPG.AaB = this.mSelectCreCountIndex;
        if (this.Alz != 9999) {
          break label1511;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "is long term");
        localObject1 = new TenpaySecureEncrypt();
        this.zPG.AaC = ((TenpaySecureEncrypt)localObject1).desedeEncode(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.Alz), Integer.valueOf(this.AlA), Integer.valueOf(this.AlB) }), com.tencent.mm.wallet_core.ui.e.fkB());
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "expire date: %s", new Object[] { this.AkS.getText() });
        this.zPG.AaG = this.AkT.getText();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "birth date: %s", new Object[] { this.AkT.getText() });
        localObject2 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new RealNameBundle();
        }
        ((RealNameBundle)localObject1).Aar = this.AjM.getText();
        ((RealNameBundle)localObject1).evp = (this.AlL + 1);
        ((RealNameBundle)localObject1).Aax = this.countryCode;
        ((RealNameBundle)localObject1).Aay = this.provinceCode;
        ((RealNameBundle)localObject1).Aaz = this.cityCode;
        ((RealNameBundle)localObject1).AaN = this.AkO.getText();
        ((RealNameBundle)localObject1).Aaw = this.zXT;
        ((RealNameBundle)localObject1).AaK = this.Alv;
        ((RealNameBundle)localObject1).AaG = this.AkT.getText();
        ((RealNameBundle)localObject1).Aau = this.zTS;
        ((RealNameBundle)localObject1).Aav = this.AkK.getText();
        ((RealNameBundle)localObject1).Aas = "";
        ((RealNameBundle)localObject1).Aat = this.zTO.getText();
        ((RealNameBundle)localObject1).AaO = this.AkR.getText();
        ((RealNameBundle)localObject1).AaC = this.AkS.getText();
        ((RealNameBundle)localObject1).AaB = this.mSelectCreCountIndex;
        getInput().putParcelable("realname_verify_process_bundle", (Parcelable)localObject1);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", new Object[] { Integer.valueOf(this.zPG.AaB), this.zPG.AaC, this.zPG.AaG });
        if ((edV()) && (!bt.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!bt.isNullOrNil(getInput().getString("key_true_name"))))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
          this.zPG.Abh = getInput().getString("key_identity");
          this.zPG.Abi = getInput().getInt("key_id_type", -1);
          this.zPG.Aar = this.mTrueName;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.zPG.Aar);
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.zPG.uXi + " elemt.bankcardTag : " + this.zXS.zWA);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.zXS.zWA);
        localObject2 = getInput();
        ((Bundle)localObject2).putString("key_mobile", str);
        ((Bundle)localObject2).putParcelable("key_authen", this.zPG);
        ((Bundle)localObject2).putString("key_bank_phone", this.zXS.AdH);
        ((Bundle)localObject2).putString("key_country_code", this.countryCode);
        ((Bundle)localObject2).putString("key_province_code", this.provinceCode);
        ((Bundle)localObject2).putString("key_city_code", this.cityCode);
        ((Bundle)localObject2).putParcelable("key_profession", this.zXT);
        ((Bundle)localObject2).putString("key_country_iso", this.Alv);
        ((Bundle)localObject2).putString("key_bind_card_type", this.zPG.dca);
        ((Bundle)localObject2).putString("key_bind_card_show1", this.zXS.szi);
        if (2 != this.zXS.AdE) {
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
          this.zPG.Abw = 1;
          this.zPG.zWG = ((String)localObject1);
        }
        this.zPG.Abx = ((Bundle)localObject2).getString("kreq_token");
        if (!getNetController().q(new Object[] { this.zPG, this.vIq })) {
          break label1539;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
        AppMethodBeat.o(70808);
        return;
        bool = false;
        break;
        ((FavorPayInfo)localObject1).Aeb = this.zQQ.bU(((FavorPayInfo)localObject1).Aeb, false);
        break label168;
        bool = false;
        break label524;
        this.zPG.AaC = this.AkS.getText();
        break label736;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70808);
      return;
    }
  }
  
  private void edU()
  {
    AppMethodBeat.i(70818);
    Object localObject;
    if ((this.zXS != null) && (this.Alf != null) && (this.Alf.containsKey(this.zXS.dca)))
    {
      localObject = (d.a)this.Alf.get(this.zXS.dca);
      if ((localObject == null) || (((d.a)localObject).Ajn == null)) {
        break label133;
      }
    }
    label133:
    for (double d = ((d.a)localObject).Ajo;; d = 0.0D)
    {
      localObject = getString(2131765090, new Object[] { com.tencent.mm.wallet_core.ui.e.E(d) });
      this.AkE.setText((CharSequence)localObject);
      this.AkE.setVisibility(0);
      AppMethodBeat.o(70818);
      return;
      this.AkE.setVisibility(8);
      AppMethodBeat.o(70818);
      return;
    }
  }
  
  private boolean edV()
  {
    AppMethodBeat.i(70819);
    boolean bool = getInput().getBoolean("key_is_forgot_process", false);
    AppMethodBeat.o(70819);
    return bool;
  }
  
  private boolean edW()
  {
    AppMethodBeat.i(174523);
    com.tencent.mm.wallet_core.d locald = getProcess();
    if ((locald != null) && ("realname_verify_process".equals(locald.cuB())))
    {
      if (locald.dow.getInt("real_name_verify_mode", 0) == 4)
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
  
  private void gP(boolean paramBoolean)
  {
    AppMethodBeat.i(70803);
    if (this.zXS == null) {
      this.zXS = new ElementQuery();
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "element: %s, %s", new Object[] { this.zXS.szi, this.zXS.dca });
    edS();
    edU();
    com.tencent.mm.wallet_core.a.bo(this);
    Object localObject1 = (Bankcard)getInput().getParcelable("key_bankcard");
    Object localObject2;
    Object localObject3;
    if ((edV()) && (localObject1 != null))
    {
      this.Ale.setHint(getString(2131765130, new Object[] { ((Bankcard)localObject1).field_bankcardTail }));
      localObject1 = this.Ale;
      localObject2 = this.Akx;
      localObject3 = this.Aky;
      a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
      localObject1 = this.AkG;
      localObject2 = this.Akz;
      localObject3 = this.AkA;
      a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
    }
    for (;;)
    {
      if (paramBoolean) {
        edR();
      }
      this.Aln = false;
      this.Alo = false;
      this.Alq = false;
      this.Alr = false;
      if (!edW()) {
        break;
      }
      localObject1 = this.zYV.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cgy)((Iterator)localObject1).next();
        if (((cgy)localObject2).Ecv.key == this.zTS)
        {
          this.Aln = ((cgy)localObject2).Ecz;
          this.Alo = ((cgy)localObject2).Ecy;
          this.Alp = ((cgy)localObject2).EcC;
          this.Alq = ((cgy)localObject2).EcA;
          this.AlK = ((cgy)localObject2).EcE;
          this.Alm = ((cgy)localObject2).Ecw;
          this.Alk = ((cgy)localObject2).Ecx;
          this.Als = ((cgy)localObject2).EcB;
          this.Alr = true;
        }
      }
      if (!bt.isNullOrNil(this.zXS.szi))
      {
        this.AkG.setText(this.zXS.szi);
        if (!this.zXS.ebx()) {
          break label561;
        }
        this.Alw.setVisibility(0);
        this.Alw.setText(getString(2131765221));
      }
      for (;;)
      {
        localObject1 = this.Ale;
        localObject2 = this.Akx;
        localObject3 = this.Aky;
        a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        localObject1 = this.AkG;
        localObject2 = this.Akz;
        localObject3 = this.AkA;
        a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        this.Ale.setOnInfoIvClickListener(this.AlO);
        if (!s.ecc().ecN().ect()) {
          break label596;
        }
        this.Ale.getInfoIv().setImageResource(2131691405);
        this.Ale.getInfoIv().setVisibility(0);
        break;
        label561:
        if (this.zXS.ebL())
        {
          this.Alw.setVisibility(0);
          this.Alw.setText(getString(2131765241));
        }
      }
      label596:
      this.Ale.getInfoIv().setVisibility(4);
    }
    Object localObject4;
    WalletFormView localWalletFormView1;
    WalletFormView localWalletFormView2;
    TextView localTextView1;
    TextView localTextView2;
    boolean bool1;
    boolean bool2;
    if ((this.zXS.AdZ != null) && (!this.zXS.AdZ.isEmpty()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "identity type： %s", new Object[] { Integer.valueOf(this.zTS) });
      localObject1 = this.zXS.AdZ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CreTypeRuleInfo)((Iterator)localObject1).next();
        if (((CreTypeRuleInfo)localObject2).Add == this.zTS)
        {
          if (((CreTypeRuleInfo)localObject2).Ade.AcZ == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "need show cre count");
            this.Aln = true;
          }
          if (((CreTypeRuleInfo)localObject2).Ade.Adb == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "need show cre expire");
            this.Alo = true;
          }
          if (((CreTypeRuleInfo)localObject2).Ade.Ada == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "need show birthday");
            this.Alq = true;
          }
          if (((CreTypeRuleInfo)localObject2).Ade.Adc == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "need show cre type");
            if (s.ecc().ecP() > 0)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
              this.Alr = true;
            }
          }
        }
      }
      if ((this.zTS == 2) && (this.Alt))
      {
        this.Als = true;
        if (!this.Alo)
        {
          this.Alz = 0;
          this.AlA = 0;
          this.AlB = 0;
        }
        if (!this.Alq)
        {
          this.AlF = 0;
          this.AlG = 0;
          this.AlH = 0;
        }
        if (!this.Aln) {
          this.mSelectCreCountIndex = 0;
        }
        this.AkJ.setVisibility(8);
        if (!Bankcard.Rw(this.zXS.zWA)) {
          break label1497;
        }
        localObject1 = this.AjM;
        localObject2 = this.AkK;
        localObject3 = this.zTO;
        localObject4 = this.AkQ;
        localWalletFormView1 = this.AkR;
        localWalletFormView2 = this.AkS;
        localTextView1 = this.zTP;
        localTextView2 = this.zTQ;
        a(new boolean[] { 0, 0, 0, 0, 0, 0 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.AkL.setVisibility(8);
        sE(true);
        paramBoolean = this.Alq;
        bool1 = this.Als;
        bool2 = this.AlK;
        localObject1 = this.AkN;
        localObject2 = this.AkO;
        localObject3 = this.AkM;
        localObject4 = this.AkT;
        localWalletFormView1 = this.AkU;
        localWalletFormView2 = this.AkP;
        localTextView1 = this.AkF;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        paramBoolean = this.zXS.Ady;
        bool1 = this.zXS.Adz;
        localObject1 = this.AkI;
        localObject2 = this.AkH;
        localObject3 = this.AkB;
        localObject4 = this.AkC;
        a(new boolean[] { paramBoolean, bool1 }, new WalletFormView[] { localObject1, localObject2 }, (TextView)localObject3, (TextView)localObject4);
        if (this.AkG.getVisibility() != 0) {
          break label2960;
        }
        switch (this.zXS.AdD)
        {
        default: 
          this.AkA.setVisibility(8);
          label1325:
          this.AkA.setTextColor(getResources().getColor(2131100707));
        }
      }
    }
    for (;;)
    {
      if ((!bt.isNullOrNil(this.zXS.AdX)) && (this.AkA.getVisibility() != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
        this.AkA.setText(this.zXS.AdX);
        this.AkA.setVisibility(0);
      }
      if ((bt.isNullOrNil(this.zXS.AdI)) || (!com.tencent.mm.model.w.sD(this.zXS.AdI)) || (edV())) {
        break label2972;
      }
      this.Ali.setText(this.zXS.AdJ);
      this.Ali.setVisibility(0);
      AppMethodBeat.o(70803);
      return;
      this.Als = false;
      break;
      if ((this.zTS == 2) && (this.Alt))
      {
        this.Als = true;
        break;
      }
      this.Als = false;
      break;
      label1497:
      int i;
      if ((this.zXS.ebM() != null) && (this.zXS.ebM().size() > 0))
      {
        i = 1;
        label1524:
        if ((!edV()) && (!s.ecc().ecH())) {
          break label2440;
        }
        localObject2 = s.ecc().getTrueName();
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          if (getProcess() != null) {
            localObject1 = getProcess().dow.getString("key_true_name");
          }
        }
        if (bt.isNullOrNil((String)localObject1)) {
          break label2252;
        }
        localObject1 = getString(2131765180, new Object[] { com.tencent.mm.wallet_core.ui.e.aNf((String)localObject1) });
        this.AjM.setHint((CharSequence)localObject1);
        this.AkJ.setHint((CharSequence)localObject1);
        label1633:
        if ((!edV()) || (bt.isNullOrNil(getInput().getString("key_identity"))) || (getInput().getInt("key_id_type", -1) == -1) || (bt.isNullOrNil(getInput().getString("key_true_name")))) {
          break label2282;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
        paramBoolean = this.Aln;
        bool1 = this.Alp;
        bool2 = this.Alo;
        localObject1 = this.AjM;
        localObject2 = this.AkK;
        localObject3 = this.zTO;
        localObject4 = this.AkQ;
        localWalletFormView1 = this.AkR;
        localWalletFormView2 = this.AkS;
        localTextView1 = this.zTP;
        localTextView2 = this.zTQ;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.mTrueName = getInput().getString("key_true_name");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "name is " + this.mTrueName);
        this.AkL.setVisibility(0);
        if (this.AjO != null)
        {
          if (!bt.isNullOrNil(this.AjO.field_mobile)) {
            d(this.AkL, this.AjO.field_mobile);
          }
          if (!bt.isNullOrNil(this.AjO.Abk)) {
            d(this.AkI, this.AjO.Abk);
          }
          if (!bt.isNullOrNil(this.AjO.AbR)) {
            d(this.AkH, this.AjO.AbR);
          }
        }
        if (!this.zXS.Adw) {
          break label2681;
        }
        this.zTQ.setText("");
      }
      for (;;)
      {
        if (!bt.isNullOrNil(this.zXS.AdA)) {
          this.zTO.setText(this.zXS.AdA);
        }
        if (s.ecc().ecP() <= 0) {
          break label2698;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", new Object[] { Integer.valueOf(s.ecc().ecP()) });
        this.AkK.setClickable(false);
        this.AkK.setText(s.eck().gv(this));
        this.AkK.setInputEnable(false);
        a(this.zTO, this.zTS);
        sE(false);
        paramBoolean = this.AlK;
        bool1 = this.Alk;
        bool2 = this.Alk;
        boolean bool3 = this.Alm;
        boolean bool4 = this.Alq;
        boolean bool5 = this.Als;
        localObject1 = this.AkP;
        localObject2 = this.AkN;
        localObject3 = this.AkO;
        localObject4 = this.AkM;
        localWalletFormView1 = this.AkT;
        localWalletFormView2 = this.AkU;
        localTextView1 = this.AkF;
        a(new boolean[] { paramBoolean, bool1, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        break;
        i = 0;
        break label1524;
        label2252:
        localObject1 = getString(2131765179);
        this.AjM.setHint((CharSequence)localObject1);
        this.AkJ.setHint((CharSequence)localObject1);
        break label1633;
        label2282:
        if ((this.Alr) || (i != 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool1 = this.Aln;
          bool2 = this.Alp;
          bool3 = this.Alo;
          localObject1 = this.AjM;
          localObject2 = this.AkK;
          localObject3 = this.zTO;
          localObject4 = this.AkQ;
          localWalletFormView1 = this.AkR;
          localWalletFormView2 = this.AkS;
          localTextView1 = this.zTP;
          localTextView2 = this.zTQ;
          a(new boolean[] { true, paramBoolean, true, bool1, bool2, bool3 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          break;
        }
        label2440:
        bool1 = this.zXS.Adw;
        if ((this.Alr) || ((i != 0) && (this.zXS.Adx))) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool2 = this.zXS.Adx;
          bool3 = this.Aln;
          bool4 = this.Alp;
          bool5 = this.Alo;
          localObject1 = this.AjM;
          localObject2 = this.AkK;
          localObject3 = this.zTO;
          localObject4 = this.AkQ;
          localWalletFormView1 = this.AkR;
          localWalletFormView2 = this.AkS;
          localTextView1 = this.zTP;
          localTextView2 = this.zTQ;
          a(new boolean[] { bool1, paramBoolean, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          this.AkL.setVisibility(0);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.zXS.Adw + " canModifyIdentity:" + this.zXS.Adx);
          break;
        }
        label2681:
        this.zTQ.setText(getString(2131765136));
      }
      label2698:
      if (this.zXS.ebM() != null)
      {
        i = this.zXS.ebM().size();
        label2721:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", new Object[] { Integer.valueOf(i) });
        if (i > 1) {
          break label2876;
        }
        this.AkK.setClickable(false);
        this.AkK.setInputEnable(false);
        this.zTO.setInputEnable(true);
      }
      for (;;)
      {
        localObject1 = this.zXS.ebM();
        if ((localObject1 == null) || (!((List)localObject1).contains(Integer.valueOf(this.zTS)))) {
          this.zTS = 1;
        }
        if (!s.eck().ad(this, this.zTS).equals(this.AlI)) {
          com.tencent.mm.plugin.report.service.h.vKh.f(16816, new Object[] { Integer.valueOf(this.zTS) });
        }
        this.AkK.setText(s.eck().ad(this, this.zTS));
        break;
        i = 0;
        break label2721;
        label2876:
        this.AkK.setClickable(true);
        this.AkK.setInputEnable(true);
        this.zTO.setInputEnable(true);
      }
      this.AkA.setText(2131765096);
      this.AkA.setVisibility(0);
      break label1325;
      this.AkA.setVisibility(8);
      break label1325;
      this.AkA.setVisibility(8);
      break label1325;
      this.AkA.setVisibility(8);
      break label1325;
      label2960:
      this.AkA.setVisibility(8);
    }
    label2972:
    this.Ali.setVisibility(8);
    AppMethodBeat.o(70803);
  }
  
  private void sE(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(70805);
    if (paramBoolean)
    {
      Object localObject = this.xDy;
      if (this.zXS.AdL)
      {
        i = 0;
        ((TextView)localObject).setVisibility(i);
        localObject = this.AkV;
        if (!this.zXS.AdL) {
          break label225;
        }
        i = 0;
        label54:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.AkW;
        if (!this.zXS.AdM) {
          break label231;
        }
        i = 0;
        label78:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.AkX;
        if (!this.zXS.AdN) {
          break label237;
        }
        i = 0;
        label102:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.AkY;
        if (!this.zXS.AdQ) {
          break label243;
        }
        i = 0;
        label126:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.AkZ;
        if (!this.zXS.AdS) {
          break label249;
        }
        i = 0;
        label150:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.Ala;
        if (!this.zXS.AdR) {
          break label255;
        }
        i = 0;
        label174:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.Alb;
        if (!this.zXS.AdT) {
          break label261;
        }
      }
      label261:
      for (int i = j;; i = 8)
      {
        ((WalletFormView)localObject).setVisibility(i);
        this.AkD.setVisibility(4);
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
    this.xDy.setVisibility(8);
    this.AkV.setVisibility(8);
    this.AkW.setVisibility(8);
    this.AkX.setVisibility(8);
    this.AkY.setVisibility(8);
    this.AkZ.setVisibility(8);
    this.Ala.setVisibility(8);
    this.Alb.setVisibility(8);
    this.AkD.setVisibility(8);
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
    this.Akx = ((TextView)findViewById(2131306710));
    this.Ale = ((WalletFormView)findViewById(2131306708));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Ale);
    this.Aky = ((TextView)findViewById(2131306709));
    this.zTP = ((TextView)findViewById(2131306712));
    this.AjM = ((WalletFormView)findViewById(2131302662));
    this.AkJ = ((WalletFormView)findViewById(2131300224));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.AjM);
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.AkJ);
    this.AkK = ((WalletFormView)findViewById(2131306730));
    this.zTO = ((WalletFormView)findViewById(2131300910));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.zTO);
    this.zTQ = ((TextView)findViewById(2131306711));
    this.Akz = ((TextView)findViewById(2131306701));
    this.AkG = ((WalletFormView)findViewById(2131306713));
    this.Alw = ((WalletFormView)findViewById(2131306717));
    this.AkA = ((TextView)findViewById(2131306702));
    this.AkE = ((TextView)findViewById(2131306706));
    this.AkB = ((TextView)findViewById(2131306704));
    this.AkI = ((WalletFormView)findViewById(2131298914));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.AkI);
    this.AkH = ((WalletFormView)findViewById(2131298929));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.AkH);
    this.AkC = ((TextView)findViewById(2131306703));
    this.xDy = ((TextView)findViewById(2131306699));
    this.AkV = ((WalletFormView)findViewById(2131300112));
    this.AkW = ((WalletFormView)findViewById(2131301314));
    this.AkX = ((WalletFormView)findViewById(2131296936));
    this.AkY = ((WalletFormView)findViewById(2131296479));
    this.AkZ = ((WalletFormView)findViewById(2131303210));
    this.Ala = ((WalletFormView)findViewById(2131303363));
    this.Alb = ((WalletFormView)findViewById(2131299329));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.Alb);
    this.AkD = ((TextView)findViewById(2131306698));
    this.Alh = ((CheckBox)findViewById(2131296518));
    this.Ali = ((CheckBox)findViewById(2131296515));
    this.ftn = ((Button)findViewById(2131302852));
    this.ftp = ((ScrollView)findViewById(2131306834));
    this.AkM = ((WalletFormView)findViewById(2131303415));
    this.AkN = ((WalletFormView)findViewById(2131303412));
    this.AkO = ((WalletFormView)findViewById(2131303411));
    this.AkP = ((WalletFormView)findViewById(2131303416));
    this.AkQ = ((WalletFormView)findViewById(2131306727));
    this.AkR = ((WalletFormView)findViewById(2131306728));
    this.AkS = ((WalletFormView)findViewById(2131306729));
    this.AkT = ((WalletFormView)findViewById(2131303413));
    this.AkU = ((WalletFormView)findViewById(2131303414));
    this.AkF = ((TextView)findViewById(2131306715));
    this.Alc = ((WalletPhoneInputView)findViewById(2131302361));
    this.AkL = this.Alc.getPhoneNumberEt();
    this.AjM.setOnInputValidChangeListener(this);
    this.AkJ.setOnInputValidChangeListener(this);
    this.Ale.setOnInputValidChangeListener(this);
    this.AkK.setOnInputValidChangeListener(this);
    this.zTO.setOnInputValidChangeListener(this);
    this.AkL.setOnInputValidChangeListener(new WalletFormView.a()
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
    this.AkI.setOnInputValidChangeListener(this);
    this.AkH.setOnInputValidChangeListener(this);
    this.AkV.setOnInputValidChangeListener(this);
    this.AkW.setOnInputValidChangeListener(this);
    this.AkX.setOnInputValidChangeListener(this);
    this.AkY.setOnInputValidChangeListener(this);
    this.AkZ.setOnInputValidChangeListener(this);
    this.Ala.setOnInputValidChangeListener(this);
    this.Alb.setOnInputValidChangeListener(this);
    this.AkM.setOnInputValidChangeListener(this);
    this.AkN.setOnInputValidChangeListener(this);
    this.AjM.setOnEditorActionListener(this);
    this.AkJ.setOnEditorActionListener(this);
    this.Ale.setOnEditorActionListener(this);
    this.AkK.setOnEditorActionListener(this);
    this.zTO.setOnEditorActionListener(this);
    this.AkL.setOnEditorActionListener(this);
    this.AkI.setOnEditorActionListener(this);
    this.AkH.setOnEditorActionListener(this);
    this.AkV.setOnEditorActionListener(this);
    this.AkW.setOnEditorActionListener(this);
    this.AkX.setOnEditorActionListener(this);
    this.AkY.setOnEditorActionListener(this);
    this.AkZ.setOnEditorActionListener(this);
    this.Ala.setOnEditorActionListener(this);
    this.Alb.setOnEditorActionListener(this);
    this.AkN.setOnEditorActionListener(this);
    this.AkM.setOnEditorActionListener(this);
    this.AkG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70786);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardElementUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putInt("key_bind_scene", WalletCardElementUI.this.getInput().getInt("key_bind_scene", -1));
        bt.isNullOrNil(WalletCardElementUI.c(WalletCardElementUI.this).getText());
        WalletCardElementUI.this.hideTenpayKB();
        com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.bo(WalletCardElementUI.this);
        if (locald != null) {
          locald.a(WalletCardElementUI.this, WalletBankCardSelectUI.class, paramAnonymousView, 1);
        }
        AppMethodBeat.o(70786);
      }
    });
    this.Alw.setOnClickListener(new View.OnClickListener()
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
          if (!localElementQuery.ebL()) {
            break label137;
          }
          paramAnonymousView.remove(1);
        }
        for (;;)
        {
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.aaR(WalletCardElementUI.e(WalletCardElementUI.this));
          paramAnonymousView.HIW = new c.a()
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
                  if (((i != 0) && (paramAnonymous2Object2.ebL())) || ((i == 0) && (paramAnonymous2Object2.ebx())))
                  {
                    WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymous2Object2);
                    WalletCardElementUI.g(WalletCardElementUI.this);
                  }
                }
                WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymousView.ffZ());
                AppMethodBeat.o(70787);
                return;
              }
            }
          };
          paramAnonymousView.show();
          AppMethodBeat.o(70788);
          return;
          label137:
          if (localElementQuery.ebx()) {
            paramAnonymousView.remove(0);
          }
        }
      }
    });
    this.AkK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70789);
        WalletCardElementUI.h(WalletCardElementUI.this);
        AppMethodBeat.o(70789);
      }
    });
    this.AkQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70791);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), WalletCardElementUI.i(WalletCardElementUI.this));
        paramAnonymousView.HIW = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(70790);
            if (paramAnonymous2Boolean)
            {
              WalletCardElementUI.j(WalletCardElementUI.this).setText((String)paramAnonymous2Object1);
              WalletCardElementUI.b(WalletCardElementUI.this, paramAnonymousView.ffZ());
              WalletCardElementUI.b(WalletCardElementUI.this);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(70790);
          }
        };
        paramAnonymousView.aaR(WalletCardElementUI.k(WalletCardElementUI.this));
        paramAnonymousView.show();
        AppMethodBeat.o(70791);
      }
    });
    this.AkR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70793);
        paramAnonymousView = new b(WalletCardElementUI.this.getContext());
        paramAnonymousView.HIQ = new b.a()
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
        paramAnonymousView.aO(i, j, k);
        localObject = WalletCardElementUI.l(WalletCardElementUI.this).getContentEt().getText().toString();
        if ((WalletCardElementUI.m(WalletCardElementUI.this) > 0) && (WalletCardElementUI.n(WalletCardElementUI.this) > 0) && (WalletCardElementUI.o(WalletCardElementUI.this) > 0)) {
          paramAnonymousView.aM(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
        }
        for (;;)
        {
          paramAnonymousView.show();
          AppMethodBeat.o(70793);
          return;
          if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).length() == 8))
          {
            WalletCardElementUI.c(WalletCardElementUI.this, bt.getInt(((String)localObject).substring(0, 4), i));
            WalletCardElementUI.d(WalletCardElementUI.this, bt.getInt(((String)localObject).substring(4, 6), j));
            WalletCardElementUI.e(WalletCardElementUI.this, bt.getInt(((String)localObject).substring(6, 8), k));
            paramAnonymousView.aM(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
          }
        }
      }
    });
    this.AkS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70794);
        paramAnonymousView = new b(WalletCardElementUI.this.getContext());
        paramAnonymousView.HIQ = new b.a()
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
        paramAnonymousView.aN(i, j, k);
        paramAnonymousView.aO(i + 200, 12, 31);
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
            break label296;
          }
          paramAnonymousView.aM(1, 1, 1);
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
          paramAnonymousView.aM(WalletCardElementUI.q(WalletCardElementUI.this), WalletCardElementUI.r(WalletCardElementUI.this), WalletCardElementUI.s(WalletCardElementUI.this));
        }
      }
    });
    this.AkP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70795);
        paramAnonymousView = WalletCardElementUI.this.getResources().getStringArray(2130903102);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), paramAnonymousView);
        paramAnonymousView.HIW = new c.a()
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
              paramAnonymousView.aaR(WalletCardElementUI.u(WalletCardElementUI.this));
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
    this.AkN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70797);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("GetAddress", true);
        paramAnonymousView.putExtra("ShowSelectedLocation", false);
        if (!Bankcard.Rw(WalletCardElementUI.v(WalletCardElementUI.this).zWA))
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
        com.tencent.mm.bs.d.c(WalletCardElementUI.this.getContext(), ".ui.tools.MultiStageCitySelectUI", paramAnonymousView, 4);
        AppMethodBeat.o(70797);
      }
    });
    this.AkM.setOnClickListener(new View.OnClickListener()
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
    this.AkT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(174512);
        paramAnonymousView = new b(WalletCardElementUI.this.getContext());
        paramAnonymousView.HIQ = new b.a()
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
          paramAnonymousView.aM(WalletCardElementUI.z(WalletCardElementUI.this), WalletCardElementUI.A(WalletCardElementUI.this), WalletCardElementUI.B(WalletCardElementUI.this));
        }
        paramAnonymousView.show();
        AppMethodBeat.o(174512);
      }
    });
    this.AkU.setOnClickListener(new View.OnClickListener()
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
    this.Alh.setChecked(true);
    this.Alh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
        com.tencent.mm.wallet_core.ui.e.b(WalletCardElementUI.this, WalletCardElementUI.v(WalletCardElementUI.this).dca, WalletCardElementUI.v(WalletCardElementUI.this).szi, false, WalletCardElementUI.v(WalletCardElementUI.this).AdW);
        AppMethodBeat.o(70778);
      }
    });
    this.AkX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174514);
        paramAnonymousView = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
        if (Bankcard.Rw(WalletCardElementUI.v(WalletCardElementUI.this).zWA)) {
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
    this.AkO.setOnInputValidChangeListener(this);
    this.ftn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174515);
        WalletCardElementUI.C(WalletCardElementUI.this);
        AppMethodBeat.o(174515);
      }
    });
    setEditFocusListener(this.Ale, 0, false, false, true);
    setEditFocusListener(this.zTO, 1, false, false, true);
    setEditFocusListener(this.AkL, 0, false, false, true);
    if ((this.zXS != null) && (!bt.isNullOrNil(this.zXS.AdK)))
    {
      com.tencent.mm.ui.base.h.a(this, this.zXS.AdK, null, true, null);
      this.zXS = null;
    }
    for (;;)
    {
      gP(true);
      aKT();
      Object localObject = com.tencent.mm.wallet_core.a.bo(this);
      if ((localObject == null) || (!((com.tencent.mm.wallet_core.d)localObject).fjs())) {
        break label1478;
      }
      localObject = (Orders)getInput().getParcelable("key_orders");
      if ((localObject == null) || (((Orders)localObject).Afh != 1)) {
        break;
      }
      this.Alg = true;
      this.AjM.setText(com.tencent.mm.wallet_core.ui.e.aNf(((Orders)localObject).Aar));
      this.AjM.setEnabled(false);
      this.AjM.setFocusable(false);
      this.zTS = ((Orders)localObject).Afi;
      this.AkK.setText(s.eck().ad(this, this.zTS));
      this.AkK.setEnabled(false);
      this.zTO.setText(((Orders)localObject).AdA);
      this.zTO.setInputEnable(false);
      this.zTO.setFocusable(false);
      this.zTP.setText(2131765089);
      AppMethodBeat.o(70800);
      return;
      if ((getInput().getInt("key_bind_scene", -1) == 5) && (!this.zXS.Aea))
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131765971), null, true, null);
        this.zXS.szi = null;
      }
    }
    this.Alg = false;
    label1478:
    AppMethodBeat.o(70800);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70810);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (this.Alc.f(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(70810);
      return;
    }
    if ((paramInt1 == 6) && (paramInt2 == 100))
    {
      if (!bt.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        this.Alv = paramIntent.getStringExtra("iso_code");
        this.AkU.setText(paramIntent.getStringExtra("country_name"));
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
      aKT();
      AppMethodBeat.o(70810);
      return;
      this.zXS = null;
      this.Aly = 0;
      this.mSelectBankName = paramIntent.getStringExtra("bank_name");
      this.AkG.setText(this.mSelectBankName);
      this.Alw.setVisibility(0);
      this.Alw.setText("");
      aus(this.mSelectBankName);
      if (this.Alx.size() == 1) {
        this.zXS = ((ElementQuery)this.Alx.get(0));
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "select bank: %s, %s", new Object[] { this.mSelectBankName, Integer.valueOf(this.Alx.size()) });
      this.AjO = null;
      gP(false);
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.Alj = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!bt.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.sWb = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.sWc = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        if (bt.isNullOrNil(str1))
        {
          this.AkX.setText(str3 + " " + str4);
          label486:
          if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.zXS.AdR)) {
            break label709;
          }
          this.Ala.setVisibility(0);
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", new Object[] { str1, str2, str3, str4, this.sWc });
        break;
        this.AkX.setText(str1 + " " + str4);
        break label486;
        if (!bt.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.sWc = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.AkX.setText(str1 + " " + str3);
          break label486;
        }
        this.sWc = this.Alj;
        this.AkX.setText(str1);
        break label486;
        label709:
        this.Ala.setVisibility(8);
      }
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.Ale.set3DesValStr(paramIntent);
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
      this.AkN.setText(paramIntent.toString());
      continue;
      this.zXT = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
      this.AkM.setText(this.zXT.Aap);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70799);
    super.onCreate(paramBundle);
    this.zXS = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.vIq = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.zTS = s.ecc().ecP();
    this.AjO = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
    this.Alk = getInput().getBoolean("key_need_area", false);
    this.Alm = getInput().getBoolean("key_need_profession", false);
    this.Alt = getInput().getBoolean("key_need_country", false);
    this.Alu = getInput().getStringArray("key_country_excludes");
    if (this.zXS != null) {
      aus(this.zXS.szi);
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "neeCountry: %s", new Object[] { Boolean.valueOf(this.Alt) });
    if ((this.Alk) || (this.Alm)) {
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
    this.zYW = new String[100];
    int i = 0;
    while (i < this.zYW.length)
    {
      this.zYW[i] = getString(2131765220, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    paramBundle = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
    if ((this.vIq != null) && (paramBundle != null))
    {
      this.zQQ = e.Ajp.a(this.vIq);
      if (this.zQQ == null) {
        break label477;
      }
      paramBundle = this.zQQ.auo(paramBundle.Aeb);
      this.Alf = this.zQQ.auj(paramBundle);
    }
    for (;;)
    {
      initView();
      this.ftp.pageScroll(33);
      f.a(this, getInput(), 3);
      com.tencent.mm.sdk.b.a.ESL.c(this.zTw);
      AppMethodBeat.o(70799);
      return;
      label477:
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70815);
    com.tencent.mm.sdk.b.a.ESL.d(this.zTw);
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
      if (this.Ald == null) {
        edT();
      }
      AppMethodBeat.o(70814);
      return false;
    }
    boolean bool1;
    if (this.Ald != null)
    {
      paramTextView = this.Ald;
      if (paramTextView.IfT != null)
      {
        bool1 = paramTextView.IfT.isFocusable();
        if (!bool1) {
          break label157;
        }
        paramTextView = this.Ald;
        bool1 = bool2;
        if (paramTextView.IfT != null) {
          bool1 = paramTextView.IfT.isClickable();
        }
        if ((!bool1) || (!this.Ald.fkF())) {
          break label157;
        }
        this.Ald.fkI();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70814);
      return true;
      bool1 = false;
      break;
      label157:
      this.Ald.performClick();
      continue;
      edT();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70813);
    aKT();
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