package com.tencent.mm.ui.contact;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
{
  static int GXn;
  private static List<String> GXo;
  private static List<String> GXp;
  
  public static void hZ(List<String> paramList)
  {
    AppMethodBeat.i(102917);
    LinkedList localLinkedList = new LinkedList();
    GXo = localLinkedList;
    localLinkedList.addAll(paramList);
    ad.d("MicroMsg.NewGroupRecommendDetailReporter", "preCommend: %s", new Object[] { GXo });
    AppMethodBeat.o(102917);
  }
  
  public static void ia(List<String> paramList)
  {
    AppMethodBeat.i(102918);
    GXp = paramList;
    ad.d("MicroMsg.NewGroupRecommendDetailReporter", "recommend: %s", new Object[] { GXp });
    AppMethodBeat.o(102918);
  }
  
  public static void ib(List<String> paramList)
  {
    AppMethodBeat.i(102919);
    if ((GXo != null) && (GXp != null) && (GXp.size() > 0) && (paramList != null) && (paramList.size() > 0))
    {
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      LinkedList localLinkedList3 = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!GXo.contains(str)) {
          if (GXp.contains(str)) {
            localLinkedList1.add(str);
          } else {
            localLinkedList2.add(str);
          }
        }
      }
      int i = 0;
      while (i < GXp.size())
      {
        if (localLinkedList1.contains(GXp.get(i))) {
          localLinkedList3.add(String.valueOf(i));
        }
        i += 1;
      }
      if ((localLinkedList1.size() > 0) || (localLinkedList2.size() > 0))
      {
        h.vKh.f(18637, new Object[] { Integer.valueOf(GXn), TextUtils.join(";", GXo), TextUtils.join(";", GXp), TextUtils.join(";", localLinkedList1), TextUtils.join(";", localLinkedList2), TextUtils.join(";", localLinkedList3) });
        ad.d("MicroMsg.NewGroupRecommendDetailReporter", "report, selectFromRecommend: %s, selectNotFromRecommendList: %s", new Object[] { localLinkedList1, localLinkedList2 });
      }
    }
    reset();
    AppMethodBeat.o(102919);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(102920);
    GXo = null;
    GXp = null;
    ad.d("MicroMsg.NewGroupRecommendDetailReporter", "reset");
    AppMethodBeat.o(102920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.w
 * JD-Core Version:    0.7.0.1
 */