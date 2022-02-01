package com.tencent.mm.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "", "()V", "getExposedId", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "libmmui_release"})
public abstract class e$a
{
  public long af(RecyclerView.v paramv)
  {
    if (paramv != null)
    {
      paramv = paramv.amk;
      if (paramv == null) {
        break label26;
      }
    }
    label26:
    for (int i = paramv.hashCode();; i = 0)
    {
      return i;
      paramv = null;
      break;
    }
  }
  
  public abstract void b(View paramView, List<? extends RecyclerView.v> paramList);
  
  public abstract boolean dpC();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.e.a
 * JD-Core Version:    0.7.0.1
 */