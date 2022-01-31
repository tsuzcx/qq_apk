package com.tencent.mm.plugin.sight.encode.ui;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mm.sdk.platformtools.y;

final class e$a$1
  implements Camera.AutoFocusCallback
{
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    y.v("MicroMsg.SightCamera", "auto focus callback");
    e.a.mhb = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.e.a.1
 * JD-Core Version:    0.7.0.1
 */