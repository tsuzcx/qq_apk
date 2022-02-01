package com.tencent.mm.ui.matrix.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  private static Pattern KCi;
  
  static
  {
    AppMethodBeat.i(38932);
    KCi = Pattern.compile("^((https|http|ftp|rtsp|mms)?://)?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$");
    AppMethodBeat.o(38932);
  }
  
  public static boolean aXf(String paramString)
  {
    AppMethodBeat.i(38930);
    boolean bool = KCi.matcher(paramString).matches();
    AppMethodBeat.o(38930);
    return bool;
  }
  
  public static String aeP(int paramInt)
  {
    AppMethodBeat.i(38931);
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      ((StringBuilder)localObject).append("      ");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(38931);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.c
 * JD-Core Version:    0.7.0.1
 */