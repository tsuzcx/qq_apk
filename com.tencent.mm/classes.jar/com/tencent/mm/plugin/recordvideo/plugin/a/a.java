package com.tencent.mm.plugin.recordvideo.plugin.a;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.q;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView;
import com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView.a;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addAudioBtn", "Landroid/widget/ImageView;", "audioCacheInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;)V", "audioPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView;", "forceEnable", "", "isSetOriginMute", "()Z", "setSetOriginMute", "(Z)V", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "name", "", "onBackPress", "onClick", "", "v", "Landroid/view/View;", "onPause", "onResume", "release", "resetStyle", "bgResId", "", "textColor", "text", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "setUpVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, q
{
  public static final a.a qdD;
  private ViewGroup eyt;
  public AudioCacheInfo qaV;
  d qbI;
  private final b qdA;
  public boolean qdB;
  private boolean qdC;
  private final ImageView qdy;
  public final EditorAudioView qdz;
  
  static
  {
    AppMethodBeat.i(150790);
    qdD = new a.a((byte)0);
    AppMethodBeat.o(150790);
  }
  
  public a(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(150789);
    this.eyt = paramViewGroup;
    this.qbI = paramd;
    paramViewGroup = this.eyt.findViewById(2131828703);
    j.p(paramViewGroup, "parent.findViewById(R.id.editor_add_audio)");
    this.qdy = ((ImageView)paramViewGroup);
    paramViewGroup = this.eyt.findViewById(2131828718);
    j.p(paramViewGroup, "parent.findViewById(R.id.editor_audio_panel)");
    this.qdz = ((EditorAudioView)paramViewGroup);
    paramViewGroup = this.eyt.getContext();
    j.p(paramViewGroup, "parent.context");
    this.qdA = new b(paramViewGroup);
    this.qdC = true;
    this.qdC = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVP, true);
    new StringBuilder("forceEnable ").append(this.qdC);
    h.dUV();
    this.qdy.setImageDrawable(aj.g(this.eyt.getContext(), 2131231464, -1));
    this.qdy.setOnClickListener((View.OnClickListener)this);
    if (this.qdC)
    {
      this.qdz.setOnVisibleChangeCallback((a.f.a.b)new a.1(this));
      this.qdz.setCallback((EditorAudioView.a)new a.2(this));
      AppMethodBeat.o(150789);
      return;
    }
    this.qdy.setVisibility(8);
    AppMethodBeat.o(150789);
  }
  
  public final boolean cgq()
  {
    AppMethodBeat.i(150788);
    if (this.qdz.Pk())
    {
      this.qdz.back();
      AppMethodBeat.o(150788);
      return true;
    }
    AppMethodBeat.o(150788);
    return false;
  }
  
  public final String name()
  {
    return "plugin_music";
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150783);
    this.qdz.setShow(true);
    paramView = com.tencent.mm.plugin.recordvideo.c.b.qfu;
    com.tencent.mm.plugin.recordvideo.c.b.Ya("KEY_CLICK_MUSIC_COUNT_INT");
    paramView = com.tencent.mm.plugin.recordvideo.c.b.qfu;
    com.tencent.mm.plugin.recordvideo.c.b.Cs(6);
    AppMethodBeat.o(150783);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(150785);
    this.qdA.pauseAudio();
    AppMethodBeat.o(150785);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(150787);
    this.qdA.b(this.qaV);
    AppMethodBeat.o(150787);
  }
  
  public final void release()
  {
    AppMethodBeat.i(150786);
    this.qdA.pauseAudio();
    this.qaV = null;
    AppMethodBeat.o(150786);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(150784);
    if (this.qdC) {
      this.qdy.setVisibility(paramInt);
    }
    AppMethodBeat.o(150784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */