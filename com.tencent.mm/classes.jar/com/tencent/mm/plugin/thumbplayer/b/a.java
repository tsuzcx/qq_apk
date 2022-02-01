package com.tencent.mm.plugin.thumbplayer.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a;
import com.tencent.mm.g.h;
import com.tencent.mm.modelcdntran.d.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "", "()V", "TAG", "", "runningPreloadTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "Lkotlin/collections/HashMap;", "runningStreamTaskMap", "streamFinishResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "streamFinishTask", "init", "", "isMediaInRunningStreamTaskMap", "", "mediaId", "isVideoDataAvailable", "", "offset", "length", "release", "requestVideoData", "duration", "callback", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "startJniPreloadTask", "task", "startJniStreamTask", "startPreloadDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "startPreloadDownloadTaskAsync", "createCallback", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "startStreamDownloadTaskAsync", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "stopAllJniStreamTask", "stopJniPreloadTask", "stopJniStreamTask", "downloadResult", "stopPreloadDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "stopStreamDownloadTask", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "PreloadTaskCallback", "StreamTaskCallback", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final String TAG;
  public final HashMap<String, h> TBQ;
  public final HashMap<String, h> TBR;
  public final HashMap<String, h> TBS;
  public final HashMap<String, com.tencent.mm.g.d> TBT;
  
  public a()
  {
    AppMethodBeat.i(272034);
    this.TAG = "MicroMsg.TP.CdnTaskController";
    this.TBQ = new HashMap();
    this.TBR = new HashMap();
    this.TBS = new HashMap();
    this.TBT = new HashMap();
    AppMethodBeat.o(272034);
  }
  
  private final int d(String paramString, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(272041);
    k.bHX();
    int i = com.tencent.mm.modelcdntran.d.c(paramString, paramd);
    switch (i)
    {
    }
    for (;;)
    {
      Log.i(this.TAG, "stopJniStreamTask " + paramString + ' ' + i);
      AppMethodBeat.o(272041);
      return i;
      this.TBQ.remove(paramString);
    }
  }
  
  public final int a(final String paramString, final int paramInt1, final int paramInt2, final c paramc)
  {
    AppMethodBeat.i(272129);
    s.u(paramString, "mediaId");
    if (this.TBQ.containsKey(paramString))
    {
      com.tencent.mm.ae.d.e("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new c(this, paramString, paramInt1, paramInt2, paramc));
      AppMethodBeat.o(272129);
      return 1;
    }
    Log.i(this.TAG, "requestVideoData not running id mediaId:" + paramString + " offset:" + paramInt1 + " length:" + paramInt2);
    AppMethodBeat.o(272129);
    return 0;
  }
  
  public final boolean a(final String paramString, b paramb, final e parame)
  {
    AppMethodBeat.i(272115);
    s.u(paramString, "mediaId");
    s.u(paramb, "createCallback");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(272115);
      return false;
    }
    Log.i(this.TAG, s.X("startStreamDownloadTaskAsync mediaId:", paramString));
    com.tencent.mm.ae.d.e("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new f(paramb, paramString, this, parame));
    AppMethodBeat.o(272115);
    return true;
  }
  
  public final boolean a(final String paramString, final f paramf)
  {
    AppMethodBeat.i(272105);
    s.u(paramString, "mediaId");
    com.tencent.mm.ae.d.e("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new g(this, paramString, paramf));
    AppMethodBeat.o(272105);
    return true;
  }
  
  public final boolean a(final String paramString, final g paramg)
  {
    AppMethodBeat.i(272123);
    s.u(paramString, "mediaId");
    Log.i(this.TAG, "stopStreamDownloadTask " + paramString + ' ' + paramg + " runningStreamTask:" + this.TBQ.size());
    com.tencent.mm.ae.d.e("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new h(this, paramString, paramg));
    AppMethodBeat.o(272123);
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$PreloadTaskCallback;", "Lcom/tencent/mm/cdn/TransportService$CdnTransCallback;", "(Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;)V", "callback", "", "mediaId", "", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "decodePrepareResponse", "", "buff", "getCdnAuthInfo", "", "Ljava/io/ByteArrayOutputStream;", "onPreloadCompleted", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements b.a
  {
    public a()
    {
      AppMethodBeat.i(272037);
      AppMethodBeat.o(272037);
    }
    
    public final int a(final String paramString, final com.tencent.mm.g.c paramc, final com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(272061);
      Object localObject = a.c(this.TBU);
      StringBuilder localStringBuilder = new StringBuilder("callback preload by jni mediaId:").append(paramString).append(" progressFinishLength:");
      long l;
      if (paramc == null)
      {
        l = 0L;
        localStringBuilder = localStringBuilder.append(l).append(" sceneResultRet:");
        if (paramd != null) {
          break label136;
        }
      }
      label136:
      for (int i = 0;; i = paramd.field_retCode)
      {
        Log.d((String)localObject, i);
        if (paramString == null) {
          break label152;
        }
        localObject = this.TBU;
        if (!a.b((a)localObject).containsKey(paramString)) {
          break label145;
        }
        com.tencent.mm.ae.d.e("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new a((a)localObject, paramString, paramc, paramString, paramd));
        AppMethodBeat.o(272061);
        return 1;
        l = paramc.field_finishedLength;
        break;
      }
      label145:
      AppMethodBeat.o(272061);
      return 0;
      label152:
      AppMethodBeat.o(272061);
      return 0;
    }
    
    public final int a(final String paramString, final com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(272052);
      String str = a.c(this.TBU);
      StringBuilder localStringBuilder = new StringBuilder("callback by jni onPreloadCompleted mediaId:").append(paramString).append(" retCode:");
      if (paramd == null) {}
      for (Object localObject = null;; localObject = Integer.valueOf(paramd.field_retCode))
      {
        Log.d(str, localObject);
        if (paramString == null) {
          break label118;
        }
        localObject = this.TBU;
        if (!a.b((a)localObject).containsKey(paramString)) {
          break;
        }
        com.tencent.mm.ae.d.e("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new b((a)localObject, paramString, paramd, paramString));
        AppMethodBeat.o(272052);
        return 1;
      }
      AppMethodBeat.o(272052);
      return 0;
      label118:
      AppMethodBeat.o(272052);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(a parama, String paramString1, com.tencent.mm.g.c paramc, String paramString2, com.tencent.mm.g.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(a parama, String paramString1, com.tencent.mm.g.d paramd, String paramString2)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController$StreamTaskCallback;", "Lcom/tencent/mm/modelcdntran/CdnTransportEngine$CdnOnlineVideoCallback;", "(Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;)V", "callback", "", "mediaId", "", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDataAvailable", "offset", "length", "onDownloadToEnd", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements d.a
  {
    public b()
    {
      AppMethodBeat.i(272035);
      AppMethodBeat.o(272035);
    }
    
    public final int a(final String paramString, final com.tencent.mm.g.c paramc, final com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(272063);
      Object localObject = a.c(this.TBU);
      StringBuilder localStringBuilder = new StringBuilder("callback stream by jni mediaId:").append(paramString).append(" progressFinishLength:");
      long l;
      if (paramc == null)
      {
        l = 0L;
        localStringBuilder = localStringBuilder.append(l).append(" sceneResultRet:");
        if (paramd != null) {
          break label136;
        }
      }
      label136:
      for (int i = 0;; i = paramd.field_retCode)
      {
        Log.d((String)localObject, i);
        if (paramString == null) {
          break label152;
        }
        localObject = this.TBU;
        if (!a.a((a)localObject).containsKey(paramString)) {
          break label145;
        }
        com.tencent.mm.ae.d.e("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new a((a)localObject, paramString, paramc, paramd, paramString));
        AppMethodBeat.o(272063);
        return 1;
        l = paramc.field_finishedLength;
        break;
      }
      label145:
      AppMethodBeat.o(272063);
      return 0;
      label152:
      AppMethodBeat.o(272063);
      return 0;
    }
    
    public final int bHL()
    {
      return 0;
    }
    
    public final int d(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(272046);
      Log.d(a.c(this.TBU), "callback by jni onMoovReady mediaId:" + paramString1 + " offset:" + paramInt1 + " length:" + paramInt2);
      if (paramString1 != null)
      {
        a locala = this.TBU;
        if (a.a(locala).containsKey(paramString1))
        {
          com.tencent.mm.ae.d.e("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new c(locala, paramString1, paramInt1, paramInt2, paramString2));
          AppMethodBeat.o(272046);
          return 1;
        }
        AppMethodBeat.o(272046);
        return 0;
      }
      AppMethodBeat.o(272046);
      return 0;
    }
    
    public final int t(final String paramString, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(272051);
      Log.d(a.c(this.TBU), "callback by jni onDataAvailable mediaId:" + paramString + " offset:" + paramInt1 + " length:" + paramInt2);
      if (paramString != null)
      {
        a locala = this.TBU;
        if (a.a(locala).containsKey(paramString))
        {
          com.tencent.mm.ae.d.e("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new b(locala, paramString, paramInt1, paramInt2));
          AppMethodBeat.o(272051);
          return 1;
        }
        AppMethodBeat.o(272051);
        return 0;
      }
      AppMethodBeat.o(272051);
      return 0;
    }
    
    public final int u(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272056);
      Log.d(a.c(this.TBU), "callback by jni onDownloadToEnd mediaId:" + paramString + " offset:" + paramInt1 + " length:" + paramInt2);
      AppMethodBeat.o(272056);
      return 0;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(a parama, String paramString1, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, String paramString2)
      {
        super();
      }
      
      private static final void a(a parama, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.secdata.a.b paramb, xc paramxc)
      {
        AppMethodBeat.i(272042);
        s.u(parama, "this$0");
        Log.i(a.c(parama), "save secdata action:" + paramInt + " success:" + paramBoolean);
        AppMethodBeat.o(272042);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(a parama, String paramString, int paramInt1, int paramInt2)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(a parama, String paramString1, int paramInt1, int paramInt2, String paramString2)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama, String paramString, int paramInt1, int paramInt2, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    public d(a parama, h paramh, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    public e(b paramb, String paramString, a parama, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(b paramb, String paramString, a parama, e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(a parama, String paramString, f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(a parama, String paramString, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.b.a
 * JD-Core Version:    0.7.0.1
 */