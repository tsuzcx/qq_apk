package com.tencent.tinker.a.a.b;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class e
{
  public static int hash(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return 0;
    }
    int n = paramVarArgs.length;
    int k = 0;
    int j = 0;
    if (k < n)
    {
      Object localObject = paramVarArgs[k];
      int i = j;
      if (localObject != null)
      {
        if ((localObject instanceof Number)) {
          break label327;
        }
        if (!(localObject instanceof boolean[])) {
          break label72;
        }
        i = j + Arrays.hashCode((boolean[])localObject);
      }
      label327:
      for (;;)
      {
        k += 1;
        j = i;
        break;
        label72:
        if ((localObject instanceof byte[]))
        {
          i = j + Arrays.hashCode((byte[])localObject);
        }
        else if ((localObject instanceof char[]))
        {
          i = j + Arrays.hashCode((char[])localObject);
        }
        else if ((localObject instanceof short[]))
        {
          i = j + Arrays.hashCode((short[])localObject);
        }
        else if ((localObject instanceof int[]))
        {
          i = j + Arrays.hashCode((int[])localObject);
        }
        else if ((localObject instanceof long[]))
        {
          i = j + Arrays.hashCode((long[])localObject);
        }
        else if ((localObject instanceof float[]))
        {
          i = j + Arrays.hashCode((float[])localObject);
        }
        else if ((localObject instanceof double[]))
        {
          i = j + Arrays.hashCode((double[])localObject);
        }
        else if ((localObject instanceof Object[]))
        {
          i = j + Arrays.hashCode((Object[])localObject);
        }
        else
        {
          if (localObject.getClass().isArray())
          {
            int m = 0;
            for (;;)
            {
              i = j;
              if (m >= Array.getLength(localObject)) {
                break;
              }
              j += hash(new Object[] { Array.get(localObject, m) });
              m += 1;
            }
          }
          i = j + localObject.hashCode();
        }
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.a.a.b.e
 * JD-Core Version:    0.7.0.1
 */