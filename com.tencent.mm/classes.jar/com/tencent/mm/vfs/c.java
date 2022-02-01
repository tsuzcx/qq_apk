package com.tencent.mm.vfs;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Lcom.tencent.mm.vfs.SchemeResolver;>;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.TreeMap;

final class c
  implements SchemeResolver.a
{
  private static final FileSystem HSO;
  final Map<String, SchemeResolver> HSP;
  final Map<String, FileSystem> HSQ;
  final SortedMap<String, String> HSR;
  final List<a> HSS;
  final Map<String, String> HST;
  final FileSystem HSU;
  Map<String, FileSystem> HSV;
  private Map<String, String> HSW;
  
  static
  {
    AppMethodBeat.i(13227);
    HSO = new NativeFileSystem("");
    AppMethodBeat.o(13227);
  }
  
  c()
  {
    AppMethodBeat.i(13218);
    this.HSV = null;
    this.HSW = null;
    this.HSP = Collections.emptyMap();
    this.HSQ = Collections.emptyMap();
    this.HSR = new TreeMap();
    this.HSS = Collections.emptyList();
    this.HST = Collections.emptyMap();
    this.HSU = HSO;
    AppMethodBeat.o(13218);
  }
  
  private c(Map<String, SchemeResolver> paramMap, Map<String, FileSystem> paramMap1, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap2, FileSystem paramFileSystem)
  {
    AppMethodBeat.i(13219);
    this.HSV = null;
    this.HSW = null;
    this.HSP = paramMap;
    this.HSQ = paramMap1;
    this.HSR = paramSortedMap;
    this.HSS = a(paramMap1, paramSortedMap, paramMap2);
    this.HST = paramMap2;
    paramMap = paramFileSystem;
    if (paramFileSystem == null) {
      paramMap = HSO;
    }
    this.HSU = paramMap;
    AppMethodBeat.o(13219);
  }
  
  private static List<a> a(Map<String, FileSystem> paramMap, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap1)
  {
    AppMethodBeat.i(13224);
    ArrayList localArrayList = new ArrayList(paramSortedMap.size());
    paramSortedMap = paramSortedMap.entrySet().iterator();
    while (paramSortedMap.hasNext())
    {
      Object localObject = (Map.Entry)paramSortedMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      FileSystem localFileSystem = (FileSystem)paramMap.get(localObject);
      if (localFileSystem == null)
      {
        paramMap = new IllegalArgumentException("FileSystem '" + (String)localObject + "' for mount point '" + str + "' not exist.");
        AppMethodBeat.o(13224);
        throw paramMap;
      }
      str = q.P(str, paramMap1);
      if (str != null) {
        localArrayList.add(new a(str, (String)localObject, localFileSystem, -1));
      }
    }
    paramMap = (a[])localArrayList.toArray(new a[0]);
    Arrays.sort(paramMap, new Comparator() {});
    int j = 1;
    if (j < paramMap.length)
    {
      paramSortedMap = paramMap[j];
      paramMap1 = paramSortedMap.HSX;
      int i = j - 1;
      localArrayList = paramMap[i];
      if (paramSortedMap.HSX.equals(localArrayList.HSX)) {
        Log.w("VFS.ResolverState", "Oops, duplicated mount point detected: " + paramSortedMap.toString() + " <=> " + localArrayList.toString());
      }
      int k;
      for (i = localArrayList.HSZ;; i = k)
      {
        if (i >= 0) {
          paramMap[j] = new a(paramSortedMap.HSX, paramSortedMap.HSY, paramSortedMap.HRC, i);
        }
        j += 1;
        break;
        do
        {
          localArrayList = paramMap[i];
          if ((paramMap1.startsWith(localArrayList.HSX)) && (paramMap1.charAt(localArrayList.HSX.length()) == '/')) {
            break;
          }
          k = localArrayList.HSZ;
          i = k;
        } while (k >= 0);
      }
    }
    paramMap = Arrays.asList(paramMap);
    AppMethodBeat.o(13224);
    return paramMap;
  }
  
  static c bb(Bundle paramBundle)
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
          localHashMap.put(localObject4, ((ArrayList)localObject1).get(i));
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
        ((HashMap)localObject1).put(localObject4, ((Bundle)localObject2).getParcelable((String)localObject4));
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
    paramBundle = new c(localHashMap, (Map)localObject1, (SortedMap)localObject2, (Map)localObject4, (FileSystem)paramBundle.getParcelable("root"));
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
  
  final c a(Map<String, SchemeResolver> paramMap, Map<String, FileSystem> paramMap1, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap2, FileSystem paramFileSystem)
  {
    AppMethodBeat.i(13220);
    Object localObject1;
    label35:
    label49:
    Object localObject2;
    if (paramMap.isEmpty())
    {
      paramMap = this.HSP;
      if (!paramMap1.isEmpty()) {
        break label160;
      }
      localObject1 = this.HSQ;
      if (!paramSortedMap.isEmpty()) {
        break label182;
      }
      paramSortedMap = this.HSR;
      if (!paramMap2.isEmpty()) {
        break label207;
      }
      localObject2 = this.HST;
      label65:
      if (paramFileSystem != null) {
        break label230;
      }
      paramFileSystem = this.HSU;
    }
    label160:
    label182:
    label207:
    label230:
    for (;;)
    {
      paramMap = new c(paramMap, (Map)localObject1, paramSortedMap, (Map)localObject2, paramFileSystem);
      if (paramMap1.isEmpty()) {
        paramMap.HSV = this.HSV;
      }
      if (paramMap2.isEmpty()) {
        paramMap.HSW = this.HSW;
      }
      AppMethodBeat.o(13220);
      return paramMap;
      localObject1 = new HashMap(this.HSP);
      c((Map)localObject1, paramMap);
      paramMap = (Map<String, SchemeResolver>)localObject1;
      break;
      localObject1 = new HashMap(this.HSQ);
      c((Map)localObject1, paramMap1);
      break label35;
      localObject2 = new TreeMap(this.HSR);
      c((Map)localObject2, paramSortedMap);
      paramSortedMap = (SortedMap<String, String>)localObject2;
      break label49;
      localObject2 = new HashMap(this.HST);
      c((Map)localObject2, paramMap2);
      break label65;
    }
  }
  
  final Bundle dxF()
  {
    AppMethodBeat.i(13221);
    Bundle localBundle1 = new Bundle();
    Object localObject3 = new HashMap();
    ArrayList localArrayList = new ArrayList(this.HSP.size());
    Bundle localBundle2 = new Bundle();
    Iterator localIterator = this.HSP.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      SchemeResolver localSchemeResolver = (SchemeResolver)localEntry.getValue();
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
    Object localObject2 = this.HSQ.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putParcelable((String)((Map.Entry)localObject3).getKey(), (Parcelable)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("fs", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.HSR.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putString((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("mp", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.HST.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putString((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("env", (Bundle)localObject1);
    localBundle1.putParcelable("root", this.HSU);
    AppMethodBeat.o(13221);
    return localBundle1;
  }
  
  public final Map<String, String> fhP()
  {
    AppMethodBeat.i(13225);
    if (this.HSW == null) {
      this.HSW = Collections.unmodifiableMap(this.HST);
    }
    Map localMap = this.HSW;
    AppMethodBeat.o(13225);
    return localMap;
  }
  
  public final FileSystem fhQ()
  {
    return this.HSU;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13226);
    String str = "schemes: " + this.HSP.size() + ", fileSystems: " + this.HSQ.size() + ", mountPoints: " + this.HSR.size() + " (" + this.HSS + " active), envVars: " + this.HST.size();
    AppMethodBeat.o(13226);
    return str;
  }
  
  static final class a
    implements Comparable<String>
  {
    final FileSystem HRC;
    final String HSX;
    final String HSY;
    final int HSZ;
    
    a(String paramString1, String paramString2, FileSystem paramFileSystem, int paramInt)
    {
      this.HSX = paramString1;
      this.HSY = paramString2;
      this.HRC = paramFileSystem;
      this.HSZ = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13216);
      String str = this.HSX + " -> " + this.HSY + " " + this.HRC.toString();
      AppMethodBeat.o(13216);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.c
 * JD-Core Version:    0.7.0.1
 */