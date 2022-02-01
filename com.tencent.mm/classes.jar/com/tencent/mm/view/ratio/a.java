package com.tencent.mm.view.ratio;

import android.view.View;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/ratio/RatioLayoutAdapter;", "T", "", "()V", "layout", "Lcom/tencent/mm/view/ratio/RatioLayout;", "getLayout", "()Lcom/tencent/mm/view/ratio/RatioLayout;", "setLayout", "(Lcom/tencent/mm/view/ratio/RatioLayout;)V", "createItemView", "Landroid/view/View;", "pos", "", "createItemView$libmmui_release", "getItemCount", "getItemData", "(I)Ljava/lang/Object;", "getItemView", "data", "(ILjava/lang/Object;)Landroid/view/View;", "getLayoutInfo", "Lcom/tencent/mm/view/ratio/RatioLayout$LayoutInfo;", "notifyDataChanged", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T>
{
  public RatioLayout agNJ;
  
  public abstract View J(int paramInt, T paramT);
  
  public abstract RatioLayout.a PG(int paramInt);
  
  public abstract T PH(int paramInt);
  
  public abstract int getItemCount();
  
  public final RatioLayout jNh()
  {
    RatioLayout localRatioLayout = this.agNJ;
    if (localRatioLayout != null) {
      return localRatioLayout;
    }
    s.bIx("layout");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.ratio.a
 * JD-Core Version:    0.7.0.1
 */