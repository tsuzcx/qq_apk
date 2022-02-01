package com.tencent.mm.plugin.recordvideo.background.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixerManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-recordvideo_release"})
public final class e
  implements a
{
  public static final e.a xMl;
  
  static
  {
    AppMethodBeat.i(75326);
    xMl = new e.a((byte)0);
    AppMethodBeat.o(75326);
  }
  
  public final c a(com.tencent.mm.plugin.recordvideo.background.c paramc, aip paramaip)
  {
    AppMethodBeat.i(75325);
    p.h(paramc, "editorData");
    p.h(paramaip, "extraConfig");
    Object localObject1 = (com.tencent.mm.bw.a)new agh();
    Object localObject2 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject2);
      localObject3 = (agh)localObject1;
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
        p.h(localObject3, "storyEditorProtoData");
        localObject2 = new com.tencent.mm.plugin.recordvideo.b.c();
        p.h(localObject3, "storyEditorProtoData");
        if ((((agh)localObject3).hku == 0) || (((agh)localObject3).hku == 1))
        {
          localObject1 = null;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xMS = ((AudioCacheInfo)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xMR = ((agh)localObject3).hku;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xMO = ((agh)localObject3).startTime;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xMP = ((agh)localObject3).endTime;
          localObject1 = ((agh)localObject3).videoPath;
          p.g(localObject1, "storyEditorProtoData.videoPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).awW((String)localObject1);
          localObject1 = ((agh)localObject3).thumbPath;
          p.g(localObject1, "storyEditorProtoData.thumbPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).awX((String)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).hwD = ((agh)localObject3).hwD;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xMT.addAll((Collection)((agh)localObject3).Gww);
          if (!((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xMT.isEmpty()) {
            ((com.tencent.mm.plugin.recordvideo.b.c)localObject2).xMQ = true;
          }
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
          localObject1 = ((agh)localObject3).GrR;
          p.g(localObject1, "storyEditorItem.baseItemData");
          Object localObject4 = ak.getContext();
          p.g(localObject4, "MMApplicationContext.getContext()");
          localObject4 = com.tencent.mm.plugin.recordvideo.background.e.a((LinkedList)localObject1, (Context)localObject4);
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.b((agh)localObject3);
          Object localObject5 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
          localObject3 = com.tencent.mm.plugin.recordvideo.background.e.c((agh)localObject3);
          localObject4 = (List)localObject4;
          localObject5 = paramaip.xOt;
          p.g(localObject5, "extraConfig.outputVideoPath");
          String str = paramaip.Gyq;
          p.g(str, "extraConfig.outputThumbPath");
          boolean bool = paramaip.xLA;
          paramaip = paramc.field_blurBgPath;
          p.g(paramaip, "editorData.field_blurBgPath");
          paramaip = new VideoMixer(new com.tencent.mm.plugin.recordvideo.background.a.a((com.tencent.mm.plugin.recordvideo.b.c)localObject2, (List)localObject4, (float[])localObject1, (float[])localObject3, (String)localObject5, str, 0, bool, false, 0, paramaip, 832));
          VideoMixer.a(paramaip, paramc.field_targetWidth, paramc.field_targetHeight, paramc.field_videoBitrate, paramc.field_audioBitrate, paramc.field_audioSampleRate, paramc.field_audioChannelCount, paramc.field_frameRate, paramc.field_videoRotate);
          ae.i("MicroMsg.VideoMixerManager", "remux video config: " + paramaip.dIs().toString());
          paramc = (c)paramaip;
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
        ae.l("safeParser", "", new Object[] { localException });
        AudioCacheInfo localAudioCacheInfo = null;
        continue;
        localAudioCacheInfo = new AudioCacheInfo();
        localAudioCacheInfo.musicUrl = ((agh)localObject3).musicUrl;
        localAudioCacheInfo.xOV = ((agh)localObject3).xOV;
        localAudioCacheInfo.aXj = ((agh)localObject3).aXj;
        localAudioCacheInfo.xOY = ((agh)localObject3).xOY;
        localAudioCacheInfo.cachePath = ((agh)localObject3).hoZ;
        localAudioCacheInfo.position = ((agh)localObject3).Gwu;
        localAudioCacheInfo.xPa = ((agh)localObject3).Gwv;
      }
      AppMethodBeat.o(75325);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.e
 * JD-Core Version:    0.7.0.1
 */