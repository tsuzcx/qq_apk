package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.autogen.a.to.a;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/QBarOfImageFileResultEventDataParser;", "", "()V", "TAG", "", "getAllEventCodePointCenterX", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "event", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "getAllEventCodePointCenterY", "getAllEventCodeType", "", "getAllEventCodeVersion", "getAllEventResult", "getAllQBarDataOfImage", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "getEventCodeName", "getEventCodePointCenterX", "getEventCodePointCenterY", "getEventCodeType", "getEventCodeVersion", "getEventResult", "getValueFloat", "list", "index", "getValueInt", "getValueString", "temporary_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o YtW;
  
  static
  {
    AppMethodBeat.i(245542);
    YtW = new o();
    AppMethodBeat.o(245542);
  }
  
  public static ArrayList<ImageQBarDataBean> b(to paramto)
  {
    AppMethodBeat.i(245505);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = c(paramto);
    int i;
    int j;
    label32:
    Object localObject1;
    label40:
    Object localObject2;
    int k;
    label58:
    ImageQBarDataBean localImageQBarDataBean;
    if (paramto == null)
    {
      i = 1;
      if (paramto != null) {
        break label280;
      }
      j = 1;
      if (paramto != null) {
        break label305;
      }
      localObject1 = "";
      localObject2 = (Iterable)localObject3;
      k = 0;
      localObject3 = ((Iterable)localObject2).iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label508;
      }
      localObject2 = ((Iterator)localObject3).next();
      if (k < 0) {
        p.kkW();
      }
      localObject2 = (String)localObject2;
      localImageQBarDataBean = new ImageQBarDataBean();
      localImageQBarDataBean.OGQ = ((String)localObject2);
      if (paramto != null) {
        break label346;
      }
      localObject2 = null;
      label114:
      localImageQBarDataBean.typeName = k((ArrayList)localObject2, k);
      if (paramto != null) {
        break label373;
      }
      localObject2 = null;
      label132:
      localImageQBarDataBean.hDb = l((ArrayList)localObject2, k);
      if (paramto != null) {
        break label400;
      }
      localObject2 = null;
      label150:
      localImageQBarDataBean.hDc = l((ArrayList)localObject2, k);
      if (paramto != null) {
        break label427;
      }
      localObject2 = null;
      label168:
      localImageQBarDataBean.priorityLevel = l((ArrayList)localObject2, k);
      if (paramto != null) {
        break label454;
      }
      localObject2 = null;
      label186:
      localImageQBarDataBean.OGR = (m((ArrayList)localObject2, k) / i);
      if (paramto != null) {
        break label481;
      }
      localObject2 = null;
    }
    for (;;)
    {
      localImageQBarDataBean.OGS = (m((ArrayList)localObject2, k) / j);
      localImageQBarDataBean.hXo = i;
      localImageQBarDataBean.hXp = j;
      localImageQBarDataBean.filePath = ((String)localObject1);
      localArrayList.add(localImageQBarDataBean);
      k += 1;
      break label58;
      localObject1 = paramto.hXi;
      if (localObject1 == null)
      {
        i = 1;
        break;
      }
      i = ((to.a)localObject1).hXo;
      break;
      label280:
      localObject1 = paramto.hXi;
      if (localObject1 == null)
      {
        j = 1;
        break label32;
      }
      j = ((to.a)localObject1).hXp;
      break label32;
      label305:
      localObject1 = paramto.hXi;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label40;
      }
      localObject2 = ((to.a)localObject1).filePath;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label40;
      }
      localObject1 = "";
      break label40;
      label346:
      localObject2 = paramto.hXi;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label114;
      }
      localObject2 = ((to.a)localObject2).hXl;
      break label114;
      label373:
      localObject2 = paramto.hXi;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label132;
      }
      localObject2 = ((to.a)localObject2).hXk;
      break label132;
      label400:
      localObject2 = paramto.hXi;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label150;
      }
      localObject2 = ((to.a)localObject2).hXm;
      break label150;
      label427:
      localObject2 = paramto.hXi;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label168;
      }
      localObject2 = ((to.a)localObject2).hXn;
      break label168;
      label454:
      localObject2 = paramto.hXi;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label186;
      }
      localObject2 = ((to.a)localObject2).hXq;
      break label186;
      label481:
      localObject2 = paramto.hXi;
      if (localObject2 == null) {
        localObject2 = null;
      } else {
        localObject2 = ((to.a)localObject2).hXr;
      }
    }
    label508:
    AppMethodBeat.o(245505);
    return localArrayList;
  }
  
  private static ArrayList<String> c(to paramto)
  {
    AppMethodBeat.i(245510);
    ArrayList localArrayList = new ArrayList();
    if (paramto != null)
    {
      paramto = paramto.hXi;
      if (paramto != null)
      {
        paramto = paramto.hXj;
        if (paramto != null)
        {
          paramto = ((Iterable)paramto).iterator();
          label96:
          while (paramto.hasNext())
          {
            Object localObject = paramto.next();
            if ((localObject instanceof String))
            {
              if (n.bp((CharSequence)localObject)) {}
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
    AppMethodBeat.o(245510);
    return localArrayList;
  }
  
  public static String d(to paramto)
  {
    Object localObject = null;
    AppMethodBeat.i(245515);
    if (paramto == null) {
      paramto = localObject;
    }
    for (;;)
    {
      paramto = k(paramto, 0);
      Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", s.X("getEventResult ", paramto));
      AppMethodBeat.o(245515);
      return paramto;
      to.a locala = paramto.hXi;
      paramto = localObject;
      if (locala != null) {
        paramto = locala.hXj;
      }
    }
  }
  
  public static int e(to paramto)
  {
    Object localObject = null;
    AppMethodBeat.i(245518);
    if (paramto == null) {
      paramto = localObject;
    }
    for (;;)
    {
      int i = l(paramto, 0);
      Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", s.X("getEventCodeType ", Integer.valueOf(i)));
      AppMethodBeat.o(245518);
      return i;
      to.a locala = paramto.hXi;
      paramto = localObject;
      if (locala != null) {
        paramto = locala.hXk;
      }
    }
  }
  
  public static int f(to paramto)
  {
    Object localObject = null;
    AppMethodBeat.i(245525);
    if (paramto == null) {
      paramto = localObject;
    }
    for (;;)
    {
      int i = l(paramto, 0);
      Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", s.X("getEventCodeVersion ", Integer.valueOf(i)));
      AppMethodBeat.o(245525);
      return i;
      to.a locala = paramto.hXi;
      paramto = localObject;
      if (locala != null) {
        paramto = locala.hXm;
      }
    }
  }
  
  private static String k(ArrayList<Object> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(245531);
    Collection localCollection = (Collection)paramArrayList;
    int i;
    if ((localCollection == null) || (localCollection.isEmpty()))
    {
      i = 1;
      if ((i != 0) || (paramInt < 0) || (paramInt >= paramArrayList.size())) {
        break label123;
      }
    }
    for (;;)
    {
      try
      {
        paramArrayList = paramArrayList.get(paramInt);
        s.s(paramArrayList, "list[index]");
        paramArrayList = (String)paramArrayList;
        Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", "getValueString:" + paramArrayList + "   index:" + paramInt);
        AppMethodBeat.o(245531);
        return paramArrayList;
        i = 0;
      }
      catch (Exception paramArrayList)
      {
        Log.printErrStackTrace("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", (Throwable)paramArrayList, "", new Object[0]);
        paramArrayList = "";
        continue;
      }
      label123:
      paramArrayList = "";
    }
  }
  
  private static int l(ArrayList<Object> paramArrayList, int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(245535);
    Collection localCollection = (Collection)paramArrayList;
    int i;
    if ((localCollection == null) || (localCollection.isEmpty())) {
      i = 1;
    }
    for (;;)
    {
      int j = k;
      if (i == 0)
      {
        j = k;
        if (paramInt >= 0)
        {
          j = k;
          if (paramInt >= paramArrayList.size()) {}
        }
      }
      try
      {
        paramArrayList = paramArrayList.get(paramInt);
        s.s(paramArrayList, "list[index]");
        i = ((Integer)paramArrayList).intValue();
        j = i;
        Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", "getValueInt:" + j + "   index:" + paramInt);
        AppMethodBeat.o(245535);
        return j;
        i = 0;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", (Throwable)paramArrayList, "", new Object[0]);
          i = 0;
        }
      }
    }
  }
  
  private static float m(ArrayList<Object> paramArrayList, int paramInt)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(245537);
    Collection localCollection = (Collection)paramArrayList;
    int i;
    if ((localCollection == null) || (localCollection.isEmpty())) {
      i = 1;
    }
    for (;;)
    {
      float f1 = f2;
      if (i == 0)
      {
        f1 = f2;
        if (paramInt >= 0)
        {
          f1 = f2;
          if (paramInt >= paramArrayList.size()) {}
        }
      }
      try
      {
        paramArrayList = paramArrayList.get(paramInt);
        s.s(paramArrayList, "list[index]");
        f1 = ((Float)paramArrayList).floatValue();
        Log.i("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", "getValueFloat:" + f1 + "   index:" + paramInt);
        AppMethodBeat.o(245537);
        return f1;
        i = 0;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.scanner.QBarOfImageFileResultEventDataParser", (Throwable)paramArrayList, "", new Object[0]);
          f1 = 0.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */