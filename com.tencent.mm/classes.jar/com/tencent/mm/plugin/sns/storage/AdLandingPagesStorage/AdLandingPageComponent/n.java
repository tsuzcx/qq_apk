package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends s
{
  public boolean hqp = true;
  public LinkedList<m> oCS = new LinkedList();
  public int oCU = 0;
  
  protected final List<s> bEY()
  {
    ArrayList localArrayList = new ArrayList(super.bEY());
    if (this.oCS != null)
    {
      Iterator localIterator = this.oCS.iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        if (localm.oCS != null) {
          localArrayList.addAll(localm.oCS);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n
 * JD-Core Version:    0.7.0.1
 */