package com.tencent.mm.plugin.vlog.ui;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.ui.plugin.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.xeffect.VLogEffectMgr;
import com.tencent.mm.xeffect.VLogEffectMgr.b;
import d.a.ae;
import d.d.b.a.j;
import d.d.d;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.u;
import d.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.az;
import kotlinx.coroutines.g;

@d.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout$setupTemplateVideoPlugins$1", f="MultiVideoPluginLayout.kt", gfL={1739}, m="invokeSuspend")
@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class MultiVideoPluginLayout$h
  extends j
  implements m<ah, d<? super z>, Object>
{
  int label;
  private ah nWQ;
  Object nWR;
  
  MultiVideoPluginLayout$h(MultiVideoPluginLayout paramMultiVideoPluginLayout, a.c paramc, boolean paramBoolean, d paramd)
  {
    super(paramd);
  }
  
  public final d<z> a(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(196033);
    p.h(paramd, "completion");
    paramd = new h(this.BLi, this.BLE, this.BLF, paramd);
    paramd.nWQ = ((ah)paramObject);
    AppMethodBeat.o(196033);
    return paramd;
  }
  
  public final Object cQ(Object paramObject)
  {
    AppMethodBeat.i(196032);
    paramObject = d.d.a.a.MLc;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(196032);
      throw paramObject;
    case 0: 
      ah localah = this.nWQ;
      Object localObject1 = MultiVideoPluginLayout.a(this.BLi).BMQ;
      if (localObject1 != null) {
        ((VideoCompositionPlayView)localObject1).pause();
      }
      localObject1 = MultiVideoPluginLayout.p(this.BLi);
      Object localObject2 = this.BLE;
      p.h(localObject2, "template");
      ((com.tencent.mm.plugin.vlog.model.o)localObject1).BFI = -1;
      ((com.tencent.mm.plugin.vlog.model.o)localObject1).BFH.clear();
      Object localObject3 = com.tencent.mm.plugin.vlog.model.local.a.BHu;
      localObject3 = com.tencent.mm.plugin.vlog.model.local.a.a((a.c)localObject2, (List)((com.tencent.mm.plugin.vlog.model.o)localObject1).BFs);
      p.h(localObject2, "template");
      p.h(localObject3, "trackList");
      w localw;
      if (((a.c)localObject2).BHz)
      {
        localObject4 = ((Iterable)localObject3).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localw = (w)((Iterator)localObject4).next();
          Object localObject5 = ((a.c)localObject2).BHx;
          double d = 1.0D * ((Size)localObject5).getWidth() / ((Size)localObject5).getHeight();
          localw.BGw.hmm.setEmpty();
          int i;
          if (1.0D * localw.BGw.BGr / localw.BGw.BGs < d)
          {
            i = localw.BGw.BGr;
            d = i / d;
            localObject5 = new Rect();
            ((Rect)localObject5).left = 0;
            ((Rect)localObject5).right = i;
            ((Rect)localObject5).top = ((int)((localw.BGw.BGs - d) / 2.0D));
            ((Rect)localObject5).bottom = ((int)(d + ((Rect)localObject5).top));
            localw.BGw.Lmz.set((Rect)localObject5);
          }
          for (;;)
          {
            localw.BGw.LmA = false;
            ad.i(((com.tencent.mm.plugin.vlog.model.o)localObject1).TAG, "track source size:[" + localw.BGw.BGr + ", " + localw.BGw.BGs + "], trackCropRect:" + localw.BGw.Lmz + ", templateSize:" + ((a.c)localObject2).BHx);
            break;
            i = localw.BGw.BGs;
            d *= i;
            localObject5 = new Rect();
            ((Rect)localObject5).top = 0;
            ((Rect)localObject5).bottom = i;
            ((Rect)localObject5).left = ((int)((localw.BGw.BGr - d) / 2.0D));
            ((Rect)localObject5).right = ((int)(d + ((Rect)localObject5).left));
            localw.BGw.Lmz.set((Rect)localObject5);
          }
        }
      }
      else
      {
        localObject4 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localw = (w)((Iterator)localObject4).next();
          localw.BGw.Lmz.set(0, 0, localw.BGw.BGr, localw.BGw.BGs);
          localw.BGw.LmA = false;
        }
      }
      ((com.tencent.mm.plugin.vlog.model.o)localObject1).BFH.addAll((Collection)localObject3);
      ((com.tencent.mm.plugin.vlog.model.o)localObject1).BFd = new v((List)((com.tencent.mm.plugin.vlog.model.o)localObject1).BFH);
      ((com.tencent.mm.plugin.vlog.model.o)localObject1).BFd.Bh(((a.c)localObject2).duration);
      localObject3 = ((com.tencent.mm.plugin.vlog.model.o)localObject1).BFd;
      Object localObject4 = com.tencent.mm.plugin.vlog.model.local.a.BHu;
      ((v)localObject3).a(com.tencent.mm.plugin.vlog.model.local.a.esu());
      ((com.tencent.mm.plugin.vlog.model.o)localObject1).BFd.io(((com.tencent.mm.plugin.vlog.model.o)localObject1).BFx, (int)(((com.tencent.mm.plugin.vlog.model.o)localObject1).BFx / (1.0D * ((a.c)localObject2).BHx.getWidth() / ((a.c)localObject2).BHx.getHeight())));
      ((com.tencent.mm.plugin.vlog.model.o)localObject1).BFd.sQ(false);
      ((com.tencent.mm.plugin.vlog.model.o)localObject1).BFd.aDp(((a.c)localObject2).hml);
      MultiVideoPluginLayout.p(this.BLi).Tz(-1);
      localObject1 = com.tencent.mm.plugin.vlog.model.local.a.BHu;
      localObject1 = this.BLE;
      localObject2 = new long[0];
      p.h(localObject1, "videoTemplate");
      p.h(localObject2, "targets");
      localObject3 = com.tencent.mm.plugin.vlog.model.local.a.BHr;
      if (localObject3 != null) {
        ((VLogEffectMgr)localObject3).fSr();
      }
      localObject3 = com.tencent.mm.plugin.vlog.model.local.a.BHr;
      if (localObject3 != null) {
        ((VLogEffectMgr)localObject3).fSs();
      }
      com.tencent.mm.plugin.vlog.model.local.a.e(-1L, -1L, false);
      localObject3 = com.tencent.mm.plugin.vlog.model.local.a.BHq;
      if (localObject3 != null) {
        com.tencent.mm.plugin.vlog.model.local.a.b((a.c)localObject3);
      }
      localObject3 = com.tencent.mm.plugin.vlog.model.local.a.BHr;
      if (localObject3 != null) {}
      for (long l = ((VLogEffectMgr)localObject3).a(0L, ((a.c)localObject1).duration, ((a.c)localObject1).xPg, (long[])localObject2);; l = -1L)
      {
        ((a.c)localObject1).BHA = l;
        localObject2 = com.tencent.mm.plugin.vlog.model.local.a.BHr;
        if (localObject2 != null) {
          ((VLogEffectMgr)localObject2).b(((a.c)localObject1).BHA, ae.c(new d.o[] { u.S(Integer.valueOf(VLogEffectMgr.b.LBB.ordinal()), Float.valueOf(1.0F)) }));
        }
        com.tencent.mm.plugin.vlog.model.local.a.BHq = (a.c)localObject1;
        localObject1 = (d.d.f)az.gvo();
        localObject2 = (m)new j(null)
        {
          int label;
          private ah nWQ;
          
          public final d<z> a(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(196030);
            p.h(paramAnonymousd, "completion");
            paramAnonymousd = new 1(this.BLG, paramAnonymousd);
            paramAnonymousd.nWQ = ((ah)paramAnonymousObject);
            AppMethodBeat.o(196030);
            return paramAnonymousd;
          }
          
          public final Object cQ(Object paramAnonymousObject)
          {
            AppMethodBeat.i(196029);
            paramAnonymousObject = d.d.a.a.MLc;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(196029);
              throw paramAnonymousObject;
            }
            if (this.BLG.BLF) {
              c.a(MultiVideoPluginLayout.a(this.BLG.BLi), true, true, 0L, 4);
            }
            for (;;)
            {
              paramAnonymousObject = z.MKo;
              AppMethodBeat.o(196029);
              return paramAnonymousObject;
              MultiVideoPluginLayout.a(this.BLG.BLi).sT(true);
            }
          }
          
          public final Object p(Object paramAnonymousObject1, Object paramAnonymousObject2)
          {
            AppMethodBeat.i(196031);
            paramAnonymousObject1 = ((1)a(paramAnonymousObject1, (d)paramAnonymousObject2)).cQ(z.MKo);
            AppMethodBeat.o(196031);
            return paramAnonymousObject1;
          }
        };
        this.nWR = localah;
        this.label = 1;
        if (g.a((d.d.f)localObject1, (m)localObject2, this) != paramObject) {
          break;
        }
        AppMethodBeat.o(196032);
        return paramObject;
      }
    }
    paramObject = z.MKo;
    AppMethodBeat.o(196032);
    return paramObject;
  }
  
  public final Object p(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(196034);
    paramObject1 = ((h)a(paramObject1, (d)paramObject2)).cQ(z.MKo);
    AppMethodBeat.o(196034);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout.h
 * JD-Core Version:    0.7.0.1
 */