package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class aj
{
  private static aj AHh;
  public a AHf;
  private boolean AHg;
  
  static
  {
    AppMethodBeat.i(117764);
    AHh = new aj();
    AppMethodBeat.o(117764);
  }
  
  private aj()
  {
    AppMethodBeat.i(117760);
    Object localObject = (String)g.afB().afk().get(ae.a.Fqq, "");
    this.AHf = new a();
    a locala = this.AHf;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("&");
        locala.id = bt.u(localObject[0], new Object[0]);
        locala.AHi = bt.aGh(localObject[1]);
        locala.AHj = bt.aGh(localObject[2]);
        locala.hPv = bt.aGi(localObject[3]);
        locala.AGn = bt.aGh(localObject[4]);
        locala.type = bt.aGh(localObject[5]);
        locala.text = localObject[6];
        locala.dub = localObject[7];
        locala.timestamp = bt.aGi(localObject[8]);
        locala.AHk = bt.aGh(localObject[9]);
        locala.hdo = bt.aGi(localObject[10]);
        locala.AHl = bt.aGh(localObject[11]);
      }
      AppMethodBeat.o(117760);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchRedPointMgr", localException, "", new Object[0]);
      AppMethodBeat.o(117760);
    }
  }
  
  public static aj eid()
  {
    return AHh;
  }
  
  public static long eie()
  {
    AppMethodBeat.i(117762);
    Object localObject = g.afB().afk().get(ae.a.Ftg, null);
    if (localObject == null)
    {
      AppMethodBeat.o(117762);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(117762);
    return l;
  }
  
  public final void Sh(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117763);
    if (this.AHf != null)
    {
      boolean bool = this.AHf.isValid();
      if ((this.AHg) && (paramInt == 1) && (!bool))
      {
        AppMethodBeat.o(117763);
        return;
      }
      String str2 = this.AHf.id;
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
      ad.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "report websearch reddot 17513: ".concat(String.valueOf(str1)));
      com.tencent.mm.plugin.report.e.vIY.kvStat(17513, str1);
      if ((paramInt == 1) && (!bool)) {
        this.AHg = true;
      }
    }
    AppMethodBeat.o(117763);
  }
  
  public final void save()
  {
    AppMethodBeat.i(117761);
    if (this.AHf == null) {}
    for (String str = "";; str = this.AHf.aZF())
    {
      g.afB().afk().set(ae.a.Fqq, str);
      AppMethodBeat.o(117761);
      return;
    }
  }
  
  public static final class a
  {
    public int AGn;
    public int AHi;
    public int AHj;
    public int AHk;
    int AHl;
    public int clear;
    public String dub;
    public long hPv;
    public long hdo;
    public String id;
    public String text;
    public long timestamp;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(117756);
      this.hdo = System.currentTimeMillis();
      AppMethodBeat.o(117756);
    }
    
    private boolean isExpired()
    {
      AppMethodBeat.i(117757);
      if (System.currentTimeMillis() > this.hdo + this.hPv * 1000L)
      {
        AppMethodBeat.o(117757);
        return true;
      }
      AppMethodBeat.o(117757);
      return false;
    }
    
    final String aZF()
    {
      AppMethodBeat.i(117759);
      String str = this.id + "&" + this.AHi + "&" + this.AHj + "&" + this.hPv + "&" + this.AGn + "&" + this.type + "&" + this.text + "&" + this.dub + "&" + this.timestamp + "&" + this.AHk + "&" + this.hdo + "&" + this.AHl;
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
      if (this.AHj > d.CpK)
      {
        ad.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.id, Integer.valueOf(this.AHj), Integer.valueOf(d.CpK) });
        AppMethodBeat.o(117758);
        return false;
      }
      if (isExpired())
      {
        ad.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", new Object[] { this.id });
        AppMethodBeat.o(117758);
        return false;
      }
      String str = this.AHi + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
      if (aa.Sb(0) >= this.AGn) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.WebSearch.WebSearchRedPointMgr", str, new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.AGn), Integer.valueOf(aa.Sb(0)), Long.valueOf(this.timestamp), Long.valueOf(aj.eie()) });
        if ((aa.Sb(0) < this.AGn) || (this.timestamp <= aj.eie())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aj
 * JD-Core Version:    0.7.0.1
 */