package com.tencent.pb.common.b;

import com.tencent.pb.common.c.b;
import java.lang.ref.WeakReference;

public final class i
  implements c
{
  private WeakReference<c> KD;
  
  public i(c paramc)
  {
    this.KD = new WeakReference(paramc);
  }
  
  public final void onResp(int paramInt, byte[] paramArrayOfByte)
  {
    if ((this.KD != null) && (this.KD.get() != null))
    {
      ((c)this.KD.get()).onResp(paramInt, paramArrayOfByte);
      return;
    }
    b.w("OnRespForLongAIDLImpl fail", new Object[] { "callback is null, errCode=".concat(String.valueOf(paramInt)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.i
 * JD-Core Version:    0.7.0.1
 */