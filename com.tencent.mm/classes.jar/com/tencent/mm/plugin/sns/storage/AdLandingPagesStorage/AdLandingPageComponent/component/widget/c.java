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
  public boolean ctF;
  private RecyclerView fPw;
  public Map<Integer, a> wYI;
  private LinearLayoutManager wYJ;
  public b xes;
  
  public c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(96948);
    this.wYI = new HashMap();
    this.ctF = true;
    this.fPw = paramRecyclerView;
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
    this.xes = ((b)paramRecyclerView.getAdapter());
    this.wYJ = ((LinearLayoutManager)paramRecyclerView.getLayoutManager());
    this.fPw.a(new c(paramRecyclerView, (LinearLayoutManager)paramRecyclerView.getLayoutManager()));
    AppMethodBeat.o(96948);
  }
  
  private void hd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96951);
    if (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.wYI.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.wYI.put(Integer.valueOf(paramInt1), locala1);
      }
      if (this.xes.MN(paramInt1))
      {
        if (locala1.wVd) {
          break label103;
        }
        this.xes.a(paramInt1, this);
        locala1.dvK();
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label103:
        if (this.xes.MO(paramInt1)) {
          this.xes.MP(paramInt1);
        }
      }
    }
    AppMethodBeat.o(96951);
  }
  
  public final void dvJ()
  {
    AppMethodBeat.i(96950);
    if (!this.ctF)
    {
      AppMethodBeat.o(96950);
      return;
    }
    if (this.wYJ != null)
    {
      int i = this.wYJ.jO();
      int j = this.wYJ.jQ();
      ad.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == j) && (i == -1))
      {
        ad.i("RecyclerViewExposureMgr", "no exposuring child");
        AppMethodBeat.o(96950);
        return;
      }
      hd(i, j);
    }
    AppMethodBeat.o(96950);
  }
  
  public final void dwJ()
  {
    AppMethodBeat.i(96949);
    if (!this.ctF)
    {
      AppMethodBeat.o(96949);
      return;
    }
    dvJ();
    int i = this.wYJ.jO();
    int j = this.wYJ.jQ();
    Iterator localIterator = this.wYI.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() < i) || (((Integer)localEntry.getKey()).intValue() > j))
      {
        if (((a)localEntry.getValue()).wVd)
        {
          this.xes.MM(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).dvL();
        }
      }
      else if (((a)localEntry.getValue()).wVd) {
        if (!this.xes.MN(((Integer)localEntry.getKey()).intValue()))
        {
          this.xes.MM(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).dvL();
        }
        else if (this.xes.MO(((Integer)localEntry.getKey()).intValue()))
        {
          this.xes.MP(((Integer)localEntry.getKey()).intValue());
        }
      }
    }
    AppMethodBeat.o(96949);
  }
  
  public final void dwK()
  {
    AppMethodBeat.i(96952);
    int i;
    int j;
    if (this.wYJ != null)
    {
      i = this.wYJ.jO();
      j = this.wYJ.jQ();
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
        a locala = (a)this.wYI.get(Integer.valueOf(i));
        if ((locala != null) && (locala.wVd))
        {
          this.xes.MM(i);
          locala.dvL();
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
    public boolean wVd;
    
    private a() {}
    
    final void dvK()
    {
      if (this.wVd) {
        return;
      }
      this.wVd = true;
    }
    
    final void dvL()
    {
      if (this.wVd) {
        this.wVd = false;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void MM(int paramInt);
    
    public abstract boolean MN(int paramInt);
    
    public abstract boolean MO(int paramInt);
    
    public abstract void MP(int paramInt);
    
    public abstract void a(int paramInt, c paramc);
    
    public abstract void onDestroy();
  }
  
  final class c
    extends RecyclerView.m
  {
    RecyclerView fPw;
    private LinearLayoutManager mJn;
    int wYP;
    private int wYQ;
    private int wYR;
    private long wYS;
    Runnable wYT;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(96943);
      this.wYP = 2147483647;
      this.wYQ = -1;
      this.wYR = -1;
      this.wYS = 0L;
      this.wYT = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96942);
          if (c.c.this.wYP == 1)
          {
            c.this.dwJ();
            c.c.this.fPw.postDelayed(c.c.this.wYT, 100L);
          }
          AppMethodBeat.o(96942);
        }
      };
      this.fPw = paramRecyclerView;
      this.mJn = paramLinearLayoutManager;
      AppMethodBeat.o(96943);
    }
    
    private void dvM()
    {
      AppMethodBeat.i(96944);
      this.fPw.getHandler().removeCallbacks(this.wYT);
      AppMethodBeat.o(96944);
    }
    
    private void he(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96947);
      c.a(c.this, paramInt1, paramInt2);
      AppMethodBeat.o(96947);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96946);
      b localb = new b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(96946);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(96945);
      b localb = new b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      super.b(paramRecyclerView, paramInt);
      if (paramInt != this.wYP)
      {
        if (paramInt != 1) {
          dvM();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.wYP = paramInt;
        ad.d("RecyclerViewExposureMgr", "state ".concat(String.valueOf(paramInt)));
        a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(96945);
        return;
        c.this.dwJ();
        if (this.wYP == 2)
        {
          int i = this.mJn.jO();
          int j = this.mJn.jQ();
          if (j < this.wYQ)
          {
            he(j, this.wYQ);
          }
          else if (i > this.wYR)
          {
            he(this.wYR, i);
            continue;
            dvM();
            this.fPw.postDelayed(this.wYT, 100L);
            continue;
            this.wYQ = this.mJn.jO();
            this.wYR = this.mJn.jQ();
            this.wYS = System.currentTimeMillis();
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