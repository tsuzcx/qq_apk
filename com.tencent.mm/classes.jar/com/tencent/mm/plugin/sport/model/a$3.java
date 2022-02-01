package com.tencent.mm.plugin.sport.model;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

public final class a$3
  implements Runnable
{
  public a$3(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(149273);
    try
    {
      Uri localUri = Uri.parse("content://com.tencent.mm.plugin.sport");
      aj.getContext().getContentResolver().query(localUri, null, "clearConfig", null, null);
      AppMethodBeat.o(149273);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(149273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.a.3
 * JD-Core Version:    0.7.0.1
 */