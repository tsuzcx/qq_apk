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
  private TestTimeForSns.a listener;
  
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
    AppMethodBeat.i(39842);
    super.dispatchDraw(paramCanvas);
    if (!this.hasDrawed)
    {
      this.hasDrawed = true;
      if (this.listener != null) {
        this.listener.bEm();
      }
    }
    g.Cy(10);
    g.Cy(22);
    AppMethodBeat.o(39842);
  }
  
  public boolean hasDrawed()
  {
    return this.hasDrawed;
  }
  
  public void setListener(TestTimeForSns.a parama)
  {
    this.listener = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TestTimeForSns
 * JD-Core Version:    0.7.0.1
 */