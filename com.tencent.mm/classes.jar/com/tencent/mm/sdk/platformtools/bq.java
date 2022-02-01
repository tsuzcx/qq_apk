package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class bq
{
  private String Guu;
  ArrayList<Long> Guv;
  ArrayList<String> Guw;
  private boolean lDp;
  private String mTag;
  
  public bq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157843);
    this.mTag = paramString1;
    this.Guu = paramString2;
    this.lDp = false;
    if (!this.lDp)
    {
      if (this.Guv != null) {
        break label71;
      }
      this.Guv = new ArrayList();
      this.Guw = new ArrayList();
    }
    for (;;)
    {
      addSplit(null);
      AppMethodBeat.o(157843);
      return;
      label71:
      this.Guv.clear();
      this.Guw.clear();
    }
  }
  
  public final void addSplit(String paramString)
  {
    AppMethodBeat.i(157844);
    if (this.lDp)
    {
      AppMethodBeat.o(157844);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.Guv.add(Long.valueOf(l));
    this.Guw.add(paramString);
    AppMethodBeat.o(157844);
  }
  
  public final void dumpToLog()
  {
    AppMethodBeat.i(157845);
    if (this.lDp)
    {
      AppMethodBeat.o(157845);
      return;
    }
    ac.d(this.mTag, this.Guu + ": begin");
    long l2 = ((Long)this.Guv.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    while (i < this.Guv.size())
    {
      l1 = ((Long)this.Guv.get(i)).longValue();
      String str = (String)this.Guw.get(i);
      long l3 = ((Long)this.Guv.get(i - 1)).longValue();
      ac.d(this.mTag, this.Guu + ":      " + (l1 - l3) + " ms, " + str);
      i += 1;
    }
    ac.d(this.mTag, this.Guu + ": end, " + (l1 - l2) + " ms");
    AppMethodBeat.o(157845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bq
 * JD-Core Version:    0.7.0.1
 */