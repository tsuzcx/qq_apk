package com.tencent.mm.plugin.music.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class LyricView$a
  extends GestureDetector.SimpleOnGestureListener
{
  private LyricView$a(LyricView paramLyricView) {}
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = LyricView.a(this.mBp, paramMotionEvent.getX(), paramMotionEvent.getY());
    if (!bk.bl(paramMotionEvent))
    {
      e.bnr().setPrimaryClip(ClipData.newPlainText("MicroMsg.Music", paramMotionEvent));
      Toast.makeText(this.mBp.getContext(), this.mBp.getContext().getString(a.f.music_clipboard_toast, new Object[] { paramMotionEvent }), 0).show();
      return;
    }
    y.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView.a
 * JD-Core Version:    0.7.0.1
 */