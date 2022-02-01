package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;

public class BroadcastHelper
{
  private static final String TAG = "MicroMsg.BroadcastHelper";
  
  public static void setIntentPackageName(Intent paramIntent)
  {
    AppMethodBeat.i(156176);
    if (d.rb(26)) {
      paramIntent.setPackage(MMApplicationContext.getPackageName());
    }
    AppMethodBeat.o(156176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BroadcastHelper
 * JD-Core Version:    0.7.0.1
 */