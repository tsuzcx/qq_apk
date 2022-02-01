package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.c;
import com.tencent.mm.modelvideo.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/ImportVideoTransfer;", "", "()V", "TAG", "", "transferVideo", "", "inputPath", "outputPath", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-videologic_release"})
public final class q
{
  public static final q QVq;
  
  static
  {
    AppMethodBeat.i(216708);
    QVq = new q();
    AppMethodBeat.o(216708);
  }
  
  public static final int d(String paramString1, String paramString2, final VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(216705);
    p.k(paramString1, "inputPath");
    p.k(paramString2, "outputPath");
    p.k(paramVideoTransPara, "videoParam");
    c localc = d.bqg();
    int j = SightVideoJNI.getMp4RotateVFS(paramString1);
    int i;
    if ((j == 0) || (j == 180))
    {
      i = paramVideoTransPara.width;
      if ((j != 0) && (j != 180)) {
        break label187;
      }
    }
    aa.a locala;
    label187:
    for (j = paramVideoTransPara.height;; j = paramVideoTransPara.width)
    {
      paramVideoTransPara.width = i;
      paramVideoTransPara.height = j;
      com.tencent.mm.modelvideo.b localb = new com.tencent.mm.modelvideo.b(paramVideoTransPara);
      localb.softEncode = true;
      localb.mfi = false;
      if (paramVideoTransPara.lJF == 1) {
        localb.mfh = true;
      }
      paramVideoTransPara = new Object();
      locala = new aa.a();
      locala.aaBx = localc.a(paramString1, paramString2, localb, (kotlin.g.a.b)new a(locala, paramVideoTransPara));
      if (locala.aaBx) {
        break label196;
      }
      AppMethodBeat.o(216705);
      return -1;
      i = paramVideoTransPara.height;
      break;
    }
    for (;;)
    {
      try
      {
        label196:
        paramVideoTransPara.wait();
        paramString1 = x.aazN;
        if (locala.aaBx)
        {
          paramString1 = f.aYg(paramString2);
          if (paramString1 != null)
          {
            i = paramString1.videoDuration;
            if (i <= 0) {
              break;
            }
            i = Util.videoMsToSec(i);
            AppMethodBeat.o(216705);
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
        AppMethodBeat.o(216705);
      }
      i = -1;
    }
    AppMethodBeat.o(216705);
    return -1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    a(aa.a parama, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.q
 * JD-Core Version:    0.7.0.1
 */