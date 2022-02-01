package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class aq
{
  private static aq PzE;
  public a PzC;
  private boolean PzD;
  
  static
  {
    AppMethodBeat.i(117764);
    PzE = new aq();
    AppMethodBeat.o(117764);
  }
  
  private aq()
  {
    AppMethodBeat.i(117760);
    Object localObject = (String)h.aHG().aHp().get(ar.a.VrC, "");
    this.PzC = new a();
    a locala = this.PzC;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("&");
        locala.id = Util.safeFormatString(localObject[0], new Object[0]);
        locala.PzF = Util.safeParseInt(localObject[1]);
        locala.PzG = Util.safeParseInt(localObject[2]);
        locala.mzZ = Util.safeParseLong(localObject[3]);
        locala.Pyz = Util.safeParseInt(localObject[4]);
        locala.type = Util.safeParseInt(localObject[5]);
        locala.text = localObject[6];
        locala.icon = localObject[7];
        locala.timestamp = Util.safeParseLong(localObject[8]);
        locala.PzH = Util.safeParseInt(localObject[9]);
        locala.lKF = Util.safeParseLong(localObject[10]);
        locala.PzI = Util.safeParseInt(localObject[11]);
      }
      AppMethodBeat.o(117760);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchRedPointMgr", localException, "", new Object[0]);
      AppMethodBeat.o(117760);
    }
  }
  
  public static aq gQV()
  {
    return PzE;
  }
  
  public static long gQW()
  {
    AppMethodBeat.i(117762);
    Object localObject = h.aHG().aHp().get(ar.a.VuK, null);
    if (localObject == null)
    {
      AppMethodBeat.o(117762);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(117762);
    return l;
  }
  
  public final void anm(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117763);
    if (this.PzC != null)
    {
      boolean bool = this.PzC.isValid();
      if ((this.PzD) && (paramInt == 1) && (!bool))
      {
        AppMethodBeat.o(117763);
        return;
      }
      String str2 = this.PzC.id;
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
      Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "report websearch reddot 17513: ".concat(String.valueOf(str1)));
      com.tencent.mm.plugin.report.f.Iyx.kvStat(17513, str1);
      if ((paramInt == 1) && (!bool)) {
        this.PzD = true;
      }
    }
    AppMethodBeat.o(117763);
  }
  
  public final void arg()
  {
    AppMethodBeat.i(117761);
    if (this.PzC == null) {}
    for (String str = "";; str = this.PzC.bRQ())
    {
      h.aHG().aHp().set(ar.a.VrC, str);
      AppMethodBeat.o(117761);
      return;
    }
  }
  
  public static final class a
  {
    public int Pyz;
    public int PzF;
    public int PzG;
    public int PzH;
    int PzI;
    public int clear;
    public String icon;
    public String id;
    public long lKF;
    public long mzZ;
    public String text;
    public long timestamp;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(117756);
      this.lKF = System.currentTimeMillis();
      AppMethodBeat.o(117756);
    }
    
    private boolean isExpired()
    {
      AppMethodBeat.i(117757);
      if (System.currentTimeMillis() > this.lKF + this.mzZ * 1000L)
      {
        AppMethodBeat.o(117757);
        return true;
      }
      AppMethodBeat.o(117757);
      return false;
    }
    
    final String bRQ()
    {
      AppMethodBeat.i(117759);
      String str = this.id + "&" + this.PzF + "&" + this.PzG + "&" + this.mzZ + "&" + this.Pyz + "&" + this.type + "&" + this.text + "&" + this.icon + "&" + this.timestamp + "&" + this.PzH + "&" + this.lKF + "&" + this.PzI;
      AppMethodBeat.o(117759);
      return str;
    }
    
    public final boolean isValid()
    {
      AppMethodBeat.i(117758);
      if (this.clear == 1)
      {
        AppMethodBeat.o(117758);
        return false;
      }
      if (this.PzG > d.RAD)
      {
        Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.id, Integer.valueOf(this.PzG), Integer.valueOf(d.RAD) });
        AppMethodBeat.o(117758);
        return false;
      }
      if (isExpired())
      {
        Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", new Object[] { this.id });
        AppMethodBeat.o(117758);
        return false;
      }
      String str = this.PzF + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
      if (ai.anh(0) >= this.Pyz) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", str, new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Pyz), Integer.valueOf(ai.anh(0)), Long.valueOf(this.timestamp), Long.valueOf(aq.gQW()) });
        if ((ai.anh(0) < this.Pyz) || (this.timestamp <= aq.gQW())) {
          break;
        }
        AppMethodBeat.o(117758);
        return true;
      }
      AppMethodBeat.o(117758);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aq
 * JD-Core Version:    0.7.0.1
 */