package com.tencent.mm.plugin.recordvideo.background.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixerManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-recordvideo_release"})
public final class e
  implements a
{
  public static final a vfM;
  
  static
  {
    AppMethodBeat.i(75326);
    vfM = new a((byte)0);
    AppMethodBeat.o(75326);
  }
  
  public final c a(d paramd, aer paramaer)
  {
    Object localObject2 = null;
    AppMethodBeat.i(75325);
    k.h(paramd, "editorData");
    k.h(paramaer, "extraConfig");
    Object localObject1 = (com.tencent.mm.bx.a)new acq();
    Object localObject3 = paramd.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject4 = (acq)localObject1;
      if (localObject4 != null)
      {
        localObject1 = f.vdH;
        k.h(localObject4, "storyEditorProtoData");
        localObject3 = new com.tencent.mm.plugin.recordvideo.b.c();
        k.h(localObject4, "storyEditorProtoData");
        localObject1 = localObject2;
        if (((acq)localObject4).gmX != 0)
        {
          if (((acq)localObject4).gmX == 1) {
            localObject1 = localObject2;
          }
        }
        else
        {
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).vgt = ((AudioCacheInfo)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).vgs = ((acq)localObject4).gmX;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).vgp = ((acq)localObject4).startTime;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).vgq = ((acq)localObject4).endTime;
          localObject1 = ((acq)localObject4).videoPath;
          k.g(localObject1, "storyEditorProtoData.videoPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).alI((String)localObject1);
          localObject1 = ((acq)localObject4).thumbPath;
          k.g(localObject1, "storyEditorProtoData.thumbPath");
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).alJ((String)localObject1);
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).gBl = ((acq)localObject4).gBl;
          ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).vgu.addAll((Collection)((acq)localObject4).Ddj);
          if (!((com.tencent.mm.plugin.recordvideo.b.c)localObject3).vgu.isEmpty()) {
            ((com.tencent.mm.plugin.recordvideo.b.c)localObject3).vgr = true;
          }
          localObject1 = f.vdH;
          localObject1 = ((acq)localObject4).Dde;
          k.g(localObject1, "storyEditorItem.baseItemData");
          localObject2 = aj.getContext();
          k.g(localObject2, "MMApplicationContext.getContext()");
          localObject2 = f.a((LinkedList)localObject1, (Context)localObject2);
          localObject1 = f.vdH;
          localObject1 = f.b((acq)localObject4);
          localObject2 = (List)localObject2;
          localObject4 = paramaer.vhU;
          k.g(localObject4, "extraConfig.outputVideoPath");
          String str = paramaer.DeV;
          k.g(str, "extraConfig.outputThumbPath");
          boolean bool = paramaer.vfa;
          paramaer = paramd.field_blurBgPath;
          k.g(paramaer, "editorData.field_blurBgPath");
          paramaer = new VideoMixer((com.tencent.mm.plugin.recordvideo.b.c)localObject3, (List)localObject2, (float[])localObject1, (String)localObject4, str, 0, bool, false, 0, paramaer, 416);
          VideoMixer.a(paramaer, paramd.field_targetWidth, paramd.field_targetHeight, paramd.field_videoBitrate, paramd.field_audioBitrate, paramd.field_audioSampleRate, paramd.field_audioChannelCount, paramd.field_frameRate, paramd.field_videoRotate);
          ad.i("MicroMsg.VideoMixerManager", "remux video config: " + paramaer.dgX().toString());
          paramd = (c)paramaer;
          AppMethodBeat.o(75325);
          return paramd;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject4;
        ad.l("safeParser", "", new Object[] { localException });
        AudioCacheInfo localAudioCacheInfo = null;
        continue;
        localAudioCacheInfo = new AudioCacheInfo();
        localAudioCacheInfo.musicUrl = ((acq)localObject4).musicUrl;
        localAudioCacheInfo.viz = ((acq)localObject4).viz;
        localAudioCacheInfo.aMb = ((acq)localObject4).aMb;
        localAudioCacheInfo.viC = ((acq)localObject4).viC;
        localAudioCacheInfo.cachePath = ((acq)localObject4).gtC;
        localAudioCacheInfo.position = ((acq)localObject4).Ddh;
        localAudioCacheInfo.viE = ((acq)localObject4).Ddi;
      }
      AppMethodBeat.o(75325);
    }
    return null;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixerManager$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.e
 * JD-Core Version:    0.7.0.1
 */