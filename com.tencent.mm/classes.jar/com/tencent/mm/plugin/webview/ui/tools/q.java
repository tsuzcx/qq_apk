package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewRecentForwardReporter;", "", "()V", "bottomSheetAppearTiming", "", "getBottomSheetAppearTiming", "()J", "setBottomSheetAppearTiming", "(J)V", "bottomSheetDismissTiming", "getBottomSheetDismissTiming", "setBottomSheetDismissTiming", "exitType", "", "getExitType", "()I", "setExitType", "(I)V", "isMpUrl", "", "()Z", "setMpUrl", "(Z)V", "toUser", "", "getToUser", "()Ljava/lang/String;", "setToUser", "(Ljava/lang/String;)V", "clean", "", "tryReport", "context", "Landroid/content/Context;", "getRecentForwardReportInfo", "Lcom/tencent/mm/protocal/protobuf/RecentForwardReportInfo;", "toShowString", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final a WWm;
  boolean WWn;
  long WWo;
  long WWp;
  int lsO = 1;
  String toUser = "";
  
  static
  {
    AppMethodBeat.i(296103);
    WWm = new a((byte)0);
    AppMethodBeat.o(296103);
  }
  
  static String a(emx paramemx)
  {
    AppMethodBeat.i(296101);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecentForwardReportInfo{exitType: ").append(paramemx.lsO).append(", delCount: ").append(paramemx.abrd).append(", delList: ").append(paramemx.XOr).append(", fastListSeq: ").append(paramemx.abre).append(", OneLineCount: ").append(paramemx.abrf).append(", scene: ").append(paramemx.scene).append(", msgType: ").append(paramemx.MFq).append(", innerAppMsgType: ").append(paramemx.abrg).append(", costTime: ").append(paramemx.Qmp).append(", logVersion: ").append(paramemx.abrh).append(", toUser: ").append(paramemx.toUser).append(", startTime: ");
    localStringBuilder.append(paramemx.startTime).append('}');
    paramemx = localStringBuilder.toString();
    AppMethodBeat.o(296101);
    return paramemx;
  }
  
  static emx kU(Context paramContext)
  {
    AppMethodBeat.i(296093);
    if (!(paramContext instanceof UIComponentActivity)) {
      Log.w("MicroMsg.WebViewRecentForwardReporter", s.X("getRecentForwardReportInfo, context: ", paramContext));
    }
    a.a locala = a.PlI;
    paramContext = (emx)a.a.c(paramContext, 14, emx.class);
    AppMethodBeat.o(296093);
    return paramContext;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewRecentForwardReporter$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */