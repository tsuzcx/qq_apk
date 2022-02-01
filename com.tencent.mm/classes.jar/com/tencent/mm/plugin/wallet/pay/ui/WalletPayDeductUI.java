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
import com.tencent.mm.g.a.vm;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
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
  implements View.OnClickListener, com.tencent.mm.al.f
{
  protected ArrayList<Preference> CJh;
  protected TextView CJi;
  private TextView CJj;
  private TextView CJk;
  private String CJl;
  private String CJm;
  private Bankcard CJn;
  protected boolean CJo = false;
  private int CJp = 0;
  private String CJq;
  protected MMSwitchBtn iCB;
  protected Button jqk;
  protected com.tencent.mm.ui.base.preference.f mzx;
  private String ozC;
  private Dialog tipDialog = null;
  private LinearLayout uGl;
  protected Orders ygb;
  
  private void eDE()
  {
    AppMethodBeat.i(69378);
    s.eDp();
    Object localObject = s.eDq();
    if (this.CJn == null) {
      this.CJn = ((an)localObject).a(null, null, true, true, true);
    }
    if (this.CJn == null)
    {
      ad.i("MicroMsg.WalletPayDeductUI", "no bank card!");
      finish();
      AppMethodBeat.o(69378);
      return;
    }
    localObject = new SpannableString(this.CJn.field_desc);
    l locall = new l(getContext());
    locall.DfS = new l.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69372);
        paramAnonymousView = WalletPayDeductUI.this.getContext();
        Object localObject = this.CJs;
        String str = WalletPayDeductUI.a(WalletPayDeductUI.this);
        Bankcard localBankcard1 = WalletPayDeductUI.b(WalletPayDeductUI.this);
        h.a local1 = new h.a()
        {
          public final void Nv(int paramAnonymous2Int)
          {
            AppMethodBeat.i(69371);
            WalletPayDeductUI.a(WalletPayDeductUI.this, (Bankcard)WalletPayDeductUI.3.this.CJs.get(paramAnonymous2Int));
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
          h.a(paramAnonymousView, str, localLinkedList, k, local1);
          AppMethodBeat.o(69372);
          return;
          ad.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
          localLinkedList.add(null);
        }
      }
    };
    ((SpannableString)localObject).setSpan(locall, 0, ((SpannableString)localObject).length(), 18);
    this.CJj.setText((CharSequence)localObject);
    this.CJj.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69378);
  }
  
  private void eDF()
  {
    AppMethodBeat.i(69380);
    if ((this.CJh == null) || (this.CJh.size() <= 0))
    {
      AppMethodBeat.o(69380);
      return;
    }
    int j = this.CJh.size();
    int i = 0;
    while (i < j)
    {
      this.mzx.cP(((Preference)this.CJh.get(i)).mKey, false);
      i += 1;
    }
    this.mzx.notifyDataSetChanged();
    AppMethodBeat.o(69380);
  }
  
  private void gH(List<Orders.DeductShowInfo> paramList)
  {
    AppMethodBeat.i(69381);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
      AppMethodBeat.o(69381);
      return;
    }
    if (this.CJh == null)
    {
      int j = paramList.size();
      this.CJh = new ArrayList();
      int i = 0;
      if (i < j)
      {
        Object localObject = (Orders.DeductShowInfo)paramList.get(i);
        com.tencent.mm.plugin.wallet_core.ui.g localg;
        if ((localObject != null) && (!bt.isNullOrNil(((Orders.DeductShowInfo)localObject).name)))
        {
          localg = new com.tencent.mm.plugin.wallet_core.ui.g(this);
          localg.setTitle(((Orders.DeductShowInfo)localObject).name);
          if (((Orders.DeductShowInfo)localObject).CZc <= 0) {
            break label231;
          }
          localg.wET = getResources().getColor(2131100547);
          String str = ((Orders.DeductShowInfo)localObject).value;
          localObject = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(69373);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              ad.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", new Object[] { Integer.valueOf(this.CJu.CZc) });
              if (this.CJu.CZc == 1) {
                if (!bt.isNullOrNil(this.CJu.CZf))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("rawUrl", this.CJu.CZf);
                  paramAnonymousView.putExtra("showShare", false);
                  com.tencent.mm.wallet_core.ui.e.an(WalletPayDeductUI.this.getContext(), paramAnonymousView);
                }
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69373);
                return;
                if (this.CJu.CZc == 2)
                {
                  paramAnonymousView = new vm();
                  paramAnonymousView.dJF.userName = this.CJu.CZd;
                  paramAnonymousView.dJF.dJH = bt.bI(this.CJu.CZe, "");
                  paramAnonymousView.dJF.scene = 1097;
                  paramAnonymousView.dJF.dJI = 0;
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
                }
              }
            }
          };
          localg.mContent = str;
          localg.mClickable = true;
          localg.gMe = ((View.OnClickListener)localObject);
        }
        for (;;)
        {
          localg.setKey("deduct_info_".concat(String.valueOf(i)));
          this.CJh.add(localg);
          this.mzx.b(localg);
          this.mzx.cP(localg.mKey, true);
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
    this.CJi = ((TextView)getContentView().findViewById(2131297270));
    this.jqk = ((Button)getContentView().findViewById(2131302852));
    this.uGl = ((LinearLayout)findViewById(2131303160));
    ((TextView)findViewById(2131298948)).setText(this.ygb.CYp.title);
    ((TextView)findViewById(2131305902)).setText(((Orders.Commodity)this.ygb.CYk.get(0)).desc);
    Object localObject1 = (WalletTextView)findViewById(2131299874);
    ((WalletTextView)localObject1).setTypeface(0);
    ((WalletTextView)localObject1).setText(com.tencent.mm.wallet_core.ui.e.aYF(this.ygb.wCF));
    ((TextView)findViewById(2131299872)).setText(((Orders.Commodity)this.ygb.CYk.get(0)).paV);
    localObject1 = (TextView)findViewById(2131300212);
    Object localObject2 = (TextView)findViewById(2131298947);
    boolean bool;
    if (!bt.isNullOrNil(this.ygb.CYp.CZa))
    {
      ((TextView)localObject2).setText(this.ygb.CYp.CZa);
      if (!bt.isNullOrNil(this.ygb.CYp.CZb)) {
        ((TextView)localObject2).setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cl(this.ygb.CYp.CZb, true));
      }
      this.CJj = ((TextView)findViewById(2131298950));
      this.CJk = ((TextView)findViewById(2131297112));
      if (this.ygb.CYp.CKb != 1) {
        break label772;
      }
      bool = true;
      label314:
      this.CJo = bool;
      this.CJp = this.ygb.CYp.CJp;
      this.ozC = this.ygb.CYp.ozC;
      this.CJq = this.ygb.CYp.CJq;
      ad.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", new Object[] { Boolean.valueOf(this.CJo), Integer.valueOf(this.CJp) });
      if (this.CJp != 0) {
        break label777;
      }
      this.iCB = ((MMSwitchBtn)findViewById(2131298255));
      this.iCB.setCheck(this.CJo);
      this.iCB.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int i = 2;
          AppMethodBeat.i(69370);
          WalletPayDeductUI.this.ud(paramAnonymousBoolean);
          if (WalletPayDeductUI.this.ygb != null)
          {
            com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
            if (paramAnonymousBoolean) {
              i = 1;
            }
            localg.f(15379, new Object[] { Integer.valueOf(i), WalletPayDeductUI.this.ygb.dlu });
          }
          AppMethodBeat.o(69370);
        }
      });
      ud(this.CJo);
      label448:
      ad.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[] { Integer.valueOf(this.ygb.CYp.CYZ) });
      if (this.ygb.CYp.CYZ != 1) {
        break label864;
      }
      com.tencent.mm.kernel.g.ajD();
      this.CJm = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivc, ""));
      com.tencent.mm.kernel.g.ajD();
      this.CJl = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivb, ""));
      if ((!bt.isNullOrNil(this.CJl)) && (!bt.isNullOrNil(this.CJl))) {
        break label846;
      }
      ad.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
      this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), false, null);
      localObject2 = new m();
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject2, 0);
      label607:
      if (bt.isNullOrNil(this.ygb.CYp.CYX)) {
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
      this.jqk.setOnClickListener(this);
      AppMethodBeat.o(69377);
      return;
      ((TextView)localObject2).setVisibility(8);
      break;
      label772:
      bool = false;
      break label314;
      label777:
      if (!bt.isNullOrNil(this.ozC)) {
        this.jqk.setText(this.ozC);
      }
      if (!bt.isNullOrNil(this.CJq))
      {
        this.CJi.setText(this.CJq);
        this.CJi.setVisibility(0);
      }
      findViewById(2131298946).setVisibility(8);
      eDF();
      break label448;
      label846:
      this.CJk.setText(this.CJm);
      eDE();
      break label607;
      label864:
      this.uGl.setVisibility(8);
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    int i = paramView.getId();
    if (i == 2131302852)
    {
      paramView = new Intent();
      if (this.CJp == 0) {
        if (this.iCB.KRP)
        {
          i = 1;
          paramView.putExtra("auto_deduct_flag", i);
          label87:
          if (this.CJn != null)
          {
            paramView.putExtra("deduct_bank_type", this.CJn.field_bankcardType);
            paramView.putExtra("deduct_bind_serial", this.CJn.field_bindSerial);
            ad.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[] { this.CJn.field_bankcardType });
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
      paramView.putExtra("auto_deduct_flag", this.ygb.CYp.CKb);
      break label87;
      if ((i == 2131300212) && (!bt.isNullOrNil(this.ygb.CYp.CYX)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", this.ygb.CYp.CYX);
        paramView.putExtra("showShare", false);
        com.tencent.mm.wallet_core.ui.e.an(getContext(), paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69374);
    super.onCreate(paramBundle);
    this.mzx = getPreferenceScreen();
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
      if (!d.ly(23)) {
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
    this.ygb = ((Orders)paramBundle.getParcelableExtra("orders"));
    if ((this.ygb == null) || (this.ygb.CYp == null))
    {
      ad.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.ygb);
      finish();
    }
    gH(this.ygb.CYp.CYY);
    setResult(0);
    setBackBtn(new x()
    {
      public final void Zi()
      {
        AppMethodBeat.i(69369);
        WalletPayDeductUI.this.setResult(0);
        WalletPayDeductUI.this.finish();
        AppMethodBeat.o(69369);
      }
    }, 2131689490);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(385, this);
    initView();
    AppMethodBeat.o(69374);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69376);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(385, this);
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
    ad.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof m)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.g.ajD();
        this.CJm = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivc, getString(2131765681)));
        com.tencent.mm.kernel.g.ajD();
        this.CJl = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivb, getString(2131765684)));
        this.CJk.setText(this.CJm);
        eDE();
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
  
  protected final void ud(boolean paramBoolean)
  {
    AppMethodBeat.i(69379);
    if (paramBoolean)
    {
      findViewById(16908298).setVisibility(0);
      if (this.ygb.CYp.CYZ == 1)
      {
        this.uGl.setVisibility(0);
        eDF();
        if (!t.eFy().eGa()) {
          break label122;
        }
        this.CJi.setVisibility(8);
        this.jqk.setText(2131765231);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.iCB.KRP);
      AppMethodBeat.o(69379);
      return;
      this.uGl.setVisibility(8);
      break;
      label122:
      this.CJi.setVisibility(0);
      this.CJi.setText(2131765230);
      this.jqk.setText(2131765228);
      continue;
      if ((this.CJh != null) && (this.CJh.size() > 0))
      {
        int j = this.CJh.size();
        int i = 0;
        while (i < j)
        {
          this.mzx.cP(((Preference)this.CJh.get(i)).mKey, true);
          i += 1;
        }
      }
      findViewById(16908298).setVisibility(8);
      this.uGl.setVisibility(8);
      this.CJi.setVisibility(8);
      this.jqk.setText(2131765229);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI
 * JD-Core Version:    0.7.0.1
 */