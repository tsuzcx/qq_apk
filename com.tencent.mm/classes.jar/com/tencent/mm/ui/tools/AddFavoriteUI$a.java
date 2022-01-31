package com.tencent.mm.ui.tools;

import android.content.ContentResolver;
import android.net.Uri;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;

final class AddFavoriteUI$a
  implements Runnable
{
  private Uri mUri;
  private AddFavoriteUI.b vYe;
  
  public AddFavoriteUI$a(AddFavoriteUI paramAddFavoriteUI, Uri paramUri, AddFavoriteUI.b paramb)
  {
    this.mUri = paramUri;
    this.vYe = paramb;
  }
  
  public final void run()
  {
    this.vYd.filePath = AddFavoriteUI.a(this.vYd, this.mUri);
    if ((bk.bl(this.vYd.filePath)) || (!new File(this.vYd.filePath).exists())) {
      if (AddFavoriteUI.aei(this.vYd.getContentResolver().getType(this.mUri)) != 2) {
        break label111;
      }
    }
    label111:
    for (this.vYd.filePath = d.a(this.vYd.getContentResolver(), this.mUri, 1);; this.vYd.filePath = d.a(this.vYd.getContentResolver(), this.mUri))
    {
      if (this.vYe != null) {
        this.vYe.cIP();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AddFavoriteUI.a
 * JD-Core Version:    0.7.0.1
 */