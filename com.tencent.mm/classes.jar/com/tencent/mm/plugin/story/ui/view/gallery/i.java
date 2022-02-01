package com.tencent.mm.plugin.story.ui.view.gallery;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "horizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "verticalHelper", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToCenter", "", "helper", "getHorizontalHelper", "getVerticalHelper", "Companion", "plugin-story_release"})
public final class i
  extends v
{
  public static final a LZS;
  private static final String TAG = "MicroMsg.PageScrollHelper";
  private u jMV;
  private u jMW;
  
  static
  {
    AppMethodBeat.i(120396);
    LZS = new a((byte)0);
    TAG = "MicroMsg.PageScrollHelper";
    AppMethodBeat.o(120396);
  }
  
  private static int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, u paramu)
  {
    AppMethodBeat.i(211519);
    int j;
    int k;
    if (paramLayoutManager.canScrollHorizontally())
    {
      i = paramLayoutManager.getLeftDecorationWidth(paramView) + paramLayoutManager.getRightDecorationWidth(paramView);
      j = paramu.aZ(paramView);
      k = (paramu.bd(paramView) - i) / 2;
      if (!paramLayoutManager.getClipToPadding()) {
        break label89;
      }
    }
    label89:
    for (int i = paramu.kT() + paramu.kV() / 2;; i = paramu.getEnd() / 2)
    {
      AppMethodBeat.o(211519);
      return j + k - i;
      i = paramLayoutManager.getTopDecorationHeight(paramView) + paramLayoutManager.getBottomDecorationHeight(paramView);
      break;
    }
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(211517);
    p.k(paramLayoutManager, "layoutManager");
    p.k(paramView, "targetView");
    Log.i(TAG, "LogStory: calculateDistanceToFinalSnap " + paramLayoutManager.getPosition(paramView));
    int[] arrayOfInt = new int[2];
    Object localObject1;
    if (paramLayoutManager.canScrollHorizontally())
    {
      if (this.jMW != null)
      {
        localObject1 = this.jMW;
        if (localObject1 == null) {
          break label191;
        }
        localObject1 = ((u)localObject1).getLayoutManager();
        if (localObject1 == paramLayoutManager) {}
      }
      else
      {
        this.jMW = u.d(paramLayoutManager);
      }
      localObject1 = this.jMW;
      if (localObject1 == null) {
        p.iCn();
      }
      arrayOfInt[0] = a(paramLayoutManager, paramView, (u)localObject1);
      label114:
      if (!paramLayoutManager.canScrollVertically()) {
        break label204;
      }
      if (this.jMV != null)
      {
        u localu = this.jMV;
        localObject1 = localObject2;
        if (localu != null) {
          localObject1 = localu.getLayoutManager();
        }
        if (localObject1 == paramLayoutManager) {}
      }
      else
      {
        this.jMV = u.e(paramLayoutManager);
      }
      localObject1 = this.jMV;
      if (localObject1 == null) {
        p.iCn();
      }
      arrayOfInt[1] = a(paramLayoutManager, paramView, (u)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(211517);
      return arrayOfInt;
      label191:
      localObject1 = null;
      break;
      arrayOfInt[0] = 0;
      break label114;
      label204:
      arrayOfInt[1] = 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.i
 * JD-Core Version:    0.7.0.1
 */