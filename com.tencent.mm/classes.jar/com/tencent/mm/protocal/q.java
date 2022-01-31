package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.zs;
import com.tencent.mm.protocal.protobuf.zt;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.sdk.platformtools.bo;

public final class q
{
  public static final class a
    extends l.d
    implements l.b
  {
    public final zt wiE;
    
    public a()
    {
      AppMethodBeat.i(79996);
      this.wiE = new zt();
      setUin(0);
      this.wiE.wQN = new zs();
      this.wiE.wQN.wQL = new sq();
      this.wiE.wQM = new zu();
      AppMethodBeat.o(79996);
    }
    
    public final int getFuncId()
    {
      if (f.whQ) {
        return 784;
      }
      return 722;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(79997);
      setRsaInfo(aa.dqE());
      this.wiE.wQN.setBaseRequest(l.a(this));
      this.wiE.wQM.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
      setPassKey(this.wiE.wQM.wvN.getBuffer().toByteArray());
      setReqPackControl(new q.a.1(this, this));
      byte[] arrayOfByte = this.wiE.toByteArray();
      AppMethodBeat.o(79997);
      return arrayOfByte;
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public final sr wiH;
    
    public b()
    {
      AppMethodBeat.i(79998);
      this.wiH = new sr();
      AppMethodBeat.o(79998);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(79999);
      this.wiH.parseFrom(paramArrayOfByte);
      int i = this.wiH.BaseResponse.Ret;
      AppMethodBeat.o(79999);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.q
 * JD-Core Version:    0.7.0.1
 */