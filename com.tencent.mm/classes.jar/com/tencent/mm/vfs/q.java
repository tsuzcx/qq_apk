package com.tencent.mm.vfs;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

final class q
  implements o
{
  private static final r<FileSystem, FileSystem.b> agzs;
  final p agxI;
  private final List<q.a> agzt;
  final r<FileSystem, FileSystem.b> agzu;
  private Map<String, SchemeResolver> agzv;
  private Map<String, FileSystem> agzw;
  private Map<String, FileSystem> agzx;
  private Map<String, Object> agzy;
  private List<o.a> agzz;
  
  static
  {
    AppMethodBeat.i(13227);
    agzs = new r(new NativeFileSystem(""));
    AppMethodBeat.o(13227);
  }
  
  q()
  {
    AppMethodBeat.i(13218);
    this.agzv = null;
    this.agzw = null;
    this.agzx = null;
    this.agzy = null;
    this.agzz = null;
    this.agxI = new p();
    this.agzt = Collections.emptyList();
    this.agzu = agzs;
    AppMethodBeat.o(13218);
  }
  
  q(p paramp)
  {
    AppMethodBeat.i(238279);
    this.agzv = null;
    this.agzw = null;
    this.agzx = null;
    this.agzy = null;
    this.agzz = null;
    this.agxI = paramp;
    this.agzt = a(paramp);
    if (paramp.agzq == null) {}
    for (paramp = agzs;; paramp = paramp.agzq)
    {
      this.agzu = paramp;
      AppMethodBeat.o(238279);
      return;
    }
  }
  
  private static List<q.a> a(p paramp)
  {
    AppMethodBeat.i(238290);
    Object localObject2 = paramp.agzo;
    Map localMap = paramp.agzm;
    paramp = paramp.agzp;
    Object localObject1 = new ArrayList(((SortedMap)localObject2).size());
    localObject2 = ((SortedMap)localObject2).entrySet().iterator();
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
      Object localObject3 = (h)((Map.Entry)localObject4).getKey();
      localObject4 = (String)((Map.Entry)localObject4).getValue();
      r localr = (r)localMap.get(localObject4);
      if (localr == null)
      {
        paramp = new IllegalArgumentException("FileSystem '" + (String)localObject4 + "' for mount point '" + localObject3 + "' not exist.");
        AppMethodBeat.o(238290);
        throw paramp;
      }
      localObject3 = ((h)localObject3).cS(paramp);
      if ((localObject3 != null) && (localObject3.length != 0))
      {
        j = localObject3.length;
        i = 0;
        while (i < j)
        {
          ((ArrayList)localObject1).add(new q.a(localObject3[i], (String)localObject4, -1, (FileSystem.b)localr.agzD));
          i += 1;
        }
      }
    }
    paramp = (q.a[])((ArrayList)localObject1).toArray(new q.a[0]);
    Arrays.sort(paramp, new q.1());
    int j = 1;
    if (j < paramp.length)
    {
      localMap = paramp[j];
      localObject1 = localMap.basePath;
      i = j - 1;
      localObject2 = paramp[i];
      if (localMap.basePath.equals(((q.a)localObject2).basePath)) {
        Log.w("VFS.ResolverState", "Oops, duplicated mount point detected: " + localMap.toString() + " <=> " + ((q.a)localObject2).toString());
      }
      int k;
      for (i = ((q.a)localObject2).agzA;; i = k)
      {
        if (i >= 0) {
          paramp[j] = new q.a(localMap.basePath, localMap.agzk, i, localMap.agzB);
        }
        j += 1;
        break;
        do
        {
          localObject2 = paramp[i];
          if ((((String)localObject1).startsWith(((q.a)localObject2).basePath)) && (((String)localObject1).charAt(((q.a)localObject2).basePath.length()) == '/')) {
            break;
          }
          k = ((q.a)localObject2).agzA;
          i = k;
        } while (k >= 0);
      }
    }
    paramp = Arrays.asList(paramp);
    AppMethodBeat.o(238290);
    return paramp;
  }
  
  public final FileSystem.b bEh(String paramString)
  {
    AppMethodBeat.i(238312);
    paramString = (r)this.agxI.agzm.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(238312);
      return null;
    }
    paramString = (FileSystem.b)paramString.cV(jKI());
    AppMethodBeat.o(238312);
    return paramString;
  }
  
  public final Pair<FileSystem.b, String> bEi(String paramString)
  {
    AppMethodBeat.i(238335);
    Object localObject2 = this.agzt;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(238335);
      return null;
    }
    String str = ah.v(paramString, true, false);
    int i = Collections.binarySearch((List)localObject2, str);
    if (i >= 0)
    {
      localObject2 = (q.a)((List)localObject2).get(i);
      paramString = "";
      if (localObject2 != null) {
        break label236;
      }
    }
    for (Object localObject1 = (FileSystem.b)this.agzu.cV(jKI());; localObject1 = ((q.a)localObject2).agzB)
    {
      paramString = new Pair(localObject1, paramString);
      AppMethodBeat.o(238335);
      return paramString;
      label184:
      for (i = -i - 2;; i = paramString.agzA)
      {
        if (i < 0) {
          localObject1 = null;
        }
        do
        {
          if (i < 0) {
            break label192;
          }
          paramString = str.substring(((q.a)localObject1).basePath.length() + 1);
          localObject2 = localObject1;
          break;
          paramString = (q.a)((List)localObject2).get(i);
          if (!str.startsWith(paramString.basePath)) {
            break label184;
          }
          localObject1 = paramString;
        } while (str.charAt(paramString.basePath.length()) == '/');
      }
      label192:
      localObject2 = localObject1;
      paramString = str;
      if (str.isEmpty()) {
        break;
      }
      localObject2 = localObject1;
      paramString = str;
      if (str.charAt(0) != '/') {
        break;
      }
      paramString = str.substring(1);
      localObject2 = localObject1;
      break;
      label236:
      if (((q.a)localObject2).agzB == null) {
        ((q.a)localObject2).agzB = bEh(((q.a)localObject2).agzk);
      }
    }
  }
  
  public final SchemeResolver.a bEj(String paramString)
  {
    AppMethodBeat.i(238320);
    paramString = (r)this.agxI.agzl.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(238320);
      return null;
    }
    paramString = (SchemeResolver.a)paramString.cV(jKI());
    AppMethodBeat.o(238320);
    return paramString;
  }
  
  public final Map<String, Object> jKI()
  {
    AppMethodBeat.i(13225);
    if (this.agzy == null) {
      this.agzy = Collections.unmodifiableMap(this.agxI.agzp);
    }
    Map localMap = this.agzy;
    AppMethodBeat.o(13225);
    return localMap;
  }
  
  public final List<o.a> jKJ()
  {
    AppMethodBeat.i(238325);
    if (this.agzz == null) {
      this.agzz = Collections.unmodifiableList(this.agzt);
    }
    List localList = this.agzz;
    AppMethodBeat.o(238325);
    return localList;
  }
  
  public final Map<String, FileSystem> jKz()
  {
    AppMethodBeat.i(238302);
    if (this.agzw == null)
    {
      localObject = new HashMap();
      Iterator localIterator = this.agxI.agzm.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((Map)localObject).put(localEntry.getKey(), ((r)localEntry.getValue()).agzC);
      }
      this.agzw = Collections.unmodifiableMap((Map)localObject);
    }
    Object localObject = this.agzw;
    AppMethodBeat.o(238302);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13226);
    String str = "schemes: " + this.agxI.agzl.size() + ", fileSystems: " + this.agxI.agzm.size() + ", mountPoints: " + this.agxI.agzo.size() + " (" + this.agzt + " active), envVars: " + this.agxI.agzp.size();
    AppMethodBeat.o(13226);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.q
 * JD-Core Version:    0.7.0.1
 */