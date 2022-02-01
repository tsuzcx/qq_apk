package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.cro;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends q
  implements m
{
  private i callback;
  byte[] efs;
  int mCmdId;
  private final d rr;
  int rxu;
  
  public y(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114616);
    this.rxu = paramInt1;
    this.mCmdId = paramInt2;
    d.a locala = new d.a();
    locala.iLN = new crn();
    locala.iLO = new cro();
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
      Log.i("MicroMsg.MT.NetSceneMultiTalk", "netSceneMultiTalk cmdid %d cgiName %s", new Object[] { Integer.valueOf(paramInt2), str });
      locala.uri = str;
      locala.funcId = this.mCmdId;
      locala.iLP = 0;
      locala.respCmdId = 0;
      this.rr = locala.aXF();
      ((crn)this.rr.iLK.iLR).KMS = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
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
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(114617);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(114617);
    return i;
  }
  
  public final int getType()
  {
    return this.mCmdId;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114618);
    Log.d("MicroMsg.MT.NetSceneMultiTalk", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " " + this.mCmdId);
    this.efs = z.a(((cro)((d)params).iLL.iLR).KMS);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(114618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.y
 * JD-Core Version:    0.7.0.1
 */