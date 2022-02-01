package com.tencent.mm.plugin.sport.model;

import android.database.MatrixCursor;
import android.os.Bundle;

public final class i
  extends MatrixCursor
{
  private Bundle dmf;
  
  public i(String[] paramArrayOfString, Bundle paramBundle)
  {
    super(paramArrayOfString);
    this.dmf = paramBundle;
  }
  
  public final Bundle getExtras()
  {
    return this.dmf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.i
 * JD-Core Version:    0.7.0.1
 */