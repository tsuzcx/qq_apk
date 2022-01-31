package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.c.a.g;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.j;

public final class l
{
  protected static long qNa = 16000L;
  protected static int qNb = 54158;
  public int qNc;
  public l.b qNd;
  
  public final l.b a(Context paramContext, int paramInt, l.a parama)
  {
    AppMethodBeat.i(24473);
    if (paramInt == this.qNc)
    {
      paramContext = this.qNd;
      AppMethodBeat.o(24473);
      return paramContext;
    }
    if (this.qNd != null) {
      this.qNd.ckR();
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.qNc = paramInt;
      this.qNd.init();
      paramContext = this.qNd;
      AppMethodBeat.o(24473);
      return paramContext;
      this.qNd = new c(paramContext, parama);
      continue;
      this.qNd = j.a(parama);
      continue;
      this.qNd = new com.tencent.mm.plugin.shake.d.a.l(paramContext, parama);
      continue;
      this.qNd = new h(parama);
      continue;
      this.qNd = new g(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.l
 * JD-Core Version:    0.7.0.1
 */