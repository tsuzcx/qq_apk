package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ae;

public final class at
{
  public static int xWL = -1;
  public static int xWM = 0;
  public static int xWN = 1;
  public static int xWO = 2;
  public boolean dfZ = false;
  public int dga = 0;
  public String objectId = "";
  public boolean xWP = true;
  
  public static void b(String paramString, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(179116);
    if (paramInt2 == 2)
    {
      aj.xUX = aj.xRo;
      g.agS();
      q localq = g.agQ().ghe;
      paramLong = aj.xRo;
      int i = xWN;
      if (paramBoolean) {}
      for (paramInt2 = 4;; paramInt2 = 8)
      {
        localq.a(new z(paramString, paramLong, paramBoolean, paramInt1, i, 0, paramInt2, 2), 0);
        AppMethodBeat.o(179116);
        return;
      }
    }
    if (paramInt2 == 1)
    {
      g.agS();
      g.agR().agA().set(68377, "");
      g.agS();
      g.agQ().ghe.a(new x(0L, paramLong, 1), 0);
    }
    AppMethodBeat.o(179116);
  }
  
  public static void f(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(95953);
    g.agS();
    q localq = g.agQ().ghe;
    long l = aj.xRp;
    int j = xWO;
    if (paramBoolean) {}
    for (int i = 4;; i = 8)
    {
      localq.a(new z(paramString, l, paramBoolean, paramInt, j, 0, i, 2), 0);
      AppMethodBeat.o(95953);
      return;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(179115);
    if (paramInt2 == 2)
    {
      this.objectId = paramString;
      this.dfZ = paramBoolean;
      this.dga = paramInt1;
      this.xWP = false;
      aj.xUX = 0L;
      g.agS();
      q localq = g.agQ().ghe;
      int i = xWM;
      if (paramBoolean) {}
      for (paramInt2 = 4;; paramInt2 = 8)
      {
        localq.a(new z(paramString, paramLong, paramBoolean, paramInt1, i, 0, paramInt2, 2), 0);
        AppMethodBeat.o(179115);
        return;
      }
    }
    if (paramInt2 == 1)
    {
      g.agS();
      g.agR().agA().set(68377, "");
      g.agS();
      g.agQ().ghe.a(new x(paramLong, 0L, 0), 0);
    }
    AppMethodBeat.o(179115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.at
 * JD-Core Version:    0.7.0.1
 */