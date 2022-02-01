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
  private final WheelView QUD;
  
  public b(WheelView paramWheelView)
  {
    this.QUD = paramWheelView;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(198523);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(198523);
      return;
      this.QUD.invalidate();
      AppMethodBeat.o(198523);
      return;
      this.QUD.a(WheelView.a.QTV);
      AppMethodBeat.o(198523);
      return;
      paramMessage = this.QUD;
      paramMessage.hcn();
      if (paramMessage.QTP != null) {
        paramMessage.postDelayed(new WheelView.1(paramMessage), 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.b
 * JD-Core Version:    0.7.0.1
 */