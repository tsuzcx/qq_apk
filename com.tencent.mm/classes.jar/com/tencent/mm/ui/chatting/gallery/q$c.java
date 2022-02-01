package com.tencent.mm.ui.chatting.gallery;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class q$c
  extends k
  implements m<kotlinx.coroutines.aq, d<? super ah>, Object>
{
  int label;
  
  q$c(TextView paramTextView, String paramString, d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(254745);
    paramObject = (d)new c(this.EEk, this.eWL, paramd);
    AppMethodBeat.o(254745);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(254740);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(254740);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      bh.bCz();
      paramObject = c.ban().get(at.a.acOt, Integer.valueOf(0));
      if (paramObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(254740);
        throw paramObject;
      }
      if (((Integer)paramObject).intValue() != 1) {
        break label190;
      }
      paramObject = (kotlin.d.f)bg.kCi();
      localObject = (m)new a(this.eWL, null);
      d locald = (d)this;
      this.label = 1;
      localObject = l.a(paramObject, (m)localObject, locald);
      paramObject = localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(254740);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = (String)paramObject;
    Object localObject = this.EEk;
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText((CharSequence)paramObject);
    label190:
    paramObject = ah.aiuX;
    AppMethodBeat.o(254740);
    return paramObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<kotlinx.coroutines.aq, d<? super String>, Object>
  {
    int label;
    
    a(String paramString, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(254724);
      paramObject = (d)new a(this.eWL, paramd);
      AppMethodBeat.o(254724);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(254719);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(254719);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = com.tencent.mm.plugin.sight.base.f.aMu(this.eWL);
      AppMethodBeat.o(254719);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.q.c
 * JD-Core Version:    0.7.0.1
 */