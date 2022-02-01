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
import com.tencent.mm.g.a.kb;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_ecard.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ced;
import com.tencent.mm.protocal.protobuf.ie;
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
  private ListView AwC;
  private TextView AwD;
  private List<ie> AwE;
  private c AwF;
  private boolean AwG;
  private d.a AwH;
  private int mSu;
  private c<kb> ujv;
  
  public WalletECardBindCardListUI()
  {
    AppMethodBeat.i(71758);
    this.AwE = new ArrayList();
    this.AwG = true;
    this.AwH = new d.a()
    {
      public final Intent q(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(71748);
        ad.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousBundle });
        if (paramAnonymousInt == -1)
        {
          BindCardOrder localBindCardOrder = (BindCardOrder)paramAnonymousBundle.getParcelable("key_bindcard_value_result");
          if (localBindCardOrder != null)
          {
            ie localie = new ie();
            localie.dca = paramAnonymousBundle.getString("key_bind_card_type");
            localie.CDJ = localBindCardOrder.AcQ;
            localie.zWw = paramAnonymousBundle.getString("key_mobile");
            if ((!bt.isNullOrNil(localie.CDJ)) && (!bt.isNullOrNil(localie.dca)) && (!bt.isNullOrNil(localie.zWw)))
            {
              WalletECardBindCardListUI.this.getNetController().q(new Object[] { localie });
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
    this.ujv = new c() {};
    AppMethodBeat.o(71758);
  }
  
  private void aKR()
  {
    AppMethodBeat.i(71764);
    ad.i("MicroMsg.WalletECardBindCardListUI", "load Data");
    doSceneForceProgress(new f("WEB_DEBIT", this.mSu));
    AppMethodBeat.o(71764);
  }
  
  private boolean g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(71765);
    com.tencent.mm.wallet_core.b.fjk();
    if (com.tencent.mm.wallet_core.b.b(b.a.pre, false))
    {
      com.tencent.mm.sdk.b.a.ESL.b(this.ujv);
      ad.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:true");
      ab.jZ(6, paramBundle.getInt("key_bind_scene"));
      z.abt(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(71765);
      return true;
    }
    ad.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:false");
    AppMethodBeat.o(71765);
    return false;
  }
  
  public final void efx()
  {
    AppMethodBeat.i(71762);
    Bundle localBundle = new Bundle();
    if (this.mSu == 3) {
      localBundle.putInt("key_bind_scene", 18);
    }
    for (;;)
    {
      localBundle.putBoolean("key_need_bind_response", true);
      localBundle.putBoolean("key_is_bind_bankcard", true);
      localBundle.putString("key_pwd1", getInput().getString("key_pwd1"));
      ad.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", new Object[] { Integer.valueOf(this.mSu) });
      if (!g(this, localBundle)) {
        break;
      }
      AppMethodBeat.o(71762);
      return;
      localBundle.putInt("key_bind_scene", 19);
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_ecard.b.a.class, localBundle, this.AwH);
    AppMethodBeat.o(71762);
  }
  
  public int getLayoutId()
  {
    return 2131493727;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71760);
    this.AwC = ((ListView)findViewById(2131297192));
    View localView = LayoutInflater.from(this).inflate(2131493728, this.AwC, false);
    this.AwD = ((TextView)localView.findViewById(2131299245));
    this.AwC.addHeaderView(localView, null, false);
    this.AwF = new c((byte)0);
    this.AwC.setAdapter(this.AwF);
    this.AwC.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71747);
        ad.i("MicroMsg.WalletECardBindCardListUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i = paramAnonymousAdapterView.getAdapter().getItemViewType(paramAnonymousInt);
        WalletECardBindCardListUI.a(WalletECardBindCardListUI.this).getClass();
        if (i == 1)
        {
          ad.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", new Object[] { Integer.valueOf(WalletECardBindCardListUI.b(WalletECardBindCardListUI.this)) });
          WalletECardBindCardListUI.this.efx();
          AppMethodBeat.o(71747);
          return;
        }
        paramAnonymousAdapterView = (ie)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ad.w("MicroMsg.WalletECardBindCardListUI", "empty item");
          AppMethodBeat.o(71747);
          return;
        }
        WalletECardBindCardListUI.this.getNetController().q(new Object[] { paramAnonymousAdapterView });
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
    this.mSu = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.AvM, 2);
    ad.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", new Object[] { Integer.valueOf(this.mSu) });
    setMMTitle("");
    initView();
    this.AwG = true;
    aKR();
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
        if (!bt.isNullOrNil(paramn.Awt.Eak)) {
          this.AwD.setText(paramn.Awt.Eak);
        }
        if (paramn.Awt.ntx == 0)
        {
          ad.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", new Object[] { Integer.valueOf(paramn.Awt.Eal.size()) });
          ad.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", new Object[] { paramn.Awt.Aar });
          getInput().putString(com.tencent.mm.plugin.wallet_ecard.a.a.Awd, paramn.Awt.Aar);
          if (paramn.Awt.Eal.size() == 0)
          {
            ad.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", new Object[] { Boolean.valueOf(this.AwG) });
            if (this.AwG) {
              efx();
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71761);
        return true;
        this.AwE.clear();
        this.AwE.addAll(paramn.Awt.Eal);
        this.AwF.notifyDataSetChanged();
        continue;
        if (!com.tencent.mm.plugin.wallet_ecard.a.b.a(this, paramn.Awt.CFv))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(getContext(), new String[] { paramn.Awt.nty, paramString });
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
    TextView lQT;
    
    public a(View paramView)
    {
      AppMethodBeat.i(71750);
      this.lQT = ((TextView)paramView.findViewById(2131299244));
      this$1 = (ImageView)paramView.findViewById(2131299243);
      paramView = android.support.v4.graphics.drawable.a.i(WalletECardBindCardListUI.this.getDrawable());
      android.support.v4.graphics.drawable.a.a(paramView, ColorStateList.valueOf(aj.getResources().getColor(2131100547)));
      WalletECardBindCardListUI.this.setImageDrawable(paramView);
      AppMethodBeat.o(71750);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(View paramView, ie paramie);
  }
  
  final class c
    extends BaseAdapter
  {
    public final int AwJ = 1;
    public final int viF = 0;
    
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
        ((WalletECardBindCardListUI.a)localView.getTag()).lQT.setText(2131758158);
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
        ((WalletECardBindCardListUI.b)localView.getTag()).a(localView, (ie)getItem(paramInt));
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(71754);
      ie localie = (ie)getItem(paramInt);
      if (localie != null)
      {
        if (localie.CDL)
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
    CdnImageView AwK;
    TextView kEu;
    TextView nym;
    
    public d(View paramView)
    {
      AppMethodBeat.i(71756);
      this.AwK = ((CdnImageView)paramView.findViewById(2131297191));
      this.kEu = ((TextView)paramView.findViewById(2131297194));
      this.nym = ((TextView)paramView.findViewById(2131297193));
      AppMethodBeat.o(71756);
    }
    
    public final void a(View paramView, ie paramie)
    {
      AppMethodBeat.i(71757);
      if (paramie != null)
      {
        this.AwK.setRoundCorner(true);
        this.AwK.setUrl(paramie.CDK);
        this.kEu.setText(String.format("%s %s(%s)", new Object[] { paramie.szi, paramie.nCd, paramie.CDI }));
        if (!bt.isNullOrNil(paramie.CDM)) {
          this.nym.setText(String.format("%s，%s", new Object[] { paramie.zWw, paramie.CDM }));
        }
        while (paramie.CDL)
        {
          ad.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", new Object[] { paramie.szi });
          paramView.setEnabled(false);
          this.kEu.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100541));
          this.nym.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100541));
          AppMethodBeat.o(71757);
          return;
          this.nym.setText(String.format("%s", new Object[] { paramie.zWw }));
        }
        paramView.setEnabled(true);
        this.kEu.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100711));
        this.nym.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100707));
      }
      AppMethodBeat.o(71757);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI
 * JD-Core Version:    0.7.0.1
 */