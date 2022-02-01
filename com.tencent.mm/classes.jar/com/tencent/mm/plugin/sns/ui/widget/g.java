package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;

public final class g
{
  public static l a(Context paramContext, String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(100558);
    paramContext = new l(k.a(paramContext, paramString, (int)paramFloat, 2, paramBoolean));
    AppMethodBeat.o(100558);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */