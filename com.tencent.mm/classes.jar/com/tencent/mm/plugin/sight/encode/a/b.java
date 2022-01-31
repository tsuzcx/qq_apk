package com.tencent.mm.plugin.sight.encode.a;

import com.tencent.mm.sdk.platformtools.ai;

public final class b
{
  public static void a(b.a parama, final int paramInt)
  {
    if (parama == null) {
      return;
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        this.ohr.onError(paramInt);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.b
 * JD-Core Version:    0.7.0.1
 */