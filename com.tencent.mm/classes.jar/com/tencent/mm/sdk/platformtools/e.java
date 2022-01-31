package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;

public final class e
{
  public static void aK(Intent paramIntent)
  {
    AppMethodBeat.i(93387);
    if (d.fv(26)) {
      paramIntent.setPackage(ah.getPackageName());
    }
    AppMethodBeat.o(93387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.e
 * JD-Core Version:    0.7.0.1
 */