package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;

public final class x
{
  public static final class a
    extends l.d
    implements l.b
  {
    public byte[] DIF;
    public bxx DJs;
    
    public a()
    {
      AppMethodBeat.i(133120);
      this.DJs = new bxx();
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
      setRsaInfo(ac.eRt());
      this.DJs.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
      this.DJs.setBaseRequest(l.a(this));
      this.DJs.FmJ = i.GqG;
      ado localado = new ado();
      localado.Ewf = 713;
      Object localObject2 = new PByteArray();
      Object localObject1 = new PByteArray();
      int m = MMProtocalJni.generateECKey(localado.Ewf, (PByteArray)localObject2, (PByteArray)localObject1);
      byte[] arrayOfByte = ((PByteArray)localObject2).value;
      localObject2 = ((PByteArray)localObject1).value;
      int i;
      label148:
      int j;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        this.DIF = ((byte[])localObject1);
        int n = localado.Ewf;
        if (arrayOfByte != null) {
          break label405;
        }
        i = -1;
        if (localObject2 != null) {
          break label412;
        }
        j = -1;
        label155:
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MMReg2.Req", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), bs.cu(arrayOfByte), bs.cu((byte[])localObject2) });
        localado.DUt = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
        this.DJs.DUx = localado;
      }
      for (;;)
      {
        try
        {
          localObject1 = b.vor.dkC();
          if (localObject1 == null) {
            continue;
          }
          i = localObject1.length;
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MMReg2.Req", "[debug] ccd set on reg, len: %s", new Object[] { Integer.valueOf(i) });
          localObject2 = new dun();
          ((dun)localObject2).Gco = new SKBuiltinBuffer_t().setBuffer((byte[])localObject1);
          ((dun)localObject2).Gcs = new SKBuiltinBuffer_t().setBuffer(b.vor.dkF());
          i = k;
          if (((dun)localObject2).Gcs != null) {
            i = ((dun)localObject2).Gcs.getILen();
          }
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MMReg2.Req", "[debug] devtok on reg, len: %s", new Object[] { Integer.valueOf(i) });
          this.DJs.DUr = new SKBuiltinBuffer_t().setBuffer(((dun)localObject2).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          label405:
          label412:
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.MMReg2.Req", localThrowable, "cc throws exception.", new Object[0]);
          continue;
        }
        localObject1 = this.DJs.toByteArray();
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
    public byte[] DIK;
    private byte[] DIL;
    public bxy DJt;
    public int gbq;
    private byte[] ikW;
    private byte[] ikX;
    
    public b()
    {
      AppMethodBeat.i(133122);
      this.DJt = new bxy();
      this.gbq = 0;
      AppMethodBeat.o(133122);
    }
    
    public final byte[] XI(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return new byte[0];
      case 1: 
        return this.DIL;
      case 2: 
        return this.ikW;
      }
      return this.ikX;
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      AppMethodBeat.i(133124);
      this.DIL = paramArrayOfByte1;
      this.ikW = paramArrayOfByte2;
      this.ikX = paramArrayOfByte3;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMReg2.Resp", "summerauths setSession [%s] [%s] [%s]", new Object[] { bs.aLJ(bs.cu(this.DIL)), bs.aLJ(bs.cu(this.ikW)), bs.aLJ(bs.cu(this.ikX)) });
      AppMethodBeat.o(133124);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133123);
      this.gbq = 0;
      this.DJt = ((bxy)new bxy().parseFrom(paramArrayOfByte));
      l.a(this, this.DJt.getBaseResponse());
      this.gbq = 0;
      int i = this.DJt.getBaseResponse().Ret;
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