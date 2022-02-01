package com.tencent.mm.y;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class b
{
  SparseArray<a> hlX;
  HashMap<ar.a, a> hlY;
  SparseArray<b> hlZ;
  HashMap<ar.a, b> hma;
  private Random hmb;
  ao hmc;
  
  public b()
  {
    AppMethodBeat.i(150060);
    this.hlX = new SparseArray();
    this.hlY = new HashMap();
    this.hlZ = new SparseArray();
    this.hma = new HashMap();
    this.hmb = new Random();
    this.hmc = null;
    AppMethodBeat.o(150060);
  }
  
  private static String Fl(String paramString)
  {
    AppMethodBeat.i(150061);
    paramString = paramString.replaceAll("\\|", "%7C");
    AppMethodBeat.o(150061);
    return paramString;
  }
  
  private static boolean Fm(String paramString)
  {
    AppMethodBeat.i(150067);
    if ((!Util.isNullOrNil(paramString)) && (paramString.matches("^[\\d]+$")))
    {
      AppMethodBeat.o(150067);
      return true;
    }
    AppMethodBeat.o(150067);
    return false;
  }
  
  private a a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150073);
    a locala = new a();
    locala.hlT = paramInt1;
    locala.type = paramInt2;
    locala.value = paramString1;
    locala.dHx = paramString2;
    AppMethodBeat.o(150073);
    return locala;
  }
  
  private a a(ar.a parama, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150074);
    a locala = new a();
    locala.hlU = parama;
    locala.type = paramInt;
    locala.value = paramString1;
    locala.dHx = paramString2;
    AppMethodBeat.o(150074);
    return locala;
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(150063);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(parama.type);
    localStringBuffer.append("|");
    localStringBuffer.append(Fl(parama.value));
    localStringBuffer.append("|");
    localStringBuffer.append(Fl(parama.dHx));
    if (parama.hlU != null)
    {
      this.hmc.set(parama.hlU, localStringBuffer.toString());
      AppMethodBeat.o(150063);
      return;
    }
    this.hmc.set(parama.hlT, localStringBuffer.toString());
    AppMethodBeat.o(150063);
  }
  
  private a c(ar.a parama)
  {
    AppMethodBeat.i(150066);
    String str = (String)this.hmc.get(parama, null);
    if (str == null)
    {
      AppMethodBeat.o(150066);
      return null;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length != 3)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
      AppMethodBeat.o(150066);
      return null;
    }
    try
    {
      parama = a(parama, Integer.valueOf(arrayOfString[0]).intValue(), unescape(arrayOfString[1]), unescape(arrayOfString[2]));
      AppMethodBeat.o(150066);
      return parama;
    }
    catch (Exception parama)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
      Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
      AppMethodBeat.o(150066);
    }
    return null;
  }
  
  private a c(ar.a parama, int paramInt)
  {
    AppMethodBeat.i(150076);
    a locala2 = f(parama);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a(parama, paramInt, "", "");
      this.hlY.put(parama, locala1);
      a(locala1);
    }
    AppMethodBeat.o(150076);
    return locala1;
  }
  
  private a cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150075);
    a locala2 = pL(paramInt1);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a(paramInt1, paramInt2, "", "");
      this.hlX.put(paramInt1, locala1);
      a(locala1);
    }
    AppMethodBeat.o(150075);
    return locala1;
  }
  
  private b d(ar.a parama)
  {
    AppMethodBeat.i(150069);
    String str = (String)this.hmc.get(parama, null);
    if (str == null)
    {
      parama = e(parama);
      AppMethodBeat.o(150069);
      return parama;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { str });
      AppMethodBeat.o(150069);
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        parama = e(parama);
        i = 0;
        if (i < arrayOfString.length) {
          if (Fm(arrayOfString[i])) {
            parama.hmf.put(Integer.valueOf(arrayOfString[i]).intValue(), unescape(arrayOfString[(i + 1)]));
          } else {
            parama.hmg.put(arrayOfString[i], unescape(arrayOfString[(i + 1)]));
          }
        }
      }
      catch (Exception parama)
      {
        Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
        Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { str });
        AppMethodBeat.o(150069);
        return null;
      }
      AppMethodBeat.o(150069);
      return parama;
      i += 2;
    }
  }
  
  private b e(ar.a parama)
  {
    AppMethodBeat.i(150072);
    b localb = new b();
    localb.hlW = parama;
    AppMethodBeat.o(150072);
    return localb;
  }
  
  private b g(ar.a parama)
  {
    AppMethodBeat.i(150080);
    b localb2 = (b)this.hma.get(parama);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = d(parama);
      if (localb1 == null)
      {
        Log.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        AppMethodBeat.o(150080);
        return null;
      }
      this.hma.put(parama, localb1);
    }
    AppMethodBeat.o(150080);
    return localb1;
  }
  
  private a pI(int paramInt)
  {
    AppMethodBeat.i(150065);
    String str = (String)this.hmc.get(paramInt, null);
    if (str == null)
    {
      AppMethodBeat.o(150065);
      return null;
    }
    Object localObject = str.split("\\|");
    if (localObject.length != 3)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
      AppMethodBeat.o(150065);
      return null;
    }
    try
    {
      localObject = a(paramInt, Integer.valueOf(localObject[0]).intValue(), unescape(localObject[1]), unescape(localObject[2]));
      AppMethodBeat.o(150065);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
      AppMethodBeat.o(150065);
    }
    return null;
  }
  
  private b pJ(int paramInt)
  {
    AppMethodBeat.i(150068);
    Object localObject = (String)this.hmc.get(paramInt, null);
    if (localObject == null)
    {
      localObject = pK(paramInt);
      AppMethodBeat.o(150068);
      return localObject;
    }
    String[] arrayOfString = ((String)localObject).split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { localObject });
      AppMethodBeat.o(150068);
      return null;
    }
    for (;;)
    {
      b localb;
      try
      {
        localb = pK(paramInt);
        paramInt = 0;
        if (paramInt < arrayOfString.length) {
          if (Fm(arrayOfString[paramInt])) {
            localb.hmf.put(Integer.valueOf(arrayOfString[paramInt]).intValue(), unescape(arrayOfString[(paramInt + 1)]));
          } else {
            localb.hmg.put(arrayOfString[paramInt], unescape(arrayOfString[(paramInt + 1)]));
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { localObject });
        AppMethodBeat.o(150068);
        return null;
      }
      AppMethodBeat.o(150068);
      return localb;
      paramInt += 2;
    }
  }
  
  private static String unescape(String paramString)
  {
    AppMethodBeat.i(150062);
    paramString = paramString.replaceAll("%7C", "|");
    AppMethodBeat.o(150062);
    return paramString;
  }
  
  public final a K(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150083);
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    a locala = pL(paramInt1);
    if (locala == null)
    {
      Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      AppMethodBeat.o(150083);
      return null;
    }
    if ((locala.type & paramInt3) == 0)
    {
      Log.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      AppMethodBeat.o(150083);
      return null;
    }
    b localb = pM(paramInt2);
    if (localb != null)
    {
      String str = (String)localb.hmf.get(paramInt1);
      if ((str != null) && (str.equals(locala.dHx)))
      {
        AppMethodBeat.o(150083);
        return null;
      }
      if (str == null)
      {
        str = axT();
        localb.hmf.put(paramInt1, str);
        a(localb);
      }
      AppMethodBeat.o(150083);
      return locala;
    }
    Log.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    AppMethodBeat.o(150083);
    return null;
  }
  
  public final a a(ar.a parama1, ar.a parama2, int paramInt)
  {
    AppMethodBeat.i(150084);
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", new Object[] { parama1, parama2, Integer.valueOf(paramInt) });
    a locala = f(parama1);
    if (locala == null)
    {
      Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      AppMethodBeat.o(150084);
      return null;
    }
    if ((locala.type & paramInt) == 0)
    {
      Log.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      AppMethodBeat.o(150084);
      return null;
    }
    parama2 = g(parama2);
    if (parama2 != null)
    {
      String str = (String)parama2.hmg.get(parama1.name());
      if ((str != null) && (str.equals(locala.dHx)))
      {
        AppMethodBeat.o(150084);
        return null;
      }
      if (str == null)
      {
        str = axT();
        parama2.hmg.put(parama1.name(), str);
        a(parama2);
      }
      AppMethodBeat.o(150084);
      return locala;
    }
    Log.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    AppMethodBeat.o(150084);
    return null;
  }
  
  final void a(b paramb)
  {
    int m = 0;
    AppMethodBeat.i(150064);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = paramb.hmg.entrySet().iterator();
    int i = 0;
    int j;
    int k;
    for (;;)
    {
      j = i;
      k = m;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if (i != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(str);
      localStringBuffer.append("|");
      localStringBuffer.append(Fl((String)localObject2));
      i += 1;
    }
    while (k < paramb.hmf.size())
    {
      i = paramb.hmf.keyAt(k);
      localObject1 = (String)paramb.hmf.get(i);
      if (j != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(i);
      localStringBuffer.append("|");
      localStringBuffer.append(Fl((String)localObject1));
      j += 1;
      k += 1;
    }
    if (paramb.hlW != null)
    {
      this.hmc.set(paramb.hlW, localStringBuffer.toString());
      AppMethodBeat.o(150064);
      return;
    }
    this.hmc.set(paramb.hme, localStringBuffer.toString());
    AppMethodBeat.o(150064);
  }
  
  final String axT()
  {
    AppMethodBeat.i(150070);
    String str = String.format("%d%04d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.hmb.nextInt(Math.abs(this.hmb.nextInt(2147483647))) % 10000) });
    AppMethodBeat.o(150070);
    return str;
  }
  
  public final void b(ar.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(150082);
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", new Object[] { parama, Integer.valueOf(paramInt), paramString });
    parama = c(parama, paramInt);
    parama.value = paramString;
    parama.type = paramInt;
    parama.dHx = axT();
    a(parama);
    AppMethodBeat.o(150082);
  }
  
  public final void d(ar.a parama1, ar.a parama2)
  {
    AppMethodBeat.i(150085);
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", new Object[] { parama1, parama2 });
    a locala = f(parama1);
    if (locala == null)
    {
      Log.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
      AppMethodBeat.o(150085);
      return;
    }
    b localb2 = g(parama2);
    b localb1 = localb2;
    if (localb2 == null)
    {
      Log.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
      localb1 = e(parama2);
      this.hma.put(parama2, localb1);
    }
    localb1.hmg.put(parama1.name(), locala.dHx);
    a(localb1);
    AppMethodBeat.o(150085);
  }
  
  public final a f(ar.a parama)
  {
    AppMethodBeat.i(150078);
    a locala2 = (a)this.hlY.get(parama);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = c(parama);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.hlY.put(parama, locala2);
        locala1 = locala2;
      }
    }
    AppMethodBeat.o(150078);
    return locala1;
  }
  
  public final void g(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(150081);
    Log.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a locala = cR(paramInt1, paramInt2);
    locala.value = paramString;
    locala.type = paramInt2;
    locala.dHx = axT();
    a(locala);
    AppMethodBeat.o(150081);
  }
  
  final b pK(int paramInt)
  {
    AppMethodBeat.i(150071);
    b localb = new b();
    localb.hme = paramInt;
    AppMethodBeat.o(150071);
    return localb;
  }
  
  public final a pL(int paramInt)
  {
    AppMethodBeat.i(150077);
    a locala2 = (a)this.hlX.get(paramInt);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = pI(paramInt);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.hlX.put(paramInt, locala2);
        locala1 = locala2;
      }
    }
    AppMethodBeat.o(150077);
    return locala1;
  }
  
  final b pM(int paramInt)
  {
    AppMethodBeat.i(150079);
    b localb2 = (b)this.hlZ.get(paramInt);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = pJ(paramInt);
      if (localb1 == null)
      {
        Log.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        AppMethodBeat.o(150079);
        return null;
      }
      this.hlZ.put(paramInt, localb1);
    }
    AppMethodBeat.o(150079);
    return localb1;
  }
  
  public final class a
  {
    String dHx;
    int hlT;
    ar.a hlU;
    int type;
    public String value;
    
    public a() {}
  }
  
  public final class b
  {
    ar.a hlW;
    int hme;
    SparseArray<String> hmf;
    HashMap<String, String> hmg;
    
    public b()
    {
      AppMethodBeat.i(150059);
      this.hmf = new SparseArray();
      this.hmg = new HashMap();
      AppMethodBeat.o(150059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.y.b
 * JD-Core Version:    0.7.0.1
 */