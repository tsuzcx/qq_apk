package com.tencent.threadpool.c;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends a
{
  public static Thread b(String paramString, Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(183244);
    paramString = new a.2(new a.1(paramRunnable), "[GT]".concat(String.valueOf(paramString)));
    paramString.setPriority(a.abd(paramInt));
    AppMethodBeat.o(183244);
    return paramString;
  }
  
  public static HandlerThread bFS(String paramString)
  {
    AppMethodBeat.i(183241);
    paramString = ju(paramString, 5);
    AppMethodBeat.o(183241);
    return paramString;
  }
  
  public static HandlerThread bFT(String paramString)
  {
    AppMethodBeat.i(183243);
    paramString = ju(paramString, 5);
    AppMethodBeat.o(183243);
    return paramString;
  }
  
  public static HandlerThread jv(String paramString, int paramInt)
  {
    AppMethodBeat.i(183237);
    paramString = ju(paramString, paramInt);
    AppMethodBeat.o(183237);
    return paramString;
  }
  
  public static HandlerThread jw(String paramString, int paramInt)
  {
    AppMethodBeat.i(183238);
    paramString = ju(paramString, paramInt);
    AppMethodBeat.o(183238);
    return paramString;
  }
  
  public static HandlerThread jx(String paramString, int paramInt)
  {
    AppMethodBeat.i(183239);
    paramString = ju(paramString, paramInt);
    AppMethodBeat.o(183239);
    return paramString;
  }
  
  public static HandlerThread jy(String paramString, int paramInt)
  {
    AppMethodBeat.i(183240);
    paramString = ju(paramString, paramInt);
    AppMethodBeat.o(183240);
    return paramString;
  }
  
  public static HandlerThread jz(String paramString, int paramInt)
  {
    AppMethodBeat.i(226868);
    paramString = ju(paramString, paramInt);
    AppMethodBeat.o(226868);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.c.d
 * JD-Core Version:    0.7.0.1
 */