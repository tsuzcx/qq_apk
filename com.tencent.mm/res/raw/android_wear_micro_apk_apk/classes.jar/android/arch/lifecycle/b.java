package android.arch.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class b
{
  final Map<f, List<c>> A;
  final Map<c, f> B;
  
  b(Map<c, f> paramMap)
  {
    this.B = paramMap;
    this.A = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      f localf = (f)localEntry.getValue();
      List localList = (List)this.A.get(localf);
      paramMap = localList;
      if (localList == null)
      {
        paramMap = new ArrayList();
        this.A.put(localf, paramMap);
      }
      paramMap.add(localEntry.getKey());
    }
  }
  
  private static void a(List<c> paramList, i parami, f paramf, Object paramObject)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ((c)paramList.get(i)).b(parami, paramf, paramObject);
        i -= 1;
      }
    }
  }
  
  final void a(i parami, f paramf, Object paramObject)
  {
    a((List)this.A.get(paramf), parami, paramf, paramObject);
    a((List)this.A.get(f.ON_ANY), parami, paramf, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.b
 * JD-Core Version:    0.7.0.1
 */