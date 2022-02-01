package com.tencent.mm.pluginsdk.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.lan_cs.SmartServer;
import com.tencent.mm.lan_cs.SmartServer.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/file/FileSmartServerMgr;", "Lcom/tencent/mm/lan_cs/SmartServer$Callback;", "()V", "TAG", "", "logoutListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "serverUrl", "startServer", "", "addFileInfo", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "attachInfo", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "getBetweenRequestTimeoutMsConfig", "", "getFileCgi", "getIdleTimeoutMsConfig", "getLanInfo", "cgi", "aesKey", "getTotalSendTimeoutMsConfig", "onSendFail", "", "error_code", "onSendProgressChange", "total_size", "send_succ_size", "onSendSucc", "removeFileInfo", "start", "stop", "app_release"})
public final class c
  implements SmartServer.a
{
  static boolean QXW;
  static String QXX;
  public static final c QXY;
  private static final IListener<mr> logoutListener;
  
  static
  {
    AppMethodBeat.i(280289);
    QXY = new c();
    QXX = "";
    IListener localIListener = (IListener)new a();
    logoutListener = localIListener;
    localIListener.alive();
    AppMethodBeat.o(280289);
  }
  
  public static void bk(ca paramca)
  {
    AppMethodBeat.i(280282);
    if (paramca != null)
    {
      paramca = bl(paramca);
      int i = SmartServer.removeFileInfo(paramca);
      Log.i("MicroMsg.FileSmartServerMgr", "removeFileInfo cgi:" + paramca + ' ' + i);
      AppMethodBeat.o(280282);
      return;
    }
    Log.e("MicroMsg.FileSmartServerMgr", "removeFileInfo msgInfo is null");
    AppMethodBeat.o(280282);
  }
  
  public static String bl(ca paramca)
  {
    AppMethodBeat.i(280285);
    p.k(paramca, "msgInfo");
    if (QXW)
    {
      paramca = "/lan_" + paramca.apJ() + '_' + com.tencent.mm.kernel.b.aGQ() + '_' + paramca.apG() + '_' + paramca.getCreateTime();
      AppMethodBeat.o(280285);
      return paramca;
    }
    AppMethodBeat.o(280285);
    return "";
  }
  
  public static long hhM()
  {
    AppMethodBeat.i(280286);
    long l = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFk, 60000L);
    AppMethodBeat.o(280286);
    return l;
  }
  
  public static int hhN()
  {
    AppMethodBeat.i(280287);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFl, -1);
    AppMethodBeat.o(280287);
    return i;
  }
  
  public static long hhO()
  {
    AppMethodBeat.i(280288);
    long l = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFm, 60000L);
    AppMethodBeat.o(280288);
    return l;
  }
  
  public static String nn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(280284);
    p.k(paramString1, "cgi");
    p.k(paramString2, "aesKey");
    paramString1 = QXX + paramString1 + ';' + paramString2;
    AppMethodBeat.o(280284);
    return paramString1;
  }
  
  public static void stop()
  {
    AppMethodBeat.i(280280);
    SmartServer.stopSmartServer();
    x localx = x.aazN;
    QXW = false;
    Log.i("MicroMsg.FileSmartServerMgr", "stop result:".concat(String.valueOf(localx)));
    AppMethodBeat.o(280280);
  }
  
  public final void onSendFail(String paramString, int paramInt)
  {
    AppMethodBeat.i(280278);
    Log.w("MicroMsg.FileSmartServerMgr", "onSendFail " + paramString + ", " + paramInt);
    f.Iyx.idkeyStat(1680L, 4L, 1L, false);
    AppMethodBeat.o(280278);
  }
  
  public final void onSendProgressChange(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(280274);
    Log.w("MicroMsg.FileSmartServerMgr", "onSendProgressChange " + paramString + ' ' + paramLong1 + ' ' + paramLong2);
    AppMethodBeat.o(280274);
  }
  
  public final void onSendSucc(String paramString)
  {
    AppMethodBeat.i(280276);
    Log.w("MicroMsg.FileSmartServerMgr", "onSendSucc ".concat(String.valueOf(paramString)));
    f.Iyx.idkeyStat(1680L, 3L, 1L, false);
    AppMethodBeat.o(280276);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/model/file/FileSmartServerMgr$logoutListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "callback", "", "event", "app_release"})
  public static final class a
    extends IListener<mr>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a.c
 * JD-Core Version:    0.7.0.1
 */