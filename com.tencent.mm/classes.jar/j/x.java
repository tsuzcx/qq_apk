package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "digest", "algorithm", "digest$okio", "equals", "", "other", "", "getSize", "", "getSize$okio", "hashCode", "hex", "hmac", "key", "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", "pos", "internalGet$okio", "lastIndexOf", "rangeEquals", "offset", "otherOffset", "byteCount", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio"}, k=1, mv={1, 4, 1})
public final class x
  extends i
{
  public final transient byte[][] ajTE;
  public final transient int[] ajTF;
  
  public x(byte[][] paramArrayOfByte, int[] paramArrayOfInt)
  {
    super(i.ajTe.data);
    AppMethodBeat.i(186299);
    this.ajTE = paramArrayOfByte;
    this.ajTF = paramArrayOfInt;
    AppMethodBeat.o(186299);
  }
  
  private final i kJd()
  {
    AppMethodBeat.i(186295);
    i locali = new i(toByteArray());
    AppMethodBeat.o(186295);
    return locali;
  }
  
  public final void a(f paramf, int paramInt)
  {
    AppMethodBeat.i(186323);
    s.u(paramf, "buffer");
    int m = paramInt + 0;
    int i = j.a.c.a(this, 0);
    int j = 0;
    if (j < m)
    {
      int k;
      label39:
      int i1;
      v localv1;
      if (i == 0)
      {
        k = 0;
        i1 = this.ajTF[i];
        int n = this.ajTF[(((Object[])this.ajTE).length + i)];
        i1 = Math.min(m, i1 - k + k) - j;
        k = n + (j - k);
        localv1 = new v(this.ajTE[i], k, k + i1, true);
        if (paramf.ajTb != null) {
          break label175;
        }
        localv1.ajTy = localv1;
        localv1.ajTx = localv1.ajTy;
        paramf.ajTb = localv1.ajTx;
      }
      for (;;)
      {
        j += i1;
        i += 1;
        break;
        k = this.ajTF[(i - 1)];
        break label39;
        label175:
        v localv2 = paramf.ajTb;
        s.checkNotNull(localv2);
        localv2 = localv2.ajTy;
        s.checkNotNull(localv2);
        localv2.a(localv1);
      }
    }
    paramf.size += paramInt;
    AppMethodBeat.o(186323);
  }
  
  public final boolean a(i parami, int paramInt)
  {
    AppMethodBeat.i(186329);
    s.u(parami, "other");
    if (kIN() - paramInt < 0)
    {
      AppMethodBeat.o(186329);
      return false;
    }
    int m = paramInt + 0;
    paramInt = j.a.c.a(this, 0);
    int i = 0;
    int j = 0;
    while (i < m)
    {
      if (paramInt == 0) {}
      int i1;
      for (int k = 0;; k = this.ajTF[(paramInt - 1)])
      {
        i1 = this.ajTF[paramInt];
        int n = this.ajTF[(((Object[])this.ajTE).length + paramInt)];
        i1 = Math.min(m, i1 - k + k) - i;
        if (parami.e(j, this.ajTE[paramInt], n + (i - k), i1)) {
          break;
        }
        AppMethodBeat.o(186329);
        return false;
      }
      j += i1;
      i += i1;
      paramInt += 1;
    }
    AppMethodBeat.o(186329);
    return true;
  }
  
  public final byte aNp(int paramInt)
  {
    AppMethodBeat.i(186312);
    c.C(this.ajTF[(((Object[])this.ajTE).length - 1)], paramInt, 1L);
    int j = j.a.c.a(this, paramInt);
    if (j == 0) {}
    for (int i = 0;; i = this.ajTF[(j - 1)])
    {
      int k = this.ajTF[(((Object[])this.ajTE).length + j)];
      byte b = this.ajTE[j][(k + (paramInt - i))];
      AppMethodBeat.o(186312);
      return b;
    }
  }
  
  public final i bKS(String paramString)
  {
    AppMethodBeat.i(186308);
    s.u(paramString, "algorithm");
    paramString = MessageDigest.getInstance(paramString);
    int m = ((Object[])this.ajTE).length;
    int i = 0;
    int j = 0;
    while (j < m)
    {
      int n = this.ajTF[(m + j)];
      int k = this.ajTF[j];
      paramString.update(this.ajTE[j], n, k - i);
      j += 1;
      i = k;
    }
    paramString = paramString.digest();
    s.s(paramString, "digestBytes");
    paramString = new i(paramString);
    AppMethodBeat.o(186308);
    return paramString;
  }
  
  public final boolean e(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(186334);
    s.u(paramArrayOfByte, "other");
    if ((paramInt1 < 0) || (paramInt1 > kIN() - paramInt3) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt3))
    {
      AppMethodBeat.o(186334);
      return false;
    }
    int j = paramInt1 + paramInt3;
    int i = j.a.c.a(this, paramInt1);
    paramInt3 = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt2 < j)
    {
      if (paramInt1 == 0) {}
      int m;
      for (i = 0;; i = this.ajTF[(paramInt1 - 1)])
      {
        m = this.ajTF[paramInt1];
        int k = this.ajTF[(((Object[])this.ajTE).length + paramInt1)];
        m = Math.min(j, m - i + i) - paramInt2;
        if (c.a(this.ajTE[paramInt1], k + (paramInt2 - i), paramArrayOfByte, paramInt3, m)) {
          break;
        }
        AppMethodBeat.o(186334);
        return false;
      }
      paramInt3 += m;
      paramInt2 += m;
      paramInt1 += 1;
    }
    AppMethodBeat.o(186334);
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186341);
    if (paramObject == this)
    {
      AppMethodBeat.o(186341);
      return true;
    }
    if ((paramObject instanceof i))
    {
      if ((((i)paramObject).kIN() == kIN()) && (a((i)paramObject, kIN())))
      {
        AppMethodBeat.o(186341);
        return true;
      }
      AppMethodBeat.o(186341);
      return false;
    }
    AppMethodBeat.o(186341);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186344);
    int i = kII();
    if (i != 0)
    {
      AppMethodBeat.o(186344);
      return i;
    }
    int i2 = ((Object[])this.ajTE).length;
    int m = 0;
    int k = 0;
    i = 1;
    while (k < i2)
    {
      int n = this.ajTF[(i2 + k)];
      int i1 = this.ajTF[k];
      byte[] arrayOfByte = this.ajTE[k];
      int j = n;
      while (j < n + (i1 - m))
      {
        i = arrayOfByte[j] + i * 31;
        j += 1;
      }
      m = i1;
      k += 1;
    }
    aNo(i);
    AppMethodBeat.o(186344);
    return i;
  }
  
  public final String kIK()
  {
    AppMethodBeat.i(186300);
    String str = kJd().kIK();
    AppMethodBeat.o(186300);
    return str;
  }
  
  public final String kIL()
  {
    AppMethodBeat.i(186303);
    String str = kJd().kIL();
    AppMethodBeat.o(186303);
    return str;
  }
  
  public final i kIM()
  {
    AppMethodBeat.i(186305);
    i locali = kJd().kIM();
    AppMethodBeat.o(186305);
    return locali;
  }
  
  public final int kIN()
  {
    return this.ajTF[(((Object[])this.ajTE).length - 1)];
  }
  
  public final byte[] kIO()
  {
    AppMethodBeat.i(186336);
    byte[] arrayOfByte = toByteArray();
    AppMethodBeat.o(186336);
    return arrayOfByte;
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(186319);
    byte[] arrayOfByte1 = new byte[kIN()];
    int n = ((Object[])this.ajTE).length;
    int k = 0;
    int i = 0;
    int j = 0;
    while (i < n)
    {
      int i1 = this.ajTF[(n + i)];
      int m = this.ajTF[i];
      byte[] arrayOfByte2 = this.ajTE[i];
      k = m - k;
      k.a(arrayOfByte2, arrayOfByte1, j, i1, i1 + k);
      j += k;
      i += 1;
      k = m;
    }
    AppMethodBeat.o(186319);
    return arrayOfByte1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186346);
    String str = kJd().toString();
    AppMethodBeat.o(186346);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.x
 * JD-Core Version:    0.7.0.1
 */