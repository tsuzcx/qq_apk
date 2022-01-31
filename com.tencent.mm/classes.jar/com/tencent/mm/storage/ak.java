package com.tencent.mm.storage;

import com.tencent.mm.h.c.cs;

public final class ak
  extends com.tencent.mm.o.a
  implements com.tencent.mm.cf.a.a<String>
{
  public bi uAh;
  
  public ak() {}
  
  public ak(String paramString)
  {
    super(paramString);
  }
  
  public final void V(int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 11: 
    default: 
      return;
    case 0: 
      fy((int)paramLong);
      return;
    case 1: 
      setStatus((int)paramLong);
      return;
    case 2: 
      fA((int)paramLong);
      return;
    case 3: 
      ba(paramLong);
      return;
    case 7: 
      bb(paramLong);
      return;
    case 10: 
      fC((int)paramLong);
      return;
    case 12: 
      fD((int)paramLong);
      return;
    case 13: 
      fE((int)paramLong);
      return;
    }
    fG((int)paramLong);
  }
  
  public final void ai(bi parambi)
  {
    setStatus(parambi.field_status);
    fA(parambi.field_isSend);
    if (parambi.aRR()) {}
    label80:
    for (;;)
    {
      long l = parambi.field_createTime;
      for (ak localak = this;; localak = this)
      {
        localak.ba(l);
        if (!parambi.cvm()) {
          break;
        }
        setContent(parambi.cvK());
        return;
        if (parambi.field_status != 1) {
          break label80;
        }
        l = 9223372036854775807L;
      }
      setContent(parambi.field_content);
      return;
    }
  }
  
  public final void bc(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 7: 
    case 10: 
    default: 
      return;
    case 4: 
      setUsername(paramString);
      return;
    case 5: 
      setContent(paramString);
      return;
    case 6: 
      dP(paramString);
      return;
    case 8: 
      dQ(paramString);
      return;
    case 9: 
      dR(paramString);
      return;
    }
    dT(paramString);
  }
  
  public final void ctt() {}
  
  public final void cuB()
  {
    setStatus(0);
    fA(0);
    setContent("");
    dP("0");
    fy(0);
    fG(0);
    bc(0L);
    fF(0);
    fF(0);
    super.dQ("");
    super.dR("");
  }
  
  public final void q(int paramInt, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ak
 * JD-Core Version:    0.7.0.1
 */