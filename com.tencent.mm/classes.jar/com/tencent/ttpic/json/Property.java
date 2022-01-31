package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

public class Property
{
  public static JSONObject toJSONObject(Properties paramProperties)
  {
    AppMethodBeat.i(50213);
    JSONObject localJSONObject = new JSONObject();
    if ((paramProperties != null) && (!paramProperties.isEmpty()))
    {
      Enumeration localEnumeration = paramProperties.propertyNames();
      while (localEnumeration.hasMoreElements())
      {
        String str = (String)localEnumeration.nextElement();
        localJSONObject.put(str, paramProperties.getProperty(str));
      }
    }
    AppMethodBeat.o(50213);
    return localJSONObject;
  }
  
  public static Properties toProperties(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50214);
    Properties localProperties = new Properties();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        localProperties.put(str, paramJSONObject.getString(str));
      }
    }
    AppMethodBeat.o(50214);
    return localProperties;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.json.Property
 * JD-Core Version:    0.7.0.1
 */