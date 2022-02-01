package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.si;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBankcardIdUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  com.tencent.mm.sdk.b.c CGp;
  com.tencent.mm.sdk.b.c CMf;
  protected WalletFormView DcA;
  private TextView DcB;
  private Bankcard DcC;
  private a DcD;
  private boolean DcE;
  private boolean DcF;
  protected WalletFormView Dcz;
  private Button fQh;
  private int mScene;
  
  public WalletBankcardIdUI()
  {
    AppMethodBeat.i(70735);
    this.DcE = false;
    this.mScene = -1;
    this.CGp = new WalletBankcardIdUI.1(this);
    this.CMf = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(70735);
  }
  
  private boolean aUW()
  {
    AppMethodBeat.i(70742);
    if (this.Dcz.ho(null))
    {
      this.fQh.setEnabled(true);
      this.fQh.setClickable(true);
      AppMethodBeat.o(70742);
      return true;
    }
    this.fQh.setEnabled(false);
    this.fQh.setClickable(false);
    AppMethodBeat.o(70742);
    return false;
  }
  
  protected final void aUj()
  {
    AppMethodBeat.i(70739);
    if (getProcess() == null)
    {
      ad.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
      AppMethodBeat.o(70739);
      return;
    }
    Object localObject = getProcess().dxT.getString("kreq_token");
    int j = getInput().getInt("entry_scene", -1);
    if (getInput().getInt("real_name_verify_mode") == 4) {}
    for (int i = 1; this.DcC != null; i = 0)
    {
      localObject = new y(getPayReqKey(), null, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i);
      ((y)localObject).mBankType = this.DcC.field_bankcardType;
      getInput().putParcelable("key_history_bankcard", this.DcC);
      doSceneProgress((n)localObject);
      AppMethodBeat.o(70739);
      return;
    }
    if (aUW())
    {
      String str = this.Dcz.getText();
      doSceneProgress(new y(getPayReqKey(), str, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i));
      AppMethodBeat.o(70739);
      return;
    }
    h.l(this, 2131765521, 2131755906);
    AppMethodBeat.o(70739);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495917;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70738);
    this.fQh = ((Button)findViewById(2131302852));
    this.Dcz = ((WalletFormView)findViewById(2131297866));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Dcz);
    this.DcA = ((WalletFormView)findViewById(2131302662));
    Object localObject1;
    label124:
    Object localObject2;
    if (getInput().getBoolean("key_bind_show_change_card", false))
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.DcA);
      this.Dcz.setOnInputValidChangeListener(this);
      this.fQh.setOnClickListener(new WalletBankcardIdUI.3(this));
      localObject1 = getProcess();
      if (localObject1 == null) {
        break label690;
      }
      this.DcF = ((com.tencent.mm.wallet_core.d)localObject1).dxT.getBoolean("key_is_realname_verify_process", false);
      if (!this.DcF) {
        break label698;
      }
      setMMTitle(2131765762);
      label138:
      this.DcB = ((TextView)findViewById(2131301034));
      if ((!com.tencent.mm.plugin.wallet_core.model.t.eFy().eGc()) && (!com.tencent.mm.plugin.wallet_core.model.t.eFy().eGb())) {
        break label708;
      }
      localObject1 = new l(this);
      ((l)localObject1).DfS = new WalletBankcardIdUI.4(this);
      localObject2 = getString(2131765326);
      Object localObject3 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject3).setSpan(localObject1, ((String)localObject2).length() - 6, ((String)localObject2).length(), 33);
      this.DcB.setText((CharSequence)localObject3);
      this.DcB.setMovementMethod(LinkMovementMethod.getInstance());
      label244:
      localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
      localObject2 = (Orders)getInput().getParcelable("key_orders");
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = e.Dcd.a((Orders)localObject2);
        localObject2 = (TextView)findViewById(2131306707);
        if (localObject3 == null) {
          break label754;
        }
        localObject1 = ((d)localObject3).aEN(((d)localObject3).aEQ(((FavorPayInfo)localObject1).CWL));
        if (((List)localObject1).size() <= 0) {
          break label745;
        }
        this.DcD = new a(getContext(), (List)localObject1);
        ((TextView)localObject2).setText(2131765324);
        ((TextView)localObject2).setOnClickListener(new WalletBankcardIdUI.5(this));
        ((TextView)localObject2).setVisibility(0);
      }
      label365:
      localObject1 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      localObject2 = com.tencent.mm.plugin.wallet_core.model.t.eFy();
      if ((!this.DcF) || (localObject1 == null) || (bt.isNullOrNil(((RealNameBundle)localObject1).CTa))) {
        break label771;
      }
      this.DcA.setVisibility(0);
      this.DcA.setText(((RealNameBundle)localObject1).CTa);
      this.Dcz.setHint(getString(2131765151));
      this.DcA.setClickable(false);
      this.DcA.setEnabled(false);
      this.DcB.setText(2131765332);
    }
    for (;;)
    {
      if ((getInput().getInt("key_bind_scene") == 18) || (getInput().getInt("key_bind_scene") == 19)) {
        this.Dcz.setHint(getString(2131765330));
      }
      g.ajD();
      localObject2 = (String)g.ajC().ajl().get(al.a.Irc, null);
      if (!bt.isNullOrNil((String)localObject2)) {
        this.Dcz.setHint((CharSequence)localObject2);
      }
      this.DcC = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
      if (this.DcC != null)
      {
        this.Dcz.setText(this.DcC.CUz);
        this.Dcz.a(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(70727);
            if ((WalletBankcardIdUI.this.Dcz.aVa()) && (!WalletBankcardIdUI.b(WalletBankcardIdUI.this)))
            {
              WalletBankcardIdUI.c(WalletBankcardIdUI.this);
              WalletBankcardIdUI.this.Dcz.dEe();
            }
            AppMethodBeat.o(70727);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
      }
      aUW();
      f.a(this, getInput(), 2);
      setEditFocusListener(this.Dcz, 0, false);
      this.Dcz.setOnInfoIvClickListener(new WalletBankcardIdUI.7(this, (RealNameBundle)localObject1));
      if (com.tencent.mm.plugin.wallet_core.model.t.eFy().eGi().eFP())
      {
        this.Dcz.getInfoIv().setVisibility(0);
        this.Dcz.getInfoIv().setImageResource(2131691405);
      }
      AppMethodBeat.o(70738);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.DcA);
      break;
      label690:
      this.DcF = false;
      break label124;
      label698:
      setMMTitle(2131765333);
      break label138;
      label708:
      this.DcB.setVisibility(0);
      localObject1 = getInput().getString("key_custom_bind_tips");
      if (bt.isNullOrNil((String)localObject1)) {
        break label244;
      }
      this.DcB.setText((CharSequence)localObject1);
      break label244;
      label745:
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label754:
      ad.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label771:
      if ((((an)localObject2).eGa()) && (((an)localObject2).getTrueName() != null) && (!bt.isNullOrNil(((an)localObject2).getTrueName().trim())) && (((an)localObject2).eGj()))
      {
        this.DcA.setVisibility(0);
        this.DcA.setText(((an)localObject2).getTrueName());
        this.Dcz.setHint(getString(2131765151));
        this.DcA.setClickable(false);
        this.DcA.setEnabled(false);
      }
      else
      {
        this.DcA.setVisibility(8);
        this.Dcz.setHint(getString(2131765328));
      }
    }
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70736);
    super.onCreate(paramBundle);
    setMMTitle(2131765333);
    initView();
    com.tencent.mm.sdk.b.a.IbL.c(this.CGp);
    com.tencent.mm.sdk.b.a.IbL.c(this.CMf);
    this.mScene = getInput().getInt("key_bind_scene");
    AppMethodBeat.o(70736);
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(70740);
    Object localObject1;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = getLayoutInflater().inflate(2131495970, null);
      ((ListViewInScrollView)((View)localObject1).findViewById(2131296471)).setAdapter(this.DcD);
      localObject2 = new d.a(this);
      ((d.a)localObject2).afe(2131765323);
      ((d.a)localObject2).gY((View)localObject1);
      ((d.a)localObject2).e(null);
      ((d.a)localObject2).afl(2131765291);
      localObject1 = ((d.a)localObject2).fMb();
      AppMethodBeat.o(70740);
      return localObject1;
    }
    if ((this.DcF) && (paramInt == 1000))
    {
      localObject1 = getString(2131765325);
      localObject2 = com.tencent.mm.wallet_core.a.br(this);
      if (localObject2 == null) {
        break label200;
      }
    }
    label200:
    for (paramInt = ((com.tencent.mm.wallet_core.d)localObject2).a(this, 1);; paramInt = -1)
    {
      if (paramInt != -1) {
        localObject1 = getString(paramInt);
      }
      localObject1 = h.a(this, true, (String)localObject1, "", getString(2131755939), getString(2131755831), new WalletBankcardIdUI.8(this), new WalletBankcardIdUI.9(this));
      AppMethodBeat.o(70740);
      return localObject1;
      localObject1 = super.onCreateDialog(paramInt);
      AppMethodBeat.o(70740);
      return localObject1;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70737);
    com.tencent.mm.sdk.b.a.IbL.d(this.CGp);
    com.tencent.mm.sdk.b.a.IbL.d(this.CMf);
    super.onDestroy();
    AppMethodBeat.o(70737);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70743);
    if (!paramBoolean)
    {
      this.DcC = null;
      getInput().putParcelable("key_history_bankcard", null);
    }
    aUW();
    AppMethodBeat.o(70743);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70741);
    ad.d("Micromsg.WalletInputCardIDUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    paramString = new Bundle();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof y))
      {
        paramn = (y)paramn;
        paramString.putBoolean("key_need_area", paramn.eEI());
        paramString.putBoolean("key_need_profession", paramn.eEJ());
        paramString.putParcelableArray("key_profession_list", paramn.mProfessions);
        if (paramn.CPm == 1) {}
        for (bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_country", bool);
          paramString.putStringArray("key_country_excludes", paramn.CPn);
          if (paramn.CPi == null) {
            break label247;
          }
          if ((!paramn.CPi.CWm) || (!paramn.CPi.isError())) {
            break;
          }
          h.l(this, 2131765036, 2131755906);
          AppMethodBeat.o(70741);
          return true;
        }
        paramString.putString("bank_name", paramn.CPi.uJF);
        paramString.putParcelable("elemt_query", paramn.CPi);
        paramString.putString("key_card_id", this.Dcz.getText());
        com.tencent.mm.wallet_core.a.k(this, paramString);
        AppMethodBeat.o(70741);
        return true;
        label247:
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.Dcz.getText());
        com.tencent.mm.wallet_core.a.k(this, paramString);
      }
    }
    while ((paramInt2 != 1) || (!(paramn instanceof y)))
    {
      boolean bool;
      AppMethodBeat.o(70741);
      return false;
    }
    paramString.putString("bank_name", "");
    paramString.putParcelable("elemt_query", new ElementQuery());
    paramString.putString("key_card_id", this.Dcz.getText());
    com.tencent.mm.wallet_core.a.k(this, paramString);
    AppMethodBeat.o(70741);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    List<com.tencent.mm.plugin.wallet.a.t> DcI;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, List<com.tencent.mm.plugin.wallet.a.t> paramList)
    {
      AppMethodBeat.i(70731);
      this.mInflater = null;
      this.DcI = new LinkedList();
      this.mContext = null;
      this.mInflater = LayoutInflater.from(paramContext);
      this.DcI = paramList;
      this.mContext = paramContext;
      AppMethodBeat.o(70731);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70732);
      if (this.DcI == null)
      {
        AppMethodBeat.o(70732);
        return 0;
      }
      int i = this.DcI.size();
      AppMethodBeat.o(70732);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70733);
      Object localObject = this.DcI.get(paramInt);
      AppMethodBeat.o(70733);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(70734);
      Object localObject;
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(2131495926, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.DcJ = ((ImageView)paramView.findViewById(2131306690));
        paramViewGroup.xSy = ((TextView)paramView.findViewById(2131306689));
        paramViewGroup.DcK = ((TextView)paramView.findViewById(2131306692));
        paramViewGroup.DcL = ((TextView)paramView.findViewById(2131306691));
        paramView.setTag(paramViewGroup);
        localObject = (com.tencent.mm.plugin.wallet.a.t)getItem(paramInt);
        if (bt.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).wCD)) {
          break label336;
        }
        paramViewGroup.xSy.setText(((com.tencent.mm.plugin.wallet.a.t)localObject).wCD);
        paramViewGroup.xSy.setVisibility(0);
        label128:
        if (bt.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).CHS)) {
          break label348;
        }
        paramViewGroup.DcK.setText(((com.tencent.mm.plugin.wallet.a.t)localObject).CHS);
        paramViewGroup.DcK.setVisibility(0);
        label159:
        if (bt.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).CGU)) {
          break label360;
        }
        paramViewGroup.DcL.setText(((com.tencent.mm.plugin.wallet.a.t)localObject).CGU);
        paramViewGroup.DcL.setVisibility(0);
      }
      for (;;)
      {
        String str = ((com.tencent.mm.plugin.wallet.a.t)localObject).CHY;
        ad.v("Micromsg.WalletInputCardIDUI", "bankType:" + ((com.tencent.mm.plugin.wallet.a.t)localObject).CHX + ", logurl:" + str);
        paramViewGroup.DcJ.setImageBitmap(null);
        if (!bt.isNullOrNil(str))
        {
          localObject = new c.a();
          q.aIK();
          ((c.a)localObject).idJ = null;
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.arU();
          ((c.a)localObject).hdP = com.tencent.mm.plugin.wallet_core.d.b.auC(str);
          ((c.a)localObject).idr = true;
          ((c.a)localObject).hdX = true;
          localObject = ((c.a)localObject).aJc();
          q.aIJ().a(str, paramViewGroup.DcJ, (com.tencent.mm.aw.a.a.c)localObject);
        }
        AppMethodBeat.o(70734);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label336:
        paramViewGroup.xSy.setVisibility(8);
        break label128;
        label348:
        paramViewGroup.DcK.setVisibility(8);
        break label159;
        label360:
        paramViewGroup.DcL.setVisibility(8);
      }
    }
    
    final class a
    {
      ImageView DcJ;
      TextView DcK;
      TextView DcL;
      TextView xSy;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI
 * JD-Core Version:    0.7.0.1
 */