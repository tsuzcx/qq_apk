package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-story_release"})
public final class StoryCommentInputView$3
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(151168);
    if (paramEditable != null)
    {
      int j = ((CharSequence)paramEditable).length();
      int k = 60 - j;
      StoryCommentInputView localStoryCommentInputView = this.sMv;
      int i;
      if (((CharSequence)paramEditable).length() > 0)
      {
        i = 1;
        if ((i == 0) || (k < 0) || (StoryCommentInputView.a(this.sMv).getLineCount() > 10)) {
          break label147;
        }
      }
      label147:
      for (boolean bool = true;; bool = false)
      {
        StoryCommentInputView.a(localStoryCommentInputView, bool);
        if (j < 55) {
          break label176;
        }
        StoryCommentInputView.h(this.sMv).setVisibility(0);
        StoryCommentInputView.h(this.sMv).setText((CharSequence)String.valueOf(k));
        if (k < 0) {
          break label153;
        }
        StoryCommentInputView.h(this.sMv).setTextColor(StoryCommentInputView.i(this.sMv));
        AppMethodBeat.o(151168);
        return;
        i = 0;
        break;
      }
      label153:
      StoryCommentInputView.h(this.sMv).setTextColor(StoryCommentInputView.j(this.sMv));
      AppMethodBeat.o(151168);
      return;
      label176:
      StoryCommentInputView.h(this.sMv).setVisibility(8);
      AppMethodBeat.o(151168);
      return;
    }
    StoryCommentInputView.a(this.sMv, false);
    StoryCommentInputView.h(this.sMv).setVisibility(8);
    AppMethodBeat.o(151168);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.3
 * JD-Core Version:    0.7.0.1
 */