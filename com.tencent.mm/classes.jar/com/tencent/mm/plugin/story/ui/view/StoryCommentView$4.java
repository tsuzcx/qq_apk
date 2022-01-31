package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryCommentView$4
  implements View.OnClickListener
{
  StoryCommentView$4(StoryCommentView paramStoryCommentView) {}
  
  public final void onClick(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(151182);
    paramView = StoryCommentView.o(this.sMZ);
    paramView.isRecording = true;
    paramView.sNE += 1;
    int i;
    if ((paramView.sNE == 1) && (paramView.sNC == null) && (paramView.sND == null)) {
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        paramView.cFz();
      }
      al.ae(paramView.sNG);
      al.p(paramView.sNG, paramView.sNF);
      AppMethodBeat.o(151182);
      return;
      if (paramView.sNE == 2)
      {
        i = j;
        if (paramView.sND == null) {}
      }
      else
      {
        i = j;
        if (paramView.sNE != 3) {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.4
 * JD-Core Version:    0.7.0.1
 */