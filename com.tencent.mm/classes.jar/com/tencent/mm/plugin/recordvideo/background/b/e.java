package com.tencent.mm.plugin.recordvideo.background.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.background.g;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixerManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-recordvideo_release"})
public final class e
  implements a
{
  public static final e.a woy;
  
  static
  {
    AppMethodBeat.i(75326);
    woy = new e.a((byte)0);
    AppMethodBeat.o(75326);
  }
  
  public final c a(com.tencent.mm.plugin.recordvideo.background.e parame, afq paramafq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(75325);
    k.h(parame, "editorData");
    k.h(paramafq, "extraConfig");
    Object localObject1 = (com.tencent.mm.bw.a)new adp();
    Object localObject3 = parame.field_baseItemData;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject4 = (adp)localObject1;
      if (localObject4 != null)
      {
        localObject1 = g.wmx;
        k.h(localObject4, "storyEditorProtoData");
        localObject3 = new com.tencent.mm.plugin.recordvideo.b.c();
        k.h(localObject4, "storyEditorProtoData");
        localObject1 = localObject2;
        if (((adp)localObject4).gNK != 0)
        {
          if (((adp)localObject4).gNK == 1) {
            localObject1 = localObject2;
          }
        }
        else
        {
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).wpf = ((AudioCacheInfo)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).wpe = ((adp)localObject4).gNK;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).wpb = ((adp)localObject4).startTime;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).wpc = ((adp)localObject4).endTime;
          localObject1 = ((adp)localObject4).videoPath;
          k.g(localObject1, "storyEditorProtoData.videoPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).aqH((String)localObject1);
          localObject1 = ((adp)localObject4).thumbPath;
          k.g(localObject1, "storyEditorProtoData.thumbPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).aqI((String)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).hbH = ((adp)localObject4).hbH;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).wpg.addAll((Collection)((adp)localObject4).Ewp);
          if (!((com.tencent.mm.plugin.recordvideo.b.c)localObject3).wpg.isEmpty()) {
            ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).wpd = true;
          }
          localObject1 = g.wmx;
          localObject1 = ((adp)localObject4).Esi;
          k.g(localObject1, "storyEditorItem.baseItemData");
          localObject2 = ai.getContext();
          k.g(localObject2, "MMApplicationContext.getContext()");
          localObject2 = g.a((LinkedList)localObject1, (Context)localObject2);
          localObject1 = g.wmx;
          localObject1 = g.b((adp)localObject4);
          localObject2 = (List)localObject2;
          localObject4 = paramafq.wqG;
          k.g(localObject4, "extraConfig.outputVideoPath");
          String str = paramafq.Eyb;
          k.g(str, "extraConfig.outputThumbPath");
          boolean bool = paramafq.wnN;
          paramafq = parame.field_blurBgPath;
          k.g(paramafq, "editorData.field_blurBgPath");
          paramafq = new VideoMixer((com.tencent.mm.plugin.recordvideo.b.c)localObject3, (List)localObject2, (float[])localObject1, (String)localObject4, str, 0, bool, false, 0, paramafq, 416);
          VideoMixer.a(paramafq, parame.field_targetWidth, parame.field_targetHeight, parame.field_videoBitrate, parame.field_audioBitrate, parame.field_audioSampleRate, parame.field_audioChannelCount, parame.field_frameRate, parame.field_videoRotate);
          ac.i("MicroMsg.VideoMixerManager", "remux video config: " + paramafq.duF().toString());
          parame = (c)paramafq;
          AppMethodBeat.o(75325);
          return parame;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject4;
        ac.l("safeParser", "", new Object[] { localException });
        AudioCacheInfo localAudioCacheInfo = null;
        continue;
        localAudioCacheInfo = new AudioCacheInfo();
        localAudioCacheInfo.musicUrl = ((adp)localObject4).musicUrl;
        localAudioCacheInfo.wri = ((adp)localObject4).wri;
        localAudioCacheInfo.aMR = ((adp)localObject4).aMR;
        localAudioCacheInfo.wrl = ((adp)localObject4).wrl;
        localAudioCacheInfo.cachePath = ((adp)localObject4).gUk;
        localAudioCacheInfo.position = ((adp)localObject4).Ewn;
        localAudioCacheInfo.wrn = ((adp)localObject4).Ewo;
      }
      AppMethodBeat.o(75325);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.e
 * JD-Core Version:    0.7.0.1
 */