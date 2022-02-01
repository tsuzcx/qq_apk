package com.tencent.mm.plugin.recordvideo.background.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixerManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-recordvideo_release"})
public final class e
  implements a
{
  public static final e.a xwo;
  
  static
  {
    AppMethodBeat.i(75326);
    xwo = new e.a((byte)0);
    AppMethodBeat.o(75326);
  }
  
  public final c a(com.tencent.mm.plugin.recordvideo.background.c paramc, aif paramaif)
  {
    AppMethodBeat.i(75325);
    p.h(paramc, "editorData");
    p.h(paramaif, "extraConfig");
    Object localObject1 = (com.tencent.mm.bx.a)new afy();
    Object localObject2 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject2);
      localObject3 = (afy)localObject1;
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
        p.h(localObject3, "storyEditorProtoData");
        localObject2 = new com.tencent.mm.plugin.recordvideo.b.c();
        p.h(localObject3, "storyEditorProtoData");
        if ((((afy)localObject3).hhG == 0) || (((afy)localObject3).hhG == 1))
        {
          localObject1 = null;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xwV = ((AudioCacheInfo)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xwU = ((afy)localObject3).hhG;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xwR = ((afy)localObject3).startTime;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xwS = ((afy)localObject3).endTime;
          localObject1 = ((afy)localObject3).videoPath;
          p.g(localObject1, "storyEditorProtoData.videoPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).avH((String)localObject1);
          localObject1 = ((afy)localObject3).thumbPath;
          p.g(localObject1, "storyEditorProtoData.thumbPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).avI((String)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).htP = ((afy)localObject3).htP;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xwW.addAll((Collection)((afy)localObject3).GdP);
          if (!((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xwW.isEmpty()) {
            ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xwT = true;
          }
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
          localObject1 = ((afy)localObject3).FZr;
          p.g(localObject1, "storyEditorItem.baseItemData");
          Object localObject4 = aj.getContext();
          p.g(localObject4, "MMApplicationContext.getContext()");
          localObject4 = com.tencent.mm.plugin.recordvideo.background.e.a((LinkedList)localObject1, (Context)localObject4);
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.b((afy)localObject3);
          Object localObject5 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
          localObject3 = com.tencent.mm.plugin.recordvideo.background.e.c((afy)localObject3);
          localObject4 = (List)localObject4;
          localObject5 = paramaif.xyx;
          p.g(localObject5, "extraConfig.outputVideoPath");
          String str = paramaif.GfI;
          p.g(str, "extraConfig.outputThumbPath");
          boolean bool = paramaif.xvD;
          paramaif = paramc.field_blurBgPath;
          p.g(paramaif, "editorData.field_blurBgPath");
          paramaif = new VideoMixer(new com.tencent.mm.plugin.recordvideo.background.a.a((com.tencent.mm.plugin.recordvideo.b.c)localObject2, (List)localObject4, (float[])localObject1, (float[])localObject3, (String)localObject5, str, 0, bool, false, 0, paramaif, 832));
          VideoMixer.a(paramaif, paramc.field_targetWidth, paramc.field_targetHeight, paramc.field_videoBitrate, paramc.field_audioBitrate, paramc.field_audioSampleRate, paramc.field_audioChannelCount, paramc.field_frameRate, paramc.field_videoRotate);
          ad.i("MicroMsg.VideoMixerManager", "remux video config: " + paramaif.dFb().toString());
          paramc = (c)paramaif;
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
        ad.l("safeParser", "", new Object[] { localException });
        AudioCacheInfo localAudioCacheInfo = null;
        continue;
        localAudioCacheInfo = new AudioCacheInfo();
        localAudioCacheInfo.musicUrl = ((afy)localObject3).musicUrl;
        localAudioCacheInfo.xyZ = ((afy)localObject3).xyZ;
        localAudioCacheInfo.aXj = ((afy)localObject3).aXj;
        localAudioCacheInfo.xzc = ((afy)localObject3).xzc;
        localAudioCacheInfo.cachePath = ((afy)localObject3).hml;
        localAudioCacheInfo.position = ((afy)localObject3).GdN;
        localAudioCacheInfo.xze = ((afy)localObject3).GdO;
      }
      AppMethodBeat.o(75325);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.e
 * JD-Core Version:    0.7.0.1
 */