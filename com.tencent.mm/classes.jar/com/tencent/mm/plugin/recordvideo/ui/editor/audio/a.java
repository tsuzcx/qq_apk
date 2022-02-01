package com.tencent.mm.plugin.recordvideo.ui.editor.audio;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateViewVisible", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f<b>
{
  public static final a.a NXt;
  
  static
  {
    AppMethodBeat.i(280125);
    NXt = new a.a((byte)0);
    AppMethodBeat.o(280125);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(280135);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramInt = paramRecyclerView.getContext().getResources().getDisplayMetrics().widthPixels;
    paramRecyclerView = paramj.caK;
    paramj = paramj.caK.getLayoutParams();
    paramj.height = (paramInt / 3);
    ah localah = ah.aiuX;
    paramRecyclerView.setLayoutParams(paramj);
    AppMethodBeat.o(280135);
  }
  
  public final int getLayoutId()
  {
    return b.f.video_editor_audio_finder_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.audio.a
 * JD-Core Version:    0.7.0.1
 */