package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;

class Mp3DecodeBase
{
  static boolean hasId3v2(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = true;
    if ((paramArrayOfByte == null) || (paramInt < 3)) {
      bool = false;
    }
    while ((paramArrayOfByte[0] == 73) && (paramArrayOfByte[1] == 68) && (paramArrayOfByte[2] == 51)) {
      return bool;
    }
    return false;
  }
  
  static boolean isVBRIVBRHeader(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = true;
    if ((paramArrayOfByte == null) || (paramInt < 4)) {
      bool = false;
    }
    while ((paramArrayOfByte[0] == 86) && (paramArrayOfByte[1] == 66) && (paramArrayOfByte[2] == 82) && (paramArrayOfByte[3] == 73)) {
      return bool;
    }
    return false;
  }
  
  static boolean isXingVBRheader(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramArrayOfByte == null) || (paramInt < 4)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if ((paramArrayOfByte[0] != 88) || (paramArrayOfByte[1] != 105) || (paramArrayOfByte[2] != 110)) {
          break;
        }
        bool1 = bool2;
      } while (paramArrayOfByte[3] == 103);
      if ((paramArrayOfByte[0] != 73) || (paramArrayOfByte[1] != 110) || (paramArrayOfByte[2] != 102)) {
        break;
      }
      bool1 = bool2;
    } while (paramArrayOfByte[3] == 111);
    return false;
  }
  
  static int readByte(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(114245);
    paramInt = readByte(paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(114245);
    return paramInt;
  }
  
  static int readByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 <= 0) || (paramArrayOfByte.length < paramInt1 + paramInt2)) {
      return -1;
    }
    return paramArrayOfByte[paramInt1] & 0xFF;
  }
  
  static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(114241);
    paramInt = readInt(paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(114241);
    return paramInt;
  }
  
  static int readInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 < 4) || (paramArrayOfByte.length < paramInt1 + paramInt2)) {
      return -1;
    }
    return (paramArrayOfByte[paramInt1] & 0xFF) << 24 | (paramArrayOfByte[(paramInt1 + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt1 + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt1 + 3)] & 0xFF;
  }
  
  static long readLong(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(114242);
    long l = readLong(paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(114242);
    return l;
  }
  
  static long readLong(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 < 4) || (paramArrayOfByte.length < paramInt1 + paramInt2)) {
      return -1L;
    }
    return (paramArrayOfByte[paramInt1] & 0xFF) << 24 | (paramArrayOfByte[(paramInt1 + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt1 + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt1 + 3)] & 0xFF;
  }
  
  static int readShort(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(114244);
    paramInt = readShort(paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(114244);
    return paramInt;
  }
  
  static int readShort(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 < 2) || (paramArrayOfByte.length < paramInt1 + paramInt2)) {
      return -1;
    }
    return (paramArrayOfByte[paramInt1] & 0xFF) << 8 | paramArrayOfByte[(paramInt1 + 1)] & 0xFF;
  }
  
  static int readUnsignedInt24(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(114243);
    paramInt = readUnsignedInt24(paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(114243);
    return paramInt;
  }
  
  static int readUnsignedInt24(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 < 3) || (paramArrayOfByte.length < paramInt1 + paramInt2)) {
      return -1;
    }
    return (paramArrayOfByte[paramInt1] & 0xFF) << 16 | (paramArrayOfByte[(paramInt1 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt1 + 2)] & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3DecodeBase
 * JD-Core Version:    0.7.0.1
 */