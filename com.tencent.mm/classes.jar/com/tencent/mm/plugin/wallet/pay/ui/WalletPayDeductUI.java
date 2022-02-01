package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletPayDeductUI
  extends MMPreference
  implements View.OnClickListener, com.tencent.mm.al.g
{
  protected MMSwitchBtn hII;
  protected Button iwY;
  protected f lxI;
  private String nti;
  private LinearLayout svN;
  private Dialog tipDialog = null;
  protected Orders vIq;
  protected TextView zQA;
  private TextView zQB;
  private TextView zQC;
  private String zQD;
  private String zQE;
  private Bankcard zQF;
  protected boolean zQG = false;
  private int zQH = 0;
  private String zQI;
  protected ArrayList<Preference> zQz;
  
  private void eai()
  {
    AppMethodBeat.i(69378);
    com.tencent.mm.plugin.wallet.a.s.dZT();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.dZU();
    if (this.zQF == null) {
      this.zQF = ((am)localObject).a(null, null, true, true, true);
    }
    if (this.zQF == null)
    {
      ad.i("MicroMsg.WalletPayDeductUI", "no bank card!");
      finish();
      AppMethodBeat.o(69378);
      return;
    }
    localObject = new SpannableString(this.zQF.field_desc);
    l locall = new l(getContext());
    locall.Anf = new l.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69372);
        paramAnonymousView = WalletPayDeductUI.this.getContext();
        Object localObject = this.zQK;
        String str = WalletPayDeductUI.a(WalletPayDeductUI.this);
        Bankcard localBankcard1 = WalletPayDeductUI.b(WalletPayDeductUI.this);
        h.a local1 = new h.a()
        {
          public final void JX(int paramAnonymous2Int)
          {
            AppMethodBeat.i(69371);
            WalletPayDeductUI.a(WalletPayDeductUI.this, (Bankcard)WalletPayDeductUI.3.this.zQK.get(paramAnonymous2Int));
            WalletPayDeductUI.c(WalletPayDeductUI.this);
            AppMethodBeat.o(69371);
          }
        };
        LinkedList localLinkedList = new LinkedList();
        if (((localObject == null) || (((List)localObject).size() == 0)) && (bt.isNullOrNil(null)))
        {
          ad.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
          AppMethodBeat.o(69372);
          return;
        }
        int i;
        if ((localObject != null) && (((List)localObject).size() != 0))
        {
          localObject = ((List)localObject).iterator();
          i = 0;
          for (int j = 0; ((Iterator)localObject).hasNext(); j = k)
          {
            Bankcard localBankcard2 = (Bankcard)((Iterator)localObject).next();
            localLinkedList.add(localBankcard2.field_desc);
            k = j;
            if (localBankcard1 != null)
            {
              k = j;
              if (localBankcard1.equals(localBankcard2)) {
                k = i;
              }
            }
            i += 1;
          }
          k = j;
          if (!bt.isNullOrNil(null))
          {
            localLinkedList.add(null);
            k = j;
            if (localBankcard1 != null) {}
          }
        }
        for (int k = i;; k = 0)
        {
          com.tencent.mm.ui.base.h.a(paramAnonymousView, str, localLinkedList, k, local1);
          AppMethodBeat.o(69372);
          return;
          ad.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
          localLinkedList.add(null);
        }
      }
    };
    ((SpannableString)localObject).setSpan(locall, 0, ((SpannableString)localObject).length(), 18);
    this.zQB.setText((CharSequence)localObject);
    this.zQB.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69378);
  }
  
  private void eaj()
  {
    AppMethodBeat.i(69380);
    if ((this.zQz == null) || (this.zQz.size() <= 0))
    {
      AppMethodBeat.o(69380);
      return;
    }
    int j = this.zQz.size();
    int i = 0;
    while (i < j)
    {
      this.lxI.cE(((Preference)this.zQz.get(i)).mKey, false);
      i += 1;
    }
    this.lxI.notifyDataSetChanged();
    AppMethodBeat.o(69380);
  }
  
  private void gj(List<Orders.DeductShowInfo> paramList)
  {
    AppMethodBeat.i(69381);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
      AppMethodBeat.o(69381);
      return;
    }
    if (this.zQz == null)
    {
      int j = paramList.size();
      this.zQz = new ArrayList();
      int i = 0;
      if (i < j)
      {
        Object localObject = (Orders.DeductShowInfo)paramList.get(i);
        com.tencent.mm.plugin.wallet_core.ui.g localg;
        if ((localObject != null) && (!bt.isNullOrNil(((Orders.DeductShowInfo)localObject).name)))
        {
          localg = new com.tencent.mm.plugin.wallet_core.ui.g(this);
          localg.setTitle(((Orders.DeductShowInfo)localObject).name);
          if (((Orders.DeductShowInfo)localObject).Agp <= 0) {
            break label231;
          }
          localg.uqD = getResources().getColor(2131100547);
          String str = ((Orders.DeductShowInfo)localObject).value;
          localObject = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(69373);
              ad.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", new Object[] { Integer.valueOf(this.zQM.Agp) });
              if (this.zQM.Agp == 1)
              {
                if (!bt.isNullOrNil(this.zQM.Ags))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("rawUrl", this.zQM.Ags);
                  paramAnonymousView.putExtra("showShare", false);
                  com.tencent.mm.wallet_core.ui.e.X(WalletPayDeductUI.this.getContext(), paramAnonymousView);
                  AppMethodBeat.o(69373);
                }
              }
              else if (this.zQM.Agp == 2)
              {
                paramAnonymousView = new uj();
                paramAnonymousView.dzH.userName = this.zQM.Agq;
                paramAnonymousView.dzH.dzJ = bt.by(this.zQM.Agr, "");
                paramAnonymousView.dzH.scene = 1097;
                paramAnonymousView.dzH.dzK = 0;
                a.ESL.l(paramAnonymousView);
              }
              AppMethodBeat.o(69373);
            }
          };
          localg.mContent = str;
          localg.mClickable = true;
          localg.pgj = ((View.OnClickListener)localObject);
        }
        for (;;)
        {
          localg.setKey("deduct_info_".concat(String.valueOf(i)));
          this.zQz.add(localg);
          this.lxI.b(localg);
          this.lxI.cE(localg.mKey, true);
          i += 1;
          break;
          label231:
          localg.mContent = ((Orders.DeductShowInfo)localObject).value;
          localg.mClickable = false;
        }
      }
    }
    AppMethodBeat.o(69381);
  }
  
  public int getLayoutId()
  {
    return 2131496003;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69377);
    this.zQA = ((TextView)getContentView().findViewById(2131297270));
    this.iwY = ((Button)getContentView().findViewById(2131302852));
    this.svN = ((LinearLayout)findViewById(2131303160));
    ((TextView)findViewById(2131298948)).setText(this.vIq.AfC.title);
    ((TextView)findViewById(2131305902)).setText(((Orders.Commodity)this.vIq.Afx.get(0)).desc);
    Object localObject1 = (WalletTextView)findViewById(2131299874);
    ((WalletTextView)localObject1).setTypeface(0);
    ((WalletTextView)localObject1).setText(com.tencent.mm.wallet_core.ui.e.aNd(this.vIq.uop));
    ((TextView)findViewById(2131299872)).setText(((Orders.Commodity)this.vIq.Afx.get(0)).nUf);
    localObject1 = (TextView)findViewById(2131300212);
    Object localObject2 = (TextView)findViewById(2131298947);
    boolean bool;
    if (!bt.isNullOrNil(this.vIq.AfC.Agn))
    {
      ((TextView)localObject2).setText(this.vIq.AfC.Agn);
      if (!bt.isNullOrNil(this.vIq.AfC.Ago)) {
        ((TextView)localObject2).setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.bW(this.vIq.AfC.Ago, true));
      }
      this.zQB = ((TextView)findViewById(2131298950));
      this.zQC = ((TextView)findViewById(2131297112));
      if (this.vIq.AfC.zRt != 1) {
        break label772;
      }
      bool = true;
      label314:
      this.zQG = bool;
      this.zQH = this.vIq.AfC.zQH;
      this.nti = this.vIq.AfC.nti;
      this.zQI = this.vIq.AfC.zQI;
      ad.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", new Object[] { Boolean.valueOf(this.zQG), Integer.valueOf(this.zQH) });
      if (this.zQH != 0) {
        break label777;
      }
      this.hII = ((MMSwitchBtn)findViewById(2131298255));
      this.hII.setCheck(this.zQG);
      this.hII.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int i = 2;
          AppMethodBeat.i(69370);
          WalletPayDeductUI.this.ss(paramAnonymousBoolean);
          if (WalletPayDeductUI.this.vIq != null)
          {
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
            if (paramAnonymousBoolean) {
              i = 1;
            }
            localh.f(15379, new Object[] { Integer.valueOf(i), WalletPayDeductUI.this.vIq.dcE });
          }
          AppMethodBeat.o(69370);
        }
      });
      ss(this.zQG);
      label448:
      ad.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[] { Integer.valueOf(this.vIq.AfC.Agm) });
      if (this.vIq.AfC.Agm != 1) {
        break label864;
      }
      com.tencent.mm.kernel.g.afC();
      this.zQE = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkV, ""));
      com.tencent.mm.kernel.g.afC();
      this.zQD = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkU, ""));
      if ((!bt.isNullOrNil(this.zQD)) && (!bt.isNullOrNil(this.zQD))) {
        break label846;
      }
      ad.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
      this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), false, null);
      localObject2 = new m();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a((n)localObject2, 0);
      label607:
      if (bt.isNullOrNil(this.vIq.AfC.Agk)) {
        break label876;
      }
      Object localObject3 = getString(2131765226);
      localObject2 = getString(2131765227);
      localObject3 = k.c(this, getString(2131765225, new Object[] { localObject3, localObject2 }));
      l locall = new l(getContext());
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject3);
      localSpannableString.setSpan(locall, ((CharSequence)localObject3).length() - ((String)localObject2).length(), ((CharSequence)localObject3).length(), 33);
      ((TextView)localObject1).setTextColor(getResources().getColor(2131100490));
      ((TextView)localObject1).setText(localSpannableString);
      ((TextView)localObject1).setOnClickListener(this);
      ((TextView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.iwY.setOnClickListener(this);
      AppMethodBeat.o(69377);
      return;
      ((TextView)localObject2).setVisibility(8);
      break;
      label772:
      bool = false;
      break label314;
      label777:
      if (!bt.isNullOrNil(this.nti)) {
        this.iwY.setText(this.nti);
      }
      if (!bt.isNullOrNil(this.zQI))
      {
        this.zQA.setText(this.zQI);
        this.zQA.setVisibility(0);
      }
      findViewById(2131298946).setVisibility(8);
      eaj();
      break label448;
      label846:
      this.zQC.setText(this.zQE);
      eai();
      break label607;
      label864:
      this.svN.setVisibility(8);
      break label607;
      label876:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(69382);
    int i = paramView.getId();
    if (i == 2131302852)
    {
      paramView = new Intent();
      if (this.zQH == 0) {
        if (this.hII.HAh)
        {
          i = 1;
          paramView.putExtra("auto_deduct_flag", i);
        }
      }
      for (;;)
      {
        if (this.zQF != null)
        {
          paramView.putExtra("deduct_bank_type", this.zQF.field_bankcardType);
          paramView.putExtra("deduct_bind_serial", this.zQF.field_bindSerial);
          ad.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[] { this.zQF.field_bankcardType });
        }
        setResult(-1, paramView);
        finish();
        AppMethodBeat.o(69382);
        return;
        i = 0;
        break;
        paramView.putExtra("auto_deduct_flag", this.vIq.AfC.zRt);
      }
    }
    if ((i == 2131300212) && (!bt.isNullOrNil(this.vIq.AfC.Agk)))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.vIq.AfC.Agk);
      paramView.putExtra("showShare", false);
      com.tencent.mm.wallet_core.ui.e.X(getContext(), paramView);
    }
    AppMethodBeat.o(69382);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69374);
    super.onCreate(paramBundle);
    this.lxI = getPreferenceScreen();
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101179)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      View localView = paramBundle.findViewById(2131299154);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(2131101053));
      }
      paramBundle = paramBundle.findViewById(16908309);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(2131101179));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(-2147483648);
      if (!d.lf(23)) {
        break label188;
      }
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
    }
    for (;;)
    {
      paramBundle = getIntent();
      if (paramBundle != null) {
        break;
      }
      ad.e("MicroMsg.WalletPayDeductUI", "intent is null");
      finish();
      AppMethodBeat.o(69374);
      return;
      label188:
      getWindow().setStatusBarColor(getResources().getColor(2131099678));
    }
    this.vIq = ((Orders)paramBundle.getParcelableExtra("orders"));
    if ((this.vIq == null) || (this.vIq.AfC == null))
    {
      ad.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.vIq);
      finish();
    }
    gj(this.vIq.AfC.Agl);
    setResult(0);
    setBackBtn(new w()
    {
      public final void VR()
      {
        AppMethodBeat.i(69369);
        WalletPayDeductUI.this.setResult(0);
        WalletPayDeductUI.this.finish();
        AppMethodBeat.o(69369);
      }
    }, 2131689490);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(385, this);
    initView();
    AppMethodBeat.o(69374);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69376);
    super.onDestroy();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(385, this);
    AppMethodBeat.o(69376);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69383);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(69383);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69375);
    super.onResume();
    AppMethodBeat.o(69375);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69384);
    ad.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof m)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.g.afC();
        this.zQE = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkV, getString(2131765681)));
        com.tencent.mm.kernel.g.afC();
        this.zQD = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkU, getString(2131765684)));
        this.zQC.setText(this.zQE);
        eai();
      }
    }
    for (;;)
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(69384);
      return;
      ad.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void ss(boolean paramBoolean)
  {
    AppMethodBeat.i(69379);
    if (paramBoolean)
    {
      findViewById(16908298).setVisibility(0);
      if (this.vIq.AfC.Agm == 1)
      {
        this.svN.setVisibility(0);
        eaj();
        if (!com.tencent.mm.plugin.wallet_core.model.s.ecc().ecF()) {
          break label122;
        }
        this.zQA.setVisibility(8);
        this.iwY.setText(2131765231);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.hII.HAh);
      AppMethodBeat.o(69379);
      return;
      this.svN.setVisibility(8);
      break;
      label122:
      this.zQA.setVisibility(0);
      this.zQA.setText(2131765230);
      this.iwY.setText(2131765228);
      continue;
      if ((this.zQz != null) && (this.zQz.size() > 0))
      {
        int j = this.zQz.size();
        int i = 0;
        while (i < j)
        {
          this.lxI.cE(((Preference)this.zQz.get(i)).mKey, true);
          i += 1;
        }
      }
      findViewById(16908298).setVisibility(8);
      this.svN.setVisibility(8);
      this.zQA.setVisibility(8);
      this.iwY.setText(2131765229);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI
 * JD-Core Version:    0.7.0.1
 */