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
    if (DetailImgUI.c(this.ajC) != null)
    {
      DetailImgUI.a(this.ajC).setImageBitmap(DetailImgUI.c(this.ajC));
      DetailImgUI.d(this.ajC).or();
      return;
    }
    com.tencent.mm.wear.app.c.a locala = new com.tencent.mm.wear.app.c.a();
    locala.agn = 2131427357;
    locala.agm = DetailImgUI.a(this.ajC);
    locala.type = 2;
    locala.agh = DetailImgUI.b(this.ajC);
    locala.width = MMActivity.nP();
    locala.height = MMActivity.nO();
    h.mR().a(locala);
    DetailImgUI.a(this.ajC, h.mR().b(locala));
    if (DetailImgUI.c(this.ajC) != null)
    {
      DetailImgUI.a(this.ajC).setImageBitmap(DetailImgUI.c(this.ajC));
      DetailImgUI.d(this.ajC).or();
      return;
    }
    DetailImgUI.d(this.ajC).setError();
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