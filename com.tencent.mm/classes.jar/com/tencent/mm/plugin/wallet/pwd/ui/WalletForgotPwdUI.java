package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  c CXV;
  private ArrayList<Bankcard> CXu;
  private List<ElementQuery> DdF;
  private Bankcard DdG;
  private a DdH;
  private WalletFormView DdI;
  private WalletFormView DdJ;
  private int DdK;
  private boolean DdL;
  private boolean DdM;
  c DdN;
  private Button fSn;
  private LinearLayout fXb;
  private ListView hbO;
  
  public WalletForgotPwdUI()
  {
    AppMethodBeat.i(69665);
    this.CXu = new ArrayList();
    this.DdF = new LinkedList();
    this.DdK = 1;
    this.DdL = false;
    this.DdM = false;
    this.DdN = new c() {};
    this.CXV = new c() {};
    AppMethodBeat.o(69665);
  }
  
  private void aUI()
  {
    AppMethodBeat.i(69672);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_reset_with_new_card", getInput().getBoolean("key_is_reset_with_new_card", false));
    eHT();
    if ((this.DdG == null) && (!this.DdL))
    {
      doSceneProgress(new y(null, this.DdI.getText(), null));
      AppMethodBeat.o(69672);
      return;
    }
    if (this.DdL)
    {
      localObject = t.eJa().eKO();
      if (!bu.isNullOrNil(((am)localObject).field_find_passwd_url))
      {
        ae.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
        f.p(this, ((am)localObject).field_find_passwd_url, false);
        AppMethodBeat.o(69672);
        return;
      }
      localBundle.putBoolean("key_is_force_bind", true);
      localBundle.putBoolean("key_is_reset_with_new_card", true);
      if (getProcess() != null) {
        getProcess().a(this, 0, localBundle);
      }
      AppMethodBeat.o(69672);
      return;
    }
    com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.bs(this);
    localBundle.putParcelable("key_bankcard", this.DdG);
    Object localObject = new ElementQuery();
    Iterator localIterator = this.DdF.iterator();
    while (localIterator.hasNext())
    {
      ElementQuery localElementQuery = (ElementQuery)localIterator.next();
      ae.i("MicroMsg.WalletForgotPwdUI", "helios:::" + localElementQuery.dlT);
      if ((!bu.isNullOrNil(localElementQuery.dlT)) && (!bu.isNullOrNil(this.DdG.field_bankcardType)) && (localElementQuery.dlT.trim().equals(this.DdG.field_bankcardType.trim()))) {
        localObject = localElementQuery;
      }
    }
    for (;;)
    {
      localBundle.putParcelable("elemt_query", (Parcelable)localObject);
      if (locald != null) {
        locald.a(this, 0, localBundle);
      }
      AppMethodBeat.o(69672);
      return;
    }
  }
  
  private boolean aVv()
  {
    AppMethodBeat.i(69674);
    if ((this.hbO.getVisibility() == 0) || ((this.DdJ.aVz()) && (this.DdI.aVz())))
    {
      this.fSn.setEnabled(true);
      this.fSn.setClickable(true);
      AppMethodBeat.o(69674);
      return true;
    }
    this.fSn.setEnabled(false);
    this.fSn.setClickable(false);
    AppMethodBeat.o(69674);
    return false;
  }
  
  private void eHT()
  {
    AppMethodBeat.i(69671);
    getInput().remove("elemt_query");
    getInput().remove("key_bankcard");
    getInput().remove("bank_name");
    getInput().remove("key_card_id");
    AppMethodBeat.o(69671);
  }
  
  private void update()
  {
    AppMethodBeat.i(69669);
    s.eGW();
    this.CXu = s.eGX().eKb();
    if ((this.CXu == null) || (this.CXu.size() == 0) || (this.DdM))
    {
      ae.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[] { Boolean.valueOf(this.DdM) });
      this.CXu = new ArrayList();
      this.fXb.setVisibility(0);
      this.hbO.setVisibility(8);
      setMMTitle(2131765247);
      ((TextView)findViewById(2131306745)).setText(getString(2131765599));
      WalletFormView localWalletFormView = this.DdJ;
      s.eGW();
      localWalletFormView.setText(f.bam(s.eGX().getTrueName()));
      AppMethodBeat.o(69669);
      return;
    }
    ae.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
    if (com.tencent.mm.wallet_core.a.bs(this) != null) {
      doSceneForceProgress(new y());
    }
    this.fXb.setVisibility(8);
    this.fSn.setVisibility(8);
    findViewById(2131302460).setVisibility(0);
    this.DdH = new a(this);
    this.hbO.setAdapter(this.DdH);
    this.DdH.hMc = this.CXu;
    this.DdH.notifyDataSetChanged();
    AppMethodBeat.o(69669);
  }
  
  public boolean checkProcLife()
  {
    return true;
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495954;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69670);
    this.hbO = ((ListView)findViewById(2131304654));
    this.fXb = ((LinearLayout)findViewById(2131300219));
    this.DdJ = ((WalletFormView)findViewById(2131302662));
    this.DdI = ((WalletFormView)findViewById(2131297791));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.DdI);
    if (getInput().getBoolean("key_is_paymanager", false)) {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.DdJ);
    }
    for (;;)
    {
      this.DdJ.setOnInputValidChangeListener(this);
      this.DdI.setOnInputValidChangeListener(this);
      this.fSn = ((Button)findViewById(2131302852));
      this.fSn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69651);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          g.yxI.f(11353, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          WalletForgotPwdUI.a(WalletForgotPwdUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69651);
        }
      });
      this.DdL = false;
      s.eGW();
      this.CXu = s.eGX().eKb();
      update();
      findViewById(2131302460).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69652);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          f.p(WalletForgotPwdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69652);
        }
      });
      aVv();
      setEditFocusListener(this.DdI, 0, false, false);
      this.DdI.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69653);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          g.yxI.f(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
          paramAnonymousView = WalletForgotPwdUI.this;
          s.eGW();
          f.d(paramAnonymousView, s.eGX().getTrueName());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69653);
        }
      });
      this.DdI.getInfoIv().setClickable(true);
      this.DdI.getInfoIv().setImageResource(2131691405);
      this.DdI.getInfoIv().setVisibility(0);
      AppMethodBeat.o(69670);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.DdJ);
    }
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69676);
    if ((this.CXu == null) || (this.CXu.size() == 0))
    {
      am localam = t.eJa().eKO();
      if ((bu.isNullOrNil(localam.field_find_passwd_url)) && (bu.isNullOrNil(localam.field_forget_passwd_url)))
      {
        AppMethodBeat.o(69676);
        return false;
      }
      AppMethodBeat.o(69676);
      return true;
    }
    AppMethodBeat.o(69676);
    return false;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69678);
    super.onActivityResult(paramInt1, paramInt1, paramIntent);
    if ((paramInt2 == -1) && (1 == paramInt1))
    {
      paramIntent = paramIntent.getStringExtra("key_bankcard_id");
      this.DdI.set3DesValStr(paramIntent);
      aUI();
    }
    AppMethodBeat.o(69678);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69666);
    super.onCreate(paramBundle);
    setMMTitle(2131765640);
    this.DdM = getInput().getBoolean("key_is_force_bind", false);
    if (!this.DdM)
    {
      doSceneProgress(new ad(null, 6));
      setContentViewVisibility(4);
    }
    initView();
    com.tencent.mm.sdk.b.a.IvT.c(this.DdN);
    com.tencent.mm.sdk.b.a.IvT.c(this.CXV);
    AppMethodBeat.o(69666);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69667);
    com.tencent.mm.sdk.b.a.IvT.d(this.DdN);
    com.tencent.mm.sdk.b.a.IvT.d(this.CXV);
    super.onDestroy();
    AppMethodBeat.o(69667);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(69675);
    aVv();
    AppMethodBeat.o(69675);
  }
  
  public boolean onProgressFinish()
  {
    AppMethodBeat.i(69677);
    if (isTransparent()) {}
    for (int i = 4;; i = 0)
    {
      setContentViewVisibility(i);
      AppMethodBeat.o(69677);
      return true;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69668);
    super.onResume();
    update();
    AppMethodBeat.o(69668);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69673);
    ae.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", new Object[] { Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramn instanceof y)) {
        break label330;
      }
      paramString = (y)paramn;
      paramn = new Bundle();
      if (bu.isNullOrNil(paramString.oCY))
      {
        this.DdF = paramString.DgL;
        ae.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
        AppMethodBeat.o(69673);
        return true;
      }
      if (paramString.DgM != null)
      {
        if (paramString.DgM.isError())
        {
          ae.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
          h.l(this, 2131765036, 2131755906);
          AppMethodBeat.o(69673);
          return true;
        }
        if (this.CXu == null) {}
        for (paramInt1 = 0;; paramInt1 = this.CXu.size())
        {
          ae.i("MicroMsg.WalletForgotPwdUI", "scene case 3 bankcards size %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((this.CXu != null) && (this.CXu.size() != 0)) {
            break;
          }
          eHT();
          paramn.putString("bank_name", paramString.DgM.uVs);
          paramn.putParcelable("elemt_query", paramString.DgM);
          paramn.putString("key_card_id", this.DdI.getText());
          paramn.putBoolean("key_is_reset_with_new_card", true);
          com.tencent.mm.wallet_core.a.k(this, paramn);
          AppMethodBeat.o(69673);
          return true;
        }
      }
      paramn.putString("bank_name", "");
      paramn.putParcelable("elemt_query", new ElementQuery());
      paramn.putString("key_card_id", this.DdI.getText());
      paramn.putBoolean("key_is_reset_with_new_card", true);
      com.tencent.mm.wallet_core.a.k(this, paramn);
    }
    label330:
    boolean bool;
    do
    {
      do
      {
        AppMethodBeat.o(69673);
        return false;
      } while (!(paramn instanceof ad));
      if (this.DdH != null) {
        break;
      }
      bool = true;
      ae.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter is null ? %s", new Object[] { Boolean.valueOf(bool) });
    } while (this.DdH == null);
    paramString = null;
    if (t.eJf() != null) {
      paramString = t.eJf().eKb();
    }
    paramn = com.tencent.mm.wallet_core.a.bs(this);
    ArrayList localArrayList;
    if (paramn != null)
    {
      paramn.fVl();
      paramn = new ArrayList();
      localArrayList = new ArrayList();
      paramString = paramString.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label496;
        }
        Bankcard localBankcard = (Bankcard)paramString.next();
        if (localBankcard.field_bankcardTag == 1)
        {
          paramn.add(localBankcard);
          continue;
          bool = false;
          break;
        }
        if (localBankcard.field_bankcardTag == 2) {
          localArrayList.add(localBankcard);
        }
      }
      label496:
      if (paramn.size() > 0) {
        this.CXu = paramn;
      }
    }
    else
    {
      label510:
      if (this.CXu != null) {
        break label583;
      }
    }
    label583:
    for (paramInt1 = 0;; paramInt1 = this.CXu.size())
    {
      ae.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter update bankcardsize:  %d", new Object[] { Integer.valueOf(paramInt1) });
      this.DdH.hMc = this.CXu;
      new aq(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(69654);
          WalletForgotPwdUI.b(WalletForgotPwdUI.this).notifyDataSetChanged();
          WalletForgotPwdUI.c(WalletForgotPwdUI.this);
          AppMethodBeat.o(69654);
        }
      });
      break;
      this.CXu = localArrayList;
      break label510;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends BaseAdapter
  {
    private Context context;
    List<Bankcard> hMc;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(69660);
      this.hMc = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(69660);
    }
    
    private Bankcard VS(int paramInt)
    {
      AppMethodBeat.i(69663);
      if ((paramInt >= 0) && (paramInt <= this.hMc.size() - 1))
      {
        Bankcard localBankcard = (Bankcard)this.hMc.get(paramInt);
        AppMethodBeat.o(69663);
        return localBankcard;
      }
      AppMethodBeat.o(69663);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(69662);
      int i = this.hMc.size();
      AppMethodBeat.o(69662);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(69661);
      if (paramView == null) {}
      for (paramView = (WalletFormView)View.inflate(this.context, 2131495908, null);; paramView = (WalletFormView)paramView)
      {
        final Bankcard localBankcard = VS(paramInt);
        if (localBankcard != null)
        {
          String str = localBankcard.field_desc;
          paramViewGroup = str;
          if (localBankcard.field_bankcardState == 1) {
            paramViewGroup = str + this.context.getString(2131765278);
          }
          paramView.setText(paramViewGroup);
        }
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69659);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$ChoiceBankAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if ((localBankcard != null) && (localBankcard.field_bankcardState == 1))
            {
              paramAnonymousView = new d.a(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this));
              paramAnonymousView.afR(2131765276);
              paramAnonymousView.afU(2131765277).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(69658);
                  f.p(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this), "https://kf.qq.com/touch/sappfaq/180704b6Zb2q180704IfqY3u.html?scene_id=kf1&platform=15", true);
                  AppMethodBeat.o(69658);
                }
              });
              paramAnonymousView.afV(2131755793);
              paramAnonymousView.zf(false);
              paramAnonymousView.fQv().show();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$ChoiceBankAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69659);
              return;
              WalletForgotPwdUI.a(WalletForgotPwdUI.this, localBankcard);
              WalletForgotPwdUI.a(WalletForgotPwdUI.this, false);
              WalletForgotPwdUI.a(WalletForgotPwdUI.this);
            }
          }
        });
        AppMethodBeat.o(69661);
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI
 * JD-Core Version:    0.7.0.1
 */