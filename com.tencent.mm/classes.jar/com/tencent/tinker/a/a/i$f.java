package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.a.a;
import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.RandomAccess;

final class i$f
  extends AbstractList<String>
  implements RandomAccess
{
  private i$f(i parami) {}
  
  public final int size()
  {
    return i.a(this.Bps).BpE.size;
  }
  
  public final String zC(int paramInt)
  {
    i.io(paramInt, i.a(this.Bps).BpE.size);
    paramInt = this.Bps.Sr(i.a(this.Bps).BpE.off + paramInt * 4).aAS.getInt();
    return this.Bps.Sr(paramInt).dVN().value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.i.f
 * JD-Core Version:    0.7.0.1
 */