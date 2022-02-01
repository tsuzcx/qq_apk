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
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q.b;
import com.tencent.mm.ui.base.q.c;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;

public final class a
{
  public q.f ODT;
  q.g ODU;
  q.g ODV;
  q.b ODW;
  q.c ODX;
  o ODY;
  o ODZ;
  a OEa;
  public boolean OEb;
  public boolean OEc;
  private AdapterView.OnItemClickListener OEd;
  public int mBE;
  Context mContext;
  private RecyclerView mRecyclerView;
  public final g tZx;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(267717);
    this.OEb = false;
    this.OEc = false;
    this.mBE = 0;
    this.OEd = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(274557);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if (paramAnonymousInt >= a.this.ODY.size() + a.this.ODZ.size())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(274557);
          return;
        }
        if (paramAnonymousInt < a.this.ODY.size())
        {
          paramAnonymousAdapterView = (p)a.this.ODY.WkP.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.qfB))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(274557);
            return;
          }
          if (a.this.ODU != null)
          {
            a.this.ODU.onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
            a.this.mBE = paramAnonymousInt;
          }
        }
        for (;;)
        {
          a.this.OEa.alc.notifyChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(274557);
          return;
          paramAnonymousAdapterView.performClick();
          break;
          if ((a.this.ODZ.size() > 0) && (paramAnonymousInt < a.this.ODY.size() + a.this.ODZ.size()))
          {
            paramAnonymousAdapterView = (p)a.this.ODZ.WkP.get(paramAnonymousInt - a.this.ODY.size());
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.qfB))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(274557);
              return;
            }
            if (a.this.ODV != null) {
              a.this.ODV.onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
            }
          }
        }
      }
    };
    this.mContext = paramContext;
    this.tZx = new g(paramContext, 2, 3);
    paramContext = this.mContext;
    this.ODY = new o(paramContext);
    this.ODZ = new o(paramContext);
    this.mRecyclerView = new RecyclerView(this.mContext);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.mRecyclerView.setFocusable(false);
    this.mRecyclerView.setLayoutParams(paramContext);
    this.mRecyclerView.setHasFixedSize(true);
    this.mRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.mRecyclerView.setItemViewCacheSize(20);
    this.mRecyclerView.setPadding(0, 0, 0, 0);
    this.OEa = new a();
    this.OEa.OEf = this.ODY;
    this.OEa.tp = this.OEd;
    this.mRecyclerView.setAdapter(this.OEa);
    if (this.tZx != null) {
      this.tZx.setCustomView(this.mRecyclerView);
    }
    BottomSheetBehavior.cg((View)this.tZx.oFW.getParent()).D(com.tencent.mm.ci.a.ks(this.mRecyclerView.getContext()));
    AppMethodBeat.o(267717);
  }
  
  public final void a(o paramo, q.g paramg)
  {
    this.ODZ = paramo;
    this.ODV = paramg;
  }
  
  public final void a(g.a parama)
  {
    this.tZx.YnF = parama;
  }
  
  public final void ah(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(267719);
    this.tZx.ah(paramCharSequence);
    AppMethodBeat.o(267719);
  }
  
  public final void eik()
  {
    AppMethodBeat.i(267721);
    if (this.ODT != null) {
      this.ODT.onCreateMMMenu(this.ODY);
    }
    this.mRecyclerView.setPadding(0, 0, 0, 0);
    if ((this.ODZ != null) && (this.OEa != null)) {
      this.OEa.alc.notifyChanged();
    }
    this.tZx.eik();
    AppMethodBeat.o(267721);
  }
  
  public final void gIa()
  {
    AppMethodBeat.i(267720);
    if (this.OEa != null) {
      this.OEa.alc.notifyChanged();
    }
    this.tZx.eik();
    AppMethodBeat.o(267720);
  }
  
  public final void setTitleView(View paramView)
  {
    AppMethodBeat.i(267718);
    this.tZx.iL(paramView);
    AppMethodBeat.o(267718);
  }
  
  public final class a
    extends RecyclerView.a<a>
  {
    o OEf;
    AdapterView.OnItemClickListener tp;
    
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(269708);
      int i = this.OEf.size();
      int j = a.this.ODZ.size();
      AppMethodBeat.o(269708);
      return i + j;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(269707);
      if (paramInt < this.OEf.size())
      {
        AppMethodBeat.o(269707);
        return 0;
      }
      AppMethodBeat.o(269707);
      return 1;
    }
    
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener
    {
      WeImageView OEg;
      ImageView OEh;
      LinearLayout OEi;
      TextView jMg;
      TextView msF;
      WeImageView znz;
      
      public a(View paramView, int paramInt)
      {
        super();
        AppMethodBeat.i(272136);
        paramView.setOnClickListener(this);
        this.jMg = ((TextView)paramView.findViewById(a.f.title));
        this.znz = ((WeImageView)paramView.findViewById(a.f.icon));
        this.OEi = ((LinearLayout)paramView.findViewById(a.f.root));
        if (a.this.OEb)
        {
          this.OEg = ((WeImageView)paramView.findViewById(a.f.radio));
          this.msF = ((TextView)paramView.findViewById(a.f.desc));
          this.OEh = ((ImageView)paramView.findViewById(a.f.divider));
          if (paramInt == 1)
          {
            paramView = (LinearLayout.LayoutParams)this.OEh.getLayoutParams();
            paramView.setMargins(0, 0, 0, 0);
            this.OEh.setLayoutParams(paramView);
            this.OEg.setImageResource(a.h.icons_outlined_arrow);
            this.OEg.setIconColor(a.this.mContext.getResources().getColor(a.c.FG_2));
          }
        }
        AppMethodBeat.o(272136);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(272138);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (a.a.this.tp != null) {
          a.a.this.tp.onItemClick(null, paramView, getPosition(), getPosition());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(272138);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.a
 * JD-Core Version:    0.7.0.1
 */