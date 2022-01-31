package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;

public final class f
{
  public static k a(Context paramContext, String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(40523);
    paramContext = new k(j.a(paramContext, paramString, (int)paramFloat, 2, paramBoolean));
    AppMethodBeat.o(40523);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */