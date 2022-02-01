package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private g callback;
  public int dgD;
  private b rr;
  
  public a(int paramInt1, String paramString1, String paramString2, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27619);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new agq();
    ((b.a)localObject).hvu = new agr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (agq)this.rr.hvr.hvw;
    this.dgD = paramInt1;
    ((agq)localObject).OpCode = paramInt1;
    ((agq)localObject).EyJ = paramString1;
    ((agq)localObject).Ewu = paramString2;
    ((agq)localObject).Eht = paramFloat2;
    ((agq)localObject).Ehu = paramFloat1;
    ((agq)localObject).EyK = paramInt2;
    if (!bs.isNullOrNil(paramString3)) {
      ((agq)localObject).EyL = paramString3;
    }
    if (!bs.isNullOrNil(paramString4)) {
      ((agq)localObject).EyM = paramString4;
    }
    ((agq)localObject).EyN = paramInt3;
    ac.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[] { Integer.valueOf(paramInt1), paramString2, Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Integer.valueOf(paramInt2), paramString3, paramString4, Integer.valueOf(paramInt3) });
    o.a(2007, paramFloat2, paramFloat1, paramInt2);
    AppMethodBeat.o(27619);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(27620);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(27620);
    return i;
  }
  
  public final agr drj()
  {
    return (agr)this.rr.hvs.hvw;
  }
  
  public final int getType()
  {
    return 653;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27621);
    ac.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dgD == 0)
    {
      paramq = drj();
      if (paramq != null)
      {
        paramq = paramq.DPz;
        if (paramq != null)
        {
          long l = System.currentTimeMillis();
          int i = paramq.size();
          paramArrayOfByte = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 < i)
          {
            ags localags = (ags)paramq.get(paramInt1);
            i locali = new i();
            if (!bs.isNullOrNil(localags.ncR)) {}
            for (locali.username = localags.ncR;; locali.username = localags.EyO)
            {
              ac.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[] { localags.ncR, localags.SmallImgUrl });
              locali.huE = localags.SmallImgUrl;
              locali.ez(true);
              paramArrayOfByte.add(locali);
              paramInt1 += 1;
              break;
            }
          }
          p.aBw().al(paramArrayOfByte);
          ac.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[] { System.currentTimeMillis() - l });
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.a.a
 * JD-Core Version:    0.7.0.1
 */