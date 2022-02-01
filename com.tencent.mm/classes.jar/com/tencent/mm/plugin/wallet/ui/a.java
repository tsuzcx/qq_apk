package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o.b;
import com.tencent.mm.ui.base.o.c;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;

public final class a
{
  public o.f HLX;
  o.g HLY;
  o.g HLZ;
  o.b HMa;
  o.c HMb;
  m HMc;
  m HMd;
  a HMe;
  public boolean HMf;
  public boolean HMg;
  private AdapterView.OnItemClickListener HMh;
  public int jKz;
  Context mContext;
  private RecyclerView mRecyclerView;
  public final g qAx;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(214106);
    this.HMf = false;
    this.HMg = false;
    this.jKz = 0;
    this.HMh = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(214099);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (paramAnonymousInt >= a.this.HMc.size() + a.this.HMd.size())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(214099);
          return;
        }
        if (paramAnonymousInt < a.this.HMc.size())
        {
          paramAnonymousAdapterView = (n)a.this.HMc.ORD.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.neT))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(214099);
            return;
          }
          if (a.this.HLY != null)
          {
            a.this.HLY.onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
            a.this.jKz = paramAnonymousInt;
          }
        }
        for (;;)
        {
          a.this.HMe.atj.notifyChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(214099);
          return;
          paramAnonymousAdapterView.performClick();
          break;
          if ((a.this.HMd.size() > 0) && (paramAnonymousInt < a.this.HMc.size() + a.this.HMd.size()))
          {
            paramAnonymousAdapterView = (n)a.this.HMd.ORD.get(paramAnonymousInt - a.this.HMc.size());
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.neT))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(214099);
              return;
            }
            if (a.this.HLZ != null) {
              a.this.HLZ.onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
            }
          }
        }
      }
    };
    this.mContext = paramContext;
    this.qAx = new g(paramContext, 2, 3);
    paramContext = this.mContext;
    this.HMc = new m(paramContext);
    this.HMd = new m(paramContext);
    this.mRecyclerView = new RecyclerView(this.mContext);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.mRecyclerView.setFocusable(false);
    this.mRecyclerView.setLayoutParams(paramContext);
    this.mRecyclerView.setHasFixedSize(true);
    this.mRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.mRecyclerView.setItemViewCacheSize(20);
    this.mRecyclerView.setPadding(0, 0, 0, 0);
    this.HMe = new a();
    this.HMe.HMj = this.HMc;
    this.HMe.ars = this.HMh;
    this.mRecyclerView.setAdapter(this.HMe);
    if (this.qAx != null) {
      this.qAx.setCustomView(this.mRecyclerView);
    }
    BottomSheetBehavior.l((View)this.qAx.lJI.getParent()).J(com.tencent.mm.cb.a.jo(this.mRecyclerView.getContext()));
    AppMethodBeat.o(214106);
  }
  
  public final void T(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(214108);
    this.qAx.T(paramCharSequence);
    AppMethodBeat.o(214108);
  }
  
  public final void a(m paramm, o.g paramg)
  {
    this.HMd = paramm;
    this.HLZ = paramg;
  }
  
  public final void a(g.a parama)
  {
    this.qAx.QOT = parama;
  }
  
  public final void dGm()
  {
    AppMethodBeat.i(214110);
    if (this.HLX != null) {
      this.HLX.onCreateMMMenu(this.HMc);
    }
    this.mRecyclerView.setPadding(0, 0, 0, 0);
    if ((this.HMd != null) && (this.HMe != null)) {
      this.HMe.atj.notifyChanged();
    }
    this.qAx.dGm();
    AppMethodBeat.o(214110);
  }
  
  public final void fPw()
  {
    AppMethodBeat.i(214109);
    if (this.HMe != null) {
      this.HMe.atj.notifyChanged();
    }
    this.qAx.dGm();
    AppMethodBeat.o(214109);
  }
  
  public final void setTitleView(View paramView)
  {
    AppMethodBeat.i(214107);
    this.qAx.hv(paramView);
    AppMethodBeat.o(214107);
  }
  
  public final class a
    extends RecyclerView.a<a>
  {
    m HMj;
    AdapterView.OnItemClickListener ars;
    
    public a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(214103);
      int i = this.HMj.size();
      int j = a.this.HMd.size();
      AppMethodBeat.o(214103);
      return i + j;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(214102);
      if (paramInt < this.HMj.size())
      {
        AppMethodBeat.o(214102);
        return 0;
      }
      AppMethodBeat.o(214102);
      return 1;
    }
    
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener
    {
      WeImageView HMk;
      ImageView HMl;
      LinearLayout HMm;
      TextView hbb;
      TextView jCB;
      WeImageView uGm;
      
      public a(View paramView, int paramInt)
      {
        super();
        AppMethodBeat.i(214100);
        paramView.setOnClickListener(this);
        this.hbb = ((TextView)paramView.findViewById(2131309195));
        this.uGm = ((WeImageView)paramView.findViewById(2131302468));
        this.HMm = ((LinearLayout)paramView.findViewById(2131307157));
        if (a.this.HMf)
        {
          this.HMk = ((WeImageView)paramView.findViewById(2131306483));
          this.jCB = ((TextView)paramView.findViewById(2131299495));
          this.HMl = ((ImageView)paramView.findViewById(2131299682));
          if (paramInt == 1)
          {
            paramView = (LinearLayout.LayoutParams)this.HMl.getLayoutParams();
            paramView.setMargins(0, 0, 0, 0);
            this.HMl.setLayoutParams(paramView);
            this.HMk.setImageResource(2131690737);
            this.HMk.setIconColor(a.this.mContext.getResources().getColor(2131099749));
          }
        }
        AppMethodBeat.o(214100);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(214101);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (a.a.this.ars != null) {
          a.a.this.ars.onItemClick(null, paramView, getPosition(), getPosition());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(214101);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.a
 * JD-Core Version:    0.7.0.1
 */