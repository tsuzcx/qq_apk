package com.tencent.mm.plugin.story.ui.a;

import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "opTv", "Landroid/widget/TextView;", "getOpTv", "()Landroid/widget/TextView;", "findMaskView", "onBind", "", "position", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindOpTv", "plugin-story_release"})
public final class f$d
  extends f.a
{
  private final TextView rFQ;
  
  public f$d(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(110124);
    paramView = localObject.findViewById(2131828321);
    a.f.b.j.p(paramView, "itemView.findViewById(R.…story_comment_item_op_tv)");
    this.rFQ = ((TextView)paramView);
    AppMethodBeat.o(110124);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.story.model.b.a parama)
  {
    AppMethodBeat.i(138859);
    a.f.b.j.q(parama, "comment");
    super.a(paramInt, parama);
    if (parama.sxz) {
      b.e(this.sHE);
    }
    Object localObject1;
    Object localObject2;
    if (!parama.sxz)
    {
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      boolean bool = bo.isEqual(j.b.coK(), parama.czp);
      this.rFQ.setVisibility(0);
      if (bool)
      {
        this.rFQ.setOnClickListener((View.OnClickListener)new f.d.b(this, parama));
        localObject1 = this.rFQ;
        localObject2 = this.aku;
        a.f.b.j.p(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        a.f.b.j.p(localObject2, "itemView.context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131304120));
        this.rFQ.setTextColor(-1);
        b.e(this.rFQ);
      }
    }
    for (;;)
    {
      this.aku.setOnClickListener((View.OnClickListener)new f.d.a(this, parama));
      AppMethodBeat.o(138859);
      return;
      if ((com.tencent.mm.plugin.story.c.a.a.srz.czE()) && ((f.a(this.sIC)) || (f.b(this.sIC))))
      {
        this.rFQ.setOnClickListener((View.OnClickListener)new f.d.c(this, parama));
        localObject1 = this.rFQ;
        localObject2 = this.aku;
        a.f.b.j.p(localObject2, "itemView");
        localObject2 = ((View)localObject2).getContext();
        a.f.b.j.p(localObject2, "itemView.context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131304121));
        this.rFQ.setTextColor(-1);
        b.e(this.rFQ);
      }
      else
      {
        this.rFQ.setVisibility(8);
      }
    }
  }
  
  public final View cFo()
  {
    AppMethodBeat.i(138858);
    View localView = this.aku.findViewById(2131828316);
    a.f.b.j.p(localView, "itemView.findViewById(R.…mment_content_background)");
    AppMethodBeat.o(138858);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.f.d
 * JD-Core Version:    0.7.0.1
 */