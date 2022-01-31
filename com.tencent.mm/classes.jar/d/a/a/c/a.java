package d.a.a.c;

import com.tencent.mm.bv.b;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a
{
  public final OutputStream eca;
  public final byte[] xpN;
  private final d.a.a.b.b.a xpO;
  
  public a(byte[] paramArrayOfByte)
  {
    this.xpN = paramArrayOfByte;
    this.eca = null;
    this.xpO = new d.a.a.b.b.a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final void Y(int paramInt, long paramLong)
  {
    d.a.a.b.b.a locala = this.xpO;
    locala.aP(paramInt, 0);
    locala.ab(paramLong);
  }
  
  public final void aA(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    d.a.a.b.b.a locala = this.xpO;
    locala.aP(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    locala.dP(paramInt);
  }
  
  public final void b(int paramInt, double paramDouble)
  {
    d.a.a.b.b.a locala = this.xpO;
    locala.aP(paramInt, 1);
    long l = Double.doubleToLongBits(paramDouble);
    locala.dP((int)l & 0xFF);
    locala.dP((int)(l >> 8) & 0xFF);
    locala.dP((int)(l >> 16) & 0xFF);
    locala.dP((int)(l >> 24) & 0xFF);
    locala.dP((int)(l >> 32) & 0xFF);
    locala.dP((int)(l >> 40) & 0xFF);
    locala.dP((int)(l >> 48) & 0xFF);
    locala.dP((int)(l >> 56) & 0xFF);
  }
  
  public final void b(int paramInt, b paramb)
  {
    d.a.a.b.b.a locala = this.xpO;
    if (paramb != null)
    {
      locala.aP(paramInt, 2);
      paramb = paramb.toByteArray();
      locala.dR(paramb.length);
      locala.j(paramb);
    }
  }
  
  public final void d(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    if (paramLinkedList != null) {
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("The data type was not found, the id used was " + paramInt2);
      case 6: 
        paramInt2 = 0;
        if (paramInt2 < paramLinkedList.size()) {
          break;
        }
      }
    }
    for (;;)
    {
      return;
      b(paramInt1, (b)paramLinkedList.get(paramInt2));
      paramInt2 += 1;
      break;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        b(paramInt1, ((Double)paramLinkedList.get(paramInt2)).doubleValue());
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        m(paramInt1, ((Float)paramLinkedList.get(paramInt2)).floatValue());
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        gB(paramInt1, ((Integer)paramLinkedList.get(paramInt2)).intValue());
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        Y(paramInt1, ((Long)paramLinkedList.get(paramInt2)).longValue());
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        d(paramInt1, (String)paramLinkedList.get(paramInt2));
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        aA(paramInt1, ((Boolean)paramLinkedList.get(paramInt2)).booleanValue());
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        com.tencent.mm.bv.a locala = (com.tencent.mm.bv.a)paramLinkedList.get(paramInt2);
        gD(paramInt1, locala.btq());
        locala.a(this);
        paramInt2 += 1;
      }
    }
  }
  
  public final void d(int paramInt, String paramString)
  {
    d.a.a.b.b.a locala = this.xpO;
    if (paramString != null)
    {
      locala.aP(paramInt, 2);
      paramString = paramString.getBytes("UTF-8");
      locala.dR(paramString.length);
      locala.j(paramString);
    }
  }
  
  public final void d(int paramInt, LinkedList<?> paramLinkedList)
  {
    int j = 0;
    d.a.a.b.b.a locala;
    int i;
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      this.xpO.aP(paramInt, 2);
      locala = this.xpO;
      if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
        break label123;
      }
      paramInt = 0;
      i = 0;
      if (i < paramLinkedList.size()) {
        break label70;
      }
    }
    for (;;)
    {
      locala.dR(paramInt);
      paramInt = j;
      for (;;)
      {
        if (paramInt >= paramLinkedList.size())
        {
          return;
          label70:
          int k = d.a.a.b.b.a.dS(((Integer)paramLinkedList.get(i)).intValue());
          i += 1;
          paramInt = k + paramInt;
          break;
        }
        this.xpO.dR(((Integer)paramLinkedList.get(paramInt)).intValue());
        paramInt += 1;
      }
      label123:
      paramInt = 0;
    }
  }
  
  public final void gB(int paramInt1, int paramInt2)
  {
    d.a.a.b.b.a locala = this.xpO;
    locala.aP(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      locala.dR(paramInt2);
      return;
    }
    locala.ab(paramInt2);
  }
  
  public final void gC(int paramInt1, int paramInt2)
  {
    gB(paramInt1, paramInt2);
  }
  
  public final void gD(int paramInt1, int paramInt2)
  {
    d.a.a.b.b.a locala = this.xpO;
    locala.aP(paramInt1, 2);
    locala.dR(paramInt2);
  }
  
  public final void m(int paramInt, float paramFloat)
  {
    d.a.a.b.b.a locala = this.xpO;
    locala.aP(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    locala.dP(paramInt & 0xFF);
    locala.dP(paramInt >> 8 & 0xFF);
    locala.dP(paramInt >> 16 & 0xFF);
    locala.dP(paramInt >> 24 & 0xFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */