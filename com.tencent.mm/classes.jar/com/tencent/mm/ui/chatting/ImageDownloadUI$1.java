package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;

final class ImageDownloadUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ImageDownloadUI$1(ImageDownloadUI paramImageDownloadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    au.Dk().c(ImageDownloadUI.a(this.vmu));
    this.vmu.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ImageDownloadUI.1
 * JD-Core Version:    0.7.0.1
 */