package com.tencent.mm.ui.chatting.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static final c WZL;
  public int PpQ;
  public int WZM;
  public int WZN;
  public int WZO;
  public int mCount;
  public int mSuccessCount;
  
  static
  {
    AppMethodBeat.i(36612);
    WZL = new c();
    AppMethodBeat.o(36612);
  }
  
  public static void aW(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36608);
    Log.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s cleanCount:%s count:%s ", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > 0)
    {
      f.Iyx.idkeyStat(403L, 67L, 1L, true);
      f.Iyx.idkeyStat(403L, 68L, paramInt1, true);
    }
    f.Iyx.idkeyStat(403L, 70L, paramInt2, true);
    if (paramInt2 <= 5)
    {
      f.Iyx.idkeyStat(403L, 71L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 10)
    {
      f.Iyx.idkeyStat(403L, 72L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 20)
    {
      f.Iyx.idkeyStat(403L, 73L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 30)
    {
      f.Iyx.idkeyStat(403L, 74L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    if (paramInt2 <= 50)
    {
      f.Iyx.idkeyStat(403L, 75L, 1L, true);
      AppMethodBeat.o(36608);
      return;
    }
    f.Iyx.idkeyStat(403L, 76L, 1L, true);
    AppMethodBeat.o(36608);
  }
  
  public static void hTn()
  {
    AppMethodBeat.i(36609);
    f.Iyx.idkeyStat(403L, 77L, 1L, true);
    AppMethodBeat.o(36609);
  }
  
  public static void hTo()
  {
    AppMethodBeat.i(36610);
    f.Iyx.idkeyStat(403L, 41L, 1L, false);
    AppMethodBeat.o(36610);
  }
  
  public static void hTp()
  {
    AppMethodBeat.i(36611);
    f.Iyx.idkeyStat(403L, 78L, 1L, false);
    AppMethodBeat.o(36611);
  }
  
  public final void awB(int paramInt)
  {
    this.WZO += paramInt;
  }
  
  public final void e(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(36607);
    Log.i("MicroMsg.GetChatroomReporter", "[recordFetch] isDown:" + paramBoolean1 + " isSuccess:" + paramBoolean2 + " chatroomid:" + paramString);
    if (paramBoolean1) {
      this.WZM += 1;
    }
    for (;;)
    {
      this.mCount += 1;
      if (paramBoolean2) {
        break;
      }
      this.PpQ += 1;
      AppMethodBeat.o(36607);
      return;
      this.WZN += 1;
    }
    this.mSuccessCount += 1;
    AppMethodBeat.o(36607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.c
 * JD-Core Version:    0.7.0.1
 */