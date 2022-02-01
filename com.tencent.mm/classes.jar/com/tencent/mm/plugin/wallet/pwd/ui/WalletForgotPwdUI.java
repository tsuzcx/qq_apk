package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.vx;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Bankcard MAF;
  IListener VkP;
  private ArrayList<Bankcard> Vkp;
  private List<ElementQuery> VqH;
  private a VqI;
  private WalletFormView VqJ;
  private WalletFormView VqK;
  private int VqL;
  private boolean VqM;
  private boolean VqN;
  IListener VqO;
  private Button lDJ;
  private LinearLayout lPl;
  private ListView nlI;
  
  public WalletForgotPwdUI()
  {
    AppMethodBeat.i(69665);
    this.Vkp = new ArrayList();
    this.VqH = new LinkedList();
    this.VqL = 1;
    this.VqM = false;
    this.VqN = false;
    this.VqO = new IListener(f.hfK) {};
    this.VkP = new WalletForgotPwdUI.8(this, f.hfK);
    AppMethodBeat.o(69665);
  }
  
  private void bYw()
  {
    AppMethodBeat.i(69672);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_reset_with_new_card", getInput().getBoolean("key_is_reset_with_new_card", false));
    fMR();
    if ((this.MAF == null) && (!this.VqM))
    {
      doSceneProgress(new z(null, this.VqJ.getText(), null));
      AppMethodBeat.o(69672);
      return;
    }
    if (this.VqM)
    {
      localObject = u.iix().ijK();
      if (!Util.isNullOrNil(((al)localObject).field_find_passwd_url))
      {
        Log.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
        i.p(this, ((al)localObject).field_find_passwd_url, false);
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
    com.tencent.mm.wallet_core.e locale = com.tencent.mm.wallet_core.a.cm(this);
    localBundle.putParcelable("key_bankcard", this.MAF);
    Object localObject = new ElementQuery();
    Iterator localIterator = this.VqH.iterator();
    while (localIterator.hasNext())
    {
      ElementQuery localElementQuery = (ElementQuery)localIterator.next();
      Log.i("MicroMsg.WalletForgotPwdUI", "helios:::" + localElementQuery.hAk);
      if ((!Util.isNullOrNil(localElementQuery.hAk)) && (!Util.isNullOrNil(this.MAF.field_bankcardType)) && (localElementQuery.hAk.trim().equals(this.MAF.field_bankcardType.trim()))) {
        localObject = localElementQuery;
      }
    }
    for (;;)
    {
      localBundle.putParcelable("elemt_query", (Parcelable)localObject);
      if (locale != null) {
        locale.a(this, 0, localBundle);
      }
      AppMethodBeat.o(69672);
      return;
    }
  }
  
  private boolean bZk()
  {
    AppMethodBeat.i(69674);
    if ((this.nlI.getVisibility() == 0) || ((this.VqK.bZp()) && (this.VqJ.bZp())))
    {
      this.lDJ.setEnabled(true);
      this.lDJ.setClickable(true);
      AppMethodBeat.o(69674);
      return true;
    }
    this.lDJ.setEnabled(false);
    this.lDJ.setClickable(false);
    AppMethodBeat.o(69674);
    return false;
  }
  
  private void fMR()
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
    com.tencent.mm.plugin.wallet.model.p.ifO();
    this.Vkp = com.tencent.mm.plugin.wallet.model.p.ifP().ijB();
    if ((this.Vkp == null) || (this.Vkp.size() == 0) || (this.VqN))
    {
      Log.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[] { Boolean.valueOf(this.VqN) });
      this.Vkp = new ArrayList();
      this.lPl.setVisibility(0);
      this.nlI.setVisibility(8);
      setMMTitle(a.i.wallet_elment_title);
      ((TextView)findViewById(a.f.wallet_forgot_pwd_tips)).setText(getString(a.i.wallet_password_forget_passwd_bind_new_tip));
      WalletFormView localWalletFormView = this.VqK;
      com.tencent.mm.plugin.wallet.model.p.ifO();
      localWalletFormView.setText(i.bEP(com.tencent.mm.plugin.wallet.model.p.ifP().getTrueName()));
      AppMethodBeat.o(69669);
      return;
    }
    Log.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
    if (com.tencent.mm.wallet_core.a.cm(this) != null) {
      doSceneForceProgress(new z());
    }
    this.lPl.setVisibility(8);
    this.lDJ.setVisibility(8);
    findViewById(a.f.more_button_tip).setVisibility(0);
    this.VqI = new a(this);
    this.nlI.setAdapter(this.VqI);
    this.VqI.bMQ = this.Vkp;
    this.VqI.notifyDataSetChanged();
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
    this.nlI = ((ListView)findViewById(a.f.settings_lv_bankcard));
    this.lPl = ((LinearLayout)findViewById(a.f.forget_ll));
    this.VqK = ((WalletFormView)findViewById(a.f.name_et));
    this.VqJ = ((WalletFormView)findViewById(a.f.card_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.VqJ);
    if (getInput().getBoolean("key_is_paymanager", false)) {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.VqK);
    }
    for (;;)
    {
      this.VqK.setOnInputValidChangeListener(this);
      this.VqJ.setOnInputValidChangeListener(this);
      this.lDJ = ((Button)findViewById(a.f.next_btn));
      this.lDJ.setOnClickListener(new WalletForgotPwdUI.1(this));
      this.VqM = false;
      com.tencent.mm.plugin.wallet.model.p.ifO();
      this.Vkp = com.tencent.mm.plugin.wallet.model.p.ifP().ijB();
      update();
      findViewById(a.f.more_button_tip).setOnClickListener(new WalletForgotPwdUI.2(this));
      bZk();
      setEditFocusListener(this.VqJ, 0, false, false);
      this.VqJ.setOnInfoIvClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(315614);
          h.OAn.b(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
          paramAnonymousView = WalletForgotPwdUI.this;
          com.tencent.mm.plugin.wallet.model.p.ifO();
          i.c(paramAnonymousView, com.tencent.mm.plugin.wallet.model.p.ifP().getTrueName());
          AppMethodBeat.o(315614);
        }
      });
      this.VqJ.getInfoIv().setClickable(true);
      this.VqJ.getInfoIv().setImageResource(a.h.wallet_scan_camera);
      this.VqJ.getInfoIv().setVisibility(0);
      AppMethodBeat.o(69670);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.VqK);
    }
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(69676);
    if ((this.Vkp == null) || (this.Vkp.size() == 0))
    {
      al localal = u.iix().ijK();
      if ((Util.isNullOrNil(localal.field_find_passwd_url)) && (Util.isNullOrNil(localal.field_forget_passwd_url)))
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
      this.VqJ.set3DesValStr(paramIntent);
      bYw();
    }
    AppMethodBeat.o(69678);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69666);
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_password_setting_ui_forget_title);
    this.VqN = getInput().getBoolean("key_is_force_bind", false);
    if (!this.VqN)
    {
      doSceneProgress(new ae(null, 6));
      setContentViewVisibility(4);
    }
    initView();
    this.VqO.alive();
    this.VkP.alive();
    AppMethodBeat.o(69666);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69667);
    this.VqO.dead();
    this.VkP.dead();
    super.onDestroy();
    AppMethodBeat.o(69667);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(69675);
    bZk();
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(69673);
    Log.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", new Object[] { Integer.valueOf(paramInt2), paramString, paramp });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramp instanceof z)) {
        break label330;
      }
      paramString = (z)paramp;
      paramp = new Bundle();
      if (Util.isNullOrNil(paramString.wrg))
      {
        this.VqH = paramString.VxZ;
        Log.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
        AppMethodBeat.o(69673);
        return true;
      }
      if (paramString.Vya != null)
      {
        if (paramString.Vya.isError())
        {
          Log.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
          com.tencent.mm.ui.base.k.s(this, a.i.wallet_bank_broken, a.i.app_tip);
          AppMethodBeat.o(69673);
          return true;
        }
        if (this.Vkp == null) {}
        for (paramInt1 = 0;; paramInt1 = this.Vkp.size())
        {
          Log.i("MicroMsg.WalletForgotPwdUI", "scene case 3 bankcards size %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((this.Vkp != null) && (this.Vkp.size() != 0)) {
            break;
          }
          fMR();
          paramp.putString("bank_name", paramString.Vya.JFk);
          paramp.putParcelable("elemt_query", paramString.Vya);
          paramp.putString("key_card_id", this.VqJ.getText());
          paramp.putBoolean("key_is_reset_with_new_card", true);
          com.tencent.mm.wallet_core.a.k(this, paramp);
          AppMethodBeat.o(69673);
          return true;
        }
      }
      paramp.putString("bank_name", "");
      paramp.putParcelable("elemt_query", new ElementQuery());
      paramp.putString("key_card_id", this.VqJ.getText());
      paramp.putBoolean("key_is_reset_with_new_card", true);
      com.tencent.mm.wallet_core.a.k(this, paramp);
    }
    label330:
    boolean bool;
    do
    {
      do
      {
        AppMethodBeat.o(69673);
        return false;
      } while (!(paramp instanceof ae));
      if (this.VqI != null) {
        break;
      }
      bool = true;
      Log.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter is null ? %s", new Object[] { Boolean.valueOf(bool) });
    } while (this.VqI == null);
    paramString = null;
    if (u.iiC() != null) {
      paramString = u.iiC().ijB();
    }
    paramp = com.tencent.mm.wallet_core.a.cm(this);
    ArrayList localArrayList;
    if (paramp != null)
    {
      paramp.jOf();
      paramp = new ArrayList();
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
          paramp.add(localBankcard);
          continue;
          bool = false;
          break;
        }
        if (localBankcard.field_bankcardTag == 2) {
          localArrayList.add(localBankcard);
        }
      }
      label496:
      if (paramp.size() > 0) {
        this.Vkp = paramp;
      }
    }
    else
    {
      label510:
      if (this.Vkp != null) {
        break label583;
      }
    }
    label583:
    for (paramInt1 = 0;; paramInt1 = this.Vkp.size())
    {
      Log.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter update bankcardsize:  %d", new Object[] { Integer.valueOf(paramInt1) });
      this.VqI.bMQ = this.Vkp;
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
      this.Vkp = localArrayList;
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
    List<Bankcard> bMQ;
    private Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(69660);
      this.bMQ = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(69660);
    }
    
    private Bankcard arR(int paramInt)
    {
      AppMethodBeat.i(69663);
      if ((paramInt >= 0) && (paramInt <= this.bMQ.size() - 1))
      {
        Bankcard localBankcard = (Bankcard)this.bMQ.get(paramInt);
        AppMethodBeat.o(69663);
        return localBankcard;
      }
      AppMethodBeat.o(69663);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(69662);
      int i = this.bMQ.size();
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
        final Bankcard localBankcard = arR(paramInt);
        if (localBankcard != null)
        {
          String str = localBankcard.field_desc;
          paramViewGroup = str;
          if (localBankcard.field_bankcardState == 1) {
            paramViewGroup = str + this.context.getString(a.i.wallet_forget_pwd_expired_suffix);
          }
          paramView.setText(paramViewGroup);
        }
        paramView.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(315669);
            if ((localBankcard != null) && (localBankcard.field_bankcardState == 1))
            {
              paramAnonymousView = new e.a(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this));
              paramAnonymousView.aEO(a.i.wallet_forget_pwd_expired_desc);
              paramAnonymousView.aER(a.i.wallet_forget_pwd_expired_qa).c(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(69658);
                  i.p(WalletForgotPwdUI.a.a(WalletForgotPwdUI.a.this), "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/sappfaq/180704b6Zb2q180704IfqY3u.html?scene_id=kf1&platform=15", true);
                  AppMethodBeat.o(69658);
                }
              });
              paramAnonymousView.aES(a.i.app_i_known);
              paramAnonymousView.NC(false);
              paramAnonymousView.jHH().show();
              AppMethodBeat.o(315669);
              return;
            }
            WalletForgotPwdUI.a(WalletForgotPwdUI.this, localBankcard);
            WalletForgotPwdUI.a(WalletForgotPwdUI.this, false);
            WalletForgotPwdUI.a(WalletForgotPwdUI.this);
            AppMethodBeat.o(315669);
          }
        });
        AppMethodBeat.o(69661);
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI
 * JD-Core Version:    0.7.0.1
 */