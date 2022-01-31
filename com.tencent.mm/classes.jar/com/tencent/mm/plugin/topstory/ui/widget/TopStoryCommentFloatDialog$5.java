package com.tencent.mm.plugin.topstory.ui.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryCommentFloatDialog$5
  extends Animation
{
  TopStoryCommentFloatDialog$5(TopStoryCommentFloatDialog paramTopStoryCommentFloatDialog, int paramInt) {}
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    AppMethodBeat.i(2247);
    paramTransformation = (RelativeLayout.LayoutParams)this.tmJ.tmE.getLayoutParams();
    paramTransformation.bottomMargin = ((int)(this.jmM * paramFloat));
    this.tmJ.tmE.setLayoutParams(paramTransformation);
    AppMethodBeat.o(2247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.5
 * JD-Core Version:    0.7.0.1
 */