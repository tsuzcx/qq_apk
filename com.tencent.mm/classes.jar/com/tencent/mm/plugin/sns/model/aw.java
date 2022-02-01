package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.ao;

public final class aw
{
  public static int Kbi = -1;
  public static int Kbj = 0;
  public static int Kbk = 1;
  public static int Kbl = 2;
  public boolean Kbm = true;
  public boolean fCB = false;
  public int fCC = 0;
  public String objectId = "";
  
  public static void b(String paramString, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(179116);
    if (paramInt2 == 2)
    {
      an.JZj = an.JVf;
      h.aHH();
      t localt = h.aHF().kcd;
      paramLong = an.JVf;
      int i = Kbk;
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
      h.aHH();
      h.aHG().aHp().i(68377, "");
      h.aHH();
      h.aHF().kcd.a(new z(0L, paramLong, 1), 0);
    }
    AppMethodBeat.o(179116);
  }
  
  public static void i(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(95953);
    h.aHH();
    t localt = h.aHF().kcd;
    long l = an.JVg;
    int j = Kbl;
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
      this.fCB = paramBoolean;
      this.fCC = paramInt1;
      this.Kbm = false;
      an.JZj = 0L;
      h.aHH();
      t localt = h.aHF().kcd;
      int i = Kbj;
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
      h.aHH();
      h.aHG().aHp().i(68377, "");
      h.aHH();
      h.aHF().kcd.a(new z(paramLong, 0L, 0), 0);
    }
    AppMethodBeat.o(179115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aw
 * JD-Core Version:    0.7.0.1
 */