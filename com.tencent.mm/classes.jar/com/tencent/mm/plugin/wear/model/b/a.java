package com.tencent.mm.plugin.wear.model.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static void aK(Bundle paramBundle)
  {
    AppMethodBeat.i(30050);
    Intent localIntent = new Intent();
    localIntent.setPackage(MMApplicationContext.getContext().getPackageName());
    localIntent.setAction("com.tencent.mm.wear.message");
    localIntent.putExtras(paramBundle);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(30050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b.a
 * JD-Core Version:    0.7.0.1
 */