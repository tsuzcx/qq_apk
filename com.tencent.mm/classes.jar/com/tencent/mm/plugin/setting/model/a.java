package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  public static a.a nQD;
  private static a nQE;
  public boolean eAp = false;
  
  public static a byG()
  {
    if (nQE == null) {
      nQE = new a();
    }
    return nQE;
  }
  
  public static long xt(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    try
    {
      long l = localSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (ParseException localParseException)
    {
      y.e("MicroMsg.FixToolsUplogModel", "dateToTimeStamp failed. date:%s, stack:%s", new Object[] { paramString, bk.csb() });
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.a
 * JD-Core Version:    0.7.0.1
 */