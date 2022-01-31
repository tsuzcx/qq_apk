package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m
{
  public static boolean a(a.a parama)
  {
    AppMethodBeat.i(80860);
    if (!bo.isNullOrNil(parama.key))
    {
      AppMethodBeat.o(80860);
      return true;
    }
    AppMethodBeat.o(80860);
    return false;
  }
  
  public static boolean b(List<a> paramList, Map<String, a.a> paramMap)
  {
    AppMethodBeat.i(80859);
    if ((paramMap == null) || (paramMap.size() <= 0) || (paramList == null))
    {
      AppMethodBeat.o(80859);
      return false;
    }
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < paramList.size(); bool1 = bool2)
    {
      bool2 = bool1;
      if (paramList.get(i) != null)
      {
        LinkedList localLinkedList = ((a)paramList.get(i)).fQb;
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
              ab.i("MicroMsg.ProductUpdateLogic", "Updating action , info: key=" + locala1.key);
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
        ((a)paramList.get(i)).qtR = bool2;
        bool2 = bool1;
      }
      i += 1;
    }
    AppMethodBeat.o(80859);
    return bool1;
  }
  
  public static LinkedList<String> cR(List<a> paramList)
  {
    AppMethodBeat.i(80857);
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      LinkedList localLinkedList2 = ((a)paramList.get(i)).fQb;
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
    AppMethodBeat.o(80857);
    return localLinkedList1;
  }
  
  public static Map<String, a.a> cS(List<String> paramList)
  {
    AppMethodBeat.i(80858);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (String)paramList.get(i);
      ab.d("MicroMsg.ProductUpdateLogic", "toUpdateXmlList info: i=" + i + ";" + bo.nullAsNil((String)localObject));
      localObject = a.m(br.F((String)localObject, "action"), ".action");
      if ((localObject != null) && (((a.a)localObject).showType != 2)) {
        localHashMap.put(((a.a)localObject).key, localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(80858);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.m
 * JD-Core Version:    0.7.0.1
 */