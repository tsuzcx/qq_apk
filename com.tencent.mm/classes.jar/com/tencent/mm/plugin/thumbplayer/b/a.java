package com.tencent.mm.plugin.thumbplayer.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.y;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "", "()V", "TAG", "", "runningPreloadTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "Lkotlin/collections/HashMap;", "runningStreamTaskMap", "streamFinishResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "streamFinishTask", "init", "", "isVideoDataAvailable", "", "mediaId", "offset", "length", "release", "requestVideoData", "duration", "callback", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "startJniPreloadTask", "task", "startJniStreamTask", "startPreloadDownloadTask", "", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "startStreamDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "startStreamDownloadTaskAsync", "createCallback", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "stopAllJniStreamTask", "stopJniPreloadTask", "stopJniStreamTask", "downloadResult", "stopPreloadDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "stopStreamDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "PreloadTaskCallback", "StreamTaskCallback", "plugin-thumbplayer_release"})
public final class a
{
  public final String TAG;
  public final HashMap<String, h> zYi;
  public final HashMap<String, h> zYj;
  public final HashMap<String, h> zYk;
  public final HashMap<String, com.tencent.mm.i.d> zYl;
  
  public a()
  {
    AppMethodBeat.i(209673);
    this.TAG = "MicroMsg.TP.CdnTaskController";
    this.zYi = new HashMap();
    this.zYj = new HashMap();
    this.zYk = new HashMap();
    this.zYl = new HashMap();
    AppMethodBeat.o(209673);
  }
  
  public final boolean a(final String paramString, final b paramb, final e parame)
  {
    AppMethodBeat.i(209670);
    k.h(paramString, "mediaId");
    k.h(paramb, "createCallback");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(209670);
      return false;
    }
    com.tencent.mm.ac.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new e(this, paramb, paramString, parame));
    AppMethodBeat.o(209670);
    return true;
  }
  
  public final boolean a(final String paramString, final g paramg)
  {
    AppMethodBeat.i(209671);
    k.h(paramString, "mediaId");
    ac.i(this.TAG, "stopStreamDownloadTask " + paramString + ' ' + paramg + " runningStreamTask:" + this.zYi.keySet());
    com.tencent.mm.ac.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new g(this, paramString, paramg));
    AppMethodBeat.o(209671);
    return true;
  }
  
  final int d(String paramString, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(209672);
    com.tencent.mm.an.f.aDE();
    int i = com.tencent.mm.an.a.c(paramString, paramd);
    if ((i == 0) || (i == -21007) || (i == -21008)) {
      this.zYi.remove(paramString);
    }
    ac.i(this.TAG, "stopJniStreamTask " + paramString + ' ' + i);
    AppMethodBeat.o(209672);
    return i;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback;", "Lcom/tencent/mm/cdn/TransportService$CdnTransCallback;", "(Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;)V", "callback", "", "mediaId", "", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "decodePrepareResponse", "", "buff", "getCdnAuthInfo", "", "Ljava/io/ByteArrayOutputStream;", "onPreloadCompleted", "plugin-thumbplayer_release"})
  public final class a
    implements b.a
  {
    public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(209657);
      String str = this.zYm.TAG;
      StringBuilder localStringBuilder = new StringBuilder("callback by jni mediaId:").append(paramString).append(" progressFinishLength:");
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
        ac.d(str, i);
        if (paramString == null) {
          break label147;
        }
        if (!this.zYm.zYj.containsKey(paramString)) {
          break label140;
        }
        com.tencent.mm.ac.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new a(paramString, this, paramc, paramString, paramd));
        AppMethodBeat.o(209657);
        return 1;
        l = 0L;
        break;
      }
      label140:
      AppMethodBeat.o(209657);
      return 0;
      label147:
      AppMethodBeat.o(209657);
      return 0;
    }
    
    public final int a(final String paramString, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(209656);
      String str = this.zYm.TAG;
      StringBuilder localStringBuilder = new StringBuilder("callback by jni onPreloadCompleted mediaId:").append(paramString).append(" retCode:");
      if (paramd != null) {}
      for (Integer localInteger = Integer.valueOf(paramd.field_retCode);; localInteger = null)
      {
        ac.d(str, localInteger);
        if (paramString == null) {
          break label116;
        }
        if (!this.zYm.zYj.containsKey(paramString)) {
          break;
        }
        com.tencent.mm.ac.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new b(paramString, this, paramd, paramString));
        AppMethodBeat.o(209656);
        return 1;
      }
      AppMethodBeat.o(209656);
      return 0;
      label116:
      AppMethodBeat.o(209656);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(String paramString1, a.a parama, com.tencent.mm.i.c paramc, String paramString2, com.tencent.mm.i.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback$onPreloadCompleted$1$1"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(String paramString1, a.a parama, com.tencent.mm.i.d paramd, String paramString2)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback;", "Lcom/tencent/mm/modelcdntran/CdnTransportEngine$CdnOnlineVideoCallback;", "(Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;)V", "callback", "", "mediaId", "", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDataAvailable", "offset", "length", "onDownloadToEnd", "onMoovReady", "svrflag", "plugin-thumbplayer_release"})
  public final class b
    implements com.tencent.mm.an.a.a
  {
    public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(209664);
      String str = this.zYm.TAG;
      StringBuilder localStringBuilder = new StringBuilder("callback by jni mediaId:").append(paramString).append(" progressFinishLength:");
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
        ac.d(str, i);
        if (paramString == null) {
          break label147;
        }
        if (!this.zYm.zYi.containsKey(paramString)) {
          break label140;
        }
        com.tencent.mm.ac.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new a(paramString, this, paramc, paramString, paramd));
        AppMethodBeat.o(209664);
        return 1;
        l = 0L;
        break;
      }
      label140:
      AppMethodBeat.o(209664);
      return 0;
      label147:
      AppMethodBeat.o(209664);
      return 0;
    }
    
    public final int d(String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(209661);
      ac.d(this.zYm.TAG, "callback by jni onMoovReady mediaId:" + paramString1 + " offset:" + paramInt1 + " length:" + paramInt2);
      if (paramString1 != null)
      {
        if (this.zYm.zYi.containsKey(paramString1))
        {
          com.tencent.mm.ac.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new c(paramString1, this, paramInt1, paramInt2, paramString2));
          AppMethodBeat.o(209661);
          return 1;
        }
        AppMethodBeat.o(209661);
        return 0;
      }
      AppMethodBeat.o(209661);
      return 0;
    }
    
    public final int n(String paramString, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(209662);
      ac.d(this.zYm.TAG, "callback by jni onDataAvailable mediaId:" + paramString + " offset:" + paramInt1 + " length:" + paramInt2);
      if (paramString != null)
      {
        if (this.zYm.zYi.containsKey(paramString))
        {
          com.tencent.mm.ac.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new b(paramString, this, paramInt1, paramInt2));
          AppMethodBeat.o(209662);
          return 1;
        }
        AppMethodBeat.o(209662);
        return 0;
      }
      AppMethodBeat.o(209662);
      return 0;
    }
    
    public final int o(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209663);
      ac.d(this.zYm.TAG, "callback by jni onDownloadToEnd mediaId:" + paramString + " offset:" + paramInt1 + " length:" + paramInt2);
      AppMethodBeat.o(209663);
      return 0;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(String paramString1, a.b paramb, com.tencent.mm.i.c paramc, String paramString2, com.tencent.mm.i.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$onDataAvailable$1$1"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(String paramString, a.b paramb, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback$onMoovReady$1$1"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(String paramString1, a.b paramb, int paramInt1, int paramInt2, String paramString2)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public c(a parama, String paramString, int paramInt1, int paramInt2, c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public d(a parama, h paramh, d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(a parama, b paramb, String paramString, e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public f(a parama, String paramString, f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(a parama, String paramString, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.b.a
 * JD-Core Version:    0.7.0.1
 */