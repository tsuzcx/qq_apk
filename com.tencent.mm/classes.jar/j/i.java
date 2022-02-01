package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "other", "digest", "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "offset", "otherOffset", "byteCount", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, k=1, mv={1, 4, 1})
public class i
  implements Serializable, Comparable<i>
{
  public static final i ajTe;
  public static final a ajTf;
  transient String ajTd;
  private transient int cHb;
  public final byte[] data;
  
  static
  {
    AppMethodBeat.i(186370);
    ajTf = new a((byte)0);
    ajTe = new i(new byte[0]);
    AppMethodBeat.o(186370);
  }
  
  public i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186368);
    this.data = paramArrayOfByte;
    AppMethodBeat.o(186368);
  }
  
  public static final i bKT(String paramString)
  {
    AppMethodBeat.i(186375);
    paramString = a.bKT(paramString);
    AppMethodBeat.o(186375);
    return paramString;
  }
  
  public static final i bKU(String paramString)
  {
    AppMethodBeat.i(186378);
    s.u(paramString, "$this$decodeBase64");
    paramString = a.bKO(paramString);
    if (paramString != null)
    {
      paramString = new i(paramString);
      AppMethodBeat.o(186378);
      return paramString;
    }
    AppMethodBeat.o(186378);
    return null;
  }
  
  public static final i bKV(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(186381);
    s.u(paramString, "$this$decodeHex");
    if (paramString.length() % 2 == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException("Unexpected hex string: ".concat(String.valueOf(paramString)).toString());
      AppMethodBeat.o(186381);
      throw paramString;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int k = arrayOfByte.length;
    i = j;
    while (i < k)
    {
      arrayOfByte[i] = ((byte)((j.a.b.O(paramString.charAt(i * 2)) << 4) + j.a.b.O(paramString.charAt(i * 2 + 1))));
      i += 1;
    }
    paramString = new i(arrayOfByte);
    AppMethodBeat.o(186381);
    return paramString;
  }
  
  public static final i ef(byte... paramVarArgs)
  {
    AppMethodBeat.i(186373);
    s.u(paramVarArgs, "data");
    paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
    s.s(paramVarArgs, "java.util.Arrays.copyOf(this, size)");
    paramVarArgs = new i(paramVarArgs);
    AppMethodBeat.o(186373);
    return paramVarArgs;
  }
  
  public void a(f paramf, int paramInt)
  {
    AppMethodBeat.i(186416);
    s.u(paramf, "buffer");
    j.a.b.a(this, paramf, paramInt);
    AppMethodBeat.o(186416);
  }
  
  public boolean a(i parami, int paramInt)
  {
    AppMethodBeat.i(186419);
    s.u(parami, "other");
    boolean bool = parami.e(0, this.data, 0, paramInt);
    AppMethodBeat.o(186419);
    return bool;
  }
  
  public final void aNo(int paramInt)
  {
    this.cHb = paramInt;
  }
  
  public byte aNp(int paramInt)
  {
    return this.data[paramInt];
  }
  
  public i bKS(String paramString)
  {
    AppMethodBeat.i(186399);
    s.u(paramString, "algorithm");
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(this.data, 0, kIN());
    paramString = paramString.digest();
    s.s(paramString, "digestBytes");
    paramString = new i(paramString);
    AppMethodBeat.o(186399);
    return paramString;
  }
  
  public boolean e(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(186421);
    s.u(paramArrayOfByte, "other");
    if ((paramInt1 >= 0) && (paramInt1 <= this.data.length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (c.a(this.data, paramInt1, paramArrayOfByte, paramInt2, paramInt3)))
    {
      AppMethodBeat.o(186421);
      return true;
    }
    AppMethodBeat.o(186421);
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186488);
    if (paramObject == this)
    {
      AppMethodBeat.o(186488);
      return true;
    }
    if ((paramObject instanceof i))
    {
      if ((((i)paramObject).kIN() == this.data.length) && (((i)paramObject).e(0, this.data, 0, this.data.length)))
      {
        AppMethodBeat.o(186488);
        return true;
      }
      AppMethodBeat.o(186488);
      return false;
    }
    AppMethodBeat.o(186488);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(186490);
    int i = this.cHb;
    if (i != 0)
    {
      AppMethodBeat.o(186490);
      return i;
    }
    i = Arrays.hashCode(this.data);
    this.cHb = i;
    AppMethodBeat.o(186490);
    return i;
  }
  
  public final int kII()
  {
    return this.cHb;
  }
  
  public final String kIJ()
  {
    AppMethodBeat.i(186390);
    String str2 = this.ajTd;
    String str1 = str2;
    if (str2 == null)
    {
      str1 = b.ec(kIO());
      this.ajTd = str1;
    }
    AppMethodBeat.o(186390);
    return str1;
  }
  
  public String kIK()
  {
    AppMethodBeat.i(186395);
    String str = a.eb(this.data);
    AppMethodBeat.o(186395);
    return str;
  }
  
  public String kIL()
  {
    AppMethodBeat.i(186402);
    Object localObject = new char[this.data.length * 2];
    byte[] arrayOfByte = this.data;
    int k = arrayOfByte.length;
    int i = 0;
    int m;
    for (int j = 0; i < k; j = m + 1)
    {
      int n = arrayOfByte[i];
      m = j + 1;
      localObject[j] = j.a.b.kJf()[(n >> 4 & 0xF)];
      localObject[m] = j.a.b.kJf()[(n & 0xF)];
      i += 1;
    }
    localObject = new String((char[])localObject);
    AppMethodBeat.o(186402);
    return localObject;
  }
  
  public i kIM()
  {
    AppMethodBeat.i(186407);
    int i = 0;
    while (i < this.data.length)
    {
      int j = this.data[i];
      if ((j < 65) || (j > 90))
      {
        i += 1;
      }
      else
      {
        Object localObject = this.data;
        localObject = Arrays.copyOf((byte[])localObject, localObject.length);
        s.s(localObject, "java.util.Arrays.copyOf(this, size)");
        localObject[i] = ((byte)(j + 32));
        i += 1;
        while (i < localObject.length)
        {
          j = localObject[i];
          if ((j < 65) || (j > 90))
          {
            i += 1;
          }
          else
          {
            localObject[i] = ((byte)(j + 32));
            i += 1;
          }
        }
        localObject = new i((byte[])localObject);
        AppMethodBeat.o(186407);
        return localObject;
      }
    }
    AppMethodBeat.o(186407);
    return this;
  }
  
  public int kIN()
  {
    return this.data.length;
  }
  
  public byte[] kIO()
  {
    return this.data;
  }
  
  public byte[] toByteArray()
  {
    AppMethodBeat.i(186413);
    byte[] arrayOfByte = this.data;
    arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
    s.s(arrayOfByte, "java.util.Arrays.copyOf(this, size)");
    AppMethodBeat.o(186413);
    return arrayOfByte;
  }
  
  public String toString()
  {
    int j = 1;
    AppMethodBeat.i(186504);
    if (this.data.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(186504);
      return "[size=0]";
    }
    i = j.a.b.eg(this.data);
    if (i == -1)
    {
      if (this.data.length <= 64)
      {
        localObject1 = "[hex=" + kIL() + ']';
        AppMethodBeat.o(186504);
        return localObject1;
      }
      localObject2 = new StringBuilder("[size=").append(this.data.length).append(" hex=");
      if (64 <= this.data.length) {}
      for (i = j; i == 0; i = 0)
      {
        localObject1 = (Throwable)new IllegalArgumentException(("endIndex > length(" + this.data.length + ')').toString());
        AppMethodBeat.o(186504);
        throw ((Throwable)localObject1);
      }
      if (64 == this.data.length) {}
      for (localObject1 = this;; localObject1 = new i(k.copyOfRange(this.data, 0, 64)))
      {
        localObject1 = ((i)localObject1).kIL() + "…]";
        AppMethodBeat.o(186504);
        return localObject1;
      }
    }
    Object localObject1 = kIJ();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(186504);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((String)localObject1).substring(0, i);
    s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject2 = n.bV(n.bV(n.bV((String)localObject2, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
    if (i < ((String)localObject1).length())
    {
      localObject1 = "[size=" + this.data.length + " text=" + (String)localObject2 + "…]";
      AppMethodBeat.o(186504);
      return localObject1;
    }
    localObject1 = "[text=" + (String)localObject2 + ']';
    AppMethodBeat.o(186504);
    return localObject1;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, k=1, mv={1, 4, 1})
  public static final class a
  {
    public static i bKT(String paramString)
    {
      AppMethodBeat.i(186414);
      s.u(paramString, "$this$encodeUtf8");
      i locali = new i(b.bKP(paramString));
      locali.ajTd = paramString;
      AppMethodBeat.o(186414);
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.i
 * JD-Core Version:    0.7.0.1
 */