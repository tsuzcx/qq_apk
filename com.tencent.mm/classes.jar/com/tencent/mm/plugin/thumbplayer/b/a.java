package com.tencent.mm.plugin.thumbplayer.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "", "()V", "TAG", "", "runningPreloadTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "Lkotlin/collections/HashMap;", "runningStreamTaskMap", "streamFinishResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "streamFinishTask", "init", "", "isVideoDataAvailable", "", "mediaId", "offset", "length", "release", "requestVideoData", "duration", "callback", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "startJniPreloadTask", "task", "startJniStreamTask", "startPreloadDownloadTask", "", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "startPreloadDownloadTaskAsync", "createCallback", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "startStreamDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "startStreamDownloadTaskAsync", "stopAllJniStreamTask", "stopJniPreloadTask", "stopJniStreamTask", "downloadResult", "stopPreloadDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "stopStreamDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "PreloadTaskCallback", "StreamTaskCallback", "plugin-thumbplayer_release"})
public final class a
{
  public final HashMap<String, h> BpN;
  public final HashMap<String, h> BpO;
  public final HashMap<String, h> BpP;
  public final HashMap<String, com.tencent.mm.i.d> BpQ;
  public final String TAG;
  
  public a()
  {
    AppMethodBeat.i(217085);
    this.TAG = "MicroMsg.TP.CdnTaskController";
    this.BpN = new HashMap();
    this.BpO = new HashMap();
    this.BpP = new HashMap();
    this.BpQ = new HashMap();
    AppMethodBeat.o(217085);
  }
  
  public final int a(final String paramString, final int paramInt1, final int paramInt2, final c paramc)
  {
    AppMethodBeat.i(217083);
    p.h(paramString, "mediaId");
    ad.i(this.TAG, "requestVideoData in caller thread mediaId:" + paramString + " offset:" + paramInt1 + " length:" + paramInt2);
    if (this.BpN.containsKey(paramString))
    {
      com.tencent.mm.ad.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new c(this, paramString, paramInt1, paramInt2, paramc));
      AppMethodBeat.o(217083);
      return 1;
    }
    AppMethodBeat.o(217083);
    return 0;
  }
  
  public final boolean a(final String paramString, final b paramb, final e parame)
  {
    AppMethodBeat.i(217080);
    p.h(paramString, "mediaId");
    p.h(paramb, "createCallback");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(217080);
      return false;
    }
    ad.i(this.TAG, "startStreamDownloadTaskAsync runningStreamTaskMap:" + this.BpN.keySet());
    com.tencent.mm.ad.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new f(this, paramb, paramString, parame));
    AppMethodBeat.o(217080);
    return true;
  }
  
  public final boolean a(final String paramString, final f paramf)
  {
    AppMethodBeat.i(217079);
    p.h(paramString, "mediaId");
    com.tencent.mm.ad.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new g(this, paramString, paramf));
    AppMethodBeat.o(217079);
    return true;
  }
  
  public final boolean a(final String paramString, final g paramg)
  {
    AppMethodBeat.i(217081);
    p.h(paramString, "mediaId");
    ad.i(this.TAG, "stopStreamDownloadTask " + paramString + ' ' + paramg + " runningStreamTask:" + this.BpN.size());
    com.tencent.mm.ad.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new h(this, paramString, paramg));
    AppMethodBeat.o(217081);
    return true;
  }
  
  public final int az(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217084);
    p.h(paramString, "mediaId");
    if (this.BpN.containsKey(paramString))
    {
      com.tencent.mm.ao.f.aGJ();
      if (com.tencent.mm.ao.a.isVideoDataAvailable(paramString, paramInt1, paramInt2))
      {
        AppMethodBeat.o(217084);
        return 1;
      }
      AppMethodBeat.o(217084);
      return 0;
    }
    AppMethodBeat.o(217084);
    return -1;
  }
  
  final int d(String paramString, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(217082);
    com.tencent.mm.ao.f.aGJ();
    int i = com.tencent.mm.ao.a.c(paramString, paramd);
    if ((i == 0) || (i == -21007) || (i == -21008)) {
      this.BpN.remove(paramString);
    }
    ad.i(this.TAG, "stopJniStreamTask " + paramString + ' ' + i);
    AppMethodBeat.o(217082);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback;", "Lcom/tencent/mm/cdn/TransportService$CdnTransCallback;", "(Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;)V", "callback", "", "mediaId", "", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "decodePrepareResponse", "", "buff", "getCdnAuthInfo", "", "Ljava/io/ByteArrayOutputStream;", "onPreloadCompleted", "plugin-thumbplayer_release"})
  public final class a
    implements b.a
  {
    public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(217065);
      String str = this.BpR.TAG;
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
        ad.d(str, i);
        if (paramString == null) {
          break label147;
        }
        if (!this.BpR.BpO.containsKey(paramString)) {
          break label140;
        }
        com.tencent.mm.ad.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new a(paramString, this, paramc, paramString, paramd));
        AppMethodBeat.o(217065);
        return 1;
        l = 0L;
        break;
      }
      label140:
      AppMethodBeat.o(217065);
      return 0;
      label147:
      AppMethodBeat.o(217065);
      return 0;
    }
    
    public final int a(final String paramString, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(217064);
      String str = this.BpR.TAG;
      StringBuilder localStringBuilder = new StringBuilder("callback by jni onPreloadCompleted mediaId:").append(paramString).append(" retCode:");
      if (paramd != null) {}
      for (Integer localInteger = Integer.valueOf(paramd.field_retCode);; localInteger = null)
      {
        ad.d(str, localInteger);
        if (paramString == null) {
          break label116;
        }
        if (!this.BpR.BpO.containsKey(paramString)) {
          break;
        }
        com.tencent.mm.ad.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new b(paramString, this, paramd, paramString));
        AppMethodBeat.o(217064);
        return 1;
      }
      AppMethodBeat.o(217064);
      return 0;
      label116:
      AppMethodBeat.o(217064);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(String paramString1, a.a parama, com.tencent.mm.i.c paramc, String paramString2, com.tencent.mm.i.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback$onPreloadCompleted$1$1"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(String paramString1, a.a parama, com.tencent.mm.i.d paramd, String paramString2)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback;", "Lcom/tencent/mm/modelcdntran/CdnTransportEngine$CdnOnlineVideoCallback;", "(Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;)V", "callback", "", "mediaId", "", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDataAvailable", "offset", "length", "onDownloadToEnd", "onMoovReady", "svrflag", "plugin-thumbplayer_release"})
  public final class b
    implements com.tencent.mm.ao.a.a
  {
    public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(217072);
      String str = this.BpR.TAG;
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
        ad.d(str, i);
        if (paramString == null) {
          break label147;
        }
        if (!this.BpR.BpN.containsKey(paramString)) {
          break label140;
        }
        com.tencent.mm.ad.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new a(paramString, this, paramc, paramString, paramd));
        AppMethodBeat.o(217072);
        return 1;
        l = 0L;
        break;
      }
      label140:
      AppMethodBeat.o(217072);
      return 0;
      label147:
      AppMethodBeat.o(217072);
      return 0;
    }
    
    public final int d(String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(217069);
      ad.d(this.BpR.TAG, "callback by jni onMoovReady mediaId:" + paramString1 + " offset:" + paramInt1 + " length:" + paramInt2);
      if (paramString1 != null)
      {
        if (this.BpR.BpN.containsKey(paramString1))
        {
          com.tencent.mm.ad.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new c(paramString1, this, paramInt1, paramInt2, paramString2));
          AppMethodBeat.o(217069);
          return 1;
        }
        AppMethodBeat.o(217069);
        return 0;
      }
      AppMethodBeat.o(217069);
      return 0;
    }
    
    public final int p(String paramString, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(217070);
      ad.d(this.BpR.TAG, "callback by jni onDataAvailable mediaId:" + paramString + " offset:" + paramInt1 + " length:" + paramInt2);
      if (paramString != null)
      {
        if (this.BpR.BpN.containsKey(paramString))
        {
          com.tencent.mm.ad.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new b(paramString, this, paramInt1, paramInt2));
          AppMethodBeat.o(217070);
          return 1;
        }
        AppMethodBeat.o(217070);
        return 0;
      }
      AppMethodBeat.o(217070);
      return 0;
    }
    
    public final int q(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(217071);
      ad.d(this.BpR.TAG, "callback by jni onDownloadToEnd mediaId:" + paramString + " offset:" + paramInt1 + " length:" + paramInt2);
      AppMethodBeat.o(217071);
      return 0;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(String paramString1, a.b paramb, com.tencent.mm.i.c paramc, String paramString2, com.tencent.mm.i.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$onDataAvailable$1$1"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(String paramString, a.b paramb, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$onMoovReady$1$1"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(String paramString1, a.b paramb, int paramInt1, int paramInt2, String paramString2)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(a parama, String paramString, int paramInt1, int paramInt2, c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class d
    extends q
    implements d.g.a.a<z>
  {
    public d(a parama, h paramh, d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class e
    extends q
    implements d.g.a.a<z>
  {
    public e(a parama, b paramb, String paramString, d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(a parama, b paramb, String paramString, e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(a parama, String paramString, f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(a parama, String paramString, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.b.a
 * JD-Core Version:    0.7.0.1
 */