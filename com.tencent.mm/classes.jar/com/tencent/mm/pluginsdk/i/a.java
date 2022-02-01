package com.tencent.mm.pluginsdk.i;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static void b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(151887);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new b();
      b.b(paramCharSequence1, paramCharSequence2);
      AppMethodBeat.o(151887);
      return;
    }
    new c();
    c.Q(paramCharSequence2);
    AppMethodBeat.o(151887);
  }
  
  public static CharSequence fee()
  {
    AppMethodBeat.i(151888);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new b();
      localCharSequence = b.fee();
      AppMethodBeat.o(151888);
      return localCharSequence;
    }
    new c();
    CharSequence localCharSequence = c.fee();
    AppMethodBeat.o(151888);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.a
 * JD-Core Version:    0.7.0.1
 */