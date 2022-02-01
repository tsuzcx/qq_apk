package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
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
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.vx;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.i;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBankcardIdUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  protected WalletFormView VLV;
  protected WalletFormView VLW;
  private TextView VLX;
  private Bankcard VLY;
  private a VLZ;
  private boolean VMa;
  private boolean VMb;
  IListener VkP;
  IListener VqO;
  private Button lDJ;
  private int mScene;
  
  public WalletBankcardIdUI()
  {
    AppMethodBeat.i(70735);
    this.VMa = false;
    this.mScene = -1;
    this.VkP = new WalletBankcardIdUI.1(this, com.tencent.mm.app.f.hfK);
    this.VqO = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(70735);
  }
  
  private boolean bZk()
  {
    AppMethodBeat.i(70742);
    if (this.VLV.mJ(null))
    {
      this.lDJ.setEnabled(true);
      this.lDJ.setClickable(true);
      AppMethodBeat.o(70742);
      return true;
    }
    this.lDJ.setEnabled(false);
    this.lDJ.setClickable(false);
    AppMethodBeat.o(70742);
    return false;
  }
  
  protected final void bYw()
  {
    AppMethodBeat.i(70739);
    if (getProcess() == null)
    {
      Log.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
      AppMethodBeat.o(70739);
      return;
    }
    Object localObject = getProcess().hPH.getString("kreq_token");
    int j = getInput().getInt("entry_scene", -1);
    if (getInput().getInt("real_name_verify_mode") == 4) {}
    for (int i = 1; this.VLY != null; i = 0)
    {
      localObject = new z(getPayReqKey(), null, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i);
      ((z)localObject).mBankType = this.VLY.field_bankcardType;
      getInput().putParcelable("key_history_bankcard", this.VLY);
      doSceneProgress((p)localObject);
      AppMethodBeat.o(70739);
      return;
    }
    if (bZk())
    {
      String str = this.VLV.getText();
      doSceneProgress(new z(getPayReqKey(), str, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i));
      AppMethodBeat.o(70739);
      return;
    }
    k.s(this, a.i.wallet_not_exist, a.i.app_tip);
    AppMethodBeat.o(70739);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_bankcard_id_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70738);
    this.lDJ = ((Button)findViewById(a.f.next_btn));
    this.VLV = ((WalletFormView)findViewById(a.f.card_num_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.VLV);
    this.VLW = ((WalletFormView)findViewById(a.f.name_et));
    Object localObject1;
    label124:
    Object localObject2;
    if (getInput().getBoolean("key_bind_show_change_card", false))
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.VLW);
      this.VLV.setOnInputValidChangeListener(this);
      this.lDJ.setOnClickListener(new WalletBankcardIdUI.2(this));
      localObject1 = getProcess();
      if (localObject1 == null) {
        break label694;
      }
      this.VMb = ((e)localObject1).hPH.getBoolean("key_is_realname_verify_process", false);
      if (!this.VMb) {
        break label702;
      }
      setMMTitle(a.i.wallet_real_name_verify_title);
      label138:
      this.VLX = ((TextView)findViewById(a.f.input_tip));
      if ((!u.iiC().ijh()) && (!u.iiC().ijg())) {
        break label712;
      }
      localObject1 = new n(this);
      ((n)localObject1).VPb = new WalletBankcardIdUI.3(this);
      localObject2 = getString(a.i.wallet_input_card_first_bind_tips);
      Object localObject3 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject3).setSpan(localObject1, ((String)localObject2).length() - 6, ((String)localObject2).length(), 33);
      this.VLX.setText((CharSequence)localObject3);
      this.VLX.setMovementMethod(LinkMovementMethod.getInstance());
      label244:
      localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
      localObject2 = (Orders)getInput().getParcelable("key_orders");
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = g.VLx.a((Orders)localObject2);
        localObject2 = (TextView)findViewById(a.f.wallet_card_favor_tips);
        if (localObject3 == null) {
          break label758;
        }
        localObject1 = ((f)localObject3).bha(((f)localObject3).bhd(((FavorPayInfo)localObject1).VFC));
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label749;
        }
        this.VLZ = new a(getContext(), (List)localObject1);
        ((TextView)localObject2).setText(a.i.wallet_input_card_favor_tips);
        ((TextView)localObject2).setOnClickListener(new WalletBankcardIdUI.4(this));
        ((TextView)localObject2).setVisibility(0);
      }
      label369:
      localObject1 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      localObject2 = u.iiC();
      if ((!this.VMb) || (localObject1 == null) || (Util.isNullOrNil(((RealNameBundle)localObject1).VBL))) {
        break label775;
      }
      this.VLW.setVisibility(0);
      this.VLW.setText(((RealNameBundle)localObject1).VBL);
      this.VLV.setHint(getString(a.i.wallet_card_num_hint));
      this.VLW.setClickable(false);
      this.VLW.setEnabled(false);
      this.VLX.setText(a.i.wallet_input_card_ui_tips2);
    }
    for (;;)
    {
      if ((getInput().getInt("key_bind_scene") == 18) || (getInput().getInt("key_bind_scene") == 19)) {
        this.VLV.setHint(getString(a.i.wallet_input_card_only_debit_card_hint));
      }
      com.tencent.mm.kernel.h.baF();
      localObject2 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIT, null);
      if (!Util.isNullOrNil((String)localObject2)) {
        this.VLV.setHint((CharSequence)localObject2);
      }
      this.VLY = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
      if (this.VLY != null)
      {
        this.VLV.setText(this.VLY.VDk);
        this.VLV.a(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(70727);
            if ((WalletBankcardIdUI.this.VLV.bZp()) && (!WalletBankcardIdUI.b(WalletBankcardIdUI.this)))
            {
              WalletBankcardIdUI.c(WalletBankcardIdUI.this);
              WalletBankcardIdUI.this.VLV.gGd();
            }
            AppMethodBeat.o(70727);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
      }
      bZk();
      m.a(this, getInput(), 2);
      setEditFocusListener(this.VLV, 0, false);
      this.VLV.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70728);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.plugin.report.service.h.OAn.b(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
          if ((WalletBankcardIdUI.d(WalletBankcardIdUI.this)) && (this.VMd != null) && (!Util.isNullOrNil(this.VMd.VBL))) {}
          for (paramAnonymousView = this.VMd.VBL;; paramAnonymousView = u.iiC().getTrueName())
          {
            i.c(WalletBankcardIdUI.this, paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70728);
            return;
          }
        }
      });
      if (u.iiC().ijp().iiT())
      {
        this.VLV.getInfoIv().setVisibility(0);
        this.VLV.getInfoIv().setImageResource(a.h.wallet_scan_camera);
      }
      AppMethodBeat.o(70738);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.VLW);
      break;
      label694:
      this.VMb = false;
      break label124;
      label702:
      setMMTitle(a.i.wallet_input_card_ui_title);
      break label138;
      label712:
      this.VLX.setVisibility(0);
      localObject1 = getInput().getString("key_custom_bind_tips");
      if (Util.isNullOrNil((String)localObject1)) {
        break label244;
      }
      this.VLX.setText((CharSequence)localObject1);
      break label244;
      label749:
      ((TextView)localObject2).setVisibility(8);
      break label369;
      label758:
      Log.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
      ((TextView)localObject2).setVisibility(8);
      break label369;
      label775:
      if ((((am)localObject2).ijf()) && (((am)localObject2).getTrueName() != null) && (!Util.isNullOrNil(((am)localObject2).getTrueName().trim())) && (((am)localObject2).ijq()))
      {
        this.VLW.setVisibility(0);
        this.VLW.setText(((am)localObject2).getTrueName());
        this.VLV.setHint(getString(a.i.wallet_card_num_hint));
        this.VLW.setClickable(false);
        this.VLW.setEnabled(false);
      }
      else
      {
        this.VLW.setVisibility(8);
        this.VLV.setHint(getString(a.i.wallet_input_card_num_hint));
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
    setMMTitle(a.i.wallet_input_card_ui_title);
    initView();
    this.VkP.alive();
    this.VqO.alive();
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
      localObject1 = getLayoutInflater().inflate(a.g.wallet_list_dialog, null);
      ((ListViewInScrollView)((View)localObject1).findViewById(a.f.address_contactlist)).setAdapter(this.VLZ);
      localObject2 = new e.a(this);
      ((e.a)localObject2).aEK(a.i.wallet_input_card_bank_favor_title);
      ((e.a)localObject2).md((View)localObject1);
      ((e.a)localObject2).e(null);
      ((e.a)localObject2).aER(a.i.wallet_i_know_it);
      localObject1 = ((e.a)localObject2).jHH();
      AppMethodBeat.o(70740);
      return localObject1;
    }
    if ((this.VMb) && (paramInt == 1000))
    {
      localObject1 = getString(a.i.wallet_input_card_finish_confirm);
      localObject2 = com.tencent.mm.wallet_core.a.cm(this);
      if (localObject2 == null) {
        break label201;
      }
    }
    label201:
    for (paramInt = ((e)localObject2).a(this, 1);; paramInt = -1)
    {
      if (paramInt != -1) {
        localObject1 = getString(paramInt);
      }
      localObject1 = k.a(this, true, (String)localObject1, "", getString(a.i.app_yes), getString(a.i.app_no), new WalletBankcardIdUI.7(this), new WalletBankcardIdUI.8(this));
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
    this.VkP.dead();
    this.VqO.dead();
    super.onDestroy();
    AppMethodBeat.o(70737);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70743);
    if (!paramBoolean)
    {
      this.VLY = null;
      getInput().putParcelable("key_history_bankcard", null);
    }
    bZk();
    AppMethodBeat.o(70743);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(70741);
    Log.d("Micromsg.WalletInputCardIDUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    paramString = new Bundle();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramp instanceof z))
      {
        paramp = (z)paramp;
        paramString.putBoolean("key_need_area", paramp.ihM());
        paramString.putBoolean("key_need_profession", paramp.ihN());
        paramString.putParcelableArray("key_profession_list", paramp.mProfessions);
        if (paramp.Vye == 1) {}
        for (bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_country", bool);
          paramString.putStringArray("key_country_excludes", paramp.Vyf);
          if (paramp.Vya == null) {
            break label247;
          }
          if ((!paramp.Vya.VFd) || (!paramp.Vya.isError())) {
            break;
          }
          k.s(this, a.i.wallet_bank_broken, a.i.app_tip);
          AppMethodBeat.o(70741);
          return true;
        }
        paramString.putString("bank_name", paramp.Vya.JFk);
        paramString.putParcelable("elemt_query", paramp.Vya);
        paramString.putString("key_card_id", this.VLV.getText());
        com.tencent.mm.wallet_core.a.k(this, paramString);
        AppMethodBeat.o(70741);
        return true;
        label247:
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.VLV.getText());
        com.tencent.mm.wallet_core.a.k(this, paramString);
      }
    }
    while ((paramInt2 != 1) || (!(paramp instanceof z)))
    {
      boolean bool;
      AppMethodBeat.o(70741);
      return false;
    }
    paramString.putString("bank_name", "");
    paramString.putParcelable("elemt_query", new ElementQuery());
    paramString.putString("key_card_id", this.VLV.getText());
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
    List<com.tencent.mm.plugin.wallet.model.q> VMe;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, List<com.tencent.mm.plugin.wallet.model.q> paramList)
    {
      AppMethodBeat.i(70731);
      this.mInflater = null;
      this.VMe = new LinkedList();
      this.mContext = null;
      this.mInflater = LayoutInflater.from(paramContext);
      this.VMe = paramList;
      this.mContext = paramContext;
      AppMethodBeat.o(70731);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70732);
      if (this.VMe == null)
      {
        AppMethodBeat.o(70732);
        return 0;
      }
      int i = this.VMe.size();
      AppMethodBeat.o(70732);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70733);
      Object localObject = this.VMe.get(paramInt);
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
        paramView = this.mInflater.inflate(a.g.wallet_bankfavor_item, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.pJd = ((ImageView)paramView.findViewById(a.f.wallet_bankfavor_logo));
        paramViewGroup.OcK = ((TextView)paramView.findViewById(a.f.wallet_bankfavor_bankname));
        paramViewGroup.VMf = ((TextView)paramView.findViewById(a.f.wallet_bankfavor_name));
        paramViewGroup.VMg = ((TextView)paramView.findViewById(a.f.wallet_bankfavor_manual));
        paramView.setTag(paramViewGroup);
        localObject = (com.tencent.mm.plugin.wallet.model.q)getItem(paramInt);
        if (Util.isNullOrNil(((com.tencent.mm.plugin.wallet.model.q)localObject).MEo)) {
          break label339;
        }
        paramViewGroup.OcK.setText(((com.tencent.mm.plugin.wallet.model.q)localObject).MEo);
        paramViewGroup.OcK.setVisibility(0);
        label133:
        if (Util.isNullOrNil(((com.tencent.mm.plugin.wallet.model.q)localObject).Vmq)) {
          break label351;
        }
        paramViewGroup.VMf.setText(((com.tencent.mm.plugin.wallet.model.q)localObject).Vmq);
        paramViewGroup.VMf.setVisibility(0);
        label164:
        if (Util.isNullOrNil(((com.tencent.mm.plugin.wallet.model.q)localObject).Vls)) {
          break label363;
        }
        paramViewGroup.VMg.setText(((com.tencent.mm.plugin.wallet.model.q)localObject).Vls);
        paramViewGroup.VMg.setVisibility(0);
      }
      for (;;)
      {
        String str = ((com.tencent.mm.plugin.wallet.model.q)localObject).Vmw;
        Log.v("Micromsg.WalletInputCardIDUI", "bankType:" + ((com.tencent.mm.plugin.wallet.model.q)localObject).Vmv + ", logurl:" + str);
        paramViewGroup.pJd.setImageBitmap(null);
        if (!Util.isNullOrNil(str))
        {
          localObject = new c.a();
          ((c.a)localObject).oKH = r.bKf();
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
          ((c.a)localObject).fullPath = com.tencent.mm.plugin.wallet_core.d.b.aRP(str);
          ((c.a)localObject).oKp = true;
          ((c.a)localObject).nqa = true;
          localObject = ((c.a)localObject).bKx();
          r.bKe().a(str, paramViewGroup.pJd, (c)localObject);
        }
        AppMethodBeat.o(70734);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label339:
        paramViewGroup.OcK.setVisibility(8);
        break label133;
        label351:
        paramViewGroup.VMf.setVisibility(8);
        break label164;
        label363:
        paramViewGroup.VMg.setVisibility(8);
      }
    }
    
    final class a
    {
      TextView OcK;
      TextView VMf;
      TextView VMg;
      ImageView pJd;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI
 * JD-Core Version:    0.7.0.1
 */