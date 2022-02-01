package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;

public final class ay
{
  public static int QyA = 1;
  public static int QyB = 2;
  public static int Qyy = -1;
  public static int Qyz = 0;
  public boolean QyC = true;
  public boolean hHq = false;
  public int hHr = 0;
  public String objectId = "";
  
  public static void b(String paramString, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(179116);
    if (paramInt2 == 2)
    {
      ap.Qws = ap.maxId;
      h.baF();
      s locals = h.baD().mCm;
      paramLong = ap.maxId;
      int i = QyA;
      if (paramBoolean) {}
      for (paramInt2 = 4;; paramInt2 = 8)
      {
        locals.a(new ab(paramString, paramLong, paramBoolean, paramInt1, i, 0, paramInt2, 2), 0);
        AppMethodBeat.o(179116);
        return;
      }
    }
    if (paramInt2 == 1)
    {
      h.baF();
      h.baE().ban().B(68377, "");
      h.baF();
      h.baD().mCm.a(new z(0L, paramLong, 1), 0);
    }
    AppMethodBeat.o(179116);
  }
  
  public static void h(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(95953);
    h.baF();
    s locals = h.baD().mCm;
    long l = ap.Qsh;
    int j = QyB;
    if (paramBoolean) {}
    for (int i = 4;; i = 8)
    {
      locals.a(new ab(paramString, l, paramBoolean, paramInt, j, 0, i, 2), 0);
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
      this.hHq = paramBoolean;
      this.hHr = paramInt1;
      this.QyC = false;
      ap.Qws = 0L;
      h.baF();
      s locals = h.baD().mCm;
      int i = Qyz;
      if (paramBoolean) {}
      for (paramInt2 = 4;; paramInt2 = 8)
      {
        locals.a(new ab(paramString, paramLong, paramBoolean, paramInt1, i, 0, paramInt2, 2), 0);
        AppMethodBeat.o(179115);
        return;
      }
    }
    if (paramInt2 == 1)
    {
      h.baF();
      h.baE().ban().B(68377, "");
      h.baF();
      h.baD().mCm.a(new z(paramLong, 0L, 0), 0);
    }
    AppMethodBeat.o(179115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ay
 * JD-Core Version:    0.7.0.1
 */