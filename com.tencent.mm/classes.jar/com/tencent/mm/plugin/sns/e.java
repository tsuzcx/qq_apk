package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.r;

public class e
  implements r
{
  private static volatile e PKc = null;
  
  public static e gZq()
  {
    AppMethodBeat.i(94916);
    if (PKc == null) {}
    try
    {
      if (PKc == null) {
        PKc = new e();
      }
      e locale = PKc;
      AppMethodBeat.o(94916);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(94916);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e
 * JD-Core Version:    0.7.0.1
 */