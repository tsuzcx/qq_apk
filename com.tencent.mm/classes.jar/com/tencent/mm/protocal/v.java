package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;

public final class v
{
  public static final class a
    extends l.d
    implements l.b
  {
    public bgf wiO;
    public byte[] wik;
    
    public a()
    {
      AppMethodBeat.i(58861);
      this.wiO = new bgf();
      AppMethodBeat.o(58861);
    }
    
    public final int getCmdId()
    {
      return 0;
    }
    
    public final int getFuncId()
    {
      return 126;
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(58862);
      setRsaInfo(aa.dqE());
      this.wiO.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
      this.wiO.setBaseRequest(l.a(this));
      this.wiO.xve = g.ymI;
      zd localzd = new zd();
      localzd.wQb = 713;
      Object localObject2 = new PByteArray();
      Object localObject1 = new PByteArray();
      int k = MMProtocalJni.generateECKey(localzd.wQb, (PByteArray)localObject2, (PByteArray)localObject1);
      byte[] arrayOfByte = ((PByteArray)localObject2).value;
      localObject2 = ((PByteArray)localObject1).value;
      int m;
      int i;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        this.wik = ((byte[])localObject1);
        m = localzd.wQb;
        if (arrayOfByte != null) {
          break label260;
        }
        i = -1;
        label147:
        if (localObject2 != null) {
          break label267;
        }
      }
      for (;;)
      {
        ab.d("MicroMsg.MMReg2.Req", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bo.cd(arrayOfByte), bo.cd((byte[])localObject2) });
        localzd.wsu = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
        this.wiO.wsy = localzd;
        localObject1 = this.wiO.toByteArray();
        AppMethodBeat.o(58862);
        return localObject1;
        localObject1 = new byte[0];
        break;
        label260:
        i = arrayOfByte.length;
        break label147;
        label267:
        j = localObject2.length;
      }
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public int eBe;
    private byte[] gda;
    private byte[] gdb;
    public bgg wiP;
    public byte[] wip;
    private byte[] wiq;
    
    public b()
    {
      AppMethodBeat.i(58863);
      this.wiP = new bgg();
      this.eBe = 0;
      AppMethodBeat.o(58863);
    }
    
    public final byte[] ME(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return new byte[0];
      case 1: 
        return this.wiq;
      case 2: 
        return this.gda;
      }
      return this.gdb;
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      AppMethodBeat.i(58865);
      this.wiq = paramArrayOfByte1;
      this.gda = paramArrayOfByte2;
      this.gdb = paramArrayOfByte3;
      ab.i("MicroMsg.MMReg2.Resp", "summerauths setSession [%s] [%s] [%s]", new Object[] { bo.aqg(bo.cd(this.wiq)), bo.aqg(bo.cd(this.gda)), bo.aqg(bo.cd(this.gdb)) });
      AppMethodBeat.o(58865);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(58864);
      this.eBe = 0;
      this.wiP = ((bgg)new bgg().parseFrom(paramArrayOfByte));
      l.a(this, this.wiP.getBaseResponse());
      this.eBe = 0;
      int i = this.wiP.getBaseResponse().Ret;
      AppMethodBeat.o(58864);
      return i;
    }
    
    public final int getCmdId()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.v
 * JD-Core Version:    0.7.0.1
 */