package com.tencent.mm.plugin.music.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class LyricView$a
  extends GestureDetector.SimpleOnGestureListener
{
  private LyricView$a(LyricView paramLyricView) {}
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105043);
    paramMotionEvent = LyricView.a(this.pbu, paramMotionEvent.getX(), paramMotionEvent.getY());
    if (!bo.isNullOrNil(paramMotionEvent))
    {
      e.bVN().setPrimaryClip(ClipData.newPlainText("MicroMsg.Music", paramMotionEvent));
      Toast.makeText(this.pbu.getContext(), this.pbu.getContext().getString(2131301720, new Object[] { paramMotionEvent }), 0).show();
      AppMethodBeat.o(105043);
      return;
    }
    ab.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
    AppMethodBeat.o(105043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView.a
 * JD-Core Version:    0.7.0.1
 */