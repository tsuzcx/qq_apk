package com.tencent.soter.a.b;

import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.g;

public abstract class e<T>
  extends f
{
  public T RQu = null;
  
  e()
  {
    super(-1);
  }
  
  protected e(int paramInt)
  {
    this(paramInt, "", null);
  }
  
  protected e(int paramInt, String paramString)
  {
    this(paramInt, paramString, null);
  }
  
  protected e(int paramInt, String paramString, T paramT)
  {
    super(paramInt, paramString);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!g.isNullOrNil(paramString)) {
        this.errMsg = paramString;
      }
      this.RQu = paramT;
      return;
      this.errMsg = "get support soter failed remotely";
      continue;
      this.errMsg = "upload app secure key";
      continue;
      this.errMsg = "upload auth key failed";
      continue;
      this.errMsg = "not initialized yet. please make sure you've already called SoterWrapperApi.init(...) and call backed";
      continue;
      this.errMsg = "context instance already released. should not happen normally, you can try to call again";
      continue;
      this.errMsg = "there must be at least 1 biometric enrolled in system to complete this process. please check it previously";
      continue;
      this.errMsg = "get challenge failed";
      continue;
      this.errMsg = "upload or verify signature in server side failed";
    }
  }
  
  protected e(T paramT)
  {
    this(0, "", paramT);
  }
  
  public String toString()
  {
    if (this.RQu == null) {
      return super.toString();
    }
    return String.format("total: %s, extData: %s", new Object[] { super.toString(), this.RQu.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.b.e
 * JD-Core Version:    0.7.0.1
 */