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
  private final Map<String, Object> PYd;
  
  public d()
  {
    AppMethodBeat.i(311341);
    this.PYd = new ArrayMap();
    AppMethodBeat.o(311341);
  }
  
  public d(String paramString, Object paramObject)
  {
    AppMethodBeat.i(311350);
    this.PYd = new ArrayMap();
    this.PYd.put(paramString, paramObject);
    AppMethodBeat.o(311350);
  }
  
  public final <T> T K(String paramString, T paramT)
  {
    AppMethodBeat.i(311385);
    try
    {
      paramString = this.PYd.get(paramString);
      if (paramString != null) {
        return paramString;
      }
    }
    finally
    {
      AppMethodBeat.o(311385);
    }
    return paramT;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(311403);
    this.PYd.clear();
    AppMethodBeat.o(311403);
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(311367);
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if (paramObject != null)
      {
        boolean bool = this.PYd.containsKey(paramObject);
        AppMethodBeat.o(311367);
        return bool;
      }
      AppMethodBeat.o(311367);
      return false;
    }
    AppMethodBeat.o(311367);
    return false;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(311375);
    boolean bool = this.PYd.containsValue(paramObject);
    AppMethodBeat.o(311375);
    return bool;
  }
  
  public final Set<Map.Entry<String, Object>> entrySet()
  {
    AppMethodBeat.i(311412);
    Set localSet = this.PYd.entrySet();
    AppMethodBeat.o(311412);
    return localSet;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(311382);
    if ((paramObject instanceof String))
    {
      paramObject = this.PYd.get(paramObject);
      AppMethodBeat.o(311382);
      return paramObject;
    }
    AppMethodBeat.o(311382);
    return null;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(311358);
    boolean bool = this.PYd.isEmpty();
    AppMethodBeat.o(311358);
    return bool;
  }
  
  public final Set<String> keySet()
  {
    AppMethodBeat.i(311406);
    Set localSet = this.PYd.keySet();
    AppMethodBeat.o(311406);
    return localSet;
  }
  
  public final Object put(String paramString, Object paramObject)
  {
    AppMethodBeat.i(311389);
    if ((paramString == null) || (paramObject == null))
    {
      AppMethodBeat.o(311389);
      return null;
    }
    paramString = this.PYd.put(paramString, paramObject);
    AppMethodBeat.o(311389);
    return paramString;
  }
  
  public final void putAll(Map<? extends String, ?> paramMap)
  {
    AppMethodBeat.i(311401);
    if (com.tencent.mm.plugin.sns.ad.j.d.aT(paramMap)) {
      this.PYd.putAll(paramMap);
    }
    AppMethodBeat.o(311401);
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(311394);
    if ((paramObject instanceof String)) {
      this.PYd.remove(paramObject);
    }
    AppMethodBeat.o(311394);
    return null;
  }
  
  public final int size()
  {
    AppMethodBeat.i(311354);
    int i = this.PYd.size();
    AppMethodBeat.o(311354);
    return i;
  }
  
  public final Collection<Object> values()
  {
    AppMethodBeat.i(311408);
    Collection localCollection = this.PYd.values();
    AppMethodBeat.o(311408);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d
 * JD-Core Version:    0.7.0.1
 */