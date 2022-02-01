package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ListViewInScrollView;
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
  protected WalletFormView AjL;
  protected WalletFormView AjM;
  private TextView AjN;
  private Bankcard AjO;
  private a AjP;
  private boolean AjQ;
  private boolean AjR;
  private Button ftn;
  private int mScene;
  com.tencent.mm.sdk.b.c zNH;
  com.tencent.mm.sdk.b.c zTw;
  
  public WalletBankcardIdUI()
  {
    AppMethodBeat.i(70735);
    this.AjQ = false;
    this.mScene = -1;
    this.zNH = new com.tencent.mm.sdk.b.c() {};
    this.zTw = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(70735);
  }
  
  private boolean aKT()
  {
    AppMethodBeat.i(70742);
    if (this.AjL.gF(null))
    {
      this.ftn.setEnabled(true);
      this.ftn.setClickable(true);
      AppMethodBeat.o(70742);
      return true;
    }
    this.ftn.setEnabled(false);
    this.ftn.setClickable(false);
    AppMethodBeat.o(70742);
    return false;
  }
  
  protected final void aKg()
  {
    AppMethodBeat.i(70739);
    if (getProcess() == null)
    {
      ad.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
      AppMethodBeat.o(70739);
      return;
    }
    Object localObject = getProcess().dow.getString("kreq_token");
    int j = getInput().getInt("entry_scene", -1);
    if (getInput().getInt("real_name_verify_mode") == 4) {}
    for (int i = 1; this.AjO != null; i = 0)
    {
      localObject = new y(getPayReqKey(), null, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i);
      ((y)localObject).mBankType = this.AjO.field_bankcardType;
      getInput().putParcelable("key_history_bankcard", this.AjO);
      doSceneProgress((n)localObject);
      AppMethodBeat.o(70739);
      return;
    }
    if (aKT())
    {
      String str = this.AjL.getText();
      doSceneProgress(new y(getPayReqKey(), str, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i));
      AppMethodBeat.o(70739);
      return;
    }
    com.tencent.mm.ui.base.h.j(this, 2131765521, 2131755906);
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
    this.ftn = ((Button)findViewById(2131302852));
    this.AjL = ((WalletFormView)findViewById(2131297866));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.AjL);
    this.AjM = ((WalletFormView)findViewById(2131302662));
    Object localObject1;
    label124:
    Object localObject2;
    if (getInput().getBoolean("key_bind_show_change_card", false))
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.AjM);
      this.AjL.setOnInputValidChangeListener(this);
      this.ftn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70724);
          com.tencent.mm.plugin.report.service.h.vKh.f(11353, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          WalletBankcardIdUI.this.aKg();
          AppMethodBeat.o(70724);
        }
      });
      localObject1 = getProcess();
      if (localObject1 == null) {
        break label690;
      }
      this.AjR = ((com.tencent.mm.wallet_core.d)localObject1).dow.getBoolean("key_is_realname_verify_process", false);
      if (!this.AjR) {
        break label698;
      }
      setMMTitle(2131765762);
      label138:
      this.AjN = ((TextView)findViewById(2131301034));
      if ((!s.ecc().ecH()) && (!s.ecc().ecG())) {
        break label708;
      }
      localObject1 = new l(this);
      ((l)localObject1).Anf = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70725);
          ad.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
          WalletBankcardIdUI.a(WalletBankcardIdUI.this);
          AppMethodBeat.o(70725);
        }
      };
      localObject2 = getString(2131765326);
      Object localObject3 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject3).setSpan(localObject1, ((String)localObject2).length() - 6, ((String)localObject2).length(), 33);
      this.AjN.setText((CharSequence)localObject3);
      this.AjN.setMovementMethod(LinkMovementMethod.getInstance());
      label244:
      localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
      localObject2 = (Orders)getInput().getParcelable("key_orders");
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = e.Ajp.a((Orders)localObject2);
        localObject2 = (TextView)findViewById(2131306707);
        if (localObject3 == null) {
          break label754;
        }
        localObject1 = ((d)localObject3).aul(((d)localObject3).auo(((FavorPayInfo)localObject1).Aeb));
        if (((List)localObject1).size() <= 0) {
          break label745;
        }
        this.AjP = new a(getContext(), (List)localObject1);
        ((TextView)localObject2).setText(2131765324);
        ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70726);
            WalletBankcardIdUI.this.showDialog(1);
            AppMethodBeat.o(70726);
          }
        });
        ((TextView)localObject2).setVisibility(0);
      }
      label365:
      localObject1 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      localObject2 = s.ecc();
      if ((!this.AjR) || (localObject1 == null) || (bt.isNullOrNil(((RealNameBundle)localObject1).Aar))) {
        break label771;
      }
      this.AjM.setVisibility(0);
      this.AjM.setText(((RealNameBundle)localObject1).Aar);
      this.AjL.setHint(getString(2131765151));
      this.AjM.setClickable(false);
      this.AjM.setEnabled(false);
      this.AjN.setText(2131765332);
    }
    for (;;)
    {
      if ((getInput().getInt("key_bind_scene") == 18) || (getInput().getInt("key_bind_scene") == 19)) {
        this.AjL.setHint(getString(2131765330));
      }
      g.afC();
      localObject2 = (String)g.afB().afk().get(ae.a.FgV, null);
      if (!bt.isNullOrNil((String)localObject2)) {
        this.AjL.setHint((CharSequence)localObject2);
      }
      this.AjO = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
      if (this.AjO != null)
      {
        this.AjL.setText(this.AjO.AbQ);
        this.AjL.a(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(70727);
            if ((WalletBankcardIdUI.this.AjL.aKX()) && (!WalletBankcardIdUI.b(WalletBankcardIdUI.this)))
            {
              WalletBankcardIdUI.c(WalletBankcardIdUI.this);
              WalletBankcardIdUI.this.AjL.dga();
            }
            AppMethodBeat.o(70727);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
      }
      aKT();
      f.a(this, getInput(), 2);
      setEditFocusListener(this.AjL, 0, false);
      this.AjL.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70728);
          com.tencent.mm.plugin.report.service.h.vKh.f(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
          if ((WalletBankcardIdUI.d(WalletBankcardIdUI.this)) && (this.AjT != null) && (!bt.isNullOrNil(this.AjT.Aar))) {}
          for (paramAnonymousView = this.AjT.Aar;; paramAnonymousView = s.ecc().getTrueName())
          {
            com.tencent.mm.wallet_core.ui.e.d(WalletBankcardIdUI.this, paramAnonymousView);
            AppMethodBeat.o(70728);
            return;
          }
        }
      });
      if (s.ecc().ecN().ect())
      {
        this.AjL.getInfoIv().setVisibility(0);
        this.AjL.getInfoIv().setImageResource(2131691405);
      }
      AppMethodBeat.o(70738);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.AjM);
      break;
      label690:
      this.AjR = false;
      break label124;
      label698:
      setMMTitle(2131765333);
      break label138;
      label708:
      this.AjN.setVisibility(0);
      localObject1 = getInput().getString("key_custom_bind_tips");
      if (bt.isNullOrNil((String)localObject1)) {
        break label244;
      }
      this.AjN.setText((CharSequence)localObject1);
      break label244;
      label745:
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label754:
      ad.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label771:
      if ((((am)localObject2).ecF()) && (((am)localObject2).getTrueName() != null) && (!bt.isNullOrNil(((am)localObject2).getTrueName().trim())) && (((am)localObject2).ecO()))
      {
        this.AjM.setVisibility(0);
        this.AjM.setText(((am)localObject2).getTrueName());
        this.AjL.setHint(getString(2131765151));
        this.AjM.setClickable(false);
        this.AjM.setEnabled(false);
      }
      else
      {
        this.AjM.setVisibility(8);
        this.AjL.setHint(getString(2131765328));
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
    com.tencent.mm.sdk.b.a.ESL.c(this.zNH);
    com.tencent.mm.sdk.b.a.ESL.c(this.zTw);
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
      ((ListViewInScrollView)((View)localObject1).findViewById(2131296471)).setAdapter(this.AjP);
      localObject2 = new d.a(this);
      ((d.a)localObject2).aau(2131765323);
      ((d.a)localObject2).gs((View)localObject1);
      ((d.a)localObject2).e(null);
      ((d.a)localObject2).aaB(2131765291);
      localObject1 = ((d.a)localObject2).fft();
      AppMethodBeat.o(70740);
      return localObject1;
    }
    if ((this.AjR) && (paramInt == 1000))
    {
      localObject1 = getString(2131765325);
      localObject2 = com.tencent.mm.wallet_core.a.bo(this);
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
      localObject1 = com.tencent.mm.ui.base.h.a(this, true, (String)localObject1, "", getString(2131755939), getString(2131755831), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70729);
          ((com.tencent.mm.plugin.wallet_core.id_verify.a)WalletBankcardIdUI.this.getProcess()).g(WalletBankcardIdUI.this, 0);
          WalletBankcardIdUI.this.finish();
          AppMethodBeat.o(70729);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70730);
          if (WalletBankcardIdUI.e(WalletBankcardIdUI.this) == null) {}
          for (paramAnonymousDialogInterface = null;; paramAnonymousDialogInterface = WalletBankcardIdUI.f(WalletBankcardIdUI.this).findFocus())
          {
            if ((paramAnonymousDialogInterface != null) && ((paramAnonymousDialogInterface instanceof EditText))) {
              WalletBankcardIdUI.this.showVKB();
            }
            AppMethodBeat.o(70730);
            return;
          }
        }
      });
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
    com.tencent.mm.sdk.b.a.ESL.d(this.zNH);
    com.tencent.mm.sdk.b.a.ESL.d(this.zTw);
    super.onDestroy();
    AppMethodBeat.o(70737);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70743);
    if (!paramBoolean)
    {
      this.AjO = null;
      getInput().putParcelable("key_history_bankcard", null);
    }
    aKT();
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
        paramString.putBoolean("key_need_area", paramn.ebm());
        paramString.putBoolean("key_need_profession", paramn.ebn());
        paramString.putParcelableArray("key_profession_list", paramn.mProfessions);
        if (paramn.zWD == 1) {}
        for (bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_country", bool);
          paramString.putStringArray("key_country_excludes", paramn.zWE);
          if (paramn.zWz == null) {
            break label247;
          }
          if ((!paramn.zWz.AdC) || (!paramn.zWz.isError())) {
            break;
          }
          com.tencent.mm.ui.base.h.j(this, 2131765036, 2131755906);
          AppMethodBeat.o(70741);
          return true;
        }
        paramString.putString("bank_name", paramn.zWz.szi);
        paramString.putParcelable("elemt_query", paramn.zWz);
        paramString.putString("key_card_id", this.AjL.getText());
        com.tencent.mm.wallet_core.a.k(this, paramString);
        AppMethodBeat.o(70741);
        return true;
        label247:
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.AjL.getText());
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
    paramString.putString("key_card_id", this.AjL.getText());
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
    List<t> AjU;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, List<t> paramList)
    {
      AppMethodBeat.i(70731);
      this.mInflater = null;
      this.AjU = new LinkedList();
      this.mContext = null;
      this.mInflater = LayoutInflater.from(paramContext);
      this.AjU = paramList;
      this.mContext = paramContext;
      AppMethodBeat.o(70731);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70732);
      if (this.AjU == null)
      {
        AppMethodBeat.o(70732);
        return 0;
      }
      int i = this.AjU.size();
      AppMethodBeat.o(70732);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70733);
      Object localObject = this.AjU.get(paramInt);
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
        paramViewGroup.AjV = ((ImageView)paramView.findViewById(2131306690));
        paramViewGroup.vuM = ((TextView)paramView.findViewById(2131306689));
        paramViewGroup.AjW = ((TextView)paramView.findViewById(2131306692));
        paramViewGroup.AjX = ((TextView)paramView.findViewById(2131306691));
        paramView.setTag(paramViewGroup);
        localObject = (t)getItem(paramInt);
        if (bt.isNullOrNil(((t)localObject).uon)) {
          break label336;
        }
        paramViewGroup.vuM.setText(((t)localObject).uon);
        paramViewGroup.vuM.setVisibility(0);
        label128:
        if (bt.isNullOrNil(((t)localObject).zPk)) {
          break label348;
        }
        paramViewGroup.AjW.setText(((t)localObject).zPk);
        paramViewGroup.AjW.setVisibility(0);
        label159:
        if (bt.isNullOrNil(((t)localObject).zOm)) {
          break label360;
        }
        paramViewGroup.AjX.setText(((t)localObject).zOm);
        paramViewGroup.AjX.setVisibility(0);
      }
      for (;;)
      {
        String str = ((t)localObject).zPq;
        ad.v("Micromsg.WalletInputCardIDUI", "bankType:" + ((t)localObject).zPp + ", logurl:" + str);
        paramViewGroup.AjV.setImageBitmap(null);
        if (!bt.isNullOrNil(str))
        {
          localObject = new c.a();
          o.ayK();
          ((c.a)localObject).hkl = null;
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aih();
          ((c.a)localObject).gjt = com.tencent.mm.plugin.wallet_core.d.b.akx(str);
          ((c.a)localObject).hjU = true;
          ((c.a)localObject).gjA = true;
          localObject = ((c.a)localObject).azc();
          o.ayJ().a(str, paramViewGroup.AjV, (com.tencent.mm.aw.a.a.c)localObject);
        }
        AppMethodBeat.o(70734);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label336:
        paramViewGroup.vuM.setVisibility(8);
        break label128;
        label348:
        paramViewGroup.AjW.setVisibility(8);
        break label159;
        label360:
        paramViewGroup.AjX.setVisibility(8);
      }
    }
    
    final class a
    {
      ImageView AjV;
      TextView AjW;
      TextView AjX;
      TextView vuM;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI
 * JD-Core Version:    0.7.0.1
 */