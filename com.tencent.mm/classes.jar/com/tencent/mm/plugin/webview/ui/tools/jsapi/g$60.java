package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.h;
import com.tencent.mm.g.a.h.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class g$60
  extends c<h>
{
  g$60(g paramg, i parami)
  {
    AppMethodBeat.i(154980);
    this.__eventId = h.class.getName().hashCode();
    AppMethodBeat.o(154980);
  }
  
  private boolean a(h paramh)
  {
    AppMethodBeat.i(154981);
    if (!(paramh instanceof h))
    {
      ab.w("MicroMsg.MsgHandler", "mismatched event");
      AppMethodBeat.o(154981);
      return false;
    }
    if (paramh.cmk.scene != 0)
    {
      ab.i("MicroMsg.MsgHandler", "not jsapi api callback");
      AppMethodBeat.o(154981);
      return false;
    }
    if (paramh.cmk.cml)
    {
      ab.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, cancel");
      this.vqm.a(this.uZa, "add_download_task:cancel", null);
      AppMethodBeat.o(154981);
      return false;
    }
    if (paramh.cmk.cmm > 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("download_id", Long.valueOf(paramh.cmk.cmm));
      ab.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, ok");
      this.vqm.a(this.uZa, "add_download_task:ok", localHashMap);
    }
    for (;;)
    {
      a.ymk.d(g.y(this.vqm));
      AppMethodBeat.o(154981);
      return false;
      ab.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, failed");
      this.vqm.a(this.uZa, "add_download_task:fail", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.60
 * JD-Core Version:    0.7.0.1
 */