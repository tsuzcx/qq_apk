package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class AddFavoriteUI$12
  extends ak
{
  AddFavoriteUI$12(AddFavoriteUI paramAddFavoriteUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(34754);
    AddFavoriteUI.d(this.Aqp);
    if ((bo.isNullOrNil(this.Aqp.filePath)) || ((bo.aqi(this.Aqp.filePath)) && (!AddFavoriteUI.auO(this.Aqp.filePath))))
    {
      ab.e("MicroMsg.AddFavoriteUI", "launch : fail, filePath is null or file is not a valid img.");
      AddFavoriteUI.g(this.Aqp);
      this.Aqp.finish();
      AppMethodBeat.o(34754);
      return;
    }
    AddFavoriteUI.h(this.Aqp);
    AppMethodBeat.o(34754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AddFavoriteUI.12
 * JD-Core Version:    0.7.0.1
 */