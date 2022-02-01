package com.tencent.mm.sns_compose.d;

import android.graphics.Bitmap;
import androidx.compose.foundation.c.ab;
import androidx.compose.foundation.j;
import androidx.compose.runtime.aa;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.e.c.c;
import androidx.compose.ui.h.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sns_compose.b.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"AvatarImage", "", "userName", "", "size", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "Lkotlin/Function0;", "AvatarImage-DzVHIIc", "(Ljava/lang/String;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "sns-compose_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final void a(String paramString, final float paramFloat, final androidx.compose.ui.f paramf, final kotlin.g.a.a<ah> parama, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(235421);
    s.u(paramString, "userName");
    s.u(parama, "onClick");
    h localh = paramh.by(1018185740);
    int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label57:
    label64:
    label76:
    label83:
    label598:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      if ((paramInt2 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt2 & 0x4) == 0) {
          break label505;
        }
        j = 384;
        j = i | j;
        if ((paramInt2 & 0x8) == 0) {
          break label545;
        }
        i = 3072;
        label96:
        i = j | i;
        label103:
        if (((i & 0x16DB ^ 0x492) == 0) && (localh.nZ())) {
          break label588;
        }
        if ((paramInt2 & 0x4) != 0) {
          paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        }
        Object localObject2 = com.tencent.mm.aj.a.a(b.c.default_avatar, localh);
        localh.bx(-3687241);
        Object localObject1 = localh.or();
        paramh = h.alD;
        paramh = (h)localObject1;
        if (localObject1 == h.a.ox())
        {
          paramh = bj.T(localObject2);
          localh.F(paramh);
        }
        localh.od();
        localObject1 = (an)paramh;
        localh.bx(-3686552);
        boolean bool1 = localh.G(paramString);
        boolean bool2 = localh.G(localObject1);
        paramh = localh.or();
        if (!(bool2 | bool1))
        {
          localObject2 = h.alD;
          if (paramh != h.a.ox()) {
            break label585;
          }
        }
        paramh = (m)new a(paramString, (an)localObject1, null);
        localh.F(paramh);
        localh.od();
        aa.a(paramString, (m)paramh, localh);
        paramh = h((an)localObject1);
        localObject1 = androidx.compose.ui.h.d.aMF;
        localObject1 = d.a.wF();
        j.a(paramh, "avatar", androidx.compose.ui.b.d.a(androidx.compose.foundation.g.a(ab.f((androidx.compose.ui.f)androidx.compose.ui.f.aud, paramFloat).a(paramf), false, parama, 7), (ay)androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(0.1F * paramFloat))), null, (androidx.compose.ui.h.d)localObject1, 0.0F, null, localh, 56, 104);
      }
      for (;;)
      {
        paramh = localh.oh();
        if (paramh != null) {
          paramh.b((m)new b(paramString, paramFloat, paramf, parama, paramInt1, paramInt2));
        }
        AppMethodBeat.o(235421);
        return;
        if ((paramInt1 & 0xE) != 0) {
          break label598;
        }
        if (localh.G(paramString))
        {
          i = 4;
          break;
        }
        i = 2;
        break;
        i = j;
        if ((paramInt1 & 0x70) != 0) {
          break label64;
        }
        if (localh.H(paramFloat))
        {
          i = 32;
          break label57;
        }
        i = 16;
        break label57;
        label505:
        j = i;
        if ((paramInt1 & 0x380) != 0) {
          break label83;
        }
        if (localh.G(paramf))
        {
          j = 256;
          break label76;
        }
        j = 128;
        break label76;
        i = j;
        if ((paramInt1 & 0x1C00) != 0) {
          break label103;
        }
        if (localh.G(parama))
        {
          i = 2048;
          break label96;
        }
        i = 1024;
        break label96;
        break label300;
        localh.oi();
      }
    }
  }
  
  private static final c h(an<c> paraman)
  {
    AppMethodBeat.i(235428);
    paraman = (c)((bm)paraman).getValue();
    AppMethodBeat.o(235428);
    return paraman;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(String paramString, an<c> paraman, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(235472);
      paramObject = (kotlin.d.d)new a(this.pmW, this.aczx, paramd);
      AppMethodBeat.o(235472);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(235465);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(235465);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.sns_compose.a.acyR;
        Object localObject = this.pmW;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        localObject = paramObject.p((String)localObject, locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(235465);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (Bitmap)paramObject;
      if (paramObject != null) {
        this.aczx.setValue((c)new androidx.compose.ui.e.c.a(androidx.compose.ui.e.f.h(paramObject)));
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(235465);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<h, Integer, ah>
  {
    b(String paramString, float paramFloat, androidx.compose.ui.f paramf, kotlin.g.a.a<ah> parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.d.a
 * JD-Core Version:    0.7.0.1
 */