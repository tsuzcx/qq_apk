package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag
  extends x
{
  public boolean mwy;
  public LinkedList<q> yjb;
  public int ykf;
  
  public ag()
  {
    AppMethodBeat.i(96325);
    this.yjb = new LinkedList();
    this.ykf = 0;
    this.mwy = true;
    AppMethodBeat.o(96325);
  }
  
  public final List<x> dKd()
  {
    AppMethodBeat.i(96326);
    ArrayList localArrayList = new ArrayList(super.dKd());
    if (this.yjb != null)
    {
      Iterator localIterator = this.yjb.iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if (localq.yjb != null) {
          localArrayList.addAll(localq.yjb);
        }
      }
    }
    AppMethodBeat.o(96326);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag
 * JD-Core Version:    0.7.0.1
 */