package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class br
{
  private String EXi;
  ArrayList<Long> EXj;
  ArrayList<String> EXk;
  private boolean ldy;
  private String mTag;
  
  public br(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157843);
    this.mTag = paramString1;
    this.EXi = paramString2;
    this.ldy = false;
    if (!this.ldy)
    {
      if (this.EXj != null) {
        break label71;
      }
      this.EXj = new ArrayList();
      this.EXk = new ArrayList();
    }
    for (;;)
    {
      addSplit(null);
      AppMethodBeat.o(157843);
      return;
      label71:
      this.EXj.clear();
      this.EXk.clear();
    }
  }
  
  public final void addSplit(String paramString)
  {
    AppMethodBeat.i(157844);
    if (this.ldy)
    {
      AppMethodBeat.o(157844);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.EXj.add(Long.valueOf(l));
    this.EXk.add(paramString);
    AppMethodBeat.o(157844);
  }
  
  public final void dumpToLog()
  {
    AppMethodBeat.i(157845);
    if (this.ldy)
    {
      AppMethodBeat.o(157845);
      return;
    }
    ad.d(this.mTag, this.EXi + ": begin");
    long l2 = ((Long)this.EXj.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    while (i < this.EXj.size())
    {
      l1 = ((Long)this.EXj.get(i)).longValue();
      String str = (String)this.EXk.get(i);
      long l3 = ((Long)this.EXj.get(i - 1)).longValue();
      ad.d(this.mTag, this.EXi + ":      " + (l1 - l3) + " ms, " + str);
      i += 1;
    }
    ad.d(this.mTag, this.EXi + ": end, " + (l1 - l2) + " ms");
    AppMethodBeat.o(157845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.br
 * JD-Core Version:    0.7.0.1
 */