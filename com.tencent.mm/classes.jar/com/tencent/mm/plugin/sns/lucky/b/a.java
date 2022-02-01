package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public final class a
{
  public static void e(int paramInt, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95196);
    if (paramSnsInfo != null)
    {
      paramSnsInfo.getTimeLine();
      if (paramInt == 2) {
        m.y(paramSnsInfo);
      }
      m.A(paramSnsInfo);
      System.currentTimeMillis();
    }
    AppMethodBeat.o(95196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.b.a
 * JD-Core Version:    0.7.0.1
 */