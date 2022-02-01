package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.bw;

public final class y
  extends com.tencent.mm.ak.l
{
  private final a DJu;
  private final b DJv;
  private final int funcId;
  private final String uri;
  
  public y(int paramInt1, String paramString, int paramInt2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134242);
    this.DJu = new a();
    this.DJv = new b();
    this.funcId = paramInt1;
    this.uri = paramString;
    this.DJu.funcId = paramInt1;
    this.DJu.DJx = paramArrayOfByte;
    this.DJu.DJw.DUM = paramInt2;
    this.DJu.DJw.DUN = paramSKBuiltinBuffer_t;
    AppMethodBeat.o(134242);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.DJu;
  }
  
  public final l.e getRespObj()
  {
    return this.DJv;
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
    public hj DJw;
    byte[] DJx;
    int funcId;
    
    public a()
    {
      AppMethodBeat.i(134238);
      this.DJw = new hj();
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
      this.DJw.setBaseRequest(l.a(this));
      this.DJw.tCb = q.XQ();
      this.DJw.DUm = b.vor.Kw(0);
      this.DJw.iJW = bs.iZ(ai.getContext());
      this.DJw.ncV = d.DEVICE_NAME;
      this.DJw.DUp = bw.fcC();
      this.DJw.pAD = ab.eUO();
      this.DJw.pAC = bs.eWc();
      this.DJw.DLC = i.cGY;
      for (;;)
      {
        try
        {
          arrayOfByte = b.vor.dkC();
          if (arrayOfByte == null) {
            continue;
          }
          i = arrayOfByte.length;
          ac.d("MicroMsg.MMReqRespAxAuth", "[debug] ccd set on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          dun localdun = new dun();
          localdun.Gco = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          localdun.Gcs = new SKBuiltinBuffer_t().setBuffer(b.vor.dkF());
          i = j;
          if (localdun.Gcs != null) {
            i = localdun.Gcs.getILen();
          }
          ac.d("MicroMsg.MMReqRespAxAuth", "[debug] devtok on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          this.DJw.DUr = new SKBuiltinBuffer_t().setBuffer(localdun.toByteArray());
        }
        catch (Throwable localThrowable)
        {
          byte[] arrayOfByte;
          int i;
          long l;
          ac.printErrStackTrace("MicroMsg.MMReqRespAxAuth", localThrowable, "cc throws exception.", new Object[0]);
          continue;
        }
        l = UtilsJni.CreateAxEcdhCryptoEngine(this.DJw.DUM, this.DJx, this.DJw.DUN.getBufferToBytes());
        setEcdhEngine(l);
        arrayOfByte = UtilsJni.AxEcdhEncrypt(l, this.DJw.toByteArray());
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
    public hk DJy;
    
    public b()
    {
      AppMethodBeat.i(134240);
      this.DJy = new hk();
      AppMethodBeat.o(134240);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(134241);
      this.DJy = ((hk)new hk().parseFrom(paramArrayOfByte));
      l.a(this, this.DJy.getBaseResponse());
      int i = this.DJy.getBaseResponse().Ret;
      AppMethodBeat.o(134241);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.y
 * JD-Core Version:    0.7.0.1
 */