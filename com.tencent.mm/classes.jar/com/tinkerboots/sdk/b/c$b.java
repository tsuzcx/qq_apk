package com.tinkerboots.sdk.b;

import android.content.Context;
import android.content.IntentFilter;

public final class c$b
{
  public c$b(Context paramContext, c.a parama)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.registerReceiver(new c.b.1(this, parama), localIntentFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tinkerboots.sdk.b.c.b
 * JD-Core Version:    0.7.0.1
 */