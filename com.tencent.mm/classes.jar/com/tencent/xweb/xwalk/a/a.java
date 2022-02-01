package com.tencent.xweb.xwalk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.b;
import com.tencent.xweb.xwalk.updater.SchedulerConfig;
import com.tencent.xweb.xwalk.updater.c;
import java.util.HashMap;

public final class a
{
  static HashMap<String, a> MxH;
  
  static
  {
    AppMethodBeat.i(195586);
    MxH = new HashMap();
    AppMethodBeat.o(195586);
  }
  
  public static a bbA(String paramString)
  {
    try
    {
      AppMethodBeat.i(195585);
      if (!MxH.containsKey(paramString)) {
        MxH.put(paramString, new a(paramString));
      }
      paramString = (a)MxH.get(paramString);
      AppMethodBeat.o(195585);
      return paramString;
    }
    finally {}
  }
  
  public static final class a
    extends c
  {
    String MxI;
    
    public a(String paramString)
    {
      AppMethodBeat.i(195582);
      this.MxI = paramString;
      this.TAG = (gdd() + "Scheduler");
      AppMethodBeat.o(195582);
    }
    
    public final boolean a(SchedulerConfig paramSchedulerConfig1, SchedulerConfig paramSchedulerConfig2)
    {
      AppMethodBeat.i(195583);
      if ((paramSchedulerConfig1.Mzc != paramSchedulerConfig2.Mzc) || (!nl(paramSchedulerConfig1.path, paramSchedulerConfig2.path)))
      {
        AppMethodBeat.o(195583);
        return false;
      }
      boolean bool = super.a(paramSchedulerConfig1, paramSchedulerConfig2);
      AppMethodBeat.o(195583);
      return bool;
    }
    
    public final String gdd()
    {
      return this.MxI;
    }
    
    public final int gde()
    {
      return 15;
    }
    
    public final String zR(boolean paramBoolean)
    {
      AppMethodBeat.i(195584);
      String str2;
      String str1;
      if (!paramBoolean)
      {
        str2 = b.mV("UPDATE_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.mV("UPDATE_SPEED_CONFIG", "tools");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(195584);
        return str1;
        str2 = b.mV("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.mV("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.a
 * JD-Core Version:    0.7.0.1
 */