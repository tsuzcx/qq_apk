package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;

public final class bi
{
  private boolean gUE;
  private String mTag;
  ArrayList<String> uiA;
  private String uiy;
  ArrayList<Long> uiz;
  
  public bi(String paramString1, String paramString2)
  {
    this.mTag = paramString1;
    this.uiy = paramString2;
    this.gUE = false;
    if (!this.gUE)
    {
      if (this.uiz != null) {
        break label61;
      }
      this.uiz = new ArrayList();
      this.uiA = new ArrayList();
    }
    for (;;)
    {
      addSplit(null);
      return;
      label61:
      this.uiz.clear();
      this.uiA.clear();
    }
  }
  
  public final void addSplit(String paramString)
  {
    if (this.gUE) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.uiz.add(Long.valueOf(l));
    this.uiA.add(paramString);
  }
  
  public final void dumpToLog()
  {
    if (this.gUE) {
      return;
    }
    y.d(this.mTag, this.uiy + ": begin");
    long l2 = ((Long)this.uiz.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    while (i < this.uiz.size())
    {
      l1 = ((Long)this.uiz.get(i)).longValue();
      String str = (String)this.uiA.get(i);
      long l3 = ((Long)this.uiz.get(i - 1)).longValue();
      y.d(this.mTag, this.uiy + ":      " + (l1 - l3) + " ms, " + str);
      i += 1;
    }
    y.d(this.mTag, this.uiy + ": end, " + (l1 - l2) + " ms");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bi
 * JD-Core Version:    0.7.0.1
 */