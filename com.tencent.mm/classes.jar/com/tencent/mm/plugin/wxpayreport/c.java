package com.tencent.mm.plugin.wxpayreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/SoterReport;", "", "()V", "AUTHENTICATION_ERROR", "", "BIO_PAY_ERROR", "INIT_ERROR", "PREPARE_KEY_ERROR", "reportAuthenticationError", "", "errorCode", "errorMsg", "reportInitError", "reportKeyStatusError", "reportPrepareKeyError", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c XIN;
  
  static
  {
    AppMethodBeat.i(261109);
    XIN = new c();
    AppMethodBeat.o(261109);
  }
  
  public static void oP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(261082);
    s.u(paramString1, "errorCode");
    s.u(paramString2, "errorMsg");
    h localh = h.XIV;
    h.O("5", "1", paramString1, paramString2);
    AppMethodBeat.o(261082);
  }
  
  public static void oQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(261088);
    s.u(paramString1, "errorCode");
    s.u(paramString2, "errorMsg");
    h localh = h.XIV;
    h.O("5", "2", paramString1, paramString2);
    AppMethodBeat.o(261088);
  }
  
  public static void oR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(261094);
    s.u(paramString1, "errorCode");
    s.u(paramString2, "errorMsg");
    h localh = h.XIV;
    h.O("5", "3", paramString1, paramString2);
    AppMethodBeat.o(261094);
  }
  
  public static void oS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(261101);
    s.u(paramString1, "errorCode");
    s.u(paramString2, "errorMsg");
    h localh = h.XIV;
    h.O("5", "4", paramString1, paramString2);
    AppMethodBeat.o(261101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.c
 * JD-Core Version:    0.7.0.1
 */