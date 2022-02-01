package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
  implements Map<String, Object>
{
  private final Map<String, Object> JHd;
  
  public d()
  {
    AppMethodBeat.i(210112);
    this.JHd = new ArrayMap();
    AppMethodBeat.o(210112);
  }
  
  public d(String paramString, Object paramObject)
  {
    AppMethodBeat.i(210115);
    this.JHd = new ArrayMap();
    this.JHd.put(paramString, paramObject);
    AppMethodBeat.o(210115);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(210137);
    this.JHd.clear();
    AppMethodBeat.o(210137);
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(210122);
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if (paramObject != null)
      {
        boolean bool = this.JHd.containsKey(paramObject);
        AppMethodBeat.o(210122);
        return bool;
      }
      AppMethodBeat.o(210122);
      return false;
    }
    AppMethodBeat.o(210122);
    return false;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(210125);
    boolean bool = this.JHd.containsValue(paramObject);
    AppMethodBeat.o(210125);
    return bool;
  }
  
  public final Set<Map.Entry<String, Object>> entrySet()
  {
    AppMethodBeat.i(210148);
    Set localSet = this.JHd.entrySet();
    AppMethodBeat.o(210148);
    return localSet;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(210126);
    if ((paramObject instanceof String))
    {
      paramObject = this.JHd.get(paramObject);
      AppMethodBeat.o(210126);
      return paramObject;
    }
    AppMethodBeat.o(210126);
    return null;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(210121);
    boolean bool = this.JHd.isEmpty();
    AppMethodBeat.o(210121);
    return bool;
  }
  
  public final Set<String> keySet()
  {
    AppMethodBeat.i(210141);
    Set localSet = this.JHd.keySet();
    AppMethodBeat.o(210141);
    return localSet;
  }
  
  public final Object put(String paramString, Object paramObject)
  {
    AppMethodBeat.i(210131);
    if ((paramString == null) || (paramObject == null))
    {
      AppMethodBeat.o(210131);
      return null;
    }
    paramString = this.JHd.put(paramString, paramObject);
    AppMethodBeat.o(210131);
    return paramString;
  }
  
  public final void putAll(Map<? extends String, ?> paramMap)
  {
    AppMethodBeat.i(210135);
    if (com.tencent.mm.plugin.sns.ad.i.d.aC(paramMap)) {
      this.JHd.putAll(paramMap);
    }
    AppMethodBeat.o(210135);
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(210132);
    if ((paramObject instanceof String)) {
      this.JHd.remove(paramObject);
    }
    AppMethodBeat.o(210132);
    return null;
  }
  
  public final int size()
  {
    AppMethodBeat.i(210118);
    int i = this.JHd.size();
    AppMethodBeat.o(210118);
    return i;
  }
  
  public final Collection<Object> values()
  {
    AppMethodBeat.i(210144);
    Collection localCollection = this.JHd.values();
    AppMethodBeat.o(210144);
    return localCollection;
  }
  
  public final <T> T y(String paramString, T paramT)
  {
    AppMethodBeat.i(210130);
    try
    {
      paramString = this.JHd.get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(210130);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(210130);
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d
 * JD-Core Version:    0.7.0.1
 */