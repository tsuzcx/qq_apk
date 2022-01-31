package com.tencent.mm.wallet_core.c;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public abstract class s
  extends m
  implements k
{
  public Bundle BX;
  public String dIA = "";
  public long fKz = 0L;
  public int fzn = 0;
  private int jsS = 0;
  private long qLq;
  
  public final int a(e parame, q paramq, k paramk)
  {
    this.qLq = System.currentTimeMillis();
    return super.a(parame, paramq, paramk);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    long l1 = System.currentTimeMillis() - this.qLq;
    Object localObject = "";
    paramArrayOfByte = "";
    this.jsS = bfM();
    long l2 = System.currentTimeMillis();
    if (this.BX != null)
    {
      String str1 = this.BX.getString("key_TransId");
      String str2 = this.BX.getString("key_reqKey");
      if (this.fKz == 0L) {
        this.fKz = this.BX.getLong("key_SessionId", 0L);
      }
      paramArrayOfByte = str2;
      localObject = str1;
      if (this.fzn == 0)
      {
        this.fzn = this.BX.getInt("key_scene");
        localObject = str1;
        paramArrayOfByte = str2;
      }
    }
    h.nFQ.f(11170, new Object[] { Integer.valueOf(getType()), Integer.valueOf(this.jsS), Long.valueOf(l1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(aq.getNetType(ae.getContext())), this.dIA, localObject, paramArrayOfByte, Long.valueOf(this.fKz), Long.valueOf(l2) });
    w.a(getType(), bfM(), paramInt2, paramInt3, l1, this.fzn, this.dIA);
    e(paramInt2, paramInt3, paramString, paramq);
  }
  
  public int bfM()
  {
    return -1;
  }
  
  public abstract void e(int paramInt1, int paramInt2, String paramString, q paramq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.s
 * JD-Core Version:    0.7.0.1
 */