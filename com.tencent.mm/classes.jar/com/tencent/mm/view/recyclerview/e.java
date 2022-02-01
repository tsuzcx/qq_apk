package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashSet;

public class e
  extends RecyclerView.v
{
  public Object IbA;
  private final SparseArray<View> Ibx;
  private final LinkedHashSet<Integer> Iby;
  private final LinkedHashSet<Integer> Ibz;
  private final Context context;
  public RecyclerView fPw;
  private RecyclerView.a fQu;
  private Object tag;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(164329);
    this.fPw = null;
    this.Ibx = new SparseArray();
    this.Iby = new LinkedHashSet();
    this.Ibz = new LinkedHashSet();
    this.context = paramView.getContext();
    AppMethodBeat.o(164329);
  }
  
  public final <T extends View> T abq(int paramInt)
  {
    AppMethodBeat.i(164335);
    View localView2 = (View)this.Ibx.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.arI.findViewById(paramInt);
      this.Ibx.put(paramInt, localView1);
    }
    AppMethodBeat.o(164335);
    return localView1;
  }
  
  public final e b(RecyclerView.a parama)
  {
    this.fQu = parama;
    return this;
  }
  
  public final e d(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(164331);
    ((TextView)abq(paramInt)).setText(paramCharSequence);
    AppMethodBeat.o(164331);
    return this;
  }
  
  public final void ei(Object paramObject)
  {
    this.IbA = paramObject;
  }
  
  public final <T> T fjf()
  {
    return this.IbA;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164330);
    if ((this.fPw == null) && ((this.arI.getParent() instanceof RecyclerView)))
    {
      this.fPw = ((RecyclerView)this.arI.getParent());
      localRecyclerView = this.fPw;
      AppMethodBeat.o(164330);
      return localRecyclerView;
    }
    RecyclerView localRecyclerView = this.fPw;
    AppMethodBeat.o(164330);
    return localRecyclerView;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  public final e jX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191030);
    ((TextView)abq(paramInt1)).setTextColor(paramInt2);
    AppMethodBeat.o(191030);
    return this;
  }
  
  public final e jY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164334);
    abq(paramInt1).setVisibility(paramInt2);
    AppMethodBeat.o(164334);
    return this;
  }
  
  public final e ll(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204023);
    ((TextView)abq(paramInt1)).setText(paramInt2);
    AppMethodBeat.o(204023);
    return this;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.fPw = paramRecyclerView;
  }
  
  public final void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.e
 * JD-Core Version:    0.7.0.1
 */