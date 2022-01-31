package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzc;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.protocal.c.ck;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends m
  implements k
{
  private f dmL;
  private List<String> jKA;
  
  public b(List<String> paramList)
  {
    this.jKA = paramList;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    cj localcj = new cj();
    ArrayList localArrayList = new ArrayList();
    if (this.jKA != null)
    {
      int i = 0;
      while (i < this.jKA.size())
      {
        bzc localbzc = new bzc();
        localbzc.hPY = ((String)this.jKA.get(i));
        localArrayList.add(localbzc);
        i += 1;
      }
    }
    localcj.svU.addAll(localArrayList);
    paramf.ecH = localcj;
    paramf.ecI = new ck();
    paramf.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
    paramf.ecG = 583;
    paramf.ecJ = 0;
    paramf.ecJ = 0;
    return a(parame, paramf.Kt(), this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.ede = paramInt1;
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      y.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 583;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.b
 * JD-Core Version:    0.7.0.1
 */