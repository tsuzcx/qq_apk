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
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  IListener HDJ;
  IListener HJH;
  protected WalletFormView Idp;
  protected WalletFormView Idq;
  private TextView Idr;
  private Bankcard Ids;
  private a Idt;
  private boolean Idu;
  private boolean Idv;
  private Button gxv;
  private int mScene;
  
  public WalletBankcardIdUI()
  {
    AppMethodBeat.i(70735);
    this.Idu = false;
    this.mScene = -1;
    this.HDJ = new WalletBankcardIdUI.1(this);
    this.HJH = new IListener() {};
    AppMethodBeat.o(70735);
  }
  
  private boolean bqg()
  {
    AppMethodBeat.i(70742);
    if (this.Idp.hK(null))
    {
      this.gxv.setEnabled(true);
      this.gxv.setClickable(true);
      AppMethodBeat.o(70742);
      return true;
    }
    this.gxv.setEnabled(false);
    this.gxv.setClickable(false);
    AppMethodBeat.o(70742);
    return false;
  }
  
  protected final void bpv()
  {
    AppMethodBeat.i(70739);
    if (getProcess() == null)
    {
      Log.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
      AppMethodBeat.o(70739);
      return;
    }
    Object localObject = getProcess().dQL.getString("kreq_token");
    int j = getInput().getInt("entry_scene", -1);
    if (getInput().getInt("real_name_verify_mode") == 4) {}
    for (int i = 1; this.Ids != null; i = 0)
    {
      localObject = new y(getPayReqKey(), null, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i);
      ((y)localObject).mBankType = this.Ids.field_bankcardType;
      getInput().putParcelable("key_history_bankcard", this.Ids);
      doSceneProgress((com.tencent.mm.ak.q)localObject);
      AppMethodBeat.o(70739);
      return;
    }
    if (bqg())
    {
      String str = this.Idp.getText();
      doSceneProgress(new y(getPayReqKey(), str, (PayInfo)getInput().getParcelable("key_pay_info"), (String)localObject, this.mScene, j, i));
      AppMethodBeat.o(70739);
      return;
    }
    com.tencent.mm.ui.base.h.n(this, 2131767970, 2131755998);
    AppMethodBeat.o(70739);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496897;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70738);
    this.gxv = ((Button)findViewById(2131305423));
    this.Idp = ((WalletFormView)findViewById(2131298182));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Idp);
    this.Idq = ((WalletFormView)findViewById(2131305216));
    Object localObject1;
    label124:
    Object localObject2;
    if (getInput().getBoolean("key_bind_show_change_card", false))
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this, this.Idq);
      this.Idp.setOnInputValidChangeListener(this);
      this.gxv.setOnClickListener(new WalletBankcardIdUI.3(this));
      localObject1 = getProcess();
      if (localObject1 == null) {
        break label690;
      }
      this.Idv = ((com.tencent.mm.wallet_core.d)localObject1).dQL.getBoolean("key_is_realname_verify_process", false);
      if (!this.Idv) {
        break label698;
      }
      setMMTitle(2131768215);
      label138:
      this.Idr = ((TextView)findViewById(2131302684));
      if ((!com.tencent.mm.plugin.wallet_core.model.t.fQI().fRm()) && (!com.tencent.mm.plugin.wallet_core.model.t.fQI().fRl())) {
        break label708;
      }
      localObject1 = new l(this);
      ((l)localObject1).IgH = new WalletBankcardIdUI.4(this);
      localObject2 = getString(2131767769);
      Object localObject3 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject3).setSpan(localObject1, ((String)localObject2).length() - 6, ((String)localObject2).length(), 33);
      this.Idr.setText((CharSequence)localObject3);
      this.Idr.setMovementMethod(LinkMovementMethod.getInstance());
      label244:
      localObject1 = (FavorPayInfo)getInput().getParcelable("key_favor_pay_info");
      localObject2 = (Orders)getInput().getParcelable("key_orders");
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = e.IcT.a((Orders)localObject2);
        localObject2 = (TextView)findViewById(2131310168);
        if (localObject3 == null) {
          break label754;
        }
        localObject1 = ((d)localObject3).aVI(((d)localObject3).aVL(((FavorPayInfo)localObject1).HXI));
        if (((List)localObject1).size() <= 0) {
          break label745;
        }
        this.Idt = new a(getContext(), (List)localObject1);
        ((TextView)localObject2).setText(2131767767);
        ((TextView)localObject2).setOnClickListener(new WalletBankcardIdUI.5(this));
        ((TextView)localObject2).setVisibility(0);
      }
      label365:
      localObject1 = (RealNameBundle)getInput().getParcelable("realname_verify_process_bundle");
      localObject2 = com.tencent.mm.plugin.wallet_core.model.t.fQI();
      if ((!this.Idv) || (localObject1 == null) || (Util.isNullOrNil(((RealNameBundle)localObject1).HTZ))) {
        break label771;
      }
      this.Idq.setVisibility(0);
      this.Idq.setText(((RealNameBundle)localObject1).HTZ);
      this.Idp.setHint(getString(2131767594));
      this.Idq.setClickable(false);
      this.Idq.setEnabled(false);
      this.Idr.setText(2131767775);
    }
    for (;;)
    {
      if ((getInput().getInt("key_bind_scene") == 18) || (getInput().getInt("key_bind_scene") == 19)) {
        this.Idp.setHint(getString(2131767773));
      }
      g.aAi();
      localObject2 = (String)g.aAh().azQ().get(ar.a.NTz, null);
      if (!Util.isNullOrNil((String)localObject2)) {
        this.Idp.setHint((CharSequence)localObject2);
      }
      this.Ids = ((Bankcard)getInput().getParcelable("key_history_bankcard"));
      if (this.Ids != null)
      {
        this.Idp.setText(this.Ids.HVy);
        this.Idp.a(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(70727);
            if ((WalletBankcardIdUI.this.Idp.bql()) && (!WalletBankcardIdUI.b(WalletBankcardIdUI.this)))
            {
              WalletBankcardIdUI.c(WalletBankcardIdUI.this);
              WalletBankcardIdUI.this.Idp.eIj();
            }
            AppMethodBeat.o(70727);
          }
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
      }
      bqg();
      com.tencent.mm.plugin.wallet_core.utils.f.b(this, getInput(), 2);
      setEditFocusListener(this.Idp, 0, false);
      this.Idp.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70728);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.report.service.h.CyF.a(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
          if ((WalletBankcardIdUI.d(WalletBankcardIdUI.this)) && (this.Idx != null) && (!Util.isNullOrNil(this.Idx.HTZ))) {}
          for (paramAnonymousView = this.Idx.HTZ;; paramAnonymousView = com.tencent.mm.plugin.wallet_core.model.t.fQI().getTrueName())
          {
            com.tencent.mm.wallet_core.ui.f.d(WalletBankcardIdUI.this, paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70728);
            return;
          }
        }
      });
      if (com.tencent.mm.plugin.wallet_core.model.t.fQI().fRs().fQZ())
      {
        this.Idp.getInfoIv().setVisibility(0);
        this.Idp.getInfoIv().setImageResource(2131691739);
      }
      AppMethodBeat.o(70738);
      return;
      com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Idq);
      break;
      label690:
      this.Idv = false;
      break label124;
      label698:
      setMMTitle(2131767776);
      break label138;
      label708:
      this.Idr.setVisibility(0);
      localObject1 = getInput().getString("key_custom_bind_tips");
      if (Util.isNullOrNil((String)localObject1)) {
        break label244;
      }
      this.Idr.setText((CharSequence)localObject1);
      break label244;
      label745:
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label754:
      Log.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
      ((TextView)localObject2).setVisibility(8);
      break label365;
      label771:
      if ((((an)localObject2).fRk()) && (((an)localObject2).getTrueName() != null) && (!Util.isNullOrNil(((an)localObject2).getTrueName().trim())) && (((an)localObject2).fRt()))
      {
        this.Idq.setVisibility(0);
        this.Idq.setText(((an)localObject2).getTrueName());
        this.Idp.setHint(getString(2131767594));
        this.Idq.setClickable(false);
        this.Idq.setEnabled(false);
      }
      else
      {
        this.Idq.setVisibility(8);
        this.Idp.setHint(getString(2131767771));
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
    setMMTitle(2131767776);
    initView();
    EventCenter.instance.addListener(this.HDJ);
    EventCenter.instance.addListener(this.HJH);
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
      localObject1 = getLayoutInflater().inflate(2131496950, null);
      ((ListViewInScrollView)((View)localObject1).findViewById(2131296545)).setAdapter(this.Idt);
      localObject2 = new d.a(this);
      ((d.a)localObject2).aoO(2131767766);
      ((d.a)localObject2).hs((View)localObject1);
      ((d.a)localObject2).f(null);
      ((d.a)localObject2).aoV(2131767734);
      localObject1 = ((d.a)localObject2).hbn();
      AppMethodBeat.o(70740);
      return localObject1;
    }
    if ((this.Idv) && (paramInt == 1000))
    {
      localObject1 = getString(2131767768);
      localObject2 = com.tencent.mm.wallet_core.a.by(this);
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
      localObject1 = com.tencent.mm.ui.base.h.a(this, true, (String)localObject1, "", getString(2131756033), getString(2131755917), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    EventCenter.instance.removeListener(this.HDJ);
    EventCenter.instance.removeListener(this.HJH);
    super.onDestroy();
    AppMethodBeat.o(70737);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70743);
    if (!paramBoolean)
    {
      this.Ids = null;
      getInput().putParcelable("key_history_bankcard", null);
    }
    bqg();
    AppMethodBeat.o(70743);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(70741);
    Log.d("Micromsg.WalletInputCardIDUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    paramString = new Bundle();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof y))
      {
        paramq = (y)paramq;
        paramString.putBoolean("key_need_area", paramq.fPS());
        paramString.putBoolean("key_need_profession", paramq.fPT());
        paramString.putParcelableArray("key_profession_list", paramq.mProfessions);
        if (paramq.HQj == 1) {}
        for (bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_country", bool);
          paramString.putStringArray("key_country_excludes", paramq.HQk);
          if (paramq.HQf == null) {
            break label247;
          }
          if ((!paramq.HQf.HXj) || (!paramq.HQf.isError())) {
            break;
          }
          com.tencent.mm.ui.base.h.n(this, 2131767479, 2131755998);
          AppMethodBeat.o(70741);
          return true;
        }
        paramString.putString("bank_name", paramq.HQf.ynT);
        paramString.putParcelable("elemt_query", paramq.HQf);
        paramString.putString("key_card_id", this.Idp.getText());
        com.tencent.mm.wallet_core.a.l(this, paramString);
        AppMethodBeat.o(70741);
        return true;
        label247:
        paramString.putString("bank_name", "");
        paramString.putParcelable("elemt_query", new ElementQuery());
        paramString.putString("key_card_id", this.Idp.getText());
        com.tencent.mm.wallet_core.a.l(this, paramString);
      }
    }
    while ((paramInt2 != 1) || (!(paramq instanceof y)))
    {
      boolean bool;
      AppMethodBeat.o(70741);
      return false;
    }
    paramString.putString("bank_name", "");
    paramString.putParcelable("elemt_query", new ElementQuery());
    paramString.putString("key_card_id", this.Idp.getText());
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
    List<com.tencent.mm.plugin.wallet.a.t> Idy;
    private Context mContext;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, List<com.tencent.mm.plugin.wallet.a.t> paramList)
    {
      AppMethodBeat.i(70731);
      this.mInflater = null;
      this.Idy = new LinkedList();
      this.mContext = null;
      this.mInflater = LayoutInflater.from(paramContext);
      this.Idy = paramList;
      this.mContext = paramContext;
      AppMethodBeat.o(70731);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70732);
      if (this.Idy == null)
      {
        AppMethodBeat.o(70732);
        return 0;
      }
      int i = this.Idy.size();
      AppMethodBeat.o(70732);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70733);
      Object localObject = this.Idy.get(paramInt);
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
        paramView = this.mInflater.inflate(2131496906, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.jVi = ((ImageView)paramView.findViewById(2131310150));
        paramViewGroup.Cjs = ((TextView)paramView.findViewById(2131310149));
        paramViewGroup.Idz = ((TextView)paramView.findViewById(2131310152));
        paramViewGroup.IdA = ((TextView)paramView.findViewById(2131310151));
        paramView.setTag(paramViewGroup);
        localObject = (com.tencent.mm.plugin.wallet.a.t)getItem(paramInt);
        if (Util.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).AOj)) {
          break label336;
        }
        paramViewGroup.Cjs.setText(((com.tencent.mm.plugin.wallet.a.t)localObject).AOj);
        paramViewGroup.Cjs.setVisibility(0);
        label128:
        if (Util.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).HFm)) {
          break label348;
        }
        paramViewGroup.Idz.setText(((com.tencent.mm.plugin.wallet.a.t)localObject).HFm);
        paramViewGroup.Idz.setVisibility(0);
        label159:
        if (Util.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).HEo)) {
          break label360;
        }
        paramViewGroup.IdA.setText(((com.tencent.mm.plugin.wallet.a.t)localObject).HEo);
        paramViewGroup.IdA.setVisibility(0);
      }
      for (;;)
      {
        String str = ((com.tencent.mm.plugin.wallet.a.t)localObject).HFs;
        Log.v("Micromsg.WalletInputCardIDUI", "bankType:" + ((com.tencent.mm.plugin.wallet.a.t)localObject).HFr + ", logurl:" + str);
        paramViewGroup.jVi.setImageBitmap(null);
        if (!Util.isNullOrNil(str))
        {
          localObject = new c.a();
          com.tencent.mm.av.q.bcW();
          ((c.a)localObject).jbw = null;
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
          ((c.a)localObject).fullPath = com.tencent.mm.plugin.wallet_core.d.b.aKj(str);
          ((c.a)localObject).jbf = true;
          ((c.a)localObject).hZF = true;
          localObject = ((c.a)localObject).bdv();
          com.tencent.mm.av.q.bcV().a(str, paramViewGroup.jVi, (c)localObject);
        }
        AppMethodBeat.o(70734);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label336:
        paramViewGroup.Cjs.setVisibility(8);
        break label128;
        label348:
        paramViewGroup.Idz.setVisibility(8);
        break label159;
        label360:
        paramViewGroup.IdA.setVisibility(8);
      }
    }
    
    final class a
    {
      TextView Cjs;
      TextView IdA;
      TextView Idz;
      ImageView jVi;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI
 * JD-Core Version:    0.7.0.1
 */