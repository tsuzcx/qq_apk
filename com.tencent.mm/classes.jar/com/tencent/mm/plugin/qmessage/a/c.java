package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.agq;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  public final b eDB;
  private f nct;
  
  public c()
  {
    b.a locala = new b.a();
    locala.ecH = new agp();
    locala.ecI = new agq();
    locala.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
    locala.ecG = 630;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eDB = locala.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    y.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
    this.nct = paramf;
    return a(parame, this.eDB, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.nct.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 630;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.c
 * JD-Core Version:    0.7.0.1
 */