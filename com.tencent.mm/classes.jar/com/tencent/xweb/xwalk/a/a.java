package com.tencent.xweb.xwalk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.b;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.c;
import java.util.HashMap;

public final class a
{
  static HashMap<String, a> MUL;
  
  static
  {
    AppMethodBeat.i(207607);
    MUL = new HashMap();
    AppMethodBeat.o(207607);
  }
  
  public static a bdd(String paramString)
  {
    try
    {
      AppMethodBeat.i(207606);
      if (!MUL.containsKey(paramString)) {
        MUL.put(paramString, new a(paramString));
      }
      paramString = (a)MUL.get(paramString);
      AppMethodBeat.o(207606);
      return paramString;
    }
    finally {}
  }
  
  public static final class a
    extends Scheduler
  {
    String MUM;
    
    public a(String paramString)
    {
      AppMethodBeat.i(207602);
      this.MUM = paramString;
      this.TAG = (ghF() + "Scheduler");
      AppMethodBeat.o(207602);
    }
    
    public final String Ae(boolean paramBoolean)
    {
      AppMethodBeat.i(207604);
      String str2;
      String str1;
      if (!paramBoolean)
      {
        str2 = b.nb("UPDATE_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.nb("UPDATE_SPEED_CONFIG", "tools");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(207604);
        return str1;
        str2 = b.nb("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.nb("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        }
      }
    }
    
    public final boolean a(c paramc1, c paramc2)
    {
      AppMethodBeat.i(207603);
      if ((paramc1.MWh != paramc2.MWh) || (!nr(paramc1.path, paramc2.path)))
      {
        AppMethodBeat.o(207603);
        return false;
      }
      boolean bool = super.a(paramc1, paramc2);
      AppMethodBeat.o(207603);
      return bool;
    }
    
    public final String gEo()
    {
      AppMethodBeat.i(224503);
      String str = b.nb("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
      if (TextUtils.isEmpty(str))
      {
        str = super.gEo();
        AppMethodBeat.o(224503);
        return str;
      }
      AppMethodBeat.o(224503);
      return str;
    }
    
    public final String ghF()
    {
      return this.MUM;
    }
    
    public final int ghG()
    {
      return 15;
    }
    
    public final String ghH()
    {
      AppMethodBeat.i(207605);
      String str = b.nb("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
      AppMethodBeat.o(207605);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.a
 * JD-Core Version:    0.7.0.1
 */