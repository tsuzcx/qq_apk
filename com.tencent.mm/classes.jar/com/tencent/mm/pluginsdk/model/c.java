package com.tencent.mm.pluginsdk.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.ui.widget.snackbar.a.b;

public final class c
  implements v
{
  public final void a(int paramInt, Activity paramActivity, a.b paramb)
  {
    AppMethodBeat.i(27235);
    com.tencent.mm.plugin.fav.ui.c.a(paramInt, paramActivity, paramb);
    AppMethodBeat.o(27235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.c
 * JD-Core Version:    0.7.0.1
 */