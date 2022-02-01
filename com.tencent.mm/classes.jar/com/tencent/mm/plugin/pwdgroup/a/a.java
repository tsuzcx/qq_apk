package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.aqz;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends p
  implements m
{
  private h callback;
  public int hHT;
  private c rr;
  
  public a(int paramInt1, String paramString1, String paramString2, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(27619);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aqy();
    ((c.a)localObject).otF = new aqz();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (aqy)c.b.b(this.rr.otB);
    this.hHT = paramInt1;
    ((aqy)localObject).YIq = paramInt1;
    ((aqy)localObject).Zyk = paramString1;
    ((aqy)localObject).Njp = paramString2;
    ((aqy)localObject).ZaG = paramFloat2;
    ((aqy)localObject).ZaH = paramFloat1;
    ((aqy)localObject).Zyl = paramInt2;
    if (!Util.isNullOrNil(paramString3)) {
      ((aqy)localObject).Zym = paramString3;
    }
    if (!Util.isNullOrNil(paramString4)) {
      ((aqy)localObject).Zyn = paramString4;
    }
    ((aqy)localObject).Zyo = paramInt3;
    Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[] { Integer.valueOf(paramInt1), paramString2, Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Integer.valueOf(paramInt2), paramString3, paramString4, Integer.valueOf(paramInt3) });
    n.a(2007, paramFloat2, paramFloat1, paramInt2);
    AppMethodBeat.o(27619);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(27620);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(27620);
    return i;
  }
  
  public final aqz gDz()
  {
    AppMethodBeat.i(284566);
    aqz localaqz = (aqz)c.c.b(this.rr.otC);
    AppMethodBeat.o(284566);
    return localaqz;
  }
  
  public final int getType()
  {
    return 653;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27621);
    Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.hHT == 0)
    {
      params = gDz();
      if (params != null)
      {
        params = params.YFm;
        if (params != null)
        {
          long l = System.currentTimeMillis();
          int i = params.size();
          paramArrayOfByte = new ArrayList();
          paramInt1 = 0;
          if (paramInt1 < i)
          {
            ara localara = (ara)params.get(paramInt1);
            j localj = new j();
            if (!Util.isNullOrNil(localara.UserName)) {}
            for (localj.username = localara.UserName;; localj.username = localara.Zyp)
            {
              Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[] { localara.UserName, localara.Zui });
              localj.osM = localara.Zui;
              localj.gX(true);
              paramArrayOfByte.add(localj);
              paramInt1 += 1;
              break;
            }
          }
          q.bFE().bY(paramArrayOfByte);
          Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[] { System.currentTimeMillis() - l });
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