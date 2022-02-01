package com.tencent.mm.ui.chatting.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public static final b KsK;
  public int DMw;
  public int KsL;
  public int KsM;
  public int KsN;
  public int mCount;
  public int mSuccessCount;
  
  static
  {
    AppMethodBeat.i(36612);
    KsK = new b();
    AppMethodBeat.o(36612);
  }
  
  public static void aZ(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36608);
    ae.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s cleanCount:%s count:%s ", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > 0)
    {
      e.ywz.idkeyStat(403L, 67L, 1L, true);
      e.ywz.idkeyStat(403L, 68L, paramInt1, true);
    }
    e.ywz.idkeyStat(403L, 70L, paramInt2, true);
    if (paramInt2 <= 5)
    {
      e.ywz.idkeyStat(403L, 71L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 10)
    {
      e.ywz.idkeyStat(403L, 72L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 20)
    {
      e.ywz.idkeyStat(403L, 73L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 30)
    {
      e.ywz.idkeyStat(403L, 74L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 50)
    {
      e.ywz.idkeyStat(403L, 75L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    e.ywz.idkeyStat(403L, 76L, 1L, true);
    AppMethodBeat.o(36608);
  }
  
  public static void fLm()
  {
    AppMethodBeat.i(36609);
    e.ywz.idkeyStat(403L, 77L, 1L, true);
    AppMethodBeat.o(36609);
  }
  
  public static void fLn()
  {
    AppMethodBeat.i(36610);
    e.ywz.idkeyStat(403L, 41L, 1L, false);
    AppMethodBeat.o(36610);
  }
  
  public static void fLo()
  {
    AppMethodBeat.i(36611);
    e.ywz.idkeyStat(403L, 78L, 1L, false);
    AppMethodBeat.o(36611);
  }
  
  public final void aeM(int paramInt)
  {
    this.KsN += paramInt;
  }
  
  public final void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(36607);
    ae.i("MicroMsg.GetChatroomReporter", "[recordFetch] isDown:" + paramBoolean1 + " isSuccess:" + paramBoolean2 + " chatroomid:" + paramString);
    if (paramBoolean1) {
      this.KsL += 1;
    }
    for (;;)
    {
      this.mCount += 1;
      if (paramBoolean2) {
        break;
      }
      this.DMw += 1;
      AppMethodBeat.o(36607);
      return;
      this.KsM += 1;
    }
    this.mSuccessCount += 1;
    AppMethodBeat.o(36607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.b
 * JD-Core Version:    0.7.0.1
 */