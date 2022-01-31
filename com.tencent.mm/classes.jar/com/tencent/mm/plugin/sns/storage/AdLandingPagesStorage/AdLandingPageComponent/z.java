package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class z
  extends t
{
  public boolean jew;
  public LinkedList<m> rsu;
  public int rtk;
  
  public z()
  {
    AppMethodBeat.i(36945);
    this.rsu = new LinkedList();
    this.rtk = 0;
    this.jew = true;
    AppMethodBeat.o(36945);
  }
  
  public final List<t> cqF()
  {
    AppMethodBeat.i(36946);
    ArrayList localArrayList = new ArrayList(super.cqF());
    if (this.rsu != null)
    {
      Iterator localIterator = this.rsu.iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        if (localm.rsu != null) {
          localArrayList.addAll(localm.rsu);
        }
      }
    }
    AppMethodBeat.o(36946);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z
 * JD-Core Version:    0.7.0.1
 */