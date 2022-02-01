package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.vlog.decoder.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.timelineedit.TimelineEditor;
import com.tencent.mm.timelineedit.TimelineEditor.g;
import com.tencent.mm.timelineedit.TimelineEditor.h;
import com.tencent.mm.timelineedit.TimelineEditor.m;
import com.tencent.mm.timelineedit.TimelineEditor.n;
import com.tencent.mm.timelineedit.TimelineEditor.q;
import com.tencent.mm.timelineedit.TimelineEditor.r;
import com.tencent.mm.timelineedit.TimelineEditor.s;
import com.tencent.mm.timelineedit.TimelineEditor.t;
import com.tencent.mm.timelineedit.a.g;
import com.tencent.mm.timelineedit.a.h;
import com.tencent.mm.videocomposition.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCorePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "config", "Lcom/tencent/mm/timelineedit/model/EditorConfig;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/timelineedit/model/EditorConfig;)V", "audioChannelCount", "", "audioSampleRate", "callbacks", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCorePlugin$CompositionUpdateCallback;", "Lkotlin/collections/ArrayList;", "value", "Lcom/tencent/mm/videocomposition/VideoComposition;", "composition", "setComposition", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "getConfig", "()Lcom/tencent/mm/timelineedit/model/EditorConfig;", "setConfig", "(Lcom/tencent/mm/timelineedit/model/EditorConfig;)V", "timelineEditor", "Lcom/tencent/mm/timelineedit/TimelineEditor;", "addCompositionUpdateCallback", "", "callback", "addMusicTrack", "path", "", "addText", "text", "fontColor", "bgColor", "fontStyle", "trackId", "", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/Long;)V", "addTrackList", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "addTransitionEffect", "duration", "index", "addTransitionEffectAll", "addWechatEmoji", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/Long;)V", "create", "", "canvasRect", "Landroid/graphics/Rect;", "validRect", "fastMuteOrigin", "mute", "fullScreenCreate", "getComposition", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getNoTransitionComposition", "getSingleFullRangeComposition", "getTransitionPlayRange", "Lcom/tencent/mm/timelineedit/model/TimeRange;", "limitMaxDuration", "maxDurationMs", "onTouchEvent", "Lkotlin/Pair;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "Lcom/tencent/mm/timelineedit/model/Track;", "touchEvent", "Landroid/view/MotionEvent;", "reset", "restore", "replace", "save", "switchMediaAudioMute", "updateCompositionCallback", "updateCompositionDuration", "startMs", "endMs", "updateIndexTrackDuration", "(IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTTSResultTrack", "result", "", "Lkotlin/Triple;", "updateTrackDuration", "(Ljava/lang/Long;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTrackSpeed", "playRate", "", "(Ljava/lang/Long;F)Lcom/tencent/mm/videocomposition/VideoComposition;", "validRectCreate", "valid", "Companion", "CompositionUpdateCallback", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final b.a Uqn;
  public j Uaw;
  public com.tencent.mm.timelineedit.a.c Uqo;
  public TimelineEditor Uqp;
  public final ArrayList<b> Uqq;
  private int audioChannelCount;
  private int audioSampleRate;
  
  static
  {
    AppMethodBeat.i(282283);
    Uqn = new b.a((byte)0);
    AppMethodBeat.o(282283);
  }
  
  public b(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, com.tencent.mm.timelineedit.a.c paramc)
  {
    super(parama);
    AppMethodBeat.i(282240);
    this.Uqo = paramc;
    this.Uqp = new TimelineEditor();
    this.audioSampleRate = 44100;
    this.audioChannelCount = 1;
    this.Uqq = new ArrayList();
    AppMethodBeat.o(282240);
  }
  
  private final void hUz()
  {
    AppMethodBeat.i(282247);
    Iterator localIterator = ((Iterable)this.Uqq).iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).c(this.Uaw);
    }
    AppMethodBeat.o(282247);
  }
  
  public final j Gb(boolean paramBoolean)
  {
    AppMethodBeat.i(282371);
    Object localObject1 = this.Uqo;
    boolean bool;
    Object localObject2;
    if (!paramBoolean)
    {
      bool = true;
      ((com.tencent.mm.timelineedit.a.c)localObject1).KH(bool);
      localObject1 = this.Uqp;
      localObject2 = this.Uqo;
      s.t(localObject2, "config");
      TimelineEditor.a((kotlin.g.a.a)new TimelineEditor.s((TimelineEditor)localObject1, (com.tencent.mm.timelineedit.a.c)localObject2), (kotlin.g.a.b)new TimelineEditor.t((TimelineEditor)localObject1));
      localObject1 = this.Uaw;
      if (localObject1 == null) {
        break label166;
      }
      localObject1 = (List)((j)localObject1).TDz;
      if (localObject1 == null) {
        break label166;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      label110:
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (com.tencent.mm.videocomposition.b)((Iterator)localObject1).next();
      } while (((com.tencent.mm.videocomposition.b)localObject2).type == 3);
      if (!paramBoolean) {
        break label161;
      }
    }
    label161:
    for (float f = 0.0F;; f = 1.0F)
    {
      ((com.tencent.mm.videocomposition.b)localObject2).setVolume(f);
      break label110;
      bool = false;
      break;
    }
    label166:
    localObject1 = this.Uaw;
    AppMethodBeat.o(282371);
    return localObject1;
  }
  
  public final j a(Long paramLong, float paramFloat)
  {
    AppMethodBeat.i(282394);
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      Object localObject = this.Uaw;
      if (localObject != null)
      {
        localObject = (List)((j)localObject).TDz;
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            com.tencent.mm.videocomposition.b localb = (com.tencent.mm.videocomposition.b)((Iterator)localObject).next();
            long l = localb.id;
            if ((paramLong != null) && (l == paramLong.longValue()))
            {
              localb.setPlayRate(paramFloat);
              setComposition(this.Uqp.b(com.tencent.mm.timelineedit.a.a.c(localb)));
            }
          }
        }
      }
    }
    hUz();
    paramLong = this.Uaw;
    AppMethodBeat.o(282394);
    return paramLong;
  }
  
  public final Object a(final Long paramLong, long paramLong1, long paramLong2, d<? super j> paramd)
  {
    AppMethodBeat.i(282402);
    paramLong = l.a((kotlin.d.f)bg.kCi(), (m)new d(paramLong1, paramLong2, paramLong, this, null), paramd);
    AppMethodBeat.o(282402);
    return paramLong;
  }
  
  public final j bN(String paramString, long paramLong)
  {
    AppMethodBeat.i(282360);
    Object localObject = this.Uaw;
    if (localObject != null)
    {
      localObject = (List)((j)localObject).TDz;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        int i = 0;
        while (((Iterator)localObject).hasNext())
        {
          ((Iterator)localObject).next();
          if (i < 0) {
            p.kkW();
          }
          u(paramString, paramLong, i);
          i += 1;
        }
      }
    }
    paramString = this.Uaw;
    AppMethodBeat.o(282360);
    return paramString;
  }
  
  public final j hUy()
  {
    AppMethodBeat.i(282303);
    Object localObject = this.Uqp;
    localObject = (j)TimelineEditor.a((kotlin.g.a.a)new TimelineEditor.g((TimelineEditor)localObject), (kotlin.g.a.b)new TimelineEditor.h((TimelineEditor)localObject));
    if (localObject != null)
    {
      e.a locala = com.tencent.mm.plugin.vlog.decoder.e.TXJ;
      ((j)localObject).mediaFactory = e.a.hQm();
    }
    if (localObject != null) {
      ((j)localObject).agDT = ((com.tencent.mm.videocomposition.a.b)new com.tencent.mm.videocomposition.a.a((com.tencent.mm.videocomposition.a.c)new com.tencent.mm.ca.a.a(this.audioSampleRate, this.audioChannelCount)));
    }
    AppMethodBeat.o(282303);
    return localObject;
  }
  
  public final j lR(List<u<String, Long, Long>> paramList)
  {
    AppMethodBeat.i(282339);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramList != null)
    {
      localObject1 = (Iterable)paramList;
      localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
      localObject3 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (u)((Iterator)localObject3).next();
        localObject4 = (String)((u)localObject1).bsC;
        long l1 = ((Number)((u)localObject1).bsD).longValue();
        long l2 = ((Number)((u)localObject1).aiuN).longValue();
        localObject1 = this.Uaw;
        if (localObject1 == null)
        {
          localObject1 = null;
          label115:
          if (localObject1 != null) {
            break label299;
          }
          localObject1 = this.Uqp.iL((String)localObject4, 2);
          if (localObject1 != null) {
            break label237;
          }
          localObject1 = null;
        }
        for (;;)
        {
          ((Collection)localObject2).add(localObject1);
          break;
          localObject1 = (List)((j)localObject1).TDz;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label115;
          }
          Iterator localIterator = ((Iterable)localObject1).iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = localIterator.next();
          } while (!s.p(localObject4, ((com.tencent.mm.videocomposition.b)localObject1).path));
          for (;;)
          {
            localObject1 = (com.tencent.mm.videocomposition.b)localObject1;
            break;
            localObject1 = null;
          }
          label237:
          ((g)localObject1).a(new com.tencent.mm.timelineedit.a.f(l1, l2));
          ((g)localObject1).b(new com.tencent.mm.timelineedit.a.f(0L, ((g)localObject1).getSourceDuration()));
          ((g)localObject1).setVolume(3.0F);
          setComposition(this.Uqp.a((g)localObject1));
          localObject1 = ah.aiuX;
          continue;
          label299:
          ((com.tencent.mm.videocomposition.b)localObject1).setStartTimeMs(l1);
          ((com.tencent.mm.videocomposition.b)localObject1).wA(l2);
          setComposition(this.Uqp.b(com.tencent.mm.timelineedit.a.a.c((com.tencent.mm.videocomposition.b)localObject1)));
          localObject1 = ah.aiuX;
        }
      }
    }
    Object localObject1 = this.Uaw;
    if (localObject1 != null)
    {
      localObject1 = (List)((j)localObject1).TDz;
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.videocomposition.b)((Iterator)localObject2).next();
          if ((((com.tencent.mm.videocomposition.b)localObject3).type == 3) && (n.i((CharSequence)((com.tencent.mm.videocomposition.b)localObject3).path, (CharSequence)"tts")))
          {
            if (paramList == null)
            {
              localObject1 = null;
              label432:
              if (localObject1 == null) {
                setComposition(this.Uqp.c(com.tencent.mm.timelineedit.a.a.c((com.tencent.mm.videocomposition.b)localObject3)));
              }
            }
            else
            {
              localObject4 = ((Iterable)paramList).iterator();
              do
              {
                if (!((Iterator)localObject4).hasNext()) {
                  break;
                }
                localObject1 = ((Iterator)localObject4).next();
              } while (!s.p(((u)localObject1).bsC, ((com.tencent.mm.videocomposition.b)localObject3).path));
            }
            for (;;)
            {
              localObject1 = (u)localObject1;
              break label432;
              break;
              localObject1 = null;
            }
          }
        }
      }
    }
    paramList = this.Uaw;
    AppMethodBeat.o(282339);
    return paramList;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282408);
    super.reset();
    this.Uqp = new TimelineEditor();
    AppMethodBeat.o(282408);
  }
  
  public final void setComposition(j paramj)
  {
    AppMethodBeat.i(282293);
    this.Uaw = paramj;
    paramj = this.Uaw;
    if (paramj != null) {
      paramj.agDT = ((com.tencent.mm.videocomposition.a.b)new com.tencent.mm.videocomposition.a.a((com.tencent.mm.videocomposition.a.c)new com.tencent.mm.ca.a.a(this.audioSampleRate, this.audioChannelCount)));
    }
    paramj = this.Uaw;
    if (paramj != null)
    {
      e.a locala = com.tencent.mm.plugin.vlog.decoder.e.TXJ;
      paramj.mediaFactory = e.a.hQm();
    }
    AppMethodBeat.o(282293);
  }
  
  public final j u(String paramString, long paramLong, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(282352);
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.vfs.y.ZC(paramString))
    {
      localObject1 = com.tencent.mm.vfs.y.n(paramString, false);
      if (localObject1 != null)
      {
        localObject2 = this.Uaw;
        if (localObject2 != null) {
          break label279;
        }
        if (paramInt < i - 1)
        {
          localObject2 = this.Uaw;
          s.checkNotNull(localObject2);
          localObject2 = (com.tencent.mm.videocomposition.b)((List)((j)localObject2).TDz).get(paramInt);
          Object localObject3 = this.Uaw;
          s.checkNotNull(localObject3);
          localObject3 = (com.tencent.mm.videocomposition.b)((List)((j)localObject3).TDz).get(paramInt + 1);
          TimelineEditor localTimelineEditor = this.Uqp;
          s.t(localObject1, "path");
          localObject1 = Long.valueOf(localTimelineEditor.nCreateTransitionEffectPath(localTimelineEditor.nNg, (String)localObject1));
          if (!TimelineEditor.zk(((Number)localObject1).longValue())) {
            break label306;
          }
          label157:
          if (localObject1 == null) {
            break label312;
          }
          localObject1 = new com.tencent.mm.xeffect.effect.y(((Number)localObject1).longValue());
          label179:
          if (localObject1 != null)
          {
            localTimelineEditor = this.Uqp;
            localObject2 = com.tencent.mm.timelineedit.a.a.c((com.tencent.mm.videocomposition.b)localObject2);
            localObject3 = com.tencent.mm.timelineedit.a.a.c((com.tencent.mm.videocomposition.b)localObject3);
            s.checkNotNull(paramString);
            paramString = new h((g)localObject2, (g)localObject3, (com.tencent.mm.xeffect.effect.y)localObject1, paramLong, paramString);
            s.t(paramString, "transitionInfo");
            setComposition((j)TimelineEditor.a((kotlin.g.a.a)new TimelineEditor.q(localTimelineEditor, paramString), (kotlin.g.a.b)new TimelineEditor.r(localTimelineEditor)));
          }
        }
      }
    }
    label279:
    label306:
    label312:
    label453:
    for (;;)
    {
      paramString = this.Uaw;
      AppMethodBeat.o(282352);
      return paramString;
      localObject2 = (List)((j)localObject2).TDz;
      if (localObject2 == null) {
        break;
      }
      i = ((List)localObject2).size();
      break;
      localObject1 = null;
      break label157;
      localObject1 = null;
      break label179;
      paramString = this.Uaw;
      if (paramString == null) {
        i = 0;
      }
      for (;;)
      {
        if (paramInt >= i - 1) {
          break label453;
        }
        paramString = this.Uaw;
        s.checkNotNull(paramString);
        localObject1 = (com.tencent.mm.videocomposition.b)((List)paramString.TDz).get(paramInt + 1);
        paramString = this.Uqp;
        localObject1 = com.tencent.mm.timelineedit.a.a.c((com.tencent.mm.videocomposition.b)localObject1);
        s.t(localObject1, "afterTrack");
        setComposition((j)TimelineEditor.a((kotlin.g.a.a)new TimelineEditor.m(paramString, (g)localObject1), (kotlin.g.a.b)new TimelineEditor.n(paramString)));
        break;
        paramString = (List)paramString.TDz;
        if (paramString == null) {
          i = 0;
        } else {
          i = paramString.size();
        }
      }
    }
  }
  
  public final void u(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(282325);
    if (paramRecordConfigProvider != null)
    {
      paramRecordConfigProvider = paramRecordConfigProvider.oSS;
      if (paramRecordConfigProvider != null)
      {
        paramRecordConfigProvider = paramRecordConfigProvider.getParcelableArrayList("media_list");
        if (paramRecordConfigProvider != null)
        {
          paramRecordConfigProvider = (Iterable)paramRecordConfigProvider;
          int j = 0;
          paramRecordConfigProvider = paramRecordConfigProvider.iterator();
          long l1 = 0L;
          if (paramRecordConfigProvider.hasNext())
          {
            Object localObject1 = paramRecordConfigProvider.next();
            if (j < 0) {
              p.kkW();
            }
            localObject1 = (GalleryItem.MediaItem)localObject1;
            long l2 = System.currentTimeMillis();
            Object localObject2 = this.Uqp;
            String str = ((GalleryItem.MediaItem)localObject1).Gcc;
            s.s(str, "item.mOriginalPath");
            switch (((GalleryItem.MediaItem)localObject1).getType())
            {
            default: 
              i = 0;
              label134:
              localObject1 = ((TimelineEditor)localObject2).iL(str, i);
              Log.i("MicroMsg.TimelineEditorCorePlugin", s.X("createTrack cost:", Long.valueOf(System.currentTimeMillis() - l2)));
              if ((localObject1 == null) || (((g)localObject1).getTrackType() != 1)) {
                break;
              }
            }
            for (int i = 1;; i = 0)
            {
              if (i != 0)
              {
                localObject2 = new com.tencent.mm.videocomposition.b(((g)localObject1).getPath(), 1);
                ((g)localObject1).a(new com.tencent.mm.timelineedit.a.e(((com.tencent.mm.videocomposition.b)localObject2).UaC, ((com.tencent.mm.videocomposition.b)localObject2).UaD));
              }
              l2 = l1;
              if (localObject1 != null)
              {
                ((g)localObject1).a(new com.tencent.mm.timelineedit.a.f(l1, ((g)localObject1).getSourceDuration()));
                ((g)localObject1).b(new com.tencent.mm.timelineedit.a.f(0L, ((g)localObject1).getSourceDuration()));
                ((g)localObject1).azw(1);
                ((g)localObject1).setVolume(1.0F);
                Log.i("MicroMsg.TimelineEditorCorePlugin", "add track index:" + j + " info:" + localObject1);
                l1 = System.currentTimeMillis();
                setComposition(this.Uqp.a((g)localObject1));
                Log.i("MicroMsg.TimelineEditorCorePlugin", s.X("addTrack cost:", Long.valueOf(System.currentTimeMillis() - l1)));
                l2 = ((g)localObject1).jeE().endTimeMs;
              }
              j += 1;
              l1 = l2;
              break;
              i = 1;
              break label134;
              i = 3;
              break label134;
            }
          }
        }
      }
    }
    hUz();
    AppMethodBeat.o(282325);
  }
  
  public final j wQ(long paramLong)
  {
    AppMethodBeat.i(282381);
    long l = 0L;
    Object localObject = this.Uaw;
    if (localObject != null)
    {
      localObject = (List)((j)localObject).TDz;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.videocomposition.b localb = (com.tencent.mm.videocomposition.b)((Iterator)localObject).next();
          if (l >= paramLong)
          {
            setComposition(this.Uqp.c(com.tencent.mm.timelineedit.a.a.c(localb)));
          }
          else
          {
            if (localb.endTimeMs - localb.startTimeMs + l > paramLong)
            {
              localb.setStartTimeMs(l);
              localb.wA(paramLong);
              localb.wB(localb.TDw);
              localb.wC(((float)(localb.endTimeMs - localb.startTimeMs) * localb.sAn + (float)localb.TDw));
              setComposition(this.Uqp.b(com.tencent.mm.timelineedit.a.a.c(localb)));
            }
            l = localb.endTimeMs - localb.startTimeMs + l;
          }
        }
      }
    }
    localObject = this.Uaw;
    AppMethodBeat.o(282381);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCorePlugin$CompositionUpdateCallback;", "", "update", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void c(j paramj);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends k
    implements m<aq, d<? super j>, Object>
  {
    int label;
    
    public c(int paramInt, b paramb, long paramLong1, long paramLong2, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(282232);
      paramObject = (d)new c(this.afA, this.Uqr, this.Mfw, this.Uqs, paramd);
      AppMethodBeat.o(282232);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(282224);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      int j;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(282224);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        j = this.afA;
        paramObject = b.a(this.Uqr);
        if (paramObject == null) {
          i = 0;
        }
        break;
      }
      while (j < i)
      {
        paramObject = b.a(this.Uqr);
        s.checkNotNull(paramObject);
        long l1 = ((com.tencent.mm.videocomposition.b)((List)paramObject.TDz).get(this.afA)).id;
        paramObject = this.Uqr;
        Long localLong = kotlin.d.b.a.b.BF(l1);
        l1 = this.Mfw;
        long l2 = this.Uqs;
        d locald = (d)this;
        this.label = 1;
        if (paramObject.a(localLong, l1, l2, locald) == locala)
        {
          AppMethodBeat.o(282224);
          return locala;
          paramObject = (List)paramObject.TDz;
          if (paramObject == null)
          {
            i = 0;
          }
          else
          {
            i = paramObject.size();
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
        }
      }
      paramObject = this.Uqr.Uaw;
      AppMethodBeat.o(282224);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, d<? super j>, Object>
  {
    int label;
    
    d(long paramLong1, long paramLong2, Long paramLong, b paramb, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(282237);
      paramObject = (d)new d(this.Mfw, paramLong, this.Uqt, this.Uqr, paramd);
      AppMethodBeat.o(282237);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(282229);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(282229);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.TimelineEditorCorePlugin", "updateTrackDuration startMs:" + this.Mfw + " endMs:" + paramLong);
        Object localObject2 = this.Uqt;
        if (localObject2 != null)
        {
          paramObject = this.Uqr;
          localObject1 = this.Uqt;
          long l1 = this.Mfw;
          long l2 = paramLong;
          ((Number)localObject2).longValue();
          localObject2 = b.a(paramObject);
          if (localObject2 != null)
          {
            localObject2 = (List)((j)localObject2).TDz;
            if (localObject2 != null)
            {
              localObject2 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                com.tencent.mm.videocomposition.b localb = (com.tencent.mm.videocomposition.b)((Iterator)localObject2).next();
                long l3 = localb.id;
                if ((localObject1 != null) && (l3 == ((Long)localObject1).longValue()))
                {
                  localb.wB(l1);
                  localb.wC(l2);
                  b.a(paramObject, b.c(paramObject).b(com.tencent.mm.timelineedit.a.a.c(localb)));
                }
              }
            }
          }
        }
        paramObject = (kotlin.d.f)bg.kCh();
        Object localObject1 = (m)new k(this.Uqr, null)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(282226);
            paramAnonymousObject = (d)new 1(this.Uqr, paramAnonymousd);
            AppMethodBeat.o(282226);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(282222);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(282222);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            b.b(this.Uqr);
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(282222);
            return paramAnonymousObject;
          }
        };
        localObject2 = (d)this;
        this.label = 1;
        if (l.a(paramObject, (m)localObject1, (d)localObject2) == locala)
        {
          AppMethodBeat.o(282229);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = this.Uqr.Uaw;
      AppMethodBeat.o(282229);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.b
 * JD-Core Version:    0.7.0.1
 */