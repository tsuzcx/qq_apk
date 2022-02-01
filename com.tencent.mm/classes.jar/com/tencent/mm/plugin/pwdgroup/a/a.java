package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.protocal.protobuf.afs;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private g callback;
  public int dji;
  private b rr;
  
  public a(int paramInt1, String paramString1, String paramString2, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27619);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new afr();
    ((b.a)localObject).gUV = new afs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (afr)this.rr.gUS.gUX;
    this.dji = paramInt1;
    ((afr)localObject).OpCode = paramInt1;
    ((afr)localObject).DfD = paramString1;
    ((afr)localObject).Ddo = paramString2;
    ((afr)localObject).COI = paramFloat2;
    ((afr)localObject).COJ = paramFloat1;
    ((afr)localObject).DfE = paramInt2;
    if (!bt.isNullOrNil(paramString3)) {
      ((afr)localObject).DfF = paramString3;
    }
    if (!bt.isNullOrNil(paramString4)) {
      ((afr)localObject).DfG = paramString4;
    }
    ((afr)localObject).DfH = paramInt3;
    ad.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[] { Integer.valueOf(paramInt1), paramString2, Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Integer.valueOf(paramInt2), paramString3, paramString4, Integer.valueOf(paramInt3) });
    o.a(2007, paramFloat2, paramFloat1, paramInt2);
    AppMethodBeat.o(27619);
  }
  
  public final afs ddB()
  {
    return (afs)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(27620);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(27620);
    return i;
  }
  
  public final int getType()
  {
    return 653;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27621);
    ad.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dji == 0)
    {
      paramq = ddB();
      if (paramq != null)
      {
        paramq = paramq.Cxd;
        if (paramq != null)
        {
          long l = System.currentTimeMillis();
          int i = paramq.size();
          paramArrayOfByte = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 < i)
          {
            aft localaft = (aft)paramq.get(paramInt1);
            i locali = new i();
            if (!bt.isNullOrNil(localaft.mAQ)) {}
            for (locali.username = localaft.mAQ;; locali.username = localaft.DfI)
            {
              ad.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[] { localaft.mAQ, localaft.SmallImgUrl });
              locali.gUf = localaft.SmallImgUrl;
              locali.ee(true);
              paramArrayOfByte.add(locali);
              paramInt1 += 1;
              break;
            }
          }
          p.auF().ao(paramArrayOfByte);
          ad.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[] { System.currentTimeMillis() - l });
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.a.a
 * JD-Core Version:    0.7.0.1
 */