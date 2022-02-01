package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppAttachNewDownloadUI$7
  implements View.OnTouchListener
{
  AppAttachNewDownloadUI$7(AppAttachNewDownloadUI paramAppAttachNewDownloadUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198784);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(198784);
      return false;
      AppAttachNewDownloadUI.a(this.Wxg, (int)paramMotionEvent.getRawX());
      AppAttachNewDownloadUI.b(this.Wxg, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.7
 * JD-Core Version:    0.7.0.1
 */