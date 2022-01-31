package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.l;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.o;

public final class a$a
{
  private final b wVo;
  
  public a$a(a parama, b paramb)
  {
    this.wVo = paramb;
  }
  
  private void a(m paramm)
  {
    int i = 0;
    switch (paramm.cQn())
    {
    case 1: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    default: 
      throw new j("Unexpected type: " + Integer.toHexString(paramm.cQn()));
    case 0: 
      l.a(this.wVo, 0, paramm.readByte());
      return;
    case 2: 
      l.a(this.wVo, 2, paramm.readShort());
      return;
    case 4: 
      l.a(this.wVo, 4, paramm.readInt());
      return;
    case 6: 
      l.a(this.wVo, 6, paramm.readLong());
      return;
    case 3: 
      l.b(this.wVo, 3, paramm.readChar());
      return;
    case 16: 
      long l = Float.floatToIntBits(paramm.readFloat());
      l.c(this.wVo, 16, l << 32);
      return;
    case 17: 
      l.c(this.wVo, 17, Double.doubleToLongBits(paramm.readDouble()));
      return;
    case 23: 
      l.b(this.wVo, 23, this.wVm.JV(paramm.cQr()));
      return;
    case 24: 
      l.b(this.wVo, 24, this.wVm.JW(paramm.cQs()));
      return;
    case 25: 
      l.b(this.wVo, 25, this.wVm.JY(paramm.cQt()));
      return;
    case 27: 
      l.b(this.wVo, 27, this.wVm.JY(paramm.cQu()));
      return;
    case 26: 
      l.b(this.wVo, 26, this.wVm.JZ(paramm.cQv()));
      return;
    case 28: 
      gn(28, 0);
      c(paramm);
      return;
    case 29: 
      gn(29, 0);
      b(paramm);
      return;
    case 30: 
      paramm.cQw();
      gn(30, 0);
      return;
    }
    if (paramm.readBoolean()) {
      i = 1;
    }
    gn(31, i);
  }
  
  private void gn(int paramInt1, int paramInt2)
  {
    this.wVo.writeByte(paramInt2 << 5 | paramInt1);
  }
  
  public final void b(m paramm)
  {
    int j = paramm.cQp();
    o.a(this.wVo, this.wVm.JW(paramm.wSO));
    o.a(this.wVo, j);
    int i = 0;
    while (i < j)
    {
      o.a(this.wVo, this.wVm.JV(paramm.cQq()));
      a(paramm);
      i += 1;
    }
  }
  
  public final void c(m paramm)
  {
    int j = paramm.cQo();
    o.a(this.wVo, j);
    int i = 0;
    while (i < j)
    {
      a(paramm);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.c.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */