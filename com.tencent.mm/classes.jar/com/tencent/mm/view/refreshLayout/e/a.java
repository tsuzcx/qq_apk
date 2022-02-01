package com.tencent.mm.view.refreshLayout.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/status/DimensionStatus;", "", "ordinal", "", "notified", "", "(IZ)V", "getNotified", "()Z", "getOrdinal", "()I", "canReplaceWith", "status", "unNotify", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final a agQA;
  private static final a agQB;
  private static final a agQC;
  private static final a agQD;
  private static final a agQE;
  private static final a agQF;
  private static final a agQG;
  private static final a[] agQH;
  public static final a agQt;
  private static final a agQv;
  private static final a agQw;
  private static final a agQx;
  private static final a agQy;
  private static final a agQz;
  public final boolean Mwc;
  public final int agQu;
  
  static
  {
    AppMethodBeat.i(235174);
    agQt = new a((byte)0);
    agQv = new a(0, false);
    agQw = new a(1, true);
    agQx = new a(2, false);
    agQy = new a(3, true);
    agQz = new a(4, false);
    agQA = new a(5, true);
    agQB = new a(6, false);
    agQC = new a(7, true);
    agQD = new a(8, false);
    agQE = new a(9, true);
    agQF = new a(10, false);
    agQG = new a(10, true);
    agQH = new a[] { agQv, agQw, agQx, agQy, agQz, agQA, agQB, agQC, agQD, agQE, agQF, agQG };
    AppMethodBeat.o(235174);
  }
  
  private a(int paramInt, boolean paramBoolean)
  {
    this.agQu = paramInt;
    this.Mwc = paramBoolean;
  }
  
  public final boolean c(a parama)
  {
    AppMethodBeat.i(235181);
    s.u(parama, "status");
    if ((this.agQu < parama.agQu) || (((!this.Mwc) || (agQE == this)) && (this.agQu == parama.agQu)))
    {
      AppMethodBeat.o(235181);
      return true;
    }
    AppMethodBeat.o(235181);
    return false;
  }
  
  public final a jNB()
  {
    a locala = this;
    if (!this.Mwc) {
      locala = agQH[(this.agQu + 1)];
    }
    return locala;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/status/DimensionStatus$Companion;", "", "()V", "CodeExact", "Lcom/tencent/mm/view/refreshLayout/status/DimensionStatus;", "getCodeExact", "()Lcom/tencent/mm/view/refreshLayout/status/DimensionStatus;", "CodeExactUnNotify", "getCodeExactUnNotify", "DeadLock", "getDeadLock", "DeadLockUnNotify", "getDeadLockUnNotify", "Default", "getDefault", "DefaultUnNotify", "getDefaultUnNotify", "XmlExact", "getXmlExact", "XmlExactUnNotify", "getXmlExactUnNotify", "XmlLayout", "getXmlLayout", "XmlLayoutUnNotify", "getXmlLayoutUnNotify", "XmlWrap", "getXmlWrap", "XmlWrapUnNotify", "getXmlWrapUnNotify", "values", "", "[Lcom/tencent/mm/view/refreshLayout/status/DimensionStatus;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.e.a
 * JD-Core Version:    0.7.0.1
 */