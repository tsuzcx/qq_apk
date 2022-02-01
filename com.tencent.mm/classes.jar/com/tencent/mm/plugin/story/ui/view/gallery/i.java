package com.tencent.mm.plugin.story.ui.view.gallery;

import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "verticalHelper", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToCenter", "", "helper", "getHorizontalHelper", "getVerticalHelper", "Companion", "plugin-story_release"})
public final class i
  extends ak
{
  public static final i.a BdJ;
  private static final String TAG = "MicroMsg.PageScrollHelper";
  private aj BdH;
  private aj BdI;
  
  static
  {
    AppMethodBeat.i(120396);
    BdJ = new i.a((byte)0);
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
    ad.i(TAG, "LogStory: calculateDistanceToFinalSnap " + RecyclerView.i.bB(paramView));
    int[] arrayOfInt = new int[2];
    Object localObject1;
    if (parami.kc())
    {
      if (this.BdI != null)
      {
        localObject1 = this.BdI;
        if (localObject1 == null) {
          break label190;
        }
        localObject1 = ((aj)localObject1).getLayoutManager();
        if (localObject1 == parami) {}
      }
      else
      {
        this.BdI = aj.d(parami);
      }
      localObject1 = this.BdI;
      if (localObject1 == null) {
        p.gfZ();
      }
      arrayOfInt[0] = a(parami, paramView, (aj)localObject1);
      label113:
      if (!parami.kd()) {
        break label203;
      }
      if (this.BdH != null)
      {
        aj localaj = this.BdH;
        localObject1 = localObject2;
        if (localaj != null) {
          localObject1 = localaj.getLayoutManager();
        }
        if (localObject1 == parami) {}
      }
      else
      {
        this.BdH = aj.e(parami);
      }
      localObject1 = this.BdH;
      if (localObject1 == null) {
        p.gfZ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.i
 * JD-Core Version:    0.7.0.1
 */