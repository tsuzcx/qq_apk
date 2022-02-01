package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.plugin.c;
import com.tencent.mm.plugin.recordvideo.plugin.e;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.m;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "revertBtn", "Landroid/widget/ImageView;", "getRevertBtn", "()Landroid/widget/ImageView;", "revertBtn$delegate", "Lkotlin/Lazy;", "sendBtn", "getSendBtn", "sendBtn$delegate", "singhtBtnContainer", "Landroid/widget/RelativeLayout;", "getSinghtBtnContainer", "()Landroid/widget/RelativeLayout;", "singhtBtnContainer$delegate", "getLayoutId", "", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onAttach", "setOutputSize", "path", "", "Companion", "plugin-textstatus_release"})
public final class TextStatusEditPhotoPluginLayout
  extends EditPhotoPluginLayout
{
  public static final TextStatusEditPhotoPluginLayout.a Gfb;
  private final kotlin.f GeZ;
  private final kotlin.f Gfa;
  private final kotlin.f vRo;
  
  static
  {
    AppMethodBeat.i(216580);
    Gfb = new TextStatusEditPhotoPluginLayout.a((byte)0);
    AppMethodBeat.o(216580);
  }
  
  public TextStatusEditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216579);
    this.GeZ = kotlin.g.ah((kotlin.g.a.a)new f(this));
    this.Gfa = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.vRo = kotlin.g.ah((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(216579);
  }
  
  private final ImageView getRevertBtn()
  {
    AppMethodBeat.i(216574);
    ImageView localImageView = (ImageView)this.Gfa.getValue();
    AppMethodBeat.o(216574);
    return localImageView;
  }
  
  private final ImageView getSendBtn()
  {
    AppMethodBeat.i(216575);
    ImageView localImageView = (ImageView)this.vRo.getValue();
    AppMethodBeat.o(216575);
    return localImageView;
  }
  
  private final RelativeLayout getSinghtBtnContainer()
  {
    AppMethodBeat.i(216573);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.GeZ.getValue();
    AppMethodBeat.o(216573);
    return localRelativeLayout;
  }
  
  private final void setOutputSize(String paramString)
  {
    AppMethodBeat.i(216577);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapUtil.decodeFile(paramString, localOptions);
    if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      "setOutputSize getOption error. path:".concat(String.valueOf(paramString));
      h.hkS();
      AppMethodBeat.o(216577);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.spg, 1920);
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
      h.hkS();
      paramString = getEditPhotoWrapper().zQp;
      if (paramString == null) {
        break;
      }
      paramString.setOutputSize(k, j);
      AppMethodBeat.o(216577);
      return;
      k = localOptions.outWidth * i / localOptions.outHeight;
      j = i;
    }
    AppMethodBeat.o(216577);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(216576);
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
      p.hyc();
    }
    setOutputSize(paramb.iql);
    AppMethodBeat.o(216576);
  }
  
  public final void aSs()
  {
    AppMethodBeat.i(216578);
    super.aSs();
    getEditFinishPlugin().view.setVisibility(4);
    AppMethodBeat.o(216578);
  }
  
  public final int getLayoutId()
  {
    return 2131496692;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216568);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      TextStatusEditPhotoPluginLayout.a(this.Gfc).onClick(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216568);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216569);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      TextStatusEditPhotoPluginLayout.b(this.Gfc).onClick(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216569);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    d(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    e(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */