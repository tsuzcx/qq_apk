package com.tencent.pb.common.b;

import java.lang.ref.WeakReference;

public final class i
  implements c
{
  private WeakReference<c> Ck;
  
  public i(c paramc)
  {
    this.Ck = new WeakReference(paramc);
  }
  
  public final void r(int paramInt, byte[] paramArrayOfByte)
  {
    if ((this.Ck != null) && (this.Ck.get() != null))
    {
      ((c)this.Ck.get()).r(paramInt, paramArrayOfByte);
      return;
    }
    com.tencent.pb.common.c.c.x("OnRespForLongAIDLImpl fail", new Object[] { "callback is null, errCode=" + paramInt });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.i
 * JD-Core Version:    0.7.0.1
 */