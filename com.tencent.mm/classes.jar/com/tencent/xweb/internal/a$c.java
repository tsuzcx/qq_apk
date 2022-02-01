package com.tencent.xweb.internal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class a$c
  extends a.b
{
  static String Mtn = null;
  
  public static void bbi(String paramString)
  {
    Mtn = paramString;
  }
  
  public static boolean gbF()
  {
    AppMethodBeat.i(197095);
    if (!XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(Mtn))
    {
      AppMethodBeat.o(197095);
      return true;
    }
    AppMethodBeat.o(197095);
    return false;
  }
  
  public final String gbB()
  {
    AppMethodBeat.i(156957);
    if (!TextUtils.isEmpty(Mtn))
    {
      str = Mtn;
      AppMethodBeat.o(156957);
      return str;
    }
    String str = super.gbB();
    AppMethodBeat.o(156957);
    return str;
  }
  
  protected final boolean gbD()
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