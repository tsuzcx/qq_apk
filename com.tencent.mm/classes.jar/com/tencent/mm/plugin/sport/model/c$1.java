package com.tencent.mm.plugin.sport.model;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;

final class c$1
  implements Runnable
{
  c$1(c paramc, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(149292);
    try
    {
      Uri localUri = Uri.parse("content://com.tencent.mm.plugin.sport");
      ai.getContext().getContentResolver().query(localUri, null, "Key_mmSensorChange", new String[] { String.valueOf(this.zoU), String.valueOf(this.zoV) }, null);
      AppMethodBeat.o(149292);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(149292);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.c.1
 * JD-Core Version:    0.7.0.1
 */