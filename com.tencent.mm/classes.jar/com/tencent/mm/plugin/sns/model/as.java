package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Map;

public final class as
{
  private static final Map<String, String> QwQ;
  
  static
  {
    AppMethodBeat.i(95922);
    QwQ = new HashMap();
    AppMethodBeat.o(95922);
  }
  
  public static String Ew(String paramString)
  {
    AppMethodBeat.i(309431);
    String str = mg(al.getAccSnsPath(), paramString);
    y.bDX(str);
    paramString = str + paramString + "thumb_bg_";
    AppMethodBeat.o(309431);
    return paramString;
  }
  
  public static String aYD(String paramString)
  {
    AppMethodBeat.i(309429);
    String str = mg(al.getAccSnsPath(), paramString);
    y.bDX(str);
    paramString = str + paramString + "image_bg_";
    AppMethodBeat.o(309429);
    return paramString;
  }
  
  public static String mg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95920);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(95920);
      return "";
    }
    boolean bool = Looper.getMainLooper().equals(Looper.myLooper());
    if ((bool) && (QwQ.containsKey(paramString1 + paramString2)))
    {
      str = (String)QwQ.get(paramString1 + paramString2);
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(95920);
        return str;
      }
    }
    String str = g.getMessageDigest(paramString2.getBytes());
    StringBuffer localStringBuffer = new StringBuffer(paramString1);
    if (str.length() > 0)
    {
      localStringBuffer.append(str.charAt(0));
      localStringBuffer.append("/");
    }
    if (str.length() >= 2)
    {
      localStringBuffer.append(str.charAt(1));
      localStringBuffer.append("/");
    }
    if (bool) {
      QwQ.put(paramString1 + paramString2, localStringBuffer.toString());
    }
    paramString1 = localStringBuffer.toString();
    AppMethodBeat.o(95920);
    return paramString1;
  }
  
  public static String mh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(309435);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(mg(al.getAccSnsPath(), paramString1).replace("MicroMsg", "cache"));
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_tmp");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(309435);
    return paramString1;
  }
  
  public static String mi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(309438);
    paramString1 = mg(al.getAccSnsPath(), paramString1).replace("MicroMsg", "cache");
    paramString1 = paramString1 + paramString2;
    AppMethodBeat.o(309438);
    return paramString1;
  }
  
  public static void release()
  {
    try
    {
      AppMethodBeat.i(95921);
      QwQ.clear();
      AppMethodBeat.o(95921);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as
 * JD-Core Version:    0.7.0.1
 */