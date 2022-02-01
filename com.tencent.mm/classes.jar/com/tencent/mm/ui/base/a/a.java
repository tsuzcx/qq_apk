package com.tencent.mm.ui.base.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T, V extends View>
  extends RecyclerView.a<b>
{
  public a GdK = null;
  public List<T> cbP = new ArrayList();
  private RecyclerView fPw;
  
  public void a(final b paramb, final int paramInt)
  {
    paramb.arI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164160);
        if (a.this.GdK != null)
        {
          int i = ((b)((RecyclerView)paramb.arI.getParent()).bu(paramb.arI)).ln();
          if (i < 0)
          {
            ad.e("MicroMsg.RecyclerViewAdapterBase", "[onBindViewHolder#setOnClickListener] pos=%s", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(164160);
            return;
          }
          a.this.GdK.a(i, paramAnonymousView, a.this.getItemAtPosition(i));
        }
        AppMethodBeat.o(164160);
      }
    });
    paramb.arI.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164161);
        if (a.this.GdK != null)
        {
          boolean bool = a.this.GdK.a(paramAnonymousView, a.this.getItemAtPosition(paramInt));
          AppMethodBeat.o(164161);
          return bool;
        }
        AppMethodBeat.o(164161);
        return false;
      }
    });
  }
  
  public void a(b paramb, int paramInt, List<Object> paramList)
  {
    super.a(paramb, paramInt, paramList);
    paramb.fPw = this.fPw;
  }
  
  public final void c(RecyclerView paramRecyclerView)
  {
    super.c(paramRecyclerView);
    this.fPw = paramRecyclerView;
  }
  
  public final void clearItems()
  {
    int i = this.cbP.size();
    this.cbP.clear();
    ar(0, i);
  }
  
  public final T getItemAtPosition(int paramInt)
  {
    return this.cbP.get(paramInt);
  }
  
  public final int getItemCount()
  {
    return this.cbP.size();
  }
  
  public final void hr(List<T> paramList)
  {
    if (paramList != null)
    {
      int i = this.cbP.size();
      this.cbP.addAll(paramList);
      aq(i, paramList.size());
    }
  }
  
  protected abstract V l(ViewGroup paramViewGroup, int paramInt);
  
  public final void setItems(List<T> paramList)
  {
    if (paramList != null)
    {
      this.cbP = paramList;
      this.aql.notifyChanged();
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