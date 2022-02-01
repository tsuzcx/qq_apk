package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  public static a yCK;
  private static a yCL;
  public boolean imJ = false;
  
  public static long VV(String paramString)
  {
    AppMethodBeat.i(73761);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    long l1 = bt.flT();
    try
    {
      long l2 = localSimpleDateFormat.parse(paramString).getTime();
      l1 = l2;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        ad.e("MicroMsg.FixToolsUplogModel", "dateToTimeStamp failed. date:%s, stack:%s", new Object[] { paramString, bt.flS() });
      }
    }
    AppMethodBeat.o(73761);
    return l1;
  }
  
  public static a dNj()
  {
    AppMethodBeat.i(73760);
    if (yCL == null) {
      yCL = new a();
    }
    a locala = yCL;
    AppMethodBeat.o(73760);
    return locala;
  }
  
  public static abstract interface a
  {
    public abstract void Pa(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.a
 * JD-Core Version:    0.7.0.1
 */