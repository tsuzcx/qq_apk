package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;

public final class x
{
  public static final class a
    extends l.d
    implements l.b
  {
    public byte[] FnM;
    public cco Foz;
    
    public a()
    {
      AppMethodBeat.i(133120);
      this.Foz = new cco();
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
      setRsaInfo(ac.fgx());
      this.Foz.FDQ = new SKBuiltinBuffer_t().setBuffer(bt.flL());
      this.Foz.setBaseRequest(l.a(this));
      this.Foz.GWs = j.Icu;
      afp localafp = new afp();
      localafp.GdB = 713;
      Object localObject2 = new PByteArray();
      Object localObject1 = new PByteArray();
      int m = MMProtocalJni.generateECKey(localafp.GdB, (PByteArray)localObject2, (PByteArray)localObject1);
      byte[] arrayOfByte = ((PByteArray)localObject2).value;
      localObject2 = ((PByteArray)localObject1).value;
      int i;
      label148:
      int j;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        this.FnM = ((byte[])localObject1);
        int n = localafp.GdB;
        if (arrayOfByte != null) {
          break label405;
        }
        i = -1;
        if (localObject2 != null) {
          break label412;
        }
        j = -1;
        label155:
        ad.d("MicroMsg.MMReg2.Req", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), bt.cB(arrayOfByte), bt.cB((byte[])localObject2) });
        localafp.FzN = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
        this.Foz.FzR = localafp;
      }
      for (;;)
      {
        try
        {
          localObject1 = b.wtJ.duO();
          if (localObject1 == null) {
            continue;
          }
          i = localObject1.length;
          ad.d("MicroMsg.MMReg2.Req", "[debug] ccd set on reg, len: %s", new Object[] { Integer.valueOf(i) });
          localObject2 = new eah();
          ((eah)localObject2).HNl = new SKBuiltinBuffer_t().setBuffer((byte[])localObject1);
          ((eah)localObject2).HNp = new SKBuiltinBuffer_t().setBuffer(b.wtJ.duR());
          i = k;
          if (((eah)localObject2).HNp != null) {
            i = ((eah)localObject2).HNp.getILen();
          }
          ad.d("MicroMsg.MMReg2.Req", "[debug] devtok on reg, len: %s", new Object[] { Integer.valueOf(i) });
          this.Foz.FzL = new SKBuiltinBuffer_t().setBuffer(((eah)localObject2).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          label405:
          label412:
          ad.printErrStackTrace("MicroMsg.MMReg2.Req", localThrowable, "cc throws exception.", new Object[0]);
          continue;
        }
        localObject1 = this.Foz.toByteArray();
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
    public byte[] FnR;
    private byte[] FnS;
    public ccp FoA;
    public int gva;
    private byte[] iEn;
    private byte[] iEo;
    
    public b()
    {
      AppMethodBeat.i(133122);
      this.FoA = new ccp();
      this.gva = 0;
      AppMethodBeat.o(133122);
    }
    
    public final byte[] ZE(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return new byte[0];
      case 1: 
        return this.FnS;
      case 2: 
        return this.iEn;
      }
      return this.iEo;
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      AppMethodBeat.i(133124);
      this.FnS = paramArrayOfByte1;
      this.iEn = paramArrayOfByte2;
      this.iEo = paramArrayOfByte3;
      ad.i("MicroMsg.MMReg2.Resp", "summerauths setSession [%s] [%s] [%s]", new Object[] { bt.aRp(bt.cB(this.FnS)), bt.aRp(bt.cB(this.iEn)), bt.aRp(bt.cB(this.iEo)) });
      AppMethodBeat.o(133124);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133123);
      this.gva = 0;
      this.FoA = ((ccp)new ccp().parseFrom(paramArrayOfByte));
      l.a(this, this.FoA.getBaseResponse());
      this.gva = 0;
      int i = this.FoA.getBaseResponse().Ret;
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