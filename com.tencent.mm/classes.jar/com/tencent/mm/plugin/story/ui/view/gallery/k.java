package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "verticalHelper", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToCenter", "", "helper", "getHorizontalHelper", "getVerticalHelper", "Companion", "plugin-story_release"})
public final class k
  extends ak
{
  private static final String TAG = "MicroMsg.PageScrollHelper";
  public static final k.a sTa;
  private aj sSY;
  private aj sSZ;
  
  static
  {
    AppMethodBeat.i(110762);
    sTa = new k.a((byte)0);
    TAG = "MicroMsg.PageScrollHelper";
    AppMethodBeat.o(110762);
  }
  
  private static int a(RecyclerView.i parami, View paramView, aj paramaj)
  {
    AppMethodBeat.i(110761);
    int j;
    int k;
    if (parami.ij())
    {
      i = RecyclerView.i.bF(paramView) + RecyclerView.i.bG(paramView);
      j = paramaj.bh(paramView);
      k = (paramaj.bl(paramView) - i) / 2;
      if (!parami.getClipToPadding()) {
        break label85;
      }
    }
    label85:
    for (int i = paramaj.iI() + paramaj.iK() / 2;; i = paramaj.getEnd() / 2)
    {
      AppMethodBeat.o(110761);
      return j + k - i;
      i = RecyclerView.i.bD(paramView) + RecyclerView.i.bE(paramView);
      break;
    }
  }
  
  public final int[] a(RecyclerView.i parami, View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(110760);
    j.q(parami, "layoutManager");
    j.q(paramView, "targetView");
    ab.i(TAG, "LogStory: calculateDistanceToFinalSnap " + RecyclerView.i.bv(paramView));
    int[] arrayOfInt = new int[2];
    Object localObject1;
    if (parami.ij())
    {
      if (this.sSZ != null)
      {
        localObject1 = this.sSZ;
        if (localObject1 == null) {
          break label190;
        }
        localObject1 = ((aj)localObject1).getLayoutManager();
        if (localObject1 == parami) {}
      }
      else
      {
        this.sSZ = aj.d(parami);
      }
      localObject1 = this.sSZ;
      if (localObject1 == null) {
        j.ebi();
      }
      arrayOfInt[0] = a(parami, paramView, (aj)localObject1);
      label113:
      if (!parami.ik()) {
        break label203;
      }
      if (this.sSY != null)
      {
        aj localaj = this.sSY;
        localObject1 = localObject2;
        if (localaj != null) {
          localObject1 = localaj.getLayoutManager();
        }
        if (localObject1 == parami) {}
      }
      else
      {
        this.sSY = aj.e(parami);
      }
      localObject1 = this.sSY;
      if (localObject1 == null) {
        j.ebi();
      }
      arrayOfInt[1] = a(parami, paramView, (aj)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(110760);
      return arrayOfInt;
      label190:
      localObject1 = null;
      break;
      arrayOfInt[0] = 0;
      break label113;
      label203:
      arrayOfInt[1] = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.k
 * JD-Core Version:    0.7.0.1
 */