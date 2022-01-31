package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShowCommentImageView$1
  implements View.OnClickListener
{
  ShowCommentImageView$1(ShowCommentImageView paramShowCommentImageView, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38570);
    ShowCommentImageView.a(this.rLl, true);
    this.rLk.onClick(paramView);
    AppMethodBeat.o(38570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ShowCommentImageView.1
 * JD-Core Version:    0.7.0.1
 */