package com.tencent.mm.wear.app.ui.img;

import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.ui.MMActivity;
import com.tencent.mm.wear.app.ui.widget.d;

final class b
  extends com.tencent.mm.wear.app.g.a
{
  private b(DetailImgUI paramDetailImgUI) {}
  
  protected final void execute()
  {
    if (DetailImgUI.c(this.aga) != null)
    {
      DetailImgUI.a(this.aga).setImageBitmap(DetailImgUI.c(this.aga));
      DetailImgUI.d(this.aga).nD();
      return;
    }
    com.tencent.mm.wear.app.c.a locala = new com.tencent.mm.wear.app.c.a();
    locala.acM = 2131427357;
    locala.acL = DetailImgUI.a(this.aga);
    locala.type = 2;
    locala.acG = DetailImgUI.b(this.aga);
    locala.width = MMActivity.nc();
    locala.height = MMActivity.nb();
    h.me().a(locala);
    DetailImgUI.a(this.aga, h.me().b(locala));
    if (DetailImgUI.c(this.aga) != null)
    {
      DetailImgUI.a(this.aga).setImageBitmap(DetailImgUI.c(this.aga));
      DetailImgUI.d(this.aga).nD();
      return;
    }
    DetailImgUI.d(this.aga).setError();
  }
  
  protected final String getName()
  {
    return "RenderImageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.img.b
 * JD-Core Version:    0.7.0.1
 */