package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.e.c;
import java.util.ArrayList;
import java.util.List;

final class TopStoryBaseVideoUI$5
  implements e.c
{
  TopStoryBaseVideoUI$5(TopStoryBaseVideoUI paramTopStoryBaseVideoUI, byg parambyg, int paramInt) {}
  
  public final void b(boolean paramBoolean, int[] paramArrayOfInt)
  {
    ArrayList localArrayList;
    int i;
    if ((paramBoolean) && (paramArrayOfInt.length > 0))
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < paramArrayOfInt.length)
      {
        if (paramArrayOfInt[i] == 1) {
          localArrayList.add(Integer.valueOf(i + 1));
        }
        i += 1;
      }
      if (localArrayList.size() == 0) {
        localArrayList.add(Integer.valueOf(0));
      }
      h.a(this.pFv.bNv(), this.pFw, localArrayList, this.pFv.pFq.cVn());
      this.pFv.pFp.stopPlay();
      paramArrayOfInt = this.pFv.pFq;
      i = this.kX;
      if (i < 0) {}
    }
    try
    {
      if (i < paramArrayOfInt.cnS().size()) {
        paramArrayOfInt.cnS().remove(i);
      }
      this.pFv.bND().bN(this.kX + this.pFv.bND().getHeadersCount());
      y.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "feedback dialog click %d", new Object[] { Integer.valueOf(localArrayList.size()) });
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.5
 * JD-Core Version:    0.7.0.1
 */