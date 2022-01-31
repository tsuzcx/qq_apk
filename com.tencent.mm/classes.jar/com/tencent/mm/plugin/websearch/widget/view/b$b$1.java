package com.tencent.mm.plugin.websearch.widget.view;

import com.tencent.mm.plugin.websearch.api.y;
import java.util.List;

final class b$b$1
  implements c.a
{
  b$b$1(b.b paramb, int paramInt) {}
  
  public final int cam()
  {
    if (this.qXE.iJQ == null) {
      return 0;
    }
    return this.qXE.iJQ.size();
  }
  
  public final List<y> can()
  {
    return this.qXE.qXC.qXA;
  }
  
  public final boolean cao()
  {
    return this.kX > 0;
  }
  
  public final boolean hasNext()
  {
    return this.kX < this.qXE.iJQ.size() - 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.b.1
 * JD-Core Version:    0.7.0.1
 */