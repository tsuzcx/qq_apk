package com.tencent.xweb.xwalk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.b;
import com.tencent.xweb.xwalk.updater.c;
import com.tencent.xweb.xwalk.updater.d;
import java.util.HashMap;

public final class a
{
  private static HashMap<String, a> aipI;
  
  static
  {
    AppMethodBeat.i(213092);
    aipI = new HashMap();
    AppMethodBeat.o(213092);
  }
  
  public static a bIp(String paramString)
  {
    try
    {
      AppMethodBeat.i(213090);
      if (!aipI.containsKey(paramString)) {
        aipI.put(paramString, new a(paramString));
      }
      paramString = (a)aipI.get(paramString);
      AppMethodBeat.o(213090);
      return paramString;
    }
    finally {}
  }
  
  public static final class a
    extends c
  {
    String aipJ;
    
    public a(String paramString)
    {
      AppMethodBeat.i(213054);
      this.aipJ = paramString;
      this.TAG = (this.aipJ + "Scheduler");
      AppMethodBeat.o(213054);
    }
    
    public final String Pd(boolean paramBoolean)
    {
      AppMethodBeat.i(213068);
      String str2;
      String str1;
      if (!paramBoolean)
      {
        str2 = b.kfi().qM("UPDATE_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.keX().qM("UPDATE_SPEED_CONFIG", "tools");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(213068);
        return str1;
        str2 = b.kfi().qM("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.keX().qM("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        }
      }
    }
    
    public final boolean a(d paramd1, d paramd2)
    {
      AppMethodBeat.i(213058);
      if ((paramd1.aiqH != paramd2.aiqH) || (!jH(paramd1.path, paramd2.path)))
      {
        AppMethodBeat.o(213058);
        return false;
      }
      boolean bool = super.a(paramd1, paramd2);
      AppMethodBeat.o(213058);
      return bool;
    }
    
    public final String kjo()
    {
      return this.aipJ;
    }
    
    public final int kjp()
    {
      return 15;
    }
    
    public final String kjq()
    {
      AppMethodBeat.i(213072);
      String str = b.kfi().qM("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
      if (TextUtils.isEmpty(str))
      {
        str = super.kjq();
        AppMethodBeat.o(213072);
        return str;
      }
      AppMethodBeat.o(213072);
      return str;
    }
    
    public final String kjr()
    {
      AppMethodBeat.i(213073);
      String str = b.kfi().qM("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
      AppMethodBeat.o(213073);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.a
 * JD-Core Version:    0.7.0.1
 */