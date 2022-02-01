package com.tencent.mm.toolkit.frontia.core;

import android.os.Bundle;
import android.text.TextUtils;

public abstract class b<P>
{
  protected int adtn = -2233;
  protected StringBuffer adto = new StringBuffer(String.valueOf(this.mState));
  protected boolean adtp = true;
  public final Bundle mExtras = new Bundle();
  private final byte[] mLock = new byte[0];
  protected int mState = -1;
  
  public final b azQ(int paramInt)
  {
    synchronized (this.mLock)
    {
      this.mState = 0;
      return bzz("0");
    }
  }
  
  public final b bzz(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.adto.append(" --> ").append(paramString);
    }
    return this;
  }
  
  public final void jhh()
  {
    this.adtp = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.toolkit.frontia.core.b
 * JD-Core Version:    0.7.0.1
 */