package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.app.t;
import com.tencent.mm.app.t.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public static a Pnv;
  private static b Pnw;
  public boolean oTC = false;
  
  public static long ahE(String paramString)
  {
    AppMethodBeat.i(73761);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    long l1 = Util.nowMilliSecond();
    try
    {
      long l2 = localSimpleDateFormat.parse(paramString).getTime();
      l1 = l2;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        Log.e("MicroMsg.FixToolsUplogModel", "dateToTimeStamp failed. date:%s, stack:%s", new Object[] { paramString, Util.getStack() });
      }
    }
    AppMethodBeat.o(73761);
    return l1;
  }
  
  public static b gUU()
  {
    AppMethodBeat.i(73760);
    if (Pnw == null) {
      Pnw = new b();
    }
    b localb = Pnw;
    AppMethodBeat.o(73760);
    return localb;
  }
  
  public static abstract interface a
  {
    public abstract void aiS(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.b
 * JD-Core Version:    0.7.0.1
 */