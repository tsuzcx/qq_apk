package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  public static a ySN;
  private static a ySO;
  public boolean ipD = false;
  
  public static long WH(String paramString)
  {
    AppMethodBeat.i(73761);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    long l1 = bu.fpO();
    try
    {
      long l2 = localSimpleDateFormat.parse(paramString).getTime();
      l1 = l2;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        ae.e("MicroMsg.FixToolsUplogModel", "dateToTimeStamp failed. date:%s, stack:%s", new Object[] { paramString, bu.fpN() });
      }
    }
    AppMethodBeat.o(73761);
    return l1;
  }
  
  public static a dQF()
  {
    AppMethodBeat.i(73760);
    if (ySO == null) {
      ySO = new a();
    }
    a locala = ySO;
    AppMethodBeat.o(73760);
    return locala;
  }
  
  public static abstract interface a
  {
    public abstract void PJ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.a
 * JD-Core Version:    0.7.0.1
 */