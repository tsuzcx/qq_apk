package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.ot;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.CreExtInfo;
import com.tencent.mm.plugin.wallet_core.model.CreTypeRuleInfo;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
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
  private String dXu;
  private String dXv;
  private Button fpF;
  private String iLj;
  private String lJI;
  private String lJJ;
  private PayInfo nDu = null;
  private Orders nEh = null;
  private TextView pcd;
  private WalletFormView qAx;
  private Bankcard qAy = null;
  private WalletFormView qBA;
  private WalletFormView qBB;
  private WalletFormView qBC;
  private WalletFormView qBD;
  private WalletFormView qBE;
  private WalletFormView qBF;
  private WalletFormView qBG;
  private WalletPhoneInputView qBH;
  private ScrollView qBI;
  private WalletFormView qBJ = null;
  private WalletFormView qBK;
  private Map<String, a.a> qBL = null;
  private boolean qBM = false;
  private CheckBox qBN;
  private CheckBox qBO;
  private String qBP;
  private boolean qBQ;
  private boolean qBR;
  private boolean qBS = false;
  private boolean qBT = false;
  private boolean qBU = false;
  private boolean qBV = false;
  private String qBW;
  private WalletFormView qBX;
  private List<ElementQuery> qBY = new ArrayList();
  private int qBZ;
  private TextView qBg;
  private TextView qBh;
  private TextView qBi;
  private TextView qBj;
  private TextView qBk;
  private TextView qBl;
  private TextView qBm;
  private TextView qBn;
  private TextView qBo;
  private WalletFormView qBp;
  private WalletFormView qBq;
  private WalletFormView qBr;
  private WalletFormView qBs;
  private WalletFormView qBt;
  private WalletFormView qBu;
  private WalletFormView qBv;
  private WalletFormView qBw;
  private WalletFormView qBx;
  private WalletFormView qBy;
  private WalletFormView qBz;
  private int qCa;
  private int qCb;
  private int qCc;
  private int qCd;
  private int qCe;
  private int qCf;
  private int qCg;
  private BaseAdapter qCh = new WalletCardElementUI.7(this);
  private View.OnClickListener qCi = new WalletCardElementUI.8(this);
  private Authen qmd = new Authen();
  a qnm = null;
  private com.tencent.mm.sdk.b.c qoS = new com.tencent.mm.sdk.b.c() {};
  private WalletFormView qpk;
  private TextView qpl;
  private TextView qpm;
  private int qpo = 1;
  private Profession[] qrb;
  private ElementQuery qsa = new ElementQuery();
  private Profession qsb;
  
  private void AS(int paramInt)
  {
    if (paramInt == 1)
    {
      a(this.qpk, 1, false, false);
      return;
    }
    a(this.qpk, 1, true, false);
  }
  
  private boolean YH()
  {
    WalletFormView localWalletFormView = this.qBJ;
    this.qBJ = null;
    if (!this.qBp.eq(null))
    {
      if ((this.qBJ == null) && (localWalletFormView != this.qBp)) {
        this.qBJ = this.qBp;
      }
      this.qBj.setText(a.i.wallet_card_bankcard_type_err_tips);
      this.qBj.setTextColor(getResources().getColor(a.c.red));
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (!this.qAx.eq(null))
      {
        if ((this.qBJ == null) && (localWalletFormView != this.qAx)) {
          this.qBJ = this.qAx;
        }
        bool1 = false;
      }
      if (!this.qBK.eq(this.qBh))
      {
        if ((this.qBJ == null) && (localWalletFormView != this.qBK)) {
          this.qBJ = this.qBK;
        }
        bool1 = false;
      }
      int i;
      if ((!this.qpk.eq(this.qpm)) && (!this.qBM))
      {
        if ((this.qBJ == null) && (localWalletFormView != this.qpk)) {
          this.qBJ = this.qpk;
        }
        this.qpm.setText(a.i.wallet_card_identify_err_hint);
        this.qpm.setTextColor(getResources().getColor(a.c.red));
        i = 1;
      }
      for (boolean bool2 = false;; bool2 = bool1)
      {
        bool1 = bool2;
        if (this.qBS)
        {
          bool1 = bool2;
          if (!this.qBx.eq(null))
          {
            if ((this.qBJ == null) && (localWalletFormView != this.qBx)) {
              this.qBJ = this.qBx;
            }
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (this.qBT)
        {
          bool2 = bool1;
          if (!this.qBy.eq(null))
          {
            if ((this.qBJ == null) && (localWalletFormView != this.qBy)) {
              this.qBJ = this.qBy;
            }
            bool2 = false;
          }
        }
        if (!this.qBu.eq(this.qpm)) {
          if (i != 0)
          {
            this.qpm.setText(a.i.wallet_card_err_id_phone);
            this.qpm.setTextColor(getResources().getColor(a.c.red));
            if ((this.qBJ == null) && (localWalletFormView != this.qBu)) {
              this.qBJ = this.qBu;
            }
            bool1 = false;
            label395:
            if (this.qpm.getVisibility() == 4)
            {
              if (!this.qsa.quX) {
                break label1057;
              }
              this.qpm.setText(getString(a.i.wallet_card_identify_first_tips));
              label430:
              this.qpm.setTextColor(getResources().getColor(a.c.hint_text_color));
              this.qpm.setVisibility(0);
            }
            if (this.qBr.eq(this.qBl)) {
              break label1111;
            }
            if ((this.qBJ == null) && (localWalletFormView != this.qBr)) {
              this.qBJ = this.qBr;
            }
            i = 1;
            bool1 = false;
          }
        }
        for (;;)
        {
          if (!this.qBq.eq(this.qBl))
          {
            if ((this.qBJ == null) && (localWalletFormView != this.qBq)) {
              this.qBJ = this.qBq;
            }
            bool2 = false;
          }
          for (;;)
          {
            if (!this.qBN.isChecked()) {
              bool2 = false;
            }
            if (!this.qBA.eq(this.qBm))
            {
              if ((this.qBJ == null) && (localWalletFormView != this.qBA)) {
                this.qBJ = this.qBA;
              }
              bool2 = false;
            }
            if (!this.qBB.eq(this.qBm))
            {
              if ((this.qBJ == null) && (localWalletFormView != this.qBB)) {
                this.qBJ = this.qBB;
              }
              bool2 = false;
            }
            if (!this.qBC.eq(this.qBm))
            {
              if ((this.qBJ == null) && (localWalletFormView != this.qBC)) {
                this.qBJ = this.qBC;
              }
              bool2 = false;
            }
            if (!this.qBD.eq(this.qBm))
            {
              if ((this.qBJ == null) && (localWalletFormView != this.qBD)) {
                this.qBJ = this.qBD;
              }
              bool2 = false;
            }
            if (!this.qBE.eq(this.qBm))
            {
              if ((this.qBJ == null) && (localWalletFormView != this.qBE)) {
                this.qBJ = this.qBE;
              }
              bool2 = false;
            }
            if (!this.qBF.eq(this.qBm))
            {
              if ((this.qBJ == null) && (localWalletFormView != this.qBF)) {
                this.qBJ = this.qBF;
              }
              bool2 = false;
            }
            if (!this.qBG.eq(this.qBm))
            {
              if ((this.qBJ == null) && (localWalletFormView != this.qBG)) {
                this.qBJ = this.qBG;
              }
              bool2 = false;
            }
            bool1 = bool2;
            if (this.qBR)
            {
              bool1 = bool2;
              if (!this.qBv.eq(null))
              {
                if ((this.qBJ == null) && (localWalletFormView != this.qBv)) {
                  this.qBJ = this.qBv;
                }
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (this.qBQ)
            {
              bool2 = bool1;
              if (!this.qBw.eq(null))
              {
                if ((this.qBJ == null) && (localWalletFormView != this.qBw)) {
                  this.qBJ = this.qBw;
                }
                bool2 = false;
              }
            }
            bool1 = bool2;
            if (this.qBU)
            {
              bool1 = bool2;
              if (!this.qBz.eq(null))
              {
                if ((this.qBJ == null) && (localWalletFormView != this.qBz)) {
                  this.qBJ = this.qBz;
                }
                bool1 = false;
              }
            }
            if (!bool1) {
              break label1093;
            }
            this.fpF.setEnabled(true);
            this.fpF.setClickable(true);
            if (localWalletFormView != null) {
              localWalletFormView.setImeOptions(1073741824);
            }
            return bool1;
            this.qpm.setText(a.i.wallet_card_err_phone);
            this.qpm.setTextColor(getResources().getColor(a.c.red));
            break;
            bool1 = bool2;
            if (i == 0) {
              break label395;
            }
            this.qpm.setVisibility(0);
            bool1 = bool2;
            break label395;
            label1057:
            this.qpm.setText(getString(a.i.wallet_card_identify_security));
            break label430;
            bool2 = bool1;
            if (i != 0)
            {
              this.qBl.setVisibility(4);
              bool2 = bool1;
            }
          }
          label1093:
          this.fpF.setEnabled(false);
          this.fpF.setClickable(false);
          return bool1;
          label1111:
          i = 0;
        }
        i = 0;
      }
    }
  }
  
  private static void a(WalletFormView paramWalletFormView, int paramInt)
  {
    paramWalletFormView = paramWalletFormView.getLogicDelegate();
    if ((paramWalletFormView instanceof com.tencent.mm.wallet_core.ui.formview.a.a)) {
      ((com.tencent.mm.wallet_core.ui.formview.a.a)paramWalletFormView).Jd(paramInt);
    }
  }
  
  private static void a(WalletFormView paramWalletFormView, String paramString)
  {
    if (!bk.bl(paramString))
    {
      KeyListener localKeyListener = paramWalletFormView.getKeyListener();
      paramWalletFormView.setKeyListener(null);
      paramWalletFormView.setEnabled(false);
      paramWalletFormView.setClickable(false);
      paramWalletFormView.setText(paramString);
      paramWalletFormView.setKeyListener(localKeyListener);
      paramWalletFormView.setVisibility(0);
      return;
    }
    paramWalletFormView.setVisibility(8);
  }
  
  private static void a(boolean[] paramArrayOfBoolean, WalletFormView[] paramArrayOfWalletFormView, TextView paramTextView1, TextView paramTextView2)
  {
    a(paramArrayOfBoolean, paramArrayOfWalletFormView, paramTextView1, paramTextView2, false);
  }
  
  private static void a(boolean[] paramArrayOfBoolean, WalletFormView[] paramArrayOfWalletFormView, TextView paramTextView1, TextView paramTextView2, boolean paramBoolean)
  {
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
        paramArrayOfWalletFormView[i].bvr();
      }
    }
    if (j != 0)
    {
      paramTextView1.setVisibility(0);
      if (paramTextView2 != null)
      {
        if (!paramBoolean) {
          break label89;
        }
        paramTextView2.setVisibility(8);
      }
    }
    label89:
    do
    {
      return;
      paramTextView2.setVisibility(4);
      return;
      paramTextView1.setVisibility(8);
    } while (paramTextView2 == null);
    paramTextView2.setVisibility(8);
  }
  
  private void aZ()
  {
    if (this.qsa == null) {
      this.qsa = new ElementQuery();
    }
    Object localObject1;
    if (this.qsa.qvz == 0)
    {
      this.qBH.bXj();
      if ((this.qsa == null) || (this.qBL == null) || (!this.qBL.containsKey(this.qsa.mOb))) {
        break label564;
      }
      localObject1 = (a.a)this.qBL.get(this.qsa.mOb);
      if ((localObject1 == null) || (((a.a)localObject1).qAa == null)) {
        break label2655;
      }
    }
    label145:
    label564:
    label1225:
    label1488:
    label2645:
    label2655:
    for (double d = ((a.a)localObject1).qAb;; d = 0.0D)
    {
      localObject1 = getString(a.i.wallet_card_bank_favor_tips, new Object[] { e.B(d) });
      this.qBn.setText((CharSequence)localObject1);
      this.qBn.setVisibility(0);
      com.tencent.mm.wallet_core.a.aj(this);
      localObject1 = (Bankcard)this.BX.getParcelable("key_bankcard");
      Object localObject2;
      Object localObject3;
      if ((bWz()) && (localObject1 != null))
      {
        this.qBK.setHint(getString(a.i.wallet_card_forgot_id_hint, new Object[] { ((Bankcard)localObject1).field_bankcardTail }));
        localObject1 = this.qBK;
        localObject2 = this.qBg;
        localObject3 = this.qBh;
        a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
        localObject1 = this.qBp;
        localObject2 = this.qBi;
        localObject3 = this.qBj;
        a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3);
      }
      for (;;)
      {
        this.qBS = false;
        this.qBT = false;
        this.qBU = false;
        this.qBV = false;
        if ((this.qsa.qvA == null) || (this.qsa.qvA.isEmpty())) {
          break label818;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "identity type： %s", new Object[] { Integer.valueOf(this.qpo) });
        localObject1 = this.qsa.qvA.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (CreTypeRuleInfo)((Iterator)localObject1).next();
          if (((CreTypeRuleInfo)localObject2).quB == this.qpo)
          {
            if (((CreTypeRuleInfo)localObject2).quC.qux == 1)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "need show cre count");
              this.qBS = true;
            }
            if (((CreTypeRuleInfo)localObject2).quC.quz == 1)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "need show cre expire");
              this.qBT = true;
            }
            if (((CreTypeRuleInfo)localObject2).quC.quy == 1)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "need show birthday");
              this.qBU = true;
            }
            if (((CreTypeRuleInfo)localObject2).quC.quA == 1)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "need show cre type");
              if (o.bVs().bVT() > 0)
              {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
                this.qBV = true;
              }
            }
          }
        }
        this.qBH.bXk();
        localObject1 = (EditText)this.qBH.findViewById(a.f.prefix_input_et);
        a(this.qBH.getPhoneNumberEt(), (EditText)localObject1, 0, false, false, true);
        break;
        this.qBn.setVisibility(8);
        break label145;
        if (!bk.bl(this.qsa.lnT))
        {
          this.qBp.setText(this.qsa.lnT);
          if (!this.qsa.bUS()) {
            break label769;
          }
          this.qBX.setVisibility(0);
          this.qBX.setText(getString(a.i.wallet_credit_card));
        }
        for (;;)
        {
          localObject1 = this.qBK;
          localObject2 = this.qBg;
          localObject3 = this.qBh;
          a(new boolean[] { false }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
          localObject1 = this.qBp;
          localObject2 = this.qBi;
          localObject3 = this.qBj;
          a(new boolean[] { true }, new WalletFormView[] { localObject1 }, (TextView)localObject2, (TextView)localObject3, true);
          this.qBK.setOnInfoIvClickListener(this.qCi);
          if (!o.bVs().bVR().bVG()) {
            break label804;
          }
          this.qBK.getInfoIv().setImageResource(a.h.wallet_scan_camera);
          this.qBK.getInfoIv().setVisibility(0);
          break;
          if (this.qsa.bVc())
          {
            this.qBX.setVisibility(0);
            this.qBX.setText(getString(a.i.wallet_deposit_card));
          }
        }
        this.qBK.getInfoIv().setVisibility(4);
      }
      if (!this.qBT)
      {
        this.qCb = 0;
        this.qCc = 0;
        this.qCd = 0;
      }
      if (!this.qBU)
      {
        this.qCe = 0;
        this.qCf = 0;
        this.qCg = 0;
      }
      if (!this.qBS) {
        this.qCa = 0;
      }
      this.qBs.setVisibility(8);
      Object localObject4;
      WalletFormView localWalletFormView;
      TextView localTextView1;
      TextView localTextView2;
      boolean bool1;
      boolean bool2;
      if (Bankcard.AM(this.qsa.qqY))
      {
        localObject1 = this.qAx;
        localObject2 = this.qBt;
        localObject3 = this.qpk;
        localObject4 = this.qBx;
        localWalletFormView = this.qBy;
        localTextView1 = this.qpl;
        localTextView2 = this.qpm;
        a(new boolean[] { 0, 0, 0, 0, 0 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView }, localTextView1, localTextView2);
        this.qBu.setVisibility(8);
        kC(true);
        bool1 = this.qBU;
        localObject1 = this.qBw;
        localObject2 = this.qBv;
        localObject3 = this.qBz;
        localObject4 = this.qBo;
        a(new boolean[] { false, false, bool1 }, new WalletFormView[] { localObject1, localObject2, localObject3 }, (TextView)localObject4, null);
        bool1 = this.qsa.quZ;
        bool2 = this.qsa.qva;
        localObject1 = this.qBr;
        localObject2 = this.qBq;
        localObject3 = this.qBk;
        localObject4 = this.qBl;
        a(new boolean[] { bool1, bool2 }, new WalletFormView[] { localObject1, localObject2 }, (TextView)localObject3, (TextView)localObject4);
        if (this.qBp.getVisibility() != 0) {
          break label2633;
        }
        switch (this.qsa.qve)
        {
        default: 
          this.qBj.setVisibility(8);
          this.qBj.setTextColor(getResources().getColor(a.c.normal_color));
        }
      }
      for (;;)
      {
        if ((!bk.bl(this.qsa.qvy)) && (this.qBj.getVisibility() != 0))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
          this.qBj.setText(this.qsa.qvy);
          this.qBj.setVisibility(0);
        }
        if ((bk.bl(this.qsa.qvj)) || (!s.hk(this.qsa.qvj)) || (bWz())) {
          break label2645;
        }
        this.qBO.setText(this.qsa.qvk);
        this.qBO.setVisibility(0);
        return;
        int i;
        if ((this.qsa.bVd() != null) && (this.qsa.bVd().size() > 0))
        {
          i = 1;
          label1379:
          if ((!bWz()) && (!o.bVs().bVK())) {
            break label2192;
          }
          localObject2 = o.bVs().aEZ();
          localObject1 = localObject2;
          if (bk.bl((String)localObject2))
          {
            localObject1 = localObject2;
            if (cNj() != null) {
              localObject1 = cNj().kke.getString("key_true_name");
            }
          }
          if (bk.bl((String)localObject1)) {
            break label2023;
          }
          localObject1 = getString(a.i.wallet_card_username_hint_forget, new Object[] { e.afj((String)localObject1) });
          this.qAx.setHint((CharSequence)localObject1);
          this.qBs.setHint((CharSequence)localObject1);
          if ((!bWz()) || (bk.bl(this.BX.getString("key_identity"))) || (this.BX.getInt("key_id_type", -1) == -1) || (bk.bl(this.BX.getString("key_true_name")))) {
            break label2053;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
          bool1 = this.qBS;
          bool2 = this.qBT;
          localObject1 = this.qAx;
          localObject2 = this.qBt;
          localObject3 = this.qpk;
          localObject4 = this.qBx;
          localWalletFormView = this.qBy;
          localTextView1 = this.qpl;
          localTextView2 = this.qpm;
          a(new boolean[] { false, false, false, bool1, bool2 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView }, localTextView1, localTextView2);
          this.iLj = this.BX.getString("key_true_name");
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "name is " + this.iLj);
          this.qBu.setVisibility(0);
          if (this.qAy != null)
          {
            if (!bk.bl(this.qAy.field_mobile)) {
              a(this.qBu, this.qAy.field_mobile);
            }
            if (!bk.bl(this.qAy.qsN)) {
              a(this.qBr, this.qAy.qsN);
            }
            if (!bk.bl(this.qAy.qtv)) {
              a(this.qBq, this.qAy.qtv);
            }
          }
          if (!this.qsa.quX) {
            break label2414;
          }
          this.qpm.setText("");
        }
        for (;;)
        {
          this.qpk.setText(this.qsa.qvb);
          if (o.bVs().bVT() <= 0) {
            break label2431;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", new Object[] { Integer.valueOf(o.bVs().bVT()) });
          this.qBt.setClickable(false);
          this.qBt.setText(o.bVA().O(this, o.bVs().bVT()));
          this.qBt.setInputEnable(false);
          a(this.qpk, this.qpo);
          AS(this.qpo);
          kC(false);
          bool1 = this.qBQ;
          bool2 = this.qBR;
          boolean bool3 = this.qBU;
          localObject1 = this.qBw;
          localObject2 = this.qBv;
          localObject3 = this.qBz;
          localObject4 = this.qBo;
          a(new boolean[] { bool1, bool2, bool3 }, new WalletFormView[] { localObject1, localObject2, localObject3 }, (TextView)localObject4, null);
          break;
          i = 0;
          break label1379;
          label2023:
          localObject1 = getString(a.i.wallet_card_username_hint);
          this.qAx.setHint((CharSequence)localObject1);
          this.qBs.setHint((CharSequence)localObject1);
          break label1488;
          if ((this.qBV) || (i != 0)) {}
          for (bool1 = true;; bool1 = false)
          {
            bool2 = this.qBS;
            bool3 = this.qBT;
            localObject1 = this.qAx;
            localObject2 = this.qBt;
            localObject3 = this.qpk;
            localObject4 = this.qBx;
            localWalletFormView = this.qBy;
            localTextView1 = this.qpl;
            localTextView2 = this.qpm;
            a(new boolean[] { true, bool1, true, bool2, bool3 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView }, localTextView1, localTextView2);
            break;
          }
          bool2 = this.qsa.quX;
          if ((this.qBV) || ((i != 0) && (this.qsa.quY))) {}
          for (bool1 = true;; bool1 = false)
          {
            bool3 = this.qsa.quY;
            boolean bool4 = this.qBS;
            boolean bool5 = this.qBT;
            localObject1 = this.qAx;
            localObject2 = this.qBt;
            localObject3 = this.qpk;
            localObject4 = this.qBx;
            localWalletFormView = this.qBy;
            localTextView1 = this.qpl;
            localTextView2 = this.qpm;
            a(new boolean[] { bool2, bool1, bool3, bool4, bool5 }, new WalletFormView[] { localObject1, localObject2, localObject3, localObject4, localWalletFormView }, localTextView1, localTextView2);
            this.qBu.setVisibility(0);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.qsa.quX + " canModifyIdentity:" + this.qsa.quY);
            break;
          }
          label2414:
          this.qpm.setText(getString(a.i.wallet_card_identify_security));
        }
        label2431:
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", new Object[] { Integer.valueOf(this.qCh.getCount()) });
        if (this.qCh.getCount() <= 1)
        {
          this.qBt.setClickable(false);
          this.qBt.setInputEnable(false);
          this.qpk.setInputEnable(true);
        }
        for (;;)
        {
          localObject1 = this.qsa.bVd();
          if ((localObject1 == null) || (!((List)localObject1).contains(Integer.valueOf(this.qpo)))) {
            this.qpo = 1;
          }
          this.qBt.setText(o.bVA().O(this, this.qpo));
          break;
          this.qBt.setClickable(true);
          this.qBt.setInputEnable(true);
          this.qpk.setInputEnable(true);
        }
        this.qBj.setText(a.i.wallet_card_cardtype_tipmsg_cn);
        this.qBj.setVisibility(0);
        break label1225;
        this.qBj.setVisibility(8);
        break label1225;
        this.qBj.setVisibility(8);
        break label1225;
        this.qBj.setVisibility(8);
        break label1225;
        this.qBj.setVisibility(8);
      }
      this.qBO.setVisibility(8);
      return;
    }
  }
  
  private void bWy()
  {
    Object localObject1;
    boolean bool;
    if (YH())
    {
      com.tencent.mm.plugin.wallet_core.e.c.bXt();
      if (!bk.bl(this.qsa.qvj))
      {
        localObject1 = this.BX;
        if ((this.qBO.getVisibility() != 0) || (!this.qBO.isChecked())) {
          break label1108;
        }
        bool = true;
        ((Bundle)localObject1).putBoolean("key_is_follow_bank_username", bool);
        this.BX.putString("key_bank_username", this.qsa.qvj);
      }
      localObject1 = (FavorPayInfo)this.BX.getParcelable("key_favor_pay_info");
      if ((this.qsa != null) && (localObject1 != null) && (this.qnm != null) && (this.qBL != null))
      {
        if (!this.qBL.containsKey(this.qsa.mOb)) {
          break label1113;
        }
        ((FavorPayInfo)localObject1).qvC = ((a.a)this.qBL.get(this.qsa.mOb)).qAa.qlk;
        label162:
        this.BX.putParcelable("key_favor_pay_info", (Parcelable)localObject1);
      }
      this.qmd = new Authen();
      if (this.qAy != null)
      {
        this.qmd.mOc = this.qAy.qtw;
        this.qmd.qsP = this.qAy.field_bankcardTail;
      }
      localObject1 = this.BX.getString("key_card_id");
      if (this.qBK.getVisibility() != 0) {
        break label1158;
      }
      localObject1 = this.qBK.getText();
    }
    label516:
    label1158:
    for (;;)
    {
      this.qmd.nqa = ((PayInfo)this.BX.getParcelable("key_pay_info"));
      this.qmd.qsM = ((String)localObject1);
      this.qmd.mOb = this.qsa.mOb;
      this.qmd.qsL = this.qpo;
      this.qmd.qsI = this.BX.getString("key_pwd1");
      if (!bk.bl(this.qBr.getText())) {
        this.qmd.qsN = this.qBr.getText();
      }
      this.qmd.qqU = this.qBu.getText();
      this.qmd.qsR = this.qBA.getText();
      this.qmd.qsS = this.qBB.getText();
      this.qmd.country = this.qBP;
      this.qmd.cCA = this.lJI;
      this.qmd.cCB = this.lJJ;
      this.qmd.ekZ = this.qBD.getText();
      this.qmd.lnV = this.qBE.getText();
      this.qmd.ftq = this.qBF.getText();
      this.qmd.cCt = this.qBG.getText();
      localObject1 = e.afk(this.qmd.qqU);
      this.BX.putString("key_mobile", (String)localObject1);
      Object localObject2 = this.BX;
      if (this.qsa.qqY == 2)
      {
        bool = true;
        ((Bundle)localObject2).putBoolean("key_is_oversea", bool);
        this.qmd.qsK = this.qpk.getText();
        this.qmd.qsJ = this.qAx.getText();
        this.qmd.qsO = this.qBq.getText();
        localObject2 = (FavorPayInfo)this.BX.getParcelable("key_favor_pay_info");
        if (localObject2 != null)
        {
          this.qmd.qsT = ((FavorPayInfo)localObject2).qvF;
          this.qmd.qsU = ((FavorPayInfo)localObject2).qvC;
        }
        this.qmd.qsZ = ("+" + this.qBH.getCountryCode());
        this.qmd.qta = this.qCa;
        this.qmd.qtc = this.qBy.getText();
        this.qmd.qtb = this.qBz.getText();
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", new Object[] { Integer.valueOf(this.qmd.qta), this.qmd.qtc, this.qmd.qtb });
        if ((bWz()) && (!bk.bl(this.BX.getString("key_identity"))) && (this.BX.getInt("key_id_type", -1) != -1) && (!bk.bl(this.BX.getString("key_true_name"))))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
          this.qmd.qsK = this.BX.getString("key_identity");
          this.qmd.qsL = this.BX.getInt("key_id_type", -1);
          this.qmd.qsJ = this.iLj;
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.qmd.qsJ);
        }
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.qmd.nqa + " elemt.bankcardTag : " + this.qsa.qqY);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.qsa.qqY);
        localObject2 = this.BX;
        ((Bundle)localObject2).putString("key_mobile", (String)localObject1);
        ((Bundle)localObject2).putParcelable("key_authen", this.qmd);
        ((Bundle)localObject2).putString("key_bank_phone", this.qsa.qvi);
        ((Bundle)localObject2).putString("key_country_code", this.countryCode);
        ((Bundle)localObject2).putString("key_province_code", this.dXv);
        ((Bundle)localObject2).putString("key_city_code", this.dXu);
        ((Bundle)localObject2).putParcelable("key_profession", this.qsb);
        ((Bundle)localObject2).putString("key_bind_card_type", this.qmd.mOb);
        ((Bundle)localObject2).putString("key_bind_card_show1", this.qsa.lnT);
        if (2 != this.qsa.qvf) {
          break label1137;
        }
      }
      label1108:
      label1113:
      label1137:
      for (localObject1 = getString(a.i.wallet_credit_card);; localObject1 = getString(a.i.wallet_deposit_card))
      {
        ((Bundle)localObject2).putString("key_bind_card_show2", (String)localObject1);
        if (!cNk().m(new Object[] { this.qmd, this.nEh })) {
          break label1148;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
        return;
        bool = false;
        break;
        ((FavorPayInfo)localObject1).qvC = this.qnm.bk(((FavorPayInfo)localObject1).qvC, false);
        break label162;
        bool = false;
        break label516;
      }
      label1148:
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      return;
    }
  }
  
  private boolean bWz()
  {
    return this.BX.getBoolean("key_is_forgot_process", false);
  }
  
  private void kC(boolean paramBoolean)
  {
    int j = 0;
    if (paramBoolean)
    {
      Object localObject = this.pcd;
      if (this.qsa.qvm)
      {
        i = 0;
        ((TextView)localObject).setVisibility(i);
        localObject = this.qBA;
        if (!this.qsa.qvm) {
          break label213;
        }
        i = 0;
        label48:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.qBB;
        if (!this.qsa.qvn) {
          break label219;
        }
        i = 0;
        label72:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.qBC;
        if (!this.qsa.qvo) {
          break label225;
        }
        i = 0;
        label96:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.qBD;
        if (!this.qsa.qvr) {
          break label231;
        }
        i = 0;
        label120:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.qBE;
        if (!this.qsa.qvt) {
          break label237;
        }
        i = 0;
        label144:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.qBF;
        if (!this.qsa.qvs) {
          break label243;
        }
        i = 0;
        label168:
        ((WalletFormView)localObject).setVisibility(i);
        localObject = this.qBG;
        if (!this.qsa.qvu) {
          break label249;
        }
      }
      label213:
      label219:
      label225:
      label231:
      label237:
      label243:
      label249:
      for (int i = j;; i = 8)
      {
        ((WalletFormView)localObject).setVisibility(i);
        this.qBm.setVisibility(4);
        return;
        i = 8;
        break;
        i = 8;
        break label48;
        i = 8;
        break label72;
        i = 8;
        break label96;
        i = 8;
        break label120;
        i = 8;
        break label144;
        i = 8;
        break label168;
      }
    }
    this.pcd.setVisibility(8);
    this.qBA.setVisibility(8);
    this.qBB.setVisibility(8);
    this.qBC.setVisibility(8);
    this.qBD.setVisibility(8);
    this.qBE.setVisibility(8);
    this.qBF.setVisibility(8);
    this.qBG.setVisibility(8);
    this.qBm.setVisibility(8);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        paramString = this.BX;
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.nDu);
        bool1 = bool2;
        if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
          com.tencent.mm.wallet_core.a.j(this, paramString);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final void gG(boolean paramBoolean)
  {
    YH();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_card_element_ui;
  }
  
  protected final void initView()
  {
    this.qBg = ((TextView)findViewById(a.f.wallet_card_forgot_id_tipmsg));
    this.qBK = ((WalletFormView)findViewById(a.f.wallet_card_forgot_id));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.qBK);
    this.qBh = ((TextView)findViewById(a.f.wallet_card_forgot_id_err_tipmsg));
    this.qpl = ((TextView)findViewById(a.f.wallet_card_identify_tipmsg));
    this.qAx = ((WalletFormView)findViewById(a.f.name_et));
    this.qBs = ((WalletFormView)findViewById(a.f.forgot_name_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.qAx);
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.qBs);
    this.qBt = ((WalletFormView)findViewById(a.f.wallet_cre_type));
    this.qpk = ((WalletFormView)findViewById(a.f.identity_et));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.qpk);
    this.qpm = ((TextView)findViewById(a.f.wallet_card_identify_err_hint));
    this.qBi = ((TextView)findViewById(a.f.wallet_card_bankcard_type_tipmsg));
    this.qBp = ((WalletFormView)findViewById(a.f.wallet_card_name));
    this.qBX = ((WalletFormView)findViewById(a.f.wallet_card_type));
    this.qBj = ((TextView)findViewById(a.f.wallet_card_cardtype_tipmsg));
    this.qBn = ((TextView)findViewById(a.f.wallet_card_favor));
    this.qBk = ((TextView)findViewById(a.f.wallet_card_cvv_tipmsg));
    this.qBr = ((WalletFormView)findViewById(a.f.cvv_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.qBr);
    this.qBq = ((WalletFormView)findViewById(a.f.date_et));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.qBq);
    this.qBl = ((TextView)findViewById(a.f.wallet_card_cvv_err_tipmsg));
    this.pcd = ((TextView)findViewById(a.f.wallet_card_address_tipmsg));
    this.qBA = ((WalletFormView)findViewById(a.f.first_name_et));
    this.qBB = ((WalletFormView)findViewById(a.f.last_name_et));
    this.qBC = ((WalletFormView)findViewById(a.f.area_et));
    this.qBD = ((WalletFormView)findViewById(a.f.address_et));
    this.qBE = ((WalletFormView)findViewById(a.f.phone_et));
    this.qBF = ((WalletFormView)findViewById(a.f.post_et));
    this.qBG = ((WalletFormView)findViewById(a.f.email_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.qBG);
    this.qBm = ((TextView)findViewById(a.f.wallet_card_address_err_tipmsg));
    this.qBN = ((CheckBox)findViewById(a.f.agree_wx_cb));
    this.qBO = ((CheckBox)findViewById(a.f.agree_follow_bank_cb));
    this.fpF = ((Button)findViewById(a.f.next_btn));
    this.qBI = ((ScrollView)findViewById(a.f.wallet_sv));
    this.qBv = ((WalletFormView)findViewById(a.f.private_profession_et));
    this.qBw = ((WalletFormView)findViewById(a.f.private_address_et));
    this.qBx = ((WalletFormView)findViewById(a.f.wallet_cre_change_times));
    this.qBy = ((WalletFormView)findViewById(a.f.wallet_cre_valid_date));
    this.qBz = ((WalletFormView)findViewById(a.f.private_birthday_et));
    this.qBo = ((TextView)findViewById(a.f.wallet_card_private_info_tipmsg));
    this.qBH = ((WalletPhoneInputView)findViewById(a.f.mobile_new_et));
    this.qBu = this.qBH.getPhoneNumberEt();
    this.qAx.setOnInputValidChangeListener(this);
    this.qBs.setOnInputValidChangeListener(this);
    this.qBK.setOnInputValidChangeListener(this);
    this.qBt.setOnInputValidChangeListener(this);
    this.qpk.setOnInputValidChangeListener(this);
    this.qBu.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void gG(boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          WalletCardElementUI.a(WalletCardElementUI.this);
          WalletCardElementUI.this.BX.putParcelable("key_history_bankcard", null);
        }
        WalletCardElementUI.b(WalletCardElementUI.this);
      }
    });
    this.qBr.setOnInputValidChangeListener(this);
    this.qBq.setOnInputValidChangeListener(this);
    this.qBA.setOnInputValidChangeListener(this);
    this.qBB.setOnInputValidChangeListener(this);
    this.qBC.setOnInputValidChangeListener(this);
    this.qBD.setOnInputValidChangeListener(this);
    this.qBE.setOnInputValidChangeListener(this);
    this.qBF.setOnInputValidChangeListener(this);
    this.qBG.setOnInputValidChangeListener(this);
    this.qBv.setOnInputValidChangeListener(this);
    this.qBw.setOnInputValidChangeListener(this);
    this.qAx.setOnEditorActionListener(this);
    this.qBs.setOnEditorActionListener(this);
    this.qBK.setOnEditorActionListener(this);
    this.qBt.setOnEditorActionListener(this);
    this.qpk.setOnEditorActionListener(this);
    this.qBu.setOnEditorActionListener(this);
    this.qBr.setOnEditorActionListener(this);
    this.qBq.setOnEditorActionListener(this);
    this.qBA.setOnEditorActionListener(this);
    this.qBB.setOnEditorActionListener(this);
    this.qBC.setOnEditorActionListener(this);
    this.qBD.setOnEditorActionListener(this);
    this.qBE.setOnEditorActionListener(this);
    this.qBF.setOnEditorActionListener(this);
    this.qBG.setOnEditorActionListener(this);
    this.qBw.setOnEditorActionListener(this);
    this.qBv.setOnEditorActionListener(this);
    this.qBp.setOnClickListener(new WalletCardElementUI.10(this));
    this.qBX.setOnClickListener(new WalletCardElementUI.11(this));
    this.qBt.setOnClickListener(new WalletCardElementUI.12(this));
    Object localObject = new String[100];
    int i = 0;
    while (i < 100)
    {
      localObject[i] = getString(a.i.wallet_cre_count, new Object[] { Integer.valueOf(i) });
      i += 1;
    }
    this.qBx.setOnClickListener(new WalletCardElementUI.13(this, (String[])localObject));
    this.qBy.setOnClickListener(new WalletCardElementUI.14(this));
    this.qBw.setOnClickListener(new WalletCardElementUI.15(this));
    this.qBv.setOnClickListener(new WalletCardElementUI.16(this));
    this.qBz.setOnClickListener(new WalletCardElementUI.17(this));
    this.qBN.setChecked(true);
    this.qBN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        WalletCardElementUI.b(WalletCardElementUI.this);
      }
    });
    findViewById(a.f.agree_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        e.a(WalletCardElementUI.this, WalletCardElementUI.n(WalletCardElementUI.this).mOb, WalletCardElementUI.n(WalletCardElementUI.this).lnT, false, WalletCardElementUI.n(WalletCardElementUI.this).qvx);
      }
    });
    this.qBC.setOnClickListener(new WalletCardElementUI.4(this));
    this.fpF.setOnClickListener(new WalletCardElementUI.5(this));
    e(this.qBK, 0, false);
    e(this.qpk, 1, false);
    a(this.qBu, 0, false, true, true);
    if ((this.qsa != null) && (!bk.bl(this.qsa.qvl)))
    {
      com.tencent.mm.ui.base.h.a(this, this.qsa.qvl, null, true, null);
      this.qsa = null;
    }
    for (;;)
    {
      aZ();
      YH();
      localObject = com.tencent.mm.wallet_core.a.aj(this);
      if ((localObject != null) && (((com.tencent.mm.wallet_core.c)localObject).cMo()))
      {
        localObject = (Orders)this.BX.getParcelable("key_orders");
        if ((localObject == null) || (((Orders)localObject).qwy != 1)) {
          break;
        }
        this.qBM = true;
        this.qAx.setText(e.afj(((Orders)localObject).qsJ));
        this.qAx.setEnabled(false);
        this.qAx.setFocusable(false);
        this.qpo = ((Orders)localObject).qwz;
        this.qBt.setText(o.bVA().O(this, this.qpo));
        this.qBt.setEnabled(false);
        this.qpk.setText(((Orders)localObject).qvb);
        this.qpk.setInputEnable(false);
        this.qpk.setFocusable(false);
        this.qpl.setText(a.i.wallet_card_assigned_userinfo_tips);
      }
      return;
      if ((this.BX.getInt("key_bind_scene", -1) == 5) && (!this.qsa.qvB))
      {
        com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_wx_offline_no_support_micropay_dialog_content), null, true, null);
        this.qsa.lnT = null;
      }
    }
    this.qBM = false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + paramInt1);
    if (this.qBH.e(paramInt1, paramInt2, paramIntent)) {}
    while (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      YH();
      return;
      this.qsa = null;
      this.qBZ = 0;
      this.qBW = paramIntent.getStringExtra("bank_name");
      this.qBp.setText(this.qBW);
      this.qBX.setVisibility(0);
      this.qBX.setText("");
      paramIntent = o.bVA().qqW;
      this.qBY.clear();
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
          } while (!((ElementQuery)localObject).lnT.equals(this.qBW));
          this.qBY.add(localObject);
          if ((this.BX.getInt("key_bind_scene", -1) == 5) && (!((ElementQuery)localObject).qvB)) {
            ((ElementQuery)localObject).qvl = getString(a.i.wallet_wx_offline_no_support);
          }
        } while (this.qBY.size() < 2);
      }
      if (this.qBY.size() == 1) {
        this.qsa = ((ElementQuery)this.qBY.get(0));
      }
      this.qAy = null;
      aZ();
      continue;
      Object localObject = paramIntent.getStringExtra("CountryName");
      String str1 = paramIntent.getStringExtra("Country");
      this.qBP = ((String)localObject + "|" + str1);
      String str2 = paramIntent.getStringExtra("ProviceName");
      String str3 = paramIntent.getStringExtra("CityName");
      if (!bk.bl(paramIntent.getStringExtra("Contact_City")))
      {
        this.lJI = (str2 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.lJJ = (str3 + "|" + paramIntent.getStringExtra("Contact_City"));
        if (bk.bl((String)localObject))
        {
          this.qBC.setText(str2 + " " + str3);
          label486:
          if ((!"US".equals(str1)) && (!"CA".equals(str1)) && (!this.qsa.qvs)) {
            break label709;
          }
          this.qBF.setVisibility(0);
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", new Object[] { localObject, str1, str2, str3, this.lJJ });
        break;
        this.qBC.setText((String)localObject + " " + str3);
        break label486;
        if (!bk.bl(paramIntent.getStringExtra("Contact_Province")))
        {
          this.lJJ = (str2 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.qBC.setText((String)localObject + " " + str2);
          break label486;
        }
        this.lJJ = this.qBP;
        this.qBC.setText((String)localObject);
        break label486;
        label709:
        this.qBF.setVisibility(8);
      }
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.qBK.set3DesValStr(paramIntent);
      continue;
      localObject = paramIntent.getStringExtra("CountryName");
      str1 = paramIntent.getStringExtra("ProviceName");
      str2 = paramIntent.getStringExtra("CityName");
      this.countryCode = paramIntent.getStringExtra("Country");
      this.dXv = paramIntent.getStringExtra("Contact_Province");
      this.dXu = paramIntent.getStringExtra("Contact_City");
      paramIntent = new StringBuilder();
      if (!bk.bl((String)localObject)) {
        paramIntent.append((String)localObject);
      }
      if (!bk.bl(str1)) {
        paramIntent.append(" ").append(str1);
      }
      if (!bk.bl(str2)) {
        paramIntent.append(" ").append(str2);
      }
      this.qBw.setText(paramIntent.toString());
      continue;
      this.qsb = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
      this.qBv.setText(this.qsb.qst);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    this.qsa = ((ElementQuery)this.BX.getParcelable("elemt_query"));
    this.nEh = ((Orders)this.BX.getParcelable("key_orders"));
    this.nDu = ((PayInfo)this.BX.getParcelable("key_pay_info"));
    this.qpo = o.bVs().bVT();
    this.qAy = ((Bankcard)this.BX.getParcelable("key_history_bankcard"));
    this.qBQ = this.BX.getBoolean("key_need_area", false);
    this.qBR = this.BX.getBoolean("key_need_profession", false);
    if ((this.qBQ) || (this.qBR)) {
      setMMTitle(a.i.wallet_elment_title2);
    }
    for (;;)
    {
      paramBundle = this.BX.getParcelableArray("key_profession_list");
      if (paramBundle == null) {
        break;
      }
      this.qrb = new Profession[paramBundle.length];
      while (i < paramBundle.length)
      {
        this.qrb[i] = ((Profession)paramBundle[i]);
        i += 1;
      }
      setMMTitle(a.i.wallet_elment_title);
    }
    if (this.nDu == null) {
      this.nDu = new PayInfo();
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.nDu);
    paramBundle = (FavorPayInfo)this.BX.getParcelable("key_favor_pay_info");
    if ((this.nEh != null) && (paramBundle != null))
    {
      this.qnm = b.qAd.a(this.nEh);
      if (this.qnm == null) {
        break label344;
      }
      paramBundle = this.qnm.QH(paramBundle.qvC);
      this.qBL = this.qnm.QD(paramBundle);
    }
    for (;;)
    {
      initView();
      this.qBI.pageScroll(33);
      com.tencent.mm.plugin.wallet_core.e.c.a(this, this.BX, 3);
      com.tencent.mm.sdk.b.a.udP.c(this.qoS);
      return;
      label344:
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
    }
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.qoS);
    super.onDestroy();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + paramInt);
    switch (paramInt)
    {
    default: 
      if (this.qBJ == null) {
        bWy();
      }
      return false;
    }
    boolean bool1;
    if (this.qBJ != null)
    {
      paramTextView = this.qBJ;
      if (paramTextView.wCS != null)
      {
        bool1 = paramTextView.wCS.isFocusable();
        if (!bool1) {
          break label145;
        }
        paramTextView = this.qBJ;
        bool1 = bool2;
        if (paramTextView.wCS != null) {
          bool1 = paramTextView.wCS.isClickable();
        }
        if ((!bool1) || (!this.qBJ.cNv())) {
          break label145;
        }
        this.qBJ.cNx();
      }
    }
    for (;;)
    {
      return true;
      bool1 = false;
      break;
      label145:
      this.qBJ.performClick();
      continue;
      bWy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI
 * JD-Core Version:    0.7.0.1
 */