package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ah;

final class b$1
  extends n.a
{
  b$1(b paramb) {}
  
  public final void et(int paramInt)
  {
    if (paramInt != 4) {
      return;
    }
    new ah(Looper.getMainLooper()).post(new b.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.b.1
 * JD-Core Version:    0.7.0.1
 */