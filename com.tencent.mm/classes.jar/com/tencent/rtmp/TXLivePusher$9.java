package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXLivePusher$9
  implements Runnable
{
  TXLivePusher$9(TXLivePusher paramTXLivePusher, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener, Bitmap paramBitmap) {}
  
  public void run()
  {
    AppMethodBeat.i(65972);
    if (this.val$listener != null) {
      this.val$listener.onSnapshot(this.val$bmp);
    }
    AppMethodBeat.o(65972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.9
 * JD-Core Version:    0.7.0.1
 */