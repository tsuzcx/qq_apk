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
import com.tencent.mm.g.a.kj;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_ecard.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  private ListView BOW;
  private TextView BOX;
  private List<ik> BOY;
  private c BOZ;
  private boolean BPa;
  private d.a BPb;
  private int nuJ;
  private c<kj> vsr;
  
  public WalletECardBindCardListUI()
  {
    AppMethodBeat.i(71758);
    this.BOY = new ArrayList();
    this.BPa = true;
    this.BPb = new d.a()
    {
      public final Intent r(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(71748);
        ac.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousBundle });
        if (paramAnonymousInt == -1)
        {
          BindCardOrder localBindCardOrder = (BindCardOrder)paramAnonymousBundle.getParcelable("key_bindcard_value_result");
          if (localBindCardOrder != null)
          {
            ik localik = new ik();
            localik.cZz = paramAnonymousBundle.getString("key_bind_card_type");
            localik.DWi = localBindCardOrder.Bvk;
            localik.BoQ = paramAnonymousBundle.getString("key_mobile");
            if ((!bs.isNullOrNil(localik.DWi)) && (!bs.isNullOrNil(localik.cZz)) && (!bs.isNullOrNil(localik.BoQ)))
            {
              WalletECardBindCardListUI.this.getNetController().s(new Object[] { localik });
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
    this.vsr = new c() {};
    AppMethodBeat.o(71758);
  }
  
  private void aRI()
  {
    AppMethodBeat.i(71764);
    ac.i("MicroMsg.WalletECardBindCardListUI", "load Data");
    doSceneForceProgress(new f("WEB_DEBIT", this.nuJ));
    AppMethodBeat.o(71764);
  }
  
  private boolean g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(71765);
    com.tencent.mm.wallet_core.b.fzz();
    if (com.tencent.mm.wallet_core.b.b(b.a.pUR, false))
    {
      com.tencent.mm.sdk.b.a.GpY.b(this.vsr);
      ac.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:true");
      ab.km(6, paramBundle.getInt("key_bind_scene"));
      z.adM(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(71765);
      return true;
    }
    ac.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:false");
    AppMethodBeat.o(71765);
    return false;
  }
  
  public final void euR()
  {
    AppMethodBeat.i(71762);
    Bundle localBundle = new Bundle();
    if (this.nuJ == 3) {
      localBundle.putInt("key_bind_scene", 18);
    }
    for (;;)
    {
      localBundle.putBoolean("key_need_bind_response", true);
      localBundle.putBoolean("key_is_bind_bankcard", true);
      localBundle.putString("key_pwd1", getInput().getString("key_pwd1"));
      ac.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", new Object[] { Integer.valueOf(this.nuJ) });
      if (!g(this, localBundle)) {
        break;
      }
      AppMethodBeat.o(71762);
      return;
      localBundle.putInt("key_bind_scene", 19);
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_ecard.b.a.class, localBundle, this.BPb);
    AppMethodBeat.o(71762);
  }
  
  public int getLayoutId()
  {
    return 2131493727;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71760);
    this.BOW = ((ListView)findViewById(2131297192));
    View localView = LayoutInflater.from(this).inflate(2131493728, this.BOW, false);
    this.BOX = ((TextView)localView.findViewById(2131299245));
    this.BOW.addHeaderView(localView, null, false);
    this.BOZ = new c((byte)0);
    this.BOW.setAdapter(this.BOZ);
    this.BOW.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71747);
        ac.i("MicroMsg.WalletECardBindCardListUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i = paramAnonymousAdapterView.getAdapter().getItemViewType(paramAnonymousInt);
        WalletECardBindCardListUI.a(WalletECardBindCardListUI.this).getClass();
        if (i == 1)
        {
          ac.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", new Object[] { Integer.valueOf(WalletECardBindCardListUI.b(WalletECardBindCardListUI.this)) });
          WalletECardBindCardListUI.this.euR();
          AppMethodBeat.o(71747);
          return;
        }
        paramAnonymousAdapterView = (ik)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ac.w("MicroMsg.WalletECardBindCardListUI", "empty item");
          AppMethodBeat.o(71747);
          return;
        }
        WalletECardBindCardListUI.this.getNetController().s(new Object[] { paramAnonymousAdapterView });
        AppMethodBeat.o(71747);
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
    this.nuJ = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.BOg, 2);
    ac.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", new Object[] { Integer.valueOf(this.nuJ) });
    setMMTitle("");
    initView();
    this.BPa = true;
    aRI();
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
        if (!bs.isNullOrNil(paramn.BON.Fxf)) {
          this.BOX.setText(paramn.BON.Fxf);
        }
        if (paramn.BON.nWx == 0)
        {
          ac.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", new Object[] { Integer.valueOf(paramn.BON.Fxg.size()) });
          ac.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", new Object[] { paramn.BON.BsL });
          getInput().putString(com.tencent.mm.plugin.wallet_ecard.a.a.BOx, paramn.BON.BsL);
          if (paramn.BON.Fxg.size() == 0)
          {
            ac.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", new Object[] { Boolean.valueOf(this.BPa) });
            if (this.BPa) {
              euR();
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71761);
        return true;
        this.BOY.clear();
        this.BOY.addAll(paramn.BON.Fxg);
        this.BOZ.notifyDataSetChanged();
        continue;
        if (!com.tencent.mm.plugin.wallet_ecard.a.b.a(this, paramn.BON.DXV))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(getContext(), new String[] { paramn.BON.nWy, paramString });
          h.c(getContext(), paramString, "", false);
          continue;
          ac.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", new Object[] { paramn });
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
    TextView msW;
    
    public a(View paramView)
    {
      AppMethodBeat.i(71750);
      this.msW = ((TextView)paramView.findViewById(2131299244));
      this$1 = (ImageView)paramView.findViewById(2131299243);
      paramView = android.support.v4.graphics.drawable.a.i(WalletECardBindCardListUI.this.getDrawable());
      android.support.v4.graphics.drawable.a.a(paramView, ColorStateList.valueOf(ai.getResources().getColor(2131100547)));
      WalletECardBindCardListUI.this.setImageDrawable(paramView);
      AppMethodBeat.o(71750);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(View paramView, ik paramik);
  }
  
  final class c
    extends BaseAdapter
  {
    public final int BPd = 1;
    public final int wrr = 0;
    
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
        ((WalletECardBindCardListUI.a)localView.getTag()).msW.setText(2131758158);
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
        ((WalletECardBindCardListUI.b)localView.getTag()).a(localView, (ik)getItem(paramInt));
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(71754);
      ik localik = (ik)getItem(paramInt);
      if (localik != null)
      {
        if (localik.DWk)
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
    CdnImageView BPe;
    TextView lfN;
    TextView obn;
    
    public d(View paramView)
    {
      AppMethodBeat.i(71756);
      this.BPe = ((CdnImageView)paramView.findViewById(2131297191));
      this.lfN = ((TextView)paramView.findViewById(2131297194));
      this.obn = ((TextView)paramView.findViewById(2131297193));
      AppMethodBeat.o(71756);
    }
    
    public final void a(View paramView, ik paramik)
    {
      AppMethodBeat.i(71757);
      if (paramik != null)
      {
        this.BPe.setRoundCorner(true);
        this.BPe.setUrl(paramik.DWj);
        this.lfN.setText(String.format("%s %s(%s)", new Object[] { paramik.tGS, paramik.ofd, paramik.DWh }));
        if (!bs.isNullOrNil(paramik.DWl)) {
          this.obn.setText(String.format("%s，%s", new Object[] { paramik.BoQ, paramik.DWl }));
        }
        while (paramik.DWk)
        {
          ac.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", new Object[] { paramik.tGS });
          paramView.setEnabled(false);
          this.lfN.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100541));
          this.obn.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100541));
          AppMethodBeat.o(71757);
          return;
          this.obn.setText(String.format("%s", new Object[] { paramik.BoQ }));
        }
        paramView.setEnabled(true);
        this.lfN.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100711));
        this.obn.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100707));
      }
      AppMethodBeat.o(71757);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI
 * JD-Core Version:    0.7.0.1
 */