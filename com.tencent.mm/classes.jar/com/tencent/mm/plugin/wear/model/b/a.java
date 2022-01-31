package com.tencent.mm.plugin.wear.model.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  public static void ab(Bundle paramBundle)
  {
    AppMethodBeat.i(26368);
    Intent localIntent = new Intent();
    localIntent.setPackage(ah.getContext().getPackageName());
    localIntent.setAction("com.tencent.mm.wear.message");
    localIntent.putExtras(paramBundle);
    ah.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(26368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b.a
 * JD-Core Version:    0.7.0.1
 */