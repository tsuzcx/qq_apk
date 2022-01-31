package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.ayp;
import com.tencent.mm.protocal.c.ayq;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends m
  implements k
{
  byte[] ccD;
  private final b dmK;
  private f dmL;
  int jsR;
  int jsS;
  
  public o(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.jsR = paramInt1;
    this.jsS = paramInt2;
    b.a locala = new b.a();
    locala.ecH = new ayp();
    locala.ecI = new ayq();
    String str;
    switch (paramInt2)
    {
    case 1920: 
    case 1921: 
    case 1922: 
    case 1923: 
    case 1924: 
    case 1925: 
    case 1926: 
    case 1930: 
    case 1934: 
    case 1936: 
    default: 
      str = "";
    }
    for (;;)
    {
      y.i("MicroMsg.MT.NetSceneMultiTalk", "netSceneMultiTalk cmdid %d cgiName %s", new Object[] { Integer.valueOf(paramInt2), str });
      locala.uri = str;
      locala.ecG = this.jsS;
      locala.ecJ = 0;
      locala.ecK = 0;
      this.dmK = locala.Kt();
      ((ayp)this.dmK.ecE.ecN).szp = new bmk().bs(paramArrayOfByte);
      return;
      str = "/cgi-bin/qcwxmultitalk-bin/createtalkroom";
      continue;
      str = "/cgi-bin/qcwxmultitalk-bin/entertalkroom";
      continue;
      str = "/cgi-bin/qcwxmultitalk-bin/exittalkroom";
      continue;
      str = "/cgi-bin/qcwxmultitalk-bin/cancelcreatetalkroom";
      continue;
      str = "/cgi-bin/qcwxmultitalk-bin/rejectentertalkroom";
      continue;
      str = "/cgi-bin/qcwxmultitalk-bin/addmembers";
      continue;
      str = "/cgi-bin/qcwxmultitalk-bin/hellotalkroom";
      continue;
      str = "/cgi-bin/qcwxmultitalk-bin/miscinfo";
      continue;
      str = "/cgi-bin/qcwxmultitalk-bin/voiceackreq";
      continue;
      str = "/cgi-bin/qcwxmultitalk-bin/oiceredirectreq";
      continue;
      str = "/cgi-bin/qcwxmultitalk-bin/getgroupinfobatch";
      continue;
      str = "/cgi-bin/qcwxmultitalk-bin/memberwhisper";
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.MT.NetSceneMultiTalk", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " " + this.jsS);
    this.ccD = aa.a(((ayq)((b)paramq).ecF.ecN).szp);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return this.jsS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.o
 * JD-Core Version:    0.7.0.1
 */