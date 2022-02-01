package com.tencent.mm.sns_compose.d;

import android.content.Context;
import androidx.compose.foundation.c.ab;
import androidx.compose.foundation.c.e;
import androidx.compose.foundation.c.r;
import androidx.compose.foundation.c.y;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.br;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.a.c;
import androidx.compose.ui.e.ad;
import androidx.compose.ui.e.ae;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sns_compose.b.a;
import com.tencent.mm.sns_compose.b.b;
import com.tencent.mm.sns_compose.b.c;
import com.tencent.mm.sns_compose.b.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "getTAG", "()Ljava/lang/String;", "ScrollableAppBar", "", "title", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "modifier", "Landroidx/compose/ui/Modifier;", "background", "Landroidx/compose/ui/graphics/Color;", "ScrollableAppBar-ww6aTOc", "(Ljava/lang/String;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "sns-compose_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final String TAG = "ScrollableAppBar";
  
  public static final void a(final String paramString, final androidx.compose.foundation.lazy.aa paramaa, final androidx.compose.ui.f paramf, final long paramLong, h paramh, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(235449);
    s.u(paramString, "title");
    s.u(paramaa, "lazyListState");
    h localh = paramh.by(617554885);
    final int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label57:
    label64:
    label76:
    label83:
    label1370:
    label1373:
    label1376:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      if ((paramInt2 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt2 & 0x4) == 0) {
          break label1266;
        }
        j = 384;
        j = i | j;
        i = j;
        if ((paramInt1 & 0x1C00) == 0)
        {
          if (((paramInt2 & 0x8) != 0) || (!localh.y(paramLong))) {
            break label1306;
          }
          i = 2048;
          label120:
          i = j | i;
        }
        if (((i & 0x16DB ^ 0x492) == 0) && (localh.nZ())) {
          break label1360;
        }
        if (((paramInt1 & 0x1) != 0) && (!localh.oa())) {
          break label1314;
        }
        localh.of();
        if ((paramInt2 & 0x4) != 0) {
          paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        }
        if ((paramInt2 & 0x8) == 0) {
          break label1373;
        }
        j = b.a.BG_0;
        paramh = MMApplicationContext.getContext();
        s.s(paramh, "getContext()");
        paramLong = com.tencent.mm.aj.a.c(j, paramh);
        i &= 0xFFFFE3FF;
      }
      for (;;)
      {
        localh.og();
        for (;;)
        {
          label236:
          localh.bx(-3687241);
          Object localObject1 = localh.or();
          paramh = h.alD;
          paramh = (h)localObject1;
          if (localObject1 == h.a.ox())
          {
            float f = androidx.compose.ui.n.g.ai(40.0F);
            j = (int)com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), f);
            f = androidx.compose.ui.n.g.ai(20.0F);
            paramh = new g(j, com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), f));
            localh.F(paramh);
          }
          localh.od();
          localObject1 = (g)paramh;
          paramh = (Context)localh.a((p)androidx.compose.ui.platform.j.yJ());
          localh.bx(-1990474327);
          Object localObject5 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
          Object localObject2 = androidx.compose.ui.a.atD;
          Object localObject4 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, localh);
          localh.bx(1376089335);
          Object localObject3 = (androidx.compose.ui.n.d)localh.a((p)androidx.compose.ui.platform.u.yU());
          localObject2 = (n)localh.a((p)androidx.compose.ui.platform.u.yW());
          Object localObject6 = androidx.compose.ui.i.a.aNC;
          localObject6 = androidx.compose.ui.i.a.a.xb();
          localObject5 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject5);
          if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
            androidx.compose.runtime.g.nW();
          }
          localh.ol();
          if (localh.nY())
          {
            localh.a((kotlin.g.a.a)localObject6);
            label495:
            localh.op();
            s.u(localh, "composer");
            localObject6 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject4, androidx.compose.ui.i.a.a.xe());
            localObject4 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject3, androidx.compose.ui.i.a.a.xd());
            localObject3 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject2, androidx.compose.ui.i.a.a.xf());
            localh.oq();
            s.u(localh, "composer");
            ((kotlin.g.a.q)localObject5).invoke(bc.p(localh), localh, Integer.valueOf(0));
            localh.bx(2058660585);
            localh.bx(-1253629305);
            localObject2 = e.acr;
            androidx.compose.b.q.a(ad.b((androidx.compose.ui.f)androidx.compose.ui.f.aud, (b)new a((g)localObject1, paramaa)), null, paramLong, 0L, null, 0.0F, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(localh, -819892554, new b(paramf, paramString, i)), localh, i >> 3 & 0x380 | 0x180000, 58);
            localObject1 = r.a(paramf, androidx.compose.ui.n.g.ai(8.0F), 0.0F, 0.0F, 0.0F, 14);
            i = b.b.ActionBarHeight;
            i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
            localObject2 = ab.c(ab.e((androidx.compose.ui.f)localObject1, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i))));
            localObject1 = androidx.compose.ui.a.atD;
            localObject1 = androidx.compose.ui.a.a.sc();
            localh.bx(-1989997546);
            localObject3 = androidx.compose.foundation.c.a.abN;
            localObject4 = y.a(androidx.compose.foundation.c.a.mt(), (a.c)localObject1, localh);
            localh.bx(1376089335);
            localObject3 = (androidx.compose.ui.n.d)localh.a((p)androidx.compose.ui.platform.u.yU());
            localObject1 = (n)localh.a((p)androidx.compose.ui.platform.u.yW());
            localObject5 = androidx.compose.ui.i.a.aNC;
            localObject5 = androidx.compose.ui.i.a.a.xb();
            localObject2 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject2);
            if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
              androidx.compose.runtime.g.nW();
            }
            localh.ol();
            if (!localh.nY()) {
              break label1350;
            }
            localh.a((kotlin.g.a.a)localObject5);
            label875:
            localh.op();
            s.u(localh, "composer");
            localObject5 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject4, androidx.compose.ui.i.a.a.xe());
            localObject4 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject3, androidx.compose.ui.i.a.a.xd());
            localObject3 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject1, androidx.compose.ui.i.a.a.xf());
            localh.oq();
            s.u(localh, "composer");
            ((kotlin.g.a.q)localObject2).invoke(bc.p(localh), localh, Integer.valueOf(0));
            localh.bx(2058660585);
            localh.bx(-326682743);
            localObject1 = androidx.compose.foundation.c.aa.adE;
            localObject1 = com.tencent.mm.aj.a.a(b.c.actionbar_icon_light_back, localh);
            i = b.a.black_color;
            localObject2 = MMApplicationContext.getContext();
            s.s(localObject2, "getContext()");
            long l = com.tencent.mm.aj.a.c(i, (Context)localObject2);
            paramh = ab.f(androidx.compose.foundation.g.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, false, (kotlin.g.a.a)new c(paramh), 7), androidx.compose.ui.n.g.ai(24.0F));
            androidx.compose.b.j.a((androidx.compose.ui.e.c.c)localObject1, MMApplicationContext.getString(b.d.app_back), paramh, l, localh, 8, 0);
            localh.od();
            localh.od();
            localh.on();
            localh.od();
            localh.od();
            localh.od();
            localh.od();
            localh.on();
            localh.od();
            localh.od();
          }
          for (;;)
          {
            paramh = localh.oh();
            if (paramh != null) {
              paramh.b((kotlin.g.a.m)new d(paramString, paramaa, paramf, paramLong, paramInt1, paramInt2));
            }
            AppMethodBeat.o(235449);
            return;
            if ((paramInt1 & 0xE) != 0) {
              break label1376;
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
            if (localh.G(paramaa))
            {
              i = 32;
              break label57;
            }
            i = 16;
            break label57;
            label1266:
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
            i = 1024;
            break label120;
            localh.oj();
            if ((paramInt2 & 0x8) == 0) {
              break label1370;
            }
            i &= 0xFFFFE3FF;
            break label236;
            localh.om();
            break label495;
            localh.om();
            break label875;
            localh.oi();
          }
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements b<ae, ah>
  {
    a(g paramg, androidx.compose.foundation.lazy.aa paramaa)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    b(androidx.compose.ui.f paramf, String paramString, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    d(String paramString, androidx.compose.foundation.lazy.aa paramaa, androidx.compose.ui.f paramf, long paramLong, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.d.f
 * JD-Core Version:    0.7.0.1
 */