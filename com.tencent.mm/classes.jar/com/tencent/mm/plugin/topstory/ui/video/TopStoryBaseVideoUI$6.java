package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.c;
import com.tencent.mm.ui.widget.a.e.e;

final class TopStoryBaseVideoUI$6
  implements e.e
{
  TopStoryBaseVideoUI$6(TopStoryBaseVideoUI paramTopStoryBaseVideoUI, e.a parama, e.c paramc) {}
  
  public final void q(int[] paramArrayOfInt)
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramArrayOfInt.length)
      {
        if (paramArrayOfInt[i] == 1) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.gPd.Iu(b.g.app_finish).a(this.pFx);
        return;
      }
      i += 1;
    }
    this.gPd.Iu(b.g.top_story_feedback_unlike).a(this.pFx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.6
 * JD-Core Version:    0.7.0.1
 */