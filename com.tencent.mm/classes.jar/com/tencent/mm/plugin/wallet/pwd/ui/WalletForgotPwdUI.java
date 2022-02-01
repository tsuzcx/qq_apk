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
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  private ArrayList<Bankcard> BfA;
  c Bgb;
  private List<ElementQuery> BlI;
  private Bankcard BlJ;
  private a BlK;
  private WalletFormView BlL;
  private WalletFormView BlM;
  private int BlN;
  private boolean BlO;
  private boolean BlP;
  c BlQ;
  private LinearLayout fBI;
  private Button fwU;
  private ListView gFr;
  
  public WalletForgotPwdUI()
  {
    AppMethodBeat.i(69665);
    this.BfA = new ArrayList();
    this.BlI = new LinkedList();
    this.BlN = 1;
    this.BlO = false;
    this.BlP = false;
    this.BlQ = new c() {};
    this.Bgb = new c() {};
    AppMethodBeat.o(69665);
  }
  
  private void aQX()
  {
    AppMethodBeat.i(69672);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_reset_with_new_card", getInput().getBoolean("key_is_reset_with_new_card", false));
    eqm();
    if ((this.BlJ == null) && (!this.BlO))
    {
      doSceneProgress(new y(null, this.BlL.getText(), null));
      AppMethodBeat.o(69672);
      return;
    }
    if (this.BlO)
    {
      localObject = com.tencent.mm.plugin.wallet_core.model.s.ert().eta();
      if (!bs.isNullOrNil(((al)localObject).field_find_passwd_url))
      {
        ac.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
        e.o(this, ((al)localObject).field_find_passwd_url, false);
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
    localBundle.putParcelable("key_bankcard", this.BlJ);
    Object localObject = new ElementQuery();
    Iterator localIterator = this.BlI.iterator();
    while (localIterator.hasNext())
    {
      ElementQuery localElementQuery = (ElementQuery)localIterator.next();
      ac.i("MicroMsg.WalletForgotPwdUI", "helios:::" + localElementQuery.cZz);
      if ((!bs.isNullOrNil(localElementQuery.cZz)) && (!bs.isNullOrNil(this.BlJ.field_bankcardType)) && (localElementQuery.cZz.trim().equals(this.BlJ.field_bankcardType.trim()))) {
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
  
  private boolean aRK()
  {
    AppMethodBeat.i(69674);
    if ((this.gFr.getVisibility() == 0) || ((this.BlM.aRO()) && (this.BlL.aRO())))
    {
      this.fwU.setEnabled(true);
      this.fwU.setClickable(true);
      AppMethodBeat.o(69674);
      return true;
    }
    this.fwU.setEnabled(false);
    this.fwU.setClickable(false);
    AppMethodBeat.o(69674);
    return false;
  }
  
  private void eqm()
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
    com.tencent.mm.plugin.wallet.a.s.epp();
    this.BfA = com.tencent.mm.plugin.wallet.a.s.epq().esu();
    if ((this.BfA == null) || (this.BfA.size() == 0) || (this.BlP))
    {
      ac.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[] { Boolean.valueOf(this.BlP) });
      this.BfA = new ArrayList();
      this.fBI.setVisibility(0);
      this.gFr.setVisibility(8);
      setMMTitle(2131765247);
      ((TextView)findViewById(2131306745)).setText(getString(2131765599));
      WalletFormView localWalletFormView = this.BlM;
      com.tencent.mm.plugin.wallet.a.s.epp();
      localWalletFormView.setText(e.aSK(com.tencent.mm.plugin.wallet.a.s.epq().getTrueName()));
      AppMethodBeat.o(69669);
      return;
    }
    ac.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
    if (com.tencent.mm.wallet_core.a.br(this) != null) {
      doSceneForceProgress(new y());
    }
    this.fBI.setVisibility(8);
    this.fwU.setVisibility(8);
    findViewById(2131302460).setVisibility(0);
    this.BlK = new a(this);
    this.gFr.setAdapter(this.BlK);
    this.BlK.hqR = this.BfA;
    this.BlK.notifyDataSetChanged();
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
    this.gFr = ((ListView)findViewById(2131304654));
    this.fBI = ((LinearLayout)findViewById(2131300219));
    this.BlM = ((WalletFormView)findViewById(2131302662));
    this.BlL = ((WalletFormView)findViewById(2131297791));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.BlL);
    if (getInput().getBoolean("key_is_paymanager", false)) {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.BlM);
    }
    for (;;)
    {
      this.BlM.setOnInputValidChangeListener(this);
      this.BlL.setOnInputValidChangeListener(this);
      this.fwU = ((Button)findViewById(2131302852));
      this.fwU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69651);
          com.tencent.mm.plugin.report.service.h.wUl.f(11353, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          WalletForgotPwdUI.a(WalletForgotPwdUI.this);
          AppMethodBeat.o(69651);
        }
      });
      this.BlO = false;
      com.tencent.mm.plugin.wallet.a.s.epp();
      this.BfA = com.tencent.mm.plugin.wallet.a.s.epq().esu();
      update();
      findViewById(2131302460).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69652);
          e.o(WalletForgotPwdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
          AppMethodBeat.o(69652);
        }
      });
      aRK();
      setEditFocusListener(this.BlL, 0, false, false);
      this.BlL.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69653);
          com.tencent.mm.plugin.report.service.h.wUl.f(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
          paramAnonymousView = WalletForgotPwdUI.this;
          com.tencent.mm.plugin.wallet.a.s.epp();
          e.d(paramAnonymousView, com.tencent.mm.plugin.wallet.a.s.epq().getTrueName());
          AppMethodBeat.o(69653);
        }
      });
      this.BlL.getInfoIv().setClickable(true);
      this.BlL.getInfoIv().setImageResource(2131691405);
      this.BlL.getInfoIv().setVisibility(0);
      AppMethodBeat.o(69670);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.BlM);
    }
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69676);
    if ((this.BfA == null) || (this.BfA.size() == 0))
    {
      al localal = com.tencent.mm.plugin.wallet_core.model.s.ert().eta();
      if ((bs.isNullOrNil(localal.field_find_passwd_url)) && (bs.isNullOrNil(localal.field_forget_passwd_url)))
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
      this.BlL.set3DesValStr(paramIntent);
      aQX();
    }
    AppMethodBeat.o(69678);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69666);
    super.onCreate(paramBundle);
    setMMTitle(2131765640);
    this.BlP = getInput().getBoolean("key_is_force_bind", false);
    if (!this.BlP)
    {
      doSceneProgress(new ad(null, 6));
      setContentViewVisibility(4);
    }
    initView();
    com.tencent.mm.sdk.b.a.GpY.c(this.BlQ);
    com.tencent.mm.sdk.b.a.GpY.c(this.Bgb);
    AppMethodBeat.o(69666);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69667);
    com.tencent.mm.sdk.b.a.GpY.d(this.BlQ);
    com.tencent.mm.sdk.b.a.GpY.d(this.Bgb);
    super.onDestroy();
    AppMethodBeat.o(69667);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(69675);
    aRK();
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
    ac.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", new Object[] { Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramn instanceof y)) {
        break label330;
      }
      paramString = (y)paramn;
      paramn = new Bundle();
      if (bs.isNullOrNil(paramString.nTb))
      {
        this.BlI = paramString.BoS;
        ac.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
        AppMethodBeat.o(69673);
        return true;
      }
      if (paramString.BoT != null)
      {
        if (paramString.BoT.isError())
        {
          ac.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
          com.tencent.mm.ui.base.h.l(this, 2131765036, 2131755906);
          AppMethodBeat.o(69673);
          return true;
        }
        if (this.BfA == null) {}
        for (paramInt1 = 0;; paramInt1 = this.BfA.size())
        {
          ac.i("MicroMsg.WalletForgotPwdUI", "scene case 3 bankcards size %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((this.BfA != null) && (this.BfA.size() != 0)) {
            break;
          }
          eqm();
          paramn.putString("bank_name", paramString.BoT.tGS);
          paramn.putParcelable("elemt_query", paramString.BoT);
          paramn.putString("key_card_id", this.BlL.getText());
          paramn.putBoolean("key_is_reset_with_new_card", true);
          com.tencent.mm.wallet_core.a.k(this, paramn);
          AppMethodBeat.o(69673);
          return true;
        }
      }
      paramn.putString("bank_name", "");
      paramn.putParcelable("elemt_query", new ElementQuery());
      paramn.putString("key_card_id", this.BlL.getText());
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
      if (this.BlK != null) {
        break;
      }
      bool = true;
      ac.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter is null ? %s", new Object[] { Boolean.valueOf(bool) });
    } while (this.BlK == null);
    paramString = null;
    if (com.tencent.mm.plugin.wallet_core.model.s.ery() != null) {
      paramString = com.tencent.mm.plugin.wallet_core.model.s.ery().esu();
    }
    paramn = com.tencent.mm.wallet_core.a.br(this);
    ArrayList localArrayList;
    if (paramn != null)
    {
      paramn.fzF();
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
        this.BfA = paramn;
      }
    }
    else
    {
      label510:
      if (this.BfA != null) {
        break label583;
      }
    }
    label583:
    for (paramInt1 = 0;; paramInt1 = this.BfA.size())
    {
      ac.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter update bankcardsize:  %d", new Object[] { Integer.valueOf(paramInt1) });
      this.BlK.hqR = this.BfA;
      new ao(Looper.getMainLooper()).post(new Runnable()
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
      this.BfA = localArrayList;
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
    List<Bankcard> hqR;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(69660);
      this.hqR = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(69660);
    }
    
    private Bankcard Tt(int paramInt)
    {
      AppMethodBeat.i(69663);
      if ((paramInt >= 0) && (paramInt <= this.hqR.size() - 1))
      {
        Bankcard localBankcard = (Bankcard)this.hqR.get(paramInt);
        AppMethodBeat.o(69663);
        return localBankcard;
      }
      AppMethodBeat.o(69663);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(69662);
      int i = this.hqR.size();
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
        final Bankcard localBankcard = Tt(paramInt);
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
            if ((localBankcard != null) && (localBankcard.field_bankcardState == 1))
            {
              paramAnonymousView = new d.a(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this));
              paramAnonymousView.acJ(2131765276);
              paramAnonymousView.acM(2131765277).b(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(69658);
                  e.o(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this), "https://kf.qq.com/touch/sappfaq/180704b6Zb2q180704IfqY3u.html?scene_id=kf1&platform=15", true);
                  AppMethodBeat.o(69658);
                }
              });
              paramAnonymousView.acN(2131755793);
              paramAnonymousView.yf(false);
              paramAnonymousView.fvp().show();
              AppMethodBeat.o(69659);
              return;
            }
            WalletForgotPwdUI.a(WalletForgotPwdUI.this, localBankcard);
            WalletForgotPwdUI.a(WalletForgotPwdUI.this, false);
            WalletForgotPwdUI.a(WalletForgotPwdUI.this);
            AppMethodBeat.o(69659);
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