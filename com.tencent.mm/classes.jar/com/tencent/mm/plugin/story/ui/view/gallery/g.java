package com.tencent.mm.plugin.story.ui.view.gallery;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "horizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "verticalHelper", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToCenter", "", "helper", "getHorizontalHelper", "getVerticalHelper", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends t
{
  public static final g.a SBo;
  private static final String TAG;
  private androidx.recyclerview.widget.s mlU;
  private androidx.recyclerview.widget.s mlV;
  
  static
  {
    AppMethodBeat.i(120396);
    SBo = new g.a((byte)0);
    TAG = "MicroMsg.PageScrollHelper";
    AppMethodBeat.o(120396);
  }
  
  private static int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, androidx.recyclerview.widget.s params)
  {
    AppMethodBeat.i(367711);
    int j;
    int k;
    if (paramLayoutManager.canScrollHorizontally())
    {
      i = paramLayoutManager.getLeftDecorationWidth(paramView) + paramLayoutManager.getRightDecorationWidth(paramView);
      j = params.bs(paramView);
      k = (params.bw(paramView) - i) / 2;
      if (!paramLayoutManager.getClipToPadding()) {
        break label89;
      }
    }
    label89:
    for (int i = params.JE() + params.JG() / 2;; i = params.getEnd() / 2)
    {
      AppMethodBeat.o(367711);
      return j + k - i;
      i = paramLayoutManager.getTopDecorationHeight(paramView) + paramLayoutManager.getBottomDecorationHeight(paramView);
      break;
    }
  }
  
  public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(367713);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    kotlin.g.b.s.u(paramView, "targetView");
    Log.i(TAG, kotlin.g.b.s.X("LogStory: calculateDistanceToFinalSnap ", Integer.valueOf(paramLayoutManager.getPosition(paramView))));
    int[] arrayOfInt = new int[2];
    Object localObject1;
    if (paramLayoutManager.canScrollHorizontally())
    {
      if (this.mlV != null)
      {
        localObject1 = this.mlV;
        if (localObject1 != null) {
          break label167;
        }
        localObject1 = null;
        if (localObject1 == paramLayoutManager) {}
      }
      else
      {
        this.mlV = androidx.recyclerview.widget.s.d(paramLayoutManager);
      }
      localObject1 = this.mlV;
      kotlin.g.b.s.checkNotNull(localObject1);
      arrayOfInt[0] = a(paramLayoutManager, paramView, (androidx.recyclerview.widget.s)localObject1);
      label101:
      if (!paramLayoutManager.canScrollVertically()) {
        break label191;
      }
      if (this.mlU != null)
      {
        localObject1 = this.mlU;
        if (localObject1 != null) {
          break label183;
        }
        localObject1 = localObject2;
        label127:
        if (localObject1 == paramLayoutManager) {}
      }
      else
      {
        this.mlU = androidx.recyclerview.widget.s.e(paramLayoutManager);
      }
      localObject1 = this.mlU;
      kotlin.g.b.s.checkNotNull(localObject1);
      arrayOfInt[1] = a(paramLayoutManager, paramView, (androidx.recyclerview.widget.s)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(367713);
      return arrayOfInt;
      label167:
      localObject1 = ((androidx.recyclerview.widget.s)localObject1).getLayoutManager();
      break;
      arrayOfInt[0] = 0;
      break label101;
      label183:
      localObject1 = ((androidx.recyclerview.widget.s)localObject1).getLayoutManager();
      break label127;
      label191:
      arrayOfInt[1] = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.g
 * JD-Core Version:    0.7.0.1
 */