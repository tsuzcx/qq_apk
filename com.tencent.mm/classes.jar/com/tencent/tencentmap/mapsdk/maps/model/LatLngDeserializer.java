package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.tools.json.JsonParser.Deserializer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

public class LatLngDeserializer
  implements JsonParser.Deserializer<LatLng>
{
  public LatLng deserialize(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(217961);
    if (paramObject2 == null)
    {
      AppMethodBeat.o(217961);
      return null;
    }
    if ((paramObject2 instanceof JSONObject))
    {
      paramObject1 = (JSONObject)paramObject2;
      paramObject1 = new LatLng(paramObject1.optDouble("lat"), paramObject1.optDouble("lng"));
      AppMethodBeat.o(217961);
      return paramObject1;
    }
    if ((paramObject2 instanceof JSONArray))
    {
      paramObject1 = (JSONArray)paramObject2;
      if (paramObject1.length() < 2)
      {
        AppMethodBeat.o(217961);
        return null;
      }
      if (paramObject1.length() > 2)
      {
        paramObject1 = new LatLng(paramObject1.getDouble(0), paramObject1.getDouble(1), paramObject1.getDouble(2));
        AppMethodBeat.o(217961);
        return paramObject1;
      }
      paramObject1 = new LatLng(paramObject1.getDouble(0), paramObject1.getDouble(1));
      AppMethodBeat.o(217961);
      return paramObject1;
    }
    if (((paramObject2 instanceof JSONStringer)) || ((paramObject2 instanceof String)))
    {
      paramObject1 = paramObject2.toString().split(",");
      if (paramObject1.length < 2)
      {
        AppMethodBeat.o(217961);
        return null;
      }
      if (paramObject1.length > 2)
      {
        paramObject1 = new LatLng(Double.parseDouble(paramObject1[0]), Double.parseDouble(paramObject1[1]), Double.parseDouble(paramObject1[2]));
        AppMethodBeat.o(217961);
        return paramObject1;
      }
      paramObject1 = new LatLng(Double.parseDouble(paramObject1[0]), Double.parseDouble(paramObject1[1]));
      AppMethodBeat.o(217961);
      return paramObject1;
    }
    AppMethodBeat.o(217961);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.LatLngDeserializer
 * JD-Core Version:    0.7.0.1
 */