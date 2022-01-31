package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONArray;
import org.json.JSONObject;

final class ah$1
  implements Runnable
{
  ah$1(ah paramah, JSONObject paramJSONObject, aw.a parama) {}
  
  public final void run()
  {
    Object localObject = this.gbZ.optJSONArray("appIdArray");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      ah.b((JSONArray)localObject, this.iRM);
      return;
    }
    long l = this.gbZ.optLong("download_id", -1L);
    localObject = this.gbZ.optString("appid");
    FileDownloadTaskInfo localFileDownloadTaskInfo;
    if (l > 0L)
    {
      localFileDownloadTaskInfo = d.aFP().dd(l);
      localObject = localFileDownloadTaskInfo;
      if (localFileDownloadTaskInfo == null) {
        localObject = new FileDownloadTaskInfo();
      }
      ah.b((FileDownloadTaskInfo)localObject, this.iRM);
      return;
    }
    if (!bk.bl((String)localObject))
    {
      localFileDownloadTaskInfo = d.aFP().zL((String)localObject);
      localObject = localFileDownloadTaskInfo;
      if (localFileDownloadTaskInfo == null) {
        localObject = new FileDownloadTaskInfo();
      }
      ah.b((FileDownloadTaskInfo)localObject, this.iRM);
      return;
    }
    this.iRM.e("fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ah.1
 * JD-Core Version:    0.7.0.1
 */