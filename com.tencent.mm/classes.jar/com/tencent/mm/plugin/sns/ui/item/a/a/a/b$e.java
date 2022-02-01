package com.tencent.mm.plugin.sns.ui.item.a.a.a;

import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.helper.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.helper.a.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$UIModel;", "", "thumb", "Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ThumbResult;", "sight", "Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;", "breakSight", "uiLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "playState", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$PlayStates;", "(Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ThumbResult;Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;Landroid/view/ViewGroup$LayoutParams;Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$PlayStates;)V", "getBreakSight", "()Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;", "getPlayState", "()Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$PlayStates;", "getSight", "getThumb", "()Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ThumbResult;", "getUiLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$e
{
  final a.c ROF;
  final a.c ROG;
  final a.b ROM;
  final ViewGroup.LayoutParams RON;
  final b.d ROO;
  
  public b$e(a.b paramb, a.c paramc1, a.c paramc2, ViewGroup.LayoutParams paramLayoutParams, b.d paramd)
  {
    AppMethodBeat.i(309125);
    this.ROM = paramb;
    this.ROF = paramc1;
    this.ROG = paramc2;
    this.RON = paramLayoutParams;
    this.ROO = paramd;
    AppMethodBeat.o(309125);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(309141);
    if (this == paramObject)
    {
      AppMethodBeat.o(309141);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(309141);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.ROM, paramObject.ROM))
    {
      AppMethodBeat.o(309141);
      return false;
    }
    if (!s.p(this.ROF, paramObject.ROF))
    {
      AppMethodBeat.o(309141);
      return false;
    }
    if (!s.p(this.ROG, paramObject.ROG))
    {
      AppMethodBeat.o(309141);
      return false;
    }
    if (!s.p(this.RON, paramObject.RON))
    {
      AppMethodBeat.o(309141);
      return false;
    }
    if (this.ROO != paramObject.ROO)
    {
      AppMethodBeat.o(309141);
      return false;
    }
    AppMethodBeat.o(309141);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(309136);
    int j = this.ROM.hashCode();
    int k = this.ROF.hashCode();
    int m = this.ROG.hashCode();
    if (this.RON == null) {}
    for (int i = 0;; i = this.RON.hashCode())
    {
      int n = this.ROO.hashCode();
      AppMethodBeat.o(309136);
      return (i + ((j * 31 + k) * 31 + m) * 31) * 31 + n;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(309131);
    String str = "UIModel(thumb=" + this.ROM + ", sight=" + this.ROF + ", breakSight=" + this.ROG + ", uiLayoutParams=" + this.RON + ", playState=" + this.ROO + ')';
    AppMethodBeat.o(309131);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.a.b.e
 * JD-Core Version:    0.7.0.1
 */