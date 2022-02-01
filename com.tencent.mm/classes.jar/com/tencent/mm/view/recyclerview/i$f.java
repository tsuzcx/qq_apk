package com.tencent.mm.view.recyclerview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addFooterView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", "other", "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$f
  extends i.b
{
  i$f(View paramView, int paramInt) {}
  
  public final long bZA()
  {
    AppMethodBeat.i(164700);
    long l = this.agOh.hashCode();
    AppMethodBeat.o(164700);
    return l;
  }
  
  public final int bZB()
  {
    return this.eKn;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(164701);
    if (((paramObject instanceof i.b)) && (bZA() == ((i.b)paramObject).bZA()))
    {
      AppMethodBeat.o(164701);
      return true;
    }
    AppMethodBeat.o(164701);
    return false;
  }
  
  public final int getLayoutId()
  {
    return 0;
  }
  
  public final View getView()
  {
    return this.agOh;
  }
  
  public final boolean jNm()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.i.f
 * JD-Core Version:    0.7.0.1
 */