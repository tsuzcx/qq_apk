package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class a
{
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
          paramInt2 = g.a.a.b.b.a.b(paramInt1, (b)paramLinkedList.get(j));
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
          paramInt2 = g.a.a.b.b.a.fS(paramInt1);
          j += 1;
          i = paramInt2 + 8 + i;
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
          paramInt2 = g.a.a.b.b.a.fS(paramInt1);
          j += 1;
          i = paramInt2 + 4 + i;
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
          paramInt2 = g.a.a.b.b.a.bu(paramInt1, ((Integer)paramLinkedList.get(j)).intValue());
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
          paramInt2 = g.a.a.b.b.a.r(paramInt1, ((Long)paramLinkedList.get(j)).longValue());
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
          paramInt2 = g.a.a.b.b.a.f(paramInt1, (String)paramLinkedList.get(j));
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
          paramInt2 = g.a.a.b.b.a.fS(paramInt1);
          j += 1;
          i = paramInt2 + 1 + i;
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
        paramInt2 = nh(paramInt1, ((com.tencent.mm.bw.a)paramLinkedList.get(j)).computeSize());
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
            j = g.a.a.b.b.a.fY(((Integer)paramLinkedList.get(i)).intValue());
            i += 1;
            paramInt2 = j + paramInt2;
          }
          i = g.a.a.b.b.a.fY(paramInt2) + paramInt2 + g.a.a.b.b.a.fS(paramInt1);
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
          j = g.a.a.b.b.a.aK(((Long)paramLinkedList.get(i)).longValue());
          i += 1;
          paramInt2 = j + paramInt2;
        }
        i = g.a.a.b.b.a.fY(paramInt2) + paramInt2 + g.a.a.b.b.a.fS(paramInt1);
      }
    }
  }
  
  public static int f(int paramInt, LinkedList<?> paramLinkedList)
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
            j = g.a.a.b.b.a.fY(((Integer)paramLinkedList.get(i)).intValue());
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
          j = g.a.a.b.b.a.aK(((Long)paramLinkedList.get(i)).longValue());
          i += 1;
          paramInt = j + paramInt;
        }
        i = paramInt;
      }
    }
  }
  
  public static int nh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2395);
    paramInt1 = g.a.a.b.b.a.fS(paramInt1);
    int i = g.a.a.b.b.a.fY(paramInt2);
    AppMethodBeat.o(2395);
    return paramInt1 + i + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     g.a.a.a
 * JD-Core Version:    0.7.0.1
 */