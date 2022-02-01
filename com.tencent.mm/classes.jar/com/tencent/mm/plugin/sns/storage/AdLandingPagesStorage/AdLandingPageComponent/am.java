package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class am
  extends aa
{
  public boolean Flq;
  public LinkedList<s> QKh;
  public int QLE;
  public boolean autoCarousel;
  
  public am()
  {
    AppMethodBeat.i(96325);
    this.QKh = new LinkedList();
    this.QLE = 0;
    this.Flq = true;
    this.autoCarousel = false;
    AppMethodBeat.o(96325);
  }
  
  public final List<aa> haE()
  {
    AppMethodBeat.i(96326);
    ArrayList localArrayList = new ArrayList(super.haE());
    if (this.QKh != null)
    {
      Iterator localIterator = this.QKh.iterator();
      while (localIterator.hasNext())
      {
        s locals = (s)localIterator.next();
        if (locals.QKh != null) {
          localArrayList.addAll(locals.QKh);
        }
      }
    }
    AppMethodBeat.o(96326);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am
 * JD-Core Version:    0.7.0.1
 */