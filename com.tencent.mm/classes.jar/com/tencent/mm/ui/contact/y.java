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
  static int afgd;
  private static List<String> afge;
  private static List<String> afgf;
  
  public static void nX(List<String> paramList)
  {
    AppMethodBeat.i(102917);
    LinkedList localLinkedList = new LinkedList();
    afge = localLinkedList;
    localLinkedList.addAll(paramList);
    Log.d("MicroMsg.NewGroupRecommendDetailReporter", "preCommend: %s", new Object[] { afge });
    AppMethodBeat.o(102917);
  }
  
  public static void nY(List<String> paramList)
  {
    AppMethodBeat.i(102918);
    afgf = paramList;
    Log.d("MicroMsg.NewGroupRecommendDetailReporter", "recommend: %s", new Object[] { afgf });
    AppMethodBeat.o(102918);
  }
  
  public static void nZ(List<String> paramList)
  {
    AppMethodBeat.i(102919);
    if ((afge != null) && (afgf != null) && (afgf.size() > 0) && (paramList != null) && (paramList.size() > 0))
    {
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      LinkedList localLinkedList3 = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!afge.contains(str)) {
          if (afgf.contains(str)) {
            localLinkedList1.add(str);
          } else {
            localLinkedList2.add(str);
          }
        }
      }
      int i = 0;
      while (i < afgf.size())
      {
        if (localLinkedList1.contains(afgf.get(i))) {
          localLinkedList3.add(String.valueOf(i));
        }
        i += 1;
      }
      if ((localLinkedList1.size() > 0) || (localLinkedList2.size() > 0))
      {
        h.OAn.b(18637, new Object[] { Integer.valueOf(afgd), TextUtils.join(";", afge), TextUtils.join(";", afgf), TextUtils.join(";", localLinkedList1), TextUtils.join(";", localLinkedList2), TextUtils.join(";", localLinkedList3) });
        Log.d("MicroMsg.NewGroupRecommendDetailReporter", "report, selectFromRecommend: %s, selectNotFromRecommendList: %s", new Object[] { localLinkedList1, localLinkedList2 });
      }
    }
    reset();
    AppMethodBeat.o(102919);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(102920);
    afge = null;
    afgf = null;
    Log.d("MicroMsg.NewGroupRecommendDetailReporter", "reset");
    AppMethodBeat.o(102920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.y
 * JD-Core Version:    0.7.0.1
 */