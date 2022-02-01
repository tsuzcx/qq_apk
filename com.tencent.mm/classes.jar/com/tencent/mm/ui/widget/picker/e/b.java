package com.tencent.mm.ui.widget.picker.e;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.WheelView.1;
import com.tencent.mm.ui.widget.picker.WheelView.a;

public final class b
  extends Handler
{
  private final WheelView LyN;
  
  public b(WheelView paramWheelView)
  {
    this.LyN = paramWheelView;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(200565);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200565);
      return;
      this.LyN.invalidate();
      AppMethodBeat.o(200565);
      return;
      this.LyN.a(WheelView.a.Lyf);
      AppMethodBeat.o(200565);
      return;
      paramMessage = this.LyN;
      paramMessage.fRl();
      if (paramMessage.Lya != null) {
        paramMessage.postDelayed(new WheelView.1(paramMessage), 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.b
 * JD-Core Version:    0.7.0.1
 */