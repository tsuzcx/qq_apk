package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;

public final class g
{
  public static void be(Intent paramIntent)
  {
    AppMethodBeat.i(156176);
    if (d.kZ(26)) {
      paramIntent.setPackage(ai.getPackageName());
    }
    AppMethodBeat.o(156176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.g
 * JD-Core Version:    0.7.0.1
 */