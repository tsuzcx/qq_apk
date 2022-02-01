package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ai;

public final class au
{
  public static int zmK = -1;
  public static int zmL = 0;
  public static int zmM = 1;
  public static int zmN = 2;
  public boolean drv = false;
  public int drw = 0;
  public String objectId = "";
  public boolean zmO = true;
  
  public static void b(String paramString, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(179116);
    if (paramInt2 == 2)
    {
      ak.zkS = ak.zhi;
      g.ajD();
      q localq = g.ajB().gAO;
      paramLong = ak.zhi;
      int i = zmM;
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
      g.ajD();
      g.ajC().ajl().set(68377, "");
      g.ajD();
      g.ajB().gAO.a(new x(0L, paramLong, 1), 0);
    }
    AppMethodBeat.o(179116);
  }
  
  public static void f(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(95953);
    g.ajD();
    q localq = g.ajB().gAO;
    long l = ak.zhj;
    int j = zmN;
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
      this.drv = paramBoolean;
      this.drw = paramInt1;
      this.zmO = false;
      ak.zkS = 0L;
      g.ajD();
      q localq = g.ajB().gAO;
      int i = zmL;
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
      g.ajD();
      g.ajC().ajl().set(68377, "");
      g.ajD();
      g.ajB().gAO.a(new x(paramLong, 0L, 0), 0);
    }
    AppMethodBeat.o(179115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.au
 * JD-Core Version:    0.7.0.1
 */