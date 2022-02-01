package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class r
{
  public static boolean a(a.a parama)
  {
    AppMethodBeat.i(51640);
    if (!bu.isNullOrNil(parama.key))
    {
      AppMethodBeat.o(51640);
      return true;
    }
    AppMethodBeat.o(51640);
    return false;
  }
  
  public static boolean b(List<a> paramList, Map<String, a.a> paramMap)
  {
    AppMethodBeat.i(51639);
    if ((paramMap == null) || (paramMap.size() <= 0) || (paramList == null))
    {
      AppMethodBeat.o(51639);
      return false;
    }
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < paramList.size(); bool1 = bool2)
    {
      bool2 = bool1;
      if (paramList.get(i) != null)
      {
        LinkedList localLinkedList = ((a)paramList.get(i)).lJQ;
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
              ae.i("MicroMsg.ProductUpdateLogic", "Updating action , info: key=" + locala1.key);
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
        ((a)paramList.get(i)).yBY = bool2;
        bool2 = bool1;
      }
      i += 1;
    }
    AppMethodBeat.o(51639);
    return bool1;
  }
  
  public static LinkedList<String> fC(List<a> paramList)
  {
    AppMethodBeat.i(51637);
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      LinkedList localLinkedList2 = ((a)paramList.get(i)).lJQ;
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
    AppMethodBeat.o(51637);
    return localLinkedList1;
  }
  
  public static Map<String, a.a> fD(List<String> paramList)
  {
    AppMethodBeat.i(51638);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (String)paramList.get(i);
      ae.d("MicroMsg.ProductUpdateLogic", "toUpdateXmlList info: i=" + i + ";" + bu.nullAsNil((String)localObject));
      localObject = a.o(bx.M((String)localObject, "action"), ".action");
      if ((localObject != null) && (((a.a)localObject).dmr != 2)) {
        localHashMap.put(((a.a)localObject).key, localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(51638);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.r
 * JD-Core Version:    0.7.0.1
 */