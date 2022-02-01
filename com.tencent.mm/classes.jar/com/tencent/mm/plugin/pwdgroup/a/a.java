package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private f callback;
  public int dtf;
  private b rr;
  
  public a(int paramInt1, String paramString1, String paramString2, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27619);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ajq();
    ((b.a)localObject).hQG = new ajr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ajq)this.rr.hQD.hQJ;
    this.dtf = paramInt1;
    ((ajq)localObject).OpCode = paramInt1;
    ((ajq)localObject).Gze = paramString1;
    ((ajq)localObject).xrf = paramString2;
    ((ajq)localObject).GgZ = paramFloat2;
    ((ajq)localObject).Gha = paramFloat1;
    ((ajq)localObject).Gzf = paramInt2;
    if (!bu.isNullOrNil(paramString3)) {
      ((ajq)localObject).Gzg = paramString3;
    }
    if (!bu.isNullOrNil(paramString4)) {
      ((ajq)localObject).Gzh = paramString4;
    }
    ((ajq)localObject).Gzi = paramInt3;
    ae.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[] { Integer.valueOf(paramInt1), paramString2, Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Integer.valueOf(paramInt2), paramString3, paramString4, Integer.valueOf(paramInt3) });
    o.a(2007, paramFloat2, paramFloat1, paramInt2);
    AppMethodBeat.o(27619);
  }
  
  public final ajr dFc()
  {
    return (ajr)this.rr.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(27620);
    this.callback = paramf;
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
    ae.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dtf == 0)
    {
      paramq = dFc();
      if (paramq != null)
      {
        paramq = paramq.FNl;
        if (paramq != null)
        {
          long l = System.currentTimeMillis();
          int i = paramq.size();
          paramArrayOfByte = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 < i)
          {
            ajs localajs = (ajs)paramq.get(paramInt1);
            i locali = new i();
            if (!bu.isNullOrNil(localajs.nIJ)) {}
            for (locali.username = localajs.nIJ;; locali.username = localajs.Gzj)
            {
              ae.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[] { localajs.nIJ, localajs.SmallImgUrl });
              locali.hPP = localajs.SmallImgUrl;
              locali.eD(true);
              paramArrayOfByte.add(locali);
              paramInt1 += 1;
              break;
            }
          }
          p.aEN().am(paramArrayOfByte);
          ae.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[] { System.currentTimeMillis() - l });
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.a.a
 * JD-Core Version:    0.7.0.1
 */