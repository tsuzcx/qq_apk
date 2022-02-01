package f.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class a
{
  public static int agm(int paramInt)
  {
    AppMethodBeat.i(2394);
    paramInt = f.a.a.b.b.a.fY(paramInt);
    AppMethodBeat.o(2394);
    return paramInt + 1;
  }
  
  public static int c(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    AppMethodBeat.i(2396);
    int i;
    if (paramLinkedList != null) {
      switch (paramInt2)
      {
      default: 
        paramLinkedList = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(2396);
        throw paramLinkedList;
      case 6: 
        paramInt2 = 0;
        i = 0;
        if (i < paramLinkedList.size()) {
          break;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(2396);
      return paramInt2;
      int j = f.a.a.b.b.a.b(paramInt1, (b)paramLinkedList.get(i));
      i += 1;
      paramInt2 = j + paramInt2;
      break;
      i = 0;
      j = 0;
      for (;;)
      {
        paramInt2 = i;
        if (j >= paramLinkedList.size()) {
          break;
        }
        ((Double)paramLinkedList.get(j)).doubleValue();
        paramInt2 = f.a.a.b.b.a.fY(paramInt1);
        j += 1;
        i = paramInt2 + 8 + i;
      }
      i = 0;
      j = 0;
      for (;;)
      {
        paramInt2 = i;
        if (j >= paramLinkedList.size()) {
          break;
        }
        ((Float)paramLinkedList.get(j)).floatValue();
        paramInt2 = f.a.a.b.b.a.fY(paramInt1);
        j += 1;
        i = paramInt2 + 4 + i;
      }
      i = 0;
      j = 0;
      for (;;)
      {
        paramInt2 = i;
        if (j >= paramLinkedList.size()) {
          break;
        }
        paramInt2 = f.a.a.b.b.a.bA(paramInt1, ((Integer)paramLinkedList.get(j)).intValue());
        j += 1;
        i = paramInt2 + i;
      }
      i = 0;
      j = 0;
      for (;;)
      {
        paramInt2 = i;
        if (j >= paramLinkedList.size()) {
          break;
        }
        paramInt2 = f.a.a.b.b.a.q(paramInt1, ((Long)paramLinkedList.get(j)).longValue());
        j += 1;
        i = paramInt2 + i;
      }
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
      i = 0;
      j = 0;
      for (;;)
      {
        paramInt2 = i;
        if (j >= paramLinkedList.size()) {
          break;
        }
        ((Boolean)paramLinkedList.get(j)).booleanValue();
        paramInt2 = f.a.a.b.b.a.fY(paramInt1);
        j += 1;
        i = paramInt2 + 1 + i;
      }
      i = 0;
      j = 0;
      for (;;)
      {
        paramInt2 = i;
        if (j >= paramLinkedList.size()) {
          break;
        }
        paramInt2 = kW(paramInt1, ((com.tencent.mm.bx.a)paramLinkedList.get(j)).computeSize());
        j += 1;
        i = paramInt2 + i;
      }
      paramInt2 = 0;
    }
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
          if (i < paramLinkedList.size()) {
            break label107;
          }
          i = f.a.a.b.b.a.ga(paramInt2) + paramInt2 + f.a.a.b.b.a.fY(paramInt1);
        }
        break;
      }
    }
    label107:
    do
    {
      AppMethodBeat.o(2397);
      return i;
      j = f.a.a.b.b.a.ga(((Integer)paramLinkedList.get(i)).intValue());
      i += 1;
      paramInt2 = j + paramInt2;
      break;
      i = j;
    } while (paramLinkedList.size() <= 0);
    paramInt2 = 0;
    i = 0;
    for (;;)
    {
      if (i >= paramLinkedList.size())
      {
        i = f.a.a.b.b.a.ga(paramInt2) + paramInt2 + f.a.a.b.b.a.fY(paramInt1);
        break;
      }
      j = f.a.a.b.b.a.aB(((Long)paramLinkedList.get(i)).longValue());
      i += 1;
      paramInt2 = j + paramInt2;
    }
  }
  
  public static int e(int paramInt, String paramString)
  {
    AppMethodBeat.i(205060);
    paramInt = f.a.a.b.b.a.e(paramInt, paramString);
    AppMethodBeat.o(205060);
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
          if (i < paramLinkedList.size()) {
            break label92;
          }
          i = paramInt;
        }
        break;
      }
    }
    label92:
    do
    {
      AppMethodBeat.o(2398);
      return i;
      j = f.a.a.b.b.a.ga(((Integer)paramLinkedList.get(i)).intValue());
      i += 1;
      paramInt = j + paramInt;
      break;
      i = j;
    } while (paramLinkedList.size() <= 0);
    paramInt = 0;
    i = 0;
    for (;;)
    {
      if (i >= paramLinkedList.size())
      {
        i = paramInt;
        break;
      }
      j = f.a.a.b.b.a.aB(((Long)paramLinkedList.get(i)).longValue());
      i += 1;
      paramInt = j + paramInt;
    }
  }
  
  public static int kV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205059);
    paramInt1 = f.a.a.b.b.a.bA(paramInt1, paramInt2);
    AppMethodBeat.o(205059);
    return paramInt1;
  }
  
  public static int kW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2395);
    paramInt1 = f.a.a.b.b.a.fY(paramInt1);
    int i = f.a.a.b.b.a.ga(paramInt2);
    AppMethodBeat.o(2395);
    return paramInt1 + i + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.a
 * JD-Core Version:    0.7.0.1
 */