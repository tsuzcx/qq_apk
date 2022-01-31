package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class am
{
  private static am uKc;
  public am.a uKa;
  private boolean uKb;
  
  static
  {
    AppMethodBeat.i(124212);
    uKc = new am();
    AppMethodBeat.o(124212);
  }
  
  private am()
  {
    AppMethodBeat.i(124209);
    Object localObject = (String)g.RL().Ru().get(ac.a.yHx, "");
    this.uKa = new am.a();
    am.a locala = this.uKa;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("&");
        locala.id = bo.p(localObject[0], new Object[0]);
        locala.uKd = bo.apV(localObject[1]);
        locala.uKe = bo.apV(localObject[2]);
        locala.ghy = bo.apW(localObject[3]);
        locala.uJc = bo.apV(localObject[4]);
        locala.type = bo.apV(localObject[5]);
        locala.text = localObject[6];
        locala.cDz = localObject[7];
        locala.timestamp = bo.apW(localObject[8]);
        locala.uKf = bo.apV(localObject[9]);
        locala.fJQ = bo.apW(localObject[10]);
        locala.uKg = bo.apV(localObject[11]);
      }
      AppMethodBeat.o(124209);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchRedPointMgr", localException, "", new Object[0]);
      AppMethodBeat.o(124209);
    }
  }
  
  public static am cZF()
  {
    return uKc;
  }
  
  public static long cZG()
  {
    AppMethodBeat.i(124211);
    Object localObject = g.RL().Ru().get(ac.a.yJV, null);
    if (localObject == null)
    {
      AppMethodBeat.o(124211);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(124211);
    return l;
  }
  
  public final void Jt(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(151922);
    if (this.uKa != null)
    {
      boolean bool = this.uKa.isValid();
      if ((this.uKb) && (paramInt == 1) && (!bool))
      {
        AppMethodBeat.o(151922);
        return;
      }
      String str2 = this.uKa.id;
      if (str2 != null)
      {
        str1 = str2;
        if (!str2.equals("null")) {}
      }
      else
      {
        str1 = "";
      }
      if (bool) {
        i = 1;
      }
      String str1 = String.format("%d,%d,%s,%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), str1, Long.valueOf(System.currentTimeMillis()) });
      ab.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "report websearch reddot 17513: ".concat(String.valueOf(str1)));
      com.tencent.mm.plugin.report.e.qrI.kvStat(17513, str1);
      if ((paramInt == 1) && (!bool)) {
        this.uKb = true;
      }
    }
    AppMethodBeat.o(151922);
  }
  
  public final void save()
  {
    AppMethodBeat.i(124210);
    if (this.uKa == null) {}
    for (String str = "";; str = this.uKa.aCR())
    {
      g.RL().Ru().set(ac.a.yHx, str);
      AppMethodBeat.o(124210);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.am
 * JD-Core Version:    0.7.0.1
 */