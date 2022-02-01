package com.tencent.mm.plugin.sns.device.appstore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

final class c
{
  int mPriority;
  String wBE;
  String wBF;
  List<String> wBG;
  List<String> wBH;
  String wBI;
  
  final Collection<b> dsi()
  {
    AppMethodBeat.i(187295);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.wBG;
    Object localObject2 = this.wBH;
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      AppMethodBeat.o(187295);
      return localArrayList;
    }
    if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
      localObject2 = ((List)localObject2).iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(b.u((String)localIterator.next(), str, this.wBE, this.wBF));
      }
      continue;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(b.u((String)((Iterator)localObject1).next(), "", this.wBE, this.wBF));
      }
    }
    AppMethodBeat.o(187295);
    return localArrayList;
  }
  
  public static final class a
    implements Comparator<c>
  {
    private static int a(c paramc1, c paramc2)
    {
      AppMethodBeat.i(187293);
      try
      {
        int i = Integer.compare(paramc1.mPriority, paramc2.mPriority);
        AppMethodBeat.o(187293);
        return i;
      }
      catch (Throwable paramc1)
      {
        AppMethodBeat.o(187293);
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.c
 * JD-Core Version:    0.7.0.1
 */