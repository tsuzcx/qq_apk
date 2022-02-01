package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.cc;

public final class y
  extends com.tencent.mm.al.l
{
  private final a FoB;
  private final y.b FoC;
  private final int funcId;
  private final String uri;
  
  public y(int paramInt1, String paramString, int paramInt2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134242);
    this.FoB = new a();
    this.FoC = new y.b();
    this.funcId = paramInt1;
    this.uri = paramString;
    this.FoB.funcId = paramInt1;
    this.FoB.FoE = paramArrayOfByte;
    this.FoB.FoD.FAh = paramInt2;
    this.FoB.FoD.FAi = paramSKBuiltinBuffer_t;
    AppMethodBeat.o(134242);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.FoB;
  }
  
  public final l.e getRespObj()
  {
    return this.FoC;
  }
  
  public final int getType()
  {
    return this.funcId;
  }
  
  public final String getUri()
  {
    return this.uri;
  }
  
  public static final class a
    extends l.d
    implements l.b
  {
    public hq FoD;
    byte[] FoE;
    int funcId;
    
    public a()
    {
      AppMethodBeat.i(134238);
      this.FoD = new hq();
      AppMethodBeat.o(134238);
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
      int j = -1;
      AppMethodBeat.i(134239);
      this.FoD.setBaseRequest(l.a(this));
      this.FoD.uEK = q.aar();
      this.FoD.FzG = b.wtJ.LY(0);
      this.FoD.jdf = bt.jj(aj.getContext());
      this.FoD.nDs = d.DEVICE_NAME;
      this.FoD.FzJ = cc.fsJ();
      this.FoD.qei = ac.fks();
      this.FoD.qeh = bt.flM();
      this.FoD.FqH = j.cSc;
      for (;;)
      {
        try
        {
          arrayOfByte = b.wtJ.duO();
          if (arrayOfByte == null) {
            continue;
          }
          i = arrayOfByte.length;
          ad.d("MicroMsg.MMReqRespAxAuth", "[debug] ccd set on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          eah localeah = new eah();
          localeah.HNl = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          localeah.HNp = new SKBuiltinBuffer_t().setBuffer(b.wtJ.duR());
          i = j;
          if (localeah.HNp != null) {
            i = localeah.HNp.getILen();
          }
          ad.d("MicroMsg.MMReqRespAxAuth", "[debug] devtok on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          this.FoD.FzL = new SKBuiltinBuffer_t().setBuffer(localeah.toByteArray());
        }
        catch (Throwable localThrowable)
        {
          byte[] arrayOfByte;
          int i;
          long l;
          ad.printErrStackTrace("MicroMsg.MMReqRespAxAuth", localThrowable, "cc throws exception.", new Object[0]);
          continue;
        }
        l = UtilsJni.CreateAxEcdhCryptoEngine(this.FoD.FAh, this.FoE, this.FoD.FAi.getBufferToBytes());
        setEcdhEngine(l);
        arrayOfByte = UtilsJni.AxEcdhEncrypt(l, this.FoD.toByteArray());
        AppMethodBeat.o(134239);
        return arrayOfByte;
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.y
 * JD-Core Version:    0.7.0.1
 */