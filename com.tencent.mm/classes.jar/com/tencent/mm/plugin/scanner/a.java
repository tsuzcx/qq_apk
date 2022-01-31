package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  public static boolean aD(int paramInt, String paramString)
  {
    if (paramInt != 22) {}
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          return false;
        } while (bk.bl(paramString));
        if ((!ae.cqV()) && ((Looper.myLooper() != Looper.getMainLooper()) || (b.BT().fC("com.tencent.mm")))) {
          break;
        }
        localObject = bxb();
        localObject = ((Set)localObject).iterator();
      }
    } while (!paramString.startsWith((String)((Iterator)localObject).next()));
    return true;
    HashSet localHashSet = new HashSet();
    Object localObject = (Bundle)f.a("com.tencent.mm", null, a.a.class);
    if (localObject != null) {}
    for (localObject = ((Bundle)localObject).getString("wxCodePrefix", "");; localObject = "")
    {
      localObject = ((String)localObject).split("|");
      paramInt = 0;
      while (paramInt < localObject.length)
      {
        if (!bk.bl(localObject[paramInt])) {
          localHashSet.add(localObject[paramInt]);
        }
        paramInt += 1;
      }
      localObject = localHashSet;
      break;
    }
  }
  
  private static Set<String> bxb()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("k");
    localHashSet.add("l");
    if (ae.cqV())
    {
      localObject = ((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AB();
      if (localObject == null) {
        break label124;
      }
    }
    label124:
    for (Object localObject = ((c)localObject).H("ScanCode", "weAppCodePrefix");; localObject = "")
    {
      y.v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", new Object[] { localObject });
      if (!bk.bl((String)localObject))
      {
        localObject = ((String)localObject).split("|");
        int i = 0;
        while (i < localObject.length)
        {
          if (!bk.bl(localObject[i])) {
            localHashSet.add(localObject[i]);
          }
          i += 1;
        }
      }
      return localHashSet;
    }
  }
  
  public static boolean wL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean wM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a
 * JD-Core Version:    0.7.0.1
 */