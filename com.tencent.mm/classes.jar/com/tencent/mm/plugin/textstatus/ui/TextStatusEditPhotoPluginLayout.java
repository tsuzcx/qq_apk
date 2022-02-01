package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.plugin.d;
import com.tencent.mm.plugin.recordvideo.plugin.k;
import com.tencent.mm.plugin.recordvideo.plugin.m;
import com.tencent.mm.plugin.recordvideo.plugin.n;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "revertBtn", "Landroid/widget/ImageView;", "getRevertBtn", "()Landroid/widget/ImageView;", "revertBtn$delegate", "Lkotlin/Lazy;", "sendBtn", "getSendBtn", "sendBtn$delegate", "singhtBtnContainer", "Landroid/widget/RelativeLayout;", "getSinghtBtnContainer", "()Landroid/widget/RelativeLayout;", "singhtBtnContainer$delegate", "getLayoutId", "", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onAttach", "setOutputSize", "path", "", "Companion", "plugin-textstatus_release"})
public final class TextStatusEditPhotoPluginLayout
  extends EditPhotoPluginLayout
{
  public static final a MMS;
  private final kotlin.f MMQ;
  private final kotlin.f MMR;
  private final kotlin.f yPa;
  
  static
  {
    AppMethodBeat.i(235859);
    MMS = new a((byte)0);
    AppMethodBeat.o(235859);
  }
  
  public TextStatusEditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235857);
    this.MMQ = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.MMR = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.yPa = kotlin.g.ar((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(235857);
  }
  
  private final ImageView getRevertBtn()
  {
    AppMethodBeat.i(235847);
    ImageView localImageView = (ImageView)this.MMR.getValue();
    AppMethodBeat.o(235847);
    return localImageView;
  }
  
  private final ImageView getSendBtn()
  {
    AppMethodBeat.i(235848);
    ImageView localImageView = (ImageView)this.yPa.getValue();
    AppMethodBeat.o(235848);
    return localImageView;
  }
  
  private final RelativeLayout getSinghtBtnContainer()
  {
    AppMethodBeat.i(235845);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.MMQ.getValue();
    AppMethodBeat.o(235845);
    return localRelativeLayout;
  }
  
  private final void setOutputSize(String paramString)
  {
    AppMethodBeat.i(235852);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapUtil.decodeFile(paramString, localOptions);
    if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      "setOutputSize getOption error. path:".concat(String.valueOf(paramString));
      com.tencent.d.f.h.ioq();
      AppMethodBeat.o(235852);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waR, 1920);
    int j;
    int k;
    if (localOptions.outWidth > localOptions.outHeight)
    {
      j = localOptions.outHeight * i / localOptions.outWidth;
      k = i;
    }
    for (;;)
    {
      new StringBuilder("setOutputSize config[").append(i).append("] origin[").append(localOptions.outWidth).append(',').append(localOptions.outHeight).append("] target[").append(k).append(',').append(j).append(']');
      com.tencent.d.f.h.ioq();
      getEditPhotoWrapper().setOutputSize(k, j);
      AppMethodBeat.o(235852);
      return;
      k = localOptions.outWidth * i / localOptions.outHeight;
      j = i;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(235850);
    getEditPencilPlugin().setVisibility(4);
    getAddEmojiPlugin().setVisibility(4);
    getEditAddTextPlugin().setVisibility(4);
    getEditCropPhotoPlugin().setVisibility(4);
    getBackToRecordPlugin().setVisibility(4);
    getSinghtBtnContainer().setVisibility(0);
    getRevertBtn().setOnClickListener((View.OnClickListener)new b(this));
    getSendBtn().setOnClickListener((View.OnClickListener)new c(this));
    super.a(paramb);
    if (paramb == null) {
      p.iCn();
    }
    setOutputSize(paramb.lfq);
    AppMethodBeat.o(235850);
  }
  
  public final void bbp()
  {
    AppMethodBeat.i(235855);
    super.bbp();
    getEditFinishPlugin().view.setVisibility(4);
    AppMethodBeat.o(235855);
  }
  
  public final int getLayoutId()
  {
    return b.f.MxU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$Companion;", "", "()V", "DEFAULT_SIZE", "", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237435);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      TextStatusEditPhotoPluginLayout.a(this.MMT).onClick(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237435);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(238731);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      TextStatusEditPhotoPluginLayout.b(this.MMT).onClick(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(238731);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    d(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    e(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    f(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */