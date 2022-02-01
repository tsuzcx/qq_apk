package com.tencent.mm.plugin.vlog.remux;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.ae.a;
import com.tencent.mm.plugin.vlog.model.af;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.protocal.protobuf.fvr;
import com.tencent.mm.protocal.protobuf.fyd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.plugin.recordvideo.background.c.a
{
  public static final a Uet;
  
  static
  {
    AppMethodBeat.i(111052);
    Uet = new a((byte)0);
    AppMethodBeat.o(111052);
  }
  
  public final com.tencent.mm.plugin.recordvideo.background.c.c a(com.tencent.mm.plugin.recordvideo.background.c paramc, apw paramapw)
  {
    AppMethodBeat.i(111051);
    s.u(paramc, "editorData");
    s.u(paramapw, "extraConfig");
    Object localObject1 = (com.tencent.mm.bx.a)new ami();
    Object localObject3 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (ami)localObject1;
      if (localObject3 != null)
      {
        localObject1 = new af();
        ((af)localObject1).audioBitrate = paramc.field_audioBitrate;
        ((af)localObject1).videoBitrate = paramc.field_videoBitrate;
        ((af)localObject1).nxO = paramc.field_targetWidth;
        ((af)localObject1).nxP = paramc.field_targetHeight;
        ((af)localObject1).frameRate = paramc.field_frameRate;
        ((af)localObject1).audioSampleRate = paramc.field_audioSampleRate;
        ((af)localObject1).audioChannelCount = paramc.field_audioChannelCount;
        ((af)localObject1).nCg = paramc.field_videoRotate;
        ((af)localObject1).UaT = ((ami)localObject3).nxj;
        ((af)localObject1).UaS = ((int)((ami)localObject3).endTime);
        paramc = paramapw.NIe;
        s.s(paramc, "extraConfig.outputVideoPath");
        ((af)localObject1).bff(paramc);
        paramc = (com.tencent.mm.bx.a)new fvr();
        paramapw = ((ami)localObject3).Ztp.toByteArray();
      }
    }
    catch (Exception localException)
    {
      try
      {
        paramc.parseFrom(paramapw);
        paramc = (fvr)paramc;
        if (paramc != null)
        {
          paramapw = paramc.abTR;
          float f1 = ((ami)localObject3).Ztg;
          float f2 = ((ami)localObject3).Zti;
          float f3 = ((ami)localObject3).Zth;
          float f4 = ((ami)localObject3).Ztj;
          Object localObject4 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
          localObject3 = ((ami)localObject3).Znd;
          s.s(localObject3, "editorProtoData.baseItemData");
          localObject4 = MMApplicationContext.getContext();
          s.s(localObject4, "getContext()");
          localObject3 = com.tencent.mm.plugin.recordvideo.background.e.a((LinkedList)localObject3, (Context)localObject4);
          if (paramapw != null)
          {
            long l = paramapw.YNt;
            localObject4 = ae.UaJ;
            localObject4 = ae.a.a(paramapw);
            String str = paramapw.abVZ.aaRO;
            s.s(str, "music.music_url");
            localObject4 = new ah(l, (List)localObject4, str, paramapw);
            ((ah)localObject4).A(new float[] { f1, f2, f3, f4 });
            ((ah)localObject4).bI((ArrayList)localObject3);
            localObject1 = new e((ah)localObject4, (af)localObject1);
            Log.i("MicroMsg.VLogMixerInstanceManager", "music url:" + paramapw.abVZ.aaYN + " exist:" + y.ZC(paramapw.abVZ.aaYN));
            ((e)localObject1).bfm(paramapw.abVZ.aaYN);
            ((e)localObject1).mz(paramc.previewWidth, paramc.previewHeight);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.d
 * JD-Core Version:    0.7.0.1
 */