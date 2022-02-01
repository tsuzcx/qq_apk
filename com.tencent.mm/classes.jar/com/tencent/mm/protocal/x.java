package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;

public final class x
{
  public static final class a
    extends l.d
    implements l.b
  {
    public cdi FGX;
    public byte[] FGk;
    
    public a()
    {
      AppMethodBeat.i(133120);
      this.FGX = new cdi();
      AppMethodBeat.o(133120);
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
      int k = -1;
      AppMethodBeat.i(133121);
      setRsaInfo(ac.fkn());
      this.FGX.FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
      this.FGX.setBaseRequest(l.a(this));
      this.FGX.HpS = k.IwF;
      afy localafy = new afy();
      localafy.Gwi = 713;
      Object localObject2 = new PByteArray();
      Object localObject1 = new PByteArray();
      int m = MMProtocalJni.generateECKey(localafy.Gwi, (PByteArray)localObject2, (PByteArray)localObject1);
      byte[] arrayOfByte = ((PByteArray)localObject2).value;
      localObject2 = ((PByteArray)localObject1).value;
      int i;
      label148:
      int j;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        this.FGk = ((byte[])localObject1);
        int n = localafy.Gwi;
        if (arrayOfByte != null) {
          break label405;
        }
        i = -1;
        if (localObject2 != null) {
          break label412;
        }
        j = -1;
        label155:
        ae.d("MicroMsg.MMReg2.Req", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), bu.cE(arrayOfByte), bu.cE((byte[])localObject2) });
        localafy.FSl = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
        this.FGX.FSp = localafy;
      }
      for (;;)
      {
        try
        {
          localObject1 = b.wJt.dye();
          if (localObject1 == null) {
            continue;
          }
          i = localObject1.length;
          ae.d("MicroMsg.MMReg2.Req", "[debug] ccd set on reg, len: %s", new Object[] { Integer.valueOf(i) });
          localObject2 = new eby();
          ((eby)localObject2).Ihs = new SKBuiltinBuffer_t().setBuffer((byte[])localObject1);
          ((eby)localObject2).Ihw = new SKBuiltinBuffer_t().setBuffer(b.wJt.dyh());
          i = k;
          if (((eby)localObject2).Ihw != null) {
            i = ((eby)localObject2).Ihw.getILen();
          }
          ae.d("MicroMsg.MMReg2.Req", "[debug] devtok on reg, len: %s", new Object[] { Integer.valueOf(i) });
          this.FGX.FSj = new SKBuiltinBuffer_t().setBuffer(((eby)localObject2).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          label405:
          label412:
          ae.printErrStackTrace("MicroMsg.MMReg2.Req", localThrowable, "cc throws exception.", new Object[0]);
          continue;
        }
        localObject1 = this.FGX.toByteArray();
        AppMethodBeat.o(133121);
        return localObject1;
        localObject1 = new byte[0];
        break;
        i = arrayOfByte.length;
        break label148;
        j = localObject2.length;
        break label155;
        i = -1;
      }
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public cdj FGY;
    public byte[] FGp;
    private byte[] FGq;
    public int gxH;
    private byte[] iHg;
    private byte[] iHh;
    
    public b()
    {
      AppMethodBeat.i(133122);
      this.FGY = new cdj();
      this.gxH = 0;
      AppMethodBeat.o(133122);
    }
    
    public final byte[] aak(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return new byte[0];
      case 1: 
        return this.FGq;
      case 2: 
        return this.iHg;
      }
      return this.iHh;
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      AppMethodBeat.i(133124);
      this.FGq = paramArrayOfByte1;
      this.iHg = paramArrayOfByte2;
      this.iHh = paramArrayOfByte3;
      ae.i("MicroMsg.MMReg2.Resp", "summerauths setSession [%s] [%s] [%s]", new Object[] { bu.aSM(bu.cE(this.FGq)), bu.aSM(bu.cE(this.iHg)), bu.aSM(bu.cE(this.iHh)) });
      AppMethodBeat.o(133124);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133123);
      this.gxH = 0;
      this.FGY = ((cdj)new cdj().parseFrom(paramArrayOfByte));
      l.a(this, this.FGY.getBaseResponse());
      this.gxH = 0;
      int i = this.FGY.getBaseResponse().Ret;
      AppMethodBeat.o(133123);
      return i;
    }
    
    public final int getCmdId()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.x
 * JD-Core Version:    0.7.0.1
 */