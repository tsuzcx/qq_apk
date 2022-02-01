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
import com.tencent.mm.g.a.ut;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
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
  implements View.OnClickListener, com.tencent.mm.ak.g
{
  protected ArrayList<Preference> BiT;
  protected TextView BiU;
  private TextView BiV;
  private TextView BiW;
  private String BiX;
  private String BiY;
  private Bankcard BiZ;
  protected boolean Bja = false;
  private int Bjb = 0;
  private String Bjc;
  protected Button iXb;
  protected MMSwitchBtn ijk;
  protected f lZC;
  private String nWi;
  private LinearLayout tDC;
  private Dialog tipDialog = null;
  protected Orders wSu;
  
  private void epE()
  {
    AppMethodBeat.i(69378);
    com.tencent.mm.plugin.wallet.a.s.epp();
    Object localObject = com.tencent.mm.plugin.wallet.a.s.epq();
    if (this.BiZ == null) {
      this.BiZ = ((am)localObject).a(null, null, true, true, true);
    }
    if (this.BiZ == null)
    {
      ac.i("MicroMsg.WalletPayDeductUI", "no bank card!");
      finish();
      AppMethodBeat.o(69378);
      return;
    }
    localObject = new SpannableString(this.BiZ.field_desc);
    l locall = new l(getContext());
    locall.BFA = new l.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69372);
        paramAnonymousView = WalletPayDeductUI.this.getContext();
        Object localObject = this.Bje;
        String str = WalletPayDeductUI.a(WalletPayDeductUI.this);
        Bankcard localBankcard1 = WalletPayDeductUI.b(WalletPayDeductUI.this);
        h.a local1 = new h.a()
        {
          public final void LW(int paramAnonymous2Int)
          {
            AppMethodBeat.i(69371);
            WalletPayDeductUI.a(WalletPayDeductUI.this, (Bankcard)WalletPayDeductUI.3.this.Bje.get(paramAnonymous2Int));
            WalletPayDeductUI.c(WalletPayDeductUI.this);
            AppMethodBeat.o(69371);
          }
        };
        LinkedList localLinkedList = new LinkedList();
        if (((localObject == null) || (((List)localObject).size() == 0)) && (bs.isNullOrNil(null)))
        {
          ac.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
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
          if (!bs.isNullOrNil(null))
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
          ac.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
          localLinkedList.add(null);
        }
      }
    };
    ((SpannableString)localObject).setSpan(locall, 0, ((SpannableString)localObject).length(), 18);
    this.BiV.setText((CharSequence)localObject);
    this.BiV.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69378);
  }
  
  private void epF()
  {
    AppMethodBeat.i(69380);
    if ((this.BiT == null) || (this.BiT.size() <= 0))
    {
      AppMethodBeat.o(69380);
      return;
    }
    int j = this.BiT.size();
    int i = 0;
    while (i < j)
    {
      this.lZC.cK(((Preference)this.BiT.get(i)).mKey, false);
      i += 1;
    }
    this.lZC.notifyDataSetChanged();
    AppMethodBeat.o(69380);
  }
  
  private void gu(List<Orders.DeductShowInfo> paramList)
  {
    AppMethodBeat.i(69381);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
      AppMethodBeat.o(69381);
      return;
    }
    if (this.BiT == null)
    {
      int j = paramList.size();
      this.BiT = new ArrayList();
      int i = 0;
      if (i < j)
      {
        Object localObject = (Orders.DeductShowInfo)paramList.get(i);
        com.tencent.mm.plugin.wallet_core.ui.g localg;
        if ((localObject != null) && (!bs.isNullOrNil(((Orders.DeductShowInfo)localObject).name)))
        {
          localg = new com.tencent.mm.plugin.wallet_core.ui.g(this);
          localg.setTitle(((Orders.DeductShowInfo)localObject).name);
          if (((Orders.DeductShowInfo)localObject).ByJ <= 0) {
            break label231;
          }
          localg.vzz = getResources().getColor(2131100547);
          String str = ((Orders.DeductShowInfo)localObject).value;
          localObject = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(69373);
              ac.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", new Object[] { Integer.valueOf(this.Bjg.ByJ) });
              if (this.Bjg.ByJ == 1)
              {
                if (!bs.isNullOrNil(this.Bjg.ByM))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("rawUrl", this.Bjg.ByM);
                  paramAnonymousView.putExtra("showShare", false);
                  com.tencent.mm.wallet_core.ui.e.al(WalletPayDeductUI.this.getContext(), paramAnonymousView);
                  AppMethodBeat.o(69373);
                }
              }
              else if (this.Bjg.ByJ == 2)
              {
                paramAnonymousView = new ut();
                paramAnonymousView.dxt.userName = this.Bjg.ByK;
                paramAnonymousView.dxt.dxv = bs.bG(this.Bjg.ByL, "");
                paramAnonymousView.dxt.scene = 1097;
                paramAnonymousView.dxt.dxw = 0;
                a.GpY.l(paramAnonymousView);
              }
              AppMethodBeat.o(69373);
            }
          };
          localg.mContent = str;
          localg.mClickable = true;
          localg.gst = ((View.OnClickListener)localObject);
        }
        for (;;)
        {
          localg.setKey("deduct_info_".concat(String.valueOf(i)));
          this.BiT.add(localg);
          this.lZC.b(localg);
          this.lZC.cK(localg.mKey, true);
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
    this.BiU = ((TextView)getContentView().findViewById(2131297270));
    this.iXb = ((Button)getContentView().findViewById(2131302852));
    this.tDC = ((LinearLayout)findViewById(2131303160));
    ((TextView)findViewById(2131298948)).setText(this.wSu.BxW.title);
    ((TextView)findViewById(2131305902)).setText(((Orders.Commodity)this.wSu.BxR.get(0)).desc);
    Object localObject1 = (WalletTextView)findViewById(2131299874);
    ((WalletTextView)localObject1).setTypeface(0);
    ((WalletTextView)localObject1).setText(com.tencent.mm.wallet_core.ui.e.aSG(this.wSu.vxl));
    ((TextView)findViewById(2131299872)).setText(((Orders.Commodity)this.wSu.BxR.get(0)).oxA);
    localObject1 = (TextView)findViewById(2131300212);
    Object localObject2 = (TextView)findViewById(2131298947);
    boolean bool;
    if (!bs.isNullOrNil(this.wSu.BxW.ByH))
    {
      ((TextView)localObject2).setText(this.wSu.BxW.ByH);
      if (!bs.isNullOrNil(this.wSu.BxW.ByI)) {
        ((TextView)localObject2).setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cd(this.wSu.BxW.ByI, true));
      }
      this.BiV = ((TextView)findViewById(2131298950));
      this.BiW = ((TextView)findViewById(2131297112));
      if (this.wSu.BxW.BjN != 1) {
        break label772;
      }
      bool = true;
      label314:
      this.Bja = bool;
      this.Bjb = this.wSu.BxW.Bjb;
      this.nWi = this.wSu.BxW.nWi;
      this.Bjc = this.wSu.BxW.Bjc;
      ac.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", new Object[] { Boolean.valueOf(this.Bja), Integer.valueOf(this.Bjb) });
      if (this.Bjb != 0) {
        break label777;
      }
      this.ijk = ((MMSwitchBtn)findViewById(2131298255));
      this.ijk.setCheck(this.Bja);
      this.ijk.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int i = 2;
          AppMethodBeat.i(69370);
          WalletPayDeductUI.this.tt(paramAnonymousBoolean);
          if (WalletPayDeductUI.this.wSu != null)
          {
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
            if (paramAnonymousBoolean) {
              i = 1;
            }
            localh.f(15379, new Object[] { Integer.valueOf(i), WalletPayDeductUI.this.wSu.dac });
          }
          AppMethodBeat.o(69370);
        }
      });
      tt(this.Bja);
      label448:
      ac.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[] { Integer.valueOf(this.wSu.BxW.ByG) });
      if (this.wSu.BxW.ByG != 1) {
        break label864;
      }
      com.tencent.mm.kernel.g.agS();
      this.BiY = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIK, ""));
      com.tencent.mm.kernel.g.agS();
      this.BiX = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIJ, ""));
      if ((!bs.isNullOrNil(this.BiX)) && (!bs.isNullOrNil(this.BiX))) {
        break label846;
      }
      ac.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
      this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), false, null);
      localObject2 = new m();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject2, 0);
      label607:
      if (bs.isNullOrNil(this.wSu.BxW.ByE)) {
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
      this.iXb.setOnClickListener(this);
      AppMethodBeat.o(69377);
      return;
      ((TextView)localObject2).setVisibility(8);
      break;
      label772:
      bool = false;
      break label314;
      label777:
      if (!bs.isNullOrNil(this.nWi)) {
        this.iXb.setText(this.nWi);
      }
      if (!bs.isNullOrNil(this.Bjc))
      {
        this.BiU.setText(this.Bjc);
        this.BiU.setVisibility(0);
      }
      findViewById(2131298946).setVisibility(8);
      epF();
      break label448;
      label846:
      this.BiW.setText(this.BiY);
      epE();
      break label607;
      label864:
      this.tDC.setVisibility(8);
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
      if (this.Bjb == 0) {
        if (this.ijk.JaE)
        {
          i = 1;
          paramView.putExtra("auto_deduct_flag", i);
        }
      }
      for (;;)
      {
        if (this.BiZ != null)
        {
          paramView.putExtra("deduct_bank_type", this.BiZ.field_bankcardType);
          paramView.putExtra("deduct_bind_serial", this.BiZ.field_bindSerial);
          ac.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[] { this.BiZ.field_bankcardType });
        }
        setResult(-1, paramView);
        finish();
        AppMethodBeat.o(69382);
        return;
        i = 0;
        break;
        paramView.putExtra("auto_deduct_flag", this.wSu.BxW.BjN);
      }
    }
    if ((i == 2131300212) && (!bs.isNullOrNil(this.wSu.BxW.ByE)))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.wSu.BxW.ByE);
      paramView.putExtra("showShare", false);
      com.tencent.mm.wallet_core.ui.e.al(getContext(), paramView);
    }
    AppMethodBeat.o(69382);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69374);
    super.onCreate(paramBundle);
    this.lZC = getPreferenceScreen();
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
      if (!d.kZ(23)) {
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
      ac.e("MicroMsg.WalletPayDeductUI", "intent is null");
      finish();
      AppMethodBeat.o(69374);
      return;
      label188:
      getWindow().setStatusBarColor(getResources().getColor(2131099678));
    }
    this.wSu = ((Orders)paramBundle.getParcelableExtra("orders"));
    if ((this.wSu == null) || (this.wSu.BxW == null))
    {
      ac.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.wSu);
      finish();
    }
    gu(this.wSu.BxW.ByF);
    setResult(0);
    setBackBtn(new x()
    {
      public final void WP()
      {
        AppMethodBeat.i(69369);
        WalletPayDeductUI.this.setResult(0);
        WalletPayDeductUI.this.finish();
        AppMethodBeat.o(69369);
      }
    }, 2131689490);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
    initView();
    AppMethodBeat.o(69374);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69376);
    super.onDestroy();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
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
    ac.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof m)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.g.agS();
        this.BiY = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIK, getString(2131765681)));
        com.tencent.mm.kernel.g.agS();
        this.BiX = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIJ, getString(2131765684)));
        this.BiW.setText(this.BiY);
        epE();
      }
    }
    for (;;)
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(69384);
      return;
      ac.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void tt(boolean paramBoolean)
  {
    AppMethodBeat.i(69379);
    if (paramBoolean)
    {
      findViewById(16908298).setVisibility(0);
      if (this.wSu.BxW.ByG == 1)
      {
        this.tDC.setVisibility(0);
        epF();
        if (!com.tencent.mm.plugin.wallet_core.model.s.ery().esa()) {
          break label122;
        }
        this.BiU.setVisibility(8);
        this.iXb.setText(2131765231);
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.ijk.JaE);
      AppMethodBeat.o(69379);
      return;
      this.tDC.setVisibility(8);
      break;
      label122:
      this.BiU.setVisibility(0);
      this.BiU.setText(2131765230);
      this.iXb.setText(2131765228);
      continue;
      if ((this.BiT != null) && (this.BiT.size() > 0))
      {
        int j = this.BiT.size();
        int i = 0;
        while (i < j)
        {
          this.lZC.cK(((Preference)this.BiT.get(i)).mKey, true);
          i += 1;
        }
      }
      findViewById(16908298).setVisibility(8);
      this.tDC.setVisibility(8);
      this.BiU.setVisibility(8);
      this.iXb.setText(2131765229);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI
 * JD-Core Version:    0.7.0.1
 */