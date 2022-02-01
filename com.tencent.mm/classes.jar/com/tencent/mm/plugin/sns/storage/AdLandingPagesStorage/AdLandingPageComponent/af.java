package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class af
  extends x
{
  public boolean lUw;
  public LinkedList<q> wWn;
  public int wXr;
  
  public af()
  {
    AppMethodBeat.i(96325);
    this.wWn = new LinkedList();
    this.wXr = 0;
    this.lUw = true;
    AppMethodBeat.o(96325);
  }
  
  public final List<x> dvE()
  {
    AppMethodBeat.i(96326);
    ArrayList localArrayList = new ArrayList(super.dvE());
    if (this.wWn != null)
    {
      Iterator localIterator = this.wWn.iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if (localq.wWn != null) {
          localArrayList.addAll(localq.wWn);
        }
      }
    }
    AppMethodBeat.o(96326);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af
 * JD-Core Version:    0.7.0.1
 */