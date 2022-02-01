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
import java.util.Map<Ljava.lang.String;Lcom.tencent.mm.vfs.i;>;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.TreeMap;

final class h
  implements g
{
  private static final d LHr;
  private Map<String, String> LHA;
  private List<g.a> LHB;
  final Map<String, i> LHs;
  final Map<String, d> LHt;
  final SortedMap<String, String> LHu;
  final List<a> LHv;
  final Map<String, String> LHw;
  final d LHx;
  private Map<String, SchemeResolver> LHy;
  private Map<String, FileSystem> LHz;
  
  static
  {
    AppMethodBeat.i(13227);
    LHr = new d(new NativeFileSystem(""));
    AppMethodBeat.o(13227);
  }
  
  h()
  {
    AppMethodBeat.i(13218);
    this.LHy = null;
    this.LHz = null;
    this.LHA = null;
    this.LHB = null;
    this.LHs = Collections.emptyMap();
    this.LHt = Collections.emptyMap();
    this.LHu = new TreeMap();
    this.LHv = Collections.emptyList();
    this.LHw = Collections.emptyMap();
    this.LHx = LHr;
    AppMethodBeat.o(13218);
  }
  
  private h(Map<String, i> paramMap, Map<String, d> paramMap1, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap2, d paramd)
  {
    AppMethodBeat.i(193437);
    this.LHy = null;
    this.LHz = null;
    this.LHA = null;
    this.LHB = null;
    this.LHs = paramMap;
    this.LHt = paramMap1;
    this.LHu = paramSortedMap;
    this.LHv = a(paramMap1, paramSortedMap, paramMap2);
    this.LHw = paramMap2;
    paramMap = paramd;
    if (paramd == null) {
      paramMap = LHr;
    }
    this.LHx = paramMap;
    AppMethodBeat.o(193437);
  }
  
  private static List<a> a(Map<String, d> paramMap, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap1)
  {
    AppMethodBeat.i(13224);
    ArrayList localArrayList = new ArrayList(paramSortedMap.size());
    paramSortedMap = paramSortedMap.entrySet().iterator();
    while (paramSortedMap.hasNext())
    {
      Object localObject = (Map.Entry)paramSortedMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      d locald = (d)paramMap.get(localObject);
      if (locald == null)
      {
        paramMap = new IllegalArgumentException("FileSystem '" + (String)localObject + "' for mount point '" + str + "' not exist.");
        AppMethodBeat.o(13224);
        throw paramMap;
      }
      str = w.T(str, paramMap1);
      if (str != null) {
        localArrayList.add(new a(str, (String)localObject, -1, locald.LGe));
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
      for (i = localArrayList.LHC;; i = k)
      {
        if (i >= 0) {
          paramMap[j] = new a(paramSortedMap.basePath, paramSortedMap.LHq, i, paramSortedMap.LHD);
        }
        j += 1;
        break;
        do
        {
          localArrayList = paramMap[i];
          if ((paramMap1.startsWith(localArrayList.basePath)) && (paramMap1.charAt(localArrayList.basePath.length()) == '/')) {
            break;
          }
          k = localArrayList.LHC;
          i = k;
        } while (k >= 0);
      }
    }
    paramMap = Arrays.asList(paramMap);
    AppMethodBeat.o(13224);
    return paramMap;
  }
  
  static h bl(Bundle paramBundle)
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
          localHashMap.put(localObject4, new i((SchemeResolver)((ArrayList)localObject1).get(i)));
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
        ((HashMap)localObject1).put(localObject4, new d((FileSystem)((Bundle)localObject2).getParcelable((String)localObject4)));
      }
    }
    Object localObject3 = paramBundle.getBundle("mp");
    localObject2 = new TreeMap();
    Object localObject5;
    if (localObject3 != null)
    {
      ((Bundle)localObject3).setClassLoader(paramBundle.getClassLoader());
      localObject4 = ((Bundle)localObject3).keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        ((TreeMap)localObject2).put(localObject5, ((Bundle)localObject3).getString((String)localObject5));
      }
    }
    localObject3 = paramBundle.getBundle("env");
    Object localObject4 = new HashMap();
    if (localObject3 != null)
    {
      localObject5 = ((Bundle)localObject3).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        String str = (String)((Iterator)localObject5).next();
        ((HashMap)localObject4).put(str, ((Bundle)localObject3).getString(str));
      }
    }
    paramBundle = new h(localHashMap, (Map)localObject1, (SortedMap)localObject2, (Map)localObject4, new d((FileSystem)paramBundle.getParcelable("root")));
    AppMethodBeat.o(13222);
    return paramBundle;
  }
  
  private static <K, V> void c(Map<K, V> paramMap1, Map<K, V> paramMap2)
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
  
  final h a(Map<String, i> paramMap, Map<String, d> paramMap1, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap2, d paramd)
  {
    AppMethodBeat.i(193438);
    Object localObject1;
    label35:
    label49:
    label60:
    Object localObject2;
    if (paramMap.isEmpty())
    {
      paramMap = this.LHs;
      if (!paramMap1.isEmpty()) {
        break label160;
      }
      localObject1 = this.LHt;
      if (!paramSortedMap.isEmpty()) {
        break label182;
      }
      paramSortedMap = this.LHu;
      if (paramd != null) {
        break label207;
      }
      paramd = this.LHx;
      if (!paramMap2.isEmpty()) {
        break label210;
      }
      localObject2 = this.LHw;
    }
    for (;;)
    {
      paramMap = new h(paramMap, (Map)localObject1, paramSortedMap, (Map)localObject2, paramd);
      if (paramMap1.isEmpty()) {
        paramMap.LHz = this.LHz;
      }
      if (paramMap2.isEmpty()) {
        paramMap.LHA = this.LHA;
      }
      AppMethodBeat.o(193438);
      return paramMap;
      localObject1 = new HashMap(this.LHs);
      c((Map)localObject1, paramMap);
      paramMap = (Map<String, i>)localObject1;
      break;
      label160:
      localObject1 = new HashMap(this.LHt);
      c((Map)localObject1, paramMap1);
      break label35;
      label182:
      localObject2 = new TreeMap(this.LHu);
      c((Map)localObject2, paramSortedMap);
      paramSortedMap = (SortedMap<String, String>)localObject2;
      break label49;
      label207:
      break label60;
      label210:
      localObject2 = new HashMap(this.LHw);
      c((Map)localObject2, paramMap2);
      Iterator localIterator = paramMap.values().iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).LHF = null;
      }
      localIterator = ((Map)localObject1).values().iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).LGe = null;
      }
      paramd.LGe = null;
    }
  }
  
  public final FileSystem.b aZO(String paramString)
  {
    AppMethodBeat.i(193440);
    paramString = (d)this.LHt.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(193440);
      return null;
    }
    if (paramString.LGe == null) {
      paramString.LGe = paramString.LGg.cd(fTa());
    }
    paramString = paramString.LGe;
    AppMethodBeat.o(193440);
    return paramString;
  }
  
  public final Pair<FileSystem.b, String> aZP(String paramString)
  {
    AppMethodBeat.i(193443);
    Object localObject2 = this.LHv;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(193443);
      return null;
    }
    String str = w.baa(paramString);
    int i = Collections.binarySearch((List)localObject2, str);
    if (i >= 0)
    {
      localObject2 = (a)((List)localObject2).get(i);
      paramString = "";
      if (localObject2 != null) {
        break label260;
      }
      if (this.LHx.LGe == null) {
        this.LHx.LGe = this.LHx.LGg.cd(fTa());
      }
    }
    for (Object localObject1 = this.LHx.LGe;; localObject1 = ((a)localObject2).LHD)
    {
      paramString = new Pair(localObject1, paramString);
      AppMethodBeat.o(193443);
      return paramString;
      label208:
      for (i = -i - 2;; i = paramString.LHC)
      {
        if (i < 0) {
          localObject1 = null;
        }
        do
        {
          if (i < 0) {
            break label216;
          }
          paramString = str.substring(((a)localObject1).basePath.length() + 1);
          localObject2 = localObject1;
          break;
          paramString = (a)((List)localObject2).get(i);
          if (!str.startsWith(paramString.basePath)) {
            break label208;
          }
          localObject1 = paramString;
        } while (str.charAt(paramString.basePath.length()) == '/');
      }
      label216:
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
      label260:
      if (((a)localObject2).LHD == null) {
        ((a)localObject2).LHD = aZO(((a)localObject2).LHq);
      }
    }
  }
  
  public final SchemeResolver.a aZQ(String paramString)
  {
    AppMethodBeat.i(193441);
    paramString = (i)this.LHs.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(193441);
      return null;
    }
    if (paramString.LHF == null)
    {
      SchemeResolver localSchemeResolver = paramString.LHE;
      fTa();
      paramString.LHF = localSchemeResolver.fTc();
    }
    paramString = paramString.LHF;
    AppMethodBeat.o(193441);
    return paramString;
  }
  
  final Bundle ebW()
  {
    AppMethodBeat.i(13221);
    Bundle localBundle1 = new Bundle();
    Object localObject3 = new HashMap();
    ArrayList localArrayList = new ArrayList(this.LHs.size());
    Bundle localBundle2 = new Bundle();
    Iterator localIterator = this.LHs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      SchemeResolver localSchemeResolver = ((i)localEntry.getValue()).LHE;
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
    Object localObject2 = this.LHt.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putParcelable((String)((Map.Entry)localObject3).getKey(), ((d)((Map.Entry)localObject3).getValue()).LGg);
    }
    localBundle1.putBundle("fs", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.LHu.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putString((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("mp", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.LHw.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putString((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("env", (Bundle)localObject1);
    localBundle1.putParcelable("root", this.LHx.LGg);
    AppMethodBeat.o(13221);
    return localBundle1;
  }
  
  public final Map<String, FileSystem> fSZ()
  {
    AppMethodBeat.i(193439);
    if (this.LHz == null)
    {
      localObject = new HashMap();
      Iterator localIterator = this.LHt.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((Map)localObject).put(localEntry.getKey(), ((d)localEntry.getValue()).LGg);
      }
      this.LHz = ((Map)localObject);
    }
    Object localObject = this.LHz;
    AppMethodBeat.o(193439);
    return localObject;
  }
  
  public final Map<String, String> fTa()
  {
    AppMethodBeat.i(13225);
    if (this.LHA == null) {
      this.LHA = Collections.unmodifiableMap(this.LHw);
    }
    Map localMap = this.LHA;
    AppMethodBeat.o(13225);
    return localMap;
  }
  
  public final List<g.a> fTb()
  {
    AppMethodBeat.i(193442);
    if (this.LHB == null) {
      this.LHB = Collections.unmodifiableList(this.LHv);
    }
    List localList = this.LHB;
    AppMethodBeat.o(193442);
    return localList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13226);
    String str = "schemes: " + this.LHs.size() + ", fileSystems: " + this.LHt.size() + ", mountPoints: " + this.LHu.size() + " (" + this.LHv + " active), envVars: " + this.LHw.size();
    AppMethodBeat.o(13226);
    return str;
  }
  
  static final class a
    extends g.a
    implements Comparable<String>
  {
    final int LHC;
    FileSystem.b LHD;
    
    a(String paramString1, String paramString2, int paramInt, FileSystem.b paramb)
    {
      super(paramString2);
      this.LHC = paramInt;
      this.LHD = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.h
 * JD-Core Version:    0.7.0.1
 */