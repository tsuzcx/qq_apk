package com.tencent.mm.plugin.textstatus.conversation.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/conversation/service/TextStatusMiniAppService$preRenderMiniApp$1", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
  implements f
{
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(291089);
    Log.d("MicroMsg.TextStatus.TextStatusMiniAppService", "onError() called with: errCode = " + paramInt + ", errMsg = " + paramString);
    AppMethodBeat.o(291089);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(291080);
    Log.d("MicroMsg.TextStatus.TextStatusMiniAppService", "onSuccess() called");
    AppMethodBeat.o(291080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.g.c.a
 * JD-Core Version:    0.7.0.1
 */