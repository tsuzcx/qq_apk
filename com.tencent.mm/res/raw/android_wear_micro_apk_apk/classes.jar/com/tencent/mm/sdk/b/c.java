package com.tencent.mm.sdk.b;

import com.tencent.mm.sdk.b.a.d;
import com.tencent.mm.sdk.b.a.f;

public final class c
  implements com.tencent.mm.sdk.b.a.c
{
  private f aan;
  private d aao;
  
  public c(f paramf)
  {
    this.aan = paramf;
  }
  
  public final void a(Runnable paramRunnable, String paramString, long paramLong)
  {
    if ((this.aao == null) || (this.aao.lK()))
    {
      if (0L >= paramLong) {
        this.aan.a(paramRunnable, paramString);
      }
    }
    else {
      return;
    }
    this.aan.b(paramRunnable, paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.c
 * JD-Core Version:    0.7.0.1
 */