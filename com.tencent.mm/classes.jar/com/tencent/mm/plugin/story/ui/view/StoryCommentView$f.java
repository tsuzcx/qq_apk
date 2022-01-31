package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
final class StoryCommentView$f
  implements DialogInterface.OnDismissListener
{
  StoryCommentView$f(StoryCommentView paramStoryCommentView) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(110419);
    this.sMZ.oq(2);
    StoryCommentView localStoryCommentView;
    if (!StoryCommentView.d(this.sMZ))
    {
      localStoryCommentView = this.sMZ;
      paramDialogInterface = StoryCommentView.e(this.sMZ);
      if (paramDialogInterface == null) {
        break label90;
      }
      paramDialogInterface = paramDialogInterface.sLt;
      if (paramDialogInterface == null) {
        break label90;
      }
    }
    label90:
    for (paramDialogInterface = paramDialogInterface.getContent();; paramDialogInterface = null)
    {
      StoryCommentView.a(localStoryCommentView, paramDialogInterface);
      paramDialogInterface = StoryCommentView.e(this.sMZ);
      if (paramDialogInterface == null) {
        break;
      }
      paramDialogInterface = paramDialogInterface.sLt;
      if (paramDialogInterface == null) {
        break;
      }
      paramDialogInterface.destroy();
      AppMethodBeat.o(110419);
      return;
    }
    AppMethodBeat.o(110419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.f
 * JD-Core Version:    0.7.0.1
 */