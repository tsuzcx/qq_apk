package com.tencent.thumbplayer.core.drm.httpclient;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class DataSpec
{
  public static final int FLAG_ALLOW_CACHE_FRAGMENTATION = 16;
  public static final int FLAG_ALLOW_GZIP = 1;
  public static final int FLAG_ALLOW_ICY_METADATA = 2;
  public static final int FLAG_DONT_CACHE_IF_LENGTH_UNKNOWN = 4;
  public static final int HTTP_METHOD_DELETE = 5;
  public static final int HTTP_METHOD_GET = 1;
  public static final int HTTP_METHOD_HEAD = 3;
  public static final int HTTP_METHOD_POST = 2;
  public static final int HTTP_METHOD_PUT = 4;
  public final long absoluteStreamPosition;
  public final int flags;
  public final byte[] httpBody;
  public final int httpMethod;
  public final String key;
  public final long length;
  public final long position;
  public final Uri uri;
  
  public DataSpec(Uri paramUri, int paramInt)
  {
    this(paramUri, paramInt, 0);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, int paramInt2)
  {
    this(paramUri, paramInt1, 0L, -1L, null, paramInt2);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2)
  {
    this(paramUri, paramInt1, null, paramLong1, paramLong2, paramLong3, paramString, paramInt2);
  }
  
  public DataSpec(Uri paramUri, int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    this(paramUri, paramInt, paramLong1, paramLong1, paramLong2, paramString, 0);
    AppMethodBeat.i(228291);
    AppMethodBeat.o(228291);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, long paramLong1, long paramLong2, String paramString, int paramInt2)
  {
    this(paramUri, paramInt1, paramLong1, paramLong1, paramLong2, paramString, paramInt2);
    AppMethodBeat.i(228299);
    AppMethodBeat.o(228299);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2)
  {
    AppMethodBeat.i(228319);
    boolean bool;
    if (paramLong1 >= 0L)
    {
      bool = true;
      Assertions.checkArgument(bool);
      if (paramLong2 < 0L) {
        break label129;
      }
      bool = true;
      label34:
      Assertions.checkArgument(bool);
      if ((paramLong3 <= 0L) && (paramLong3 != -1L)) {
        break label135;
      }
      bool = true;
      label58:
      Assertions.checkArgument(bool);
      this.uri = paramUri;
      this.httpMethod = paramInt1;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
        break label141;
      }
    }
    for (;;)
    {
      this.httpBody = paramArrayOfByte;
      this.absoluteStreamPosition = paramLong1;
      this.position = paramLong2;
      this.length = paramLong3;
      this.key = paramString;
      this.flags = paramInt2;
      AppMethodBeat.o(228319);
      return;
      bool = false;
      break;
      label129:
      bool = false;
      break label34;
      label135:
      bool = false;
      break label58;
      label141:
      paramArrayOfByte = null;
    }
  }
  
  public static String getStringForHttpMethod(int paramInt)
  {
    AppMethodBeat.i(228327);
    switch (paramInt)
    {
    default: 
      AssertionError localAssertionError = new AssertionError(paramInt);
      AppMethodBeat.o(228327);
      throw localAssertionError;
    case 1: 
      AppMethodBeat.o(228327);
      return "GET";
    case 2: 
      AppMethodBeat.o(228327);
      return "POST";
    case 3: 
      AppMethodBeat.o(228327);
      return "HEAD";
    case 4: 
      AppMethodBeat.o(228327);
      return "PUT";
    }
    AppMethodBeat.o(228327);
    return "DELETE";
  }
  
  public final String getHttpMethodString()
  {
    AppMethodBeat.i(228348);
    String str = getStringForHttpMethod(this.httpMethod);
    AppMethodBeat.o(228348);
    return str;
  }
  
  public final boolean isFlagSet(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public final DataSpec subrange(long paramLong)
  {
    long l = -1L;
    AppMethodBeat.i(228354);
    if (this.length == -1L) {}
    for (;;)
    {
      DataSpec localDataSpec = subrange(paramLong, l);
      AppMethodBeat.o(228354);
      return localDataSpec;
      l = this.length - paramLong;
    }
  }
  
  public final DataSpec subrange(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228362);
    if ((paramLong1 == 0L) && (this.length == paramLong2))
    {
      AppMethodBeat.o(228362);
      return this;
    }
    DataSpec localDataSpec = new DataSpec(this.uri, this.httpMethod, this.httpBody, this.absoluteStreamPosition + paramLong1, this.position + paramLong1, paramLong2, this.key, this.flags);
    AppMethodBeat.o(228362);
    return localDataSpec;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(228343);
    String str = "DataSpec[" + getHttpMethodString() + " " + this.uri + ", " + Arrays.toString(this.httpBody) + ", " + this.absoluteStreamPosition + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    AppMethodBeat.o(228343);
    return str;
  }
  
  public final DataSpec withUri(Uri paramUri)
  {
    AppMethodBeat.i(228368);
    paramUri = new DataSpec(paramUri, this.httpMethod, this.httpBody, this.absoluteStreamPosition, this.position, this.length, this.key, this.flags);
    AppMethodBeat.o(228368);
    return paramUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.DataSpec
 * JD-Core Version:    0.7.0.1
 */