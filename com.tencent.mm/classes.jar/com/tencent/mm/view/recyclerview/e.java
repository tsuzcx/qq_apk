package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashSet;

public class e
  extends RecyclerView.w
{
  private final LinkedHashSet<Integer> Lvu;
  private final LinkedHashSet<Integer> Lvv;
  public Object Lvw;
  private final Context context;
  public RecyclerView gmV;
  private RecyclerView.a gnR;
  private final SparseArray<View> sTT;
  private Object tag;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(164329);
    this.gmV = null;
    this.sTT = new SparseArray();
    this.Lvu = new LinkedHashSet();
    this.Lvv = new LinkedHashSet();
    this.context = paramView.getContext();
    AppMethodBeat.o(164329);
  }
  
  public final <T extends View> T Gd(int paramInt)
  {
    AppMethodBeat.i(164335);
    View localView2 = (View)this.sTT.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.auu.findViewById(paramInt);
      this.sTT.put(paramInt, localView1);
    }
    AppMethodBeat.o(164335);
    return localView1;
  }
  
  public final e agj(int paramInt)
  {
    AppMethodBeat.i(164332);
    ((TextView)Gd(2131298516)).setText(paramInt);
    AppMethodBeat.o(164332);
    return this;
  }
  
  public final e b(RecyclerView.a parama)
  {
    this.gnR = parama;
    return this;
  }
  
  public final e d(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(164331);
    ((TextView)Gd(paramInt)).setText(paramCharSequence);
    AppMethodBeat.o(164331);
    return this;
  }
  
  public final void em(Object paramObject)
  {
    this.Lvw = paramObject;
  }
  
  public final <T> T fQC()
  {
    return this.Lvw;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164330);
    if ((this.gmV == null) && ((this.auu.getParent() instanceof RecyclerView)))
    {
      this.gmV = ((RecyclerView)this.auu.getParent());
      localRecyclerView = this.gmV;
      AppMethodBeat.o(164330);
      return localRecyclerView;
    }
    RecyclerView localRecyclerView = this.gmV;
    AppMethodBeat.o(164330);
    return localRecyclerView;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  public final e kA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164334);
    Gd(paramInt1).setVisibility(paramInt2);
    AppMethodBeat.o(164334);
    return this;
  }
  
  public final e kz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186565);
    ((TextView)Gd(paramInt1)).setTextColor(paramInt2);
    AppMethodBeat.o(186565);
    return this;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.gmV = paramRecyclerView;
  }
  
  public final void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.e
 * JD-Core Version:    0.7.0.1
 */