package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Map;

final class g$55
  implements Runnable
{
  g$55(g paramg, i parami) {}
  
  public final void run()
  {
    long l = bk.getLong((String)this.rzk.ndL.get("download_id"), -1L);
    String str = (String)this.rzk.ndL.get("appid");
    Object localObject = (String)this.rzk.ndL.get("appIdArray");
    y.i("MicroMsg.MsgHandler", "doQueryDownloadTask, downloadId = " + l + ",appId = " + str + ",appIds = " + (String)localObject);
    if (!bk.bl((String)localObject))
    {
      g.a(this.rzi, (String)localObject, this.rzk);
      return;
    }
    if (l > 0L)
    {
      localObject = d.aFP().dd(l);
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        str = "default";
      }
    }
    for (;;)
    {
      y.i("MicroMsg.MsgHandler", "doQueryDownloadTask, state = " + str);
      HashMap localHashMap = new HashMap();
      localHashMap.put("state", str);
      localHashMap.put("download_id", Long.valueOf(((FileDownloadTaskInfo)localObject).id));
      if ((str == "downloading") && (((FileDownloadTaskInfo)localObject).hFz != 0L)) {
        localHashMap.put("progress", Long.valueOf(((float)((FileDownloadTaskInfo)localObject).iPM / (float)((FileDownloadTaskInfo)localObject).hFz * 100.0F)));
      }
      g.a(this.rzi, this.rzk, "query_download_task:ok", localHashMap);
      return;
      if (!bk.bl(str))
      {
        localObject = d.aFP().zL(str);
        break;
      }
      y.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, invalid downloadId = " + l + " or appid is null");
      g.a(this.rzi, this.rzk, "query_download_task:fail", null);
      return;
      y.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, api not support");
      g.a(this.rzi, this.rzk, "query_download_task:fail_apilevel_too_low", null);
      return;
      str = "downloading";
      continue;
      if (e.bK(((FileDownloadTaskInfo)localObject).path))
      {
        str = "download_succ";
      }
      else
      {
        str = "default";
        continue;
        str = "download_pause";
        continue;
        str = "download_fail";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.55
 * JD-Core Version:    0.7.0.1
 */