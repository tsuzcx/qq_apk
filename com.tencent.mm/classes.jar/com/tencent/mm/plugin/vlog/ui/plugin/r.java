package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.b.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "context", "Landroid/content/Context;", "dialogView", "Landroid/view/View;", "getDialogView", "()Landroid/view/View;", "dialogView$delegate", "Lkotlin/Lazy;", "editorControlIconsContainer", "kotlin.jvm.PlatformType", "getEditorControlIconsContainer", "editorControlIconsContainer$delegate", "enable", "", "finishBtn", "Landroid/widget/Button;", "getFinishBtn", "()Landroid/widget/Button;", "finishBtn$delegate", "fullScreenThumbView", "Landroid/widget/ImageView;", "getFullScreenThumbView", "()Landroid/widget/ImageView;", "fullScreenThumbView$delegate", "halfScreenHeader", "halfScreenSelectBtn", "halfScreenThumbView", "getHalfScreenThumbView", "halfScreenThumbView$delegate", "helpDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "getHelpDialog", "()Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "helpDialog$delegate", "value", "isFirstEnter", "()Z", "setFirstEnter", "(Z)V", "isNeedCropFullScreen", "isPreviewHalfScreen", "getLayout", "()Landroid/view/ViewGroup;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbHeight", "", "thumbPath", "", "thumbWidth", "changePreviewMode", "", "halfScreen", "enablePreview", "ensureThumb", "hide", "isEnablePreview", "isInHalfScreenMode", "need", "onBackPress", "onUpdate", "seekTo", "", "seekToOriginPosition", "onUpdateImage", "show", "showHelpDialogIfNeed", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.d
{
  public static final r.a UiN;
  private final j FQm;
  private c FTn;
  final ViewGroup GrB;
  private ac TYA;
  public boolean UhZ;
  private final View UiO;
  private final View UiP;
  private final j UiQ;
  private final j UiR;
  private final j UiS;
  private final j UiT;
  public boolean UiU;
  private final j UiV;
  private final Context context;
  private final MultiProcessMMKV eMf;
  private boolean enable;
  private final int thumbHeight;
  public String thumbPath;
  private final int thumbWidth;
  
  static
  {
    AppMethodBeat.i(282604);
    UiN = new r.a((byte)0);
    AppMethodBeat.o(282604);
  }
  
  public r(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282483);
    this.GrB = paramViewGroup;
    paramViewGroup = this.GrB.getContext();
    s.s(paramViewGroup, "layout.context");
    this.context = paramViewGroup;
    this.eMf = MultiProcessMMKV.getMMKV("MultiEditPostPreviewPlugin");
    paramViewGroup = this.GrB.findViewById(a.f.half_screen_select_btn);
    s.s(paramViewGroup, "layout.findViewById(R.id.half_screen_select_btn)");
    this.UiO = paramViewGroup;
    paramViewGroup = this.GrB.findViewById(a.f.half_screen_header);
    s.s(paramViewGroup, "layout.findViewById(R.id.half_screen_header)");
    this.UiP = paramViewGroup;
    this.UiQ = k.cm((kotlin.g.a.a)new c(this));
    this.FQm = k.cm((kotlin.g.a.a)new e(this));
    this.UiR = k.cm((kotlin.g.a.a)new b(this));
    this.UiS = k.cm((kotlin.g.a.a)new g(this));
    this.UiT = k.cm((kotlin.g.a.a)new f(this));
    this.thumbWidth = com.tencent.mm.cd.a.br(this.context, a.d.Edge_12A);
    this.thumbHeight = com.tencent.mm.cd.a.br(this.context, a.d.Edge_23A);
    this.UiV = k.cm((kotlin.g.a.a)new h(this));
    this.UiO.setOnClickListener(new r..ExternalSyntheticLambda1(this));
    this.UiP.setOnClickListener(new r..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(282483);
  }
  
  private static final void a(r paramr, View paramView)
  {
    AppMethodBeat.i(282571);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramr);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramr, "this$0");
    if (!paramr.UhZ) {}
    for (boolean bool = true;; bool = false)
    {
      paramr.FT(bool);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282571);
      return;
    }
  }
  
  private static final void b(r paramr, View paramView)
  {
    AppMethodBeat.i(282576);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramr);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramr, "this$0");
    paramr.hTl();
    paramr.hTk().show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282576);
  }
  
  private final Button getFinishBtn()
  {
    AppMethodBeat.i(282517);
    Button localButton = (Button)this.FQm.getValue();
    AppMethodBeat.o(282517);
    return localButton;
  }
  
  private final boolean hTf()
  {
    AppMethodBeat.i(282491);
    boolean bool = this.eMf.getBoolean("isFirstEnter", false);
    AppMethodBeat.o(282491);
    return bool;
  }
  
  private final void hTg()
  {
    AppMethodBeat.i(282496);
    this.eMf.putBoolean("isFirstEnter", true);
    AppMethodBeat.o(282496);
  }
  
  private final View hTh()
  {
    AppMethodBeat.i(282507);
    View localView = (View)this.UiQ.getValue();
    AppMethodBeat.o(282507);
    return localView;
  }
  
  private final ImageView hTi()
  {
    AppMethodBeat.i(282525);
    ImageView localImageView = (ImageView)this.UiS.getValue();
    AppMethodBeat.o(282525);
    return localImageView;
  }
  
  private final ImageView hTj()
  {
    AppMethodBeat.i(282535);
    ImageView localImageView = (ImageView)this.UiT.getValue();
    AppMethodBeat.o(282535);
    return localImageView;
  }
  
  private final com.google.android.material.bottomsheet.a hTk()
  {
    AppMethodBeat.i(282542);
    com.google.android.material.bottomsheet.a locala = (com.google.android.material.bottomsheet.a)this.UiV.getValue();
    AppMethodBeat.o(282542);
    return locala;
  }
  
  private final void hTl()
  {
    AppMethodBeat.i(282561);
    Object localObject3 = this.thumbPath;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject2 = d.fl(y.n(this.thumbPath, false), Math.max(this.thumbWidth, this.thumbHeight));
      if (localObject2 == null) {}
    }
    for (;;)
    {
      try
      {
        int i = new androidx.f.a.a(y.Lh((String)localObject3)).k("Orientation", 1);
        localObject3 = new Matrix();
        switch (i)
        {
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Log.e("MicroMsg.MultiEditPostPreviewPlugin", "cannot decode thumbnail from " + this.thumbPath + ", " + localException.getLocalizedMessage());
        continue;
        float f = 0.0F;
        continue;
      }
      ((Matrix)localObject3).postRotate(localObject1);
      localObject2 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject3, true);
      hTi().setImageBitmap((Bitmap)localObject2);
      hTj().setImageBitmap((Bitmap)localObject2);
      localObject2 = this.TYA;
      if (localObject2 != null)
      {
        localObject3 = this.FTn;
        if (localObject3 != null) {
          ((c)localObject3).destroy();
        }
        localObject3 = com.tencent.mm.videocomposition.a.agDr;
        this.FTn = ((c)a.a.d(((ad)p.oK((List)((ac)localObject2).TDz)).UaI));
        localObject2 = this.FTn;
        if (localObject2 != null) {
          ((c)localObject2).setSize(this.thumbWidth, this.thumbHeight);
        }
        localObject2 = this.FTn;
        if (localObject2 != null) {
          ((c)localObject2).b(p.listOf(Long.valueOf(0L)), (m)new d(this));
        }
      }
      AppMethodBeat.o(282561);
      return;
      f = 90.0F;
      continue;
      f = 180.0F;
      continue;
      f = 270.0F;
    }
  }
  
  public final void FS(boolean paramBoolean)
  {
    AppMethodBeat.i(282626);
    this.enable = paramBoolean;
    if (paramBoolean)
    {
      this.UiO.setVisibility(0);
      AppMethodBeat.o(282626);
      return;
    }
    this.UiO.setVisibility(8);
    AppMethodBeat.o(282626);
  }
  
  public final void FT(boolean paramBoolean)
  {
    AppMethodBeat.i(282641);
    this.UhZ = paramBoolean;
    com.tencent.mm.plugin.recordvideo.plugin.parent.a locala;
    a.c localc;
    Bundle localBundle;
    if (this.UhZ)
    {
      this.UiP.setVisibility(0);
      this.UiO.setVisibility(8);
      hTh().setVisibility(8);
      getFinishBtn().setText((CharSequence)this.context.getString(a.i.app_ok));
      locala = this.GrC;
      localc = a.c.NOU;
      localBundle = new Bundle();
      if (!this.UhZ) {
        break label171;
      }
    }
    label171:
    for (int i = 2;; i = 1)
    {
      localBundle.putInt("PARAM_1_INT", i);
      ah localah = ah.aiuX;
      locala.a(localc, localBundle);
      AppMethodBeat.o(282641);
      return;
      this.UiP.setVisibility(8);
      this.UiO.setVisibility(0);
      hTh().setVisibility(0);
      getFinishBtn().setText((CharSequence)this.context.getString(a.i.app_nextstep));
      break;
    }
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    this.TYA = paramac;
  }
  
  public final void hTm()
  {
    AppMethodBeat.i(282649);
    if ((!hTf()) && (this.enable))
    {
      hTg();
      hTl();
      hTk().show();
    }
    AppMethodBeat.o(282649);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282654);
    if (this.UhZ)
    {
      FT(false);
      AppMethodBeat.o(282654);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(282654);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<View>
  {
    b(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<View>
  {
    c(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "thumb", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<Long, Bitmap, ah>
  {
    d(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Button>
  {
    e(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    f(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    g(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<com.google.android.material.bottomsheet.a>
  {
    h(r paramr)
    {
      super();
    }
    
    private static final void a(com.google.android.material.bottomsheet.a parama, View paramView)
    {
      AppMethodBeat.i(283069);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$helpDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "$this_apply");
      parama.hide();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$helpDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(283069);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.r
 * JD-Core Version:    0.7.0.1
 */