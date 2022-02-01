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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.model.ab;
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
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.ui.widget.picker.c.b;
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
  private Orders CwO;
  private TextView EIm;
  private Authen HFI;
  d HGS;
  private IListener HJH;
  private WalletFormView HJY;
  private TextView HJZ;
  private TextView HKa;
  private int HKd;
  private ElementQuery HRy;
  private Profession HRz;
  private List<djv> HSB;
  private String[] HSD;
  private WalletFormView Idq;
  private Bankcard Ids;
  private WalletFormView IeA;
  private WalletFormView IeB;
  private WalletFormView IeC;
  private WalletFormView IeD;
  private WalletFormView IeE;
  private WalletPhoneInputView IeF;
  private WalletFormView IeG;
  private WalletFormView IeH;
  private Map<String, d.a> IeI;
  private boolean IeJ;
  private CheckBox IeK;
  private CheckBox IeL;
  private String IeM;
  private boolean IeN;
  private boolean IeO;
  private boolean IeP;
  private boolean IeQ;
  private boolean IeR;
  private boolean IeS;
  private boolean IeT;
  private boolean IeU;
  private boolean IeV;
  private String[] IeW;
  private String IeX;
  private WalletFormView IeY;
  private List<ElementQuery> IeZ;
  private TextView Iea;
  private TextView Ieb;
  private TextView Iec;
  private TextView Ied;
  private TextView Iee;
  private TextView Ief;
  private TextView Ieg;
  private TextView Ieh;
  private TextView Iei;
  private WalletFormView Iej;
  private WalletFormView Iek;
  private WalletFormView Iel;
  private WalletFormView Iem;
  private WalletFormView Ien;
  private WalletFormView Ieo;
  private WalletFormView Iep;
  private WalletFormView Ieq;
  private WalletFormView Ier;
  private WalletFormView Ies;
  private WalletFormView Iet;
  private WalletFormView Ieu;
  private WalletFormView Iev;
  private WalletFormView Iew;
  private WalletFormView Iex;
  private WalletFormView Iey;
  private WalletFormView Iez;
  private int Ifa;
  private int Ifb;
  private int Ifc;
  private int Ifd;
  private int Ife;
  private int Iff;
  private int Ifg;
  private int Ifh;
  private int Ifi;
  private int Ifj;
  private String Ifk;
  private String Ifl;
  private boolean Ifm;
  private int Ifn;
  private int Ifo;
  private int Ifp;
  private View.OnClickListener Ifq;
  private String cityCode;
  private String countryCode;
  private int fuA;
  private Button gxv;
  private ScrollView gxx;
  private PayInfo mPayInfo;
  private Profession[] mProfessions;
  private String mSelectBankName;
  private int mSelectCreCountIndex;
  private String mTrueName;
  private String provinceCode;
  private String yMR;
  private String yMS;
  
  public WalletCardElementUI()
  {
    AppMethodBeat.i(70798);
    this.IeG = null;
    this.HRy = new ElementQuery();
    this.HFI = new Authen();
    this.CwO = null;
    this.mPayInfo = null;
    this.Ids = null;
    this.IeI = null;
    this.HGS = null;
    this.IeJ = false;
    this.HKd = 1;
    this.IeP = false;
    this.IeQ = false;
    this.IeR = false;
    this.IeS = false;
    this.IeT = false;
    this.IeU = false;
    this.IeV = false;
    this.IeW = null;
    this.IeZ = new ArrayList();
    this.HSB = new ArrayList();
    this.Ifq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174518);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.report.service.h.CyF.a(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
        com.tencent.mm.wallet_core.ui.f.d(WalletCardElementUI.this, t.fQI().getTrueName());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174518);
      }
    };
    this.HJH = new IListener() {};
    AppMethodBeat.o(70798);
  }
  
  private void a(WalletFormView paramWalletFormView, int paramInt)
  {
    AppMethodBeat.i(70816);
    paramWalletFormView = paramWalletFormView.getLogicDelegate();
    if ((paramWalletFormView instanceof a.a))
    {
      ((a.a)paramWalletFormView).aqn(paramInt);
      aeP(paramInt);
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
        paramArrayOfWalletFormView[i].eIj();
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
  
  private void aVO(String paramString)
  {
    AppMethodBeat.i(70811);
    Object localObject = t.fQQ().HQe;
    this.IeZ.clear();
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
        } while (!localElementQuery.ynT.equals(paramString));
        Log.i("MicroMsg.WalletCardElmentUI", "add element: %s, %s", new Object[] { localElementQuery.ynT, localElementQuery.dDj });
        this.IeZ.add(localElementQuery);
        if ((getInput().getInt("key_bind_scene", -1) == 5) && (!localElementQuery.HXH)) {
          localElementQuery.HXr = getString(2131768422);
        }
      } while (this.IeZ.size() < 2);
    }
    AppMethodBeat.o(70811);
  }
  
  private void aeP(int paramInt)
  {
    AppMethodBeat.i(70817);
    if (paramInt == 1)
    {
      setEditFocusListener(this.HJY, 1, false, false, false);
      AppMethodBeat.o(70817);
      return;
    }
    setEditFocusListener(this.HJY, 1, true, false, false);
    AppMethodBeat.o(70817);
  }
  
  private boolean bqg()
  {
    AppMethodBeat.i(70812);
    WalletFormView localWalletFormView = this.IeG;
    this.IeG = null;
    if (!this.Iej.hK(null))
    {
      if ((this.IeG == null) && (localWalletFormView != this.Iej)) {
        this.IeG = this.Iej;
      }
      this.Ied.setText(2131767534);
      this.Ied.setTextColor(getResources().getColor(2131100994));
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (!this.Idq.hK(null))
      {
        if ((this.IeG == null) && (localWalletFormView != this.Idq)) {
          this.IeG = this.Idq;
        }
        bool1 = false;
      }
      if (!this.IeH.hK(this.Ieb))
      {
        if ((this.IeG == null) && (localWalletFormView != this.IeH)) {
          this.IeG = this.IeH;
        }
        bool1 = false;
      }
      int i;
      if ((!this.HJY.hK(this.HKa)) && (!this.IeJ))
      {
        if ((this.IeG == null) && (localWalletFormView != this.HJY)) {
          this.IeG = this.HJY;
        }
        this.HKa.setText(2131767575);
        this.HKa.setTextColor(getResources().getColor(2131100994));
        i = 1;
      }
      for (boolean bool2 = false;; bool2 = bool1)
      {
        bool1 = bool2;
        if (this.IeP)
        {
          bool1 = bool2;
          if (!this.Iet.hK(null))
          {
            if ((this.IeG == null) && (localWalletFormView != this.Iet)) {
              this.IeG = this.Iet;
            }
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (this.IeQ)
        {
          bool2 = bool1;
          if (!this.Iev.hK(null))
          {
            if ((this.IeG == null) && (localWalletFormView != this.Iev)) {
              this.IeG = this.Iev;
            }
            bool2 = false;
          }
        }
        if (!this.Ieo.hK(this.HKa)) {
          if (i != 0)
          {
            this.HKa.setText(2131767568);
            this.HKa.setTextColor(getResources().getColor(2131100994));
            if ((this.IeG == null) && (localWalletFormView != this.Ieo)) {
              this.IeG = this.Ieo;
            }
            bool1 = false;
            label401:
            if (this.HKa.getVisibility() == 4)
            {
              if (!this.HRy.HXd) {
                break label1165;
              }
              this.HKa.setText(getString(2131767576));
              label436:
              this.HKa.setTextColor(getResources().getColor(2131100594));
              this.HKa.setVisibility(0);
            }
            if (this.Iel.hK(this.Ief)) {
              break label1220;
            }
            if ((this.IeG == null) && (localWalletFormView != this.Iel)) {
              this.IeG = this.Iel;
            }
            i = 1;
            bool1 = false;
          }
        }
        for (;;)
        {
          if (!this.Iek.hK(this.Ief))
          {
            if ((this.IeG == null) && (localWalletFormView != this.Iek)) {
              this.IeG = this.Iek;
            }
            bool2 = false;
            label543:
            if (!this.IeK.isChecked()) {
              bool2 = false;
            }
            if (!this.Iey.hK(this.Ieg))
            {
              if ((this.IeG == null) && (localWalletFormView != this.Iey)) {
                this.IeG = this.Iey;
              }
              bool2 = false;
            }
            if (!this.Iez.hK(this.Ieg))
            {
              if ((this.IeG == null) && (localWalletFormView != this.Iez)) {
                this.IeG = this.Iez;
              }
              bool2 = false;
            }
            if (!this.IeA.hK(this.Ieg))
            {
              if ((this.IeG == null) && (localWalletFormView != this.IeA)) {
                this.IeG = this.IeA;
              }
              bool2 = false;
            }
            if (!this.IeB.hK(this.Ieg))
            {
              if ((this.IeG == null) && (localWalletFormView != this.IeB)) {
                this.IeG = this.IeB;
              }
              bool2 = false;
            }
            if (!this.IeC.hK(this.Ieg))
            {
              if ((this.IeG == null) && (localWalletFormView != this.IeC)) {
                this.IeG = this.IeC;
              }
              bool2 = false;
            }
            if (!this.IeD.hK(this.Ieg))
            {
              if ((this.IeG == null) && (localWalletFormView != this.IeD)) {
                this.IeG = this.IeD;
              }
              bool2 = false;
            }
            if (!this.IeE.hK(this.Ieg))
            {
              if ((this.IeG == null) && (localWalletFormView != this.IeE)) {
                this.IeG = this.IeE;
              }
              bool2 = false;
            }
            bool1 = bool2;
            if (this.IeO)
            {
              bool1 = bool2;
              if (!this.Iep.hK(null))
              {
                if ((this.IeG == null) && (localWalletFormView != this.Iep)) {
                  this.IeG = this.Iep;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.IeN)
            {
              bool2 = bool1;
              if (!this.Ieq.hK(null))
              {
                if ((this.IeG == null) && (localWalletFormView != this.Ieq)) {
                  this.IeG = this.Ieq;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.IeN)
            {
              bool1 = bool2;
              if (!this.Ier.hK(null))
              {
                if ((this.IeG == null) && (localWalletFormView != this.Ier)) {
                  this.IeG = this.Ier;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.Ifm)
            {
              bool2 = bool1;
              if (!this.Ies.hK(null))
              {
                if ((this.IeG == null) && (localWalletFormView != this.Ies)) {
                  this.IeG = this.Ies;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.IeS)
            {
              bool1 = bool2;
              if (!this.Iew.hK(null))
              {
                if ((this.IeG == null) && (localWalletFormView != this.Iew)) {
                  this.IeG = this.Iew;
                }
                bool1 = false;
              }
            }
            if (!bool1) {
              break label1201;
            }
            this.gxv.setEnabled(true);
            this.gxv.setClickable(true);
            if (localWalletFormView != null) {
              localWalletFormView.setImeOptions(1073741824);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(70812);
            return bool1;
            this.HKa.setText(2131767569);
            this.HKa.setTextColor(getResources().getColor(2131100994));
            break;
            bool1 = bool2;
            if (i == 0) {
              break label401;
            }
            this.HKa.setVisibility(0);
            bool1 = bool2;
            break label401;
            label1165:
            this.HKa.setText(getString(2131767579));
            break label436;
            bool2 = bool1;
            if (i == 0) {
              break label543;
            }
            this.Ief.setVisibility(4);
            bool2 = bool1;
            break label543;
            label1201:
            this.gxv.setEnabled(false);
            this.gxv.setClickable(false);
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
  
  private void fSF()
  {
    AppMethodBeat.i(70801);
    Object localObject;
    if (fSK()) {
      localObject = getInput().getString("realname_verify_process_get_wording_cache");
    }
    try
    {
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = (btr)new btr().parseFrom(((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.HSB.addAll(((btr)localObject).MaA);
      }
      localObject = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      if (localObject != null)
      {
        this.mTrueName = ((RealNameBundle)localObject).HTZ;
        this.Ifl = ((RealNameBundle)localObject).HUv;
        this.fuA = ((RealNameBundle)localObject).fuA;
        if ((this.HRy != null) && (this.HRy.fQs() != null) && (this.HRy.fQs().contains(Integer.valueOf(((RealNameBundle)localObject).HUc))))
        {
          Log.i("MicroMsg.WalletCardElmentUI", "set cretype: %s", new Object[] { Integer.valueOf(((RealNameBundle)localObject).HUc), this.HRy.fQs() });
          this.HKd = ((RealNameBundle)localObject).HUc;
          this.Ien.setText(((RealNameBundle)localObject).HUd);
          this.HJY.setText(((RealNameBundle)localObject).HUa);
          a(this.HJY, this.HKd);
          if (((RealNameBundle)localObject).HUl != 9999) {
            break label606;
          }
          this.Iev.setText(getString(2131768509));
          this.Ifb = 9999;
          this.Ifc = 12;
          this.Ifd = 31;
          this.Ieu.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(((RealNameBundle)localObject).HUx), Integer.valueOf(((RealNameBundle)localObject).HUy), Integer.valueOf(((RealNameBundle)localObject).HUz) }));
          this.mSelectCreCountIndex = ((RealNameBundle)localObject).HUj;
          this.Iet.setText(this.HSD[this.mSelectCreCountIndex]);
        }
        this.Idq.setText(((RealNameBundle)localObject).HTZ);
        this.countryCode = ((RealNameBundle)localObject).HUf;
        this.provinceCode = ((RealNameBundle)localObject).HUg;
        this.cityCode = ((RealNameBundle)localObject).HUh;
        this.Ieq.setText(((RealNameBundle)localObject).HUi);
        this.Ier.setText(((RealNameBundle)localObject).HUv);
        this.IeX = ((RealNameBundle)localObject).HUs;
        this.Iex.setText(((RealNameBundle)localObject).HUt);
        this.HRz = ((RealNameBundle)localObject).HUe;
        if (this.HRz != null) {
          this.Iep.setText(this.HRz.HTX);
        }
        this.Ifn = (((RealNameBundle)localObject).fuA - 1);
        if (this.Ifn < 0) {
          this.Ifn = 0;
        }
        WalletFormView localWalletFormView = this.Ies;
        if (((RealNameBundle)localObject).fuA != 1) {
          break label656;
        }
        i = 2131765721;
        localWalletFormView.setText(getString(i));
        this.Ifh = ((RealNameBundle)localObject).HUp;
        this.Ifi = ((RealNameBundle)localObject).HUq;
        this.Ifj = ((RealNameBundle)localObject).HUr;
        if ((this.Ifh > 0) && (this.Ifi > 0) && (this.Ifj > 0)) {
          this.Iew.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.Ifh), Integer.valueOf(this.Ifi), Integer.valueOf(this.Ifj) }));
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
        this.Iev.setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(localIOException.HUl), Integer.valueOf(localIOException.HUm), Integer.valueOf(localIOException.HUn) }));
        continue;
        label656:
        int i = 2131765720;
      }
    }
  }
  
  private void fSG()
  {
    AppMethodBeat.i(70802);
    Object localObject1;
    Object localObject2;
    if (this.HRy.HXF == 0)
    {
      this.IeF.fTU();
      localObject1 = t.fQQ().Ibg;
      if (localObject1 == null) {
        break label172;
      }
      localObject2 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.wallet_core.id_verify.model.a)((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).dDj.equals(this.HRy.dDj))
          {
            label77:
            localObject2 = this.IeF;
            if (localObject1 != null)
            {
              if (Util.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).HTB)) {
                break label177;
              }
              ((WalletPhoneInputView)localObject2).Ino.setHint(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).HTB);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).HTC)) {
        ((WalletPhoneInputView)localObject2).Inv = ((com.tencent.mm.plugin.wallet_core.id_verify.model.a)localObject1).HTC;
      }
      AppMethodBeat.o(70802);
      return;
      this.IeF.fTV();
      localObject1 = (EditText)this.IeF.findViewById(2131306096);
      setEditFocusListener(this.IeF.getPhoneNumberEt(), (EditText)localObject1, 0, false, false, true);
      break;
      label172:
      localObject1 = null;
      break label77;
      label177:
      ((WalletPhoneInputView)localObject2).Ino.setHint(((WalletPhoneInputView)localObject2).getContext().getString(2131767587));
    }
  }
  
  private void fSH()
  {
    AppMethodBeat.i(70808);
    Object localObject1;
    boolean bool;
    if (bqg())
    {
      com.tencent.mm.plugin.wallet_core.utils.f.fUi();
      if (!Util.isNullOrNil(this.HRy.HXp))
      {
        localObject1 = getInput();
        if ((this.IeL.getVisibility() == 0) && (this.IeL.isChecked()))
        {
          bool = true;
          ((Bundle)localObject1).putBoolean("key_is_follow_bank_username", bool);
          getInput().putString("key_bank_username", this.HRy.HXp);
        }
      }
      else
      {
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if ((this.HRy != null) && (localObject1 != null) && (this.HGS != null) && (this.IeI != null))
        {
          if (!this.IeI.containsKey(this.HRy.dDj)) {
            break label1487;
          }
          ((FavorPayInfo)localObject1).HXI = ((d.a)this.IeI.get(this.HRy.dDj)).IcR.HEJ;
          label168:
          getInput().putParcelable("key_favor_pay_info", (Parcelable)localObject1);
        }
        this.HFI = new Authen();
        if (this.Ids != null)
        {
          this.HFI.ANo = this.Ids.HVA;
          this.HFI.xxN = this.Ids.field_bankcardTail;
        }
        localObject1 = getInput().getString("key_card_id");
        if (this.IeH.getVisibility() != 0) {
          break label1555;
        }
        localObject1 = this.IeH.getText();
      }
    }
    label524:
    label1555:
    for (;;)
    {
      this.HFI.BDB = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.HFI.HUR = ((String)localObject1);
      this.HFI.dDj = this.HRy.dDj;
      this.HFI.HUQ = this.HKd;
      this.HFI.HUO = getInput().getString("key_pwd1");
      if (!Util.isNullOrNil(this.Iel.getText())) {
        this.HFI.HUS = this.Iel.getText();
      }
      this.HFI.HQc = this.Ieo.getText();
      this.HFI.HUV = this.Iey.getText();
      this.HFI.HUW = this.Iez.getText();
      this.HFI.country = this.IeM;
      this.HFI.fuJ = this.yMR;
      this.HFI.fuK = this.yMS;
      this.HFI.iUO = this.IeB.getText();
      this.HFI.ynV = this.IeC.getText();
      this.HFI.ksV = this.IeD.getText();
      this.HFI.fuD = this.IeE.getText();
      String str = com.tencent.mm.wallet_core.ui.f.bpt(this.HFI.HQc);
      getInput().putString("key_mobile", str);
      localObject1 = getInput();
      label736:
      Object localObject2;
      if (this.HRy.HQg == 2)
      {
        bool = true;
        ((Bundle)localObject1).putBoolean("key_is_oversea", bool);
        this.HFI.HUP = this.HJY.getText();
        this.HFI.HTZ = this.Idq.getText();
        this.HFI.HUT = this.Iek.getText();
        localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
        if (localObject1 != null)
        {
          this.HFI.HUX = ((FavorPayInfo)localObject1).HXL;
          this.HFI.HUY = ((FavorPayInfo)localObject1).HXI;
        }
        this.HFI.HVd = ("+" + this.IeF.getCountryCode());
        this.HFI.HUj = this.mSelectCreCountIndex;
        if (this.Ifb != 9999) {
          break label1511;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "is long term");
        localObject1 = new TenpaySecureEncrypt();
        this.HFI.HUk = ((TenpaySecureEncrypt)localObject1).desedeEncode(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.Ifb), Integer.valueOf(this.Ifc), Integer.valueOf(this.Ifd) }), com.tencent.mm.wallet_core.ui.f.hhV());
        Log.d("MicroMsg.WalletCardElmentUI", "expire date: %s", new Object[] { this.Iev.getText() });
        this.HFI.HUo = this.Iew.getText();
        Log.d("MicroMsg.WalletCardElmentUI", "birth date: %s", new Object[] { this.Iew.getText() });
        localObject2 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new RealNameBundle();
        }
        ((RealNameBundle)localObject1).HTZ = this.Idq.getText();
        ((RealNameBundle)localObject1).fuA = (this.Ifn + 1);
        ((RealNameBundle)localObject1).HUf = this.countryCode;
        ((RealNameBundle)localObject1).HUg = this.provinceCode;
        ((RealNameBundle)localObject1).HUh = this.cityCode;
        ((RealNameBundle)localObject1).HUv = this.Ier.getText();
        ((RealNameBundle)localObject1).HUe = this.HRz;
        ((RealNameBundle)localObject1).HUs = this.IeX;
        ((RealNameBundle)localObject1).HUo = this.Iew.getText();
        ((RealNameBundle)localObject1).HUc = this.HKd;
        ((RealNameBundle)localObject1).HUd = this.Ien.getText();
        ((RealNameBundle)localObject1).HUa = "";
        ((RealNameBundle)localObject1).HUb = this.HJY.getText();
        ((RealNameBundle)localObject1).HUw = this.Ieu.getText();
        ((RealNameBundle)localObject1).HUk = this.Iev.getText();
        ((RealNameBundle)localObject1).HUj = this.mSelectCreCountIndex;
        getInput().putParcelable("realname_verify_process_bundle", (Parcelable)localObject1);
        Log.d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", new Object[] { Integer.valueOf(this.HFI.HUj), this.HFI.HUk, this.HFI.HUo });
        if ((fSJ()) && (!Util.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!Util.isNullOrNil(getInput().getString("key_true_name"))))
        {
          Log.i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
          this.HFI.HUP = getInput().getString("key_identity");
          this.HFI.HUQ = getInput().getInt("key_id_type", -1);
          this.HFI.HTZ = this.mTrueName;
          Log.i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.HFI.HTZ);
        }
        Log.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.HFI.BDB + " elemt.bankcardTag : " + this.HRy.HQg);
        Log.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.HRy.HQg);
        localObject2 = getInput();
        ((Bundle)localObject2).putString("key_mobile", str);
        ((Bundle)localObject2).putParcelable("key_authen", this.HFI);
        ((Bundle)localObject2).putString("key_bank_phone", this.HRy.HXo);
        ((Bundle)localObject2).putString("key_country_code", this.countryCode);
        ((Bundle)localObject2).putString("key_province_code", this.provinceCode);
        ((Bundle)localObject2).putString("key_city_code", this.cityCode);
        ((Bundle)localObject2).putParcelable("key_profession", this.HRz);
        ((Bundle)localObject2).putString("key_country_iso", this.IeX);
        ((Bundle)localObject2).putString("key_bind_card_type", this.HFI.dDj);
        ((Bundle)localObject2).putString("key_bind_card_show1", this.HRy.ynT);
        if (2 != this.HRy.HXl) {
          break label1528;
        }
      }
      label1487:
      label1511:
      label1528:
      for (localObject1 = getString(2131767664);; localObject1 = getString(2131767684))
      {
        ((Bundle)localObject2).putString("key_bind_card_show2", (String)localObject1);
        localObject1 = ((Bundle)localObject2).getString("key_bind_card_user_token", null);
        if (!Util.isNullOrNil((String)localObject1))
        {
          this.HFI.HVe = 1;
          this.HFI.HQm = ((String)localObject1);
        }
        this.HFI.HVf = ((Bundle)localObject2).getString("kreq_token");
        if (!getNetController().r(new Object[] { this.HFI, this.CwO })) {
          break label1539;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
        AppMethodBeat.o(70808);
        return;
        bool = false;
        break;
        ((FavorPayInfo)localObject1).HXI = this.HGS.cG(((FavorPayInfo)localObject1).HXI, false);
        break label168;
        bool = false;
        break label524;
        this.HFI.HUk = this.Iev.getText();
        break label736;
      }
      Log.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70808);
      return;
    }
  }
  
  private void fSI()
  {
    AppMethodBeat.i(70818);
    Object localObject;
    if ((this.HRy != null) && (this.IeI != null) && (this.IeI.containsKey(this.HRy.dDj)))
    {
      localObject = (d.a)this.IeI.get(this.HRy.dDj);
      if ((localObject == null) || (((d.a)localObject).IcR == null)) {
        break label133;
      }
    }
    label133:
    for (double d = ((d.a)localObject).IcS;; d = 0.0D)
    {
      localObject = getString(2131767533, new Object[] { com.tencent.mm.wallet_core.ui.f.D(d) });
      this.Ieh.setText((CharSequence)localObject);
      this.Ieh.setVisibility(0);
      AppMethodBeat.o(70818);
      return;
      this.Ieh.setVisibility(8);
      AppMethodBeat.o(70818);
      return;
    }
  }
  
  private boolean fSJ()
  {
    AppMethodBeat.i(70819);
    boolean bool = getInput().getBoolean("key_is_forgot_process", false);
    AppMethodBeat.o(70819);
    return bool;
  }
  
  private boolean fSK()
  {
    AppMethodBeat.i(174523);
    com.tencent.mm.wallet_core.d locald = getProcess();
    if ((locald != null) && ("realname_verify_process".equals(locald.dKC())))
    {
      if (locald.dQL.getInt("real_name_verify_mode", 0) == 4)
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
  
  private void is(boolean paramBoolean)
  {
    AppMethodBeat.i(70803);
    if (this.HRy == null) {
      this.HRy = new ElementQuery();
    }
    Log.i("MicroMsg.WalletCardElmentUI", "element: %s, %s", new Object[] { this.HRy.ynT, this.HRy.dDj });
    fSG();
    fSI();
    com.tencent.mm.wallet_core.a.by(this);
    Object localObject1 = (Bankcard)getInput().getParcelable("key_bankcard");
    Object localObject2;
    Object localObject3;
    if ((fSJ()) && (localObject1 != null))
    {
      this.IeH.setHint(getString(2131767573, new Object[] { ((Bankcard)localObject1).field_bankcardTail }));
      localObject1 = this.IeH;
      localObject2 = this.Iea;
      localObject3 = this.Ieb;
      a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
      localObject1 = this.Iej;
      localObject2 = this.Iec;
      localObject3 = this.Ied;
      a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
    }
    for (;;)
    {
      if (paramBoolean) {
        fSF();
      }
      this.IeP = false;
      this.IeQ = false;
      this.IeS = false;
      this.IeT = false;
      if (!fSK()) {
        break;
      }
      localObject1 = this.HSB.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (djv)((Iterator)localObject1).next();
        if (((djv)localObject2).MNM.key == this.HKd)
        {
          this.IeP = ((djv)localObject2).MNQ;
          this.IeQ = ((djv)localObject2).MNP;
          this.IeR = ((djv)localObject2).MNT;
          this.IeS = ((djv)localObject2).MNR;
          this.Ifm = ((djv)localObject2).MNV;
          this.IeO = ((djv)localObject2).MNN;
          this.IeN = ((djv)localObject2).MNO;
          this.IeU = ((djv)localObject2).MNS;
          this.IeT = true;
        }
      }
      if (!Util.isNullOrNil(this.HRy.ynT))
      {
        this.Iej.setText(this.HRy.ynT);
        if (!this.HRy.fQd()) {
          break label561;
        }
        this.IeY.setVisibility(0);
        this.IeY.setText(getString(2131767664));
      }
      for (;;)
      {
        localObject1 = this.IeH;
        localObject2 = this.Iea;
        localObject3 = this.Ieb;
        a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        localObject1 = this.Iej;
        localObject2 = this.Iec;
        localObject3 = this.Ied;
        a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
        this.IeH.setOnInfoIvClickListener(this.Ifq);
        if (!t.fQI().fRs().fQZ()) {
          break label596;
        }
        this.IeH.getInfoIv().setImageResource(2131691739);
        this.IeH.getInfoIv().setVisibility(0);
        break;
        label561:
        if (this.HRy.fQr())
        {
          this.IeY.setVisibility(0);
          this.IeY.setText(getString(2131767684));
        }
      }
      label596:
      this.IeH.getInfoIv().setVisibility(4);
    }
    Object localObject4;
    WalletFormView localWalletFormView1;
    WalletFormView localWalletFormView2;
    TextView localTextView1;
    TextView localTextView2;
    boolean bool1;
    boolean bool2;
    if ((this.HRy.HXG != null) && (!this.HRy.HXG.isEmpty()))
    {
      Log.i("MicroMsg.WalletCardElmentUI", "identity type： %s", new Object[] { Integer.valueOf(this.HKd) });
      localObject1 = this.HRy.HXG.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CreTypeRuleInfo)((Iterator)localObject1).next();
        if (((CreTypeRuleInfo)localObject2).HWK == this.HKd)
        {
          if (((CreTypeRuleInfo)localObject2).HWL.HWG == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show cre count");
            this.IeP = true;
          }
          if (((CreTypeRuleInfo)localObject2).HWL.HWI == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show cre expire");
            this.IeQ = true;
          }
          if (((CreTypeRuleInfo)localObject2).HWL.HWH == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show birthday");
            this.IeS = true;
          }
          if (((CreTypeRuleInfo)localObject2).HWL.HWJ == 1)
          {
            Log.i("MicroMsg.WalletCardElmentUI", "need show cre type");
            if (t.fQI().fRu() > 0)
            {
              Log.i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
              this.IeT = true;
            }
          }
        }
      }
      if ((this.HKd == 2) && (this.IeV))
      {
        this.IeU = true;
        if (!this.IeQ)
        {
          this.Ifb = 0;
          this.Ifc = 0;
          this.Ifd = 0;
        }
        if (!this.IeS)
        {
          this.Ifh = 0;
          this.Ifi = 0;
          this.Ifj = 0;
        }
        if (!this.IeP) {
          this.mSelectCreCountIndex = 0;
        }
        this.Iem.setVisibility(8);
        if (!Bankcard.aeI(this.HRy.HQg)) {
          break label1497;
        }
        localObject1 = this.Idq;
        localObject2 = this.Ien;
        localObject3 = this.HJY;
        localObject4 = this.Iet;
        localWalletFormView1 = this.Ieu;
        localWalletFormView2 = this.Iev;
        localTextView1 = this.HJZ;
        localTextView2 = this.HKa;
        a(new boolean[] { 0, 0, 0, 0, 0, 0 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.Ieo.setVisibility(8);
        yl(true);
        paramBoolean = this.IeS;
        bool1 = this.IeU;
        bool2 = this.Ifm;
        localObject1 = this.Ieq;
        localObject2 = this.Ier;
        localObject3 = this.Iep;
        localObject4 = this.Iew;
        localWalletFormView1 = this.Iex;
        localWalletFormView2 = this.Ies;
        localTextView1 = this.Iei;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        paramBoolean = this.HRy.HXf;
        bool1 = this.HRy.HXg;
        localObject1 = this.Iel;
        localObject2 = this.Iek;
        localObject3 = this.Iee;
        localObject4 = this.Ief;
        a(new boolean[] { paramBoolean, bool1 }, new WalletFormView[] { localObject1, localObject2 }, (TextView)localObject3, (TextView)localObject4);
        if (this.Iej.getVisibility() != 0) {
          break label2960;
        }
        switch (this.HRy.HXk)
        {
        default: 
          this.Ied.setVisibility(8);
          label1325:
          this.Ied.setTextColor(getResources().getColor(2131100900));
        }
      }
    }
    for (;;)
    {
      if ((!Util.isNullOrNil(this.HRy.HXE)) && (this.Ied.getVisibility() != 0))
      {
        Log.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
        this.Ied.setText(this.HRy.HXE);
        this.Ied.setVisibility(0);
      }
      if ((Util.isNullOrNil(this.HRy.HXp)) || (!ab.IS(this.HRy.HXp)) || (fSJ())) {
        break label2972;
      }
      this.IeL.setText(this.HRy.HXq);
      this.IeL.setVisibility(0);
      AppMethodBeat.o(70803);
      return;
      this.IeU = false;
      break;
      if ((this.HKd == 2) && (this.IeV))
      {
        this.IeU = true;
        break;
      }
      this.IeU = false;
      break;
      label1497:
      int i;
      if ((this.HRy.fQs() != null) && (this.HRy.fQs().size() > 0))
      {
        i = 1;
        label1524:
        if ((!fSJ()) && (!t.fQI().fRm())) {
          break label2440;
        }
        localObject2 = t.fQI().getTrueName();
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          localObject1 = localObject2;
          if (getProcess() != null) {
            localObject1 = getProcess().dQL.getString("key_true_name");
          }
        }
        if (Util.isNullOrNil((String)localObject1)) {
          break label2252;
        }
        localObject1 = getString(2131767623, new Object[] { com.tencent.mm.wallet_core.ui.f.bps((String)localObject1) });
        this.Idq.setHint((CharSequence)localObject1);
        this.Iem.setHint((CharSequence)localObject1);
        label1633:
        if ((!fSJ()) || (Util.isNullOrNil(getInput().getString("key_identity"))) || (getInput().getInt("key_id_type", -1) == -1) || (Util.isNullOrNil(getInput().getString("key_true_name")))) {
          break label2282;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
        paramBoolean = this.IeP;
        bool1 = this.IeR;
        bool2 = this.IeQ;
        localObject1 = this.Idq;
        localObject2 = this.Ien;
        localObject3 = this.HJY;
        localObject4 = this.Iet;
        localWalletFormView1 = this.Ieu;
        localWalletFormView2 = this.Iev;
        localTextView1 = this.HJZ;
        localTextView2 = this.HKa;
        a(new boolean[] { false, false, false, paramBoolean, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
        this.mTrueName = getInput().getString("key_true_name");
        Log.i("MicroMsg.WalletCardElmentUI", "name is " + this.mTrueName);
        this.Ieo.setVisibility(0);
        if (this.Ids != null)
        {
          if (!Util.isNullOrNil(this.Ids.field_mobile)) {
            d(this.Ieo, this.Ids.field_mobile);
          }
          if (!Util.isNullOrNil(this.Ids.HUS)) {
            d(this.Iel, this.Ids.HUS);
          }
          if (!Util.isNullOrNil(this.Ids.HVz)) {
            d(this.Iek, this.Ids.HVz);
          }
        }
        if (!this.HRy.HXd) {
          break label2681;
        }
        this.HKa.setText("");
      }
      for (;;)
      {
        if (!Util.isNullOrNil(this.HRy.HXh)) {
          this.HJY.setText(this.HRy.HXh);
        }
        if (t.fQI().fRu() <= 0) {
          break label2698;
        }
        Log.i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", new Object[] { Integer.valueOf(t.fQI().fRu()) });
        this.Ien.setClickable(false);
        this.Ien.setText(t.fQQ().hM(this));
        this.Ien.setInputEnable(false);
        a(this.HJY, this.HKd);
        yl(false);
        paramBoolean = this.Ifm;
        bool1 = this.IeN;
        bool2 = this.IeN;
        boolean bool3 = this.IeO;
        boolean bool4 = this.IeS;
        boolean bool5 = this.IeU;
        localObject1 = this.Ies;
        localObject2 = this.Ieq;
        localObject3 = this.Ier;
        localObject4 = this.Iep;
        localWalletFormView1 = this.Iew;
        localWalletFormView2 = this.Iex;
        localTextView1 = this.Iei;
        a(new boolean[] { paramBoolean, bool1, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, null);
        break;
        i = 0;
        break label1524;
        label2252:
        localObject1 = getString(2131767622);
        this.Idq.setHint((CharSequence)localObject1);
        this.Iem.setHint((CharSequence)localObject1);
        break label1633;
        label2282:
        if ((this.IeT) || (i != 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool1 = this.IeP;
          bool2 = this.IeR;
          bool3 = this.IeQ;
          localObject1 = this.Idq;
          localObject2 = this.Ien;
          localObject3 = this.HJY;
          localObject4 = this.Iet;
          localWalletFormView1 = this.Ieu;
          localWalletFormView2 = this.Iev;
          localTextView1 = this.HJZ;
          localTextView2 = this.HKa;
          a(new boolean[] { true, paramBoolean, true, bool1, bool2, bool3 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          break;
        }
        label2440:
        bool1 = this.HRy.HXd;
        if ((this.IeT) || ((i != 0) && (this.HRy.HXe))) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          bool2 = this.HRy.HXe;
          bool3 = this.IeP;
          bool4 = this.IeR;
          bool5 = this.IeQ;
          localObject1 = this.Idq;
          localObject2 = this.Ien;
          localObject3 = this.HJY;
          localObject4 = this.Iet;
          localWalletFormView1 = this.Ieu;
          localWalletFormView2 = this.Iev;
          localTextView1 = this.HJZ;
          localTextView2 = this.HKa;
          a(new boolean[] { bool1, paramBoolean, bool2, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView1, localWalletFormView2 }, localTextView1, localTextView2);
          this.Ieo.setVisibility(0);
          Log.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.HRy.HXd + " canModifyIdentity:" + this.HRy.HXe);
          break;
        }
        label2681:
        this.HKa.setText(getString(2131767579));
      }
      label2698:
      if (this.HRy.fQs() != null)
      {
        i = this.HRy.fQs().size();
        label2721:
        Log.i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", new Object[] { Integer.valueOf(i) });
        if (i > 1) {
          break label2876;
        }
        this.Ien.setClickable(false);
        this.Ien.setInputEnable(false);
        this.HJY.setInputEnable(true);
      }
      for (;;)
      {
        localObject1 = this.HRy.fQs();
        if ((localObject1 == null) || (!((List)localObject1).contains(Integer.valueOf(this.HKd)))) {
          this.HKd = 1;
        }
        if (!t.fQQ().av(this, this.HKd).equals(this.Ifk)) {
          com.tencent.mm.plugin.report.service.h.CyF.a(16816, new Object[] { Integer.valueOf(this.HKd) });
        }
        this.Ien.setText(t.fQQ().av(this, this.HKd));
        break;
        i = 0;
        break label2721;
        label2876:
        this.Ien.setClickable(true);
        this.Ien.setInputEnable(true);
        this.HJY.setInputEnable(true);
      }
      this.Ied.setText(2131767539);
      this.Ied.setVisibility(0);
      break label1325;
      this.Ied.setVisibility(8);
      break label1325;
      this.Ied.setVisibility(8);
      break label1325;
      this.Ied.setVisibility(8);
      break label1325;
      label2960:
      this.Ied.setVisibility(8);
    }
    label2972:
    this.IeL.setVisibility(8);
    AppMethodBeat.o(70803);
  }
  
  private void yl(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(70805);
    if (paramBoolean)
    {
      Object localObject = this.EIm;
      if (this.HRy.HXs)
      {
        i = 0;
        ((TextView)localObject).setVisibility(i);
        localObject = this.Iey;
        if (!this.HRy.HXs) {
          break label225;
        }
        i = 0;
        label54:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.Iez;
        if (!this.HRy.HXt) {
          break label231;
        }
        i = 0;
        label78:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.IeA;
        if (!this.HRy.HXu) {
          break label237;
        }
        i = 0;
        label102:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.IeB;
        if (!this.HRy.HXx) {
          break label243;
        }
        i = 0;
        label126:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.IeC;
        if (!this.HRy.HXz) {
          break label249;
        }
        i = 0;
        label150:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.IeD;
        if (!this.HRy.HXy) {
          break label255;
        }
        i = 0;
        label174:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.IeE;
        if (!this.HRy.HXA) {
          break label261;
        }
      }
      label261:
      for (int i = j;; i = 8)
      {
        ((WalletFormView)localObject).setVisibility(i);
        this.Ieg.setVisibility(4);
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
    this.EIm.setVisibility(8);
    this.Iey.setVisibility(8);
    this.Iez.setVisibility(8);
    this.IeA.setVisibility(8);
    this.IeB.setVisibility(8);
    this.IeC.setVisibility(8);
    this.IeD.setVisibility(8);
    this.IeE.setVisibility(8);
    this.Ieg.setVisibility(8);
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
    return 2131496909;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70800);
    this.Iea = ((TextView)findViewById(2131310171));
    this.IeH = ((WalletFormView)findViewById(2131310169));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.IeH);
    this.Ieb = ((TextView)findViewById(2131310170));
    this.HJZ = ((TextView)findViewById(2131310173));
    this.Idq = ((WalletFormView)findViewById(2131305216));
    this.Iem = ((WalletFormView)findViewById(2131301698));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Idq);
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Iem);
    this.Ien = ((WalletFormView)findViewById(2131310192));
    this.HJY = ((WalletFormView)findViewById(2131302521));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.HJY);
    this.HKa = ((TextView)findViewById(2131310172));
    this.Iec = ((TextView)findViewById(2131310162));
    this.Iej = ((WalletFormView)findViewById(2131310174));
    this.IeY = ((WalletFormView)findViewById(2131310178));
    this.Ied = ((TextView)findViewById(2131310163));
    this.Ieh = ((TextView)findViewById(2131310167));
    this.Iee = ((TextView)findViewById(2131310165));
    this.Iel = ((WalletFormView)findViewById(2131299398));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.Iel);
    this.Iek = ((WalletFormView)findViewById(2131299413));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.Iek);
    this.Ief = ((TextView)findViewById(2131310164));
    this.EIm = ((TextView)findViewById(2131310160));
    this.Iey = ((WalletFormView)findViewById(2131301552));
    this.Iez = ((WalletFormView)findViewById(2131303014));
    this.IeA = ((WalletFormView)findViewById(2131297042));
    this.IeB = ((WalletFormView)findViewById(2131296553));
    this.IeC = ((WalletFormView)findViewById(2131305878));
    this.IeD = ((WalletFormView)findViewById(2131306062));
    this.IeE = ((WalletFormView)findViewById(2131299941));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.IeE);
    this.Ieg = ((TextView)findViewById(2131310159));
    this.IeK = ((CheckBox)findViewById(2131296592));
    this.IeL = ((CheckBox)findViewById(2131296589));
    this.gxv = ((Button)findViewById(2131305423));
    this.gxx = ((ScrollView)findViewById(2131310296));
    this.Iep = ((WalletFormView)findViewById(2131306143));
    this.Ieq = ((WalletFormView)findViewById(2131306135));
    this.Ier = ((WalletFormView)findViewById(2131306134));
    this.Ies = ((WalletFormView)findViewById(2131306144));
    this.Iet = ((WalletFormView)findViewById(2131310189));
    this.Ieu = ((WalletFormView)findViewById(2131310190));
    this.Iev = ((WalletFormView)findViewById(2131310191));
    this.Iew = ((WalletFormView)findViewById(2131306136));
    this.Iex = ((WalletFormView)findViewById(2131306137));
    this.Iei = ((TextView)findViewById(2131310176));
    this.IeF = ((WalletPhoneInputView)findViewById(2131304758));
    this.Ieo = this.IeF.getPhoneNumberEt();
    this.Idq.setOnInputValidChangeListener(this);
    this.Iem.setOnInputValidChangeListener(this);
    this.IeH.setOnInputValidChangeListener(this);
    this.Ien.setOnInputValidChangeListener(this);
    this.HJY.setOnInputValidChangeListener(this);
    this.Ieo.setOnInputValidChangeListener(new WalletFormView.a()
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
    this.Iel.setOnInputValidChangeListener(this);
    this.Iek.setOnInputValidChangeListener(this);
    this.Iey.setOnInputValidChangeListener(this);
    this.Iez.setOnInputValidChangeListener(this);
    this.IeA.setOnInputValidChangeListener(this);
    this.IeB.setOnInputValidChangeListener(this);
    this.IeC.setOnInputValidChangeListener(this);
    this.IeD.setOnInputValidChangeListener(this);
    this.IeE.setOnInputValidChangeListener(this);
    this.Iep.setOnInputValidChangeListener(this);
    this.Ieq.setOnInputValidChangeListener(this);
    this.Idq.setOnEditorActionListener(this);
    this.Iem.setOnEditorActionListener(this);
    this.IeH.setOnEditorActionListener(this);
    this.Ien.setOnEditorActionListener(this);
    this.HJY.setOnEditorActionListener(this);
    this.Ieo.setOnEditorActionListener(this);
    this.Iel.setOnEditorActionListener(this);
    this.Iek.setOnEditorActionListener(this);
    this.Iey.setOnEditorActionListener(this);
    this.Iez.setOnEditorActionListener(this);
    this.IeA.setOnEditorActionListener(this);
    this.IeB.setOnEditorActionListener(this);
    this.IeC.setOnEditorActionListener(this);
    this.IeD.setOnEditorActionListener(this);
    this.IeE.setOnEditorActionListener(this);
    this.Ieq.setOnEditorActionListener(this);
    this.Iep.setOnEditorActionListener(this);
    this.Iej.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70786);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardElementUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putInt("key_bind_scene", WalletCardElementUI.this.getInput().getInt("key_bind_scene", -1));
        Util.isNullOrNil(WalletCardElementUI.c(WalletCardElementUI.this).getText());
        WalletCardElementUI.this.hideTenpayKB();
        localObject = com.tencent.mm.wallet_core.a.by(WalletCardElementUI.this);
        if (localObject != null) {
          ((com.tencent.mm.wallet_core.d)localObject).a(WalletCardElementUI.this, WalletBankCardSelectUI.class, paramAnonymousView, 1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70786);
      }
    });
    this.IeY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70788);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(WalletCardElementUI.this.getString(2131767684));
        paramAnonymousView.add(WalletCardElementUI.this.getString(2131767664));
        if (WalletCardElementUI.d(WalletCardElementUI.this).size() == 1)
        {
          localObject = (ElementQuery)WalletCardElementUI.d(WalletCardElementUI.this).get(0);
          if (!((ElementQuery)localObject).fQr()) {
            break label178;
          }
          paramAnonymousView.remove(1);
        }
        for (;;)
        {
          paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), paramAnonymousView);
          paramAnonymousView.app(WalletCardElementUI.e(WalletCardElementUI.this));
          paramAnonymousView.QTc = new c.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(70787);
              paramAnonymousView.hide();
              if (paramAnonymous2Boolean)
              {
                paramAnonymous2Object1 = (String)paramAnonymous2Object1;
                WalletCardElementUI.f(WalletCardElementUI.this).setText(paramAnonymous2Object1);
                if (!paramAnonymous2Object1.equals(WalletCardElementUI.this.getString(2131767664))) {
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
                  if (((i != 0) && (paramAnonymous2Object2.fQr())) || ((i == 0) && (paramAnonymous2Object2.fQd())))
                  {
                    WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymous2Object2);
                    WalletCardElementUI.g(WalletCardElementUI.this);
                  }
                }
                WalletCardElementUI.a(WalletCardElementUI.this, paramAnonymousView.hci());
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
          if (((ElementQuery)localObject).fQd()) {
            paramAnonymousView.remove(0);
          }
        }
      }
    });
    this.Ien.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70789);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletCardElementUI.h(WalletCardElementUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70789);
      }
    });
    this.Iet.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), WalletCardElementUI.i(WalletCardElementUI.this));
        paramAnonymousView.QTc = new c.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(70790);
            if (paramAnonymous2Boolean)
            {
              WalletCardElementUI.j(WalletCardElementUI.this).setText((String)paramAnonymous2Object1);
              WalletCardElementUI.b(WalletCardElementUI.this, paramAnonymousView.hci());
              WalletCardElementUI.b(WalletCardElementUI.this);
            }
            paramAnonymousView.hide();
            AppMethodBeat.o(70790);
          }
        };
        paramAnonymousView.app(WalletCardElementUI.k(WalletCardElementUI.this));
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70791);
      }
    });
    this.Ieu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70793);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
        paramAnonymousView.QSU = new b.a()
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
        paramAnonymousView.aZ(i, j, k);
        localObject = WalletCardElementUI.l(WalletCardElementUI.this).getContentEt().getText().toString();
        if ((WalletCardElementUI.m(WalletCardElementUI.this) > 0) && (WalletCardElementUI.n(WalletCardElementUI.this) > 0) && (WalletCardElementUI.o(WalletCardElementUI.this) > 0)) {
          paramAnonymousView.aX(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
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
            paramAnonymousView.aX(WalletCardElementUI.m(WalletCardElementUI.this), WalletCardElementUI.n(WalletCardElementUI.this), WalletCardElementUI.o(WalletCardElementUI.this));
          }
        }
      }
    });
    this.Iev.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70794);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
        paramAnonymousView.QSU = new b.a()
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
              WalletCardElementUI.p(WalletCardElementUI.this).setText(WalletCardElementUI.this.getString(2131768509));
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
        paramAnonymousView.aY(i, j, k);
        paramAnonymousView.aZ(i + 200, 12, 31);
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
            break label340;
          }
          paramAnonymousView.aX(1, 1, 1);
        }
        for (;;)
        {
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70794);
          return;
          if (!((String)localObject).equals(WalletCardElementUI.this.getString(2131768509))) {
            break;
          }
          WalletCardElementUI.f(WalletCardElementUI.this, 9999);
          WalletCardElementUI.g(WalletCardElementUI.this, 12);
          WalletCardElementUI.h(WalletCardElementUI.this, 31);
          break;
          label340:
          paramAnonymousView.aX(WalletCardElementUI.q(WalletCardElementUI.this), WalletCardElementUI.r(WalletCardElementUI.this), WalletCardElementUI.s(WalletCardElementUI.this));
        }
      }
    });
    this.Ies.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(70795);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = WalletCardElementUI.this.getResources().getStringArray(2130903104);
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WalletCardElementUI.this.getContext(), paramAnonymousView);
        paramAnonymousView.QTc = new c.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(174522);
            if (paramAnonymous2Boolean)
            {
              WalletCardElementUI.t(WalletCardElementUI.this).setText((String)paramAnonymous2Object1);
              if (!((String)paramAnonymous2Object1).equalsIgnoreCase(WalletCardElementUI.this.getString(2131765721))) {
                break label90;
              }
              WalletCardElementUI.i(WalletCardElementUI.this, 0);
            }
            for (;;)
            {
              paramAnonymousView.app(WalletCardElementUI.u(WalletCardElementUI.this));
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
    this.Ieq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70797);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("GetAddress", true);
        paramAnonymousView.putExtra("ShowSelectedLocation", false);
        if (!Bankcard.aeI(WalletCardElementUI.v(WalletCardElementUI.this).HQg))
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
        com.tencent.mm.br.c.c(WalletCardElementUI.this.getContext(), ".ui.tools.MultiStageCitySelectUI", paramAnonymousView, 4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70797);
      }
    });
    this.Iep.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70774);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent(WalletCardElementUI.this.getContext(), WalletSelectProfessionUI.class);
        paramAnonymousView.putExtra("key_profession_list", WalletCardElementUI.x(WalletCardElementUI.this));
        WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 5);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70774);
      }
    });
    this.Iew.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(174512);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
        paramAnonymousView.QSU = new b.a()
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
          paramAnonymousView.aX(WalletCardElementUI.z(WalletCardElementUI.this), WalletCardElementUI.A(WalletCardElementUI.this), WalletCardElementUI.B(WalletCardElementUI.this));
        }
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174512);
      }
    });
    this.Iex.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70776);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WalletCardElementUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        paramAnonymousView.putExtra("exclude_countries_iso", WalletCardElementUI.w(WalletCardElementUI.this));
        paramAnonymousView.putExtra("CountryCodeUI_isShowCountryCode", false);
        paramAnonymousView.putExtra("ui_title", WalletCardElementUI.this.getString(2131768312));
        WalletCardElementUI.this.startActivityForResult(paramAnonymousView, 6);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70776);
      }
    });
    this.IeK.setChecked(true);
    this.IeK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(174513);
        WalletCardElementUI.b(WalletCardElementUI.this);
        AppMethodBeat.o(174513);
      }
    });
    findViewById(2131296587).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70778);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.wallet_core.ui.f.b(WalletCardElementUI.this, WalletCardElementUI.v(WalletCardElementUI.this).dDj, WalletCardElementUI.v(WalletCardElementUI.this).ynT, false, WalletCardElementUI.v(WalletCardElementUI.this).HXD);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70778);
      }
    });
    this.IeA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174514);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
        if (Bankcard.aeI(WalletCardElementUI.v(WalletCardElementUI.this).HQg)) {
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
    this.Ier.setOnInputValidChangeListener(this);
    this.gxv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174515);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletCardElementUI.C(WalletCardElementUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174515);
      }
    });
    setEditFocusListener(this.IeH, 0, false, false, true);
    setEditFocusListener(this.HJY, 1, false, false, true);
    setEditFocusListener(this.Ieo, 0, false, false, true);
    if ((this.HRy != null) && (!Util.isNullOrNil(this.HRy.HXr)))
    {
      com.tencent.mm.ui.base.h.a(this, this.HRy.HXr, null, true, null);
      this.HRy = null;
    }
    for (;;)
    {
      is(true);
      bqg();
      Object localObject = com.tencent.mm.wallet_core.a.by(this);
      if ((localObject == null) || (!((com.tencent.mm.wallet_core.d)localObject).hgK())) {
        break label1478;
      }
      localObject = (Orders)getInput().getParcelable("key_orders");
      if ((localObject == null) || (((Orders)localObject).HYN != 1)) {
        break;
      }
      this.IeJ = true;
      this.Idq.setText(com.tencent.mm.wallet_core.ui.f.bps(((Orders)localObject).HTZ));
      this.Idq.setEnabled(false);
      this.Idq.setFocusable(false);
      this.HKd = ((Orders)localObject).HYO;
      this.Ien.setText(t.fQQ().av(this, this.HKd));
      this.Ien.setEnabled(false);
      this.HJY.setText(((Orders)localObject).HXh);
      this.HJY.setInputEnable(false);
      this.HJY.setFocusable(false);
      this.HJZ.setText(2131767532);
      AppMethodBeat.o(70800);
      return;
      if ((getInput().getInt("key_bind_scene", -1) == 5) && (!this.HRy.HXH))
      {
        com.tencent.mm.ui.base.h.a(this, getString(2131768424), null, true, null);
        this.HRy.ynT = null;
      }
    }
    this.IeJ = false;
    label1478:
    AppMethodBeat.o(70800);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70810);
    Log.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (this.IeF.g(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(70810);
      return;
    }
    if ((paramInt1 == 6) && (paramInt2 == 100))
    {
      if (!Util.isNullOrNil(paramIntent.getStringExtra("country_name")))
      {
        this.IeX = paramIntent.getStringExtra("iso_code");
        this.Iex.setText(paramIntent.getStringExtra("country_name"));
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
      bqg();
      AppMethodBeat.o(70810);
      return;
      this.HRy = null;
      this.Ifa = 0;
      this.mSelectBankName = paramIntent.getStringExtra("bank_name");
      this.Iej.setText(this.mSelectBankName);
      this.IeY.setVisibility(0);
      this.IeY.setText("");
      aVO(this.mSelectBankName);
      if (this.IeZ.size() == 1) {
        this.HRy = ((ElementQuery)this.IeZ.get(0));
      }
      Log.i("MicroMsg.WalletCardElmentUI", "select bank: %s, %s", new Object[] { this.mSelectBankName, Integer.valueOf(this.IeZ.size()) });
      this.Ids = null;
      is(false);
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.IeM = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.yMR = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.yMS = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        if (Util.isNullOrNil(str1))
        {
          this.IeA.setText(str3 + " " + str4);
          label486:
          if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.HRy.HXy)) {
            break label709;
          }
          this.IeD.setVisibility(0);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", new Object[] { str1, str2, str3, str4, this.yMS });
        break;
        this.IeA.setText(str1 + " " + str4);
        break label486;
        if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.yMS = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.IeA.setText(str1 + " " + str3);
          break label486;
        }
        this.yMS = this.IeM;
        this.IeA.setText(str1);
        break label486;
        label709:
        this.IeD.setVisibility(8);
      }
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.IeH.set3DesValStr(paramIntent);
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
      this.Ieq.setText(paramIntent.toString());
      continue;
      this.HRz = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
      this.Iep.setText(this.HRz.HTX);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70799);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.HRy = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.CwO = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.HKd = t.fQI().fRu();
    this.Ids = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
    this.IeN = getInput().getBoolean("key_need_area", false);
    this.IeO = getInput().getBoolean("key_need_profession", false);
    this.IeV = getInput().getBoolean("key_need_country", false);
    this.IeW = getInput().getStringArray("key_country_excludes");
    if (this.HRy != null) {
      aVO(this.HRy.ynT);
    }
    Log.d("MicroMsg.WalletCardElmentUI", "neeCountry: %s", new Object[] { Boolean.valueOf(this.IeV) });
    if ((this.IeN) || (this.IeO)) {
      setMMTitle(2131767691);
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
      setMMTitle(2131767690);
    }
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    Log.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    this.HSD = new String[100];
    int i = 0;
    while (i < this.HSD.length)
    {
      this.HSD[i] = getString(2131767663, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    paramBundle = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
    if ((this.CwO != null) && (paramBundle != null))
    {
      this.HGS = e.IcT.a(this.CwO);
      if (this.HGS == null) {
        break label482;
      }
      paramBundle = this.HGS.aVL(paramBundle.HXI);
      this.IeI = this.HGS.aVG(paramBundle);
    }
    for (;;)
    {
      initView();
      this.gxx.pageScroll(33);
      com.tencent.mm.plugin.wallet_core.utils.f.b(this, getInput(), 3);
      EventCenter.instance.addListener(this.HJH);
      AppMethodBeat.o(70799);
      return;
      label482:
      Log.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70815);
    EventCenter.instance.removeListener(this.HJH);
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
      if (this.IeG == null) {
        fSH();
      }
      AppMethodBeat.o(70814);
      return false;
    }
    boolean bool1;
    if (this.IeG != null)
    {
      paramTextView = this.IeG;
      if (paramTextView.Rwe != null)
      {
        bool1 = paramTextView.Rwe.isFocusable();
        if (!bool1) {
          break label157;
        }
        paramTextView = this.IeG;
        bool1 = bool2;
        if (paramTextView.Rwe != null) {
          bool1 = paramTextView.Rwe.isClickable();
        }
        if ((!bool1) || (!this.IeG.hhZ())) {
          break label157;
        }
        this.IeG.hic();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70814);
      return true;
      bool1 = false;
      break;
      label157:
      this.IeG.performClick();
      continue;
      fSH();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70813);
    bqg();
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
      if ((paramq instanceof ad))
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