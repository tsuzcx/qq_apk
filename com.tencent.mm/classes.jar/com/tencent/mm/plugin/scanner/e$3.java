package com.tencent.mm.plugin.scanner;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qc.a;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.b.a.t;
import com.tencent.mm.g.c.eg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.util.r.a;
import com.tencent.mm.plugin.scanner.util.r.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.util.HashMap;

final class e$3
  extends c<qc>
{
  e$3(e parame)
  {
    AppMethodBeat.i(138453);
    this.__eventId = qc.class.getName().hashCode();
    AppMethodBeat.o(138453);
  }
  
  private boolean a(qc paramqc)
  {
    AppMethodBeat.i(138454);
    if ((paramqc.cGF.scene == 1) && (!bo.isNullOrNil(paramqc.cGF.filePath))) {
      try
      {
        ab.i("MicroMsg.scanner.SubCoreScanner", "request to translate img %s, sessionId %d", new Object[] { paramqc.cGF.filePath, Integer.valueOf(paramqc.cGF.cnU) });
        Object localObject1 = ag.cE(paramqc.cGF.filePath + com.tencent.mm.vfs.e.avJ(paramqc.cGF.filePath));
        localObject1 = e.chX().cic().Yz((String)localObject1);
        if (localObject1 != null)
        {
          ab.i("MicroMsg.scanner.SubCoreScanner", "already has translation result");
          localObject2 = ((eg)localObject1).field_resultFile;
          if (d.decodeFile((String)localObject2, new BitmapFactory.Options()) != null)
          {
            localObject3 = new qd();
            ((qd)localObject3).cGG.cnU = paramqc.cGF.cnU;
            ((qd)localObject3).cGG.cnz = true;
            ((qd)localObject3).cGG.cGH = ((String)localObject2);
            ((qd)localObject3).cGG.cGI = ((eg)localObject1).field_fromLang;
            ((qd)localObject3).cGG.cGJ = ((eg)localObject1).field_toLang;
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
            e.a(this.qtF).remove(Integer.valueOf(paramqc.cGF.cnU));
            AppMethodBeat.o(138454);
            return true;
          }
          ab.w("MicroMsg.scanner.SubCoreScanner", "can not find old translation result!");
        }
        Object localObject3 = new t();
        ((t)localObject3).cSK = 4L;
        e.b(this.qtF).put(Integer.valueOf(paramqc.cGF.cnU), localObject3);
        com.tencent.mm.plugin.scanner.model.r localr = new com.tencent.mm.plugin.scanner.model.r();
        localr.fWT = paramqc.cGF.filePath;
        localr.quY = paramqc.cGF.filePath;
        final int i = Exif.fromFile(paramqc.cGF.filePath).getOrientationInDegree();
        ab.i("MicroMsg.scanner.SubCoreScanner", "original img degree %s", new Object[] { Integer.valueOf(i) });
        Object localObject2 = paramqc.cGF.filePath;
        final String str = com.tencent.mm.plugin.scanner.util.r.YO(paramqc.cGF.filePath);
        localObject1 = localObject2;
        if (i != 0)
        {
          Bitmap localBitmap = d.decodeFile(paramqc.cGF.filePath, new BitmapFactory.Options());
          localObject1 = localObject2;
          if (localBitmap != null)
          {
            localObject2 = d.b(localBitmap, i);
            e.chX();
            localObject1 = e.Yv("jpg");
            d.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
            localr.quY = ((String)localObject1);
          }
        }
        e.a(this.qtF).put(Integer.valueOf(paramqc.cGF.cnU), localr);
        final long l = System.currentTimeMillis();
        e.c(this.qtF).put(Integer.valueOf(paramqc.cGF.cnU), Long.valueOf(l));
        e.chX().qtu.a(str, (String)localObject1, com.tencent.mm.i.a.MediaType_IMAGE, new r.a()
        {
          public final void a(String paramAnonymousString, r.b paramAnonymousb)
          {
            AppMethodBeat.i(138452);
            if ((!bo.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(str)))
            {
              this.qtH.cSN = (System.currentTimeMillis() - l);
              ab.i("MicroMsg.scanner.SubCoreScanner", "upload img cost %d", new Object[] { Long.valueOf(this.qtH.cSN) });
              switch (paramAnonymousb.errCode)
              {
              }
            }
            for (;;)
            {
              if (this.qtL != 0)
              {
                ab.i("delete tmp path %s", i);
                com.tencent.mm.vfs.e.deleteFile(i);
              }
              AppMethodBeat.o(138452);
              return;
              if (!bo.Q(new String[] { paramAnonymousb.fileId, paramAnonymousb.aeskey }))
              {
                ab.i("MicroMsg.scanner.SubCoreScanner", "upload img success, fileId %s", new Object[] { paramAnonymousb.fileId });
                paramAnonymousString = new com.tencent.mm.plugin.scanner.model.e(this.qtJ.cGF.cnU, com.tencent.mm.a.e.cM(i), paramAnonymousb.fileId, paramAnonymousb.aeskey);
                g.Rc().a(paramAnonymousString, 0);
              }
              else
              {
                this.qtH.cSM = 3L;
                this.qtH.cSP = (System.currentTimeMillis() - l);
                this.qtH.ake();
                e.b(e.3.this.qtF).remove(Integer.valueOf(this.qtJ.cGF.cnU));
                e.c(e.3.this.qtF).remove(Integer.valueOf(this.qtJ.cGF.cnU));
                ab.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(e.b(e.3.this.qtF).size()), Integer.valueOf(e.c(e.3.this.qtF).size()) });
                e.a(e.3.this.qtF, this.qtJ.cGF.cnU);
                continue;
                this.qtH.cSM = 3L;
                this.qtH.cSP = (System.currentTimeMillis() - l);
                this.qtH.ake();
                e.b(e.3.this.qtF).remove(Integer.valueOf(this.qtJ.cGF.cnU));
                e.c(e.3.this.qtF).remove(Integer.valueOf(this.qtJ.cGF.cnU));
                ab.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", new Object[] { Integer.valueOf(e.b(e.3.this.qtF).size()), Integer.valueOf(e.c(e.3.this.qtF).size()) });
                e.a(e.3.this.qtF, this.qtJ.cGF.cnU);
              }
            }
          }
        });
        AppMethodBeat.o(138454);
        return true;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", localException, "", new Object[0]);
        e.a(this.qtF, paramqc.cGF.cnU);
      }
    }
    AppMethodBeat.o(138454);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.3
 * JD-Core Version:    0.7.0.1
 */