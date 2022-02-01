package com.tencent.mm.plugin.recordvideo.background.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixerManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements a
{
  public static final e.a NFV;
  
  static
  {
    AppMethodBeat.i(75326);
    NFV = new e.a((byte)0);
    AppMethodBeat.o(75326);
  }
  
  public final c a(com.tencent.mm.plugin.recordvideo.background.c paramc, apw paramapw)
  {
    AppMethodBeat.i(75325);
    s.u(paramc, "editorData");
    s.u(paramapw, "extraConfig");
    Object localObject1 = (com.tencent.mm.bx.a)new ami();
    Object localObject2 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject2);
      localObject3 = (ami)localObject1;
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        s.u(localObject3, "storyEditorProtoData");
        localObject2 = new com.tencent.mm.plugin.recordvideo.c.c();
        s.u(localObject3, "storyEditorProtoData");
        if ((((ami)localObject3).nxj == 0) || (((ami)localObject3).nxj == 1))
        {
          localObject1 = null;
          ((com.tencent.mm.plugin.recordvideo.c.c)localObject2).EEx = ((AudioCacheInfo)localObject1);
          ((com.tencent.mm.plugin.recordvideo.c.c)localObject2).NGC = ((ami)localObject3).nxj;
          ((com.tencent.mm.plugin.recordvideo.c.c)localObject2).NGz = ((ami)localObject3).startTime;
          ((com.tencent.mm.plugin.recordvideo.c.c)localObject2).NGA = ((ami)localObject3).endTime;
          localObject1 = ((ami)localObject3).videoPath;
          s.s(localObject1, "storyEditorProtoData.videoPath");
          ((com.tencent.mm.plugin.recordvideo.c.c)localObject2).aSY((String)localObject1);
          localObject1 = ((ami)localObject3).thumbPath;
          s.s(localObject1, "storyEditorProtoData.thumbPath");
          ((com.tencent.mm.plugin.recordvideo.c.c)localObject2).aSZ((String)localObject1);
          ((com.tencent.mm.plugin.recordvideo.c.c)localObject2).nJW = ((ami)localObject3).nJW;
          ((com.tencent.mm.plugin.recordvideo.c.c)localObject2).NGD.addAll((Collection)((ami)localObject3).Zto);
          if (!((com.tencent.mm.plugin.recordvideo.c.c)localObject2).NGD.isEmpty()) {
            ((com.tencent.mm.plugin.recordvideo.c.c)localObject2).NGB = true;
          }
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
          localObject1 = ((ami)localObject3).Znd;
          s.s(localObject1, "storyEditorItem.baseItemData");
          Object localObject4 = MMApplicationContext.getContext();
          s.s(localObject4, "getContext()");
          localObject4 = com.tencent.mm.plugin.recordvideo.background.e.a((LinkedList)localObject1, (Context)localObject4);
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
          localObject1 = com.tencent.mm.plugin.recordvideo.background.e.b((ami)localObject3);
          Object localObject5 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
          localObject3 = com.tencent.mm.plugin.recordvideo.background.e.c((ami)localObject3);
          localObject4 = (List)localObject4;
          localObject5 = paramapw.NIe;
          s.s(localObject5, "extraConfig.outputVideoPath");
          String str = paramapw.Zxl;
          s.s(str, "extraConfig.outputThumbPath");
          boolean bool = paramapw.NFi;
          paramapw = paramc.field_blurBgPath;
          s.s(paramapw, "editorData.field_blurBgPath");
          paramapw = new VideoMixer(new com.tencent.mm.plugin.recordvideo.background.a.a((com.tencent.mm.plugin.recordvideo.c.c)localObject2, (List)localObject4, (float[])localObject1, (float[])localObject3, (String)localObject5, str, 0, bool, false, 0, paramapw, 832));
          VideoMixer.a(paramapw, paramc.field_targetWidth, paramc.field_targetHeight, paramc.field_videoBitrate, paramc.field_audioBitrate, paramc.field_audioSampleRate, paramc.field_audioChannelCount, paramc.field_frameRate, paramc.field_videoRotate);
          Log.i("MicroMsg.VideoMixerManager", s.X("remux video config: ", paramapw.gGZ()));
          paramc = (c)paramapw;
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
        localAudioCacheInfo.musicUrl = ((ami)localObject3).musicUrl;
        localAudioCacheInfo.NID = ((ami)localObject3).NID;
        localAudioCacheInfo.cached = ((ami)localObject3).cached;
        localAudioCacheInfo.NIG = ((ami)localObject3).NIG;
        localAudioCacheInfo.cachePath = ((ami)localObject3).nBT;
        localAudioCacheInfo.position = ((ami)localObject3).Ztm;
        localAudioCacheInfo.NII = ((ami)localObject3).Ztn;
      }
      AppMethodBeat.o(75325);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.e
 * JD-Core Version:    0.7.0.1
 */