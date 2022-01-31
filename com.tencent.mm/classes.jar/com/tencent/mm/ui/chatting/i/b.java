package com.tencent.mm.ui.chatting.i;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static final b vzo = new b();
  public int mCount;
  public int mSuccessCount;
  public int qPO;
  public int vzp;
  public int vzq;
  public int vzr;
  
  public static void ar(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s cleanCount:%s count:%s ", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > 0)
    {
      f.nEG.a(403L, 67L, 1L, true);
      f.nEG.a(403L, 68L, paramInt1, true);
    }
    f.nEG.a(403L, 70L, paramInt2, true);
    if (paramInt2 <= 5)
    {
      f.nEG.a(403L, 71L, 1L, true);
      return;
    }
    if (paramInt2 <= 10)
    {
      f.nEG.a(403L, 72L, 1L, true);
      return;
    }
    if (paramInt2 <= 20)
    {
      f.nEG.a(403L, 73L, 1L, true);
      return;
    }
    if (paramInt2 <= 30)
    {
      f.nEG.a(403L, 74L, 1L, true);
      return;
    }
    if (paramInt2 <= 50)
    {
      f.nEG.a(403L, 75L, 1L, true);
      return;
    }
    f.nEG.a(403L, 76L, 1L, true);
  }
  
  public static void cGQ()
  {
    f.nEG.a(403L, 77L, 1L, true);
  }
  
  public static void cGR()
  {
    f.nEG.a(403L, 41L, 1L, false);
  }
  
  public static void cGS()
  {
    f.nEG.a(403L, 78L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.b
 * JD-Core Version:    0.7.0.1
 */