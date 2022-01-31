package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class i
{
  public static boolean gm(long paramLong)
  {
    int i = 2;
    int j = 0;
    Object localObject = af.bDF().gt(paramLong);
    if (localObject == null) {}
    boolean bool2;
    ArrayList localArrayList;
    label144:
    do
    {
      return false;
      String[] arrayOfString = ((String)g.DP().Dz().get(ac.a.uzy, "")).split("&");
      if ((arrayOfString.length > 0) && (bk.getBoolean(arrayOfString[0], false)))
      {
        bool1 = true;
        if ((arrayOfString.length < 2) || (!bk.getBoolean(arrayOfString[1], false))) {
          break label144;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        localArrayList = new ArrayList();
        while (i < arrayOfString.length)
        {
          long l = bk.getLong(arrayOfString[i], 0L);
          if (l != 0L) {
            localArrayList.add(Long.valueOf(l));
          }
          i += 1;
        }
        bool1 = false;
        break;
      }
      if (((n)localObject).bGe().tNr.sPI != 15) {
        break;
      }
    } while (bool1);
    boolean bool1 = true;
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
      if ((((n)localObject).bGe().tNr.sPI != 1) || (bool2)) {
        break;
      }
      bool2 = true;
    }
    g.DP().Dz().c(ac.a.uzy, ((StringBuilder)localObject).toString());
    i(Long.valueOf(paramLong));
    return true;
  }
  
  public static void gn(long paramLong)
  {
    boolean bool2 = true;
    int j = 0;
    Object localObject = ((String)g.DP().Dz().get(ac.a.uzy, "")).split("&");
    boolean bool1;
    if ((localObject.length > 0) && (bk.getBoolean(localObject[0], false)))
    {
      bool1 = true;
      if ((localObject.length < 2) || (!bk.getBoolean(localObject[1], false))) {
        break label128;
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
        long l = bk.getLong(localObject[i], 0L);
        if (l != 0L) {
          localArrayList.add(Long.valueOf(l));
        }
        i += 1;
      }
      bool1 = false;
      break;
      label128:
      bool2 = false;
    }
    localArrayList.remove(Long.valueOf(paramLong));
    Collections.reverse(localArrayList);
    if (localArrayList.size() > 0) {}
    for (localObject = (Long)localArrayList.get(0);; localObject = null)
    {
      i((Long)localObject);
      localObject = new StringBuilder().append(bool1).append("&").append(bool2);
      i = j;
      while (i < localArrayList.size())
      {
        ((StringBuilder)localObject).append("&").append(localArrayList.get(i));
        i += 1;
      }
    }
    g.DP().Dz().c(ac.a.uzy, ((StringBuilder)localObject).toString());
  }
  
  public static void i(Long paramLong)
  {
    g.DP().Dz().c(ac.a.uzz, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.i
 * JD-Core Version:    0.7.0.1
 */