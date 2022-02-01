package com.tencent.mm.pluginsdk.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.ui.widget.snackbar.a.b;

public final class e
  implements v
{
  public final void a(int paramInt, Activity paramActivity, a.b paramb)
  {
    AppMethodBeat.i(30938);
    com.tencent.mm.plugin.fav.ui.e.a(paramInt, paramActivity, paramb);
    AppMethodBeat.o(30938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.e
 * JD-Core Version:    0.7.0.1
 */