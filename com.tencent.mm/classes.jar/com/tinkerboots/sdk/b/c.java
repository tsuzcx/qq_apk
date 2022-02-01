package com.tinkerboots.sdk.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static Context context;
  
  public static Context getContext()
  {
    AppMethodBeat.i(3462);
    if (context == null)
    {
      localObject = new RuntimeException("TinkerClientContext, context is null, please init first");
      AppMethodBeat.o(3462);
      throw ((Throwable)localObject);
    }
    Object localObject = context;
    AppMethodBeat.o(3462);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tinkerboots.sdk.b.c
 * JD-Core Version:    0.7.0.1
 */