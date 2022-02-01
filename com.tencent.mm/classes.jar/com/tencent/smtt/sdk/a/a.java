package com.tencent.smtt.sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class a
{
  public static String a(long paramLong)
  {
    AppMethodBeat.i(194231);
    String str = String.format(Locale.getDefault(), "%d(%s)", new Object[] { Long.valueOf(paramLong), new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(paramLong)) });
    AppMethodBeat.o(194231);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */