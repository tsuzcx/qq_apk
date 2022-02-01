package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ao;

public final class ax
{
  public static int DOc = -1;
  public static int DOd = 0;
  public static int DOe = 1;
  public static int DOf = 2;
  public boolean DOg = true;
  public boolean dJM = false;
  public int dJN = 0;
  public String objectId = "";
  
  public static void b(String paramString, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(179116);
    if (paramInt2 == 2)
    {
      an.DMh = an.DIf;
      g.aAi();
      t localt = g.aAg().hqi;
      paramLong = an.DIf;
      int i = DOe;
      if (paramBoolean) {}
      for (paramInt2 = 4;; paramInt2 = 8)
      {
        localt.a(new ab(paramString, paramLong, paramBoolean, paramInt1, i, 0, paramInt2, 2), 0);
        AppMethodBeat.o(179116);
        return;
      }
    }
    if (paramInt2 == 1)
    {
      g.aAi();
      g.aAh().azQ().set(68377, "");
      g.aAi();
      g.aAg().hqi.a(new z(0L, paramLong, 1), 0);
    }
    AppMethodBeat.o(179116);
  }
  
  public static void f(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(95953);
    g.aAi();
    t localt = g.aAg().hqi;
    long l = an.DIg;
    int j = DOf;
    if (paramBoolean) {}
    for (int i = 4;; i = 8)
    {
      localt.a(new ab(paramString, l, paramBoolean, paramInt, j, 0, i, 2), 0);
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
      this.dJM = paramBoolean;
      this.dJN = paramInt1;
      this.DOg = false;
      an.DMh = 0L;
      g.aAi();
      t localt = g.aAg().hqi;
      int i = DOd;
      if (paramBoolean) {}
      for (paramInt2 = 4;; paramInt2 = 8)
      {
        localt.a(new ab(paramString, paramLong, paramBoolean, paramInt1, i, 0, paramInt2, 2), 0);
        AppMethodBeat.o(179115);
        return;
      }
    }
    if (paramInt2 == 1)
    {
      g.aAi();
      g.aAh().azQ().set(68377, "");
      g.aAi();
      g.aAg().hqi.a(new z(paramLong, 0L, 0), 0);
    }
    AppMethodBeat.o(179115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ax
 * JD-Core Version:    0.7.0.1
 */