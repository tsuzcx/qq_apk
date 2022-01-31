package com.tencent.rtmp;

import com.tencent.liteav.audio.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXLivePusher$1
  implements e
{
  TXLivePusher$1(TXLivePusher paramTXLivePusher) {}
  
  public void onPlayEnd(int paramInt)
  {
    AppMethodBeat.i(146982);
    if (this.this$0.mBGMNotify != null) {
      this.this$0.mBGMNotify.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(146982);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(146983);
    if (this.this$0.mBGMNotify != null) {
      this.this$0.mBGMNotify.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(146983);
  }
  
  public void onPlayStart()
  {
    AppMethodBeat.i(146981);
    if (this.this$0.mBGMNotify != null) {
      this.this$0.mBGMNotify.onBGMStart();
    }
    AppMethodBeat.o(146981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.1
 * JD-Core Version:    0.7.0.1
 */