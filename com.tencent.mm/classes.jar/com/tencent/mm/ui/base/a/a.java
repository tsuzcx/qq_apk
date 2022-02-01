package com.tencent.mm.ui.base.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T, V extends View>
  extends RecyclerView.a<b>
{
  public a JMe = null;
  public List<T> cjg = new ArrayList();
  private RecyclerView gpr;
  
  public void a(final b paramb, final int paramInt)
  {
    paramb.auu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164160);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (a.this.JMe != null)
        {
          int i = ((b)((RecyclerView)paramb.auu.getParent()).bu(paramb.auu)).lN();
          if (i < 0)
          {
            ae.e("MicroMsg.RecyclerViewAdapterBase", "[onBindViewHolder#setOnClickListener] pos=%s", new Object[] { Integer.valueOf(i) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164160);
            return;
          }
          a.this.JMe.a(i, paramAnonymousView, a.this.getItemAtPosition(i));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164160);
      }
    });
    paramb.auu.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164161);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        if (a.this.JMe != null)
        {
          boolean bool = a.this.JMe.a(paramAnonymousView, a.this.getItemAtPosition(paramInt));
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
    paramb.gpr = this.gpr;
  }
  
  public final void c(RecyclerView paramRecyclerView)
  {
    super.c(paramRecyclerView);
    this.gpr = paramRecyclerView;
  }
  
  public final void clearItems()
  {
    int i = this.cjg.size();
    this.cjg.clear();
    as(0, i);
  }
  
  public final T getItemAtPosition(int paramInt)
  {
    return this.cjg.get(paramInt);
  }
  
  public final int getItemCount()
  {
    return this.cjg.size();
  }
  
  public final void ia(List<T> paramList)
  {
    if (paramList != null)
    {
      int i = this.cjg.size();
      this.cjg.addAll(paramList);
      ar(i, paramList.size());
    }
  }
  
  protected abstract V m(ViewGroup paramViewGroup, int paramInt);
  
  public final void setItems(List<T> paramList)
  {
    if (paramList != null)
    {
      this.cjg = paramList;
      this.asY.notifyChanged();
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(int paramInt, View paramView, T paramT);
    
    public abstract boolean a(View paramView, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.a.a
 * JD-Core Version:    0.7.0.1
 */