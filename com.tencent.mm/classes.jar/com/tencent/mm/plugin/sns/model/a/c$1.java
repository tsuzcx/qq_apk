package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.f;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;

final class c$1
  implements g.a
{
  c$1(c paramc, com.tencent.mm.i.e parame, long paramLong) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(36746);
    if (this.rke.rjH == null)
    {
      ab.e("MicroMsg.SnsCdnDownloadBase", "pack is null.");
      AppMethodBeat.o(36746);
      return 0;
    }
    int j;
    int i;
    int k;
    com.tencent.mm.plugin.sns.data.e locale;
    if (paramd != null) {
      if (paramd.field_retCode != 0)
      {
        ab.e("MicroMsg.SnsCdnDownloadBase", "download err, retCode: %d reqDownType: %d.", new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(this.rke.rjH.rjC) });
        com.tencent.mm.network.b.reportFailIp(paramd.field_serverIP);
        if (9 != this.rke.rjH.rjC) {
          break label1011;
        }
        paramString = paramd.ede;
        if ((paramString != null) && (paramString.length > 0))
        {
          h.qsU.cT(1040, 12);
          paramc = (f)this.rkc;
          ab.e("MicroMsg.SnsCdnDownloadBase", "download err, taskInfo2 need inc counter, before: %d, inc: %d, count: %d.", new Object[] { Integer.valueOf(paramc.counter), Integer.valueOf(paramString.length), Integer.valueOf(paramc.edn) });
          paramc.counter += paramString.length;
          j = paramString.length;
          i = 0;
          while (i < j)
          {
            paramc = paramString[i];
            if (paramc.retry)
            {
              k = paramc.picIndex;
              paramc = (bcs)this.rke.rjH.rbn.get(k);
              locale = (com.tencent.mm.plugin.sns.data.e)this.rke.rjH.rbd.get(k);
              ag.cpa().a(paramc, 1, locale, this.rke.rjH.rjD);
              ab.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
            }
            i += 1;
          }
          i = 2;
        }
      }
    }
    for (;;)
    {
      this.rke.b(paramd);
      ag.bEf().post(new c.1.1(this, i, paramd));
      for (;;)
      {
        if (paramInt == 0) {
          break label1004;
        }
        ab.e("MicroMsg.SnsCdnDownloadBase", "task build error! startRet: %d, type: %d.", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rke.rjH.rjC) });
        if (9 != this.rke.rjH.rjC) {
          break label1004;
        }
        h.qsU.cT(1040, 13);
        c.cpW().remove(this.rke.rjH.reG);
        this.rke.rjF.a(2, null, this.rke.rjH.rjC, this.rke.rjH.rjA, this.rke.rjH.reG, -1, -1, true);
        paramString = ((f)this.rkc).ede;
        i = paramString.length;
        paramInt = 0;
        while (paramInt < i)
        {
          j = paramString[paramInt].picIndex;
          paramc = (bcs)this.rke.rjH.rbn.get(j);
          paramd = (com.tencent.mm.plugin.sns.data.e)this.rke.rjH.rbd.get(j);
          ag.cpa().a(paramc, 1, paramd, this.rke.rjH.rjD);
          ab.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(j) });
          paramInt += 1;
        }
        h.qsU.cT(1040, 14);
        ab.e("MicroMsg.SnsCdnDownloadBase", "download error, totally re-download by single.");
        paramString = (f)this.rkc;
        paramString.counter = paramString.edn;
        paramString = paramString.ede;
        j = paramString.length;
        i = 0;
        while (i < j)
        {
          k = paramString[i].picIndex;
          paramc = (bcs)this.rke.rjH.rbn.get(k);
          locale = (com.tencent.mm.plugin.sns.data.e)this.rke.rjH.rbd.get(k);
          ag.cpa().a(paramc, 1, locale, this.rke.rjH.rjD);
          ab.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", new Object[] { Integer.valueOf(k) });
          i += 1;
        }
        i = 2;
        break;
        ab.d("MicroMsg.SnsCdnDownloadBase", "download succ, type: %d.", new Object[] { Integer.valueOf(this.rke.rjH.rjC) });
        this.rke.rka = paramd.field_fileLength;
        if (9 == this.rke.rjH.rjC)
        {
          paramString = (f)this.rkc;
          paramString.counter += 1;
          ab.d("MicroMsg.SnsCdnDownloadBase", "download succ, counter++, res: %d, count: %d.", new Object[] { Integer.valueOf(paramString.counter), Integer.valueOf(paramString.edn) });
        }
        for (paramBoolean = this.rke.DY(paramd.index);; paramBoolean = this.rke.cpR())
        {
          if (paramBoolean) {
            break label879;
          }
          i = 2;
          break;
        }
        label879:
        if (this.rke.rjH.rjA)
        {
          i = 3;
          break;
        }
        i = 1;
        break;
        if (paramc != null)
        {
          float f = paramc.field_finishedLength / paramc.field_toltalLength;
          if (this.rke.rjH.rjE < f)
          {
            this.rke.rjH.rjE = f;
            ab.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", new Object[] { Integer.valueOf(this.rke.rjH.rjC), paramString, Float.valueOf(f), this.rke.rjH.url });
          }
        }
      }
      label1004:
      AppMethodBeat.o(36746);
      return 0;
      label1011:
      i = 2;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c.1
 * JD-Core Version:    0.7.0.1
 */