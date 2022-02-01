package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.protocal.protobuf.hf;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;

public final class y
  extends com.tencent.mm.al.l
{
  private final a Crc;
  private final b Crd;
  private final int funcId;
  private final String uri;
  
  public y(int paramInt1, String paramString, int paramInt2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134242);
    this.Crc = new a();
    this.Crd = new b();
    this.funcId = paramInt1;
    this.uri = paramString;
    this.Crc.funcId = paramInt1;
    this.Crc.Crf = paramArrayOfByte;
    this.Crc.Cre.CCp = paramInt2;
    this.Crc.Cre.CCq = paramSKBuiltinBuffer_t;
    AppMethodBeat.o(134242);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.Crc;
  }
  
  public final l.e getRespObj()
  {
    return this.Crd;
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
    public hf Cre;
    byte[] Crf;
    int funcId;
    
    public a()
    {
      AppMethodBeat.i(134238);
      this.Cre = new hf();
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
      this.Cre.setBaseRequest(l.a(this));
      this.Cre.sul = q.WT();
      this.Cre.CBO = b.ufs.Ix(0);
      this.Cre.ijP = com.tencent.mm.sdk.platformtools.bt.iO(aj.getContext());
      this.Cre.mAU = d.DEVICE_NAME;
      this.Cre.CBS = com.tencent.mm.storage.bt.eMY();
      this.Cre.oXs = ac.eFu();
      this.Cre.oXr = com.tencent.mm.sdk.platformtools.bt.eGH();
      this.Cre.Ctl = i.cJR;
      for (;;)
      {
        try
        {
          arrayOfByte = b.ufs.cWU();
          if (arrayOfByte == null) {
            continue;
          }
          i = arrayOfByte.length;
          ad.d("MicroMsg.MMReqRespAxAuth", "[debug] ccd set on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          dow localdow = new dow();
          localdow.EFc = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          localdow.EFg = new SKBuiltinBuffer_t().setBuffer(b.ufs.cWX());
          i = j;
          if (localdow.EFg != null) {
            i = localdow.EFg.getILen();
          }
          ad.d("MicroMsg.MMReqRespAxAuth", "[debug] devtok on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          this.Cre.CBU = new SKBuiltinBuffer_t().setBuffer(localdow.toByteArray());
        }
        catch (Throwable localThrowable)
        {
          byte[] arrayOfByte;
          int i;
          long l;
          ad.printErrStackTrace("MicroMsg.MMReqRespAxAuth", localThrowable, "cc throws exception.", new Object[0]);
          continue;
        }
        l = UtilsJni.CreateAxEcdhCryptoEngine(this.Cre.CCp, this.Crf, this.Cre.CCq.getBufferToBytes());
        setEcdhEngine(l);
        arrayOfByte = UtilsJni.AxEcdhEncrypt(l, this.Cre.toByteArray());
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
    public hg Crg;
    
    public b()
    {
      AppMethodBeat.i(134240);
      this.Crg = new hg();
      AppMethodBeat.o(134240);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(134241);
      this.Crg = ((hg)new hg().parseFrom(paramArrayOfByte));
      l.a(this, this.Crg.getBaseResponse());
      int i = this.Crg.getBaseResponse().Ret;
      AppMethodBeat.o(134241);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.y
 * JD-Core Version:    0.7.0.1
 */