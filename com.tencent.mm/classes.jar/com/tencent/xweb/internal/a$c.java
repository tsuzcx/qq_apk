package com.tencent.xweb.internal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class a$c
  extends a.b
{
  static String SDr = null;
  
  public static void bsv(String paramString)
  {
    SDr = paramString;
  }
  
  public static boolean htz()
  {
    AppMethodBeat.i(219067);
    if (!XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(SDr))
    {
      AppMethodBeat.o(219067);
      return true;
    }
    AppMethodBeat.o(219067);
    return false;
  }
  
  public final String htv()
  {
    AppMethodBeat.i(156957);
    if (!TextUtils.isEmpty(SDr))
    {
      str = SDr;
      AppMethodBeat.o(156957);
      return str;
    }
    String str = super.htv();
    AppMethodBeat.o(156957);
    return str;
  }
  
  protected final boolean htx()
  {
    AppMethodBeat.i(156956);
    boolean bool = XWalkEnvironment.is64BitRuntime();
    AppMethodBeat.o(156956);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.internal.a.c
 * JD-Core Version:    0.7.0.1
 */