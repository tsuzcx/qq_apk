package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"arrayRangeEquals", "", "a", "", "aOffset", "", "b", "bOffset", "byteCount", "checkOffsetAndCount", "", "size", "", "offset", "minOf", "and", "", "other", "leftRotate", "bitCount", "reverseBytes", "", "rightRotate", "shl", "shr", "toHexString", "", "xor", "okio"}, k=2, mv={1, 4, 1})
public final class c
{
  public static final void C(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(186345);
    if (((paramLong2 | paramLong3) < 0L) || (paramLong2 > paramLong1) || (paramLong1 - paramLong2 < paramLong3))
    {
      Throwable localThrowable = (Throwable)new ArrayIndexOutOfBoundsException("size=" + paramLong1 + " offset=" + paramLong2 + " byteCount=" + paramLong3);
      AppMethodBeat.o(186345);
      throw localThrowable;
    }
    AppMethodBeat.o(186345);
  }
  
  public static final String Lx(int paramInt)
  {
    AppMethodBeat.i(186498);
    if (paramInt == 0)
    {
      AppMethodBeat.o(186498);
      return "0";
    }
    Object localObject = new char[8];
    localObject[0] = j.a.b.kJf()[(paramInt >> 28 & 0xF)];
    localObject[1] = j.a.b.kJf()[(paramInt >> 24 & 0xF)];
    localObject[2] = j.a.b.kJf()[(paramInt >> 20 & 0xF)];
    localObject[3] = j.a.b.kJf()[(paramInt >> 16 & 0xF)];
    localObject[4] = j.a.b.kJf()[(paramInt >> 12 & 0xF)];
    localObject[5] = j.a.b.kJf()[(paramInt >> 8 & 0xF)];
    localObject[6] = j.a.b.kJf()[(paramInt >> 4 & 0xF)];
    localObject[7] = j.a.b.kJf()[(paramInt & 0xF)];
    paramInt = 0;
    while ((paramInt < 8) && (localObject[paramInt] == '0')) {
      paramInt += 1;
    }
    localObject = new String((char[])localObject, paramInt, 8 - paramInt);
    AppMethodBeat.o(186498);
    return localObject;
  }
  
  public static final boolean a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(186347);
    s.u(paramArrayOfByte1, "a");
    s.u(paramArrayOfByte2, "b");
    int i = 0;
    while (i < paramInt3)
    {
      if (paramArrayOfByte1[(i + paramInt1)] != paramArrayOfByte2[(i + paramInt2)])
      {
        AppMethodBeat.o(186347);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(186347);
    return true;
  }
  
  public static final String s(byte paramByte)
  {
    AppMethodBeat.i(186492);
    String str = new String(new char[] { j.a.b.kJf()[(paramByte >> 4 & 0xF)], j.a.b.kJf()[(paramByte & 0xF)] });
    AppMethodBeat.o(186492);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.c
 * JD-Core Version:    0.7.0.1
 */