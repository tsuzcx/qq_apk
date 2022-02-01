package a.a.a.c;

import com.tencent.mm.d.b;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a
{
  private final byte[] aqw;
  private final OutputStream aqx;
  private final a.a.a.b.b.a aqy;
  
  public a(byte[] paramArrayOfByte)
  {
    this.aqw = paramArrayOfByte;
    this.aqx = null;
    this.aqy = a.a.a.b.b.a.r(paramArrayOfByte);
  }
  
  private void as(int paramInt1, int paramInt2)
  {
    this.aqy.ap(paramInt1, paramInt2);
  }
  
  public final void at(int paramInt1, int paramInt2)
  {
    as(paramInt1, paramInt2);
  }
  
  public final void b(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    if (paramLinkedList != null) {
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt2)));
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
        this.aqy.a(paramInt1, d);
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        float f = ((Float)paramLinkedList.get(paramInt2)).floatValue();
        this.aqy.d(paramInt1, f);
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        as(paramInt1, ((Integer)paramLinkedList.get(paramInt2)).intValue());
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
        h(paramInt1, ((Boolean)paramLinkedList.get(paramInt2)).booleanValue());
        paramInt2 += 1;
      }
      continue;
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        com.tencent.mm.d.a locala = (com.tencent.mm.d.a)paramLinkedList.get(paramInt2);
        int i = locala.lk();
        this.aqy.aq(paramInt1, i);
        locala.a(this);
        paramInt2 += 1;
      }
    }
  }
  
  public final void c(int paramInt, b paramb)
  {
    this.aqy.a(paramInt, paramb);
  }
  
  public final void d(int paramInt, String paramString)
  {
    this.aqy.d(paramInt, paramString);
  }
  
  public final void g(int paramInt, long paramLong)
  {
    this.aqy.e(paramInt, paramLong);
  }
  
  public final void h(int paramInt, boolean paramBoolean)
  {
    this.aqy.g(paramInt, paramBoolean);
  }
  
  public final void pB()
  {
    if (this.aqx != null)
    {
      this.aqx.write(this.aqw);
      this.aqx.flush();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     a.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */