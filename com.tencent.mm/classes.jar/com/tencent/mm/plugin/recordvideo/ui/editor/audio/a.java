package com.tencent.mm.plugin.recordvideo.ui.editor.audio;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.RoundCornerAudioWaveView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateViewVisible", "Companion", "plugin-recordvideo_release"})
public final class a
  extends e<b>
{
  public static final a IaT;
  
  static
  {
    AppMethodBeat.i(219184);
    IaT = new a((byte)0);
    AppMethodBeat.o(219184);
  }
  
  private static void a(i parami, b paramb)
  {
    AppMethodBeat.i(219181);
    if (paramb.IaV)
    {
      parami.nx(b.e.normal_mask, 8);
      parami.nx(b.e.disable_mask, 0);
      parami.nx(b.e.select_mask, 8);
      parami.nx(b.e.audio_wave, 8);
      parami.nx(b.e.audio_check_icon, 8);
      parami.nx(b.e.music_icon, 8);
      parami.nx(b.e.finder_video_duration, 8);
      AppMethodBeat.o(219181);
      return;
    }
    if (paramb.tsm)
    {
      parami.nx(b.e.normal_mask, 8);
      parami.nx(b.e.disable_mask, 8);
      parami.nx(b.e.select_mask, 0);
      parami.nx(b.e.audio_wave, 0);
      parami.nx(b.e.music_icon, 8);
      parami.nx(b.e.audio_check_icon, 0);
      parami.nx(b.e.finder_video_duration, 8);
      paramb = (RoundCornerAudioWaveView)parami.RD(b.e.audio_wave);
      paramb.setColor(com.tencent.mm.ci.a.w(parami.getContext(), b.b.BW_BG_100));
      paramb.setShow(true);
      AppMethodBeat.o(219181);
      return;
    }
    parami.nx(b.e.normal_mask, 0);
    parami.nx(b.e.disable_mask, 8);
    parami.nx(b.e.select_mask, 8);
    parami.nx(b.e.audio_wave, 8);
    parami.nx(b.e.music_icon, 0);
    parami.nx(b.e.audio_check_icon, 8);
    parami.nx(b.e.finder_video_duration, 0);
    AppMethodBeat.o(219181);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(219149);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = paramRecyclerView.getContext();
    p.j(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = paramRecyclerView.getResources();
    p.j(paramRecyclerView, "recyclerView.context.resources");
    paramInt = paramRecyclerView.getDisplayMetrics().widthPixels;
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    parami = parami.amk;
    p.j(parami, "holder.itemView");
    parami = parami.getLayoutParams();
    parami.height = (paramInt / 3);
    paramRecyclerView.setLayoutParams(parami);
    AppMethodBeat.o(219149);
  }
  
  public final int getLayoutId()
  {
    return b.f.video_editor_audio_finder_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderConverter$Companion;", "", "()V", "PAYLOAD_SELECT", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.audio.a
 * JD-Core Version:    0.7.0.1
 */