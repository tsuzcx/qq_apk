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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.si;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
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
  private ArrayList<Bankcard> CFO;
  c CGp;
  private List<ElementQuery> CLX;
  private Bankcard CLY;
  private a CLZ;
  private WalletFormView CMa;
  private WalletFormView CMb;
  private int CMc;
  private boolean CMd;
  private boolean CMe;
  c CMf;
  private Button fQh;
  private LinearLayout fUV;
  private ListView gZb;
  
  public WalletForgotPwdUI()
  {
    AppMethodBeat.i(69665);
    this.CFO = new ArrayList();
    this.CLX = new LinkedList();
    this.CMc = 1;
    this.CMd = false;
    this.CMe = false;
    this.CMf = new c() {};
    this.CGp = new WalletForgotPwdUI.8(this);
    AppMethodBeat.o(69665);
  }
  
  private boolean aUW()
  {
    AppMethodBeat.i(69674);
    if ((this.gZb.getVisibility() == 0) || ((this.CMb.aVa()) && (this.CMa.aVa())))
    {
      this.fQh.setEnabled(true);
      this.fQh.setClickable(true);
      AppMethodBeat.o(69674);
      return true;
    }
    this.fQh.setEnabled(false);
    this.fQh.setClickable(false);
    AppMethodBeat.o(69674);
    return false;
  }
  
  private void aUj()
  {
    AppMethodBeat.i(69672);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_reset_with_new_card", getInput().getBoolean("key_is_reset_with_new_card", false));
    eEm();
    if ((this.CLY == null) && (!this.CMd))
    {
      doSceneProgress(new y(null, this.CMa.getText(), null));
      AppMethodBeat.o(69672);
      return;
    }
    if (this.CMd)
    {
      localObject = t.eFt().eHg();
      if (!bt.isNullOrNil(((am)localObject).field_find_passwd_url))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
        e.o(this, ((am)localObject).field_find_passwd_url, false);
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
    com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.br(this);
    localBundle.putParcelable("key_bankcard", this.CLY);
    Object localObject = new ElementQuery();
    Iterator localIterator = this.CLX.iterator();
    while (localIterator.hasNext())
    {
      ElementQuery localElementQuery = (ElementQuery)localIterator.next();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "helios:::" + localElementQuery.dkR);
      if ((!bt.isNullOrNil(localElementQuery.dkR)) && (!bt.isNullOrNil(this.CLY.field_bankcardType)) && (localElementQuery.dkR.trim().equals(this.CLY.field_bankcardType.trim()))) {
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
  
  private void eEm()
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
    s.eDp();
    this.CFO = s.eDq().eGu();
    if ((this.CFO == null) || (this.CFO.size() == 0) || (this.CMe))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[] { Boolean.valueOf(this.CMe) });
      this.CFO = new ArrayList();
      this.fUV.setVisibility(0);
      this.gZb.setVisibility(8);
      setMMTitle(2131765247);
      ((TextView)findViewById(2131306745)).setText(getString(2131765599));
      WalletFormView localWalletFormView = this.CMb;
      s.eDp();
      localWalletFormView.setText(e.aYJ(s.eDq().getTrueName()));
      AppMethodBeat.o(69669);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
    if (com.tencent.mm.wallet_core.a.br(this) != null) {
      doSceneForceProgress(new y());
    }
    this.fUV.setVisibility(8);
    this.fQh.setVisibility(8);
    findViewById(2131302460).setVisibility(0);
    this.CLZ = new a(this);
    this.gZb.setAdapter(this.CLZ);
    this.CLZ.hJj = this.CFO;
    this.CLZ.notifyDataSetChanged();
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
    this.gZb = ((ListView)findViewById(2131304654));
    this.fUV = ((LinearLayout)findViewById(2131300219));
    this.CMb = ((WalletFormView)findViewById(2131302662));
    this.CMa = ((WalletFormView)findViewById(2131297791));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.CMa);
    if (getInput().getBoolean("key_is_paymanager", false)) {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.CMb);
    }
    for (;;)
    {
      this.CMb.setOnInputValidChangeListener(this);
      this.CMa.setOnInputValidChangeListener(this);
      this.fQh = ((Button)findViewById(2131302852));
      this.fQh.setOnClickListener(new WalletForgotPwdUI.1(this));
      this.CMd = false;
      s.eDp();
      this.CFO = s.eDq().eGu();
      update();
      findViewById(2131302460).setOnClickListener(new WalletForgotPwdUI.2(this));
      aUW();
      setEditFocusListener(this.CMa, 0, false, false);
      this.CMa.setOnInfoIvClickListener(new WalletForgotPwdUI.3(this));
      this.CMa.getInfoIv().setClickable(true);
      this.CMa.getInfoIv().setImageResource(2131691405);
      this.CMa.getInfoIv().setVisibility(0);
      AppMethodBeat.o(69670);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.CMb);
    }
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69676);
    if ((this.CFO == null) || (this.CFO.size() == 0))
    {
      am localam = t.eFt().eHg();
      if ((bt.isNullOrNil(localam.field_find_passwd_url)) && (bt.isNullOrNil(localam.field_forget_passwd_url)))
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
      this.CMa.set3DesValStr(paramIntent);
      aUj();
    }
    AppMethodBeat.o(69678);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69666);
    super.onCreate(paramBundle);
    setMMTitle(2131765640);
    this.CMe = getInput().getBoolean("key_is_force_bind", false);
    if (!this.CMe)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 6));
      setContentViewVisibility(4);
    }
    initView();
    com.tencent.mm.sdk.b.a.IbL.c(this.CMf);
    com.tencent.mm.sdk.b.a.IbL.c(this.CGp);
    AppMethodBeat.o(69666);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69667);
    com.tencent.mm.sdk.b.a.IbL.d(this.CMf);
    com.tencent.mm.sdk.b.a.IbL.d(this.CGp);
    super.onDestroy();
    AppMethodBeat.o(69667);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(69675);
    aUW();
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", new Object[] { Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramn instanceof y)) {
        break label330;
      }
      paramString = (y)paramn;
      paramn = new Bundle();
      if (bt.isNullOrNil(paramString.oww))
      {
        this.CLX = paramString.CPh;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
        AppMethodBeat.o(69673);
        return true;
      }
      if (paramString.CPi != null)
      {
        if (paramString.CPi.isError())
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
          h.l(this, 2131765036, 2131755906);
          AppMethodBeat.o(69673);
          return true;
        }
        if (this.CFO == null) {}
        for (paramInt1 = 0;; paramInt1 = this.CFO.size())
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "scene case 3 bankcards size %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((this.CFO != null) && (this.CFO.size() != 0)) {
            break;
          }
          eEm();
          paramn.putString("bank_name", paramString.CPi.uJF);
          paramn.putParcelable("elemt_query", paramString.CPi);
          paramn.putString("key_card_id", this.CMa.getText());
          paramn.putBoolean("key_is_reset_with_new_card", true);
          com.tencent.mm.wallet_core.a.k(this, paramn);
          AppMethodBeat.o(69673);
          return true;
        }
      }
      paramn.putString("bank_name", "");
      paramn.putParcelable("elemt_query", new ElementQuery());
      paramn.putString("key_card_id", this.CMa.getText());
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
      } while (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad));
      if (this.CLZ != null) {
        break;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter is null ? %s", new Object[] { Boolean.valueOf(bool) });
    } while (this.CLZ == null);
    paramString = null;
    if (t.eFy() != null) {
      paramString = t.eFy().eGu();
    }
    paramn = com.tencent.mm.wallet_core.a.br(this);
    ArrayList localArrayList;
    if (paramn != null)
    {
      paramn.fQP();
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
        this.CFO = paramn;
      }
    }
    else
    {
      label510:
      if (this.CFO != null) {
        break label583;
      }
    }
    label583:
    for (paramInt1 = 0;; paramInt1 = this.CFO.size())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter update bankcardsize:  %d", new Object[] { Integer.valueOf(paramInt1) });
      this.CLZ.hJj = this.CFO;
      new ap(Looper.getMainLooper()).post(new Runnable()
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
      this.CFO = localArrayList;
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
    List<Bankcard> hJj;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(69660);
      this.hJj = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(69660);
    }
    
    private Bankcard Vl(int paramInt)
    {
      AppMethodBeat.i(69663);
      if ((paramInt >= 0) && (paramInt <= this.hJj.size() - 1))
      {
        Bankcard localBankcard = (Bankcard)this.hJj.get(paramInt);
        AppMethodBeat.o(69663);
        return localBankcard;
      }
      AppMethodBeat.o(69663);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(69662);
      int i = this.hJj.size();
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
        final Bankcard localBankcard = Vl(paramInt);
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$ChoiceBankAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if ((localBankcard != null) && (localBankcard.field_bankcardState == 1))
            {
              paramAnonymousView = new d.a(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this));
              paramAnonymousView.afi(2131765276);
              paramAnonymousView.afl(2131765277).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(69658);
                  e.o(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this), "https://kf.qq.com/touch/sappfaq/180704b6Zb2q180704IfqY3u.html?scene_id=kf1&platform=15", true);
                  AppMethodBeat.o(69658);
                }
              });
              paramAnonymousView.afm(2131755793);
              paramAnonymousView.yR(false);
              paramAnonymousView.fMb().show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI
 * JD-Core Version:    0.7.0.1
 */