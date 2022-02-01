package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ImageMultiCodeReport;", "", "()V", "getCodeListString", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "Lkotlin/collections/ArrayList;", "getPriorityLevelListString", "getTypeNameListString", "scanMultiCodeReport", "", "sessionId", "", "opType", "", "clickData", "costTime", "fromScanCodeButton", "", "expoFrom", "showReport", "allIconNum", "recIconNum", "scene", "url", "OPTYPE", "SCENE", "plugin-comm_release"})
public final class j
{
  public static final j IAG;
  
  static
  {
    AppMethodBeat.i(227152);
    IAG = new j();
    AppMethodBeat.o(227152);
  }
  
  public static void a(long paramLong1, int paramInt1, ArrayList<ImageQBarDataBean> paramArrayList, ImageQBarDataBean paramImageQBarDataBean, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(227136);
    p.k(paramArrayList, "dataList");
    h localh = h.IzE;
    int i = paramArrayList.size();
    String str3 = aV(paramArrayList);
    String str4 = aX(paramArrayList);
    String str1;
    if (paramImageQBarDataBean != null)
    {
      String str2 = paramImageQBarDataBean.IAH;
      str1 = str2;
      if (str2 != null) {}
    }
    else
    {
      str1 = "";
    }
    if (paramImageQBarDataBean != null) {}
    for (paramImageQBarDataBean = Integer.valueOf(paramImageQBarDataBean.priorityLevel);; paramImageQBarDataBean = Integer.valueOf(0))
    {
      localh.a(19332, new Object[] { Long.valueOf(paramLong1), Integer.valueOf(i), str3, str4, Integer.valueOf(paramInt1), str1, paramImageQBarDataBean, Long.valueOf(paramLong2), "", aW(paramArrayList), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(227136);
      return;
    }
  }
  
  public static void a(long paramLong1, int paramInt, ArrayList<ImageQBarDataBean> paramArrayList, ImageQBarDataBean paramImageQBarDataBean, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(227126);
    p.k(paramArrayList, "dataList");
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      a(paramLong1, paramInt, paramArrayList, paramImageQBarDataBean, paramLong2, i);
      AppMethodBeat.o(227126);
      return;
    }
  }
  
  private static String aV(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(227140);
    Object localObject1 = (Collection)paramArrayList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(227140);
      return "";
    }
    localObject1 = new StringBuilder();
    paramArrayList = ((Iterable)paramArrayList).iterator();
    i = j;
    while (paramArrayList.hasNext())
    {
      Object localObject2 = paramArrayList.next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (ImageQBarDataBean)localObject2;
      if (i != 0) {
        ((StringBuilder)localObject1).append("#");
      }
      ((StringBuilder)localObject1).append(((ImageQBarDataBean)localObject2).IAH);
      i += 1;
    }
    paramArrayList = ((StringBuilder)localObject1).toString();
    p.j(paramArrayList, "sb.toString()");
    AppMethodBeat.o(227140);
    return paramArrayList;
  }
  
  private static String aW(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(227141);
    Object localObject1 = (Collection)paramArrayList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(227141);
      return "";
    }
    localObject1 = new StringBuilder();
    paramArrayList = ((Iterable)paramArrayList).iterator();
    i = j;
    while (paramArrayList.hasNext())
    {
      Object localObject2 = paramArrayList.next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (ImageQBarDataBean)localObject2;
      if (i != 0) {
        ((StringBuilder)localObject1).append("#");
      }
      ((StringBuilder)localObject1).append(((ImageQBarDataBean)localObject2).typeName);
      i += 1;
    }
    paramArrayList = ((StringBuilder)localObject1).toString();
    p.j(paramArrayList, "sb.toString()");
    AppMethodBeat.o(227141);
    return paramArrayList;
  }
  
  private static String aX(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    int j = 0;
    AppMethodBeat.i(227149);
    Object localObject1 = (Collection)paramArrayList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(227149);
      return "";
    }
    localObject1 = new StringBuilder();
    paramArrayList = ((Iterable)paramArrayList).iterator();
    i = j;
    while (paramArrayList.hasNext())
    {
      Object localObject2 = paramArrayList.next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (ImageQBarDataBean)localObject2;
      if (i != 0) {
        ((StringBuilder)localObject1).append("#");
      }
      ((StringBuilder)localObject1).append(((ImageQBarDataBean)localObject2).priorityLevel);
      i += 1;
    }
    paramArrayList = ((StringBuilder)localObject1).toString();
    p.j(paramArrayList, "sb.toString()");
    AppMethodBeat.o(227149);
    return paramArrayList;
  }
  
  public static void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(227120);
    p.k(paramString, "url");
    h.IzE.a(23040, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(227120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.j
 * JD-Core Version:    0.7.0.1
 */