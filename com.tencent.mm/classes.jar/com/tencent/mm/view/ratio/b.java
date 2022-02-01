package com.tencent.mm.view.ratio;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/ratio/RatioLayoutManager;", "", "()V", "TAG", "", "layout", "Lcom/tencent/mm/view/ratio/RatioLayout;", "getLayout$libmmui_release", "()Lcom/tencent/mm/view/ratio/RatioLayout;", "setLayout$libmmui_release", "(Lcom/tencent/mm/view/ratio/RatioLayout;)V", "requestRefresh", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final String TAG = "MicroMsg.MultiAreaLayoutManager";
  public RatioLayout agNJ;
  
  private RatioLayout jNi()
  {
    AppMethodBeat.i(234837);
    RatioLayout localRatioLayout = this.agNJ;
    if (localRatioLayout != null)
    {
      AppMethodBeat.o(234837);
      return localRatioLayout;
    }
    s.bIx("layout");
    AppMethodBeat.o(234837);
    return null;
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(234847);
    Object localObject1 = jNi().getAdapter();
    int k = ((a)localObject1).getItemCount();
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject3 = ((a)localObject1).PG(i);
      ((ArrayList)localObject2).add(((a)localObject1).J(i, ((a)localObject1).PH(i)));
      localArrayList.add(localObject3);
      Log.i(this.TAG, "addView index:" + i + " layoutInfo:" + localObject3);
      if (j >= k)
      {
        jNi().removeAllViews();
        if ((((ArrayList)localObject2).size() > 0) && (((ArrayList)localObject2).size() == localArrayList.size()))
        {
          localObject1 = ((Iterable)localObject2).iterator();
          i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              p.kkW();
            }
            localObject2 = (View)localObject2;
            localObject3 = jNi();
            RatioLayout.LayoutParams localLayoutParams = new RatioLayout.LayoutParams(-1);
            localLayoutParams.agNI = ((RatioLayout.a)localArrayList.get(i));
            ah localah = ah.aiuX;
            ((RatioLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localLayoutParams);
            i += 1;
          }
          AppMethodBeat.o(234847);
          return;
        }
        Log.i(this.TAG, "viewList size:" + ((ArrayList)localObject2).size() + ", layoutInfoList size:" + localArrayList.size());
        AppMethodBeat.o(234847);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.ratio.b
 * JD-Core Version:    0.7.0.1
 */