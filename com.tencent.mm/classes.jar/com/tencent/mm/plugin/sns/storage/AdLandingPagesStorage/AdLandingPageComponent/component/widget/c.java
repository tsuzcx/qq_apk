package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public boolean cCq;
  private RecyclerView gpr;
  public Map<Integer, a> zTn;
  private LinearLayoutManager zTo;
  public b zZy;
  
  public c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(96948);
    this.zTn = new HashMap();
    this.cCq = true;
    this.gpr = paramRecyclerView;
    if ((paramRecyclerView.getLayoutManager() == null) || (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)))
    {
      paramRecyclerView = new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
      AppMethodBeat.o(96948);
      throw paramRecyclerView;
    }
    if ((paramRecyclerView.getAdapter() == null) || (!(paramRecyclerView.getAdapter() instanceof b)))
    {
      paramRecyclerView = new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
      AppMethodBeat.o(96948);
      throw paramRecyclerView;
    }
    this.zZy = ((b)paramRecyclerView.getAdapter());
    this.zTo = ((LinearLayoutManager)paramRecyclerView.getLayoutManager());
    this.gpr.a(new c(paramRecyclerView, (LinearLayoutManager)paramRecyclerView.getLayoutManager()));
    AppMethodBeat.o(96948);
  }
  
  private void hG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96951);
    if (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.zTn.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.zTn.put(Integer.valueOf(paramInt1), locala1);
      }
      if (this.zZy.Rf(paramInt1))
      {
        if (locala1.zPy) {
          break label103;
        }
        this.zZy.a(paramInt1, this);
        locala1.dZZ();
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label103:
        if (this.zZy.Rg(paramInt1)) {
          this.zZy.Rh(paramInt1);
        }
      }
    }
    AppMethodBeat.o(96951);
  }
  
  public final void dZY()
  {
    AppMethodBeat.i(96950);
    if (!this.cCq)
    {
      AppMethodBeat.o(96950);
      return;
    }
    if (this.zTo != null)
    {
      int i = this.zTo.km();
      int j = this.zTo.ko();
      ae.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == j) && (i == -1))
      {
        ae.i("RecyclerViewExposureMgr", "no exposuring child");
        AppMethodBeat.o(96950);
        return;
      }
      hG(i, j);
    }
    AppMethodBeat.o(96950);
  }
  
  public final void ebc()
  {
    AppMethodBeat.i(96949);
    if (!this.cCq)
    {
      AppMethodBeat.o(96949);
      return;
    }
    dZY();
    int i = this.zTo.km();
    int j = this.zTo.ko();
    Iterator localIterator = this.zTn.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() < i) || (((Integer)localEntry.getKey()).intValue() > j))
      {
        if (((a)localEntry.getValue()).zPy)
        {
          this.zZy.Re(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).eaa();
        }
      }
      else if (((a)localEntry.getValue()).zPy) {
        if (!this.zZy.Rf(((Integer)localEntry.getKey()).intValue()))
        {
          this.zZy.Re(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).eaa();
        }
        else if (this.zZy.Rg(((Integer)localEntry.getKey()).intValue()))
        {
          this.zZy.Rh(((Integer)localEntry.getKey()).intValue());
        }
      }
    }
    AppMethodBeat.o(96949);
  }
  
  public final void ebd()
  {
    AppMethodBeat.i(96952);
    int i;
    int j;
    if (this.zTo != null)
    {
      i = this.zTo.km();
      j = this.zTo.ko();
      ae.d("RecyclerViewExposureMgr", "disappear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i != j) || (i != -1)) {
        break label136;
      }
      ae.i("RecyclerViewExposureMgr", "no exposuring child");
      AppMethodBeat.o(96952);
    }
    label136:
    for (;;)
    {
      if (i <= j)
      {
        a locala = (a)this.zTn.get(Integer.valueOf(i));
        if ((locala != null) && (locala.zPy))
        {
          this.zZy.Re(i);
          locala.eaa();
        }
        i += 1;
      }
      else
      {
        AppMethodBeat.o(96952);
        return;
      }
    }
  }
  
  public final class a
  {
    public boolean zPy;
    
    private a() {}
    
    final void dZZ()
    {
      if (this.zPy) {
        return;
      }
      this.zPy = true;
    }
    
    final void eaa()
    {
      if (this.zPy) {
        this.zPy = false;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void Re(int paramInt);
    
    public abstract boolean Rf(int paramInt);
    
    public abstract boolean Rg(int paramInt);
    
    public abstract void Rh(int paramInt);
    
    public abstract void a(int paramInt, c paramc);
    
    public abstract void onDestroy();
  }
  
  final class c
    extends RecyclerView.m
  {
    RecyclerView gpr;
    private LinearLayoutManager nRC;
    int zTu;
    private int zTv;
    private int zTw;
    private long zTx;
    Runnable zTy;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(96943);
      this.zTu = 2147483647;
      this.zTv = -1;
      this.zTw = -1;
      this.zTx = 0L;
      this.zTy = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96942);
          if (c.c.this.zTu == 1)
          {
            c.this.ebc();
            c.c.this.gpr.postDelayed(c.c.this.zTy, 100L);
          }
          AppMethodBeat.o(96942);
        }
      };
      this.gpr = paramRecyclerView;
      this.nRC = paramLinearLayoutManager;
      AppMethodBeat.o(96943);
    }
    
    private void eab()
    {
      AppMethodBeat.i(96944);
      this.gpr.getHandler().removeCallbacks(this.zTy);
      AppMethodBeat.o(96944);
    }
    
    private void hH(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96947);
      c.a(c.this, paramInt1, paramInt2);
      AppMethodBeat.o(96947);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96946);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(96946);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(96945);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      super.b(paramRecyclerView, paramInt);
      if (paramInt != this.zTu)
      {
        if (paramInt != 1) {
          eab();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.zTu = paramInt;
        ae.d("RecyclerViewExposureMgr", "state ".concat(String.valueOf(paramInt)));
        a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(96945);
        return;
        c.this.ebc();
        if (this.zTu == 2)
        {
          int i = this.nRC.km();
          int j = this.nRC.ko();
          if (j < this.zTv)
          {
            hH(j, this.zTv);
          }
          else if (i > this.zTw)
          {
            hH(this.zTw, i);
            continue;
            eab();
            this.gpr.postDelayed(this.zTy, 100L);
            continue;
            this.zTv = this.nRC.km();
            this.zTw = this.nRC.ko();
            this.zTx = System.currentTimeMillis();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c
 * JD-Core Version:    0.7.0.1
 */