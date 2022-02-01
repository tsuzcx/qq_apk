package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/MultiTalkDrawingView;", "Lcom/tencent/mm/view/BaseDrawingView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createBoardView", "Lcom/tencent/mm/view/board/BaseBoardView;", "createFooterView", "Lcom/tencent/mm/view/footer/BaseFooterView;", "getFeatures", "", "Lcom/tencent/mm/api/FeaturesType;", "()[Lcom/tencent/mm/api/FeaturesType;", "Companion", "plugin-photoedit-sdk_release"})
public final class l
  extends a
{
  public static final a YLF;
  
  static
  {
    AppMethodBeat.i(260158);
    YLF = new a((byte)0);
    AppMethodBeat.o(260158);
  }
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final h[] getFeatures()
  {
    AppMethodBeat.i(260157);
    if (this.YKd == null) {
      this.YKd = new h[] { h.fan, h.fap, h.fao, h.faq, h.far };
    }
    h[] arrayOfh = this.YKd;
    p.j(arrayOfh, "mFeaturesTypes");
    AppMethodBeat.o(260157);
    return arrayOfh;
  }
  
  protected final com.tencent.mm.view.b.a igR()
  {
    AppMethodBeat.i(260155);
    com.tencent.mm.view.b.a locala = (com.tencent.mm.view.b.a)new com.tencent.mm.view.b.b(getContext(), getPresenter());
    AppMethodBeat.o(260155);
    return locala;
  }
  
  protected final com.tencent.mm.view.footer.a igS()
  {
    AppMethodBeat.i(260156);
    Object localObject = getContext();
    p.j(localObject, "context");
    com.tencent.mm.ca.b localb = getPresenter();
    p.j(localb, "presenter");
    localObject = (com.tencent.mm.view.footer.a)new com.tencent.mm.view.footer.b((Context)localObject, localb);
    AppMethodBeat.o(260156);
    return localObject;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/MultiTalkDrawingView$Companion;", "", "()V", "TAG", "", "plugin-photoedit-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.l
 * JD-Core Version:    0.7.0.1
 */