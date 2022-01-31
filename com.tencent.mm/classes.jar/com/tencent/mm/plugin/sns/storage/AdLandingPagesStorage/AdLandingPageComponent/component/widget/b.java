package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private RecyclerView heQ;
  public Map<Integer, b.a> oFa = new HashMap();
  private LinearLayoutManager oFb;
  public b.b oIM;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b oIN;
  
  public b(RecyclerView paramRecyclerView, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b paramb)
  {
    this.heQ = paramRecyclerView;
    this.oIN = paramb;
    if ((paramRecyclerView.getLayoutManager() == null) || (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))) {
      throw new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
    }
    if ((paramRecyclerView.getAdapter() == null) || (!(paramRecyclerView.getAdapter() instanceof b.b))) {
      throw new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
    }
    this.oIM = ((b.b)paramRecyclerView.getAdapter());
    this.oFb = ((LinearLayoutManager)paramRecyclerView.getLayoutManager());
    this.heQ.a(new b.c(this, paramRecyclerView, (LinearLayoutManager)paramRecyclerView.getLayoutManager()));
  }
  
  public final void bFH()
  {
    bFg();
    int i = this.oFb.gY();
    int j = this.oFb.ha();
    Iterator localIterator = this.oFa.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() < i) || (((Integer)localEntry.getKey()).intValue() > j))
      {
        if (((b.a)localEntry.getValue()).oCc)
        {
          this.oIM.yj(((Integer)localEntry.getKey()).intValue());
          ((b.a)localEntry.getValue()).bFh();
        }
      }
      else if ((((b.a)localEntry.getValue()).oCc) && (!this.oIM.yk(((Integer)localEntry.getKey()).intValue())))
      {
        this.oIM.yj(((Integer)localEntry.getKey()).intValue());
        ((b.a)localEntry.getValue()).bFh();
      }
    }
  }
  
  public final void bFI()
  {
    int i;
    int j;
    if (this.oFb != null)
    {
      i = this.oFb.gY();
      j = this.oFb.ha();
      if ((i != j) || (i != -1)) {
        break label88;
      }
    }
    for (;;)
    {
      return;
      label88:
      while (i <= j)
      {
        b.a locala = (b.a)this.oFa.get(Integer.valueOf(i));
        if ((locala != null) && (locala.oCc))
        {
          this.oIM.yj(i);
          locala.bFh();
        }
        i += 1;
      }
    }
  }
  
  public final void bFg()
  {
    int i;
    int j;
    if (this.oFb != null)
    {
      i = this.oFb.gY();
      j = this.oFb.ha();
      if ((i != j) || (i != -1)) {}
    }
    else
    {
      return;
    }
    dO(i, j);
  }
  
  final void dO(int paramInt1, int paramInt2)
  {
    while (paramInt1 <= paramInt2)
    {
      b.a locala2 = (b.a)this.oFa.get(Integer.valueOf(paramInt1));
      b.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new b.a(this, (byte)0);
        this.oFa.put(Integer.valueOf(paramInt1), locala1);
      }
      if ((!locala1.oCc) && (this.oIM.yk(paramInt1)))
      {
        this.oIM.a(paramInt1, this);
        if (!locala1.oCc) {
          locala1.oCc = true;
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b
 * JD-Core Version:    0.7.0.1
 */