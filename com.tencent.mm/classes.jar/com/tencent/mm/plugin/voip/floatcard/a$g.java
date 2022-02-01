package com.tencent.mm.plugin.voip.floatcard;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class a$g
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  a$g(ImageView paramImageView, View paramView, d<? super g> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(292280);
    paramObject = (d)new g(this.UvC, this.GMO, paramd);
    AppMethodBeat.o(292280);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(292275);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(292275);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      Object localObject = BitmapUtil.getBitmapNative(b.c.voip_video_called_blur_background);
      paramObject = (f)bg.kCh();
      localObject = (m)new k(this.UvC, this.GMO)
      {
        int label;
        
        public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
        {
          AppMethodBeat.i(292253);
          paramAnonymousObject = (d)new 1(this.UvC, this.GMO, this.UvD, paramAnonymousd);
          AppMethodBeat.o(292253);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(292247);
          Object localObject = a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(292247);
            throw paramAnonymousObject;
          }
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = this.UvC;
          localObject = new BitmapDrawable(this.GMO.getResources(), this.UvD);
          ((BitmapDrawable)localObject).setAlpha(230);
          ((BitmapDrawable)localObject).setFilterBitmap(true);
          ah localah = ah.aiuX;
          paramAnonymousObject.setBackground((Drawable)localObject);
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(292247);
          return paramAnonymousObject;
        }
      };
      d locald = (d)this;
      this.label = 1;
      if (l.a(paramObject, (m)localObject, locald) == locala)
      {
        AppMethodBeat.o(292275);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(292275);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.floatcard.a.g
 * JD-Core Version:    0.7.0.1
 */