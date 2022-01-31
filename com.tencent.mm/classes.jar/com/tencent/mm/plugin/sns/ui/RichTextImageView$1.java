package com.tencent.mm.plugin.sns.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class RichTextImageView$1
  implements Runnable
{
  RichTextImageView$1(RichTextImageView paramRichTextImageView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(38546);
    RichTextImageView.b(this.rLc).setText(RichTextImageView.a(this.rLc).substring(0, this.rLb));
    RichTextImageView.c(this.rLc).setText(RichTextImageView.a(this.rLc).substring(this.rLb, RichTextImageView.a(this.rLc).length()));
    RichTextImageView.c(this.rLc).invalidate();
    RichTextImageView.d(this.rLc);
    ab.e("test", "bottomH:" + RichTextImageView.c(this.rLc).getHeight());
    AppMethodBeat.o(38546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RichTextImageView.1
 * JD-Core Version:    0.7.0.1
 */