package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

class b$12
  implements Runnable
{
  b$12(b paramb, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener, Bitmap paramBitmap) {}
  
  public void run()
  {
    AppMethodBeat.i(14242);
    if (this.a != null) {
      this.a.onSnapshot(this.b);
    }
    AppMethodBeat.o(14242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.b.12
 * JD-Core Version:    0.7.0.1
 */