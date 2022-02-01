package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;

class WXLivePusher$2
  implements TRTCCloudListener.TRTCSnapshotListener
{
  WXLivePusher$2(WXLivePusher paramWXLivePusher, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public void onSnapshotComplete(Bitmap paramBitmap)
  {
    AppMethodBeat.i(182245);
    if (this.val$listener != null) {
      this.val$listener.onSnapshot(paramBitmap);
    }
    AppMethodBeat.o(182245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePusher.2
 * JD-Core Version:    0.7.0.1
 */