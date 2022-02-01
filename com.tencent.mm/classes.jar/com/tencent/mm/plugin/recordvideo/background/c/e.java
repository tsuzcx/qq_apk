package com.tencent.mm.plugin.recordvideo.background.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixerManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-recordvideo_release"})
public final class e
  implements a
{
  public static final e.a BMr;
  
  static
  {
    AppMethodBeat.i(75326);
    BMr = new e.a((byte)0);
    AppMethodBeat.o(75326);
  }
  
  public final c a(com.tencent.mm.plugin.recordvideo.background.c paramc, ald paramald)
  {
    AppMethodBeat.i(75325);
    p.h(paramc, "editorData");
    p.h(paramald, "extraConfig");
    Object localObject1 = (com.tencent.mm.bw.a)new aio();
    Object localObject2 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject2);
      localObject3 = (aio)localObject1;
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        p.h(localObject3, "storyEditorProtoData");
        localObject2 = new com.tencent.mm.plugin.recordvideo.b.c();
        p.h(localObject3, "storyEditorProtoData");
        if ((((aio)localObject3).idq == 0) || (((aio)localObject3).idq == 1))
        {
          localObject1 = null;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).uPh = ((AudioCacheInfo)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).BMY = ((aio)localObject3).idq;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).BMV = ((aio)localObject3).startTime;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).BMW = ((aio)localObject3).endTime;
          localObject1 = ((aio)localObject3).videoPath;
          p.g(localObject1, "storyEditorProtoData.videoPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).aLo((String)localObject1);
          localObject1 = ((aio)localObject3).thumbPath;
          p.g(localObject1, "storyEditorProtoData.thumbPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).aLp((String)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).iqf = ((aio)localObject3).iqf;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).BMZ.addAll((Collection)((aio)localObject3).Lsc);
          if (!((com.tencent.mm.plugin.recordvideo.b.c)localObject2).BMZ.isEmpty()) {
            ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).BMX = true;
          }
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
          localObject1 = ((aio)localObject3).Lna;
          p.g(localObject1, "storyEditorItem.baseItemData");
          Object localObject4 = MMApplicationContext.getContext();
          p.g(localObject4, "MMApplicationContext.getContext()");
          localObject4 = com.tencent.mm.plugin.recordvideo.background.e.a((LinkedList)localObject1, (Context)localObject4);
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.b((aio)localObject3);
          Object localObject5 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
          localObject3 = com.tencent.mm.plugin.recordvideo.background.e.c((aio)localObject3);
          localObject4 = (List)localObject4;
          localObject5 = paramald.BOA;
          p.g(localObject5, "extraConfig.outputVideoPath");
          String str = paramald.Lue;
          p.g(str, "extraConfig.outputThumbPath");
          boolean bool = paramald.BLF;
          paramald = paramc.field_blurBgPath;
          p.g(paramald, "editorData.field_blurBgPath");
          paramald = new VideoMixer(new com.tencent.mm.plugin.recordvideo.background.a.a((com.tencent.mm.plugin.recordvideo.b.c)localObject2, (List)localObject4, (float[])localObject1, (float[])localObject3, (String)localObject5, str, 0, bool, false, 0, paramald, 832));
          VideoMixer.a(paramald, paramc.field_targetWidth, paramc.field_targetHeight, paramc.field_videoBitrate, paramc.field_audioBitrate, paramc.field_audioSampleRate, paramc.field_audioChannelCount, paramc.field_frameRate, paramc.field_videoRotate);
          Log.i("MicroMsg.VideoMixerManager", "remux video config: " + paramald.eJf().toString());
          paramc = (c)paramald;
          AppMethodBeat.o(75325);
          return paramc;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3;
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        AudioCacheInfo localAudioCacheInfo = null;
        continue;
        localAudioCacheInfo = new AudioCacheInfo();
        localAudioCacheInfo.musicUrl = ((aio)localObject3).musicUrl;
        localAudioCacheInfo.BOX = ((aio)localObject3).BOX;
        localAudioCacheInfo.aXa = ((aio)localObject3).aXa;
        localAudioCacheInfo.BPa = ((aio)localObject3).BPa;
        localAudioCacheInfo.cachePath = ((aio)localObject3).iiv;
        localAudioCacheInfo.position = ((aio)localObject3).Lsa;
        localAudioCacheInfo.BPd = ((aio)localObject3).Lsb;
      }
      AppMethodBeat.o(75325);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.e
 * JD-Core Version:    0.7.0.1
 */