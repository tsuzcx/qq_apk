package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  public static a.a qEA;
  private static a qEB;
  public boolean fQi = false;
  
  public static long Gm(String paramString)
  {
    AppMethodBeat.i(126839);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    long l1 = bo.aoy();
    try
    {
      long l2 = localSimpleDateFormat.parse(paramString).getTime();
      l1 = l2;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        ab.e("MicroMsg.FixToolsUplogModel", "dateToTimeStamp failed. date:%s, stack:%s", new Object[] { paramString, bo.dtY() });
      }
    }
    AppMethodBeat.o(126839);
    return l1;
  }
  
  public static a cjQ()
  {
    AppMethodBeat.i(126838);
    if (qEB == null) {
      qEB = new a();
    }
    a locala = qEB;
    AppMethodBeat.o(126838);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.a
 * JD-Core Version:    0.7.0.1
 */