package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ab;

public final class as
{
  public static int wKg = -1;
  public static int wKh = 0;
  public static int wKi = 1;
  public static int wKj = 2;
  public boolean diE = false;
  public int diF = 0;
  public String objectId = "";
  public boolean wKk = true;
  
  public static void b(String paramString, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(179116);
    if (paramInt2 == 2)
    {
      aj.wIC = aj.wET;
      g.afC();
      q localq = g.afA().gcy;
      paramLong = aj.wET;
      int i = wKi;
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
      g.afC();
      g.afB().afk().set(68377, "");
      g.afC();
      g.afA().gcy.a(new x(0L, paramLong, 1), 0);
    }
    AppMethodBeat.o(179116);
  }
  
  public static void f(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(95953);
    g.afC();
    q localq = g.afA().gcy;
    long l = aj.wEU;
    int j = wKj;
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
      this.diE = paramBoolean;
      this.diF = paramInt1;
      this.wKk = false;
      aj.wIC = 0L;
      g.afC();
      q localq = g.afA().gcy;
      int i = wKh;
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
      g.afC();
      g.afB().afk().set(68377, "");
      g.afC();
      g.afA().gcy.a(new x(paramLong, 0L, 0), 0);
    }
    AppMethodBeat.o(179115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as
 * JD-Core Version:    0.7.0.1
 */