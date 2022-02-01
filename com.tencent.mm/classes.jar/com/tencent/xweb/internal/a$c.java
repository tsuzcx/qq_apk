package com.tencent.xweb.internal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class a$c
  extends a.b
{
  static String aaeB = null;
  
  public static void bFu(String paramString)
  {
    aaeB = paramString;
  }
  
  public static boolean ixi()
  {
    AppMethodBeat.i(196401);
    if (!XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(aaeB))
    {
      AppMethodBeat.o(196401);
      return true;
    }
    AppMethodBeat.o(196401);
    return false;
  }
  
  public final String ixe()
  {
    AppMethodBeat.i(156957);
    if (!TextUtils.isEmpty(aaeB))
    {
      str = aaeB;
      AppMethodBeat.o(156957);
      return str;
    }
    String str = super.ixe();
    AppMethodBeat.o(156957);
    return str;
  }
  
  protected final boolean ixg()
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