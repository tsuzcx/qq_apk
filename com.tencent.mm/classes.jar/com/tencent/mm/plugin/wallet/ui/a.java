package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.base.u.d;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;

public final class a
{
  u.i GAC;
  public u.g Vtg;
  u.i Vth;
  u.b Vti;
  u.d Vtj;
  s Vtk;
  s Vtl;
  a Vtm;
  public boolean Vtn;
  public boolean Vto;
  private AdapterView.OnItemClickListener Vtp;
  Context mContext;
  private RecyclerView mRecyclerView;
  public int pym;
  private View tss;
  public final j xcO;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(315467);
    this.Vtn = false;
    this.Vto = false;
    this.pym = 0;
    this.Vtp = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(315473);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (paramAnonymousInt >= a.this.Vtk.size() + a.this.Vtl.size())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(315473);
          return;
        }
        if (paramAnonymousInt < a.this.Vtk.size())
        {
          paramAnonymousAdapterView = (t)a.this.Vtk.adRW.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.disable))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(315473);
            return;
          }
          if (a.this.GAC != null)
          {
            a.this.GAC.onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
            a.this.pym = paramAnonymousInt;
          }
        }
        for (;;)
        {
          a.this.Vtm.bZE.notifyChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(315473);
          return;
          paramAnonymousAdapterView.performClick();
          break;
          if ((a.this.Vtl.size() > 0) && (paramAnonymousInt < a.this.Vtk.size() + a.this.Vtl.size()))
          {
            paramAnonymousAdapterView = (t)a.this.Vtl.adRW.get(paramAnonymousInt - a.this.Vtk.size());
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.disable))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(315473);
              return;
            }
            if (a.this.Vth != null) {
              a.this.Vth.onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
            }
          }
        }
      }
    };
    this.mContext = paramContext;
    this.xcO = new j(paramContext, 2, 3);
    paramContext = this.mContext;
    this.Vtk = new s(paramContext);
    this.Vtl = new s(paramContext);
    this.mRecyclerView = new RecyclerView(this.mContext);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.mRecyclerView.setFocusable(false);
    this.mRecyclerView.setLayoutParams(paramContext);
    this.mRecyclerView.setHasFixedSize(true);
    this.mRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.mRecyclerView.setItemViewCacheSize(20);
    this.mRecyclerView.setPadding(0, 0, 0, 0);
    this.Vtm = new a();
    this.Vtm.GAB = this.Vtk;
    this.Vtm.un = this.Vtp;
    this.mRecyclerView.setAdapter(this.Vtm);
    if (this.xcO != null) {
      this.xcO.setCustomView(this.mRecyclerView);
    }
    AppMethodBeat.o(315467);
  }
  
  public final void a(s params, u.i parami)
  {
    this.Vtl = params;
    this.Vth = parami;
  }
  
  public final void a(j.a parama)
  {
    this.xcO.agfR = parama;
  }
  
  public final void au(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(315476);
    this.xcO.au(paramCharSequence);
    AppMethodBeat.o(315476);
  }
  
  public final void dDn()
  {
    AppMethodBeat.i(315491);
    if (this.Vtg != null) {
      this.Vtg.onCreateMMMenu(this.Vtk);
    }
    this.mRecyclerView.setPadding(0, 0, 0, 0);
    if ((this.Vtl != null) && (this.Vtm != null)) {
      this.Vtm.bZE.notifyChanged();
    }
    this.xcO.dDn();
    AppMethodBeat.o(315491);
  }
  
  public final void ihf()
  {
    AppMethodBeat.i(315483);
    if (this.Vtm != null) {
      this.Vtm.bZE.notifyChanged();
    }
    this.xcO.dDn();
    AppMethodBeat.o(315483);
  }
  
  public final void setTitleView(View paramView)
  {
    AppMethodBeat.i(315471);
    this.xcO.mi(paramView);
    this.tss = paramView;
    AppMethodBeat.o(315471);
  }
  
  public final class a
    extends RecyclerView.a<a>
  {
    s GAB;
    AdapterView.OnItemClickListener un;
    
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(315466);
      int i = this.GAB.size();
      int j = a.this.Vtl.size();
      AppMethodBeat.o(315466);
      return i + j;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(315463);
      if (paramInt < this.GAB.size())
      {
        AppMethodBeat.o(315463);
        return 0;
      }
      AppMethodBeat.o(315463);
      return 1;
    }
    
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener
    {
      WeImageView EoD;
      WeImageView Vtr;
      ImageView Vts;
      LinearLayout Vtt;
      TextView mll;
      TextView pmf;
      
      public a(View paramView, int paramInt)
      {
        super();
        AppMethodBeat.i(315465);
        paramView.setOnClickListener(this);
        this.mll = ((TextView)paramView.findViewById(a.f.title));
        this.EoD = ((WeImageView)paramView.findViewById(a.f.icon));
        this.Vtt = ((LinearLayout)paramView.findViewById(a.f.root));
        if (a.this.Vtn)
        {
          this.Vtr = ((WeImageView)paramView.findViewById(a.f.radio));
          this.pmf = ((TextView)paramView.findViewById(a.f.desc));
          this.Vts = ((ImageView)paramView.findViewById(a.f.divider));
          if (paramInt == 1)
          {
            paramView = (LinearLayout.LayoutParams)this.Vts.getLayoutParams();
            paramView.setMargins(0, 0, 0, 0);
            this.Vts.setLayoutParams(paramView);
            this.Vtr.setImageResource(a.h.icons_outlined_arrow);
            this.Vtr.setIconColor(a.this.mContext.getResources().getColor(a.c.FG_2));
          }
        }
        AppMethodBeat.o(315465);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(315470);
        b localb = new b();
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (a.a.this.un != null) {
          a.a.this.un.onItemClick(null, paramView, getPosition(), getPosition());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(315470);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.a
 * JD-Core Version:    0.7.0.1
 */