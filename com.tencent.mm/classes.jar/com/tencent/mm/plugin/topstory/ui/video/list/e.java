package com.tencent.mm.plugin.topstory.ui.video.list;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.topstory.ui.video.e
{
  boolean tlc;
  boolean tld;
  boolean tll;
  h tlm;
  
  public e(b paramb)
  {
    super(paramb);
  }
  
  public final int GD(int paramInt)
  {
    AppMethodBeat.i(2032);
    int i = getHeadersCount();
    if (bo.es(((b)this.thM).cJs().GI(paramInt - i).wVo))
    {
      AppMethodBeat.o(2032);
      return 0;
    }
    AppMethodBeat.o(2032);
    return 1;
  }
  
  public final void l(List<ckx> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(2031);
    super.l(paramList, paramBoolean);
    al.d(new e.1(this, paramList, paramBoolean));
    AppMethodBeat.o(2031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e
 * JD-Core Version:    0.7.0.1
 */