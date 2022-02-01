package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

public class TestTimeForSns
  extends FrameLayout
{
  public final boolean DEBUG = true;
  public final String TAG = "MicroMsg.TestTimeForSns";
  public long beginTime;
  private boolean hasDrawed;
  private a listener;
  
  public TestTimeForSns(Context paramContext)
  {
    super(paramContext);
  }
  
  public TestTimeForSns(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(99702);
    super.dispatchDraw(paramCanvas);
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if (this.listener != null) {
        this.listener.cAy();
      }
    }
    g.KJ(10);
    g.KJ(22);
    AppMethodBeat.o(99702);
  }
  
  public boolean hasDrawed()
  {
    return this.hasDrawed;
  }
  
  public void setListener(a parama)
  {
    this.listener = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cAy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TestTimeForSns
 * JD-Core Version:    0.7.0.1
 */