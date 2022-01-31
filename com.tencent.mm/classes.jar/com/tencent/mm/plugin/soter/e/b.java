package com.tencent.mm.plugin.soter.e;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vending.g.f;
import com.tencent.soter.core.d.e;

public final class b
{
  public static boolean sow;
  public static int sox;
  private static e soy;
  
  static
  {
    AppMethodBeat.i(156649);
    sow = false;
    soy = new b.1();
    AppMethodBeat.o(156649);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, g paramg)
  {
    AppMethodBeat.i(59357);
    ab.i("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    try
    {
      long l = System.currentTimeMillis();
      f.A(Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2)).e(new a()).e(new c()).e(new d()).a(new b.3(paramg)).a(new b.2(l, paramg));
      AppMethodBeat.o(59357);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SoterInitManager", localException, "alvinluo exception when init soter: %s", new Object[] { localException.getMessage() });
      com.tencent.mm.plugin.soter.d.a.j(4, 1001, 1L);
      if (paramg != null) {
        paramg.aC(-1, "system error");
      }
      AppMethodBeat.o(59357);
    }
  }
  
  public static boolean cyj()
  {
    AppMethodBeat.i(156204);
    SharedPreferences localSharedPreferences = ah.dsQ();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156204);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("init_success", false);
    AppMethodBeat.o(156204);
    return bool;
  }
  
  public static boolean cyk()
  {
    return (Build.VERSION.SDK_INT >= 28) && (!sow) && (sox == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.b
 * JD-Core Version:    0.7.0.1
 */