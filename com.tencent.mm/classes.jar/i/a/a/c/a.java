package i.a.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.io.OutputStream;
import java.util.LinkedList;

public class a
{
  public final byte[] ajGm;
  public byte[] ajGn;
  public final i.a.a.b.b.a ajGo;
  public final OutputStream osU;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2444);
    this.ajGm = paramArrayOfByte;
    this.osU = null;
    this.ajGo = new i.a.a.b.b.a(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(2444);
  }
  
  public final void bS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2449);
    this.ajGo.cF(paramInt1, paramInt2);
    AppMethodBeat.o(2449);
  }
  
  public final void bv(int paramInt, long paramLong)
  {
    AppMethodBeat.i(2451);
    this.ajGo.t(paramInt, paramLong);
    AppMethodBeat.o(2451);
  }
  
  public final void d(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(2447);
    this.ajGo.d(paramInt, paramDouble);
    AppMethodBeat.o(2447);
  }
  
  public final void d(int paramInt, b paramb)
  {
    AppMethodBeat.i(2446);
    this.ajGo.b(paramInt, paramb);
    AppMethodBeat.o(2446);
  }
  
  public final void di(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(2445);
    this.ajGo.I(paramInt, paramBoolean);
    AppMethodBeat.o(2445);
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
          d(paramInt1, (b)paramLinkedList.get(paramInt2));
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 4: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          d(paramInt1, ((Double)paramLinkedList.get(paramInt2)).doubleValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 5: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          l(paramInt1, ((Float)paramLinkedList.get(paramInt2)).floatValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 2: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          bS(paramInt1, ((Integer)paramLinkedList.get(paramInt2)).intValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 3: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          bv(paramInt1, ((Long)paramLinkedList.get(paramInt2)).longValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 1: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          g(paramInt1, (String)paramLinkedList.get(paramInt2));
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      case 7: 
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          di(paramInt1, ((Boolean)paramLinkedList.get(paramInt2)).booleanValue());
          paramInt2 += 1;
        }
        AppMethodBeat.o(2454);
        return;
      }
      paramInt2 = 0;
      while (paramInt2 < paramLinkedList.size())
      {
        com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)paramLinkedList.get(paramInt2);
        qD(paramInt1, locala.computeSize());
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
          this.ajGo.cE(paramInt1, 2);
          this.ajGo.lI(i.a.a.a.f(paramInt2, paramLinkedList));
          paramInt1 = 0;
          while (paramInt1 < paramLinkedList.size())
          {
            this.ajGo.lI(((Integer)paramLinkedList.get(paramInt1)).intValue());
            paramInt1 += 1;
          }
          AppMethodBeat.o(2455);
          return;
        }
        break;
      case 3: 
        if (paramLinkedList.size() > 0)
        {
          this.ajGo.cE(paramInt1, 2);
          this.ajGo.lI(i.a.a.a.f(paramInt2, paramLinkedList));
          paramInt1 = 0;
          while (paramInt1 < paramLinkedList.size())
          {
            this.ajGo.dg(((Long)paramLinkedList.get(paramInt1)).longValue());
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
  
  public final void g(int paramInt, String paramString)
  {
    AppMethodBeat.i(2452);
    this.ajGo.g(paramInt, paramString);
    AppMethodBeat.o(2452);
  }
  
  public final void kGd()
  {
    AppMethodBeat.i(168739);
    if (this.osU != null)
    {
      this.osU.write(this.ajGm);
      this.osU.flush();
    }
    AppMethodBeat.o(168739);
  }
  
  public final void l(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(2448);
    this.ajGo.l(paramInt, paramFloat);
    AppMethodBeat.o(2448);
  }
  
  public final void qD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2453);
    this.ajGo.qD(paramInt1, paramInt2);
    AppMethodBeat.o(2453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     i.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */