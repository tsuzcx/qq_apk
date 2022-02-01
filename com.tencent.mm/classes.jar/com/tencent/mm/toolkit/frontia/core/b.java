package com.tencent.mm.toolkit.frontia.core;

import android.os.Bundle;
import android.text.TextUtils;

public abstract class b<P>
{
  protected int Heb = -2233;
  protected StringBuffer Hec = new StringBuffer(String.valueOf(this.mState));
  protected boolean Hed = true;
  public final Bundle mExtras = new Bundle();
  private final byte[] mLock = new byte[0];
  protected int mState = -1;
  
  public final b aPm(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.Hec.append(" --> ").append(paramString);
    }
    return this;
  }
  
  public final b fek()
  {
    synchronized (this.mLock)
    {
      this.mState = 0;
      return aPm("0");
    }
  }
  
  public final void fel()
  {
    this.Hed = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.toolkit.frontia.core.b
 * JD-Core Version:    0.7.0.1
 */