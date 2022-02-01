package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.cd;

public final class y
  extends com.tencent.mm.ak.l
{
  private final a FGZ;
  private final b FHa;
  private final int funcId;
  private final String uri;
  
  public y(int paramInt1, String paramString, int paramInt2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134242);
    this.FGZ = new a();
    this.FHa = new b();
    this.funcId = paramInt1;
    this.uri = paramString;
    this.FGZ.funcId = paramInt1;
    this.FGZ.FHc = paramArrayOfByte;
    this.FGZ.FHb.uuz = paramInt2;
    this.FGZ.FHb.FSF = paramSKBuiltinBuffer_t;
    AppMethodBeat.o(134242);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.FGZ;
  }
  
  public final l.e getRespObj()
  {
    return this.FHa;
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
    public hq FHb;
    byte[] FHc;
    int funcId;
    
    public a()
    {
      AppMethodBeat.i(134238);
      this.FHb = new hq();
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
      this.FHb.setBaseRequest(l.a(this));
      this.FHb.uQx = q.aaA();
      this.FHb.FSe = b.wJt.MD(0);
      this.FHb.jfY = bu.jp(ak.getContext());
      this.FHb.nIN = d.DEVICE_NAME;
      this.FHb.FSh = cd.fwK();
      this.FHb.qkN = ad.fom();
      this.FHb.qkM = bu.fpH();
      this.FHb.FJf = k.cSM;
      for (;;)
      {
        try
        {
          arrayOfByte = b.wJt.dye();
          if (arrayOfByte == null) {
            continue;
          }
          i = arrayOfByte.length;
          ae.d("MicroMsg.MMReqRespAxAuth", "[debug] ccd set on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          eby localeby = new eby();
          localeby.Ihs = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          localeby.Ihw = new SKBuiltinBuffer_t().setBuffer(b.wJt.dyh());
          i = j;
          if (localeby.Ihw != null) {
            i = localeby.Ihw.getILen();
          }
          ae.d("MicroMsg.MMReqRespAxAuth", "[debug] devtok on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          this.FHb.FSj = new SKBuiltinBuffer_t().setBuffer(localeby.toByteArray());
        }
        catch (Throwable localThrowable)
        {
          byte[] arrayOfByte;
          int i;
          long l;
          ae.printErrStackTrace("MicroMsg.MMReqRespAxAuth", localThrowable, "cc throws exception.", new Object[0]);
          continue;
        }
        l = UtilsJni.CreateAxEcdhCryptoEngine(this.FHb.uuz, this.FHc, this.FHb.FSF.getBufferToBytes());
        setEcdhEngine(l);
        arrayOfByte = UtilsJni.AxEcdhEncrypt(l, this.FHb.toByteArray());
        AppMethodBeat.o(134239);
        return arrayOfByte;
        i = -1;
      }
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public hr FHd;
    
    public b()
    {
      AppMethodBeat.i(134240);
      this.FHd = new hr();
      AppMethodBeat.o(134240);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(134241);
      this.FHd = ((hr)new hr().parseFrom(paramArrayOfByte));
      l.a(this, this.FHd.getBaseResponse());
      int i = this.FHd.getBaseResponse().Ret;
      AppMethodBeat.o(134241);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.y
 * JD-Core Version:    0.7.0.1
 */