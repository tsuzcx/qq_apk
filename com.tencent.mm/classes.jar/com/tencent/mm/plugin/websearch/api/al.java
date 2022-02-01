package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class al
{
  private static al DUr;
  public a DUp;
  private boolean DUq;
  
  static
  {
    AppMethodBeat.i(117764);
    DUr = new al();
    AppMethodBeat.o(117764);
  }
  
  private al()
  {
    AppMethodBeat.i(117760);
    Object localObject = (String)g.ajR().ajA().get(am.a.IVa, "");
    this.DUp = new a();
    a locala = this.DUp;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("&");
        locala.id = bu.x(localObject[0], new Object[0]);
        locala.DUs = bu.aSB(localObject[1]);
        locala.DUt = bu.aSB(localObject[2]);
        locala.iMg = bu.aSC(localObject[3]);
        locala.DTy = bu.aSB(localObject[4]);
        locala.type = bu.aSB(localObject[5]);
        locala.text = localObject[6];
        locala.dEM = localObject[7];
        locala.timestamp = bu.aSC(localObject[8]);
        locala.DUu = bu.aSB(localObject[9]);
        locala.hZo = bu.aSC(localObject[10]);
        locala.DUv = bu.aSB(localObject[11]);
      }
      AppMethodBeat.o(117760);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchRedPointMgr", localException, "", new Object[0]);
      AppMethodBeat.o(117760);
    }
  }
  
  public static al ePX()
  {
    return DUr;
  }
  
  public static long ePY()
  {
    AppMethodBeat.i(117762);
    Object localObject = g.ajR().ajA().get(am.a.IXX, null);
    if (localObject == null)
    {
      AppMethodBeat.o(117762);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(117762);
    return l;
  }
  
  public final void WQ(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117763);
    if (this.DUp != null)
    {
      boolean bool = this.DUp.isValid();
      if ((this.DUq) && (paramInt == 1) && (!bool))
      {
        AppMethodBeat.o(117763);
        return;
      }
      String str2 = this.DUp.id;
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
      ae.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "report websearch reddot 17513: ".concat(String.valueOf(str1)));
      com.tencent.mm.plugin.report.e.ywz.kvStat(17513, str1);
      if ((paramInt == 1) && (!bool)) {
        this.DUq = true;
      }
    }
    AppMethodBeat.o(117763);
  }
  
  public final void save()
  {
    AppMethodBeat.i(117761);
    if (this.DUp == null) {}
    for (String str = "";; str = this.DUp.bkK())
    {
      g.ajR().ajA().set(am.a.IVa, str);
      AppMethodBeat.o(117761);
      return;
    }
  }
  
  public static final class a
  {
    public int DTy;
    public int DUs;
    public int DUt;
    public int DUu;
    int DUv;
    public int clear;
    public String dEM;
    public long hZo;
    public long iMg;
    public String id;
    public String text;
    public long timestamp;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(117756);
      this.hZo = System.currentTimeMillis();
      AppMethodBeat.o(117756);
    }
    
    private boolean isExpired()
    {
      AppMethodBeat.i(117757);
      if (System.currentTimeMillis() > this.hZo + this.iMg * 1000L)
      {
        AppMethodBeat.o(117757);
        return true;
      }
      AppMethodBeat.o(117757);
      return false;
    }
    
    final String bkK()
    {
      AppMethodBeat.i(117759);
      String str = this.id + "&" + this.DUs + "&" + this.DUt + "&" + this.iMg + "&" + this.DTy + "&" + this.type + "&" + this.text + "&" + this.dEM + "&" + this.timestamp + "&" + this.DUu + "&" + this.hZo + "&" + this.DUv;
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
      if (this.DUt > d.FFH)
      {
        ae.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.id, Integer.valueOf(this.DUt), Integer.valueOf(d.FFH) });
        AppMethodBeat.o(117758);
        return false;
      }
      if (isExpired())
      {
        ae.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", new Object[] { this.id });
        AppMethodBeat.o(117758);
        return false;
      }
      String str = this.DUs + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
      if (ad.WL(0) >= this.DTy) {}
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.WebSearch.WebSearchRedPointMgr", str, new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DTy), Integer.valueOf(ad.WL(0)), Long.valueOf(this.timestamp), Long.valueOf(al.ePY()) });
        if ((ad.WL(0) < this.DTy) || (this.timestamp <= al.ePY())) {
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