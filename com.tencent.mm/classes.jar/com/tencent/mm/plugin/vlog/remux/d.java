package com.tencent.mm.plugin.vlog.remux;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.recordvideo.background.b.c;
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.plugin.vlog.model.z;
import com.tencent.mm.plugin.vlog.model.z.a;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-vlog_release"})
public final class d
  implements com.tencent.mm.plugin.recordvideo.background.b.a
{
  public static final a zbi;
  
  static
  {
    AppMethodBeat.i(111052);
    zbi = new a((byte)0);
    AppMethodBeat.o(111052);
  }
  
  public final c a(com.tencent.mm.plugin.recordvideo.background.d paramd, aer paramaer)
  {
    AppMethodBeat.i(111051);
    k.h(paramd, "editorData");
    k.h(paramaer, "extraConfig");
    Object localObject1 = (com.tencent.mm.bx.a)new acq();
    Object localObject3 = paramd.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (acq)localObject1;
      if (localObject3 != null)
      {
        localObject1 = new com.tencent.mm.plugin.vlog.model.g();
        ((com.tencent.mm.plugin.vlog.model.g)localObject1).audioBitrate = paramd.field_audioBitrate;
        ((com.tencent.mm.plugin.vlog.model.g)localObject1).videoBitrate = paramd.field_videoBitrate;
        ((com.tencent.mm.plugin.vlog.model.g)localObject1).gnh = paramd.field_targetWidth;
        ((com.tencent.mm.plugin.vlog.model.g)localObject1).gni = paramd.field_targetHeight;
        ((com.tencent.mm.plugin.vlog.model.g)localObject1).frameRate = paramd.field_frameRate;
        ((com.tencent.mm.plugin.vlog.model.g)localObject1).audioSampleRate = paramd.field_audioSampleRate;
        ((com.tencent.mm.plugin.vlog.model.g)localObject1).gnH = paramd.field_audioChannelCount;
        ((com.tencent.mm.plugin.vlog.model.g)localObject1).gta = paramd.field_videoRotate;
        ((com.tencent.mm.plugin.vlog.model.g)localObject1).yZq = ((acq)localObject3).gmX;
        ((com.tencent.mm.plugin.vlog.model.g)localObject1).yZp = ((int)((acq)localObject3).endTime);
        paramd = paramaer.vhU;
        k.g(paramd, "extraConfig.outputVideoPath");
        ((com.tencent.mm.plugin.vlog.model.g)localObject1).asV(paramd);
        paramd = (com.tencent.mm.bx.a)new diy();
        paramaer = ((acq)localObject3).Ddk.toByteArray();
      }
    }
    catch (Exception localException)
    {
      try
      {
        paramd.parseFrom(paramaer);
        paramd = (diy)paramd;
        if (paramd != null)
        {
          paramaer = paramd.Ezg;
          float f1 = ((acq)localObject3).Dda;
          float f2 = ((acq)localObject3).Ddc;
          float f3 = ((acq)localObject3).Ddb;
          float f4 = ((acq)localObject3).Ddd;
          Object localObject4 = f.vdH;
          localObject3 = ((acq)localObject3).Dde;
          k.g(localObject3, "editorProtoData.baseItemData");
          localObject4 = aj.getContext();
          k.g(localObject4, "MMApplicationContext.getContext()");
          localObject3 = f.a((LinkedList)localObject3, (Context)localObject4);
          if (paramaer != null)
          {
            long l = paramaer.CFc;
            localObject4 = z.LrD;
            localObject4 = z.a.a(paramaer);
            String str = paramaer.EAA.DLo;
            k.g(str, "music.music_url");
            localObject4 = new com.tencent.mm.plugin.vlog.model.h(l, (List)localObject4, str, paramaer);
            ((com.tencent.mm.plugin.vlog.model.h)localObject4).p(new float[] { f1, f2, f3, f4 });
            ((com.tencent.mm.plugin.vlog.model.h)localObject4).at((ArrayList)localObject3);
            localObject1 = new g((com.tencent.mm.plugin.vlog.model.h)localObject4, (com.tencent.mm.plugin.vlog.model.g)localObject1);
            new StringBuilder("music url:").append(paramaer.EAA.DPH).append(" exist:").append(i.eK(paramaer.EAA.DPH));
            com.tencent.d.f.h.fmz();
            ((g)localObject1).asX(paramaer.EAA.DPH);
            ((g)localObject1).hN(paramd.aMk, paramd.aMl);
            paramd = (c)localObject1;
            AppMethodBeat.o(111051);
            return paramd;
            localException = localException;
            ad.l("safeParser", "", new Object[] { localException });
            Object localObject2 = null;
          }
        }
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { paramd });
          paramd = null;
        }
      }
      com.tencent.d.f.h.ep("return null mixer");
      AppMethodBeat.o(111051);
    }
    return null;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.d
 * JD-Core Version:    0.7.0.1
 */