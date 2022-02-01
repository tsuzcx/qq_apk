package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.e.a;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "TAG", "", "callbacks", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "", "kotlin.jvm.PlatformType", "", "getInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mediaId", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "addCallback", "cb", "cancel", "dead", "notifyCallbacks", "start", "plugin-recordvideo_release"})
public final class b
  implements a
{
  final String TAG;
  private final List<m<Boolean, String, y>> callbacks;
  private final com.tencent.mm.vending.e.b<a> fOI;
  private final String mediaId;
  private final g viP;
  private final AudioCacheInfo viQ;
  
  public b(final com.tencent.mm.vending.e.b<a> paramb, final AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75414);
    this.fOI = paramb;
    this.viQ = paramAudioCacheInfo;
    this.TAG = "MicroMsg.AudioDownloadTask";
    this.callbacks = Collections.synchronizedList((List)new ArrayList());
    paramb = this.viQ.cachePath + "_temp";
    paramAudioCacheInfo = this.viQ.cachePath;
    com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.vtE;
    com.tencent.mm.plugin.recordvideo.e.b.alY(paramb);
    if (paramAudioCacheInfo != null)
    {
      localb = com.tencent.mm.plugin.recordvideo.e.b.vtE;
      com.tencent.mm.plugin.recordvideo.e.b.alY(paramAudioCacheInfo);
    }
    this.mediaId = ("downaudio_" + this.viQ.viz);
    this.viP = new g();
    this.viP.fnL = 60;
    this.viP.fnM = 60;
    this.viP.field_mediaId = this.mediaId;
    this.viP.fnK = this.viQ.musicUrl;
    this.viP.field_fileType = 40001;
    this.viP.field_fullpath = paramb;
    this.viP.fnH = ((g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(75406);
        k.h(paramAnonymousString, "mediaId");
        String str2 = this.viR.TAG;
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
        ad.d(str2, "AudioDownloadTask on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, localObject });
        if (paramAnonymousd != null) {
          if (paramAnonymousd.field_retCode == 0)
          {
            ad.i(this.viR.TAG, "download success " + paramAnonymousString + ' ' + paramAudioCacheInfo);
            com.tencent.mm.vfs.i.lD(paramb, paramAudioCacheInfo);
            b.a(this.viR, true, paramAudioCacheInfo);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(75406);
          return 0;
          ad.w(this.viR.TAG, "download fail sceneResult " + paramAnonymousd.field_retCode);
          b.a(this.viR, false, null);
          continue;
          if (paramAnonymousInt != 0)
          {
            ad.w(this.viR.TAG, "download fail startRet ".concat(String.valueOf(paramAnonymousInt)));
            b.a(this.viR, false, null);
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(75407);
        k.h(paramAnonymousString, "mediaId");
        k.h(paramAnonymousByteArrayOutputStream, "buff");
        AppMethodBeat.o(75407);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(75408);
        k.h(paramAnonymousString, "mediaId");
        k.h(paramAnonymousArrayOfByte, "inbuf");
        AppMethodBeat.o(75408);
        return new byte[0];
      }
    });
    AppMethodBeat.o(75414);
  }
  
  private final void t(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(75413);
    ??? = this.callbacks;
    k.g(???, "callbacks");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext()) {
        ((m)localIterator.next()).n(Boolean.valueOf(paramBoolean), paramString);
      }
    }
    paramString = y.JfV;
    this.callbacks.clear();
    AppMethodBeat.o(75413);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(75411);
    ad.i(this.TAG, "cancel " + this.mediaId);
    f.awL().xL(this.mediaId);
    this.callbacks.clear();
    AppMethodBeat.o(75411);
  }
  
  public final void d(m<? super Boolean, ? super String, y> paramm)
  {
    AppMethodBeat.i(75410);
    if (paramm != null) {
      this.callbacks.add(paramm);
    }
    AppMethodBeat.o(75410);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(75412);
    i.a locala = i.vjj;
    i.dhZ().a(this.viQ);
    AppMethodBeat.o(75412);
  }
  
  public final void start()
  {
    AppMethodBeat.i(75409);
    if (!f.awL().d(this.viP))
    {
      t(false, null);
      AppMethodBeat.o(75409);
      return;
    }
    com.tencent.mm.vending.e.b localb = this.fOI;
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