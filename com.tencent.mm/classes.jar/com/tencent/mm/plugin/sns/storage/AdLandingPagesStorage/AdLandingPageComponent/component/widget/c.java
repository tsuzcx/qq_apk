package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public boolean cqM;
  private RecyclerView fTr;
  public Map<Integer, a> ylw;
  private LinearLayoutManager ylx;
  public b yrh;
  
  public c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(96948);
    this.ylw = new HashMap();
    this.cqM = true;
    this.fTr = paramRecyclerView;
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
    this.yrh = ((b)paramRecyclerView.getAdapter());
    this.ylx = ((LinearLayoutManager)paramRecyclerView.getLayoutManager());
    this.fTr.a(new c(paramRecyclerView, (LinearLayoutManager)paramRecyclerView.getLayoutManager()));
    AppMethodBeat.o(96948);
  }
  
  private void hm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96951);
    if (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.ylw.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.ylw.put(Integer.valueOf(paramInt1), locala1);
      }
      if (this.yrh.OQ(paramInt1))
      {
        if (locala1.yhR) {
          break label103;
        }
        this.yrh.a(paramInt1, this);
        locala1.dKj();
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label103:
        if (this.yrh.OR(paramInt1)) {
          this.yrh.OS(paramInt1);
        }
      }
    }
    AppMethodBeat.o(96951);
  }
  
  public final void dKi()
  {
    AppMethodBeat.i(96950);
    if (!this.cqM)
    {
      AppMethodBeat.o(96950);
      return;
    }
    if (this.ylx != null)
    {
      int i = this.ylx.jW();
      int j = this.ylx.jY();
      ac.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == j) && (i == -1))
      {
        ac.i("RecyclerViewExposureMgr", "no exposuring child");
        AppMethodBeat.o(96950);
        return;
      }
      hm(i, j);
    }
    AppMethodBeat.o(96950);
  }
  
  public final void dLi()
  {
    AppMethodBeat.i(96949);
    if (!this.cqM)
    {
      AppMethodBeat.o(96949);
      return;
    }
    dKi();
    int i = this.ylx.jW();
    int j = this.ylx.jY();
    Iterator localIterator = this.ylw.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() < i) || (((Integer)localEntry.getKey()).intValue() > j))
      {
        if (((a)localEntry.getValue()).yhR)
        {
          this.yrh.OP(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).dKk();
        }
      }
      else if (((a)localEntry.getValue()).yhR) {
        if (!this.yrh.OQ(((Integer)localEntry.getKey()).intValue()))
        {
          this.yrh.OP(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).dKk();
        }
        else if (this.yrh.OR(((Integer)localEntry.getKey()).intValue()))
        {
          this.yrh.OS(((Integer)localEntry.getKey()).intValue());
        }
      }
    }
    AppMethodBeat.o(96949);
  }
  
  public final void dLj()
  {
    AppMethodBeat.i(96952);
    int i;
    int j;
    if (this.ylx != null)
    {
      i = this.ylx.jW();
      j = this.ylx.jY();
      ac.d("RecyclerViewExposureMgr", "disappear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i != j) || (i != -1)) {
        break label136;
      }
      ac.i("RecyclerViewExposureMgr", "no exposuring child");
      AppMethodBeat.o(96952);
    }
    label136:
    for (;;)
    {
      if (i <= j)
      {
        a locala = (a)this.ylw.get(Integer.valueOf(i));
        if ((locala != null) && (locala.yhR))
        {
          this.yrh.OP(i);
          locala.dKk();
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
    public boolean yhR;
    
    private a() {}
    
    final void dKj()
    {
      if (this.yhR) {
        return;
      }
      this.yhR = true;
    }
    
    final void dKk()
    {
      if (this.yhR) {
        this.yhR = false;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void OP(int paramInt);
    
    public abstract boolean OQ(int paramInt);
    
    public abstract boolean OR(int paramInt);
    
    public abstract void OS(int paramInt);
    
    public abstract void a(int paramInt, c paramc);
    
    public abstract void onDestroy();
  }
  
  final class c
    extends RecyclerView.m
  {
    RecyclerView fTr;
    private LinearLayoutManager nlq;
    int ylD;
    private int ylE;
    private int ylF;
    private long ylG;
    Runnable ylH;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(96943);
      this.ylD = 2147483647;
      this.ylE = -1;
      this.ylF = -1;
      this.ylG = 0L;
      this.ylH = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96942);
          if (c.c.this.ylD == 1)
          {
            c.this.dLi();
            c.c.this.fTr.postDelayed(c.c.this.ylH, 100L);
          }
          AppMethodBeat.o(96942);
        }
      };
      this.fTr = paramRecyclerView;
      this.nlq = paramLinearLayoutManager;
      AppMethodBeat.o(96943);
    }
    
    private void dKl()
    {
      AppMethodBeat.i(96944);
      this.fTr.getHandler().removeCallbacks(this.ylH);
      AppMethodBeat.o(96944);
    }
    
    private void hn(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96947);
      c.a(c.this, paramInt1, paramInt2);
      AppMethodBeat.o(96947);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96946);
      b localb = new b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(96946);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(96945);
      b localb = new b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      super.b(paramRecyclerView, paramInt);
      if (paramInt != this.ylD)
      {
        if (paramInt != 1) {
          dKl();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.ylD = paramInt;
        ac.d("RecyclerViewExposureMgr", "state ".concat(String.valueOf(paramInt)));
        a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(96945);
        return;
        c.this.dLi();
        if (this.ylD == 2)
        {
          int i = this.nlq.jW();
          int j = this.nlq.jY();
          if (j < this.ylE)
          {
            hn(j, this.ylE);
          }
          else if (i > this.ylF)
          {
            hn(this.ylF, i);
            continue;
            dKl();
            this.fTr.postDelayed(this.ylH, 100L);
            continue;
            this.ylE = this.nlq.jW();
            this.ylF = this.nlq.jY();
            this.ylG = System.currentTimeMillis();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c
 * JD-Core Version:    0.7.0.1
 */