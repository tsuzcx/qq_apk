package com.tencent.mm.ui.base.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T, V extends View>
  extends RecyclerView.a<b>
{
  public a OXb = null;
  public List<T> cvc = new ArrayList();
  private RecyclerView hak;
  
  public void a(final b paramb, final int paramInt)
  {
    paramb.aus.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164160);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (a.this.OXb != null)
        {
          int i = ((b)((RecyclerView)paramb.aus.getParent()).bu(paramb.aus)).lR();
          if (i < 0)
          {
            Log.e("MicroMsg.RecyclerViewAdapterBase", "[onBindViewHolder#setOnClickListener] pos=%s", new Object[] { Integer.valueOf(i) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164160);
            return;
          }
          a.this.OXb.a(i, paramAnonymousView, a.this.getItemAtPosition(i));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164160);
      }
    });
    paramb.aus.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164161);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        if (a.this.OXb != null)
        {
          boolean bool = a.this.OXb.a(paramAnonymousView, a.this.getItemAtPosition(paramInt));
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
    paramb.hak = this.hak;
  }
  
  public final void alC(int paramInt)
  {
    Object localObject = this.cvc.get(0);
    this.cvc.add(paramInt, localObject);
    cj(paramInt);
  }
  
  public final void b(RecyclerView paramRecyclerView)
  {
    super.b(paramRecyclerView);
    this.hak = paramRecyclerView;
  }
  
  public final void clearItems()
  {
    int i = this.cvc.size();
    this.cvc.clear();
    at(0, i);
  }
  
  public final T getItemAtPosition(int paramInt)
  {
    return this.cvc.get(paramInt);
  }
  
  public final int getItemCount()
  {
    return this.cvc.size();
  }
  
  public final void je(List<T> paramList)
  {
    if (paramList != null)
    {
      int i = this.cvc.size();
      this.cvc.addAll(paramList);
      as(i, paramList.size());
    }
  }
  
  protected abstract V l(ViewGroup paramViewGroup, int paramInt);
  
  public final void p(T paramT, int paramInt)
  {
    if (paramT != null)
    {
      this.cvc.add(paramInt, paramT);
      cj(paramInt);
    }
  }
  
  public final void removeItem(int paramInt)
  {
    if ((paramInt > 0) || (paramInt < this.cvc.size()))
    {
      this.cvc.remove(paramInt);
      ck(paramInt);
    }
  }
  
  public final void setItems(List<T> paramList)
  {
    if (paramList != null)
    {
      this.cvc = paramList;
      this.atj.notifyChanged();
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(int paramInt, View paramView, T paramT);
    
    public abstract boolean a(View paramView, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.a.a
 * JD-Core Version:    0.7.0.1
 */