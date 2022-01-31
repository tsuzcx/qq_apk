package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.azc;
import com.tencent.mm.protocal.c.azd;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.e;

public final class u
{
  public static final class a
    extends k.d
    implements k.b
  {
    public byte[] spy;
    public azc sqk = new azc();
    
    public final byte[] HG()
    {
      int j = -1;
      this.spM = y.cph();
      this.sqk.sBt = new bmk().bs(bk.crT());
      this.sqk.tEX = k.a(this);
      this.sqk.tuV = e.ueh;
      uq localuq = new uq();
      localuq.sRn = 713;
      Object localObject2 = new PByteArray();
      Object localObject1 = new PByteArray();
      int k = MMProtocalJni.generateECKey(localuq.sRn, (PByteArray)localObject2, (PByteArray)localObject1);
      byte[] arrayOfByte = ((PByteArray)localObject2).value;
      localObject2 = ((PByteArray)localObject1).value;
      int m;
      int i;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        this.spy = ((byte[])localObject1);
        m = localuq.sRn;
        if (arrayOfByte != null) {
          break label245;
        }
        i = -1;
        label141:
        if (localObject2 != null) {
          break label252;
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReg2.Req", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bk.bD(arrayOfByte), bk.bD((byte[])localObject2) });
        localuq.syK = new bmk().bs(arrayOfByte);
        this.sqk.syO = localuq;
        return this.sqk.toByteArray();
        localObject1 = new byte[0];
        break;
        label245:
        i = arrayOfByte.length;
        break label141;
        label252:
        j = localObject2.length;
      }
    }
    
    public final int HH()
    {
      return 126;
    }
    
    public final int getCmdId()
    {
      return 0;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public int dDD = 0;
    public byte[] eNt;
    public byte[] spA;
    public azd sqm = new azd();
    
    public final int A(byte[] paramArrayOfByte)
    {
      this.dDD = 0;
      this.sqm = ((azd)new azd().aH(paramArrayOfByte));
      k.a(this, this.sqm.tFx);
      this.dDD = 0;
      return this.sqm.tFx.sze;
    }
    
    public final void bn(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.eNt = paramArrayOfByte;
        return;
        paramArrayOfByte = new byte[0];
      }
    }
    
    public final int getCmdId()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.u
 * JD-Core Version:    0.7.0.1
 */