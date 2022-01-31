package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryCommentInputView$d
  implements Runnable
{
  StoryCommentInputView$d(StoryCommentInputView paramStoryCommentInputView) {}
  
  public final void run()
  {
    AppMethodBeat.i(110394);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.sMv.getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.showSoftInput((View)StoryCommentInputView.a(this.sMv), 0);
      AppMethodBeat.o(110394);
      return;
    }
    AppMethodBeat.o(110394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.d
 * JD-Core Version:    0.7.0.1
 */