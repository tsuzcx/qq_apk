package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static final c aeJl;
  public int WgD;
  public int aeJm;
  public int aeJn;
  public int aeJo;
  public int mCount;
  public int mSuccessCount;
  
  static
  {
    AppMethodBeat.i(36612);
    aeJl = new c();
    AppMethodBeat.o(36612);
  }
  
  public static void bf(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36608);
    Log.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s cleanCount:%s count:%s ", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > 0)
    {
      f.Ozc.idkeyStat(403L, 67L, 1L, true);
      f.Ozc.idkeyStat(403L, 68L, paramInt1, true);
    }
    f.Ozc.idkeyStat(403L, 70L, paramInt2, true);
    if (paramInt2 <= 5)
    {
      f.Ozc.idkeyStat(403L, 71L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 10)
    {
      f.Ozc.idkeyStat(403L, 72L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 20)
    {
      f.Ozc.idkeyStat(403L, 73L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 30)
    {
      f.Ozc.idkeyStat(403L, 74L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 50)
    {
      f.Ozc.idkeyStat(403L, 75L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    f.Ozc.idkeyStat(403L, 76L, 1L, true);
    AppMethodBeat.o(36608);
  }
  
  public static void jwO()
  {
    AppMethodBeat.i(36609);
    f.Ozc.idkeyStat(403L, 77L, 1L, true);
    AppMethodBeat.o(36609);
  }
  
  public static void jwP()
  {
    AppMethodBeat.i(36610);
    f.Ozc.idkeyStat(403L, 41L, 1L, false);
    AppMethodBeat.o(36610);
  }
  
  public static void jwQ()
  {
    AppMethodBeat.i(36611);
    f.Ozc.idkeyStat(403L, 78L, 1L, false);
    AppMethodBeat.o(36611);
  }
  
  public final void aDk(int paramInt)
  {
    this.aeJo += paramInt;
  }
  
  public final void f(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(36607);
    Log.i("MicroMsg.GetChatroomReporter", "[recordFetch] isDown:" + paramBoolean1 + " isSuccess:" + paramBoolean2 + " chatroomid:" + paramString);
    if (paramBoolean1) {
      this.aeJm += 1;
    }
    for (;;)
    {
      this.mCount += 1;
      if (paramBoolean2) {
        break;
      }
      this.WgD += 1;
      AppMethodBeat.o(36607);
      return;
      this.aeJn += 1;
    }
    this.mSuccessCount += 1;
    AppMethodBeat.o(36607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.c
 * JD-Core Version:    0.7.0.1
 */