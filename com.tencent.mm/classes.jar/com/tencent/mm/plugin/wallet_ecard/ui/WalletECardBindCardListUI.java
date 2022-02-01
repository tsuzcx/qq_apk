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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_ecard.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
  private ListView DGU;
  private TextView DGV;
  private List<ir> DGW;
  private c DGX;
  private boolean DGY;
  private d.a DGZ;
  private int obQ;
  private c<kt> wNu;
  
  public WalletECardBindCardListUI()
  {
    AppMethodBeat.i(71758);
    this.DGW = new ArrayList();
    this.DGY = true;
    this.DGZ = new d.a()
    {
      public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(71748);
        ae.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousBundle });
        if (paramAnonymousInt == -1)
        {
          BindCardOrder localBindCardOrder = (BindCardOrder)paramAnonymousBundle.getParcelable("key_bindcard_value_result");
          if (localBindCardOrder != null)
          {
            ir localir = new ir();
            localir.dlT = paramAnonymousBundle.getString("key_bind_card_type");
            localir.FTZ = localBindCardOrder.Dnf;
            localir.DgJ = paramAnonymousBundle.getString("key_mobile");
            if ((!bu.isNullOrNil(localir.FTZ)) && (!bu.isNullOrNil(localir.dlT)) && (!bu.isNullOrNil(localir.DgJ)))
            {
              WalletECardBindCardListUI.this.getNetController().r(new Object[] { localir });
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
    this.wNu = new c() {};
    AppMethodBeat.o(71758);
  }
  
  private void aVt()
  {
    AppMethodBeat.i(71764);
    ae.i("MicroMsg.WalletECardBindCardListUI", "load Data");
    doSceneForceProgress(new f("WEB_DEBIT", this.obQ));
    AppMethodBeat.o(71764);
  }
  
  private boolean g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(71765);
    com.tencent.mm.wallet_core.b.fVf();
    if (com.tencent.mm.wallet_core.b.b(b.a.qGD, false))
    {
      com.tencent.mm.sdk.b.a.IvT.b(this.wNu);
      ae.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:true");
      ab.kI(6, paramBundle.getInt("key_bind_scene"));
      z.agV(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(71765);
      return true;
    }
    ae.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:false");
    AppMethodBeat.o(71765);
    return false;
  }
  
  public final void eMF()
  {
    AppMethodBeat.i(71762);
    Bundle localBundle = new Bundle();
    if (this.obQ == 3) {
      localBundle.putInt("key_bind_scene", 18);
    }
    for (;;)
    {
      localBundle.putBoolean("key_need_bind_response", true);
      localBundle.putBoolean("key_is_bind_bankcard", true);
      localBundle.putString("key_pwd1", getInput().getString("key_pwd1"));
      ae.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", new Object[] { Integer.valueOf(this.obQ) });
      if (!g(this, localBundle)) {
        break;
      }
      AppMethodBeat.o(71762);
      return;
      localBundle.putInt("key_bind_scene", 19);
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_ecard.b.a.class, localBundle, this.DGZ);
    AppMethodBeat.o(71762);
  }
  
  public int getLayoutId()
  {
    return 2131493727;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71760);
    this.DGU = ((ListView)findViewById(2131297192));
    View localView = LayoutInflater.from(this).inflate(2131493728, this.DGU, false);
    this.DGV = ((TextView)localView.findViewById(2131299245));
    this.DGU.addHeaderView(localView, null, false);
    this.DGX = new c((byte)0);
    this.DGU.setAdapter(this.DGX);
    this.DGU.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71747);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        ae.i("MicroMsg.WalletECardBindCardListUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i = paramAnonymousAdapterView.getAdapter().getItemViewType(paramAnonymousInt);
        WalletECardBindCardListUI.a(WalletECardBindCardListUI.this).getClass();
        if (i == 1)
        {
          ae.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", new Object[] { Integer.valueOf(WalletECardBindCardListUI.b(WalletECardBindCardListUI.this)) });
          WalletECardBindCardListUI.this.eMF();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(71747);
          return;
          paramAnonymousAdapterView = (ir)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            ae.w("MicroMsg.WalletECardBindCardListUI", "empty item");
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
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    this.mNetSceneMgr.addSceneEndListener(1988);
    this.obQ = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.DGe, 2);
    ae.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", new Object[] { Integer.valueOf(this.obQ) });
    setMMTitle("");
    initView();
    this.DGY = true;
    aVt();
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
        if (!bu.isNullOrNil(paramn.DGL.HAK)) {
          this.DGV.setText(paramn.DGL.HAK);
        }
        if (paramn.DGL.oGt == 0)
        {
          ae.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", new Object[] { Integer.valueOf(paramn.DGL.HAL.size()) });
          ae.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", new Object[] { paramn.DGL.DkG });
          getInput().putString(com.tencent.mm.plugin.wallet_ecard.a.a.DGv, paramn.DGL.DkG);
          if (paramn.DGL.HAL.size() == 0)
          {
            ae.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", new Object[] { Boolean.valueOf(this.DGY) });
            if (this.DGY) {
              eMF();
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71761);
        return true;
        this.DGW.clear();
        this.DGW.addAll(paramn.DGL.HAL);
        this.DGX.notifyDataSetChanged();
        continue;
        if (!com.tencent.mm.plugin.wallet_ecard.a.b.a(this, paramn.DGL.FVM))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(getContext(), new String[] { paramn.DGL.oGu, paramString });
          h.c(getContext(), paramString, "", false);
          continue;
          ae.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", new Object[] { paramn });
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
    TextView mYK;
    
    public a(View paramView)
    {
      AppMethodBeat.i(71750);
      this.mYK = ((TextView)paramView.findViewById(2131299244));
      this$1 = (ImageView)paramView.findViewById(2131299243);
      paramView = android.support.v4.graphics.drawable.a.i(WalletECardBindCardListUI.this.getDrawable());
      android.support.v4.graphics.drawable.a.a(paramView, ColorStateList.valueOf(ak.getResources().getColor(2131100547)));
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
    public final int DHb = 1;
    public final int xPe = 0;
    
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
        ((WalletECardBindCardListUI.a)localView.getTag()).mYK.setText(2131758158);
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
        if (localir.FUb)
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
    CdnImageView DHc;
    TextView lHk;
    TextView oLi;
    
    public d(View paramView)
    {
      AppMethodBeat.i(71756);
      this.DHc = ((CdnImageView)paramView.findViewById(2131297191));
      this.lHk = ((TextView)paramView.findViewById(2131297194));
      this.oLi = ((TextView)paramView.findViewById(2131297193));
      AppMethodBeat.o(71756);
    }
    
    public final void a(View paramView, ir paramir)
    {
      AppMethodBeat.i(71757);
      if (paramir != null)
      {
        this.DHc.setRoundCorner(true);
        this.DHc.setUrl(paramir.FUa);
        this.lHk.setText(String.format("%s %s(%s)", new Object[] { paramir.uVs, paramir.oOZ, paramir.FTY }));
        if (!bu.isNullOrNil(paramir.FUc)) {
          this.oLi.setText(String.format("%s，%s", new Object[] { paramir.DgJ, paramir.FUc }));
        }
        while (paramir.FUb)
        {
          ae.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", new Object[] { paramir.uVs });
          paramView.setEnabled(false);
          this.lHk.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100541));
          this.oLi.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100541));
          AppMethodBeat.o(71757);
          return;
          this.oLi.setText(String.format("%s", new Object[] { paramir.DgJ }));
        }
        paramView.setEnabled(true);
        this.lHk.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100711));
        this.oLi.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100707));
      }
      AppMethodBeat.o(71757);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI
 * JD-Core Version:    0.7.0.1
 */