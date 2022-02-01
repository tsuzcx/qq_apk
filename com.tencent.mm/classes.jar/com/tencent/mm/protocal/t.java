package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bkv;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.sdk.platformtools.Util;

public final class t
{
  public static final class a
    extends l.d
    implements l.b
  {
    public bkv KAc;
    
    public a()
    {
      AppMethodBeat.i(133107);
      this.KAc = new bkv();
      AppMethodBeat.o(133107);
    }
    
    public final int getCmdId()
    {
      return 179;
    }
    
    public final int getFuncId()
    {
      return 381;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(133108);
      setRsaInfo(ac.gtT());
      this.KAc.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
      this.KAc.LTJ = ac.gtR().ver;
      this.KAc.setBaseRequest(l.a(this));
      byte[] arrayOfByte = this.KAc.toByteArray();
      AppMethodBeat.o(133108);
      return arrayOfByte;
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public bkw KAd;
    
    public b()
    {
      AppMethodBeat.i(133109);
      this.KAd = new bkw();
      AppMethodBeat.o(133109);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133110);
      this.KAd = ((bkw)new bkw().parseFrom(paramArrayOfByte));
      l.a(this, this.KAd.getBaseResponse());
      int i = this.KAd.getBaseResponse().Ret;
      AppMethodBeat.o(133110);
      return i;
    }
    
    public final int getCmdId()
    {
      return 1000000179;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.t
 * JD-Core Version:    0.7.0.1
 */