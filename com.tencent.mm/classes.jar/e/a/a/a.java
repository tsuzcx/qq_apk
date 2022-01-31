package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class a
{
  public static int Wo(int paramInt)
  {
    AppMethodBeat.i(51860);
    paramInt = e.a.a.b.b.a.eW(paramInt);
    AppMethodBeat.o(51860);
    return paramInt + 1;
  }
  
  public static int c(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    AppMethodBeat.i(51862);
    int i;
    if (paramLinkedList != null) {
      switch (paramInt2)
      {
      default: 
        paramLinkedList = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(51862);
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
      AppMethodBeat.o(51862);
      return paramInt2;
      int j = e.a.a.b.b.a.b(paramInt1, (b)paramLinkedList.get(i));
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
        paramInt2 = e.a.a.b.b.a.eW(paramInt1);
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
        paramInt2 = e.a.a.b.b.a.eW(paramInt1);
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
        paramInt2 = e.a.a.b.b.a.bl(paramInt1, ((Integer)paramLinkedList.get(j)).intValue());
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
        paramInt2 = e.a.a.b.b.a.p(paramInt1, ((Long)paramLinkedList.get(j)).longValue());
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
        paramInt2 = e.a.a.b.b.a.f(paramInt1, (String)paramLinkedList.get(j));
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
        paramInt2 = e.a.a.b.b.a.eW(paramInt1);
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
        paramInt2 = iP(paramInt1, ((com.tencent.mm.bv.a)paramLinkedList.get(j)).computeSize());
        j += 1;
        i = paramInt2 + i;
      }
      paramInt2 = 0;
    }
  }
  
  public static int d(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    int j = 0;
    AppMethodBeat.i(51863);
    int i = j;
    if (paramLinkedList != null) {
      switch (paramInt2)
      {
      default: 
        paramLinkedList = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(51863);
        throw paramLinkedList;
      case 2: 
        i = j;
        if (paramLinkedList.size() > 0)
        {
          paramInt2 = 0;
          i = 0;
          if (i < paramLinkedList.size()) {
            break label105;
          }
          i = e.a.a.b.b.a.eY(paramInt2) + paramInt2 + e.a.a.b.b.a.eW(paramInt1);
        }
        break;
      }
    }
    label105:
    do
    {
      AppMethodBeat.o(51863);
      return i;
      j = e.a.a.b.b.a.eY(((Integer)paramLinkedList.get(i)).intValue());
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
        i = e.a.a.b.b.a.eY(paramInt2) + paramInt2 + e.a.a.b.b.a.eW(paramInt1);
        break;
      }
      j = e.a.a.b.b.a.ap(((Long)paramLinkedList.get(i)).longValue());
      i += 1;
      paramInt2 = j + paramInt2;
    }
  }
  
  public static int e(int paramInt, LinkedList<?> paramLinkedList)
  {
    int j = 0;
    AppMethodBeat.i(51864);
    int i = j;
    if (paramLinkedList != null) {
      switch (paramInt)
      {
      default: 
        paramLinkedList = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(51864);
        throw paramLinkedList;
      case 2: 
        i = j;
        if (paramLinkedList.size() > 0)
        {
          paramInt = 0;
          i = 0;
          if (i < paramLinkedList.size()) {
            break label90;
          }
          i = paramInt;
        }
        break;
      }
    }
    label90:
    do
    {
      AppMethodBeat.o(51864);
      return i;
      j = e.a.a.b.b.a.eY(((Integer)paramLinkedList.get(i)).intValue());
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
      j = e.a.a.b.b.a.ap(((Long)paramLinkedList.get(i)).longValue());
      i += 1;
      paramInt = j + paramInt;
    }
  }
  
  public static int f(int paramInt, String paramString)
  {
    AppMethodBeat.i(156876);
    paramInt = e.a.a.b.b.a.f(paramInt, paramString);
    AppMethodBeat.o(156876);
    return paramInt;
  }
  
  public static int iO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156875);
    paramInt1 = e.a.a.b.b.a.bl(paramInt1, paramInt2);
    AppMethodBeat.o(156875);
    return paramInt1;
  }
  
  public static int iP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51861);
    paramInt1 = e.a.a.b.b.a.eW(paramInt1);
    int i = e.a.a.b.b.a.eY(paramInt2);
    AppMethodBeat.o(51861);
    return paramInt1 + i + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     e.a.a.a
 * JD-Core Version:    0.7.0.1
 */