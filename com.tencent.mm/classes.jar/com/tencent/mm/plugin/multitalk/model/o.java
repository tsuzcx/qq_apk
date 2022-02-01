package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.sdk.platformtools.ac;

public final class o
  extends n
  implements k
{
  private g callback;
  byte[] dzW;
  int mCmdId;
  int pwo;
  private final b rr;
  
  public o(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114616);
    this.pwo = paramInt1;
    this.mCmdId = paramInt2;
    b.a locala = new b.a();
    locala.hvt = new bxb();
    locala.hvu = new bxc();
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
      ac.i("MicroMsg.MT.NetSceneMultiTalk", "netSceneMultiTalk cmdid %d cgiName %s", new Object[] { Integer.valueOf(paramInt2), str });
      locala.uri = str;
      locala.funcId = this.mCmdId;
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      this.rr = locala.aAz();
      ((bxb)this.rr.hvr.hvw).DVs = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
      AppMethodBeat.o(114616);
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
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(114617);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(114617);
    return i;
  }
  
  public final int getType()
  {
    return this.mCmdId;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114618);
    ac.d("MicroMsg.MT.NetSceneMultiTalk", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " " + this.mCmdId);
    this.dzW = z.a(((bxc)((b)paramq).hvs.hvw).DVs);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(114618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.o
 * JD-Core Version:    0.7.0.1
 */