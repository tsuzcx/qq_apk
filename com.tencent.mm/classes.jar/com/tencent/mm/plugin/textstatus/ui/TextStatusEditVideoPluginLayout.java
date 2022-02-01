package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.e;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxDuration", "", "revertBtn", "Landroid/widget/ImageView;", "getRevertBtn", "()Landroid/widget/ImageView;", "revertBtn$delegate", "Lkotlin/Lazy;", "sendBtn", "getSendBtn", "sendBtn$delegate", "singhtBtnContainer", "Landroid/widget/RelativeLayout;", "getSinghtBtnContainer", "()Landroid/widget/RelativeLayout;", "singhtBtnContainer$delegate", "getLayoutId", "", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onAttach", "setInvisiblePlugin", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusEditVideoPluginLayout
  extends EditorVideoPluginLayoutNew
{
  public static final TextStatusEditVideoPluginLayout.a Gfe;
  private final kotlin.f GeZ;
  private final kotlin.f Gfa;
  private long Gfd;
  private final kotlin.f vRo;
  
  static
  {
    AppMethodBeat.i(216598);
    Gfe = new TextStatusEditVideoPluginLayout.a((byte)0);
    AppMethodBeat.o(216598);
  }
  
  public TextStatusEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216597);
    this.Gfd = 15L;
    this.GeZ = g.ah((kotlin.g.a.a)new g(this));
    this.Gfa = g.ah((kotlin.g.a.a)new e(this));
    this.vRo = g.ah((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(216597);
  }
  
  private final ImageView getRevertBtn()
  {
    AppMethodBeat.i(216591);
    ImageView localImageView = (ImageView)this.Gfa.getValue();
    AppMethodBeat.o(216591);
    return localImageView;
  }
  
  private final ImageView getSendBtn()
  {
    AppMethodBeat.i(216592);
    ImageView localImageView = (ImageView)this.vRo.getValue();
    AppMethodBeat.o(216592);
    return localImageView;
  }
  
  private final RelativeLayout getSinghtBtnContainer()
  {
    AppMethodBeat.i(216590);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.GeZ.getValue();
    AppMethodBeat.o(216590);
    return localRelativeLayout;
  }
  
  public final void a(final com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(216593);
    getReMuxPlugin().BRT = ((kotlin.g.a.q)new d(this, paramb));
    getAddEmojiPlugin().setVisibility(4);
    getAddTextPlugin().setVisibility(4);
    getAddMusicPlugin().setVisibility(4);
    getCropVideoPlugin().setVisibility(4);
    getEditFinishPlugin().view.setVisibility(4);
    getBackToRecordPlugin().setVisibility(4);
    if (paramb != null)
    {
      Object localObject = com.tencent.mm.plugin.gallery.a.c.xsz;
      localObject = com.tencent.mm.plugin.gallery.a.c.awl(paramb.iqd);
      Log.i("MicroMsg.TextStatusEditVideoPluginLayout", "mediaInfo ".concat(String.valueOf(localObject)));
      if (((com.tencent.mm.plugin.sight.base.a)localObject).getVideoDuration() > this.Gfd) {
        break label173;
      }
      getSinghtBtnContainer().setVisibility(0);
      getRevertBtn().setOnClickListener((View.OnClickListener)new b(this));
      getSendBtn().setOnClickListener((View.OnClickListener)new c(this));
    }
    for (;;)
    {
      super.a(paramb);
      AppMethodBeat.o(216593);
      return;
      label173:
      getSinghtBtnContainer().setVisibility(4);
    }
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(216594);
    p.h(parama, "navigator");
    p.h(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    this.Gfd = paramRecordConfigProvider.BOm.duration;
    AppMethodBeat.o(216594);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216595);
    p.h(paramc, "status");
    switch (i.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(216595);
      return;
    }
    super.a(d.c.BVw, paramBundle);
    AppMethodBeat.o(216595);
  }
  
  public final void aSs()
  {
    AppMethodBeat.i(216596);
    super.aSs();
    getEditFinishPlugin().view.setVisibility(4);
    AppMethodBeat.o(216596);
  }
  
  public final int getLayoutId()
  {
    return 2131496706;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$2$1"})
  static final class b
    implements View.OnClickListener
  {
    b(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216584);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      TextStatusEditVideoPluginLayout.b(this.Gff).onClick(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216584);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$2$2"})
  static final class c
    implements View.OnClickListener
  {
    c(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216585);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      TextStatusEditVideoPluginLayout.c(this.Gff).onClick(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216585);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, String, Boolean, x>
  {
    d(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout, com.tencent.mm.media.widget.camerarecordview.b.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    e(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    f(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RelativeLayout>
  {
    g(TextStatusEditVideoPluginLayout paramTextStatusEditVideoPluginLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */