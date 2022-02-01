package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "TAG", "", "callbacks", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "", "kotlin.jvm.PlatformType", "", "getInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mediaId", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "addCallback", "cb", "cancel", "dead", "notifyCallbacks", "start", "plugin-recordvideo_release"})
public final class b
  implements a
{
  private final g HMd;
  private final AudioCacheInfo HMe;
  private final String TAG;
  private final List<m<Boolean, String, x>> callbacks;
  private final com.tencent.mm.vending.e.b<a> jKn;
  private final String mediaId;
  
  public b(final com.tencent.mm.vending.e.b<a> paramb, final AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75414);
    this.jKn = paramb;
    this.HMe = paramAudioCacheInfo;
    this.TAG = "MicroMsg.AudioDownloadTask";
    this.callbacks = Collections.synchronizedList((List)new ArrayList());
    paramb = this.HMe.cachePath + "_temp";
    paramAudioCacheInfo = this.HMe.cachePath;
    com.tencent.mm.plugin.recordvideo.e.d locald = com.tencent.mm.plugin.recordvideo.e.d.IeU;
    com.tencent.mm.plugin.recordvideo.e.d.aWs(paramb);
    if (paramAudioCacheInfo != null)
    {
      locald = com.tencent.mm.plugin.recordvideo.e.d.IeU;
      com.tencent.mm.plugin.recordvideo.e.d.aWs(paramAudioCacheInfo);
    }
    this.mediaId = ("downaudio_" + this.HMe.HLC);
    this.HMd = new g();
    this.HMd.taskName = "task_AudioDownloadTask";
    this.HMd.iUK = 60;
    this.HMd.iUL = 60;
    this.HMd.field_mediaId = this.mediaId;
    this.HMd.iUJ = this.HMe.musicUrl;
    this.HMd.field_fileType = 40001;
    this.HMd.field_fullpath = paramb;
    this.HMd.field_aesKey = this.HMe.decodeKey;
    this.HMd.iUG = ((g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(75406);
        p.k(paramAnonymousString, "mediaId");
        String str2 = b.a(this.HMf);
        Object localObject;
        if (paramAnonymousc != null)
        {
          localObject = paramAnonymousc.toString();
          paramAnonymousc = (c)localObject;
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
            Log.i(b.a(this.HMf), "download success " + paramAnonymousString + ' ' + paramAudioCacheInfo);
            u.oo(paramb, paramAudioCacheInfo);
            b.a(this.HMf, true, paramAudioCacheInfo);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(75406);
          return 0;
          Log.w(b.a(this.HMf), "download fail sceneResult " + paramAnonymousd.field_retCode);
          b.a(this.HMf, false, null);
          continue;
          if (paramAnonymousInt != 0)
          {
            Log.w(b.a(this.HMf), "download fail startRet ".concat(String.valueOf(paramAnonymousInt)));
            b.a(this.HMf, false, null);
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(75407);
        p.k(paramAnonymousString, "mediaId");
        p.k(paramAnonymousByteArrayOutputStream, "buff");
        AppMethodBeat.o(75407);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(75408);
        p.k(paramAnonymousString, "mediaId");
        p.k(paramAnonymousArrayOfByte, "inbuf");
        AppMethodBeat.o(75408);
        return new byte[0];
      }
    });
    AppMethodBeat.o(75414);
  }
  
  private final void G(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(75413);
    ??? = this.callbacks;
    p.j(???, "callbacks");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext()) {
        ((m)localIterator.next()).invoke(Boolean.valueOf(paramBoolean), paramString);
      }
    }
    paramString = x.aazN;
    this.callbacks.clear();
    AppMethodBeat.o(75413);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(75411);
    Log.i(this.TAG, "cancel " + this.mediaId);
    f.bkg().Vz(this.mediaId);
    this.callbacks.clear();
    AppMethodBeat.o(75411);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(75412);
    k.a locala = k.HMx;
    k.fwB().c(this.HMe);
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
    if (!f.bkg().e(this.HMd))
    {
      G(false, null);
      AppMethodBeat.o(75409);
      return;
    }
    com.tencent.mm.vending.e.b localb = this.jKn;
    if (localb != null)
    {
      localb.keep((a)this);
      AppMethodBeat.o(75409);
      return;
    }
    AppMethodBeat.o(75409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.b
 * JD-Core Version:    0.7.0.1
 */