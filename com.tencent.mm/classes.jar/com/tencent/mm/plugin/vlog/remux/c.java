package com.tencent.mm.plugin.vlog.remux;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.plugin.vlog.model.x;
import com.tencent.mm.plugin.vlog.model.x.a;
import com.tencent.mm.plugin.vlog.model.y;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-vlog_release"})
public final class c
  implements com.tencent.mm.plugin.recordvideo.background.c.a
{
  public static final a BJJ;
  
  static
  {
    AppMethodBeat.i(111052);
    BJJ = new a((byte)0);
    AppMethodBeat.o(111052);
  }
  
  public final com.tencent.mm.plugin.recordvideo.background.c.c a(com.tencent.mm.plugin.recordvideo.background.c paramc, aif paramaif)
  {
    AppMethodBeat.i(111051);
    p.h(paramc, "editorData");
    p.h(paramaif, "extraConfig");
    Object localObject1 = (com.tencent.mm.bx.a)new afy();
    Object localObject3 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (afy)localObject1;
      if (localObject3 != null)
      {
        localObject1 = new y();
        ((y)localObject1).audioBitrate = paramc.field_audioBitrate;
        ((y)localObject1).videoBitrate = paramc.field_videoBitrate;
        ((y)localObject1).targetWidth = paramc.field_targetWidth;
        ((y)localObject1).targetHeight = paramc.field_targetHeight;
        ((y)localObject1).frameRate = paramc.field_frameRate;
        ((y)localObject1).audioSampleRate = paramc.field_audioSampleRate;
        ((y)localObject1).audioChannelCount = paramc.field_audioChannelCount;
        ((y)localObject1).hlJ = paramc.field_videoRotate;
        ((y)localObject1).BGI = ((afy)localObject3).hhG;
        ((y)localObject1).BGH = ((int)((afy)localObject3).endTime);
        paramc = paramaif.xyx;
        p.g(paramc, "extraConfig.outputVideoPath");
        ((y)localObject1).aDr(paramc);
        paramc = (com.tencent.mm.bx.a)new due();
        paramaif = ((afy)localObject3).GdQ.toByteArray();
      }
    }
    catch (Exception localException)
    {
      try
      {
        paramc.parseFrom(paramaif);
        paramc = (due)paramc;
        if (paramc != null)
        {
          paramaif = paramc.HGY;
          float f1 = ((afy)localObject3).GdH;
          float f2 = ((afy)localObject3).GdJ;
          float f3 = ((afy)localObject3).GdI;
          float f4 = ((afy)localObject3).GdK;
          Object localObject4 = e.xuo;
          localObject3 = ((afy)localObject3).FZr;
          p.g(localObject3, "editorProtoData.baseItemData");
          localObject4 = aj.getContext();
          p.g(localObject4, "MMApplicationContext.getContext()");
          localObject3 = e.a((LinkedList)localObject3, (Context)localObject4);
          if (paramaif != null)
          {
            long l = paramaif.FCY;
            localObject4 = x.BGE;
            localObject4 = x.a.a(paramaif);
            String str = paramaif.HIK.GRf;
            p.g(str, "music.music_url");
            localObject4 = new aa(l, (List)localObject4, str, paramaif);
            ((aa)localObject4).p(new float[] { f1, f2, f3, f4 });
            ((aa)localObject4).aB((ArrayList)localObject3);
            localObject1 = new d((aa)localObject4, (y)localObject1);
            ad.i("MicroMsg.VLogMixerInstanceManager", "music url:" + paramaif.HIK.GVH + " exist:" + i.fv(paramaif.HIK.GVH));
            ((d)localObject1).aDt(paramaif.HIK.GVH);
            ((d)localObject1).iq(paramc.aXs, paramc.aXt);
            paramc = (com.tencent.mm.plugin.recordvideo.background.c.c)localObject1;
            AppMethodBeat.o(111051);
            return paramc;
            localException = localException;
            ad.l("safeParser", "", new Object[] { localException });
            Object localObject2 = null;
          }
        }
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { paramc });
          paramc = null;
        }
      }
      ad.e("MicroMsg.VLogMixerInstanceManager", "return null mixer");
      AppMethodBeat.o(111051);
    }
    return null;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.c
 * JD-Core Version:    0.7.0.1
 */