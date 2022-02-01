package com.tencent.xweb.internal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class a$c
  extends a.b
{
  static String MQr = null;
  
  public static void bcL(String paramString)
  {
    MQr = paramString;
  }
  
  public static boolean ggh()
  {
    AppMethodBeat.i(217413);
    if (!XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(MQr))
    {
      AppMethodBeat.o(217413);
      return true;
    }
    AppMethodBeat.o(217413);
    return false;
  }
  
  public final String ggd()
  {
    AppMethodBeat.i(156957);
    if (!TextUtils.isEmpty(MQr))
    {
      str = MQr;
      AppMethodBeat.o(156957);
      return str;
    }
    String str = super.ggd();
    AppMethodBeat.o(156957);
    return str;
  }
  
  protected final boolean ggf()
  {
    AppMethodBeat.i(156956);
    boolean bool = XWalkEnvironment.is64BitRuntime();
    AppMethodBeat.o(156956);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.a.c
 * JD-Core Version:    0.7.0.1
 */