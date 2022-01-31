package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public boolean bSe;
  private RecyclerView iQe;
  public Map<Integer, c.a> ruB;
  private LinearLayoutManager ruC;
  public c.b ryK;
  
  public c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(37486);
    this.ruB = new HashMap();
    this.bSe = true;
    this.iQe = paramRecyclerView;
    if ((paramRecyclerView.getLayoutManager() == null) || (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)))
    {
      paramRecyclerView = new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
      AppMethodBeat.o(37486);
      throw paramRecyclerView;
    }
    if ((paramRecyclerView.getAdapter() == null) || (!(paramRecyclerView.getAdapter() instanceof c.b)))
    {
      paramRecyclerView = new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
      AppMethodBeat.o(37486);
      throw paramRecyclerView;
    }
    this.ryK = ((c.b)paramRecyclerView.getAdapter());
    this.ruC = ((LinearLayoutManager)paramRecyclerView.getLayoutManager());
    this.iQe.a(new c.c(this, paramRecyclerView, (LinearLayoutManager)paramRecyclerView.getLayoutManager()));
    AppMethodBeat.o(37486);
  }
  
  private void fx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37489);
    if (paramInt1 <= paramInt2)
    {
      c.a locala2 = (c.a)this.ruB.get(Integer.valueOf(paramInt1));
      c.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new c.a(this, (byte)0);
        this.ruB.put(Integer.valueOf(paramInt1), locala1);
      }
      if (this.ryK.Ej(paramInt1))
      {
        if (locala1.rrB) {
          break label103;
        }
        this.ryK.a(paramInt1, this);
        locala1.cqM();
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label103:
        if (this.ryK.Ek(paramInt1)) {
          this.ryK.El(paramInt1);
        }
      }
    }
    AppMethodBeat.o(37489);
  }
  
  public final void cqL()
  {
    AppMethodBeat.i(37488);
    if (!this.bSe)
    {
      AppMethodBeat.o(37488);
      return;
    }
    if (this.ruC != null)
    {
      int i = this.ruC.it();
      int j = this.ruC.iv();
      ab.d("RecyclerViewExposureMgr", "appear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == j) && (i == -1))
      {
        ab.i("RecyclerViewExposureMgr", "no exposuring child");
        AppMethodBeat.o(37488);
        return;
      }
      fx(i, j);
    }
    AppMethodBeat.o(37488);
  }
  
  public final void crD()
  {
    AppMethodBeat.i(37487);
    if (!this.bSe)
    {
      AppMethodBeat.o(37487);
      return;
    }
    cqL();
    int i = this.ruC.it();
    int j = this.ruC.iv();
    Iterator localIterator = this.ruB.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() < i) || (((Integer)localEntry.getKey()).intValue() > j))
      {
        if (((c.a)localEntry.getValue()).rrB)
        {
          this.ryK.Ei(((Integer)localEntry.getKey()).intValue());
          ((c.a)localEntry.getValue()).cqN();
        }
      }
      else if (((c.a)localEntry.getValue()).rrB) {
        if (!this.ryK.Ej(((Integer)localEntry.getKey()).intValue()))
        {
          this.ryK.Ei(((Integer)localEntry.getKey()).intValue());
          ((c.a)localEntry.getValue()).cqN();
        }
        else if (this.ryK.Ek(((Integer)localEntry.getKey()).intValue()))
        {
          this.ryK.El(((Integer)localEntry.getKey()).intValue());
        }
      }
    }
    AppMethodBeat.o(37487);
  }
  
  public final void crE()
  {
    AppMethodBeat.i(37490);
    int i;
    int j;
    if (this.ruC != null)
    {
      i = this.ruC.it();
      j = this.ruC.iv();
      ab.d("RecyclerViewExposureMgr", "disappear [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i != j) || (i != -1)) {
        break label136;
      }
      ab.i("RecyclerViewExposureMgr", "no exposuring child");
      AppMethodBeat.o(37490);
    }
    label136:
    for (;;)
    {
      if (i <= j)
      {
        c.a locala = (c.a)this.ruB.get(Integer.valueOf(i));
        if ((locala != null) && (locala.rrB))
        {
          this.ryK.Ei(i);
          locala.cqN();
        }
        i += 1;
      }
      else
      {
        AppMethodBeat.o(37490);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c
 * JD-Core Version:    0.7.0.1
 */