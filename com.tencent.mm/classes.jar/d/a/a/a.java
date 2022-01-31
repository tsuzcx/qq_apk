package d.a.a;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class a
{
  public static int KM(int paramInt)
  {
    return d.a.a.b.b.a.dQ(paramInt) + 1;
  }
  
  public static int X(int paramInt, long paramLong)
  {
    int i = d.a.a.b.b.a.dQ(paramInt);
    if ((0xFFFFFF80 & paramLong) == 0L) {
      paramInt = 1;
    }
    for (;;)
    {
      return paramInt + i;
      if ((0xFFFFC000 & paramLong) == 0L) {
        paramInt = 2;
      } else if ((0xFFE00000 & paramLong) == 0L) {
        paramInt = 3;
      } else if ((0xF0000000 & paramLong) == 0L) {
        paramInt = 4;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 5;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 6;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 7;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 8;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 9;
      } else {
        paramInt = 10;
      }
    }
  }
  
  public static int a(int paramInt, b paramb)
  {
    if (paramb == null) {
      return 0;
    }
    return d.a.a.b.b.a.dQ(paramInt) + d.a.a.b.b.a.dS(paramb.oY.length) + paramb.oY.length;
  }
  
  public static int c(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    if (paramLinkedList != null)
    {
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("The data type was not found, the id used was " + paramInt2);
      case 6: 
        paramInt2 = 0;
        i = 0;
        for (;;)
        {
          if (i >= paramLinkedList.size()) {
            return paramInt2;
          }
          j = a(paramInt1, (b)paramLinkedList.get(i));
          i += 1;
          paramInt2 = j + paramInt2;
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
          paramInt2 = d.a.a.b.b.a.dQ(paramInt1);
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
          paramInt2 = d.a.a.b.b.a.dQ(paramInt1);
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
          paramInt2 = gy(paramInt1, ((Integer)paramLinkedList.get(j)).intValue());
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
          paramInt2 = X(paramInt1, ((Long)paramLinkedList.get(j)).longValue());
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
          paramInt2 = d.a.a.b.b.a.e(paramInt1, (String)paramLinkedList.get(j));
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
          paramInt2 = d.a.a.b.b.a.dQ(paramInt1);
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
        paramInt2 = gA(paramInt1, ((com.tencent.mm.bv.a)paramLinkedList.get(j)).btq());
        j += 1;
        i = paramInt2 + i;
      }
    }
    return 0;
  }
  
  public static int c(int paramInt, LinkedList<?> paramLinkedList)
  {
    int j = 0;
    int i = j;
    if (paramLinkedList != null)
    {
      i = j;
      if (paramLinkedList.size() > 0)
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      if (i >= paramLinkedList.size())
      {
        i = d.a.a.b.b.a.dS(j) + j + d.a.a.b.b.a.dQ(paramInt);
        return i;
      }
      j += d.a.a.b.b.a.dS(((Integer)paramLinkedList.get(i)).intValue());
      i += 1;
    }
  }
  
  public static int e(int paramInt, String paramString)
  {
    return d.a.a.b.b.a.e(paramInt, paramString);
  }
  
  public static int gA(int paramInt1, int paramInt2)
  {
    return d.a.a.b.b.a.dQ(paramInt1) + d.a.a.b.b.a.dS(paramInt2) + paramInt2;
  }
  
  public static int gy(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      return d.a.a.b.b.a.dQ(paramInt1) + d.a.a.b.b.a.dS(paramInt2);
    }
    return d.a.a.b.b.a.dQ(paramInt1) + 10;
  }
  
  public static int gz(int paramInt1, int paramInt2)
  {
    return gy(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.a.a
 * JD-Core Version:    0.7.0.1
 */