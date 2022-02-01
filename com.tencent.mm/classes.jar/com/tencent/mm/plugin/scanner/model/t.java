package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class t
{
  public static boolean a(b.a parama)
  {
    AppMethodBeat.i(51640);
    if (!Util.isNullOrNil(parama.key))
    {
      AppMethodBeat.o(51640);
      return true;
    }
    AppMethodBeat.o(51640);
    return false;
  }
  
  public static boolean b(List<b> paramList, Map<String, b.a> paramMap)
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
        LinkedList localLinkedList = ((b)paramList.get(i)).mRG;
        int j = 0;
        bool2 = false;
        if (j < localLinkedList.size())
        {
          b.a locala1 = (b.a)localLinkedList.get(j);
          if (a(locala1))
          {
            b.a locala2 = (b.a)paramMap.get(locala1.key);
            if (locala2 != null)
            {
              Log.i("MicroMsg.ProductUpdateLogic", "Updating action , info: key=" + locala1.key);
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
        ((b)paramList.get(i)).CEH = bool2;
        bool2 = bool1;
      }
      i += 1;
    }
    AppMethodBeat.o(51639);
    return bool1;
  }
  
  public static LinkedList<String> gA(List<b> paramList)
  {
    AppMethodBeat.i(51637);
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      LinkedList localLinkedList2 = ((b)paramList.get(i)).mRG;
      int j = 0;
      while (j < localLinkedList2.size())
      {
        b.a locala = (b.a)localLinkedList2.get(j);
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
  
  public static Map<String, b.a> gB(List<String> paramList)
  {
    AppMethodBeat.i(51638);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (String)paramList.get(i);
      Log.d("MicroMsg.ProductUpdateLogic", "toUpdateXmlList info: i=" + i + ";" + Util.nullAsNil((String)localObject));
      localObject = b.p(XmlParser.parseXml((String)localObject, "action", null), ".action");
      if ((localObject != null) && (((b.a)localObject).dDG != 2)) {
        localHashMap.put(((b.a)localObject).key, localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(51638);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.t
 * JD-Core Version:    0.7.0.1
 */