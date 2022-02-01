package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ai
  extends y
{
  public boolean ncj;
  public LinkedList<q> zQI;
  public int zRU;
  
  public ai()
  {
    AppMethodBeat.i(96325);
    this.zQI = new LinkedList();
    this.zRU = 0;
    this.ncj = true;
    AppMethodBeat.o(96325);
  }
  
  public final List<y> dZS()
  {
    AppMethodBeat.i(96326);
    ArrayList localArrayList = new ArrayList(super.dZS());
    if (this.zQI != null)
    {
      Iterator localIterator = this.zQI.iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if (localq.zQI != null) {
          localArrayList.addAll(localq.zQI);
        }
      }
    }
    AppMethodBeat.o(96326);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai
 * JD-Core Version:    0.7.0.1
 */