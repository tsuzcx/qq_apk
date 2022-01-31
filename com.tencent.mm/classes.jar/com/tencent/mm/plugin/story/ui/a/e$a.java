package com.tencent.mm.plugin.story.ui.a;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/RecommendMusicAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "plugin-story_release"})
public class e$a
  extends RecyclerView.v
{
  public e$a(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(110103);
    localObject.setOnClickListener((View.OnClickListener)new e.a.1(this, localObject));
    AppMethodBeat.o(110103);
  }
  
  public void a(int paramInt, AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(110102);
    j.q(paramAudioCacheInfo, "info");
    AppMethodBeat.o(110102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.e.a
 * JD-Core Version:    0.7.0.1
 */