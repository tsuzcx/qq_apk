package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.os.Handler;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  public LinearLayoutManager AJH;
  public Map<Integer, a> QMY;
  public b QTG;
  public boolean ffv;
  private RecyclerView mkw;
  
  public b(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(307261);
    this.QMY = new HashMap();
    this.ffv = true;
    this.mkw = paramRecyclerView;
    if ((paramRecyclerView.getLayoutManager() == null) || (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)))
    {
      paramRecyclerView = new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
      AppMethodBeat.o(307261);
      throw paramRecyclerView;
    }
    if ((paramRecyclerView.getAdapter() == null) || (!(paramRecyclerView.getAdapter() instanceof b)))
    {
      paramRecyclerView = new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
      AppMethodBeat.o(307261);
      throw paramRecyclerView;
    }
    this.QTG = ((b)paramRecyclerView.getAdapter());
    this.AJH = ((LinearLayoutManager)paramRecyclerView.getLayoutManager());
    this.mkw.a(new c(paramRecyclerView, (LinearLayoutManager)paramRecyclerView.getLayoutManager()));
    AppMethodBeat.o(307261);
  }
  
  private void lu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96951);
    if (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.QMY.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.QMY.put(Integer.valueOf(paramInt1), locala1);
      }
      if (this.QTG.all(paramInt1))
      {
        if (locala1.QIM) {
          break label103;
        }
        this.QTG.a(paramInt1, this);
        locala1.hiI();
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label103:
        if (this.QTG.alm(paramInt1)) {
          this.QTG.aln(paramInt1);
        }
      }
    }
    AppMethodBeat.o(96951);
  }
  
  public final void a(h paramh, String paramString)
  {
    AppMethodBeat.i(307266);
    if (this.AJH != null)
    {
      int i = this.AJH.Ju();
      int j = this.AJH.Jw();
      Log.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == j) && (i == -1))
      {
        Log.i("RecyclerViewExposureMgr", "no exposuring child");
        AppMethodBeat.o(307266);
        return;
      }
      while (i <= j)
      {
        if (((aa)paramh.QXi.get(i)).QKG.equals(paramString))
        {
          paramString = (a)this.QMY.get(Integer.valueOf(i));
          paramh = paramString;
          if (paramString == null)
          {
            paramh = new a((byte)0);
            this.QMY.put(Integer.valueOf(i), paramh);
          }
          if ((!this.QTG.all(i)) || (paramh.QIM)) {
            break;
          }
          this.QTG.a(i, this);
          paramh.hiI();
          AppMethodBeat.o(307266);
          return;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(307266);
  }
  
  public final void b(h paramh, String paramString)
  {
    AppMethodBeat.i(307268);
    int i;
    int j;
    if (this.AJH != null)
    {
      i = this.AJH.Ju();
      j = this.AJH.Jw();
      Log.d("RecyclerViewExposureMgr", "disappear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i != j) || (i != -1)) {
        break label165;
      }
      Log.i("RecyclerViewExposureMgr", "no exposuring child");
      AppMethodBeat.o(307268);
    }
    label165:
    for (;;)
    {
      if (i <= j)
      {
        if (!((aa)paramh.QXi.get(i)).QKG.equals(paramString))
        {
          a locala = (a)this.QMY.get(Integer.valueOf(i));
          if ((locala != null) && (locala.QIM))
          {
            this.QTG.alk(i);
            locala.hiJ();
          }
        }
        i += 1;
      }
      else
      {
        AppMethodBeat.o(307268);
        return;
      }
    }
  }
  
  public final void hiH()
  {
    AppMethodBeat.i(96950);
    if (!this.ffv)
    {
      AppMethodBeat.o(96950);
      return;
    }
    if (this.AJH != null)
    {
      int i = this.AJH.Ju();
      int j = this.AJH.Jw();
      Log.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == j) && (i == -1))
      {
        Log.i("RecyclerViewExposureMgr", "no exposuring child");
        AppMethodBeat.o(96950);
        return;
      }
      lu(i, j);
    }
    AppMethodBeat.o(96950);
  }
  
  public final void hjQ()
  {
    AppMethodBeat.i(96949);
    if (!this.ffv)
    {
      AppMethodBeat.o(96949);
      return;
    }
    hiH();
    int i = this.AJH.Ju();
    int j = this.AJH.Jw();
    Iterator localIterator = this.QMY.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() < i) || (((Integer)localEntry.getKey()).intValue() > j))
      {
        if (((a)localEntry.getValue()).QIM)
        {
          this.QTG.alk(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).hiJ();
        }
      }
      else if (((a)localEntry.getValue()).QIM) {
        if (!this.QTG.all(((Integer)localEntry.getKey()).intValue()))
        {
          this.QTG.alk(((Integer)localEntry.getKey()).intValue());
          ((a)localEntry.getValue()).hiJ();
        }
        else if (this.QTG.alm(((Integer)localEntry.getKey()).intValue()))
        {
          this.QTG.aln(((Integer)localEntry.getKey()).intValue());
        }
      }
    }
    AppMethodBeat.o(96949);
  }
  
  public final void hjR()
  {
    AppMethodBeat.i(96952);
    int i;
    int j;
    if (this.AJH != null)
    {
      i = this.AJH.Ju();
      j = this.AJH.Jw();
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
        a locala = (a)this.QMY.get(Integer.valueOf(i));
        if ((locala != null) && (locala.QIM))
        {
          this.QTG.alk(i);
          locala.hiJ();
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
    public boolean QIM;
    
    private a() {}
    
    public final void hiI()
    {
      if (this.QIM) {
        return;
      }
      this.QIM = true;
    }
    
    final void hiJ()
    {
      if (this.QIM) {
        this.QIM = false;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, b paramb);
    
    public abstract void alk(int paramInt);
    
    public abstract boolean all(int paramInt);
    
    public abstract boolean alm(int paramInt);
    
    public abstract void aln(int paramInt);
    
    public abstract void onDestroy();
  }
  
  final class c
    extends RecyclerView.l
  {
    private int QNe;
    private int QNf;
    private int QNg;
    private long QNh;
    private Runnable QNi;
    private RecyclerView mkw;
    private LinearLayoutManager vqi;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(307260);
      this.QNe = 2147483647;
      this.QNf = -1;
      this.QNg = -1;
      this.QNh = 0L;
      this.QNi = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96942);
          if (b.c.a(b.c.this) == 1)
          {
            b.c.b(b.c.this);
            b.c.d(b.c.this).postDelayed(b.c.c(b.c.this), 100L);
          }
          AppMethodBeat.o(96942);
        }
      };
      this.mkw = paramRecyclerView;
      this.vqi = paramLinearLayoutManager;
      AppMethodBeat.o(307260);
    }
    
    private void hiK()
    {
      AppMethodBeat.i(96944);
      this.mkw.getHandler().removeCallbacks(this.QNi);
      AppMethodBeat.o(96944);
    }
    
    private void lw(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96947);
      b.a(b.this, paramInt1, paramInt2);
      AppMethodBeat.o(96947);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(307265);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt != this.QNe)
      {
        if (paramInt != 1) {
          hiK();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.QNe = paramInt;
        Log.d("RecyclerViewExposureMgr", "state ".concat(String.valueOf(paramInt)));
        a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(307265);
        return;
        b.this.hjQ();
        if (this.QNe == 2)
        {
          int i = this.vqi.Ju();
          int j = this.vqi.Jw();
          if (j < this.QNf)
          {
            lw(j, this.QNf);
          }
          else if (i > this.QNg)
          {
            lw(this.QNg, i);
            continue;
            hiK();
            this.mkw.postDelayed(this.QNi, 100L);
            continue;
            this.QNf = this.vqi.Ju();
            this.QNg = this.vqi.Jw();
            this.QNh = System.currentTimeMillis();
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(307267);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/RecyclerViewExposureMgr$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(307267);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b
 * JD-Core Version:    0.7.0.1
 */