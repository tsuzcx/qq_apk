package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  public int dKp;
  private d rr;
  
  public a(int paramInt1, String paramString1, String paramString2, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27619);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ame();
    ((d.a)localObject).iLO = new amf();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ame)this.rr.iLK.iLR;
    this.dKp = paramInt1;
    ((ame)localObject).OpCode = paramInt1;
    ((ame)localObject).LuS = paramString1;
    ((ame)localObject).Bri = paramString2;
    ((ame)localObject).LbC = paramFloat2;
    ((ame)localObject).LbD = paramFloat1;
    ((ame)localObject).LuT = paramInt2;
    if (!Util.isNullOrNil(paramString3)) {
      ((ame)localObject).LuU = paramString3;
    }
    if (!Util.isNullOrNil(paramString4)) {
      ((ame)localObject).LuV = paramString4;
    }
    ((ame)localObject).LuW = paramInt3;
    Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[] { Integer.valueOf(paramInt1), paramString2, Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Integer.valueOf(paramInt2), paramString3, paramString4, Integer.valueOf(paramInt3) });
    o.a(2007, paramFloat2, paramFloat1, paramInt2);
    AppMethodBeat.o(27619);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(27620);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(27620);
    return i;
  }
  
  public final amf eFS()
  {
    return (amf)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 653;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27621);
    Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dKp == 0)
    {
      params = eFS();
      if (params != null)
      {
        params = params.KGQ;
        if (params != null)
        {
          long l = System.currentTimeMillis();
          int i = params.size();
          paramArrayOfByte = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 < i)
          {
            amg localamg = (amg)params.get(paramInt1);
            com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
            if (!Util.isNullOrNil(localamg.UserName)) {}
            for (locali.username = localamg.UserName;; locali.username = localamg.LuX)
            {
              Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[] { localamg.UserName, localamg.SmallImgUrl });
              locali.iKW = localamg.SmallImgUrl;
              locali.fv(true);
              paramArrayOfByte.add(locali);
              paramInt1 += 1;
              break;
            }
          }
          p.aYB().av(paramArrayOfByte);
          Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[] { System.currentTimeMillis() - l });
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