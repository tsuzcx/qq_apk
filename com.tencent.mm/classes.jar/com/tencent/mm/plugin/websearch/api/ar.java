package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class ar
{
  private static ar WpM;
  public a WpK;
  private boolean WpL;
  
  static
  {
    AppMethodBeat.i(117764);
    WpM = new ar();
    AppMethodBeat.o(117764);
  }
  
  private ar()
  {
    AppMethodBeat.i(117760);
    Object localObject = (String)h.baE().ban().get(at.a.acTg, "");
    this.WpK = new a();
    a locala = this.WpK;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("&");
        locala.id = Util.safeFormatString(localObject[0], new Object[0]);
        locala.WpN = Util.safeParseInt(localObject[1]);
        locala.WpO = Util.safeParseInt(localObject[2]);
        locala.pwJ = Util.safeParseLong(localObject[3]);
        locala.WoG = Util.safeParseInt(localObject[4]);
        locala.type = Util.safeParseInt(localObject[5]);
        locala.text = localObject[6];
        locala.icon = localObject[7];
        locala.timestamp = Util.safeParseLong(localObject[8]);
        locala.WpP = Util.safeParseInt(localObject[9]);
        locala.oDh = Util.safeParseLong(localObject[10]);
        locala.WpQ = Util.safeParseInt(localObject[11]);
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
  
  public static ar iqh()
  {
    return WpM;
  }
  
  public static long iqi()
  {
    AppMethodBeat.i(117762);
    Object localObject = h.baE().ban().get(at.a.acWt, null);
    if (localObject == null)
    {
      AppMethodBeat.o(117762);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(117762);
    return l;
  }
  
  public final void atd(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117763);
    if (this.WpK != null)
    {
      boolean bool = this.WpK.isValid();
      if ((this.WpL) && (paramInt == 1) && (!bool))
      {
        AppMethodBeat.o(117763);
        return;
      }
      String str2 = this.WpK.id;
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
      com.tencent.mm.plugin.report.f.Ozc.kvStat(17513, str1);
      if ((paramInt == 1) && (!bool)) {
        this.WpL = true;
      }
    }
    AppMethodBeat.o(117763);
  }
  
  public final void sz()
  {
    AppMethodBeat.i(117761);
    if (this.WpK == null) {}
    for (String str = "";; str = this.WpK.crV())
    {
      h.baE().ban().set(at.a.acTg, str);
      AppMethodBeat.o(117761);
      return;
    }
  }
  
  public static final class a
  {
    public int WoG;
    public int WpN;
    public int WpO;
    public int WpP;
    int WpQ;
    public int clear;
    public String icon;
    public String id;
    public long oDh;
    public long pwJ;
    public String text;
    public long timestamp;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(117756);
      this.oDh = System.currentTimeMillis();
      AppMethodBeat.o(117756);
    }
    
    private boolean isExpired()
    {
      AppMethodBeat.i(117757);
      if (System.currentTimeMillis() > this.oDh + this.pwJ * 1000L)
      {
        AppMethodBeat.o(117757);
        return true;
      }
      AppMethodBeat.o(117757);
      return false;
    }
    
    final String crV()
    {
      AppMethodBeat.i(117759);
      String str = this.id + "&" + this.WpN + "&" + this.WpO + "&" + this.pwJ + "&" + this.WoG + "&" + this.type + "&" + this.text + "&" + this.icon + "&" + this.timestamp + "&" + this.WpP + "&" + this.oDh + "&" + this.WpQ;
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
      if (this.WpO > d.Yxh)
      {
        Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.id, Integer.valueOf(this.WpO), Integer.valueOf(d.Yxh) });
        AppMethodBeat.o(117758);
        return false;
      }
      if (isExpired())
      {
        Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", new Object[] { this.id });
        AppMethodBeat.o(117758);
        return false;
      }
      String str = this.WpN + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
      if (aj.asY(0) >= this.WoG) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", str, new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.WoG), Integer.valueOf(aj.asY(0)), Long.valueOf(this.timestamp), Long.valueOf(ar.iqi()) });
        if ((aj.asY(0) < this.WoG) || (this.timestamp <= ar.iqi())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ar
 * JD-Core Version:    0.7.0.1
 */