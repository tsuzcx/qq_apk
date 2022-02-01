package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.report.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tav.core.AssetImageGenerator.AssetImageGeneratorResult;
import com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener;
import com.tencent.tav.coremedia.CMTime;
import d.a.j;
import d.g.b.k;
import d.g.b.v.e;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "requestedTime", "Lcom/tencent/tav/coremedia/CMTime;", "bitmap", "Landroid/graphics/Bitmap;", "actualTime", "result", "Lcom/tencent/tav/core/AssetImageGenerator$AssetImageGeneratorResult;", "onCompletion"})
final class t$c
  implements AssetImageGenerator.ImageGeneratorListener
{
  t$c(t paramt) {}
  
  public final void onCompletion(CMTime paramCMTime1, Bitmap paramBitmap, CMTime arg3, AssetImageGenerator.AssetImageGeneratorResult paramAssetImageGeneratorResult)
  {
    AppMethodBeat.i(207608);
    k.h(paramCMTime1, "requestedTime");
    k.h(paramAssetImageGeneratorResult, "result");
    if (paramAssetImageGeneratorResult != AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded)
    {
      paramCMTime1 = a.Apq;
      a.efQ();
      AppMethodBeat.o(207608);
      return;
    }
    if (paramBitmap == null)
    {
      paramCMTime1 = a.Apq;
      a.efP();
      AppMethodBeat.o(207608);
      return;
    }
    paramAssetImageGeneratorResult = new v.e();
    paramAssetImageGeneratorResult.KUP = -1L;
    synchronized (t.a(this.Aor))
    {
      j.a((List)t.a(this.Aor), (d.g.a.b)new t.c.a(this, paramCMTime1, paramAssetImageGeneratorResult, paramBitmap));
      ac.i("MicroMsg.VLogCompositionCoverGenerator", "get " + this.Aor.hashCode() + ": " + paramAssetImageGeneratorResult.KUP + 65292 + paramCMTime1.getTimeUs() / 1000L);
      if (paramAssetImageGeneratorResult.KUP >= 0L) {
        t.efF().put(t.b(this.Aor) + '-' + paramAssetImageGeneratorResult.KUP, paramBitmap);
      }
      AppMethodBeat.o(207608);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.t.c
 * JD-Core Version:    0.7.0.1
 */