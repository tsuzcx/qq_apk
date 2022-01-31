package com.tencent.mm.plugin.story.ui.sns;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "tipId", "", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;I)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "getTipId", "()I", "setTipId", "(I)V", "onBind", "", "position", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
public final class c$c$b
  extends c.c.a
{
  private final TextView gMp;
  private int sKR;
  
  public c$c$b(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    AppMethodBeat.i(110271);
    int i;
    this.sKR = i;
    paramView = paramInt.findViewById(2131821071);
    j.p(paramView, "itemView.findViewById(R.id.tip_tv)");
    this.gMp = ((TextView)paramView);
    paramInt.setOnClickListener((View.OnClickListener)1.sKS);
    AppMethodBeat.o(110271);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(110270);
    j.q(paramb, "data");
    this.gMp.setText(this.sKR);
    AppMethodBeat.o(110270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c.c.b
 * JD-Core Version:    0.7.0.1
 */