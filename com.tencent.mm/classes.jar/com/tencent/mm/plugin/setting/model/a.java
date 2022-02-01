package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  public static a CXD;
  private static a CXE;
  public boolean jkK = false;
  
  public static long agD(String paramString)
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
  
  public static a eSG()
  {
    AppMethodBeat.i(73760);
    if (CXE == null) {
      CXE = new a();
    }
    a locala = CXE;
    AppMethodBeat.o(73760);
    return locala;
  }
  
  public static abstract interface a
  {
    public abstract void Xn(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.a
 * JD-Core Version:    0.7.0.1
 */