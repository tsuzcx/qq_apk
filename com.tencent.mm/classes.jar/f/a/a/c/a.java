package f.a.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a
{
  private final byte[] LVq;
  private final f.a.a.b.b.a LVr;
  private final OutputStream output;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2444);
    this.LVq = paramArrayOfByte;
    this.output = null;
    this.LVr = new f.a.a.b.b.a(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(2444);
  }
  
  public final void aO(int paramInt, long paramLong)
  {
    AppMethodBeat.i(2451);
    this.LVr.n(paramInt, paramLong);
    AppMethodBeat.o(2451);
  }
  
  public final void aR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2449);
    this.LVr.bv(paramInt1, paramInt2);
    AppMethodBeat.o(2449);
  }
  
  public final void bl(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(2445);
    this.LVr.bk(paramInt, paramBoolean);
    AppMethodBeat.o(2445);
  }
  
  public final void c(int paramInt, b paramb)
  {
    AppMethodBeat.i(2446);
    this.LVr.a(paramInt, paramb);
    AppMethodBeat.o(2446);
  }
  
  public final void d(int paramInt, String paramString)
  {
    AppMethodBeat.i(2452);
    this.LVr.d(paramInt, paramString);
    AppMethodBeat.o(2452);
  }
  
  public final void e(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(2447);
    this.LVr.e(paramInt, paramDouble);
    AppMethodBeat.o(2447);
  }
  
  public final void e(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    AppMethodBeat.i(2454);
    if (paramLinkedList != null)
    {
      switch (paramInt2)
      {
      default: 
        paramLinkedList = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(2454);
        throw paramLinkedList;
      case 6: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          c(paramInt1, (b)paramLinkedList.get(paramInt2));
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 4: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          e(paramInt1, ((Double)paramLinkedList.get(paramInt2)).doubleValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 5: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          x(paramInt1, ((Float)paramLinkedList.get(paramInt2)).floatValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 2: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          aR(paramInt1, ((Integer)paramLinkedList.get(paramInt2)).intValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 3: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          aO(paramInt1, ((Long)paramLinkedList.get(paramInt2)).longValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 1: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          d(paramInt1, (String)paramLinkedList.get(paramInt2));
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 7: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          bl(paramInt1, ((Boolean)paramLinkedList.get(paramInt2)).booleanValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      }
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        com.tencent.mm.bw.a locala = (com.tencent.mm.bw.a)paramLinkedList.get(paramInt2);
        ln(paramInt1, locala.computeSize());
        locala.writeFields(this);
        paramInt2 += 1;
      }
      AppMethodBeat.o(2454);
      return;
    }
    AppMethodBeat.o(2454);
  }
  
  public final void f(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    AppMethodBeat.i(2455);
    if (paramLinkedList != null) {
      switch (paramInt2)
      {
      default: 
        paramLinkedList = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(2455);
        throw paramLinkedList;
      case 2: 
        if (paramLinkedList.size() > 0)
        {
          this.LVr.bz(paramInt1, 2);
          this.LVr.fL(f.a.a.a.e(paramInt2, paramLinkedList));
          paramInt1 = 0;
          while (paramInt1 < paramLinkedList.size())
          {
            this.LVr.fL(((Integer)paramLinkedList.get(paramInt1)).intValue());
            paramInt1 += 1;
          }
          AppMethodBeat.o(2455);
          return;
        }
        break;
      case 3: 
        if (paramLinkedList.size() > 0)
        {
          this.LVr.bz(paramInt1, 2);
          this.LVr.fL(f.a.a.a.e(paramInt2, paramLinkedList));
          paramInt1 = 0;
          while (paramInt1 < paramLinkedList.size())
          {
            this.LVr.aw(((Long)paramLinkedList.get(paramInt1)).longValue());
            paramInt1 += 1;
          }
          AppMethodBeat.o(2455);
          return;
        }
        break;
      }
    }
    AppMethodBeat.o(2455);
  }
  
  public final void gfq()
  {
    AppMethodBeat.i(168739);
    if (this.output != null)
    {
      this.output.write(this.LVq);
      this.output.flush();
    }
    AppMethodBeat.o(168739);
  }
  
  public final void ln(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2453);
    this.LVr.ln(paramInt1, paramInt2);
    AppMethodBeat.o(2453);
  }
  
  public final void lo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210389);
    aR(paramInt1, paramInt2);
    AppMethodBeat.o(210389);
  }
  
  public final void x(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(2448);
    this.LVr.x(paramInt, paramFloat);
    AppMethodBeat.o(2448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */