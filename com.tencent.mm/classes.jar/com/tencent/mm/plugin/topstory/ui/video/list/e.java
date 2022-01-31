package com.tencent.mm.plugin.topstory.ui.video.list;

import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.topstory.ui.video.e
{
  boolean pHA;
  boolean pHB;
  boolean pHF;
  h pHG;
  
  public e(b paramb)
  {
    super(paramb);
  }
  
  protected final void g(List<byg> paramList, boolean paramBoolean)
  {
    super.g(paramList, paramBoolean);
    ai.d(new e.1(this, paramList, paramBoolean));
  }
  
  public final int zA(int paramInt)
  {
    int i = this.pEn.size();
    if (bk.dk(((b)this.pEp).bNJ().Es(paramInt - i).sXo)) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.e
 * JD-Core Version:    0.7.0.1
 */