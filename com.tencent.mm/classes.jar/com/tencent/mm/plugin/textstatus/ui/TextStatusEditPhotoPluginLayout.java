package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.plugin.e;
import com.tencent.mm.plugin.recordvideo.plugin.g;
import com.tencent.mm.plugin.recordvideo.plugin.l;
import com.tencent.mm.plugin.recordvideo.plugin.n;
import com.tencent.mm.plugin.recordvideo.plugin.o;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "revertBtn", "Landroid/widget/ImageView;", "getRevertBtn", "()Landroid/widget/ImageView;", "revertBtn$delegate", "Lkotlin/Lazy;", "sendBtn", "getSendBtn", "sendBtn$delegate", "singhtBtnContainer", "Landroid/widget/RelativeLayout;", "getSinghtBtnContainer", "()Landroid/widget/RelativeLayout;", "singhtBtnContainer$delegate", "getLayoutId", "", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onAttach", "setOutputSize", "path", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEditPhotoPluginLayout
  extends EditPhotoPluginLayout
{
  public static final TextStatusEditPhotoPluginLayout.a Tze;
  private final j ETG;
  private final j Tzf;
  private final j Tzg;
  
  static
  {
    AppMethodBeat.i(291453);
    Tze = new TextStatusEditPhotoPluginLayout.a((byte)0);
    AppMethodBeat.o(291453);
  }
  
  public TextStatusEditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(291360);
    this.Tzf = k.cm((kotlin.g.a.a)new d(this));
    this.Tzg = k.cm((kotlin.g.a.a)new b(this));
    this.ETG = k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(291360);
  }
  
  private static final void a(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout, View paramView)
  {
    AppMethodBeat.i(291428);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditPhotoPluginLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTextStatusEditPhotoPluginLayout, "this$0");
    paramTextStatusEditPhotoPluginLayout.getBackToRecordPlugin().onClick(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291428);
  }
  
  private static final void b(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout, View paramView)
  {
    AppMethodBeat.i(291443);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditPhotoPluginLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTextStatusEditPhotoPluginLayout, "this$0");
    paramTextStatusEditPhotoPluginLayout.getEditFinishPlugin().onClick(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291443);
  }
  
  private final ImageView getRevertBtn()
  {
    AppMethodBeat.i(291383);
    Object localObject = this.Tzg.getValue();
    s.s(localObject, "<get-revertBtn>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(291383);
    return localObject;
  }
  
  private final ImageView getSendBtn()
  {
    AppMethodBeat.i(291393);
    Object localObject = this.ETG.getValue();
    s.s(localObject, "<get-sendBtn>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(291393);
    return localObject;
  }
  
  private final RelativeLayout getSinghtBtnContainer()
  {
    AppMethodBeat.i(291372);
    Object localObject = this.Tzf.getValue();
    s.s(localObject, "<get-singhtBtnContainer>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(291372);
    return localObject;
  }
  
  private final void setOutputSize(String paramString)
  {
    AppMethodBeat.i(291410);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapUtil.decodeFile(paramString, localOptions);
    if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      s.X("setOutputSize getOption error. path:", paramString);
      com.tencent.e.f.h.jXD();
      AppMethodBeat.o(291410);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zuq, 1920);
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
      com.tencent.e.f.h.jXD();
      getEditPhotoWrapper().setOutputSize(k, j);
      AppMethodBeat.o(291410);
      return;
      k = localOptions.outWidth * i / localOptions.outHeight;
      j = i;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(291489);
    getEditPencilPlugin().setVisibility(4);
    getAddEmojiPlugin().setVisibility(4);
    getEditAddTextPlugin().setVisibility(4);
    getEditCropPhotoPlugin().setVisibility(4);
    getBackToRecordPlugin().setVisibility(4);
    getSinghtBtnContainer().setVisibility(0);
    getRevertBtn().setOnClickListener(new TextStatusEditPhotoPluginLayout..ExternalSyntheticLambda0(this));
    getSendBtn().setOnClickListener(new TextStatusEditPhotoPluginLayout..ExternalSyntheticLambda1(this));
    super.a(paramb);
    s.checkNotNull(paramb);
    setOutputSize(paramb.nKb);
    AppMethodBeat.o(291489);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(291515);
    super.bwk();
    getEditFinishPlugin().view.setVisibility(4);
    AppMethodBeat.o(291515);
  }
  
  public final int getLayoutId()
  {
    return a.f.TfC;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    b(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    c(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    d(TextStatusEditPhotoPluginLayout paramTextStatusEditPhotoPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */