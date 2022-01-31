package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.ContentValues;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class fn
  implements Serializable
{
  protected final ConcurrentHashMap<String, String> a;
  protected final ConcurrentHashMap<String, Object> b;
  
  public fn()
  {
    this(null);
  }
  
  public fn(Map<String, String> paramMap)
  {
    AppMethodBeat.i(147946);
    this.a = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        a((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    AppMethodBeat.o(147946);
  }
  
  private List<ContentValues> b(String paramString, Object paramObject)
  {
    AppMethodBeat.i(147951);
    LinkedList localLinkedList = new LinkedList();
    if ((paramObject instanceof Map))
    {
      localObject1 = (Map)paramObject;
      paramObject = new ArrayList(((Map)localObject1).keySet());
      if ((paramObject.size() > 0) && ((paramObject.get(0) instanceof Comparable))) {
        Collections.sort(paramObject);
      }
      Iterator localIterator = paramObject.iterator();
      Object localObject2;
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramObject = localIterator.next();
        } while (!(paramObject instanceof String));
        localObject2 = ((Map)localObject1).get(paramObject);
      } while (localObject2 == null);
      if (paramString == null) {}
      for (paramObject = (String)paramObject;; paramObject = String.format("%s[%s]", new Object[] { paramString, paramObject }))
      {
        localLinkedList.addAll(b(paramObject, localObject2));
        break;
      }
    }
    int j;
    int i;
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      j = paramObject.size();
      i = 0;
      while (i < j)
      {
        localLinkedList.addAll(b(String.format("%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), paramObject.get(i)));
        i += 1;
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localLinkedList.addAll(b(String.format("%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), paramObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof Set))
    {
      paramObject = ((Set)paramObject).iterator();
      while (paramObject.hasNext()) {
        localLinkedList.addAll(b(paramString, paramObject.next()));
      }
    }
    Object localObject1 = new ContentValues();
    ((ContentValues)localObject1).put(paramString, paramObject.toString());
    localLinkedList.add(localObject1);
    AppMethodBeat.o(147951);
    return localLinkedList;
  }
  
  protected String a()
  {
    AppMethodBeat.i(147952);
    String str = Uri.encode(toString(), "=&");
    AppMethodBeat.o(147952);
    return str;
  }
  
  public void a(String paramString, Object paramObject)
  {
    AppMethodBeat.i(147948);
    if ((paramString != null) && (paramObject != null)) {
      this.b.put(paramString, paramObject);
    }
    AppMethodBeat.o(147948);
  }
  
  public void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147947);
    if ((paramString1 != null) && (paramString2 != null)) {
      this.a.put(paramString1, paramString2);
    }
    AppMethodBeat.o(147947);
  }
  
  public void b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147949);
    if ((paramString1 != null) && (paramString2 != null))
    {
      Object localObject2 = this.b.get(paramString1);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        a(paramString1, localObject1);
      }
      if ((localObject1 instanceof List))
      {
        ((List)localObject1).add(paramString2);
        AppMethodBeat.o(147949);
        return;
      }
      if ((localObject1 instanceof Set)) {
        ((Set)localObject1).add(paramString2);
      }
    }
    AppMethodBeat.o(147949);
  }
  
  public String toString()
  {
    AppMethodBeat.i(147950);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (Map.Entry)localIterator.next();
      if (((StringBuilder)localObject1).length() > 0) {
        ((StringBuilder)localObject1).append("&");
      }
      ((StringBuilder)localObject1).append((String)((Map.Entry)localObject2).getKey());
      ((StringBuilder)localObject1).append("=");
      ((StringBuilder)localObject1).append((String)((Map.Entry)localObject2).getValue());
    }
    localIterator = b(null, this.b).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (ContentValues)localIterator.next();
      if (((StringBuilder)localObject1).length() > 0) {
        ((StringBuilder)localObject1).append("&");
      }
      localObject2 = ((ContentValues)localObject2).valueSet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append((String)localEntry.getKey());
        ((StringBuilder)localObject1).append("=");
        ((StringBuilder)localObject1).append(localEntry.getValue().toString());
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(147950);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fn
 * JD-Core Version:    0.7.0.1
 */