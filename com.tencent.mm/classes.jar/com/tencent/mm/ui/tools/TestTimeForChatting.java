package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class TestTimeForChatting
  extends DrawnCallBackLinearLayout
{
  a KLL;
  public int KLM = 0;
  public int KLN = 0;
  public final String TAG = "MicroMsg.TestTimeForChatting";
  private long ckk;
  private int gfZ = 0;
  
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
    this.gfZ += 1;
    try
    {
      super.dispatchDraw(paramCanvas);
      f.Ok(9);
      f.Ok(18);
      f.Ok(25);
      f.Ok(24);
      f.Ok(20);
      f.Ok(18);
      if (this.KLL != null) {
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(39199);
            if (TestTimeForChatting.this.KLL != null) {
              TestTimeForChatting.this.KLL.fxB();
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
        ad.printErrStackTrace("MicroMsg.TestTimeForChatting", paramCanvas, "dispatchDraw", new Object[0]);
      }
    }
  }
  
  public final void fKK()
  {
    AppMethodBeat.i(39201);
    ad.i("MicroMsg.TestTimeForChatting", "start chatting response time: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.ckk) });
    this.gfZ = 0;
    AppMethodBeat.o(39201);
  }
  
  public final void fKL()
  {
    AppMethodBeat.i(39202);
    ad.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", new Object[] { Integer.valueOf(this.gfZ) });
    g.yhR.f(11198, new Object[] { Integer.valueOf(this.gfZ) });
    AppMethodBeat.o(39202);
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(39204);
    ad.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", new Object[] { paramRect.toString(), Integer.valueOf(this.KLM), Integer.valueOf(this.KLN) });
    paramRect.bottom += this.KLM;
    paramRect.right += this.KLN;
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(39204);
    return bool;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39200);
    long l = System.currentTimeMillis();
    super.onDraw(paramCanvas);
    ad.i("MicroMsg.TestTimeForChatting", System.currentTimeMillis() - l);
    AppMethodBeat.o(39200);
  }
  
  public void setOndispatchDraw(a parama)
  {
    this.KLL = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fxB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.TestTimeForChatting
 * JD-Core Version:    0.7.0.1
 */