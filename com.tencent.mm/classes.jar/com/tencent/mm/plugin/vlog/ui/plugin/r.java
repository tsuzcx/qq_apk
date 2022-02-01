package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.c;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "context", "Landroid/content/Context;", "dialogView", "Landroid/view/View;", "getDialogView", "()Landroid/view/View;", "dialogView$delegate", "Lkotlin/Lazy;", "editorControlIconsContainer", "kotlin.jvm.PlatformType", "getEditorControlIconsContainer", "editorControlIconsContainer$delegate", "enable", "", "finishBtn", "Landroid/widget/Button;", "getFinishBtn", "()Landroid/widget/Button;", "finishBtn$delegate", "fullScreenThumbView", "Landroid/widget/ImageView;", "getFullScreenThumbView", "()Landroid/widget/ImageView;", "fullScreenThumbView$delegate", "halfScreenHeader", "halfScreenSelectBtn", "halfScreenThumbView", "getHalfScreenThumbView", "halfScreenThumbView$delegate", "helpDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "getHelpDialog", "()Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "helpDialog$delegate", "value", "isFirstEnter", "()Z", "setFirstEnter", "(Z)V", "isNeedCropFullScreen", "isPreviewHalfScreen", "getLayout", "()Landroid/view/ViewGroup;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbHeight", "", "thumbPath", "", "thumbWidth", "changePreviewMode", "", "halfScreen", "enablePreview", "ensureThumb", "hide", "isEnablePreview", "isInHalfScreenMode", "need", "onBackPress", "onUpdate", "seekTo", "", "seekToOriginPosition", "onUpdateImage", "show", "showHelpDialogIfNeed", "Companion", "plugin-vlog_release"})
public final class r
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.d
{
  public static final a NvH;
  final ViewGroup APk;
  private final d APl;
  private final f Aqs;
  private c Aub;
  private ac Nlb;
  public boolean NuF;
  private final View NvA;
  private final f NvB;
  private final f NvC;
  private final f NvD;
  private final f NvE;
  public boolean NvF;
  private final f NvG;
  private final View Nvz;
  private final MultiProcessMMKV cQO;
  private final Context context;
  private boolean enable;
  private final int thumbHeight;
  public String thumbPath;
  private final int thumbWidth;
  
  static
  {
    AppMethodBeat.i(226779);
    NvH = new a((byte)0);
    AppMethodBeat.o(226779);
  }
  
  public r(ViewGroup paramViewGroup, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(226778);
    this.APk = paramViewGroup;
    this.APl = paramd;
    paramViewGroup = this.APk.getContext();
    p.j(paramViewGroup, "layout.context");
    this.context = paramViewGroup;
    this.cQO = MultiProcessMMKV.getMMKV("MultiEditPostPreviewPlugin");
    paramViewGroup = this.APk.findViewById(a.f.half_screen_select_btn);
    p.j(paramViewGroup, "layout.findViewById(R.id.half_screen_select_btn)");
    this.Nvz = paramViewGroup;
    paramViewGroup = this.APk.findViewById(a.f.half_screen_header);
    p.j(paramViewGroup, "layout.findViewById(R.id.half_screen_header)");
    this.NvA = paramViewGroup;
    this.NvB = g.ar((kotlin.g.a.a)new c(this));
    this.Aqs = g.ar((kotlin.g.a.a)new e(this));
    this.NvC = g.ar((kotlin.g.a.a)new b(this));
    this.NvD = g.ar((kotlin.g.a.a)new g(this));
    this.NvE = g.ar((kotlin.g.a.a)new f(this));
    this.thumbWidth = com.tencent.mm.ci.a.aY(this.context, a.d.Edge_12A);
    this.thumbHeight = com.tencent.mm.ci.a.aY(this.context, a.d.Edge_23A);
    this.NvG = g.ar((kotlin.g.a.a)new h(this));
    this.Nvz.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(229580);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.NvI;
        if (!r.e(this.NvI)) {}
        for (boolean bool = true;; bool = false)
        {
          r.a(paramAnonymousView, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(229580);
          return;
        }
      }
    });
    this.NvA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235779);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        r.f(this.NvI);
        r.g(this.NvI).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(235779);
      }
    });
    AppMethodBeat.o(226778);
  }
  
  private final Button getFinishBtn()
  {
    AppMethodBeat.i(226745);
    Button localButton = (Button)this.Aqs.getValue();
    AppMethodBeat.o(226745);
    return localButton;
  }
  
  private final boolean gvp()
  {
    AppMethodBeat.i(226739);
    boolean bool = this.cQO.getBoolean("isFirstEnter", false);
    AppMethodBeat.o(226739);
    return bool;
  }
  
  private final void gvq()
  {
    AppMethodBeat.i(226741);
    this.cQO.putBoolean("isFirstEnter", true);
    AppMethodBeat.o(226741);
  }
  
  private final View gvr()
  {
    AppMethodBeat.i(226743);
    View localView = (View)this.NvB.getValue();
    AppMethodBeat.o(226743);
    return localView;
  }
  
  private final ImageView gvs()
  {
    AppMethodBeat.i(226747);
    ImageView localImageView = (ImageView)this.NvD.getValue();
    AppMethodBeat.o(226747);
    return localImageView;
  }
  
  private final ImageView gvt()
  {
    AppMethodBeat.i(226749);
    ImageView localImageView = (ImageView)this.NvE.getValue();
    AppMethodBeat.o(226749);
    return localImageView;
  }
  
  private final com.google.android.material.bottomsheet.a gvu()
  {
    AppMethodBeat.i(226750);
    com.google.android.material.bottomsheet.a locala = (com.google.android.material.bottomsheet.a)this.NvG.getValue();
    AppMethodBeat.o(226750);
    return locala;
  }
  
  private final void gvv()
  {
    AppMethodBeat.i(226769);
    Object localObject3 = this.thumbPath;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject2 = com.tencent.mm.plugin.gallery.a.b.ew(u.n(this.thumbPath, false), Math.max(this.thumbWidth, this.thumbHeight));
      if (localObject2 == null) {}
    }
    for (;;)
    {
      try
      {
        int i = new androidx.e.a.a(u.Tf((String)localObject3)).i("Orientation", 1);
        localObject3 = new Matrix();
        switch (i)
        {
        case 6: 
          Object localObject1;
          ((Matrix)localObject3).postRotate(localObject1);
          localObject2 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject3, true);
          gvs().setImageBitmap((Bitmap)localObject2);
          gvt().setImageBitmap((Bitmap)localObject2);
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MultiEditPostPreviewPlugin", "cannot decode thumbnail from " + this.thumbPath + ", " + localException.getLocalizedMessage());
        continue;
        AppMethodBeat.o(226769);
        return;
      }
      localObject2 = this.Nlb;
      if (localObject2 != null)
      {
        localObject3 = this.Aub;
        if (localObject3 != null) {
          ((c)localObject3).destroy();
        }
        localObject3 = com.tencent.mm.videocomposition.a.YHM;
        this.Aub = ((c)a.a.d(((ad)j.lo((List)((ac)localObject2).MQY)).Nng));
        localObject2 = this.Aub;
        if (localObject2 != null) {
          ((c)localObject2).setSize(this.thumbWidth, this.thumbHeight);
        }
        localObject2 = this.Aub;
        if (localObject2 != null)
        {
          ((c)localObject2).b(j.listOf(Long.valueOf(0L)), (m)new d(this));
          AppMethodBeat.o(226769);
          return;
          f = 90.0F;
          continue;
          f = 180.0F;
          continue;
          f = 270.0F;
          continue;
        }
      }
      AppMethodBeat.o(226769);
      return;
      float f = 0.0F;
    }
  }
  
  public final void At(boolean paramBoolean)
  {
    AppMethodBeat.i(226752);
    this.enable = paramBoolean;
    if (paramBoolean)
    {
      this.Nvz.setVisibility(0);
      AppMethodBeat.o(226752);
      return;
    }
    this.Nvz.setVisibility(8);
    AppMethodBeat.o(226752);
  }
  
  public final void Au(boolean paramBoolean)
  {
    AppMethodBeat.i(226757);
    this.NuF = paramBoolean;
    Object localObject;
    d.c localc;
    Bundle localBundle;
    if (this.NuF)
    {
      this.NvA.setVisibility(0);
      this.Nvz.setVisibility(8);
      localObject = gvr();
      p.j(localObject, "editorControlIconsContainer");
      ((View)localObject).setVisibility(8);
      localObject = getFinishBtn();
      p.j(localObject, "finishBtn");
      ((Button)localObject).setText((CharSequence)this.context.getString(a.i.app_ok));
      localObject = this.APl;
      localc = d.c.HSo;
      localBundle = new Bundle();
      if (!this.NuF) {
        break label202;
      }
    }
    label202:
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("PARAM_1_INT", i);
      ((d)localObject).a(localc, localBundle);
      AppMethodBeat.o(226757);
      return;
      this.NvA.setVisibility(8);
      this.Nvz.setVisibility(0);
      localObject = gvr();
      p.j(localObject, "editorControlIconsContainer");
      ((View)localObject).setVisibility(0);
      localObject = getFinishBtn();
      p.j(localObject, "finishBtn");
      ((Button)localObject).setText((CharSequence)this.context.getString(a.i.app_nextstep));
      break;
    }
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    this.Nlb = paramac;
  }
  
  public final void gvw()
  {
    AppMethodBeat.i(226771);
    if ((!gvp()) && (this.enable))
    {
      gvq();
      gvv();
      gvu().show();
    }
    AppMethodBeat.o(226771);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(226773);
    if (this.NuF)
    {
      Au(false);
      AppMethodBeat.o(226773);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(226773);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$Companion;", "", "()V", "PREVIEW_MODE_FULL", "", "PREVIEW_MODE_HALF", "PREVIEW_MODE_LOCK", "PREVIEW_MODE_WIDE_VIDEO", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<View>
  {
    b(r paramr)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<View>
  {
    c(r paramr)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "thumb", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$ensureThumb$2$1"})
  static final class d
    extends q
    implements m<Long, Bitmap, x>
  {
    d(r paramr)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<Button>
  {
    e(r paramr)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    f(r paramr)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    g(r paramr)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<com.google.android.material.bottomsheet.a>
  {
    h(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.r
 * JD-Core Version:    0.7.0.1
 */