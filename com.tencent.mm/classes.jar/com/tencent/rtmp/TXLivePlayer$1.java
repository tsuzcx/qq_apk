package com.tencent.rtmp;

import com.tencent.liteav.j.a;
import com.tencent.liteav.n;

class TXLivePlayer$1
  implements j.a
{
  TXLivePlayer$1(TXLivePlayer paramTXLivePlayer) {}
  
  public void onLiveTime(long paramLong)
  {
    TXLivePlayer.access$002(this.this$0, paramLong);
    if (TXLivePlayer.access$100(this.this$0) != null) {
      TXLivePlayer.access$100(this.this$0).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePlayer.1
 * JD-Core Version:    0.7.0.1
 */