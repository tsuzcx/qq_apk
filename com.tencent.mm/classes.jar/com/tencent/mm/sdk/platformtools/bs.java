package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class bs
{
  private String IAA;
  ArrayList<Long> IAB;
  ArrayList<String> IAC;
  private String mTag;
  private boolean mhk;
  
  public bs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157843);
    this.mTag = paramString1;
    this.IAA = paramString2;
    this.mhk = false;
    if (!this.mhk)
    {
      if (this.IAB != null) {
        break label71;
      }
      this.IAB = new ArrayList();
      this.IAC = new ArrayList();
    }
    for (;;)
    {
      addSplit(null);
      AppMethodBeat.o(157843);
      return;
      label71:
      this.IAB.clear();
      this.IAC.clear();
    }
  }
  
  public final void addSplit(String paramString)
  {
    AppMethodBeat.i(157844);
    if (this.mhk)
    {
      AppMethodBeat.o(157844);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.IAB.add(Long.valueOf(l));
    this.IAC.add(paramString);
    AppMethodBeat.o(157844);
  }
  
  public final void dumpToLog()
  {
    AppMethodBeat.i(157845);
    if (this.mhk)
    {
      AppMethodBeat.o(157845);
      return;
    }
    ae.d(this.mTag, this.IAA + ": begin");
    long l2 = ((Long)this.IAB.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    while (i < this.IAB.size())
    {
      l1 = ((Long)this.IAB.get(i)).longValue();
      String str = (String)this.IAC.get(i);
      long l3 = ((Long)this.IAB.get(i - 1)).longValue();
      ae.d(this.mTag, this.IAA + ":      " + (l1 - l3) + " ms, " + str);
      i += 1;
    }
    ae.d(this.mTag, this.IAA + ": end, " + (l1 - l2) + " ms");
    AppMethodBeat.o(157845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bs
 * JD-Core Version:    0.7.0.1
 */