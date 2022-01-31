package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class bm
{
  private boolean ixN;
  private String mTag;
  private String yqB;
  ArrayList<Long> yqC;
  ArrayList<String> yqD;
  
  public bm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52283);
    this.mTag = paramString1;
    this.yqB = paramString2;
    this.ixN = false;
    if (!this.ixN)
    {
      if (this.yqC != null) {
        break label71;
      }
      this.yqC = new ArrayList();
      this.yqD = new ArrayList();
    }
    for (;;)
    {
      addSplit(null);
      AppMethodBeat.o(52283);
      return;
      label71:
      this.yqC.clear();
      this.yqD.clear();
    }
  }
  
  public final void addSplit(String paramString)
  {
    AppMethodBeat.i(52284);
    if (this.ixN)
    {
      AppMethodBeat.o(52284);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.yqC.add(Long.valueOf(l));
    this.yqD.add(paramString);
    AppMethodBeat.o(52284);
  }
  
  public final void dumpToLog()
  {
    AppMethodBeat.i(52285);
    if (this.ixN)
    {
      AppMethodBeat.o(52285);
      return;
    }
    ab.d(this.mTag, this.yqB + ": begin");
    long l2 = ((Long)this.yqC.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    while (i < this.yqC.size())
    {
      l1 = ((Long)this.yqC.get(i)).longValue();
      String str = (String)this.yqD.get(i);
      long l3 = ((Long)this.yqC.get(i - 1)).longValue();
      ab.d(this.mTag, this.yqB + ":      " + (l1 - l3) + " ms, " + str);
      i += 1;
    }
    ab.d(this.mTag, this.yqB + ": end, " + (l1 - l2) + " ms");
    AppMethodBeat.o(52285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bm
 * JD-Core Version:    0.7.0.1
 */