package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/StoryBubbleListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bubbleRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryBubbleListView
  extends RelativeLayout
{
  private final RecyclerView Sxz;
  
  public StoryBubbleListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120088);
    AppMethodBeat.o(120088);
  }
  
  public StoryBubbleListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120087);
    View.inflate(paramContext, a.e.SgR, (ViewGroup)this);
    paramContext = findViewById(a.d.SfS);
    s.s(paramContext, "findViewById(R.id.story_msg_recycler_view)");
    this.Sxz = ((RecyclerView)paramContext);
    AppMethodBeat.o(120087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryBubbleListView
 * JD-Core Version:    0.7.0.1
 */