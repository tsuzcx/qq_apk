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
  private final WheelView JkP;
  
  public b(WheelView paramWheelView)
  {
    this.JkP = paramWheelView;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(199842);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(199842);
      return;
      this.JkP.invalidate();
      AppMethodBeat.o(199842);
      return;
      this.JkP.a(WheelView.a.Jkh);
      AppMethodBeat.o(199842);
      return;
      paramMessage = this.JkP;
      paramMessage.fwc();
      if (paramMessage.Jkc != null) {
        paramMessage.postDelayed(new WheelView.1(paramMessage), 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.b
 * JD-Core Version:    0.7.0.1
 */