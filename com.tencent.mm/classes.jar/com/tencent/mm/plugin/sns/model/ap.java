package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class ap
{
  private static final Map<String, String> zCD;
  
  static
  {
    AppMethodBeat.i(95922);
    zCD = new HashMap();
    AppMethodBeat.o(95922);
  }
  
  public static String jv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95920);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(95920);
      return "";
    }
    boolean bool = Looper.getMainLooper().equals(Looper.myLooper());
    if ((bool) && (zCD.containsKey(paramString1 + paramString2)))
    {
      str = (String)zCD.get(paramString1 + paramString2);
      if (!bu.isNullOrNil(str))
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
      zCD.put(paramString1 + paramString2, localStringBuffer.toString());
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
      zCD.clear();
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ap
 * JD-Core Version:    0.7.0.1
 */