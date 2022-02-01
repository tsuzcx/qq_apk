package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class i
{
  public static void f(Long paramLong)
  {
    AppMethodBeat.i(97449);
    g.agR().agA().set(ah.a.GRs, paramLong);
    AppMethodBeat.o(97449);
  }
  
  public static boolean xD(long paramLong)
  {
    int i = 2;
    int j = 0;
    AppMethodBeat.i(97447);
    Object localObject = af.dHR().xK(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(97447);
      return false;
    }
    String[] arrayOfString = ((String)g.agR().agA().get(ah.a.GRr, "")).split("&");
    boolean bool1;
    if ((arrayOfString.length > 0) && (bs.getBoolean(arrayOfString[0], false)))
    {
      bool1 = true;
      if ((arrayOfString.length < 2) || (!bs.getBoolean(arrayOfString[1], false))) {
        break label154;
      }
    }
    ArrayList localArrayList;
    label154:
    for (boolean bool2 = true;; bool2 = false)
    {
      localArrayList = new ArrayList();
      while (i < arrayOfString.length)
      {
        long l = bs.getLong(arrayOfString[i], 0L);
        if (l != 0L) {
          localArrayList.add(Long.valueOf(l));
        }
        i += 1;
      }
      bool1 = false;
      break;
    }
    if (((p)localObject).dLV().FQo.Ety == 15) {
      if (!bool1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (!localArrayList.contains(Long.valueOf(paramLong))) {
        localArrayList.add(Long.valueOf(paramLong));
      }
      localObject = new StringBuilder().append(bool1).append("&").append(bool2);
      i = j;
      while (i < localArrayList.size())
      {
        ((StringBuilder)localObject).append("&").append(localArrayList.get(i));
        i += 1;
      }
      AppMethodBeat.o(97447);
      return false;
      if (((p)localObject).dLV().FQo.Ety != 1) {
        break label313;
      }
      if (bool2) {
        break;
      }
      bool2 = true;
    }
    AppMethodBeat.o(97447);
    return false;
    label313:
    AppMethodBeat.o(97447);
    return false;
    g.agR().agA().set(ah.a.GRr, ((StringBuilder)localObject).toString());
    f(Long.valueOf(paramLong));
    AppMethodBeat.o(97447);
    return true;
  }
  
  public static void xE(long paramLong)
  {
    boolean bool2 = true;
    int j = 0;
    AppMethodBeat.i(97448);
    Object localObject = ((String)g.agR().agA().get(ah.a.GRr, "")).split("&");
    boolean bool1;
    if ((localObject.length > 0) && (bs.getBoolean(localObject[0], false)))
    {
      bool1 = true;
      if ((localObject.length < 2) || (!bs.getBoolean(localObject[1], false))) {
        break label133;
      }
    }
    ArrayList localArrayList;
    int i;
    for (;;)
    {
      localArrayList = new ArrayList();
      i = 2;
      while (i < localObject.length)
      {
        long l = bs.getLong(localObject[i], 0L);
        if (l != 0L) {
          localArrayList.add(Long.valueOf(l));
        }
        i += 1;
      }
      bool1 = false;
      break;
      label133:
      bool2 = false;
    }
    localArrayList.remove(Long.valueOf(paramLong));
    Collections.reverse(localArrayList);
    if (localArrayList.size() > 0) {}
    for (localObject = (Long)localArrayList.get(0);; localObject = null)
    {
      f((Long)localObject);
      localObject = new StringBuilder().append(bool1).append("&").append(bool2);
      i = j;
      while (i < localArrayList.size())
      {
        ((StringBuilder)localObject).append("&").append(localArrayList.get(i));
        i += 1;
      }
    }
    g.agR().agA().set(ah.a.GRr, ((StringBuilder)localObject).toString());
    AppMethodBeat.o(97448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.i
 * JD-Core Version:    0.7.0.1
 */