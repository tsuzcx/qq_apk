package com.tencent.pb.common.b;

import java.lang.ref.WeakReference;

public final class i
  implements c
{
  private WeakReference<c> CT;
  
  public i(c paramc)
  {
    this.CT = new WeakReference(paramc);
  }
  
  public final void onResp(int paramInt, byte[] paramArrayOfByte)
  {
    if ((this.CT != null) && (this.CT.get() != null))
    {
      ((c)this.CT.get()).onResp(paramInt, paramArrayOfByte);
      return;
    }
    com.tencent.pb.common.c.c.w("OnRespForLongAIDLImpl fail", new Object[] { "callback is null, errCode=".concat(String.valueOf(paramInt)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.i
 * JD-Core Version:    0.7.0.1
 */