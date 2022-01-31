package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.g.b.a.f;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;

final class j$1
  implements g.a
{
  j$1(j paramj, long paramLong1, String paramString1, long paramLong2, int paramInt1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(27312);
    if (paramInt != 0)
    {
      ab.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[] { Long.valueOf(this.fEP), Integer.valueOf(paramInt), this.fEW });
      new f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(this.fET), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(this.fEX), "" })).ake();
      AppMethodBeat.o(27312);
      return paramInt;
    }
    if (paramd == null)
    {
      AppMethodBeat.o(27312);
      return 0;
    }
    label210:
    long l1;
    long l2;
    int i;
    int j;
    int k;
    if (paramd.field_retCode != 0)
    {
      ab.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Long.valueOf(this.fEP), Integer.valueOf(paramd.field_retCode), this.fEW });
      if (paramd != null) {
        break label904;
      }
      paramInt = -1;
      l1 = this.fET;
      l2 = bo.aoy();
      i = com.tencent.mm.al.c.cb(ah.getContext());
      j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      k = this.fEX;
      if (paramd != null) {
        break label913;
      }
      paramString = "";
      label248:
      if (paramd != null) {
        break label922;
      }
      paramc = "";
      label256:
      new f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramString, "", "", "", "", "", "", "", paramc })).ake();
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        if (paramd != null) {
          break label931;
        }
        paramInt = -1;
        label402:
        l1 = this.fET;
        l2 = bo.aoy();
        i = com.tencent.mm.al.c.cb(ah.getContext());
        j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        k = this.fEX;
        if (paramd != null) {
          break label940;
        }
        paramString = "";
        label440:
        if (paramd != null) {
          break label949;
        }
      }
    }
    label896:
    label904:
    label913:
    label922:
    label931:
    label940:
    label949:
    for (paramc = "";; paramc = paramd.edb)
    {
      new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramString, "", "", "", "", "", "", "", paramc })).ake();
      o.ahC().doNotify();
      AppMethodBeat.o(27312);
      return 0;
      aw.aaz();
      paramc = com.tencent.mm.model.c.YC().ag(this.euc, this.fEP);
      if (paramc.field_msgSvrId != this.fEP)
      {
        ab.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", new Object[] { Long.valueOf(this.fEP) });
        AppMethodBeat.o(27312);
        return 0;
      }
      ab.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", new Object[] { Long.valueOf(this.fEP), Integer.valueOf(paramc.getType()) });
      paramString = e.i(this.fEU, 0, -1);
      if ((this.vLl == 33) || (this.vLl == 36) || (this.vLl == 46) || (this.vLl == 44) || (this.vLl == 48))
      {
        paramString = o.ahC().a(paramString, Bitmap.CompressFormat.JPEG);
        label747:
        if (!bo.isNullOrNil(paramString))
        {
          paramc.kk(paramString);
          aw.aaz();
          com.tencent.mm.model.c.YC().b(paramc.field_msgSvrId, paramc);
        }
        ab.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[] { Long.valueOf(this.fEP), this.euc, this.fEW, paramString });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 16L, this.fEX, false);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 17L, 1L, false);
        paramString = com.tencent.mm.plugin.report.service.h.qsU;
        if (!t.lA(this.euc)) {
          break label896;
        }
      }
      for (l1 = 19L;; l1 = 18L)
      {
        paramString.idkeyStat(198L, l1, 1L, false);
        break;
        paramString = j.a(paramString, this.vLm, paramc.dxT());
        break label747;
      }
      paramInt = paramd.field_retCode;
      break label210;
      paramString = paramd.field_transInfo;
      break label248;
      paramc = paramd.edb;
      break label256;
      paramInt = paramd.field_retCode;
      break label402;
      paramString = paramd.field_transInfo;
      break label440;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.j.1
 * JD-Core Version:    0.7.0.1
 */