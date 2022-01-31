package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class y$a
  implements Comparable<a>
{
  public boolean cIi;
  public int color;
  public int hPx;
  public int offset;
  public boolean zVG;
  public String zVH;
  
  public static a x(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(33178);
    a locala = new a();
    for (;;)
    {
      try
      {
        locala.offset = bo.getInt((String)paramMap.get(paramString + ".offset"), 0);
        str = (String)paramMap.get(paramString + ".font");
        if (bo.isNullOrNil(str))
        {
          ab.d("MicroMsg.LineNode", "parseFrom, font is null, use default value");
          str = "m";
          locala.cIi = y.dA(str);
          locala.zVG = y.yq(str);
          locala.hPx = y.aus(str);
          locala.color = y.aut((String)paramMap.get(paramString + ".color"));
          locala.zVH = ((String)paramMap.get(paramString + ".chars"));
          if (!bo.isNullOrNil(locala.zVH)) {
            break;
          }
          ab.e("MicroMsg.LineNode", "parseFrom fail, chars is null");
          AppMethodBeat.o(33178);
          return null;
        }
      }
      catch (Exception paramMap)
      {
        ab.e("MicroMsg.LineNode", "parseFrom fail, ex = " + paramMap.getMessage());
        AppMethodBeat.o(33178);
        return null;
      }
      String str = str.toLowerCase();
    }
    AppMethodBeat.o(33178);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.a
 * JD-Core Version:    0.7.0.1
 */