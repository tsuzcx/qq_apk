package com.tencent.mm.plugin.sns.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;

final class RichTextImageView$1
  implements Runnable
{
  RichTextImageView$1(RichTextImageView paramRichTextImageView, int paramInt) {}
  
  public final void run()
  {
    RichTextImageView.b(this.oTf).setText(RichTextImageView.a(this.oTf).substring(0, this.oTe));
    RichTextImageView.c(this.oTf).setText(RichTextImageView.a(this.oTf).substring(this.oTe, RichTextImageView.a(this.oTf).length()));
    RichTextImageView.c(this.oTf).invalidate();
    RichTextImageView.d(this.oTf);
    y.e("test", "bottomH:" + RichTextImageView.c(this.oTf).getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RichTextImageView.1
 * JD-Core Version:    0.7.0.1
 */