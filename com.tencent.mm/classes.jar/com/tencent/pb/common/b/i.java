package com.tencent.pb.common.b;

import com.tencent.pb.common.c.b;
import java.lang.ref.WeakReference;

public final class i
  implements c
{
  private WeakReference<c> dv;
  
  public i(c paramc)
  {
    this.dv = new WeakReference(paramc);
  }
  
  public final void onResp(int paramInt, byte[] paramArrayOfByte)
  {
    if ((this.dv != null) && (this.dv.get() != null))
    {
      ((c)this.dv.get()).onResp(paramInt, paramArrayOfByte);
      return;
    }
    b.w("OnRespForLongAIDLImpl fail", new Object[] { "callback is null, errCode=".concat(String.valueOf(paramInt)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.i
 * JD-Core Version:    0.7.0.1
 */