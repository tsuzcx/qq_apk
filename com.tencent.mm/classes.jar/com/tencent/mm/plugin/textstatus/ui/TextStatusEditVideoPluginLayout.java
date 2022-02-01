package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.c;
import com.tencent.mm.plugin.recordvideo.plugin.e;
import com.tencent.mm.plugin.recordvideo.plugin.g;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.textstatus.a.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxDuration", "", "revertBtn", "Landroid/widget/ImageView;", "getRevertBtn", "()Landroid/widget/ImageView;", "revertBtn$delegate", "Lkotlin/Lazy;", "sendBtn", "getSendBtn", "sendBtn$delegate", "singhtBtnContainer", "Landroid/widget/RelativeLayout;", "getSinghtBtnContainer", "()Landroid/widget/RelativeLayout;", "singhtBtnContainer$delegate", "getLayoutId", "", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onAttach", "setInvisiblePlugin", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEditVideoPluginLayout
  extends EditorVideoPluginLayoutNew
{
  public static final TextStatusEditVideoPluginLayout.a Tzi;
  private final j ETG;
  private final j Tzf;
  private final j Tzg;
  private long Tzj;
  
  static
  {
    AppMethodBeat.i(291370);
    Tzi = new TextStatusEditVideoPluginLayout.a((byte)0);
    AppMethodBeat.o(291370);
  }
  
  public TextStatusEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(291313);
    this.Tzj = 15L;
    this.Tzf = k.cm((kotlin.g.a.a)new f(this));
    this.Tzg = k.cm((kotlin.g.a.a)new d(this));
    this.ETG = k.cm((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(291313);
  }
  
  private static final void a(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout, View paramView)
  {
    AppMethodBeat.i(291343);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditVideoPluginLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTextStatusEditVideoPluginLayout, "this$0");
    paramTextStatusEditVideoPluginLayout.getBackToRecordPlugin().onClick(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291343);
  }
  
  private static final void b(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout, View paramView)
  {
    AppMethodBeat.i(291350);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTextStatusEditVideoPluginLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTextStatusEditVideoPluginLayout, "this$0");
    paramTextStatusEditVideoPluginLayout.getEditFinishPlugin().onClick(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291350);
  }
  
  private final ImageView getRevertBtn()
  {
    AppMethodBeat.i(291333);
    Object localObject = this.Tzg.getValue();
    s.s(localObject, "<get-revertBtn>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(291333);
    return localObject;
  }
  
  private final ImageView getSendBtn()
  {
    AppMethodBeat.i(291337);
    Object localObject = this.ETG.getValue();
    s.s(localObject, "<get-sendBtn>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(291337);
    return localObject;
  }
  
  private final RelativeLayout getSinghtBtnContainer()
  {
    AppMethodBeat.i(291325);
    Object localObject = this.Tzf.getValue();
    s.s(localObject, "<get-singhtBtnContainer>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(291325);
    return localObject;
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(291395);
    getReMuxPlugin().NLv = ((q)new c(paramb, this));
    getAddEmojiPlugin().setVisibility(4);
    getAddTextPlugin().setVisibility(4);
    getAddMusicPlugin().setVisibility(4);
    getCropVideoPlugin().setVisibility(4);
    getEditFinishPlugin().view.setVisibility(4);
    getBackToRecordPlugin().setVisibility(4);
    super.a(paramb);
    AppMethodBeat.o(291395);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(291401);
    s.u(paramc, "status");
    switch (TextStatusEditVideoPluginLayout.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(291401);
      return;
    case 1: 
      super.a(a.c.NOQ, paramBundle);
      AppMethodBeat.o(291401);
      return;
    }
    super.a(paramc, paramBundle);
    if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_VIDEO_NEED_CROP"))) {}
    for (int i = 1; i != 0; i = 0)
    {
      getSinghtBtnContainer().setVisibility(0);
      getRevertBtn().setOnClickListener(new TextStatusEditVideoPluginLayout..ExternalSyntheticLambda0(this));
      getSendBtn().setOnClickListener(new TextStatusEditVideoPluginLayout..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(291401);
      return;
    }
    getSinghtBtnContainer().setVisibility(4);
    AppMethodBeat.o(291401);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(291413);
    super.bwk();
    getEditFinishPlugin().view.setVisibility(4);
    AppMethodBeat.o(291413);
  }
  
  public final int getLayoutId()
  {
    return a.f.TfS;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements q<String, String, Boolean, ah>
  {
    c(com.tencent.mm.media.widget.camerarecordview.b.b paramb, TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    d(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    e(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    f(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */