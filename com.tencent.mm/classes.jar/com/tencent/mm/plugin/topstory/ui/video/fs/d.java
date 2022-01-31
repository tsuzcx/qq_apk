package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.List;

public final class d
  extends e
{
  protected b pEP;
  public boolean pGM = false;
  
  public d(b paramb)
  {
    super(paramb);
    this.pEP = paramb;
  }
  
  protected final void g(List<byg> paramList, boolean paramBoolean)
  {
    super.g(paramList, paramBoolean);
    ai.d(new d.1(this, paramList));
  }
  
  public final int zA(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.d
 * JD-Core Version:    0.7.0.1
 */