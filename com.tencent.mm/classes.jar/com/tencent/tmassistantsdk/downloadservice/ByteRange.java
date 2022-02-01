package com.tencent.tmassistantsdk.downloadservice;

import android.content.res.Resources.NotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByteRange
{
  protected static final String BYTES_UNIT = "bytes";
  protected static final Pattern CONTENT_RANGE_HEADER_PATTERN;
  protected static final String INVALID_RANGE_HEADER_REGEX = "((?:\\s*,\\s*(?:\\d*)-(?:\\d*))*)";
  protected static final Pattern RANGE_HEADER_PATTERN;
  protected static final String UNIT_REGEX = "([^=\\s]+)";
  protected static final String VALID_CONTENT_RANGE_HEADER_REGEX = "bytes\\s+(\\d+)-(\\d+)/(\\d+)";
  protected static final String VALID_RANGE_HEADER_REGEX = "([^=\\s]+)\\s*=\\s*(\\d*)\\s*-\\s*(\\d*)";
  protected final Long end;
  protected final long start;
  
  static
  {
    AppMethodBeat.i(101945);
    RANGE_HEADER_PATTERN = Pattern.compile("^\\s*([^=\\s]+)\\s*=\\s*(\\d*)\\s*-\\s*(\\d*)((?:\\s*,\\s*(?:\\d*)-(?:\\d*))*)\\s*$");
    CONTENT_RANGE_HEADER_PATTERN = Pattern.compile("^\\s*bytes\\s+(\\d+)-(\\d+)/(\\d+)\\s*$");
    AppMethodBeat.o(101945);
  }
  
  public ByteRange(long paramLong)
  {
    this(paramLong, null);
  }
  
  public ByteRange(long paramLong1, long paramLong2)
  {
    this(paramLong1, Long.valueOf(paramLong2));
    AppMethodBeat.i(101938);
    IllegalArgumentException localIllegalArgumentException;
    if (paramLong1 < 0L)
    {
      localIllegalArgumentException = new IllegalArgumentException("If end is provided, start must be positive.");
      AppMethodBeat.o(101938);
      throw localIllegalArgumentException;
    }
    if (paramLong2 < paramLong1)
    {
      localIllegalArgumentException = new IllegalArgumentException("end must be >= start.");
      AppMethodBeat.o(101938);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(101938);
  }
  
  protected ByteRange(long paramLong, Long paramLong1)
  {
    this.start = paramLong;
    this.end = paramLong1;
  }
  
  public static long getTotalSize(String paramString)
  {
    AppMethodBeat.i(101942);
    int i = paramString.indexOf("/");
    if (i == -1)
    {
      paramString = new Resources.NotFoundException();
      AppMethodBeat.o(101942);
      throw paramString;
    }
    long l = bs.aLz(paramString.substring(i + 1));
    AppMethodBeat.o(101942);
    return l;
  }
  
  public static ByteRange parseContentRange(String paramString)
  {
    AppMethodBeat.i(101941);
    Matcher localMatcher = CONTENT_RANGE_HEADER_PATTERN.matcher(paramString);
    if (!localMatcher.matches())
    {
      paramString = new Throwable("Invalid content-range format: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(101941);
      throw paramString;
    }
    paramString = new ByteRange(bs.aLz(localMatcher.group(1)), bs.aLz(localMatcher.group(2)));
    AppMethodBeat.o(101941);
    return paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101944);
    if ((paramObject instanceof ByteRange))
    {
      paramObject = (ByteRange)paramObject;
      if (this.start != paramObject.getStart())
      {
        AppMethodBeat.o(101944);
        return false;
      }
      if (hasEnd() != paramObject.hasEnd())
      {
        AppMethodBeat.o(101944);
        return false;
      }
      if (hasEnd())
      {
        boolean bool = this.end.equals(Long.valueOf(paramObject.getEnd()));
        AppMethodBeat.o(101944);
        return bool;
      }
      AppMethodBeat.o(101944);
      return true;
    }
    AppMethodBeat.o(101944);
    return false;
  }
  
  public long getEnd()
  {
    AppMethodBeat.i(101939);
    if (!hasEnd())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Byte-range does not have end.  Check hasEnd() before use");
      AppMethodBeat.o(101939);
      throw localIllegalStateException;
    }
    long l = this.end.longValue();
    AppMethodBeat.o(101939);
    return l;
  }
  
  public long getStart()
  {
    return this.start;
  }
  
  public boolean hasEnd()
  {
    return this.end != null;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(101943);
    int j = Long.valueOf(this.start).hashCode() + 629;
    int i = j;
    if (this.end != null) {
      i = j * 37 + this.end.hashCode();
    }
    AppMethodBeat.o(101943);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(101940);
    if (this.end != null)
    {
      str = "bytes=" + this.start + "-" + this.end;
      AppMethodBeat.o(101940);
      return str;
    }
    if (this.start < 0L)
    {
      str = "bytes=" + this.start;
      AppMethodBeat.o(101940);
      return str;
    }
    String str = "bytes=" + this.start + "-";
    AppMethodBeat.o(101940);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.ByteRange
 * JD-Core Version:    0.7.0.1
 */