package com.tencent.mm.toolkit.frontia.core;

import android.os.Bundle;
import android.text.TextUtils;

public abstract class b<P>
{
  protected int FEY = -2233;
  protected StringBuffer FEZ = new StringBuffer(String.valueOf(this.mState));
  protected boolean FFa = true;
  public final Bundle mExtras = new Bundle();
  private final byte[] mLock = new byte[0];
  protected int mState = -1;
  
  public final b aJO(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.FEZ.append(" --> ").append(paramString);
    }
    return this;
  }
  
  public final b eOG()
  {
    synchronized (this.mLock)
    {
      this.mState = 0;
      return aJO("0");
    }
  }
  
  public final void eOH()
  {
    this.FFa = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.toolkit.frontia.core.b
 * JD-Core Version:    0.7.0.1
 */