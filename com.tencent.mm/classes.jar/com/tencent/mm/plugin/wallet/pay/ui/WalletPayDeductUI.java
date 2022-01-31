package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pwd.a.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

public class WalletPayDeductUI
  extends MMPreference
  implements View.OnClickListener, com.tencent.mm.ai.f
{
  protected Button gJr;
  private Dialog gKM = null;
  protected com.tencent.mm.ui.base.preference.f iLA;
  private String knU;
  private LinearLayout nIg;
  protected MMSwitchBtn ozl;
  protected Orders qrf;
  protected ArrayList<Preference> tWm;
  protected TextView tWn;
  private TextView tWo;
  private TextView tWp;
  private String tWq;
  private String tWr;
  private Bankcard tWs;
  protected boolean tWt = false;
  private int tWu = 0;
  private String tWv;
  
  private void cRW()
  {
    AppMethodBeat.i(46026);
    s.cRG();
    Object localObject = s.cRH();
    if (this.tWs == null) {
      this.tWs = ((am)localObject).a(null, null, true, true, true);
    }
    if (this.tWs == null)
    {
      ab.i("MicroMsg.WalletPayDeductUI", "no bank card!");
      finish();
      AppMethodBeat.o(46026);
      return;
    }
    localObject = new SpannableString(this.tWs.field_desc);
    com.tencent.mm.plugin.wallet_core.ui.j localj = new com.tencent.mm.plugin.wallet_core.ui.j(getContext());
    localj.uqj = new WalletPayDeductUI.3(this, ae.cTX());
    ((SpannableString)localObject).setSpan(localj, 0, ((SpannableString)localObject).length(), 18);
    this.tWo.setText((CharSequence)localObject);
    this.tWo.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(46026);
  }
  
  private void cRX()
  {
    AppMethodBeat.i(46028);
    if ((this.tWm == null) || (this.tWm.size() <= 0))
    {
      AppMethodBeat.o(46028);
      return;
    }
    int j = this.tWm.size();
    int i = 0;
    while (i < j)
    {
      this.iLA.cl(((Preference)this.tWm.get(i)).mKey, false);
      i += 1;
    }
    this.iLA.notifyDataSetChanged();
    AppMethodBeat.o(46028);
  }
  
  private void dT(List<Orders.DeductShowInfo> paramList)
  {
    AppMethodBeat.i(46029);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
      AppMethodBeat.o(46029);
      return;
    }
    if (this.tWm == null)
    {
      int j = paramList.size();
      this.tWm = new ArrayList();
      int i = 0;
      if (i < j)
      {
        Object localObject = (Orders.DeductShowInfo)paramList.get(i);
        com.tencent.mm.plugin.wallet_core.ui.e locale;
        if ((localObject != null) && (!bo.isNullOrNil(((Orders.DeductShowInfo)localObject).name)))
        {
          locale = new com.tencent.mm.plugin.wallet_core.ui.e(this);
          locale.setTitle(((Orders.DeductShowInfo)localObject).name);
          if (((Orders.DeductShowInfo)localObject).ukd <= 0) {
            break label230;
          }
          locale.prD = getResources().getColor(2131690214);
          String str = ((Orders.DeductShowInfo)localObject).value;
          localObject = new WalletPayDeductUI.4(this, (Orders.DeductShowInfo)localObject);
          locale.mContent = str;
          locale.nob = true;
          locale.lPx = ((View.OnClickListener)localObject);
        }
        for (;;)
        {
          locale.setKey("deduct_info_".concat(String.valueOf(i)));
          this.tWm.add(locale);
          this.iLA.b(locale);
          this.iLA.cl(locale.mKey, true);
          i += 1;
          break;
          label230:
          locale.mContent = ((Orders.DeductShowInfo)localObject).value;
          locale.nob = false;
        }
      }
    }
    AppMethodBeat.o(46029);
  }
  
  public int getLayoutId()
  {
    return 2130971226;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46025);
    this.tWn = ((TextView)getContentView().findViewById(2131829321));
    this.gJr = ((Button)getContentView().findViewById(2131822914));
    this.nIg = ((LinearLayout)findViewById(2131829317));
    ((TextView)findViewById(2131829315)).setText(this.qrf.ujq.title);
    ((TextView)findViewById(2131820680)).setText(((Orders.Commodity)this.qrf.ujl.get(0)).desc);
    Object localObject1 = (WalletTextView)findViewById(2131829313);
    ((WalletTextView)localObject1).setTypeface(0);
    ((WalletTextView)localObject1).setText(com.tencent.mm.wallet_core.ui.e.awa(this.qrf.ppp));
    ((TextView)findViewById(2131826674)).setText(((Orders.Commodity)this.qrf.ujl.get(0)).kNS);
    localObject1 = (TextView)findViewById(2131826176);
    Object localObject2 = (TextView)findViewById(2131829316);
    boolean bool;
    if (!bo.isNullOrNil(this.qrf.ujq.ukb))
    {
      ((TextView)localObject2).setText(this.qrf.ujq.ukb);
      if (!bo.isNullOrNil(this.qrf.ujq.ukc)) {
        ((TextView)localObject2).setTextColor(Color.parseColor(this.qrf.ujq.ukc));
      }
      this.tWo = ((TextView)findViewById(2131829318));
      this.tWp = ((TextView)findViewById(2131829319));
      if (this.qrf.ujq.tXg != 1) {
        break label771;
      }
      bool = true;
      label313:
      this.tWt = bool;
      this.tWu = this.qrf.ujq.tWu;
      this.knU = this.qrf.ujq.knU;
      this.tWv = this.qrf.ujq.tWv;
      ab.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", new Object[] { Boolean.valueOf(this.tWt), Integer.valueOf(this.tWu) });
      if (this.tWu != 0) {
        break label776;
      }
      this.ozl = ((MMSwitchBtn)findViewById(2131820950));
      this.ozl.setCheck(this.tWt);
      this.ozl.setSwitchListener(new WalletPayDeductUI.2(this));
      ny(this.tWt);
      label447:
      ab.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[] { Integer.valueOf(this.qrf.ujq.uka) });
      if (this.qrf.ujq.uka != 1) {
        break label863;
      }
      com.tencent.mm.kernel.g.RM();
      this.tWr = ((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCz, ""));
      com.tencent.mm.kernel.g.RM();
      this.tWq = ((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCy, ""));
      if ((!bo.isNullOrNil(this.tWq)) && (!bo.isNullOrNil(this.tWq))) {
        break label845;
      }
      ab.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
      this.gKM = com.tencent.mm.wallet_core.ui.g.a(getContext(), false, null);
      localObject2 = new k();
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a((m)localObject2, 0);
      label606:
      if (bo.isNullOrNil(this.qrf.ujq.ujY)) {
        break label875;
      }
      Object localObject3 = getString(2131305034);
      localObject2 = getString(2131305035);
      localObject3 = com.tencent.mm.pluginsdk.ui.d.j.b(this, getString(2131305033, new Object[] { localObject3, localObject2 }));
      com.tencent.mm.plugin.wallet_core.ui.j localj = new com.tencent.mm.plugin.wallet_core.ui.j(getContext());
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject3);
      localSpannableString.setSpan(localj, ((CharSequence)localObject3).length() - ((String)localObject2).length(), ((CharSequence)localObject3).length(), 33);
      ((TextView)localObject1).setTextColor(getResources().getColor(2131690168));
      ((TextView)localObject1).setText(localSpannableString);
      ((TextView)localObject1).setOnClickListener(this);
      ((TextView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.gJr.setOnClickListener(this);
      AppMethodBeat.o(46025);
      return;
      ((TextView)localObject2).setVisibility(8);
      break;
      label771:
      bool = false;
      break label313;
      label776:
      if (!bo.isNullOrNil(this.knU)) {
        this.gJr.setText(this.knU);
      }
      if (!bo.isNullOrNil(this.tWv))
      {
        this.tWn.setText(this.tWv);
        this.tWn.setVisibility(0);
      }
      findViewById(2131829314).setVisibility(8);
      cRX();
      break label447;
      label845:
      this.tWp.setText(this.tWr);
      cRW();
      break label606;
      label863:
      this.nIg.setVisibility(8);
      break label606;
      label875:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  protected final void ny(boolean paramBoolean)
  {
    AppMethodBeat.i(46027);
    if (paramBoolean)
    {
      findViewById(16908298).setVisibility(0);
      if (this.qrf.ujq.uka == 1)
      {
        this.nIg.setVisibility(0);
        cRX();
        if (!t.cTN().cUl()) {
          break label122;
        }
        this.tWn.setVisibility(8);
        this.gJr.setText(2131305039);
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.ozl.ADA);
      AppMethodBeat.o(46027);
      return;
      this.nIg.setVisibility(8);
      break;
      label122:
      this.tWn.setVisibility(0);
      this.tWn.setText(2131305038);
      this.gJr.setText(2131305036);
      continue;
      if ((this.tWm != null) && (this.tWm.size() > 0))
      {
        int j = this.tWm.size();
        int i = 0;
        while (i < j)
        {
          this.iLA.cl(((Preference)this.tWm.get(i)).mKey, true);
          i += 1;
        }
      }
      findViewById(16908298).setVisibility(8);
      this.nIg.setVisibility(8);
      this.tWn.setVisibility(8);
      this.gJr.setText(2131305037);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(46030);
    int i = paramView.getId();
    if (i == 2131822914)
    {
      paramView = new Intent();
      if (this.tWu == 0) {
        if (this.ozl.ADA)
        {
          i = 1;
          paramView.putExtra("auto_deduct_flag", i);
        }
      }
      for (;;)
      {
        if (this.tWs != null)
        {
          paramView.putExtra("deduct_bank_type", this.tWs.field_bankcardType);
          paramView.putExtra("deduct_bind_serial", this.tWs.field_bindSerial);
          ab.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[] { this.tWs.field_bankcardType });
        }
        setResult(-1, paramView);
        finish();
        AppMethodBeat.o(46030);
        return;
        i = 0;
        break;
        paramView.putExtra("auto_deduct_flag", this.qrf.ujq.tXg);
      }
    }
    if ((i == 2131826176) && (!bo.isNullOrNil(this.qrf.ujq.ujY)))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.qrf.ujq.ujY);
      paramView.putExtra("showShare", false);
      com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppMethodBeat.o(46030);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46022);
    super.onCreate(paramBundle);
    this.iLA = getPreferenceScreen();
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131690709)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      View localView = paramBundle.findViewById(2131821148);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(2131690605));
      }
      paramBundle = paramBundle.findViewById(16908309);
      if ((paramBundle != null) && ((paramBundle instanceof TextView))) {
        ((TextView)paramBundle).setTextColor(getResources().getColor(2131690709));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      if (!com.tencent.mm.compatible.util.d.fv(23)) {
        break label200;
      }
      paramBundle.setStatusBarColor(getResources().getColor(2131690639));
      getWindow().getDecorView().setSystemUiVisibility(8192);
    }
    for (;;)
    {
      paramBundle = getIntent();
      if (paramBundle != null) {
        break;
      }
      ab.e("MicroMsg.WalletPayDeductUI", "intent is null");
      finish();
      AppMethodBeat.o(46022);
      return;
      label200:
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
    }
    this.qrf = ((Orders)paramBundle.getParcelableExtra("orders"));
    if ((this.qrf == null) || (this.qrf.ujq == null))
    {
      ab.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.qrf);
      finish();
    }
    dT(this.qrf.ujq.ujZ);
    setResult(0);
    setBackBtn(new WalletPayDeductUI.1(this), 2131230737);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(385, this);
    initView();
    AppMethodBeat.o(46022);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46024);
    super.onDestroy();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(385, this);
    AppMethodBeat.o(46024);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(46031);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(46031);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(46023);
    super.onResume();
    AppMethodBeat.o(46023);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46032);
    ab.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramm instanceof k)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.g.RM();
        this.tWr = ((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCz, getString(2131305467)));
        com.tencent.mm.kernel.g.RM();
        this.tWq = ((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCy, getString(2131305470)));
        this.tWp.setText(this.tWr);
        cRW();
      }
    }
    for (;;)
    {
      if (this.gKM != null) {
        this.gKM.dismiss();
      }
      AppMethodBeat.o(46032);
      return;
      ab.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI
 * JD-Core Version:    0.7.0.1
 */