package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.sdk.platformtools.ab;

public final class o
  extends m
  implements k
{
  byte[] cLl;
  private f callback;
  int lCr;
  int mCmdId;
  private final b rr;
  
  public o(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(54085);
    this.lCr = paramInt1;
    this.mCmdId = paramInt2;
    b.a locala = new b.a();
    locala.fsX = new bfn();
    locala.fsY = new bfo();
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
      ab.i("MicroMsg.MT.NetSceneMultiTalk", "netSceneMultiTalk cmdid %d cgiName %s", new Object[] { Integer.valueOf(paramInt2), str });
      locala.uri = str;
      locala.funcId = this.mCmdId;
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      this.rr = locala.ado();
      ((bfn)this.rr.fsV.fta).wtq = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
      AppMethodBeat.o(54085);
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
    AppMethodBeat.i(54086);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(54086);
    return i;
  }
  
  public final int getType()
  {
    return this.mCmdId;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(54087);
    ab.d("MicroMsg.MT.NetSceneMultiTalk", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " " + this.mCmdId);
    this.cLl = aa.a(((bfo)((b)paramq).fsW.fta).wtq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(54087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.o
 * JD-Core Version:    0.7.0.1
 */