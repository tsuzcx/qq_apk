package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.aj;

public final class av
{
  public static int zDZ = -1;
  public static int zEa = 0;
  public static int zEb = 1;
  public static int zEc = 2;
  public boolean dsB = false;
  public int dsC = 0;
  public String objectId = "";
  public boolean zEd = true;
  
  public static void b(String paramString, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(179116);
    if (paramInt2 == 2)
    {
      al.zCh = al.zxX;
      g.ajS();
      q localq = g.ajQ().gDv;
      paramLong = al.zxX;
      int i = zEb;
      if (paramBoolean) {}
      for (paramInt2 = 4;; paramInt2 = 8)
      {
        localq.a(new aa(paramString, paramLong, paramBoolean, paramInt1, i, 0, paramInt2, 2), 0);
        AppMethodBeat.o(179116);
        return;
      }
    }
    if (paramInt2 == 1)
    {
      g.ajS();
      g.ajR().ajA().set(68377, "");
      g.ajS();
      g.ajQ().gDv.a(new y(0L, paramLong, 1), 0);
    }
    AppMethodBeat.o(179116);
  }
  
  public static void f(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(95953);
    g.ajS();
    q localq = g.ajQ().gDv;
    long l = al.zxY;
    int j = zEc;
    if (paramBoolean) {}
    for (int i = 4;; i = 8)
    {
      localq.a(new aa(paramString, l, paramBoolean, paramInt, j, 0, i, 2), 0);
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
      this.dsB = paramBoolean;
      this.dsC = paramInt1;
      this.zEd = false;
      al.zCh = 0L;
      g.ajS();
      q localq = g.ajQ().gDv;
      int i = zEa;
      if (paramBoolean) {}
      for (paramInt2 = 4;; paramInt2 = 8)
      {
        localq.a(new aa(paramString, paramLong, paramBoolean, paramInt1, i, 0, paramInt2, 2), 0);
        AppMethodBeat.o(179115);
        return;
      }
    }
    if (paramInt2 == 1)
    {
      g.ajS();
      g.ajR().ajA().set(68377, "");
      g.ajS();
      g.ajQ().gDv.a(new y(paramLong, 0L, 0), 0);
    }
    AppMethodBeat.o(179115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.av
 * JD-Core Version:    0.7.0.1
 */