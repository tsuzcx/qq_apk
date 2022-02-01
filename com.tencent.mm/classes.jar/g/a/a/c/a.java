package g.a.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.io.OutputStream;
import java.util.LinkedList;

public class a
{
  private final byte[] abFj;
  private final g.a.a.b.b.a abFk;
  private final OutputStream output;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2444);
    this.abFj = paramArrayOfByte;
    this.output = null;
    this.abFk = new g.a.a.b.b.a(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(2444);
  }
  
  public final void aY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2449);
    this.abFk.bJ(paramInt1, paramInt2);
    AppMethodBeat.o(2449);
  }
  
  public final void bm(int paramInt, long paramLong)
  {
    AppMethodBeat.i(2451);
    this.abFk.r(paramInt, paramLong);
    AppMethodBeat.o(2451);
  }
  
  public final void c(int paramInt, b paramb)
  {
    AppMethodBeat.i(2446);
    this.abFk.a(paramInt, paramb);
    AppMethodBeat.o(2446);
  }
  
  public final void co(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(2445);
    this.abFk.t(paramInt, paramBoolean);
    AppMethodBeat.o(2445);
  }
  
  public final void e(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(2447);
    this.abFk.e(paramInt, paramDouble);
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
          i(paramInt1, ((Float)paramLinkedList.get(paramInt2)).floatValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 2: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          aY(paramInt1, ((Integer)paramLinkedList.get(paramInt2)).intValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 3: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          bm(paramInt1, ((Long)paramLinkedList.get(paramInt2)).longValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 1: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          f(paramInt1, (String)paramLinkedList.get(paramInt2));
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 7: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          co(paramInt1, ((Boolean)paramLinkedList.get(paramInt2)).booleanValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      }
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        com.tencent.mm.cd.a locala = (com.tencent.mm.cd.a)paramLinkedList.get(paramInt2);
        oE(paramInt1, locala.computeSize());
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
          this.abFk.bI(paramInt1, 2);
          this.abFk.hT(g.a.a.a.g(paramInt2, paramLinkedList));
          paramInt1 = 0;
          while (paramInt1 < paramLinkedList.size())
          {
            this.abFk.hT(((Integer)paramLinkedList.get(paramInt1)).intValue());
            paramInt1 += 1;
          }
          AppMethodBeat.o(2455);
          return;
        }
        break;
      case 3: 
        if (paramLinkedList.size() > 0)
        {
          this.abFk.bI(paramInt1, 2);
          this.abFk.hT(g.a.a.a.g(paramInt2, paramLinkedList));
          paramInt1 = 0;
          while (paramInt1 < paramLinkedList.size())
          {
            this.abFk.aN(((Long)paramLinkedList.get(paramInt1)).longValue());
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
  
  public final void f(int paramInt, String paramString)
  {
    AppMethodBeat.i(2452);
    this.abFk.f(paramInt, paramString);
    AppMethodBeat.o(2452);
  }
  
  public final void i(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(2448);
    this.abFk.i(paramInt, paramFloat);
    AppMethodBeat.o(2448);
  }
  
  public final void iUC()
  {
    AppMethodBeat.i(168739);
    if (this.output != null)
    {
      this.output.write(this.abFj);
      this.output.flush();
    }
    AppMethodBeat.o(168739);
  }
  
  public final void oE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2453);
    this.abFk.oE(paramInt1, paramInt2);
    AppMethodBeat.o(2453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     g.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */