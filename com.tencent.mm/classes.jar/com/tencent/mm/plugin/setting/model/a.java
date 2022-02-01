package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  public static a xof;
  private static a xog;
  public boolean hTo = false;
  
  public static long Sx(String paramString)
  {
    AppMethodBeat.i(73761);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    long l1 = bs.eWj();
    try
    {
      long l2 = localSimpleDateFormat.parse(paramString).getTime();
      l1 = l2;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        ac.e("MicroMsg.FixToolsUplogModel", "dateToTimeStamp failed. date:%s, stack:%s", new Object[] { paramString, bs.eWi() });
      }
    }
    AppMethodBeat.o(73761);
    return l1;
  }
  
  public static a dBG()
  {
    AppMethodBeat.i(73760);
    if (xog == null) {
      xog = new a();
    }
    a locala = xog;
    AppMethodBeat.o(73760);
    return locala;
  }
  
  public static abstract interface a
  {
    public abstract void Nx(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.a
 * JD-Core Version:    0.7.0.1
 */