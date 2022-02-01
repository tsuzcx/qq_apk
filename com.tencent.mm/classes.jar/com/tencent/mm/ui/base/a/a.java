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
  public a adXy = null;
  public List<T> ell = new ArrayList();
  private RecyclerView mkw;
  
  public void a(final b paramb, final int paramInt)
  {
    paramb.caK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164160);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (a.this.adXy != null)
        {
          int i = ((b)((RecyclerView)paramb.caK.getParent()).by(paramb.caK)).KJ();
          if (i < 0)
          {
            Log.e("MicroMsg.RecyclerViewAdapterBase", "[onBindViewHolder#setOnClickListener] pos=%s", new Object[] { Integer.valueOf(i) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164160);
            return;
          }
          a.this.adXy.a(i, paramAnonymousView, a.this.aBc(i));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164160);
      }
    });
    paramb.caK.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164161);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if (a.this.adXy != null)
        {
          boolean bool = a.this.adXy.a(paramAnonymousView, a.this.aBc(paramInt));
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
    paramb.mkw = this.mkw;
  }
  
  public final void aBb(int paramInt)
  {
    Object localObject = this.ell.get(0);
    this.ell.add(paramInt, localObject);
    fW(paramInt);
  }
  
  public final T aBc(int paramInt)
  {
    return this.ell.get(paramInt);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    super.d(paramRecyclerView);
    this.mkw = paramRecyclerView;
  }
  
  public final int getItemCount()
  {
    return this.ell.size();
  }
  
  protected abstract V m(ViewGroup paramViewGroup, int paramInt);
  
  public final void nl(List<T> paramList)
  {
    if (paramList != null)
    {
      int i = this.ell.size();
      this.ell.addAll(paramList);
      bA(i, paramList.size());
    }
  }
  
  public final void removeItem(int paramInt)
  {
    if ((paramInt > 0) || (paramInt < this.ell.size()))
    {
      this.ell.remove(paramInt);
      fX(paramInt);
    }
  }
  
  public final void setItems(List<T> paramList)
  {
    if (paramList != null)
    {
      this.ell = paramList;
      this.bZE.notifyChanged();
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