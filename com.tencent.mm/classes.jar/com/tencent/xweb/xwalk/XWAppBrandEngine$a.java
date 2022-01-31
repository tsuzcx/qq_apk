package com.tencent.xweb.xwalk;

import android.os.Handler;
import java.util.ArrayList;
import java.util.TimerTask;

public final class XWAppBrandEngine$a
  extends TimerTask
{
  public int bks;
  public boolean xlD;
  
  public XWAppBrandEngine$a(XWAppBrandEngine paramXWAppBrandEngine, int paramInt, boolean paramBoolean)
  {
    this.bks = paramInt;
    this.xlD = paramBoolean;
  }
  
  public final void run()
  {
    if (XWAppBrandEngine.a(this.xlE))
    {
      if (this.xlD) {
        return;
      }
      synchronized (this.xlE.xlB)
      {
        this.xlE.xlB.add(new XWAppBrandEngine.a.1(this));
        return;
      }
    }
    XWAppBrandEngine.c(this.xlE).post(new XWAppBrandEngine.a.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWAppBrandEngine.a
 * JD-Core Version:    0.7.0.1
 */