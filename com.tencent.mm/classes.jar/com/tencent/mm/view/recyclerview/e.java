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
  private final SparseArray<View> JCn;
  private final LinkedHashSet<Integer> JCo;
  private final LinkedHashSet<Integer> JCp;
  public Object JCq;
  private final Context context;
  public RecyclerView fTr;
  private RecyclerView.a fUp;
  private Object tag;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(164329);
    this.fTr = null;
    this.JCn = new SparseArray();
    this.JCo = new LinkedHashSet();
    this.JCp = new LinkedHashSet();
    this.context = paramView.getContext();
    AppMethodBeat.o(164329);
  }
  
  public final <T extends View> T adJ(int paramInt)
  {
    AppMethodBeat.i(164335);
    View localView2 = (View)this.JCn.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.asD.findViewById(paramInt);
      this.JCn.put(paramInt, localView1);
    }
    AppMethodBeat.o(164335);
    return localView1;
  }
  
  public final e b(RecyclerView.a parama)
  {
    this.fUp = parama;
    return this;
  }
  
  public final e d(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(164331);
    ((TextView)adJ(paramInt)).setText(paramCharSequence);
    AppMethodBeat.o(164331);
    return this;
  }
  
  public final void ej(Object paramObject)
  {
    this.JCq = paramObject;
  }
  
  public final <T> T fzs()
  {
    return this.JCq;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164330);
    if ((this.fTr == null) && ((this.asD.getParent() instanceof RecyclerView)))
    {
      this.fTr = ((RecyclerView)this.asD.getParent());
      localRecyclerView = this.fTr;
      AppMethodBeat.o(164330);
      return localRecyclerView;
    }
    RecyclerView localRecyclerView = this.fTr;
    AppMethodBeat.o(164330);
    return localRecyclerView;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  public final e kj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197248);
    ((TextView)adJ(paramInt1)).setText(paramInt2);
    AppMethodBeat.o(197248);
    return this;
  }
  
  public final e kk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197249);
    ((TextView)adJ(paramInt1)).setTextColor(paramInt2);
    AppMethodBeat.o(197249);
    return this;
  }
  
  public final e kl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164334);
    adJ(paramInt1).setVisibility(paramInt2);
    AppMethodBeat.o(164334);
    return this;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.fTr = paramRecyclerView;
  }
  
  public final void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.e
 * JD-Core Version:    0.7.0.1
 */