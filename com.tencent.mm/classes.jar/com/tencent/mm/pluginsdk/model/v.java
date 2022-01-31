package com.tencent.mm.pluginsdk.model;

import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;
import java.util.Map;

public final class v
{
  private static final Map<String, Object> rTU = new HashMap();
  
  public static void o(String paramString, Object paramObject)
  {
    rTU.put(paramString, paramObject);
    d.initTbsSettings(rTU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.v
 * JD-Core Version:    0.7.0.1
 */