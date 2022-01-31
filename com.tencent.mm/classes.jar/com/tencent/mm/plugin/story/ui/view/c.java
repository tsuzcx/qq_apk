package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/CommentInputDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentInputView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "getCommentInputView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "setCommentInputView", "(Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;)V", "params", "Landroid/view/ViewGroup$LayoutParams;", "getParams", "()Landroid/view/ViewGroup$LayoutParams;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class c
  extends e
{
  private final ViewGroup.LayoutParams oNt;
  StoryCommentInputView sLt;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131493172);
    AppMethodBeat.i(110341);
    this.sLt = new StoryCommentInputView(paramContext);
    this.oNt = new ViewGroup.LayoutParams(-1, -1);
    eS();
    AppMethodBeat.o(110341);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(151162);
    super.onBackPressed();
    AppMethodBeat.o(151162);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110340);
    setContentView((View)this.sLt, this.oNt);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(67108864);
      paramBundle.setLayout(-1, -1);
      paramBundle.setSoftInputMode(36);
      AppMethodBeat.o(110340);
      return;
    }
    AppMethodBeat.o(110340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.c
 * JD-Core Version:    0.7.0.1
 */