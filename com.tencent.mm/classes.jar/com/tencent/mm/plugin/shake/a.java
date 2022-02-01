package com.tencent.mm.plugin.shake;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mz;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/shake/Reporter;", "", "()V", "enterScene", "", "getEnterScene", "()I", "setEnterScene", "(I)V", "sessionID", "", "tabType", "getTabType", "setTabType", "doReport", "", "action", "shakeActionReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/ShakeActionReportStruct;", "getSessionID", "setSessionID", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static String FUP;
  public static final a PyM;
  private static int enterScene;
  private static int hJx;
  
  static
  {
    AppMethodBeat.i(273517);
    PyM = new a();
    FUP = "";
    AppMethodBeat.o(273517);
  }
  
  public static void a(int paramInt, mz parammz)
  {
    AppMethodBeat.i(273508);
    h.ahAA.r(new a..ExternalSyntheticLambda0(parammz, paramInt), 100L);
    AppMethodBeat.o(273508);
  }
  
  private static final void a(mz parammz, int paramInt)
  {
    AppMethodBeat.i(273513);
    mz localmz = parammz;
    if (parammz == null) {
      localmz = new mz();
    }
    localmz.ilm = paramInt;
    localmz.iqO = localmz.F("SessionID", FUP, true);
    localmz.iOI = System.currentTimeMillis();
    localmz.iHU = enterScene;
    localmz.jcV = hJx;
    localmz.bMH();
    AppMethodBeat.o(273513);
  }
  
  public static void agL(int paramInt)
  {
    enterScene = paramInt;
  }
  
  public static void gWE()
  {
    AppMethodBeat.i(273486);
    FUP = s.X("", Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(273486);
  }
  
  public static String gWF()
  {
    return FUP;
  }
  
  public static void setTabType(int paramInt)
  {
    hJx = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a
 * JD-Core Version:    0.7.0.1
 */