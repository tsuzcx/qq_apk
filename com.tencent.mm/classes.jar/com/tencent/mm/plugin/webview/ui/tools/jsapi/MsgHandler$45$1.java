package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.j.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

class MsgHandler$45$1
  extends IListener<com.tencent.mm.autogen.a.j>
{
  MsgHandler$45$1(j.90 param90, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(297178);
    this.__eventId = com.tencent.mm.autogen.a.j.class.getName().hashCode();
    AppMethodBeat.o(297178);
  }
  
  private boolean a(com.tencent.mm.autogen.a.j paramj)
  {
    HashMap localHashMap = null;
    AppMethodBeat.i(297187);
    if (!(paramj instanceof com.tencent.mm.autogen.a.j))
    {
      Log.w("MicroMsg.MsgHandler", "mismatched event");
      AppMethodBeat.o(297187);
      return false;
    }
    if (paramj.hyT.scene != 0)
    {
      Log.i("MicroMsg.MsgHandler", "not jsapi api callback");
      AppMethodBeat.o(297187);
      return false;
    }
    if (paramj.hyT.hyU)
    {
      Log.i("MicroMsg.MsgHandler", "addDownloadApp callback, cancel");
      if (!Util.isNullOrNil(paramj.hyT.errMsg))
      {
        localHashMap = new HashMap();
        localHashMap.put("detail_err_msg", paramj.hyT.errMsg);
      }
      this.XkG.XjI.callback(this.XkG.WEp, "addDownloadApp:cancel", localHashMap);
      AppMethodBeat.o(297187);
      return false;
    }
    if (paramj.hyT.hyV > 0L)
    {
      localHashMap = new HashMap();
      localHashMap.put("download_id", Long.valueOf(paramj.hyT.hyV));
      localHashMap.put("detail_err_msg", paramj.hyT.errMsg);
      Log.i("MicroMsg.MsgHandler", "addDownloadApp callback, ok");
      this.XkG.XjI.callback(this.XkG.WEp, "addDownloadApp:ok", localHashMap);
    }
    for (;;)
    {
      j.x(this.XkG.XjI).dead();
      AppMethodBeat.o(297187);
      return false;
      Log.i("MicroMsg.MsgHandler", "addDownloadApp callback, failed");
      this.XkG.XjI.callback(this.XkG.WEp, "addDownloadApp:fail", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.MsgHandler.45.1
 * JD-Core Version:    0.7.0.1
 */