package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.sdk.platformtools.bs;

public final class t
{
  public static final class a
    extends l.d
    implements l.b
  {
    public aux DJm;
    
    public a()
    {
      AppMethodBeat.i(133107);
      this.DJm = new aux();
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
      setRsaInfo(ac.eRv());
      this.DJm.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
      this.DJm.EMZ = ac.eRt().ver;
      this.DJm.setBaseRequest(l.a(this));
      byte[] arrayOfByte = this.DJm.toByteArray();
      AppMethodBeat.o(133108);
      return arrayOfByte;
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public auy DJn;
    
    public b()
    {
      AppMethodBeat.i(133109);
      this.DJn = new auy();
      AppMethodBeat.o(133109);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133110);
      this.DJn = ((auy)new auy().parseFrom(paramArrayOfByte));
      l.a(this, this.DJn.getBaseResponse());
      int i = this.DJn.getBaseResponse().Ret;
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