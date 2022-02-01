package f.a.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a
{
  private final byte[] NPP;
  private final f.a.a.b.b.a NPQ;
  private final OutputStream output;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2444);
    this.NPP = paramArrayOfByte;
    this.output = null;
    this.NPQ = f.a.a.b.b.a.de(paramArrayOfByte);
    AppMethodBeat.o(2444);
  }
  
  public final void aS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2449);
    this.NPQ.bx(paramInt1, paramInt2);
    AppMethodBeat.o(2449);
  }
  
  public final void aY(int paramInt, long paramLong)
  {
    AppMethodBeat.i(2451);
    this.NPQ.n(paramInt, paramLong);
    AppMethodBeat.o(2451);
  }
  
  public final void bt(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(2445);
    this.NPQ.bs(paramInt, paramBoolean);
    AppMethodBeat.o(2445);
  }
  
  public final void c(int paramInt, b paramb)
  {
    AppMethodBeat.i(2446);
    this.NPQ.a(paramInt, paramb);
    AppMethodBeat.o(2446);
  }
  
  public final void d(int paramInt, String paramString)
  {
    AppMethodBeat.i(2452);
    this.NPQ.d(paramInt, paramString);
    AppMethodBeat.o(2452);
  }
  
  public final void e(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(2447);
    this.NPQ.e(paramInt, paramDouble);
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
          z(paramInt1, ((Float)paramLinkedList.get(paramInt2)).floatValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 2: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          aS(paramInt1, ((Integer)paramLinkedList.get(paramInt2)).intValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 3: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          aY(paramInt1, ((Long)paramLinkedList.get(paramInt2)).longValue());
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
          bt(paramInt1, ((Boolean)paramLinkedList.get(paramInt2)).booleanValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      }
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)paramLinkedList.get(paramInt2);
        lC(paramInt1, locala.computeSize());
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
          this.NPQ.bB(paramInt1, 2);
          this.NPQ.alS(f.a.a.a.e(paramInt2, paramLinkedList));
          paramInt1 = 0;
          while (paramInt1 < paramLinkedList.size())
          {
            this.NPQ.fO(((Integer)paramLinkedList.get(paramInt1)).intValue());
            paramInt1 += 1;
          }
          AppMethodBeat.o(2455);
          return;
        }
        break;
      case 3: 
        if (paramLinkedList.size() > 0)
        {
          this.NPQ.bB(paramInt1, 2);
          this.NPQ.alS(f.a.a.a.e(paramInt2, paramLinkedList));
          paramInt1 = 0;
          while (paramInt1 < paramLinkedList.size())
          {
            this.NPQ.aw(((Long)paramLinkedList.get(paramInt1)).longValue());
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
  
  public final void gxO()
  {
    AppMethodBeat.i(168739);
    if (this.output != null)
    {
      this.output.write(this.NPP);
      this.output.flush();
    }
    AppMethodBeat.o(168739);
  }
  
  public final void lC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2453);
    this.NPQ.lC(paramInt1, paramInt2);
    AppMethodBeat.o(2453);
  }
  
  public final void lD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221596);
    aS(paramInt1, paramInt2);
    AppMethodBeat.o(221596);
  }
  
  public final void z(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(2448);
    this.NPQ.z(paramInt, paramFloat);
    AppMethodBeat.o(2448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */