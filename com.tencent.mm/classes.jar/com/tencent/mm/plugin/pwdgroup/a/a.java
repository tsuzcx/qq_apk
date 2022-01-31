package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends m
  implements k
{
  private f callback;
  public int cuo;
  private b rr;
  
  public a(int paramInt1, String paramString1, String paramString2, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23980);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new abu();
    ((b.a)localObject).fsY = new abv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (abu)this.rr.fsV.fta;
    this.cuo = paramInt1;
    ((abu)localObject).OpCode = paramInt1;
    ((abu)localObject).wSj = paramString1;
    ((abu)localObject).wQf = paramString2;
    ((abu)localObject).wDh = paramFloat2;
    ((abu)localObject).wDi = paramFloat1;
    ((abu)localObject).wSk = paramInt2;
    if (!bo.isNullOrNil(paramString3)) {
      ((abu)localObject).wSl = paramString3;
    }
    if (!bo.isNullOrNil(paramString4)) {
      ((abu)localObject).wSm = paramString4;
    }
    ((abu)localObject).wSn = paramInt3;
    ab.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[] { Integer.valueOf(paramInt1), paramString2, Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Integer.valueOf(paramInt2), paramString3, paramString4, Integer.valueOf(paramInt3) });
    com.tencent.mm.modelstat.o.a(2007, paramFloat2, paramFloat1, paramInt2);
    AppMethodBeat.o(23980);
  }
  
  public final abv cdj()
  {
    return (abv)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23981);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23981);
    return i;
  }
  
  public final int getType()
  {
    return 653;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23982);
    ab.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.cuo == 0)
    {
      paramq = cdj();
      if (paramq != null)
      {
        paramq = paramq.wov;
        if (paramq != null)
        {
          long l = System.currentTimeMillis();
          int i = paramq.size();
          paramArrayOfByte = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 < i)
          {
            abw localabw = (abw)paramq.get(paramInt1);
            h localh = new h();
            if (!bo.isNullOrNil(localabw.jJA)) {}
            for (localh.username = localabw.jJA;; localh.username = localabw.wSo)
            {
              ab.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[] { localabw.jJA, localabw.SmallImgUrl });
              localh.fsk = localabw.SmallImgUrl;
              localh.cM(true);
              paramArrayOfByte.add(localh);
              paramInt1 += 1;
              break;
            }
          }
          com.tencent.mm.ah.o.adg().X(paramArrayOfByte);
          ab.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[] { System.currentTimeMillis() - l });
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.a.a
 * JD-Core Version:    0.7.0.1
 */