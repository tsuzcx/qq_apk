package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.j.a;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

class MsgHandler$41
  extends IListener<com.tencent.mm.autogen.a.j>
{
  MsgHandler$41(j paramj, q paramq, p paramp)
  {
    super(paramq);
    AppMethodBeat.i(297433);
    this.__eventId = com.tencent.mm.autogen.a.j.class.getName().hashCode();
    AppMethodBeat.o(297433);
  }
  
  private boolean a(com.tencent.mm.autogen.a.j paramj)
  {
    HashMap localHashMap = null;
    AppMethodBeat.i(297438);
    if (!(paramj instanceof com.tencent.mm.autogen.a.j))
    {
      Log.w("MicroMsg.MsgHandler", "mismatched event");
      AppMethodBeat.o(297438);
      return false;
    }
    if (paramj.hyT.scene != 0)
    {
      Log.i("MicroMsg.MsgHandler", "not jsapi api callback");
      AppMethodBeat.o(297438);
      return false;
    }
    if (paramj.hyT.hyU)
    {
      Log.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, cancel");
      if (!Util.isNullOrNil(paramj.hyT.errMsg))
      {
        localHashMap = new HashMap();
        localHashMap.put("detail_err_msg", paramj.hyT.errMsg);
      }
      this.XjI.callback(this.WEp, "add_download_task:cancel", localHashMap);
      AppMethodBeat.o(297438);
      return false;
    }
    if (paramj.hyT.hyV > 0L)
    {
      localHashMap = new HashMap();
      localHashMap.put("download_id", Long.valueOf(paramj.hyT.hyV));
      localHashMap.put("detail_err_msg", paramj.hyT.errMsg);
      Log.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, ok");
      this.XjI.callback(this.WEp, "add_download_task:ok", localHashMap);
    }
    for (;;)
    {
      j.x(this.XjI).dead();
      AppMethodBeat.o(297438);
      return false;
      Log.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, failed");
      this.XjI.callback(this.WEp, "add_download_task:fail", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.MsgHandler.41
 * JD-Core Version:    0.7.0.1
 */