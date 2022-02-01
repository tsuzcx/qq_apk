package com.tencent.mm.toolkit.frontia.core;

import android.os.Bundle;
import android.text.TextUtils;

public abstract class b<P>
{
  protected int VPi = -2233;
  protected StringBuffer VPj = new StringBuffer(String.valueOf(this.mState));
  protected boolean VPk = true;
  public final Bundle mExtras = new Bundle();
  private final byte[] mLock = new byte[0];
  protected int mState = -1;
  
  public final b bye(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.VPj.append(" --> ").append(paramString);
    }
    return this;
  }
  
  public final b hEU()
  {
    synchronized (this.mLock)
    {
      this.mState = 0;
      return bye("0");
    }
  }
  
  public final void hEV()
  {
    this.VPk = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.frontia.core.b
 * JD-Core Version:    0.7.0.1
 */