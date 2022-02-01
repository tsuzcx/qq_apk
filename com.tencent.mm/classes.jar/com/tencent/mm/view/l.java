package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/MultiTalkDrawingView;", "Lcom/tencent/mm/view/BaseDrawingView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createBoardView", "Lcom/tencent/mm/view/board/BaseBoardView;", "createFooterView", "Lcom/tencent/mm/view/footer/BaseFooterView;", "getFeatures", "", "Lcom/tencent/mm/api/FeaturesType;", "()[Lcom/tencent/mm/api/FeaturesType;", "Companion", "plugin-photoedit-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends a
{
  public static final l.a agHr;
  
  static
  {
    AppMethodBeat.i(234674);
    agHr = new l.a((byte)0);
    AppMethodBeat.o(234674);
  }
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final i[] getFeatures()
  {
    AppMethodBeat.i(234686);
    if (this.agFV == null) {
      this.agFV = new i[] { i.hdO, i.hdQ, i.hdP, i.hdR, i.hdS };
    }
    i[] arrayOfi = this.agFV;
    s.s(arrayOfi, "mFeaturesTypes");
    AppMethodBeat.o(234686);
    return arrayOfi;
  }
  
  protected final com.tencent.mm.view.b.a jMg()
  {
    AppMethodBeat.i(234676);
    com.tencent.mm.view.b.a locala = (com.tencent.mm.view.b.a)new com.tencent.mm.view.b.b(getContext(), getPresenter());
    AppMethodBeat.o(234676);
    return locala;
  }
  
  protected final com.tencent.mm.view.footer.a jMh()
  {
    AppMethodBeat.i(234682);
    Object localObject = getContext();
    s.s(localObject, "context");
    com.tencent.mm.bt.b localb = getPresenter();
    s.s(localb, "presenter");
    localObject = (com.tencent.mm.view.footer.a)new com.tencent.mm.view.footer.b((Context)localObject, localb);
    AppMethodBeat.o(234682);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.l
 * JD-Core Version:    0.7.0.1
 */