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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  com.tencent.mm.sdk.b.c CXV;
  com.tencent.mm.sdk.b.c DdN;
  protected WalletFormView Dud;
  protected WalletFormView Due;
  private TextView Duf;
  private Bankcard Dug;
  private a Duh;
  private boolean Dui;
  private boolean Duj;
  private Button fSn;
  private int mScene;
  
  public WalletBankcardIdUI()
  {
    AppMethodBeat.i(70735);
    this.Dui = false;
    this.mScene = -1;
    this.CXV = new com.tencent.mm.sdk.b.c() {};
    this.DdN = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(70735);
  }
  
  private boolean aVv()
  {
    AppMethodBeat.i(70742);
    if (this.Dud.ht(null))
    {
      this.fSn.setEnabled(true);
      this.fSn.setClickable(true);
      AppMethodBeat.o(70742);
      return true;
    }
    this.fSn.setEnabled(false);
    this.fSn.setClickable(false);
    AppMethodBeat.o(70742);
    return false;
  }
  
  protected final void aUI()
  {
    AppMethodBeat.i(70739);
    if (getProcess() == null)
    {
      ae.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
      AppMethodBeat.o(70739);
      return;
    }
    Object localObject = getProcess().dyY.getString("kreq_token");
    int j = getInput().getInt("entry_scene", -1);
    if (getInput().getInt("real_name_verify_mode") == 4) {}
    for (int i = 1; this.Dug != null; i = 0)
    {
      localObject = new y(getPayReqKey(), null, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i);
      ((y)localObject).mBankType = this.Dug.field_bankcardType;
      getInput().putParcelable("key_history_bankcard", this.Dug);
      doSceneProgress((n)localObject);
      AppMethodBeat.o(70739);
      return;
    }
    if (aVv())
    {
      String str = this.Dud.getText();
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
    this.fSn = ((Button)findViewById(2131302852));
    this.Dud = ((WalletFormView)findViewById(2131297866));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Dud);
    this.Due = ((WalletFormView)findViewById(2131302662));
    Object localObject1;
    label124:
    Object localObject2;
    if (getInput().getBoolean("key_bind_show_change_card", false))
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.Due);
      this.Dud.setOnInputValidChangeListener(this);
      this.fSn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70724);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.plugin.report.service.g.yxI.f(11353, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          WalletBankcardIdUI.this.aUI();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70724);
        }
      });
      localObject1 = getProcess();
      if (localObject1 == null) {
        break label690;
      }
      this.Duj = ((com.tencent.mm.wallet_core.d)localObject1).dyY.getBoolean("key_is_realname_verify_process", false);
      if (!this.Duj) {
        break label698;
      }
      setMMTitle(2131765762);
      label138:
      this.Duf = ((TextView)findViewById(2131301034));
      if ((!com.tencent.mm.plugin.wallet_core.model.t.eJf().eJJ()) && (!com.tencent.mm.plugin.wallet_core.model.t.eJf().eJI())) {
        break label708;
      }
      localObject1 = new l(this);
      ((l)localObject1).Dxw = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70725);
          ae.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
          WalletBankcardIdUI.a(WalletBankcardIdUI.this);
          AppMethodBeat.o(70725);
        }
      };
      localObject2 = getString(2131765326);
      Object localObject3 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject3).setSpan(localObject1, ((String)localObject2).length() - 6, ((String)localObject2).length(), 33);
      this.Duf.setText((CharSequence)localObject3);
      this.Duf.setMovementMethod(LinkMovementMethod.getInstance());
      label244:
      localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
      localObject2 = (Orders)getInput().getParcelable("key_orders");
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = e.DtH.a((Orders)localObject2);
        localObject2 = (TextView)findViewById(2131306707);
        if (localObject3 == null) {
          break label754;
        }
        localObject1 = ((d)localObject3).aGh(((d)localObject3).aGk(((FavorPayInfo)localObject1).Doq));
        if (((List)localObject1).size() <= 0) {
          break label745;
        }
        this.Duh = new a(getContext(), (List)localObject1);
        ((TextView)localObject2).setText(2131765324);
        ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70726);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            WalletBankcardIdUI.this.showDialog(1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70726);
          }
        });
        ((TextView)localObject2).setVisibility(0);
      }
      label365:
      localObject1 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      localObject2 = com.tencent.mm.plugin.wallet_core.model.t.eJf();
      if ((!this.Duj) || (localObject1 == null) || (bu.isNullOrNil(((RealNameBundle)localObject1).DkG))) {
        break label771;
      }
      this.Due.setVisibility(0);
      this.Due.setText(((RealNameBundle)localObject1).DkG);
      this.Dud.setHint(getString(2131765151));
      this.Due.setClickable(false);
      this.Due.setEnabled(false);
      this.Duf.setText(2131765332);
    }
    for (;;)
    {
      if ((getInput().getInt("key_bind_scene") == 18) || (getInput().getInt("key_bind_scene") == 19)) {
        this.Dud.setHint(getString(2131765330));
      }
      com.tencent.mm.kernel.g.ajS();
      localObject2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILy, null);
      if (!bu.isNullOrNil((String)localObject2)) {
        this.Dud.setHint((CharSequence)localObject2);
      }
      this.Dug = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
      if (this.Dug != null)
      {
        this.Dud.setText(this.Dug.Dmf);
        this.Dud.a(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(70727);
            if ((WalletBankcardIdUI.this.Dud.aVz()) && (!WalletBankcardIdUI.b(WalletBankcardIdUI.this)))
            {
              WalletBankcardIdUI.c(WalletBankcardIdUI.this);
              WalletBankcardIdUI.this.Dud.dHv();
            }
            AppMethodBeat.o(70727);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
      }
      aVv();
      com.tencent.mm.plugin.wallet_core.utils.f.a(this, getInput(), 2);
      setEditFocusListener(this.Dud, 0, false);
      this.Dud.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70728);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.plugin.report.service.g.yxI.f(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
          if ((WalletBankcardIdUI.d(WalletBankcardIdUI.this)) && (this.Dul != null) && (!bu.isNullOrNil(this.Dul.DkG))) {}
          for (paramAnonymousView = this.Dul.DkG;; paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.t.eJf().getTrueName())
          {
            com.tencent.mm.wallet_core.ui.f.d(WalletBankcardIdUI.this, paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70728);
            return;
          }
        }
      });
      if (com.tencent.mm.plugin.wallet_core.model.t.eJf().eJP().eJw())
      {
        this.Dud.getInfoIv().setVisibility(0);
        this.Dud.getInfoIv().setImageResource(2131691405);
      }
      AppMethodBeat.o(70738);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Due);
      break;
      label690:
      this.Duj = false;
      break label124;
      label698:
      setMMTitle(2131765333);
      break label138;
      label708:
      this.Duf.setVisibility(0);
      localObject1 = getInput().getString("key_custom_bind_tips");
      if (bu.isNullOrNil((String)localObject1)) {
        break label244;
      }
      this.Duf.setText((CharSequence)localObject1);
      break label244;
      label745:
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label754:
      ae.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label771:
      if ((((an)localObject2).eJH()) && (((an)localObject2).getTrueName() != null) && (!bu.isNullOrNil(((an)localObject2).getTrueName().trim())) && (((an)localObject2).eJQ()))
      {
        this.Due.setVisibility(0);
        this.Due.setText(((an)localObject2).getTrueName());
        this.Dud.setHint(getString(2131765151));
        this.Due.setClickable(false);
        this.Due.setEnabled(false);
      }
      else
      {
        this.Due.setVisibility(8);
        this.Dud.setHint(getString(2131765328));
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
    com.tencent.mm.sdk.b.a.IvT.c(this.CXV);
    com.tencent.mm.sdk.b.a.IvT.c(this.DdN);
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
      ((ListViewInScrollView)((View)localObject1).findViewById(2131296471)).setAdapter(this.Duh);
      localObject2 = new d.a(this);
      ((d.a)localObject2).afN(2131765323);
      ((d.a)localObject2).hd((View)localObject1);
      ((d.a)localObject2).e(null);
      ((d.a)localObject2).afU(2131765291);
      localObject1 = ((d.a)localObject2).fQv();
      AppMethodBeat.o(70740);
      return localObject1;
    }
    if ((this.Duj) && (paramInt == 1000))
    {
      localObject1 = getString(2131765325);
      localObject2 = com.tencent.mm.wallet_core.a.bs(this);
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
      localObject1 = h.a(this, true, (String)localObject1, "", getString(2131755939), getString(2131755831), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    com.tencent.mm.sdk.b.a.IvT.d(this.CXV);
    com.tencent.mm.sdk.b.a.IvT.d(this.DdN);
    super.onDestroy();
    AppMethodBeat.o(70737);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70743);
    if (!paramBoolean)
    {
      this.Dug = null;
      getInput().putParcelable("key_history_bankcard", null);
    }
    aVv();
    AppMethodBeat.o(70743);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70741);
    ae.d("Micromsg.WalletInputCardIDUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    paramString = new Bundle();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof y))
      {
        paramn = (y)paramn;
        paramString.putBoolean("key_need_area", paramn.eIp());
        paramString.putBoolean("key_need_profession", paramn.eIq());
        paramString.putParcelableArray("key_profession_list", paramn.mProfessions);
        if (paramn.DgQ == 1) {}
        for (bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_country", bool);
          paramString.putStringArray("key_country_excludes", paramn.DgR);
          if (paramn.DgM == null) {
            break label247;
          }
          if ((!paramn.DgM.DnR) || (!paramn.DgM.isError())) {
            break;
          }
          h.l(this, 2131765036, 2131755906);
          AppMethodBeat.o(70741);
          return true;
        }
        paramString.putString("bank_name", paramn.DgM.uVs);
        paramString.putParcelable("elemt_query", paramn.DgM);
        paramString.putString("key_card_id", this.Dud.getText());
        com.tencent.mm.wallet_core.a.k(this, paramString);
        AppMethodBeat.o(70741);
        return true;
        label247:
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.Dud.getText());
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
    paramString.putString("key_card_id", this.Dud.getText());
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
    List<com.tencent.mm.plugin.wallet.a.t> Dum;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, List<com.tencent.mm.plugin.wallet.a.t> paramList)
    {
      AppMethodBeat.i(70731);
      this.mInflater = null;
      this.Dum = new LinkedList();
      this.mContext = null;
      this.mInflater = LayoutInflater.from(paramContext);
      this.Dum = paramList;
      this.mContext = paramContext;
      AppMethodBeat.o(70731);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70732);
      if (this.Dum == null)
      {
        AppMethodBeat.o(70732);
        return 0;
      }
      int i = this.Dum.size();
      AppMethodBeat.o(70732);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70733);
      Object localObject = this.Dum.get(paramInt);
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
        paramViewGroup.Dun = ((ImageView)paramView.findViewById(2131306690));
        paramViewGroup.yir = ((TextView)paramView.findViewById(2131306689));
        paramViewGroup.Duo = ((TextView)paramView.findViewById(2131306692));
        paramViewGroup.Dup = ((TextView)paramView.findViewById(2131306691));
        paramView.setTag(paramViewGroup);
        localObject = (com.tencent.mm.plugin.wallet.a.t)getItem(paramInt);
        if (bu.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).wSo)) {
          break label336;
        }
        paramViewGroup.yir.setText(((com.tencent.mm.plugin.wallet.a.t)localObject).wSo);
        paramViewGroup.yir.setVisibility(0);
        label128:
        if (bu.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).CZy)) {
          break label348;
        }
        paramViewGroup.Duo.setText(((com.tencent.mm.plugin.wallet.a.t)localObject).CZy);
        paramViewGroup.Duo.setVisibility(0);
        label159:
        if (bu.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).CYA)) {
          break label360;
        }
        paramViewGroup.Dup.setText(((com.tencent.mm.plugin.wallet.a.t)localObject).CYA);
        paramViewGroup.Dup.setVisibility(0);
      }
      for (;;)
      {
        String str = ((com.tencent.mm.plugin.wallet.a.t)localObject).CZE;
        ae.v("Micromsg.WalletInputCardIDUI", "bankType:" + ((com.tencent.mm.plugin.wallet.a.t)localObject).CZD + ", logurl:" + str);
        paramViewGroup.Dun.setImageBitmap(null);
        if (!bu.isNullOrNil(str))
        {
          localObject = new c.a();
          q.aJc();
          ((c.a)localObject).igB = null;
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
          ((c.a)localObject).hgD = com.tencent.mm.plugin.wallet_core.d.b.avR(str);
          ((c.a)localObject).igk = true;
          ((c.a)localObject).hgL = true;
          localObject = ((c.a)localObject).aJu();
          q.aJb().a(str, paramViewGroup.Dun, (com.tencent.mm.av.a.a.c)localObject);
        }
        AppMethodBeat.o(70734);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label336:
        paramViewGroup.yir.setVisibility(8);
        break label128;
        label348:
        paramViewGroup.Duo.setVisibility(8);
        break label159;
        label360:
        paramViewGroup.Dup.setVisibility(8);
      }
    }
    
    final class a
    {
      ImageView Dun;
      TextView Duo;
      TextView Dup;
      TextView yir;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI
 * JD-Core Version:    0.7.0.1
 */