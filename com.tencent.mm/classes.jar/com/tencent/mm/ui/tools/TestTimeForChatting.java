package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class TestTimeForChatting
  extends DrawnCallBackLinearLayout
{
  public final String TAG = "MicroMsg.TestTimeForChatting";
  public int afLA = 0;
  public int afLB = 0;
  a afLz;
  private long emw;
  private int mbS = 0;
  
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
    this.mbS += 1;
    try
    {
      super.dispatchDraw(paramCanvas);
      g.ahx(9);
      g.ahx(18);
      g.ahx(25);
      g.ahx(24);
      g.ahx(20);
      g.ahx(18);
      if (this.afLz != null) {
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(39199);
            if (TestTimeForChatting.this.afLz != null) {
              TestTimeForChatting.this.afLz.jkD();
            }
            AppMethodBeat.o(39199);
          }
        });
      }
      AppMethodBeat.o(39203);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TestTimeForChatting", paramCanvas, "dispatchDraw", new Object[0]);
      }
    }
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(39204);
    Log.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", new Object[] { paramRect.toString(), Integer.valueOf(this.afLA), Integer.valueOf(this.afLB) });
    paramRect.bottom += this.afLA;
    paramRect.right += this.afLB;
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(39204);
    return bool;
  }
  
  public final void jDp()
  {
    AppMethodBeat.i(39201);
    Log.i("MicroMsg.TestTimeForChatting", "start chatting response time: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.emw) });
    this.mbS = 0;
    AppMethodBeat.o(39201);
  }
  
  public final void jDq()
  {
    AppMethodBeat.i(39202);
    Log.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", new Object[] { Integer.valueOf(this.mbS) });
    h.OAn.b(11198, new Object[] { Integer.valueOf(this.mbS) });
    AppMethodBeat.o(39202);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39200);
    long l = System.currentTimeMillis();
    super.onDraw(paramCanvas);
    Log.i("MicroMsg.TestTimeForChatting", System.currentTimeMillis() - l);
    AppMethodBeat.o(39200);
  }
  
  public void setOndispatchDraw(a parama)
  {
    this.afLz = parama;
  }
  
  public static abstract interface a
  {
    public abstract void jkD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.TestTimeForChatting
 * JD-Core Version:    0.7.0.1
 */