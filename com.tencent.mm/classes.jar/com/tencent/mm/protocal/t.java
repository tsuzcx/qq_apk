package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.sdk.platformtools.bu;

public final class t
{
  public static final class a
    extends l.d
    implements l.b
  {
    public azl FGR;
    
    public a()
    {
      AppMethodBeat.i(133107);
      this.FGR = new azl();
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
      setRsaInfo(ac.fkp());
      this.FGR.FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
      this.FGR.GPC = ac.fkn().ver;
      this.FGR.setBaseRequest(l.a(this));
      byte[] arrayOfByte = this.FGR.toByteArray();
      AppMethodBeat.o(133108);
      return arrayOfByte;
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public azm FGS;
    
    public b()
    {
      AppMethodBeat.i(133109);
      this.FGS = new azm();
      AppMethodBeat.o(133109);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133110);
      this.FGS = ((azm)new azm().parseFrom(paramArrayOfByte));
      l.a(this, this.FGS.getBaseResponse());
      int i = this.FGS.getBaseResponse().Ret;
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