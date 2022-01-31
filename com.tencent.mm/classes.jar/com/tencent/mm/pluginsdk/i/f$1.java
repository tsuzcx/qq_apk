package com.tencent.mm.pluginsdk.i;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements Camera.AutoFocusCallback
{
  f$1(f paramf) {}
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    y.d("MicroMsg.YuvReocrder", "auto focus callback");
    f.a(this.rYy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.f.1
 * JD-Core Version:    0.7.0.1
 */