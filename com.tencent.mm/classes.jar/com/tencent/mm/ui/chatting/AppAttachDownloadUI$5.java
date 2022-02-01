package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppAttachDownloadUI$5
  implements View.OnTouchListener
{
  AppAttachDownloadUI$5(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(291922);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(291922);
      return false;
      AppAttachDownloadUI.b(this.WwM, (int)paramMotionEvent.getRawX());
      AppAttachDownloadUI.c(this.WwM, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.5
 * JD-Core Version:    0.7.0.1
 */