package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
final class StoryCommentView$h
  implements DialogInterface.OnDismissListener
{
  StoryCommentView$h(StoryCommentView paramStoryCommentView) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(151196);
    if (!StoryCommentView.d(this.sMZ)) {
      StoryCommentView.g(this.sMZ);
    }
    this.sMZ.oq(2);
    paramDialogInterface = StoryCommentView.e(this.sMZ);
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.sLt;
      if (paramDialogInterface != null)
      {
        paramDialogInterface.destroy();
        AppMethodBeat.o(151196);
        return;
      }
    }
    AppMethodBeat.o(151196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.h
 * JD-Core Version:    0.7.0.1
 */