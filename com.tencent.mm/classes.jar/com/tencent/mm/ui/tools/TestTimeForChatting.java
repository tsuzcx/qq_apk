package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class TestTimeForChatting
  extends DrawnCallBackLinearLayout
{
  TestTimeForChatting.a Ayd;
  public int Aye = 0;
  public int Ayf = 0;
  public final String TAG = "MicroMsg.TestTimeForChatting";
  private int eLv = 0;
  private long fYL;
  
  public TestTimeForChatting(Context paramContext)
  {
    super(paramContext);
  }
  
  public TestTimeForChatting(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void dOb()
  {
    AppMethodBeat.i(35004);
    ab.i("MicroMsg.TestTimeForChatting", "start chatting response time: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.fYL) });
    this.eLv = 0;
    AppMethodBeat.o(35004);
  }
  
  public final void dOc()
  {
    AppMethodBeat.i(35005);
    ab.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", new Object[] { Integer.valueOf(this.eLv) });
    h.qsU.e(11198, new Object[] { Integer.valueOf(this.eLv) });
    AppMethodBeat.o(35005);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(35006);
    this.eLv += 1;
    try
    {
      super.dispatchDraw(paramCanvas);
      g.Cy(9);
      g.Cy(18);
      g.Cy(25);
      g.Cy(24);
      g.Cy(20);
      g.Cy(18);
      if (this.Ayd != null) {
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35002);
            if (TestTimeForChatting.this.Ayd != null) {
              TestTimeForChatting.this.Ayd.dDc();
            }
            AppMethodBeat.o(35002);
          }
        });
      }
      AppMethodBeat.o(35006);
      return;
    }
    catch (Throwable paramCanvas)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TestTimeForChatting", paramCanvas, "dispatchDraw", new Object[0]);
      }
    }
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(35007);
    ab.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", new Object[] { paramRect.toString(), Integer.valueOf(this.Aye), Integer.valueOf(this.Ayf) });
    paramRect.bottom += this.Aye;
    paramRect.right += this.Ayf;
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(35007);
    return bool;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(35003);
    long l = System.currentTimeMillis();
    super.onDraw(paramCanvas);
    ab.i("MicroMsg.TestTimeForChatting", System.currentTimeMillis() - l);
    AppMethodBeat.o(35003);
  }
  
  public void setOndispatchDraw(TestTimeForChatting.a parama)
  {
    this.Ayd = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.TestTimeForChatting
 * JD-Core Version:    0.7.0.1
 */