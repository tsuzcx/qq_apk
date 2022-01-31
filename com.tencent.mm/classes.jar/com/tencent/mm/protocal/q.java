package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.ads;
import com.tencent.mm.protocal.c.adt;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.sdk.platformtools.bk;

public final class q
{
  public static final class a
    extends k.d
    implements k.b
  {
    public ads sqe = new ads();
    
    public final byte[] HG()
    {
      this.spM = y.cpj();
      this.sqe.sBt = new bmk().bs(bk.crT());
      this.sqe.tbO = y.cph().ver;
      this.sqe.tEX = k.a(this);
      return this.sqe.toByteArray();
    }
    
    public final int HH()
    {
      return 381;
    }
    
    public final int getCmdId()
    {
      return 179;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public adt sqf = new adt();
    
    public final int A(byte[] paramArrayOfByte)
    {
      this.sqf = ((adt)new adt().aH(paramArrayOfByte));
      k.a(this, this.sqf.tFx);
      return this.sqf.tFx.sze;
    }
    
    public final int getCmdId()
    {
      return 1000000179;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.q
 * JD-Core Version:    0.7.0.1
 */