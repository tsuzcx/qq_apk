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
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  private Button ftn;
  private LinearLayout fyb;
  private ListView izP;
  c zNH;
  private ArrayList<Bankcard> zNg;
  private List<ElementQuery> zTo;
  private Bankcard zTp;
  private a zTq;
  private WalletFormView zTr;
  private WalletFormView zTs;
  private int zTt;
  private boolean zTu;
  private boolean zTv;
  c zTw;
  
  public WalletForgotPwdUI()
  {
    AppMethodBeat.i(69665);
    this.zNg = new ArrayList();
    this.zTo = new LinkedList();
    this.zTt = 1;
    this.zTu = false;
    this.zTv = false;
    this.zTw = new c() {};
    this.zNH = new c() {};
    AppMethodBeat.o(69665);
  }
  
  private boolean aKT()
  {
    AppMethodBeat.i(69674);
    if ((this.izP.getVisibility() == 0) || ((this.zTs.aKX()) && (this.zTr.aKX())))
    {
      this.ftn.setEnabled(true);
      this.ftn.setClickable(true);
      AppMethodBeat.o(69674);
      return true;
    }
    this.ftn.setEnabled(false);
    this.ftn.setClickable(false);
    AppMethodBeat.o(69674);
    return false;
  }
  
  private void aKg()
  {
    AppMethodBeat.i(69672);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_reset_with_new_card", getInput().getBoolean("key_is_reset_with_new_card", false));
    eaQ();
    if ((this.zTp == null) && (!this.zTu))
    {
      doSceneProgress(new y(null, this.zTr.getText(), null));
      AppMethodBeat.o(69672);
      return;
    }
    if (this.zTu)
    {
      localObject = com.tencent.mm.plugin.wallet_core.model.s.ebX().edF();
      if (!bt.isNullOrNil(((al)localObject).field_find_passwd_url))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
        e.p(this, ((al)localObject).field_find_passwd_url, false);
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
    com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.bo(this);
    localBundle.putParcelable("key_bankcard", this.zTp);
    Object localObject = new ElementQuery();
    Iterator localIterator = this.zTo.iterator();
    while (localIterator.hasNext())
    {
      ElementQuery localElementQuery = (ElementQuery)localIterator.next();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "helios:::" + localElementQuery.dca);
      if ((!bt.isNullOrNil(localElementQuery.dca)) && (!bt.isNullOrNil(this.zTp.field_bankcardType)) && (localElementQuery.dca.trim().equals(this.zTp.field_bankcardType.trim()))) {
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
  
  private void eaQ()
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
    com.tencent.mm.plugin.wallet.a.s.dZT();
    this.zNg = com.tencent.mm.plugin.wallet.a.s.dZU().ecZ();
    if ((this.zNg == null) || (this.zNg.size() == 0) || (this.zTv))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[] { Boolean.valueOf(this.zTv) });
      this.zNg = new ArrayList();
      this.fyb.setVisibility(0);
      this.izP.setVisibility(8);
      setMMTitle(2131765247);
      ((TextView)findViewById(2131306745)).setText(getString(2131765599));
      WalletFormView localWalletFormView = this.zTs;
      com.tencent.mm.plugin.wallet.a.s.dZT();
      localWalletFormView.setText(e.aNh(com.tencent.mm.plugin.wallet.a.s.dZU().getTrueName()));
      AppMethodBeat.o(69669);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
    if (com.tencent.mm.wallet_core.a.bo(this) != null) {
      doSceneForceProgress(new y());
    }
    this.fyb.setVisibility(8);
    this.ftn.setVisibility(8);
    findViewById(2131302460).setVisibility(0);
    this.zTq = new a(this);
    this.izP.setAdapter(this.zTq);
    this.zTq.gQr = this.zNg;
    this.zTq.notifyDataSetChanged();
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
    this.izP = ((ListView)findViewById(2131304654));
    this.fyb = ((LinearLayout)findViewById(2131300219));
    this.zTs = ((WalletFormView)findViewById(2131302662));
    this.zTr = ((WalletFormView)findViewById(2131297791));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.zTr);
    if (getInput().getBoolean("key_is_paymanager", false)) {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.zTs);
    }
    for (;;)
    {
      this.zTs.setOnInputValidChangeListener(this);
      this.zTr.setOnInputValidChangeListener(this);
      this.ftn = ((Button)findViewById(2131302852));
      this.ftn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69651);
          com.tencent.mm.plugin.report.service.h.vKh.f(11353, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          WalletForgotPwdUI.a(WalletForgotPwdUI.this);
          AppMethodBeat.o(69651);
        }
      });
      this.zTu = false;
      com.tencent.mm.plugin.wallet.a.s.dZT();
      this.zNg = com.tencent.mm.plugin.wallet.a.s.dZU().ecZ();
      update();
      findViewById(2131302460).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69652);
          e.p(WalletForgotPwdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
          AppMethodBeat.o(69652);
        }
      });
      aKT();
      setEditFocusListener(this.zTr, 0, false, false);
      this.zTr.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69653);
          com.tencent.mm.plugin.report.service.h.vKh.f(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
          paramAnonymousView = WalletForgotPwdUI.this;
          com.tencent.mm.plugin.wallet.a.s.dZT();
          e.d(paramAnonymousView, com.tencent.mm.plugin.wallet.a.s.dZU().getTrueName());
          AppMethodBeat.o(69653);
        }
      });
      this.zTr.getInfoIv().setClickable(true);
      this.zTr.getInfoIv().setImageResource(2131691405);
      this.zTr.getInfoIv().setVisibility(0);
      AppMethodBeat.o(69670);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.zTs);
    }
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69676);
    if ((this.zNg == null) || (this.zNg.size() == 0))
    {
      al localal = com.tencent.mm.plugin.wallet_core.model.s.ebX().edF();
      if ((bt.isNullOrNil(localal.field_find_passwd_url)) && (bt.isNullOrNil(localal.field_forget_passwd_url)))
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
      this.zTr.set3DesValStr(paramIntent);
      aKg();
    }
    AppMethodBeat.o(69678);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69666);
    super.onCreate(paramBundle);
    setMMTitle(2131765640);
    this.zTv = getInput().getBoolean("key_is_force_bind", false);
    if (!this.zTv)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 6));
      setContentViewVisibility(4);
    }
    initView();
    com.tencent.mm.sdk.b.a.ESL.c(this.zTw);
    com.tencent.mm.sdk.b.a.ESL.c(this.zNH);
    AppMethodBeat.o(69666);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69667);
    com.tencent.mm.sdk.b.a.ESL.d(this.zTw);
    com.tencent.mm.sdk.b.a.ESL.d(this.zNH);
    super.onDestroy();
    AppMethodBeat.o(69667);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(69675);
    aKT();
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
      if (bt.isNullOrNil(paramString.nqb))
      {
        this.zTo = paramString.zWy;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
        AppMethodBeat.o(69673);
        return true;
      }
      if (paramString.zWz != null)
      {
        if (paramString.zWz.isError())
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
          com.tencent.mm.ui.base.h.j(this, 2131765036, 2131755906);
          AppMethodBeat.o(69673);
          return true;
        }
        if (this.zNg == null) {}
        for (paramInt1 = 0;; paramInt1 = this.zNg.size())
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "scene case 3 bankcards size %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((this.zNg != null) && (this.zNg.size() != 0)) {
            break;
          }
          eaQ();
          paramn.putString("bank_name", paramString.zWz.szi);
          paramn.putParcelable("elemt_query", paramString.zWz);
          paramn.putString("key_card_id", this.zTr.getText());
          paramn.putBoolean("key_is_reset_with_new_card", true);
          com.tencent.mm.wallet_core.a.k(this, paramn);
          AppMethodBeat.o(69673);
          return true;
        }
      }
      paramn.putString("bank_name", "");
      paramn.putParcelable("elemt_query", new ElementQuery());
      paramn.putString("key_card_id", this.zTr.getText());
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
      if (this.zTq != null) {
        break;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter is null ? %s", new Object[] { Boolean.valueOf(bool) });
    } while (this.zTq == null);
    paramString = null;
    if (com.tencent.mm.plugin.wallet_core.model.s.ecc() != null) {
      paramString = com.tencent.mm.plugin.wallet_core.model.s.ecc().ecZ();
    }
    paramn = com.tencent.mm.wallet_core.a.bo(this);
    ArrayList localArrayList;
    if (paramn != null)
    {
      paramn.fjq();
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
        this.zNg = paramn;
      }
    }
    else
    {
      label510:
      if (this.zNg != null) {
        break label583;
      }
    }
    label583:
    for (paramInt1 = 0;; paramInt1 = this.zNg.size())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter update bankcardsize:  %d", new Object[] { Integer.valueOf(paramInt1) });
      this.zTq.gQr = this.zNg;
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
      this.zNg = localArrayList;
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
    List<Bankcard> gQr;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(69660);
      this.gQr = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(69660);
    }
    
    private Bankcard Rk(int paramInt)
    {
      AppMethodBeat.i(69663);
      if ((paramInt >= 0) && (paramInt <= this.gQr.size() - 1))
      {
        Bankcard localBankcard = (Bankcard)this.gQr.get(paramInt);
        AppMethodBeat.o(69663);
        return localBankcard;
      }
      AppMethodBeat.o(69663);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(69662);
      int i = this.gQr.size();
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
        final Bankcard localBankcard = Rk(paramInt);
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
              paramAnonymousView.aay(2131765276);
              paramAnonymousView.aaB(2131765277).b(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(69658);
                  e.p(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this), "https://kf.qq.com/touch/sappfaq/180704b6Zb2q180704IfqY3u.html?scene_id=kf1&platform=15", true);
                  AppMethodBeat.o(69658);
                }
              });
              paramAnonymousView.aaC(2131755793);
              paramAnonymousView.wX(false);
              paramAnonymousView.fft().show();
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