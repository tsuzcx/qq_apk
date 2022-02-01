package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ImageMultiCodeReport;", "", "()V", "getCodeListString", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "Lkotlin/collections/ArrayList;", "getPriorityLevelListString", "getTypeNameListString", "scanMultiCodeReport", "", "sessionId", "", "opType", "", "clickData", "costTime", "fromScanCodeButton", "", "expoFrom", "showReport", "allIconNum", "recIconNum", "scene", "url", "OPTYPE", "SCENE", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j OGP;
  
  static
  {
    AppMethodBeat.i(313364);
    OGP = new j();
    AppMethodBeat.o(313364);
  }
  
  public static void a(long paramLong1, int paramInt1, ArrayList<ImageQBarDataBean> paramArrayList, ImageQBarDataBean paramImageQBarDataBean, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(313346);
    s.u(paramArrayList, "dataList");
    h localh = h.OAn;
    int j = paramArrayList.size();
    String str2 = bt(paramArrayList);
    String str3 = bv(paramArrayList);
    Object localObject;
    if (paramImageQBarDataBean == null)
    {
      localObject = "";
      if (paramImageQBarDataBean != null) {
        break label197;
      }
    }
    label197:
    for (int i = 0;; i = paramImageQBarDataBean.priorityLevel)
    {
      localh.b(19332, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(j), str2, str3, Integer.valueOf(paramInt1), localObject, Integer.valueOf(i), Long.valueOf(paramLong2), "", bu(paramArrayList), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(313346);
      return;
      String str1 = paramImageQBarDataBean.OGQ;
      localObject = str1;
      if (str1 != null) {
        break;
      }
      localObject = "";
      break;
    }
  }
  
  public static void a(long paramLong1, int paramInt, ArrayList<ImageQBarDataBean> paramArrayList, ImageQBarDataBean paramImageQBarDataBean, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(313338);
    s.u(paramArrayList, "dataList");
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      a(paramLong1, paramInt, paramArrayList, paramImageQBarDataBean, paramLong2, i);
      AppMethodBeat.o(313338);
      return;
    }
  }
  
  public static void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(313333);
    s.u(paramString, "url");
    h.OAn.b(23040, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(313333);
  }
  
  private static String bt(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(313352);
    Object localObject1 = (Collection)paramArrayList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(313352);
      return "";
    }
    localObject1 = new StringBuilder();
    paramArrayList = ((Iterable)paramArrayList).iterator();
    i = j;
    while (paramArrayList.hasNext())
    {
      Object localObject2 = paramArrayList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (ImageQBarDataBean)localObject2;
      if (i != 0) {
        ((StringBuilder)localObject1).append("#");
      }
      ((StringBuilder)localObject1).append(((ImageQBarDataBean)localObject2).OGQ);
      i += 1;
    }
    paramArrayList = ((StringBuilder)localObject1).toString();
    s.s(paramArrayList, "sb.toString()");
    AppMethodBeat.o(313352);
    return paramArrayList;
  }
  
  private static String bu(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(313356);
    Object localObject1 = (Collection)paramArrayList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(313356);
      return "";
    }
    localObject1 = new StringBuilder();
    paramArrayList = ((Iterable)paramArrayList).iterator();
    i = j;
    while (paramArrayList.hasNext())
    {
      Object localObject2 = paramArrayList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (ImageQBarDataBean)localObject2;
      if (i != 0) {
        ((StringBuilder)localObject1).append("#");
      }
      ((StringBuilder)localObject1).append(((ImageQBarDataBean)localObject2).typeName);
      i += 1;
    }
    paramArrayList = ((StringBuilder)localObject1).toString();
    s.s(paramArrayList, "sb.toString()");
    AppMethodBeat.o(313356);
    return paramArrayList;
  }
  
  private static String bv(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(313360);
    Object localObject1 = (Collection)paramArrayList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(313360);
      return "";
    }
    localObject1 = new StringBuilder();
    paramArrayList = ((Iterable)paramArrayList).iterator();
    i = j;
    while (paramArrayList.hasNext())
    {
      Object localObject2 = paramArrayList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (ImageQBarDataBean)localObject2;
      if (i != 0) {
        ((StringBuilder)localObject1).append("#");
      }
      ((StringBuilder)localObject1).append(((ImageQBarDataBean)localObject2).priorityLevel);
      i += 1;
    }
    paramArrayList = ((StringBuilder)localObject1).toString();
    s.s(paramArrayList, "sb.toString()");
    AppMethodBeat.o(313360);
    return paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.j
 * JD-Core Version:    0.7.0.1
 */