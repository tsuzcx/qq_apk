package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bui;
import com.tencent.mm.protocal.c.bul;
import com.tencent.mm.protocal.c.bum;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends m
  implements k
{
  private int bMC;
  private b dmK;
  public f dmL;
  private long oqG;
  private int scene = 0;
  
  public w(int paramInt1, long paramLong, String paramString, int paramInt2, List<String> paramList, int paramInt3)
  {
    y.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + paramInt1 + " tagName " + paramString + " memberList " + paramList.size() + " scene " + paramInt3);
    this.bMC = paramInt1;
    this.oqG = paramLong;
    this.scene = paramInt3;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bul();
    ((b.a)localObject).ecI = new bum();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
    ((b.a)localObject).ecG = 291;
    ((b.a)localObject).ecJ = 115;
    ((b.a)localObject).ecK = 1000000115;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bul)this.dmK.ecE.ecN;
    ((bul)localObject).ssq = paramInt1;
    ((bul)localObject).tLb = paramLong;
    ((bul)localObject).kVl = paramString;
    ((bul)localObject).hPS = paramInt2;
    ((bul)localObject).pyo = this.scene;
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramString.add(new bml().YI(str));
    }
    ((bul)localObject).hPT = paramString;
    y.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + localObject.toString());
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = ((bum)((b)paramq).ecF.ecN).tLd;
    y.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + paramq.toString());
    paramArrayOfByte = af.bDL().gv(paramq.tLb);
    paramArrayOfByte.field_tagId = paramq.tLb;
    paramArrayOfByte.field_tagName = bk.aM(paramq.kVl, "");
    switch (this.bMC)
    {
    }
    for (;;)
    {
      af.bDL().a(paramArrayOfByte);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      paramArrayOfByte.field_count = paramq.hPS;
      paramArrayOfByte.cD(paramq.hPT);
    }
  }
  
  public final int getType()
  {
    return 291;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.w
 * JD-Core Version:    0.7.0.1
 */