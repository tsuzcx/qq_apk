package com.tencent.mm.plugin.sns.ui.item.a.a.a;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.helper.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.helper.a.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.t;

@Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$UIModel;", "thumb", "Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ThumbResult;", "sight", "Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;", "breakSight", "uiLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "playState", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$PlayStates;"}, k=3, mv={1, 5, 1}, xi=48)
final class b$g$1
  extends k
  implements t<a.b, a.c, a.c, FrameLayout.LayoutParams, b.d, d<? super b.e>, Object>
{
  int label;
  
  b$g$1(d<? super 1> paramd)
  {
    super(6, paramd);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(309149);
    Object localObject = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(309149);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = (a.b)this.L$0;
    localObject = (a.c)this.Uf;
    a.c localc = (a.c)this.VC;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.VD;
    b.d locald = (b.d)this.Ze;
    paramObject = new b.e(paramObject, (a.c)localObject, localc, (ViewGroup.LayoutParams)localLayoutParams, locald);
    AppMethodBeat.o(309149);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.a.b.g.1
 * JD-Core Version:    0.7.0.1
 */