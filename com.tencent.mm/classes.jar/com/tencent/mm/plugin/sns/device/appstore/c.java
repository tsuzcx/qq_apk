package com.tencent.mm.plugin.sns.device.appstore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

final class c
{
  String QoD;
  String QoE;
  List<String> QoF;
  List<String> QoG;
  String QoH;
  int mPriority;
  
  final Collection<b> heW()
  {
    AppMethodBeat.i(306341);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.QoF;
    Object localObject2 = this.QoG;
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      AppMethodBeat.o(306341);
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
        localArrayList.add(b.J((String)localIterator.next(), str, this.QoD, this.QoE));
      }
      continue;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(b.J((String)((Iterator)localObject1).next(), "", this.QoD, this.QoE));
      }
    }
    AppMethodBeat.o(306341);
    return localArrayList;
  }
  
  public static final class a
    implements Comparator<c>
  {
    private static int a(c paramc1, c paramc2)
    {
      AppMethodBeat.i(306343);
      try
      {
        int i = Integer.compare(paramc1.mPriority, paramc2.mPriority);
        return i;
      }
      finally
      {
        AppMethodBeat.o(306343);
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.c
 * JD-Core Version:    0.7.0.1
 */