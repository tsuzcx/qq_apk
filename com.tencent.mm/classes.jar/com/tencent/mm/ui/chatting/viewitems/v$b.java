package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class v$b
{
  public boolean bZQ;
  public int color;
  public int guC;
  public boolean vEv;
  public int vEx;
  public int vEy;
  
  public static b x(Map<String, String> paramMap, String paramString)
  {
    Object localObject = (String)paramMap.get(paramString + ".range");
    if (bk.bl((String)localObject))
    {
      y.e("MicroMsg.StyleNode", "parseFrom fail, range is null");
      return null;
    }
    if ((((String)localObject).length() < 5) || (((String)localObject).charAt(0) != '{') || (((String)localObject).charAt(((String)localObject).length() - 1) != '}') || (!((String)localObject).contains(",")))
    {
      y.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, range = " + (String)localObject);
      return null;
    }
    y.d("MicroMsg.StyleNode", "parseFrom, range = " + (String)localObject);
    localObject = ((String)localObject).substring(1, ((String)localObject).length() - 1).split(",");
    if ((localObject == null) || (localObject.length != 2))
    {
      y.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, strs array length = " + localObject.length);
      return null;
    }
    b localb = new b();
    for (;;)
    {
      try
      {
        localb.vEx = bk.getInt(localObject[0], 0);
        int i = localb.vEx;
        localb.vEy = (bk.getInt(localObject[1], 0) + i);
        localObject = (String)paramMap.get(paramString + ".font");
        if (bk.bl((String)localObject))
        {
          y.d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
          localObject = "m";
          localb.bZQ = v.co((String)localObject);
          localb.vEv = v.qU((String)localObject);
          localb.guC = v.adL((String)localObject);
          localb.color = v.adM((String)paramMap.get(paramString + ".color"));
          return localb;
        }
      }
      catch (Exception paramMap)
      {
        y.e("MicroMsg.StyleNode", "parseFrom fail, ex = " + paramMap.getMessage());
        return null;
      }
      localObject = ((String)localObject).toLowerCase();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.b
 * JD-Core Version:    0.7.0.1
 */