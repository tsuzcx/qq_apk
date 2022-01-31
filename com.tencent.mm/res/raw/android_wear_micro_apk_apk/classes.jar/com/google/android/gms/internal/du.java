package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class du
{
  protected static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
  public static final Object RA = new Object();
  protected static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public static void a(dq paramdq1, dq paramdq2)
  {
    if (paramdq1.Rr != null) {
      paramdq2.Rr = ((ds)paramdq1.Rr.clone());
    }
  }
  
  public static boolean equals(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat1.length == 0)) {
      return (paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length == 0);
    }
    return Arrays.equals(paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong1.length == 0)) {
      return (paramArrayOfLong2 == null) || (paramArrayOfLong2.length == 0);
    }
    return Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    boolean bool2 = false;
    int k;
    if (paramArrayOfObject1 == null)
    {
      k = 0;
      if (paramArrayOfObject2 != null) {
        break label47;
      }
    }
    int j;
    int i;
    label47:
    for (int m = 0;; m = paramArrayOfObject2.length)
    {
      j = 0;
      i = 0;
      while ((i < k) && (paramArrayOfObject1[i] == null)) {
        i += 1;
      }
      k = paramArrayOfObject1.length;
      break;
    }
    for (;;)
    {
      if ((j < m) && (paramArrayOfObject2[j] == null))
      {
        j += 1;
      }
      else
      {
        int n;
        int i1;
        label91:
        boolean bool1;
        if (i >= k)
        {
          n = 1;
          if (j < m) {
            break label113;
          }
          i1 = 1;
          if ((n == 0) || (i1 == 0)) {
            break label119;
          }
          bool1 = true;
        }
        label113:
        label119:
        do
        {
          do
          {
            return bool1;
            n = 0;
            break;
            i1 = 0;
            break label91;
            bool1 = bool2;
          } while (n != i1);
          bool1 = bool2;
        } while (!paramArrayOfObject1[i].equals(paramArrayOfObject2[j]));
        j += 1;
        i += 1;
        break;
      }
    }
  }
  
  public static int hashCode(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0)) {
      return 0;
    }
    return Arrays.hashCode(paramArrayOfFloat);
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {
      return 0;
    }
    return Arrays.hashCode(paramArrayOfLong);
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    int j;
    int k;
    int i;
    if (paramArrayOfObject == null)
    {
      j = 0;
      k = 0;
      i = 0;
      label10:
      if (k >= j) {
        break label49;
      }
      Object localObject = paramArrayOfObject[k];
      if (localObject == null) {
        break label51;
      }
      i = localObject.hashCode() + i * 31;
    }
    label49:
    label51:
    for (;;)
    {
      k += 1;
      break label10;
      j = paramArrayOfObject.length;
      break;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.du
 * JD-Core Version:    0.7.0.1
 */