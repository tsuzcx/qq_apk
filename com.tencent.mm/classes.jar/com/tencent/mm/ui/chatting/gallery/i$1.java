package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.k;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class i$1
  implements k
{
  i$1(i parami) {}
  
  public final void onImageLoadComplete(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(35937);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35936);
        AppMethodBeat.o(35936);
      }
    });
    AppMethodBeat.o(35937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.i.1
 * JD-Core Version:    0.7.0.1
 */