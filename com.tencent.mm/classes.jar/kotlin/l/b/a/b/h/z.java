package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class z
{
  static int B(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65) || (paramInt3 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1 ^ paramInt3 << 16;
  }
  
  public static int Y(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59636);
    while ((paramInt1 < paramInt2) && (paramArrayOfByte[paramInt1] >= 0)) {
      paramInt1 += 1;
    }
    if (paramInt1 >= paramInt2)
    {
      AppMethodBeat.o(59636);
      return 0;
    }
    paramInt1 = Z(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(59636);
    return paramInt1;
  }
  
  private static int Z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59637);
    for (;;)
    {
      if (paramInt1 >= paramInt2)
      {
        AppMethodBeat.o(59637);
        return 0;
      }
      int i = paramInt1 + 1;
      paramInt1 = paramArrayOfByte[paramInt1];
      if (paramInt1 < 0)
      {
        if (paramInt1 < -32)
        {
          if (i >= paramInt2)
          {
            AppMethodBeat.o(59637);
            return paramInt1;
          }
          if (paramInt1 >= -62)
          {
            paramInt1 = i + 1;
            if (paramArrayOfByte[i] <= -65) {}
          }
          else
          {
            AppMethodBeat.o(59637);
            return -1;
          }
        }
        else
        {
          int j;
          if (paramInt1 < -16)
          {
            if (i >= paramInt2 - 1)
            {
              paramInt1 = aa(paramArrayOfByte, i, paramInt2);
              AppMethodBeat.o(59637);
              return paramInt1;
            }
            j = i + 1;
            i = paramArrayOfByte[i];
            if ((i <= -65) && ((paramInt1 != -32) || (i >= -96)) && ((paramInt1 != -19) || (i < -96)))
            {
              paramInt1 = j + 1;
              if (paramArrayOfByte[j] <= -65) {}
            }
            else
            {
              AppMethodBeat.o(59637);
              return -1;
            }
          }
          else
          {
            if (i >= paramInt2 - 2)
            {
              paramInt1 = aa(paramArrayOfByte, i, paramInt2);
              AppMethodBeat.o(59637);
              return paramInt1;
            }
            j = i + 1;
            i = paramArrayOfByte[i];
            if ((i <= -65) && ((paramInt1 << 28) + (i + 112) >> 30 == 0))
            {
              i = j + 1;
              if (paramArrayOfByte[j] <= -65)
              {
                paramInt1 = i + 1;
                if (paramArrayOfByte[i] <= -65) {
                  break label243;
                }
              }
            }
            AppMethodBeat.o(59637);
            return -1;
          }
        }
      }
      else {
        label243:
        paramInt1 = i;
      }
    }
  }
  
  private static int aa(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59638);
    int i = paramArrayOfByte[(paramInt1 - 1)];
    switch (paramInt2 - paramInt1)
    {
    default: 
      paramArrayOfByte = new AssertionError();
      AppMethodBeat.o(59638);
      throw paramArrayOfByte;
    case 0: 
      paramInt1 = hM(i);
      AppMethodBeat.o(59638);
      return paramInt1;
    case 1: 
      paramInt1 = bR(i, paramArrayOfByte[paramInt1]);
      AppMethodBeat.o(59638);
      return paramInt1;
    }
    paramInt1 = B(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
    AppMethodBeat.o(59638);
    return paramInt1;
  }
  
  static int bR(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1;
  }
  
  private static int hM(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  public static boolean s(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59635);
    if (Y(paramArrayOfByte, paramInt1, paramInt2) == 0)
    {
      AppMethodBeat.o(59635);
      return true;
    }
    AppMethodBeat.o(59635);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.h.z
 * JD-Core Version:    0.7.0.1
 */