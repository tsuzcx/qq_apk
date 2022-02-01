package com.tencent.mm.pluginsdk.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hh;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/report/ForwardHalfPanelReporter;", "", "()V", "TAG", "", "report24035", "", "context", "Landroid/content/Context;", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a XUW;
  
  static
  {
    AppMethodBeat.i(244497);
    XUW = new a();
    AppMethodBeat.o(244497);
  }
  
  public static void ly(Context paramContext)
  {
    AppMethodBeat.i(244495);
    s.u(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramContext = (emx)a.a.c(paramContext, 14, emx.class);
    if (paramContext != null)
    {
      localObject = new hh();
      ((hh)localObject).iNJ = paramContext.lsO;
      ((hh)localObject).iNK = paramContext.abrd;
      ((hh)localObject).iNL = ((hh)localObject).F("Del_list", paramContext.XOr, true);
      ((hh)localObject).iNM = paramContext.abre;
      ((hh)localObject).iNN = paramContext.abrf;
      ((hh)localObject).iuA = paramContext.scene;
      ((hh)localObject).iNO = ((hh)localObject).F("MsgType", paramContext.MFq, true);
      ((hh)localObject).iNP = ((hh)localObject).F("InnerAppMsgType", paramContext.abrg, true);
      ((hh)localObject).ijA = paramContext.Qmp;
      ((hh)localObject).iNQ = paramContext.abrh;
      ((hh)localObject).iNR = ((hh)localObject).F("ToUser", paramContext.toUser, true);
      ((hh)localObject).bMH();
      paramContext = (com.tencent.mm.plugin.report.a)localObject;
      int i = paramContext.getId();
      paramContext = paramContext.aIF();
      s.s(paramContext, "struct.toShowString()");
      Log.i("MircoMsg.ForwardHalfPanelReporter", "report%s %s", new Object[] { Integer.valueOf(i), n.m(paramContext, "\r\n", " ", false) });
    }
    AppMethodBeat.o(244495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a
 * JD-Core Version:    0.7.0.1
 */