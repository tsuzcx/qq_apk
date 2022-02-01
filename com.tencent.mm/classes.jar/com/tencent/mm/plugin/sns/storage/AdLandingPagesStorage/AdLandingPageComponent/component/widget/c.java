package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.os.Handler;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public LinearLayoutManager Arh;
  public Map<Integer, a> KoR;
  public b KuW;
  public boolean dgo;
  private RecyclerView jLl;
  
  public c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(243962);
    this.KoR = new HashMap();
    this.dgo = true;
    this.jLl = paramRecyclerView;
    if ((paramRecyclerView.getLayoutManager() == null) || (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)))
    {
      paramRecyclerView = new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
      AppMethodBeat.o(243962);
      throw paramRecyclerView;
    }
    if ((paramRecyclerView.getAdapter() == null) || (!(paramRecyclerView.getAdapter() instanceof b)))
    {
      paramRecyclerView = new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
      AppMethodBeat.o(243962);
      throw paramRecyclerView;
    }
    this.KuW = ((b)paramRecyclerView.getAdapter());
    this.Arh = ((LinearLayoutManager)paramRecyclerView.getLayoutManager());
    this.jLl.a(new c(paramRecyclerView, (LinearLayoutManager)paramRecyclerView.getLayoutManager()));
    AppMethodBeat.o(243962);
  }
  
  private void jI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96951);
    if (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.KoR.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.KoR.put(Integer.valueOf(paramInt1), locala1);
      }
      if (this.KuW.agt(paramInt1))
      {
        if (locala1.KkF) {
          break label103;
        }
        this.KuW.a(paramInt1, this);
        locala1.fQK();
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label103:
        if (this.KuW.agu(paramInt1)) {
          this.KuW.agv(paramInt1);
        }
      }
    }
    AppMethodBeat.o(96951);
  }
  
  public final void a(g paramg, String paramString)
  {
    AppMethodBeat.i(243964);
    if (this.Arh != null)
    {
      int i = this.Arh.kJ();
      int j = this.Arh.kL();
      Log.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == j) && (i == -1))
      {
        Log.i("RecyclerViewExposureMgr", "no exposuring child");
        AppMethodBeat.o(243964);
        return;
      }
      while (i <= j)
      {
        if (((aa)paramg.Kyp.get(i)).KmB.equals(paramString))
        {
          paramString = (a)this.KoR.get(Integer.valueOf(i));
          paramg = paramString;
          if (paramString == null)
          {
            paramg = new a((byte)0);
            this.KoR.put(Integer.valueOf(i), paramg);
          }
          if ((!this.KuW.agt(i)) || (paramg.KkF)) {
            break;
          }
          this.KuW.a(i, this);
          paramg.fQK();
          AppMethodBeat.o(243964);
          return;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(243964);
  }
  
  public final void b(g paramg, String paramString)
  {
    AppMethodBeat.i(243965);
    int i;
    int j;
    if (this.Arh != null)
    {
      i = this.Arh.kJ();
      j = this.Arh.kL();
      Log.d("RecyclerViewExposureMgr", "disappear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i != j) || (i != -1)) {
        break label165;
      }
      Log.i("RecyclerViewExposureMgr", "no exposuring child");
      AppMethodBeat.o(243965);
    }
    label165:
    for (;;)
    {
      if (i <= j)
      {
        if (!((aa)paramg.Kyp.get(i)).KmB.equals(paramString))
        {
          a locala = (a)this.KoR.get(Integer.valueOf(i));
          if ((locala != null) && (locala.KkF))
          {
            this.KuW.ags(i);
            locala.fQL();
          }
        }
        i += 1;
      }
      else
      {
        AppMethodBeat.o(243965);
        return;
      }
    }
  }
  
  public final void fQJ()
  {
    AppMethodBeat.i(96950);
    if (!this.dgo)
    {
      AppMethodBeat.o(96950);
      return;
    }
    if (this.Arh != null)
    {
      int i = this.Arh.kJ();
      int j = this.Arh.kL();
      Log.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == j) && (i == -1))
      {
        Log.i("RecyclerViewExposureMgr", "no exposuring child");
        AppMethodBeat.o(96950);
        return;
      }
      jI(i, j);
    }
    AppMethodBeat.o(96950);
  }
  
  public final void fRL()
  {
    AppMethodBeat.i(96949);
    if (!this.dgo)
    {
      AppMethodBeat.o(96949);
      return;
    }
    fQJ();
    int i = this.Arh.kJ();
    int j = this.Arh.kL();
    Iterator localIterator = this.KoR.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() < i) || (((Integer)localEntry.getKey()).intValue() > j))
      {
        if (((a)localEntry.getValue()).KkF)
        {
          this.KuW.ags(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).fQL();
        }
      }
      else if (((a)localEntry.getValue()).KkF) {
        if (!this.KuW.agt(((Integer)localEntry.getKey()).intValue()))
        {
          this.KuW.ags(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).fQL();
        }
        else if (this.KuW.agu(((Integer)localEntry.getKey()).intValue()))
        {
          this.KuW.agv(((Integer)localEntry.getKey()).intValue());
        }
      }
    }
    AppMethodBeat.o(96949);
  }
  
  public final void fRM()
  {
    AppMethodBeat.i(96952);
    int i;
    int j;
    if (this.Arh != null)
    {
      i = this.Arh.kJ();
      j = this.Arh.kL();
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
        a locala = (a)this.KoR.get(Integer.valueOf(i));
        if ((locala != null) && (locala.KkF))
        {
          this.KuW.ags(i);
          locala.fQL();
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
    public boolean KkF;
    
    private a() {}
    
    public final void fQK()
    {
      if (this.KkF) {
        return;
      }
      this.KkF = true;
    }
    
    final void fQL()
    {
      if (this.KkF) {
        this.KkF = false;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, c paramc);
    
    public abstract void ags(int paramInt);
    
    public abstract boolean agt(int paramInt);
    
    public abstract boolean agu(int paramInt);
    
    public abstract void agv(int paramInt);
    
    public abstract void onDestroy();
  }
  
  final class c
    extends RecyclerView.l
  {
    private int KoX;
    private int KoY;
    private int KoZ;
    private long Kpa;
    private Runnable Kpb;
    private RecyclerView jLl;
    private LinearLayoutManager set;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(227087);
      this.KoX = 2147483647;
      this.KoY = -1;
      this.KoZ = -1;
      this.Kpa = 0L;
      this.Kpb = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96942);
          if (c.c.a(c.c.this) == 1)
          {
            c.c.b(c.c.this);
            c.c.d(c.c.this).postDelayed(c.c.c(c.c.this), 100L);
          }
          AppMethodBeat.o(96942);
        }
      };
      this.jLl = paramRecyclerView;
      this.set = paramLinearLayoutManager;
      AppMethodBeat.o(227087);
    }
    
    private void fQM()
    {
      AppMethodBeat.i(96944);
      this.jLl.getHandler().removeCallbacks(this.Kpb);
      AppMethodBeat.o(96944);
    }
    
    private void jK(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96947);
      c.a(c.this, paramInt1, paramInt2);
      AppMethodBeat.o(96947);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(227095);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt != this.KoX)
      {
        if (paramInt != 1) {
          fQM();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.KoX = paramInt;
        Log.d("RecyclerViewExposureMgr", "state ".concat(String.valueOf(paramInt)));
        a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(227095);
        return;
        c.this.fRL();
        if (this.KoX == 2)
        {
          int i = this.set.kJ();
          int j = this.set.kL();
          if (j < this.KoY)
          {
            jK(j, this.KoY);
          }
          else if (i > this.KoZ)
          {
            jK(this.KoZ, i);
            continue;
            fQM();
            this.jLl.postDelayed(this.Kpb, 100L);
            continue;
            this.KoY = this.set.kJ();
            this.KoZ = this.set.kL();
            this.Kpa = System.currentTimeMillis();
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(227100);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(227100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c
 * JD-Core Version:    0.7.0.1
 */