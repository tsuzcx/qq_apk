package com.tencent.mm.plugin.story.ui.view.gallery;

import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "verticalHelper", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToCenter", "", "helper", "getHorizontalHelper", "getVerticalHelper", "Companion", "plugin-story_release"})
public final class i
  extends ak
{
  public static final i.a Bvh;
  private static final String TAG = "MicroMsg.PageScrollHelper";
  private aj Bvf;
  private aj Bvg;
  
  static
  {
    AppMethodBeat.i(120396);
    Bvh = new i.a((byte)0);
    TAG = "MicroMsg.PageScrollHelper";
    AppMethodBeat.o(120396);
  }
  
  private static int a(RecyclerView.i parami, View paramView, aj paramaj)
  {
    AppMethodBeat.i(120395);
    int j;
    int k;
    if (parami.kc())
    {
      i = RecyclerView.i.bM(paramView) + RecyclerView.i.bN(paramView);
      j = paramaj.bn(paramView);
      k = (paramaj.br(paramView) - i) / 2;
      if (!parami.getClipToPadding()) {
        break label85;
      }
    }
    label85:
    for (int i = paramaj.kB() + paramaj.kD() / 2;; i = paramaj.getEnd() / 2)
    {
      AppMethodBeat.o(120395);
      return j + k - i;
      i = RecyclerView.i.bK(paramView) + RecyclerView.i.bL(paramView);
      break;
    }
  }
  
  public final int[] a(RecyclerView.i parami, View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120394);
    p.h(parami, "layoutManager");
    p.h(paramView, "targetView");
    ae.i(TAG, "LogStory: calculateDistanceToFinalSnap " + RecyclerView.i.bB(paramView));
    int[] arrayOfInt = new int[2];
    Object localObject1;
    if (parami.kc())
    {
      if (this.Bvg != null)
      {
        localObject1 = this.Bvg;
        if (localObject1 == null) {
          break label190;
        }
        localObject1 = ((aj)localObject1).getLayoutManager();
        if (localObject1 == parami) {}
      }
      else
      {
        this.Bvg = aj.d(parami);
      }
      localObject1 = this.Bvg;
      if (localObject1 == null) {
        p.gkB();
      }
      arrayOfInt[0] = a(parami, paramView, (aj)localObject1);
      label113:
      if (!parami.kd()) {
        break label203;
      }
      if (this.Bvf != null)
      {
        aj localaj = this.Bvf;
        localObject1 = localObject2;
        if (localaj != null) {
          localObject1 = localaj.getLayoutManager();
        }
        if (localObject1 == parami) {}
      }
      else
      {
        this.Bvf = aj.e(parami);
      }
      localObject1 = this.Bvf;
      if (localObject1 == null) {
        p.gkB();
      }
      arrayOfInt[1] = a(parami, paramView, (aj)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(120394);
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
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.i
 * JD-Core Version:    0.7.0.1
 */