package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class TestTimeForChatting
  extends DrawnCallBackLinearLayout
{
  a IUH;
  public int IUI = 0;
  public int IUJ = 0;
  public final String TAG = "MicroMsg.TestTimeForChatting";
  private long bZS;
  private int fMz = 0;
  
  public TestTimeForChatting(Context paramContext)
  {
    super(paramContext);
  }
  
  public TestTimeForChatting(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39203);
    this.fMz += 1;
    try
    {
      super.dispatchDraw(paramCanvas);
      g.MI(9);
      g.MI(18);
      g.MI(25);
      g.MI(24);
      g.MI(20);
      g.MI(18);
      if (this.IUH != null) {
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(39199);
            if (TestTimeForChatting.this.IUH != null) {
              TestTimeForChatting.this.IUH.fhp();
            }
            AppMethodBeat.o(39199);
          }
        });
      }
      AppMethodBeat.o(39203);
      return;
    }
    catch (Throwable paramCanvas)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.TestTimeForChatting", paramCanvas, "dispatchDraw", new Object[0]);
      }
    }
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(39204);
    ac.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", new Object[] { paramRect.toString(), Integer.valueOf(this.IUI), Integer.valueOf(this.IUJ) });
    paramRect.bottom += this.IUI;
    paramRect.right += this.IUJ;
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(39204);
    return bool;
  }
  
  public final void ftX()
  {
    AppMethodBeat.i(39201);
    ac.i("MicroMsg.TestTimeForChatting", "start chatting response time: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.bZS) });
    this.fMz = 0;
    AppMethodBeat.o(39201);
  }
  
  public final void ftY()
  {
    AppMethodBeat.i(39202);
    ac.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", new Object[] { Integer.valueOf(this.fMz) });
    h.wUl.f(11198, new Object[] { Integer.valueOf(this.fMz) });
    AppMethodBeat.o(39202);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39200);
    long l = System.currentTimeMillis();
    super.onDraw(paramCanvas);
    ac.i("MicroMsg.TestTimeForChatting", System.currentTimeMillis() - l);
    AppMethodBeat.o(39200);
  }
  
  public void setOndispatchDraw(a parama)
  {
    this.IUH = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fhp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.TestTimeForChatting
 * JD-Core Version:    0.7.0.1
 */