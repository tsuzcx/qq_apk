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
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.a.aay;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.j;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.g;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBankcardIdUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  IListener OBB;
  protected WalletFormView OVG;
  protected WalletFormView OVH;
  private Bankcard OVI;
  private a OVJ;
  private boolean OVK;
  private boolean OVL;
  IListener OvC;
  private Button jbJ;
  private int mScene;
  private TextView nns;
  
  public WalletBankcardIdUI()
  {
    AppMethodBeat.i(70735);
    this.OVK = false;
    this.mScene = -1;
    this.OvC = new IListener() {};
    this.OBB = new WalletBankcardIdUI.2(this);
    AppMethodBeat.o(70735);
  }
  
  private boolean bAu()
  {
    AppMethodBeat.i(70742);
    if (this.OVG.jf(null))
    {
      this.jbJ.setEnabled(true);
      this.jbJ.setClickable(true);
      AppMethodBeat.o(70742);
      return true;
    }
    this.jbJ.setEnabled(false);
    this.jbJ.setClickable(false);
    AppMethodBeat.o(70742);
    return false;
  }
  
  protected final void bzH()
  {
    AppMethodBeat.i(70739);
    if (getProcess() == null)
    {
      Log.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
      AppMethodBeat.o(70739);
      return;
    }
    Object localObject = getProcess().fKb.getString("kreq_token");
    int j = getInput().getInt("entry_scene", -1);
    if (getInput().getInt("real_name_verify_mode") == 4) {}
    for (int i = 1; this.OVI != null; i = 0)
    {
      localObject = new z(getPayReqKey(), null, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i);
      ((z)localObject).mBankType = this.OVI.field_bankcardType;
      getInput().putParcelable("key_history_bankcard", this.OVI);
      doSceneProgress((com.tencent.mm.an.q)localObject);
      AppMethodBeat.o(70739);
      return;
    }
    if (bAu())
    {
      String str = this.OVG.getText();
      doSceneProgress(new z(getPayReqKey(), str, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i));
      AppMethodBeat.o(70739);
      return;
    }
    com.tencent.mm.ui.base.h.p(this, a.i.wallet_not_exist, a.i.app_tip);
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
    this.jbJ = ((Button)findViewById(a.f.next_btn));
    this.OVG = ((WalletFormView)findViewById(a.f.card_num_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.OVG);
    this.OVH = ((WalletFormView)findViewById(a.f.name_et));
    Object localObject1;
    label124:
    Object localObject2;
    if (getInput().getBoolean("key_bind_show_change_card", false))
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.OVH);
      this.OVG.setOnInputValidChangeListener(this);
      this.jbJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70724);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.report.service.h.IzE.a(11353, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          WalletBankcardIdUI.this.bzH();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70724);
        }
      });
      localObject1 = getProcess();
      if (localObject1 == null) {
        break label690;
      }
      this.OVL = ((d)localObject1).fKb.getBoolean("key_is_realname_verify_process", false);
      if (!this.OVL) {
        break label698;
      }
      setMMTitle(a.i.wallet_real_name_verify_title);
      label138:
      this.nns = ((TextView)findViewById(a.f.input_tip));
      if ((!u.gJo().gJS()) && (!u.gJo().gJR())) {
        break label708;
      }
      localObject1 = new m(this);
      ((m)localObject1).OYN = new m.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70725);
          Log.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
          WalletBankcardIdUI.a(WalletBankcardIdUI.this);
          AppMethodBeat.o(70725);
        }
      };
      localObject2 = getString(a.i.wallet_input_card_first_bind_tips);
      Object localObject3 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject3).setSpan(localObject1, ((String)localObject2).length() - 6, ((String)localObject2).length(), 33);
      this.nns.setText((CharSequence)localObject3);
      this.nns.setMovementMethod(LinkMovementMethod.getInstance());
      label244:
      localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
      localObject2 = (Orders)getInput().getParcelable("key_orders");
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = f.OVk.a((Orders)localObject2);
        localObject2 = (TextView)findViewById(a.f.wallet_card_favor_tips);
        if (localObject3 == null) {
          break label754;
        }
        localObject1 = ((e)localObject3).bhr(((e)localObject3).bhu(((FavorPayInfo)localObject1).OPI));
        if (((List)localObject1).size() <= 0) {
          break label745;
        }
        this.OVJ = new a(getContext(), (List)localObject1);
        ((TextView)localObject2).setText(a.i.wallet_input_card_favor_tips);
        ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70726);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            WalletBankcardIdUI.this.showDialog(1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70726);
          }
        });
        ((TextView)localObject2).setVisibility(0);
      }
      label365:
      localObject1 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      localObject2 = u.gJo();
      if ((!this.OVL) || (localObject1 == null) || (Util.isNullOrNil(((RealNameBundle)localObject1).OMa))) {
        break label771;
      }
      this.OVH.setVisibility(0);
      this.OVH.setText(((RealNameBundle)localObject1).OMa);
      this.OVG.setHint(getString(a.i.wallet_card_num_hint));
      this.OVH.setClickable(false);
      this.OVH.setEnabled(false);
      this.nns.setText(a.i.wallet_input_card_ui_tips2);
    }
    for (;;)
    {
      if ((getInput().getInt("key_bind_scene") == 18) || (getInput().getInt("key_bind_scene") == 19)) {
        this.OVG.setHint(getString(a.i.wallet_input_card_only_debit_card_hint));
      }
      com.tencent.mm.kernel.h.aHH();
      localObject2 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vhz, null);
      if (!Util.isNullOrNil((String)localObject2)) {
        this.OVG.setHint((CharSequence)localObject2);
      }
      this.OVI = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
      if (this.OVI != null)
      {
        this.OVG.setText(this.OVI.ONz);
        this.OVG.a(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(70727);
            if ((WalletBankcardIdUI.this.OVG.bAz()) && (!WalletBankcardIdUI.b(WalletBankcardIdUI.this)))
            {
              WalletBankcardIdUI.c(WalletBankcardIdUI.this);
              WalletBankcardIdUI.this.OVG.fuo();
            }
            AppMethodBeat.o(70727);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
      }
      bAu();
      j.a(this, getInput(), 2);
      setEditFocusListener(this.OVG, 0, false);
      this.OVG.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70728);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.report.service.h.IzE.a(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
          if ((WalletBankcardIdUI.d(WalletBankcardIdUI.this)) && (this.OVN != null) && (!Util.isNullOrNil(this.OVN.OMa))) {}
          for (paramAnonymousView = this.OVN.OMa;; paramAnonymousView = u.gJo().getTrueName())
          {
            g.d(WalletBankcardIdUI.this, paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70728);
            return;
          }
        }
      });
      if (u.gJo().gJY().gJF())
      {
        this.OVG.getInfoIv().setVisibility(0);
        this.OVG.getInfoIv().setImageResource(a.h.wallet_scan_camera);
      }
      AppMethodBeat.o(70738);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.OVH);
      break;
      label690:
      this.OVL = false;
      break label124;
      label698:
      setMMTitle(a.i.wallet_input_card_ui_title);
      break label138;
      label708:
      this.nns.setVisibility(0);
      localObject1 = getInput().getString("key_custom_bind_tips");
      if (Util.isNullOrNil((String)localObject1)) {
        break label244;
      }
      this.nns.setText((CharSequence)localObject1);
      break label244;
      label745:
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label754:
      Log.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label771:
      if ((((com.tencent.mm.plugin.wallet_core.model.ao)localObject2).gJQ()) && (((com.tencent.mm.plugin.wallet_core.model.ao)localObject2).getTrueName() != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.wallet_core.model.ao)localObject2).getTrueName().trim())) && (((com.tencent.mm.plugin.wallet_core.model.ao)localObject2).gJZ()))
      {
        this.OVH.setVisibility(0);
        this.OVH.setText(((com.tencent.mm.plugin.wallet_core.model.ao)localObject2).getTrueName());
        this.OVG.setHint(getString(a.i.wallet_card_num_hint));
        this.OVH.setClickable(false);
        this.OVH.setEnabled(false);
      }
      else
      {
        this.OVH.setVisibility(8);
        this.OVG.setHint(getString(a.i.wallet_input_card_num_hint));
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
    EventCenter.instance.addListener(this.OvC);
    EventCenter.instance.addListener(this.OBB);
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
      ((ListViewInScrollView)((View)localObject1).findViewById(a.f.address_contactlist)).setAdapter(this.OVJ);
      localObject2 = new d.a(this);
      ((d.a)localObject2).ayc(a.i.wallet_input_card_bank_favor_title);
      ((d.a)localObject2).iI((View)localObject1);
      ((d.a)localObject2).f(null);
      ((d.a)localObject2).ayj(a.i.wallet_i_know_it);
      localObject1 = ((d.a)localObject2).icu();
      AppMethodBeat.o(70740);
      return localObject1;
    }
    if ((this.OVL) && (paramInt == 1000))
    {
      localObject1 = getString(a.i.wallet_input_card_finish_confirm);
      localObject2 = com.tencent.mm.wallet_core.a.bF(this);
      if (localObject2 == null) {
        break label201;
      }
    }
    label201:
    for (paramInt = ((d)localObject2).a(this, 1);; paramInt = -1)
    {
      if (paramInt != -1) {
        localObject1 = getString(paramInt);
      }
      localObject1 = com.tencent.mm.ui.base.h.a(this, true, (String)localObject1, "", getString(a.i.app_yes), getString(a.i.app_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(70729);
          ((com.tencent.mm.plugin.wallet_core.id_verify.a)WalletBankcardIdUI.this.getProcess()).h(WalletBankcardIdUI.this, 0);
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
    EventCenter.instance.removeListener(this.OvC);
    EventCenter.instance.removeListener(this.OBB);
    super.onDestroy();
    AppMethodBeat.o(70737);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70743);
    if (!paramBoolean)
    {
      this.OVI = null;
      getInput().putParcelable("key_history_bankcard", null);
    }
    bAu();
    AppMethodBeat.o(70743);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(70741);
    Log.d("Micromsg.WalletInputCardIDUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    paramString = new Bundle();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof z))
      {
        paramq = (z)paramq;
        paramString.putBoolean("key_need_area", paramq.gIy());
        paramString.putBoolean("key_need_profession", paramq.gIz());
        paramString.putParcelableArray("key_profession_list", paramq.mProfessions);
        if (paramq.OIs == 1) {}
        for (bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_country", bool);
          paramString.putStringArray("key_country_excludes", paramq.OIt);
          if (paramq.OIo == null) {
            break label247;
          }
          if ((!paramq.OIo.OPj) || (!paramq.OIo.isError())) {
            break;
          }
          com.tencent.mm.ui.base.h.p(this, a.i.wallet_bank_broken, a.i.app_tip);
          AppMethodBeat.o(70741);
          return true;
        }
        paramString.putString("bank_name", paramq.OIo.DNV);
        paramString.putParcelable("elemt_query", paramq.OIo);
        paramString.putString("key_card_id", this.OVG.getText());
        com.tencent.mm.wallet_core.a.l(this, paramString);
        AppMethodBeat.o(70741);
        return true;
        label247:
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.OVG.getText());
        com.tencent.mm.wallet_core.a.l(this, paramString);
      }
    }
    while ((paramInt2 != 1) || (!(paramq instanceof z)))
    {
      boolean bool;
      AppMethodBeat.o(70741);
      return false;
    }
    paramString.putString("bank_name", "");
    paramString.putParcelable("elemt_query", new ElementQuery());
    paramString.putString("key_card_id", this.OVG.getText());
    com.tencent.mm.wallet_core.a.l(this, paramString);
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
    List<t> OVO;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, List<t> paramList)
    {
      AppMethodBeat.i(70731);
      this.mInflater = null;
      this.OVO = new LinkedList();
      this.mContext = null;
      this.mInflater = LayoutInflater.from(paramContext);
      this.OVO = paramList;
      this.mContext = paramContext;
      AppMethodBeat.o(70731);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70732);
      if (this.OVO == null)
      {
        AppMethodBeat.o(70732);
        return 0;
      }
      int i = this.OVO.size();
      AppMethodBeat.o(70732);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70733);
      Object localObject = this.OVO.get(paramInt);
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
        paramViewGroup.mMv = ((ImageView)paramView.findViewById(a.f.wallet_bankfavor_logo));
        paramViewGroup.Igl = ((TextView)paramView.findViewById(a.f.wallet_bankfavor_bankname));
        paramViewGroup.OVP = ((TextView)paramView.findViewById(a.f.wallet_bankfavor_name));
        paramViewGroup.OVQ = ((TextView)paramView.findViewById(a.f.wallet_bankfavor_manual));
        paramView.setTag(paramViewGroup);
        localObject = (t)getItem(paramInt);
        if (Util.isNullOrNil(((t)localObject).GHx)) {
          break label341;
        }
        paramViewGroup.Igl.setText(((t)localObject).GHx);
        paramViewGroup.Igl.setVisibility(0);
        label133:
        if (Util.isNullOrNil(((t)localObject).Oxf)) {
          break label353;
        }
        paramViewGroup.OVP.setText(((t)localObject).Oxf);
        paramViewGroup.OVP.setVisibility(0);
        label164:
        if (Util.isNullOrNil(((t)localObject).Owh)) {
          break label365;
        }
        paramViewGroup.OVQ.setText(((t)localObject).Owh);
        paramViewGroup.OVQ.setVisibility(0);
      }
      for (;;)
      {
        String str = ((t)localObject).Oxl;
        Log.v("Micromsg.WalletInputCardIDUI", "bankType:" + ((t)localObject).Oxk + ", logurl:" + str);
        paramViewGroup.mMv.setImageBitmap(null);
        if (!Util.isNullOrNil(str))
        {
          localObject = new c.a();
          com.tencent.mm.ay.q.bmm();
          ((c.a)localObject).lRV = null;
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
          ((c.a)localObject).fullPath = com.tencent.mm.plugin.wallet_core.d.b.aUH(str);
          ((c.a)localObject).lRD = true;
          ((c.a)localObject).kOl = true;
          localObject = ((c.a)localObject).bmL();
          com.tencent.mm.ay.q.bml().a(str, paramViewGroup.mMv, (c)localObject);
        }
        AppMethodBeat.o(70734);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label341:
        paramViewGroup.Igl.setVisibility(8);
        break label133;
        label353:
        paramViewGroup.OVP.setVisibility(8);
        break label164;
        label365:
        paramViewGroup.OVQ.setVisibility(8);
      }
    }
    
    final class a
    {
      TextView Igl;
      TextView OVP;
      TextView OVQ;
      ImageView mMv;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI
 * JD-Core Version:    0.7.0.1
 */