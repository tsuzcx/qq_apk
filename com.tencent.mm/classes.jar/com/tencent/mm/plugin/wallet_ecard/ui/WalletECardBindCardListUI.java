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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_ecard.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.d.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletECardBindCardListUI
  extends WalletECardBaseUI
{
  private ListView Dpo;
  private TextView Dpp;
  private List<ir> Dpq;
  private c Dpr;
  private boolean Dps;
  private d.a Dpt;
  private int nWh;
  private c<ks> wxJ;
  
  public WalletECardBindCardListUI()
  {
    AppMethodBeat.i(71758);
    this.Dpq = new ArrayList();
    this.Dps = true;
    this.Dpt = new d.a()
    {
      public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(71748);
        ad.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousBundle });
        if (paramAnonymousInt == -1)
        {
          BindCardOrder localBindCardOrder = (BindCardOrder)paramAnonymousBundle.getParcelable("key_bindcard_value_result");
          if (localBindCardOrder != null)
          {
            ir localir = new ir();
            localir.dkR = paramAnonymousBundle.getString("key_bind_card_type");
            localir.FBE = localBindCardOrder.CVz;
            localir.CPf = paramAnonymousBundle.getString("key_mobile");
            if ((!bt.isNullOrNil(localir.FBE)) && (!bt.isNullOrNil(localir.dkR)) && (!bt.isNullOrNil(localir.CPf)))
            {
              WalletECardBindCardListUI.this.getNetController().s(new Object[] { localir });
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
    this.wxJ = new c() {};
    AppMethodBeat.o(71758);
  }
  
  private void aUU()
  {
    AppMethodBeat.i(71764);
    ad.i("MicroMsg.WalletECardBindCardListUI", "load Data");
    doSceneForceProgress(new f("WEB_DEBIT", this.nWh));
    AppMethodBeat.o(71764);
  }
  
  private boolean g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(71765);
    com.tencent.mm.wallet_core.b.fQJ();
    if (com.tencent.mm.wallet_core.b.b(b.a.qzx, false))
    {
      com.tencent.mm.sdk.b.a.IbL.b(this.wxJ);
      ad.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:true");
      ab.kB(6, paramBundle.getInt("key_bind_scene"));
      z.agm(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(71765);
      return true;
    }
    ad.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:false");
    AppMethodBeat.o(71765);
    return false;
  }
  
  public final void eIX()
  {
    AppMethodBeat.i(71762);
    Bundle localBundle = new Bundle();
    if (this.nWh == 3) {
      localBundle.putInt("key_bind_scene", 18);
    }
    for (;;)
    {
      localBundle.putBoolean("key_need_bind_response", true);
      localBundle.putBoolean("key_is_bind_bankcard", true);
      localBundle.putString("key_pwd1", getInput().getString("key_pwd1"));
      ad.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", new Object[] { Integer.valueOf(this.nWh) });
      if (!g(this, localBundle)) {
        break;
      }
      AppMethodBeat.o(71762);
      return;
      localBundle.putInt("key_bind_scene", 19);
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_ecard.b.a.class, localBundle, this.Dpt);
    AppMethodBeat.o(71762);
  }
  
  public int getLayoutId()
  {
    return 2131493727;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71760);
    this.Dpo = ((ListView)findViewById(2131297192));
    View localView = LayoutInflater.from(this).inflate(2131493728, this.Dpo, false);
    this.Dpp = ((TextView)localView.findViewById(2131299245));
    this.Dpo.addHeaderView(localView, null, false);
    this.Dpr = new c((byte)0);
    this.Dpo.setAdapter(this.Dpr);
    this.Dpo.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71747);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        ad.i("MicroMsg.WalletECardBindCardListUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i = paramAnonymousAdapterView.getAdapter().getItemViewType(paramAnonymousInt);
        WalletECardBindCardListUI.a(WalletECardBindCardListUI.this).getClass();
        if (i == 1)
        {
          ad.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", new Object[] { Integer.valueOf(WalletECardBindCardListUI.b(WalletECardBindCardListUI.this)) });
          WalletECardBindCardListUI.this.eIX();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(71747);
          return;
          paramAnonymousAdapterView = (ir)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            ad.w("MicroMsg.WalletECardBindCardListUI", "empty item");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(71747);
            return;
          }
          WalletECardBindCardListUI.this.getNetController().s(new Object[] { paramAnonymousAdapterView });
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
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    this.mNetSceneMgr.addSceneEndListener(1988);
    this.nWh = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Doy, 2);
    ad.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", new Object[] { Integer.valueOf(this.nWh) });
    setMMTitle("");
    initView();
    this.Dps = true;
    aUU();
    AppMethodBeat.o(71759);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71763);
    super.onDestroy();
    this.mNetSceneMgr.removeSceneEndListener(1988);
    AppMethodBeat.o(71763);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71761);
    if ((paramn instanceof f))
    {
      paramn = (f)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!bt.isNullOrNil(paramn.Dpf.Hhk)) {
          this.Dpp.setText(paramn.Dpf.Hhk);
        }
        if (paramn.Dpf.ozR == 0)
        {
          ad.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", new Object[] { Integer.valueOf(paramn.Dpf.Hhl.size()) });
          ad.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", new Object[] { paramn.Dpf.CTa });
          getInput().putString(com.tencent.mm.plugin.wallet_ecard.a.a.DoP, paramn.Dpf.CTa);
          if (paramn.Dpf.Hhl.size() == 0)
          {
            ad.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", new Object[] { Boolean.valueOf(this.Dps) });
            if (this.Dps) {
              eIX();
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71761);
        return true;
        this.Dpq.clear();
        this.Dpq.addAll(paramn.Dpf.Hhl);
        this.Dpr.notifyDataSetChanged();
        continue;
        if (!com.tencent.mm.plugin.wallet_ecard.a.b.a(this, paramn.Dpf.FDr))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(getContext(), new String[] { paramn.Dpf.ozS, paramString });
          h.c(getContext(), paramString, "", false);
          continue;
          ad.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", new Object[] { paramn });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(getContext(), new String[] { paramString });
          h.c(getContext(), paramString, "", false);
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
    TextView mTC;
    
    public a(View paramView)
    {
      AppMethodBeat.i(71750);
      this.mTC = ((TextView)paramView.findViewById(2131299244));
      this$1 = (ImageView)paramView.findViewById(2131299243);
      paramView = android.support.v4.graphics.drawable.a.i(WalletECardBindCardListUI.this.getDrawable());
      android.support.v4.graphics.drawable.a.a(paramView, ColorStateList.valueOf(aj.getResources().getColor(2131100547)));
      WalletECardBindCardListUI.this.setImageDrawable(paramView);
      AppMethodBeat.o(71750);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(View paramView, ir paramir);
  }
  
  final class c
    extends BaseAdapter
  {
    public final int Dpv = 1;
    public final int xzi = 0;
    
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
          localView = LayoutInflater.from(WalletECardBindCardListUI.this.getContext()).inflate(2131493730, paramViewGroup, false);
          localView.setTag(new WalletECardBindCardListUI.a(WalletECardBindCardListUI.this, localView));
        }
        ((WalletECardBindCardListUI.a)localView.getTag()).mTC.setText(2131758158);
      }
      for (;;)
      {
        AppMethodBeat.o(71755);
        return localView;
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(WalletECardBindCardListUI.this.getContext()).inflate(2131493729, paramViewGroup, false);
          localView.setTag(new WalletECardBindCardListUI.d(WalletECardBindCardListUI.this, localView));
        }
        ((WalletECardBindCardListUI.b)localView.getTag()).a(localView, (ir)getItem(paramInt));
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(71754);
      ir localir = (ir)getItem(paramInt);
      if (localir != null)
      {
        if (localir.FBG)
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
    CdnImageView Dpw;
    TextView lCL;
    TextView oEG;
    
    public d(View paramView)
    {
      AppMethodBeat.i(71756);
      this.Dpw = ((CdnImageView)paramView.findViewById(2131297191));
      this.lCL = ((TextView)paramView.findViewById(2131297194));
      this.oEG = ((TextView)paramView.findViewById(2131297193));
      AppMethodBeat.o(71756);
    }
    
    public final void a(View paramView, ir paramir)
    {
      AppMethodBeat.i(71757);
      if (paramir != null)
      {
        this.Dpw.setRoundCorner(true);
        this.Dpw.setUrl(paramir.FBF);
        this.lCL.setText(String.format("%s %s(%s)", new Object[] { paramir.uJF, paramir.oIx, paramir.FBD }));
        if (!bt.isNullOrNil(paramir.FBH)) {
          this.oEG.setText(String.format("%s，%s", new Object[] { paramir.CPf, paramir.FBH }));
        }
        while (paramir.FBG)
        {
          ad.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", new Object[] { paramir.uJF });
          paramView.setEnabled(false);
          this.lCL.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100541));
          this.oEG.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100541));
          AppMethodBeat.o(71757);
          return;
          this.oEG.setText(String.format("%s", new Object[] { paramir.CPf }));
        }
        paramView.setEnabled(true);
        this.lCL.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100711));
        this.oEG.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100707));
      }
      AppMethodBeat.o(71757);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI
 * JD-Core Version:    0.7.0.1
 */