package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.d;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/ImportVideoTransfer;", "", "()V", "TAG", "", "enableAvcHard", "", "transferVideo", "", "inputPath", "outputPath", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-videologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s XRo;
  
  static
  {
    AppMethodBeat.i(244766);
    XRo = new s();
    AppMethodBeat.o(244766);
  }
  
  public static final int d(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(244761);
    kotlin.g.b.s.u(paramString1, "inputPath");
    kotlin.g.b.s.u(paramString2, "outputPath");
    kotlin.g.b.s.u(paramVideoTransPara, "videoParam");
    com.tencent.mm.modelvideo.c localc = d.bNM();
    int j = SightVideoJNI.getMp4RotateVFS(paramString1);
    label102:
    com.tencent.mm.modelvideo.b localb;
    boolean bool;
    switch (j)
    {
    default: 
      i = paramVideoTransPara.height;
      switch (j)
      {
      default: 
        j = paramVideoTransPara.width;
        paramVideoTransPara.width = i;
        paramVideoTransPara.height = j;
        localb = new com.tencent.mm.modelvideo.b(paramVideoTransPara);
        localb.oYb = false;
        if (paramVideoTransPara.oCh == 1) {
          localb.oYa = true;
        }
        if (!localb.oYa) {
          if (!iHZ())
          {
            bool = true;
            label160:
            localb.softEncode = bool;
            if (!localb.softEncode)
            {
              Log.i("MicroMsg.ImportVideoTransfer", "report avc hard encode");
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 52L, 1L, false);
            }
            label196:
            bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWs, false);
            paramVideoTransPara = f.aVX(paramString1);
            if (paramVideoTransPara != null) {
              break label406;
            }
          }
        }
        break;
      }
      break;
    }
    ah.a locala;
    label406:
    for (int i = 0;; i = paramVideoTransPara.videoDuration)
    {
      if ((i > 20000) && (bool) && (BuildInfo.IS_ARM64))
      {
        localb.oYd.oZL = true;
        localb.oYd.oZM = 2;
      }
      Log.i("MicroMsg.ImportVideoTransfer", "transferVideo softEncode:" + localb.softEncode + " outputHevc:" + localb.oYa + " parallelParam :" + localb.oYd);
      paramVideoTransPara = new Object();
      locala = new ah.a();
      locala.aiwY = localc.a(paramString1, paramString2, localb, (kotlin.g.a.b)new s.a(locala, paramVideoTransPara));
      if (locala.aiwY) {
        break label414;
      }
      AppMethodBeat.o(244761);
      return -1;
      i = paramVideoTransPara.width;
      break;
      j = paramVideoTransPara.height;
      break label102;
      bool = false;
      break label160;
      localb.softEncode = true;
      break label196;
    }
    for (;;)
    {
      try
      {
        label414:
        paramVideoTransPara.wait();
        paramString1 = ah.aiuX;
        if (locala.aiwY)
        {
          paramString1 = f.aVX(paramString2);
          if (paramString1 != null)
          {
            i = paramString1.videoDuration;
            if (i <= 0) {
              break;
            }
            i = Util.videoMsToSec(i);
            AppMethodBeat.o(244761);
            return i;
          }
        }
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.ImportVideoTransfer", (Throwable)paramString1, "", new Object[0]);
        continue;
      }
      finally
      {
        AppMethodBeat.o(244761);
      }
      i = -1;
    }
    AppMethodBeat.o(244761);
    return -1;
  }
  
  public static boolean iHZ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(244762);
    boolean bool1;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwN, 0) == 1)
    {
      bool1 = true;
      Log.i("MicroMsg.ImportVideoTransfer", "expt enableAvcHard:%s", new Object[] { Boolean.valueOf(bool1) });
      i locali = i.agtt;
      int i = i.a(b.a.agrz, 0);
      if (i == 0) {
        break label103;
      }
      Log.i("MicroMsg.ImportVideoTransfer", kotlin.g.b.s.X("debug repairerConfig:", Integer.valueOf(i)));
      if (i != 1) {
        break label98;
      }
      bool1 = bool2;
    }
    label98:
    label103:
    for (;;)
    {
      AppMethodBeat.o(244762);
      return bool1;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.s
 * JD-Core Version:    0.7.0.1
 */