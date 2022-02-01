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
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private boolean OBA;
  IListener OBB;
  private List<ElementQuery> OBt;
  private Bankcard OBu;
  private a OBv;
  private WalletFormView OBw;
  private WalletFormView OBx;
  private int OBy;
  private boolean OBz;
  IListener OvC;
  private ArrayList<Bankcard> Ovb;
  private Button jbJ;
  private LinearLayout jmn;
  private ListView kJh;
  
  public WalletForgotPwdUI()
  {
    AppMethodBeat.i(69665);
    this.Ovb = new ArrayList();
    this.OBt = new LinkedList();
    this.OBy = 1;
    this.OBz = false;
    this.OBA = false;
    this.OBB = new WalletForgotPwdUI.7(this);
    this.OvC = new WalletForgotPwdUI.8(this);
    AppMethodBeat.o(69665);
  }
  
  private boolean bAu()
  {
    AppMethodBeat.i(69674);
    if ((this.kJh.getVisibility() == 0) || ((this.OBx.bAz()) && (this.OBw.bAz())))
    {
      this.jbJ.setEnabled(true);
      this.jbJ.setClickable(true);
      AppMethodBeat.o(69674);
      return true;
    }
    this.jbJ.setEnabled(false);
    this.jbJ.setClickable(false);
    AppMethodBeat.o(69674);
    return false;
  }
  
  private void bzH()
  {
    AppMethodBeat.i(69672);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_reset_with_new_card", getInput().getBoolean("key_is_reset_with_new_card", false));
    eEO();
    if ((this.OBu == null) && (!this.OBz))
    {
      doSceneProgress(new z(null, this.OBw.getText(), null));
      AppMethodBeat.o(69672);
      return;
    }
    if (this.OBz)
    {
      localObject = u.gJj().gKZ();
      if (!Util.isNullOrNil(((an)localObject).field_find_passwd_url))
      {
        Log.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
        g.p(this, ((an)localObject).field_find_passwd_url, false);
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
    com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.bF(this);
    localBundle.putParcelable("key_bankcard", this.OBu);
    Object localObject = new ElementQuery();
    Iterator localIterator = this.OBt.iterator();
    while (localIterator.hasNext())
    {
      ElementQuery localElementQuery = (ElementQuery)localIterator.next();
      Log.i("MicroMsg.WalletForgotPwdUI", "helios:::" + localElementQuery.fvP);
      if ((!Util.isNullOrNil(localElementQuery.fvP)) && (!Util.isNullOrNil(this.OBu.field_bankcardType)) && (localElementQuery.fvP.trim().equals(this.OBu.field_bankcardType.trim()))) {
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
  
  private void eEO()
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
    s.gGL();
    this.Ovb = s.gGM().gKk();
    if ((this.Ovb == null) || (this.Ovb.size() == 0) || (this.OBA))
    {
      Log.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[] { Boolean.valueOf(this.OBA) });
      this.Ovb = new ArrayList();
      this.jmn.setVisibility(0);
      this.kJh.setVisibility(8);
      setMMTitle(a.i.wallet_elment_title);
      ((TextView)findViewById(a.f.wallet_forgot_pwd_tips)).setText(getString(a.i.wallet_password_forget_passwd_bind_new_tip));
      WalletFormView localWalletFormView = this.OBx;
      s.gGL();
      localWalletFormView.setText(g.bCr(s.gGM().getTrueName()));
      AppMethodBeat.o(69669);
      return;
    }
    Log.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
    if (com.tencent.mm.wallet_core.a.bF(this) != null) {
      doSceneForceProgress(new z());
    }
    this.jmn.setVisibility(8);
    this.jbJ.setVisibility(8);
    findViewById(a.f.more_button_tip).setVisibility(0);
    this.OBv = new a(this);
    this.kJh.setAdapter(this.OBv);
    this.OBv.lxh = this.Ovb;
    this.OBv.notifyDataSetChanged();
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
    return a.g.wallet_forgot_pwd_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69670);
    this.kJh = ((ListView)findViewById(a.f.settings_lv_bankcard));
    this.jmn = ((LinearLayout)findViewById(a.f.forget_ll));
    this.OBx = ((WalletFormView)findViewById(a.f.name_et));
    this.OBw = ((WalletFormView)findViewById(a.f.card_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.OBw);
    if (getInput().getBoolean("key_is_paymanager", false)) {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.OBx);
    }
    for (;;)
    {
      this.OBx.setOnInputValidChangeListener(this);
      this.OBw.setOnInputValidChangeListener(this);
      this.jbJ = ((Button)findViewById(a.f.next_btn));
      this.jbJ.setOnClickListener(new WalletForgotPwdUI.1(this));
      this.OBz = false;
      s.gGL();
      this.Ovb = s.gGM().gKk();
      update();
      findViewById(a.f.more_button_tip).setOnClickListener(new WalletForgotPwdUI.2(this));
      bAu();
      setEditFocusListener(this.OBw, 0, false, false);
      this.OBw.setOnInfoIvClickListener(new WalletForgotPwdUI.3(this));
      this.OBw.getInfoIv().setClickable(true);
      this.OBw.getInfoIv().setImageResource(a.h.wallet_scan_camera);
      this.OBw.getInfoIv().setVisibility(0);
      AppMethodBeat.o(69670);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.OBx);
    }
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69676);
    if ((this.Ovb == null) || (this.Ovb.size() == 0))
    {
      an localan = u.gJj().gKZ();
      if ((Util.isNullOrNil(localan.field_find_passwd_url)) && (Util.isNullOrNil(localan.field_forget_passwd_url)))
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
      this.OBw.set3DesValStr(paramIntent);
      bzH();
    }
    AppMethodBeat.o(69678);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69666);
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_password_setting_ui_forget_title);
    this.OBA = getInput().getBoolean("key_is_force_bind", false);
    if (!this.OBA)
    {
      doSceneProgress(new ae(null, 6));
      setContentViewVisibility(4);
    }
    initView();
    EventCenter.instance.addListener(this.OBB);
    EventCenter.instance.addListener(this.OvC);
    AppMethodBeat.o(69666);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69667);
    EventCenter.instance.removeListener(this.OBB);
    EventCenter.instance.removeListener(this.OvC);
    super.onDestroy();
    AppMethodBeat.o(69667);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(69675);
    bAu();
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
      if (!(paramq instanceof z)) {
        break label330;
      }
      paramString = (z)paramq;
      paramq = new Bundle();
      if (Util.isNullOrNil(paramString.tmG))
      {
        this.OBt = paramString.OIn;
        Log.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
        AppMethodBeat.o(69673);
        return true;
      }
      if (paramString.OIo != null)
      {
        if (paramString.OIo.isError())
        {
          Log.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
          h.p(this, a.i.wallet_bank_broken, a.i.app_tip);
          AppMethodBeat.o(69673);
          return true;
        }
        if (this.Ovb == null) {}
        for (paramInt1 = 0;; paramInt1 = this.Ovb.size())
        {
          Log.i("MicroMsg.WalletForgotPwdUI", "scene case 3 bankcards size %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((this.Ovb != null) && (this.Ovb.size() != 0)) {
            break;
          }
          eEO();
          paramq.putString("bank_name", paramString.OIo.DNV);
          paramq.putParcelable("elemt_query", paramString.OIo);
          paramq.putString("key_card_id", this.OBw.getText());
          paramq.putBoolean("key_is_reset_with_new_card", true);
          com.tencent.mm.wallet_core.a.l(this, paramq);
          AppMethodBeat.o(69673);
          return true;
        }
      }
      paramq.putString("bank_name", "");
      paramq.putParcelable("elemt_query", new ElementQuery());
      paramq.putString("key_card_id", this.OBw.getText());
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
      } while (!(paramq instanceof ae));
      if (this.OBv != null) {
        break;
      }
      bool = true;
      Log.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter is null ? %s", new Object[] { Boolean.valueOf(bool) });
    } while (this.OBv == null);
    paramString = null;
    if (u.gJo() != null) {
      paramString = u.gJo().gKk();
    }
    paramq = com.tencent.mm.wallet_core.a.bF(this);
    ArrayList localArrayList;
    if (paramq != null)
    {
      paramq.iik();
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
        this.Ovb = paramq;
      }
    }
    else
    {
      label510:
      if (this.Ovb != null) {
        break label583;
      }
    }
    label583:
    for (paramInt1 = 0;; paramInt1 = this.Ovb.size())
    {
      Log.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter update bankcardsize:  %d", new Object[] { Integer.valueOf(paramInt1) });
      this.OBv.lxh = this.Ovb;
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
      this.Ovb = localArrayList;
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
    List<Bankcard> lxh;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(69660);
      this.lxh = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(69660);
    }
    
    private Bankcard amh(int paramInt)
    {
      AppMethodBeat.i(69663);
      if ((paramInt >= 0) && (paramInt <= this.lxh.size() - 1))
      {
        Bankcard localBankcard = (Bankcard)this.lxh.get(paramInt);
        AppMethodBeat.o(69663);
        return localBankcard;
      }
      AppMethodBeat.o(69663);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(69662);
      int i = this.lxh.size();
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
      for (paramView = (WalletFormView)View.inflate(this.context, a.g.wallet_bank_clickable_item, null);; paramView = (WalletFormView)paramView)
      {
        final Bankcard localBankcard = amh(paramInt);
        if (localBankcard != null)
        {
          String str = localBankcard.field_desc;
          paramViewGroup = str;
          if (localBankcard.field_bankcardState == 1) {
            paramViewGroup = str + this.context.getString(a.i.wallet_forget_pwd_expired_suffix);
          }
          paramView.setText(paramViewGroup);
        }
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69659);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$ChoiceBankAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if ((localBankcard != null) && (localBankcard.field_bankcardState == 1))
            {
              paramAnonymousView = new d.a(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this));
              paramAnonymousView.ayg(a.i.wallet_forget_pwd_expired_desc);
              paramAnonymousView.ayj(a.i.wallet_forget_pwd_expired_qa).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(69658);
                  g.p(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this), "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/sappfaq/180704b6Zb2q180704IfqY3u.html?scene_id=kf1&platform=15", true);
                  AppMethodBeat.o(69658);
                }
              });
              paramAnonymousView.ayk(a.i.app_i_known);
              paramAnonymousView.HG(false);
              paramAnonymousView.icu().show();
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