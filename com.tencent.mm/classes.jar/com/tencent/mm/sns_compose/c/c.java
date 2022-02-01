package com.tencent.mm.sns_compose.c;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.foundation.c.ab;
import androidx.compose.foundation.c.e;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.br;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.r;
import androidx.compose.runtime.x;
import androidx.compose.runtime.y;
import androidx.compose.ui.e.af;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.h.d.a;
import androidx.compose.ui.n.n;
import androidx.lifecycle.j.a;
import androidx.lifecycle.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sns_compose.a.f.b;
import com.tencent.mm.sns_compose.a.f.c;
import com.tencent.mm.sns_compose.a.f.d;
import com.tencent.mm.sns_compose.a.f.e;
import com.tencent.mm.sns_compose.a.f.f;
import com.tencent.mm.sns_compose.a.f.g;
import com.tencent.mm.sns_compose.b.a;
import com.tencent.mm.sns_compose.b.b;
import com.tencent.mm.sns_compose.b.d;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"TAG", "", "BuildImage", "", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/tencent/mm/protocal/protobuf/MediaObj;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "url", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "snsId", "mediaId", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "FinderContent", "thumbUrl", "isVideo", "", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ImageContent", "mediaList", "", "imagePreviewCb", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "MediaContent", "content", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "MusicMvContent", "title", "subTitle", "(Lcom/tencent/mm/protocal/protobuf/MediaObj;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "TextContent", "text", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "UrlContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "VideoContent", "item", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaVideo;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "isPlay", "(Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaVideo;Lcom/tencent/mm/sdk/coroutines/LifecycleScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "WithTaContent", "withTaViewModel", "Lcom/tencent/mm/sns_compose/page/WithTaViewModel;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "index", "", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "lazyDemoItem", "Landroidx/paging/compose/LazyPagingItems;", "(Lcom/tencent/mm/sns_compose/page/WithTaViewModel;Landroidx/compose/foundation/lazy/LazyListState;ILcom/tencent/mm/sns_compose/api/SnsWithTaBase;Landroidx/paging/compose/LazyPagingItems;Lcom/tencent/mm/sdk/coroutines/LifecycleScope;Landroidx/compose/runtime/Composer;I)V", "makeGalleryItems", "Lcom/tencent/mm/sns_compose/api/GalleryData;", "showWithTaDetail", "context", "Landroid/content/Context;", "rememberScope", "Lkotlinx/coroutines/CoroutineScope;", "cb", "showWithTaDialog", "sns-compose_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final com.tencent.mm.sns_compose.a.a a(String paramString, androidx.paging.compose.a<com.tencent.mm.sns_compose.a.f> parama)
  {
    AppMethodBeat.i(235621);
    s.u(paramString, "mediaId");
    s.u(parama, "lazyDemoItem");
    ArrayList localArrayList = new ArrayList();
    ah.d locald1 = new ah.d();
    ah.d locald2 = new ah.d();
    Iterator localIterator1 = ((Iterable)kotlin.k.k.qt(0, parama.Il().size())).iterator();
    while (localIterator1.hasNext())
    {
      com.tencent.mm.sns_compose.a.f localf = (com.tencent.mm.sns_compose.a.f)parama.fp(((kotlin.a.ah)localIterator1).Zo());
      if ((localf instanceof f.c))
      {
        Iterator localIterator2 = ((f.c)localf).aczm.iterator();
        while (localIterator2.hasNext()) {
          a(paramString, locald1, locald2, localArrayList, (dmz)localIterator2.next(), ((f.c)localf).icg, ((f.c)localf).createTime);
        }
      }
      else if ((localf instanceof f.g))
      {
        a(paramString, locald1, locald2, localArrayList, ((f.g)localf).ibT, ((f.g)localf).icg, ((f.g)localf).createTime);
      }
    }
    paramString = new com.tencent.mm.sns_compose.a.a(localArrayList, locald1.aixb);
    AppMethodBeat.o(235621);
    return paramString;
  }
  
  public static final void a(Context paramContext, g paramg, aq paramaq, com.tencent.mm.sns_compose.a.f paramf)
  {
    AppMethodBeat.i(235609);
    s.u(paramContext, "context");
    s.u(paramg, "withTaViewModel");
    s.u(paramaq, "rememberScope");
    s.u(paramf, "item");
    g.a locala = new g.a(paramContext);
    locala.bDE(paramContext.getString(b.d.acyW));
    locala.bDI(MMApplicationContext.getString(b.d.acyZ));
    locala.b(new c..ExternalSyntheticLambda0(paramContext, paramaq, paramf, paramg));
    locala.aEZ(MMApplicationContext.getColor(b.a.brand_text_color));
    locala.bDJ(MMApplicationContext.getString(b.d.app_i_know)).show();
    AppMethodBeat.o(235609);
  }
  
  public static final void a(Context paramContext, g paramg, aq paramaq, com.tencent.mm.sns_compose.a.f paramf, kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(235617);
    s.u(paramContext, "context");
    s.u(paramg, "withTaViewModel");
    s.u(paramaq, "rememberScope");
    s.u(paramf, "item");
    s.u(parama, "cb");
    if ((paramf.extFlag & 0x40) > 0)
    {
      a(paramContext, paramg, paramaq, paramf);
      AppMethodBeat.o(235617);
      return;
    }
    parama.invoke();
    AppMethodBeat.o(235617);
  }
  
  private static final void a(final Context paramContext, aq paramaq, final com.tencent.mm.sns_compose.a.f paramf, g paramg, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(235639);
    s.u(paramContext, "$context");
    s.u(paramaq, "$rememberScope");
    s.u(paramf, "$item");
    s.u(paramg, "$withTaViewModel");
    com.tencent.mm.sns_compose.a.acyR.a(paramContext, paramaq, paramf.aczi, 1, b.d.acza, (kotlin.g.a.b)new aa(paramg, paramf, paramContext));
    AppMethodBeat.o(235639);
  }
  
  public static final void a(dmz paramdmz, final androidx.compose.ui.f paramf, final h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(235634);
    s.u(paramdmz, "media");
    h localh = paramh.by(571259212);
    if ((paramInt2 & 0x2) != 0) {
      paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
    }
    for (;;)
    {
      localh.bx(-3686930);
      boolean bool = localh.G(paramdmz);
      Object localObject = localh.or();
      if (!bool)
      {
        paramh = h.alD;
        paramh = (h)localObject;
        if (localObject != h.a.ox()) {}
      }
      else
      {
        paramh = bj.T(androidx.compose.ui.e.ah.Z(1, 1));
        localh.F(paramh);
      }
      localh.od();
      paramh = (an)paramh;
      androidx.compose.runtime.aa.a(paramdmz, (kotlin.g.a.m)new b(paramdmz, paramh, null), localh);
      paramh = (af)((bm)paramh).getValue();
      localObject = androidx.compose.ui.h.d.aMF;
      androidx.compose.foundation.j.a(paramh, "avatar", paramf, null, d.a.wF(), 0.0F, null, localh, paramInt1 << 3 & 0x380 | 0x38, 104);
      paramh = localh.oh();
      if (paramh != null) {
        paramh.b((kotlin.g.a.m)new c(paramdmz, paramf, paramInt1, paramInt2));
      }
      AppMethodBeat.o(235634);
      return;
    }
  }
  
  public static final void a(dmz paramdmz, final String paramString1, final String paramString2, final kotlin.g.a.a<kotlin.ah> parama, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(235626);
    s.u(paramString1, "title");
    s.u(parama, "onClick");
    paramh = paramh.by(-652795844);
    if ((paramInt2 & 0x4) != 0) {
      paramString2 = null;
    }
    for (;;)
    {
      if (paramdmz == null)
      {
        paramh = paramh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new j(paramdmz, paramString1, paramString2, parama, paramInt1, paramInt2));
        }
        AppMethodBeat.o(235626);
        return;
      }
      androidx.compose.ui.f localf = androidx.compose.foundation.g.a(androidx.compose.ui.b.d.a(ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud), (ay)androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(8.0F))), false, parama, 7);
      int i = b.a.BG_0;
      Context localContext = MMApplicationContext.getContext();
      s.s(localContext, "getContext()");
      androidx.compose.b.q.a(localf, null, com.tencent.mm.aj.a.c(i, localContext), 0L, null, 0.0F, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(paramh, -819889812, new k(paramdmz, paramString1, paramInt1, paramString2)), paramh, 1572864, 58);
      paramh = paramh.oh();
      if (paramh != null) {
        paramh.b((kotlin.g.a.m)new l(paramdmz, paramString1, paramString2, parama, paramInt1, paramInt2));
      }
      AppMethodBeat.o(235626);
      return;
    }
  }
  
  public static final void a(f.g paramg, final LifecycleScope paramLifecycleScope, final kotlin.g.a.a<Boolean> parama, final kotlin.g.a.a<kotlin.ah> parama1, final h paramh, final int paramInt)
  {
    AppMethodBeat.i(235629);
    s.u(paramg, "item");
    s.u(paramLifecycleScope, "scope");
    s.u(parama, "isPlay");
    s.u(parama1, "onClick");
    h localh = paramh.by(-258637178);
    localh.bx(-3687241);
    Object localObject = localh.or();
    paramh = h.alD;
    paramh = (h)localObject;
    if (localObject == h.a.ox())
    {
      paramh = bj.f((kotlin.g.a.a)new c.u(parama));
      localh.F(paramh);
    }
    localh.od();
    final bm localbm = (bm)paramh;
    Context localContext = (Context)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.j.yJ());
    localh.bx(-3686930);
    boolean bool = localh.G(paramg);
    localObject = localh.or();
    if (!bool)
    {
      paramh = h.alD;
      paramh = (h)localObject;
      if (localObject != h.a.ox()) {}
    }
    else
    {
      paramh = new com.tencent.mm.sns_compose.d.c(localContext, paramg.hQX, paramg.icg, paramg.ibT, paramg.createTime, paramLifecycleScope);
      localh.F(paramh);
    }
    localh.od();
    paramh = (com.tencent.mm.sns_compose.d.c)paramh;
    localObject = (androidx.lifecycle.q)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.j.yK());
    androidx.compose.runtime.aa.a(localObject, (kotlin.g.a.b)new q((androidx.lifecycle.q)localObject, paramh), localh);
    androidx.compose.runtime.aa.a(Boolean.valueOf(h(localbm)), (kotlin.g.a.m)new r(paramh, localbm, null), localh);
    a((kotlin.g.a.q)androidx.compose.runtime.c.c.a(localh, -819898550, new s(parama1, paramh, localbm)), localh, 6);
    paramh = localh.oh();
    if (paramh != null) {
      paramh.b((kotlin.g.a.m)new t(paramg, paramLifecycleScope, parama, parama1, paramInt));
    }
    AppMethodBeat.o(235629);
  }
  
  public static final void a(final g paramg, final androidx.compose.foundation.lazy.aa paramaa, final int paramInt1, final com.tencent.mm.sns_compose.a.f paramf, final androidx.paging.compose.a<com.tencent.mm.sns_compose.a.f> parama, final LifecycleScope paramLifecycleScope, h paramh, final int paramInt2)
  {
    AppMethodBeat.i(235623);
    s.u(paramg, "withTaViewModel");
    s.u(paramaa, "lazyListState");
    s.u(paramf, "item");
    s.u(parama, "lazyDemoItem");
    s.u(paramLifecycleScope, "scope");
    h localh = paramh.by(717646034);
    Object localObject2 = (Context)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.j.yJ());
    localh.bx(-723524056);
    localh.bx(-3687241);
    Object localObject1 = localh.or();
    paramh = h.alD;
    paramh = (h)localObject1;
    if (localObject1 == h.a.ox())
    {
      paramh = new r(androidx.compose.runtime.aa.a((kotlin.d.f)kotlin.d.g.aiwf, localh));
      localh.F(paramh);
    }
    localh.od();
    final aq localaq = ((r)paramh).coroutineScope;
    localh.od();
    paramh = paramf.hQX;
    localh.bx(-3686930);
    boolean bool = localh.G(paramh);
    localObject1 = localh.or();
    if (!bool)
    {
      paramh = h.alD;
      paramh = (h)localObject1;
      if (localObject1 != h.a.ox()) {}
    }
    else
    {
      paramh = (kotlin.g.a.a)new y(paramf, (Context)localObject2, paramg, localaq);
      localh.F(paramh);
    }
    localh.od();
    kotlin.g.a.a locala = (kotlin.g.a.a)paramh;
    localh.bx(-3686930);
    bool = localh.G(paramaa);
    localObject1 = localh.or();
    float f;
    if (!bool)
    {
      paramh = h.alD;
      paramh = (h)localObject1;
      if (localObject1 != h.a.ox()) {}
    }
    else
    {
      f = androidx.compose.ui.n.g.ai(100.0F);
      paramh = Integer.valueOf((int)com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), f));
      localh.F(paramh);
    }
    localh.od();
    int i = ((Number)paramh).intValue();
    localh.bx(-3686930);
    bool = localh.G(paramaa);
    localObject1 = localh.or();
    if (!bool)
    {
      paramh = h.alD;
      paramh = (h)localObject1;
      if (localObject1 != h.a.ox()) {}
    }
    else
    {
      f = androidx.compose.ui.n.g.ai(300.0F);
      paramh = Integer.valueOf((int)com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), f));
      localh.F(paramh);
    }
    localh.od();
    final int j = ((Number)paramh).intValue();
    if ((paramf instanceof f.e))
    {
      localh.bx(717646846);
      a(paramf.uyk, locala, localh, 0);
      localh.od();
    }
    for (;;)
    {
      paramh = localh.oh();
      if (paramh != null) {
        paramh.b((kotlin.g.a.m)new x(paramg, paramaa, paramInt1, paramf, parama, paramLifecycleScope, paramInt2));
      }
      AppMethodBeat.o(235623);
      return;
      if ((paramf instanceof f.c))
      {
        localh.bx(717646935);
        a(paramf.hQX, ((f.c)paramf).aczm, (kotlin.g.a.b)new v(paramf, (Context)localObject2, paramg, localaq, parama), localh, 64);
        localh.od();
      }
      else
      {
        if ((paramf instanceof f.g))
        {
          localh.bx(717647417);
          int k = androidx.paging.compose.a.Ue;
          localh.bx(-3686930);
          bool = localh.G(parama);
          localObject1 = localh.or();
          if (!bool)
          {
            paramh = h.alD;
            paramh = (h)localObject1;
            if (localObject1 != h.a.ox()) {}
          }
          else
          {
            paramh = Boolean.valueOf(com.tencent.mm.sns_compose.a.acyR.hge());
            localh.F(paramh);
          }
          localh.od();
          bool = ((Boolean)paramh).booleanValue();
          paramh = (kotlin.g.a.a)new z((Context)localObject2, paramg, localaq, paramf, parama);
          if (bool)
          {
            localh.bx(717647900);
            a((f.g)paramf, paramLifecycleScope, (kotlin.g.a.a)new w(i, j, paramaa, parama, paramf), paramh, localh, 72);
            localh.od();
          }
          for (;;)
          {
            localh.od();
            break;
            localh.bx(717648194);
            localObject1 = ((f.g)paramf).ibT.aaTl;
            s.s(localObject1, "item.media.Thumb");
            a((String)localObject1, true, paramh, localh, 48);
            localh.od();
          }
        }
        if ((paramf instanceof f.b))
        {
          localh.bx(717648445);
          a(((f.b)paramf).thumbUrl, ((f.b)paramf).AnF, locala, localh, 0);
          localh.od();
        }
        else if ((paramf instanceof f.d))
        {
          localh.bx(717648609);
          paramh = ((f.d)paramf).ibT;
          localObject1 = ((f.d)paramf).title;
          s.checkNotNull(localObject1);
          a(paramh, (String)localObject1, ((f.d)paramf).uCW, locala, localh, 8, 0);
          localh.od();
        }
        else
        {
          if ((paramf instanceof f.f))
          {
            localh.bx(717648715);
            if (((f.f)paramf).ibT != null)
            {
              localh.bx(717648753);
              paramh = paramf.hQX;
              localObject1 = ((f.f)paramf).ibT;
              s.checkNotNull(localObject1);
              localObject1 = ((dmz)localObject1).Id;
              s.s(localObject1, "item.media!!.Id");
              localObject2 = ((f.f)paramf).title;
              s.checkNotNull(localObject2);
              a(paramh, (String)localObject1, (String)localObject2, ((f.f)paramf).uCW, locala, localh, 0, 0);
              localh.od();
            }
            for (;;)
            {
              localh.od();
              break;
              localh.bx(717648862);
              localh.od();
            }
          }
          localh.bx(717648889);
          a(paramf.uyk, locala, localh, 0);
          localh.od();
        }
      }
    }
  }
  
  public static final void a(String paramString, final androidx.compose.ui.f paramf, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(235635);
    s.u(paramString, "url");
    paramh = paramh.by(571259652);
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label51:
    label248:
    label251:
    label254:
    for (int i = paramInt1 | i;; i = paramInt1)
    {
      int j;
      if ((paramInt2 & 0x2) != 0)
      {
        j = 48;
        i |= j;
      }
      for (;;)
      {
        if (((i & 0x5B ^ 0x12) != 0) || (!paramh.nZ()))
        {
          if ((paramInt2 & 0x2) == 0) {
            break label248;
          }
          paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        }
        for (;;)
        {
          coil.d.d locald = com.tencent.mm.sns_compose.d.b.b(paramString, paramh);
          Object localObject = androidx.compose.ui.h.d.aMF;
          localObject = d.a.wF();
          androidx.compose.foundation.j.a((androidx.compose.ui.e.c.c)locald, "avatar", paramf, null, (androidx.compose.ui.h.d)localObject, 0.0F, null, paramh, i << 3 & 0x380 | 0x30, 104);
          for (;;)
          {
            paramh = paramh.oh();
            if (paramh != null) {
              paramh.b((kotlin.g.a.m)new d(paramString, paramf, paramInt1, paramInt2));
            }
            AppMethodBeat.o(235635);
            return;
            if ((paramInt1 & 0xE) != 0) {
              break label254;
            }
            if (paramh.G(paramString))
            {
              i = 4;
              break;
            }
            i = 2;
            break;
            if ((paramInt1 & 0x70) != 0) {
              break label251;
            }
            if (paramh.G(paramf))
            {
              j = 32;
              break label51;
            }
            j = 16;
            break label51;
            paramh.oi();
          }
        }
      }
    }
  }
  
  public static final void a(String paramString1, final String paramString2, final androidx.compose.ui.f paramf, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(235633);
    s.u(paramString1, "snsId");
    s.u(paramString2, "mediaId");
    h localh = paramh.by(571258867);
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label409:
    label412:
    label419:
    for (int i = paramInt1 | i;; i = paramInt1)
    {
      int j;
      if ((paramInt2 & 0x2) != 0)
      {
        j = 48;
        label59:
        j = i | j;
        label66:
        if ((paramInt2 & 0x4) == 0) {
          break label363;
        }
        i = 384;
      }
      label78:
      for (i = j | i;; i = j)
      {
        if (((i & 0x2DB ^ 0x92) != 0) || (!localh.nZ()))
        {
          if ((paramInt2 & 0x4) == 0) {
            break label409;
          }
          paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        }
        for (;;)
        {
          localh.bx(-3687241);
          Object localObject = localh.or();
          paramh = h.alD;
          paramh = (h)localObject;
          if (localObject == h.a.ox())
          {
            paramh = "sns://" + paramString1 + '/' + paramString2 + "/0/JPG";
            localh.F(paramh);
          }
          localh.od();
          paramh = com.tencent.mm.sns_compose.d.b.b((String)paramh, localh);
          localObject = androidx.compose.ui.h.d.aMF;
          localObject = d.a.wF();
          androidx.compose.foundation.j.a((androidx.compose.ui.e.c.c)paramh, "avatar", paramf, null, (androidx.compose.ui.h.d)localObject, 0.0F, null, localh, i & 0x380 | 0x30, 104);
          for (;;)
          {
            paramh = localh.oh();
            if (paramh != null) {
              paramh.b((kotlin.g.a.m)new a(paramString1, paramString2, paramf, paramInt1, paramInt2));
            }
            AppMethodBeat.o(235633);
            return;
            if ((paramInt1 & 0xE) != 0) {
              break label419;
            }
            if (localh.G(paramString1))
            {
              i = 4;
              break;
            }
            i = 2;
            break;
            j = i;
            if ((paramInt1 & 0x70) != 0) {
              break label66;
            }
            if (localh.G(paramString2))
            {
              j = 32;
              break label59;
            }
            j = 16;
            break label59;
            label363:
            if ((paramInt1 & 0x380) != 0) {
              break label412;
            }
            if (localh.G(paramf))
            {
              i = 256;
              break label78;
            }
            i = 128;
            break label78;
            localh.oi();
          }
        }
      }
    }
  }
  
  public static final void a(String paramString1, final String paramString2, final String paramString3, final String paramString4, final kotlin.g.a.a<kotlin.ah> parama, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(235627);
    s.u(paramString1, "snsId");
    s.u(paramString2, "mediaId");
    s.u(paramString3, "title");
    s.u(parama, "onClick");
    paramh = paramh.by(-246212466);
    final int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label134:
    label519:
    label522:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      if ((paramInt2 & 0x2) != 0)
      {
        i = 48;
        label75:
        i = j | i;
        label82:
        if ((paramInt2 & 0x4) == 0) {
          break label389;
        }
        j = 384;
        label94:
        j = i | j;
        label101:
        if ((paramInt2 & 0x8) == 0) {
          break label429;
        }
        i = 3072;
        label114:
        i = j | i;
        label121:
        if ((paramInt2 & 0x10) == 0) {
          break label469;
        }
        j = 24576;
        i |= j;
      }
      for (;;)
      {
        if (((0xB6DB & i ^ 0x2492) != 0) || (!paramh.nZ()))
        {
          if ((paramInt2 & 0x8) == 0) {
            break label516;
          }
          paramString4 = null;
        }
        for (;;)
        {
          androidx.compose.ui.f localf = androidx.compose.foundation.g.a(androidx.compose.ui.b.d.a(ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud), (ay)androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(8.0F))), false, parama, 7);
          j = b.a.BG_1;
          Context localContext = MMApplicationContext.getContext();
          s.s(localContext, "getContext()");
          androidx.compose.b.q.a(localf, null, com.tencent.mm.aj.a.c(j, localContext), 0L, null, 0.0F, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(paramh, -819900735, new o(paramString1, paramString2, i, paramString3, paramString4)), paramh, 1572864, 58);
          for (;;)
          {
            paramh = paramh.oh();
            if (paramh != null) {
              paramh.b((kotlin.g.a.m)new p(paramString1, paramString2, paramString3, paramString4, parama, paramInt1, paramInt2));
            }
            AppMethodBeat.o(235627);
            return;
            if ((paramInt1 & 0xE) != 0) {
              break label522;
            }
            if (paramh.G(paramString1))
            {
              i = 4;
              break;
            }
            i = 2;
            break;
            i = j;
            if ((paramInt1 & 0x70) != 0) {
              break label82;
            }
            if (paramh.G(paramString2))
            {
              i = 32;
              break label75;
            }
            i = 16;
            break label75;
            j = i;
            if ((paramInt1 & 0x380) != 0) {
              break label101;
            }
            if (paramh.G(paramString3))
            {
              j = 256;
              break label94;
            }
            j = 128;
            break label94;
            label429:
            i = j;
            if ((paramInt1 & 0x1C00) != 0) {
              break label121;
            }
            if (paramh.G(paramString4))
            {
              i = 2048;
              break label114;
            }
            i = 1024;
            break label114;
            label469:
            if ((0xE000 & paramInt1) != 0) {
              break label519;
            }
            if (paramh.G(parama))
            {
              j = 16384;
              break label134;
            }
            j = 8192;
            break label134;
            paramh.oi();
          }
        }
      }
    }
  }
  
  public static final void a(final String paramString, final List<? extends dmz> paramList, final kotlin.g.a.b<? super String, kotlin.ah> paramb, h paramh, final int paramInt)
  {
    AppMethodBeat.i(235631);
    s.u(paramString, "snsId");
    s.u(paramList, "mediaList");
    s.u(paramb, "imagePreviewCb");
    paramh = paramh.by(1374503047);
    paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.j.yJ());
    paramh.bx(-723524056);
    paramh.bx(-3687241);
    Object localObject = paramh.or();
    h.a locala = h.alD;
    if (localObject == h.a.ox()) {
      paramh.F(new r(androidx.compose.runtime.aa.a((kotlin.d.f)kotlin.d.g.aiwf, paramh)));
    }
    paramh.od();
    paramh.od();
    a((kotlin.g.a.q)androidx.compose.runtime.c.c.a(paramh, -819900292, new g(paramList, paramString, paramInt, paramb)), paramh, 6);
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((kotlin.g.a.m)new h(paramString, paramList, paramb, paramInt));
    }
    AppMethodBeat.o(235631);
  }
  
  public static final void a(String paramString, final kotlin.g.a.a<kotlin.ah> parama, h paramh, final int paramInt)
  {
    AppMethodBeat.i(235624);
    s.u(paramString, "text");
    s.u(parama, "onClick");
    paramh = paramh.by(-955523434);
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramString)) {
        i = 4;
      }
    }
    for (final int i = paramInt | i;; i = paramInt)
    {
      int j;
      if ((paramInt & 0x70) == 0) {
        if (paramh.G(parama))
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
          androidx.compose.ui.f localf = androidx.compose.foundation.g.a(androidx.compose.ui.b.d.a(ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud), (ay)androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(8.0F))), false, parama, 7);
          j = b.a.BG_0;
          Context localContext = MMApplicationContext.getContext();
          s.s(localContext, "getContext()");
          androidx.compose.b.q.a(localf, null, com.tencent.mm.aj.a.c(j, localContext), 0L, null, 0.0F, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(paramh, -819889191, new m(paramString, i)), paramh, 1572864, 58);
        }
        for (;;)
        {
          paramh = paramh.oh();
          if (paramh != null) {
            paramh.b((kotlin.g.a.m)new n(paramString, parama, paramInt));
          }
          AppMethodBeat.o(235624);
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
  
  private static final void a(String paramString, ah.d paramd1, ah.d paramd2, ArrayList<bzi> paramArrayList, dmz paramdmz, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235640);
    if (s.p(paramString, paramdmz.Id)) {
      paramd1.aixb = paramd2.aixb;
    }
    paramString = new bzi();
    paramString.ibT = paramdmz;
    paramString.parentId = s.X("sns_table_", Integer.valueOf(paramInt1));
    paramString.createTime = paramInt2;
    paramd2.aixb += 1;
    paramString.aaiz = paramd2.aixb;
    paramArrayList.add(paramString);
    AppMethodBeat.o(235640);
  }
  
  public static final void a(String paramString, final boolean paramBoolean, final kotlin.g.a.a<kotlin.ah> parama, h paramh, final int paramInt)
  {
    AppMethodBeat.i(235630);
    s.u(paramString, "thumbUrl");
    s.u(parama, "onClick");
    paramh = paramh.by(-1162125614);
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramString)) {
        i = 4;
      }
    }
    for (final int i = paramInt | i;; i = paramInt)
    {
      int j = i;
      if ((paramInt & 0x70) == 0)
      {
        if (paramh.am(paramBoolean))
        {
          j = 32;
          label84:
          j = i | j;
        }
      }
      else
      {
        if ((paramInt & 0x380) != 0) {
          break label241;
        }
        if (!paramh.G(parama)) {
          break label224;
        }
        i = 256;
        label115:
        i |= j;
      }
      for (;;)
      {
        if (((i & 0x2DB ^ 0x92) != 0) || (!paramh.nZ())) {
          a((kotlin.g.a.q)androidx.compose.runtime.c.c.a(paramh, -819899023, new e(paramString, i, parama, paramBoolean)), paramh, 6);
        }
        for (;;)
        {
          paramh = paramh.oh();
          if (paramh != null) {
            paramh.b((kotlin.g.a.m)new f(paramString, paramBoolean, parama, paramInt));
          }
          AppMethodBeat.o(235630);
          return;
          i = 2;
          break;
          j = 16;
          break label84;
          label224:
          i = 128;
          break label115;
          paramh.oi();
        }
        label241:
        i = j;
      }
    }
  }
  
  static final void a(kotlin.g.a.q<? super androidx.compose.foundation.c.d, ? super h, ? super Integer, kotlin.ah> paramq, h paramh, final int paramInt)
  {
    AppMethodBeat.i(235638);
    paramh = paramh.by(614170009);
    int i;
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramq))
      {
        i = 4;
        i |= paramInt;
      }
    }
    for (;;)
    {
      if (((i & 0xB ^ 0x2) != 0) || (!paramh.nZ()))
      {
        Object localObject1 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        int j = b.b.acyU;
        j = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), j);
        Object localObject4 = androidx.compose.ui.b.d.a(ab.e((androidx.compose.ui.f)localObject1, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), j))), (ay)androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(8.0F)));
        paramh.bx(-1990474327);
        localObject1 = androidx.compose.ui.a.atD;
        Object localObject3 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, paramh);
        paramh.bx(1376089335);
        Object localObject2 = (androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
        localObject1 = (n)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
        Object localObject5 = androidx.compose.ui.i.a.aNC;
        localObject5 = androidx.compose.ui.i.a.a.xb();
        localObject4 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject4);
        if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
          androidx.compose.runtime.g.nW();
        }
        paramh.ol();
        if (paramh.nY())
        {
          paramh.a((kotlin.g.a.a)localObject5);
          label240:
          paramh.op();
          s.u(paramh, "composer");
          localObject5 = androidx.compose.ui.i.a.aNC;
          br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xe());
          localObject3 = androidx.compose.ui.i.a.aNC;
          br.a(paramh, localObject2, androidx.compose.ui.i.a.a.xd());
          localObject2 = androidx.compose.ui.i.a.aNC;
          br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
          paramh.oq();
          s.u(paramh, "composer");
          ((kotlin.g.a.q)localObject4).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
          paramh.bx(2058660585);
          paramh.bx(-1253629305);
          localObject1 = (androidx.compose.foundation.c.d)e.acr;
          localObject2 = ab.d(ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud));
          float f = androidx.compose.ui.n.g.ai(0.5F);
          j = b.a.FG_3;
          localObject3 = MMApplicationContext.getContext();
          s.s(localObject3, "getContext()");
          localObject2 = androidx.compose.foundation.d.a((androidx.compose.ui.f)localObject2, f, com.tencent.mm.aj.a.c(j, (Context)localObject3), (ay)androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(8.0F)));
          localObject3 = a.aczo;
          androidx.compose.b.q.a((androidx.compose.ui.f)localObject2, null, 0L, 0L, null, 0.0F, a.iVw(), paramh, 0, 62);
          paramq.invoke(localObject1, paramh, Integer.valueOf(i << 3 & 0x70 | 0x6));
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
          paramh.b((kotlin.g.a.m)new i(paramq, paramInt));
        }
        AppMethodBeat.o(235638);
        return;
        i = 2;
        break;
        paramh.om();
        break label240;
        paramh.oi();
      }
      i = paramInt;
    }
  }
  
  static final boolean h(bm<Boolean> parambm)
  {
    AppMethodBeat.i(235641);
    boolean bool = ((Boolean)parambm.getValue()).booleanValue();
    AppMethodBeat.o(235641);
    return bool;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    a(String paramString1, String paramString2, androidx.compose.ui.f paramf, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isOk", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    aa(g paramg, com.tencent.mm.sns_compose.a.f paramf, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    b(dmz paramdmz, an<af> paraman, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(235585);
      paramObject = (kotlin.d.d)new b(this.mrU, paramh, paramd);
      AppMethodBeat.o(235585);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(235581);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(235581);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.sns_compose.a.acyR;
        Object localObject = this.mrU;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        localObject = paramObject.b((dmz)localObject, false, locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(235581);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (Bitmap)paramObject;
      if (paramObject != null)
      {
        paramObject = androidx.compose.ui.e.f.h(paramObject);
        if (paramObject != null) {
          paramh.setValue(paramObject);
        }
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(235581);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    c(dmz paramdmz, androidx.compose.ui.f paramf, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    d(String paramString, androidx.compose.ui.f paramf, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.q<androidx.compose.foundation.c.d, h, Integer, kotlin.ah>
  {
    e(String paramString, int paramInt, kotlin.g.a.a<kotlin.ah> parama, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    f(String paramString, boolean paramBoolean, kotlin.g.a.a<kotlin.ah> parama, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.q<androidx.compose.foundation.c.d, h, Integer, kotlin.ah>
  {
    g(List<? extends dmz> paramList, String paramString, int paramInt, kotlin.g.a.b<? super String, kotlin.ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    h(String paramString, List<? extends dmz> paramList, kotlin.g.a.b<? super String, kotlin.ah> paramb, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    i(kotlin.g.a.q<? super androidx.compose.foundation.c.d, ? super h, ? super Integer, kotlin.ah> paramq, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    j(dmz paramdmz, String paramString1, String paramString2, kotlin.g.a.a<kotlin.ah> parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    k(dmz paramdmz, String paramString1, int paramInt, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    l(dmz paramdmz, String paramString1, String paramString2, kotlin.g.a.a<kotlin.ah> parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    m(String paramString, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    n(String paramString, kotlin.g.a.a<kotlin.ah> parama, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    o(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    p(String paramString1, String paramString2, String paramString3, String paramString4, kotlin.g.a.a<kotlin.ah> parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.b<y, x>
  {
    q(androidx.lifecycle.q paramq, com.tencent.mm.sns_compose.d.c paramc)
    {
      super();
    }
    
    private static final void a(com.tencent.mm.sns_compose.d.c paramc, androidx.lifecycle.q paramq, j.a parama)
    {
      AppMethodBeat.i(235547);
      s.u(paramc, "$playState");
      s.u(paramq, "$noName_0");
      s.u(parama, "event");
      if (parama != j.a.ON_START)
      {
        if (parama == j.a.ON_PAUSE)
        {
          paramc = paramc.HOn;
          if (paramc != null) {
            paramc.pause();
          }
          AppMethodBeat.o(235547);
          return;
        }
        if (parama == j.a.ON_DESTROY)
        {
          paramq = paramc.HOn;
          if (paramq != null) {
            paramq.stop();
          }
          paramc.HOn = null;
          paramc = com.tencent.mm.sns_compose.d.c.acAc;
          Log.v("MiscroMsg.PlayerState", "playerRecycler clear");
          paramc = com.tencent.mm.sns_compose.d.c.iVA();
          s.s(paramc, "playerRecycler");
          paramc = ((Iterable)paramc).iterator();
          while (paramc.hasNext()) {
            ((ThumbPlayerVideoView)paramc.next()).stop();
          }
          com.tencent.mm.sns_compose.d.c.iVA().clear();
          AppMethodBeat.o(235547);
          return;
        }
        if ((parama == j.a.ON_RESUME) && (paramc.hJg))
        {
          paramc = paramc.HOn;
          if (paramc != null) {
            paramc.start();
          }
        }
      }
      AppMethodBeat.o(235547);
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(androidx.lifecycle.q paramq, o paramo) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(235566);
        this.aczC.getLifecycle().removeObserver((androidx.lifecycle.p)this.aczD);
        AppMethodBeat.o(235566);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    r(com.tencent.mm.sns_compose.d.c paramc, bm<Boolean> parambm, kotlin.d.d<? super r> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(235549);
      paramObject = (kotlin.d.d)new r(this.aczB, localbm, paramd);
      AppMethodBeat.o(235549);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(235546);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(235546);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.aczB;
      boolean bool = c.h(localbm);
      Log.v("MiscroMsg.PlayerState", "updatePlayState snsId:" + paramObject.hQX + "  isPlay:play :" + bool);
      paramObject.hJg = bool;
      if (paramObject.HOn != null)
      {
        if (!paramObject.hJg) {
          break label159;
        }
        localObject = paramObject.HOn;
        s.checkNotNull(localObject);
        if (!((ThumbPlayerVideoView)localObject).isPlaying())
        {
          paramObject = paramObject.HOn;
          if (paramObject != null) {
            paramObject.start();
          }
        }
      }
      for (;;)
      {
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(235546);
        return paramObject;
        label159:
        localObject = paramObject.HOn;
        s.checkNotNull(localObject);
        if (((ThumbPlayerVideoView)localObject).isPlaying())
        {
          paramObject = paramObject.HOn;
          if (paramObject != null) {
            paramObject.pause();
          }
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.q<androidx.compose.foundation.c.d, h, Integer, kotlin.ah>
  {
    s(kotlin.g.a.a<kotlin.ah> parama, com.tencent.mm.sns_compose.d.c paramc, bm<Boolean> parambm)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    t(f.g paramg, LifecycleScope paramLifecycleScope, kotlin.g.a.a<Boolean> parama, kotlin.g.a.a<kotlin.ah> parama1, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, kotlin.ah>
  {
    v(com.tencent.mm.sns_compose.a.f paramf, Context paramContext, g paramg, aq paramaq, androidx.paging.compose.a<com.tencent.mm.sns_compose.a.f> parama)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    w(int paramInt1, int paramInt2, androidx.compose.foundation.lazy.aa paramaa, androidx.paging.compose.a<com.tencent.mm.sns_compose.a.f> parama, com.tencent.mm.sns_compose.a.f paramf)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, kotlin.ah>
  {
    x(g paramg, androidx.compose.foundation.lazy.aa paramaa, int paramInt1, com.tencent.mm.sns_compose.a.f paramf, androidx.paging.compose.a<com.tencent.mm.sns_compose.a.f> parama, LifecycleScope paramLifecycleScope, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    y(com.tencent.mm.sns_compose.a.f paramf, Context paramContext, g paramg, aq paramaq)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    z(Context paramContext, g paramg, aq paramaq, com.tencent.mm.sns_compose.a.f paramf, androidx.paging.compose.a<com.tencent.mm.sns_compose.a.f> parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.c.c
 * JD-Core Version:    0.7.0.1
 */