package com.tencent.mm.plugin.story.ui.view.gallery;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "verticalHelper", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToCenter", "", "helper", "getHorizontalHelper", "getVerticalHelper", "Companion", "plugin-story_release"})
public final class i
  extends ak
{
  public static final i.a FFS;
  private static final String TAG = "MicroMsg.PageScrollHelper";
  private aj hbL;
  private aj hbM;
  
  static
  {
    AppMethodBeat.i(120396);
    FFS = new i.a((byte)0);
    TAG = "MicroMsg.PageScrollHelper";
    AppMethodBeat.o(120396);
  }
  
  private static int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, aj paramaj)
  {
    AppMethodBeat.i(120395);
    int j;
    int k;
    if (paramLayoutManager.canScrollHorizontally())
    {
      i = paramLayoutManager.getLeftDecorationWidth(paramView) + paramLayoutManager.getRightDecorationWidth(paramView);
      j = paramaj.bo(paramView);
      k = (paramaj.bs(paramView) - i) / 2;
      if (!paramLayoutManager.getClipToPadding()) {
        break label89;
      }
    }
    label89:
    for (int i = paramaj.kH() + paramaj.kJ() / 2;; i = paramaj.getEnd() / 2)
    {
      AppMethodBeat.o(120395);
      return j + k - i;
      i = paramLayoutManager.getTopDecorationHeight(paramView) + paramLayoutManager.getBottomDecorationHeight(paramView);
      break;
    }
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120394);
    p.h(paramLayoutManager, "layoutManager");
    p.h(paramView, "targetView");
    Log.i(TAG, "LogStory: calculateDistanceToFinalSnap " + paramLayoutManager.getPosition(paramView));
    int[] arrayOfInt = new int[2];
    Object localObject1;
    if (paramLayoutManager.canScrollHorizontally())
    {
      if (this.hbM != null)
      {
        localObject1 = this.hbM;
        if (localObject1 == null) {
          break label191;
        }
        localObject1 = ((aj)localObject1).getLayoutManager();
        if (localObject1 == paramLayoutManager) {}
      }
      else
      {
        this.hbM = aj.d(paramLayoutManager);
      }
      localObject1 = this.hbM;
      if (localObject1 == null) {
        p.hyc();
      }
      arrayOfInt[0] = a(paramLayoutManager, paramView, (aj)localObject1);
      label114:
      if (!paramLayoutManager.canScrollVertically()) {
        break label204;
      }
      if (this.hbL != null)
      {
        aj localaj = this.hbL;
        localObject1 = localObject2;
        if (localaj != null) {
          localObject1 = localaj.getLayoutManager();
        }
        if (localObject1 == paramLayoutManager) {}
      }
      else
      {
        this.hbL = aj.e(paramLayoutManager);
      }
      localObject1 = this.hbL;
      if (localObject1 == null) {
        p.hyc();
      }
      arrayOfInt[1] = a(paramLayoutManager, paramView, (aj)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(120394);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.i
 * JD-Core Version:    0.7.0.1
 */