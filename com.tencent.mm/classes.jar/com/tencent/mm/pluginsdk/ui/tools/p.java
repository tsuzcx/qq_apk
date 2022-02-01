package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.rz.a;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/QBarOfImageFileResultEventDataParser;", "", "()V", "TAG", "", "getAllEventCodePointCenterX", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "event", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "getAllEventCodePointCenterY", "getAllEventCodeType", "", "getAllEventCodeVersion", "getAllEventResult", "getAllQBarDataOfImage", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "getEventCodeName", "getEventCodePointCenterX", "getEventCodePointCenterY", "getEventCodeType", "getEventCodeVersion", "getEventResult", "getValueFloat", "list", "index", "getValueInt", "getValueString", "temporary_release"})
public final class p
{
  public static final p RxG;
  
  static
  {
    AppMethodBeat.i(188608);
    RxG = new p();
    AppMethodBeat.o(188608);
  }
  
  public static ArrayList<ImageQBarDataBean> b(rz paramrz)
  {
    AppMethodBeat.i(188587);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = c(paramrz);
    Object localObject1;
    int i;
    int j;
    label62:
    label97:
    int k;
    label115:
    ImageQBarDataBean localImageQBarDataBean;
    if (paramrz != null)
    {
      localObject1 = paramrz.fRl;
      if (localObject1 != null)
      {
        i = ((rz.a)localObject1).fRr;
        if (paramrz == null) {
          break label407;
        }
        localObject1 = paramrz.fRl;
        if (localObject1 == null) {
          break label407;
        }
        j = ((rz.a)localObject1).fRs;
        if (paramrz != null)
        {
          localObject1 = paramrz.fRl;
          if (localObject1 != null)
          {
            localObject2 = ((rz.a)localObject1).filePath;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label97;
            }
          }
        }
        localObject1 = "";
        localObject2 = (Iterable)localObject3;
        k = 0;
        localObject3 = ((Iterable)localObject2).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label448;
        }
        localObject2 = ((Iterator)localObject3).next();
        if (k < 0) {
          j.iBO();
        }
        localObject2 = (String)localObject2;
        localImageQBarDataBean = new ImageQBarDataBean();
        localImageQBarDataBean.IAH = ((String)localObject2);
        if (paramrz == null) {
          break label412;
        }
        localObject2 = paramrz.fRl;
        if (localObject2 == null) {
          break label412;
        }
        localObject2 = ((rz.a)localObject2).fRo;
        label186:
        localImageQBarDataBean.typeName = f((ArrayList)localObject2, k);
        if (paramrz == null) {
          break label418;
        }
        localObject2 = paramrz.fRl;
        if (localObject2 == null) {
          break label418;
        }
        localObject2 = ((rz.a)localObject2).fRn;
        label219:
        localImageQBarDataBean.fys = g((ArrayList)localObject2, k);
        if (paramrz == null) {
          break label424;
        }
        localObject2 = paramrz.fRl;
        if (localObject2 == null) {
          break label424;
        }
        localObject2 = ((rz.a)localObject2).fRp;
        label252:
        localImageQBarDataBean.fyt = g((ArrayList)localObject2, k);
        if (paramrz == null) {
          break label430;
        }
        localObject2 = paramrz.fRl;
        if (localObject2 == null) {
          break label430;
        }
        localObject2 = ((rz.a)localObject2).fRq;
        label285:
        localImageQBarDataBean.priorityLevel = g((ArrayList)localObject2, k);
        if (paramrz == null) {
          break label436;
        }
        localObject2 = paramrz.fRl;
        if (localObject2 == null) {
          break label436;
        }
        localObject2 = ((rz.a)localObject2).fRt;
        label318:
        localImageQBarDataBean.IAI = (h((ArrayList)localObject2, k) / i);
        if (paramrz == null) {
          break label442;
        }
        localObject2 = paramrz.fRl;
        if (localObject2 == null) {
          break label442;
        }
      }
    }
    label407:
    label412:
    label418:
    label424:
    label430:
    label436:
    label442:
    for (Object localObject2 = ((rz.a)localObject2).fRu;; localObject2 = null)
    {
      localImageQBarDataBean.IAJ = (h((ArrayList)localObject2, k) / j);
      localImageQBarDataBean.fRr = i;
      localImageQBarDataBean.fRs = j;
      localImageQBarDataBean.filePath = ((String)localObject1);
      localArrayList.add(localImageQBarDataBean);
      k += 1;
      break label115;
      i = 1;
      break;
      j = 1;
      break label62;
      localObject2 = null;
      break label186;
      localObject2 = null;
      break label219;
      localObject2 = null;
      break label252;
      localObject2 = null;
      break label285;
      localObject2 = null;
      break label318;
    }
    label448:
    AppMethodBeat.o(188587);
    return localArrayList;
  }
  
  private static ArrayList<String> c(rz paramrz)
  {
    AppMethodBeat.i(188589);
    ArrayList localArrayList = new ArrayList();
    if (paramrz != null)
    {
      paramrz = paramrz.fRl;
      if (paramrz != null)
      {
        paramrz = paramrz.fRm;
        if (paramrz != null)
        {
          paramrz = ((Iterable)paramrz).iterator();
          label96:
          while (paramrz.hasNext())
          {
            Object localObject = paramrz.next();
            if ((localObject instanceof String))
            {
              if (n.ba((CharSequence)localObject)) {}
              for (int i = 1;; i = 0)
              {
                if (i != 0) {
                  break label96;
                }
                localArrayList.add(localObject);
                break;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(188589);
    return localArrayList;
  }
  
  public static String d(rz paramrz)
  {
    AppMethodBeat.i(188591);
    if (paramrz != null)
    {
      paramrz = paramrz.fRl;
      if (paramrz == null) {}
    }
    for (paramrz = paramrz.fRm;; paramrz = null)
    {
      paramrz = f(paramrz, 0);
      Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", "getEventResult ".concat(String.valueOf(paramrz)));
      AppMethodBeat.o(188591);
      return paramrz;
    }
  }
  
  public static int e(rz paramrz)
  {
    AppMethodBeat.i(188593);
    if (paramrz != null)
    {
      paramrz = paramrz.fRl;
      if (paramrz == null) {}
    }
    for (paramrz = paramrz.fRn;; paramrz = null)
    {
      int i = g(paramrz, 0);
      Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", "getEventCodeType ".concat(String.valueOf(i)));
      AppMethodBeat.o(188593);
      return i;
    }
  }
  
  public static int f(rz paramrz)
  {
    AppMethodBeat.i(188595);
    if (paramrz != null)
    {
      paramrz = paramrz.fRl;
      if (paramrz == null) {}
    }
    for (paramrz = paramrz.fRp;; paramrz = null)
    {
      int i = g(paramrz, 0);
      Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", "getEventCodeVersion ".concat(String.valueOf(i)));
      AppMethodBeat.o(188595);
      return i;
    }
  }
  
  private static String f(ArrayList<Object> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(188600);
    Collection localCollection = (Collection)paramArrayList;
    int i;
    if ((localCollection == null) || (localCollection.isEmpty()))
    {
      i = 1;
      if ((i != 0) || (paramInt < 0) || (paramInt >= paramArrayList.size())) {
        break label145;
      }
      try
      {
        paramArrayList = paramArrayList.get(paramInt);
        kotlin.g.b.p.j(paramArrayList, "list[index]");
        if (paramArrayList == null)
        {
          paramArrayList = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(188600);
          throw paramArrayList;
        }
      }
      catch (Exception paramArrayList)
      {
        Log.printErrStackTrace("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", (Throwable)paramArrayList, "", new Object[0]);
        paramArrayList = "";
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", "getValueString:" + paramArrayList + "   index:" + paramInt);
      AppMethodBeat.o(188600);
      return paramArrayList;
      i = 0;
      break;
      paramArrayList = (String)paramArrayList;
      continue;
      label145:
      paramArrayList = "";
    }
  }
  
  private static int g(ArrayList<Object> paramArrayList, int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(188602);
    Collection localCollection = (Collection)paramArrayList;
    int i;
    int j;
    if ((localCollection == null) || (localCollection.isEmpty()))
    {
      i = 1;
      j = k;
      if (i == 0)
      {
        j = k;
        if (paramInt >= 0)
        {
          j = k;
          if (paramInt < paramArrayList.size()) {
            try
            {
              paramArrayList = paramArrayList.get(paramInt);
              kotlin.g.b.p.j(paramArrayList, "list[index]");
              if (paramArrayList == null)
              {
                paramArrayList = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(188602);
                throw paramArrayList;
              }
            }
            catch (Exception paramArrayList)
            {
              Log.printErrStackTrace("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", (Throwable)paramArrayList, "", new Object[0]);
              i = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      j = i;
      Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", "getValueInt:" + j + "   index:" + paramInt);
      AppMethodBeat.o(188602);
      return j;
      i = 0;
      break;
      i = ((Integer)paramArrayList).intValue();
    }
  }
  
  private static float h(ArrayList<Object> paramArrayList, int paramInt)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(188606);
    Collection localCollection = (Collection)paramArrayList;
    int i;
    float f1;
    if ((localCollection == null) || (localCollection.isEmpty()))
    {
      i = 1;
      f1 = f2;
      if (i == 0)
      {
        f1 = f2;
        if (paramInt >= 0)
        {
          f1 = f2;
          if (paramInt < paramArrayList.size()) {
            try
            {
              paramArrayList = paramArrayList.get(paramInt);
              kotlin.g.b.p.j(paramArrayList, "list[index]");
              if (paramArrayList == null)
              {
                paramArrayList = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(188606);
                throw paramArrayList;
              }
            }
            catch (Exception paramArrayList)
            {
              Log.printErrStackTrace("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", (Throwable)paramArrayList, "", new Object[0]);
              f1 = 0.0F;
            }
          }
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", "getValueFloat:" + f1 + "   index:" + paramInt);
      AppMethodBeat.o(188606);
      return f1;
      i = 0;
      break;
      f1 = ((Float)paramArrayList).floatValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.p
 * JD-Core Version:    0.7.0.1
 */