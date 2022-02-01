package com.tencent.mm.pluginsdk.model.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.lan_cs.SmartServer.Java2C;
import com.tencent.mm.lan_cs.SmartServer.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/file/FileSmartServerMgr;", "Lcom/tencent/mm/lan_cs/SmartServer$Callback;", "()V", "TAG", "", "logoutListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "serverUrl", "startServer", "", "addFileInfo", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "attachInfo", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "getBetweenRequestTimeoutMsConfig", "", "getFileCgi", "getIdleTimeoutMsConfig", "getLanInfo", "cgi", "aesKey", "getTotalSendTimeoutMsConfig", "onSendFail", "", "error_code", "onSendProgressChange", "total_size", "send_succ_size", "onSendSucc", "removeFileInfo", "start", "stop", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements SmartServer.a
{
  public static final c XTU;
  static boolean XTV;
  static String XTW;
  private static final IListener<ny> logoutListener;
  
  static
  {
    AppMethodBeat.i(244744);
    XTU = new c();
    XTW = "";
    IListener localIListener = (IListener)new FileSmartServerMgr.logoutListener.1(com.tencent.mm.app.f.hfK);
    logoutListener = localIListener;
    localIListener.alive();
    AppMethodBeat.o(244744);
  }
  
  public static void bA(cc paramcc)
  {
    AppMethodBeat.i(244721);
    if (paramcc == null) {}
    for (paramcc = null;; paramcc = ah.aiuX)
    {
      if (paramcc == null) {
        Log.e("MicroMsg.FileSmartServerMgr", "removeFileInfo msgInfo is null");
      }
      AppMethodBeat.o(244721);
      return;
      paramcc = bB(paramcc);
      int i = SmartServer.Java2C.removeFileInfo(paramcc);
      Log.i("MicroMsg.FileSmartServerMgr", "removeFileInfo cgi:" + paramcc + ' ' + i);
    }
  }
  
  public static String bB(cc paramcc)
  {
    AppMethodBeat.i(244730);
    s.u(paramcc, "msgInfo");
    if (XTV)
    {
      paramcc = "/lan_" + paramcc.field_talker + '_' + b.aZQ() + '_' + paramcc.field_msgId + '_' + paramcc.getCreateTime();
      AppMethodBeat.o(244730);
      return paramcc;
    }
    AppMethodBeat.o(244730);
    return "";
  }
  
  public static long iIN()
  {
    AppMethodBeat.i(244732);
    long l = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUK, 60000L);
    AppMethodBeat.o(244732);
    return l;
  }
  
  public static int iIO()
  {
    AppMethodBeat.i(244736);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUL, -1);
    AppMethodBeat.o(244736);
    return i;
  }
  
  public static long iIP()
  {
    AppMethodBeat.i(244738);
    long l = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUM, 60000L);
    AppMethodBeat.o(244738);
    return l;
  }
  
  public static String pi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(244725);
    s.u(paramString1, "cgi");
    s.u(paramString2, "aesKey");
    paramString1 = XTW + paramString1 + ';' + paramString2;
    AppMethodBeat.o(244725);
    return paramString1;
  }
  
  public static void stop()
  {
    AppMethodBeat.i(244715);
    SmartServer.Java2C.stopSmartServer();
    ah localah = ah.aiuX;
    XTV = false;
    Log.i("MicroMsg.FileSmartServerMgr", s.X("stop result:", localah));
    AppMethodBeat.o(244715);
  }
  
  public final void onSendFail(String paramString, int paramInt)
  {
    AppMethodBeat.i(244756);
    Log.w("MicroMsg.FileSmartServerMgr", "onSendFail " + paramString + ", " + paramInt);
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1680L, 4L, 1L, false);
    AppMethodBeat.o(244756);
  }
  
  public final void onSendProgressChange(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(244748);
    Log.w("MicroMsg.FileSmartServerMgr", "onSendProgressChange " + paramString + ' ' + paramLong1 + ' ' + paramLong2);
    AppMethodBeat.o(244748);
  }
  
  public final void onSendSucc(String paramString)
  {
    AppMethodBeat.i(244752);
    Log.w("MicroMsg.FileSmartServerMgr", s.X("onSendSucc ", paramString));
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1680L, 3L, 1L, false);
    AppMethodBeat.o(244752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.file.c
 * JD-Core Version:    0.7.0.1
 */