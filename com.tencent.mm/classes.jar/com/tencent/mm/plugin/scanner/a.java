package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  public static boolean CA(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean CB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean ba(int paramInt, String paramString)
  {
    AppMethodBeat.i(79165);
    if (paramInt != 22)
    {
      AppMethodBeat.o(79165);
      return false;
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79165);
      return false;
    }
    Object localObject;
    if ((ah.brt()) || ((Looper.myLooper() == Looper.getMainLooper()) && (!b.PK().lX("com.tencent.mm")))) {
      localObject = chV();
    }
    for (;;)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.startsWith((String)((Iterator)localObject).next()))
        {
          AppMethodBeat.o(79165);
          return true;
          localObject = new HashSet();
          String[] arrayOfString = chU().split("|");
          paramInt = 0;
          while (paramInt < arrayOfString.length)
          {
            if (!bo.isNullOrNil(arrayOfString[paramInt])) {
              ((Set)localObject).add(arrayOfString[paramInt]);
            }
            paramInt += 1;
          }
        }
      }
      AppMethodBeat.o(79165);
      return false;
    }
  }
  
  private static String chU()
  {
    AppMethodBeat.i(79166);
    Object localObject = (Bundle)f.a("com.tencent.mm", null, a.a.class);
    if (localObject != null) {}
    for (localObject = ((Bundle)localObject).getString("wxCodePrefix", "");; localObject = "")
    {
      AppMethodBeat.o(79166);
      return localObject;
    }
  }
  
  private static Set<String> chV()
  {
    AppMethodBeat.i(79167);
    HashSet localHashSet = new HashSet();
    localHashSet.add("k");
    localHashSet.add("l");
    if (ah.brt())
    {
      localObject = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nr();
      if (localObject == null) {
        break label134;
      }
    }
    label134:
    for (Object localObject = ((c)localObject).R("ScanCode", "weAppCodePrefix");; localObject = "")
    {
      ab.v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", new Object[] { localObject });
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("|");
        int i = 0;
        while (i < localObject.length)
        {
          if (!bo.isNullOrNil(localObject[i])) {
            localHashSet.add(localObject[i]);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(79167);
      return localHashSet;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a
 * JD-Core Version:    0.7.0.1
 */