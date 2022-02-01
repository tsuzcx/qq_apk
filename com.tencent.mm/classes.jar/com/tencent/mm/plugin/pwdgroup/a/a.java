package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajg;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private f callback;
  public int drZ;
  private b rr;
  
  public a(int paramInt1, String paramString1, String paramString2, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27619);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ajg();
    ((b.a)localObject).hNN = new ajh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ajg)this.rr.hNK.hNQ;
    this.drZ = paramInt1;
    ((ajg)localObject).OpCode = paramInt1;
    ((ajg)localObject).Ggv = paramString1;
    ((ajg)localObject).xbo = paramString2;
    ((ajg)localObject).FOA = paramFloat2;
    ((ajg)localObject).FOB = paramFloat1;
    ((ajg)localObject).Ggw = paramInt2;
    if (!bt.isNullOrNil(paramString3)) {
      ((ajg)localObject).Ggx = paramString3;
    }
    if (!bt.isNullOrNil(paramString4)) {
      ((ajg)localObject).Ggy = paramString4;
    }
    ((ajg)localObject).Ggz = paramInt3;
    ad.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[] { Integer.valueOf(paramInt1), paramString2, Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Integer.valueOf(paramInt2), paramString3, paramString4, Integer.valueOf(paramInt3) });
    o.a(2007, paramFloat2, paramFloat1, paramInt2);
    AppMethodBeat.o(27619);
  }
  
  public final ajh dBL()
  {
    return (ajh)this.rr.hNL.hNQ;
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
    ad.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.drZ == 0)
    {
      paramq = dBL();
      if (paramq != null)
      {
        paramq = paramq.FuN;
        if (paramq != null)
        {
          long l = System.currentTimeMillis();
          int i = paramq.size();
          paramArrayOfByte = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 < i)
          {
            aji localaji = (aji)paramq.get(paramInt1);
            i locali = new i();
            if (!bt.isNullOrNil(localaji.nDo)) {}
            for (locali.username = localaji.nDo;; locali.username = localaji.GgA)
            {
              ad.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[] { localaji.nDo, localaji.SmallImgUrl });
              locali.hMW = localaji.SmallImgUrl;
              locali.eB(true);
              paramArrayOfByte.add(locali);
              paramInt1 += 1;
              break;
            }
          }
          p.aEx().am(paramArrayOfByte);
          ad.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[] { System.currentTimeMillis() - l });
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