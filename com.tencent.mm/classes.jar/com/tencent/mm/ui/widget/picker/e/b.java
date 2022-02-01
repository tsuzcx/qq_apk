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
  private final WheelView HKs;
  
  public b(WheelView paramWheelView)
  {
    this.HKs = paramWheelView;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(195371);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195371);
      return;
      this.HKs.invalidate();
      AppMethodBeat.o(195371);
      return;
      this.HKs.a(WheelView.a.HJK);
      AppMethodBeat.o(195371);
      return;
      paramMessage = this.HKs;
      if (paramMessage.HJF != null) {
        paramMessage.postDelayed(new WheelView.1(paramMessage), 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e.b
 * JD-Core Version:    0.7.0.1
 */