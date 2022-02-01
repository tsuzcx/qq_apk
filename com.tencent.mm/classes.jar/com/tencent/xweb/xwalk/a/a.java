package com.tencent.xweb.xwalk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.b;
import com.tencent.xweb.xwalk.b.c;
import com.tencent.xweb.xwalk.b.d;
import java.util.HashMap;

public final class a
{
  static HashMap<String, a> aajK;
  
  static
  {
    AppMethodBeat.i(210217);
    aajK = new HashMap();
    AppMethodBeat.o(210217);
  }
  
  public static a bFR(String paramString)
  {
    try
    {
      AppMethodBeat.i(210216);
      if (!aajK.containsKey(paramString)) {
        aajK.put(paramString, new a(paramString));
      }
      paramString = (a)aajK.get(paramString);
      AppMethodBeat.o(210216);
      return paramString;
    }
    finally {}
  }
  
  public static final class a
    extends c
  {
    String aajL;
    
    public a(String paramString)
    {
      AppMethodBeat.i(204408);
      this.aajL = paramString;
      this.TAG = (iyV() + "Scheduler");
      AppMethodBeat.o(204408);
    }
    
    public final String IX(boolean paramBoolean)
    {
      AppMethodBeat.i(204412);
      String str2;
      String str1;
      if (!paramBoolean)
      {
        str2 = b.oO("UPDATE_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.oO("UPDATE_SPEED_CONFIG", "tools");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(204412);
        return str1;
        str2 = b.oO("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = com.tencent.xweb.a.oO("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        }
      }
    }
    
    public final boolean a(d paramd1, d paramd2)
    {
      AppMethodBeat.i(204409);
      if ((paramd1.aald != paramd2.aald) || (!pg(paramd1.path, paramd2.path)))
      {
        AppMethodBeat.o(204409);
        return false;
      }
      boolean bool = super.a(paramd1, paramd2);
      AppMethodBeat.o(204409);
      return bool;
    }
    
    public final String iyV()
    {
      return this.aajL;
    }
    
    public final int iyW()
    {
      return 15;
    }
    
    public final String iyX()
    {
      AppMethodBeat.i(204413);
      String str = b.oO("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
      if (TextUtils.isEmpty(str))
      {
        str = super.iyX();
        AppMethodBeat.o(204413);
        return str;
      }
      AppMethodBeat.o(204413);
      return str;
    }
    
    public final String iyY()
    {
      AppMethodBeat.i(204415);
      String str = b.oO("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
      AppMethodBeat.o(204415);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.a
 * JD-Core Version:    0.7.0.1
 */