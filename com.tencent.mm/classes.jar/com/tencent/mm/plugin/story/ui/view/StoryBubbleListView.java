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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/StoryBubbleListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bubbleRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-story_release"})
public final class StoryBubbleListView
  extends RelativeLayout
{
  private final RecyclerView LVG;
  
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
    View.inflate(paramContext, a.e.LDg, (ViewGroup)this);
    paramContext = findViewById(a.d.LCh);
    p.j(paramContext, "findViewById(R.id.story_msg_recycler_view)");
    this.LVG = ((RecyclerView)paramContext);
    AppMethodBeat.o(120087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryBubbleListView
 * JD-Core Version:    0.7.0.1
 */