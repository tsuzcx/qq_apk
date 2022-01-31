package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class ao
{
  private static final Map<String, String> ril;
  
  static
  {
    AppMethodBeat.i(36599);
    ril = new HashMap();
    AppMethodBeat.o(36599);
  }
  
  public static String gl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(36597);
    if (paramString2 == null)
    {
      AppMethodBeat.o(36597);
      return "";
    }
    boolean bool = Looper.getMainLooper().equals(Looper.myLooper());
    if ((bool) && (ril.containsKey(paramString1 + paramString2)))
    {
      str = (String)ril.get(paramString1 + paramString2);
      if (!bo.isNullOrNil(str))
      {
        AppMethodBeat.o(36597);
        return str;
      }
    }
    String str = g.w(paramString2.getBytes());
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
      ril.put(paramString1 + paramString2, localStringBuffer.toString());
    }
    paramString1 = localStringBuffer.toString();
    AppMethodBeat.o(36597);
    return paramString1;
  }
  
  public static void release()
  {
    try
    {
      AppMethodBeat.i(36598);
      ril.clear();
      AppMethodBeat.o(36598);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ao
 * JD-Core Version:    0.7.0.1
 */