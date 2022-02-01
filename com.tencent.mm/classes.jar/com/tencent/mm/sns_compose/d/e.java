package com.tencent.mm.sns_compose.d;

import android.content.Context;
import androidx.compose.b.t;
import androidx.compose.foundation.c.a.d;
import androidx.compose.foundation.c.a.l;
import androidx.compose.foundation.c.aa;
import androidx.compose.foundation.c.ab;
import androidx.compose.foundation.c.ae;
import androidx.compose.foundation.c.r;
import androidx.compose.foundation.c.y;
import androidx.compose.foundation.c.z;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.br;
import androidx.compose.runtime.p;
import androidx.compose.ui.m.f.c;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sns_compose.b.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Rest", "", "text", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "color", "Rest-RIQooxk", "(Ljava/lang/String;JJLandroidx/compose/runtime/Composer;II)V", "sns-compose_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final void a(String paramString, final long paramLong1, long paramLong2, androidx.compose.runtime.h paramh, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235418);
    paramh = paramh.by(825389950);
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label68:
    label107:
    label1389:
    for (int i = paramInt1 | i;; i = paramInt1)
    {
      int j = i;
      if ((paramInt1 & 0x70) == 0)
      {
        if (((paramInt2 & 0x2) == 0) && (paramh.y(paramLong1)))
        {
          j = 32;
          j = i | j;
        }
      }
      else
      {
        if ((paramInt1 & 0x380) != 0) {
          break label1382;
        }
        if (((paramInt2 & 0x4) != 0) || (!paramh.y(paramLong2))) {
          break label1294;
        }
        i = 256;
        i |= j;
      }
      for (;;)
      {
        Object localObject1;
        if (((i & 0x2DB ^ 0x92) != 0) || (!paramh.nZ())) {
          if (((paramInt1 & 0x1) == 0) || (paramh.oa()))
          {
            paramh.of();
            if ((paramInt2 & 0x1) != 0) {
              paramString = "•";
            }
            j = i;
            if ((paramInt2 & 0x2) != 0)
            {
              j = b.a.BW_0_Alpha_0_3;
              localObject1 = MMApplicationContext.getContext();
              s.s(localObject1, "getContext()");
              paramLong1 = com.tencent.mm.aj.a.c(j, (Context)localObject1);
              j = i & 0xFFFFFF8F;
            }
            i = j;
            if ((paramInt2 & 0x4) != 0)
            {
              i = b.a.BW_0_Alpha_0_1_5;
              localObject1 = MMApplicationContext.getContext();
              s.s(localObject1, "getContext()");
              paramLong2 = com.tencent.mm.aj.a.c(i, (Context)localObject1);
              i = j & 0xFFFFFC7F;
            }
            paramh.og();
          }
        }
        for (;;)
        {
          Object localObject2 = ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud);
          paramh.bx(-1113031299);
          localObject1 = androidx.compose.foundation.c.a.abN;
          localObject1 = androidx.compose.foundation.c.a.mw();
          Object localObject3 = androidx.compose.ui.a.atD;
          Object localObject4 = androidx.compose.foundation.c.f.a((a.l)localObject1, androidx.compose.ui.a.a.sd(), paramh);
          paramh.bx(1376089335);
          localObject3 = (androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU());
          localObject1 = (n)paramh.a((p)androidx.compose.ui.platform.u.yW());
          Object localObject5 = androidx.compose.ui.i.a.aNC;
          localObject5 = androidx.compose.ui.i.a.a.xb();
          localObject2 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject2);
          if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
            androidx.compose.runtime.g.nW();
          }
          paramh.ol();
          if (paramh.nY())
          {
            paramh.a((kotlin.g.a.a)localObject5);
            paramh.op();
            s.u(paramh, "composer");
            localObject5 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject4, androidx.compose.ui.i.a.a.xe());
            localObject4 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xd());
            localObject3 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
            paramh.oq();
            s.u(paramh, "composer");
            ((q)localObject2).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
            paramh.bx(2058660585);
            paramh.bx(276693241);
            localObject1 = (androidx.compose.foundation.c.g)androidx.compose.foundation.c.h.acw;
            localObject2 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
            localObject3 = androidx.compose.ui.a.atD;
            localObject2 = ab.e(r.a(((androidx.compose.foundation.c.g)localObject1).a((androidx.compose.ui.f)localObject2, androidx.compose.ui.a.a.se()), 0.0F, androidx.compose.ui.n.g.ai(48.0F), 0.0F, androidx.compose.ui.n.g.ai(32.0F), 5), androidx.compose.ui.n.g.ai(68.0F));
            paramh.bx(-1989997546);
            localObject1 = androidx.compose.foundation.c.a.abN;
            localObject1 = androidx.compose.foundation.c.a.mt();
            localObject3 = androidx.compose.ui.a.atD;
            localObject4 = y.a((a.d)localObject1, androidx.compose.ui.a.a.sb(), paramh);
            paramh.bx(1376089335);
            localObject3 = (androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU());
            localObject1 = (n)paramh.a((p)androidx.compose.ui.platform.u.yW());
            localObject5 = androidx.compose.ui.i.a.aNC;
            localObject5 = androidx.compose.ui.i.a.a.xb();
            localObject2 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject2);
            if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
              androidx.compose.runtime.g.nW();
            }
            paramh.ol();
            if (!paramh.nY()) {
              break label1355;
            }
            paramh.a((kotlin.g.a.a)localObject5);
            paramh.op();
            s.u(paramh, "composer");
            localObject5 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject4, androidx.compose.ui.i.a.a.xe());
            localObject4 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xd());
            localObject3 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
            paramh.oq();
            s.u(paramh, "composer");
            ((q)localObject2).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
            paramh.bx(2058660585);
            paramh.bx(-326682743);
            localObject1 = (z)aa.adE;
            ae.b(ab.d((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(55.040001F)), paramh, 6);
            localObject2 = ab.e(ab.d((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(24.0F)), androidx.compose.ui.n.g.ai(1.0F));
            localObject3 = androidx.compose.ui.a.atD;
            androidx.compose.b.g.a(((z)localObject1).a((androidx.compose.ui.f)localObject2, androidx.compose.ui.a.a.sc()), paramLong2, 0.0F, 0.0F, paramh, i >> 3 & 0x70, 12);
            float f = androidx.compose.ui.n.g.ai(14.0F);
            long l = ((androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU())).x(f);
            localObject2 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
            localObject3 = androidx.compose.ui.a.atD;
            localObject2 = r.a(((z)localObject1).a((androidx.compose.ui.f)localObject2, androidx.compose.ui.a.a.sc()), androidx.compose.ui.n.g.ai(8.0F), 0.0F, androidx.compose.ui.n.g.ai(8.0F), 0.0F, 10);
            localObject3 = c.beg;
            t.a(paramString, (androidx.compose.ui.f)localObject2, paramLong1, l, null, null, null, 0L, null, c.dD(c.BP()), 0L, 0, false, 0, null, null, paramh, 0x40000C00 | i & 0xE | i << 3 & 0x380, 64, 65008);
            localObject2 = ab.e(ab.d((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(24.0F)), androidx.compose.ui.n.g.ai(1.0F));
            localObject3 = androidx.compose.ui.a.atD;
            androidx.compose.b.g.a(((z)localObject1).a((androidx.compose.ui.f)localObject2, androidx.compose.ui.a.a.sc()), paramLong2, 0.0F, 0.0F, paramh, i >> 3 & 0x70, 12);
            ae.b(ab.d((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(55.040001F)), paramh, 6);
            paramh.od();
            paramh.od();
            paramh.on();
            paramh.od();
            paramh.od();
            paramh.od();
            paramh.od();
            paramh.on();
            paramh.od();
            paramh.od();
          }
          for (;;)
          {
            paramh = paramh.oh();
            if (paramh != null) {
              paramh.b((kotlin.g.a.m)new a(paramString, paramLong1, paramLong2, paramInt1, paramInt2));
            }
            AppMethodBeat.o(235418);
            return;
            if ((paramInt1 & 0xE) != 0) {
              break label1389;
            }
            if (paramh.G(paramString))
            {
              i = 4;
              break;
            }
            i = 2;
            break;
            j = 16;
            break label68;
            i = 128;
            break label107;
            paramh.oj();
            j = i;
            if ((paramInt2 & 0x2) != 0) {
              j = i & 0xFFFFFF8F;
            }
            if ((paramInt2 & 0x4) == 0) {
              break label1375;
            }
            i = j & 0xFFFFFC7F;
            break label265;
            paramh.om();
            break label416;
            paramh.om();
            break label728;
            paramh.oi();
          }
          i = j;
        }
        i = j;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.d.e
 * JD-Core Version:    0.7.0.1
 */