package com.tencent.mm.view.footer;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/footer/MultitalkScreenFooterView;", "Lcom/tencent/mm/view/footer/PhotoFooterView;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "(Landroid/content/Context;Lcom/tencent/mm/presenter/IPresenter;)V", "getColor", "", "index", "Companion", "plugin-photoedit-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c
{
  private static final int NMp;
  private static final int NMq;
  private static final int NMr;
  private static final int NMs;
  private static final int NMt;
  private static final int NMu;
  private static final int NMv;
  private static final int NMw;
  private static final int[] agLQ;
  public static final b.a agLW;
  
  static
  {
    AppMethodBeat.i(235007);
    agLW = new b.a((byte)0);
    NMp = -855310;
    NMq = -16777216;
    NMr = -707825;
    NMs = -17592;
    NMt = -16535286;
    NMu = -15172610;
    NMv = -7054596;
    NMw = -449092;
    agLQ = new int[] { NMp, NMq, NMr, NMs, NMt, NMu, NMv, NMw };
    AppMethodBeat.o(235007);
  }
  
  public b(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(235003);
    AppMethodBeat.o(235003);
  }
  
  public final int getColor(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < agLQ.length)) {
      return agLQ[paramInt];
    }
    return -65536;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.footer.b
 * JD-Core Version:    0.7.0.1
 */