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
  private final LinkedHashSet<Integer> LSh;
  private final LinkedHashSet<Integer> LSi;
  public Object LSj;
  private final Context context;
  public RecyclerView gpr;
  private RecyclerView.a gqn;
  private Object tag;
  private final SparseArray<View> tff;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(164329);
    this.gpr = null;
    this.tff = new SparseArray();
    this.LSh = new LinkedHashSet();
    this.LSi = new LinkedHashSet();
    this.context = paramView.getContext();
    AppMethodBeat.o(164329);
  }
  
  public final <T extends View> T GD(int paramInt)
  {
    AppMethodBeat.i(164335);
    View localView2 = (View)this.tff.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.auu.findViewById(paramInt);
      this.tff.put(paramInt, localView1);
    }
    AppMethodBeat.o(164335);
    return localView1;
  }
  
  public final e agS(int paramInt)
  {
    AppMethodBeat.i(164332);
    ((TextView)GD(2131298516)).setText(paramInt);
    AppMethodBeat.o(164332);
    return this;
  }
  
  public final e b(RecyclerView.a parama)
  {
    this.gqn = parama;
    return this;
  }
  
  public final e e(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(164331);
    ((TextView)GD(paramInt)).setText(paramCharSequence);
    AppMethodBeat.o(164331);
    return this;
  }
  
  public final void ep(Object paramObject)
  {
    this.LSj = paramObject;
  }
  
  public final <T> T fUY()
  {
    return this.LSj;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164330);
    if ((this.gpr == null) && ((this.auu.getParent() instanceof RecyclerView)))
    {
      this.gpr = ((RecyclerView)this.auu.getParent());
      localRecyclerView = this.gpr;
      AppMethodBeat.o(164330);
      return localRecyclerView;
    }
    RecyclerView localRecyclerView = this.gpr;
    AppMethodBeat.o(164330);
    return localRecyclerView;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  public final e kG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193823);
    ((TextView)GD(paramInt1)).setTextColor(paramInt2);
    AppMethodBeat.o(193823);
    return this;
  }
  
  public final e kH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164334);
    GD(paramInt1).setVisibility(paramInt2);
    AppMethodBeat.o(164334);
    return this;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.gpr = paramRecyclerView;
  }
  
  public final void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.e
 * JD-Core Version:    0.7.0.1
 */