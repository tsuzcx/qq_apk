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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.a.a;
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
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletPayDeductUI
  extends MMPreference
  implements View.OnClickListener, i
{
  protected Orders CwO;
  protected ArrayList<Preference> HGB;
  protected TextView HGC;
  private TextView HGD;
  private TextView HGE;
  private String HGF;
  private String HGG;
  private Bankcard HGH;
  protected boolean HGI = false;
  private int HGJ = 0;
  private String HGK;
  protected MMSwitchBtn jBx;
  protected Button krs;
  protected com.tencent.mm.ui.base.preference.f nRm;
  private String pTK;
  private Dialog tipDialog = null;
  private LinearLayout ykB;
  
  private void fOv()
  {
    AppMethodBeat.i(69378);
    s.fOg();
    Object localObject = s.fOh();
    if (this.HGH == null) {
      this.HGH = ((an)localObject).a(null, null, true, true, true);
    }
    if (this.HGH == null)
    {
      Log.i("MicroMsg.WalletPayDeductUI", "no bank card!");
      finish();
      AppMethodBeat.o(69378);
      return;
    }
    localObject = new SpannableString(this.HGH.field_desc);
    com.tencent.mm.plugin.wallet_core.ui.l locall = new com.tencent.mm.plugin.wallet_core.ui.l(getContext());
    locall.IgH = new l.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69372);
        paramAnonymousView = WalletPayDeductUI.this.getContext();
        Object localObject = this.HGM;
        String str = WalletPayDeductUI.a(WalletPayDeductUI.this);
        Bankcard localBankcard1 = WalletPayDeductUI.b(WalletPayDeductUI.this);
        h.a local1 = new h.a()
        {
          public final void Vq(int paramAnonymous2Int)
          {
            AppMethodBeat.i(69371);
            WalletPayDeductUI.a(WalletPayDeductUI.this, (Bankcard)WalletPayDeductUI.3.this.HGM.get(paramAnonymous2Int));
            WalletPayDeductUI.c(WalletPayDeductUI.this);
            AppMethodBeat.o(69371);
          }
        };
        LinkedList localLinkedList = new LinkedList();
        if (((localObject == null) || (((List)localObject).size() == 0)) && (Util.isNullOrNil(null)))
        {
          Log.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
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
          if (!Util.isNullOrNil(null))
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
          Log.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
          localLinkedList.add(null);
        }
      }
    };
    ((SpannableString)localObject).setSpan(locall, 0, ((SpannableString)localObject).length(), 18);
    this.HGD.setText((CharSequence)localObject);
    this.HGD.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(69378);
  }
  
  private void fOw()
  {
    AppMethodBeat.i(69380);
    if ((this.HGB == null) || (this.HGB.size() <= 0))
    {
      AppMethodBeat.o(69380);
      return;
    }
    int j = this.HGB.size();
    int i = 0;
    while (i < j)
    {
      this.nRm.jdMethod_do(((Preference)this.HGB.get(i)).mKey, false);
      i += 1;
    }
    this.nRm.notifyDataSetChanged();
    AppMethodBeat.o(69380);
  }
  
  private void hW(List<Orders.DeductShowInfo> paramList)
  {
    AppMethodBeat.i(69381);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
      AppMethodBeat.o(69381);
      return;
    }
    if (this.HGB == null)
    {
      int j = paramList.size();
      this.HGB = new ArrayList();
      int i = 0;
      if (i < j)
      {
        Object localObject = (Orders.DeductShowInfo)paramList.get(i);
        com.tencent.mm.plugin.wallet_core.ui.g localg;
        if ((localObject != null) && (!Util.isNullOrNil(((Orders.DeductShowInfo)localObject).name)))
        {
          localg = new com.tencent.mm.plugin.wallet_core.ui.g(this);
          localg.setTitle(((Orders.DeductShowInfo)localObject).name);
          if (((Orders.DeductShowInfo)localObject).gTx <= 0) {
            break label231;
          }
          localg.AQA = getResources().getColor(2131100685);
          String str = ((Orders.DeductShowInfo)localObject).value;
          localObject = new WalletPayDeductUI.4(this, (Orders.DeductShowInfo)localObject);
          localg.mContent = str;
          localg.mClickable = true;
          localg.hEZ = ((View.OnClickListener)localObject);
        }
        for (;;)
        {
          localg.setKey("deduct_info_".concat(String.valueOf(i)));
          this.HGB.add(localg);
          this.nRm.c(localg);
          this.nRm.jdMethod_do(localg.mKey, true);
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
    return 2131496983;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69377);
    this.HGC = ((TextView)getContentView().findViewById(2131297427));
    this.krs = ((Button)getContentView().findViewById(2131305423));
    this.ykB = ((LinearLayout)findViewById(2131305817));
    ((TextView)findViewById(2131299439)).setText(this.CwO.HZi.title);
    ((TextView)findViewById(2131309195)).setText(((Orders.Commodity)this.CwO.HZd.get(0)).desc);
    Object localObject1 = (WalletTextView)findViewById(2131300554);
    ((WalletTextView)localObject1).setTypeface(0);
    ((WalletTextView)localObject1).setText(com.tencent.mm.wallet_core.ui.f.bpq(this.CwO.AOl));
    ((TextView)findViewById(2131300552)).setText(((Orders.Commodity)this.CwO.HZd.get(0)).qwJ);
    localObject1 = (TextView)findViewById(2131301681);
    Object localObject2 = (TextView)findViewById(2131299438);
    boolean bool;
    if (!Util.isNullOrNil(this.CwO.HZi.HZT))
    {
      ((TextView)localObject2).setText(this.CwO.HZi.HZT);
      if (!Util.isNullOrNil(this.CwO.HZi.HZU)) {
        ((TextView)localObject2).setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CwO.HZi.HZU, true));
      }
      this.HGD = ((TextView)findViewById(2131299441));
      this.HGE = ((TextView)findViewById(2131297257));
      if (this.CwO.HZi.HHv != 1) {
        break label772;
      }
      bool = true;
      label314:
      this.HGI = bool;
      this.HGJ = this.CwO.HZi.HGJ;
      this.pTK = this.CwO.HZi.pTK;
      this.HGK = this.CwO.HZi.HGK;
      Log.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", new Object[] { Boolean.valueOf(this.HGI), Integer.valueOf(this.HGJ) });
      if (this.HGJ != 0) {
        break label777;
      }
      this.jBx = ((MMSwitchBtn)findViewById(2131298639));
      this.jBx.setCheck(this.HGI);
      this.jBx.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          int i = 2;
          AppMethodBeat.i(69370);
          WalletPayDeductUI.this.xV(paramAnonymousBoolean);
          if (WalletPayDeductUI.this.CwO != null)
          {
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
            if (paramAnonymousBoolean) {
              i = 1;
            }
            localh.a(15379, new Object[] { Integer.valueOf(i), WalletPayDeductUI.this.CwO.dDL });
          }
          AppMethodBeat.o(69370);
        }
      });
      xV(this.HGI);
      label448:
      Log.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[] { Integer.valueOf(this.CwO.HZi.HZS) });
      if (this.CwO.HZi.HZS != 1) {
        break label864;
      }
      com.tencent.mm.kernel.g.aAi();
      this.HGG = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXB, ""));
      com.tencent.mm.kernel.g.aAi();
      this.HGF = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXA, ""));
      if ((!Util.isNullOrNil(this.HGF)) && (!Util.isNullOrNil(this.HGF))) {
        break label846;
      }
      Log.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
      this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(getContext(), false, null);
      localObject2 = new m();
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a((q)localObject2, 0);
      label607:
      if (Util.isNullOrNil(this.CwO.HZi.HZQ)) {
        break label876;
      }
      Object localObject3 = getString(2131767669);
      localObject2 = getString(2131767670);
      localObject3 = com.tencent.mm.pluginsdk.ui.span.l.c(this, getString(2131767668, new Object[] { localObject3, localObject2 }));
      com.tencent.mm.plugin.wallet_core.ui.l locall = new com.tencent.mm.plugin.wallet_core.ui.l(getContext());
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject3);
      localSpannableString.setSpan(locall, ((CharSequence)localObject3).length() - ((String)localObject2).length(), ((CharSequence)localObject3).length(), 33);
      ((TextView)localObject1).setTextColor(getResources().getColor(2131100594));
      ((TextView)localObject1).setText(localSpannableString);
      ((TextView)localObject1).setOnClickListener(this);
      ((TextView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.krs.setOnClickListener(this);
      AppMethodBeat.o(69377);
      return;
      ((TextView)localObject2).setVisibility(8);
      break;
      label772:
      bool = false;
      break label314;
      label777:
      if (!Util.isNullOrNil(this.pTK)) {
        this.krs.setText(this.pTK);
      }
      if (!Util.isNullOrNil(this.HGK))
      {
        this.HGC.setText(this.HGK);
        this.HGC.setVisibility(0);
      }
      findViewById(2131299437).setVisibility(8);
      fOw();
      break label448;
      label846:
      this.HGE.setText(this.HGG);
      fOv();
      break label607;
      label864:
      this.ykB.setVisibility(8);
      break label607;
      label876:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(69382);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    int i = paramView.getId();
    if (i == 2131305423)
    {
      paramView = new Intent();
      if (this.HGJ == 0) {
        if (this.jBx.QDw)
        {
          i = 1;
          paramView.putExtra("auto_deduct_flag", i);
          label87:
          if (this.HGH != null)
          {
            paramView.putExtra("deduct_bank_type", this.HGH.field_bankcardType);
            paramView.putExtra("deduct_bind_serial", this.HGH.field_bindSerial);
            Log.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[] { this.HGH.field_bankcardType });
          }
          setResult(-1, paramView);
          finish();
        }
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(69382);
      return;
      i = 0;
      break;
      paramView.putExtra("auto_deduct_flag", this.CwO.HZi.HHv);
      break label87;
      if ((i == 2131301681) && (!Util.isNullOrNil(this.CwO.HZi.HZQ)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", this.CwO.HZi.HZQ);
        paramView.putExtra("showShare", false);
        com.tencent.mm.wallet_core.ui.f.aA(getContext(), paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69374);
    super.onCreate(paramBundle);
    this.nRm = getPreferenceScreen();
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101424)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      View localView = paramBundle.findViewById(2131299682);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(2131101287));
      }
      paramBundle = paramBundle.findViewById(16908309);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(2131101424));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(-2147483648);
      if (!d.oD(23)) {
        break label188;
      }
      getWindow().setStatusBarColor(getResources().getColor(2131101424));
    }
    for (;;)
    {
      paramBundle = getIntent();
      if (paramBundle != null) {
        break;
      }
      Log.e("MicroMsg.WalletPayDeductUI", "intent is null");
      finish();
      AppMethodBeat.o(69374);
      return;
      label188:
      getWindow().setStatusBarColor(getResources().getColor(2131099687));
    }
    this.CwO = ((Orders)paramBundle.getParcelableExtra("orders"));
    if ((this.CwO == null) || (this.CwO.HZi == null))
    {
      Log.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.CwO);
      finish();
    }
    hW(this.CwO.HZi.HZR);
    setResult(0);
    setBackBtn(new y()
    {
      public final void ane()
      {
        AppMethodBeat.i(69369);
        WalletPayDeductUI.this.setResult(0);
        WalletPayDeductUI.this.finish();
        AppMethodBeat.o(69369);
      }
    }, 2131689492);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(385, this);
    initView();
    AppMethodBeat.o(69374);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69376);
    super.onDestroy();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(385, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69384);
    Log.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramq instanceof m)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.g.aAi();
        this.HGG = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXB, getString(2131768134)));
        com.tencent.mm.kernel.g.aAi();
        this.HGF = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXA, getString(2131768137)));
        this.HGE.setText(this.HGG);
        fOv();
      }
    }
    for (;;)
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(69384);
      return;
      Log.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void xV(boolean paramBoolean)
  {
    AppMethodBeat.i(69379);
    if (paramBoolean)
    {
      findViewById(16908298).setVisibility(0);
      if (this.CwO.HZi.HZS == 1)
      {
        this.ykB.setVisibility(0);
        fOw();
        if (!com.tencent.mm.plugin.wallet_core.model.t.fQI().fRk()) {
          break label122;
        }
        this.HGC.setVisibility(8);
        this.krs.setText(2131767674);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.jBx.QDw);
      AppMethodBeat.o(69379);
      return;
      this.ykB.setVisibility(8);
      break;
      label122:
      this.HGC.setVisibility(0);
      this.HGC.setText(2131767673);
      this.krs.setText(2131767671);
      continue;
      if ((this.HGB != null) && (this.HGB.size() > 0))
      {
        int j = this.HGB.size();
        int i = 0;
        while (i < j)
        {
          this.nRm.jdMethod_do(((Preference)this.HGB.get(i)).mKey, true);
          i += 1;
        }
      }
      findViewById(16908298).setVisibility(8);
      this.ykB.setVisibility(8);
      this.HGC.setVisibility(8);
      this.krs.setText(2131767672);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI
 * JD-Core Version:    0.7.0.1
 */