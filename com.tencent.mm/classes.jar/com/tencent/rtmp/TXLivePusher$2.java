package com.tencent.rtmp;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.liteav.basic.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXLivePusher$2
  implements n
{
  TXLivePusher$2(TXLivePusher paramTXLivePusher, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public void onTakePhotoComplete(Bitmap paramBitmap)
  {
    AppMethodBeat.i(146984);
    TXLivePusher.access$000(this.this$0, this.val$listener, paramBitmap);
    TXLivePusher.access$102(this.this$0, false);
    TXLivePusher.access$300(this.this$0).removeCallbacks(TXLivePusher.access$200(this.this$0));
    AppMethodBeat.o(146984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.2
 * JD-Core Version:    0.7.0.1
 */