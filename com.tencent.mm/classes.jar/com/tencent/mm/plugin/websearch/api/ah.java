package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class ah
{
  private static ah BZy;
  public a BZw;
  private boolean BZx;
  
  static
  {
    AppMethodBeat.i(117764);
    BZy = new ah();
    AppMethodBeat.o(117764);
  }
  
  private ah()
  {
    AppMethodBeat.i(117760);
    Object localObject = (String)g.agR().agA().get(com.tencent.mm.storage.ah.a.GOg, "");
    this.BZw = new a();
    a locala = this.BZw;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("&");
        locala.id = bs.u(localObject[0], new Object[0]);
        locala.BZz = bs.aLy(localObject[1]);
        locala.BZA = bs.aLy(localObject[2]);
        locala.ipQ = bs.aLz(localObject[3]);
        locala.BYF = bs.aLy(localObject[4]);
        locala.type = bs.aLy(localObject[5]);
        locala.text = localObject[6];
        locala.drM = localObject[7];
        locala.timestamp = bs.aLz(localObject[8]);
        locala.BZB = bs.aLy(localObject[9]);
        locala.hDR = bs.aLz(localObject[10]);
        locala.BZC = bs.aLy(localObject[11]);
      }
      AppMethodBeat.o(117760);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchRedPointMgr", localException, "", new Object[0]);
      AppMethodBeat.o(117760);
    }
  }
  
  public static ah exx()
  {
    return BZy;
  }
  
  public static long exy()
  {
    AppMethodBeat.i(117762);
    Object localObject = g.agR().agA().get(com.tencent.mm.storage.ah.a.GRa, null);
    if (localObject == null)
    {
      AppMethodBeat.o(117762);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(117762);
    return l;
  }
  
  public final void Uq(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117763);
    if (this.BZw != null)
    {
      boolean bool = this.BZw.isValid();
      if ((this.BZx) && (paramInt == 1) && (!bool))
      {
        AppMethodBeat.o(117763);
        return;
      }
      String str2 = this.BZw.id;
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
      ac.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "report websearch reddot 17513: ".concat(String.valueOf(str1)));
      com.tencent.mm.plugin.report.e.wTc.kvStat(17513, str1);
      if ((paramInt == 1) && (!bool)) {
        this.BZx = true;
      }
    }
    AppMethodBeat.o(117763);
  }
  
  public final void save()
  {
    AppMethodBeat.i(117761);
    if (this.BZw == null) {}
    for (String str = "";; str = this.BZw.bgx())
    {
      g.agR().agA().set(com.tencent.mm.storage.ah.a.GOg, str);
      AppMethodBeat.o(117761);
      return;
    }
  }
  
  public static final class a
  {
    public int BYF;
    public int BZA;
    public int BZB;
    int BZC;
    public int BZz;
    public int clear;
    public String drM;
    public long hDR;
    public String id;
    public long ipQ;
    public String text;
    public long timestamp;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(117756);
      this.hDR = System.currentTimeMillis();
      AppMethodBeat.o(117756);
    }
    
    private boolean isExpired()
    {
      AppMethodBeat.i(117757);
      if (System.currentTimeMillis() > this.hDR + this.ipQ * 1000L)
      {
        AppMethodBeat.o(117757);
        return true;
      }
      AppMethodBeat.o(117757);
      return false;
    }
    
    final String bgx()
    {
      AppMethodBeat.i(117759);
      String str = this.id + "&" + this.BZz + "&" + this.BZA + "&" + this.ipQ + "&" + this.BYF + "&" + this.type + "&" + this.text + "&" + this.drM + "&" + this.timestamp + "&" + this.BZB + "&" + this.hDR + "&" + this.BZC;
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
      if (this.BZA > d.DIc)
      {
        ac.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.id, Integer.valueOf(this.BZA), Integer.valueOf(d.DIc) });
        AppMethodBeat.o(117758);
        return false;
      }
      if (isExpired())
      {
        ac.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", new Object[] { this.id });
        AppMethodBeat.o(117758);
        return false;
      }
      String str = this.BZz + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
      if (z.Ul(0) >= this.BYF) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.WebSearch.WebSearchRedPointMgr", str, new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BYF), Integer.valueOf(z.Ul(0)), Long.valueOf(this.timestamp), Long.valueOf(ah.exy()) });
        if ((z.Ul(0) < this.BYF) || (this.timestamp <= ah.exy())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ah
 * JD-Core Version:    0.7.0.1
 */