package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "TAG", "", "callbacks", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "", "kotlin.jvm.PlatformType", "", "getInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mediaId", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "addCallback", "cb", "cancel", "dead", "notifyCallbacks", "start", "plugin-recordvideo_release"})
public final class b
  implements a
{
  private final g BPr;
  private final AudioCacheInfo BPs;
  final String TAG;
  private final List<m<Boolean, String, x>> callbacks;
  private final com.tencent.mm.vending.e.b<a> gZm;
  private final String mediaId;
  
  public b(final com.tencent.mm.vending.e.b<a> paramb, final AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75414);
    this.gZm = paramb;
    this.BPs = paramAudioCacheInfo;
    this.TAG = "MicroMsg.AudioDownloadTask";
    this.callbacks = Collections.synchronizedList((List)new ArrayList());
    paramb = this.BPs.cachePath + "_temp";
    paramAudioCacheInfo = this.BPs.cachePath;
    com.tencent.mm.plugin.recordvideo.e.c localc = com.tencent.mm.plugin.recordvideo.e.c.Cic;
    com.tencent.mm.plugin.recordvideo.e.c.aLP(paramb);
    if (paramAudioCacheInfo != null)
    {
      localc = com.tencent.mm.plugin.recordvideo.e.c.Cic;
      com.tencent.mm.plugin.recordvideo.e.c.aLP(paramAudioCacheInfo);
    }
    this.mediaId = ("downaudio_" + this.BPs.BOX);
    this.BPr = new g();
    this.BPr.taskName = "task_AudioDownloadTask";
    this.BPr.gqC = 60;
    this.BPr.gqD = 60;
    this.BPr.field_mediaId = this.mediaId;
    this.BPr.gqB = this.BPs.musicUrl;
    this.BPr.field_fileType = 40001;
    this.BPr.field_fullpath = paramb;
    this.BPr.gqy = ((g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(75406);
        p.h(paramAnonymousString, "mediaId");
        String str2 = this.BPt.TAG;
        Object localObject;
        if (paramAnonymousc != null)
        {
          localObject = paramAnonymousc.toString();
          paramAnonymousc = (com.tencent.mm.i.c)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramAnonymousc = "null";
        }
        if (paramAnonymousd != null)
        {
          String str1 = paramAnonymousd.toString();
          localObject = str1;
          if (str1 != null) {}
        }
        else
        {
          localObject = "null";
        }
        Log.d(str2, "AudioDownloadTask on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, localObject });
        if (paramAnonymousd != null) {
          if (paramAnonymousd.field_retCode == 0)
          {
            Log.i(this.BPt.TAG, "download success " + paramAnonymousString + ' ' + paramAudioCacheInfo);
            s.nx(paramb, paramAudioCacheInfo);
            b.a(this.BPt, true, paramAudioCacheInfo);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(75406);
          return 0;
          Log.w(this.BPt.TAG, "download fail sceneResult " + paramAnonymousd.field_retCode);
          b.a(this.BPt, false, null);
          continue;
          if (paramAnonymousInt != 0)
          {
            Log.w(this.BPt.TAG, "download fail startRet ".concat(String.valueOf(paramAnonymousInt)));
            b.a(this.BPt, false, null);
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(75407);
        p.h(paramAnonymousString, "mediaId");
        p.h(paramAnonymousByteArrayOutputStream, "buff");
        AppMethodBeat.o(75407);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(75408);
        p.h(paramAnonymousString, "mediaId");
        p.h(paramAnonymousArrayOfByte, "inbuf");
        AppMethodBeat.o(75408);
        return new byte[0];
      }
    });
    AppMethodBeat.o(75414);
  }
  
  private final void B(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(75413);
    ??? = this.callbacks;
    p.g(???, "callbacks");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext()) {
        ((m)localIterator.next()).invoke(Boolean.valueOf(paramBoolean), paramString);
      }
    }
    paramString = x.SXb;
    this.callbacks.clear();
    AppMethodBeat.o(75413);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(75411);
    Log.i(this.TAG, "cancel " + this.mediaId);
    f.baQ().Oc(this.mediaId);
    this.callbacks.clear();
    AppMethodBeat.o(75411);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(75412);
    i.a locala = i.BPL;
    i.eKl().c(this.BPs);
    AppMethodBeat.o(75412);
  }
  
  public final void h(m<? super Boolean, ? super String, x> paramm)
  {
    AppMethodBeat.i(75410);
    if (paramm != null) {
      this.callbacks.add(paramm);
    }
    AppMethodBeat.o(75410);
  }
  
  public final void start()
  {
    AppMethodBeat.i(75409);
    if (!f.baQ().e(this.BPr))
    {
      B(false, null);
      AppMethodBeat.o(75409);
      return;
    }
    com.tencent.mm.vending.e.b localb = this.gZm;
    if (localb != null)
    {
      localb.keep((a)this);
      AppMethodBeat.o(75409);
      return;
    }
    AppMethodBeat.o(75409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.b
 * JD-Core Version:    0.7.0.1
 */