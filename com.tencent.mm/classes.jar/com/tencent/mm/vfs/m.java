package com.tencent.mm.vfs;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Lcom.tencent.mm.vfs.g;>;
import java.util.Map<Ljava.lang.String;Lcom.tencent.mm.vfs.n;>;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.TreeMap;

final class m
  implements l
{
  private static final g YDR;
  final Map<String, n> YDS;
  final Map<String, g> YDT;
  final Map<String, g> YDU;
  final SortedMap<String, String> YDV;
  final List<a> YDW;
  final Map<String, String> YDX;
  final g YDY;
  private Map<String, SchemeResolver> YDZ;
  private Map<String, FileSystem> YEa;
  private Map<String, FileSystem> YEb;
  private Map<String, String> YEc;
  private List<l.a> YEd;
  
  static
  {
    AppMethodBeat.i(13227);
    YDR = new g(new NativeFileSystem(""));
    AppMethodBeat.o(13227);
  }
  
  m()
  {
    AppMethodBeat.i(13218);
    this.YDZ = null;
    this.YEa = null;
    this.YEb = null;
    this.YEc = null;
    this.YEd = null;
    this.YDS = Collections.emptyMap();
    this.YDT = Collections.emptyMap();
    this.YDU = Collections.emptyMap();
    this.YDV = new TreeMap();
    this.YDW = Collections.emptyList();
    this.YDX = Collections.emptyMap();
    this.YDY = YDR;
    AppMethodBeat.o(13218);
  }
  
  private m(Map<String, n> paramMap, Map<String, g> paramMap1, Map<String, g> paramMap2, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap3, g paramg)
  {
    AppMethodBeat.i(236773);
    this.YDZ = null;
    this.YEa = null;
    this.YEb = null;
    this.YEc = null;
    this.YEd = null;
    this.YDS = paramMap;
    this.YDT = paramMap1;
    this.YDU = paramMap2;
    this.YDV = paramSortedMap;
    this.YDW = a(paramMap1, paramSortedMap, paramMap3);
    this.YDX = paramMap3;
    if (paramg != null)
    {
      paramMap = paramg;
      if (paramg.YCm != null) {}
    }
    else
    {
      paramMap = YDR;
    }
    this.YDY = paramMap;
    AppMethodBeat.o(236773);
  }
  
  private static List<a> a(Map<String, g> paramMap, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap1)
  {
    AppMethodBeat.i(13224);
    ArrayList localArrayList = new ArrayList(paramSortedMap.size());
    paramSortedMap = paramSortedMap.entrySet().iterator();
    while (paramSortedMap.hasNext())
    {
      Object localObject = (Map.Entry)paramSortedMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      g localg = (g)paramMap.get(localObject);
      if (localg == null)
      {
        paramMap = new IllegalArgumentException("FileSystem '" + (String)localObject + "' for mount point '" + str + "' not exist.");
        AppMethodBeat.o(13224);
        throw paramMap;
      }
      str = ad.ad(str, paramMap1);
      if (str != null) {
        localArrayList.add(new a(str, (String)localObject, -1, localg.YCk));
      }
    }
    paramMap = (a[])localArrayList.toArray(new a[0]);
    Arrays.sort(paramMap, new Comparator() {});
    int j = 1;
    if (j < paramMap.length)
    {
      paramSortedMap = paramMap[j];
      paramMap1 = paramSortedMap.basePath;
      int i = j - 1;
      localArrayList = paramMap[i];
      if (paramSortedMap.basePath.equals(localArrayList.basePath)) {
        Log.w("VFS.ResolverState", "Oops, duplicated mount point detected: " + paramSortedMap.toString() + " <=> " + localArrayList.toString());
      }
      int k;
      for (i = localArrayList.YEe;; i = k)
      {
        if (i >= 0) {
          paramMap[j] = new a(paramSortedMap.basePath, paramSortedMap.YDQ, i, paramSortedMap.YEf);
        }
        j += 1;
        break;
        do
        {
          localArrayList = paramMap[i];
          if ((paramMap1.startsWith(localArrayList.basePath)) && (paramMap1.charAt(localArrayList.basePath.length()) == '/')) {
            break;
          }
          k = localArrayList.YEe;
          i = k;
        } while (k >= 0);
      }
    }
    paramMap = Arrays.asList(paramMap);
    AppMethodBeat.o(13224);
    return paramMap;
  }
  
  static m bv(Bundle paramBundle)
  {
    AppMethodBeat.i(13222);
    Object localObject1 = paramBundle.getParcelableArrayList("sl");
    Object localObject2 = paramBundle.getBundle("sm");
    HashMap localHashMap = new HashMap();
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject3 = ((Bundle)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        int i = ((Bundle)localObject2).getInt((String)localObject4);
        if ((i >= 0) && (i < ((ArrayList)localObject1).size())) {
          localHashMap.put(localObject4, new n((SchemeResolver)((ArrayList)localObject1).get(i)));
        }
      }
    }
    localObject2 = paramBundle.getBundle("fs");
    localObject1 = new HashMap();
    if (localObject2 != null)
    {
      ((Bundle)localObject2).setClassLoader(paramBundle.getClassLoader());
      localObject3 = ((Bundle)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        ((HashMap)localObject1).put(localObject4, new g((FileSystem)((Bundle)localObject2).getParcelable((String)localObject4)));
      }
    }
    Object localObject3 = paramBundle.getBundle("mfs");
    localObject2 = new HashMap();
    if (localObject3 != null)
    {
      ((Bundle)localObject3).setClassLoader(paramBundle.getClassLoader());
      localObject4 = ((Bundle)localObject3).keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        ((HashMap)localObject2).put(localObject5, new g((FileSystem)((Bundle)localObject3).getParcelable((String)localObject5)));
      }
    }
    Object localObject4 = paramBundle.getBundle("mp");
    localObject3 = new TreeMap();
    Object localObject6;
    if (localObject4 != null)
    {
      ((Bundle)localObject4).setClassLoader(paramBundle.getClassLoader());
      localObject5 = ((Bundle)localObject4).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (String)((Iterator)localObject5).next();
        ((TreeMap)localObject3).put(localObject6, ((Bundle)localObject4).getString((String)localObject6));
      }
    }
    Object localObject5 = paramBundle.getBundle("env");
    localObject4 = new HashMap();
    if (localObject5 != null)
    {
      localObject6 = ((Bundle)localObject5).keySet().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        String str = (String)((Iterator)localObject6).next();
        ((HashMap)localObject4).put(str, ((Bundle)localObject5).getString(str));
      }
    }
    paramBundle = (FileSystem)paramBundle.getParcelable("root");
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = new g(paramBundle))
    {
      paramBundle = new m(localHashMap, (Map)localObject1, (Map)localObject2, (SortedMap)localObject3, (Map)localObject4, paramBundle);
      AppMethodBeat.o(13222);
      return paramBundle;
    }
  }
  
  private static <K, V> void e(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    AppMethodBeat.i(13223);
    paramMap2 = paramMap2.entrySet().iterator();
    while (paramMap2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap2.next();
      if (localEntry.getValue() == null) {
        paramMap1.remove(localEntry.getKey());
      } else {
        paramMap1.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    AppMethodBeat.o(13223);
  }
  
  final m a(Map<String, n> paramMap, Map<String, g> paramMap1, Map<String, g> paramMap2, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap3, g paramg)
  {
    AppMethodBeat.i(236774);
    Object localObject1;
    label35:
    label49:
    label65:
    label76:
    Object localObject2;
    if (paramMap.isEmpty())
    {
      paramMap = this.YDS;
      if (!paramMap1.isEmpty()) {
        break label178;
      }
      localObject1 = this.YDT;
      if (!paramMap2.isEmpty()) {
        break label200;
      }
      paramMap2 = this.YDU;
      if (!paramSortedMap.isEmpty()) {
        break label225;
      }
      paramSortedMap = this.YDV;
      if (paramg != null) {
        break label252;
      }
      paramg = this.YDY;
      if (!paramMap3.isEmpty()) {
        break label255;
      }
      localObject2 = this.YDX;
    }
    for (;;)
    {
      paramMap = new m(paramMap, (Map)localObject1, paramMap2, paramSortedMap, (Map)localObject2, paramg);
      if (paramMap1.isEmpty()) {
        paramMap.YEa = this.YEa;
      }
      if (paramMap3.isEmpty()) {
        paramMap.YEc = this.YEc;
      }
      AppMethodBeat.o(236774);
      return paramMap;
      localObject1 = new HashMap(this.YDS);
      e((Map)localObject1, paramMap);
      paramMap = (Map<String, n>)localObject1;
      break;
      label178:
      localObject1 = new HashMap(this.YDT);
      e((Map)localObject1, paramMap1);
      break label35;
      label200:
      localObject2 = new HashMap(this.YDU);
      e((Map)localObject2, paramMap2);
      paramMap2 = (Map<String, g>)localObject2;
      break label49;
      label225:
      localObject2 = new TreeMap(this.YDV);
      e((Map)localObject2, paramSortedMap);
      paramSortedMap = (SortedMap<String, String>)localObject2;
      break label65;
      label252:
      break label76;
      label255:
      localObject2 = new HashMap(this.YDX);
      e((Map)localObject2, paramMap3);
      Iterator localIterator = paramMap.values().iterator();
      while (localIterator.hasNext()) {
        ((n)localIterator.next()).YEh = null;
      }
      localIterator = ((Map)localObject1).values().iterator();
      while (localIterator.hasNext()) {
        ((g)localIterator.next()).YCk = null;
      }
      localIterator = paramMap2.values().iterator();
      while (localIterator.hasNext()) {
        ((g)localIterator.next()).YCk = null;
      }
      paramg.YCk = null;
    }
  }
  
  public final FileSystem.b bBL(String paramString)
  {
    AppMethodBeat.i(236782);
    paramString = (g)this.YDT.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(236782);
      return null;
    }
    if (paramString.YCk == null) {
      paramString.YCk = paramString.YCm.cp(ift());
    }
    paramString = paramString.YCk;
    AppMethodBeat.o(236782);
    return paramString;
  }
  
  public final Pair<FileSystem.b, String> bBM(String paramString)
  {
    AppMethodBeat.i(236788);
    Object localObject2 = this.YDW;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(236788);
      return null;
    }
    String str = ad.r(paramString, true, false);
    int i = Collections.binarySearch((List)localObject2, str);
    if (i >= 0)
    {
      localObject2 = (a)((List)localObject2).get(i);
      paramString = "";
      if (localObject2 != null) {
        break label262;
      }
      if (this.YDY.YCk == null) {
        this.YDY.YCk = this.YDY.YCm.cp(ift());
      }
    }
    for (Object localObject1 = this.YDY.YCk;; localObject1 = ((a)localObject2).YEf)
    {
      paramString = new Pair(localObject1, paramString);
      AppMethodBeat.o(236788);
      return paramString;
      label210:
      for (i = -i - 2;; i = paramString.YEe)
      {
        if (i < 0) {
          localObject1 = null;
        }
        do
        {
          if (i < 0) {
            break label218;
          }
          paramString = str.substring(((a)localObject1).basePath.length() + 1);
          localObject2 = localObject1;
          break;
          paramString = (a)((List)localObject2).get(i);
          if (!str.startsWith(paramString.basePath)) {
            break label210;
          }
          localObject1 = paramString;
        } while (str.charAt(paramString.basePath.length()) == '/');
      }
      label218:
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
      label262:
      if (((a)localObject2).YEf == null) {
        ((a)localObject2).YEf = bBL(((a)localObject2).YDQ);
      }
    }
  }
  
  public final SchemeResolver.a bBN(String paramString)
  {
    AppMethodBeat.i(236784);
    paramString = (n)this.YDS.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(236784);
      return null;
    }
    if (paramString.YEh == null)
    {
      SchemeResolver localSchemeResolver = paramString.YEg;
      ift();
      paramString.YEh = localSchemeResolver.ifv();
    }
    paramString = paramString.YEh;
    AppMethodBeat.o(236784);
    return paramString;
  }
  
  public final Map<String, FileSystem> ifl()
  {
    AppMethodBeat.i(236779);
    if (this.YEa == null)
    {
      localObject = new HashMap();
      Iterator localIterator = this.YDT.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((Map)localObject).put(localEntry.getKey(), ((g)localEntry.getValue()).YCm);
      }
      this.YEa = ((Map)localObject);
    }
    Object localObject = this.YEa;
    AppMethodBeat.o(236779);
    return localObject;
  }
  
  public final Map<String, String> ift()
  {
    AppMethodBeat.i(13225);
    if (this.YEc == null) {
      this.YEc = Collections.unmodifiableMap(this.YDX);
    }
    Map localMap = this.YEc;
    AppMethodBeat.o(13225);
    return localMap;
  }
  
  public final List<l.a> ifu()
  {
    AppMethodBeat.i(236786);
    if (this.YEd == null) {
      this.YEd = Collections.unmodifiableList(this.YDW);
    }
    List localList = this.YEd;
    AppMethodBeat.o(236786);
    return localList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13226);
    String str = "schemes: " + this.YDS.size() + ", fileSystems: " + this.YDT.size() + ", mountPoints: " + this.YDV.size() + " (" + this.YDW + " active), envVars: " + this.YDX.size();
    AppMethodBeat.o(13226);
    return str;
  }
  
  final Bundle writeToBundle()
  {
    AppMethodBeat.i(13221);
    Bundle localBundle1 = new Bundle();
    Object localObject3 = new HashMap();
    ArrayList localArrayList = new ArrayList(this.YDS.size());
    Bundle localBundle2 = new Bundle();
    Iterator localIterator = this.YDS.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      SchemeResolver localSchemeResolver = ((n)localEntry.getValue()).YEg;
      localObject2 = (Integer)((HashMap)localObject3).get(localSchemeResolver);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = Integer.valueOf(localArrayList.size());
        localArrayList.add(localSchemeResolver);
        ((HashMap)localObject3).put(localSchemeResolver, localObject1);
      }
      localBundle2.putInt((String)localEntry.getKey(), ((Integer)localObject1).intValue());
    }
    localBundle1.putParcelableArrayList("sl", localArrayList);
    localBundle1.putBundle("sm", localBundle2);
    Object localObject1 = new Bundle();
    Object localObject2 = this.YDT.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putParcelable((String)((Map.Entry)localObject3).getKey(), ((g)((Map.Entry)localObject3).getValue()).YCm);
    }
    localBundle1.putBundle("fs", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.YDU.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putParcelable((String)((Map.Entry)localObject3).getKey(), ((g)((Map.Entry)localObject3).getValue()).YCm);
    }
    localBundle1.putBundle("mfs", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.YDV.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putString((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("mp", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.YDX.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putString((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("env", (Bundle)localObject1);
    localBundle1.putParcelable("root", this.YDY.YCm);
    AppMethodBeat.o(13221);
    return localBundle1;
  }
  
  static final class a
    extends l.a
    implements Comparable<String>
  {
    final int YEe;
    FileSystem.b YEf;
    
    a(String paramString1, String paramString2, int paramInt, FileSystem.b paramb)
    {
      super(paramString2);
      this.YEe = paramInt;
      this.YEf = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.m
 * JD-Core Version:    0.7.0.1
 */