package com.tencent.mm.plugin.story.ui.view;

import a.f.a.m;
import a.f.b.j;
import a.l;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.ui.widget.MMEditText;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
final class StoryCommentInputView$6
  implements TextView.OnEditorActionListener
{
  StoryCommentInputView$6(StoryCommentInputView paramStoryCommentInputView) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(151170);
    if (4 != paramInt)
    {
      j.p(paramKeyEvent, "keyEvent");
      if (paramKeyEvent.getAction() != 66) {}
    }
    else if (StoryCommentInputView.b(this.sMv))
    {
      paramTextView = i.sFa;
      i.FU(9);
      paramTextView = StoryCommentInputView.a(this.sMv).getText();
      if (paramTextView != null)
      {
        StoryCommentInputView.c(this.sMv);
        StoryCommentInputView.a(this.sMv).setText(null);
        StoryCommentInputView.e(this.sMv).setVisibility(4);
        paramKeyEvent = this.sMv.getCommentInputCallback();
        if (paramKeyEvent != null) {
          paramKeyEvent.h(paramTextView.toString(), Boolean.TRUE);
        }
      }
    }
    AppMethodBeat.o(151170);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.6
 * JD-Core Version:    0.7.0.1
 */