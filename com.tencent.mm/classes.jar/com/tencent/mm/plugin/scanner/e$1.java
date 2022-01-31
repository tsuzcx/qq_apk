package com.tencent.mm.plugin.scanner;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.b.a.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.q;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.plugin.scanner.util.p.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.util.HashMap;

final class e$1
  implements p.b
{
  e$1(e parame) {}
  
  public final void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(80774);
    if (e.a(this.qtF).containsKey(Integer.valueOf(paramInt)))
    {
      if ((e.b(this.qtF).containsKey(Integer.valueOf(paramInt))) && (e.c(this.qtF).containsKey(Integer.valueOf(paramInt))))
      {
        ((t)e.b(this.qtF).get(Integer.valueOf(paramInt))).cSP = (System.currentTimeMillis() - ((Long)e.c(this.qtF).get(Integer.valueOf(paramInt))).longValue());
        ((t)e.b(this.qtF).get(Integer.valueOf(paramInt))).ake();
        e.b(this.qtF).remove(Integer.valueOf(paramInt));
        e.c(this.qtF).remove(Integer.valueOf(paramInt));
        ab.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(e.b(this.qtF).size()), Integer.valueOf(e.c(this.qtF).size()) });
      }
      if (!g.RG())
      {
        AppMethodBeat.o(80774);
        return;
      }
      e.chX();
      String str = e.Yu("jpg");
      try
      {
        d.a(paramBitmap, 80, Bitmap.CompressFormat.JPEG, str, false);
        Object localObject = new q();
        paramBitmap = (r)e.a(this.qtF).get(Integer.valueOf(paramInt));
        ((q)localObject).field_originMD5 = ag.cE(paramBitmap.fWT + com.tencent.mm.vfs.e.avJ(paramBitmap.fWT));
        ((q)localObject).field_resultFile = str;
        ((q)localObject).field_fromLang = paramBitmap.cGI;
        ((q)localObject).field_toLang = paramBitmap.cGJ;
        ab.i("MicroMsg.scanner.SubCoreScanner", "translate %d success, insert translate result %s", new Object[] { Integer.valueOf(paramInt), str });
        e.chX().cic().insert((c)localObject);
        localObject = new qd();
        ((qd)localObject).cGG.cnU = paramInt;
        ((qd)localObject).cGG.cnz = true;
        ((qd)localObject).cGG.cGH = str;
        ((qd)localObject).cGG.cGI = paramBitmap.cGI;
        ((qd)localObject).cGG.cGJ = paramBitmap.cGJ;
        a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
        e.a(this.qtF).remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(80774);
        return;
      }
      catch (IOException paramBitmap)
      {
        ab.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", paramBitmap, "save translate result file error", new Object[0]);
        e.a(this.qtF, paramInt);
      }
    }
    AppMethodBeat.o(80774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.1
 * JD-Core Version:    0.7.0.1
 */