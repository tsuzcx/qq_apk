package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.sdk.platformtools.bt;

public final class t
{
  public static final class a
    extends l.d
    implements l.b
  {
    public ayv Fot;
    
    public a()
    {
      AppMethodBeat.i(133107);
      this.Fot = new ayv();
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
      setRsaInfo(ac.fgz());
      this.Fot.FDQ = new SKBuiltinBuffer_t().setBuffer(bt.flL());
      this.Fot.Gwd = ac.fgx().ver;
      this.Fot.setBaseRequest(l.a(this));
      byte[] arrayOfByte = this.Fot.toByteArray();
      AppMethodBeat.o(133108);
      return arrayOfByte;
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public ayw Fou;
    
    public b()
    {
      AppMethodBeat.i(133109);
      this.Fou = new ayw();
      AppMethodBeat.o(133109);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133110);
      this.Fou = ((ayw)new ayw().parseFrom(paramArrayOfByte));
      l.a(this, this.Fou.getBaseResponse());
      int i = this.Fou.getBaseResponse().Ret;
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