package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView;", "Lcom/tencent/mm/ui/base/MMPageControlView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPageIndicatorStatusInterface", "Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView$IPageIndicatorStatusInterface;", "generatePageControl", "", "currentIndex", "", "setPageIndicatorStatusInterface", "pageControlInterface", "IPageIndicatorStatusInterface", "plugin-story_release"})
public final class StoryPageControlView
  extends MMPageControlView
{
  private StoryPageControlView.a sNj;
  
  public StoryPageControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(110450);
    AppMethodBeat.o(110450);
  }
  
  public final void Eg(int paramInt)
  {
    AppMethodBeat.i(110449);
    super.Eg(paramInt);
    int j = this.count;
    int i = 0;
    if (i < j)
    {
      this.cuM = ((ImageView)this.map.get(Integer.valueOf(i)));
      ImageView localImageView = this.cuM;
      j.p(localImageView, "imageView");
      if (paramInt == i) {}
      for (boolean bool = true;; bool = false)
      {
        localImageView.setSelected(bool);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(110449);
  }
  
  public final void setPageIndicatorStatusInterface(StoryPageControlView.a parama)
  {
    this.sNj = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryPageControlView
 * JD-Core Version:    0.7.0.1
 */