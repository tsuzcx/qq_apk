package com.tencent.mm.pluginsdk.ui.chat;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.HorizontalListView.a;

final class m$4
  implements HorizontalListView.a
{
  m$4(m paramm) {}
  
  public final boolean o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(62457);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62457);
      return false;
      this.vZl.mHandler.sendEmptyMessage(20002);
      continue;
      this.vZl.mHandler.sendEmptyMessageDelayed(20001, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m.4
 * JD-Core Version:    0.7.0.1
 */