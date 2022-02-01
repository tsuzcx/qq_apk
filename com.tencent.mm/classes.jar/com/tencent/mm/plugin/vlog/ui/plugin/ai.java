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
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1;", "originEnd", "originPlayRate", "", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "playStartOffset", "sourceDuration", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "trackCropView$delegate", "videoSeekable", "cancel", "", "checkInit", "isShowing", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "init", "maxTrackEnd", "setVisibility", "visibility", "", "updateHint", "plugin-vlog_release"})
public final class ai
  implements t, e.c
{
  e.e GGT;
  e.e GGU;
  private final f GGj;
  private final f GGk;
  private final f GGl;
  private final f GGm;
  private final f GGn;
  boolean GGs;
  private long GHo;
  private long GHp;
  long GHq;
  long GHr;
  private float GJA;
  private long GJB;
  private final g GJC;
  private long GJz;
  final String TAG;
  private boolean gKM;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  final EditorPanelHolder wji;
  
  public ai(EditorPanelHolder paramEditorPanelHolder, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(191574);
    this.wji = paramEditorPanelHolder;
    this.wgr = paramd;
    this.TAG = "MicroMsg.VLogTrackEditPlugin";
    this.GGj = g.ah((kotlin.g.a.a)new h(this));
    this.GGk = g.ah((kotlin.g.a.a)new i(this));
    this.GGl = g.ah((kotlin.g.a.a)new e(this));
    this.GGm = g.ah((kotlin.g.a.a)new a(this));
    this.GGn = g.ah((kotlin.g.a.a)new f(this));
    this.GJA = 1.0F;
    this.GJC = new g(this);
    AppMethodBeat.o(191574);
  }
  
  private void a(ad paramad, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(191569);
    p.h(paramad, "track");
    if ((paramBoolean) && (this.GHr != 0L))
    {
      this.GJC.ay(this.GHq, this.GHr);
      AppMethodBeat.o(191569);
      return;
    }
    this.GGs = false;
    if (!this.gKM)
    {
      this.gKM = true;
      this.wji.setCloseTouchOutside(false);
      fDR().setCallback((TrackCropView.a)this.GJC);
      localObject = (ImageView)this.GGm.getValue();
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener((View.OnClickListener)new b(this));
      }
      localObject = (ImageView)this.GGn.getValue();
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener((View.OnClickListener)new c(this));
      }
      this.wji.setOnVisibleChangeCallback((kotlin.g.a.b)new d(this));
    }
    Object localObject = new ad(paramad.path, paramad.type);
    ((ad)localObject).KR(paramad.GzA.GJB);
    ((ad)localObject).KP(((float)paramad.GzA.GJB / paramad.GzA.mwH));
    ((ad)localObject).setPlayRate(paramad.GzA.mwH);
    ((ad)localObject).GzA.Rhd = 0L;
    ((ad)localObject).GzA.Rhe = ((ad)localObject).GzA.endTimeMs;
    ((ad)localObject).GzA.gKp();
    this.GJz = paramad.GzA.startTimeMs;
    this.GHo = paramad.GzA.GGz;
    this.GHp = Math.min(paramad.GzA.GGA, paramLong);
    this.GJA = paramad.GzA.mwH;
    this.GHq = (((float)this.GHo / this.GJA));
    this.GHr = (((float)this.GHp / this.GJA));
    this.GJB = paramad.GzA.GJB;
    localObject = new ac(j.listOf(localObject));
    ((ac)localObject).at(((float)this.GHo / paramad.GzA.mwH), ((float)this.GHp / paramad.GzA.mwH));
    TrackCropView.a(fDR(), (ac)localObject);
    this.wji.setShow(true);
    eTf();
    AppMethodBeat.o(191569);
  }
  
  private final TextView dpN()
  {
    AppMethodBeat.i(191565);
    TextView localTextView = (TextView)this.GGl.getValue();
    AppMethodBeat.o(191565);
    return localTextView;
  }
  
  public final void a(e.e parame) {}
  
  public final void a(e.e parame1, e.e parame2)
  {
    this.GGT = parame1;
    this.GGU = parame2;
  }
  
  public final void aSs() {}
  
  final void eTf()
  {
    AppMethodBeat.i(191571);
    int i = Math.round((float)this.GJB / this.GJA / 1000.0F);
    int j = Math.round((float)(this.GHr - this.GHq) / 1000.0F);
    TextView localTextView = dpN();
    p.g(localTextView, "hintText");
    localTextView.setText((CharSequence)this.wji.getContext().getString(2131767122, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    AppMethodBeat.o(191571);
  }
  
  final TrackCropView fDR()
  {
    AppMethodBeat.i(191564);
    TrackCropView localTrackCropView = (TrackCropView)this.GGk.getValue();
    AppMethodBeat.o(191564);
    return localTrackCropView;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(191573);
    if (this.wji.getVisibility() == 0)
    {
      AppMethodBeat.o(191573);
      return true;
    }
    AppMethodBeat.o(191573);
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(191568);
    if (this.wji.bJw())
    {
      this.GGs = false;
      this.wji.setShow(false);
      AppMethodBeat.o(191568);
      return true;
    }
    AppMethodBeat.o(191568);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onProgress(long paramLong)
  {
    AppMethodBeat.i(191572);
    if (this.wji.bJw()) {
      fDR().setProgress(paramLong);
    }
    AppMethodBeat.o(191572);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191575);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191575);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(191566);
    fDR().setEnableLengthEdit(paramBoolean);
    AppMethodBeat.o(191566);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191567);
    if (paramInt == 8)
    {
      this.GGs = false;
      this.wji.setShow(false);
    }
    AppMethodBeat.o(191567);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    a(ai paramai)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ai paramai) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191553);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.GJD.GGs = false;
      this.GJD.wji.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191553);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ai paramai) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191554);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.GJD.GGs = true;
      this.GJD.wji.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191554);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(ai paramai)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<TextView>
  {
    e(ai paramai)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    f(ai paramai)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static final class g
    implements TrackCropView.a
  {
    public final void ay(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191559);
      Log.i(this.GJD.TAG, "onScrollStateChanged: " + paramLong1 + ", " + paramLong2);
      Object localObject = new Bundle();
      this.GJD.GHq = paramLong1;
      this.GJD.GHr = paramLong2;
      this.GJD.eTf();
      ((Bundle)localObject).putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      ((Bundle)localObject).putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((Bundle)localObject).putBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", true);
      this.GJD.wgr.a(d.c.BWc, (Bundle)localObject);
      localObject = this.GJD.GGT;
      if (localObject != null)
      {
        ((e.e)localObject).resume();
        AppMethodBeat.o(191559);
        return;
      }
      AppMethodBeat.o(191559);
    }
    
    public final void az(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191558);
      this.GJD.GHq = paramLong1;
      this.GJD.GHr = paramLong2;
      this.GJD.eTf();
      AppMethodBeat.o(191558);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(191560);
      e.e locale = this.GJD.GGT;
      if (locale != null) {
        locale.pause();
      }
      locale = this.GJD.GGU;
      if (locale != null)
      {
        locale.pause();
        AppMethodBeat.o(191560);
        return;
      }
      AppMethodBeat.o(191560);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(191561);
      e.e locale = this.GJD.GGT;
      if (locale != null)
      {
        locale.Lb(paramLong);
        AppMethodBeat.o(191561);
        return;
      }
      AppMethodBeat.o(191561);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    h(ai paramai)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<TrackCropView>
  {
    i(ai paramai)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ai
 * JD-Core Version:    0.7.0.1
 */