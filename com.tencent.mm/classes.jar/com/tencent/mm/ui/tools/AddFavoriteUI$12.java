package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class AddFavoriteUI$12
  extends ah
{
  AddFavoriteUI$12(AddFavoriteUI paramAddFavoriteUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AddFavoriteUI.d(this.vYd);
    if ((bk.bl(this.vYd.filePath)) || ((bk.aae(this.vYd.filePath)) && (!AddFavoriteUI.aeh(this.vYd.filePath))))
    {
      y.e("MicroMsg.AddFavoriteUI", "launch : fail, filePath is null or file is not a valid img.");
      AddFavoriteUI.g(this.vYd);
      this.vYd.finish();
      return;
    }
    AddFavoriteUI.h(this.vYd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AddFavoriteUI.12
 * JD-Core Version:    0.7.0.1
 */