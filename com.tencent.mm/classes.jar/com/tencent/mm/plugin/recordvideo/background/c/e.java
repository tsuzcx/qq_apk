package com.tencent.mm.plugin.recordvideo.background.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixerManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-recordvideo_release"})
public final class e
  implements a
{
  public static final a HID;
  
  static
  {
    AppMethodBeat.i(75326);
    HID = new a((byte)0);
    AppMethodBeat.o(75326);
  }
  
  public final c a(com.tencent.mm.plugin.recordvideo.background.c paramc, ame paramame)
  {
    AppMethodBeat.i(75325);
    p.k(paramc, "editorData");
    p.k(paramame, "extraConfig");
    Object localObject1 = (com.tencent.mm.cd.a)new ajd();
    Object localObject2 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject2);
      localObject3 = (ajd)localObject1;
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
        p.k(localObject3, "storyEditorProtoData");
        localObject2 = new com.tencent.mm.plugin.recordvideo.b.c();
        p.k(localObject3, "storyEditorProtoData");
        if ((((ajd)localObject3).kRX == 0) || (((ajd)localObject3).kRX == 1))
        {
          localObject1 = null;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).zBD = ((AudioCacheInfo)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).HJD = ((ajd)localObject3).kRX;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).HJA = ((ajd)localObject3).startTime;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).HJB = ((ajd)localObject3).endTime;
          localObject1 = ((ajd)localObject3).videoPath;
          p.j(localObject1, "storyEditorProtoData.videoPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).aVQ((String)localObject1);
          localObject1 = ((ajd)localObject3).thumbPath;
          p.j(localObject1, "storyEditorProtoData.thumbPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).aVR((String)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).lfl = ((ajd)localObject3).lfl;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).HJE.addAll((Collection)((ajd)localObject3).StE);
          if (!((com.tencent.mm.plugin.recordvideo.b.c)localObject2).HJE.isEmpty()) {
            ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).HJC = true;
          }
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
          localObject1 = ((ajd)localObject3).Sor;
          p.j(localObject1, "storyEditorItem.baseItemData");
          Object localObject4 = MMApplicationContext.getContext();
          p.j(localObject4, "MMApplicationContext.getContext()");
          localObject4 = com.tencent.mm.plugin.recordvideo.background.e.a((LinkedList)localObject1, (Context)localObject4);
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.b((ajd)localObject3);
          Object localObject5 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
          localObject3 = com.tencent.mm.plugin.recordvideo.background.e.c((ajd)localObject3);
          localObject4 = (List)localObject4;
          localObject5 = paramame.HLg;
          p.j(localObject5, "extraConfig.outputVideoPath");
          String str = paramame.SwC;
          p.j(str, "extraConfig.outputThumbPath");
          boolean bool = paramame.HHQ;
          paramame = paramc.field_blurBgPath;
          p.j(paramame, "editorData.field_blurBgPath");
          paramame = new VideoMixer(new com.tencent.mm.plugin.recordvideo.background.a.a((com.tencent.mm.plugin.recordvideo.b.c)localObject2, (List)localObject4, (float[])localObject1, (float[])localObject3, (String)localObject5, str, 0, bool, false, 0, paramame, 832));
          VideoMixer.a(paramame, paramc.field_targetWidth, paramc.field_targetHeight, paramc.field_videoBitrate, paramc.field_audioBitrate, paramc.field_audioSampleRate, paramc.field_audioChannelCount, paramc.field_frameRate, paramc.field_videoRotate);
          Log.i("MicroMsg.VideoMixerManager", "remux video config: " + paramame.fvj().toString());
          paramc = (c)paramame;
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
        localAudioCacheInfo.musicUrl = ((ajd)localObject3).musicUrl;
        localAudioCacheInfo.HLC = ((ajd)localObject3).HLC;
        localAudioCacheInfo.aGs = ((ajd)localObject3).aGs;
        localAudioCacheInfo.HLF = ((ajd)localObject3).HLF;
        localAudioCacheInfo.cachePath = ((ajd)localObject3).kXi;
        localAudioCacheInfo.position = ((ajd)localObject3).StC;
        localAudioCacheInfo.HLI = ((ajd)localObject3).StD;
      }
      AppMethodBeat.o(75325);
    }
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixerManager$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.e
 * JD-Core Version:    0.7.0.1
 */