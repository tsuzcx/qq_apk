package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class al
{
  private static al DCu;
  public a DCs;
  private boolean DCt;
  
  static
  {
    AppMethodBeat.i(117764);
    DCu = new al();
    AppMethodBeat.o(117764);
  }
  
  private al()
  {
    AppMethodBeat.i(117760);
    Object localObject = (String)g.ajC().ajl().get(com.tencent.mm.storage.al.a.IAB, "");
    this.DCs = new a();
    a locala = this.DCs;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("&");
        locala.id = bt.x(localObject[0], new Object[0]);
        locala.DCv = bt.aRe(localObject[1]);
        locala.DCw = bt.aRe(localObject[2]);
        locala.iJn = bt.aRf(localObject[3]);
        locala.DBB = bt.aRe(localObject[4]);
        locala.type = bt.aRe(localObject[5]);
        locala.text = localObject[6];
        locala.dDH = localObject[7];
        locala.timestamp = bt.aRf(localObject[8]);
        locala.DCx = bt.aRe(localObject[9]);
        locala.hWw = bt.aRf(localObject[10]);
        locala.DCy = bt.aRe(localObject[11]);
      }
      AppMethodBeat.o(117760);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchRedPointMgr", localException, "", new Object[0]);
      AppMethodBeat.o(117760);
    }
  }
  
  public static al eMo()
  {
    return DCu;
  }
  
  public static long eMp()
  {
    AppMethodBeat.i(117762);
    Object localObject = g.ajC().ajl().get(com.tencent.mm.storage.al.a.IDx, null);
    if (localObject == null)
    {
      AppMethodBeat.o(117762);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(117762);
    return l;
  }
  
  public final void Wj(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117763);
    if (this.DCs != null)
    {
      boolean bool = this.DCs.isValid();
      if ((this.DCt) && (paramInt == 1) && (!bool))
      {
        AppMethodBeat.o(117763);
        return;
      }
      String str2 = this.DCs.id;
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "report websearch reddot 17513: ".concat(String.valueOf(str1)));
      com.tencent.mm.plugin.report.e.ygI.kvStat(17513, str1);
      if ((paramInt == 1) && (!bool)) {
        this.DCt = true;
      }
    }
    AppMethodBeat.o(117763);
  }
  
  public final void save()
  {
    AppMethodBeat.i(117761);
    if (this.DCs == null) {}
    for (String str = "";; str = this.DCs.bkb())
    {
      g.ajC().ajl().set(com.tencent.mm.storage.al.a.IAB, str);
      AppMethodBeat.o(117761);
      return;
    }
  }
  
  public static final class a
  {
    public int DBB;
    public int DCv;
    public int DCw;
    public int DCx;
    int DCy;
    public int clear;
    public String dDH;
    public long hWw;
    public long iJn;
    public String id;
    public String text;
    public long timestamp;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(117756);
      this.hWw = System.currentTimeMillis();
      AppMethodBeat.o(117756);
    }
    
    private boolean isExpired()
    {
      AppMethodBeat.i(117757);
      if (System.currentTimeMillis() > this.hWw + this.iJn * 1000L)
      {
        AppMethodBeat.o(117757);
        return true;
      }
      AppMethodBeat.o(117757);
      return false;
    }
    
    final String bkb()
    {
      AppMethodBeat.i(117759);
      String str = this.id + "&" + this.DCv + "&" + this.DCw + "&" + this.iJn + "&" + this.DBB + "&" + this.type + "&" + this.text + "&" + this.dDH + "&" + this.timestamp + "&" + this.DCx + "&" + this.hWw + "&" + this.DCy;
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
      if (this.DCw > d.Fnj)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.id, Integer.valueOf(this.DCw), Integer.valueOf(d.Fnj) });
        AppMethodBeat.o(117758);
        return false;
      }
      if (isExpired())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", new Object[] { this.id });
        AppMethodBeat.o(117758);
        return false;
      }
      String str = this.DCv + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
      if (ad.We(0) >= this.DBB) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchRedPointMgr", str, new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DBB), Integer.valueOf(ad.We(0)), Long.valueOf(this.timestamp), Long.valueOf(al.eMp()) });
        if ((ad.We(0) < this.DBB) || (this.timestamp <= al.eMp())) {
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
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.al
 * JD-Core Version:    0.7.0.1
 */