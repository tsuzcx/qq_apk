package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.fkz;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/model/WebViewSecretMsgReporter;", "", "()V", "secretMsgInfo", "Lcom/tencent/mm/protocal/protobuf/WebPageSecretMsgInfo;", "getSecretMsgInfo", "init", "", "intent", "Landroid/content/Intent;", "reportOpen", "Companion", "SecretMsgLaunchAppResult", "SecretMsgOpType", "SecretMsgScene", "plugin-webview_release"})
public final class as
{
  public static final a PVJ;
  public fkz PVI;
  
  static
  {
    AppMethodBeat.i(266327);
    PVJ = new a((byte)0);
    AppMethodBeat.o(266327);
  }
  
  public static final void a(fkz paramfkz)
  {
    AppMethodBeat.i(266328);
    a.a(paramfkz);
    AppMethodBeat.o(266328);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/model/WebViewSecretMsgReporter$Companion;", "", "()V", "TAG", "", "report", "", "secretMsgInfo", "Lcom/tencent/mm/protocal/protobuf/WebPageSecretMsgInfo;", "plugin-webview_release"})
  public static final class a
  {
    public static void a(fkz paramfkz)
    {
      AppMethodBeat.i(215881);
      if (paramfkz == null)
      {
        AppMethodBeat.o(215881);
        return;
      }
      h.IzE.a(23341, new Object[] { Integer.valueOf(paramfkz.fwM), paramfkz.url, Integer.valueOf(paramfkz.opType), paramfkz.appId, Integer.valueOf(paramfkz.scene), paramfkz.UJN, Integer.valueOf(paramfkz.UJO) });
      AppMethodBeat.o(215881);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.as
 * JD-Core Version:    0.7.0.1
 */