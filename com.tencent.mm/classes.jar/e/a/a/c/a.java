package e.a.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a
{
  public final byte[] CMa;
  private final e.a.a.b.b.a CMb;
  public final OutputStream output;
  
  public a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51910);
    this.CMa = paramArrayOfByte;
    this.output = null;
    this.CMb = new e.a.a.b.b.a(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(51910);
  }
  
  public final void aO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51915);
    this.CMb.bj(paramInt1, paramInt2);
    AppMethodBeat.o(51915);
  }
  
  public final void aS(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(51911);
    this.CMb.aR(paramInt, paramBoolean);
    AppMethodBeat.o(51911);
  }
  
  public final void am(int paramInt, long paramLong)
  {
    AppMethodBeat.i(51917);
    this.CMb.n(paramInt, paramLong);
    AppMethodBeat.o(51917);
  }
  
  public final void c(int paramInt, b paramb)
  {
    AppMethodBeat.i(51912);
    this.CMb.a(paramInt, paramb);
    AppMethodBeat.o(51912);
  }
  
  public final void e(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    AppMethodBeat.i(51920);
    if (paramLinkedList != null)
    {
      switch (paramInt2)
      {
      default: 
        paramLinkedList = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(51920);
        throw paramLinkedList;
      case 6: 
        paramInt2 = 0;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size())
          {
            AppMethodBeat.o(51920);
            return;
          }
          c(paramInt1, (b)paramLinkedList.get(paramInt2));
          paramInt2 += 1;
        }
      case 4: 
        paramInt2 = 0;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size())
          {
            AppMethodBeat.o(51920);
            return;
          }
          f(paramInt1, ((Double)paramLinkedList.get(paramInt2)).doubleValue());
          paramInt2 += 1;
        }
      case 5: 
        paramInt2 = 0;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size())
          {
            AppMethodBeat.o(51920);
            return;
          }
          q(paramInt1, ((Float)paramLinkedList.get(paramInt2)).floatValue());
          paramInt2 += 1;
        }
      case 2: 
        paramInt2 = 0;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size())
          {
            AppMethodBeat.o(51920);
            return;
          }
          aO(paramInt1, ((Integer)paramLinkedList.get(paramInt2)).intValue());
          paramInt2 += 1;
        }
      case 3: 
        paramInt2 = 0;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size())
          {
            AppMethodBeat.o(51920);
            return;
          }
          am(paramInt1, ((Long)paramLinkedList.get(paramInt2)).longValue());
          paramInt2 += 1;
        }
      case 1: 
        paramInt2 = 0;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size())
          {
            AppMethodBeat.o(51920);
            return;
          }
          e(paramInt1, (String)paramLinkedList.get(paramInt2));
          paramInt2 += 1;
        }
      case 7: 
        paramInt2 = 0;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size())
          {
            AppMethodBeat.o(51920);
            return;
          }
          aS(paramInt1, ((Boolean)paramLinkedList.get(paramInt2)).booleanValue());
          paramInt2 += 1;
        }
      }
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= paramLinkedList.size())
        {
          AppMethodBeat.o(51920);
          return;
        }
        com.tencent.mm.bv.a locala = (com.tencent.mm.bv.a)paramLinkedList.get(paramInt2);
        iQ(paramInt1, locala.computeSize());
        locala.writeFields(this);
        paramInt2 += 1;
      }
    }
    AppMethodBeat.o(51920);
  }
  
  public final void e(int paramInt, String paramString)
  {
    AppMethodBeat.i(51918);
    this.CMb.e(paramInt, paramString);
    AppMethodBeat.o(51918);
  }
  
  public final void f(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(51913);
    this.CMb.f(paramInt, paramDouble);
    AppMethodBeat.o(51913);
  }
  
  public final void f(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    AppMethodBeat.i(51921);
    if (paramLinkedList != null) {
      switch (paramInt2)
      {
      default: 
        paramLinkedList = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(51921);
        throw paramLinkedList;
      case 2: 
        if (paramLinkedList.size() > 0)
        {
          this.CMb.bn(paramInt1, 2);
          this.CMb.eX(e.a.a.a.e(paramInt2, paramLinkedList));
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= paramLinkedList.size())
            {
              AppMethodBeat.o(51921);
              return;
            }
            this.CMb.eX(((Integer)paramLinkedList.get(paramInt1)).intValue());
            paramInt1 += 1;
          }
        }
        break;
      case 3: 
        if (paramLinkedList.size() > 0)
        {
          this.CMb.bn(paramInt1, 2);
          this.CMb.eX(e.a.a.a.e(paramInt2, paramLinkedList));
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= paramLinkedList.size())
            {
              AppMethodBeat.o(51921);
              return;
            }
            this.CMb.ao(((Long)paramLinkedList.get(paramInt1)).longValue());
            paramInt1 += 1;
          }
        }
        break;
      }
    }
    AppMethodBeat.o(51921);
  }
  
  public final void iQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51919);
    this.CMb.iQ(paramInt1, paramInt2);
    AppMethodBeat.o(51919);
  }
  
  public final void iR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156879);
    aO(paramInt1, paramInt2);
    AppMethodBeat.o(156879);
  }
  
  public final void q(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(51914);
    this.CMb.q(paramInt, paramFloat);
    AppMethodBeat.o(51914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     e.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */