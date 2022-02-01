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
  a Qxe;
  public int Qxf = 0;
  public int Qxg = 0;
  public final String TAG = "MicroMsg.TestTimeForChatting";
  private long cwj;
  private int gRJ = 0;
  
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
    this.gRJ += 1;
    try
    {
      super.dispatchDraw(paramCanvas);
      g.Wm(9);
      g.Wm(18);
      g.Wm(25);
      g.Wm(24);
      g.Wm(20);
      g.Wm(18);
      if (this.Qxe != null) {
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(39199);
            if (TestTimeForChatting.this.Qxe != null) {
              TestTimeForChatting.this.Qxe.gJx();
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
        Log.printErrStackTrace("MicroMsg.TestTimeForChatting", paramCanvas, "dispatchDraw", new Object[0]);
      }
    }
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(39204);
    Log.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", new Object[] { paramRect.toString(), Integer.valueOf(this.Qxf), Integer.valueOf(this.Qxg) });
    paramRect.bottom += this.Qxf;
    paramRect.right += this.Qxg;
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(39204);
    return bool;
  }
  
  public final void gXV()
  {
    AppMethodBeat.i(39201);
    Log.i("MicroMsg.TestTimeForChatting", "start chatting response time: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.cwj) });
    this.gRJ = 0;
    AppMethodBeat.o(39201);
  }
  
  public final void gXW()
  {
    AppMethodBeat.i(39202);
    Log.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", new Object[] { Integer.valueOf(this.gRJ) });
    h.CyF.a(11198, new Object[] { Integer.valueOf(this.gRJ) });
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
    this.Qxe = parama;
  }
  
  public static abstract interface a
  {
    public abstract void gJx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.TestTimeForChatting
 * JD-Core Version:    0.7.0.1
 */