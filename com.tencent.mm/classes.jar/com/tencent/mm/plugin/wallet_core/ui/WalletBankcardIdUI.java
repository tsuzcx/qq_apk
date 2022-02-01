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
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.a.xm;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  protected WalletFormView BCh;
  protected WalletFormView BCi;
  private TextView BCj;
  private Bankcard BCk;
  private a BCl;
  private boolean BCm;
  private boolean BCn;
  com.tencent.mm.sdk.b.c Bgb;
  com.tencent.mm.sdk.b.c BlQ;
  private Button fwU;
  private int mScene;
  
  public WalletBankcardIdUI()
  {
    AppMethodBeat.i(70735);
    this.BCm = false;
    this.mScene = -1;
    this.Bgb = new com.tencent.mm.sdk.b.c() {};
    this.BlQ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(70735);
  }
  
  private boolean aRK()
  {
    AppMethodBeat.i(70742);
    if (this.BCh.gX(null))
    {
      this.fwU.setEnabled(true);
      this.fwU.setClickable(true);
      AppMethodBeat.o(70742);
      return true;
    }
    this.fwU.setEnabled(false);
    this.fwU.setClickable(false);
    AppMethodBeat.o(70742);
    return false;
  }
  
  protected final void aQX()
  {
    AppMethodBeat.i(70739);
    if (getProcess() == null)
    {
      ac.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
      AppMethodBeat.o(70739);
      return;
    }
    Object localObject = getProcess().dmf.getString("kreq_token");
    int j = getInput().getInt("entry_scene", -1);
    if (getInput().getInt("real_name_verify_mode") == 4) {}
    for (int i = 1; this.BCk != null; i = 0)
    {
      localObject = new y(getPayReqKey(), null, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i);
      ((y)localObject).mBankType = this.BCk.field_bankcardType;
      getInput().putParcelable("key_history_bankcard", this.BCk);
      doSceneProgress((n)localObject);
      AppMethodBeat.o(70739);
      return;
    }
    if (aRK())
    {
      String str = this.BCh.getText();
      doSceneProgress(new y(getPayReqKey(), str, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i));
      AppMethodBeat.o(70739);
      return;
    }
    com.tencent.mm.ui.base.h.l(this, 2131765521, 2131755906);
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
    this.fwU = ((Button)findViewById(2131302852));
    this.BCh = ((WalletFormView)findViewById(2131297866));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.BCh);
    this.BCi = ((WalletFormView)findViewById(2131302662));
    Object localObject1;
    label124:
    Object localObject2;
    if (getInput().getBoolean("key_bind_show_change_card", false))
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.BCi);
      this.BCh.setOnInputValidChangeListener(this);
      this.fwU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70724);
          com.tencent.mm.plugin.report.service.h.wUl.f(11353, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          WalletBankcardIdUI.this.aQX();
          AppMethodBeat.o(70724);
        }
      });
      localObject1 = getProcess();
      if (localObject1 == null) {
        break label690;
      }
      this.BCn = ((com.tencent.mm.wallet_core.d)localObject1).dmf.getBoolean("key_is_realname_verify_process", false);
      if (!this.BCn) {
        break label698;
      }
      setMMTitle(2131765762);
      label138:
      this.BCj = ((TextView)findViewById(2131301034));
      if ((!s.ery().esc()) && (!s.ery().esb())) {
        break label708;
      }
      localObject1 = new l(this);
      ((l)localObject1).BFA = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70725);
          ac.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
          WalletBankcardIdUI.a(WalletBankcardIdUI.this);
          AppMethodBeat.o(70725);
        }
      };
      localObject2 = getString(2131765326);
      Object localObject3 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject3).setSpan(localObject1, ((String)localObject2).length() - 6, ((String)localObject2).length(), 33);
      this.BCj.setText((CharSequence)localObject3);
      this.BCj.setMovementMethod(LinkMovementMethod.getInstance());
      label244:
      localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
      localObject2 = (Orders)getInput().getParcelable("key_orders");
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = e.BBL.a((Orders)localObject2);
        localObject2 = (TextView)findViewById(2131306707);
        if (localObject3 == null) {
          break label754;
        }
        localObject1 = ((d)localObject3).azD(((d)localObject3).azG(((FavorPayInfo)localObject1).Bwv));
        if (((List)localObject1).size() <= 0) {
          break label745;
        }
        this.BCl = new a(getContext(), (List)localObject1);
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
      localObject2 = s.ery();
      if ((!this.BCn) || (localObject1 == null) || (bs.isNullOrNil(((RealNameBundle)localObject1).BsL))) {
        break label771;
      }
      this.BCi.setVisibility(0);
      this.BCi.setText(((RealNameBundle)localObject1).BsL);
      this.BCh.setHint(getString(2131765151));
      this.BCi.setClickable(false);
      this.BCi.setEnabled(false);
      this.BCj.setText(2131765332);
    }
    for (;;)
    {
      if ((getInput().getInt("key_bind_scene") == 18) || (getInput().getInt("key_bind_scene") == 19)) {
        this.BCh.setHint(getString(2131765330));
      }
      g.agS();
      localObject2 = (String)g.agR().agA().get(ah.a.GEJ, null);
      if (!bs.isNullOrNil((String)localObject2)) {
        this.BCh.setHint((CharSequence)localObject2);
      }
      this.BCk = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
      if (this.BCk != null)
      {
        this.BCh.setText(this.BCk.Buk);
        this.BCh.a(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(70727);
            if ((WalletBankcardIdUI.this.BCh.aRO()) && (!WalletBankcardIdUI.b(WalletBankcardIdUI.this)))
            {
              WalletBankcardIdUI.c(WalletBankcardIdUI.this);
              WalletBankcardIdUI.this.BCh.dtH();
            }
            AppMethodBeat.o(70727);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
      }
      aRK();
      f.a(this, getInput(), 2);
      setEditFocusListener(this.BCh, 0, false);
      this.BCh.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70728);
          com.tencent.mm.plugin.report.service.h.wUl.f(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
          if ((WalletBankcardIdUI.d(WalletBankcardIdUI.this)) && (this.BCp != null) && (!bs.isNullOrNil(this.BCp.BsL))) {}
          for (paramAnonymousView = this.BCp.BsL;; paramAnonymousView = s.ery().getTrueName())
          {
            com.tencent.mm.wallet_core.ui.e.d(WalletBankcardIdUI.this, paramAnonymousView);
            AppMethodBeat.o(70728);
            return;
          }
        }
      });
      if (s.ery().esi().erP())
      {
        this.BCh.getInfoIv().setVisibility(0);
        this.BCh.getInfoIv().setImageResource(2131691405);
      }
      AppMethodBeat.o(70738);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.BCi);
      break;
      label690:
      this.BCn = false;
      break label124;
      label698:
      setMMTitle(2131765333);
      break label138;
      label708:
      this.BCj.setVisibility(0);
      localObject1 = getInput().getString("key_custom_bind_tips");
      if (bs.isNullOrNil((String)localObject1)) {
        break label244;
      }
      this.BCj.setText((CharSequence)localObject1);
      break label244;
      label745:
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label754:
      ac.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label771:
      if ((((am)localObject2).esa()) && (((am)localObject2).getTrueName() != null) && (!bs.isNullOrNil(((am)localObject2).getTrueName().trim())) && (((am)localObject2).esj()))
      {
        this.BCi.setVisibility(0);
        this.BCi.setText(((am)localObject2).getTrueName());
        this.BCh.setHint(getString(2131765151));
        this.BCi.setClickable(false);
        this.BCi.setEnabled(false);
      }
      else
      {
        this.BCi.setVisibility(8);
        this.BCh.setHint(getString(2131765328));
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
    com.tencent.mm.sdk.b.a.GpY.c(this.Bgb);
    com.tencent.mm.sdk.b.a.GpY.c(this.BlQ);
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
      ((ListViewInScrollView)((View)localObject1).findViewById(2131296471)).setAdapter(this.BCl);
      localObject2 = new d.a(this);
      ((d.a)localObject2).acF(2131765323);
      ((d.a)localObject2).gH((View)localObject1);
      ((d.a)localObject2).e(null);
      ((d.a)localObject2).acM(2131765291);
      localObject1 = ((d.a)localObject2).fvp();
      AppMethodBeat.o(70740);
      return localObject1;
    }
    if ((this.BCn) && (paramInt == 1000))
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
    com.tencent.mm.sdk.b.a.GpY.d(this.Bgb);
    com.tencent.mm.sdk.b.a.GpY.d(this.BlQ);
    super.onDestroy();
    AppMethodBeat.o(70737);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70743);
    if (!paramBoolean)
    {
      this.BCk = null;
      getInput().putParcelable("key_history_bankcard", null);
    }
    aRK();
    AppMethodBeat.o(70743);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70741);
    ac.d("Micromsg.WalletInputCardIDUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    paramString = new Bundle();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof y))
      {
        paramn = (y)paramn;
        paramString.putBoolean("key_need_area", paramn.eqI());
        paramString.putBoolean("key_need_profession", paramn.eqJ());
        paramString.putParcelableArray("key_profession_list", paramn.mProfessions);
        if (paramn.BoX == 1) {}
        for (bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_country", bool);
          paramString.putStringArray("key_country_excludes", paramn.BoY);
          if (paramn.BoT == null) {
            break label247;
          }
          if ((!paramn.BoT.BvW) || (!paramn.BoT.isError())) {
            break;
          }
          com.tencent.mm.ui.base.h.l(this, 2131765036, 2131755906);
          AppMethodBeat.o(70741);
          return true;
        }
        paramString.putString("bank_name", paramn.BoT.tGS);
        paramString.putParcelable("elemt_query", paramn.BoT);
        paramString.putString("key_card_id", this.BCh.getText());
        com.tencent.mm.wallet_core.a.k(this, paramString);
        AppMethodBeat.o(70741);
        return true;
        label247:
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.BCh.getText());
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
    paramString.putString("key_card_id", this.BCh.getText());
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
    List<t> BCq;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, List<t> paramList)
    {
      AppMethodBeat.i(70731);
      this.mInflater = null;
      this.BCq = new LinkedList();
      this.mContext = null;
      this.mInflater = LayoutInflater.from(paramContext);
      this.BCq = paramList;
      this.mContext = paramContext;
      AppMethodBeat.o(70731);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70732);
      if (this.BCq == null)
      {
        AppMethodBeat.o(70732);
        return 0;
      }
      int i = this.BCq.size();
      AppMethodBeat.o(70732);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70733);
      Object localObject = this.BCq.get(paramInt);
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
        paramViewGroup.BCr = ((ImageView)paramView.findViewById(2131306690));
        paramViewGroup.wER = ((TextView)paramView.findViewById(2131306689));
        paramViewGroup.BCs = ((TextView)paramView.findViewById(2131306692));
        paramViewGroup.BCt = ((TextView)paramView.findViewById(2131306691));
        paramView.setTag(paramViewGroup);
        localObject = (t)getItem(paramInt);
        if (bs.isNullOrNil(((t)localObject).vxj)) {
          break label336;
        }
        paramViewGroup.wER.setText(((t)localObject).vxj);
        paramViewGroup.wER.setVisibility(0);
        label128:
        if (bs.isNullOrNil(((t)localObject).BhE)) {
          break label348;
        }
        paramViewGroup.BCs.setText(((t)localObject).BhE);
        paramViewGroup.BCs.setVisibility(0);
        label159:
        if (bs.isNullOrNil(((t)localObject).BgG)) {
          break label360;
        }
        paramViewGroup.BCt.setText(((t)localObject).BgG);
        paramViewGroup.BCt.setVisibility(0);
      }
      for (;;)
      {
        String str = ((t)localObject).BhK;
        ac.v("Micromsg.WalletInputCardIDUI", "bankType:" + ((t)localObject).BhJ + ", logurl:" + str);
        paramViewGroup.BCr.setImageBitmap(null);
        if (!bs.isNullOrNil(str))
        {
          localObject = new c.a();
          o.aFC();
          ((c.a)localObject).hKO = null;
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
          ((c.a)localObject).gKe = com.tencent.mm.plugin.wallet_core.d.b.apw(str);
          ((c.a)localObject).hKx = true;
          ((c.a)localObject).gKm = true;
          localObject = ((c.a)localObject).aFT();
          o.aFB().a(str, paramViewGroup.BCr, (com.tencent.mm.av.a.a.c)localObject);
        }
        AppMethodBeat.o(70734);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label336:
        paramViewGroup.wER.setVisibility(8);
        break label128;
        label348:
        paramViewGroup.BCs.setVisibility(8);
        break label159;
        label360:
        paramViewGroup.BCt.setVisibility(8);
      }
    }
    
    final class a
    {
      ImageView BCr;
      TextView BCs;
      TextView BCt;
      TextView wER;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI
 * JD-Core Version:    0.7.0.1
 */