package oicq.wlogin_sdk.tools;

import java.util.Random;

public final class d
{
  public static byte[] a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramInt);
    paramArrayOfByte1 = new a();
    int i = arrayOfByte.length;
    paramArrayOfByte1.plain = new byte[8];
    paramArrayOfByte1.prePlain = new byte[8];
    paramArrayOfByte1.pos = 1;
    paramArrayOfByte1.padding = 0;
    paramArrayOfByte1.preCrypt = 0;
    paramArrayOfByte1.crypt = 0;
    paramArrayOfByte1.key = paramArrayOfByte2;
    paramArrayOfByte1.header = true;
    paramArrayOfByte1.pos = ((i + 10) % 8);
    if (paramArrayOfByte1.pos != 0) {
      paramArrayOfByte1.pos = (8 - paramArrayOfByte1.pos);
    }
    paramArrayOfByte1.out = new byte[paramArrayOfByte1.pos + i + 10];
    paramArrayOfByte1.plain[0] = ((byte)(paramArrayOfByte1.random.nextInt() & 0xF8 | paramArrayOfByte1.pos));
    paramInt = 1;
    if (paramInt > paramArrayOfByte1.pos)
    {
      paramArrayOfByte1.pos += 1;
      paramInt = 0;
      label161:
      if (paramInt < 8) {
        break label230;
      }
      paramArrayOfByte1.padding = 1;
    }
    for (;;)
    {
      if (paramArrayOfByte1.padding > 2)
      {
        paramInt = 0;
        if (i > 0) {
          break label311;
        }
        paramArrayOfByte1.padding = 1;
        label191:
        if (paramArrayOfByte1.padding <= 7) {
          break label375;
        }
        return paramArrayOfByte1.out;
        paramArrayOfByte1.plain[paramInt] = ((byte)(paramArrayOfByte1.random.nextInt() & 0xFF));
        paramInt += 1;
        break;
        label230:
        paramArrayOfByte1.prePlain[paramInt] = 0;
        paramInt += 1;
        break label161;
      }
      if (paramArrayOfByte1.pos < 8)
      {
        paramArrayOfByte2 = paramArrayOfByte1.plain;
        paramInt = paramArrayOfByte1.pos;
        paramArrayOfByte1.pos = (paramInt + 1);
        paramArrayOfByte2[paramInt] = ((byte)(paramArrayOfByte1.random.nextInt() & 0xFF));
        paramArrayOfByte1.padding += 1;
      }
      if (paramArrayOfByte1.pos == 8) {
        paramArrayOfByte1.encrypt8Bytes();
      }
    }
    label311:
    if (paramArrayOfByte1.pos < 8)
    {
      paramArrayOfByte2 = paramArrayOfByte1.plain;
      int k = paramArrayOfByte1.pos;
      paramArrayOfByte1.pos = (k + 1);
      int j = paramInt + 1;
      paramArrayOfByte2[k] = arrayOfByte[paramInt];
      i -= 1;
      paramInt = j;
    }
    for (;;)
    {
      if (paramArrayOfByte1.pos == 8) {
        paramArrayOfByte1.encrypt8Bytes();
      }
      break;
      label375:
      if (paramArrayOfByte1.pos < 8)
      {
        paramArrayOfByte2 = paramArrayOfByte1.plain;
        paramInt = paramArrayOfByte1.pos;
        paramArrayOfByte1.pos = (paramInt + 1);
        paramArrayOfByte2[paramInt] = 0;
        paramArrayOfByte1.padding += 1;
      }
      if (paramArrayOfByte1.pos != 8) {
        break label191;
      }
      paramArrayOfByte1.encrypt8Bytes();
      break label191;
    }
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte1, paramInt1, arrayOfByte, 0, paramInt2);
    a locala = new a();
    int i = arrayOfByte.length;
    locala.preCrypt = 0;
    locala.crypt = 0;
    locala.key = paramArrayOfByte2;
    paramArrayOfByte1 = new byte[8];
    if ((i % 8 != 0) || (i < 16)) {
      return null;
    }
    locala.prePlain = locala.R(arrayOfByte);
    locala.pos = (locala.prePlain[0] & 0x7);
    paramInt2 = i - locala.pos - 10;
    if (paramInt2 < 0) {
      return null;
    }
    paramInt1 = 0;
    if (paramInt1 >= 8)
    {
      locala.out = new byte[paramInt2];
      locala.preCrypt = 0;
      locala.crypt = 8;
      locala.contextStart = 8;
      locala.pos += 1;
      locala.padding = 1;
    }
    for (;;)
    {
      if (locala.padding > 2)
      {
        paramInt1 = 0;
        if (paramInt2 != 0) {
          break label273;
        }
        locala.padding = 1;
        label188:
        if (locala.padding < 8) {
          break label375;
        }
        return locala.out;
        paramArrayOfByte1[paramInt1] = 0;
        paramInt1 += 1;
        break;
      }
      if (locala.pos < 8)
      {
        locala.pos += 1;
        locala.padding += 1;
      }
      if (locala.pos == 8)
      {
        if (!locala.D(arrayOfByte, i))
        {
          return null;
          label273:
          if (locala.pos < 8)
          {
            locala.out[paramInt1] = ((byte)(paramArrayOfByte1[(locala.preCrypt + 0 + locala.pos)] ^ locala.prePlain[locala.pos]));
            paramInt1 += 1;
            locala.pos += 1;
            paramInt2 -= 1;
          }
          for (;;)
          {
            if (locala.pos == 8)
            {
              locala.preCrypt = (locala.crypt - 8);
              if (!locala.D(arrayOfByte, i))
              {
                return null;
                label375:
                if (locala.pos < 8)
                {
                  if ((paramArrayOfByte1[(locala.preCrypt + 0 + locala.pos)] ^ locala.prePlain[locala.pos]) != 0) {
                    return null;
                  }
                  locala.pos += 1;
                }
                if (locala.pos == 8)
                {
                  locala.preCrypt = locala.crypt;
                  if (!locala.D(arrayOfByte, i)) {
                    return null;
                  }
                  paramArrayOfByte1 = arrayOfByte;
                }
                locala.padding += 1;
                break label188;
              }
              paramArrayOfByte1 = arrayOfByte;
              break;
            }
            break;
          }
        }
        paramArrayOfByte1 = arrayOfByte;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.d
 * JD-Core Version:    0.7.0.1
 */