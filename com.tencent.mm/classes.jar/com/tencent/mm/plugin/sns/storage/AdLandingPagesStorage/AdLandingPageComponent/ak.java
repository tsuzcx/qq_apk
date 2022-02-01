package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ak
  extends z
{
  public LinkedList<r> DYI;
  public int Eac;
  public boolean autoCarousel;
  public boolean onr;
  
  public ak()
  {
    AppMethodBeat.i(96325);
    this.DYI = new LinkedList();
    this.Eac = 0;
    this.onr = true;
    this.autoCarousel = false;
    AppMethodBeat.o(96325);
  }
  
  public final List<z> eXg()
  {
    AppMethodBeat.i(96326);
    ArrayList localArrayList = new ArrayList(super.eXg());
    if (this.DYI != null)
    {
      Iterator localIterator = this.DYI.iterator();
      while (localIterator.hasNext())
      {
        r localr = (r)localIterator.next();
        if (localr.DYI != null) {
          localArrayList.addAll(localr.DYI);
        }
      }
    }
    AppMethodBeat.o(96326);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak
 * JD-Core Version:    0.7.0.1
 */