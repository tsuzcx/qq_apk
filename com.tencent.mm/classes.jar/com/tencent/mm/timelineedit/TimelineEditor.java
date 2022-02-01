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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/timelineedit/TimelineEditor;", "", "()V", "effectList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "Lkotlin/collections/HashMap;", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "effectManagerPtr", "nPtr", "addEffectToTimeline", "", "effect", "bindTrack", "", "addEffectToTimelineBindToTrack", "trackId", "addTrack", "Lcom/tencent/mm/videocomposition/VideoComposition;", "track", "Lcom/tencent/mm/timelineedit/model/Track;", "addWrapDurationAudioTrack", "path", "", "checkEffectPtrValid", "ptr", "clearTransition", "create", "canvasRect", "Landroid/graphics/Rect;", "validRect", "config", "Lcom/tencent/mm/timelineedit/model/EditorConfig;", "createDecodeStickerEffect", "Lcom/tencent/mm/xeffect/effect/StickerEffect;", "asset", "Landroid/content/res/AssetManager;", "assetPath", "bytes", "", "createGlobalAnimationEffect", "Lcom/tencent/mm/xeffect/effect/PagGlobalAnimateEffect;", "createPAGStickerEffect", "Lcom/tencent/mm/xeffect/effect/PagStickerEffect;", "createTextEffect", "Lcom/tencent/mm/xeffect/effect/PagTextEffect;", "createTrack", "type", "", "createTransitionEffect", "Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;", "createVideoTemplateEffect", "Lcom/tencent/mm/xeffect/effect/PagTemplateEffect;", "destroy", "getEffectManager", "getNoTransitionComposition", "getSingleFullRangeComposition", "nAddEffectToTimeline", "effectPtr", "nAddEffectToTimelineBindToTrack", "nAddTrack", "trackBytes", "nAddWrapDurationAudioTrack", "nClearTransition", "nCreate", "canvasRectBytes", "validRectBytes", "editorConfig", "nCreateDecodeStickerEffectAsset", "nCreateDecodeStickerEffectBytes", "length", "nCreateDecodeStickerEffectPath", "nCreateGlobalAnimationEffectAsset", "nCreateGlobalAnimationEffectBytes", "nCreateGlobalAnimationEffectPath", "nCreatePAGStickerEffectAsset", "nCreatePAGStickerEffectBytes", "nCreatePAGStickerEffectPath", "nCreateTextEffectAsset", "nCreateTextEffectBytes", "nCreateTextEffectPath", "nCreateTrack", "nCreateTransitionEffectAsset", "nCreateTransitionEffectBytes", "nCreateTransitionEffectPath", "nCreateVideoTemplateEffectAsset", "nCreateVideoTemplateEffectBytes", "nCreateVideoTemplateEffectPath", "nDestroy", "nGetEffectManager", "nGetNoTransitionComposition", "nGetSingleFullRangeComposition", "nRemoveEffect", "nRemoveTrack", "nRemoveTransition", "afterTrack", "nRestore", "replace", "nSave", "nSetNativeLog", "nSetTransition", "beforeTrack", "transitionEffect", "durationMs", "nTouchMotionEvent", "actionA", "pointAX", "", "pointAY", "keyA", "actionB", "pointBX", "pointBY", "keyB", "nUpdateCompositionDuration", "startMs", "endMs", "nUpdateConfig", "nUpdateDisplayTime", "displayTime", "nUpdateTrack", "nUpdateValidRect", "onTouchEvent", "Lkotlin/Pair;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "touchEvent", "Landroid/view/MotionEvent;", "removeEffect", "removeTrack", "removeTransition", "restore", "returnValueOrNull", "R", "T", "call", "Lkotlin/Function0;", "ret", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "save", "setNativeLog", "setTransition", "transitionInfo", "Lcom/tencent/mm/timelineedit/model/TrackTransitionInfo;", "updateCompositionDuration", "updateConfig", "updateDisplayTime", "updateTrack", "Companion", "timelinelib_release"}, k=1, mv={1, 1, 15})
public final class TimelineEditor
{
  private static volatile boolean adpt;
  public static final Companion adpu;
  private EffectManager GpO;
  private long adpr;
  public HashMap<Long, af> adps;
  public long nNg;
  
  static
  {
    AppMethodBeat.i(232238);
    adpu = new Companion((byte)0);
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("xlabeffect");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/timelineedit/TimelineEditor", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/timelineedit/TimelineEditor", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    locala = new com.tencent.mm.hellhoundlib.b.a().cG("timeline-editor");
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/timelineedit/TimelineEditor", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/timelineedit/TimelineEditor", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(232238);
  }
  
  public TimelineEditor()
  {
    AppMethodBeat.i(232228);
    this.nNg = -1L;
    this.adpr = -1L;
    this.adps = new HashMap();
    AppMethodBeat.o(232228);
  }
  
  public static <T, R> R a(kotlin.g.a.a<? extends T> parama, b<? super T, ? extends R> paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(232047);
    parama = parama.invoke();
    if (parama != null) {}
    try
    {
      parama = paramb.invoke(parama);
      AppMethodBeat.o(232047);
      return parama;
      AppMethodBeat.o(232047);
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
  
  public static boolean zk(long paramLong)
  {
    return paramLong > 0L;
  }
  
  public final j a(final g paramg)
  {
    AppMethodBeat.i(232385);
    s.t(paramg, "track");
    paramg = (j)a((kotlin.g.a.a)new a(this, paramg), (b)new b(this));
    AppMethodBeat.o(232385);
    return paramg;
  }
  
  public final void a(af paramaf)
  {
    AppMethodBeat.i(232413);
    s.t(paramaf, "effect");
    long l = nAddEffectToTimeline(this.nNg, paramaf.ptr, true);
    if (l > 0L) {
      synchronized (this.adps)
      {
        ((Map)this.adps).put(Long.valueOf(l), paramaf);
        paramaf = ah.aiuX;
        AppMethodBeat.o(232413);
        return;
      }
    }
    AppMethodBeat.o(232413);
  }
  
  public final void a(af paramaf, long paramLong)
  {
    AppMethodBeat.i(232423);
    s.t(paramaf, "effect");
    paramLong = nAddEffectToTimelineBindToTrack(this.nNg, paramaf.ptr, paramLong);
    if (paramLong > 0L) {
      synchronized (this.adps)
      {
        ((Map)this.adps).put(Long.valueOf(paramLong), paramaf);
        paramaf = ah.aiuX;
        AppMethodBeat.o(232423);
        return;
      }
    }
    AppMethodBeat.o(232423);
  }
  
  public final j b(final g paramg)
  {
    AppMethodBeat.i(232391);
    s.t(paramg, "track");
    paramg = (j)a((kotlin.g.a.a)new u(this, paramg), (b)new v(this));
    AppMethodBeat.o(232391);
    return paramg;
  }
  
  public final ac bzx(String paramString)
  {
    AppMethodBeat.i(232404);
    s.t(paramString, "path");
    paramString = Long.valueOf(nCreateDecodeStickerEffectPath(this.nNg, paramString));
    if (zk(((Number)paramString).longValue())) {}
    while (paramString != null)
    {
      paramString = new ac(((Number)paramString).longValue());
      AppMethodBeat.o(232404);
      return paramString;
      paramString = null;
    }
    AppMethodBeat.o(232404);
    return null;
  }
  
  public final j c(final g paramg)
  {
    AppMethodBeat.i(232397);
    s.t(paramg, "track");
    paramg = (j)a((kotlin.g.a.a)new k(this, paramg), (b)new l(this));
    AppMethodBeat.o(232397);
    return paramg;
  }
  
  public final EffectManager getEffectManager()
  {
    AppMethodBeat.i(232433);
    if (this.adpr == -1L)
    {
      this.adpr = nGetEffectManager(this.nNg);
      localObject = EffectManager.agXK;
      this.GpO = EffectManager.a.AV(this.adpr);
    }
    Object localObject = this.GpO;
    AppMethodBeat.o(232433);
    return localObject;
  }
  
  public final g iL(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(232374);
    s.t(paramString, "path");
    paramString = (g)a((kotlin.g.a.a)new e(this, paramString, paramInt), (b)f.adpx);
    AppMethodBeat.o(232374);
    return paramString;
  }
  
  public final native long nCreate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public final native long nCreateTransitionEffectPath(long paramLong, String paramString);
  
  public final native boolean nSave(long paramLong);
  
  public final native byte[] nTouchMotionEvent(long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, long paramLong2, int paramInt2, float paramFloat3, float paramFloat4, long paramLong3);
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/timelineedit/TimelineEditor$Companion;", "", "()V", "TAG", "", "jniInit", "", "checkInitJNI", "", "timelinelib_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    private final void checkInitJNI()
    {
      AppMethodBeat.i(232036);
      if (!TimelineEditor.jeA())
      {
        new EffectManager();
        TimelineEditor.jeB();
      }
      AppMethodBeat.o(232036);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class a
    extends u
    implements kotlin.g.a.a<byte[]>
  {
    a(TimelineEditor paramTimelineEditor, g paramg)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class b
    extends u
    implements b<byte[], j>
  {
    b(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class c
    extends u
    implements kotlin.g.a.a<byte[]>
  {
    public c(TimelineEditor paramTimelineEditor, String paramString)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class d
    extends u
    implements b<byte[], j>
  {
    public d(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class e
    extends u
    implements kotlin.g.a.a<byte[]>
  {
    e(TimelineEditor paramTimelineEditor, String paramString, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/timelineedit/model/Track;", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class f
    extends u
    implements b<byte[], g>
  {
    public static final f adpx;
    
    static
    {
      AppMethodBeat.i(232054);
      adpx = new f();
      AppMethodBeat.o(232054);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class g
    extends u
    implements kotlin.g.a.a<byte[]>
  {
    public g(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class h
    extends u
    implements b<byte[], j>
  {
    public h(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class i
    extends u
    implements kotlin.g.a.a<byte[]>
  {
    public i(TimelineEditor paramTimelineEditor, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class j
    extends u
    implements b<byte[], j>
  {
    public j(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class k
    extends u
    implements kotlin.g.a.a<byte[]>
  {
    k(TimelineEditor paramTimelineEditor, g paramg)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class l
    extends u
    implements b<byte[], j>
  {
    l(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class m
    extends u
    implements kotlin.g.a.a<byte[]>
  {
    public m(TimelineEditor paramTimelineEditor, g paramg)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class n
    extends u
    implements b<byte[], j>
  {
    public n(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class o
    extends u
    implements kotlin.g.a.a<byte[]>
  {
    public o(TimelineEditor paramTimelineEditor, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class p
    extends u
    implements b<byte[], j>
  {
    public p(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class q
    extends u
    implements kotlin.g.a.a<byte[]>
  {
    public q(TimelineEditor paramTimelineEditor, h paramh)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class r
    extends u
    implements b<byte[], j>
  {
    public r(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class s
    extends u
    implements kotlin.g.a.a<byte[]>
  {
    public s(TimelineEditor paramTimelineEditor, c paramc)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class t
    extends u
    implements b<byte[], j>
  {
    public t(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class u
    extends u
    implements kotlin.g.a.a<byte[]>
  {
    u(TimelineEditor paramTimelineEditor, g paramg)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/videocomposition/VideoComposition;", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class v
    extends u
    implements b<byte[], j>
  {
    v(TimelineEditor paramTimelineEditor)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.timelineedit.TimelineEditor
 * JD-Core Version:    0.7.0.1
 */