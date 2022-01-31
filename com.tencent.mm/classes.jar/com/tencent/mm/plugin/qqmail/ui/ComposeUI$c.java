package com.tencent.mm.plugin.qqmail.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;

final class ComposeUI$c
  extends MailAddrsViewControl.c
{
  private ImageView ngW;
  private int tag;
  
  public ComposeUI$c(ComposeUI paramComposeUI, ImageView paramImageView, int paramInt)
  {
    this.ngW = paramImageView;
    this.tag = paramInt;
  }
  
  public final void ij(boolean paramBoolean)
  {
    int i = 0;
    ComposeUI.y(this.ngJ);
    Object localObject;
    if (this.ngJ.ngo) {
      localObject = this.ngW;
    }
    for (;;)
    {
      ((ImageView)localObject).setVisibility(i);
      if (((this.tag == 1) || (this.tag == 2)) && (!paramBoolean)) {
        ComposeUI.z(this.ngJ).postDelayed(new ComposeUI.c.1(this), 10L);
      }
      return;
      ImageView localImageView = this.ngW;
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