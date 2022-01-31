package com.tencent.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 1;
    int i = paramInt1;
    if (paramBoolean)
    {
      i = paramInt1 + (paramInt2 - 1);
      j = -1;
    }
    paramInt1 = 0;
    while (paramInt2 > 0)
    {
      paramInt1 = paramInt1 << 8 | paramArrayOfByte[i] & 0xFF;
      i += j;
      paramInt2 -= 1;
    }
    return paramInt1;
  }
  
  public static int cv(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(86578);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(86578);
      return 0;
    }
    int i = 0;
    int m;
    int k;
    do
    {
      do
      {
        j = i;
        if (i + 3 >= paramArrayOfByte.length) {
          break;
        }
        j = i + 1;
        if ((paramArrayOfByte[i] & 0xFF) != 255) {
          break label494;
        }
        m = paramArrayOfByte[j] & 0xFF;
        if (m == 255) {
          break label489;
        }
        k = j + 1;
        i = k;
      } while (m == 216);
      i = k;
    } while (m == 1);
    int j = k;
    if (m != 217)
    {
      j = k;
      if (m != 218)
      {
        i = c(paramArrayOfByte, k, 2, false);
        if ((i < 2) || (k + i > paramArrayOfByte.length))
        {
          i.n("CameraExif", "Invalid length");
          AppMethodBeat.o(86578);
          return 0;
        }
        if ((m == 225) && (i >= 8) && (c(paramArrayOfByte, k + 2, 4, false) == 1165519206) && (c(paramArrayOfByte, k + 6, 2, false) == 0))
        {
          j = k + 8;
          i -= 8;
        }
      }
    }
    for (;;)
    {
      if (i > 8)
      {
        k = c(paramArrayOfByte, j, 4, false);
        if ((k != 1229531648) && (k != 1296891946))
        {
          i.n("CameraExif", "Invalid byte order");
          AppMethodBeat.o(86578);
          return 0;
          i = k + i;
          break;
        }
        if (k == 1229531648) {}
        int n;
        for (boolean bool = true;; bool = false)
        {
          n = c(paramArrayOfByte, j + 4, 4, bool) + 2;
          if ((n >= 10) && (n <= i)) {
            break;
          }
          i.n("CameraExif", "Invalid offset");
          AppMethodBeat.o(86578);
          return 0;
        }
        k = j + n;
        m = c(paramArrayOfByte, k - 2, 2, bool);
        j = i - n;
        i = m;
        while ((i > 0) && (j >= 12))
        {
          if (c(paramArrayOfByte, k, 2, bool) == 274)
          {
            switch (c(paramArrayOfByte, k + 8, 2, bool))
            {
            case 2: 
            case 4: 
            case 5: 
            case 7: 
            default: 
              i.k("CameraExif", "Unsupported orientation");
              AppMethodBeat.o(86578);
              return 0;
            case 1: 
              AppMethodBeat.o(86578);
              return 0;
            case 3: 
              AppMethodBeat.o(86578);
              return 180;
            case 6: 
              AppMethodBeat.o(86578);
              return 90;
            }
            AppMethodBeat.o(86578);
            return 270;
          }
          k += 12;
          j -= 12;
          i -= 1;
        }
      }
      i.k("CameraExif", "Orientation not found");
      AppMethodBeat.o(86578);
      return 0;
      i = 0;
      continue;
      label489:
      i = j;
      break;
      label494:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.util.d
 * JD-Core Version:    0.7.0.1
 */