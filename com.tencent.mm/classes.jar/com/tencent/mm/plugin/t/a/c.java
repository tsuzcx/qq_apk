package com.tencent.mm.plugin.t.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

public final class c
{
  private static final a ARS;
  private static final b ART;
  
  static
  {
    AppMethodBeat.i(224090);
    ARS = new a()
    {
      public final void eBu()
      {
        AppMethodBeat.i(224086);
        Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader savePayTestEnvIDs");
        AppMethodBeat.o(224086);
      }
      
      public final void gL(Context paramAnonymousContext)
      {
        AppMethodBeat.i(224088);
        Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader showPayTestEnvIDsUI");
        u.makeText(paramAnonymousContext, "不支持此功能， 需要支付测试包编译参数。", 1).show();
        AppMethodBeat.o(224088);
      }
      
      public final void sC(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(224087);
        Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader setPayTestEnvID2RR, isKinda: ".concat(String.valueOf(paramAnonymousBoolean)));
        AppMethodBeat.o(224087);
      }
    };
    ART = new b() {};
    AppMethodBeat.o(224090);
  }
  
  public static a eBv()
  {
    AppMethodBeat.i(224089);
    a locala = (a)g.af(a.class);
    if (locala != null)
    {
      h.CyF.idkeyStat(1490L, 0L, 1L, false);
      AppMethodBeat.o(224089);
      return locala;
    }
    locala = ARS;
    AppMethodBeat.o(224089);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.t.a.c
 * JD-Core Version:    0.7.0.1
 */