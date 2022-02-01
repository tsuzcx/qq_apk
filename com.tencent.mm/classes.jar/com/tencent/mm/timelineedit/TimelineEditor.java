package com.tencent.mm.timelineedit;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.timelineedit.a.c;
import com.tencent.mm.timelineedit.a.g;
import com.tencent.mm.timelineedit.a.h;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.EffectManager.a;
import com.tencent.mm.xeffect.effect.ac;
import com.tencent.mm.xeffect.effect.af;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/timelineedit/TimelineEditor;", "", "()V", "effectList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "Lkotlin/collections/HashMap;", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "effectManagerPtr", "nPtr", "addEffectToTimeline", "", "effect", "bindTrack", "", "addEffectToTimelineBindToTrack", "trackId", "addTrack", "Lcom/tencent/mm/videocomposition/VideoComposition;", "track", "Lcom/tencent/mm/timelineedit/model/Track;", "addWrapDurationAudioTrack", "path", "", "checkEffectPtrValid", "ptr", "clearTransition", "create", "canvasRect", "Landroid/graphics/Rect;", "validRect", "config", "Lcom/tencent/mm/timelineedit/model/EditorConfig;", "createDecodeStickerEffect", "Lcom/tencent/mm/xeffect/effect/StickerEffect;", "asset", "Landroid/content/res/AssetManager;", "assetPath", "bytes", "", "createGlobalAnimationEffect", "Lcom/tencent/mm/xeffect/effect/PagGlobalAnimateEffect;", "createPAGStickerEffect", "Lcom/tencent/mm/xeffect/effect/PagStickerEffect;", "createTextEffect", "Lcom/tencent/mm/xeffect/effect/PagTextEffect;", "createTrack", "type", "", "createTransitionEffect", "Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;", "createVideoTemplateEffect", "Lcom/tencent/mm/xeffect/effect/PagTemplateEffect;", "destroy", "getEffectManager", "getNoTransitionComposition", "getSingleFullRangeComposition", "nAddEffectToTimeline", "effectPtr", "nAddEffectToTimelineBindToTrack", "nAddTrack", "trackBytes", "nAddWrapDurationAudioTrack", "nClearTransition", "nCreate", "canvasRectBytes", "validRectBytes", "editorConfig", "nCreateDecodeStickerEffectAsset", "nCreateDecodeStickerEffectBytes", "length", "nCreateDecodeStickerEffectPath", "nCreateGlobalAnimationEffectAsset", "nCreateGlobalAnimationEffectBytes", "nCreateGlobalAnimationEffectPath", "nCreatePAGStickerEffectAsset", "nCreatePAGStickerEffectBytes", "nCreatePAGStickerEffectPath", "nCreateTextEffectAsset", "nCreateTextEffectBytes", "nCreateTextEffectPath", "nCreateTrack", "nCreateTransitionEffectAsset", "nCreateTransitionEffectBytes", "nCreateTransitionEffectPath", "nCreateVideoTemplateEffectAsset", "nCreateVideoTemplateEffectBytes", "nCreateVideoTemplateEffectPath", "nDestroy", "nGetEffectManager", "nGetNoTransitionComposition", "nGetSingleFullRangeComposition", "nRemoveEffect", "nRemoveTrack", "nRemoveTransition", "afterTrack", "nRestore", "replace", "nSave", "nSetNativeLog", "nSetTransition", "beforeTrack", "transitionEffect", "durationMs", "nTouchMotionEvent", "actionA", "pointAX", "", "pointAY", "keyA", "actionB", "pointBX", "pointBY", "keyB", "nUpdateCompositionDuration", "startMs", "endMs", "nUpdateConfig", "nUpdateDisplayTime", "displayTime", "nUpdateTrack", "nUpdateValidRect", "onTouchEvent", "Lkotlin/Pair;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "touchEvent", "Landroid/view/MotionEvent;", "removeEffect", "removeTrack", "removeTransition", "restore", "returnValueOrNull", "R", "T", "call", "Lkotlin/Function0;", "ret", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "save", "setNativeLog", "setTransition", "transitionInfo", "Lcom/tencent/mm/timelineedit/model/TrackTransitionInfo;", "updateCompositionDuration", "updateConfig", "updateDisplayTime", "updateTrack", "Companion", "timelinelib_release"})
public final class TimelineEditor
{
  private static volatile boolean VLp;
  public static final Companion VLq;
  private EffectManager ANo;
  public long NmO;
  private long VLn;
  public HashMap<Long, af> VLo;
  
  static
  {
    AppMethodBeat.i(261993);
    VLq = new Companion((byte)0);
    System.loadLibrary("xlabeffect");
    System.loadLibrary("timeline-editor");
    AppMethodBeat.o(261993);
  }
  
  public TimelineEditor()
  {
    AppMethodBeat.i(261992);
    this.NmO = -1L;
    this.VLn = -1L;
    this.VLo = new HashMap();
    AppMethodBeat.o(261992);
  }
  
  public static boolean Vc(long paramLong)
  {
    return paramLong > 0L;
  }
  
  public static <T, R> R a(a<? extends T> parama, b<? super T, ? extends R> paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(261955);
    parama = parama.invoke();
    if (parama != null) {}
    try
    {
      parama = paramb.invoke(parama);
      AppMethodBeat.o(261955);
      return parama;
      AppMethodBeat.o(261955);
      return null;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        parama = localObject;
      }
    }
  }
  
  private final native long nAddEffectToTimeline(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private final native long nAddEffectToTimelineBindToTrack(long paramLong1, long paramLong2, long paramLong3);
  
  private final native byte[] nAddTrack(long paramLong, byte[] paramArrayOfByte);
  
  private final native byte[] nAddWrapDurationAudioTrack(long paramLong, String paramString);
  
  private final native byte[] nClearTransition(long paramLong);
  
  private final native long nCreateDecodeStickerEffectAsset(long paramLong, AssetManager paramAssetManager, String paramString);
  
  private final native long nCreateDecodeStickerEffectBytes(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
  
  private final native long nCreateDecodeStickerEffectPath(long paramLong, String paramString);
  
  private final native long nCreateGlobalAnimationEffectAsset(long paramLong, AssetManager paramAssetManager, String paramString);
  
  private final native long nCreateGlobalAnimationEffectBytes(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
  
  private final native long nCreateGlobalAnimationEffectPath(long paramLong, String paramString);
  
  private final native long nCreatePAGStickerEffectAsset(long paramLong, AssetManager paramAssetManager, String paramString);
  
  private final native long nCreatePAGStickerEffectBytes(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
  
  private final native long nCreatePAGStickerEffectPath(long paramLong, String paramString);
  
  private final native long nCreateTextEffectAsset(long paramLong, AssetManager paramAssetManager, String paramString);
  
  private final native long nCreateTextEffectBytes(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
  
  private final native long nCreateTextEffectPath(long paramLong, String paramString);
  
  private final native byte[] nCreateTrack(long paramLong, String paramString, int paramInt);
  
  private final native long nCreateTransitionEffectAsset(long paramLong, AssetManager paramAssetManager, String paramString);
  
  private final native long nCreateTransitionEffectBytes(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
  
  private final native long nCreateVideoTemplateEffectAsset(long paramLong, AssetManager paramAssetManager, String paramString);
  
  private final native long nCreateVideoTemplateEffectBytes(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
  
  private final native long nCreateVideoTemplateEffectPath(long paramLong, String paramString);
  
  private final native boolean nDestroy(long paramLong);
  
  private final native long nGetEffectManager(long paramLong);
  
  private final native byte[] nGetNoTransitionComposition(long paramLong);
  
  private final native byte[] nGetSingleFullRangeComposition(long paramLong1, long paramLong2);
  
  private final native boolean nRemoveEffect(long paramLong1, long paramLong2);
  
  private final native byte[] nRemoveTrack(long paramLong, byte[] paramArrayOfByte);
  
  private final native byte[] nRemoveTransition(long paramLong, byte[] paramArrayOfByte);
  
  private final native byte[] nRestore(long paramLong, boolean paramBoolean);
  
  private final native void nSetNativeLog(long paramLong);
  
  private final native byte[] nSetTransition(long paramLong1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong2, long paramLong3);
  
  private final native byte[] nUpdateCompositionDuration(long paramLong1, long paramLong2, long paramLong3);
  
  private final native byte[] nUpdateConfig(long paramLong, byte[] paramArrayOfByte);
  
  private final native void nUpdateDisplayTime(long paramLong1, long paramLong2);
  
  private final native byte[] nUpdateTrack(long paramLong, byte[] paramArrayOfByte);
  
  private final native byte[] nUpdateValidRect(long paramLong, byte[] paramArrayOfByte);
  
  public final j a(final g paramg)
  {
    AppMethodBeat.i(261958);
    p.k(paramg, "track");
    paramg = (j)a((a)new a(this, paramg), (b)new b(this));
    AppMethodBeat.o(261958);
    return paramg;
  }
  
  public final void a(af paramaf)
  {
    AppMethodBeat.i(261966);
    p.k(paramaf, "effect");
    long l = nAddEffectToTimeline(this.NmO, paramaf.ptr, true);
    if (l > 0L) {
      synchronized (this.VLo)
      {
        ((Map)this.VLo).put(Long.valueOf(l), paramaf);
        paramaf = x.aazN;
        AppMethodBeat.o(261966);
        return;
      }
    }
    AppMethodBeat.o(261966);
  }
  
  public final void a(af paramaf, long paramLong)
  {
    AppMethodBeat.i(261967);
    p.k(paramaf, "effect");
    paramLong = nAddEffectToTimelineBindToTrack(this.NmO, paramaf.ptr, paramLong);
    if (paramLong > 0L) {
      synchronized (this.VLo)
      {
        ((Map)this.VLo).put(Long.valueOf(paramLong), paramaf);
        paramaf = x.aazN;
        AppMethodBeat.o(261967);
        return;
      }
    }
    AppMethodBeat.o(261967);
  }
  
  public final j b(final g paramg)
  {
    AppMethodBeat.i(261960);
    p.k(paramg, "track");
    paramg = (j)a((a)new u(this, paramg), (b)new v(this));
    AppMethodBeat.o(261960);
    return paramg;
  }
  
  public final ac byc(String paramString)
  {
    AppMethodBeat.i(261965);
    p.k(paramString, "path");
    paramString = Long.valueOf(nCreateDecodeStickerEffectPath(this.NmO, paramString));
    if (Vc(((Number)paramString).longValue())) {}
    while (paramString != null)
    {
      paramString = new ac(((Number)paramString).longValue());
      AppMethodBeat.o(261965);
      return paramString;
      paramString = null;
    }
    AppMethodBeat.o(261965);
    return null;
  }
  
  public final j c(final g paramg)
  {
    AppMethodBeat.i(261962);
    p.k(paramg, "track");
    paramg = (j)a((a)new k(this, paramg), (b)new l(this));
    AppMethodBeat.o(261962);
    return paramg;
  }
  
  public final EffectManager getEffectManager()
  {
    AppMethodBeat.i(261968);
    if (this.VLn == -1L)
    {
      this.VLn = nGetEffectManager(this.NmO);
      localObject = EffectManager.YZy;
      this.ANo = EffectManager.a.WK(this.VLn);
    }
    Object localObject = this.ANo;
    AppMethodBeat.o(261968);
    return localObject;
  }
  
  public final g hE(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(261957);
    p.k(paramString, "path");
    paramString = (g)a((a)new e(this, paramString, paramInt), (b)f.VLt);
    AppMethodBeat.o(261957);
    return paramString;
  }
  
  public final native long nCreate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public final native long nCreateTransitionEffectPath(long paramLong, String paramString);
  
  public final native boolean nSave(long paramLong);
  
  public final native byte[] nTouchMotionEvent(long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, long paramLong2, int paramInt2, float paramFloat3, float paramFloat4, long paramLong3);
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/timelineedit/TimelineEditor$Companion;", "", "()V", "TAG", "", "jniInit", "", "checkInitJNI", "", "timelinelib_release"})
  public static final class Companion
  {
    private final void checkInitJNI()
    {
      AppMethodBeat.i(261837);
      if (!TimelineEditor.hCu())
      {
        new EffectManager();
        TimelineEditor.hCv();
      }
      AppMethodBeat.o(261837);
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<byte[]>
  {
    a(TimelineEditor paramTimelineEditor, g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"})
  static final class b
    extends q
    implements b<byte[], j>
  {
    b(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements a<byte[]>
  {
    public c(TimelineEditor paramTimelineEditor, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"})
  public static final class d
    extends q
    implements b<byte[], j>
  {
    public d(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<byte[]>
  {
    e(TimelineEditor paramTimelineEditor, String paramString, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/timelineedit/model/Track;", "it", "", "invoke"})
  static final class f
    extends q
    implements b<byte[], g>
  {
    public static final f VLt;
    
    static
    {
      AppMethodBeat.i(261872);
      VLt = new f();
      AppMethodBeat.o(261872);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class g
    extends q
    implements a<byte[]>
  {
    public g(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"})
  public static final class h
    extends q
    implements b<byte[], j>
  {
    public h(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class i
    extends q
    implements a<byte[]>
  {
    public i(TimelineEditor paramTimelineEditor, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"})
  public static final class j
    extends q
    implements b<byte[], j>
  {
    public j(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements a<byte[]>
  {
    k(TimelineEditor paramTimelineEditor, g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"})
  static final class l
    extends q
    implements b<byte[], j>
  {
    l(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class m
    extends q
    implements a<byte[]>
  {
    public m(TimelineEditor paramTimelineEditor, g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"})
  public static final class n
    extends q
    implements b<byte[], j>
  {
    public n(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class o
    extends q
    implements a<byte[]>
  {
    public o(TimelineEditor paramTimelineEditor, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"})
  public static final class p
    extends q
    implements b<byte[], j>
  {
    public p(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class q
    extends q
    implements a<byte[]>
  {
    public q(TimelineEditor paramTimelineEditor, h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"})
  public static final class r
    extends q
    implements b<byte[], j>
  {
    public r(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class s
    extends q
    implements a<byte[]>
  {
    public s(TimelineEditor paramTimelineEditor, c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"})
  public static final class t
    extends q
    implements b<byte[], j>
  {
    public t(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class u
    extends q
    implements a<byte[]>
  {
    u(TimelineEditor paramTimelineEditor, g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"})
  static final class v
    extends q
    implements b<byte[], j>
  {
    v(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.timelineedit.TimelineEditor
 * JD-Core Version:    0.7.0.1
 */