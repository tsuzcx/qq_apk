package com.tencent.mm.vending.d;

import android.content.Intent;
import android.os.Bundle;

public final class a
{
  Bundle wtu = null;
  
  public a(Intent paramIntent)
  {
    this.wtu = paramIntent.getExtras();
  }
  
  public final int getIntExtra(String paramString, int paramInt)
  {
    if (this.wtu == null) {
      return paramInt;
    }
    return this.wtu.getInt(paramString, paramInt);
  }
  
  public final String getStringExtra(String paramString)
  {
    if (this.wtu == null) {
      return null;
    }
    return this.wtu.getString(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.d.a
 * JD-Core Version:    0.7.0.1
 */