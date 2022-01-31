package com.tencent.xweb.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import org.xwalk.core.XWalkEnvironment;

public final class d
{
  public static boolean bj(String paramString, long paramLong)
  {
    AppMethodBeat.i(151441);
    if ("true".equals(a.axN("dis_".concat(String.valueOf(paramString)))))
    {
      AppMethodBeat.o(151441);
      return false;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("FREQUENT_LIMITER");
    long l1 = localSharedPreferences.getLong(paramString, 0L);
    long l2 = System.currentTimeMillis();
    if (Math.abs(l2 - l1) < paramLong)
    {
      AppMethodBeat.o(151441);
      return false;
    }
    localSharedPreferences.edit().putLong(paramString, l2).commit();
    AppMethodBeat.o(151441);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.c.d
 * JD-Core Version:    0.7.0.1
 */