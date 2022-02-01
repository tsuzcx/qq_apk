package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.sdk.platformtools.ad;

public final class v
  extends n
  implements k
{
  private f callback;
  byte[] dMj;
  int mCmdId;
  int pZT;
  private final b rr;
  
  public v(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114616);
    this.pZT = paramInt1;
    this.mCmdId = paramInt2;
    b.a locala = new b.a();
    locala.hNM = new cbr();
    locala.hNN = new cbs();
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
      ad.i("MicroMsg.MT.NetSceneMultiTalk", "netSceneMultiTalk cmdid %d cgiName %s", new Object[] { Integer.valueOf(paramInt2), str });
      locala.uri = str;
      locala.funcId = this.mCmdId;
      locala.hNO = 0;
      locala.respCmdId = 0;
      this.rr = locala.aDC();
      ((cbr)this.rr.hNK.hNQ).FAN = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
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
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(114617);
    this.callback = paramf;
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
    ad.d("MicroMsg.MT.NetSceneMultiTalk", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " " + this.mCmdId);
    this.dMj = z.a(((cbs)((b)paramq).hNL.hNQ).FAN);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(114618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.v
 * JD-Core Version:    0.7.0.1
 */