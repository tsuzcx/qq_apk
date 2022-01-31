package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class cd
{
  public Map<String, Object> a;
  
  public cd()
  {
    AppMethodBeat.i(147342);
    this.a = new HashMap();
    AppMethodBeat.o(147342);
  }
  
  public final byte[] a()
  {
    AppMethodBeat.i(147343);
    Object localObject = new JSONObject();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      try
      {
        ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (Exception localException) {}
    }
    localObject = ((JSONObject)localObject).toString().getBytes();
    AppMethodBeat.o(147343);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cd
 * JD-Core Version:    0.7.0.1
 */