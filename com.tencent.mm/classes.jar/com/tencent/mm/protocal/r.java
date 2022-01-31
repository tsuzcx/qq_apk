package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.sdk.platformtools.bo;

public final class r
{
  public static final class a
    extends l.d
    implements l.b
  {
    public aim wiI;
    
    public a()
    {
      AppMethodBeat.i(58848);
      this.wiI = new aim();
      AppMethodBeat.o(58848);
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
      AppMethodBeat.i(58849);
      setRsaInfo(aa.dqG());
      this.wiI.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
      this.wiI.xah = aa.dqE().ver;
      this.wiI.setBaseRequest(l.a(this));
      byte[] arrayOfByte = this.wiI.toByteArray();
      AppMethodBeat.o(58849);
      return arrayOfByte;
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public ain wiJ;
    
    public b()
    {
      AppMethodBeat.i(58850);
      this.wiJ = new ain();
      AppMethodBeat.o(58850);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(58851);
      this.wiJ = ((ain)new ain().parseFrom(paramArrayOfByte));
      l.a(this, this.wiJ.getBaseResponse());
      int i = this.wiJ.getBaseResponse().Ret;
      AppMethodBeat.o(58851);
      return i;
    }
    
    public final int getCmdId()
    {
      return 1000000179;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.r
 * JD-Core Version:    0.7.0.1
 */