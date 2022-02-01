package com.tencent.mm.ui.chatting.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public static final b GGk;
  public int ACc;
  public int GGl;
  public int GGm;
  public int GGn;
  public int mCount;
  public int mSuccessCount;
  
  static
  {
    AppMethodBeat.i(36612);
    GGk = new b();
    AppMethodBeat.o(36612);
  }
  
  public static void aP(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36608);
    ad.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s cleanCount:%s count:%s ", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > 0)
    {
      e.vIY.idkeyStat(403L, 67L, 1L, true);
      e.vIY.idkeyStat(403L, 68L, paramInt1, true);
    }
    e.vIY.idkeyStat(403L, 70L, paramInt2, true);
    if (paramInt2 <= 5)
    {
      e.vIY.idkeyStat(403L, 71L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 10)
    {
      e.vIY.idkeyStat(403L, 72L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 20)
    {
      e.vIY.idkeyStat(403L, 73L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 30)
    {
      e.vIY.idkeyStat(403L, 74L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 50)
    {
      e.vIY.idkeyStat(403L, 75L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    e.vIY.idkeyStat(403L, 76L, 1L, true);
    AppMethodBeat.o(36608);
  }
  
  public static void faq()
  {
    AppMethodBeat.i(36609);
    e.vIY.idkeyStat(403L, 77L, 1L, true);
    AppMethodBeat.o(36609);
  }
  
  public static void far()
  {
    AppMethodBeat.i(36610);
    e.vIY.idkeyStat(403L, 41L, 1L, false);
    AppMethodBeat.o(36610);
  }
  
  public static void fas()
  {
    AppMethodBeat.i(36611);
    e.vIY.idkeyStat(403L, 78L, 1L, false);
    AppMethodBeat.o(36611);
  }
  
  public final void Zx(int paramInt)
  {
    this.GGn += paramInt;
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(36607);
    ad.i("MicroMsg.GetChatroomReporter", "[recordFetch] isDown:" + paramBoolean1 + " isSuccess:" + paramBoolean2 + " chatroomid:" + paramString);
    if (paramBoolean1) {
      this.GGl += 1;
    }
    for (;;)
    {
      this.mCount += 1;
      if (paramBoolean2) {
        break;
      }
      this.ACc += 1;
      AppMethodBeat.o(36607);
      return;
      this.GGm += 1;
    }
    this.mSuccessCount += 1;
    AppMethodBeat.o(36607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.b
 * JD-Core Version:    0.7.0.1
 */