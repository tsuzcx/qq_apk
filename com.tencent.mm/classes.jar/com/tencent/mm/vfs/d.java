package com.tencent.mm.vfs;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements n.a
{
  private static final int Rbr;
  private static Map<String, a> Rbs;
  private static Map<String, a> Rbt;
  private static boolean Rbu;
  private static Set<String> Rbv;
  private static Set<String> Rbw;
  private static final g.d Rbx;
  private static final Pattern Rbz;
  private static final Object sLock;
  private final int FV;
  private final long Rby;
  private final String mPath;
  private final int mType;
  private final long nfE;
  
  static
  {
    AppMethodBeat.i(197215);
    long l = System.nanoTime();
    Random localRandom = new Random();
    localRandom.setSeed(l);
    Rbr = localRandom.nextInt();
    sLock = new Object();
    Rbs = new HashMap();
    Rbu = false;
    Rbv = new HashSet();
    Rbw = new HashSet();
    Rbx = new g.d()
    {
      public final void bh(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(197206);
        if ((!paramAnonymousBoolean1) && (!paramAnonymousBoolean2))
        {
          long l;
          try
          {
            l = System.currentTimeMillis();
            ??? = new NativeFileSystem("${data}/MicroMsg/${account}").cj(g.hRR().hRV()).dx("", false);
            if (??? != null) {
              break label429;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              label51:
              Object localObject6;
              Iterator localIterator2;
              Log.printErrStackTrace("VFS.DiskFileStatistics", localException, "Failed to calculate databases.", new Object[0]);
              continue;
              ??? = d.apb();
              continue;
              int i = 0;
            }
            Log.i("VFS.DiskFileStatistics", "End statistics maintenance, statistics count: " + d.apb().size());
            d.ck(null);
            d.gcD();
            d.VV();
            AppMethodBeat.o(197206);
            return;
          }
          i = d.Rbr;
          com.tencent.mm.kernel.g.aAf();
          if (((i ^ a.getUin() ^ BuildInfo.CLIENT_VERSION_INT) % 1024 == 0) || (WeChatEnvironment.hasDebugger()))
          {
            i = 1;
            synchronized (d.sLock)
            {
              d.cl(d.apb());
              Iterator localIterator1 = d.apc().values().iterator();
              if (!localIterator1.hasNext()) {
                break label646;
              }
              localObject6 = (d.a)localIterator1.next();
              if (i != 0) {
                com.tencent.mm.plugin.report.e.Cxv.a(21388, new Object[] { ((d.a)localObject6).name, Integer.valueOf(((d.a)localObject6).type), Integer.valueOf(((d.a)localObject6).flags), ((d.a)localObject6).path, Long.valueOf(((d.a)localObject6).oJj), Integer.valueOf(((d.a)localObject6).fileCount), Integer.valueOf(((d.a)localObject6).RbA), Integer.valueOf(((d.a)localObject6).RbB), Long.valueOf(((d.a)localObject6).RbC), Long.valueOf(0L), Long.valueOf(((d.a)localObject6).RbD), Long.valueOf(((d.a)localObject6).RbE), Long.valueOf(((d.a)localObject6).jmW) });
              }
              Log.i("VFS.DiskFileStatistics", "KV > name: %s, type: %d, flags: %d, path: %s, totalSize: %d, fileCount: %d, dirCount: %d, maxDepth: %d, maxFileSize: %d, filesAge: %d", new Object[] { ((d.a)localObject6).name, Integer.valueOf(((d.a)localObject6).type), Integer.valueOf(((d.a)localObject6).flags), ((d.a)localObject6).path, Long.valueOf(((d.a)localObject6).oJj), Integer.valueOf(((d.a)localObject6).fileCount), Integer.valueOf(((d.a)localObject6).RbA), Integer.valueOf(((d.a)localObject6).RbB), Long.valueOf(((d.a)localObject6).RbC), Long.valueOf(((d.a)localObject6).RbD) });
            }
            label429:
            localIterator2 = ((Iterable)???).iterator();
            for (;;)
            {
              if (!localIterator2.hasNext()) {
                break label51;
              }
              ??? = (e)localIterator2.next();
              if ((((e)???).RbJ) || (!((e)???).name.endsWith(".db"))) {
                break;
              }
              localObject6 = "${data}/MicroMsg/${account}/" + ((e)???).name;
              d.a locala = new d.a("@DiskSpace-DB", 12, 0, (String)localObject6, ((e)???).RbH, 1, 0, 1, ((e)???).size, ((e)???).RbI - l, 0L, 0L);
              synchronized (d.sLock)
              {
                if (d.apb() == null)
                {
                  ??? = d.apc();
                  ((Map)???).put((String)localObject6 + '|' + "@DiskSpace-DB", locala);
                }
              }
            }
          }
        }
        label646:
        synchronized (d.sLock)
        {
          Log.i("VFS.DiskFileStatistics", "Interrupted statistics maintenance, statistics count: " + d.apb().size());
          d.apc().putAll(d.apb());
          d.ck(null);
          AppMethodBeat.o(197206);
          return;
        }
      }
      
      public final void hdV()
      {
        AppMethodBeat.i(197205);
        synchronized (d.sLock)
        {
          d.ck(new HashMap());
          Log.i("VFS.DiskFileStatistics", "Begin statistics maintenance");
          AppMethodBeat.o(197205);
          return;
        }
      }
    };
    Rbz = Pattern.compile("[0-9a-f]{32}(?:temp[0-9]+)?");
    AppMethodBeat.o(197215);
  }
  
  public d(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.mPath = paramString;
    this.mType = paramInt1;
    this.FV = paramInt2;
    this.Rby = paramLong1;
    this.nfE = paramLong2;
  }
  
  private static void a(g.a parama, String paramString, String[] paramArrayOfString, Set<String> paramSet, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(197210);
    Map localMap = g.hRR().hRV();
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      String str;
      Object localObject;
      if (i < j)
      {
        str = paramArrayOfString[i];
        localObject = new ArrayList();
      }
      try
      {
        NativeFileSystem localNativeFileSystem = new NativeFileSystem(str);
        Iterator localIterator = localNativeFileSystem.cj(localMap).dx("", false).iterator();
        while (localIterator.hasNext())
        {
          e locale = (e)localIterator.next();
          if ((locale.RbJ) && (!paramSet.contains(locale.name)) && (Rbz.matcher(locale.name).matches() == paramBoolean)) {
            ((ArrayList)localObject).add(locale.name);
          }
        }
        localObject = new StatisticsFileSystem(localNativeFileSystem, (Collection)localObject);
        ((StatisticsFileSystem)localObject).a(paramString + str, new d(str, paramInt, 0, 0L, 0L));
        parama.b(paramString + str, (FileSystem)localObject);
      }
      catch (Exception localException)
      {
        i += 1;
      }
      AppMethodBeat.o(197210);
      return;
    }
  }
  
  public static void b(g.a parama)
  {
    AppMethodBeat.i(197212);
    synchronized (sLock)
    {
      Set localSet1 = Rbv;
      Set localSet2 = Rbw;
      Rbv = Collections.emptySet();
      Rbw = Collections.emptySet();
      a(parama, "@DiskSpace-NonAccountSdcard-", new String[] { "${sdFrom}/MicroMsg", "${sdTo}/MicroMsg", "${sdToCache}" }, localSet1, false, 10);
      a(parama, "@DiskSpace-AccountSdcard-", new String[] { "${sdFrom}/MicroMsg/${account}", "${sdTo}/MicroMsg/${account}", "${sdToCache}/${account}", "${sdFrom}/MicroMsg/${accountSalt}", "${sdTo}/MicroMsg/${accountSalt}", "${sdToCache}/${accountSalt}" }, localSet2, false, 11);
      ??? = new HashSet(Arrays.asList(new String[] { ".vfs", "MicroMsg", "cache" }));
      a(parama, "@DiskSpace-NonAccountData-", new String[] { "${data}", "${dataCache}" }, (Set)???, false, 7);
      ??? = new StatisticsFileSystem(new NativeFileSystem("${data}/MicroMsg/${account}"));
      ((StatisticsFileSystem)???).a("@DiskSpace-AccountData", new d("${data}/MicroMsg/${account}", 8, 0, 0L, 0L));
      parama.b("@DiskSpace-AccountData", (FileSystem)???);
      AppMethodBeat.o(197212);
      return;
    }
  }
  
  public static void c(g.a parama)
  {
    AppMethodBeat.i(197213);
    Object localObject = g.hRR().hRV();
    localObject = new HashSet(Arrays.asList(new String[] { (String)((Map)localObject).get("account"), (String)((Map)localObject).get("accountSalt") }));
    a(parama, "@DiskSpace-OtherAccountSdcard-", new String[] { "${sdFrom}/MicroMsg", "${sdTo}/MicroMsg", "${sdToCache}" }, (Set)localObject, true, 5);
    a(parama, "@DiskSpace-OtherAccountData-", new String[] { "${data}/MicroMsg" }, (Set)localObject, true, 9);
    AppMethodBeat.o(197213);
  }
  
  public static void hdU()
  {
    AppMethodBeat.i(197209);
    long l6 = 0L;
    long l7 = 0L;
    long l2 = 0L;
    long l4 = 0L;
    for (;;)
    {
      long l8;
      long l3;
      long l5;
      long l1;
      long l10;
      long l9;
      double d1;
      double d2;
      double d3;
      int i;
      synchronized (sLock)
      {
        if (!Rbu)
        {
          AppMethodBeat.o(197209);
          return;
        }
        Iterator localIterator = Rbs.values().iterator();
        l8 = 0L;
        l3 = 0L;
        l5 = 0L;
        l1 = 0L;
        a locala;
        if (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          l10 = locala.oJj;
          l9 = l8 + l10;
        }
        switch (locala.type)
        {
        case 2: 
          if ((locala.path.startsWith("${sdToCache}")) || (locala.path.startsWith("${dataCache}"))) {
            break label969;
          }
          if (!locala.path.startsWith("${sdFrom}")) {
            break label940;
          }
          l4 += l10;
          break label1087;
          d1 = l2 / l8;
          d2 = l6 / l8;
          d3 = l3 / l8;
          ??? = new ArrayList();
          ((ArrayList)???).add(new IDKey(1556, 0, 1));
          ((ArrayList)???).add(new IDKey(1556L, 1L, l6 / 1048576L));
          ((ArrayList)???).add(new IDKey(1556L, 2L, l7 / 1048576L));
          ((ArrayList)???).add(new IDKey(1556L, 3L, l1 / 1048576L));
          ((ArrayList)???).add(new IDKey(1556L, 4L, l2 / 1048576L));
          ((ArrayList)???).add(new IDKey(1556L, 5L, l5 / 1048576L));
          ((ArrayList)???).add(new IDKey(1556L, 6L, l4 / 1048576L));
          ((ArrayList)???).add(new IDKey(1556L, 7L, l3 / 1048576L));
          ((ArrayList)???).add(new IDKey(1556L, 9L, l8 / 1048576L));
          if (l2 < 536870912L)
          {
            i = 41;
            ((ArrayList)???).add(new IDKey(1556, i, 1));
            if (d1 >= 0.2D) {
              break label827;
            }
            i = 51;
            ((ArrayList)???).add(new IDKey(1556, i, 1));
            if (d2 >= 0.2D) {
              break label864;
            }
            i = 61;
            ((ArrayList)???).add(new IDKey(1556, i, 1));
            if (d3 >= 0.2D) {
              break label901;
            }
            i = 71;
            ((ArrayList)???).add(new IDKey(1556, i, 1));
            com.tencent.mm.plugin.report.e.Cxv.b((ArrayList)???, true);
            Log.i("VFS.DiskFileStatistics", "IDKEY > persist: %dM, expire: %dM, lru: %dM, nonVfs: %dM, cache: %dM, tencent: %dM, other: %dM, all: %dM, nonVfsRatio: %.2f%%, persistRatio: %.2f%%, otherRatio: %.2f%%", new Object[] { Long.valueOf(l6 / 1048576L), Long.valueOf(l7 / 1048576L), Long.valueOf(l1 / 1048576L), Long.valueOf(l2 / 1048576L), Long.valueOf(l5 / 1048576L), Long.valueOf(l4 / 1048576L), Long.valueOf(l3 / 1048576L), Long.valueOf(l8 / 1048576L), Double.valueOf(100.0D * d1), Double.valueOf(100.0D * d2), Double.valueOf(100.0D * d3) });
            AppMethodBeat.o(197209);
            return;
          }
          break;
        }
      }
      if (l2 < 1073741824L) {
        i = 42;
      } else if (l2 < 2147483648L) {
        i = 43;
      } else {
        label901:
        label940:
        if (l2 < 4294967296L)
        {
          i = 44;
        }
        else
        {
          i = 45;
          continue;
          label827:
          label1087:
          if (d1 < 0.5D) {
            i = 52;
          } else {
            label969:
            if (d1 < 0.8D)
            {
              i = 53;
            }
            else
            {
              i = 54;
              continue;
              label864:
              if (d2 < 0.5D)
              {
                i = 62;
              }
              else if (d2 < 0.8D)
              {
                i = 63;
              }
              else
              {
                i = 64;
                continue;
                if (d3 < 0.5D)
                {
                  i = 72;
                }
                else if (d3 < 0.8D)
                {
                  i = 73;
                }
                else
                {
                  i = 74;
                  continue;
                  break label1087;
                  l8 = l2 + l10;
                  l2 = l3;
                  l3 = l1;
                  l1 = l2;
                  l2 = l8;
                  continue;
                  l10 = l5 + l10;
                  l5 = l3;
                  l3 = l1;
                  l1 = l5;
                  l8 = l9;
                  l5 = l10;
                  continue;
                  l8 = l6 + l10;
                  l6 = l1;
                  l1 = l3;
                  l3 = l6;
                  l6 = l8;
                  continue;
                  l8 = l7 + l10;
                  l7 = l1;
                  l1 = l3;
                  l3 = l7;
                  l7 = l8;
                  continue;
                  l8 = l1 + l10;
                  l1 = l3;
                  l3 = l8;
                  continue;
                  l8 = l3 + l10;
                  l3 = l1;
                  l1 = l8;
                  continue;
                  l8 = l3;
                  l3 = l1;
                  l1 = l8;
                  l8 = l9;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void hp(String paramString, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(197211);
    int i;
    if ((paramInt & 0x4) == 0)
    {
      i = 1;
      if ((paramInt & 0x3) == 0) {
        break label40;
      }
    }
    label40:
    for (paramInt = j;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label45;
      }
      AppMethodBeat.o(197211);
      return;
      i = 0;
      break;
    }
    label45:
    localObject = sLock;
    if (i != 0) {}
    for (;;)
    {
      try
      {
        Rbw.add(paramString);
        return;
      }
      finally
      {
        AppMethodBeat.o(197211);
      }
      Rbv.add(paramString);
    }
  }
  
  static void init()
  {
    AppMethodBeat.i(197208);
    try
    {
      Object localObject1 = new JSONObject(s.boY(aa.z(new o(MMApplicationContext.getContext().getFilesDir(), "vfs-statistics").mUri)));
      if (((JSONObject)localObject1).optInt("version") != 1) {
        Log.e("VFS.DiskFileStatistics", "Mismatched file version: " + ((JSONObject)localObject1).optInt("version"));
      }
      for (;;)
      {
        h.Rco.a(Rbx);
        AppMethodBeat.o(197208);
        return;
        ??? = ((JSONObject)localObject1).getJSONArray("content");
        int j = ((JSONArray)???).length();
        localObject1 = new HashMap();
        int i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = ((JSONArray)???).getJSONObject(i);
          String str1 = localJSONObject.getString("name");
          String str2 = localJSONObject.getString("path");
          ((Map)localObject1).put(str2 + '|' + str1, new a(str1, localJSONObject.getInt("type"), localJSONObject.getInt("flags"), str2, localJSONObject.getLong("totalSize"), localJSONObject.getInt("fileCount"), localJSONObject.getInt("dirCount"), localJSONObject.getInt("maxDepth"), localJSONObject.getLong("maxFileSize"), localJSONObject.getLong("filesAge"), localJSONObject.optLong("targetSize"), localJSONObject.optLong("expireTime")));
          i += 1;
        }
        Log.i("VFS.DiskFileStatistics", "Loaded statistics, count: " + ((Map)localObject1).size());
        synchronized (sLock)
        {
          Rbs = (Map)localObject1;
          Rbu = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("VFS.DiskFileStatistics", localIOException, "Unable to load statistics", new Object[0]);
      }
    }
    catch (JSONException localJSONException)
    {
      label321:
      break label321;
    }
  }
  
  public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(197207);
    paramFileSystem = (String)paramMap.get("relPath");
    if (!paramFileSystem.isEmpty()) {
      paramFileSystem = this.mPath + '/' + paramFileSystem;
    }
    for (;;)
    {
      a locala = new a(paramString, this.mType, this.FV, paramFileSystem, ((Long)paramMap.get("totalSize")).longValue(), ((Integer)paramMap.get("fileCount")).intValue(), ((Integer)paramMap.get("dirCount")).intValue(), ((Integer)paramMap.get("maxDepth")).intValue(), ((Long)paramMap.get("maxFileSize")).longValue(), ((Long)paramMap.get("averageAge")).longValue(), this.Rby, this.nfE);
      synchronized (sLock)
      {
        if (Rbt == null)
        {
          paramMap = Rbs;
          paramMap.put(paramFileSystem + '|' + paramString, locala);
          AppMethodBeat.o(197207);
          return;
          paramFileSystem = this.mPath;
          continue;
        }
        paramMap = Rbt;
      }
    }
  }
  
  static final class a
  {
    final int RbA;
    final int RbB;
    final long RbC;
    final long RbD;
    final long RbE;
    final int fileCount;
    final int flags;
    final long jmW;
    final String name;
    final long oJj;
    final String path;
    final int type;
    
    a(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      this.name = paramString1;
      this.type = paramInt1;
      this.flags = paramInt2;
      this.path = paramString2;
      this.oJj = paramLong1;
      this.fileCount = paramInt3;
      this.RbA = paramInt4;
      this.RbB = paramInt5;
      this.RbC = paramLong2;
      this.RbD = paramLong3;
      this.RbE = paramLong4;
      this.jmW = paramLong5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.d
 * JD-Core Version:    0.7.0.1
 */