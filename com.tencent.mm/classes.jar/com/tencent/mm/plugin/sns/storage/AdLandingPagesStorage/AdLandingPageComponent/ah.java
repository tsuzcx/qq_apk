package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ah
  extends x
{
  public boolean mXd;
  public int zAU;
  public LinkedList<q> zzJ;
  
  public ah()
  {
    AppMethodBeat.i(96325);
    this.zzJ = new LinkedList();
    this.zAU = 0;
    this.mXd = true;
    AppMethodBeat.o(96325);
  }
  
  public final List<x> dWq()
  {
    AppMethodBeat.i(96326);
    ArrayList localArrayList = new ArrayList(super.dWq());
    if (this.zzJ != null)
    {
      Iterator localIterator = this.zzJ.iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if (localq.zzJ != null) {
          localArrayList.addAll(localq.zzJ);
        }
      }
    }
    AppMethodBeat.o(96326);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah
 * JD-Core Version:    0.7.0.1
 */