package com.tencent.mm.view.footer;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/footer/MultitalkScreenFooterView;", "Lcom/tencent/mm/view/footer/PhotoFooterView;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "(Landroid/content/Context;Lcom/tencent/mm/presenter/IPresenter;)V", "getColor", "", "index", "Companion", "plugin-photoedit-sdk_release"})
public final class b
  extends c
{
  private static final int HPJ = -855310;
  private static final int HPK = -16777216;
  private static final int HPL = -707825;
  private static final int HPM = -17592;
  private static final int HPN = -16535286;
  private static final int HPO = -15172610;
  private static final int HPP = -7054596;
  private static final int HPQ = -449092;
  private static final int[] YQk;
  public static final a YQq;
  
  static
  {
    AppMethodBeat.i(260116);
    YQq = new a((byte)0);
    HPJ = -855310;
    HPK = -16777216;
    HPL = -707825;
    HPM = -17592;
    HPN = -16535286;
    HPO = -15172610;
    HPP = -7054596;
    HPQ = -449092;
    YQk = new int[] { HPJ, HPK, HPL, HPM, HPN, HPO, HPP, HPQ };
    AppMethodBeat.o(260116);
  }
  
  public b(Context paramContext, com.tencent.mm.ca.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(260114);
    AppMethodBeat.o(260114);
  }
  
  public final int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < YQk.length)) {
      return YQk[paramInt];
    }
    return -65536;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/footer/MultitalkScreenFooterView$Companion;", "", "()V", "COLOR_0", "", "COLOR_1", "COLOR_2", "COLOR_3", "COLOR_4", "COLOR_5", "COLOR_6", "COLOR_7", "mColorsDoodle", "", "getMColorsDoodle", "()[I", "plugin-photoedit-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.footer.b
 * JD-Core Version:    0.7.0.1
 */