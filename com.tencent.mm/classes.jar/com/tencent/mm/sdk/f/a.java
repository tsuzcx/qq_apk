package com.tencent.mm.sdk.f;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static Activity hr(Context paramContext)
  {
    AppMethodBeat.i(146184);
    for (;;)
    {
      if (paramContext == null)
      {
        AppMethodBeat.o(146184);
        return null;
      }
      if ((paramContext instanceof Activity))
      {
        paramContext = (Activity)paramContext;
        AppMethodBeat.o(146184);
        return paramContext;
      }
      if (!(paramContext instanceof ContextWrapper)) {
        break;
      }
      Context localContext = ((ContextWrapper)paramContext).getBaseContext();
      if (localContext == paramContext) {
        break;
      }
      paramContext = localContext;
    }
    AppMethodBeat.o(146184);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.f.a
 * JD-Core Version:    0.7.0.1
 */