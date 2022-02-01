package com.tencent.mm.timelineedit.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.timelineedit.TimelineEditor;
import com.tencent.mm.timelineedit.a.a.aa;
import com.tencent.mm.timelineedit.a.a.ac;
import com.tencent.mm.timelineedit.a.a.i;
import com.tencent.mm.timelineedit.a.a.o;
import com.tencent.mm.timelineedit.a.a.p;
import com.tencent.mm.timelineedit.a.a.q;
import com.tencent.mm.timelineedit.a.a.q.a;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toContentCropType", "", "Lcom/tencent/mm/timelineedit/model/pb/PBVideoContentCrop;", "toMotionAction", "toPBEditorOutsideType", "Lcom/tencent/mm/timelineedit/model/pb/EditorOutSideType;", "toPBTrackType", "Lcom/tencent/mm/timelineedit/model/pb/PBTrackType;", "toPBVideoContentCrop", "toProto", "Lcom/tencent/mm/timelineedit/model/pb/RectProto;", "Landroid/graphics/Rect;", "toRect", "toTrackProto", "Lcom/tencent/mm/timelineedit/model/Track;", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "toTrackRotate", "toTrackType", "toVideoComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "Lcom/tencent/mm/timelineedit/model/pb/CompositionInfo;", "timelineEditor", "Lcom/tencent/mm/timelineedit/TimelineEditor;", "timelinelib_release"}, k=2, mv={1, 1, 15})
public final class a
{
  public static final q H(Rect paramRect)
  {
    AppMethodBeat.i(232068);
    s.t(paramRect, "$this$toProto");
    paramRect = q.jfS().azB(paramRect.left).azC(paramRect.top).azD(paramRect.right).azE(paramRect.bottom).jfX();
    s.r(paramRect, "RectProto.newBuilder()\n …(bottom)\n        .build()");
    AppMethodBeat.o(232068);
    return paramRect;
  }
  
  public static final int a(o paramo)
  {
    AppMethodBeat.i(232074);
    s.t(paramo, "$this$toTrackType");
    switch (b.$EnumSwitchMapping$0[paramo.ordinal()])
    {
    default: 
      AppMethodBeat.o(232074);
      return 0;
    case 1: 
      AppMethodBeat.o(232074);
      return 1;
    case 2: 
      AppMethodBeat.o(232074);
      return 3;
    }
    AppMethodBeat.o(232074);
    return 2;
  }
  
  public static final int a(p paramp)
  {
    AppMethodBeat.i(232080);
    s.t(paramp, "$this$toContentCropType");
    switch (b.avl[paramp.ordinal()])
    {
    default: 
      AppMethodBeat.o(232080);
      return 4;
    case 1: 
      AppMethodBeat.o(232080);
      return 1;
    case 2: 
      AppMethodBeat.o(232080);
      return 2;
    }
    AppMethodBeat.o(232080);
    return 0;
  }
  
  public static final Rect a(q paramq)
  {
    AppMethodBeat.i(232064);
    s.t(paramq, "$this$toRect");
    paramq = new Rect(paramq.yY(), paramq.yZ(), paramq.CP(), paramq.CQ());
    AppMethodBeat.o(232064);
    return paramq;
  }
  
  public static final j a(com.tencent.mm.timelineedit.a.a.e parame, TimelineEditor paramTimelineEditor)
  {
    AppMethodBeat.i(232103);
    s.t(parame, "$this$toVideoComposition");
    s.t(paramTimelineEditor, "timelineEditor");
    Object localObject1 = parame.jfa();
    s.r(localObject1, "tracksList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (List)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aa)((Iterator)localObject2).next();
      s.r(localObject3, "trackInfo");
      Object localObject4 = ((aa)localObject3).jgx();
      s.r(localObject4, "trackInfo.type");
      i = a((o)localObject4);
      if (i != 0)
      {
        localObject4 = ((aa)localObject3).getPath();
        s.r(localObject4, "trackInfo.path");
        localObject4 = new b((String)localObject4, i);
        ((b)localObject4).id = ((aa)localObject3).getId();
        ((b)localObject4).setStartTimeMs(((aa)localObject3).getStartTimeMs());
        ((b)localObject4).wA(((aa)localObject3).getEndTimeMs());
        ((b)localObject4).wB(((aa)localObject3).jgy());
        ((b)localObject4).wC(((aa)localObject3).jgz());
        ((b)localObject4).setVolume(((aa)localObject3).getVolume());
        ((b)localObject4).hYK = azr(((aa)localObject3).hRY());
        ((b)localObject4).setPlayRate(((aa)localObject3).getPlayRate());
        Object localObject5 = ((aa)localObject3).jgB();
        s.r(localObject5, "trackInfo.cropInfo");
        localObject5 = ((i)localObject5).jfG();
        s.r(localObject5, "trackInfo.cropInfo.displayRect");
        ((b)localObject4).setCropRect(a((q)localObject5));
        localObject5 = ((aa)localObject3).jgB();
        s.r(localObject5, "trackInfo.cropInfo");
        localObject5 = ((i)localObject5).jfE();
        s.r(localObject5, "trackInfo.cropInfo.cropRect");
        ((b)localObject4).I(a((q)localObject5));
        if (((aa)localObject3).jgE() == p.adqQ) {}
        for (boolean bool = true;; bool = false)
        {
          ((b)localObject4).agDA = bool;
          localObject5 = new com.tencent.mm.videocomposition.g();
          Object localObject6 = ((aa)localObject3).jgD();
          s.r(localObject6, "trackInfo.transitionInfo");
          localObject6 = ((ac)localObject6).getPath();
          s.r(localObject6, "trackInfo.transitionInfo.path");
          ((com.tencent.mm.videocomposition.g)localObject5).setPath((String)localObject6);
          localObject3 = ((aa)localObject3).jgD();
          s.r(localObject3, "trackInfo.transitionInfo");
          ((com.tencent.mm.videocomposition.g)localObject5).duration = ((ac)localObject3).getDuration();
          ((b)localObject4).a((com.tencent.mm.videocomposition.g)localObject5);
          ((List)localObject1).add(localObject4);
          break;
        }
      }
    }
    localObject1 = new j((List)localObject1);
    ((j)localObject1).FO(parame.jfb());
    localObject2 = parame.jfh();
    s.r(localObject2, "canvasRect");
    int i = a((q)localObject2).width();
    parame = parame.jfh();
    s.r(parame, "canvasRect");
    ((j)localObject1).pk(i, a(parame).height());
    ((j)localObject1).UbK = paramTimelineEditor.getEffectManager();
    AppMethodBeat.o(232103);
    return localObject1;
  }
  
  private static int azr(int paramInt)
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
  
  public static final int azs(int paramInt)
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
    AppMethodBeat.i(232115);
    s.t(paramb, "$this$toTrackProto");
    g localg = new g();
    localg.zl(paramb.id);
    localg.setPath(paramb.path);
    localg.azv(paramb.type);
    localg.a(new f(paramb.startTimeMs, paramb.endTimeMs));
    localg.b(new f(paramb.TDw, paramb.TDx));
    localg.setPlayRate(paramb.sAn);
    localg.setVolume(paramb.volume);
    localg.th(paramb.hYK);
    localg.zm(paramb.UjZ);
    localg.a(new e(paramb.UaC, paramb.UaD));
    localg.I(paramb.agDz);
    localg.J(paramb.Gl);
    if (paramb.agDA) {
      localg.azw(a(p.adqQ));
    }
    AppMethodBeat.o(232115);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a
 * JD-Core Version:    0.7.0.1
 */