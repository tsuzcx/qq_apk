package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public Map<Integer, a> Ebw;
  public b EhP;
  public boolean cQp;
  private RecyclerView hak;
  private LinearLayoutManager vKp;
  
  public c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(96948);
    this.Ebw = new HashMap();
    this.cQp = true;
    this.hak = paramRecyclerView;
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
    this.EhP = ((b)paramRecyclerView.getAdapter());
    this.vKp = ((LinearLayoutManager)paramRecyclerView.getLayoutManager());
    this.hak.a(new c(paramRecyclerView, (LinearLayoutManager)paramRecyclerView.getLayoutManager()));
    AppMethodBeat.o(96948);
  }
  
  private void iz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96951);
    if (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.Ebw.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.Ebw.put(Integer.valueOf(paramInt1), locala1);
      }
      if (this.EhP.Zd(paramInt1))
      {
        if (locala1.DXw) {
          break label103;
        }
        this.EhP.a(paramInt1, this);
        locala1.fcT();
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label103:
        if (this.EhP.Ze(paramInt1)) {
          this.EhP.Zf(paramInt1);
        }
      }
    }
    AppMethodBeat.o(96951);
  }
  
  public final void fcS()
  {
    AppMethodBeat.i(96950);
    if (!this.cQp)
    {
      AppMethodBeat.o(96950);
      return;
    }
    if (this.vKp != null)
    {
      int i = this.vKp.ks();
      int j = this.vKp.ku();
      Log.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == j) && (i == -1))
      {
        Log.i("RecyclerViewExposureMgr", "no exposuring child");
        AppMethodBeat.o(96950);
        return;
      }
      iz(i, j);
    }
    AppMethodBeat.o(96950);
  }
  
  public final void fdT()
  {
    AppMethodBeat.i(96949);
    if (!this.cQp)
    {
      AppMethodBeat.o(96949);
      return;
    }
    fcS();
    int i = this.vKp.ks();
    int j = this.vKp.ku();
    Iterator localIterator = this.Ebw.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() < i) || (((Integer)localEntry.getKey()).intValue() > j))
      {
        if (((a)localEntry.getValue()).DXw)
        {
          this.EhP.Zc(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).fcU();
        }
      }
      else if (((a)localEntry.getValue()).DXw) {
        if (!this.EhP.Zd(((Integer)localEntry.getKey()).intValue()))
        {
          this.EhP.Zc(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).fcU();
        }
        else if (this.EhP.Ze(((Integer)localEntry.getKey()).intValue()))
        {
          this.EhP.Zf(((Integer)localEntry.getKey()).intValue());
        }
      }
    }
    AppMethodBeat.o(96949);
  }
  
  public final void fdU()
  {
    AppMethodBeat.i(96952);
    int i;
    int j;
    if (this.vKp != null)
    {
      i = this.vKp.ks();
      j = this.vKp.ku();
      Log.d("RecyclerViewExposureMgr", "disappear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i != j) || (i != -1)) {
        break label136;
      }
      Log.i("RecyclerViewExposureMgr", "no exposuring child");
      AppMethodBeat.o(96952);
    }
    label136:
    for (;;)
    {
      if (i <= j)
      {
        a locala = (a)this.Ebw.get(Integer.valueOf(i));
        if ((locala != null) && (locala.DXw))
        {
          this.EhP.Zc(i);
          locala.fcU();
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
    public boolean DXw;
    
    private a() {}
    
    final void fcT()
    {
      if (this.DXw) {
        return;
      }
      this.DXw = true;
    }
    
    final void fcU()
    {
      if (this.DXw) {
        this.DXw = false;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void Zc(int paramInt);
    
    public abstract boolean Zd(int paramInt);
    
    public abstract boolean Ze(int paramInt);
    
    public abstract void Zf(int paramInt);
    
    public abstract void a(int paramInt, c paramc);
    
    public abstract void onDestroy();
  }
  
  final class c
    extends RecyclerView.l
  {
    int EbC;
    private int EbD;
    private int EbE;
    private long EbF;
    Runnable EbG;
    RecyclerView hak;
    private LinearLayoutManager pcs;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(96943);
      this.EbC = 2147483647;
      this.EbD = -1;
      this.EbE = -1;
      this.EbF = 0L;
      this.EbG = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96942);
          if (c.c.this.EbC == 1)
          {
            c.this.fdT();
            c.c.this.hak.postDelayed(c.c.this.EbG, 100L);
          }
          AppMethodBeat.o(96942);
        }
      };
      this.hak = paramRecyclerView;
      this.pcs = paramLinearLayoutManager;
      AppMethodBeat.o(96943);
    }
    
    private void fcV()
    {
      AppMethodBeat.i(96944);
      this.hak.getHandler().removeCallbacks(this.EbG);
      AppMethodBeat.o(96944);
    }
    
    private void iB(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96947);
      c.a(c.this, paramInt1, paramInt2);
      AppMethodBeat.o(96947);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(96945);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt != this.EbC)
      {
        if (paramInt != 1) {
          fcV();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.EbC = paramInt;
        Log.d("RecyclerViewExposureMgr", "state ".concat(String.valueOf(paramInt)));
        a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(96945);
        return;
        c.this.fdT();
        if (this.EbC == 2)
        {
          int i = this.pcs.ks();
          int j = this.pcs.ku();
          if (j < this.EbD)
          {
            iB(j, this.EbD);
          }
          else if (i > this.EbE)
          {
            iB(this.EbE, i);
            continue;
            fcV();
            this.hak.postDelayed(this.EbG, 100L);
            continue;
            this.EbD = this.pcs.ks();
            this.EbE = this.pcs.ku();
            this.EbF = System.currentTimeMillis();
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96946);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(96946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c
 * JD-Core Version:    0.7.0.1
 */