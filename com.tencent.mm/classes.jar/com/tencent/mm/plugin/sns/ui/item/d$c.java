package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class d$c
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  d$c(ImageView paramImageView, long paramLong, String paramString, d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(308978);
    paramObject = (d)new c(this.Byq, this.BdS, this.AsO, paramd);
    AppMethodBeat.o(308978);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(308975);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(308975);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (b)h.az(b.class);
      Context localContext = this.Byq.getContext();
      s.s(localContext, "iconView.context");
      long l = this.BdS;
      String str = this.AsO;
      ImageView localImageView = this.Byq;
      d locald = (d)this;
      this.label = 1;
      if (paramObject.executeCirculationFillingActivityIcon(localContext, l, str, localImageView, 3, locald) == locala)
      {
        AppMethodBeat.o(308975);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(308975);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.d.c
 * JD-Core Version:    0.7.0.1
 */