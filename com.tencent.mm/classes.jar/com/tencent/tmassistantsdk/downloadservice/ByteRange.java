package com.tencent.tmassistantsdk.downloadservice;

import android.content.res.Resources.NotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(75699);
    RANGE_HEADER_PATTERN = Pattern.compile("^\\s*([^=\\s]+)\\s*=\\s*(\\d*)\\s*-\\s*(\\d*)((?:\\s*,\\s*(?:\\d*)-(?:\\d*))*)\\s*$");
    CONTENT_RANGE_HEADER_PATTERN = Pattern.compile("^\\s*bytes\\s+(\\d+)-(\\d+)/(\\d+)\\s*$");
    AppMethodBeat.o(75699);
  }
  
  public ByteRange(long paramLong)
  {
    this(paramLong, null);
  }
  
  public ByteRange(long paramLong1, long paramLong2)
  {
    this(paramLong1, Long.valueOf(paramLong2));
    AppMethodBeat.i(75692);
    IllegalArgumentException localIllegalArgumentException;
    if (paramLong1 < 0L)
    {
      localIllegalArgumentException = new IllegalArgumentException("If end is provided, start must be positive.");
      AppMethodBeat.o(75692);
      throw localIllegalArgumentException;
    }
    if (paramLong2 < paramLong1)
    {
      localIllegalArgumentException = new IllegalArgumentException("end must be >= start.");
      AppMethodBeat.o(75692);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(75692);
  }
  
  protected ByteRange(long paramLong, Long paramLong1)
  {
    this.start = paramLong;
    this.end = paramLong1;
  }
  
  public static long getTotalSize(String paramString)
  {
    AppMethodBeat.i(75696);
    int i = paramString.indexOf("/");
    if (i == -1)
    {
      paramString = new Resources.NotFoundException();
      AppMethodBeat.o(75696);
      throw paramString;
    }
    long l = bo.apW(paramString.substring(i + 1));
    AppMethodBeat.o(75696);
    return l;
  }
  
  public static ByteRange parseContentRange(String paramString)
  {
    AppMethodBeat.i(75695);
    Matcher localMatcher = CONTENT_RANGE_HEADER_PATTERN.matcher(paramString);
    if (!localMatcher.matches())
    {
      paramString = new Throwable("Invalid content-range format: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(75695);
      throw paramString;
    }
    paramString = new ByteRange(bo.apW(localMatcher.group(1)), bo.apW(localMatcher.group(2)));
    AppMethodBeat.o(75695);
    return paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(75698);
    if ((paramObject instanceof ByteRange))
    {
      paramObject = (ByteRange)paramObject;
      if (this.start != paramObject.getStart())
      {
        AppMethodBeat.o(75698);
        return false;
      }
      if (hasEnd() != paramObject.hasEnd())
      {
        AppMethodBeat.o(75698);
        return false;
      }
      if (hasEnd())
      {
        boolean bool = this.end.equals(Long.valueOf(paramObject.getEnd()));
        AppMethodBeat.o(75698);
        return bool;
      }
      AppMethodBeat.o(75698);
      return true;
    }
    AppMethodBeat.o(75698);
    return false;
  }
  
  public long getEnd()
  {
    AppMethodBeat.i(75693);
    if (!hasEnd())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Byte-range does not have end.  Check hasEnd() before use");
      AppMethodBeat.o(75693);
      throw localIllegalStateException;
    }
    long l = this.end.longValue();
    AppMethodBeat.o(75693);
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
    AppMethodBeat.i(75697);
    int j = Long.valueOf(this.start).hashCode() + 629;
    int i = j;
    if (this.end != null) {
      i = j * 37 + this.end.hashCode();
    }
    AppMethodBeat.o(75697);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(75694);
    if (this.end != null)
    {
      str = "bytes=" + this.start + "-" + this.end;
      AppMethodBeat.o(75694);
      return str;
    }
    if (this.start < 0L)
    {
      str = "bytes=" + this.start;
      AppMethodBeat.o(75694);
      return str;
    }
    String str = "bytes=" + this.start + "-";
    AppMethodBeat.o(75694);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.ByteRange
 * JD-Core Version:    0.7.0.1
 */