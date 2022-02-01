package com.tencent.mm.timelineedit.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.timelineedit.TimelineEditor;
import com.tencent.mm.timelineedit.a.a.aa;
import com.tencent.mm.timelineedit.a.a.ac;
import com.tencent.mm.timelineedit.a.a.i;
import com.tencent.mm.timelineedit.a.a.o;
import com.tencent.mm.timelineedit.a.a.q;
import com.tencent.mm.timelineedit.a.a.q.a;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"toContentCropType", "", "Lcom/tencent/mm/timelineedit/model/pb/PBVideoContentCrop;", "toMotionAction", "toPBEditorOutsideType", "Lcom/tencent/mm/timelineedit/model/pb/EditorOutSideType;", "toPBTrackType", "Lcom/tencent/mm/timelineedit/model/pb/PBTrackType;", "toPBVideoContentCrop", "toProto", "Lcom/tencent/mm/timelineedit/model/pb/RectProto;", "Landroid/graphics/Rect;", "toRect", "toTrackProto", "Lcom/tencent/mm/timelineedit/model/Track;", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "toTrackRotate", "toTrackType", "toVideoComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "Lcom/tencent/mm/timelineedit/model/pb/CompositionInfo;", "timelineEditor", "Lcom/tencent/mm/timelineedit/TimelineEditor;", "timelinelib_release"})
public final class a
{
  public static final int a(o paramo)
  {
    AppMethodBeat.i(262034);
    kotlin.g.b.p.k(paramo, "$this$toTrackType");
    switch (b.$EnumSwitchMapping$0[paramo.ordinal()])
    {
    default: 
      AppMethodBeat.o(262034);
      return 0;
    case 1: 
      AppMethodBeat.o(262034);
      return 1;
    case 2: 
      AppMethodBeat.o(262034);
      return 3;
    }
    AppMethodBeat.o(262034);
    return 2;
  }
  
  public static final int a(com.tencent.mm.timelineedit.a.a.p paramp)
  {
    AppMethodBeat.i(262035);
    kotlin.g.b.p.k(paramp, "$this$toContentCropType");
    switch (b.jLJ[paramp.ordinal()])
    {
    default: 
      AppMethodBeat.o(262035);
      return 4;
    case 1: 
      AppMethodBeat.o(262035);
      return 1;
    case 2: 
      AppMethodBeat.o(262035);
      return 2;
    }
    AppMethodBeat.o(262035);
    return 0;
  }
  
  public static final Rect a(q paramq)
  {
    AppMethodBeat.i(262031);
    kotlin.g.b.p.k(paramq, "$this$toRect");
    paramq = new Rect(paramq.hDI(), paramq.hDJ(), paramq.fG(), paramq.fH());
    AppMethodBeat.o(262031);
    return paramq;
  }
  
  public static final j a(com.tencent.mm.timelineedit.a.a.e parame, TimelineEditor paramTimelineEditor)
  {
    AppMethodBeat.i(262040);
    kotlin.g.b.p.k(parame, "$this$toVideoComposition");
    kotlin.g.b.p.k(paramTimelineEditor, "timelineEditor");
    Object localObject1 = parame.hCT();
    kotlin.g.b.p.j(localObject1, "tracksList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (List)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aa)((Iterator)localObject2).next();
      kotlin.g.b.p.j(localObject3, "trackInfo");
      Object localObject4 = ((aa)localObject3).hEl();
      kotlin.g.b.p.j(localObject4, "trackInfo.type");
      i = a((o)localObject4);
      if (i != 0)
      {
        localObject4 = ((aa)localObject3).getPath();
        kotlin.g.b.p.j(localObject4, "trackInfo.path");
        localObject4 = new b((String)localObject4, i);
        ((b)localObject4).id = ((aa)localObject3).getId();
        ((b)localObject4).Sl(((aa)localObject3).getStartTimeMs());
        ((b)localObject4).Sm(((aa)localObject3).getEndTimeMs());
        ((b)localObject4).Sn(((aa)localObject3).hEm());
        ((b)localObject4).So(((aa)localObject3).hEn());
        ((b)localObject4).setVolume(((aa)localObject3).getVolume());
        ((b)localObject4).fSM = atb(((aa)localObject3).aVr());
        ((b)localObject4).setPlayRate(((aa)localObject3).getPlayRate());
        Object localObject5 = ((aa)localObject3).hEp();
        kotlin.g.b.p.j(localObject5, "trackInfo.cropInfo");
        localObject5 = ((i)localObject5).hDy();
        kotlin.g.b.p.j(localObject5, "trackInfo.cropInfo.displayRect");
        ((b)localObject4).setCropRect(a((q)localObject5));
        localObject5 = ((aa)localObject3).hEp();
        kotlin.g.b.p.j(localObject5, "trackInfo.cropInfo");
        localObject5 = ((i)localObject5).hDw();
        kotlin.g.b.p.j(localObject5, "trackInfo.cropInfo.cropRect");
        ((b)localObject4).A(a((q)localObject5));
        if (((aa)localObject3).hEs() == com.tencent.mm.timelineedit.a.a.p.VML) {}
        for (boolean bool = true;; bool = false)
        {
          ((b)localObject4).YHT = bool;
          localObject5 = new com.tencent.mm.videocomposition.g();
          Object localObject6 = ((aa)localObject3).hEr();
          kotlin.g.b.p.j(localObject6, "trackInfo.transitionInfo");
          localObject6 = ((ac)localObject6).getPath();
          kotlin.g.b.p.j(localObject6, "trackInfo.transitionInfo.path");
          ((com.tencent.mm.videocomposition.g)localObject5).setPath((String)localObject6);
          localObject3 = ((aa)localObject3).hEr();
          kotlin.g.b.p.j(localObject3, "trackInfo.transitionInfo");
          ((com.tencent.mm.videocomposition.g)localObject5).duration = ((ac)localObject3).getDuration();
          ((b)localObject4).a((com.tencent.mm.videocomposition.g)localObject5);
          ((List)localObject1).add(localObject4);
          break;
        }
      }
    }
    localObject1 = new j((List)localObject1);
    ((j)localObject1).Ap(parame.hCU());
    localObject2 = parame.hDa();
    kotlin.g.b.p.j(localObject2, "canvasRect");
    int i = a((q)localObject2).width();
    parame = parame.hDa();
    kotlin.g.b.p.j(parame, "canvasRect");
    ((j)localObject1).nn(i, a(parame).height());
    ((j)localObject1).Noe = paramTimelineEditor.getEffectManager();
    AppMethodBeat.o(262040);
    return localObject1;
  }
  
  private static int atb(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 90: 
      return 1;
    case 180: 
      return 2;
    }
    return 3;
  }
  
  public static final int atc(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return 0;
    case 0: 
    case 5: 
      return 1;
    case 2: 
      return 2;
    case 1: 
    case 6: 
      return 3;
    }
    return 4;
  }
  
  public static final g c(b paramb)
  {
    AppMethodBeat.i(262042);
    kotlin.g.b.p.k(paramb, "$this$toTrackProto");
    g localg = new g();
    localg.Vd(paramb.id);
    localg.setPath(paramb.path);
    localg.atf(paramb.type);
    localg.a(new f(paramb.startTimeMs, paramb.endTimeMs));
    localg.b(new f(paramb.MQV, paramb.MQW));
    localg.setPlayRate(paramb.pvh);
    localg.setVolume(paramb.volume);
    localg.tm(paramb.fSM);
    localg.Ve(paramb.NwS);
    localg.a(new e(paramb.Nna, paramb.Nnb));
    localg.A(paramb.YHS);
    localg.B(paramb.kXj);
    if (paramb.YHT) {
      localg.atg(a(com.tencent.mm.timelineedit.a.a.p.VML));
    }
    AppMethodBeat.o(262042);
    return localg;
  }
  
  public static final q z(Rect paramRect)
  {
    AppMethodBeat.i(262032);
    kotlin.g.b.p.k(paramRect, "$this$toProto");
    paramRect = q.hDK().atl(paramRect.left).atm(paramRect.top).atn(paramRect.right).ato(paramRect.bottom).hDO();
    kotlin.g.b.p.j(paramRect, "RectProto.newBuilder()\n …(bottom)\n        .build()");
    AppMethodBeat.o(262032);
    return paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a
 * JD-Core Version:    0.7.0.1
 */