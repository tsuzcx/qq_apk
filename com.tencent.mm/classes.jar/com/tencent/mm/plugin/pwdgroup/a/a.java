package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  public int fDe;
  private d rr;
  
  public a(int paramInt1, String paramString1, String paramString2, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27619);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new anf();
    ((d.a)localObject).lBV = new ang();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (anf)d.b.b(this.rr.lBR);
    this.fDe = paramInt1;
    ((anf)localObject).RLe = paramInt1;
    ((anf)localObject).Sxs = paramString1;
    ((anf)localObject).HlB = paramString2;
    ((anf)localObject).ScO = paramFloat2;
    ((anf)localObject).ScP = paramFloat1;
    ((anf)localObject).Sxt = paramInt2;
    if (!Util.isNullOrNil(paramString3)) {
      ((anf)localObject).Sxu = paramString3;
    }
    if (!Util.isNullOrNil(paramString4)) {
      ((anf)localObject).Sxv = paramString4;
    }
    ((anf)localObject).Sxw = paramInt3;
    Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[] { Integer.valueOf(paramInt1), paramString2, Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Integer.valueOf(paramInt2), paramString3, paramString4, Integer.valueOf(paramInt3) });
    n.a(2007, paramFloat2, paramFloat1, paramInt2);
    AppMethodBeat.o(27619);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(27620);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(27620);
    return i;
  }
  
  public final ang frR()
  {
    AppMethodBeat.i(275087);
    ang localang = (ang)d.c.b(this.rr.lBS);
    AppMethodBeat.o(275087);
    return localang;
  }
  
  public final int getType()
  {
    return 653;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27621);
    Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.fDe == 0)
    {
      params = frR();
      if (params != null)
      {
        params = params.RIk;
        if (params != null)
        {
          long l = System.currentTimeMillis();
          int i = params.size();
          paramArrayOfByte = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 < i)
          {
            anh localanh = (anh)params.get(paramInt1);
            j localj = new j();
            if (!Util.isNullOrNil(localanh.UserName)) {}
            for (localj.username = localanh.UserName;; localj.username = localanh.Sxx)
            {
              Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[] { localanh.UserName, localanh.Sus });
              localj.lBd = localanh.Sus;
              localj.gg(true);
              paramArrayOfByte.add(localj);
              paramInt1 += 1;
              break;
            }
          }
          com.tencent.mm.am.q.bhP().at(paramArrayOfByte);
          Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[] { System.currentTimeMillis() - l });
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