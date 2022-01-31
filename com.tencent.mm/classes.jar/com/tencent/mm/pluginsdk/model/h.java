package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static void a(Context paramContext, String[] paramArrayOfString, h.a parama)
  {
    AppMethodBeat.i(79213);
    if ((parama == null) || (paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramContext = new IllegalArgumentException();
      AppMethodBeat.o(79213);
      throw paramContext;
    }
    new h.1(paramContext, paramArrayOfString, parama).execute(new Void[0]);
    AppMethodBeat.o(79213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.h
 * JD-Core Version:    0.7.0.1
 */