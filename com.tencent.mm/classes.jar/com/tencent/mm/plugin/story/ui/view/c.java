package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/CommentInputDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentInputView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "getCommentInputView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "setCommentInputView", "(Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;)V", "params", "Landroid/view/ViewGroup$LayoutParams;", "getParams", "()Landroid/view/ViewGroup$LayoutParams;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "plugin-story_release"})
public final class c
  extends e
{
  StoryCommentInputView BpS;
  private final ViewGroup.LayoutParams wgm;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131820846);
    AppMethodBeat.i(120021);
    this.BpS = new StoryCommentInputView(paramContext);
    this.wgm = new ViewGroup.LayoutParams(-1, -1);
    gK();
    AppMethodBeat.o(120021);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(120020);
    super.onBackPressed();
    AppMethodBeat.o(120020);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(120018);
    setContentView((View)this.BpS, this.wgm);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(67108864);
      paramBundle.setLayout(-1, -1);
      paramBundle.setSoftInputMode(36);
      AppMethodBeat.o(120018);
      return;
    }
    AppMethodBeat.o(120018);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(120019);
    super.onStart();
    this.BpS.requestFocus();
    AppMethodBeat.o(120019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.c
 * JD-Core Version:    0.7.0.1
 */