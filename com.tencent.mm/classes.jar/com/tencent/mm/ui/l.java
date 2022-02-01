package com.tencent.mm.ui;

import android.content.ContentResolver;
import android.provider.Settings.Global;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
{
  public static int a(ContentResolver paramContentResolver)
  {
    AppMethodBeat.i(249227);
    int i = 0;
    try
    {
      int j = Settings.Global.getInt(paramContentResolver, "hn_fold_display_mode_prepare");
      i = j;
    }
    catch (Exception paramContentResolver)
    {
      for (;;)
      {
        Log.e("MicroMsg.HonorUtil", "error occur");
      }
    }
    AppMethodBeat.o(249227);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.l
 * JD-Core Version:    0.7.0.1
 */