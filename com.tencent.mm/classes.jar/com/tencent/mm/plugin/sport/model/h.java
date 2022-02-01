package com.tencent.mm.plugin.sport.model;

import android.database.MatrixCursor;
import android.os.Bundle;

public final class h
  extends MatrixCursor
{
  private Bundle dQL;
  
  public h(String[] paramArrayOfString, Bundle paramBundle)
  {
    super(paramArrayOfString);
    this.dQL = paramBundle;
  }
  
  public final Bundle getExtras()
  {
    return this.dQL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.h
 * JD-Core Version:    0.7.0.1
 */