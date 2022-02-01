package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
  implements Map<String, Object>
{
  private final Map<String, Object> Dxw;
  
  public d()
  {
    AppMethodBeat.i(202070);
    this.Dxw = new ArrayMap();
    AppMethodBeat.o(202070);
  }
  
  public d(String paramString, Object paramObject)
  {
    AppMethodBeat.i(202071);
    this.Dxw = new ArrayMap();
    this.Dxw.put(paramString, paramObject);
    AppMethodBeat.o(202071);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202081);
    this.Dxw.clear();
    AppMethodBeat.o(202081);
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(202074);
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if (paramObject != null)
      {
        boolean bool = this.Dxw.containsKey(paramObject);
        AppMethodBeat.o(202074);
        return bool;
      }
      AppMethodBeat.o(202074);
      return false;
    }
    AppMethodBeat.o(202074);
    return false;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(202075);
    boolean bool = this.Dxw.containsValue(paramObject);
    AppMethodBeat.o(202075);
    return bool;
  }
  
  public final Set<Map.Entry<String, Object>> entrySet()
  {
    AppMethodBeat.i(202084);
    Set localSet = this.Dxw.entrySet();
    AppMethodBeat.o(202084);
    return localSet;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(202076);
    if ((paramObject instanceof String))
    {
      paramObject = this.Dxw.get(paramObject);
      AppMethodBeat.o(202076);
      return paramObject;
    }
    AppMethodBeat.o(202076);
    return null;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(202073);
    boolean bool = this.Dxw.isEmpty();
    AppMethodBeat.o(202073);
    return bool;
  }
  
  public final Set<String> keySet()
  {
    AppMethodBeat.i(202082);
    Set localSet = this.Dxw.keySet();
    AppMethodBeat.o(202082);
    return localSet;
  }
  
  public final Object put(String paramString, Object paramObject)
  {
    AppMethodBeat.i(202078);
    if ((paramString == null) || (paramObject == null))
    {
      AppMethodBeat.o(202078);
      return null;
    }
    paramString = this.Dxw.put(paramString, paramObject);
    AppMethodBeat.o(202078);
    return paramString;
  }
  
  public final void putAll(Map<? extends String, ?> paramMap)
  {
    AppMethodBeat.i(202080);
    if (c.aI(paramMap)) {
      this.Dxw.putAll(paramMap);
    }
    AppMethodBeat.o(202080);
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(202079);
    if ((paramObject instanceof String)) {
      this.Dxw.remove(paramObject);
    }
    AppMethodBeat.o(202079);
    return null;
  }
  
  public final int size()
  {
    AppMethodBeat.i(202072);
    int i = this.Dxw.size();
    AppMethodBeat.o(202072);
    return i;
  }
  
  public final Collection<Object> values()
  {
    AppMethodBeat.i(202083);
    Collection localCollection = this.Dxw.values();
    AppMethodBeat.o(202083);
    return localCollection;
  }
  
  public final <T> T z(String paramString, T paramT)
  {
    AppMethodBeat.i(202077);
    try
    {
      paramString = this.Dxw.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(202077);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(202077);
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d
 * JD-Core Version:    0.7.0.1
 */