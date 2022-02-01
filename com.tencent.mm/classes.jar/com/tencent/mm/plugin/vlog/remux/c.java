package com.tencent.mm.plugin.vlog.remux;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.plugin.vlog.model.x;
import com.tencent.mm.plugin.vlog.model.x.a;
import com.tencent.mm.plugin.vlog.model.y;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.protocal.protobuf.dxb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-vlog_release"})
public final class c
  implements com.tencent.mm.plugin.recordvideo.background.c.a
{
  public static final a Cbi;
  
  static
  {
    AppMethodBeat.i(111052);
    Cbi = new a((byte)0);
    AppMethodBeat.o(111052);
  }
  
  public final com.tencent.mm.plugin.recordvideo.background.c.c a(com.tencent.mm.plugin.recordvideo.background.c paramc, aip paramaip)
  {
    AppMethodBeat.i(111051);
    p.h(paramc, "editorData");
    p.h(paramaip, "extraConfig");
    Object localObject1 = (com.tencent.mm.bw.a)new agh();
    Object localObject3 = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (agh)localObject1;
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
        ((y)localObject1).hoy = paramc.field_videoRotate;
        ((y)localObject1).BYh = ((agh)localObject3).hku;
        ((y)localObject1).BYg = ((int)((agh)localObject3).endTime);
        paramc = paramaip.xOt;
        p.g(paramc, "extraConfig.outputVideoPath");
        ((y)localObject1).aEK(paramc);
        paramc = (com.tencent.mm.bw.a)new dvb();
        paramaip = ((agh)localObject3).Gwx.toByteArray();
      }
    }
    catch (Exception localException)
    {
      try
      {
        paramc.parseFrom(paramaip);
        paramc = (dvb)paramc;
        if (paramc != null)
        {
          paramaip = paramc.IaL;
          float f1 = ((agh)localObject3).Gwo;
          float f2 = ((agh)localObject3).Gwq;
          float f3 = ((agh)localObject3).Gwp;
          float f4 = ((agh)localObject3).Gwr;
          Object localObject4 = e.xKl;
          localObject3 = ((agh)localObject3).GrR;
          p.g(localObject3, "editorProtoData.baseItemData");
          localObject4 = ak.getContext();
          p.g(localObject4, "MMApplicationContext.getContext()");
          localObject3 = e.a((LinkedList)localObject3, (Context)localObject4);
          if (paramaip != null)
          {
            long l = paramaip.FVt;
            localObject4 = x.BYd;
            localObject4 = x.a.a(paramaip);
            String str = paramaip.Icw.HkG;
            p.g(str, "music.music_url");
            localObject4 = new aa(l, (List)localObject4, str, paramaip);
            ((aa)localObject4).p(new float[] { f1, f2, f3, f4 });
            ((aa)localObject4).aC((ArrayList)localObject3);
            localObject1 = new d((aa)localObject4, (y)localObject1);
            ae.i("MicroMsg.VLogMixerInstanceManager", "music url:" + paramaip.Icw.Hpi + " exist:" + o.fB(paramaip.Icw.Hpi));
            ((d)localObject1).aEM(paramaip.Icw.Hpi);
            ((d)localObject1).iu(paramc.aXs, paramc.aXt);
            paramc = (com.tencent.mm.plugin.recordvideo.background.c.c)localObject1;
            AppMethodBeat.o(111051);
            return paramc;
            localException = localException;
            ae.l("safeParser", "", new Object[] { localException });
            Object localObject2 = null;
          }
        }
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { paramc });
          paramc = null;
        }
      }
      ae.e("MicroMsg.VLogMixerInstanceManager", "return null mixer");
      AppMethodBeat.o(111051);
    }
    return null;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.c
 * JD-Core Version:    0.7.0.1
 */