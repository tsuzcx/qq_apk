package com.tencent.mm.vending.d;

import android.content.Intent;
import android.os.Bundle;

public final class a
{
  Bundle adw = null;
  
  private a(Intent paramIntent)
  {
    this.adw = paramIntent.getExtras();
  }
  
  public static final a d(Intent paramIntent)
  {
    return new a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.d.a
 * JD-Core Version:    0.7.0.1
 */