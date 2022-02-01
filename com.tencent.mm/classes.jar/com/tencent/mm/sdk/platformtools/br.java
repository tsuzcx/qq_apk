package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class br
{
  private String Igp;
  ArrayList<Long> Igq;
  ArrayList<String> Igr;
  private String mTag;
  private boolean mcS;
  
  public br(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157843);
    this.mTag = paramString1;
    this.Igp = paramString2;
    this.mcS = false;
    if (!this.mcS)
    {
      if (this.Igq != null) {
        break label71;
      }
      this.Igq = new ArrayList();
      this.Igr = new ArrayList();
    }
    for (;;)
    {
      addSplit(null);
      AppMethodBeat.o(157843);
      return;
      label71:
      this.Igq.clear();
      this.Igr.clear();
    }
  }
  
  public final void addSplit(String paramString)
  {
    AppMethodBeat.i(157844);
    if (this.mcS)
    {
      AppMethodBeat.o(157844);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.Igq.add(Long.valueOf(l));
    this.Igr.add(paramString);
    AppMethodBeat.o(157844);
  }
  
  public final void dumpToLog()
  {
    AppMethodBeat.i(157845);
    if (this.mcS)
    {
      AppMethodBeat.o(157845);
      return;
    }
    ad.d(this.mTag, this.Igp + ": begin");
    long l2 = ((Long)this.Igq.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    while (i < this.Igq.size())
    {
      l1 = ((Long)this.Igq.get(i)).longValue();
      String str = (String)this.Igr.get(i);
      long l3 = ((Long)this.Igq.get(i - 1)).longValue();
      ad.d(this.mTag, this.Igp + ":      " + (l1 - l3) + " ms, " + str);
      i += 1;
    }
    ad.d(this.mTag, this.Igp + ": end, " + (l1 - l2) + " ms");
    AppMethodBeat.o(157845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.br
 * JD-Core Version:    0.7.0.1
 */