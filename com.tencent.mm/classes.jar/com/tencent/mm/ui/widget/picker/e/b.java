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
  private final WheelView Lcm;
  
  public b(WheelView paramWheelView)
  {
    this.Lcm = paramWheelView;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(192792);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192792);
      return;
      this.Lcm.invalidate();
      AppMethodBeat.o(192792);
      return;
      this.Lcm.a(WheelView.a.LbE);
      AppMethodBeat.o(192792);
      return;
      paramMessage = this.Lcm;
      paramMessage.fMQ();
      if (paramMessage.Lbz != null) {
        paramMessage.postDelayed(new WheelView.1(paramMessage), 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.b
 * JD-Core Version:    0.7.0.1
 */