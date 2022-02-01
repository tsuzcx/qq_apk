package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/CommentInputDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentInputView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "getCommentInputView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "setCommentInputView", "(Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;)V", "params", "Landroid/view/ViewGroup$LayoutParams;", "getParams", "()Landroid/view/ViewGroup$LayoutParams;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "plugin-story_release"})
public final class c
  extends e
{
  private final ViewGroup.LayoutParams FfH;
  StoryCommentInputView LUI;
  
  public c(Context paramContext)
  {
    super(paramContext, a.h.LEq);
    AppMethodBeat.i(120021);
    this.LUI = new StoryCommentInputView(paramContext);
    this.FfH = new ViewGroup.LayoutParams(-1, -1);
    bb();
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
    setContentView((View)this.LUI, this.FfH);
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
    this.LUI.requestFocus();
    AppMethodBeat.o(120019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.c
 * JD-Core Version:    0.7.0.1
 */