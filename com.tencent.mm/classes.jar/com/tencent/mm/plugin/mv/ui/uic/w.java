package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.emx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/RecentForwardReporter;", "", "context", "Landroid/content/Context;", "startTime", "", "(Landroid/content/Context;J)V", "getContext", "()Landroid/content/Context;", "getStartTime", "()J", "setStartTime", "(J)V", "doMultiReport", "", "endTime", "exitType", "", "msgType", "", "scene", "toUser", "reportBack", "reportDialogCanceled", "reportNormalForwardBegin", "reportOtherButtons", "reportRecentForwardSuccess", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  private final Context context;
  private long startTime;
  
  public w(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(287452);
    this.context = paramContext;
    this.startTime = paramLong;
    AppMethodBeat.o(287452);
  }
  
  public final void b(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(287469);
    s.u(paramString1, "msgType");
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject = (emx)a.a.c(this.context, 14, emx.class);
    if (localObject != null) {
      ((emx)localObject).Qmp = ((int)(paramLong - this.startTime));
    }
    if (localObject != null) {
      ((emx)localObject).lsO = paramInt;
    }
    if (localObject != null) {
      ((emx)localObject).MFq = paramString1;
    }
    if (localObject != null) {
      ((emx)localObject).scene = 10;
    }
    if ((paramString2 != null) && (localObject != null)) {
      ((emx)localObject).toUser = paramString2;
    }
    paramString1 = com.tencent.mm.pluginsdk.j.a.XUW;
    com.tencent.mm.pluginsdk.j.a.ly(this.context);
    AppMethodBeat.o(287469);
  }
  
  public final void sN(long paramLong)
  {
    AppMethodBeat.i(287455);
    b(paramLong, 4, "2", null);
    AppMethodBeat.o(287455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.w
 * JD-Core Version:    0.7.0.1
 */