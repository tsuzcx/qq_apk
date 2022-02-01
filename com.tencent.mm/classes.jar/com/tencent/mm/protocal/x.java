package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;

public final class x
{
  public static final class a
    extends l.d
    implements l.b
  {
    public byte[] Cqn;
    public btg Cra;
    
    public a()
    {
      AppMethodBeat.i(133120);
      this.Cra = new btg();
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
      setRsaInfo(ac.eBY());
      this.Cra.CFU = new SKBuiltinBuffer_t().setBuffer(bt.eGG());
      this.Cra.setBaseRequest(l.a(this));
      this.Cra.DQr = i.ETt;
      acp localacp = new acp();
      localacp.DcY = 713;
      Object localObject2 = new PByteArray();
      Object localObject1 = new PByteArray();
      int m = MMProtocalJni.generateECKey(localacp.DcY, (PByteArray)localObject2, (PByteArray)localObject1);
      byte[] arrayOfByte = ((PByteArray)localObject2).value;
      localObject2 = ((PByteArray)localObject1).value;
      int i;
      label148:
      int j;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        this.Cqn = ((byte[])localObject1);
        int n = localacp.DcY;
        if (arrayOfByte != null) {
          break label405;
        }
        i = -1;
        if (localObject2 != null) {
          break label412;
        }
        j = -1;
        label155:
        ad.d("MicroMsg.MMReg2.Req", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), bt.cv(arrayOfByte), bt.cv((byte[])localObject2) });
        localacp.CBW = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
        this.Cra.CCa = localacp;
      }
      for (;;)
      {
        try
        {
          localObject1 = b.ufs.cWU();
          if (localObject1 == null) {
            continue;
          }
          i = localObject1.length;
          ad.d("MicroMsg.MMReg2.Req", "[debug] ccd set on reg, len: %s", new Object[] { Integer.valueOf(i) });
          localObject2 = new dow();
          ((dow)localObject2).EFc = new SKBuiltinBuffer_t().setBuffer((byte[])localObject1);
          ((dow)localObject2).EFg = new SKBuiltinBuffer_t().setBuffer(b.ufs.cWX());
          i = k;
          if (((dow)localObject2).EFg != null) {
            i = ((dow)localObject2).EFg.getILen();
          }
          ad.d("MicroMsg.MMReg2.Req", "[debug] devtok on reg, len: %s", new Object[] { Integer.valueOf(i) });
          this.Cra.CBU = new SKBuiltinBuffer_t().setBuffer(((dow)localObject2).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          label405:
          label412:
          ad.printErrStackTrace("MicroMsg.MMReg2.Req", localThrowable, "cc throws exception.", new Object[0]);
          continue;
        }
        localObject1 = this.Cra.toByteArray();
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
    public byte[] Cqs;
    private byte[] Cqt;
    public bth Crb;
    public int fWJ;
    private byte[] hKA;
    private byte[] hKz;
    
    public b()
    {
      AppMethodBeat.i(133122);
      this.Crb = new bth();
      this.fWJ = 0;
      AppMethodBeat.o(133122);
    }
    
    public final byte[] Vz(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return new byte[0];
      case 1: 
        return this.Cqt;
      case 2: 
        return this.hKz;
      }
      return this.hKA;
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      AppMethodBeat.i(133124);
      this.Cqt = paramArrayOfByte1;
      this.hKz = paramArrayOfByte2;
      this.hKA = paramArrayOfByte3;
      ad.i("MicroMsg.MMReg2.Resp", "summerauths setSession [%s] [%s] [%s]", new Object[] { bt.aGs(bt.cv(this.Cqt)), bt.aGs(bt.cv(this.hKz)), bt.aGs(bt.cv(this.hKA)) });
      AppMethodBeat.o(133124);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133123);
      this.fWJ = 0;
      this.Crb = ((bth)new bth().parseFrom(paramArrayOfByte));
      l.a(this, this.Crb.getBaseResponse());
      this.fWJ = 0;
      int i = this.Crb.getBaseResponse().Ret;
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