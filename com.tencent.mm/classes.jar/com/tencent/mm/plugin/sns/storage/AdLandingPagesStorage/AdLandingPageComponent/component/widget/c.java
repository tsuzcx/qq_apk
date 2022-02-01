package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public boolean cBJ;
  private RecyclerView gmV;
  public Map<Integer, a> zCl;
  private LinearLayoutManager zCm;
  public b zIr;
  
  public c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(96948);
    this.zCl = new HashMap();
    this.cBJ = true;
    this.gmV = paramRecyclerView;
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
    this.zIr = ((b)paramRecyclerView.getAdapter());
    this.zCm = ((LinearLayoutManager)paramRecyclerView.getLayoutManager());
    this.gmV.a(new c(paramRecyclerView, (LinearLayoutManager)paramRecyclerView.getLayoutManager()));
    AppMethodBeat.o(96948);
  }
  
  private void hD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96951);
    if (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.zCl.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.zCl.put(Integer.valueOf(paramInt1), locala1);
      }
      if (this.zIr.Qy(paramInt1))
      {
        if (locala1.zxZ) {
          break label103;
        }
        this.zIr.a(paramInt1, this);
        locala1.dWx();
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label103:
        if (this.zIr.Qz(paramInt1)) {
          this.zIr.QA(paramInt1);
        }
      }
    }
    AppMethodBeat.o(96951);
  }
  
  public final void dWw()
  {
    AppMethodBeat.i(96950);
    if (!this.cBJ)
    {
      AppMethodBeat.o(96950);
      return;
    }
    if (this.zCm != null)
    {
      int i = this.zCm.km();
      int j = this.zCm.ko();
      ad.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == j) && (i == -1))
      {
        ad.i("RecyclerViewExposureMgr", "no exposuring child");
        AppMethodBeat.o(96950);
        return;
      }
      hD(i, j);
    }
    AppMethodBeat.o(96950);
  }
  
  public final void dXA()
  {
    AppMethodBeat.i(96952);
    int i;
    int j;
    if (this.zCm != null)
    {
      i = this.zCm.km();
      j = this.zCm.ko();
      ad.d("RecyclerViewExposureMgr", "disappear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i != j) || (i != -1)) {
        break label136;
      }
      ad.i("RecyclerViewExposureMgr", "no exposuring child");
      AppMethodBeat.o(96952);
    }
    label136:
    for (;;)
    {
      if (i <= j)
      {
        a locala = (a)this.zCl.get(Integer.valueOf(i));
        if ((locala != null) && (locala.zxZ))
        {
          this.zIr.Qx(i);
          locala.dWy();
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
  
  public final void dXz()
  {
    AppMethodBeat.i(96949);
    if (!this.cBJ)
    {
      AppMethodBeat.o(96949);
      return;
    }
    dWw();
    int i = this.zCm.km();
    int j = this.zCm.ko();
    Iterator localIterator = this.zCl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() < i) || (((Integer)localEntry.getKey()).intValue() > j))
      {
        if (((a)localEntry.getValue()).zxZ)
        {
          this.zIr.Qx(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).dWy();
        }
      }
      else if (((a)localEntry.getValue()).zxZ) {
        if (!this.zIr.Qy(((Integer)localEntry.getKey()).intValue()))
        {
          this.zIr.Qx(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).dWy();
        }
        else if (this.zIr.Qz(((Integer)localEntry.getKey()).intValue()))
        {
          this.zIr.QA(((Integer)localEntry.getKey()).intValue());
        }
      }
    }
    AppMethodBeat.o(96949);
  }
  
  public final class a
  {
    public boolean zxZ;
    
    private a() {}
    
    final void dWx()
    {
      if (this.zxZ) {
        return;
      }
      this.zxZ = true;
    }
    
    final void dWy()
    {
      if (this.zxZ) {
        this.zxZ = false;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void QA(int paramInt);
    
    public abstract void Qx(int paramInt);
    
    public abstract boolean Qy(int paramInt);
    
    public abstract boolean Qz(int paramInt);
    
    public abstract void a(int paramInt, c paramc);
    
    public abstract void onDestroy();
  }
  
  final class c
    extends RecyclerView.m
  {
    RecyclerView gmV;
    private LinearLayoutManager nLX;
    int zCs;
    private int zCt;
    private int zCu;
    private long zCv;
    Runnable zCw;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(96943);
      this.zCs = 2147483647;
      this.zCt = -1;
      this.zCu = -1;
      this.zCv = 0L;
      this.zCw = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96942);
          if (c.c.this.zCs == 1)
          {
            c.this.dXz();
            c.c.this.gmV.postDelayed(c.c.this.zCw, 100L);
          }
          AppMethodBeat.o(96942);
        }
      };
      this.gmV = paramRecyclerView;
      this.nLX = paramLinearLayoutManager;
      AppMethodBeat.o(96943);
    }
    
    private void dWz()
    {
      AppMethodBeat.i(96944);
      this.gmV.getHandler().removeCallbacks(this.zCw);
      AppMethodBeat.o(96944);
    }
    
    private void hE(int paramInt1, int paramInt2)
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
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(96946);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(96945);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      super.b(paramRecyclerView, paramInt);
      if (paramInt != this.zCs)
      {
        if (paramInt != 1) {
          dWz();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.zCs = paramInt;
        ad.d("RecyclerViewExposureMgr", "state ".concat(String.valueOf(paramInt)));
        a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(96945);
        return;
        c.this.dXz();
        if (this.zCs == 2)
        {
          int i = this.nLX.km();
          int j = this.nLX.ko();
          if (j < this.zCt)
          {
            hE(j, this.zCt);
          }
          else if (i > this.zCu)
          {
            hE(this.zCu, i);
            continue;
            dWz();
            this.gmV.postDelayed(this.zCw, 100L);
            continue;
            this.zCt = this.nLX.km();
            this.zCu = this.nLX.ko();
            this.zCv = System.currentTimeMillis();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c
 * JD-Core Version:    0.7.0.1
 */