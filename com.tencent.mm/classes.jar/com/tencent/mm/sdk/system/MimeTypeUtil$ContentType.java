package com.tencent.mm.sdk.system;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MimeTypeUtil$ContentType
{
  private static final String CHARSET_EQ = "charset=";
  public static final String DEFAULT_CHARSET = "UTF-8";
  private static final Pattern MIMETYPE_PATTERN;
  public final String charset;
  public final String mimeType;
  
  static
  {
    AppMethodBeat.i(153467);
    MIMETYPE_PATTERN = Pattern.compile("([a-zA-Z*-.0-9]+/[a-zA-Z*-.0-9]+)");
    AppMethodBeat.o(153467);
  }
  
  private MimeTypeUtil$ContentType(String paramString1, String paramString2)
  {
    this.mimeType = paramString1;
    this.charset = paramString2;
  }
  
  public static ContentType obtain(String paramString)
  {
    String str = null;
    AppMethodBeat.i(153466);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(153466);
      return null;
    }
    Object localObject = MIMETYPE_PATTERN.matcher(paramString);
    if (!((Matcher)localObject).find())
    {
      AppMethodBeat.o(153466);
      return null;
    }
    localObject = ((Matcher)localObject).group(0);
    if (paramString.contains("charset=")) {
      str = paramString.substring(paramString.indexOf("charset=") + 8).trim();
    }
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "UTF-8";
    }
    paramString = new ContentType((String)localObject, paramString);
    AppMethodBeat.o(153466);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153465);
    String str = "ContentType{mimeType='" + this.mimeType + '\'' + ", charset='" + this.charset + '\'' + '}';
    AppMethodBeat.o(153465);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.system.MimeTypeUtil.ContentType
 * JD-Core Version:    0.7.0.1
 */