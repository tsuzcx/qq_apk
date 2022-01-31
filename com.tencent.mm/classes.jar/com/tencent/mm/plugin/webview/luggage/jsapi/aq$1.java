package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

final class aq$1
  implements Runnable
{
  aq$1(aq paramaq, JSONObject paramJSONObject, bh.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(6354);
    Object localObject = this.bBa.optJSONArray("appIdArray");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      aq.b((JSONArray)localObject, this.law);
      AppMethodBeat.o(6354);
      return;
    }
    long l = this.bBa.optLong("download_id", -1L);
    localObject = this.bBa.optString("appid");
    FileDownloadTaskInfo localFileDownloadTaskInfo;
    if (l > 0L)
    {
      localFileDownloadTaskInfo = f.bjl().iA(l);
      localObject = localFileDownloadTaskInfo;
      if (localFileDownloadTaskInfo == null) {
        localObject = new FileDownloadTaskInfo();
      }
      aq.b((FileDownloadTaskInfo)localObject, this.law);
      AppMethodBeat.o(6354);
      return;
    }
    if (!bo.isNullOrNil((String)localObject))
    {
      localFileDownloadTaskInfo = f.bjl().JH((String)localObject);
      localObject = localFileDownloadTaskInfo;
      if (localFileDownloadTaskInfo == null) {
        localObject = new FileDownloadTaskInfo();
      }
      aq.b((FileDownloadTaskInfo)localObject, this.law);
      AppMethodBeat.o(6354);
      return;
    }
    this.law.c("fail", null);
    AppMethodBeat.o(6354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aq.1
 * JD-Core Version:    0.7.0.1
 */