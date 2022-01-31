package com.tencent.mm.plugin.story.ui.view;

import a.f.a.m;
import a.l;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.ui.widget.MMEditText;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-story_release"})
public final class StoryCommentInputView$b
  implements ChatFooterPanel.a
{
  public final void aRo()
  {
    AppMethodBeat.i(110393);
    StoryCommentInputView.a(this.sMv).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    StoryCommentInputView.a(this.sMv).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(110393);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(110392);
    StoryCommentInputView.a(this.sMv).avk(paramString);
    AppMethodBeat.o(110392);
  }
  
  public final void bag()
  {
    AppMethodBeat.i(151172);
    if (StoryCommentInputView.b(this.sMv))
    {
      Object localObject = i.sFa;
      i.FU(9);
      localObject = StoryCommentInputView.a(this.sMv).getText();
      if (localObject != null)
      {
        StoryCommentInputView.c(this.sMv);
        StoryCommentInputView.a(this.sMv).setText(null);
        StoryCommentInputView.d(this.sMv).setVisibility(8);
        StoryCommentInputView.e(this.sMv).setVisibility(4);
        m localm = this.sMv.getCommentInputCallback();
        if (localm != null)
        {
          localm.h(localObject.toString(), Boolean.TRUE);
          AppMethodBeat.o(151172);
          return;
        }
        AppMethodBeat.o(151172);
        return;
      }
    }
    AppMethodBeat.o(151172);
  }
  
  public final void fT(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.b
 * JD-Core Version:    0.7.0.1
 */