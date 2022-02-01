package com.tencent.mm.ui.contact;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class y
{
  static int Xux;
  private static List<String> Xuy;
  private static List<String> Xuz;
  
  public static void kG(List<String> paramList)
  {
    AppMethodBeat.i(102917);
    LinkedList localLinkedList = new LinkedList();
    Xuy = localLinkedList;
    localLinkedList.addAll(paramList);
    Log.d("MicroMsg.NewGroupRecommendDetailReporter", "preCommend: %s", new Object[] { Xuy });
    AppMethodBeat.o(102917);
  }
  
  public static void kH(List<String> paramList)
  {
    AppMethodBeat.i(102918);
    Xuz = paramList;
    Log.d("MicroMsg.NewGroupRecommendDetailReporter", "recommend: %s", new Object[] { Xuz });
    AppMethodBeat.o(102918);
  }
  
  public static void kI(List<String> paramList)
  {
    AppMethodBeat.i(102919);
    if ((Xuy != null) && (Xuz != null) && (Xuz.size() > 0) && (paramList != null) && (paramList.size() > 0))
    {
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      LinkedList localLinkedList3 = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!Xuy.contains(str)) {
          if (Xuz.contains(str)) {
            localLinkedList1.add(str);
          } else {
            localLinkedList2.add(str);
          }
        }
      }
      int i = 0;
      while (i < Xuz.size())
      {
        if (localLinkedList1.contains(Xuz.get(i))) {
          localLinkedList3.add(String.valueOf(i));
        }
        i += 1;
      }
      if ((localLinkedList1.size() > 0) || (localLinkedList2.size() > 0))
      {
        h.IzE.a(18637, new Object[] { Integer.valueOf(Xux), TextUtils.join(";", Xuy), TextUtils.join(";", Xuz), TextUtils.join(";", localLinkedList1), TextUtils.join(";", localLinkedList2), TextUtils.join(";", localLinkedList3) });
        Log.d("MicroMsg.NewGroupRecommendDetailReporter", "report, selectFromRecommend: %s, selectNotFromRecommendList: %s", new Object[] { localLinkedList1, localLinkedList2 });
      }
    }
    reset();
    AppMethodBeat.o(102919);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(102920);
    Xuy = null;
    Xuz = null;
    Log.d("MicroMsg.NewGroupRecommendDetailReporter", "reset");
    AppMethodBeat.o(102920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.y
 * JD-Core Version:    0.7.0.1
 */