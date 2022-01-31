package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class TestTimeForChatting
  extends DrawnCallBackLinearLayout
{
  public final String TAG = "MicroMsg.TestTimeForChatting";
  private int dNN = 0;
  private long eJg;
  TestTimeForChatting.a wfn;
  public int wfo = 0;
  public int wfp = 0;
  
  public TestTimeForChatting(Context paramContext)
  {
    super(paramContext);
  }
  
  public TestTimeForChatting(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void cJl()
  {
    y.i("MicroMsg.TestTimeForChatting", "start chatting response time: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.eJg) });
    this.dNN = 0;
  }
  
  public final void cJm()
  {
    y.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", new Object[] { Integer.valueOf(this.dNN) });
    h.nFQ.f(11198, new Object[] { Integer.valueOf(this.dNN) });
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.dNN += 1;
    try
    {
      super.dispatchDraw(paramCanvas);
      g.wJ(9);
      g.wJ(18);
      g.wJ(25);
      g.wJ(24);
      g.wJ(20);
      g.wJ(18);
      if (this.wfn != null) {
        post(new TestTimeForChatting.1(this));
      }
      return;
    }
    catch (Throwable paramCanvas)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TestTimeForChatting", paramCanvas, "dispatchDraw", new Object[0]);
      }
    }
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    y.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", new Object[] { paramRect.toString(), Integer.valueOf(this.wfo), Integer.valueOf(this.wfp) });
    paramRect.bottom += this.wfo;
    paramRect.right += this.wfp;
    return super.fitSystemWindows(paramRect);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    long l = System.currentTimeMillis();
    super.onDraw(paramCanvas);
    y.i("MicroMsg.TestTimeForChatting", System.currentTimeMillis() - l);
  }
  
  public void setOndispatchDraw(TestTimeForChatting.a parama)
  {
    this.wfn = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.TestTimeForChatting
 * JD-Core Version:    0.7.0.1
 */