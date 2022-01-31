package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ah.m;
import com.tencent.mm.as.d.a;
import com.tencent.mm.as.e;
import com.tencent.mm.as.f;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

final class k$b$1
  implements d.a
{
  k$b$1(k.b paramb, e parame, bi parambi, long paramLong) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    this.ntm.ntg.put(Long.valueOf(this.ntl), Boolean.valueOf(true));
    k.b.a(this.ntm, this.ntm.ntg, k.b.c(this.ntm), k.b.b(this.ntm));
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    boolean bool;
    if ((paramInt3 == 0) && (paramInt4 == 0))
    {
      bool = true;
      y.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      if (!(paramObject instanceof xv)) {
        break label292;
      }
      paramObject = (xv)paramObject;
      paramObject.XI(o.OJ().o(f.c(this.epf), "", ""));
      paramObject.XJ(o.OJ().F(this.dUy.field_imgPath, true));
      paramString = bn.s(this.epf.enA, "msg");
      if (paramString == null) {
        break label268;
      }
      paramObject.Xy((String)paramString.get(".msg.img.$cdnbigimgurl"));
      paramObject.hf(bk.getInt((String)paramString.get(".msg.img.$length"), 0));
      paramObject.Xz((String)paramString.get(".msg.img.$aeskey"));
      k.b.b(this.ntm).field_dataProto.sXc.set(k.b.a(this.ntm), paramObject);
      label210:
      this.ntm.ntg.put(Long.valueOf(paramObject.sVM), Boolean.valueOf(true));
    }
    for (;;)
    {
      k.b.a(this.ntm, this.ntm.ntg, k.b.c(this.ntm), k.b.b(this.ntm));
      return;
      bool = false;
      break;
      label268:
      y.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", new Object[] { this.epf.enA });
      break label210;
      label292:
      this.ntm.ntg.put(Long.valueOf(this.ntl), Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.k.b.1
 * JD-Core Version:    0.7.0.1
 */