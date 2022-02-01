package com.tencent.mm.plugin.textstatus.f.h;

import android.os.Looper;
import android.os.Message;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.g;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/upload/UploadManager;", "", "()V", "TAG", "", "retryHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "clearUploadTask", "", "doCheck", "getLastUploadTask", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPostErrMsg", "makeCdnFail", "postInfo", "makeCgiFail", "errMsg", "reCommitByUser", "retry", "saveUploadTask", "plugin-textstatus_release"})
public final class c
{
  private static final MMHandler FZW;
  public static final c FZX;
  
  static
  {
    AppMethodBeat.i(216321);
    FZX = new c();
    FZW = (MMHandler)new c(Looper.getMainLooper());
    AppMethodBeat.o(216321);
  }
  
  private static MultiProcessMMKV VQ()
  {
    AppMethodBeat.i(216317);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("text_status_upload" + com.tencent.mm.kernel.a.azs());
    AppMethodBeat.o(216317);
    return localMultiProcessMMKV;
  }
  
  public static void a(v paramv)
  {
    AppMethodBeat.i(216318);
    p.h(paramv, "postInfo");
    Object localObject = VQ();
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((MultiProcessMMKV)localObject).encode("upload_cache", paramv.toByteArray()));; localObject = null)
    {
      Log.i("MicroMsg.TxtStatus.UploadManager", "saveUploadTask result:" + localObject + " rowId:" + paramv.Gba + " cdnSuccess:" + paramv.Gbb + " cdnRetryNum:" + paramv.GaY + " cgiRetryNum:" + paramv.GaZ);
      AppMethodBeat.o(216318);
      return;
    }
  }
  
  public static void cjR()
  {
    AppMethodBeat.i(216313);
    h.RTc.aX((Runnable)a.FZY);
    AppMethodBeat.o(216313);
  }
  
  static void dYH()
  {
    AppMethodBeat.i(216316);
    FZW.sendEmptyMessage(0);
    AppMethodBeat.o(216316);
  }
  
  public static void fwc()
  {
    AppMethodBeat.i(216314);
    Log.i("MicroMsg.TxtStatus.UploadManager", "click to reCommit");
    h.RTc.aX((Runnable)b.FZZ);
    AppMethodBeat.o(216314);
  }
  
  public static String fwd()
  {
    AppMethodBeat.i(216315);
    String str = null;
    v localv = fwe();
    if (localv != null) {
      str = localv.errMsg;
    }
    AppMethodBeat.o(216315);
    return str;
  }
  
  public static v fwe()
  {
    AppMethodBeat.i(216319);
    Object localObject = VQ();
    if (localObject != null) {}
    for (localObject = ((MultiProcessMMKV)localObject).decodeBytes("upload_cache"); localObject == null; localObject = null)
    {
      AppMethodBeat.o(216319);
      return null;
    }
    v localv = new v();
    localv.parseFrom((byte[])localObject);
    AppMethodBeat.o(216319);
    return localv;
  }
  
  public static void fwf()
  {
    AppMethodBeat.i(216320);
    MultiProcessMMKV localMultiProcessMMKV = VQ();
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.clearAll();
      AppMethodBeat.o(216320);
      return;
    }
    AppMethodBeat.o(216320);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a FZY;
    
    static
    {
      AppMethodBeat.i(216309);
      FZY = new a();
      AppMethodBeat.o(216309);
    }
    
    public final void run()
    {
      AppMethodBeat.i(216308);
      Object localObject1 = c.FZX;
      localObject1 = c.fwe();
      if (localObject1 != null)
      {
        Object localObject2 = f.FXJ;
        localObject2 = f.fvM();
        String str = com.tencent.mm.plugin.auth.a.a.ceA();
        p.g(str, "Account.username()");
        localObject2 = ((com.tencent.mm.plugin.textstatus.f.f.d)localObject2).aTl(str);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_CreateTime > ((v)localObject1).GaU.Gaz))
        {
          Log.w("MicroMsg.TxtStatus.UploadManager", "doCheck, last item is new.(cur:" + ((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_CreateTime + ", new:" + ((v)localObject1).GaU.Gaz + ')');
          localObject2 = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.c(((v)localObject1).Usb, Long.valueOf(6L));
          localObject1 = c.FZX;
          c.fwf();
          AppMethodBeat.o(216308);
          return;
        }
        Log.i("MicroMsg.TxtStatus.UploadManager", "trigger upload last post");
        localObject1 = c.FZX;
        c.fwg();
        AppMethodBeat.o(216308);
        return;
      }
      AppMethodBeat.o(216308);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b FZZ;
    
    static
    {
      AppMethodBeat.i(216311);
      FZZ = new b();
      AppMethodBeat.o(216311);
    }
    
    public final void run()
    {
      AppMethodBeat.i(216310);
      Object localObject1 = c.FZX;
      localObject1 = c.fwe();
      if (localObject1 != null)
      {
        Object localObject2 = f.FXJ;
        localObject2 = f.fvM();
        String str = com.tencent.mm.plugin.auth.a.a.ceA();
        p.g(str, "Account.username()");
        localObject2 = ((com.tencent.mm.plugin.textstatus.f.f.d)localObject2).aTl(str);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_CreateTime > ((v)localObject1).GaU.Gaz))
        {
          Log.w("MicroMsg.TxtStatus.UploadManager", "reCommit, last item is new.(cur:" + ((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_CreateTime + ", new:" + ((v)localObject1).GaU.Gaz + ')');
          localObject2 = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.c(((v)localObject1).Usb, Long.valueOf(6L));
          localObject1 = c.FZX;
          c.fwf();
          AppMethodBeat.o(216310);
          return;
        }
        Log.i("MicroMsg.TxtStatus.UploadManager", "reCommit last post");
        if (!((v)localObject1).Gbb) {
          ((v)localObject1).GaY = 0;
        }
        ((v)localObject1).GaZ = 0;
        ((v)localObject1).errMsg = "";
        ((v)localObject1).GaU.Gaz = cl.aWB();
        localObject2 = c.FZX;
        c.a((v)localObject1);
        localObject2 = f.FXJ;
        f.c(Long.valueOf(((v)localObject1).Gba), 3);
        localObject1 = c.FZX;
        c.fwg();
        AppMethodBeat.o(216310);
        return;
      }
      AppMethodBeat.o(216310);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/model/upload/UploadManager$retryHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-textstatus_release"})
  public static final class c
    extends MMHandler
  {
    c(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(216312);
      p.h(paramMessage, "msg");
      Log.i("MicroMsg.TxtStatus.UploadManager", "retryHandler");
      paramMessage = c.FZX;
      paramMessage = c.fwe();
      if (paramMessage != null)
      {
        if (!Util.isNullOrNil(paramMessage.errMsg))
        {
          Log.w("MicroMsg.TxtStatus.UploadManager", "business fial " + paramMessage.errMsg);
          AppMethodBeat.o(216312);
          return;
        }
        if (paramMessage.Gbb)
        {
          if (paramMessage.GaZ > 3)
          {
            localObject = f.FXJ;
            f.c(Long.valueOf(paramMessage.Gba), 5);
            AppMethodBeat.o(216312);
          }
        }
        else if (paramMessage.GaY > 5)
        {
          localObject = f.FXJ;
          f.c(Long.valueOf(paramMessage.Gba), 5);
          AppMethodBeat.o(216312);
          return;
        }
        if (cl.aWB() - paramMessage.GaU.Gaz > 1800L)
        {
          Log.w("MicroMsg.TxtStatus.UploadManager", "exceed 30min to fial");
          localObject = f.FXJ;
          f.c(Long.valueOf(paramMessage.Gba), 5);
          AppMethodBeat.o(216312);
          return;
        }
        Object localObject = d.Gaa;
        d.b(paramMessage);
        AppMethodBeat.o(216312);
        return;
      }
      AppMethodBeat.o(216312);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.h.c
 * JD-Core Version:    0.7.0.1
 */