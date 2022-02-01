package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ghn;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/WebViewSecretMsgReporter;", "", "()V", "secretMsgInfo", "Lcom/tencent/mm/protocal/protobuf/WebPageSecretMsgInfo;", "getSecretMsgInfo", "init", "", "intent", "Landroid/content/Intent;", "reportOpen", "Companion", "SecretMsgLaunchAppResult", "SecretMsgOpType", "SecretMsgScene", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as
{
  public static final a WMp;
  public ghn WMq;
  
  static
  {
    AppMethodBeat.i(298198);
    WMp = new a((byte)0);
    AppMethodBeat.o(298198);
  }
  
  public static final void a(ghn paramghn)
  {
    AppMethodBeat.i(298195);
    a.a(paramghn);
    AppMethodBeat.o(298195);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/WebViewSecretMsgReporter$Companion;", "", "()V", "TAG", "", "report", "", "secretMsgInfo", "Lcom/tencent/mm/protocal/protobuf/WebPageSecretMsgInfo;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(ghn paramghn)
    {
      AppMethodBeat.i(298308);
      if (paramghn == null)
      {
        AppMethodBeat.o(298308);
        return;
      }
      h.OAn.b(23341, new Object[] { Integer.valueOf(paramghn.hBm), paramghn.url, Integer.valueOf(paramghn.opType), paramghn.appId, Integer.valueOf(paramghn.scene), paramghn.xIc, Integer.valueOf(paramghn.acdV) });
      AppMethodBeat.o(298308);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.as
 * JD-Core Version:    0.7.0.1
 */