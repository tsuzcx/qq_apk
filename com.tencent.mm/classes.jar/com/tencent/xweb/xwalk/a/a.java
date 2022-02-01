package com.tencent.xweb.xwalk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.b;
import com.tencent.xweb.xwalk.updater.SchedulerConfig;
import com.tencent.xweb.xwalk.updater.c;
import java.util.HashMap;

public final class a
{
  static HashMap<String, a> KHh;
  
  static
  {
    AppMethodBeat.i(208946);
    KHh = new HashMap();
    AppMethodBeat.o(208946);
  }
  
  public static a aVx(String paramString)
  {
    try
    {
      AppMethodBeat.i(208945);
      if (!KHh.containsKey(paramString)) {
        KHh.put(paramString, new a(paramString));
      }
      paramString = (a)KHh.get(paramString);
      AppMethodBeat.o(208945);
      return paramString;
    }
    finally {}
  }
  
  public static final class a
    extends c
  {
    String KHi;
    
    public a(String paramString)
    {
      AppMethodBeat.i(208941);
      this.KHi = paramString;
      this.TAG = (fLH() + "Scheduler");
      AppMethodBeat.o(208941);
    }
    
    public final boolean a(SchedulerConfig paramSchedulerConfig1, SchedulerConfig paramSchedulerConfig2)
    {
      AppMethodBeat.i(208942);
      if ((paramSchedulerConfig1.KIx != paramSchedulerConfig2.KIx) || (!mN(paramSchedulerConfig1.path, paramSchedulerConfig2.path)))
      {
        AppMethodBeat.o(208942);
        return false;
      }
      boolean bool = super.a(paramSchedulerConfig1, paramSchedulerConfig2);
      AppMethodBeat.o(208942);
      return bool;
    }
    
    public final String fLH()
    {
      return this.KHi;
    }
    
    public final int fLI()
    {
      return 15;
    }
    
    public final String fLJ()
    {
      AppMethodBeat.i(208944);
      String str = b.mx("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
      if (TextUtils.isEmpty(str))
      {
        str = super.fLJ();
        AppMethodBeat.o(208944);
        return str;
      }
      AppMethodBeat.o(208944);
      return str;
    }
    
    public final String ze(boolean paramBoolean)
    {
      AppMethodBeat.i(208943);
      String str2;
      String str1;
      if (!paramBoolean)
      {
        str2 = b.mx("UPDATE_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.mx("UPDATE_SPEED_CONFIG", "tools");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(208943);
        return str1;
        str2 = b.mx("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.mx("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.a
 * JD-Core Version:    0.7.0.1
 */