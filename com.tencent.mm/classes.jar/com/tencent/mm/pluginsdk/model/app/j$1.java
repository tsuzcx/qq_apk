package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.as.o;
import com.tencent.mm.h.b.a.f;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;

final class j$1
  implements f.a
{
  j$1(j paramj, long paramLong1, String paramString1, long paramLong2, int paramInt1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      y.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[] { Long.valueOf(this.eos), Integer.valueOf(paramInt), this.eoz });
      new f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(this.eow), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_THUMBIMAGE), Integer.valueOf(this.eoA), "" })).QX();
      return paramInt;
    }
    if (paramd == null) {
      return 0;
    }
    label192:
    long l1;
    long l2;
    int i;
    int j;
    int k;
    if (paramd.field_retCode != 0)
    {
      y.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Long.valueOf(this.eos), Integer.valueOf(paramd.field_retCode), this.eoz });
      if (paramd != null) {
        break label847;
      }
      paramInt = -1;
      l1 = this.eow;
      l2 = bk.UY();
      i = com.tencent.mm.ak.c.bx(ae.getContext());
      j = com.tencent.mm.j.a.MediaType_THUMBIMAGE;
      k = this.eoA;
      if (paramd != null) {
        break label856;
      }
      paramString = "";
      label230:
      if (paramd != null) {
        break label865;
      }
      paramc = "";
      label238:
      new f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramString, "", "", "", "", "", "", "", paramc })).QX();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label874;
        }
        paramInt = -1;
        label384:
        l1 = this.eow;
        l2 = bk.UY();
        i = com.tencent.mm.ak.c.bx(ae.getContext());
        j = com.tencent.mm.j.a.MediaType_THUMBIMAGE;
        k = this.eoA;
        if (paramd != null) {
          break label883;
        }
        paramString = "";
        label422:
        if (paramd != null) {
          break label892;
        }
      }
    }
    label690:
    label839:
    label847:
    label856:
    label865:
    label874:
    label883:
    label892:
    for (paramc = "";; paramc = paramd.dlG)
    {
      new com.tencent.mm.h.b.a.d(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramString, "", "", "", "", "", "", "", paramc })).QX();
      o.OJ().doNotify();
      return 0;
      au.Hx();
      paramc = com.tencent.mm.model.c.Fy().O(this.dAA, this.eos);
      if (paramc.field_msgSvrId != this.eos)
      {
        y.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", new Object[] { Long.valueOf(this.eos) });
        return 0;
      }
      y.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", new Object[] { Long.valueOf(this.eos), Integer.valueOf(paramc.getType()) });
      paramString = e.c(this.eox, 0, -1);
      if ((this.rUo == 33) || (this.rUo == 36))
      {
        paramString = o.OJ().a(paramString, Bitmap.CompressFormat.JPEG);
        if (!bk.bl(paramString))
        {
          paramc.ed(paramString);
          au.Hx();
          com.tencent.mm.model.c.Fy().b(paramc.field_msgSvrId, paramc);
        }
        y.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[] { Long.valueOf(this.eos), this.dAA, this.eoz, paramString });
        h.nFQ.a(198L, 16L, this.eoA, false);
        h.nFQ.a(198L, 17L, 1L, false);
        paramString = h.nFQ;
        if (!s.fn(this.dAA)) {
          break label839;
        }
      }
      for (l1 = 19L;; l1 = 18L)
      {
        paramString.a(198L, l1, 1L, false);
        break;
        paramString = j.a(paramString, this.rUp, paramc.cvp());
        break label690;
      }
      paramInt = paramd.field_retCode;
      break label192;
      paramString = paramd.field_transInfo;
      break label230;
      paramc = paramd.dlG;
      break label238;
      paramInt = paramd.field_retCode;
      break label384;
      paramString = paramd.field_transInfo;
      break label422;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.j.1
 * JD-Core Version:    0.7.0.1
 */