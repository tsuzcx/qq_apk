package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class n
{
  public static void m(Long paramLong)
  {
    AppMethodBeat.i(97449);
    h.baE().ban().set(at.a.acWS, paramLong);
    AppMethodBeat.o(97449);
  }
  
  public static boolean vf(long paramLong)
  {
    int i = 2;
    int j = 0;
    AppMethodBeat.i(97447);
    Object localObject = al.hgB().vj(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(97447);
      return false;
    }
    String[] arrayOfString = ((String)h.baE().ban().get(at.a.acWR, "")).split("&");
    boolean bool1;
    if ((arrayOfString.length > 0) && (Util.getBoolean(arrayOfString[0], false)))
    {
      bool1 = true;
      if ((arrayOfString.length < 2) || (!Util.getBoolean(arrayOfString[1], false))) {
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
        long l = Util.getLong(arrayOfString[i], 0L);
        if (l != 0L) {
          localArrayList.add(Long.valueOf(l));
        }
        i += 1;
      }
      bool1 = false;
      break;
    }
    if (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq == 15) {
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
      if (((SnsInfo)localObject).getTimeLine().ContentObj.Zpq != 1) {
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
    h.baE().ban().set(at.a.acWR, ((StringBuilder)localObject).toString());
    m(Long.valueOf(paramLong));
    AppMethodBeat.o(97447);
    return true;
  }
  
  public static void vg(long paramLong)
  {
    boolean bool2 = true;
    int j = 0;
    AppMethodBeat.i(97448);
    Object localObject = ((String)h.baE().ban().get(at.a.acWR, "")).split("&");
    boolean bool1;
    if ((localObject.length > 0) && (Util.getBoolean(localObject[0], false)))
    {
      bool1 = true;
      if ((localObject.length < 2) || (!Util.getBoolean(localObject[1], false))) {
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
        long l = Util.getLong(localObject[i], 0L);
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
      m((Long)localObject);
      localObject = new StringBuilder().append(bool1).append("&").append(bool2);
      i = j;
      while (i < localArrayList.size())
      {
        ((StringBuilder)localObject).append("&").append(localArrayList.get(i));
        i += 1;
      }
    }
    h.baE().ban().set(at.a.acWR, ((StringBuilder)localObject).toString());
    AppMethodBeat.o(97448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.n
 * JD-Core Version:    0.7.0.1
 */