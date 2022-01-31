package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.al;
import java.util.List;

public final class d
  extends e
{
  protected b tim;
  public boolean tke = false;
  
  public d(b paramb)
  {
    super(paramb);
    this.tim = paramb;
  }
  
  public final int GD(int paramInt)
  {
    return 0;
  }
  
  public final void l(List<ckx> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(1874);
    super.l(paramList, paramBoolean);
    al.d(new d.1(this, paramList));
    AppMethodBeat.o(1874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.d
 * JD-Core Version:    0.7.0.1
 */