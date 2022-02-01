package com.tencent.mm.ui.base.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T, V extends View>
  extends RecyclerView.a<b>
{
  public a Wqm = null;
  public List<T> ctq = new ArrayList();
  private RecyclerView jLl;
  
  public void a(final b paramb, final int paramInt)
  {
    paramb.amk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164160);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (a.this.Wqm != null)
        {
          int i = ((b)((RecyclerView)paramb.amk.getParent()).bf(paramb.amk)).md();
          if (i < 0)
          {
            Log.e("MicroMsg.RecyclerViewAdapterBase", "[onBindViewHolder#setOnClickListener] pos=%s", new Object[] { Integer.valueOf(i) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164160);
            return;
          }
          a.this.Wqm.a(i, paramAnonymousView, a.this.auB(i));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164160);
      }
    });
    paramb.amk.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164161);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        if (a.this.Wqm != null)
        {
          boolean bool = a.this.Wqm.a(paramAnonymousView, a.this.auB(paramInt));
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(164161);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(164161);
        return false;
      }
    });
  }
  
  public void a(b paramb, int paramInt, List<Object> paramList)
  {
    super.a(paramb, paramInt, paramList);
    paramb.jLl = this.jLl;
  }
  
  public final void auA(int paramInt)
  {
    Object localObject = this.ctq.get(0);
    this.ctq.add(paramInt, localObject);
    cM(paramInt);
  }
  
  public final T auB(int paramInt)
  {
    return this.ctq.get(paramInt);
  }
  
  public final void clearItems()
  {
    int i = this.ctq.size();
    this.ctq.clear();
    aH(0, i);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    super.d(paramRecyclerView);
    this.jLl = paramRecyclerView;
  }
  
  public final int getItemCount()
  {
    return this.ctq.size();
  }
  
  public final void jW(List<T> paramList)
  {
    if (paramList != null)
    {
      int i = this.ctq.size();
      this.ctq.addAll(paramList);
      aG(i, paramList.size());
    }
  }
  
  protected abstract V m(ViewGroup paramViewGroup, int paramInt);
  
  public final void removeItem(int paramInt)
  {
    if ((paramInt > 0) || (paramInt < this.ctq.size()))
    {
      this.ctq.remove(paramInt);
      cN(paramInt);
    }
  }
  
  public final void setItems(List<T> paramList)
  {
    if (paramList != null)
    {
      this.ctq = paramList;
      this.alc.notifyChanged();
    }
  }
  
  public final void v(T paramT, int paramInt)
  {
    if (paramT != null)
    {
      this.ctq.add(paramInt, paramT);
      cM(paramInt);
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(int paramInt, View paramView, T paramT);
    
    public abstract boolean a(View paramView, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.a.a
 * JD-Core Version:    0.7.0.1
 */