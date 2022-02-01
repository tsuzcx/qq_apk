package com.tencent.xweb.internal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class a$c
  extends a.b
{
  static String IQt = null;
  
  public static void aPm(String paramString)
  {
    IQt = paramString;
  }
  
  public final String frF()
  {
    AppMethodBeat.i(156957);
    if (!TextUtils.isEmpty(IQt))
    {
      str = IQt;
      AppMethodBeat.o(156957);
      return str;
    }
    String str = super.frF();
    AppMethodBeat.o(156957);
    return str;
  }
  
  protected final boolean frH()
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