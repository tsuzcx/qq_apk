package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMNewPhotoEditUI$1
  implements Runnable
{
  MMNewPhotoEditUI$1(MMNewPhotoEditUI paramMMNewPhotoEditUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(11919);
    ab.i("MicroMsg.MMNewPhotoEditUI", "connected!!!");
    MMNewPhotoEditUI.a(this.zcs);
    this.zcs.initView();
    AppMethodBeat.o(11919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.MMNewPhotoEditUI.1
 * JD-Core Version:    0.7.0.1
 */