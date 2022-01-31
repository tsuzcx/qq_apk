package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;

public final class j
{
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(29437);
    d.post(new j.1(paramActivity, paramInt1, paramInt2), paramString);
    AppMethodBeat.o(29437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.j
 * JD-Core Version:    0.7.0.1
 */