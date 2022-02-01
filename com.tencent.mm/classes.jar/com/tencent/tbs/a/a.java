package com.tencent.tbs.a;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class a
{
  private static final DateFormat ahzC;
  
  static
  {
    AppMethodBeat.i(174261);
    ahzC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
    AppMethodBeat.o(174261);
  }
  
  public static String d(b paramb)
  {
    AppMethodBeat.i(174260);
    if (paramb == null)
    {
      AppMethodBeat.o(174260);
      return "";
    }
    paramb = ahzC.format(new Date(paramb.a)) + " " + Process.myPid() + "-" + Process.myTid() + " " + c.a(paramb.ahzD) + "/" + paramb.c + ": " + paramb.d + "\n";
    AppMethodBeat.o(174260);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.a.a
 * JD-Core Version:    0.7.0.1
 */