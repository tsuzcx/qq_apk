package com.tencent.mm.ui.contact;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
{
  static int IxB;
  private static List<String> IxC;
  private static List<String> IxD;
  
  public static void im(List<String> paramList)
  {
    AppMethodBeat.i(102917);
    LinkedList localLinkedList = new LinkedList();
    IxC = localLinkedList;
    localLinkedList.addAll(paramList);
    ac.d("MicroMsg.NewGroupRecommendDetailReporter", "preCommend: %s", new Object[] { IxC });
    AppMethodBeat.o(102917);
  }
  
  public static void in(List<String> paramList)
  {
    AppMethodBeat.i(102918);
    IxD = paramList;
    ac.d("MicroMsg.NewGroupRecommendDetailReporter", "recommend: %s", new Object[] { IxD });
    AppMethodBeat.o(102918);
  }
  
  public static void io(List<String> paramList)
  {
    AppMethodBeat.i(102919);
    if ((IxC != null) && (IxD != null) && (IxD.size() > 0) && (paramList != null) && (paramList.size() > 0))
    {
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      LinkedList localLinkedList3 = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!IxC.contains(str)) {
          if (IxD.contains(str)) {
            localLinkedList1.add(str);
          } else {
            localLinkedList2.add(str);
          }
        }
      }
      int i = 0;
      while (i < IxD.size())
      {
        if (localLinkedList1.contains(IxD.get(i))) {
          localLinkedList3.add(String.valueOf(i));
        }
        i += 1;
      }
      if ((localLinkedList1.size() > 0) || (localLinkedList2.size() > 0))
      {
        h.wUl.f(18637, new Object[] { Integer.valueOf(IxB), TextUtils.join(";", IxC), TextUtils.join(";", IxD), TextUtils.join(";", localLinkedList1), TextUtils.join(";", localLinkedList2), TextUtils.join(";", localLinkedList3) });
        ac.d("MicroMsg.NewGroupRecommendDetailReporter", "report, selectFromRecommend: %s, selectNotFromRecommendList: %s", new Object[] { localLinkedList1, localLinkedList2 });
      }
    }
    reset();
    AppMethodBeat.o(102919);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(102920);
    IxC = null;
    IxD = null;
    ac.d("MicroMsg.NewGroupRecommendDetailReporter", "reset");
    AppMethodBeat.o(102920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.w
 * JD-Core Version:    0.7.0.1
 */