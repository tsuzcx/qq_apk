package com.tencent.mm.ui.contact;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
{
  static int KKD;
  private static List<String> KKE;
  private static List<String> KKF;
  
  public static void iI(List<String> paramList)
  {
    AppMethodBeat.i(102917);
    LinkedList localLinkedList = new LinkedList();
    KKE = localLinkedList;
    localLinkedList.addAll(paramList);
    ae.d("MicroMsg.NewGroupRecommendDetailReporter", "preCommend: %s", new Object[] { KKE });
    AppMethodBeat.o(102917);
  }
  
  public static void iJ(List<String> paramList)
  {
    AppMethodBeat.i(102918);
    KKF = paramList;
    ae.d("MicroMsg.NewGroupRecommendDetailReporter", "recommend: %s", new Object[] { KKF });
    AppMethodBeat.o(102918);
  }
  
  public static void iK(List<String> paramList)
  {
    AppMethodBeat.i(102919);
    if ((KKE != null) && (KKF != null) && (KKF.size() > 0) && (paramList != null) && (paramList.size() > 0))
    {
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      LinkedList localLinkedList3 = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!KKE.contains(str)) {
          if (KKF.contains(str)) {
            localLinkedList1.add(str);
          } else {
            localLinkedList2.add(str);
          }
        }
      }
      int i = 0;
      while (i < KKF.size())
      {
        if (localLinkedList1.contains(KKF.get(i))) {
          localLinkedList3.add(String.valueOf(i));
        }
        i += 1;
      }
      if ((localLinkedList1.size() > 0) || (localLinkedList2.size() > 0))
      {
        g.yxI.f(18637, new Object[] { Integer.valueOf(KKD), TextUtils.join(";", KKE), TextUtils.join(";", KKF), TextUtils.join(";", localLinkedList1), TextUtils.join(";", localLinkedList2), TextUtils.join(";", localLinkedList3) });
        ae.d("MicroMsg.NewGroupRecommendDetailReporter", "report, selectFromRecommend: %s, selectNotFromRecommendList: %s", new Object[] { localLinkedList1, localLinkedList2 });
      }
    }
    reset();
    AppMethodBeat.o(102919);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(102920);
    KKE = null;
    KKF = null;
    ae.d("MicroMsg.NewGroupRecommendDetailReporter", "reset");
    AppMethodBeat.o(102920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.w
 * JD-Core Version:    0.7.0.1
 */