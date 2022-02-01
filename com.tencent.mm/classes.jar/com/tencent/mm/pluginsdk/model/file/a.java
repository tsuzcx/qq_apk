package com.tencent.mm.pluginsdk.model.file;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.lan_cs.SmartServer.Java2C;
import com.tencent.mm.lan_cs.SmartServer.ServerFileInfo;
import com.tencent.mm.lan_cs.SmartServer.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.exf;
import com.tencent.mm.protocal.protobuf.exg;
import com.tencent.mm.protocal.protobuf.exh;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/file/CgiSendFileUploadMsg;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/SendFileUploadMsgResp;", "attachInfo", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "(Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;)V", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<exh>
{
  public static final a.a XTR;
  
  static
  {
    AppMethodBeat.i(244723);
    XTR = new a.a((byte)0);
    AppMethodBeat.o(244723);
  }
  
  public a(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(244718);
    c.a locala = new c.a();
    exg localexg = new exg();
    bh.bCz();
    cc localcc = com.tencent.mm.model.c.bzD().sl(paramc.field_msgInfoId);
    localexg.hHa = localcc.field_talker;
    localexg.abzh = String.valueOf(paramc.field_msgInfoId);
    localexg.action = 1;
    Object localObject2 = k.b.Hf(Util.processXml(localcc.field_content));
    if (localObject2 != null)
    {
      if (Util.isNullOrNil(((k.b)localObject2).filemd5))
      {
        k.bHX();
        ((k.b)localObject2).filemd5 = d.Ns(paramc.field_fileFullPath);
        localcc.setContent(k.b.a((k.b)localObject2, null, null));
        ((n)h.ax(n.class)).gaZ().a(localcc.field_msgId, localcc);
        Log.w("MicroMsg.CgiSendFileUploadMsg", "set filemd5! msgId:" + localcc.field_msgId + " path:" + paramc.field_fileFullPath);
      }
      exf localexf = new exf();
      localexf.title = ((k.b)localObject2).title;
      localexf.lPJ = ((k.b)localObject2).nRe;
      localexf.md5 = ((k.b)localObject2).filemd5;
      localexf.osy = ((int)y.bEl(paramc.field_fileFullPath));
      localexg.abzi = localexf;
      localObject2 = c.XTU;
      if ((localcc == null) || (paramc == null))
      {
        Log.e("MicroMsg.FileSmartServerMgr", "msgInfo is null, or attachInfo is null");
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 != null) {
          localexg.abzk = ((String)localObject1);
        }
        localObject1 = new exh();
        ((exh)localObject1).setBaseResponse(new kd());
        ((exh)localObject1).getBaseResponse().akjO = new etl();
        locala.otE = ((com.tencent.mm.bx.a)localexg);
        locala.otF = ((com.tencent.mm.bx.a)localObject1);
        locala.uri = "/cgi-bin/micromsg-bin/sendfileuploadmsg";
        locala.funcId = 6691;
        c(locala.bEF());
        Log.i("MicroMsg.CgiSendFileUploadMsg", "request msgId:" + paramc.field_msgInfoId + " md5:" + localexf.md5 + " fileExt:" + localexf.lPJ + " path:" + paramc.field_fileFullPath + " lanInfo:" + localexg.abzk);
        AppMethodBeat.o(244718);
        return;
        if (!c.XTV) {
          break;
        }
        Log.i("MicroMsg.FileSmartServerMgr", "start no");
        localObject2 = new SmartServer.ServerFileInfo();
        k.bHX();
        ((SmartServer.ServerFileInfo)localObject2).cryptKey = d.bHI();
        ((SmartServer.ServerFileInfo)localObject2).cgi = c.bB(localcc);
        ((SmartServer.ServerFileInfo)localObject2).filePath = y.n(paramc.field_fileFullPath, false);
        ((SmartServer.ServerFileInfo)localObject2).idleTimeoutMs = ((int)c.iIN());
        ((SmartServer.ServerFileInfo)localObject2).totalSendTimeoutMs = c.iIO();
        ((SmartServer.ServerFileInfo)localObject2).betweenRequestTimeoutMs = ((int)c.iIP());
        SmartServer.Java2C.addFileInfo((SmartServer.ServerFileInfo)localObject2);
        localObject1 = ((SmartServer.ServerFileInfo)localObject2).cgi;
        s.s(localObject1, "serverFileInfo.cgi");
        String str = ((SmartServer.ServerFileInfo)localObject2).cryptKey;
        s.s(str, "serverFileInfo.cryptKey");
        localObject1 = c.pi((String)localObject1, str);
        Log.i("MicroMsg.FileSmartServerMgr", "addFileInfo msgInfo:" + localcc.field_msgId + " filePath:" + paramc.field_fileFullPath + " url:" + (String)localObject1 + " aesKey:" + Util.secPrint(((SmartServer.ServerFileInfo)localObject2).cryptKey));
      }
      c.XTV = false;
      com.tencent.mm.lan_cs.SmartServer.mHU = (SmartServer.a)localObject2;
      localObject2 = SmartServer.Java2C.access$000();
      if (localObject2 == null)
      {
        if (localObject1 == null) {
          Log.e("MicroMsg.FileSmartServerMgr", "start result is null");
        }
        localObject1 = f.Ozc;
        if (!c.XTV) {
          break label933;
        }
      }
      label933:
      for (long l = 0L;; l = 1L)
      {
        ((f)localObject1).idkeyStat(1680L, l, 1L, false);
        break;
        localObject1 = localObject2[0];
        label744:
        boolean bool;
        if ((localObject1 instanceof Integer))
        {
          localObject1 = (Integer)localObject1;
          if ((localObject1 == null) || (((Number)localObject1).intValue() <= 0)) {
            break label872;
          }
          bool = true;
          label763:
          c.XTV = bool;
        }
        for (;;)
        {
          try
          {
            if (!c.XTV) {
              continue;
            }
            localObject1 = MMApplicationContext.getContext().getString(R.l.gHO, new Object[] { localObject2[1].toString(), localObject2[2].toString() });
            s.s(localObject1, "{\n                    MM…ring())\n                }");
            c.XTW = (String)localObject1;
          }
          catch (Exception localException)
          {
            label872:
            Log.e("MicroMsg.FileSmartServerMgr", "start " + localException.getClass().getSimpleName() + ' ' + localException.getMessage());
            continue;
          }
          Log.i("MicroMsg.FileSmartServerMgr", "start startServer:" + c.XTV + " serverUrl:" + c.XTW);
          localObject1 = ah.aiuX;
          break;
          localObject1 = null;
          break label744;
          bool = false;
          break label763;
          localObject1 = "";
        }
      }
    }
    Log.e("MicroMsg.CgiSendFileUploadMsg", "appMsgContent is null!! msgId:" + paramc.field_msgInfoId + " path:" + paramc.field_fileFullPath);
    AppMethodBeat.o(244718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.file.a
 * JD-Core Version:    0.7.0.1
 */