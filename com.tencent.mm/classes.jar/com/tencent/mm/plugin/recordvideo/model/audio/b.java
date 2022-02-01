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
import d.g.b.p;
import d.l;
import d.z;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "TAG", "", "callbacks", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "", "kotlin.jvm.PlatformType", "", "getInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mediaId", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "addCallback", "cb", "cancel", "dead", "notifyCallbacks", "start", "plugin-recordvideo_release"})
public final class b
  implements a
{
  final String TAG;
  private final List<m<Boolean, String, z>> callbacks;
  private final com.tencent.mm.vending.e.b<a> glX;
  private final String mediaId;
  private final g xzs;
  private final AudioCacheInfo xzt;
  
  public b(final com.tencent.mm.vending.e.b<a> paramb, final AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75414);
    this.glX = paramb;
    this.xzt = paramAudioCacheInfo;
    this.TAG = "MicroMsg.AudioDownloadTask";
    this.callbacks = Collections.synchronizedList((List)new ArrayList());
    paramb = this.xzt.cachePath + "_temp";
    paramAudioCacheInfo = this.xzt.cachePath;
    com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.xRl;
    com.tencent.mm.plugin.recordvideo.e.b.awb(paramb);
    if (paramAudioCacheInfo != null)
    {
      localb = com.tencent.mm.plugin.recordvideo.e.b.xRl;
      com.tencent.mm.plugin.recordvideo.e.b.awb(paramAudioCacheInfo);
    }
    this.mediaId = ("downaudio_" + this.xzt.xyZ);
    this.xzs = new g();
    this.xzs.fJi = "task_AudioDownloadTask";
    this.xzs.fJn = 60;
    this.xzs.fJo = 60;
    this.xzs.field_mediaId = this.mediaId;
    this.xzs.fJm = this.xzt.musicUrl;
    this.xzs.field_fileType = 40001;
    this.xzs.field_fullpath = paramb;
    this.xzs.fJj = ((g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(75406);
        p.h(paramAnonymousString, "mediaId");
        String str2 = this.xzu.TAG;
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
            ad.i(this.xzu.TAG, "download success " + paramAnonymousString + ' ' + paramAudioCacheInfo);
            com.tencent.mm.vfs.i.mA(paramb, paramAudioCacheInfo);
            b.a(this.xzu, true, paramAudioCacheInfo);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(75406);
          return 0;
          ad.w(this.xzu.TAG, "download fail sceneResult " + paramAnonymousd.field_retCode);
          b.a(this.xzu, false, null);
          continue;
          if (paramAnonymousInt != 0)
          {
            ad.w(this.xzu.TAG, "download fail startRet ".concat(String.valueOf(paramAnonymousInt)));
            b.a(this.xzu, false, null);
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
  
  private final void z(boolean paramBoolean, String paramString)
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
    paramString = z.MKo;
    this.callbacks.clear();
    AppMethodBeat.o(75413);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(75411);
    ad.i(this.TAG, "cancel " + this.mediaId);
    f.aGI().EQ(this.mediaId);
    this.callbacks.clear();
    AppMethodBeat.o(75411);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(75412);
    i.a locala = i.xzM;
    i.dGi().a(this.xzt);
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
    if (!f.aGI().e(this.xzs))
    {
      z(false, null);
      AppMethodBeat.o(75409);
      return;
    }
    com.tencent.mm.vending.e.b localb = this.glX;
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