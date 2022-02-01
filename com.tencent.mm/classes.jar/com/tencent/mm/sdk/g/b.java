package com.tencent.mm.sdk.g;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class b
{
  public static final b IhT;
  
  static
  {
    AppMethodBeat.i(158155);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      IhT = new b();
      AppMethodBeat.o(158155);
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(158135);
    AppMethodBeat.o(158135);
  }
  
  @Deprecated
  private void b(final Runnable paramRunnable, final String paramString)
  {
    AppMethodBeat.i(158142);
    if ((!$assertionsDisabled) && (paramRunnable == null))
    {
      paramRunnable = new AssertionError();
      AppMethodBeat.o(158142);
      throw paramRunnable;
    }
    com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return paramString;
      }
      
      public final void run()
      {
        AppMethodBeat.i(158103);
        paramRunnable.run();
        AppMethodBeat.o(158103);
      }
    });
    AppMethodBeat.o(158142);
  }
  
  @Deprecated
  public static void c(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(158143);
    IhT.b(paramRunnable, paramString);
    AppMethodBeat.o(158143);
  }
  
  @Deprecated
  public static void d(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(158144);
    IhT.b(paramRunnable, paramString);
    AppMethodBeat.o(158144);
  }
  
  @Deprecated
  public static void e(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(158145);
    IhT.b(paramRunnable, paramString);
    AppMethodBeat.o(158145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.b
 * JD-Core Version:    0.7.0.1
 */