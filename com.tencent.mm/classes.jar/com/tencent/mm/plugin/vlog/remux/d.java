package com.tencent.mm.plugin.vlog.remux;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.ae.a;
import com.tencent.mm.plugin.vlog.model.af;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.ezn;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-vlog_release"})
public final class d
  implements com.tencent.mm.plugin.recordvideo.background.c.a
{
  public static final a NqG;
  
  static
  {
    AppMethodBeat.i(111052);
    NqG = new a((byte)0);
    AppMethodBeat.o(111052);
  }
  
  public final com.tencent.mm.plugin.recordvideo.background.c.c a(com.tencent.mm.plugin.recordvideo.background.c paramc, ame paramame)
  {
    AppMethodBeat.i(111051);
    p.k(paramc, "editorData");
    p.k(paramame, "extraConfig");
    Object localObject1 = (com.tencent.mm.cd.a)new ajd();
    Object localObject3 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (ajd)localObject1;
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
        ((af)localObject1).kWG = paramc.field_videoRotate;
        ((af)localObject1).Nns = ((ajd)localObject3).kRX;
        ((af)localObject1).Nnr = ((int)((ajd)localObject3).endTime);
        paramc = paramame.HLg;
        p.j(paramc, "extraConfig.outputVideoPath");
        ((af)localObject1).bfy(paramc);
        paramc = (com.tencent.mm.cd.a)new ezn();
        paramame = ((ajd)localObject3).StF.toByteArray();
      }
    }
    catch (Exception localException)
    {
      try
      {
        paramc.parseFrom(paramame);
        paramc = (ezn)paramc;
        if (paramc != null)
        {
          paramame = paramc.UzO;
          float f1 = ((ajd)localObject3).Stw;
          float f2 = ((ajd)localObject3).Sty;
          float f3 = ((ajd)localObject3).Stx;
          float f4 = ((ajd)localObject3).Stz;
          Object localObject4 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
          localObject3 = ((ajd)localObject3).Sor;
          p.j(localObject3, "editorProtoData.baseItemData");
          localObject4 = MMApplicationContext.getContext();
          p.j(localObject4, "MMApplicationContext.getContext()");
          localObject3 = com.tencent.mm.plugin.recordvideo.background.e.a((LinkedList)localObject3, (Context)localObject4);
          if (paramame != null)
          {
            long l = paramame.RQc;
            localObject4 = ae.Nno;
            localObject4 = ae.a.a(paramame);
            String str = paramame.UBQ.TCi;
            p.j(str, "music.music_url");
            localObject4 = new ah(l, (List)localObject4, str, paramame);
            ((ah)localObject4).q(new float[] { f1, f2, f3, f4 });
            ((ah)localObject4).bh((ArrayList)localObject3);
            localObject1 = new e((ah)localObject4, (af)localObject1);
            Log.i("MicroMsg.VLogMixerInstanceManager", "music url:" + paramame.UBQ.TIY + " exist:" + u.agG(paramame.UBQ.TIY));
            ((e)localObject1).bfF(paramame.UBQ.TIY);
            ((e)localObject1).kJ(paramc.previewWidth, paramc.previewHeight);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.d
 * JD-Core Version:    0.7.0.1
 */