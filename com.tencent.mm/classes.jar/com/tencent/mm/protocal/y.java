package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.protocal.protobuf.id;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ck;

public final class y
  extends o
{
  private final a KAk;
  private final b KAl;
  private final int funcId;
  private final String uri;
  
  public y(int paramInt1, String paramString, int paramInt2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134242);
    this.KAk = new a();
    this.KAl = new b();
    this.funcId = paramInt1;
    this.uri = paramString;
    this.KAk.funcId = paramInt1;
    this.KAk.KAn = paramArrayOfByte;
    this.KAk.KAm.xMB = paramInt2;
    this.KAk.KAm.KMo = paramSKBuiltinBuffer_t;
    AppMethodBeat.o(134242);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.KAk;
  }
  
  public final l.e getRespObj()
  {
    return this.KAl;
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
    public id KAm;
    byte[] KAn;
    int funcId;
    
    public a()
    {
      AppMethodBeat.i(134238);
      this.KAm = new id();
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
      this.KAm.setBaseRequest(l.a(this));
      this.KAm.yiZ = q.aoz();
      this.KAm.KLL = com.tencent.mm.plugin.normsg.a.d.AEF.TK(0);
      this.KAm.keb = Util.getSourceeMd5(MMApplicationContext.getContext());
      this.KAm.oTI = d.DEVICE_NAME;
      this.KAm.KLO = ck.getFingerprint();
      this.KAm.rBI = LocaleUtil.getApplicationLanguage();
      this.KAm.rBH = Util.getTimeZoneOffset();
      this.KAm.KCx = ChannelUtil.channelId;
      for (;;)
      {
        try
        {
          arrayOfByte = com.tencent.mm.plugin.normsg.a.d.AEF.exJ();
          if (arrayOfByte == null) {
            continue;
          }
          i = arrayOfByte.length;
          Log.d("MicroMsg.MMReqRespAxAuth", "[debug] ccd set on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          ewf localewf = new ewf();
          localewf.NtQ = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          localewf.NtU = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exM());
          i = j;
          if (localewf.NtU != null) {
            i = localewf.NtU.getILen();
          }
          Log.d("MicroMsg.MMReqRespAxAuth", "[debug] devtok on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          this.KAm.KLQ = new SKBuiltinBuffer_t().setBuffer(localewf.toByteArray());
        }
        catch (Throwable localThrowable)
        {
          byte[] arrayOfByte;
          int i;
          long l;
          Log.printErrStackTrace("MicroMsg.MMReqRespAxAuth", localThrowable, "cc throws exception.", new Object[0]);
          continue;
        }
        l = UtilsJni.CreateAxEcdhCryptoEngine(this.KAm.xMB, this.KAn, this.KAm.KMo.getBufferToBytes());
        setEcdhEngine(l);
        arrayOfByte = UtilsJni.AxEcdhEncrypt(l, this.KAm.toByteArray());
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
    public ie KAo;
    
    public b()
    {
      AppMethodBeat.i(134240);
      this.KAo = new ie();
      AppMethodBeat.o(134240);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(134241);
      this.KAo = ((ie)new ie().parseFrom(paramArrayOfByte));
      l.a(this, this.KAo.getBaseResponse());
      int i = this.KAo.getBaseResponse().Ret;
      AppMethodBeat.o(134241);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.y
 * JD-Core Version:    0.7.0.1
 */