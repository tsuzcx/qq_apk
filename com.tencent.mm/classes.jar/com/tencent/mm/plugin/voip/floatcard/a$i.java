package com.tencent.mm.plugin.voip.floatcard;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class a$i
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  a$i(Bitmap paramBitmap, a parama, View paramView1, ImageView paramImageView, View paramView2, d<? super i> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(292294);
    paramObject = (d)new i(this.UvE, this.UvA, this.GMO, this.UvC, this.evk, paramd);
    AppMethodBeat.o(292294);
    return paramObject;
  }
  
  public final Object invokeSuspend(final Object paramObject)
  {
    AppMethodBeat.i(292282);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(292282);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.UvE;
      if (paramObject == null) {}
      Object localObject;
      for (paramObject = null;; paramObject = a.i(paramObject, ((View)localObject).getWidth(), ((View)localObject).getHeight()))
      {
        localObject = (f)bg.kCh();
        paramObject = (m)new k(this.UvC, this.evk)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(292250);
            paramAnonymousObject = (d)new 1(this.UvC, this.evk, this.GMO, paramObject, paramAnonymousd);
            AppMethodBeat.o(292250);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(292245);
            Object localObject1 = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(292245);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = this.UvC;
            localObject1 = this.UvC.getLayoutParams();
            Object localObject2 = this.GMO;
            ((ViewGroup.LayoutParams)localObject1).width = ((View)localObject2).getWidth();
            ((ViewGroup.LayoutParams)localObject1).height = ((View)localObject2).getHeight();
            localObject2 = ah.aiuX;
            paramAnonymousObject.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramAnonymousObject = this.evk;
            localObject1 = this.evk.getLayoutParams();
            localObject2 = this.GMO;
            ((ViewGroup.LayoutParams)localObject1).width = ((View)localObject2).getWidth();
            ((ViewGroup.LayoutParams)localObject1).height = ((View)localObject2).getHeight();
            localObject2 = ah.aiuX;
            paramAnonymousObject.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.evk.setBackground((Drawable)new BitmapDrawable(this.GMO.getResources(), paramObject));
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(292245);
            return paramAnonymousObject;
          }
        };
        d locald = (d)this;
        this.label = 1;
        if (l.a((f)localObject, paramObject, locald) != locala) {
          break;
        }
        AppMethodBeat.o(292282);
        return locala;
        localObject = this.GMO;
      }
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = ah.aiuX;
    AppMethodBeat.o(292282);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.floatcard.a.i
 * JD-Core Version:    0.7.0.1
 */