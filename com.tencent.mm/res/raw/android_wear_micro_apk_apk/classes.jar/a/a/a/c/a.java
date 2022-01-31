package a.a.a.c;

import com.tencent.mm.d.b;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a
{
  private final byte[] amU;
  private final OutputStream amV;
  private final a.a.a.b.b.a amW;
  
  public a(byte[] paramArrayOfByte)
  {
    this.amU = paramArrayOfByte;
    this.amV = null;
    this.amW = a.a.a.b.b.a.r(paramArrayOfByte);
  }
  
  private void ap(int paramInt1, int paramInt2)
  {
    this.amW.am(paramInt1, paramInt2);
  }
  
  public final void aq(int paramInt1, int paramInt2)
  {
    ap(paramInt1, paramInt2);
  }
  
  public final void b(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
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
      c(paramInt1, (b)paramLinkedList.get(paramInt2));
      paramInt2 += 1;
      break;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        double d = ((Double)paramLinkedList.get(paramInt2)).doubleValue();
        this.amW.a(paramInt1, d);
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        float f = ((Float)paramLinkedList.get(paramInt2)).floatValue();
        this.amW.c(paramInt1, f);
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        ap(paramInt1, ((Integer)paramLinkedList.get(paramInt2)).intValue());
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        g(paramInt1, ((Long)paramLinkedList.get(paramInt2)).longValue());
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
        g(paramInt1, ((Boolean)paramLinkedList.get(paramInt2)).booleanValue());
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        com.tencent.mm.d.a locala = (com.tencent.mm.d.a)paramLinkedList.get(paramInt2);
        int i = locala.la();
        this.amW.an(paramInt1, i);
        locala.a(this);
        paramInt2 += 1;
      }
    }
  }
  
  public final void c(int paramInt, b paramb)
  {
    this.amW.b(paramInt, paramb);
  }
  
  public final void d(int paramInt, String paramString)
  {
    this.amW.d(paramInt, paramString);
  }
  
  public final void g(int paramInt, long paramLong)
  {
    this.amW.f(paramInt, paramLong);
  }
  
  public final void g(int paramInt, boolean paramBoolean)
  {
    this.amW.f(paramInt, paramBoolean);
  }
  
  public final void oN()
  {
    if (this.amV != null)
    {
      this.amV.write(this.amU);
      this.amV.flush();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     a.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */