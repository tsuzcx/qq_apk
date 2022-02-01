package com.tencent.mm.sdk.b;

import android.text.TextUtils;
import com.tencent.mm.sdk.b.b.a;

final class e
  implements com.tencent.mm.sdk.b.a.e
{
  com.tencent.mm.sdk.b.a.e aaH;
  String aaI;
  
  e(d paramd, String paramString, com.tencent.mm.sdk.b.a.e parame)
  {
    this.aaI = paramString;
    this.aaH = null;
  }
  
  public final void a(Runnable paramRunnable, int paramInt)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(this.aaI);
      if (bool) {
        return;
      }
      Object localObject1 = d.c(paramRunnable, this.aaI);
      localObject1 = d.a(this.aaG, localObject1, paramInt);
      if (localObject1 != null) {
        this.aaG.aaw.execute((Runnable)localObject1);
      }
      return;
    }
    finally
    {
      if (this.aaH != null) {
        this.aaH.a(paramRunnable, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.e
 * JD-Core Version:    0.7.0.1
 */