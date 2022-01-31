package com.tencent.soter.a.b;

import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.g;

public abstract class e<T>
  extends f
{
  public T wPx = null;
  
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
      if (!g.bl(paramString)) {
        this.aox = paramString;
      }
      this.wPx = paramT;
      return;
      this.aox = "get support soter failed remotely";
      continue;
      this.aox = "upload app secure key";
      continue;
      this.aox = "upload auth key failed";
      continue;
      this.aox = "not initialized yet. please make sure you've already called SoterWrapperApi.init(...) and call backed";
      continue;
      this.aox = "context instance already released. should not happen normally, you can try to call again";
      continue;
      this.aox = "there must be at least 1 biometric enrolled in system to complete this process. please check it previously";
      continue;
      this.aox = "get challenge failed";
      continue;
      this.aox = "upload or verify signature in server side failed";
    }
  }
  
  protected e(T paramT)
  {
    this(0, "", paramT);
  }
  
  public String toString()
  {
    if (this.wPx == null) {
      return super.toString();
    }
    return String.format("total: %s, extData: %s", new Object[] { super.toString(), this.wPx.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.soter.a.b.e
 * JD-Core Version:    0.7.0.1
 */