package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class TestTimeForChatting
  extends DrawnCallBackLinearLayout
{
  a Lif;
  public int Lig = 0;
  public int Lih = 0;
  public final String TAG = "MicroMsg.TestTimeForChatting";
  private long ckm;
  private int gir = 0;
  
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
    this.gir += 1;
    try
    {
      super.dispatchDraw(paramCanvas);
      f.OQ(9);
      f.OQ(18);
      f.OQ(25);
      f.OQ(24);
      f.OQ(20);
      f.OQ(18);
      if (this.Lif != null) {
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(39199);
            if (TestTimeForChatting.this.Lif != null) {
              TestTimeForChatting.this.Lif.fBD();
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
        ae.printErrStackTrace("MicroMsg.TestTimeForChatting", paramCanvas, "dispatchDraw", new Object[0]);
      }
    }
  }
  
  public final void fPb()
  {
    AppMethodBeat.i(39201);
    ae.i("MicroMsg.TestTimeForChatting", "start chatting response time: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.ckm) });
    this.gir = 0;
    AppMethodBeat.o(39201);
  }
  
  public final void fPc()
  {
    AppMethodBeat.i(39202);
    ae.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", new Object[] { Integer.valueOf(this.gir) });
    g.yxI.f(11198, new Object[] { Integer.valueOf(this.gir) });
    AppMethodBeat.o(39202);
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(39204);
    ae.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", new Object[] { paramRect.toString(), Integer.valueOf(this.Lig), Integer.valueOf(this.Lih) });
    paramRect.bottom += this.Lig;
    paramRect.right += this.Lih;
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(39204);
    return bool;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39200);
    long l = System.currentTimeMillis();
    super.onDraw(paramCanvas);
    ae.i("MicroMsg.TestTimeForChatting", System.currentTimeMillis() - l);
    AppMethodBeat.o(39200);
  }
  
  public void setOndispatchDraw(a parama)
  {
    this.Lif = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fBD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.TestTimeForChatting
 * JD-Core Version:    0.7.0.1
 */