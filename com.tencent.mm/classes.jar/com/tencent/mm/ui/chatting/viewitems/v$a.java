package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class v$a
  implements Comparable<a>
{
  public boolean bZQ;
  public int color;
  public int guC;
  public int offset;
  public boolean vEv;
  public String vEw;
  
  public static a w(Map<String, String> paramMap, String paramString)
  {
    a locala = new a();
    for (;;)
    {
      try
      {
        locala.offset = bk.getInt((String)paramMap.get(paramString + ".offset"), 0);
        str = (String)paramMap.get(paramString + ".font");
        if (bk.bl(str))
        {
          y.d("MicroMsg.LineNode", "parseFrom, font is null, use default value");
          str = "m";
          locala.bZQ = v.co(str);
          locala.vEv = v.qU(str);
          locala.guC = v.adL(str);
          locala.color = v.adM((String)paramMap.get(paramString + ".color"));
          locala.vEw = ((String)paramMap.get(paramString + ".chars"));
          if (!bk.bl(locala.vEw)) {
            break;
          }
          y.e("MicroMsg.LineNode", "parseFrom fail, chars is null");
          return null;
        }
      }
      catch (Exception paramMap)
      {
        y.e("MicroMsg.LineNode", "parseFrom fail, ex = " + paramMap.getMessage());
        return null;
      }
      String str = str.toLowerCase();
    }
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.a
 * JD-Core Version:    0.7.0.1
 */