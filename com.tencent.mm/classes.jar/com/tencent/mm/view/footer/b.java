package com.tencent.mm.view.footer;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/footer/MultitalkScreenFooterView;", "Lcom/tencent/mm/view/footer/PhotoFooterView;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "(Landroid/content/Context;Lcom/tencent/mm/presenter/IPresenter;)V", "getColor", "", "index", "Companion", "plugin-photoedit-sdk_release"})
public final class b
  extends c
{
  private static final int BSV = -855310;
  private static final int BSW = -16777216;
  private static final int BSX = -707825;
  private static final int BSY = -17592;
  private static final int BSZ = -16535286;
  private static final int BTa = -15172610;
  private static final int BTb = -7054596;
  private static final int BTc = -449092;
  private static final int[] RoQ;
  public static final b.a RoW;
  
  static
  {
    AppMethodBeat.i(204714);
    RoW = new b.a((byte)0);
    BSV = -855310;
    BSW = -16777216;
    BSX = -707825;
    BSY = -17592;
    BSZ = -16535286;
    BTa = -15172610;
    BTb = -7054596;
    BTc = -449092;
    RoQ = new int[] { BSV, BSW, BSX, BSY, BSZ, BTa, BTb, BTc };
    AppMethodBeat.o(204714);
  }
  
  public b(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(204713);
    AppMethodBeat.o(204713);
  }
  
  public final int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < RoQ.length)) {
      return RoQ[paramInt];
    }
    return -65536;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.footer.b
 * JD-Core Version:    0.7.0.1
 */