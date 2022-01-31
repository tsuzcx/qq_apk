package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.ah;

final class h$1
  implements Runnable
{
  h$1(h paramh, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    Object localObject = this.opF.cj();
    this.opF.handler.post(new h.1.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.h.1
 * JD-Core Version:    0.7.0.1
 */