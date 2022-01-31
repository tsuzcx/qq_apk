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
    return i.a(this.wSL).wSX.size;
  }
  
  public final String ul(int paramInt)
  {
    i.gg(paramInt, i.a(this.wSL).wSX.size);
    paramInt = this.wSL.Jw(i.a(this.wSL).wSX.off + paramInt * 4).ayD.getInt();
    return this.wSL.Jw(paramInt).cPZ().value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.i.f
 * JD-Core Version:    0.7.0.1
 */