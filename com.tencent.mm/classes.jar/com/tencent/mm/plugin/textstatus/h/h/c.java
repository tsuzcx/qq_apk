package com.tencent.mm.plugin.textstatus.h.h;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.h.f.g;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/upload/UploadManager;", "", "()V", "TAG", "", "retryHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "clearUploadTask", "", "doCheck", "getLastUploadTask", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPostErrMsg", "makeCdnFail", "postInfo", "makeCgiFail", "errMsg", "reCommitByUser", "retry", "saveUploadTask", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c Tob;
  private static final MMHandler Toc;
  
  static
  {
    AppMethodBeat.i(290689);
    Tob = new c();
    Toc = (MMHandler)new a(Looper.getMainLooper());
    AppMethodBeat.o(290689);
  }
  
  public static void a(bg parambg)
  {
    AppMethodBeat.i(290661);
    s.u(parambg, "postInfo");
    Object localObject = aBP();
    if (localObject == null) {}
    for (localObject = null;; localObject = Boolean.valueOf(((MultiProcessMMKV)localObject).encode("upload_cache", parambg.toByteArray())))
    {
      Log.i("MicroMsg.TextStatus.UploadManager", "saveUploadTask result:" + localObject + " rowId:" + parambg.Tqo + " cdnSuccess:" + parambg.Tqp + " cdnRetryNum:" + parambg.Tqm + " cgiRetryNum:" + parambg.Tqn);
      AppMethodBeat.o(290661);
      return;
    }
  }
  
  private static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(290652);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(s.X("text_status_upload", Integer.valueOf(com.tencent.mm.kernel.b.aZP())));
    AppMethodBeat.o(290652);
    return localMultiProcessMMKV;
  }
  
  public static void cZW()
  {
    AppMethodBeat.i(290635);
    h.ahAA.bm(c..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(290635);
  }
  
  public static void hHT()
  {
    AppMethodBeat.i(290639);
    Log.i("MicroMsg.TextStatus.UploadManager", "click to reCommit");
    h.ahAA.bm(c..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(290639);
  }
  
  public static bg hHU()
  {
    AppMethodBeat.i(290666);
    Object localObject = aBP();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((MultiProcessMMKV)localObject).decodeBytes("upload_cache"))
    {
      AppMethodBeat.o(290666);
      return null;
    }
    bg localbg = new bg();
    localbg.parseFrom((byte[])localObject);
    AppMethodBeat.o(290666);
    return localbg;
  }
  
  public static void hHV()
  {
    AppMethodBeat.i(290671);
    MultiProcessMMKV localMultiProcessMMKV = aBP();
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.clearAll();
    }
    AppMethodBeat.o(290671);
  }
  
  private static final void hHW()
  {
    AppMethodBeat.i(290674);
    bg localbg = hHU();
    if (localbg != null)
    {
      Object localObject = f.TjQ;
      localObject = f.hGH().bdY(a.cUx());
      if ((localObject != null) && (((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_CreateTime > localbg.Tqi.createTime))
      {
        Log.w("MicroMsg.TextStatus.UploadManager", "doCheck, last item is new.(cur:" + ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_CreateTime + ", new:" + localbg.Tqi.createTime + ')');
        localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.d(localbg.Tqq, Long.valueOf(6L));
        hHV();
        AppMethodBeat.o(290674);
        return;
      }
      Log.i("MicroMsg.TextStatus.UploadManager", "trigger upload last post");
      retry();
    }
    AppMethodBeat.o(290674);
  }
  
  private static final void hHX()
  {
    AppMethodBeat.i(290682);
    bg localbg = hHU();
    if (localbg != null)
    {
      Object localObject = f.TjQ;
      localObject = f.hGH().bdY(a.cUx());
      if ((localObject != null) && (((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_CreateTime > localbg.Tqi.createTime))
      {
        Log.w("MicroMsg.TextStatus.UploadManager", "reCommit, last item is new.(cur:" + ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_CreateTime + ", new:" + localbg.Tqi.createTime + ')');
        localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.d(localbg.Tqq, Long.valueOf(6L));
        hHV();
        AppMethodBeat.o(290682);
        return;
      }
      Log.i("MicroMsg.TextStatus.UploadManager", "reCommit last post");
      if (!localbg.Tqp) {
        localbg.Tqm = 0;
      }
      localbg.Tqn = 0;
      localbg.errMsg = "";
      localbg.Tqi.createTime = cn.getSyncServerTimeSecond();
      a(localbg);
      localObject = f.TjQ;
      f.d(Long.valueOf(localbg.Tqo), 3);
      retry();
    }
    AppMethodBeat.o(290682);
  }
  
  static void retry()
  {
    AppMethodBeat.i(290645);
    Toc.sendEmptyMessage(0);
    AppMethodBeat.o(290645);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/model/upload/UploadManager$retryHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends MMHandler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(290628);
      s.u(paramMessage, "msg");
      Log.i("MicroMsg.TextStatus.UploadManager", "retryHandler");
      paramMessage = c.Tob;
      paramMessage = c.hHU();
      if (paramMessage != null)
      {
        if (!Util.isNullOrNil(paramMessage.errMsg))
        {
          Log.w("MicroMsg.TextStatus.UploadManager", s.X("business fial ", paramMessage.errMsg));
          AppMethodBeat.o(290628);
          return;
        }
        if (paramMessage.Tqp)
        {
          if (paramMessage.Tqn > 3)
          {
            localObject = f.TjQ;
            f.d(Long.valueOf(paramMessage.Tqo), 5);
            AppMethodBeat.o(290628);
          }
        }
        else if (paramMessage.Tqm > 5)
        {
          localObject = f.TjQ;
          f.d(Long.valueOf(paramMessage.Tqo), 5);
          AppMethodBeat.o(290628);
          return;
        }
        if (cn.getSyncServerTimeSecond() - paramMessage.Tqi.createTime > 1800L)
        {
          Log.w("MicroMsg.TextStatus.UploadManager", "exceed 30min to fial");
          localObject = f.TjQ;
          f.d(Long.valueOf(paramMessage.Tqo), 5);
          AppMethodBeat.o(290628);
          return;
        }
        Object localObject = d.Tod;
        d.c(paramMessage);
      }
      AppMethodBeat.o(290628);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.h.c
 * JD-Core Version:    0.7.0.1
 */