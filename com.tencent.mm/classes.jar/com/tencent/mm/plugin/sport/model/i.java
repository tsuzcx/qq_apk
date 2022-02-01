package com.tencent.mm.plugin.sport.model;

import android.database.MatrixCursor;
import android.os.Bundle;

public final class i
  extends MatrixCursor
{
  private Bundle dow;
  
  public i(String[] paramArrayOfString, Bundle paramBundle)
  {
    super(paramArrayOfString);
    this.dow = paramBundle;
  }
  
  public final Bundle getExtras()
  {
    return this.dow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.i
 * JD-Core Version:    0.7.0.1
 */