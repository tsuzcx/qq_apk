package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.g;
import j.i;
import java.io.ByteArrayOutputStream;

final class k
{
  private static final int[] ajRX;
  private static final byte[] ajRY;
  private static final k ajRZ;
  private final a ajSa;
  
  static
  {
    AppMethodBeat.i(187074);
    ajRX = new int[] { 8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846 };
    ajRY = new byte[] { 13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26 };
    ajRZ = new k();
    AppMethodBeat.o(187074);
  }
  
  private k()
  {
    AppMethodBeat.i(186877);
    this.ajSa = new a();
    kId();
    AppMethodBeat.o(186877);
  }
  
  static void a(i parami, g paramg)
  {
    AppMethodBeat.i(186884);
    long l = 0L;
    int j = 0;
    int i = 0;
    while (j < parami.kIN())
    {
      int m = parami.aNp(j) & 0xFF;
      int k = ajRX[m];
      m = ajRY[m];
      l = l << m | k;
      i = m + i;
      while (i >= 8)
      {
        i -= 8;
        paramg.aNh((int)(l >> i));
      }
      j += 1;
    }
    if (i > 0) {
      paramg.aNh((int)(l << 8 - i | 255 >>> i));
    }
    AppMethodBeat.o(186884);
  }
  
  static int c(i parami)
  {
    AppMethodBeat.i(186889);
    long l = 0L;
    int i = 0;
    while (i < parami.kIN())
    {
      int j = parami.aNp(i);
      l += ajRY[(j & 0xFF)];
      i += 1;
    }
    i = (int)(7L + l >> 3);
    AppMethodBeat.o(186889);
    return i;
  }
  
  public static k kIc()
  {
    return ajRZ;
  }
  
  private void kId()
  {
    AppMethodBeat.i(186900);
    int i = 0;
    while (i < ajRY.length)
    {
      int k = ajRX[i];
      int j = ajRY[i];
      a locala = new a(i, j);
      for (Object localObject = this.ajSa; j > 8; localObject = localObject.ajSb[m])
      {
        j = (byte)(j - 8);
        m = k >>> j & 0xFF;
        if (((a)localObject).ajSb == null)
        {
          localObject = new IllegalStateException("invalid dictionary: prefix not unique");
          AppMethodBeat.o(186900);
          throw ((Throwable)localObject);
        }
        if (localObject.ajSb[m] == null) {
          ((a)localObject).ajSb[m] = new a();
        }
      }
      int m = 8 - j;
      k = k << m & 0xFF;
      j = k;
      while (j < k + (1 << m))
      {
        ((a)localObject).ajSb[j] = locala;
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(186900);
  }
  
  final byte[] decode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187100);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a locala1 = this.ajSa;
    int j = 0;
    int i = 0;
    int k = 0;
    int m;
    a locala2;
    for (;;)
    {
      m = i;
      locala2 = locala1;
      if (j >= paramArrayOfByte.length) {
        break;
      }
      k = k << 8 | paramArrayOfByte[j] & 0xFF;
      i += 8;
      while (i >= 8)
      {
        locala1 = locala1.ajSb[(k >>> i - 8 & 0xFF)];
        if (locala1.ajSb == null)
        {
          localByteArrayOutputStream.write(locala1.symbol);
          i -= locala1.ajSc;
          locala1 = this.ajSa;
        }
        else
        {
          i -= 8;
        }
      }
      j += 1;
    }
    while (m > 0)
    {
      paramArrayOfByte = locala2.ajSb[(k << 8 - m & 0xFF)];
      if ((paramArrayOfByte.ajSb != null) || (paramArrayOfByte.ajSc > m)) {
        break;
      }
      localByteArrayOutputStream.write(paramArrayOfByte.symbol);
      m -= paramArrayOfByte.ajSc;
      locala2 = this.ajSa;
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(187100);
    return paramArrayOfByte;
  }
  
  static final class a
  {
    final a[] ajSb;
    final int ajSc;
    final int symbol;
    
    a()
    {
      AppMethodBeat.i(186996);
      this.ajSb = new a[256];
      this.symbol = 0;
      this.ajSc = 0;
      AppMethodBeat.o(186996);
    }
    
    a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(187003);
      this.ajSb = null;
      this.symbol = paramInt1;
      paramInt2 &= 0x7;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 8;
      }
      this.ajSc = paramInt1;
      AppMethodBeat.o(187003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.k
 * JD-Core Version:    0.7.0.1
 */