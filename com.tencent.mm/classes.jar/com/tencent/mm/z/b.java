package com.tencent.mm.z;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class b
{
  SparseArray<a> fYn;
  HashMap<ae.a, a> fYo;
  SparseArray<b> fYp;
  HashMap<ae.a, b> fYq;
  private Random fYr;
  ab fYs;
  
  public b()
  {
    AppMethodBeat.i(150060);
    this.fYn = new SparseArray();
    this.fYo = new HashMap();
    this.fYp = new SparseArray();
    this.fYq = new HashMap();
    this.fYr = new Random();
    this.fYs = null;
    AppMethodBeat.o(150060);
  }
  
  private a a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150073);
    a locala = new a();
    locala.fYj = paramInt1;
    locala.type = paramInt2;
    locala.value = paramString1;
    locala.dgo = paramString2;
    AppMethodBeat.o(150073);
    return locala;
  }
  
  private a a(ae.a parama, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150074);
    a locala = new a();
    locala.fYk = parama;
    locala.type = paramInt;
    locala.value = paramString1;
    locala.dgo = paramString2;
    AppMethodBeat.o(150074);
    return locala;
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(150063);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(parama.type);
    localStringBuffer.append("|");
    localStringBuffer.append(qj(parama.value));
    localStringBuffer.append("|");
    localStringBuffer.append(qj(parama.dgo));
    if (parama.fYk != null)
    {
      this.fYs.set(parama.fYk, localStringBuffer.toString());
      AppMethodBeat.o(150063);
      return;
    }
    this.fYs.set(parama.fYj, localStringBuffer.toString());
    AppMethodBeat.o(150063);
  }
  
  private a c(ae.a parama)
  {
    AppMethodBeat.i(150066);
    String str = (String)this.fYs.get(parama, null);
    if (str == null)
    {
      AppMethodBeat.o(150066);
      return null;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length != 3)
    {
      ad.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
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
      ad.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bt.m(parama) });
      ad.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
      AppMethodBeat.o(150066);
    }
    return null;
  }
  
  private a c(ae.a parama, int paramInt)
  {
    AppMethodBeat.i(150076);
    a locala2 = f(parama);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a(parama, paramInt, "", "");
      this.fYo.put(parama, locala1);
      a(locala1);
    }
    AppMethodBeat.o(150076);
    return locala1;
  }
  
  private a cL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150075);
    a locala2 = lX(paramInt1);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a(paramInt1, paramInt2, "", "");
      this.fYn.put(paramInt1, locala1);
      a(locala1);
    }
    AppMethodBeat.o(150075);
    return locala1;
  }
  
  private b d(ae.a parama)
  {
    AppMethodBeat.i(150069);
    String str = (String)this.fYs.get(parama, null);
    if (str == null)
    {
      parama = e(parama);
      AppMethodBeat.o(150069);
      return parama;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      ad.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { str });
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
          if (qk(arrayOfString[i])) {
            parama.fYv.put(Integer.valueOf(arrayOfString[i]).intValue(), unescape(arrayOfString[(i + 1)]));
          } else {
            parama.fYw.put(arrayOfString[i], unescape(arrayOfString[(i + 1)]));
          }
        }
      }
      catch (Exception parama)
      {
        ad.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bt.m(parama) });
        ad.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { str });
        AppMethodBeat.o(150069);
        return null;
      }
      AppMethodBeat.o(150069);
      return parama;
      i += 2;
    }
  }
  
  private b e(ae.a parama)
  {
    AppMethodBeat.i(150072);
    b localb = new b();
    localb.fYm = parama;
    AppMethodBeat.o(150072);
    return localb;
  }
  
  private b g(ae.a parama)
  {
    AppMethodBeat.i(150080);
    b localb2 = (b)this.fYq.get(parama);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = d(parama);
      if (localb1 == null)
      {
        ad.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        AppMethodBeat.o(150080);
        return null;
      }
      this.fYq.put(parama, localb1);
    }
    AppMethodBeat.o(150080);
    return localb1;
  }
  
  private a lU(int paramInt)
  {
    AppMethodBeat.i(150065);
    String str = (String)this.fYs.get(paramInt, null);
    if (str == null)
    {
      AppMethodBeat.o(150065);
      return null;
    }
    Object localObject = str.split("\\|");
    if (localObject.length != 3)
    {
      ad.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
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
      ad.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bt.m(localException) });
      ad.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
      AppMethodBeat.o(150065);
    }
    return null;
  }
  
  private b lV(int paramInt)
  {
    AppMethodBeat.i(150068);
    Object localObject = (String)this.fYs.get(paramInt, null);
    if (localObject == null)
    {
      localObject = lW(paramInt);
      AppMethodBeat.o(150068);
      return localObject;
    }
    String[] arrayOfString = ((String)localObject).split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      ad.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { localObject });
      AppMethodBeat.o(150068);
      return null;
    }
    for (;;)
    {
      b localb;
      try
      {
        localb = lW(paramInt);
        paramInt = 0;
        if (paramInt < arrayOfString.length) {
          if (qk(arrayOfString[paramInt])) {
            localb.fYv.put(Integer.valueOf(arrayOfString[paramInt]).intValue(), unescape(arrayOfString[(paramInt + 1)]));
          } else {
            localb.fYw.put(arrayOfString[paramInt], unescape(arrayOfString[(paramInt + 1)]));
          }
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bt.m(localException) });
        ad.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { localObject });
        AppMethodBeat.o(150068);
        return null;
      }
      AppMethodBeat.o(150068);
      return localb;
      paramInt += 2;
    }
  }
  
  private static String qj(String paramString)
  {
    AppMethodBeat.i(150061);
    paramString = paramString.replaceAll("\\|", "%7C");
    AppMethodBeat.o(150061);
    return paramString;
  }
  
  private static boolean qk(String paramString)
  {
    AppMethodBeat.i(150067);
    if ((!bt.isNullOrNil(paramString)) && (paramString.matches("^[\\d]+$")))
    {
      AppMethodBeat.o(150067);
      return true;
    }
    AppMethodBeat.o(150067);
    return false;
  }
  
  private static String unescape(String paramString)
  {
    AppMethodBeat.i(150062);
    paramString = paramString.replaceAll("%7C", "|");
    AppMethodBeat.o(150062);
    return paramString;
  }
  
  public final a I(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150083);
    ad.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    a locala = lX(paramInt1);
    if (locala == null)
    {
      ad.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      AppMethodBeat.o(150083);
      return null;
    }
    if ((locala.type & paramInt3) == 0)
    {
      ad.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      AppMethodBeat.o(150083);
      return null;
    }
    b localb = lY(paramInt2);
    if (localb != null)
    {
      String str = (String)localb.fYv.get(paramInt1);
      if ((str != null) && (str.equals(locala.dgo)))
      {
        AppMethodBeat.o(150083);
        return null;
      }
      if (str == null)
      {
        str = adp();
        localb.fYv.put(paramInt1, str);
        a(localb);
      }
      AppMethodBeat.o(150083);
      return locala;
    }
    ad.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    AppMethodBeat.o(150083);
    return null;
  }
  
  public final a a(ae.a parama1, ae.a parama2, int paramInt)
  {
    AppMethodBeat.i(150084);
    ad.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", new Object[] { parama1, parama2, Integer.valueOf(paramInt) });
    a locala = f(parama1);
    if (locala == null)
    {
      ad.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      AppMethodBeat.o(150084);
      return null;
    }
    if ((locala.type & paramInt) == 0)
    {
      ad.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      AppMethodBeat.o(150084);
      return null;
    }
    parama2 = g(parama2);
    if (parama2 != null)
    {
      String str = (String)parama2.fYw.get(parama1.name());
      if ((str != null) && (str.equals(locala.dgo)))
      {
        AppMethodBeat.o(150084);
        return null;
      }
      if (str == null)
      {
        str = adp();
        parama2.fYw.put(parama1.name(), str);
        a(parama2);
      }
      AppMethodBeat.o(150084);
      return locala;
    }
    ad.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    AppMethodBeat.o(150084);
    return null;
  }
  
  final void a(b paramb)
  {
    int m = 0;
    AppMethodBeat.i(150064);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = paramb.fYw.entrySet().iterator();
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
      localStringBuffer.append(qj((String)localObject2));
      i += 1;
    }
    while (k < paramb.fYv.size())
    {
      i = paramb.fYv.keyAt(k);
      localObject1 = (String)paramb.fYv.get(i);
      if (j != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(i);
      localStringBuffer.append("|");
      localStringBuffer.append(qj((String)localObject1));
      j += 1;
      k += 1;
    }
    if (paramb.fYm != null)
    {
      this.fYs.set(paramb.fYm, localStringBuffer.toString());
      AppMethodBeat.o(150064);
      return;
    }
    this.fYs.set(paramb.fYu, localStringBuffer.toString());
    AppMethodBeat.o(150064);
  }
  
  final String adp()
  {
    AppMethodBeat.i(150070);
    String str = String.format("%d%04d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.fYr.nextInt(Math.abs(this.fYr.nextInt(2147483647))) % 10000) });
    AppMethodBeat.o(150070);
    return str;
  }
  
  public final void b(ae.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(150082);
    ad.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", new Object[] { parama, Integer.valueOf(paramInt), paramString });
    parama = c(parama, paramInt);
    parama.value = paramString;
    parama.type = paramInt;
    parama.dgo = adp();
    a(parama);
    AppMethodBeat.o(150082);
  }
  
  public final void d(ae.a parama1, ae.a parama2)
  {
    AppMethodBeat.i(150085);
    ad.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", new Object[] { parama1, parama2 });
    a locala = f(parama1);
    if (locala == null)
    {
      ad.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
      AppMethodBeat.o(150085);
      return;
    }
    b localb2 = g(parama2);
    b localb1 = localb2;
    if (localb2 == null)
    {
      ad.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
      localb1 = e(parama2);
      this.fYq.put(parama2, localb1);
    }
    localb1.fYw.put(parama1.name(), locala.dgo);
    a(localb1);
    AppMethodBeat.o(150085);
  }
  
  public final a f(ae.a parama)
  {
    AppMethodBeat.i(150078);
    a locala2 = (a)this.fYo.get(parama);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = c(parama);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.fYo.put(parama, locala2);
        locala1 = locala2;
      }
    }
    AppMethodBeat.o(150078);
    return locala1;
  }
  
  public final void g(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(150081);
    ad.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a locala = cL(paramInt1, paramInt2);
    locala.value = paramString;
    locala.type = paramInt2;
    locala.dgo = adp();
    a(locala);
    AppMethodBeat.o(150081);
  }
  
  final b lW(int paramInt)
  {
    AppMethodBeat.i(150071);
    b localb = new b();
    localb.fYu = paramInt;
    AppMethodBeat.o(150071);
    return localb;
  }
  
  public final a lX(int paramInt)
  {
    AppMethodBeat.i(150077);
    a locala2 = (a)this.fYn.get(paramInt);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = lU(paramInt);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.fYn.put(paramInt, locala2);
        locala1 = locala2;
      }
    }
    AppMethodBeat.o(150077);
    return locala1;
  }
  
  final b lY(int paramInt)
  {
    AppMethodBeat.i(150079);
    b localb2 = (b)this.fYp.get(paramInt);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = lV(paramInt);
      if (localb1 == null)
      {
        ad.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        AppMethodBeat.o(150079);
        return null;
      }
      this.fYp.put(paramInt, localb1);
    }
    AppMethodBeat.o(150079);
    return localb1;
  }
  
  public final class a
  {
    String dgo;
    int fYj;
    ae.a fYk;
    int type;
    public String value;
    
    public a() {}
  }
  
  public final class b
  {
    ae.a fYm;
    int fYu;
    SparseArray<String> fYv;
    HashMap<String, String> fYw;
    
    public b()
    {
      AppMethodBeat.i(150059);
      this.fYv = new SparseArray();
      this.fYw = new HashMap();
      AppMethodBeat.o(150059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.z.b
 * JD-Core Version:    0.7.0.1
 */