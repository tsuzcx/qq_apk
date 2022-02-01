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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
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
  IListener HDJ;
  private ArrayList<Bankcard> HDi;
  private Bankcard HJA;
  private a HJB;
  private WalletFormView HJC;
  private WalletFormView HJD;
  private int HJE;
  private boolean HJF;
  private boolean HJG;
  IListener HJH;
  private List<ElementQuery> HJz;
  private LinearLayout gCh;
  private Button gxv;
  private ListView hUI;
  
  public WalletForgotPwdUI()
  {
    AppMethodBeat.i(69665);
    this.HDi = new ArrayList();
    this.HJz = new LinkedList();
    this.HJE = 1;
    this.HJF = false;
    this.HJG = false;
    this.HJH = new IListener() {};
    this.HDJ = new WalletForgotPwdUI.8(this);
    AppMethodBeat.o(69665);
  }
  
  private void bpv()
  {
    AppMethodBeat.i(69672);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_reset_with_new_card", getInput().getBoolean("key_is_reset_with_new_card", false));
    fPf();
    if ((this.HJA == null) && (!this.HJF))
    {
      doSceneProgress(new y(null, this.HJC.getText(), null));
      AppMethodBeat.o(69672);
      return;
    }
    if (this.HJF)
    {
      localObject = t.fQD().fRN();
      if (!Util.isNullOrNil(((am)localObject).field_find_passwd_url))
      {
        Log.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
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
    com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.by(this);
    localBundle.putParcelable("key_bankcard", this.HJA);
    Object localObject = new ElementQuery();
    Iterator localIterator = this.HJz.iterator();
    while (localIterator.hasNext())
    {
      ElementQuery localElementQuery = (ElementQuery)localIterator.next();
      Log.i("MicroMsg.WalletForgotPwdUI", "helios:::" + localElementQuery.dDj);
      if ((!Util.isNullOrNil(localElementQuery.dDj)) && (!Util.isNullOrNil(this.HJA.field_bankcardType)) && (localElementQuery.dDj.trim().equals(this.HJA.field_bankcardType.trim()))) {
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
  
  private boolean bqg()
  {
    AppMethodBeat.i(69674);
    if ((this.hUI.getVisibility() == 0) || ((this.HJD.bql()) && (this.HJC.bql())))
    {
      this.gxv.setEnabled(true);
      this.gxv.setClickable(true);
      AppMethodBeat.o(69674);
      return true;
    }
    this.gxv.setEnabled(false);
    this.gxv.setClickable(false);
    AppMethodBeat.o(69674);
    return false;
  }
  
  private void fPf()
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
    s.fOg();
    this.HDi = s.fOh().fRE();
    if ((this.HDi == null) || (this.HDi.size() == 0) || (this.HJG))
    {
      Log.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[] { Boolean.valueOf(this.HJG) });
      this.HDi = new ArrayList();
      this.gCh.setVisibility(0);
      this.hUI.setVisibility(8);
      setMMTitle(2131767690);
      ((TextView)findViewById(2131310206)).setText(getString(2131768048));
      WalletFormView localWalletFormView = this.HJD;
      s.fOg();
      localWalletFormView.setText(f.bpu(s.fOh().getTrueName()));
      AppMethodBeat.o(69669);
      return;
    }
    Log.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
    if (com.tencent.mm.wallet_core.a.by(this) != null) {
      doSceneForceProgress(new y());
    }
    this.gCh.setVisibility(8);
    this.gxv.setVisibility(8);
    findViewById(2131304869).setVisibility(0);
    this.HJB = new a(this);
    this.hUI.setAdapter(this.HJB);
    this.HJB.iHf = this.HDi;
    this.HJB.notifyDataSetChanged();
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
    return 2131496934;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69670);
    this.hUI = ((ListView)findViewById(2131307707));
    this.gCh = ((LinearLayout)findViewById(2131301693));
    this.HJD = ((WalletFormView)findViewById(2131305216));
    this.HJC = ((WalletFormView)findViewById(2131298106));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.HJC);
    if (getInput().getBoolean("key_is_paymanager", false)) {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.HJD);
    }
    for (;;)
    {
      this.HJD.setOnInputValidChangeListener(this);
      this.HJC.setOnInputValidChangeListener(this);
      this.gxv = ((Button)findViewById(2131305423));
      this.gxv.setOnClickListener(new WalletForgotPwdUI.1(this));
      this.HJF = false;
      s.fOg();
      this.HDi = s.fOh().fRE();
      update();
      findViewById(2131304869).setOnClickListener(new WalletForgotPwdUI.2(this));
      bqg();
      setEditFocusListener(this.HJC, 0, false, false);
      this.HJC.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69653);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.report.service.h.CyF.a(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
          paramAnonymousView = WalletForgotPwdUI.this;
          s.fOg();
          f.d(paramAnonymousView, s.fOh().getTrueName());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69653);
        }
      });
      this.HJC.getInfoIv().setClickable(true);
      this.HJC.getInfoIv().setImageResource(2131691739);
      this.HJC.getInfoIv().setVisibility(0);
      AppMethodBeat.o(69670);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.HJD);
    }
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69676);
    if ((this.HDi == null) || (this.HDi.size() == 0))
    {
      am localam = t.fQD().fRN();
      if ((Util.isNullOrNil(localam.field_find_passwd_url)) && (Util.isNullOrNil(localam.field_forget_passwd_url)))
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
      this.HJC.set3DesValStr(paramIntent);
      bpv();
    }
    AppMethodBeat.o(69678);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69666);
    super.onCreate(paramBundle);
    setMMTitle(2131768093);
    this.HJG = getInput().getBoolean("key_is_force_bind", false);
    if (!this.HJG)
    {
      doSceneProgress(new ad(null, 6));
      setContentViewVisibility(4);
    }
    initView();
    EventCenter.instance.addListener(this.HJH);
    EventCenter.instance.addListener(this.HDJ);
    AppMethodBeat.o(69666);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69667);
    EventCenter.instance.removeListener(this.HJH);
    EventCenter.instance.removeListener(this.HDJ);
    super.onDestroy();
    AppMethodBeat.o(69667);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(69675);
    bqg();
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69673);
    Log.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", new Object[] { Integer.valueOf(paramInt2), paramString, paramq });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramq instanceof y)) {
        break label330;
      }
      paramString = (y)paramq;
      paramq = new Bundle();
      if (Util.isNullOrNil(paramString.pQH))
      {
        this.HJz = paramString.HQe;
        Log.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
        AppMethodBeat.o(69673);
        return true;
      }
      if (paramString.HQf != null)
      {
        if (paramString.HQf.isError())
        {
          Log.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
          com.tencent.mm.ui.base.h.n(this, 2131767479, 2131755998);
          AppMethodBeat.o(69673);
          return true;
        }
        if (this.HDi == null) {}
        for (paramInt1 = 0;; paramInt1 = this.HDi.size())
        {
          Log.i("MicroMsg.WalletForgotPwdUI", "scene case 3 bankcards size %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((this.HDi != null) && (this.HDi.size() != 0)) {
            break;
          }
          fPf();
          paramq.putString("bank_name", paramString.HQf.ynT);
          paramq.putParcelable("elemt_query", paramString.HQf);
          paramq.putString("key_card_id", this.HJC.getText());
          paramq.putBoolean("key_is_reset_with_new_card", true);
          com.tencent.mm.wallet_core.a.l(this, paramq);
          AppMethodBeat.o(69673);
          return true;
        }
      }
      paramq.putString("bank_name", "");
      paramq.putParcelable("elemt_query", new ElementQuery());
      paramq.putString("key_card_id", this.HJC.getText());
      paramq.putBoolean("key_is_reset_with_new_card", true);
      com.tencent.mm.wallet_core.a.l(this, paramq);
    }
    label330:
    boolean bool;
    do
    {
      do
      {
        AppMethodBeat.o(69673);
        return false;
      } while (!(paramq instanceof ad));
      if (this.HJB != null) {
        break;
      }
      bool = true;
      Log.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter is null ? %s", new Object[] { Boolean.valueOf(bool) });
    } while (this.HJB == null);
    paramString = null;
    if (t.fQI() != null) {
      paramString = t.fQI().fRE();
    }
    paramq = com.tencent.mm.wallet_core.a.by(this);
    ArrayList localArrayList;
    if (paramq != null)
    {
      paramq.hgI();
      paramq = new ArrayList();
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
          paramq.add(localBankcard);
          continue;
          bool = false;
          break;
        }
        if (localBankcard.field_bankcardTag == 2) {
          localArrayList.add(localBankcard);
        }
      }
      label496:
      if (paramq.size() > 0) {
        this.HDi = paramq;
      }
    }
    else
    {
      label510:
      if (this.HDi != null) {
        break label583;
      }
    }
    label583:
    for (paramInt1 = 0;; paramInt1 = this.HDi.size())
    {
      Log.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter update bankcardsize:  %d", new Object[] { Integer.valueOf(paramInt1) });
      this.HJB.iHf = this.HDi;
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
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
      this.HDi = localArrayList;
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
    List<Bankcard> iHf;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(69660);
      this.iHf = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(69660);
    }
    
    private Bankcard aeu(int paramInt)
    {
      AppMethodBeat.i(69663);
      if ((paramInt >= 0) && (paramInt <= this.iHf.size() - 1))
      {
        Bankcard localBankcard = (Bankcard)this.iHf.get(paramInt);
        AppMethodBeat.o(69663);
        return localBankcard;
      }
      AppMethodBeat.o(69663);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(69662);
      int i = this.iHf.size();
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
      for (paramView = (WalletFormView)View.inflate(this.context, 2131496888, null);; paramView = (WalletFormView)paramView)
      {
        final Bankcard localBankcard = aeu(paramInt);
        if (localBankcard != null)
        {
          String str = localBankcard.field_desc;
          paramViewGroup = str;
          if (localBankcard.field_bankcardState == 1) {
            paramViewGroup = str + this.context.getString(2131767721);
          }
          paramView.setText(paramViewGroup);
        }
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69659);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$ChoiceBankAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if ((localBankcard != null) && (localBankcard.field_bankcardState == 1))
            {
              paramAnonymousView = new d.a(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this));
              paramAnonymousView.aoS(2131767719);
              paramAnonymousView.aoV(2131767720).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(69658);
                  f.p(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this), "https://" + WeChatHosts.domainString(2131761715) + "/touch/sappfaq/180704b6Zb2q180704IfqY3u.html?scene_id=kf1&platform=15", true);
                  AppMethodBeat.o(69658);
                }
              });
              paramAnonymousView.aoW(2131755874);
              paramAnonymousView.Dk(false);
              paramAnonymousView.hbn().show();
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