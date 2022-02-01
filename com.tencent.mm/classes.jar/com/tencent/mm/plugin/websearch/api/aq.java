package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class aq
{
  private static aq IFm;
  public a IFk;
  private boolean IFl;
  
  static
  {
    AppMethodBeat.i(117764);
    IFm = new aq();
    AppMethodBeat.o(117764);
  }
  
  private aq()
  {
    AppMethodBeat.i(117760);
    Object localObject = (String)g.aAh().azQ().get(ar.a.Ods, "");
    this.IFk = new a();
    a locala = this.IFk;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("&");
        locala.id = Util.safeFormatString(localObject[0], new Object[0]);
        locala.IFn = Util.safeParseInt(localObject[1]);
        locala.IFo = Util.safeParseInt(localObject[2]);
        locala.jIU = Util.safeParseLong(localObject[3]);
        locala.IEj = Util.safeParseInt(localObject[4]);
        locala.type = Util.safeParseInt(localObject[5]);
        locala.text = localObject[6];
        locala.icon = localObject[7];
        locala.timestamp = Util.safeParseLong(localObject[8]);
        locala.IFp = Util.safeParseInt(localObject[9]);
        locala.iUm = Util.safeParseLong(localObject[10]);
        locala.IFq = Util.safeParseInt(localObject[11]);
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
  
  public static aq fYk()
  {
    return IFm;
  }
  
  public static long fYl()
  {
    AppMethodBeat.i(117762);
    Object localObject = g.aAh().azQ().get(ar.a.Ogu, null);
    if (localObject == null)
    {
      AppMethodBeat.o(117762);
      return 0L;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(117762);
    return l;
  }
  
  public final void afy(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117763);
    if (this.IFk != null)
    {
      boolean bool = this.IFk.isValid();
      if ((this.IFl) && (paramInt == 1) && (!bool))
      {
        AppMethodBeat.o(117763);
        return;
      }
      String str2 = this.IFk.id;
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
      com.tencent.mm.plugin.report.e.Cxv.kvStat(17513, str1);
      if ((paramInt == 1) && (!bool)) {
        this.IFl = true;
      }
    }
    AppMethodBeat.o(117763);
  }
  
  public final void save()
  {
    AppMethodBeat.i(117761);
    if (this.IFk == null) {}
    for (String str = "";; str = this.IFk.bGg())
    {
      g.aAh().azQ().set(ar.a.Ods, str);
      AppMethodBeat.o(117761);
      return;
    }
  }
  
  public static final class a
  {
    public int IEj;
    public int IFn;
    public int IFo;
    public int IFp;
    int IFq;
    public int clear;
    public long iUm;
    public String icon;
    public String id;
    public long jIU;
    public String text;
    public long timestamp;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(117756);
      this.iUm = System.currentTimeMillis();
      AppMethodBeat.o(117756);
    }
    
    private boolean isExpired()
    {
      AppMethodBeat.i(117757);
      if (System.currentTimeMillis() > this.iUm + this.jIU * 1000L)
      {
        AppMethodBeat.o(117757);
        return true;
      }
      AppMethodBeat.o(117757);
      return false;
    }
    
    final String bGg()
    {
      AppMethodBeat.i(117759);
      String str = this.id + "&" + this.IFn + "&" + this.IFo + "&" + this.jIU + "&" + this.IEj + "&" + this.type + "&" + this.text + "&" + this.icon + "&" + this.timestamp + "&" + this.IFp + "&" + this.iUm + "&" + this.IFq;
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
      if (this.IFo > d.KyO)
      {
        Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[] { this.id, Integer.valueOf(this.IFo), Integer.valueOf(d.KyO) });
        AppMethodBeat.o(117758);
        return false;
      }
      if (isExpired())
      {
        Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", new Object[] { this.id });
        AppMethodBeat.o(117758);
        return false;
      }
      String str = this.IFn + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
      if (ai.aft(0) >= this.IEj) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.WebSearch.WebSearchRedPointMgr", str, new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IEj), Integer.valueOf(ai.aft(0)), Long.valueOf(this.timestamp), Long.valueOf(aq.fYl()) });
        if ((ai.aft(0) < this.IEj) || (this.timestamp <= aq.fYl())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aq
 * JD-Core Version:    0.7.0.1
 */