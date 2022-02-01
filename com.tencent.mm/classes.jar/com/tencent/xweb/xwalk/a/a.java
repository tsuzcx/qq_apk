package com.tencent.xweb.xwalk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.b;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.c;
import java.util.HashMap;

public final class a
{
  static HashMap<String, a> SHS;
  
  static
  {
    AppMethodBeat.i(207340);
    SHS = new HashMap();
    AppMethodBeat.o(207340);
  }
  
  public static a bsQ(String paramString)
  {
    try
    {
      AppMethodBeat.i(207339);
      if (!SHS.containsKey(paramString)) {
        SHS.put(paramString, new a(paramString));
      }
      paramString = (a)SHS.get(paramString);
      AppMethodBeat.o(207339);
      return paramString;
    }
    finally {}
  }
  
  public static final class a
    extends Scheduler
  {
    String SHT;
    
    public a(String paramString)
    {
      AppMethodBeat.i(207334);
      this.SHT = paramString;
      this.TAG = (hvc() + "Scheduler");
      AppMethodBeat.o(207334);
    }
    
    public final String Eu(boolean paramBoolean)
    {
      AppMethodBeat.i(207336);
      String str2;
      String str1;
      if (!paramBoolean)
      {
        str2 = b.nS("UPDATE_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.nS("UPDATE_SPEED_CONFIG", "tools");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(207336);
        return str1;
        str2 = b.nS("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.nS("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        }
      }
    }
    
    public final boolean a(c paramc1, c paramc2)
    {
      AppMethodBeat.i(207335);
      if ((paramc1.SJl != paramc2.SJl) || (!ok(paramc1.path, paramc2.path)))
      {
        AppMethodBeat.o(207335);
        return false;
      }
      boolean bool = super.a(paramc1, paramc2);
      AppMethodBeat.o(207335);
      return bool;
    }
    
    public final String hvc()
    {
      return this.SHT;
    }
    
    public final int hvd()
    {
      return 15;
    }
    
    public final String hve()
    {
      AppMethodBeat.i(207337);
      String str = b.nS("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
      if (TextUtils.isEmpty(str))
      {
        str = super.hve();
        AppMethodBeat.o(207337);
        return str;
      }
      AppMethodBeat.o(207337);
      return str;
    }
    
    public final String hvf()
    {
      AppMethodBeat.i(207338);
      String str = b.nS("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
      AppMethodBeat.o(207338);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.a
 * JD-Core Version:    0.7.0.1
 */