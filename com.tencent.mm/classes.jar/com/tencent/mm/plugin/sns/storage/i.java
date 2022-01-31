package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class i
{
  public static void h(Long paramLong)
  {
    AppMethodBeat.i(37840);
    g.RL().Ru().set(ac.a.yKn, paramLong);
    AppMethodBeat.o(37840);
  }
  
  public static boolean lS(long paramLong)
  {
    int i = 2;
    int j = 0;
    AppMethodBeat.i(37838);
    Object localObject = ag.cpf().lZ(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(37838);
      return false;
    }
    String[] arrayOfString = ((String)g.RL().Ru().get(ac.a.yKm, "")).split("&");
    boolean bool1;
    if ((arrayOfString.length > 0) && (bo.getBoolean(arrayOfString[0], false)))
    {
      bool1 = true;
      if ((arrayOfString.length < 2) || (!bo.getBoolean(arrayOfString[1], false))) {
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
        long l = bo.getLong(arrayOfString[i], 0L);
        if (l != 0L) {
          localArrayList.add(Long.valueOf(l));
        }
        i += 1;
      }
      bool1 = false;
      break;
    }
    if (((n)localObject).csh().xTS.wNZ == 15) {
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
      AppMethodBeat.o(37838);
      return false;
      if (((n)localObject).csh().xTS.wNZ != 1) {
        break label313;
      }
      if (bool2) {
        break;
      }
      bool2 = true;
    }
    AppMethodBeat.o(37838);
    return false;
    label313:
    AppMethodBeat.o(37838);
    return false;
    g.RL().Ru().set(ac.a.yKm, ((StringBuilder)localObject).toString());
    h(Long.valueOf(paramLong));
    AppMethodBeat.o(37838);
    return true;
  }
  
  public static void lT(long paramLong)
  {
    boolean bool2 = true;
    int j = 0;
    AppMethodBeat.i(37839);
    Object localObject = ((String)g.RL().Ru().get(ac.a.yKm, "")).split("&");
    boolean bool1;
    if ((localObject.length > 0) && (bo.getBoolean(localObject[0], false)))
    {
      bool1 = true;
      if ((localObject.length < 2) || (!bo.getBoolean(localObject[1], false))) {
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
        long l = bo.getLong(localObject[i], 0L);
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
      h((Long)localObject);
      localObject = new StringBuilder().append(bool1).append("&").append(bool2);
      i = j;
      while (i < localArrayList.size())
      {
        ((StringBuilder)localObject).append("&").append(localArrayList.get(i));
        i += 1;
      }
    }
    g.RL().Ru().set(ac.a.yKm, ((StringBuilder)localObject).toString());
    AppMethodBeat.o(37839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.i
 * JD-Core Version:    0.7.0.1
 */