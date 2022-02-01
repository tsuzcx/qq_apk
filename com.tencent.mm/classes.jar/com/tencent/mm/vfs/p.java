package com.tencent.mm.vfs;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

final class p
{
  private static final Comparator<h> agzr;
  final Map<String, r<SchemeResolver, SchemeResolver.a>> agzl;
  final Map<String, r<FileSystem, FileSystem.b>> agzm;
  final Map<String, r<FileSystem, FileSystem.b>> agzn;
  final SortedMap<h, String> agzo;
  final Map<String, Object> agzp;
  r<FileSystem, FileSystem.b> agzq;
  
  static
  {
    AppMethodBeat.i(238326);
    agzr = new Comparator() {};
    AppMethodBeat.o(238326);
  }
  
  p()
  {
    AppMethodBeat.i(238277);
    this.agzl = new HashMap();
    this.agzm = new HashMap();
    this.agzn = new HashMap();
    this.agzo = new TreeMap(agzr);
    this.agzp = new HashMap();
    this.agzq = null;
    AppMethodBeat.o(238277);
  }
  
  p(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(238285);
    if (paramBoolean)
    {
      this.agzl = new HashMap(paramp.agzl.size());
      Iterator localIterator = paramp.agzl.entrySet().iterator();
      Map.Entry localEntry;
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        this.agzl.put(localEntry.getKey(), new r(((r)localEntry.getValue()).agzC));
      }
      this.agzm = new HashMap(paramp.agzm.size());
      localIterator = paramp.agzm.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        this.agzm.put(localEntry.getKey(), new r(((r)localEntry.getValue()).agzC));
      }
      this.agzn = new HashMap(paramp.agzn.size());
      localIterator = paramp.agzn.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        this.agzn.put(localEntry.getKey(), new r(((r)localEntry.getValue()).agzC));
      }
    }
    this.agzl = new HashMap(paramp.agzl);
    this.agzm = new HashMap(paramp.agzm);
    this.agzn = new HashMap(paramp.agzn);
    this.agzo = new TreeMap(paramp.agzo);
    this.agzp = new HashMap(paramp.agzp);
    this.agzq = paramp.agzq;
    AppMethodBeat.o(238285);
  }
  
  static <K, V> void a(Printer paramPrinter, Map<K, V> paramMap)
  {
    AppMethodBeat.i(238321);
    StringBuilder localStringBuilder = new StringBuilder(256);
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.setLength(0);
      localStringBuilder.append("  ").append(localEntry.getKey());
      Object localObject = localEntry.getValue();
      if (localObject == null) {
        localStringBuilder.append(" (deleted)\n");
      }
      for (;;)
      {
        paramPrinter.println(localStringBuilder.toString());
        break;
        if (localObject.getClass().isArray()) {
          localStringBuilder.append(Arrays.toString((Object[])localObject));
        } else {
          localStringBuilder.append(" => ").append(localEntry.getValue().toString());
        }
      }
    }
    AppMethodBeat.o(238321);
  }
  
  static p ce(Bundle paramBundle)
  {
    AppMethodBeat.i(238311);
    p localp = new p();
    Object localObject1 = paramBundle.getParcelableArrayList("sl");
    Object localObject2 = paramBundle.getBundle("sm");
    Object localObject3 = localp.agzl;
    Object localObject4;
    Object localObject5;
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject4 = ((Bundle)localObject2).keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        int i = ((Bundle)localObject2).getInt((String)localObject5);
        if ((i >= 0) && (i < ((ArrayList)localObject1).size())) {
          ((Map)localObject3).put(localObject5, new r((d)((ArrayList)localObject1).get(i)));
        }
      }
    }
    localObject1 = paramBundle.getBundle("fs");
    localObject2 = localp.agzm;
    if (localObject1 != null)
    {
      ((Bundle)localObject1).setClassLoader(paramBundle.getClassLoader());
      localObject3 = ((Bundle)localObject1).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        ((Map)localObject2).put(localObject4, new r((d)((Bundle)localObject1).getParcelable((String)localObject4)));
      }
    }
    localObject1 = paramBundle.getBundle("mfs");
    localObject2 = localp.agzn;
    if (localObject1 != null)
    {
      ((Bundle)localObject1).setClassLoader(paramBundle.getClassLoader());
      localObject3 = ((Bundle)localObject1).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        ((Map)localObject2).put(localObject4, new r((d)((Bundle)localObject1).getParcelable((String)localObject4)));
      }
    }
    localObject1 = paramBundle.getBundle("mp");
    localObject2 = localp.agzo;
    if (localObject1 != null)
    {
      ((Bundle)localObject1).setClassLoader(paramBundle.getClassLoader());
      localObject3 = ((Bundle)localObject1).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        ((SortedMap)localObject2).put(new h((String)localObject4), ((Bundle)localObject1).getString((String)localObject4));
      }
    }
    localObject1 = paramBundle.getBundle("env");
    localObject2 = localp.agzp;
    if (localObject1 != null)
    {
      localObject3 = ((Bundle)localObject1).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        localObject5 = ((Bundle)localObject1).getStringArray((String)localObject4);
        if ((localObject5 != null) && (localObject5.length != 0)) {
          if (localObject5.length == 1) {
            ((Map)localObject2).put(localObject4, localObject5[0]);
          } else {
            ((Map)localObject2).put(localObject4, localObject5);
          }
        }
      }
    }
    paramBundle = (FileSystem)paramBundle.getParcelable("root");
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = new r(paramBundle))
    {
      localp.agzq = paramBundle;
      AppMethodBeat.o(238311);
      return localp;
    }
  }
  
  static <K, V> void f(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    AppMethodBeat.i(238293);
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
    AppMethodBeat.o(238293);
  }
  
  private static <K, V extends r<B, S>, B extends d<S>, S> void g(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    AppMethodBeat.i(238300);
    paramMap2 = paramMap2.entrySet().iterator();
    while (paramMap2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap2.next();
      if (localEntry.getValue() == null) {
        paramMap1.remove(localEntry.getKey());
      } else {
        paramMap1.put(localEntry.getKey(), new r((r)localEntry.getValue()));
      }
    }
    AppMethodBeat.o(238300);
  }
  
  final p a(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(238333);
    if (paramBoolean)
    {
      g(this.agzl, paramp.agzl);
      g(this.agzm, paramp.agzm);
      g(this.agzn, paramp.agzn);
    }
    for (;;)
    {
      f(this.agzo, paramp.agzo);
      f(this.agzp, paramp.agzp);
      if (paramp.agzq != null) {
        this.agzq = paramp.agzq;
      }
      AppMethodBeat.o(238333);
      return this;
      f(this.agzl, paramp.agzl);
      f(this.agzm, paramp.agzm);
      f(this.agzn, paramp.agzn);
    }
  }
  
  final void a(Printer paramPrinter)
  {
    AppMethodBeat.i(238349);
    if (!this.agzl.isEmpty())
    {
      paramPrinter.println("[Scheme]");
      a(paramPrinter, this.agzl);
    }
    if (!this.agzm.isEmpty())
    {
      paramPrinter.println("[FileSystems]");
      a(paramPrinter, this.agzm);
    }
    if (!this.agzn.isEmpty())
    {
      paramPrinter.println("[Maintenance-only]");
      a(paramPrinter, this.agzn);
    }
    if (!this.agzo.isEmpty())
    {
      paramPrinter.println("[Mount points]");
      a(paramPrinter, this.agzo);
    }
    if (!this.agzp.isEmpty())
    {
      paramPrinter.println("[Environment]");
      a(paramPrinter, this.agzp);
    }
    if (this.agzq != null) {
      paramPrinter.println("[Root] " + this.agzq.toString());
    }
    AppMethodBeat.o(238349);
  }
  
  final Bundle writeToBundle()
  {
    AppMethodBeat.i(238342);
    Bundle localBundle1 = new Bundle();
    Object localObject3 = new HashMap();
    Object localObject4 = new ArrayList(this.agzl.size());
    Bundle localBundle2 = new Bundle();
    Iterator localIterator = this.agzl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      SchemeResolver localSchemeResolver = (SchemeResolver)((r)localEntry.getValue()).agzC;
      localObject2 = (Integer)((HashMap)localObject3).get(localSchemeResolver);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = Integer.valueOf(((ArrayList)localObject4).size());
        ((ArrayList)localObject4).add(localSchemeResolver);
        ((HashMap)localObject3).put(localSchemeResolver, localObject1);
      }
      localBundle2.putInt((String)localEntry.getKey(), ((Integer)localObject1).intValue());
    }
    localBundle1.putParcelableArrayList("sl", (ArrayList)localObject4);
    localBundle1.putBundle("sm", localBundle2);
    Object localObject1 = new Bundle();
    Object localObject2 = this.agzm.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putParcelable((String)((Map.Entry)localObject3).getKey(), (Parcelable)((r)((Map.Entry)localObject3).getValue()).agzC);
    }
    localBundle1.putBundle("fs", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.agzn.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putParcelable((String)((Map.Entry)localObject3).getKey(), (Parcelable)((r)((Map.Entry)localObject3).getValue()).agzC);
    }
    localBundle1.putBundle("mfs", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.agzo.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putString(((h)((Map.Entry)localObject3).getKey()).value, (String)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("mp", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.agzp.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject4 = ((Map.Entry)localObject3).getValue();
      if ((localObject4 instanceof String)) {
        ((Bundle)localObject1).putStringArray((String)((Map.Entry)localObject3).getKey(), new String[] { (String)localObject4 });
      } else if ((localObject4 instanceof String[])) {
        ((Bundle)localObject1).putStringArray((String)((Map.Entry)localObject3).getKey(), (String[])localObject4);
      }
    }
    localBundle1.putBundle("env", (Bundle)localObject1);
    if (this.agzq == null) {}
    for (localObject1 = null;; localObject1 = (FileSystem)this.agzq.agzC)
    {
      localBundle1.putParcelable("root", (Parcelable)localObject1);
      AppMethodBeat.o(238342);
      return localBundle1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.p
 * JD-Core Version:    0.7.0.1
 */