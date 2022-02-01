package com.tencent.mm.plugin.thumbplayer.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.secdata.i;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "", "()V", "TAG", "", "runningPreloadTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "Lkotlin/collections/HashMap;", "runningStreamTaskMap", "streamFinishResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "streamFinishTask", "init", "", "isMediaInRunningStreamTaskMap", "", "mediaId", "isVideoDataAvailable", "", "offset", "length", "release", "requestVideoData", "duration", "callback", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "startJniPreloadTask", "task", "startJniStreamTask", "startPreloadDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "startPreloadDownloadTaskAsync", "createCallback", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "startStreamDownloadTaskAsync", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "stopAllJniStreamTask", "stopJniPreloadTask", "stopJniStreamTask", "downloadResult", "stopPreloadDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "stopStreamDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "PreloadTaskCallback", "StreamTaskCallback", "plugin-thumbplayer_release"})
public final class a
{
  public final HashMap<String, h> MPj;
  public final HashMap<String, h> MPk;
  public final HashMap<String, h> MPl;
  public final HashMap<String, com.tencent.mm.i.d> MPm;
  public final String TAG;
  
  public a()
  {
    AppMethodBeat.i(189641);
    this.TAG = "MicroMsg.TP.CdnTaskController";
    this.MPj = new HashMap();
    this.MPk = new HashMap();
    this.MPl = new HashMap();
    this.MPm = new HashMap();
    AppMethodBeat.o(189641);
  }
  
  private final int d(String paramString, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(189638);
    com.tencent.mm.aq.f.bkh();
    int i = com.tencent.mm.aq.a.c(paramString, paramd);
    if ((i == 0) || (i == -21007) || (i == -21008)) {
      this.MPj.remove(paramString);
    }
    Log.i(this.TAG, "stopJniStreamTask " + paramString + ' ' + i);
    AppMethodBeat.o(189638);
    return i;
  }
  
  public final int a(final String paramString, final int paramInt1, final int paramInt2, final c paramc)
  {
    AppMethodBeat.i(189640);
    p.k(paramString, "mediaId");
    if (this.MPj.containsKey(paramString))
    {
      com.tencent.mm.ae.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new c(this, paramString, paramInt1, paramInt2, paramc));
      AppMethodBeat.o(189640);
      return 1;
    }
    Log.i(this.TAG, "requestVideoData not running id mediaId:" + paramString + " offset:" + paramInt1 + " length:" + paramInt2);
    AppMethodBeat.o(189640);
    return 0;
  }
  
  public final boolean a(final String paramString, final b paramb, final e parame)
  {
    AppMethodBeat.i(189633);
    p.k(paramString, "mediaId");
    p.k(paramb, "createCallback");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(189633);
      return false;
    }
    Log.i(this.TAG, "startStreamDownloadTaskAsync mediaId:".concat(String.valueOf(paramString)));
    com.tencent.mm.ae.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new f(this, paramb, paramString, parame));
    AppMethodBeat.o(189633);
    return true;
  }
  
  public final boolean a(final String paramString, final f paramf)
  {
    AppMethodBeat.i(189632);
    p.k(paramString, "mediaId");
    com.tencent.mm.ae.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new g(this, paramString, paramf));
    AppMethodBeat.o(189632);
    return true;
  }
  
  public final boolean a(final String paramString, final g paramg)
  {
    AppMethodBeat.i(189635);
    p.k(paramString, "mediaId");
    Log.i(this.TAG, "stopStreamDownloadTask " + paramString + ' ' + paramg + " runningStreamTask:" + this.MPj.size());
    com.tencent.mm.ae.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new h(this, paramString, paramg));
    AppMethodBeat.o(189635);
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback;", "Lcom/tencent/mm/cdn/TransportService$CdnTransCallback;", "(Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;)V", "callback", "", "mediaId", "", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "decodePrepareResponse", "", "buff", "getCdnAuthInfo", "", "Ljava/io/ByteArrayOutputStream;", "onPreloadCompleted", "plugin-thumbplayer_release"})
  public final class a
    implements b.a
  {
    public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(190574);
      String str = a.a(this.MPn);
      StringBuilder localStringBuilder = new StringBuilder("callback preload by jni mediaId:").append(paramString).append(" progressFinishLength:");
      long l;
      if (paramc != null)
      {
        l = paramc.field_finishedLength;
        localStringBuilder = localStringBuilder.append(l).append(" sceneResultRet:");
        if (paramd == null) {
          break label134;
        }
      }
      label134:
      for (int i = paramd.field_retCode;; i = 0)
      {
        Log.d(str, i);
        if (paramString == null) {
          break label147;
        }
        if (!a.b(this.MPn).containsKey(paramString)) {
          break label140;
        }
        com.tencent.mm.ae.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new a(paramString, this, paramc, paramString, paramd));
        AppMethodBeat.o(190574);
        return 1;
        l = 0L;
        break;
      }
      label140:
      AppMethodBeat.o(190574);
      return 0;
      label147:
      AppMethodBeat.o(190574);
      return 0;
    }
    
    public final int a(final String paramString, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(190563);
      String str = a.a(this.MPn);
      StringBuilder localStringBuilder = new StringBuilder("callback by jni onPreloadCompleted mediaId:").append(paramString).append(" retCode:");
      if (paramd != null) {}
      for (Integer localInteger = Integer.valueOf(paramd.field_retCode);; localInteger = null)
      {
        Log.d(str, localInteger);
        if (paramString == null) {
          break label116;
        }
        if (!a.b(this.MPn).containsKey(paramString)) {
          break;
        }
        com.tencent.mm.ae.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new b(paramString, this, paramd, paramString));
        AppMethodBeat.o(190563);
        return 1;
      }
      AppMethodBeat.o(190563);
      return 0;
      label116:
      AppMethodBeat.o(190563);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(String paramString1, a.a parama, com.tencent.mm.i.c paramc, String paramString2, com.tencent.mm.i.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback$onPreloadCompleted$1$1"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(String paramString1, a.a parama, com.tencent.mm.i.d paramd, String paramString2)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback;", "Lcom/tencent/mm/modelcdntran/CdnTransportEngine$CdnOnlineVideoCallback;", "(Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;)V", "callback", "", "mediaId", "", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDataAvailable", "offset", "length", "onDownloadToEnd", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "plugin-thumbplayer_release"})
  public final class b
    implements com.tencent.mm.aq.a.a
  {
    public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(189985);
      String str = a.a(this.MPn);
      StringBuilder localStringBuilder = new StringBuilder("callback stream by jni mediaId:").append(paramString).append(" progressFinishLength:");
      long l;
      if (paramc != null)
      {
        l = paramc.field_finishedLength;
        localStringBuilder = localStringBuilder.append(l).append(" sceneResultRet:");
        if (paramd == null) {
          break label134;
        }
      }
      label134:
      for (int i = paramd.field_retCode;; i = 0)
      {
        Log.d(str, i);
        if (paramString == null) {
          break label147;
        }
        if (!a.c(this.MPn).containsKey(paramString)) {
          break label140;
        }
        com.tencent.mm.ae.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new a(paramString, this, paramc, paramString, paramd));
        AppMethodBeat.o(189985);
        return 1;
        l = 0L;
        break;
      }
      label140:
      AppMethodBeat.o(189985);
      return 0;
      label147:
      AppMethodBeat.o(189985);
      return 0;
    }
    
    public final int d(String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(189967);
      Log.d(a.a(this.MPn), "callback by jni onMoovReady mediaId:" + paramString1 + " offset:" + paramInt1 + " length:" + paramInt2);
      if (paramString1 != null)
      {
        if (a.c(this.MPn).containsKey(paramString1))
        {
          com.tencent.mm.ae.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new c(paramString1, this, paramInt1, paramInt2, paramString2));
          AppMethodBeat.o(189967);
          return 1;
        }
        AppMethodBeat.o(189967);
        return 0;
      }
      AppMethodBeat.o(189967);
      return 0;
    }
    
    public final int q(String paramString, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(189974);
      Log.d(a.a(this.MPn), "callback by jni onDataAvailable mediaId:" + paramString + " offset:" + paramInt1 + " length:" + paramInt2);
      if (paramString != null)
      {
        if (a.c(this.MPn).containsKey(paramString))
        {
          com.tencent.mm.ae.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new b(paramString, this, paramInt1, paramInt2));
          AppMethodBeat.o(189974);
          return 1;
        }
        AppMethodBeat.o(189974);
        return 0;
      }
      AppMethodBeat.o(189974);
      return 0;
    }
    
    public final int r(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(189978);
      Log.d(a.a(this.MPn), "callback by jni onDownloadToEnd mediaId:" + paramString + " offset:" + paramInt1 + " length:" + paramInt2);
      AppMethodBeat.o(189978);
      return 0;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(String paramString1, a.b paramb, com.tencent.mm.i.c paramc, String paramString2, com.tencent.mm.i.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$onDataAvailable$1$1"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(String paramString, a.b paramb, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$onMoovReady$1$1"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(String paramString1, a.b paramb, int paramInt1, int paramInt2, String paramString2)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(a parama, String paramString, int paramInt1, int paramInt2, c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    public d(a parama, h paramh, d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public e(a parama, b paramb, String paramString, d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(a parama, b paramb, String paramString, e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(a parama, String paramString, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(a parama, String paramString, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.b.a
 * JD-Core Version:    0.7.0.1
 */