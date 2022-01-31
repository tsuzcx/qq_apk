package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Map;

final class g$64
  implements Runnable
{
  g$64(g paramg, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(154985);
    long l = bo.getLong((String)this.uZa.pJb.get("download_id"), -1L);
    String str = (String)this.uZa.pJb.get("appid");
    Object localObject = (String)this.uZa.pJb.get("appIdArray");
    ab.i("MicroMsg.MsgHandler", "doQueryDownloadTask, downloadId = " + l + ",appId = " + str + ",appIds = " + (String)localObject);
    if (!bo.isNullOrNil((String)localObject))
    {
      g.a(this.vqm, (String)localObject, this.uZa);
      AppMethodBeat.o(154985);
      return;
    }
    if (l > 0L)
    {
      localObject = f.bjl().iA(l);
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        str = "default";
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.MsgHandler", "doQueryDownloadTask, state = ".concat(String.valueOf(str)));
      HashMap localHashMap = new HashMap();
      localHashMap.put("state", str);
      localHashMap.put("download_id", Long.valueOf(((FileDownloadTaskInfo)localObject).id));
      if (((FileDownloadTaskInfo)localObject).kZa) {
        localHashMap.put("reserve_for_wifi", Integer.valueOf(1));
      }
      if (((FileDownloadTaskInfo)localObject).jyU != 0L)
      {
        l = ((FileDownloadTaskInfo)localObject).kYX * 100L / ((FileDownloadTaskInfo)localObject).jyU;
        float f = (float)((FileDownloadTaskInfo)localObject).kYX * 100.0F / (float)((FileDownloadTaskInfo)localObject).jyU;
        localHashMap.put("progress", Long.valueOf(l));
        localHashMap.put("progress_float", Float.valueOf(f));
      }
      this.vqm.a(this.uZa, "query_download_task:ok", localHashMap);
      AppMethodBeat.o(154985);
      return;
      if (!bo.isNullOrNil(str))
      {
        localObject = f.bjl().JH(str);
        break;
      }
      ab.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, invalid downloadId = " + l + " or appid is null");
      this.vqm.a(this.uZa, "query_download_task:fail", null);
      AppMethodBeat.o(154985);
      return;
      ab.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, api not support");
      this.vqm.a(this.uZa, "query_download_task:fail_apilevel_too_low", null);
      AppMethodBeat.o(154985);
      return;
      str = "downloading";
      continue;
      if (e.cN(((FileDownloadTaskInfo)localObject).path))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.64
 * JD-Core Version:    0.7.0.1
 */