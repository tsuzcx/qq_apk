package com.tencent.mm.ui.chatting.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  public static final b zPL;
  public int mCount;
  public int mSuccessCount;
  public int uEW;
  public int zPM;
  public int zPN;
  public int zPO;
  
  static
  {
    AppMethodBeat.i(32672);
    zPL = new b();
    AppMethodBeat.o(32672);
  }
  
  public static void aI(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32668);
    ab.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s cleanCount:%s count:%s ", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > 0)
    {
      e.qrI.idkeyStat(403L, 67L, 1L, true);
      e.qrI.idkeyStat(403L, 68L, paramInt1, true);
    }
    e.qrI.idkeyStat(403L, 70L, paramInt2, true);
    if (paramInt2 <= 5)
    {
      e.qrI.idkeyStat(403L, 71L, 1L, true);
      AppMethodBeat.o(32668);
      return;
    }
    if (paramInt2 <= 10)
    {
      e.qrI.idkeyStat(403L, 72L, 1L, true);
      AppMethodBeat.o(32668);
      return;
    }
    if (paramInt2 <= 20)
    {
      e.qrI.idkeyStat(403L, 73L, 1L, true);
      AppMethodBeat.o(32668);
      return;
    }
    if (paramInt2 <= 30)
    {
      e.qrI.idkeyStat(403L, 74L, 1L, true);
      AppMethodBeat.o(32668);
      return;
    }
    if (paramInt2 <= 50)
    {
      e.qrI.idkeyStat(403L, 75L, 1L, true);
      AppMethodBeat.o(32668);
      return;
    }
    e.qrI.idkeyStat(403L, 76L, 1L, true);
    AppMethodBeat.o(32668);
  }
  
  public static void dLc()
  {
    AppMethodBeat.i(32669);
    e.qrI.idkeyStat(403L, 77L, 1L, true);
    AppMethodBeat.o(32669);
  }
  
  public static void dLd()
  {
    AppMethodBeat.i(32670);
    e.qrI.idkeyStat(403L, 41L, 1L, false);
    AppMethodBeat.o(32670);
  }
  
  public static void dLe()
  {
    AppMethodBeat.i(32671);
    e.qrI.idkeyStat(403L, 78L, 1L, false);
    AppMethodBeat.o(32671);
  }
  
  public final void Qo(int paramInt)
  {
    this.zPO += paramInt;
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(32667);
    ab.i("MicroMsg.GetChatroomReporter", "[recordFetch] isDown:" + paramBoolean1 + " isSuccess:" + paramBoolean2 + " chatroomid:" + paramString);
    if (paramBoolean1) {
      this.zPM += 1;
    }
    for (;;)
    {
      this.mCount += 1;
      if (paramBoolean2) {
        break;
      }
      this.uEW += 1;
      AppMethodBeat.o(32667);
      return;
      this.zPN += 1;
    }
    this.mSuccessCount += 1;
    AppMethodBeat.o(32667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.b
 * JD-Core Version:    0.7.0.1
 */