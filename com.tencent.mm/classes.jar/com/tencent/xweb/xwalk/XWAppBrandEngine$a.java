package com.tencent.xweb.xwalk;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.TimerTask;

public final class XWAppBrandEngine$a
  extends TimerTask
{
  public int BJs;
  public boolean BJt;
  
  public XWAppBrandEngine$a(XWAppBrandEngine paramXWAppBrandEngine, int paramInt, boolean paramBoolean)
  {
    this.BJs = paramInt;
    this.BJt = paramBoolean;
  }
  
  public final void run()
  {
    AppMethodBeat.i(4167);
    if (XWAppBrandEngine.a(this.BJu))
    {
      if (this.BJt)
      {
        AppMethodBeat.o(4167);
        return;
      }
      synchronized (this.BJu.BJq)
      {
        this.BJu.BJq.add(new XWAppBrandEngine.a.1(this));
        AppMethodBeat.o(4167);
        return;
      }
    }
    XWAppBrandEngine.c(this.BJu).post(new XWAppBrandEngine.a.2(this));
    AppMethodBeat.o(4167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWAppBrandEngine.a
 * JD-Core Version:    0.7.0.1
 */