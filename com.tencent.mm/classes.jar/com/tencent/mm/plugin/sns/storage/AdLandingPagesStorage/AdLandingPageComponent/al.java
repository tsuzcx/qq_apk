package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
  extends aa
{
  public boolean AJP;
  public LinkedList<s> Kmd;
  public int Kny;
  public boolean autoCarousel;
  
  public al()
  {
    AppMethodBeat.i(96325);
    this.Kmd = new LinkedList();
    this.Kny = 0;
    this.AJP = true;
    this.autoCarousel = false;
    AppMethodBeat.o(96325);
  }
  
  public final List<aa> fKw()
  {
    AppMethodBeat.i(96326);
    ArrayList localArrayList = new ArrayList(super.fKw());
    if (this.Kmd != null)
    {
      Iterator localIterator = this.Kmd.iterator();
      while (localIterator.hasNext())
      {
        s locals = (s)localIterator.next();
        if (locals.Kmd != null) {
          localArrayList.addAll(locals.Kmd);
        }
      }
    }
    AppMethodBeat.o(96326);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al
 * JD-Core Version:    0.7.0.1
 */