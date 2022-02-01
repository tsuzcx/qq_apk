package com.tencent.mm.plugin.wallet_ecard.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ejp;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.e.a;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.model.ac;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class WalletECardBindCardListUI
  extends WalletECardBaseUI
{
  private IListener<ng> Myr;
  private ListView VZC;
  private TextView VZD;
  private List<jp> VZE;
  private c VZF;
  private boolean VZG;
  private e.a VZH;
  private int vAZ;
  
  public WalletECardBindCardListUI()
  {
    AppMethodBeat.i(71758);
    this.VZE = new ArrayList();
    this.VZG = true;
    this.VZH = new e.a()
    {
      public final Intent v(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(71748);
        Log.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousBundle });
        if (paramAnonymousInt == -1)
        {
          BindCardOrder localBindCardOrder = (BindCardOrder)paramAnonymousBundle.getParcelable("key_bindcard_value_result");
          if (localBindCardOrder != null)
          {
            jp localjp = new jp();
            localjp.hAk = paramAnonymousBundle.getString("key_bind_card_type");
            localjp.YLQ = localBindCardOrder.VEr;
            localjp.VxX = paramAnonymousBundle.getString("key_mobile");
            if ((!Util.isNullOrNil(localjp.YLQ)) && (!Util.isNullOrNil(localjp.hAk)) && (!Util.isNullOrNil(localjp.VxX)))
            {
              WalletECardBindCardListUI.this.getNetController().t(new Object[] { localjp });
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
    this.Myr = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(71758);
  }
  
  private void dSD()
  {
    AppMethodBeat.i(71764);
    Log.i("MicroMsg.WalletECardBindCardListUI", "load Data");
    doSceneForceProgress(new com.tencent.mm.plugin.wallet_ecard.a.f("WEB_DEBIT", this.vAZ));
    AppMethodBeat.o(71764);
  }
  
  private boolean j(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(71765);
    com.tencent.mm.wallet_core.b.jNX();
    if (com.tencent.mm.wallet_core.b.b(c.a.yWP, true))
    {
      this.Myr.alive();
      Log.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:true");
      ac.pu(6, paramBundle.getInt("key_bind_scene"));
      aa.aGq(paramBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
      AppMethodBeat.o(71765);
      return true;
    }
    Log.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:false");
    AppMethodBeat.o(71765);
    return false;
  }
  
  public int getLayoutId()
  {
    return a.g.ecard_bind_card_list;
  }
  
  public final void imh()
  {
    AppMethodBeat.i(71762);
    Bundle localBundle = new Bundle();
    if (this.vAZ == 3) {
      localBundle.putInt("key_bind_scene", 18);
    }
    for (;;)
    {
      localBundle.putBoolean("key_need_bind_response", true);
      localBundle.putBoolean("key_is_bind_bankcard", true);
      localBundle.putString("key_pwd1", getInput().getString("key_pwd1"));
      Log.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", new Object[] { Integer.valueOf(this.vAZ) });
      if (!j(this, localBundle)) {
        break;
      }
      AppMethodBeat.o(71762);
      return;
      localBundle.putInt("key_bind_scene", 19);
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_ecard.b.a.class, localBundle, this.VZH);
    AppMethodBeat.o(71762);
  }
  
  public void initView()
  {
    AppMethodBeat.i(71760);
    this.VZC = ((ListView)findViewById(a.f.bcard_bind_card_list));
    View localView = LayoutInflater.from(this).inflate(a.g.ecard_bind_card_list_header_layout, this.VZC, false);
    this.VZD = ((TextView)localView.findViewById(a.f.ecard_bind_list_desc_tv));
    this.VZC.addHeaderView(localView, null, false);
    this.VZF = new c((byte)0);
    this.VZC.setAdapter(this.VZF);
    this.VZC.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(71747);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        Log.i("MicroMsg.WalletECardBindCardListUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i = paramAnonymousAdapterView.getAdapter().getItemViewType(paramAnonymousInt);
        Objects.requireNonNull(WalletECardBindCardListUI.a(WalletECardBindCardListUI.this));
        if (i == 1)
        {
          Log.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", new Object[] { Integer.valueOf(WalletECardBindCardListUI.b(WalletECardBindCardListUI.this)) });
          WalletECardBindCardListUI.this.imh();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(71747);
          return;
          paramAnonymousAdapterView = (jp)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            Log.w("MicroMsg.WalletECardBindCardListUI", "empty item");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(71747);
            return;
          }
          WalletECardBindCardListUI.this.getNetController().t(new Object[] { paramAnonymousAdapterView });
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
    this.vAZ = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.VYM, 2);
    Log.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", new Object[] { Integer.valueOf(this.vAZ) });
    setMMTitle("");
    initView();
    this.VZG = true;
    dSD();
    AppMethodBeat.o(71759);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71763);
    super.onDestroy();
    this.mNetSceneMgr.removeSceneEndListener(1988);
    AppMethodBeat.o(71763);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71761);
    if ((paramp instanceof com.tencent.mm.plugin.wallet_ecard.a.f))
    {
      paramp = (com.tencent.mm.plugin.wallet_ecard.a.f)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!Util.isNullOrNil(paramp.VZt.aboh)) {
          this.VZD.setText(paramp.VZt.aboh);
        }
        if (paramp.VZt.wuz == 0)
        {
          Log.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", new Object[] { Integer.valueOf(paramp.VZt.aboi.size()) });
          Log.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", new Object[] { paramp.VZt.VBL });
          getInput().putString(com.tencent.mm.plugin.wallet_ecard.a.a.VZd, paramp.VZt.VBL);
          if (paramp.VZt.aboi.size() == 0)
          {
            Log.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", new Object[] { Boolean.valueOf(this.VZG) });
            if (this.VZG) {
              imh();
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71761);
        return true;
        this.VZE.clear();
        this.VZE.addAll(paramp.VZt.aboi);
        this.VZF.notifyDataSetChanged();
        continue;
        if (!com.tencent.mm.plugin.wallet_ecard.a.b.a(this, paramp.VZt.YNL))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(getContext(), new String[] { paramp.VZt.wuA, paramString });
          k.c(getContext(), paramString, "", false);
          continue;
          Log.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", new Object[] { paramp });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.e(getContext(), new String[] { paramString });
          k.c(getContext(), paramString, "", false);
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
    TextView uyy;
    
    public a(View paramView)
    {
      AppMethodBeat.i(71750);
      this.uyy = ((TextView)paramView.findViewById(a.f.ecard_bind_card_add_main_title_tv));
      this$1 = (ImageView)paramView.findViewById(a.f.ecard_bind_card_add_main_iv);
      paramView = androidx.core.graphics.drawable.a.s(WalletECardBindCardListUI.this.getDrawable());
      androidx.core.graphics.drawable.a.a(paramView, ColorStateList.valueOf(MMApplicationContext.getResources().getColor(a.c.link_color)));
      WalletECardBindCardListUI.this.setImageDrawable(paramView);
      AppMethodBeat.o(71750);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(View paramView, jp paramjp);
  }
  
  final class c
    extends BaseAdapter
  {
    public final int NIN = 0;
    public final int VZJ = 1;
    
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
        ((WalletECardBindCardListUI.a)localView.getTag()).uyy.setText(a.i.ecard_bind_card_add_other_debit_card);
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
        ((WalletECardBindCardListUI.b)localView.getTag()).a(localView, (jp)getItem(paramInt));
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(71754);
      jp localjp = (jp)getItem(paramInt);
      if (localjp != null)
      {
        if (localjp.YLS)
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
    CdnImageView VZK;
    TextView sUt;
    TextView wzp;
    
    public d(View paramView)
    {
      AppMethodBeat.i(71756);
      this.VZK = ((CdnImageView)paramView.findViewById(a.f.bcard_bind_card_iv));
      this.sUt = ((TextView)paramView.findViewById(a.f.bcard_bind_card_title_tv));
      this.wzp = ((TextView)paramView.findViewById(a.f.bcard_bind_card_subtitle_tv));
      AppMethodBeat.o(71756);
    }
    
    public final void a(View paramView, jp paramjp)
    {
      AppMethodBeat.i(71757);
      if (paramjp != null)
      {
        this.VZK.setRoundCorner(true);
        this.VZK.setUrl(paramjp.YLR);
        this.sUt.setText(String.format("%s %s(%s)", new Object[] { paramjp.JFk, paramjp.wDh, paramjp.YLP }));
        if (!Util.isNullOrNil(paramjp.YLT)) {
          this.wzp.setText(String.format("%s，%s", new Object[] { paramjp.VxX, paramjp.YLT }));
        }
        while (paramjp.YLS)
        {
          Log.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", new Object[] { paramjp.JFk });
          paramView.setEnabled(false);
          this.sUt.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(a.c.light_grey_text_color));
          this.wzp.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(a.c.light_grey_text_color));
          AppMethodBeat.o(71757);
          return;
          this.wzp.setText(String.format("%s", new Object[] { paramjp.VxX }));
        }
        paramView.setEnabled(true);
        this.sUt.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(a.c.normal_text_color));
        this.wzp.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(a.c.normal_color));
      }
      AppMethodBeat.o(71757);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI
 * JD-Core Version:    0.7.0.1
 */