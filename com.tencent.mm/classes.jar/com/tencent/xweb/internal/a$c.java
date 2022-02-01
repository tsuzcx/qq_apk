package com.tencent.xweb.internal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class a$c
  extends a.b
{
  static String KCO = null;
  
  public static void aVf(String paramString)
  {
    KCO = paramString;
  }
  
  public final String fKh()
  {
    AppMethodBeat.i(156957);
    if (!TextUtils.isEmpty(KCO))
    {
      str = KCO;
      AppMethodBeat.o(156957);
      return str;
    }
    String str = super.fKh();
    AppMethodBeat.o(156957);
    return str;
  }
  
  protected final boolean fKj()
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