package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class aq
{
  private static final Map<String, String> JZI;
  
  static
  {
    AppMethodBeat.i(95922);
    JZI = new HashMap();
    AppMethodBeat.o(95922);
  }
  
  public static String kD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95920);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(95920);
      return "";
    }
    boolean bool = Looper.getMainLooper().equals(Looper.myLooper());
    if ((bool) && (JZI.containsKey(paramString1 + paramString2)))
    {
      str = (String)JZI.get(paramString1 + paramString2);
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
      JZI.put(paramString1 + paramString2, localStringBuffer.toString());
    }
    paramString1 = localStringBuffer.toString();
    AppMethodBeat.o(95920);
    return paramString1;
  }
  
  public static void release()
  {
    try
    {
      AppMethodBeat.i(95921);
      JZI.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aq
 * JD-Core Version:    0.7.0.1
 */