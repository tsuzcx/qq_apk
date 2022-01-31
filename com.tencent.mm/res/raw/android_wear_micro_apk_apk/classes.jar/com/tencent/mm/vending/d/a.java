package com.tencent.mm.vending.d;

import android.content.Intent;
import android.os.Bundle;

public final class a
{
  Bundle ZW = null;
  
  private a(Intent paramIntent)
  {
    this.ZW = paramIntent.getExtras();
  }
  
  public static final a b(Intent paramIntent)
  {
    return new a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.d.a
 * JD-Core Version:    0.7.0.1
 */