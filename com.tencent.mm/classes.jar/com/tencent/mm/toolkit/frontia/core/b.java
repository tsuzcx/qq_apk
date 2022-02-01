package com.tencent.mm.toolkit.frontia.core;

import android.os.Bundle;
import android.text.TextUtils;

public abstract class b<P>
{
  protected int IRr = -2233;
  protected StringBuffer IRs = new StringBuffer(String.valueOf(this.mState));
  protected boolean IRt = true;
  public final Bundle mExtras = new Bundle();
  private final byte[] mLock = new byte[0];
  protected int mState = -1;
  
  public final b aVd(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.IRs.append(" --> ").append(paramString);
    }
    return this;
  }
  
  public final b fus()
  {
    synchronized (this.mLock)
    {
      this.mState = 0;
      return aVd("0");
    }
  }
  
  public final void fut()
  {
    this.IRt = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.toolkit.frontia.core.b
 * JD-Core Version:    0.7.0.1
 */