package com.tencent.mm.plugin.vlog.remux;

import android.content.Context;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.background.g;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.v.a;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.model.y;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-vlog_release"})
public final class c
  implements com.tencent.mm.plugin.recordvideo.background.b.a
{
  public static final c.a ArS;
  
  static
  {
    AppMethodBeat.i(111052);
    ArS = new c.a((byte)0);
    AppMethodBeat.o(111052);
  }
  
  public final com.tencent.mm.plugin.recordvideo.background.b.c a(e parame, afq paramafq)
  {
    AppMethodBeat.i(111051);
    k.h(parame, "editorData");
    k.h(paramafq, "extraConfig");
    Object localObject1 = (com.tencent.mm.bw.a)new adp();
    Object localObject3 = parame.field_baseItemData;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (adp)localObject1;
      if (localObject3 != null)
      {
        localObject1 = new w();
        ((w)localObject1).audioBitrate = parame.field_audioBitrate;
        ((w)localObject1).videoBitrate = parame.field_videoBitrate;
        ((w)localObject1).gNU = parame.field_targetWidth;
        ((w)localObject1).gNV = parame.field_targetHeight;
        ((w)localObject1).frameRate = parame.field_frameRate;
        ((w)localObject1).audioSampleRate = parame.field_audioSampleRate;
        ((w)localObject1).gOt = parame.field_audioChannelCount;
        ((w)localObject1).gTI = parame.field_videoRotate;
        ((w)localObject1).AoR = ((adp)localObject3).gNK;
        ((w)localObject1).AoQ = ((int)((adp)localObject3).endTime);
        parame = paramafq.wqG;
        k.g(parame, "extraConfig.outputVideoPath");
        ((w)localObject1).ayl(parame);
        parame = (com.tencent.mm.bw.a)new don();
        paramafq = ((adp)localObject3).Ewq.toByteArray();
      }
    }
    catch (Exception localException)
    {
      try
      {
        parame.parseFrom(paramafq);
        parame = (don)parame;
        if (parame != null)
        {
          paramafq = parame.FWi;
          float f1 = ((adp)localObject3).Ewh;
          float f2 = ((adp)localObject3).Ewj;
          float f3 = ((adp)localObject3).Ewi;
          float f4 = ((adp)localObject3).Ewk;
          Object localObject4 = g.wmx;
          localObject3 = ((adp)localObject3).Esi;
          k.g(localObject3, "editorProtoData.baseItemData");
          localObject4 = ai.getContext();
          k.g(localObject4, "MMApplicationContext.getContext()");
          localObject3 = g.a((LinkedList)localObject3, (Context)localObject4);
          if (paramafq != null)
          {
            long l = paramafq.DXC;
            localObject4 = v.AoN;
            localObject4 = v.a.a(paramafq);
            String str = paramafq.FXO.FhD;
            k.g(str, "music.music_url");
            localObject4 = new y(l, (List)localObject4, str, paramafq);
            ((y)localObject4).p(new float[] { f1, f2, f3, f4 });
            ((y)localObject4).aF((ArrayList)localObject3);
            localObject1 = new d((y)localObject4, (w)localObject1);
            new StringBuilder("music url:").append(paramafq.FXO.FlY).append(" exist:").append(i.eA(paramafq.FXO.FlY));
            h.fCP();
            ((d)localObject1).ayn(paramafq.FXO.FlY);
            ((d)localObject1).ib(parame.aNa, parame.aNb);
            parame = (com.tencent.mm.plugin.recordvideo.background.b.c)localObject1;
            AppMethodBeat.o(111051);
            return parame;
            localException = localException;
            ac.l("safeParser", "", new Object[] { localException });
            Object localObject2 = null;
          }
        }
      }
      catch (Exception parame)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { parame });
          parame = null;
        }
      }
      h.eq("return null mixer");
      AppMethodBeat.o(111051);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.c
 * JD-Core Version:    0.7.0.1
 */