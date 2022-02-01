package a.a.a;

import com.tencent.mm.d.b;
import java.util.LinkedList;

public final class a
{
  public static int a(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    if (paramLinkedList != null)
    {
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(paramInt2)));
      case 6: 
        paramInt2 = 0;
        i = 0;
        for (;;)
        {
          if (i >= paramLinkedList.size()) {
            return paramInt2;
          }
          j = a.a.a.b.b.a.b(paramInt1, (b)paramLinkedList.get(i));
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
          paramInt2 = a.a.a.b.b.a.cK(paramInt1);
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
          paramInt2 = a.a.a.b.b.a.cK(paramInt1);
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
          paramInt2 = an(paramInt1, ((Integer)paramLinkedList.get(j)).intValue());
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
          paramInt2 = a.a.a.b.b.a.f(paramInt1, ((Long)paramLinkedList.get(j)).longValue());
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
          paramInt2 = a.a.a.b.b.a.e(paramInt1, (String)paramLinkedList.get(j));
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
          paramInt2 = a.a.a.b.b.a.cK(paramInt1);
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
        paramInt2 = ((com.tencent.mm.d.a)paramLinkedList.get(j)).lk();
        int k = a.a.a.b.b.a.cK(paramInt1);
        int m = a.a.a.b.b.a.cM(paramInt2);
        j += 1;
        i = paramInt2 + (k + m) + i;
      }
    }
    return 0;
  }
  
  public static int an(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      return a.a.a.b.b.a.cK(paramInt1) + a.a.a.b.b.a.cM(paramInt2);
    }
    return a.a.a.b.b.a.cK(paramInt1) + 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     a.a.a.a
 * JD-Core Version:    0.7.0.1
 */