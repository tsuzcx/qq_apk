package com.tencent.mm.plugin.vlog.remux;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.ae.a;
import com.tencent.mm.plugin.vlog.model.af;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-vlog_release"})
public final class c
  implements com.tencent.mm.plugin.recordvideo.background.c.a
{
  public static final a GCW;
  
  static
  {
    AppMethodBeat.i(111052);
    GCW = new a((byte)0);
    AppMethodBeat.o(111052);
  }
  
  public final com.tencent.mm.plugin.recordvideo.background.c.c a(com.tencent.mm.plugin.recordvideo.background.c paramc, ald paramald)
  {
    AppMethodBeat.i(111051);
    p.h(paramc, "editorData");
    p.h(paramald, "extraConfig");
    Object localObject1 = (com.tencent.mm.bw.a)new aio();
    Object localObject3 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (aio)localObject1;
      if (localObject3 != null)
      {
        localObject1 = new af();
        ((af)localObject1).audioBitrate = paramc.field_audioBitrate;
        ((af)localObject1).videoBitrate = paramc.field_videoBitrate;
        ((af)localObject1).targetWidth = paramc.field_targetWidth;
        ((af)localObject1).targetHeight = paramc.field_targetHeight;
        ((af)localObject1).frameRate = paramc.field_frameRate;
        ((af)localObject1).audioSampleRate = paramc.field_audioSampleRate;
        ((af)localObject1).audioChannelCount = paramc.field_audioChannelCount;
        ((af)localObject1).ihS = paramc.field_videoRotate;
        ((af)localObject1).GzM = ((aio)localObject3).idq;
        ((af)localObject1).GzL = ((int)((aio)localObject3).endTime);
        paramc = paramald.BOA;
        p.g(paramc, "extraConfig.outputVideoPath");
        ((af)localObject1).aUb(paramc);
        paramc = (com.tencent.mm.bw.a)new epc();
        paramald = ((aio)localObject3).Lsd.toByteArray();
      }
    }
    catch (Exception localException)
    {
      try
      {
        paramc.parseFrom(paramald);
        paramc = (epc)paramc;
        if (paramc != null)
        {
          paramald = paramc.NmX;
          float f1 = ((aio)localObject3).LrU;
          float f2 = ((aio)localObject3).LrW;
          float f3 = ((aio)localObject3).LrV;
          float f4 = ((aio)localObject3).LrX;
          Object localObject4 = e.BKp;
          localObject3 = ((aio)localObject3).Lna;
          p.g(localObject3, "editorProtoData.baseItemData");
          localObject4 = MMApplicationContext.getContext();
          p.g(localObject4, "MMApplicationContext.getContext()");
          localObject3 = e.a((LinkedList)localObject3, (Context)localObject4);
          if (paramald != null)
          {
            long l = paramald.KPe;
            localObject4 = ae.GzI;
            localObject4 = ae.a.a(paramald);
            String str = paramald.NoU.MqU;
            p.g(str, "music.music_url");
            localObject4 = new ah(l, (List)localObject4, str, paramald);
            ((ah)localObject4).p(new float[] { f1, f2, f3, f4 });
            ((ah)localObject4).aT((ArrayList)localObject3);
            localObject1 = new d((ah)localObject4, (af)localObject1);
            Log.i("MicroMsg.VLogMixerInstanceManager", "music url:" + paramald.NoU.MxH + " exist:" + s.YS(paramald.NoU.MxH));
            ((d)localObject1).aUg(paramald.NoU.MxH);
            ((d)localObject1).jw(paramc.previewWidth, paramc.previewHeight);
            paramc = (com.tencent.mm.plugin.recordvideo.background.c.c)localObject1;
            AppMethodBeat.o(111051);
            return paramc;
            localException = localException;
            Log.printDebugStack("safeParser", "", new Object[] { localException });
            Object localObject2 = null;
          }
        }
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramc });
          paramc = null;
        }
      }
      Log.e("MicroMsg.VLogMixerInstanceManager", "return null mixer");
      AppMethodBeat.o(111051);
    }
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.c
 * JD-Core Version:    0.7.0.1
 */