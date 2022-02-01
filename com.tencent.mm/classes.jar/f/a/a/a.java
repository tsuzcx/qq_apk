package f.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class a
{
  public static int alP(int paramInt)
  {
    AppMethodBeat.i(2394);
    paramInt = f.a.a.b.b.a.alV(paramInt);
    AppMethodBeat.o(2394);
    return paramInt;
  }
  
  public static int c(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    AppMethodBeat.i(2396);
    if (paramLinkedList != null)
    {
      switch (paramInt2)
      {
      default: 
        paramLinkedList = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(2396);
        throw paramLinkedList;
      case 6: 
        i = 0;
        j = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          paramInt2 = f.a.a.b.b.a.b(paramInt1, (b)paramLinkedList.get(j));
          j += 1;
          i = paramInt2 + i;
        }
      case 4: 
        i = 0;
        j = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          ((Double)paramLinkedList.get(j)).doubleValue();
          paramInt2 = f.a.a.b.b.a.alT(paramInt1);
          j += 1;
          i = paramInt2 + i;
        }
      case 5: 
        i = 0;
        j = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          ((Float)paramLinkedList.get(j)).floatValue();
          paramInt2 = f.a.a.b.b.a.alU(paramInt1);
          j += 1;
          i = paramInt2 + i;
        }
      case 2: 
        i = 0;
        j = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          paramInt2 = f.a.a.b.b.a.bz(paramInt1, ((Integer)paramLinkedList.get(j)).intValue());
          j += 1;
          i = paramInt2 + i;
        }
      case 3: 
        i = 0;
        j = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          paramInt2 = f.a.a.b.b.a.p(paramInt1, ((Long)paramLinkedList.get(j)).longValue());
          j += 1;
          i = paramInt2 + i;
        }
      case 1: 
        i = 0;
        j = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          paramInt2 = f.a.a.b.b.a.e(paramInt1, (String)paramLinkedList.get(j));
          j += 1;
          i = paramInt2 + i;
        }
      case 7: 
        i = 0;
        j = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          ((Boolean)paramLinkedList.get(j)).booleanValue();
          paramInt2 = f.a.a.b.b.a.alV(paramInt1);
          j += 1;
          i = paramInt2 + i;
        }
      }
      int i = 0;
      int j = 0;
      for (;;)
      {
        paramInt2 = i;
        if (j >= paramLinkedList.size()) {
          break;
        }
        paramInt2 = lB(paramInt1, ((com.tencent.mm.bx.a)paramLinkedList.get(j)).computeSize());
        j += 1;
        i = paramInt2 + i;
      }
    }
    paramInt2 = 0;
    AppMethodBeat.o(2396);
    return paramInt2;
  }
  
  public static int d(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    int j = 0;
    AppMethodBeat.i(2397);
    int i = j;
    if (paramLinkedList != null) {
      switch (paramInt2)
      {
      default: 
        paramLinkedList = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(2397);
        throw paramLinkedList;
      case 2: 
        i = j;
        if (paramLinkedList.size() > 0)
        {
          paramInt2 = 0;
          i = 0;
          while (i < paramLinkedList.size())
          {
            j = f.a.a.b.b.a.fP(((Integer)paramLinkedList.get(i)).intValue());
            i += 1;
            paramInt2 = j + paramInt2;
          }
          i = f.a.a.b.b.a.fP(paramInt2) + paramInt2 + f.a.a.b.b.a.fN(paramInt1);
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(2397);
      return i;
      i = j;
      if (paramLinkedList.size() > 0)
      {
        paramInt2 = 0;
        i = 0;
        while (i < paramLinkedList.size())
        {
          j = f.a.a.b.b.a.ax(((Long)paramLinkedList.get(i)).longValue());
          i += 1;
          paramInt2 = j + paramInt2;
        }
        i = f.a.a.b.b.a.fP(paramInt2) + paramInt2 + f.a.a.b.b.a.fN(paramInt1);
      }
    }
  }
  
  public static int e(int paramInt, String paramString)
  {
    AppMethodBeat.i(221592);
    paramInt = f.a.a.b.b.a.e(paramInt, paramString);
    AppMethodBeat.o(221592);
    return paramInt;
  }
  
  public static int e(int paramInt, LinkedList<?> paramLinkedList)
  {
    int j = 0;
    AppMethodBeat.i(2398);
    int i = j;
    if (paramLinkedList != null) {
      switch (paramInt)
      {
      default: 
        paramLinkedList = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(2398);
        throw paramLinkedList;
      case 2: 
        i = j;
        if (paramLinkedList.size() > 0)
        {
          paramInt = 0;
          i = 0;
          while (i < paramLinkedList.size())
          {
            j = f.a.a.b.b.a.fP(((Integer)paramLinkedList.get(i)).intValue());
            i += 1;
            paramInt = j + paramInt;
          }
          i = paramInt;
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(2398);
      return i;
      i = j;
      if (paramLinkedList.size() > 0)
      {
        paramInt = 0;
        i = 0;
        while (i < paramLinkedList.size())
        {
          j = f.a.a.b.b.a.ax(((Long)paramLinkedList.get(i)).longValue());
          i += 1;
          paramInt = j + paramInt;
        }
        i = paramInt;
      }
    }
  }
  
  public static int lA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221591);
    paramInt1 = f.a.a.b.b.a.bz(paramInt1, paramInt2);
    AppMethodBeat.o(221591);
    return paramInt1;
  }
  
  public static int lB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2395);
    paramInt1 = f.a.a.b.b.a.fN(paramInt1);
    int i = f.a.a.b.b.a.fP(paramInt2);
    AppMethodBeat.o(2395);
    return paramInt1 + i + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.a
 * JD-Core Version:    0.7.0.1
 */