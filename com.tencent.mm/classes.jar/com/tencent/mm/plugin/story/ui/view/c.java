package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/CommentInputDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentInputView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "getCommentInputView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "setCommentInputView", "(Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;)V", "params", "Landroid/view/ViewGroup$LayoutParams;", "getParams", "()Landroid/view/ViewGroup$LayoutParams;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends e
{
  StoryCommentInputView SwI;
  private final ViewGroup.LayoutParams nxi;
  
  public c(Context paramContext)
  {
    super(paramContext, a.h.Sib);
    AppMethodBeat.i(120021);
    this.SwI = new StoryCommentInputView(paramContext);
    this.nxi = new ViewGroup.LayoutParams(-1, -1);
    bU();
    AppMethodBeat.o(120021);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(120020);
    if (!StoryCommentInputView.aAx()) {
      super.onBackPressed();
    }
    AppMethodBeat.o(120020);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(120018);
    setContentView((View)this.SwI, this.nxi);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(67108864);
      paramBundle.setLayout(-1, -1);
      paramBundle.setSoftInputMode(36);
    }
    AppMethodBeat.o(120018);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(120019);
    super.onStart();
    this.SwI.requestFocus();
    AppMethodBeat.o(120019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.c
 * JD-Core Version:    0.7.0.1
 */