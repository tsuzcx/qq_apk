package com.tencent.mm.x;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class b
{
  SparseArray<b.a> eDj;
  HashMap<ac.a, b.a> eDk;
  SparseArray<b.b> eDl;
  HashMap<ac.a, b.b> eDm;
  private Random eDn;
  z eDo;
  
  public b()
  {
    AppMethodBeat.i(77724);
    this.eDj = new SparseArray();
    this.eDk = new HashMap();
    this.eDl = new SparseArray();
    this.eDm = new HashMap();
    this.eDn = new Random();
    this.eDo = null;
    AppMethodBeat.o(77724);
  }
  
  private b.a a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(77737);
    b.a locala = new b.a(this);
    locala.eDf = paramInt1;
    locala.type = paramInt2;
    locala.value = paramString1;
    locala.crs = paramString2;
    AppMethodBeat.o(77737);
    return locala;
  }
  
  private b.a a(ac.a parama, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(77738);
    b.a locala = new b.a(this);
    locala.eDg = parama;
    locala.type = paramInt;
    locala.value = paramString1;
    locala.crs = paramString2;
    AppMethodBeat.o(77738);
    return locala;
  }
  
  private void a(b.a parama)
  {
    AppMethodBeat.i(77727);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(parama.type);
    localStringBuffer.append("|");
    localStringBuffer.append(escape(parama.value));
    localStringBuffer.append("|");
    localStringBuffer.append(escape(parama.crs));
    if (parama.eDg != null)
    {
      this.eDo.set(parama.eDg, localStringBuffer.toString());
      AppMethodBeat.o(77727);
      return;
    }
    this.eDo.set(parama.eDf, localStringBuffer.toString());
    AppMethodBeat.o(77727);
  }
  
  private b.a c(ac.a parama)
  {
    AppMethodBeat.i(77730);
    String str = (String)this.eDo.get(parama, null);
    if (str == null)
    {
      AppMethodBeat.o(77730);
      return null;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length != 3)
    {
      ab.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
      AppMethodBeat.o(77730);
      return null;
    }
    try
    {
      parama = a(parama, Integer.valueOf(arrayOfString[0]).intValue(), unescape(arrayOfString[1]), unescape(arrayOfString[2]));
      AppMethodBeat.o(77730);
      return parama;
    }
    catch (Exception parama)
    {
      ab.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bo.l(parama) });
      ab.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
      AppMethodBeat.o(77730);
    }
    return null;
  }
  
  private b.a c(ac.a parama, int paramInt)
  {
    AppMethodBeat.i(77740);
    b.a locala2 = f(parama);
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a(parama, paramInt, "", "");
      this.eDk.put(parama, locala1);
      a(locala1);
    }
    AppMethodBeat.o(77740);
    return locala1;
  }
  
  private b.a cf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77739);
    b.a locala2 = ju(paramInt1);
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a(paramInt1, paramInt2, "", "");
      this.eDj.put(paramInt1, locala1);
      a(locala1);
    }
    AppMethodBeat.o(77739);
    return locala1;
  }
  
  private b.b d(ac.a parama)
  {
    AppMethodBeat.i(77733);
    String str = (String)this.eDo.get(parama, null);
    if (str == null)
    {
      parama = e(parama);
      AppMethodBeat.o(77733);
      return parama;
    }
    String[] arrayOfString = str.split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      ab.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { str });
      AppMethodBeat.o(77733);
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
          if (lV(arrayOfString[i])) {
            parama.eDr.put(Integer.valueOf(arrayOfString[i]).intValue(), unescape(arrayOfString[(i + 1)]));
          } else {
            parama.eDs.put(arrayOfString[i], unescape(arrayOfString[(i + 1)]));
          }
        }
      }
      catch (Exception parama)
      {
        ab.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bo.l(parama) });
        ab.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { str });
        AppMethodBeat.o(77733);
        return null;
      }
      AppMethodBeat.o(77733);
      return parama;
      i += 2;
    }
  }
  
  private static String escape(String paramString)
  {
    AppMethodBeat.i(77725);
    paramString = paramString.replaceAll("\\|", "%7C");
    AppMethodBeat.o(77725);
    return paramString;
  }
  
  private b.a jr(int paramInt)
  {
    AppMethodBeat.i(77729);
    String str = (String)this.eDo.get(paramInt, null);
    if (str == null)
    {
      AppMethodBeat.o(77729);
      return null;
    }
    Object localObject = str.split("\\|");
    if (localObject.length != 3)
    {
      ab.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[] { str });
      AppMethodBeat.o(77729);
      return null;
    }
    try
    {
      localObject = a(paramInt, Integer.valueOf(localObject[0]).intValue(), unescape(localObject[1]), unescape(localObject[2]));
      AppMethodBeat.o(77729);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bo.l(localException) });
      ab.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[] { str });
      AppMethodBeat.o(77729);
    }
    return null;
  }
  
  private b.b js(int paramInt)
  {
    AppMethodBeat.i(77732);
    Object localObject = (String)this.eDo.get(paramInt, null);
    if (localObject == null)
    {
      localObject = jt(paramInt);
      AppMethodBeat.o(77732);
      return localObject;
    }
    String[] arrayOfString = ((String)localObject).split("\\|");
    if (arrayOfString.length % 2 != 0)
    {
      ab.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[] { localObject });
      AppMethodBeat.o(77732);
      return null;
    }
    for (;;)
    {
      b.b localb;
      try
      {
        localb = jt(paramInt);
        paramInt = 0;
        if (paramInt < arrayOfString.length) {
          if (lV(arrayOfString[paramInt])) {
            localb.eDr.put(Integer.valueOf(arrayOfString[paramInt]).intValue(), unescape(arrayOfString[(paramInt + 1)]));
          } else {
            localb.eDs.put(arrayOfString[paramInt], unescape(arrayOfString[(paramInt + 1)]));
          }
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[] { bo.l(localException) });
        ab.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[] { localObject });
        AppMethodBeat.o(77732);
        return null;
      }
      AppMethodBeat.o(77732);
      return localb;
      paramInt += 2;
    }
  }
  
  private static boolean lV(String paramString)
  {
    AppMethodBeat.i(77731);
    if ((!bo.isNullOrNil(paramString)) && (paramString.matches("^[\\d]+$")))
    {
      AppMethodBeat.o(77731);
      return true;
    }
    AppMethodBeat.o(77731);
    return false;
  }
  
  private static String unescape(String paramString)
  {
    AppMethodBeat.i(77726);
    paramString = paramString.replaceAll("%7C", "|");
    AppMethodBeat.o(77726);
    return paramString;
  }
  
  public final b.a F(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(77747);
    ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    b.a locala = ju(paramInt1);
    if (locala == null)
    {
      ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      AppMethodBeat.o(77747);
      return null;
    }
    if ((locala.type & paramInt3) == 0)
    {
      ab.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      AppMethodBeat.o(77747);
      return null;
    }
    b.b localb = jv(paramInt2);
    if (localb != null)
    {
      String str = (String)localb.eDr.get(paramInt1);
      if ((str != null) && (str.equals(locala.crs)))
      {
        AppMethodBeat.o(77747);
        return null;
      }
      if (str == null)
      {
        str = PH();
        localb.eDr.put(paramInt1, str);
        a(localb);
      }
      AppMethodBeat.o(77747);
      return locala;
    }
    ab.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    AppMethodBeat.o(77747);
    return null;
  }
  
  final String PH()
  {
    AppMethodBeat.i(77734);
    String str = String.format("%d%04d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.eDn.nextInt(Math.abs(this.eDn.nextInt(2147483647))) % 10000) });
    AppMethodBeat.o(77734);
    return str;
  }
  
  public final b.a a(ac.a parama1, ac.a parama2, int paramInt)
  {
    AppMethodBeat.i(77748);
    ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", new Object[] { parama1, parama2, Integer.valueOf(paramInt) });
    b.a locala = f(parama1);
    if (locala == null)
    {
      ab.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
      AppMethodBeat.o(77748);
      return null;
    }
    if ((locala.type & paramInt) == 0)
    {
      ab.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
      AppMethodBeat.o(77748);
      return null;
    }
    parama2 = g(parama2);
    if (parama2 != null)
    {
      String str = (String)parama2.eDs.get(parama1.name());
      if ((str != null) && (str.equals(locala.crs)))
      {
        AppMethodBeat.o(77748);
        return null;
      }
      if (str == null)
      {
        str = PH();
        parama2.eDs.put(parama1.name(), str);
        a(parama2);
      }
      AppMethodBeat.o(77748);
      return locala;
    }
    ab.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
    AppMethodBeat.o(77748);
    return null;
  }
  
  final void a(b.b paramb)
  {
    int m = 0;
    AppMethodBeat.i(77728);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = paramb.eDs.entrySet().iterator();
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
      localStringBuffer.append(escape((String)localObject2));
      i += 1;
    }
    while (k < paramb.eDr.size())
    {
      i = paramb.eDr.keyAt(k);
      localObject1 = (String)paramb.eDr.get(i);
      if (j != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(i);
      localStringBuffer.append("|");
      localStringBuffer.append(escape((String)localObject1));
      j += 1;
      k += 1;
    }
    if (paramb.eDi != null)
    {
      this.eDo.set(paramb.eDi, localStringBuffer.toString());
      AppMethodBeat.o(77728);
      return;
    }
    this.eDo.set(paramb.eDq, localStringBuffer.toString());
    AppMethodBeat.o(77728);
  }
  
  public final void b(ac.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(77746);
    ab.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", new Object[] { parama, Integer.valueOf(paramInt), paramString });
    parama = c(parama, paramInt);
    parama.value = paramString;
    parama.type = paramInt;
    parama.crs = PH();
    a(parama);
    AppMethodBeat.o(77746);
  }
  
  final b.b e(ac.a parama)
  {
    AppMethodBeat.i(77736);
    b.b localb = new b.b(this);
    localb.eDi = parama;
    AppMethodBeat.o(77736);
    return localb;
  }
  
  public final b.a f(ac.a parama)
  {
    AppMethodBeat.i(77742);
    b.a locala2 = (b.a)this.eDk.get(parama);
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = c(parama);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.eDk.put(parama, locala2);
        locala1 = locala2;
      }
    }
    AppMethodBeat.o(77742);
    return locala1;
  }
  
  final b.b g(ac.a parama)
  {
    AppMethodBeat.i(77744);
    b.b localb2 = (b.b)this.eDm.get(parama);
    b.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = d(parama);
      if (localb1 == null)
      {
        ab.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        AppMethodBeat.o(77744);
        return null;
      }
      this.eDm.put(parama, localb1);
    }
    AppMethodBeat.o(77744);
    return localb1;
  }
  
  public final void h(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(77745);
    ab.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    b.a locala = cf(paramInt1, paramInt2);
    locala.value = paramString;
    locala.type = paramInt2;
    locala.crs = PH();
    a(locala);
    AppMethodBeat.o(77745);
  }
  
  final b.b jt(int paramInt)
  {
    AppMethodBeat.i(77735);
    b.b localb = new b.b(this);
    localb.eDq = paramInt;
    AppMethodBeat.o(77735);
    return localb;
  }
  
  public final b.a ju(int paramInt)
  {
    AppMethodBeat.i(77741);
    b.a locala2 = (b.a)this.eDj.get(paramInt);
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = jr(paramInt);
      locala1 = locala2;
      if (locala2 != null)
      {
        this.eDj.put(paramInt, locala2);
        locala1 = locala2;
      }
    }
    AppMethodBeat.o(77741);
    return locala1;
  }
  
  final b.b jv(int paramInt)
  {
    AppMethodBeat.i(77743);
    b.b localb2 = (b.b)this.eDl.get(paramInt);
    b.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = js(paramInt);
      if (localb1 == null)
      {
        ab.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
        AppMethodBeat.o(77743);
        return null;
      }
      this.eDl.put(paramInt, localb1);
    }
    AppMethodBeat.o(77743);
    return localb1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.x.b
 * JD-Core Version:    0.7.0.1
 */