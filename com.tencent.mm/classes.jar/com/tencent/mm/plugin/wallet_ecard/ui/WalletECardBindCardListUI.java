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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_ecard.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
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
  private IListener<lj> AJa;
  private ListView Iqg;
  private TextView Iqh;
  private List<je> Iqi;
  private c Iqj;
  private boolean Iqk;
  private d.a Iql;
  private int pmM;
  
  public WalletECardBindCardListUI()
  {
    AppMethodBeat.i(71758);
    this.Iqi = new ArrayList();
    this.Iqk = true;
    this.Iql = new d.a()
    {
      public final Intent q(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(71748);
        Log.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousBundle });
        if (paramAnonymousInt == -1)
        {
          BindCardOrder localBindCardOrder = (BindCardOrder)paramAnonymousBundle.getParcelable("key_bindcard_value_result");
          if (localBindCardOrder != null)
          {
            je localje = new je();
            localje.dDj = paramAnonymousBundle.getString("key_bind_card_type");
            localje.KNI = localBindCardOrder.HWx;
            localje.HQc = paramAnonymousBundle.getString("key_mobile");
            if ((!Util.isNullOrNil(localje.KNI)) && (!Util.isNullOrNil(localje.dDj)) && (!Util.isNullOrNil(localje.HQc)))
            {
              WalletECardBindCardListUI.this.getNetController().r(new Object[] { localje });
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
    this.AJa = new IListener() {};
    AppMethodBeat.o(71758);
  }
  
  private void bqe()
  {
    AppMethodBeat.i(71764);
    Log.i("MicroMsg.WalletECardBindCardListUI", "load Data");
    doSceneForceProgress(new f("WEB_DEBIT", this.pmM));
    AppMethodBeat.o(71764);
  }
  
  private boolean h(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(71765);
    com.tencent.mm.wallet_core.b.hgC();
    if (com.tencent.mm.wallet_core.b.b(b.a.rZU, true))
    {
      EventCenter.instance.add(this.AJa);
      Log.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:true");
      ab.mg(6, paramBundle.getInt("key_bind_scene"));
      z.aqh(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(71765);
      return true;
    }
    Log.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:false");
    AppMethodBeat.o(71765);
    return false;
  }
  
  public final void fUm()
  {
    AppMethodBeat.i(71762);
    Bundle localBundle = new Bundle();
    if (this.pmM == 3) {
      localBundle.putInt("key_bind_scene", 18);
    }
    for (;;)
    {
      localBundle.putBoolean("key_need_bind_response", true);
      localBundle.putBoolean("key_is_bind_bankcard", true);
      localBundle.putString("key_pwd1", getInput().getString("key_pwd1"));
      Log.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", new Object[] { Integer.valueOf(this.pmM) });
      if (!h(this, localBundle)) {
        break;
      }
      AppMethodBeat.o(71762);
      return;
      localBundle.putInt("key_bind_scene", 19);
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_ecard.b.a.class, localBundle, this.Iql);
    AppMethodBeat.o(71762);
  }
  
  public int getLayoutId()
  {
    return 2131493862;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71760);
    this.Iqg = ((ListView)findViewById(2131297337));
    View localView = LayoutInflater.from(this).inflate(2131493863, this.Iqg, false);
    this.Iqh = ((TextView)localView.findViewById(2131299817));
    this.Iqg.addHeaderView(localView, null, false);
    this.Iqj = new c((byte)0);
    this.Iqg.setAdapter(this.Iqj);
    this.Iqg.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71747);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        Log.i("MicroMsg.WalletECardBindCardListUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i = paramAnonymousAdapterView.getAdapter().getItemViewType(paramAnonymousInt);
        WalletECardBindCardListUI.a(WalletECardBindCardListUI.this).getClass();
        if (i == 1)
        {
          Log.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", new Object[] { Integer.valueOf(WalletECardBindCardListUI.b(WalletECardBindCardListUI.this)) });
          WalletECardBindCardListUI.this.fUm();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(71747);
          return;
          paramAnonymousAdapterView = (je)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
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
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    this.mNetSceneMgr.addSceneEndListener(1988);
    this.pmM = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq, 2);
    Log.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", new Object[] { Integer.valueOf(this.pmM) });
    setMMTitle("");
    initView();
    this.Iqk = true;
    bqe();
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
        if (!Util.isNullOrNil(paramq.IpX.MLv)) {
          this.Iqh.setText(paramq.IpX.MLv);
        }
        if (paramq.IpX.pTZ == 0)
        {
          Log.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", new Object[] { Integer.valueOf(paramq.IpX.MLw.size()) });
          Log.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", new Object[] { paramq.IpX.HTZ });
          getInput().putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpH, paramq.IpX.HTZ);
          if (paramq.IpX.MLw.size() == 0)
          {
            Log.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", new Object[] { Boolean.valueOf(this.Iqk) });
            if (this.Iqk) {
              fUm();
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71761);
        return true;
        this.Iqi.clear();
        this.Iqi.addAll(paramq.IpX.MLw);
        this.Iqj.notifyDataSetChanged();
        continue;
        if (!com.tencent.mm.plugin.wallet_ecard.a.b.a(this, paramq.IpX.KPx))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(getContext(), new String[] { paramq.IpX.pUa, paramString });
          h.c(getContext(), paramString, "", false);
          continue;
          Log.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", new Object[] { paramq });
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
    TextView olP;
    
    public a(View paramView)
    {
      AppMethodBeat.i(71750);
      this.olP = ((TextView)paramView.findViewById(2131299816));
      this$1 = (ImageView)paramView.findViewById(2131299815);
      paramView = android.support.v4.graphics.drawable.a.i(WalletECardBindCardListUI.this.getDrawable());
      android.support.v4.graphics.drawable.a.a(paramView, ColorStateList.valueOf(MMApplicationContext.getResources().getColor(2131100685)));
      WalletECardBindCardListUI.this.setImageDrawable(paramView);
      AppMethodBeat.o(71750);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(View paramView, je paramje);
  }
  
  final class c
    extends BaseAdapter
  {
    public final int BPh = 0;
    public final int Iqn = 1;
    
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
          localView = LayoutInflater.from(WalletECardBindCardListUI.this.getContext()).inflate(2131493865, paramViewGroup, false);
          localView.setTag(new WalletECardBindCardListUI.a(WalletECardBindCardListUI.this, localView));
        }
        ((WalletECardBindCardListUI.a)localView.getTag()).olP.setText(2131758431);
      }
      for (;;)
      {
        AppMethodBeat.o(71755);
        return localView;
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(WalletECardBindCardListUI.this.getContext()).inflate(2131493864, paramViewGroup, false);
          localView.setTag(new WalletECardBindCardListUI.d(WalletECardBindCardListUI.this, localView));
        }
        ((WalletECardBindCardListUI.b)localView.getTag()).a(localView, (je)getItem(paramInt));
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(71754);
      je localje = (je)getItem(paramInt);
      if (localje != null)
      {
        if (localje.KNK)
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
    CdnImageView Iqo;
    TextView mPa;
    TextView pYW;
    
    public d(View paramView)
    {
      AppMethodBeat.i(71756);
      this.Iqo = ((CdnImageView)paramView.findViewById(2131297336));
      this.mPa = ((TextView)paramView.findViewById(2131297339));
      this.pYW = ((TextView)paramView.findViewById(2131297338));
      AppMethodBeat.o(71756);
    }
    
    public final void a(View paramView, je paramje)
    {
      AppMethodBeat.i(71757);
      if (paramje != null)
      {
        this.Iqo.setRoundCorner(true);
        this.Iqo.setUrl(paramje.KNJ);
        this.mPa.setText(String.format("%s %s(%s)", new Object[] { paramje.ynT, paramje.qcN, paramje.KNH }));
        if (!Util.isNullOrNil(paramje.KNL)) {
          this.pYW.setText(String.format("%s，%s", new Object[] { paramje.HQc, paramje.KNL }));
        }
        while (paramje.KNK)
        {
          Log.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", new Object[] { paramje.ynT });
          paramView.setEnabled(false);
          this.mPa.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100679));
          this.pYW.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100679));
          AppMethodBeat.o(71757);
          return;
          this.pYW.setText(String.format("%s", new Object[] { paramje.HQc }));
        }
        paramView.setEnabled(true);
        this.mPa.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100904));
        this.pYW.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(2131100900));
      }
      AppMethodBeat.o(71757);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI
 * JD-Core Version:    0.7.0.1
 */