package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppAttachDownloadUI$11
  implements View.OnTouchListener
{
  AppAttachDownloadUI$11(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30274);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30274);
      return false;
      AppAttachDownloadUI.b(this.zvM, (int)paramMotionEvent.getRawX());
      AppAttachDownloadUI.c(this.zvM, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.11
 * JD-Core Version:    0.7.0.1
 */