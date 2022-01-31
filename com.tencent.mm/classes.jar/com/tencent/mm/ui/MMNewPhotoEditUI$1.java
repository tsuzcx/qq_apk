package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.y;

final class MMNewPhotoEditUI$1
  implements Runnable
{
  MMNewPhotoEditUI$1(MMNewPhotoEditUI paramMMNewPhotoEditUI) {}
  
  public final void run()
  {
    y.i("MicroMsg.MMNewPhotoEditUI", "connected!!!");
    MMNewPhotoEditUI.a(this.uOz);
    this.uOz.initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.MMNewPhotoEditUI.1
 * JD-Core Version:    0.7.0.1
 */