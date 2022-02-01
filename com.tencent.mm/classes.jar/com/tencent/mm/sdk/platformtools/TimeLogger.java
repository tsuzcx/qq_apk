package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class TimeLogger
{
  private boolean mDisabled;
  private String mLabel;
  ArrayList<String> mSplitLabels;
  ArrayList<Long> mSplits;
  private String mTag;
  
  public TimeLogger(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157843);
    reset(paramString1, paramString2);
    AppMethodBeat.o(157843);
  }
  
  public void addSplit(String paramString)
  {
    AppMethodBeat.i(157844);
    if (this.mDisabled)
    {
      AppMethodBeat.o(157844);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.mSplits.add(Long.valueOf(l));
    this.mSplitLabels.add(paramString);
    AppMethodBeat.o(157844);
  }
  
  public void dumpToLog()
  {
    AppMethodBeat.i(157845);
    if (this.mDisabled)
    {
      AppMethodBeat.o(157845);
      return;
    }
    Log.d(this.mTag, this.mLabel + ": begin");
    long l2 = ((Long)this.mSplits.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    while (i < this.mSplits.size())
    {
      l1 = ((Long)this.mSplits.get(i)).longValue();
      String str = (String)this.mSplitLabels.get(i);
      long l3 = ((Long)this.mSplits.get(i - 1)).longValue();
      Log.d(this.mTag, this.mLabel + ":      " + (l1 - l3) + " ms, " + str);
      i += 1;
    }
    Log.d(this.mTag, this.mLabel + ": end, " + (l1 - l2) + " ms");
    AppMethodBeat.o(157845);
  }
  
  public void reset()
  {
    AppMethodBeat.i(230401);
    this.mDisabled = false;
    if (this.mDisabled)
    {
      AppMethodBeat.o(230401);
      return;
    }
    if (this.mSplits == null)
    {
      this.mSplits = new ArrayList();
      this.mSplitLabels = new ArrayList();
    }
    for (;;)
    {
      addSplit(null);
      AppMethodBeat.o(230401);
      return;
      this.mSplits.clear();
      this.mSplitLabels.clear();
    }
  }
  
  public void reset(String paramString1, String paramString2)
  {
    AppMethodBeat.i(230400);
    this.mTag = paramString1;
    this.mLabel = paramString2;
    reset();
    AppMethodBeat.o(230400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.TimeLogger
 * JD-Core Version:    0.7.0.1
 */