package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class y$b
{
  public boolean cIi;
  public int color;
  public int hPx;
  public boolean zVG;
  public int zVI;
  public int zVJ;
  
  public static b y(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(33180);
    Object localObject = (String)paramMap.get(paramString + ".range");
    if (bo.isNullOrNil((String)localObject))
    {
      ab.e("MicroMsg.StyleNode", "parseFrom fail, range is null");
      AppMethodBeat.o(33180);
      return null;
    }
    if ((((String)localObject).length() < 5) || (((String)localObject).charAt(0) != '{') || (((String)localObject).charAt(((String)localObject).length() - 1) != '}') || (!((String)localObject).contains(",")))
    {
      ab.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, range = ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(33180);
      return null;
    }
    ab.d("MicroMsg.StyleNode", "parseFrom, range = ".concat(String.valueOf(localObject)));
    localObject = ((String)localObject).substring(1, ((String)localObject).length() - 1).split(",");
    if ((localObject == null) || (localObject.length != 2))
    {
      ab.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, strs array length = " + localObject.length);
      AppMethodBeat.o(33180);
      return null;
    }
    b localb = new b();
    for (;;)
    {
      try
      {
        localb.zVI = bo.getInt(localObject[0], 0);
        int i = localb.zVI;
        localb.zVJ = (bo.getInt(localObject[1], 0) + i);
        localObject = (String)paramMap.get(paramString + ".font");
        if (bo.isNullOrNil((String)localObject))
        {
          ab.d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
          localObject = "m";
          localb.cIi = y.dA((String)localObject);
          localb.zVG = y.yq((String)localObject);
          localb.hPx = y.aus((String)localObject);
          localb.color = y.aut((String)paramMap.get(paramString + ".color"));
          AppMethodBeat.o(33180);
          return localb;
        }
      }
      catch (Exception paramMap)
      {
        ab.e("MicroMsg.StyleNode", "parseFrom fail, ex = " + paramMap.getMessage());
        AppMethodBeat.o(33180);
        return null;
      }
      localObject = ((String)localObject).toLowerCase();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.b
 * JD-Core Version:    0.7.0.1
 */