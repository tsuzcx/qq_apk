package com.tencent.mm.y;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class b
{
  SparseArray<b.a> dFH = new SparseArray();
  HashMap<ac.a, b.a> dFI = new HashMap();
  SparseArray<b.b> dFJ = new SparseArray();
  HashMap<ac.a, b.b> dFK = new HashMap();
  private Random dFL = new Random();
  z dFM = null;
  
  private b.a c(ac.a parama)
  {
    String str = (String)this.dFM.get(parama, null);
    if (str == null) {
      return null;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length != 3)
    {
      y.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
      return null;
    }
    try
    {
      parama = a(parama, Integer.valueOf(arrayOfString[0]).intValue(), unescape(arrayOfString[1]), unescape(arrayOfString[2]));
      return parama;
    }
    catch (Exception parama)
    {
      y.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bk.j(parama) });
      y.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
    }
    return null;
  }
  
  private b.b d(ac.a parama)
  {
    String str = (String)this.dFM.get(parama, null);
    if (str == null) {
      return e(parama);
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      y.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { str });
      return null;
    }
    try
    {
      parama = e(parama);
      int i = 0;
      while (i < arrayOfString.length)
      {
        parama.dFQ.put(arrayOfString[i], unescape(arrayOfString[(i + 1)]));
        i += 2;
      }
      return parama;
    }
    catch (Exception parama)
    {
      y.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bk.j(parama) });
      y.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { str });
    }
    return null;
  }
  
  private static String fA(String paramString)
  {
    return paramString.replaceAll("\\|", "%7C");
  }
  
  private b.a hb(int paramInt)
  {
    String str = (String)this.dFM.get(paramInt, null);
    if (str == null) {
      return null;
    }
    Object localObject = str.split("\\|");
    if (localObject.length != 3)
    {
      y.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
      return null;
    }
    try
    {
      localObject = a(paramInt, Integer.valueOf(localObject[0]).intValue(), unescape(localObject[1]), unescape(localObject[2]));
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bk.j(localException) });
      y.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
    }
    return null;
  }
  
  private b.b hc(int paramInt)
  {
    String str = (String)this.dFM.get(paramInt, null);
    if (str == null) {
      return hd(paramInt);
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      y.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { str });
      return null;
    }
    try
    {
      b.b localb = hd(paramInt);
      paramInt = 0;
      while (paramInt < arrayOfString.length)
      {
        localb.dFP.put(Integer.valueOf(arrayOfString[paramInt]).intValue(), unescape(arrayOfString[(paramInt + 1)]));
        paramInt += 2;
      }
      return localb;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bk.j(localException) });
      y.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { str });
    }
    return null;
  }
  
  private static String unescape(String paramString)
  {
    return paramString.replaceAll("%7C", "|");
  }
  
  final String BR()
  {
    return String.format("%d%04d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.dFL.nextInt(Math.abs(this.dFL.nextInt(2147483647))) % 10000) });
  }
  
  final b.a a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b.a locala = new b.a(this);
    locala.dFD = paramInt1;
    locala.type = paramInt2;
    locala.value = paramString1;
    locala.bJY = paramString2;
    return locala;
  }
  
  final b.a a(ac.a parama, int paramInt, String paramString1, String paramString2)
  {
    b.a locala = new b.a(this);
    locala.dFE = parama;
    locala.type = paramInt;
    locala.value = paramString1;
    locala.bJY = paramString2;
    return locala;
  }
  
  public final b.a a(ac.a parama1, ac.a parama2, int paramInt)
  {
    y.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", new Object[] { parama1, parama2, Integer.valueOf(paramInt) });
    b.a locala = f(parama1);
    if (locala == null)
    {
      y.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      return null;
    }
    if ((locala.type & paramInt) == 0)
    {
      y.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      return null;
    }
    parama2 = g(parama2);
    if (parama2 != null)
    {
      String str = (String)parama2.dFQ.get(parama1.name());
      if ((str != null) && (str.equals(locala.bJY))) {
        return null;
      }
      if (str == null)
      {
        str = BR();
        parama2.dFQ.put(parama1.name(), str);
        a(parama2);
      }
      return locala;
    }
    y.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    return null;
  }
  
  final void a(b.a parama)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(parama.type);
    localStringBuffer.append("|");
    localStringBuffer.append(fA(parama.value));
    localStringBuffer.append("|");
    localStringBuffer.append(fA(parama.bJY));
    if (parama.dFE != null)
    {
      this.dFM.c(parama.dFE, localStringBuffer.toString());
      return;
    }
    this.dFM.o(parama.dFD, localStringBuffer.toString());
  }
  
  final void a(b.b paramb)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1;
    if (paramb.dFG != null)
    {
      localObject1 = paramb.dFQ.entrySet().iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        if (i != 0) {
          localStringBuffer.append("|");
        }
        localStringBuffer.append(str);
        localStringBuffer.append("|");
        localStringBuffer.append(fA((String)localObject2));
        i += 1;
      }
      this.dFM.c(paramb.dFG, localStringBuffer.toString());
      return;
    }
    int i = 0;
    while (i < paramb.dFP.size())
    {
      int j = paramb.dFP.keyAt(i);
      localObject1 = (String)paramb.dFP.get(j);
      if (i != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(j);
      localStringBuffer.append("|");
      localStringBuffer.append(fA((String)localObject1));
      i += 1;
    }
    this.dFM.o(paramb.dFO, localStringBuffer.toString());
  }
  
  final b.b e(ac.a parama)
  {
    b.b localb = new b.b(this);
    localb.dFG = parama;
    return localb;
  }
  
  public final b.a f(ac.a parama)
  {
    b.a locala2 = (b.a)this.dFI.get(parama);
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = c(parama);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.dFI.put(parama, locala2);
        locala1 = locala2;
      }
    }
    return locala1;
  }
  
  final b.b g(ac.a parama)
  {
    b.b localb2 = (b.b)this.dFK.get(parama);
    b.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = d(parama);
      if (localb1 == null)
      {
        y.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        localb1 = null;
      }
    }
    else
    {
      return localb1;
    }
    this.dFK.put(parama, localb1);
    return localb1;
  }
  
  final b.b hd(int paramInt)
  {
    b.b localb = new b.b(this);
    localb.dFO = paramInt;
    return localb;
  }
  
  public final b.a he(int paramInt)
  {
    b.a locala2 = (b.a)this.dFH.get(paramInt);
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = hb(paramInt);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.dFH.put(paramInt, locala2);
        locala1 = locala2;
      }
    }
    return locala1;
  }
  
  final b.b hf(int paramInt)
  {
    b.b localb2 = (b.b)this.dFJ.get(paramInt);
    b.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = hc(paramInt);
      if (localb1 == null)
      {
        y.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        localb1 = null;
      }
    }
    else
    {
      return localb1;
    }
    this.dFJ.put(paramInt, localb1);
    return localb1;
  }
  
  public final b.a u(int paramInt1, int paramInt2, int paramInt3)
  {
    y.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    b.a locala = he(paramInt1);
    if (locala == null)
    {
      y.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      return null;
    }
    if ((locala.type & paramInt3) == 0)
    {
      y.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      return null;
    }
    b.b localb = hf(paramInt2);
    if (localb != null)
    {
      String str = (String)localb.dFP.get(paramInt1);
      if ((str != null) && (str.equals(locala.bJY))) {
        return null;
      }
      if (str == null)
      {
        str = BR();
        localb.dFP.put(paramInt1, str);
        a(localb);
      }
      return locala;
    }
    y.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.y.b
 * JD-Core Version:    0.7.0.1
 */