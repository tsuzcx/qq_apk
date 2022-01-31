package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog.a;

class TXLiveBase$a
  implements TXCLog.a
{
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (TXLiveBase.access$100() != null) {
      TXLiveBase.access$100().OnLog(paramInt, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.TXLiveBase.a
 * JD-Core Version:    0.7.0.1
 */