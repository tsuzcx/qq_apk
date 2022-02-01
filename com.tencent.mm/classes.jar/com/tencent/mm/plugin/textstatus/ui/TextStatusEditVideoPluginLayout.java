package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.textstatus.b.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxDuration", "", "revertBtn", "Landroid/widget/ImageView;", "getRevertBtn", "()Landroid/widget/ImageView;", "revertBtn$delegate", "Lkotlin/Lazy;", "sendBtn", "getSendBtn", "sendBtn$delegate", "singhtBtnContainer", "Landroid/widget/RelativeLayout;", "getSinghtBtnContainer", "()Landroid/widget/RelativeLayout;", "singhtBtnContainer$delegate", "getLayoutId", "", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onAttach", "setInvisiblePlugin", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusEditVideoPluginLayout
  extends EditorVideoPluginLayoutNew
{
  public static final a MMV;
  private final kotlin.f MMQ;
  private final kotlin.f MMR;
  private long MMU;
  private final kotlin.f yPa;
  
  static
  {
    AppMethodBeat.i(237876);
    MMV = new a((byte)0);
    AppMethodBeat.o(237876);
  }
  
  public TextStatusEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237875);
    this.MMU = 15L;
    this.MMQ = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.MMR = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.yPa = kotlin.g.ar((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(237875);
  }
  
  private final ImageView getRevertBtn()
  {
    AppMethodBeat.i(237859);
    ImageView localImageView = (ImageView)this.MMR.getValue();
    AppMethodBeat.o(237859);
    return localImageView;
  }
  
  private final ImageView getSendBtn()
  {
    AppMethodBeat.i(237861);
    ImageView localImageView = (ImageView)this.yPa.getValue();
    AppMethodBeat.o(237861);
    return localImageView;
  }
  
  private final RelativeLayout getSinghtBtnContainer()
  {
    AppMethodBeat.i(237858);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.MMQ.getValue();
    AppMethodBeat.o(237858);
    return localRelativeLayout;
  }
  
  public final void a(final com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(237862);
    getReMuxPlugin().HOI = ((kotlin.g.a.q)new b(this, paramb));
    getAddEmojiPlugin().setVisibility(4);
    getAddTextPlugin().setVisibility(4);
    getAddMusicPlugin().setVisibility(4);
    getCropVideoPlugin().setVisibility(4);
    getEditFinishPlugin().view.setVisibility(4);
    getBackToRecordPlugin().setVisibility(4);
    super.a(paramb);
    AppMethodBeat.o(237862);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(237864);
    p.k(parama, "navigator");
    p.k(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    AppMethodBeat.o(237864);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(237868);
    p.k(paramc, "status");
    switch (l.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(237868);
      return;
    case 1: 
      super.a(d.c.HSk, paramBundle);
      AppMethodBeat.o(237868);
      return;
    }
    super.a(paramc, paramBundle);
    if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_VIDEO_NEED_CROP")))
    {
      getSinghtBtnContainer().setVisibility(0);
      getRevertBtn().setOnClickListener((View.OnClickListener)new f(this));
      getSendBtn().setOnClickListener((View.OnClickListener)new g(this));
      AppMethodBeat.o(237868);
      return;
    }
    getSinghtBtnContainer().setVisibility(4);
    AppMethodBeat.o(237868);
  }
  
  public final void bbp()
  {
    AppMethodBeat.i(237871);
    super.bbp();
    getEditFinishPlugin().view.setVisibility(4);
    AppMethodBeat.o(237871);
  }
  
  public final int getLayoutId()
  {
    return b.f.Myo;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$Companion;", "", "()V", "DEFAULT_SIZE", "", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, String, Boolean, x>
  {
    b(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout, com.tencent.mm.media.widget.camerarecordview.b.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    c(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    d(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RelativeLayout>
  {
    e(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237951);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      TextStatusEditVideoPluginLayout.b(this.MMW).onClick(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237951);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(232438);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      TextStatusEditVideoPluginLayout.c(this.MMW).onClick(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(232438);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */