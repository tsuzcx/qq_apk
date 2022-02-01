package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView;", "Lcom/tencent/mm/ui/base/MMPageControlView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPageIndicatorStatusInterface", "Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView$IPageIndicatorStatusInterface;", "generatePageControl", "", "currentIndex", "", "setPageIndicatorStatusInterface", "pageControlInterface", "IPageIndicatorStatusInterface", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryPageControlView
  extends MMPageControlView
{
  private StoryPageControlView.a SzB;
  
  public StoryPageControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120285);
    AppMethodBeat.o(120285);
  }
  
  public final void ali(int paramInt)
  {
    AppMethodBeat.i(120284);
    super.ali(paramInt);
    int k = this.count;
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      this.hIz = ((ImageView)this.map.get(Integer.valueOf(i)));
      ImageView localImageView = this.hIz;
      if (paramInt == i) {}
      for (boolean bool = true;; bool = false)
      {
        localImageView.setSelected(bool);
        if (j < k) {
          break;
        }
        AppMethodBeat.o(120284);
        return;
      }
    }
  }
  
  public final void setPageIndicatorStatusInterface(StoryPageControlView.a parama)
  {
    this.SzB = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryPageControlView
 * JD-Core Version:    0.7.0.1
 */