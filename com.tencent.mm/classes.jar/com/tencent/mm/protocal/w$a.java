package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.gi;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.storage.bs;

public final class w$a
  extends l.d
  implements l.b
{
  int funcId;
  public gi wiS;
  byte[] wiT;
  
  public w$a()
  {
    AppMethodBeat.i(154522);
    this.wiS = new gi();
    AppMethodBeat.o(154522);
  }
  
  public final int getFuncId()
  {
    return this.funcId;
  }
  
  public final boolean isAxAuth()
  {
    return true;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(154523);
    this.wiS.setBaseRequest(l.a(this));
    this.wiS.nGG = q.LD();
    this.wiS.wsn = b.pgQ.AP(0);
    this.wiS.gwS = bo.hk(ah.getContext());
    this.wiS.jJE = d.DEVICE_NAME;
    this.wiS.wsq = bs.dyO();
    this.wiS.lGH = aa.dsG();
    this.wiS.lGG = bo.dtS();
    this.wiS.wkX = g.bWu;
    long l = UtilsJni.CreateAxEcdhCryptoEngine(this.wiS.wsK, this.wiT, this.wiS.wsL.getBufferToBytes());
    setEcdhEngine(l);
    byte[] arrayOfByte = UtilsJni.AxEcdhEncrypt(l, this.wiS.toByteArray());
    AppMethodBeat.o(154523);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.w.a
 * JD-Core Version:    0.7.0.1
 */