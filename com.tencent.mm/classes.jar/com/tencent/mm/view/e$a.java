package com.tencent.mm.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "", "()V", "canStartExpose", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getExposedId", "", "ignoreFlingExposed", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e$a
{
  public long aa(RecyclerView.v paramv)
  {
    if (paramv == null)
    {
      paramv = null;
      if (paramv == null) {
        break label26;
      }
    }
    label26:
    for (int i = paramv.hashCode();; i = 0)
    {
      return i;
      paramv = paramv.caK;
      break;
    }
  }
  
  public boolean ab(RecyclerView.v paramv)
  {
    return true;
  }
  
  public abstract void b(View paramView, List<? extends RecyclerView.v> paramList);
  
  public abstract boolean dXG();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.e.a
 * JD-Core Version:    0.7.0.1
 */