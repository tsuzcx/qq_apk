package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.ma;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_ecard.a.f;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletECardBindCardListUI
  extends WalletECardBaseUI
{
  private IListener<ma> GCj;
  private ListView PiO;
  private TextView PiP;
  private List<it> PiQ;
  private c PiR;
  private boolean PiS;
  private d.a PiT;
  private int svv;
  
  public WalletECardBindCardListUI()
  {
    AppMethodBeat.i(71758);
    this.PiQ = new ArrayList();
    this.PiS = true;
    this.PiT = new d.a()
    {
      public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(71748);
        Log.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousBundle });
        if (paramAnonymousInt == -1)
        {
          BindCardOrder localBindCardOrder = (BindCardOrder)paramAnonymousBundle.getParcelable("key_bindcard_value_result");
          if (localBindCardOrder != null)
          {
            it localit = new it();
            localit.fvP = paramAnonymousBundle.getString("key_bind_card_type");
            localit.ROC = localBindCardOrder.OOx;
            localit.OIl = paramAnonymousBundle.getString("key_mobile");
            if ((!Util.isNullOrNil(localit.ROC)) && (!Util.isNullOrNil(localit.fvP)) && (!Util.isNullOrNil(localit.OIl)))
            {
              WalletECardBindCardListUI.this.getNetController().r(new Object[] { localit });
              AppMethodBeat.o(71748);
              return null;
            }
          }
          WalletECardBindCardListUI.c(WalletECardBindCardListUI.this);
        }
        WalletECardBindCardListUI.d(WalletECardBindCardListUI.this);
        AppMethodBeat.o(71748);
        return null;
      }
    };
    this.GCj = new IListener() {};
    AppMethodBeat.o(71758);
  }
  
  private void dlN()
  {
    AppMethodBeat.i(71764);
    Log.i("MicroMsg.WalletECardBindCardListUI", "load Data");
    doSceneForceProgress(new f("WEB_DEBIT", this.svv));
    AppMethodBeat.o(71764);
  }
  
  private boolean h(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(71765);
    com.tencent.mm.wallet_core.b.iie();
    if (com.tencent.mm.wallet_core.b.b(b.a.vGW, true))
    {
      EventCenter.instance.add(this.GCj);
      Log.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:true");
      ab.ny(6, paramBundle.getInt("key_bind_scene"));
      z.azF(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(71765);
      return true;
    }
    Log.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:false");
    AppMethodBeat.o(71765);
    return false;
  }
  
  public final void gMS()
  {
    AppMethodBeat.i(71762);
    Bundle localBundle = new Bundle();
    if (this.svv == 3) {
      localBundle.putInt("key_bind_scene", 18);
    }
    for (;;)
    {
      localBundle.putBoolean("key_need_bind_response", true);
      localBundle.putBoolean("key_is_bind_bankcard", true);
      localBundle.putString("key_pwd1", getInput().getString("key_pwd1"));
      Log.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", new Object[] { Integer.valueOf(this.svv) });
      if (!h(this, localBundle)) {
        break;
      }
      AppMethodBeat.o(71762);
      return;
      localBundle.putInt("key_bind_scene", 19);
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_ecard.b.a.class, localBundle, this.PiT);
    AppMethodBeat.o(71762);
  }
  
  public int getLayoutId()
  {
    return a.g.ecard_bind_card_list;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71760);
    this.PiO = ((ListView)findViewById(a.f.bcard_bind_card_list));
    View localView = LayoutInflater.from(this).inflate(a.g.ecard_bind_card_list_header_layout, this.PiO, false);
    this.PiP = ((TextView)localView.findViewById(a.f.ecard_bind_list_desc_tv));
    this.PiO.addHeaderView(localView, null, false);
    this.PiR = new c((byte)0);
    this.PiO.setAdapter(this.PiR);
    this.PiO.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71747);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        Log.i("MicroMsg.WalletECardBindCardListUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i = paramAnonymousAdapterView.getAdapter().getItemViewType(paramAnonymousInt);
        WalletECardBindCardListUI.a(WalletECardBindCardListUI.this).getClass();
        if (i == 1)
        {
          Log.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", new Object[] { Integer.valueOf(WalletECardBindCardListUI.b(WalletECardBindCardListUI.this)) });
          WalletECardBindCardListUI.this.gMS();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(71747);
          return;
          paramAnonymousAdapterView = (it)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            Log.w("MicroMsg.WalletECardBindCardListUI", "empty item");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(71747);
            return;
          }
          WalletECardBindCardListUI.this.getNetController().r(new Object[] { paramAnonymousAdapterView });
        }
      }
    });
    AppMethodBeat.o(71760);
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71759);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    this.mNetSceneMgr.addSceneEndListener(1988);
    this.svv = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.PhY, 2);
    Log.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", new Object[] { Integer.valueOf(this.svv) });
    setMMTitle("");
    initView();
    this.PiS = true;
    dlN();
    AppMethodBeat.o(71759);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71763);
    super.onDestroy();
    this.mNetSceneMgr.removeSceneEndListener(1988);
    AppMethodBeat.o(71763);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71761);
    if ((paramq instanceof f))
    {
      paramq = (f)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!Util.isNullOrNil(paramq.PiF.TXq)) {
          this.PiP.setText(paramq.PiF.TXq);
        }
        if (paramq.PiF.tqa == 0)
        {
          Log.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", new Object[] { Integer.valueOf(paramq.PiF.TXr.size()) });
          Log.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", new Object[] { paramq.PiF.OMa });
          getInput().putString(com.tencent.mm.plugin.wallet_ecard.a.a.Pip, paramq.PiF.OMa);
          if (paramq.PiF.TXr.size() == 0)
          {
            Log.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", new Object[] { Boolean.valueOf(this.PiS) });
            if (this.PiS) {
              gMS();
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71761);
        return true;
        this.PiQ.clear();
        this.PiQ.addAll(paramq.PiF.TXr);
        this.PiR.notifyDataSetChanged();
        continue;
        if (!com.tencent.mm.plugin.wallet_ecard.a.b.a(this, paramq.PiF.RQv))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(getContext(), new String[] { paramq.PiF.tqb, paramString });
          com.tencent.mm.ui.base.h.c(getContext(), paramString, "", false);
          continue;
          Log.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", new Object[] { paramq });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(getContext(), new String[] { paramString });
          com.tencent.mm.ui.base.h.c(getContext(), paramString, "", false);
        }
      }
    }
    AppMethodBeat.o(71761);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    TextView ror;
    
    public a(View paramView)
    {
      AppMethodBeat.i(71750);
      this.ror = ((TextView)paramView.findViewById(a.f.ecard_bind_card_add_main_title_tv));
      this$1 = (ImageView)paramView.findViewById(a.f.ecard_bind_card_add_main_iv);
      paramView = androidx.core.graphics.drawable.a.p(WalletECardBindCardListUI.this.getDrawable());
      androidx.core.graphics.drawable.a.a(paramView, ColorStateList.valueOf(MMApplicationContext.getResources().getColor(a.c.link_color)));
      WalletECardBindCardListUI.this.setImageDrawable(paramView);
      AppMethodBeat.o(71750);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(View paramView, it paramit);
  }
  
  final class c
    extends BaseAdapter
  {
    public final int HLN = 0;
    public final int PiV = 1;
    
    private c() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(71751);
      int i = WalletECardBindCardListUI.f(WalletECardBindCardListUI.this).size();
      AppMethodBeat.o(71751);
      return i + 1;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(71752);
      if (paramInt < WalletECardBindCardListUI.f(WalletECardBindCardListUI.this).size())
      {
        Object localObject = WalletECardBindCardListUI.f(WalletECardBindCardListUI.this).get(paramInt);
        AppMethodBeat.o(71752);
        return localObject;
      }
      AppMethodBeat.o(71752);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(71753);
      if (paramInt >= WalletECardBindCardListUI.f(WalletECardBindCardListUI.this).size())
      {
        AppMethodBeat.o(71753);
        return 1;
      }
      AppMethodBeat.o(71753);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(71755);
      View localView;
      if (getItemViewType(paramInt) == 1)
      {
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(WalletECardBindCardListUI.this.getContext()).inflate(a.g.ecard_bind_card_list_item_add, paramViewGroup, false);
          localView.setTag(new WalletECardBindCardListUI.a(WalletECardBindCardListUI.this, localView));
        }
        ((WalletECardBindCardListUI.a)localView.getTag()).ror.setText(a.i.ecard_bind_card_add_other_debit_card);
      }
      for (;;)
      {
        AppMethodBeat.o(71755);
        return localView;
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(WalletECardBindCardListUI.this.getContext()).inflate(a.g.ecard_bind_card_list_item, paramViewGroup, false);
          localView.setTag(new WalletECardBindCardListUI.d(WalletECardBindCardListUI.this, localView));
        }
        ((WalletECardBindCardListUI.b)localView.getTag()).a(localView, (it)getItem(paramInt));
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(71754);
      it localit = (it)getItem(paramInt);
      if (localit != null)
      {
        if (localit.ROE)
        {
          AppMethodBeat.o(71754);
          return false;
        }
        AppMethodBeat.o(71754);
        return true;
      }
      boolean bool = super.isEnabled(paramInt);
      AppMethodBeat.o(71754);
      return bool;
    }
  }
  
  final class d
    implements WalletECardBindCardListUI.b
  {
    CdnImageView PiW;
    TextView pPT;
    TextView tuS;
    
    public d(View paramView)
    {
      AppMethodBeat.i(71756);
      this.PiW = ((CdnImageView)paramView.findViewById(a.f.bcard_bind_card_iv));
      this.pPT = ((TextView)paramView.findViewById(a.f.bcard_bind_card_title_tv));
      this.tuS = ((TextView)paramView.findViewById(a.f.bcard_bind_card_subtitle_tv));
      AppMethodBeat.o(71756);
    }
    
    public final void a(View paramView, it paramit)
    {
      AppMethodBeat.i(71757);
      if (paramit != null)
      {
        this.PiW.setRoundCorner(true);
        this.PiW.setUrl(paramit.ROD);
        this.pPT.setText(String.format("%s %s(%s)", new Object[] { paramit.DNV, paramit.tyK, paramit.ROB }));
        if (!Util.isNullOrNil(paramit.ROF)) {
          this.tuS.setText(String.format("%s，%s", new Object[] { paramit.OIl, paramit.ROF }));
        }
        while (paramit.ROE)
        {
          Log.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", new Object[] { paramit.DNV });
          paramView.setEnabled(false);
          this.pPT.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(a.c.light_grey_text_color));
          this.tuS.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(a.c.light_grey_text_color));
          AppMethodBeat.o(71757);
          return;
          this.tuS.setText(String.format("%s", new Object[] { paramit.OIl }));
        }
        paramView.setEnabled(true);
        this.pPT.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(a.c.normal_text_color));
        this.tuS.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(a.c.normal_color));
      }
      AppMethodBeat.o(71757);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI
 * JD-Core Version:    0.7.0.1
 */