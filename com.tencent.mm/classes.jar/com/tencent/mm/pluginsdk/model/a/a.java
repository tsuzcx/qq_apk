package com.tencent.mm.pluginsdk.model.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.lan_cs.SmartServer;
import com.tencent.mm.lan_cs.SmartServer.ServerFileInfo;
import com.tencent.mm.lan_cs.SmartServer.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.edo;
import com.tencent.mm.protocal.protobuf.edp;
import com.tencent.mm.protocal.protobuf.edq;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/file/CgiSendFileUploadMsg;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/SendFileUploadMsgResp;", "attachInfo", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "(Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;)V", "Companion", "app_release"})
public final class a
  extends com.tencent.mm.an.c<edq>
{
  public static final a QXT;
  
  static
  {
    AppMethodBeat.i(225771);
    QXT = new a((byte)0);
    AppMethodBeat.o(225771);
  }
  
  public a(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(225768);
    d.a locala = new d.a();
    edp localedp = new edp();
    p.j(bh.beI(), "MMCore.getAccStg()");
    ca localca = com.tencent.mm.model.c.bbO().Oq(paramc.field_msgInfoId);
    p.j(localca, "msgInfo");
    localedp.fCl = localca.apJ();
    localedp.UhR = String.valueOf(paramc.field_msgInfoId);
    localedp.action = 1;
    Object localObject2 = k.b.OQ(Util.processXml(localca.getContent()));
    if (localObject2 != null)
    {
      if (Util.isNullOrNil(((k.b)localObject2).filemd5))
      {
        com.tencent.mm.aq.f.bkh();
        ((k.b)localObject2).filemd5 = com.tencent.mm.aq.a.Vs(paramc.field_fileFullPath);
        localca.setContent(k.b.a((k.b)localObject2, null, null));
        localObject3 = h.ae(n.class);
        p.j(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
        ((n)localObject3).eSe().a(localca.apG(), localca);
        Log.w("MicroMsg.CgiSendFileUploadMsg", "set filemd5! msgId:" + localca.apG() + " path:" + paramc.field_fileFullPath);
      }
      Object localObject3 = new edo();
      ((edo)localObject3).title = ((k.b)localObject2).title;
      ((edo)localObject3).jmx = ((k.b)localObject2).llY;
      ((edo)localObject3).md5 = ((k.b)localObject2).filemd5;
      ((edo)localObject3).lAW = ((int)u.bBQ(paramc.field_fileFullPath));
      localedp.UhS = ((edo)localObject3);
      localObject2 = c.QXY;
      if (paramc == null) {
        Log.e("MicroMsg.FileSmartServerMgr", "msgInfo is null, or attachInfo is null");
      }
      for (;;)
      {
        if (localObject1 != null) {
          localedp.UhU = ((String)localObject1);
        }
        localObject1 = new edq();
        ((edq)localObject1).setBaseResponse(new jh());
        ((edq)localObject1).getBaseResponse().Tef = new eaf();
        locala.c((com.tencent.mm.cd.a)localedp);
        locala.d((com.tencent.mm.cd.a)localObject1);
        locala.TW("/cgi-bin/micromsg-bin/sendfileuploadmsg");
        locala.vD(6691);
        c(locala.bgN());
        Log.i("MicroMsg.CgiSendFileUploadMsg", "request msgId:" + paramc.field_msgInfoId + " md5:" + ((edo)localObject3).md5 + " fileExt:" + ((edo)localObject3).jmx + " path:" + paramc.field_fileFullPath + " lanInfo:" + localedp.UhU);
        AppMethodBeat.o(225768);
        return;
        if (!c.QXW) {
          break;
        }
        Log.i("MicroMsg.FileSmartServerMgr", "start no");
        localObject2 = new SmartServer.ServerFileInfo();
        com.tencent.mm.aq.f.bkh();
        ((SmartServer.ServerFileInfo)localObject2).cryptKey = com.tencent.mm.aq.a.bjV();
        ((SmartServer.ServerFileInfo)localObject2).cgi = c.bl(localca);
        ((SmartServer.ServerFileInfo)localObject2).filePath = u.n(paramc.field_fileFullPath, false);
        ((SmartServer.ServerFileInfo)localObject2).idleTimeoutMs = ((int)c.hhM());
        ((SmartServer.ServerFileInfo)localObject2).totalSendTimeoutMs = c.hhN();
        ((SmartServer.ServerFileInfo)localObject2).betweenRequestTimeoutMs = ((int)c.hhO());
        SmartServer.addFileInfo((SmartServer.ServerFileInfo)localObject2);
        localObject1 = ((SmartServer.ServerFileInfo)localObject2).cgi;
        p.j(localObject1, "serverFileInfo.cgi");
        localObject4 = ((SmartServer.ServerFileInfo)localObject2).cryptKey;
        p.j(localObject4, "serverFileInfo.cryptKey");
        localObject1 = c.nn((String)localObject1, (String)localObject4);
        Log.i("MicroMsg.FileSmartServerMgr", "addFileInfo msgInfo:" + localca.apG() + " filePath:" + paramc.field_fileFullPath + " url:" + (String)localObject1 + " aesKey:" + Util.secPrint(((SmartServer.ServerFileInfo)localObject2).cryptKey));
      }
      c.QXW = false;
      Object localObject4 = SmartServer.a((SmartServer.a)localObject2);
      boolean bool;
      if (localObject4 != null)
      {
        localObject2 = localObject4[0];
        localObject1 = localObject2;
        if (!(localObject2 instanceof Integer)) {
          localObject1 = null;
        }
        localObject1 = (Integer)localObject1;
        if (localObject1 != null) {
          if (((Number)localObject1).intValue() > 0)
          {
            bool = true;
            label740:
            c.QXW = bool;
          }
        }
        try
        {
          if (!c.QXW) {
            break label871;
          }
          localObject1 = MMApplicationContext.getContext().getString(R.l.eEV, new Object[] { localObject4[1].toString(), localObject4[2].toString() });
          p.j(localObject1, "MMApplicationContext.get…ring(), it[2].toString())");
          label793:
          c.QXX = (String)localObject1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.FileSmartServerMgr", "start " + localException.getClass().getSimpleName() + ' ' + localException.getMessage());
          }
        }
        Log.i("MicroMsg.FileSmartServerMgr", "start startServer:" + c.QXW + " serverUrl:" + c.QXX);
        label834:
        localObject1 = com.tencent.mm.plugin.report.f.Iyx;
        if (!c.QXW) {
          break label937;
        }
      }
      label937:
      for (long l = 0L;; l = 1L)
      {
        ((com.tencent.mm.plugin.report.f)localObject1).idkeyStat(1680L, l, 1L, false);
        break;
        bool = false;
        break label740;
        bool = false;
        break label740;
        label871:
        localObject1 = "";
        break label793;
        Log.e("MicroMsg.FileSmartServerMgr", "start result is null");
        break label834;
      }
    }
    Log.e("MicroMsg.CgiSendFileUploadMsg", "appMsgContent is null!! msgId:" + paramc.field_msgInfoId + " path:" + paramc.field_fileFullPath);
    AppMethodBeat.o(225768);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/file/CgiSendFileUploadMsg$Companion;", "", "()V", "ACTION_START_UPLOAD", "", "TAG", "", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a.a
 * JD-Core Version:    0.7.0.1
 */