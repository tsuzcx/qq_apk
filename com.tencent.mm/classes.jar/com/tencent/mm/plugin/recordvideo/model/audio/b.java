package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vfs.o;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "TAG", "", "callbacks", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "", "kotlin.jvm.PlatformType", "", "getInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mediaId", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "addCallback", "cb", "cancel", "dead", "notifyCallbacks", "start", "plugin-recordvideo_release"})
public final class b
  implements a
{
  final String TAG;
  private final List<m<Boolean, String, z>> callbacks;
  private final com.tencent.mm.vending.e.b<a> got;
  private final String mediaId;
  private final g xPo;
  private final AudioCacheInfo xPp;
  
  public b(final com.tencent.mm.vending.e.b<a> paramb, final AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75414);
    this.got = paramb;
    this.xPp = paramAudioCacheInfo;
    this.TAG = "MicroMsg.AudioDownloadTask";
    this.callbacks = Collections.synchronizedList((List)new ArrayList());
    paramb = this.xPp.cachePath + "_temp";
    paramAudioCacheInfo = this.xPp.cachePath;
    com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.yhe;
    com.tencent.mm.plugin.recordvideo.e.b.axq(paramb);
    if (paramAudioCacheInfo != null)
    {
      localb = com.tencent.mm.plugin.recordvideo.e.b.yhe;
      com.tencent.mm.plugin.recordvideo.e.b.axq(paramAudioCacheInfo);
    }
    this.mediaId = ("downaudio_" + this.xPp.xOV);
    this.xPo = new g();
    this.xPo.fLl = "task_AudioDownloadTask";
    this.xPo.fLq = 60;
    this.xPo.fLr = 60;
    this.xPo.field_mediaId = this.mediaId;
    this.xPo.fLp = this.xPp.musicUrl;
    this.xPo.field_fileType = 40001;
    this.xPo.field_fullpath = paramb;
    this.xPo.fLm = ((g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(75406);
        p.h(paramAnonymousString, "mediaId");
        String str2 = this.xPq.TAG;
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
        ae.d(str2, "AudioDownloadTask on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, localObject });
        if (paramAnonymousd != null) {
          if (paramAnonymousd.field_retCode == 0)
          {
            ae.i(this.xPq.TAG, "download success " + paramAnonymousString + ' ' + paramAudioCacheInfo);
            o.mG(paramb, paramAudioCacheInfo);
            b.a(this.xPq, true, paramAudioCacheInfo);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(75406);
          return 0;
          ae.w(this.xPq.TAG, "download fail sceneResult " + paramAnonymousd.field_retCode);
          b.a(this.xPq, false, null);
          continue;
          if (paramAnonymousInt != 0)
          {
            ae.w(this.xPq.TAG, "download fail startRet ".concat(String.valueOf(paramAnonymousInt)));
            b.a(this.xPq, false, null);
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
  
  private final void A(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(75413);
    ??? = this.callbacks;
    p.g(???, "callbacks");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext()) {
        ((m)localIterator.next()).p(Boolean.valueOf(paramBoolean), paramString);
      }
    }
    paramString = z.Nhr;
    this.callbacks.clear();
    AppMethodBeat.o(75413);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(75411);
    ae.i(this.TAG, "cancel " + this.mediaId);
    f.aGZ().Fs(this.mediaId);
    this.callbacks.clear();
    AppMethodBeat.o(75411);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(75412);
    i.a locala = i.xPI;
    i.dJz().a(this.xPp);
    AppMethodBeat.o(75412);
  }
  
  public final void e(m<? super Boolean, ? super String, z> paramm)
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
    if (!f.aGZ().e(this.xPo))
    {
      A(false, null);
      AppMethodBeat.o(75409);
      return;
    }
    com.tencent.mm.vending.e.b localb = this.got;
    if (localb != null)
    {
      localb.keep((a)this);
      AppMethodBeat.o(75409);
      return;
    }
    AppMethodBeat.o(75409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.b
 * JD-Core Version:    0.7.0.1
 */