package com.tencent.mm.ui.tools;

import android.content.ContentResolver;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

final class AddFavoriteUI$a
  implements Runnable
{
  private AddFavoriteUI.b Aqq;
  private Uri mUri;
  
  public AddFavoriteUI$a(AddFavoriteUI paramAddFavoriteUI, Uri paramUri, AddFavoriteUI.b paramb)
  {
    this.mUri = paramUri;
    this.Aqq = paramb;
  }
  
  public final void run()
  {
    AppMethodBeat.i(34758);
    this.Aqp.filePath = AddFavoriteUI.a(this.Aqp, this.mUri);
    if ((bo.isNullOrNil(this.Aqp.filePath)) || (!new File(this.Aqp.filePath).exists())) {
      if (AddFavoriteUI.auP(this.Aqp.getContentResolver().getType(this.mUri)) != 2) {
        break label121;
      }
    }
    label121:
    for (this.Aqp.filePath = e.a(this.Aqp.getContentResolver(), this.mUri, 1);; this.Aqp.filePath = e.a(this.Aqp.getContentResolver(), this.mUri))
    {
      if (this.Aqq != null) {
        this.Aqq.dND();
      }
      AppMethodBeat.o(34758);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AddFavoriteUI.a
 * JD-Core Version:    0.7.0.1
 */