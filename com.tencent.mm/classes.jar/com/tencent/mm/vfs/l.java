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
import java.util.Map<Ljava.lang.String;Lcom.tencent.mm.vfs.f;>;
import java.util.Map<Ljava.lang.String;Lcom.tencent.mm.vfs.m;>;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.TreeMap;

final class l
  implements k
{
  private static final f Rdd;
  final Map<String, m> Rde;
  final Map<String, f> Rdf;
  final Map<String, f> Rdg;
  final SortedMap<String, String> Rdh;
  final List<a> Rdi;
  final Map<String, String> Rdj;
  final f Rdk;
  private Map<String, SchemeResolver> Rdl;
  private Map<String, FileSystem> Rdm;
  private Map<String, FileSystem> Rdn;
  private Map<String, String> Rdo;
  private List<k.a> Rdp;
  
  static
  {
    AppMethodBeat.i(13227);
    Rdd = new f(new NativeFileSystem(""));
    AppMethodBeat.o(13227);
  }
  
  l()
  {
    AppMethodBeat.i(13218);
    this.Rdl = null;
    this.Rdm = null;
    this.Rdn = null;
    this.Rdo = null;
    this.Rdp = null;
    this.Rde = Collections.emptyMap();
    this.Rdf = Collections.emptyMap();
    this.Rdg = Collections.emptyMap();
    this.Rdh = new TreeMap();
    this.Rdi = Collections.emptyList();
    this.Rdj = Collections.emptyMap();
    this.Rdk = Rdd;
    AppMethodBeat.o(13218);
  }
  
  private l(Map<String, m> paramMap, Map<String, f> paramMap1, Map<String, f> paramMap2, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap3, f paramf)
  {
    AppMethodBeat.i(187732);
    this.Rdl = null;
    this.Rdm = null;
    this.Rdn = null;
    this.Rdo = null;
    this.Rdp = null;
    this.Rde = paramMap;
    this.Rdf = paramMap1;
    this.Rdg = paramMap2;
    this.Rdh = paramSortedMap;
    this.Rdi = a(paramMap1, paramSortedMap, paramMap3);
    this.Rdj = paramMap3;
    paramMap = paramf;
    if (paramf == null) {
      paramMap = Rdd;
    }
    this.Rdk = paramMap;
    AppMethodBeat.o(187732);
  }
  
  private static List<a> a(Map<String, f> paramMap, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap1)
  {
    AppMethodBeat.i(13224);
    ArrayList localArrayList = new ArrayList(paramSortedMap.size());
    paramSortedMap = paramSortedMap.entrySet().iterator();
    while (paramSortedMap.hasNext())
    {
      Object localObject = (Map.Entry)paramSortedMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      f localf = (f)paramMap.get(localObject);
      if (localf == null)
      {
        paramMap = new IllegalArgumentException("FileSystem '" + (String)localObject + "' for mount point '" + str + "' not exist.");
        AppMethodBeat.o(13224);
        throw paramMap;
      }
      str = aa.aa(str, paramMap1);
      if (str != null) {
        localArrayList.add(new a(str, (String)localObject, -1, localf.RbK));
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
      for (i = localArrayList.Rdq;; i = k)
      {
        if (i >= 0) {
          paramMap[j] = new a(paramSortedMap.basePath, paramSortedMap.Rdc, i, paramSortedMap.Rdr);
        }
        j += 1;
        break;
        do
        {
          localArrayList = paramMap[i];
          if ((paramMap1.startsWith(localArrayList.basePath)) && (paramMap1.charAt(localArrayList.basePath.length()) == '/')) {
            break;
          }
          k = localArrayList.Rdq;
          i = k;
        } while (k >= 0);
      }
    }
    paramMap = Arrays.asList(paramMap);
    AppMethodBeat.o(13224);
    return paramMap;
  }
  
  static l by(Bundle paramBundle)
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
          localHashMap.put(localObject4, new m((SchemeResolver)((ArrayList)localObject1).get(i)));
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
        ((HashMap)localObject1).put(localObject4, new f((FileSystem)((Bundle)localObject2).getParcelable((String)localObject4)));
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
        ((HashMap)localObject2).put(localObject5, new f((FileSystem)((Bundle)localObject3).getParcelable((String)localObject5)));
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
    localObject4 = paramBundle.getBundle("env");
    Object localObject5 = new HashMap();
    if (localObject4 != null)
    {
      localObject6 = ((Bundle)localObject4).keySet().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        String str = (String)((Iterator)localObject6).next();
        ((HashMap)localObject5).put(str, ((Bundle)localObject4).getString(str));
      }
    }
    paramBundle = new l(localHashMap, (Map)localObject1, (Map)localObject2, (SortedMap)localObject3, (Map)localObject5, new f((FileSystem)paramBundle.getParcelable("root")));
    AppMethodBeat.o(13222);
    return paramBundle;
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
  
  final l a(Map<String, m> paramMap, Map<String, f> paramMap1, Map<String, f> paramMap2, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap3, f paramf)
  {
    AppMethodBeat.i(187733);
    Object localObject1;
    label35:
    label49:
    label65:
    label76:
    Object localObject2;
    if (paramMap.isEmpty())
    {
      paramMap = this.Rde;
      if (!paramMap1.isEmpty()) {
        break label178;
      }
      localObject1 = this.Rdf;
      if (!paramMap2.isEmpty()) {
        break label200;
      }
      paramMap2 = this.Rdg;
      if (!paramSortedMap.isEmpty()) {
        break label225;
      }
      paramSortedMap = this.Rdh;
      if (paramf != null) {
        break label252;
      }
      paramf = this.Rdk;
      if (!paramMap3.isEmpty()) {
        break label255;
      }
      localObject2 = this.Rdj;
    }
    for (;;)
    {
      paramMap = new l(paramMap, (Map)localObject1, paramMap2, paramSortedMap, (Map)localObject2, paramf);
      if (paramMap1.isEmpty()) {
        paramMap.Rdm = this.Rdm;
      }
      if (paramMap3.isEmpty()) {
        paramMap.Rdo = this.Rdo;
      }
      AppMethodBeat.o(187733);
      return paramMap;
      localObject1 = new HashMap(this.Rde);
      e((Map)localObject1, paramMap);
      paramMap = (Map<String, m>)localObject1;
      break;
      label178:
      localObject1 = new HashMap(this.Rdf);
      e((Map)localObject1, paramMap1);
      break label35;
      label200:
      localObject2 = new HashMap(this.Rdg);
      e((Map)localObject2, paramMap2);
      paramMap2 = (Map<String, f>)localObject2;
      break label49;
      label225:
      localObject2 = new TreeMap(this.Rdh);
      e((Map)localObject2, paramSortedMap);
      paramSortedMap = (SortedMap<String, String>)localObject2;
      break label65;
      label252:
      break label76;
      label255:
      localObject2 = new HashMap(this.Rdj);
      e((Map)localObject2, paramMap3);
      Iterator localIterator = paramMap.values().iterator();
      while (localIterator.hasNext()) {
        ((m)localIterator.next()).Rdt = null;
      }
      localIterator = ((Map)localObject1).values().iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).RbK = null;
      }
      localIterator = paramMap2.values().iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).RbK = null;
      }
      paramf.RbK = null;
    }
  }
  
  public final FileSystem.b boT(String paramString)
  {
    AppMethodBeat.i(187735);
    paramString = (f)this.Rdf.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(187735);
      return null;
    }
    if (paramString.RbK == null) {
      paramString.RbK = paramString.RbM.cj(hej());
    }
    paramString = paramString.RbK;
    AppMethodBeat.o(187735);
    return paramString;
  }
  
  public final Pair<FileSystem.b, String> boU(String paramString)
  {
    AppMethodBeat.i(187738);
    Object localObject2 = this.Rdi;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(187738);
      return null;
    }
    String str = aa.q(paramString, true, false);
    int i = Collections.binarySearch((List)localObject2, str);
    if (i >= 0)
    {
      localObject2 = (a)((List)localObject2).get(i);
      paramString = "";
      if (localObject2 != null) {
        break label262;
      }
      if (this.Rdk.RbK == null) {
        this.Rdk.RbK = this.Rdk.RbM.cj(hej());
      }
    }
    for (Object localObject1 = this.Rdk.RbK;; localObject1 = ((a)localObject2).Rdr)
    {
      paramString = new Pair(localObject1, paramString);
      AppMethodBeat.o(187738);
      return paramString;
      label210:
      for (i = -i - 2;; i = paramString.Rdq)
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
      if (((a)localObject2).Rdr == null) {
        ((a)localObject2).Rdr = boT(((a)localObject2).Rdc);
      }
    }
  }
  
  public final SchemeResolver.a boV(String paramString)
  {
    AppMethodBeat.i(187736);
    paramString = (m)this.Rde.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(187736);
      return null;
    }
    if (paramString.Rdt == null)
    {
      SchemeResolver localSchemeResolver = paramString.Rds;
      hej();
      paramString.Rdt = localSchemeResolver.hel();
    }
    paramString = paramString.Rdt;
    AppMethodBeat.o(187736);
    return paramString;
  }
  
  public final Map<String, FileSystem> hec()
  {
    AppMethodBeat.i(187734);
    if (this.Rdm == null)
    {
      localObject = new HashMap();
      Iterator localIterator = this.Rdf.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((Map)localObject).put(localEntry.getKey(), ((f)localEntry.getValue()).RbM);
      }
      this.Rdm = ((Map)localObject);
    }
    Object localObject = this.Rdm;
    AppMethodBeat.o(187734);
    return localObject;
  }
  
  public final Map<String, String> hej()
  {
    AppMethodBeat.i(13225);
    if (this.Rdo == null) {
      this.Rdo = Collections.unmodifiableMap(this.Rdj);
    }
    Map localMap = this.Rdo;
    AppMethodBeat.o(13225);
    return localMap;
  }
  
  public final List<k.a> hek()
  {
    AppMethodBeat.i(187737);
    if (this.Rdp == null) {
      this.Rdp = Collections.unmodifiableList(this.Rdi);
    }
    List localList = this.Rdp;
    AppMethodBeat.o(187737);
    return localList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13226);
    String str = "schemes: " + this.Rde.size() + ", fileSystems: " + this.Rdf.size() + ", mountPoints: " + this.Rdh.size() + " (" + this.Rdi + " active), envVars: " + this.Rdj.size();
    AppMethodBeat.o(13226);
    return str;
  }
  
  static final class a
    extends k.a
    implements Comparable<String>
  {
    final int Rdq;
    FileSystem.b Rdr;
    
    a(String paramString1, String paramString2, int paramInt, FileSystem.b paramb)
    {
      super(paramString2);
      this.Rdq = paramInt;
      this.Rdr = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.l
 * JD-Core Version:    0.7.0.1
 */