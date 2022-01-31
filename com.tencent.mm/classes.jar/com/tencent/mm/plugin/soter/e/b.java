package com.tencent.mm.plugin.soter.e;

import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.f;

public final class b
{
  public static void a(boolean paramBoolean1, boolean paramBoolean2, g paramg)
  {
    y.v("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    try
    {
      long l = System.currentTimeMillis();
      f.p(Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2)).d(new a()).d(new c()).d(new d()).a(new b.2(paramg)).a(new b.1(l, paramg));
      return;
    }
    catch (Exception localException)
    {
      do
      {
        y.printErrStackTrace("MicroMsg.SoterInitManager", localException, "alvinluo exception when init soter: %s", new Object[] { localException.getMessage() });
        com.tencent.mm.plugin.soter.d.a.eg(4, 1001);
      } while (paramg == null);
      paramg.ai(-1, "system error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.b
 * JD-Core Version:    0.7.0.1
 */