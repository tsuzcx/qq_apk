package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
{
  public static boolean a(a.a parama)
  {
    return !bk.bl(parama.key);
  }
  
  public static boolean b(List<a> paramList, Map<String, a.a> paramMap)
  {
    boolean bool2;
    if ((paramMap == null) || (paramMap.size() <= 0) || (paramList == null))
    {
      bool2 = false;
      return bool2;
    }
    int i = 0;
    for (boolean bool1 = false;; bool1 = bool2)
    {
      bool2 = bool1;
      if (i >= paramList.size()) {
        break;
      }
      bool2 = bool1;
      if (paramList.get(i) != null)
      {
        LinkedList localLinkedList = ((a)paramList.get(i)).eAm;
        int j = 0;
        bool2 = false;
        if (j < localLinkedList.size())
        {
          a.a locala1 = (a.a)localLinkedList.get(j);
          if (a(locala1))
          {
            a.a locala2 = (a.a)paramMap.get(locala1.key);
            if (locala2 != null)
            {
              y.i("MicroMsg.ProductUpdateLogic", "Updating action , info: key=" + locala1.key);
              localLinkedList.remove(j);
              localLinkedList.add(j, locala2);
              bool2 = true;
              bool1 = true;
            }
          }
          for (;;)
          {
            j += 1;
            break;
            bool2 = true;
          }
        }
        ((a)paramList.get(i)).nGB = bool2;
        bool2 = bool1;
      }
      i += 1;
    }
  }
  
  public static LinkedList<String> cn(List<a> paramList)
  {
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      LinkedList localLinkedList2 = ((a)paramList.get(i)).eAm;
      int j = 0;
      while (j < localLinkedList2.size())
      {
        a.a locala = (a.a)localLinkedList2.get(j);
        if (a(locala)) {
          localLinkedList1.add(locala.key);
        }
        j += 1;
      }
      i += 1;
    }
    return localLinkedList1;
  }
  
  public static Map<String, a.a> co(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (String)paramList.get(i);
      y.d("MicroMsg.ProductUpdateLogic", "toUpdateXmlList info: i=" + i + ";" + bk.pm((String)localObject));
      localObject = a.m(bn.s((String)localObject, "action"), ".action");
      if ((localObject != null) && (((a.a)localObject).showType != 2)) {
        localHashMap.put(((a.a)localObject).key, localObject);
      }
      i += 1;
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.l
 * JD-Core Version:    0.7.0.1
 */