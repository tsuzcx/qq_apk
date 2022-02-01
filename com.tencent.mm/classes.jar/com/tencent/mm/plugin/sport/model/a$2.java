package com.tencent.mm.plugin.sport.model;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class a$2
  implements Runnable
{
  a$2(a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(149272);
    try
    {
      Uri localUri = Uri.parse("content://com.tencent.mm.plugin.sport");
      ak.getContext().getContentResolver().query(localUri, null, "updateConfig", new String[] { this.AYj }, null);
      AppMethodBeat.o(149272);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(149272);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.a.2
 * JD-Core Version:    0.7.0.1
 */