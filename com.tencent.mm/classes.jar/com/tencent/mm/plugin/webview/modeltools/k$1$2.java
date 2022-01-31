package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.protocal.protobuf.aae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

final class k$1$2
  implements Runnable
{
  k$1$2(k.1 param1, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(7027);
    try
    {
      String str = new JSONObject(this.uYw.substring(1, this.uYw.length() - 1).replace("\\\"", "\"")).optString("data");
      if (bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.WebViewReportOnLeaveHelper", "invalid reportData");
        AppMethodBeat.o(7027);
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      for (;;)
      {
        ab.w("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave, ex = %s", new Object[] { localException.getMessage() });
        localObject1 = null;
      }
      ab.i("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave reportData size=%d", new Object[] { Integer.valueOf(localObject1.length()) });
      Object localObject2 = new b.a();
      ((b.a)localObject2).fsX = new aad();
      ((b.a)localObject2).fsY = new aae();
      ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/exitreport";
      ((b.a)localObject2).funcId = 1642;
      localObject2 = ((b.a)localObject2).ado();
      ((aad)((com.tencent.mm.ai.b)localObject2).fsV.fta).wQW = localObject1;
      com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)localObject2, new k.2());
      AppMethodBeat.o(7027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.k.1.2
 * JD-Core Version:    0.7.0.1
 */