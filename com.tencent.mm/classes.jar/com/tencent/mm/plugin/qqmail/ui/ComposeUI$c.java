package com.tencent.mm.plugin.qqmail.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComposeUI$c
  extends MailAddrsViewControl.c
{
  private ImageView pMk;
  private int tag;
  
  public ComposeUI$c(ComposeUI paramComposeUI, ImageView paramImageView, int paramInt)
  {
    this.pMk = paramImageView;
    this.tag = paramInt;
  }
  
  public final void kk(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(68212);
    ComposeUI.y(this.pLX);
    Object localObject;
    if (this.pLX.pLC) {
      localObject = this.pMk;
    }
    for (;;)
    {
      ((ImageView)localObject).setVisibility(i);
      if (((this.tag == 1) || (this.tag == 2)) && (!paramBoolean)) {
        ComposeUI.z(this.pLX).postDelayed(new ComposeUI.c.1(this), 10L);
      }
      AppMethodBeat.o(68212);
      return;
      ImageView localImageView = this.pMk;
      localObject = localImageView;
      if (!paramBoolean)
      {
        i = 4;
        localObject = localImageView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.c
 * JD-Core Version:    0.7.0.1
 */