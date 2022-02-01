package com.tencent.mm.toolkit.frontia.core;

import android.os.Bundle;
import android.text.TextUtils;

public abstract class b<P>
{
  protected int JlZ = -2233;
  protected StringBuffer Jma = new StringBuffer(String.valueOf(this.mState));
  protected boolean Jmb = true;
  public final Bundle mExtras = new Bundle();
  private final byte[] mLock = new byte[0];
  protected int mState = -1;
  
  public final b aWE(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.Jma.append(" --> ").append(paramString);
    }
    return this;
  }
  
  public final b fyt()
  {
    synchronized (this.mLock)
    {
      this.mState = 0;
      return aWE("0");
    }
  }
  
  public final void fyu()
  {
    this.Jmb = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.frontia.core.b
 * JD-Core Version:    0.7.0.1
 */