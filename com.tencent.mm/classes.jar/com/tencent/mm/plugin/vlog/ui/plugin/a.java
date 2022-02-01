package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView.b;
import com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackRecyclerView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cutDuration", "", "getCutDuration", "()J", "externalStatusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getExternalStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "externalStatusIcon$delegate", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "getLayout", "()Landroid/view/ViewGroup;", "maxTrackEnd", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1;", "panelRoot", "getPanelRoot", "panelRoot$delegate", "playStatusIcon", "getPlayStatusIcon", "playStatusIcon$delegate", "progressIndicator", "Landroid/view/View;", "getProgressIndicator", "()Landroid/view/View;", "progressIndicator$delegate", "restorer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer;", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "sourceDuration", "getSourceDuration", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "trackCropView$delegate", "cache", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "composition", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "onUpdate", "seekTo", "seekToOriginPosition", "onVideoPause", "onVideoPlay", "restore", "restoreTrackTime", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "setVisibility", "visibility", "", "updateHint", "Companion", "plugin-vlog_release"})
public final class a
  implements t, e.c, e.d, v.a
{
  public static final a.a GGv;
  private e.e GDw;
  private final f GGj;
  private final f GGk;
  private final f GGl;
  private final f GGm;
  private final f GGn;
  private final f GGo;
  private final f GGp;
  private final f GGq;
  private long GGr;
  private boolean GGs;
  private final b GGt;
  private final j GGu;
  private boolean gKM;
  final ViewGroup wgq;
  final d wgr;
  private final EditorPanelHolder wji;
  
  static
  {
    AppMethodBeat.i(191165);
    GGv = new a.a((byte)0);
    AppMethodBeat.o(191165);
  }
  
  public a(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191164);
    this.wgq = paramViewGroup;
    this.wgr = paramd;
    paramViewGroup = this.wgq.getContext();
    p.g(paramViewGroup, "layout.context");
    paramViewGroup = new EditorPanelHolder(paramViewGroup);
    this.wgq.addView((View)paramViewGroup);
    paramViewGroup.setVisibility(8);
    this.wji = paramViewGroup;
    this.GGj = g.ah((kotlin.g.a.a)new k(this));
    this.GGk = g.ah((kotlin.g.a.a)new n(this));
    this.GGl = g.ah((kotlin.g.a.a)new h(this));
    this.GGm = g.ah((kotlin.g.a.a)new b(this));
    this.GGn = g.ah((kotlin.g.a.a)new i(this));
    this.GGo = g.ah((kotlin.g.a.a)new m(this));
    this.GGp = g.ah((kotlin.g.a.a)new g(this));
    this.GGq = g.ah((kotlin.g.a.a)new l(this));
    this.GGt = new b();
    this.GGu = new j(this);
    AppMethodBeat.o(191164);
  }
  
  private final void aTL()
  {
    AppMethodBeat.i(191153);
    if (this.gKM)
    {
      AppMethodBeat.o(191153);
      return;
    }
    this.gKM = true;
    this.wji.setCloseTouchOutside(false);
    fCP().setCallback((MultiTrackCropView.b)this.GGu);
    ((ImageView)this.GGm.getValue()).setOnClickListener((View.OnClickListener)new c(this));
    ((ImageView)this.GGn.getValue()).setOnClickListener((View.OnClickListener)new d(this));
    fCQ().setOnClickListener((View.OnClickListener)new e(this));
    this.wji.setOnVisibleChangeCallback((kotlin.g.a.b)new f(this));
    AppMethodBeat.o(191153);
  }
  
  private final TextView dpN()
  {
    AppMethodBeat.i(191151);
    TextView localTextView = (TextView)this.GGl.getValue();
    AppMethodBeat.o(191151);
    return localTextView;
  }
  
  private final void eTf()
  {
    AppMethodBeat.i(191159);
    long l1 = kotlin.h.a.L((float)fCP().getCutDuration() / 1000.0F);
    long l2 = kotlin.h.a.L((float)Math.min(this.GGr, fCP().getCutDuration()) / 1000.0F);
    TextView localTextView = dpN();
    p.g(localTextView, "hintText");
    localTextView.setText((CharSequence)this.wji.getContext().getString(2131767122, new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    localTextView = dpN();
    p.g(localTextView, "hintText");
    if (fCP().getSourceDuration() > this.GGr) {}
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(191159);
      return;
    }
  }
  
  private final MultiTrackCropView fCP()
  {
    AppMethodBeat.i(191150);
    MultiTrackCropView localMultiTrackCropView = (MultiTrackCropView)this.GGk.getValue();
    AppMethodBeat.o(191150);
    return localMultiTrackCropView;
  }
  
  private final WeImageView fCQ()
  {
    AppMethodBeat.i(191152);
    WeImageView localWeImageView = (WeImageView)this.GGq.getValue();
    AppMethodBeat.o(191152);
    return localWeImageView;
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(191160);
    if ((paramac != null) && (paramLong >= 0L))
    {
      MultiTrackCropView localMultiTrackCropView = fCP();
      p.h(paramac, "composition");
      if (localMultiTrackCropView.GPB)
      {
        localMultiTrackCropView.GPB = false;
        Log.d("MicroMsg.MultiTrackCropView", "onUpdateComposition, seekTo: ".concat(String.valueOf(paramLong)));
        localMultiTrackCropView.GPC = true;
        localMultiTrackCropView.GPD = paramLong;
        localMultiTrackCropView.GJb = true;
        int i = localMultiTrackCropView.GPz;
        int j = (int)((float)((paramLong - localMultiTrackCropView.wbl) * localMultiTrackCropView.GJa) * 1.0F / (float)(localMultiTrackCropView.GhH - localMultiTrackCropView.wbl));
        paramac = localMultiTrackCropView.GPx;
        if (paramac == null) {
          p.btv("recyclerView");
        }
        paramac.smoothScrollBy(i + j - localMultiTrackCropView.FVU, 0);
      }
    }
    AppMethodBeat.o(191160);
  }
  
  public final void a(e.e parame)
  {
    this.GDw = parame;
  }
  
  public final void aSs() {}
  
  public final void b(ac paramac, long paramLong)
  {
    AppMethodBeat.i(191158);
    p.h(paramac, "composition");
    this.GGs = false;
    aTL();
    this.GGr = paramLong;
    this.wji.setShow(true);
    fCP().setTrack(paramac);
    eTf();
    AppMethodBeat.o(191158);
  }
  
  public final ac c(ac paramac)
  {
    AppMethodBeat.i(191156);
    p.h(paramac, "composition");
    paramac = this.GGt.c(paramac);
    AppMethodBeat.o(191156);
    return paramac;
  }
  
  public final ac c(ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(191157);
    p.h(paramac, "composition");
    paramac = this.GGt.c(paramac, paramBoolean);
    AppMethodBeat.o(191157);
    return paramac;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(191155);
    if (this.wji.bJw())
    {
      this.GGs = false;
      this.wji.setShow(false);
      AppMethodBeat.o(191155);
      return true;
    }
    AppMethodBeat.o(191155);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onProgress(long paramLong)
  {
    AppMethodBeat.i(191161);
    if (this.wji.bJw()) {
      fCP().setProgress(paramLong);
    }
    AppMethodBeat.o(191161);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191166);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191166);
  }
  
  public final void onResume() {}
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(191163);
    fCQ().setImageDrawable(ar.m(this.wgq.getContext(), 2131690647, -1));
    AppMethodBeat.o(191163);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(191162);
    fCQ().setImageDrawable(ar.m(this.wgq.getContext(), 2131690631, -1));
    AppMethodBeat.o(191162);
  }
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191154);
    if (paramInt == 8)
    {
      this.GGs = false;
      this.wji.setShow(false);
    }
    AppMethodBeat.o(191154);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191134);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      a.a(this.GGw, false);
      a.b(this.GGw).setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191134);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191135);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      a.a(this.GGw, true);
      a.b(this.GGw).setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191135);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191136);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      a.c(this.GGw).performClick();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191136);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<TextView>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$OnCropCallback;", "onTapDown", "", "position", "", "left", "", "startTimeMs", "", "endTimeMs", "onTapMove", "onTapUp", "pause", "resume", "seekTo", "time", "plugin-vlog_release"})
  public static final class j
    implements MultiTrackCropView.b
  {
    public final void a(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191141);
      Object localObject = a.e(this.GGw);
      p.g(localObject, "progressIndicator");
      ((View)localObject).setVisibility(4);
      localObject = a.f(this.GGw);
      if (localObject != null) {
        ((e.e)localObject).pause();
      }
      localObject = this.GGw.wgr;
      d.c localc = d.c.BWe;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_COMPOSITION_TRACK_INDEX", paramInt);
      localBundle.putBoolean("EDIT_COMPOSITION_LEFT", paramBoolean);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((d)localObject).a(localc, localBundle);
      AppMethodBeat.o(191141);
    }
    
    public final void b(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191142);
      Object localObject = a.e(this.GGw);
      p.g(localObject, "progressIndicator");
      ((View)localObject).setVisibility(0);
      localObject = this.GGw.wgr;
      d.c localc = d.c.BWe;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_COMPOSITION_TRACK_INDEX", paramInt);
      localBundle.putBoolean("EDIT_COMPOSITION_LEFT", paramBoolean);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((d)localObject).a(localc, localBundle);
      a.g(this.GGw);
      AppMethodBeat.o(191142);
    }
    
    public final void fCR()
    {
      AppMethodBeat.i(191143);
      a.g(this.GGw);
      AppMethodBeat.o(191143);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(191144);
      e.e locale = a.f(this.GGw);
      if (locale != null)
      {
        locale.pause();
        AppMethodBeat.o(191144);
        return;
      }
      AppMethodBeat.o(191144);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(191145);
      e.e locale = a.f(this.GGw);
      if (locale != null)
      {
        locale.Lb(paramLong);
        AppMethodBeat.o(191145);
        return;
      }
      AppMethodBeat.o(191145);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    k(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    l(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<View>
  {
    m(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<MultiTrackCropView>
  {
    n(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.a
 * JD-Core Version:    0.7.0.1
 */