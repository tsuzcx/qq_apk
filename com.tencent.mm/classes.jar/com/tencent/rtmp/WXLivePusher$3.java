package com.tencent.rtmp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloud.BGMNotify;
import java.lang.ref.WeakReference;

class WXLivePusher$3
  implements TRTCCloud.BGMNotify
{
  WXLivePusher$3(WXLivePusher paramWXLivePusher) {}
  
  public void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(170246);
    if (WXLivePusher.access$100(this.this$0) != null)
    {
      TXLivePusher.OnBGMNotify localOnBGMNotify = (TXLivePusher.OnBGMNotify)WXLivePusher.access$100(this.this$0).get();
      if (localOnBGMNotify != null) {
        localOnBGMNotify.onBGMComplete(paramInt);
      }
    }
    AppMethodBeat.o(170246);
  }
  
  public void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(170245);
    if (WXLivePusher.access$100(this.this$0) != null)
    {
      TXLivePusher.OnBGMNotify localOnBGMNotify = (TXLivePusher.OnBGMNotify)WXLivePusher.access$100(this.this$0).get();
      if (localOnBGMNotify != null) {
        localOnBGMNotify.onBGMProgress(paramLong1, paramLong2);
      }
    }
    AppMethodBeat.o(170245);
  }
  
  public void onBGMStart(int paramInt)
  {
    AppMethodBeat.i(170244);
    if (WXLivePusher.access$100(this.this$0) != null)
    {
      TXLivePusher.OnBGMNotify localOnBGMNotify = (TXLivePusher.OnBGMNotify)WXLivePusher.access$100(this.this$0).get();
      if (localOnBGMNotify != null) {
        localOnBGMNotify.onBGMStart();
      }
    }
    AppMethodBeat.o(170244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePusher.3
 * JD-Core Version:    0.7.0.1
 */