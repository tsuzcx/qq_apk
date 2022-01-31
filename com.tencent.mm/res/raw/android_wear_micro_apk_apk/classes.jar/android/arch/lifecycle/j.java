package android.arch.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class j
{
  final Map<c, List<k>> I;
  final Map<k, c> J;
  
  j(Map<k, c> paramMap)
  {
    this.J = paramMap;
    this.I = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      c localc = (c)localEntry.getValue();
      List localList = (List)this.I.get(localc);
      paramMap = localList;
      if (localList == null)
      {
        paramMap = new ArrayList();
        this.I.put(localc, paramMap);
      }
      paramMap.add(localEntry.getKey());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.j
 * JD-Core Version:    0.7.0.1
 */