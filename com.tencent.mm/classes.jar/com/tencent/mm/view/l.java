package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/MultiTalkDrawingView;", "Lcom/tencent/mm/view/BaseDrawingView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createBoardView", "Lcom/tencent/mm/view/board/BaseBoardView;", "createFooterView", "Lcom/tencent/mm/view/footer/BaseFooterView;", "getFeatures", "", "Lcom/tencent/mm/api/FeaturesType;", "()[Lcom/tencent/mm/api/FeaturesType;", "Companion", "plugin-photoedit-sdk_release"})
public final class l
  extends a
{
  public static final l.a Rka;
  
  static
  {
    AppMethodBeat.i(204704);
    Rka = new l.a((byte)0);
    AppMethodBeat.o(204704);
  }
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final h[] getFeatures()
  {
    AppMethodBeat.i(204703);
    if (this.Riw == null) {
      this.Riw = new h[] { h.diH, h.diJ, h.diI, h.diK, h.diL };
    }
    h[] arrayOfh = this.Riw;
    p.g(arrayOfh, "mFeaturesTypes");
    AppMethodBeat.o(204703);
    return arrayOfh;
  }
  
  protected final com.tencent.mm.view.b.a hfv()
  {
    AppMethodBeat.i(204701);
    com.tencent.mm.view.b.a locala = (com.tencent.mm.view.b.a)new com.tencent.mm.view.b.b(getContext(), getPresenter());
    AppMethodBeat.o(204701);
    return locala;
  }
  
  protected final com.tencent.mm.view.footer.a hfw()
  {
    AppMethodBeat.i(204702);
    Object localObject = getContext();
    p.g(localObject, "context");
    com.tencent.mm.bt.b localb = getPresenter();
    p.g(localb, "presenter");
    localObject = (com.tencent.mm.view.footer.a)new com.tencent.mm.view.footer.b((Context)localObject, localb);
    AppMethodBeat.o(204702);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.l
 * JD-Core Version:    0.7.0.1
 */