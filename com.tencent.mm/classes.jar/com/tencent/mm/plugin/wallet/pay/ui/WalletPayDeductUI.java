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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletPayDeductUI
  extends MMPreference
  implements View.OnClickListener, com.tencent.mm.ak.f
{
  protected ArrayList<Preference> DaN;
  protected TextView DaO;
  private TextView DaP;
  private TextView DaQ;
  private String DaR;
  private String DaS;
  private Bankcard DaT;
  protected boolean DaU = false;
  private int DaV = 0;
  private String DaW;
  protected MMSwitchBtn iFu;
  protected Button jtd;
  protected com.tencent.mm.ui.base.preference.f mEx;
  private String oGe;
  private Dialog tipDialog = null;
  private LinearLayout uRY;
  protected Orders yvS;
  
  private void eHl()
  {
    AppMethodBeat.i(69378);
    s.eGW();
    Object localObject = s.eGX();
    if (this.DaT == null) {
      this.DaT = ((an)localObject).a(null, null, true, true, true);
    }
    if (this.DaT == null)
    {
      ae.i("MicroMsg.WalletPayDeductUI", "no bank card!");
      finish();
      AppMethodBeat.o(69378);
      return;
    }
    localObject = new SpannableString(this.DaT.field_desc);
    l locall = new l(getContext());
    locall.Dxw = new l.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69372);
        paramAnonymousView = WalletPayDeductUI.this.getContext();
        Object localObject = this.DaY;
        String str = WalletPayDeductUI.a(WalletPayDeductUI.this);
        Bankcard localBankcard1 = WalletPayDeductUI.b(WalletPayDeductUI.this);
        h.a local1 = new h.a()
        {
          public final void Ob(int paramAnonymous2Int)
          {
            AppMethodBeat.i(69371);
            WalletPayDeductUI.a(WalletPayDeductUI.this, (Bankcard)WalletPayDeductUI.3.this.DaY.get(paramAnonymous2Int));
            WalletPayDeductUI.c(WalletPayDeductUI.this);
            AppMethodBeat.o(69371);
          }
        };
        LinkedList localLinkedList = new LinkedList();
        if (((localObject == null) || (((List)localObject).size() == 0)) && (bu.isNullOrNil(null)))
        {
          ae.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
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
          if (!bu.isNullOrNil(null))
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
          ae.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
          localLinkedList.add(null);
        }
      }
    };
    ((SpannableString)localObject).setSpan(locall, 0, ((SpannableString)localObject).length(), 18);
    this.DaP.setText((CharSequence)localObject);
    this.DaP.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69378);
  }
  
  private void eHm()
  {
    AppMethodBeat.i(69380);
    if ((this.DaN == null) || (this.DaN.size() <= 0))
    {
      AppMethodBeat.o(69380);
      return;
    }
    int j = this.DaN.size();
    int i = 0;
    while (i < j)
    {
      this.mEx.cT(((Preference)this.DaN.get(i)).mKey, false);
      i += 1;
    }
    this.mEx.notifyDataSetChanged();
    AppMethodBeat.o(69380);
  }
  
  private void gQ(List<Orders.DeductShowInfo> paramList)
  {
    AppMethodBeat.i(69381);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
      AppMethodBeat.o(69381);
      return;
    }
    if (this.DaN == null)
    {
      int j = paramList.size();
      this.DaN = new ArrayList();
      int i = 0;
      if (i < j)
      {
        Object localObject = (Orders.DeductShowInfo)paramList.get(i);
        com.tencent.mm.plugin.wallet_core.ui.g localg;
        if ((localObject != null) && (!bu.isNullOrNil(((Orders.DeductShowInfo)localObject).name)))
        {
          localg = new com.tencent.mm.plugin.wallet_core.ui.g(this);
          localg.setTitle(((Orders.DeductShowInfo)localObject).name);
          if (((Orders.DeductShowInfo)localObject).DqH <= 0) {
            break label231;
          }
          localg.wUE = getResources().getColor(2131100547);
          String str = ((Orders.DeductShowInfo)localObject).value;
          localObject = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(69373);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", new Object[] { Integer.valueOf(this.Dba.DqH) });
              if (this.Dba.DqH == 1) {
                if (!bu.isNullOrNil(this.Dba.DqK))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("rawUrl", this.Dba.DqK);
                  paramAnonymousView.putExtra("showShare", false);
                  com.tencent.mm.wallet_core.ui.f.an(WalletPayDeductUI.this.getContext(), paramAnonymousView);
                }
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69373);
                return;
                if (this.Dba.DqH == 2)
                {
                  paramAnonymousView = new vq();
                  paramAnonymousView.dKT.userName = this.Dba.DqI;
                  paramAnonymousView.dKT.dKV = bu.bI(this.Dba.DqJ, "");
                  paramAnonymousView.dKT.scene = 1097;
                  paramAnonymousView.dKT.dKW = 0;
                  com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
                }
              }
            }
          };
          localg.mContent = str;
          localg.mClickable = true;
          localg.gON = ((View.OnClickListener)localObject);
        }
        for (;;)
        {
          localg.setKey("deduct_info_".concat(String.valueOf(i)));
          this.DaN.add(localg);
          this.mEx.b(localg);
          this.mEx.cT(localg.mKey, true);
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
    this.DaO = ((TextView)getContentView().findViewById(2131297270));
    this.jtd = ((Button)getContentView().findViewById(2131302852));
    this.uRY = ((LinearLayout)findViewById(2131303160));
    ((TextView)findViewById(2131298948)).setText(this.yvS.DpU.title);
    ((TextView)findViewById(2131305902)).setText(((Orders.Commodity)this.yvS.DpP.get(0)).desc);
    Object localObject1 = (WalletTextView)findViewById(2131299874);
    ((WalletTextView)localObject1).setTypeface(0);
    ((WalletTextView)localObject1).setText(com.tencent.mm.wallet_core.ui.f.bai(this.yvS.wSq));
    ((TextView)findViewById(2131299872)).setText(((Orders.Commodity)this.yvS.DpP.get(0)).phz);
    localObject1 = (TextView)findViewById(2131300212);
    Object localObject2 = (TextView)findViewById(2131298947);
    boolean bool;
    if (!bu.isNullOrNil(this.yvS.DpU.DqF))
    {
      ((TextView)localObject2).setText(this.yvS.DpU.DqF);
      if (!bu.isNullOrNil(this.yvS.DpU.DqG)) {
        ((TextView)localObject2).setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cp(this.yvS.DpU.DqG, true));
      }
      this.DaP = ((TextView)findViewById(2131298950));
      this.DaQ = ((TextView)findViewById(2131297112));
      if (this.yvS.DpU.DbH != 1) {
        break label772;
      }
      bool = true;
      label314:
      this.DaU = bool;
      this.DaV = this.yvS.DpU.DaV;
      this.oGe = this.yvS.DpU.oGe;
      this.DaW = this.yvS.DpU.DaW;
      ae.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", new Object[] { Boolean.valueOf(this.DaU), Integer.valueOf(this.DaV) });
      if (this.DaV != 0) {
        break label777;
      }
      this.iFu = ((MMSwitchBtn)findViewById(2131298255));
      this.iFu.setCheck(this.DaU);
      this.iFu.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int i = 2;
          AppMethodBeat.i(69370);
          WalletPayDeductUI.this.uk(paramAnonymousBoolean);
          if (WalletPayDeductUI.this.yvS != null)
          {
            com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
            if (paramAnonymousBoolean) {
              i = 1;
            }
            localg.f(15379, new Object[] { Integer.valueOf(i), WalletPayDeductUI.this.yvS.dmw });
          }
          AppMethodBeat.o(69370);
        }
      });
      uk(this.DaU);
      label448:
      ae.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[] { Integer.valueOf(this.yvS.DpU.DqE) });
      if (this.yvS.DpU.DqE != 1) {
        break label864;
      }
      com.tencent.mm.kernel.g.ajS();
      this.DaS = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPA, ""));
      com.tencent.mm.kernel.g.ajS();
      this.DaR = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPz, ""));
      if ((!bu.isNullOrNil(this.DaR)) && (!bu.isNullOrNil(this.DaR))) {
        break label846;
      }
      ae.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
      this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(getContext(), false, null);
      localObject2 = new m();
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject2, 0);
      label607:
      if (bu.isNullOrNil(this.yvS.DpU.DqC)) {
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
      this.jtd.setOnClickListener(this);
      AppMethodBeat.o(69377);
      return;
      ((TextView)localObject2).setVisibility(8);
      break;
      label772:
      bool = false;
      break label314;
      label777:
      if (!bu.isNullOrNil(this.oGe)) {
        this.jtd.setText(this.oGe);
      }
      if (!bu.isNullOrNil(this.DaW))
      {
        this.DaO.setText(this.DaW);
        this.DaO.setVisibility(0);
      }
      findViewById(2131298946).setVisibility(8);
      eHm();
      break label448;
      label846:
      this.DaQ.setText(this.DaS);
      eHl();
      break label607;
      label864:
      this.uRY.setVisibility(8);
      break label607;
      label876:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(69382);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    int i = paramView.getId();
    if (i == 2131302852)
    {
      paramView = new Intent();
      if (this.DaV == 0) {
        if (this.iFu.Lon)
        {
          i = 1;
          paramView.putExtra("auto_deduct_flag", i);
          label87:
          if (this.DaT != null)
          {
            paramView.putExtra("deduct_bank_type", this.DaT.field_bankcardType);
            paramView.putExtra("deduct_bind_serial", this.DaT.field_bindSerial);
            ae.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[] { this.DaT.field_bankcardType });
          }
          setResult(-1, paramView);
          finish();
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(69382);
      return;
      i = 0;
      break;
      paramView.putExtra("auto_deduct_flag", this.yvS.DpU.DbH);
      break label87;
      if ((i == 2131300212) && (!bu.isNullOrNil(this.yvS.DpU.DqC)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", this.yvS.DpU.DqC);
        paramView.putExtra("showShare", false);
        com.tencent.mm.wallet_core.ui.f.an(getContext(), paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69374);
    super.onCreate(paramBundle);
    this.mEx = getPreferenceScreen();
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
      if (!d.lA(23)) {
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
      ae.e("MicroMsg.WalletPayDeductUI", "intent is null");
      finish();
      AppMethodBeat.o(69374);
      return;
      label188:
      getWindow().setStatusBarColor(getResources().getColor(2131099678));
    }
    this.yvS = ((Orders)paramBundle.getParcelableExtra("orders"));
    if ((this.yvS == null) || (this.yvS.DpU == null))
    {
      ae.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.yvS);
      finish();
    }
    gQ(this.yvS.DpU.DqD);
    setResult(0);
    setBackBtn(new x()
    {
      public final void Zr()
      {
        AppMethodBeat.i(69369);
        WalletPayDeductUI.this.setResult(0);
        WalletPayDeductUI.this.finish();
        AppMethodBeat.o(69369);
      }
    }, 2131689490);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(385, this);
    initView();
    AppMethodBeat.o(69374);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69376);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(385, this);
    AppMethodBeat.o(69376);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69383);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(69383);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
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
    ae.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof m)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.g.ajS();
        this.DaS = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPA, getString(2131765681)));
        com.tencent.mm.kernel.g.ajS();
        this.DaR = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPz, getString(2131765684)));
        this.DaQ.setText(this.DaS);
        eHl();
      }
    }
    for (;;)
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(69384);
      return;
      ae.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void uk(boolean paramBoolean)
  {
    AppMethodBeat.i(69379);
    if (paramBoolean)
    {
      findViewById(16908298).setVisibility(0);
      if (this.yvS.DpU.DqE == 1)
      {
        this.uRY.setVisibility(0);
        eHm();
        if (!t.eJf().eJH()) {
          break label122;
        }
        this.DaO.setVisibility(8);
        this.jtd.setText(2131765231);
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.iFu.Lon);
      AppMethodBeat.o(69379);
      return;
      this.uRY.setVisibility(8);
      break;
      label122:
      this.DaO.setVisibility(0);
      this.DaO.setText(2131765230);
      this.jtd.setText(2131765228);
      continue;
      if ((this.DaN != null) && (this.DaN.size() > 0))
      {
        int j = this.DaN.size();
        int i = 0;
        while (i < j)
        {
          this.mEx.cT(((Preference)this.DaN.get(i)).mKey, true);
          i += 1;
        }
      }
      findViewById(16908298).setVisibility(8);
      this.uRY.setVisibility(8);
      this.DaO.setVisibility(8);
      this.jtd.setText(2131765229);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI
 * JD-Core Version:    0.7.0.1
 */