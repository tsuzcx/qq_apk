package com.tencent.mm.sns_compose.c;

import android.content.Context;
import androidx.compose.b.t;
import androidx.compose.foundation.c.a.l;
import androidx.compose.foundation.c.ab;
import androidx.compose.foundation.c.g.a;
import androidx.compose.foundation.c.y;
import androidx.compose.foundation.lazy.w;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.br;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.a.b;
import androidx.compose.ui.m.b.i;
import androidx.compose.ui.n.n;
import androidx.compose.ui.platform.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sns_compose.b.a;
import com.tencent.mm.sns_compose.b.d;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.b.am;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"TAG", "", "ContentItem", "", "withTaViewModel", "Lcom/tencent/mm/sns_compose/page/WithTaViewModel;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "index", "", "itemBean", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "lazyDemoItem", "Landroidx/paging/compose/LazyPagingItems;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "(Lcom/tencent/mm/sns_compose/page/WithTaViewModel;Landroidx/compose/foundation/lazy/LazyListState;ILcom/tencent/mm/sns_compose/api/SnsWithTaBase;Landroidx/paging/compose/LazyPagingItems;Lcom/tencent/mm/sdk/coroutines/LifecycleScope;Landroidx/compose/runtime/Composer;I)V", "HeaderView", "title", "withFriends", "Landroidx/compose/runtime/MutableState;", "(Ljava/lang/String;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/Composer;I)V", "Loading", "(Landroidx/compose/runtime/Composer;I)V", "UserInfo", "username", "createTime", "(Ljava/lang/String;ILandroidx/compose/runtime/Composer;I)V", "WithFriendsPage", "(Lcom/tencent/mm/sns_compose/page/WithTaViewModel;Landroidx/compose/runtime/Composer;I)V", "determineCurrentlyPlayingItem", "offsetStart", "offsetEnd", "listState", "items", "sns-compose_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final void a(final g paramg, final androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(235605);
    kotlin.g.b.s.u(paramg, "withTaViewModel");
    androidx.compose.runtime.h localh = paramh.by(1242920577);
    final androidx.paging.compose.a locala = androidx.paging.compose.b.a(paramg.aczX, localh);
    localh.bx(-3687241);
    Object localObject = localh.or();
    paramh = androidx.compose.runtime.h.alD;
    paramh = (androidx.compose.runtime.h)localObject;
    if (localObject == h.a.ox())
    {
      paramh = bj.T(com.tencent.mm.sns_compose.a.acyR.hhX());
      localh.F(paramh);
    }
    localh.od();
    final an localan = (an)paramh;
    localh.bx(-3687241);
    localObject = localh.or();
    paramh = androidx.compose.runtime.h.alD;
    paramh = (androidx.compose.runtime.h)localObject;
    if (localObject == h.a.ox())
    {
      if (!com.tencent.mm.sns_compose.a.acyR.isSelf()) {
        break label367;
      }
      paramh = MMApplicationContext.getString(b.d.acyV);
    }
    for (;;)
    {
      localh.F(paramh);
      localh.od();
      String str = (String)paramh;
      localh.bx(-723524056);
      localh.bx(-3687241);
      localObject = localh.or();
      paramh = androidx.compose.runtime.h.alD;
      paramh = (androidx.compose.runtime.h)localObject;
      if (localObject == h.a.ox())
      {
        paramh = new androidx.compose.runtime.r(androidx.compose.runtime.aa.a((kotlin.d.f)kotlin.d.g.aiwf, localh));
        localh.F(paramh);
      }
      localh.od();
      paramh = ((androidx.compose.runtime.r)paramh).coroutineScope;
      localh.od();
      localObject = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
      int i = b.a.BG_2;
      Context localContext = MMApplicationContext.getContext();
      kotlin.g.b.s.s(localContext, "getContext()");
      androidx.compose.b.q.a(androidx.compose.foundation.b.a((androidx.compose.ui.f)localObject, com.tencent.mm.aj.a.c(i, localContext)), null, 0L, 0L, null, 0.0F, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(localh, -819892339, new h(str, locala, localan, paramh, paramg)), localh, 1572864, 62);
      paramh = localh.oh();
      if (paramh != null) {
        paramh.b((kotlin.g.a.m)new i(paramg, paramInt));
      }
      AppMethodBeat.o(235605);
      return;
      label367:
      paramh = am.aixg;
      paramh = MMApplicationContext.getString(b.d.aczb);
      kotlin.g.b.s.s(paramh, "sns_withta_with_friends.str");
      paramh = String.format(paramh, Arrays.copyOf(new Object[] { com.tencent.mm.sns_compose.a.acyR.aSV() }, 1));
      kotlin.g.b.s.s(paramh, "java.lang.String.format(format, *args)");
    }
  }
  
  public static final void a(final String paramString, final int paramInt1, androidx.compose.runtime.h paramh, final int paramInt2)
  {
    AppMethodBeat.i(235625);
    kotlin.g.b.s.u(paramString, "username");
    androidx.compose.runtime.h localh = paramh.by(-1961737330);
    if ((paramInt2 & 0xE) == 0) {
      if (localh.G(paramString)) {
        i = 4;
      }
    }
    for (int i = paramInt2 | i;; i = paramInt2)
    {
      int j;
      if ((paramInt2 & 0x70) == 0) {
        if (localh.bz(paramInt1))
        {
          j = 32;
          label73:
          i = j | i;
        }
      }
      for (;;)
      {
        if (((i & 0x5B ^ 0x12) != 0) || (!localh.nZ()))
        {
          paramh = androidx.compose.ui.a.atD;
          paramh = androidx.compose.ui.a.a.sc();
          Object localObject1 = androidx.compose.ui.f.aud;
          float f1 = androidx.compose.ui.n.g.ai(8.0F);
          float f2 = androidx.compose.ui.n.g.ai(6.0F);
          float f3 = androidx.compose.ui.n.g.ai(6.0F);
          Object localObject2 = androidx.compose.foundation.c.r.a((androidx.compose.ui.f)localObject1, f2, 0.0F, f3, f1, 2);
          localh.bx(-1989997546);
          localObject1 = androidx.compose.foundation.c.a.abN;
          Object localObject3 = y.a(androidx.compose.foundation.c.a.mt(), paramh, localh);
          localh.bx(1376089335);
          localObject1 = (androidx.compose.ui.n.d)localh.a((p)androidx.compose.ui.platform.u.yU());
          paramh = (n)localh.a((p)androidx.compose.ui.platform.u.yW());
          Object localObject4 = androidx.compose.ui.i.a.aNC;
          localObject4 = androidx.compose.ui.i.a.a.xb();
          localObject2 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject2);
          if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
            androidx.compose.runtime.g.nW();
          }
          localh.ol();
          if (localh.nY())
          {
            localh.a((kotlin.g.a.a)localObject4);
            label286:
            localh.op();
            kotlin.g.b.s.u(localh, "composer");
            localObject4 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject3, androidx.compose.ui.i.a.a.xe());
            localObject3 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject1, androidx.compose.ui.i.a.a.xd());
            localObject1 = androidx.compose.ui.i.a.aNC;
            br.a(localh, paramh, androidx.compose.ui.i.a.a.xf());
            localh.oq();
            kotlin.g.b.s.u(localh, "composer");
            ((kotlin.g.a.q)localObject2).invoke(bc.p(localh), localh, Integer.valueOf(0));
            localh.bx(2058660585);
            localh.bx(-326682743);
            paramh = androidx.compose.foundation.c.aa.adE;
            localObject2 = (Context)localh.a((p)j.yJ());
            com.tencent.mm.sns_compose.d.a.a(paramString, androidx.compose.ui.n.g.ai(48.0F), null, (kotlin.g.a.a)new e((Context)localObject2, paramString), localh, i & 0xE | 0x30, 4);
            localh.bx(-3686930);
            boolean bool = localh.G(paramString);
            localObject1 = localh.or();
            if (!bool)
            {
              paramh = androidx.compose.runtime.h.alD;
              paramh = (androidx.compose.runtime.h)localObject1;
              if (localObject1 != h.a.ox()) {}
            }
            else
            {
              paramh = com.tencent.mm.sns_compose.a.acyR.getDisplayName(paramString);
              localh.F(paramh);
            }
            localh.od();
            localObject3 = (String)paramh;
            localh.bx(-3686930);
            bool = localh.G(Integer.valueOf(paramInt1));
            localObject1 = localh.or();
            if (!bool)
            {
              paramh = androidx.compose.runtime.h.alD;
              paramh = (androidx.compose.runtime.h)localObject1;
              if (localObject1 != h.a.ox()) {}
            }
            else
            {
              paramh = com.tencent.mm.sns_compose.a.acyR.aX((Context)localObject2, paramInt1);
              localh.F(paramh);
            }
            localh.od();
            paramh = (String)paramh;
            localObject4 = androidx.compose.foundation.c.r.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(8.0F), 0.0F, 0.0F, 0.0F, 14);
            localh.bx(-1113031299);
            localObject1 = androidx.compose.foundation.c.a.abN;
            localObject1 = androidx.compose.foundation.c.a.mw();
            Object localObject5 = androidx.compose.ui.a.atD;
            Object localObject6 = androidx.compose.foundation.c.f.a((a.l)localObject1, androidx.compose.ui.a.a.sd(), localh);
            localh.bx(1376089335);
            localObject5 = (androidx.compose.ui.n.d)localh.a((p)androidx.compose.ui.platform.u.yU());
            localObject1 = (n)localh.a((p)androidx.compose.ui.platform.u.yW());
            Object localObject7 = androidx.compose.ui.i.a.aNC;
            localObject7 = androidx.compose.ui.i.a.a.xb();
            localObject4 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject4);
            if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
              androidx.compose.runtime.g.nW();
            }
            localh.ol();
            if (!localh.nY()) {
              break label1253;
            }
            localh.a((kotlin.g.a.a)localObject7);
            label780:
            localh.op();
            kotlin.g.b.s.u(localh, "composer");
            localObject7 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject6, androidx.compose.ui.i.a.a.xe());
            localObject6 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject5, androidx.compose.ui.i.a.a.xd());
            localObject5 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject1, androidx.compose.ui.i.a.a.xf());
            localh.oq();
            kotlin.g.b.s.u(localh, "composer");
            ((kotlin.g.a.q)localObject4).invoke(bc.p(localh), localh, Integer.valueOf(0));
            localh.bx(2058660585);
            localh.bx(276693241);
            localObject1 = androidx.compose.foundation.c.h.acw;
            f1 = androidx.compose.ui.n.g.ai(17.040001F);
            long l1 = ((androidx.compose.ui.n.d)localh.a((p)androidx.compose.ui.platform.u.yU())).x(f1);
            localObject1 = i.bcc;
            localObject1 = i.Bh();
            i = b.a.BW_0_Alpha_0_9;
            localObject4 = MMApplicationContext.getContext();
            kotlin.g.b.s.s(localObject4, "getContext()");
            long l2 = com.tencent.mm.aj.a.c(i, (Context)localObject4);
            com.tencent.mm.aj.b.g.b((String)localObject3, androidx.compose.foundation.g.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, false, (kotlin.g.a.a)new f((Context)localObject2, paramString), 7), l2, l1, null, (i)localObject1, null, 0L, null, null, 0L, 0, false, 0, null, null, localh, 3072, 64, 65488);
            f1 = androidx.compose.ui.n.g.ai(14.0F);
            l1 = ((androidx.compose.ui.n.d)localh.a((p)androidx.compose.ui.platform.u.yU())).x(f1);
            i = b.a.BW_0_Alpha_0_5;
            localObject1 = MMApplicationContext.getContext();
            kotlin.g.b.s.s(localObject1, "getContext()");
            l2 = com.tencent.mm.aj.a.c(i, (Context)localObject1);
            localObject1 = i.bcc;
            t.a(paramh, null, l2, l1, null, i.Bg(), null, 0L, null, null, 0L, 0, false, 0, null, null, localh, 3072, 64, 65490);
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
        }
        for (;;)
        {
          paramh = localh.oh();
          if (paramh != null) {
            paramh.b((kotlin.g.a.m)new g(paramString, paramInt1, paramInt2));
          }
          AppMethodBeat.o(235625);
          return;
          i = 2;
          break;
          j = 16;
          break label73;
          localh.om();
          break label286;
          label1253:
          localh.om();
          break label780;
          localh.oi();
        }
      }
    }
  }
  
  public static final void a(String paramString, final an<String> paraman, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(235616);
    kotlin.g.b.s.u(paramString, "title");
    kotlin.g.b.s.u(paraman, "withFriends");
    paramh = paramh.by(-213829645);
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramString)) {
        i = 4;
      }
    }
    for (final int i = paramInt | i;; i = paramInt)
    {
      int j;
      if ((paramInt & 0x70) == 0) {
        if (paramh.G(paraman))
        {
          j = 32;
          label77:
          i = j | i;
        }
      }
      for (;;)
      {
        if (((i & 0x5B ^ 0x12) != 0) || (!paramh.nZ()))
        {
          androidx.compose.ui.f localf = ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud);
          j = b.a.normal_actionbar_color;
          Context localContext = MMApplicationContext.getContext();
          kotlin.g.b.s.s(localContext, "getContext()");
          androidx.compose.b.q.a(localf, null, com.tencent.mm.aj.a.c(j, localContext), 0L, null, 0.0F, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(paramh, -819891612, new b(paramString, i, paraman)), paramh, 1572870, 58);
        }
        for (;;)
        {
          paramh = paramh.oh();
          if (paramh != null) {
            paramh.b((kotlin.g.a.m)new c(paramString, paraman, paramInt));
          }
          AppMethodBeat.o(235616);
          return;
          i = 2;
          break;
          j = 16;
          break label77;
          paramh.oi();
        }
      }
    }
  }
  
  public static final void b(g paramg, final androidx.compose.foundation.lazy.aa paramaa, final int paramInt1, final com.tencent.mm.sns_compose.a.f paramf, final androidx.paging.compose.a<com.tencent.mm.sns_compose.a.f> parama, final LifecycleScope paramLifecycleScope, androidx.compose.runtime.h paramh, final int paramInt2)
  {
    AppMethodBeat.i(235622);
    kotlin.g.b.s.u(paramg, "withTaViewModel");
    kotlin.g.b.s.u(paramaa, "lazyListState");
    kotlin.g.b.s.u(paramf, "itemBean");
    kotlin.g.b.s.u(parama, "lazyDemoItem");
    kotlin.g.b.s.u(paramLifecycleScope, "scope");
    paramh = paramh.by(691534216);
    Object localObject2 = androidx.compose.foundation.c.r.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(16.0F), androidx.compose.ui.n.g.ai(24.0F));
    paramh.bx(-1113031299);
    Object localObject1 = androidx.compose.foundation.c.a.abN;
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
    label554:
    int i;
    if (paramh.nY())
    {
      paramh.a((kotlin.g.a.a)localObject5);
      paramh.op();
      kotlin.g.b.s.u(paramh, "composer");
      localObject5 = androidx.compose.ui.i.a.aNC;
      br.a(paramh, localObject4, androidx.compose.ui.i.a.a.xe());
      localObject4 = androidx.compose.ui.i.a.aNC;
      br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xd());
      localObject3 = androidx.compose.ui.i.a.aNC;
      br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
      paramh.oq();
      kotlin.g.b.s.u(paramh, "composer");
      ((kotlin.g.a.q)localObject2).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
      paramh.bx(2058660585);
      paramh.bx(276693241);
      localObject1 = androidx.compose.foundation.c.h.acw;
      a(paramf.userName, paramf.createTime, paramh, 0);
      c.a(paramg, paramaa, paramInt1, paramf, parama, paramLifecycleScope, paramh, 0x41008 | paramInt2 & 0x70 | paramInt2 & 0x380 | androidx.paging.compose.a.Ue << 12 | 0xE000 & paramInt2);
      localObject2 = androidx.compose.foundation.c.r.b((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(6.0F));
      paramh.bx(-1113031299);
      localObject1 = androidx.compose.foundation.c.a.abN;
      localObject1 = androidx.compose.foundation.c.a.mw();
      localObject3 = androidx.compose.ui.a.atD;
      localObject4 = androidx.compose.foundation.c.f.a((a.l)localObject1, androidx.compose.ui.a.a.sd(), paramh);
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
        break label1073;
      }
      paramh.a((kotlin.g.a.a)localObject5);
      paramh.op();
      kotlin.g.b.s.u(paramh, "composer");
      localObject5 = androidx.compose.ui.i.a.aNC;
      br.a(paramh, localObject4, androidx.compose.ui.i.a.a.xe());
      localObject4 = androidx.compose.ui.i.a.aNC;
      br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xd());
      localObject3 = androidx.compose.ui.i.a.aNC;
      br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
      paramh.oq();
      kotlin.g.b.s.u(paramh, "composer");
      ((kotlin.g.a.q)localObject2).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
      paramh.bx(2058660585);
      paramh.bx(276693241);
      localObject1 = androidx.compose.foundation.c.h.acw;
      localObject1 = paramf.aczl;
      float f = androidx.compose.ui.n.g.ai(14.0F);
      long l1 = ((androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU())).x(f);
      i = b.a.BW_0_Alpha_0_5;
      localObject2 = MMApplicationContext.getContext();
      kotlin.g.b.s.s(localObject2, "getContext()");
      long l2 = com.tencent.mm.aj.a.c(i, (Context)localObject2);
      com.tencent.mm.aj.b.g.b((String)localObject1, androidx.compose.foundation.c.r.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, 0.0F, androidx.compose.ui.n.g.ai(8.0F), 0.0F, 0.0F, 13), l2, l1, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, paramh, 3120, 64, 65520);
      if (((CharSequence)paramf.aczk).length() <= 0) {
        break label1083;
      }
      i = 1;
      label807:
      if (i == 0) {
        break label1089;
      }
      paramh.bx(552701816);
      localObject1 = paramf.aczk;
      f = androidx.compose.ui.n.g.ai(14.0F);
      l1 = ((androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU())).x(f);
      i = b.a.BW_0_Alpha_0_5;
      localObject2 = MMApplicationContext.getContext();
      kotlin.g.b.s.s(localObject2, "getContext()");
      l2 = com.tencent.mm.aj.a.c(i, (Context)localObject2);
      com.tencent.mm.aj.b.g.b((String)localObject1, androidx.compose.foundation.c.r.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, 0.0F, androidx.compose.ui.n.g.ai(4.0F), 0.0F, 0.0F, 13), l2, l1, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, paramh, 3120, 64, 65520);
      paramh.od();
    }
    for (;;)
    {
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
      paramh = paramh.oh();
      if (paramh != null) {
        paramh.b((kotlin.g.a.m)new a(paramg, paramaa, paramInt1, paramf, parama, paramLifecycleScope, paramInt2));
      }
      AppMethodBeat.o(235622);
      return;
      paramh.om();
      break;
      label1073:
      paramh.om();
      break label554;
      label1083:
      i = 0;
      break label807;
      label1089:
      paramh.bx(552702085);
      paramh.od();
    }
  }
  
  public static final void g(androidx.compose.runtime.h paramh, int paramInt)
  {
    AppMethodBeat.i(235628);
    paramh = paramh.by(2049762519);
    if ((paramInt != 0) || (!paramh.nZ()))
    {
      Object localObject1 = androidx.compose.ui.a.atD;
      localObject1 = androidx.compose.ui.a.a.se();
      Object localObject3 = androidx.compose.foundation.c.r.a(ab.d(ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud)), 0.0F, androidx.compose.ui.n.g.ai(112.0F), 0.0F, 0.0F, 13);
      paramh.bx(-1113031299);
      Object localObject2 = androidx.compose.foundation.c.a.abN;
      Object localObject4 = androidx.compose.foundation.c.f.a(androidx.compose.foundation.c.a.mw(), (a.b)localObject1, paramh);
      paramh.bx(1376089335);
      localObject2 = (androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU());
      localObject1 = (n)paramh.a((p)androidx.compose.ui.platform.u.yW());
      Object localObject5 = androidx.compose.ui.i.a.aNC;
      localObject5 = androidx.compose.ui.i.a.a.xb();
      localObject3 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject3);
      if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
        androidx.compose.runtime.g.nW();
      }
      paramh.ol();
      if (paramh.nY())
      {
        paramh.a((kotlin.g.a.a)localObject5);
        paramh.op();
        kotlin.g.b.s.u(paramh, "composer");
        localObject5 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject4, androidx.compose.ui.i.a.a.xe());
        localObject4 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject2, androidx.compose.ui.i.a.a.xd());
        localObject2 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
        paramh.oq();
        kotlin.g.b.s.u(paramh, "composer");
        ((kotlin.g.a.q)localObject3).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
        paramh.bx(2058660585);
        paramh.bx(276693241);
        localObject1 = (androidx.compose.foundation.c.g)androidx.compose.foundation.c.h.acw;
        localObject5 = g.a.a((androidx.compose.foundation.c.g)localObject1, (androidx.compose.ui.f)androidx.compose.ui.f.aud, 0.3F);
        paramh.bx(-1990474327);
        localObject2 = androidx.compose.ui.a.atD;
        localObject4 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, paramh);
        paramh.bx(1376089335);
        localObject3 = (androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU());
        localObject2 = (n)paramh.a((p)androidx.compose.ui.platform.u.yW());
        Object localObject6 = androidx.compose.ui.i.a.aNC;
        localObject6 = androidx.compose.ui.i.a.a.xb();
        localObject5 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject5);
        if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
          androidx.compose.runtime.g.nW();
        }
        paramh.ol();
        if (!paramh.nY()) {
          break label914;
        }
        paramh.a((kotlin.g.a.a)localObject6);
        label426:
        paramh.op();
        kotlin.g.b.s.u(paramh, "composer");
        localObject6 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject4, androidx.compose.ui.i.a.a.xe());
        localObject4 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xd());
        localObject3 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject2, androidx.compose.ui.i.a.a.xf());
        paramh.oq();
        kotlin.g.b.s.u(paramh, "composer");
        ((kotlin.g.a.q)localObject5).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
        paramh.bx(2058660585);
        paramh.bx(-1253629305);
        localObject2 = androidx.compose.foundation.c.e.acr;
        paramh.od();
        paramh.od();
        paramh.on();
        paramh.od();
        paramh.od();
        com.tencent.mm.aj.b.b.a(null, null, null, paramh, 0, 7);
        localObject4 = g.a.a((androidx.compose.foundation.c.g)localObject1, (androidx.compose.ui.f)androidx.compose.ui.f.aud, 0.7F);
        paramh.bx(-1990474327);
        localObject1 = androidx.compose.ui.a.atD;
        localObject3 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, paramh);
        paramh.bx(1376089335);
        localObject2 = (androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU());
        localObject1 = (n)paramh.a((p)androidx.compose.ui.platform.u.yW());
        localObject5 = androidx.compose.ui.i.a.aNC;
        localObject5 = androidx.compose.ui.i.a.a.xb();
        localObject4 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject4);
        if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
          androidx.compose.runtime.g.nW();
        }
        paramh.ol();
        if (!paramh.nY()) {
          break label923;
        }
        paramh.a((kotlin.g.a.a)localObject5);
        label706:
        paramh.op();
        kotlin.g.b.s.u(paramh, "composer");
        localObject5 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xe());
        localObject3 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject2, androidx.compose.ui.i.a.a.xd());
        localObject2 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
        paramh.oq();
        kotlin.g.b.s.u(paramh, "composer");
        ((kotlin.g.a.q)localObject4).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
        paramh.bx(2058660585);
        paramh.bx(-1253629305);
        localObject1 = androidx.compose.foundation.c.e.acr;
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
    }
    for (;;)
    {
      paramh = paramh.oh();
      if (paramh != null) {
        paramh.b((kotlin.g.a.m)new d(paramInt));
      }
      AppMethodBeat.o(235628);
      return;
      paramh.om();
      break;
      label914:
      paramh.om();
      break label426;
      label923:
      paramh.om();
      break label706;
      paramh.oi();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    a(g paramg, androidx.compose.foundation.lazy.aa paramaa, int paramInt1, com.tencent.mm.sns_compose.a.f paramf, androidx.paging.compose.a<com.tencent.mm.sns_compose.a.f> parama, LifecycleScope paramLifecycleScope, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    b(String paramString, int paramInt, an<String> paraman)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    c(String paramString, an<String> paraman, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    d(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    e(Context paramContext, String paramString)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(Context paramContext, String paramString)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    g(String paramString, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    h(String paramString, androidx.paging.compose.a<com.tencent.mm.sns_compose.a.f> parama, an<String> paraman, aq paramaq, g paramg)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.b<w, ah>
    {
      a(androidx.paging.compose.a<com.tencent.mm.sns_compose.a.f> parama, an<String> paraman, String paramString, aq paramaq, g paramg, androidx.compose.foundation.lazy.aa paramaa)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    i(g paramg, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.c.e
 * JD-Core Version:    0.7.0.1
 */