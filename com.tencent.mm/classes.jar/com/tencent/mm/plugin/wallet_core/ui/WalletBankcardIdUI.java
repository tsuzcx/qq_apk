package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBankcardIdUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Button gHb;
  private int mScene;
  com.tencent.mm.sdk.b.c tTv;
  com.tencent.mm.sdk.b.c tZf;
  protected WalletFormView ung;
  protected WalletFormView unh;
  private TextView uni;
  private Bankcard unj;
  private WalletBankcardIdUI.a unk;
  private boolean unl;
  private boolean unm;
  
  public WalletBankcardIdUI()
  {
    AppMethodBeat.i(47174);
    this.unl = false;
    this.mScene = -1;
    this.tTv = new com.tencent.mm.sdk.b.c() {};
    this.tZf = new WalletBankcardIdUI.2(this);
    AppMethodBeat.o(47174);
  }
  
  private boolean asr()
  {
    AppMethodBeat.i(47181);
    if (this.ung.fE(null))
    {
      this.gHb.setEnabled(true);
      this.gHb.setClickable(true);
      AppMethodBeat.o(47181);
      return true;
    }
    this.gHb.setEnabled(false);
    this.gHb.setClickable(false);
    AppMethodBeat.o(47181);
    return false;
  }
  
  protected final void arG()
  {
    AppMethodBeat.i(47178);
    if (getProcess() == null)
    {
      ab.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
      AppMethodBeat.o(47178);
      return;
    }
    Object localObject = getProcess().mEJ.getString("kreq_token");
    int j = getInput().getInt("entry_scene", -1);
    if (getInput().getInt("real_name_verify_mode") == 4) {}
    for (int i = 1; this.unj != null; i = 0)
    {
      localObject = new w(getPayReqKey(), null, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i);
      ((w)localObject).qib = this.unj.field_bankcardType;
      getInput().putParcelable("key_history_bankcard", this.unj);
      doSceneProgress((m)localObject);
      AppMethodBeat.o(47178);
      return;
    }
    if (asr())
    {
      String str = this.ung.getText();
      doSceneProgress(new w(getPayReqKey(), str, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i));
      AppMethodBeat.o(47178);
      return;
    }
    h.h(this, 2131305307, 2131297087);
    AppMethodBeat.o(47178);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971143;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47177);
    this.gHb = ((Button)findViewById(2131822914));
    this.ung = ((WalletFormView)findViewById(2131826693));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.ung);
    this.unh = ((WalletFormView)findViewById(2131829013));
    Object localObject1;
    label124:
    Object localObject2;
    if (getInput().getBoolean("key_bind_show_change_card", false))
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.unh);
      this.ung.setOnInputValidChangeListener(this);
      this.gHb.setOnClickListener(new WalletBankcardIdUI.3(this));
      localObject1 = getProcess();
      if (localObject1 == null) {
        break label692;
      }
      this.unm = ((com.tencent.mm.wallet_core.c)localObject1).mEJ.getBoolean("key_is_realname_verify_process", false);
      if (!this.unm) {
        break label700;
      }
      setMMTitle(2131305547);
      label138:
      this.uni = ((TextView)findViewById(2131828908));
      if ((!t.cTN().cUn()) && (!t.cTN().cUm())) {
        break label710;
      }
      localObject1 = new j(this);
      ((j)localObject1).uqj = new WalletBankcardIdUI.4(this);
      localObject2 = getString(2131305134);
      Object localObject3 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject3).setSpan(localObject1, ((String)localObject2).length() - 6, ((String)localObject2).length(), 33);
      this.uni.setText((CharSequence)localObject3);
      this.uni.setMovementMethod(LinkMovementMethod.getInstance());
      label244:
      localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
      localObject2 = (Orders)getInput().getParcelable("key_orders");
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = c.umO.a((Orders)localObject2);
        localObject2 = (TextView)findViewById(2131829014);
        if (localObject3 == null) {
          break label756;
        }
        localObject1 = ((b)localObject3).afC(((b)localObject3).afF(((FavorPayInfo)localObject1).uhU));
        if (((List)localObject1).size() <= 0) {
          break label747;
        }
        this.unk = new WalletBankcardIdUI.a(getContext(), (List)localObject1);
        ((TextView)localObject2).setText(2131305132);
        ((TextView)localObject2).setOnClickListener(new WalletBankcardIdUI.5(this));
        ((TextView)localObject2).setVisibility(0);
      }
      label365:
      localObject1 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      localObject2 = t.cTN();
      if ((!((am)localObject2).cUl()) || (((am)localObject2).getTrueName() == null) || (bo.isNullOrNil(((am)localObject2).getTrueName().trim())) || (!((am)localObject2).cUu())) {
        break label773;
      }
      this.unh.setVisibility(0);
      this.unh.setText(((am)localObject2).getTrueName());
      this.ung.setHint(getString(2131304959));
      this.unh.setClickable(false);
      this.unh.setEnabled(false);
    }
    for (;;)
    {
      if ((getInput().getInt("key_bind_scene") == 18) || (getInput().getInt("key_bind_scene") == 19)) {
        this.ung.setHint(getString(2131305138));
      }
      g.RM();
      localObject1 = (String)g.RL().Ru().get(ac.a.yyA, null);
      if (!bo.isNullOrNil((String)localObject1)) {
        this.ung.setHint((CharSequence)localObject1);
      }
      this.unj = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
      if (this.unj != null)
      {
        this.ung.setText(this.unj.ufI);
        this.ung.a(new WalletBankcardIdUI.6(this));
      }
      asr();
      d.a(this, getInput(), 2);
      setEditFocusListener(this.ung, 0, false);
      this.ung.setOnInfoIvClickListener(new WalletBankcardIdUI.7(this));
      if (t.cTN().cUt().cUc())
      {
        this.ung.getInfoIv().setVisibility(0);
        this.ung.getInfoIv().setImageResource(2131232197);
      }
      AppMethodBeat.o(47177);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.unh);
      break;
      label692:
      this.unm = false;
      break label124;
      label700:
      setMMTitle(2131305141);
      break label138;
      label710:
      this.uni.setVisibility(0);
      localObject1 = getInput().getString("key_custom_bind_tips");
      if (bo.isNullOrNil((String)localObject1)) {
        break label244;
      }
      this.uni.setText((CharSequence)localObject1);
      break label244;
      label747:
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label756:
      ab.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label773:
      if ((this.unm) && (localObject1 != null) && (!bo.isNullOrNil(((RealNameBundle)localObject1).ueu)))
      {
        this.unh.setVisibility(0);
        this.unh.setText(((RealNameBundle)localObject1).ueu);
        this.ung.setHint(getString(2131304959));
        this.unh.setClickable(false);
        this.unh.setEnabled(false);
        this.uni.setText(2131305140);
      }
      else
      {
        this.unh.setVisibility(8);
        this.ung.setHint(getString(2131305136));
      }
    }
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47175);
    super.onCreate(paramBundle);
    setMMTitle(2131305141);
    initView();
    com.tencent.mm.sdk.b.a.ymk.c(this.tTv);
    com.tencent.mm.sdk.b.a.ymk.c(this.tZf);
    this.mScene = getInput().getInt("key_bind_scene");
    AppMethodBeat.o(47175);
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(47179);
    Object localObject1;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = getLayoutInflater().inflate(2130971194, null);
      ((ListViewInScrollView)((View)localObject1).findViewById(2131821074)).setAdapter(this.unk);
      localObject2 = new c.a(this);
      ((c.a)localObject2).Rb(2131305131);
      ((c.a)localObject2).fu((View)localObject1);
      ((c.a)localObject2).e(null);
      ((c.a)localObject2).Ri(2131305099);
      localObject1 = ((c.a)localObject2).aLZ();
      AppMethodBeat.o(47179);
      return localObject1;
    }
    if ((this.unm) && (paramInt == 1000))
    {
      localObject1 = getString(2131305133);
      localObject2 = com.tencent.mm.wallet_core.a.aM(this);
      if (localObject2 == null) {
        break label200;
      }
    }
    label200:
    for (paramInt = ((com.tencent.mm.wallet_core.c)localObject2).a(this, 1);; paramInt = -1)
    {
      if (paramInt != -1) {
        localObject1 = getString(paramInt);
      }
      localObject1 = h.a(this, true, (String)localObject1, "", getString(2131297115), getString(2131297014), new WalletBankcardIdUI.8(this), new WalletBankcardIdUI.9(this));
      AppMethodBeat.o(47179);
      return localObject1;
      localObject1 = super.onCreateDialog(paramInt);
      AppMethodBeat.o(47179);
      return localObject1;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47176);
    com.tencent.mm.sdk.b.a.ymk.d(this.tTv);
    com.tencent.mm.sdk.b.a.ymk.d(this.tZf);
    super.onDestroy();
    AppMethodBeat.o(47176);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47182);
    if (!paramBoolean)
    {
      this.unj = null;
      getInput().putParcelable("key_history_bankcard", null);
    }
    asr();
    AppMethodBeat.o(47182);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47180);
    ab.d("Micromsg.WalletInputCardIDUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    paramString = new Bundle();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof w))
      {
        paramm = (w)paramm;
        paramString.putBoolean("key_need_area", paramm.cSY());
        paramString.putBoolean("key_need_profession", paramm.cSZ());
        paramString.putParcelableArray("key_profession_list", paramm.mProfessions);
        if (paramm.ubX == 1) {}
        for (bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_country", bool);
          paramString.putStringArray("key_country_excludes", paramm.ubY);
          if (paramm.ubT == null) {
            break label247;
          }
          if ((!paramm.ubT.uhv) || (!paramm.ubT.isError())) {
            break;
          }
          h.h(this, 2131304850, 2131297087);
          AppMethodBeat.o(47180);
          return true;
        }
        paramString.putString("bank_name", paramm.ubT.nLq);
        paramString.putParcelable("elemt_query", paramm.ubT);
        paramString.putString("key_card_id", this.ung.getText());
        com.tencent.mm.wallet_core.a.j(this, paramString);
        AppMethodBeat.o(47180);
        return true;
        label247:
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.ung.getText());
        com.tencent.mm.wallet_core.a.j(this, paramString);
      }
    }
    while ((paramInt2 != 1) || (!(paramm instanceof w)))
    {
      boolean bool;
      AppMethodBeat.o(47180);
      return false;
    }
    paramString.putString("bank_name", "");
    paramString.putParcelable("elemt_query", new ElementQuery());
    paramString.putString("key_card_id", this.ung.getText());
    com.tencent.mm.wallet_core.a.j(this, paramString);
    AppMethodBeat.o(47180);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI
 * JD-Core Version:    0.7.0.1
 */