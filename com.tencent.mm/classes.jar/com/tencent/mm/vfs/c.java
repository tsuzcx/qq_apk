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
  private static final FileSystem Jtk;
  final Map<String, SchemeResolver> Jtl;
  final Map<String, FileSystem> Jtm;
  final SortedMap<String, String> Jtn;
  final List<a> Jto;
  final Map<String, String> Jtp;
  final FileSystem Jtq;
  Map<String, FileSystem> Jtr;
  private Map<String, String> Jts;
  
  static
  {
    AppMethodBeat.i(13227);
    Jtk = new NativeFileSystem("");
    AppMethodBeat.o(13227);
  }
  
  c()
  {
    AppMethodBeat.i(13218);
    this.Jtr = null;
    this.Jts = null;
    this.Jtl = Collections.emptyMap();
    this.Jtm = Collections.emptyMap();
    this.Jtn = new TreeMap();
    this.Jto = Collections.emptyList();
    this.Jtp = Collections.emptyMap();
    this.Jtq = Jtk;
    AppMethodBeat.o(13218);
  }
  
  private c(Map<String, SchemeResolver> paramMap, Map<String, FileSystem> paramMap1, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap2, FileSystem paramFileSystem)
  {
    AppMethodBeat.i(13219);
    this.Jtr = null;
    this.Jts = null;
    this.Jtl = paramMap;
    this.Jtm = paramMap1;
    this.Jtn = paramSortedMap;
    this.Jto = a(paramMap1, paramSortedMap, paramMap2);
    this.Jtp = paramMap2;
    paramMap = paramFileSystem;
    if (paramFileSystem == null) {
      paramMap = Jtk;
    }
    this.Jtq = paramMap;
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
      str = q.Q(str, paramMap1);
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
      paramMap1 = paramSortedMap.basePath;
      int i = j - 1;
      localArrayList = paramMap[i];
      if (paramSortedMap.basePath.equals(localArrayList.basePath)) {
        Log.w("VFS.ResolverState", "Oops, duplicated mount point detected: " + paramSortedMap.toString() + " <=> " + localArrayList.toString());
      }
      int k;
      for (i = localArrayList.Jtu;; i = k)
      {
        if (i >= 0) {
          paramMap[j] = new a(paramSortedMap.basePath, paramSortedMap.Jtt, paramSortedMap.Jsh, i);
        }
        j += 1;
        break;
        do
        {
          localArrayList = paramMap[i];
          if ((paramMap1.startsWith(localArrayList.basePath)) && (paramMap1.charAt(localArrayList.basePath.length()) == '/')) {
            break;
          }
          k = localArrayList.Jtu;
          i = k;
        } while (k >= 0);
      }
    }
    paramMap = Arrays.asList(paramMap);
    AppMethodBeat.o(13224);
    return paramMap;
  }
  
  static c bf(Bundle paramBundle)
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
      paramMap = this.Jtl;
      if (!paramMap1.isEmpty()) {
        break label160;
      }
      localObject1 = this.Jtm;
      if (!paramSortedMap.isEmpty()) {
        break label182;
      }
      paramSortedMap = this.Jtn;
      if (!paramMap2.isEmpty()) {
        break label207;
      }
      localObject2 = this.Jtp;
      label65:
      if (paramFileSystem != null) {
        break label230;
      }
      paramFileSystem = this.Jtq;
    }
    label160:
    label182:
    label207:
    label230:
    for (;;)
    {
      paramMap = new c(paramMap, (Map)localObject1, paramSortedMap, (Map)localObject2, paramFileSystem);
      if (paramMap1.isEmpty()) {
        paramMap.Jtr = this.Jtr;
      }
      if (paramMap2.isEmpty()) {
        paramMap.Jts = this.Jts;
      }
      AppMethodBeat.o(13220);
      return paramMap;
      localObject1 = new HashMap(this.Jtl);
      c((Map)localObject1, paramMap);
      paramMap = (Map<String, SchemeResolver>)localObject1;
      break;
      localObject1 = new HashMap(this.Jtm);
      c((Map)localObject1, paramMap1);
      break label35;
      localObject2 = new TreeMap(this.Jtn);
      c((Map)localObject2, paramSortedMap);
      paramSortedMap = (SortedMap<String, String>)localObject2;
      break label49;
      localObject2 = new HashMap(this.Jtp);
      c((Map)localObject2, paramMap2);
      break label65;
    }
  }
  
  final Bundle dMc()
  {
    AppMethodBeat.i(13221);
    Bundle localBundle1 = new Bundle();
    Object localObject3 = new HashMap();
    ArrayList localArrayList = new ArrayList(this.Jtl.size());
    Bundle localBundle2 = new Bundle();
    Iterator localIterator = this.Jtl.entrySet().iterator();
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
    Object localObject2 = this.Jtm.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putParcelable((String)((Map.Entry)localObject3).getKey(), (Parcelable)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("fs", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.Jtn.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putString((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("mp", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.Jtp.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putString((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("env", (Bundle)localObject1);
    localBundle1.putParcelable("root", this.Jtq);
    AppMethodBeat.o(13221);
    return localBundle1;
  }
  
  public final Map<String, String> fxQ()
  {
    AppMethodBeat.i(13225);
    if (this.Jts == null) {
      this.Jts = Collections.unmodifiableMap(this.Jtp);
    }
    Map localMap = this.Jts;
    AppMethodBeat.o(13225);
    return localMap;
  }
  
  public final FileSystem fxR()
  {
    return this.Jtq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13226);
    String str = "schemes: " + this.Jtl.size() + ", fileSystems: " + this.Jtm.size() + ", mountPoints: " + this.Jtn.size() + " (" + this.Jto + " active), envVars: " + this.Jtp.size();
    AppMethodBeat.o(13226);
    return str;
  }
  
  static final class a
    implements Comparable<String>
  {
    final FileSystem Jsh;
    final String Jtt;
    final int Jtu;
    final String basePath;
    
    a(String paramString1, String paramString2, FileSystem paramFileSystem, int paramInt)
    {
      this.basePath = paramString1;
      this.Jtt = paramString2;
      this.Jsh = paramFileSystem;
      this.Jtu = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13216);
      String str = this.basePath + " -> " + this.Jtt + " " + this.Jsh.toString();
      AppMethodBeat.o(13216);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.c
 * JD-Core Version:    0.7.0.1
 */