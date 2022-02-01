package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"BASE64", "", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"}, k=2, mv={1, 4, 1})
public final class a
{
  private static final byte[] ajSP;
  private static final byte[] ajSQ;
  
  static
  {
    AppMethodBeat.i(186333);
    i.a locala = i.ajTf;
    ajSP = i.a.bKT("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").data;
    locala = i.ajTf;
    ajSQ = i.a.bKT("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").data;
    AppMethodBeat.o(186333);
  }
  
  public static final byte[] bKO(String paramString)
  {
    AppMethodBeat.i(186326);
    s.u(paramString, "$this$decodeBase64ToArray");
    int m = paramString.length();
    int i;
    while (m > 0)
    {
      i = paramString.charAt(m - 1);
      if ((i != 61) && (i != 10) && (i != 13) && (i != 32) && (i != 9)) {
        break;
      }
      m -= 1;
    }
    byte[] arrayOfByte = new byte[(int)(m * 6L / 8L)];
    int n = 0;
    int k = 0;
    int i1 = 0;
    int j = 0;
    if (n < m)
    {
      i = paramString.charAt(n);
      if (65 > i)
      {
        label116:
        if (97 <= i) {
          break label230;
        }
        label122:
        if (48 <= i) {
          break label244;
        }
        label128:
        if ((i != 43) && (i != 45)) {
          break label257;
        }
        i = 62;
        label143:
        k = i | k << 6;
        i1 += 1;
        i = j;
        if (i1 % 4 == 0)
        {
          i = j + 1;
          arrayOfByte[j] = ((byte)(k >> 16));
          j = i + 1;
          arrayOfByte[i] = ((byte)(k >> 8));
          i = j + 1;
          arrayOfByte[j] = ((byte)k);
        }
        j = i;
      }
      for (i = k;; i = k)
      {
        n += 1;
        k = i;
        break;
        if (90 < i) {
          break label116;
        }
        i -= 65;
        break label143;
        label230:
        if (122 < i) {
          break label122;
        }
        i -= 71;
        break label143;
        label244:
        if (57 < i) {
          break label128;
        }
        i += 4;
        break label143;
        label257:
        if ((i == 47) || (i == 95))
        {
          i = 63;
          break label143;
        }
        if ((i != 10) && (i != 13) && (i != 32) && (i != 9)) {
          break label304;
        }
      }
      label304:
      AppMethodBeat.o(186326);
      return null;
    }
    switch (i1 % 4)
    {
    }
    while (j == arrayOfByte.length)
    {
      AppMethodBeat.o(186326);
      return arrayOfByte;
      AppMethodBeat.o(186326);
      return null;
      arrayOfByte[j] = ((byte)(k << 12 >> 16));
      j += 1;
      continue;
      i = k << 6;
      k = j + 1;
      arrayOfByte[j] = ((byte)(i >> 16));
      j = k + 1;
      arrayOfByte[k] = ((byte)(i >> 8));
    }
    paramString = Arrays.copyOf(arrayOfByte, j);
    s.s(paramString, "java.util.Arrays.copyOf(this, newSize)");
    AppMethodBeat.o(186326);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.a
 * JD-Core Version:    0.7.0.1
 */