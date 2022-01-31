package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.protocal.c.bjq;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends m
  implements k
{
  public com.tencent.mm.ah.b dmK;
  private f dmL;
  private byf pDB;
  
  public b(byf parambyf, List<String> paramList)
  {
    y.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStoryGetVideoUrl Video");
    this.pDB = parambyf;
    parambyf = new b.a();
    parambyf.ecG = 2579;
    parambyf.uri = "/cgi-bin/mmsearch-bin/recommendgetvideourl";
    parambyf.ecH = new bjp();
    parambyf.ecI = new bjq();
    this.dmK = parambyf.Kt();
    parambyf = (bjp)this.dmK.ecE.ecN;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      rn localrn = new rn();
      localrn.sPH = str;
      parambyf.tDs.add(localrn);
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 2579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.b
 * JD-Core Version:    0.7.0.1
 */