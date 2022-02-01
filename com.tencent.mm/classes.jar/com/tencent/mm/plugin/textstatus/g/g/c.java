package com.tencent.mm.plugin.textstatus.g.g;

import android.os.Looper;
import android.os.Message;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/upload/UploadManager;", "", "()V", "TAG", "", "retryHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "clearUploadTask", "", "doCheck", "getLastUploadTask", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPostErrMsg", "makeCdnFail", "postInfo", "makeCgiFail", "errMsg", "reCommitByUser", "retry", "saveUploadTask", "plugin-textstatus_release"})
public final class c
{
  private static final MMHandler MEs;
  public static final c MEt;
  
  static
  {
    AppMethodBeat.i(232344);
    MEt = new c();
    MEs = (MMHandler)new c(Looper.getMainLooper());
    AppMethodBeat.o(232344);
  }
  
  public static void a(al paramal)
  {
    AppMethodBeat.i(232341);
    p.k(paramal, "postInfo");
    Object localObject = aal();
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((MultiProcessMMKV)localObject).encode("upload_cache", paramal.toByteArray()));; localObject = null)
    {
      Log.i("MicroMsg.TextStatus.UploadManager", "saveUploadTask result:" + localObject + " rowId:" + paramal.MFT + " cdnSuccess:" + paramal.MFU + " cdnRetryNum:" + paramal.MFR + " cgiRetryNum:" + paramal.MFS);
      AppMethodBeat.o(232341);
      return;
    }
  }
  
  private static MultiProcessMMKV aal()
  {
    AppMethodBeat.i(232340);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("text_status_upload" + b.aGP());
    AppMethodBeat.o(232340);
    return localMultiProcessMMKV;
  }
  
  public static void cxi()
  {
    AppMethodBeat.i(232336);
    h.ZvG.be((Runnable)a.MEu);
    AppMethodBeat.o(232336);
  }
  
  static void eCf()
  {
    AppMethodBeat.i(232339);
    MEs.sendEmptyMessage(0);
    AppMethodBeat.o(232339);
  }
  
  public static void gmj()
  {
    AppMethodBeat.i(232338);
    Log.i("MicroMsg.TextStatus.UploadManager", "click to reCommit");
    h.ZvG.be((Runnable)b.MEv);
    AppMethodBeat.o(232338);
  }
  
  public static al gmk()
  {
    AppMethodBeat.i(232342);
    Object localObject = aal();
    if (localObject != null) {}
    for (localObject = ((MultiProcessMMKV)localObject).decodeBytes("upload_cache"); localObject == null; localObject = null)
    {
      AppMethodBeat.o(232342);
      return null;
    }
    al localal = new al();
    localal.parseFrom((byte[])localObject);
    AppMethodBeat.o(232342);
    return localal;
  }
  
  public static void gml()
  {
    AppMethodBeat.i(232343);
    MultiProcessMMKV localMultiProcessMMKV = aal();
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.clearAll();
      AppMethodBeat.o(232343);
      return;
    }
    AppMethodBeat.o(232343);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a MEu;
    
    static
    {
      AppMethodBeat.i(232333);
      MEu = new a();
      AppMethodBeat.o(232333);
    }
    
    public final void run()
    {
      AppMethodBeat.i(232332);
      Object localObject1 = c.MEt;
      localObject1 = c.gmk();
      if (localObject1 != null)
      {
        Object localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.gly();
        String str = com.tencent.mm.plugin.auth.a.a.crN();
        p.j(str, "Account.username()");
        localObject2 = ((com.tencent.mm.plugin.textstatus.g.e.f)localObject2).bey(str);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.textstatus.g.e.a)localObject2).field_CreateTime > ((al)localObject1).MFN.createTime))
        {
          Log.w("MicroMsg.TextStatus.UploadManager", "doCheck, last item is new.(cur:" + ((com.tencent.mm.plugin.textstatus.g.e.a)localObject2).field_CreateTime + ", new:" + ((al)localObject1).MFN.createTime + ')');
          localObject2 = com.tencent.mm.plugin.textstatus.h.a.MGJ;
          com.tencent.mm.plugin.textstatus.h.a.c(((al)localObject1).MFV, Long.valueOf(6L));
          localObject1 = c.MEt;
          c.gml();
          AppMethodBeat.o(232332);
          return;
        }
        Log.i("MicroMsg.TextStatus.UploadManager", "trigger upload last post");
        localObject1 = c.MEt;
        c.gmm();
        AppMethodBeat.o(232332);
        return;
      }
      AppMethodBeat.o(232332);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b MEv;
    
    static
    {
      AppMethodBeat.i(238159);
      MEv = new b();
      AppMethodBeat.o(238159);
    }
    
    public final void run()
    {
      AppMethodBeat.i(238156);
      Object localObject1 = c.MEt;
      localObject1 = c.gmk();
      if (localObject1 != null)
      {
        Object localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.gly();
        String str = com.tencent.mm.plugin.auth.a.a.crN();
        p.j(str, "Account.username()");
        localObject2 = ((com.tencent.mm.plugin.textstatus.g.e.f)localObject2).bey(str);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.textstatus.g.e.a)localObject2).field_CreateTime > ((al)localObject1).MFN.createTime))
        {
          Log.w("MicroMsg.TextStatus.UploadManager", "reCommit, last item is new.(cur:" + ((com.tencent.mm.plugin.textstatus.g.e.a)localObject2).field_CreateTime + ", new:" + ((al)localObject1).MFN.createTime + ')');
          localObject2 = com.tencent.mm.plugin.textstatus.h.a.MGJ;
          com.tencent.mm.plugin.textstatus.h.a.c(((al)localObject1).MFV, Long.valueOf(6L));
          localObject1 = c.MEt;
          c.gml();
          AppMethodBeat.o(238156);
          return;
        }
        Log.i("MicroMsg.TextStatus.UploadManager", "reCommit last post");
        if (!((al)localObject1).MFU) {
          ((al)localObject1).MFR = 0;
        }
        ((al)localObject1).MFS = 0;
        ((al)localObject1).errMsg = "";
        ((al)localObject1).MFN.createTime = cm.bfF();
        localObject2 = c.MEt;
        c.a((al)localObject1);
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
        com.tencent.mm.plugin.textstatus.b.f.c(Long.valueOf(((al)localObject1).MFT), 3);
        localObject1 = c.MEt;
        c.gmm();
        AppMethodBeat.o(238156);
        return;
      }
      AppMethodBeat.o(238156);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/model/upload/UploadManager$retryHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-textstatus_release"})
  public static final class c
    extends MMHandler
  {
    c(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(237162);
      p.k(paramMessage, "msg");
      Log.i("MicroMsg.TextStatus.UploadManager", "retryHandler");
      paramMessage = c.MEt;
      paramMessage = c.gmk();
      if (paramMessage != null)
      {
        if (!Util.isNullOrNil(paramMessage.errMsg))
        {
          Log.w("MicroMsg.TextStatus.UploadManager", "business fial " + paramMessage.errMsg);
          AppMethodBeat.o(237162);
          return;
        }
        if (paramMessage.MFU)
        {
          if (paramMessage.MFS > 3)
          {
            localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
            com.tencent.mm.plugin.textstatus.b.f.c(Long.valueOf(paramMessage.MFT), 5);
            AppMethodBeat.o(237162);
          }
        }
        else if (paramMessage.MFR > 5)
        {
          localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
          com.tencent.mm.plugin.textstatus.b.f.c(Long.valueOf(paramMessage.MFT), 5);
          AppMethodBeat.o(237162);
          return;
        }
        if (cm.bfF() - paramMessage.MFN.createTime > 1800L)
        {
          Log.w("MicroMsg.TextStatus.UploadManager", "exceed 30min to fial");
          localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
          com.tencent.mm.plugin.textstatus.b.f.c(Long.valueOf(paramMessage.MFT), 5);
          AppMethodBeat.o(237162);
          return;
        }
        Object localObject = d.MEw;
        d.c(paramMessage);
        AppMethodBeat.o(237162);
        return;
      }
      AppMethodBeat.o(237162);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.g.c
 * JD-Core Version:    0.7.0.1
 */