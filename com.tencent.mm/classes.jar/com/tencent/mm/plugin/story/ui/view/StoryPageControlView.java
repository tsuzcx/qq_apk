package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPageControlView;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView;", "Lcom/tencent/mm/ui/base/MMPageControlView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPageIndicatorStatusInterface", "Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView$IPageIndicatorStatusInterface;", "generatePageControl", "", "currentIndex", "", "setPageIndicatorStatusInterface", "pageControlInterface", "IPageIndicatorStatusInterface", "plugin-story_release"})
public final class StoryPageControlView
  extends MMPageControlView
{
  private StoryPageControlView.a BbJ;
  
  public StoryPageControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120285);
    AppMethodBeat.o(120285);
  }
  
  public final void Qv(int paramInt)
  {
    AppMethodBeat.i(120284);
    super.Qv(paramInt);
    int j = this.count;
    int i = 0;
    if (i < j)
    {
      this.dsD = ((ImageView)this.map.get(Integer.valueOf(i)));
      ImageView localImageView = this.dsD;
      p.g(localImageView, "imageView");
      if (paramInt == i) {}
      for (boolean bool = true;; bool = false)
      {
        localImageView.setSelected(bool);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(120284);
  }
  
  public final void setPageIndicatorStatusInterface(StoryPageControlView.a parama)
  {
    this.BbJ = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryPageControlView
 * JD-Core Version:    0.7.0.1
 */